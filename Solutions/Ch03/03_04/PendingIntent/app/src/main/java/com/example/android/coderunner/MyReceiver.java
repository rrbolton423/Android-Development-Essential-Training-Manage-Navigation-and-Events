package com.example.android.coderunner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.android.coderunner.events.MessageEvent;

import org.greenrobot.eventbus.EventBus;

public class MyReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        String message = intent.getStringExtra("payload");
        EventBus.getDefault().post(new MessageEvent("Received message: " + message));
    }
}
