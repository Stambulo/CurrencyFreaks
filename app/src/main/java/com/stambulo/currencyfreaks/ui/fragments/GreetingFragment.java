package com.stambulo.currencyfreaks.ui.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.stambulo.currencyfreaks.R;
import com.stambulo.currencyfreaks.mvp.presenter.GreetingPresenter;
import com.stambulo.currencyfreaks.mvp.view.GreetingView;
import com.stambulo.currencyfreaks.ui.BackButtonListener;

import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;

public class GreetingFragment extends MvpAppCompatFragment implements View.OnClickListener, GreetingView, BackButtonListener {
    private TextView tv_greeting;
    private Button btn_all_currencies;
    private ImageView dollar_image;
    private View view;

    @InjectPresenter
    GreetingPresenter greetingPresenter;

    public static GreetingFragment getInstance(int data) {
        GreetingFragment fragment = new GreetingFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key", data);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null) {
        }
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_greetings, container, false);
        tv_greeting = view.findViewById(R.id.welcome_text);
        dollar_image = view.findViewById(R.id.imageView);
        btn_all_currencies = view.findViewById(R.id.btn_all_currencies);
        btn_all_currencies.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        greetingPresenter.showCurrencies();
    }

    @Override
    public void init() {
    }

    @Override
    public boolean backPressed() {
        return greetingPresenter.backPressed();
    }
}
