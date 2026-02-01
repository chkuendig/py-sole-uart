package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.ui.graphics.Color;
import kotlin.Metadata;

/* compiled from: RadioButton.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\u0006H\u0007ø\u0001\u0000¢\u0006\u0004\b\t\u0010\n\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000b"}, d2 = {"Landroidx/compose/material/RadioButtonDefaults;", "", "()V", "colors", "Landroidx/compose/material/RadioButtonColors;", "selectedColor", "Landroidx/compose/ui/graphics/Color;", "unselectedColor", "disabledColor", "colors-RGew2ao", "(JJJLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/RadioButtonColors;", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class RadioButtonDefaults {
    public static final int $stable = 0;
    public static final RadioButtonDefaults INSTANCE = new RadioButtonDefaults();

    private RadioButtonDefaults() {
    }

    /* renamed from: colors-RGew2ao, reason: not valid java name */
    public final RadioButtonColors m1942colorsRGew2ao(long j, long j2, long j3, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(1370708026);
        ComposerKt.sourceInformation(composer, "C(colors)P(1:c#ui.graphics.Color,2:c#ui.graphics.Color,0:c#ui.graphics.Color)163@6598L6,164@6663L6,165@6745L6,165@6788L8,167@6840L197:RadioButton.kt#jmzs0o");
        long jM1801getSecondary0d7_KjU = (i2 & 1) != 0 ? MaterialTheme.INSTANCE.getColors(composer, 6).m1801getSecondary0d7_KjU() : j;
        long jM4537copywmQWz5c$default = (i2 & 2) != 0 ? Color.m4537copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1798getOnSurface0d7_KjU(), 0.6f, 0.0f, 0.0f, 0.0f, 14, null) : j2;
        long jM4537copywmQWz5c$default2 = (i2 & 4) != 0 ? Color.m4537copywmQWz5c$default(MaterialTheme.INSTANCE.getColors(composer, 6).m1798getOnSurface0d7_KjU(), ContentAlpha.INSTANCE.getDisabled(composer, 6), 0.0f, 0.0f, 0.0f, 14, null) : j3;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1370708026, i, -1, "androidx.compose.material.RadioButtonDefaults.colors (RadioButton.kt:166)");
        }
        Color colorM4528boximpl = Color.m4528boximpl(jM1801getSecondary0d7_KjU);
        Color colorM4528boximpl2 = Color.m4528boximpl(jM4537copywmQWz5c$default);
        Color colorM4528boximpl3 = Color.m4528boximpl(jM4537copywmQWz5c$default2);
        composer.startReplaceableGroup(1618982084);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1,2,3):Composables.kt#9igjgp");
        boolean zChanged = composer.changed(colorM4528boximpl) | composer.changed(colorM4528boximpl2) | composer.changed(colorM4528boximpl3);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new DefaultRadioButtonColors(jM1801getSecondary0d7_KjU, jM4537copywmQWz5c$default, jM4537copywmQWz5c$default2, null);
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DefaultRadioButtonColors defaultRadioButtonColors = (DefaultRadioButtonColors) objRememberedValue;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return defaultRadioButtonColors;
    }
}
