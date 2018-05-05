package com.example.android.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.TaskStackBuilder;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class Activity3 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    // This method is called when a menu item is selected
    // In this case, we're handling the home / up button being pressed
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        // If the home button is pressed in the action bar...
        if (item.getItemId() == android.R.id.home) {

            // Call onBackPressed() to add create the stack
            // hierarchy programmatically
            onBackPressed();

            // Return true if all went well
            return true;
        }

        // Make call to super class
        return super.onOptionsItemSelected(item);
    }

    // This method is called when a the back button is pressed
    @Override
    public void onBackPressed() {
        super.onBackPressed();

        // Create an instance of the class TaskStackBuilder
        // This object will build a synthetic back stack
        // for cross navigation
        TaskStackBuilder builder = TaskStackBuilder.create(this);

        // By calling appParentStack() and passing the Activity3
        // class literal, all parents of Activity3 as specified
        // in the manifest will be added to this back stack
        builder.addParentStack(Activity3.class);

        // You want to build the Intent stack from the beginning of the
        // app going forward. Whatever you declare last will be at the
        // top of the back stack.

        // Add an Intent navigating to MainActivity in the Back Stack
        builder.addNextIntent(new Intent(this, MainActivity.class));

        // Add an Intent navigating to Activity2 in the Back Stack
        builder.addNextIntent(new Intent(this, Activity2.class));

        // Return the array of Intents added to this builder object,
        // and start the Activities
        startActivities(builder.getIntents());

    }
}
