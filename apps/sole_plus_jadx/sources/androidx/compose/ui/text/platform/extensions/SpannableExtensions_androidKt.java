package androidx.compose.ui.text.platform.extensions;

import android.graphics.Typeface;
import android.text.Spannable;
import android.text.style.AbsoluteSizeSpan;
import android.text.style.BackgroundColorSpan;
import android.text.style.ForegroundColorSpan;
import android.text.style.LeadingMarginSpan;
import android.text.style.MetricAffectingSpan;
import android.text.style.RelativeSizeSpan;
import android.text.style.ScaleXSpan;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ShaderBrush;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.SolidColor;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.AnnotatedStringKt;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.android.style.BaselineShiftSpan;
import androidx.compose.ui.text.android.style.FontFeatureSpan;
import androidx.compose.ui.text.android.style.LetterSpacingSpanEm;
import androidx.compose.ui.text.android.style.LetterSpacingSpanPx;
import androidx.compose.ui.text.android.style.LineHeightSpan;
import androidx.compose.ui.text.android.style.LineHeightStyleSpan;
import androidx.compose.ui.text.android.style.ShadowSpan;
import androidx.compose.ui.text.android.style.SkewXSpan;
import androidx.compose.ui.text.android.style.TextDecorationSpan;
import androidx.compose.ui.text.android.style.TypefaceSpan;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.platform.style.DrawStyleSpan;
import androidx.compose.ui.text.platform.style.ShaderBrushSpan;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import com.android.SdkConstants;
import io.ktor.http.ContentDisposition;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import kotlin.text.StringsKt;

