package com.stambulo.currencyfreaks.mvp.model;

import com.stambulo.currencyfreaks.mvp.model.entity.ServerRequest;

import io.reactivex.rxjava3.core.Single;

public interface IRates {
    Single<ServerRequest> getRates();
}
