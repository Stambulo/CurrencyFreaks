package com.stambulo.currencyfreaks.mvp.presenter.list;

import com.stambulo.currencyfreaks.mvp.view.list.IItemView;

public interface IListPresenter<V extends IItemView> {
    void onItemClick(V view);
    void bindView(V view);
    int getCount();
}
