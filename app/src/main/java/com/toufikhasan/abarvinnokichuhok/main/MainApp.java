package com.toufikhasan.abarvinnokichuhok.main;

import android.app.Application;

import com.google.android.gms.ads.MobileAds;
import com.toufikhasan.abarvinnokichuhok.admob.InterstitialAds;

public class MainApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        MobileAds.initialize(this, initializationStatus -> {

        });

        InterstitialAds.loadInterstitialAd(this);
    }
}
