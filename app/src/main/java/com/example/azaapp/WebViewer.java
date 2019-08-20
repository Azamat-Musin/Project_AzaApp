package com.example.azaapp;
import android.app.Activity;

import android.os.Bundle;
import android.webkit.WebView;
// Документация
/*
Активити отвечающая за открытие вед-страниц
----------------------------------------
*/
public class WebViewer extends Activity {
    private WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_viewer);
        webView = findViewById(R.id.webView);
        // включаем поддержку JavaScript
        webView.getSettings().setJavaScriptEnabled(true);
        // указываем страницу загрузки
        webView.loadUrl("http://developer.alexanderklimov.ru/android");
    }
}
