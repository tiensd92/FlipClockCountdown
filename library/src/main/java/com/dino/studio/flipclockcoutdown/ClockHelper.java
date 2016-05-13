package com.dino.studio.flipclockcoutdown;

import java.util.Iterator;
import java.util.TimeZone;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
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

    protected boolean mAttached;
    //protected Time mCalendar;
    //protected TimeZone mTimeZone;
    //protected final Handler mHandler = new Handler();

    private final OnTimeChangeListener timeChangeHandler;

    public ClockHelper(OnTimeChangeListener timeChangeHandler) {
        this.timeChangeHandler = timeChangeHandler;
    }


    public void onAttachToWindow(Context context) {

        if (!mAttached) {
            mAttached = true;
            Log.e("onAttachToWindow", "onAttachToWindow");
            mIntentReceiver.SetAlarm(context);
            context.registerReceiver(mIntentReceiver, new IntentFilter("countdown"));
        }
    }

    public void onDetachedFromWindow(Context context) {
        if (mAttached) {

            Log.e("onDetachedFromWindow", "onDetachedFromWindow");
            mIntentReceiver.CancelAlarm(context);
            context.unregisterReceiver(mIntentReceiver);
            mAttached = false;
        }
        timeChangeHandler.handleTimeChange();
    }

    private final Alarm mIntentReceiver = new Alarm() {
        @Override
        public void runAlarm() {
            timeChangeHandler.handleTimeChange();
        }
    };

    public interface OnTimeChangeListener {
        void handleTimeChange();
    }

    class Alarm extends BroadcastReceiver {
        @Override
        public void onReceive(Context context, Intent intent) {
            Log.e("onReceive", "onReceive");
            PowerManager pm = (PowerManager) context.getSystemService(Context.POWER_SERVICE);
            PowerManager.WakeLock wl = pm.newWakeLock(PowerManager.PARTIAL_WAKE_LOCK, "");
            wl.acquire();
            runAlarm();
            wl.release();
        }

        public void runAlarm() {

        }

        public void SetAlarm(Context context) {
            AlarmManager am = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            //Intent i = new Intent(context, Alarm.class);
            PendingIntent pi = PendingIntent.getBroadcast(context, 0, new Intent("countdown"), 0);
            am.setRepeating(AlarmManager.RTC, System.currentTimeMillis(), 1000, pi); // Millisec * Second * Minute
        }

        public void CancelAlarm(Context context) {
            Intent intent = new Intent(context, Alarm.class);
            PendingIntent sender = PendingIntent.getBroadcast(context, 0, intent, 0);
            AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
            alarmManager.cancel(sender);
        }
    }
}
