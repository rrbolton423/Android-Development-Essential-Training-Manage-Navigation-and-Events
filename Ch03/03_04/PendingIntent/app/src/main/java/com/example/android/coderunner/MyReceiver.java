package com.example.android.coderunner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.android.coderunner.events.MessageEvent;

import org.greenrobot.eventbus.EventBus;

public class MyReceiver extends BroadcastReceiver {

    // This method is called when the BroadcastReceiver is
    // receiving an Intent broadcast.
    @Override
    public void onReceive(Context context, Intent intent) {

        // Get the String extra from the Intent with the key "payload"
        String message = intent.getStringExtra("payload");

        // Send the message back to the Activity
        EventBus.getDefault().post(new MessageEvent("Received message: " + message));
    }
}
