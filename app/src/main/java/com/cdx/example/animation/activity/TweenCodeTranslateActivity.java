package com.cdx.example.animation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.BounceInterpolator;
import android.view.animation.Interpolator;
import android.view.animation.TranslateAnimation;
import android.widget.ImageView;

import com.cdx.example.animation.R;

public class TweenCodeTranslateActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_code_translate);

        findViewById(R.id.btn_translate).setOnClickListener(this);
        mIv = findViewById(R.id.iv);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_translate){
            //构造函数如下：
            //public TranslateAnimation(float fromXDelta, float toXDelta, float fromYDelta, float toYDelta)
            //public TranslateAnimation(int fromXType, float fromXValue, int toXType, float toXValue,
            //int fromYType, float fromYValue, int toYType, float toYValue)

            //其中的参数如下：
            //fromXType：动画开始时在X轴的位移模式，取值Animation.ABSOLUTE
            //Animation.RELATIVE_TO_SELF 或者Andimation.RELATIVE_TO_PATENT
            //fromXValue / fromXDelta:动画开始时，当前View的X坐标。
            //toXType：动画结束时在X轴的位移模式，取值Animation.ABSOLUTE
            //Animation.RELATIVE_TO_SELF 或者Andimation.RELATIVE_TO_PATENT
            //toXValue / toXDelta：动画结束时，当前View的X坐标。
            //剩下的关于Y的参数和X的参数是一样的。

            float fromXDelta = 0;
            float toXDelta = 500;
            float fromYDelta = 0;
            float toYDelta = 1000;
            TranslateAnimation translateAnimation = new TranslateAnimation(fromXDelta,toXDelta,fromYDelta,toYDelta);
            translateAnimation.setDuration(2000);
            translateAnimation.setInterpolator(new BounceInterpolator());
            translateAnimation.setRepeatCount(3);
            translateAnimation.setRepeatMode(Animation.RESTART);

            mIv.startAnimation(translateAnimation);
        }
    }
}
