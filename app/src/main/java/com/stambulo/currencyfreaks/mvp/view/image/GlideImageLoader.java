package com.stambulo.currencyfreaks.mvp.view.image;

import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class GlideImageLoader implements IImageLoader<ImageView>{
    @Override
    public void loadImage(String url, ImageView container) {
        Glide.with(container.getContext()).load(url).into(container);
    }
}
