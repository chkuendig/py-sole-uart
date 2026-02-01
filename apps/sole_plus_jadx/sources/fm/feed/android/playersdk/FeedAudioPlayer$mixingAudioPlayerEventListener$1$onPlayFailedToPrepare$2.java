package fm.feed.android.playersdk;

import com.facebook.internal.FacebookRequestErrorClassification;
import fm.feed.android.playersdk.models.Play;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FeedAudioPlayer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "fm.feed.android.playersdk.FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayFailedToPrepare$2", f = "FeedAudioPlayer.kt", i = {}, l = {490, FacebookRequestErrorClassification.ESC_APP_INACTIVE}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayFailedToPrepare$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ Ref.ObjectRef<String> $message;
    final /* synthetic */ Play $play;
    int label;
    final /* synthetic */ FeedAudioPlayer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayFailedToPrepare$2(FeedAudioPlayer feedAudioPlayer, Play play, Ref.ObjectRef<String> objectRef, Continuation<? super FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayFailedToPrepare$2> continuation) {
        super(2, continuation);
        this.this$0 = feedAudioPlayer;
        this.$play = play;
        this.$message = objectRef;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayFailedToPrepare$2(this.this$0, this.$play, this.$message, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayFailedToPrepare$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:33:0x0089  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r8) throws java.lang.Throwable {
        /*
            r7 = this;
            java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r1 = r7.label
            r2 = 1
            r3 = 2
            r4 = 0
            if (r1 == 0) goto L20
            if (r1 == r2) goto L1c
            if (r1 != r3) goto L14
            kotlin.ResultKt.throwOnFailure(r8)
            goto L85
        L14:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r0)
            throw r8
        L1c:
            kotlin.ResultKt.throwOnFailure(r8)
            goto L52
        L20:
            kotlin.ResultKt.throwOnFailure(r8)
            fm.feed.android.playersdk.FeedAudioPlayer r8 = r7.this$0
            fm.feed.android.playersdk.FeedSession r8 = fm.feed.android.playersdk.FeedAudioPlayer.access$getMSession$p(r8)
            if (r8 != 0) goto L31
            java.lang.String r8 = "mSession"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r8)
            r8 = r4
        L31:
            fm.feed.android.playersdk.models.Play r1 = r7.$play
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r5 = r7.$message
            T r5 = r5.element
            if (r5 != 0) goto L40
            java.lang.String r5 = "message"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r5)
            r5 = r4
            goto L46
        L40:
            kotlin.jvm.internal.Ref$ObjectRef<java.lang.String> r5 = r7.$message
            T r5 = r5.element
            java.lang.String r5 = (java.lang.String) r5
        L46:
            r6 = r7
            kotlin.coroutines.Continuation r6 = (kotlin.coroutines.Continuation) r6
            r7.label = r2
            java.lang.Object r8 = r8.rejectPlay(r1, r5, r6)
            if (r8 != r0) goto L52
            return r0
        L52:
            java.lang.Boolean r8 = (java.lang.Boolean) r8
            boolean r8 = r8.booleanValue()
            if (r8 == 0) goto La4
            fm.feed.android.playersdk.FeedAudioPlayer r8 = r7.this$0
            fm.feed.android.playersdk.NextSongProvider r8 = fm.feed.android.playersdk.FeedAudioPlayer.access$getSongProvider$p(r8)
            java.lang.String r1 = "songProvider"
            if (r8 != 0) goto L68
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r8 = r4
        L68:
            fm.feed.android.playersdk.models.Play r2 = r7.$play
            r8.playStart(r2)
            fm.feed.android.playersdk.FeedAudioPlayer r8 = r7.this$0
            fm.feed.android.playersdk.NextSongProvider r8 = fm.feed.android.playersdk.FeedAudioPlayer.access$getSongProvider$p(r8)
            if (r8 != 0) goto L79
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r1)
            r8 = r4
        L79:
            r1 = r7
            kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
            r7.label = r3
            java.lang.Object r8 = r8.requestNextPlay(r1)
            if (r8 != r0) goto L85
            return r0
        L85:
            fm.feed.android.playersdk.models.Play r8 = (fm.feed.android.playersdk.models.Play) r8
            if (r8 == 0) goto La4
            fm.feed.android.playersdk.FeedAudioPlayer r0 = r7.this$0
            fm.feed.android.playersdk.FMLog r0 = fm.feed.android.playersdk.FeedAudioPlayer.access$getLog$p(r0)
            java.lang.String r1 = "Adding Flushed "
            java.lang.String r1 = kotlin.jvm.internal.Intrinsics.stringPlus(r1, r8)
            fm.feed.android.playersdk.FMLog.e$default(r0, r1, r4, r3, r4)
            fm.feed.android.playersdk.FeedAudioPlayer r0 = r7.this$0
            fm.feed.android.playersdk.MixingAudioPlayer r0 = fm.feed.android.playersdk.FeedAudioPlayer.access$getMPlayer$p(r0)
            if (r0 != 0) goto La1
            goto La4
        La1:
            r0.addAudioAsset(r8)
        La4:
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayFailedToPrepare$2.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
