package com.example.kisaanbazaar.Fragments;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.example.kisaanbazaar.Adapters.CategoryNameAdapter;
import com.example.kisaanbazaar.Adapters.ProductAdapter;
import com.example.kisaanbazaar.Handlers.JsonHandler;
import com.example.kisaanbazaar.Models.Product;
import com.example.kisaanbazaar.Models.Products;
import com.example.kisaanbazaar.R;
import java.util.ArrayList;
import java.util.List;

public class HomeFragment extends Fragment {

    private RecyclerView rv_products, rv_categories;
    private ProductAdapter productAdapter;
    private List<Products> products = new ArrayList<>();
    private CategoryNameAdapter categoryNameAdapter;
    private String[] categories = {"Vegetables", "Grains", "Dairy", "Spices"};

    public HomeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);
        rv_products = view.findViewById(R.id.rv_products);
        rv_categories = view.findViewById(R.id.rv_product_category);
        products = new JsonHandler(getContext()).getAllProducts();

        productAdapter = new ProductAdapter(getContext(),products,false);
        categoryNameAdapter = new CategoryNameAdapter(categories);
        rv_categories.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.HORIZONTAL, false));
        rv_products.setLayoutManager(new GridLayoutManager(getContext(),2,RecyclerView.VERTICAL,false));
        rv_products.setAdapter(productAdapter);
        rv_categories.setAdapter(categoryNameAdapter);
        return view;
    }

}
