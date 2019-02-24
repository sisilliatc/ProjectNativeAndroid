package com.example.myapplication.Adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.RecyclerView;
import android.text.Html;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.example.myapplication.MainActivity;
import com.example.myapplication.Model.ModelData;
import com.example.myapplication.R;

import java.util.List;

import static android.content.Context.LAYOUT_INFLATER_SERVICE;

public class AdapterListData extends RecyclerView.Adapter<AdapterListData.MyviewHolder> {

    public final int limit = 5;
    private PopupWindow mPopupWindow;
    LinearLayout mLinearLayout;
    List<ModelData> modelDataList;
    Context context;

    public AdapterListData(List<ModelData> modelData, MainActivity mainActivity) {
        super();
        this.modelDataList = modelData;
        this.context = context;
    }

    public class MyviewHolder extends RecyclerView.ViewHolder {
        TextView dataList, upText;
        public MyviewHolder(@NonNull View itemView) {
            super(itemView);
            dataList = (TextView) itemView.findViewById(R.id.dataList);
            upText = (TextView) itemView.findViewById(R.id.upText);
        }
    }

    @NonNull
    @Override
    public AdapterListData.MyviewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.recyclerview_adapter_list_data, viewGroup, false);
        return new AdapterListData.MyviewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final AdapterListData.MyviewHolder myviewHolder, int position) {
        ModelData modelData = modelDataList.get(position);
        myviewHolder.dataList.setText(modelData.getJoke());

        myviewHolder.dataList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(myviewHolder.dataList.getContext());
                alertDialog.setTitle("Hello World");
                alertDialog.setMessage(Html.fromHtml("<small> This is a pop up Menu </small>"));
                alertDialog.setNegativeButton("Cancel",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.dismiss();
                            }
                        });
                alertDialog.setPositiveButton("Hello World too!",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                Toast.makeText(v.getContext(),"Hello world too!!",Toast.LENGTH_SHORT).show();
                                //perform action
                                Log.d("message","done");
                            }
                        });
                final AlertDialog alert = alertDialog.create();
                alert.show();
            }

        });

    }

    @Override
    public int getItemCount() {
        return modelDataList.size();
    }


}
