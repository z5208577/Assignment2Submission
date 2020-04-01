package com.example.assignment2restarunt;

import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.SpannableString;
import android.text.style.UnderlineSpan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.NumberFormat;
import java.util.Calendar;

public class RestaurantDetailFragment extends Fragment {
    private Restaurant mRestaurant;
    private TextView name, cuisine, address, rating, hours,phone;
    public RestaurantDetailFragment() {
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_resturant_detail,container,false);


        String position = getArguments().getString(MainActivity.EXTRA_MESSAGE);

        mRestaurant = Restaurant.getRestaurant(position);

        NumberFormat formatter = NumberFormat.getCurrencyInstance();
        getActivity().setTitle(mRestaurant.getName());

        LinearLayout layout = (LinearLayout) view.findViewById(R.id.linear);
        for (int i = 0; i < 3; i++) {
            ImageView imageView = new ImageView(getContext());
            imageView.setId(i);
            imageView.setPadding(2, 2, 2, 2);
            imageView.setImageBitmap(BitmapFactory.decodeResource(
                    getResources(), mRestaurant.getImageResource()));

            imageView.setMaxWidth(50);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);

            layout.addView(imageView);
        }
        name = view.findViewById(R.id.restName);
        name.setText(mRestaurant.getName());

        cuisine = view.findViewById(R.id.restCuisine);
        cuisine.setText(mRestaurant.getCuisine());

        address = view.findViewById(R.id.restAddress);
        //to underline
        SpannableString content = new SpannableString(mRestaurant.getAddress());
        content.setSpan(new UnderlineSpan(), 0, content.length(), 0);
        address.setText(content);
        address.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchAddress(mRestaurant.getAddress(),mRestaurant.getName());
            }
        });

        ImageView mapIcon = view.findViewById(R.id.imageView);
        mapIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchAddress(mRestaurant.getAddress(),mRestaurant.getName());
            }
        });

        rating = view.findViewById(R.id.restRating);
        rating.setText(Double.toString(mRestaurant.getRating()) + "/5");

        Calendar c1 = Calendar.getInstance();
        if (c1.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY ||
                c1.get(Calendar.DAY_OF_WEEK) == Calendar.SUNDAY){
            hours = view.findViewById(R.id.restHours);
            hours.setText(mRestaurant.getWeekendHours());
        }
        else {
            hours = view.findViewById(R.id.restHours);
            hours.setText(mRestaurant.getWeekdayHours());
        }

        phone = view.findViewById(R.id.restPhone);
        //to underline
        SpannableString content2 = new SpannableString(mRestaurant.getTelephone());
        content2.setSpan(new UnderlineSpan(), 0, content2.length(), 0);
        phone.setText(content2);
        phone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callPhone(mRestaurant.getTelephone());
            }
        });

        TextView menu = view.findViewById(R.id.menu);
        SpannableString content3 = new SpannableString("View the Menu");
        content3.setSpan(new UnderlineSpan(), 0, content3.length(), 0);
        menu.setText(content3);
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                searchResturant(mRestaurant.getName());
            }
        });

        return view;
    }
    //Menu Button
    public void searchResturant(String name) {
        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.google.com/search?q=" + name + " menu"));
        startActivity(intent);
    }
    //map location
    public void searchAddress(String address, String name) {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=" + name + " " + address);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    public void callPhone(String phone) {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse(phone));
        startActivity(intent);
    }
}
