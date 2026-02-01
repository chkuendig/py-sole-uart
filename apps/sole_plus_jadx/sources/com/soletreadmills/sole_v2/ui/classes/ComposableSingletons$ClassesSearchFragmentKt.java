package com.soletreadmills.sole_v2.ui.classes;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.material.IconKt;
import androidx.compose.material.ProgressIndicatorKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.ColorResources_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.soletreadmills.sole_v2.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClassesSearchFragment.kt */
@Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ComposableSingletons$ClassesSearchFragmentKt {
    public static final ComposableSingletons$ClassesSearchFragmentKt INSTANCE = new ComposableSingletons$ClassesSearchFragmentKt();

    /* renamed from: lambda-1, reason: not valid java name */
    public static Function3<LazyItemScope, Composer, Integer, Unit> f74lambda1 = ComposableLambdaKt.composableLambdaInstance(1218231037, false, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ComposableSingletons$ClassesSearchFragmentKt$lambda-1$1
        @Override // kotlin.jvm.functions.Function3
        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer, Integer num) {
            invoke(lazyItemScope, composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(LazyItemScope item, Composer composer, int i) {
            Intrinsics.checkNotNullParameter(item, "$this$item");
            if ((i & 81) != 16 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1218231037, i, -1, "com.soletreadmills.sole_v2.ui.classes.ComposableSingletons$ClassesSearchFragmentKt.lambda-1.<anonymous> (ClassesSearchFragment.kt:229)");
                }
                Modifier modifierM985padding3ABfNKs = PaddingKt.m985padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m7255constructorimpl(16));
                Alignment center = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM985padding3ABfNKs);
                Function0<ComposeUiNode> constructor = ComposeUiNode.Companion.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor);
                } else {
                    composer.useNode();
                }
                Composer composerM3857constructorimpl = Updater.m3857constructorimpl(composer);
                Updater.m3864setimpl(composerM3857constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.Companion.getSetMeasurePolicy());
                Updater.m3864setimpl(composerM3857constructorimpl, currentCompositionLocalMap, ComposeUiNode.Companion.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.Companion.getSetCompositeKeyHash();
                if (composerM3857constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                    composerM3857constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                    composerM3857constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                }
                Updater.m3864setimpl(composerM3857constructorimpl, modifierMaterializeModifier, ComposeUiNode.Companion.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ProgressIndicatorKt.m1923CircularProgressIndicatorLxG7B9w(SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(24)), ColorResources_androidKt.colorResource(R.color.colorLabel_accent, composer, 0), 0.0f, 0L, 0, composer, 6, 28);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                    return;
                }
                return;
            }
            composer.skipToGroupEnd();
        }
    });

    /* renamed from: lambda-2, reason: not valid java name */
    public static Function2<Composer, Integer, Unit> f75lambda2 = ComposableLambdaKt.composableLambdaInstance(-472173583, false, new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ComposableSingletons$ClassesSearchFragmentKt$lambda-2$1
        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
            invoke(composer, num.intValue());
            return Unit.INSTANCE;
        }

        public final void invoke(Composer composer, int i) {
            if ((i & 11) != 2 || !composer.getSkipping()) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-472173583, i, -1, "com.soletreadmills.sole_v2.ui.classes.ComposableSingletons$ClassesSearchFragmentKt.lambda-2.<anonymous> (ClassesSearchFragment.kt:410)");
                }
                IconKt.m1888Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.clear, composer, 0), "Clear", SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(24)), ColorResources_androidKt.colorResource(R.color.colorLabel_label3, composer, 0), composer, 440, 0);
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
    public final Function3<LazyItemScope, Composer, Integer, Unit> m8655getLambda1$app_release() {
        return f74lambda1;
    }

    /* renamed from: getLambda-2$app_release, reason: not valid java name */
    public final Function2<Composer, Integer, Unit> m8656getLambda2$app_release() {
        return f75lambda2;
    }
}
