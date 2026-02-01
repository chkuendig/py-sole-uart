package com.soletreadmills.sole_v2.ui.classes;

import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.media3.exoplayer.ExoPlayer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: VideoPlayerView.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0015\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\fH\u0000¢\u0006\u0002\b\u0010J\u0006\u0010\u0011\u001a\u00020\u0012J\u0006\u0010\u0013\u001a\u00020\u0012J\u0006\u0010\u0014\u001a\u00020\u000eJ\u0006\u0010\u0015\u001a\u00020\u000eJ\u0006\u0010\u0016\u001a\u00020\u000eJ\u000e\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u0018\u001a\u00020\u0012J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u001a\u001a\u00020\u0012J\u0006\u0010\u001b\u001a\u00020\u000eR+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048F@BX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001c"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/classes/VideoPlayerController;", "", "()V", "<set-?>", "", "isPlaying", "()Z", "setPlaying", "(Z)V", "isPlaying$delegate", "Landroidx/compose/runtime/MutableState;", "player", "Landroidx/media3/exoplayer/ExoPlayer;", "attachPlayer", "", "exoPlayer", "attachPlayer$app_release", "getCurrentPosition", "", "getDuration", "pause", "play", "replay", "seekBy", "deltaMs", "seekTo", "positionMs", "togglePlayPause", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VideoPlayerController {
    public static final int $stable = 8;

    /* renamed from: isPlaying$delegate, reason: from kotlin metadata */
    private final MutableState isPlaying = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
    private ExoPlayer player;

    public final void attachPlayer$app_release(ExoPlayer exoPlayer) {
        Intrinsics.checkNotNullParameter(exoPlayer, "exoPlayer");
        this.player = exoPlayer;
    }

    private final void setPlaying(boolean z) {
        this.isPlaying.setValue(Boolean.valueOf(z));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean isPlaying() {
        return ((Boolean) this.isPlaying.getValue()).booleanValue();
    }

    public final void play() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.play();
        }
    }

    public final void pause() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.pause();
        }
    }

    public final void seekTo(long positionMs) {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            exoPlayer.seekTo(positionMs);
        }
    }

    public final void seekBy(long deltaMs) {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            seekTo(exoPlayer.getCurrentPosition() + deltaMs);
        }
    }

    public final void replay() {
        if (this.player != null) {
            seekTo(0L);
        }
    }

    public final void togglePlayPause() {
        if (isPlaying()) {
            pause();
        } else {
            play();
        }
        setPlaying(!isPlaying());
    }

    public final long getCurrentPosition() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            return exoPlayer.getCurrentPosition();
        }
        return 0L;
    }

    public final long getDuration() {
        ExoPlayer exoPlayer = this.player;
        if (exoPlayer != null) {
            return exoPlayer.getDuration();
        }
        return 0L;
    }
}
