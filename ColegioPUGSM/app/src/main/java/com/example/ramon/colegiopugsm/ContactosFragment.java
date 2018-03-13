package com.example.ramon.colegiopugsm;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;


public class ContactosFragment extends Fragment {

      @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_contactos, container, false);

        List<String> list = new ArrayList<>();

        //String[] list = {"Dirección: 44525470", "Preceptoria: 44525470", "Secretaria: 44525470", "Gabinete: 44525470",
          //      "Laboratorio: 44525470", "Biblioteca: 44525470", "Administración: 44525470"};

        //for (int i = 1; i <= 20; i++) {
          list.add("Dirección:   4457096");
          list.add("Preceptoria: 4457097");
          list.add("Secretaria:  4457387");


        ListView listView = view.findViewById(R.id.listContactos);



        ArrayAdapter <String> adapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list);

        listView.setAdapter(adapter);

        // Inflate the layout for this fragment
        return view;
    }

}