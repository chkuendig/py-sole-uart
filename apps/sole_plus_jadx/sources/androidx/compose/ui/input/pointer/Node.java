package androidx.compose.ui.input.pointer;

import androidx.collection.LongSparseArray;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.input.pointer.util.PointerIdArray;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.DelegatingNode;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.PointerInputModifierNode;
import com.android.SdkConstants;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: HitPathTracker.kt */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00000\u001cH\u0016J.\u0010\u001d\u001a\u00020\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0014H\u0016J\u0010\u0010#\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0016J.\u0010$\u001a\u00020\u00142\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010\u001f\u001a\u00020\u00102\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020\u0014H\u0016J\u001a\u0010%\u001a\u00020\u00142\b\u0010&\u001a\u0004\u0018\u00010\u00122\u0006\u0010'\u001a\u00020\u0012H\u0002J\b\u0010(\u001a\u00020\u0018H\u0002J\u0017\u0010)\u001a\u00020\u00142\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00180+H\u0082\bJ\b\u0010,\u001a\u00020\u0018H\u0016J\u0006\u0010-\u001a\u00020\u0018J\u0010\u0010.\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!H\u0016J\b\u0010/\u001a\u000200H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00061"}, d2 = {"Landroidx/compose/ui/input/pointer/Node;", "Landroidx/compose/ui/input/pointer/NodeParent;", "modifierNode", "Landroidx/compose/ui/Modifier$Node;", SdkConstants.CONSTRUCTOR_NAME, "(Landroidx/compose/ui/Modifier$Node;)V", "getModifierNode", "()Landroidx/compose/ui/Modifier$Node;", "pointerIds", "Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "getPointerIds", "()Landroidx/compose/ui/input/pointer/util/PointerIdArray;", "relevantChanges", "Landroidx/collection/LongSparseArray;", "Landroidx/compose/ui/input/pointer/PointerInputChange;", "coordinates", "Landroidx/compose/ui/layout/LayoutCoordinates;", "pointerEvent", "Landroidx/compose/ui/input/pointer/PointerEvent;", "wasIn", "", "isIn", "hasExited", "removeInvalidPointerIdsAndChanges", "", "pointerIdValue", "", "hitNodes", "Landroidx/collection/MutableObjectList;", "dispatchMainEventPass", "changes", "parentCoordinates", "internalPointerEvent", "Landroidx/compose/ui/input/pointer/InternalPointerEvent;", "isInBounds", "dispatchFinalEventPass", "buildCache", "hasPositionChanged", "oldEvent", "newEvent", "clearCache", "dispatchIfNeeded", "block", "Lkotlin/Function0;", "dispatchCancel", "markIsIn", "cleanUpHits", "toString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Node extends NodeParent {
    public static final int $stable = 8;
    private LayoutCoordinates coordinates;
    private final Modifier.Node modifierNode;
    private PointerEvent pointerEvent;
    private boolean wasIn;
    private final PointerIdArray pointerIds = new PointerIdArray();
    private final LongSparseArray<PointerInputChange> relevantChanges = new LongSparseArray<>(2);
    private boolean isIn = true;
    private boolean hasExited = true;

    public Node(Modifier.Node node) {
        this.modifierNode = node;
    }

    public final Modifier.Node getModifierNode() {
        return this.modifierNode;
    }

    public final PointerIdArray getPointerIds() {
        return this.pointerIds;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void removeInvalidPointerIdsAndChanges(long pointerIdValue, MutableObjectList<Node> hitNodes) {
        if (this.pointerIds.contains(pointerIdValue) && !hitNodes.contains(this)) {
            this.pointerIds.remove(pointerIdValue);
            this.relevantChanges.remove(pointerIdValue);
        }
        MutableVector<Node> children = getChildren();
        Node[] nodeArr = children.content;
        int size = children.getSize();
        for (int i = 0; i < size; i++) {
            nodeArr[i].removeInvalidPointerIdsAndChanges(pointerIdValue, hitNodes);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0275  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0297  */
    /* JADX WARN: Type inference failed for: r5v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v29 */
    /* JADX WARN: Type inference failed for: r5v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v30, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r5v31, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r5v32 */
    /* JADX WARN: Type inference failed for: r5v33 */
    /* JADX WARN: Type inference failed for: r5v34 */
    /* JADX WARN: Type inference failed for: r5v35 */
    /* JADX WARN: Type inference failed for: r5v36 */
    /* JADX WARN: Type inference failed for: r5v37 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public boolean buildCache(androidx.collection.LongSparseArray<androidx.compose.ui.input.pointer.PointerInputChange> r45, androidx.compose.ui.layout.LayoutCoordinates r46, androidx.compose.ui.input.pointer.InternalPointerEvent r47, boolean r48) {
        /*
            Method dump skipped, instructions count: 734
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.input.pointer.Node.buildCache(androidx.collection.LongSparseArray, androidx.compose.ui.layout.LayoutCoordinates, androidx.compose.ui.input.pointer.InternalPointerEvent, boolean):boolean");
    }

    private final boolean hasPositionChanged(PointerEvent oldEvent, PointerEvent newEvent) {
        if (oldEvent == null || oldEvent.getChanges().size() != newEvent.getChanges().size()) {
            return true;
        }
        int size = newEvent.getChanges().size();
        for (int i = 0; i < size; i++) {
            if (!Offset.m4291equalsimpl0(oldEvent.getChanges().get(i).getPosition(), newEvent.getChanges().get(i).getPosition())) {
                return true;
            }
        }
        return false;
    }

    private final void clearCache() {
        this.relevantChanges.clear();
        this.coordinates = null;
    }

    private final boolean dispatchIfNeeded(Function0<Unit> block) {
        if (this.relevantChanges.isEmpty() || !this.modifierNode.getIsAttached()) {
            return false;
        }
        block.invoke();
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10 */
    /* JADX WARN: Type inference failed for: r0v11 */
    /* JADX WARN: Type inference failed for: r0v12 */
    /* JADX WARN: Type inference failed for: r0v13 */
    /* JADX WARN: Type inference failed for: r0v2, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v5 */
    /* JADX WARN: Type inference failed for: r0v6, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r0v7, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r0v8 */
    /* JADX WARN: Type inference failed for: r0v9 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void dispatchCancel() {
        MutableVector<Node> children = getChildren();
        Node[] nodeArr = children.content;
        int size = children.getSize();
        for (int i = 0; i < size; i++) {
            nodeArr[i].dispatchCancel();
        }
        DelegatingNode delegatingNodePop = this.modifierNode;
        int iM6248constructorimpl = NodeKind.m6248constructorimpl(16);
        MutableVector mutableVector = null;
        while (delegatingNodePop != 0) {
            if (delegatingNodePop instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) delegatingNodePop).onCancelPointerInput();
            } else if ((delegatingNodePop.getKindSet() & iM6248constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                Modifier.Node delegate = delegatingNodePop.getDelegate();
                int i2 = 0;
                delegatingNodePop = delegatingNodePop;
                while (delegate != null) {
                    if ((delegate.getKindSet() & iM6248constructorimpl) != 0) {
                        i2++;
                        if (i2 == 1) {
                            delegatingNodePop = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (delegatingNodePop != 0) {
                                if (mutableVector != null) {
                                    mutableVector.add(delegatingNodePop);
                                }
                                delegatingNodePop = 0;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate);
                            }
                        }
                    }
                    delegate = delegate.getChild();
                    delegatingNodePop = delegatingNodePop;
                }
                if (i2 == 1) {
                }
            }
            delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
        }
    }

    public final void markIsIn() {
        this.isIn = true;
    }

    @Override // androidx.compose.ui.input.pointer.NodeParent
    public void cleanUpHits(InternalPointerEvent internalPointerEvent) {
        super.cleanUpHits(internalPointerEvent);
        PointerEvent pointerEvent = this.pointerEvent;
        if (pointerEvent == null) {
            return;
        }
        this.wasIn = this.isIn;
        List<PointerInputChange> changes = pointerEvent.getChanges();
        int size = changes.size();
        for (int i = 0; i < size; i++) {
            PointerInputChange pointerInputChange = changes.get(i);
            boolean pressed = pointerInputChange.getPressed();
            boolean zM5757activeHoverEvent0FcD4WY = internalPointerEvent.m5757activeHoverEvent0FcD4WY(pointerInputChange.getId());
            boolean z = this.isIn;
            if ((!pressed && !zM5757activeHoverEvent0FcD4WY) || (!pressed && !z)) {
                this.pointerIds.remove(pointerInputChange.getId());
            }
        }
        this.isIn = false;
        this.hasExited = PointerEventType.m5778equalsimpl0(pointerEvent.getType(), PointerEventType.INSTANCE.m5783getExit7fucELk());
    }

    public String toString() {
        return "Node(modifierNode=" + this.modifierNode + ", children=" + getChildren() + ", pointerIds=" + this.pointerIds + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r14v10 */
    /* JADX WARN: Type inference failed for: r14v11 */
    /* JADX WARN: Type inference failed for: r14v12 */
    /* JADX WARN: Type inference failed for: r14v13 */
    /* JADX WARN: Type inference failed for: r14v14 */
    /* JADX WARN: Type inference failed for: r14v3, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r14v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r14v6 */
    /* JADX WARN: Type inference failed for: r14v7, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r14v8, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r14v9 */
    /* JADX WARN: Type inference failed for: r2v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v15 */
    /* JADX WARN: Type inference failed for: r2v16, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r2v17, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r2v18 */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    /* JADX WARN: Type inference failed for: r2v21 */
    /* JADX WARN: Type inference failed for: r2v22 */
    /* JADX WARN: Type inference failed for: r2v23 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchMainEventPass(LongSparseArray<PointerInputChange> changes, LayoutCoordinates parentCoordinates, InternalPointerEvent internalPointerEvent, boolean isInBounds) {
        if (this.relevantChanges.isEmpty() || !this.modifierNode.getIsAttached()) {
            return false;
        }
        PointerEvent pointerEvent = this.pointerEvent;
        Intrinsics.checkNotNull(pointerEvent);
        LayoutCoordinates layoutCoordinates = this.coordinates;
        Intrinsics.checkNotNull(layoutCoordinates);
        long jMo5965getSizeYbymL2g = layoutCoordinates.mo5965getSizeYbymL2g();
        DelegatingNode delegatingNodePop = this.modifierNode;
        int iM6248constructorimpl = NodeKind.m6248constructorimpl(16);
        MutableVector mutableVector = null;
        while (delegatingNodePop != 0) {
            if (delegatingNodePop instanceof PointerInputModifierNode) {
                ((PointerInputModifierNode) delegatingNodePop).mo513onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Initial, jMo5965getSizeYbymL2g);
            } else if ((delegatingNodePop.getKindSet() & iM6248constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                Modifier.Node delegate = delegatingNodePop.getDelegate();
                int i = 0;
                delegatingNodePop = delegatingNodePop;
                while (delegate != null) {
                    if ((delegate.getKindSet() & iM6248constructorimpl) != 0) {
                        i++;
                        if (i == 1) {
                            delegatingNodePop = delegate;
                        } else {
                            if (mutableVector == null) {
                                mutableVector = new MutableVector(new Modifier.Node[16], 0);
                            }
                            if (delegatingNodePop != 0) {
                                if (mutableVector != null) {
                                    mutableVector.add(delegatingNodePop);
                                }
                                delegatingNodePop = 0;
                            }
                            if (mutableVector != null) {
                                mutableVector.add(delegate);
                            }
                        }
                    }
                    delegate = delegate.getChild();
                    delegatingNodePop = delegatingNodePop;
                }
                if (i == 1) {
                }
            }
            delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
        }
        if (this.modifierNode.getIsAttached()) {
            MutableVector<Node> children = getChildren();
            Node[] nodeArr = children.content;
            int size = children.getSize();
            for (int i2 = 0; i2 < size; i2++) {
                Node node = nodeArr[i2];
                LongSparseArray<PointerInputChange> longSparseArray = this.relevantChanges;
                LayoutCoordinates layoutCoordinates2 = this.coordinates;
                Intrinsics.checkNotNull(layoutCoordinates2);
                node.dispatchMainEventPass(longSparseArray, layoutCoordinates2, internalPointerEvent, isInBounds);
            }
        }
        if (this.modifierNode.getIsAttached()) {
            DelegatingNode delegatingNodePop2 = this.modifierNode;
            int iM6248constructorimpl2 = NodeKind.m6248constructorimpl(16);
            MutableVector mutableVector2 = null;
            while (delegatingNodePop2 != 0) {
                if (delegatingNodePop2 instanceof PointerInputModifierNode) {
                    ((PointerInputModifierNode) delegatingNodePop2).mo513onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Main, jMo5965getSizeYbymL2g);
                } else if ((delegatingNodePop2.getKindSet() & iM6248constructorimpl2) != 0 && (delegatingNodePop2 instanceof DelegatingNode)) {
                    Modifier.Node delegate2 = delegatingNodePop2.getDelegate();
                    int i3 = 0;
                    delegatingNodePop2 = delegatingNodePop2;
                    while (delegate2 != null) {
                        if ((delegate2.getKindSet() & iM6248constructorimpl2) != 0) {
                            i3++;
                            if (i3 == 1) {
                                delegatingNodePop2 = delegate2;
                            } else {
                                if (mutableVector2 == null) {
                                    mutableVector2 = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (delegatingNodePop2 != 0) {
                                    if (mutableVector2 != null) {
                                        mutableVector2.add(delegatingNodePop2);
                                    }
                                    delegatingNodePop2 = 0;
                                }
                                if (mutableVector2 != null) {
                                    mutableVector2.add(delegate2);
                                }
                            }
                        }
                        delegate2 = delegate2.getChild();
                        delegatingNodePop2 = delegatingNodePop2;
                    }
                    if (i3 == 1) {
                    }
                }
                delegatingNodePop2 = DelegatableNodeKt.pop(mutableVector2);
            }
        }
        return true;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r4v0, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v1, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v10 */
    /* JADX WARN: Type inference failed for: r4v11 */
    /* JADX WARN: Type inference failed for: r4v3 */
    /* JADX WARN: Type inference failed for: r4v4, types: [androidx.compose.ui.Modifier$Node] */
    /* JADX WARN: Type inference failed for: r4v5, types: [java.lang.Object] */
    /* JADX WARN: Type inference failed for: r4v6 */
    /* JADX WARN: Type inference failed for: r4v7 */
    /* JADX WARN: Type inference failed for: r4v8 */
    /* JADX WARN: Type inference failed for: r4v9 */
    @Override // androidx.compose.ui.input.pointer.NodeParent
    public boolean dispatchFinalEventPass(InternalPointerEvent internalPointerEvent) {
        boolean z = false;
        z = false;
        if (!this.relevantChanges.isEmpty() && this.modifierNode.getIsAttached()) {
            PointerEvent pointerEvent = this.pointerEvent;
            Intrinsics.checkNotNull(pointerEvent);
            LayoutCoordinates layoutCoordinates = this.coordinates;
            Intrinsics.checkNotNull(layoutCoordinates);
            long jMo5965getSizeYbymL2g = layoutCoordinates.mo5965getSizeYbymL2g();
            DelegatingNode delegatingNodePop = this.modifierNode;
            int iM6248constructorimpl = NodeKind.m6248constructorimpl(16);
            MutableVector mutableVector = null;
            while (delegatingNodePop != 0) {
                if (delegatingNodePop instanceof PointerInputModifierNode) {
                    ((PointerInputModifierNode) delegatingNodePop).mo513onPointerEventH0pRuoY(pointerEvent, PointerEventPass.Final, jMo5965getSizeYbymL2g);
                } else if ((delegatingNodePop.getKindSet() & iM6248constructorimpl) != 0 && (delegatingNodePop instanceof DelegatingNode)) {
                    Modifier.Node delegate = delegatingNodePop.getDelegate();
                    int i = 0;
                    delegatingNodePop = delegatingNodePop;
                    while (delegate != null) {
                        if ((delegate.getKindSet() & iM6248constructorimpl) != 0) {
                            i++;
                            if (i == 1) {
                                delegatingNodePop = delegate;
                            } else {
                                if (mutableVector == null) {
                                    mutableVector = new MutableVector(new Modifier.Node[16], 0);
                                }
                                if (delegatingNodePop != 0) {
                                    if (mutableVector != null) {
                                        mutableVector.add(delegatingNodePop);
                                    }
                                    delegatingNodePop = 0;
                                }
                                if (mutableVector != null) {
                                    mutableVector.add(delegate);
                                }
                            }
                        }
                        delegate = delegate.getChild();
                        delegatingNodePop = delegatingNodePop;
                    }
                    if (i == 1) {
                    }
                }
                delegatingNodePop = DelegatableNodeKt.pop(mutableVector);
            }
            if (this.modifierNode.getIsAttached()) {
                MutableVector<Node> children = getChildren();
                Node[] nodeArr = children.content;
                int size = children.getSize();
                for (int i2 = 0; i2 < size; i2++) {
                    nodeArr[i2].dispatchFinalEventPass(internalPointerEvent);
                }
            }
            z = true;
        }
        cleanUpHits(internalPointerEvent);
        clearCache();
        return z;
    }
}
