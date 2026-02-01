package fm.feed.android.playersdk;

import fm.feed.android.playersdk.models.Play;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FeedAudioPlayer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "fm.feed.android.playersdk.FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayItemBeganPlayback$1", f = "FeedAudioPlayer.kt", i = {}, l = {383, 386, 395}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayItemBeganPlayback$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ long $bufferingTime;
    final /* synthetic */ Play $play;
    final /* synthetic */ int $waitingTime;
    int label;
    final /* synthetic */ FeedAudioPlayer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayItemBeganPlayback$1(FeedAudioPlayer feedAudioPlayer, Play play, long j, int i, Continuation<? super FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayItemBeganPlayback$1> continuation) {
        super(2, continuation);
        this.this$0 = feedAudioPlayer;
        this.$play = play;
        this.$bufferingTime = j;
        this.$waitingTime = i;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayItemBeganPlayback$1(this.this$0, this.$play, this.$bufferingTime, this.$waitingTime, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayItemBeganPlayback$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x011c  */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r17) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: fm.feed.android.playersdk.FeedAudioPlayer$mixingAudioPlayerEventListener$1$onPlayItemBeganPlayback$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
