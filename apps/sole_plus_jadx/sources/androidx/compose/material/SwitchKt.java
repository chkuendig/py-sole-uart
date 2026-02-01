package androidx.compose.material;

import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.IndicationKt;
import androidx.compose.foundation.interaction.InteractionSource;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ripple.RippleKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.StrokeCap;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntOffsetKt;
import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.math.MathKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: Switch.kt */
@Metadata(d1 = {"\u0000\\\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\u001aS\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\u0014\u0010\u0019\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010\u001d\u001a\u00020\u00182\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!H\u0007¢\u0006\u0002\u0010\"\u001a?\u0010#\u001a\u00020\u0016*\u00020$2\u0006\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u001d\u001a\u00020\u00182\u0006\u0010 \u001a\u00020!2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00020&2\u0006\u0010\u001e\u001a\u00020'H\u0003¢\u0006\u0002\u0010(\u001a.\u0010)\u001a\u00020\u0016*\u00020*2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020\u00022\u0006\u0010.\u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\b/\u00100\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\u0007\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\b\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\t\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\n\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0016\u0010\u000b\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\f\u0010\r\"\u0010\u0010\u000e\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u000f\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0010\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0016\u0010\u0011\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0012\u0010\r\"\u0016\u0010\u0013\u001a\u00020\u0004X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0005\u001a\u0004\b\u0014\u0010\r\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00061²\u0006\n\u00102\u001a\u00020\u0018X\u008a\u008e\u0002²\u0006\u0018\u00103\u001a\u0010\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u0016\u0018\u00010\u001aX\u008a\u0084\u0002²\u0006\n\u00104\u001a\u00020\u0018X\u008a\u0084\u0002²\u0006\n\u0010+\u001a\u00020,X\u008a\u0084\u0002²\u0006\n\u00105\u001a\u00020,X\u008a\u0084\u0002²\u0006\n\u00106\u001a\u00020,X\u008a\u0084\u0002"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "DefaultSwitchPadding", "Landroidx/compose/ui/unit/Dp;", "F", "SwitchHeight", "SwitchPositionalThreshold", "SwitchVelocityThreshold", "SwitchWidth", "ThumbDefaultElevation", "ThumbDiameter", "getThumbDiameter", "()F", "ThumbPathLength", "ThumbPressedElevation", "ThumbRippleRadius", "TrackStrokeWidth", "getTrackStrokeWidth", "TrackWidth", "getTrackWidth", SdkConstants.SWITCH, "", SdkConstants.ATTR_CHECKED, "", "onCheckedChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "colors", "Landroidx/compose/material/SwitchColors;", "(ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/SwitchColors;Landroidx/compose/runtime/Composer;II)V", "SwitchImpl", "Landroidx/compose/foundation/layout/BoxScope;", "thumbValue", "Lkotlin/Function0;", "Landroidx/compose/foundation/interaction/InteractionSource;", "(Landroidx/compose/foundation/layout/BoxScope;ZZLandroidx/compose/material/SwitchColors;Lkotlin/jvm/functions/Function0;Landroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/runtime/Composer;I)V", "drawTrack", "Landroidx/compose/ui/graphics/drawscope/DrawScope;", "trackColor", "Landroidx/compose/ui/graphics/Color;", "trackWidth", SdkConstants.ATTR_STROKE_WIDTH, "drawTrack-RPmYEkk", "(Landroidx/compose/ui/graphics/drawscope/DrawScope;JFF)V", "material_release", "forceAnimationCheck", "currentOnCheckedChange", "currentChecked", "thumbColor", "resolvedThumbColor"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SwitchKt {
    private static final TweenSpec<Float> AnimationSpec;
    private static final float DefaultSwitchPadding;
    private static final float SwitchHeight;
    private static final float SwitchPositionalThreshold = 0.7f;
    private static final float SwitchVelocityThreshold;
    private static final float SwitchWidth;
    private static final float ThumbDefaultElevation;
    private static final float ThumbDiameter;
    private static final float ThumbPathLength;
    private static final float ThumbPressedElevation;
    private static final float ThumbRippleRadius;
    private static final float TrackStrokeWidth;
    private static final float TrackWidth;

    /* JADX WARN: Removed duplicated region for block: B:100:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0279  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x02c2  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x02f5  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x03a9  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x043a  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x0493  */
    /* JADX WARN: Removed duplicated region for block: B:160:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00ce  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0105  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x010b  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0160  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Switch(final boolean r46, final kotlin.jvm.functions.Function1<? super java.lang.Boolean, kotlin.Unit> r47, androidx.compose.ui.Modifier r48, boolean r49, androidx.compose.foundation.interaction.MutableInteractionSource r50, androidx.compose.material.SwitchColors r51, androidx.compose.runtime.Composer r52, final int r53, final int r54) {
        /*
            Method dump skipped, instructions count: 1191
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwitchKt.Switch(boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.material.SwitchColors, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Switch$lambda$3(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void Switch$lambda$4(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SwitchImpl(final BoxScope boxScope, final boolean z, final boolean z2, final SwitchColors switchColors, final Function0<Float> function0, final InteractionSource interactionSource, Composer composer, final int i) {
        int i2;
        float f;
        long jSwitchImpl$lambda$17;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(70908914);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SwitchImpl)P(!1,2!1,4)220@9007L46,222@9059L648,241@9910L28,242@9943L171,248@10144L28,249@10222L7,*250@10281L7,252@10392L6,251@10331L228,264@10804L59,258@10564L475:Switch.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(boxScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(switchColors) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(interactionSource) ? 131072 : 65536;
        }
        if ((374491 & i2) != 74898 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(70908914, i2, -1, "androidx.compose.material.SwitchImpl (Switch.kt:219)");
            }
            composerStartRestartGroup.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):Composables.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.mutableStateListOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SnapshotStateList snapshotStateList = (SnapshotStateList) objRememberedValue;
            composerStartRestartGroup.startReplaceableGroup(-1650291661);
            boolean zChanged = composerStartRestartGroup.changed(interactionSource) | composerStartRestartGroup.changed(snapshotStateList);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function2) new SwitchKt$SwitchImpl$1$1(interactionSource, snapshotStateList, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            EffectsKt.LaunchedEffect(interactionSource, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue2, composerStartRestartGroup, ((i2 >> 15) & 14) | 64);
            if (!snapshotStateList.isEmpty()) {
                f = ThumbPressedElevation;
            } else {
                f = ThumbDefaultElevation;
            }
            float f2 = f;
            int i3 = ((i2 >> 6) & 14) | (i2 & 112) | ((i2 >> 3) & 896);
            final State<Color> stateTrackColor = switchColors.trackColor(z2, z, composerStartRestartGroup, i3);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(boxScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), 0.0f, 1, null);
            composerStartRestartGroup.startReplaceableGroup(-1650290721);
            boolean zChanged2 = composerStartRestartGroup.changed(stateTrackColor);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$2$1
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
                        SwitchKt.m1992drawTrackRPmYEkk(drawScope, SwitchKt.SwitchImpl$lambda$15(stateTrackColor), drawScope.mo677toPx0680j_4(SwitchKt.getTrackWidth()), drawScope.mo677toPx0680j_4(SwitchKt.getTrackStrokeWidth()));
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(modifierFillMaxSize$default, (Function1) objRememberedValue3, composerStartRestartGroup, 0);
            State<Color> stateThumbColor = switchColors.thumbColor(z2, z, composerStartRestartGroup, i3);
            ProvidableCompositionLocal<ElevationOverlay> localElevationOverlay = ElevationOverlayKt.getLocalElevationOverlay();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localElevationOverlay);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ElevationOverlay elevationOverlay = (ElevationOverlay) objConsume;
            ProvidableCompositionLocal<Dp> localAbsoluteElevation = ElevationOverlayKt.getLocalAbsoluteElevation();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localAbsoluteElevation);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float fM7255constructorimpl = Dp.m7255constructorimpl(((Dp) objConsume2).m7269unboximpl() + f2);
            composerStartRestartGroup.startReplaceableGroup(-539243554);
            ComposerKt.sourceInformation(composerStartRestartGroup, "253@10467L36");
            if (Color.m4539equalsimpl0(SwitchImpl$lambda$17(stateThumbColor), MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1803getSurface0d7_KjU()) && elevationOverlay != null) {
                jSwitchImpl$lambda$17 = elevationOverlay.mo1839apply7g2Lkgo(SwitchImpl$lambda$17(stateThumbColor), fM7255constructorimpl, composerStartRestartGroup, 0);
            } else {
                jSwitchImpl$lambda$17 = SwitchImpl$lambda$17(stateThumbColor);
            }
            composerStartRestartGroup.endReplaceableGroup();
            composer2 = composerStartRestartGroup;
            State<Color> stateM418animateColorAsStateeuL9pac = SingleValueAnimationKt.m418animateColorAsStateeuL9pac(jSwitchImpl$lambda$17, null, null, null, composerStartRestartGroup, 0, 14);
            Modifier modifierAlign = boxScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenterStart());
            composer2.startReplaceableGroup(-1650290103);
            boolean zChangedInstance = composer2.changedInstance(function0);
            Object objRememberedValue4 = composer2.rememberedValue();
            if (zChangedInstance || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = (Function1) new Function1<Density, IntOffset>() { // from class: androidx.compose.material.SwitchKt$SwitchImpl$3$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ IntOffset invoke(Density density) {
                        return IntOffset.m7374boximpl(m1993invokeBjo55l4(density));
                    }

                    /* renamed from: invoke-Bjo55l4, reason: not valid java name */
                    public final long m1993invokeBjo55l4(Density density) {
                        return IntOffsetKt.IntOffset(MathKt.roundToInt(function0.invoke().floatValue()), 0);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue4);
            }
            composer2.endReplaceableGroup();
            SpacerKt.Spacer(BackgroundKt.m539backgroundbw27NRU(ShadowKt.m4141shadows4CzXII$default(SizeKt.m1022requiredSize3ABfNKs(IndicationKt.indication(OffsetKt.offset(modifierAlign, (Function1) objRememberedValue4), interactionSource, RippleKt.m2065rememberRipple9IZ8Weo(false, ThumbRippleRadius, 0L, composer2, 54, 4)), ThumbDiameter), f2, RoundedCornerShapeKt.getCircleShape(), false, 0L, 0L, 24, null), SwitchImpl$lambda$18(stateM418animateColorAsStateeuL9pac), RoundedCornerShapeKt.getCircleShape()), composer2, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.SwitchKt.SwitchImpl.4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    SwitchKt.SwitchImpl(boxScope, z, z2, switchColors, function0, interactionSource, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: drawTrack-RPmYEkk, reason: not valid java name */
    public static final void m1992drawTrackRPmYEkk(DrawScope drawScope, long j, float f, float f2) {
        float f3 = f2 / 2;
        DrawScope.m5103drawLineNGM6Ib0$default(drawScope, j, androidx.compose.ui.geometry.OffsetKt.Offset(f3, Offset.m4295getYimpl(drawScope.mo5116getCenterF1C5BW0())), androidx.compose.ui.geometry.OffsetKt.Offset(f - f3, Offset.m4295getYimpl(drawScope.mo5116getCenterF1C5BW0())), f2, StrokeCap.INSTANCE.m4909getRoundKaPHkGw(), null, 0.0f, null, 0, 480, null);
    }

    public static final float getTrackWidth() {
        return TrackWidth;
    }

    public static final float getTrackStrokeWidth() {
        return TrackStrokeWidth;
    }

    public static final float getThumbDiameter() {
        return ThumbDiameter;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function1<Boolean, Unit> Switch$lambda$7(State<? extends Function1<? super Boolean, Unit>> state) {
        return (Function1) state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean Switch$lambda$8(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long SwitchImpl$lambda$15(State<Color> state) {
        return state.getValue().m4548unboximpl();
    }

    private static final long SwitchImpl$lambda$17(State<Color> state) {
        return state.getValue().m4548unboximpl();
    }

    private static final long SwitchImpl$lambda$18(State<Color> state) {
        return state.getValue().m4548unboximpl();
    }

    static {
        float fM7255constructorimpl = Dp.m7255constructorimpl(34);
        TrackWidth = fM7255constructorimpl;
        TrackStrokeWidth = Dp.m7255constructorimpl(14);
        float fM7255constructorimpl2 = Dp.m7255constructorimpl(20);
        ThumbDiameter = fM7255constructorimpl2;
        ThumbRippleRadius = Dp.m7255constructorimpl(24);
        DefaultSwitchPadding = Dp.m7255constructorimpl(2);
        SwitchWidth = fM7255constructorimpl;
        SwitchHeight = fM7255constructorimpl2;
        ThumbPathLength = Dp.m7255constructorimpl(fM7255constructorimpl - fM7255constructorimpl2);
        AnimationSpec = new TweenSpec<>(100, 0, null, 6, null);
        ThumbDefaultElevation = Dp.m7255constructorimpl(1);
        ThumbPressedElevation = Dp.m7255constructorimpl(6);
        SwitchVelocityThreshold = Dp.m7255constructorimpl(125);
    }
}
