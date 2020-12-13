package com.stambulo.currencyfreaks.mvp.view;

import moxy.MvpView;
import moxy.viewstate.strategy.alias.AddToEndSingle;

@AddToEndSingle
//@StateStrategyType(AddToEndSingleStrategy.class)
public interface CurrenciesView extends MvpView {
    void init();
    void updateData();
}
