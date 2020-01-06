package com.example.kisaanbazaar.Fragments;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.kisaanbazaar.Adapters.OffersPagerAdapter;
import com.example.kisaanbazaar.Adapters.OffersRecyclerViewAdapter;
import com.example.kisaanbazaar.Models.OfferCard;
import com.example.kisaanbazaar.R;

import java.util.ArrayList;

import me.relex.circleindicator.CircleIndicator;


/**
 * A simple {@link Fragment} subclass.
 */
public class OffersFragment extends Fragment {

    private ViewPager view_pager_offers;
    private CircleIndicator circleIndicator;
    private OffersPagerAdapter offersPagerAdapter;
    private RecyclerView rv_offer_cards;
    private OffersRecyclerViewAdapter offersRecyclerViewAdapter;
    private ArrayList<OfferCard> offerCards;


    public OffersFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_special_offers, container, false);
        view_pager_offers  = view.findViewById(R.id.view_pager_offers);
        circleIndicator = view.findViewById(R.id.circle);
        rv_offer_cards = view.findViewById(R.id.rv_offer_cards);
        offerCards = new ArrayList<>();
        offersRecyclerViewAdapter = new OffersRecyclerViewAdapter(offerCards);
        offersPagerAdapter = new OffersPagerAdapter(getContext());
        rv_offer_cards.setLayoutManager(new GridLayoutManager(getContext(), 2, RecyclerView.VERTICAL,false));
        rv_offer_cards.setAdapter(offersRecyclerViewAdapter);
        view_pager_offers.setAdapter(offersPagerAdapter);
        circleIndicator.setViewPager(view_pager_offers);
        generateCards();
        return view;
    }

    private void generateCards(){
        for(int i = 0; i < 10; i++){
            OfferCard offerCard = new OfferCard("Gpay");
            offerCards.add(offerCard);
            offersRecyclerViewAdapter.notifyDataSetChanged();
        }
    }

}
