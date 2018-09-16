package com.example.android.tuneup;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class HomeActivity extends AppCompatActivity {

    int activity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
    }

    /** Called when the user taps the Exercising button */
    public void Mood1 (View view) {
        activity = 1;

        Intent intent = new Intent(this, PlayerActivity.class);
        intent.putExtra("Mood", "Exercising");
        intent.putExtra("activityID", activity);
        startActivity(intent);
    }

    /** Called when the user taps the Partying button */
    public void Mood2 (View view) {
        activity = 2;

        Intent intent = new Intent(this, PlayerActivity.class);
        intent.putExtra("Mood", "Partying");
        intent.putExtra("activityID", activity);
        startActivity(intent);
    }

    /** Called when the user taps the Relaxing button */
    public  void Mood3 (View view) {
        activity = 3;

        Intent intent = new Intent(this, PlayerActivity.class);
        intent.putExtra("Mood", "Relaxing");
        intent.putExtra("activityID", activity);
        startActivity(intent);
    }

    /** Called when the user taps the Studying button */
    public void Mood4 (View view) {
        activity = 4;

        Intent intent = new Intent(this, PlayerActivity.class);
        intent.putExtra("Mood", "Studying");
        intent.putExtra("activityID", activity);
        startActivity(intent);
    }

    /** Called when the user taps the Chilling button */
    public void Mood5 (View view) {
        activity = 5;

        Intent intent = new Intent(this, PlayerActivity.class);
        intent.putExtra("Mood", "Chilling");
        intent.putExtra("activityID", activity);
        startActivity(intent);
    }

    /** Called when the user taps the Tune Me UP button */
    public void Mood6 (View view) {
        activity = 6;

        Intent intent = new Intent(this, PlayerActivity.class);
        intent.putExtra("Mood", "Tune-ing!");
        intent.putExtra("activityID", activity);
        startActivity(intent);
    }
}
