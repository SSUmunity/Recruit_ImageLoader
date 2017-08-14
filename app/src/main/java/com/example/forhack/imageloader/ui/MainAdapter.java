package com.example.forhack.imageloader.ui;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.forhack.imageloader.R;
import com.example.forhack.imageloader.model.Item;

import java.util.ArrayList;
import java.util.List;

class MainAdapter extends BaseAdapter {

    private List<Item> mList = new ArrayList<>();

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public Item getItem(int position) {
        return mList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder viewHolder;
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext())
                    .inflate(R.layout.item_list_row, parent, false);
            viewHolder = new ViewHolder();
            viewHolder.image = (ImageView) convertView.findViewById(R.id.item_image);
            viewHolder.title = (TextView) convertView.findViewById(R.id.item_title);
            convertView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) convertView.getTag();
        }

        Item item = getItem(position);
        viewHolder.image.setBackgroundResource(item.getImageRes());
        viewHolder.title.setText(item.getTitle());
        return convertView;
    }

    void setList(List<Item> list) {
        mList = list;
    }

    private static class ViewHolder {
        ImageView image;
        TextView title;
    }
}
