package com.example.android.navigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class EmailListActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_list);

        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.NAME_KEY);

        EditText et = (EditText) findViewById(R.id.name_text);
        et.setText(name);
    }
}
