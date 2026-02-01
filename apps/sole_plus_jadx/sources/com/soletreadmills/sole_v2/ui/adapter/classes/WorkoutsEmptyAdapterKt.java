package com.soletreadmills.sole_v2.ui.adapter.classes;

import android.content.res.Resources;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.ColorResources_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontKt;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.soletreadmills.sole_v2.R;
import com.sun.jna.platform.win32.WinPerf;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: WorkoutsEmptyAdapter.kt */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005"}, d2 = {"WorkoutsEmpty", "", "onResetFiltersClick", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WorkoutsEmptyAdapterKt {
    public static final void WorkoutsEmpty(final Function0<Unit> onResetFiltersClick, Composer composer, final int i) throws Resources.NotFoundException {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(onResetFiltersClick, "onResetFiltersClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(645510373);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(onResetFiltersClick) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i2 & 11) != 2 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(645510373, i2, -1, "com.soletreadmills.sole_v2.ui.adapter.classes.WorkoutsEmpty (WorkoutsEmptyAdapter.kt:56)");
            }
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Modifier modifierM989paddingqDBjuR0$default = PaddingKt.m989paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m7255constructorimpl(40), 0.0f, 0.0f, 13, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM989paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3857constructorimpl = Updater.m3857constructorimpl(composerStartRestartGroup);
            Updater.m3864setimpl(composerM3857constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3864setimpl(composerM3857constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3857constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3857constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3857constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3864setimpl(composerM3857constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            int i3 = i2;
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.search_empty, composerStartRestartGroup, 0), (String) null, SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(120)), (Alignment) null, (ContentScale) null, 0.0f, (ColorFilter) null, composerStartRestartGroup, 440, 120);
            float f = 20;
            TextKt.m2975Text4IGK_g(StringResources_androidKt.stringResource(R.string.hint_29, composerStartRestartGroup, 0), PaddingKt.m987paddingVpY3zN4$default(PaddingKt.m989paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m7255constructorimpl(f), 0.0f, 0.0f, 13, null), Dp.m7255constructorimpl(f), 0.0f, 2, null), ColorResources_androidKt.colorResource(R.color.colorLabel_label3, composerStartRestartGroup, 0), TextUnitKt.getSp(17), (FontStyle) null, (FontWeight) null, FontFamilyKt.FontFamily(FontKt.m6811FontYpTlLL0$default(R.font.inter_regular_400, null, 0, 0, 14, null)), 0L, (TextDecoration) null, TextAlign.m7132boximpl(TextAlign.INSTANCE.m7139getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 3120, 0, 130480);
            String strStringResource = StringResources_androidKt.stringResource(R.string.reset_filters, composerStartRestartGroup, 0);
            FontFamily FontFamily = FontFamilyKt.FontFamily(FontKt.m6811FontYpTlLL0$default(R.font.inter_semibold_600, null, 0, 0, 14, null));
            long jColorResource = ColorResources_androidKt.colorResource(R.color.colorGlobal_accent, composerStartRestartGroup, 0);
            long sp = TextUnitKt.getSp(17);
            Modifier modifierM989paddingqDBjuR0$default2 = PaddingKt.m989paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m7255constructorimpl(f), 0.0f, 0.0f, 13, null);
            composerStartRestartGroup.startReplaceGroup(1543898597);
            boolean z = (i3 & 14) == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.adapter.classes.WorkoutsEmptyAdapterKt$WorkoutsEmpty$1$1$1
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
                        onResetFiltersClick.invoke();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            float f2 = 28;
            composer2 = composerStartRestartGroup;
            TextKt.m2975Text4IGK_g(strStringResource, PaddingKt.m986paddingVpY3zN4(BackgroundKt.m539backgroundbw27NRU(ClickableKt.m573clickableXHw0xAI$default(modifierM989paddingqDBjuR0$default2, false, null, null, (Function0) objRememberedValue, 7, null), ColorResources_androidKt.colorResource(R.color.colorBackground_raised, composerStartRestartGroup, 0), RoundedCornerShapeKt.m1268RoundedCornerShape0680j_4(Dp.m7255constructorimpl(f2))), Dp.m7255constructorimpl(f2), Dp.m7255constructorimpl(16)), jColorResource, sp, (FontStyle) null, (FontWeight) null, FontFamily, 0L, (TextDecoration) null, TextAlign.m7132boximpl(TextAlign.INSTANCE.m7139getCentere0LSkKk()), 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, WinPerf.PERF_TYPE_ZERO, 0, 130480);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            composer2 = composerStartRestartGroup;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.adapter.classes.WorkoutsEmptyAdapterKt.WorkoutsEmpty.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) throws Resources.NotFoundException {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) throws Resources.NotFoundException {
                    WorkoutsEmptyAdapterKt.WorkoutsEmpty(onResetFiltersClick, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
