package fm.feed.android.playersdk;

import fm.feed.android.playersdk.models.Play;
import fm.feed.android.playersdk.models.Station;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: StationMusicSource.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0006J\u001b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u001b\u001a\u00020\u001cH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001dR\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR(\u0010\r\u001a\u0004\u0018\u00010\f2\b\u0010\u000b\u001a\u0004\u0018\u00010\f@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\b\"\u0004\b\u0014\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lfm/feed/android/playersdk/StationMusicSource;", "", "mSession", "Lfm/feed/android/playersdk/FeedSession;", "(Lfm/feed/android/playersdk/FeedSession;)V", "currentPlay", "Lfm/feed/android/playersdk/models/Play;", "getCurrentPlay", "()Lfm/feed/android/playersdk/models/Play;", "setCurrentPlay", "(Lfm/feed/android/playersdk/models/Play;)V", "station", "Lfm/feed/android/playersdk/models/Station;", "mActiveStation", "getMActiveStation", "()Lfm/feed/android/playersdk/models/Station;", "setMActiveStation", "(Lfm/feed/android/playersdk/models/Station;)V", "mNextPlay", "getMNextPlay", "setMNextPlay", "fetchNextStationPlay", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "playStart", "", "play", "requestAudioFile", "audioFile", "Lfm/feed/android/playersdk/models/AudioFile;", "(Lfm/feed/android/playersdk/models/AudioFile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class StationMusicSource {
    private Play currentPlay;
    private Station mActiveStation;
    private Play mNextPlay;
    private final FeedSession mSession;

    /* compiled from: StationMusicSource.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "fm.feed.android.playersdk.StationMusicSource", f = "StationMusicSource.kt", i = {0}, l = {50}, m = "fetchNextStationPlay", n = {"this"}, s = {"L$0"})
    /* renamed from: fm.feed.android.playersdk.StationMusicSource$fetchNextStationPlay$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StationMusicSource.this.fetchNextStationPlay(this);
        }
    }

    /* compiled from: StationMusicSource.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "fm.feed.android.playersdk.StationMusicSource", f = "StationMusicSource.kt", i = {0}, l = {66}, m = "requestAudioFile", n = {"this"}, s = {"L$0"})
    /* renamed from: fm.feed.android.playersdk.StationMusicSource$requestAudioFile$1, reason: invalid class name and case insensitive filesystem */
    static final class C10601 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10601(Continuation<? super C10601> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StationMusicSource.this.requestAudioFile(null, this);
        }
    }

    public StationMusicSource(FeedSession mSession) {
        Intrinsics.checkNotNullParameter(mSession, "mSession");
        this.mSession = mSession;
    }

    public final Station getMActiveStation() {
        return this.mActiveStation;
    }

    public final void setMActiveStation(Station station) {
        this.mActiveStation = station;
        this.mNextPlay = null;
        this.currentPlay = null;
    }

    public final Play getCurrentPlay() {
        return this.currentPlay;
    }

    public final void setCurrentPlay(Play play) {
        this.currentPlay = play;
    }

    public final Play getMNextPlay() {
        return this.mNextPlay;
    }

    public final void setMNextPlay(Play play) {
        this.mNextPlay = play;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object fetchNextStationPlay(kotlin.coroutines.Continuation<? super fm.feed.android.playersdk.models.Play> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof fm.feed.android.playersdk.StationMusicSource.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r5
            fm.feed.android.playersdk.StationMusicSource$fetchNextStationPlay$1 r0 = (fm.feed.android.playersdk.StationMusicSource.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            fm.feed.android.playersdk.StationMusicSource$fetchNextStationPlay$1 r0 = new fm.feed.android.playersdk.StationMusicSource$fetchNextStationPlay$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r0 = r0.L$0
            fm.feed.android.playersdk.StationMusicSource r0 = (fm.feed.android.playersdk.StationMusicSource) r0
            kotlin.ResultKt.throwOnFailure(r5)
            goto L67
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r5)
            fm.feed.android.playersdk.FeedSession r5 = r4.mSession
            java.lang.Boolean r5 = r5.isAvailable()
            fm.feed.android.playersdk.models.Station r2 = r4.getMActiveStation()
            if (r2 == 0) goto L6d
            if (r5 == 0) goto L6d
            r2 = 0
            java.lang.Boolean r2 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r2)
            boolean r5 = kotlin.jvm.internal.Intrinsics.areEqual(r5, r2)
            if (r5 != 0) goto L6d
            fm.feed.android.playersdk.FeedSession r5 = r4.mSession
            fm.feed.android.playersdk.models.Station r2 = r4.getMActiveStation()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r2)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r5 = r5.getNextPlayForStation(r2, r0)
            if (r5 != r1) goto L66
            return r1
        L66:
            r0 = r4
        L67:
            fm.feed.android.playersdk.models.Play r5 = (fm.feed.android.playersdk.models.Play) r5
            r0.setMNextPlay(r5)
            goto L71
        L6d:
            r5 = 0
            r0 = r5
            fm.feed.android.playersdk.models.Play r0 = (fm.feed.android.playersdk.models.Play) r0
        L71:
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.StationMusicSource.fetchNextStationPlay(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object requestAudioFile(fm.feed.android.playersdk.models.AudioFile r8, kotlin.coroutines.Continuation<? super fm.feed.android.playersdk.models.Play> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof fm.feed.android.playersdk.StationMusicSource.C10601
            if (r0 == 0) goto L14
            r0 = r9
            fm.feed.android.playersdk.StationMusicSource$requestAudioFile$1 r0 = (fm.feed.android.playersdk.StationMusicSource.C10601) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            fm.feed.android.playersdk.StationMusicSource$requestAudioFile$1 r0 = new fm.feed.android.playersdk.StationMusicSource$requestAudioFile$1
            r0.<init>(r9)
        L19:
            r6 = r0
            java.lang.Object r9 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            if (r1 == 0) goto L37
            if (r1 != r2) goto L2f
            java.lang.Object r8 = r6.L$0
            fm.feed.android.playersdk.StationMusicSource r8 = (fm.feed.android.playersdk.StationMusicSource) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L69
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.ResultKt.throwOnFailure(r9)
            fm.feed.android.playersdk.FeedSession r9 = r7.mSession
            java.lang.Boolean r9 = r9.isAvailable()
            fm.feed.android.playersdk.models.Station r1 = r7.getMActiveStation()
            if (r1 == 0) goto L6f
            if (r9 == 0) goto L6f
            r1 = 0
            java.lang.Boolean r1 = kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r1)
            boolean r9 = kotlin.jvm.internal.Intrinsics.areEqual(r9, r1)
            if (r9 != 0) goto L6f
            fm.feed.android.playersdk.FeedSession r1 = r7.mSession
            fm.feed.android.playersdk.models.Station r9 = r7.getMActiveStation()
            r6.L$0 = r7
            r6.label = r2
            r4 = 0
            r5 = 0
            r2 = r9
            r3 = r8
            java.lang.Object r9 = r1.requestAudioFile(r2, r3, r4, r5, r6)
            if (r9 != r0) goto L68
            return r0
        L68:
            r8 = r7
        L69:
            fm.feed.android.playersdk.models.Play r9 = (fm.feed.android.playersdk.models.Play) r9
            r8.setMNextPlay(r9)
            goto L70
        L6f:
            r9 = 0
        L70:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.StationMusicSource.requestAudioFile(fm.feed.android.playersdk.models.AudioFile, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void playStart(Play play) {
        Intrinsics.checkNotNullParameter(play, "play");
        this.mNextPlay = null;
        this.currentPlay = play;
    }
}
