package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.ui.text.TextStyle;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* compiled from: Text.kt */
@Metadata(d1 = {"\u0000\u008a\u0001\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\u001a(\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00022\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00060\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001aæ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b0\u00101\u001aÜ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010(\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020+0)2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00103\u001aÆ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\u0014\b\u0002\u0010,\u001a\u000e\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u00060-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b4\u00105\u001aÒ\u0001\u0010\f\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020*2\b\b\u0002\u0010\u000f\u001a\u00020\u00102\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00162\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u00182\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u00142\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u001f2\b\b\u0002\u0010 \u001a\u00020\u00142\b\b\u0002\u0010!\u001a\u00020\"2\b\b\u0002\u0010#\u001a\u00020$2\b\b\u0002\u0010%\u001a\u00020&2\b\b\u0002\u0010'\u001a\u00020&2\u0016\b\u0002\u0010,\u001a\u0010\u0012\u0004\u0012\u00020.\u0012\u0004\u0012\u00020\u0006\u0018\u00010-2\b\b\u0002\u0010/\u001a\u00020\u0002H\u0007ø\u0001\u0000¢\u0006\u0004\b2\u00106\"\u0017\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0003\u0010\u0004\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u00067"}, d2 = {"LocalTextStyle", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "Landroidx/compose/ui/text/TextStyle;", "getLocalTextStyle", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "ProvideTextStyle", "", "value", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Landroidx/compose/ui/text/TextStyle;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "Text", "text", "Landroidx/compose/ui/text/AnnotatedString;", "modifier", "Landroidx/compose/ui/Modifier;", "color", "Landroidx/compose/ui/graphics/Color;", "fontSize", "Landroidx/compose/ui/unit/TextUnit;", "fontStyle", "Landroidx/compose/ui/text/font/FontStyle;", "fontWeight", "Landroidx/compose/ui/text/font/FontWeight;", "fontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "letterSpacing", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "textAlign", "Landroidx/compose/ui/text/style/TextAlign;", "lineHeight", "overflow", "Landroidx/compose/ui/text/style/TextOverflow;", "softWrap", "", "maxLines", "", "minLines", "inlineContent", "", "", "Landroidx/compose/foundation/text/InlineTextContent;", "onTextLayout", "Lkotlin/Function1;", "Landroidx/compose/ui/text/TextLayoutResult;", "style", "Text-IbK3jfQ", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text--4IGK_g", "(Landroidx/compose/ui/text/AnnotatedString;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILjava/util/Map;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "Text-fLXpl1I", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;JJLandroidx/compose/ui/text/font/FontStyle;Landroidx/compose/ui/text/font/FontWeight;Landroidx/compose/ui/text/font/FontFamily;JLandroidx/compose/ui/text/style/TextDecoration;Landroidx/compose/ui/text/style/TextAlign;JIZIILkotlin/jvm/functions/Function1;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;III)V", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class TextKt {
    private static final ProvidableCompositionLocal<TextStyle> LocalTextStyle = CompositionLocalKt.compositionLocalOf(SnapshotStateKt.structuralEqualityPolicy(), new Function0<TextStyle>() { // from class: androidx.compose.material.TextKt$LocalTextStyle$1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final TextStyle invoke() {
            return TypographyKt.getDefaultTextStyle();
        }
    });

    /* JADX WARN: Removed duplicated region for block: B:106:0x0151  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0156  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0175  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01e8  */
    /* JADX WARN: Removed duplicated region for block: B:161:0x01ef  */
    /* JADX WARN: Removed duplicated region for block: B:170:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:177:0x021a  */
    /* JADX WARN: Removed duplicated region for block: B:180:0x0226  */
    /* JADX WARN: Removed duplicated region for block: B:186:0x025b  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x02a7  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02c0  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:218:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02fb  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0302  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x0306  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x030a  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x030f  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0314  */
    /* JADX WARN: Removed duplicated region for block: B:244:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0335  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x0348  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0353  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x038e  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x0393  */
    /* JADX WARN: Removed duplicated region for block: B:260:0x03c7  */
    /* JADX WARN: Removed duplicated region for block: B:261:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:266:0x0427  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x0474  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:273:0x0499  */
    /* JADX WARN: Removed duplicated region for block: B:275:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d5  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00dc  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f3  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00fa  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0112  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0119  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0138  */
    /* renamed from: Text--4IGK_g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2038Text4IGK_g(final java.lang.String r64, androidx.compose.ui.Modifier r65, long r66, long r68, androidx.compose.ui.text.font.FontStyle r70, androidx.compose.ui.text.font.FontWeight r71, androidx.compose.ui.text.font.FontFamily r72, long r73, androidx.compose.ui.text.style.TextDecoration r75, androidx.compose.ui.text.style.TextAlign r76, long r77, int r79, boolean r80, int r81, int r82, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r83, androidx.compose.ui.text.TextStyle r84, androidx.compose.runtime.Composer r85, final int r86, final int r87, final int r88) {
        /*
            Method dump skipped, instructions count: 1204
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.m2038Text4IGK_g(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x0150  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016f  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018e  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0191  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01ab  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01ae  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c6  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x01c9  */
    /* JADX WARN: Removed duplicated region for block: B:162:0x01eb  */
    /* JADX WARN: Removed duplicated region for block: B:169:0x01ff  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x020b  */
    /* JADX WARN: Removed duplicated region for block: B:178:0x0240  */
    /* JADX WARN: Removed duplicated region for block: B:187:0x027a  */
    /* JADX WARN: Removed duplicated region for block: B:188:0x027c  */
    /* JADX WARN: Removed duplicated region for block: B:189:0x0281  */
    /* JADX WARN: Removed duplicated region for block: B:191:0x0285  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x028c  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x0290  */
    /* JADX WARN: Removed duplicated region for block: B:195:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:198:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x029f  */
    /* JADX WARN: Removed duplicated region for block: B:201:0x02a3  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02a6  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x02ad  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:211:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02d2  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02d9  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02dd  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02df  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02e3  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02e7  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x02f6  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x031a  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0340  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x034b  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x0398  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x03be  */
    /* JADX WARN: Removed duplicated region for block: B:247:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0092  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00ba  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f1  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f8  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0111  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0115  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0130  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0137  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* renamed from: Text-fLXpl1I, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m2040TextfLXpl1I(final java.lang.String r54, androidx.compose.ui.Modifier r55, long r56, long r58, androidx.compose.ui.text.font.FontStyle r60, androidx.compose.ui.text.font.FontWeight r61, androidx.compose.ui.text.font.FontFamily r62, long r63, androidx.compose.ui.text.style.TextDecoration r65, androidx.compose.ui.text.style.TextAlign r66, long r67, int r69, boolean r70, int r71, kotlin.jvm.functions.Function1 r72, androidx.compose.ui.text.TextStyle r73, androidx.compose.runtime.Composer r74, final int r75, final int r76, final int r77) {
        /*
            Method dump skipped, instructions count: 985
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.m2040TextfLXpl1I(java.lang.String, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x0172  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x0177  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x0190  */
    /* JADX WARN: Removed duplicated region for block: B:128:0x0193  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x01ad  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x01b0  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:150:0x01cb  */
    /* JADX WARN: Removed duplicated region for block: B:160:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:163:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x01f5  */
    /* JADX WARN: Removed duplicated region for block: B:174:0x0213  */
    /* JADX WARN: Removed duplicated region for block: B:181:0x0227  */
    /* JADX WARN: Removed duplicated region for block: B:184:0x022e  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x026e  */
    /* JADX WARN: Removed duplicated region for block: B:202:0x02b1  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02b3  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02b8  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02bc  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02c7  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02ce  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02d4  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x02d7  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02db  */
    /* JADX WARN: Removed duplicated region for block: B:217:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02e2  */
    /* JADX WARN: Removed duplicated region for block: B:220:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:223:0x02f0  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02f4  */
    /* JADX WARN: Removed duplicated region for block: B:226:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:229:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:232:0x0307  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:235:0x0312  */
    /* JADX WARN: Removed duplicated region for block: B:238:0x0317  */
    /* JADX WARN: Removed duplicated region for block: B:239:0x0319  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x031d  */
    /* JADX WARN: Removed duplicated region for block: B:242:0x0321  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0326  */
    /* JADX WARN: Removed duplicated region for block: B:247:0x032a  */
    /* JADX WARN: Removed duplicated region for block: B:248:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:250:0x0333  */
    /* JADX WARN: Removed duplicated region for block: B:251:0x0338  */
    /* JADX WARN: Removed duplicated region for block: B:254:0x033e  */
    /* JADX WARN: Removed duplicated region for block: B:255:0x035b  */
    /* JADX WARN: Removed duplicated region for block: B:258:0x0368  */
    /* JADX WARN: Removed duplicated region for block: B:259:0x0373  */
    /* JADX WARN: Removed duplicated region for block: B:262:0x03ae  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x03b1  */
    /* JADX WARN: Removed duplicated region for block: B:269:0x03e5  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:270:0x03ea  */
    /* JADX WARN: Removed duplicated region for block: B:275:0x0443  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x0494  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:282:0x04c0  */
    /* JADX WARN: Removed duplicated region for block: B:284:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x009a  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00b5  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d7  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00de  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00f7  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00fe  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x011b  */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x013a  */
    /* renamed from: Text-IbK3jfQ, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void m2039TextIbK3jfQ(final androidx.compose.ui.text.AnnotatedString r69, androidx.compose.ui.Modifier r70, long r71, long r73, androidx.compose.ui.text.font.FontStyle r75, androidx.compose.ui.text.font.FontWeight r76, androidx.compose.ui.text.font.FontFamily r77, long r78, androidx.compose.ui.text.style.TextDecoration r80, androidx.compose.ui.text.style.TextAlign r81, long r82, int r84, boolean r85, int r86, int r87, java.util.Map<java.lang.String, androidx.compose.foundation.text.InlineTextContent> r88, kotlin.jvm.functions.Function1<? super androidx.compose.ui.text.TextLayoutResult, kotlin.Unit> r89, androidx.compose.ui.text.TextStyle r90, androidx.compose.runtime.Composer r91, final int r92, final int r93, final int r94) {
        /*
            Method dump skipped, instructions count: 1243
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.m2039TextIbK3jfQ(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    /* JADX WARN: Removed duplicated region for block: B:107:0x014e  */
    /* JADX WARN: Removed duplicated region for block: B:108:0x0153  */
    /* JADX WARN: Removed duplicated region for block: B:118:0x016d  */
    /* JADX WARN: Removed duplicated region for block: B:119:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:129:0x018c  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x018f  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:141:0x01ac  */
    /* JADX WARN: Removed duplicated region for block: B:151:0x01c4  */
    /* JADX WARN: Removed duplicated region for block: B:154:0x01cd  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:165:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:172:0x0206  */
    /* JADX WARN: Removed duplicated region for block: B:175:0x020c  */
    /* JADX WARN: Removed duplicated region for block: B:183:0x024c  */
    /* JADX WARN: Removed duplicated region for block: B:192:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:193:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:194:0x028f  */
    /* JADX WARN: Removed duplicated region for block: B:196:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:197:0x029a  */
    /* JADX WARN: Removed duplicated region for block: B:199:0x029e  */
    /* JADX WARN: Removed duplicated region for block: B:200:0x02a5  */
    /* JADX WARN: Removed duplicated region for block: B:203:0x02aa  */
    /* JADX WARN: Removed duplicated region for block: B:204:0x02ac  */
    /* JADX WARN: Removed duplicated region for block: B:206:0x02b0  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x02b2  */
    /* JADX WARN: Removed duplicated region for block: B:209:0x02b6  */
    /* JADX WARN: Removed duplicated region for block: B:210:0x02b9  */
    /* JADX WARN: Removed duplicated region for block: B:212:0x02bd  */
    /* JADX WARN: Removed duplicated region for block: B:213:0x02c4  */
    /* JADX WARN: Removed duplicated region for block: B:215:0x02c8  */
    /* JADX WARN: Removed duplicated region for block: B:216:0x02ca  */
    /* JADX WARN: Removed duplicated region for block: B:219:0x02cf  */
    /* JADX WARN: Removed duplicated region for block: B:221:0x02d3  */
    /* JADX WARN: Removed duplicated region for block: B:222:0x02da  */
    /* JADX WARN: Removed duplicated region for block: B:224:0x02de  */
    /* JADX WARN: Removed duplicated region for block: B:225:0x02e5  */
    /* JADX WARN: Removed duplicated region for block: B:227:0x02e9  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x02eb  */
    /* JADX WARN: Removed duplicated region for block: B:230:0x02ef  */
    /* JADX WARN: Removed duplicated region for block: B:231:0x02f3  */
    /* JADX WARN: Removed duplicated region for block: B:233:0x02f7  */
    /* JADX WARN: Removed duplicated region for block: B:234:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:236:0x0300  */
    /* JADX WARN: Removed duplicated region for block: B:237:0x0305  */
    /* JADX WARN: Removed duplicated region for block: B:240:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:241:0x032f  */
    /* JADX WARN: Removed duplicated region for block: B:245:0x0356  */
    /* JADX WARN: Removed duplicated region for block: B:246:0x0361  */
    /* JADX WARN: Removed duplicated region for block: B:249:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:253:0x03d5  */
    /* JADX WARN: Removed duplicated region for block: B:255:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:26:0x0052  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x0093  */
    /* JADX WARN: Removed duplicated region for block: B:56:0x00af  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00d1  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00d8  */
    /* JADX WARN: Removed duplicated region for block: B:76:0x00ef  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f6  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x0113  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x012e  */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0135  */
    @kotlin.Deprecated(level = kotlin.DeprecationLevel.HIDDEN, message = "Maintained for binary compatibility. Use version with minLines instead")
    /* renamed from: Text--4IGK_g, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final /* synthetic */ void m2037Text4IGK_g(final androidx.compose.ui.text.AnnotatedString r52, androidx.compose.ui.Modifier r53, long r54, long r56, androidx.compose.ui.text.font.FontStyle r58, androidx.compose.ui.text.font.FontWeight r59, androidx.compose.ui.text.font.FontFamily r60, long r61, androidx.compose.ui.text.style.TextDecoration r63, androidx.compose.ui.text.style.TextAlign r64, long r65, int r67, boolean r68, int r69, java.util.Map r70, kotlin.jvm.functions.Function1 r71, androidx.compose.ui.text.TextStyle r72, androidx.compose.runtime.Composer r73, final int r74, final int r75, final int r76) {
        /*
            Method dump skipped, instructions count: 1008
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextKt.m2037Text4IGK_g(androidx.compose.ui.text.AnnotatedString, androidx.compose.ui.Modifier, long, long, androidx.compose.ui.text.font.FontStyle, androidx.compose.ui.text.font.FontWeight, androidx.compose.ui.text.font.FontFamily, long, androidx.compose.ui.text.style.TextDecoration, androidx.compose.ui.text.style.TextAlign, long, int, boolean, int, java.util.Map, kotlin.jvm.functions.Function1, androidx.compose.ui.text.TextStyle, androidx.compose.runtime.Composer, int, int, int):void");
    }

    public static final ProvidableCompositionLocal<TextStyle> getLocalTextStyle() {
        return LocalTextStyle;
    }

    public static final void ProvideTextStyle(final TextStyle textStyle, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1772272796);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ProvideTextStyle)P(1)394@17636L7,395@17661L80:Text.kt#jmzs0o");
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(textStyle) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if ((i2 & 91) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1772272796, i2, -1, "androidx.compose.material.ProvideTextStyle (Text.kt:393)");
            }
            ProvidableCompositionLocal<TextStyle> providableCompositionLocal = LocalTextStyle;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC:CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(providableCompositionLocal);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            CompositionLocalKt.CompositionLocalProvider(providableCompositionLocal.provides(((TextStyle) objConsume).merge(textStyle)), function2, composerStartRestartGroup, (i2 & 112) | ProvidedValue.$stable);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.material.TextKt.ProvideTextStyle.1
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
                    TextKt.ProvideTextStyle(textStyle, function2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
