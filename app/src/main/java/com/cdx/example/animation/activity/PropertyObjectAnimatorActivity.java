package com.cdx.example.animation.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cdx.example.animation.R;

public class PropertyObjectAnimatorActivity extends AppCompatActivity {

    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_object_animator);

        mTv = findViewById(R.id.tv);
    }

    /**
     * 透明度的变化
     * @param view
     */
    public void alpha(View view) {
        //对于透明度的一个变化
        ObjectAnimator animator = ObjectAnimator.ofFloat(mTv,"alpha",1.0f,0.0f);
        animator.setDuration(2000);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(1);
        animator.start();
    }

    /**
     * 旋转的变化
     * @param view
     */
    public void rotate(View view) {
        //由于有这样的一个方法mTvResult.setRotation();
        //所以有rotation这样的属性，来让TextView进行一个旋转
        ObjectAnimator animator = ObjectAnimator.ofFloat(mTv,"rotation",0,360);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.setDuration(2000);
        animator.start();

        //注意：这个需求也可以利用ValueAnimator来实现，让它的值从0变换到360，然后在监听的方法中
        //设置TextView的setRotation（）来设置角度，这个ObjectAnimation就是将ValueAnimation的操作从两步变成了一步。
    }

    /**
     * 移动的变化
     * @param view
     */
    public void translate(View view) {
        //mTvResult.setTranslationX();
        float translationX = mTv.getTranslationX();
        ObjectAnimator animator = ObjectAnimator.ofFloat(mTv,"translationX",translationX,500);
        animator.setDuration(2000);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.start();
    }
}
