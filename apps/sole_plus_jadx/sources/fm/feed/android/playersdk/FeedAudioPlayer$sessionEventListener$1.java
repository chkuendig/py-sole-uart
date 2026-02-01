package fm.feed.android.playersdk;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import fm.feed.android.playersdk.FeedSession;
import fm.feed.android.playersdk.models.CacheInfo;
import fm.feed.android.playersdk.models.Station;
import fm.feed.android.playersdk.models.StationList;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONArray;
import org.json.JSONException;

/* compiled from: FeedAudioPlayer.kt */
@Metadata(d1 = {"\u0000E\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0016J\b\u0010\u0007\u001a\u00020\u0003H\u0016J\u0016\u0010\b\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\b\u0010\f\u001a\u00020\u0003H\u0016J\u0014\u0010\r\u001a\u00020\u00032\n\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u0013H\u0016J\u0018\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0016\u0010\u0018\u001a\u00020\u00032\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nH\u0016J\u0014\u0010\u0019\u001a\u00020\u00032\n\u0010\u001a\u001a\u00060\u000fj\u0002`\u0010H\u0016¨\u0006\u001b"}, d2 = {"fm/feed/android/playersdk/FeedAudioPlayer$sessionEventListener$1", "Lfm/feed/android/playersdk/FeedSession$EventListener;", "cacheFilesAvailable", "", "cacheInfoList", "", "Lfm/feed/android/playersdk/models/CacheInfo;", "noMoreMusic", "remoteOfflineStationListAvailable", "stations", "", "Lfm/feed/android/playersdk/models/Station;", "sessionAvailable", "sessionNotAvailable", "ex", "Ljava/lang/Exception;", "Lkotlin/Exception;", "skipStatusDidChange", "canSkip", "", "stationInfoAvailable", "station", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Lfm/feed/android/playersdk/StationDownloadListener;", "stationListAvailable", "unexpectedError", "e", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class FeedAudioPlayer$sessionEventListener$1 implements FeedSession.EventListener {
    final /* synthetic */ FeedAudioPlayer this$0;

    FeedAudioPlayer$sessionEventListener$1(FeedAudioPlayer feedAudioPlayer) {
        this.this$0 = feedAudioPlayer;
    }

    @Override // fm.feed.android.playersdk.FeedSession.EventListener
    public void stationInfoAvailable(Station station, StationDownloadListener listener) {
        Intrinsics.checkNotNullParameter(station, "station");
        Intrinsics.checkNotNullParameter(listener, "listener");
        OfflineSession offlineSession = this.this$0.mOfflineSession;
        if (offlineSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
            offlineSession = null;
        }
        offlineSession.addOfflineStation(station, listener);
    }

    @Override // fm.feed.android.playersdk.FeedSession.EventListener
    public void remoteOfflineStationListAvailable(List<Station> stations) {
        Intrinsics.checkNotNullParameter(stations, "stations");
        StationList stationList = new StationList();
        stationList.addAll(stations);
        this.this$0.remoteOfflineStationList = stationList;
    }

    @Override // fm.feed.android.playersdk.FeedSession.EventListener
    public void noMoreMusic() {
        if (this.this$0.mAdvanceOnNextItemReady) {
            this.this$0.mAdvanceOnNextItemReady = false;
        }
        MixingAudioPlayer mixingAudioPlayer = this.this$0.mPlayer;
        if ((mixingAudioPlayer == null ? null : mixingAudioPlayer.getState()) != State.WAITING_FOR_ITEM) {
            MixingAudioPlayer mixingAudioPlayer2 = this.this$0.mPlayer;
            if ((mixingAudioPlayer2 != null ? mixingAudioPlayer2.getState() : null) != State.READY_TO_PLAY) {
                return;
            }
        }
        this.this$0.stop();
        Iterator it = this.this$0.mOutOfMusicListeners.iterator();
        while (it.hasNext()) {
            ((OutOfMusicListener) it.next()).onOutOfMusic();
        }
    }

    @Override // fm.feed.android.playersdk.FeedSession.EventListener
    public void cacheFilesAvailable(final List<CacheInfo> cacheInfoList) {
        Intrinsics.checkNotNullParameter(cacheInfoList, "cacheInfoList");
        final AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        if (cacheInfoList.isEmpty()) {
            CachePreparedListener cachePreparedListener = this.this$0.cachePreparedListener;
            if (cachePreparedListener != null) {
                cachePreparedListener.onCachePrepared(atomicBoolean.get());
            }
            this.this$0.cachePreparedListener = null;
            return;
        }
        CacheInfo cacheInfo = cacheInfoList.get(0);
        cacheInfoList.remove(0);
        CacheMediaListener cacheMediaListener = new CacheMediaListener() { // from class: fm.feed.android.playersdk.FeedAudioPlayer$sessionEventListener$1$$ExternalSyntheticLambda0
            @Override // fm.feed.android.playersdk.CacheMediaListener
            public final void onCacheTransferEnded() {
                FeedAudioPlayer$sessionEventListener$1.m8778cacheFilesAvailable$lambda0(atomicBoolean, this, cacheInfoList);
            }
        };
        MixingAudioPlayer mixingAudioPlayer = this.this$0.mPlayer;
        if (mixingAudioPlayer == null) {
            return;
        }
        mixingAudioPlayer.cacheMedia(cacheInfo.getUrl(), cacheInfo.getCacheSize(), cacheMediaListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: cacheFilesAvailable$lambda-0, reason: not valid java name */
    public static final void m8778cacheFilesAvailable$lambda0(AtomicBoolean isSuccess, FeedAudioPlayer$sessionEventListener$1 this$0, List cacheInfoList) {
        Intrinsics.checkNotNullParameter(isSuccess, "$isSuccess");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(cacheInfoList, "$cacheInfoList");
        isSuccess.set(true);
        this$0.cacheFilesAvailable(cacheInfoList);
    }

    /* JADX WARN: Removed duplicated region for block: B:45:0x00de  */
    @Override // fm.feed.android.playersdk.FeedSession.EventListener
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public void stationListAvailable(java.util.List<fm.feed.android.playersdk.models.Station> r6) {
        /*
            Method dump skipped, instructions count: 298
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.FeedAudioPlayer$sessionEventListener$1.stationListAvailable(java.util.List):void");
    }

    @Override // fm.feed.android.playersdk.FeedSession.EventListener
    public void sessionNotAvailable(Exception ex) {
        Intrinsics.checkNotNullParameter(ex, "ex");
        if (this.this$0.getBIsUpdatingSession()) {
            return;
        }
        if (this.this$0.mState == State.UNINITIALIZED) {
            this.this$0.setState(State.UNAVAILABLE);
            if (FeedAudioPlayer.INSTANCE.getAutoNetworkRetry()) {
                Iterator it = this.this$0.mAvailabilityListeners.iterator();
                while (it.hasNext()) {
                    ((AvailabilityListener) it.next()).onPlayerUnavailable(ex);
                }
                return;
            } else {
                while (!this.this$0.mAvailabilityListeners.isEmpty()) {
                    Object objRemove = this.this$0.mAvailabilityListeners.remove(0);
                    Intrinsics.checkNotNullExpressionValue(objRemove, "mAvailabilityListeners.removeAt(0)");
                    ((AvailabilityListener) objRemove).onPlayerUnavailable(ex);
                }
                return;
            }
        }
        if (this.this$0.mState != State.UNAVAILABLE) {
            while (!this.this$0.mAvailabilityListeners.isEmpty()) {
                if (this.this$0.getLocalOfflineStationList().size() > 0) {
                    Object objRemove2 = this.this$0.mAvailabilityListeners.remove(0);
                    Intrinsics.checkNotNullExpressionValue(objRemove2, "mAvailabilityListeners.removeAt(0)");
                    ((AvailabilityListener) objRemove2).onPlayerAvailable(this.this$0);
                }
            }
        }
    }

    @Override // fm.feed.android.playersdk.FeedSession.EventListener
    public void sessionAvailable() throws JSONException {
        SessionUpdateListener mSessionUpdateListener;
        if (this.this$0.getBIsUpdatingSession() && (mSessionUpdateListener = this.this$0.getMSessionUpdateListener()) != null) {
            mSessionUpdateListener.onUpdatedSessionAvailable();
        }
        this.this$0.setState(State.READY_TO_PLAY);
        while (!this.this$0.mAvailabilityListeners.isEmpty()) {
            Object objRemove = this.this$0.mAvailabilityListeners.remove(0);
            Intrinsics.checkNotNullExpressionValue(objRemove, "mAvailabilityListeners.removeAt(0)");
            ((AvailabilityListener) objRemove).onPlayerAvailable(this.this$0);
        }
        OfflineSession offlineSession = this.this$0.mOfflineSession;
        FeedSession feedSession = null;
        if (offlineSession == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
            offlineSession = null;
        }
        JSONArray jSONArrayCopyAndResetLogs = offlineSession.copyAndResetLogs();
        if (jSONArrayCopyAndResetLogs.length() > 0) {
            FeedSession feedSession2 = this.this$0.mSession;
            if (feedSession2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mSession");
            } else {
                feedSession = feedSession2;
            }
            final FeedAudioPlayer feedAudioPlayer = this.this$0;
            feedSession.sendOfflineLogs(jSONArrayCopyAndResetLogs, new FeedSession.OfflineLogsListener() { // from class: fm.feed.android.playersdk.FeedAudioPlayer$sessionEventListener$1$sessionAvailable$1
                @Override // fm.feed.android.playersdk.FeedSession.OfflineLogsListener
                public void offlineLogSaveFailed(JSONArray logs) {
                    Intrinsics.checkNotNullParameter(logs, "logs");
                    OfflineSession offlineSession2 = feedAudioPlayer.mOfflineSession;
                    if (offlineSession2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mOfflineSession");
                        offlineSession2 = null;
                    }
                    offlineSession2.prependLogs(logs);
                }
            });
        }
    }

    @Override // fm.feed.android.playersdk.FeedSession.EventListener
    public void unexpectedError(Exception e) {
        Intrinsics.checkNotNullParameter(e, "e");
        FMLog.e$default(this.this$0.log, "Unexpected error \n", null, 2, null);
        e.printStackTrace();
        Iterator it = this.this$0.mUnhandledErrorListeners.iterator();
        while (it.hasNext()) {
            ((UnhandledErrorListener) it.next()).onUnhandledError(new FeedException(e));
        }
    }

    @Override // fm.feed.android.playersdk.FeedSession.EventListener
    public void skipStatusDidChange(boolean canSkip) {
        Iterator it = this.this$0.mPlayListeners.iterator();
        while (it.hasNext()) {
            ((PlayListener) it.next()).onSkipStatusChanged(canSkip);
        }
    }
}
