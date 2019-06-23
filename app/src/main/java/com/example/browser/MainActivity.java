package com.example.browser;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    WebView browser;
    EditText search;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        browser=findViewById(R.id.web);
        search=findViewById(R.id.linktext);
        browser.setWebViewClient(new inpage());
        browser.getSettings().setJavaScriptEnabled(true);
        browser.getSettings().setLoadsImagesAutomatically(true);


        browser.loadUrl("https://www.google.com/");
       search.setText( browser.getOriginalUrl());
    }

    public void back(View view) {
        browser.goBack();


    }

    public void next(View view) {
        browser.goForward();

    }

    public void go(View view) {
        browser.loadUrl("http://www.google.com/search?q="+search.getText().toString());

    }
    class inpage extends WebViewClient{

        @Override
        public boolean shouldOverrideUrlLoading(WebView view, String url) {
            view.loadUrl(url);
            return true;
        }
    }
}
