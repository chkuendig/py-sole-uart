package androidx.compose.ui.text.font;

import com.android.SdkConstants;
import java.util.List;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: FontStyle.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087@\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\b\u001a\u00020\tH\u0016¢\u0006\u0004\b\n\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\u0088\u0001\u0002¨\u0006\u0011"}, d2 = {"Landroidx/compose/ui/text/font/FontStyle;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "equals", "", "other", "hashCode", "Companion", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class FontStyle {
    private final int value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Normal = m6828constructorimpl(0);
    private static final int Italic = m6828constructorimpl(1);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ FontStyle m6827boximpl(int i) {
        return new FontStyle(i);
    }

    @Deprecated(message = "Please use FontStyle.Normal or FontStyle.Italic", replaceWith = @ReplaceWith(expression = "FontStyle.", imports = {}))
    /* renamed from: constructor-impl, reason: not valid java name */
    public static int m6828constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m6829equalsimpl(int i, Object obj) {
        return (obj instanceof FontStyle) && i == ((FontStyle) obj).m6833unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6830equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m6831hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object other) {
        return m6829equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m6831hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m6833unboximpl() {
        return this.value;
    }

    @Deprecated(message = "Please use FontStyle.Normal or FontStyle.Italic", replaceWith = @ReplaceWith(expression = "FontStyle.", imports = {}))
    private /* synthetic */ FontStyle(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    public String toString() {
        return m6832toStringimpl(this.value);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m6832toStringimpl(int i) {
        return m6830equalsimpl0(i, Normal) ? "Normal" : m6830equalsimpl0(i, Italic) ? "Italic" : "Invalid";
    }

    /* compiled from: FontStyle.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010 \n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00050\u000eR\u0019\u0010\u0004\u001a\u00020\u0005¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u0019\u0010\n\u001a\u00020\u0005¢\u0006\u0010\n\u0002\u0010\t\u0012\u0004\b\u000b\u0010\u0003\u001a\u0004\b\f\u0010\b¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/text/font/FontStyle$Companion;", "", SdkConstants.CONSTRUCTOR_NAME, "()V", "Normal", "Landroidx/compose/ui/text/font/FontStyle;", "getNormal-_-LCdwA$annotations", "getNormal-_-LCdwA", "()I", "I", "Italic", "getItalic-_-LCdwA$annotations", "getItalic-_-LCdwA", SdkConstants.FD_RES_VALUES, "", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        /* renamed from: getItalic-_-LCdwA$annotations, reason: not valid java name */
        public static /* synthetic */ void m6834getItalic_LCdwA$annotations() {
        }

        /* renamed from: getNormal-_-LCdwA$annotations, reason: not valid java name */
        public static /* synthetic */ void m6835getNormal_LCdwA$annotations() {
        }

        private Companion() {
        }

        /* renamed from: getNormal-_-LCdwA, reason: not valid java name */
        public final int m6837getNormal_LCdwA() {
            return FontStyle.Normal;
        }

        /* renamed from: getItalic-_-LCdwA, reason: not valid java name */
        public final int m6836getItalic_LCdwA() {
            return FontStyle.Italic;
        }

        public final List<FontStyle> values() {
            return CollectionsKt.listOf((Object[]) new FontStyle[]{FontStyle.m6827boximpl(m6837getNormal_LCdwA()), FontStyle.m6827boximpl(m6836getItalic_LCdwA())});
        }
    }
}
