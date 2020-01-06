package com.example.kisaanbazaar.Fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kisaanbazaar.Adapters.CartItemAdapter;
import com.example.kisaanbazaar.Models.CartItem;
import com.example.kisaanbazaar.R;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class CartFragment extends Fragment {

    RecyclerView rv_cart_items;
    CartItemAdapter cartItemAdapter;
    ArrayList<CartItem> cartItems;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_cart,container,false);
        rv_cart_items = view.findViewById(R.id.rv_cart_items);
        cartItems = new ArrayList<>();
        cartItemAdapter = new CartItemAdapter(getContext(), cartItems);
        rv_cart_items.setLayoutManager(new LinearLayoutManager(getContext(), RecyclerView.VERTICAL, false));
        rv_cart_items.setAdapter(cartItemAdapter);
        generateCartItems();
        return view;
    }

    private void generateCartItems(){
        for(int i = 0; i < 10; i++){
            CartItem cartItem = new CartItem("Cauliflower", "Fresh Vegetables", true, false, false,
                    10000, 11000, 6, 300, 5, false);
            cartItems.add(cartItem);
            cartItemAdapter.notifyDataSetChanged();
        }
    }

}
