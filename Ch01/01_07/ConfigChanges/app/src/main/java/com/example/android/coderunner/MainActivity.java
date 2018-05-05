package com.example.android.coderunner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    // Create TAG for logging
    private static final String TAG = "MainActivity";
    public static final String LOG_TEXT_KEY = "log_text_key";

    // Declare TextView
    private TextView mLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get reference to TextView
        mLog = (TextView) findViewById(R.id.log);

        // Turn on vertical scrolling
        mLog.setMovementMethod(new ScrollingMovementMethod());

        // Check to see if savedInstanceState is null, and then check
        // to see whether it has the key I'm looking for
        if (savedInstanceState != null && savedInstanceState.containsKey(LOG_TEXT_KEY)) {

            // Retrieve the value and display it in the log TextView
            mLog.setText(savedInstanceState.getString(LOG_TEXT_KEY));

            // If the above condition isn't true...
        } else {

            // Clear the Text
            mLog.setText("");
        }

        // Log create message
        logMessage("onCreate");
    }

    // onSaveInstanceState will automatically be called by the framework
    // as the Activity closes down.
    @Override
    protected void onSaveInstanceState(Bundle outState) {

        // Get the data from the TextView
        String logText = mLog.getText().toString();

        // Put the data into the outState Bundle object
        // using key value pairs
        outState.putString(LOG_TEXT_KEY, logText);

        // Call the super version of the method to save the data
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onPause() {
        super.onPause();

        // Log pause message
        logMessage("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Log resume message
        logMessage("onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();

        // Log stop message
        logMessage("onStop");
    }

    @Override
    protected void onStart() {
        super.onStart();

        // Log start message
        logMessage("onStart");
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

        // Log runCode message
        logMessage("runCode");
    }

    public void clearLog(View view) {

        // Clear the Text and reset the scroll position
        mLog.setText("");
        mLog.scrollTo(0, 0);
    }
}
