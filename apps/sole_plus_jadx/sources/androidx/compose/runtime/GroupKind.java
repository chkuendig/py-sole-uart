package androidx.compose.runtime;

import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Composer.kt */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0083@\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0013\u0010\u000e\u001a\u00020\t2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000b\u0088\u0001\u0002¨\u0006\u0014"}, d2 = {"Landroidx/compose/runtime/GroupKind;", "", "value", "", "constructor-impl", "(I)I", "getValue", "()I", "isNode", "", "isNode-impl", "(I)Z", "isReusable", "isReusable-impl", "equals", "other", "hashCode", "toString", "", "Companion", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes.dex */
final class GroupKind {

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final int Group = m3793constructorimpl(0);
    private static final int Node = m3793constructorimpl(1);
    private static final int ReusableNode = m3793constructorimpl(2);
    private final int value;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ GroupKind m3792boximpl(int i) {
        return new GroupKind(i);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    private static int m3793constructorimpl(int i) {
        return i;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m3794equalsimpl(int i, Object obj) {
        return (obj instanceof GroupKind) && i == ((GroupKind) obj).m3800unboximpl();
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m3795equalsimpl0(int i, int i2) {
        return i == i2;
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m3796hashCodeimpl(int i) {
        return Integer.hashCode(i);
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m3799toStringimpl(int i) {
        return "GroupKind(value=" + i + ')';
    }

    public boolean equals(Object other) {
        return m3794equalsimpl(this.value, other);
    }

    public int hashCode() {
        return m3796hashCodeimpl(this.value);
    }

    public String toString() {
        return m3799toStringimpl(this.value);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int m3800unboximpl() {
        return this.value;
    }

    private /* synthetic */ GroupKind(int i) {
        this.value = i;
    }

    public final int getValue() {
        return this.value;
    }

    /* renamed from: isNode-impl, reason: not valid java name */
    public static final boolean m3797isNodeimpl(int i) {
        return i != INSTANCE.m3801getGroupULZAiWs();
    }

    /* renamed from: isReusable-impl, reason: not valid java name */
    public static final boolean m3798isReusableimpl(int i) {
        return i != INSTANCE.m3802getNodeULZAiWs();
    }

    /* compiled from: Composer.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u0013\u0010\u000b\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\f\u0010\u0007¨\u0006\r"}, d2 = {"Landroidx/compose/runtime/GroupKind$Companion;", "", SdkConstants.CONSTRUCTOR_NAME, "()V", "Group", "Landroidx/compose/runtime/GroupKind;", "getGroup-ULZAiWs", "()I", "I", "Node", "getNode-ULZAiWs", "ReusableNode", "getReusableNode-ULZAiWs", "runtime"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* renamed from: getGroup-ULZAiWs, reason: not valid java name */
        public final int m3801getGroupULZAiWs() {
            return GroupKind.Group;
        }

        /* renamed from: getNode-ULZAiWs, reason: not valid java name */
        public final int m3802getNodeULZAiWs() {
            return GroupKind.Node;
        }

        /* renamed from: getReusableNode-ULZAiWs, reason: not valid java name */
        public final int m3803getReusableNodeULZAiWs() {
            return GroupKind.ReusableNode;
        }
    }
}
