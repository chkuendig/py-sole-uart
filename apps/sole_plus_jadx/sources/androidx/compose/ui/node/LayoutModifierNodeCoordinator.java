package androidx.compose.ui.node;

import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidPaint_androidKt;
import androidx.compose.ui.graphics.Canvas;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Paint;
import androidx.compose.ui.graphics.PaintingStyle;
import androidx.compose.ui.graphics.layer.GraphicsLayer;
import androidx.compose.ui.layout.AlignmentLine;
import androidx.compose.ui.layout.ApproachLayoutModifierNode;
import androidx.compose.ui.layout.ApproachMeasureScopeImpl;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntSize;
import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LayoutModifierNodeCoordinator.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0001\u0018\u0000 H2\u00020\u0001:\u0002GHB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010#\u001a\u00020$H\u0016J\u0017\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020\u0016H\u0016¢\u0006\u0004\b(\u0010)J\u0010\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0016J\u0010\u0010-\u001a\u00020+2\u0006\u0010,\u001a\u00020+H\u0016J\u0010\u0010.\u001a\u00020+2\u0006\u0010/\u001a\u00020+H\u0016J\u0010\u00100\u001a\u00020+2\u0006\u0010/\u001a\u00020+H\u0016J'\u00101\u001a\u00020$2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u000207H\u0014¢\u0006\u0004\b8\u00109J:\u00101\u001a\u00020$2\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002052\u0019\u0010:\u001a\u0015\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020$\u0018\u00010;¢\u0006\u0002\b=H\u0014¢\u0006\u0004\b8\u0010>J\b\u0010?\u001a\u00020$H\u0002J\u0010\u0010@\u001a\u00020+2\u0006\u0010A\u001a\u00020BH\u0016J\u001a\u0010C\u001a\u00020$2\u0006\u0010D\u001a\u00020E2\b\u0010F\u001a\u0004\u0018\u000107H\u0016R$\u0010\t\u001a\u00020\u00052\u0006\u0010\b\u001a\u00020\u0005@@X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u0014\u0010\u000e\u001a\u00020\u000f8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00018F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0015\u001a\u0004\u0018\u00010\u0016X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR(\u0010\u001c\u001a\u0004\u0018\u00010\u001b2\b\u0010\b\u001a\u0004\u0018\u00010\u001b@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;", "Landroidx/compose/ui/node/NodeCoordinator;", "layoutNode", "Landroidx/compose/ui/node/LayoutNode;", "measureNode", "Landroidx/compose/ui/node/LayoutModifierNode;", SdkConstants.CONSTRUCTOR_NAME, "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/node/LayoutModifierNode;)V", "value", "layoutModifierNode", "getLayoutModifierNode", "()Landroidx/compose/ui/node/LayoutModifierNode;", "setLayoutModifierNode$ui_release", "(Landroidx/compose/ui/node/LayoutModifierNode;)V", "tail", "Landroidx/compose/ui/Modifier$Node;", "getTail", "()Landroidx/compose/ui/Modifier$Node;", "wrappedNonNull", "getWrappedNonNull", "()Landroidx/compose/ui/node/NodeCoordinator;", "lookaheadConstraints", "Landroidx/compose/ui/unit/Constraints;", "getLookaheadConstraints-DWUhwKw$ui_release", "()Landroidx/compose/ui/unit/Constraints;", "setLookaheadConstraints-_Sx5XlM$ui_release", "(Landroidx/compose/ui/unit/Constraints;)V", "Landroidx/compose/ui/node/LookaheadDelegate;", "lookaheadDelegate", "getLookaheadDelegate", "()Landroidx/compose/ui/node/LookaheadDelegate;", "setLookaheadDelegate", "(Landroidx/compose/ui/node/LookaheadDelegate;)V", "approachMeasureScope", "Landroidx/compose/ui/layout/ApproachMeasureScopeImpl;", "ensureLookaheadDelegateCreated", "", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "minIntrinsicWidth", "", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "placeAt", "position", "Landroidx/compose/ui/unit/IntOffset;", "zIndex", "", "layer", "Landroidx/compose/ui/graphics/layer/GraphicsLayer;", "placeAt-f8xVGno", "(JFLandroidx/compose/ui/graphics/layer/GraphicsLayer;)V", "layerBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/graphics/GraphicsLayerScope;", "Lkotlin/ExtensionFunctionType;", "(JFLkotlin/jvm/functions/Function1;)V", "onAfterPlaceAt", "calculateAlignmentLine", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "performDraw", "canvas", "Landroidx/compose/ui/graphics/Canvas;", "graphicsLayer", "LookaheadDelegateForLayoutModifierNode", "Companion", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LayoutModifierNodeCoordinator extends NodeCoordinator {
    public static final int $stable = 0;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Paint modifierBoundsPaint;
    private ApproachMeasureScopeImpl approachMeasureScope;
    private LayoutModifierNode layoutModifierNode;
    private Constraints lookaheadConstraints;
    private LookaheadDelegate lookaheadDelegate;

    public LayoutModifierNodeCoordinator(LayoutNode layoutNode, LayoutModifierNode layoutModifierNode) {
        super(layoutNode);
        this.layoutModifierNode = layoutModifierNode;
        ApproachMeasureScopeImpl approachMeasureScopeImpl = null;
        this.lookaheadDelegate = layoutNode.getLookaheadRoot() != null ? new LookaheadDelegateForLayoutModifierNode() : null;
        if ((layoutModifierNode.getNode().getKindSet() & NodeKind.m6248constructorimpl(512)) != 0) {
            Intrinsics.checkNotNull(layoutModifierNode, "null cannot be cast to non-null type androidx.compose.ui.layout.ApproachLayoutModifierNode");
            approachMeasureScopeImpl = new ApproachMeasureScopeImpl(this, (ApproachLayoutModifierNode) layoutModifierNode);
        }
        this.approachMeasureScope = approachMeasureScopeImpl;
    }

    public final LayoutModifierNode getLayoutModifierNode() {
        return this.layoutModifierNode;
    }

    public final void setLayoutModifierNode$ui_release(LayoutModifierNode layoutModifierNode) {
        if (!Intrinsics.areEqual(layoutModifierNode, this.layoutModifierNode)) {
            Modifier.Node node = layoutModifierNode.getNode();
            if ((node.getKindSet() & NodeKind.m6248constructorimpl(512)) != 0) {
                Intrinsics.checkNotNull(layoutModifierNode, "null cannot be cast to non-null type androidx.compose.ui.layout.ApproachLayoutModifierNode");
                ApproachLayoutModifierNode approachLayoutModifierNode = (ApproachLayoutModifierNode) layoutModifierNode;
                ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
                if (approachMeasureScopeImpl != null) {
                    approachMeasureScopeImpl.setApproachNode(approachLayoutModifierNode);
                } else {
                    approachMeasureScopeImpl = new ApproachMeasureScopeImpl(this, approachLayoutModifierNode);
                }
                this.approachMeasureScope = approachMeasureScopeImpl;
            } else {
                this.approachMeasureScope = null;
            }
        }
        this.layoutModifierNode = layoutModifierNode;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public Modifier.Node getTail() {
        return this.layoutModifierNode.getNode();
    }

    public final NodeCoordinator getWrappedNonNull() {
        NodeCoordinator wrapped$ui_release = getWrapped();
        Intrinsics.checkNotNull(wrapped$ui_release);
        return wrapped$ui_release;
    }

    /* renamed from: getLookaheadConstraints-DWUhwKw$ui_release, reason: not valid java name and from getter */
    public final Constraints getLookaheadConstraints() {
        return this.lookaheadConstraints;
    }

    /* renamed from: setLookaheadConstraints-_Sx5XlM$ui_release, reason: not valid java name */
    public final void m6149setLookaheadConstraints_Sx5XlM$ui_release(Constraints constraints) {
        this.lookaheadConstraints = constraints;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public LookaheadDelegate getLookaheadDelegate() {
        return this.lookaheadDelegate;
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    protected void setLookaheadDelegate(LookaheadDelegate lookaheadDelegate) {
        this.lookaheadDelegate = lookaheadDelegate;
    }

    /* compiled from: LayoutModifierNodeCoordinator.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0017\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\u0010\u0010\u000e\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u000f\u001a\u00020\u000bH\u0016J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016¨\u0006\u0014"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$LookaheadDelegateForLayoutModifierNode;", "Landroidx/compose/ui/node/LookaheadDelegate;", SdkConstants.CONSTRUCTOR_NAME, "(Landroidx/compose/ui/node/LayoutModifierNodeCoordinator;)V", "measure", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "measure-BRTryo0", "(J)Landroidx/compose/ui/layout/Placeable;", "calculateAlignmentLine", "", "alignmentLine", "Landroidx/compose/ui/layout/AlignmentLine;", "minIntrinsicWidth", "height", "maxIntrinsicWidth", "minIntrinsicHeight", "width", "maxIntrinsicHeight", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private final class LookaheadDelegateForLayoutModifierNode extends LookaheadDelegate {
        public LookaheadDelegateForLayoutModifierNode() {
            super(LayoutModifierNodeCoordinator.this);
        }

        @Override // androidx.compose.ui.layout.Measurable
        /* renamed from: measure-BRTryo0 */
        public Placeable mo5957measureBRTryo0(long constraints) {
            LookaheadDelegateForLayoutModifierNode lookaheadDelegateForLayoutModifierNode = this;
            LayoutModifierNodeCoordinator layoutModifierNodeCoordinator = LayoutModifierNodeCoordinator.this;
            lookaheadDelegateForLayoutModifierNode.m6021setMeasurementConstraintsBRTryo0(constraints);
            layoutModifierNodeCoordinator.m6149setLookaheadConstraints_Sx5XlM$ui_release(Constraints.m7195boximpl(constraints));
            LookaheadDelegate lookaheadDelegate = layoutModifierNodeCoordinator.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            lookaheadDelegateForLayoutModifierNode.set_measureResult(layoutModifierNodeCoordinator.getLayoutModifierNode().mo395measure3p2s80s(this, lookaheadDelegate, constraints));
            return lookaheadDelegateForLayoutModifierNode;
        }

        @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
        public int calculateAlignmentLine(AlignmentLine alignmentLine) {
            int iCalculateAlignmentAndPlaceChildAsNeeded = LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
            getCachedAlignmentLinesMap().set(alignmentLine, iCalculateAlignmentAndPlaceChildAsNeeded);
            return iCalculateAlignmentAndPlaceChildAsNeeded;
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate, androidx.compose.ui.layout.IntrinsicMeasurable
        public int minIntrinsicWidth(int height) {
            LayoutModifierNode layoutModifierNode = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return layoutModifierNode.minIntrinsicWidth(this, lookaheadDelegate, height);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate, androidx.compose.ui.layout.IntrinsicMeasurable
        public int maxIntrinsicWidth(int height) {
            LayoutModifierNode layoutModifierNode = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return layoutModifierNode.maxIntrinsicWidth(this, lookaheadDelegate, height);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate, androidx.compose.ui.layout.IntrinsicMeasurable
        public int minIntrinsicHeight(int width) {
            LayoutModifierNode layoutModifierNode = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return layoutModifierNode.minIntrinsicHeight(this, lookaheadDelegate, width);
        }

        @Override // androidx.compose.ui.node.LookaheadDelegate, androidx.compose.ui.layout.IntrinsicMeasurable
        public int maxIntrinsicHeight(int width) {
            LayoutModifierNode layoutModifierNode = LayoutModifierNodeCoordinator.this.getLayoutModifierNode();
            LookaheadDelegate lookaheadDelegate = LayoutModifierNodeCoordinator.this.getWrappedNonNull().getLookaheadDelegate();
            Intrinsics.checkNotNull(lookaheadDelegate);
            return layoutModifierNode.maxIntrinsicHeight(this, lookaheadDelegate, width);
        }
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public void ensureLookaheadDelegateCreated() {
        if (getLookaheadDelegate() == null) {
            setLookaheadDelegate(new LookaheadDelegateForLayoutModifierNode());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00c0  */
    @Override // androidx.compose.ui.layout.Measurable
    /* renamed from: measure-BRTryo0 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public androidx.compose.ui.layout.Placeable mo5957measureBRTryo0(long r9) {
        /*
            r8 = this;
            boolean r0 = r8.getForceMeasureWithLookaheadConstraints()
            if (r0 == 0) goto L1b
            androidx.compose.ui.unit.Constraints r9 = r8.lookaheadConstraints
            if (r9 == 0) goto Lf
            long r9 = r9.getValue()
            goto L1b
        Lf:
            java.lang.IllegalArgumentException r9 = new java.lang.IllegalArgumentException
            java.lang.String r10 = "Lookahead constraints cannot be null in approach pass."
            java.lang.String r10 = r10.toString()
            r9.<init>(r10)
            throw r9
        L1b:
            r0 = r8
            androidx.compose.ui.node.NodeCoordinator r0 = (androidx.compose.ui.node.NodeCoordinator) r0
            androidx.compose.ui.node.NodeCoordinator.m6215access$setMeasurementConstraintsBRTryo0(r0, r9)
            androidx.compose.ui.layout.ApproachMeasureScopeImpl r0 = access$getApproachMeasureScope$p(r8)
            if (r0 == 0) goto Lc0
            androidx.compose.ui.layout.ApproachLayoutModifierNode r1 = r0.getApproachNode()
            long r2 = r0.mo5935getLookaheadSizeYbymL2g()
            boolean r2 = r1.mo408isMeasurementApproachInProgressozmzZPI(r2)
            r3 = 0
            r4 = 1
            if (r2 != 0) goto L44
            androidx.compose.ui.unit.Constraints r2 = r8.getLookaheadConstraints()
            boolean r2 = androidx.compose.ui.unit.Constraints.m7200equalsimpl(r9, r2)
            if (r2 != 0) goto L42
            goto L44
        L42:
            r2 = r3
            goto L45
        L44:
            r2 = r4
        L45:
            r0.setApproachMeasureRequired$ui_release(r2)
            boolean r2 = r0.getApproachMeasureRequired()
            if (r2 != 0) goto L55
            androidx.compose.ui.node.NodeCoordinator r2 = r8.getWrappedNonNull()
            r2.setForceMeasureWithLookaheadConstraints$ui_release(r4)
        L55:
            r2 = r0
            androidx.compose.ui.layout.ApproachMeasureScope r2 = (androidx.compose.ui.layout.ApproachMeasureScope) r2
            androidx.compose.ui.node.NodeCoordinator r5 = r8.getWrappedNonNull()
            androidx.compose.ui.layout.Measurable r5 = (androidx.compose.ui.layout.Measurable) r5
            androidx.compose.ui.layout.MeasureResult r1 = r1.mo407approachMeasure3p2s80s(r2, r5, r9)
            androidx.compose.ui.node.NodeCoordinator r2 = r8.getWrappedNonNull()
            r2.setForceMeasureWithLookaheadConstraints$ui_release(r3)
            int r2 = r1.getWidth()
            androidx.compose.ui.node.LookaheadDelegate r5 = r8.getLookaheadDelegate()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            int r5 = r5.getWidth()
            if (r2 != r5) goto L8c
            int r2 = r1.getHeight()
            androidx.compose.ui.node.LookaheadDelegate r5 = r8.getLookaheadDelegate()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            int r5 = r5.getHeight()
            if (r2 != r5) goto L8c
            r3 = r4
        L8c:
            boolean r0 = r0.getApproachMeasureRequired()
            if (r0 != 0) goto Lbe
            androidx.compose.ui.node.NodeCoordinator r0 = r8.getWrappedNonNull()
            long r4 = r0.mo5965getSizeYbymL2g()
            androidx.compose.ui.node.NodeCoordinator r0 = r8.getWrappedNonNull()
            androidx.compose.ui.node.LookaheadDelegate r0 = r0.getLookaheadDelegate()
            if (r0 == 0) goto Lad
            long r6 = r0.m6185getSizeYbymL2g$ui_release()
            androidx.compose.ui.unit.IntSize r0 = androidx.compose.ui.unit.IntSize.m7418boximpl(r6)
            goto Lae
        Lad:
            r0 = 0
        Lae:
            boolean r0 = androidx.compose.ui.unit.IntSize.m7423equalsimpl(r4, r0)
            if (r0 == 0) goto Lbe
            if (r3 != 0) goto Lbe
            androidx.compose.ui.node.LayoutModifierNodeCoordinator$measure$1$1$1$1 r0 = new androidx.compose.ui.node.LayoutModifierNodeCoordinator$measure$1$1$1$1
            r0.<init>(r8)
            r1 = r0
            androidx.compose.ui.layout.MeasureResult r1 = (androidx.compose.ui.layout.MeasureResult) r1
        Lbe:
            if (r1 != 0) goto Ld1
        Lc0:
            androidx.compose.ui.node.LayoutModifierNode r0 = r8.getLayoutModifierNode()
            r1 = r8
            androidx.compose.ui.layout.MeasureScope r1 = (androidx.compose.ui.layout.MeasureScope) r1
            androidx.compose.ui.node.NodeCoordinator r2 = r8.getWrappedNonNull()
            androidx.compose.ui.layout.Measurable r2 = (androidx.compose.ui.layout.Measurable) r2
            androidx.compose.ui.layout.MeasureResult r1 = r0.mo395measure3p2s80s(r1, r2, r9)
        Ld1:
            r8.setMeasureResult$ui_release(r1)
            r9 = r8
            androidx.compose.ui.layout.Placeable r9 = (androidx.compose.ui.layout.Placeable) r9
            r8.onMeasured()
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutModifierNodeCoordinator.mo5957measureBRTryo0(long):androidx.compose.ui.layout.Placeable");
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicWidth(int height) {
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
        if (approachMeasureScopeImpl != null) {
            return approachMeasureScopeImpl.getApproachNode().minApproachIntrinsicWidth(approachMeasureScopeImpl, getWrappedNonNull(), height);
        }
        return this.layoutModifierNode.minIntrinsicWidth(this, getWrappedNonNull(), height);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicWidth(int height) {
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
        if (approachMeasureScopeImpl != null) {
            return approachMeasureScopeImpl.getApproachNode().maxApproachIntrinsicWidth(approachMeasureScopeImpl, getWrappedNonNull(), height);
        }
        return this.layoutModifierNode.maxIntrinsicWidth(this, getWrappedNonNull(), height);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int minIntrinsicHeight(int width) {
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
        if (approachMeasureScopeImpl != null) {
            return approachMeasureScopeImpl.getApproachNode().minApproachIntrinsicHeight(approachMeasureScopeImpl, getWrappedNonNull(), width);
        }
        return this.layoutModifierNode.minIntrinsicHeight(this, getWrappedNonNull(), width);
    }

    @Override // androidx.compose.ui.layout.IntrinsicMeasurable
    public int maxIntrinsicHeight(int width) {
        ApproachMeasureScopeImpl approachMeasureScopeImpl = this.approachMeasureScope;
        if (approachMeasureScopeImpl != null) {
            return approachMeasureScopeImpl.getApproachNode().maxApproachIntrinsicHeight(approachMeasureScopeImpl, getWrappedNonNull(), width);
        }
        return this.layoutModifierNode.maxIntrinsicHeight(this, getWrappedNonNull(), width);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator, androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    protected void mo6019placeAtf8xVGno(long position, float zIndex, GraphicsLayer layer) {
        super.mo6019placeAtf8xVGno(position, zIndex, layer);
        onAfterPlaceAt();
    }

    @Override // androidx.compose.ui.node.NodeCoordinator, androidx.compose.ui.layout.Placeable
    /* renamed from: placeAt-f8xVGno */
    protected void mo5958placeAtf8xVGno(long position, float zIndex, Function1<? super GraphicsLayerScope, Unit> layerBlock) {
        super.mo5958placeAtf8xVGno(position, zIndex, layerBlock);
        onAfterPlaceAt();
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void onAfterPlaceAt() {
        /*
            r7 = this;
            boolean r0 = r7.getIsShallowPlacing()
            if (r0 == 0) goto L7
            return
        L7:
            r7.onPlaced()
            androidx.compose.ui.layout.ApproachMeasureScopeImpl r0 = r7.approachMeasureScope
            r1 = 0
            if (r0 == 0) goto L75
            androidx.compose.ui.layout.ApproachLayoutModifierNode r2 = r0.getApproachNode()
            androidx.compose.ui.layout.Placeable$PlacementScope r3 = r7.getPlacementScope()
            androidx.compose.ui.node.LookaheadDelegate r4 = r7.getLookaheadDelegate()
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            androidx.compose.ui.layout.LookaheadLayoutCoordinates r4 = r4.getLookaheadLayoutCoordinates()
            androidx.compose.ui.layout.LayoutCoordinates r4 = (androidx.compose.ui.layout.LayoutCoordinates) r4
            boolean r2 = r2.isPlacementApproachInProgress(r3, r4)
            if (r2 != 0) goto L6d
            boolean r0 = r0.getApproachMeasureRequired()
            if (r0 != 0) goto L6d
            long r2 = r7.mo5965getSizeYbymL2g()
            androidx.compose.ui.node.LookaheadDelegate r0 = r7.getLookaheadDelegate()
            r4 = 0
            if (r0 == 0) goto L44
            long r5 = r0.m6185getSizeYbymL2g$ui_release()
            androidx.compose.ui.unit.IntSize r0 = androidx.compose.ui.unit.IntSize.m7418boximpl(r5)
            goto L45
        L44:
            r0 = r4
        L45:
            boolean r0 = androidx.compose.ui.unit.IntSize.m7423equalsimpl(r2, r0)
            if (r0 == 0) goto L6d
            androidx.compose.ui.node.NodeCoordinator r0 = r7.getWrappedNonNull()
            long r2 = r0.mo5965getSizeYbymL2g()
            androidx.compose.ui.node.NodeCoordinator r0 = r7.getWrappedNonNull()
            androidx.compose.ui.node.LookaheadDelegate r0 = r0.getLookaheadDelegate()
            if (r0 == 0) goto L65
            long r4 = r0.m6185getSizeYbymL2g$ui_release()
            androidx.compose.ui.unit.IntSize r4 = androidx.compose.ui.unit.IntSize.m7418boximpl(r4)
        L65:
            boolean r0 = androidx.compose.ui.unit.IntSize.m7423equalsimpl(r2, r4)
            if (r0 == 0) goto L6d
            r0 = 1
            goto L6e
        L6d:
            r0 = r1
        L6e:
            androidx.compose.ui.node.NodeCoordinator r2 = r7.getWrappedNonNull()
            r2.setForcePlaceWithLookaheadOffset$ui_release(r0)
        L75:
            androidx.compose.ui.layout.MeasureResult r0 = r7.getMeasureResult$ui_release()
            r0.placeChildren()
            androidx.compose.ui.node.NodeCoordinator r0 = r7.getWrappedNonNull()
            r0.setForcePlaceWithLookaheadOffset$ui_release(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.node.LayoutModifierNodeCoordinator.onAfterPlaceAt():void");
    }

    @Override // androidx.compose.ui.node.LookaheadCapablePlaceable
    public int calculateAlignmentLine(AlignmentLine alignmentLine) {
        LookaheadDelegate lookaheadDelegate = getLookaheadDelegate();
        return lookaheadDelegate != null ? lookaheadDelegate.getCachedAlignmentLine$ui_release(alignmentLine) : LayoutModifierNodeCoordinatorKt.calculateAlignmentAndPlaceChildAsNeeded(this, alignmentLine);
    }

    @Override // androidx.compose.ui.node.NodeCoordinator
    public void performDraw(Canvas canvas, GraphicsLayer graphicsLayer) {
        NodeCoordinator wrapped$ui_release;
        getWrappedNonNull().draw(canvas, graphicsLayer);
        if (!LayoutNodeKt.requireOwner(getLayoutNode()).getShowLayoutBounds() || (wrapped$ui_release = getWrapped()) == null) {
            return;
        }
        if (IntSize.m7424equalsimpl0(mo5965getSizeYbymL2g(), wrapped$ui_release.mo5965getSizeYbymL2g()) && IntOffset.m7382equalsimpl0(wrapped$ui_release.getPosition(), IntOffset.INSTANCE.m7394getZeronOccac())) {
            return;
        }
        drawBorder(canvas, modifierBoundsPaint);
    }

    /* compiled from: LayoutModifierNodeCoordinator.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0080\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/node/LayoutModifierNodeCoordinator$Companion;", "", SdkConstants.CONSTRUCTOR_NAME, "()V", "modifierBoundsPaint", "Landroidx/compose/ui/graphics/Paint;", "getModifierBoundsPaint", "()Landroidx/compose/ui/graphics/Paint;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Paint getModifierBoundsPaint() {
            return LayoutModifierNodeCoordinator.modifierBoundsPaint;
        }
    }

    static {
        Paint Paint = AndroidPaint_androidKt.Paint();
        Paint.mo4415setColor8_81llA(Color.INSTANCE.m4565getBlue0d7_KjU());
        Paint.setStrokeWidth(1.0f);
        Paint.mo4419setStylek9PVt8s(PaintingStyle.INSTANCE.m4818getStrokeTiuSbCo());
        modifierBoundsPaint = Paint;
    }
}
