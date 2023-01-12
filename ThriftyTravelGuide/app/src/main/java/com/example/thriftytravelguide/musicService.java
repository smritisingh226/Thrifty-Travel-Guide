//A class to play music in the background.
//Extends the service class
package com.example.thriftytravelguide;

import android.app.Service;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.IBinder;
import android.provider.Settings;

import androidx.annotation.Nullable;

import java.security.Provider;
import java.util.List;
import java.util.Map;

public class musicService extends Service {

    //Creates an object for the media player
    private MediaPlayer player;

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    //On the start of the music plays a music in the background in loop.
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        player = MediaPlayer.create(this, Settings.System.DEFAULT_ALARM_ALERT_URI);
        player.setLooping(true);
        player.start();
        return START_NOT_STICKY;
    }

    //On the destroy of the activity stops the background music.
    @Override
    public void onDestroy() {
        super.onDestroy();
        player.stop();
        player.release();
    }
}
