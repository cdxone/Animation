package com.cdx.example.animation.activity;

import java.util.ArrayList;

import apis.amapv2.com.listviewlibrary.activity.BaseListActivty;
import apis.amapv2.com.listviewlibrary.bean.ItemObject;

public class  DrawableAnimationActivity extends BaseListActivty {

    @Override
    protected void initData() {
        ArrayList<ItemObject> data = new ArrayList<>();
        data.add(new ItemObject("帧动画基本知识",DrawableAnimationKnowledgeActivity.class));
        data.add(new ItemObject("帧动画XML方式实现数字变化",DrawableXMLNumberActivity.class));

        mMyListView.setData(data);
    }
}
