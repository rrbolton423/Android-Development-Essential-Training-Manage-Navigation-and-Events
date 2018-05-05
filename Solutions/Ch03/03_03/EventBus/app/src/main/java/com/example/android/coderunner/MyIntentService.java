package com.example.android.coderunner;

import android.app.IntentService;
import android.content.Intent;

import com.example.android.coderunner.events.MessageEvent;

import org.greenrobot.eventbus.EventBus;

public class MyIntentService extends IntentService {

    public MyIntentService() {
        super("MyIntentService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        MessageEvent event = new MessageEvent("from the service");
        EventBus.getDefault().post(event);

        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        event.setMessage("another message from the service");
        EventBus.getDefault().post(event);

    }
}
