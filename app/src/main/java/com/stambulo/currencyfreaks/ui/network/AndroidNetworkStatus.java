package com.stambulo.currencyfreaks.ui.network;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkRequest;
import android.util.Log;

import androidx.annotation.NonNull;

import com.stambulo.currencyfreaks.CFreaksApplication;
import com.stambulo.currencyfreaks.mvp.model.network.INetworkStatus;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.subjects.BehaviorSubject;

public class AndroidNetworkStatus implements INetworkStatus {
    private static final String TAG = "--->";

    private BehaviorSubject<Boolean> statusObject = BehaviorSubject.create();

    public AndroidNetworkStatus() {
        statusObject.onNext(false);

        ConnectivityManager connectivityManager = (ConnectivityManager)
                CFreaksApplication.INSTANCE.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkRequest networkRequest = new NetworkRequest.Builder().build();

        connectivityManager.registerNetworkCallback(networkRequest, new ConnectivityManager.NetworkCallback() {
            @Override
            public void onAvailable(@NonNull Network network) {
                super.onAvailable(network);

                    Log.i(TAG, "onAvailable");

                statusObject.onNext(true);
            }

            @Override
            public void onUnavailable() {
                super.onUnavailable();

                    Log.i(TAG, "onUnavailable");

                statusObject.onNext(false);
            }

            @Override
            public void onLost(@NonNull Network network) {
                super.onLost(network);

                    Log.i(TAG, "onLost");

                statusObject.onNext(false);
            }
        });
    }

    @Override
    public Observable<Boolean> isOnline() {
        return statusObject;
    }

    @Override
    public Single<Boolean> isOnlineSingle() {
        return statusObject.first(false);
    }
}
