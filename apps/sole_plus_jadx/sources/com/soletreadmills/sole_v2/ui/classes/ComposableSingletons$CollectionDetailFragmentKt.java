package com.soletreadmills.sole_v2.ui.classes;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.soletreadmills.sole_v2.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CollectionDetailFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposableSingletons$CollectionDetailFragmentKt {
    public static final ComposableSingletons$CollectionDetailFragmentKt INSTANCE = new ComposableSingletons$CollectionDetailFragmentKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<RowScope, Composer, Integer, Unit> f76lambda1 = ComposableLambdaKt.composableLambdaInstance(-1875255970, false, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ComposableSingletons$CollectionDetailFragmentKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer, Integer num) {
            invoke(rowScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(RowScope Button, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(Button, "$this$Button");
            if ((i & 81) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1875255970, i, -1, "com.soletreadmills.sole_v2.ui.classes.ComposableSingletons$CollectionDetailFragmentKt.lambda-1.<anonymous> (CollectionDetailFragment.kt:446)");
                }
                IconKt.m1888Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_m__play_fill, composer, 0), (String) null, SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(24)), Color.INSTANCE.m4575getWhite0d7_KjU(), composer, 3512, 0);
                TextKt.m2038Text4IGK_g("Start", PaddingKt.m989paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m7255constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null), Color.INSTANCE.m4575getWhite0d7_KjU(), TextUnitKt.getSp(17), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer, 200118, 0, 131024);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: getLambda-1$app_release, reason: not valid java name */
    public final Function3<RowScope, Composer, Integer, Unit> m8657getLambda1$app_release() {
        return f76lambda1;
    }
}
