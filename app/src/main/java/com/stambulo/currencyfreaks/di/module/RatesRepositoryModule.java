package com.stambulo.currencyfreaks.di.module;

import java.util.Map;
import java.util.TreeMap;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RatesRepositoryModule {
    private Map<String, String> ratesMap = new TreeMap<>();

    @Singleton
    @Provides
    public Map<String, String> getRates(){return ratesMap;}
}
