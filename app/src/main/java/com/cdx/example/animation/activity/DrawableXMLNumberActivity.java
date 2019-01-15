package com.cdx.example.animation.activity;

import android.content.Context;
import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.cdx.example.animation.R;

public class DrawableXMLNumberActivity extends AppCompatActivity {

    private ImageView mIv;
    private Context mContext;
    private AnimationDrawable drawable;//动画对象

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_animation_number);

        mContext = this;
        mIv = findViewById(R.id.iv);
        //注意:
        //1、由于ImageView的src属性引用的是一个帧动画资源，所以，在这个地方通过getDrawable(）
        //获得的Drawable对象就是一个AnimationDrawable对象。）
        //2、这地方通过getDrawable()来获得AnimationDrawable对象。❤：也可以用过getBackground来获得AnimationDrawable对象。
        //但是必须和布局文件中的进行对应，如果布局文件ImageView使用的是src属性，那么此时获得AnimationDrawable的方式就是getDrawable
        //如果布局文件中ImageView使用的是background属性，那么此时获得AnimationDrawable的方式就是getBackground方式。
        drawable = (AnimationDrawable) mIv.getDrawable();
    }

    public void start(View view) {
        //开始动画
        drawable.start();
    }

    public void stop(View view) {
        //停止动画
        drawable.stop();
    }
}
