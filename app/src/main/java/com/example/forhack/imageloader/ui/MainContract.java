package com.example.forhack.imageloader.ui;

interface MainContract {
    interface View {

        void setAdapter(MainAdapter adapter);
    }

    interface Presenter {

        void setList();
    }
}
