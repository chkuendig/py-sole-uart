package io.ktor.utils.io;

import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import io.ktor.utils.io.pool.ObjectPool;
import java.nio.ByteBuffer;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ByteChannel.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0003\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u001a\u0010\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u001a(\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u0016\u0010\u0004\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0006\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0005\u001a\u000e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n\u001a\u001e\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r¨\u0006\u000f"}, d2 = {"ByteChannel", "Lio/ktor/utils/io/ByteChannel;", "autoFlush", "", "exceptionMapper", "Lkotlin/Function1;", "", "ByteReadChannel", "Lio/ktor/utils/io/ByteReadChannel;", "content", "Ljava/nio/ByteBuffer;", "", "offset", "", SessionDescription.ATTR_LENGTH, "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class ByteChannelKt {
    public static final ByteReadChannel ByteReadChannel(ByteBuffer content) {
        Intrinsics.checkNotNullParameter(content, "content");
        return new ByteBufferChannel(content);
    }

    public static final ByteChannel ByteChannel(boolean z) {
        return new ByteBufferChannel(z, null, 0, 6, null);
    }

    public static /* synthetic */ ByteChannel ByteChannel$default(boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return ByteChannel(z);
    }

    public static final ByteReadChannel ByteReadChannel(byte[] content, int i, int i2) {
        Intrinsics.checkNotNullParameter(content, "content");
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(content, i, i2);
        Intrinsics.checkNotNullExpressionValue(byteBufferWrap, "wrap(content, offset, length)");
        return new ByteBufferChannel(byteBufferWrap);
    }

    public static /* synthetic */ ByteChannel ByteChannel$default(boolean z, Function1 function1, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return ByteChannel(z, function1);
    }

    public static final ByteChannel ByteChannel(boolean z, final Function1<? super Throwable, ? extends Throwable> exceptionMapper) {
        Intrinsics.checkNotNullParameter(exceptionMapper, "exceptionMapper");
        return new ByteBufferChannel(z) { // from class: io.ktor.utils.io.ByteChannelKt.ByteChannel.1
            /* JADX WARN: Multi-variable type inference failed */
            {
                int i = 6;
                DefaultConstructorMarker defaultConstructorMarker = null;
                ObjectPool objectPool = null;
                int i2 = 0;
            }

            @Override // io.ktor.utils.io.ByteBufferChannel, io.ktor.utils.io.ByteWriteChannel
            public boolean close(Throwable cause) {
                return super.close(exceptionMapper.invoke(cause));
            }
        };
    }
}
