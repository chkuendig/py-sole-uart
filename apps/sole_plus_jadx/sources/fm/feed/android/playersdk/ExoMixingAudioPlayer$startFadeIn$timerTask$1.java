package fm.feed.android.playersdk;

import android.os.Handler;
import java.util.Timer;
import java.util.TimerTask;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ExoMixingAudioPlayer.kt */
@Metadata(d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004"}, d2 = {"fm/feed/android/playersdk/ExoMixingAudioPlayer$startFadeIn$timerTask$1", "Ljava/util/TimerTask;", "run", "", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class ExoMixingAudioPlayer$startFadeIn$timerTask$1 extends TimerTask {
    final /* synthetic */ float $deltaVolume;
    final /* synthetic */ Timer $timer;
    final /* synthetic */ ExoMixingAudioPlayer this$0;

    ExoMixingAudioPlayer$startFadeIn$timerTask$1(ExoMixingAudioPlayer exoMixingAudioPlayer, float f, Timer timer) {
        this.this$0 = exoMixingAudioPlayer;
        this.$deltaVolume = f;
        this.$timer = timer;
    }

    @Override // java.util.TimerTask, java.lang.Runnable
    public void run() {
        Handler handler = this.this$0.mMainHandler;
        if (handler == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mMainHandler");
            handler = null;
        }
        final ExoMixingAudioPlayer exoMixingAudioPlayer = this.this$0;
        final float f = this.$deltaVolume;
        final Timer timer = this.$timer;
        handler.postAtFrontOfQueue(new Runnable() { // from class: fm.feed.android.playersdk.ExoMixingAudioPlayer$startFadeIn$timerTask$1$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ExoMixingAudioPlayer$startFadeIn$timerTask$1.m8769run$lambda0(exoMixingAudioPlayer, f, timer);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: run$lambda-0, reason: not valid java name */
    public static final void m8769run$lambda0(ExoMixingAudioPlayer this$0, float f, Timer timer) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(timer, "$timer");
        FMLog.v$default(this$0.log, Intrinsics.stringPlus("primary player volume increased to = ", Float.valueOf(this$0.volumeMin)), null, 2, null);
        PlayerProxy.INSTANCE.setVolume(this$0.mPrimaryPlayer.getPlayer(), this$0.volumeMin);
        this$0.volumeMin += f;
        if (this$0.volumeMin >= this$0.mPrimaryPlayer.getPlayingVolume()) {
            timer.cancel();
            timer.purge();
            PlayerProxy.INSTANCE.setVolume(this$0.mPrimaryPlayer.getPlayer(), this$0.mPrimaryPlayer.getPlayingVolume());
            FMLog.v$default(this$0.log, "Ended primary player fade in", null, 2, null);
            FMLog.v$default(this$0.log, Intrinsics.stringPlus(" After secondary fade out. state: ", this$0), null, 2, null);
        }
    }
}
