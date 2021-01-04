package com.goodluck028.showloading;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;

import java.util.Calendar;
import java.util.Random;

public class LoadingView extends View {
    private class Ball {
        int r = 36;
        double x = 36;
        double vx = 5+(new Random().nextFloat())*10;
        double y;
        double vy = 0;
    }

    //
    private Paint mBallPaint = new Paint();
    private Paint mLinePaint = new Paint();
    private Ball mBall;
    private long lastTime = Calendar.getInstance().getTimeInMillis();

    //
    public LoadingView(Context context) {
        super(context);
        setBackgroundColor(Color.parseColor("#ffffff"));
        mBallPaint.setColor(Color.parseColor("#cccccc"));
        mLinePaint.setColor(Color.parseColor("#cccccc"));
        mLinePaint.setStrokeWidth(10);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        int width = getWidth();
        int roof = getHeight() * 1 / 5;
        int floor = getHeight() * 4 / 5;
        if (mBall == null) {
            mBall = new Ball();
            mBall.y = roof;
        }
        //
        long diff = Calendar.getInstance().getTimeInMillis() - lastTime;
        lastTime = Calendar.getInstance().getTimeInMillis();
        diff /= 10;
        //
        double vy = mBall.vy + diff;
        mBall.y = mBall.y + (mBall.vy + vy) * diff / 2;
        mBall.vy = vy;
        if (mBall.y > (floor - mBall.r)) {
            mBall.y = floor - mBall.r;
            mBall.vy *= -0.9;
        }
        //
        mBall.x = mBall.x + diff * mBall.vx;
        if (mBall.x > width - mBall.r) {
            mBall.x = width - mBall.r;
            mBall.vx *= -0.9;
        } else if (mBall.x < mBall.r) {
            mBall.x = mBall.r;
            mBall.vx *= -0.9;
        }
        //
        canvas.drawCircle((int) mBall.x, (int) mBall.y, mBall.r, mBallPaint);
        canvas.drawLine(0, floor, width, floor, mLinePaint);
        //
        invalidate();
    }
}
