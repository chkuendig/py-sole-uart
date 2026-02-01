package fm.feed.android.playersdk;

import com.sun.jna.platform.win32.WinError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FeedAudioPlayer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "fm.feed.android.playersdk.FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayerStateChanged$3", f = "FeedAudioPlayer.kt", i = {}, l = {WinError.ERROR_ABIOS_ERROR, WinError.ERROR_WX86_ERROR}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayerStateChanged$3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ State $playerState;
    int label;
    final /* synthetic */ FeedAudioPlayer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayerStateChanged$3(State state, FeedAudioPlayer feedAudioPlayer, Continuation<? super FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayerStateChanged$3> continuation) {
        super(2, continuation);
        this.$playerState = state;
        this.this$0 = feedAudioPlayer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayerStateChanged$3(this.$playerState, this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayerStateChanged$3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0066  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r6) throws java.lang.Throwable {
        /*
            r5 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r5.label
            r2 = 1
            r3 = 2
            r4 = 0
            if (r1 == 0) goto L1f
            if (r1 == r2) goto L1b
            if (r1 != r3) goto L13
            kotlin.ResultKt.throwOnFailure(r6)
            goto L62
        L13:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L1b:
            kotlin.ResultKt.throwOnFailure(r6)
            goto L30
        L1f:
            kotlin.ResultKt.throwOnFailure(r6)
            r6 = r5
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r5.label = r2
            r1 = 3000(0xbb8, double:1.482E-320)
            java.lang.Object r6 = kotlinx.coroutines.DelayKt.delay(r1, r6)
            if (r6 != r0) goto L30
            return r0
        L30:
            fm.feed.android.playersdk.State r6 = r5.$playerState
            fm.feed.android.playersdk.State r1 = fm.feed.android.playersdk.State.WAITING_FOR_ITEM
            if (r6 != r1) goto L88
            fm.feed.android.playersdk.FeedAudioPlayer r6 = r5.this$0
            fm.feed.android.playersdk.NextSongProvider r6 = fm.feed.android.playersdk.FeedAudioPlayer.access$getSongProvider$p(r6)
            java.lang.String r1 = "songProvider"
            if (r6 != 0) goto L44
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r6 = r4
        L44:
            boolean r6 = r6.getMNextPlayInProgress()
            if (r6 != 0) goto L88
            fm.feed.android.playersdk.FeedAudioPlayer r6 = r5.this$0
            fm.feed.android.playersdk.NextSongProvider r6 = fm.feed.android.playersdk.FeedAudioPlayer.access$getSongProvider$p(r6)
            if (r6 != 0) goto L56
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r6 = r4
        L56:
            r1 = r5
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r5.label = r3
            java.lang.Object r6 = r6.requestNextPlay(r1)
            if (r6 != r0) goto L62
            return r0
        L62:
            fm.feed.android.playersdk.models.Play r6 = (fm.feed.android.playersdk.models.Play) r6
            if (r6 == 0) goto L88
            fm.feed.android.playersdk.FeedAudioPlayer r0 = r5.this$0
            fm.feed.android.playersdk.FMLog r0 = fm.feed.android.playersdk.FeedAudioPlayer.access$getLog$p(r0)
            java.lang.String r1 = "Adding delayed song "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r6)
            fm.feed.android.playersdk.FMLog.e$default(r0, r1, r4, r3, r4)
            fm.feed.android.playersdk.FeedAudioPlayer r0 = r5.this$0
            fm.feed.android.playersdk.MixingAudioPlayer r0 = fm.feed.android.playersdk.FeedAudioPlayer.access$getMPlayer$p(r0)
            if (r0 != 0) goto L7e
            goto L81
        L7e:
            r0.addAudioAsset(r6)
        L81:
            fm.feed.android.playersdk.FeedAudioPlayer r6 = r5.this$0
            java.lang.String r0 = "Player stopped for unknown reason!!"
            fm.feed.android.playersdk.FeedAudioPlayer.access$assert(r6, r0)
        L88:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayerStateChanged$3.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
