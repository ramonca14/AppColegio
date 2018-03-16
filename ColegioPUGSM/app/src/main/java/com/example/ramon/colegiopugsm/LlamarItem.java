package com.example.ramon.colegiopugsm;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.example.ramon.colegiopugsm.entity.Icono;

/**
 * Created by Ramon on 15/3/2018.
 */

public class LlamarItem extends AppCompatActivity {
    private Icono Item;
private String tel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

Item = (Icono) getIntent().getSerializableExtra("llamada");

tel = Item.getXml();

        Intent intent = new Intent (Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:"+tel));
        startActivity(intent);



    }
}
