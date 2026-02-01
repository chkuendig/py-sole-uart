package io.ktor.util;

import com.android.SdkConstants;
import io.ktor.utils.io.ByteReadChannel;
import io.ktor.utils.io.CoroutinesKt;
import io.ktor.utils.io.WriterScope;
import io.ktor.utils.io.pool.ObjectPool;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: EncodersJvm.kt */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\b\u001a\u00020\t*\u00020\u00052\u0006\u0010\n\u001a\u00020\u0005H\u0082\u0004\u001a\u001e\u0010\u000b\u001a\u00020\f*\u00020\r2\u0006\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\tH\u0002\u001a-\u0010\u0010\u001a\u00020\u0005*\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u0018\"\u0011\u0010\u0000\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u0011\u0010\u0006\u001a\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u0003\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u0019"}, d2 = {"Deflate", "Lio/ktor/util/Encoder;", "getDeflate", "()Lio/ktor/util/Encoder;", "GZIP_HEADER_SIZE", "", "GZip", "getGZip", "has", "", "flag", SdkConstants.INFLATE_METHOD, "Lio/ktor/utils/io/ByteReadChannel;", "Lkotlinx/coroutines/CoroutineScope;", "source", "gzip", "inflateTo", "Ljava/util/zip/Inflater;", "channel", "Lio/ktor/utils/io/ByteWriteChannel;", "buffer", "Ljava/nio/ByteBuffer;", "checksum", "Ljava/util/zip/Checksum;", "(Ljava/util/zip/Inflater;Lio/ktor/utils/io/ByteWriteChannel;Ljava/nio/ByteBuffer;Ljava/util/zip/Checksum;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "ktor-utils"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class EncodersJvmKt {
    private static final int GZIP_HEADER_SIZE = 10;
    private static final Encoder Deflate = new Encoder() { // from class: io.ktor.util.EncodersJvmKt$Deflate$1
        @Override // io.ktor.util.Encoder
        public ByteReadChannel encode(CoroutineScope coroutineScope, ByteReadChannel source) {
            Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
            Intrinsics.checkNotNullParameter(source, "source");
            return DeflaterKt.deflated$default(source, true, (ObjectPool) null, coroutineScope.getCoroutineContext(), 2, (Object) null);
        }

        @Override // io.ktor.util.Encoder
        public ByteReadChannel decode(CoroutineScope coroutineScope, ByteReadChannel source) {
            Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
            Intrinsics.checkNotNullParameter(source, "source");
            return EncodersJvmKt.inflate(coroutineScope, source, false);
        }
    };
    private static final Encoder GZip = new Encoder() { // from class: io.ktor.util.EncodersJvmKt$GZip$1
        @Override // io.ktor.util.Encoder
        public ByteReadChannel encode(CoroutineScope coroutineScope, ByteReadChannel source) {
            Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
            Intrinsics.checkNotNullParameter(source, "source");
            return DeflaterKt.deflated$default(source, true, (ObjectPool) null, coroutineScope.getCoroutineContext(), 2, (Object) null);
        }

        @Override // io.ktor.util.Encoder
        public ByteReadChannel decode(CoroutineScope coroutineScope, ByteReadChannel source) {
            Intrinsics.checkNotNullParameter(coroutineScope, "<this>");
            Intrinsics.checkNotNullParameter(source, "source");
            return EncodersJvmKt.inflate$default(coroutineScope, source, false, 2, null);
        }
    };

    /* compiled from: EncodersJvm.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.EncodersJvmKt", f = "EncodersJvm.kt", i = {0}, l = {157}, m = "inflateTo", n = {"inflated"}, s = {"I$0"})
    /* renamed from: io.ktor.util.EncodersJvmKt$inflateTo$1, reason: invalid class name and case insensitive filesystem */
    static final class C11691 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;

        C11691(Continuation<? super C11691> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return EncodersJvmKt.inflateTo(null, null, null, null, this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean has(int i, int i2) {
        return (i & i2) != 0;
    }

    public static final Encoder getDeflate() {
        return Deflate;
    }

    public static final Encoder getGZip() {
        return GZip;
    }

    static /* synthetic */ ByteReadChannel inflate$default(CoroutineScope coroutineScope, ByteReadChannel byteReadChannel, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        return inflate(coroutineScope, byteReadChannel, z);
    }

    /* compiled from: EncodersJvm.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lio/ktor/utils/io/WriterScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "io.ktor.util.EncodersJvmKt$inflate$1", f = "EncodersJvm.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6}, l = {68, 85, 161, 164, 103, 109, 121}, m = "invokeSuspend", n = {"$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "magic", "format", "flags", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "magic", "format", "flags", "extraLen", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "n$iv", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "totalSize", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "totalSize", "$this$writer", "readBuffer", "writeBuffer", "inflater", "checksum", "totalSize"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "S$0", "B$0", "B$1", "L$0", "L$1", "L$2", "L$3", "L$4", "S$0", "B$0", "B$1", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "J$0", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"})
    /* renamed from: io.ktor.util.EncodersJvmKt$inflate$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<WriterScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $gzip;
        final /* synthetic */ ByteReadChannel $source;
        byte B$0;
        byte B$1;
        int I$0;
        long J$0;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        short S$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(boolean z, ByteReadChannel byteReadChannel, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$gzip = z;
            this.$source = byteReadChannel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(this.$gzip, this.$source, continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(WriterScope writerScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(writerScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:28:0x0172  */
        /* JADX WARN: Removed duplicated region for block: B:34:0x01c0 A[RETURN] */
        /* JADX WARN: Removed duplicated region for block: B:35:0x01c1  */
        /* JADX WARN: Removed duplicated region for block: B:38:0x01cd  */
        /* JADX WARN: Removed duplicated region for block: B:39:0x01d8  */
        /* JADX WARN: Removed duplicated region for block: B:41:0x01ef  */
        /* JADX WARN: Removed duplicated region for block: B:44:0x01f7  */
        /* JADX WARN: Removed duplicated region for block: B:58:0x023b  */
        /* JADX WARN: Removed duplicated region for block: B:66:0x0289  */
        /* JADX WARN: Removed duplicated region for block: B:73:0x02b5 A[Catch: all -> 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:7:0x0036, B:98:0x037e, B:92:0x0350, B:94:0x0356, B:99:0x0396, B:101:0x039a, B:103:0x03a2, B:105:0x03c0, B:108:0x03c5, B:109:0x03ed, B:110:0x03ee, B:111:0x03f9, B:112:0x03fa, B:113:0x0420, B:114:0x0421, B:118:0x043b, B:119:0x0446, B:10:0x005d, B:87:0x0324, B:79:0x02ed, B:81:0x02f3, B:83:0x02f9, B:88:0x033d, B:71:0x02ad, B:73:0x02b5, B:76:0x02d3, B:78:0x02db, B:89:0x0342, B:91:0x034a, B:120:0x0447, B:13:0x007f), top: B:127:0x000d }] */
        /* JADX WARN: Removed duplicated region for block: B:78:0x02db A[Catch: all -> 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:7:0x0036, B:98:0x037e, B:92:0x0350, B:94:0x0356, B:99:0x0396, B:101:0x039a, B:103:0x03a2, B:105:0x03c0, B:108:0x03c5, B:109:0x03ed, B:110:0x03ee, B:111:0x03f9, B:112:0x03fa, B:113:0x0420, B:114:0x0421, B:118:0x043b, B:119:0x0446, B:10:0x005d, B:87:0x0324, B:79:0x02ed, B:81:0x02f3, B:83:0x02f9, B:88:0x033d, B:71:0x02ad, B:73:0x02b5, B:76:0x02d3, B:78:0x02db, B:89:0x0342, B:91:0x034a, B:120:0x0447, B:13:0x007f), top: B:127:0x000d }] */
        /* JADX WARN: Removed duplicated region for block: B:81:0x02f3 A[Catch: all -> 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:7:0x0036, B:98:0x037e, B:92:0x0350, B:94:0x0356, B:99:0x0396, B:101:0x039a, B:103:0x03a2, B:105:0x03c0, B:108:0x03c5, B:109:0x03ed, B:110:0x03ee, B:111:0x03f9, B:112:0x03fa, B:113:0x0420, B:114:0x0421, B:118:0x043b, B:119:0x0446, B:10:0x005d, B:87:0x0324, B:79:0x02ed, B:81:0x02f3, B:83:0x02f9, B:88:0x033d, B:71:0x02ad, B:73:0x02b5, B:76:0x02d3, B:78:0x02db, B:89:0x0342, B:91:0x034a, B:120:0x0447, B:13:0x007f), top: B:127:0x000d }] */
        /* JADX WARN: Removed duplicated region for block: B:89:0x0342 A[Catch: all -> 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:7:0x0036, B:98:0x037e, B:92:0x0350, B:94:0x0356, B:99:0x0396, B:101:0x039a, B:103:0x03a2, B:105:0x03c0, B:108:0x03c5, B:109:0x03ed, B:110:0x03ee, B:111:0x03f9, B:112:0x03fa, B:113:0x0420, B:114:0x0421, B:118:0x043b, B:119:0x0446, B:10:0x005d, B:87:0x0324, B:79:0x02ed, B:81:0x02f3, B:83:0x02f9, B:88:0x033d, B:71:0x02ad, B:73:0x02b5, B:76:0x02d3, B:78:0x02db, B:89:0x0342, B:91:0x034a, B:120:0x0447, B:13:0x007f), top: B:127:0x000d }] */
        /* JADX WARN: Removed duplicated region for block: B:94:0x0356 A[Catch: all -> 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:7:0x0036, B:98:0x037e, B:92:0x0350, B:94:0x0356, B:99:0x0396, B:101:0x039a, B:103:0x03a2, B:105:0x03c0, B:108:0x03c5, B:109:0x03ed, B:110:0x03ee, B:111:0x03f9, B:112:0x03fa, B:113:0x0420, B:114:0x0421, B:118:0x043b, B:119:0x0446, B:10:0x005d, B:87:0x0324, B:79:0x02ed, B:81:0x02f3, B:83:0x02f9, B:88:0x033d, B:71:0x02ad, B:73:0x02b5, B:76:0x02d3, B:78:0x02db, B:89:0x0342, B:91:0x034a, B:120:0x0447, B:13:0x007f), top: B:127:0x000d }] */
        /* JADX WARN: Removed duplicated region for block: B:99:0x0396 A[Catch: all -> 0x0086, TryCatch #0 {all -> 0x0086, blocks: (B:7:0x0036, B:98:0x037e, B:92:0x0350, B:94:0x0356, B:99:0x0396, B:101:0x039a, B:103:0x03a2, B:105:0x03c0, B:108:0x03c5, B:109:0x03ed, B:110:0x03ee, B:111:0x03f9, B:112:0x03fa, B:113:0x0420, B:114:0x0421, B:118:0x043b, B:119:0x0446, B:10:0x005d, B:87:0x0324, B:79:0x02ed, B:81:0x02f3, B:83:0x02f9, B:88:0x033d, B:71:0x02ad, B:73:0x02b5, B:76:0x02d3, B:78:0x02db, B:89:0x0342, B:91:0x034a, B:120:0x0447, B:13:0x007f), top: B:127:0x000d }] */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:77:0x02d9 -> B:71:0x02ad). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:78:0x02db -> B:79:0x02ed). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:86:0x031f -> B:87:0x0324). Please report as a decompilation issue!!! */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:97:0x037c -> B:98:0x037e). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r19) throws java.io.EOFException {
            /*
                Method dump skipped, instructions count: 1140
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.EncodersJvmKt.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ByteReadChannel inflate(CoroutineScope coroutineScope, ByteReadChannel byteReadChannel, boolean z) {
        return CoroutinesKt.writer$default(coroutineScope, (CoroutineContext) null, false, (Function2) new AnonymousClass1(z, byteReadChannel, null), 3, (Object) null).getChannel();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object inflateTo(java.util.zip.Inflater r5, io.ktor.utils.io.ByteWriteChannel r6, java.nio.ByteBuffer r7, java.util.zip.Checksum r8, kotlin.coroutines.Continuation<? super java.lang.Integer> r9) throws java.util.zip.DataFormatException {
        /*
            boolean r0 = r9 instanceof io.ktor.util.EncodersJvmKt.C11691
            if (r0 == 0) goto L14
            r0 = r9
            io.ktor.util.EncodersJvmKt$inflateTo$1 r0 = (io.ktor.util.EncodersJvmKt.C11691) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            io.ktor.util.EncodersJvmKt$inflateTo$1 r0 = new io.ktor.util.EncodersJvmKt$inflateTo$1
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            int r5 = r0.I$0
            kotlin.ResultKt.throwOnFailure(r9)
            goto L63
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r6 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r6)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r9)
            r7.clear()
            byte[] r9 = r7.array()
            int r2 = r7.position()
            int r4 = r7.remaining()
            int r5 = r5.inflate(r9, r2, r4)
            int r9 = r7.position()
            int r9 = r9 + r5
            r7.position(r9)
            r7.flip()
            io.ktor.util.DeflaterKt.updateKeepPosition(r8, r7)
            r0.I$0 = r5
            r0.label = r3
            java.lang.Object r6 = r6.writeFully(r7, r0)
            if (r6 != r1) goto L63
            return r1
        L63:
            java.lang.Integer r5 = kotlin.coroutines.jvm.internal.Boxing.boxInt(r5)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: io.ktor.util.EncodersJvmKt.inflateTo(java.util.zip.Inflater, io.ktor.utils.io.ByteWriteChannel, java.nio.ByteBuffer, java.util.zip.Checksum, kotlin.coroutines.Continuation):java.lang.Object");
    }
}
