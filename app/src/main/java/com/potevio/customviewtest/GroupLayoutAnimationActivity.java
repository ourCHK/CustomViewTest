package com.potevio.customviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.GridLayoutAnimationController;
import android.widget.ArrayAdapter;
import android.widget.Button;

import com.potevio.customviewtest.adapter.GridLayoutAdapter;
import com.potevio.customviewtest.adapter.MyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindBitmap;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class GroupLayoutAnimationActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    MyRecyclerView recyclerView;

    List<String> mDataList;

    GridLayoutAdapter mGridLayoutAdapter;

    @BindView(R.id.add)
    Button add;

    @BindView(R.id.remove)
    Button remove;

    @OnClick({R.id.add,R.id.remove})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.add:
                add();
                break;
            case R.id.remove:
                remove();
                break;
        }
    }

    void add() {
        String addContent = mDataList.size()+"";
        mDataList.add(addContent);
        mGridLayoutAdapter.notifyItemInserted(mDataList.size() - 1);
    }

    void remove() {
        int index = mDataList.size() - 1;
        if (index >= 0) {
            mDataList.remove(index);
        }
        mGridLayoutAdapter.notifyItemRemoved(index);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_group_layout_animation);

        ButterKnife.bind(this);
        init();
    }

    void init() {
        dataInit();
        viewInit();
    }


    void dataInit() {
        mDataList = new ArrayList<>();
        for (int i=0; i<27; i++) {
            mDataList.add("String:"+i);
        }
        mGridLayoutAdapter = new GridLayoutAdapter(this,mDataList);
    }

    void viewInit() {
        recyclerView.setAdapter(mGridLayoutAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,5));
//        Animation animation = AnimationUtils.loadAnimation(this,android.R.anim.slide_in_left);
//        GridLayoutAnimationController gridLayoutAnimationController = new GridLayoutAnimationController(animation);
//        gridLayoutAnimationController.setColumnDelay(0.2f);
//        gridLayoutAnimationController.setRowDelay(0.2f);
//        gridLayoutAnimationController.setDirectionPriority(GridLayoutAnimationController.PRIORITY_COLUMN);
//        recyclerView.setLayoutAnimation(gridLayoutAnimationController);
    }
}
