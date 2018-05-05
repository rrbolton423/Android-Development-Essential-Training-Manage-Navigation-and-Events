package com.example.android.coderunner;

import android.app.IntentService;
import android.content.Intent;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

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

        // Log information
        Log.i("MyIntentService", "onHandleIntent");

        /* Now I want to communicate from the Service back to the Activity */

        // Create an Intent and ass a custom action to it
        Intent returnIntent = new Intent("custom-event");

        // Add data to the Intent
        returnIntent.putExtra(MESSAGE_KEY, "from the service");

        // Get a reference to the local BroadcastManager
        LocalBroadcastManager.getInstance(getApplicationContext())
                .sendBroadcast(returnIntent);

        // As the Service completes, it'll send the message
    }
}
