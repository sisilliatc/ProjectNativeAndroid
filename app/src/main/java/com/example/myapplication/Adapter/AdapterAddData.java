package com.example.myapplication.Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.myapplication.Model.ModelData;
import com.example.myapplication.R;

import java.util.ArrayList;
import java.util.List;

public class AdapterAddData extends RecyclerView.Adapter<AdapterAddData.MyviewHolder> {

    List<ModelData> modelDataList;
    Context context;

    public AdapterAddData(List<ModelData> modelData, Context context) {
        super();
        this.modelDataList = modelData;
        this.context = context;
    }

    @NonNull
    @Override
    public AdapterAddData.MyviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclerview_adapter_list_data, viewGroup, false);
        return new AdapterAddData.MyviewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull AdapterAddData.MyviewHolder myviewHolder, int i) {
        ModelData modelData = modelDataList.get(i);
        myviewHolder.dataList.setText(modelData.getJoke());
    }

    @Override
    public int getItemCount() {
        return modelDataList.size();
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView dataList, upText;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            dataList = (TextView) itemView.findViewById(R.id.dataList);
            upText = (TextView) itemView.findViewById(R.id.upText);
        }
    }

    public void emptyData(){
        modelDataList = new ArrayList<ModelData>();
        notifyDataSetChanged();
    }

}
