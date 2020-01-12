package com.example.kisaanbazaar.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kisaanbazaar.Adapters.CategoryAdapter;
import com.example.kisaanbazaar.Models.Category;
import com.example.kisaanbazaar.R;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {

    RecyclerView rv_categories;
    CategoryAdapter categoryAdapter;
    ArrayList<Category> categories;


    public CategoryFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_category, container, false);

        rv_categories = view.findViewById(R.id.rv_categories);
        categories = new ArrayList<>();
        categoryAdapter = new CategoryAdapter(categories);
        rv_categories.setLayoutManager(new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL, false));
        rv_categories.setAdapter(categoryAdapter);
        generateCategories();

        return view;
    }

    private void generateCategories() {
        for(int i = 0; i <= 10; i++){
            Category category = new Category("Fresh Vegetables");
            categories.add(category);
            categoryAdapter.notifyDataSetChanged();
        }
    }

}
