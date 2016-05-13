package com.dino.studio.flipclockcoutdown;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by DINO on 26/04/2016.
 */
public class CircleView extends View {
    float dis;
    private Paint paint;

    public CircleView(Context context) {
        super(context);
    }

    public CircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        getColor(context, attrs);
    }

    public CircleView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        getColor(context, attrs);
    }

    private void getColor(Context context, AttributeSet attrs) {

        ColorDrawable buttonColor = (ColorDrawable) getBackground();
        paint = new Paint();
        paint.setColor(buttonColor.getColor());
        setBackgroundColor(Color.TRANSPARENT);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        if (paint != null)
            canvas.drawCircle(dis / 2, dis / 2, dis / 2, paint);
    }

    @Override
    protected void onMeasure(int width, int height) {
        super.onMeasure(width, height);
        int measuredWidth = getMeasuredWidth();
        int measuredHeight = getMeasuredHeight();
        if (measuredWidth > measuredHeight) {
            dis = measuredWidth;
            setMeasuredDimension(measuredWidth, measuredWidth);
        } else {
            dis = measuredHeight;
            setMeasuredDimension(measuredHeight, measuredHeight);
        }
        invalidate();

    }
}
