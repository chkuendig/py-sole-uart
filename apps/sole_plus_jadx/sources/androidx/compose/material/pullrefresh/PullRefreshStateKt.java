package androidx.compose.material.pullrefresh;

import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionScopedCoroutineScopeCanceller;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: PullRefreshState.kt */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a<\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u0007ø\u0001\u0000¢\u0006\u0004\b\f\u0010\r\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u000e"}, d2 = {"DragMultiplier", "", "rememberPullRefreshState", "Landroidx/compose/material/pullrefresh/PullRefreshState;", "refreshing", "", "onRefresh", "Lkotlin/Function0;", "", "refreshThreshold", "Landroidx/compose/ui/unit/Dp;", "refreshingOffset", "rememberPullRefreshState-UuyPYSY", "(ZLkotlin/jvm/functions/Function0;FFLandroidx/compose/runtime/Composer;II)Landroidx/compose/material/pullrefresh/PullRefreshState;", "material_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class PullRefreshStateKt {
    private static final float DragMultiplier = 0.5f;

    /* renamed from: rememberPullRefreshState-UuyPYSY, reason: not valid java name */
    public static final PullRefreshState m2055rememberPullRefreshStateUuyPYSY(final boolean z, Function0<Unit> function0, float f, float f2, Composer composer, int i, int i2) {
        composer.startReplaceableGroup(-174977512);
        ComposerKt.sourceInformation(composer, "C(rememberPullRefreshState)P(2!1,1:c#ui.unit.Dp,3:c#ui.unit.Dp)64@2591L24,65@2641L31,*69@2757L7,74@2890L104,78@3000L152:PullRefreshState.kt#t44y28");
        if ((i2 & 4) != 0) {
            f = PullRefreshDefaults.INSTANCE.m2048getRefreshThresholdD9Ej5fM();
        }
        if ((i2 & 8) != 0) {
            f2 = PullRefreshDefaults.INSTANCE.m2049getRefreshingOffsetD9Ej5fM();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-174977512, i, -1, "androidx.compose.material.pullrefresh.rememberPullRefreshState (PullRefreshState.kt:61)");
        }
        if (Dp.m7254compareTo0680j_4(f, Dp.m7255constructorimpl(0)) <= 0) {
            throw new IllegalArgumentException("The refresh trigger must be greater than zero!".toString());
        }
        composer.startReplaceableGroup(773894976);
        ComposerKt.sourceInformation(composer, "CC(rememberCoroutineScope)489@20472L144:Effects.kt#9igjgp");
        composer.startReplaceableGroup(-492369756);
        ComposerKt.sourceInformation(composer, "CC(remember):Composables.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            Object compositionScopedCoroutineScopeCanceller = new CompositionScopedCoroutineScopeCanceller(EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer));
            composer.updateRememberedValue(compositionScopedCoroutineScopeCanceller);
            objRememberedValue = compositionScopedCoroutineScopeCanceller;
        }
        composer.endReplaceableGroup();
        CoroutineScope coroutineScope = ((CompositionScopedCoroutineScopeCanceller) objRememberedValue).getCoroutineScope();
        composer.endReplaceableGroup();
        State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function0, composer, (i >> 3) & 14);
        final Ref.FloatRef floatRef = new Ref.FloatRef();
        final Ref.FloatRef floatRef2 = new Ref.FloatRef();
        ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC:CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localDensity);
        ComposerKt.sourceInformationMarkerEnd(composer);
        Density density = (Density) objConsume;
        floatRef.element = density.mo677toPx0680j_4(f);
        floatRef2.element = density.mo677toPx0680j_4(f2);
        composer.startReplaceableGroup(1157296644);
        ComposerKt.sourceInformation(composer, "CC(remember)P(1):Composables.kt#9igjgp");
        boolean zChanged = composer.changed(coroutineScope);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new PullRefreshState(coroutineScope, stateRememberUpdatedState, floatRef2.element, floatRef.element);
            composer.updateRememberedValue(objRememberedValue2);
        }
        composer.endReplaceableGroup();
        final PullRefreshState pullRefreshState = (PullRefreshState) objRememberedValue2;
        EffectsKt.SideEffect(new Function0<Unit>() { // from class: androidx.compose.material.pullrefresh.PullRefreshStateKt$rememberPullRefreshState$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
                pullRefreshState.setRefreshing$material_release(z);
                pullRefreshState.setThreshold$material_release(floatRef.element);
                pullRefreshState.setRefreshingOffset$material_release(floatRef2.element);
            }
        }, composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceableGroup();
        return pullRefreshState;
    }
}
