package com.example.kisaanbazaar.Adapters;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.kisaanbazaar.Models.Products;
import com.example.kisaanbazaar.R;
import java.util.List;

import static com.example.kisaanbazaar.Utils.Constants.ADDRESS_STATE;
import static com.example.kisaanbazaar.Utils.Constants.ADRRESS_DISTRICT;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private static final String TAG = ProductAdapter.class.getSimpleName();
    private OnItemClickListener onItemClickListener;
    private List<Products> products;
    private boolean isFavourite;
    private Context mContext;

    public ProductAdapter(Context mContext, List<Products> products, boolean isFavourite) {
        this.mContext = mContext;
        this.products = products;
        this.isFavourite = isFavourite;
    }


    public interface OnItemClickListener {
        void OnItemClick(int position);
        void OnItemLongClick(int position);
    }


    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView = inflater.inflate(R.layout.list_item_products, parent, false);
        return new ProductViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder holder, int position) {
        Products product = products.get(position);
        Log.d(TAG, "onBindViewHolder: url = " + product.getThumbnail());
//        Glide.with(mContext)
//                .load(product.getThumbnail())
//                .apply(new RequestOptions()
//                    .centerCrop())
//                .into(holder.iv_product);
        if (isFavourite){
            holder.iv_favourite.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ic_red_heart));
        }
        holder.tv_name.setText(product.getName());
        holder.tv_price.setText(product.getPrice() + "/" + product.getQuantity_type());
        holder.tv_address.setText(product.getAddress().get(ADRRESS_DISTRICT) + ", "  + product.getAddress().get(ADDRESS_STATE));
        //holder.iv_favourite.setImageResource(product.isFavourite() ? R.drawable.ic_red_heart : R.drawable.ic_favourite);
//        holder.iv_favourite.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                if(product.isFavourite()){
//                    holder.iv_favourite.setImageResource(R.drawable.ic_favourite);
//                    product.setFavourite(false);
//                }else{
//                    holder.iv_favourite.setImageResource(R.drawable.ic_red_heart);
//                    product.setFavourite(true);
//                }
//            }
//        });
    }

    class ProductViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        TextView tv_name, tv_price ,tv_address;
        ImageView iv_product, iv_favourite;
        CardView like_button;

        ProductViewHolder(@NonNull View itemView) {
            super(itemView);

            itemView.setOnClickListener(this);
            itemView.setOnLongClickListener(this);
            tv_name = itemView.findViewById(R.id.product_name);
            tv_price = itemView.findViewById(R.id.product_price);
            tv_address = itemView.findViewById(R.id.product_address);
            iv_product = itemView.findViewById(R.id.iv_product);
            iv_favourite = itemView.findViewById(R.id.favourite_image);
            like_button = itemView.findViewById(R.id.like_button);
        }

        @Override
        public void onClick(View v) {
            onItemClickListener.OnItemClick(this.getLayoutPosition());
        }

        @Override
        public boolean onLongClick(View v) {
            onItemClickListener.OnItemLongClick(this.getLayoutPosition());
            return false;
        }
    }


    @Override
    public int getItemCount() {
        return products.size();
    }

}
