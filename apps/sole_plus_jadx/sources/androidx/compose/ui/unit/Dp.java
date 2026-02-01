package androidx.compose.ui.unit;

import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Dp.kt */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u000f\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087@\u0018\u0000 \"2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\"B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\b\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\n\u0010\u000bJ\u0018\u0010\f\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\r\u0010\u000bJ\u0010\u0010\u000e\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u000f\u0010\u0005J\u0018\u0010\u0010\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0003H\u0087\n¢\u0006\u0004\b\u0011\u0010\u000bJ\u0018\u0010\u0010\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b\u0011\u0010\u0013J\u0018\u0010\u0010\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\u0000H\u0087\n¢\u0006\u0004\b\u0014\u0010\u000bJ\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0003H\u0087\n¢\u0006\u0004\b\u0016\u0010\u000bJ\u0018\u0010\u0015\u001a\u00020\u00002\u0006\u0010\t\u001a\u00020\u0012H\u0087\n¢\u0006\u0004\b\u0016\u0010\u0013J\u0018\u0010\u0017\u001a\u00020\u00122\u0006\u0010\t\u001a\u00020\u0000H\u0097\u0002¢\u0006\u0004\b\u0018\u0010\u0019J\u000f\u0010\u001a\u001a\u00020\u001bH\u0017¢\u0006\u0004\b\u001c\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010\t\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006#"}, d2 = {"Landroidx/compose/ui/unit/Dp;", "", "value", "", "constructor-impl", "(F)F", "getValue", "()F", "plus", "other", "plus-5rwHm24", "(FF)F", "minus", "minus-5rwHm24", "unaryMinus", "unaryMinus-D9Ej5fM", "div", "div-u2uoSUM", "", "(FI)F", "div-0680j_4", "times", "times-u2uoSUM", "compareTo", "compareTo-0680j_4", "(FF)I", "toString", "", "toString-impl", "(F)Ljava/lang/String;", "equals", "", "", "hashCode", "Companion", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class Dp implements Comparable<Dp> {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final float Hairline = m7255constructorimpl(0.0f);
    private static final float Infinity = m7255constructorimpl(Float.POSITIVE_INFINITY);
    private static final float Unspecified = m7255constructorimpl(Float.NaN);
    private final float value;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Dp m7253boximpl(float f) {
        return new Dp(f);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static float m7255constructorimpl(float f) {
        return f;
    }

    /* renamed from: div-0680j_4, reason: not valid java name */
    public static final float m7256div0680j_4(float f, float f2) {
        return f / f2;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m7259equalsimpl(float f, Object obj) {
        return (obj instanceof Dp) && Float.compare(f, ((Dp) obj).m7269unboximpl()) == 0;
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7260equalsimpl0(float f, float f2) {
        return Float.compare(f, f2) == 0;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m7261hashCodeimpl(float f) {
        return Float.hashCode(f);
    }

    public boolean equals(Object other) {
        return m7259equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m7261hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ float m7269unboximpl() {
        return this.value;
    }

    @Override // java.lang.Comparable
    public /* bridge */ /* synthetic */ int compareTo(Dp dp) {
        return m7268compareTo0680j_4(dp.m7269unboximpl());
    }

    private /* synthetic */ Dp(float f) {
        this.value = f;
    }

    public final float getValue() {
        return this.value;
    }

    /* renamed from: plus-5rwHm24, reason: not valid java name */
    public static final float m7263plus5rwHm24(float f, float f2) {
        return m7255constructorimpl(f + f2);
    }

    /* renamed from: minus-5rwHm24, reason: not valid java name */
    public static final float m7262minus5rwHm24(float f, float f2) {
        return m7255constructorimpl(f - f2);
    }

    /* renamed from: unaryMinus-D9Ej5fM, reason: not valid java name */
    public static final float m7267unaryMinusD9Ej5fM(float f) {
        return m7255constructorimpl(-f);
    }

    /* renamed from: div-u2uoSUM, reason: not valid java name */
    public static final float m7257divu2uoSUM(float f, float f2) {
        return m7255constructorimpl(f / f2);
    }

    /* renamed from: div-u2uoSUM, reason: not valid java name */
    public static final float m7258divu2uoSUM(float f, int i) {
        return m7255constructorimpl(f / i);
    }

    /* renamed from: times-u2uoSUM, reason: not valid java name */
    public static final float m7264timesu2uoSUM(float f, float f2) {
        return m7255constructorimpl(f * f2);
    }

    /* renamed from: times-u2uoSUM, reason: not valid java name */
    public static final float m7265timesu2uoSUM(float f, int i) {
        return m7255constructorimpl(f * i);
    }

    /* renamed from: compareTo-0680j_4, reason: not valid java name */
    public int m7268compareTo0680j_4(float f) {
        return m7254compareTo0680j_4(this.value, f);
    }

    /* renamed from: compareTo-0680j_4, reason: not valid java name */
    public static int m7254compareTo0680j_4(float f, float f2) {
        return Float.compare(f, f2);
    }

    public String toString() {
        return m7266toStringimpl(this.value);
    }

    /* compiled from: Dp.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u001e\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u001e\u0010\n\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\bR\u001e\u0010\r\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000e\u0010\u0003\u001a\u0004\b\u000f\u0010\b¨\u0006\u0010"}, d2 = {"Landroidx/compose/ui/unit/Dp$Companion;", "", SdkConstants.CONSTRUCTOR_NAME, "()V", "Hairline", "Landroidx/compose/ui/unit/Dp;", "getHairline-D9Ej5fM$annotations", "getHairline-D9Ej5fM", "()F", "F", "Infinity", "getInfinity-D9Ej5fM$annotations", "getInfinity-D9Ej5fM", "Unspecified", "getUnspecified-D9Ej5fM$annotations", "getUnspecified-D9Ej5fM", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getHairline-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m7270getHairlineD9Ej5fM$annotations() {
        }

        /* renamed from: getInfinity-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m7271getInfinityD9Ej5fM$annotations() {
        }

        /* renamed from: getUnspecified-D9Ej5fM$annotations, reason: not valid java name */
        public static /* synthetic */ void m7272getUnspecifiedD9Ej5fM$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getHairline-D9Ej5fM, reason: not valid java name */
        public final float m7273getHairlineD9Ej5fM() {
            return Dp.Hairline;
        }

        /* renamed from: getInfinity-D9Ej5fM, reason: not valid java name */
        public final float m7274getInfinityD9Ej5fM() {
            return Dp.Infinity;
        }

        /* renamed from: getUnspecified-D9Ej5fM, reason: not valid java name */
        public final float m7275getUnspecifiedD9Ej5fM() {
            return Dp.Unspecified;
        }
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m7266toStringimpl(float f) {
        return Float.isNaN(f) ? "Dp.Unspecified" : f + ".dp";
    }
}
