package io.ktor.utils.io.streams;

import com.android.SdkConstants;
import com.android.ddmlib.testrunner.IInstrumentationResultParser;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import io.ktor.utils.io.bits.Memory;
import io.ktor.utils.io.core.Input;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: Input.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0000\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014J-\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lio/ktor/utils/io/streams/InputStreamAsInput;", "Lio/ktor/utils/io/core/Input;", IInstrumentationResultParser.StatusKeys.STREAM, "Ljava/io/InputStream;", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", "(Ljava/io/InputStream;Lio/ktor/utils/io/pool/ObjectPool;)V", "closeSource", "", SdkConstants.GRAVITY_VALUE_FILL, "", "destination", "Lio/ktor/utils/io/bits/Memory;", "offset", SessionDescription.ATTR_LENGTH, "fill-62zg_DM", "(Ljava/nio/ByteBuffer;II)I", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class InputStreamAsInput extends Input {
    private final InputStream stream;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public InputStreamAsInput(InputStream stream, ObjectPool<ChunkBuffer> pool) {
        super(null, 0L, pool, 3, null);
        Intrinsics.checkNotNullParameter(stream, "stream");
        Intrinsics.checkNotNullParameter(pool, "pool");
        this.stream = stream;
    }

    @Override // io.ktor.utils.io.core.Input
    /* renamed from: fill-62zg_DM */
    protected int mo8992fill62zg_DM(ByteBuffer destination, int offset, int length) {
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (destination.hasArray() && !destination.isReadOnly()) {
            return RangesKt.coerceAtLeast(this.stream.read(destination.array(), destination.arrayOffset() + offset, length), 0);
        }
        byte[] bArrBorrow = ByteArraysKt.getByteArrayPool().borrow();
        try {
            int i = this.stream.read(bArrBorrow, 0, Math.min(bArrBorrow.length, length));
            if (i == -1) {
                return 0;
            }
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArrBorrow, 0, i).slice().order(ByteOrder.BIG_ENDIAN);
            Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
            Memory.m8813copyToJT6ljtQ(Memory.m8812constructorimpl(byteBufferOrder), destination, 0, i, offset);
            return i;
        } finally {
            ByteArraysKt.getByteArrayPool().recycle(bArrBorrow);
        }
    }

    @Override // io.ktor.utils.io.core.Input
    protected void closeSource() throws IOException {
        this.stream.close();
    }
}
