package io.ktor.utils.io.bits;

import androidx.collection.SieveCacheKt;
import io.ktor.utils.io.core.internal.NumbersKt;
import java.nio.ByteBuffer;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: PrimitiveArraysJvm.kt */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0013\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0010\u0016\n\u0002\b\u0004\n\u0002\u0010\u0017\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0000\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\n\u001a;\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\t\u0010\f\u001a;\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u000e2\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0010\u001a;\u0010\r\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u000e2\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u000f\u0010\u0011\u001a;\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00132\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0015\u001a;\u0010\u0012\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00132\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0014\u0010\u0016\u001a;\u0010\u0017\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001a\u001a;\u0010\u0017\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u00182\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0019\u0010\u001b\u001a;\u0010\u001c\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u001d2\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010\u001f\u001a;\u0010\u001c\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\u0005\u001a\u00020\u001d2\b\b\u0002\u0010\u0007\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u001e\u0010 \u001a;\u0010!\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\n\u001a;\u0010!\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00062\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b$\u0010\f\u001a;\u0010%\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010\u0010\u001a;\u0010%\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u000e2\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b&\u0010\u0011\u001a;\u0010'\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010\u0015\u001a;\u0010'\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00132\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b(\u0010\u0016\u001a;\u0010)\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010\u001a\u001a;\u0010)\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00182\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b*\u0010\u001b\u001a;\u0010+\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u001d2\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010\u001f\u001a;\u0010+\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u001d2\b\b\u0002\u0010#\u001a\u00020\u00042\b\b\u0002\u0010\b\u001a\u00020\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b,\u0010 \u001a\u0015\u0010-\u001a\u00020.*\u00020.2\u0006\u0010\u0003\u001a\u00020\u0004H\u0082\b\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006/"}, d2 = {"loadDoubleArray", "", "Lio/ktor/utils/io/bits/Memory;", "offset", "", "destination", "", "destinationOffset", "count", "loadDoubleArray-9zorpBc", "(Ljava/nio/ByteBuffer;I[DII)V", "", "(Ljava/nio/ByteBuffer;J[DII)V", "loadFloatArray", "", "loadFloatArray-9zorpBc", "(Ljava/nio/ByteBuffer;I[FII)V", "(Ljava/nio/ByteBuffer;J[FII)V", "loadIntArray", "", "loadIntArray-9zorpBc", "(Ljava/nio/ByteBuffer;I[III)V", "(Ljava/nio/ByteBuffer;J[III)V", "loadLongArray", "", "loadLongArray-9zorpBc", "(Ljava/nio/ByteBuffer;I[JII)V", "(Ljava/nio/ByteBuffer;J[JII)V", "loadShortArray", "", "loadShortArray-9zorpBc", "(Ljava/nio/ByteBuffer;I[SII)V", "(Ljava/nio/ByteBuffer;J[SII)V", "storeDoubleArray", "source", "sourceOffset", "storeDoubleArray-9zorpBc", "storeFloatArray", "storeFloatArray-9zorpBc", "storeIntArray", "storeIntArray-9zorpBc", "storeLongArray", "storeLongArray-9zorpBc", "storeShortArray", "storeShortArray-9zorpBc", "withOffset", "Ljava/nio/ByteBuffer;", "ktor-io"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class PrimitiveArraysJvmKt {
    /* renamed from: loadShortArray-9zorpBc, reason: not valid java name */
    public static final void m8933loadShortArray9zorpBc(ByteBuffer loadShortArray, long j, short[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(loadShortArray, "$this$loadShortArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (j < SieveCacheKt.NodeLinkMask) {
            m8932loadShortArray9zorpBc(loadShortArray, (int) j, destination, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: loadIntArray-9zorpBc, reason: not valid java name */
    public static final void m8925loadIntArray9zorpBc(ByteBuffer loadIntArray, long j, int[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(loadIntArray, "$this$loadIntArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (j < SieveCacheKt.NodeLinkMask) {
            m8924loadIntArray9zorpBc(loadIntArray, (int) j, destination, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: loadShortArray-9zorpBc$default, reason: not valid java name */
    public static /* synthetic */ void m8934loadShortArray9zorpBc$default(ByteBuffer byteBuffer, int i, short[] sArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = sArr.length - i2;
        }
        m8932loadShortArray9zorpBc(byteBuffer, i, sArr, i2, i3);
    }

    /* renamed from: loadLongArray-9zorpBc, reason: not valid java name */
    public static final void m8929loadLongArray9zorpBc(ByteBuffer loadLongArray, long j, long[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(loadLongArray, "$this$loadLongArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (j < SieveCacheKt.NodeLinkMask) {
            m8928loadLongArray9zorpBc(loadLongArray, (int) j, destination, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: loadShortArray-9zorpBc$default, reason: not valid java name */
    public static /* synthetic */ void m8935loadShortArray9zorpBc$default(ByteBuffer byteBuffer, long j, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = sArr.length - i4;
        }
        m8933loadShortArray9zorpBc(byteBuffer, j, sArr, i4, i2);
    }

    /* renamed from: loadFloatArray-9zorpBc, reason: not valid java name */
    public static final void m8921loadFloatArray9zorpBc(ByteBuffer loadFloatArray, long j, float[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(loadFloatArray, "$this$loadFloatArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (j < SieveCacheKt.NodeLinkMask) {
            m8920loadFloatArray9zorpBc(loadFloatArray, (int) j, destination, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: loadIntArray-9zorpBc$default, reason: not valid java name */
    public static /* synthetic */ void m8926loadIntArray9zorpBc$default(ByteBuffer byteBuffer, int i, int[] iArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = iArr.length - i2;
        }
        m8924loadIntArray9zorpBc(byteBuffer, i, iArr, i2, i3);
    }

    /* renamed from: loadDoubleArray-9zorpBc, reason: not valid java name */
    public static final void m8917loadDoubleArray9zorpBc(ByteBuffer loadDoubleArray, long j, double[] destination, int i, int i2) {
        Intrinsics.checkNotNullParameter(loadDoubleArray, "$this$loadDoubleArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        if (j < SieveCacheKt.NodeLinkMask) {
            m8916loadDoubleArray9zorpBc(loadDoubleArray, (int) j, destination, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: loadIntArray-9zorpBc$default, reason: not valid java name */
    public static /* synthetic */ void m8927loadIntArray9zorpBc$default(ByteBuffer byteBuffer, long j, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = iArr.length - i4;
        }
        m8925loadIntArray9zorpBc(byteBuffer, j, iArr, i4, i2);
    }

    /* renamed from: storeShortArray-9zorpBc, reason: not valid java name */
    public static final void m8953storeShortArray9zorpBc(ByteBuffer storeShortArray, long j, short[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(storeShortArray, "$this$storeShortArray");
        Intrinsics.checkNotNullParameter(source, "source");
        if (j < SieveCacheKt.NodeLinkMask) {
            m8952storeShortArray9zorpBc(storeShortArray, (int) j, source, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: loadLongArray-9zorpBc$default, reason: not valid java name */
    public static /* synthetic */ void m8930loadLongArray9zorpBc$default(ByteBuffer byteBuffer, int i, long[] jArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = jArr.length - i2;
        }
        m8928loadLongArray9zorpBc(byteBuffer, i, jArr, i2, i3);
    }

    /* renamed from: storeIntArray-9zorpBc, reason: not valid java name */
    public static final void m8945storeIntArray9zorpBc(ByteBuffer storeIntArray, long j, int[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(storeIntArray, "$this$storeIntArray");
        Intrinsics.checkNotNullParameter(source, "source");
        if (j < SieveCacheKt.NodeLinkMask) {
            m8944storeIntArray9zorpBc(storeIntArray, (int) j, source, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: loadLongArray-9zorpBc$default, reason: not valid java name */
    public static /* synthetic */ void m8931loadLongArray9zorpBc$default(ByteBuffer byteBuffer, long j, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = jArr.length - i4;
        }
        m8929loadLongArray9zorpBc(byteBuffer, j, jArr, i4, i2);
    }

    /* renamed from: storeLongArray-9zorpBc, reason: not valid java name */
    public static final void m8949storeLongArray9zorpBc(ByteBuffer storeLongArray, long j, long[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(storeLongArray, "$this$storeLongArray");
        Intrinsics.checkNotNullParameter(source, "source");
        if (j < SieveCacheKt.NodeLinkMask) {
            m8948storeLongArray9zorpBc(storeLongArray, (int) j, source, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: storeFloatArray-9zorpBc, reason: not valid java name */
    public static final void m8941storeFloatArray9zorpBc(ByteBuffer storeFloatArray, long j, float[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(storeFloatArray, "$this$storeFloatArray");
        Intrinsics.checkNotNullParameter(source, "source");
        if (j < SieveCacheKt.NodeLinkMask) {
            m8940storeFloatArray9zorpBc(storeFloatArray, (int) j, source, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: loadFloatArray-9zorpBc$default, reason: not valid java name */
    public static /* synthetic */ void m8922loadFloatArray9zorpBc$default(ByteBuffer byteBuffer, int i, float[] fArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = fArr.length - i2;
        }
        m8920loadFloatArray9zorpBc(byteBuffer, i, fArr, i2, i3);
    }

    /* renamed from: loadFloatArray-9zorpBc$default, reason: not valid java name */
    public static /* synthetic */ void m8923loadFloatArray9zorpBc$default(ByteBuffer byteBuffer, long j, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = fArr.length - i4;
        }
        m8921loadFloatArray9zorpBc(byteBuffer, j, fArr, i4, i2);
    }

    /* renamed from: storeDoubleArray-9zorpBc, reason: not valid java name */
    public static final void m8937storeDoubleArray9zorpBc(ByteBuffer storeDoubleArray, long j, double[] source, int i, int i2) {
        Intrinsics.checkNotNullParameter(storeDoubleArray, "$this$storeDoubleArray");
        Intrinsics.checkNotNullParameter(source, "source");
        if (j < SieveCacheKt.NodeLinkMask) {
            m8936storeDoubleArray9zorpBc(storeDoubleArray, (int) j, source, i, i2);
        } else {
            NumbersKt.failLongToIntConversion(j, "offset");
            throw new KotlinNothingValueException();
        }
    }

    /* renamed from: loadDoubleArray-9zorpBc$default, reason: not valid java name */
    public static /* synthetic */ void m8918loadDoubleArray9zorpBc$default(ByteBuffer byteBuffer, int i, double[] dArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = dArr.length - i2;
        }
        m8916loadDoubleArray9zorpBc(byteBuffer, i, dArr, i2, i3);
    }

    private static final ByteBuffer withOffset(ByteBuffer byteBuffer, int i) {
        ByteBuffer byteBufferDuplicate = byteBuffer.duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        byteBufferDuplicate.position(i);
        return byteBufferDuplicate;
    }

    /* renamed from: loadDoubleArray-9zorpBc$default, reason: not valid java name */
    public static /* synthetic */ void m8919loadDoubleArray9zorpBc$default(ByteBuffer byteBuffer, long j, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = dArr.length - i4;
        }
        m8917loadDoubleArray9zorpBc(byteBuffer, j, dArr, i4, i2);
    }

    /* renamed from: storeDoubleArray-9zorpBc$default, reason: not valid java name */
    public static /* synthetic */ void m8938storeDoubleArray9zorpBc$default(ByteBuffer byteBuffer, int i, double[] dArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = dArr.length - i2;
        }
        m8936storeDoubleArray9zorpBc(byteBuffer, i, dArr, i2, i3);
    }

    /* renamed from: storeDoubleArray-9zorpBc$default, reason: not valid java name */
    public static /* synthetic */ void m8939storeDoubleArray9zorpBc$default(ByteBuffer byteBuffer, long j, double[] dArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = dArr.length - i4;
        }
        m8937storeDoubleArray9zorpBc(byteBuffer, j, dArr, i4, i2);
    }

    /* renamed from: storeFloatArray-9zorpBc$default, reason: not valid java name */
    public static /* synthetic */ void m8942storeFloatArray9zorpBc$default(ByteBuffer byteBuffer, int i, float[] fArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = fArr.length - i2;
        }
        m8940storeFloatArray9zorpBc(byteBuffer, i, fArr, i2, i3);
    }

    /* renamed from: storeFloatArray-9zorpBc$default, reason: not valid java name */
    public static /* synthetic */ void m8943storeFloatArray9zorpBc$default(ByteBuffer byteBuffer, long j, float[] fArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = fArr.length - i4;
        }
        m8941storeFloatArray9zorpBc(byteBuffer, j, fArr, i4, i2);
    }

    /* renamed from: storeIntArray-9zorpBc$default, reason: not valid java name */
    public static /* synthetic */ void m8946storeIntArray9zorpBc$default(ByteBuffer byteBuffer, int i, int[] iArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = iArr.length - i2;
        }
        m8944storeIntArray9zorpBc(byteBuffer, i, iArr, i2, i3);
    }

    /* renamed from: storeIntArray-9zorpBc$default, reason: not valid java name */
    public static /* synthetic */ void m8947storeIntArray9zorpBc$default(ByteBuffer byteBuffer, long j, int[] iArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = iArr.length - i4;
        }
        m8945storeIntArray9zorpBc(byteBuffer, j, iArr, i4, i2);
    }

    /* renamed from: storeLongArray-9zorpBc$default, reason: not valid java name */
    public static /* synthetic */ void m8950storeLongArray9zorpBc$default(ByteBuffer byteBuffer, int i, long[] jArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = jArr.length - i2;
        }
        m8948storeLongArray9zorpBc(byteBuffer, i, jArr, i2, i3);
    }

    /* renamed from: storeLongArray-9zorpBc$default, reason: not valid java name */
    public static /* synthetic */ void m8951storeLongArray9zorpBc$default(ByteBuffer byteBuffer, long j, long[] jArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = jArr.length - i4;
        }
        m8949storeLongArray9zorpBc(byteBuffer, j, jArr, i4, i2);
    }

    /* renamed from: storeShortArray-9zorpBc$default, reason: not valid java name */
    public static /* synthetic */ void m8954storeShortArray9zorpBc$default(ByteBuffer byteBuffer, int i, short[] sArr, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i2 = 0;
        }
        if ((i4 & 8) != 0) {
            i3 = sArr.length - i2;
        }
        m8952storeShortArray9zorpBc(byteBuffer, i, sArr, i2, i3);
    }

    /* renamed from: storeShortArray-9zorpBc$default, reason: not valid java name */
    public static /* synthetic */ void m8955storeShortArray9zorpBc$default(ByteBuffer byteBuffer, long j, short[] sArr, int i, int i2, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            i = 0;
        }
        int i4 = i;
        if ((i3 & 8) != 0) {
            i2 = sArr.length - i4;
        }
        m8953storeShortArray9zorpBc(byteBuffer, j, sArr, i4, i2);
    }

    /* renamed from: loadShortArray-9zorpBc, reason: not valid java name */
    public static final void m8932loadShortArray9zorpBc(ByteBuffer loadShortArray, int i, short[] destination, int i2, int i3) {
        Intrinsics.checkNotNullParameter(loadShortArray, "$this$loadShortArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        ByteBuffer byteBufferDuplicate = loadShortArray.duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        byteBufferDuplicate.position(i);
        byteBufferDuplicate.asShortBuffer().get(destination, i2, i3);
    }

    /* renamed from: loadIntArray-9zorpBc, reason: not valid java name */
    public static final void m8924loadIntArray9zorpBc(ByteBuffer loadIntArray, int i, int[] destination, int i2, int i3) {
        Intrinsics.checkNotNullParameter(loadIntArray, "$this$loadIntArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        ByteBuffer byteBufferDuplicate = loadIntArray.duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        byteBufferDuplicate.position(i);
        byteBufferDuplicate.asIntBuffer().get(destination, i2, i3);
    }

    /* renamed from: loadLongArray-9zorpBc, reason: not valid java name */
    public static final void m8928loadLongArray9zorpBc(ByteBuffer loadLongArray, int i, long[] destination, int i2, int i3) {
        Intrinsics.checkNotNullParameter(loadLongArray, "$this$loadLongArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        ByteBuffer byteBufferDuplicate = loadLongArray.duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        byteBufferDuplicate.position(i);
        byteBufferDuplicate.asLongBuffer().get(destination, i2, i3);
    }

    /* renamed from: loadFloatArray-9zorpBc, reason: not valid java name */
    public static final void m8920loadFloatArray9zorpBc(ByteBuffer loadFloatArray, int i, float[] destination, int i2, int i3) {
        Intrinsics.checkNotNullParameter(loadFloatArray, "$this$loadFloatArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        ByteBuffer byteBufferDuplicate = loadFloatArray.duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        byteBufferDuplicate.position(i);
        byteBufferDuplicate.asFloatBuffer().get(destination, i2, i3);
    }

    /* renamed from: loadDoubleArray-9zorpBc, reason: not valid java name */
    public static final void m8916loadDoubleArray9zorpBc(ByteBuffer loadDoubleArray, int i, double[] destination, int i2, int i3) {
        Intrinsics.checkNotNullParameter(loadDoubleArray, "$this$loadDoubleArray");
        Intrinsics.checkNotNullParameter(destination, "destination");
        ByteBuffer byteBufferDuplicate = loadDoubleArray.duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        byteBufferDuplicate.position(i);
        byteBufferDuplicate.asDoubleBuffer().get(destination, i2, i3);
    }

    /* renamed from: storeShortArray-9zorpBc, reason: not valid java name */
    public static final void m8952storeShortArray9zorpBc(ByteBuffer storeShortArray, int i, short[] source, int i2, int i3) {
        Intrinsics.checkNotNullParameter(storeShortArray, "$this$storeShortArray");
        Intrinsics.checkNotNullParameter(source, "source");
        ByteBuffer byteBufferDuplicate = storeShortArray.duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        byteBufferDuplicate.position(i);
        byteBufferDuplicate.asShortBuffer().put(source, i2, i3);
    }

    /* renamed from: storeIntArray-9zorpBc, reason: not valid java name */
    public static final void m8944storeIntArray9zorpBc(ByteBuffer storeIntArray, int i, int[] source, int i2, int i3) {
        Intrinsics.checkNotNullParameter(storeIntArray, "$this$storeIntArray");
        Intrinsics.checkNotNullParameter(source, "source");
        ByteBuffer byteBufferDuplicate = storeIntArray.duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        byteBufferDuplicate.position(i);
        byteBufferDuplicate.asIntBuffer().put(source, i2, i3);
    }

    /* renamed from: storeLongArray-9zorpBc, reason: not valid java name */
    public static final void m8948storeLongArray9zorpBc(ByteBuffer storeLongArray, int i, long[] source, int i2, int i3) {
        Intrinsics.checkNotNullParameter(storeLongArray, "$this$storeLongArray");
        Intrinsics.checkNotNullParameter(source, "source");
        ByteBuffer byteBufferDuplicate = storeLongArray.duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        byteBufferDuplicate.position(i);
        byteBufferDuplicate.asLongBuffer().put(source, i2, i3);
    }

    /* renamed from: storeFloatArray-9zorpBc, reason: not valid java name */
    public static final void m8940storeFloatArray9zorpBc(ByteBuffer storeFloatArray, int i, float[] source, int i2, int i3) {
        Intrinsics.checkNotNullParameter(storeFloatArray, "$this$storeFloatArray");
        Intrinsics.checkNotNullParameter(source, "source");
        ByteBuffer byteBufferDuplicate = storeFloatArray.duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        byteBufferDuplicate.position(i);
        byteBufferDuplicate.asFloatBuffer().put(source, i2, i3);
    }

    /* renamed from: storeDoubleArray-9zorpBc, reason: not valid java name */
    public static final void m8936storeDoubleArray9zorpBc(ByteBuffer storeDoubleArray, int i, double[] source, int i2, int i3) {
        Intrinsics.checkNotNullParameter(storeDoubleArray, "$this$storeDoubleArray");
        Intrinsics.checkNotNullParameter(source, "source");
        ByteBuffer byteBufferDuplicate = storeDoubleArray.duplicate();
        Intrinsics.checkNotNull(byteBufferDuplicate);
        byteBufferDuplicate.position(i);
        byteBufferDuplicate.asDoubleBuffer().put(source, i2, i3);
    }
}
