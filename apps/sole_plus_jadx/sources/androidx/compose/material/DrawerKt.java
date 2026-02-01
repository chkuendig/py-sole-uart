package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Velocity;
import com.android.SdkConstants;
import com.facebook.internal.ServerProtocol;
import com.sun.jna.platform.win32.WinError;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.ranges.RangesKt;

/* compiled from: Drawer.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0093\u0001\u0010\t\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\n0\u001e¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b\u001f\u0010 \u001a0\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u001a2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\n0\u001e2\u0006\u0010$\u001a\u00020\u0015H\u0003ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001a.\u0010'\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00150\fH\u0007\u001a\u0014\u0010-\u001a\u00020.2\n\u0010/\u001a\u0006\u0012\u0002\b\u000300H\u0002\u001a\u0093\u0001\u00101\u001a\u00020\n2\u001c\u0010\u000b\u001a\u0018\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\n0\f¢\u0006\u0002\b\u000e¢\u0006\u0002\b\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u0002022\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00052\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001a2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\n0\u001e¢\u0006\u0002\b\u000eH\u0007ø\u0001\u0000¢\u0006\u0004\b3\u00104\u001a>\u00105\u001a\u00020\n2\u0006\u00106\u001a\u00020\u00152\f\u00107\u001a\b\u0012\u0004\u0012\u00020\n0\u001e2\f\u00108\u001a\b\u0012\u0004\u0012\u00020\u00020\u001e2\u0006\u0010\"\u001a\u00020\u001aH\u0003ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a \u0010;\u001a\u00020\u00022\u0006\u0010<\u001a\u00020\u00022\u0006\u0010=\u001a\u00020\u00022\u0006\u0010>\u001a\u00020\u0002H\u0002\u001a+\u0010?\u001a\u00020\u00132\u0006\u0010(\u001a\u00020)2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00150\fH\u0007¢\u0006\u0002\u0010@\u001a+\u0010A\u001a\u0002022\u0006\u0010(\u001a\u00020B2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020B\u0012\u0004\u0012\u00020\u00150\fH\u0007¢\u0006\u0002\u0010C\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0002X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\u0007\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\"\u0010\u0010\b\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0006\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006D²\u0006\n\u0010E\u001a\u00020\u0002X\u008a\u0084\u0002"}, d2 = {"AnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "BottomDrawerOpenFraction", "DrawerPositionalThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "DrawerVelocityThreshold", "EndDrawerPadding", "BottomDrawer", "", "drawerContent", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "modifier", "Landroidx/compose/ui/Modifier;", "drawerState", "Landroidx/compose/material/BottomDrawerState;", "gesturesEnabled", "", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "scrimColor", "content", "Lkotlin/Function0;", "BottomDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomDrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "BottomDrawerScrim", "color", "onDismiss", SdkConstants.ATTR_VISIBLE, "BottomDrawerScrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "BottomDrawerState", "initialValue", "Landroidx/compose/material/BottomDrawerValue;", "density", "Landroidx/compose/ui/unit/Density;", "confirmStateChange", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/material/AnchoredDraggableState;", "ModalDrawer", "Landroidx/compose/material/DrawerState;", "ModalDrawer-Gs3lGvM", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/DrawerState;ZLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "Scrim", "open", "onClose", "fraction", "Scrim-Bx497Mc", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;I)V", "calculateFraction", "a", "b", "pos", "rememberBottomDrawerState", "(Landroidx/compose/material/BottomDrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomDrawerState;", "rememberDrawerState", "Landroidx/compose/material/DrawerValue;", "(Landroidx/compose/material/DrawerValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/DrawerState;", "material_release", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class DrawerKt {
    private static final float BottomDrawerOpenFraction = 0.5f;
    private static final float DrawerPositionalThreshold;
    private static final float EndDrawerPadding;
    private static final float DrawerVelocityThreshold = Dp.m7255constructorimpl(400);
    private static final TweenSpec<Float> AnimationSpec = new TweenSpec<>(256, 0, null, 6, null);

    public static /* synthetic */ BottomDrawerState BottomDrawerState$default(BottomDrawerValue bottomDrawerValue, Density density, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            function1 = new Function1<BottomDrawerValue, Boolean>() { // from class: androidx.compose.material.DrawerKt.BottomDrawerState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BottomDrawerValue bottomDrawerValue2) {
                    return true;
                }
            };
        }
        return BottomDrawerState(bottomDrawerValue, density, function1);
    }

    public static final BottomDrawerState BottomDrawerState(BottomDrawerValue bottomDrawerValue, Density density, Function1<? super BottomDrawerValue, Boolean> function1) {
        BottomDrawerState bottomDrawerState = new BottomDrawerState(bottomDrawerValue, function1);
        bottomDrawerState.setDensity$material_release(density);
        return bottomDrawerState;
    }

    public static final DrawerState rememberDrawerState(final DrawerValue drawerValue, final Function1<? super DrawerValue, Boolean> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1435874229);
        ComposerKt.sourceInformation(composer, "C(rememberDrawerState)P(1)449@15518L125:Drawer.kt#jmzs0o");
        if ((i2 & 2) != 0) {
            function1 = new Function1<DrawerValue, Boolean>() { // from class: androidx.compose.material.DrawerKt.rememberDrawerState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(DrawerValue drawerValue2) {
                    return true;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1435874229, i, -1, "androidx.compose.material.rememberDrawerState (Drawer.kt:448)");
        }
        Object[] objArr = new Object[0];
        Saver<DrawerState, DrawerValue> Saver = DrawerState.INSTANCE.Saver(function1);
        composer.startReplaceableGroup(1903586313);
        boolean zChanged = composer.changed(drawerValue) | composer.changedInstance(function1);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function0) new Function0<DrawerState>() { // from class: androidx.compose.material.DrawerKt$rememberDrawerState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DrawerState invoke() {
                    return new DrawerState(drawerValue, function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DrawerState drawerState = (DrawerState) RememberSaveableKt.m3983rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) objRememberedValue, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return drawerState;
    }

    public static final BottomDrawerState rememberBottomDrawerState(final BottomDrawerValue bottomDrawerValue, final Function1<? super BottomDrawerValue, Boolean> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-598115156);
        ComposerKt.sourceInformation(composer, "C(rememberBottomDrawerState)P(1)466@16084L7,467@16103L164:Drawer.kt#jmzs0o");
        if ((i2 & 2) != 0) {
            function1 = new Function1<BottomDrawerValue, Boolean>() { // from class: androidx.compose.material.DrawerKt.rememberBottomDrawerState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BottomDrawerValue bottomDrawerValue2) {
                    return true;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-598115156, i, -1, "androidx.compose.material.rememberBottomDrawerState (Drawer.kt:465)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) objConsume;
        Object[] objArr = {density};
        Saver<BottomDrawerState, BottomDrawerValue> Saver = BottomDrawerState.Companion.Saver(density, function1);
        composer.startReplaceableGroup(1903586922);
        boolean zChanged = composer.changed(bottomDrawerValue) | composer.changed(density) | composer.changedInstance(function1);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function0) new Function0<BottomDrawerState>() { // from class: androidx.compose.material.DrawerKt$rememberBottomDrawerState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final BottomDrawerState invoke() {
                    return DrawerKt.BottomDrawerState(bottomDrawerValue, density, function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        BottomDrawerState bottomDrawerState = (BottomDrawerState) RememberSaveableKt.m3983rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) objRememberedValue, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return bottomDrawerState;
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0117  */
    /* JADX WARN: Removed duplicated region for block: B:102:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:111:0x0139  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0196  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x0198  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x019d  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01cf  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01d4  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01f8  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0216  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:178:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0065  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006b  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006e  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c3  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0111  */
    /* renamed from: ModalDrawer-Gs3lGvM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1848ModalDrawerGs3lGvM(final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.ui.Modifier r34, androidx.compose.material.DrawerState r35, boolean r36, androidx.compose.ui.graphics.Shape r37, float r38, long r39, long r41, long r43, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, androidx.compose.runtime.Composer r46, final int r47, final int r48) {
        /*
            Method dump skipped, instructions count: 722
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt.m1848ModalDrawerGs3lGvM(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.DrawerState, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:102:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0181  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0183  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x019b  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b2  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b9  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0200  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x024d  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:171:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0074  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e6  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0105  */
    /* renamed from: BottomDrawer-Gs3lGvM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1846BottomDrawerGs3lGvM(final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r33, androidx.compose.ui.Modifier r34, androidx.compose.material.BottomDrawerState r35, boolean r36, androidx.compose.ui.graphics.Shape r37, float r38, long r39, long r41, long r43, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, androidx.compose.runtime.Composer r46, final int r47, final int r48) {
        /*
            Method dump skipped, instructions count: 735
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt.m1846BottomDrawerGs3lGvM(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.BottomDrawerState, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float calculateFraction(float f, float f2, float f3) {
        return RangesKt.coerceIn((f3 - f) / (f2 - f), 0.0f, 1.0f);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: BottomDrawerScrim-3J-VO9M, reason: not valid java name */
    public static final void m1847BottomDrawerScrim3JVO9M(final long j, final Function0<Unit> function0, final boolean z, Composer composer, final int i) {
        int i2;
        Modifier.Companion companionSemantics;
        Composer composerStartRestartGroup = composer.startRestartGroup(-513067266);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomDrawerScrim)P(0:c#ui.graphics.Color)793@29917L121,797@30065L30,811@30509L171:Drawer.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i2 & WinError.ERROR_WAIT_1) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-513067266, i2, -1, "androidx.compose.material.BottomDrawerScrim (Drawer.kt:791)");
            }
            if (j != Color.INSTANCE.m4574getUnspecified0d7_KjU()) {
                final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                final String strM1976getString4foXLRw = Strings_androidKt.m1976getString4foXLRw(Strings.INSTANCE.m1969getCloseDrawerUdPEhr4(), composerStartRestartGroup, 6);
                if (z) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(1903600934);
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(function0);
                    DrawerKt$BottomDrawerScrim$dismissModifier$1$1 drawerKt$BottomDrawerScrim$dismissModifier$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || drawerKt$BottomDrawerScrim$dismissModifier$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        drawerKt$BottomDrawerScrim$dismissModifier$1$1RememberedValue = new DrawerKt$BottomDrawerScrim$dismissModifier$1$1(function0, null);
                        composerStartRestartGroup.updateRememberedValue(drawerKt$BottomDrawerScrim$dismissModifier$1$1RememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    Modifier modifierThen = companion.then(new SuspendPointerInputElement(function0, null, null, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0((Function2) drawerKt$BottomDrawerScrim$dismissModifier$1$1RememberedValue), 6, null));
                    composerStartRestartGroup.startReplaceableGroup(1903601060);
                    boolean zChanged = composerStartRestartGroup.changed(strM1976getString4foXLRw) | composerStartRestartGroup.changedInstance(function0);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$dismissModifier$2$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                invoke2(semanticsPropertyReceiver);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                                SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, strM1976getString4foXLRw);
                                final Function0<Unit> function02 = function0;
                                SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$dismissModifier$2$1.1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(0);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Boolean invoke() {
                                        function02.invoke();
                                        return true;
                                    }
                                }, 1, null);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    companionSemantics = SemanticsModifierKt.semantics(modifierThen, true, (Function1) objRememberedValue);
                } else {
                    companionSemantics = Modifier.INSTANCE;
                }
                Modifier modifierThen2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(companionSemantics);
                composerStartRestartGroup.startReplaceableGroup(1903601349);
                boolean zChanged2 = composerStartRestartGroup.changed(j) | composerStartRestartGroup.changed(stateAnimateFloatAsState);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$1$1
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
                            DrawScope.m5111drawRectnJ9OG0$default(drawScope, j, 0L, 0L, DrawerKt.BottomDrawerScrim_3J_VO9M$lambda$3(stateAnimateFloatAsState), null, null, 0, 118, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierThen2, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$BottomDrawerScrim$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    DrawerKt.m1847BottomDrawerScrim3JVO9M(j, function0, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Scrim-Bx497Mc, reason: not valid java name */
    public static final void m1849ScrimBx497Mc(final boolean z, final Function0<Unit> function0, final Function0<Float> function02, final long j, Composer composer, final int i) {
        int i2;
        Modifier.Companion companionSemantics;
        Composer composerStartRestartGroup = composer.startRestartGroup(1983403750);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Scrim)P(3,2,1,0:c#ui.graphics.Color)828@30835L30,840@31188L142:Drawer.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function02) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 2048 : 1024;
        }
        if ((i2 & 5851) != 1170 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1983403750, i2, -1, "androidx.compose.material.Scrim (Drawer.kt:827)");
            }
            final String strM1976getString4foXLRw = Strings_androidKt.m1976getString4foXLRw(Strings.INSTANCE.m1969getCloseDrawerUdPEhr4(), composerStartRestartGroup, 6);
            if (z) {
                Modifier.Companion companion = Modifier.INSTANCE;
                composerStartRestartGroup.startReplaceableGroup(1903601685);
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(function0);
                DrawerKt$Scrim$dismissDrawer$1$1 drawerKt$Scrim$dismissDrawer$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || drawerKt$Scrim$dismissDrawer$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    drawerKt$Scrim$dismissDrawer$1$1RememberedValue = new DrawerKt$Scrim$dismissDrawer$1$1(function0, null);
                    composerStartRestartGroup.updateRememberedValue(drawerKt$Scrim$dismissDrawer$1$1RememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                Modifier modifierThen = companion.then(new SuspendPointerInputElement(function0, null, null, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0((Function2) drawerKt$Scrim$dismissDrawer$1$1RememberedValue), 6, null));
                composerStartRestartGroup.startReplaceableGroup(1903601769);
                boolean zChanged = composerStartRestartGroup.changed(strM1976getString4foXLRw) | composerStartRestartGroup.changedInstance(function0);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (Function1) new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$dismissDrawer$2$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            invoke2(semanticsPropertyReceiver);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(SemanticsPropertyReceiver semanticsPropertyReceiver) {
                            SemanticsPropertiesKt.setContentDescription(semanticsPropertyReceiver, strM1976getString4foXLRw);
                            final Function0<Unit> function03 = function0;
                            SemanticsPropertiesKt.onClick$default(semanticsPropertyReceiver, null, new Function0<Boolean>() { // from class: androidx.compose.material.DrawerKt$Scrim$dismissDrawer$2$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(0);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function0
                                public final Boolean invoke() {
                                    function03.invoke();
                                    return true;
                                }
                            }, 1, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                companionSemantics = SemanticsModifierKt.semantics(modifierThen, true, (Function1) objRememberedValue);
            } else {
                companionSemantics = Modifier.INSTANCE;
            }
            Modifier modifierThen2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(companionSemantics);
            composerStartRestartGroup.startReplaceableGroup(1903602010);
            boolean zChanged2 = composerStartRestartGroup.changed(j) | composerStartRestartGroup.changedInstance(function02);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$1$1
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
                        DrawScope.m5111drawRectnJ9OG0$default(drawScope, j, 0L, 0L, function02.invoke().floatValue(), null, null, 0, 118, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceableGroup();
            CanvasKt.Canvas(modifierThen2, (Function1) objRememberedValue2, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.DrawerKt$Scrim$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    DrawerKt.m1849ScrimBx497Mc(z, function0, function02, j, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* compiled from: Drawer.kt */
    @Metadata(d1 = {"\u00001\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\n\u0010\u000bJ*\u0010\f\u001a\u00020\r2\u0006\u0010\b\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0010\u0010\u0011J\u001b\u0010\u0012\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0013\u0010\u0014J\"\u0010\u0015\u001a\u00020\r2\u0006\u0010\t\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0018\u001a\u00020\u0019*\u00020\rH\u0003¢\u0006\u0004\b\u001a\u0010\u001bJ\u0013\u0010\u0018\u001a\u00020\u0019*\u00020\u0007H\u0003¢\u0006\u0004\b\u001c\u0010\u001bJ\u0017\u0010\u001d\u001a\u00020\r*\u00020\u0019H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001f"}, d2 = {"androidx/compose/material/DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", SdkConstants.ATTR_ORIENTATION, "Landroidx/compose/foundation/gestures/Orientation;", "getOrientation", "()Landroidx/compose/foundation/gestures/Orientation;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "toFloat", "", "offsetToFloat", "(J)F", "velocityToFloat", "toOffset", "(F)J", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1, reason: invalid class name and case insensitive filesystem */
    public static final class C05121 implements NestedScrollConnection {
        final /* synthetic */ AnchoredDraggableState<?> $state;
        private final Orientation orientation = Orientation.Vertical;

        C05121(AnchoredDraggableState<?> anchoredDraggableState) {
            this.$state = anchoredDraggableState;
        }

        public final Orientation getOrientation() {
            return this.orientation;
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* renamed from: onPreScroll-OzD1aCk */
        public long mo1061onPreScrollOzD1aCk(long available, int source) {
            float fOffsetToFloat = offsetToFloat(available);
            if (fOffsetToFloat < 0.0f && NestedScrollSource.m5709equalsimpl0(source, NestedScrollSource.INSTANCE.m5717getDragWNlRxjI())) {
                return toOffset(this.$state.dispatchRawDelta(fOffsetToFloat));
            }
            return Offset.INSTANCE.m4310getZeroF1C5BW0();
        }

        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* renamed from: onPostScroll-DzOQY0M */
        public long mo787onPostScrollDzOQY0M(long consumed, long available, int source) {
            if (NestedScrollSource.m5709equalsimpl0(source, NestedScrollSource.INSTANCE.m5717getDragWNlRxjI())) {
                return toOffset(this.$state.dispatchRawDelta(offsetToFloat(available)));
            }
            return Offset.INSTANCE.m4310getZeroF1C5BW0();
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* renamed from: onPreFling-QWom1Mo */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object mo1060onPreFlingQWom1Mo(long r6, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r8) {
            /*
                r5 = this;
                boolean r0 = r8 instanceof androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1
                if (r0 == 0) goto L14
                r0 = r8
                androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = (androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r8 = r0.label
                int r8 = r8 - r2
                r0.label = r8
                goto L19
            L14:
                androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = new androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1
                r0.<init>(r5, r8)
            L19:
                java.lang.Object r8 = r0.result
                java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r2 = r0.label
                r3 = 1
                if (r2 == 0) goto L34
                if (r2 != r3) goto L2c
                long r6 = r0.J$0
                kotlin.ResultKt.throwOnFailure(r8)
                goto L67
            L2c:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r7)
                throw r6
            L34:
                kotlin.ResultKt.throwOnFailure(r8)
                float r8 = r5.velocityToFloat(r6)
                androidx.compose.material.AnchoredDraggableState<?> r2 = r5.$state
                float r2 = r2.requireOffset()
                r4 = 0
                int r4 = (r8 > r4 ? 1 : (r8 == r4 ? 0 : -1))
                if (r4 >= 0) goto L61
                androidx.compose.material.AnchoredDraggableState<?> r4 = r5.$state
                androidx.compose.material.DraggableAnchors r4 = r4.getAnchors()
                float r4 = r4.minAnchor()
                int r2 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
                if (r2 <= 0) goto L61
                androidx.compose.material.AnchoredDraggableState<?> r2 = r5.$state
                r0.J$0 = r6
                r0.label = r3
                java.lang.Object r8 = r2.settle(r8, r0)
                if (r8 != r1) goto L67
                return r1
            L61:
                androidx.compose.ui.unit.Velocity$Companion r6 = androidx.compose.ui.unit.Velocity.INSTANCE
                long r6 = r6.m7504getZero9UxMQ8M()
            L67:
                androidx.compose.ui.unit.Velocity r6 = androidx.compose.ui.unit.Velocity.m7484boximpl(r6)
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt.C05121.mo1060onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
        }

        /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
        @Override // androidx.compose.ui.input.nestedscroll.NestedScrollConnection
        /* renamed from: onPostFling-RZ2iAVY */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public java.lang.Object mo786onPostFlingRZ2iAVY(long r3, long r5, kotlin.coroutines.Continuation<? super androidx.compose.ui.unit.Velocity> r7) {
            /*
                r2 = this;
                boolean r3 = r7 instanceof androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1
                if (r3 == 0) goto L14
                r3 = r7
                androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r3 = (androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) r3
                int r4 = r3.label
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                r4 = r4 & r0
                if (r4 == 0) goto L14
                int r4 = r3.label
                int r4 = r4 - r0
                r3.label = r4
                goto L19
            L14:
                androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r3 = new androidx.compose.material.DrawerKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1
                r3.<init>(r2, r7)
            L19:
                java.lang.Object r4 = r3.result
                java.lang.Object r7 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r0 = r3.label
                r1 = 1
                if (r0 == 0) goto L34
                if (r0 != r1) goto L2c
                long r5 = r3.J$0
                kotlin.ResultKt.throwOnFailure(r4)
                goto L48
            L2c:
                java.lang.IllegalStateException r3 = new java.lang.IllegalStateException
                java.lang.String r4 = "call to 'resume' before 'invoke' with coroutine"
                r3.<init>(r4)
                throw r3
            L34:
                kotlin.ResultKt.throwOnFailure(r4)
                androidx.compose.material.AnchoredDraggableState<?> r4 = r2.$state
                float r0 = r2.velocityToFloat(r5)
                r3.J$0 = r5
                r3.label = r1
                java.lang.Object r3 = r4.settle(r0, r3)
                if (r3 != r7) goto L48
                return r7
            L48:
                androidx.compose.ui.unit.Velocity r3 = androidx.compose.ui.unit.Velocity.m7484boximpl(r5)
                return r3
            */
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.DrawerKt.C05121.mo786onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
        }

        private final long toOffset(float f) {
            float f2 = this.orientation == Orientation.Horizontal ? f : 0.0f;
            if (this.orientation != Orientation.Vertical) {
                f = 0.0f;
            }
            return OffsetKt.Offset(f2, f);
        }

        private final float velocityToFloat(long j) {
            return this.orientation == Orientation.Horizontal ? Velocity.m7493getXimpl(j) : Velocity.m7494getYimpl(j);
        }

        private final float offsetToFloat(long j) {
            return this.orientation == Orientation.Horizontal ? Offset.m4294getXimpl(j) : Offset.m4295getYimpl(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> anchoredDraggableState) {
        return new C05121(anchoredDraggableState);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float BottomDrawerScrim_3J_VO9M$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    static {
        float f = 56;
        EndDrawerPadding = Dp.m7255constructorimpl(f);
        DrawerPositionalThreshold = Dp.m7255constructorimpl(f);
    }
}
