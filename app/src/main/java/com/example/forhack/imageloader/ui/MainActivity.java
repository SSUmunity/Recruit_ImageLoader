package com.example.forhack.imageloader.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.forhack.imageloader.customview.CircleImageView;
import com.example.forhack.imageloader.R;
import com.example.forhack.imageloader.model.Item;
import com.example.forhack.imageloader.util.ImageUtil;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.View {
    private static final String TAG = MainActivity.class.getSimpleName();

    private MainPresenter mPresenter;
    private RecyclerView mRecyclerView;
    private CustomAdapter mAdapter;

    private List<Item> mDataList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter(this);
        initView();
    }

    public void updateDataList(List<Item> dataList) {
        mDataList = dataList;
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.main_list);

        mAdapter = new CustomAdapter();
        mRecyclerView.setAdapter(mAdapter);

        mPresenter.fetchNetwork();
    }

    class CustomAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

        private final View.OnClickListener mOnClickListener = new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int itemPosition = mRecyclerView.getChildPosition(view);
                Item item = mDataList.get(itemPosition);
                Toast.makeText(MainActivity.this, item.getTitle(), Toast.LENGTH_LONG).show();
            }
        };

        @Override
        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

            View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list_row, parent, false);
            view.setOnClickListener(mOnClickListener);
            return new CustomViewHolder(view);
        }

        @Override
        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int position) {
            Item item = mDataList.get(position);

            ((CustomViewHolder) viewHolder).titleText.setText(item.getTitle());
            ((CustomViewHolder) viewHolder).dateText.setText(item.getDate());
            ImageUtil.loadUrlImage(((CustomViewHolder) viewHolder).profileImage, item.getImageUrl());

            viewHolder.itemView.setTag(item);
        }

        @Override
        public int getItemCount() {
            return mDataList.size();
        }

        private class CustomViewHolder extends RecyclerView.ViewHolder {

            public TextView titleText, dateText;
            public CircleImageView profileImage;

            public CustomViewHolder(View view) {
                super(view);

                titleText = (TextView) view.findViewById(R.id.item_title_txt);
                dateText = (TextView) view.findViewById(R.id.item_date_txt);
                profileImage = (CircleImageView) view.findViewById(R.id.item_image);
            }
        }
    }
}
