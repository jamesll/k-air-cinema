package com.kair.cinema.adapter;

import java.util.List;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.kair.cinema.R;
import com.kair.cinema.vo.MovieGridItem;

public class MovieGridAdapter extends BaseAdapter {

    private Context context;

    private List<MovieGridItem> list;
    private LayoutInflater mInflater;

    public MovieGridAdapter(final Context c) {
        super();
        this.context = c;
    }

    public void setList(final List<MovieGridItem> list) {
        this.list = list;
        mInflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    }

    @Override
    public int getCount() {
        // TODO Auto-generated method stub
        return list.size();
    }

    @Override
    public Object getItem(final int index) {

        return list.get(index);
    }

    @Override
    public long getItemId(final int index) {
        return index;
    }

    @Override
    public View getView(final int index, View convertView,
            final ViewGroup parent) {
        GridHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.item_movie_grid, null);
            holder = new GridHolder();
            holder.appImage = (ImageView) convertView
                    .findViewById(R.id.ItemImage);
            holder.appName = (TextView) convertView.findViewById(R.id.ItemText);

            convertView.setTag(holder);

        } else {
            holder = (GridHolder) convertView.getTag();

        }

        MovieGridItem info = list.get(index);
        if (info != null) {
            holder.appName.setText(info.getName());
            holder.appImage.setImageResource(info.getImageResource());
        }

        return convertView;
    }

    private class GridHolder {
        ImageView appImage;
        TextView appName;
    }
}
