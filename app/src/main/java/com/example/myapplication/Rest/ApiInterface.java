package com.example.myapplication.Rest;

import com.example.myapplication.Model.ModelData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("random/3-")
    Call<ModelData> getDataList();

    @GET("random/2-")
    Call<ModelData> addDataList();
}
