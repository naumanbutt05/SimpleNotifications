package com.nauman.simplenotifications;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.graphics.BitmapFactory;
import android.media.RingtoneManager;
import android.net.Uri;
import android.os.Build;
import android.support.v4.app.NotificationCompat;

public class SimpleNotifications {
    public static void generateNotification(Context context, int notificationID, String channelID,String channelName, String title, String message, int largeIcon,int smallIcon, Class className) {
        NotificationCompat.Builder builder = new NotificationCompat.Builder(context);
        Uri soundUri = RingtoneManager.getDefaultUri(RingtoneManager.TYPE_ALARM);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0,
                new Intent(context, className), PendingIntent.FLAG_UPDATE_CURRENT);

        Notification notification = new NotificationCompat.Builder(context,channelID)
                .setContentIntent(pendingIntent)
                .setSmallIcon(smallIcon)
                .setLargeIcon(BitmapFactory.decodeResource(context.getResources(), largeIcon))
                .setTicker("ticker value")
                .setAutoCancel(true)
                .setPriority(8)
                .setChannelId(channelID)
                .setSound(soundUri)
                .setContentTitle(title)
                .setOngoing(false)
                .setStyle(new NotificationCompat.BigTextStyle())
                .setContentText(message).build();
        notification.flags |= Notification.FLAG_AUTO_CANCEL | Notification.FLAG_SHOW_LIGHTS;
        notification.defaults |= Notification.DEFAULT_SOUND | Notification.DEFAULT_VIBRATE;
        notification.ledARGB = 0xFFFFA500;
        notification.ledOnMS = 800;
        notification.ledOffMS = 1000;
        NotificationManager notificationManager = (NotificationManager) context.getSystemService(context.NOTIFICATION_SERVICE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            int importance = NotificationManager.IMPORTANCE_HIGH;
            NotificationChannel mChannel = new NotificationChannel(channelID, channelName, importance);
            notificationManager.createNotificationChannel(mChannel);
        }
        notificationManager.notify(notificationID, notification);

    }
}

