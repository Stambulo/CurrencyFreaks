package com.stambulo.currencyfreaks.di;

import com.stambulo.currencyfreaks.MainActivity;
import com.stambulo.currencyfreaks.di.module.AppModule;
import com.stambulo.currencyfreaks.di.module.CiceroneModule;
import com.stambulo.currencyfreaks.mvp.presenter.CurrenciesPresenter;
import com.stambulo.currencyfreaks.mvp.presenter.GreetingPresenter;
import com.stambulo.currencyfreaks.mvp.presenter.MainPresenter;

import javax.inject.Singleton;
import dagger.Component;

@Singleton
@Component(
        modules = {
                AppModule.class,
                CiceroneModule.class
        }
)

public interface AppComponent {
    void inject(MainActivity mainActivity);
    void inject(MainPresenter mainPresenter);
    void inject(GreetingPresenter greetingPresenter);
    void inject(CurrenciesPresenter currenciesPresenter);
}
