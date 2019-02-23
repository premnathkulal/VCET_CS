package com.example.vcet_cs;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class Web_links extends AppCompatActivity {

    WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_links);


        ProgressDialog progressDialog;
        progressDialog = new ProgressDialog(this);

        progressDialog.setMessage("Downloading...");
        progressDialog.show();

        Intent i = getIntent();

        String url = i.getStringExtra("URLID");

        webView = (WebView)findViewById(R.id.web_id);
        webView.setWebViewClient(new MyBrowser());
        webView.getSettings().setJavaScriptEnabled(true);
        webView.loadUrl(url);

        progressDialog.dismiss();

    }

    private class MyBrowser extends WebViewClient{
        @Override
        public boolean shouldOverrideUrlLoading(WebView view,String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
