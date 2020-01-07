package com.example.kisaanbazaar.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.kisaanbazaar.R;

public class CategoryNameAdapter extends RecyclerView.Adapter<CategoryNameAdapter.CategoryViewHolder> {

    String[] categories;

    public CategoryNameAdapter(String[] categories) {
        this.categories = categories;
    }

    @NonNull
    @Override
    public CategoryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = li.inflate(R.layout.list_item_category_name, parent, false);
        return new CategoryViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CategoryViewHolder holder, int position) {
        String string = categories[position];
        holder.tv_category.setText(string);
    }

    @Override
    public int getItemCount() {
        return categories.length;
    }

    public class CategoryViewHolder extends RecyclerView.ViewHolder {
        TextView tv_category;
        public CategoryViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_category = itemView.findViewById(R.id.tv_category);
        }
    }
}

