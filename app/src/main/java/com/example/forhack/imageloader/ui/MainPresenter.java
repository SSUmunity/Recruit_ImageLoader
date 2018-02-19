package com.example.forhack.imageloader.ui;

import android.util.Log;

import com.example.forhack.imageloader.model.Item;
import com.example.forhack.imageloader.service.MainService;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

class MainPresenter implements MainContract.Presenter {

    private MainContract.View mView;

    MainPresenter(MainContract.View view) {
        mView = view;
    }

    @Override
    public void setList() {
        MainService mainService = MainService.retrofit.create(MainService.class);
        Call<String> call = mainService.getDataList();
        call.enqueue(new Callback<String>() {
            @Override
            public void onResponse(Call<String> call, Response<String> response) {
                List<Item> list = new ArrayList<>();

                String data = response.body().toString();
                try {
                    JSONArray jsonArray = new JSONArray(data);
                    for(int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        Item item = new Item();
                        item.setDate(jsonObject.get("date").toString());
                        item.setTitle(jsonObject.get("title").toString());
                        item.setUrl(jsonObject.get("url").toString());
                        list.add(item);
                    }
                    MainAdapter adapter = new MainAdapter();
                    adapter.setList(list);
                    mView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(Call<String> call, Throwable t) {
                Log.e("Retrofit Error", t.getMessage());
            }
        });

    }
}
