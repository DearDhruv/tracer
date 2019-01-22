package com.deardhruv.tracer;

import android.annotation.TargetApi;
import android.app.Notification;
import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.os.Bundle;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

import static com.deardhruv.tracer.NotificationUtils.ANDROID_CHANNEL_ID;

/**
 * Created by deardhruv on 19-05-2017.
 */
public class TracerActivity extends AppCompatActivity {
    NotificationUtils notificationUtils;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        notificationUtils = new NotificationUtils(this);
        notify("onCreate");
    }

    @Override
    protected void onPause() {
        super.onPause();
        notify("onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        notify("onResume");
    }

    @Override
    protected void onStart() {
        super.onStart();
        notify("onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        notify("onStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        notify("onDestroy");
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        notify("onRestoreInstanceState");
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        notify("onSaveInstanceState");
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        notify("onActivityResult");
    }

    @TargetApi(Build.VERSION_CODES.O)
    public void notify(String methodName) {
        String name = this.getClass().getName();
        String[] strings = name.split("\\.");
        Notification noti = getAndroidChannelNotification(methodName + " " + strings[strings.length - 1], name)
                .build();
        notificationUtils.getNotificationManager().notify((int) System.currentTimeMillis(), noti);
    }

    @RequiresApi(api = Build.VERSION_CODES.O)
    public Notification.Builder getAndroidChannelNotification(String title, String body) {
        return new Notification.Builder(getApplicationContext(), ANDROID_CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.drawable.ic_stat_cycle)
                .setLargeIcon(((BitmapDrawable) ResourcesCompat.getDrawable(this.getResources(),
                        R.drawable.ic_stat_cycle_large, null)).getBitmap())
                .setAutoCancel(true);
    }
}