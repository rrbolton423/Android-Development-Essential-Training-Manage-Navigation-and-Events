package com.example.android.navigation;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class EmailListActivity extends AppCompatActivity {

    private EditText etName, etEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_email_list);

        //noinspection ConstantConditions
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_checkmark);

        Intent intent = getIntent();
        String name = intent.getStringExtra(MainActivity.NAME_KEY);

        etName = (EditText) findViewById(R.id.name_text);
        etEmail = (EditText) findViewById(R.id.email_address);
        etName.setText(name);
    }

    @Override
    public void onBackPressed() {
        String nameText = etName.getText().toString();
        String emailText = etEmail.getText().toString();

        Intent intent = new Intent();
        intent.putExtra(MainActivity.NAME_KEY, nameText);
        intent.putExtra(MainActivity.EMAIL_KEY, emailText);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            onBackPressed();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}
