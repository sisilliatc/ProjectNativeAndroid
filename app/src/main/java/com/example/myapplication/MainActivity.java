package com.example.myapplication;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.example.myapplication.Adapter.AdapterListData;
import com.example.myapplication.Model.ModelData;
import com.example.myapplication.Rest.ApiClient;
import com.example.myapplication.Rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recycleDataList;
    AdapterListData adapterListData;
    List<ModelData> modelData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeLayout);
        recycleDataList = (RecyclerView) findViewById(R.id.listRecycle);

        loadDataList();

    }

    private void loadDataList(){

        ApiInterface apiInterDataList = ApiClient.getClient(0).create(ApiInterface.class);

        Call<ModelData> showDataListCall = apiInterDataList.getDataList();

        showDataListCall.enqueue(new Callback<ModelData>() {
            @Override
            public void onResponse(Call<ModelData> call, Response<ModelData> response) {
                if(response.isSuccessful()){
                    modelData = response.body().getValue();
                    adapterListData = new AdapterListData(modelData, MainActivity.this);
                    recycleDataList.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                            LinearLayoutManager.VERTICAL,false));
                    recycleDataList.setNestedScrollingEnabled(false);
                    recycleDataList.setHasFixedSize(true);
                    recycleDataList.setAdapter(adapterListData);
                }
            }

            @Override
            public void onFailure(Call<ModelData> call, Throwable t) {

            }
        });
    }
}
