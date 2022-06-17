package com.example.myapp03;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.EditText;

public class webview extends AppCompatActivity {


    Button btnGo, btnBack;
    WebView web;
    EditText edtUrl;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);

        btnGo = findViewById(R.id.btnGo);
        btnBack = findViewById(R.id.btnBack);
        web = findViewById(R.id.webview1);
        edtUrl = findViewById(R.id.editurl);

        web.setWebViewClient(new CookWebViewClient());
        WebSettings webSettings = web.getSettings();
        webSettings.setUseWideViewPort(true);   //화면 사이즈 맞추기 허용
        webSettings.setJavaScriptEnabled(true); // javascript 이용할 수 있게함
//        webSettings.setDomStorageEnabled(true); // 내부 저장소 이용할 수 있게 함

        btnGo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d(":aa :", edtUrl.getText().toString());
                web.loadUrl(edtUrl.getText().toString());
            }
        });

        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                web.goBack();
            }
        });
    }

    class CookWebViewClient extends WebViewClient {
        @Override
        public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
            return super.shouldOverrideUrlLoading(view, request);
        }
    }
}