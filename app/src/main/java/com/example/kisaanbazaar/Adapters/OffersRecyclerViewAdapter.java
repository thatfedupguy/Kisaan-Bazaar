package com.example.kisaanbazaar.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.kisaanbazaar.Models.OfferCard;
import com.example.kisaanbazaar.R;

import java.util.ArrayList;

public class OffersRecyclerViewAdapter extends RecyclerView.Adapter<OffersRecyclerViewAdapter.OffersViewHolder> {
    ArrayList<OfferCard> offerCards;

    public OffersRecyclerViewAdapter(ArrayList<OfferCard> offerCards) {
        this.offerCards = offerCards;
    }

    @NonNull
    @Override
    public OffersViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater li = (LayoutInflater) parent.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = li.inflate(R.layout.list_item_offer, parent, false);
        return new OffersViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OffersViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return offerCards.size();
    }

    public class OffersViewHolder extends RecyclerView.ViewHolder {
        ImageView iv_offer_card;
        public OffersViewHolder(@NonNull View itemView) {
            super(itemView);
            iv_offer_card = itemView.findViewById(R.id.iv_offer_card);
        }
    }
}
