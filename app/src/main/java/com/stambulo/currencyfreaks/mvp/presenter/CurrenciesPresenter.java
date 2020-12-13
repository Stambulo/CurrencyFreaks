package com.stambulo.currencyfreaks.mvp.presenter;

import android.util.Log;

import com.stambulo.currencyfreaks.CFreaksApplication;
import com.stambulo.currencyfreaks.mvp.model.CurrencyRetrofit;
import com.stambulo.currencyfreaks.mvp.model.IRates;
import com.stambulo.currencyfreaks.mvp.presenter.list.IRateListPresenter;
import com.stambulo.currencyfreaks.mvp.view.CurrenciesView;
import com.stambulo.currencyfreaks.mvp.view.list.AllCurrencyItemView;
import com.stambulo.currencyfreaks.navigation.Screens;

import java.util.LinkedHashMap;
import java.util.Map;

import javax.inject.Inject;

import moxy.MvpPresenter;
import ru.terrakok.cicerone.Router;

public class CurrenciesPresenter extends MvpPresenter<CurrenciesView> {
    private IRates rates = new CurrencyRetrofit(CFreaksApplication.INSTANCE.getApi());

    @Inject
    Router router;

    public CurrenciesPresenter() {
        CFreaksApplication.INSTANCE.getAppComponent().inject(this);
    }


    private class RatesListPresenter implements IRateListPresenter {
        private Map<String, String> ratesMap = new LinkedHashMap<>();

        @Override
        public void onItemClick(AllCurrencyItemView view) {
        }

        @Override
        public void bindView(AllCurrencyItemView view) {
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
//            Log.i("--->", "bindView: " + ratesMap.get("RUB"));
            switch (view.getPos()) {
                case 0:
                    view.setCurrencyRate(ratesMap.get("RUB"));
                    view.setCurrencyName("RUB");
                    break;
                case 1:
                    view.setCurrencyRate(ratesMap.get("CNY"));
                    view.setCurrencyName("CNY");
                    break;
                case 2:
                    view.setCurrencyRate(ratesMap.get("EUR"));
                    view.setCurrencyName("EUR");
                    break;
                case 3:
                    view.setCurrencyRate(ratesMap.get("GBP"));
                    view.setCurrencyName("GBP");
                    break;
            }
//            Log.i("--->", "Size: " + ratesMap.size());
        }

        @Override
        public int getCount() {
//            return ratesMap.size();
            return 4;
        }
    }

    private final RatesListPresenter ratesListPresenter = new RatesListPresenter();

    public RatesListPresenter getRatesListPresenter() {
        return ratesListPresenter;
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().init();
        loadData();
    }

    private void loadData() {
        rates.getRates().subscribe(freshRates -> {
            ratesListPresenter.ratesMap.clear();
            ratesListPresenter.ratesMap = freshRates.getRates().getCurrenciesMap();

//            Log.i("--->", "RUB - " + freshRates.getRates().getRUB());
//            Log.i("--->", "CNY - " + freshRates.getRates().getCNY());
//            Log.i("--->", "EUR - " + freshRates.getRates().getEUR());
//            Log.i("--->", "GBP - " + freshRates.getRates().getGBP());
            Thread.sleep(2000);
/**
 *      Здесь проблема !!!
 */
//            getViewState().updateData();
        }, (e) -> {
            Log.i("--->", "Error in getData - " + e.getMessage());
        });
    }

    public boolean backPressed() {
        router.navigateTo(new Screens.GreetingScreen());
        return true;
    }
}
