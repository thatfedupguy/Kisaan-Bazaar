package com.example.kisaanbazaar.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;
import androidx.core.content.ContextCompat;

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

    CardView farmer_loginId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            View decor = getWindow().getDecorView();
            decor.setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
            getWindow().setStatusBarColor(ContextCompat.getColor(this, R.color.white));
        }
        farmer_loginId = findViewById(R.id.farmer_loginId);
        RelativeLayout skipButton = findViewById(R.id.skip_buttonId);
        skipButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenceHandler handler = new PreferenceHandler(LoginActivity.this);
                handler.saveInt(LOGIN_STATUS,LOGIN_SKIPPED);
                startActivity(new Intent(LoginActivity.this,MainActivity.class));

            }
        });
        farmer_loginId.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, FarmerLoginActivity.class);
                startActivity(i);
            }
        });


    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }
}
