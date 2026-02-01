package androidx.compose.material;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.AlignmentLineKt;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.Measurable;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.MeasureResult;
import androidx.compose.ui.layout.MeasureScope;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import com.android.SdkConstants;
import com.sun.jna.platform.win32.WinError;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: BottomNavigation.kt */
@Metadata(d1 = {"\u0000x\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a`\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\t2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00042\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u001aX\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00102\b\b\u0002\u0010\u0012\u001a\u00020\u00042\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u000b0\u0014¢\u0006\u0002\b\u0016¢\u0006\u0002\b\u0017H\u0007ø\u0001\u0000¢\u0006\u0004\b\u001a\u0010\u001b\u001a?\u0010\u001c\u001a\u00020\u000b2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u000b0\u001e¢\u0006\u0002\b\u00162\u0013\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001e¢\u0006\u0002\b\u00162\b\b\u0001\u0010 \u001a\u00020\u0002H\u0003¢\u0006\u0002\u0010!\u001aR\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\u00102\u0006\u0010$\u001a\u00020\u00102\u0006\u0010%\u001a\u00020&2&\u0010\u0013\u001a\"\u0012\u0013\u0012\u00110\u0002¢\u0006\f\b'\u0012\b\b(\u0012\u0004\b\b()\u0012\u0004\u0012\u00020\u000b0\u0014¢\u0006\u0002\b\u0016H\u0003ø\u0001\u0000¢\u0006\u0004\b*\u0010+\u001a\u0092\u0001\u0010,\u001a\u00020\u000b*\u00020\u00152\u0006\u0010%\u001a\u00020&2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001e2\u0011\u0010\u001d\u001a\r\u0012\u0004\u0012\u00020\u000b0\u001e¢\u0006\u0002\b\u00162\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010.\u001a\u00020&2\u0015\b\u0002\u0010\u001f\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\u001e¢\u0006\u0002\b\u00162\b\b\u0002\u0010/\u001a\u00020&2\b\b\u0002\u00100\u001a\u0002012\b\b\u0002\u00102\u001a\u00020\u00102\b\b\u0002\u00103\u001a\u00020\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001a&\u00106\u001a\u000207*\u0002082\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<H\u0002ø\u0001\u0000¢\u0006\u0004\b=\u0010>\u001a8\u0010?\u001a\u000207*\u0002082\u0006\u0010@\u001a\u00020:2\u0006\u00109\u001a\u00020:2\u0006\u0010;\u001a\u00020<2\b\b\u0001\u0010 \u001a\u00020\u0002H\u0002ø\u0001\u0000¢\u0006\u0004\bA\u0010B\"\u0014\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000\"\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0006\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u0010\u0010\u0007\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005\"\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006C²\u0006\n\u0010)\u001a\u00020\u0002X\u008a\u0084\u0002"}, d2 = {"BottomNavigationAnimationSpec", "Landroidx/compose/animation/core/TweenSpec;", "", "BottomNavigationHeight", "Landroidx/compose/ui/unit/Dp;", "F", "BottomNavigationItemHorizontalPadding", "CombinedItemTextBaseline", "ZeroInsets", "Landroidx/compose/foundation/layout/WindowInsets;", "BottomNavigation", "", "windowInsets", "modifier", "Landroidx/compose/ui/Modifier;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "contentColor", "elevation", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "BottomNavigation-_UMDTes", "(Landroidx/compose/foundation/layout/WindowInsets;Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomNavigation-PEIptTM", "(Landroidx/compose/ui/Modifier;JJFLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "BottomNavigationItemBaselineLayout", "icon", "Lkotlin/Function0;", "label", "iconPositionAnimationProgress", "(Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;FLandroidx/compose/runtime/Composer;I)V", "BottomNavigationTransition", "activeColor", "inactiveColor", "selected", "", "Lkotlin/ParameterName;", "name", "animationProgress", "BottomNavigationTransition-Klgx-Pg", "(JJZLkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;I)V", "BottomNavigationItem", SdkConstants.ATTR_ON_CLICK, "enabled", "alwaysShowLabel", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "selectedContentColor", "unselectedContentColor", "BottomNavigationItem-jY6E1Zs", "(Landroidx/compose/foundation/layout/RowScope;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function2;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;JJLandroidx/compose/runtime/Composer;III)V", "placeIcon", "Landroidx/compose/ui/layout/MeasureResult;", "Landroidx/compose/ui/layout/MeasureScope;", "iconPlaceable", "Landroidx/compose/ui/layout/Placeable;", "constraints", "Landroidx/compose/ui/unit/Constraints;", "placeIcon-3p2s80s", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;J)Landroidx/compose/ui/layout/MeasureResult;", "placeLabelAndIcon", "labelPlaceable", "placeLabelAndIcon-DIyivk0", "(Landroidx/compose/ui/layout/MeasureScope;Landroidx/compose/ui/layout/Placeable;Landroidx/compose/ui/layout/Placeable;JF)Landroidx/compose/ui/layout/MeasureResult;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class BottomNavigationKt {
    private static final TweenSpec<Float> BottomNavigationAnimationSpec = new TweenSpec<>(300, 0, EasingKt.getFastOutSlowInEasing(), 2, null);
    private static final float BottomNavigationHeight = Dp.m7255constructorimpl(56);
    private static final float BottomNavigationItemHorizontalPadding;
    private static final float CombinedItemTextBaseline;
    private static final WindowInsets ZeroInsets;

    /* JADX WARN: Removed duplicated region for block: B:101:0x016b  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0178  */
    /* JADX WARN: Removed duplicated region for block: B:107:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0060  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:45:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a1  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x00fc  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x010d  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x012b  */
    /* renamed from: BottomNavigation-_UMDTes, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1745BottomNavigation_UMDTes(final androidx.compose.foundation.layout.WindowInsets r25, androidx.compose.ui.Modifier r26, long r27, long r29, float r31, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, androidx.compose.runtime.Composer r33, final int r34, final int r35) {
        /*
            Method dump skipped, instructions count: 398
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomNavigationKt.m1745BottomNavigation_UMDTes(androidx.compose.foundation.layout.WindowInsets, androidx.compose.ui.Modifier, long, long, float, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00b2  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e4  */
    /* JADX WARN: Removed duplicated region for block: B:83:0x00f4  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0101  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0141  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x014b  */
    /* JADX WARN: Removed duplicated region for block: B:97:? A[RETURN, SYNTHETIC] */
    /* renamed from: BottomNavigation-PEIptTM, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1744BottomNavigationPEIptTM(androidx.compose.ui.Modifier r22, long r23, long r25, float r27, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r28, androidx.compose.runtime.Composer r29, final int r30, final int r31) {
        /*
            Method dump skipped, instructions count: 353
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomNavigationKt.m1744BottomNavigationPEIptTM(androidx.compose.ui.Modifier, long, long, float, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0137  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x013d  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a7  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01b1  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01b4  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x01ba  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01bc  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01e4  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0248  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x03a8  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:188:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00a4  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e2  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0109  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0124  */
    /* renamed from: BottomNavigationItem-jY6E1Zs, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m1746BottomNavigationItemjY6E1Zs(final androidx.compose.foundation.layout.RowScope r26, final boolean r27, final kotlin.jvm.functions.Function0<kotlin.Unit> r28, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r29, androidx.compose.ui.Modifier r30, boolean r31, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r32, boolean r33, androidx.compose.foundation.interaction.MutableInteractionSource r34, long r35, long r37, androidx.compose.runtime.Composer r39, final int r40, final int r41, final int r42) {
        /*
            Method dump skipped, instructions count: 989
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.BottomNavigationKt.m1746BottomNavigationItemjY6E1Zs(androidx.compose.foundation.layout.RowScope, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function2, androidx.compose.ui.Modifier, boolean, kotlin.jvm.functions.Function2, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, long, long, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: BottomNavigationTransition-Klgx-Pg, reason: not valid java name */
    public static final void m1747BottomNavigationTransitionKlgxPg(final long j, final long j2, final boolean z, final Function3<? super Float, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-985175058);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomNavigationTransition)P(0:c#ui.graphics.Color,2:c#ui.graphics.Color,3)288@12485L128,295@12688L181:BottomNavigation.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((i2 & 5851) != 1170 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-985175058, i2, -1, "androidx.compose.material.BottomNavigationTransition (BottomNavigation.kt:287)");
            }
            composer2 = composerStartRestartGroup;
            final State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(z ? 1.0f : 0.0f, BottomNavigationAnimationSpec, 0.0f, null, null, composerStartRestartGroup, 48, 28);
            long jM4589lerpjxsXWHM = ColorKt.m4589lerpjxsXWHM(j2, j, BottomNavigationTransition_Klgx_Pg$lambda$3(stateAnimateFloatAsState));
            CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m4528boximpl(Color.m4537copywmQWz5c$default(jM4589lerpjxsXWHM, 1.0f, 0.0f, 0.0f, 0.0f, 14, null))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m4540getAlphaimpl(jM4589lerpjxsXWHM)))}, ComposableLambdaKt.composableLambda(composer2, -138092754, true, new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationTransition$1
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

                public final void invoke(Composer composer3, int i3) {
                    ComposerKt.sourceInformation(composer3, "C299@12837L26:BottomNavigation.kt#jmzs0o");
                    if ((i3 & 11) == 2 && composer3.getSkipping()) {
                        composer3.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-138092754, i3, -1, "androidx.compose.material.BottomNavigationTransition.<anonymous> (BottomNavigation.kt:299)");
                    }
                    function3.invoke(Float.valueOf(BottomNavigationKt.BottomNavigationTransition_Klgx_Pg$lambda$3(stateAnimateFloatAsState)), composer3, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }), composer2, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationTransition$2
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

                public final void invoke(Composer composer3, int i3) {
                    BottomNavigationKt.m1747BottomNavigationTransitionKlgxPg(j, j2, z, function3, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void BottomNavigationItemBaselineLayout(final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final float f, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1162995092);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomNavigationItemBaselineLayout)P(!1,2)320@13538L1211:BottomNavigation.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function22) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 256 : 128;
        }
        if ((i2 & WinError.ERROR_WAIT_1) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1162995092, i2, -1, "androidx.compose.material.BottomNavigationItemBaselineLayout (BottomNavigation.kt:319)");
            }
            composerStartRestartGroup.startReplaceableGroup(188155536);
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(function22) | composerStartRestartGroup.changed(f);
            MeasurePolicy measurePolicyRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || measurePolicyRememberedValue == Composer.INSTANCE.getEmpty()) {
                measurePolicyRememberedValue = new MeasurePolicy() { // from class: androidx.compose.material.BottomNavigationKt$BottomNavigationItemBaselineLayout$2$1
                    @Override // androidx.compose.ui.layout.MeasurePolicy
                    /* renamed from: measure-3p2s80s */
                    public final MeasureResult mo342measure3p2s80s(MeasureScope measureScope, List<? extends Measurable> list, long j) {
                        Placeable placeableMo5957measureBRTryo0;
                        int size = list.size();
                        for (int i3 = 0; i3 < size; i3++) {
                            Measurable measurable = list.get(i3);
                            if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable), "icon")) {
                                Placeable placeableMo5957measureBRTryo02 = measurable.mo5957measureBRTryo0(j);
                                if (function22 != null) {
                                    int size2 = list.size();
                                    for (int i4 = 0; i4 < size2; i4++) {
                                        Measurable measurable2 = list.get(i4);
                                        if (Intrinsics.areEqual(LayoutIdKt.getLayoutId(measurable2), "label")) {
                                            placeableMo5957measureBRTryo0 = measurable2.mo5957measureBRTryo0(Constraints.m7198copyZbe2FdA$default(j, 0, 0, 0, 0, 11, null));
                                        }
                                    }
                                    throw new NoSuchElementException("Collection contains no element matching the predicate.");
                                }
                                placeableMo5957measureBRTryo0 = null;
                                Placeable placeable = placeableMo5957measureBRTryo0;
                                if (function22 == null) {
                                    return BottomNavigationKt.m1751placeIcon3p2s80s(measureScope, placeableMo5957measureBRTryo02, j);
                                }
                                Intrinsics.checkNotNull(placeable);
                                return BottomNavigationKt.m1752placeLabelAndIconDIyivk0(measureScope, placeable, placeableMo5957measureBRTryo02, j, f);
                            }
                        }
                        throw new NoSuchElementException("Collection contains no element matching the predicate.");
                    }
                };
                composerStartRestartGroup.updateRememberedValue(measurePolicyRememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) measurePolicyRememberedValue;
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            Modifier.Companion companion = Modifier.INSTANCE;
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
            Updater.m3864setimpl(composerM3857constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3864setimpl(composerM3857constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3857constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3857constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3857constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3827boximpl(SkippableUpdater.m3828constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 620000090, "C322@13568L41:BottomNavigation.kt#jmzs0o");
            Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "icon");
            composerStartRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifierLayoutId);
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
            Updater.m3864setimpl(composerM3857constructorimpl2, measurePolicyRememberBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3864setimpl(composerM3857constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3857constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM3857constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3857constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            function3ModifierMaterializerOf2.invoke(SkippableUpdater.m3827boximpl(SkippableUpdater.m3828constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1517371748, "C322@13601L6:BottomNavigation.kt#jmzs0o");
            function2.invoke(composerStartRestartGroup, Integer.valueOf(i2 & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(-1198309649);
            ComposerKt.sourceInformation(composerStartRestartGroup, "324@13659L253");
            if (function22 != null) {
                Modifier modifierM987paddingVpY3zN4$default = PaddingKt.m987paddingVpY3zN4$default(AlphaKt.alpha(LayoutIdKt.layoutId(Modifier.INSTANCE, "label"), f), BottomNavigationItemHorizontalPadding, 0.0f, 2, null);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierM987paddingVpY3zN4$default);
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
                Updater.m3864setimpl(composerM3857constructorimpl3, measurePolicyRememberBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3864setimpl(composerM3857constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM3857constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                    composerM3857constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                    composerM3857constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                }
                function3ModifierMaterializerOf3.invoke(SkippableUpdater.m3827boximpl(SkippableUpdater.m3828constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1517371446, "C329@13903L7:BottomNavigation.kt#jmzs0o");
                function22.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.BottomNavigationKt.BottomNavigationItemBaselineLayout.3
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
                    BottomNavigationKt.BottomNavigationItemBaselineLayout(function2, function22, f, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeIcon-3p2s80s, reason: not valid java name */
    public static final MeasureResult m1751placeIcon3p2s80s(MeasureScope measureScope, final Placeable placeable, long j) {
        int iM7224constrainHeightK40F9xA = ConstraintsKt.m7224constrainHeightK40F9xA(j, measureScope.mo671roundToPx0680j_4(BottomNavigationHeight));
        final int height = (iM7224constrainHeightK40F9xA - placeable.getHeight()) / 2;
        return MeasureScope.layout$default(measureScope, placeable.getWidth(), iM7224constrainHeightK40F9xA, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$placeIcon$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, height, 0.0f, 4, null);
            }
        }, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: placeLabelAndIcon-DIyivk0, reason: not valid java name */
    public static final MeasureResult m1752placeLabelAndIconDIyivk0(MeasureScope measureScope, final Placeable placeable, final Placeable placeable2, long j, final float f) {
        int i = measureScope.mo671roundToPx0680j_4(CombinedItemTextBaseline) - placeable.get(AlignmentLineKt.getFirstBaseline());
        int height = placeable2.getHeight() + placeable.getHeight() + i;
        int iM7224constrainHeightK40F9xA = ConstraintsKt.m7224constrainHeightK40F9xA(j, Math.max(height, measureScope.mo671roundToPx0680j_4(BottomNavigationHeight)));
        final int iCoerceAtLeast = RangesKt.coerceAtLeast((iM7224constrainHeightK40F9xA - height) / 2, 0);
        int height2 = (iM7224constrainHeightK40F9xA - placeable2.getHeight()) / 2;
        final int height3 = placeable2.getHeight() + iCoerceAtLeast + i;
        int iMax = Math.max(placeable.getWidth(), placeable2.getWidth());
        final int width = (iMax - placeable.getWidth()) / 2;
        final int width2 = (iMax - placeable2.getWidth()) / 2;
        final int iRoundToInt = MathKt.roundToInt((height2 - iCoerceAtLeast) * (1 - f));
        return MeasureScope.layout$default(measureScope, iMax, iM7224constrainHeightK40F9xA, null, new Function1<Placeable.PlacementScope, Unit>() { // from class: androidx.compose.material.BottomNavigationKt$placeLabelAndIcon$1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
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
                if (f != 0.0f) {
                    Placeable.PlacementScope.placeRelative$default(placementScope, placeable, width, height3 + iRoundToInt, 0.0f, 4, null);
                }
                Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, width2, iCoerceAtLeast + iRoundToInt, 0.0f, 4, null);
            }
        }, 4, null);
    }

    static {
        float f = 12;
        BottomNavigationItemHorizontalPadding = Dp.m7255constructorimpl(f);
        CombinedItemTextBaseline = Dp.m7255constructorimpl(f);
        float f2 = 0;
        ZeroInsets = WindowInsetsKt.m1054WindowInsetsa9UjIt4(Dp.m7255constructorimpl(f2), Dp.m7255constructorimpl(f2), Dp.m7255constructorimpl(f2), Dp.m7255constructorimpl(f2));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float BottomNavigationTransition_Klgx_Pg$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }
}
