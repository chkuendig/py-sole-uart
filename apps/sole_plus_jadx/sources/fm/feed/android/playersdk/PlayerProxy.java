package fm.feed.android.playersdk;

import android.content.Context;
import android.net.Uri;
import android.os.Looper;
import android.util.Log;
import androidx.exifinterface.media.ExifInterface;
import com.android.SdkConstants;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.PlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.database.StandaloneDatabaseProvider;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.DefaultDataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.upstream.cache.Cache;
import com.google.android.exoplayer2.upstream.cache.CacheDataSource;
import com.google.android.exoplayer2.upstream.cache.CacheKeyFactory;
import com.google.android.exoplayer2.upstream.cache.CacheWriter;
import com.google.android.exoplayer2.upstream.cache.LeastRecentlyUsedCacheEvictor;
import com.google.android.exoplayer2.upstream.cache.SimpleCache;
import com.google.android.exoplayer2.util.Util;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import fm.feed.android.playersdk.PlayerProxy;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* compiled from: PlayerProxy.kt */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0004\u0018\u0000 .2\u00020\u0001:\u0002./B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016J\u0010\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\u0015H\u0016J\u0018\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0010\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\u0019H\u0016J\u0010\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u0019H\u0016J\b\u0010\u001e\u001a\u00020\rH\u0016J\u0010\u0010\u001f\u001a\u00020\r2\u0006\u0010 \u001a\u00020\u000fH\u0016J\u0018\u0010!\u001a\u00020\r2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020%H\u0016J<\u0010&\u001a\u0004\u0018\u00010'\"\u0006\b\u0000\u0010(\u0018\u0001*\u0002H(2\u0006\u0010)\u001a\u00020*2\u0016\u0010+\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010'0,\"\u0004\u0018\u00010'H\u0086\b¢\u0006\u0002\u0010-R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u0011\u0010\t\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u00060"}, d2 = {"Lfm/feed/android/playersdk/PlayerProxy;", "Lcom/google/android/exoplayer2/Player$Listener;", "nListener", "Lfm/feed/android/playersdk/PlayerProxy$ExoEventListener;", "(Lfm/feed/android/playersdk/PlayerProxy$ExoEventListener;)V", "eventListener", "getEventListener", "()Lfm/feed/android/playersdk/PlayerProxy$ExoEventListener;", "setEventListener", "exoListener", "getExoListener", "()Lcom/google/android/exoplayer2/Player$Listener;", "onLoadingChanged", "", "isLoading", "", "onPlaybackParametersChanged", "playbackParameters", "Lcom/google/android/exoplayer2/PlaybackParameters;", "onPlayerError", "error", "Lcom/google/android/exoplayer2/PlaybackException;", "onPlayerStateChanged", "playWhenReady", "playbackState", "", "onPositionDiscontinuity", "reason", "onRepeatModeChanged", "repeatMode", "onSeekProcessed", "onShuffleModeEnabledChanged", "shuffleModeEnabled", "onTracksChanged", "trackGroups", "Lcom/google/android/exoplayer2/source/TrackGroupArray;", "trackSelections", "Lcom/google/android/exoplayer2/trackselection/TrackSelectionArray;", "callPrivateFunc", "", ExifInterface.GPS_DIRECTION_TRUE, "name", "", "args", "", "(Ljava/lang/Object;Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;", "Companion", "ExoEventListener", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class PlayerProxy implements Player.Listener {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int cacheSizeInBytes = 41943040;
    private static SimpleCache simpleCache;
    private ExoEventListener eventListener;

    /* compiled from: PlayerProxy.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&J\u0012\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\bH&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u00052\u0006\u0010\u000b\u001a\u00020\fH&J\b\u0010\r\u001a\u00020\u0003H&¨\u0006\u000e"}, d2 = {"Lfm/feed/android/playersdk/PlayerProxy$ExoEventListener;", "", "onLoadingChanged", "", "isLoading", "", "onPlayerError", "error", "Lcom/google/android/exoplayer2/ExoPlaybackException;", "onPlayerStateChanged", "playWhenReady", "playbackState", "", "onSeekProcessed", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public interface ExoEventListener {
        void onLoadingChanged(boolean isLoading);

        void onPlayerError(ExoPlaybackException error);

        void onPlayerStateChanged(boolean playWhenReady, int playbackState);

        void onSeekProcessed();
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
        Intrinsics.checkNotNullParameter(playbackParameters, "playbackParameters");
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPositionDiscontinuity(int reason) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onRepeatModeChanged(int repeatMode) {
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {
    }

    public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
        Intrinsics.checkNotNullParameter(trackGroups, "trackGroups");
        Intrinsics.checkNotNullParameter(trackSelections, "trackSelections");
    }

    public PlayerProxy(ExoEventListener exoEventListener) {
        this.eventListener = exoEventListener;
    }

    public final ExoEventListener getEventListener() {
        return this.eventListener;
    }

    public final void setEventListener(ExoEventListener exoEventListener) {
        this.eventListener = exoEventListener;
    }

    public final Player.Listener getExoListener() {
        return this;
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onLoadingChanged(boolean isLoading) {
        ExoEventListener exoEventListener = this.eventListener;
        Intrinsics.checkNotNull(exoEventListener);
        exoEventListener.onLoadingChanged(isLoading);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
        ExoEventListener exoEventListener = this.eventListener;
        Intrinsics.checkNotNull(exoEventListener);
        exoEventListener.onPlayerStateChanged(playWhenReady, playbackState);
    }

    @Override // com.google.android.exoplayer2.Player.Listener
    public void onPlayerError(PlaybackException error) {
        Intrinsics.checkNotNullParameter(error, "error");
        ExoEventListener exoEventListener = this.eventListener;
        Intrinsics.checkNotNull(exoEventListener);
        exoEventListener.onPlayerError((ExoPlaybackException) error);
    }

    public void onSeekProcessed() {
        ExoEventListener exoEventListener = this.eventListener;
        Intrinsics.checkNotNull(exoEventListener);
        exoEventListener.onSeekProcessed();
    }

    /* compiled from: PlayerProxy.kt */
    @Metadata(d1 = {"\u0000\u008a\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JK\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\n\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0000¢\u0006\u0002\b\u0019J'\u0010\u001a\u001a\u00020\u000f2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u001cH\u0000¢\u0006\u0002\b J\u0016\u0010!\u001a\u00020\"2\u0006\u0010\u0007\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020(J\u001f\u0010)\u001a\u00020\r2\u0006\u0010%\u001a\u00020&2\b\u0010*\u001a\u0004\u0018\u00010\u0018H\u0000¢\u0006\u0002\b+J \u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\"2\u0006\u0010/\u001a\u0002002\b\u0010\u001f\u001a\u0004\u0018\u00010\u001cJ\u0010\u00101\u001a\u00020\u001c2\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u000e\u00102\u001a\u0002032\u0006\u00104\u001a\u00020$J\u0016\u00105\u001a\u00020\u000b2\u0006\u00104\u001a\u00020$2\u0006\u00106\u001a\u00020-J\u0017\u00107\u001a\u00020\u000b2\b\u0010%\u001a\u0004\u0018\u00010&H\u0000¢\u0006\u0002\b8J\u0016\u00109\u001a\u00020\u000b2\u0006\u00104\u001a\u00020$2\u0006\u0010:\u001a\u000203R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\t¨\u0006;"}, d2 = {"Lfm/feed/android/playersdk/PlayerProxy$Companion;", "", "()V", "cacheSizeInBytes", "", "<set-?>", "Lcom/google/android/exoplayer2/upstream/cache/SimpleCache;", "simpleCache", "getSimpleCache", "()Lcom/google/android/exoplayer2/upstream/cache/SimpleCache;", SdkConstants.FD_CACHE, "", "dataSourceFactory", "Lcom/google/android/exoplayer2/upstream/DataSource$Factory;", "dataSpec", "Lcom/google/android/exoplayer2/upstream/DataSpec;", "Lcom/google/android/exoplayer2/upstream/cache/Cache;", "buffer", "", "enableEOFException", "", "atomicBoolean", "Ljava/util/concurrent/atomic/AtomicBoolean;", "cacheMediaListener", "Lfm/feed/android/playersdk/CacheMediaListener;", "cache$PlayerSdk_exoDefaultRelease", "createDataSpec", "url", "", "maxCache", "", "key", "createDataSpec$PlayerSdk_exoDefaultRelease", "createDateSourceFactory", "Lcom/google/android/exoplayer2/upstream/cache/CacheDataSource$Factory;", "createSimpleExoplayer", "Lcom/google/android/exoplayer2/ExoPlayer;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "looper", "Landroid/os/Looper;", "dataSourceFactoryCreator", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "dataSourceFactoryCreator$PlayerSdk_exoDefaultRelease", "getExtractorMediaSource", "Lcom/google/android/exoplayer2/source/MediaSource;", "cacheDataSourceFactory", "uri", "Landroid/net/Uri;", "getKey", "getVolume", "", "player", "prepare", "source", "setSimpleCache", "setSimpleCache$PlayerSdk_exoDefaultRelease", "setVolume", "volume", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SimpleCache getSimpleCache() {
            return PlayerProxy.simpleCache;
        }

        public final void setSimpleCache$PlayerSdk_exoDefaultRelease(Context context) {
            if (getSimpleCache() == null) {
                LeastRecentlyUsedCacheEvictor leastRecentlyUsedCacheEvictor = new LeastRecentlyUsedCacheEvictor(41943040L);
                Intrinsics.checkNotNull(context);
                PlayerProxy.simpleCache = new SimpleCache(new File(Intrinsics.stringPlus(context.getCacheDir().toString(), "/Music/"), "exo_player_exo_cache"), leastRecentlyUsedCacheEvictor, new StandaloneDatabaseProvider(context));
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: cache$lambda-0, reason: not valid java name */
        public static final String m8780cache$lambda0(DataSpec it) {
            Intrinsics.checkNotNullParameter(it, "it");
            Companion companion = PlayerProxy.INSTANCE;
            String string = it.uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "it.uri.toString()");
            return companion.getKey(string);
        }

        public final void cache$PlayerSdk_exoDefaultRelease(DataSource.Factory dataSourceFactory, DataSpec dataSpec, Cache cache, byte[] buffer, boolean enableEOFException, AtomicBoolean atomicBoolean, CacheMediaListener cacheMediaListener) throws InterruptedException, IOException {
            Intrinsics.checkNotNullParameter(dataSourceFactory, "dataSourceFactory");
            Intrinsics.checkNotNullParameter(dataSpec, "dataSpec");
            Intrinsics.checkNotNullParameter(cache, "cache");
            CacheDataSource cacheDataSourceCreateDataSourceForDownloading = new CacheDataSource.Factory().setCache(cache).setUpstreamDataSourceFactory(dataSourceFactory).setCacheKeyFactory(new CacheKeyFactory() { // from class: fm.feed.android.playersdk.PlayerProxy$Companion$$ExternalSyntheticLambda1
                @Override // com.google.android.exoplayer2.upstream.cache.CacheKeyFactory
                public final String buildCacheKey(DataSpec dataSpec2) {
                    return PlayerProxy.Companion.m8780cache$lambda0(dataSpec2);
                }
            }).setEventListener(new CacheDataSource.EventListener() { // from class: fm.feed.android.playersdk.PlayerProxy$Companion$cache$source$1
                @Override // com.google.android.exoplayer2.upstream.cache.CacheDataSource.EventListener
                public void onCacheIgnored(int reason) {
                }

                @Override // com.google.android.exoplayer2.upstream.cache.CacheDataSource.EventListener
                public void onCachedBytesRead(long cacheSizeBytes, long cachedBytesRead) {
                    Log.d("Cache", "cacheSizeBytes = " + cacheSizeBytes + "  cachedBytesRead =" + cachedBytesRead);
                }
            }).createDataSourceForDownloading();
            Intrinsics.checkNotNullExpressionValue(cacheDataSourceCreateDataSourceForDownloading, "Factory().setCache(cache…ataSourceForDownloading()");
            new CacheWriter(cacheDataSourceCreateDataSourceForDownloading, dataSpec, buffer, null).cache();
        }

        public final DataSpec createDataSpec$PlayerSdk_exoDefaultRelease(String url, long maxCache, String key) {
            Intrinsics.checkNotNullParameter(url, "url");
            return new DataSpec(Uri.parse(url), 0L, maxCache);
        }

        public final DataSource.Factory dataSourceFactoryCreator$PlayerSdk_exoDefaultRelease(Context context, final CacheMediaListener listener) {
            Intrinsics.checkNotNullParameter(context, "context");
            DefaultHttpDataSource.Factory userAgent = new DefaultHttpDataSource.Factory().setAllowCrossProtocolRedirects(true).setUserAgent(Util.getUserAgent(context, "FeedAndroidSdk"));
            Intrinsics.checkNotNullExpressionValue(userAgent, "Factory().setAllowCrossP…ntext, \"FeedAndroidSdk\"))");
            DefaultDataSource.Factory transferListener = new DefaultDataSource.Factory(context, userAgent).setTransferListener(new TransferListener() { // from class: fm.feed.android.playersdk.PlayerProxy$Companion$dataSourceFactoryCreator$1
                @Override // com.google.android.exoplayer2.upstream.TransferListener
                public void onBytesTransferred(DataSource source, DataSpec dataSpec, boolean isNetwork, int bytesTransferred) {
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(dataSpec, "dataSpec");
                }

                @Override // com.google.android.exoplayer2.upstream.TransferListener
                public void onTransferInitializing(DataSource source, DataSpec dataSpec, boolean isNetwork) {
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(dataSpec, "dataSpec");
                }

                @Override // com.google.android.exoplayer2.upstream.TransferListener
                public void onTransferStart(DataSource source, DataSpec dataSpec, boolean isNetwork) {
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(dataSpec, "dataSpec");
                    Log.v("Cache", "Started caching source (" + source.getUri() + ") start from position " + dataSpec.position + ", length " + dataSpec.length);
                }

                @Override // com.google.android.exoplayer2.upstream.TransferListener
                public void onTransferEnd(DataSource source, DataSpec dataSpec, boolean isNetwork) {
                    Intrinsics.checkNotNullParameter(source, "source");
                    Intrinsics.checkNotNullParameter(dataSpec, "dataSpec");
                    CacheMediaListener cacheMediaListener = listener;
                    if (cacheMediaListener != null) {
                        cacheMediaListener.onCacheTransferEnded();
                    }
                    Log.v("Cache", "Finished caching source (" + dataSpec.uri + ") transfer ended ");
                }
            });
            Intrinsics.checkNotNullExpressionValue(transferListener, "listener: CacheMediaList…         }\n            })");
            return transferListener;
        }

        private final String getKey(String url) {
            String str = url;
            if (!StringsKt.contains$default((CharSequence) str, (CharSequence) SdkConstants.PREFIX_THEME_REF, false, 2, (Object) null)) {
                return url;
            }
            int iIndexOf$default = StringsKt.indexOf$default((CharSequence) str, SdkConstants.PREFIX_THEME_REF, 0, false, 6, (Object) null);
            if (url == null) {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
            String strSubstring = url.substring(0, iIndexOf$default);
            Intrinsics.checkNotNullExpressionValue(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
            return strSubstring;
        }

        public final ExoPlayer createSimpleExoplayer(Context context, Looper looper) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(looper, "looper");
            ExoPlayer exoPlayerBuild = new ExoPlayer.Builder(context).setLooper(looper).build();
            Intrinsics.checkNotNullExpressionValue(exoPlayerBuild, "Builder(context).setLooper(looper).build()");
            return exoPlayerBuild;
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* renamed from: createDateSourceFactory$lambda-1, reason: not valid java name */
        public static final String m8781createDateSourceFactory$lambda1(DataSpec it) {
            Intrinsics.checkNotNullParameter(it, "it");
            Companion companion = PlayerProxy.INSTANCE;
            String string = it.uri.toString();
            Intrinsics.checkNotNullExpressionValue(string, "it.uri.toString()");
            return companion.getKey(string);
        }

        public final CacheDataSource.Factory createDateSourceFactory(Cache simpleCache, DataSource.Factory dataSourceFactory) {
            Intrinsics.checkNotNullParameter(simpleCache, "simpleCache");
            Intrinsics.checkNotNullParameter(dataSourceFactory, "dataSourceFactory");
            CacheDataSource.Factory eventListener = new CacheDataSource.Factory().setCache(simpleCache).setUpstreamDataSourceFactory(dataSourceFactory).setCacheKeyFactory(new CacheKeyFactory() { // from class: fm.feed.android.playersdk.PlayerProxy$Companion$$ExternalSyntheticLambda0
                @Override // com.google.android.exoplayer2.upstream.cache.CacheKeyFactory
                public final String buildCacheKey(DataSpec dataSpec) {
                    return PlayerProxy.Companion.m8781createDateSourceFactory$lambda1(dataSpec);
                }
            }).setEventListener(new CacheDataSource.EventListener() { // from class: fm.feed.android.playersdk.PlayerProxy$Companion$createDateSourceFactory$1
                @Override // com.google.android.exoplayer2.upstream.cache.CacheDataSource.EventListener
                public void onCacheIgnored(int reason) {
                }

                @Override // com.google.android.exoplayer2.upstream.cache.CacheDataSource.EventListener
                public void onCachedBytesRead(long cacheSizeBytes, long cachedBytesRead) {
                }
            });
            Intrinsics.checkNotNullExpressionValue(eventListener, "Factory().setCache(simpl…        }\n\n            })");
            return eventListener;
        }

        public final MediaSource getExtractorMediaSource(CacheDataSource.Factory cacheDataSourceFactory, Uri uri, String key) {
            Intrinsics.checkNotNullParameter(cacheDataSourceFactory, "cacheDataSourceFactory");
            Intrinsics.checkNotNullParameter(uri, "uri");
            ProgressiveMediaSource progressiveMediaSourceCreateMediaSource = new ProgressiveMediaSource.Factory(cacheDataSourceFactory).createMediaSource(MediaItem.fromUri(uri));
            Intrinsics.checkNotNullExpressionValue(progressiveMediaSourceCreateMediaSource, "Factory(cacheDataSourceF…e(MediaItem.fromUri(uri))");
            return progressiveMediaSourceCreateMediaSource;
        }

        public final float getVolume(ExoPlayer player) {
            Intrinsics.checkNotNullParameter(player, "player");
            return player.getVolume();
        }

        public final void setVolume(ExoPlayer player, float volume) {
            Intrinsics.checkNotNullParameter(player, "player");
            player.setVolume(volume);
        }

        public final void prepare(ExoPlayer player, MediaSource source) {
            Intrinsics.checkNotNullParameter(player, "player");
            Intrinsics.checkNotNullParameter(source, "source");
            player.setMediaSource(source);
            player.prepare();
        }
    }

    public final /* synthetic */ <T> Object callPrivateFunc(T t, String name, Object... args) throws NoSuchMethodException, SecurityException {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(args, "args");
        ArrayList arrayList = new ArrayList(args.length);
        for (Object obj : args) {
            Intrinsics.checkNotNull(obj);
            arrayList.add(obj.getClass());
        }
        Object[] array = arrayList.toArray(new Class[0]);
        if (array != null) {
            Class[] clsArr = (Class[]) array;
            Intrinsics.reifiedOperationMarker(4, ExifInterface.GPS_DIRECTION_TRUE);
            Method declaredMethod = Object.class.getDeclaredMethod(name, (Class[]) Arrays.copyOf(clsArr, clsArr.length));
            declaredMethod.setAccessible(true);
            return declaredMethod.invoke(t, Arrays.copyOf(args, args.length));
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }
}
