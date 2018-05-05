package com.example.android.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    // Constant for IntentExtra data
    public static final String NAME_KEY = "name_key";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        // Get a reference to the Floating Action Button
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);

        // Set up an OnClickListener interface on the FAB
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // Create an Explicit Intent to navigate to the EmailListActivity
                Intent intent = new Intent(MainActivity.this, EmailListActivity.class);

                // Store data as an IntentExtra using key-value pairs
                intent.putExtra(NAME_KEY, "Mike Smith");

                // Launch the Activity
                startActivity(intent);
            }
        });

    }

    public void displayStarters(View view) {

        // Create an Explicit Intent to navigate to the StartersActivity
        Intent intent = new Intent(this, StartersActivity.class);

        // Launch the Activity
        startActivity(intent);
    }
}
