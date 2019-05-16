package com.potevio.customviewtest;

import android.animation.Animator;
import android.animation.IntEvaluator;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.TimeInterpolator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ValueAnimatorActivity extends AppCompatActivity {

    String TAG = ValueAnimatorActivity.class.getSimpleName();

    @BindView(R.id.startValueAnimation)
    Button startValueAnimation;

    @BindView(R.id.displayTextView)
    TextView displayTextView;

    @BindView(R.id.cancel)
    Button cancel;

    @BindView(R.id.reset)
    Button reset;

    Animator animator;
    ValueAnimator valueAnimator;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animator);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.startValueAnimation,R.id.displayTextView,R.id.cancel,R.id.reset})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.startValueAnimation:
//                animator = doObjectAnimation(displayTextView);
//                animator = doObjectAnimationWithPropertyValueHolder(displayTextView);
                animator = doObjectAnimationWithPropertyValueHolderKeyFrame(displayTextView);

                break;
            case R.id.displayTextView:
                Toast.makeText(this, "you click the displayTextView", Toast.LENGTH_SHORT).show();
                break;
            case R.id.cancel:
                if (animator != null)
                    animator.cancel();
                break;
            case R.id.reset:
                resetView(displayTextView);
                break;
        }
    }


    private Animator doObjectAnimationWithPropertyValueHolderKeyFrame(final View view) {
        Keyframe keyframe1 = Keyframe.ofFloat(0,0);
        Keyframe keyframe2 = Keyframe.ofFloat(0.5f,60);
        Keyframe keyframe3 = Keyframe.ofFloat(1,0);
//        Keyframe keyframe4 = Keyframe.ofFloat(0,0);
//        Keyframe keyframe5 = Keyframe.ofFloat(0,0);
        PropertyValuesHolder keyFramePropertyValuesHolder = PropertyValuesHolder.ofKeyframe("Rotation",keyframe1,keyframe2,keyframe3);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view,keyFramePropertyValuesHolder);
        objectAnimator.setDuration(100);
        objectAnimator.start();
        return objectAnimator;
    }

    private Animator doObjectAnimationWithPropertyValueHolder(final View view) {
        PropertyValuesHolder rotatePropertyValuesHolder = PropertyValuesHolder.ofFloat("Rotation",60,-60,40,-40,20,-20,10,-10,0);
        PropertyValuesHolder scaleXPropertyValuesHolder = PropertyValuesHolder.ofFloat("scaleX",2,1);
        PropertyValuesHolder scaleYPropertyValuesHolder = PropertyValuesHolder.ofFloat("scaleY",2,1);
        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(view,rotatePropertyValuesHolder,scaleXPropertyValuesHolder,scaleYPropertyValuesHolder);
        objectAnimator.setDuration(1000);
        objectAnimator.setRepeatCount(ObjectAnimator.INFINITE);
        objectAnimator.setRepeatMode(ValueAnimator.REVERSE);
        objectAnimator.start();
        return objectAnimator;
    }

    private void resetView(View view) {
        view.setScaleX(1);
        view.setScaleY(1);
        view.setRotation(0);
    }

    private ObjectAnimator doObjectAnimation(final View view) {
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(view,"alpha",1,0,1);
        objectAnimator.setDuration(2000);
        objectAnimator.start();
        return objectAnimator;

    }



    private ValueAnimator doValueAnimation(final View view) {
        ValueAnimator valueAnimator = ValueAnimator.ofObject(new MyCharEvalutor(),new Character('A'),new Character('Z'));
//        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
//        valueAnimator.setRepeatCount(1);
        valueAnimator.setDuration(5000);
        final int initLeft = view.getLeft();
        final int initTop = view.getTop();
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
//                int curValue = (int)animation.getAnimatedValue();
                char curChar = (char)animation.getAnimatedValue();
                ((TextView)view).setText(curChar+"");
//                view.setBackgroundColor(curChar);
//                view.layout(initLeft+curValue,initTop+curValue,initLeft+curValue+view.getWidth(),initTop+curValue+view.getHeight());
                Log.i(TAG,"curValue:"+curChar);
            }
        });
        valueAnimator.setInterpolator(new BounceInterpolator());
        valueAnimator.setEvaluator(new MyCharEvalutor());
        valueAnimator.start();
        return valueAnimator;
    }

//    private ValueAnimator doValueObjectAnimation(final View view) {
//        ValueAnimator valueAnimator = ValueAnimator.ofObject();
//    }

    class MyCharEvalutor implements TypeEvaluator<Character> {
        @Override
        public Character evaluate(float fraction, Character startValue, Character endValue) {
            char curValue = (char)((int)(startValue + fraction * (endValue.charValue() - startValue.charValue())));

            return new Character(curValue);
        }
    }


    class MyInterpolator implements TimeInterpolator {
        @Override
        public float getInterpolation(float input) {
             return 1-input;
        }
    }

    class MyEvalutor implements TypeEvaluator<Integer> {

        @Override
        public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
            return (int)(startValue + fraction * (endValue - startValue));
//            return null;
        }

    }
}
