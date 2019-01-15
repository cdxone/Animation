package com.cdx.example.animation.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.cdx.example.animation.R;

public class TweenInfiniteActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private ImageView mIv1;
    private ImageView mIv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_infinite);

        initParamsAndValues();

        initView();
    }

    private void initParamsAndValues() {
        mContext = this;
    }

    private void initView() {
        findViewById(R.id.btn1).setOnClickListener(this);
        findViewById(R.id.btn2).setOnClickListener(this);
        mIv1 = findViewById(R.id.iv1);
        mIv2 = findViewById(R.id.iv2);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn1){
            //第一种方式：通过在动画的xml文件中设置android:repeatCount="infinite"
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.infinite_rotate);
            mIv1.startAnimation(animation);
        } else if (id == R.id.btn2){
            //第二种方式：通过监听来控制无限动画
            Animation animation = AnimationUtils.loadAnimation(this, R.anim.infinite_rotate2);
            animation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {

                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    animation.reset(); //动画重置
                    animation.setAnimationListener(this);
                    animation.start();
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });
           mIv2.startAnimation(animation);
        }
    }
}
