package com.example.zhangshuai.android_study.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

/**
 * Created by zhanglin on 15/11/15.
 */
public class CircleView extends View{
    private int paintColor = Color.RED;
    private Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
    private int defaultPX = 200;
    float touchX = 0;
    float touchY = 0;

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CircleView);
        paintColor = a.getColor(R.styleable.CircleView_circle_color, paintColor);
        a.recycle();
        init();
    }

    private void init() {
        mPaint.setColor(paintColor);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        int widthSpecMode = MeasureSpec.getMode(widthMeasureSpec);
        int widthSpecSize = MeasureSpec.getSize(widthMeasureSpec);
        int heightSpecMode = MeasureSpec.getMode(heightMeasureSpec);
        int heightSpecSize = MeasureSpec.getSize(heightMeasureSpec);
        if(widthSpecMode==MeasureSpec.AT_MOST && heightSpecMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(defaultPX, defaultPX);
        }else if(widthSpecMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(defaultPX, heightSpecSize);
        }else if(heightSpecMode==MeasureSpec.AT_MOST){
            setMeasuredDimension(widthSpecSize, defaultPX);
        }
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        drawCusCircle(canvas);
    }

    private void drawCusCircle(Canvas canvas) {
        final int width = (int) touchX;
        final int height = (int)touchY;
        int radius = Math.min(width, height)/2;
        canvas.drawCircle(width, height, 50, mPaint);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        touchX = event.getX();
        touchY = event.getY();
        invalidate();
        return super.onTouchEvent(event);

    }

}
