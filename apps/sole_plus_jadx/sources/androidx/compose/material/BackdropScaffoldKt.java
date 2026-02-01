package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.CanvasKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.CompositingStrategy;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScopeKt;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.TransformOrigin;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.input.pointer.SuspendPointerInputElement;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.android.SdkConstants;
import com.sun.jna.platform.win32.WinError;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* compiled from: BackdropScaffold.kt */
@Metadata(d1 = {"\u0000r\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a;\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\n\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\tH\u0003¢\u0006\u0002\u0010\u000b\u001aò\u0001\u0010\f\u001a\u00020\u00042\u0011\u0010\u0007\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\r\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\u0011\u0010\u000e\u001a\r\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\b\b\u0002\u0010\u0015\u001a\u00020\u00012\b\b\u0002\u0010\u0016\u001a\u00020\u00012\b\b\u0002\u0010\u0017\u001a\u00020\u00142\b\b\u0002\u0010\u0018\u001a\u00020\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001a2\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u00012\b\b\u0002\u0010\u001f\u001a\u00020\u001a2\b\b\u0002\u0010 \u001a\u00020\u001a2\b\b\u0002\u0010!\u001a\u00020\u001a2\u0019\b\u0002\u0010\"\u001a\u0013\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00040#¢\u0006\u0002\b\tH\u0007ø\u0001\u0000¢\u0006\u0004\b%\u0010&\u001ae\u0010'\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00102\u0016\u0010(\u001a\u0012\u0012\u0004\u0012\u00020\u00040\b¢\u0006\u0002\b\t¢\u0006\u0002\b)2\u0012\u0010*\u001a\u000e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020+0#2\"\u0010,\u001a\u001e\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00040-¢\u0006\u0002\b\t¢\u0006\u0002\b)H\u0003¢\u0006\u0002\u0010/\u001a0\u00100\u001a\u00020\u00042\u0006\u00101\u001a\u00020\u001a2\f\u00102\u001a\b\u0012\u0004\u0012\u00020\u00040\b2\u0006\u00103\u001a\u00020\u0014H\u0003ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001aE\u00106\u001a\u00020\u00122\u0006\u00107\u001a\u00020\u00062\u000e\b\u0002\u00108\u001a\b\u0012\u0004\u0012\u00020.092\u0014\b\u0002\u0010:\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00140#2\b\b\u0002\u0010;\u001a\u00020$H\u0007¢\u0006\u0002\u0010<\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006=²\u0006\n\u0010>\u001a\u00020.X\u008a\u0084\u0002²\u0006\n\u0010?\u001a\u00020.X\u008a\u0084\u0002"}, d2 = {"AnimationSlideOffset", "Landroidx/compose/ui/unit/Dp;", "F", "BackLayerTransition", "", TypedValues.AttributesType.S_TARGET, "Landroidx/compose/material/BackdropValue;", "appBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "content", "(Landroidx/compose/material/BackdropValue;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "BackdropScaffold", "backLayerContent", "frontLayerContent", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/BackdropScaffoldState;", "gesturesEnabled", "", "peekHeight", "headerHeight", "persistentAppBar", "stickyFrontLayer", "backLayerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "backLayerContentColor", "frontLayerShape", "Landroidx/compose/ui/graphics/Shape;", "frontLayerElevation", "frontLayerBackgroundColor", "frontLayerContentColor", "frontLayerScrimColor", "snackbarHost", "Lkotlin/Function1;", "Landroidx/compose/material/SnackbarHostState;", "BackdropScaffold-BZszfkY", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;Landroidx/compose/material/BackdropScaffoldState;ZFFZZJJLandroidx/compose/ui/graphics/Shape;FJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "BackdropStack", "backLayer", "Landroidx/compose/ui/UiComposable;", "calculateBackLayerConstraints", "Landroidx/compose/ui/unit/Constraints;", "frontLayer", "Lkotlin/Function2;", "", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function4;Landroidx/compose/runtime/Composer;I)V", "Scrim", "color", "onDismiss", SdkConstants.ATTR_VISIBLE, "Scrim-3J-VO9M", "(JLkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "rememberBackdropScaffoldState", "initialValue", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "confirmStateChange", "snackbarHostState", "(Landroidx/compose/material/BackdropValue;Landroidx/compose/animation/core/AnimationSpec;Lkotlin/jvm/functions/Function1;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/BackdropScaffoldState;", "material_release", "alpha", "animationProgress"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BackdropScaffoldKt {
    private static final float AnimationSlideOffset = Dp.m7255constructorimpl(20);

    public static final BackdropScaffoldState rememberBackdropScaffoldState(final BackdropValue backdropValue, final AnimationSpec<Float> animationSpec, final Function1<? super BackdropValue, Boolean> function1, final SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-862178912);
        ComposerKt.sourceInformation(composer, "C(rememberBackdropScaffoldState)P(2)173@6493L32,175@6564L538:BackdropScaffold.kt#jmzs0o");
        if ((i2 & 2) != 0) {
            animationSpec = SwipeableDefaults.INSTANCE.getAnimationSpec();
        }
        if ((i2 & 4) != 0) {
            function1 = new Function1<BackdropValue, Boolean>() { // from class: androidx.compose.material.BackdropScaffoldKt.rememberBackdropScaffoldState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(BackdropValue backdropValue2) {
                    return true;
                }
            };
        }
        if ((i2 & 8) != 0) {
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
            ComposerKt.traceEventStart(-862178912, i, -1, "androidx.compose.material.rememberBackdropScaffoldState (BackdropScaffold.kt:174)");
        }
        BackdropScaffoldState backdropScaffoldState = (BackdropScaffoldState) RememberSaveableKt.m3983rememberSaveable(new Object[]{animationSpec, function1, snackbarHostState}, (Saver) BackdropScaffoldState.INSTANCE.Saver(animationSpec, function1, snackbarHostState), (String) null, (Function0) new Function0<BackdropScaffoldState>() { // from class: androidx.compose.material.BackdropScaffoldKt.rememberBackdropScaffoldState.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BackdropScaffoldState invoke() {
                return new BackdropScaffoldState(backdropValue, animationSpec, function1, snackbarHostState);
            }
        }, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return backdropScaffoldState;
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0163  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0197  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01b3  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:158:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01f3  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0207  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0230  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0250  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02e0  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x0310  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x031f  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0323  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0339  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x033f  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0357  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0367  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0388  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0390  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x03cf  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x03d6  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0471  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x04fa  */
    /* JADX WARN: Removed duplicated region for block: B:293:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:53:0x00a2  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00ac  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ec  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0141  */
    /* renamed from: BackdropScaffold-BZszfkY, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1734BackdropScaffoldBZszfkY(final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r35, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r36, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, androidx.compose.ui.Modifier r38, androidx.compose.material.BackdropScaffoldState r39, boolean r40, float r41, float r42, boolean r43, boolean r44, long r45, long r47, androidx.compose.ui.graphics.Shape r49, float r50, long r51, long r53, long r55, kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r57, androidx.compose.runtime.Composer r58, final int r59, final int r60, final int r61) {
        /*
            Method dump skipped, instructions count: 1314
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BackdropScaffoldKt.m1734BackdropScaffoldBZszfkY(kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, androidx.compose.material.BackdropScaffoldState, boolean, float, float, boolean, boolean, long, long, androidx.compose.ui.graphics.Shape, float, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: Scrim-3J-VO9M, reason: not valid java name */
    public static final void m1735Scrim3JVO9M(final long j, final Function0<Unit> function0, final boolean z, Composer composer, final int i) {
        int i2;
        Modifier.Companion companionThen;
        Composer composerStartRestartGroup = composer.startRestartGroup(-92141505);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Scrim)P(0:c#ui.graphics.Color)390@16754L121,399@17055L171:BackdropScaffold.kt#jmzs0o");
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
                ComposerKt.traceEventStart(-92141505, i2, -1, "androidx.compose.material.Scrim (BackdropScaffold.kt:388)");
            }
            if (j != Color.INSTANCE.m4574getUnspecified0d7_KjU()) {
                final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, composerStartRestartGroup, 48, 28);
                if (z) {
                    Modifier.Companion companion = Modifier.INSTANCE;
                    Unit unit = Unit.INSTANCE;
                    composerStartRestartGroup.startReplaceableGroup(-874712345);
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(function0);
                    BackdropScaffoldKt$Scrim$dismissModifier$1$1 backdropScaffoldKt$Scrim$dismissModifier$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || backdropScaffoldKt$Scrim$dismissModifier$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        backdropScaffoldKt$Scrim$dismissModifier$1$1RememberedValue = new BackdropScaffoldKt$Scrim$dismissModifier$1$1(function0, null);
                        composerStartRestartGroup.updateRememberedValue(backdropScaffoldKt$Scrim$dismissModifier$1$1RememberedValue);
                    }
                    composerStartRestartGroup.endReplaceableGroup();
                    companionThen = companion.then(new SuspendPointerInputElement(unit, null, null, new SuspendingPointerInputFilterKt$sam$androidx_compose_ui_input_pointer_PointerInputEventHandler$0((Function2) backdropScaffoldKt$Scrim$dismissModifier$1$1RememberedValue), 6, null));
                } else {
                    companionThen = Modifier.INSTANCE;
                }
                Modifier modifierThen = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null).then(companionThen);
                composerStartRestartGroup.startReplaceableGroup(-874712142);
                boolean zChanged = composerStartRestartGroup.changed(j) | composerStartRestartGroup.changed(stateAnimateFloatAsState);
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (Function1) new Function1<DrawScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$Scrim$1$1
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
                            DrawScope.m5111drawRectnJ9OG0$default(drawScope, j, 0L, 0L, BackdropScaffoldKt.Scrim_3J_VO9M$lambda$4(stateAnimateFloatAsState), null, null, 0, 118, null);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceableGroup();
                CanvasKt.Canvas(modifierThen, (Function1) objRememberedValue, composerStartRestartGroup, 0);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$Scrim$2
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
                    BackdropScaffoldKt.m1735Scrim3JVO9M(j, function0, z, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BackLayerTransition(final BackdropValue backdropValue, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-950970976);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BackLayerTransition)P(2)423@17886L112,*426@18048L7,431@18222L486:BackdropScaffold.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(backdropValue) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function22) ? 256 : 128;
        }
        int i3 = i2;
        if ((i3 & WinError.ERROR_WAIT_1) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-950970976, i3, -1, "androidx.compose.material.BackLayerTransition (BackdropScaffold.kt:420)");
            }
            State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(backdropValue == BackdropValue.Revealed ? 0.0f : 2.0f, new TweenSpec(0, 0, null, 7, null), 0.0f, null, null, composerStartRestartGroup, 48, 28);
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            float fMo677toPx0680j_4 = ((Density) objConsume).mo677toPx0680j_4(AnimationSlideOffset);
            float f = 1;
            float fCoerceIn = RangesKt.coerceIn(BackLayerTransition$lambda$7(stateAnimateFloatAsState) - f, 0.0f, 1.0f);
            float fCoerceIn2 = RangesKt.coerceIn(f - BackLayerTransition$lambda$7(stateAnimateFloatAsState), 0.0f, 1.0f);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(companion);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1538629116, "C432@18236L226,440@18471L231:BackdropScaffold.kt#jmzs0o");
            Modifier modifierM4701graphicsLayerAp8cVGQ = GraphicsLayerModifierKt.m4701graphicsLayerAp8cVGQ(ZIndexModifierKt.zIndex(Modifier.INSTANCE, fCoerceIn), (131067 & 1) != 0 ? 1.0f : 0.0f, (131067 & 2) != 0 ? 1.0f : 0.0f, (131067 & 4) == 0 ? fCoerceIn : 1.0f, (131067 & 8) != 0 ? 0.0f : 0.0f, (131067 & 16) != 0 ? 0.0f : (f - fCoerceIn) * fMo677toPx0680j_4, (131067 & 32) != 0 ? 0.0f : 0.0f, (131067 & 64) != 0 ? 0.0f : 0.0f, (131067 & 128) != 0 ? 0.0f : 0.0f, (131067 & 256) == 0 ? 0.0f : 0.0f, (131067 & 512) != 0 ? 8.0f : 0.0f, (131067 & 1024) != 0 ? TransformOrigin.INSTANCE.m4946getCenterSzJe1aQ() : 0L, (131067 & 2048) != 0 ? RectangleShapeKt.getRectangleShape() : null, (131067 & 4096) != 0 ? false : false, (131067 & 8192) != 0 ? null : null, (131067 & 16384) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (131067 & 32768) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (131067 & 65536) != 0 ? CompositingStrategy.INSTANCE.m4628getAutoNrFUSI() : 0);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifierM4701graphicsLayerAp8cVGQ);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3857constructorimpl2 = Updater.m3857constructorimpl(composerStartRestartGroup);
            Updater.m3864setimpl(composerM3857constructorimpl2, measurePolicyRememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3864setimpl(composerM3857constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3857constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM3857constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3857constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            function3ModifierMaterializerOf2.invoke(SkippableUpdater.m3827boximpl(SkippableUpdater.m3828constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -481855243, "C438@18444L8:BackdropScaffold.kt#jmzs0o");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierM4701graphicsLayerAp8cVGQ2 = GraphicsLayerModifierKt.m4701graphicsLayerAp8cVGQ(ZIndexModifierKt.zIndex(Modifier.INSTANCE, fCoerceIn2), (131067 & 1) != 0 ? 1.0f : 0.0f, (131067 & 2) != 0 ? 1.0f : 0.0f, (131067 & 4) == 0 ? fCoerceIn2 : 1.0f, (131067 & 8) != 0 ? 0.0f : 0.0f, (131067 & 16) != 0 ? 0.0f : (f - fCoerceIn2) * (-fMo677toPx0680j_4), (131067 & 32) != 0 ? 0.0f : 0.0f, (131067 & 64) != 0 ? 0.0f : 0.0f, (131067 & 128) != 0 ? 0.0f : 0.0f, (131067 & 256) == 0 ? 0.0f : 0.0f, (131067 & 512) != 0 ? 8.0f : 0.0f, (131067 & 1024) != 0 ? TransformOrigin.INSTANCE.m4946getCenterSzJe1aQ() : 0L, (131067 & 2048) != 0 ? RectangleShapeKt.getRectangleShape() : null, (131067 & 4096) != 0 ? false : false, (131067 & 8192) != 0 ? null : null, (131067 & 16384) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (131067 & 32768) != 0 ? GraphicsLayerScopeKt.getDefaultShadowColor() : 0L, (131067 & 65536) != 0 ? CompositingStrategy.INSTANCE.m4628getAutoNrFUSI() : 0);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierM4701graphicsLayerAp8cVGQ2);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3857constructorimpl3 = Updater.m3857constructorimpl(composerStartRestartGroup);
            Updater.m3864setimpl(composerM3857constructorimpl3, measurePolicyRememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3864setimpl(composerM3857constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3857constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM3857constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM3857constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            function3ModifierMaterializerOf3.invoke(SkippableUpdater.m3827boximpl(SkippableUpdater.m3828constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -481855004, "C446@18683L9:BackdropScaffold.kt#jmzs0o");
            function22.invoke(composerStartRestartGroup, Integer.valueOf((i3 >> 6) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt.BackLayerTransition.2
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

                public final void invoke(Composer composer2, int i4) {
                    BackdropScaffoldKt.BackLayerTransition(backdropValue, function2, function22, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BackdropStack(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function1<? super Constraints, Constraints> function1, final Function4<? super Constraints, ? super Float, ? super Composer, ? super Integer, Unit> function4, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1248995194);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BackdropStack)P(3)459@18986L917:BackdropScaffold.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
        }
        if ((i2 & 5851) != 1170 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1248995194, i2, -1, "androidx.compose.material.BackdropStack (BackdropScaffold.kt:458)");
            }
            composerStartRestartGroup.startReplaceableGroup(-874710293);
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(function2) | composerStartRestartGroup.changedInstance(function1) | composerStartRestartGroup.changedInstance(function4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1740invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m1740invoke0kLqBqw(SubcomposeMeasureScope subcomposeMeasureScope, final long j) {
                        final Placeable placeableMo5957measureBRTryo0 = ((Measurable) CollectionsKt.first((List) subcomposeMeasureScope.subcompose(BackdropLayers.Back, function2))).mo5957measureBRTryo0(function1.invoke(Constraints.m7195boximpl(j)).getValue());
                        final float height = placeableMo5957measureBRTryo0.getHeight();
                        BackdropLayers backdropLayers = BackdropLayers.Front;
                        final Function4<Constraints, Float, Composer, Integer, Unit> function42 = function4;
                        List<Measurable> listSubcompose = subcomposeMeasureScope.subcompose(backdropLayers, ComposableLambdaKt.composableLambdaInstance(-1222642649, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1$placeables$1
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

                            public final void invoke(Composer composer2, int i3) {
                                ComposerKt.sourceInformation(composer2, "C468@19351L40:BackdropScaffold.kt#jmzs0o");
                                if ((i3 & 11) == 2 && composer2.getSkipping()) {
                                    composer2.skipToGroupEnd();
                                    return;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-1222642649, i3, -1, "androidx.compose.material.BackdropStack.<anonymous>.<anonymous>.<anonymous> (BackdropScaffold.kt:468)");
                                }
                                function42.invoke(Constraints.m7195boximpl(j), Float.valueOf(height), composer2, 0);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                            }
                        }));
                        ArrayList arrayList = new ArrayList(listSubcompose.size());
                        int size = listSubcompose.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            arrayList.add(listSubcompose.get(i3).mo5957measureBRTryo0(j));
                        }
                        final ArrayList arrayList2 = arrayList;
                        int iMax = Math.max(Constraints.m7210getMinWidthimpl(j), placeableMo5957measureBRTryo0.getWidth());
                        int iMax2 = Math.max(Constraints.m7209getMinHeightimpl(j), placeableMo5957measureBRTryo0.getHeight());
                        int size2 = arrayList2.size();
                        int iMax3 = iMax2;
                        int iMax4 = iMax;
                        for (int i4 = 0; i4 < size2; i4++) {
                            Placeable placeable = (Placeable) arrayList2.get(i4);
                            iMax4 = Math.max(iMax4, placeable.getWidth());
                            iMax3 = Math.max(iMax3, placeable.getHeight());
                        }
                        return MeasureScope.layout$default(subcomposeMeasureScope, iMax4, iMax3, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt$BackdropStack$1$1.2
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
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
                                List<Placeable> list = arrayList2;
                                int size3 = list.size();
                                for (int i5 = 0; i5 < size3; i5++) {
                                    Placeable.PlacementScope.placeRelative$default(placementScope, list.get(i5), 0, 0, 0.0f, 4, null);
                                }
                            }
                        }, 4, null);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            SubcomposeLayoutKt.SubcomposeLayout(modifier, (Function2) objRememberedValue, composerStartRestartGroup, i2 & 14, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BackdropScaffoldKt.BackdropStack.2
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

                public final void invoke(Composer composer2, int i3) {
                    BackdropScaffoldKt.BackdropStack(modifier, function2, function1, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float Scrim_3J_VO9M$lambda$4(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float BackLayerTransition$lambda$7(State<Float> state) {
        return state.getValue().floatValue();
    }
}
