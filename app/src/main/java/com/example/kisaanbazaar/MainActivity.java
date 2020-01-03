package com.example.kisaanbazaar;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Handler h = new Handler();
        Runnable r = new Runnable() {
            @Override
            public void run() {
                Log.d(TAG, "run: We have waited 2 seconds");
                Intent i = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(i);
            }
        };
        h.postDelayed(r, 2000);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }
}
