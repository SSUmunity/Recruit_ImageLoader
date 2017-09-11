package com.example.forhack.imageloader.ui;

import com.example.forhack.imageloader.model.Item;
import com.example.forhack.imageloader.network.NetworkFetcher;

import java.util.List;

public class MainPresenter implements MainContract.Presenter, MainContract.OnDataFetchedListener {

    private MainActivity mView;

   public MainPresenter(MainActivity view) {
        mView = view;
    }

    @Override
    public void onDataFetched(String response) {
        List<Item> dataList = Item.fromJson(response);

        mView.updateDataList(dataList);
    }

    public void fetchNetwork() {
        NetworkFetcher fetcher = new NetworkFetcher(this);
        fetcher.sendRequest();
    }
}
