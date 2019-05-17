package com.potevio.customviewtest.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.potevio.customviewtest.R;

import java.util.List;

/**
 * Created by CHK on 19-5-17.
 */
public class GridLayoutAdapter extends RecyclerView.Adapter {

    List<String> mDataList;

    public GridLayoutAdapter(List<String> mDataList) {
        this.mDataList = mDataList;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_recycler_view_item,viewGroup,false);
        GridLayoutViewHolder gridLayoutViewHolder = new GridLayoutViewHolder(view);
        return gridLayoutViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

    }

    @Override
    public int getItemCount() {
        return mDataList.size();
    }

    class GridLayoutViewHolder extends RecyclerView.ViewHolder {
        public TextView showText;
        public GridLayoutViewHolder(@NonNull View itemView) {
            super(itemView);
            showText = itemView.findViewById(R.id.showText);
        }
    }
}
