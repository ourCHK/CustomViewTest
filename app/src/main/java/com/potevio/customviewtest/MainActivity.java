package com.potevio.customviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.scale)
    Button scale;

    @BindView(R.id.translate)
    Button trans;

    @BindView(R.id.rotate)
    Button rotate;

    @BindView(R.id.alpha)
    Button alpha;

    @BindView(R.id.animSet)
    Button animSet;

    @BindView(R.id.displayTextView)
    TextView display;

    @BindView(R.id.imageView)
    ImageView imageView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
    }

    @OnClick({R.id.alpha,R.id.rotate,R.id.translate,R.id.scale,R.id.displayTextView,R.id.animSet})
    void onClick(View view) {
        int AnimationId = 0;
        switch (view.getId()) {
            case R.id.alpha:
                AnimationId = R.anim.alphaanim;
                break;
            case R.id.rotate:
                AnimationId = R.anim.rotateanim;
                break;
            case R.id.translate:
                AnimationId = R.anim.transanim;
                break;
            case R.id.scale:
                AnimationId = R.anim.scaleanim;
                break;
            case R.id.animSet:
                AnimationId = R.anim.animset;
                break;
            case R.id.displayTextView:
                Toast.makeText(this, "you click this!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.imageView:
                break;
        }
        display.setVisibility(View.VISIBLE);
        try {
            Animation animation = AnimationUtils.loadAnimation(this,AnimationId);
            if (animation != null)
                display.startAnimation(animation);
        } catch (Exception e) {

        }

    }
}
