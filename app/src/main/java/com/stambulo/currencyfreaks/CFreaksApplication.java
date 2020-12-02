package com.stambulo.currencyfreaks;

import android.app.Application;

import com.stambulo.currencyfreaks.di.AppComponent;
import com.stambulo.currencyfreaks.di.DaggerAppComponent;
import com.stambulo.currencyfreaks.di.module.AppModule;

public class CFreaksApplication extends Application {
    public static CFreaksApplication INSTANCE;
    AppComponent appComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
    }

    public static CFreaksApplication getApplication() {return INSTANCE;}

    public AppComponent getAppComponent(){return appComponent;}
}
