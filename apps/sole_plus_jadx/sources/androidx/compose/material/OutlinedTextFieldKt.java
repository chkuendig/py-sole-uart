package androidx.compose.material;

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
import androidx.compose.ui.geometry.Size;
import androidx.compose.ui.graphics.ClipOp;
import androidx.compose.ui.graphics.drawscope.ContentDrawScope;
import androidx.compose.ui.graphics.drawscope.DrawContext;
import androidx.compose.ui.layout.LayoutIdKt;
import androidx.compose.ui.layout.LayoutKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Constraints;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.util.MathHelpersKt;
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

/* compiled from: OutlinedTextField.kt */
@Metadata(d1 = {"\u0000¤\u0001\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\u001a\u0087\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010+\u001a\u0091\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010,\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010-\u001a\u0087\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010.\u001a\u0091\u0002\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00012\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0001\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00142\u0015\b\u0002\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0018\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u0019\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\b\b\u0002\u0010\u001b\u001a\u00020\u00112\b\b\u0002\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020!2\b\b\u0002\u0010\"\u001a\u00020\u00112\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010,\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020(2\b\b\u0002\u0010)\u001a\u00020*H\u0007¢\u0006\u0002\u0010/\u001aÁ\u0001\u00100\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\u000f2\u0011\u00101\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\b\u00172\u0019\u0010\u0018\u001a\u0015\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\r¢\u0006\u0002\b\u00172\u0013\u0010\u0015\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u00102\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0013\u00103\u001a\u000f\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016¢\u0006\u0002\b\u00172\u0006\u0010\"\u001a\u00020\u00112\u0006\u00104\u001a\u0002052\u0012\u00106\u001a\u000e\u0012\u0004\u0012\u000207\u0012\u0004\u0012\u00020\t0\r2\u0011\u00108\u001a\r\u0012\u0004\u0012\u00020\t0\u0016¢\u0006\u0002\b\u00172\u0006\u00109\u001a\u00020:H\u0001¢\u0006\u0002\u0010;\u001aZ\u0010<\u001a\u00020$2\u0006\u0010=\u001a\u00020$2\u0006\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020$2\u0006\u0010@\u001a\u00020$2\u0006\u0010A\u001a\u00020$2\u0006\u00104\u001a\u0002052\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002052\u0006\u00109\u001a\u00020:H\u0002ø\u0001\u0000¢\u0006\u0004\bE\u0010F\u001aZ\u0010G\u001a\u00020$2\u0006\u0010H\u001a\u00020$2\u0006\u0010I\u001a\u00020$2\u0006\u0010J\u001a\u00020$2\u0006\u0010K\u001a\u00020$2\u0006\u0010L\u001a\u00020$2\u0006\u00104\u001a\u0002052\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u0002052\u0006\u00109\u001a\u00020:H\u0002ø\u0001\u0000¢\u0006\u0004\bM\u0010F\u001a&\u0010N\u001a\u00020\u000f*\u00020\u000f2\u0006\u0010O\u001a\u0002072\u0006\u00109\u001a\u00020:H\u0000ø\u0001\u0000¢\u0006\u0004\bP\u0010Q\u001a|\u0010R\u001a\u00020\t*\u00020S2\u0006\u0010T\u001a\u00020$2\u0006\u0010U\u001a\u00020$2\b\u0010V\u001a\u0004\u0018\u00010W2\b\u0010X\u001a\u0004\u0018\u00010W2\u0006\u0010Y\u001a\u00020W2\b\u0010Z\u001a\u0004\u0018\u00010W2\b\u0010[\u001a\u0004\u0018\u00010W2\u0006\u0010\\\u001a\u00020W2\u0006\u00104\u001a\u0002052\u0006\u0010\"\u001a\u00020\u00112\u0006\u0010D\u001a\u0002052\u0006\u0010]\u001a\u00020^2\u0006\u00109\u001a\u00020:H\u0002\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0010\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0004\"\u0016\u0010\u0005\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0004\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006_"}, d2 = {"BorderId", "", "OutlinedTextFieldInnerPadding", "Landroidx/compose/ui/unit/Dp;", "F", "OutlinedTextFieldTopPadding", "getOutlinedTextFieldTopPadding", "()F", "OutlinedTextField", "", "value", "Landroidx/compose/ui/text/input/TextFieldValue;", "onValueChange", "Lkotlin/Function1;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "readOnly", SdkConstants.ATTR_TEXT_STYLE, "Landroidx/compose/ui/text/TextStyle;", "label", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "placeholder", "leadingIcon", "trailingIcon", "isError", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "keyboardOptions", "Landroidx/compose/foundation/text/KeyboardOptions;", "keyboardActions", "Landroidx/compose/foundation/text/KeyboardActions;", "singleLine", "maxLines", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", SdkConstants.TAG_SHAPE, "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material/TextFieldColors;", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "minLines", "(Landroidx/compose/ui/text/input/TextFieldValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZZLandroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZLandroidx/compose/ui/text/input/VisualTransformation;Landroidx/compose/foundation/text/KeyboardOptions;Landroidx/compose/foundation/text/KeyboardActions;ZIILandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material/TextFieldColors;Landroidx/compose/runtime/Composer;III)V", "OutlinedTextFieldLayout", "textField", "leading", "trailing", "animationProgress", "", "onLabelMeasured", "Landroidx/compose/ui/geometry/Size;", OutlinedTextFieldKt.BorderId, "paddingValues", "Landroidx/compose/foundation/layout/PaddingValues;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZFLkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function2;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/runtime/Composer;II)V", "calculateHeight", "leadingPlaceableHeight", "trailingPlaceableHeight", "textFieldPlaceableHeight", "labelPlaceableHeight", "placeholderPlaceableHeight", "constraints", "Landroidx/compose/ui/unit/Constraints;", "density", "calculateHeight-O3s9Psw", "(IIIIIFJFLandroidx/compose/foundation/layout/PaddingValues;)I", "calculateWidth", "leadingPlaceableWidth", "trailingPlaceableWidth", "textFieldPlaceableWidth", "labelPlaceableWidth", "placeholderPlaceableWidth", "calculateWidth-O3s9Psw", "outlineCutout", "labelSize", "outlineCutout-12SF9DM", "(Landroidx/compose/ui/Modifier;JLandroidx/compose/foundation/layout/PaddingValues;)Landroidx/compose/ui/Modifier;", "place", "Landroidx/compose/ui/layout/Placeable$PlacementScope;", "height", "width", "leadingPlaceable", "Landroidx/compose/ui/layout/Placeable;", "trailingPlaceable", "textFieldPlaceable", "labelPlaceable", "placeholderPlaceable", "borderPlaceable", "layoutDirection", "Landroidx/compose/ui/unit/LayoutDirection;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class OutlinedTextFieldKt {
    public static final String BorderId = "border";
    private static final float OutlinedTextFieldInnerPadding = Dp.m7255constructorimpl(4);
    private static final float OutlinedTextFieldTopPadding = Dp.m7255constructorimpl(8);

    /* JADX WARN: Removed duplicated region for block: B:108:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0159  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0176  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0192  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01af  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0208  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x020f  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x022d  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0246  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x025c  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0264  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x0278  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x0284  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x031c  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0327  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x032d  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:252:0x035f  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0363  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0365  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x0369  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x036b  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x036f  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x0375  */
    /* JADX WARN: Removed duplicated region for block: B:264:0x0377  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x037b  */
    /* JADX WARN: Removed duplicated region for block: B:267:0x0382  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0386  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:272:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x039e  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x03a7  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:283:0x03bb  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x03c1  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x03ca  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x03f0  */
    /* JADX WARN: Removed duplicated region for block: B:296:0x03f9  */
    /* JADX WARN: Removed duplicated region for block: B:297:0x040e  */
    /* JADX WARN: Removed duplicated region for block: B:300:0x0418  */
    /* JADX WARN: Removed duplicated region for block: B:301:0x0464  */
    /* JADX WARN: Removed duplicated region for block: B:305:0x0484  */
    /* JADX WARN: Removed duplicated region for block: B:306:0x0491  */
    /* JADX WARN: Removed duplicated region for block: B:310:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:313:0x050b  */
    /* JADX WARN: Removed duplicated region for block: B:314:0x0533  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0604  */
    /* JADX WARN: Removed duplicated region for block: B:321:0x062a  */
    /* JADX WARN: Removed duplicated region for block: B:323:? A[RETURN, SYNTHETIC] */
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
    public static final void OutlinedTextField(final java.lang.String r101, final kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> r102, androidx.compose.ui.Modifier r103, boolean r104, boolean r105, androidx.compose.ui.text.TextStyle r106, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r107, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r108, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r109, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r110, boolean r111, androidx.compose.ui.text.input.VisualTransformation r112, androidx.compose.foundation.text.KeyboardOptions r113, androidx.compose.foundation.text.KeyboardActions r114, boolean r115, int r116, int r117, androidx.compose.foundation.interaction.MutableInteractionSource r118, androidx.compose.ui.graphics.Shape r119, androidx.compose.material.TextFieldColors r120, androidx.compose.runtime.Composer r121, final int r122, final int r123, final int r124) {
        /*
            Method dump skipped, instructions count: 1607
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x0152  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0157  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x0174  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01aa  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c5  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01e7  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0205  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x020a  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0225  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0241  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x0257  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x0263  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02ec  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02ee  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02f9  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02fd  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02ff  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0325  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x032e  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0330  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0334  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0336  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x033a  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x033c  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0345  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0352  */
    /* JADX WARN: Removed duplicated region for block: B:256:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:257:0x035d  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x036c  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:265:0x0372  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0378  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x037e  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x03a4  */
    /* JADX WARN: Removed duplicated region for block: B:276:0x03ac  */
    /* JADX WARN: Removed duplicated region for block: B:277:0x03c0  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0055  */
    /* JADX WARN: Removed duplicated region for block: B:280:0x03c9  */
    /* JADX WARN: Removed duplicated region for block: B:281:0x0416  */
    /* JADX WARN: Removed duplicated region for block: B:285:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:286:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:289:0x049c  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x04c1  */
    /* JADX WARN: Removed duplicated region for block: B:295:? A[RETURN, SYNTHETIC] */
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
    public static final /* synthetic */ void OutlinedTextField(final java.lang.String r71, final kotlin.jvm.functions.Function1 r72, androidx.compose.ui.Modifier r73, boolean r74, boolean r75, androidx.compose.ui.text.TextStyle r76, kotlin.jvm.functions.Function2 r77, kotlin.jvm.functions.Function2 r78, kotlin.jvm.functions.Function2 r79, kotlin.jvm.functions.Function2 r80, boolean r81, androidx.compose.ui.text.input.VisualTransformation r82, androidx.compose.foundation.text.KeyboardOptions r83, androidx.compose.foundation.text.KeyboardActions r84, boolean r85, int r86, androidx.compose.foundation.interaction.MutableInteractionSource r87, androidx.compose.ui.graphics.Shape r88, androidx.compose.material.TextFieldColors r89, androidx.compose.runtime.Composer r90, final int r91, final int r92, final int r93) {
        /*
            Method dump skipped, instructions count: 1246
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField(java.lang.String, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
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
    /* JADX WARN: Removed duplicated region for block: B:315:0x0529  */
    /* JADX WARN: Removed duplicated region for block: B:316:0x0551  */
    /* JADX WARN: Removed duplicated region for block: B:319:0x0622  */
    /* JADX WARN: Removed duplicated region for block: B:323:0x0648  */
    /* JADX WARN: Removed duplicated region for block: B:325:? A[RETURN, SYNTHETIC] */
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
    public static final void OutlinedTextField(final androidx.compose.ui.text.input.TextFieldValue r101, final kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.input.TextFieldValue, kotlin.Unit> r102, androidx.compose.ui.Modifier r103, boolean r104, boolean r105, androidx.compose.ui.text.TextStyle r106, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r107, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r108, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r109, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r110, boolean r111, androidx.compose.ui.text.input.VisualTransformation r112, androidx.compose.foundation.text.KeyboardOptions r113, androidx.compose.foundation.text.KeyboardActions r114, boolean r115, int r116, int r117, androidx.compose.foundation.interaction.MutableInteractionSource r118, androidx.compose.ui.graphics.Shape r119, androidx.compose.material.TextFieldColors r120, androidx.compose.runtime.Composer r121, final int r122, final int r123, final int r124) {
        /*
            Method dump skipped, instructions count: 1637
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
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
    public static final /* synthetic */ void OutlinedTextField(final androidx.compose.ui.text.input.TextFieldValue r71, final kotlin.jvm.functions.Function1 r72, androidx.compose.ui.Modifier r73, boolean r74, boolean r75, androidx.compose.ui.text.TextStyle r76, kotlin.jvm.functions.Function2 r77, kotlin.jvm.functions.Function2 r78, kotlin.jvm.functions.Function2 r79, kotlin.jvm.functions.Function2 r80, boolean r81, androidx.compose.ui.text.input.VisualTransformation r82, androidx.compose.foundation.text.KeyboardOptions r83, androidx.compose.foundation.text.KeyboardActions r84, boolean r85, int r86, androidx.compose.foundation.interaction.MutableInteractionSource r87, androidx.compose.ui.graphics.Shape r88, androidx.compose.material.TextFieldColors r89, androidx.compose.runtime.Composer r90, final int r91, final int r92, final int r93) {
        /*
            Method dump skipped, instructions count: 1278
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextField(androidx.compose.ui.text.input.TextFieldValue, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, boolean, boolean, androidx.compose.ui.text.TextStyle, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, androidx.compose.ui.text.input.VisualTransformation, androidx.compose.foundation.text.KeyboardOptions, androidx.compose.foundation.text.KeyboardActions, boolean, int, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.material.TextFieldColors, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final void OutlinedTextFieldLayout(final Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super Modifier, ? super Composer, ? super Integer, Unit> function3, final Function2<? super Composer, ? super Integer, Unit> function22, final Function2<? super Composer, ? super Integer, Unit> function23, final Function2<? super Composer, ? super Integer, Unit> function24, final boolean z, final float f, final Function1<? super Size, Unit> function1, final Function2<? super Composer, ? super Integer, Unit> function25, final PaddingValues paddingValues, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-2049536174);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedTextFieldLayout)P(4,9,7,2,3,10,8!1,5)493@22963L239,501@23250L7,502@23262L2308:OutlinedTextField.kt#jmzs0o");
        int i4 = (i & 14) == 0 ? i | (composerStartRestartGroup.changed(modifier) ? 4 : 2) : i;
        if ((i & 112) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if ((i & 7168) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function22) ? 2048 : 1024;
        }
        if ((57344 & i) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function23) ? 16384 : 8192;
        }
        if ((458752 & i) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function24) ? 131072 : 65536;
        }
        if ((3670016 & i) == 0) {
            i4 |= composerStartRestartGroup.changed(z) ? 1048576 : 524288;
        }
        if ((29360128 & i) == 0) {
            i4 |= composerStartRestartGroup.changed(f) ? 8388608 : 4194304;
        }
        if ((234881024 & i) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 67108864 : 33554432;
        }
        if ((1879048192 & i) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function25) ? 536870912 : 268435456;
        }
        int i5 = i4;
        int i6 = (i2 & 14) == 0 ? i2 | (composerStartRestartGroup.changed(paddingValues) ? 4 : 2) : i2;
        if ((i5 & 1533916891) != 306783378 || (i6 & 11) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2049536174, i5, i6, "androidx.compose.material.OutlinedTextFieldLayout (OutlinedTextField.kt:492)");
            }
            Object[] objArr = {function1, Boolean.valueOf(z), Float.valueOf(f), paddingValues};
            composerStartRestartGroup.startReplaceableGroup(-568225417);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember)P(1):Composables.kt#9igjgp");
            int i7 = 0;
            boolean zChanged = false;
            for (int i8 = 4; i7 < i8; i8 = 4) {
                zChanged |= composerStartRestartGroup.changed(objArr[i7]);
                i7++;
            }
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new OutlinedTextFieldMeasurePolicy(function1, z, f, paddingValues);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceableGroup();
            OutlinedTextFieldMeasurePolicy outlinedTextFieldMeasurePolicy = (OutlinedTextFieldMeasurePolicy) objRememberedValue;
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
            Updater.m3864setimpl(composerM3857constructorimpl, outlinedTextFieldMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3864setimpl(composerM3857constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3857constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3857constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3857constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            function3ModifierMaterializerOf.invoke(SkippableUpdater.m3827boximpl(SkippableUpdater.m3828constructorimpl(composerStartRestartGroup)), composerStartRestartGroup, 0);
            composerStartRestartGroup.startReplaceableGroup(2058660585);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1169918312, "C510@23766L8,549@25214L182:OutlinedTextField.kt#jmzs0o");
            function25.invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 27) & 14));
            composerStartRestartGroup.startReplaceableGroup(1169918334);
            ComposerKt.sourceInformation(composerStartRestartGroup, "513@23827L219");
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -905297530, "C517@24019L9:OutlinedTextField.kt#jmzs0o");
                function23.invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 12) & 14));
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endReplaceableGroup();
                composerStartRestartGroup.endReplaceableGroup();
            }
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(1169918619);
            ComposerKt.sourceInformation(composerStartRestartGroup, "521@24113L221");
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -905297243, "C525@24306L10:OutlinedTextField.kt#jmzs0o");
                function24.invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 15) & 14));
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
            composerStartRestartGroup.startReplaceableGroup(1169919630);
            ComposerKt.sourceInformation(composerStartRestartGroup, "546@25127L59");
            if (function3 != null) {
                function3.invoke(LayoutIdKt.layoutId(Modifier.INSTANCE, "Hint").then(modifierM989paddingqDBjuR0$default), composerStartRestartGroup, Integer.valueOf((i5 >> 3) & 112));
            }
            composerStartRestartGroup.endReplaceableGroup();
            Modifier modifierThen3 = LayoutIdKt.layoutId(Modifier.INSTANCE, "TextField").then(modifierM989paddingqDBjuR0$default);
            composerStartRestartGroup.startReplaceableGroup(733328855);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyRememberBoxMeasurePolicy3 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), true, composerStartRestartGroup, 48);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -905296178, "C553@25371L11:OutlinedTextField.kt#jmzs0o");
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 3) & 14));
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.endReplaceableGroup();
            composerStartRestartGroup.startReplaceableGroup(-614207693);
            ComposerKt.sourceInformation(composerStartRestartGroup, "557@25447L54");
            if (function22 != null) {
                Modifier modifierLayoutId = LayoutIdKt.layoutId(Modifier.INSTANCE, "Label");
                composerStartRestartGroup.startReplaceableGroup(733328855);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Box)P(2,1,3)71@3309L67,72@3381L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyRememberBoxMeasurePolicy4 = BoxKt.rememberBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false, composerStartRestartGroup, 0);
                composerStartRestartGroup.startReplaceableGroup(-1323940314);
                ComposerKt.sourceInformation(composerStartRestartGroup, "CC(Layout)P(!1,2)77@3132L23,79@3222L420:Layout.kt#80mrfh");
                int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
                CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                Function3<SkippableUpdater<ComposeUiNode>, Composer, Integer, Unit> function3ModifierMaterializerOf5 = LayoutKt.modifierMaterializerOf(modifierLayoutId);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -905296057, "C557@25492L7:OutlinedTextField.kt#jmzs0o");
                function22.invoke(composerStartRestartGroup, Integer.valueOf((i5 >> 9) & 14));
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt.OutlinedTextFieldLayout.2
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

                public final void invoke(Composer composer2, int i9) {
                    OutlinedTextFieldKt.OutlinedTextFieldLayout(modifier, function2, function3, function22, function23, function24, z, f, function1, function25, paddingValues, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2));
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateWidth-O3s9Psw, reason: not valid java name */
    public static final int m1919calculateWidthO3s9Psw(int i, int i2, int i3, int i4, int i5, float f, long j, float f2, PaddingValues paddingValues) {
        return Math.max(i + Math.max(i3, Math.max(MathHelpersKt.lerp(i4, 0, f), i5)) + i2, Math.max(MathKt.roundToInt((i4 + (Dp.m7255constructorimpl(paddingValues.mo936calculateLeftPaddingu2uoSUM(LayoutDirection.Ltr) + paddingValues.mo937calculateRightPaddingu2uoSUM(LayoutDirection.Ltr)) * f2)) * f), Constraints.m7210getMinWidthimpl(j)));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: calculateHeight-O3s9Psw, reason: not valid java name */
    public static final int m1918calculateHeightO3s9Psw(int i, int i2, int i3, int i4, int i5, float f, long j, float f2, PaddingValues paddingValues) {
        int iMax = Math.max(i3, Math.max(i5, MathHelpersKt.lerp(i4, 0, f)));
        float top = paddingValues.getTop() * f2;
        return Math.max(Constraints.m7209getMinHeightimpl(j), Math.max(i, Math.max(i2, MathKt.roundToInt(MathHelpersKt.lerp(top, Math.max(top, i4 / 2.0f), f) + iMax + (paddingValues.getBottom() * f2)))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void place(Placeable.PlacementScope placementScope, int i, int i2, Placeable placeable, Placeable placeable2, Placeable placeable3, Placeable placeable4, Placeable placeable5, Placeable placeable6, float f, boolean z, float f2, LayoutDirection layoutDirection, PaddingValues paddingValues) {
        int iRoundToInt = MathKt.roundToInt(paddingValues.getTop() * f2);
        int iRoundToInt2 = MathKt.roundToInt(PaddingKt.calculateStartPadding(paddingValues, layoutDirection) * f2);
        float horizontalIconPadding = TextFieldImplKt.getHorizontalIconPadding() * f2;
        if (placeable != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable, 0, Alignment.INSTANCE.getCenterVertically().align(placeable.getHeight(), i), 0.0f, 4, null);
        }
        if (placeable2 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable2, i2 - placeable2.getWidth(), Alignment.INSTANCE.getCenterVertically().align(placeable2.getHeight(), i), 0.0f, 4, null);
        }
        if (placeable4 != null) {
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable4, MathKt.roundToInt(placeable == null ? 0.0f : (TextFieldImplKt.widthOrZero(placeable) - horizontalIconPadding) * (1 - f)) + iRoundToInt2, MathHelpersKt.lerp(z ? Alignment.INSTANCE.getCenterVertically().align(placeable4.getHeight(), i) : iRoundToInt, -(placeable4.getHeight() / 2), f), 0.0f, 4, null);
        }
        Placeable.PlacementScope.placeRelative$default(placementScope, placeable3, TextFieldImplKt.widthOrZero(placeable), Math.max(z ? Alignment.INSTANCE.getCenterVertically().align(placeable3.getHeight(), i) : iRoundToInt, TextFieldImplKt.heightOrZero(placeable4) / 2), 0.0f, 4, null);
        if (placeable5 != null) {
            if (z) {
                iRoundToInt = Alignment.INSTANCE.getCenterVertically().align(placeable5.getHeight(), i);
            }
            Placeable.PlacementScope.placeRelative$default(placementScope, placeable5, TextFieldImplKt.widthOrZero(placeable), Math.max(iRoundToInt, TextFieldImplKt.heightOrZero(placeable4) / 2), 0.0f, 4, null);
        }
        Placeable.PlacementScope.m6022place70tqf50$default(placementScope, placeable6, IntOffset.INSTANCE.m7394getZeronOccac(), 0.0f, 2, null);
    }

    /* renamed from: outlineCutout-12SF9DM, reason: not valid java name */
    public static final Modifier m1920outlineCutout12SF9DM(Modifier modifier, final long j, final PaddingValues paddingValues) {
        return DrawModifierKt.drawWithContent(modifier, new Function1<ContentDrawScope, Unit>() { // from class: androidx.compose.material.OutlinedTextFieldKt$outlineCutout$1

            /* compiled from: OutlinedTextField.kt */
            @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[LayoutDirection.values().length];
                    try {
                        iArr[LayoutDirection.Rtl.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

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
                float fCoerceAtLeast;
                float fM4363getWidthimpl = Size.m4363getWidthimpl(j);
                if (fM4363getWidthimpl > 0.0f) {
                    float f = contentDrawScope.mo677toPx0680j_4(OutlinedTextFieldKt.OutlinedTextFieldInnerPadding);
                    float f2 = contentDrawScope.mo677toPx0680j_4(paddingValues.mo936calculateLeftPaddingu2uoSUM(contentDrawScope.getLayoutDirection())) - f;
                    float f3 = 2;
                    float fM4363getWidthimpl2 = fM4363getWidthimpl + f2 + (f * f3);
                    if (WhenMappings.$EnumSwitchMapping$0[contentDrawScope.getLayoutDirection().ordinal()] == 1) {
                        fCoerceAtLeast = Size.m4363getWidthimpl(contentDrawScope.mo5117getSizeNHjbRc()) - fM4363getWidthimpl2;
                    } else {
                        fCoerceAtLeast = RangesKt.coerceAtLeast(f2, 0.0f);
                    }
                    float f4 = fCoerceAtLeast;
                    if (WhenMappings.$EnumSwitchMapping$0[contentDrawScope.getLayoutDirection().ordinal()] == 1) {
                        fM4363getWidthimpl2 = Size.m4363getWidthimpl(contentDrawScope.mo5117getSizeNHjbRc()) - RangesKt.coerceAtLeast(f2, 0.0f);
                    }
                    float f5 = fM4363getWidthimpl2;
                    float fM4360getHeightimpl = Size.m4360getHeightimpl(j);
                    float f6 = (-fM4360getHeightimpl) / f3;
                    float f7 = fM4360getHeightimpl / f3;
                    int iM4526getDifferencertfAjoo = ClipOp.INSTANCE.m4526getDifferencertfAjoo();
                    DrawContext drawContext = contentDrawScope.getDrawContext();
                    long jMo5038getSizeNHjbRc = drawContext.mo5038getSizeNHjbRc();
                    drawContext.getCanvas().save();
                    drawContext.getTransform().mo5041clipRectN_I0leg(f4, f6, f5, f7, iM4526getDifferencertfAjoo);
                    contentDrawScope.drawContent();
                    drawContext.getCanvas().restore();
                    drawContext.mo5039setSizeuvyYCjk(jMo5038getSizeNHjbRc);
                    return;
                }
                contentDrawScope.drawContent();
            }
        });
    }

    public static final float getOutlinedTextFieldTopPadding() {
        return OutlinedTextFieldTopPadding;
    }
}
