package com.example.forhack.imageloader.ui;

import android.util.Log;

import com.example.forhack.imageloader.R;
import com.example.forhack.imageloader.model.Item;

import java.util.ArrayList;
import java.util.List;

class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;

    MainPresenter(MainContract.View view) {
        mView = view;
    }

    @Override
    public void setList() {
        List<Item> list = new ArrayList<>();
        list.add(new Item(R.drawable.a, "강1"));
        list.add(new Item(R.drawable.b, "강2"));
        list.add(new Item(R.drawable.c, "올빼미"));
        list.add(new Item(R.drawable.d, "민들레씨"));
        list.add(new Item(R.drawable.e, "고양이"));
        list.add(new Item(R.drawable.f, "올빼미2"));
        list.add(new Item(R.drawable.g, "코끼리"));
        list.add(new Item(R.drawable.h, "염소"));
        list.add(new Item(R.drawable.i, "오로라"));
        list.add(new Item(R.drawable.j, "바다"));

        MainAdapter adapter = new MainAdapter();
        adapter.setList(list);
        mView.setAdapter(adapter);
    }
}
