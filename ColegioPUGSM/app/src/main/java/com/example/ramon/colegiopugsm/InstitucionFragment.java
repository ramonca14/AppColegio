package com.example.ramon.colegiopugsm;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.AlignmentSpan;
import android.text.style.ClickableSpan;
import android.text.style.StyleSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bluejamesbond.text.DocumentView;
import com.bluejamesbond.text.hyphen.IHyphenator;
import com.bluejamesbond.text.style.JustifiedSpan;
import com.bluejamesbond.text.style.TextAlignment;
import com.bluejamesbond.text.style.TextAlignmentSpan;

import java.util.List;


public class InstitucionFragment extends Fragment {

    private WebView Wview;
    private final String LOG_TAG = "log_fragment";
    TextView textView;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_institucion, container, false);
        //  String string = getString(R.string.institucion_string);

        //JustifiedTextView J = (JustifiedTextView)v.findViewById(R.id.TextV);
        // myMsg.setText("asldfkajsdñflkadsjñlfjasdlñfjñlsadfjñasdlkflñasdjflñasdjkflñasdjflñasdñfljasñdlfjañldsfjñlasdjfñljfsadjfklñasfd");
        Wview = (WebView) v.findViewById(R.id.wView);
        // Wview.setVerticalScrollBarEnabled(false);

        // ((LinearLayout)v.findViewById(R.id.TextV)).addView(view);

        Wview.loadData(getString(R.string.institucion_string), "text/html; charset=utf-8", "utf-8");

//SpannableStringBuilder stringBuilder =  new SpannableStringBuilder(getString(R.string.institucion_string));
//stringBuilder.setSpan(new AlignmentSpan.Standard(Layout.Alignment.ALIGN_CENTER),0,200,0);


        //textView = (TextView)v.findViewById(R.id.TextV);

        //SpannableString spannableString = new SpannableString(string);
        //spannableString.setSpan(new StyleSpan(Typeface.BOLD_ITALIC),0,1000,0);


        //textView.setText(spannableString);
        return v;


    }

}