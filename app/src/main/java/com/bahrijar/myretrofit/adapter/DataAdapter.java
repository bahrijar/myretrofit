package com.bahrijar.myretrofit.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView.ViewHolder;

import com.bahrijar.myretrofit.R;
import com.bahrijar.myretrofit.model.Data;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends BaseAdapter {
    Context context;
    List<Data> data;

    public DataAdapter(Context context) {
        this.context = context;
        this.data = new ArrayList<>();
    }

    public void add(Data item) {
        data.add(item);
    }

    public void addAll(List<Data> items) {
        for (Data item : items) {
            add(item);
        }
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int i) {
        return data.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View itemView = view;
        if (itemView == null) {
            itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_data, viewGroup, false);
        }

        ViewHolder viewHolder = new ViewHolder(itemView);
        Data data = (Data) getItem(i);
        viewHolder.bind(data);

        return itemView;
    }

    private class ViewHolder {
        private TextView txtNama, txtDesc;

        ViewHolder(View view) {
            txtNama = view.findViewById(R.id.tv_title);
            txtDesc = view.findViewById(R.id.tv_desc);
        }

        void bind(Data data) {
            txtNama.setText(data.getJudul());
            txtDesc.setText(data.getDeskripsi());
        }



    }
}
