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
import com.example.kisaanbazaar.Handlers.JsonHandler;
import com.example.kisaanbazaar.Models.Product;
import com.example.kisaanbazaar.Models.Products;
import com.example.kisaanbazaar.R;

import java.util.ArrayList;
import java.util.List;

public class FavouritesFragment extends Fragment {

    private RecyclerView rv_favourite_products;
    private ProductAdapter productAdapter;
    private List<Products> products = new ArrayList<>();


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_favourites,container,false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rv_favourite_products = view.findViewById(R.id.rv_favourite_products);
        products = new JsonHandler(getContext()).getAllProducts();
        productAdapter = new ProductAdapter(getContext(),products,true);
        rv_favourite_products.setLayoutManager(new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false));
        rv_favourite_products.setAdapter(productAdapter);
    }
}
