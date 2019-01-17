package com.cdx.example.animation.activity;

import java.util.ArrayList;

import apis.amapv2.com.listviewlibrary.activity.BaseListActivty;
import apis.amapv2.com.listviewlibrary.bean.ItemObject;

/**
 * 属性动画
 */
public class PropertyAnimationActivity extends BaseListActivty {

    @Override
    protected void initData() {
        ArrayList<ItemObject> data = new ArrayList<>();
        data.add(new ItemObject("属性动画的基本知识",PropertyAnimationKnowledgeActivity.class));
        data.add(new ItemObject("属性动画中ValueAnimator的使用",PropertyValueAnimatorActivity.class));
        data.add(new ItemObject("属性动画中ObjectAnimator的使用",PropertyObjectAnimatorActivity.class));
        data.add(new ItemObject("属性动画中ObjectAnimator实现摇一摇",PropertyObjectAnimator2Activity.class));

        mMyListView.setData(data);
    }
}
