package androidx.compose.material;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.unit.Dp;
import com.android.SdkConstants;
import com.facebook.internal.ServerProtocol;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;

/* compiled from: SwipeToDismiss.kt */
@Metadata(d1 = {"\u0000P\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\u001a\u0081\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0014\b\u0002\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u000e0\r2\u001c\u0010\u000f\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u00122\u001c\u0010\u0013\u001a\u0018\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\r¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0012H\u0007¢\u0006\u0002\u0010\u0014\u001a\u001a\u0010\u0015\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0017H\u0002\u001a-\u0010\u0019\u001a\u00020\u00062\b\b\u0002\u0010\u001a\u001a\u00020\u00172\u0014\b\u0002\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u001c0\rH\u0007¢\u0006\u0002\u0010\u001d\"\u0010\u0010\u0000\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0002¨\u0006\u001e"}, d2 = {"DISMISS_THRESHOLD", "Landroidx/compose/ui/unit/Dp;", "F", "SwipeToDismiss", "", ServerProtocol.DIALOG_PARAM_STATE, "Landroidx/compose/material/DismissState;", "modifier", "Landroidx/compose/ui/Modifier;", "directions", "", "Landroidx/compose/material/DismissDirection;", "dismissThresholds", "Lkotlin/Function1;", "Landroidx/compose/material/ThresholdConfig;", SdkConstants.ATTR_BACKGROUND, "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "dismissContent", "(Landroidx/compose/material/DismissState;Landroidx/compose/ui/Modifier;Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "getDismissDirection", "from", "Landroidx/compose/material/DismissValue;", "to", "rememberDismissState", "initialValue", "confirmStateChange", "", "(Landroidx/compose/material/DismissValue;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)Landroidx/compose/material/DismissState;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class SwipeToDismissKt {
    private static final float DISMISS_THRESHOLD = Dp.m7255constructorimpl(56);

    public static final DismissState rememberDismissState(final DismissValue dismissValue, final Function1<? super DismissValue, Boolean> function1, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-1753522702);
        ComposerKt.sourceInformation(composer, "C(rememberDismissState)P(1)153@5407L127:SwipeToDismiss.kt#jmzs0o");
        if ((i2 & 1) != 0) {
            dismissValue = DismissValue.Default;
        }
        if ((i2 & 2) != 0) {
            function1 = new Function1<DismissValue, Boolean>() { // from class: androidx.compose.material.SwipeToDismissKt.rememberDismissState.1
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(DismissValue dismissValue2) {
                    return true;
                }
            };
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1753522702, i, -1, "androidx.compose.material.rememberDismissState (SwipeToDismiss.kt:152)");
        }
        Object[] objArr = new Object[0];
        Saver<DismissState, DismissValue> Saver = DismissState.INSTANCE.Saver(function1);
        composer.startReplaceableGroup(-822335729);
        boolean zChanged = composer.changed(dismissValue) | composer.changedInstance(function1);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function0) new Function0<DismissState>() { // from class: androidx.compose.material.SwipeToDismissKt$rememberDismissState$2$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final DismissState invoke() {
                    return new DismissState(dismissValue, function1);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        composer.endReplaceableGroup();
        DismissState dismissState = (DismissState) RememberSaveableKt.m3983rememberSaveable(objArr, (Saver) Saver, (String) null, (Function0) objRememberedValue, composer, 72, 4);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return dismissState;
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0050  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0059  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x0072  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x0077  */
    /* JADX WARN: Removed duplicated region for block: B:50:0x008f  */
    /* JADX WARN: Removed duplicated region for block: B:51:0x0095  */
    /* JADX WARN: Removed duplicated region for block: B:59:0x00aa  */
    /* JADX WARN: Removed duplicated region for block: B:65:0x00c2  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c4  */
    /* JADX WARN: Removed duplicated region for block: B:67:0x00c9  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x00cd  */
    /* JADX WARN: Removed duplicated region for block: B:71:0x00dd  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x00e1  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x00f0  */
    /* JADX WARN: Removed duplicated region for block: B:80:0x0124  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0131  */
    /* JADX WARN: Removed duplicated region for block: B:86:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void SwipeToDismiss(final androidx.compose.material.DismissState r17, androidx.compose.ui.Modifier r18, java.util.Set<? extends androidx.compose.material.DismissDirection> r19, kotlin.jvm.functions.Function1<? super androidx.compose.material.DismissDirection, ? extends androidx.compose.material.ThresholdConfig> r20, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r21, final kotlin.jvm.functions.Function3<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
        /*
            Method dump skipped, instructions count: 328
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.SwipeToDismissKt.SwipeToDismiss(androidx.compose.material.DismissState, androidx.compose.ui.Modifier, java.util.Set, kotlin.jvm.functions.Function1, kotlin.jvm.functions.Function3, kotlin.jvm.functions.Function3, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DismissDirection getDismissDirection(DismissValue dismissValue, DismissValue dismissValue2) {
        if (dismissValue == dismissValue2 && dismissValue == DismissValue.Default) {
            return null;
        }
        if (dismissValue == dismissValue2 && dismissValue == DismissValue.DismissedToEnd) {
            return DismissDirection.StartToEnd;
        }
        if (dismissValue == dismissValue2 && dismissValue == DismissValue.DismissedToStart) {
            return DismissDirection.EndToStart;
        }
        if (dismissValue == DismissValue.Default && dismissValue2 == DismissValue.DismissedToEnd) {
            return DismissDirection.StartToEnd;
        }
        if (dismissValue == DismissValue.Default && dismissValue2 == DismissValue.DismissedToStart) {
            return DismissDirection.EndToStart;
        }
        if (dismissValue == DismissValue.DismissedToEnd && dismissValue2 == DismissValue.Default) {
            return DismissDirection.StartToEnd;
        }
        if (dismissValue == DismissValue.DismissedToStart && dismissValue2 == DismissValue.Default) {
            return DismissDirection.EndToStart;
        }
        return null;
    }
}
