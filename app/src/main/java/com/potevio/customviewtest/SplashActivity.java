package com.potevio.customviewtest;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
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

    float length = 200f;

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
                Toast.makeText(this,"you click the fixButton",Toast.LENGTH_SHORT).show();
                if (!isOpen)
                    openAnimator();
                else
                    closeAnimator();
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
        Log.i(TAG,showButton1.getX()+"  "+showButton1.getWidth()+"   "+showButton1.getLeft());
        Log.i(TAG,showButton1.getY()+"  "+showButton1.getWidth()+"   "+showButton1.getTop());
        isOpen = true;
//        ObjectAnimator button1ObjectAnimator = ObjectAnimator.ofFloat(showButton1,"translationY",showButton1.getY(),(showButton1.getY()-length));
//        button1ObjectAnimator.setDuration(1000);
//        button1ObjectAnimator.start();

        ObjectAnimator fixObjectAnimator = ObjectAnimator.ofFloat(fixButton,"translationX",fixButton.getLeft(),fixButton.getLeft()-length);
        fixObjectAnimator.setDuration(1000);
        fixObjectAnimator.start();
    }

    void closeAnimator() {
        isOpen = false;
        Log.i(TAG,showButton1.getX()+"  "+showButton1.getWidth()+"   "+showButton1.getLeft());
        Log.i(TAG,showButton1.getY()+"  "+showButton1.getWidth()+"   "+showButton1.getTop());
        ObjectAnimator button1ObjectAnimator = ObjectAnimator.ofFloat(showButton1,"translationY",showButton1.getY(),(showButton1.getY()+length));
        button1ObjectAnimator.setDuration(1000);
        button1ObjectAnimator.start();
    }
}
