package com.example.hou.demo;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.JavascriptInterface;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class WebViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_view);

        WebView viewContent = (WebView) findViewById(R.id.webView);
        viewContent.setWebViewClient(new WebViewClient());

        WebSettings webSettings = viewContent.getSettings();
        //support js
        webSettings.setJavaScriptEnabled(true);
        //support sessionstroage and localstorage
        webSettings.setDomStorageEnabled(true);
        //support websql
        webSettings.setDatabaseEnabled(true);
        //跨域设置
        webSettings.setAllowUniversalAccessFromFileURLs(true);

        Bundle extras = getIntent().getExtras();

        String url = extras.getString("url");

        class JsObject {
            @JavascriptInterface
            public String toString() {
                return "injectedObject";
            }
            @JavascriptInterface
            public String androidToast(String name) {
                Toast.makeText(getApplicationContext(), "默认" + name + "样式",
                        Toast.LENGTH_SHORT).show();
                return "androidToast";
            }
        }
        viewContent.addJavascriptInterface(new JsObject(), "AndroidApi");
        viewContent.loadUrl(url);
//        // 开启应用程序缓存
//        webSettings.setAppCacheEnabled(true);
//        String appCacheDir = this.getApplicationCo./ntext()
//                .getDir(-"cache", Context.MODE_PRIVATE).getPath();
//        webSettings.setAppCachePath(appCacheDir);
//        webSettings.setCacheMode(WebSettings.LOAD_DEFAULT);
//        webSettings.setAppCacheMaxSize(1024 * 1024 * 10);// 设置缓冲大小，我设的是10M
//        webSettings.setAllowFileAccess(true);
    }


}
