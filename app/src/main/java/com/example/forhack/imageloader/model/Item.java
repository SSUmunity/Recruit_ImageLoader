package com.example.forhack.imageloader.model;

import android.support.annotation.DrawableRes;

public class Item {
    private String title;
    private String url;
    private String date;

    public Item(String title, String url, String date) {
        this.title = title;
        this.url = url;
        this.date = date;
    }

    public Item(){}

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }
}
