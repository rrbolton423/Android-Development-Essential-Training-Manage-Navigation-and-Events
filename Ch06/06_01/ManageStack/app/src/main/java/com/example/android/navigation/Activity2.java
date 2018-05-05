package com.example.android.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class Activity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);
    }

    public void displayNextActivity(View view) {

        // Create an Intent to Activity3
        Intent intent = new Intent(this, Activity3.class);

        // Have Activity3 wipe out the back stack completely by
        // 1. Creating a new Task
        // 2. Clearing the existing Task
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);

        // Start the Activity
        startActivity(intent);
    }

}
