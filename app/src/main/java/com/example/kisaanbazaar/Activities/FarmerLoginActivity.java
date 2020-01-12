package com.example.kisaanbazaar.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.kisaanbazaar.R;
import com.google.android.material.textfield.TextInputLayout;

public class FarmerLoginActivity extends AppCompatActivity {

    TextInputLayout til_aadhar_number;
    Button btn_send_otp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_login);
        til_aadhar_number = findViewById(R.id.til_aadhar_number);
        btn_send_otp = findViewById(R.id.btn_send_otp);
        btn_send_otp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String aadharNo = til_aadhar_number.getEditText().getText().toString().trim();
                if(aadharNo.equals("123412341234")){
                    startActivity(new Intent(FarmerLoginActivity.this, OtpVerificationActivity.class));
                }else{
                    Toast.makeText(FarmerLoginActivity.this, "Enter Valid Aadhar Number", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(FarmerLoginActivity.this, LoginActivity.class));
    }
}
