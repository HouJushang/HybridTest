package com.example.hou.demo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;
import android.webkit.WebViewClient;
import android.webkit.WebSettings;

public class MainActivity extends AppCompatActivity {

    private TextView showBtn1;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        showBtn1 = (TextView) findViewById(R.id.show);
        showBtn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showBtn1.setText("1额度asdasdfffklkjasasdfasd为爽肤水 !");
            }
        });

        WebView viewContent= (WebView) findViewById(R.id.webView);
        viewContent.setWebViewClient(new WebViewClient());

        WebSettings webSettings = viewContent.getSettings();
        webSettings.setJavaScriptEnabled(true);

        viewContent.loadUrl("file:///android_asset/H5/index.html#/list/1");

    }
    public void showMess(View source){
        TextView showBtn2 = (TextView) findViewById(R.id.show2);
        showBtn2.setText("切,你也点击我了!");
    }
}
