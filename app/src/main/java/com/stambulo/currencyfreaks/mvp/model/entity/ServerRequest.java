package com.stambulo.currencyfreaks.mvp.model.entity;

import com.google.gson.annotations.Expose;

import java.util.Map;

public class ServerRequest {
    @Expose private String date;
    @Expose private String base;
    @Expose private Map<String, String> rates;

    public Map<String, String> getRates() {return rates;}

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

    public void setRates(Map<String, String> rates) {this.rates = rates;}
}
