package io.ktor.utils.io.core;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import org.objectweb.asm.Opcodes;

/* compiled from: ByteReadPacketExtensions.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0014\b\u0002\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005\u001a>\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\n2\u0014\b\u0004\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0086\bø\u0001\u0000\u001a*\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u0005H\u0002\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010"}, d2 = {"ByteReadPacket", "Lio/ktor/utils/io/core/ByteReadPacket;", "bb", "Ljava/nio/ByteBuffer;", "release", "Lkotlin/Function1;", "", "array", "", "offset", "", SessionDescription.ATTR_LENGTH, "block", "poolFor", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ByteReadPacketExtensionsKt {

    /* compiled from: ByteReadPacketExtensions.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "it", "Ljava/nio/ByteBuffer;", "invoke"}, k = 3, mv = {1, 8, 0}, xi = Opcodes.ARETURN)
    /* renamed from: io.ktor.utils.io.core.ByteReadPacketExtensionsKt$ByteReadPacket$1, reason: invalid class name */
    public static final class AnonymousClass1 extends Lambda implements Function1<ByteBuffer, Unit> {
        final /* synthetic */ byte[] $array;
        final /* synthetic */ Function1<byte[], Unit> $block;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        public AnonymousClass1(Function1<? super byte[], Unit> function1, byte[] bArr) {
            super(1);
            this.$block = function1;
            this.$array = bArr;
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(ByteBuffer byteBuffer) {
            invoke2(byteBuffer);
            return Unit.INSTANCE;
        }

        /* renamed from: invoke, reason: avoid collision after fix types in other method */
        public final void invoke2(ByteBuffer it) {
            Intrinsics.checkNotNullParameter(it, "it");
            this.$block.invoke(this.$array);
        }
    }

    public static final ByteReadPacket ByteReadPacket(byte[] array, int i, int i2, Function1<? super byte[], Unit> block) {
        Intrinsics.checkNotNullParameter(array, "array");
        Intrinsics.checkNotNullParameter(block, "block");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(array, i, i2);
        Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(array, offset, length)");
        return ByteReadPacket(byteBufferWrap, new AnonymousClass1(block, array));
    }

    public static /* synthetic */ ByteReadPacket ByteReadPacket$default(ByteBuffer byteBuffer, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function1 = new Function1<ByteBuffer, Unit>() { // from class: io.ktor.utils.io.core.ByteReadPacketExtensionsKt.ByteReadPacket.2
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ByteBuffer it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(ByteBuffer byteBuffer2) {
                    invoke2(byteBuffer2);
                    return Unit.INSTANCE;
                }
            };
        }
        return ByteReadPacket(byteBuffer, function1);
    }

    public static final ByteReadPacket ByteReadPacket(ByteBuffer bb, Function1<? super ByteBuffer, Unit> release) {
        Intrinsics.checkNotNullParameter(bb, "bb");
        Intrinsics.checkNotNullParameter(release, "release");
        ObjectPool<ChunkBuffer> objectPoolPoolFor = poolFor(bb, release);
        ChunkBuffer chunkBufferBorrow = objectPoolPoolFor.borrow();
        chunkBufferBorrow.resetForRead();
        return new ByteReadPacket(chunkBufferBorrow, objectPoolPoolFor);
    }

    private static final ObjectPool<ChunkBuffer> poolFor(ByteBuffer byteBuffer, Function1<? super ByteBuffer, Unit> function1) {
        return new SingleByteBufferPool(byteBuffer, function1);
    }

    public static /* synthetic */ ByteReadPacket ByteReadPacket$default(byte[] array, int i, int i2, Function1 block, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = array.length;
        }
        Intrinsics.checkNotNullParameter(array, "array");
        Intrinsics.checkNotNullParameter(block, "block");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(array, i, i2);
        Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(array, offset, length)");
        return ByteReadPacket(byteBufferWrap, new AnonymousClass1(block, array));
    }
}
