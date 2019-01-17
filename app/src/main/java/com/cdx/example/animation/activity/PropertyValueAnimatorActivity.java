package com.cdx.example.animation.activity;

import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.TextView;

import com.cdx.example.animation.R;

public class PropertyValueAnimatorActivity extends AppCompatActivity implements View.OnClickListener{

    private static final String TAG = PropertyValueAnimatorActivity.class.getSimpleName();
    private TextView mTvResult;
    private Button mBtnValueAnimator;
    private ValueAnimator mAnimator;
    private Button mBtnCancelValueAnimator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_value_animator);

        initView();
    }

    private void initView() {
        mTvResult = findViewById(R.id.tv_result);
        mBtnValueAnimator = findViewById(R.id.btn_ValueAnimator);
        mBtnValueAnimator.setOnClickListener(this);
        mBtnCancelValueAnimator = findViewById(R.id.btn_cancel_ValueAnimator);
        mBtnCancelValueAnimator.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_ValueAnimator://属性动画
                startValueAnimator();
                break;
            case R.id.btn_cancel_ValueAnimator://关闭属性动画
                cancelValueAnimator();
        }
    }

    private void startValueAnimator() {
        //让动画的设置状态设置一次
        //使用ValueAnimator创建动画的4个步骤（Good）

        if (mAnimator==null){
            //1、调用ValueAnimator的ofInt()，ofFloat()，ofObject()静态方法创建ValueObject对象
            mAnimator = ValueAnimator.ofFloat(1.0f,2.0f);
            //2、调用ValueAnimator的setXxx()方法设置动画持续时间，差值方式，重复次数等
            mAnimator.setDuration(2000);//设置动画持续的时间
            mAnimator.setStartDelay(2000);//设置动画延迟播放时间
            mAnimator.setRepeatMode(ValueAnimator.RESTART);//重新开始  REVERSE:从后往前
            mAnimator.setRepeatCount(Animation.INFINITE);//表示无限循环 值为-1  INFINITE:无限
            //3、为ValueAnimator注册AnimatorUpdateListener监听器，监听计算出来的ValueAnimator计算出来的值的改变
            mAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {//设置动画的监听
                @Override
                public void onAnimationUpdate(ValueAnimator valueAnimator) {
                    Float value = (Float) valueAnimator.getAnimatedValue();
                    mTvResult.setText(value+"");
                }
            });

        }
        //4、让动画不要反复的开启
        if(!mAnimator.isStarted()){
            mAnimator.start();
        }
    }

    private void cancelValueAnimator() {
        if (mAnimator != null){
            //取消动画
            mAnimator.cancel();
            //当取消状态的时候，动画的isStarted() 和 isRunning()为false
            Log.e(TAG, "isRunning:"+mAnimator.isRunning());
            Log.e(TAG, "isStarted:"+mAnimator.isStarted());
        }
    }

}
