package com.stambulo.currencyfreaks.mvp.presenter;

import com.stambulo.currencyfreaks.CFreaksApplication;
import com.stambulo.currencyfreaks.mvp.model.CurrencyRetrofit;
import com.stambulo.currencyfreaks.mvp.model.IRates;
import com.stambulo.currencyfreaks.mvp.presenter.list.IRateListPresenter;
import com.stambulo.currencyfreaks.mvp.view.CurrenciesView;
import com.stambulo.currencyfreaks.mvp.view.list.CurrencyItemView;
import com.stambulo.currencyfreaks.navigation.Screens;

import java.util.Map;

import javax.inject.Inject;

import moxy.MvpPresenter;
import ru.terrakok.cicerone.Router;

public class CurrenciesPresenter extends MvpPresenter<CurrenciesView> {
    private IRates rates = new CurrencyRetrofit(CFreaksApplication.INSTANCE.getApi());

    @Inject
    Router router;

    @Inject
    Map<String, String> ratesMap;

    public CurrenciesPresenter() {
        CFreaksApplication.INSTANCE.getAppComponent().inject(this);
    }


    private class RatesListPresenter implements IRateListPresenter {

        @Override
        public void onItemClick(CurrencyItemView view) {
        }

        @Override
        public void bindView(CurrencyItemView view) {
            String valuteName = ratesMap.keySet().toArray()[view.getPos()].toString();
            String valuteRate = ratesMap.get(valuteName);

            if (valuteRate.length() > 7){
                valuteRate = valuteRate.substring(0, 7);
            }

            view.setCurrencyRate(valuteRate);
            view.setCurrencyName(valuteName);
        }

        @Override
        public int getCount() {
            return ratesMap.size();
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
        getViewState().updateData();
    }

    public boolean backPressed() {
        router.navigateTo(new Screens.GreetingScreen());
        return true;
    }
}
