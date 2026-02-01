package com.soletreadmills.sole_v2.ui.classes;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.SliderDefaults;
import androidx.compose.material.SliderKt;
import androidx.compose.material.SwitchDefaults;
import androidx.compose.material.SwitchKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.res.ColorResources_androidKt;
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
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui._base.BaseNavViewKt;
import com.soletreadmills.sole_v2.ui._base.EmptyViewBinding;
import com.soletreadmills.sole_v2.ui.customview.DashedDividerKt;
import com.soletreadmills.sole_v2.ui.customview.SelectLanguageCustom;
import com.sun.jna.platform.win32.WinPerf;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.math.MathKt;

/* compiled from: VideoSettingsFragment.kt */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003JJ\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0010H\u0007ø\u0001\u0000¢\u0006\u0004\b\u0012\u0010\u0013J\u001a\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u000bH\u0016J\u0012\u0010\u001a\u001a\u00020\u000b2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J$\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u00182\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\u0006\u0010\u001f\u001a\u00020\u000bR\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006 "}, d2 = {"Lcom/soletreadmills/sole_v2/ui/classes/VideoSettingsFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/EmptyViewBinding;", "()V", "viewModel", "Lcom/soletreadmills/sole_v2/ui/classes/VideoSettingsViewModel;", "getViewModel", "()Lcom/soletreadmills/sole_v2/ui/classes/VideoSettingsViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "VideoSettingView", "", "cellHeight", "Landroidx/compose/ui/unit/Dp;", SdkConstants.ATTR_CORNER_RADIUS, "onBackClick", "Lkotlin/Function0;", "onLangTab", "VideoSettingView-o3XDK20", "(Lcom/soletreadmills/sole_v2/ui/classes/VideoSettingsViewModel;FFLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "showLangAlert", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VideoSettingsFragment extends BaseFragment<EmptyViewBinding> {
    public static final int $stable = 8;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
    }

    public VideoSettingsFragment() {
        final VideoSettingsFragment videoSettingsFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoSettingsFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return videoSettingsFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoSettingsFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function0.invoke();
            }
        });
        final Function0 function02 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(videoSettingsFragment, Reflection.getOrCreateKotlinClass(VideoSettingsViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoSettingsFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m7569viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoSettingsFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function03 = function02;
                if (function03 != null && (creationExtras = (CreationExtras) function03.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM7569viewModels$lambda1 = FragmentViewModelLazyKt.m7569viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM7569viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM7569viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoSettingsFragment$special$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory;
                ViewModelStoreOwner viewModelStoreOwnerM7569viewModels$lambda1 = FragmentViewModelLazyKt.m7569viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM7569viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM7569viewModels$lambda1 : null;
                if (hasDefaultViewModelProviderFactory != null && (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) != null) {
                    return defaultViewModelProviderFactory;
                }
                ViewModelProvider.Factory defaultViewModelProviderFactory2 = videoSettingsFragment.getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory2, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoSettingsViewModel getViewModel() {
        return (VideoSettingsViewModel) this.viewModel.getValue();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public EmptyViewBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return new EmptyViewBinding();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextRequireContext, null, 0, 6, null);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(1070009227, true, new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoSettingsFragment$onCreateView$1$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) {
                if ((i & 11) != 2 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1070009227, i, -1, "com.soletreadmills.sole_v2.ui.classes.VideoSettingsFragment.onCreateView.<anonymous>.<anonymous> (VideoSettingsFragment.kt:67)");
                    }
                    VideoSettingsFragment videoSettingsFragment = this.this$0;
                    VideoSettingsViewModel viewModel = videoSettingsFragment.getViewModel();
                    final VideoSettingsFragment videoSettingsFragment2 = this.this$0;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoSettingsFragment$onCreateView$1$1.1
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
                            videoSettingsFragment2.requireActivity().getOnBackPressedDispatcher().onBackPressed();
                        }
                    };
                    final VideoSettingsFragment videoSettingsFragment3 = this.this$0;
                    videoSettingsFragment.m8666VideoSettingViewo3XDK20(viewModel, 0.0f, 0.0f, function0, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoSettingsFragment$onCreateView$1$1.2
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
                            videoSettingsFragment3.showLangAlert();
                        }
                    }, composer, 262152, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer.skipToGroupEnd();
            }
        }));
        return composeView;
    }

    public final void showLangAlert() {
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null) {
            mainActivity.getChangeViewManager().changePage(new SelectLanguageCustom(mainActivity, getViewModel().getDefaultLocale(), new SelectLanguageCustom.SelectLanguageListener() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoSettingsFragment$showLangAlert$1$1
                @Override // com.soletreadmills.sole_v2.ui.customview.SelectLanguageCustom.SelectLanguageListener
                public void onClick(Locale selectLocale) {
                    Intrinsics.checkNotNullParameter(selectLocale, "selectLocale");
                    this.this$0.getViewModel().updateSubtitleLanguage(selectLocale);
                    MainActivity mainActivity2 = this.this$0.getMainActivity();
                    if (mainActivity2 != null) {
                        mainActivity2.onBackPressed();
                    }
                }
            }));
        }
    }

    /* renamed from: VideoSettingView-o3XDK20, reason: not valid java name */
    public final void m8666VideoSettingViewo3XDK20(final VideoSettingsViewModel viewModel, float f, float f2, final Function0<Unit> onBackClick, final Function0<Unit> onLangTab, Composer composer, final int i, final int i2) {
        String str;
        String str2;
        String str3;
        String str4;
        String str5;
        String str6;
        String str7;
        String str8;
        float f3;
        String str9;
        String str10;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Intrinsics.checkNotNullParameter(onLangTab, "onLangTab");
        Composer composerStartRestartGroup = composer.startRestartGroup(1675930759);
        final float fM7255constructorimpl = (i2 & 2) != 0 ? Dp.m7255constructorimpl(56) : f;
        float fM7255constructorimpl2 = (i2 & 4) != 0 ? Dp.m7255constructorimpl(28) : f2;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1675930759, i, -1, "com.soletreadmills.sole_v2.ui.classes.VideoSettingsFragment.VideoSettingView (VideoSettingsFragment.kt:107)");
        }
        float f4 = 12;
        Modifier modifierM987paddingVpY3zN4$default = PaddingKt.m987paddingVpY3zN4$default(BackgroundKt.m540backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), ColorResources_androidKt.colorResource(R.color.colorBackground_canvas, composerStartRestartGroup, 0), null, 2, null), 0.0f, Dp.m7255constructorimpl(f4), 1, null);
        Arrangement.HorizontalOrVertical horizontalOrVerticalM865spacedBy0680j_4 = Arrangement.INSTANCE.m865spacedBy0680j_4(Dp.m7255constructorimpl(f4));
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM865spacedBy0680j_4, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM987paddingVpY3zN4$default);
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
        Context context = getContext();
        composerStartRestartGroup.startReplaceGroup(1843340096);
        if (context != null) {
            String string = context.getString(R.string.video_settings);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            str = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
            str2 = "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo";
            str3 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
            str4 = "C88@4444L9:Column.kt#2w3rfo";
            BaseNavViewKt.BaseNavView(null, string, null, context.getString(R.string.done), null, null, false, onBackClick, null, composerStartRestartGroup, ((i << 12) & 29360128) | 1572864, 309);
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        } else {
            str = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
            str2 = "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo";
            str3 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
            str4 = "C88@4444L9:Column.kt#2w3rfo";
        }
        composerStartRestartGroup.endReplaceGroup();
        float f5 = 16;
        Modifier modifierM987paddingVpY3zN4$default2 = PaddingKt.m987paddingVpY3zN4$default(BackgroundKt.m540backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m987paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m7255constructorimpl(f5), 0.0f, 2, null), RoundedCornerShapeKt.m1268RoundedCornerShape0680j_4(fM7255constructorimpl2)), ColorResources_androidKt.colorResource(R.color.colorBackground_raised, composerStartRestartGroup, 0), null, 2, null), Dp.m7255constructorimpl(f5), 0.0f, 2, null);
        String str11 = str2;
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, str11);
        MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, str);
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM987paddingVpY3zN4$default2);
        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
        String str12 = str3;
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, str12);
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor2);
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM3857constructorimpl2 = Updater.m3857constructorimpl(composerStartRestartGroup);
        Updater.m3864setimpl(composerM3857constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3864setimpl(composerM3857constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM3857constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            composerM3857constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            composerM3857constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        Updater.m3864setimpl(composerM3857constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
        String str13 = str4;
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, str13);
        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
        Modifier modifierM1016height3ABfNKs = SizeKt.m1016height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), fM7255constructorimpl);
        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
        final float f6 = fM7255constructorimpl2;
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, str);
        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1016height3ABfNKs);
        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, str12);
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor3);
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM3857constructorimpl3 = Updater.m3857constructorimpl(composerStartRestartGroup);
        Updater.m3864setimpl(composerM3857constructorimpl3, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3864setimpl(composerM3857constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM3857constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
            composerM3857constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
            composerM3857constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
        }
        Updater.m3864setimpl(composerM3857constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        Context context2 = getContext();
        composerStartRestartGroup.startReplaceGroup(-580969037);
        if (context2 != null) {
            String string2 = context2.getString(R.string.show_subtitles);
            long sp = TextUnitKt.getSp(17);
            FontWeight semiBold = FontWeight.INSTANCE.getSemiBold();
            long jColorResource = ColorResources_androidKt.colorResource(R.color.colorLabel_label1, composerStartRestartGroup, 0);
            str5 = "C101@5126L9:Row.kt#2w3rfo";
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            str6 = str13;
            Intrinsics.checkNotNull(string2);
            str7 = str11;
            str8 = str12;
            f3 = f5;
            TextKt.m2038Text4IGK_g(string2, modifierWeight$default, jColorResource, sp, (FontStyle) null, semiBold, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 199680, 0, 131024);
            Unit unit3 = Unit.INSTANCE;
            Unit unit4 = Unit.INSTANCE;
        } else {
            str6 = str13;
            str5 = "C101@5126L9:Row.kt#2w3rfo";
            str7 = str11;
            str8 = str12;
            f3 = f5;
        }
        composerStartRestartGroup.endReplaceGroup();
        SwitchKt.Switch(viewModel.getShowSubtitles(), new Function1<Boolean, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoSettingsFragment$VideoSettingView$1$2$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke(bool.booleanValue());
                return Unit.INSTANCE;
            }

            public final void invoke(boolean z) {
                viewModel.updateShowSubtitles(z);
            }
        }, null, false, null, SwitchDefaults.INSTANCE.m1990colorsSQMK_m0(ColorResources_androidKt.colorResource(R.color.colorLabel_accent, composerStartRestartGroup, 0), 0L, 0.0f, Color.INSTANCE.m4568getGray0d7_KjU(), 0L, 0.0f, 0L, 0L, 0L, 0L, composerStartRestartGroup, WinPerf.PERF_TYPE_ZERO, SwitchDefaults.$stable, 1014), composerStartRestartGroup, 0, 28);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        composerStartRestartGroup.endNode();
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        DashedDividerKt.m8697DashedDividersv6B3W4(ColorResources_androidKt.colorResource(R.color.colorLabel_outline, composerStartRestartGroup, 0), 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 0, 14);
        Modifier modifierM1016height3ABfNKs2 = SizeKt.m1016height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), fM7255constructorimpl);
        composerStartRestartGroup.startReplaceGroup(2037988351);
        boolean z = (((57344 & i) ^ 24576) > 16384 && composerStartRestartGroup.changed(onLangTab)) || (i & 24576) == 16384;
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoSettingsFragment$VideoSettingView$1$2$2$1
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
                    onLangTab.invoke();
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        composerStartRestartGroup.endReplaceGroup();
        Modifier modifierM573clickableXHw0xAI$default = ClickableKt.m573clickableXHw0xAI$default(modifierM1016height3ABfNKs2, false, null, null, (Function0) objRememberedValue, 7, null);
        Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
        MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, str);
        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM573clickableXHw0xAI$default);
        Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, str8);
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor4);
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM3857constructorimpl4 = Updater.m3857constructorimpl(composerStartRestartGroup);
        Updater.m3864setimpl(composerM3857constructorimpl4, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3864setimpl(composerM3857constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM3857constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
            composerM3857constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
            composerM3857constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
        }
        Updater.m3864setimpl(composerM3857constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
        String str14 = str5;
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, str14);
        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
        Context context3 = getContext();
        composerStartRestartGroup.startReplaceGroup(-580967541);
        if (context3 == null) {
            str9 = str14;
        } else {
            String string3 = context3.getString(R.string.language);
            long sp2 = TextUnitKt.getSp(17);
            FontWeight medium = FontWeight.INSTANCE.getMedium();
            long jColorResource2 = ColorResources_androidKt.colorResource(R.color.colorLabel_label1, composerStartRestartGroup, 0);
            Modifier modifierWeight$default2 = RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null);
            str9 = str14;
            Intrinsics.checkNotNull(string3);
            TextKt.m2038Text4IGK_g(string3, modifierWeight$default2, jColorResource2, sp2, (FontStyle) null, medium, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 199680, 0, 131024);
            Unit unit5 = Unit.INSTANCE;
            Unit unit6 = Unit.INSTANCE;
        }
        composerStartRestartGroup.endReplaceGroup();
        TextKt.m2038Text4IGK_g(viewModel.getLanguage(), (Modifier) null, ColorResources_androidKt.colorResource(R.color.colorLabel_accent, composerStartRestartGroup, 0), TextUnitKt.getSp(17), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 199680, 0, 131026);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        composerStartRestartGroup.endNode();
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        composerStartRestartGroup.endNode();
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        Modifier modifierM987paddingVpY3zN4$default3 = PaddingKt.m987paddingVpY3zN4$default(BackgroundKt.m540backgroundbw27NRU$default(ClipKt.clip(PaddingKt.m987paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m7255constructorimpl(f3), 0.0f, 2, null), RoundedCornerShapeKt.m1268RoundedCornerShape0680j_4(f6)), ColorResources_androidKt.colorResource(R.color.colorBackground_raised, composerStartRestartGroup, 0), null, 2, null), Dp.m7255constructorimpl(f3), 0.0f, 2, null);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, str7);
        MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, str);
        int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM987paddingVpY3zN4$default3);
        Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, str8);
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor5);
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM3857constructorimpl5 = Updater.m3857constructorimpl(composerStartRestartGroup);
        Updater.m3864setimpl(composerM3857constructorimpl5, measurePolicyColumnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3864setimpl(composerM3857constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM3857constructorimpl5.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
            composerM3857constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
            composerM3857constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
        }
        Updater.m3864setimpl(composerM3857constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, str6);
        ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
        Modifier modifierM1016height3ABfNKs3 = SizeKt.m1016height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), fM7255constructorimpl);
        Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
        MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically3, composerStartRestartGroup, 48);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, str);
        int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1016height3ABfNKs3);
        Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, str8);
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor6);
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM3857constructorimpl6 = Updater.m3857constructorimpl(composerStartRestartGroup);
        Updater.m3864setimpl(composerM3857constructorimpl6, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3864setimpl(composerM3857constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM3857constructorimpl6.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
            composerM3857constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
            composerM3857constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
        }
        Updater.m3864setimpl(composerM3857constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
        String str15 = str9;
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, str15);
        RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
        Context context4 = getContext();
        composerStartRestartGroup.startReplaceGroup(-580966191);
        if (context4 == null) {
            str10 = str15;
        } else {
            String string4 = context4.getString(R.string.music);
            long sp3 = TextUnitKt.getSp(17);
            FontWeight medium2 = FontWeight.INSTANCE.getMedium();
            long jColorResource3 = ColorResources_androidKt.colorResource(R.color.colorLabel_label1, composerStartRestartGroup, 0);
            Modifier modifierWeight$default3 = RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null);
            str10 = str15;
            Intrinsics.checkNotNull(string4);
            TextKt.m2038Text4IGK_g(string4, modifierWeight$default3, jColorResource3, sp3, (FontStyle) null, medium2, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 199680, 0, 131024);
            Unit unit7 = Unit.INSTANCE;
            Unit unit8 = Unit.INSTANCE;
        }
        composerStartRestartGroup.endReplaceGroup();
        TextKt.m2038Text4IGK_g(new StringBuilder().append((int) (viewModel.getMusicVolume() * 100)).append('%').toString(), (Modifier) null, ColorResources_androidKt.colorResource(R.color.colorLabel_label3, composerStartRestartGroup, 0), TextUnitKt.getSp(17), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 199680, 0, 131026);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        composerStartRestartGroup.endNode();
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        DashedDividerKt.m8697DashedDividersv6B3W4(ColorResources_androidKt.colorResource(R.color.colorLabel_outline, composerStartRestartGroup, 0), 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 0, 14);
        Modifier modifierM1016height3ABfNKs4 = SizeKt.m1016height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), fM7255constructorimpl);
        Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
        Arrangement.HorizontalOrVertical horizontalOrVerticalM865spacedBy0680j_42 = Arrangement.INSTANCE.m865spacedBy0680j_4(Dp.m7255constructorimpl(f3));
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
        MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(horizontalOrVerticalM865spacedBy0680j_42, centerVertically4, composerStartRestartGroup, 54);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, str);
        int currentCompositeKeyHash7 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1016height3ABfNKs4);
        Function0<ComposeUiNode> constructor7 = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, str8);
        if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composerStartRestartGroup.startReusableNode();
        if (composerStartRestartGroup.getInserting()) {
            composerStartRestartGroup.createNode(constructor7);
        } else {
            composerStartRestartGroup.useNode();
        }
        Composer composerM3857constructorimpl7 = Updater.m3857constructorimpl(composerStartRestartGroup);
        Updater.m3864setimpl(composerM3857constructorimpl7, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3864setimpl(composerM3857constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash7 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM3857constructorimpl7.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl7.rememberedValue(), Integer.valueOf(currentCompositeKeyHash7))) {
            composerM3857constructorimpl7.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash7));
            composerM3857constructorimpl7.apply(Integer.valueOf(currentCompositeKeyHash7), setCompositeKeyHash7);
        }
        Updater.m3864setimpl(composerM3857constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, str10);
        RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
        float f7 = 24;
        IconKt.m1888Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_m__music_strikethrough, composerStartRestartGroup, 0), (String) null, SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(f7)), ColorResources_androidKt.colorResource(R.color.colorLabel_label3, composerStartRestartGroup, 0), composerStartRestartGroup, 440, 0);
        SliderKt.Slider(viewModel.getMusicVolume(), new Function1<Float, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoSettingsFragment$VideoSettingView$1$3$2$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Float f8) {
                invoke(f8.floatValue());
                return Unit.INSTANCE;
            }

            public final void invoke(float f8) {
                viewModel.updateMusicVolume(MathKt.roundToInt(f8 * 10) / 10.0f);
            }
        }, RowScope.weight$default(rowScopeInstance4, Modifier.INSTANCE, 1.0f, false, 2, null), false, null, 0, null, null, SliderDefaults.INSTANCE.m1953colorsq0g_0yA(ColorResources_androidKt.colorResource(R.color.colorLabel_accent, composerStartRestartGroup, 0), 0L, ColorResources_androidKt.colorResource(R.color.colorLabel_accent, composerStartRestartGroup, 0), ColorResources_androidKt.colorResource(R.color.colorBackground_raised, composerStartRestartGroup, 0), 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, SliderDefaults.$stable, 1010), composerStartRestartGroup, 0, 248);
        IconKt.m1888Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_m__music, composerStartRestartGroup, 0), (String) null, SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(f7)), ColorResources_androidKt.colorResource(R.color.colorLabel_label3, composerStartRestartGroup, 0), composerStartRestartGroup, 440, 0);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        composerStartRestartGroup.endNode();
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        composerStartRestartGroup.endNode();
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        composerStartRestartGroup.endNode();
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoSettingsFragment$VideoSettingView$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    this.$tmp0_rcvr.m8666VideoSettingViewo3XDK20(viewModel, fM7255constructorimpl, f6, onBackClick, onLangTab, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}
