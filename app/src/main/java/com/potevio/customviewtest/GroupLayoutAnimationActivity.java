package com.potevio.customviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.ArrayAdapter;

import com.potevio.customviewtest.adapter.GridLayoutAdapter;
import com.potevio.customviewtest.adapter.MyRecyclerView;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class GroupLayoutAnimationActivity extends AppCompatActivity {

    @BindView(R.id.recyclerView)
    MyRecyclerView recyclerView;

    List<String> mDataList;

    GridLayoutAdapter mGridLayoutAdapter;

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
        mGridLayoutAdapter = new GridLayoutAdapter(mDataList);
    }

    void viewInit() {
        recyclerView.setAdapter(mGridLayoutAdapter);
        recyclerView.setLayoutManager(new GridLayoutManager(this,5));
    }
}
