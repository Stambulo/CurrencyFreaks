package com.stambulo.currencyfreaks.mvp.model;

import android.util.Log;

import com.stambulo.currencyfreaks.mvp.model.entity.ServerRequest;
import com.stambulo.currencyfreaks.mvp.model.entity.room.Database;
import com.stambulo.currencyfreaks.mvp.model.entity.room.RoomCurrencyRates;
import com.stambulo.currencyfreaks.mvp.model.network.INetworkStatus;
import com.stambulo.currencyfreaks.ui.network.AndroidNetworkStatus;

import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class CurrencyRetrofit implements IRates {
    private IDataSource api;
    private Database db = Database.getInstance();

    private INetworkStatus networkStatus = new AndroidNetworkStatus();

    public CurrencyRetrofit(IDataSource api) {
        this.api = api;
    }


    @Override
    public Single<ServerRequest> getRates() {
        return networkStatus.isOnlineSingle().flatMap((isOnline) -> {

            if (isOnline) {
                Log.i("--->", "isOnline");
                return api.getRatesFromServer().flatMap((rates) -> {
                    return Single.fromCallable(() -> {


                        RoomCurrencyRates ratesForRoom = new RoomCurrencyRates(
                                rates.getDate(), rates.getBase(), rates.getRates());


                        // Запись
                        db.currencyDAO().insert(ratesForRoom);

                return rates;
                    });
                });

            } else {
                Log.i("--->", "is NOT Online");

                    return Single.fromCallable(() -> {

                        ServerRequest dbRates = new ServerRequest();
                        // Чтение
                        RoomCurrencyRates ratesFromRoom = db.currencyDAO().getLastRates();
                        dbRates.setDate(ratesFromRoom.getData());
                        dbRates.setBase(ratesFromRoom.getBase());
                        dbRates.setRates(ratesFromRoom.getRates());

                        return dbRates;
                    });
            }
        }).subscribeOn(Schedulers.io());
    }
}