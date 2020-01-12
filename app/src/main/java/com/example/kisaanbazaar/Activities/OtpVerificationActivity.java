package com.example.kisaanbazaar.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kisaanbazaar.R;
import com.google.android.material.textfield.TextInputLayout;

public class OtpVerificationActivity extends AppCompatActivity {

    TextInputLayout til_otp;
    Button btn_continue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp_verification);
        til_otp = findViewById(R.id.til_otp);
        btn_continue = findViewById(R.id.btn_continue);
        btn_continue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String otp = til_otp.getEditText().getText().toString().trim();
                if(otp.equals("0000")){
                    startActivity(new Intent(OtpVerificationActivity.this, FarmerMainActivity.class));
                }else{
                    Toast.makeText(OtpVerificationActivity.this, "Enter Valid OTP" , Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(OtpVerificationActivity.this, FarmerLoginActivity.class));
    }
}
