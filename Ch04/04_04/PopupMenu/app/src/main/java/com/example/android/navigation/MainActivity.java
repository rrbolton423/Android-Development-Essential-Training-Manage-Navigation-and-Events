package com.example.android.navigation;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.PopupMenu;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    public static final int EMAIL_REQUEST = 1000;
    public static final String NAME_KEY = "name_key";
    public static final String EMAIL_KEY = "email_key";

    private static final String COORDINATES = "34.3852964,-119.4875023";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, EmailListActivity.class);
                intent.putExtra(NAME_KEY, "Mike Smith");
                startActivityForResult(intent, EMAIL_REQUEST);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.action_map) {
            displayMap(null);
        }
        return super.onOptionsItemSelected(item);
    }

    public void displayStarters(View view) {
        Intent intent = new Intent(this, StartersActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == EMAIL_REQUEST && resultCode == RESULT_OK) {
            String nameText = data.getStringExtra(NAME_KEY);
            String emailText = data.getStringExtra(EMAIL_KEY);
            Toast.makeText(this, "You entered: " + nameText + " and " + emailText,
                    Toast.LENGTH_SHORT).show();
        }
    }

    public void displayMap(View view) {
        Uri uri = Uri.parse("geo:" + COORDINATES);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }

    public void displayMoreOptions(View view) {

        // Create a PopupMenu object
        // The 2 arguments are the context (the current Activity),
        // and the anchor, which is any view object in the current layout.
        PopupMenu popupMenu = new PopupMenu(this, view);

        // Inflate the menu file, and pass in the menu reference where I
        // want that to be added. So I'm saying inflate the XML file and add
        // all of its items to this menu, that belongs to the popupMenu object.
        popupMenu.getMenuInflater().inflate(R.menu.more_menu, popupMenu.getMenu());

        /* Add code to react to the menu choices */
        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem menuItem) {

                // Get the id of the menu item clicked in the popupMenu
                switch (menuItem.getItemId()) {

                    // If the "hours" menu item was selected...
                    case R.id.action_hours:

                        // Display hours Toast message
                        Toast.makeText(MainActivity.this, "Display hours",
                                Toast.LENGTH_SHORT).show();

                        // Break from the switch statement
                        break;

                    // If the "dress code" menu item was selected...
                    case R.id.action_dress_code:

                        // Display dress code Toast message
                        Toast.makeText(MainActivity.this, "Display dress code",
                                Toast.LENGTH_SHORT).show();

                        // Break from the switch statement
                        break;
                }

                // Return false from the method
                return false;
            }
        });

        // Display the menu
        popupMenu.show();
    }
}
