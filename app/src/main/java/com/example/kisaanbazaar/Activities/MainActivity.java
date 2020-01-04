package com.example.kisaanbazaar.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.kisaanbazaar.Fragments.CustomerServicesFragment;
import com.example.kisaanbazaar.Fragments.GiftCardsFragment;
import com.example.kisaanbazaar.Fragments.HomeFragment;
import com.example.kisaanbazaar.Fragments.NotificationsFragment;
import com.example.kisaanbazaar.Fragments.OrdersFragment;
import com.example.kisaanbazaar.Fragments.SettingsFragment;
import com.example.kisaanbazaar.Fragments.ShopByCategoryFragment;
import com.example.kisaanbazaar.Fragments.SpecialOffersFragment;
import com.example.kisaanbazaar.R;
import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    DrawerLayout drawerLayout;
    NavigationView navigationView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        displayView(R.id.navigation_home);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }

    public void displayView(int viewId) {
        Fragment fragment = null;
        switch (viewId) {
            case R.id.navigation_home:
                fragment = new HomeFragment();
                break;
            case R.id.navigation_shop_by_category:
                fragment = new ShopByCategoryFragment();
                break;
            case R.id.navigation_orders:
                fragment = new OrdersFragment();
                break;
            case R.id.navigation_special_offers:
                fragment = new SpecialOffersFragment();
                break;
            case R.id.navigation_gift_cards:
                fragment = new GiftCardsFragment();
                break;
            case R.id.navigation_notification:
                fragment = new NotificationsFragment();
                break;
            case R.id.navigation_customer_services:
                fragment = new CustomerServicesFragment();
                break;
            case R.id.navigation_settings:
                fragment = new SettingsFragment();
                break;
            case R.id.navigation_logout:
                Toast.makeText(this, "User Logged out Successfully!", Toast.LENGTH_SHORT).show();
                break;

        }
        if (fragment != null) {
            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
            ft.replace(R.id.content_frame, fragment);
            ft.commit();
        }
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerLayout.closeDrawer(GravityCompat.START);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        displayView(item.getItemId());
        return true;
    }


}
