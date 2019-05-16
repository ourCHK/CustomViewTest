package com.potevio.customviewtest;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class AnimatorXMLActivity extends AppCompatActivity {

    @BindView(R.id.start)
    Button start;

    @BindView(R.id.displayTextView)
    TextView displayTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_xml);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.start,R.id.displayTextView})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.start:
//                doValueAnimator(displayTextView);
//                doObjectAnimator(displayTextView);
                doSetObjectAnimator(displayTextView);
                break;
        }
    }

    void doValueAnimator(final View view) {

        final int initLeft = view.getLeft();
        final int initTop = view.getTop();

        ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(this,R.animator.value_animator);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int)animation.getAnimatedValue();
                view.layout(initLeft+curValue,initTop+curValue,initLeft+curValue+view.getWidth(),initTop+curValue+view.getHeight());
            }
        });
        valueAnimator.start();

    }

    void doObjectAnimator(final View view) {
        ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(this,R.animator.object_animator);
        objectAnimator.setTarget(view);
        objectAnimator.start();
    }

    void doColorObjectAnimator(final View view) {
        ObjectAnimator objectAnimator = (ObjectAnimator) AnimatorInflater.loadAnimator(this,R.animator.color_animator);
        objectAnimator.setTarget(view);
        objectAnimator.start();
    }


    void doSetObjectAnimator(final View view) {
        AnimatorSet set = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.set_animator);
        set.setTarget(view);
        set.start();
    }
}
