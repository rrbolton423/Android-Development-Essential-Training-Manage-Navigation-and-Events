package com.example.android.coderunner;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";
    private static final String LOG_VALUE = "log_value";
    private TextView mLog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initializeViews();

        if (savedInstanceState != null && savedInstanceState.containsKey(LOG_VALUE)) {
            mLog.setText(savedInstanceState.getString(LOG_VALUE));
            adjustScroll();
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        String logValue = mLog.getText().toString();
        outState.putString(LOG_VALUE, logValue);
        super.onSaveInstanceState(outState);
    }

    private void initializeViews() {
        mLog = (TextView) findViewById(R.id.log);
        mLog.setMovementMethod(new ScrollingMovementMethod());
    }

    private void log(String message) {
        Log.i(TAG, message);
        mLog.append(message + "\n");
        adjustScroll();
    }

    private void adjustScroll() {
        final int scrollAmount = mLog.getLayout()
                .getLineTop(mLog.getLineCount()) - mLog.getHeight();
        if (scrollAmount > 0)
            mLog.scrollTo(0, scrollAmount);
        else
            mLog.scrollTo(0, 0);
    }

    public void runCode(View view) {
        log("Running code");
    }

    public void clearLog(View view) {
        mLog.setText("");
    }
}
