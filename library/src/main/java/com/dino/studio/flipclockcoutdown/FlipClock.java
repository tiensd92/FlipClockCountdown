package com.dino.studio.flipclockcoutdown;

import java.util.HashMap;
import java.util.Map;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * Very basic impl of a flip clock.  Clock 'flips' every minute, and supports
 * both 12-hour and 24-hour clocks, based on the user's system preference.
 *
 * @author jonson
 */
public class FlipClock extends LinearLayout implements Clock {

    public static final Map<Integer, TypeAnim> mod10DigitToDrawable = new HashMap<Integer, TypeAnim>();
    int[] currentTime = new int[6];
    private ClockHelper helper;

    static {
        mod10DigitToDrawable.put(0, TypeAnim.full_0);
        mod10DigitToDrawable.put(1, TypeAnim.full_1);
        mod10DigitToDrawable.put(2, TypeAnim.full_2);
        mod10DigitToDrawable.put(3, TypeAnim.full_3);
        mod10DigitToDrawable.put(4, TypeAnim.full_4);
        mod10DigitToDrawable.put(5, TypeAnim.full_5);
        mod10DigitToDrawable.put(6, TypeAnim.full_6);
        mod10DigitToDrawable.put(7, TypeAnim.full_7);
        mod10DigitToDrawable.put(8, TypeAnim.full_8);
        mod10DigitToDrawable.put(9, TypeAnim.full_9);

    }

    private ImageNumber hour0;
    private ImageNumber hour1;
    private ImageNumber minute0;
    private ImageNumber minute1;
    private ImageNumber second0;
    private ImageNumber second1;

    public FlipClock(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public FlipClock(Context context) {
        super(context);
        init(context);
    }

    public FlipClock(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    private void init(Context context) {
        LayoutInflater mInflater = LayoutInflater.from(context);

        View layout = mInflater.inflate(R.layout.inc_flipclock, this);

        hour0 = (ImageNumber) layout.findViewById(R.id.dcHour0);
        hour1 = (ImageNumber) layout.findViewById(R.id.dcHour1);
        minute0 = (ImageNumber) layout.findViewById(R.id.dcMinute0);
        minute1 = (ImageNumber) layout.findViewById(R.id.dcMinute1);
        second0 = (ImageNumber) layout.findViewById(R.id.dcSecond0);
        second1 = (ImageNumber) layout.findViewById(R.id.dcSecond1);

        hour0.setNumber(0);
        hour1.setNumber(0);
        minute0.setNumber(0);
        minute1.setNumber(0);
        second0.setNumber(0);
        second1.setNumber(0);
        requestLayout();
        invalidate();

        helper = new ClockHelper(new ClockHelper.OnTimeChangeListener() {
            @Override
            public void handleTimeChange() {
                onTimeChanged();
            }
        });
        //setCurrentTime(new int[]{1, 2, 3, 4, 5, 6});
    }

    public void setCurrentTime(int[] array) {
        for (int i = 0; i < currentTime.length; i++)
            currentTime[i] = array[i];
        onTimeChanged();
        helper.startCountDown(array[0] * 10 + array[1], array[2] * 10 + array[3], array[4] * 10 + array[5]);
    }

    public void setCurrentTime(int hours, int minutes, int second) {
        currentTime[0] = hours / 10;
        currentTime[1] = hours % 10;
        currentTime[2] = minutes / 10;
        currentTime[3] = minutes % 10;
        currentTime[4] = second / 10;
        currentTime[5] = second % 10;
        onTimeChanged();
        helper.startCountDown(hours, minutes, second);
    }

    @Override
    public void onTimeChanged() {

        Log.e("Timer", currentTime[0] + "" + currentTime[1] + ":" + currentTime[2] + "" + currentTime[3] + ":" + currentTime[4] + "" + currentTime[5]);
        if (currentTime[5] == 0 && currentTime[4] == 0
                && currentTime[3] == 0 && currentTime[2] == 0
                && currentTime[1] == 0 && currentTime[1] == 0) {
            return;
        }
        if (currentTime[5] == 0) {
            currentTime[5] = 9;
            if (currentTime[4] == 0) {
                currentTime[4] = 5;
                if (currentTime[3] == 0) {
                    currentTime[3] = 9;
                    if (currentTime[2] == 0) {
                        currentTime[2] = 9;
                        currentTime[1]--;
                    } else currentTime[2]--;
                } else currentTime[3]--;
            } else currentTime[4]--;
        } else
            currentTime[5]--;


        hour0.setAnime(getDrawableNoraml(currentTime[0]));
        hour1.setAnime(getDrawableNoraml(currentTime[1]));
        minute0.setAnime(getDrawalbeSpecial(currentTime[2]));
        minute1.setAnime(getDrawableNoraml(currentTime[3]));
        second0.setAnime(getDrawalbeSpecial(currentTime[4]));
        second1.setAnime(getDrawableNoraml(currentTime[5]));

        requestLayout();
        //last = vals;

    }

    private TypeAnim getDrawalbeSpecial(int x) {
        switch (x) {
            default:
                return TypeAnim.flip_1_0;
            case 1:
                return TypeAnim.flip_2_1;
            case 2:
                return TypeAnim.flip_3_2;
            case 3:
                return TypeAnim.flip_4_3;
            case 4:
                return TypeAnim.flip_5_4;
            case 5:
                return TypeAnim.flip_0_5;
        }
    }

    private TypeAnim getDrawableNoraml(int x) {
        switch (x) {
            default:
                return TypeAnim.flip_1_0;
            case 1:
                return TypeAnim.flip_2_1;
            case 2:
                return TypeAnim.flip_3_2;
            case 3:
                return TypeAnim.flip_4_3;
            case 4:
                return TypeAnim.flip_5_4;
            case 5:
                return TypeAnim.flip_6_5;
            case 6:
                return TypeAnim.flip_7_6;
            case 7:
                return TypeAnim.flip_8_7;
            case 8:
                return TypeAnim.flip_9_8;
            case 9:
                return TypeAnim.flip_0_9;
        }
    }

    /**
     * Ensure the animation is run on the UI thread
     *
     * @param iv
     */


}
