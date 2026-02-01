package fm.feed.android.playersdk;

import android.util.Log;
import fm.feed.android.playersdk.FMLog;
import java.io.File;
import java.io.IOException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: FMLog.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 5, 1}, xi = 48)
@DebugMetadata(c = "fm.feed.android.playersdk.FMLog$Companion$setContext$1", f = "FMLog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
/* loaded from: classes6.dex */
final class FMLog$Companion$setContext$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    final /* synthetic */ File $dir;
    final /* synthetic */ File $log;
    int label;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    FMLog$Companion$setContext$1(File file, File file2, Continuation<? super FMLog$Companion$setContext$1> continuation) {
        super(2, continuation);
        this.$dir = file;
        this.$log = file2;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new FMLog$Companion$setContext$1(this.$dir, this.$log, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((FMLog$Companion$setContext$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) throws IOException {
        IntrinsicsKt.getCOROUTINE_SUSPENDED();
        if (this.label != 0) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        ResultKt.throwOnFailure(obj);
        try {
            this.$dir.mkdirs();
            Log.d("fm.feed.FMLog", Intrinsics.stringPlus("Deleted old log file = ", Boxing.boxBoolean(this.$log.exists() ? this.$log.delete() : false)));
            this.$log.createNewFile();
            FMLog.Companion companion = FMLog.INSTANCE;
            FMLog.logFile = this.$log;
        } catch (IOException e) {
            Log.e("fm.feed.FMLog", "Unable to create log file", e);
        }
        return Unit.INSTANCE;
    }
}
