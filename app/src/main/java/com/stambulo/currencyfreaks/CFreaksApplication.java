package com.stambulo.currencyfreaks;

import android.app.Application;
import android.util.Log;

import com.stambulo.currencyfreaks.di.AppComponent;
import com.stambulo.currencyfreaks.di.DaggerAppComponent;
import com.stambulo.currencyfreaks.di.module.AppModule;
import com.stambulo.currencyfreaks.mvp.model.IDataSource;

import io.reactivex.rxjava3.plugins.RxJavaPlugins;

public class CFreaksApplication extends Application {
    public static CFreaksApplication INSTANCE;
    AppComponent appComponent;
    private ApiHolder apiHolder;

    @Override
    public void onCreate() {
        super.onCreate();
        INSTANCE = this;
        appComponent = DaggerAppComponent.builder().appModule(new AppModule(this)).build();
        apiHolder = new ApiHolder();

        RxJavaPlugins.setErrorHandler(throwable -> {
            Log.i("--->", "Rx Error: " + throwable.getMessage());});
    }

    public static CFreaksApplication getApplication() {return INSTANCE;}

    public AppComponent getAppComponent(){return appComponent;}

    public ApiHolder getApiHolder(){
        return apiHolder;
    }

    public IDataSource getApi() {
        return apiHolder.getDataSource();
    }
}
