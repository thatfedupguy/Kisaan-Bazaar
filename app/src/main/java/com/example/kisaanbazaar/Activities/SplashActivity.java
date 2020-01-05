package com.example.kisaanbazaar.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.kisaanbazaar.Handlers.PreferenceHandler;
import com.example.kisaanbazaar.R;

import static com.example.kisaanbazaar.Utils.Constants.INITIAL_START;
import static com.example.kisaanbazaar.Utils.Constants.LOGIN_DONE;
import static com.example.kisaanbazaar.Utils.Constants.LOGIN_INCOMPLETE;
import static com.example.kisaanbazaar.Utils.Constants.LOGIN_SKIPPED;
import static com.example.kisaanbazaar.Utils.Constants.LOGIN_STATUS;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final PreferenceHandler handler = new PreferenceHandler(this);
        int status = handler.getInt(LOGIN_STATUS);
        switch (status){
            case INITIAL_START:
                startActivity(new Intent(this,LoginActivity.class));
                break;
            case LOGIN_DONE:
            case LOGIN_SKIPPED:
                startActivity(new Intent(this,MainActivity.class));
                break;
            case LOGIN_INCOMPLETE:
                //TODO : Incomplete Login Flow comes here...
                break;
        }
        finish();
    }
}
