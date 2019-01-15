package com.cdx.example.animation.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.ImageView;

import com.cdx.example.animation.R;

public class TweenCodeScaleActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_code_scale);

        initParamsAndValues();

        initView();
    }

    private void initParamsAndValues() {
        mContext = this;
    }

    private void initView() {
        findViewById(R.id.btn_alpha).setOnClickListener(this);
        mIv = findViewById(R.id.iv);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_alpha){
            //构造函数如下,可以选择其中的一个
            //public ScaleAnimation(float fromX, float toX, float fromY, float toY)
            //public ScaleAnimation(float fromX, float toX, float fromY, float toY,float pivotX, float pivotY)
            //public ScaleAnimation(float fromX, float toX, float fromY, float toY,int pivotXType,
            //float pivotXValue, int pivotYType, float pivotYValue)

            //其中参数如下：
            //fromX:动画开始时X轴的伸缩尺寸。
            //toX:动画结束时X轴的伸缩尺寸。
            //fromY:动画开始时Y轴的伸缩尺寸。
            //toY:动画结束时Y轴的伸缩尺寸。
            //pivotX/pivotXValue:缩放动画中心的X坐标。
            //pivotY/pivotYValue:缩放动画中心的Y坐标。
            //pivotXType：动画在X轴的伸缩模式，也就是中心点相对于哪个物件，
            //取值Animation.ABSOLUTE,Animation.RELATIVE_TO_SELF 或者Andimation.RELATIVE_TO_PATENT
            //pivotYType：动画在Y轴的伸缩模式，也就是中心点相对于哪个物件，
            //取值Animation.ABSOLUTE,Animation.RELATIVE_TO_SELF 或者Andimation.RELATIVE_TO_PATENT

            float fromX = 1;
            float toX = 0;
            float fromY = 1;
            float toY = 0.5f;
            int pivotXType = Animation.RELATIVE_TO_SELF;
            float pivotXValue = 0.5f;
            int pivotYType = Animation.RELATIVE_TO_SELF ;
            float pivotYValue = 0.5f;
            ScaleAnimation scaleAnimation = new ScaleAnimation(fromX,toX,fromY,toY, pivotXType,pivotXValue,pivotYType,pivotYValue);
            scaleAnimation.setRepeatCount(3);
            scaleAnimation.setRepeatMode(Animation.RESTART);
            scaleAnimation.setDuration(3000);

            mIv.startAnimation(scaleAnimation);
        }
    }
}
