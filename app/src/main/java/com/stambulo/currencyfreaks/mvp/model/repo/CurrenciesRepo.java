package com.stambulo.currencyfreaks.mvp.model.repo;

import android.util.Log;

import java.util.LinkedHashMap;
import java.util.Map;

public class CurrenciesRepo {
    private static Map<String, String> ratesMap = new LinkedHashMap<>();

    public void setRatesMap(Map<String, String> ratesMap){
        Log.i("--->", "setRatesMap: " + ratesMap.get("RUB"));
//        this.ratesMap = ratesMap;
    }

    public Map<String, String> getRatesMap(){
        return ratesMap;
    }
}
