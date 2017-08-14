package com.example.forhack.imageloader.ui;

class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;

    public MainPresenter(MainContract.View view) {
        mView = view;
    }
}
