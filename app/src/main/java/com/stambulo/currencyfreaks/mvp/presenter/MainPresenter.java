package com.stambulo.currencyfreaks.mvp.presenter;

import android.util.Log;

import io.reactivex.rxjava3.schedulers.Schedulers;
import moxy.MvpPresenter;
import com.stambulo.currencyfreaks.CFreaksApplication;
import com.stambulo.currencyfreaks.mvp.model.CurrencyRetrofit;
import com.stambulo.currencyfreaks.mvp.model.IRates;
import com.stambulo.currencyfreaks.mvp.view.MainView;
import com.stambulo.currencyfreaks.navigation.Screens;

import java.util.Map;

import javax.inject.Inject;

import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.Router;

public class MainPresenter extends MvpPresenter<MainView> {
    private IRates rates = new CurrencyRetrofit(CFreaksApplication.INSTANCE.getApi());

    @Inject
    Router router;

    @Inject
    Map<String, String> ratesMap;

    public MainPresenter(){
        super();
        CFreaksApplication.INSTANCE.getAppComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getRates();
        router.replaceScreen(new Screens.GreetingScreen());
    }

    void getRates(){
        rates.getRates().observeOn(Schedulers.io()).subscribe(freshRates -> {
            ratesMap.clear();
            ratesMap.putAll(freshRates.getRates());
        }, (e) -> {
            Log.w("--->", "Error in getData - " + e.getMessage());
        });
    }

    public void backClicked() {
        router.exit();
    }
}
