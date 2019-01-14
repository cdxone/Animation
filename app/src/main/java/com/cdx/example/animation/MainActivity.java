package com.cdx.example.animation;


import com.cdx.example.animation.activity.AnimationKnowledgeActivity;

import java.util.ArrayList;

import apis.amapv2.com.listviewlibrary.activity.BaseListActivty;
import apis.amapv2.com.listviewlibrary.bean.ItemObject;

public class MainActivity extends BaseListActivty {

    @Override
    protected void initData() {

        ArrayList<ItemObject> data = new ArrayList<>();
        data.add(new ItemObject("动画的基本知识",AnimationKnowledgeActivity.class));

        mMyListView.setData(data);
    }
}
