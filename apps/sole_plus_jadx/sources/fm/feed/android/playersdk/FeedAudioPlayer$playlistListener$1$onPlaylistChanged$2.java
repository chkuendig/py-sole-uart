package fm.feed.android.playersdk;

import com.sun.jna.platform.win32.WinError;
import fm.feed.android.playersdk.models.Play;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FeedAudioPlayer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "fm.feed.android.playersdk.FeedAudioPlayer$playlistListener$1$onPlaylistChanged$2", f = "FeedAudioPlayer.kt", i = {}, l = {WinError.ERROR_SINGLE_INSTANCE_APP}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class FeedAudioPlayer$playlistListener$1$onPlaylistChanged$2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int label;
    final /* synthetic */ FeedAudioPlayer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FeedAudioPlayer$playlistListener$1$onPlaylistChanged$2(FeedAudioPlayer feedAudioPlayer, Continuation<? super FeedAudioPlayer$playlistListener$1$onPlaylistChanged$2> continuation) {
        super(2, continuation);
        this.this$0 = feedAudioPlayer;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FeedAudioPlayer$playlistListener$1$onPlaylistChanged$2(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FeedAudioPlayer$playlistListener$1$onPlaylistChanged$2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws Throwable {
        MixingAudioPlayer mixingAudioPlayer;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            NextSongProvider nextSongProvider = this.this$0.songProvider;
            if (nextSongProvider == null) {
                Intrinsics.throwUninitializedPropertyAccessException("songProvider");
                nextSongProvider = null;
            }
            this.label = 1;
            obj = nextSongProvider.requestNextPlay(this);
            if (obj == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
        }
        Play play = (Play) obj;
        if (play != null && (mixingAudioPlayer = this.this$0.mPlayer) != null) {
            mixingAudioPlayer.addAudioAsset(play);
        }
        return Unit.INSTANCE;
    }
}
