package androidx.compose.foundation;

import android.view.KeyEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.compose.ui.input.key.KeyEventType;
import androidx.compose.ui.input.key.KeyEvent_androidKt;
import androidx.compose.ui.input.key.Key_androidKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNode_androidKt;
import kotlin.Metadata;

/* compiled from: Clickable.android.kt */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\r\u001a\u00020\u0005*\u00020\u000eH\u0000\u001a\f\u0010\u000f\u001a\u00020\u0005*\u00020\u0010H\u0002\"\u0014\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0018\u0010\u0004\u001a\u00020\u0005*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0018\u0010\t\u001a\u00020\u0005*\u00020\u00068BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\b\"\u0018\u0010\u000b\u001a\u00020\u0005*\u00020\u00068@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\b¨\u0006\u0011"}, d2 = {"TapIndicationDelay", "", "getTapIndicationDelay", "()J", "isClick", "", "Landroidx/compose/ui/input/key/KeyEvent;", "isClick-ZmokQxo", "(Landroid/view/KeyEvent;)Z", "isEnter", "isEnter-ZmokQxo", "isPress", "isPress-ZmokQxo", "isComposeRootInScrollableContainer", "Landroidx/compose/ui/node/DelegatableNode;", "isInScrollableViewGroup", "Landroid/view/View;", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Clickable_androidKt {
    private static final long TapIndicationDelay = ViewConfiguration.getTapTimeout();

    public static final boolean isComposeRootInScrollableContainer(DelegatableNode delegatableNode) {
        return isInScrollableViewGroup(DelegatableNode_androidKt.requireView(delegatableNode));
    }

    private static final boolean isInScrollableViewGroup(View view) {
        ViewParent parent = view.getParent();
        while (parent != null && (parent instanceof ViewGroup)) {
            ViewGroup viewGroup = (ViewGroup) parent;
            if (viewGroup.shouldDelayChildPressedState()) {
                return true;
            }
            parent = viewGroup.getParent();
        }
        return false;
    }

    public static final long getTapIndicationDelay() {
        return TapIndicationDelay;
    }

    /* renamed from: isPress-ZmokQxo, reason: not valid java name */
    public static final boolean m587isPressZmokQxo(KeyEvent keyEvent) {
        return KeyEventType.m5677equalsimpl0(KeyEvent_androidKt.m5685getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m5681getKeyDownCS__XNY()) && m586isEnterZmokQxo(keyEvent);
    }

    /* renamed from: isClick-ZmokQxo, reason: not valid java name */
    public static final boolean m585isClickZmokQxo(KeyEvent keyEvent) {
        return KeyEventType.m5677equalsimpl0(KeyEvent_androidKt.m5685getTypeZmokQxo(keyEvent), KeyEventType.INSTANCE.m5682getKeyUpCS__XNY()) && m586isEnterZmokQxo(keyEvent);
    }

    /* renamed from: isEnter-ZmokQxo, reason: not valid java name */
    private static final boolean m586isEnterZmokQxo(KeyEvent keyEvent) {
        int iM5691getNativeKeyCodeYVgTNJs = Key_androidKt.m5691getNativeKeyCodeYVgTNJs(KeyEvent_androidKt.m5684getKeyZmokQxo(keyEvent));
        return iM5691getNativeKeyCodeYVgTNJs == 23 || iM5691getNativeKeyCodeYVgTNJs == 66 || iM5691getNativeKeyCodeYVgTNJs == 160;
    }
}
