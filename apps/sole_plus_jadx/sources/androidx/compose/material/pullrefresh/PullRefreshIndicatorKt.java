package androidx.compose.material.pullrefresh;

import androidx.compose.animation.CrossfadeKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ColorsKt;
import androidx.compose.material.ElevationOverlay;
import androidx.compose.material.ElevationOverlayKt;
import androidx.compose.material.MaterialTheme;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Rect;
import androidx.compose.ui.graphics.AndroidPath_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Path;
import androidx.compose.ui.graphics.PathFillType;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.graphics.drawscope.Stroke;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import com.android.SdkConstants;
import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: PullRefreshIndicator.kt */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0002H\u0002\u001a*\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0003ø\u0001\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001aJ\u0010\u001f\u001a\u00020\u00162\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\"\u001a\u00020\u001a2\b\b\u0002\u0010#\u001a\u00020\u001a2\b\b\u0002\u0010$\u001a\u00020!H\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a>\u0010'\u001a\u00020\u0016*\u00020(2\u0006\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0013H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u00100\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u000b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\f\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0011\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00061²\u0006\n\u00102\u001a\u00020!X\u008a\u0084\u0002²\u0006\n\u00103\u001a\u00020\u0002X\u008a\u0084\u0002"}, d2 = {"AlphaTween", "Landroidx/compose/animation/core/TweenSpec;", "", "ArcRadius", "Landroidx/compose/ui/unit/Dp;", "F", "ArrowHeight", "ArrowWidth", "CrossfadeDurationMs", "", "Elevation", "IndicatorSize", "MaxAlpha", "MaxProgressArc", "MinAlpha", "SpinnerShape", "Landroidx/compose/foundation/shape/RoundedCornerShape;", "StrokeWidth", "ArrowValues", "Landroidx/compose/material/pullrefresh/ArrowValues;", "progress", "CircularArrowIndicator", "", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/material/pullrefresh/PullRefreshState;", "color", "Landroidx/compose/ui/graphics/Color;", "modifier", "Landroidx/compose/ui/Modifier;", "CircularArrowIndicator-iJQMabo", "(Landroidx/compose/material/pullrefresh/PullRefreshState;JLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "PullRefreshIndicator", "refreshing", "", "backgroundColor", "contentColor", "scale", "PullRefreshIndicator-jB83MbM", "(ZLandroidx/compose/material/pullrefresh/PullRefreshState;Landroidx/compose/ui/Modifier;JJZLandroidx/compose/runtime/Composer;II)V", "drawArrow", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "arrow", "Landroidx/compose/ui/graphics/Path;", "bounds", "Landroidx/compose/ui/geometry/Rect;", "alpha", SdkConstants.FD_RES_VALUES, "drawArrow-Bx497Mc", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;Landroidx/compose/ui/graphics/Path;Landroidx/compose/ui/geometry/Rect;JFLandroidx/compose/material/pullrefresh/ArrowValues;)V", "material_release", "showElevation", "targetAlpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PullRefreshIndicatorKt {
    private static final int CrossfadeDurationMs = 100;
    private static final float MaxAlpha = 1.0f;
    private static final float MaxProgressArc = 0.8f;
    private static final float MinAlpha = 0.3f;
    private static final float IndicatorSize = Dp.m7255constructorimpl(40);
    private static final RoundedCornerShape SpinnerShape = RoundedCornerShapeKt.getCircleShape();
    private static final float ArcRadius = Dp.m7255constructorimpl((float) 7.5d);
    private static final float StrokeWidth = Dp.m7255constructorimpl((float) 2.5d);
    private static final float ArrowWidth = Dp.m7255constructorimpl(10);
    private static final float ArrowHeight = Dp.m7255constructorimpl(5);
    private static final float Elevation = Dp.m7255constructorimpl(6);
    private static final TweenSpec<Float> AlphaTween = AnimationSpecKt.tween$default(300, 0, EasingKt.getLinearEasing(), 2, null);

    /* renamed from: PullRefreshIndicator-jB83MbM, reason: not valid java name */
    public static final void m2051PullRefreshIndicatorjB83MbM(final boolean z, final PullRefreshState pullRefreshState, Modifier modifier, long j, long j2, boolean z2, Composer composer, final int i, final int i2) {
        long jM1803getSurface0d7_KjU;
        int i3;
        final long j3;
        int i4;
        long jM4548unboximpl;
        Composer composerStartRestartGroup = composer.startRestartGroup(308716636);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PullRefreshIndicator)P(3,5,2,0:c#ui.graphics.Color,1:c#ui.graphics.Color)78@3382L6,79@3424L32,82@3514L98,89@3897L7,93@4025L1067:PullRefreshIndicator.kt#t44y28");
        Modifier modifier2 = (i2 & 4) != 0 ? Modifier.INSTANCE : modifier;
        if ((i2 & 8) != 0) {
            i3 = i & (-7169);
            jM1803getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1803getSurface0d7_KjU();
        } else {
            jM1803getSurface0d7_KjU = j;
            i3 = i;
        }
        if ((i2 & 16) != 0) {
            long jM1817contentColorForek8zF_U = ColorsKt.m1817contentColorForek8zF_U(jM1803getSurface0d7_KjU, composerStartRestartGroup, (i3 >> 9) & 14);
            i3 &= -57345;
            j3 = jM1817contentColorForek8zF_U;
        } else {
            j3 = j2;
        }
        boolean z3 = (i2 & 32) != 0 ? false : z2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(308716636, i3, -1, "androidx.compose.material.pullrefresh.PullRefreshIndicator (PullRefreshIndicator.kt:81)");
        }
        Boolean boolValueOf = Boolean.valueOf(z);
        int i5 = i3 & 14;
        composerStartRestartGroup.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean zChanged = composerStartRestartGroup.changed(boolValueOf) | composerStartRestartGroup.changed(pullRefreshState);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$showElevation$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(z || pullRefreshState.getPosition$material_release() > 0.5f);
                }
            });
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceableGroup();
        State state = (State) objRememberedValue;
        ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composerStartRestartGroup.consume(localElevationOverlay);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ElevationOverlay elevationOverlay = (ElevationOverlay) objConsume;
        composerStartRestartGroup.startReplaceableGroup(52228748);
        ComposerKt.sourceInformation(composerStartRestartGroup, "90@3939L53");
        Color colorM4528boximpl = elevationOverlay == null ? null : Color.m4528boximpl(elevationOverlay.mo1839apply7g2Lkgo(jM1803getSurface0d7_KjU, Elevation, composerStartRestartGroup, ((i3 >> 9) & 14) | 48));
        composerStartRestartGroup.endReplaceableGroup();
        if (colorM4528boximpl != null) {
            i4 = i5;
            jM4548unboximpl = colorM4528boximpl.m4548unboximpl();
        } else {
            i4 = i5;
            jM4548unboximpl = jM1803getSurface0d7_KjU;
        }
        Modifier modifierPullRefreshIndicatorTransform = PullRefreshIndicatorTransformKt.pullRefreshIndicatorTransform(SizeKt.m1030size3ABfNKs(modifier2, IndicatorSize), pullRefreshState, z3);
        float fM7255constructorimpl = PullRefreshIndicator_jB83MbM$lambda$1(state) ? Elevation : Dp.m7255constructorimpl(0);
        RoundedCornerShape roundedCornerShape = SpinnerShape;
        Modifier modifierM539backgroundbw27NRU = BackgroundKt.m539backgroundbw27NRU(ShadowKt.m4141shadows4CzXII$default(modifierPullRefreshIndicatorTransform, fM7255constructorimpl, roundedCornerShape, true, 0L, 0L, 24, null), jM4548unboximpl, roundedCornerShape);
        composerStartRestartGroup.startReplaceableGroup(733328855);
        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
        MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(-1323940314);
        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifierM539backgroundbw27NRU);
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor);
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM3857constructorimpl = Updater.m3857constructorimpl(composerStartRestartGroup);
        Updater.m3864setimpl(composerM3857constructorimpl, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3864setimpl(composerM3857constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM3857constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM3857constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM3857constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        function3ModifierMaterializerOf.invoke(SkippableUpdater.m3827boximpl(SkippableUpdater.m3828constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
        composerStartRestartGroup.startReplaceableGroup(2058660585);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1406369954, "C100@4312L774:PullRefreshIndicator.kt#t44y28");
        final long j4 = j3;
        CrossfadeKt.Crossfade(Boolean.valueOf(z), (Modifier) null, AnimationSpecKt.tween$default(100, 0, null, 6, null), (String) null, ComposableLambdaKt.composableLambda(composerStartRestartGroup, 1853731063, true, new Function3<Boolean, Composer, Integer, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$1$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool, Composer composer2, Integer num) {
                invoke(bool.booleanValue(), composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z4, Composer composer2, int i6) {
                ComposerKt.sourceInformation(composer2, "C104@4471L605:PullRefreshIndicator.kt#t44y28");
                if ((i6 & 14) == 0) {
                    i6 |= composer2.changed(z4) ? 4 : 2;
                }
                if ((i6 & 91) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1853731063, i6, -1, "androidx.compose.material.pullrefresh.PullRefreshIndicator.<anonymous>.<anonymous> (PullRefreshIndicator.kt:104)");
                    }
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Alignment center = Alignment.INSTANCE.getCenter();
                    long j5 = j3;
                    PullRefreshState pullRefreshState2 = pullRefreshState;
                    composer2.startReplaceableGroup(733328855);
                    ComposerKt.sourceInformation(composer2, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center, false, composer2, 6);
                    composer2.startReplaceableGroup(-1323940314);
                    ComposerKt.sourceInformation(composer2, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifierFillMaxSize$default);
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM3857constructorimpl2 = Updater.m3857constructorimpl(composer2);
                    Updater.m3864setimpl(composerM3857constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3864setimpl(composerM3857constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM3857constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composerM3857constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM3857constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    function3ModifierMaterializerOf2.invoke(SkippableUpdater.m3827boximpl(SkippableUpdater.m3828constructorimpl(composer2)), composer2, 0);
                    composer2.startReplaceableGroup(2058660585);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -2035147121, "C:PullRefreshIndicator.kt#t44y28");
                    float fM7255constructorimpl2 = Dp.m7255constructorimpl(Dp.m7255constructorimpl(PullRefreshIndicatorKt.ArcRadius + PullRefreshIndicatorKt.StrokeWidth) * 2);
                    if (z4) {
                        composer2.startReplaceableGroup(-2035147035);
                        ComposerKt.sourceInformation(composer2, "111@4719L208");
                        ProgressIndicatorKt.m1923CircularProgressIndicatorLxG7B9w(SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, fM7255constructorimpl2), j5, PullRefreshIndicatorKt.StrokeWidth, 0L, 0, composer2, 390, 24);
                        composer2.endReplaceableGroup();
                    } else {
                        composer2.startReplaceableGroup(-2035146781);
                        ComposerKt.sourceInformation(composer2, "117@4973L71");
                        PullRefreshIndicatorKt.m2050CircularArrowIndicatoriJQMabo(pullRefreshState2, j5, SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, fM7255constructorimpl2), composer2, 392);
                        composer2.endReplaceableGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceableGroup();
                    composer2.endNode();
                    composer2.endReplaceableGroup();
                    composer2.endReplaceableGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }), composerStartRestartGroup, i4 | 24960, 10);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endNode();
        composerStartRestartGroup.endReplaceableGroup();
        composerStartRestartGroup.endReplaceableGroup();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier3 = modifier2;
            final long j5 = jM1803getSurface0d7_KjU;
            final boolean z4 = z3;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$PullRefreshIndicator$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    PullRefreshIndicatorKt.m2051PullRefreshIndicatorjB83MbM(z, pullRefreshState, modifier3, j5, j4, z4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: CircularArrowIndicator-iJQMabo, reason: not valid java name */
    public static final void m2050CircularArrowIndicatoriJQMabo(final PullRefreshState pullRefreshState, final long j, final Modifier modifier, Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-486016981);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CircularArrowIndicator)P(2,0:c#ui.graphics.Color)134@5303L61,136@5389L119,142@5531L74,145@5644L1000:PullRefreshIndicator.kt#t44y28");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-486016981, i, -1, "androidx.compose.material.pullrefresh.CircularArrowIndicator (PullRefreshIndicator.kt:133)");
        }
        composerStartRestartGroup.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Composables.kt#9igjgp");
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        Object obj = objRememberedValue;
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            Path Path = AndroidPath_androidKt.Path();
            Path.mo4429setFillTypeoQ8Xj4U(PathFillType.INSTANCE.m4832getEvenOddRgk1Os());
            composerStartRestartGroup.updateRememberedValue(Path);
            obj = Path;
        }
        composerStartRestartGroup.endReplaceableGroup();
        final Path path = (Path) obj;
        composerStartRestartGroup.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean zChanged = composerStartRestartGroup.changed(pullRefreshState);
        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Float>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$targetAlpha$2$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(pullRefreshState.getProgress() < 1.0f ? 0.3f : 1.0f);
                }
            });
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
        }
        composerStartRestartGroup.endReplaceableGroup();
        final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(CircularArrowIndicator_iJQMabo$lambda$6((State) objRememberedValue2), AlphaTween, 0.0f, null, null, composerStartRestartGroup, 48, 28);
        CanvasKt.Canvas(SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                invoke2(semanticsPropertyReceiver);
                return Unit.INSTANCE;
            }
        }, 1, null), new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(DrawScope drawScope) {
                invoke2(drawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(DrawScope drawScope) {
                ArrowValues ArrowValues = PullRefreshIndicatorKt.ArrowValues(pullRefreshState.getProgress());
                float fFloatValue = stateAnimateFloatAsState.getValue().floatValue();
                float rotation = ArrowValues.getRotation();
                long j2 = j;
                Path path2 = path;
                long jMo5116getCenterF1C5BW0 = drawScope.mo5116getCenterF1C5BW0();
                DrawContext drawContext = drawScope.getDrawContext();
                long jMo5038getSizeNHjbRc = drawContext.mo5038getSizeNHjbRc();
                drawContext.getCanvas().save();
                drawContext.getTransform().mo5044rotateUv8p0NA(rotation, jMo5116getCenterF1C5BW0);
                float f = drawScope.mo677toPx0680j_4(PullRefreshIndicatorKt.ArcRadius) + (drawScope.mo677toPx0680j_4(PullRefreshIndicatorKt.StrokeWidth) / 2.0f);
                Rect rect = new Rect(Offset.m4294getXimpl(androidx.compose.ui.geometry.SizeKt.m4373getCenteruvyYCjk(drawScope.mo5117getSizeNHjbRc())) - f, Offset.m4295getYimpl(androidx.compose.ui.geometry.SizeKt.m4373getCenteruvyYCjk(drawScope.mo5117getSizeNHjbRc())) - f, Offset.m4294getXimpl(androidx.compose.ui.geometry.SizeKt.m4373getCenteruvyYCjk(drawScope.mo5117getSizeNHjbRc())) + f, Offset.m4295getYimpl(androidx.compose.ui.geometry.SizeKt.m4373getCenteruvyYCjk(drawScope.mo5117getSizeNHjbRc())) + f);
                DrawScope.m5096drawArcyD3GUKo$default(drawScope, j2, ArrowValues.getStartAngle(), ArrowValues.getEndAngle() - ArrowValues.getStartAngle(), false, rect.m4329getTopLeftF1C5BW0(), rect.m4327getSizeNHjbRc(), fFloatValue, new Stroke(drawScope.mo677toPx0680j_4(PullRefreshIndicatorKt.StrokeWidth), 0.0f, StrokeCap.INSTANCE.m4910getSquareKaPHkGw(), 0, null, 26, null), null, 0, 768, null);
                PullRefreshIndicatorKt.m2054drawArrowBx497Mc(drawScope, path2, rect, j2, fFloatValue, ArrowValues);
                drawContext.getCanvas().restore();
                drawContext.mo5039setSizeuvyYCjk(jMo5038getSizeNHjbRc);
            }
        }, composerStartRestartGroup, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshIndicatorKt$CircularArrowIndicator$3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i2) {
                    PullRefreshIndicatorKt.m2050CircularArrowIndicatoriJQMabo(pullRefreshState, j, modifier, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ArrowValues ArrowValues(float f) {
        float fMax = (Math.max(Math.min(1.0f, f) - 0.4f, 0.0f) * 5) / 3;
        float fCoerceIn = RangesKt.coerceIn(Math.abs(f) - 1.0f, 0.0f, 2.0f);
        float fPow = (((0.4f * fMax) - 0.25f) + (fCoerceIn - (((float) Math.pow(fCoerceIn, 2)) / 4))) * 0.5f;
        float f2 = 360;
        return new ArrowValues(fPow, fPow * f2, ((MaxProgressArc * fMax) + fPow) * f2, Math.min(1.0f, fMax));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawArrow-Bx497Mc, reason: not valid java name */
    public static final void m2054drawArrowBx497Mc(DrawScope drawScope, Path path, Rect rect, long j, float f, ArrowValues arrowValues) {
        path.reset();
        path.moveTo(0.0f, 0.0f);
        float f2 = ArrowWidth;
        path.lineTo(drawScope.mo677toPx0680j_4(f2) * arrowValues.getScale(), 0.0f);
        path.lineTo((drawScope.mo677toPx0680j_4(f2) * arrowValues.getScale()) / 2, drawScope.mo677toPx0680j_4(ArrowHeight) * arrowValues.getScale());
        path.mo4431translatek4lQ0M(OffsetKt.Offset(((Math.min(rect.getWidth(), rect.getHeight()) / 2.0f) + Offset.m4294getXimpl(rect.m4324getCenterF1C5BW0())) - ((drawScope.mo677toPx0680j_4(f2) * arrowValues.getScale()) / 2.0f), Offset.m4295getYimpl(rect.m4324getCenterF1C5BW0()) + (drawScope.mo677toPx0680j_4(StrokeWidth) / 2.0f)));
        path.close();
        float endAngle = arrowValues.getEndAngle();
        long jMo5116getCenterF1C5BW0 = drawScope.mo5116getCenterF1C5BW0();
        DrawContext drawContext = drawScope.getDrawContext();
        long jMo5038getSizeNHjbRc = drawContext.mo5038getSizeNHjbRc();
        drawContext.getCanvas().save();
        drawContext.getTransform().mo5044rotateUv8p0NA(endAngle, jMo5116getCenterF1C5BW0);
        DrawScope.m5107drawPathLG529CI$default(drawScope, path, j, f, null, null, 0, 56, null);
        drawContext.getCanvas().restore();
        drawContext.mo5039setSizeuvyYCjk(jMo5038getSizeNHjbRc);
    }

    private static final boolean PullRefreshIndicator_jB83MbM$lambda$1(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final float CircularArrowIndicator_iJQMabo$lambda$6(State<Float> state) {
        return state.getValue().floatValue();
    }
}
