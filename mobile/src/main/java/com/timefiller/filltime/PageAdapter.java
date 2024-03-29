package com.timefiller.filltime;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by antonello on 28/11/15.
 */
public class PageAdapter extends ArrayAdapter<String> {

    private ArrayList<String> mockItems;
    private LayoutInflater inflater = null;
    private int layoutResourceId;
    private Context context;

    public PageAdapter(Context context, int resource, ArrayList<String> items) {

        super(context, resource, items);
        this.mockItems = items;
        this.layoutResourceId = resource;
        this.context = context;

    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;

        if (convertView == null) {
            inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(layoutResourceId, null);

            holder = new ViewHolder();
            holder.text = (TextView) convertView.findViewById(R.id.text);

            convertView.setTag(holder);
        } else
            holder = (ViewHolder) convertView.getTag();

        holder.text.setText(mockItems.get(position));

        return convertView;
    }

    public static class ViewHolder {
        public TextView text;
    }

}
