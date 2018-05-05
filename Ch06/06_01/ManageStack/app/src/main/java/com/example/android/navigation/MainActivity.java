package com.example.android.navigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void displayNextActivity(View view) {

        // Create an Intent to navigate to Activity 2
        Intent intent = new Intent(this, Activity2.class);

        // When you create an intent, you can add flags: integer-based
        // values that are represented by constants that add some instruction
        // to the intent. In this case, Activity 2 will have no
        // history in the back stack.
        intent.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);

        // Start the Activity
        startActivity(intent);
    }
}
