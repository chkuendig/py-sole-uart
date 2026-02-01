package fm.feed.android.playersdk;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Bitmap;
import android.media.MediaMetadata;
import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.RatingCompat;
import android.support.v4.media.session.MediaControllerCompat;
import android.support.v4.media.session.PlaybackStateCompat;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.media.app.NotificationCompat;
import com.android.SdkConstants;
import com.sun.jna.Callback;
import fm.feed.android.playersdk.models.NotificationStyle;
import fm.feed.android.playersdk.models.Play;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;

/* compiled from: MediaNotificationManager.kt */
@Metadata(d1 = {"\u0000\u009d\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005*\u0001\u000e\b\u0000\u0018\u0000 B2\u00020\u0001:\u0002ABB3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b¢\u0006\u0002\u0010\fJ0\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!H\u0002J\u0006\u0010%\u001a\u00020&J\b\u0010'\u001a\u00020&H\u0003J\b\u0010(\u001a\u00020)H\u0003J\n\u0010*\u001a\u0004\u0018\u00010+H\u0002J\b\u0010,\u001a\u00020-H\u0002J\u0018\u0010.\u001a\u00020&2\u0006\u0010/\u001a\u0002002\u0006\u00101\u001a\u000202H\u0016J\u000e\u00103\u001a\u00020&2\u0006\u00104\u001a\u00020\u000bJ\b\u00105\u001a\u00020&H\u0002Jb\u00106\u001a\u00020&2\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020:2\u0006\u0010<\u001a\u00020:2\b\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020!2\u0006\u0010?\u001a\u00020\u00152\u0006\u0010@\u001a\u00020\u0015H\u0002R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006C"}, d2 = {"Lfm/feed/android/playersdk/MediaNotificationManager;", "Landroid/content/BroadcastReceiver;", "mAudioPlayer", "Lfm/feed/android/playersdk/FeedAudioPlayer;", "mPlayerService", "Lfm/feed/android/playersdk/PlayerService;", "mMediaController", "Landroid/support/v4/media/session/MediaControllerCompat;", "mContentIntent", "Landroid/app/PendingIntent;", "mNotificationStyle", "Lfm/feed/android/playersdk/models/NotificationStyle;", "(Lfm/feed/android/playersdk/FeedAudioPlayer;Lfm/feed/android/playersdk/PlayerService;Landroid/support/v4/media/session/MediaControllerCompat;Landroid/app/PendingIntent;Lfm/feed/android/playersdk/models/NotificationStyle;)V", Callback.METHOD_NAME, "fm/feed/android/playersdk/MediaNotificationManager$callback$1", "Lfm/feed/android/playersdk/MediaNotificationManager$callback$1;", "log", "Lfm/feed/android/playersdk/FMLog;", "mCancelIntent", "mDislikeIntent", "mForeground", "", "mLikeIntent", "mNextIntent", "mNotificationManager", "Landroidx/core/app/NotificationManagerCompat;", "mPauseIntent", "mPlayIntent", "addActions", "", "notificationBuilder", "Landroidx/core/app/NotificationCompat$Builder;", "thumbsDownState", "Lfm/feed/android/playersdk/MediaNotificationManager$ButtonState;", "thumbsUpState", "playPauseState", "skipState", "cancelNotification", "", "createChannel", "createMediaMetaData", "", "createNotification", "Landroid/app/Notification;", "getFlags", "", "onReceive", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "setNotificationIcons", "ni", "updateNotification", "wireUpRemoteViews", "remoteViews", "Landroid/widget/RemoteViews;", "title", "", "artist", "album", "bm", "Landroid/graphics/Bitmap;", "buffering", "big", "ButtonState", "Companion", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class MediaNotificationManager extends BroadcastReceiver {
    public static final String ACTION_CANCEL = "fm.feed.android.playersdk.cancel";
    public static final String ACTION_DISLIKE = "fm.feed.android.playersdk.dislike";
    public static final String ACTION_LIKE = "fm.feed.android.playersdk.like";
    public static final String ACTION_NEXT = "fm.feed.android.playersdk.next";
    public static final String ACTION_PAUSE = "fm.feed.android.playersdk.pause";
    public static final String ACTION_PLAY = "fm.feed.android.playersdk.play";
    private static final String CHANNEL_ID = "media_playback_channel";
    private static final int NOTIFICATION_ID = 53376;
    private static final int REQUEST_CODE = 808;
    private final MediaNotificationManager$callback$1 callback;
    private final FMLog log;
    private final FeedAudioPlayer mAudioPlayer;
    private final PendingIntent mCancelIntent;
    private final PendingIntent mContentIntent;
    private final PendingIntent mDislikeIntent;
    private boolean mForeground;
    private final PendingIntent mLikeIntent;
    private MediaControllerCompat mMediaController;
    private final PendingIntent mNextIntent;
    private final NotificationManagerCompat mNotificationManager;
    private NotificationStyle mNotificationStyle;
    private final PendingIntent mPauseIntent;
    private final PendingIntent mPlayIntent;
    private final PlayerService mPlayerService;

    /* compiled from: MediaNotificationManager.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lfm/feed/android/playersdk/MediaNotificationManager$ButtonState;", "", "(Ljava/lang/String;I)V", "DISABLED", "NORMAL", "SELECTED", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    private enum ButtonState {
        DISABLED,
        NORMAL,
        SELECTED
    }

    /* compiled from: MediaNotificationManager.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ButtonState.values().length];
            iArr[ButtonState.DISABLED.ordinal()] = 1;
            iArr[ButtonState.NORMAL.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private final int getFlags() {
        return 335544320;
    }

    /* JADX WARN: Type inference failed for: r12v3, types: [fm.feed.android.playersdk.MediaNotificationManager$callback$1] */
    public MediaNotificationManager(FeedAudioPlayer mAudioPlayer, PlayerService mPlayerService, MediaControllerCompat mediaControllerCompat, PendingIntent pendingIntent, NotificationStyle notificationStyle) {
        Intrinsics.checkNotNullParameter(mAudioPlayer, "mAudioPlayer");
        Intrinsics.checkNotNullParameter(mPlayerService, "mPlayerService");
        this.mAudioPlayer = mAudioPlayer;
        this.mPlayerService = mPlayerService;
        this.mMediaController = mediaControllerCompat;
        this.mContentIntent = pendingIntent;
        this.mNotificationStyle = notificationStyle;
        this.log = new FMLog("fm.feed.MediaNotif");
        NotificationManagerCompat notificationManagerCompatFrom = NotificationManagerCompat.from(mPlayerService);
        Intrinsics.checkNotNullExpressionValue(notificationManagerCompatFrom, "from(mPlayerService)");
        this.mNotificationManager = notificationManagerCompatFrom;
        ?? r12 = new MediaControllerCompat.Callback() { // from class: fm.feed.android.playersdk.MediaNotificationManager$callback$1
            @Override // android.support.v4.media.session.MediaControllerCompat.Callback
            public void onPlaybackStateChanged(PlaybackStateCompat state) {
                Intrinsics.checkNotNullParameter(state, "state");
                if (state.getState() == 1 || state.getState() == 0) {
                    FMLog.d$default(this.this$0.log, "Playback state changed to STOPPED or NONE", null, 2, null);
                } else {
                    this.this$0.updateNotification();
                }
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback
            public void onMetadataChanged(MediaMetadataCompat metadata) {
                FMLog.d$default(this.this$0.log, "Metadata changed", null, 2, null);
                this.this$0.updateNotification();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback
            public void onExtrasChanged(Bundle extras) {
                FMLog.d$default(this.this$0.log, "Extras changed", null, 2, null);
                this.this$0.updateNotification();
            }

            @Override // android.support.v4.media.session.MediaControllerCompat.Callback
            public void onSessionDestroyed() {
                FMLog.d$default(this.this$0.log, "Session destroyed", null, 2, null);
                this.this$0.cancelNotification();
            }
        };
        this.callback = r12;
        String packageName = mPlayerService.getPackageName();
        PendingIntent broadcast = PendingIntent.getBroadcast(mPlayerService, REQUEST_CODE, new Intent(ACTION_PAUSE).setPackage(packageName), getFlags());
        Intrinsics.checkNotNullExpressionValue(broadcast, "getBroadcast(mPlayerServ…Package(pkg), getFlags())");
        this.mPauseIntent = broadcast;
        PendingIntent broadcast2 = PendingIntent.getBroadcast(mPlayerService, REQUEST_CODE, new Intent(ACTION_PLAY).setPackage(packageName), getFlags());
        Intrinsics.checkNotNullExpressionValue(broadcast2, "getBroadcast(mPlayerServ…Package(pkg), getFlags())");
        this.mPlayIntent = broadcast2;
        PendingIntent broadcast3 = PendingIntent.getBroadcast(mPlayerService, REQUEST_CODE, new Intent(ACTION_NEXT).setPackage(packageName), getFlags());
        Intrinsics.checkNotNullExpressionValue(broadcast3, "getBroadcast(mPlayerServ…Package(pkg), getFlags())");
        this.mNextIntent = broadcast3;
        PendingIntent broadcast4 = PendingIntent.getBroadcast(mPlayerService, REQUEST_CODE, new Intent(ACTION_CANCEL).setPackage(packageName), getFlags());
        Intrinsics.checkNotNullExpressionValue(broadcast4, "getBroadcast(mPlayerServ…Package(pkg), getFlags())");
        this.mCancelIntent = broadcast4;
        PendingIntent broadcast5 = PendingIntent.getBroadcast(mPlayerService, REQUEST_CODE, new Intent(ACTION_LIKE).setPackage(packageName), getFlags());
        Intrinsics.checkNotNullExpressionValue(broadcast5, "getBroadcast(mPlayerServ…Package(pkg), getFlags())");
        this.mLikeIntent = broadcast5;
        PendingIntent broadcast6 = PendingIntent.getBroadcast(mPlayerService, REQUEST_CODE, new Intent(ACTION_DISLIKE).setPackage(packageName), getFlags());
        Intrinsics.checkNotNullExpressionValue(broadcast6, "getBroadcast(mPlayerServ…Package(pkg), getFlags())");
        this.mDislikeIntent = broadcast6;
        notificationManagerCompatFrom.cancelAll();
        MediaControllerCompat mediaControllerCompat2 = this.mMediaController;
        Intrinsics.checkNotNull(mediaControllerCompat2);
        mediaControllerCompat2.registerCallback((MediaControllerCompat.Callback) r12);
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_NEXT);
        intentFilter.addAction(ACTION_PLAY);
        intentFilter.addAction(ACTION_PAUSE);
        intentFilter.addAction(ACTION_CANCEL);
        intentFilter.addAction(ACTION_LIKE);
        intentFilter.addAction(ACTION_DISLIKE);
        mPlayerService.registerReceiver(this, intentFilter);
        this.mForeground = true;
        createChannel();
        Notification notificationCreateNotification = createNotification();
        if (notificationCreateNotification != null) {
            mPlayerService.startForeground(NOTIFICATION_ID, notificationCreateNotification);
        }
        updateNotification();
    }

    private final Object createMediaMetaData() {
        MediaMetadata mediaMetadataBuild = new MediaMetadata.Builder().putText(MediaMetadataCompat.METADATA_KEY_DISPLAY_TITLE, " ").build();
        Intrinsics.checkNotNullExpressionValue(mediaMetadataBuild, "Builder().putText(MediaM…SPLAY_TITLE, \" \").build()");
        return mediaMetadataBuild;
    }

    private final void createChannel() {
        Object systemService = this.mPlayerService.getSystemService("notification");
        if (systemService == null) {
            throw new NullPointerException("null cannot be cast to non-null type android.app.NotificationManager");
        }
        NotificationChannel notificationChannel = new NotificationChannel(CHANNEL_ID, "Media playback", 2);
        notificationChannel.setDescription("Media playback controls");
        notificationChannel.setShowBadge(false);
        notificationChannel.setLockscreenVisibility(1);
        ((NotificationManager) systemService).createNotificationChannel(notificationChannel);
    }

    public final void cancelNotification() {
        FMLog.d$default(this.log, "cancelling notification and quitting", null, 2, null);
        MediaControllerCompat mediaControllerCompat = this.mMediaController;
        if (mediaControllerCompat == null) {
            return;
        }
        Intrinsics.checkNotNull(mediaControllerCompat);
        mediaControllerCompat.unregisterCallback(this.callback);
        this.mMediaController = null;
        try {
            this.mPlayerService.unregisterReceiver(this);
            this.mNotificationManager.cancel(NOTIFICATION_ID);
        } catch (IllegalArgumentException unused) {
        }
        this.mPlayerService.stopForeground(true);
    }

    public final void setNotificationIcons(NotificationStyle ni) {
        Intrinsics.checkNotNullParameter(ni, "ni");
        this.mNotificationStyle = ni;
        updateNotification();
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    @Override // android.content.BroadcastReceiver
    public void onReceive(Context context, Intent intent) throws JSONException {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(intent, "intent");
        String action = intent.getAction();
        if (action != null) {
            FMLog.d$default(this.log, Intrinsics.stringPlus("Received intent with action ", action), null, 2, null);
            switch (action.hashCode()) {
                case -1343067672:
                    if (action.equals(ACTION_DISLIKE)) {
                        if (this.mAudioPlayer.getCurrentPlay() != null) {
                            Play currentPlay = this.mAudioPlayer.getCurrentPlay();
                            Intrinsics.checkNotNull(currentPlay);
                            if (currentPlay.getAudioFile().getIsDisliked()) {
                                this.mAudioPlayer.unlike();
                                return;
                            } else {
                                this.mAudioPlayer.dislike();
                                return;
                            }
                        }
                        return;
                    }
                    break;
                case -715034188:
                    if (action.equals(ACTION_LIKE)) {
                        if (this.mAudioPlayer.getCurrentPlay() != null) {
                            Play currentPlay2 = this.mAudioPlayer.getCurrentPlay();
                            Intrinsics.checkNotNull(currentPlay2);
                            if (currentPlay2.getAudioFile().getIsLiked()) {
                                this.mAudioPlayer.unlike();
                                return;
                            } else {
                                this.mAudioPlayer.like();
                                return;
                            }
                        }
                        return;
                    }
                    break;
                case -714978032:
                    if (action.equals(ACTION_NEXT)) {
                        this.mAudioPlayer.skip();
                        return;
                    }
                    break;
                case -714912431:
                    if (action.equals(ACTION_PLAY)) {
                        this.mAudioPlayer.play();
                        return;
                    }
                    break;
                case -687757447:
                    if (action.equals(ACTION_PAUSE)) {
                        this.mAudioPlayer.pause();
                        return;
                    }
                    break;
                case -218047145:
                    if (action.equals(ACTION_CANCEL)) {
                        FeedPlayerService.INSTANCE.stopService$PlayerSdk_exoDefaultRelease();
                        return;
                    }
                    break;
            }
            FMLog.w$default(this.log, Intrinsics.stringPlus("Unknown intent ignored. Action=", action), null, 2, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateNotification() {
        Notification notificationCreateNotification;
        if (this.mMediaController == null || (notificationCreateNotification = createNotification()) == null) {
            return;
        }
        FMLog.d$default(this.log, Intrinsics.stringPlus("Updating notification ", notificationCreateNotification), null, 2, null);
        boolean z = (notificationCreateNotification.flags & 2) != 0;
        if (z && !this.mForeground) {
            FMLog.d$default(this.log, "mPlayerService.startForeground", null, 2, null);
            this.mPlayerService.startForeground(NOTIFICATION_ID, notificationCreateNotification);
            this.mForeground = true;
        } else {
            if (!z && this.mForeground) {
                FMLog.d$default(this.log, "mPlayerService.stopForeground(true)", null, 2, null);
                this.mPlayerService.stopForeground(false);
                this.mNotificationManager.notify(NOTIFICATION_ID, notificationCreateNotification);
                this.mForeground = false;
                return;
            }
            FMLog.d$default(this.log, "no change in fore/background", null, 2, null);
            try {
                this.mNotificationManager.notify(NOTIFICATION_ID, notificationCreateNotification);
            } catch (RuntimeException e) {
                FMLog.e$default(this.log, Intrinsics.stringPlus("Ignoring runtime exception while setting notification. Probably the 'bad array lengths' error.", e.getStackTrace()), null, 2, null);
            }
        }
    }

    private final Notification createNotification() {
        ButtonState buttonState;
        String str;
        String str2;
        String str3;
        boolean z;
        Bitmap bitmap;
        CharSequence charSequence;
        int i;
        ButtonState buttonState2;
        boolean z2;
        ButtonState buttonState3;
        int i2;
        Notification notification;
        ButtonState buttonState4;
        MediaControllerCompat mediaControllerCompat = this.mMediaController;
        if (mediaControllerCompat == null) {
            FMLog.e$default(this.log, "no media controller - unable to create notification", null, 2, null);
            return null;
        }
        Intrinsics.checkNotNull(mediaControllerCompat);
        MediaMetadataCompat metadata = mediaControllerCompat.getMetadata();
        MediaControllerCompat mediaControllerCompat2 = this.mMediaController;
        Intrinsics.checkNotNull(mediaControllerCompat2);
        PlaybackStateCompat playbackState = mediaControllerCompat2.getPlaybackState();
        if (metadata == null) {
            metadata = MediaMetadataCompat.fromMediaMetadata(createMediaMetaData());
        }
        MediaMetadataCompat mediaMetadataCompat = metadata;
        if (playbackState == null) {
            FMLog.e$default(this.log, "playback state is null - unable to create notification", null, 2, null);
            return null;
        }
        FMLog fMLog = this.log;
        Intrinsics.checkNotNull(mediaMetadataCompat);
        FMLog.d$default(fMLog, Intrinsics.stringPlus("Setting updating notification from ", mediaMetadataCompat), null, 2, null);
        ButtonState buttonState5 = ButtonState.DISABLED;
        NotificationStyle notificationStyle = this.mNotificationStyle;
        Intrinsics.checkNotNull(notificationStyle);
        if (notificationStyle.getThumbsDownIcon() != -1) {
            RatingCompat rating = mediaMetadataCompat.getRating(MediaMetadataCompat.METADATA_KEY_RATING);
            if (rating != null && !rating.isThumbUp()) {
                buttonState5 = ButtonState.SELECTED;
            } else {
                buttonState5 = ButtonState.NORMAL;
            }
        }
        ButtonState buttonState6 = buttonState5;
        ButtonState buttonState7 = ButtonState.DISABLED;
        NotificationStyle notificationStyle2 = this.mNotificationStyle;
        Intrinsics.checkNotNull(notificationStyle2);
        if (notificationStyle2.getThumbsUpIcon() != -1) {
            RatingCompat rating2 = mediaMetadataCompat.getRating(MediaMetadataCompat.METADATA_KEY_RATING);
            if (rating2 != null && rating2.isThumbUp()) {
                buttonState7 = ButtonState.SELECTED;
            } else {
                buttonState7 = ButtonState.NORMAL;
            }
        }
        ButtonState buttonState8 = buttonState7;
        if (playbackState.getState() == 3 || playbackState.getState() == 6) {
            buttonState = ButtonState.SELECTED;
        } else {
            buttonState = ButtonState.NORMAL;
        }
        ButtonState buttonState9 = buttonState;
        int state = playbackState.getState();
        boolean z3 = state == 3 || state == 10 || state == 6;
        ButtonState buttonState10 = ButtonState.DISABLED;
        if ((playbackState.getActions() & 32) != 0) {
            buttonState10 = ButtonState.NORMAL;
        }
        ButtonState buttonState11 = buttonState10;
        FMLog.d$default(this.log, "Button states are: " + buttonState6 + ", " + buttonState8 + ", " + buttonState9 + ", " + buttonState11, null, 2, null);
        CharSequence title = mediaMetadataCompat.getText(MediaMetadataCompat.METADATA_KEY_TITLE);
        CharSequence artist = mediaMetadataCompat.getText(MediaMetadataCompat.METADATA_KEY_ARTIST);
        CharSequence album = mediaMetadataCompat.getText(MediaMetadataCompat.METADATA_KEY_ALBUM);
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this.mPlayerService, "");
        boolean z4 = z3;
        int[] iArrAddActions = addActions(builder, buttonState6, buttonState8, buttonState9, buttonState11);
        NotificationCompat.MediaStyle cancelButtonIntent = new NotificationCompat.MediaStyle().setShowActionsInCompactView(Arrays.copyOf(iArrAddActions, iArrAddActions.length)).setShowCancelButton(!z4).setCancelButtonIntent(this.mCancelIntent);
        MediaControllerCompat mediaControllerCompat3 = this.mMediaController;
        Intrinsics.checkNotNull(mediaControllerCompat3);
        NotificationCompat.Builder style = builder.setStyle(cancelButtonIntent.setMediaSession(mediaControllerCompat3.getSessionToken()));
        NotificationStyle notificationStyle3 = this.mNotificationStyle;
        Intrinsics.checkNotNull(notificationStyle3);
        NotificationCompat.Builder subText = style.setSmallIcon(notificationStyle3.getSmallIcon()).setVisibility(1).setUsesChronometer(false).setContentTitle(title).setContentText(artist).setChannelId(CHANNEL_ID).setSubText(album);
        NotificationStyle notificationStyle4 = this.mNotificationStyle;
        Intrinsics.checkNotNull(notificationStyle4);
        subText.setColor(notificationStyle4.getColor()).setWhen(0L).setShowWhen(false).setOngoing(z4);
        PendingIntent pendingIntent = this.mContentIntent;
        if (pendingIntent != null) {
            builder.setContentIntent(pendingIntent);
        }
        Bitmap bitmap2 = mediaMetadataCompat.getBitmap(MediaMetadataCompat.METADATA_KEY_ART);
        if (bitmap2 != null) {
            builder.setLargeIcon(bitmap2);
        }
        Notification notificationBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(notificationBuild, "notificationBuilder.build()");
        NotificationStyle notificationStyle5 = this.mNotificationStyle;
        if (notificationStyle5 != null && notificationStyle5.hasBigContentView()) {
            FMLog.d$default(this.log, "adding big content view", null, 2, null);
            NotificationStyle notificationStyle6 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle6);
            RemoteViews bigContentView = notificationStyle6.getBigContentView();
            Intrinsics.checkNotNullExpressionValue(title, "title");
            Intrinsics.checkNotNullExpressionValue(artist, "artist");
            Intrinsics.checkNotNullExpressionValue(album, "album");
            str = "title";
            str2 = "artist";
            str3 = "album";
            z = false;
            bitmap = bitmap2;
            charSequence = artist;
            i = state;
            buttonState2 = buttonState9;
            z2 = true;
            buttonState3 = buttonState6;
            i2 = 6;
            notification = notificationBuild;
            buttonState4 = buttonState8;
            wireUpRemoteViews(bigContentView, title, artist, album, bitmap2, buttonState6, buttonState8, buttonState9, buttonState11, state == 6, true);
        } else {
            str = "title";
            str2 = "artist";
            z = false;
            str3 = "album";
            bitmap = bitmap2;
            charSequence = artist;
            notification = notificationBuild;
            buttonState3 = buttonState6;
            i = state;
            buttonState2 = buttonState9;
            i2 = 6;
            z2 = true;
            buttonState4 = buttonState8;
        }
        NotificationStyle notificationStyle7 = this.mNotificationStyle;
        Intrinsics.checkNotNull(notificationStyle7);
        if (notificationStyle7.hasContentView()) {
            FMLog.d$default(this.log, "adding normal content view", null, 2, null);
            NotificationStyle notificationStyle8 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle8);
            RemoteViews contentView = notificationStyle8.getContentView();
            Intrinsics.checkNotNullExpressionValue(title, str);
            CharSequence charSequence2 = charSequence;
            Intrinsics.checkNotNullExpressionValue(charSequence2, str2);
            Intrinsics.checkNotNullExpressionValue(album, str3);
            wireUpRemoteViews(contentView, title, charSequence2, album, bitmap, buttonState3, buttonState4, buttonState2, buttonState11, i == i2 ? z2 : z, false);
        }
        return notification;
    }

    private final int[] addActions(NotificationCompat.Builder notificationBuilder, ButtonState thumbsDownState, ButtonState thumbsUpState, ButtonState playPauseState, ButtonState skipState) {
        int i;
        int pauseIcon;
        PendingIntent pendingIntent;
        String str;
        int thumbsUpSelectedIcon;
        int thumbsDownSelectedIcon;
        if (thumbsDownState != ButtonState.DISABLED) {
            if (thumbsDownState == ButtonState.NORMAL) {
                NotificationStyle notificationStyle = this.mNotificationStyle;
                Intrinsics.checkNotNull(notificationStyle);
                thumbsDownSelectedIcon = notificationStyle.getThumbsDownIcon();
            } else {
                NotificationStyle notificationStyle2 = this.mNotificationStyle;
                Intrinsics.checkNotNull(notificationStyle2);
                thumbsDownSelectedIcon = notificationStyle2.getThumbsDownSelectedIcon();
            }
            notificationBuilder.addAction(new NotificationCompat.Action(thumbsDownSelectedIcon, "Dislike", this.mDislikeIntent));
            i = 1;
        } else {
            i = 0;
        }
        if (thumbsUpState != ButtonState.DISABLED) {
            if (thumbsUpState == ButtonState.NORMAL) {
                NotificationStyle notificationStyle3 = this.mNotificationStyle;
                Intrinsics.checkNotNull(notificationStyle3);
                thumbsUpSelectedIcon = notificationStyle3.getThumbsUpIcon();
            } else {
                NotificationStyle notificationStyle4 = this.mNotificationStyle;
                Intrinsics.checkNotNull(notificationStyle4);
                thumbsUpSelectedIcon = notificationStyle4.getThumbsUpSelectedIcon();
            }
            notificationBuilder.addAction(new NotificationCompat.Action(thumbsUpSelectedIcon, "Like", this.mLikeIntent));
            i++;
        }
        if (playPauseState != ButtonState.DISABLED) {
            if (playPauseState == ButtonState.NORMAL) {
                NotificationStyle notificationStyle5 = this.mNotificationStyle;
                Intrinsics.checkNotNull(notificationStyle5);
                pauseIcon = notificationStyle5.getPlayIcon();
                pendingIntent = this.mPlayIntent;
                str = "Play";
            } else {
                NotificationStyle notificationStyle6 = this.mNotificationStyle;
                Intrinsics.checkNotNull(notificationStyle6);
                pauseIcon = notificationStyle6.getPauseIcon();
                pendingIntent = this.mPauseIntent;
                str = "Pause";
            }
            notificationBuilder.addAction(new NotificationCompat.Action(pauseIcon, str, pendingIntent));
        }
        if (skipState == ButtonState.NORMAL) {
            NotificationStyle notificationStyle7 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle7);
            notificationBuilder.addAction(notificationStyle7.getSkipIcon(), "Next", this.mNextIntent);
            return new int[]{i, i + 1};
        }
        return new int[]{i};
    }

    private final void wireUpRemoteViews(RemoteViews remoteViews, CharSequence title, CharSequence artist, CharSequence album, Bitmap bm, ButtonState thumbsDownState, ButtonState thumbsUpState, ButtonState playPauseState, ButtonState skipState, boolean buffering, boolean big) {
        NotificationStyle notificationStyle = this.mNotificationStyle;
        Intrinsics.checkNotNull(notificationStyle);
        if (notificationStyle.getTrackTextId() > -1) {
            NotificationStyle notificationStyle2 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle2);
            remoteViews.setTextViewText(notificationStyle2.getTrackTextId(), title);
        }
        NotificationStyle notificationStyle3 = this.mNotificationStyle;
        Intrinsics.checkNotNull(notificationStyle3);
        if (notificationStyle3.getArtistTextId() > -1) {
            NotificationStyle notificationStyle4 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle4);
            remoteViews.setTextViewText(notificationStyle4.getArtistTextId(), artist);
        }
        NotificationStyle notificationStyle5 = this.mNotificationStyle;
        Intrinsics.checkNotNull(notificationStyle5);
        if (notificationStyle5.getReleaseTextId() > -1) {
            NotificationStyle notificationStyle6 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle6);
            remoteViews.setTextViewText(notificationStyle6.getReleaseTextId(), album);
        }
        if (buffering) {
            NotificationStyle notificationStyle7 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle7);
            if (notificationStyle7.getProgressId() > -1) {
                NotificationStyle notificationStyle8 = this.mNotificationStyle;
                Intrinsics.checkNotNull(notificationStyle8);
                remoteViews.setViewVisibility(notificationStyle8.getProgressId(), 0);
                NotificationStyle notificationStyle9 = this.mNotificationStyle;
                Intrinsics.checkNotNull(notificationStyle9);
                if (notificationStyle9.getMediaImageId() > -1) {
                    NotificationStyle notificationStyle10 = this.mNotificationStyle;
                    Intrinsics.checkNotNull(notificationStyle10);
                    remoteViews.setViewVisibility(notificationStyle10.getMediaImageId(), 8);
                }
            } else {
                NotificationStyle notificationStyle11 = this.mNotificationStyle;
                Intrinsics.checkNotNull(notificationStyle11);
                if (notificationStyle11.getMediaImageId() > -1) {
                    NotificationStyle notificationStyle12 = this.mNotificationStyle;
                    Intrinsics.checkNotNull(notificationStyle12);
                    remoteViews.setViewVisibility(notificationStyle12.getMediaImageId(), 0);
                    NotificationStyle notificationStyle13 = this.mNotificationStyle;
                    Intrinsics.checkNotNull(notificationStyle13);
                    remoteViews.setImageViewBitmap(notificationStyle13.getMediaImageId(), bm);
                }
            }
        } else {
            NotificationStyle notificationStyle14 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle14);
            if (notificationStyle14.getMediaImageId() > -1) {
                NotificationStyle notificationStyle15 = this.mNotificationStyle;
                Intrinsics.checkNotNull(notificationStyle15);
                remoteViews.setViewVisibility(notificationStyle15.getMediaImageId(), 0);
                NotificationStyle notificationStyle16 = this.mNotificationStyle;
                Intrinsics.checkNotNull(notificationStyle16);
                remoteViews.setImageViewBitmap(notificationStyle16.getMediaImageId(), bm);
                NotificationStyle notificationStyle17 = this.mNotificationStyle;
                Intrinsics.checkNotNull(notificationStyle17);
                if (notificationStyle17.getProgressId() > -1) {
                    NotificationStyle notificationStyle18 = this.mNotificationStyle;
                    Intrinsics.checkNotNull(notificationStyle18);
                    remoteViews.setViewVisibility(notificationStyle18.getProgressId(), 8);
                }
            }
        }
        int i = WhenMappings.$EnumSwitchMapping$0[thumbsDownState.ordinal()];
        if (i == 1) {
            NotificationStyle notificationStyle19 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle19);
            remoteViews.setViewVisibility(notificationStyle19.getDislikeButtonId(), 4);
        } else if (i == 2) {
            NotificationStyle notificationStyle20 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle20);
            int dislikeButtonId = notificationStyle20.getDislikeButtonId();
            NotificationStyle notificationStyle21 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle21);
            remoteViews.setImageViewResource(dislikeButtonId, notificationStyle21.getThumbsDownIcon());
            NotificationStyle notificationStyle22 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle22);
            remoteViews.setOnClickPendingIntent(notificationStyle22.getDislikeButtonId(), this.mDislikeIntent);
            NotificationStyle notificationStyle23 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle23);
            remoteViews.setViewVisibility(notificationStyle23.getDislikeButtonId(), 0);
        } else {
            NotificationStyle notificationStyle24 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle24);
            int dislikeButtonId2 = notificationStyle24.getDislikeButtonId();
            NotificationStyle notificationStyle25 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle25);
            remoteViews.setImageViewResource(dislikeButtonId2, notificationStyle25.getThumbsDownSelectedIcon());
            NotificationStyle notificationStyle26 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle26);
            remoteViews.setOnClickPendingIntent(notificationStyle26.getDislikeButtonId(), this.mDislikeIntent);
            NotificationStyle notificationStyle27 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle27);
            remoteViews.setViewVisibility(notificationStyle27.getDislikeButtonId(), 0);
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[thumbsUpState.ordinal()];
        if (i2 == 1) {
            NotificationStyle notificationStyle28 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle28);
            remoteViews.setViewVisibility(notificationStyle28.getLikeButtonId(), 4);
        } else if (i2 == 2) {
            NotificationStyle notificationStyle29 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle29);
            int likeButtonId = notificationStyle29.getLikeButtonId();
            NotificationStyle notificationStyle30 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle30);
            remoteViews.setImageViewResource(likeButtonId, notificationStyle30.getThumbsUpIcon());
            NotificationStyle notificationStyle31 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle31);
            remoteViews.setOnClickPendingIntent(notificationStyle31.getLikeButtonId(), this.mLikeIntent);
            NotificationStyle notificationStyle32 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle32);
            remoteViews.setViewVisibility(notificationStyle32.getLikeButtonId(), 0);
        } else {
            NotificationStyle notificationStyle33 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle33);
            int likeButtonId2 = notificationStyle33.getLikeButtonId();
            NotificationStyle notificationStyle34 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle34);
            remoteViews.setImageViewResource(likeButtonId2, notificationStyle34.getThumbsUpSelectedIcon());
            NotificationStyle notificationStyle35 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle35);
            remoteViews.setOnClickPendingIntent(notificationStyle35.getLikeButtonId(), this.mLikeIntent);
            NotificationStyle notificationStyle36 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle36);
            remoteViews.setViewVisibility(notificationStyle36.getLikeButtonId(), 0);
        }
        if (playPauseState == ButtonState.NORMAL) {
            NotificationStyle notificationStyle37 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle37);
            int playPauseButtonId = notificationStyle37.getPlayPauseButtonId();
            NotificationStyle notificationStyle38 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle38);
            remoteViews.setImageViewResource(playPauseButtonId, notificationStyle38.getPlayIcon());
            NotificationStyle notificationStyle39 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle39);
            remoteViews.setOnClickPendingIntent(notificationStyle39.getPlayPauseButtonId(), this.mPlayIntent);
        } else {
            NotificationStyle notificationStyle40 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle40);
            int playPauseButtonId2 = notificationStyle40.getPlayPauseButtonId();
            NotificationStyle notificationStyle41 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle41);
            remoteViews.setImageViewResource(playPauseButtonId2, notificationStyle41.getPauseIcon());
            NotificationStyle notificationStyle42 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle42);
            remoteViews.setOnClickPendingIntent(notificationStyle42.getPlayPauseButtonId(), this.mPauseIntent);
        }
        if (skipState == ButtonState.NORMAL) {
            NotificationStyle notificationStyle43 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle43);
            int skipButtonId = notificationStyle43.getSkipButtonId();
            NotificationStyle notificationStyle44 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle44);
            remoteViews.setImageViewResource(skipButtonId, notificationStyle44.getSkipIcon());
            NotificationStyle notificationStyle45 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle45);
            remoteViews.setOnClickPendingIntent(notificationStyle45.getSkipButtonId(), this.mNextIntent);
            NotificationStyle notificationStyle46 = this.mNotificationStyle;
            Intrinsics.checkNotNull(notificationStyle46);
            remoteViews.setViewVisibility(notificationStyle46.getSkipButtonId(), 0);
            return;
        }
        NotificationStyle notificationStyle47 = this.mNotificationStyle;
        Intrinsics.checkNotNull(notificationStyle47);
        remoteViews.setViewVisibility(notificationStyle47.getSkipButtonId(), 4);
    }
}
