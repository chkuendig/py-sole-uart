package androidx.compose.material;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.gestures.Orientation;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.input.nestedscroll.NestedScrollConnection;
import androidx.compose.ui.input.nestedscroll.NestedScrollSource;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.Velocity;
import com.android.SdkConstants;
import com.facebook.internal.ServerProtocol;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: BottomSheetScaffold.kt */
@Metadata(d1 = {"\u0000Â\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u0093\u0001\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2'\u0010\r\u001a#\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(\u0012\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00140\u00130\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\u001c\u0010\u001d\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001f¢\u0006\u0002\b H\u0003ø\u0001\u0000¢\u0006\u0004\b!\u0010\"\u001aÞ\u0002\u0010#\u001a\u00020\b2\u001c\u0010$\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001f¢\u0006\u0002\b 2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010%\u001a\u00020&2\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010(¢\u0006\u0002\b\u001f2\u0019\b\u0002\u0010)\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001f2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010(¢\u0006\u0002\b\u001f2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010.\u001a\u00020\u00012 \b\u0002\u0010/\u001a\u001a\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\b\u0018\u00010\u000e¢\u0006\u0002\b\u001f¢\u0006\u0002\b 2\b\b\u0002\u00100\u001a\u00020\f2\b\b\u0002\u00101\u001a\u00020\u00162\b\b\u0002\u00102\u001a\u00020\u00012\b\b\u0002\u00103\u001a\u00020\u00192\b\b\u0002\u00104\u001a\u00020\u00192\b\b\u0002\u00105\u001a\u00020\u00192\b\b\u0002\u00106\u001a\u00020\u00192\b\b\u0002\u00107\u001a\u00020\u00192\u0017\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001fH\u0007ø\u0001\u0000¢\u0006\u0004\b9\u0010:\u001a\u0080\u0002\u0010#\u001a\u00020\b2\u001c\u0010$\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001f¢\u0006\u0002\b 2\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\b\b\u0002\u0010%\u001a\u00020&2\u0015\b\u0002\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010(¢\u0006\u0002\b\u001f2\u0019\b\u0002\u0010)\u001a\u0013\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001f2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010(¢\u0006\u0002\b\u001f2\b\b\u0002\u0010,\u001a\u00020-2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\u0017\u001a\u00020\u00012\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010.\u001a\u00020\u00012\b\b\u0002\u00106\u001a\u00020\u00192\b\b\u0002\u00107\u001a\u00020\u00192\u0017\u0010\u001d\u001a\u0013\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001fH\u0007ø\u0001\u0000¢\u0006\u0004\b;\u0010<\u001aÅ\u0001\u0010=\u001a\u00020\b2\u0013\u0010'\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010(¢\u0006\u0002\b\u001f2&\u0010>\u001a\"\u0012\u0013\u0012\u001108¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(?\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001f2&\u0010@\u001a\"\u0012\u0013\u0012\u00110A¢\u0006\f\b\u0010\u0012\b\b\u0011\u0012\u0004\b\b(B\u0012\u0004\u0012\u00020\b0\u000e¢\u0006\u0002\b\u001f2\u0013\u0010+\u001a\u000f\u0012\u0004\u0012\u00020\b\u0018\u00010(¢\u0006\u0002\b\u001f2\u0011\u0010)\u001a\r\u0012\u0004\u0012\u00020\b0(¢\u0006\u0002\b\u001f2\u0006\u0010.\u001a\u00020\u00012\u0006\u0010,\u001a\u00020-2\f\u0010C\u001a\b\u0012\u0004\u0012\u00020D0(2\u0006\u0010E\u001a\u00020\nH\u0003ø\u0001\u0000¢\u0006\u0004\bF\u0010G\u001a4\u0010H\u001a\u00020\n2\u0006\u0010I\u001a\u00020\u00142\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020D0K2\u0012\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0\u000eH\u0007\u001a \u0010H\u001a\u00020&2\u0006\u0010M\u001a\u00020N2\u0006\u0010O\u001a\u00020\n2\u0006\u0010P\u001a\u00020*H\u0007\u001a>\u0010Q\u001a\u00020\n2\u0006\u0010I\u001a\u00020\u00142\u0006\u0010R\u001a\u00020S2\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020D0K2\u0014\b\u0002\u0010T\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0\u000eH\u0007\u001a\u001c\u0010U\u001a\u00020V2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030W2\u0006\u0010X\u001a\u00020YH\u0002\u001a!\u0010Z\u001a\u00020&2\b\b\u0002\u0010O\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020*H\u0007¢\u0006\u0002\u0010[\u001a+\u0010Z\u001a\u00020&2\b\b\u0002\u0010M\u001a\u00020N2\b\b\u0002\u0010O\u001a\u00020\n2\b\b\u0002\u0010P\u001a\u00020*H\u0007¢\u0006\u0002\u0010\\\u001a;\u0010]\u001a\u00020\n2\u0006\u0010I\u001a\u00020\u00142\u000e\b\u0002\u0010J\u001a\b\u0012\u0004\u0012\u00020D0K2\u0014\b\u0002\u0010L\u001a\u000e\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\f0\u000eH\u0007¢\u0006\u0002\u0010^\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0006\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006_"}, d2 = {"BottomSheetScaffoldPositionalThreshold", "Landroidx/compose/ui/unit/Dp;", "F", "BottomSheetScaffoldVelocityThreshold", "BottomSheetScaffoldWithDrawerDeprecated", "", "FabSpacing", "BottomSheet", "", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/material/BottomSheetState;", "sheetGesturesEnabled", "", "calculateAnchors", "Lkotlin/Function1;", "Landroidx/compose/ui/unit/IntSize;", "Lkotlin/ParameterName;", "name", "sheetSize", "Landroidx/compose/material/DraggableAnchors;", "Landroidx/compose/material/BottomSheetValue;", "sheetShape", "Landroidx/compose/ui/graphics/Shape;", "sheetElevation", "sheetBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "sheetContentColor", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BottomSheet-0cLKjW4", "(Landroidx/compose/material/BottomSheetState;ZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/graphics/Shape;FJJLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomSheetScaffold", "sheetContent", "scaffoldState", "Landroidx/compose/material/BottomSheetScaffoldState;", "topBar", "Lkotlin/Function0;", "snackbarHost", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "Landroidx/compose/material/FabPosition;", "sheetPeekHeight", "drawerContent", "drawerGesturesEnabled", "drawerShape", "drawerElevation", "drawerBackgroundColor", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "Landroidx/compose/foundation/layout/PaddingValues;", "BottomSheetScaffold-bGncdBI", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomSheetScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLandroidx/compose/ui/graphics/Shape;FJJFLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;IIII)V", "BottomSheetScaffold-HnlDQGw", "(Lkotlin/jvm/functions/Function3;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BottomSheetScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLandroidx/compose/ui/graphics/Shape;FJJFJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BottomSheetScaffoldLayout", "body", "innerPadding", "bottomSheet", "", "layoutHeight", "sheetOffset", "", "sheetState", "BottomSheetScaffoldLayout-KCBPh4w", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FILkotlin/jvm/functions/Function0;Landroidx/compose/material/BottomSheetState;Landroidx/compose/runtime/Composer;I)V", "BottomSheetScaffoldState", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "drawerState", "Landroidx/compose/material/DrawerState;", "bottomSheetState", "snackbarHostState", "BottomSheetState", "density", "Landroidx/compose/ui/unit/Density;", "confirmValueChange", "ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "Landroidx/compose/material/AnchoredDraggableState;", SdkConstants.ATTR_ORIENTATION, "Landroidx/compose/foundation/gestures/Orientation;", "rememberBottomSheetScaffoldState", "(Landroidx/compose/material/BottomSheetState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetScaffoldState;", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/BottomSheetState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetScaffoldState;", "rememberBottomSheetState", "(Landroidx/compose/material/BottomSheetValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BottomSheetState;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BottomSheetScaffoldKt {
    private static final String BottomSheetScaffoldWithDrawerDeprecated = "BottomSheetScaffold with a drawer has been deprecated. To achieve the same functionality, wrap your BottomSheetScaffold in aModalDrawer. See BottomSheetScaffoldWithDrawerSample for more details.";
    private static final float FabSpacing = Dp.m7255constructorimpl(16);
    private static final float BottomSheetScaffoldPositionalThreshold = Dp.m7255constructorimpl(56);
    private static final float BottomSheetScaffoldVelocityThreshold = Dp.m7255constructorimpl(125);

    public static /* synthetic */ BottomSheetState BottomSheetScaffoldState$default(BottomSheetValue bottomSheetValue, AnimationSpec animationSpec, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            animationSpec = AnchoredDraggableDefaults.INSTANCE.getAnimationSpec();
        }
        return BottomSheetScaffoldState(bottomSheetValue, (AnimationSpec<Float>) animationSpec, (Function1<? super BottomSheetValue, Boolean>) function1);
    }

    @Deprecated(message = "This constructor is deprecated. confirmStateChange has been renamed to confirmValueChange.", replaceWith = @ReplaceWith(expression = "BottomSheetScaffoldState(initialValue, animationSpec, confirmStateChange)", imports = {}))
    public static final BottomSheetState BottomSheetScaffoldState(BottomSheetValue bottomSheetValue, AnimationSpec<Float> animationSpec, Function1<? super BottomSheetValue, Boolean> function1) {
        return new BottomSheetState(bottomSheetValue, animationSpec, function1);
    }

    public static /* synthetic */ BottomSheetState BottomSheetState$default(BottomSheetValue bottomSheetValue, Density density, AnimationSpec animationSpec, Function1 function1, int i, Object obj) {
        if ((i & 4) != 0) {
            animationSpec = AnchoredDraggableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i & 8) != 0) {
            function1 = new Function1<BottomSheetValue, Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt.BottomSheetState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BottomSheetValue bottomSheetValue2) {
                    return true;
                }
            };
        }
        return BottomSheetState(bottomSheetValue, density, animationSpec, function1);
    }

    public static final BottomSheetState BottomSheetState(BottomSheetValue bottomSheetValue, Density density, AnimationSpec<Float> animationSpec, Function1<? super BottomSheetValue, Boolean> function1) {
        BottomSheetState bottomSheetState = new BottomSheetState(bottomSheetValue, animationSpec, function1);
        bottomSheetState.setDensity$material_release(density);
        return bottomSheetState;
    }

    public static final BottomSheetState rememberBottomSheetState(final BottomSheetValue bottomSheetValue, final AnimationSpec<Float> animationSpec, final Function1<? super BottomSheetValue, Boolean> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1808153344);
        ComposerKt.sourceInformation(composer, "C(rememberBottomSheetState)P(2)306@11010L7,307@11029L433:BottomSheetScaffold.kt#jmzs0o");
        if ((i2 & 2) != 0) {
            animationSpec = AnchoredDraggableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i2 & 4) != 0) {
            function1 = new Function1<BottomSheetValue, Boolean>() { // from class: androidx.compose.material.BottomSheetScaffoldKt.rememberBottomSheetState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BottomSheetValue bottomSheetValue2) {
                    return true;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1808153344, i, -1, "androidx.compose.material.rememberBottomSheetState (BottomSheetScaffold.kt:305)");
        }
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        final Density density = (Density) objConsume;
        BottomSheetState bottomSheetState = (BottomSheetState) RememberSaveableKt.m3983rememberSaveable(new Object[]{animationSpec}, (Saver) BottomSheetState.INSTANCE.Saver(animationSpec, function1, density), (String) null, (Function0) new Function0<BottomSheetState>() { // from class: androidx.compose.material.BottomSheetScaffoldKt.rememberBottomSheetState.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BottomSheetState invoke() {
                return BottomSheetScaffoldKt.BottomSheetState(bottomSheetValue, density, animationSpec, function1);
            }
        }, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return bottomSheetState;
    }

    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(BottomSheetState bottomSheetState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1022285988);
        ComposerKt.sourceInformation(composer, "C(rememberBottomSheetScaffoldState)346@12196L35,347@12276L32,349@12350L196:BottomSheetScaffold.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            bottomSheetState = rememberBottomSheetState(BottomSheetValue.Collapsed, null, null, composer, 6, 6);
        }
        if ((i2 & 2) != 0) {
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
            snackbarHostState = (SnackbarHostState) objRememberedValue;
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1022285988, i, -1, "androidx.compose.material.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:348)");
        }
        composer.startReplaceableGroup(511388516);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2):Composables.kt#9igjgp");
        boolean zChanged = composer.changed(bottomSheetState) | composer.changed(snackbarHostState);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new BottomSheetScaffoldState(bottomSheetState, snackbarHostState);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        BottomSheetScaffoldState bottomSheetScaffoldState = (BottomSheetScaffoldState) objRememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return bottomSheetScaffoldState;
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = BottomSheetScaffoldWithDrawerDeprecated)
    public static final BottomSheetScaffoldState BottomSheetScaffoldState(DrawerState drawerState, BottomSheetState bottomSheetState, SnackbarHostState snackbarHostState) {
        throw new IllegalStateException(BottomSheetScaffoldWithDrawerDeprecated.toString());
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = BottomSheetScaffoldWithDrawerDeprecated)
    public static final BottomSheetScaffoldState rememberBottomSheetScaffoldState(DrawerState drawerState, BottomSheetState bottomSheetState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1353009744);
        ComposerKt.sourceInformation(composer, "C(rememberBottomSheetScaffoldState)P(1)385@13723L39,386@13805L35,387@13885L32:BottomSheetScaffold.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            DrawerKt.rememberDrawerState(DrawerValue.Closed, null, composer, 6, 2);
        }
        if ((i2 & 2) != 0) {
            rememberBottomSheetState(BottomSheetValue.Collapsed, null, null, composer, 6, 6);
        }
        if ((i2 & 4) != 0) {
            composer.startReplaceableGroup(-492369756);
            ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composer.updateRememberedValue(objRememberedValue);
            }
            composer.endReplaceableGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1353009744, i, -1, "androidx.compose.material.rememberBottomSheetScaffoldState (BottomSheetScaffold.kt:388)");
        }
        throw new IllegalStateException(BottomSheetScaffoldWithDrawerDeprecated.toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0166  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0184  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c1  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01d3  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x01fe  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x022c  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x0280  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x0282  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x0298  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02b5  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02d1  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02d5  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02f1  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x030d  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0351  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0422  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:266:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bb  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0130  */
    /* renamed from: BottomSheetScaffold-HnlDQGw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1756BottomSheetScaffoldHnlDQGw(final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.ui.Modifier r39, androidx.compose.material.BottomSheetScaffoldState r40, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, int r44, boolean r45, androidx.compose.ui.graphics.Shape r46, float r47, long r48, long r50, float r52, long r53, long r55, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r57, androidx.compose.runtime.Composer r58, final int r59, final int r60, final int r61) {
        /*
            Method dump skipped, instructions count: 1118
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.m1756BottomSheetScaffoldHnlDQGw(kotlin.jvm.functions.Function3, androidx.compose.ui.Modifier, androidx.compose.material.BottomSheetScaffoldState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, int, boolean, androidx.compose.ui.graphics.Shape, float, long, long, float, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    @Deprecated(level = DeprecationLevel.ERROR, message = BottomSheetScaffoldWithDrawerDeprecated)
    /* renamed from: BottomSheetScaffold-bGncdBI, reason: not valid java name */
    public static final void m1757BottomSheetScaffoldbGncdBI(final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, final Modifier modifier, final BottomSheetScaffoldState bottomSheetScaffoldState, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super SnackbarHostState, ? super Composer, ? super Integer, Unit> function32, final Function2<? super Composer, ? super Integer, Unit> function22, final int i, final boolean z, final Shape shape, final float f, final long j, final long j2, final float f2, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function33, final boolean z2, final Shape shape2, final float f3, final long j3, final long j4, final long j5, final long j6, final long j7, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function34, Composer composer, final int i2, final int i3, final int i4, final int i5) {
        long jM1803getSurface0d7_KjU;
        int i6;
        int i7;
        int i8;
        long jM1803getSurface0d7_KjU2;
        long jM1792getBackground0d7_KjU;
        Composer composerStartRestartGroup = composer.startRestartGroup(46422755);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomSheetScaffold)P(15,12,13,22,21,10,11:c#material.FabPosition,18,20,17:c#ui.unit.Dp,14:c#ui.graphics.Color,16:c#ui.graphics.Color,19:c#ui.unit.Dp,4,7,9,6:c#ui.unit.Dp,3:c#ui.graphics.Color,5:c#ui.graphics.Color,8:c#ui.graphics.Color,0:c#ui.graphics.Color,2:c#ui.graphics.Color)574@24388L34,580@24757L6,582@24888L6,583@24935L37,587@25192L6,589@25307L6,590@25355L38,591@25440L10,592@25495L6,593@25540L32:BottomSheetScaffold.kt#jmzs0o");
        if ((i3 & 14) == 0) {
            jM1803getSurface0d7_KjU = j;
            i6 = i3 | (((i5 & 1024) == 0 && composerStartRestartGroup.changed(jM1803getSurface0d7_KjU)) ? 4 : 2);
        } else {
            jM1803getSurface0d7_KjU = j;
            i6 = i3;
        }
        if ((i3 & 29360128) == 0) {
            i6 |= ((i5 & 131072) == 0 && composerStartRestartGroup.changed(j3)) ? 8388608 : 4194304;
        }
        if ((i4 & 14) == 0) {
            i7 = i4 | (((i5 & 1048576) == 0 && composerStartRestartGroup.changed(j6)) ? 4 : 2);
        } else {
            i7 = i4;
        }
        int i9 = i2 & 1;
        if (i9 != 0 || (20971531 & i6) != 4194306 || (i7 & 11) != 2 || !composerStartRestartGroup.getSkipping()) {
            composerStartRestartGroup.startDefaults();
            if (i9 == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                i8 = i2;
                if ((i5 & 2) != 0) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                }
                if ((i5 & 4) != 0) {
                    rememberBottomSheetScaffoldState(null, null, composerStartRestartGroup, 0, 3);
                    i8 &= -897;
                }
                if ((i5 & 16) != 0) {
                    ComposableSingletons$BottomSheetScaffoldKt.INSTANCE.m1826getLambda2$material_release();
                }
                if ((i5 & 64) != 0) {
                    FabPosition.INSTANCE.m1876getEnd5ygKITE();
                }
                if ((i5 & 256) != 0) {
                    MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i8 &= -234881025;
                }
                if ((i5 & 512) != 0) {
                    BottomSheetScaffoldDefaults.INSTANCE.m1753getSheetElevationD9Ej5fM();
                }
                if ((i5 & 1024) != 0) {
                    jM1803getSurface0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1803getSurface0d7_KjU();
                    i6 &= -15;
                }
                if ((i5 & 2048) != 0) {
                    ColorsKt.m1817contentColorForek8zF_U(jM1803getSurface0d7_KjU, composerStartRestartGroup, i6 & 14);
                    i6 &= -113;
                }
                if ((i5 & 4096) != 0) {
                    BottomSheetScaffoldDefaults.INSTANCE.m1754getSheetPeekHeightD9Ej5fM();
                }
                if ((i5 & 32768) != 0) {
                    MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getLarge();
                    i6 &= -458753;
                }
                if ((65536 & i5) != 0) {
                    DrawerDefaults.INSTANCE.m1845getElevationD9Ej5fM();
                }
                if ((i5 & 131072) != 0) {
                    jM1803getSurface0d7_KjU2 = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1803getSurface0d7_KjU();
                    i6 &= -29360129;
                } else {
                    jM1803getSurface0d7_KjU2 = j3;
                }
                if ((i5 & 262144) != 0) {
                    ColorsKt.m1817contentColorForek8zF_U(jM1803getSurface0d7_KjU2, composerStartRestartGroup, (i6 >> 21) & 14);
                    i6 &= -234881025;
                }
                if ((524288 & i5) != 0) {
                    DrawerDefaults.INSTANCE.getScrimColor(composerStartRestartGroup, 6);
                    i6 = (-1879048193) & i6;
                }
                if ((1048576 & i5) != 0) {
                    jM1792getBackground0d7_KjU = MaterialTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m1792getBackground0d7_KjU();
                    i7 &= -15;
                } else {
                    jM1792getBackground0d7_KjU = j6;
                }
                if ((2097152 & i5) != 0) {
                    ColorsKt.m1817contentColorForek8zF_U(jM1792getBackground0d7_KjU, composerStartRestartGroup, i7 & 14);
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                i8 = (i5 & 4) != 0 ? i2 & (-897) : i2;
                if ((i5 & 256) != 0) {
                    i8 &= -234881025;
                }
                if ((i5 & 1024) != 0) {
                    i6 &= -15;
                }
                if ((i5 & 2048) != 0) {
                    i6 &= -113;
                }
                if ((i5 & 32768) != 0) {
                    i6 &= -458753;
                }
                if ((i5 & 131072) != 0) {
                    i6 &= -29360129;
                }
                if ((i5 & 262144) != 0) {
                    i6 &= -234881025;
                }
                if ((i5 & 524288) != 0) {
                    i6 &= -1879048193;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(46422755, i8, i6, "androidx.compose.material.BottomSheetScaffold (BottomSheetScaffold.kt:595)");
            }
            throw new IllegalStateException(BottomSheetScaffoldWithDrawerDeprecated.toString());
        }
        composerStartRestartGroup.skipToGroupEnd();
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffold$4
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i10) {
                    BottomSheetScaffoldKt.m1757BottomSheetScaffoldbGncdBI(function3, modifier, bottomSheetScaffoldState, function2, function32, function22, i, z, shape, f, j, j2, f2, function33, z2, shape2, f3, j3, j4, j5, j6, j7, function34, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), RecomposeScopeImplKt.updateChangedFlags(i3), RecomposeScopeImplKt.updateChangedFlags(i4), i5);
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:102:0x0128  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x012a  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x0162  */
    /* JADX WARN: Removed duplicated region for block: B:115:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:122:0x021d  */
    /* JADX WARN: Removed duplicated region for block: B:124:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0082  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c0  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011a  */
    /* renamed from: BottomSheet-0cLKjW4, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1755BottomSheet0cLKjW4(final androidx.compose.material.BottomSheetState r26, final boolean r27, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.unit.IntSize, ? extends androidx.compose.material.DraggableAnchors<androidx.compose.material.BottomSheetValue>> r28, final androidx.compose.ui.graphics.Shape r29, final float r30, final long r31, final long r33, androidx.compose.ui.Modifier r35, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, androidx.compose.runtime.Composer r37, final int r38, final int r39) {
        /*
            Method dump skipped, instructions count: 577
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.m1755BottomSheet0cLKjW4(androidx.compose.material.BottomSheetState, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.graphics.Shape, float, long, long, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: BottomSheetScaffoldLayout-KCBPh4w, reason: not valid java name */
    public static final void m1758BottomSheetScaffoldLayoutKCBPh4w(final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function3<? super Integer, ? super Composer, ? super Integer, Unit> function32, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final float f, final int i, final Function0<Float> function0, final BottomSheetState bottomSheetState, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1621720523);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomSheetScaffoldLayout)P(8!3,7,5:c#ui.unit.Dp,3:c#material.FabPosition)687@28825L3007:BottomSheetScaffold.kt#jmzs0o");
        if ((i2 & 14) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function32) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function22) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function23) ? 16384 : 8192;
        }
        if ((458752 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(f) ? 131072 : 65536;
        }
        if ((3670016 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 1048576 : 524288;
        }
        if ((29360128 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 8388608 : 4194304;
        }
        if ((234881024 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(bottomSheetState) ? 67108864 : 33554432;
        }
        if ((191739611 & i3) != 38347922 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1621720523, i3, -1, "androidx.compose.material.BottomSheetScaffoldLayout (BottomSheetScaffold.kt:686)");
            }
            composerStartRestartGroup.startReplaceableGroup(750846060);
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(function32) | composerStartRestartGroup.changedInstance(function2) | composerStartRestartGroup.changedInstance(function3) | composerStartRestartGroup.changed(f) | composerStartRestartGroup.changedInstance(function22) | composerStartRestartGroup.changedInstance(function23) | composerStartRestartGroup.changedInstance(function0) | composerStartRestartGroup.changed(i) | composerStartRestartGroup.changed(bottomSheetState);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                composer2 = composerStartRestartGroup;
                objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1763invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* JADX WARN: Removed duplicated region for block: B:27:0x00c4  */
                    /* JADX WARN: Removed duplicated region for block: B:53:0x0182  */
                    /* JADX WARN: Removed duplicated region for block: B:69:0x01bf  */
                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final androidx.compose.ui.layout.MeasureResult m1763invoke0kLqBqw(final androidx.compose.ui.layout.SubcomposeMeasureScope r29, long r30) {
                        /*
                            Method dump skipped, instructions count: 674
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$1$1.m1763invoke0kLqBqw(androidx.compose.ui.layout.SubcomposeMeasureScope, long):androidx.compose.ui.layout.MeasureResult");
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            } else {
                composer2 = composerStartRestartGroup;
            }
            composer2.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(null, (Function2) objRememberedValue, composer2, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomSheetScaffoldKt$BottomSheetScaffoldLayout$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    BottomSheetScaffoldKt.m1758BottomSheetScaffoldLayoutKCBPh4w(function2, function3, function32, function22, function23, f, i, function0, bottomSheetState, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* compiled from: BottomSheetScaffold.kt */
    @Metadata(d1 = {"\u0000)\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0007\n\u0002\b\u0006*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J#\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\b\u001a\u00020\t2\u0006\u0010\u0004\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\f\u0010\rJ\u001b\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0003H\u0096@ø\u0001\u0000¢\u0006\u0004\b\u000f\u0010\u0010J\"\u0010\u0011\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0016ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u0013\u0010\u0014\u001a\u00020\u0015*\u00020\tH\u0003¢\u0006\u0004\b\u0016\u0010\u0017J\u0013\u0010\u0014\u001a\u00020\u0015*\u00020\u0003H\u0003¢\u0006\u0004\b\u0018\u0010\u0017J\u0017\u0010\u0019\u001a\u00020\t*\u00020\u0015H\u0002ø\u0001\u0001ø\u0001\u0000¢\u0006\u0002\u0010\u001a\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u001b"}, d2 = {"androidx/compose/material/BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1", "Landroidx/compose/ui/input/nestedscroll/NestedScrollConnection;", "onPostFling", "Landroidx/compose/ui/unit/Velocity;", "consumed", "available", "onPostFling-RZ2iAVY", "(JJLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPostScroll", "Landroidx/compose/ui/geometry/Offset;", "source", "Landroidx/compose/ui/input/nestedscroll/NestedScrollSource;", "onPostScroll-DzOQY0M", "(JJI)J", "onPreFling", "onPreFling-QWom1Mo", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onPreScroll", "onPreScroll-OzD1aCk", "(JI)J", "toFloat", "", "offsetToFloat", "(J)F", "velocityToFloat", "toOffset", "(F)J", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
    /* renamed from: androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1, reason: invalid class name and case insensitive filesystem */
    public static final class C05061 implements NestedScrollConnection {
        final /* synthetic */ Orientation $orientation;
        final /* synthetic */ AnchoredDraggableState<?> $state;

        C05061(AnchoredDraggableState<?> anchoredDraggableState, Orientation orientation) {
            this.$state = anchoredDraggableState;
            this.$orientation = orientation;
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
                boolean r0 = r8 instanceof androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1
                if (r0 == 0) goto L14
                r0 = r8
                androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = (androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1) r0
                int r1 = r0.label
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r1 = r1 & r2
                if (r1 == 0) goto L14
                int r8 = r0.label
                int r8 = r8 - r2
                r0.label = r8
                goto L19
            L14:
                androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1 r0 = new androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPreFling$1
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
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.C05061.mo1060onPreFlingQWom1Mo(long, kotlin.coroutines.Continuation):java.lang.Object");
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
                boolean r3 = r7 instanceof androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1
                if (r3 == 0) goto L14
                r3 = r7
                androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r3 = (androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1) r3
                int r4 = r3.label
                r0 = -2147483648(0xffffffff80000000, float:-0.0)
                r4 = r4 & r0
                if (r4 == 0) goto L14
                int r4 = r3.label
                int r4 = r4 - r0
                r3.label = r4
                goto L19
            L14:
                androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1 r3 = new androidx.compose.material.BottomSheetScaffoldKt$ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection$1$onPostFling$1
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
            throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomSheetScaffoldKt.C05061.mo786onPostFlingRZ2iAVY(long, long, kotlin.coroutines.Continuation):java.lang.Object");
        }

        private final long toOffset(float f) {
            float f2 = this.$orientation == Orientation.Horizontal ? f : 0.0f;
            if (this.$orientation != Orientation.Vertical) {
                f = 0.0f;
            }
            return OffsetKt.Offset(f2, f);
        }

        private final float velocityToFloat(long j) {
            return this.$orientation == Orientation.Horizontal ? Velocity.m7493getXimpl(j) : Velocity.m7494getYimpl(j);
        }

        private final float offsetToFloat(long j) {
            return this.$orientation == Orientation.Horizontal ? Offset.m4294getXimpl(j) : Offset.m4295getYimpl(j);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NestedScrollConnection ConsumeSwipeWithinBottomSheetBoundsNestedScrollConnection(AnchoredDraggableState<?> anchoredDraggableState, Orientation orientation) {
        return new C05061(anchoredDraggableState, orientation);
    }
}
