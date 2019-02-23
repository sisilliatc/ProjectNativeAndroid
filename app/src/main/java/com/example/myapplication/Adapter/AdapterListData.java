package com.example.myapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.MainActivity;
import com.example.myapplication.Model.ModelData;
import com.example.myapplication.R;

import java.util.List;

public class AdapterListData extends RecyclerView.Adapter<AdapterListData.MyviewHolder> {

    List<ModelData> modelDataList;
    Context context;

    public AdapterListData(List<ModelData> modelData, MainActivity mainActivity) {
        super();
        this.modelDataList = modelData;
        this.context = context;
    }



    @NonNull
    @Override
    public AdapterListData.MyviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclerview_adapter_list_data, viewGroup, false);
        return new AdapterListData.MyviewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterListData.MyviewHolder myviewHolder, int position) {
        ModelData modelData = modelDataList.get(position);
        myviewHolder.dataList.setText(modelData.getJoke());

    }

    @Override
    public int getItemCount() {
        return modelDataList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView dataList;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            dataList = (TextView) itemView.findViewById(R.id.dataList);
        }
    }
}
