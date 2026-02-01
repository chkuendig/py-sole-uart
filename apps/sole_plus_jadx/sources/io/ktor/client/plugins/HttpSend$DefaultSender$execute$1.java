package io.ktor.client.plugins;

import io.ktor.client.plugins.HttpSend;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: HttpSend.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.client.plugins.HttpSend$DefaultSender", f = "HttpSend.kt", i = {0}, l = {138}, m = "execute", n = {"this"}, s = {"L$0"})
/* loaded from: classes6.dex */
final class HttpSend$DefaultSender$execute$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ HttpSend.DefaultSender this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    HttpSend$DefaultSender$execute$1(HttpSend.DefaultSender defaultSender, Continuation<? super HttpSend$DefaultSender$execute$1> continuation) {
        super(continuation);
        this.this$0 = defaultSender;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return this.this$0.execute(null, this);
    }
}
