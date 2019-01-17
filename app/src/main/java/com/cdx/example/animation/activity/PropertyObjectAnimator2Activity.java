package com.cdx.example.animation.activity;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cdx.example.animation.R;

public class PropertyObjectAnimator2Activity extends AppCompatActivity {

    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_object_animator2);

        mTv = findViewById(R.id.tv);
    }

    /**
     * 摇一摇
     * @param view
     */
    public void shake(View view) {
        //震动的效果，其中-5表示向左移动-5的位置，5表示向右移动5的位置
        //然后重复4次，就实现了这样震动的效果
        ObjectAnimator animator = ObjectAnimator.ofFloat(mTv,"translationX",-5,5);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setRepeatCount(4);
        animator.setDuration(50);
        animator.start();
    }
}
