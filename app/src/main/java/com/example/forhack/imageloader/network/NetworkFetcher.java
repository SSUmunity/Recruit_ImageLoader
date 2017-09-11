package com.example.forhack.imageloader.network;

import android.util.Log;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.example.forhack.imageloader.AppConfig;
import com.example.forhack.imageloader.BaseApplication;
import com.example.forhack.imageloader.ui.MainContract;

import org.json.JSONArray;

public class NetworkFetcher {
    private static final String TAG = NetworkFetcher.class.getSimpleName();

    private RequestQueue mQueue;
    private MainContract.OnDataFetchedListener mListener;

    public NetworkFetcher(MainContract.OnDataFetchedListener listener) {
        mQueue = BaseApplication.getRequestQueue();
        mListener = listener;
    }

    public void sendRequest() {
        JsonArrayRequest request = new JsonArrayRequest(AppConfig.LIST_DATA_URL,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray jsonArray) {
                       mListener.onDataFetched(jsonArray.toString());
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError volleyError) {
                        Log.d(TAG, "Requset error");
                    }
                });

        mQueue.add(request);
    }
}
