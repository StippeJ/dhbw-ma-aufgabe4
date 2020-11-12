package com.example.stippejan.aufgabe4;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.TextView;

import com.google.gson.Gson;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class MainActivity extends AppCompatActivity {

    public User currentUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        currentUser = createUser(readJsonFile());
    }

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

    private User createUser(String jsonText) {
        Gson gson = new Gson();
        return gson.fromJson(jsonText, User.class);
    }
}