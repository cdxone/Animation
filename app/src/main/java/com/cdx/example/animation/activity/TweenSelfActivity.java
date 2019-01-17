package com.cdx.example.animation.activity;

import java.util.ArrayList;

import apis.amapv2.com.listviewlibrary.activity.BaseListActivty;
import apis.amapv2.com.listviewlibrary.bean.ItemObject;

/**
 * 自定义补间动画的效果
 */
public class TweenSelfActivity extends BaseListActivty {

    @Override
    protected void initData() {
        ArrayList<ItemObject> data = new ArrayList<>();
        data.add(new ItemObject("自定义补间动画知识",TweenSelfKnowledgeActivity.class));
        data.add(new ItemObject("自定义补间动画知识",TweenSelfRotateActivity.class));

        mMyListView.setData(data);
    }
}
