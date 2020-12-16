package com.stambulo.currencyfreaks.mvp.model.entity.room;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class RoomCurrencyRates {

    @PrimaryKey
    @NonNull
    public String base;
    public String data;
    public String RUB;
    public String CNY;
    public String EUR;
    public String GBP;

    public RoomCurrencyRates(String data, String base,
                             String RUB, String CNY, String EUR, String GBP){
        this.data = data;
        this.base = base;
        this.RUB = RUB;
        this.CNY = CNY;
        this.EUR = EUR;
        this.GBP = GBP;
    }

    @NonNull
    public String getData() {
        return data;
    }

    public String getBase() {
        return base;
    }

    public String getRUB() {
        return RUB;
    }

    public String getCNY() {
        return CNY;
    }

    public String getEUR() {
        return EUR;
    }

    public String getGBP() {
        return GBP;
    }
}
