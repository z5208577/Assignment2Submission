package com.example.assignment2restarunt;

import android.content.Context;
import android.content.Intent;
import android.media.Image;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class WordListAdapter extends
        RecyclerView.Adapter<WordListAdapter.WordViewHolder>  {

    public static final String EXTRA_MESSAGE = "com.example.myfirstapp.MESSAGE";
    private final List<Restaurant> mWordList;
    private Context context;
    recyclerViewFragment.OnItemClicked onClick;

    private RecyclerViewClickListener mListener;
    private LayoutInflater mInflater;
    //Do the filtering here
    public WordListAdapter(Context context,
                           List<Restaurant> wordList, String filters) {
        mInflater = LayoutInflater.from(context);

        ArrayList<Restaurant> restaurants = Restaurant.getRestaurants();
        if(filters.contains("fast")){
            for(Iterator<Restaurant> itr = restaurants.iterator(); itr.hasNext();){
                Restaurant restaurant = itr.next();
                if(restaurant.getCuisine().equals("Fast Food")){
                    itr.remove();
                }
            }
        }
        if(filters.contains("thai")){
            for(Iterator<Restaurant> itr = restaurants.iterator(); itr.hasNext();){
                Restaurant restaurant = itr.next();
                if(restaurant.getCuisine().equals("Thai")){
                    itr.remove();
                }
            }
        }
        if(filters.contains("chicken")){
            for(Iterator<Restaurant> itr = restaurants.iterator(); itr.hasNext();){
                Restaurant restaurant = itr.next();
                if(restaurant.getCuisine().equals("Chicken")){
                    itr.remove();
                }
            }
        }
        if(filters.contains("italian")){
            for(Iterator<Restaurant> itr = restaurants.iterator(); itr.hasNext();){
                Restaurant restaurant = itr.next();
                if(restaurant.getCuisine().equals("Italian")){
                    itr.remove();
                }
            }
        }
        if(filters.contains("chinese")){
            for(Iterator<Restaurant> itr = restaurants.iterator(); itr.hasNext();){
                Restaurant restaurant = itr.next();
                if(restaurant.getCuisine().equals("Chinese")){
                    itr.remove();
                }
            }
        }
        if(filters.contains("hotpot")){
            for(Iterator<Restaurant> itr = restaurants.iterator(); itr.hasNext();){
                Restaurant restaurant = itr.next();
                if(restaurant.getCuisine().equals("Hotpot")){
                    itr.remove();
                }
            }
        }

        this.mWordList = restaurants;
    }
    public interface RecyclerViewClickListener {
        void onClick(View view, int position);
    }
    public WordListAdapter(Context context, ArrayList<Restaurant> resturants, RecyclerViewClickListener listener) {
        mInflater = LayoutInflater.from(context);
        mWordList = resturants;
        mListener = listener;
    }
    @NonNull
    @Override
    public WordListAdapter.WordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View mItemView = mInflater.inflate(R.layout.wordlist_item,
                parent, false);
        return new WordViewHolder(mItemView, this);
    }

    @Override
    public void onBindViewHolder(@NonNull WordListAdapter.WordViewHolder holder, int position) {
        final Restaurant mCurrent = mWordList.get(position);
        holder.name.setText(mCurrent.getName());
        holder.cuisine.setText(mCurrent.getCuisine());
        holder.address.setText((mCurrent.getAddress()));
        holder.rating.setText(Double.toString(mCurrent.getRating()));
        holder.restaurantPreview.setImageResource(mWordList.get(position).getImageResource());
    }

    @Override
    public int getItemCount() {
        return mWordList.size();
    }


    class WordViewHolder extends RecyclerView.ViewHolder
            implements View.OnClickListener {
        public final TextView name,cuisine,address,rating;
        public final ImageView restaurantPreview;

        final WordListAdapter mAdapter;

        public WordViewHolder(View itemView, WordListAdapter adapter) {
            super(itemView);
            name = itemView.findViewById(R.id.restName);
            cuisine = itemView.findViewById(R.id.restCuisine);
            address = itemView.findViewById(R.id.restAddress);
            rating = itemView.findViewById(R.id.restRating);
            restaurantPreview = itemView.findViewById(R.id.restaurantPreview);
            this.mAdapter = adapter;
            itemView.setOnClickListener(this);
        }
// the tablet boolean is tested here
        @Override
        public void onClick(View v) {
            String mPosition = name.getText().toString();
            AppCompatActivity activity = (AppCompatActivity) v.getContext();
            boolean tablet = activity.getWindow().getDecorView().getWidth() > 1500;
            if ( tablet) {
                Fragment fragment = new RestaurantDetailFragment();
                activity.getSupportFragmentManager().beginTransaction().replace(R.id.scrollViewDetail, fragment).addToBackStack(null).commit();

                Bundle bundle = new Bundle();
                bundle.putString(MainActivity.EXTRA_MESSAGE, mPosition);
                fragment.setArguments(bundle);
            } else {
                Restaurant element = Restaurant.getRestaurant(mPosition);
                Intent intent = new Intent(v.getContext(),RestaurantDetail.class);
                Restaurant message = element;
                intent.putExtra(EXTRA_MESSAGE, mPosition);
                v.getContext().startActivity(intent);
            }
        }
    }

    public void setOnClick(recyclerViewFragment.OnItemClicked onClick)
    {
        this.onClick=onClick;
    }
}

