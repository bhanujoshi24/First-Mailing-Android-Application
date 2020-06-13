package com.slrtce.sendinvitation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Vector;

public class MainActivity extends AppCompatActivity {

    EditText editText_userid;
    EditText editText_passText;
    Button button_login;
    TextView textView_signup;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void login(View view){

        editText_userid=(EditText)findViewById(R.id.textView_user);
        editText_passText=(EditText)findViewById(R.id.textView_password);
        String emailid,pass;
        emailid=editText_userid.getText().toString();
        pass=editText_passText.getText().toString();

        DbHelper dbHelper=new DbHelper(this);
        Cursor cursor = dbHelper.getData(emailid,pass);
        cursor.moveToFirst();

        ArrayList<String> user_detail=new ArrayList<String>();

        //Vector<String> user_detail=new Vector<String>();
        user_detail.add(cursor.getString(0));
        user_detail.add(cursor.getString(1));
        user_detail.add(cursor.getString(2));
        user_detail.add(cursor.getString(3));
        user_detail.add(cursor.getString(4));
        user_detail.add(cursor.getString(5));
        String verifyemail= user_detail.get(1);
        String verifypass = user_detail.get(5);

        if(emailid.equals(verifyemail) && pass.equals(verifypass)){
            Intent gotohome= new Intent();
            gotohome.setClass(this, Homepage.class);
            gotohome.putExtra("user_detail",user_detail);
            startActivity(gotohome);
        }
        else{
            Toast.makeText(getApplicationContext(),"Invalid Credential", Toast.LENGTH_SHORT);
        }
    }

    public void signup(View view){
        Intent gotosignup=new Intent();
        gotosignup.setClass(this, Signup.class);
        startActivity(gotosignup);

    }
}
