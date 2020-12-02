package com.stambulo.currencyfreaks.mvp.presenter;

import moxy.MvpPresenter;
import com.stambulo.currencyfreaks.CFreaksApplication;
import com.stambulo.currencyfreaks.mvp.view.MainView;
import com.stambulo.currencyfreaks.navigation.Screens;

import javax.inject.Inject;

import ru.terrakok.cicerone.Router;

public class MainPresenter extends MvpPresenter<MainView> {

    @Inject
    Router router;

    public MainPresenter(){
        super();
        CFreaksApplication.INSTANCE.getAppComponent().inject(this);
    }

    @Override
    protected void onFirstViewAttach() {
        super.onFirstViewAttach();
        router.replaceScreen(new Screens.GreetingScreen());
    }

    public void backClicked() {router.exit();}
}
