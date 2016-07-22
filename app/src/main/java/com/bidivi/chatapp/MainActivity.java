package com.bidivi.chatapp;
import android.app.PendingIntent;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button sendSms;
    EditText editText;
    String stuff;
    String helper = "4086878302"; // should have a lot of numbers in database
    // each person that needs help is connected to another in
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText = (EditText) findViewById(R.id.message);
        sendSms = (Button) findViewById(R.id.sendBtn);
        sendSms.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {
                String myMsg = editText.getText().toString();
                stuff = "Hi, I am from Talk2Me. I need help with some stuff: " + myMsg;
                sendMsg(helper,stuff); //helper
            }
        });
    }
    protected void sendMsg(String theNumber, String myMsg)
    {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(theNumber,null,myMsg,null,null);
    }
}
