package com.example.kisaanbazaar.Activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import android.os.Bundle;
import android.util.Log;
import android.view.MenuItem;
import android.widget.Toast;
import com.example.kisaanbazaar.Fragments.CustomerServicesFragment;
import com.example.kisaanbazaar.Fragments.GiftCardsFragment;
import com.example.kisaanbazaar.Fragments.MainFragment;
import com.example.kisaanbazaar.Fragments.NotificationsFragment;
import com.example.kisaanbazaar.Fragments.OrdersFragment;
import com.example.kisaanbazaar.Fragments.SettingsFragment;
import com.example.kisaanbazaar.Handlers.JsonHandler;
import com.example.kisaanbazaar.Models.Account;
import com.example.kisaanbazaar.Models.Products;
import com.example.kisaanbazaar.R;
import com.google.android.material.navigation.NavigationView;

import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener {

    public static final String TAG = MainActivity.class.getSimpleName();
    public static DrawerLayout drawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setBackgroundColor(getResources().getColor(R.color.white));
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.setCheckedItem(R.id.navigation_main);
        displayView(R.id.navigation_main);

//        List<Products> productsList = new JsonHandler(this).getAllProducts();
//        Log.d(TAG, "onCreate: ProductsSize = " + productsList.size());
//        for (int i=0;i<productsList.size();i++){
//            Log.d(TAG, "onCreate: Product " + i + " = " + productsList.get(i).toString());
//        }

//        List<Account> accountList = new JsonHandler(this).getAllAccounts();
//        Log.d(TAG, "onCreate: ProductsSize = " + accountList.size());
//        for (int i=0;i<accountList.size();i++){
//            Log.d(TAG, "onCreate: Product " + i + " = " + accountList.get(i).toString());
//        }
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        moveTaskToBack(true);
    }

    public void displayView(int viewId) {
        Fragment fragment = null;
        switch (viewId) {
            case R.id.navigation_main:
                fragment = MainFragment.newInstance(R.id.navigation_main);
                break;
            case R.id.navigation_shop_by_category:
                fragment = MainFragment.newInstance(R.id.navigation_shop_by_category);
                break;
            case R.id.navigation_orders:
                fragment = new OrdersFragment();
                break;
            case R.id.navigation_special_offers:
                fragment = MainFragment.newInstance(R.id.navigation_special_offers);
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
