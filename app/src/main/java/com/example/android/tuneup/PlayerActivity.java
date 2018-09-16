package com.example.android.tuneup;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class PlayerActivity extends AppCompatActivity {

    int activity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Intent intent = getIntent();
        String Mood = intent.getStringExtra("Mood");
        activity = intent.getIntExtra("activityID", 0);
        TextView textView = findViewById(R.id.T1);
        textView.setText("Current Mood: " + Mood);

        final Button button = findViewById(R.id.Play);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (activity) {
                    case 1:
                        SwitchSG();
                        break;
                    case 2:
                        SwitchP();
                        break;
                    case 3:
                        SwitchR();
                        break;
                    case 4:
                        SwitchST();
                        break;
                    case 5:
                        SwitchC();
                        break;
                    case 6:
                        SwitchT();
                        break;
                    default:
                }
            }
        });
    }

    public void SwitchSG() {
        // Sports/Gym Playlist
        Uri webpage = Uri.parse("");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

    public void SwitchP() {
        //Partying Playlist
        Uri webpage = Uri.parse("spotify:user:warlock6699:playlist:6rF0STnMcSRlbcnhiiFrDj");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

    public void SwitchR() {
        //Relaxing Playlist
        Uri webpage = Uri.parse("spotify:user:warlock6699:playlist:00Bf5KVUPH74R5HtmgbxaH");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

    public void SwitchST() {
        //Studying Playlist
        Uri webpage = Uri.parse("");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

    public void SwitchC() {
        //Chilling Playlist
        Uri webpage = Uri.parse("");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

    public void SwitchT() {
        //Tune Me UP Playlist
        Uri webpage = Uri.parse("");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

    public void Default() {
        //Exception
        Toast toast = Toast.makeText(getApplicationContext(), "You haven't selected an option!", Toast.LENGTH_SHORT);
        toast.show();
    }
}
