package com.example.android.coderunner;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.example.android.coderunner.events.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView mLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLog = (TextView) findViewById(R.id.log);
        mLog.setMovementMethod(new ScrollingMovementMethod());
        mLog.setText("");

        logMessage("Ready!");

        // Register the MainActivity to listen for events
        // via EventBus as the Activity starts up
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onDestroy() {

        // un-Register the MainActivity to listen for events
        // via EventBus as the Activity shuts down
        EventBus.getDefault().unregister(this);

        super.onDestroy();
    }

    private void logMessage(String message) {
//      Output message to logcat console
        Log.i(TAG, message);

//      Output message to TextView
        mLog.append(message + "\n");

//      Adjust scroll position to make last line visible
        Layout layout = mLog.getLayout();
        if (layout != null) {
            int scrollAmount = layout.getLineTop(mLog.getLineCount()) - mLog.getHeight();
            mLog.scrollTo(0, scrollAmount > 0 ? scrollAmount : 0);
        }
    }

    // This method starts the IntentService
    public void runCode(View view) {

        // Create an Intent to the IntentService
        Intent intent = new Intent(this, MyIntentService.class);

        // Start the Service passing the Intent object
        startService(intent);
    }

    public void clearLog(View view) {
        mLog.setText("");
        mLog.scrollTo(0, 0);
    }

    // To receive an event, create a method that receives
    // that event type as an argument. It should be public and
    // return void. To connect the method with EventBus, add an
    // annotation above the method named "@Subscribe", and add an
    // argument named "threadMode". It it not required but you need
    // to be specific about the threadMode.
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onMessageEvent(MessageEvent event) {

        // Display message in TextView
        logMessage(event.getMessage());
    }

}
