package com.example.kisaanbazaar.Fragments;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.view.GravityCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.kisaanbazaar.Activities.MainActivity;
import com.example.kisaanbazaar.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.mancj.materialsearchbar.MaterialSearchBar;

public class MainFragment extends Fragment {

    private static final String TAG = MainFragment.class.getSimpleName();
    private MaterialSearchBar searchBar;

    public static MainFragment newInstance(int id){
        MainFragment mainFragment = new MainFragment();
        Bundle args = new Bundle();
        args.putInt("id", id);
        mainFragment.setArguments(args);
        return mainFragment;
    }


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main,container,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        searchBar = view.findViewById(R.id.searchBar);
        BottomNavigationView bottomNavigationView = view.findViewById(R.id.bottomNavigationId);
        bottomNavigationView.setOnNavigationItemSelectedListener(onBottomNavigationItemSelectedListener);
        searchBar.setOnSearchActionListener(onSearchActionListener);
        Bundle bundle = getArguments();
        if (bundle !=null){
            int fragmentId = bundle.getInt("id");
//            Log.d(TAG, "onViewCreated: id=" + fragmentId);
            switch (fragmentId){
                case R.id.navigation_main:
                    replaceFragment(new HomeFragment());
                    bottomNavigationView.setSelectedItemId(R.id.homeId);
                    break;
                case R.id.navigation_shop_by_category:
                    replaceFragment(new CategoryFragment());
                    bottomNavigationView.setSelectedItemId(R.id.catId);
                    break;
                case R.id.navigation_special_offers:
                    replaceFragment(new OffersFragment());
                    bottomNavigationView.setSelectedItemId(R.id.offersId);
                    break;
            }
        }
    }


    private BottomNavigationView.OnNavigationItemSelectedListener onBottomNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
            switch (menuItem.getItemId()){

                case R.id.homeId :
                    replaceFragment(new HomeFragment());
                    searchBar.setPlaceHolder(getResources().getString(R.string.app_name));
                    break;
                case R.id.catId :
                    replaceFragment(new CategoryFragment());
                    searchBar.setPlaceHolder("Categories");
                    break;
                case R.id.offersId :
                    replaceFragment(new OffersFragment());
                    searchBar.setPlaceHolder("Offers");
                    break;
                case R.id.favId :
                    replaceFragment(new FavouritesFragment());
                    searchBar.setPlaceHolder("Favourites");
                    break;
                case R.id.cartId :
                    replaceFragment(new CartFragment());
                    searchBar.setPlaceHolder("My Cart");
                    break;
            }
            return true;
        }
    };


    private MaterialSearchBar.OnSearchActionListener onSearchActionListener
            = new MaterialSearchBar.OnSearchActionListener() {
        @Override
        public void onSearchStateChanged(boolean enabled) {
            Log.d(TAG, "onSearchStateChanged: " + enabled);
        }

        @Override
        public void onSearchConfirmed(CharSequence text) {
            Log.d(TAG, "onSearchConfirmed: " + text);
        }

        @Override
        public void onButtonClicked(int buttonCode) {
            Log.d(TAG, "onButtonClicked: " + buttonCode);
            switch (buttonCode){
                case 2:
                    MainActivity.drawerLayout.openDrawer(GravityCompat.START);
                    break;
                case 3:
                    searchBar.disableSearch();
                    break;
            }
        }
    };


    private void replaceFragment(final Fragment fragment){

        Log.d(TAG, "replaceFragment: Replaced " + fragment.getClass().getSimpleName());

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                FragmentManager manager = getChildFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.setCustomAnimations(R.anim.fade_in, R.anim.fade_out);
                transaction.replace(R.id.childFrameId, fragment);
                transaction.commitAllowingStateLoss();
                //transaction.commit();
            }
        },300);

    }
}
