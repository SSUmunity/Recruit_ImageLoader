package com.example.forhack.imageloader.util;


import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class ImageUtil {

    public static void loadUrlImage(ImageView imageView, String url) {
        Glide.with(imageView.getContext()).load(url).into(imageView);
    }
}
