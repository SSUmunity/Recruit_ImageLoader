package com.example.forhack.imageloader.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.MultiAutoCompleteTextView;

import com.example.forhack.imageloader.R;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPresenter = new MainPresenter(this);
    }
}
