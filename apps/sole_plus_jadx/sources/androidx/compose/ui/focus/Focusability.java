package androidx.compose.ui.focus;

import androidx.compose.ui.input.InputMode;
import androidx.compose.ui.input.InputModeManager;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNode;
import androidx.compose.ui.node.CompositionLocalConsumerModifierNodeKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Focusability.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0087@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u000f\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0017\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0000¢\u0006\u0004\b\u000e\u0010\u000fJ\u0013\u0010\u0010\u001a\u00020\u000b2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÖ\u0001R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\u0088\u0001\u0002\u0092\u0001\u00020\u0003¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/focus/Focusability;", "", "value", "", "constructor-impl", "(I)I", "toString", "", "toString-impl", "(I)Ljava/lang/String;", "canFocus", "", "node", "Landroidx/compose/ui/node/CompositionLocalConsumerModifierNode;", "canFocus-impl$ui_release", "(ILandroidx/compose/ui/node/CompositionLocalConsumerModifierNode;)Z", "equals", "other", "hashCode", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
public final class Focusability {
    private final int value;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Always = m4222constructorimpl(1);
    private static final int SystemDefined = m4222constructorimpl(0);
    private static final int Never = m4222constructorimpl(2);

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Focusability m4220boximpl(int i) {
        return new Focusability(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m4222constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m4223equalsimpl(int i, Object obj) {
        return (obj instanceof Focusability) && i == ((Focusability) obj).getValue();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m4224equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m4225hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    public boolean equals(Object other) {
        return m4223equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m4225hashCodeimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name and from getter */
    public final /* synthetic */ int getValue() {
        return this.value;
    }

    /* compiled from: Focusability.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/ui/focus/Focusability$Companion;", "", SdkConstants.CONSTRUCTOR_NAME, "()V", "Always", "Landroidx/compose/ui/focus/Focusability;", "getAlways-LCbbffg", "()I", "I", "SystemDefined", "getSystemDefined-LCbbffg", "Never", "getNever-LCbbffg", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getAlways-LCbbffg, reason: not valid java name */
        public final int m4228getAlwaysLCbbffg() {
            return Focusability.Always;
        }

        /* renamed from: getSystemDefined-LCbbffg, reason: not valid java name */
        public final int m4230getSystemDefinedLCbbffg() {
            return Focusability.SystemDefined;
        }

        /* renamed from: getNever-LCbbffg, reason: not valid java name */
        public final int m4229getNeverLCbbffg() {
            return Focusability.Never;
        }
    }

    private /* synthetic */ Focusability(int i) {
        this.value = i;
    }

    public String toString() {
        return m4226toStringimpl(this.value);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m4226toStringimpl(int i) {
        if (m4224equalsimpl0(i, Always)) {
            return "Always";
        }
        if (m4224equalsimpl0(i, SystemDefined)) {
            return "SystemDefined";
        }
        if (m4224equalsimpl0(i, Never)) {
            return "Never";
        }
        throw new IllegalStateException("Unknown Focusability".toString());
    }

    /* renamed from: canFocus-impl$ui_release, reason: not valid java name */
    public static final boolean m4221canFocusimpl$ui_release(int i, CompositionLocalConsumerModifierNode compositionLocalConsumerModifierNode) {
        if (m4224equalsimpl0(i, Always)) {
            return true;
        }
        if (m4224equalsimpl0(i, SystemDefined)) {
            return true ^ InputMode.m5349equalsimpl0(((InputModeManager) CompositionLocalConsumerModifierNodeKt.currentValueOf(compositionLocalConsumerModifierNode, CompositionLocalsKt.getLocalInputModeManager())).mo5355getInputModeaOaMEAU(), InputMode.INSTANCE.m5354getTouchaOaMEAU());
        }
        if (m4224equalsimpl0(i, Never)) {
            return false;
        }
        throw new IllegalStateException("Unknown Focusability".toString());
    }
}
