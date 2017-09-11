package com.example.forhack.imageloader.model;

import com.google.gson.Gson;

import java.util.Arrays;
import java.util.List;

public class Item {
    private String url, title, date;

    public Item(String url, String title, String date) {
        this.url = url;
        this.title = title;
        this.date = date;
    }

    public String getImageUrl() {
        return url;
    }

    public String getTitle() {
        return title;
    }

    public String getDate() {
        return date;
    }

    public static List<Item> fromJson(String response) {
        Item [] itemSet = new Gson().fromJson(response, Item[].class);
        List<Item> itemList = Arrays.asList(itemSet);

        return itemList;
    }

}
