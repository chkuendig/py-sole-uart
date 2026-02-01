package fm.feed.android.playersdk;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import com.android.SdkConstants;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import fm.feed.android.playersdk.FeedAudioPlayer;
import fm.feed.android.playersdk.PlayerService;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeedPlayerService.kt */
@Metadata(d1 = {"\u0000I\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\f\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u0004H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J \u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0007J\u0010\u0010\u0012\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018H\u0007J\b\u0010\u0019\u001a\u00020\u000fH\u0002J\r\u0010\u001a\u001a\u00020\u000fH\u0000¢\u0006\u0002\b\u001bR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\r¨\u0006\u001c"}, d2 = {"Lfm/feed/android/playersdk/FeedPlayerService;", "", "()V", "feedAudioPlayer", "Lfm/feed/android/playersdk/FeedAudioPlayer;", "log", "Lfm/feed/android/playersdk/FMLog;", "mContext", "Landroid/content/Context;", "mPlayerService", "Lfm/feed/android/playersdk/PlayerService;", "mServerConn", "fm/feed/android/playersdk/FeedPlayerService$mServerConn$1", "Lfm/feed/android/playersdk/FeedPlayerService$mServerConn$1;", "getInstance", "", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lfm/feed/android/playersdk/AvailabilityListener;", "initialize", SdkConstants.ATTR_CONTEXT, "token", "", "secret", "builder", "Lfm/feed/android/playersdk/FeedAudioPlayer$Builder;", "startService", "stopService", "stopService$PlayerSdk_exoDefaultRelease", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class FeedPlayerService {
    private static FeedAudioPlayer feedAudioPlayer;
    private static Context mContext;
    private static PlayerService mPlayerService;
    public static final FeedPlayerService INSTANCE = new FeedPlayerService();
    private static final FMLog log = new FMLog("fm.feed.PlayerService");
    private static final FeedPlayerService$mServerConn$1 mServerConn = new ServiceConnection() { // from class: fm.feed.android.playersdk.FeedPlayerService$mServerConn$1
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName name, IBinder binder) {
            Intrinsics.checkNotNullParameter(name, "name");
            Intrinsics.checkNotNullParameter(binder, "binder");
            FeedPlayerService feedPlayerService = FeedPlayerService.INSTANCE;
            FeedPlayerService.mPlayerService = ((PlayerService.LocalBinder) binder).getThis$0();
            PlayerService playerService = FeedPlayerService.mPlayerService;
            Intrinsics.checkNotNull(playerService);
            FeedAudioPlayer feedAudioPlayer2 = FeedPlayerService.feedAudioPlayer;
            Intrinsics.checkNotNull(feedAudioPlayer2);
            playerService.setPlayer(feedAudioPlayer2);
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName name) {
            Intrinsics.checkNotNullParameter(name, "name");
            FeedPlayerService feedPlayerService = FeedPlayerService.INSTANCE;
            FeedPlayerService.mPlayerService = null;
        }
    };

    private FeedPlayerService() {
    }

    @JvmStatic
    public static final FeedAudioPlayer getInstance() {
        FeedAudioPlayer feedAudioPlayer2 = feedAudioPlayer;
        Intrinsics.checkNotNull(feedAudioPlayer2);
        return feedAudioPlayer2;
    }

    @JvmStatic
    public static final void initialize(Context context, String token, String secret) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(token, "token");
        Intrinsics.checkNotNullParameter(secret, "secret");
        if (feedAudioPlayer != null) {
            FMLog.w$default(log, "initialize() called a second time, so resetting original player", null, 2, null);
            INSTANCE.stopService$PlayerSdk_exoDefaultRelease();
            FeedAudioPlayer feedAudioPlayer2 = feedAudioPlayer;
            if (feedAudioPlayer2 != null) {
                feedAudioPlayer2.destroyInstance();
            }
            feedAudioPlayer = null;
        }
        mContext = context.getApplicationContext();
        Context context2 = mContext;
        Intrinsics.checkNotNull(context2);
        FeedAudioPlayer feedAudioPlayer3 = new FeedAudioPlayer(context2, token, secret);
        feedAudioPlayer = feedAudioPlayer3;
        Intrinsics.checkNotNull(feedAudioPlayer3);
        feedAudioPlayer3.addStateListener(new StateListener() { // from class: fm.feed.android.playersdk.FeedPlayerService.initialize.1
            @Override // fm.feed.android.playersdk.StateListener
            public void onStateChanged(State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                if (state == State.PAUSED && FeedPlayerService.mPlayerService != null) {
                    PlayerService playerService = FeedPlayerService.mPlayerService;
                    Intrinsics.checkNotNull(playerService);
                    playerService.stopForeground(false);
                } else if (state == State.PLAYING) {
                    FMLog.d$default(FeedPlayerService.log, "starting service", null, 2, null);
                    FeedPlayerService.INSTANCE.startService();
                }
            }
        });
    }

    @JvmStatic
    public static final void initialize(FeedAudioPlayer.Builder builder) {
        Intrinsics.checkNotNullParameter(builder, "builder");
        mContext = builder.getContext().getApplicationContext();
        FeedAudioPlayer feedAudioPlayerBuild = builder.build();
        feedAudioPlayer = feedAudioPlayerBuild;
        if (feedAudioPlayerBuild == null) {
            throw new IllegalArgumentException("The builder provided to FeedPlayerService.initialize() wasn't fully configured, and build() returned null");
        }
        if (feedAudioPlayerBuild == null) {
            return;
        }
        feedAudioPlayerBuild.addStateListener(new StateListener() { // from class: fm.feed.android.playersdk.FeedPlayerService.initialize.2
            @Override // fm.feed.android.playersdk.StateListener
            public void onStateChanged(State state) {
                Intrinsics.checkNotNullParameter(state, "state");
                if (state == State.PAUSED && FeedPlayerService.mPlayerService != null) {
                    PlayerService playerService = FeedPlayerService.mPlayerService;
                    Intrinsics.checkNotNull(playerService);
                    playerService.stopForeground(false);
                } else if (state == State.PLAYING) {
                    FMLog.d$default(FeedPlayerService.log, "starting service", null, 2, null);
                    FeedPlayerService.INSTANCE.startService();
                }
            }
        });
    }

    @JvmStatic
    public static final void getInstance(AvailabilityListener listener) {
        Intrinsics.checkNotNullParameter(listener, "listener");
        FeedAudioPlayer feedAudioPlayer2 = feedAudioPlayer;
        if (feedAudioPlayer2 == null || feedAudioPlayer2 == null) {
            return;
        }
        feedAudioPlayer2.addAvailabilityListener(listener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void startService() {
        if (mPlayerService == null) {
            Intent intent = new Intent(mContext, (Class<?>) PlayerService.class);
            Context context = mContext;
            Intrinsics.checkNotNull(context);
            context.startForegroundService(intent);
            Context context2 = mContext;
            Intrinsics.checkNotNull(context2);
            context2.bindService(intent, mServerConn, 64);
        }
    }

    public final void stopService$PlayerSdk_exoDefaultRelease() {
        Context context = mContext;
        if (context == null || mPlayerService == null) {
            return;
        }
        Intrinsics.checkNotNull(context);
        context.unbindService(mServerConn);
        PlayerService playerService = mPlayerService;
        Intrinsics.checkNotNull(playerService);
        playerService.stopForeground(false);
        Context context2 = mContext;
        Intrinsics.checkNotNull(context2);
        context2.stopService(new Intent(mContext, (Class<?>) PlayerService.class));
        mPlayerService = null;
    }
}
