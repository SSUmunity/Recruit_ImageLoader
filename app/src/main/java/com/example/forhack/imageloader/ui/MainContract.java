package com.example.forhack.imageloader.ui;

public interface MainContract {
    interface View {
        void initView();
    }

    interface Presenter {

    }

    interface OnDataFetchedListener {

        void onDataFetched(String response);
    }
}
