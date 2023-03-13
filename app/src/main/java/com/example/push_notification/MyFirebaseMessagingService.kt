package com.example.push_notification

import android.annotation.SuppressLint
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.Context
import android.content.Intent
import android.os.Build
import android.util.JsonToken
import android.util.Log
import android.widget.RemoteViews
import androidx.core.app.NotificationCompat
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage





const val ChannelId="notification"
const val  ChannelName="com.example.push_notification"

class MyFirebaseMessagingService :FirebaseMessagingService() {
    


    override fun onMessageReceived(remoteMessage: RemoteMessage) {

        if (remoteMessage.notification != null) {
            // Since the notification is received directly
            // from FCM, the title and the body can be
            // fetched directly as below.
            generateNotification(
                remoteMessage.notification!!.title!!,
                remoteMessage.notification!!.body!!
            )
        }
    }

   @SuppressLint("RemoteViewLayout")
   fun getRemoteView(title: String, message: String):RemoteViews{

       val remoteView=RemoteViews("com.example.push_notification",R.layout.notification)
       remoteView.setTextViewText(R.id.title,title)
       remoteView.setTextViewText(R.id.dec,message)
       remoteView.setImageViewResource(R.id.messageIcon,R.drawable.ic_baseline_message_24)
       return  remoteView
   }


    fun generateNotification(title:String ,message:String){






        val intent= Intent(this,MainActivity::class.java)
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)

        val pendingIntent=PendingIntent.getActivity(this,0,intent,PendingIntent.FLAG_ONE_SHOT)

       val builder:NotificationCompat.Builder=NotificationCompat.Builder(applicationContext,
           ChannelId)

           .setSmallIcon(R.drawable.ic_baseline_message_24)
           .setVibrate(longArrayOf(1000,1000,1000,1000))
           .setContentIntent(pendingIntent)
           .setOnlyAlertOnce(true)

           .setContent(getRemoteView(title,message))


        val notificationManager = getSystemService(
            Context.NOTIFICATION_SERVICE
        ) as NotificationManager
        // Check if the Android Version is greater than Oreo
        // Check if the Android Version is greater than Oreo
        if (Build.VERSION.SDK_INT
            >= Build.VERSION_CODES.O
        ) {
            val notificationChannel = NotificationChannel(
                ChannelId, ChannelName,
                NotificationManager.IMPORTANCE_HIGH
            )
            notificationManager.createNotificationChannel(
                notificationChannel
            )
        }

        notificationManager.notify(0, builder.build())
    }
}