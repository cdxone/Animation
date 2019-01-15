package com.cdx.example.animation.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import com.cdx.example.animation.R;

public class TweenCodeRotateActivity extends AppCompatActivity implements View.OnClickListener{

    private Context mContext;
    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_code_rotate);

        initParamsAndValues();
        initView();
    }

    private void initParamsAndValues() {
        mContext = this;
    }

    private void initView() {
        findViewById(R.id.btn).setOnClickListener(this);
        mIv = findViewById(R.id.iv);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn){//旋转动画

            //构造函数如下
            //public RotateAnimation(float fromDegrees, float toDegrees)
            //public RotateAnimation(float fromDegrees, float toDegrees, float pivotX, float pivotY)
            //public RotateAnimation(float fromDegrees, float toDegrees, int pivotXType,
            //float pivotXValue,int pivotYType, float pivotYValue)

            //参数如下：
            //fromDegrees：动画开始时的旋转角度。
            //toDegress：动画结束时的旋转角度。
            //pivotXType：动画在X轴的旋转模式，相对于物件的位置类型，取值是
            //Animation.ABSOLUTE  或者 Animation.RELATIVE_TO_SELF 或者Andimation.RELATIVE_TO_PATENT
            //pivotXValue：动画相对于物件的X坐标开始的位置
            //pivotYType：动画在Y轴的旋转模式，相对于物件的位置类型，取值是
            //Animation.ABSOLUTE  或者 Animation.RELATIVE_TO_SELF 或者Andimation.RELATIVE_TO_PATENT
            //pivotYValue：动画相对于物件的Y坐标开始的位置

            float fromDegrees = 0;
            float toDegrees = 360;
            int pivotXType = Animation.RELATIVE_TO_SELF;
            float pivotXValue = 0.5f;//以中间作为标准
            int pivotYType = Animation.RELATIVE_TO_SELF;
            float pivotYValue = 0.5f;//以中间作为标准
            RotateAnimation rotateAnimation = new RotateAnimation(fromDegrees,toDegrees,pivotXType,pivotXValue, pivotYType,pivotYValue);
            rotateAnimation.setDuration(2000);
            rotateAnimation.setRepeatCount(10);
            rotateAnimation.setRepeatMode(Animation.RESTART);

            mIv.startAnimation(rotateAnimation);
        }
    }
}
