package com.cdx.example.animation.activity;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.cdx.example.animation.R;

public class DrawableCodeNumberActivity extends AppCompatActivity {

    private ImageView iv;
    private AnimationDrawable drawable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_code_number);

        iv = findViewById(R.id.iv);

        initAnimationDrawable();
    }

    private void initAnimationDrawable() {
        //1、构造出AnimationDrawable对象。
        drawable = new AnimationDrawable();
        //2、往AnimationDrawable对象中添加一帧一帧。
        drawable.addFrame(getResources().getDrawable(R.drawable.num_1),800);
        drawable.addFrame(getResources().getDrawable(R.drawable.num_2),800);
        drawable.addFrame(getResources().getDrawable(R.drawable.num_3),800);
        drawable.addFrame(getResources().getDrawable(R.drawable.num_4),800);
        drawable.addFrame(getResources().getDrawable(R.drawable.num_5),800);
        //3、然后将它绑定到ImageView上。
        //我们知道在布局文件中设置帧动画，采用的是src属性，所以这个地方我们可以对应的设置src的方法
        iv.setImageDrawable(drawable);
    }

    public void start(View view){
        drawable.start();
    }

    public void stop(View view){
        drawable.stop();
    }
}
