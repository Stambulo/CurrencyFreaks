package com.stambulo.currencyfreaks.navigation;

import androidx.fragment.app.Fragment;

import com.stambulo.currencyfreaks.ui.fragments.GreetingFragment;

import ru.terrakok.cicerone.android.support.SupportAppScreen;

public class Screens {

    public static class GreetingScreen extends SupportAppScreen{
        @Override
        public Fragment getFragment() {
            return GreetingFragment.getInstance(0);
        }
    }
}
