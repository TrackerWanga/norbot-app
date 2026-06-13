package com.megan.bot

import android.app.Application
import android.app.NotificationChannel
import android.app.NotificationManager
import android.os.Build
import com.google.firebase.analytics.FirebaseAnalytics

class NorbotApp : Application() {
    lateinit var analytics: FirebaseAnalytics

    override fun onCreate() {
        super.onCreate()
        analytics = FirebaseAnalytics.getInstance(this)
        createNotificationChannels()
    }

    private fun createNotificationChannels() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val channels = listOf(
                NotificationChannel("norbot_downloads", "Downloads", NotificationManager.IMPORTANCE_LOW),
                NotificationChannel("norbot_news", "News Updates", NotificationManager.IMPORTANCE_HIGH),
                NotificationChannel("norbot_general", "General", NotificationManager.IMPORTANCE_DEFAULT)
            )
            val manager = getSystemService(NotificationManager::class.java)
            channels.forEach { manager.createNotificationChannel(it) }
        }
    }
}
