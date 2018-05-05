package com.example.android.coderunner;

import android.app.IntentService;
import android.content.Intent;

import com.example.android.coderunner.events.MessageEvent;

import org.greenrobot.eventbus.EventBus;

// And IntentService is a background service and it runs
// on it's own thread. It run to completion, it doesn't stay in
// the background forever, but it doesn't have direct access to
// an Activity that might've called it. It can't call the Activity's
// methods. So to send information from the IntentService back to
// the Activity, you can use a local broadcast message.
public class MyIntentService extends IntentService {

    // Create String constant
    public static final String MESSAGE_KEY = "message_key";

    // Create Constructor
    public MyIntentService() {
        super("MyIntentService");
    }

    // When the Service is launched, the onHandleIntent() method
    // will be called automatically
    @Override
    protected void onHandleIntent(Intent intent) {

        // Create a new instance of my MessageEvent class
        MessageEvent event = new MessageEvent("from the service");

        // Dispatch the message using the EventBus class
        // This is how you send an event
        // Now you can receive the event from anywhere in the
        // application (Activity, Fragment, Singleton, etc...)
        EventBus.getDefault().post(event);

        // Pause for 2 seconds
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        // Set another message for the event
        event.setMessage("another message from the service");

        // Dispatch another message using the EventBus class
        EventBus.getDefault().post(event);

        // As the Service completes, it'll send the message
    }
}
