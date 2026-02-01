package androidx.compose.ui.spatial;

import android.os.Trace;
import androidx.collection.IntObjectMap;
import androidx.collection.IntObjectMapKt;
import androidx.collection.MutableObjectList;
import androidx.compose.runtime.collection.MutableVector;
import androidx.compose.ui.Actual_androidKt;
import androidx.compose.ui.ComposeUiFlags;
import androidx.compose.ui.geometry.MutableRect;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.graphics.MatrixKt;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.MeasurePassDelegate;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.node.OwnedLayer;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import androidx.compose.ui.unit.IntSize;
import com.android.SdkConstants;
import com.sun.jna.Callback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.TypeIntrinsics;

/* compiled from: RectManager.kt */
@Metadata(d1 = {"\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000e\b\u0001\u0018\u00002\u00020\u0001B\u0017\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u0006\u0010\u0019\u001a\u00020\u0010J5\u0010\u001a\u001a\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!¢\u0006\u0004\b#\u0010$J\u0006\u0010%\u001a\u00020\u0010J\u000e\u0010&\u001a\u00020\u00102\u0006\u0010'\u001a\u00020\u0012J\u0016\u0010(\u001a\u0004\u0018\u00010\u00012\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fJ:\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u0002002\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u001001J:\u00103\u001a\u00020+2\u0006\u0010,\u001a\u00020!2\u0006\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020\u00172\u0006\u0010/\u001a\u0002002\u0012\u0010)\u001a\u000e\u0012\u0004\u0012\u000202\u0012\u0004\u0012\u00020\u001001J\u0010\u00104\u001a\u00020\u00102\b\u00105\u001a\u0004\u0018\u00010\u0001J\u000e\u00106\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0004J\u001e\u00108\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u00122\u0006\u0010:\u001a\u00020\u0012J\u000e\u0010;\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0004J\u0016\u0010<\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0012J\u0010\u0010>\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0004H\u0002J\u0010\u0010?\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0004H\u0002J\u0018\u0010B\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u0012H\u0002J8\u0010C\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u00042\u0006\u0010=\u001a\u00020\u00122\u0006\u0010D\u001a\u00020!2\u0006\u0010E\u001a\u00020!2\u0006\u0010F\u001a\u00020!2\u0006\u0010G\u001a\u00020!H\u0002J\u0014\u0010H\u001a\u00020\u0010*\u00020I2\u0006\u0010J\u001a\u00020AH\u0002J\u001b\u0010K\u001a\u00020\u001c*\u00020I2\u0006\u0010L\u001a\u00020\u001cH\u0002¢\u0006\u0004\bM\u0010NJ\u0013\u0010O\u001a\u00020\u001c*\u00020\u0004H\u0002¢\u0006\u0004\bP\u0010QJ\u000e\u0010R\u001a\u00020\u00102\u0006\u00107\u001a\u00020\u0004J\u001d\u0010S\u001a\u00020\u00122\u0006\u0010T\u001a\u00020!2\u0006\u0010U\u001a\u00020!H\u0000¢\u0006\u0002\bVR\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00100\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010@\u001a\u00020AX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006W"}, d2 = {"Landroidx/compose/ui/spatial/RectManager;", "", "layoutNodes", "Landroidx/collection/IntObjectMap;", "Landroidx/compose/ui/node/LayoutNode;", SdkConstants.CONSTRUCTOR_NAME, "(Landroidx/collection/IntObjectMap;)V", "rects", "Landroidx/compose/ui/spatial/RectList;", "getRects", "()Landroidx/compose/ui/spatial/RectList;", "throttledCallbacks", "Landroidx/compose/ui/spatial/ThrottledCallbacks;", "callbacks", "Landroidx/collection/MutableObjectList;", "Lkotlin/Function0;", "", "isDirty", "", "isScreenOrWindowDirty", "isFragmented", "dispatchToken", "scheduledDispatchDeadline", "", "dispatchLambda", "invalidate", "updateOffsets", "screenOffset", "Landroidx/compose/ui/unit/IntOffset;", "windowOffset", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "windowWidth", "", "windowHeight", "updateOffsets-gTq6Wqs", "(JJ[FII)V", "dispatchCallbacks", "scheduleDebounceCallback", "ensureSomethingScheduled", "registerOnChangedCallback", Callback.METHOD_NAME, "registerOnRectChangedCallback", "Landroidx/compose/ui/node/DelegatableNode$RegistrationHandle;", "id", "throttleMillis", "debounceMillis", "node", "Landroidx/compose/ui/node/DelegatableNode;", "Lkotlin/Function1;", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "registerOnGlobalLayoutCallback", "unregisterOnChangedCallback", "token", "invalidateCallbacksFor", "layoutNode", "updateFlagsFor", SdkConstants.ATTR_FOCUSABLE, "gesturable", "onLayoutLayerPositionalPropertiesChanged", "onLayoutPositionChanged", "firstPlacement", "recalculateOffsetFromRoot", "insertOrUpdateTransformedNodeSubhierarchy", "cachedRect", "Landroidx/compose/ui/geometry/MutableRect;", "insertOrUpdateTransformedNode", "insertOrUpdate", "l", "t", SdkConstants.FD_RES_CLASS, "b", "boundingRectInRoot", "Landroidx/compose/ui/node/NodeCoordinator;", "rect", "applyLayerTransformation", "position", "applyLayerTransformation-2IdBmHc", "(Landroidx/compose/ui/node/NodeCoordinator;J)J", "outerToInnerOffset", "outerToInnerOffset-Bjo55l4", "(Landroidx/compose/ui/node/LayoutNode;)J", "remove", "isTargetDrawnFirst", SdkConstants.ATTR_MOTION_TARGET_ID, "otherId", "isTargetDrawnFirst$ui_release", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RectManager {
    public static final int $stable = 8;
    private final MutableRect cachedRect;
    private final MutableObjectList<Function0<Unit>> callbacks;
    private final Function0<Unit> dispatchLambda;
    private Object dispatchToken;
    private boolean isDirty;
    private boolean isFragmented;
    private boolean isScreenOrWindowDirty;
    private final IntObjectMap<LayoutNode> layoutNodes;
    private final RectList rects;
    private long scheduledDispatchDeadline;
    private final ThrottledCallbacks throttledCallbacks;

    /* JADX WARN: Multi-variable type inference failed */
    public RectManager() {
        this(null, 1, 0 == true ? 1 : 0);
    }

    public RectManager(IntObjectMap<LayoutNode> intObjectMap) {
        this.layoutNodes = intObjectMap;
        this.rects = new RectList();
        this.throttledCallbacks = new ThrottledCallbacks();
        this.callbacks = new MutableObjectList<>(0, 1, null);
        this.scheduledDispatchDeadline = -1L;
        this.dispatchLambda = new Function0<Unit>() { // from class: androidx.compose.ui.spatial.RectManager$dispatchLambda$1
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
                this.this$0.dispatchToken = null;
                RectManager rectManager = this.this$0;
                Trace.beginSection("OnPositionedDispatch");
                try {
                    rectManager.dispatchCallbacks();
                    Unit unit = Unit.INSTANCE;
                } finally {
                    Trace.endSection();
                }
            }
        };
        this.cachedRect = new MutableRect(0.0f, 0.0f, 0.0f, 0.0f);
    }

    public /* synthetic */ RectManager(IntObjectMap intObjectMap, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? IntObjectMapKt.intObjectMapOf() : intObjectMap);
    }

    public final RectList getRects() {
        return this.rects;
    }

    public final void invalidate() {
        this.isDirty = true;
    }

    /* renamed from: updateOffsets-gTq6Wqs, reason: not valid java name */
    public final void m6487updateOffsetsgTq6Wqs(long screenOffset, long windowOffset, float[] viewToWindowMatrix, int windowWidth, int windowHeight) {
        this.isScreenOrWindowDirty = this.throttledCallbacks.m6504updateOffsetsLDcG7Xg(screenOffset, windowOffset, (RectManagerKt.m6490analyzeComponents58bKbWc(viewToWindowMatrix) & 2) == 0 ? viewToWindowMatrix : null, windowWidth, windowHeight) || this.isScreenOrWindowDirty;
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00cd  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void dispatchCallbacks() {
        /*
            Method dump skipped, instructions count: 270
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.spatial.RectManager.dispatchCallbacks():void");
    }

    public final void scheduleDebounceCallback(boolean ensureSomethingScheduled) {
        boolean z = (ensureSomethingScheduled && this.dispatchToken == null) ? false : true;
        long minDebounceDeadline = this.throttledCallbacks.getMinDebounceDeadline();
        if (minDebounceDeadline >= 0 || !z) {
            if (this.scheduledDispatchDeadline == minDebounceDeadline && z) {
                return;
            }
            Object obj = this.dispatchToken;
            if (obj != null) {
                Actual_androidKt.removePost(obj);
            }
            long jCurrentTimeMillis = Actual_androidKt.currentTimeMillis();
            long jMax = Math.max(minDebounceDeadline, 16 + jCurrentTimeMillis);
            this.scheduledDispatchDeadline = jMax;
            this.dispatchToken = Actual_androidKt.postDelayed(jMax - jCurrentTimeMillis, this.dispatchLambda);
        }
    }

    public final Object registerOnChangedCallback(Function0<Unit> callback) {
        this.callbacks.add(callback);
        return callback;
    }

    public final DelegatableNode.RegistrationHandle registerOnRectChangedCallback(int id2, long throttleMillis, long debounceMillis, DelegatableNode node, Function1<? super RelativeLayoutBounds, Unit> callback) {
        DelegatableNode.RegistrationHandle registrationHandleRegisterOnRectChanged = this.throttledCallbacks.registerOnRectChanged(id2, throttleMillis, debounceMillis, node, callback);
        invalidate();
        scheduleDebounceCallback(true);
        return registrationHandleRegisterOnRectChanged;
    }

    public final DelegatableNode.RegistrationHandle registerOnGlobalLayoutCallback(int id2, long throttleMillis, long debounceMillis, DelegatableNode node, Function1<? super RelativeLayoutBounds, Unit> callback) {
        return this.throttledCallbacks.registerOnGlobalChange(id2, throttleMillis, debounceMillis, node, callback);
    }

    public final void unregisterOnChangedCallback(Object token) {
        if ((TypeIntrinsics.isFunctionOfArity(token, 0) ? (Function0) token : null) == null) {
            return;
        }
        this.callbacks.remove(token);
    }

    public final void invalidateCallbacksFor(LayoutNode layoutNode) {
        this.isDirty = true;
        this.rects.markUpdated(layoutNode.getSemanticsId());
        scheduleDebounceCallback(true);
    }

    public final void updateFlagsFor(LayoutNode layoutNode, boolean focusable, boolean gesturable) {
        if (layoutNode.isAttached()) {
            this.rects.updateFlagsFor(layoutNode.getSemanticsId(), focusable, gesturable);
        }
    }

    public final void onLayoutLayerPositionalPropertiesChanged(LayoutNode layoutNode) {
        if (ComposeUiFlags.isRectTrackingEnabled) {
            long jM6486outerToInnerOffsetBjo55l4 = m6486outerToInnerOffsetBjo55l4(layoutNode);
            if (RectManagerKt.m6491isSetgyyYBs(jM6486outerToInnerOffsetBjo55l4)) {
                layoutNode.m6163setOuterToInnerOffsetgyyYBs$ui_release(jM6486outerToInnerOffsetBjo55l4);
                layoutNode.setOuterToInnerOffsetDirty$ui_release(false);
                MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
                LayoutNode[] layoutNodeArr = mutableVector.content;
                int size = mutableVector.getSize();
                for (int i = 0; i < size; i++) {
                    onLayoutPositionChanged(layoutNodeArr[i], false);
                }
                invalidateCallbacksFor(layoutNode);
                return;
            }
            insertOrUpdateTransformedNodeSubhierarchy(layoutNode);
        }
    }

    public final void onLayoutPositionChanged(LayoutNode layoutNode, boolean firstPlacement) {
        if (ComposeUiFlags.isRectTrackingEnabled) {
            MeasurePassDelegate measurePassDelegate$ui_release = layoutNode.getMeasurePassDelegate$ui_release();
            int measuredWidth = measurePassDelegate$ui_release.getMeasuredWidth();
            int measuredHeight = measurePassDelegate$ui_release.getMeasuredHeight();
            long offsetFromRoot = layoutNode.getOffsetFromRoot();
            long lastSize = layoutNode.getLastSize();
            int i = (int) (lastSize >> 32);
            int i2 = (int) (lastSize & 4294967295L);
            recalculateOffsetFromRoot(layoutNode);
            long offsetFromRoot2 = layoutNode.getOffsetFromRoot();
            if (!RectManagerKt.m6491isSetgyyYBs(offsetFromRoot2)) {
                insertOrUpdateTransformedNode(layoutNode, firstPlacement);
                return;
            }
            layoutNode.m6161setLastSizeozmzZPI$ui_release(IntSize.m7421constructorimpl((measuredWidth << 32) | (4294967295L & measuredHeight)));
            int iM7383getXimpl = IntOffset.m7383getXimpl(offsetFromRoot2);
            int iM7384getYimpl = IntOffset.m7384getYimpl(offsetFromRoot2);
            int i3 = iM7383getXimpl + measuredWidth;
            int i4 = iM7384getYimpl + measuredHeight;
            if (!firstPlacement && IntOffset.m7382equalsimpl0(offsetFromRoot2, offsetFromRoot) && i == measuredWidth && i2 == measuredHeight) {
                return;
            }
            insertOrUpdate(layoutNode, firstPlacement, iM7383getXimpl, iM7384getYimpl, i3, i4);
        }
    }

    private final void recalculateOffsetFromRoot(LayoutNode layoutNode) {
        long outerToInnerOffset;
        NodeCoordinator outerCoordinator$ui_release = layoutNode.getOuterCoordinator$ui_release();
        long jM6485applyLayerTransformation2IdBmHc = m6485applyLayerTransformation2IdBmHc(outerCoordinator$ui_release, IntOffset.INSTANCE.m7394getZeronOccac());
        if (!RectManagerKt.m6491isSetgyyYBs(jM6485applyLayerTransformation2IdBmHc)) {
            layoutNode.m6162setOffsetFromRootgyyYBs$ui_release(IntOffset.INSTANCE.m7393getMaxnOccac());
            return;
        }
        long jM7387plusqkQi6aY = IntOffset.m7387plusqkQi6aY(jM6485applyLayerTransformation2IdBmHc, outerCoordinator$ui_release.getPosition());
        LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
        if (parent$ui_release != null) {
            if (!RectManagerKt.m6491isSetgyyYBs(parent$ui_release.getOffsetFromRoot())) {
                recalculateOffsetFromRoot(parent$ui_release);
            }
            long offsetFromRoot = parent$ui_release.getOffsetFromRoot();
            if (!RectManagerKt.m6491isSetgyyYBs(offsetFromRoot)) {
                jM7387plusqkQi6aY = IntOffset.INSTANCE.m7393getMaxnOccac();
            } else {
                if (parent$ui_release.getOuterToInnerOffsetDirty()) {
                    outerToInnerOffset = m6486outerToInnerOffsetBjo55l4(parent$ui_release);
                    parent$ui_release.m6163setOuterToInnerOffsetgyyYBs$ui_release(outerToInnerOffset);
                    parent$ui_release.setOuterToInnerOffsetDirty$ui_release(false);
                } else {
                    outerToInnerOffset = parent$ui_release.getOuterToInnerOffset();
                }
                if (!RectManagerKt.m6491isSetgyyYBs(outerToInnerOffset)) {
                    jM7387plusqkQi6aY = IntOffset.INSTANCE.m7393getMaxnOccac();
                } else {
                    jM7387plusqkQi6aY = IntOffset.m7387plusqkQi6aY(IntOffset.m7387plusqkQi6aY(offsetFromRoot, outerToInnerOffset), jM7387plusqkQi6aY);
                }
            }
        }
        layoutNode.m6162setOffsetFromRootgyyYBs$ui_release(jM7387plusqkQi6aY);
    }

    private final void insertOrUpdateTransformedNode(LayoutNode layoutNode, boolean firstPlacement) {
        NodeCoordinator outerCoordinator$ui_release = layoutNode.getOuterCoordinator$ui_release();
        MeasurePassDelegate measurePassDelegate$ui_release = layoutNode.getMeasurePassDelegate$ui_release();
        int measuredWidth = measurePassDelegate$ui_release.getMeasuredWidth();
        int measuredHeight = measurePassDelegate$ui_release.getMeasuredHeight();
        MutableRect mutableRect = this.cachedRect;
        mutableRect.set(0.0f, 0.0f, measuredWidth, measuredHeight);
        boundingRectInRoot(outerCoordinator$ui_release, mutableRect);
        int left = (int) mutableRect.getLeft();
        int top = (int) mutableRect.getTop();
        int right = (int) mutableRect.getRight();
        int bottom = (int) mutableRect.getBottom();
        int semanticsId = layoutNode.getSemanticsId();
        if (firstPlacement || !this.rects.update(semanticsId, left, top, right, bottom)) {
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            this.rects.insert(semanticsId, left, top, right, bottom, parent$ui_release != null ? parent$ui_release.getSemanticsId() : -1, layoutNode.getNodes().m6209hasH91voCI$ui_release(NodeKind.m6248constructorimpl(1024)), layoutNode.getNodes().m6209hasH91voCI$ui_release(NodeKind.m6248constructorimpl(16)));
        }
        invalidate();
    }

    private final void insertOrUpdate(LayoutNode layoutNode, boolean firstPlacement, int l, int t, int r, int b) {
        int semanticsId = layoutNode.getSemanticsId();
        if (firstPlacement || !this.rects.move(semanticsId, l, t, r, b)) {
            LayoutNode parent$ui_release = layoutNode.getParent$ui_release();
            this.rects.insert(semanticsId, l, t, r, b, parent$ui_release != null ? parent$ui_release.getSemanticsId() : -1, layoutNode.getNodes().m6209hasH91voCI$ui_release(NodeKind.m6248constructorimpl(1024)), layoutNode.getNodes().m6209hasH91voCI$ui_release(NodeKind.m6248constructorimpl(16)));
        }
        invalidate();
    }

    private final void boundingRectInRoot(NodeCoordinator nodeCoordinator, MutableRect mutableRect) {
        while (nodeCoordinator != null) {
            OwnedLayer layer = nodeCoordinator.getLayer();
            if (layer != null) {
                float[] fArrMo6301getUnderlyingMatrixsQKQjiQ = layer.mo6301getUnderlyingMatrixsQKQjiQ();
                if (!MatrixKt.m4805isIdentity58bKbWc(fArrMo6301getUnderlyingMatrixsQKQjiQ)) {
                    Matrix.m4788mapimpl(fArrMo6301getUnderlyingMatrixsQKQjiQ, mutableRect);
                }
            }
            long position = nodeCoordinator.getPosition();
            float fM7383getXimpl = IntOffset.m7383getXimpl(position);
            float fM7384getYimpl = IntOffset.m7384getYimpl(position);
            mutableRect.m4279translatek4lQ0M(Offset.m4286constructorimpl((Float.floatToRawIntBits(fM7383getXimpl) << 32) | (Float.floatToRawIntBits(fM7384getYimpl) & 4294967295L)));
            nodeCoordinator = nodeCoordinator.getWrappedBy();
        }
    }

    /* renamed from: applyLayerTransformation-2IdBmHc, reason: not valid java name */
    private final long m6485applyLayerTransformation2IdBmHc(NodeCoordinator nodeCoordinator, long j) {
        OwnedLayer layer = nodeCoordinator.getLayer();
        if (layer != null) {
            float[] fArrMo6301getUnderlyingMatrixsQKQjiQ = layer.mo6301getUnderlyingMatrixsQKQjiQ();
            int iM6490analyzeComponents58bKbWc = RectManagerKt.m6490analyzeComponents58bKbWc(fArrMo6301getUnderlyingMatrixsQKQjiQ);
            if (iM6490analyzeComponents58bKbWc != 3) {
                if ((iM6490analyzeComponents58bKbWc & 2) == 0) {
                    return IntOffset.INSTANCE.m7393getMaxnOccac();
                }
                float fM7383getXimpl = IntOffset.m7383getXimpl(j);
                float fM7384getYimpl = IntOffset.m7384getYimpl(j);
                return IntOffsetKt.m7400roundk4lQ0M(Matrix.m4786mapMKHz9U(fArrMo6301getUnderlyingMatrixsQKQjiQ, Offset.m4286constructorimpl((Float.floatToRawIntBits(fM7384getYimpl) & 4294967295L) | (Float.floatToRawIntBits(fM7383getXimpl) << 32))));
            }
        }
        return j;
    }

    /* renamed from: outerToInnerOffset-Bjo55l4, reason: not valid java name */
    private final long m6486outerToInnerOffsetBjo55l4(LayoutNode layoutNode) {
        NodeCoordinator outerCoordinator$ui_release = layoutNode.getOuterCoordinator$ui_release();
        long jM7394getZeronOccac = IntOffset.INSTANCE.m7394getZeronOccac();
        for (NodeCoordinator innerCoordinator$ui_release = layoutNode.getInnerCoordinator$ui_release(); innerCoordinator$ui_release != null && innerCoordinator$ui_release != outerCoordinator$ui_release; innerCoordinator$ui_release = innerCoordinator$ui_release.getWrappedBy()) {
            long jM6485applyLayerTransformation2IdBmHc = m6485applyLayerTransformation2IdBmHc(innerCoordinator$ui_release, jM7394getZeronOccac);
            if (IntOffset.m7382equalsimpl0(jM6485applyLayerTransformation2IdBmHc, IntOffset.INSTANCE.m7393getMaxnOccac())) {
                return IntOffset.INSTANCE.m7393getMaxnOccac();
            }
            jM7394getZeronOccac = IntOffset.m7387plusqkQi6aY(jM6485applyLayerTransformation2IdBmHc, innerCoordinator$ui_release.getPosition());
        }
        return jM7394getZeronOccac;
    }

    public final void remove(LayoutNode layoutNode) {
        this.rects.remove(layoutNode.getSemanticsId());
        invalidate();
        this.isFragmented = true;
    }

    public final boolean isTargetDrawnFirst$ui_release(int targetId, int otherId) {
        LayoutNode parent$ui_release;
        LayoutNode parent$ui_release2;
        LayoutNode parent$ui_release3 = this.layoutNodes.get(targetId);
        if (parent$ui_release3 == null || (parent$ui_release = this.layoutNodes.get(otherId)) == null || parent$ui_release3.getDepth() == 0 || parent$ui_release.getDepth() == 0) {
            return false;
        }
        while (parent$ui_release3.getDepth() > parent$ui_release.getDepth()) {
            parent$ui_release3 = parent$ui_release3.getParent$ui_release();
            if (parent$ui_release3 == null) {
                return false;
            }
        }
        if (parent$ui_release3 == parent$ui_release) {
            return false;
        }
        while (parent$ui_release.getDepth() > parent$ui_release3.getDepth()) {
            parent$ui_release = parent$ui_release.getParent$ui_release();
            if (parent$ui_release == null) {
                return false;
            }
        }
        if (parent$ui_release3 == parent$ui_release) {
            return false;
        }
        LayoutNode layoutNode = parent$ui_release;
        LayoutNode layoutNode2 = layoutNode;
        LayoutNode layoutNode3 = parent$ui_release3;
        while (parent$ui_release3 != layoutNode) {
            LayoutNode parent$ui_release4 = parent$ui_release3.getParent$ui_release();
            if (parent$ui_release4 == null || (parent$ui_release2 = layoutNode.getParent$ui_release()) == null) {
                return false;
            }
            layoutNode3 = parent$ui_release3;
            parent$ui_release3 = parent$ui_release4;
            layoutNode2 = layoutNode;
            layoutNode = parent$ui_release2;
        }
        return layoutNode3.getMeasurePassDelegate$ui_release().getZIndex() == layoutNode2.getMeasurePassDelegate$ui_release().getZIndex() ? layoutNode3.getPlaceOrder$ui_release() < layoutNode2.getPlaceOrder$ui_release() : layoutNode3.getMeasurePassDelegate$ui_release().getZIndex() < layoutNode2.getMeasurePassDelegate$ui_release().getZIndex();
    }

    private final void insertOrUpdateTransformedNodeSubhierarchy(LayoutNode layoutNode) {
        MutableVector<LayoutNode> mutableVector = layoutNode.get_children$ui_release();
        LayoutNode[] layoutNodeArr = mutableVector.content;
        int size = mutableVector.getSize();
        for (int i = 0; i < size; i++) {
            LayoutNode layoutNode2 = layoutNodeArr[i];
            insertOrUpdateTransformedNode(layoutNode2, false);
            insertOrUpdateTransformedNodeSubhierarchy(layoutNode2);
        }
    }
}