/* compiled from: SpannableExtensions.android.kt */
@Metadata(d1 = {"\u0000Ö\u0001\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a$\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a&\u0010\b\u001a\u00020\u0001*\u00020\u00022\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000\u001a<\u0010\u000f\u001a\u00020\u0001*\u00020\u00022\u0014\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00120\u00112\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0000\u001a'\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001a3\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u001b\u001a\u00020\u001cH\u0000¢\u0006\u0004\b\u001d\u0010\u001e\u001a+\u0010\u0019\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0000¢\u0006\u0004\b\u001f\u0010 \u001a'\u0010!\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u00162\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0002¢\u0006\u0004\b\"\u0010\u0018\u001a\u0010\u0010#\u001a\u00020$2\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001aZ\u0010%\u001a\u00020\u0001*\u00020\u00022\u0006\u0010&\u001a\u00020'2\u0014\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00120\u00112\u0006\u0010\r\u001a\u00020\u000e2&\u0010(\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0)H\u0000\u001a,\u0010/\u001a\u00020\u0001*\u00020\u00022\u0006\u00100\u001a\u0002012\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\u000eH\u0002\u001aR\u00102\u001a\u00020\u0001*\u00020\u00022\u0006\u0010&\u001a\u00020'2\u0014\u0010\u0010\u001a\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00130\u00120\u00112&\u0010(\u001a\"\u0012\u0006\u0012\u0004\u0018\u00010*\u0012\u0004\u0012\u00020+\u0012\u0004\u0012\u00020,\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020.0)H\u0002\u001aF\u00103\u001a\u00020\u00012\b\u00104\u001a\u0004\u0018\u0001012\u0012\u00105\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002010\u00120\u00112\u001e\u00106\u001a\u001a\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u000107H\u0000\u001a!\u00108\u001a\u0004\u0018\u0001092\u0006\u0010:\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000eH\u0002¢\u0006\u0004\b;\u0010<\u001a&\u0010@\u001a\u00020\u0001*\u00020\u00022\b\u0010A\u001a\u0004\u0018\u00010B2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u001a&\u0010C\u001a\u00020\u0001*\u00020\u00022\b\u0010D\u001a\u0004\u0018\u00010E2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u001a+\u0010F\u001a\u00020\u0001*\u00020\u00022\u0006\u0010G\u001a\u00020H2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\bI\u0010J\u001a&\u0010K\u001a\u00020\u0001*\u00020\u00022\b\u0010L\u001a\u0004\u0018\u00010M2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a&\u0010N\u001a\u00020\u0001*\u00020\u00022\b\u0010O\u001a\u0004\u0018\u00010P2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u001a&\u0010Q\u001a\u00020\u0001*\u00020\u00022\b\u0010R\u001a\u0004\u0018\u00010S2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u001a3\u0010T\u001a\u00020\u0001*\u00020\u00022\u0006\u0010U\u001a\u00020\u00162\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\bV\u0010W\u001a&\u0010X\u001a\u00020\u0001*\u00020\u00022\b\u0010Y\u001a\u0004\u0018\u00010Z2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000\u001a+\u0010[\u001a\u00020\u0001*\u00020\u00022\u0006\u0010G\u001a\u00020H2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0000¢\u0006\u0004\b\\\u0010J\u001a+\u0010]\u001a\u00020\u0001*\u00020\u00022\b\u0010^\u001a\u0004\u0018\u00010_2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002¢\u0006\u0002\b`\u001a.\u0010a\u001a\u00020\u0001*\u00020\u00022\b\u0010b\u001a\u0004\u0018\u00010c2\u0006\u0010d\u001a\u00020\f2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006H\u0002\u001a\f\u0010e\u001a\u00020$*\u00020'H\u0002\u001a\u0016\u0010f\u001a\u000201*\u0004\u0018\u0001012\u0006\u0010g\u001a\u000201H\u0002\"\u0018\u0010=\u001a\u00020$*\u0002018BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?¨\u0006h"}, d2 = {"setSpan", "", "Landroid/text/Spannable;", "span", "", "start", "", "end", "setTextIndent", "textIndent", "Landroidx/compose/ui/text/style/TextIndent;", "contextFontSize", "", "density", "Landroidx/compose/ui/unit/Density;", "setBulletSpans", "annotations", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "Landroidx/compose/ui/text/AnnotatedString$Annotation;", "resolveBulletTextUnitToPx", ContentDisposition.Parameters.Size, "Landroidx/compose/ui/unit/TextUnit;", "resolveBulletTextUnitToPx-o2QH7mI", "(JFLandroidx/compose/ui/unit/Density;)F", "setLineHeight", "lineHeight", "lineHeightStyle", "Landroidx/compose/ui/text/style/LineHeightStyle;", "setLineHeight-KmRG4DE", "(Landroid/text/Spannable;JFLandroidx/compose/ui/unit/Density;Landroidx/compose/ui/text/style/LineHeightStyle;)V", "setLineHeight-r9BaKPg", "(Landroid/text/Spannable;JFLandroidx/compose/ui/unit/Density;)V", "resolveLineHeightInPx", "resolveLineHeightInPx-o2QH7mI", "isNonLinearFontScalingActive", "", "setSpanStyles", "contextTextStyle", "Landroidx/compose/ui/text/TextStyle;", "resolveTypeface", "Lkotlin/Function4;", "Landroidx/compose/ui/text/font/FontFamily;", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontStyle;", "Landroidx/compose/ui/text/font/FontSynthesis;", "Landroid/graphics/Typeface;", "setSpanStyle", "style", "Landroidx/compose/ui/text/SpanStyle;", "setFontAttributes", "flattenFontStylesAndApply", "contextFontSpanStyle", "spanStyles", "block", "Lkotlin/Function3;", "createLetterSpacingSpan", "Landroid/text/style/MetricAffectingSpan;", "letterSpacing", "createLetterSpacingSpan-eAf_CNQ", "(JLandroidx/compose/ui/unit/Density;)Landroid/text/style/MetricAffectingSpan;", "needsLetterSpacingSpan", "getNeedsLetterSpacingSpan", "(Landroidx/compose/ui/text/SpanStyle;)Z", "setShadow", "shadow", "Landroidx/compose/ui/graphics/Shadow;", "setDrawStyle", "drawStyle", "Landroidx/compose/ui/graphics/drawscope/DrawStyle;", "setBackground", "color", "Landroidx/compose/ui/graphics/Color;", "setBackground-RPmYEkk", "(Landroid/text/Spannable;JII)V", "setLocaleList", "localeList", "Landroidx/compose/ui/text/intl/LocaleList;", "setGeometricTransform", "textGeometricTransform", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "setFontFeatureSettings", "fontFeatureSettings", "", "setFontSize", "fontSize", "setFontSize-KmRG4DE", "(Landroid/text/Spannable;JLandroidx/compose/ui/unit/Density;II)V", "setTextDecoration", "textDecoration", "Landroidx/compose/ui/text/style/TextDecoration;", "setColor", "setColor-RPmYEkk", "setBaselineShift", "baselineShift", "Landroidx/compose/ui/text/style/BaselineShift;", "setBaselineShift-0ocSgnM", "setBrush", "brush", "Landroidx/compose/ui/graphics/Brush;", "alpha", "hasFontAttributes", SdkConstants.VIEW_MERGE, "spanStyle", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SpannableExtensions_androidKt {
    public static final void setSpan(Spannable spannable, Object obj, int i, int i2) {
        spannable.setSpan(obj, i, i2, 33);
    }

    public static final void setTextIndent(Spannable spannable, TextIndent textIndent, float f, Density density) {
        float fM7449getValueimpl;
        if (textIndent != null) {
            if ((TextUnit.m7446equalsimpl0(textIndent.getFirstLine(), TextUnitKt.getSp(0)) && TextUnit.m7446equalsimpl0(textIndent.getRestLine(), TextUnitKt.getSp(0))) || TextUnit.m7447getRawTypeimpl(textIndent.getFirstLine()) == 0 || TextUnit.m7447getRawTypeimpl(textIndent.getRestLine()) == 0) {
                return;
            }
            long jM7448getTypeUIouoOA = TextUnit.m7448getTypeUIouoOA(textIndent.getFirstLine());
            float fM7449getValueimpl2 = 0.0f;
            if (TextUnitType.m7477equalsimpl0(jM7448getTypeUIouoOA, TextUnitType.INSTANCE.m7482getSpUIouoOA())) {
                fM7449getValueimpl = density.mo676toPxR2X_6o(textIndent.getFirstLine());
            } else {
                fM7449getValueimpl = TextUnitType.m7477equalsimpl0(jM7448getTypeUIouoOA, TextUnitType.INSTANCE.m7481getEmUIouoOA()) ? TextUnit.m7449getValueimpl(textIndent.getFirstLine()) * f : 0.0f;
            }
            long jM7448getTypeUIouoOA2 = TextUnit.m7448getTypeUIouoOA(textIndent.getRestLine());
            if (TextUnitType.m7477equalsimpl0(jM7448getTypeUIouoOA2, TextUnitType.INSTANCE.m7482getSpUIouoOA())) {
                fM7449getValueimpl2 = density.mo676toPxR2X_6o(textIndent.getRestLine());
            } else if (TextUnitType.m7477equalsimpl0(jM7448getTypeUIouoOA2, TextUnitType.INSTANCE.m7481getEmUIouoOA())) {
                fM7449getValueimpl2 = TextUnit.m7449getValueimpl(textIndent.getRestLine()) * f;
            }
            setSpan(spannable, new LeadingMarginSpan.Standard((int) Math.ceil(fM7449getValueimpl), (int) Math.ceil(fM7449getValueimpl2)), 0, spannable.length());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x00af  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void setBulletSpans(android.text.Spannable r17, java.util.List<? extends androidx.compose.ui.text.AnnotatedString.Range<? extends androidx.compose.ui.text.AnnotatedString.Annotation>> r18, float r19, androidx.compose.ui.unit.Density r20, androidx.compose.ui.text.style.TextIndent r21) {
        /*
            r0 = r18
            r1 = r19
            r12 = r20
            r2 = 0
            if (r21 == 0) goto L3b
            long r3 = r21.getFirstLine()
            long r3 = androidx.compose.ui.unit.TextUnit.m7448getTypeUIouoOA(r3)
            androidx.compose.ui.unit.TextUnitType$Companion r5 = androidx.compose.ui.unit.TextUnitType.INSTANCE
            long r5 = r5.m7482getSpUIouoOA()
            boolean r5 = androidx.compose.ui.unit.TextUnitType.m7477equalsimpl0(r3, r5)
            if (r5 == 0) goto L26
            long r2 = r21.getFirstLine()
            float r2 = r12.mo676toPxR2X_6o(r2)
            goto L3b
        L26:
            androidx.compose.ui.unit.TextUnitType$Companion r5 = androidx.compose.ui.unit.TextUnitType.INSTANCE
            long r5 = r5.m7481getEmUIouoOA()
            boolean r3 = androidx.compose.ui.unit.TextUnitType.m7477equalsimpl0(r3, r5)
            if (r3 == 0) goto L3b
            long r2 = r21.getFirstLine()
            float r2 = androidx.compose.ui.unit.TextUnit.m7449getValueimpl(r2)
            float r2 = r2 * r1
        L3b:
            r13 = r2
            r2 = r0
            java.util.Collection r2 = (java.util.Collection) r2
            int r14 = r2.size()
            r2 = 0
            r15 = r2
        L45:
            if (r15 >= r14) goto Lb6
            java.lang.Object r2 = r0.get(r15)
            r16 = r2
            androidx.compose.ui.text.AnnotatedString$Range r16 = (androidx.compose.ui.text.AnnotatedString.Range) r16
            java.lang.Object r2 = r16.getItem()
            boolean r3 = r2 instanceof androidx.compose.ui.text.Bullet
            if (r3 == 0) goto L5a
            androidx.compose.ui.text.Bullet r2 = (androidx.compose.ui.text.Bullet) r2
            goto L5b
        L5a:
            r2 = 0
        L5b:
            if (r2 == 0) goto Laf
            long r3 = r2.getWidth()
            float r4 = m6996resolveBulletTextUnitToPxo2QH7mI(r3, r1, r12)
            long r5 = r2.getHeight()
            float r5 = m6996resolveBulletTextUnitToPxo2QH7mI(r5, r1, r12)
            long r6 = r2.getPadding()
            float r6 = m6996resolveBulletTextUnitToPxo2QH7mI(r6, r1, r12)
            boolean r3 = java.lang.Float.isNaN(r4)
            if (r3 != 0) goto Laf
            boolean r3 = java.lang.Float.isNaN(r5)
            if (r3 != 0) goto Laf
            boolean r3 = java.lang.Float.isNaN(r6)
            if (r3 != 0) goto Laf
            androidx.compose.ui.graphics.Shape r3 = r2.getShape()
            androidx.compose.ui.graphics.Brush r7 = r2.getBrush()
            float r8 = r2.getAlpha()
            androidx.compose.ui.graphics.drawscope.DrawStyle r9 = r2.getDrawStyle()
            androidx.compose.ui.text.platform.style.CustomBulletSpan r11 = new androidx.compose.ui.text.platform.style.CustomBulletSpan
            r2 = r11
            r10 = r20
            r0 = r11
            r11 = r13
            r2.<init>(r3, r4, r5, r6, r7, r8, r9, r10, r11)
            int r2 = r16.getStart()
            int r3 = r16.getEnd()
            r4 = r17
            setSpan(r4, r0, r2, r3)
            goto Lb1
        Laf:
            r4 = r17
        Lb1:
            int r15 = r15 + 1
            r0 = r18
            goto L45
        Lb6:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt.setBulletSpans(android.text.Spannable, java.util.List, float, androidx.compose.ui.unit.Density, androidx.compose.ui.text.style.TextIndent):void");
    }

    /* renamed from: resolveBulletTextUnitToPx-o2QH7mI, reason: not valid java name */
    private static final float m6996resolveBulletTextUnitToPxo2QH7mI(long j, float f, Density density) {
        if (TextUnit.m7446equalsimpl0(j, TextUnit.INSTANCE.m7460getUnspecifiedXSAIIZE())) {
            return f;
        }
        long jM7448getTypeUIouoOA = TextUnit.m7448getTypeUIouoOA(j);
        if (TextUnitType.m7477equalsimpl0(jM7448getTypeUIouoOA, TextUnitType.INSTANCE.m7482getSpUIouoOA())) {
            return density.mo676toPxR2X_6o(j);
        }
        if (TextUnitType.m7477equalsimpl0(jM7448getTypeUIouoOA, TextUnitType.INSTANCE.m7481getEmUIouoOA())) {
            return TextUnit.m7449getValueimpl(j) * f;
        }
        return Float.NaN;
    }

    /* renamed from: setLineHeight-KmRG4DE, reason: not valid java name */
    public static final void m7002setLineHeightKmRG4DE(Spannable spannable, long j, float f, Density density, LineHeightStyle lineHeightStyle) {
        float fM6997resolveLineHeightInPxo2QH7mI = m6997resolveLineHeightInPxo2QH7mI(j, f, density);
        if (Float.isNaN(fM6997resolveLineHeightInPxo2QH7mI)) {
            return;
        }
        Spannable spannable2 = spannable;
        setSpan(spannable, new LineHeightStyleSpan(fM6997resolveLineHeightInPxo2QH7mI, 0, (spannable2.length() == 0 || StringsKt.last(spannable2) == '\n') ? spannable.length() + 1 : spannable.length(), LineHeightStyle.Trim.m7124isTrimFirstLineTopimpl$ui_text(lineHeightStyle.getTrim()), LineHeightStyle.Trim.m7125isTrimLastLineBottomimpl$ui_text(lineHeightStyle.getTrim()), lineHeightStyle.getAlignment(), LineHeightStyle.Mode.m7113equalsimpl0(lineHeightStyle.getMode(), LineHeightStyle.Mode.INSTANCE.m7118getMinimumlzQqcRY())), 0, spannable.length());
    }

    /* renamed from: setLineHeight-r9BaKPg, reason: not valid java name */
    public static final void m7003setLineHeightr9BaKPg(Spannable spannable, long j, float f, Density density) {
        float fM6997resolveLineHeightInPxo2QH7mI = m6997resolveLineHeightInPxo2QH7mI(j, f, density);
        if (Float.isNaN(fM6997resolveLineHeightInPxo2QH7mI)) {
            return;
        }
        setSpan(spannable, new LineHeightSpan(fM6997resolveLineHeightInPxo2QH7mI), 0, spannable.length());
    }

    /* renamed from: resolveLineHeightInPx-o2QH7mI, reason: not valid java name */
    private static final float m6997resolveLineHeightInPxo2QH7mI(long j, float f, Density density) {
        float fM7449getValueimpl;
        long jM7448getTypeUIouoOA = TextUnit.m7448getTypeUIouoOA(j);
        if (TextUnitType.m7477equalsimpl0(jM7448getTypeUIouoOA, TextUnitType.INSTANCE.m7482getSpUIouoOA())) {
            if (!isNonLinearFontScalingActive(density)) {
                return density.mo676toPxR2X_6o(j);
            }
            fM7449getValueimpl = TextUnit.m7449getValueimpl(j) / TextUnit.m7449getValueimpl(density.mo680toSpkPz2Gy4(f));
        } else {
            if (!TextUnitType.m7477equalsimpl0(jM7448getTypeUIouoOA, TextUnitType.INSTANCE.m7481getEmUIouoOA())) {
                return Float.NaN;
            }
            fM7449getValueimpl = TextUnit.m7449getValueimpl(j);
        }
        return fM7449getValueimpl * f;
    }

    private static final boolean isNonLinearFontScalingActive(Density density) {
        return ((double) density.getFontScale()) > 1.05d;
    }

    public static final void setSpanStyles(Spannable spannable, TextStyle textStyle, List<? extends AnnotatedString.Range<? extends AnnotatedString.Annotation>> list, Density density, Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4) {
        MetricAffectingSpan metricAffectingSpanM6995createLetterSpacingSpaneAf_CNQ;
        setFontAttributes(spannable, textStyle, list, function4);
        List<? extends AnnotatedString.Range<? extends AnnotatedString.Annotation>> list2 = list;
        int size = list2.size();
        boolean z = false;
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<? extends AnnotatedString.Annotation> range = list.get(i);
            if (range.getItem() instanceof SpanStyle) {
                int start = range.getStart();
                int end = range.getEnd();
                if (start >= 0 && start < spannable.length() && end > start && end <= spannable.length()) {
                    setSpanStyle(spannable, (SpanStyle) range.getItem(), start, end, density);
                    if (getNeedsLetterSpacingSpan((SpanStyle) range.getItem())) {
                        z = true;
                    }
                }
            }
        }
        if (z) {
            int size2 = list2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                AnnotatedString.Range<? extends AnnotatedString.Annotation> range2 = list.get(i2);
                AnnotatedString.Annotation item = range2.getItem();
                if (item instanceof SpanStyle) {
                    int start2 = range2.getStart();
                    int end2 = range2.getEnd();
                    if (start2 >= 0 && start2 < spannable.length() && end2 > start2 && end2 <= spannable.length() && (metricAffectingSpanM6995createLetterSpacingSpaneAf_CNQ = m6995createLetterSpacingSpaneAf_CNQ(((SpanStyle) item).getLetterSpacing(), density)) != null) {
                        setSpan(spannable, metricAffectingSpanM6995createLetterSpacingSpaneAf_CNQ, start2, end2);
                    }
                }
            }
        }
    }

    private static final void setSpanStyle(Spannable spannable, SpanStyle spanStyle, int i, int i2, Density density) {
        m6999setBaselineShift0ocSgnM(spannable, spanStyle.getBaselineShift(), i, i2);
        m7000setColorRPmYEkk(spannable, spanStyle.m6658getColor0d7_KjU(), i, i2);
        setBrush(spannable, spanStyle.getBrush(), spanStyle.getAlpha(), i, i2);
        setTextDecoration(spannable, spanStyle.getTextDecoration(), i, i2);
        m7001setFontSizeKmRG4DE(spannable, spanStyle.getFontSize(), density, i, i2);
        setFontFeatureSettings(spannable, spanStyle.getFontFeatureSettings(), i, i2);
        setGeometricTransform(spannable, spanStyle.getTextGeometricTransform(), i, i2);
        setLocaleList(spannable, spanStyle.getLocaleList(), i, i2);
        m6998setBackgroundRPmYEkk(spannable, spanStyle.getBackground(), i, i2);
        setShadow(spannable, spanStyle.getShadow(), i, i2);
        setDrawStyle(spannable, spanStyle.getDrawStyle(), i, i2);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit setFontAttributes$lambda$12(Spannable spannable, Function4 function4, SpanStyle spanStyle, int i, int i2) {
        FontFamily fontFamily = spanStyle.getFontFamily();
        FontWeight fontWeight = spanStyle.getFontWeight();
        if (fontWeight == null) {
            fontWeight = FontWeight.INSTANCE.getNormal();
        }
        FontStyle fontStyle = spanStyle.getFontStyle();
        FontStyle fontStyleM6827boximpl = FontStyle.m6827boximpl(fontStyle != null ? fontStyle.m6833unboximpl() : FontStyle.INSTANCE.m6837getNormal_LCdwA());
        FontSynthesis fontSynthesis = spanStyle.getFontSynthesis();
        spannable.setSpan(new TypefaceSpan((Typeface) function4.invoke(fontFamily, fontWeight, fontStyleM6827boximpl, FontSynthesis.m6838boximpl(fontSynthesis != null ? fontSynthesis.getValue() : FontSynthesis.INSTANCE.m6847getAllGVVA2EU()))), i, i2, 33);
        return Unit.INSTANCE;
    }

    public static final void flattenFontStylesAndApply(SpanStyle spanStyle, List<AnnotatedString.Range<SpanStyle>> list, Function3<? super SpanStyle, ? super Integer, ? super Integer, Unit> function3) {
        if (list.size() <= 1) {
            if (list.isEmpty()) {
                return;
            }
            function3.invoke(merge(spanStyle, list.get(0).getItem()), Integer.valueOf(list.get(0).getStart()), Integer.valueOf(list.get(0).getEnd()));
            return;
        }
        int size = list.size();
        int i = size * 2;
        int[] iArr = new int[i];
        List<AnnotatedString.Range<SpanStyle>> list2 = list;
        int size2 = list2.size();
        for (int i2 = 0; i2 < size2; i2++) {
            AnnotatedString.Range<SpanStyle> range = list.get(i2);
            iArr[i2] = range.getStart();
            iArr[i2 + size] = range.getEnd();
        }
        ArraysKt.sort(iArr);
        int iFirst = ArraysKt.first(iArr);
        for (int i3 = 0; i3 < i; i3++) {
            int i4 = iArr[i3];
            if (i4 != iFirst) {
                int size3 = list2.size();
                SpanStyle spanStyleMerge = spanStyle;
                for (int i5 = 0; i5 < size3; i5++) {
                    AnnotatedString.Range<SpanStyle> range2 = list.get(i5);
                    if (range2.getStart() != range2.getEnd() && AnnotatedStringKt.intersect(iFirst, i4, range2.getStart(), range2.getEnd())) {
                        spanStyleMerge = merge(spanStyleMerge, range2.getItem());
                    }
                }
                if (spanStyleMerge != null) {
                    function3.invoke(spanStyleMerge, Integer.valueOf(iFirst), Integer.valueOf(i4));
                }
                iFirst = i4;
            }
        }
    }

    /* renamed from: createLetterSpacingSpan-eAf_CNQ, reason: not valid java name */
    private static final MetricAffectingSpan m6995createLetterSpacingSpaneAf_CNQ(long j, Density density) {
        long jM7448getTypeUIouoOA = TextUnit.m7448getTypeUIouoOA(j);
        if (TextUnitType.m7477equalsimpl0(jM7448getTypeUIouoOA, TextUnitType.INSTANCE.m7482getSpUIouoOA())) {
            return new LetterSpacingSpanPx(density.mo676toPxR2X_6o(j));
        }
        if (TextUnitType.m7477equalsimpl0(jM7448getTypeUIouoOA, TextUnitType.INSTANCE.m7481getEmUIouoOA())) {
            return new LetterSpacingSpanEm(TextUnit.m7449getValueimpl(j));
        }
        return null;
    }

    private static final boolean getNeedsLetterSpacingSpan(SpanStyle spanStyle) {
        return TextUnitType.m7477equalsimpl0(TextUnit.m7448getTypeUIouoOA(spanStyle.getLetterSpacing()), TextUnitType.INSTANCE.m7482getSpUIouoOA()) || TextUnitType.m7477equalsimpl0(TextUnit.m7448getTypeUIouoOA(spanStyle.getLetterSpacing()), TextUnitType.INSTANCE.m7481getEmUIouoOA());
    }

    private static final void setShadow(Spannable spannable, Shadow shadow, int i, int i2) {
        if (shadow != null) {
            setSpan(spannable, new ShadowSpan(ColorKt.m4592toArgb8_81llA(shadow.getColor()), Float.intBitsToFloat((int) (shadow.getOffset() >> 32)), Float.intBitsToFloat((int) (shadow.getOffset() & 4294967295L)), TextPaintExtensions_androidKt.correctBlurRadius(shadow.getBlurRadius())), i, i2);
        }
    }

    private static final void setDrawStyle(Spannable spannable, DrawStyle drawStyle, int i, int i2) {
        if (drawStyle != null) {
            setSpan(spannable, new DrawStyleSpan(drawStyle), i, i2);
        }
    }

    /* renamed from: setBackground-RPmYEkk, reason: not valid java name */
    public static final void m6998setBackgroundRPmYEkk(Spannable spannable, long j, int i, int i2) {
        if (j != 16) {
            setSpan(spannable, new BackgroundColorSpan(ColorKt.m4592toArgb8_81llA(j)), i, i2);
        }
    }

    public static final void setLocaleList(Spannable spannable, LocaleList localeList, int i, int i2) {
        if (localeList != null) {
            setSpan(spannable, LocaleListHelperMethods.INSTANCE.localeSpan(localeList), i, i2);
        }
    }

    private static final void setGeometricTransform(Spannable spannable, TextGeometricTransform textGeometricTransform, int i, int i2) {
        if (textGeometricTransform != null) {
            setSpan(spannable, new ScaleXSpan(textGeometricTransform.getScaleX()), i, i2);
            setSpan(spannable, new SkewXSpan(textGeometricTransform.getSkewX()), i, i2);
        }
    }

    private static final void setFontFeatureSettings(Spannable spannable, String str, int i, int i2) {
        if (str != null) {
            setSpan(spannable, new FontFeatureSpan(str), i, i2);
        }
    }

    /* renamed from: setFontSize-KmRG4DE, reason: not valid java name */
    public static final void m7001setFontSizeKmRG4DE(Spannable spannable, long j, Density density, int i, int i2) {
        long jM7448getTypeUIouoOA = TextUnit.m7448getTypeUIouoOA(j);
        if (TextUnitType.m7477equalsimpl0(jM7448getTypeUIouoOA, TextUnitType.INSTANCE.m7482getSpUIouoOA())) {
            setSpan(spannable, new AbsoluteSizeSpan(MathKt.roundToInt(density.mo676toPxR2X_6o(j)), false), i, i2);
        } else if (TextUnitType.m7477equalsimpl0(jM7448getTypeUIouoOA, TextUnitType.INSTANCE.m7481getEmUIouoOA())) {
            setSpan(spannable, new RelativeSizeSpan(TextUnit.m7449getValueimpl(j)), i, i2);
        }
    }

    public static final void setTextDecoration(Spannable spannable, TextDecoration textDecoration, int i, int i2) {
        if (textDecoration != null) {
            setSpan(spannable, new TextDecorationSpan(textDecoration.contains(TextDecoration.INSTANCE.getUnderline()), textDecoration.contains(TextDecoration.INSTANCE.getLineThrough())), i, i2);
        }
    }

    /* renamed from: setColor-RPmYEkk, reason: not valid java name */
    public static final void m7000setColorRPmYEkk(Spannable spannable, long j, int i, int i2) {
        if (j != 16) {
            setSpan(spannable, new ForegroundColorSpan(ColorKt.m4592toArgb8_81llA(j)), i, i2);
        }
    }

    /* renamed from: setBaselineShift-0ocSgnM, reason: not valid java name */
    private static final void m6999setBaselineShift0ocSgnM(Spannable spannable, BaselineShift baselineShift, int i, int i2) {
        if (baselineShift != null) {
            setSpan(spannable, new BaselineShiftSpan(baselineShift.m7017unboximpl()), i, i2);
        }
    }

    private static final void setBrush(Spannable spannable, Brush brush, float f, int i, int i2) {
        if (brush != null) {
            if (brush instanceof SolidColor) {
                m7000setColorRPmYEkk(spannable, ((SolidColor) brush).getValue(), i, i2);
            } else {
                if (!(brush instanceof ShaderBrush)) {
                    throw new NoWhenBranchMatchedException();
                }
                setSpan(spannable, new ShaderBrushSpan((ShaderBrush) brush, f), i, i2);
            }
        }
    }

    private static final boolean hasFontAttributes(TextStyle textStyle) {
        return TextPaintExtensions_androidKt.hasFontAttributes(textStyle.toSpanStyle()) || textStyle.m6750getFontSynthesisZQGJjVo() != null;
    }

    private static final SpanStyle merge(SpanStyle spanStyle, SpanStyle spanStyle2) {
        return spanStyle == null ? spanStyle2 : spanStyle.merge(spanStyle2);
    }

    private static final void setFontAttributes(final Spannable spannable, TextStyle textStyle, List<? extends AnnotatedString.Range<? extends AnnotatedString.Annotation>> list, final Function4<? super FontFamily, ? super FontWeight, ? super FontStyle, ? super FontSynthesis, ? extends Typeface> function4) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            AnnotatedString.Range<? extends AnnotatedString.Annotation> range = list.get(i);
            if ((range.getItem() instanceof SpanStyle) && (TextPaintExtensions_androidKt.hasFontAttributes((SpanStyle) range.getItem()) || ((SpanStyle) range.getItem()).getFontSynthesis() != null)) {
                Intrinsics.checkNotNull(range, "null cannot be cast to non-null type androidx.compose.ui.text.AnnotatedString.Range<androidx.compose.ui.text.SpanStyle>");
                arrayList.add(range);
            }
        }
        ArrayList arrayList2 = arrayList;
        flattenFontStylesAndApply(hasFontAttributes(textStyle) ? new SpanStyle(0L, 0L, textStyle.getFontWeight(), textStyle.m6749getFontStyle4Lr2A7w(), textStyle.m6750getFontSynthesisZQGJjVo(), textStyle.getFontFamily(), (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, 65475, (DefaultConstructorMarker) null) : null, arrayList2, new Function3() { // from class: androidx.compose.ui.text.platform.extensions.SpannableExtensions_androidKt$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return SpannableExtensions_androidKt.setFontAttributes$lambda$12(spannable, function4, (SpanStyle) obj, ((Integer) obj2).intValue(), ((Integer) obj3).intValue());
            }
        });
    }
}
