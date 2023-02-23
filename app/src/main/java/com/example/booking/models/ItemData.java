package com.example.booking.models;

import androidx.annotation.NonNull;

import com.example.booking.R;

import java.util.ArrayList;

public class ItemData {
    public static ArrayList<Item> orders = new ArrayList<>();

    @NonNull
    public static ArrayList<Item> getList() {
        ArrayList<Item> per = new ArrayList<>();
        per.add(new Item("USA. \n" +
                "Tour dates: from 01.03 to 06.03\n" +
                "Duration: 5 nights in Standard\n" +
                "Meals: All inclusive\n" +
                "Tourists: 1 adult\n" +
                "Flight included", 1500, R.drawable.usaa));
        per.add(new Item("Barcelona.\n" +
                "UAI-Ultra all inclusive\n" +
                "\n" +
                "In the room\n" +
                "Imported beer, soft drinks, chocolate, chips (on arrival)\n" +
                "Fruit basket and cookies (upon arrival)\n" +
                "nutrition\n" +
                "One special dish according to the proposed menu", 800, R.drawable.barcelona));
        per.add(new Item("Japan\n" +
                "Tour dates: from 01.03 to 06.03\n" +
                "Duration: 5 nights in Standard\n" +
                "Meals: All inclusive\n" +
                "Tourists: 1 adult\n" +
                "Flight included", 900, R.drawable.japan));
        per.add(new Item("Korea\n" +
                "Tour dates: from 01.03 to 06.03\n" +
                "Duration: 5 nights in Standard\n" +
                "Meals: All inclusive\n" +
                "Tourists: 1 adult\n" +
                "Flight included", 700, R.drawable.korea));
        per.add(new Item("France\n" +
                "Tour dates: from 01.03 to 06.03\n" +
                "Duration: 5 nights in Standard\n" +
                "Meals: All inclusive\n" +
                "Tourists: 1 adult\n" +
                "Flight included", 800, R.drawable.france));
        per.add(new Item("Canada\n" +
                "Tour dates: from 01.03 to 06.03\n" +
                "Duration: 5 nights in Standard\n" +
                "Meals: All inclusive\n" +
                "Tourists: 1 adult\n" +
                "Flight included", 700, R.drawable.canada));

        return per;
    }


    @NonNull
    public static ArrayList<Item> getListOrder() {
        return orders;
    }

}