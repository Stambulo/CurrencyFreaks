package com.stambulo.currencyfreaks.mvp.model;

import com.stambulo.currencyfreaks.mvp.model.entity.ServerRequest;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface IDataSource {

    @GET("/latest?apikey=46da9210321740d89f2d7f7f5977d15f&symbols=RUB,CNY,EUR,GBP")
    Single<ServerRequest> getRatesFromServer();
}
