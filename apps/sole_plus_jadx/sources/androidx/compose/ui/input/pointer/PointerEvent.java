package androidx.compose.ui.input.pointer;

import android.os.Build;
import android.view.MotionEvent;
import com.android.SdkConstants;
import java.util.List;
import kotlin.Metadata;

/* compiled from: PointerEvent.android.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\u00020\u0001B!\b\u0000\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bB\u0017\b\u0016\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0007\u0010\tJ\u000f\u0010#\u001a\u00020\u001eH\u0002¢\u0006\u0004\b$\u0010\u0015J\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003J\u001e\u0010&\u001a\u00020\u00002\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0016\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u0013¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0013\u0010\u0016\u001a\u00020\u0017¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0018\u0010\u0015R\u0013\u0010\u001a\u001a\u00020\u001b¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u001c\u0010\u0015R&\u0010\u001f\u001a\u00020\u001e2\u0006\u0010\u001d\u001a\u00020\u001e@@X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0019\u001a\u0004\b \u0010\u0015\"\u0004\b!\u0010\"¨\u0006'"}, d2 = {"Landroidx/compose/ui/input/pointer/PointerEvent;", "", "changes", "", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", SdkConstants.CONSTRUCTOR_NAME, "(Ljava/util/List;Landroidx/compose/ui/input/pointer/InternalPointerEvent;)V", "(Ljava/util/List;)V", "getChanges", "()Ljava/util/List;", "getInternalPointerEvent$ui_release", "()Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "motionEvent", "Landroid/view/MotionEvent;", "getMotionEvent", "()Landroid/view/MotionEvent;", "classification", "", "getClassification", "()I", "buttons", "Landroidx/compose/ui/input/pointer/PointerButtons;", "getButtons-ry648PA", "I", "keyboardModifiers", "Landroidx/compose/ui/input/pointer/PointerKeyboardModifiers;", "getKeyboardModifiers-k7X9c1A", "value", "Landroidx/compose/ui/input/pointer/PointerEventType;", "type", "getType-7fucELk", "setType-EhbLWgg$ui_release", "(I)V", "calculatePointerEventType", "calculatePointerEventType-7fucELk", "component1", "copy", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class PointerEvent {
    public static final int $stable = 8;
    private final int buttons;
    private final List<PointerInputChange> changes;
    private final int classification;
    private final InternalPointerEvent internalPointerEvent;
    private final int keyboardModifiers;
    private int type;

    public PointerEvent(List<PointerInputChange> list, InternalPointerEvent internalPointerEvent) {
        MotionEvent motionEvent;
        this.changes = list;
        this.internalPointerEvent = internalPointerEvent;
        this.classification = (Build.VERSION.SDK_INT < 29 || (motionEvent = getMotionEvent()) == null) ? 0 : motionEvent.getClassification();
        MotionEvent motionEvent2 = getMotionEvent();
        this.buttons = PointerButtons.m5762constructorimpl(motionEvent2 != null ? motionEvent2.getButtonState() : 0);
        MotionEvent motionEvent3 = getMotionEvent();
        this.keyboardModifiers = PointerKeyboardModifiers.m5891constructorimpl(motionEvent3 != null ? motionEvent3.getMetaState() : 0);
        this.type = m5768calculatePointerEventType7fucELk();
    }

    public final List<PointerInputChange> getChanges() {
        return this.changes;
    }

    /* renamed from: getInternalPointerEvent$ui_release, reason: from getter */
    public final InternalPointerEvent getInternalPointerEvent() {
        return this.internalPointerEvent;
    }

    public final MotionEvent getMotionEvent() {
        InternalPointerEvent internalPointerEvent = this.internalPointerEvent;
        if (internalPointerEvent != null) {
            return internalPointerEvent.getMotionEvent();
        }
        return null;
    }

    public final int getClassification() {
        return this.classification;
    }

    public PointerEvent(List<PointerInputChange> list) {
        this(list, null);
    }

    /* renamed from: getButtons-ry648PA, reason: not valid java name and from getter */
    public final int getButtons() {
        return this.buttons;
    }

    /* renamed from: getKeyboardModifiers-k7X9c1A, reason: not valid java name and from getter */
    public final int getKeyboardModifiers() {
        return this.keyboardModifiers;
    }

    /* renamed from: getType-7fucELk, reason: not valid java name and from getter */
    public final int getType() {
        return this.type;
    }

    /* renamed from: setType-EhbLWgg$ui_release, reason: not valid java name */
    public final void m5772setTypeEhbLWgg$ui_release(int i) {
        this.type = i;
    }

    /* renamed from: calculatePointerEventType-7fucELk, reason: not valid java name */
    private final int m5768calculatePointerEventType7fucELk() {
        MotionEvent motionEvent = getMotionEvent();
        if (motionEvent != null) {
            int actionMasked = motionEvent.getActionMasked();
            if (actionMasked != 0) {
                if (actionMasked != 1) {
                    if (actionMasked != 2) {
                        switch (actionMasked) {
                        }
                        return PointerEventType.INSTANCE.m5785getPress7fucELk();
                    }
                    return PointerEventType.INSTANCE.m5784getMove7fucELk();
                }
                return PointerEventType.INSTANCE.m5786getRelease7fucELk();
            }
            return PointerEventType.INSTANCE.m5785getPress7fucELk();
        }
        List<PointerInputChange> list = this.changes;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = list.get(i);
            if (PointerEventKt.changedToUpIgnoreConsumed(pointerInputChange)) {
                return PointerEventType.INSTANCE.m5786getRelease7fucELk();
            }
            if (PointerEventKt.changedToDownIgnoreConsumed(pointerInputChange)) {
                return PointerEventType.INSTANCE.m5785getPress7fucELk();
            }
        }
        return PointerEventType.INSTANCE.m5784getMove7fucELk();
    }

    public final List<PointerInputChange> component1() {
        return this.changes;
    }

    /* JADX WARN: Removed duplicated region for block: B:15:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final androidx.compose.ui.input.pointer.PointerEvent copy(java.util.List<androidx.compose.ui.input.pointer.PointerInputChange> r32, android.view.MotionEvent r33) {
        /*
            r31 = this;
            r0 = r31
            r1 = r32
            r2 = r33
            if (r2 != 0) goto L10
            androidx.compose.ui.input.pointer.PointerEvent r2 = new androidx.compose.ui.input.pointer.PointerEvent
            r3 = 0
            r2.<init>(r1, r3)
            goto Lb7
        L10:
            android.view.MotionEvent r3 = r31.getMotionEvent()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual(r2, r3)
            if (r3 == 0) goto L23
            androidx.compose.ui.input.pointer.PointerEvent r2 = new androidx.compose.ui.input.pointer.PointerEvent
            androidx.compose.ui.input.pointer.InternalPointerEvent r3 = r0.internalPointerEvent
            r2.<init>(r1, r3)
            goto Lb7
        L23:
            androidx.collection.LongSparseArray r3 = new androidx.collection.LongSparseArray
            int r4 = r32.size()
            r3.<init>(r4)
            java.util.ArrayList r4 = new java.util.ArrayList
            int r5 = r32.size()
            r4.<init>(r5)
            r5 = r1
            java.util.Collection r5 = (java.util.Collection) r5
            int r5 = r5.size()
            r7 = 0
        L3d:
            if (r7 >= r5) goto La1
            java.lang.Object r8 = r1.get(r7)
            androidx.compose.ui.input.pointer.PointerInputChange r8 = (androidx.compose.ui.input.pointer.PointerInputChange) r8
            long r9 = r8.getId()
            r3.put(r9, r8)
            r9 = r4
            java.util.Collection r9 = (java.util.Collection) r9
            androidx.compose.ui.input.pointer.PointerInputEventData r15 = new androidx.compose.ui.input.pointer.PointerInputEventData
            long r11 = r8.getId()
            long r13 = r8.getUptimeMillis()
            long r16 = r8.getPosition()
            long r18 = r8.getPosition()
            boolean r20 = r8.getPressed()
            float r21 = r8.getPressure()
            int r22 = r8.getType()
            androidx.compose.ui.input.pointer.InternalPointerEvent r10 = r0.internalPointerEvent
            r30 = r7
            if (r10 == 0) goto L7f
            long r6 = r8.getId()
            boolean r6 = r10.m5757activeHoverEvent0FcD4WY(r6)
            r7 = 1
            if (r6 != r7) goto L7f
            goto L80
        L7f:
            r7 = 0
        L80:
            r28 = 1792(0x700, float:2.511E-42)
            r29 = 0
            r23 = 0
            r24 = 0
            r26 = 0
            r10 = r15
            r6 = r15
            r15 = r16
            r17 = r18
            r19 = r20
            r20 = r21
            r21 = r22
            r22 = r7
            r10.<init>(r11, r13, r15, r17, r19, r20, r21, r22, r23, r24, r26, r28, r29)
            r9.add(r6)
            int r7 = r30 + 1
            goto L3d
        La1:
            androidx.compose.ui.input.pointer.PointerInputEvent r5 = new androidx.compose.ui.input.pointer.PointerInputEvent
            long r6 = r33.getEventTime()
            java.util.List r4 = (java.util.List) r4
            r5.<init>(r6, r4, r2)
            androidx.compose.ui.input.pointer.InternalPointerEvent r2 = new androidx.compose.ui.input.pointer.InternalPointerEvent
            r2.<init>(r3, r5)
            androidx.compose.ui.input.pointer.PointerEvent r3 = new androidx.compose.ui.input.pointer.PointerEvent
            r3.<init>(r1, r2)
            r2 = r3
        Lb7:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.PointerEvent.copy(java.util.List, android.view.MotionEvent):androidx.compose.ui.input.pointer.PointerEvent");
    }
}
