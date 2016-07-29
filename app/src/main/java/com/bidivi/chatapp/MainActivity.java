package com.bidivi.chatapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class MainActivity extends AppCompatActivity {

    Button sendSms;
    //TextView tv1;
    RadioGroup radioGroup;
    RadioButton radioButton;
    RadioButton radioButton2;
    RadioButton radioButton3;
    RadioButton radioButton4;
    RadioButton radioButton5;
    String myMsg;
    String stuff;
    String helper = "4087180303"; // should have a lot of numbers in database
    // each person that needs help is connected to another in
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sendSms = (Button) findViewById(R.id.sendBtn);
        radioButton = (RadioButton) findViewById(R.id.radioButton);
        radioButton2 = (RadioButton) findViewById(R.id.radioButton2);
        radioButton3 = (RadioButton) findViewById(R.id.radioButton3);
        radioButton4 = (RadioButton) findViewById(R.id.radioButton4);
        radioButton5 = (RadioButton) findViewById(R.id.radioButton5);
        radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        /*tv1=(TextView)findViewById(R.id.textView3);
        Typeface custom_font = Typeface.createFromAsset(getAssets(), "SF Gushing Meadow.ttf");
        tv1.setTypeface(custom_font);*/

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                switch (checkedId) {
                    case R.id.radioButton:

                        RadioButton r = (RadioButton) findViewById(R.id.radioButton);
                        myMsg = r.getText().toString();

                        break;

                    case R.id.radioButton2:

                        RadioButton r2 = (RadioButton) findViewById(R.id.radioButton2);
                        myMsg = r2.getText().toString();

                        break;
                    case R.id.radioButton3:

                        RadioButton r3 = (RadioButton) findViewById(R.id.radioButton3);
                        myMsg = r3.getText().toString();

                        break;
                    case R.id.radioButton4:

                        RadioButton r4 = (RadioButton) findViewById(R.id.radioButton4);
                        myMsg = r4.getText().toString();

                        break;
                    case R.id.radioButton5:

                        RadioButton r5 = (RadioButton) findViewById(R.id.radioButton5);
                        myMsg = r5.getText().toString();

                        break;
                }
            }
        });
        radioGroup.setEnabled(false);



        sendSms.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v)
            {

                stuff = "Hi, I am from Talk2Me. I need help with " + myMsg;
                sendMsg(helper,stuff);
                setContentView(R.layout.animation);
                Intent myIntent = new Intent(MainActivity.this, SMS.class);
                startActivity(myIntent);
            }
        });
    }
    protected void sendMsg(String theNumber, String myMsg)
    {
        SmsManager sms = SmsManager.getDefault();
        sms.sendTextMessage(theNumber,null,myMsg,null,null);
    }


}
