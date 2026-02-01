package fm.feed.android.playersdk;

import fm.feed.android.playersdk.FeedAudioPlayer;
import fm.feed.android.playersdk.models.AudioFile;
import fm.feed.android.playersdk.models.Play;
import fm.feed.android.playersdk.models.PlayList;
import fm.feed.android.playersdk.models.Station;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import org.objectweb.asm.Opcodes;

/* compiled from: NextSongProvider.kt */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001b\u0010$\u001a\u0004\u0018\u00010\u00062\u0006\u0010%\u001a\u00020&H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010'J\u001b\u0010(\u001a\u0004\u0018\u00010\u00062\u0006\u0010)\u001a\u00020*H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010+J\b\u0010,\u001a\u0004\u0018\u00010&J\u0006\u0010-\u001a\u00020.J\n\u0010/\u001a\u0004\u0018\u00010\u0006H\u0002J\n\u00100\u001a\u0004\u0018\u00010\u0006H\u0002J\u000e\u00101\u001a\u0002022\u0006\u0010\u0005\u001a\u00020\u0006J\u0013\u00103\u001a\u0004\u0018\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u00104J\u001b\u00105\u001a\u0004\u0018\u00010\u00062\u0006\u0010)\u001a\u00020*H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010+J\u0006\u00106\u001a\u000202J\u000e\u00107\u001a\u0002022\u0006\u0010%\u001a\u00020&J\b\u00108\u001a\u000209H\u0016R(\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R(\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\u00068F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001c\u0010\t\"\u0004\b\u001d\u0010\u000bR\u000e\u0010\u001e\u001a\u00020\u001fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060!X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006:"}, d2 = {"Lfm/feed/android/playersdk/NextSongProvider;", "", "mSession", "Lfm/feed/android/playersdk/FeedSession;", "(Lfm/feed/android/playersdk/FeedSession;)V", "play", "Lfm/feed/android/playersdk/models/Play;", "currentItem", "getCurrentItem", "()Lfm/feed/android/playersdk/models/Play;", "setCurrentItem", "(Lfm/feed/android/playersdk/models/Play;)V", "currentMusicSource", "Lfm/feed/android/playersdk/FeedAudioPlayer$MusicSource;", "getCurrentMusicSource", "()Lfm/feed/android/playersdk/FeedAudioPlayer$MusicSource;", "setCurrentMusicSource", "(Lfm/feed/android/playersdk/FeedAudioPlayer$MusicSource;)V", "log", "Lfm/feed/android/playersdk/FMLog;", "mNextPlayInProgress", "", "getMNextPlayInProgress", "()Z", "setMNextPlayInProgress", "(Z)V", "value", "nextItem", "getNextItem", "setNextItem", "onDemandMusicSource", "Lfm/feed/android/playersdk/OnDemandMusicSource;", "preparedPlays", "", "stationMusicSource", "Lfm/feed/android/playersdk/StationMusicSource;", "cacheNextPlayInStation", "station", "Lfm/feed/android/playersdk/models/Station;", "(Lfm/feed/android/playersdk/models/Station;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "cachePlayForAudioFile", "audioFile", "Lfm/feed/android/playersdk/models/AudioFile;", "(Lfm/feed/android/playersdk/models/AudioFile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCurrentStation", "getPlayQueue", "Lfm/feed/android/playersdk/models/PlayList;", "nextOnDemandPlayFromCacheOrNull", "nextPlayInActiveStationFromCacheOrNull", "playStart", "", "requestNextPlay", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestPlayForAudioFile", "reset", "setActiveStation", "toString", "", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class NextSongProvider {
    private FeedAudioPlayer.MusicSource currentMusicSource;
    private final FMLog log;
    private boolean mNextPlayInProgress;
    private final FeedSession mSession;
    private final OnDemandMusicSource onDemandMusicSource;
    private final List<Play> preparedPlays;
    private final StationMusicSource stationMusicSource;

    /* compiled from: NextSongProvider.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[FeedAudioPlayer.MusicSource.values().length];
            iArr[FeedAudioPlayer.MusicSource.ON_DEMAND.ordinal()] = 1;
            iArr[FeedAudioPlayer.MusicSource.STATION.ordinal()] = 2;
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: NextSongProvider.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "fm.feed.android.playersdk.NextSongProvider", f = "NextSongProvider.kt", i = {0, 0}, l = {Opcodes.PUTFIELD}, m = "cacheNextPlayInStation", n = {"this", "station"}, s = {"L$0", "L$1"})
    /* renamed from: fm.feed.android.playersdk.NextSongProvider$cacheNextPlayInStation$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NextSongProvider.this.cacheNextPlayInStation(null, this);
        }
    }

    /* compiled from: NextSongProvider.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "fm.feed.android.playersdk.NextSongProvider", f = "NextSongProvider.kt", i = {0}, l = {135}, m = "cachePlayForAudioFile", n = {"this"}, s = {"L$0"})
    /* renamed from: fm.feed.android.playersdk.NextSongProvider$cachePlayForAudioFile$1, reason: invalid class name and case insensitive filesystem */
    static final class C10571 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10571(Continuation<? super C10571> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NextSongProvider.this.cachePlayForAudioFile(null, this);
        }
    }

    /* compiled from: NextSongProvider.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "fm.feed.android.playersdk.NextSongProvider", f = "NextSongProvider.kt", i = {0, 1, 2, 2, 3}, l = {86, 87, 96, 98}, m = "requestNextPlay", n = {"this", "this", "this", "nextPlay", "this"}, s = {"L$0", "L$0", "L$0", "L$1", "L$0"})
    /* renamed from: fm.feed.android.playersdk.NextSongProvider$requestNextPlay$1, reason: invalid class name and case insensitive filesystem */
    static final class C10581 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        C10581(Continuation<? super C10581> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return NextSongProvider.this.requestNextPlay(this);
        }
    }

    public NextSongProvider(FeedSession mSession) {
        Intrinsics.checkNotNullParameter(mSession, "mSession");
        this.mSession = mSession;
        this.log = new FMLog("fm.feed.NextSongProvider");
        this.onDemandMusicSource = new OnDemandMusicSource(mSession);
        this.stationMusicSource = new StationMusicSource(mSession);
        this.currentMusicSource = FeedAudioPlayer.MusicSource.STATION;
        this.preparedPlays = new ArrayList();
    }

    public final FeedAudioPlayer.MusicSource getCurrentMusicSource() {
        return this.currentMusicSource;
    }

    public final void setCurrentMusicSource(FeedAudioPlayer.MusicSource musicSource) {
        Intrinsics.checkNotNullParameter(musicSource, "<set-?>");
        this.currentMusicSource = musicSource;
    }

    public final boolean getMNextPlayInProgress() {
        return this.mNextPlayInProgress;
    }

    public final void setMNextPlayInProgress(boolean z) {
        this.mNextPlayInProgress = z;
    }

    public final Play getNextItem() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.currentMusicSource.ordinal()];
        if (i == 1) {
            return this.onDemandMusicSource.getNextItem();
        }
        if (i == 2) {
            return this.stationMusicSource.getMNextPlay();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void setNextItem(Play play) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.currentMusicSource.ordinal()];
        if (i == 1) {
            this.onDemandMusicSource.setNextItem(play);
        } else {
            if (i != 2) {
                return;
            }
            this.stationMusicSource.setMNextPlay(play);
        }
    }

    public final Play getCurrentItem() {
        int i = WhenMappings.$EnumSwitchMapping$0[this.currentMusicSource.ordinal()];
        if (i == 1) {
            return this.onDemandMusicSource.getCurrentItem();
        }
        if (i == 2) {
            return this.stationMusicSource.getCurrentPlay();
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void setCurrentItem(Play play) {
        int i = WhenMappings.$EnumSwitchMapping$0[this.currentMusicSource.ordinal()];
        if (i == 1) {
            this.onDemandMusicSource.setCurrentItem(play);
        } else {
            if (i != 2) {
                return;
            }
            this.stationMusicSource.setCurrentPlay(play);
        }
    }

    public final void reset() {
        this.onDemandMusicSource.setCurrentItem(null);
        this.onDemandMusicSource.setNextItem(null);
        this.onDemandMusicSource.setCurrentPlayList(new PlayList());
        this.stationMusicSource.setCurrentPlay(null);
        this.stationMusicSource.setMNextPlay(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:70:0x011f  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x0146  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0166  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object requestNextPlay(kotlin.coroutines.Continuation<? super fm.feed.android.playersdk.models.Play> r11) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 364
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.NextSongProvider.requestNextPlay(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void playStart(Play play) {
        Intrinsics.checkNotNullParameter(play, "play");
        int i = WhenMappings.$EnumSwitchMapping$0[this.currentMusicSource.ordinal()];
        if (i == 1) {
            this.onDemandMusicSource.playStart(play);
        } else {
            if (i != 2) {
                return;
            }
            this.stationMusicSource.playStart(play);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object cachePlayForAudioFile(fm.feed.android.playersdk.models.AudioFile r5, kotlin.coroutines.Continuation<? super fm.feed.android.playersdk.models.Play> r6) {
        /*
            r4 = this;
            boolean r0 = r6 instanceof fm.feed.android.playersdk.NextSongProvider.C10571
            if (r0 == 0) goto L14
            r0 = r6
            fm.feed.android.playersdk.NextSongProvider$cachePlayForAudioFile$1 r0 = (fm.feed.android.playersdk.NextSongProvider.C10571) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r6 = r0.label
            int r6 = r6 - r2
            r0.label = r6
            goto L19
        L14:
            fm.feed.android.playersdk.NextSongProvider$cachePlayForAudioFile$1 r0 = new fm.feed.android.playersdk.NextSongProvider$cachePlayForAudioFile$1
            r0.<init>(r6)
        L19:
            java.lang.Object r6 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L36
            if (r2 != r3) goto L2e
            java.lang.Object r5 = r0.L$0
            fm.feed.android.playersdk.NextSongProvider r5 = (fm.feed.android.playersdk.NextSongProvider) r5
            kotlin.ResultKt.throwOnFailure(r6)
            goto L45
        L2e:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L36:
            kotlin.ResultKt.throwOnFailure(r6)
            r0.L$0 = r4
            r0.label = r3
            java.lang.Object r6 = r4.requestPlayForAudioFile(r5, r0)
            if (r6 != r1) goto L44
            return r1
        L44:
            r5 = r4
        L45:
            fm.feed.android.playersdk.models.Play r6 = (fm.feed.android.playersdk.models.Play) r6
            fm.feed.android.playersdk.OnDemandMusicSource r0 = r5.onDemandMusicSource
            r1 = 0
            r0.setNextItem(r1)
            if (r6 != 0) goto L50
            goto L59
        L50:
            java.util.List<fm.feed.android.playersdk.models.Play> r5 = r5.preparedPlays
            boolean r5 = r5.add(r6)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r5)
        L59:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.NextSongProvider.cachePlayForAudioFile(fm.feed.android.playersdk.models.AudioFile, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final Object requestPlayForAudioFile(AudioFile audioFile, Continuation<? super Play> continuation) {
        int i = WhenMappings.$EnumSwitchMapping$0[getCurrentMusicSource().ordinal()];
        if (i == 1) {
            return this.onDemandMusicSource.requestAudioFile(audioFile, continuation);
        }
        if (i == 2) {
            return this.stationMusicSource.requestAudioFile(audioFile, continuation);
        }
        throw new NoWhenBranchMatchedException();
    }

    public final void setActiveStation(Station station) {
        Intrinsics.checkNotNullParameter(station, "station");
        this.stationMusicSource.setMActiveStation(station);
        this.currentMusicSource = FeedAudioPlayer.MusicSource.STATION;
    }

    public final Station getCurrentStation() {
        return this.stationMusicSource.getMActiveStation();
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object cacheNextPlayInStation(fm.feed.android.playersdk.models.Station r7, kotlin.coroutines.Continuation<? super fm.feed.android.playersdk.models.Play> r8) throws java.lang.Throwable {
        /*
            r6 = this;
            boolean r0 = r8 instanceof fm.feed.android.playersdk.NextSongProvider.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            fm.feed.android.playersdk.NextSongProvider$cacheNextPlayInStation$1 r0 = (fm.feed.android.playersdk.NextSongProvider.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            fm.feed.android.playersdk.NextSongProvider$cacheNextPlayInStation$1 r0 = new fm.feed.android.playersdk.NextSongProvider$cacheNextPlayInStation$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r7 = r0.L$1
            fm.feed.android.playersdk.models.Station r7 = (fm.feed.android.playersdk.models.Station) r7
            java.lang.Object r0 = r0.L$0
            fm.feed.android.playersdk.NextSongProvider r0 = (fm.feed.android.playersdk.NextSongProvider) r0
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6b
        L33:
            java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
            java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
            r7.<init>(r8)
            throw r7
        L3b:
            kotlin.ResultKt.throwOnFailure(r8)
            fm.feed.android.playersdk.FMLog r8 = r6.log
            java.lang.String r2 = "cacheNextPlayInStation"
            r5 = 2
            fm.feed.android.playersdk.FMLog.d$default(r8, r2, r4, r5, r4)
            fm.feed.android.playersdk.FeedSession r8 = r6.mSession
            java.lang.Boolean r8 = r8.isAvailable()
            if (r8 != 0) goto L4f
            goto L89
        L4f:
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto L89
            boolean r8 = r6.getMNextPlayInProgress()
            if (r8 != 0) goto L89
            fm.feed.android.playersdk.FeedSession r8 = r6.mSession
            r0.L$0 = r6
            r0.L$1 = r7
            r0.label = r3
            java.lang.Object r8 = r8.getNextPlayForStation(r7, r0)
            if (r8 != r1) goto L6a
            return r1
        L6a:
            r0 = r6
        L6b:
            fm.feed.android.playersdk.models.Play r8 = (fm.feed.android.playersdk.models.Play) r8
            if (r8 != 0) goto L70
            goto L74
        L70:
            fm.feed.android.playersdk.models.Station r4 = r8.getStation()
        L74:
            if (r4 != 0) goto L7c
            if (r8 != 0) goto L79
            goto L7c
        L79:
            r8.setStation(r7)
        L7c:
            if (r8 != 0) goto L7f
            goto L88
        L7f:
            java.util.List<fm.feed.android.playersdk.models.Play> r7 = r0.preparedPlays
            boolean r7 = r7.add(r8)
            kotlin.coroutines.jvm.internal.Boxing.boxBoolean(r7)
        L88:
            return r8
        L89:
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.NextSongProvider.cacheNextPlayInStation(fm.feed.android.playersdk.models.Station, kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final PlayList getPlayQueue() {
        return this.onDemandMusicSource.getCurrentPlayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private final Play nextOnDemandPlayFromCacheOrNull() {
        Play play = null;
        if (this.onDemandMusicSource.getCurrentPlayList().isNotEmpty()) {
            AudioFile audioFileFirst = this.onDemandMusicSource.getCurrentPlayList().first();
            Iterator<T> it = this.preparedPlays.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                Object next = it.next();
                if (Intrinsics.areEqual(audioFileFirst, ((Play) next).getAudioFile())) {
                    play = next;
                    break;
                }
            }
            play = play;
            if (play != null) {
                this.preparedPlays.remove(play);
            }
        }
        return play;
    }

    private final Play nextPlayInActiveStationFromCacheOrNull() {
        Object obj;
        Iterator<T> it = this.preparedPlays.iterator();
        while (true) {
            if (!it.hasNext()) {
                break;
            }
            Object next = it.next();
            Station station = ((Play) next).getStation();
            Integer id2 = station == null ? null : station.getId();
            Station mActiveStation = this.stationMusicSource.getMActiveStation();
            if (Intrinsics.areEqual(id2, mActiveStation != null ? mActiveStation.getId() : null)) {
                obj = next;
                break;
            }
        }
        Play play = (Play) obj;
        if (play != null) {
            this.preparedPlays.remove(play);
        }
        return play;
    }

    public String toString() {
        return "NSP:" + this.currentMusicSource.name() + ", Pplays:" + this.preparedPlays + ", NPIP:" + this.mNextPlayInProgress + " , StationSource:  currentPlay:" + this.stationMusicSource.getCurrentPlay() + ", nextPlay:" + this.stationMusicSource.getMNextPlay() + ", station:" + this.stationMusicSource.getMActiveStation() + "OnDemandMusicSource: Current:" + this.onDemandMusicSource.getCurrentItem() + ", Next:" + this.onDemandMusicSource.getNextItem() + ", List: " + this.onDemandMusicSource.getCurrentPlayList().toList() + ' ';
    }
}
