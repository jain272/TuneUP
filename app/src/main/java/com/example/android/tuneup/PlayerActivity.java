package com.example.android.tuneup;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PlayerActivity extends AppCompatActivity {

    int activity = 0;
    String weather1;
    double temp;
    int activityPoints = 50;
    char weather;
    int time;
    String mood;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_player);

        Intent intent = getIntent();
        String Mood = intent.getStringExtra("Mood");
        activity = intent.getIntExtra("activityID", 0);
        Bundle bundle = intent.getExtras();
        weather1 = bundle.getString("weather1ID","");
        temp = bundle.getDouble("TempID");
        TextView textView = findViewById(R.id.T1);
        textView.setText("Current Mood: " + Mood);

        final Button button = findViewById(R.id.Play);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (activity) {
                    case 1: {
                        if (temp <= 30) {
                            activityPoints -= 25;
                        } else if (temp > 30 && temp <= 50) {
                            activityPoints -= 10;
                        } else if (temp > 50 && temp <= 80) {
                            activityPoints += 25;
                        } else {
                            activityPoints -= 10;
                        }
                        switch (weather) {
                            case 'R':
                                activityPoints -= 25;
                                break;
                            case 'C':
                                activityPoints -= 10;
                                break;
                            case 'P':
                                activityPoints += 25;
                                break;
                            case 'S':
                                activityPoints += 10;
                                break;
                            default:
                                activityPoints += 0;
                                break;
                        }
                        if (time < 6) {
                            activityPoints -= 15;
                        } else {
                            activityPoints += 15;
                        }
                        if (activityPoints < 25) {
                            mood = "Mellow";
                        } else if (activityPoints >= 25 && activityPoints < 50) {
                            mood = "Semi-Mellow";
                        } else if (activityPoints >= 50 && activityPoints < 75) {
                            mood = "Semi-Active";
                        } else {
                            mood = "Active";
                        }
                        if (mood.equals("Mellow")){
                            SwitchSG1();
                        }
                        else if(mood.equals("Semi-Mellow")){
                            SwitchSG2();
                        }
                        else if(mood.equals("Semi-Active")){
                            SwitchSG3();
                        }
                        else {
                            SwitchSG4();
                        }
                        break;
                    }
                    case 2: {
                        if (activityPoints < 25) {
                            mood = "Mellow";
                        } else if (activityPoints >= 25 && activityPoints < 50) {
                            mood = "Semi-Mellow";
                        } else if (activityPoints >= 50 && activityPoints < 75) {
                            mood = "Semi-Active";
                        } else {
                            mood = "Active";
                        }
                        SwitchP();
                        break;
                    }
                    case 3: {
                        if (activityPoints < 25) {
                            mood = "Mellow";
                        } else if (activityPoints >= 25 && activityPoints < 50) {
                            mood = "Semi-Mellow";
                        } else if (activityPoints >= 50 && activityPoints < 75) {
                            mood = "Semi-Active";
                        } else {
                            mood = "Active";
                        }
                        SwitchR();
                        break;
                    }
                    case 4: {
                        if (time <= 7 && time > 4) {
                            activityPoints -= 25;
                        } else if (time <= 11 && time > 7) {
                            activityPoints -= 10;
                        } else if (time <= 13 && time > 11) {
                            activityPoints += 0;
                        } else if (time <= 19 && time > 11) {
                            activityPoints += 10;
                        } else if (time <= 4 || time > 19) {
                            activityPoints += 25;
                        }

                        if (weather == 'R') {
                            activityPoints -= 15;
                        } else {
                            activityPoints += 15;
                        }
                        if (activityPoints < 25) {
                            mood = "Mellow";
                        } else if (activityPoints >= 25 && activityPoints < 50) {
                            mood = "Semi-Mellow";
                        } else if (activityPoints >= 50 && activityPoints < 75) {
                            mood = "Semi-Active";
                        } else {
                            mood = "Active";
                        }

                        if (mood.equals("Mellow")) {
                            SwitchST1();
                        }
                        else if(mood.equals("Semi-Mellow")){
                            SwitchST2();
                        }
                        else if(mood.equals("Semi-Active")){
                            SwitchST3();
                        }
                        else {
                            SwitchST4();
                        }
                        break;
                    }
                    case 5: {
                        switch (weather) {
                            case 'R':
                                activityPoints -= 15;
                                break;
                            default:
                                activityPoints += 0;
                                break;
                        }
                        if (time <= 7 && time > 4) {
                            activityPoints += 25;
                        } else if (time <= 11 && time > 7) {
                            activityPoints = +15;
                        } else if (time <= 13 && time > 11) {
                            activityPoints += 0;
                        } else if (time <= 19 && time > 13) {
                            activityPoints -= 25;

                        } else if (time <= 4 || time > 19) {
                            activityPoints -= 25;
                        }
                        if (activityPoints <= 25) {
                            mood = "Mellow";
                        } else if (activityPoints > 25 && activityPoints <= 50) {
                            mood = "Semi-Mellow";
                        } else if (activityPoints > 50 && activityPoints <= 75) {
                            mood = "Semi-Active";
                        } else {
                            mood = "Active";
                        }

                        if (mood.equals("Mellow")) {
                            SwitchC1();
                        }
                        else if(mood.equals("Semi-Mellow")){
                            SwitchC2();
                        }
                        else if(mood.equals("Semi-Active")){
                            SwitchC3();
                        }
                        else {
                            SwitchC4();
                        }
                        break;
                    }
                    case 6: {
                        if (weather == 'R') {
                            activityPoints -= 25;

                        } else if (weather == 'S') {
                            activityPoints += 25;
                        } else if (weather == 'C') {
                            activityPoints -= 10;
                        } else if (weather == 'P') {
                            activityPoints += 15;
                        }
                        if (temp <= 30) {
                            activityPoints -= 25;
                        } else if (temp > 30 && temp <= 50) {
                            activityPoints += 15;
                        } else if (temp > 50 && temp <= 80) {
                            activityPoints -= 10;
                        } else {
                            activityPoints += 25;
                        }
                        if (time >= 4 && time < 7) {
                            activityPoints += 10;
                        } else if (time >= 7 && time < 11) {
                            activityPoints += 5;
                        } else if (time >= 11 && time < 14) {
                            activityPoints += 0;
                        } else if (time >= 14 && time < 19) {
                            activityPoints -= 15;
                        } else if (time >= 19 || time < 4) {
                            activityPoints -= 25;
                        }
                        if (activityPoints < 13) {
                            mood = "Sad af";
                        } else if (activityPoints >= 13 && activityPoints < 25) {
                            mood = "Sad";
                        } else if (activityPoints >= 25 && activityPoints < 38) {
                            mood = "Mellow";
                        } else if (activityPoints >= 38 && activityPoints < 40) {
                            mood = "Semi-Mellow";
                        } else if (activityPoints >= 40 && activityPoints < 53) {
                            mood = "Normal";
                        } else if (activityPoints >= 53 && activityPoints < 65) {
                            mood = "Semi-Active";
                        } else if (activityPoints >= 65 && activityPoints < 78) {
                            mood = "Active";
                        } else if (activityPoints >= 78 && activityPoints < 90) {
                            mood = "Excited";
                        } else {
                            mood = "Excited af";
                        }

                        if (mood.equals("Sad af")) {
                            SwitchT1();
                        }
                        else if(mood.equals("Sad")){
                            SwitchT2();
                        }
                        else if(mood.equals("Mellow")){
                            SwitchT3();
                        }
                        else if(mood.equals("Semi-Mellow")){
                            SwitchT4();
                        }
                        else if(mood.equals("Normal")){
                            SwitchT5();
                        }
                        else if(mood.equals("Semi-Active")){
                            SwitchT6();
                        }
                        else if(mood.equals("Active")){
                            SwitchT7();
                        }
                        else if(mood.equals("Excited")){
                            SwitchT8();
                        }
                        else {
                            SwitchT8();
                        }
                        break;
                    }
                    default:
                        Default();
                }
            }
        });

        if (weather1.equals("Sunny") || weather1.equals("Mostly Sunny") || weather1.equals("Partly Sunny") || weather1.equals("Clear") || weather1.equals("Mostly Clear") || weather1.equals("Hot")) {
            weather = 'S';
        } else if (weather1.equals("Intermittent Clouds") || weather1.equals("Mostly Cloudy") || weather1.equals("Partly Cloudy")) {
            weather = 'P';
        } else if (weather1.equals("Cloudy") || weather1.equals("Dreary (Overcast)") || weather1.equals("Fog") || weather1.equals("Hazy Moonlight")) {
            weather = 'C';
        } else {
            weather = 'R';
        }
        SimpleDateFormat formatter = new SimpleDateFormat("HH");
        Date date = new Date();
        time = Integer.parseInt(formatter.format(date));
    }

    public void SwitchSG1() {
        //Sports/Gym Playlist1
        Uri webpage = Uri.parse("spotify:user:warlock6699:playlist:1OX1q67JTZXWUdKF0oKi7e");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        activityPoints=50;
    }

    public void SwitchSG2() {
        //Sports/Gym Playlist2
        Uri webpage = Uri.parse("spotify:user:warlock6699:playlist:3WK9bqjUmjYKZjpgOePsy8");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        activityPoints=50;
    }

    public void SwitchSG3() {
        //Sports/Gym Playlist3
        Uri webpage = Uri.parse("https://open.spotify.com/playlist/4NRrIjOcwLOITmEP2HgwbP");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        activityPoints=50;
    }

    public void SwitchSG4() {
        //Sports/Gym Playlist4
        Uri webpage = Uri.parse("https://open.spotify.com/playlist/1YJAlGGP8cDzqZJsoEQ3gD");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        activityPoints=50;
    }

    public void SwitchP() {
        //Partying Playlist
        Uri webpage = Uri.parse("spotify:user:warlock6699:playlist:6rF0STnMcSRlbcnhiiFrDj");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        activityPoints=50;
    }

    public void SwitchR() {
        //Relaxing Playlist
        Uri webpage = Uri.parse("spotify:user:warlock6699:playlist:00Bf5KVUPH74R5HtmgbxaH");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
    }

    public void SwitchST1() {
        //Studying Playlist1
        Uri webpage = Uri.parse("https://open.spotify.com/playlist/2jArGkAqIWi2Sx8Hypa31p");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        activityPoints=50;
    }

    public void SwitchST2() {
        //Studying Playlist2
        Uri webpage = Uri.parse("https://open.spotify.com/playlist/7L5cshmVSw9v0X0mZIn78U");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        activityPoints=50;
    }

    public void SwitchST3() {
        //Studying Playlist3
        Uri webpage = Uri.parse("https://open.spotify.com/playlist/37nHJKXeTOgQhwZXvRtGfm");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        activityPoints=50;
    }

    public void SwitchST4() {
        //Studying Playlist4
        Uri webpage = Uri.parse("https://open.spotify.com/playlist/2amhJhphcPln6Ybsjh6IYH");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        activityPoints=50;
    }

    public void SwitchC1() {
        //Chilling Playlist1
        Uri webpage = Uri.parse("https://open.spotify.com/playlist/0SUEaZOIRWBJsl8wWDwQAM");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        activityPoints=50;
    }

    public void SwitchC2() {
        //Chilling Playlist2
        Uri webpage = Uri.parse("https://open.spotify.com/playlist/3tRCQgeVW3I9Nn47lvilrw");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        activityPoints=50;
    }

    public void SwitchC3() {
        //Chilling Playlist3
        Uri webpage = Uri.parse("https://open.spotify.com/playlist/28iMFWE1FJmAmXZOxruBlZ");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        activityPoints=50;
    }

    public void SwitchC4() {
        //Chilling Playlist4
        Uri webpage = Uri.parse("https://open.spotify.com/playlist/2QYuI6SROeJtqRWNxrUMxH");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        activityPoints=50;
    }

    public void SwitchT1() {
        //Tune Me UP Playlist1
        Uri webpage = Uri.parse("https://open.spotify.com/playlist/2AjlccWiGYG0jvvOnC5zB7");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        activityPoints=50;
    }

    public void SwitchT2() {
        //Tune Me UP Playlist2
        Uri webpage = Uri.parse("https://open.spotify.com/playlist/79gnLfvaKxD8GifGZPLx2v");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        activityPoints=50;
    }

    public void SwitchT3() {
        //Tune Me UP Playlist3
        Uri webpage = Uri.parse("https://open.spotify.com/playlist/3683pKHDNgefBamcxpqs8h");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        activityPoints=50;
    }

    public void SwitchT4() {
        //Tune Me UP Playlist4
        Uri webpage = Uri.parse("https://open.spotify.com/playlist/6hMiy1yc7aQwhIBkEPy579");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        activityPoints=50;
    }

    public void SwitchT5() {
        //Tune Me UP Playlist5
        Uri webpage = Uri.parse("https://open.spotify.com/playlist/1uajGvEjcv1V6OU9X7P7Yf");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        activityPoints=50;
    }

    public void SwitchT6() {
        //Tune Me UP Playlist6
        Uri webpage = Uri.parse("https://open.spotify.com/playlist/6jWhlLBvM2d4IDkADxZbQJ");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        activityPoints=50;
    }

    public void SwitchT7() {
        //Tune Me UP Playlist7
        Uri webpage = Uri.parse("https://open.spotify.com/playlist/33JEvnoeXghLrt18qlAwcL");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        activityPoints=50;
    }

    public void SwitchT8() {
        //Tune Me UP Playlist8
        Uri webpage = Uri.parse("https://open.spotify.com/playlist/0aUxW2AHypBMz8VH19FDQx");
        Intent intent = new Intent(Intent.ACTION_VIEW, webpage);
        startActivity(intent);
        activityPoints=50;
    }

    public void Default() {
        //Exception
        Toast toast = Toast.makeText(getApplicationContext(), "You haven't selected an option!", Toast.LENGTH_SHORT);
        toast.show();
        activityPoints=50;
    }
}
