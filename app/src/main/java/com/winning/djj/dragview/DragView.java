package com.winning.djj.dragview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.TextView;

import com.nineoldandroids.view.ViewHelper;

/**
 * 描述:
 * 作者|时间: djj on 2019/3/30 21:15
 * 博客地址: http://www.jianshu.com/u/dfbde65a03fc
 */


@SuppressLint("AppCompatCustomView")
public class DragView extends TextView {
    private int mLastX;
    private int mLastY;

    public DragView(Context context) {
        super(context);
        initView();
    }

    public DragView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }


    private void initView() {
        setBackgroundColor(Color.BLUE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getRawX();
        int y = (int) event.getRawY();

        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                //记录触摸点的坐标
//                mLastX = (int) event.getX();
//                mLastY = (int) event.getY();
                break;
            case MotionEvent.ACTION_MOVE:
                //计算偏移量
                int deltaX = x - mLastX;
                int deltaY = x - mLastY;
                //当前情况下加上偏移量
                int translationX = (int) (ViewHelper.getTranslationX(this) + deltaX);
                int translationY = (int) (ViewHelper.getTranslationY(this) + deltaY);
                ViewHelper.setTranslationX(this, translationX);
                ViewHelper.setTranslationY(this, translationY);

                //在当前left,top,right,bottom的基础上加上便宜量
                //layout(getLeft() + deltaX, getTop() + deltaY, getRight() + deltaX, getBottom() + deltaY);

                break;
            case MotionEvent.ACTION_UP:

                break;
            default:
                break;
        }
        mLastX = x;
        mLastY = y;
        return true;
    }
}
