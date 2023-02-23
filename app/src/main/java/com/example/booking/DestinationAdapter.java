package com.example.booking;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class DestinationAdapter extends ArrayAdapter<String> {

    private Integer[] imgs = {
            R.drawable.usa,
            R.drawable.inde,
            R.drawable.tailand,
            R.drawable.korea,
            R.drawable.swiss,
            R.drawable.canada,
            R.drawable.france,
            R.drawable.italie,
            R.drawable.tirquie,
            R.drawable.espagne,
            R.drawable.uk,
            R.drawable.mexique,
            R.drawable.kazakh

    };

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater)
                getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View rowView = inflater.inflate(R.layout.des, parent, false);

        TextView textView = (TextView) rowView.findViewById(R.id.label);
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);

        textView.setText(getItem(position));


        imageView.setImageResource(imgs[position]);


        return rowView;
    }

    public DestinationAdapter(Context context, String[] values) {
        super(context, R.layout.des, values);
    }
}