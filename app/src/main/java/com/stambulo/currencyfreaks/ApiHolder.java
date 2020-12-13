package com.stambulo.currencyfreaks;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.stambulo.currencyfreaks.mvp.model.IDataSource;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiHolder {
    private IDataSource dataSource;

    public ApiHolder() {
        Gson gson = new GsonBuilder().excludeFieldsWithoutExposeAnnotation().create();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.currencyfreaks.com/")
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();


        dataSource = retrofit.create(IDataSource.class);
    }


    public IDataSource getDataSource() {
        return dataSource;
    }
}
