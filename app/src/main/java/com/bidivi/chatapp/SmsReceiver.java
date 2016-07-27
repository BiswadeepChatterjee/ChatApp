
package com.bidivi.chatapp;
        import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.PhoneNumberUtils;
import android.telephony.gsm.SmsMessage;
        import android.widget.Toast;

        public class SmsReceiver extends BroadcastReceiver
        {
            @Override
            public void onReceive(Context context, Intent intent)
            {
                //---get the SMS message passed in---
                Bundle bundle = intent.getExtras();
                SmsMessage[] msgs = null;
                String str = "";
                String helperphone = "4086878302";
                String phone = "";
                if (bundle != null)
                {
                    //---retrieve the SMS message received---
                    Object[] pdus = (Object[]) bundle.get("pdus");
                    msgs = new SmsMessage[pdus.length];
                    for (int i=0; i<msgs.length; i++){
                        msgs[i] = SmsMessage.createFromPdu((byte[])pdus[i]);
                        phone += msgs[i].getOriginatingAddress();
                        if (PhoneNumberUtils.compare(helperphone, phone)) {
                            str += "SMS from " + msgs[i].getOriginatingAddress();
                            str += " :";
                            str += msgs[i].getMessageBody().toString();
                        }
                    }
                    //---display the new SMS message---
                    String sender = phone;
                    // apply sms filter
                    if (PhoneNumberUtils.compare(helperphone, sender)) {
                        Toast.makeText(context, str, Toast.LENGTH_SHORT).show();
                    }
                }

            }
        }