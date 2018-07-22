package com.example.svbk0.ams_sms;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

public class MainActivity extends AppCompatActivity {

    Button practice, sms, status, about, close;

    private AdmobAds ads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MainActivity.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        ads = new AdmobAds();

        ads.adInitialize(getApplicationContext());

        practice = findViewById(R.id.practice);
        sms = findViewById(R.id.sms);
        status = findViewById(R.id.status);
        about = findViewById(R.id.about);
        close = findViewById(R.id.close);

        practice.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ads.showAd();
                startActivity(new Intent(MainActivity.this, Practice.class));
            }
        });

        sms.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ads.showAd();
                startActivity(new Intent(MainActivity.this, SendSMS.class));
            }
        });

        status.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ads.showAd();
                startActivity(new Intent(MainActivity.this, CheckStatus.class));
            }
        });

        about.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ads.showAd();
                startActivity(new Intent(MainActivity.this, About.class));
            }
        });

        close.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ads.showAd();
                finishAndRemoveTask();
            }
        });

    }
}
