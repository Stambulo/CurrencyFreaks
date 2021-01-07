package com.stambulo.currencyfreaks.mvp.model.entity.room;

import androidx.annotation.NonNull;
import androidx.room.Entity;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverter;
import androidx.room.TypeConverters;

import com.stambulo.currencyfreaks.mvp.model.CurrencyRetrofit;

import java.util.Map;

@Entity
public class RoomCurrencyRates {

    @PrimaryKey
    @NonNull
    public String base;
    public String data;

    @TypeConverters({RoomConverter.class})
    public Map<String, String> rates;

    public RoomCurrencyRates(String data, String base, Map<String, String> rates){
        this.data = data;
        this.base = base;
        this.rates = rates;
    }

    @NonNull
    public String getData() {
        return data;
    }

    public String getBase() {
        return base;
    }

    public Map<String, String> getRates() {return rates; }
}
