package com.example.duvangiraldo.reciclame;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Duvan Giraldo on 30/05/2017.
 */

public class Datos extends ArrayAdapter<String[]> {
    private List<String[]> scoreList = new ArrayList<String[]>();

    static class ItemViewHolder {
        TextView categoria;
        TextView direccion;
    }

    public Datos(Context context, int textViewResourceId) {
        super(context, textViewResourceId);
    }

    @Override
    public void add(String[] object) {
        scoreList.add(object);
        super.add(object);
    }

    @Override
    public int getCount() {
        return this.scoreList.size();
    }

    @Override
    public String[] getItem(int index) {
        return this.scoreList.get(index);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View row = convertView;
        ItemViewHolder viewHolder;
        if (row == null) {
            LayoutInflater inflater = (LayoutInflater) this.getContext().
                    getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.item_layout, parent, false);
            viewHolder = new ItemViewHolder();

            viewHolder.categoria = (TextView) row.findViewById(R.id.categoria);
            viewHolder.direccion = (TextView) row.findViewById(R.id.direccion);
            row.setTag(viewHolder);
        } else {
            viewHolder = (ItemViewHolder)row.getTag();
        }
        String[] stat = getItem(position);
        viewHolder.categoria.setText(stat[0]);
        viewHolder.direccion.setText(stat[1]);
        return row;
    }
}
