package com.cdx.example.animation.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.cdx.example.animation.R;

public class TweenXmlTranslateActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_xml_translate);

        findViewById(R.id.btn_translate).setOnClickListener(this);
        mIv = findViewById(R.id.iv);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.btn_translate){
            Animation animation = AnimationUtils.loadAnimation(this,R.anim.translate);
            mIv.startAnimation(animation);
        }
    }
}
