package androidx.compose.ui.graphics;

import androidx.compose.ui.graphics.colorspace.ColorModel;
import androidx.compose.ui.graphics.colorspace.ColorSpace;
import androidx.compose.ui.graphics.colorspace.ColorSpaces;
import androidx.compose.ui.graphics.colorspace.DoubleFunction;
import androidx.compose.ui.graphics.colorspace.Rgb;
import androidx.compose.ui.util.MathHelpersKt;
import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.ULong;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: Color.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0013\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e\u001a9\u0010\u000f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\b2\b\b\u0002\u0010\u000b\u001a\u00020\b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0001¢\u0006\u0002\u0010\u000e\u001a\u0017\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a\u0015\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0010\u001a\u00020\u0013H\u0007¢\u0006\u0002\u0010\u0014\u001a5\u0010\u0005\u001a\u00020\u00062\b\b\u0001\u0010\u0007\u001a\u00020\u00112\b\b\u0001\u0010\t\u001a\u00020\u00112\b\b\u0001\u0010\n\u001a\u00020\u00112\b\b\u0003\u0010\u000b\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0015\u001a)\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\u00062\u0006\u0010\u0018\u001a\u00020\u00062\b\b\u0001\u0010\u0019\u001a\u00020\bH\u0007¢\u0006\u0004\b\u001a\u0010\u001b\u001a\u001b\u0010\u001c\u001a\u00020\u0006*\u00020\u00062\u0006\u0010\u001d\u001a\u00020\u0006H\u0007¢\u0006\u0004\b\u001e\u0010\u001f\u001a1\u0010 \u001a\u00020\b2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\b2\u0006\u0010$\u001a\u00020\b2\u0006\u0010%\u001a\u00020\bH\u0082\b\u001a\u0013\u0010&\u001a\u00020'*\u00020\u0006H\u0003¢\u0006\u0004\b(\u0010)\u001a\u0013\u0010*\u001a\u00020\b*\u00020\u0006H\u0007¢\u0006\u0004\b+\u0010,\u001a\u0013\u0010-\u001a\u00020\u0011*\u00020\u0006H\u0007¢\u0006\u0004\b.\u0010/\u001a\"\u00109\u001a\u00020\u0006*\u00020\u00062\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00060;H\u0086\b¢\u0006\u0004\b<\u0010=\"\u0018\u0010\u0000\u001a\u00020\u00018\u0000X\u0081T¢\u0006\n\n\u0002\u0010\u0004\u0012\u0004\b\u0002\u0010\u0003\"\u001f\u00100\u001a\u000201*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b2\u00103\u001a\u0004\b4\u00105\"\u001f\u00106\u001a\u000201*\u00020\u00068Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b7\u00103\u001a\u0004\b8\u00105¨\u0006>"}, d2 = {"UnspecifiedColor", "Lkotlin/ULong;", "getUnspecifiedColor$annotations", "()V", "J", "Color", "Landroidx/compose/ui/graphics/Color;", "red", "", "green", "blue", "alpha", "colorSpace", "Landroidx/compose/ui/graphics/colorspace/ColorSpace;", "(FFFFLandroidx/compose/ui/graphics/colorspace/ColorSpace;)J", "UncheckedColor", "color", "", "(I)J", "", "(J)J", "(IIII)J", "lerp", "start", "stop", "fraction", "lerp-jxsXWHM", "(JJF)J", "compositeOver", SdkConstants.ATTR_BACKGROUND, "compositeOver--OWjLjI", "(JJ)J", "compositeComponent", "fgC", "bgC", "fgA", "bgA", "a", "getComponents", "", "getComponents-8_81llA", "(J)[F", "luminance", "luminance-8_81llA", "(J)F", "toArgb", "toArgb-8_81llA", "(J)I", "isSpecified", "", "isSpecified-8_81llA$annotations", "(J)V", "isSpecified-8_81llA", "(J)Z", "isUnspecified", "isUnspecified-8_81llA$annotations", "isUnspecified-8_81llA", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-DxMtmZc", "(JLkotlin/jvm/functions/Function0;)J", "ui-graphics_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class ColorKt {
    public static final long UnspecifiedColor = 16;

    private static final float compositeComponent(float f, float f2, float f3, float f4, float f5) {
        if (f5 == 0.0f) {
            return 0.0f;
        }
        return ((f * f3) + ((f2 * f4) * (1.0f - f3))) / f5;
    }

    public static /* synthetic */ void getUnspecifiedColor$annotations() {
    }

    /* renamed from: isSpecified-8_81llA, reason: not valid java name */
    public static final boolean m4585isSpecified8_81llA(long j) {
        return j != 16;
    }

    /* renamed from: isSpecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m4586isSpecified8_81llA$annotations(long j) {
    }

    /* renamed from: isUnspecified-8_81llA, reason: not valid java name */
    public static final boolean m4587isUnspecified8_81llA(long j) {
        return j == 16;
    }

    /* renamed from: isUnspecified-8_81llA$annotations, reason: not valid java name */
    public static /* synthetic */ void m4588isUnspecified8_81llA$annotations(long j) {
    }

    public static /* synthetic */ long Color$default(float f, float f2, float f3, float f4, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f4 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return Color(f, f2, f3, f4, colorSpace);
    }

    /* JADX WARN: Removed duplicated region for block: B:110:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:114:0x0170  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x017d  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0185  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:144:0x01ca  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0108  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x010f  */
    /* JADX WARN: Removed duplicated region for block: B:87:0x011d  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x0125  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long Color(float r20, float r21, float r22, float r23, androidx.compose.ui.graphics.colorspace.ColorSpace r24) {
        /*
            Method dump skipped, instructions count: 504
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.ColorKt.Color(float, float, float, float, androidx.compose.ui.graphics.colorspace.ColorSpace):long");
    }

    public static /* synthetic */ long UncheckedColor$default(float f, float f2, float f3, float f4, ColorSpace colorSpace, int i, Object obj) {
        if ((i & 8) != 0) {
            f4 = 1.0f;
        }
        if ((i & 16) != 0) {
            colorSpace = ColorSpaces.INSTANCE.getSrgb();
        }
        return UncheckedColor(f, f2, f3, f4, colorSpace);
    }

    /* JADX WARN: Removed duplicated region for block: B:29:0x009b  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00a3  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00e5  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x00ee  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final long UncheckedColor(float r17, float r18, float r19, float r20, androidx.compose.ui.graphics.colorspace.ColorSpace r21) {
        /*
            Method dump skipped, instructions count: 348
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.graphics.ColorKt.UncheckedColor(float, float, float, float, androidx.compose.ui.graphics.colorspace.ColorSpace):long");
    }

    public static final long Color(int i) {
        return Color.m4534constructorimpl(ULong.m9261constructorimpl(ULong.m9261constructorimpl(i) << 32));
    }

    public static final long Color(long j) {
        return Color.m4534constructorimpl(ULong.m9261constructorimpl(j << 32));
    }

    public static /* synthetic */ long Color$default(int i, int i2, int i3, int i4, int i5, Object obj) {
        if ((i5 & 8) != 0) {
            i4 = 255;
        }
        return Color(i, i2, i3, i4);
    }

    public static final long Color(int i, int i2, int i3, int i4) {
        return Color(((i & 255) << 16) | ((i4 & 255) << 24) | ((i2 & 255) << 8) | (i3 & 255));
    }

    /* renamed from: lerp-jxsXWHM, reason: not valid java name */
    public static final long m4589lerpjxsXWHM(long j, long j2, float f) {
        ColorSpace oklab = ColorSpaces.INSTANCE.getOklab();
        long jM4535convertvNxB06k = Color.m4535convertvNxB06k(j, oklab);
        long jM4535convertvNxB06k2 = Color.m4535convertvNxB06k(j2, oklab);
        float fM4540getAlphaimpl = Color.m4540getAlphaimpl(jM4535convertvNxB06k);
        float fM4544getRedimpl = Color.m4544getRedimpl(jM4535convertvNxB06k);
        float fM4543getGreenimpl = Color.m4543getGreenimpl(jM4535convertvNxB06k);
        float fM4541getBlueimpl = Color.m4541getBlueimpl(jM4535convertvNxB06k);
        float fM4540getAlphaimpl2 = Color.m4540getAlphaimpl(jM4535convertvNxB06k2);
        float fM4544getRedimpl2 = Color.m4544getRedimpl(jM4535convertvNxB06k2);
        float fM4543getGreenimpl2 = Color.m4543getGreenimpl(jM4535convertvNxB06k2);
        float fM4541getBlueimpl2 = Color.m4541getBlueimpl(jM4535convertvNxB06k2);
        if (f < 0.0f) {
            f = 0.0f;
        }
        if (f > 1.0f) {
            f = 1.0f;
        }
        return Color.m4535convertvNxB06k(UncheckedColor(MathHelpersKt.lerp(fM4544getRedimpl, fM4544getRedimpl2, f), MathHelpersKt.lerp(fM4543getGreenimpl, fM4543getGreenimpl2, f), MathHelpersKt.lerp(fM4541getBlueimpl, fM4541getBlueimpl2, f), MathHelpersKt.lerp(fM4540getAlphaimpl, fM4540getAlphaimpl2, f), oklab), Color.m4542getColorSpaceimpl(j2));
    }

    /* renamed from: compositeOver--OWjLjI, reason: not valid java name */
    public static final long m4583compositeOverOWjLjI(long j, long j2) {
        long jM4535convertvNxB06k = Color.m4535convertvNxB06k(j, Color.m4542getColorSpaceimpl(j2));
        float fM4540getAlphaimpl = Color.m4540getAlphaimpl(j2);
        float fM4540getAlphaimpl2 = Color.m4540getAlphaimpl(jM4535convertvNxB06k);
        float f = 1.0f - fM4540getAlphaimpl2;
        float f2 = (fM4540getAlphaimpl * f) + fM4540getAlphaimpl2;
        return UncheckedColor(f2 == 0.0f ? 0.0f : ((Color.m4544getRedimpl(jM4535convertvNxB06k) * fM4540getAlphaimpl2) + ((Color.m4544getRedimpl(j2) * fM4540getAlphaimpl) * f)) / f2, f2 == 0.0f ? 0.0f : ((Color.m4543getGreenimpl(jM4535convertvNxB06k) * fM4540getAlphaimpl2) + ((Color.m4543getGreenimpl(j2) * fM4540getAlphaimpl) * f)) / f2, f2 != 0.0f ? ((Color.m4541getBlueimpl(jM4535convertvNxB06k) * fM4540getAlphaimpl2) + ((Color.m4541getBlueimpl(j2) * fM4540getAlphaimpl) * f)) / f2 : 0.0f, f2, Color.m4542getColorSpaceimpl(j2));
    }

    /* renamed from: getComponents-8_81llA, reason: not valid java name */
    private static final float[] m4584getComponents8_81llA(long j) {
        return new float[]{Color.m4544getRedimpl(j), Color.m4543getGreenimpl(j), Color.m4541getBlueimpl(j), Color.m4540getAlphaimpl(j)};
    }

    /* renamed from: luminance-8_81llA, reason: not valid java name */
    public static final float m4590luminance8_81llA(long j) {
        ColorSpace colorSpaceM4542getColorSpaceimpl = Color.m4542getColorSpaceimpl(j);
        if (!ColorModel.m4963equalsimpl0(colorSpaceM4542getColorSpaceimpl.getModel(), ColorModel.INSTANCE.m4970getRgbxdoWZVw())) {
            InlineClassHelperKt.throwIllegalArgumentException("The specified color must be encoded in an RGB color space. The supplied color space is " + ((Object) ColorModel.m4966toStringimpl(colorSpaceM4542getColorSpaceimpl.getModel())));
        }
        Intrinsics.checkNotNull(colorSpaceM4542getColorSpaceimpl, "null cannot be cast to non-null type androidx.compose.ui.graphics.colorspace.Rgb");
        DoubleFunction eotfFunc$ui_graphics_release = ((Rgb) colorSpaceM4542getColorSpaceimpl).getEotfFunc();
        float fInvoke = (float) ((eotfFunc$ui_graphics_release.invoke(Color.m4544getRedimpl(j)) * 0.2126d) + (eotfFunc$ui_graphics_release.invoke(Color.m4543getGreenimpl(j)) * 0.7152d) + (eotfFunc$ui_graphics_release.invoke(Color.m4541getBlueimpl(j)) * 0.0722d));
        if (fInvoke < 0.0f) {
            fInvoke = 0.0f;
        }
        if (fInvoke > 1.0f) {
            return 1.0f;
        }
        return fInvoke;
    }

    /* renamed from: toArgb-8_81llA, reason: not valid java name */
    public static final int m4592toArgb8_81llA(long j) {
        return (int) ULong.m9261constructorimpl(Color.m4535convertvNxB06k(j, ColorSpaces.INSTANCE.getSrgb()) >>> 32);
    }

    /* renamed from: takeOrElse-DxMtmZc, reason: not valid java name */
    public static final long m4591takeOrElseDxMtmZc(long j, Function0<Color> function0) {
        return j != 16 ? j : function0.invoke().m4548unboximpl();
    }
}
