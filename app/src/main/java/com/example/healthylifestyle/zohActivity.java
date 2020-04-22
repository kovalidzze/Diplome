package com.example.healthylifestyle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class zohActivity extends AppCompatActivity {
    private WebView webView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.zoh_layot);
        this.setTitle("Советы по ведению ЗОЖ");

            webView = (WebView) findViewById(R.id.webview);
            webView.setWebViewClient(new WebViewClient());
            webView.loadUrl("https://dailyfit.ru/osnovy-bodibildinga/40-sovetov-kak-vesti-zdorovyj-obraz-zhizni/");


        }
}
