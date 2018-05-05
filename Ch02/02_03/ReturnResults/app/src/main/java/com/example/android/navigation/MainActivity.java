package com.example.android.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    // Constant to identify the specific request
    public static final int EMAIL_REQUEST = 1000;

    // Constant key for the name value
    public static final String NAME_KEY = "name_key";

    // Constant key for the email value
    public static final String EMAIL_KEY = "email_key";

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
                startActivityForResult(intent, EMAIL_REQUEST);
            }
        });
    }

    public void displayStarters(View view) {

        // Create an Explicit Intent to navigate to the StartersActivity
        Intent intent = new Intent(this, StartersActivity.class);

        // Launch the Activity
        startActivity(intent);
    }

    // Handle the result
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        // Make sure you're coming from the expected Activity and the result code is OK
        if (requestCode == EMAIL_REQUEST && resultCode == RESULT_OK) {

            // Get the name from the Intent data
            String nameText = data.getStringExtra(NAME_KEY);

            // Get the email from the Intent data
            String emailText = data.getStringExtra(EMAIL_KEY);

            // Display the name and email via Toast
            Toast.makeText(this,
                    "You entered: " + nameText + " and " + emailText,
                    Toast.LENGTH_SHORT)
                    .show();
        }
    }
}

