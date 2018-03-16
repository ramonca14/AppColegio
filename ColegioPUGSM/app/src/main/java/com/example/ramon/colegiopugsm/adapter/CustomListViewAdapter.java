package com.example.ramon.colegiopugsm.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ramon.colegiopugsm.R;
import com.example.ramon.colegiopugsm.entity.Icono;

import java.util.List;

public class CustomListViewAdapter extends ArrayAdapter<Icono> {

    private Context context;
    private int resource;
    private List<Icono> iconos;

    public CustomListViewAdapter(Context context, int resource, List<Icono> iconos) {
        super(context, resource, iconos);
        this.context = context;
        this.resource = resource;
        this.iconos = iconos;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(resource, parent, false);

            viewHolder = new ViewHolder();

            viewHolder.icon = (ImageView) convertView.findViewById(R.id.imageView);
            viewHolder.nombre = (TextView) convertView.findViewById(R.id.tvNombre);
            viewHolder.xml = (TextView) convertView.findViewById(R.id.tvXml);
            viewHolder.index = (TextView) convertView.findViewById(R.id.tvIndex);

            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        viewHolder.icon.setBackgroundResource(iconos.get(position).getIcon());
        viewHolder.nombre.setText(iconos.get(position).getNobmre());
        viewHolder.xml.setText(iconos.get(position).getXml());
        viewHolder.index.setText(Integer.toString(position));

        return convertView;
    }

    private static class ViewHolder {
        private ImageView icon;
        private TextView nombre;
        private TextView xml;
        private TextView index;
    }



}
