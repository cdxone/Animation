package com.cdx.example.animation.activity;

import java.util.ArrayList;

import apis.amapv2.com.listviewlibrary.activity.BaseListActivty;
import apis.amapv2.com.listviewlibrary.bean.ItemObject;

/**
 * 补间动画
 */
public class TweenAnimationActivity extends BaseListActivty {

    @Override
    protected void initData() {

        ArrayList<ItemObject> data = new ArrayList<>();
        data.add(new ItemObject("补间动画基本知识",TweenAnimationKnowledgeActivity.class));
        data.add(new ItemObject("补间动画XML方式实现大小变化",TweenXmlScaleActivity.class));
        data.add(new ItemObject("补间动画代码方式实现大小变化",TweenCodeScaleActivity.class));
        data.add(new ItemObject("补间动画XML方式实现位移变化",TweenXmlTranslateActivity.class));
        data.add(new ItemObject("补间动画代码方式实现位移变化",TweenCodeTranslateActivity.class));

        mMyListView.setData(data);
    }
}