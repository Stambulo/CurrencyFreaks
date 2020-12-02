package com.stambulo.currencyfreaks.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.stambulo.currencyfreaks.R;
import com.stambulo.currencyfreaks.mvp.presenter.GreetingPresenter;
import com.stambulo.currencyfreaks.mvp.view.GreetingView;
import com.stambulo.currencyfreaks.ui.BackButtonListener;

import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;

public class GreetingFragment extends MvpAppCompatFragment implements View.OnClickListener, GreetingView, BackButtonListener {
    private TextView tv_greeting;
    private Button btn_entrance;
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
        btn_entrance = view.findViewById(R.id.btn_entrance);
        btn_entrance.setOnClickListener(this);
        return view;
    }

    @Override
    public void onClick(View view) {
        Toast.makeText(getContext(), "<--- Button --->", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void init() {
    }

    @Override
    public boolean backPressed() {
        return greetingPresenter.backPressed();
    }
}
