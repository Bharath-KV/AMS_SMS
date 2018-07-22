package com.example.svbk0.ams_sms;

import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

public class CheckStatus extends AppCompatActivity {


    private Button back;

    private WebView checkStatus;

    private AdmobAds ads;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_status);
        CheckStatus.this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);

        back = findViewById(R.id.statusBackBtn);
        checkStatus = findViewById(R.id.statusWebView);

        ads = new AdmobAds();

        ads.adInitialize(getApplicationContext());

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        checkStatus.getSettings().setJavaScriptEnabled(true);
        checkStatus.getSettings().setSupportZoom(true);
        checkStatus.getSettings().setDisplayZoomControls(false);
        checkStatus.getSettings().setUseWideViewPort(true);
        checkStatus.getSettings().setBuiltInZoomControls(true);
        checkStatus.getSettings().setLoadWithOverviewMode(true);
        checkStatus.setBackgroundColor(Color.WHITE);
        checkStatus.setWebViewClient(new WebViewClient());

        checkStatus.loadUrl("http://dasoha.karnataka.gov.in/public/SchoolWiseMonthlyAttendance.aspx");

    }

}
