package com.dino.studio.flipclockcoutdown;

import java.util.Iterator;
import java.util.TimeZone;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.PowerManager;
import android.text.format.Time;
import android.util.Log;

/**
 * Helper class that handles common dirty work of a clock.
 * <p/>
 * This helper requires a {@link OnTimeChangeListener}, which currently
 * only supports per-minute updates.
 *
 * @author jonson
 */
public class ClockHelper {

    private final OnTimeChangeListener timeChangeHandler;
    CountDownTimer countDownTimer;

    public ClockHelper(OnTimeChangeListener timeChangeHandler) {
        this.timeChangeHandler = timeChangeHandler;
    }

    public interface OnTimeChangeListener {
        void handleTimeChange();
    }

    public void startCountDown(int hours, int minutes, int second) {
        int maxtime = second * 1000 + minutes * 60 * 1000 + hours * 60 * 60 * 1000;
        if (countDownTimer != null)
            countDownTimer.onFinish();
        Log.e("countDownTimer", "countDownTimer");
        countDownTimer = null;
        countDownTimer = new CountDownTimer(maxtime, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                timeChangeHandler.handleTimeChange();
                Log.e("millisUntilFinished", "millisUntilFinished");
            }

            @Override
            public void onFinish() {

            }
        };
        countDownTimer.start();
    }


}
