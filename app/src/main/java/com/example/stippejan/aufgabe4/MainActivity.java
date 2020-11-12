package com.example.stippejan.aufgabe4;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    // User-object that includes the data that will be shown by this activity
    public User currentUser;

    // Loading the JSON-file and saving its data in the currentUser-object
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentUser = createUser(readJsonFile());
    }

    // Load the data into the activities layout
    // Setting the text for the TextViews
    // Initialising the RecyclerView
    @Override
    protected void onStart() {
        super.onStart();

        TextView userName = findViewById(R.id.userName);
        TextView userLastLogin = findViewById(R.id.userLastLogin);

        userName.setText(getString(R.string.welcome_user, currentUser.getUserName()));
        userLastLogin.setText(getString(R.string.last_login, currentUser.getLastLogin()));

        RecyclerView movieRecyclerView = findViewById(R.id.userMovieRecyclerView);
        MovieAdapter movieAdapter = new MovieAdapter(currentUser.getMovieList());
        movieRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        movieRecyclerView.setAdapter(movieAdapter);
    }

    // Creating the options-menu
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    // Specifying the actions for the menu-icons
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.mainMenuSearch:
                Toast.makeText(this, getString(R.string.menu_search_toast), Toast.LENGTH_SHORT).show();
                break;
            case R.id.mainMenuUser:
                Toast.makeText(this, getString(R.string.menu_account_toast), Toast.LENGTH_SHORT).show();
                break;
            default:
                break;
        }
        return true;
    }

    // Read the json-file and return the content as a string
    private String readJsonFile() {
        InputStream is = getResources().openRawResource(R.raw.movies);
        String jsonText = "";

        try {
            jsonText = IOUtils.toString(is, StandardCharsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();
        }

        return jsonText;
    }

    // Create a user from a string that contains json-data
    private User createUser(String jsonText) {
        Gson gson = new Gson();
        return gson.fromJson(jsonText, User.class);
    }
}