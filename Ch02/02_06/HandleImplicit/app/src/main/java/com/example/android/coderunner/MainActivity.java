package com.example.android.coderunner;

import android.content.Intent;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mLog = (TextView) findViewById(R.id.log);
        mLog.setMovementMethod(new ScrollingMovementMethod());
        mLog.setText("");
    }

    // When this Activity is launched, onResume() will always
    // be called. So put code to handle the Intent here
    @Override
    protected void onResume() {
        super.onResume();

        // Create a reference to the Intent object that started this Activity
        Intent intent = getIntent();

        // Check to make sure that the Intent object isn't null
        // If the Intent is not null...
        if (intent != null) {

            // Get the String data from the Intent via the key
            String message = intent.getStringExtra("payload");

            // Check to make sure that the message String isn't null
            // If the message is not null...
            if (message != null) {

                // Display the message in the TextView of this Activity
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
}
