package com.slrtce.sendinvitation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }
    public void save_detail(View view){
        String name,email,gender,dob,contactnumber,pass;
        name=((EditText)findViewById(R.id.textView_name)).getText().toString();
        email=((EditText)findViewById(R.id.textView_email)).getText().toString();
        dob=((EditText)findViewById(R.id.editText_dob)).getText().toString();
        contactnumber=((EditText)findViewById(R.id.editText_contact)).getText().toString();
        pass=((EditText)findViewById(R.id.editText_password)).getText().toString();
        gender=((EditText)findViewById(R.id.editText_gender)).getText().toString();
        DbHelper dbHelper=new DbHelper(this);
        boolean status = dbHelper.insertdetail(name,email,gender,dob,contactnumber,pass);
        if(status){
           // Toast.makeText(getApplicationContext(),"Successfully Inserted",Toast.LENGTH_SHORT);
            Intent loginintent = new Intent();
            startActivity(loginintent);
        }


    }
}
