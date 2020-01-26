package com.bahrijar.myretrofit.network.response;

import com.google.gson.annotations.SerializedName;

public class BaseResponse<T> {
    @SerializedName("data")
    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}

