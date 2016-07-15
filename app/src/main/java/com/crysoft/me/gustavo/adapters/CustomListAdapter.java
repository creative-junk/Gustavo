package com.crysoft.me.gustavo.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.crysoft.me.gustavo.R;

/**
 * Created by Maxx on 7/14/2016.
 */
public class CustomListAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] values;
    private String[] tagLine = {
            "Find parts & Accessories","Locate nearest Auto Shop","Find the Nearest Mechanics","Deals & Specials","Find Help on Vehicle Repair"
    };
    private int[] tabImages = {
            R.drawable.ic_home_orange,
            R.drawable.ic_location_orange,
            R.drawable.ic_mechanic_orange,
            R.drawable.ic_account_orange,
            R.drawable.ic_repairs

    };

    public CustomListAdapter(Context context, String[] values) {
        super(context, R.layout.list_items, values);
        this.context = context;
        this.values = values;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.list_items, parent, false);
        //get the textviews
        TextView tvTitle = (TextView) rowView.findViewById(R.id.title);
        TextView tvTagline = (TextView) rowView.findViewById(R.id.tagline);
        //get the Image
        ImageView imageView = (ImageView) rowView.findViewById(R.id.icon);
        tvTitle.setText(values[position]);
        tvTagline.setText(tagLine[position]);
        imageView.setImageResource(tabImages[position]);

        return rowView;
    }
}
