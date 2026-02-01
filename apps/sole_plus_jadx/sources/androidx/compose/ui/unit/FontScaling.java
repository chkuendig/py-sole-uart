package androidx.compose.ui.unit;

import androidx.compose.ui.unit.fontscaling.FontScaleConverter;
import androidx.compose.ui.unit.fontscaling.FontScaleConverterFactory;
import kotlin.Metadata;

/* compiled from: FontScaling.android.kt */
@Metadata(d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bg\u0018\u00002\u00020\u0001J\u0013\u0010\b\u001a\u00020\t*\u00020\nH\u0017¢\u0006\u0004\b\u000b\u0010\fJ\u0013\u0010\r\u001a\u00020\n*\u00020\tH\u0017¢\u0006\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0002\u001a\u00020\u00038&X§\u0004¢\u0006\f\u0012\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007ø\u0001\u0000\u0082\u0002\u0006\n\u0004\b!0\u0001¨\u0006\u0010À\u0006\u0003"}, d2 = {"Landroidx/compose/ui/unit/FontScaling;", "", "fontScale", "", "getFontScale$annotations", "()V", "getFontScale", "()F", "toSp", "Landroidx/compose/ui/unit/TextUnit;", "Landroidx/compose/ui/unit/Dp;", "toSp-0xMU5do", "(F)J", "toDp", "toDp-GaN1DYA", "(J)F", "ui-unit"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public interface FontScaling {
    float getFontScale();

    /* compiled from: FontScaling.android.kt */
    @Metadata(k = 3, mv = {2, 0, 0}, xi = 48)
    public static final class DefaultImpls {
        public static /* synthetic */ void getFontScale$annotations() {
        }

        @Deprecated
        /* renamed from: toSp-0xMU5do, reason: not valid java name */
        public static long m7367toSp0xMU5do(FontScaling fontScaling, float f) {
            return FontScaling.super.mo679toSp0xMU5do(f);
        }

        @Deprecated
        /* renamed from: toDp-GaN1DYA, reason: not valid java name */
        public static float m7366toDpGaN1DYA(FontScaling fontScaling, long j) {
            return FontScaling.super.mo672toDpGaN1DYA(j);
        }
    }

    /* renamed from: toSp-0xMU5do */
    default long mo679toSp0xMU5do(float f) {
        if (!FontScaleConverterFactory.INSTANCE.isNonLinearFontScalingActive(getFontScale())) {
            return TextUnitKt.getSp(f / getFontScale());
        }
        FontScaleConverter fontScaleConverterForScale = FontScaleConverterFactory.INSTANCE.forScale(getFontScale());
        return TextUnitKt.getSp(fontScaleConverterForScale != null ? fontScaleConverterForScale.convertDpToSp(f) : f / getFontScale());
    }

    /* renamed from: toDp-GaN1DYA */
    default float mo672toDpGaN1DYA(long j) {
        if (!TextUnitType.m7477equalsimpl0(TextUnit.m7448getTypeUIouoOA(j), TextUnitType.INSTANCE.m7482getSpUIouoOA())) {
            InlineClassHelperKt.throwIllegalStateException("Only Sp can convert to Px");
        }
        if (!FontScaleConverterFactory.INSTANCE.isNonLinearFontScalingActive(getFontScale())) {
            return Dp.m7255constructorimpl(TextUnit.m7449getValueimpl(j) * getFontScale());
        }
        FontScaleConverter fontScaleConverterForScale = FontScaleConverterFactory.INSTANCE.forScale(getFontScale());
        float fM7449getValueimpl = TextUnit.m7449getValueimpl(j);
        return Dp.m7255constructorimpl(fontScaleConverterForScale == null ? fM7449getValueimpl * getFontScale() : fontScaleConverterForScale.convertSpToDp(fM7449getValueimpl));
    }
}
