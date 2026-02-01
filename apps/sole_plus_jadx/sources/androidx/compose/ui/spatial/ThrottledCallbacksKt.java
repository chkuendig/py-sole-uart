package androidx.compose.ui.spatial;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.node.DelegatableNode;
import androidx.compose.ui.node.DelegatableNodeKt;
import androidx.compose.ui.node.LayoutNode;
import androidx.compose.ui.node.NodeCoordinator;
import androidx.compose.ui.node.NodeKind;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import kotlin.Metadata;

/* compiled from: ThrottledCallbacks.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aK\u0010\u0000\u001a\u0004\u0018\u00010\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00052\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0000¢\u0006\u0004\b\r\u0010\u000e¨\u0006\u000f"}, d2 = {"rectInfoFor", "Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "node", "Landroidx/compose/ui/node/DelegatableNode;", "topLeft", "", "bottomRight", "windowOffset", "Landroidx/compose/ui/unit/IntOffset;", "screenOffset", "windowSize", "viewToWindowMatrix", "Landroidx/compose/ui/graphics/Matrix;", "rectInfoFor-Dg36KO4", "(Landroidx/compose/ui/node/DelegatableNode;JJJJJ[F)Landroidx/compose/ui/spatial/RelativeLayoutBounds;", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ThrottledCallbacksKt {
    /* renamed from: rectInfoFor-Dg36KO4, reason: not valid java name */
    public static final RelativeLayoutBounds m6506rectInfoForDg36KO4(DelegatableNode delegatableNode, long j, long j2, long j3, long j4, long j5, float[] fArr) {
        NodeCoordinator nodeCoordinatorM6102requireCoordinator64DMado = DelegatableNodeKt.m6102requireCoordinator64DMado(delegatableNode, NodeKind.m6248constructorimpl(2));
        LayoutNode layoutNodeRequireLayoutNode = DelegatableNodeKt.requireLayoutNode(delegatableNode);
        if (!layoutNodeRequireLayoutNode.isPlaced()) {
            return null;
        }
        if (layoutNodeRequireLayoutNode.getOuterCoordinator$ui_release() != nodeCoordinatorM6102requireCoordinator64DMado) {
            long jM7377constructorimpl = IntOffset.m7377constructorimpl(j);
            float fM7383getXimpl = IntOffset.m7383getXimpl(jM7377constructorimpl);
            float fM7384getYimpl = IntOffset.m7384getYimpl(jM7377constructorimpl);
            long jM4286constructorimpl = Offset.m4286constructorimpl((Float.floatToRawIntBits(fM7383getXimpl) << 32) | (Float.floatToRawIntBits(fM7384getYimpl) & 4294967295L));
            long jMo5965getSizeYbymL2g = nodeCoordinatorM6102requireCoordinator64DMado.getCoordinates().mo5965getSizeYbymL2g();
            return new RelativeLayoutBounds(IntOffsetKt.m7400roundk4lQ0M(layoutNodeRequireLayoutNode.getOuterCoordinator$ui_release().getCoordinates().mo5966localPositionOfR5De75A(nodeCoordinatorM6102requireCoordinator64DMado, jM4286constructorimpl)), IntOffset.m7377constructorimpl(((IntOffset.m7383getXimpl(r3) + ((int) (jMo5965getSizeYbymL2g >> 32))) << 32) | ((IntOffset.m7384getYimpl(r3) + ((int) (jMo5965getSizeYbymL2g & 4294967295L))) & 4294967295L)), j3, j4, j5, fArr, delegatableNode, null);
        }
        return new RelativeLayoutBounds(j, j2, j3, j4, j5, fArr, delegatableNode, null);
    }
}
