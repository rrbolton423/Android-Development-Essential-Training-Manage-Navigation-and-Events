package com.example.android.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }

    public void displayStarters(View view) {

        // Create an Explicit Intent to navigate to the StartersActivity
        Intent intent = new Intent(this, StartersActivity.class);

        // Launch the Activity
        startActivity(intent);
    }
}
