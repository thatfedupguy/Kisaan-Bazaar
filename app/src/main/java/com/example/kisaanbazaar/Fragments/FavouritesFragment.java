package com.example.kisaanbazaar.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kisaanbazaar.Adapters.ProductAdapter;
import com.example.kisaanbazaar.Models.Product;
import com.example.kisaanbazaar.R;

import java.util.ArrayList;

public class FavouritesFragment extends Fragment {

    RecyclerView rv_favourite_products;
    ProductAdapter productAdapter;
    ArrayList<Product> products;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favourites,container,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv_favourite_products = view.findViewById(R.id.rv_favourite_products);
        products = new ArrayList<>();
        productAdapter = new ProductAdapter(products);
        rv_favourite_products.setLayoutManager(new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false));
        rv_favourite_products.setAdapter(productAdapter);
        generateProducts();
    }

    private void generateProducts(){
        for(int i = 0; i < 10; i++){
            Product product = new Product("Cauliflower", true, false, false, 40, true);
            products.add(product);
            productAdapter.notifyDataSetChanged();
        }
    }
}
