package fm.feed.android.playersdk;

import android.app.PendingIntent;
import android.app.Service;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Binder;
import android.os.IBinder;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.MediaSessionCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.view.KeyEvent;
import com.android.SdkConstants;
import com.facebook.internal.ServerProtocol;
import fm.feed.android.playersdk.models.AudioFile;
import fm.feed.android.playersdk.models.NotificationStyle;
import fm.feed.android.playersdk.models.Play;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* compiled from: PlayerService.kt */
@Metadata(d1 = {"\u0000\u008f\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u000e*\u0001\u000e\b\u0000\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u00042\u00020\u0005:\u0002@AB\u0005¢\u0006\u0002\u0010\u0006J\n\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0003J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0017H\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0002J\u0010\u0010\u001b\u001a\u00020\u00152\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0010\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u001f\u001a\u00020 H\u0016J\u0012\u0010!\u001a\u0004\u0018\u00010\f2\u0006\u0010\"\u001a\u00020#H\u0016J\b\u0010$\u001a\u00020\u001aH\u0016J\b\u0010%\u001a\u00020\u001aH\u0016J\u0010\u0010&\u001a\u00020\u001a2\u0006\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u001aH\u0016J\b\u0010*\u001a\u00020\u001aH\u0016J\u0012\u0010+\u001a\u00020\u001a2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J \u0010.\u001a\u00020\u001a2\u0006\u0010,\u001a\u00020-2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000200H\u0016J\u0010\u00102\u001a\u00020\u001a2\u0006\u00103\u001a\u000204H\u0016J \u00105\u001a\u00020\u00152\u0006\u0010\"\u001a\u00020#2\u0006\u00106\u001a\u00020\u00152\u0006\u00107\u001a\u00020\u0015H\u0016J\u0010\u00108\u001a\u00020\u001a2\u0006\u00109\u001a\u00020\u001dH\u0016J\u000e\u0010:\u001a\u00020\u001a2\u0006\u0010;\u001a\u00020\nJ\b\u0010<\u001a\u00020\u001aH\u0002J\b\u0010=\u001a\u00020\u001aH\u0002J\u0010\u0010>\u001a\u00020\u001a2\u0006\u0010?\u001a\u000204H\u0002R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B"}, d2 = {"Lfm/feed/android/playersdk/PlayerService;", "Landroid/app/Service;", "Lfm/feed/android/playersdk/StateListener;", "Lfm/feed/android/playersdk/LikeStatusChangeListener;", "Lfm/feed/android/playersdk/PlayListener;", "Lfm/feed/android/playersdk/NotificationDataListener;", "()V", "log", "Lfm/feed/android/playersdk/FMLog;", "mAudioPlayer", "Lfm/feed/android/playersdk/FeedAudioPlayer;", "mBinder", "Landroid/os/IBinder;", "mCallback", "fm/feed/android/playersdk/PlayerService$mCallback$1", "Lfm/feed/android/playersdk/PlayerService$mCallback$1;", "mMediaSession", "Landroid/support/v4/media/session/MediaSessionCompat;", "mNotificationManager", "Lfm/feed/android/playersdk/MediaNotificationManager;", "mState", "", "createDefaultContentIntent", "Landroid/app/PendingIntent;", "createDefaultOldContentIntent", "destroyMediaSession", "", "mapStateToState", "playerState", "Lfm/feed/android/playersdk/State;", "onArtWorkChanged", SdkConstants.TAG_BITMAP, "Landroid/graphics/Bitmap;", "onBind", "intent", "Landroid/content/Intent;", "onCreate", "onDestroy", "onLikeStatusChanged", "audioFile", "Lfm/feed/android/playersdk/models/AudioFile;", "onNotificationStyleChanged", "onPendingIntentChanged", "onPlayStarted", "play", "Lfm/feed/android/playersdk/models/Play;", "onProgressUpdate", "elapsedTime", "", "duration", "onSkipStatusChanged", "status", "", "onStartCommand", "flags", "startId", "onStateChanged", ServerProtocol.DIALOG_PARAM_STATE, "setPlayer", "player", "setPs", "updateMetaData", "updateState", "forceUpdateNotification", "LocalBinder", "RemoteReceiver", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class PlayerService extends Service implements StateListener, LikeStatusChangeListener, PlayListener, NotificationDataListener {
    private FeedAudioPlayer mAudioPlayer;
    private MediaSessionCompat mMediaSession;
    private MediaNotificationManager mNotificationManager;
    private int mState;
    private final FMLog log = new FMLog("fm.feed.PlayerService");
    private IBinder mBinder = new LocalBinder(this);
    private final PlayerService$mCallback$1 mCallback = new MediaSessionCompat.Callback() { // from class: fm.feed.android.playersdk.PlayerService$mCallback$1
        /* JADX WARN: Removed duplicated region for block: B:43:0x009c  */
        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public boolean onMediaButtonEvent(android.content.Intent r5) {
            /*
                r4 = this;
                fm.feed.android.playersdk.PlayerService r0 = r4.this$0
                fm.feed.android.playersdk.FMLog r0 = fm.feed.android.playersdk.PlayerService.access$getLog$p(r0)
                r1 = 2
                java.lang.String r2 = "media session play/pause"
                r3 = 0
                fm.feed.android.playersdk.FMLog.d$default(r0, r2, r3, r1, r3)
                kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
                java.lang.String r0 = r5.getAction()
                java.lang.String r1 = "android.intent.action.MEDIA_BUTTON"
                boolean r0 = kotlin.jvm.internal.Intrinsics.areEqual(r1, r0)
                if (r0 == 0) goto Lcf
                java.lang.String r0 = "android.intent.extra.KEY_EVENT"
                android.os.Parcelable r0 = r5.getParcelableExtra(r0)
                android.view.KeyEvent r0 = (android.view.KeyEvent) r0
                if (r0 == 0) goto Lcf
                int r1 = r0.getAction()
                if (r1 != 0) goto Lcf
                int r5 = r0.getKeyCode()
                r0 = 126(0x7e, float:1.77E-43)
                r1 = 1
                java.lang.String r2 = "mAudioPlayer"
                if (r5 == r0) goto Lbe
                r0 = 127(0x7f, float:1.78E-43)
                if (r5 == r0) goto Lad
                switch(r5) {
                    case 85: goto L62;
                    case 86: goto L51;
                    case 87: goto L40;
                    default: goto L3e;
                }
            L3e:
                r5 = 0
                return r5
            L40:
                fm.feed.android.playersdk.PlayerService r5 = r4.this$0
                fm.feed.android.playersdk.FeedAudioPlayer r5 = fm.feed.android.playersdk.PlayerService.access$getMAudioPlayer$p(r5)
                if (r5 != 0) goto L4c
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
                goto L4d
            L4c:
                r3 = r5
            L4d:
                r3.skip()
                return r1
            L51:
                fm.feed.android.playersdk.PlayerService r5 = r4.this$0
                fm.feed.android.playersdk.FeedAudioPlayer r5 = fm.feed.android.playersdk.PlayerService.access$getMAudioPlayer$p(r5)
                if (r5 != 0) goto L5d
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
                goto L5e
            L5d:
                r3 = r5
            L5e:
                r3.stop()
                return r1
            L62:
                fm.feed.android.playersdk.PlayerService r5 = r4.this$0
                fm.feed.android.playersdk.FeedAudioPlayer r5 = fm.feed.android.playersdk.PlayerService.access$getMAudioPlayer$p(r5)
                if (r5 != 0) goto L6e
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
                r5 = r3
            L6e:
                fm.feed.android.playersdk.State r5 = r5.getMState()
                fm.feed.android.playersdk.State r0 = fm.feed.android.playersdk.State.PAUSED
                if (r5 == r0) goto L9c
                fm.feed.android.playersdk.PlayerService r5 = r4.this$0
                fm.feed.android.playersdk.FeedAudioPlayer r5 = fm.feed.android.playersdk.PlayerService.access$getMAudioPlayer$p(r5)
                if (r5 != 0) goto L82
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
                r5 = r3
            L82:
                fm.feed.android.playersdk.State r5 = r5.getMState()
                fm.feed.android.playersdk.State r0 = fm.feed.android.playersdk.State.READY_TO_PLAY
                if (r5 != r0) goto L8b
                goto L9c
            L8b:
                fm.feed.android.playersdk.PlayerService r5 = r4.this$0
                fm.feed.android.playersdk.FeedAudioPlayer r5 = fm.feed.android.playersdk.PlayerService.access$getMAudioPlayer$p(r5)
                if (r5 != 0) goto L97
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
                goto L98
            L97:
                r3 = r5
            L98:
                r3.pause()
                goto Lac
            L9c:
                fm.feed.android.playersdk.PlayerService r5 = r4.this$0
                fm.feed.android.playersdk.FeedAudioPlayer r5 = fm.feed.android.playersdk.PlayerService.access$getMAudioPlayer$p(r5)
                if (r5 != 0) goto La8
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
                goto La9
            La8:
                r3 = r5
            La9:
                r3.play()
            Lac:
                return r1
            Lad:
                fm.feed.android.playersdk.PlayerService r5 = r4.this$0
                fm.feed.android.playersdk.FeedAudioPlayer r5 = fm.feed.android.playersdk.PlayerService.access$getMAudioPlayer$p(r5)
                if (r5 != 0) goto Lb9
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
                goto Lba
            Lb9:
                r3 = r5
            Lba:
                r3.pause()
                return r1
            Lbe:
                fm.feed.android.playersdk.PlayerService r5 = r4.this$0
                fm.feed.android.playersdk.FeedAudioPlayer r5 = fm.feed.android.playersdk.PlayerService.access$getMAudioPlayer$p(r5)
                if (r5 != 0) goto Lca
                kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
                goto Lcb
            Lca:
                r3 = r5
            Lcb:
                r3.play()
                return r1
            Lcf:
                boolean r5 = super.onMediaButtonEvent(r5)
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.PlayerService$mCallback$1.onMediaButtonEvent(android.content.Intent):boolean");
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
        public void onPlay() {
            FeedAudioPlayer feedAudioPlayer = null;
            FMLog.d$default(this.this$0.log, "media session play", null, 2, null);
            FeedAudioPlayer feedAudioPlayer2 = this.this$0.mAudioPlayer;
            if (feedAudioPlayer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
            } else {
                feedAudioPlayer = feedAudioPlayer2;
            }
            feedAudioPlayer.play();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
        public void onPause() {
            FeedAudioPlayer feedAudioPlayer = null;
            FMLog.d$default(this.this$0.log, "media session paused", null, 2, null);
            FeedAudioPlayer feedAudioPlayer2 = this.this$0.mAudioPlayer;
            if (feedAudioPlayer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
            } else {
                feedAudioPlayer = feedAudioPlayer2;
            }
            feedAudioPlayer.pause();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
        public void onSkipToNext() {
            FeedAudioPlayer feedAudioPlayer = null;
            FMLog.d$default(this.this$0.log, "media session skip", null, 2, null);
            FeedAudioPlayer feedAudioPlayer2 = this.this$0.mAudioPlayer;
            if (feedAudioPlayer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
            } else {
                feedAudioPlayer = feedAudioPlayer2;
            }
            feedAudioPlayer.skip();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
        public void onStop() {
            FeedAudioPlayer feedAudioPlayer = null;
            FMLog.d$default(this.this$0.log, "media session stopped", null, 2, null);
            FeedAudioPlayer feedAudioPlayer2 = this.this$0.mAudioPlayer;
            if (feedAudioPlayer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
            } else {
                feedAudioPlayer = feedAudioPlayer2;
            }
            feedAudioPlayer.pause();
            this.this$0.destroyMediaSession();
        }

        @Override // android.support.v4.media.session.MediaSessionCompat.Callback
        public void onSetRating(RatingCompat rating) throws JSONException {
            Play.LikeState likeState;
            Intrinsics.checkNotNullParameter(rating, "rating");
            if (rating.getRatingStyle() == 2) {
                FeedAudioPlayer feedAudioPlayer = this.this$0.mAudioPlayer;
                FeedAudioPlayer feedAudioPlayer2 = null;
                if (feedAudioPlayer == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                    feedAudioPlayer = null;
                }
                if (feedAudioPlayer.getCurrentPlay() != null) {
                    FeedAudioPlayer feedAudioPlayer3 = this.this$0.mAudioPlayer;
                    if (feedAudioPlayer3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                        feedAudioPlayer3 = null;
                    }
                    Play currentPlay = feedAudioPlayer3.getCurrentPlay();
                    Intrinsics.checkNotNull(currentPlay);
                    likeState = currentPlay.getLikeState();
                } else {
                    likeState = Play.LikeState.NONE;
                }
                if (rating.isThumbUp()) {
                    if (likeState == Play.LikeState.LIKED) {
                        FeedAudioPlayer feedAudioPlayer4 = this.this$0.mAudioPlayer;
                        if (feedAudioPlayer4 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                            feedAudioPlayer4 = null;
                        }
                        FeedAudioPlayer feedAudioPlayer5 = this.this$0.mAudioPlayer;
                        if (feedAudioPlayer5 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                        } else {
                            feedAudioPlayer2 = feedAudioPlayer5;
                        }
                        Play currentPlay2 = feedAudioPlayer2.getCurrentPlay();
                        Intrinsics.checkNotNull(currentPlay2);
                        feedAudioPlayer4.unlike(currentPlay2.getAudioFile());
                        return;
                    }
                    FeedAudioPlayer feedAudioPlayer6 = this.this$0.mAudioPlayer;
                    if (feedAudioPlayer6 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                    } else {
                        feedAudioPlayer2 = feedAudioPlayer6;
                    }
                    feedAudioPlayer2.like();
                    return;
                }
                if (likeState == Play.LikeState.DISLIKED) {
                    FeedAudioPlayer feedAudioPlayer7 = this.this$0.mAudioPlayer;
                    if (feedAudioPlayer7 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                        feedAudioPlayer7 = null;
                    }
                    FeedAudioPlayer feedAudioPlayer8 = this.this$0.mAudioPlayer;
                    if (feedAudioPlayer8 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                    } else {
                        feedAudioPlayer2 = feedAudioPlayer8;
                    }
                    Play currentPlay3 = feedAudioPlayer2.getCurrentPlay();
                    Intrinsics.checkNotNull(currentPlay3);
                    feedAudioPlayer7.unlike(currentPlay3.getAudioFile());
                    return;
                }
                FeedAudioPlayer feedAudioPlayer9 = this.this$0.mAudioPlayer;
                if (feedAudioPlayer9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                } else {
                    feedAudioPlayer2 = feedAudioPlayer9;
                }
                feedAudioPlayer2.dislike();
            }
        }
    };

    /* compiled from: PlayerService.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[State.values().length];
            iArr[State.PAUSED.ordinal()] = 1;
            iArr[State.PLAYING.ordinal()] = 2;
            iArr[State.UNINITIALIZED.ordinal()] = 3;
            iArr[State.STALLED.ordinal()] = 4;
            iArr[State.UNAVAILABLE.ordinal()] = 5;
            iArr[State.READY_TO_PLAY.ordinal()] = 6;
            iArr[State.WAITING_FOR_ITEM.ordinal()] = 7;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    @Override // fm.feed.android.playersdk.PlayListener
    public void onProgressUpdate(Play play, float elapsedTime, float duration) {
        Intrinsics.checkNotNullParameter(play, "play");
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int flags, int startId) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return 2;
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        return this.mBinder;
    }

    public final void setPlayer(FeedAudioPlayer player) {
        Intrinsics.checkNotNullParameter(player, "player");
        this.mAudioPlayer = player;
        FeedAudioPlayer feedAudioPlayer = null;
        if (player == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
            player = null;
        }
        player.addStateListener(this);
        FeedAudioPlayer feedAudioPlayer2 = this.mAudioPlayer;
        if (feedAudioPlayer2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
            feedAudioPlayer2 = null;
        }
        feedAudioPlayer2.addLikeStatusChangeListener(this);
        FeedAudioPlayer feedAudioPlayer3 = this.mAudioPlayer;
        if (feedAudioPlayer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
            feedAudioPlayer3 = null;
        }
        feedAudioPlayer3.addPlayListener(this);
        FeedAudioPlayer feedAudioPlayer4 = this.mAudioPlayer;
        if (feedAudioPlayer4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
            feedAudioPlayer4 = null;
        }
        feedAudioPlayer4.setNotificationDataListener$PlayerSdk_exoDefaultRelease(this);
        FeedAudioPlayer feedAudioPlayer5 = this.mAudioPlayer;
        if (feedAudioPlayer5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
        } else {
            feedAudioPlayer = feedAudioPlayer5;
        }
        this.mState = mapStateToState(feedAudioPlayer.getMState());
        updateState(true);
        updateMetaData();
    }

    @Override // fm.feed.android.playersdk.StateListener
    public void onStateChanged(State state) {
        Intrinsics.checkNotNullParameter(state, "state");
        this.mState = mapStateToState(state);
        updateState(false);
    }

    @Override // fm.feed.android.playersdk.PlayListener
    public void onSkipStatusChanged(boolean status) {
        updateState(false);
    }

    @Override // fm.feed.android.playersdk.PlayListener
    public void onPlayStarted(Play play) {
        updateMetaData();
    }

    @Override // fm.feed.android.playersdk.LikeStatusChangeListener
    public void onLikeStatusChanged(AudioFile audioFile) {
        Intrinsics.checkNotNullParameter(audioFile, "audioFile");
        updateMetaData();
    }

    @Override // fm.feed.android.playersdk.NotificationDataListener
    public void onPendingIntentChanged() {
        updateState(true);
    }

    @Override // fm.feed.android.playersdk.NotificationDataListener
    public void onNotificationStyleChanged() {
        updateState(true);
        if (this.mNotificationManager != null) {
            FeedAudioPlayer feedAudioPlayer = this.mAudioPlayer;
            FeedAudioPlayer feedAudioPlayer2 = null;
            if (feedAudioPlayer == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                feedAudioPlayer = null;
            }
            if (feedAudioPlayer.getNotificationStyle() != null) {
                MediaNotificationManager mediaNotificationManager = this.mNotificationManager;
                Intrinsics.checkNotNull(mediaNotificationManager);
                FeedAudioPlayer feedAudioPlayer3 = this.mAudioPlayer;
                if (feedAudioPlayer3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                } else {
                    feedAudioPlayer2 = feedAudioPlayer3;
                }
                NotificationStyle notificationStyle = feedAudioPlayer2.getNotificationStyle();
                Intrinsics.checkNotNull(notificationStyle);
                mediaNotificationManager.setNotificationIcons(notificationStyle);
            }
        }
    }

    @Override // fm.feed.android.playersdk.NotificationDataListener
    public void onArtWorkChanged(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bitmap");
        updateMetaData();
    }

    /* compiled from: PlayerService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lfm/feed/android/playersdk/PlayerService$LocalBinder;", "Landroid/os/Binder;", "(Lfm/feed/android/playersdk/PlayerService;)V", "playerInstance", "Lfm/feed/android/playersdk/PlayerService;", "getPlayerInstance", "()Lfm/feed/android/playersdk/PlayerService;", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class LocalBinder extends Binder {
        final /* synthetic */ PlayerService this$0;

        public LocalBinder(PlayerService this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
        }

        /* renamed from: getPlayerInstance, reason: from getter */
        public final PlayerService getThis$0() {
            return this.this$0;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.app.Service
    public void onDestroy() {
        MediaNotificationManager mediaNotificationManager = this.mNotificationManager;
        if (mediaNotificationManager != null) {
            Intrinsics.checkNotNull(mediaNotificationManager);
            mediaNotificationManager.cancelNotification();
        }
        super.onDestroy();
    }

    private final PendingIntent createDefaultOldContentIntent() {
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getApplicationInfo().packageName);
        if (launchIntentForPackage == null) {
            return null;
        }
        launchIntentForPackage.addFlags(541065216);
        return PendingIntent.getActivity(getApplicationContext(), 0, launchIntentForPackage, 268435456);
    }

    private final PendingIntent createDefaultContentIntent() {
        Intent launchIntentForPackage = getPackageManager().getLaunchIntentForPackage(getApplicationInfo().packageName);
        if (launchIntentForPackage == null) {
            return null;
        }
        launchIntentForPackage.addFlags(541065216);
        return PendingIntent.getActivity(getApplicationContext(), 0, launchIntentForPackage, 335544320);
    }

    private final int mapStateToState(State playerState) {
        int i = WhenMappings.$EnumSwitchMapping$0[playerState.ordinal()];
        if (i == 1) {
            return 2;
        }
        if (i == 2) {
            return 3;
        }
        if (i == 3 || i == 4) {
            return 6;
        }
        return i != 5 ? 1 : 0;
    }

    private final void updateState(boolean forceUpdateNotification) {
        FeedAudioPlayer feedAudioPlayer;
        FeedAudioPlayer feedAudioPlayer2 = null;
        if (this.mMediaSession == null || forceUpdateNotification) {
            if (this.mState != 3) {
                FMLog.d$default(this.log, "Ignoring state update since playback hasn't started yet", null, 2, null);
                return;
            }
            FMLog.d$default(this.log, "Creating new media session", null, 2, null);
            ComponentName componentName = new ComponentName(getPackageName(), RemoteReceiver.class.getName());
            FeedAudioPlayer feedAudioPlayer3 = this.mAudioPlayer;
            if (feedAudioPlayer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                feedAudioPlayer3 = null;
            }
            PendingIntent pendingIntent = feedAudioPlayer3.getPendingIntent();
            if (pendingIntent == null) {
                pendingIntent = createDefaultContentIntent();
            }
            PendingIntent pendingIntent2 = pendingIntent;
            MediaSessionCompat mediaSessionCompat = new MediaSessionCompat(this, "Feed Music Service", componentName, pendingIntent2);
            this.mMediaSession = mediaSessionCompat;
            Intrinsics.checkNotNull(mediaSessionCompat);
            mediaSessionCompat.setFlags(3);
            MediaSessionCompat mediaSessionCompat2 = this.mMediaSession;
            Intrinsics.checkNotNull(mediaSessionCompat2);
            mediaSessionCompat2.setCallback(this.mCallback);
            MediaSessionCompat mediaSessionCompat3 = this.mMediaSession;
            Intrinsics.checkNotNull(mediaSessionCompat3);
            mediaSessionCompat3.setActive(true);
            setPs();
            updateMetaData();
            FeedAudioPlayer feedAudioPlayer4 = this.mAudioPlayer;
            if (feedAudioPlayer4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                feedAudioPlayer = null;
            } else {
                feedAudioPlayer = feedAudioPlayer4;
            }
            MediaSessionCompat mediaSessionCompat4 = this.mMediaSession;
            Intrinsics.checkNotNull(mediaSessionCompat4);
            MediaControllerCompat controller = mediaSessionCompat4.getController();
            FeedAudioPlayer feedAudioPlayer5 = this.mAudioPlayer;
            if (feedAudioPlayer5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                feedAudioPlayer5 = null;
            }
            this.mNotificationManager = new MediaNotificationManager(feedAudioPlayer, this, controller, pendingIntent2, feedAudioPlayer5.getNotificationStyle());
        } else {
            int i = this.mState;
            if (i == 0 || i == 1) {
                destroyMediaSession();
                return;
            }
        }
        FeedAudioPlayer feedAudioPlayer6 = this.mAudioPlayer;
        if (feedAudioPlayer6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
            feedAudioPlayer6 = null;
        }
        long j = feedAudioPlayer6.canSkip() ? 673L : 641L;
        float f = this.mState == 3 ? 1.0f : 0.0f;
        FMLog.d$default(this.log, "Updating playback state", null, 2, null);
        PlaybackStateCompat.Builder builder = new PlaybackStateCompat.Builder();
        int i2 = this.mState;
        FeedAudioPlayer feedAudioPlayer7 = this.mAudioPlayer;
        if (feedAudioPlayer7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
        } else {
            feedAudioPlayer2 = feedAudioPlayer7;
        }
        PlaybackStateCompat playbackStateCompatBuild = builder.setState(i2, ((long) feedAudioPlayer2.getCurrentPlaybackTime()) * 1000, f).setActions(j).build();
        MediaSessionCompat mediaSessionCompat5 = this.mMediaSession;
        Intrinsics.checkNotNull(mediaSessionCompat5);
        mediaSessionCompat5.setPlaybackState(playbackStateCompatBuild);
    }

    private final void setPs() {
        FeedAudioPlayer feedAudioPlayer = this.mAudioPlayer;
        FeedAudioPlayer feedAudioPlayer2 = null;
        if (feedAudioPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
            feedAudioPlayer = null;
        }
        long j = feedAudioPlayer.canSkip() ? 673L : 641L;
        float f = this.mState == 3 ? 1.0f : 0.0f;
        FMLog.d$default(this.log, "Updating playback state", null, 2, null);
        PlaybackStateCompat.Builder builder = new PlaybackStateCompat.Builder();
        int i = this.mState;
        FeedAudioPlayer feedAudioPlayer3 = this.mAudioPlayer;
        if (feedAudioPlayer3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
        } else {
            feedAudioPlayer2 = feedAudioPlayer3;
        }
        PlaybackStateCompat playbackStateCompatBuild = builder.setState(i, (long) (feedAudioPlayer2.getCurrentPlaybackTime() * 1000), f).setActions(j).build();
        MediaSessionCompat mediaSessionCompat = this.mMediaSession;
        Intrinsics.checkNotNull(mediaSessionCompat);
        mediaSessionCompat.setPlaybackState(playbackStateCompatBuild);
    }

    private final void updateMetaData() {
        if (this.mMediaSession == null) {
            return;
        }
        MediaMetadataCompat.Builder builder = new MediaMetadataCompat.Builder();
        FeedAudioPlayer feedAudioPlayer = this.mAudioPlayer;
        FeedAudioPlayer feedAudioPlayer2 = null;
        if (feedAudioPlayer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
            feedAudioPlayer = null;
        }
        if (feedAudioPlayer.getCurrentPlay() == null) {
            FMLog.d$default(this.log, "(metadata will be empty)", null, 2, null);
        } else {
            FeedAudioPlayer feedAudioPlayer3 = this.mAudioPlayer;
            if (feedAudioPlayer3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                feedAudioPlayer3 = null;
            }
            if (feedAudioPlayer3.getCurrentPlay() != null) {
                FeedAudioPlayer feedAudioPlayer4 = this.mAudioPlayer;
                if (feedAudioPlayer4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                    feedAudioPlayer4 = null;
                }
                Play currentPlay = feedAudioPlayer4.getCurrentPlay();
                Intrinsics.checkNotNull(currentPlay);
                MediaMetadataCompat.Builder builderPutString = builder.putString(MediaMetadataCompat.METADATA_KEY_TITLE, currentPlay.getAudioFile().getTrack().getTitle());
                FeedAudioPlayer feedAudioPlayer5 = this.mAudioPlayer;
                if (feedAudioPlayer5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                    feedAudioPlayer5 = null;
                }
                Play currentPlay2 = feedAudioPlayer5.getCurrentPlay();
                Intrinsics.checkNotNull(currentPlay2);
                MediaMetadataCompat.Builder builderPutString2 = builderPutString.putString(MediaMetadataCompat.METADATA_KEY_ARTIST, currentPlay2.getAudioFile().getArtist().getName());
                FeedAudioPlayer feedAudioPlayer6 = this.mAudioPlayer;
                if (feedAudioPlayer6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                    feedAudioPlayer6 = null;
                }
                Play currentPlay3 = feedAudioPlayer6.getCurrentPlay();
                Intrinsics.checkNotNull(currentPlay3);
                MediaMetadataCompat.Builder builderPutString3 = builderPutString2.putString(MediaMetadataCompat.METADATA_KEY_ALBUM, currentPlay3.getAudioFile().getRelease().getTitle());
                FeedAudioPlayer feedAudioPlayer7 = this.mAudioPlayer;
                if (feedAudioPlayer7 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                    feedAudioPlayer7 = null;
                }
                Play currentPlay4 = feedAudioPlayer7.getCurrentPlay();
                Intrinsics.checkNotNull(currentPlay4);
                builderPutString3.putLong(MediaMetadataCompat.METADATA_KEY_DURATION, (long) (currentPlay4.getAudioFile().getDurationInSeconds() * 1000));
            }
            FeedAudioPlayer feedAudioPlayer8 = this.mAudioPlayer;
            if (feedAudioPlayer8 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                feedAudioPlayer8 = null;
            }
            if (feedAudioPlayer8.getArtWork() != null) {
                FeedAudioPlayer feedAudioPlayer9 = this.mAudioPlayer;
                if (feedAudioPlayer9 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                    feedAudioPlayer9 = null;
                }
                builder.putBitmap(MediaMetadataCompat.METADATA_KEY_ART, feedAudioPlayer9.getArtWork());
                FeedAudioPlayer feedAudioPlayer10 = this.mAudioPlayer;
                if (feedAudioPlayer10 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                    feedAudioPlayer10 = null;
                }
                builder.putBitmap(MediaMetadataCompat.METADATA_KEY_ALBUM_ART, feedAudioPlayer10.getArtWork());
            }
            FeedAudioPlayer feedAudioPlayer11 = this.mAudioPlayer;
            if (feedAudioPlayer11 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
            } else {
                feedAudioPlayer2 = feedAudioPlayer11;
            }
            Play currentPlay5 = feedAudioPlayer2.getCurrentPlay();
            Intrinsics.checkNotNull(currentPlay5);
            Play.LikeState likeState = currentPlay5.getLikeState();
            if (likeState == Play.LikeState.LIKED) {
                builder.putRating(MediaMetadataCompat.METADATA_KEY_RATING, RatingCompat.newThumbRating(true));
            } else if (likeState == Play.LikeState.DISLIKED) {
                builder.putRating(MediaMetadataCompat.METADATA_KEY_RATING, RatingCompat.newThumbRating(false));
            }
        }
        MediaMetadataCompat mediaMetadataCompatBuild = builder.build();
        MediaSessionCompat mediaSessionCompat = this.mMediaSession;
        Intrinsics.checkNotNull(mediaSessionCompat);
        mediaSessionCompat.setMetadata(mediaMetadataCompatBuild);
    }

    /* compiled from: PlayerService.kt */
    @Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, d2 = {"Lfm/feed/android/playersdk/PlayerService$RemoteReceiver;", "Landroid/content/BroadcastReceiver;", "(Lfm/feed/android/playersdk/PlayerService;)V", "onReceive", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public final class RemoteReceiver extends BroadcastReceiver {
        final /* synthetic */ PlayerService this$0;

        public RemoteReceiver(PlayerService this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            this.this$0 = this$0;
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            FeedAudioPlayer feedAudioPlayer = null;
            if (!Intrinsics.areEqual("android.intent.action.MEDIA_BUTTON", intent.getAction())) {
                FMLog fMLog = this.this$0.log;
                String action = intent.getAction();
                Intrinsics.checkNotNull(action);
                FMLog.d$default(fMLog, Intrinsics.stringPlus(" unknown action: ", action), null, 2, null);
                return;
            }
            KeyEvent keyEvent = (KeyEvent) intent.getParcelableExtra("android.intent.extra.KEY_EVENT");
            if (keyEvent == null || keyEvent.getAction() != 0) {
                return;
            }
            FeedAudioPlayer feedAudioPlayer2 = this.this$0.mAudioPlayer;
            if (feedAudioPlayer2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                feedAudioPlayer2 = null;
            }
            State mState = feedAudioPlayer2.getMState();
            FMLog.d$default(this.this$0.log, "received media action button", null, 2, null);
            int keyCode = keyEvent.getKeyCode();
            if (keyCode == 85) {
                if (mState == State.PAUSED) {
                    FeedAudioPlayer feedAudioPlayer3 = this.this$0.mAudioPlayer;
                    if (feedAudioPlayer3 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                    } else {
                        feedAudioPlayer = feedAudioPlayer3;
                    }
                    feedAudioPlayer.play();
                    return;
                }
                if (mState == State.PLAYING) {
                    FeedAudioPlayer feedAudioPlayer4 = this.this$0.mAudioPlayer;
                    if (feedAudioPlayer4 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                    } else {
                        feedAudioPlayer = feedAudioPlayer4;
                    }
                    feedAudioPlayer.pause();
                    return;
                }
                return;
            }
            if (keyCode != 126) {
                if (keyCode == 127 && mState == State.PLAYING) {
                    FeedAudioPlayer feedAudioPlayer5 = this.this$0.mAudioPlayer;
                    if (feedAudioPlayer5 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                    } else {
                        feedAudioPlayer = feedAudioPlayer5;
                    }
                    feedAudioPlayer.pause();
                    return;
                }
                return;
            }
            if (mState == State.PAUSED) {
                FeedAudioPlayer feedAudioPlayer6 = this.this$0.mAudioPlayer;
                if (feedAudioPlayer6 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mAudioPlayer");
                } else {
                    feedAudioPlayer = feedAudioPlayer6;
                }
                feedAudioPlayer.play();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void destroyMediaSession() {
        FMLog.d$default(this.log, "releasing media session", null, 2, null);
        MediaSessionCompat mediaSessionCompat = this.mMediaSession;
        if (mediaSessionCompat != null) {
            Intrinsics.checkNotNull(mediaSessionCompat);
            mediaSessionCompat.release();
            this.mMediaSession = null;
            MediaNotificationManager mediaNotificationManager = this.mNotificationManager;
            if (mediaNotificationManager != null) {
                Intrinsics.checkNotNull(mediaNotificationManager);
                mediaNotificationManager.cancelNotification();
                this.mNotificationManager = null;
            }
        }
    }
}
