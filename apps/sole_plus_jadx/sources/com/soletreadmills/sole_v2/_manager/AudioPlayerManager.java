package com.soletreadmills.sole_v2._manager;

import android.content.Context;
import android.net.Uri;
import com.android.SdkConstants;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.Player;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: AudioPlayerManager.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u0007\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\f\u001a\u00020\rJ\b\u0010\u000e\u001a\u00020\u000fH\u0002J\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0011\u001a\u00020\u000fH\u0002J\u0006\u0010\u0012\u001a\u00020\u000fJ\u0010\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u0006H\u0002J\u0006\u0010\u0015\u001a\u00020\u000fJ\u0006\u0010\u0016\u001a\u00020\u000fJ\u0014\u0010\u0017\u001a\u00020\u000f2\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u000b0\nJ\u000e\u0010\u0019\u001a\u00020\u000f2\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u000fJ\u0006\u0010\u001d\u001a\u00020\u000fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/soletreadmills/sole_v2/_manager/AudioPlayerManager;", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "(Landroid/content/Context;)V", "currentIndex", "", "player", "Lcom/google/android/exoplayer2/ExoPlayer;", "playlist", "", "Landroid/net/Uri;", "hasPlaylist", "", "observeSongFinished", "", "pause", "playNextSong", "playPlaylist", "playSong", "index", "release", "resume", "setPlaylist", "urls", "setVolume", "value", "", "stop", "togglePlayPause", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AudioPlayerManager {
    public static final int $stable = 8;
    private int currentIndex;
    private ExoPlayer player;
    private List<? extends Uri> playlist;

    public AudioPlayerManager(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(context).build();
        Intrinsics.checkNotNullExpressionValue(exoPlayerBuild, "build(...)");
        this.player = exoPlayerBuild;
        this.playlist = CollectionsKt.emptyList();
    }

    public final void setPlaylist(List<? extends Uri> urls) {
        Intrinsics.checkNotNullParameter(urls, "urls");
        this.playlist = urls;
        this.currentIndex = 0;
    }

    public final void playPlaylist() {
        if (this.playlist.isEmpty()) {
            return;
        }
        playSong(this.currentIndex);
    }

    public final void setVolume(float value) {
        this.player.setVolume(value);
    }

    private final void playSong(int index) {
        if (index < 0 || index >= this.playlist.size()) {
            return;
        }
        MediaItem mediaItemFromUri = MediaItem.fromUri(this.playlist.get(index));
        Intrinsics.checkNotNullExpressionValue(mediaItemFromUri, "fromUri(...)");
        this.player.setMediaItem(mediaItemFromUri);
        this.player.prepare();
        this.player.play();
        observeSongFinished();
    }

    private final void observeSongFinished() {
        this.player.addListener(new Player.Listener() { // from class: com.soletreadmills.sole_v2._manager.AudioPlayerManager.observeSongFinished.1
            @Override // com.google.android.exoplayer2.Player.Listener
            public void onPlaybackStateChanged(int state) {
                if (state == 4) {
                    AudioPlayerManager.this.playNextSong();
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void playNextSong() {
        int i = this.currentIndex + 1;
        this.currentIndex = i;
        if (i >= this.playlist.size()) {
            this.currentIndex = 0;
        }
        playSong(this.currentIndex);
    }

    public final void release() {
        this.player.release();
    }

    public final void pause() {
        this.player.pause();
    }

    public final void resume() {
        if (this.playlist.isEmpty()) {
            return;
        }
        this.player.play();
    }

    public final void stop() {
        this.player.stop();
    }

    public final boolean hasPlaylist() {
        return !this.playlist.isEmpty();
    }

    public final void togglePlayPause() {
        if (this.player.isPlaying()) {
            this.player.pause();
        } else {
            this.player.play();
        }
    }
}
