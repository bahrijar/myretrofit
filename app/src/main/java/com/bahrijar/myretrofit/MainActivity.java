package com.bahrijar.myretrofit;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.bahrijar.myretrofit.adapter.DataAdapter;
import com.bahrijar.myretrofit.model.Data;
import com.bahrijar.myretrofit.network.ServiceGenerator;
import com.bahrijar.myretrofit.network.response.BaseResponse;
import com.bahrijar.myretrofit.network.service.DataService;

import org.jetbrains.annotations.NotNull;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private DataService service;
    private DataAdapter adapter;
    private ListView lvData;

    ProgressDialog loadingData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        adapter = new DataAdapter(this);
        service = ServiceGenerator.createBaseService(this, DataService.class);

        loadData();
    }

    private void initViews() {
        loadingData = new ProgressDialog(this);
        loadingData.setTitle("Mohon tunggu...");
        loadingData.setCancelable(false);
        loadingData.setMessage("Sedang mengambil data dari API");

        lvData = findViewById(R.id.lv_data);
    }

    private void loadData() {
        loadingData.show();
        Call<BaseResponse<List<Data>>> call = service.apiRead();
        call.enqueue(new Callback<BaseResponse<List<Data>>>() {
            @Override
            public void onResponse(@NotNull Call<BaseResponse<List<Data>>> call, @NotNull Response<BaseResponse<List<Data>>> response) {
                if (response.code() == 200) {
                    adapter.addAll(response.body().getData());
                    lvData.setAdapter(adapter);
                    loadingData.dismiss();
//                    Toast.makeText(MainActivity.this, "Success", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(@NotNull Call<BaseResponse<List<Data>>> call, @NotNull Throwable t) {
                loadingData.dismiss();
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
    }

}
