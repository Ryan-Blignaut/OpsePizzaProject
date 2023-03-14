package me.ryanblignaut.opsepizzaproject.backend

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.graphics.Color
import android.os.Build
import androidx.core.app.NotificationCompat
import me.ryanblignaut.opsepizzaproject.R


class LocalNotificationManager {
    private val channelId = "PizzaOPSENotification"
    private val channelName = "OPSE Pizza Notification"
    private val channelDescription = "Shows pizza notifications"

    fun createNotification(
        context: Context,
        title: String?,
        message: String?,
        notificationId: Int
    ) {
        val notificationManager =
            context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        // Create a notification channel for Android Oreo and above
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channel = NotificationChannel(
                channelId,
                channelName,
                NotificationManager.IMPORTANCE_DEFAULT
            )
            channel.description = channelDescription
            channel.enableLights(true)
            channel.lightColor = Color.CYAN
            notificationManager.createNotificationChannel(channel)
        }

        // Build the notification
        val builder: NotificationCompat.Builder = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(R.drawable.ic_launcher_background)
            .setContentTitle(title)
            .setContentText(message)
            .setPriority(NotificationCompat.PRIORITY_DEFAULT)
            .setAutoCancel(true)

        // Show the notification
        notificationManager.notify(notificationId, builder.build())
    }

}