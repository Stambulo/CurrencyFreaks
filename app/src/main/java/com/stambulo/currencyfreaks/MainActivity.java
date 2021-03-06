package com.stambulo.currencyfreaks;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import com.stambulo.currencyfreaks.mvp.presenter.MainPresenter;
import com.stambulo.currencyfreaks.mvp.view.MainView;
import com.stambulo.currencyfreaks.ui.BackButtonListener;

import javax.inject.Inject;

import moxy.MvpAppCompatActivity;
import moxy.presenter.InjectPresenter;
import ru.terrakok.cicerone.Navigator;
import ru.terrakok.cicerone.NavigatorHolder;
import ru.terrakok.cicerone.android.support.SupportAppNavigator;

public class MainActivity extends MvpAppCompatActivity implements MainView {

    @InjectPresenter
    MainPresenter presenter;

    @Inject
    NavigatorHolder navigatorHolder;

    private Navigator navigator = new SupportAppNavigator(this, getSupportFragmentManager(),
            R.id.container);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        CFreaksApplication.INSTANCE.getAppComponent().inject(this);
    }

    @Override
    protected void onResumeFragments() {
        super.onResumeFragments();
        navigatorHolder.setNavigator(navigator);
    }

    @Override
    protected void onPause() {
        super.onPause();
        navigatorHolder.removeNavigator();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        for (Fragment fragment : getSupportFragmentManager().getFragments()){
            if (fragment instanceof BackButtonListener && ((BackButtonListener) fragment).backPressed()){
                return;
            }
        }
        presenter.backClicked();
    }
}
