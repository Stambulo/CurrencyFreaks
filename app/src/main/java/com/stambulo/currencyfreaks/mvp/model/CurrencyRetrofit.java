package com.stambulo.currencyfreaks.mvp.model;

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
        return api.getRatesFromServer().flatMap((rates) -> {
            return Single.fromCallable(() -> {


                RoomCurrencyRates ratesForRoom = new RoomCurrencyRates(
                        rates.getDate(), rates.getBase(), rates.getRates());


                // Запись
                db.currencyDAO().insert(ratesForRoom);


                ServerRequest dbRates = new ServerRequest();
                // Чтение
                RoomCurrencyRates ratesFromRoom = db.currencyDAO().getLastRates();
                dbRates.setDate(ratesFromRoom.getData());
                dbRates.setBase(ratesFromRoom.getBase());
                dbRates.setRates(ratesFromRoom.getRates());

                return dbRates;
//                return rates;
            });
        });
    }
}
