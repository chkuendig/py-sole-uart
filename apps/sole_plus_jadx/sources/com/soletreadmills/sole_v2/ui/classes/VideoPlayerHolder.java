package com.soletreadmills.sole_v2.ui.classes;

import android.content.Context;
import androidx.media3.common.MediaItem;
import androidx.media3.datasource.okhttp.OkHttpDataSource;
import androidx.media3.exoplayer.ExoPlayer;
import androidx.media3.exoplayer.hls.HlsMediaSource;
import com.android.SdkConstants;
import com.google.common.net.HttpHeaders;
import java.net.HttpCookie;
import java.util.List;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.OkHttpClient;
import org.objectweb.asm.signature.SignatureVisitor;

/* compiled from: VideoPlayerView.kt */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0006J\b\u0010\u000e\u001a\u0004\u0018\u00010\nJ\u000e\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0003\u001a\u00020\u0004J\u0018\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\r\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0013\u001a\u00020\fR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/classes/VideoPlayerHolder;", "", "()V", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "controller", "Lcom/soletreadmills/sole_v2/ui/classes/VideoPlayerController;", "currentMediaItemUrl", "", "exoPlayer", "Landroidx/media3/exoplayer/ExoPlayer;", "attachController", "", "attachedController", "get", "initialize", "prepare", "data", "Lcom/soletreadmills/sole_v2/ui/classes/CookieData;", "release", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VideoPlayerHolder {
    private static Context context;
    private static VideoPlayerController controller;
    private static String currentMediaItemUrl;
    private static ExoPlayer exoPlayer;
    public static final VideoPlayerHolder INSTANCE = new VideoPlayerHolder();
    public static final int $stable = 8;

    private VideoPlayerHolder() {
    }

    public final void initialize(Context context2) {
        Intrinsics.checkNotNullParameter(context2, "context");
        if (exoPlayer == null) {
            context = context2.getApplicationContext();
        }
    }

    public final void prepare(CookieData data, VideoPlayerController attachedController) {
        String strJoinToString$default;
        Intrinsics.checkNotNullParameter(data, "data");
        if (context == null || data.getVideoUrl().length() == 0) {
            return;
        }
        if (exoPlayer != null && Intrinsics.areEqual(currentMediaItemUrl, data.getVideoUrl())) {
            controller = attachedController;
            if (attachedController != null) {
                ExoPlayer exoPlayer2 = exoPlayer;
                Intrinsics.checkNotNull(exoPlayer2);
                attachedController.attachPlayer$app_release(exoPlayer2);
                return;
            }
            return;
        }
        ExoPlayer exoPlayer3 = exoPlayer;
        if (exoPlayer3 != null) {
            exoPlayer3.release();
        }
        List<HttpCookie> cookies = data.getCookies();
        if (cookies == null || (strJoinToString$default = CollectionsKt.joinToString$default(cookies, "; ", null, null, 0, null, new Function1<HttpCookie, CharSequence>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoPlayerHolder$prepare$cookieHeader$1
            @Override // kotlin.jvm.functions.Function1
            public final CharSequence invoke(HttpCookie it) {
                Intrinsics.checkNotNullParameter(it, "it");
                return it.getName() + SignatureVisitor.INSTANCEOF + it.getValue();
            }
        }, 30, null)) == null) {
            strJoinToString$default = "";
        }
        OkHttpDataSource.Factory defaultRequestProperties = new OkHttpDataSource.Factory(new OkHttpClient.Builder().build()).setDefaultRequestProperties(MapsKt.mapOf(TuplesKt.to(HttpHeaders.COOKIE, strJoinToString$default)));
        Intrinsics.checkNotNullExpressionValue(defaultRequestProperties, "setDefaultRequestProperties(...)");
        MediaItem mediaItemFromUri = MediaItem.fromUri(data.getVideoUrl());
        Intrinsics.checkNotNullExpressionValue(mediaItemFromUri, "fromUri(...)");
        HlsMediaSource hlsMediaSourceCreateMediaSource = new HlsMediaSource.Factory(defaultRequestProperties).createMediaSource(mediaItemFromUri);
        Intrinsics.checkNotNullExpressionValue(hlsMediaSourceCreateMediaSource, "createMediaSource(...)");
        Context context2 = context;
        Intrinsics.checkNotNull(context2);
        ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(context2).build();
        exoPlayerBuild.setMediaSource(hlsMediaSourceCreateMediaSource);
        exoPlayerBuild.setRepeatMode(data.getSetLoop() ? 1 : 0);
        exoPlayerBuild.setPlayWhenReady(true);
        exoPlayerBuild.prepare();
        exoPlayer = exoPlayerBuild;
        currentMediaItemUrl = data.getVideoUrl();
        controller = attachedController;
        if (attachedController != null) {
            ExoPlayer exoPlayer4 = exoPlayer;
            Intrinsics.checkNotNull(exoPlayer4);
            attachedController.attachPlayer$app_release(exoPlayer4);
        }
    }

    public final ExoPlayer get() {
        return exoPlayer;
    }

    public final void attachController(VideoPlayerController attachedController) {
        Intrinsics.checkNotNullParameter(attachedController, "attachedController");
        controller = attachedController;
        ExoPlayer exoPlayer2 = exoPlayer;
        if (exoPlayer2 == null || attachedController == null) {
            return;
        }
        attachedController.attachPlayer$app_release(exoPlayer2);
    }

    public final void release() {
        ExoPlayer exoPlayer2 = exoPlayer;
        if (exoPlayer2 != null) {
            exoPlayer2.release();
        }
        exoPlayer = null;
        currentMediaItemUrl = null;
        controller = null;
        context = null;
    }
}
