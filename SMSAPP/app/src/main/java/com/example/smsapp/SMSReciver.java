package com.example.smsapp;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.telephony.SmsMessage;
import android.widget.Toast;

public class SMSReciver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {

        Bundle b = intent.getExtras(); // Get message through intent
        Object[] smsobj = (Object[]) b.get("pdus");

        for (Object obj : smsobj) {
            SmsMessage sm = SmsMessage.createFromPdu((byte[]) obj);
            String mo = sm.getOriginatingAddress();
            String msg = sm.getMessageBody();
            Toast.makeText(context, "Mobile Number is " + mo + "\n" + "Message " + msg, Toast.LENGTH_SHORT).show();
        }
    }
}
