package com.deardhruv.tracer;

import android.app.Notification;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import static com.deardhruv.tracer.NotificationUtils.ANDROID_CHANNEL_ID;

/**
 * Created by deard on 19-05-2017.
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

    private void notify(String methodName) {
        String name = this.getClass().getName();
        String[] strings = name.split("\\.");
        Notification noti = getAndroidChannelNotification(methodName + " " + strings[strings.length - 1], name)
                .build();
        notificationUtils.getManager().notify((int) System.currentTimeMillis(), noti);
    }

    public Notification.Builder getAndroidChannelNotification(String title, String body) {
        return new Notification.Builder(getApplicationContext(), ANDROID_CHANNEL_ID)
                .setContentTitle(title)
                .setContentText(body)
                .setSmallIcon(R.mipmap.ic_launcher)
                .setAutoCancel(true);
    }
}