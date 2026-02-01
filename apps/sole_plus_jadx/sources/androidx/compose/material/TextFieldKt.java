package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SkippableUpdater;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.DrawModifierKt;
import androidx.compose.ui.geometry.OffsetKt;
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawScope;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.LayoutDirection;
import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;

/* compiled from: TextField.kt */
@Metadata(d1 = {"\u0000\u009e\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\u001a\u0087\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010,\u001a\u0091\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010-\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u0010.\u001a\u0087\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020/2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u00100\u001a\u0091\u0002\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020/2\u0012\u0010\r\u001a\u000e\u0012\u0004\u0012\u00020/\u0012\u0004\u0012\u00020\n0\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00122\b\b\u0002\u0010\u0014\u001a\u00020\u00152\u0015\b\u0002\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\b\b\u0002\u0010\u001c\u001a\u00020\u00122\b\b\u0002\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 2\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020\u00122\b\b\u0002\u0010$\u001a\u00020%2\b\b\u0002\u0010-\u001a\u00020%2\b\b\u0002\u0010&\u001a\u00020'2\b\b\u0002\u0010(\u001a\u00020)2\b\b\u0002\u0010*\u001a\u00020+H\u0007¢\u0006\u0002\u00101\u001a\u009a\u0001\u00102\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0011\u00103\u001a\r\u0012\u0004\u0012\u00020\n0\u0017¢\u0006\u0002\b\u00182\u0013\u0010\u0016\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0019\u0010\u0019\u001a\u0015\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\u000e¢\u0006\u0002\b\u00182\u0013\u00104\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0013\u00105\u001a\u000f\u0012\u0004\u0012\u00020\n\u0018\u00010\u0017¢\u0006\u0002\b\u00182\u0006\u0010#\u001a\u00020\u00122\u0006\u00106\u001a\u0002072\u0006\u00108\u001a\u000209H\u0001¢\u0006\u0002\u0010:\u001aZ\u0010;\u001a\u00020%2\u0006\u0010<\u001a\u00020%2\u0006\u0010=\u001a\u00020\u00122\u0006\u0010>\u001a\u00020%2\u0006\u0010?\u001a\u00020%2\u0006\u0010@\u001a\u00020%2\u0006\u0010A\u001a\u00020%2\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001aB\u0010G\u001a\u00020%2\u0006\u0010H\u001a\u00020%2\u0006\u0010I\u001a\u00020%2\u0006\u0010J\u001a\u00020%2\u0006\u0010K\u001a\u00020%2\u0006\u0010L\u001a\u00020%2\u0006\u0010B\u001a\u00020CH\u0002ø\u0001\u0000¢\u0006\u0004\bM\u0010N\u001a\u0014\u0010O\u001a\u00020\u0010*\u00020\u00102\u0006\u0010P\u001a\u00020QH\u0000\u001at\u0010R\u001a\u00020\n*\u00020S2\u0006\u0010T\u001a\u00020%2\u0006\u0010U\u001a\u00020%2\u0006\u0010V\u001a\u00020W2\b\u0010X\u001a\u0004\u0018\u00010W2\b\u0010Y\u001a\u0004\u0018\u00010W2\b\u0010Z\u001a\u0004\u0018\u00010W2\b\u0010[\u001a\u0004\u0018\u00010W2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010\\\u001a\u00020%2\u0006\u0010]\u001a\u00020%2\u0006\u00106\u001a\u0002072\u0006\u0010D\u001a\u000207H\u0002\u001aZ\u0010^\u001a\u00020\n*\u00020S2\u0006\u0010T\u001a\u00020%2\u0006\u0010U\u001a\u00020%2\u0006\u0010_\u001a\u00020W2\b\u0010Y\u001a\u0004\u0018\u00010W2\b\u0010Z\u001a\u0004\u0018\u00010W2\b\u0010[\u001a\u0004\u0018\u00010W2\u0006\u0010#\u001a\u00020\u00122\u0006\u0010D\u001a\u0002072\u0006\u00108\u001a\u000209H\u0002\"\u0016\u0010\u0000\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0002\u0010\u0003\"\u0016\u0010\u0005\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0003\"\u0016\u0010\u0007\u001a\u00020\u0001X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\b\u0010\u0003\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006`"}, d2 = {"FirstBaselineOffset", "Landroidx/compose/ui/unit/Dp;", "getFirstBaselineOffset", "()F", "F", "TextFieldBottomPadding", "getTextFieldBottomPadding", "TextFieldTopPadding", "getTextFieldTopPadding", "TextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", SdkConstants.ATTR_TEXT_STYLE, "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", SdkConstants.TAG_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "TextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLandroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;I)V", "calculateHeight", "textFieldHeight", "hasLabel", "labelBaseline", "leadingHeight", "trailingHeight", "placeholderHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-O3s9Psw", "(IZIIIIJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingWidth", "trailingWidth", "textFieldWidth", "labelWidth", "placeholderWidth", "calculateWidth-VsPV1Ek", "(IIIIIJ)I", "drawIndicatorLine", "indicatorBorder", "Landroidx/compose/foundation/BorderStroke;", "placeWithLabel", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "width", "height", "textfieldPlaceable", "Landroidx/compose/ui/layout/Placeable;", "labelPlaceable", "placeholderPlaceable", "leadingPlaceable", "trailingPlaceable", "labelEndPosition", "textPosition", "placeWithoutLabel", "textPlaceable", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldKt {
    private static final float FirstBaselineOffset = Dp.m7255constructorimpl(20);
    private static final float TextFieldBottomPadding = Dp.m7255constructorimpl(10);
    private static final float TextFieldTopPadding = Dp.m7255constructorimpl(2);

    /* JADX WARN: Removed duplicated region for block: B:108:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x0454  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x04aa  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x04ca  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x04f5  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0641  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0667  */
    /* JADX WARN: Removed duplicated region for block: B:321:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void TextField(final java.lang.String r101, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r102, androidx.compose.ui.Modifier r103, boolean r104, boolean r105, androidx.compose.ui.text.TextStyle r106, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r107, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r108, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r109, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r110, boolean r111, androidx.compose.ui.text.input.VisualTransformation r112, androidx.compose.foundation.text.KeyboardOptions r113, androidx.compose.foundation.text.KeyboardActions r114, boolean r115, int r116, int r117, androidx.compose.foundation.interaction.MutableInteractionSource r118, androidx.compose.ui.graphics.Shape r119, androidx.compose.material.TextFieldColors r120, androidx.compose.runtime.Composer r121, final int r122, final int r123, final int r124) {
        /*
            Method dump skipped, instructions count: 1668
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.TextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x0408  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x0411  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x047b  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x0486  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x04e4  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x0509  */
    /* JADX WARN: Removed duplicated region for block: B:298:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0139  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void TextField(final java.lang.String r71, final kotlin.jvm.functions.Function1 r72, androidx.compose.ui.Modifier r73, boolean r74, boolean r75, androidx.compose.ui.text.TextStyle r76, kotlin.jvm.functions.Function2 r77, kotlin.jvm.functions.Function2 r78, kotlin.jvm.functions.Function2 r79, kotlin.jvm.functions.Function2 r80, boolean r81, androidx.compose.ui.text.input.VisualTransformation r82, androidx.compose.foundation.text.KeyboardOptions r83, androidx.compose.foundation.text.KeyboardActions r84, boolean r85, int r86, androidx.compose.foundation.interaction.MutableInteractionSource r87, androidx.compose.ui.graphics.Shape r88, androidx.compose.material.TextFieldColors r89, androidx.compose.runtime.Composer r90, final int r91, final int r92, final int r93) {
        /*
            Method dump skipped, instructions count: 1318
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.TextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0220  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0256  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x025e  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x027e  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02b7  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x031b  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x0320  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0324  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x032c  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0354  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x035c  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x035e  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0362  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0364  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x036a  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0374  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0376  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x037a  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0381  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x0385  */
    /* JADX WARN: Removed duplicated region for block: B:271:0x038c  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0392  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x03bc  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x03c2  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x03cb  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03df  */
    /* JADX WARN: Removed duplicated region for block: B:287:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x03e8  */
    /* JADX WARN: Removed duplicated region for block: B:291:0x03ee  */
    /* JADX WARN: Removed duplicated region for block: B:295:0x0414  */
    /* JADX WARN: Removed duplicated region for block: B:298:0x041d  */
    /* JADX WARN: Removed duplicated region for block: B:299:0x042c  */
    /* JADX WARN: Removed duplicated region for block: B:302:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:303:0x0482  */
    /* JADX WARN: Removed duplicated region for block: B:307:0x04a2  */
    /* JADX WARN: Removed duplicated region for block: B:308:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:312:0x04cd  */
    /* JADX WARN: Removed duplicated region for block: B:315:0x0619  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x063f  */
    /* JADX WARN: Removed duplicated region for block: B:321:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00fd  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0134  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x013b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void TextField(final androidx.compose.ui.text.input.TextFieldValue r101, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r102, androidx.compose.ui.Modifier r103, boolean r104, boolean r105, androidx.compose.ui.text.TextStyle r106, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r107, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r108, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r109, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r110, boolean r111, androidx.compose.ui.text.input.VisualTransformation r112, androidx.compose.foundation.text.KeyboardOptions r113, androidx.compose.foundation.text.KeyboardActions r114, boolean r115, int r116, int r117, androidx.compose.foundation.interaction.MutableInteractionSource r118, androidx.compose.ui.graphics.Shape r119, androidx.compose.material.TextFieldColors r120, androidx.compose.runtime.Composer r121, final int r122, final int r123, final int r124) {
        /*
            Method dump skipped, instructions count: 1628
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.TextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01be  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01e1  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0204  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x0251  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x0296  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:243:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:268:0x0397  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x039d  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x03a3  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x03d1  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x03e0  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03e9  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x0436  */
    /* JADX WARN: Removed duplicated region for block: B:288:0x0453  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x045e  */
    /* JADX WARN: Removed duplicated region for block: B:292:0x04bc  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x04e1  */
    /* JADX WARN: Removed duplicated region for block: B:298:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0075  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00b8  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00cc  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00f2  */
    /* JADX WARN: Removed duplicated region for block: B:79:0x00f9  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0139  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void TextField(final androidx.compose.ui.text.input.TextFieldValue r71, final kotlin.jvm.functions.Function1 r72, androidx.compose.ui.Modifier r73, boolean r74, boolean r75, androidx.compose.ui.text.TextStyle r76, kotlin.jvm.functions.Function2 r77, kotlin.jvm.functions.Function2 r78, kotlin.jvm.functions.Function2 r79, kotlin.jvm.functions.Function2 r80, boolean r81, androidx.compose.ui.text.input.VisualTransformation r82, androidx.compose.foundation.text.KeyboardOptions r83, androidx.compose.foundation.text.KeyboardActions r84, boolean r85, int r86, androidx.compose.foundation.interaction.MutableInteractionSource r87, androidx.compose.ui.graphics.Shape r88, androidx.compose.material.TextFieldColors r89, androidx.compose.runtime.Composer r90, final int r91, final int r92, final int r93) {
        /*
            Method dump skipped, instructions count: 1278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldKt.TextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final void TextFieldLayout(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function2<? super Composer, ? super Integer, Unit> function22, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final boolean z, final float f, final PaddingValues paddingValues, Composer composer, final int i) {
        int i2;
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2112507061);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(TextFieldLayout)P(3,7,1,5,2,8,6)487@22599L139,490@22786L7,491@22798L1853:TextField.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function22) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function23) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function24) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(f) ? 8388608 : 4194304;
        }
        if ((234881024 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(paddingValues) ? 67108864 : 33554432;
        }
        if ((191739611 & i2) != 38347922 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2112507061, i2, -1, "androidx.compose.material.TextFieldLayout (TextField.kt:486)");
            }
            Boolean boolValueOf = Boolean.valueOf(z);
            Float fValueOf = Float.valueOf(f);
            composerStartRestartGroup.startReplaceableGroup(1618982084);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(boolValueOf) | composerStartRestartGroup.changed(fValueOf) | composerStartRestartGroup.changed(paddingValues);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new TextFieldMeasurePolicy(z, f, paddingValues);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            TextFieldMeasurePolicy textFieldMeasurePolicy = (TextFieldMeasurePolicy) objRememberedValue;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume;
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf = LayoutKt.modifierMaterializerOf(modifier);
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
            Updater.m3864setimpl(composerM3857constructorimpl, textFieldMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3864setimpl(composerM3857constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3857constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3857constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3857constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3827boximpl(SkippableUpdater.m3828constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 254819939, "C533@24413L183:TextField.kt#jmzs0o");
            composerStartRestartGroup.startReplaceableGroup(254819939);
            ComposerKt.sourceInformation(composerStartRestartGroup, "495@22906L219");
            if (function23 != null) {
                Modifier modifierThen = LayoutIdKt.layoutId(Modifier.INSTANCE, "Leading").then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center = Alignment.INSTANCE.getCenter();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy = BoxKt.rememberBoxMeasurePolicy(center, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf2 = LayoutKt.modifierMaterializerOf(modifierThen);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1767364245, "C499@23098L9:TextField.kt#jmzs0o");
                function23.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(254820224);
            ComposerKt.sourceInformation(composerStartRestartGroup, "503@23192L221");
            if (function24 != null) {
                Modifier modifierThen2 = LayoutIdKt.layoutId(Modifier.INSTANCE, "Trailing").then(TextFieldImplKt.getIconDefaultSizeModifier());
                Alignment center2 = Alignment.INSTANCE.getCenter();
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy2 = BoxKt.rememberBoxMeasurePolicy(center2, false, composerStartRestartGroup, 6);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf3 = LayoutKt.modifierMaterializerOf(modifierThen2);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1767363958, "C507@23385L10:TextField.kt#jmzs0o");
                function24.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 15) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            float fCalculateStartPadding = PaddingKt.calculateStartPadding(paddingValues, layoutDirection);
            float fCalculateEndPadding = PaddingKt.calculateEndPadding(paddingValues, layoutDirection);
            Modifier.Companion companion = Modifier.INSTANCE;
            if (function23 != null) {
                i3 = 0;
                fCalculateStartPadding = Dp.m7255constructorimpl(RangesKt.coerceAtLeast(Dp.m7255constructorimpl(fCalculateStartPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m7255constructorimpl(0)));
            } else {
                i3 = 0;
            }
            float f2 = fCalculateStartPadding;
            if (function24 != null) {
                fCalculateEndPadding = Dp.m7255constructorimpl(RangesKt.coerceAtLeast(Dp.m7255constructorimpl(fCalculateEndPadding - TextFieldImplKt.getHorizontalIconPadding()), Dp.m7255constructorimpl(i3)));
            }
            Modifier modifierM989paddingqDBjuR0$default = PaddingKt.m989paddingqDBjuR0$default(companion, f2, 0.0f, fCalculateEndPadding, 0.0f, 10, null);
            composerStartRestartGroup.startReplaceableGroup(254821235);
            ComposerKt.sourceInformation(composerStartRestartGroup, "528@24206L59");
            if (function3 != null) {
                function3.invoke(LayoutIdKt.layoutId(Modifier.INSTANCE, "Hint").then(modifierM989paddingqDBjuR0$default), composerStartRestartGroup, Integer.valueOf((i2 >> 6) & 112));
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(254821364);
            ComposerKt.sourceInformation(composerStartRestartGroup, "531@24329L57");
            if (function22 != null) {
                Modifier modifierThen3 = LayoutIdKt.layoutId(Modifier.INSTANCE, "Label").then(modifierM989paddingqDBjuR0$default);
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf4 = LayoutKt.modifierMaterializerOf(modifierThen3);
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor4);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM3857constructorimpl4 = Updater.m3857constructorimpl(composerStartRestartGroup);
                Updater.m3864setimpl(composerM3857constructorimpl4, measurePolicyRememberBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m3864setimpl(composerM3857constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM3857constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                    composerM3857constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                    composerM3857constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                }
                function3ModifierMaterializerOf4.invoke(SkippableUpdater.m3827boximpl(SkippableUpdater.m3828constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(2058660585);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1767362966, "C531@24377L7:TextField.kt#jmzs0o");
                function22.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 6) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierThen4 = LayoutIdKt.layoutId(Modifier.INSTANCE, "TextField").then(modifierM989paddingqDBjuR0$default);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composerStartRestartGroup, 48);
            composerStartRestartGroup.startReplaceableGroup(-1323940314);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
            int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
            Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(modifierThen4);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor5);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3857constructorimpl5 = Updater.m3857constructorimpl(composerStartRestartGroup);
            Updater.m3864setimpl(composerM3857constructorimpl5, measurePolicyRememberBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3864setimpl(composerM3857constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3857constructorimpl5.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                composerM3857constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                composerM3857constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
            }
            function3ModifierMaterializerOf5.invoke(SkippableUpdater.m3827boximpl(SkippableUpdater.m3828constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1253629263, "C73@3426L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1767362772, "C537@24571L11:TextField.kt#jmzs0o");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextFieldKt.TextFieldLayout.2
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
                    TextFieldKt.TextFieldLayout(modifier, function2, function22, function3, function23, function24, z, f, paddingValues, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-VsPV1Ek, reason: not valid java name */
    public static final int m2035calculateWidthVsPV1Ek(int i, int i2, int i3, int i4, int i5, long j) {
        return Math.max(i + Math.max(i3, Math.max(i4, i5)) + i2, Constraints.m7210getMinWidthimpl(j));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-O3s9Psw, reason: not valid java name */
    public static final int m2034calculateHeightO3s9Psw(int i, boolean z, int i2, int i3, int i4, int i5, long j, float f, PaddingValues paddingValues) {
        float f2 = TextFieldTopPadding * f;
        float top = paddingValues.getTop() * f;
        float bottom = paddingValues.getBottom() * f;
        int iMax = Math.max(i, i5);
        return Math.max(MathKt.roundToInt(z ? i2 + f2 + iMax + bottom : top + iMax + bottom), Math.max(Math.max(i3, i4), Constraints.m7209getMinHeightimpl(j)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, boolean z, int i3, int i4, float f, float f2) {
        int iRoundToInt;
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, 0, Alignment.INSTANCE.getCenterVertically().align(placeable4.getHeight(), i2), 0.0f, 4, null);
        }
        if (placeable5 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, i - placeable5.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable5.getHeight(), i2), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            if (z) {
                iRoundToInt = Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), i2);
            } else {
                iRoundToInt = MathKt.roundToInt(TextFieldImplKt.getTextFieldPadding() * f2);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, TextFieldImplKt.widthOrZero(placeable4), iRoundToInt - MathKt.roundToInt((iRoundToInt - i3) * f), 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, TextFieldImplKt.widthOrZero(placeable4), i4, 0.0f, 4, null);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, TextFieldImplKt.widthOrZero(placeable4), i4, 0.0f, 4, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void placeWithoutLabel(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, boolean z, float f, PaddingValues paddingValues) {
        int iRoundToInt = MathKt.roundToInt(paddingValues.getTop() * f);
        if (placeable3 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, 0, Alignment.INSTANCE.getCenterVertically().align(placeable3.getHeight(), i2), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, i - placeable4.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable4.getHeight(), i2), 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable, TextFieldImplKt.widthOrZero(placeable3), z ? Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), i2) : iRoundToInt, 0.0f, 4, null);
        if (placeable2 != null) {
            if (z) {
                iRoundToInt = Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), i2);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, TextFieldImplKt.widthOrZero(placeable3), iRoundToInt, 0.0f, 4, null);
        }
    }

    public static final Modifier drawIndicatorLine(Modifier modifier, final BorderStroke borderStroke) {
        final float width = borderStroke.getWidth();
        return DrawModifierKt.drawWithContent(modifier, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material.TextFieldKt.drawIndicatorLine.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ContentDrawScope contentDrawScope) {
                invoke2(contentDrawScope);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ContentDrawScope contentDrawScope) {
                contentDrawScope.drawContent();
                if (Dp.m7260equalsimpl0(width, Dp.INSTANCE.m7273getHairlineD9Ej5fM())) {
                    return;
                }
                float density = width * contentDrawScope.getDensity();
                float fM4360getHeightimpl = Size.m4360getHeightimpl(contentDrawScope.mo5117getSizeNHjbRc()) - (density / 2);
                DrawScope.m5102drawLine1RTmtNc$default(contentDrawScope, borderStroke.getBrush(), OffsetKt.Offset(0.0f, fM4360getHeightimpl), OffsetKt.Offset(Size.m4363getWidthimpl(contentDrawScope.mo5117getSizeNHjbRc()), fM4360getHeightimpl), density, 0, null, 0.0f, null, 0, 496, null);
            }
        });
    }

    public static final float getFirstBaselineOffset() {
        return FirstBaselineOffset;
    }

    public static final float getTextFieldBottomPadding() {
        return TextFieldBottomPadding;
    }

    public static final float getTextFieldTopPadding() {
        return TextFieldTopPadding;
    }
}
