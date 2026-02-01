package io.ktor.utils.io;

import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* compiled from: ByteBufferChannel.kt */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.utils.io.ByteBufferChannel", f = "ByteBufferChannel.kt", i = {0}, l = {2368}, m = "peekTo-lBXzO7A$suspendImpl", n = {"bytesCopied"}, s = {"L$0"})
/* loaded from: classes6.dex */
final class ByteBufferChannel$peekTo$1 extends ContinuationImpl {
    Object L$0;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ ByteBufferChannel this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    ByteBufferChannel$peekTo$1(ByteBufferChannel byteBufferChannel, Continuation<? super ByteBufferChannel$peekTo$1> continuation) {
        super(continuation);
        this.this$0 = byteBufferChannel;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        return ByteBufferChannel.m8799peekTolBXzO7A$suspendImpl(this.this$0, null, 0L, 0L, 0L, 0L, this);
    }
}
