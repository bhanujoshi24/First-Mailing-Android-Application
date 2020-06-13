package com.slrtce.sendinvitation;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.Vector;

public class Homepage extends AppCompatActivity {

    EditText editText_no;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homepage);
        Intent homeintent=getIntent();
        ArrayList<String> user_msg =  (ArrayList<String>) homeintent.getStringArrayListExtra("user_detail");
        TextView textView_welcome=(TextView)findViewById(R.id.textView_welcome);
        textView_welcome.setText("Welcome "+user_msg.get(0));


    }

    public void sendmessage(View view){

        String no = ((EditText)findViewById(R.id.textView_number_send)).getText().toString();
        String description= ((EditText)findViewById(R.id.editText_email_description)).getText().toString();

        Intent smsintent= new Intent(Intent.ACTION_SENDTO, Uri.parse("smsto:"+no));
        smsintent.putExtra("smsbody",description);
        startActivity(smsintent);

    }
}
