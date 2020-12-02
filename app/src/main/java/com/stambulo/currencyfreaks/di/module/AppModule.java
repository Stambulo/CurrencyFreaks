package com.stambulo.currencyfreaks.di.module;

import com.stambulo.currencyfreaks.CFreaksApplication;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {
    private CFreaksApplication app;

    public AppModule(CFreaksApplication app) {this.app = app;}

    @Provides
    public CFreaksApplication app() {return app;}
}
