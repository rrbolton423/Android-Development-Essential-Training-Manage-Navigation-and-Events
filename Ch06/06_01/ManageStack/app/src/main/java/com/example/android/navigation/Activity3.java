package com.example.android.navigation;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        // Get a reference to the ActionBar object
        ActionBar actionBar = getSupportActionBar();

        // If the ActionBar is not nul..
        if (actionBar != null) {

            // Do not display the Home / Up Button on in this Activity
            actionBar.setDisplayHomeAsUpEnabled(false);
        }
    }
}
