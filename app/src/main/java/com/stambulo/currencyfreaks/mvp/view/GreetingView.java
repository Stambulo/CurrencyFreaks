package com.stambulo.currencyfreaks.mvp.view;

import moxy.MvpView;
import moxy.viewstate.strategy.alias.AddToEndSingle;

@AddToEndSingle
public interface GreetingView extends MvpView {
    void init();
}
