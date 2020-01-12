package com.example.kisaanbazaar.Activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.MenuItem;

import com.example.kisaanbazaar.Fragments.AccountFragment;
import com.example.kisaanbazaar.Fragments.ChatsFragment;
import com.example.kisaanbazaar.Fragments.FarmerHomeFragment;
import com.example.kisaanbazaar.Fragments.FarmerProductFragment;
import com.example.kisaanbazaar.Fragments.HomeFragment;
import com.example.kisaanbazaar.Fragments.NewsFragment;
import com.example.kisaanbazaar.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class FarmerMainActivity extends AppCompatActivity {

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_farmer_main);
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottomNavigationId);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleMargin(50,0,0,0);
        replaceFragment(new FarmerHomeFragment());
        bottomNavigationView.setOnNavigationItemSelectedListener(onBottomNavigationItemSelectedListener);
    }
    private BottomNavigationView.OnNavigationItemSelectedListener onBottomNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){
                case R.id.homeId :
                    replaceFragment(new FarmerHomeFragment());
                    toolbar.setTitle("Kisaan Bazaar");
                    toolbar.setSubtitle("Rajpal Yadav");
                    break;
                case R.id.productId :
                    replaceFragment(new FarmerProductFragment());
                    toolbar.setTitle("Prodcuts");
                    toolbar.setSubtitle("");
                    break;
                case R.id.newsId :
                    replaceFragment(new NewsFragment());
                    toolbar.setTitle("News");
                    toolbar.setSubtitle("");
                    break;
                case R.id.chatsId:
                    replaceFragment(new ChatsFragment());
                    toolbar.setTitle("Chats");
                    toolbar.setSubtitle("");
                    break;
                case R.id.AccountId:
                    replaceFragment(new AccountFragment());
                    toolbar.setTitle("Account");
                    toolbar.setSubtitle("");
                    break;
            }
            return true;
        }
    };




    private void replaceFragment(final Fragment fragment){


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                transaction.replace(R.id.childFrameId, fragment);
                transaction.commitAllowingStateLoss();
                //transaction.commit();
            }
        },300);

    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startActivity(new Intent(FarmerMainActivity.this, FarmerLoginActivity.class));
    }
}
