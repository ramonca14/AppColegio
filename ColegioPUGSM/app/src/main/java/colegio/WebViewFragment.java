package colegio;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class WebViewFragment extends Fragment {
    private WebView webView;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
View view = inflater.inflate(R.layout.webview_fragment_layout, container, false);

webView = (WebView)view.findViewById(R.id.webView);

webView.setWebContentsDebuggingEnabled(false);
WebSettings webSettings = webView.getSettings();
webSettings.setJavaScriptEnabled(true);


webView.setWebViewClient(new WebViewClient(){
    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        //Verifica si es .pdf
        if (url.toLowerCase().endsWith(".pdf")){
            //Crea un Intent para abrir un archivo con MIME TYPE application/pdf
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(Uri.parse(url), "application/pdf");
            try{
                view.getContext().startActivity(intent);
            } catch (ActivityNotFoundException e) {
                //Error!
            }
        } else {  //Si no es .pdf simplemente carga la url en el WebView.
            webView.loadUrl(url);
        }
        return true;
    }
});

webView.loadUrl(MainActivity.weburl);






        webView.setOnKeyListener(new View.OnKeyListener()
        {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event)
            {
                if(event.getAction() == KeyEvent.ACTION_DOWN)
                {
                    WebView webView = (WebView) v;

                    switch(keyCode)
                    {
                        case KeyEvent.KEYCODE_BACK:
                            if(webView.canGoBack())
                            {
                                webView.goBack();
                                return true;
                            }
                            break;
                    }
                }

                return false;
            }
        });


return view;
    }



}

