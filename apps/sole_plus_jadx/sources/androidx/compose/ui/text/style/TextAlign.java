package androidx.compose.ui.text.style;

import com.android.SdkConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: TextAlign.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB\u0011\b\u0000\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/style/TextAlign;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class TextAlign {
    private final int value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Left = m7133constructorimpl(1);
    private static final int Right = m7133constructorimpl(2);
    private static final int Center = m7133constructorimpl(3);
    private static final int Justify = m7133constructorimpl(4);
    private static final int Start = m7133constructorimpl(5);
    private static final int End = m7133constructorimpl(6);
    private static final int Unspecified = m7133constructorimpl(Integer.MIN_VALUE);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ TextAlign m7132boximpl(int i) {
        return new TextAlign(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m7133constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m7134equalsimpl(int i, Object obj) {
        return (obj instanceof TextAlign) && i == ((TextAlign) obj).getValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m7135equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m7136hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object other) {
        return m7134equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m7136hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    private /* synthetic */ TextAlign(int i) {
        this.value = i;
    }

    public String toString() {
        return m7137toStringimpl(this.value);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m7137toStringimpl(int i) {
        return m7135equalsimpl0(i, Left) ? "Left" : m7135equalsimpl0(i, Right) ? "Right" : m7135equalsimpl0(i, Center) ? "Center" : m7135equalsimpl0(i, Justify) ? "Justify" : m7135equalsimpl0(i, Start) ? "Start" : m7135equalsimpl0(i, End) ? "End" : m7135equalsimpl0(i, Unspecified) ? "Unspecified" : "Invalid";
    }

    /* compiled from: TextAlign.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010 \n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007R\u0013\u0010\r\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u000e\u0010\u0007R\u0013\u0010\u000f\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0010\u0010\u0007R\u0013\u0010\u0011\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0012\u0010\u0007R\u0013\u0010\u0015\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0016\u0010\u0007¨\u0006\u0017"}, d2 = {"Landroidx/compose/ui/text/style/TextAlign$Companion;", "", SdkConstants.CONSTRUCTOR_NAME, "()V", "Left", "Landroidx/compose/ui/text/style/TextAlign;", "getLeft-e0LSkKk", "()I", "I", "Right", "getRight-e0LSkKk", "Center", "getCenter-e0LSkKk", "Justify", "getJustify-e0LSkKk", "Start", "getStart-e0LSkKk", "End", "getEnd-e0LSkKk", SdkConstants.FD_RES_VALUES, "", "Unspecified", "getUnspecified-e0LSkKk", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getLeft-e0LSkKk, reason: not valid java name */
        public final int m7142getLefte0LSkKk() {
            return TextAlign.Left;
        }

        /* renamed from: getRight-e0LSkKk, reason: not valid java name */
        public final int m7143getRighte0LSkKk() {
            return TextAlign.Right;
        }

        /* renamed from: getCenter-e0LSkKk, reason: not valid java name */
        public final int m7139getCentere0LSkKk() {
            return TextAlign.Center;
        }

        /* renamed from: getJustify-e0LSkKk, reason: not valid java name */
        public final int m7141getJustifye0LSkKk() {
            return TextAlign.Justify;
        }

        /* renamed from: getStart-e0LSkKk, reason: not valid java name */
        public final int m7144getStarte0LSkKk() {
            return TextAlign.Start;
        }

        /* renamed from: getEnd-e0LSkKk, reason: not valid java name */
        public final int m7140getEnde0LSkKk() {
            return TextAlign.End;
        }

        public final List<TextAlign> values() {
            return CollectionsKt.listOf((Object[]) new TextAlign[]{TextAlign.m7132boximpl(m7142getLefte0LSkKk()), TextAlign.m7132boximpl(m7143getRighte0LSkKk()), TextAlign.m7132boximpl(m7139getCentere0LSkKk()), TextAlign.m7132boximpl(m7141getJustifye0LSkKk()), TextAlign.m7132boximpl(m7144getStarte0LSkKk()), TextAlign.m7132boximpl(m7140getEnde0LSkKk())});
        }

        /* renamed from: getUnspecified-e0LSkKk, reason: not valid java name */
        public final int m7145getUnspecifiede0LSkKk() {
            return TextAlign.Unspecified;
        }
    }
}
