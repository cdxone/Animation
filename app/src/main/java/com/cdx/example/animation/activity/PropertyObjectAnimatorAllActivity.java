package com.cdx.example.animation.activity;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cdx.example.animation.R;

public class PropertyObjectAnimatorAllActivity extends AppCompatActivity {

    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_object_animator_all);

        //需求
        //让TextView从屏幕外移动到屏幕内，然后旋转360度，然后同时伴有淡入淡出的效果。
        mTv = findViewById(R.id.tv);
    }

    public void all(View view) {
        //定义一个属性动画，从屏幕外移动到屏幕内的
        ObjectAnimator animatorIn = ObjectAnimator.ofFloat(mTv,"translationX",-300,200);
        animatorIn.setDuration(2000);
        //定义一个属性动画，旋转360度
        ObjectAnimator animatorRotation = ObjectAnimator.ofFloat(mTv,"rotation",0,360);
        animatorRotation.setDuration(2000);
        animatorRotation.setRepeatMode(ValueAnimator.REVERSE);
        animatorRotation.setRepeatCount(ValueAnimator.INFINITE);
        //定义一个属性动画，伴有淡入淡出的效果
        ObjectAnimator animatorAlpha = ObjectAnimator.ofFloat(mTv,"alpha",1,0);
        animatorAlpha.setDuration(2000);
        animatorAlpha.setRepeatMode(ValueAnimator.REVERSE);
        animatorAlpha.setRepeatCount(ValueAnimator.INFINITE);
        //定义一个属性动画集合
        AnimatorSet set = new AnimatorSet();
        set.play(animatorRotation) //旋转
                .after(animatorIn) //在移入动画之后执行旋转
                .with(animatorAlpha); //透明度
        set.setDuration(5000);
        set.start();
    }
}
