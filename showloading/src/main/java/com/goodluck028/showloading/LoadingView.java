package com.goodluck028.showloading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.Calendar;

public class LoadingView extends View {

    private Paint mRectPaint = new Paint();

    public LoadingView(Context context) {
        super(context);
        setBackgroundColor(Color.parseColor("#ffffff"));
        mRectPaint.setColor(Color.parseColor("#cccccc"));
        mRectPaint.setStyle(Paint.Style.FILL);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int startLeft = getWidth() / 3;
        int rectWidth = startLeft * 2 / 15;
        int widthDiff = startLeft / 5;
        int midHeight = getHeight() / 2;
        //
        int tick = (int) (Calendar.getInstance().getTimeInMillis() % 1000);
        for (int i = 0; i < 5; i++) {
            int r = getHeight() / 7;
            int left = startLeft + i * widthDiff;
            int right = left + rectWidth;
            //
            int diff = Math.abs(tick - i * 100);
            if (diff <= 500) {
                diff = diff * r / 500;
            } else {
                diff = (1000 - diff) * r / 500;
            }
            int top = midHeight - r/2 - diff;
            int bottom = midHeight + r/2 + diff;
            //
            canvas.drawRect(left, top, right, bottom, mRectPaint);
        }
        //
        invalidate();
    }
}
