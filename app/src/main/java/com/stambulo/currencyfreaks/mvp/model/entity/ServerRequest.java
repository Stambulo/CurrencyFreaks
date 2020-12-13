package com.stambulo.currencyfreaks.mvp.model.entity;

import com.google.gson.annotations.Expose;

public class ServerRequest {
    @Expose private String date;
    @Expose private String base;
    @Expose private CurrenciesArray rates;


    public String getDate() {
        return date;
    }

    public String getBase() {
        return base;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public CurrenciesArray getRates() {
        return rates;
    }

    public void setRates(CurrenciesArray rates) {
        this.rates = rates;
    }
}
