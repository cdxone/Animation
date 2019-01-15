package com.cdx.example.animation.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.cdx.example.animation.R;

public class TweenXmlScaleActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext;
    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_xml_scale);

        initParamsAndValues();

        initView();
    }

    private void initParamsAndValues() {
        mContext = this;
    }

    private void initView() {
        findViewById(R.id.btn_scale).setOnClickListener(this);
        mIv = findViewById(R.id.iv);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_scale){//大小变化
            //1、加载动画。
            Animation rotate = AnimationUtils.loadAnimation(this,R.anim.scale);
            //2、给ImageView设置动画。
            mIv.startAnimation(rotate);
        }
    }
}
