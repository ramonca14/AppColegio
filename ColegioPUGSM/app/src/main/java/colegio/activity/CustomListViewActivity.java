package colegio.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;


import colegio.R;

import colegio.activity.CustomListViewActivity;
import colegio.adapter.CustomListViewAdapter;
import colegio.entity.Icono;

import java.util.List;

public class CustomListViewActivity extends AppCompatActivity{

    private ListView listView;
private List<Icono> iconolist;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_custom_list_view);
        listView = (ListView) findViewById(R.id.listView);
        iconolist = Icono.getList();
        ArrayAdapter adapter = new CustomListViewAdapter(this, R.layout.adapter_custom_listview_row, iconolist);
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



    }

    @Override
    public void onBackPressed() {


            super.onBackPressed();
        }





}
