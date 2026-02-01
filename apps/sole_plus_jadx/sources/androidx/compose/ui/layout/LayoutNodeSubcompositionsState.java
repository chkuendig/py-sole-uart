package androidx.compose.ui.layout;

import androidx.collection.IntSetKt;
import androidx.collection.MutableIntSet;
import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.runtime.ComposeNodeLifecycleCallback;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.PausableComposition;
import androidx.compose.runtime.PausedComposition;
import androidx.compose.runtime.ReusableComposition;
import androidx.compose.runtime.ShouldPauseCallback;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.Snapshot;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.internal.InlineClassHelperKt;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutState;
import androidx.compose.ui.layout.SubcomposeSlotReusePolicy;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.LayoutNodeKt;
import androidx.compose.ui.node.LookaheadDelegate;
import androidx.compose.ui.node.LookaheadPassDelegate;
import androidx.compose.ui.node.MeasurePassDelegate;
import androidx.compose.ui.node.NodeChain;
import androidx.compose.ui.node.OutOfFrameExecutor;
import androidx.compose.ui.node.TraversableNode;
import androidx.compose.ui.node.TraversableNodeKt;
import androidx.compose.ui.platform.SubcompositionKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.DpRect;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.exifinterface.media.ExifInterface;
import com.android.SdkConstants;
import com.google.android.gms.measurement.api.AppMeasurementSdk;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: SubcomposeLayout.kt */
@Metadata(d1 = {"\u0000¸\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0011\b\u0001\u0018\u00002\u00020\u0001:\u0003opqB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010(\u001a\u00020)H\u0016J\b\u0010*\u001a\u00020)H\u0016J\b\u0010+\u001a\u00020)H\u0016J.\u0010,\u001a\b\u0012\u0004\u0012\u00020.0-2\b\u0010/\u001a\u0004\u0018\u00010\u001a2\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020)01¢\u0006\u0002\b2¢\u0006\u0002\u00103J:\u0010,\u001a\u00020)2\u0006\u00104\u001a\u00020\u00032\b\u0010/\u001a\u0004\u0018\u00010\u001a2\u0006\u00105\u001a\u0002062\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020)01¢\u0006\u0002\b2H\u0002¢\u0006\u0002\u00107J \u0010,\u001a\u00020)2\u0006\u00104\u001a\u00020\u00032\u0006\u0010<\u001a\u00020\u00182\u0006\u00105\u001a\u000206H\u0002J \u0010=\u001a\u0004\u0018\u00010\u001a2\f\u0010>\u001a\b\u0012\u0004\u0012\u00020\u00030-2\u0006\u0010?\u001a\u00020\u0014H\u0002J\u000e\u0010@\u001a\u00020)2\u0006\u0010A\u001a\u00020\u0014J\u0014\u0010B\u001a\u00020)*\u00020\u00182\u0006\u0010C\u001a\u000209H\u0002J\u0010\u0010D\u001a\u00020)2\u0006\u0010E\u001a\u000206H\u0002J\b\u0010F\u001a\u00020)H\u0002J\u0006\u0010G\u001a\u00020)J\f\u0010H\u001a\u00020)*\u00020\u0003H\u0002J\u0014\u0010I\u001a\u0004\u0018\u00010\u00032\b\u0010/\u001a\u0004\u0018\u00010\u001aH\u0002J%\u0010J\u001a\u00020K2\u001d\u0010L\u001a\u0019\u0012\u0004\u0012\u00020N\u0012\u0004\u0012\u00020O\u0012\u0004\u0012\u00020P0M¢\u0006\u0002\bQJ\b\u0010R\u001a\u00020)H\u0002J!\u0010S\u001a\u00020P2\u0006\u0010T\u001a\u00020P2\u000e\b\u0004\u0010U\u001a\b\u0012\u0004\u0012\u00020)01H\u0082\bJ(\u0010X\u001a\u00020#2\b\u0010/\u001a\u0004\u0018\u00010\u001a2\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020)01¢\u0006\u0002\b2¢\u0006\u0002\u0010YJ2\u0010X\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u00010\u001a2\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020)01¢\u0006\u0002\b22\u0006\u00105\u001a\u000206H\u0002¢\u0006\u0002\u0010ZJ\u0014\u0010[\u001a\u00020)*\u00020\u00182\u0006\u0010\\\u001a\u000206H\u0002J\f\u0010]\u001a\u00020)*\u00020\u0018H\u0002J\u0012\u0010^\u001a\u00020)2\b\u0010/\u001a\u0004\u0018\u00010\u001aH\u0002J\u0012\u0010_\u001a\u00020#2\b\u0010/\u001a\u0004\u0018\u00010\u001aH\u0002J(\u0010`\u001a\u00020a2\b\u0010/\u001a\u0004\u0018\u00010\u001a2\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020)01¢\u0006\u0002\b2¢\u0006\u0002\u0010bJ\u0006\u0010c\u001a\u00020)J\u0010\u0010d\u001a\u00020\u00032\u0006\u0010?\u001a\u00020\u0014H\u0002J\"\u0010e\u001a\u00020)2\u0006\u0010f\u001a\u00020\u00142\u0006\u0010g\u001a\u00020\u00142\b\b\u0002\u0010h\u001a\u00020\u0014H\u0002J\"\u0010i\u001a\u0002Hj\"\u0004\b\u0000\u0010j2\f\u0010L\u001a\b\u0012\u0004\u0012\u0002Hj01H\u0082\b¢\u0006\u0002\u0010kJ\u0014\u0010l\u001a\u00020)*\u00020\u00182\u0006\u0010m\u001a\u000206H\u0002J0\u0010n\u001a\b\u0012\u0004\u0012\u00020.0-2\b\u0010/\u001a\u0004\u0018\u00010\u001a2\u0011\u00100\u001a\r\u0012\u0004\u0012\u00020)01¢\u0006\u0002\b2H\u0002¢\u0006\u0002\u00103R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00180\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0019\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u00030\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001b\u001a\u00060\u001cR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001d\u001a\u00060\u001eR\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u001f\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020\u00030\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020!X\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\"\u001a\u0010\u0012\u0006\u0012\u0004\u0018\u00010\u001a\u0012\u0004\u0012\u00020#0\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010$\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001a0%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u00108\u001a\u0004\u0018\u0001098BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b:\u0010;R\u000e\u0010V\u001a\u00020WX\u0082D¢\u0006\u0002\n\u0000¨\u0006r"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;", "Landroidx/compose/runtime/ComposeNodeLifecycleCallback;", "root", "Landroidx/compose/ui/node/LayoutNode;", "slotReusePolicy", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", SdkConstants.CONSTRUCTOR_NAME, "(Landroidx/compose/ui/node/LayoutNode;Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "compositionContext", "Landroidx/compose/runtime/CompositionContext;", "getCompositionContext", "()Landroidx/compose/runtime/CompositionContext;", "setCompositionContext", "(Landroidx/compose/runtime/CompositionContext;)V", "value", "getSlotReusePolicy", "()Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;", "setSlotReusePolicy", "(Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy;)V", "currentIndex", "", "currentApproachIndex", "nodeToNodeState", "Landroidx/collection/MutableScatterMap;", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;", "slotIdToNode", "", "scope", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$Scope;", "approachMeasureScope", "Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$ApproachMeasureScopeImpl;", "precomposeMap", "reusableSlotIdsSet", "Landroidx/compose/ui/layout/SubcomposeSlotReusePolicy$SlotIdsSet;", "approachPrecomposeSlotHandleMap", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "approachComposedSlotIds", "Landroidx/compose/runtime/collection/MutableVector;", "reusableCount", "precomposedCount", "onReuse", "", "onDeactivate", "onRelease", "subcompose", "", "Landroidx/compose/ui/layout/Measurable;", "slotId", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "node", "pausable", "", "(Landroidx/compose/ui/node/LayoutNode;Ljava/lang/Object;ZLkotlin/jvm/functions/Function2;)V", "outOfFrameExecutor", "Landroidx/compose/ui/node/OutOfFrameExecutor;", "getOutOfFrameExecutor", "()Landroidx/compose/ui/node/OutOfFrameExecutor;", "nodeState", "getSlotIdAtIndex", "foldedChildren", "index", "disposeOrReuseStartingFromIndex", "startIndex", "deactivateOutOfFrame", "executor", "markActiveNodesAsReused", "deactivate", "disposeCurrentNodes", "makeSureStateIsConsistent", "resetLayoutState", "takeNodeFromReusables", "createMeasurePolicy", "Landroidx/compose/ui/layout/MeasurePolicy;", "block", "Lkotlin/Function2;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/unit/Constraints;", "Landroidx/compose/ui/layout/MeasureResult;", "Lkotlin/ExtensionFunctionType;", "disposeUnusedSlotsInApproach", "createMeasureResult", "result", "placeChildrenBlock", "NoIntrinsicsMessage", "", "precompose", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PrecomposedSlotHandle;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Z)V", "reuseComposition", "forceDeactivate", "cancelPausedPrecomposition", "disposePrecomposedSlot", "createPrecomposedSlotHandle", "precomposePaused", "Landroidx/compose/ui/layout/SubcomposeLayoutState$PausedPrecomposition;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Landroidx/compose/ui/layout/SubcomposeLayoutState$PausedPrecomposition;", "forceRecomposeChildren", "createNodeAt", "move", "from", "to", "count", "ignoreRemeasureRequests", ExifInterface.GPS_DIRECTION_TRUE, "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "applyPausedPrecomposition", "shouldComplete", "approachSubcompose", "NodeState", "Scope", "ApproachMeasureScopeImpl", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LayoutNodeSubcompositionsState implements ComposeNodeLifecycleCallback {
    public static final int $stable = 8;
    private CompositionContext compositionContext;
    private int currentApproachIndex;
    private int currentIndex;
    private int precomposedCount;
    private int reusableCount;
    private final LayoutNode root;
    private SubcomposeSlotReusePolicy slotReusePolicy;
    private final MutableScatterMap<LayoutNode, NodeState> nodeToNodeState = ScatterMapKt.mutableScatterMapOf();
    private final MutableScatterMap<Object, LayoutNode> slotIdToNode = ScatterMapKt.mutableScatterMapOf();
    private final Scope scope = new Scope();
    private final ApproachMeasureScopeImpl approachMeasureScope = new ApproachMeasureScopeImpl();
    private final MutableScatterMap<Object, LayoutNode> precomposeMap = ScatterMapKt.mutableScatterMapOf();
    private final SubcomposeSlotReusePolicy.SlotIdsSet reusableSlotIdsSet = new SubcomposeSlotReusePolicy.SlotIdsSet(null, 1, null);
    private final MutableScatterMap<Object, SubcomposeLayoutState.PrecomposedSlotHandle> approachPrecomposeSlotHandleMap = ScatterMapKt.mutableScatterMapOf();
    private final MutableVector<Object> approachComposedSlotIds = new MutableVector<>(new Object[16], 0);
    private final String NoIntrinsicsMessage = "Asking for intrinsic measurements of SubcomposeLayout layouts is not supported. This includes components that are built on top of SubcomposeLayout, such as lazy lists, BoxWithConstraints, TabRow, etc. To mitigate this:\n- if intrinsic measurements are used to achieve 'match parent' sizing, consider replacing the parent of the component with a custom layout which controls the order in which children are measured, making intrinsic measurement not needed\n- adding a size modifier to the component, in order to fast return the queried intrinsic measurement.";

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean applyPausedPrecomposition$lambda$28$lambda$27$lambda$26() {
        return false;
    }

    public LayoutNodeSubcompositionsState(LayoutNode layoutNode, SubcomposeSlotReusePolicy subcomposeSlotReusePolicy) {
        this.root = layoutNode;
        this.slotReusePolicy = subcomposeSlotReusePolicy;
    }

    public final CompositionContext getCompositionContext() {
        return this.compositionContext;
    }

    public final void setCompositionContext(CompositionContext compositionContext) {
        this.compositionContext = compositionContext;
    }

    public final SubcomposeSlotReusePolicy getSlotReusePolicy() {
        return this.slotReusePolicy;
    }

    public final void setSlotReusePolicy(SubcomposeSlotReusePolicy subcomposeSlotReusePolicy) {
        if (this.slotReusePolicy != subcomposeSlotReusePolicy) {
            this.slotReusePolicy = subcomposeSlotReusePolicy;
            markActiveNodesAsReused(false);
            LayoutNode.requestRemeasure$ui_release$default(this.root, false, false, false, 7, null);
        }
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onReuse() {
        markActiveNodesAsReused(false);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onDeactivate() {
        markActiveNodesAsReused(true);
    }

    @Override // androidx.compose.runtime.ComposeNodeLifecycleCallback
    public void onRelease() {
        disposeCurrentNodes();
    }

    public final List<Measurable> subcompose(Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
        makeSureStateIsConsistent();
        LayoutNode.LayoutState layoutState$ui_release = this.root.getLayoutState$ui_release();
        if (!(layoutState$ui_release == LayoutNode.LayoutState.Measuring || layoutState$ui_release == LayoutNode.LayoutState.LayingOut || layoutState$ui_release == LayoutNode.LayoutState.LookaheadMeasuring || layoutState$ui_release == LayoutNode.LayoutState.LookaheadLayingOut)) {
            InlineClassHelperKt.throwIllegalStateException("subcompose can only be used inside the measure or layout blocks");
        }
        MutableScatterMap<Object, LayoutNode> mutableScatterMap = this.slotIdToNode;
        LayoutNode layoutNodeRemove = mutableScatterMap.get(slotId);
        if (layoutNodeRemove == null) {
            layoutNodeRemove = this.precomposeMap.remove(slotId);
            if (layoutNodeRemove != null) {
                if (!(this.precomposedCount > 0)) {
                    InlineClassHelperKt.throwIllegalStateException("Check failed.");
                }
                this.precomposedCount--;
            } else {
                layoutNodeRemove = takeNodeFromReusables(slotId);
                if (layoutNodeRemove == null) {
                    layoutNodeRemove = createNodeAt(this.currentIndex);
                }
            }
            mutableScatterMap.set(slotId, layoutNodeRemove);
        }
        LayoutNode layoutNode = layoutNodeRemove;
        if (CollectionsKt.getOrNull(this.root.getFoldedChildren$ui_release(), this.currentIndex) != layoutNode) {
            int iIndexOf = this.root.getFoldedChildren$ui_release().indexOf(layoutNode);
            if (!(iIndexOf >= this.currentIndex)) {
                InlineClassHelperKt.throwIllegalArgumentException("Key \"" + slotId + "\" was already used. If you are using LazyColumn/Row please make sure you provide a unique key for each item.");
            }
            int i = this.currentIndex;
            if (i != iIndexOf) {
                move$default(this, iIndexOf, i, 0, 4, null);
            }
        }
        this.currentIndex++;
        subcompose(layoutNode, slotId, false, content);
        if (layoutState$ui_release == LayoutNode.LayoutState.Measuring || layoutState$ui_release == LayoutNode.LayoutState.LayingOut) {
            return layoutNode.getChildMeasurables$ui_release();
        }
        return layoutNode.getChildLookaheadMeasurables$ui_release();
    }

    private final void subcompose(LayoutNode node, Object slotId, boolean pausable, Function2<? super Composer, ? super Integer, Unit> content) {
        MutableScatterMap<LayoutNode, NodeState> mutableScatterMap = this.nodeToNodeState;
        NodeState nodeState = mutableScatterMap.get(node);
        if (nodeState == null) {
            nodeState = new NodeState(slotId, ComposableSingletons$SubcomposeLayoutKt.INSTANCE.getLambda$641200809$ui_release(), null, 4, null);
            mutableScatterMap.set(node, nodeState);
        }
        NodeState nodeState2 = nodeState;
        boolean z = nodeState2.getContent() != content;
        if (nodeState2.getPausedComposition() != null) {
            if (z) {
                cancelPausedPrecomposition(nodeState2);
            } else if (pausable) {
                return;
            } else {
                applyPausedPrecomposition(nodeState2, true);
            }
        }
        ReusableComposition composition = nodeState2.getComposition();
        boolean hasInvalidations = composition != null ? composition.getHasInvalidations() : true;
        if (z || hasInvalidations || nodeState2.getForceRecompose()) {
            nodeState2.setContent(content);
            subcompose(node, nodeState2, pausable);
            nodeState2.setForceRecompose(false);
        }
    }

    private final OutOfFrameExecutor getOutOfFrameExecutor() {
        if (ComposeUiFlags.isOutOfFrameDeactivationEnabled) {
            return LayoutNodeKt.requireOwner(this.root).getOutOfFrameExecutor();
        }
        return null;
    }

    private final void subcompose(LayoutNode node, final NodeState nodeState, boolean pausable) {
        if (!(nodeState.getPausedComposition() == null)) {
            InlineClassHelperKt.throwIllegalArgumentException("new subcompose call while paused composition is still active");
        }
        Snapshot.Companion companion = Snapshot.INSTANCE;
        Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
        Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
        Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
        try {
            LayoutNode layoutNode = this.root;
            layoutNode.ignoreRemeasureRequests = true;
            PausableComposition composition = nodeState.getComposition();
            CompositionContext compositionContext = this.compositionContext;
            if (compositionContext == null) {
                InlineClassHelperKt.throwIllegalStateExceptionForNullCheck("parent composition reference not set");
                throw new KotlinNothingValueException();
            }
            if (composition == null || composition.isDisposed()) {
                if (pausable) {
                    composition = SubcompositionKt.createPausableSubcomposition(node, compositionContext);
                } else {
                    composition = SubcompositionKt.createSubcomposition(node, compositionContext);
                }
            }
            nodeState.setComposition(composition);
            final ComposableLambda content = nodeState.getContent();
            if (getOutOfFrameExecutor() != null) {
                nodeState.setComposedWithReusableContentHost(false);
            } else {
                nodeState.setComposedWithReusableContentHost(true);
                content = ComposableLambdaKt.composableLambdaInstance(1524156494, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$subcompose$4$1$composable$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                        invoke(composer, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer, int i) {
                        ComposerKt.sourceInformation(composer, "C683@31030L46:SubcomposeLayout.kt#80mrfh");
                        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(1524156494, i, -1, "androidx.compose.ui.layout.LayoutNodeSubcompositionsState.subcompose.<anonymous>.<anonymous>.<anonymous> (SubcomposeLayout.kt:683)");
                            }
                            boolean active = nodeState.getActive();
                            Function2<Composer, Integer, Unit> function2 = content;
                            ComposerKt.sourceInformationMarkerStart(composer, 1991829300, "CC(ReusableContentHost)N(active,content)169@6768L9:Composables.kt#9igjgp");
                            composer.startReusableGroup(207, Boolean.valueOf(active));
                            boolean zChanged = composer.changed(active);
                            if (active) {
                                function2.invoke(composer, 0);
                            } else {
                                composer.deactivateToEndGroup(zChanged);
                            }
                            composer.endReusableGroup();
                            ComposerKt.sourceInformationMarkerEnd(composer);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                                return;
                            }
                            return;
                        }
                        composer.skipToGroupEnd();
                    }
                });
            }
            if (pausable) {
                Intrinsics.checkNotNull(composition, "null cannot be cast to non-null type androidx.compose.runtime.PausableComposition");
                if (nodeState.getForceReuse()) {
                    nodeState.setPausedComposition(((PausableComposition) composition).setPausableContentWithReuse(content));
                } else {
                    nodeState.setPausedComposition(((PausableComposition) composition).setPausableContent(content));
                }
            } else if (nodeState.getForceReuse()) {
                composition.setContentWithReuse(content);
            } else {
                composition.setContent(content);
            }
            nodeState.setForceReuse(false);
            Unit unit = Unit.INSTANCE;
            layoutNode.ignoreRemeasureRequests = false;
            Unit unit2 = Unit.INSTANCE;
        } finally {
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
        }
    }

    private final Object getSlotIdAtIndex(List<LayoutNode> foldedChildren, int index) {
        NodeState nodeState = this.nodeToNodeState.get(foldedChildren.get(index));
        Intrinsics.checkNotNull(nodeState);
        return nodeState.getSlotId();
    }

    public final void disposeOrReuseStartingFromIndex(int startIndex) {
        boolean z = false;
        this.reusableCount = 0;
        List<LayoutNode> foldedChildren$ui_release = this.root.getFoldedChildren$ui_release();
        int size = (foldedChildren$ui_release.size() - this.precomposedCount) - 1;
        if (startIndex <= size) {
            this.reusableSlotIdsSet.clear();
            if (startIndex <= size) {
                int i = startIndex;
                while (true) {
                    this.reusableSlotIdsSet.add(getSlotIdAtIndex(foldedChildren$ui_release, i));
                    if (i == size) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            this.slotReusePolicy.getSlotsToRetain(this.reusableSlotIdsSet);
            Snapshot.Companion companion = Snapshot.INSTANCE;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            boolean z2 = false;
            while (size >= startIndex) {
                try {
                    LayoutNode layoutNode = foldedChildren$ui_release.get(size);
                    NodeState nodeState = this.nodeToNodeState.get(layoutNode);
                    Intrinsics.checkNotNull(nodeState);
                    NodeState nodeState2 = nodeState;
                    Object slotId = nodeState2.getSlotId();
                    if (!this.reusableSlotIdsSet.contains(slotId)) {
                        LayoutNode layoutNode2 = this.root;
                        layoutNode2.ignoreRemeasureRequests = true;
                        this.nodeToNodeState.remove(layoutNode);
                        ReusableComposition composition = nodeState2.getComposition();
                        if (composition != null) {
                            composition.dispose();
                        }
                        this.root.removeAt$ui_release(size, 1);
                        Unit unit = Unit.INSTANCE;
                        layoutNode2.ignoreRemeasureRequests = false;
                    } else {
                        this.reusableCount++;
                        if (nodeState2.getActive()) {
                            resetLayoutState(layoutNode);
                            reuseComposition(nodeState2, false);
                            if (nodeState2.getComposedWithReusableContentHost()) {
                                z2 = true;
                            }
                        }
                    }
                    this.slotIdToNode.remove(slotId);
                    size--;
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            Unit unit2 = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            z = z2;
        }
        if (z) {
            Snapshot.INSTANCE.sendApplyNotifications();
        }
        makeSureStateIsConsistent();
    }

    private final void deactivateOutOfFrame(final NodeState nodeState, OutOfFrameExecutor outOfFrameExecutor) {
        outOfFrameExecutor.schedule(new Function0<Unit>() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.deactivateOutOfFrame.1
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                ReusableComposition composition;
                if (nodeState.getActive() || (composition = nodeState.getComposition()) == null) {
                    return;
                }
                composition.deactivate();
            }
        });
    }

    private final void markActiveNodesAsReused(boolean deactivate) {
        this.precomposedCount = 0;
        this.precomposeMap.clear();
        List<LayoutNode> foldedChildren$ui_release = this.root.getFoldedChildren$ui_release();
        int size = foldedChildren$ui_release.size();
        if (this.reusableCount != size) {
            this.reusableCount = size;
            Snapshot.Companion companion = Snapshot.INSTANCE;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            for (int i = 0; i < size; i++) {
                try {
                    LayoutNode layoutNode = foldedChildren$ui_release.get(i);
                    NodeState nodeState = this.nodeToNodeState.get(layoutNode);
                    if (nodeState != null && nodeState.getActive()) {
                        resetLayoutState(layoutNode);
                        reuseComposition(nodeState, deactivate);
                        nodeState.setSlotId(SubcomposeLayoutKt.ReusedSlotId);
                    }
                } catch (Throwable th) {
                    companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    throw th;
                }
            }
            Unit unit = Unit.INSTANCE;
            companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            this.slotIdToNode.clear();
        }
        makeSureStateIsConsistent();
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0050  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void disposeCurrentNodes() {
        /*
            r15 = this;
            androidx.compose.ui.node.LayoutNode r0 = r15.root
            r1 = 1
            androidx.compose.ui.node.LayoutNode.access$setIgnoreRemeasureRequests$p(r0, r1)
            androidx.collection.MutableScatterMap<androidx.compose.ui.node.LayoutNode, androidx.compose.ui.layout.LayoutNodeSubcompositionsState$NodeState> r1 = r15.nodeToNodeState
            androidx.collection.ScatterMap r1 = (androidx.collection.ScatterMap) r1
            java.lang.Object[] r2 = r1.values
            long[] r1 = r1.metadata
            int r3 = r1.length
            int r3 = r3 + (-2)
            r4 = 0
            if (r3 < 0) goto L55
            r5 = r4
        L15:
            r6 = r1[r5]
            long r8 = ~r6
            r10 = 7
            long r8 = r8 << r10
            long r8 = r8 & r6
            r10 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r8 = r8 & r10
            int r8 = (r8 > r10 ? 1 : (r8 == r10 ? 0 : -1))
            if (r8 == 0) goto L50
            int r8 = r5 - r3
            int r8 = ~r8
            int r8 = r8 >>> 31
            r9 = 8
            int r8 = 8 - r8
            r10 = r4
        L2f:
            if (r10 >= r8) goto L4e
            r11 = 255(0xff, double:1.26E-321)
            long r11 = r11 & r6
            r13 = 128(0x80, double:6.3E-322)
            int r11 = (r11 > r13 ? 1 : (r11 == r13 ? 0 : -1))
            if (r11 >= 0) goto L4a
            int r11 = r5 << 3
            int r11 = r11 + r10
            r11 = r2[r11]
            androidx.compose.ui.layout.LayoutNodeSubcompositionsState$NodeState r11 = (androidx.compose.ui.layout.LayoutNodeSubcompositionsState.NodeState) r11
            androidx.compose.runtime.ReusableComposition r11 = r11.getComposition()
            if (r11 == 0) goto L4a
            r11.dispose()
        L4a:
            long r6 = r6 >> r9
            int r10 = r10 + 1
            goto L2f
        L4e:
            if (r8 != r9) goto L55
        L50:
            if (r5 == r3) goto L55
            int r5 = r5 + 1
            goto L15
        L55:
            androidx.compose.ui.node.LayoutNode r1 = r15.root
            r1.removeAll$ui_release()
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            androidx.compose.ui.node.LayoutNode.access$setIgnoreRemeasureRequests$p(r0, r4)
            androidx.collection.MutableScatterMap<androidx.compose.ui.node.LayoutNode, androidx.compose.ui.layout.LayoutNodeSubcompositionsState$NodeState> r0 = r15.nodeToNodeState
            r0.clear()
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.ui.node.LayoutNode> r0 = r15.slotIdToNode
            r0.clear()
            r15.precomposedCount = r4
            r15.reusableCount = r4
            androidx.collection.MutableScatterMap<java.lang.Object, androidx.compose.ui.node.LayoutNode> r0 = r15.precomposeMap
            r0.clear()
            r15.makeSureStateIsConsistent()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.disposeCurrentNodes():void");
    }

    public final void makeSureStateIsConsistent() {
        int size = this.root.getFoldedChildren$ui_release().size();
        if (!(this.nodeToNodeState.get_size() == size)) {
            InlineClassHelperKt.throwIllegalArgumentException("Inconsistency between the count of nodes tracked by the state (" + this.nodeToNodeState.get_size() + ") and the children count on the SubcomposeLayout (" + size + "). Are you trying to use the state of the disposed SubcomposeLayout?");
        }
        if (!((size - this.reusableCount) - this.precomposedCount >= 0)) {
            InlineClassHelperKt.throwIllegalArgumentException("Incorrect state. Total children " + size + ". Reusable children " + this.reusableCount + ". Precomposed children " + this.precomposedCount);
        }
        if (this.precomposeMap.get_size() == this.precomposedCount) {
            return;
        }
        InlineClassHelperKt.throwIllegalArgumentException("Incorrect state. Precomposed children " + this.precomposedCount + ". Map size " + this.precomposeMap.get_size());
    }

    private final void resetLayoutState(LayoutNode layoutNode) {
        layoutNode.getMeasurePassDelegate$ui_release().setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
        LookaheadPassDelegate lookaheadPassDelegate$ui_release = layoutNode.getLookaheadPassDelegate$ui_release();
        if (lookaheadPassDelegate$ui_release != null) {
            lookaheadPassDelegate$ui_release.setMeasuredByParent$ui_release(LayoutNode.UsageByParent.NotUsed);
        }
    }

    private final LayoutNode takeNodeFromReusables(Object slotId) {
        int i;
        if (this.reusableCount == 0) {
            return null;
        }
        List<LayoutNode> foldedChildren$ui_release = this.root.getFoldedChildren$ui_release();
        int size = foldedChildren$ui_release.size() - this.precomposedCount;
        int i2 = size - this.reusableCount;
        int i3 = size - 1;
        int i4 = i3;
        while (true) {
            if (i4 < i2) {
                i = -1;
                break;
            }
            if (Intrinsics.areEqual(getSlotIdAtIndex(foldedChildren$ui_release, i4), slotId)) {
                i = i4;
                break;
            }
            i4--;
        }
        if (i == -1) {
            while (i3 >= i2) {
                NodeState nodeState = this.nodeToNodeState.get(foldedChildren$ui_release.get(i3));
                Intrinsics.checkNotNull(nodeState);
                NodeState nodeState2 = nodeState;
                if (nodeState2.getSlotId() == SubcomposeLayoutKt.ReusedSlotId || this.slotReusePolicy.areCompatible(slotId, nodeState2.getSlotId())) {
                    nodeState2.setSlotId(slotId);
                    i4 = i3;
                    i = i4;
                    break;
                }
                i3--;
            }
            i4 = i3;
        }
        if (i == -1) {
            return null;
        }
        if (i4 != i2) {
            move(i4, i2, 1);
        }
        this.reusableCount--;
        LayoutNode layoutNode = foldedChildren$ui_release.get(i2);
        NodeState nodeState3 = this.nodeToNodeState.get(layoutNode);
        Intrinsics.checkNotNull(nodeState3);
        NodeState nodeState4 = nodeState3;
        nodeState4.setActiveState(SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null));
        nodeState4.setForceReuse(true);
        nodeState4.setForceRecompose(true);
        return layoutNode;
    }

    public final MeasurePolicy createMeasurePolicy(final Function2<? super SubcomposeMeasureScope, ? super Constraints, ? extends MeasureResult> block) {
        return new LayoutNode.NoIntrinsicsMeasurePolicy(this.NoIntrinsicsMessage) { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.createMeasurePolicy.1
            @Override // androidx.compose.ui.layout.MeasurePolicy
            /* renamed from: measure-3p2s80s */
            public MeasureResult mo342measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                LayoutNodeSubcompositionsState.this.scope.setLayoutDirection(measureScope.getLayoutDirection());
                LayoutNodeSubcompositionsState.this.scope.setDensity(measureScope.getDensity());
                LayoutNodeSubcompositionsState.this.scope.setFontScale(measureScope.getFontScale());
                if (measureScope.isLookingAhead() || LayoutNodeSubcompositionsState.this.root.getLookaheadRoot() == null) {
                    LayoutNodeSubcompositionsState.this.currentIndex = 0;
                    final MeasureResult measureResultInvoke = block.invoke(LayoutNodeSubcompositionsState.this.scope, Constraints.m7195boximpl(j));
                    final int i = LayoutNodeSubcompositionsState.this.currentIndex;
                    final LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
                    return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure-3p2s80s$$inlined$createMeasureResult$2
                        @Override // androidx.compose.ui.layout.MeasureResult
                        public Map<AlignmentLine, Integer> getAlignmentLines() {
                            return measureResultInvoke.getAlignmentLines();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        /* renamed from: getHeight */
                        public int get$height() {
                            return measureResultInvoke.get$height();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        public Function1<RulerScope, Unit> getRulers() {
                            return measureResultInvoke.getRulers();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        /* renamed from: getWidth */
                        public int get$width() {
                            return measureResultInvoke.get$width();
                        }

                        @Override // androidx.compose.ui.layout.MeasureResult
                        public void placeChildren() {
                            layoutNodeSubcompositionsState.currentIndex = i;
                            measureResultInvoke.placeChildren();
                            LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = layoutNodeSubcompositionsState;
                            layoutNodeSubcompositionsState2.disposeOrReuseStartingFromIndex(layoutNodeSubcompositionsState2.currentIndex);
                        }
                    };
                }
                LayoutNodeSubcompositionsState.this.currentApproachIndex = 0;
                final MeasureResult measureResultInvoke2 = block.invoke(LayoutNodeSubcompositionsState.this.approachMeasureScope, Constraints.m7195boximpl(j));
                final int i2 = LayoutNodeSubcompositionsState.this.currentApproachIndex;
                final LayoutNodeSubcompositionsState layoutNodeSubcompositionsState2 = LayoutNodeSubcompositionsState.this;
                return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$createMeasurePolicy$1$measure-3p2s80s$$inlined$createMeasureResult$1
                    @Override // androidx.compose.ui.layout.MeasureResult
                    public Map<AlignmentLine, Integer> getAlignmentLines() {
                        return measureResultInvoke2.getAlignmentLines();
                    }

                    @Override // androidx.compose.ui.layout.MeasureResult
                    /* renamed from: getHeight */
                    public int get$height() {
                        return measureResultInvoke2.get$height();
                    }

                    @Override // androidx.compose.ui.layout.MeasureResult
                    public Function1<RulerScope, Unit> getRulers() {
                        return measureResultInvoke2.getRulers();
                    }

                    @Override // androidx.compose.ui.layout.MeasureResult
                    /* renamed from: getWidth */
                    public int get$width() {
                        return measureResultInvoke2.get$width();
                    }

                    @Override // androidx.compose.ui.layout.MeasureResult
                    public void placeChildren() {
                        layoutNodeSubcompositionsState2.currentApproachIndex = i2;
                        measureResultInvoke2.placeChildren();
                        layoutNodeSubcompositionsState2.disposeUnusedSlotsInApproach();
                    }
                };
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disposeUnusedSlotsInApproach() {
        MutableScatterMap<Object, SubcomposeLayoutState.PrecomposedSlotHandle> mutableScatterMap = this.approachPrecomposeSlotHandleMap;
        long[] jArr = mutableScatterMap.metadata;
        int length = jArr.length - 2;
        if (length < 0) {
            return;
        }
        int i = 0;
        while (true) {
            long j = jArr[i];
            if ((((~j) << 7) & j & (-9187201950435737472L)) != -9187201950435737472L) {
                int i2 = 8 - ((~(i - length)) >>> 31);
                for (int i3 = 0; i3 < i2; i3++) {
                    if ((255 & j) < 128) {
                        int i4 = (i << 3) + i3;
                        Object obj = mutableScatterMap.keys[i4];
                        SubcomposeLayoutState.PrecomposedSlotHandle precomposedSlotHandle = (SubcomposeLayoutState.PrecomposedSlotHandle) mutableScatterMap.values[i4];
                        int iIndexOf = this.approachComposedSlotIds.indexOf(obj);
                        if (iIndexOf < 0 || iIndexOf >= this.currentApproachIndex) {
                            precomposedSlotHandle.dispose();
                            mutableScatterMap.removeValueAt(i4);
                        }
                    }
                    j >>= 8;
                }
                if (i2 != 8) {
                    return;
                }
            }
            if (i == length) {
                return;
            } else {
                i++;
            }
        }
    }

    private final MeasureResult createMeasureResult(final MeasureResult result, final Function0<Unit> placeChildrenBlock) {
        return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.createMeasureResult.1
            @Override // androidx.compose.ui.layout.MeasureResult
            public Map<AlignmentLine, Integer> getAlignmentLines() {
                return result.getAlignmentLines();
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            /* renamed from: getHeight */
            public int get$height() {
                return result.get$height();
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public Function1<RulerScope, Unit> getRulers() {
                return result.getRulers();
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            /* renamed from: getWidth */
            public int get$width() {
                return result.get$width();
            }

            @Override // androidx.compose.ui.layout.MeasureResult
            public void placeChildren() {
                placeChildrenBlock.invoke();
            }
        };
    }

    public final SubcomposeLayoutState.PrecomposedSlotHandle precompose(Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
        precompose(slotId, content, false);
        return createPrecomposedSlotHandle(slotId);
    }

    private final void precompose(Object slotId, Function2<? super Composer, ? super Integer, Unit> content, boolean pausable) {
        if (this.root.isAttached()) {
            makeSureStateIsConsistent();
            if (this.slotIdToNode.containsKey(slotId)) {
                return;
            }
            this.approachPrecomposeSlotHandleMap.remove(slotId);
            MutableScatterMap<Object, LayoutNode> mutableScatterMap = this.precomposeMap;
            LayoutNode layoutNodeTakeNodeFromReusables = mutableScatterMap.get(slotId);
            if (layoutNodeTakeNodeFromReusables == null) {
                layoutNodeTakeNodeFromReusables = takeNodeFromReusables(slotId);
                if (layoutNodeTakeNodeFromReusables != null) {
                    move(this.root.getFoldedChildren$ui_release().indexOf(layoutNodeTakeNodeFromReusables), this.root.getFoldedChildren$ui_release().size(), 1);
                    this.precomposedCount++;
                } else {
                    layoutNodeTakeNodeFromReusables = createNodeAt(this.root.getFoldedChildren$ui_release().size());
                    this.precomposedCount++;
                }
                mutableScatterMap.set(slotId, layoutNodeTakeNodeFromReusables);
            }
            subcompose(layoutNodeTakeNodeFromReusables, slotId, pausable, content);
        }
    }

    private final void reuseComposition(NodeState nodeState, boolean z) {
        ReusableComposition composition;
        if (z || !nodeState.getComposedWithReusableContentHost()) {
            nodeState.setActiveState(SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null));
        } else {
            nodeState.setActive(false);
        }
        if (nodeState.getPausedComposition() != null) {
            cancelPausedPrecomposition(nodeState);
            return;
        }
        if (z) {
            ReusableComposition composition2 = nodeState.getComposition();
            if (composition2 != null) {
                composition2.deactivate();
                return;
            }
            return;
        }
        OutOfFrameExecutor outOfFrameExecutor = getOutOfFrameExecutor();
        if (outOfFrameExecutor != null) {
            deactivateOutOfFrame(nodeState, outOfFrameExecutor);
        } else {
            if (nodeState.getComposedWithReusableContentHost() || (composition = nodeState.getComposition()) == null) {
                return;
            }
            composition.deactivate();
        }
    }

    private final void cancelPausedPrecomposition(NodeState nodeState) {
        PausedComposition pausedComposition = nodeState.getPausedComposition();
        if (pausedComposition != null) {
            pausedComposition.cancel();
            nodeState.setPausedComposition(null);
            ReusableComposition composition = nodeState.getComposition();
            if (composition != null) {
                composition.dispose();
            }
            nodeState.setComposition(null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void disposePrecomposedSlot(Object slotId) {
        makeSureStateIsConsistent();
        LayoutNode layoutNodeRemove = this.precomposeMap.remove(slotId);
        if (layoutNodeRemove != null) {
            if (!(this.precomposedCount > 0)) {
                InlineClassHelperKt.throwIllegalStateException("No pre-composed items to dispose");
            }
            int iIndexOf = this.root.getFoldedChildren$ui_release().indexOf(layoutNodeRemove);
            if (!(iIndexOf >= this.root.getFoldedChildren$ui_release().size() - this.precomposedCount)) {
                InlineClassHelperKt.throwIllegalStateException("Item is not in pre-composed item range");
            }
            this.reusableCount++;
            this.precomposedCount--;
            NodeState nodeState = this.nodeToNodeState.get(layoutNodeRemove);
            if (nodeState != null) {
                cancelPausedPrecomposition(nodeState);
            }
            int size = (this.root.getFoldedChildren$ui_release().size() - this.precomposedCount) - this.reusableCount;
            move(iIndexOf, size, 1);
            disposeOrReuseStartingFromIndex(size);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SubcomposeLayoutState.PrecomposedSlotHandle createPrecomposedSlotHandle(final Object slotId) {
        if (!this.root.isAttached()) {
            return new SubcomposeLayoutState.PrecomposedSlotHandle() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.createPrecomposedSlotHandle.1
                @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
                public void dispose() {
                }
            };
        }
        return new SubcomposeLayoutState.PrecomposedSlotHandle() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.createPrecomposedSlotHandle.2
            private final MutableIntSet hasPremeasured = IntSetKt.mutableIntSetOf();

            public final MutableIntSet getHasPremeasured() {
                return this.hasPremeasured;
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public void dispose() {
                LayoutNodeSubcompositionsState.this.disposePrecomposedSlot(slotId);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public int getPlaceablesCount() {
                List<LayoutNode> children$ui_release;
                LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.precomposeMap.get(slotId);
                if (layoutNode == null || (children$ui_release = layoutNode.getChildren$ui_release()) == null) {
                    return 0;
                }
                return children$ui_release.size();
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            /* renamed from: premeasure-0kLqBqw, reason: not valid java name */
            public void mo5984premeasure0kLqBqw(int index, long constraints) {
                LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.precomposeMap.get(slotId);
                if (layoutNode == null || !layoutNode.isAttached()) {
                    return;
                }
                int size = layoutNode.getChildren$ui_release().size();
                if (index < 0 || index >= size) {
                    InlineClassHelperKt.throwIndexOutOfBoundsException("Index (" + index + ") is out of bound of [0, " + size + ')');
                }
                if (layoutNode.isPlaced()) {
                    InlineClassHelperKt.throwIllegalArgumentException("Pre-measure called on node that is not placed");
                }
                LayoutNode layoutNode2 = LayoutNodeSubcompositionsState.this.root;
                layoutNode2.ignoreRemeasureRequests = true;
                LayoutNodeKt.requireOwner(layoutNode).mo6311measureAndLayout0kLqBqw(layoutNode.getChildren$ui_release().get(index), constraints);
                Unit unit = Unit.INSTANCE;
                layoutNode2.ignoreRemeasureRequests = false;
                this.hasPremeasured.add(index);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            public void traverseDescendants(Object key, Function1<? super TraversableNode, ? extends TraversableNode.Companion.TraverseDescendantsAction> block) {
                NodeChain nodes;
                Modifier.Node head;
                LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.precomposeMap.get(slotId);
                if (layoutNode == null || (nodes = layoutNode.getNodes()) == null || (head = nodes.getHead()) == null) {
                    return;
                }
                TraversableNodeKt.traverseDescendants(head, key, block);
            }

            /* JADX WARN: Multi-variable type inference failed */
            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PrecomposedSlotHandle
            /* renamed from: getSize-YEO4UFw, reason: not valid java name */
            public long mo5983getSizeYEO4UFw(int index) {
                LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.precomposeMap.get(slotId);
                if (layoutNode != null && layoutNode.isAttached()) {
                    int size = layoutNode.getChildren$ui_release().size();
                    if (index < 0 || index >= size) {
                        InlineClassHelperKt.throwIndexOutOfBoundsException("Index (" + index + ") is out of bound of [0, " + size + ')');
                    }
                    if (this.hasPremeasured.contains(index)) {
                        return IntSize.m7421constructorimpl((layoutNode.getChildren$ui_release().get(index).getWidth() << 32) | (layoutNode.getChildren$ui_release().get(index).getHeight() & 4294967295L));
                    }
                }
                return IntSize.INSTANCE.m7431getZeroYbymL2g();
            }
        };
    }

    public final SubcomposeLayoutState.PausedPrecomposition precomposePaused(final Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
        if (!this.root.isAttached()) {
            return new PausedPrecompositionImpl() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.precomposePaused.1
                private final boolean isComplete = true;

                @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
                public void cancel() {
                }

                @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
                public boolean resume(ShouldPauseCallback shouldPause) {
                    return true;
                }

                @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
                /* renamed from: isComplete, reason: from getter */
                public boolean getIsComplete() {
                    return this.isComplete;
                }

                @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
                public SubcomposeLayoutState.PrecomposedSlotHandle apply() {
                    return LayoutNodeSubcompositionsState.this.createPrecomposedSlotHandle(slotId);
                }
            };
        }
        precompose(slotId, content, true);
        return new PausedPrecompositionImpl() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.precomposePaused.2
            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
            public void cancel() {
                NodeState nodeState = getNodeState();
                if ((nodeState != null ? nodeState.getPausedComposition() : null) != null) {
                    LayoutNodeSubcompositionsState.this.disposePrecomposedSlot(slotId);
                }
            }

            /* JADX WARN: Multi-variable type inference failed */
            private final NodeState getNodeState() {
                LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.precomposeMap.get(slotId);
                if (layoutNode != null) {
                    return (NodeState) LayoutNodeSubcompositionsState.this.nodeToNodeState.get(layoutNode);
                }
                return null;
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
            /* renamed from: isComplete */
            public boolean getIsComplete() {
                PausedComposition pausedComposition;
                NodeState nodeState = getNodeState();
                if (nodeState == null || (pausedComposition = nodeState.getPausedComposition()) == null) {
                    return true;
                }
                return pausedComposition.isComplete();
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
            public boolean resume(ShouldPauseCallback shouldPause) {
                NodeState nodeState = getNodeState();
                PausedComposition pausedComposition = nodeState != null ? nodeState.getPausedComposition() : null;
                boolean zResume = true;
                if (pausedComposition != null && !pausedComposition.isComplete()) {
                    Snapshot.Companion companion = Snapshot.INSTANCE;
                    LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
                    Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
                    Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
                    Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
                    try {
                        LayoutNode layoutNode = layoutNodeSubcompositionsState.root;
                        layoutNode.ignoreRemeasureRequests = true;
                        zResume = pausedComposition.resume(shouldPause);
                        layoutNode.ignoreRemeasureRequests = false;
                    } finally {
                        companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
                    }
                }
                return zResume;
            }

            @Override // androidx.compose.ui.layout.SubcomposeLayoutState.PausedPrecomposition
            public SubcomposeLayoutState.PrecomposedSlotHandle apply() {
                NodeState nodeState = getNodeState();
                if (nodeState != null) {
                    LayoutNodeSubcompositionsState.this.applyPausedPrecomposition(nodeState, false);
                }
                return LayoutNodeSubcompositionsState.this.createPrecomposedSlotHandle(slotId);
            }
        };
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0053  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void forceRecomposeChildren() {
        /*
            r14 = this;
            androidx.compose.ui.node.LayoutNode r0 = r14.root
            java.util.List r0 = r0.getFoldedChildren$ui_release()
            int r0 = r0.size()
            int r1 = r14.reusableCount
            if (r1 == r0) goto L85
            androidx.collection.MutableScatterMap<androidx.compose.ui.node.LayoutNode, androidx.compose.ui.layout.LayoutNodeSubcompositionsState$NodeState> r0 = r14.nodeToNodeState
            androidx.collection.ScatterMap r0 = (androidx.collection.ScatterMap) r0
            java.lang.Object[] r1 = r0.values
            long[] r0 = r0.metadata
            int r2 = r0.length
            int r2 = r2 + (-2)
            if (r2 < 0) goto L58
            r3 = 0
            r4 = r3
        L1d:
            r5 = r0[r4]
            long r7 = ~r5
            r9 = 7
            long r7 = r7 << r9
            long r7 = r7 & r5
            r9 = -9187201950435737472(0x8080808080808080, double:-2.937446524422997E-306)
            long r7 = r7 & r9
            int r7 = (r7 > r9 ? 1 : (r7 == r9 ? 0 : -1))
            if (r7 == 0) goto L53
            int r7 = r4 - r2
            int r7 = ~r7
            int r7 = r7 >>> 31
            r8 = 8
            int r7 = 8 - r7
            r9 = r3
        L37:
            if (r9 >= r7) goto L51
            r10 = 255(0xff, double:1.26E-321)
            long r10 = r10 & r5
            r12 = 128(0x80, double:6.3E-322)
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 >= 0) goto L4d
            int r10 = r4 << 3
            int r10 = r10 + r9
            r10 = r1[r10]
            androidx.compose.ui.layout.LayoutNodeSubcompositionsState$NodeState r10 = (androidx.compose.ui.layout.LayoutNodeSubcompositionsState.NodeState) r10
            r11 = 1
            r10.setForceRecompose(r11)
        L4d:
            long r5 = r5 >> r8
            int r9 = r9 + 1
            goto L37
        L51:
            if (r7 != r8) goto L58
        L53:
            if (r4 == r2) goto L58
            int r4 = r4 + 1
            goto L1d
        L58:
            androidx.compose.ui.node.LayoutNode r0 = r14.root
            androidx.compose.ui.node.LayoutNode r0 = r0.getLookaheadRoot()
            if (r0 == 0) goto L73
            androidx.compose.ui.node.LayoutNode r0 = r14.root
            boolean r0 = r0.getLookaheadMeasurePending$ui_release()
            if (r0 != 0) goto L85
            androidx.compose.ui.node.LayoutNode r1 = r14.root
            r5 = 7
            r6 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            androidx.compose.ui.node.LayoutNode.requestLookaheadRemeasure$ui_release$default(r1, r2, r3, r4, r5, r6)
            goto L85
        L73:
            androidx.compose.ui.node.LayoutNode r0 = r14.root
            boolean r0 = r0.getMeasurePending$ui_release()
            if (r0 != 0) goto L85
            androidx.compose.ui.node.LayoutNode r1 = r14.root
            r5 = 7
            r6 = 0
            r2 = 0
            r3 = 0
            r4 = 0
            androidx.compose.ui.node.LayoutNode.requestRemeasure$ui_release$default(r1, r2, r3, r4, r5, r6)
        L85:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.layout.LayoutNodeSubcompositionsState.forceRecomposeChildren():void");
    }

    private final LayoutNode createNodeAt(int index) {
        LayoutNode layoutNode = new LayoutNode(true, 0, 2, null);
        LayoutNode layoutNode2 = this.root;
        layoutNode2.ignoreRemeasureRequests = true;
        this.root.insertAt$ui_release(index, layoutNode);
        Unit unit = Unit.INSTANCE;
        layoutNode2.ignoreRemeasureRequests = false;
        return layoutNode;
    }

    static /* synthetic */ void move$default(LayoutNodeSubcompositionsState layoutNodeSubcompositionsState, int i, int i2, int i3, int i4, Object obj) {
        if ((i4 & 4) != 0) {
            i3 = 1;
        }
        layoutNodeSubcompositionsState.move(i, i2, i3);
    }

    private final <T> T ignoreRemeasureRequests(Function0<? extends T> block) {
        LayoutNode layoutNode = this.root;
        layoutNode.ignoreRemeasureRequests = true;
        T tInvoke = block.invoke();
        layoutNode.ignoreRemeasureRequests = false;
        return tInvoke;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void applyPausedPrecomposition(NodeState nodeState, boolean z) {
        PausedComposition pausedComposition = nodeState.getPausedComposition();
        if (pausedComposition != null) {
            Snapshot.Companion companion = Snapshot.INSTANCE;
            Snapshot currentThreadSnapshot = companion.getCurrentThreadSnapshot();
            Function1<Object, Unit> readObserver = currentThreadSnapshot != null ? currentThreadSnapshot.getReadObserver() : null;
            Snapshot snapshotMakeCurrentNonObservable = companion.makeCurrentNonObservable(currentThreadSnapshot);
            try {
                LayoutNode layoutNode = this.root;
                layoutNode.ignoreRemeasureRequests = true;
                if (z) {
                    while (!pausedComposition.isComplete()) {
                        pausedComposition.resume(new ShouldPauseCallback() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$$ExternalSyntheticLambda0
                            @Override // androidx.compose.runtime.ShouldPauseCallback
                            public final boolean shouldPause() {
                                return LayoutNodeSubcompositionsState.applyPausedPrecomposition$lambda$28$lambda$27$lambda$26();
                            }
                        });
                    }
                }
                pausedComposition.apply();
                nodeState.setPausedComposition(null);
                Unit unit = Unit.INSTANCE;
                layoutNode.ignoreRemeasureRequests = false;
                Unit unit2 = Unit.INSTANCE;
            } finally {
                companion.restoreNonObservable(currentThreadSnapshot, snapshotMakeCurrentNonObservable, readObserver);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SubcomposeLayout.kt */
    @Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\b\u0002\u0018\u00002\u00020\u0001B0\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001\u0012\u0011\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b¢\u0006\u0004\b\t\u0010\nR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR'\u0010\u0003\u001a\r\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\u0002\b\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001dR\u001c\u0010!\u001a\u0004\u0018\u00010\"X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&R \u0010'\u001a\b\u0012\u0004\u0012\u00020\u00190(X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001a\u0010-\u001a\u00020\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010\u001b\"\u0004\b/\u0010\u001dR$\u00101\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u00198F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b2\u0010\u001b\"\u0004\b3\u0010\u001d¨\u00064"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$NodeState;", "", "slotId", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "composition", "Landroidx/compose/runtime/ReusableComposition;", SdkConstants.CONSTRUCTOR_NAME, "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/ReusableComposition;)V", "getSlotId", "()Ljava/lang/Object;", "setSlotId", "(Ljava/lang/Object;)V", "getContent", "()Lkotlin/jvm/functions/Function2;", "setContent", "(Lkotlin/jvm/functions/Function2;)V", "Lkotlin/jvm/functions/Function2;", "getComposition", "()Landroidx/compose/runtime/ReusableComposition;", "setComposition", "(Landroidx/compose/runtime/ReusableComposition;)V", "forceRecompose", "", "getForceRecompose", "()Z", "setForceRecompose", "(Z)V", "forceReuse", "getForceReuse", "setForceReuse", "pausedComposition", "Landroidx/compose/runtime/PausedComposition;", "getPausedComposition", "()Landroidx/compose/runtime/PausedComposition;", "setPausedComposition", "(Landroidx/compose/runtime/PausedComposition;)V", "activeState", "Landroidx/compose/runtime/MutableState;", "getActiveState", "()Landroidx/compose/runtime/MutableState;", "setActiveState", "(Landroidx/compose/runtime/MutableState;)V", "composedWithReusableContentHost", "getComposedWithReusableContentHost", "setComposedWithReusableContentHost", "value", AppMeasurementSdk.ConditionalUserProperty.ACTIVE, "getActive", "setActive", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    static final class NodeState {
        private MutableState<Boolean> activeState;
        private boolean composedWithReusableContentHost;
        private ReusableComposition composition;
        private Function2<? super Composer, ? super Integer, Unit> content;
        private boolean forceRecompose;
        private boolean forceReuse;
        private PausedComposition pausedComposition;
        private Object slotId;

        public NodeState(Object obj, Function2<? super Composer, ? super Integer, Unit> function2, ReusableComposition reusableComposition) {
            this.slotId = obj;
            this.content = function2;
            this.composition = reusableComposition;
            this.activeState = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
        }

        public /* synthetic */ NodeState(Object obj, Function2 function2, ReusableComposition reusableComposition, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(obj, function2, (i & 4) != 0 ? null : reusableComposition);
        }

        public final Object getSlotId() {
            return this.slotId;
        }

        public final void setSlotId(Object obj) {
            this.slotId = obj;
        }

        public final Function2<Composer, Integer, Unit> getContent() {
            return this.content;
        }

        public final void setContent(Function2<? super Composer, ? super Integer, Unit> function2) {
            this.content = function2;
        }

        public final ReusableComposition getComposition() {
            return this.composition;
        }

        public final void setComposition(ReusableComposition reusableComposition) {
            this.composition = reusableComposition;
        }

        public final boolean getForceRecompose() {
            return this.forceRecompose;
        }

        public final void setForceRecompose(boolean z) {
            this.forceRecompose = z;
        }

        public final boolean getForceReuse() {
            return this.forceReuse;
        }

        public final void setForceReuse(boolean z) {
            this.forceReuse = z;
        }

        public final PausedComposition getPausedComposition() {
            return this.pausedComposition;
        }

        public final void setPausedComposition(PausedComposition pausedComposition) {
            this.pausedComposition = pausedComposition;
        }

        public final MutableState<Boolean> getActiveState() {
            return this.activeState;
        }

        public final void setActiveState(MutableState<Boolean> mutableState) {
            this.activeState = mutableState;
        }

        public final boolean getComposedWithReusableContentHost() {
            return this.composedWithReusableContentHost;
        }

        public final void setComposedWithReusableContentHost(boolean z) {
            this.composedWithReusableContentHost = z;
        }

        public final boolean getActive() {
            return this.activeState.getValue().booleanValue();
        }

        public final void setActive(boolean z) {
            this.activeState.setValue(Boolean.valueOf(z));
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: SubcomposeLayout.kt */
    @Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0082\u0004\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J0\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00180\u00172\b\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\u0011\u0010\u001b\u001a\r\u0012\u0004\u0012\u00020\u001d0\u001c¢\u0006\u0002\b\u001eH\u0016¢\u0006\u0002\u0010\u001fJ`\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020#2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020'\u0012\u0004\u0012\u00020#0&2\u0019\u0010(\u001a\u0015\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u001d\u0018\u00010)¢\u0006\u0002\b+2\u0017\u0010,\u001a\u0013\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u001d0)¢\u0006\u0002\b+H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u000bX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015¨\u0006."}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$Scope;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", SdkConstants.CONSTRUCTOR_NAME, "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "setLayoutDirection", "(Landroidx/compose/ui/unit/LayoutDirection;)V", "density", "", "getDensity", "()F", "setDensity", "(F)V", "fontScale", "getFontScale", "setFontScale", "isLookingAhead", "", "()Z", "subcompose", "", "Landroidx/compose/ui/layout/Measurable;", "slotId", "", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "rulers", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/RulerScope;", "Lkotlin/ExtensionFunctionType;", "placementBlock", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    final class Scope implements SubcomposeMeasureScope {
        private float density;
        private float fontScale;
        private LayoutDirection layoutDirection = LayoutDirection.Rtl;

        public Scope() {
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public LayoutDirection getLayoutDirection() {
            return this.layoutDirection;
        }

        public void setLayoutDirection(LayoutDirection layoutDirection) {
            this.layoutDirection = layoutDirection;
        }

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.density;
        }

        public void setDensity(float f) {
            this.density = f;
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float getFontScale() {
            return this.fontScale;
        }

        public void setFontScale(float f) {
            this.fontScale = f;
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public boolean isLookingAhead() {
            return LayoutNodeSubcompositionsState.this.root.getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadLayingOut || LayoutNodeSubcompositionsState.this.root.getLayoutState$ui_release() == LayoutNode.LayoutState.LookaheadMeasuring;
        }

        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public List<Measurable> subcompose(Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
            return LayoutNodeSubcompositionsState.this.subcompose(slotId, content);
        }

        @Override // androidx.compose.ui.layout.MeasureScope
        public MeasureResult layout(final int width, final int height, final Map<AlignmentLine, Integer> alignmentLines, final Function1<? super RulerScope, Unit> rulers, final Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
            if (!((width & (-16777216)) == 0 && ((-16777216) & height) == 0)) {
                InlineClassHelperKt.throwIllegalStateException("Size(" + width + " x " + height + ") is out of range. Each dimension must be between 0 and 16777215.");
            }
            final LayoutNodeSubcompositionsState layoutNodeSubcompositionsState = LayoutNodeSubcompositionsState.this;
            return new MeasureResult() { // from class: androidx.compose.ui.layout.LayoutNodeSubcompositionsState$Scope$layout$1
                @Override // androidx.compose.ui.layout.MeasureResult
                /* renamed from: getWidth, reason: from getter */
                public int get$width() {
                    return width;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                /* renamed from: getHeight, reason: from getter */
                public int get$height() {
                    return height;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public Map<AlignmentLine, Integer> getAlignmentLines() {
                    return alignmentLines;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public Function1<RulerScope, Unit> getRulers() {
                    return rulers;
                }

                @Override // androidx.compose.ui.layout.MeasureResult
                public void placeChildren() {
                    LookaheadDelegate lookaheadDelegate;
                    if (!this.isLookingAhead() || (lookaheadDelegate = layoutNodeSubcompositionsState.root.getInnerCoordinator$ui_release().getLookaheadDelegate()) == null) {
                        placementBlock.invoke(layoutNodeSubcompositionsState.root.getInnerCoordinator$ui_release().getPlacementScope());
                    } else {
                        placementBlock.invoke(lookaheadDelegate.getPlacementScope());
                    }
                }
            };
        }
    }

    /* compiled from: SubcomposeLayout.kt */
    @Metadata(d1 = {"\u0000\u009c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0082\u0004\u0018\u00002\u00020\u00012\u00020\u0002B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J0\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\b\rH\u0016¢\u0006\u0002\u0010\u000eJF\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120\u00152\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001aH\u0096\u0001Ja\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00122\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00120\u00152\u0019\u0010\u001b\u001a\u0015\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\f\u0018\u00010\u0018¢\u0006\u0002\b\u001a2\u0017\u0010\u0017\u001a\u0013\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\f0\u0018¢\u0006\u0002\b\u001aH\u0096\u0001J\u0014\u0010\u001d\u001a\u00020\u0012*\u00020\u001eH\u0097\u0001¢\u0006\u0004\b\u001f\u0010 J\u0014\u0010\u001d\u001a\u00020\u0012*\u00020!H\u0097\u0001¢\u0006\u0004\b\"\u0010#J\u0014\u0010$\u001a\u00020\u001e*\u00020\u0012H\u0097\u0001¢\u0006\u0004\b%\u0010&J\u0014\u0010$\u001a\u00020\u001e*\u00020'H\u0097\u0001¢\u0006\u0004\b%\u0010(J\u0014\u0010$\u001a\u00020\u001e*\u00020!H\u0097\u0001¢\u0006\u0004\b)\u0010*J\u0014\u0010+\u001a\u00020,*\u00020-H\u0097\u0001¢\u0006\u0004\b.\u0010/J\u0014\u00100\u001a\u00020'*\u00020\u001eH\u0097\u0001¢\u0006\u0004\b1\u0010(J\u0014\u00100\u001a\u00020'*\u00020!H\u0097\u0001¢\u0006\u0004\b2\u0010*J\r\u00103\u001a\u000204*\u000205H\u0097\u0001J\u0014\u00106\u001a\u00020-*\u00020,H\u0097\u0001¢\u0006\u0004\b7\u0010/J\u0014\u00108\u001a\u00020!*\u00020\u0012H\u0097\u0001¢\u0006\u0004\b9\u0010:J\u0014\u00108\u001a\u00020!*\u00020'H\u0097\u0001¢\u0006\u0004\b9\u0010;J\u0014\u00108\u001a\u00020!*\u00020\u001eH\u0097\u0001¢\u0006\u0004\b<\u0010;R\u0014\u0010=\u001a\u00020'8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\b>\u0010?R\u0014\u0010@\u001a\u00020'8\u0016X\u0097\u0005¢\u0006\u0006\u001a\u0004\bA\u0010?R\u0014\u0010B\u001a\u00020C8VX\u0096\u0005¢\u0006\u0006\u001a\u0004\bB\u0010DR\u0012\u0010E\u001a\u00020FX\u0096\u0005¢\u0006\u0006\u001a\u0004\bG\u0010H¨\u0006I"}, d2 = {"Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState$ApproachMeasureScopeImpl;", "Landroidx/compose/ui/layout/SubcomposeMeasureScope;", "Landroidx/compose/ui/layout/MeasureScope;", SdkConstants.CONSTRUCTOR_NAME, "(Landroidx/compose/ui/layout/LayoutNodeSubcompositionsState;)V", "subcompose", "", "Landroidx/compose/ui/layout/Measurable;", "slotId", "", "content", "Lkotlin/Function0;", "", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function2;)Ljava/util/List;", "layout", "Landroidx/compose/ui/layout/MeasureResult;", "width", "", "height", "alignmentLines", "", "Landroidx/compose/ui/layout/AlignmentLine;", "placementBlock", "Lkotlin/Function1;", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "Lkotlin/ExtensionFunctionType;", "rulers", "Landroidx/compose/ui/layout/RulerScope;", "roundToPx", "Landroidx/compose/ui/unit/Dp;", "roundToPx-0680j_4", "(F)I", "Landroidx/compose/ui/unit/TextUnit;", "roundToPx--R2X_6o", "(J)I", "toDp", "toDp-u2uoSUM", "(I)F", "", "(F)F", "toDp-GaN1DYA", "(J)F", "toDpSize", "Landroidx/compose/ui/unit/DpSize;", "Landroidx/compose/ui/geometry/Size;", "toDpSize-k-rfVVM", "(J)J", "toPx", "toPx-0680j_4", "toPx--R2X_6o", "toRect", "Landroidx/compose/ui/geometry/Rect;", "Landroidx/compose/ui/unit/DpRect;", "toSize", "toSize-XkaWNTQ", "toSp", "toSp-kPz2Gy4", "(I)J", "(F)J", "toSp-0xMU5do", "density", "getDensity", "()F", "fontScale", "getFontScale", "isLookingAhead", "", "()Z", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "getLayoutDirection", "()Landroidx/compose/ui/unit/LayoutDirection;", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
    private final class ApproachMeasureScopeImpl implements SubcomposeMeasureScope, MeasureScope {
        private final /* synthetic */ Scope $$delegate_0;

        @Override // androidx.compose.ui.unit.Density
        public float getDensity() {
            return this.$$delegate_0.getDensity();
        }

        @Override // androidx.compose.ui.unit.FontScaling
        public float getFontScale() {
            return this.$$delegate_0.getFontScale();
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public LayoutDirection getLayoutDirection() {
            return this.$$delegate_0.getLayoutDirection();
        }

        @Override // androidx.compose.ui.layout.IntrinsicMeasureScope
        public boolean isLookingAhead() {
            return this.$$delegate_0.isLookingAhead();
        }

        @Override // androidx.compose.ui.layout.MeasureScope
        public MeasureResult layout(int width, int height, Map<AlignmentLine, Integer> alignmentLines, Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
            return this.$$delegate_0.layout(width, height, alignmentLines, placementBlock);
        }

        @Override // androidx.compose.ui.layout.MeasureScope
        public MeasureResult layout(int width, int height, Map<AlignmentLine, Integer> alignmentLines, Function1<? super RulerScope, Unit> rulers, Function1<? super Placeable.PlacementScope, Unit> placementBlock) {
            return this.$$delegate_0.layout(width, height, alignmentLines, rulers, placementBlock);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: roundToPx--R2X_6o */
        public int mo670roundToPxR2X_6o(long j) {
            return this.$$delegate_0.mo670roundToPxR2X_6o(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: roundToPx-0680j_4 */
        public int mo671roundToPx0680j_4(float f) {
            return this.$$delegate_0.mo671roundToPx0680j_4(f);
        }

        @Override // androidx.compose.ui.unit.FontScaling
        /* renamed from: toDp-GaN1DYA */
        public float mo672toDpGaN1DYA(long j) {
            return this.$$delegate_0.mo672toDpGaN1DYA(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public float mo673toDpu2uoSUM(float f) {
            return this.$$delegate_0.mo673toDpu2uoSUM(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDp-u2uoSUM */
        public float mo674toDpu2uoSUM(int i) {
            return this.$$delegate_0.mo674toDpu2uoSUM(i);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toDpSize-k-rfVVM */
        public long mo675toDpSizekrfVVM(long j) {
            return this.$$delegate_0.mo675toDpSizekrfVVM(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toPx--R2X_6o */
        public float mo676toPxR2X_6o(long j) {
            return this.$$delegate_0.mo676toPxR2X_6o(j);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toPx-0680j_4 */
        public float mo677toPx0680j_4(float f) {
            return this.$$delegate_0.mo677toPx0680j_4(f);
        }

        @Override // androidx.compose.ui.unit.Density
        public Rect toRect(DpRect dpRect) {
            return this.$$delegate_0.toRect(dpRect);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSize-XkaWNTQ */
        public long mo678toSizeXkaWNTQ(long j) {
            return this.$$delegate_0.mo678toSizeXkaWNTQ(j);
        }

        @Override // androidx.compose.ui.unit.FontScaling
        /* renamed from: toSp-0xMU5do */
        public long mo679toSp0xMU5do(float f) {
            return this.$$delegate_0.mo679toSp0xMU5do(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSp-kPz2Gy4 */
        public long mo680toSpkPz2Gy4(float f) {
            return this.$$delegate_0.mo680toSpkPz2Gy4(f);
        }

        @Override // androidx.compose.ui.unit.Density
        /* renamed from: toSp-kPz2Gy4 */
        public long mo681toSpkPz2Gy4(int i) {
            return this.$$delegate_0.mo681toSpkPz2Gy4(i);
        }

        public ApproachMeasureScopeImpl() {
            this.$$delegate_0 = LayoutNodeSubcompositionsState.this.scope;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // androidx.compose.ui.layout.SubcomposeMeasureScope
        public List<Measurable> subcompose(Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
            LayoutNode layoutNode = (LayoutNode) LayoutNodeSubcompositionsState.this.slotIdToNode.get(slotId);
            if (layoutNode == null || LayoutNodeSubcompositionsState.this.root.getFoldedChildren$ui_release().indexOf(layoutNode) >= LayoutNodeSubcompositionsState.this.currentIndex) {
                return LayoutNodeSubcompositionsState.this.approachSubcompose(slotId, content);
            }
            return layoutNode.getChildMeasurables$ui_release();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Measurable> approachSubcompose(Object slotId, Function2<? super Composer, ? super Integer, Unit> content) {
        if (!(this.approachComposedSlotIds.getSize() >= this.currentApproachIndex)) {
            InlineClassHelperKt.throwIllegalArgumentException("Error: currentApproachIndex cannot be greater than the size of theapproachComposedSlotIds list.");
        }
        int size = this.approachComposedSlotIds.getSize();
        int i = this.currentApproachIndex;
        if (size == i) {
            this.approachComposedSlotIds.add(slotId);
        } else {
            this.approachComposedSlotIds.set(i, slotId);
        }
        this.currentApproachIndex++;
        if (!this.precomposeMap.contains(slotId)) {
            this.approachPrecomposeSlotHandleMap.set(slotId, precompose(slotId, content));
            if (this.root.getLayoutState$ui_release() == LayoutNode.LayoutState.LayingOut) {
                this.root.requestLookaheadRelayout$ui_release(true);
            } else {
                LayoutNode.requestLookaheadRemeasure$ui_release$default(this.root, true, false, false, 6, null);
            }
        } else {
            LayoutNode layoutNode = this.precomposeMap.get(slotId);
            NodeState nodeState = layoutNode != null ? this.nodeToNodeState.get(layoutNode) : null;
            if (nodeState != null && nodeState.getForceRecompose()) {
                subcompose(layoutNode, slotId, false, content);
            }
        }
        LayoutNode layoutNode2 = this.precomposeMap.get(slotId);
        if (layoutNode2 != null) {
            List<MeasurePassDelegate> childDelegates$ui_release = layoutNode2.getMeasurePassDelegate$ui_release().getChildDelegates$ui_release();
            int size2 = childDelegates$ui_release.size();
            for (int i2 = 0; i2 < size2; i2++) {
                childDelegates$ui_release.get(i2).markDetachedFromParentLookaheadPass$ui_release();
            }
            if (childDelegates$ui_release != null) {
                return childDelegates$ui_release;
            }
        }
        return CollectionsKt.emptyList();
    }

    private final void move(int from, int to, int count) {
        LayoutNode layoutNode = this.root;
        layoutNode.ignoreRemeasureRequests = true;
        this.root.move$ui_release(from, to, count);
        Unit unit = Unit.INSTANCE;
        layoutNode.ignoreRemeasureRequests = false;
    }
}
