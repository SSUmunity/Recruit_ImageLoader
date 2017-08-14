package com.example.forhack.imageloader.ui;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import com.example.forhack.imageloader.R;

public class MainActivity extends AppCompatActivity implements MainContract.View {

    private MainContract.Presenter mPresenter;
    private ListView mListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mListView = (ListView) findViewById(R.id.main_list);

        mPresenter = new MainPresenter(this);
        mPresenter.setList();
    }

    @Override
    public void setAdapter(MainAdapter adapter) {
        mListView.setAdapter(adapter);
    }
}
