package com.potevio.customviewtest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

import com.potevio.customviewtest.R;

import java.util.List;

/**
 * Created by CHK on 19-5-17.
 */
public class GridLayoutAdapter extends RecyclerView.Adapter {

    List<String> mDataList;
    Animation animation;

    public GridLayoutAdapter(Context context, List<String> mDataList) {
        this.mDataList = mDataList;
        animation = AnimationUtils.loadAnimation(context,android.R.anim.slide_in_left);
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
        viewHolder.itemView.startAnimation(animation);
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
