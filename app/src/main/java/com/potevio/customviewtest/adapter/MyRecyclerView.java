package com.potevio.customviewtest.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.GridLayoutAnimationController;
import android.view.animation.LayoutAnimationController;
import android.widget.ListView;

/**
 * Created by CHK on 19-5-17.
 */
public class MyRecyclerView extends RecyclerView {

    public MyRecyclerView(@NonNull Context context) {
        super(context);
    }

    public MyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public MyRecyclerView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    protected void attachLayoutAnimationParameters(View child, ViewGroup.LayoutParams params, int index, int count) {
        final LayoutManager layoutManager = getLayoutManager();
        if (layoutManager instanceof GridLayoutManager) {   //是网格布局的子类
            GridLayoutAnimationController.AnimationParameters animationParameters = (GridLayoutAnimationController.AnimationParameters) params.layoutAnimationParameters;
            if (animationParameters == null) {
                animationParameters = new GridLayoutAnimationController.AnimationParameters();
                params.layoutAnimationParameters = animationParameters;
            }
            //其实这里就是要制定各个参数的值，就是根据index来计算各个view对应的值
            animationParameters.count = count;
            animationParameters.index = index;

            animationParameters.columnsCount = ((GridLayoutManager) layoutManager).getSpanCount();
            animationParameters.rowsCount = count / animationParameters.columnsCount;
            animationParameters.row = index / animationParameters.columnsCount;
            animationParameters.column = index % animationParameters.columnsCount;
        } else {
            super.attachLayoutAnimationParameters(child,params,index,count);
        }
    }
}
