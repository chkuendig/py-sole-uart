package androidx.compose.material;

import androidx.compose.runtime.State;
import androidx.compose.ui.graphics.Color;
import com.android.SdkConstants;
import kotlin.Metadata;

/* compiled from: TextFieldImpl.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\b\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J²\u0001\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\b2\u0017\u0010\n\u001a\u0013\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\b0\u000b¢\u0006\u0002\b\f2\u0006\u0010\r\u001a\u00020\u000e2e\u0010\u000f\u001aa\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\u0011¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u00040\u0010¢\u0006\u0002\b\fH\u0007ø\u0001\u0000¢\u0006\u0004\b\u0018\u0010\u0019\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u001a²\u0006\n\u0010\u0014\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0017\u001a\u00020\u0011X\u008a\u0084\u0002²\u0006\n\u0010\u0015\u001a\u00020\bX\u008a\u0084\u0002²\u0006\n\u0010\u0016\u001a\u00020\bX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material/TextFieldTransitionScope;", "", "()V", SdkConstants.MotionSceneTags.TRANSITION, "", "inputState", "Landroidx/compose/material/InputPhase;", "focusedTextStyleColor", "Landroidx/compose/ui/graphics/Color;", "unfocusedTextStyleColor", "contentColor", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "showLabel", "", "content", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "labelProgress", "labelTextStyleColor", "labelContentColor", "placeholderOpacity", "Transition-DTcfvLk", "(Landroidx/compose/material/InputPhase;JJLkotlin/jvm/functions/Function3;ZLkotlin/jvm/functions/Function6;Landroidx/compose/runtime/Composer;I)V", "material_release"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
final class TextFieldTransitionScope {
    public static final TextFieldTransitionScope INSTANCE = new TextFieldTransitionScope();

    /* compiled from: TextFieldImpl.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[InputPhase.values().length];
            try {
                iArr[InputPhase.Focused.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[InputPhase.UnfocusedEmpty.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[InputPhase.UnfocusedNotEmpty.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    private TextFieldTransitionScope() {
    }

    /* JADX WARN: Removed duplicated region for block: B:103:0x01ea  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x01f2  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x020e  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x021f  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x0231  */
    /* JADX WARN: Removed duplicated region for block: B:124:0x0239  */
    /* JADX WARN: Removed duplicated region for block: B:127:0x028a  */
    /* JADX WARN: Removed duplicated region for block: B:130:0x0299  */
    /* JADX WARN: Removed duplicated region for block: B:131:0x029c  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x02a4  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x02c3  */
    /* JADX WARN: Removed duplicated region for block: B:139:0x02cb  */
    /* JADX WARN: Removed duplicated region for block: B:142:0x02fc  */
    /* JADX WARN: Removed duplicated region for block: B:145:0x030b  */
    /* JADX WARN: Removed duplicated region for block: B:146:0x030e  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0316  */
    /* JADX WARN: Removed duplicated region for block: B:152:0x0332  */
    /* JADX WARN: Removed duplicated region for block: B:155:0x0341  */
    /* JADX WARN: Removed duplicated region for block: B:156:0x0344  */
    /* JADX WARN: Removed duplicated region for block: B:159:0x034c  */
    /* JADX WARN: Removed duplicated region for block: B:164:0x03c4  */
    /* JADX WARN: Removed duplicated region for block: B:167:0x0463  */
    /* JADX WARN: Removed duplicated region for block: B:70:0x0114  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0133  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x013b  */
    /* JADX WARN: Removed duplicated region for block: B:77:0x0149  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0158  */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0160  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x01c8  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x01d9  */
    /* renamed from: Transition-DTcfvLk, reason: not valid java name */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void m2036TransitionDTcfvLk(final androidx.compose.material.InputPhase r23, final long r24, final long r26, final kotlin.jvm.functions.Function3<? super androidx.compose.material.InputPhase, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, androidx.compose.ui.graphics.Color> r28, final boolean r29, final kotlin.jvm.functions.Function6<? super java.lang.Float, ? super androidx.compose.ui.graphics.Color, ? super androidx.compose.ui.graphics.Color, ? super java.lang.Float, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r30, androidx.compose.runtime.Composer r31, final int r32) {
        /*
            Method dump skipped, instructions count: 1160
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.material.TextFieldTransitionScope.m2036TransitionDTcfvLk(androidx.compose.material.InputPhase, long, long, kotlin.jvm.functions.Function3, boolean, kotlin.jvm.functions.Function6, androidx.compose.runtime.Composer, int):void");
    }

    private static final float Transition_DTcfvLk$lambda$1(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final float Transition_DTcfvLk$lambda$3(State<Float> state) {
        return state.getValue().floatValue();
    }

    private static final long Transition_DTcfvLk$lambda$5(State<Color> state) {
        return state.getValue().m4548unboximpl();
    }

    private static final long Transition_DTcfvLk$lambda$6(State<Color> state) {
        return state.getValue().m4548unboximpl();
    }
}
