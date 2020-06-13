package com.slrtce.sendinvitation;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DbHelper extends SQLiteOpenHelper {

    public static final String db="invitation.db";
    public static final String table_name="user_info";
    public static final SQLiteDatabase.CursorFactory factory=null;
    public static final int version=1;
    public DbHelper(Context context) {
        super(context,db, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(
                "create table user_info " +
                        "(id integer primary key, name text,email text,gender text, dob text,contact text,password text)"
        );
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS user_info");
        onCreate(sqLiteDatabase);

    }

    public boolean insertdetail (String name, String email, String gender, String dob,String contact,String password) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put("name", name);
        contentValues.put("email", email);
        contentValues.put("gender", gender);
        contentValues.put("dob", dob);
        contentValues.put("contact", contact);
        contentValues.put("password",password);
        db.insert("user_info", null, contentValues);
        return true;
    }

    public Cursor getData(String email,String pass) {
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor res =  db.rawQuery( "select * from user_info where email like '"+email+"' and password like '"+pass+"'", null );
        return res;
    }
}
