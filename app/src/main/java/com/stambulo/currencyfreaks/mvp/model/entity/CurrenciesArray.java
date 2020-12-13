package com.stambulo.currencyfreaks.mvp.model.entity;

import com.google.gson.annotations.Expose;
import com.stambulo.currencyfreaks.mvp.model.IRates;

import java.util.LinkedHashMap;
import java.util.Map;

public class CurrenciesArray {
    @Expose private String RUB;
    @Expose private String CNY;
    @Expose private String GBP;
    @Expose private String EUR;

    private Map<String,String> currenciesMap = new LinkedHashMap<String, String>();
    public Map<String, String> getCurrenciesMap(){
        currenciesMap.clear();
        currenciesMap.put("RUB", getRUB());
        currenciesMap.put("CNY", getCNY());
        currenciesMap.put("EUR", getEUR());
        currenciesMap.put("GBP", getGBP());
        return currenciesMap;
    }

    public String getRUB() {
        return RUB;
    }

    public void setRUB(String RUB) {
        this.RUB = RUB;
    }

    public String getCNY() {
        return CNY;
    }

    public void setCNY(String CNY) {
        this.CNY = CNY;
    }

    public String getGBP() {
        return GBP;
    }

    public void setGBP(String GBP) {
        this.GBP = GBP;
    }

    public String getEUR() {
        return EUR;
    }

    public void setEUR(String EUR) {
        this.EUR = EUR;
    }
}
