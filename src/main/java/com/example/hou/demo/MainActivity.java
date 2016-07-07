package com.example.hou.demo;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.JavascriptInterface;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Intent webView;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        webView = new Intent(this, WebViewActivity.class);

    }

    public void goH5(View source) {
        webView.putExtra("url", "file:///android_asset/H5/index.html");
        startActivity(webView);
    }

    public void goTrainList(View source) {
        webView.putExtra("url", "file:///android_asset/DG/index.html#/trainList");
        startActivity(webView);
    }
    public void goTrainBuy(View source) {
        webView.putExtra("url", "file:///android_asset/DG/index.html#/trainIndex");
        startActivity(webView);
    }
}
