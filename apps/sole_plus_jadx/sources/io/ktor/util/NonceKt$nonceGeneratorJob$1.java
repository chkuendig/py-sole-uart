package io.ktor.util;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Nonce.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "io.ktor.util.NonceKt$nonceGeneratorJob$1", f = "Nonce.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {76}, m = "invokeSuspend", n = {"seedChannel", "previousRoundNonceList", "secureInstance", "weakRandom", "secureBytes", "weakBytes", "randomNonceList", "lastReseed", "index"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "J$0", "I$0"})
/* loaded from: classes6.dex */
final class NonceKt$nonceGeneratorJob$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
    int I$0;
    int I$1;
    long J$0;
    Object L$0;
    Object L$1;
    Object L$2;
    Object L$3;
    Object L$4;
    Object L$5;
    Object L$6;
    int label;

    NonceKt$nonceGeneratorJob$1(Continuation<? super NonceKt$nonceGeneratorJob$1> continuation) {
        super(2, continuation);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new NonceKt$nonceGeneratorJob$1(continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
        return ((NonceKt$nonceGeneratorJob$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007e A[Catch: all -> 0x0040, LOOP:1: B:14:0x007c->B:15:0x007e, LOOP_END, TryCatch #0 {all -> 0x0040, blocks: (B:6:0x002f, B:25:0x0102, B:22:0x00de, B:26:0x0104, B:28:0x0113, B:13:0x0073, B:15:0x007e, B:16:0x0087, B:18:0x0093, B:20:0x00a4, B:19:0x00a1), top: B:38:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:18:0x0093 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:6:0x002f, B:25:0x0102, B:22:0x00de, B:26:0x0104, B:28:0x0113, B:13:0x0073, B:15:0x007e, B:16:0x0087, B:18:0x0093, B:20:0x00a4, B:19:0x00a1), top: B:38:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:19:0x00a1 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:6:0x002f, B:25:0x0102, B:22:0x00de, B:26:0x0104, B:28:0x0113, B:13:0x0073, B:15:0x007e, B:16:0x0087, B:18:0x0093, B:20:0x00a4, B:19:0x00a1), top: B:38:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:22:0x00de A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:6:0x002f, B:25:0x0102, B:22:0x00de, B:26:0x0104, B:28:0x0113, B:13:0x0073, B:15:0x007e, B:16:0x0087, B:18:0x0093, B:20:0x00a4, B:19:0x00a1), top: B:38:0x002f }] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0104 A[Catch: all -> 0x0040, TryCatch #0 {all -> 0x0040, blocks: (B:6:0x002f, B:25:0x0102, B:22:0x00de, B:26:0x0104, B:28:0x0113, B:13:0x0073, B:15:0x007e, B:16:0x0087, B:18:0x0093, B:20:0x00a4, B:19:0x00a1), top: B:38:0x002f }] */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x00ff -> B:25:0x0102). Please report as a decompilation issue!!! */
    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object invokeSuspend(java.lang.Object r24) throws java.security.NoSuchAlgorithmException {
        /*
            Method dump skipped, instructions count: 313
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.NonceKt$nonceGeneratorJob$1.invokeSuspend(java.lang.Object):java.lang.Object");
    }
}
