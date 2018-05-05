package com.example.android.navigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;

public class EmailListActivity extends AppCompatActivity {

    // Declare Views
    private EditText etName, etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_list);

        // Get a reference to the Intent that launched this Activity
        Intent intent = getIntent();

        // Get the data from the IntentExtra
        String name = intent.getStringExtra(MainActivity.NAME_KEY);

        // Get a reference to the EditText component(s) that
        // will display the name and email
        etName = (EditText) findViewById(R.id.name_text);
        etEmail = (EditText) findViewById(R.id.email_address);

        // Display the data in the EditText
        etName.setText(name);
    }

    @Override
    public void onBackPressed() {

        // Get the values that the user has typed in
        String nameText = etName.getText().toString();
        String emailText = etEmail.getText().toString();

        // Create Intent object for the purpose of holding data
        Intent intent = new Intent();

        // Pass values into the Intent object
        intent.putExtra(MainActivity.NAME_KEY, nameText);
        intent.putExtra(MainActivity.EMAIL_KEY, emailText);

        // Set the result before I return to the MainActivity,
        // passing the request code constant and an Intent object
        setResult(RESULT_OK, intent);

        // Call to super class
        super.onBackPressed();

    }
}
