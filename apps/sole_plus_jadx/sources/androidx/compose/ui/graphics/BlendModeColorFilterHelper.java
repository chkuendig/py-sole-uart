package androidx.compose.ui.graphics;

import com.android.SdkConstants;
import kotlin.Metadata;

/* compiled from: AndroidColorFilter.android.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\bÃ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u001d\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0005¨\u0006\u000f"}, d2 = {"Landroidx/compose/ui/graphics/BlendModeColorFilterHelper;", "", SdkConstants.CONSTRUCTOR_NAME, "()V", "BlendModeColorFilter", "Landroid/graphics/BlendModeColorFilter;", "color", "Landroidx/compose/ui/graphics/Color;", "blendMode", "Landroidx/compose/ui/graphics/BlendMode;", "BlendModeColorFilter-xETnrds", "(JI)Landroid/graphics/BlendModeColorFilter;", "createBlendModeColorFilter", "Landroidx/compose/ui/graphics/BlendModeColorFilter;", "androidBlendModeColorFilter", "ui-graphics_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
final class BlendModeColorFilterHelper {
    public static final BlendModeColorFilterHelper INSTANCE = new BlendModeColorFilterHelper();

    private BlendModeColorFilterHelper() {
    }

    /* renamed from: BlendModeColorFilter-xETnrds, reason: not valid java name */
    public final android.graphics.BlendModeColorFilter m4483BlendModeColorFilterxETnrds(long color, int blendMode) {
        return new android.graphics.BlendModeColorFilter(ColorKt.m4592toArgb8_81llA(color), AndroidBlendMode_androidKt.m4386toAndroidBlendModes9anfk8(blendMode));
    }

    public final BlendModeColorFilter createBlendModeColorFilter(android.graphics.BlendModeColorFilter androidBlendModeColorFilter) {
        return new BlendModeColorFilter(ColorKt.Color(androidBlendModeColorFilter.getColor()), AndroidBlendMode_androidKt.toComposeBlendMode(androidBlendModeColorFilter.getMode()), androidBlendModeColorFilter, null);
    }
}
