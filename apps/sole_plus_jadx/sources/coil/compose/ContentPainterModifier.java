package coil.compose;

import androidx.compose.ui.Alignment;
import androidx.compose.ui.draw.DrawModifier;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.geometry.SizeKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.IntrinsicMeasureScope;
import androidx.compose.ui.layout.LayoutModifier;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.ScaleFactorKt;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.platform.InspectorValueInfo;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.IntOffset;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* compiled from: ContentPainterModifier.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0080\b\u0018\u00002\u00020\u00012\u00020\u00022\u00020\u0003B/\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r¢\u0006\u0002\u0010\u000eJ\u001d\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b\u0012\u0010\u0013J\t\u0010\u0014\u001a\u00020\u0005HÂ\u0003J\t\u0010\u0015\u001a\u00020\u0007HÂ\u0003J\t\u0010\u0016\u001a\u00020\tHÂ\u0003J\t\u0010\u0017\u001a\u00020\u000bHÂ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\rHÂ\u0003J=\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\rHÆ\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dHÖ\u0003J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001J\u001d\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!H\u0002ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b#\u0010\u0013J\t\u0010$\u001a\u00020%HÖ\u0001J\f\u0010&\u001a\u00020'*\u00020(H\u0016J\u001c\u0010)\u001a\u00020\u001f*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001fH\u0016J\u001c\u0010.\u001a\u00020\u001f*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010/\u001a\u00020\u001fH\u0016J)\u00100\u001a\u000201*\u0002022\u0006\u0010+\u001a\u0002032\u0006\u0010\"\u001a\u00020!H\u0016ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\b4\u00105J\u001c\u00106\u001a\u00020\u001f*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u001fH\u0016J\u001c\u00107\u001a\u00020\u001f*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010/\u001a\u00020\u001fH\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u00068"}, d2 = {"Lcoil/compose/ContentPainterModifier;", "Landroidx/compose/ui/layout/LayoutModifier;", "Landroidx/compose/ui/draw/DrawModifier;", "Landroidx/compose/ui/platform/InspectorValueInfo;", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "alignment", "Landroidx/compose/ui/Alignment;", "contentScale", "Landroidx/compose/ui/layout/ContentScale;", "alpha", "", "colorFilter", "Landroidx/compose/ui/graphics/ColorFilter;", "(Landroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/ui/Alignment;Landroidx/compose/ui/layout/ContentScale;FLandroidx/compose/ui/graphics/ColorFilter;)V", "calculateScaledSize", "Landroidx/compose/ui/geometry/Size;", "dstSize", "calculateScaledSize-E7KxVPU", "(J)J", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "", "modifyConstraints", "Landroidx/compose/ui/unit/Constraints;", "constraints", "modifyConstraints-ZezNO4M", "toString", "", "draw", "", "Landroidx/compose/ui/graphics/drawscope/ContentDrawScope;", "maxIntrinsicHeight", "Landroidx/compose/ui/layout/IntrinsicMeasureScope;", "measurable", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "width", "maxIntrinsicWidth", "height", "measure", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "Landroidx/compose/ui/layout/Measurable;", "measure-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Measurable;J)Landroidx/compose/ui/layout/MeasureResult;", "minIntrinsicHeight", "minIntrinsicWidth", "coil-compose-base_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes3.dex */
public final /* data */ class ContentPainterModifier extends InspectorValueInfo implements LayoutModifier, DrawModifier {
    private final Alignment alignment;
    private final float alpha;
    private final ColorFilter colorFilter;
    private final ContentScale contentScale;
    private final Painter painter;

    /* renamed from: component1, reason: from getter */
    private final Painter getPainter() {
        return this.painter;
    }

    /* renamed from: component2, reason: from getter */
    private final Alignment getAlignment() {
        return this.alignment;
    }

    /* renamed from: component3, reason: from getter */
    private final ContentScale getContentScale() {
        return this.contentScale;
    }

    /* renamed from: component4, reason: from getter */
    private final float getAlpha() {
        return this.alpha;
    }

    /* renamed from: component5, reason: from getter */
    private final ColorFilter getColorFilter() {
        return this.colorFilter;
    }

    public static /* synthetic */ ContentPainterModifier copy$default(ContentPainterModifier contentPainterModifier, Painter painter, Alignment alignment, ContentScale contentScale, float f, ColorFilter colorFilter, int i, Object obj) {
        if ((i & 1) != 0) {
            painter = contentPainterModifier.painter;
        }
        if ((i & 2) != 0) {
            alignment = contentPainterModifier.alignment;
        }
        Alignment alignment2 = alignment;
        if ((i & 4) != 0) {
            contentScale = contentPainterModifier.contentScale;
        }
        ContentScale contentScale2 = contentScale;
        if ((i & 8) != 0) {
            f = contentPainterModifier.alpha;
        }
        float f2 = f;
        if ((i & 16) != 0) {
            colorFilter = contentPainterModifier.colorFilter;
        }
        return contentPainterModifier.copy(painter, alignment2, contentScale2, f2, colorFilter);
    }

    public final ContentPainterModifier copy(Painter painter, Alignment alignment, ContentScale contentScale, float alpha, ColorFilter colorFilter) {
        return new ContentPainterModifier(painter, alignment, contentScale, alpha, colorFilter);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ContentPainterModifier)) {
            return false;
        }
        ContentPainterModifier contentPainterModifier = (ContentPainterModifier) other;
        return Intrinsics.areEqual(this.painter, contentPainterModifier.painter) && Intrinsics.areEqual(this.alignment, contentPainterModifier.alignment) && Intrinsics.areEqual(this.contentScale, contentPainterModifier.contentScale) && Float.compare(this.alpha, contentPainterModifier.alpha) == 0 && Intrinsics.areEqual(this.colorFilter, contentPainterModifier.colorFilter);
    }

    public int hashCode() {
        int iHashCode = ((((((this.painter.hashCode() * 31) + this.alignment.hashCode()) * 31) + this.contentScale.hashCode()) * 31) + Float.hashCode(this.alpha)) * 31;
        ColorFilter colorFilter = this.colorFilter;
        return iHashCode + (colorFilter == null ? 0 : colorFilter.hashCode());
    }

    public String toString() {
        return "ContentPainterModifier(painter=" + this.painter + ", alignment=" + this.alignment + ", contentScale=" + this.contentScale + ", alpha=" + this.alpha + ", colorFilter=" + this.colorFilter + ')';
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    /* renamed from: measure-3p2s80s */
    public MeasureResult mo368measure3p2s80s(MeasureScope measureScope, Measurable measurable, long j) {
        final Placeable placeableMo5957measureBRTryo0 = measurable.mo5957measureBRTryo0(m7963modifyConstraintsZezNO4M(j));
        return MeasureScope.layout$default(measureScope, placeableMo5957measureBRTryo0.getWidth(), placeableMo5957measureBRTryo0.getHeight(), null, new Function1<Placeable.PlacementScope, Unit>() { // from class: coil.compose.ContentPainterModifier$measure$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Placeable.PlacementScope placementScope) {
                invoke2(placementScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Placeable.PlacementScope placementScope) {
                Placeable.PlacementScope.placeRelative$default(placementScope, placeableMo5957measureBRTryo0, 0, 0, 0.0f, 4, null);
            }
        }, 4, null);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.getIntrinsicSize() != Size.INSTANCE.m4371getUnspecifiedNHjbRc()) {
            int iMinIntrinsicWidth = intrinsicMeasurable.minIntrinsicWidth(Constraints.m7207getMaxHeightimpl(m7963modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null))));
            return Math.max(MathKt.roundToInt(Size.m4363getWidthimpl(m7962calculateScaledSizeE7KxVPU(SizeKt.Size(iMinIntrinsicWidth, i)))), iMinIntrinsicWidth);
        }
        return intrinsicMeasurable.minIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicWidth(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.getIntrinsicSize() != Size.INSTANCE.m4371getUnspecifiedNHjbRc()) {
            int iMaxIntrinsicWidth = intrinsicMeasurable.maxIntrinsicWidth(Constraints.m7207getMaxHeightimpl(m7963modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, 0, 0, i, 7, null))));
            return Math.max(MathKt.roundToInt(Size.m4363getWidthimpl(m7962calculateScaledSizeE7KxVPU(SizeKt.Size(iMaxIntrinsicWidth, i)))), iMaxIntrinsicWidth);
        }
        return intrinsicMeasurable.maxIntrinsicWidth(i);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int minIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.getIntrinsicSize() != Size.INSTANCE.m4371getUnspecifiedNHjbRc()) {
            int iMinIntrinsicHeight = intrinsicMeasurable.minIntrinsicHeight(Constraints.m7208getMaxWidthimpl(m7963modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null))));
            return Math.max(MathKt.roundToInt(Size.m4360getHeightimpl(m7962calculateScaledSizeE7KxVPU(SizeKt.Size(i, iMinIntrinsicHeight)))), iMinIntrinsicHeight);
        }
        return intrinsicMeasurable.minIntrinsicHeight(i);
    }

    @Override // androidx.compose.ui.layout.LayoutModifier
    public int maxIntrinsicHeight(IntrinsicMeasureScope intrinsicMeasureScope, IntrinsicMeasurable intrinsicMeasurable, int i) {
        if (this.painter.getIntrinsicSize() != Size.INSTANCE.m4371getUnspecifiedNHjbRc()) {
            int iMaxIntrinsicHeight = intrinsicMeasurable.maxIntrinsicHeight(Constraints.m7208getMaxWidthimpl(m7963modifyConstraintsZezNO4M(ConstraintsKt.Constraints$default(0, i, 0, 0, 13, null))));
            return Math.max(MathKt.roundToInt(Size.m4360getHeightimpl(m7962calculateScaledSizeE7KxVPU(SizeKt.Size(i, iMaxIntrinsicHeight)))), iMaxIntrinsicHeight);
        }
        return intrinsicMeasurable.maxIntrinsicHeight(i);
    }

    /* renamed from: calculateScaledSize-E7KxVPU, reason: not valid java name */
    private final long m7962calculateScaledSizeE7KxVPU(long dstSize) {
        if (Size.m4365isEmptyimpl(dstSize)) {
            return Size.INSTANCE.m4372getZeroNHjbRc();
        }
        long intrinsicSize = this.painter.getIntrinsicSize();
        if (intrinsicSize == Size.INSTANCE.m4371getUnspecifiedNHjbRc()) {
            return dstSize;
        }
        float fM4363getWidthimpl = Size.m4363getWidthimpl(intrinsicSize);
        if (Float.isInfinite(fM4363getWidthimpl) || Float.isNaN(fM4363getWidthimpl)) {
            fM4363getWidthimpl = Size.m4363getWidthimpl(dstSize);
        }
        float fM4360getHeightimpl = Size.m4360getHeightimpl(intrinsicSize);
        if (Float.isInfinite(fM4360getHeightimpl) || Float.isNaN(fM4360getHeightimpl)) {
            fM4360getHeightimpl = Size.m4360getHeightimpl(dstSize);
        }
        long jSize = SizeKt.Size(fM4363getWidthimpl, fM4360getHeightimpl);
        return ScaleFactorKt.m6062timesUQTWf7w(jSize, this.contentScale.mo5950computeScaleFactorH7hwNQA(jSize, dstSize));
    }

    /* renamed from: modifyConstraints-ZezNO4M, reason: not valid java name */
    private final long m7963modifyConstraintsZezNO4M(long constraints) {
        float fM7210getMinWidthimpl;
        int iM7209getMinHeightimpl;
        float fM7983constrainHeightK40F9xA;
        boolean zM7206getHasFixedWidthimpl = Constraints.m7206getHasFixedWidthimpl(constraints);
        boolean zM7205getHasFixedHeightimpl = Constraints.m7205getHasFixedHeightimpl(constraints);
        if (zM7206getHasFixedWidthimpl && zM7205getHasFixedHeightimpl) {
            return constraints;
        }
        boolean z = Constraints.m7204getHasBoundedWidthimpl(constraints) && Constraints.m7203getHasBoundedHeightimpl(constraints);
        long intrinsicSize = this.painter.getIntrinsicSize();
        if (intrinsicSize == Size.INSTANCE.m4371getUnspecifiedNHjbRc()) {
            return z ? Constraints.m7198copyZbe2FdA$default(constraints, Constraints.m7208getMaxWidthimpl(constraints), 0, Constraints.m7207getMaxHeightimpl(constraints), 0, 10, null) : constraints;
        }
        if (z && (zM7206getHasFixedWidthimpl || zM7205getHasFixedHeightimpl)) {
            fM7210getMinWidthimpl = Constraints.m7208getMaxWidthimpl(constraints);
            iM7209getMinHeightimpl = Constraints.m7207getMaxHeightimpl(constraints);
        } else {
            float fM4363getWidthimpl = Size.m4363getWidthimpl(intrinsicSize);
            float fM4360getHeightimpl = Size.m4360getHeightimpl(intrinsicSize);
            fM7210getMinWidthimpl = (Float.isInfinite(fM4363getWidthimpl) || Float.isNaN(fM4363getWidthimpl)) ? Constraints.m7210getMinWidthimpl(constraints) : UtilsKt.m7984constrainWidthK40F9xA(constraints, fM4363getWidthimpl);
            if (Float.isInfinite(fM4360getHeightimpl) || Float.isNaN(fM4360getHeightimpl)) {
                iM7209getMinHeightimpl = Constraints.m7209getMinHeightimpl(constraints);
            } else {
                fM7983constrainHeightK40F9xA = UtilsKt.m7983constrainHeightK40F9xA(constraints, fM4360getHeightimpl);
                long jM7962calculateScaledSizeE7KxVPU = m7962calculateScaledSizeE7KxVPU(SizeKt.Size(fM7210getMinWidthimpl, fM7983constrainHeightK40F9xA));
                return Constraints.m7198copyZbe2FdA$default(constraints, ConstraintsKt.m7225constrainWidthK40F9xA(constraints, MathKt.roundToInt(Size.m4363getWidthimpl(jM7962calculateScaledSizeE7KxVPU))), 0, ConstraintsKt.m7224constrainHeightK40F9xA(constraints, MathKt.roundToInt(Size.m4360getHeightimpl(jM7962calculateScaledSizeE7KxVPU))), 0, 10, null);
            }
        }
        fM7983constrainHeightK40F9xA = iM7209getMinHeightimpl;
        long jM7962calculateScaledSizeE7KxVPU2 = m7962calculateScaledSizeE7KxVPU(SizeKt.Size(fM7210getMinWidthimpl, fM7983constrainHeightK40F9xA));
        return Constraints.m7198copyZbe2FdA$default(constraints, ConstraintsKt.m7225constrainWidthK40F9xA(constraints, MathKt.roundToInt(Size.m4363getWidthimpl(jM7962calculateScaledSizeE7KxVPU2))), 0, ConstraintsKt.m7224constrainHeightK40F9xA(constraints, MathKt.roundToInt(Size.m4360getHeightimpl(jM7962calculateScaledSizeE7KxVPU2))), 0, 10, null);
    }

    @Override // androidx.compose.ui.draw.DrawModifier
    public void draw(ContentDrawScope contentDrawScope) {
        long jM7962calculateScaledSizeE7KxVPU = m7962calculateScaledSizeE7KxVPU(contentDrawScope.mo5117getSizeNHjbRc());
        long jMo4017alignKFBX0sM = this.alignment.mo4017alignKFBX0sM(UtilsKt.m7985toIntSizeuvyYCjk(jM7962calculateScaledSizeE7KxVPU), UtilsKt.m7985toIntSizeuvyYCjk(contentDrawScope.mo5117getSizeNHjbRc()), contentDrawScope.getLayoutDirection());
        ContentDrawScope contentDrawScope2 = contentDrawScope;
        float fM7375component1impl = IntOffset.m7375component1impl(jMo4017alignKFBX0sM);
        float fM7376component2impl = IntOffset.m7376component2impl(jMo4017alignKFBX0sM);
        contentDrawScope2.getDrawContext().getTransform().translate(fM7375component1impl, fM7376component2impl);
        this.painter.m5243drawx_KDEd0(contentDrawScope2, jM7962calculateScaledSizeE7KxVPU, this.alpha, this.colorFilter);
        contentDrawScope2.getDrawContext().getTransform().translate(-fM7375component1impl, -fM7376component2impl);
        contentDrawScope.drawContent();
    }

    public ContentPainterModifier(final Painter painter, final Alignment alignment, final ContentScale contentScale, final float f, final ColorFilter colorFilter) {
        super(InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: coil.compose.ContentPainterModifier$special$$inlined$debugInspectorInfo$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                Intrinsics.checkNotNullParameter(inspectorInfo, "$this$null");
                inspectorInfo.setName("content");
                inspectorInfo.getProperties().set("painter", painter);
                inspectorInfo.getProperties().set("alignment", alignment);
                inspectorInfo.getProperties().set("contentScale", contentScale);
                inspectorInfo.getProperties().set("alpha", Float.valueOf(f));
                inspectorInfo.getProperties().set("colorFilter", colorFilter);
            }
        } : InspectableValueKt.getNoInspectorInfo());
        this.painter = painter;
        this.alignment = alignment;
        this.contentScale = contentScale;
        this.alpha = f;
        this.colorFilter = colorFilter;
    }
}
