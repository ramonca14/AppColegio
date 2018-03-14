package com.example.ramon.colegiopugsm;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewPdf extends Fragment {
    private WebView webView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_webviewpdf, container, false);
        webView = (WebView) view.findViewById(R.id.webViewPdf);
        WebSettings webSettings = webView.getSettings();
        webSettings.setJavaScriptEnabled(true);

        webView.setWebViewClient(new WebViewClient(){

            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon){
                super.onPageStarted(view, url, favicon);

            }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

            }
        });

        //Url Ejemplo:
        String pdf = "http://cpugsm.unlar.edu.ar/descarga/calendario_academico_2017.pdf";
        //Carga url de .PDF en WebView  mediante Google Drive Viewer.
        webView.loadUrl("http://drive.google.com/viewerng/viewer?embedded=true&url=" + pdf);


        //webView.loadUrl(MainActivity.weburl);




        return view;
    }
}