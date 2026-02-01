package io.ktor.utils.io;

import io.ktor.utils.io.core.ByteOrder;
import io.ktor.utils.io.core.BytePacketBuilder;
import io.ktor.utils.io.core.ByteReadPacket;
import io.ktor.utils.io.core.StringsKt;
import java.nio.charset.Charset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteWriteChannel.kt */
@Metadata(d1 = {"\u0000h\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\f\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u001d\u0010\u0003\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\b\u001a\u00020\t*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0001H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u000b\u001a\u001d\u0010\f\u001a\u00020\t*\u00020\u00022\u0006\u0010\n\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a\u001d\u0010\u000e\u001a\u00020\t*\u00020\u00022\u0006\u0010\u000f\u001a\u00020\u0010H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0011\u001a\u001d\u0010\u0012\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0007\u001a\u001d\u0010\u0013\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u0015H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0016\u001a%\u0010\u0013\u001a\u00020\t*\u00020\u00022\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\u0019\u001a.\u0010\u001a\u001a\u00020\t*\u00020\u00022\u0017\u0010\u001b\u001a\u0013\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\t0\u001c¢\u0006\u0002\b\u001eH\u0086Hø\u0001\u0000¢\u0006\u0002\u0010\u001f\u001a>\u0010 \u001a\u00020\t*\u00020\u00022'\u0010\u001b\u001a#\b\u0001\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\t0\"\u0012\u0006\u0012\u0004\u0018\u00010#0!¢\u0006\u0002\b\u001eH\u0086@ø\u0001\u0000¢\u0006\u0002\u0010$\u001a\u001d\u0010%\u001a\u00020\t*\u00020\u00022\u0006\u0010&\u001a\u00020\u0004H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010\r\u001a%\u0010%\u001a\u00020\t*\u00020\u00022\u0006\u0010&\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u0018H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010'\u001a\u001d\u0010(\u001a\u00020\t*\u00020\u00022\u0006\u0010&\u001a\u00020)H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010*\u001a\u001d\u0010(\u001a\u00020\t*\u00020\u00022\u0006\u0010&\u001a\u00020+H\u0086@ø\u0001\u0000¢\u0006\u0002\u0010,\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006-"}, d2 = {"close", "", "Lio/ktor/utils/io/ByteWriteChannel;", "writeAvailable", "", "src", "", "(Lio/ktor/utils/io/ByteWriteChannel;[BLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeBoolean", "", "b", "(Lio/ktor/utils/io/ByteWriteChannel;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeByte", "(Lio/ktor/utils/io/ByteWriteChannel;ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeChar", "ch", "", "(Lio/ktor/utils/io/ByteWriteChannel;CLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeFully", "writeInt", "i", "", "(Lio/ktor/utils/io/ByteWriteChannel;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "byteOrder", "Lio/ktor/utils/io/core/ByteOrder;", "(Lio/ktor/utils/io/ByteWriteChannel;JLio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writePacket", "builder", "Lkotlin/Function1;", "Lio/ktor/utils/io/core/BytePacketBuilder;", "Lkotlin/ExtensionFunctionType;", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writePacketSuspend", "Lkotlin/Function2;", "Lkotlin/coroutines/Continuation;", "", "(Lio/ktor/utils/io/ByteWriteChannel;Lkotlin/jvm/functions/Function2;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeShort", "s", "(Lio/ktor/utils/io/ByteWriteChannel;ILio/ktor/utils/io/core/ByteOrder;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "writeStringUtf8", "", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/lang/CharSequence;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "", "(Lio/ktor/utils/io/ByteWriteChannel;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ByteWriteChannelKt {

    /* compiled from: ByteWriteChannel.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.utils.io.ByteWriteChannelKt", f = "ByteWriteChannel.kt", i = {0}, l = {199, 199}, m = "writePacketSuspend", n = {"builder$iv"}, s = {"L$0"})
    /* renamed from: io.ktor.utils.io.ByteWriteChannelKt$writePacketSuspend$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return ByteWriteChannelKt.writePacketSuspend(null, null, this);
        }
    }

    public static final Object writeAvailable(ByteWriteChannel byteWriteChannel, byte[] bArr, Continuation<? super Integer> continuation) {
        return byteWriteChannel.writeAvailable(bArr, 0, bArr.length, continuation);
    }

    public static final Object writeFully(ByteWriteChannel byteWriteChannel, byte[] bArr, Continuation<? super Unit> continuation) {
        Object objWriteFully = byteWriteChannel.writeFully(bArr, 0, bArr.length, continuation);
        return objWriteFully == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteFully : Unit.INSTANCE;
    }

    public static final Object writeShort(ByteWriteChannel byteWriteChannel, int i, Continuation<? super Unit> continuation) {
        Object objWriteShort = byteWriteChannel.writeShort((short) (i & 65535), continuation);
        return objWriteShort == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteShort : Unit.INSTANCE;
    }

    public static final Object writeShort(ByteWriteChannel byteWriteChannel, int i, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        Object objWriteShort = ChannelLittleEndianKt.writeShort(byteWriteChannel, (short) (i & 65535), byteOrder, continuation);
        return objWriteShort == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteShort : Unit.INSTANCE;
    }

    public static final Object writeByte(ByteWriteChannel byteWriteChannel, int i, Continuation<? super Unit> continuation) {
        Object objWriteByte = byteWriteChannel.writeByte((byte) (i & 255), continuation);
        return objWriteByte == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteByte : Unit.INSTANCE;
    }

    public static final Object writeInt(ByteWriteChannel byteWriteChannel, long j, Continuation<? super Unit> continuation) {
        Object objWriteInt = byteWriteChannel.writeInt((int) j, continuation);
        return objWriteInt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteInt : Unit.INSTANCE;
    }

    public static final Object writeInt(ByteWriteChannel byteWriteChannel, long j, ByteOrder byteOrder, Continuation<? super Unit> continuation) {
        Object objWriteInt = ChannelLittleEndianKt.writeInt(byteWriteChannel, (int) j, byteOrder, continuation);
        return objWriteInt == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteInt : Unit.INSTANCE;
    }

    public static final boolean close(ByteWriteChannel byteWriteChannel) {
        Intrinsics.checkNotNullParameter(byteWriteChannel, "<this>");
        return byteWriteChannel.close(null);
    }

    public static final Object writeBoolean(ByteWriteChannel byteWriteChannel, boolean z, Continuation<? super Unit> continuation) {
        Object objWriteByte = byteWriteChannel.writeByte(z ? (byte) 1 : (byte) 0, continuation);
        return objWriteByte == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteByte : Unit.INSTANCE;
    }

    public static final Object writeChar(ByteWriteChannel byteWriteChannel, char c, Continuation<? super Unit> continuation) {
        Object objWriteShort = writeShort(byteWriteChannel, c, continuation);
        return objWriteShort == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWriteShort : Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object writePacketSuspend(io.ktor.utils.io.ByteWriteChannel r6, kotlin.jvm.functions.Function2<? super io.ktor.utils.io.core.BytePacketBuilder, ? super kotlin.coroutines.Continuation<? super kotlin.Unit>, ? extends java.lang.Object> r7, kotlin.coroutines.Continuation<? super kotlin.Unit> r8) throws java.lang.Throwable {
        /*
            boolean r0 = r8 instanceof io.ktor.utils.io.ByteWriteChannelKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r8
            io.ktor.utils.io.ByteWriteChannelKt$writePacketSuspend$1 r0 = (io.ktor.utils.io.ByteWriteChannelKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r8 = r0.label
            int r8 = r8 - r2
            r0.label = r8
            goto L19
        L14:
            io.ktor.utils.io.ByteWriteChannelKt$writePacketSuspend$1 r0 = new io.ktor.utils.io.ByteWriteChannelKt$writePacketSuspend$1
            r0.<init>(r8)
        L19:
            java.lang.Object r8 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L44
            if (r2 == r4) goto L36
            if (r2 != r3) goto L2e
            kotlin.ResultKt.throwOnFailure(r8)
            goto L6b
        L2e:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L36:
            java.lang.Object r6 = r0.L$1
            io.ktor.utils.io.ByteWriteChannel r6 = (io.ktor.utils.io.ByteWriteChannel) r6
            java.lang.Object r7 = r0.L$0
            io.ktor.utils.io.core.BytePacketBuilder r7 = (io.ktor.utils.io.core.BytePacketBuilder) r7
            kotlin.ResultKt.throwOnFailure(r8)     // Catch: java.lang.Throwable -> L42
            goto L5a
        L42:
            r6 = move-exception
            goto L70
        L44:
            kotlin.ResultKt.throwOnFailure(r8)
            io.ktor.utils.io.core.BytePacketBuilder r8 = new io.ktor.utils.io.core.BytePacketBuilder
            r8.<init>(r5, r4, r5)
            r0.L$0 = r8     // Catch: java.lang.Throwable -> L6e
            r0.L$1 = r6     // Catch: java.lang.Throwable -> L6e
            r0.label = r4     // Catch: java.lang.Throwable -> L6e
            java.lang.Object r7 = r7.invoke(r8, r0)     // Catch: java.lang.Throwable -> L6e
            if (r7 != r1) goto L59
            return r1
        L59:
            r7 = r8
        L5a:
            io.ktor.utils.io.core.ByteReadPacket r7 = r7.build()     // Catch: java.lang.Throwable -> L42
            r0.L$0 = r5
            r0.L$1 = r5
            r0.label = r3
            java.lang.Object r6 = r6.writePacket(r7, r0)
            if (r6 != r1) goto L6b
            return r1
        L6b:
            kotlin.Unit r6 = kotlin.Unit.INSTANCE
            return r6
        L6e:
            r6 = move-exception
            r7 = r8
        L70:
            r7.release()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.utils.io.ByteWriteChannelKt.writePacketSuspend(io.ktor.utils.io.ByteWriteChannel, kotlin.jvm.functions.Function2, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object writeStringUtf8(ByteWriteChannel byteWriteChannel, CharSequence charSequence, Continuation<? super Unit> continuation) {
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, 0 == true ? 1 : 0);
        try {
            StringsKt.writeText$default(bytePacketBuilder, charSequence, 0, 0, (Charset) null, 14, (Object) null);
            Object objWritePacket = byteWriteChannel.writePacket(bytePacketBuilder.build(), continuation);
            return objWritePacket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWritePacket : Unit.INSTANCE;
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object writeStringUtf8(ByteWriteChannel byteWriteChannel, String str, Continuation<? super Unit> continuation) {
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, 0 == true ? 1 : 0);
        try {
            StringsKt.writeText$default(bytePacketBuilder, str, 0, 0, (Charset) null, 14, (Object) null);
            Object objWritePacket = byteWriteChannel.writePacket(bytePacketBuilder.build(), continuation);
            return objWritePacket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWritePacket : Unit.INSTANCE;
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Object writePacket(ByteWriteChannel byteWriteChannel, Function1<? super BytePacketBuilder, Unit> function1, Continuation<? super Unit> continuation) {
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, 0 == true ? 1 : 0);
        try {
            function1.invoke(bytePacketBuilder);
            Object objWritePacket = byteWriteChannel.writePacket(bytePacketBuilder.build(), continuation);
            return objWritePacket == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objWritePacket : Unit.INSTANCE;
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final Object writePacket$$forInline(ByteWriteChannel byteWriteChannel, Function1<? super BytePacketBuilder, Unit> function1, Continuation<? super Unit> continuation) {
        BytePacketBuilder bytePacketBuilder = new BytePacketBuilder(null, 1, 0 == true ? 1 : 0);
        try {
            function1.invoke(bytePacketBuilder);
            ByteReadPacket byteReadPacketBuild = bytePacketBuilder.build();
            InlineMarker.mark(0);
            byteWriteChannel.writePacket(byteReadPacketBuild, continuation);
            InlineMarker.mark(1);
            return Unit.INSTANCE;
        } catch (Throwable th) {
            bytePacketBuilder.release();
            throw th;
        }
    }
}
