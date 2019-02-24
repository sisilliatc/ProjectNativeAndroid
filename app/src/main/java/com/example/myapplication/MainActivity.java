package com.example.myapplication;

import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.myapplication.Adapter.AdapterListData;
import com.example.myapplication.Model.ModelData;
import com.example.myapplication.Rest.ApiClient;
import com.example.myapplication.Rest.ApiInterface;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recycleDataList, recycleAddData;
    AdapterListData adapterListData;
    List<ModelData> modelData;
    TextView addData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        swipeRefreshLayout = (SwipeRefreshLayout) findViewById(R.id.swipeLayout);
        recycleDataList = (RecyclerView) findViewById(R.id.listRecycle);
        recycleAddData = (RecyclerView) findViewById(R.id.addDataList);
        addData = (TextView) findViewById(R.id.addData);

        //add data
        addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                addDataList();
            }
        });

//        if (recycleAddData != null){
//            addData.setVisibility(View.GONE);
//        }else {
//            addData.setVisibility(View.VISIBLE);
//        }

        loadDataList();

    }

    private void loadDataList(){

        ApiInterface apiInterDataList = ApiClient.getClient(0).create(ApiInterface.class);
        Call<ModelData> showDataListCall = apiInterDataList.getDataList();

        showDataListCall.enqueue(new Callback<ModelData>() {
            @Override
            public void onResponse(Call<ModelData> call, Response<ModelData> response) {
                if(response.isSuccessful()){
                    modelData = new ArrayList<>();
                    modelData = response.body().getValue();
                    modelData.subList(0,3);
                    adapterListData = new AdapterListData(modelData, MainActivity.this);
                    recycleDataList.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                            LinearLayoutManager.VERTICAL,false));
                    recycleDataList.setNestedScrollingEnabled(false);
                    recycleDataList.setHasFixedSize(true);
                    recycleDataList.setAdapter(adapterListData);
                    adapterListData.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ModelData> call, Throwable t) {

            }
        });
    }

    private void addDataList(){
        ApiInterface apiInterDataList = ApiClient.getClient(0).create(ApiInterface.class);
        Call<ModelData> addDataListCall = apiInterDataList.addDataList();

        addDataListCall.enqueue(new Callback<ModelData>() {
            @Override
            public void onResponse(Call<ModelData> call, Response<ModelData> response) {
                if(response.isSuccessful()){
                    modelData = new ArrayList<>();
                    modelData = response.body().getValue();
                    adapterListData = new AdapterListData(modelData, MainActivity.this);
                    recycleAddData.setLayoutManager(new LinearLayoutManager(MainActivity.this,
                            LinearLayoutManager.VERTICAL,false));
                    recycleAddData.setNestedScrollingEnabled(false);
                    recycleAddData.setHasFixedSize(true);
                    recycleAddData.setAdapter(adapterListData);
                    adapterListData.notifyDataSetChanged();
                }

            }

            @Override
            public void onFailure(Call<ModelData> call, Throwable t) {

            }
        });
    }
}
