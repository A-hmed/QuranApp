package com.example.quranproject.quran;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.app.NotificationCompat;

import com.example.quranproject.Base.BaseActivity;
import com.example.quranproject.R;

import java.util.Calendar;

public class Splash extends BaseActivity {

    private BroadcastReceiver mtimeInfoReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context c, Intent i) {
            //initialize objects

            Calendar calendar = Calendar.getInstance();
            //display time on toast

            //set time on text view
            //  Log.i("lo",calendar.getTime().toString());
            if (calendar.getTime().getHours() == 5 && calendar.getTime().getMinutes() == 18) {
                Log.i("fgr", "fagrrr");
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel notificationChannel = new NotificationChannel("CHANNEL_ID", "CHANNEL_NAME", NotificationManager.IMPORTANCE_DEFAULT);
                    notificationChannel.setDescription("CHANNEL_DESCRIPTION");
                    notificationChannel.enableVibration(true);
                    notificationChannel.enableLights(true);
                    notificationChannel.canShowBadge();
                    notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
                    notificationChannel.setLightColor(getResources().getColor(R.color.colorAccent));

                    notificationManager.createNotificationChannel(notificationChannel);
                }
                NotificationCompat.Builder builder = new NotificationCompat.Builder(Splash.this, "CHANNEL_ID")
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("تذكير للصلاه")
                        .setContentText("حان الان موعد اذان الفجر")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                PendingIntent pendingIntent = PendingIntent.getActivity(Splash.this, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);

                notificationManager.notify(0, builder.build());

            } else if (calendar.getTime().getHours() == 11 && calendar.getTime().getMinutes() == 58) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel notificationChannel = new NotificationChannel("CHANNEL_ID", "CHANNEL_NAME", NotificationManager.IMPORTANCE_DEFAULT);
                    notificationChannel.setDescription("CHANNEL_DESCRIPTION");
                    notificationChannel.enableVibration(true);
                    notificationChannel.enableLights(true);
                    notificationChannel.canShowBadge();
                    notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
                    notificationChannel.setLightColor(getResources().getColor(R.color.colorAccent));

                    notificationManager.createNotificationChannel(notificationChannel);
                }
                NotificationCompat.Builder builder = new NotificationCompat.Builder(Splash.this, "CHANNEL_ID")
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("تذكير للصلاه")
                        .setContentText("حان الان موعد اذان الظهر")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                PendingIntent pendingIntent = PendingIntent.getActivity(Splash.this, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);

                notificationManager.notify(0, builder.build());
            } else if (calendar.getTime().getHours() == 14 && calendar.getTime().getMinutes() == 46) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel notificationChannel = new NotificationChannel("CHANNEL_ID", "CHANNEL_NAME", NotificationManager.IMPORTANCE_DEFAULT);
                    notificationChannel.setDescription("CHANNEL_DESCRIPTION");
                    notificationChannel.enableVibration(true);
                    notificationChannel.enableLights(true);
                    notificationChannel.canShowBadge();
                    notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
                    notificationChannel.setLightColor(getResources().getColor(R.color.colorAccent));

                    notificationManager.createNotificationChannel(notificationChannel);
                }
                NotificationCompat.Builder builder = new NotificationCompat.Builder(Splash.this, "CHANNEL_ID")
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("تذكير للصلاه")
                        .setContentText("حان الان موعد اذان العصر")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                PendingIntent pendingIntent = PendingIntent.getActivity(Splash.this, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);
                notificationManager.notify(0, builder.build());
            } else if (calendar.getTime().getHours() == 17 && calendar.getTime().getMinutes() == 05) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel notificationChannel = new NotificationChannel("CHANNEL_ID", "CHANNEL_NAME", NotificationManager.IMPORTANCE_DEFAULT);
                    notificationChannel.setDescription("CHANNEL_DESCRIPTION");
                    notificationChannel.enableVibration(true);
                    notificationChannel.enableLights(true);
                    notificationChannel.canShowBadge();
                    notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
                    notificationChannel.setLightColor(getResources().getColor(R.color.colorAccent));

                    notificationManager.createNotificationChannel(notificationChannel);
                }
                NotificationCompat.Builder builder = new NotificationCompat.Builder(Splash.this, "CHANNEL_ID")
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("تذكير للصلاه")
                        .setContentText("حان الان موعد اذان المغرب")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                PendingIntent pendingIntent = PendingIntent.getActivity(Splash.this, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);
                notificationManager.notify(0, builder.build());
            } else if (calendar.getTime().getHours() == 18 && calendar.getTime().getMinutes() == 28) {
                NotificationManager notificationManager = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
                    NotificationChannel notificationChannel = new NotificationChannel("CHANNEL_ID", "CHANNEL_NAME", NotificationManager.IMPORTANCE_DEFAULT);
                    notificationChannel.setDescription("CHANNEL_DESCRIPTION");
                    notificationChannel.enableVibration(true);
                    notificationChannel.enableLights(true);
                    notificationChannel.canShowBadge();
                    notificationChannel.setLockscreenVisibility(Notification.VISIBILITY_PUBLIC);
                    notificationChannel.setLightColor(getResources().getColor(R.color.colorAccent));

                    notificationManager.createNotificationChannel(notificationChannel);
                }
                NotificationCompat.Builder builder = new NotificationCompat.Builder(Splash.this, "CHANNEL_ID")
                        .setSmallIcon(R.drawable.notification_icon)
                        .setContentTitle("تذكير للصلاه")
                        .setContentText("حان الان موعد اذان العشاء")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);
                PendingIntent pendingIntent = PendingIntent.getActivity(Splash.this, 0, new Intent(), PendingIntent.FLAG_UPDATE_CURRENT);
                builder.setContentIntent(pendingIntent);
                notificationManager.notify(0, builder.build());
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        IntentFilter mTime = new IntentFilter(Intent.ACTION_TIME_TICK);
        //register broadcast receiver
        registerReceiver(mtimeInfoReceiver, mTime);
        new Handler()
                .postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        startActivity(new Intent(activity, Login.class));
                        finish();
                    }
                }, 2000);
    }
}