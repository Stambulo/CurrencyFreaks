package com.stambulo.currencyfreaks.mvp.presenter;

import android.util.Log;

import com.stambulo.currencyfreaks.CFreaksApplication;
import com.stambulo.currencyfreaks.mvp.model.CurrencyRetrofit;
import com.stambulo.currencyfreaks.mvp.model.IRates;
import com.stambulo.currencyfreaks.mvp.view.GreetingView;
import com.stambulo.currencyfreaks.navigation.Screens;

import java.util.Map;

import javax.inject.Inject;

import io.reactivex.rxjava3.schedulers.Schedulers;
import moxy.MvpPresenter;
import ru.terrakok.cicerone.Router;

public class GreetingPresenter extends MvpPresenter<GreetingView> {
    private IRates rates = new CurrencyRetrofit(CFreaksApplication.INSTANCE.getApi());

    @Inject
    Router router;

    @Inject
    Map<String, String> ratesMap;

    public GreetingPresenter(){
        CFreaksApplication.INSTANCE.getAppComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().init();
    }

    public void showCurrencies() {
        ratesMap.clear();
        getRates();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        router.replaceScreen(new Screens.CurrenciesScreen());
    }

    void getRates(){
        rates.getRates().observeOn(Schedulers.io()).subscribe(freshRates -> {
            ratesMap.clear();
            ratesMap.putAll(freshRates.getRates());
        }, (e) -> {
            Log.w("--->", "Error in getData - " + e.getMessage());
        });
    }

    public boolean backPressed() {
        return true;
    }
}
