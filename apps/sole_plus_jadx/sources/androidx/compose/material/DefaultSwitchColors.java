package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import com.android.SdkConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* compiled from: Switch.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0003\u0018\u00002\u00020\u0001BE\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bJ\u0013\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0096\u0002J\b\u0010\u0011\u001a\u00020\u0012H\u0016J#\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0017¢\u0006\u0002\u0010\u0017J#\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00030\u00142\u0006\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u0016\u001a\u00020\u000eH\u0017¢\u0006\u0002\u0010\u0017R\u0016\u0010\u0002\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0004\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0007\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\b\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\t\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\n\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0005\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\fR\u0016\u0010\u0006\u001a\u00020\u0003X\u0082\u0004ø\u0001\u0000ø\u0001\u0001¢\u0006\u0004\n\u0002\u0010\f\u0082\u0002\u000b\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006\u0019"}, d2 = {"Landroidx/compose/material/DefaultSwitchColors;", "Landroidx/compose/material/SwitchColors;", "checkedThumbColor", "Landroidx/compose/ui/graphics/Color;", "checkedTrackColor", "uncheckedThumbColor", "uncheckedTrackColor", "disabledCheckedThumbColor", "disabledCheckedTrackColor", "disabledUncheckedThumbColor", "disabledUncheckedTrackColor", "(JJJJJJJJLkotlin/jvm/internal/DefaultConstructorMarker;)V", "J", "equals", "", "other", "", "hashCode", "", "thumbColor", "Landroidx/compose/runtime/State;", "enabled", SdkConstants.ATTR_CHECKED, "(ZZLandroidx/compose/runtime/Composer;I)Landroidx/compose/runtime/State;", "trackColor", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class DefaultSwitchColors implements SwitchColors {
    private final long checkedThumbColor;
    private final long checkedTrackColor;
    private final long disabledCheckedThumbColor;
    private final long disabledCheckedTrackColor;
    private final long disabledUncheckedThumbColor;
    private final long disabledUncheckedTrackColor;
    private final long uncheckedThumbColor;
    private final long uncheckedTrackColor;

    public /* synthetic */ DefaultSwitchColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8, DefaultConstructorMarker defaultConstructorMarker) {
        this(j, j2, j3, j4, j5, j6, j7, j8);
    }

    private DefaultSwitchColors(long j, long j2, long j3, long j4, long j5, long j6, long j7, long j8) {
        this.checkedThumbColor = j;
        this.checkedTrackColor = j2;
        this.uncheckedThumbColor = j3;
        this.uncheckedTrackColor = j4;
        this.disabledCheckedThumbColor = j5;
        this.disabledCheckedTrackColor = j6;
        this.disabledUncheckedThumbColor = j7;
        this.disabledUncheckedTrackColor = j8;
    }

    @Override // androidx.compose.material.SwitchColors
    public State<Color> thumbColor(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(-66424183);
        ComposerKt.sourceInformation(composer, "C(thumbColor)P(1)368@15317L253:Switch.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-66424183, i, -1, "androidx.compose.material.DefaultSwitchColors.thumbColor (Switch.kt:367)");
        }
        if (z) {
            j = z2 ? this.checkedThumbColor : this.uncheckedThumbColor;
        } else {
            j = z2 ? this.disabledCheckedThumbColor : this.disabledUncheckedThumbColor;
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4528boximpl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    @Override // androidx.compose.material.SwitchColors
    public State<Color> trackColor(boolean z, boolean z2, Composer composer, int i) {
        long j;
        composer.startReplaceableGroup(-1176343362);
        ComposerKt.sourceInformation(composer, "C(trackColor)P(1)379@15689L253:Switch.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1176343362, i, -1, "androidx.compose.material.DefaultSwitchColors.trackColor (Switch.kt:378)");
        }
        if (z) {
            j = z2 ? this.checkedTrackColor : this.uncheckedTrackColor;
        } else {
            j = z2 ? this.disabledCheckedTrackColor : this.disabledUncheckedTrackColor;
        }
        State<Color> stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(Color.m4528boximpl(j), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return stateRememberUpdatedState;
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (other == null || getClass() != other.getClass()) {
            return false;
        }
        DefaultSwitchColors defaultSwitchColors = (DefaultSwitchColors) other;
        return Color.m4539equalsimpl0(this.checkedThumbColor, defaultSwitchColors.checkedThumbColor) && Color.m4539equalsimpl0(this.checkedTrackColor, defaultSwitchColors.checkedTrackColor) && Color.m4539equalsimpl0(this.uncheckedThumbColor, defaultSwitchColors.uncheckedThumbColor) && Color.m4539equalsimpl0(this.uncheckedTrackColor, defaultSwitchColors.uncheckedTrackColor) && Color.m4539equalsimpl0(this.disabledCheckedThumbColor, defaultSwitchColors.disabledCheckedThumbColor) && Color.m4539equalsimpl0(this.disabledCheckedTrackColor, defaultSwitchColors.disabledCheckedTrackColor) && Color.m4539equalsimpl0(this.disabledUncheckedThumbColor, defaultSwitchColors.disabledUncheckedThumbColor) && Color.m4539equalsimpl0(this.disabledUncheckedTrackColor, defaultSwitchColors.disabledUncheckedTrackColor);
    }

    public int hashCode() {
        return (((((((((((((Color.m4545hashCodeimpl(this.checkedThumbColor) * 31) + Color.m4545hashCodeimpl(this.checkedTrackColor)) * 31) + Color.m4545hashCodeimpl(this.uncheckedThumbColor)) * 31) + Color.m4545hashCodeimpl(this.uncheckedTrackColor)) * 31) + Color.m4545hashCodeimpl(this.disabledCheckedThumbColor)) * 31) + Color.m4545hashCodeimpl(this.disabledCheckedTrackColor)) * 31) + Color.m4545hashCodeimpl(this.disabledUncheckedThumbColor)) * 31) + Color.m4545hashCodeimpl(this.disabledUncheckedTrackColor);
    }
}
