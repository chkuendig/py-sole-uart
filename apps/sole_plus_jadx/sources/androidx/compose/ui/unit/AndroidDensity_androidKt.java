package androidx.compose.ui.unit;

import android.content.Context;
import androidx.compose.ui.unit.fontscaling.FontScaleConverterFactory;
import com.android.SdkConstants;
import kotlin.Metadata;

/* compiled from: AndroidDensity.android.kt */
@Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u000e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003¨\u0006\u0004"}, d2 = {"Density", "Landroidx/compose/ui/unit/Density;", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "ui-unit"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class AndroidDensity_androidKt {
    public static final Density Density(Context context) {
        float f = context.getResources().getConfiguration().fontScale;
        float f2 = context.getResources().getDisplayMetrics().density;
        LinearFontScaleConverter linearFontScaleConverterForScale = FontScaleConverterFactory.INSTANCE.forScale(f);
        if (linearFontScaleConverterForScale == null) {
            linearFontScaleConverterForScale = new LinearFontScaleConverter(f);
        }
        return new DensityWithConverter(f2, f, linearFontScaleConverterForScale);
    }
}
