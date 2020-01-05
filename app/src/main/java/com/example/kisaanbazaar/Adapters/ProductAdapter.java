package com.example.kisaanbazaar.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kisaanbazaar.Models.Product;
import com.example.kisaanbazaar.R;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    ArrayList<Product> products;

    public ProductAdapter(ArrayList<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_products, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder holder, int position) {
        final Product product = products.get(position);
        holder.tv_name.setText(product.getName());
        holder.tv_price.setText(product.getPrice()+(product.getInKg()? "/Kg" : product.getInLitres() ? "/Ltrs" : "/Dozen"));
        holder.iv_favourite.setImageResource(product.isFavourite() ? R.drawable.ic_red_heart : R.drawable.ic_favourite);
        holder.iv_favourite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(product.isFavourite()){
                    holder.iv_favourite.setImageResource(R.drawable.ic_favourite);
                    product.setFavourite(false);
                }else{
                    holder.iv_favourite.setImageResource(R.drawable.ic_red_heart);
                    product.setFavourite(true);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView tv_name, tv_price;
        ImageView iv_product, iv_favourite;
        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_name = itemView.findViewById(R.id.tv_name);
            tv_price = itemView.findViewById(R.id.tv_price);
            iv_product = itemView.findViewById(R.id.iv_product);
            iv_favourite = itemView.findViewById(R.id.iv_favourite);
        }
    }

}
