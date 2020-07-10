package com.example.geomob_encyclopedie_geographique

import android.annotation.SuppressLint
import android.annotation.TargetApi
import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.content.BroadcastReceiver
import android.content.ContentValues
import android.content.Context
import android.content.Intent
import android.graphics.drawable.Icon
import android.os.AsyncTask
import android.os.Build
import android.util.Log
import android.widget.Toast
import androidx.annotation.RequiresApi
import androidx.core.app.NotificationCompat
import androidx.core.content.ContextCompat.getSystemService
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.geomob_encyclopedie_geographique.DataRoom.Pays
import com.example.geomob_encyclopedie_geographique.DataRoom.PaysDataBase
import com.example.geomob_encyclopedie_geographique.DataRoom.PaysViewModel


class GetPaysOnBootReceiver : BroadcastReceiver() {
    private val channelId = "MyChannel"
    private val channelName = "Shona"
    private val importance = NotificationManager.IMPORTANCE_HIGH
    private val REQUEST_CODE = 99

    private var databse: PaysDataBase? = null

    @RequiresApi(Build.VERSION_CODES.M)
    override fun onReceive(context: Context, intent: Intent) {
            if (Intent.ACTION_BOOT_COMPLETED.equals(intent.action)){
                Toast.makeText(context,"Boot completed", Toast.LENGTH_SHORT).show()
                createNotification(context)

            }
    }


    @TargetApi(Build.VERSION_CODES.O)
    @RequiresApi(Build.VERSION_CODES.M)
    private fun createNotification(context: Context) {
        val notifIntent1 = Intent(context, NotifActivity::class.java)

        val pNotifIntent1 = PendingIntent.getActivity(context, System.currentTimeMillis().toInt(), notifIntent1, 0)


        val icon1 = Icon.createWithResource(context, R.drawable.algerie1)
        val action1 = Notification.Action.Builder(icon1,"Visitez",pNotifIntent1).build()





        val notificationManager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
            val mChannel = NotificationChannel(
                channelId, channelName, importance)
            notificationManager.createNotificationChannel(mChannel)
        }

        val noti = Notification.Builder(context, channelId)
            .setContentTitle("Notification GeoMob")
            .setContentText("Voulez vous découvrir un nouveau pays ?")
            .setSmallIcon(android.R.drawable.btn_dialog)
            .setContentIntent(pNotifIntent1)
            .addAction(action1)
            .setAutoCancel(true)

            .build()

        notificationManager.notify(0, noti)
        }
    }
