package androidx.compose.ui.unit;

import androidx.compose.ui.util.MathHelpersKt;
import com.android.SdkConstants;
import com.samsung.android.sdk.healthdata.HealthConstants;
import io.ktor.http.ContentDisposition;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.ranges.RangesKt;

/* compiled from: Dp.kt */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u001f\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0018\u0002\n\u0002\b\n\u001a\"\u0010\n\u001a\u00020\u0002*\u00020\u00022\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00020\fH\u0086\b¢\u0006\u0004\b\r\u0010\u000e\u001a\u001c\u0010\u001a\u001a\u00020\u0002*\u00020\u00182\u0006\u0010\u001b\u001a\u00020\u0002H\u0087\n¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u001c\u0010\u001a\u001a\u00020\u0002*\u00020\u00152\u0006\u0010\u001b\u001a\u00020\u0002H\u0087\n¢\u0006\u0004\b\u001c\u0010\u001e\u001a\u001c\u0010\u001a\u001a\u00020\u0002*\u00020\u00102\u0006\u0010\u001b\u001a\u00020\u0002H\u0087\n¢\u0006\u0004\b\u001c\u0010\u001f\u001a \u0010 \u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b#\u0010\u001d\u001a \u0010$\u001a\u00020\u00022\u0006\u0010!\u001a\u00020\u00022\u0006\u0010\"\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b%\u0010\u001d\u001a$\u0010&\u001a\u00020\u0002*\u00020\u00022\u0006\u0010'\u001a\u00020\u00022\u0006\u0010(\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b)\u0010*\u001a\u001c\u0010+\u001a\u00020\u0002*\u00020\u00022\u0006\u0010'\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b,\u0010\u001d\u001a\u001c\u0010-\u001a\u00020\u0002*\u00020\u00022\u0006\u0010(\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b.\u0010\u001d\u001a'\u00102\u001a\u00020\u00022\u0006\u00103\u001a\u00020\u00022\u0006\u00104\u001a\u00020\u00022\u0006\u00105\u001a\u00020\u0018H\u0007¢\u0006\u0004\b6\u0010*\u001a \u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u00022\u0006\u0010:\u001a\u00020\u0002H\u0087\b¢\u0006\u0004\b;\u0010<\u001a\"\u0010\n\u001a\u000208*\u0002082\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002080\fH\u0086\b¢\u0006\u0004\bC\u0010D\u001a'\u00102\u001a\u0002082\u0006\u00103\u001a\u0002082\u0006\u00104\u001a\u0002082\u0006\u00105\u001a\u00020\u0018H\u0007¢\u0006\u0004\bE\u0010F\u001a\u001f\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020\u00022\u0006\u0010J\u001a\u00020\u0002H\u0007¢\u0006\u0004\bK\u0010<\u001a\"\u0010\n\u001a\u00020H*\u00020H2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020H0\fH\u0086\b¢\u0006\u0004\bP\u0010D\u001a\u001c\u0010\u001a\u001a\u00020H*\u00020\u00102\u0006\u0010U\u001a\u00020HH\u0087\n¢\u0006\u0004\bV\u0010W\u001a\u001c\u0010\u001a\u001a\u00020H*\u00020\u00182\u0006\u0010U\u001a\u00020HH\u0087\n¢\u0006\u0004\bV\u0010X\u001a'\u00102\u001a\u00020H2\u0006\u00103\u001a\u00020H2\u0006\u00104\u001a\u00020H2\u0006\u00105\u001a\u00020\u0018H\u0007¢\u0006\u0004\bY\u0010F\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006\"\u001f\u0010\u0007\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\b\u0010\u0004\u001a\u0004\b\t\u0010\u0006\"\u001f\u0010\u000f\u001a\u00020\u0002*\u00020\u00108Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014\"\u001f\u0010\u000f\u001a\u00020\u0002*\u00020\u00158Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0016\u001a\u0004\b\u0013\u0010\u0017\"\u001f\u0010\u000f\u001a\u00020\u0002*\u00020\u00188Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0004\u001a\u0004\b\u0013\u0010\u0019\"\u001f\u0010/\u001a\u00020\u0001*\u00020\u00028Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b0\u0010\u0004\u001a\u0004\b1\u0010\u0006\"\u001f\u0010\u0000\u001a\u00020\u0001*\u0002088Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b=\u0010>\u001a\u0004\b?\u0010@\"\u001f\u0010\u0007\u001a\u00020\u0001*\u0002088Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bA\u0010>\u001a\u0004\bB\u0010@\"\u001f\u0010\u0000\u001a\u00020\u0001*\u00020H8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bL\u0010>\u001a\u0004\bM\u0010@\"\u001f\u0010\u0007\u001a\u00020\u0001*\u00020H8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\bN\u0010>\u001a\u0004\bO\u0010@\"\u001e\u0010Q\u001a\u000208*\u00020H8FX\u0087\u0004¢\u0006\f\u0012\u0004\bR\u0010>\u001a\u0004\bS\u0010T\"\u001f\u0010I\u001a\u00020\u0002*\u00020Z8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b[\u0010\\\u001a\u0004\b]\u0010^\"\u001f\u0010J\u001a\u00020\u0002*\u00020Z8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\b_\u0010\\\u001a\u0004\b`\u0010^\"\u001f\u0010U\u001a\u00020H*\u00020Z8Æ\u0002X\u0087\u0004¢\u0006\f\u0012\u0004\ba\u0010\\\u001a\u0004\bb\u0010c¨\u0006d"}, d2 = {"isSpecified", "", "Landroidx/compose/ui/unit/Dp;", "isSpecified-0680j_4$annotations", "(F)V", "isSpecified-0680j_4", "(F)Z", "isUnspecified", "isUnspecified-0680j_4$annotations", "isUnspecified-0680j_4", "takeOrElse", "block", "Lkotlin/Function0;", "takeOrElse-D5KLDUw", "(FLkotlin/jvm/functions/Function0;)F", SdkConstants.UNIT_DP, "", "getDp$annotations", "(I)V", "getDp", "(I)F", "", "(D)V", "(D)F", "", "(F)F", "times", "other", "times-3ABfNKs", "(FF)F", "(DF)F", "(IF)F", HealthConstants.HeartRate.MIN, "a", "b", "min-YgX7TsA", "max", "max-YgX7TsA", "coerceIn", "minimumValue", "maximumValue", "coerceIn-2z7ARbQ", "(FFF)F", "coerceAtLeast", "coerceAtLeast-YgX7TsA", "coerceAtMost", "coerceAtMost-YgX7TsA", "isFinite", "isFinite-0680j_4$annotations", "isFinite-0680j_4", "lerp", "start", "stop", "fraction", "lerp-Md-fbLM", "DpOffset", "Landroidx/compose/ui/unit/DpOffset;", "x", "y", "DpOffset-YgX7TsA", "(FF)J", "isSpecified-jo-Fl9I$annotations", "(J)V", "isSpecified-jo-Fl9I", "(J)Z", "isUnspecified-jo-Fl9I$annotations", "isUnspecified-jo-Fl9I", "takeOrElse-gVKV90s", "(JLkotlin/jvm/functions/Function0;)J", "lerp-xhh869w", "(JJF)J", "DpSize", "Landroidx/compose/ui/unit/DpSize;", "width", "height", "DpSize-YgX7TsA", "isSpecified-EaSLcWc$annotations", "isSpecified-EaSLcWc", "isUnspecified-EaSLcWc$annotations", "isUnspecified-EaSLcWc", "takeOrElse-itqla9I", "center", "getCenter-EaSLcWc$annotations", "getCenter-EaSLcWc", "(J)J", ContentDisposition.Parameters.Size, "times-6HolHcs", "(IJ)J", "(FJ)J", "lerp-IDex15A", "Landroidx/compose/ui/unit/DpRect;", "getWidth$annotations", "(Landroidx/compose/ui/unit/DpRect;)V", "getWidth", "(Landroidx/compose/ui/unit/DpRect;)F", "getHeight$annotations", "getHeight", "getSize$annotations", "getSize", "(Landroidx/compose/ui/unit/DpRect;)J", "ui-unit"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class DpKt {
    /* renamed from: getCenter-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m7282getCenterEaSLcWc$annotations(long j) {
    }

    public static /* synthetic */ void getDp$annotations(double d) {
    }

    public static /* synthetic */ void getDp$annotations(float f) {
    }

    public static /* synthetic */ void getDp$annotations(int i) {
    }

    public static /* synthetic */ void getHeight$annotations(DpRect dpRect) {
    }

    public static /* synthetic */ void getSize$annotations(DpRect dpRect) {
    }

    public static /* synthetic */ void getWidth$annotations(DpRect dpRect) {
    }

    /* renamed from: isFinite-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m7284isFinite0680j_4$annotations(float f) {
    }

    /* renamed from: isSpecified-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m7286isSpecified0680j_4$annotations(float f) {
    }

    /* renamed from: isSpecified-EaSLcWc, reason: not valid java name */
    public static final boolean m7287isSpecifiedEaSLcWc(long j) {
        return j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    /* renamed from: isSpecified-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m7288isSpecifiedEaSLcWc$annotations(long j) {
    }

    /* renamed from: isSpecified-jo-Fl9I, reason: not valid java name */
    public static final boolean m7289isSpecifiedjoFl9I(long j) {
        return j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    /* renamed from: isSpecified-jo-Fl9I$annotations, reason: not valid java name */
    public static /* synthetic */ void m7290isSpecifiedjoFl9I$annotations(long j) {
    }

    /* renamed from: isUnspecified-0680j_4$annotations, reason: not valid java name */
    public static /* synthetic */ void m7292isUnspecified0680j_4$annotations(float f) {
    }

    /* renamed from: isUnspecified-EaSLcWc, reason: not valid java name */
    public static final boolean m7293isUnspecifiedEaSLcWc(long j) {
        return j == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    /* renamed from: isUnspecified-EaSLcWc$annotations, reason: not valid java name */
    public static /* synthetic */ void m7294isUnspecifiedEaSLcWc$annotations(long j) {
    }

    /* renamed from: isUnspecified-jo-Fl9I, reason: not valid java name */
    public static final boolean m7295isUnspecifiedjoFl9I(long j) {
        return j == androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats;
    }

    /* renamed from: isUnspecified-jo-Fl9I$annotations, reason: not valid java name */
    public static /* synthetic */ void m7296isUnspecifiedjoFl9I$annotations(long j) {
    }

    /* renamed from: isSpecified-0680j_4, reason: not valid java name */
    public static final boolean m7285isSpecified0680j_4(float f) {
        return !Float.isNaN(f);
    }

    /* renamed from: isUnspecified-0680j_4, reason: not valid java name */
    public static final boolean m7291isUnspecified0680j_4(float f) {
        return Float.isNaN(f);
    }

    public static final float getDp(int i) {
        return Dp.m7255constructorimpl(i);
    }

    public static final float getDp(double d) {
        return Dp.m7255constructorimpl((float) d);
    }

    public static final float getDp(float f) {
        return Dp.m7255constructorimpl(f);
    }

    /* renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m7306times3ABfNKs(float f, float f2) {
        return Dp.m7255constructorimpl(f * f2);
    }

    /* renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m7305times3ABfNKs(double d, float f) {
        return Dp.m7255constructorimpl(((float) d) * f);
    }

    /* renamed from: times-3ABfNKs, reason: not valid java name */
    public static final float m7307times3ABfNKs(int i, float f) {
        return Dp.m7255constructorimpl(i * f);
    }

    /* renamed from: min-YgX7TsA, reason: not valid java name */
    public static final float m7301minYgX7TsA(float f, float f2) {
        return Dp.m7255constructorimpl(Math.min(f, f2));
    }

    /* renamed from: max-YgX7TsA, reason: not valid java name */
    public static final float m7300maxYgX7TsA(float f, float f2) {
        return Dp.m7255constructorimpl(Math.max(f, f2));
    }

    /* renamed from: coerceIn-2z7ARbQ, reason: not valid java name */
    public static final float m7280coerceIn2z7ARbQ(float f, float f2, float f3) {
        return Dp.m7255constructorimpl(RangesKt.coerceIn(f, f2, f3));
    }

    /* renamed from: coerceAtLeast-YgX7TsA, reason: not valid java name */
    public static final float m7278coerceAtLeastYgX7TsA(float f, float f2) {
        return Dp.m7255constructorimpl(RangesKt.coerceAtLeast(f, f2));
    }

    /* renamed from: coerceAtMost-YgX7TsA, reason: not valid java name */
    public static final float m7279coerceAtMostYgX7TsA(float f, float f2) {
        return Dp.m7255constructorimpl(RangesKt.coerceAtMost(f, f2));
    }

    /* renamed from: lerp-Md-fbLM, reason: not valid java name */
    public static final float m7298lerpMdfbLM(float f, float f2, float f3) {
        return Dp.m7255constructorimpl(MathHelpersKt.lerp(f, f2, f3));
    }

    /* renamed from: takeOrElse-gVKV90s, reason: not valid java name */
    public static final long m7303takeOrElsegVKV90s(long j, Function0<DpOffset> function0) {
        return j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats ? j : function0.invoke().m7324unboximpl();
    }

    /* renamed from: lerp-xhh869w, reason: not valid java name */
    public static final long m7299lerpxhh869w(long j, long j2, float f) {
        float fLerp = MathHelpersKt.lerp(DpOffset.m7316getXD9Ej5fM(j), DpOffset.m7316getXD9Ej5fM(j2), f);
        float fLerp2 = MathHelpersKt.lerp(DpOffset.m7318getYD9Ej5fM(j), DpOffset.m7318getYD9Ej5fM(j2), f);
        return DpOffset.m7311constructorimpl((Float.floatToRawIntBits(fLerp) << 32) | (Float.floatToRawIntBits(fLerp2) & 4294967295L));
    }

    /* renamed from: takeOrElse-itqla9I, reason: not valid java name */
    public static final long m7304takeOrElseitqla9I(long j, Function0<DpSize> function0) {
        return j != androidx.compose.ui.geometry.InlineClassHelperKt.UnspecifiedPackedFloats ? j : function0.invoke().getPackedValue();
    }

    /* renamed from: getCenter-EaSLcWc, reason: not valid java name */
    public static final long m7281getCenterEaSLcWc(long j) {
        float fM7255constructorimpl = Dp.m7255constructorimpl(DpSize.m7353getWidthD9Ej5fM(j) / 2.0f);
        float fM7255constructorimpl2 = Dp.m7255constructorimpl(DpSize.m7351getHeightD9Ej5fM(j) / 2.0f);
        return DpOffset.m7311constructorimpl((Float.floatToRawIntBits(fM7255constructorimpl2) & 4294967295L) | (Float.floatToRawIntBits(fM7255constructorimpl) << 32));
    }

    /* renamed from: times-6HolHcs, reason: not valid java name */
    public static final long m7309times6HolHcs(int i, long j) {
        return DpSize.m7359timesGh9hcWk(j, i);
    }

    /* renamed from: times-6HolHcs, reason: not valid java name */
    public static final long m7308times6HolHcs(float f, long j) {
        return DpSize.m7358timesGh9hcWk(j, f);
    }

    /* renamed from: lerp-IDex15A, reason: not valid java name */
    public static final long m7297lerpIDex15A(long j, long j2, float f) {
        float fM7298lerpMdfbLM = m7298lerpMdfbLM(DpSize.m7353getWidthD9Ej5fM(j), DpSize.m7353getWidthD9Ej5fM(j2), f);
        float fM7298lerpMdfbLM2 = m7298lerpMdfbLM(DpSize.m7351getHeightD9Ej5fM(j), DpSize.m7351getHeightD9Ej5fM(j2), f);
        return DpSize.m7344constructorimpl((Float.floatToRawIntBits(fM7298lerpMdfbLM) << 32) | (Float.floatToRawIntBits(fM7298lerpMdfbLM2) & 4294967295L));
    }

    public static final float getWidth(DpRect dpRect) {
        return Dp.m7255constructorimpl(dpRect.m7339getRightD9Ej5fM() - dpRect.m7338getLeftD9Ej5fM());
    }

    public static final float getHeight(DpRect dpRect) {
        return Dp.m7255constructorimpl(dpRect.m7337getBottomD9Ej5fM() - dpRect.m7340getTopD9Ej5fM());
    }

    /* renamed from: takeOrElse-D5KLDUw, reason: not valid java name */
    public static final float m7302takeOrElseD5KLDUw(float f, Function0<Dp> function0) {
        return !Float.isNaN(f) ? f : function0.invoke().m7269unboximpl();
    }

    /* renamed from: isFinite-0680j_4, reason: not valid java name */
    public static final boolean m7283isFinite0680j_4(float f) {
        return (Float.floatToRawIntBits(f) & Integer.MAX_VALUE) < 2139095040;
    }

    /* renamed from: DpOffset-YgX7TsA, reason: not valid java name */
    public static final long m7276DpOffsetYgX7TsA(float f, float f2) {
        return DpOffset.m7311constructorimpl((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    /* renamed from: DpSize-YgX7TsA, reason: not valid java name */
    public static final long m7277DpSizeYgX7TsA(float f, float f2) {
        return DpSize.m7344constructorimpl((Float.floatToRawIntBits(f2) & 4294967295L) | (Float.floatToRawIntBits(f) << 32));
    }

    public static final long getSize(DpRect dpRect) {
        return m7277DpSizeYgX7TsA(Dp.m7255constructorimpl(dpRect.m7339getRightD9Ej5fM() - dpRect.m7338getLeftD9Ej5fM()), Dp.m7255constructorimpl(dpRect.m7337getBottomD9Ej5fM() - dpRect.m7340getTopD9Ej5fM()));
    }
}
