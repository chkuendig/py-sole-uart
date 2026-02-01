package androidx.compose.material;

import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.font.SystemFontFamily;
import androidx.compose.ui.unit.TextUnitKt;
import com.android.SdkConstants;
import com.facebook.share.internal.ShareConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Typography.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0093\u0001\b\u0016\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\r\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0005¢\u0006\u0002\u0010\u0012Bo\b\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\u0006\u0010\b\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\u0005\u0012\u0006\u0010\n\u001a\u00020\u0005\u0012\u0006\u0010\u000b\u001a\u00020\u0005\u0012\u0006\u0010\f\u001a\u00020\u0005\u0012\u0006\u0010\r\u001a\u00020\u0005\u0012\u0006\u0010\u000e\u001a\u00020\u0005\u0012\u0006\u0010\u000f\u001a\u00020\u0005\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0005¢\u0006\u0002\u0010\u0013J\u0088\u0001\u0010\"\u001a\u00020\u00002\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00052\b\b\u0002\u0010\u000e\u001a\u00020\u00052\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u0005J\u0013\u0010#\u001a\u00020$2\b\u0010%\u001a\u0004\u0018\u00010\u0001H\u0096\u0002J\b\u0010&\u001a\u00020'H\u0016J\b\u0010(\u001a\u00020)H\u0016R\u0011\u0010\r\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u000e\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0015R\u0011\u0010\u000f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0011\u0010\u0010\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0015R\u0011\u0010\u0007\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0015R\u0011\u0010\b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0015R\u0011\u0010\t\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0015R\u0011\u0010\n\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\u0011\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u0015R\u0011\u0010\u000b\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b \u0010\u0015R\u0011\u0010\f\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0015¨\u0006*"}, d2 = {"Landroidx/compose/material/Typography;", "", "defaultFontFamily", "Landroidx/compose/ui/text/font/FontFamily;", "h1", "Landroidx/compose/ui/text/TextStyle;", "h2", "h3", "h4", "h5", "h6", "subtitle1", "subtitle2", "body1", "body2", SdkConstants.ATTR_BUTTON, ShareConstants.FEED_CAPTION_PARAM, "overline", "(Landroidx/compose/ui/text/font/FontFamily;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;)V", "(Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;Landroidx/compose/ui/text/TextStyle;)V", "getBody1", "()Landroidx/compose/ui/text/TextStyle;", "getBody2", "getButton", "getCaption", "getH1", "getH2", "getH3", "getH4", "getH5", "getH6", "getOverline", "getSubtitle1", "getSubtitle2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class Typography {
    public static final int $stable = 0;
    private final TextStyle body1;
    private final TextStyle body2;
    private final TextStyle button;
    private final TextStyle caption;
    private final TextStyle h1;
    private final TextStyle h2;
    private final TextStyle h3;
    private final TextStyle h4;
    private final TextStyle h5;
    private final TextStyle h6;
    private final TextStyle overline;
    private final TextStyle subtitle1;
    private final TextStyle subtitle2;

    public Typography(TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13) {
        this.h1 = textStyle;
        this.h2 = textStyle2;
        this.h3 = textStyle3;
        this.h4 = textStyle4;
        this.h5 = textStyle5;
        this.h6 = textStyle6;
        this.subtitle1 = textStyle7;
        this.subtitle2 = textStyle8;
        this.body1 = textStyle9;
        this.body2 = textStyle10;
        this.button = textStyle11;
        this.caption = textStyle12;
        this.overline = textStyle13;
    }

    public final TextStyle getH1() {
        return this.h1;
    }

    public final TextStyle getH2() {
        return this.h2;
    }

    public final TextStyle getH3() {
        return this.h3;
    }

    public final TextStyle getH4() {
        return this.h4;
    }

    public final TextStyle getH5() {
        return this.h5;
    }

    public final TextStyle getH6() {
        return this.h6;
    }

    public final TextStyle getSubtitle1() {
        return this.subtitle1;
    }

    public final TextStyle getSubtitle2() {
        return this.subtitle2;
    }

    public final TextStyle getBody1() {
        return this.body1;
    }

    public final TextStyle getBody2() {
        return this.body2;
    }

    public final TextStyle getButton() {
        return this.button;
    }

    public final TextStyle getCaption() {
        return this.caption;
    }

    public final TextStyle getOverline() {
        return this.overline;
    }

    /* JADX WARN: Illegal instructions before constructor call */
    public /* synthetic */ Typography(FontFamily fontFamily, TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13, int i, DefaultConstructorMarker defaultConstructorMarker) {
        TextStyle textStyleM6743copyp1EtxEg;
        TextStyle textStyleM6743copyp1EtxEg2;
        TextStyle textStyleM6743copyp1EtxEg3;
        TextStyle textStyleM6743copyp1EtxEg4;
        TextStyle textStyleM6743copyp1EtxEg5;
        TextStyle textStyleM6743copyp1EtxEg6;
        TextStyle textStyleM6743copyp1EtxEg7;
        TextStyle textStyleM6743copyp1EtxEg8;
        TextStyle textStyleM6743copyp1EtxEg9;
        TextStyle textStyleM6743copyp1EtxEg10;
        TextStyle textStyleM6743copyp1EtxEg11;
        TextStyle textStyleM6743copyp1EtxEg12;
        TextStyle textStyleM6743copyp1EtxEg13;
        SystemFontFamily systemFontFamily = (i & 1) != 0 ? FontFamily.INSTANCE.getDefault() : fontFamily;
        if ((i & 2) != 0) {
            TextStyle defaultTextStyle = TypographyKt.getDefaultTextStyle();
            textStyleM6743copyp1EtxEg = defaultTextStyle.m6743copyp1EtxEg((15695871 & 1) != 0 ? defaultTextStyle.spanStyle.m6658getColor0d7_KjU() : 0L, (15695871 & 2) != 0 ? defaultTextStyle.spanStyle.getFontSize() : TextUnitKt.getSp(96), (15695871 & 4) != 0 ? defaultTextStyle.spanStyle.getFontWeight() : FontWeight.INSTANCE.getLight(), (15695871 & 8) != 0 ? defaultTextStyle.spanStyle.getFontStyle() : null, (15695871 & 16) != 0 ? defaultTextStyle.spanStyle.getFontSynthesis() : null, (15695871 & 32) != 0 ? defaultTextStyle.spanStyle.getFontFamily() : null, (15695871 & 64) != 0 ? defaultTextStyle.spanStyle.getFontFeatureSettings() : null, (15695871 & 128) != 0 ? defaultTextStyle.spanStyle.getLetterSpacing() : TextUnitKt.getSp(-1.5d), (15695871 & 256) != 0 ? defaultTextStyle.spanStyle.getBaselineShift() : null, (15695871 & 512) != 0 ? defaultTextStyle.spanStyle.getTextGeometricTransform() : null, (15695871 & 1024) != 0 ? defaultTextStyle.spanStyle.getLocaleList() : null, (15695871 & 2048) != 0 ? defaultTextStyle.spanStyle.getBackground() : 0L, (15695871 & 4096) != 0 ? defaultTextStyle.spanStyle.getTextDecoration() : null, (15695871 & 8192) != 0 ? defaultTextStyle.spanStyle.getShadow() : null, (15695871 & 16384) != 0 ? defaultTextStyle.spanStyle.getDrawStyle() : null, (15695871 & 32768) != 0 ? defaultTextStyle.paragraphStyle.getTextAlign() : 0, (15695871 & 65536) != 0 ? defaultTextStyle.paragraphStyle.getTextDirection() : 0, (15695871 & 131072) != 0 ? defaultTextStyle.paragraphStyle.getLineHeight() : TextUnitKt.getSp(112), (15695871 & 262144) != 0 ? defaultTextStyle.paragraphStyle.getTextIndent() : null, (15695871 & 524288) != 0 ? defaultTextStyle.platformStyle : null, (15695871 & 1048576) != 0 ? defaultTextStyle.paragraphStyle.getLineHeightStyle() : null, (15695871 & 2097152) != 0 ? defaultTextStyle.paragraphStyle.getLineBreak() : 0, (15695871 & 4194304) != 0 ? defaultTextStyle.paragraphStyle.getHyphens() : 0, (15695871 & 8388608) != 0 ? defaultTextStyle.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM6743copyp1EtxEg = textStyle;
        }
        if ((i & 4) != 0) {
            TextStyle defaultTextStyle2 = TypographyKt.getDefaultTextStyle();
            textStyleM6743copyp1EtxEg2 = defaultTextStyle2.m6743copyp1EtxEg((15695871 & 1) != 0 ? defaultTextStyle2.spanStyle.m6658getColor0d7_KjU() : 0L, (15695871 & 2) != 0 ? defaultTextStyle2.spanStyle.getFontSize() : TextUnitKt.getSp(60), (15695871 & 4) != 0 ? defaultTextStyle2.spanStyle.getFontWeight() : FontWeight.INSTANCE.getLight(), (15695871 & 8) != 0 ? defaultTextStyle2.spanStyle.getFontStyle() : null, (15695871 & 16) != 0 ? defaultTextStyle2.spanStyle.getFontSynthesis() : null, (15695871 & 32) != 0 ? defaultTextStyle2.spanStyle.getFontFamily() : null, (15695871 & 64) != 0 ? defaultTextStyle2.spanStyle.getFontFeatureSettings() : null, (15695871 & 128) != 0 ? defaultTextStyle2.spanStyle.getLetterSpacing() : TextUnitKt.getSp(-0.5d), (15695871 & 256) != 0 ? defaultTextStyle2.spanStyle.getBaselineShift() : null, (15695871 & 512) != 0 ? defaultTextStyle2.spanStyle.getTextGeometricTransform() : null, (15695871 & 1024) != 0 ? defaultTextStyle2.spanStyle.getLocaleList() : null, (15695871 & 2048) != 0 ? defaultTextStyle2.spanStyle.getBackground() : 0L, (15695871 & 4096) != 0 ? defaultTextStyle2.spanStyle.getTextDecoration() : null, (15695871 & 8192) != 0 ? defaultTextStyle2.spanStyle.getShadow() : null, (15695871 & 16384) != 0 ? defaultTextStyle2.spanStyle.getDrawStyle() : null, (15695871 & 32768) != 0 ? defaultTextStyle2.paragraphStyle.getTextAlign() : 0, (15695871 & 65536) != 0 ? defaultTextStyle2.paragraphStyle.getTextDirection() : 0, (15695871 & 131072) != 0 ? defaultTextStyle2.paragraphStyle.getLineHeight() : TextUnitKt.getSp(72), (15695871 & 262144) != 0 ? defaultTextStyle2.paragraphStyle.getTextIndent() : null, (15695871 & 524288) != 0 ? defaultTextStyle2.platformStyle : null, (15695871 & 1048576) != 0 ? defaultTextStyle2.paragraphStyle.getLineHeightStyle() : null, (15695871 & 2097152) != 0 ? defaultTextStyle2.paragraphStyle.getLineBreak() : 0, (15695871 & 4194304) != 0 ? defaultTextStyle2.paragraphStyle.getHyphens() : 0, (15695871 & 8388608) != 0 ? defaultTextStyle2.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM6743copyp1EtxEg2 = textStyle2;
        }
        if ((i & 8) != 0) {
            TextStyle defaultTextStyle3 = TypographyKt.getDefaultTextStyle();
            textStyleM6743copyp1EtxEg3 = defaultTextStyle3.m6743copyp1EtxEg((15695871 & 1) != 0 ? defaultTextStyle3.spanStyle.m6658getColor0d7_KjU() : 0L, (15695871 & 2) != 0 ? defaultTextStyle3.spanStyle.getFontSize() : TextUnitKt.getSp(48), (15695871 & 4) != 0 ? defaultTextStyle3.spanStyle.getFontWeight() : FontWeight.INSTANCE.getNormal(), (15695871 & 8) != 0 ? defaultTextStyle3.spanStyle.getFontStyle() : null, (15695871 & 16) != 0 ? defaultTextStyle3.spanStyle.getFontSynthesis() : null, (15695871 & 32) != 0 ? defaultTextStyle3.spanStyle.getFontFamily() : null, (15695871 & 64) != 0 ? defaultTextStyle3.spanStyle.getFontFeatureSettings() : null, (15695871 & 128) != 0 ? defaultTextStyle3.spanStyle.getLetterSpacing() : TextUnitKt.getSp(0), (15695871 & 256) != 0 ? defaultTextStyle3.spanStyle.getBaselineShift() : null, (15695871 & 512) != 0 ? defaultTextStyle3.spanStyle.getTextGeometricTransform() : null, (15695871 & 1024) != 0 ? defaultTextStyle3.spanStyle.getLocaleList() : null, (15695871 & 2048) != 0 ? defaultTextStyle3.spanStyle.getBackground() : 0L, (15695871 & 4096) != 0 ? defaultTextStyle3.spanStyle.getTextDecoration() : null, (15695871 & 8192) != 0 ? defaultTextStyle3.spanStyle.getShadow() : null, (15695871 & 16384) != 0 ? defaultTextStyle3.spanStyle.getDrawStyle() : null, (15695871 & 32768) != 0 ? defaultTextStyle3.paragraphStyle.getTextAlign() : 0, (15695871 & 65536) != 0 ? defaultTextStyle3.paragraphStyle.getTextDirection() : 0, (15695871 & 131072) != 0 ? defaultTextStyle3.paragraphStyle.getLineHeight() : TextUnitKt.getSp(56), (15695871 & 262144) != 0 ? defaultTextStyle3.paragraphStyle.getTextIndent() : null, (15695871 & 524288) != 0 ? defaultTextStyle3.platformStyle : null, (15695871 & 1048576) != 0 ? defaultTextStyle3.paragraphStyle.getLineHeightStyle() : null, (15695871 & 2097152) != 0 ? defaultTextStyle3.paragraphStyle.getLineBreak() : 0, (15695871 & 4194304) != 0 ? defaultTextStyle3.paragraphStyle.getHyphens() : 0, (15695871 & 8388608) != 0 ? defaultTextStyle3.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM6743copyp1EtxEg3 = textStyle3;
        }
        if ((i & 16) != 0) {
            TextStyle defaultTextStyle4 = TypographyKt.getDefaultTextStyle();
            textStyleM6743copyp1EtxEg4 = defaultTextStyle4.m6743copyp1EtxEg((15695871 & 1) != 0 ? defaultTextStyle4.spanStyle.m6658getColor0d7_KjU() : 0L, (15695871 & 2) != 0 ? defaultTextStyle4.spanStyle.getFontSize() : TextUnitKt.getSp(34), (15695871 & 4) != 0 ? defaultTextStyle4.spanStyle.getFontWeight() : FontWeight.INSTANCE.getNormal(), (15695871 & 8) != 0 ? defaultTextStyle4.spanStyle.getFontStyle() : null, (15695871 & 16) != 0 ? defaultTextStyle4.spanStyle.getFontSynthesis() : null, (15695871 & 32) != 0 ? defaultTextStyle4.spanStyle.getFontFamily() : null, (15695871 & 64) != 0 ? defaultTextStyle4.spanStyle.getFontFeatureSettings() : null, (15695871 & 128) != 0 ? defaultTextStyle4.spanStyle.getLetterSpacing() : TextUnitKt.getSp(0.25d), (15695871 & 256) != 0 ? defaultTextStyle4.spanStyle.getBaselineShift() : null, (15695871 & 512) != 0 ? defaultTextStyle4.spanStyle.getTextGeometricTransform() : null, (15695871 & 1024) != 0 ? defaultTextStyle4.spanStyle.getLocaleList() : null, (15695871 & 2048) != 0 ? defaultTextStyle4.spanStyle.getBackground() : 0L, (15695871 & 4096) != 0 ? defaultTextStyle4.spanStyle.getTextDecoration() : null, (15695871 & 8192) != 0 ? defaultTextStyle4.spanStyle.getShadow() : null, (15695871 & 16384) != 0 ? defaultTextStyle4.spanStyle.getDrawStyle() : null, (15695871 & 32768) != 0 ? defaultTextStyle4.paragraphStyle.getTextAlign() : 0, (15695871 & 65536) != 0 ? defaultTextStyle4.paragraphStyle.getTextDirection() : 0, (15695871 & 131072) != 0 ? defaultTextStyle4.paragraphStyle.getLineHeight() : TextUnitKt.getSp(36), (15695871 & 262144) != 0 ? defaultTextStyle4.paragraphStyle.getTextIndent() : null, (15695871 & 524288) != 0 ? defaultTextStyle4.platformStyle : null, (15695871 & 1048576) != 0 ? defaultTextStyle4.paragraphStyle.getLineHeightStyle() : null, (15695871 & 2097152) != 0 ? defaultTextStyle4.paragraphStyle.getLineBreak() : 0, (15695871 & 4194304) != 0 ? defaultTextStyle4.paragraphStyle.getHyphens() : 0, (15695871 & 8388608) != 0 ? defaultTextStyle4.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM6743copyp1EtxEg4 = textStyle4;
        }
        if ((i & 32) != 0) {
            TextStyle defaultTextStyle5 = TypographyKt.getDefaultTextStyle();
            textStyleM6743copyp1EtxEg5 = defaultTextStyle5.m6743copyp1EtxEg((15695871 & 1) != 0 ? defaultTextStyle5.spanStyle.m6658getColor0d7_KjU() : 0L, (15695871 & 2) != 0 ? defaultTextStyle5.spanStyle.getFontSize() : TextUnitKt.getSp(24), (15695871 & 4) != 0 ? defaultTextStyle5.spanStyle.getFontWeight() : FontWeight.INSTANCE.getNormal(), (15695871 & 8) != 0 ? defaultTextStyle5.spanStyle.getFontStyle() : null, (15695871 & 16) != 0 ? defaultTextStyle5.spanStyle.getFontSynthesis() : null, (15695871 & 32) != 0 ? defaultTextStyle5.spanStyle.getFontFamily() : null, (15695871 & 64) != 0 ? defaultTextStyle5.spanStyle.getFontFeatureSettings() : null, (15695871 & 128) != 0 ? defaultTextStyle5.spanStyle.getLetterSpacing() : TextUnitKt.getSp(0), (15695871 & 256) != 0 ? defaultTextStyle5.spanStyle.getBaselineShift() : null, (15695871 & 512) != 0 ? defaultTextStyle5.spanStyle.getTextGeometricTransform() : null, (15695871 & 1024) != 0 ? defaultTextStyle5.spanStyle.getLocaleList() : null, (15695871 & 2048) != 0 ? defaultTextStyle5.spanStyle.getBackground() : 0L, (15695871 & 4096) != 0 ? defaultTextStyle5.spanStyle.getTextDecoration() : null, (15695871 & 8192) != 0 ? defaultTextStyle5.spanStyle.getShadow() : null, (15695871 & 16384) != 0 ? defaultTextStyle5.spanStyle.getDrawStyle() : null, (15695871 & 32768) != 0 ? defaultTextStyle5.paragraphStyle.getTextAlign() : 0, (15695871 & 65536) != 0 ? defaultTextStyle5.paragraphStyle.getTextDirection() : 0, (15695871 & 131072) != 0 ? defaultTextStyle5.paragraphStyle.getLineHeight() : TextUnitKt.getSp(24), (15695871 & 262144) != 0 ? defaultTextStyle5.paragraphStyle.getTextIndent() : null, (15695871 & 524288) != 0 ? defaultTextStyle5.platformStyle : null, (15695871 & 1048576) != 0 ? defaultTextStyle5.paragraphStyle.getLineHeightStyle() : null, (15695871 & 2097152) != 0 ? defaultTextStyle5.paragraphStyle.getLineBreak() : 0, (15695871 & 4194304) != 0 ? defaultTextStyle5.paragraphStyle.getHyphens() : 0, (15695871 & 8388608) != 0 ? defaultTextStyle5.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM6743copyp1EtxEg5 = textStyle5;
        }
        if ((i & 64) != 0) {
            TextStyle defaultTextStyle6 = TypographyKt.getDefaultTextStyle();
            textStyleM6743copyp1EtxEg6 = defaultTextStyle6.m6743copyp1EtxEg((15695871 & 1) != 0 ? defaultTextStyle6.spanStyle.m6658getColor0d7_KjU() : 0L, (15695871 & 2) != 0 ? defaultTextStyle6.spanStyle.getFontSize() : TextUnitKt.getSp(20), (15695871 & 4) != 0 ? defaultTextStyle6.spanStyle.getFontWeight() : FontWeight.INSTANCE.getMedium(), (15695871 & 8) != 0 ? defaultTextStyle6.spanStyle.getFontStyle() : null, (15695871 & 16) != 0 ? defaultTextStyle6.spanStyle.getFontSynthesis() : null, (15695871 & 32) != 0 ? defaultTextStyle6.spanStyle.getFontFamily() : null, (15695871 & 64) != 0 ? defaultTextStyle6.spanStyle.getFontFeatureSettings() : null, (15695871 & 128) != 0 ? defaultTextStyle6.spanStyle.getLetterSpacing() : TextUnitKt.getSp(0.15d), (15695871 & 256) != 0 ? defaultTextStyle6.spanStyle.getBaselineShift() : null, (15695871 & 512) != 0 ? defaultTextStyle6.spanStyle.getTextGeometricTransform() : null, (15695871 & 1024) != 0 ? defaultTextStyle6.spanStyle.getLocaleList() : null, (15695871 & 2048) != 0 ? defaultTextStyle6.spanStyle.getBackground() : 0L, (15695871 & 4096) != 0 ? defaultTextStyle6.spanStyle.getTextDecoration() : null, (15695871 & 8192) != 0 ? defaultTextStyle6.spanStyle.getShadow() : null, (15695871 & 16384) != 0 ? defaultTextStyle6.spanStyle.getDrawStyle() : null, (15695871 & 32768) != 0 ? defaultTextStyle6.paragraphStyle.getTextAlign() : 0, (15695871 & 65536) != 0 ? defaultTextStyle6.paragraphStyle.getTextDirection() : 0, (15695871 & 131072) != 0 ? defaultTextStyle6.paragraphStyle.getLineHeight() : TextUnitKt.getSp(24), (15695871 & 262144) != 0 ? defaultTextStyle6.paragraphStyle.getTextIndent() : null, (15695871 & 524288) != 0 ? defaultTextStyle6.platformStyle : null, (15695871 & 1048576) != 0 ? defaultTextStyle6.paragraphStyle.getLineHeightStyle() : null, (15695871 & 2097152) != 0 ? defaultTextStyle6.paragraphStyle.getLineBreak() : 0, (15695871 & 4194304) != 0 ? defaultTextStyle6.paragraphStyle.getHyphens() : 0, (15695871 & 8388608) != 0 ? defaultTextStyle6.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM6743copyp1EtxEg6 = textStyle6;
        }
        if ((i & 128) != 0) {
            TextStyle defaultTextStyle7 = TypographyKt.getDefaultTextStyle();
            textStyleM6743copyp1EtxEg7 = defaultTextStyle7.m6743copyp1EtxEg((15695871 & 1) != 0 ? defaultTextStyle7.spanStyle.m6658getColor0d7_KjU() : 0L, (15695871 & 2) != 0 ? defaultTextStyle7.spanStyle.getFontSize() : TextUnitKt.getSp(16), (15695871 & 4) != 0 ? defaultTextStyle7.spanStyle.getFontWeight() : FontWeight.INSTANCE.getNormal(), (15695871 & 8) != 0 ? defaultTextStyle7.spanStyle.getFontStyle() : null, (15695871 & 16) != 0 ? defaultTextStyle7.spanStyle.getFontSynthesis() : null, (15695871 & 32) != 0 ? defaultTextStyle7.spanStyle.getFontFamily() : null, (15695871 & 64) != 0 ? defaultTextStyle7.spanStyle.getFontFeatureSettings() : null, (15695871 & 128) != 0 ? defaultTextStyle7.spanStyle.getLetterSpacing() : TextUnitKt.getSp(0.15d), (15695871 & 256) != 0 ? defaultTextStyle7.spanStyle.getBaselineShift() : null, (15695871 & 512) != 0 ? defaultTextStyle7.spanStyle.getTextGeometricTransform() : null, (15695871 & 1024) != 0 ? defaultTextStyle7.spanStyle.getLocaleList() : null, (15695871 & 2048) != 0 ? defaultTextStyle7.spanStyle.getBackground() : 0L, (15695871 & 4096) != 0 ? defaultTextStyle7.spanStyle.getTextDecoration() : null, (15695871 & 8192) != 0 ? defaultTextStyle7.spanStyle.getShadow() : null, (15695871 & 16384) != 0 ? defaultTextStyle7.spanStyle.getDrawStyle() : null, (15695871 & 32768) != 0 ? defaultTextStyle7.paragraphStyle.getTextAlign() : 0, (15695871 & 65536) != 0 ? defaultTextStyle7.paragraphStyle.getTextDirection() : 0, (15695871 & 131072) != 0 ? defaultTextStyle7.paragraphStyle.getLineHeight() : TextUnitKt.getSp(24), (15695871 & 262144) != 0 ? defaultTextStyle7.paragraphStyle.getTextIndent() : null, (15695871 & 524288) != 0 ? defaultTextStyle7.platformStyle : null, (15695871 & 1048576) != 0 ? defaultTextStyle7.paragraphStyle.getLineHeightStyle() : null, (15695871 & 2097152) != 0 ? defaultTextStyle7.paragraphStyle.getLineBreak() : 0, (15695871 & 4194304) != 0 ? defaultTextStyle7.paragraphStyle.getHyphens() : 0, (15695871 & 8388608) != 0 ? defaultTextStyle7.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM6743copyp1EtxEg7 = textStyle7;
        }
        if ((i & 256) != 0) {
            TextStyle defaultTextStyle8 = TypographyKt.getDefaultTextStyle();
            textStyleM6743copyp1EtxEg8 = defaultTextStyle8.m6743copyp1EtxEg((15695871 & 1) != 0 ? defaultTextStyle8.spanStyle.m6658getColor0d7_KjU() : 0L, (15695871 & 2) != 0 ? defaultTextStyle8.spanStyle.getFontSize() : TextUnitKt.getSp(14), (15695871 & 4) != 0 ? defaultTextStyle8.spanStyle.getFontWeight() : FontWeight.INSTANCE.getMedium(), (15695871 & 8) != 0 ? defaultTextStyle8.spanStyle.getFontStyle() : null, (15695871 & 16) != 0 ? defaultTextStyle8.spanStyle.getFontSynthesis() : null, (15695871 & 32) != 0 ? defaultTextStyle8.spanStyle.getFontFamily() : null, (15695871 & 64) != 0 ? defaultTextStyle8.spanStyle.getFontFeatureSettings() : null, (15695871 & 128) != 0 ? defaultTextStyle8.spanStyle.getLetterSpacing() : TextUnitKt.getSp(0.1d), (15695871 & 256) != 0 ? defaultTextStyle8.spanStyle.getBaselineShift() : null, (15695871 & 512) != 0 ? defaultTextStyle8.spanStyle.getTextGeometricTransform() : null, (15695871 & 1024) != 0 ? defaultTextStyle8.spanStyle.getLocaleList() : null, (15695871 & 2048) != 0 ? defaultTextStyle8.spanStyle.getBackground() : 0L, (15695871 & 4096) != 0 ? defaultTextStyle8.spanStyle.getTextDecoration() : null, (15695871 & 8192) != 0 ? defaultTextStyle8.spanStyle.getShadow() : null, (15695871 & 16384) != 0 ? defaultTextStyle8.spanStyle.getDrawStyle() : null, (15695871 & 32768) != 0 ? defaultTextStyle8.paragraphStyle.getTextAlign() : 0, (15695871 & 65536) != 0 ? defaultTextStyle8.paragraphStyle.getTextDirection() : 0, (15695871 & 131072) != 0 ? defaultTextStyle8.paragraphStyle.getLineHeight() : TextUnitKt.getSp(24), (15695871 & 262144) != 0 ? defaultTextStyle8.paragraphStyle.getTextIndent() : null, (15695871 & 524288) != 0 ? defaultTextStyle8.platformStyle : null, (15695871 & 1048576) != 0 ? defaultTextStyle8.paragraphStyle.getLineHeightStyle() : null, (15695871 & 2097152) != 0 ? defaultTextStyle8.paragraphStyle.getLineBreak() : 0, (15695871 & 4194304) != 0 ? defaultTextStyle8.paragraphStyle.getHyphens() : 0, (15695871 & 8388608) != 0 ? defaultTextStyle8.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM6743copyp1EtxEg8 = textStyle8;
        }
        if ((i & 512) != 0) {
            TextStyle defaultTextStyle9 = TypographyKt.getDefaultTextStyle();
            textStyleM6743copyp1EtxEg9 = defaultTextStyle9.m6743copyp1EtxEg((15695871 & 1) != 0 ? defaultTextStyle9.spanStyle.m6658getColor0d7_KjU() : 0L, (15695871 & 2) != 0 ? defaultTextStyle9.spanStyle.getFontSize() : TextUnitKt.getSp(16), (15695871 & 4) != 0 ? defaultTextStyle9.spanStyle.getFontWeight() : FontWeight.INSTANCE.getNormal(), (15695871 & 8) != 0 ? defaultTextStyle9.spanStyle.getFontStyle() : null, (15695871 & 16) != 0 ? defaultTextStyle9.spanStyle.getFontSynthesis() : null, (15695871 & 32) != 0 ? defaultTextStyle9.spanStyle.getFontFamily() : null, (15695871 & 64) != 0 ? defaultTextStyle9.spanStyle.getFontFeatureSettings() : null, (15695871 & 128) != 0 ? defaultTextStyle9.spanStyle.getLetterSpacing() : TextUnitKt.getSp(0.5d), (15695871 & 256) != 0 ? defaultTextStyle9.spanStyle.getBaselineShift() : null, (15695871 & 512) != 0 ? defaultTextStyle9.spanStyle.getTextGeometricTransform() : null, (15695871 & 1024) != 0 ? defaultTextStyle9.spanStyle.getLocaleList() : null, (15695871 & 2048) != 0 ? defaultTextStyle9.spanStyle.getBackground() : 0L, (15695871 & 4096) != 0 ? defaultTextStyle9.spanStyle.getTextDecoration() : null, (15695871 & 8192) != 0 ? defaultTextStyle9.spanStyle.getShadow() : null, (15695871 & 16384) != 0 ? defaultTextStyle9.spanStyle.getDrawStyle() : null, (15695871 & 32768) != 0 ? defaultTextStyle9.paragraphStyle.getTextAlign() : 0, (15695871 & 65536) != 0 ? defaultTextStyle9.paragraphStyle.getTextDirection() : 0, (15695871 & 131072) != 0 ? defaultTextStyle9.paragraphStyle.getLineHeight() : TextUnitKt.getSp(24), (15695871 & 262144) != 0 ? defaultTextStyle9.paragraphStyle.getTextIndent() : null, (15695871 & 524288) != 0 ? defaultTextStyle9.platformStyle : null, (15695871 & 1048576) != 0 ? defaultTextStyle9.paragraphStyle.getLineHeightStyle() : null, (15695871 & 2097152) != 0 ? defaultTextStyle9.paragraphStyle.getLineBreak() : 0, (15695871 & 4194304) != 0 ? defaultTextStyle9.paragraphStyle.getHyphens() : 0, (15695871 & 8388608) != 0 ? defaultTextStyle9.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM6743copyp1EtxEg9 = textStyle9;
        }
        if ((i & 1024) != 0) {
            TextStyle defaultTextStyle10 = TypographyKt.getDefaultTextStyle();
            textStyleM6743copyp1EtxEg10 = defaultTextStyle10.m6743copyp1EtxEg((15695871 & 1) != 0 ? defaultTextStyle10.spanStyle.m6658getColor0d7_KjU() : 0L, (15695871 & 2) != 0 ? defaultTextStyle10.spanStyle.getFontSize() : TextUnitKt.getSp(14), (15695871 & 4) != 0 ? defaultTextStyle10.spanStyle.getFontWeight() : FontWeight.INSTANCE.getNormal(), (15695871 & 8) != 0 ? defaultTextStyle10.spanStyle.getFontStyle() : null, (15695871 & 16) != 0 ? defaultTextStyle10.spanStyle.getFontSynthesis() : null, (15695871 & 32) != 0 ? defaultTextStyle10.spanStyle.getFontFamily() : null, (15695871 & 64) != 0 ? defaultTextStyle10.spanStyle.getFontFeatureSettings() : null, (15695871 & 128) != 0 ? defaultTextStyle10.spanStyle.getLetterSpacing() : TextUnitKt.getSp(0.25d), (15695871 & 256) != 0 ? defaultTextStyle10.spanStyle.getBaselineShift() : null, (15695871 & 512) != 0 ? defaultTextStyle10.spanStyle.getTextGeometricTransform() : null, (15695871 & 1024) != 0 ? defaultTextStyle10.spanStyle.getLocaleList() : null, (15695871 & 2048) != 0 ? defaultTextStyle10.spanStyle.getBackground() : 0L, (15695871 & 4096) != 0 ? defaultTextStyle10.spanStyle.getTextDecoration() : null, (15695871 & 8192) != 0 ? defaultTextStyle10.spanStyle.getShadow() : null, (15695871 & 16384) != 0 ? defaultTextStyle10.spanStyle.getDrawStyle() : null, (15695871 & 32768) != 0 ? defaultTextStyle10.paragraphStyle.getTextAlign() : 0, (15695871 & 65536) != 0 ? defaultTextStyle10.paragraphStyle.getTextDirection() : 0, (15695871 & 131072) != 0 ? defaultTextStyle10.paragraphStyle.getLineHeight() : TextUnitKt.getSp(20), (15695871 & 262144) != 0 ? defaultTextStyle10.paragraphStyle.getTextIndent() : null, (15695871 & 524288) != 0 ? defaultTextStyle10.platformStyle : null, (15695871 & 1048576) != 0 ? defaultTextStyle10.paragraphStyle.getLineHeightStyle() : null, (15695871 & 2097152) != 0 ? defaultTextStyle10.paragraphStyle.getLineBreak() : 0, (15695871 & 4194304) != 0 ? defaultTextStyle10.paragraphStyle.getHyphens() : 0, (15695871 & 8388608) != 0 ? defaultTextStyle10.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM6743copyp1EtxEg10 = textStyle10;
        }
        if ((i & 2048) != 0) {
            TextStyle defaultTextStyle11 = TypographyKt.getDefaultTextStyle();
            textStyleM6743copyp1EtxEg11 = defaultTextStyle11.m6743copyp1EtxEg((15695871 & 1) != 0 ? defaultTextStyle11.spanStyle.m6658getColor0d7_KjU() : 0L, (15695871 & 2) != 0 ? defaultTextStyle11.spanStyle.getFontSize() : TextUnitKt.getSp(14), (15695871 & 4) != 0 ? defaultTextStyle11.spanStyle.getFontWeight() : FontWeight.INSTANCE.getMedium(), (15695871 & 8) != 0 ? defaultTextStyle11.spanStyle.getFontStyle() : null, (15695871 & 16) != 0 ? defaultTextStyle11.spanStyle.getFontSynthesis() : null, (15695871 & 32) != 0 ? defaultTextStyle11.spanStyle.getFontFamily() : null, (15695871 & 64) != 0 ? defaultTextStyle11.spanStyle.getFontFeatureSettings() : null, (15695871 & 128) != 0 ? defaultTextStyle11.spanStyle.getLetterSpacing() : TextUnitKt.getSp(1.25d), (15695871 & 256) != 0 ? defaultTextStyle11.spanStyle.getBaselineShift() : null, (15695871 & 512) != 0 ? defaultTextStyle11.spanStyle.getTextGeometricTransform() : null, (15695871 & 1024) != 0 ? defaultTextStyle11.spanStyle.getLocaleList() : null, (15695871 & 2048) != 0 ? defaultTextStyle11.spanStyle.getBackground() : 0L, (15695871 & 4096) != 0 ? defaultTextStyle11.spanStyle.getTextDecoration() : null, (15695871 & 8192) != 0 ? defaultTextStyle11.spanStyle.getShadow() : null, (15695871 & 16384) != 0 ? defaultTextStyle11.spanStyle.getDrawStyle() : null, (15695871 & 32768) != 0 ? defaultTextStyle11.paragraphStyle.getTextAlign() : 0, (15695871 & 65536) != 0 ? defaultTextStyle11.paragraphStyle.getTextDirection() : 0, (15695871 & 131072) != 0 ? defaultTextStyle11.paragraphStyle.getLineHeight() : TextUnitKt.getSp(16), (15695871 & 262144) != 0 ? defaultTextStyle11.paragraphStyle.getTextIndent() : null, (15695871 & 524288) != 0 ? defaultTextStyle11.platformStyle : null, (15695871 & 1048576) != 0 ? defaultTextStyle11.paragraphStyle.getLineHeightStyle() : null, (15695871 & 2097152) != 0 ? defaultTextStyle11.paragraphStyle.getLineBreak() : 0, (15695871 & 4194304) != 0 ? defaultTextStyle11.paragraphStyle.getHyphens() : 0, (15695871 & 8388608) != 0 ? defaultTextStyle11.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM6743copyp1EtxEg11 = textStyle11;
        }
        if ((i & 4096) != 0) {
            TextStyle defaultTextStyle12 = TypographyKt.getDefaultTextStyle();
            textStyleM6743copyp1EtxEg12 = defaultTextStyle12.m6743copyp1EtxEg((15695871 & 1) != 0 ? defaultTextStyle12.spanStyle.m6658getColor0d7_KjU() : 0L, (15695871 & 2) != 0 ? defaultTextStyle12.spanStyle.getFontSize() : TextUnitKt.getSp(12), (15695871 & 4) != 0 ? defaultTextStyle12.spanStyle.getFontWeight() : FontWeight.INSTANCE.getNormal(), (15695871 & 8) != 0 ? defaultTextStyle12.spanStyle.getFontStyle() : null, (15695871 & 16) != 0 ? defaultTextStyle12.spanStyle.getFontSynthesis() : null, (15695871 & 32) != 0 ? defaultTextStyle12.spanStyle.getFontFamily() : null, (15695871 & 64) != 0 ? defaultTextStyle12.spanStyle.getFontFeatureSettings() : null, (15695871 & 128) != 0 ? defaultTextStyle12.spanStyle.getLetterSpacing() : TextUnitKt.getSp(0.4d), (15695871 & 256) != 0 ? defaultTextStyle12.spanStyle.getBaselineShift() : null, (15695871 & 512) != 0 ? defaultTextStyle12.spanStyle.getTextGeometricTransform() : null, (15695871 & 1024) != 0 ? defaultTextStyle12.spanStyle.getLocaleList() : null, (15695871 & 2048) != 0 ? defaultTextStyle12.spanStyle.getBackground() : 0L, (15695871 & 4096) != 0 ? defaultTextStyle12.spanStyle.getTextDecoration() : null, (15695871 & 8192) != 0 ? defaultTextStyle12.spanStyle.getShadow() : null, (15695871 & 16384) != 0 ? defaultTextStyle12.spanStyle.getDrawStyle() : null, (15695871 & 32768) != 0 ? defaultTextStyle12.paragraphStyle.getTextAlign() : 0, (15695871 & 65536) != 0 ? defaultTextStyle12.paragraphStyle.getTextDirection() : 0, (15695871 & 131072) != 0 ? defaultTextStyle12.paragraphStyle.getLineHeight() : TextUnitKt.getSp(16), (15695871 & 262144) != 0 ? defaultTextStyle12.paragraphStyle.getTextIndent() : null, (15695871 & 524288) != 0 ? defaultTextStyle12.platformStyle : null, (15695871 & 1048576) != 0 ? defaultTextStyle12.paragraphStyle.getLineHeightStyle() : null, (15695871 & 2097152) != 0 ? defaultTextStyle12.paragraphStyle.getLineBreak() : 0, (15695871 & 4194304) != 0 ? defaultTextStyle12.paragraphStyle.getHyphens() : 0, (15695871 & 8388608) != 0 ? defaultTextStyle12.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM6743copyp1EtxEg12 = textStyle12;
        }
        if ((i & 8192) != 0) {
            TextStyle defaultTextStyle13 = TypographyKt.getDefaultTextStyle();
            textStyleM6743copyp1EtxEg13 = defaultTextStyle13.m6743copyp1EtxEg((15695871 & 1) != 0 ? defaultTextStyle13.spanStyle.m6658getColor0d7_KjU() : 0L, (15695871 & 2) != 0 ? defaultTextStyle13.spanStyle.getFontSize() : TextUnitKt.getSp(10), (15695871 & 4) != 0 ? defaultTextStyle13.spanStyle.getFontWeight() : FontWeight.INSTANCE.getNormal(), (15695871 & 8) != 0 ? defaultTextStyle13.spanStyle.getFontStyle() : null, (15695871 & 16) != 0 ? defaultTextStyle13.spanStyle.getFontSynthesis() : null, (15695871 & 32) != 0 ? defaultTextStyle13.spanStyle.getFontFamily() : null, (15695871 & 64) != 0 ? defaultTextStyle13.spanStyle.getFontFeatureSettings() : null, (15695871 & 128) != 0 ? defaultTextStyle13.spanStyle.getLetterSpacing() : TextUnitKt.getSp(1.5d), (15695871 & 256) != 0 ? defaultTextStyle13.spanStyle.getBaselineShift() : null, (15695871 & 512) != 0 ? defaultTextStyle13.spanStyle.getTextGeometricTransform() : null, (15695871 & 1024) != 0 ? defaultTextStyle13.spanStyle.getLocaleList() : null, (15695871 & 2048) != 0 ? defaultTextStyle13.spanStyle.getBackground() : 0L, (15695871 & 4096) != 0 ? defaultTextStyle13.spanStyle.getTextDecoration() : null, (15695871 & 8192) != 0 ? defaultTextStyle13.spanStyle.getShadow() : null, (15695871 & 16384) != 0 ? defaultTextStyle13.spanStyle.getDrawStyle() : null, (15695871 & 32768) != 0 ? defaultTextStyle13.paragraphStyle.getTextAlign() : 0, (15695871 & 65536) != 0 ? defaultTextStyle13.paragraphStyle.getTextDirection() : 0, (15695871 & 131072) != 0 ? defaultTextStyle13.paragraphStyle.getLineHeight() : TextUnitKt.getSp(16), (15695871 & 262144) != 0 ? defaultTextStyle13.paragraphStyle.getTextIndent() : null, (15695871 & 524288) != 0 ? defaultTextStyle13.platformStyle : null, (15695871 & 1048576) != 0 ? defaultTextStyle13.paragraphStyle.getLineHeightStyle() : null, (15695871 & 2097152) != 0 ? defaultTextStyle13.paragraphStyle.getLineBreak() : 0, (15695871 & 4194304) != 0 ? defaultTextStyle13.paragraphStyle.getHyphens() : 0, (15695871 & 8388608) != 0 ? defaultTextStyle13.paragraphStyle.getTextMotion() : null);
        } else {
            textStyleM6743copyp1EtxEg13 = textStyle13;
        }
        this(systemFontFamily, textStyleM6743copyp1EtxEg, textStyleM6743copyp1EtxEg2, textStyleM6743copyp1EtxEg3, textStyleM6743copyp1EtxEg4, textStyleM6743copyp1EtxEg5, textStyleM6743copyp1EtxEg6, textStyleM6743copyp1EtxEg7, textStyleM6743copyp1EtxEg8, textStyleM6743copyp1EtxEg9, textStyleM6743copyp1EtxEg10, textStyleM6743copyp1EtxEg11, textStyleM6743copyp1EtxEg12, textStyleM6743copyp1EtxEg13);
    }

    public Typography(FontFamily fontFamily, TextStyle textStyle, TextStyle textStyle2, TextStyle textStyle3, TextStyle textStyle4, TextStyle textStyle5, TextStyle textStyle6, TextStyle textStyle7, TextStyle textStyle8, TextStyle textStyle9, TextStyle textStyle10, TextStyle textStyle11, TextStyle textStyle12, TextStyle textStyle13) {
        this(TypographyKt.withDefaultFontFamily(textStyle, fontFamily), TypographyKt.withDefaultFontFamily(textStyle2, fontFamily), TypographyKt.withDefaultFontFamily(textStyle3, fontFamily), TypographyKt.withDefaultFontFamily(textStyle4, fontFamily), TypographyKt.withDefaultFontFamily(textStyle5, fontFamily), TypographyKt.withDefaultFontFamily(textStyle6, fontFamily), TypographyKt.withDefaultFontFamily(textStyle7, fontFamily), TypographyKt.withDefaultFontFamily(textStyle8, fontFamily), TypographyKt.withDefaultFontFamily(textStyle9, fontFamily), TypographyKt.withDefaultFontFamily(textStyle10, fontFamily), TypographyKt.withDefaultFontFamily(textStyle11, fontFamily), TypographyKt.withDefaultFontFamily(textStyle12, fontFamily), TypographyKt.withDefaultFontFamily(textStyle13, fontFamily));
    }

    public final Typography copy(TextStyle h1, TextStyle h2, TextStyle h3, TextStyle h4, TextStyle h5, TextStyle h6, TextStyle subtitle1, TextStyle subtitle2, TextStyle body1, TextStyle body2, TextStyle button, TextStyle caption, TextStyle overline) {
        return new Typography(h1, h2, h3, h4, h5, h6, subtitle1, subtitle2, body1, body2, button, caption, overline);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Typography)) {
            return false;
        }
        Typography typography = (Typography) other;
        return Intrinsics.areEqual(this.h1, typography.h1) && Intrinsics.areEqual(this.h2, typography.h2) && Intrinsics.areEqual(this.h3, typography.h3) && Intrinsics.areEqual(this.h4, typography.h4) && Intrinsics.areEqual(this.h5, typography.h5) && Intrinsics.areEqual(this.h6, typography.h6) && Intrinsics.areEqual(this.subtitle1, typography.subtitle1) && Intrinsics.areEqual(this.subtitle2, typography.subtitle2) && Intrinsics.areEqual(this.body1, typography.body1) && Intrinsics.areEqual(this.body2, typography.body2) && Intrinsics.areEqual(this.button, typography.button) && Intrinsics.areEqual(this.caption, typography.caption) && Intrinsics.areEqual(this.overline, typography.overline);
    }

    public int hashCode() {
        return (((((((((((((((((((((((this.h1.hashCode() * 31) + this.h2.hashCode()) * 31) + this.h3.hashCode()) * 31) + this.h4.hashCode()) * 31) + this.h5.hashCode()) * 31) + this.h6.hashCode()) * 31) + this.subtitle1.hashCode()) * 31) + this.subtitle2.hashCode()) * 31) + this.body1.hashCode()) * 31) + this.body2.hashCode()) * 31) + this.button.hashCode()) * 31) + this.caption.hashCode()) * 31) + this.overline.hashCode();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("Typography(h1=");
        sb.append(this.h1).append(", h2=").append(this.h2).append(", h3=").append(this.h3).append(", h4=").append(this.h4).append(", h5=").append(this.h5).append(", h6=").append(this.h6).append(", subtitle1=").append(this.subtitle1).append(", subtitle2=").append(this.subtitle2).append(", body1=").append(this.body1).append(", body2=").append(this.body2).append(", button=").append(this.button).append(", caption=");
        sb.append(this.caption).append(", overline=").append(this.overline).append(')');
        return sb.toString();
    }
}
