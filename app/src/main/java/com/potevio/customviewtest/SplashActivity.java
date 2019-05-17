package com.potevio.customviewtest;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SplashActivity extends AppCompatActivity {

    String TAG = SplashActivity.class.getSimpleName();

    @BindView(R.id.fixButton)
    Button fixButton;

    @BindView(R.id.showButton1)
    Button showButton1;

    @BindView(R.id.showButton2)
    Button showButton2;

    @BindView(R.id.showButton3)
    Button showButton3;

    @BindView(R.id.showButton4)
    Button showButton4;

    @BindView(R.id.showButton5)
    Button showButton5;

    boolean isOpen;

    float fixXPosition;
    float fixYPosition;

    int length = 400;
    int duration = 200;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ButterKnife.bind(this);
        initData();
    }

    @OnClick({R.id.fixButton,R.id.showButton1,R.id.showButton2,R.id.showButton3,R.id.showButton4,R.id.showButton5})
    void onClick(View view) {
        switch (view.getId()) {
            case R.id.fixButton:
                if (!isOpen) {
                    doOpenFixAnimator(fixButton);
                    doOpenAnimator(showButton1,0,4,length);
                    doOpenAnimator(showButton2,1,4,length);
                    doOpenAnimator(showButton3,2,4,length);
                    doOpenAnimator(showButton4,3,4,length);
                    doOpenAnimator(showButton5,4,4,length);
                    isOpen = true;
                } else {
                    doCloseFixAnimator(fixButton);
                    doCloseAnimator(showButton1,0,4,length);
                    doCloseAnimator(showButton2,1,4,length);
                    doCloseAnimator(showButton3,2,4,length);
                    doCloseAnimator(showButton4,3,4,length);
                    doCloseAnimator(showButton5,4,4,length);
                    isOpen = false;
                }
                break;
            case R.id.showButton1:
                Toast.makeText(this, "you click the button 1", Toast.LENGTH_SHORT).show();
                break;
            case R.id.showButton2:
                Toast.makeText(this, "you click the button 2", Toast.LENGTH_SHORT).show();
                break;
            case R.id.showButton3:
                Toast.makeText(this, "you click the button 3", Toast.LENGTH_SHORT).show();
                break;
            case R.id.showButton4:
                Toast.makeText(this, "you click the button 4", Toast.LENGTH_SHORT).show();
                break;
            case R.id.showButton5:
                Toast.makeText(this, "you click the button 5", Toast.LENGTH_SHORT).show();
                break;
        }
    }

    void initData() {
        fixXPosition = fixButton.getX() + fixButton.getWidth() / 2;
        fixYPosition = fixButton.getY() + fixButton.getHeight() / 2;
        Log.i(TAG,"fixX:"+fixXPosition+"  fixY:"+fixYPosition);
    }

    void openAnimator() {
        isOpen = true;
        ObjectAnimator button1YObjectAnimator = ObjectAnimator.ofFloat(showButton1,"translationY",0f,-length);
        ObjectAnimator button1XObjectAnimator = ObjectAnimator.ofFloat(showButton1,"translationX",0f,0);

        ObjectAnimator button2YObjectAnimator = ObjectAnimator.ofFloat(showButton2,"translationY",0f,-(float)(length * Math.cos(Math.PI/8)));
        ObjectAnimator button2XObjectAnimator = ObjectAnimator.ofFloat(showButton2,"translationX",0f,-(float)(length * Math.sin(Math.PI/8)));


        ObjectAnimator button3YObjectAnimator = ObjectAnimator.ofFloat(showButton3,"translationY",0f,-(float)(length * Math.cos(Math.PI/4)));
        ObjectAnimator button3XObjectAnimator = ObjectAnimator.ofFloat(showButton3,"translationX",0f,-(float)(length * Math.sin(Math.PI/4)));


        ObjectAnimator button4YObjectAnimator = ObjectAnimator.ofFloat(showButton4,"translationY",0f,-(float)(length * Math.cos(Math.PI * 3/8)));
        ObjectAnimator button4XObjectAnimator = ObjectAnimator.ofFloat(showButton4,"translationX",0f,-(float)(length * Math.sin(Math.PI * 3/8)));


        ObjectAnimator button5YObjectAnimator = ObjectAnimator.ofFloat(showButton5,"translationY",0f,0);
        ObjectAnimator button5XObjectAnimator = ObjectAnimator.ofFloat(showButton5,"translationX",0f,-(float)(length * Math.sin(Math.PI/2)));


        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(button1XObjectAnimator,button1YObjectAnimator,
                button2XObjectAnimator,button2YObjectAnimator,
                button3XObjectAnimator,button3YObjectAnimator,
                button4XObjectAnimator,button4YObjectAnimator,
                button5XObjectAnimator,button5YObjectAnimator);
        animatorSet.setDuration(duration);
        animatorSet.start();
    }

    void closeAnimator() {
        isOpen = false;
        ObjectAnimator button1YObjectAnimator = ObjectAnimator.ofFloat(showButton1,"translationY",-length,0f);
        ObjectAnimator button1XObjectAnimator = ObjectAnimator.ofFloat(showButton1,"translationX",0f,0);

        ObjectAnimator button2YObjectAnimator = ObjectAnimator.ofFloat(showButton2,"translationY",-(float)(length * Math.cos(Math.PI/8)),0f);
        ObjectAnimator button2XObjectAnimator = ObjectAnimator.ofFloat(showButton2,"translationX",-(float)(length * Math.sin(Math.PI/8)),0f);


        ObjectAnimator button3YObjectAnimator = ObjectAnimator.ofFloat(showButton3,"translationY",-(float)(length * Math.cos(Math.PI/4)),0f);
        ObjectAnimator button3XObjectAnimator = ObjectAnimator.ofFloat(showButton3,"translationX",-(float)(length * Math.sin(Math.PI/4)),0f);


        ObjectAnimator button4YObjectAnimator = ObjectAnimator.ofFloat(showButton4,"translationY",-(float)(length * Math.cos(Math.PI * 3/8)),0f);
        ObjectAnimator button4XObjectAnimator = ObjectAnimator.ofFloat(showButton4,"translationX",-(float)(length * Math.sin(Math.PI * 3/8)),0f);


        ObjectAnimator button5YObjectAnimator = ObjectAnimator.ofFloat(showButton5,"translationY",0f,0);
        ObjectAnimator button5XObjectAnimator = ObjectAnimator.ofFloat(showButton5,"translationX",-(float)(length * Math.sin(Math.PI/2)),0f);


        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(button1XObjectAnimator,button1YObjectAnimator,
                button2XObjectAnimator,button2YObjectAnimator,
                button3XObjectAnimator,button3YObjectAnimator,
                button4XObjectAnimator,button4YObjectAnimator,
                button5XObjectAnimator,button5YObjectAnimator);
        animatorSet.setDuration(duration);
        animatorSet.start();
    }

    void doOpenFixAnimator(View view) {
        ObjectAnimator angleObjectAnimator = ObjectAnimator.ofFloat(view,"rotation",0,45);
        angleObjectAnimator.setDuration(duration);
        angleObjectAnimator.start();
    }

    void doCloseFixAnimator(View view) {
        ObjectAnimator angleObjectAnimator = ObjectAnimator.ofFloat(view,"rotation",45,0);
        angleObjectAnimator.setDuration(duration);
        angleObjectAnimator.start();
    }


    void doOpenAnimator(View view,float index,float total,int length) {
        double angle = index / total * Math.PI / 2;
        float detalX = (float) (length * Math.sin(angle));
        float detalY = (float) (length * Math.cos(angle));

        ObjectAnimator objectXAnimator = ObjectAnimator.ofFloat(view,"translationX",0,-detalX);
        ObjectAnimator objectYAnimator = ObjectAnimator.ofFloat(view,"translationY",0,-detalY);
        ObjectAnimator objectAlphaAnimator = ObjectAnimator.ofFloat(view,"alpha",0,1);
        ObjectAnimator objectScaleXAnimator = ObjectAnimator.ofFloat(view,"scaleX",0.1f,1);
        ObjectAnimator objectScaleYAnimator = ObjectAnimator.ofFloat(view,"scaleY",0.1f,1);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectXAnimator,objectYAnimator,objectAlphaAnimator,objectScaleXAnimator,objectScaleYAnimator);
        animatorSet.setDuration(duration);
        animatorSet.start();
    }

    void doCloseAnimator(View view,float index,float total,int length) {
        double angle = index / total * Math.PI / 2;
        float detalX = (float) (length * Math.sin(angle));
        float detalY = (float) (length * Math.cos(angle));

        ObjectAnimator objectXAnimator = ObjectAnimator.ofFloat(view,"translationX",-detalX,0);
        ObjectAnimator objectYAnimator = ObjectAnimator.ofFloat(view,"translationY",-detalY,0);
        ObjectAnimator objectAlphaAnimator = ObjectAnimator.ofFloat(view,"alpha",1,0);
        ObjectAnimator objectScaleXAnimator = ObjectAnimator.ofFloat(view,"scaleX",1,0.1f);
        ObjectAnimator objectScaleYAnimator = ObjectAnimator.ofFloat(view,"scaleY",1,0.1f);

        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(objectXAnimator,objectYAnimator,objectAlphaAnimator,objectScaleXAnimator,objectScaleYAnimator);
        animatorSet.setDuration(duration);
        animatorSet.start();
    }









}
