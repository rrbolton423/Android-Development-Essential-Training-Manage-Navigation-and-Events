package com.example.android.navigation;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;

public class EmailListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_list);

        // Get a reference to the Intent that launched this Activity
        Intent intent = getIntent();

        // Get the data from the IntentExtra
        String name = intent.getStringExtra(MainActivity.NAME_KEY);

        // Get a reference to the EditText component that
        // will display the name
        EditText et = (EditText) findViewById(R.id.name_text);

        // Display the data in the EditText
        et.setText(name);
    }
}
