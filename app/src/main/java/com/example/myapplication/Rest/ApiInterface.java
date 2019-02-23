package com.example.myapplication.Rest;

import com.example.myapplication.Model.ModelData;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("random/10-")
    Call<ModelData> getDataList();
}
