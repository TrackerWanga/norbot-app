package com.megan.bot.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import android.app.PendingIntent
import android.app.Service
import android.content.Intent
import android.media.MediaPlayer
import android.os.Binder
import android.os.Build
import android.os.IBinder
import com.megan.bot.MainActivity

class MusicService : Service() {
    private val binder = MusicBinder()
    private var mediaPlayer: MediaPlayer? = null
    var currentTitle: String? = null
    var currentArtist: String? = null
    var playing = false
    var onComplete: (() -> Unit)? = null

    inner class MusicBinder : Binder() {
        fun getService(): MusicService = this@MusicService
    }

    override fun onCreate() {
        super.onCreate()
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            getSystemService(NotificationManager::class.java).createNotificationChannel(
                NotificationChannel("norbot_playback", "Norbot Music", NotificationManager.IMPORTANCE_LOW)
            )
        }
    }

    override fun onBind(intent: Intent?): IBinder = binder

    override fun onStartCommand(intent: Intent?, flags: Int, startId: Int): Int {
        when (intent?.action) {
            "PAUSE" -> { pause(); return START_STICKY }
            "PLAY" -> { resume(); return START_STICKY }
            "NEXT" -> { playNext(); return START_STICKY }
            "PREVIOUS" -> { playPrevious(); return START_STICKY }
            "STOP" -> { stopAll(); return START_NOT_STICKY }
        }
        intent?.let {
            play(it.getStringExtra("url") ?: return START_STICKY,
                 it.getStringExtra("title"),
                 it.getStringExtra("artist"))
        }
        return START_STICKY
    }

    fun play(url: String, title: String?, artist: String?) {
        currentTitle = title; currentArtist = artist
        mediaPlayer?.apply { if (isPlaying) stop(); release() }
        mediaPlayer = null; playing = false

        showNotification(isLoading = true)

        mediaPlayer = MediaPlayer().apply {
            setDataSource(url)
            setOnPreparedListener {
                start(); playing = true
                showNotification(isLoading = false)
            }
            setOnCompletionListener {
                playing = false
                showNotification()
                onComplete?.invoke()
            }
            setOnErrorListener { _, _, _ -> playing = false; false }
            prepareAsync()
        }
    }

    fun pause() { 
        mediaPlayer?.pause()
        playing = false
        showNotification()
    }

    fun resume() {
        mediaPlayer?.start()
        playing = true
        showNotification()
    }

    fun stopAll() {
        mediaPlayer?.apply { if (isPlaying) stop(); release() }
        mediaPlayer = null
        playing = false
        stopForeground(STOP_FOREGROUND_REMOVE)
        stopSelf()
    }

    fun seekTo(position: Int) {
        mediaPlayer?.seekTo(position)
    }

    fun getCurrentPosition(): Int = mediaPlayer?.currentPosition ?: 0
    fun getDuration(): Int = mediaPlayer?.duration ?: 0
    fun isPlaying(): Boolean = playing

    private fun playNext() {
        onComplete?.invoke()
    }

    private fun playPrevious() {
        mediaPlayer?.seekTo(0)
    }

    private fun showNotification(isLoading: Boolean = false) {
        val pi = PendingIntent.getActivity(this, 0, 
            Intent(this, MainActivity::class.java), 
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)

        val pauseIntent = PendingIntent.getService(this, 1,
            Intent(this, MusicService::class.java).setAction(if (playing) "PAUSE" else "PLAY"),
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)

        val nextIntent = PendingIntent.getService(this, 2,
            Intent(this, MusicService::class.java).setAction("NEXT"),
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)

        val prevIntent = PendingIntent.getService(this, 3,
            Intent(this, MusicService::class.java).setAction("PREVIOUS"),
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)

        val stopIntent = PendingIntent.getService(this, 4,
            Intent(this, MusicService::class.java).setAction("STOP"),
            PendingIntent.FLAG_IMMUTABLE or PendingIntent.FLAG_UPDATE_CURRENT)

        val nb = if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) 
            Notification.Builder(this, "norbot_playback")
        else @Suppress("DEPRECATION") Notification.Builder(this)

        startForeground(1, nb
            .setContentTitle(currentTitle ?: "Norbot Music")
            .setContentText(if (isLoading) "Loading..." else currentArtist ?: "Playing")
            .setSmallIcon(android.R.drawable.ic_media_play)
            .setContentIntent(pi)
            .setOngoing(true)
            .addAction(android.R.drawable.ic_media_previous, "Prev", prevIntent)
            .addAction(if (playing) android.R.drawable.ic_media_pause else android.R.drawable.ic_media_play, 
                if (playing) "Pause" else "Play", pauseIntent)
            .addAction(android.R.drawable.ic_media_next, "Next", nextIntent)
            .addAction(android.R.drawable.ic_delete, "Stop", stopIntent)
            .setStyle(android.media.session.MediaSession.Token?.let { null } ?: 
                Notification.MediaStyle().setShowActionsInCompactView(0, 1, 2))
            .setProgress(0, 0, isLoading)
            .build())
    }

    override fun onDestroy() {
        mediaPlayer?.release()
        mediaPlayer = null
        super.onDestroy()
    }
}
