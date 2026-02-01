package io.ktor.utils.io.bits;

import androidx.collection.SieveCacheKt;
import com.android.SdkConstants;
import com.google.android.exoplayer2.source.rtsp.SessionDescription;
import io.ktor.utils.io.core.internal.NumbersKt;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: MemoryJvm.kt */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0012\n\u0002\b\t\n\u0002\u0010\u0005\n\u0002\b\b\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\b\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\tø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0007\u0010\n\u001a7\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u000f\u001a7\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000e\u0010\u0010\u001a'\u0010\u0000\u001a\u00020\u0001*\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u0006ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0011\u0010\b\u001a/\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0017\u001a/\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u0015ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0016\u0010\u0018\u001a\r\u0010\u0019\u001a\u00020\u0004*\u00020\u0004H\u0082\b\u001a\r\u0010\u001a\u001a\u00020\u0004*\u00020\u0004H\u0082\b\u001a\u001c\u0010\u001b\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\u0006H\u0000\u001a\r\u0010\u001c\u001a\u00020\u0004*\u00020\u0004H\u0082\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\u001d"}, d2 = {"copyTo", "", "Lio/ktor/utils/io/bits/Memory;", "destination", "Ljava/nio/ByteBuffer;", "offset", "", "copyTo-62zg_DM", "(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;I)V", "", "(Ljava/nio/ByteBuffer;Ljava/nio/ByteBuffer;J)V", "", SessionDescription.ATTR_LENGTH, "destinationOffset", "copyTo-9zorpBc", "(Ljava/nio/ByteBuffer;[BIII)V", "(Ljava/nio/ByteBuffer;[BJII)V", "copyTo-SG11BkQ", SdkConstants.GRAVITY_VALUE_FILL, "count", "value", "", "fill-JT6ljtQ", "(Ljava/nio/ByteBuffer;IIB)V", "(Ljava/nio/ByteBuffer;JJB)V", "myDuplicate", "mySlice", "sliceSafe", "suppressNullCheck", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class MemoryJvmKt {
    private static final ByteBuffer suppressNullCheck(ByteBuffer byteBuffer) {
        return byteBuffer;
    }

    /* renamed from: copyTo-9zorpBc, reason: not valid java name */
    public static final void m8831copyTo9zorpBc(ByteBuffer copyTo, byte[] destination, int i, int i2, int i3) {
        Intrinsics.checkNotNullParameter(copyTo, "$this$copyTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (copyTo.hasArray() && !copyTo.isReadOnly()) {
            System.arraycopy(copyTo.array(), copyTo.arrayOffset() + i, destination, i3, i2);
        } else {
            copyTo.duplicate().get(destination, i3, i2);
        }
    }

    /* renamed from: copyTo-9zorpBc, reason: not valid java name */
    public static final void m8832copyTo9zorpBc(ByteBuffer copyTo, byte[] destination, long j, int i, int i2) {
        Intrinsics.checkNotNullParameter(copyTo, "$this$copyTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (j < SieveCacheKt.NodeLinkMask) {
            m8831copyTo9zorpBc(copyTo, destination, (int) j, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: copyTo-62zg_DM, reason: not valid java name */
    public static final void m8829copyTo62zg_DM(ByteBuffer copyTo, ByteBuffer destination, int i) {
        Intrinsics.checkNotNullParameter(copyTo, "$this$copyTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        int iRemaining = destination.remaining();
        if (copyTo.hasArray() && !copyTo.isReadOnly() && destination.hasArray() && !destination.isReadOnly()) {
            int iPosition = destination.position();
            System.arraycopy(copyTo.array(), copyTo.arrayOffset() + i, destination.array(), destination.arrayOffset() + iPosition, iRemaining);
            destination.position(iPosition + iRemaining);
        } else {
            ByteBuffer byteBufferDuplicate = copyTo.duplicate();
            byteBufferDuplicate.limit(iRemaining + i);
            byteBufferDuplicate.position(i);
            destination.put(byteBufferDuplicate);
        }
    }

    /* renamed from: copyTo-62zg_DM, reason: not valid java name */
    public static final void m8830copyTo62zg_DM(ByteBuffer copyTo, ByteBuffer destination, long j) {
        Intrinsics.checkNotNullParameter(copyTo, "$this$copyTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (j < SieveCacheKt.NodeLinkMask) {
            m8829copyTo62zg_DM(copyTo, destination, (int) j);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: copyTo-SG11BkQ, reason: not valid java name */
    public static final void m8833copyToSG11BkQ(ByteBuffer copyTo, ByteBuffer destination, int i) {
        Intrinsics.checkNotNullParameter(copyTo, "$this$copyTo");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (copyTo.hasArray() && !copyTo.isReadOnly()) {
            byte[] bArrArray = copyTo.array();
            Intrinsics.checkNotNullExpressionValue(bArrArray, "array()");
            int iArrayOffset = copyTo.arrayOffset() + copyTo.position();
            int iRemaining = copyTo.remaining();
            ByteBuffer byteBufferOrder = ByteBuffer.wrap(bArrArray, iArrayOffset, iRemaining).slice().order(ByteOrder.BIG_ENDIAN);
            Intrinsics.checkNotNullExpressionValue(byteBufferOrder, "wrap(this, offset, lengt…der(ByteOrder.BIG_ENDIAN)");
            Memory.m8813copyToJT6ljtQ(Memory.m8812constructorimpl(byteBufferOrder), destination, 0, iRemaining, i);
            copyTo.position(copyTo.limit());
            return;
        }
        sliceSafe(destination, i, copyTo.remaining()).put(copyTo);
    }

    private static final ByteBuffer myDuplicate(ByteBuffer byteBuffer) {
        ByteBuffer myDuplicate$lambda$1 = byteBuffer.duplicate();
        Intrinsics.checkNotNullExpressionValue(myDuplicate$lambda$1, "myDuplicate$lambda$1");
        return myDuplicate$lambda$1;
    }

    private static final ByteBuffer mySlice(ByteBuffer byteBuffer) {
        ByteBuffer mySlice$lambda$2 = byteBuffer.slice();
        Intrinsics.checkNotNullExpressionValue(mySlice$lambda$2, "mySlice$lambda$2");
        return mySlice$lambda$2;
    }

    /* renamed from: fill-JT6ljtQ, reason: not valid java name */
    public static final void m8835fillJT6ljtQ(ByteBuffer fill, long j, long j2, byte b) {
        Intrinsics.checkNotNullParameter(fill, "$this$fill");
        if (j >= SieveCacheKt.NodeLinkMask) {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
        int i = (int) j;
        if (j2 < SieveCacheKt.NodeLinkMask) {
            m8834fillJT6ljtQ(fill, i, (int) j2, b);
        } else {
            NumbersKt.failLongToIntConversion(j2, "count");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: fill-JT6ljtQ, reason: not valid java name */
    public static final void m8834fillJT6ljtQ(ByteBuffer fill, int i, int i2, byte b) {
        Intrinsics.checkNotNullParameter(fill, "$this$fill");
        int i3 = i2 + i;
        while (i < i3) {
            fill.put(i, b);
            i++;
        }
    }

    public static final ByteBuffer sliceSafe(ByteBuffer byteBuffer, int i, int i2) {
        Intrinsics.checkNotNullParameter(byteBuffer, "<this>");
        ByteBuffer myDuplicate$lambda$1 = byteBuffer.duplicate();
        Intrinsics.checkNotNullExpressionValue(myDuplicate$lambda$1, "myDuplicate$lambda$1");
        myDuplicate$lambda$1.position(i);
        myDuplicate$lambda$1.limit(i + i2);
        ByteBuffer mySlice$lambda$2 = myDuplicate$lambda$1.slice();
        Intrinsics.checkNotNullExpressionValue(mySlice$lambda$2, "mySlice$lambda$2");
        return mySlice$lambda$2;
    }
}
