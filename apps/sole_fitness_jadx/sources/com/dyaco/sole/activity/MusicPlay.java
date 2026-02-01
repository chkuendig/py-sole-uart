package com.dyaco.sole.activity;

import android.media.MediaPlayer;
import android.util.Log;
import java.io.IOException;

/* loaded from: classes.dex */
public class MusicPlay implements Runnable {
    public static final int BUTTON_PAUSE = 2;
    public static final int BUTTON_PLAY = 1;
    public static final int BUTTON_RESUME = 4;
    public static final int BUTTON_STOP = 3;
    private int currentPosition;
    private boolean isPause;
    private MediaPlayer mediaPlayer = new MediaPlayer();
    private String path;

    @Override // java.lang.Runnable
    public void run() {
    }

    public void setVolume(float f) {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.setVolume(f, f);
        }
    }

    public void play(int i) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        if (this.mediaPlayer.isPlaying()) {
            stop();
        }
        try {
            this.mediaPlayer.reset();
            this.mediaPlayer.setDataSource(this.path);
            this.mediaPlayer.prepare();
            this.mediaPlayer.setOnPreparedListener(new PreparedListener(i));
            this.mediaPlayer.setOnCompletionListener(new MediaPlayer.OnCompletionListener() { // from class: com.dyaco.sole.activity.MusicPlay.1
                @Override // android.media.MediaPlayer.OnCompletionListener
                public void onCompletion(MediaPlayer mediaPlayer) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                    MusicPlay.this.play(0);
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void pause() throws IllegalStateException {
        Log.d("ccc", "ppp");
        Log.d("ccc", "mediaPlayer " + this.mediaPlayer);
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        Log.d("ccc", "ppp111");
        this.mediaPlayer.pause();
        this.currentPosition = this.mediaPlayer.getCurrentPosition();
        Log.d("ccc", "ppp  currentPosition  " + this.currentPosition);
    }

    public void resume() throws IllegalStateException {
        Log.d("ccc", "rrr");
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null || mediaPlayer.isPlaying()) {
            return;
        }
        Log.d("ccc", "rrr111 isPause  " + this.isPause);
        Log.d("ccc", "rrr222");
        this.mediaPlayer.start();
        this.mediaPlayer.seekTo(this.currentPosition);
    }

    public void stop() throws IllegalStateException {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer == null || !mediaPlayer.isPlaying()) {
            return;
        }
        this.mediaPlayer.stop();
    }

    public void onDestroy() throws IllegalStateException {
        MediaPlayer mediaPlayer = this.mediaPlayer;
        if (mediaPlayer != null) {
            mediaPlayer.stop();
            this.mediaPlayer.release();
        }
    }

    public void setMp3Path(String str) {
        this.path = str;
    }

    private final class PreparedListener implements MediaPlayer.OnPreparedListener {
        private int positon;

        public PreparedListener(int i) {
            this.positon = i;
        }

        @Override // android.media.MediaPlayer.OnPreparedListener
        public void onPrepared(MediaPlayer mediaPlayer) throws IllegalStateException {
            MusicPlay.this.mediaPlayer.start();
            if (this.positon > 0) {
                MusicPlay.this.mediaPlayer.seekTo(this.positon);
            }
        }
    }
}
