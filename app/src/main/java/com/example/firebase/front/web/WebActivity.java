package com.example.firebase.front.web;

import android.os.Bundle;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.firebase.utils.Initialization;

public class WebActivity extends AppCompatActivity implements Initialization {
    WebView view;
    @Override protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        initialize();
        setContentView(view);
    }
    @Override public void initialize() {
        view = new WebView(this);
        view.setWebViewClient(new WebViewClient());
        view.loadUrl("https://www.google.com/");
    }
}
