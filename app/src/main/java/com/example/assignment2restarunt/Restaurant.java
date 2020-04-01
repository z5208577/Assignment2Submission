package com.example.assignment2restarunt;

import android.content.Context;

import java.util.ArrayList;

public class Restaurant {
    private String name;
    private String cuisine;
    private String address;
    private double rating;
    private String weekdayHours;
    private String weekendHours;
    private String  telephone;
    private int imageResource;
    private Context context;


    public Restaurant(){}

    public Restaurant(String name, String cuisine, String address, double rating, String weekdayHours, String weekendHours, String telephone){
        this.name = name;
        this.cuisine = cuisine;
        this.address = address;
        this.rating = rating;
        this.weekdayHours = weekdayHours;
        this.weekendHours = weekendHours;
        this.telephone = telephone;
        //no database to set images so need to used a swtich statment and the res folder
        switch (name){
            case "Lidcombe McDonald's":
                this.imageResource = R.drawable.maccas;
                setImageResource(R.drawable.maccas);
                break;
            case "El Jannah's":
                this.imageResource = R.drawable.eljs;
                setImageResource(R.drawable.eljs);
                break;
            case "Q-Lounge":
                this.imageResource = R.drawable.qlounge;
                setImageResource(R.drawable.qlounge);
                break;
            case "Parramatta KFC":
                this.imageResource = R.drawable.kfc;
                setImageResource(R.drawable.kfc);
                break;
            case "Totti's":
                this.imageResource = R.drawable.tottie;
                setImageResource(R.drawable.tottie);
                break;
            case "Town Hall Hungry Jacks":
                this.imageResource = R.drawable.hj;
                setImageResource(R.drawable.hj);
                break;
            case "Chicken V":
                this.imageResource = R.drawable.chikn;
                setImageResource(R.drawable.chikn);
                break;
            case "ShanCheng Hotpot":
                this.imageResource = R.drawable.htpt;
                setImageResource(R.drawable.htpt);
                break;
            case "Noodle King":
                this.imageResource = R.drawable.ndl;
                setImageResource(R.drawable.ndl);
                break;
            default:
                this.imageResource = R.drawable.thai;
                setImageResource(R.drawable.thai);
        }
    }

    public static Restaurant searchCoin(String search){
        ArrayList<Restaurant> coins = getRestaurants();
        for(Restaurant coin : coins){
            if(coin.getName().equals(search)) {
                return coin;
            }
        }
        return null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuisine() {
        return cuisine;
    }

    public void setCuisine(String cuisine) {
        this.cuisine = cuisine;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public int getImageResource() {
        return imageResource;
    }

    public void setImageResource(int imageResource) {
        this.imageResource = imageResource;
    }

    public String getWeekdayHours() {
        return weekdayHours;
    }

    public void setWeekdayHours(String weekdayHours) {
        this.weekdayHours = weekdayHours;
    }

    public String getWeekendHours() {
        return weekendHours;
    }

    public void setWeekendHours(String weekendHours) {
        this.weekendHours = weekendHours;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public static ArrayList<Restaurant> getRestaurants() {
        ArrayList<Restaurant> restaurant = new ArrayList<>();
        restaurant.add(new Restaurant("Time For Thai", "Thai", "Aznac Parade, Randwick",4.5,"12:00pm - 9:00pm","10:00am - 10:00pm","0412345678"));
        restaurant.add(new Restaurant("Lidcombe McDonald's", "Fast Food", "Vaughan Street, Lidcombe",3.8,"12:00am - 12:00am","12:00am - 12:00am","0412312338"));
        restaurant.add(new Restaurant("El Jannah's", "Chicken", "South Street, Granville", 4.9,"10:00am - 8pm","10:00am - 10:00pm","0432345678"));
        restaurant.add(new Restaurant("Q-Lounge", "Fast Food", "UNSW Kensington", 3.6,"12:00pm - 6pm","CLOSED","0412399978"));
        restaurant.add(new Restaurant("Parramatta KFC", "Fast Food", "Church Street, Parramatta",5.0,"12:00am - 12:00am","12:00am - 12:00am","0412446781"));
        restaurant.add(new Restaurant("Totti's", "Italian", "Bondi Road, Bondi",4.6,"12:00pm - 9pm","10:00am - 10:00pm","0412345678"));
        restaurant.add(new Restaurant("Town Hall Hungry Jacks", "Fast Food", "The Galeries, Sydney",3.8,"12:00am - 12:00am","12:00am - 12:00am","0422225678"));
        restaurant.add(new Restaurant("Chicken V", "Chicken", "Sussex Street, Sydney", 2.0,"1:30pm - 9pm","3:00pm - 12:00pm","0412345678"));
        restaurant.add(new Restaurant("Noodle King", "Chinese", "Sussex Street, Sydney", 4.2,"4:30pm - 9pm","3:00pm - 12:00pm","0949945678"));
        restaurant.add(new Restaurant("ShanCheng Hotpot","Hotpot", "Sussex Street, Haymarket", 4.7,"5:00pm - 9pm","3:00pm - 12:00pm","0924345678"));
        return restaurant;
    }

    public static Restaurant getRestaurant(String name){
        ArrayList<Restaurant> restaurants = getRestaurants();
        for(Restaurant restaurant : restaurants){
            if (restaurant.getName().equalsIgnoreCase(name)){
                return restaurant;
            }
        }
        return null;
    }
}
