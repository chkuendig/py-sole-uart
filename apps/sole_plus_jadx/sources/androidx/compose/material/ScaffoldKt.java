package androidx.compose.material;

import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.layout.SubcomposeLayoutKt;
import androidx.compose.ui.layout.SubcomposeMeasureScope;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* compiled from: Scaffold.kt */
@Metadata(d1 = {"\u0000\u0086\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a¨\u0001\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00140\u001d¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0006\u0010!\u001a\u00020\"2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0003ø\u0001\u0000¢\u0006\u0004\b$\u0010%\u001a§\u0002\u0010&\u001a\u00020\u00142\u0006\u0010!\u001a\u00020\"2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a2\u0013\b\u0002\u0010#\u001a\r\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a2\u0019\b\u0002\u0010+\u001a\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00140\u001d¢\u0006\u0002\b\u001a2\u0013\b\u0002\u0010-\u001a\r\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a2\b\b\u0002\u0010.\u001a\u00020\u00172\b\b\u0002\u0010/\u001a\u00020\t2 \b\u0002\u00100\u001a\u001a\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001d¢\u0006\u0002\b\u001a¢\u0006\u0002\b22\b\b\u0002\u00103\u001a\u00020\t2\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u00012\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u0002082\b\b\u0002\u0010:\u001a\u0002082\b\b\u0002\u0010;\u001a\u0002082\b\b\u0002\u0010<\u001a\u0002082\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00140\u001d¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a\u009f\u0002\u0010&\u001a\u00020\u00142\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*2\u0013\b\u0002\u0010\u0018\u001a\r\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a2\u0013\b\u0002\u0010#\u001a\r\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a2\u0019\b\u0002\u0010+\u001a\u0013\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020\u00140\u001d¢\u0006\u0002\b\u001a2\u0013\b\u0002\u0010-\u001a\r\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a2\b\b\u0002\u0010.\u001a\u00020\u00172\b\b\u0002\u0010/\u001a\u00020\t2 \b\u0002\u00100\u001a\u001a\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u001d¢\u0006\u0002\b\u001a¢\u0006\u0002\b22\b\b\u0002\u00103\u001a\u00020\t2\b\b\u0002\u00104\u001a\u0002052\b\b\u0002\u00106\u001a\u00020\u00012\b\b\u0002\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u0002082\b\b\u0002\u0010:\u001a\u0002082\b\b\u0002\u0010;\u001a\u0002082\b\b\u0002\u0010<\u001a\u0002082\u0017\u0010\u001c\u001a\u0013\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00140\u001d¢\u0006\u0002\b\u001aH\u0007ø\u0001\u0000¢\u0006\u0004\b?\u0010@\u001a¨\u0001\u0010A\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00140\u001d¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0006\u0010!\u001a\u00020\"2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0003ø\u0001\u0000¢\u0006\u0004\bB\u0010%\u001a¨\u0001\u0010C\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0016\u001a\u00020\u00172\u0016\u0010\u0018\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u00140\u001d¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\u0010\u001f\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0016\u0010 \u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001b2\u0006\u0010!\u001a\u00020\"2\u0016\u0010#\u001a\u0012\u0012\u0004\u0012\u00020\u00140\u0019¢\u0006\u0002\b\u001a¢\u0006\u0002\b\u001bH\u0003ø\u0001\u0000¢\u0006\u0004\bD\u0010%\u001a!\u0010E\u001a\u00020*2\b\b\u0002\u0010F\u001a\u00020G2\b\b\u0002\u0010H\u001a\u00020,H\u0007¢\u0006\u0002\u0010I\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u001c\u0010\u0003\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00050\u0004X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"1\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t8G@GX\u0087\u008e\u0002¢\u0006\u0018\n\u0004\b\u0011\u0010\u0012\u0012\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006J"}, d2 = {"FabSpacing", "Landroidx/compose/ui/unit/Dp;", "F", "LocalFabPlacement", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/material/FabPlacement;", "getLocalFabPlacement", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "<set-?>", "", "ScaffoldSubcomposeInMeasureFix", "getScaffoldSubcomposeInMeasureFix$annotations", "()V", "getScaffoldSubcomposeInMeasureFix", "()Z", "setScaffoldSubcomposeInMeasureFix", "(Z)V", "ScaffoldSubcomposeInMeasureFix$delegate", "Landroidx/compose/runtime/MutableState;", "LegacyScaffoldLayout", "", "isFabDocked", "fabPosition", "Landroidx/compose/material/FabPosition;", "topBar", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "Landroidx/compose/ui/UiComposable;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/PaddingValues;", "snackbar", "fab", "contentWindowInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "bottomBar", "LegacyScaffoldLayout-i1QSOvI", "(ZILkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Scaffold", "modifier", "Landroidx/compose/ui/Modifier;", "scaffoldState", "Landroidx/compose/material/ScaffoldState;", "snackbarHost", "Landroidx/compose/material/SnackbarHostState;", "floatingActionButton", "floatingActionButtonPosition", "isFloatingActionButtonDocked", "drawerContent", "Landroidx/compose/foundation/layout/ColumnScope;", "Lkotlin/ExtensionFunctionType;", "drawerGesturesEnabled", "drawerShape", "Landroidx/compose/ui/graphics/Shape;", "drawerElevation", "drawerBackgroundColor", "Landroidx/compose/ui/graphics/Color;", "drawerContentColor", "drawerScrimColor", "backgroundColor", "contentColor", "Scaffold-u4IkXBM", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "Scaffold-27mzLpw", "(Landroidx/compose/ui/Modifier;Landroidx/compose/material/ScaffoldState;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;IZLkotlin/jvm/functions/Function3;ZLandroidx/compose/ui/graphics/Shape;FJJJJJLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "ScaffoldLayout", "ScaffoldLayout-i1QSOvI", "ScaffoldLayoutWithMeasureFix", "ScaffoldLayoutWithMeasureFix-i1QSOvI", "rememberScaffoldState", "drawerState", "Landroidx/compose/material/DrawerState;", "snackbarHostState", "(Landroidx/compose/material/DrawerState;Landroidx/compose/material/SnackbarHostState;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/ScaffoldState;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ScaffoldKt {
    private static final MutableState ScaffoldSubcomposeInMeasureFix$delegate = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
    private static final ProvidableCompositionLocal<FabPlacement> LocalFabPlacement = CompositionLocalKt.staticCompositionLocalOf(new Function0<FabPlacement>() { // from class: androidx.compose.material.ScaffoldKt$LocalFabPlacement$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final FabPlacement invoke() {
            return null;
        }
    });
    private static final float FabSpacing = Dp.m7255constructorimpl(16);

    public static /* synthetic */ void getScaffoldSubcomposeInMeasureFix$annotations() {
    }

    public static final ScaffoldState rememberScaffoldState(DrawerState drawerState, SnackbarHostState snackbarHostState, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1569641925);
        ComposerKt.sourceInformation(composer, "C(rememberScaffoldState)74@2854L39,75@2938L32,76@2990L62:Scaffold.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            drawerState = DrawerKt.rememberDrawerState(DrawerValue.Closed, null, composer, 6, 2);
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
            ComposerKt.traceEventStart(1569641925, i, -1, "androidx.compose.material.rememberScaffoldState (Scaffold.kt:76)");
        }
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new ScaffoldState(drawerState, snackbarHostState);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        ScaffoldState scaffoldState = (ScaffoldState) objRememberedValue2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return scaffoldState;
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01dc  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01e2  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x01f9  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0219  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0313  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0350  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0358  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004d  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x037c  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0389  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x0399  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x03b0  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03b8  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03d2  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03e2  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x0406  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0420  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x042b  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:304:0x0483  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x04e3  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x0506  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x052d  */
    /* JADX WARN: Removed duplicated region for block: B:314:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0062  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0090  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d2  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0137  */
    /* renamed from: Scaffold-u4IkXBM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1945Scaffoldu4IkXBM(final androidx.compose.foundation.layout.WindowInsets r39, androidx.compose.ui.Modifier r40, androidx.compose.material.ScaffoldState r41, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r45, int r46, boolean r47, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r48, boolean r49, androidx.compose.ui.graphics.Shape r50, float r51, long r52, long r54, long r56, long r58, long r60, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r62, androidx.compose.runtime.Composer r63, final int r64, final int r65, final int r66) {
        /*
            Method dump skipped, instructions count: 1354
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ScaffoldKt.m1945Scaffoldu4IkXBM(androidx.compose.foundation.layout.WindowInsets, androidx.compose.ui.Modifier, androidx.compose.material.ScaffoldState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, int, boolean, kotlin.jvm.functions.Function3, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0179  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a6  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x01da  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x0211  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0217  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02dc  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02e1  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02fa  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0301  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0304  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0337  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x033b  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x033d  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0346  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0383  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03ec  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x040b  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x0490  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x04b2  */
    /* JADX WARN: Removed duplicated region for block: B:297:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00bf  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00ff  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013d  */
    /* renamed from: Scaffold-27mzLpw, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1944Scaffold27mzLpw(androidx.compose.ui.Modifier r57, androidx.compose.material.ScaffoldState r58, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r59, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r60, kotlin.jvm.functions.Function3<? super androidx.compose.material.SnackbarHostState, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r61, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r62, int r63, boolean r64, kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r65, boolean r66, androidx.compose.ui.graphics.Shape r67, float r68, long r69, long r71, long r73, long r75, long r77, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.PaddingValues, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r79, androidx.compose.runtime.Composer r80, final int r81, final int r82, final int r83) {
        /*
            Method dump skipped, instructions count: 1229
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ScaffoldKt.m1944Scaffold27mzLpw(androidx.compose.ui.Modifier, androidx.compose.material.ScaffoldState, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function2, int, boolean, kotlin.jvm.functions.Function3, boolean, androidx.compose.ui.graphics.Shape, float, long, long, long, long, long, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final boolean getScaffoldSubcomposeInMeasureFix() {
        return ((Boolean) ScaffoldSubcomposeInMeasureFix$delegate.getValue()).booleanValue();
    }

    public static final void setScaffoldSubcomposeInMeasureFix(boolean z) {
        ScaffoldSubcomposeInMeasureFix$delegate.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ScaffoldLayout-i1QSOvI, reason: not valid java name */
    public static final void m1946ScaffoldLayouti1QSOvI(final boolean z, final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-468424875);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScaffoldLayout)P(5,4:c#material.FabPosition,7,1,6,3,2):Scaffold.kt#jmzs0o");
        if ((i2 & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function22) ? 16384 : 8192;
        }
        if ((458752 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function23) ? 131072 : 65536;
        }
        if ((3670016 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(windowInsets) ? 1048576 : 524288;
        }
        if ((29360128 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
        }
        if ((23967451 & i3) != 4793490 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-468424875, i3, -1, "androidx.compose.material.ScaffoldLayout (Scaffold.kt:409)");
            }
            if (getScaffoldSubcomposeInMeasureFix()) {
                composerStartRestartGroup.startReplaceableGroup(-2103098080);
                ComposerKt.sourceInformation(composerStartRestartGroup, "411@18576L322");
                m1947ScaffoldLayoutWithMeasureFixi1QSOvI(z, i, function2, function3, function22, function23, windowInsets, function24, composerStartRestartGroup, i3 & 33554430);
                composerStartRestartGroup.endReplaceableGroup();
            } else {
                composerStartRestartGroup.startReplaceableGroup(-2103097736);
                ComposerKt.sourceInformation(composerStartRestartGroup, "422@18920L314");
                m1943LegacyScaffoldLayouti1QSOvI(z, i, function2, function3, function22, function23, windowInsets, function24, composerStartRestartGroup, i3 & 33554430);
                composerStartRestartGroup.endReplaceableGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayout$1
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
                    ScaffoldKt.m1946ScaffoldLayouti1QSOvI(z, i, function2, function3, function22, function23, windowInsets, function24, composer2, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: ScaffoldLayoutWithMeasureFix-i1QSOvI, reason: not valid java name */
    public static final void m1947ScaffoldLayoutWithMeasureFixi1QSOvI(final boolean z, final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1285900760);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ScaffoldLayoutWithMeasureFix)P(5,4:c#material.FabPosition,7,1,6,3,2)450@19773L6694:Scaffold.kt#jmzs0o");
        if ((i2 & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function22) ? 16384 : 8192;
        }
        if ((458752 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function23) ? 131072 : 65536;
        }
        if ((3670016 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(windowInsets) ? 1048576 : 524288;
        }
        if ((29360128 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
        }
        if ((23967451 & i3) != 4793490 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1285900760, i3, -1, "androidx.compose.material.ScaffoldLayoutWithMeasureFix (Scaffold.kt:449)");
            }
            composerStartRestartGroup.startReplaceableGroup(188870142);
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(function2) | composerStartRestartGroup.changedInstance(function22) | composerStartRestartGroup.changed(windowInsets) | composerStartRestartGroup.changedInstance(function23) | composerStartRestartGroup.changed(i) | composerStartRestartGroup.changed(z) | composerStartRestartGroup.changedInstance(function24) | composerStartRestartGroup.changedInstance(function3);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                composer2 = composerStartRestartGroup;
                objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1952invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* JADX WARN: Removed duplicated region for block: B:93:0x0250  */
                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                        To view partially-correct add '--show-bad-code' argument
                    */
                    public final androidx.compose.ui.layout.MeasureResult m1952invoke0kLqBqw(final androidx.compose.ui.layout.SubcomposeMeasureScope r33, long r34) {
                        /*
                            Method dump skipped, instructions count: 961
                            To view this dump add '--comments-level debug' option
                        */
                        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ScaffoldKt$ScaffoldLayoutWithMeasureFix$1$1.m1952invoke0kLqBqw(androidx.compose.ui.layout.SubcomposeMeasureScope, long):androidx.compose.ui.layout.MeasureResult");
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$ScaffoldLayoutWithMeasureFix$2
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
                    ScaffoldKt.m1947ScaffoldLayoutWithMeasureFixi1QSOvI(z, i, function2, function3, function22, function23, windowInsets, function24, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: LegacyScaffoldLayout-i1QSOvI, reason: not valid java name */
    public static final void m1943LegacyScaffoldLayouti1QSOvI(final boolean z, final int i, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super PaddingValues, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final WindowInsets windowInsets, final Function2<? super Composer, ? super Integer, Unit> function24, Composer composer, final int i2) {
        int i3;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(141059468);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(LegacyScaffoldLayout)P(5,4:c#material.FabPosition,7,1,6,3,2)628@26997L7169:Scaffold.kt#jmzs0o");
        if ((i2 & 14) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 112) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 896) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        if ((i2 & 7168) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((57344 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function22) ? 16384 : 8192;
        }
        if ((458752 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function23) ? 131072 : 65536;
        }
        if ((3670016 & i2) == 0) {
            i3 |= composerStartRestartGroup.changed(windowInsets) ? 1048576 : 524288;
        }
        if ((29360128 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function24) ? 8388608 : 4194304;
        }
        if ((23967451 & i3) != 4793490 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(141059468, i3, -1, "androidx.compose.material.LegacyScaffoldLayout (Scaffold.kt:627)");
            }
            composerStartRestartGroup.startReplaceableGroup(188877366);
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(function2) | composerStartRestartGroup.changedInstance(function22) | composerStartRestartGroup.changed(windowInsets) | composerStartRestartGroup.changedInstance(function23) | composerStartRestartGroup.changed(i) | composerStartRestartGroup.changed(z) | composerStartRestartGroup.changedInstance(function24) | composerStartRestartGroup.changedInstance(function3);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                composer2 = composerStartRestartGroup;
                objRememberedValue = (Function2) new Function2<SubcomposeMeasureScope, Constraints, MeasureResult>() { // from class: androidx.compose.material.ScaffoldKt$LegacyScaffoldLayout$1$1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ MeasureResult invoke(SubcomposeMeasureScope subcomposeMeasureScope, Constraints constraints) {
                        return m1951invoke0kLqBqw(subcomposeMeasureScope, constraints.getValue());
                    }

                    /* renamed from: invoke-0kLqBqw, reason: not valid java name */
                    public final MeasureResult m1951invoke0kLqBqw(final SubcomposeMeasureScope subcomposeMeasureScope, long j) {
                        final int iM7208getMaxWidthimpl = Constraints.m7208getMaxWidthimpl(j);
                        final int iM7207getMaxHeightimpl = Constraints.m7207getMaxHeightimpl(j);
                        final long jM7198copyZbe2FdA$default = Constraints.m7198copyZbe2FdA$default(j, 0, 0, 0, 0, 10, null);
                        final Function2<Composer, Integer, Unit> function25 = function2;
                        final Function2<Composer, Integer, Unit> function26 = function22;
                        final Function2<Composer, Integer, Unit> function27 = function23;
                        final int i4 = i;
                        final boolean z2 = z;
                        final WindowInsets windowInsets2 = windowInsets;
                        final Function2<Composer, Integer, Unit> function28 = function24;
                        final Function3<PaddingValues, Composer, Integer, Unit> function32 = function3;
                        return MeasureScope.layout$default(subcomposeMeasureScope, iM7208getMaxWidthimpl, iM7207getMaxHeightimpl, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.ScaffoldKt$LegacyScaffoldLayout$1$1.1
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

                            /* JADX WARN: Removed duplicated region for block: B:90:0x024a  */
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                                To view partially-correct add '--show-bad-code' argument
                            */
                            public final void invoke2(androidx.compose.ui.layout.Placeable.PlacementScope r31) {
                                /*
                                    Method dump skipped, instructions count: 1120
                                    To view this dump add '--comments-level debug' option
                                */
                                throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ScaffoldKt$LegacyScaffoldLayout$1$1.AnonymousClass1.invoke2(androidx.compose.ui.layout.Placeable$PlacementScope):void");
                            }
                        }, 4, null);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.ScaffoldKt$LegacyScaffoldLayout$2
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
                    ScaffoldKt.m1943LegacyScaffoldLayouti1QSOvI(z, i, function2, function3, function22, function23, windowInsets, function24, composer3, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
                }
            });
        }
    }

    public static final ProvidableCompositionLocal<FabPlacement> getLocalFabPlacement() {
        return LocalFabPlacement;
    }
}
