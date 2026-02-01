package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.unit.Dp;
import com.android.SdkConstants;
import kotlin.Metadata;

/* compiled from: Chip.kt */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u001a\u008e\u0001\u0010\n\u001a\u00020\u000b2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020\u00192\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b0\u001d¢\u0006\u0002\b\u001b¢\u0006\u0002\b\u001fH\u0007¢\u0006\u0002\u0010 \u001aÄ\u0001\u0010!\u001a\u00020\u000b2\u0006\u0010\"\u001a\u00020\u00112\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000b0\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00152\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0002\u0010\u0018\u001a\u00020#2\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u0015\b\u0002\u0010$\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u0015\b\u0002\u0010%\u001a\u000f\u0012\u0004\u0012\u00020\u000b\u0018\u00010\r¢\u0006\u0002\b\u001b2\u001c\u0010\u001c\u001a\u0018\u0012\u0004\u0012\u00020\u001e\u0012\u0004\u0012\u00020\u000b0\u001d¢\u0006\u0002\b\u001b¢\u0006\u0002\b\u001fH\u0007¢\u0006\u0002\u0010&\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0003\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0004\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u0010\u0010\u0005\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002\"\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010\t\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006'²\u0006\n\u0010(\u001a\u00020)X\u008a\u0084\u0002²\u0006\n\u0010*\u001a\u00020)X\u008a\u0084\u0002"}, d2 = {"HorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "LeadingIconEndSpacing", "LeadingIconStartSpacing", "SelectedIconContainerSize", "SelectedOverlayOpacity", "", "SurfaceOverlayOpacity", "TrailingIconSpacing", "Chip", "", SdkConstants.ATTR_ON_CLICK, "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", SdkConstants.TAG_SHAPE, "Landroidx/compose/ui/graphics/Shape;", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ChipColors;", "leadingIcon", "Landroidx/compose/runtime/Composable;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FilterChip", "selected", "Landroidx/compose/material/SelectableChipColors;", "selectedIcon", "trailingIcon", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/SelectableChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "material_release", "contentColor", "Landroidx/compose/ui/graphics/Color;", "leadingIconContentColor"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class ChipKt {
    private static final float LeadingIconEndSpacing;
    private static final float SelectedOverlayOpacity = 0.16f;
    private static final float SurfaceOverlayOpacity = 0.12f;
    private static final float TrailingIconSpacing;
    private static final float HorizontalPadding = Dp.m7255constructorimpl(12);
    private static final float LeadingIconStartSpacing = Dp.m7255constructorimpl(4);
    private static final float SelectedIconContainerSize = Dp.m7255constructorimpl(24);

    /* JADX WARN: Removed duplicated region for block: B:102:0x0127  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x013c  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x016c  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x016e  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0173  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:125:0x017a  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x019e  */
    /* JADX WARN: Removed duplicated region for block: B:132:0x01a3  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x01bd  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x01c0  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01c2  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01c7  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01ec  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0201  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x028d  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x029b  */
    /* JADX WARN: Removed duplicated region for block: B:156:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0053  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x006c  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x009f  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00a5  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00a9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00c5  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x00db  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0103  */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0107  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void Chip(final kotlin.jvm.functions.Function0<kotlin.Unit> r30, androidx.compose.ui.Modifier r31, boolean r32, androidx.compose.foundation.interaction.MutableInteractionSource r33, androidx.compose.ui.graphics.Shape r34, androidx.compose.foundation.BorderStroke r35, androidx.compose.material.ChipColors r36, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r37, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 687
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ChipKt.Chip(kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.foundation.BorderStroke, androidx.compose.material.ChipColors, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:108:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x0140  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x015a  */
    /* JADX WARN: Removed duplicated region for block: B:120:0x015d  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x017f  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x01a4  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x01de  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01e5  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01e9  */
    /* JADX WARN: Removed duplicated region for block: B:153:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01ee  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x0212  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x0218  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x0235  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x023b  */
    /* JADX WARN: Removed duplicated region for block: B:166:0x023e  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x0244  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x026a  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:173:0x0270  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x0274  */
    /* JADX WARN: Removed duplicated region for block: B:176:0x0276  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:179:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02a2  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x0355  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0370  */
    /* JADX WARN: Removed duplicated region for block: B:191:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0066  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
    /* JADX WARN: Removed duplicated region for block: B:48:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:64:0x00b7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:68:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00df  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x00f5  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x0102  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:99:0x0124  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void FilterChip(final boolean r43, final kotlin.jvm.functions.Function0<kotlin.Unit> r44, androidx.compose.ui.Modifier r45, boolean r46, androidx.compose.foundation.interaction.MutableInteractionSource r47, androidx.compose.ui.graphics.Shape r48, androidx.compose.foundation.BorderStroke r49, androidx.compose.material.SelectableChipColors r50, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r51, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r52, kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r53, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r54, androidx.compose.runtime.Composer r55, final int r56, final int r57, final int r58) {
        /*
            Method dump skipped, instructions count: 911
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.ChipKt.FilterChip(boolean, kotlin.jvm.functions.Function0, androidx.compose.ui.Modifier, boolean, androidx.compose.foundation.interaction.MutableInteractionSource, androidx.compose.ui.graphics.Shape, androidx.compose.foundation.BorderStroke, androidx.compose.material.SelectableChipColors, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function2, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final long Chip$lambda$1(State<Color> state) {
        return state.getValue().m4548unboximpl();
    }

    static {
        float f = 8;
        LeadingIconEndSpacing = Dp.m7255constructorimpl(f);
        TrailingIconSpacing = Dp.m7255constructorimpl(f);
    }
}
