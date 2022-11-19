package com.example.bai10_minhtuan_filterweb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.webkit.WebView;

public class MainActivity extends AppCompatActivity {
    WebView mybrowser;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mybrowser = findViewById(R.id.mybrowser);
        Intent webView = getIntent();
        Uri mylink = webView.getData();
        try {
            mybrowser.loadUrl(mylink.toString());
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}