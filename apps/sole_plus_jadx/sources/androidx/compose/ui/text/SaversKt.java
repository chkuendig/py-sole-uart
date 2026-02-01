package androidx.compose.ui.text;

import androidx.compose.runtime.saveable.Saver;
import androidx.compose.runtime.saveable.SaverKt;
import androidx.compose.runtime.saveable.SaverScope;
import androidx.compose.ui.geometry.Offset;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.LinkAnnotation;
import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.Locale;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.Hyphens;
import androidx.compose.ui.text.style.LineBreak;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextDirection;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.unit.TextUnitType;
import androidx.exifinterface.media.ExifInterface;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Savers.kt */
@Metadata(d1 = {"\u0000\u0094\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aI\u0010\u0000\u001a\u00020\u0001\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u00052\b\u0010\u0006\u001a\u0004\u0018\u0001H\u00042\u0006\u0010\u0007\u001a\u0002H\u00022\u0006\u0010\b\u001a\u00020\tH\u0000¢\u0006\u0002\u0010\n\u001aL\u0010\u000b\u001a\u0004\u0018\u0001H\f\"\u0014\b\u0000\u0010\u0002*\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u0003\"\u0004\b\u0001\u0010\u0004\"\u0004\b\u0002\u0010\u0005\"\u0006\b\u0003\u0010\f\u0018\u00012\b\u0010\u0006\u001a\u0004\u0018\u0001H\u00052\u0006\u0010\u0007\u001a\u0002H\u0002H\u0080\b¢\u0006\u0002\u0010\r\u001ay\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u0002H\u0004\u0012\u0004\u0012\u0002H\u00050\u000f\"\u0004\b\u0000\u0010\u0004\"\b\b\u0001\u0010\u0005*\u00020\u00012.\u0010\u0000\u001a*\u0012\u0004\u0012\u00020\t\u0012\u0013\u0012\u0011H\u0004¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0006\u0012\u0006\u0012\u0004\u0018\u0001H\u00050\u0010¢\u0006\u0002\b\u00132#\u0010\u000b\u001a\u001f\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\u0011\u0012\b\b\u0012\u0012\u0004\b\b(\u0006\u0012\u0006\u0012\u0004\u0018\u0001H\u00040\u0014H\u0002\u001a\u001f\u0010\u0000\u001a\u0004\u0018\u0001H\u0002\"\u0004\b\u0000\u0010\u00022\b\u0010\u0006\u001a\u0004\u0018\u0001H\u0002H\u0000¢\u0006\u0002\u0010\u0015\u001a\"\u0010\u000b\u001a\u0004\u0018\u0001H\f\"\u0006\b\u0000\u0010\f\u0018\u00012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001H\u0080\b¢\u0006\u0002\u0010\u0015\" \u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"(\u0010\u001a\u001a\u001c\u0012\u0012\u0012\u0010\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001c0\u001b\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"(\u0010\u001d\u001a\u0016\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00010\u001c\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b\u001e\u0010\u001f\"\u001a\u0010 \u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010\"\u001a\u000e\u0012\u0004\u0012\u00020#\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\b\n\u0000\u0012\u0004\b$\u0010\u001f\"\u001a\u0010%\u001a\u000e\u0012\u0004\u0012\u00020&\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"\u001a\u0010'\u001a\u000e\u0012\u0004\u0012\u00020(\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\" \u0010)\u001a\u000e\u0012\u0004\u0012\u00020*\u0012\u0004\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0019\" \u0010,\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b.\u0010\u0019\" \u0010/\u001a\u000e\u0012\u0004\u0012\u000200\u0012\u0004\u0012\u00020\u00010\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\u0019\"$\u00102\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00010\u0003*\u0002048@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u00106\"\u001a\u00107\u001a\u000e\u0012\u0004\u0012\u000203\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u0003*\u0002098@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010:\"\u001a\u0010;\u001a\u000e\u0012\u0004\u0012\u000208\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00010\u0003*\u00020=8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010>\"\u001a\u0010?\u001a\u000e\u0012\u0004\u0012\u00020<\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u00010\u0003*\u00020A8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010B\"\u001a\u0010C\u001a\u000e\u0012\u0004\u0012\u00020@\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\u00010\u0003*\u00020E8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010F\"\u001a\u0010G\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u00010\u0003*\u00020I8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010J\"\u001a\u0010K\u001a\u000e\u0012\u0004\u0012\u00020H\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u00010\u0003*\u00020M8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010N\"\u001a\u0010O\u001a\u000e\u0012\u0004\u0012\u00020L\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\u00010\u0003*\u00020Q8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010R\"\u001a\u0010S\u001a\u000e\u0012\u0004\u0012\u00020P\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\u00010\u0003*\u00020U8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010V\"\u001a\u0010W\u001a\u000e\u0012\u0004\u0012\u00020T\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020\u00010\u0003*\u00020Y8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010Z\"\u001a\u0010[\u001a\u000e\u0012\u0004\u0012\u00020X\u0012\u0004\u0012\u00020\u00010\u000fX\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\u00010\u0003*\u00020]8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010^\"\u001a\u0010_\u001a\u000e\u0012\u0004\u0012\u00020\\\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020\u00010\u0003*\u00020a8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010b\"\u001a\u0010c\u001a\u000e\u0012\u0004\u0012\u00020`\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000\"$\u00102\u001a\u000e\u0012\u0004\u0012\u00020d\u0012\u0004\u0012\u00020\u00010\u0003*\u00020e8@X\u0080\u0004¢\u0006\u0006\u001a\u0004\b5\u0010f\"\u001a\u0010g\u001a\u000e\u0012\u0004\u0012\u00020d\u0012\u0004\u0012\u00020\u00010\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006h"}, d2 = {"save", "", ExifInterface.GPS_DIRECTION_TRUE, "Landroidx/compose/runtime/saveable/Saver;", "Original", "Saveable", "value", "saver", "scope", "Landroidx/compose/runtime/saveable/SaverScope;", "(Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;Landroidx/compose/runtime/saveable/SaverScope;)Ljava/lang/Object;", "restore", "Result", "(Ljava/lang/Object;Landroidx/compose/runtime/saveable/Saver;)Ljava/lang/Object;", "NonNullValueClassSaver", "Landroidx/compose/ui/text/NonNullValueClassSaver;", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "Lkotlin/ExtensionFunctionType;", "Lkotlin/Function1;", "(Ljava/lang/Object;)Ljava/lang/Object;", "AnnotatedStringSaver", "Landroidx/compose/ui/text/AnnotatedString;", "getAnnotatedStringSaver", "()Landroidx/compose/runtime/saveable/Saver;", "AnnotationRangeListSaver", "", "Landroidx/compose/ui/text/AnnotatedString$Range;", "AnnotationRangeSaver", "getAnnotationRangeSaver$annotations", "()V", "VerbatimTtsAnnotationSaver", "Landroidx/compose/ui/text/VerbatimTtsAnnotation;", "UrlAnnotationSaver", "Landroidx/compose/ui/text/UrlAnnotation;", "getUrlAnnotationSaver$annotations", "LinkSaver", "Landroidx/compose/ui/text/LinkAnnotation$Url;", "ClickableSaver", "Landroidx/compose/ui/text/LinkAnnotation$Clickable;", "ParagraphStyleSaver", "Landroidx/compose/ui/text/ParagraphStyle;", "getParagraphStyleSaver", "SpanStyleSaver", "Landroidx/compose/ui/text/SpanStyle;", "getSpanStyleSaver", "TextLinkStylesSaver", "Landroidx/compose/ui/text/TextLinkStyles;", "getTextLinkStylesSaver", "Saver", "Landroidx/compose/ui/text/style/TextDecoration;", "Landroidx/compose/ui/text/style/TextDecoration$Companion;", "getSaver", "(Landroidx/compose/ui/text/style/TextDecoration$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextDecorationSaver", "Landroidx/compose/ui/text/style/TextGeometricTransform;", "Landroidx/compose/ui/text/style/TextGeometricTransform$Companion;", "(Landroidx/compose/ui/text/style/TextGeometricTransform$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextGeometricTransformSaver", "Landroidx/compose/ui/text/style/TextIndent;", "Landroidx/compose/ui/text/style/TextIndent$Companion;", "(Landroidx/compose/ui/text/style/TextIndent$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextIndentSaver", "Landroidx/compose/ui/text/font/FontWeight;", "Landroidx/compose/ui/text/font/FontWeight$Companion;", "(Landroidx/compose/ui/text/font/FontWeight$Companion;)Landroidx/compose/runtime/saveable/Saver;", "FontWeightSaver", "Landroidx/compose/ui/text/style/BaselineShift;", "Landroidx/compose/ui/text/style/BaselineShift$Companion;", "(Landroidx/compose/ui/text/style/BaselineShift$Companion;)Landroidx/compose/runtime/saveable/Saver;", "BaselineShiftSaver", "Landroidx/compose/ui/text/TextRange;", "Landroidx/compose/ui/text/TextRange$Companion;", "(Landroidx/compose/ui/text/TextRange$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextRangeSaver", "Landroidx/compose/ui/graphics/Shadow;", "Landroidx/compose/ui/graphics/Shadow$Companion;", "(Landroidx/compose/ui/graphics/Shadow$Companion;)Landroidx/compose/runtime/saveable/Saver;", "ShadowSaver", "Landroidx/compose/ui/graphics/Color;", "Landroidx/compose/ui/graphics/Color$Companion;", "(Landroidx/compose/ui/graphics/Color$Companion;)Landroidx/compose/runtime/saveable/Saver;", "ColorSaver", "Landroidx/compose/ui/unit/TextUnit;", "Landroidx/compose/ui/unit/TextUnit$Companion;", "(Landroidx/compose/ui/unit/TextUnit$Companion;)Landroidx/compose/runtime/saveable/Saver;", "TextUnitSaver", "Landroidx/compose/ui/geometry/Offset;", "Landroidx/compose/ui/geometry/Offset$Companion;", "(Landroidx/compose/ui/geometry/Offset$Companion;)Landroidx/compose/runtime/saveable/Saver;", "OffsetSaver", "Landroidx/compose/ui/text/intl/LocaleList;", "Landroidx/compose/ui/text/intl/LocaleList$Companion;", "(Landroidx/compose/ui/text/intl/LocaleList$Companion;)Landroidx/compose/runtime/saveable/Saver;", "LocaleListSaver", "Landroidx/compose/ui/text/intl/Locale;", "Landroidx/compose/ui/text/intl/Locale$Companion;", "(Landroidx/compose/ui/text/intl/Locale$Companion;)Landroidx/compose/runtime/saveable/Saver;", "LocaleSaver", "Landroidx/compose/ui/text/style/LineHeightStyle;", "Landroidx/compose/ui/text/style/LineHeightStyle$Companion;", "(Landroidx/compose/ui/text/style/LineHeightStyle$Companion;)Landroidx/compose/runtime/saveable/Saver;", "LineHeightStyleSaver", "ui-text"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class SaversKt {
    private static final Saver<AnnotatedString, Object> AnnotatedStringSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.AnnotatedStringSaver$lambda$5((SaverScope) obj, (AnnotatedString) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda2
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.AnnotatedStringSaver$lambda$6(obj);
        }
    });
    private static final Saver<List<AnnotatedString.Range<? extends Object>>, Object> AnnotationRangeListSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda14
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.AnnotationRangeListSaver$lambda$8((SaverScope) obj, (List) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda26
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.AnnotationRangeListSaver$lambda$10(obj);
        }
    });
    private static final Saver<AnnotatedString.Range<? extends Object>, Object> AnnotationRangeSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda31
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.AnnotationRangeSaver$lambda$11((SaverScope) obj, (AnnotatedString.Range) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda32
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.AnnotationRangeSaver$lambda$12(obj);
        }
    });
    private static final Saver<VerbatimTtsAnnotation, Object> VerbatimTtsAnnotationSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda34
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.VerbatimTtsAnnotationSaver$lambda$13((SaverScope) obj, (VerbatimTtsAnnotation) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda35
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.VerbatimTtsAnnotationSaver$lambda$14(obj);
        }
    });
    private static final Saver<UrlAnnotation, Object> UrlAnnotationSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda36
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.UrlAnnotationSaver$lambda$15((SaverScope) obj, (UrlAnnotation) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda37
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.UrlAnnotationSaver$lambda$16(obj);
        }
    });
    private static final Saver<LinkAnnotation.Url, Object> LinkSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda11
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.LinkSaver$lambda$17((SaverScope) obj, (LinkAnnotation.Url) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda22
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.LinkSaver$lambda$18(obj);
        }
    });
    private static final Saver<LinkAnnotation.Clickable, Object> ClickableSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda33
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.ClickableSaver$lambda$19((SaverScope) obj, (LinkAnnotation.Clickable) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda38
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.ClickableSaver$lambda$20(obj);
        }
    });
    private static final Saver<ParagraphStyle, Object> ParagraphStyleSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda39
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.ParagraphStyleSaver$lambda$21((SaverScope) obj, (ParagraphStyle) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda40
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.ParagraphStyleSaver$lambda$22(obj);
        }
    });
    private static final Saver<SpanStyle, Object> SpanStyleSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda41
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.SpanStyleSaver$lambda$23((SaverScope) obj, (SpanStyle) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda42
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.SpanStyleSaver$lambda$24(obj);
        }
    });
    private static final Saver<TextLinkStyles, Object> TextLinkStylesSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda43
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.TextLinkStylesSaver$lambda$25((SaverScope) obj, (TextLinkStyles) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda1
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.TextLinkStylesSaver$lambda$26(obj);
        }
    });
    private static final Saver<TextDecoration, Object> TextDecorationSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda3
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.TextDecorationSaver$lambda$27((SaverScope) obj, (TextDecoration) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda4
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.TextDecorationSaver$lambda$28(obj);
        }
    });
    private static final Saver<TextGeometricTransform, Object> TextGeometricTransformSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda5
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.TextGeometricTransformSaver$lambda$29((SaverScope) obj, (TextGeometricTransform) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda6
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.TextGeometricTransformSaver$lambda$30(obj);
        }
    });
    private static final Saver<TextIndent, Object> TextIndentSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda7
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.TextIndentSaver$lambda$31((SaverScope) obj, (TextIndent) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda8
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.TextIndentSaver$lambda$32(obj);
        }
    });
    private static final Saver<FontWeight, Object> FontWeightSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda9
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.FontWeightSaver$lambda$33((SaverScope) obj, (FontWeight) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda10
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.FontWeightSaver$lambda$34(obj);
        }
    });
    private static final Saver<BaselineShift, Object> BaselineShiftSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda12
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.BaselineShiftSaver$lambda$35((SaverScope) obj, (BaselineShift) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda13
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.BaselineShiftSaver$lambda$36(obj);
        }
    });
    private static final Saver<TextRange, Object> TextRangeSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda15
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.TextRangeSaver$lambda$37((SaverScope) obj, (TextRange) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda16
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.TextRangeSaver$lambda$38(obj);
        }
    });
    private static final Saver<Shadow, Object> ShadowSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda17
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.ShadowSaver$lambda$39((SaverScope) obj, (Shadow) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda18
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.ShadowSaver$lambda$40(obj);
        }
    });
    private static final NonNullValueClassSaver<Color, Object> ColorSaver = NonNullValueClassSaver(new Function2<SaverScope, Color, Object>() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(SaverScope saverScope, Color color) {
            return m6646invoke4WTKRHQ(saverScope, color.m4548unboximpl());
        }

        /* renamed from: invoke-4WTKRHQ, reason: not valid java name */
        public final Object m6646invoke4WTKRHQ(SaverScope saverScope, long j) {
            if (j == 16) {
                return false;
            }
            return Integer.valueOf(ColorKt.m4592toArgb8_81llA(j));
        }
    }, new Function1<Object, Color>() { // from class: androidx.compose.ui.text.SaversKt$ColorSaver$2
        @Override // kotlin.jvm.functions.Function1
        /* renamed from: invoke-ijrfgN4, reason: not valid java name and merged with bridge method [inline-methods] */
        public final Color invoke(Object obj) {
            if (Intrinsics.areEqual(obj, (Object) false)) {
                return Color.m4528boximpl(Color.INSTANCE.m4574getUnspecified0d7_KjU());
            }
            Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
            return Color.m4528boximpl(ColorKt.Color(((Integer) obj).intValue()));
        }
    });
    private static final NonNullValueClassSaver<TextUnit, Object> TextUnitSaver = NonNullValueClassSaver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda19
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.TextUnitSaver$lambda$41((SaverScope) obj, (TextUnit) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda20
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.TextUnitSaver$lambda$42(obj);
        }
    });
    private static final NonNullValueClassSaver<Offset, Object> OffsetSaver = NonNullValueClassSaver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda21
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.OffsetSaver$lambda$43((SaverScope) obj, (Offset) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda23
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.OffsetSaver$lambda$44(obj);
        }
    });
    private static final Saver<LocaleList, Object> LocaleListSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda24
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.LocaleListSaver$lambda$46((SaverScope) obj, (LocaleList) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda25
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.LocaleListSaver$lambda$48(obj);
        }
    });
    private static final Saver<Locale, Object> LocaleSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda27
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.LocaleSaver$lambda$49((SaverScope) obj, (Locale) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda28
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.LocaleSaver$lambda$50(obj);
        }
    });
    private static final Saver<LineHeightStyle, Object> LineHeightStyleSaver = SaverKt.Saver(new Function2() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda29
        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(Object obj, Object obj2) {
            return SaversKt.LineHeightStyleSaver$lambda$51((SaverScope) obj, (LineHeightStyle) obj2);
        }
    }, new Function1() { // from class: androidx.compose.ui.text.SaversKt$$ExternalSyntheticLambda30
        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Object obj) {
            return SaversKt.LineHeightStyleSaver$lambda$52(obj);
        }
    });

    /* compiled from: Savers.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AnnotationType.values().length];
            try {
                iArr[AnnotationType.Paragraph.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AnnotationType.Span.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AnnotationType.VerbatimTts.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AnnotationType.Url.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[AnnotationType.Link.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[AnnotationType.Clickable.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[AnnotationType.String.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private static /* synthetic */ void getAnnotationRangeSaver$annotations() {
    }

    private static /* synthetic */ void getUrlAnnotationSaver$annotations() {
    }

    public static final <T> T save(T t) {
        return t;
    }

    public static final <T extends Saver<Original, Saveable>, Original, Saveable> Object save(Original original, T t, SaverScope saverScope) {
        Object objSave;
        if (original == null || (objSave = t.save(saverScope, original)) == null) {
            return false;
        }
        return objSave;
    }

    public static final /* synthetic */ <T extends Saver<Original, Saveable>, Original, Saveable, Result> Result restore(Saveable saveable, T t) {
        if ((Intrinsics.areEqual((Object) saveable, (Object) false) && !(t instanceof NonNullValueClassSaver)) || saveable == null) {
            return null;
        }
        Result result = (Result) t.restore(saveable);
        Intrinsics.reifiedOperationMarker(1, "Result");
        return result;
    }

    private static final <Original, Saveable> NonNullValueClassSaver<Original, Saveable> NonNullValueClassSaver(final Function2<? super SaverScope, ? super Original, ? extends Saveable> function2, final Function1<? super Saveable, ? extends Original> function1) {
        return new NonNullValueClassSaver<Original, Saveable>() { // from class: androidx.compose.ui.text.SaversKt.NonNullValueClassSaver.1
            @Override // androidx.compose.runtime.saveable.Saver
            public Saveable save(SaverScope saverScope, Original original) {
                return function2.invoke(saverScope, original);
            }

            @Override // androidx.compose.runtime.saveable.Saver
            public Original restore(Saveable value) {
                return function1.invoke(value);
            }
        };
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final /* synthetic */ <Result> Result restore(Object obj) {
        if (obj == 0) {
            return null;
        }
        Intrinsics.reifiedOperationMarker(1, "Result");
        return obj;
    }

    public static final Saver<AnnotatedString, Object> getAnnotatedStringSaver() {
        return AnnotatedStringSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object AnnotatedStringSaver$lambda$5(SaverScope saverScope, AnnotatedString annotatedString) {
        return CollectionsKt.arrayListOf(save(annotatedString.getText()), save(annotatedString.getAnnotations$ui_text(), AnnotationRangeListSaver, saverScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString AnnotatedStringSaver$lambda$6(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(1);
        Saver<List<AnnotatedString.Range<? extends Object>>, Object> saver = AnnotationRangeListSaver;
        List<AnnotatedString.Range<? extends Object>> listRestore = ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
        Object obj3 = list.get(0);
        String str = obj3 != null ? (String) obj3 : null;
        Intrinsics.checkNotNull(str);
        return new AnnotatedString(listRestore, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final List AnnotationRangeListSaver$lambda$10(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj2 = list.get(i);
            ArrayList arrayList2 = arrayList;
            Saver<AnnotatedString.Range<? extends Object>, Object> saver = AnnotationRangeSaver;
            AnnotatedString.Range<? extends Object> rangeRestore = null;
            if ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) {
                rangeRestore = saver.restore(obj2);
            }
            Intrinsics.checkNotNull(rangeRestore);
            arrayList2.add(rangeRestore);
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object AnnotationRangeSaver$lambda$11(SaverScope saverScope, AnnotatedString.Range range) {
        AnnotationType annotationType;
        Object objSave;
        Object item = range.getItem();
        if (item instanceof ParagraphStyle) {
            annotationType = AnnotationType.Paragraph;
        } else if (item instanceof SpanStyle) {
            annotationType = AnnotationType.Span;
        } else if (item instanceof VerbatimTtsAnnotation) {
            annotationType = AnnotationType.VerbatimTts;
        } else if (item instanceof UrlAnnotation) {
            annotationType = AnnotationType.Url;
        } else if (item instanceof LinkAnnotation.Url) {
            annotationType = AnnotationType.Link;
        } else if (item instanceof LinkAnnotation.Clickable) {
            annotationType = AnnotationType.Clickable;
        } else {
            if (!(item instanceof StringAnnotation)) {
                throw new UnsupportedOperationException();
            }
            annotationType = AnnotationType.String;
        }
        switch (WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()]) {
            case 1:
                Object item2 = range.getItem();
                Intrinsics.checkNotNull(item2, "null cannot be cast to non-null type androidx.compose.ui.text.ParagraphStyle");
                objSave = save((ParagraphStyle) item2, ParagraphStyleSaver, saverScope);
                break;
            case 2:
                Object item3 = range.getItem();
                Intrinsics.checkNotNull(item3, "null cannot be cast to non-null type androidx.compose.ui.text.SpanStyle");
                objSave = save((SpanStyle) item3, SpanStyleSaver, saverScope);
                break;
            case 3:
                Object item4 = range.getItem();
                Intrinsics.checkNotNull(item4, "null cannot be cast to non-null type androidx.compose.ui.text.VerbatimTtsAnnotation");
                objSave = save((VerbatimTtsAnnotation) item4, VerbatimTtsAnnotationSaver, saverScope);
                break;
            case 4:
                Object item5 = range.getItem();
                Intrinsics.checkNotNull(item5, "null cannot be cast to non-null type androidx.compose.ui.text.UrlAnnotation");
                objSave = save((UrlAnnotation) item5, UrlAnnotationSaver, saverScope);
                break;
            case 5:
                Object item6 = range.getItem();
                Intrinsics.checkNotNull(item6, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Url");
                objSave = save((LinkAnnotation.Url) item6, LinkSaver, saverScope);
                break;
            case 6:
                Object item7 = range.getItem();
                Intrinsics.checkNotNull(item7, "null cannot be cast to non-null type androidx.compose.ui.text.LinkAnnotation.Clickable");
                objSave = save((LinkAnnotation.Clickable) item7, ClickableSaver, saverScope);
                break;
            case 7:
                Object item8 = range.getItem();
                Intrinsics.checkNotNull(item8, "null cannot be cast to non-null type androidx.compose.ui.text.StringAnnotation");
                objSave = save(((StringAnnotation) item8).m6671unboximpl());
                break;
            default:
                throw new NoWhenBranchMatchedException();
        }
        return CollectionsKt.arrayListOf(save(annotationType), objSave, save(Integer.valueOf(range.getStart())), save(Integer.valueOf(range.getEnd())), save(range.getTag()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AnnotatedString.Range AnnotationRangeSaver$lambda$12(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        ParagraphStyle paragraphStyleRestore = null;
        clickableRestore = null;
        LinkAnnotation.Clickable clickableRestore = null;
        urlRestore = null;
        LinkAnnotation.Url urlRestore = null;
        urlAnnotationRestore = null;
        UrlAnnotation urlAnnotationRestore = null;
        verbatimTtsAnnotationRestore = null;
        VerbatimTtsAnnotation verbatimTtsAnnotationRestore = null;
        spanStyleRestore = null;
        SpanStyle spanStyleRestore = null;
        paragraphStyleRestore = null;
        AnnotationType annotationType = obj2 != null ? (AnnotationType) obj2 : null;
        Intrinsics.checkNotNull(annotationType);
        Object obj3 = list.get(2);
        Integer num = obj3 != null ? (Integer) obj3 : null;
        Intrinsics.checkNotNull(num);
        int iIntValue = num.intValue();
        Object obj4 = list.get(3);
        Integer num2 = obj4 != null ? (Integer) obj4 : null;
        Intrinsics.checkNotNull(num2);
        int iIntValue2 = num2.intValue();
        Object obj5 = list.get(4);
        String str = obj5 != null ? (String) obj5 : null;
        Intrinsics.checkNotNull(str);
        switch (WhenMappings.$EnumSwitchMapping$0[annotationType.ordinal()]) {
            case 1:
                Object obj6 = list.get(1);
                Saver<ParagraphStyle, Object> saver = ParagraphStyleSaver;
                if ((!Intrinsics.areEqual(obj6, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj6 != null) {
                    paragraphStyleRestore = saver.restore(obj6);
                }
                Intrinsics.checkNotNull(paragraphStyleRestore);
                return new AnnotatedString.Range(paragraphStyleRestore, iIntValue, iIntValue2, str);
            case 2:
                Object obj7 = list.get(1);
                Saver<SpanStyle, Object> saver2 = SpanStyleSaver;
                if ((!Intrinsics.areEqual(obj7, (Object) false) || (saver2 instanceof NonNullValueClassSaver)) && obj7 != null) {
                    spanStyleRestore = saver2.restore(obj7);
                }
                Intrinsics.checkNotNull(spanStyleRestore);
                return new AnnotatedString.Range(spanStyleRestore, iIntValue, iIntValue2, str);
            case 3:
                Object obj8 = list.get(1);
                Saver<VerbatimTtsAnnotation, Object> saver3 = VerbatimTtsAnnotationSaver;
                if ((!Intrinsics.areEqual(obj8, (Object) false) || (saver3 instanceof NonNullValueClassSaver)) && obj8 != null) {
                    verbatimTtsAnnotationRestore = saver3.restore(obj8);
                }
                Intrinsics.checkNotNull(verbatimTtsAnnotationRestore);
                return new AnnotatedString.Range(verbatimTtsAnnotationRestore, iIntValue, iIntValue2, str);
            case 4:
                Object obj9 = list.get(1);
                Saver<UrlAnnotation, Object> saver4 = UrlAnnotationSaver;
                if ((!Intrinsics.areEqual(obj9, (Object) false) || (saver4 instanceof NonNullValueClassSaver)) && obj9 != null) {
                    urlAnnotationRestore = saver4.restore(obj9);
                }
                Intrinsics.checkNotNull(urlAnnotationRestore);
                return new AnnotatedString.Range(urlAnnotationRestore, iIntValue, iIntValue2, str);
            case 5:
                Object obj10 = list.get(1);
                Saver<LinkAnnotation.Url, Object> saver5 = LinkSaver;
                if ((!Intrinsics.areEqual(obj10, (Object) false) || (saver5 instanceof NonNullValueClassSaver)) && obj10 != null) {
                    urlRestore = saver5.restore(obj10);
                }
                Intrinsics.checkNotNull(urlRestore);
                return new AnnotatedString.Range(urlRestore, iIntValue, iIntValue2, str);
            case 6:
                Object obj11 = list.get(1);
                Saver<LinkAnnotation.Clickable, Object> saver6 = ClickableSaver;
                if ((!Intrinsics.areEqual(obj11, (Object) false) || (saver6 instanceof NonNullValueClassSaver)) && obj11 != null) {
                    clickableRestore = saver6.restore(obj11);
                }
                Intrinsics.checkNotNull(clickableRestore);
                return new AnnotatedString.Range(clickableRestore, iIntValue, iIntValue2, str);
            case 7:
                Object obj12 = list.get(1);
                String str2 = obj12 != null ? (String) obj12 : null;
                Intrinsics.checkNotNull(str2);
                return new AnnotatedString.Range(StringAnnotation.m6665boximpl(StringAnnotation.m6666constructorimpl(str2)), iIntValue, iIntValue2, str);
            default:
                throw new NoWhenBranchMatchedException();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object VerbatimTtsAnnotationSaver$lambda$13(SaverScope saverScope, VerbatimTtsAnnotation verbatimTtsAnnotation) {
        return save(verbatimTtsAnnotation.getVerbatim());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final VerbatimTtsAnnotation VerbatimTtsAnnotationSaver$lambda$14(Object obj) {
        String str = obj != null ? (String) obj : null;
        Intrinsics.checkNotNull(str);
        return new VerbatimTtsAnnotation(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object UrlAnnotationSaver$lambda$15(SaverScope saverScope, UrlAnnotation urlAnnotation) {
        return save(urlAnnotation.getUrl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final UrlAnnotation UrlAnnotationSaver$lambda$16(Object obj) {
        String str = obj != null ? (String) obj : null;
        Intrinsics.checkNotNull(str);
        return new UrlAnnotation(str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object LinkSaver$lambda$17(SaverScope saverScope, LinkAnnotation.Url url) {
        return CollectionsKt.arrayListOf(save(url.getUrl()), save(url.getStyles(), TextLinkStylesSaver, saverScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinkAnnotation.Url LinkSaver$lambda$18(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        TextLinkStyles textLinkStylesRestore = null;
        String str = obj2 != null ? (String) obj2 : null;
        Intrinsics.checkNotNull(str);
        Object obj3 = list.get(1);
        Saver<TextLinkStyles, Object> saver = TextLinkStylesSaver;
        if ((!Intrinsics.areEqual(obj3, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj3 != null) {
            textLinkStylesRestore = saver.restore(obj3);
        }
        return new LinkAnnotation.Url(str, textLinkStylesRestore, null, 4, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ClickableSaver$lambda$19(SaverScope saverScope, LinkAnnotation.Clickable clickable) {
        return CollectionsKt.arrayListOf(save(clickable.getTag()), save(clickable.getStyles(), TextLinkStylesSaver, saverScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LinkAnnotation.Clickable ClickableSaver$lambda$20(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        String str = obj2 != null ? (String) obj2 : null;
        Intrinsics.checkNotNull(str);
        Object obj3 = list.get(1);
        Saver<TextLinkStyles, Object> saver = TextLinkStylesSaver;
        return new LinkAnnotation.Clickable(str, ((!Intrinsics.areEqual(obj3, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj3 != null) ? saver.restore(obj3) : null, null);
    }

    public static final Saver<ParagraphStyle, Object> getParagraphStyleSaver() {
        return ParagraphStyleSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ParagraphStyleSaver$lambda$21(SaverScope saverScope, ParagraphStyle paragraphStyle) {
        return CollectionsKt.arrayListOf(save(TextAlign.m7132boximpl(paragraphStyle.getTextAlign())), save(TextDirection.m7146boximpl(paragraphStyle.getTextDirection())), save(TextUnit.m7439boximpl(paragraphStyle.getLineHeight()), getSaver(TextUnit.INSTANCE), saverScope), save(paragraphStyle.getTextIndent(), getSaver(TextIndent.INSTANCE), saverScope), save(paragraphStyle.getPlatformStyle(), Savers_androidKt.getSaver(PlatformParagraphStyle.INSTANCE), saverScope), save(paragraphStyle.getLineHeightStyle(), getSaver(LineHeightStyle.INSTANCE), saverScope), save(LineBreak.m7040boximpl(paragraphStyle.getLineBreak()), Savers_androidKt.getSaver(LineBreak.INSTANCE), saverScope), save(Hyphens.m7030boximpl(paragraphStyle.getHyphens())), save(paragraphStyle.getTextMotion(), Savers_androidKt.getSaver(TextMotion.INSTANCE), saverScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ParagraphStyle ParagraphStyleSaver$lambda$22(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        TextAlign textAlign = obj2 != null ? (TextAlign) obj2 : null;
        Intrinsics.checkNotNull(textAlign);
        int value = textAlign.getValue();
        Object obj3 = list.get(1);
        TextDirection textDirection = obj3 != null ? (TextDirection) obj3 : null;
        Intrinsics.checkNotNull(textDirection);
        int value2 = textDirection.getValue();
        Object obj4 = list.get(2);
        Saver<TextUnit, Object> saver = getSaver(TextUnit.INSTANCE);
        TextUnit textUnitRestore = ((!Intrinsics.areEqual(obj4, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj4 != null) ? saver.restore(obj4) : null;
        Intrinsics.checkNotNull(textUnitRestore);
        long packedValue = textUnitRestore.getPackedValue();
        Object obj5 = list.get(3);
        Saver<TextIndent, Object> saver2 = getSaver(TextIndent.INSTANCE);
        TextIndent textIndentRestore = ((!Intrinsics.areEqual(obj5, (Object) false) || (saver2 instanceof NonNullValueClassSaver)) && obj5 != null) ? saver2.restore(obj5) : null;
        Object obj6 = list.get(4);
        Saver<PlatformParagraphStyle, Object> saver3 = Savers_androidKt.getSaver(PlatformParagraphStyle.INSTANCE);
        PlatformParagraphStyle platformParagraphStyleRestore = ((!Intrinsics.areEqual(obj6, (Object) false) || (saver3 instanceof NonNullValueClassSaver)) && obj6 != null) ? saver3.restore(obj6) : null;
        Object obj7 = list.get(5);
        Saver<LineHeightStyle, Object> saver4 = getSaver(LineHeightStyle.INSTANCE);
        LineHeightStyle lineHeightStyleRestore = ((!Intrinsics.areEqual(obj7, (Object) false) || (saver4 instanceof NonNullValueClassSaver)) && obj7 != null) ? saver4.restore(obj7) : null;
        Object obj8 = list.get(6);
        Saver<LineBreak, Object> saver5 = Savers_androidKt.getSaver(LineBreak.INSTANCE);
        LineBreak lineBreakRestore = ((!Intrinsics.areEqual(obj8, (Object) false) || (saver5 instanceof NonNullValueClassSaver)) && obj8 != null) ? saver5.restore(obj8) : null;
        Intrinsics.checkNotNull(lineBreakRestore);
        int mask = lineBreakRestore.getMask();
        Object obj9 = list.get(7);
        Hyphens hyphens = obj9 != null ? (Hyphens) obj9 : null;
        Intrinsics.checkNotNull(hyphens);
        int value3 = hyphens.getValue();
        Object obj10 = list.get(8);
        Saver<TextMotion, Object> saver6 = Savers_androidKt.getSaver(TextMotion.INSTANCE);
        return new ParagraphStyle(value, value2, packedValue, textIndentRestore, platformParagraphStyleRestore, lineHeightStyleRestore, mask, value3, ((!Intrinsics.areEqual(obj10, (Object) false) || (saver6 instanceof NonNullValueClassSaver)) && obj10 != null) ? saver6.restore(obj10) : null, (DefaultConstructorMarker) null);
    }

    public static final Saver<SpanStyle, Object> getSpanStyleSaver() {
        return SpanStyleSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object SpanStyleSaver$lambda$23(SaverScope saverScope, SpanStyle spanStyle) {
        return CollectionsKt.arrayListOf(save(Color.m4528boximpl(spanStyle.m6658getColor0d7_KjU()), getSaver(Color.INSTANCE), saverScope), save(TextUnit.m7439boximpl(spanStyle.getFontSize()), getSaver(TextUnit.INSTANCE), saverScope), save(spanStyle.getFontWeight(), getSaver(FontWeight.INSTANCE), saverScope), save(spanStyle.getFontStyle()), save(spanStyle.getFontSynthesis()), save(-1), save(spanStyle.getFontFeatureSettings()), save(TextUnit.m7439boximpl(spanStyle.getLetterSpacing()), getSaver(TextUnit.INSTANCE), saverScope), save(spanStyle.getBaselineShift(), getSaver(BaselineShift.INSTANCE), saverScope), save(spanStyle.getTextGeometricTransform(), getSaver(TextGeometricTransform.INSTANCE), saverScope), save(spanStyle.getLocaleList(), getSaver(LocaleList.INSTANCE), saverScope), save(Color.m4528boximpl(spanStyle.getBackground()), getSaver(Color.INSTANCE), saverScope), save(spanStyle.getTextDecoration(), getSaver(TextDecoration.INSTANCE), saverScope), save(spanStyle.getShadow(), getSaver(Shadow.INSTANCE), saverScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SpanStyle SpanStyleSaver$lambda$24(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Saver<Color, Object> saver = getSaver(Color.INSTANCE);
        Color colorRestore = ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
        Intrinsics.checkNotNull(colorRestore);
        long jM4548unboximpl = colorRestore.m4548unboximpl();
        Object obj3 = list.get(1);
        Saver<TextUnit, Object> saver2 = getSaver(TextUnit.INSTANCE);
        TextUnit textUnitRestore = ((!Intrinsics.areEqual(obj3, (Object) false) || (saver2 instanceof NonNullValueClassSaver)) && obj3 != null) ? saver2.restore(obj3) : null;
        Intrinsics.checkNotNull(textUnitRestore);
        long packedValue = textUnitRestore.getPackedValue();
        Object obj4 = list.get(2);
        Saver<FontWeight, Object> saver3 = getSaver(FontWeight.INSTANCE);
        FontWeight fontWeightRestore = ((!Intrinsics.areEqual(obj4, (Object) false) || (saver3 instanceof NonNullValueClassSaver)) && obj4 != null) ? saver3.restore(obj4) : null;
        Object obj5 = list.get(3);
        FontStyle fontStyle = obj5 != null ? (FontStyle) obj5 : null;
        Object obj6 = list.get(4);
        FontSynthesis fontSynthesis = obj6 != null ? (FontSynthesis) obj6 : null;
        Object obj7 = list.get(6);
        String str = obj7 != null ? (String) obj7 : null;
        Object obj8 = list.get(7);
        Saver<TextUnit, Object> saver4 = getSaver(TextUnit.INSTANCE);
        TextUnit textUnitRestore2 = ((!Intrinsics.areEqual(obj8, (Object) false) || (saver4 instanceof NonNullValueClassSaver)) && obj8 != null) ? saver4.restore(obj8) : null;
        Intrinsics.checkNotNull(textUnitRestore2);
        long packedValue2 = textUnitRestore2.getPackedValue();
        Object obj9 = list.get(8);
        Saver<BaselineShift, Object> saver5 = getSaver(BaselineShift.INSTANCE);
        BaselineShift baselineShiftRestore = ((!Intrinsics.areEqual(obj9, (Object) false) || (saver5 instanceof NonNullValueClassSaver)) && obj9 != null) ? saver5.restore(obj9) : null;
        Object obj10 = list.get(9);
        Saver<TextGeometricTransform, Object> saver6 = getSaver(TextGeometricTransform.INSTANCE);
        TextGeometricTransform textGeometricTransformRestore = ((!Intrinsics.areEqual(obj10, (Object) false) || (saver6 instanceof NonNullValueClassSaver)) && obj10 != null) ? saver6.restore(obj10) : null;
        Object obj11 = list.get(10);
        Saver<LocaleList, Object> saver7 = getSaver(LocaleList.INSTANCE);
        LocaleList localeListRestore = ((!Intrinsics.areEqual(obj11, (Object) false) || (saver7 instanceof NonNullValueClassSaver)) && obj11 != null) ? saver7.restore(obj11) : null;
        Object obj12 = list.get(11);
        Saver<Color, Object> saver8 = getSaver(Color.INSTANCE);
        Color colorRestore2 = ((!Intrinsics.areEqual(obj12, (Object) false) || (saver8 instanceof NonNullValueClassSaver)) && obj12 != null) ? saver8.restore(obj12) : null;
        Intrinsics.checkNotNull(colorRestore2);
        long jM4548unboximpl2 = colorRestore2.m4548unboximpl();
        Object obj13 = list.get(12);
        Saver<TextDecoration, Object> saver9 = getSaver(TextDecoration.INSTANCE);
        TextDecoration textDecorationRestore = ((!Intrinsics.areEqual(obj13, (Object) false) || (saver9 instanceof NonNullValueClassSaver)) && obj13 != null) ? saver9.restore(obj13) : null;
        Object obj14 = list.get(13);
        Saver<Shadow, Object> saver10 = getSaver(Shadow.INSTANCE);
        return new SpanStyle(jM4548unboximpl, packedValue, fontWeightRestore, fontStyle, fontSynthesis, (FontFamily) null, str, packedValue2, baselineShiftRestore, textGeometricTransformRestore, localeListRestore, jM4548unboximpl2, textDecorationRestore, ((!Intrinsics.areEqual(obj14, (Object) false) || (saver10 instanceof NonNullValueClassSaver)) && obj14 != null) ? saver10.restore(obj14) : null, (PlatformSpanStyle) null, (DrawStyle) null, 49184, (DefaultConstructorMarker) null);
    }

    public static final Saver<TextLinkStyles, Object> getTextLinkStylesSaver() {
        return TextLinkStylesSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TextLinkStylesSaver$lambda$25(SaverScope saverScope, TextLinkStyles textLinkStyles) {
        SpanStyle style = textLinkStyles.getStyle();
        Saver<SpanStyle, Object> saver = SpanStyleSaver;
        return CollectionsKt.arrayListOf(save(style, saver, saverScope), save(textLinkStyles.getFocusedStyle(), saver, saverScope), save(textLinkStyles.getHoveredStyle(), saver, saverScope), save(textLinkStyles.getPressedStyle(), saver, saverScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextLinkStyles TextLinkStylesSaver$lambda$26(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Saver<SpanStyle, Object> saver = SpanStyleSaver;
        SpanStyle spanStyleRestore = null;
        SpanStyle spanStyleRestore2 = ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
        Object obj3 = list.get(1);
        SpanStyle spanStyleRestore3 = ((!Intrinsics.areEqual(obj3, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj3 != null) ? saver.restore(obj3) : null;
        Object obj4 = list.get(2);
        SpanStyle spanStyleRestore4 = ((!Intrinsics.areEqual(obj4, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj4 != null) ? saver.restore(obj4) : null;
        Object obj5 = list.get(3);
        if ((!Intrinsics.areEqual(obj5, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj5 != null) {
            spanStyleRestore = saver.restore(obj5);
        }
        return new TextLinkStyles(spanStyleRestore2, spanStyleRestore3, spanStyleRestore4, spanStyleRestore);
    }

    public static final Saver<TextDecoration, Object> getSaver(TextDecoration.Companion companion) {
        return TextDecorationSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TextDecorationSaver$lambda$27(SaverScope saverScope, TextDecoration textDecoration) {
        return Integer.valueOf(textDecoration.getMask());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextDecoration TextDecorationSaver$lambda$28(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return new TextDecoration(((Integer) obj).intValue());
    }

    public static final Saver<TextGeometricTransform, Object> getSaver(TextGeometricTransform.Companion companion) {
        return TextGeometricTransformSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TextGeometricTransformSaver$lambda$29(SaverScope saverScope, TextGeometricTransform textGeometricTransform) {
        return CollectionsKt.arrayListOf(Float.valueOf(textGeometricTransform.getScaleX()), Float.valueOf(textGeometricTransform.getSkewX()));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextGeometricTransform TextGeometricTransformSaver$lambda$30(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Float>");
        List list = (List) obj;
        return new TextGeometricTransform(((Number) list.get(0)).floatValue(), ((Number) list.get(1)).floatValue());
    }

    public static final Saver<TextIndent, Object> getSaver(TextIndent.Companion companion) {
        return TextIndentSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TextIndentSaver$lambda$31(SaverScope saverScope, TextIndent textIndent) {
        return CollectionsKt.arrayListOf(save(TextUnit.m7439boximpl(textIndent.getFirstLine()), getSaver(TextUnit.INSTANCE), saverScope), save(TextUnit.m7439boximpl(textIndent.getRestLine()), getSaver(TextUnit.INSTANCE), saverScope));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextIndent TextIndentSaver$lambda$32(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Saver<TextUnit, Object> saver = getSaver(TextUnit.INSTANCE);
        TextUnit textUnitRestore = null;
        TextUnit textUnitRestore2 = ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
        Intrinsics.checkNotNull(textUnitRestore2);
        long packedValue = textUnitRestore2.getPackedValue();
        Object obj3 = list.get(1);
        Saver<TextUnit, Object> saver2 = getSaver(TextUnit.INSTANCE);
        if ((!Intrinsics.areEqual(obj3, (Object) false) || (saver2 instanceof NonNullValueClassSaver)) && obj3 != null) {
            textUnitRestore = saver2.restore(obj3);
        }
        Intrinsics.checkNotNull(textUnitRestore);
        return new TextIndent(packedValue, textUnitRestore.getPackedValue(), null);
    }

    public static final Saver<FontWeight, Object> getSaver(FontWeight.Companion companion) {
        return FontWeightSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object FontWeightSaver$lambda$33(SaverScope saverScope, FontWeight fontWeight) {
        return Integer.valueOf(fontWeight.getWeight());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FontWeight FontWeightSaver$lambda$34(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Int");
        return new FontWeight(((Integer) obj).intValue());
    }

    public static final Saver<BaselineShift, Object> getSaver(BaselineShift.Companion companion) {
        return BaselineShiftSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object BaselineShiftSaver$lambda$35(SaverScope saverScope, BaselineShift baselineShift) {
        return Float.valueOf(baselineShift.m7017unboximpl());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final BaselineShift BaselineShiftSaver$lambda$36(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.Float");
        return BaselineShift.m7011boximpl(BaselineShift.m7012constructorimpl(((Float) obj).floatValue()));
    }

    public static final Saver<TextRange, Object> getSaver(TextRange.Companion companion) {
        return TextRangeSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object TextRangeSaver$lambda$37(SaverScope saverScope, TextRange textRange) {
        return CollectionsKt.arrayListOf(save(Integer.valueOf(TextRange.m6717getStartimpl(textRange.getPackedValue()))), save(Integer.valueOf(TextRange.m6712getEndimpl(textRange.getPackedValue()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextRange TextRangeSaver$lambda$38(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Integer num = obj2 != null ? (Integer) obj2 : null;
        Intrinsics.checkNotNull(num);
        int iIntValue = num.intValue();
        Object obj3 = list.get(1);
        Integer num2 = obj3 != null ? (Integer) obj3 : null;
        Intrinsics.checkNotNull(num2);
        return TextRange.m6705boximpl(TextRangeKt.TextRange(iIntValue, num2.intValue()));
    }

    public static final Saver<Shadow, Object> getSaver(Shadow.Companion companion) {
        return ShadowSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object ShadowSaver$lambda$39(SaverScope saverScope, Shadow shadow) {
        return CollectionsKt.arrayListOf(save(Color.m4528boximpl(shadow.getColor()), getSaver(Color.INSTANCE), saverScope), save(Offset.m4283boximpl(shadow.getOffset()), getSaver(Offset.INSTANCE), saverScope), save(Float.valueOf(shadow.getBlurRadius())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Shadow ShadowSaver$lambda$40(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Saver<Color, Object> saver = getSaver(Color.INSTANCE);
        Color colorRestore = ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) ? saver.restore(obj2) : null;
        Intrinsics.checkNotNull(colorRestore);
        long jM4548unboximpl = colorRestore.m4548unboximpl();
        Object obj3 = list.get(1);
        Saver<Offset, Object> saver2 = getSaver(Offset.INSTANCE);
        Offset offsetRestore = ((!Intrinsics.areEqual(obj3, (Object) false) || (saver2 instanceof NonNullValueClassSaver)) && obj3 != null) ? saver2.restore(obj3) : null;
        Intrinsics.checkNotNull(offsetRestore);
        long jM4304unboximpl = offsetRestore.m4304unboximpl();
        Object obj4 = list.get(2);
        Float f = obj4 != null ? (Float) obj4 : null;
        Intrinsics.checkNotNull(f);
        return new Shadow(jM4548unboximpl, jM4304unboximpl, f.floatValue(), null);
    }

    public static final Saver<Color, Object> getSaver(Color.Companion companion) {
        return ColorSaver;
    }

    public static final Saver<TextUnit, Object> getSaver(TextUnit.Companion companion) {
        return TextUnitSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object TextUnitSaver$lambda$41(SaverScope saverScope, TextUnit textUnit) {
        if (textUnit == null ? false : TextUnit.m7446equalsimpl0(textUnit.getPackedValue(), TextUnit.INSTANCE.m7460getUnspecifiedXSAIIZE())) {
            return (Serializable) false;
        }
        return CollectionsKt.arrayListOf(save(Float.valueOf(TextUnit.m7449getValueimpl(textUnit.getPackedValue()))), save(TextUnitType.m7474boximpl(TextUnit.m7448getTypeUIouoOA(textUnit.getPackedValue()))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextUnit TextUnitSaver$lambda$42(Object obj) {
        if (Intrinsics.areEqual(obj, (Object) false)) {
            return TextUnit.m7439boximpl(TextUnit.INSTANCE.m7460getUnspecifiedXSAIIZE());
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Float f = obj2 != null ? (Float) obj2 : null;
        Intrinsics.checkNotNull(f);
        float fFloatValue = f.floatValue();
        Object obj3 = list.get(1);
        TextUnitType textUnitType = obj3 != null ? (TextUnitType) obj3 : null;
        Intrinsics.checkNotNull(textUnitType);
        return TextUnit.m7439boximpl(TextUnitKt.m7461TextUnitanM5pPY(fFloatValue, textUnitType.getType()));
    }

    public static final Saver<Offset, Object> getSaver(Offset.Companion companion) {
        return OffsetSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final Object OffsetSaver$lambda$43(SaverScope saverScope, Offset offset) {
        return offset == null ? false : Offset.m4291equalsimpl0(offset.m4304unboximpl(), Offset.INSTANCE.m4309getUnspecifiedF1C5BW0()) ? (Serializable) false : CollectionsKt.arrayListOf(save(Float.valueOf(Float.intBitsToFloat((int) (offset.m4304unboximpl() >> 32)))), save(Float.valueOf(Float.intBitsToFloat((int) (offset.m4304unboximpl() & 4294967295L)))));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Offset OffsetSaver$lambda$44(Object obj) {
        if (Intrinsics.areEqual(obj, (Object) false)) {
            return Offset.m4283boximpl(Offset.INSTANCE.m4309getUnspecifiedF1C5BW0());
        }
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any?>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        Float f = obj2 != null ? (Float) obj2 : null;
        Intrinsics.checkNotNull(f);
        float fFloatValue = f.floatValue();
        Object obj3 = list.get(1);
        Intrinsics.checkNotNull(obj3 != null ? (Float) obj3 : null);
        return Offset.m4283boximpl(Offset.m4286constructorimpl((Float.floatToRawIntBits(fFloatValue) << 32) | (Float.floatToRawIntBits(r1.floatValue()) & 4294967295L)));
    }

    public static final Saver<LocaleList, Object> getSaver(LocaleList.Companion companion) {
        return LocaleListSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object LocaleListSaver$lambda$46(SaverScope saverScope, LocaleList localeList) {
        List<Locale> localeList2 = localeList.getLocaleList();
        ArrayList arrayList = new ArrayList(localeList2.size());
        int size = localeList2.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(save(localeList2.get(i), getSaver(Locale.INSTANCE), saverScope));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LocaleList LocaleListSaver$lambda$48(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Object obj2 = list.get(i);
            ArrayList arrayList2 = arrayList;
            Saver<Locale, Object> saver = getSaver(Locale.INSTANCE);
            Locale localeRestore = null;
            if ((!Intrinsics.areEqual(obj2, (Object) false) || (saver instanceof NonNullValueClassSaver)) && obj2 != null) {
                localeRestore = saver.restore(obj2);
            }
            Intrinsics.checkNotNull(localeRestore);
            arrayList2.add(localeRestore);
        }
        return new LocaleList(arrayList);
    }

    public static final Saver<Locale, Object> getSaver(Locale.Companion companion) {
        return LocaleSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object LocaleSaver$lambda$49(SaverScope saverScope, Locale locale) {
        return locale.toLanguageTag();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Locale LocaleSaver$lambda$50(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.String");
        return new Locale((String) obj);
    }

    public static final Saver<LineHeightStyle, Object> getSaver(LineHeightStyle.Companion companion) {
        return LineHeightStyleSaver;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object LineHeightStyleSaver$lambda$51(SaverScope saverScope, LineHeightStyle lineHeightStyle) {
        return CollectionsKt.arrayListOf(save(LineHeightStyle.Alignment.m7099boximpl(lineHeightStyle.getAlignment())), save(LineHeightStyle.Trim.m7119boximpl(lineHeightStyle.getTrim())), save(LineHeightStyle.Mode.m7110boximpl(lineHeightStyle.getMode())));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final LineHeightStyle LineHeightStyleSaver$lambda$52(Object obj) {
        Intrinsics.checkNotNull(obj, "null cannot be cast to non-null type kotlin.collections.List<kotlin.Any>");
        List list = (List) obj;
        Object obj2 = list.get(0);
        LineHeightStyle.Alignment alignment = obj2 != null ? (LineHeightStyle.Alignment) obj2 : null;
        Intrinsics.checkNotNull(alignment);
        float topRatio = alignment.getTopRatio();
        Object obj3 = list.get(1);
        LineHeightStyle.Trim trim = obj3 != null ? (LineHeightStyle.Trim) obj3 : null;
        Intrinsics.checkNotNull(trim);
        int value = trim.getValue();
        Object obj4 = list.get(2);
        LineHeightStyle.Mode mode = obj4 != null ? (LineHeightStyle.Mode) obj4 : null;
        Intrinsics.checkNotNull(mode);
        return new LineHeightStyle(topRatio, value, mode.getValue(), null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object AnnotationRangeListSaver$lambda$8(SaverScope saverScope, List list) {
        ArrayList arrayList = new ArrayList(list.size());
        int size = list.size();
        for (int i = 0; i < size; i++) {
            arrayList.add(save((AnnotatedString.Range) list.get(i), AnnotationRangeSaver, saverScope));
        }
        return arrayList;
    }
}
