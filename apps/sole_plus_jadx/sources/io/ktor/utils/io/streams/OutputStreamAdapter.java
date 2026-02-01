package io.ktor.utils.io.streams;

import com.android.ddmlib.testrunner.IInstrumentationResultParser;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import io.ktor.utils.io.bits.MemoryJvmKt;
import io.ktor.utils.io.core.Output;
import io.ktor.utils.io.core.internal.ChunkBuffer;
import io.ktor.utils.io.pool.ObjectPool;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Output.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\u001b\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010\b\u001a\u00020\tH\u0014J-\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000eH\u0014ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u0012"}, d2 = {"Lio/ktor/utils/io/streams/OutputStreamAdapter;", "Lio/ktor/utils/io/core/Output;", "pool", "Lio/ktor/utils/io/pool/ObjectPool;", "Lio/ktor/utils/io/core/internal/ChunkBuffer;", IInstrumentationResultParser.StatusKeys.STREAM, "Ljava/io/OutputStream;", "(Lio/ktor/utils/io/pool/ObjectPool;Ljava/io/OutputStream;)V", "closeDestination", "", "flush", "source", "Lio/ktor/utils/io/bits/Memory;", "offset", "", SessionDescription.ATTR_LENGTH, "flush-62zg_DM", "(Ljava/nio/ByteBuffer;II)V", "ktor-io"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
final class OutputStreamAdapter extends Output {
    private final OutputStream stream;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OutputStreamAdapter(ObjectPool<ChunkBuffer> pool, OutputStream stream) {
        super(pool);
        Intrinsics.checkNotNullParameter(pool, "pool");
        Intrinsics.checkNotNullParameter(stream, "stream");
        this.stream = stream;
    }

    @Override // io.ktor.utils.io.core.Output
    /* renamed from: flush-62zg_DM */
    protected void mo8991flush62zg_DM(ByteBuffer source, int offset, int length) throws IOException {
        Intrinsics.checkNotNullParameter(source, "source");
        if (source.hasArray() && !source.isReadOnly()) {
            this.stream.write(source.array(), source.arrayOffset() + offset, length);
            return;
        }
        byte[] bArrBorrow = ByteArraysKt.getByteArrayPool().borrow();
        ByteBuffer byteBufferSliceSafe = MemoryJvmKt.sliceSafe(source, offset, length);
        while (true) {
            try {
                int iMin = Math.min(byteBufferSliceSafe.remaining(), bArrBorrow.length);
                if (iMin == 0) {
                    return;
                }
                byteBufferSliceSafe.get(bArrBorrow, 0, iMin);
                this.stream.write(bArrBorrow, 0, iMin);
            } finally {
                ByteArraysKt.getByteArrayPool().recycle(bArrBorrow);
            }
        }
    }

    @Override // io.ktor.utils.io.core.Output
    protected void closeDestination() throws IOException {
        this.stream.close();
    }
}
