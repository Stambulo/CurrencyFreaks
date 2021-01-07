package com.stambulo.currencyfreaks.mvp.model;

import com.stambulo.currencyfreaks.mvp.model.entity.ServerRequest;

import io.reactivex.rxjava3.core.Single;
import retrofit2.http.GET;

public interface IDataSource {

//    @GET("/latest?apikey=46da9210321740d89f2d7f7f5977d15f&symbols=RUB,CNY,EUR,GBP")
    @GET("/latest?apikey=46da9210321740d89f2d7f7f5977d15f")
    Single<ServerRequest> getRatesFromServer();
}


//        {
//        "date": "2020-12-13 00:06:00+00",
//        "base": "USD",
//        "rates": {
//                  "RUB": "73.15",
//                  "CNY": "6.5467",
//                  "EUR": "0.825655",
//                  "GBP": "0.756115"
//                  }
//        }
