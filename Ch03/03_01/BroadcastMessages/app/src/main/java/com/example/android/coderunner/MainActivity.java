package com.example.android.coderunner;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private TextView mLog;

    // Declare BroadcastReceiver object
    private BroadcastReceiver br;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLog = (TextView) findViewById(R.id.log);
        mLog.setMovementMethod(new ScrollingMovementMethod());
        mLog.setText("");

        // Instantiate BroadcastReceiver object
        br = new MyBroadcastReceiver();

        // Create an IntentFilter
        // CONNECTIVITY_ACTION happens every time something changes
        // in your connectivity to the internet
        IntentFilter filter = new IntentFilter(ConnectivityManager.CONNECTIVITY_ACTION);

        // Specifically listen for the action that happens when
        // Airplane Mode changes
        filter.addAction(Intent.ACTION_AIRPLANE_MODE_CHANGED);

        // Specifically listen for the action that happens when
        // the battery gets low
        filter.addAction(Intent.ACTION_BATTERY_LOW);

        // Register the BroadcastReceiver
        registerReceiver(br, filter);
    }

    // un-register the BroadcastReceiver when the Activity is destroyed
    @Override
    protected void onDestroy() {

        // un-register the BroadcastReceiver
        unregisterReceiver(br);

        super.onDestroy();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        if (intent != null) {
            String message = intent.getStringExtra("payload");
            if (message != null) {
                logMessage(message);
            }
        }
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

    public void runCode(View view) {
        logMessage("runCode");
    }

    public void clearLog(View view) {
        mLog.setText("");
        mLog.scrollTo(0, 0);
    }

    /*
    Broadcast messages are sent by the application framework and the
    operating system to notify you of things going on, on the device.
    And you can register to listen for those messages, and react however
    you want to in your Android app
     */

    // Create BroadcastReceiver class extending "BroadcastReceiver"
    class MyBroadcastReceiver extends BroadcastReceiver {

        // When the onReceive() method is called,
        // I'll receive a context and an intent object. The
        // Intent object has an action, and I can retrieve the action with
        // a getAction() method. I will simply display the action.
        @Override
        public void onReceive(Context context, Intent intent) {

            logMessage("Action: " + intent.getAction());

        }
    }
}