package com.soletreadmills.sole_v2.ui.classes;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.layout.ContentScale;
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
import coil.compose.SingletonAsyncImageKt;
import com.android.SdkConstants;
import com.samsung.android.sdk.healthdata.HealthConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.classes.ClassesData;
import com.soletreadmills.sole_v2._data.classes.CollectionDetailData;
import com.soletreadmills.sole_v2._data.classes.DurationType;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui._base.BaseNavViewKt;
import com.soletreadmills.sole_v2.ui._base.EmptyViewBinding;
import com.sun.jna.platform.win32.WinError;
import com.sun.jna.platform.win32.WinPerf;
import com.sun.jna.platform.win32.WinUser;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: CollectionDetailFragment.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J)\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u000fH\u0007¢\u0006\u0002\u0010\u0010J;\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00132\u0014\b\u0002\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u000fH\u0007¢\u0006\u0002\u0010\u0014JE\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u000b0\u00132\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0013H\u0007¢\u0006\u0002\u0010\u001eJ\u001a\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u000bH\u0016J\u0012\u0010%\u001a\u00020\u000b2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J$\u0010(\u001a\u00020)2\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006*²\u0006\n\u0010+\u001a\u00020\u001bX\u008a\u0084\u0002"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/classes/CollectionDetailFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/EmptyViewBinding;", "()V", "viewModel", "Lcom/soletreadmills/sole_v2/ui/classes/CollectionDetailViewModel;", "getViewModel", "()Lcom/soletreadmills/sole_v2/ui/classes/CollectionDetailViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "ClassesDataItem", "", "data", "Lcom/soletreadmills/sole_v2/_data/classes/ClassesData;", "onClassesClick", "Lkotlin/Function1;", "(Lcom/soletreadmills/sole_v2/_data/classes/ClassesData;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "CollectionDetailScreen", "onBackClick", "Lkotlin/Function0;", "(Lcom/soletreadmills/sole_v2/ui/classes/CollectionDetailViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "ConnectBottomView", "leftText", "", "leftImg", "", "showRightBtn", "", "onLeftClick", "onRightClick", "(Ljava/lang/String;Ljava/lang/Integer;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "app_release", "showTopNav"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CollectionDetailFragment extends BaseFragment<EmptyViewBinding> {
    public static final int $stable = 8;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
    }

    public CollectionDetailFragment() {
        final CollectionDetailFragment collectionDetailFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return collectionDetailFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(collectionDetailFragment, Reflection.getOrCreateKotlinClass(CollectionDetailViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m7569viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment$special$$inlined$viewModels$default$5
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
                ViewModelProvider.Factory defaultViewModelProviderFactory2 = collectionDetailFragment.getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory2, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final CollectionDetailViewModel getViewModel() {
        return (CollectionDetailViewModel) this.viewModel.getValue();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public EmptyViewBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return new EmptyViewBinding();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("collectionId") : null;
        CollectionDetailViewModel viewModel = getViewModel();
        if (string == null) {
            string = "";
        }
        viewModel.setCollectionId(string);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextRequireContext, null, 0, 6, null);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-248583325, true, new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment$onCreateView$1$1
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
                        ComposerKt.traceEventStart(-248583325, i, -1, "com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment.onCreateView.<anonymous>.<anonymous> (CollectionDetailFragment.kt:86)");
                    }
                    CollectionDetailFragment collectionDetailFragment = this.this$0;
                    CollectionDetailViewModel viewModel = collectionDetailFragment.getViewModel();
                    final CollectionDetailFragment collectionDetailFragment2 = this.this$0;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment$onCreateView$1$1.1
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
                            collectionDetailFragment2.requireActivity().getOnBackPressedDispatcher().onBackPressed();
                        }
                    };
                    final CollectionDetailFragment collectionDetailFragment3 = this.this$0;
                    collectionDetailFragment.CollectionDetailScreen(viewModel, function0, new Function1<ClassesData, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment$onCreateView$1$1.2
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ClassesData classesData) {
                            invoke2(classesData);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ClassesData data) {
                            Intrinsics.checkNotNullParameter(data, "data");
                            Bundle bundle = new Bundle();
                            bundle.putString("classID", data.getClass_id());
                            collectionDetailFragment3.safeNavigate(R.id.classesDetailFragment, bundle);
                        }
                    }, composer, 4104, 0);
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

    public final void CollectionDetailScreen(final CollectionDetailViewModel viewModel, Function0<Unit> function0, Function1<? super ClassesData, Unit> function1, Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1815508242);
        Function0<Unit> function02 = (i2 & 2) != 0 ? new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment.CollectionDetailScreen.1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : function0;
        Function1<? super ClassesData, Unit> function12 = (i2 & 4) != 0 ? new Function1<ClassesData, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment.CollectionDetailScreen.2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ClassesData it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ClassesData classesData) {
                invoke2(classesData);
                return Unit.INSTANCE;
            }
        } : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1815508242, i, -1, "com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment.CollectionDetailScreen (CollectionDetailFragment.kt:106)");
        }
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)608@27648L68:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683737348, "CC(remember):Effects.kt#9igjgp");
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        EffectsKt.LaunchedEffect(viewModel, new C08883(viewModel, null), composerStartRestartGroup, 72);
        final LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
        composerStartRestartGroup.startReplaceGroup(1434582765);
        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment$CollectionDetailScreen$showTopNav$2$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(lazyListStateRememberLazyListState.getFirstVisibleItemIndex() > 0 || lazyListStateRememberLazyListState.getFirstVisibleItemScrollOffset() > 200);
                }
            });
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
        }
        final State state = (State) objRememberedValue2;
        composerStartRestartGroup.endReplaceGroup();
        final Function0<Unit> function03 = function02;
        final Function1<? super ClassesData, Unit> function13 = function12;
        ScaffoldKt.m1944Scaffold27mzLpw(null, null, null, ComposableLambdaKt.rememberComposableLambda(-1326748876, true, new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment.CollectionDetailScreen.4
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
                Context context;
                int i4;
                if ((i3 & 11) != 2 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1326748876, i3, -1, "com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment.CollectionDetailScreen.<anonymous> (CollectionDetailFragment.kt:125)");
                    }
                    CollectionDetailData data = viewModel.getData();
                    String string = null;
                    if (data != null ? Intrinsics.areEqual((Object) data.is_favorite(), (Object) true) : false) {
                        context = this.getContext();
                        if (context != null) {
                            i4 = R.string.save;
                            string = context.getString(i4);
                        }
                    } else {
                        context = this.getContext();
                        if (context != null) {
                            i4 = R.string.to_favorites;
                            string = context.getString(i4);
                        }
                    }
                    String str = string;
                    if (str != null) {
                        CollectionDetailFragment collectionDetailFragment = this;
                        final CollectionDetailViewModel collectionDetailViewModel = viewModel;
                        final CoroutineScope coroutineScope2 = coroutineScope;
                        CollectionDetailData data2 = collectionDetailViewModel.getData();
                        collectionDetailFragment.ConnectBottomView(str, Integer.valueOf(data2 != null ? Intrinsics.areEqual((Object) data2.is_favorite(), (Object) true) : false ? R.drawable.ic_bookmark_fill_red : R.drawable.ic_m__bookmark), false, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment$CollectionDetailScreen$4$1$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* compiled from: CollectionDetailFragment.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                            @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment$CollectionDetailScreen$4$1$1$1", f = "CollectionDetailFragment.kt", i = {}, l = {138, 140}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment$CollectionDetailScreen$4$1$1$1, reason: invalid class name */
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                final /* synthetic */ CollectionDetailViewModel $viewModel;
                                int label;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(CollectionDetailViewModel collectionDetailViewModel, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.$viewModel = collectionDetailViewModel;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.$viewModel, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    int i = this.label;
                                    if (i == 0) {
                                        ResultKt.throwOnFailure(obj);
                                        CollectionDetailData data = this.$viewModel.getData();
                                        if (data != null) {
                                            CollectionDetailViewModel collectionDetailViewModel = this.$viewModel;
                                            if (Intrinsics.areEqual(data.is_favorite(), Boxing.boxBoolean(true))) {
                                                this.label = 1;
                                                if (collectionDetailViewModel.apiDeleteFavorite(this) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                            } else {
                                                this.label = 2;
                                                if (collectionDetailViewModel.apiPostFavorite(this) == coroutine_suspended) {
                                                    return coroutine_suspended;
                                                }
                                            }
                                        }
                                    } else {
                                        if (i != 1 && i != 2) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                    }
                                    return Unit.INSTANCE;
                                }
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new AnonymousClass1(collectionDetailViewModel, null), 3, null);
                            }
                        }, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment$CollectionDetailScreen$4$1$2
                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }
                        }, composer2, 287104, 0);
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }, composerStartRestartGroup, 54), null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.rememberComposableLambda(1505322284, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment.CollectionDetailScreen.5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
            {
                super(3);
            }

            @Override // kotlin.jvm.functions.Function3
            public /* bridge */ /* synthetic */ Unit invoke(PaddingValues paddingValues, Composer composer2, Integer num) {
                invoke(paddingValues, composer2, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(PaddingValues innerPadding, Composer composer2, int i3) {
                int i4;
                String collection_name;
                Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
                if ((i3 & 14) == 0) {
                    i4 = i3 | (composer2.changed(innerPadding) ? 4 : 2);
                } else {
                    i4 = i3;
                }
                if ((i4 & 91) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1505322284, i4, -1, "com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment.CollectionDetailScreen.<anonymous> (CollectionDetailFragment.kt:150)");
                    }
                    Modifier modifierM540backgroundbw27NRU$default = BackgroundKt.m540backgroundbw27NRU$default(PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), innerPadding), ColorResources_androidKt.colorResource(R.color.colorBackground_canvas, composer2, 0), null, 2, null);
                    LazyListState lazyListState = lazyListStateRememberLazyListState;
                    final CollectionDetailViewModel collectionDetailViewModel = viewModel;
                    final Function0<Unit> function04 = function03;
                    final CollectionDetailFragment collectionDetailFragment = this;
                    final Function1<ClassesData, Unit> function14 = function13;
                    State<Boolean> state2 = state;
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM540backgroundbw27NRU$default);
                    Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM3857constructorimpl = Updater.m3857constructorimpl(composer2);
                    Updater.m3864setimpl(composerM3857constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3864setimpl(composerM3857constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM3857constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                        composerM3857constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                        composerM3857constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
                    }
                    Updater.m3864setimpl(composerM3857constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    LazyDslKt.LazyColumn(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), lazyListState, PaddingKt.m982PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, Dp.m7255constructorimpl(80), 7, null), false, Arrangement.INSTANCE.m865spacedBy0680j_4(Dp.m7255constructorimpl(12)), null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment$CollectionDetailScreen$5$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(LazyListScope lazyListScope) {
                            invoke2(lazyListScope);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(LazyListScope LazyColumn) {
                            final List<ClassesData> listEmptyList;
                            Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                            final CollectionDetailViewModel collectionDetailViewModel2 = collectionDetailViewModel;
                            final Function0<Unit> function05 = function04;
                            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-191981498, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment$CollectionDetailScreen$5$1$1.1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer3, Integer num) {
                                    invoke(lazyItemScope, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer composer3, int i5) {
                                    String background_url;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    if ((i5 & 81) != 16 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-191981498, i5, -1, "com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment.CollectionDetailScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CollectionDetailFragment.kt:165)");
                                        }
                                        Modifier modifierM1016height3ABfNKs = SizeKt.m1016height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m7255constructorimpl(280));
                                        CollectionDetailViewModel collectionDetailViewModel3 = collectionDetailViewModel2;
                                        Function0<Unit> function06 = function05;
                                        ComposerKt.sourceInformationMarkerStart(composer3, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierM1016height3ABfNKs);
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor2);
                                        } else {
                                            composer3.useNode();
                                        }
                                        Composer composerM3857constructorimpl2 = Updater.m3857constructorimpl(composer3);
                                        Updater.m3864setimpl(composerM3857constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3864setimpl(composerM3857constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (composerM3857constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                            composerM3857constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                            composerM3857constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                        }
                                        Updater.m3864setimpl(composerM3857constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(composer3, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                                        BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                                        CollectionDetailData data = collectionDetailViewModel3.getData();
                                        if (data == null || (background_url = data.getBackground_url()) == null) {
                                            background_url = "";
                                        }
                                        SingletonAsyncImageKt.m7975AsyncImage3HmZ8SU(background_url, null, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, composer3, 1573296, 952);
                                        ClassesDetailFragmentKt.CircleButton(R.drawable.ic_m__chevron_back, PaddingKt.m985padding3ABfNKs(boxScopeInstance2.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopStart()), Dp.m7255constructorimpl(12)), function06, composer3, 0, 0);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), 3, null);
                            final CollectionDetailViewModel collectionDetailViewModel3 = collectionDetailViewModel;
                            final CollectionDetailFragment collectionDetailFragment2 = collectionDetailFragment;
                            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-814963075, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment$CollectionDetailScreen$5$1$1.2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer3, Integer num) {
                                    invoke(lazyItemScope, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer composer3, int i5) {
                                    CollectionDetailViewModel collectionDetailViewModel4;
                                    String instructorsName;
                                    String collection_name2;
                                    String collection_description;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    if ((i5 & 81) != 16 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-814963075, i5, -1, "com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment.CollectionDetailScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CollectionDetailFragment.kt:190)");
                                        }
                                        Modifier modifierM986paddingVpY3zN4 = PaddingKt.m986paddingVpY3zN4(Modifier.INSTANCE, Dp.m7255constructorimpl(20), Dp.m7255constructorimpl(32));
                                        CollectionDetailViewModel collectionDetailViewModel5 = collectionDetailViewModel3;
                                        CollectionDetailFragment collectionDetailFragment3 = collectionDetailFragment2;
                                        ComposerKt.sourceInformationMarkerStart(composer3, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                                        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer3, 0);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap2 = composer3.getCurrentCompositionLocalMap();
                                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer3, modifierM986paddingVpY3zN4);
                                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor2);
                                        } else {
                                            composer3.useNode();
                                        }
                                        Composer composerM3857constructorimpl2 = Updater.m3857constructorimpl(composer3);
                                        Updater.m3864setimpl(composerM3857constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3864setimpl(composerM3857constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (composerM3857constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                                            composerM3857constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                                            composerM3857constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                                        }
                                        Updater.m3864setimpl(composerM3857constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(composer3, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                                        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                                        Arrangement.HorizontalOrVertical horizontalOrVerticalM865spacedBy0680j_4 = Arrangement.INSTANCE.m865spacedBy0680j_4(Dp.m7255constructorimpl(8));
                                        ComposerKt.sourceInformationMarkerStart(composer3, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                                        Modifier.Companion companion = Modifier.INSTANCE;
                                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM865spacedBy0680j_4, centerVertically, composer3, 54);
                                        ComposerKt.sourceInformationMarkerStart(composer3, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer3, 0);
                                        CompositionLocalMap currentCompositionLocalMap3 = composer3.getCurrentCompositionLocalMap();
                                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer3, companion);
                                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                                        ComposerKt.sourceInformationMarkerStart(composer3, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                                        if (!(composer3.getApplier() instanceof Applier)) {
                                            ComposablesKt.invalidApplier();
                                        }
                                        composer3.startReusableNode();
                                        if (composer3.getInserting()) {
                                            composer3.createNode(constructor3);
                                        } else {
                                            composer3.useNode();
                                        }
                                        Composer composerM3857constructorimpl3 = Updater.m3857constructorimpl(composer3);
                                        Updater.m3864setimpl(composerM3857constructorimpl3, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                                        Updater.m3864setimpl(composerM3857constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                                        if (composerM3857constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                                            composerM3857constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                                            composerM3857constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                                        }
                                        Updater.m3864setimpl(composerM3857constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                                        ComposerKt.sourceInformationMarkerStart(composer3, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                                        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                                        Context context = collectionDetailFragment3.getContext();
                                        composer3.startReplaceGroup(-1941626465);
                                        if (context == null) {
                                            collectionDetailViewModel4 = collectionDetailViewModel5;
                                        } else {
                                            CollectionDetailData data = collectionDetailViewModel5.getData();
                                            String string = context.getString(data != null ? data.getClassTypeTitle() : R.string.other);
                                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                                            collectionDetailViewModel4 = collectionDetailViewModel5;
                                            TextKt.m2038Text4IGK_g(string, (Modifier) null, ColorResources_androidKt.colorResource(R.color.colorLabel_label2, composer3, 0), TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199680, 0, 131026);
                                        }
                                        composer3.endReplaceGroup();
                                        BoxKt.Box(BackgroundKt.m540backgroundbw27NRU$default(SizeKt.m1016height3ABfNKs(SizeKt.m1035width3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(1)), Dp.m7255constructorimpl(16)), ColorResources_androidKt.colorResource(R.color.colorLabel_outline, composer3, 0), null, 2, null), composer3, 0);
                                        CollectionDetailData data2 = collectionDetailViewModel4.getData();
                                        if (data2 == null || (instructorsName = data2.getInstructorsName()) == null) {
                                            instructorsName = "";
                                        }
                                        TextKt.m2038Text4IGK_g(instructorsName, (Modifier) null, ColorResources_androidKt.colorResource(R.color.colorLabel_label2, composer3, 0), TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199680, 0, 131026);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        SpacerKt.Spacer(SizeKt.m1016height3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(18)), composer3, 6);
                                        CollectionDetailData data3 = collectionDetailViewModel4.getData();
                                        if (data3 == null || (collection_name2 = data3.getCollection_name()) == null) {
                                            collection_name2 = SdkConstants.RES_QUALIFIER_SEP;
                                        }
                                        TextKt.m2038Text4IGK_g(collection_name2, (Modifier) null, ColorResources_androidKt.colorResource(R.color.colorLabel_label1, composer3, 0), TextUnitKt.getSp(34), (FontStyle) null, FontWeight.INSTANCE.getExtraBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199680, 0, 131026);
                                        CollectionDetailData data4 = collectionDetailViewModel4.getData();
                                        if (data4 == null || (collection_description = data4.getCollection_description()) == null) {
                                            collection_description = SdkConstants.RES_QUALIFIER_SEP;
                                        }
                                        TextKt.m2038Text4IGK_g(collection_description, (Modifier) null, ColorResources_androidKt.colorResource(R.color.colorLabel_label1, composer3, 0), TextUnitKt.getSp(17), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, WinPerf.PERF_TYPE_ZERO, 0, 131058);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        composer3.endNode();
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        ComposerKt.sourceInformationMarkerEnd(composer3);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), 3, null);
                            final CollectionDetailViewModel collectionDetailViewModel4 = collectionDetailViewModel;
                            final CollectionDetailFragment collectionDetailFragment3 = collectionDetailFragment;
                            LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-1638773890, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment$CollectionDetailScreen$5$1$1.3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(3);
                                }

                                @Override // kotlin.jvm.functions.Function3
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer3, Integer num) {
                                    invoke(lazyItemScope, composer3, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope item, Composer composer3, int i5) {
                                    Integer workout_amount;
                                    Intrinsics.checkNotNullParameter(item, "$this$item");
                                    if ((i5 & 81) != 16 || !composer3.getSkipping()) {
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventStart(-1638773890, i5, -1, "com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment.CollectionDetailScreen.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CollectionDetailFragment.kt:235)");
                                        }
                                        StringBuilder sb = new StringBuilder();
                                        CollectionDetailData data = collectionDetailViewModel4.getData();
                                        StringBuilder sbAppend = sb.append((data == null || (workout_amount = data.getWorkout_amount()) == null) ? 0 : workout_amount.intValue()).append(' ');
                                        Context context = collectionDetailFragment3.getContext();
                                        TextKt.m2038Text4IGK_g(sbAppend.append(context != null ? context.getString(R.string.workouts) : null).toString(), PaddingKt.m986paddingVpY3zN4(Modifier.INSTANCE, Dp.m7255constructorimpl(20), Dp.m7255constructorimpl(12)), ColorResources_androidKt.colorResource(R.color.colorLabel_label1, composer3, 0), TextUnitKt.getSp(21), (FontStyle) null, FontWeight.INSTANCE.getExtraBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199728, 0, 131024);
                                        if (ComposerKt.isTraceInProgress()) {
                                            ComposerKt.traceEventEnd();
                                            return;
                                        }
                                        return;
                                    }
                                    composer3.skipToGroupEnd();
                                }
                            }), 3, null);
                            CollectionDetailData data = collectionDetailViewModel.getData();
                            if (data == null || (listEmptyList = data.getClasses()) == null) {
                                listEmptyList = CollectionsKt.emptyList();
                            }
                            final AnonymousClass4 anonymousClass4 = new Function1<ClassesData, Object>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment$CollectionDetailScreen$5$1$1.4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(ClassesData it) {
                                    Intrinsics.checkNotNullParameter(it, "it");
                                    String class_id = it.getClass_id();
                                    return class_id == null ? "" : class_id;
                                }
                            };
                            final CollectionDetailFragment collectionDetailFragment4 = collectionDetailFragment;
                            final Function1<ClassesData, Unit> function15 = function14;
                            final CollectionDetailFragment$CollectionDetailScreen$5$1$1$invoke$$inlined$items$default$1 collectionDetailFragment$CollectionDetailScreen$5$1$1$invoke$$inlined$items$default$1 = new Function1() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment$CollectionDetailScreen$5$1$1$invoke$$inlined$items$default$1
                                @Override // kotlin.jvm.functions.Function1
                                public final Void invoke(ClassesData classesData) {
                                    return null;
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                                    return invoke((ClassesData) obj);
                                }
                            };
                            LazyColumn.items(listEmptyList.size(), anonymousClass4 != null ? new Function1<Integer, Object>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment$CollectionDetailScreen$5$1$1$invoke$$inlined$items$default$2
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                    return invoke(num.intValue());
                                }

                                public final Object invoke(int i5) {
                                    return anonymousClass4.invoke(listEmptyList.get(i5));
                                }
                            } : null, new Function1<Integer, Object>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment$CollectionDetailScreen$5$1$1$invoke$$inlined$items$default$3
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                @Override // kotlin.jvm.functions.Function1
                                public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                                    return invoke(num.intValue());
                                }

                                public final Object invoke(int i5) {
                                    return collectionDetailFragment$CollectionDetailScreen$5$1$1$invoke$$inlined$items$default$1.invoke(listEmptyList.get(i5));
                                }
                            }, ComposableLambdaKt.composableLambdaInstance(-632812321, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment$CollectionDetailScreen$5$1$1$invoke$$inlined$items$default$4
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(4);
                                }

                                @Override // kotlin.jvm.functions.Function4
                                public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer3, Integer num2) {
                                    invoke(lazyItemScope, num.intValue(), composer3, num2.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(LazyItemScope lazyItemScope, int i5, Composer composer3, int i6) {
                                    int i7;
                                    ComposerKt.sourceInformation(composer3, "C152@7074L22:LazyDsl.kt#428nma");
                                    if ((i6 & 6) == 0) {
                                        i7 = (composer3.changed(lazyItemScope) ? 4 : 2) | i6;
                                    } else {
                                        i7 = i6;
                                    }
                                    if ((i6 & 48) == 0) {
                                        i7 |= composer3.changed(i5) ? 32 : 16;
                                    }
                                    if ((i7 & 147) == 146 && composer3.getSkipping()) {
                                        composer3.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-632812321, i7, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:152)");
                                    }
                                    ClassesData classesData = (ClassesData) listEmptyList.get(i5);
                                    composer3.startReplaceGroup(1887969466);
                                    collectionDetailFragment4.ClassesDataItem(classesData, function15, composer3, 520);
                                    composer3.endReplaceGroup();
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }));
                        }
                    }, composer2, 24966, WinError.ERROR_NO_DATA);
                    composer2.startReplaceGroup(-1420379949);
                    if (CollectionDetailFragment.CollectionDetailScreen$lambda$2(state2)) {
                        CollectionDetailData data = collectionDetailViewModel.getData();
                        if (data == null || (collection_name = data.getCollection_name()) == null) {
                            collection_name = "";
                        }
                        BaseNavViewKt.BaseNavView(boxScopeInstance.align(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Alignment.INSTANCE.getTopCenter()), collection_name, Integer.valueOf(R.drawable.ic_m__chevron_back), null, null, null, false, function04, null, composer2, 0, 376);
                    }
                    composer2.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                        return;
                    }
                    return;
                }
                composer2.skipToGroupEnd();
            }
        }, composerStartRestartGroup, 54), composerStartRestartGroup, WinPerf.PERF_TYPE_ZERO, WinUser.WS_CAPTION, 131063);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Function0<Unit> function04 = function02;
            final Function1<? super ClassesData, Unit> function14 = function12;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment.CollectionDetailScreen.6
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    CollectionDetailFragment.this.CollectionDetailScreen(viewModel, function04, function14, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* compiled from: CollectionDetailFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment$CollectionDetailScreen$3", f = "CollectionDetailFragment.kt", i = {}, l = {111, 112}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment$CollectionDetailScreen$3, reason: invalid class name and case insensitive filesystem */
    static final class C08883 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ CollectionDetailViewModel $viewModel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08883(CollectionDetailViewModel collectionDetailViewModel, Continuation<? super C08883> continuation) {
            super(2, continuation);
            this.$viewModel = collectionDetailViewModel;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08883(this.$viewModel, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08883) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (this.$viewModel.apiPostCollectionClick(this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    if (i != 2) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    return Unit.INSTANCE;
                }
                ResultKt.throwOnFailure(obj);
            }
            this.label = 2;
            if (this.$viewModel.apiGetCollectionDetail(this) == coroutine_suspended) {
                return coroutine_suspended;
            }
            return Unit.INSTANCE;
        }
    }

    public final void ClassesDataItem(final ClassesData data, final Function1<? super ClassesData, Unit> onClassesClick, Composer composer, final int i) {
        String title;
        String strLocalized;
        String str;
        String str2;
        int i2;
        int i3;
        Composer composer2;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(onClassesClick, "onClassesClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1563233869);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1563233869, i, -1, "com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment.ClassesDataItem (CollectionDetailFragment.kt:279)");
        }
        float f = 30;
        float f2 = 12;
        Modifier modifierM573clickableXHw0xAI$default = ClickableKt.m573clickableXHw0xAI$default(PaddingKt.m989paddingqDBjuR0$default(ClipKt.clip(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), RoundedCornerShapeKt.m1268RoundedCornerShape0680j_4(Dp.m7255constructorimpl(f))), Dp.m7255constructorimpl(f2), 0.0f, Dp.m7255constructorimpl(f2), Dp.m7255constructorimpl(f2), 2, null), false, null, null, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment.ClassesDataItem.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            /* JADX WARN: Multi-variable type inference failed */
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
                onClassesClick.invoke(data);
            }
        }, 7, null);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM573clickableXHw0xAI$default);
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
        Modifier modifierClip = ClipKt.clip(SizeKt.m1016height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m7255constructorimpl(200)), RoundedCornerShapeKt.m1268RoundedCornerShape0680j_4(Dp.m7255constructorimpl(f)));
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierClip);
        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
        Updater.m3864setimpl(composerM3857constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3864setimpl(composerM3857constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM3857constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            composerM3857constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            composerM3857constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        Updater.m3864setimpl(composerM3857constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
        String background_url = data.getBackground_url();
        if (background_url == null) {
            background_url = "";
        }
        SingletonAsyncImageKt.m7975AsyncImage3HmZ8SU(background_url, null, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, composerStartRestartGroup, 1573296, 952);
        BoxKt.Box(BackgroundKt.m540backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), Color.m4537copywmQWz5c$default(ColorResources_androidKt.colorResource(R.color.colorLabel_outline, composerStartRestartGroup, 0), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null), composerStartRestartGroup, 0);
        float f3 = 8;
        Modifier modifierAlign = boxScopeInstance.align(PaddingKt.m985padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m7255constructorimpl(f3)), Alignment.INSTANCE.getTopStart());
        Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
        Alignment.Vertical top = Alignment.INSTANCE.getTop();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, top, composerStartRestartGroup, 54);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierAlign);
        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
        StringBuilder sb = new StringBuilder();
        DurationType durationStr = data.getDurationStr();
        if (durationStr == null || (title = durationStr.getTitle()) == null) {
            title = "0";
        }
        StringBuilder sbAppend = sb.append(title).append(' ');
        Context context = getContext();
        if (context != null) {
            Intrinsics.checkNotNull(context);
            strLocalized = ClassesDetailFragmentKt.localized(context, HealthConstants.HeartRate.MIN);
        } else {
            strLocalized = null;
        }
        String string = sbAppend.append(strLocalized).toString();
        long jM4575getWhite0d7_KjU = Color.INSTANCE.m4575getWhite0d7_KjU();
        long sp = TextUnitKt.getSp(14);
        FontWeight bold = FontWeight.INSTANCE.getBold();
        float f4 = 44;
        Modifier modifierM539backgroundbw27NRU = BackgroundKt.m539backgroundbw27NRU(SizeKt.m1016height3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(f4)), Color.m4537copywmQWz5c$default(Color.INSTANCE.m4564getBlack0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.m1268RoundedCornerShape0680j_4(Dp.m7255constructorimpl(22)));
        float f5 = 16;
        TextKt.m2038Text4IGK_g(string, SizeKt.wrapContentHeight$default(PaddingKt.m987paddingVpY3zN4$default(modifierM539backgroundbw27NRU, Dp.m7255constructorimpl(f5), 0.0f, 2, null), Alignment.INSTANCE.getCenterVertically(), false, 2, null), jM4575getWhite0d7_KjU, sp, (FontStyle) null, bold, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 200064, 0, 131024);
        composerStartRestartGroup.startReplaceGroup(1255278067);
        if (Intrinsics.areEqual((Object) data.is_favorite(), (Object) true)) {
            Modifier modifierM539backgroundbw27NRU2 = BackgroundKt.m539backgroundbw27NRU(SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(f4)), Color.m4537copywmQWz5c$default(Color.INSTANCE.m4564getBlack0d7_KjU(), 0.3f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape());
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            i2 = 0;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            str = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
            i3 = -1323940314;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, str);
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM539backgroundbw27NRU2);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
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
            Updater.m3864setimpl(composerM3857constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3864setimpl(composerM3857constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3857constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                composerM3857constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                composerM3857constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m3864setimpl(composerM3857constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            str2 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
            IconKt.m1888Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_m__bookmark_fill, composerStartRestartGroup, 0), (String) null, SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(f5)), Color.INSTANCE.m4575getWhite0d7_KjU(), composerStartRestartGroup, 3512, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        } else {
            str = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
            str2 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
            i2 = 0;
            i3 = -1323940314;
        }
        composerStartRestartGroup.endReplaceGroup();
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
        Modifier modifierM986paddingVpY3zN4 = PaddingKt.m986paddingVpY3zN4(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m7255constructorimpl(f3), Dp.m7255constructorimpl(f2));
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, i2);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, i3, str);
        int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, i2);
        CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM986paddingVpY3zN4);
        Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, str2);
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
        Updater.m3864setimpl(composerM3857constructorimpl5, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3864setimpl(composerM3857constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM3857constructorimpl5.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
            composerM3857constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
            composerM3857constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
        }
        Updater.m3864setimpl(composerM3857constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
        String class_name = data.getClass_name();
        if (class_name == null) {
            class_name = "--";
        }
        int i4 = i2;
        TextKt.m2038Text4IGK_g(class_name, SizeKt.m1016height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m7255constructorimpl(24)), ColorResources_androidKt.colorResource(R.color.colorLabel_label1, composerStartRestartGroup, i2), TextUnitKt.getSp(17), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 199728, 0, 131024);
        Context context2 = getContext();
        composerStartRestartGroup.startReplaceGroup(1811178649);
        if (context2 == null) {
            composer2 = composerStartRestartGroup;
        } else {
            String string2 = context2.getString(data.getClassType().getClassCategory());
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            String upperCase = string2.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            composer2 = composerStartRestartGroup;
            TextKt.m2038Text4IGK_g(upperCase, SizeKt.m1016height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m7255constructorimpl(20)), ColorResources_androidKt.colorResource(R.color.colorLabel_label2, composerStartRestartGroup, i4), TextUnitKt.getSp(15), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 199728, 0, 131024);
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
        composer2.endReplaceGroup();
        ComposerKt.sourceInformationMarkerEnd(composer2);
        composer2.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        composer2.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment.ClassesDataItem.3
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i5) {
                    CollectionDetailFragment.this.ClassesDataItem(data, onClassesClick, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0391  */
    /* JADX WARN: Removed duplicated region for block: B:104:0x039c  */
    /* JADX WARN: Removed duplicated region for block: B:106:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0087  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:60:0x00b3  */
    /* JADX WARN: Removed duplicated region for block: B:62:0x00b6  */
    /* JADX WARN: Removed duplicated region for block: B:63:0x00b9  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x00c1  */
    /* JADX WARN: Removed duplicated region for block: B:69:0x0126  */
    /* JADX WARN: Removed duplicated region for block: B:72:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:73:0x0136  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x0169  */
    /* JADX WARN: Removed duplicated region for block: B:81:0x0223  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x022f  */
    /* JADX WARN: Removed duplicated region for block: B:85:0x0233  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0266  */
    /* JADX WARN: Removed duplicated region for block: B:93:0x0293  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0297  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x030e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void ConnectBottomView(final java.lang.String r34, final java.lang.Integer r35, boolean r36, final kotlin.jvm.functions.Function0<kotlin.Unit> r37, final kotlin.jvm.functions.Function0<kotlin.Unit> r38, androidx.compose.runtime.Composer r39, final int r40, final int r41) {
        /*
            Method dump skipped, instructions count: 950
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.CollectionDetailFragment.ConnectBottomView(java.lang.String, java.lang.Integer, boolean, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, androidx.compose.runtime.Composer, int, int):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean CollectionDetailScreen$lambda$2(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}
