package com.boopalan.FirebaseProjectStaff.activity;

import android.os.Bundle;
import android.webkit.WebView;

import com.boopalan.FirebaseProjectStaff.R;

/**
 * Created by aashi on 7/25/2016.
 */
public class Form extends BaseActivity {

    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(true);
        WebView webview = (WebView) findViewById(R.id.webview);
        webview.getSettings().setJavaScriptEnabled(true);
        Bundle bundle = getIntent().getExtras();
        String message = bundle.getString("message");
//        String pdf = "http://www.qantas.com.au/infodetail/flying/atTheAirport/lost-damaged-baggage-claim-form.pdf";
        webview.loadUrl(message);
    }

}