package com.example.zhangshuai.android_study.cusview.bt_0;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Scroller;
import android.widget.TextView;

/**
 * Created by zhanglin on 15/11/21.
 */
public class BT0CusView extends TextView {
    Paint cusPaint_0;
    Paint cusPaint_1;
    Scroller scroller;
    ViewGroup vp;

    public BT0CusView(Context context) {
        super(context);
        scroller = new Scroller(context);
        vp = (ViewGroup) getParent();
    }

    public BT0CusView(Context context, AttributeSet attrs) {
        super(context, attrs);
        scroller = new Scroller(context);
        vp = (ViewGroup) getParent();
    }

    public BT0CusView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        scroller = new Scroller(context);
        vp = (ViewGroup) getParent();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        initPaint();
        canvas.save();
        canvas.drawRect(0, 0, getMeasuredWidth(), getMeasuredHeight(), cusPaint_0);
        canvas.translate(10, 10);
        canvas.drawRect(0, 0, getMeasuredWidth() - 20, getMeasuredHeight() - 20, cusPaint_1);
        canvas.restore();
        super.onDraw(canvas);
    }

    protected void initPaint(){
        cusPaint_0 = new Paint();
        cusPaint_0.setColor(Color.GREEN);
        cusPaint_0.setStyle(Paint.Style.FILL);
        cusPaint_1 = new Paint();
        cusPaint_1.setColor(Color.YELLOW);
        cusPaint_1.setStyle(Paint.Style.FILL);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int width = getMeasuredWidth();
        final int height = getMeasuredHeight();
        final float currentX = event.getX();
        final float currentY = event.getY();
        float lastX = 0;
        float lastY = 0;
        float offsetX = 0;
        float offsetY = 0;
        ViewGroup vp = (ViewGroup) getParent();
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                lastX = currentX;
                lastY = currentY;
                break;
            case MotionEvent.ACTION_MOVE:
                Log.d("shuai", vp.getScrollX()+"");
                offsetX = currentX - lastX;
                offsetY = currentY - lastY;
                ((View)getParent()).scrollBy(new Float(-offsetX).intValue(), new Float(-offsetY).intValue());
                lastX = currentX;
                lastY = currentY;
                break;
            default:

                scroller.startScroll(vp.getScrollX(), vp.getScrollY(), -vp.getScrollX(), -vp.getScrollY(), 2000);
                postInvalidate();
                break;
        }

        return true;
    }

    @Override
    public void computeScroll() {
        super.computeScroll();
        if(scroller.computeScrollOffset()){
            ((View)getParent()).scrollTo(
                    scroller.getCurrX(),
                    scroller.getCurrY()
            );
            invalidate();
        }
    }
}
