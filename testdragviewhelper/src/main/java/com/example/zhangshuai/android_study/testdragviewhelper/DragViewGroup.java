package com.example.zhangshuai.android_study.testdragviewhelper;

import android.content.Context;
import android.support.v4.view.ViewCompat;
import android.support.v4.widget.ViewDragHelper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.FrameLayout;

/**
 * Created by zhanglin on 15/12/6.
 */
public class DragViewGroup extends FrameLayout{
    private ViewDragHelper mViewDragHelper;
    private View mMenuView;
    private View mMainView;
    private MViewDragCallback mViewDragCallback = new MViewDragCallback();
    public DragViewGroup(Context context) {
        super(context);
        initView();
    }

    public DragViewGroup(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    public DragViewGroup(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView();
    }
    private void initView(){
        mViewDragHelper = ViewDragHelper.create(this, mViewDragCallback);
    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        mMenuView = getChildAt(0);
        mMainView = getChildAt(1);
    }



    @Override
    public boolean onTouchEvent(MotionEvent event) {
        mViewDragHelper.processTouchEvent(event);
        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        return mViewDragHelper.shouldInterceptTouchEvent(ev);
    }

    @Override
    public void computeScroll() {
        if(mViewDragHelper.continueSettling(true)){
            ViewCompat.postInvalidateOnAnimation(this);
        }
    }
    private class MViewDragCallback extends ViewDragHelper.Callback{

        @Override
        public boolean tryCaptureView(View child, int pointerId) {
            return mMainView == child;
        }

        @Override
        public int clampViewPositionHorizontal(View child, int left, int dx) {
            if(left>mMenuView.getWidth()){
                if(left>mMenuView.getWidth()+100){
                    left = mMenuView.getWidth()+100;
                }else{
                    left = left - (left - mMenuView.getWidth())*(9/10);
                }
            }else if(left<0){
                left =  0;
            }
            return left;
        }

        @Override
        public int clampViewPositionVertical(View child, int top, int dy) {
            return 0;
        }

        @Override
        public void onViewReleased(View releasedChild, float xvel, float yvel) {
            super.onViewReleased(releasedChild, xvel, yvel);
            if(mMainView == releasedChild){
                if(mMainView.getLeft() < mMenuView.getWidth()/2){
                    mViewDragHelper.smoothSlideViewTo(mMainView, 0, 0);
                    ViewCompat.postInvalidateOnAnimation(DragViewGroup.this);
                }else{
                    mViewDragHelper.smoothSlideViewTo(mMainView, mMenuView.getWidth(), 0);
                    ViewCompat.postInvalidateOnAnimation(DragViewGroup.this);
                }
            }
        }
    }
}
