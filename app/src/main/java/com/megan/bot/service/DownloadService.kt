package com.megan.bot.service

import android.app.*
import android.content.Context
import android.content.Intent
import android.os.Build
import android.os.Environment
import android.os.IBinder
import androidx.core.app.NotificationCompat
import com.megan.bot.MainActivity
import com.megan.bot.R
import kotlinx.coroutines.*
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.File
import java.io.FileOutputStream

class DownloadService : Service() {
    private val serviceScope = CoroutineScope(Dispatchers.IO + SupervisorJob())
    private val client = OkHttpClient()

    override fun onBind(intent: Intent?): IBinder? = null

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        val url = intent?.getStringExtra("url") ?: return START_NOT_STICKY
        val fileName = intent.getStringExtra("fileName") ?: "download_${System.currentTimeMillis()}"
        val fileType = intent.getStringExtra("fileType") ?: "mp4"

        startForeground(1, createNotification("Preparing download...", 0))

        serviceScope.launch {
            try {
                downloadFile(url, fileName, fileType)
            } catch (e: Exception) {
                showError(e.message ?: "Download failed")
            }
        }

        return START_STICKY
    }

    private suspend fun downloadFile(url: String, fileName: String, fileType: String) {
        val request = Request.Builder().url(url).build()
        val response = client.newCall(request).execute()
        val body = response.body ?: throw Exception("No response body")
        val totalBytes = body.contentLength()

        val downloadDir = File(
            Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS),
            "Norbot"
        )
        if (!downloadDir.exists()) downloadDir.mkdirs()

        val file = File(downloadDir, "${fileName.replace(" ", "_")}.$fileType")
        
        body.byteStream().use { input ->
            FileOutputStream(file).use { output ->
                val buffer = ByteArray(8192)
                var downloadedBytes = 0L
                var bytes: Int

                while (input.read(buffer).also { bytes = it } != -1) {
                    output.write(buffer, 0, bytes)
                    downloadedBytes += bytes
                    val progress = if (totalBytes > 0) ((downloadedBytes * 100) / totalBytes).toInt() else 0
                    updateNotification(fileName, progress)
                }
            }
        }

        showComplete(fileName, file.absolutePath)
    }

    private fun createNotification(content: String, progress: Int): Notification {
        val channelId = "norbot_downloads"
        return NotificationCompat.Builder(this, channelId)
            .setContentTitle("📥 Norbot Download")
            .setContentText(content)
            .setSmallIcon(android.R.drawable.stat_sys_download)
            .setProgress(100, progress, progress == 0)
            .setOngoing(true)
            .build()
    }

    private fun updateNotification(fileName: String, progress: Int) {
        val notification = createNotification("Downloading $fileName", progress)
        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(1, notification)
    }

    private fun showComplete(fileName: String, filePath: String) {
        val channelId = "norbot_downloads"
        val intent = Intent(this, MainActivity::class.java)
        val pendingIntent = PendingIntent.getActivity(this, 0, intent, 
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)

        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle("✅ Download Complete")
            .setContentText("$fileName saved to Downloads/Norbot")
            .setSmallIcon(android.R.drawable.stat_sys_download_done)
            .setAutoCancel(true)
            .setContentIntent(pendingIntent)
            .build()

        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(2, notification)
        stopForeground(STOP_FOREGROUND_REMOVE)
        stopSelf()
    }

    private fun showError(message: String) {
        val channelId = "norbot_downloads"
        val notification = NotificationCompat.Builder(this, channelId)
            .setContentTitle("❌ Download Failed")
            .setContentText(message)
            .setSmallIcon(android.R.drawable.stat_sys_warning)
            .setAutoCancel(true)
            .build()

        val manager = getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
        manager.notify(3, notification)
        stopForeground(STOP_FOREGROUND_REMOVE)
        stopSelf()
    }

    override fun onDestroy() {
        serviceScope.cancel()
        super.onDestroy()
    }
}
