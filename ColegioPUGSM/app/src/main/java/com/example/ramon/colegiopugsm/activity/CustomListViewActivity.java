package com.example.ramon.colegiopugsm.activity;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import com.example.ramon.colegiopugsm.LlamarItem;
import com.example.ramon.colegiopugsm.MainActivity;
import com.example.ramon.colegiopugsm.R;
import com.example.ramon.colegiopugsm.adapter.CustomListViewAdapter;
import com.example.ramon.colegiopugsm.entity.Icono;

import java.util.List;

import static com.example.ramon.colegiopugsm.entity.Icono.getList;

public class CustomListViewActivity extends AppCompatActivity{

    private ListView listView;
private List<Icono> iconolist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);

        listView = (ListView) findViewById(R.id.listView);
iconolist = getList();
        ArrayAdapter adapter = new CustomListViewAdapter(this,
                R.layout.adapter_custom_listview_row, iconolist);

        listView.setAdapter(adapter);
        listView.setClickable(true);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        { public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            TextView textView = (TextView) view.findViewById(R.id.tvXml);
            String text = textView.getText().toString();

                    Intent intent = new Intent(Intent.ACTION_DIAL);
                    intent.setData(Uri.parse("tel:"+text));
                    startActivity(intent);
        }});



    }}
