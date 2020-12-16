package com.stambulo.currencyfreaks.ui.fragments;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.stambulo.currencyfreaks.R;
import com.stambulo.currencyfreaks.mvp.presenter.CurrenciesPresenter;
import com.stambulo.currencyfreaks.mvp.view.CurrenciesView;
import com.stambulo.currencyfreaks.ui.BackButtonListener;
import com.stambulo.currencyfreaks.ui.adapter.AllRVAdapter;

import moxy.MvpAppCompatFragment;
import moxy.presenter.InjectPresenter;
import moxy.presenter.ProvidePresenter;

public class CurrenciesFragment extends MvpAppCompatFragment implements CurrenciesView, BackButtonListener {
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView recyclerView;
    private AllRVAdapter adapter;
    private View view;

    @InjectPresenter
    CurrenciesPresenter currenciesPresenter;

    public static Fragment getInstance(int i) {
        Fragment fragment = new CurrenciesFragment();
        Bundle bundle = new Bundle();
        bundle.putInt("key", i);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle bundle = getArguments();
        if (bundle != null){}
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_all_currencies, container, false);
        recyclerView = view.findViewById(R.id.rv_all_currencies);
        return view;
    }

    @Override
    public void init() {
        layoutManager = new LinearLayoutManager(view.getContext());
        adapter = new AllRVAdapter(currenciesPresenter.getRatesListPresenter());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void updateData() {
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        adapter.notifyDataSetChanged();
        Log.i("--->", "updateData: ");
    }

    @Override
    public boolean backPressed() {
        return currenciesPresenter.backPressed();
    }
}
