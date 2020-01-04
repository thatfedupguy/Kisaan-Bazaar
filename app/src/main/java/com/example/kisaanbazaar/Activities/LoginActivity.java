package com.example.kisaanbazaar.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

import com.example.kisaanbazaar.Handlers.PreferenceHandler;
import com.example.kisaanbazaar.R;

import static com.example.kisaanbazaar.Utils.Constants.INITIAL_START;
import static com.example.kisaanbazaar.Utils.Constants.LOGIN_DONE;
import static com.example.kisaanbazaar.Utils.Constants.LOGIN_INCOMPLETE;
import static com.example.kisaanbazaar.Utils.Constants.LOGIN_SKIPPED;
import static com.example.kisaanbazaar.Utils.Constants.LOGIN_STATUS;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);


        RelativeLayout skipButton = findViewById(R.id.skip_buttonId);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceHandler handler = new PreferenceHandler(LoginActivity.this);
                handler.saveInt(LOGIN_STATUS,LOGIN_SKIPPED);
                startActivity(new Intent(LoginActivity.this,MainActivity.class));
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }
}
