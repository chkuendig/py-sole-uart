package fm.feed.android.playersdk.models;

import android.R;
import android.widget.RemoteViews;
import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: NotificationStyle.kt */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b.\n\u0002\u0010\u000b\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010)\u001a\u00020\u0004J\u0006\u0010*\u001a\u00020\u0004J\u0006\u0010+\u001a\u00020\u0004J\u0006\u0010,\u001a\u00020\u0004J\u0006\u0010-\u001a\u00020\u0004J\u0006\u0010.\u001a\u00020\u0004J\u0006\u0010/\u001a\u00020\u0004J\u0006\u00100\u001a\u00020\u0004J\u0006\u00101\u001a\u00020\u0004J\u0006\u00102\u001a\u00020\u0004J\u0006\u00103\u001a\u00020\u0004J\u0006\u00104\u001a\u00020\u0004J\u0006\u00105\u001a\u00020\u0004J\u0006\u00106\u001a\u00020\u0004J\u0006\u00107\u001a\u00020\u0004J\u0006\u00108\u001a\u00020\u0004J\u0006\u00109\u001a\u00020:J\u0006\u0010;\u001a\u00020:J\u000e\u0010<\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u0004J\u0016\u0010=\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010\t\u001a\u00020\u0004J\u000e\u0010?\u001a\u00020\u00002\u0006\u0010\f\u001a\u00020\u0004J\u000e\u0010@\u001a\u00020\u00002\u0006\u0010\r\u001a\u00020\u0004J\u000e\u0010A\u001a\u00020\u00002\u0006\u0010\u000e\u001a\u00020\u0004J\u0016\u0010B\u001a\u00020\u00002\u0006\u0010>\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010C\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0004J\u000e\u0010D\u001a\u00020\u00002\u0006\u0010\u0014\u001a\u00020\u0004J\u000e\u0010E\u001a\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u0004J\u000e\u0010F\u001a\u00020\u00002\u0006\u0010\u0016\u001a\u00020\u0004J\u000e\u0010G\u001a\u00020\u00002\u0006\u0010\u0017\u001a\u00020\u0004J\u000e\u0010H\u001a\u00020\u00002\u0006\u0010\u0018\u001a\u00020\u0004J\u000e\u0010I\u001a\u00020\u00002\u0006\u0010\u0019\u001a\u00020\u0004J\u000e\u0010J\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u0004J\u000e\u0010K\u001a\u00020\u00002\u0006\u0010\u001b\u001a\u00020\u0004J\u000e\u0010L\u001a\u00020\u00002\u0006\u0010\u001c\u001a\u00020\u0004J\u000e\u0010M\u001a\u00020\u00002\u0006\u0010\u001d\u001a\u00020\u0004J\u0016\u0010N\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u0004J\u0016\u0010O\u001a\u00020\u00002\u0006\u0010$\u001a\u00020\u00042\u0006\u0010&\u001a\u00020\u0004J\u000e\u0010P\u001a\u00020\u00002\u0006\u0010(\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\bR\u000e\u0010\u0011\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u001f\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b \u0010!R\u001e\u0010\"\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b#\u0010!R\u001e\u0010$\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b%\u0010!R\u001e\u0010&\u001a\u00020\u00042\u0006\u0010\u001e\u001a\u00020\u0004@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b'\u0010!R\u000e\u0010(\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Q"}, d2 = {"Lfm/feed/android/playersdk/models/NotificationStyle;", "", "()V", "artistTextId", "", "bigContentView", "Landroid/widget/RemoteViews;", "getBigContentView", "()Landroid/widget/RemoteViews;", "bigContentViewId", "bigContentViewPackageName", "", "cancelButtonId", "cancelIcon", "color", "contentView", "getContentView", "contentViewId", "contentViewPackageName", "dislikeButtonId", "likeButtonId", "mediaImageId", "pauseIcon", "playIcon", "playPauseButtonId", "progressId", "releaseTextId", "skipButtonId", "skipIcon", "smallIcon", "<set-?>", "thumbsDownIcon", "getThumbsDownIcon", "()I", "thumbsDownSelectedIcon", "getThumbsDownSelectedIcon", "thumbsUpIcon", "getThumbsUpIcon", "thumbsUpSelectedIcon", "getThumbsUpSelectedIcon", "trackTextId", "getArtistTextId", "getCancelButtonId", "getCancelIcon", "getColor", "getDislikeButtonId", "getLikeButtonId", "getMediaImageId", "getPauseIcon", "getPlayIcon", "getPlayPauseButtonId", "getProgressId", "getReleaseTextId", "getSkipButtonId", "getSkipIcon", "getSmallIcon", "getTrackTextId", "hasBigContentView", "", "hasContentView", "setArtistTextId", "setBigContentView", "packageName", "setCancelButtonId", "setCancelIcon", "setColor", SdkConstants.SET_CONTENT_VIEW_METHOD, "setDislikeButtonId", "setLikeButtonId", "setMediaImageId", "setPauseIcon", "setPlayIcon", "setPlayPauseButtonId", "setProgressId", "setReleaseTextId", "setSkipButtonId", "setSkipIcon", "setSmallIcon", "setThumbsDownIcons", "setThumbsUpIcons", "setTrackTextId", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class NotificationStyle {
    private String bigContentViewPackageName;
    private String contentViewPackageName;
    private int smallIcon = R.drawable.ic_media_play;
    private int pauseIcon = R.drawable.ic_media_pause;
    private int playIcon = R.drawable.ic_media_play;
    private int skipIcon = R.drawable.ic_media_next;
    private int cancelIcon = R.drawable.ic_menu_close_clear_cancel;
    private int thumbsUpIcon = -1;
    private int thumbsUpSelectedIcon = -1;
    private int thumbsDownIcon = -1;
    private int thumbsDownSelectedIcon = -1;
    private int color = -16777216;
    private int bigContentViewId = -1;
    private int contentViewId = -1;
    private int dislikeButtonId = -1;
    private int likeButtonId = -1;
    private int playPauseButtonId = -1;
    private int skipButtonId = -1;
    private int mediaImageId = -1;
    private int progressId = -1;
    private int cancelButtonId = -1;
    private int trackTextId = -1;
    private int artistTextId = -1;
    private int releaseTextId = -1;

    public final int getThumbsUpIcon() {
        return this.thumbsUpIcon;
    }

    public final int getThumbsUpSelectedIcon() {
        return this.thumbsUpSelectedIcon;
    }

    public final int getThumbsDownIcon() {
        return this.thumbsDownIcon;
    }

    public final int getThumbsDownSelectedIcon() {
        return this.thumbsDownSelectedIcon;
    }

    public final RemoteViews getBigContentView() {
        return new RemoteViews(this.bigContentViewPackageName, this.bigContentViewId);
    }

    public final RemoteViews getContentView() {
        return new RemoteViews(this.contentViewPackageName, this.contentViewId);
    }

    public final int getSmallIcon() {
        return this.smallIcon;
    }

    public final NotificationStyle setSmallIcon(int smallIcon) {
        this.smallIcon = smallIcon;
        return this;
    }

    public final int getPauseIcon() {
        return this.pauseIcon;
    }

    public final NotificationStyle setPauseIcon(int pauseIcon) {
        this.pauseIcon = pauseIcon;
        return this;
    }

    public final int getPlayIcon() {
        return this.playIcon;
    }

    public final NotificationStyle setPlayIcon(int playIcon) {
        this.playIcon = playIcon;
        return this;
    }

    public final int getSkipIcon() {
        return this.skipIcon;
    }

    public final NotificationStyle setSkipIcon(int skipIcon) {
        this.skipIcon = skipIcon;
        return this;
    }

    public final int getCancelIcon() {
        return this.cancelIcon;
    }

    public final NotificationStyle setCancelIcon(int cancelIcon) {
        this.cancelIcon = cancelIcon;
        return this;
    }

    public final int getColor() {
        return this.color;
    }

    public final NotificationStyle setColor(int color) {
        this.color = color;
        return this;
    }

    public final NotificationStyle setThumbsUpIcons(int thumbsUpIcon, int thumbsUpSelectedIcon) {
        this.thumbsUpIcon = thumbsUpIcon;
        this.thumbsUpSelectedIcon = thumbsUpSelectedIcon;
        return this;
    }

    public final NotificationStyle setThumbsDownIcons(int thumbsDownIcon, int thumbsDownSelectedIcon) {
        this.thumbsDownIcon = thumbsDownIcon;
        this.thumbsDownSelectedIcon = thumbsDownSelectedIcon;
        return this;
    }

    public final NotificationStyle setBigContentView(String packageName, int bigContentViewId) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.bigContentViewPackageName = packageName;
        this.bigContentViewId = bigContentViewId;
        return this;
    }

    public final boolean hasBigContentView() {
        return (this.bigContentViewPackageName == null || this.bigContentViewId == -1) ? false : true;
    }

    public final NotificationStyle setContentView(String packageName, int contentViewId) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        this.contentViewPackageName = packageName;
        this.contentViewId = contentViewId;
        return this;
    }

    public final boolean hasContentView() {
        return (this.contentViewPackageName == null || this.contentViewId == -1) ? false : true;
    }

    public final int getDislikeButtonId() {
        return this.dislikeButtonId;
    }

    public final NotificationStyle setDislikeButtonId(int dislikeButtonId) {
        this.dislikeButtonId = dislikeButtonId;
        return this;
    }

    public final int getLikeButtonId() {
        return this.likeButtonId;
    }

    public final NotificationStyle setLikeButtonId(int likeButtonId) {
        this.likeButtonId = likeButtonId;
        return this;
    }

    public final int getPlayPauseButtonId() {
        return this.playPauseButtonId;
    }

    public final NotificationStyle setPlayPauseButtonId(int playPauseButtonId) {
        this.playPauseButtonId = playPauseButtonId;
        return this;
    }

    public final int getSkipButtonId() {
        return this.skipButtonId;
    }

    public final NotificationStyle setSkipButtonId(int skipButtonId) {
        this.skipButtonId = skipButtonId;
        return this;
    }

    public final int getTrackTextId() {
        return this.trackTextId;
    }

    public final NotificationStyle setTrackTextId(int trackTextId) {
        this.trackTextId = trackTextId;
        return this;
    }

    public final int getArtistTextId() {
        return this.artistTextId;
    }

    public final NotificationStyle setArtistTextId(int artistTextId) {
        this.artistTextId = artistTextId;
        return this;
    }

    public final int getReleaseTextId() {
        return this.releaseTextId;
    }

    public final NotificationStyle setReleaseTextId(int releaseTextId) {
        this.releaseTextId = releaseTextId;
        return this;
    }

    public final int getMediaImageId() {
        return this.mediaImageId;
    }

    public final NotificationStyle setMediaImageId(int mediaImageId) {
        this.mediaImageId = mediaImageId;
        return this;
    }

    public final int getProgressId() {
        return this.progressId;
    }

    public final NotificationStyle setProgressId(int progressId) {
        this.progressId = progressId;
        return this;
    }

    public final int getCancelButtonId() {
        return this.cancelButtonId;
    }

    public final NotificationStyle setCancelButtonId(int cancelButtonId) {
        this.cancelButtonId = cancelButtonId;
        return this;
    }
}
