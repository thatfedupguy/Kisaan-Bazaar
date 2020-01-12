package com.example.kisaanbazaar.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kisaanbazaar.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class FarmerHomeFragment extends Fragment {


    public FarmerHomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_farmer_home, container, false);
    }

}
