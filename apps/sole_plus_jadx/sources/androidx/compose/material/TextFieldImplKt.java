package androidx.compose.material;

import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.IntrinsicMeasurable;
import androidx.compose.ui.layout.LayoutIdParentData;
import androidx.compose.ui.layout.Placeable;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.ConstraintsKt;
import androidx.compose.ui.unit.Dp;
import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;

/* compiled from: TextFieldImpl.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aß\u0001\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\f2\u0011\u0010$\u001a\r\u0012\u0004\u0012\u00020 0%¢\u0006\u0002\b&2\u0006\u0010'\u001a\u00020(2\u0013\u0010)\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010*\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010+\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\u0015\b\u0002\u0010,\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&2\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010/\u001a\u00020.2\b\b\u0002\u00100\u001a\u00020.2\u0006\u00101\u001a\u0002022\u0006\u00103\u001a\u0002042\u0006\u00105\u001a\u0002062\u0015\b\u0002\u00107\u001a\u000f\u0012\u0004\u0012\u00020 \u0018\u00010%¢\u0006\u0002\b&H\u0001¢\u0006\u0002\u00108\u001aT\u00109\u001a\u00020 2\u0006\u0010:\u001a\u00020;2\n\b\u0002\u0010<\u001a\u0004\u0018\u00010=2\n\b\u0002\u0010>\u001a\u0004\u0018\u00010?2 \u0010@\u001a\u001c\u0012\u0004\u0012\u00020 0%¢\u0006\u0002\b&¢\u0006\f\bA\u0012\b\bB\u0012\u0004\b\u0003\u0010\u0000H\u0001ø\u0001\u0000¢\u0006\u0004\bC\u0010D\u001a\u0012\u0010E\u001a\u00020\u00012\b\u0010F\u001a\u0004\u0018\u00010GH\u0000\u001a\u0012\u0010H\u001a\u00020\u00012\b\u0010F\u001a\u0004\u0018\u00010GH\u0000\u001a\u001c\u0010I\u001a\u00020\b*\u00020\b2\u0006\u00100\u001a\u00020.2\u0006\u0010J\u001a\u00020\fH\u0000\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0004\u0010\u0005\"\u0014\u0010\u0007\u001a\u00020\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\"\u000e\u0010\u000b\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\r\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000e\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u000f\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0010\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0011\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0012\u001a\u00020\u0003X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0006\u001a\u0004\b\u0013\u0010\u0005\"\u000e\u0010\u0014\u001a\u00020\fX\u0080T¢\u0006\u0002\n\u0000\"\u0016\u0010\u0015\u001a\u00020\u0016X\u0080\u0004¢\u0006\n\n\u0002\u0010\u0019\u001a\u0004\b\u0017\u0010\u0018\"\u001a\u0010\u001a\u001a\u0004\u0018\u00010\u001b*\u00020\u001c8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u001e\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006K"}, d2 = {"AnimationDuration", "", "HorizontalIconPadding", "Landroidx/compose/ui/unit/Dp;", "getHorizontalIconPadding", "()F", "F", "IconDefaultSizeModifier", "Landroidx/compose/ui/Modifier;", "getIconDefaultSizeModifier", "()Landroidx/compose/ui/Modifier;", "LabelId", "", "LeadingId", "PlaceholderAnimationDelayOrDuration", "PlaceholderAnimationDuration", "PlaceholderId", "TextFieldId", "TextFieldPadding", "getTextFieldPadding", "TrailingId", "ZeroConstraints", "Landroidx/compose/ui/unit/Constraints;", "getZeroConstraints", "()J", "J", "layoutId", "", "Landroidx/compose/ui/layout/IntrinsicMeasurable;", "getLayoutId", "(Landroidx/compose/ui/layout/IntrinsicMeasurable;)Ljava/lang/Object;", "CommonDecorationBox", "", "type", "Landroidx/compose/material/TextFieldType;", "value", "innerTextField", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "visualTransformation", "Landroidx/compose/ui/text/input/VisualTransformation;", "label", "placeholder", "leadingIcon", "trailingIcon", "singleLine", "", "enabled", "isError", "interactionSource", "Landroidx/compose/foundation/interaction/InteractionSource;", SdkConstants.ATTR_CONTENT_PADDING, "Landroidx/compose/foundation/layout/PaddingValues;", "colors", "Landroidx/compose/material/TextFieldColors;", OutlinedTextFieldKt.BorderId, "(Landroidx/compose/material/TextFieldType;Ljava/lang/String;Lkotlin/jvm/functions/Function2;Landroidx/compose/ui/text/input/VisualTransformation;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;ZZZLandroidx/compose/foundation/interaction/InteractionSource;Landroidx/compose/foundation/layout/PaddingValues;Landroidx/compose/material/TextFieldColors;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;III)V", "Decoration", "contentColor", "Landroidx/compose/ui/graphics/Color;", "typography", "Landroidx/compose/ui/text/TextStyle;", "contentAlpha", "", "content", "Landroidx/compose/runtime/ComposableOpenTarget;", "index", "Decoration-euL9pac", "(JLandroidx/compose/ui/text/TextStyle;Ljava/lang/Float;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "heightOrZero", "placeable", "Landroidx/compose/ui/layout/Placeable;", "widthOrZero", "defaultErrorSemantics", "defaultErrorMessage", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextFieldImplKt {
    public static final int AnimationDuration = 150;
    private static final Modifier IconDefaultSizeModifier;
    public static final String LabelId = "Label";
    public static final String LeadingId = "Leading";
    private static final int PlaceholderAnimationDelayOrDuration = 67;
    private static final int PlaceholderAnimationDuration = 83;
    public static final String PlaceholderId = "Hint";
    public static final String TextFieldId = "TextField";
    public static final String TrailingId = "Trailing";
    private static final long ZeroConstraints = ConstraintsKt.Constraints(0, 0, 0, 0);
    private static final float TextFieldPadding = Dp.m7255constructorimpl(16);
    private static final float HorizontalIconPadding = Dp.m7255constructorimpl(12);

    /* JADX WARN: Removed duplicated region for block: B:106:0x014f  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0154  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0171  */
    /* JADX WARN: Removed duplicated region for block: B:126:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0188  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x01a0  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x01b6  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01bb  */
    /* JADX WARN: Removed duplicated region for block: B:157:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01fc  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x0202  */
    /* JADX WARN: Removed duplicated region for block: B:168:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0209  */
    /* JADX WARN: Removed duplicated region for block: B:171:0x020d  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0210  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0215  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x021c  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x021e  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0222  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x0224  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x0228  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x022b  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x025d  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x032b  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x0347  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x038a  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x038d  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x03de  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x03f5  */
    /* JADX WARN: Removed duplicated region for block: B:237:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x007b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x007e  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0099  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00cf  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d6  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x012f  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0136  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void CommonDecorationBox(final androidx.compose.material.TextFieldType r37, final java.lang.String r38, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r39, final androidx.compose.ui.text.input.VisualTransformation r40, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r41, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r42, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r43, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r44, boolean r45, boolean r46, boolean r47, final androidx.compose.foundation.interaction.InteractionSource r48, final androidx.compose.foundation.layout.PaddingValues r49, final androidx.compose.material.TextFieldColors r50, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, androidx.compose.runtime.Composer r52, final int r53, final int r54, final int r55) {
        /*
            Method dump skipped, instructions count: 1054
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldImplKt.CommonDecorationBox(androidx.compose.material.TextFieldType, java.lang.String, kotlin.jvm.functions.Function2, androidx.compose.ui.text.input.VisualTransformation, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, boolean, boolean, boolean, androidx.compose.foundation.interaction.InteractionSource, androidx.compose.foundation.layout.PaddingValues, androidx.compose.material.TextFieldColors, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0048  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x004b  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0064  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0067  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:52:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x008c  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x0096  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00ad  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:71:? A[RETURN, SYNTHETIC] */
    /* renamed from: Decoration-euL9pac, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2028DecorationeuL9pac(final long r13, androidx.compose.ui.text.TextStyle r15, java.lang.Float r16, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r17, androidx.compose.runtime.Composer r18, final int r19, final int r20) {
        /*
            Method dump skipped, instructions count: 252
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldImplKt.m2028DecorationeuL9pac(long, androidx.compose.ui.text.TextStyle, java.lang.Float, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
    }

    public static final Modifier defaultErrorSemantics(Modifier modifier, boolean z, final String str) {
        return z ? SemanticsModifierKt.semantics$default(modifier, false, new Function1<SemanticsPropertyReceiver, Unit>() { // from class: androidx.compose.material.TextFieldImplKt.defaultErrorSemantics.1
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
                SemanticsPropertiesKt.error(semanticsPropertyReceiver, str);
            }
        }, 1, null) : modifier;
    }

    public static final int widthOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getWidth();
        }
        return 0;
    }

    public static final int heightOrZero(Placeable placeable) {
        if (placeable != null) {
            return placeable.getHeight();
        }
        return 0;
    }

    public static final Object getLayoutId(IntrinsicMeasurable intrinsicMeasurable) {
        Object parentData = intrinsicMeasurable.getParentData();
        LayoutIdParentData layoutIdParentData = parentData instanceof LayoutIdParentData ? (LayoutIdParentData) parentData : null;
        if (layoutIdParentData != null) {
            return layoutIdParentData.getLayoutId();
        }
        return null;
    }

    static {
        float f = 48;
        IconDefaultSizeModifier = SizeKt.m1014defaultMinSizeVpY3zN4(Modifier.INSTANCE, Dp.m7255constructorimpl(f), Dp.m7255constructorimpl(f));
    }

    public static final long getZeroConstraints() {
        return ZeroConstraints;
    }

    public static final float getTextFieldPadding() {
        return TextFieldPadding;
    }

    public static final float getHorizontalIconPadding() {
        return HorizontalIconPadding;
    }

    public static final Modifier getIconDefaultSizeModifier() {
        return IconDefaultSizeModifier;
    }
}
