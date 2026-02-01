package androidx.compose.ui.geometry;

import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Offset.kt */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087@\u0018\u0000 72\u00020\u0001:\u00017B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0011\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0012\u0010\rJ\u0010\u0010\u0013\u001a\u00020\tH\u0087\n¢\u0006\u0004\b\u0014\u0010\rJ!\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\u000e\u001a\u00020\t¢\u0006\u0004\b\u0016\u0010\u0017J\u0010\u0010\u0018\u001a\u00020\u0019H\u0087\b¢\u0006\u0004\b\u001a\u0010\u001bJ\u000f\u0010\u001c\u001a\u00020\tH\u0007¢\u0006\u0004\b\u001d\u0010\rJ\u000f\u0010\u001e\u001a\u00020\tH\u0007¢\u0006\u0004\b\u001f\u0010\rJ\u0010\u0010 \u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b!\u0010\u0005J\u0018\u0010\"\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b$\u0010%J\u0018\u0010&\u001a\u00020\u00002\u0006\u0010#\u001a\u00020\u0000H\u0087\u0002¢\u0006\u0004\b'\u0010%J\u0018\u0010(\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b*\u0010+J\u0018\u0010,\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b-\u0010+J\u0018\u0010.\u001a\u00020\u00002\u0006\u0010)\u001a\u00020\tH\u0087\u0002¢\u0006\u0004\b/\u0010+J\u000f\u00100\u001a\u000201H\u0016¢\u0006\u0004\b2\u00103J\u0013\u00104\u001a\u00020\u00192\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u00105\u001a\u000206HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u000b\u001a\u0004\b\f\u0010\rR\u001b\u0010\u000e\u001a\u00020\t8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u000f\u0010\u000b\u001a\u0004\b\u0010\u0010\r\u0088\u0001\u0002¨\u00068"}, d2 = {"Landroidx/compose/ui/geometry/Offset;", "", "packedValue", "", "constructor-impl", "(J)J", "getPackedValue", "()J", "x", "", "getX$annotations", "()V", "getX-impl", "(J)F", "y", "getY$annotations", "getY-impl", "component1", "component1-impl", "component2", "component2-impl", "copy", "copy-dBAh8RU", "(JFF)J", "isValid", "", "isValid-impl", "(J)Z", "getDistance", "getDistance-impl", "getDistanceSquared", "getDistanceSquared-impl", "unaryMinus", "unaryMinus-F1C5BW0", "minus", "other", "minus-MK-Hz9U", "(JJ)J", "plus", "plus-MK-Hz9U", "times", "operand", "times-tuRUvjQ", "(JF)J", "div", "div-tuRUvjQ", "rem", "rem-tuRUvjQ", "toString", "", "toString-impl", "(J)Ljava/lang/String;", "equals", "hashCode", "", "Companion", "ui-geometry"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class Offset {
    private final long packedValue;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final long Zero = m4286constructorimpl(0);
    private static final long Infinite = m4286constructorimpl(InlineClassHelperKt.DualFloatInfinityBase);
    private static final long Unspecified = m4286constructorimpl(InlineClassHelperKt.UnspecifiedPackedFloats);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Offset m4283boximpl(long j) {
        return new Offset(j);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static long m4286constructorimpl(long j) {
        return j;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4290equalsimpl(long j, Object obj) {
        return (obj instanceof Offset) && j == ((Offset) obj).m4304unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4291equalsimpl0(long j, long j2) {
        return j == j2;
    }

    public static /* synthetic */ void getX$annotations() {
    }

    public static /* synthetic */ void getY$annotations() {
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4296hashCodeimpl(long j) {
        return Long.hashCode(j);
    }

    /* renamed from: isValid-impl, reason: not valid java name */
    public static final boolean m4297isValidimpl(long j) {
        return (((j & 9223372034707292159L) + InlineClassHelperKt.DualLoadedSignificand) & (-9223372034707292160L)) == 0;
    }

    public boolean equals(Object other) {
        return m4290equalsimpl(this.packedValue, other);
    }

    public int hashCode() {
        return m4296hashCodeimpl(this.packedValue);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ long m4304unboximpl() {
        return this.packedValue;
    }

    private /* synthetic */ Offset(long j) {
        this.packedValue = j;
    }

    public final long getPackedValue() {
        return this.packedValue;
    }

    /* compiled from: Offset.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\b¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/geometry/Offset$Companion;", "", SdkConstants.CONSTRUCTOR_NAME, "()V", "Zero", "Landroidx/compose/ui/geometry/Offset;", "getZero-F1C5BW0$annotations", "getZero-F1C5BW0", "()J", "J", "Infinite", "getInfinite-F1C5BW0$annotations", "getInfinite-F1C5BW0", "Unspecified", "getUnspecified-F1C5BW0$annotations", "getUnspecified-F1C5BW0", "ui-geometry"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getInfinite-F1C5BW0$annotations, reason: not valid java name */
        public static /* synthetic */ void m4305getInfiniteF1C5BW0$annotations() {
        }

        /* renamed from: getUnspecified-F1C5BW0$annotations, reason: not valid java name */
        public static /* synthetic */ void m4306getUnspecifiedF1C5BW0$annotations() {
        }

        /* renamed from: getZero-F1C5BW0$annotations, reason: not valid java name */
        public static /* synthetic */ void m4307getZeroF1C5BW0$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getZero-F1C5BW0, reason: not valid java name */
        public final long m4310getZeroF1C5BW0() {
            return Offset.Zero;
        }

        /* renamed from: getInfinite-F1C5BW0, reason: not valid java name */
        public final long m4308getInfiniteF1C5BW0() {
            return Offset.Infinite;
        }

        /* renamed from: getUnspecified-F1C5BW0, reason: not valid java name */
        public final long m4309getUnspecifiedF1C5BW0() {
            return Offset.Unspecified;
        }
    }

    /* renamed from: unaryMinus-F1C5BW0, reason: not valid java name */
    public static final long m4303unaryMinusF1C5BW0(long j) {
        return m4286constructorimpl(j ^ (-9223372034707292160L));
    }

    public String toString() {
        return m4302toStringimpl(this.packedValue);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4302toStringimpl(long j) {
        if ((9223372034707292159L & j) != InlineClassHelperKt.UnspecifiedPackedFloats) {
            return "Offset(" + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat((int) (j >> 32)), 1) + ", " + GeometryUtilsKt.toStringAsFixed(Float.intBitsToFloat((int) (j & 4294967295L)), 1) + ')';
        }
        return "Offset.Unspecified";
    }

    /* renamed from: getX-impl, reason: not valid java name */
    public static final float m4294getXimpl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: getY-impl, reason: not valid java name */
    public static final float m4295getYimpl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: component1-impl, reason: not valid java name */
    public static final float m4284component1impl(long j) {
        return Float.intBitsToFloat((int) (j >> 32));
    }

    /* renamed from: component2-impl, reason: not valid java name */
    public static final float m4285component2impl(long j) {
        return Float.intBitsToFloat((int) (j & 4294967295L));
    }

    /* renamed from: copy-dBAh8RU, reason: not valid java name */
    public static final long m4287copydBAh8RU(long j, float f, float f2) {
        return m4286constructorimpl((Float.floatToRawIntBits(f) << 32) | (Float.floatToRawIntBits(f2) & 4294967295L));
    }

    /* renamed from: copy-dBAh8RU$default, reason: not valid java name */
    public static /* synthetic */ long m4288copydBAh8RU$default(long j, float f, float f2, int i, Object obj) {
        if ((i & 1) != 0) {
            f = Float.intBitsToFloat((int) (j >> 32));
        }
        if ((i & 2) != 0) {
            f2 = Float.intBitsToFloat((int) (4294967295L & j));
        }
        return m4287copydBAh8RU(j, f, f2);
    }

    /* renamed from: getDistance-impl, reason: not valid java name */
    public static final float m4292getDistanceimpl(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        return (float) Math.sqrt((fIntBitsToFloat * fIntBitsToFloat) + (fIntBitsToFloat2 * fIntBitsToFloat2));
    }

    /* renamed from: getDistanceSquared-impl, reason: not valid java name */
    public static final float m4293getDistanceSquaredimpl(long j) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L));
        return (fIntBitsToFloat * fIntBitsToFloat) + (fIntBitsToFloat2 * fIntBitsToFloat2);
    }

    /* renamed from: minus-MK-Hz9U, reason: not valid java name */
    public static final long m4298minusMKHz9U(long j, long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) - Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) - Float.intBitsToFloat((int) (j2 & 4294967295L));
        return m4286constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    /* renamed from: plus-MK-Hz9U, reason: not valid java name */
    public static final long m4299plusMKHz9U(long j, long j2) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) + Float.intBitsToFloat((int) (j2 >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) + Float.intBitsToFloat((int) (j2 & 4294967295L));
        return m4286constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    /* renamed from: times-tuRUvjQ, reason: not valid java name */
    public static final long m4301timestuRUvjQ(long j, float f) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) * f;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) * f;
        return m4286constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    /* renamed from: div-tuRUvjQ, reason: not valid java name */
    public static final long m4289divtuRUvjQ(long j, float f) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) / f;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) / f;
        return m4286constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }

    /* renamed from: rem-tuRUvjQ, reason: not valid java name */
    public static final long m4300remtuRUvjQ(long j, float f) {
        float fIntBitsToFloat = Float.intBitsToFloat((int) (j >> 32)) % f;
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (j & 4294967295L)) % f;
        return m4286constructorimpl((Float.floatToRawIntBits(fIntBitsToFloat) << 32) | (Float.floatToRawIntBits(fIntBitsToFloat2) & 4294967295L));
    }
}
