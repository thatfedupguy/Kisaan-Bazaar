package com.example.kisaanbazaar.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.kisaanbazaar.R;

public class ProductsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product);

        TextView productName = findViewById(R.id.product_name);
        TextView productAddress = findViewById(R.id.product_address);
        ImageView backBurron = findViewById(R.id.menu_buttonId);

        Bundle bundle = getIntent().getExtras();
        if (bundle!=null){
            String name = bundle.getString("name");
            String address = bundle.getString("address");

            productName.setText(name);
            productAddress.setText(address);
        }

        backBurron.setOnClickListener(v -> onBackPressed());
    }
}
