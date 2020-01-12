package com.example.kisaanbazaar.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kisaanbazaar.Models.CartItem;
import com.example.kisaanbazaar.R;


import org.angmarch.views.NiceSpinner;
import org.angmarch.views.OnSpinnerItemSelectedListener;

import java.util.ArrayList;

public class CartItemAdapter extends RecyclerView.Adapter<CartItemAdapter.CartItemViewHolder> {
    Context context;
    ArrayList<CartItem> cartItems;

    public CartItemAdapter(Context context, ArrayList<CartItem> cartItems) {
        this.context = context;
        this.cartItems = cartItems;
    }

    @NonNull
    @Override
    public CartItemViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.list_item_cart, parent, false);
        return new CartItemViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final CartItemViewHolder holder, int position) {
        final CartItem cartItem = cartItems.get(position);
        holder.tv_product_name.setText(cartItem.getName());
        holder.tv_product_category.setText(cartItem.getCategory());
        holder.tv_available_offers.setText(cartItem.getNoOfOffersAvailable() + " Offers Available");
        holder.tv_price.setText(String.valueOf(cartItem.getPrice()));
        holder.tv_old_price.setText(String.valueOf(cartItem.getOldPrice()));
        holder.tv_days_for_delivery.setText("Delivery in " + cartItem.getDeliveryDays()+ " Days");
        holder.spinner_quantity.setOnSpinnerItemSelectedListener(new OnSpinnerItemSelectedListener() {
            @Override
            public void onItemSelected(NiceSpinner parent, View view, int position, long id) {
                cartItem.setQuantity(position+1);
            }
        });
    }

    @Override
    public int getItemCount() {
        return cartItems.size();
    }

    public class CartItemViewHolder extends RecyclerView.ViewHolder {
        NiceSpinner spinner_quantity;
        TextView tv_product_name, tv_product_category, tv_available_offers, tv_price, tv_old_price, tv_days_for_delivery, tv_info_for_extra_charges, tv_quantity;
        Button btn_checkout, btn_remove;
        ImageView iv_product;
        ArrayAdapter quantityAdapter;
        ArrayList<Integer> quantities;

        public CartItemViewHolder(@NonNull View itemView) {
            super(itemView);
            spinner_quantity = itemView.findViewById(R.id.spinner_quantity);
            tv_product_name = itemView.findViewById(R.id.tv_product_name);
            tv_product_category = itemView.findViewById(R.id.tv_product_category);
            tv_available_offers = itemView.findViewById(R.id.tv_available_offers);
            tv_price = itemView.findViewById(R.id.tv_price);
            tv_old_price = itemView.findViewById(R.id.tv_old_price);
            tv_days_for_delivery = itemView.findViewById(R.id.tv_days_for_delivery);
            tv_info_for_extra_charges = itemView.findViewById(R.id.tv_info_for_extra_charges);
            btn_checkout = itemView.findViewById(R.id.btn_checkout);
            btn_remove = itemView.findViewById(R.id.btn_remove);
            iv_product = itemView.findViewById(R.id.iv_product);
            quantities = new ArrayList<>();

            for(int i = 1; i < 1001; i++){
                quantities.add(i);
            }
            quantityAdapter = new ArrayAdapter(context, R.layout.spinner_text, quantities);
            spinner_quantity.setAdapter(quantityAdapter);
        }
    }
}
