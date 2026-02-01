package fm.feed.android.playersdk;

import fm.feed.android.playersdk.models.Play;
import fm.feed.android.playersdk.models.PlayList;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: OnDemandMusicSource.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0006J\u001d\u0010\u001b\u001a\u0004\u0018\u00010\u00062\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u0004\u0018\u00010\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010 R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\b\"\u0004\b\u0017\u0010\n\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006!"}, d2 = {"Lfm/feed/android/playersdk/OnDemandMusicSource;", "", "mSession", "Lfm/feed/android/playersdk/FeedSession;", "(Lfm/feed/android/playersdk/FeedSession;)V", "currentItem", "Lfm/feed/android/playersdk/models/Play;", "getCurrentItem", "()Lfm/feed/android/playersdk/models/Play;", "setCurrentItem", "(Lfm/feed/android/playersdk/models/Play;)V", "currentPlayList", "Lfm/feed/android/playersdk/models/PlayList;", "getCurrentPlayList", "()Lfm/feed/android/playersdk/models/PlayList;", "setCurrentPlayList", "(Lfm/feed/android/playersdk/models/PlayList;)V", "log", "Lfm/feed/android/playersdk/FMLog;", "getMSession", "()Lfm/feed/android/playersdk/FeedSession;", "nextItem", "getNextItem", "setNextItem", "playStart", "", "play", "requestAudioFile", "audioFile", "Lfm/feed/android/playersdk/models/AudioFile;", "(Lfm/feed/android/playersdk/models/AudioFile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "requestNextPlay", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class OnDemandMusicSource {
    private Play currentItem;
    private PlayList currentPlayList;
    private final FMLog log;
    private final FeedSession mSession;
    private Play nextItem;

    /* compiled from: OnDemandMusicSource.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "fm.feed.android.playersdk.OnDemandMusicSource", f = "OnDemandMusicSource.kt", i = {0}, l = {26}, m = "requestAudioFile", n = {"this"}, s = {"L$0"})
    /* renamed from: fm.feed.android.playersdk.OnDemandMusicSource$requestAudioFile$1, reason: invalid class name */
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
            return OnDemandMusicSource.this.requestAudioFile(null, this);
        }
    }

    /* compiled from: OnDemandMusicSource.kt */
    @Metadata(k = 3, mv = {1, 5, 1}, xi = 48)
    @DebugMetadata(c = "fm.feed.android.playersdk.OnDemandMusicSource", f = "OnDemandMusicSource.kt", i = {0}, l = {40}, m = "requestNextPlay", n = {"this"}, s = {"L$0"})
    /* renamed from: fm.feed.android.playersdk.OnDemandMusicSource$requestNextPlay$1, reason: invalid class name and case insensitive filesystem */
    static final class C10591 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        C10591(Continuation<? super C10591> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return OnDemandMusicSource.this.requestNextPlay(this);
        }
    }

    public OnDemandMusicSource(FeedSession mSession) {
        Intrinsics.checkNotNullParameter(mSession, "mSession");
        this.mSession = mSession;
        this.log = new FMLog("fm.feed.OnDemandMusicSource");
        this.currentPlayList = new PlayList();
    }

    public final FeedSession getMSession() {
        return this.mSession;
    }

    public final PlayList getCurrentPlayList() {
        return this.currentPlayList;
    }

    public final void setCurrentPlayList(PlayList playList) {
        Intrinsics.checkNotNullParameter(playList, "<set-?>");
        this.currentPlayList = playList;
    }

    public final Play getNextItem() {
        return this.nextItem;
    }

    public final void setNextItem(Play play) {
        this.nextItem = play;
    }

    public final Play getCurrentItem() {
        return this.currentItem;
    }

    public final void setCurrentItem(Play play) {
        this.currentItem = play;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object requestAudioFile(fm.feed.android.playersdk.models.AudioFile r8, kotlin.coroutines.Continuation<? super fm.feed.android.playersdk.models.Play> r9) throws java.lang.Throwable {
        /*
            r7 = this;
            boolean r0 = r9 instanceof fm.feed.android.playersdk.OnDemandMusicSource.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r9
            fm.feed.android.playersdk.OnDemandMusicSource$requestAudioFile$1 r0 = (fm.feed.android.playersdk.OnDemandMusicSource.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            fm.feed.android.playersdk.OnDemandMusicSource$requestAudioFile$1 r0 = new fm.feed.android.playersdk.OnDemandMusicSource$requestAudioFile$1
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
            fm.feed.android.playersdk.OnDemandMusicSource r8 = (fm.feed.android.playersdk.OnDemandMusicSource) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto L5f
        L2f:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L37:
            kotlin.ResultKt.throwOnFailure(r9)
            fm.feed.android.playersdk.FeedSession r9 = r7.getMSession()
            java.lang.Boolean r9 = r9.isAvailable()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L65
            fm.feed.android.playersdk.FeedSession r1 = r7.getMSession()
            r6.L$0 = r7
            r6.label = r2
            r2 = 0
            r4 = 0
            r5 = 0
            r3 = r8
            java.lang.Object r9 = r1.requestAudioFile(r2, r3, r4, r5, r6)
            if (r9 != r0) goto L5e
            return r0
        L5e:
            r8 = r7
        L5f:
            fm.feed.android.playersdk.models.Play r9 = (fm.feed.android.playersdk.models.Play) r9
            r8.setNextItem(r9)
            goto L66
        L65:
            r9 = 0
        L66:
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.OnDemandMusicSource.requestAudioFile(fm.feed.android.playersdk.models.AudioFile, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object requestNextPlay(kotlin.coroutines.Continuation<? super fm.feed.android.playersdk.models.Play> r9) {
        /*
            r8 = this;
            boolean r0 = r9 instanceof fm.feed.android.playersdk.OnDemandMusicSource.C10591
            if (r0 == 0) goto L14
            r0 = r9
            fm.feed.android.playersdk.OnDemandMusicSource$requestNextPlay$1 r0 = (fm.feed.android.playersdk.OnDemandMusicSource.C10591) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            fm.feed.android.playersdk.OnDemandMusicSource$requestNextPlay$1 r0 = new fm.feed.android.playersdk.OnDemandMusicSource$requestNextPlay$1
            r0.<init>(r9)
        L19:
            r6 = r0
            java.lang.Object r9 = r6.result
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r6.label
            r2 = 1
            r7 = 0
            if (r1 == 0) goto L38
            if (r1 != r2) goto L30
            java.lang.Object r0 = r6.L$0
            fm.feed.android.playersdk.OnDemandMusicSource r0 = (fm.feed.android.playersdk.OnDemandMusicSource) r0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L71
        L30:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L38:
            kotlin.ResultKt.throwOnFailure(r9)
            fm.feed.android.playersdk.FeedSession r9 = r8.getMSession()
            java.lang.Boolean r9 = r9.isAvailable()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r9)
            boolean r9 = r9.booleanValue()
            if (r9 == 0) goto L83
            fm.feed.android.playersdk.models.PlayList r9 = r8.getCurrentPlayList()
            boolean r9 = r9.isNotEmpty()
            if (r9 == 0) goto L83
            fm.feed.android.playersdk.models.PlayList r9 = r8.getCurrentPlayList()
            fm.feed.android.playersdk.models.AudioFile r3 = r9.first()
            fm.feed.android.playersdk.FeedSession r1 = r8.getMSession()
            r6.L$0 = r8
            r6.label = r2
            r2 = 0
            r4 = 0
            r5 = 0
            java.lang.Object r9 = r1.requestAudioFile(r2, r3, r4, r5, r6)
            if (r9 != r0) goto L70
            return r0
        L70:
            r0 = r8
        L71:
            fm.feed.android.playersdk.models.Play r9 = (fm.feed.android.playersdk.models.Play) r9
            fm.feed.android.playersdk.FMLog r1 = r0.log
            java.lang.String r2 = "PLMS requestNextPlay "
            java.lang.String r2 = kotlin.jvm.internal.Intrinsics.stringPlus(r2, r9)
            r3 = 2
            fm.feed.android.playersdk.FMLog.d$default(r1, r2, r7, r3, r7)
            r0.setNextItem(r9)
            r7 = r9
        L83:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.OnDemandMusicSource.requestNextPlay(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void playStart(Play play) {
        Intrinsics.checkNotNullParameter(play, "play");
        FMLog.d$default(this.log, Intrinsics.stringPlus("playStart removing ", play), null, 2, null);
        new PlayList.Editor(this.currentPlayList).removeFromPlaylist(play.getAudioFile());
        this.currentItem = this.nextItem;
        this.nextItem = null;
    }
}
