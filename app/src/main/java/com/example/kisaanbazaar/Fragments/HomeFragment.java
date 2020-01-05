package com.example.kisaanbazaar.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

import com.example.kisaanbazaar.Adapters.CategoryAdapter;
import com.example.kisaanbazaar.Adapters.ProductAdapter;
import com.example.kisaanbazaar.Models.Product;
import com.example.kisaanbazaar.R;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    RecyclerView rv_products, rv_categories;
    ProductAdapter productAdapter;
    ArrayList<Product> products;
    CategoryAdapter categoryAdapter;
    String[] categories = {"Vegetables", "Grains", "Dairy", "Spices"};

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rv_products = view.findViewById(R.id.rv_products);
        rv_categories = view.findViewById(R.id.rv_product_category);
        products = new ArrayList<>();
        productAdapter = new ProductAdapter(products);
        categoryAdapter = new CategoryAdapter(categories);
        rv_categories.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        rv_products.setLayoutManager(new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false));
        rv_products.setAdapter(productAdapter);
        rv_categories.setAdapter(categoryAdapter);
        generateProducts();
        return view;
    }
    public void generateProducts(){
        for(int i = 0; i < 10; i++){
            Product product = new Product("Cauliflower", true, false, false, 40, false);
            products.add(product);
            productAdapter.notifyDataSetChanged();
        }
    }

}
