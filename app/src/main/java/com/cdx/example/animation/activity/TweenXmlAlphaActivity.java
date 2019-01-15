package com.cdx.example.animation.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.cdx.example.animation.R;

public class TweenXmlAlphaActivity extends AppCompatActivity implements View.OnClickListener{

    private Context mContext;
    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_xml_alpha);
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
        if (id == R.id.btn_alpha){//透明度变化
            Animation animation = AnimationUtils.loadAnimation(this,R.anim.alpha);
            mIv.startAnimation(animation);
        }
    }
}
