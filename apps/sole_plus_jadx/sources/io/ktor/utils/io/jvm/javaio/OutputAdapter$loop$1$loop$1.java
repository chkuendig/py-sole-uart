package io.ktor.utils.io.jvm.javaio;

import com.sun.jna.platform.win32.WinNT;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: Blocking.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.jvm.javaio.OutputAdapter$loop$1", f = "Blocking.kt", i = {0, 0, 1}, l = {WinNT.SERVICE_TYPE_ALL, 94}, m = "loop", n = {"this", "this_$iv", "this"}, s = {"L$0", "L$1", "L$0"})
/* loaded from: classes6.dex */
final class OutputAdapter$loop$1$loop$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ OutputAdapter$loop$1 this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    OutputAdapter$loop$1$loop$1(OutputAdapter$loop$1 outputAdapter$loop$1, Continuation<? super OutputAdapter$loop$1$loop$1> continuation) {
        super(continuation);
        this.this$0 = outputAdapter$loop$1;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.loop(this);
    }
}
