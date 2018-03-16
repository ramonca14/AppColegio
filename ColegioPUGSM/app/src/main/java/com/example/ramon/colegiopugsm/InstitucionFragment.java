package com.example.ramon.colegiopugsm;

import android.os.Bundle;

import android.support.v4.app.Fragment;
import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.TextView;


public class InstitucionFragment extends Fragment {
TextView tv;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
         View v= inflater.inflate(R.layout.fragment_institucion, container, false);
tv = (TextView)v.findViewById(R.id.txtinst);
        tv.setText(Html.fromHtml(getResources().getString(R.string.institucion_string)));
        return v;
    }

}