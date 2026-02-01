package com.soletreadmills.sole_v2._manager;

import com.soletreadmills.sole_v2._manager.LogManager;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: LogManager.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
@DebugMetadata(c = "com.soletreadmills.sole_v2._manager.LogManager$Companion", f = "LogManager.kt", i = {0}, l = {65}, m = "uploadLog", n = {"logData"}, s = {"L$0"})
/* loaded from: classes5.dex */
final class LogManager$Companion$uploadLog$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ LogManager.Companion this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    LogManager$Companion$uploadLog$1(LogManager.Companion companion, Continuation<? super LogManager$Companion$uploadLog$1> continuation) {
        super(continuation);
        this.this$0 = companion;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.uploadLog(null, null, null, null, this);
    }
}
