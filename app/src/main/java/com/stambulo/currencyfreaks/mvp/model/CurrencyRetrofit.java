package com.stambulo.currencyfreaks.mvp.model;

import com.stambulo.currencyfreaks.mvp.model.entity.CurrenciesArray;
import com.stambulo.currencyfreaks.mvp.model.entity.ServerRequest;
import com.stambulo.currencyfreaks.mvp.model.entity.room.Database;
import com.stambulo.currencyfreaks.mvp.model.entity.room.RoomCurrencyRates;

import io.reactivex.rxjava3.core.Single;

public class CurrencyRetrofit implements IRates {
    private IDataSource api;
    private Database db = Database.getInstance();

    public CurrencyRetrofit(IDataSource api) {
        this.api = api;
    }


    @Override
    public Single<ServerRequest> getRates() {
        return api.getRatesFromServer().flatMap((rates)->{
            return Single.fromCallable(()->{


                RoomCurrencyRates ratesForRoom = new RoomCurrencyRates(
                        rates.getDate(), rates.getBase(), rates.getRates().getRUB(),
                                                          rates.getRates().getCNY(),
                                                          rates.getRates().getEUR(),
                                                          rates.getRates().getGBP()
                );

                // Запись
                db.currencyDAO().insert(ratesForRoom);


                // Чтение
                RoomCurrencyRates ratesFromRoom = db.currencyDAO().getLastRates();
                rates.setDate(ratesFromRoom.getData());
                rates.setBase(ratesFromRoom.getBase());

                CurrenciesArray ca = new CurrenciesArray();
                ca.setRUB(ratesFromRoom.getRUB());
                ca.setCNY(ratesFromRoom.getCNY());
                ca.setEUR(ratesFromRoom.getEUR());
                ca.setGBP(ratesFromRoom.getGBP());
                rates.setRates(ca);

                return rates;
            });
        });
    }
}
