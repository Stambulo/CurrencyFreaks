package com.stambulo.currencyfreaks.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.stambulo.currencyfreaks.R;
import com.stambulo.currencyfreaks.mvp.presenter.list.IRateListPresenter;
import com.stambulo.currencyfreaks.mvp.view.list.CurrencyItemView;

public class AllRVAdapter extends RecyclerView.Adapter<AllRVAdapter.ViewHolder> {
    private IRateListPresenter presenter;

    public AllRVAdapter(IRateListPresenter presenter){
        this.presenter = presenter;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View rateView = inflater.inflate(R.layout.item_currency, parent, false);
        return new ViewHolder(rateView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.position = position;
        holder.itemView.setOnClickListener(view -> presenter.onItemClick(holder));
        presenter.bindView(holder);
    }


    @Override
    public int getItemCount() {
        return presenter.getCount();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements CurrencyItemView {
        TextView tv_currency_rate;
        TextView tv_currency_name;
        int position;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tv_currency_rate = itemView.findViewById(R.id.tv_currency_rate);
            tv_currency_name = itemView.findViewById(R.id.tv_currency_name);
        }

        @Override
        public void setCurrencyRate(String currencyRate) {
            tv_currency_rate.setText(currencyRate);
        }

        @Override
        public void setCurrencyName(String currencyName) {
            tv_currency_name.setText(currencyName);
        }

        @Override
        public int getPos() {
            return position;
        }
    }
}
