package com.soletreadmills.sole_v2.ui.classes;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ButtonDefaults;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.DividerKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.ScaffoldKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
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
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.LocalLifecycleOwnerKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import coil.compose.SingletonAsyncImageKt;
import coil.request.ImageRequest;
import com.android.SdkConstants;
import com.samsung.android.sdk.healthdata.HealthConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.classes.ClassCollectionsData;
import com.soletreadmills.sole_v2._data.classes.ClassesData;
import com.soletreadmills.sole_v2._data.classes.DifficultyType;
import com.soletreadmills.sole_v2._data.classes.DurationType;
import com.soletreadmills.sole_v2._tools.WearDataTool;
import com.soletreadmills.sole_v2._type.ClassType;
import com.soletreadmills.sole_v2._type.WearStatusType;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui._base.EmptyViewBinding;
import com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment;
import com.sun.jna.platform.win32.WinError;
import com.sun.jna.platform.win32.WinPerf;
import com.sun.jna.platform.win32.WinUser;
import java.util.List;
import java.util.Locale;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import timber.log.Timber;

/* compiled from: ClassesDetailFragment.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J%\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010\u0011J?\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0012\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u0017H\u0007¢\u0006\u0002\u0010\u0018J)\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0012\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u0017H\u0007¢\u0006\u0002\u0010\u001bJ{\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001d\u001a\u00020\r2\u0006\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001f2\u000e\b\u0002\u0010 \u001a\b\u0012\u0004\u0012\u00020\u000b0\u001f2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001f2\u000e\b\u0002\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001f2\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u000b0\u00172\u0006\u0010#\u001a\u00020$H\u0007¢\u0006\u0002\u0010%JE\u0010&\u001a\u00020\u000b2\u0006\u0010'\u001a\u00020\r2\b\u0010(\u001a\u0004\u0018\u00010)2\b\b\u0002\u0010*\u001a\u00020\u00102\f\u0010+\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001f2\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001fH\u0007¢\u0006\u0002\u0010-J\u001a\u0010.\u001a\u00020\u00022\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00103\u001a\u00020\u000bH\u0016J\u0012\u00104\u001a\u00020\u000b2\b\u00105\u001a\u0004\u0018\u000106H\u0016J$\u00107\u001a\u0002082\u0006\u0010/\u001a\u0002002\b\u00101\u001a\u0004\u0018\u0001022\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00109\u001a\u00020\u000bH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006:"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/classes/ClassesDetailFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/EmptyViewBinding;", "()V", "viewModel", "Lcom/soletreadmills/sole_v2/ui/classes/ClassDetailViewModel;", "getViewModel", "()Lcom/soletreadmills/sole_v2/ui/classes/ClassDetailViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "CellView", "", "title", "", "value", "showBG", "", "(Ljava/lang/String;Ljava/lang/String;ZLandroidx/compose/runtime/Composer;I)V", "CellViewWithUnderline", SdkConstants.FD_RES_VALUES, "", "Lcom/soletreadmills/sole_v2/_data/classes/ClassCollectionsData;", SdkConstants.ATTR_ON_CLICK, "Lkotlin/Function1;", "(Ljava/lang/String;Ljava/util/List;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ClassDetailView", "onClickCollection", "(Lcom/soletreadmills/sole_v2/ui/classes/ClassDetailViewModel;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ClassesDetailScreen", "classId", "onBackClick", "Lkotlin/Function0;", "onStartClick", "onWatchClick", "onDeviceClick", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "(Ljava/lang/String;Lcom/soletreadmills/sole_v2/ui/classes/ClassDetailViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroid/content/Context;Landroidx/compose/runtime/Composer;II)V", "ConnectBottomView", "leftText", "leftImg", "", "showRightBtn", "onLeftClick", "onRightClick", "(Ljava/lang/String;Ljava/lang/Integer;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "onResume", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassesDetailFragment extends BaseFragment<EmptyViewBinding> {
    public static final int $stable = 8;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
    }

    public ClassesDetailFragment() {
        final ClassesDetailFragment classesDetailFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return classesDetailFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(classesDetailFragment, Reflection.getOrCreateKotlinClass(ClassDetailViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m7569viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$special$$inlined$viewModels$default$5
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
                ViewModelProvider.Factory defaultViewModelProviderFactory2 = classesDetailFragment.getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory2, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassDetailViewModel getViewModel() {
        return (ClassDetailViewModel) this.viewModel.getValue();
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
        String string = arguments != null ? arguments.getString("classID") : null;
        ClassDetailViewModel viewModel = getViewModel();
        if (string == null) {
            string = "";
        }
        viewModel.setClassId(string);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        getViewModel().updateFtmsConnectionStatus();
        getViewModel().updateHrConnectionStatus();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextRequireContext, null, 0, 6, null);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(1399959531, true, new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$onCreateView$1$1
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
                        ComposerKt.traceEventStart(1399959531, i, -1, "com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.onCreateView.<anonymous>.<anonymous> (ClassesDetailFragment.kt:99)");
                    }
                    MainActivity mainActivity = this.this$0.getMainActivity();
                    if (mainActivity != null) {
                        final ClassesDetailFragment classesDetailFragment = this.this$0;
                        classesDetailFragment.ClassesDetailScreen(classesDetailFragment.getViewModel().getClassId(), classesDetailFragment.getViewModel(), new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$onCreateView$1$1$1$1
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
                                classesDetailFragment.requireActivity().getOnBackPressedDispatcher().onBackPressed();
                                try {
                                    BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(classesDetailFragment), Dispatchers.getIO(), null, new AnonymousClass1(classesDetailFragment, null), 2, null);
                                } catch (Exception e) {
                                    Timber.INSTANCE.e(e);
                                }
                            }

                            /* compiled from: ClassesDetailFragment.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                            @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$onCreateView$1$1$1$1$1", f = "ClassesDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$onCreateView$1$1$1$1$1, reason: invalid class name */
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                int label;
                                final /* synthetic */ ClassesDetailFragment this$0;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(ClassesDetailFragment classesDetailFragment, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.this$0 = classesDetailFragment;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.this$0, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Object invokeSuspend(Object obj) {
                                    IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                    if (this.label != 0) {
                                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                    }
                                    ResultKt.throwOnFailure(obj);
                                    MainActivity mainActivity = this.this$0.getMainActivity();
                                    if (mainActivity != null) {
                                        WearDataTool.INSTANCE.callWearCommand(WearStatusType.MACHINE_IS_STOP.getId(), mainActivity);
                                    }
                                    return Unit.INSTANCE;
                                }
                            }
                        }, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$onCreateView$1$1$1$2
                            {
                                super(0);
                            }

                            @Override // kotlin.jvm.functions.Function0
                            public /* bridge */ /* synthetic */ Unit invoke() {
                                invoke2();
                                return Unit.INSTANCE;
                            }

                            /* compiled from: ClassesDetailFragment.kt */
                            @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                            @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$onCreateView$1$1$1$2$1", f = "ClassesDetailFragment.kt", i = {}, l = {123, 125}, m = "invokeSuspend", n = {}, s = {})
                            /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$onCreateView$1$1$1$2$1, reason: invalid class name */
                            static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                int label;
                                final /* synthetic */ ClassesDetailFragment this$0;

                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                AnonymousClass1(ClassesDetailFragment classesDetailFragment, Continuation<? super AnonymousClass1> continuation) {
                                    super(2, continuation);
                                    this.this$0 = classesDetailFragment;
                                }

                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                    return new AnonymousClass1(this.this$0, continuation);
                                }

                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                    return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                }

                                /* JADX WARN: Removed duplicated region for block: B:20:0x006c  */
                                /* JADX WARN: Removed duplicated region for block: B:21:0x0071  */
                                @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                /*
                                    Code decompiled incorrectly, please refer to instructions dump.
                                    To view partially-correct add '--show-bad-code' argument
                                */
                                public final java.lang.Object invokeSuspend(java.lang.Object r12) {
                                    /*
                                        r11 = this;
                                        java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                                        int r1 = r11.label
                                        r2 = 1
                                        r3 = 2
                                        r4 = 0
                                        if (r1 == 0) goto L1f
                                        if (r1 == r2) goto L1b
                                        if (r1 != r3) goto L13
                                        kotlin.ResultKt.throwOnFailure(r12)
                                        goto L4e
                                    L13:
                                        java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
                                        java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                                        r12.<init>(r0)
                                        throw r12
                                    L1b:
                                        kotlin.ResultKt.throwOnFailure(r12)
                                        goto L34
                                    L1f:
                                        kotlin.ResultKt.throwOnFailure(r12)
                                        com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment r12 = r11.this$0
                                        com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel r12 = com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.access$getViewModel(r12)
                                        r1 = r11
                                        kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                                        r11.label = r2
                                        java.lang.Object r12 = r12.apiGetSubscriptionStatus(r1)
                                        if (r12 != r0) goto L34
                                        return r0
                                    L34:
                                        java.lang.Boolean r12 = (java.lang.Boolean) r12
                                        boolean r12 = r12.booleanValue()
                                        if (r12 == 0) goto Laa
                                        com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment r12 = r11.this$0
                                        com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel r12 = com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.access$getViewModel(r12)
                                        r1 = r11
                                        kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                                        r11.label = r3
                                        java.lang.Object r12 = r12.apiPostStartClass(r1)
                                        if (r12 != r0) goto L4e
                                        return r0
                                    L4e:
                                        android.os.Bundle r12 = new android.os.Bundle
                                        r12.<init>()
                                        com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment r0 = r11.this$0
                                        com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel r1 = com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.access$getViewModel(r0)
                                        java.lang.String r1 = r1.getClassId()
                                        java.lang.String r2 = "classID"
                                        r12.putString(r2, r1)
                                        com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel r0 = com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.access$getViewModel(r0)
                                        com.soletreadmills.sole_v2._data.classes.ClassesData r0 = r0.getData()
                                        if (r0 == 0) goto L71
                                        java.lang.String r0 = r0.getVideo_id()
                                        goto L72
                                    L71:
                                        r0 = r4
                                    L72:
                                        java.lang.String r1 = "videoID"
                                        r12.putString(r1, r0)
                                        com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment r0 = r11.this$0     // Catch: java.lang.Exception -> L9a
                                        androidx.lifecycle.LifecycleOwner r0 = (androidx.lifecycle.LifecycleOwner) r0     // Catch: java.lang.Exception -> L9a
                                        androidx.lifecycle.LifecycleCoroutineScope r0 = androidx.lifecycle.LifecycleOwnerKt.getLifecycleScope(r0)     // Catch: java.lang.Exception -> L9a
                                        r5 = r0
                                        kotlinx.coroutines.CoroutineScope r5 = (kotlinx.coroutines.CoroutineScope) r5     // Catch: java.lang.Exception -> L9a
                                        kotlinx.coroutines.CoroutineDispatcher r0 = kotlinx.coroutines.Dispatchers.getIO()     // Catch: java.lang.Exception -> L9a
                                        r6 = r0
                                        kotlin.coroutines.CoroutineContext r6 = (kotlin.coroutines.CoroutineContext) r6     // Catch: java.lang.Exception -> L9a
                                        com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$onCreateView$1$1$1$2$1$1 r0 = new com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$onCreateView$1$1$1$2$1$1     // Catch: java.lang.Exception -> L9a
                                        com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment r1 = r11.this$0     // Catch: java.lang.Exception -> L9a
                                        r0.<init>(r1, r4)     // Catch: java.lang.Exception -> L9a
                                        r8 = r0
                                        kotlin.jvm.functions.Function2 r8 = (kotlin.jvm.functions.Function2) r8     // Catch: java.lang.Exception -> L9a
                                        r9 = 2
                                        r10 = 0
                                        r7 = 0
                                        kotlinx.coroutines.BuildersKt.launch$default(r5, r6, r7, r8, r9, r10)     // Catch: java.lang.Exception -> L9a
                                        goto La2
                                    L9a:
                                        r0 = move-exception
                                        timber.log.Timber$Forest r1 = timber.log.Timber.INSTANCE
                                        java.lang.Throwable r0 = (java.lang.Throwable) r0
                                        r1.e(r0)
                                    La2:
                                        com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment r0 = r11.this$0
                                        int r1 = com.soletreadmills.sole_v2.R.id.videoModeFragment
                                        com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.access$safeNavigate(r0, r1, r12)
                                        goto Lb3
                                    Laa:
                                        com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment r12 = r11.this$0
                                        com.soletreadmills.sole_v2.ui._base.BaseFragment r12 = (com.soletreadmills.sole_v2.ui._base.BaseFragment) r12
                                        int r0 = com.soletreadmills.sole_v2.R.id.payWallFragment
                                        com.soletreadmills.sole_v2.ui._base.BaseFragment.safeNavigate$default(r12, r0, r4, r3, r4)
                                    Lb3:
                                        kotlin.Unit r12 = kotlin.Unit.INSTANCE
                                        return r12
                                    */
                                    throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$onCreateView$1$1$1$2.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
                                }

                                /* compiled from: ClassesDetailFragment.kt */
                                @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                                @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$onCreateView$1$1$1$2$1$1", f = "ClassesDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
                                /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$onCreateView$1$1$1$2$1$1, reason: invalid class name and collision with other inner class name */
                                static final class C02111 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                                    int label;
                                    final /* synthetic */ ClassesDetailFragment this$0;

                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    C02111(ClassesDetailFragment classesDetailFragment, Continuation<? super C02111> continuation) {
                                        super(2, continuation);
                                        this.this$0 = classesDetailFragment;
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                                        return new C02111(this.this$0, continuation);
                                    }

                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                                        return ((C02111) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                                    }

                                    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                                    public final Object invokeSuspend(Object obj) {
                                        IntrinsicsKt.getCOROUTINE_SUSPENDED();
                                        if (this.label != 0) {
                                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                                        }
                                        ResultKt.throwOnFailure(obj);
                                        MainActivity mainActivity = this.this$0.getMainActivity();
                                        if (mainActivity != null) {
                                            WearDataTool.INSTANCE.callWearCommand(WearStatusType.MACHINE_IS_START.getId(), mainActivity);
                                        }
                                        return Unit.INSTANCE;
                                    }
                                }
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2() {
                                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(classesDetailFragment), null, null, new AnonymousClass1(classesDetailFragment, null), 3, null);
                            }
                        }, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$onCreateView$1$1$1$3
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
                                BaseFragment.safeNavigate$default(classesDetailFragment, R.id.heartRateMonitorFragment, null, 2, null);
                            }
                        }, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$onCreateView$1$1$1$4
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
                                BaseFragment.safeNavigate$default(classesDetailFragment, R.id.myDevicesFragment, null, 2, null);
                            }
                        }, new Function1<String, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$onCreateView$1$1$1$5
                            {
                                super(1);
                            }

                            @Override // kotlin.jvm.functions.Function1
                            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                                invoke2(str);
                                return Unit.INSTANCE;
                            }

                            /* renamed from: invoke, reason: avoid collision after fix types in other method */
                            public final void invoke2(String collectionId) {
                                Intrinsics.checkNotNullParameter(collectionId, "collectionId");
                                Log.d("ClassesDetailFragment collectionId", collectionId);
                                Bundle bundle = new Bundle();
                                bundle.putString("collectionId", collectionId);
                                classesDetailFragment.safeNavigate(R.id.collectionDetailFragment, bundle);
                            }
                        }, mainActivity, composer, 150995008, 0);
                    }
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

    public final void ClassesDetailScreen(final String classId, final ClassDetailViewModel viewModel, Function0<Unit> function0, Function0<Unit> function02, Function0<Unit> function03, Function0<Unit> function04, Function1<? super String, Unit> function1, final Context context, Composer composer, final int i, final int i2) {
        Intrinsics.checkNotNullParameter(classId, "classId");
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(context, "context");
        Composer composerStartRestartGroup = composer.startRestartGroup(949967106);
        Function0<Unit> function05 = (i2 & 4) != 0 ? new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.ClassesDetailScreen.1
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : function0;
        Function0<Unit> function06 = (i2 & 8) != 0 ? new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.ClassesDetailScreen.2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : function02;
        Function0<Unit> function07 = (i2 & 16) != 0 ? new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.ClassesDetailScreen.3
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : function03;
        Function0<Unit> function08 = (i2 & 32) != 0 ? new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.ClassesDetailScreen.4
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2() {
            }

            @Override // kotlin.jvm.functions.Function0
            public /* bridge */ /* synthetic */ Unit invoke() {
                invoke2();
                return Unit.INSTANCE;
            }
        } : function04;
        Function1<? super String, Unit> function12 = (i2 & 64) != 0 ? new Function1<String, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.ClassesDetailScreen.5
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }
        } : function1;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(949967106, i, -1, "com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.ClassesDetailScreen (ClassesDetailFragment.kt:180)");
        }
        ProvidableCompositionLocal<LifecycleOwner> localLifecycleOwner = LocalLifecycleOwnerKt.getLocalLifecycleOwner();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composerStartRestartGroup.consume(localLifecycleOwner);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        LifecycleOwner lifecycleOwner = (LifecycleOwner) objConsume;
        final VideoPlayerController videoPlayerController = viewModel.getVideoPlayerController();
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
        context.getString(R.string.music);
        EffectsKt.LaunchedEffect(classId, new AnonymousClass6(viewModel, classId, null), composerStartRestartGroup, (i & 14) | 64);
        EffectsKt.DisposableEffect(lifecycleOwner, new AnonymousClass7(lifecycleOwner, videoPlayerController, viewModel), composerStartRestartGroup, 8);
        final Function0<Unit> function09 = function06;
        ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(745730044, true, new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.ClassesDetailScreen.8
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
                Context context2;
                int i4;
                if ((i3 & 11) == 2 && composer2.getSkipping()) {
                    composer2.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(745730044, i3, -1, "com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.ClassesDetailScreen.<anonymous> (ClassesDetailFragment.kt:221)");
                }
                ClassesDetailFragment classesDetailFragment = ClassesDetailFragment.this;
                ClassesData data = viewModel.getData();
                if (data != null ? Intrinsics.areEqual((Object) data.is_favorite(), (Object) true) : false) {
                    context2 = context;
                    i4 = R.string.save;
                } else {
                    context2 = context;
                    i4 = R.string.to_favorites;
                }
                String string = context2.getString(i4);
                Intrinsics.checkNotNull(string);
                ClassesData data2 = viewModel.getData();
                Integer numValueOf = Integer.valueOf(data2 != null ? Intrinsics.areEqual((Object) data2.is_favorite(), (Object) true) : false ? R.drawable.ic_bookmark_fill_red : R.drawable.ic_m__bookmark);
                final CoroutineScope coroutineScope2 = coroutineScope;
                final ClassDetailViewModel classDetailViewModel = viewModel;
                classesDetailFragment.ConnectBottomView(string, numValueOf, false, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.ClassesDetailScreen.8.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(0);
                    }

                    @Override // kotlin.jvm.functions.Function0
                    public /* bridge */ /* synthetic */ Unit invoke() {
                        invoke2();
                        return Unit.INSTANCE;
                    }

                    /* compiled from: ClassesDetailFragment.kt */
                    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
                    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$ClassesDetailScreen$8$1$1", f = "ClassesDetailFragment.kt", i = {}, l = {WinError.ERROR_PIPE_BUSY, WinError.ERROR_PIPE_NOT_CONNECTED}, m = "invokeSuspend", n = {}, s = {})
                    /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$ClassesDetailScreen$8$1$1, reason: invalid class name and collision with other inner class name */
                    static final class C02101 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
                        final /* synthetic */ ClassDetailViewModel $viewModel;
                        int label;

                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        C02101(ClassDetailViewModel classDetailViewModel, Continuation<? super C02101> continuation) {
                            super(2, continuation);
                            this.$viewModel = classDetailViewModel;
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                            return new C02101(this.$viewModel, continuation);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                            return ((C02101) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
                        }

                        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
                        public final Object invokeSuspend(Object obj) {
                            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                            int i = this.label;
                            if (i == 0) {
                                ResultKt.throwOnFailure(obj);
                                ClassesData data = this.$viewModel.getData();
                                if (data != null) {
                                    ClassDetailViewModel classDetailViewModel = this.$viewModel;
                                    if (Intrinsics.areEqual(data.is_favorite(), Boxing.boxBoolean(true))) {
                                        this.label = 1;
                                        if (classDetailViewModel.apiDeleteFavorite(this) == coroutine_suspended) {
                                            return coroutine_suspended;
                                        }
                                    } else {
                                        this.label = 2;
                                        if (classDetailViewModel.apiPostFavorite(this) == coroutine_suspended) {
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
                        BuildersKt__Builders_commonKt.launch$default(coroutineScope2, null, null, new C02101(classDetailViewModel, null), 3, null);
                    }
                }, function09, composer2, 262144, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }, composerStartRestartGroup, 54);
        final Function0<Unit> function010 = function05;
        final Function1<? super String, Unit> function13 = function12;
        final Function0<Unit> function011 = function08;
        final Function0<Unit> function012 = function07;
        ScaffoldKt.m1944Scaffold27mzLpw(null, null, null, composableLambdaRememberComposableLambda, null, null, 0, false, null, false, null, 0.0f, 0L, 0L, 0L, 0L, 0L, ComposableLambdaKt.rememberComposableLambda(-2031896828, true, new Function3<PaddingValues, Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.ClassesDetailScreen.9
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
                Intrinsics.checkNotNullParameter(innerPadding, "innerPadding");
                if ((i3 & 14) == 0) {
                    i4 = i3 | (composer2.changed(innerPadding) ? 4 : 2);
                } else {
                    i4 = i3;
                }
                if ((i4 & 91) != 18 || !composer2.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-2031896828, i4, -1, "com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.ClassesDetailScreen.<anonymous> (ClassesDetailFragment.kt:241)");
                    }
                    Modifier modifierPadding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), innerPadding);
                    Function0<Unit> function013 = function010;
                    ClassesDetailFragment classesDetailFragment = this;
                    final ClassDetailViewModel classDetailViewModel = viewModel;
                    Function1<String, Unit> function14 = function13;
                    VideoPlayerController videoPlayerController2 = videoPlayerController;
                    Function0<Unit> function014 = function011;
                    Function0<Unit> function015 = function012;
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierPadding);
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
                    Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    ComposerKt.sourceInformationMarkerStart(composer2, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxSize$default);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor2);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM3857constructorimpl2 = Updater.m3857constructorimpl(composer2);
                    Updater.m3864setimpl(composerM3857constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3864setimpl(composerM3857constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM3857constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                        composerM3857constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                        composerM3857constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                    }
                    Updater.m3864setimpl(composerM3857constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -384784025, "C88@4444L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    Modifier modifierM540backgroundbw27NRU$default = BackgroundKt.m540backgroundbw27NRU$default(SizeKt.m1016height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m7255constructorimpl(280)), Color.INSTANCE.m4564getBlack0d7_KjU(), null, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierM540backgroundbw27NRU$default);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM3857constructorimpl3 = Updater.m3857constructorimpl(composer2);
                    Updater.m3864setimpl(composerM3857constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3864setimpl(composerM3857constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM3857constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composerM3857constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM3857constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m3864setimpl(composerM3857constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                    ComposerKt.sourceInformationMarkerStart(composer2, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume2 = composer2.consume(localContext);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ImageRequest.Builder builder = new ImageRequest.Builder((Context) objConsume2);
                    ClassesData data = classDetailViewModel.getData();
                    SingletonAsyncImageKt.m7975AsyncImage3HmZ8SU(builder.data(data != null ? data.getBackground_url() : null).crossfade(true).build(), null, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, composer2, 1573304, 952);
                    VideoPlayerViewKt.VideoPlayerAutoPlay(classDetailViewModel.getCookieData(), videoPlayerController2, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), new Function1<Pair<? extends Long, ? extends Long>, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$ClassesDetailScreen$9$1$1$1$1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Pair<? extends Long, ? extends Long> pair) {
                            invoke2((Pair<Long, Long>) pair);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(Pair<Long, Long> pair) {
                            Intrinsics.checkNotNullParameter(pair, "<name for destructuring parameter 0>");
                            classDetailViewModel.updateVideoProgress(pair.component1().longValue(), pair.component2().longValue());
                        }
                    }, composer2, 456, 0);
                    float f = 8;
                    VideoPlayerViewKt.SubtitleView(classDetailViewModel.getSubtitle(), classDetailViewModel.getShowSubtitles(), PaddingKt.m985padding3ABfNKs(SizeKt.fillMaxWidth$default(boxScopeInstance2.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomCenter()), 0.0f, 1, null), Dp.m7255constructorimpl(f)), composer2, 0, 0);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    classesDetailFragment.ClassDetailView(classDetailViewModel, function14, composer2, 520);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    float f2 = 20;
                    float f3 = 12;
                    ClassesDetailFragmentKt.CircleButton(R.drawable.ic_m__chevron_back, PaddingKt.m985padding3ABfNKs(PaddingKt.m989paddingqDBjuR0$default(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopStart()), 0.0f, Dp.m7255constructorimpl(f2), 0.0f, 0.0f, 13, null), Dp.m7255constructorimpl(f3)), function013, composer2, 0, 0);
                    Modifier modifierM985padding3ABfNKs = PaddingKt.m985padding3ABfNKs(PaddingKt.m989paddingqDBjuR0$default(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopEnd()), 0.0f, Dp.m7255constructorimpl(f2), 0.0f, 0.0f, 13, null), Dp.m7255constructorimpl(f3));
                    Arrangement.HorizontalOrVertical horizontalOrVerticalM865spacedBy0680j_4 = Arrangement.INSTANCE.m865spacedBy0680j_4(Dp.m7255constructorimpl(16));
                    ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM865spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer2, 6);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, modifierM985padding3ABfNKs);
                    Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor4);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM3857constructorimpl4 = Updater.m3857constructorimpl(composer2);
                    Updater.m3864setimpl(composerM3857constructorimpl4, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3864setimpl(composerM3857constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM3857constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                        composerM3857constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                        composerM3857constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
                    }
                    Updater.m3864setimpl(composerM3857constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                    float f4 = 44;
                    Modifier modifierM1030size3ABfNKs = SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(f4));
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap5 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composer2, modifierM1030size3ABfNKs);
                    Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor5);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM3857constructorimpl5 = Updater.m3857constructorimpl(composer2);
                    Updater.m3864setimpl(composerM3857constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3864setimpl(composerM3857constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM3857constructorimpl5.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
                        composerM3857constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
                        composerM3857constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
                    }
                    Updater.m3864setimpl(composerM3857constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    ClassesDetailFragmentKt.CircleButton(R.drawable.ic_machine_treadmill, null, function014, composer2, 0, 2);
                    composer2.startReplaceGroup(-1079090223);
                    if (classDetailViewModel.isConnectingFtms()) {
                        BoxKt.Box(BackgroundKt.m539backgroundbw27NRU(SizeKt.m1030size3ABfNKs(OffsetKt.m945offsetVpY3zN4(boxScopeInstance3.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopEnd()), Dp.m7255constructorimpl(-6), Dp.m7255constructorimpl(6)), Dp.m7255constructorimpl(f)), ColorKt.Color(4278255360L), RoundedCornerShapeKt.getCircleShape()), composer2, 0);
                    }
                    composer2.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    Modifier modifierM1030size3ABfNKs2 = SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(f4));
                    ComposerKt.sourceInformationMarkerStart(composer2, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                    int currentCompositeKeyHash6 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                    CompositionLocalMap currentCompositionLocalMap6 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composer2, modifierM1030size3ABfNKs2);
                    Function0<ComposeUiNode> constructor6 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor6);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM3857constructorimpl6 = Updater.m3857constructorimpl(composer2);
                    Updater.m3864setimpl(composerM3857constructorimpl6, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m3864setimpl(composerM3857constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash6 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM3857constructorimpl6.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl6.rememberedValue(), Integer.valueOf(currentCompositeKeyHash6))) {
                        composerM3857constructorimpl6.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash6));
                        composerM3857constructorimpl6.apply(Integer.valueOf(currentCompositeKeyHash6), setCompositeKeyHash6);
                    }
                    Updater.m3864setimpl(composerM3857constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                    ClassesDetailFragmentKt.CircleButton(R.drawable.ic_m__watch, null, function015, composer2, 0, 2);
                    composer2.startReplaceGroup(-1079089477);
                    if (classDetailViewModel.isConnectingHr()) {
                        BoxKt.Box(BackgroundKt.m539backgroundbw27NRU(SizeKt.m1030size3ABfNKs(OffsetKt.m945offsetVpY3zN4(boxScopeInstance4.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopEnd()), Dp.m7255constructorimpl(-6), Dp.m7255constructorimpl(6)), Dp.m7255constructorimpl(f)), ColorKt.Color(4278255360L), RoundedCornerShapeKt.getCircleShape()), composer2, 0);
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
            final Function0<Unit> function013 = function05;
            final Function0<Unit> function014 = function06;
            final Function0<Unit> function015 = function07;
            final Function0<Unit> function016 = function08;
            final Function1<? super String, Unit> function14 = function12;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.ClassesDetailScreen.10
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
                    ClassesDetailFragment.this.ClassesDetailScreen(classId, viewModel, function013, function014, function015, function016, function14, context, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* compiled from: ClassesDetailFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$ClassesDetailScreen$6", f = "ClassesDetailFragment.kt", i = {}, l = {190, 191, 192}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$ClassesDetailScreen$6, reason: invalid class name */
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $classId;
        final /* synthetic */ ClassDetailViewModel $viewModel;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(ClassDetailViewModel classDetailViewModel, String str, Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
            this.$viewModel = classDetailViewModel;
            this.$classId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass6(this.$viewModel, this.$classId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0058 A[RETURN] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r6) {
            /*
                r5 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r5.label
                r2 = 3
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L25
                if (r1 == r4) goto L21
                if (r1 == r3) goto L1d
                if (r1 != r2) goto L15
                kotlin.ResultKt.throwOnFailure(r6)
                goto L59
            L15:
                java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                r6.<init>(r0)
                throw r6
            L1d:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L4b
            L21:
                kotlin.ResultKt.throwOnFailure(r6)
                goto L3d
            L25:
                kotlin.ResultKt.throwOnFailure(r6)
                com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel r6 = r5.$viewModel
                java.lang.String r1 = r5.$classId
                r6.setClassId(r1)
                com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel r6 = r5.$viewModel
                r1 = r5
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r5.label = r4
                java.lang.Object r6 = r6.apiPostClassClick(r1)
                if (r6 != r0) goto L3d
                return r0
            L3d:
                com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel r6 = r5.$viewModel
                r1 = r5
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r5.label = r3
                java.lang.Object r6 = r6.apiGetClassDetail(r1)
                if (r6 != r0) goto L4b
                return r0
            L4b:
                com.soletreadmills.sole_v2.ui.classes.ClassDetailViewModel r6 = r5.$viewModel
                r1 = r5
                kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                r5.label = r2
                java.lang.Object r6 = r6.apiGetClassVideo(r1)
                if (r6 != r0) goto L59
                return r0
            L59:
                kotlin.Unit r6 = kotlin.Unit.INSTANCE
                return r6
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.AnonymousClass6.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* compiled from: ClassesDetailFragment.kt */
    @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$ClassesDetailScreen$7, reason: invalid class name */
    static final class AnonymousClass7 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
        final /* synthetic */ LifecycleOwner $lifecycleOwner;
        final /* synthetic */ VideoPlayerController $videoPlayerController;
        final /* synthetic */ ClassDetailViewModel $viewModel;

        /* compiled from: ClassesDetailFragment.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$ClassesDetailScreen$7$WhenMappings */
        public /* synthetic */ class WhenMappings {
            public static final /* synthetic */ int[] $EnumSwitchMapping$0;

            static {
                int[] iArr = new int[Lifecycle.Event.values().length];
                try {
                    iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
                } catch (NoSuchFieldError unused) {
                }
                try {
                    iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
                } catch (NoSuchFieldError unused2) {
                }
                try {
                    iArr[Lifecycle.Event.ON_STOP.ordinal()] = 3;
                } catch (NoSuchFieldError unused3) {
                }
                try {
                    iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(LifecycleOwner lifecycleOwner, VideoPlayerController videoPlayerController, ClassDetailViewModel classDetailViewModel) {
            super(1);
            this.$lifecycleOwner = lifecycleOwner;
            this.$videoPlayerController = videoPlayerController;
            this.$viewModel = classDetailViewModel;
        }

        @Override // kotlin.jvm.functions.Function1
        public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
            Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
            final VideoPlayerController videoPlayerController = this.$videoPlayerController;
            final ClassDetailViewModel classDetailViewModel = this.$viewModel;
            final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$ClassesDetailScreen$7$$ExternalSyntheticLambda0
                @Override // androidx.lifecycle.LifecycleEventObserver
                public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                    ClassesDetailFragment.AnonymousClass7.invoke$lambda$0(videoPlayerController, classDetailViewModel, lifecycleOwner, event);
                }
            };
            this.$lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
            final LifecycleOwner lifecycleOwner = this.$lifecycleOwner;
            return new DisposableEffectResult() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$ClassesDetailScreen$7$invoke$$inlined$onDispose$1
                @Override // androidx.compose.runtime.DisposableEffectResult
                public void dispose() {
                    lifecycleOwner.getLifecycle().removeObserver(lifecycleEventObserver);
                }
            };
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$0(VideoPlayerController videoPlayerController, ClassDetailViewModel viewModel, LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
            Intrinsics.checkNotNullParameter(videoPlayerController, "$videoPlayerController");
            Intrinsics.checkNotNullParameter(viewModel, "$viewModel");
            Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
            Intrinsics.checkNotNullParameter(event, "event");
            int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
            if (i == 1 || i == 2) {
                Log.d("ClassesDetailFragment", "ON_START - 恢復播放");
                videoPlayerController.seekTo(viewModel.getLastPosition());
                videoPlayerController.play();
            } else if (i == 3 || i == 4) {
                Log.d("ClassesDetailFragment", "ON_PAUSE - 暫停播放");
                viewModel.setLastPosition(videoPlayerController.getCurrentPosition());
                videoPlayerController.pause();
            }
        }
    }

    public final void CellViewWithUnderline(final String title, final List<ClassCollectionsData> values, final boolean z, final Function1<? super String, Unit> onClick, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(values, "values");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1415385446);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1415385446, i, -1, "com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.CellViewWithUnderline (ClassesDetailFragment.kt:350)");
        }
        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
        composerStartRestartGroup.startReplaceGroup(-1021124308);
        long jColorResource = z ? ColorResources_androidKt.colorResource(R.color.colorBackground_raised, composerStartRestartGroup, 0) : Color.INSTANCE.m4573getTransparent0d7_KjU();
        composerStartRestartGroup.endReplaceGroup();
        Modifier modifierM986paddingVpY3zN4 = PaddingKt.m986paddingVpY3zN4(BackgroundKt.m539backgroundbw27NRU(modifierFillMaxWidth$default, jColorResource, RoundedCornerShapeKt.m1268RoundedCornerShape0680j_4(Dp.m7255constructorimpl(24))), Dp.m7255constructorimpl(16), Dp.m7255constructorimpl(14));
        Alignment.Vertical top = Alignment.INSTANCE.getTop();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), top, composerStartRestartGroup, 48);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM986paddingVpY3zN4);
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
        Updater.m3864setimpl(composerM3857constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3864setimpl(composerM3857constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM3857constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM3857constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM3857constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m3864setimpl(composerM3857constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        String upperCase = title.toUpperCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
        TextKt.m2038Text4IGK_g(upperCase, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), ColorResources_androidKt.colorResource(R.color.colorLabel_label1, composerStartRestartGroup, 0), TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 199680, 0, 131024);
        Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
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
        Updater.m3864setimpl(composerM3857constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3864setimpl(composerM3857constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM3857constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            composerM3857constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            composerM3857constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        Updater.m3864setimpl(composerM3857constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        composerStartRestartGroup.startReplaceGroup(-496355005);
        for (final ClassCollectionsData classCollectionsData : values) {
            String name = classCollectionsData.getName();
            if (name == null) {
                name = SdkConstants.RES_QUALIFIER_SEP;
            }
            String str = name;
            long sp = TextUnitKt.getSp(17);
            FontWeight normal = FontWeight.INSTANCE.getNormal();
            long jColorResource2 = ColorResources_androidKt.colorResource(R.color.colorLabel_accent, composerStartRestartGroup, 0);
            TextDecoration underline = TextDecoration.INSTANCE.getUnderline();
            Modifier.Companion companion = Modifier.INSTANCE;
            composerStartRestartGroup.startReplaceGroup(1996089769);
            boolean zChanged = composerStartRestartGroup.changed(classCollectionsData) | ((((i & 7168) ^ WinPerf.PERF_TYPE_ZERO) > 2048 && composerStartRestartGroup.changed(onClick)) || (i & WinPerf.PERF_TYPE_ZERO) == 2048);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$CellViewWithUnderline$1$1$1$1$1
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
                        Function1<String, Unit> function1 = onClick;
                        String id2 = classCollectionsData.getId();
                        if (id2 == null) {
                            id2 = "";
                        }
                        function1.invoke(id2);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            TextKt.m2038Text4IGK_g(str, PaddingKt.m987paddingVpY3zN4$default(ClickableKt.m573clickableXHw0xAI$default(companion, false, null, null, (Function0) objRememberedValue, 7, null), 0.0f, Dp.m7255constructorimpl(2), 1, null), jColorResource2, sp, (FontStyle) null, normal, (FontFamily) null, 0L, underline, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 100862976, 0, 130768);
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
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.CellViewWithUnderline.2
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

                public final void invoke(Composer composer2, int i2) {
                    ClassesDetailFragment.this.CellViewWithUnderline(title, values, z, onClick, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public final void ConnectBottomView(final String leftText, final Integer num, boolean z, final Function0<Unit> onLeftClick, final Function0<Unit> onRightClick, Composer composer, final int i, final int i2) {
        int i3;
        Intrinsics.checkNotNullParameter(leftText, "leftText");
        Intrinsics.checkNotNullParameter(onLeftClick, "onLeftClick");
        Intrinsics.checkNotNullParameter(onRightClick, "onRightClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-2034716223);
        boolean z2 = (i2 & 4) != 0 ? true : z;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2034716223, i, -1, "com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.ConnectBottomView (ClassesDetailFragment.kt:393)");
        }
        Modifier modifierM540backgroundbw27NRU$default = BackgroundKt.m540backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), ColorResources_androidKt.colorResource(R.color.colorBackground_canvas, composerStartRestartGroup, 0), null, 2, null);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM540backgroundbw27NRU$default);
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
        DividerKt.m1840DivideroMI9zvI(null, ColorResources_androidKt.colorResource(R.color.colorLabel_outline, composerStartRestartGroup, 0), Dp.m7255constructorimpl(1), 0.0f, composerStartRestartGroup, 384, 9);
        Modifier modifierM540backgroundbw27NRU$default2 = BackgroundKt.m540backgroundbw27NRU$default(PaddingKt.m987paddingVpY3zN4$default(SizeKt.m1016height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m7255constructorimpl(80)), Dp.m7255constructorimpl(12), 0.0f, 2, null), ColorResources_androidKt.colorResource(R.color.colorBackground_canvas, composerStartRestartGroup, 0), null, 2, null);
        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM540backgroundbw27NRU$default2);
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
        Updater.m3864setimpl(composerM3857constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3864setimpl(composerM3857constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM3857constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            composerM3857constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            composerM3857constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        Updater.m3864setimpl(composerM3857constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        composerStartRestartGroup.startReplaceGroup(1034716438);
        if (num == null) {
            i3 = 0;
        } else {
            final int iIntValue = num.intValue();
            i3 = 0;
            ButtonKt.TextButton(onLeftClick, null, false, null, null, null, null, ButtonDefaults.INSTANCE.m1773textButtonColorsRGew2ao(Color.INSTANCE.m4573getTransparent0d7_KjU(), ColorResources_androidKt.colorResource(R.color.colorLabel_accent, composerStartRestartGroup, 0), 0L, composerStartRestartGroup, (ButtonDefaults.$stable << 9) | 6, 4), null, ComposableLambdaKt.rememberComposableLambda(441011106, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$ConnectBottomView$1$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num2) {
                    invoke(rowScope, composer2, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope TextButton, Composer composer2, int i4) {
                    Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                    if ((i4 & 81) != 16 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(441011106, i4, -1, "com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.ConnectBottomView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ClassesDetailFragment.kt:418)");
                        }
                        Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                        int i5 = iIntValue;
                        String str = leftText;
                        ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                        Modifier.Companion companion = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composer2, 48);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, companion);
                        Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor3);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM3857constructorimpl3 = Updater.m3857constructorimpl(composer2);
                        Updater.m3864setimpl(composerM3857constructorimpl3, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3864setimpl(composerM3857constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM3857constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                            composerM3857constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                            composerM3857constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                        }
                        Updater.m3864setimpl(composerM3857constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                        IconKt.m1888Iconww6aTOc(PainterResources_androidKt.painterResource(i5, composer2, 0), (String) null, SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(24)), ColorResources_androidKt.colorResource(R.color.colorLabel_accent, composer2, 0), composer2, 440, 0);
                        TextKt.m2038Text4IGK_g(str, PaddingKt.m989paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m7255constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null), ColorResources_androidKt.colorResource(R.color.colorLabel_accent, composer2, 0), TextUnitKt.getSp(17), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 199728, 0, 131024);
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
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i >> 9) & 14) | 805330944, 366);
        }
        composerStartRestartGroup.endReplaceGroup();
        SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, i3);
        composerStartRestartGroup.startReplaceGroup(-1323831845);
        if (z2) {
            ButtonKt.Button(onRightClick, SizeKt.m1016height3ABfNKs(SizeKt.m1035width3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(144)), Dp.m7255constructorimpl(56)), false, null, null, RoundedCornerShapeKt.m1268RoundedCornerShape0680j_4(Dp.m7255constructorimpl(28)), null, ButtonDefaults.INSTANCE.m1764buttonColorsro_MJ88(ColorResources_androidKt.colorResource(R.color.colorLabel_accent, composerStartRestartGroup, i3), 0L, 0L, 0L, composerStartRestartGroup, ButtonDefaults.$stable << 12, 14), null, ComposableLambdaKt.rememberComposableLambda(-1976796634, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment$ConnectBottomView$1$1$2
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num2) {
                    invoke(rowScope, composer2, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope Button, Composer composer2, int i4) {
                    Intrinsics.checkNotNullParameter(Button, "$this$Button");
                    if ((i4 & 81) != 16 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1976796634, i4, -1, "com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.ConnectBottomView.<anonymous>.<anonymous>.<anonymous> (ClassesDetailFragment.kt:449)");
                        }
                        IconKt.m1888Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_m__play_fill, composer2, 0), (String) null, SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(24)), Color.INSTANCE.m4575getWhite0d7_KjU(), composer2, 3512, 0);
                        Context context = this.this$0.getContext();
                        if (context != null) {
                            String string = context.getString(R.string.start);
                            long sp = TextUnitKt.getSp(17);
                            FontWeight semiBold = FontWeight.INSTANCE.getSemiBold();
                            long jM4575getWhite0d7_KjU = Color.INSTANCE.m4575getWhite0d7_KjU();
                            Modifier modifierM989paddingqDBjuR0$default = PaddingKt.m989paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m7255constructorimpl(8), 0.0f, 0.0f, 0.0f, 14, null);
                            Intrinsics.checkNotNull(string);
                            TextKt.m2038Text4IGK_g(string, modifierM989paddingqDBjuR0$default, jM4575getWhite0d7_KjU, sp, (FontStyle) null, semiBold, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 200112, 0, 131024);
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i >> 12) & 14) | 805306416, 348);
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
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z3 = z2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.ConnectBottomView.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num2) {
                    invoke(composer2, num2.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i4) {
                    ClassesDetailFragment.this.ConnectBottomView(leftText, num, z3, onLeftClick, onRightClick, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    public final void ClassDetailView(final ClassDetailViewModel viewModel, final Function1<? super String, Unit> onClickCollection, Composer composer, final int i) {
        String str;
        String str2;
        int i2;
        String str3;
        ClassType classType;
        String title;
        String strLocalized;
        String instructor_name;
        String str4;
        List<ClassCollectionsData> list;
        Composer composer2;
        DifficultyType difficultyStr;
        Object obj;
        Context context;
        String description;
        String class_name;
        String date;
        DurationType durationStr;
        Intrinsics.checkNotNullParameter(viewModel, "viewModel");
        Intrinsics.checkNotNullParameter(onClickCollection, "onClickCollection");
        Composer composerStartRestartGroup = composer.startRestartGroup(-236104651);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-236104651, i, -1, "com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.ClassDetailView (ClassesDetailFragment.kt:475)");
        }
        Modifier modifierM540backgroundbw27NRU$default = BackgroundKt.m540backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), ColorResources_androidKt.colorResource(R.color.colorBackground_canvas, composerStartRestartGroup, 0), null, 2, null);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM540backgroundbw27NRU$default);
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
        Modifier modifierVerticalScroll$default = ScrollKt.verticalScroll$default(ColumnScope.weight$default(ColumnScopeInstance.INSTANCE, Modifier.INSTANCE, 1.0f, false, 2, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierVerticalScroll$default);
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
        Updater.m3864setimpl(composerM3857constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3864setimpl(composerM3857constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM3857constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
            composerM3857constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
            composerM3857constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
        }
        Updater.m3864setimpl(composerM3857constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        Modifier modifierM986paddingVpY3zN4 = PaddingKt.m986paddingVpY3zN4(Modifier.INSTANCE, Dp.m7255constructorimpl(20), Dp.m7255constructorimpl(32));
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM986paddingVpY3zN4);
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
        Updater.m3864setimpl(composerM3857constructorimpl3, measurePolicyColumnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3864setimpl(composerM3857constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM3857constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
            composerM3857constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
            composerM3857constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
        }
        Updater.m3864setimpl(composerM3857constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
        Modifier.Companion companion = Modifier.INSTANCE;
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
        Updater.m3864setimpl(composerM3857constructorimpl4, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3864setimpl(composerM3857constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM3857constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
            composerM3857constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
            composerM3857constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
        }
        Updater.m3864setimpl(composerM3857constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
        RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
        Context context2 = getContext();
        composerStartRestartGroup.startReplaceGroup(-1477891047);
        if (context2 != null) {
            ClassesData data = viewModel.getData();
            String string = context2.getString((data == null || (classType = data.getClassType()) == null) ? R.string.other : classType.getClassCategory());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            String upperCase = string.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            str = "getString(...)";
            str2 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
            i2 = 14;
            str3 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
            TextKt.m2038Text4IGK_g(upperCase, PaddingKt.m989paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m7255constructorimpl(8), 0.0f, 11, null), ColorResources_androidKt.colorResource(R.color.colorLabel_label2, composerStartRestartGroup, 0), TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 199728, 0, 131024);
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        } else {
            str3 = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
            str2 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
            i2 = 14;
            str = "getString(...)";
        }
        composerStartRestartGroup.endReplaceGroup();
        float f = i2;
        float f2 = 1;
        DividerKt.m1840DivideroMI9zvI(SizeKt.m1035width3ABfNKs(SizeKt.m1016height3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(f)), Dp.m7255constructorimpl(f2)), ColorResources_androidKt.colorResource(R.color.colorLabel_outline, composerStartRestartGroup, 0), 0.0f, 0.0f, composerStartRestartGroup, 6, 12);
        StringBuilder sb = new StringBuilder();
        ClassesData data2 = viewModel.getData();
        if (data2 == null || (durationStr = data2.getDurationStr()) == null || (title = durationStr.getTitle()) == null) {
            title = "";
        }
        StringBuilder sbAppend = sb.append(title).append(' ');
        Context context3 = getContext();
        if (context3 != null) {
            Intrinsics.checkNotNull(context3);
            strLocalized = ClassesDetailFragmentKt.localized(context3, HealthConstants.HeartRate.MIN);
        } else {
            strLocalized = null;
        }
        float f3 = 8;
        TextKt.m2038Text4IGK_g(sbAppend.append(strLocalized).toString(), PaddingKt.m989paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m7255constructorimpl(f3), 0.0f, Dp.m7255constructorimpl(f3), 0.0f, 10, null), ColorResources_androidKt.colorResource(R.color.colorLabel_label2, composerStartRestartGroup, 0), TextUnitKt.getSp(i2), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 199728, 0, 131024);
        DividerKt.m1840DivideroMI9zvI(SizeKt.m1035width3ABfNKs(SizeKt.m1016height3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(f)), Dp.m7255constructorimpl(f2)), ColorResources_androidKt.colorResource(R.color.colorLabel_outline, composerStartRestartGroup, 0), 0.0f, 0.0f, composerStartRestartGroup, 6, 12);
        ClassesData data3 = viewModel.getData();
        TextKt.m2038Text4IGK_g((data3 == null || (date = data3.getDate()) == null) ? SdkConstants.RES_QUALIFIER_SEP : date, PaddingKt.m989paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m7255constructorimpl(f3), 0.0f, 0.0f, 0.0f, 14, null), ColorResources_androidKt.colorResource(R.color.colorLabel_label2, composerStartRestartGroup, 0), TextUnitKt.getSp(i2), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 199728, 0, 131024);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        composerStartRestartGroup.endNode();
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ClassesData data4 = viewModel.getData();
        String str5 = (data4 == null || (class_name = data4.getClass_name()) == null) ? SdkConstants.RES_QUALIFIER_SEP : class_name;
        float f4 = 16;
        TextKt.m2038Text4IGK_g(str5, PaddingKt.m989paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m7255constructorimpl(f4), 0.0f, 0.0f, 13, null), ColorResources_androidKt.colorResource(R.color.colorLabel_label1, composerStartRestartGroup, 0), TextUnitKt.getSp(34), (FontStyle) null, FontWeight.INSTANCE.getExtraBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 199728, 0, 131024);
        ClassesData data5 = viewModel.getData();
        TextKt.m2038Text4IGK_g((data5 == null || (description = data5.getDescription()) == null) ? SdkConstants.RES_QUALIFIER_SEP : description, PaddingKt.m989paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m7255constructorimpl(f3), 0.0f, 0.0f, 13, null), ColorResources_androidKt.colorResource(R.color.colorLabel_label1, composerStartRestartGroup, 0), TextUnitKt.getSp(17), (FontStyle) null, FontWeight.INSTANCE.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 199728, 0, 131024);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        composerStartRestartGroup.endNode();
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        Modifier modifierM986paddingVpY3zN42 = PaddingKt.m986paddingVpY3zN4(Modifier.INSTANCE, Dp.m7255constructorimpl(12), Dp.m7255constructorimpl(f4));
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, str2);
        int currentCompositeKeyHash5 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM986paddingVpY3zN42);
        Function0<ComposeUiNode> constructor5 = ComposeUiNode.INSTANCE.getConstructor();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, str3);
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
        Updater.m3864setimpl(composerM3857constructorimpl5, measurePolicyColumnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m3864setimpl(composerM3857constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash5 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM3857constructorimpl5.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl5.rememberedValue(), Integer.valueOf(currentCompositeKeyHash5))) {
            composerM3857constructorimpl5.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash5));
            composerM3857constructorimpl5.apply(Integer.valueOf(currentCompositeKeyHash5), setCompositeKeyHash5);
        }
        Updater.m3864setimpl(composerM3857constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
        Context context4 = getContext();
        composerStartRestartGroup.startReplaceGroup(1588854893);
        if (context4 == null) {
            str4 = str;
            composer2 = composerStartRestartGroup;
            list = null;
        } else {
            String string2 = context4.getString(R.string.instructors);
            Intrinsics.checkNotNullExpressionValue(string2, str);
            ClassesData data6 = viewModel.getData();
            if (data6 == null || (instructor_name = data6.getInstructor_name()) == null) {
                instructor_name = SdkConstants.RES_QUALIFIER_SEP;
            }
            str4 = str;
            list = null;
            composer2 = composerStartRestartGroup;
            CellView(string2, instructor_name, true, composerStartRestartGroup, 4480);
            ClassesData data7 = viewModel.getData();
            if (data7 == null || (difficultyStr = data7.getDifficultyStr()) == null) {
                difficultyStr = DifficultyType.U;
            }
            String string3 = context4.getString(R.string.level);
            Intrinsics.checkNotNullExpressionValue(string3, str4);
            String string4 = context4.getString(difficultyStr.getTitle());
            Intrinsics.checkNotNullExpressionValue(string4, str4);
            CellView(string3, string4, false, composer2, 4480);
            String string5 = context4.getString(R.string.dumbbells);
            Intrinsics.checkNotNullExpressionValue(string5, str4);
            ClassesData data8 = viewModel.getData();
            composer2.startReplaceGroup(1588855567);
            String dumbbells = data8 == null ? null : data8.getDumbbells(composer2, 8);
            composer2.endReplaceGroup();
            CellView(string5, dumbbells == null ? SdkConstants.RES_QUALIFIER_SEP : dumbbells, true, composer2, 4480);
            Unit unit3 = Unit.INSTANCE;
            Unit unit4 = Unit.INSTANCE;
        }
        composer2.endReplaceGroup();
        ClassesData data9 = viewModel.getData();
        List<ClassCollectionsData> collectionData = data9 != null ? data9.getCollectionData() : list;
        composer2.startReplaceGroup(1588855730);
        if (collectionData == null) {
            obj = list;
        } else {
            Context context5 = getContext();
            composer2.startReplaceGroup(1588855784);
            if (context5 == null) {
                obj = list;
            } else {
                String string6 = context5.getString(R.string.collections);
                Intrinsics.checkNotNullExpressionValue(string6, str4);
                CellViewWithUnderline(string6, collectionData, false, onClickCollection, composer2, ((i << 6) & 7168) | 33216);
                Unit unit5 = Unit.INSTANCE;
                obj = Unit.INSTANCE;
            }
            composer2.endReplaceGroup();
        }
        composer2.endReplaceGroup();
        composer2.startReplaceGroup(-434560404);
        if (obj == null && (context = getContext()) != null) {
            String string7 = context.getString(R.string.collections);
            Intrinsics.checkNotNullExpressionValue(string7, str4);
            CellView(string7, SdkConstants.RES_QUALIFIER_SEP, false, composer2, 4528);
            Unit unit6 = Unit.INSTANCE;
            Unit unit7 = Unit.INSTANCE;
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.ClassDetailView.2
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

                public final void invoke(Composer composer3, int i3) {
                    ClassesDetailFragment.this.ClassDetailView(viewModel, onClickCollection, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public final void CellView(final String title, final String value, final boolean z, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(value, "value");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1818675344);
        if ((i & 14) == 0) {
            i2 = (composerStartRestartGroup.changed(title) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 112) == 0) {
            i2 |= composerStartRestartGroup.changed(value) ? 32 : 16;
        }
        if ((i & 896) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        int i3 = i2;
        if ((i3 & WinError.ERROR_WAIT_1) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1818675344, i3, -1, "com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.CellView (ClassesDetailFragment.kt:607)");
            }
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            composerStartRestartGroup.startReplaceGroup(-1858985339);
            long jColorResource = z ? ColorResources_androidKt.colorResource(R.color.colorBackground_raised, composerStartRestartGroup, 0) : Color.INSTANCE.m4573getTransparent0d7_KjU();
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierM986paddingVpY3zN4 = PaddingKt.m986paddingVpY3zN4(BackgroundKt.m539backgroundbw27NRU(modifierFillMaxWidth$default, jColorResource, RoundedCornerShapeKt.m1268RoundedCornerShape0680j_4(Dp.m7255constructorimpl(24))), Dp.m7255constructorimpl(16), Dp.m7255constructorimpl(14));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM986paddingVpY3zN4);
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
            Updater.m3864setimpl(composerM3857constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3864setimpl(composerM3857constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3857constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3857constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3857constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3864setimpl(composerM3857constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            String upperCase = title.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            TextKt.m2038Text4IGK_g(upperCase, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), ColorResources_androidKt.colorResource(R.color.colorLabel_label1, composerStartRestartGroup, 0), TextUnitKt.getSp(14), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 199680, 0, 131024);
            composer2 = composerStartRestartGroup;
            TextKt.m2038Text4IGK_g(value, RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), ColorResources_androidKt.colorResource(R.color.colorLabel_label1, composerStartRestartGroup, 0), TextUnitKt.getSp(17), (FontStyle) null, FontWeight.INSTANCE.getNormal(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, ((i3 >> 3) & 14) | 199680, 0, 131024);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesDetailFragment.CellView.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) {
                    ClassesDetailFragment.this.CellView(title, value, z, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }
}
