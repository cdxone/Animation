package com.cdx.example.animation.activity;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.cdx.example.animation.R;

public class PropertyObjectAnimatorXmlAllActivity extends AppCompatActivity {

    private TextView mTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property_object_animator_xml_all);

        mTv = findViewById(R.id.tv);
    }

    public void alpha(View view){
        Animator animator = AnimatorInflater.loadAnimator(this,R.animator.anim_alpha);
        animator.setTarget(mTv);
        animator.setDuration(3000);
        animator.start();
    }

    public void set(View view){
        //加载布局集合
        Animator animator = AnimatorInflater.loadAnimator(this,R.animator.anim_set);
        animator.setDuration(5000);
        animator.setTarget(mTv);
        animator.start();
    }
}
