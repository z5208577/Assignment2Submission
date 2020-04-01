package com.example.assignment2restarunt;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.List;
/*
This is assignment 2 Submission: Top 10 Restaurants. Key functionalities include;
    -Displaying the name, cuisine, location and rating of 10 restauratnts (Required)
    -Phone Number, Directions/Location using google maps,Opening hours

 */

public class MainActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private static final String TAG =  "MainActivity";
    public TextView thai,fast,chicken,chinese,hotpot,italian,warning;
    private boolean excludeThai,excludeFast,excludeChicken,excludeChinese,excludeHotPot,excludeItalian;
    private final List<Restaurant> mWordList= Restaurant.getRestaurants();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("Hey Fork");
        warning = findViewById(R.id.warning);

        thai = findViewById(R.id.thaiFilter);
        thai.setText(getEmojii(0x1F372	) +" Thai");
        thai.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excludeThai = !excludeThai;
                initiate();
                if (excludeThai) {
                    thai.setBackgroundResource(R.drawable.rounded_corner_selected);
                } else {
                    thai.setBackgroundResource(R.drawable.rounded_corner);
                }
            }
        });

        fast = findViewById(R.id.fastFilter);
        fast.setText(getEmojii(0x1F35F	) +" Fast");
        fast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excludeFast = !excludeFast;
                initiate();
                if (excludeFast) {
                    fast.setBackgroundResource(R.drawable.rounded_corner_selected);
                } else {
                    fast.setBackgroundResource(R.drawable.rounded_corner);
                }
            }
        });

        chicken = findViewById(R.id.chickenFilter);
        chicken.setText(getEmojii(0x1F357	) +" Chicken");
        chicken.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excludeChicken = !excludeChicken;
                initiate();
                if (excludeChicken) {
                    chicken.setBackgroundResource(R.drawable.rounded_corner_selected);
                } else {
                    chicken.setBackgroundResource(R.drawable.rounded_corner);
                }
            }
        });

        chinese = findViewById(R.id.chineseFilter);
        chinese.setText(getEmojii(0x1F961) +" Chinese");
        chinese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excludeChinese = !excludeChinese;
                initiate();
                if (excludeChinese) {
                    chinese.setBackgroundResource(R.drawable.rounded_corner_selected);
                } else {
                    chinese.setBackgroundResource(R.drawable.rounded_corner);
                }
            }
        });

        hotpot = findViewById(R.id.hotpotFilter);
        hotpot.setText(getEmojii(0x1F35C) +" Hotpot");
        hotpot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excludeHotPot = !excludeHotPot;
                initiate();
                if (excludeHotPot) {
                    hotpot.setBackgroundResource(R.drawable.rounded_corner_selected);
                } else {
                    hotpot.setBackgroundResource(R.drawable.rounded_corner);
                }
            }
        });

        italian = findViewById(R.id.italianFilter);
        italian.setText(getEmojii(0x1F355) +" Italian");
        italian.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                excludeItalian = !excludeItalian;
                initiate();
                if (excludeItalian) {
                    italian.setBackgroundResource(R.drawable.rounded_corner_selected);
                } else {
                    italian.setBackgroundResource(R.drawable.rounded_corner);
                }
            }
        });

        //tablet is tested in the adapter
        initiate();
    }
    public String getEmojii(int unicode){
        return new String(Character.toChars(unicode));
    }

    public void initiate() {
        //the main activity is made up of a fragment similar to week 5 submission
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        Fragment fragment = new recyclerViewFragment();
        Bundle arguments = new Bundle();
        //pass the filter booleans
        String filters="";
        if(excludeChicken){filters += "chicken";}
        if(excludeChinese){filters += "chinese";}
        if(excludeFast){filters += "fast";}
        if(excludeHotPot){filters += "hotpot";}
        if(excludeItalian){filters += "italian";}
        if(excludeThai){filters += "thai";}
        arguments.putString("filters",filters);
        fragment.setArguments(arguments);
        transaction.replace(R.id.scrollViewMain,fragment);
        transaction.commit();
        if (excludeItalian && excludeThai && excludeFast && excludeHotPot && excludeChinese && excludeChicken){
            warning.setVisibility(View.VISIBLE);
        } else {
            warning.setVisibility(View.INVISIBLE);
        }
    }
}
