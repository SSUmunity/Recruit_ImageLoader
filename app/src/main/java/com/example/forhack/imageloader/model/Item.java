package com.example.forhack.imageloader.model;

import android.support.annotation.DrawableRes;

public class Item {
    @DrawableRes
    private int imageRes;
    private String title;

    public Item(int imageRes, String title) {
        this.imageRes = imageRes;
        this.title = title;
    }

    public int getImageRes() {
        return imageRes;
    }

    public String getTitle() {
        return title;
    }
}
