package com.stambulo.currencyfreaks.mvp.presenter;

import com.stambulo.currencyfreaks.CFreaksApplication;
import com.stambulo.currencyfreaks.mvp.view.GreetingView;

import javax.inject.Inject;

import moxy.MvpPresenter;
import ru.terrakok.cicerone.Router;

public class GreetingPresenter extends MvpPresenter<GreetingView> {

    @Inject
    Router router;

    public GreetingPresenter(){
        CFreaksApplication.INSTANCE.getAppComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        getViewState().init();
    }

    public boolean backPressed() {
        return true;
    }
}
