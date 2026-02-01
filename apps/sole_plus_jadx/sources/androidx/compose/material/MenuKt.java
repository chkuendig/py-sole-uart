package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.unit.Dp;
import com.android.SdkConstants;
import kotlin.Metadata;

/* compiled from: Menu.kt */
@Metadata(d1 = {"\u0000t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0000\u001aY\u0010\u000f\u001a\u00020\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u00152\u0006\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\u001c\u0010\u001b\u001a\u0018\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00100\u001c¢\u0006\u0002\b\u001e¢\u0006\u0002\b\u001fH\u0001¢\u0006\u0002\u0010 \u001aa\u0010!\u001a\u00020\u00102\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00100#2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010$\u001a\u00020\u00132\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\u001c\u0010\u001b\u001a\u0018\u0012\u0004\u0012\u00020)\u0012\u0004\u0012\u00020\u00100\u001c¢\u0006\u0002\b\u001e¢\u0006\u0002\b\u001fH\u0001¢\u0006\u0002\u0010*\u001a\u001d\u0010+\u001a\u00020\u00162\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-H\u0000¢\u0006\u0002\u0010/\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\u0006\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\u0007\u0010\b\"\u000e\u0010\t\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0016\u0010\f\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0002\u001a\u0004\b\r\u0010\b\"\u000e\u0010\u000e\u001a\u00020\nX\u0080T¢\u0006\u0002\n\u0000¨\u00060²\u0006\n\u00101\u001a\u000202X\u008a\u0084\u0002²\u0006\n\u00103\u001a\u000202X\u008a\u0084\u0002"}, d2 = {"DropdownMenuItemDefaultMaxWidth", "Landroidx/compose/ui/unit/Dp;", "F", "DropdownMenuItemDefaultMinHeight", "DropdownMenuItemDefaultMinWidth", "DropdownMenuItemHorizontalPadding", "DropdownMenuVerticalPadding", "getDropdownMenuVerticalPadding", "()F", "InTransitionDuration", "", "MenuElevation", "MenuVerticalMargin", "getMenuVerticalMargin", "OutTransitionDuration", "DropdownMenuContent", "", "expandedStates", "Landroidx/compose/animation/core/MutableTransitionState;", "", "transformOriginState", "Landroidx/compose/runtime/MutableState;", "Landroidx/compose/ui/graphics/TransformOrigin;", "scrollState", "Landroidx/compose/foundation/ScrollState;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/animation/core/MutableTransitionState;Landroidx/compose/runtime/MutableState;Landroidx/compose/foundation/ScrollState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "DropdownMenuItemContent", SdkConstants.ATTR_ON_CLICK, "Lkotlin/Function0;", "enabled", SdkConstants.ATTR_CONTENT_PADDING, "Landroidx/compose/foundation/layout/PaddingValues;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "Landroidx/compose/foundation/layout/RowScope;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "calculateTransformOrigin", "parentBounds", "Landroidx/compose/ui/unit/IntRect;", "menuBounds", "(Landroidx/compose/ui/unit/IntRect;Landroidx/compose/ui/unit/IntRect;)J", "material_release", "scale", "", "alpha"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class MenuKt {
    private static final float DropdownMenuItemDefaultMinHeight;
    private static final float DropdownMenuVerticalPadding;
    public static final int InTransitionDuration = 120;
    private static final float MenuElevation;
    private static final float MenuVerticalMargin;
    public static final int OutTransitionDuration = 75;
    private static final float DropdownMenuItemHorizontalPadding = Dp.m7255constructorimpl(16);
    private static final float DropdownMenuItemDefaultMinWidth = Dp.m7255constructorimpl(112);
    private static final float DropdownMenuItemDefaultMaxWidth = Dp.m7255constructorimpl(280);

    /* JADX WARN: Removed duplicated region for block: B:101:0x01fd  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x0294  */
    /* JADX WARN: Removed duplicated region for block: B:116:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:118:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0080  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00a8  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x0106  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x0110  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x013f  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0144  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0147  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x01d0  */
    /* JADX WARN: Removed duplicated region for block: B:95:0x01d7  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01f7  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void DropdownMenuContent(final androidx.compose.animation.core.MutableTransitionState<java.lang.Boolean> r22, final androidx.compose.runtime.MutableState<androidx.compose.ui.graphics.TransformOrigin> r23, final androidx.compose.foundation.ScrollState r24, androidx.compose.ui.Modifier r25, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r26, androidx.compose.runtime.Composer r27, final int r28, final int r29) {
        /*
            Method dump skipped, instructions count: 695
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.MenuKt.DropdownMenuContent(androidx.compose.animation.core.MutableTransitionState, androidx.compose.runtime.MutableState, androidx.compose.foundation.ScrollState, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01df  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:110:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:112:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0088  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x008b  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a6  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00d3  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x00da  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00e0  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e3  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x00ee  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x011c  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x019c  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x01a8  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x01ac  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void DropdownMenuItemContent(final kotlin.jvm.functions.Function0<kotlin.Unit> r20, androidx.compose.ui.Modifier r21, boolean r22, androidx.compose.foundation.layout.PaddingValues r23, androidx.compose.foundation.interaction.MutableInteractionSource r24, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r25, androidx.compose.runtime.Composer r26, final int r27, final int r28) {
        /*
            Method dump skipped, instructions count: 626
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.MenuKt.DropdownMenuItemContent(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.layout.PaddingValues, androidx.compose.foundation.interaction.MutableInteractionSource, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final float getMenuVerticalMargin() {
        return MenuVerticalMargin;
    }

    public static final float getDropdownMenuVerticalPadding() {
        return DropdownMenuVerticalPadding;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:4:0x000d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long calculateTransformOrigin(androidx.compose.ui.unit.IntRect r5, androidx.compose.ui.unit.IntRect r6) {
        /*
            int r0 = r6.getLeft()
            int r1 = r5.getRight()
            r2 = 1065353216(0x3f800000, float:1.0)
            r3 = 0
            if (r0 < r1) goto Lf
        Ld:
            r0 = r3
            goto L49
        Lf:
            int r0 = r6.getRight()
            int r1 = r5.getLeft()
            if (r0 > r1) goto L1b
            r0 = r2
            goto L49
        L1b:
            int r0 = r6.getWidth()
            if (r0 != 0) goto L22
            goto Ld
        L22:
            int r0 = r5.getLeft()
            int r1 = r6.getLeft()
            int r0 = java.lang.Math.max(r0, r1)
            int r1 = r5.getRight()
            int r4 = r6.getRight()
            int r1 = java.lang.Math.min(r1, r4)
            int r0 = r0 + r1
            int r0 = r0 / 2
            int r1 = r6.getLeft()
            int r0 = r0 - r1
            float r0 = (float) r0
            int r1 = r6.getWidth()
            float r1 = (float) r1
            float r0 = r0 / r1
        L49:
            int r1 = r6.getTop()
            int r4 = r5.getBottom()
            if (r1 < r4) goto L55
        L53:
            r2 = r3
            goto L8f
        L55:
            int r1 = r6.getBottom()
            int r4 = r5.getTop()
            if (r1 > r4) goto L60
            goto L8f
        L60:
            int r1 = r6.getHeight()
            if (r1 != 0) goto L67
            goto L53
        L67:
            int r1 = r5.getTop()
            int r2 = r6.getTop()
            int r1 = java.lang.Math.max(r1, r2)
            int r5 = r5.getBottom()
            int r2 = r6.getBottom()
            int r5 = java.lang.Math.min(r5, r2)
            int r1 = r1 + r5
            int r1 = r1 / 2
            int r5 = r6.getTop()
            int r1 = r1 - r5
            float r5 = (float) r1
            int r6 = r6.getHeight()
            float r6 = (float) r6
            float r2 = r5 / r6
        L8f:
            long r5 = androidx.compose.ui.graphics.TransformOriginKt.TransformOrigin(r0, r2)
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.MenuKt.calculateTransformOrigin(androidx.compose.ui.unit.IntRect, androidx.compose.ui.unit.IntRect):long");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float DropdownMenuContent$lambda$1(State<Float> state) {
        return state.getValue().floatValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final float DropdownMenuContent$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    static {
        float f = 8;
        MenuElevation = Dp.m7255constructorimpl(f);
        float f2 = 48;
        MenuVerticalMargin = Dp.m7255constructorimpl(f2);
        DropdownMenuVerticalPadding = Dp.m7255constructorimpl(f);
        DropdownMenuItemDefaultMinHeight = Dp.m7255constructorimpl(f2);
    }
}
