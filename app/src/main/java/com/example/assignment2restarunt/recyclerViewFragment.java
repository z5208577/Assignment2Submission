package com.example.assignment2restarunt;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class recyclerViewFragment extends Fragment {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private static final String TAG =  "MainActivity";
    private RecyclerView mRecyclerView;
    private WordListAdapter mAdapter;

    private final List<Restaurant> mWordList=Restaurant.getRestaurants();

    public recyclerViewFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_recycler_view, container, false);
        ArrayList<Restaurant> restaurants = Restaurant.getRestaurants();
        String filters = getArguments().getString("filters","");
        mRecyclerView = view.findViewById(R.id.recyclerview);
        mAdapter = new WordListAdapter(getContext(),restaurants,filters);
        mRecyclerView.setAdapter(mAdapter);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    public interface OnItemClicked {
        void onItemClick(int position);
    }




}
