package com.example.ramon.colegiopugsm.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Icono implements Serializable {

    private String nobmre;
    private String xml;
    private int icon;

    public Icono(String nobmre, String xml, int icon) {
        this.nobmre = nobmre;
        this.xml = xml;
        this.icon = icon;
    }

    public String getNobmre() {
        return nobmre;
    }

    public void setNobmre(String nobmre) {
        this.nobmre = nobmre;
    }

    public String getXml() {
        return xml;
    }

    public void setXml(String xml) {
        this.xml = xml;
    }

    public int getIcon() {
        return icon;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }

    public static List<Icono> getList() {
        List<Icono> iconos = new ArrayList<>();
        Icono icono = new Icono("Dirección: ","(3804) 457391",
                android.R.drawable.ic_menu_call);
        iconos.add(icono);
        icono = new Icono("Vice-Dirección: ","3804457387",
                android.R.drawable.ic_menu_call);
        iconos.add(icono);
        icono = new Icono("C.E.P.U.: ","380457096",
                android.R.drawable.ic_menu_call);
        iconos.add(icono);
        icono = new Icono("Jefatura de Preceptores: ","3804457097",
                android.R.drawable.ic_menu_call);
        iconos.add(icono);
        icono = new Icono("Títulos: ","3804457333",
                android.R.drawable.ic_menu_call);
        iconos.add(icono);
        return iconos;
    }
}
