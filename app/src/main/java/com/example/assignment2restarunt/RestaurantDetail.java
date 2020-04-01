package com.example.assignment2restarunt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;

public class RestaurantDetail extends AppCompatActivity {
// similar to the week 5 submission
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resturant_detail);
        Intent intent = getIntent();
        String position = intent.getStringExtra((MainActivity.EXTRA_MESSAGE));

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = new RestaurantDetailFragment();
        Bundle bundle = new Bundle();
        bundle.putString(MainActivity.EXTRA_MESSAGE, position);
        fragment.setArguments(bundle);
        transaction.replace(R.id.ConstraintLayoutDetail,fragment);
        transaction.commit();
    }
}
