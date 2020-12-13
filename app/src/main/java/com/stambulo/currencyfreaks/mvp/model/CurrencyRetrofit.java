package com.stambulo.currencyfreaks.mvp.model;

import com.stambulo.currencyfreaks.mvp.model.entity.ServerRequest;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CurrencyRetrofit implements IRates{
    private IDataSource api;

    public CurrencyRetrofit(IDataSource api){this.api = api;}

    @Override
    public Single<ServerRequest> getRates() {
        return api.getRatesFromServer().subscribeOn(Schedulers.io());
    }
}
