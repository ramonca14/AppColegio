package com.example.ramon.colegiopugsm;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

/**
 * Created by Ramon on 12/2/2018.
 */

public class WebViewFragment extends Fragment {
    private WebView webView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
View view = inflater.inflate(R.layout.webview_fragment_layout, container, false);

webView = (WebView)view.findViewById(R.id.webView);

WebSettings webSettings = webView.getSettings();
webSettings.setJavaScriptEnabled(true);

webView.setWebViewClient(new WebViewClient());
webView.loadUrl(MainActivity.weburl);
return view;
    }
     public void onBackPressed() {

           }
}

