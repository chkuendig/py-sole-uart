package androidx.compose.material.pullrefresh;

import androidx.compose.animation.core.EasingKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.ranges.RangesKt;

/* compiled from: PullRefreshIndicatorTransform.kt */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u0007¨\u0006\u0006"}, d2 = {"pullRefreshIndicatorTransform", "Landroidx/compose/ui/Modifier;", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/material/pullrefresh/PullRefreshState;", "scale", "", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PullRefreshIndicatorTransformKt {
    public static /* synthetic */ Modifier pullRefreshIndicatorTransform$default(Modifier modifier, PullRefreshState pullRefreshState, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = false;
        }
        return pullRefreshIndicatorTransform(modifier, pullRefreshState, z);
    }

    public static final Modifier pullRefreshIndicatorTransform(Modifier modifier, final PullRefreshState pullRefreshState, final boolean z) {
        Function1<InspectorInfo, Unit> noInspectorInfo = InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$$inlined$debugInspectorInfo$1
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
                inspectorInfo.setName("pullRefreshIndicatorTransform");
                inspectorInfo.getProperties().set(ServerProtocol.DIALOG_PARAM_STATE, pullRefreshState);
                inspectorInfo.getProperties().set("scale", Boolean.valueOf(z));
            }
        } : InspectableValueKt.getNoInspectorInfo();
        Modifier.Companion companion = Modifier.INSTANCE;
        return InspectableValueKt.inspectableWrapper(modifier, noInspectorInfo, GraphicsLayerModifierKt.graphicsLayer(DrawModifierKt.drawWithContent(Modifier.INSTANCE, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope contentDrawScope) {
                int iM4527getIntersectrtfAjoo = ClipOp.INSTANCE.m4527getIntersectrtfAjoo();
                DrawContext drawContext = contentDrawScope.getDrawContext();
                long jMo5038getSizeNHjbRc = drawContext.mo5038getSizeNHjbRc();
                drawContext.getCanvas().save();
                drawContext.getTransform().mo5041clipRectN_I0leg(-3.4028235E38f, 0.0f, Float.MAX_VALUE, Float.MAX_VALUE, iM4527getIntersectrtfAjoo);
                contentDrawScope.drawContent();
                drawContext.getCanvas().restore();
                drawContext.mo5039setSizeuvyYCjk(jMo5038getSizeNHjbRc);
            }
        }), new Function1<GraphicsLayerScope, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorTransformKt$pullRefreshIndicatorTransform$2$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(GraphicsLayerScope graphicsLayerScope) {
                invoke2(graphicsLayerScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(GraphicsLayerScope graphicsLayerScope) {
                graphicsLayerScope.setTranslationY(pullRefreshState.getPosition$material_release() - Size.m4360getHeightimpl(graphicsLayerScope.getSize()));
                if (!z || pullRefreshState.getRefreshing$material_release()) {
                    return;
                }
                float fCoerceIn = RangesKt.coerceIn(EasingKt.getLinearOutSlowInEasing().transform(pullRefreshState.getPosition$material_release() / pullRefreshState.getThreshold$material_release()), 0.0f, 1.0f);
                graphicsLayerScope.setScaleX(fCoerceIn);
                graphicsLayerScope.setScaleY(fCoerceIn);
            }
        }));
    }
}
