package androidx.compose.ui.graphics;

import com.android.SdkConstants;
import com.facebook.internal.AnalyticsEvents;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TileMode.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/TileMode;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class TileMode {
    private final int value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Clamp = m4922constructorimpl(0);
    private static final int Repeated = m4922constructorimpl(1);
    private static final int Mirror = m4922constructorimpl(2);
    private static final int Decal = m4922constructorimpl(3);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TileMode m4921boximpl(int i) {
        return new TileMode(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m4922constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4923equalsimpl(int i, Object obj) {
        return (obj instanceof TileMode) && i == ((TileMode) obj).getValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4924equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4925hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object other) {
        return m4923equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m4925hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    /* compiled from: TileMode.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/TileMode$Companion;", "", SdkConstants.CONSTRUCTOR_NAME, "()V", "Clamp", "Landroidx/compose/ui/graphics/TileMode;", "getClamp-3opZhB0", "()I", "I", "Repeated", "getRepeated-3opZhB0", "Mirror", "getMirror-3opZhB0", "Decal", "getDecal-3opZhB0", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getClamp-3opZhB0, reason: not valid java name */
        public final int m4928getClamp3opZhB0() {
            return TileMode.Clamp;
        }

        /* renamed from: getRepeated-3opZhB0, reason: not valid java name */
        public final int m4931getRepeated3opZhB0() {
            return TileMode.Repeated;
        }

        /* renamed from: getMirror-3opZhB0, reason: not valid java name */
        public final int m4930getMirror3opZhB0() {
            return TileMode.Mirror;
        }

        /* renamed from: getDecal-3opZhB0, reason: not valid java name */
        public final int m4929getDecal3opZhB0() {
            return TileMode.Decal;
        }
    }

    private /* synthetic */ TileMode(int i) {
        this.value = i;
    }

    public String toString() {
        return m4926toStringimpl(this.value);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4926toStringimpl(int i) {
        return m4924equalsimpl0(i, Clamp) ? "Clamp" : m4924equalsimpl0(i, Repeated) ? "Repeated" : m4924equalsimpl0(i, Mirror) ? "Mirror" : m4924equalsimpl0(i, Decal) ? "Decal" : AnalyticsEvents.PARAMETER_DIALOG_OUTCOME_VALUE_UNKNOWN;
    }
}
