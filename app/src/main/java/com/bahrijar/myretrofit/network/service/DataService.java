package com.bahrijar.myretrofit.network.service;

import com.bahrijar.myretrofit.model.Data;
import com.bahrijar.myretrofit.network.Endpoint;
import com.bahrijar.myretrofit.network.response.BaseResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface DataService {
    @GET(Endpoint.API_READ)
    Call<BaseResponse<List<Data>>> apiRead();

    @GET(Endpoint.API_CREATE)
    Call<BaseResponse<List<Data>>> apiCreate();

    @GET(Endpoint.API_UPDATE)
    Call<BaseResponse<List<Data>>> apiUpdate();

    @GET(Endpoint.API_DELETE)
    Call<BaseResponse<List<Data>>> apiDelete();

}
