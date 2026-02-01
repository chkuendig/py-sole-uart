package io.ktor.serialization.kotlinx.json;

import io.ktor.utils.io.ByteWriteChannel;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.serialization.KSerializer;

/* JADX INFO: Add missing generic type declarations: [T] */
/* compiled from: Collect.kt */
@Metadata(d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\b\u0012\u0004\u0012\u00028\u00000\u0001J\u0019\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00028\u0000H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\b¸\u0006\u0000"}, d2 = {"kotlinx/coroutines/flow/FlowKt__CollectKt$collectIndexed$2", "Lkotlinx/coroutines/flow/FlowCollector;", "index", "", "emit", "", "value", "(Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "kotlinx-coroutines-core"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1<T> implements FlowCollector<T> {
    final /* synthetic */ ByteWriteChannel $channel$inlined;
    final /* synthetic */ Charset $charset$inlined;
    final /* synthetic */ JsonArraySymbols $jsonArraySymbols$inlined;
    final /* synthetic */ KSerializer $serializer$inlined;
    private int index;
    final /* synthetic */ KotlinxSerializationJsonExtensions this$0;

    /* compiled from: Collect.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1", f = "KotlinxSerializationJsonExtensions.kt", i = {0, 0, 1}, l = {124, 127}, m = "emit", n = {"this", "value", "this"}, s = {"L$0", "L$1", "L$0"})
    /* renamed from: io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1$1, reason: invalid class name */
    public static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        public AnonymousClass1(Continuation continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.this.emit(null, this);
        }
    }

    public KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1(ByteWriteChannel byteWriteChannel, JsonArraySymbols jsonArraySymbols, KotlinxSerializationJsonExtensions kotlinxSerializationJsonExtensions, KSerializer kSerializer, Charset charset) {
        this.$channel$inlined = byteWriteChannel;
        this.$jsonArraySymbols$inlined = jsonArraySymbols;
        this.this$0 = kotlinxSerializationJsonExtensions;
        this.$serializer$inlined = kSerializer;
        this.$charset$inlined = charset;
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x00b2 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // kotlinx.coroutines.flow.FlowCollector
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object emit(T r8, kotlin.coroutines.Continuation<? super kotlin.Unit> r9) {
        /*
            r7 = this;
            boolean r0 = r9 instanceof io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1$1 r0 = (io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1$1 r0 = new io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L44
            if (r2 == r4) goto L3a
            if (r2 != r3) goto L32
            java.lang.Object r8 = r0.L$0
            io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1 r8 = (io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1) r8
            kotlin.ResultKt.throwOnFailure(r9)
            goto Lb3
        L32:
            java.lang.IllegalStateException r8 = new java.lang.IllegalStateException
            java.lang.String r9 = "call to 'resume' before 'invoke' with coroutine"
            r8.<init>(r9)
            throw r8
        L3a:
            java.lang.Object r8 = r0.L$1
            java.lang.Object r2 = r0.L$0
            io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1 r2 = (io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1) r2
            kotlin.ResultKt.throwOnFailure(r9)
            goto L6a
        L44:
            kotlin.ResultKt.throwOnFailure(r9)
            int r9 = r7.index
            int r2 = r9 + 1
            r7.index = r2
            if (r9 < 0) goto Lbb
            r2 = r0
            kotlin.coroutines.Continuation r2 = (kotlin.coroutines.Continuation) r2
            if (r9 <= 0) goto L6d
            io.ktor.utils.io.ByteWriteChannel r9 = r7.$channel$inlined
            io.ktor.serialization.kotlinx.json.JsonArraySymbols r2 = r7.$jsonArraySymbols$inlined
            byte[] r2 = r2.getObjectSeparator()
            r0.L$0 = r7
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r9 = io.ktor.utils.io.ByteWriteChannelKt.writeFully(r9, r2, r0)
            if (r9 != r1) goto L69
            return r1
        L69:
            r2 = r7
        L6a:
            r9 = r8
            r8 = r2
            goto L6f
        L6d:
            r9 = r8
            r8 = r7
        L6f:
            io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions r2 = r8.this$0
            kotlinx.serialization.json.Json r2 = io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions.access$getFormat$p(r2)
            kotlinx.serialization.KSerializer r4 = r8.$serializer$inlined
            kotlinx.serialization.SerializationStrategy r4 = (kotlinx.serialization.SerializationStrategy) r4
            java.lang.String r9 = r2.encodeToString(r4, r9)
            io.ktor.utils.io.ByteWriteChannel r2 = r8.$channel$inlined
            java.nio.charset.Charset r4 = r8.$charset$inlined
            java.nio.charset.Charset r5 = kotlin.text.Charsets.UTF_8
            boolean r4 = kotlin.jvm.internal.Intrinsics.areEqual(r4, r5)
            if (r4 == 0) goto L8e
            byte[] r9 = kotlin.text.StringsKt.encodeToByteArray(r9)
            goto La5
        L8e:
            java.nio.charset.Charset r4 = r8.$charset$inlined
            java.nio.charset.CharsetEncoder r4 = r4.newEncoder()
            java.lang.String r5 = "charset.newEncoder()"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r5)
            r5 = r9
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r6 = 0
            int r9 = r9.length()
            byte[] r9 = io.ktor.utils.io.charsets.CharsetJVMKt.encodeToByteArray(r4, r5, r6, r9)
        La5:
            r0.L$0 = r8
            r4 = 0
            r0.L$1 = r4
            r0.label = r3
            java.lang.Object r9 = io.ktor.utils.io.ByteWriteChannelKt.writeFully(r2, r9, r0)
            if (r9 != r1) goto Lb3
            return r1
        Lb3:
            io.ktor.utils.io.ByteWriteChannel r8 = r8.$channel$inlined
            r8.flush()
            kotlin.Unit r8 = kotlin.Unit.INSTANCE
            return r8
        Lbb:
            java.lang.ArithmeticException r8 = new java.lang.ArithmeticException
            java.lang.String r9 = "Index overflow has happened"
            r8.<init>(r9)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.serialization.kotlinx.json.KotlinxSerializationJsonExtensions$serialize$$inlined$collectIndexed$1.emit(java.lang.Object, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
