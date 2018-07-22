package com.example.svbk0.ams_sms;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;
import com.google.android.gms.ads.MobileAds;

public class AdmobAds {

    private InterstitialAd mInterstitialAd;
    private AdRequest adRequest;

    private String adUnit = "ca-app-pub-3940256099942544/1033173712";

    public void adInitialize(final Context context){

        MobileAds.initialize(context, adUnit);

        mInterstitialAd = new InterstitialAd(context);
        adRequest = new AdRequest.Builder().build();

        mInterstitialAd.setAdUnitId(adUnit);
        mInterstitialAd.loadAd(adRequest);
        mInterstitialAd.setAdListener(new AdListener() {
            @Override
            public void onAdLoaded() {
                Toast.makeText(context, "Ad Loaded.", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdFailedToLoad(int errorCode) {
                Toast.makeText(context, "OOPS Ad Failed to Load!!", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdOpened() {
                Toast.makeText(context, "Ad Opened..", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onAdLeftApplication() {
                Toast.makeText(context, "Oh no, Application closed!!!!", Toast.LENGTH_SHORT).show();
                mInterstitialAd.show();
            }

            @Override
            public void onAdClosed() {
                mInterstitialAd.loadAd(adRequest);
                Toast.makeText(context, "Ad closed!!!!", Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void showAd(){

        if (mInterstitialAd.isLoaded()) {
            mInterstitialAd.show();
        } else {
            Log.d("TAG", "The interstitial wasn't loaded yet.");
        }
    }

}
