package androidx.compose.ui.layout;

import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.node.NodeCoordinator;
import kotlin.Metadata;

/* compiled from: LayoutCoordinates.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\u000f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0003\u001a\u000f\u0010\u0004\u001a\u00020\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0003\u001a\u000f\u0010\u0005\u001a\u00020\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0003\u001a\n\u0010\u0006\u001a\u00020\u0007*\u00020\u0002\u001a\n\u0010\b\u001a\u00020\u0007*\u00020\u0002\u001a\u000f\u0010\t\u001a\u00020\u0001*\u00020\u0002¢\u0006\u0002\u0010\u0003\u001a\n\u0010\n\u001a\u00020\u0007*\u00020\u0002\u001a\n\u0010\u000b\u001a\u00020\u0002*\u00020\u0002¨\u0006\f"}, d2 = {"positionInRoot", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/layout/LayoutCoordinates;", "(Landroidx/compose/ui/layout/LayoutCoordinates;)J", "positionInWindow", "positionOnScreen", "boundsInRoot", "Landroidx/compose/ui/geometry/Rect;", "boundsInWindow", "positionInParent", "boundsInParent", "findRootCoordinates", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class LayoutCoordinatesKt {
    public static final long positionInRoot(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.mo5968localToRootMKHz9U(Offset.INSTANCE.m4310getZeroF1C5BW0());
    }

    public static final long positionInWindow(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.mo5970localToWindowMKHz9U(Offset.INSTANCE.m4310getZeroF1C5BW0());
    }

    public static final long positionOnScreen(LayoutCoordinates layoutCoordinates) {
        return layoutCoordinates.mo5969localToScreenMKHz9U(Offset.INSTANCE.m4310getZeroF1C5BW0());
    }

    public static final Rect boundsInRoot(LayoutCoordinates layoutCoordinates) {
        return LayoutCoordinates.localBoundingBoxOf$default(findRootCoordinates(layoutCoordinates), layoutCoordinates, false, 2, null);
    }

    public static final Rect boundsInWindow(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinatesFindRootCoordinates = findRootCoordinates(layoutCoordinates);
        float fMo5965getSizeYbymL2g = (int) (layoutCoordinatesFindRootCoordinates.mo5965getSizeYbymL2g() >> 32);
        float fMo5965getSizeYbymL2g2 = (int) (layoutCoordinatesFindRootCoordinates.mo5965getSizeYbymL2g() & 4294967295L);
        Rect rectLocalBoundingBoxOf$default = LayoutCoordinates.localBoundingBoxOf$default(layoutCoordinatesFindRootCoordinates, layoutCoordinates, false, 2, null);
        float left = rectLocalBoundingBoxOf$default.getLeft();
        if (left < 0.0f) {
            left = 0.0f;
        }
        if (left > fMo5965getSizeYbymL2g) {
            left = fMo5965getSizeYbymL2g;
        }
        float top = rectLocalBoundingBoxOf$default.getTop();
        if (top < 0.0f) {
            top = 0.0f;
        }
        if (top > fMo5965getSizeYbymL2g2) {
            top = fMo5965getSizeYbymL2g2;
        }
        float right = rectLocalBoundingBoxOf$default.getRight();
        if (right < 0.0f) {
            right = 0.0f;
        }
        if (right <= fMo5965getSizeYbymL2g) {
            fMo5965getSizeYbymL2g = right;
        }
        float bottom = rectLocalBoundingBoxOf$default.getBottom();
        float f = bottom >= 0.0f ? bottom : 0.0f;
        if (f <= fMo5965getSizeYbymL2g2) {
            fMo5965getSizeYbymL2g2 = f;
        }
        if (left == fMo5965getSizeYbymL2g || top == fMo5965getSizeYbymL2g2) {
            return Rect.INSTANCE.getZero();
        }
        long jMo5970localToWindowMKHz9U = layoutCoordinatesFindRootCoordinates.mo5970localToWindowMKHz9U(Offset.m4286constructorimpl((Float.floatToRawIntBits(left) << 32) | (Float.floatToRawIntBits(top) & 4294967295L)));
        long jMo5970localToWindowMKHz9U2 = layoutCoordinatesFindRootCoordinates.mo5970localToWindowMKHz9U(Offset.m4286constructorimpl((Float.floatToRawIntBits(top) & 4294967295L) | (Float.floatToRawIntBits(fMo5965getSizeYbymL2g) << 32)));
        long jMo5970localToWindowMKHz9U3 = layoutCoordinatesFindRootCoordinates.mo5970localToWindowMKHz9U(Offset.m4286constructorimpl((Float.floatToRawIntBits(fMo5965getSizeYbymL2g) << 32) | (Float.floatToRawIntBits(fMo5965getSizeYbymL2g2) & 4294967295L)));
        long jMo5970localToWindowMKHz9U4 = layoutCoordinatesFindRootCoordinates.mo5970localToWindowMKHz9U(Offset.m4286constructorimpl((Float.floatToRawIntBits(fMo5965getSizeYbymL2g2) & 4294967295L) | (Float.floatToRawIntBits(left) << 32)));
        float fIntBitsToFloat = Float.intBitsToFloat((int) (jMo5970localToWindowMKHz9U >> 32));
        float fIntBitsToFloat2 = Float.intBitsToFloat((int) (jMo5970localToWindowMKHz9U2 >> 32));
        float fIntBitsToFloat3 = Float.intBitsToFloat((int) (jMo5970localToWindowMKHz9U4 >> 32));
        float fIntBitsToFloat4 = Float.intBitsToFloat((int) (jMo5970localToWindowMKHz9U3 >> 32));
        float fMin = Math.min(fIntBitsToFloat, Math.min(fIntBitsToFloat2, Math.min(fIntBitsToFloat3, fIntBitsToFloat4)));
        float fMax = Math.max(fIntBitsToFloat, Math.max(fIntBitsToFloat2, Math.max(fIntBitsToFloat3, fIntBitsToFloat4)));
        float fIntBitsToFloat5 = Float.intBitsToFloat((int) (jMo5970localToWindowMKHz9U & 4294967295L));
        float fIntBitsToFloat6 = Float.intBitsToFloat((int) (jMo5970localToWindowMKHz9U2 & 4294967295L));
        float fIntBitsToFloat7 = Float.intBitsToFloat((int) (jMo5970localToWindowMKHz9U4 & 4294967295L));
        float fIntBitsToFloat8 = Float.intBitsToFloat((int) (jMo5970localToWindowMKHz9U3 & 4294967295L));
        return new Rect(fMin, Math.min(fIntBitsToFloat5, Math.min(fIntBitsToFloat6, Math.min(fIntBitsToFloat7, fIntBitsToFloat8))), fMax, Math.max(fIntBitsToFloat5, Math.max(fIntBitsToFloat6, Math.max(fIntBitsToFloat7, fIntBitsToFloat8))));
    }

    public static final long positionInParent(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return parentLayoutCoordinates != null ? parentLayoutCoordinates.mo5966localPositionOfR5De75A(layoutCoordinates, Offset.INSTANCE.m4310getZeroF1C5BW0()) : Offset.INSTANCE.m4310getZeroF1C5BW0();
    }

    public static final Rect boundsInParent(LayoutCoordinates layoutCoordinates) {
        Rect rectLocalBoundingBoxOf$default;
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        return (parentLayoutCoordinates == null || (rectLocalBoundingBoxOf$default = LayoutCoordinates.localBoundingBoxOf$default(parentLayoutCoordinates, layoutCoordinates, false, 2, null)) == null) ? new Rect(0.0f, 0.0f, (int) (layoutCoordinates.mo5965getSizeYbymL2g() >> 32), (int) (layoutCoordinates.mo5965getSizeYbymL2g() & 4294967295L)) : rectLocalBoundingBoxOf$default;
    }

    public static final LayoutCoordinates findRootCoordinates(LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates layoutCoordinates2;
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        while (true) {
            LayoutCoordinates layoutCoordinates3 = parentLayoutCoordinates;
            layoutCoordinates2 = layoutCoordinates;
            layoutCoordinates = layoutCoordinates3;
            if (layoutCoordinates == null) {
                break;
            }
            parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        }
        NodeCoordinator nodeCoordinator = layoutCoordinates2 instanceof NodeCoordinator ? (NodeCoordinator) layoutCoordinates2 : null;
        if (nodeCoordinator == null) {
            return layoutCoordinates2;
        }
        NodeCoordinator wrappedBy = nodeCoordinator.getWrappedBy();
        while (true) {
            NodeCoordinator nodeCoordinator2 = wrappedBy;
            NodeCoordinator nodeCoordinator3 = nodeCoordinator;
            nodeCoordinator = nodeCoordinator2;
            if (nodeCoordinator != null) {
                wrappedBy = nodeCoordinator.getWrappedBy();
            } else {
                return nodeCoordinator3;
            }
        }
    }
}
