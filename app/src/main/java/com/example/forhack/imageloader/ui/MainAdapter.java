package com.example.forhack.imageloader.ui;

import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.forhack.imageloader.R;
import com.example.forhack.imageloader.model.Item;

import java.util.ArrayList;
import java.util.List;

class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {

    private List<Item> mList = new ArrayList<>();

    void setList(List<Item> list) {
        mList = list;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_row, null);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Log.d("test", "bind view holder");
        Item item = mList.get(position);
        Log.d("size", Integer.toString(mList.size()));
        holder.image.setBackgroundResource(item.getImageRes());
        holder.title.setText(item.getTitle());
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView image;
        TextView title;
        public ViewHolder(View itemView) {
            super(itemView);
            image = (ImageView) itemView.findViewById(R.id.item_image);
            title = (TextView) itemView.findViewById(R.id.item_title);
        }

    }
}
