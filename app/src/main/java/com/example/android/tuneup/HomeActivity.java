package com.example.android.tuneup;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.Charset;

public class HomeActivity extends AppCompatActivity {

    String a, weather1;
    double temp;

    private static final String TAG = HomeActivity.class.getSimpleName();

    public static final String USGS_BASE_URL = "http://dataservice.accuweather1.com/currentconditions/v1/2135952";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        @SuppressLint("StaticFieldLeak")
        AsyncTask <Void, Void, Void> mAsyncTask = new AsyncTask <Void, Void, Void> () {
            @Override
            protected Void doInBackground(Void... voids) {
                Uri uri = Uri.parse(USGS_BASE_URL);
                Uri.Builder builder = uri.buildUpon();
                builder.appendQueryParameter("apikey", "ajr8GYVfftISVReAL2NYa9tg7fewD0kd");
                builder.appendQueryParameter("q", "West Lafayette");
                uri = builder.build();

                URL url;
                try{
                    url = new URL(uri.toString());
                } catch (MalformedURLException e) {
                    url = null;
                    e.printStackTrace();
                }

                HttpURLConnection connection;
                try {
                    assert url != null;
                    connection = (HttpURLConnection) url.openConnection();
                    connection.setReadTimeout(10000);
                    connection.setConnectTimeout(15000);
                    connection.setRequestMethod("GET");
                    connection.connect();

                    Log.v(TAG, "Response code: " + connection.getResponseCode());

                    BufferedReader reader = null;
                    if (connection.getResponseCode() == 200){
                        InputStream stream = connection.getInputStream();
                        StringBuilder output = new StringBuilder();
                        InputStreamReader inputStreamReader = new InputStreamReader(stream, Charset.forName("UTF-8"));
                        reader = new BufferedReader(inputStreamReader);
                        String line = reader.readLine();
                        while (line != null){
                            output.append(line);
                            line = reader.readLine();
                        }
                        a = "" + output;
                        try {
                            JSONObject b = new JSONArray(a).getJSONObject(0);
                            weather1 = b.getString("weather1Text");
                            temp = b.getJSONObject("Temperature").getJSONObject("Imperial").getDouble("Value");
                        } catch (JSONException e) {
                            //Ignore
                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
                return null;
            }
        };
        mAsyncTask.execute();
    }

    int activity = 0;

    /** Called when the user taps the Exercising button */
    public void Mood1 (View view) {
        activity = 1;

        Intent intent = new Intent(this, PlayerActivity.class);
        intent.putExtra("Mood", "Exercising");
        intent.putExtra("activityID", activity);
        intent.putExtra("weather1ID", weather1);
        intent.putExtra("TempID", temp);
        startActivity(intent);
    }

    /** Called when the user taps the Partying button */
    public void Mood2 (View view) {
        activity = 2;

        Intent intent = new Intent(this, PlayerActivity.class);
        intent.putExtra("Mood", "Partying");
        intent.putExtra("activityID", activity);
        intent.putExtra("weather1ID", weather1);
        intent.putExtra("TempID", temp);
        startActivity(intent);
    }

    /** Called when the user taps the Relaxing button */
    public  void Mood3 (View view) {
        activity = 3;

        Intent intent = new Intent(this, PlayerActivity.class);
        intent.putExtra("Mood", "Relaxing");
        intent.putExtra("activityID", activity);
        intent.putExtra("weather1ID", weather1);
        intent.putExtra("TempID", temp);
        startActivity(intent);
    }

    /** Called when the user taps the Studying button */
    public void Mood4 (View view) {
        activity = 4;

        Intent intent = new Intent(this, PlayerActivity.class);
        intent.putExtra("Mood", "Studying");
        intent.putExtra("activityID", activity);
        intent.putExtra("weather1ID", weather1);
        intent.putExtra("TempID", temp);
        startActivity(intent);
    }

    /** Called when the user taps the Chilling button */
    public void Mood5 (View view) {
        activity = 5;

        Intent intent = new Intent(this, PlayerActivity.class);
        intent.putExtra("Mood", "Chilling");
        intent.putExtra("activityID", activity);
        intent.putExtra("weather1ID", weather1);
        intent.putExtra("TempID", temp);
        startActivity(intent);
    }

    /** Called when the user taps the Tune Me UP button */
    public void Mood6 (View view) {
        activity = 6;

        Intent intent = new Intent(this, PlayerActivity.class);
        intent.putExtra("Mood", "Tune-ing!");
        intent.putExtra("activityID", activity);
        intent.putExtra("weather1ID", weather1);
        intent.putExtra("TempID", temp);
        startActivity(intent);
    }
}
