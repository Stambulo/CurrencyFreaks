package com.stambulo.currencyfreaks.mvp.view.image;

public interface IImageLoader<T> {
    void loadImage(String url, T container);
}
