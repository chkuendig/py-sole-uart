package com.soletreadmills.sole_v2.ui.classes;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material.IconButtonKt;
import androidx.compose.material.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.focus.FocusChangedModifierKt;
import androidx.compose.ui.focus.FocusState;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.res.ColorResources_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
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
import coil.request.ImageRequest;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.classes.ClassCollectionData;
import com.soletreadmills.sole_v2._data.classes.ClassesData;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui._base.BaseNavViewKt;
import com.soletreadmills.sole_v2.ui._base.EmptyViewBinding;
import com.sun.jna.platform.win32.WinPerf;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.CoroutineScope;

/* compiled from: ClassesSearchFragment.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J)\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u0014H\u0007¢\u0006\u0002\u0010\u0015JW\u0010\u0016\u001a\u00020\u00102\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00100\u00182\u0014\b\u0002\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00100\u00142\u0014\b\u0002\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00100\u0014H\u0007¢\u0006\u0002\u0010\u001cJ)\u0010\u001d\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u001b2\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00100\u0014H\u0007¢\u0006\u0002\u0010\u001eJ\r\u0010\u001f\u001a\u00020\u0010H\u0007¢\u0006\u0002\u0010 J\u0015\u0010!\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\"J\u001a\u0010#\u001a\u00020\u00022\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\b\u0010(\u001a\u00020\u0010H\u0016J\u0012\u0010)\u001a\u00020\u00102\b\u0010*\u001a\u0004\u0018\u00010+H\u0016J$\u0010,\u001a\u00020-2\u0006\u0010$\u001a\u00020%2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010*\u001a\u0004\u0018\u00010+H\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\u001b\u0010\n\u001a\u00020\u000b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\t\u001a\u0004\b\f\u0010\r¨\u0006.²\u0006\u0010\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001200X\u008a\u0084\u0002²\u0006\u0010\u00101\u001a\b\u0012\u0004\u0012\u00020\u001b00X\u008a\u0084\u0002²\u0006\n\u00102\u001a\u000203X\u008a\u0084\u0002²\u0006\n\u00104\u001a\u000205X\u008a\u0084\u0002²\u0006\n\u00106\u001a\u000207X\u008a\u0084\u0002²\u0006\n\u00108\u001a\u000207X\u008a\u0084\u0002²\u0006\n\u00109\u001a\u000207X\u008a\u0084\u0002²\u0006\n\u0010:\u001a\u000207X\u008a\u008e\u0002²\u0006\n\u0010;\u001a\u000205X\u008a\u0084\u0002"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/classes/ClassesSearchFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/EmptyViewBinding;", "()V", "classesViewModel", "Lcom/soletreadmills/sole_v2/ui/classes/ClassesSearchViewModel;", "getClassesViewModel", "()Lcom/soletreadmills/sole_v2/ui/classes/ClassesSearchViewModel;", "classesViewModel$delegate", "Lkotlin/Lazy;", "searchViewModel", "Lcom/soletreadmills/sole_v2/ui/classes/SearchViewModel;", "getSearchViewModel", "()Lcom/soletreadmills/sole_v2/ui/classes/SearchViewModel;", "searchViewModel$delegate", "ClassesSearchDataItem", "", "data", "Lcom/soletreadmills/sole_v2/_data/classes/ClassesData;", SdkConstants.ATTR_ON_CLICK, "Lkotlin/Function1;", "(Lcom/soletreadmills/sole_v2/_data/classes/ClassesData;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ClassesSearchScreen", "onBackClick", "Lkotlin/Function0;", "onClassesClick", "onCollectionClick", "Lcom/soletreadmills/sole_v2/_data/classes/ClassCollectionData;", "(Lcom/soletreadmills/sole_v2/ui/classes/ClassesSearchViewModel;Lcom/soletreadmills/sole_v2/ui/classes/SearchViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "CollectionDataItem", "(Lcom/soletreadmills/sole_v2/_data/classes/ClassCollectionData;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "ReachedEndView", "(Landroidx/compose/runtime/Composer;I)V", SdkConstants.SEARCH_VIEW, "(Lcom/soletreadmills/sole_v2/ui/classes/SearchViewModel;Landroidx/compose/runtime/Composer;I)V", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "app_release", "sessionResults", "", "collectionResults", "totalCount", "", "searchText", "", "isLoading", "", "hasReachedEnd", "hasMoreData", "isEditing", "text"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassesSearchFragment extends BaseFragment<EmptyViewBinding> {
    public static final int $stable = 8;

    /* renamed from: classesViewModel$delegate, reason: from kotlin metadata */
    private final Lazy classesViewModel;

    /* renamed from: searchViewModel$delegate, reason: from kotlin metadata */
    private final Lazy searchViewModel;

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
    }

    public ClassesSearchFragment() {
        final ClassesSearchFragment classesSearchFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return classesSearchFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$special$$inlined$viewModels$default$2
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
        this.classesViewModel = FragmentViewModelLazyKt.createViewModelLazy(classesSearchFragment, Reflection.getOrCreateKotlinClass(ClassesSearchViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m7569viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$special$$inlined$viewModels$default$5
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
                ViewModelProvider.Factory defaultViewModelProviderFactory2 = classesSearchFragment.getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory2, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory2;
            }
        });
        final Function0<Fragment> function03 = new Function0<Fragment>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$special$$inlined$viewModels$default$6
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return classesSearchFragment;
            }
        };
        final Lazy lazy2 = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$special$$inlined$viewModels$default$7
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function03.invoke();
            }
        });
        this.searchViewModel = FragmentViewModelLazyKt.createViewModelLazy(classesSearchFragment, Reflection.getOrCreateKotlinClass(SearchViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$special$$inlined$viewModels$default$8
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m7569viewModels$lambda1(lazy2).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$special$$inlined$viewModels$default$9
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function04 = function02;
                if (function04 != null && (creationExtras = (CreationExtras) function04.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM7569viewModels$lambda1 = FragmentViewModelLazyKt.m7569viewModels$lambda1(lazy2);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM7569viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM7569viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$special$$inlined$viewModels$default$10
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory;
                ViewModelStoreOwner viewModelStoreOwnerM7569viewModels$lambda1 = FragmentViewModelLazyKt.m7569viewModels$lambda1(lazy2);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM7569viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM7569viewModels$lambda1 : null;
                if (hasDefaultViewModelProviderFactory != null && (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) != null) {
                    return defaultViewModelProviderFactory;
                }
                ViewModelProvider.Factory defaultViewModelProviderFactory2 = classesSearchFragment.getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory2, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory2;
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassesSearchViewModel getClassesViewModel() {
        return (ClassesSearchViewModel) this.classesViewModel.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SearchViewModel getSearchViewModel() {
        return (SearchViewModel) this.searchViewModel.getValue();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public EmptyViewBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return new EmptyViewBinding();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        ClassesType classesType;
        String hint;
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        int i = arguments != null ? arguments.getInt("type", 0) : 0;
        ClassesSearchViewModel classesViewModel = getClassesViewModel();
        if (i != 0 && i == 1) {
            classesType = ClassesType.COLLECTION;
        } else {
            classesType = ClassesType.SESSION;
        }
        classesViewModel.setClassesType(classesType);
        SearchViewModel searchViewModel = getSearchViewModel();
        if (i != 0 && i == 1) {
            hint = ClassesType.COLLECTION.getHint();
        } else {
            hint = ClassesType.SESSION.getHint();
        }
        searchViewModel.setHint(hint);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextRequireContext, null, 0, 6, null);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(-307692149, true, new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$onCreateView$1$1
            {
                super(2);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) throws Resources.NotFoundException {
                invoke(composer, num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(Composer composer, int i) throws Resources.NotFoundException {
                if ((i & 11) != 2 || !composer.getSkipping()) {
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-307692149, i, -1, "com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment.onCreateView.<anonymous>.<anonymous> (ClassesSearchFragment.kt:103)");
                    }
                    ClassesSearchFragment classesSearchFragment = this.this$0;
                    ClassesSearchViewModel classesViewModel = classesSearchFragment.getClassesViewModel();
                    SearchViewModel searchViewModel = this.this$0.getSearchViewModel();
                    final ClassesSearchFragment classesSearchFragment2 = this.this$0;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$onCreateView$1$1.1
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
                            classesSearchFragment2.requireActivity().getOnBackPressedDispatcher().onBackPressed();
                        }
                    };
                    final ClassesSearchFragment classesSearchFragment3 = this.this$0;
                    Function1<ClassesData, Unit> function1 = new Function1<ClassesData, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$onCreateView$1$1.2
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
                            classesSearchFragment3.safeNavigate(R.id.classesDetailFragment, bundle);
                        }
                    };
                    final ClassesSearchFragment classesSearchFragment4 = this.this$0;
                    classesSearchFragment.ClassesSearchScreen(classesViewModel, searchViewModel, function0, function1, new Function1<ClassCollectionData, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$onCreateView$1$1.3
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(ClassCollectionData classCollectionData) {
                            invoke2(classCollectionData);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(ClassCollectionData data) {
                            Intrinsics.checkNotNullParameter(data, "data");
                            Bundle bundle = new Bundle();
                            bundle.putString("collectionId", data.getCollection_id());
                            classesSearchFragment4.safeNavigate(R.id.collectionDetailFragment, bundle);
                        }
                    }, composer, 262216, 0);
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

    public final void ClassesSearchScreen(final ClassesSearchViewModel classesViewModel, final SearchViewModel searchViewModel, final Function0<Unit> onBackClick, Function1<? super ClassesData, Unit> function1, Function1<? super ClassCollectionData, Unit> function12, Composer composer, final int i, final int i2) throws Resources.NotFoundException {
        Context context;
        int i3;
        String string;
        Composer composer2;
        Intrinsics.checkNotNullParameter(classesViewModel, "classesViewModel");
        Intrinsics.checkNotNullParameter(searchViewModel, "searchViewModel");
        Intrinsics.checkNotNullParameter(onBackClick, "onBackClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(131429501);
        Function1<? super ClassesData, Unit> function13 = (i2 & 8) != 0 ? new Function1<ClassesData, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment.ClassesSearchScreen.1
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
        Function1<? super ClassCollectionData, Unit> function14 = (i2 & 16) != 0 ? new Function1<ClassCollectionData, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment.ClassesSearchScreen.2
            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ClassCollectionData it) {
                Intrinsics.checkNotNullParameter(it, "it");
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ClassCollectionData classCollectionData) {
                invoke2(classCollectionData);
                return Unit.INSTANCE;
            }
        } : function12;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(131429501, i, -1, "com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment.ClassesSearchScreen (ClassesSearchFragment.kt:133)");
        }
        State stateCollectAsState = SnapshotStateKt.collectAsState(classesViewModel.getOutput().getSessionResults(), null, composerStartRestartGroup, 8, 1);
        State stateCollectAsState2 = SnapshotStateKt.collectAsState(classesViewModel.getOutput().getCollectionsResults(), null, composerStartRestartGroup, 8, 1);
        final State stateCollectAsState3 = SnapshotStateKt.collectAsState(classesViewModel.getOutput().getTotalCount(), null, composerStartRestartGroup, 8, 1);
        State stateCollectAsState4 = SnapshotStateKt.collectAsState(searchViewModel.getText(), null, composerStartRestartGroup, 8, 1);
        final State stateCollectAsState5 = SnapshotStateKt.collectAsState(classesViewModel.getOutput().isLoading(), null, composerStartRestartGroup, 8, 1);
        final State stateCollectAsState6 = SnapshotStateKt.collectAsState(classesViewModel.getOutput().getHasReachedEnd(), null, composerStartRestartGroup, 8, 1);
        composerStartRestartGroup.startReplaceGroup(1137883654);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0<Boolean>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$ClassesSearchScreen$hasMoreData$2$1
                {
                    super(0);
                }

                /* JADX WARN: Can't rename method to resolve collision */
                @Override // kotlin.jvm.functions.Function0
                public final Boolean invoke() {
                    return Boolean.valueOf(classesViewModel.getHasMoreData());
                }
            });
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        final State state = (State) objRememberedValue;
        composerStartRestartGroup.endReplaceGroup();
        EffectsKt.LaunchedEffect(ClassesSearchScreen$lambda$4(stateCollectAsState4), new C08793(classesViewModel, stateCollectAsState4, null), composerStartRestartGroup, 64);
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
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        if (classesViewModel.getClassesType() == ClassesType.SESSION) {
            context = getContext();
            if (context != null) {
                i3 = R.string.search_classes;
                string = context.getString(i3);
            }
            string = null;
        } else {
            context = getContext();
            if (context != null) {
                i3 = R.string.search_collections;
                string = context.getString(i3);
            }
            string = null;
        }
        composerStartRestartGroup.startReplaceGroup(663010486);
        if (string != null) {
            BaseNavViewKt.BaseNavView(null, string, Integer.valueOf(R.drawable.ic_m__xmark), null, null, null, false, onBackClick, null, composerStartRestartGroup, ((i << 15) & 29360128) | 1572864, 313);
        }
        composerStartRestartGroup.endReplaceGroup();
        SearchView(searchViewModel, composerStartRestartGroup, 72);
        final List listClassesSearchScreen$lambda$1 = classesViewModel.getClassesType() == ClassesType.SESSION ? ClassesSearchScreen$lambda$1(stateCollectAsState) : ClassesSearchScreen$lambda$2(stateCollectAsState2);
        if (ClassesSearchScreen$lambda$4(stateCollectAsState4).length() > 0 && listClassesSearchScreen$lambda$1.isEmpty() && !ClassesSearchScreen$lambda$5(stateCollectAsState5)) {
            composerStartRestartGroup.startReplaceGroup(663011066);
            Modifier modifierWeight$default = ColumnScope.weight$default(columnScopeInstance, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
            Alignment topStart = Alignment.INSTANCE.getTopStart();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topStart, false);
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
            ClassesSearchFragmentKt.SearchEmpty(composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endReplaceGroup();
            composer2 = composerStartRestartGroup;
        } else {
            composerStartRestartGroup.startReplaceGroup(663011383);
            final Function1<? super ClassesData, Unit> function15 = function13;
            final Function1<? super ClassCollectionData, Unit> function16 = function14;
            composer2 = composerStartRestartGroup;
            LazyDslKt.LazyColumn(ColumnScope.weight$default(columnScopeInstance, SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null), null, null, false, null, null, null, false, new Function1<LazyListScope, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$ClassesSearchScreen$4$3
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
                    Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
                    if (!listClassesSearchScreen$lambda$1.isEmpty()) {
                        final ClassesSearchViewModel classesSearchViewModel = classesViewModel;
                        final ClassesSearchFragment classesSearchFragment = this;
                        final State<Integer> state2 = stateCollectAsState3;
                        LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(-62959866, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$ClassesSearchScreen$4$3.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(3);
                            }

                            @Override // kotlin.jvm.functions.Function3
                            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer3, Integer num) {
                                invoke(lazyItemScope, composer3, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(LazyItemScope item, Composer composer3, int i4) {
                                String string2;
                                Intrinsics.checkNotNullParameter(item, "$this$item");
                                if ((i4 & 81) != 16 || !composer3.getSkipping()) {
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(-62959866, i4, -1, "com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment.ClassesSearchScreen.<anonymous>.<anonymous>.<anonymous> (ClassesSearchFragment.kt:187)");
                                    }
                                    if (classesSearchViewModel.getClassesType() == ClassesType.SESSION) {
                                        StringBuilder sbAppend = new StringBuilder().append(ClassesSearchFragment.ClassesSearchScreen$lambda$3(state2)).append(' ');
                                        Context context2 = classesSearchFragment.getContext();
                                        string2 = sbAppend.append(context2 != null ? context2.getString(R.string.classes) : null).toString();
                                    } else {
                                        StringBuilder sbAppend2 = new StringBuilder().append(ClassesSearchFragment.ClassesSearchScreen$lambda$3(state2)).append(' ');
                                        Context context3 = classesSearchFragment.getContext();
                                        string2 = sbAppend2.append(context3 != null ? context3.getString(R.string.collections) : null).toString();
                                    }
                                    float f = 20;
                                    TextKt.m2975Text4IGK_g(string2, PaddingKt.m989paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m7255constructorimpl(f), Dp.m7255constructorimpl(f), 0.0f, Dp.m7255constructorimpl(8), 4, null), ColorResources_androidKt.colorResource(R.color.colorLabel_label1, composer3, 0), TextUnitKt.getSp(21), (FontStyle) null, FontWeight.INSTANCE.getExtraBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer3, 199728, 0, 131024);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                        return;
                                    }
                                    return;
                                }
                                composer3.skipToGroupEnd();
                            }
                        }), 3, null);
                    }
                    final List<Object> list = listClassesSearchScreen$lambda$1;
                    final ClassesSearchFragment classesSearchFragment2 = this;
                    final Function1<ClassesData, Unit> function17 = function15;
                    final Function1<ClassCollectionData, Unit> function18 = function16;
                    final State<Boolean> state3 = state;
                    final State<Boolean> state4 = stateCollectAsState5;
                    final ClassesSearchViewModel classesSearchViewModel2 = classesViewModel;
                    LazyColumn.items(list.size(), null, new Function1<Integer, Object>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$ClassesSearchScreen$4$3$invoke$$inlined$itemsIndexed$default$2
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                            return invoke(num.intValue());
                        }

                        public final Object invoke(int i4) {
                            list.get(i4);
                            return null;
                        }
                    }, ComposableLambdaKt.composableLambdaInstance(-1091073711, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$ClassesSearchScreen$4$3$invoke$$inlined$itemsIndexed$default$3
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        {
                            super(4);
                        }

                        @Override // kotlin.jvm.functions.Function4
                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer3, Integer num2) {
                            invoke(lazyItemScope, num.intValue(), composer3, num2.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(LazyItemScope lazyItemScope, int i4, Composer composer3, int i5) {
                            int i6;
                            ComposerKt.sourceInformation(composer3, "C188@8866L26:LazyDsl.kt#428nma");
                            if ((i5 & 6) == 0) {
                                i6 = (composer3.changed(lazyItemScope) ? 4 : 2) | i5;
                            } else {
                                i6 = i5;
                            }
                            if ((i5 & 48) == 0) {
                                i6 |= composer3.changed(i4) ? 32 : 16;
                            }
                            if ((i6 & 147) == 146 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1091073711, i6, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:188)");
                            }
                            Object obj = list.get(i4);
                            int i7 = i6 & 126;
                            composer3.startReplaceGroup(-1599059534);
                            if (obj instanceof ClassesData) {
                                composer3.startReplaceGroup(-1599059474);
                                ClassesSearchFragment classesSearchFragment3 = classesSearchFragment2;
                                ClassesData classesData = (ClassesData) obj;
                                composer3.startReplaceGroup(-1599059364);
                                boolean zChanged = composer3.changed(function17);
                                Object objRememberedValue2 = composer3.rememberedValue();
                                if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    final Function1 function19 = function17;
                                    objRememberedValue2 = (Function1) new Function1<ClassesData, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$ClassesSearchScreen$4$3$2$1$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(ClassesData classesData2) {
                                            invoke2(classesData2);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(ClassesData it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            function19.invoke(it);
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue2);
                                }
                                composer3.endReplaceGroup();
                                classesSearchFragment3.ClassesSearchDataItem(classesData, (Function1) objRememberedValue2, composer3, 520);
                                composer3.endReplaceGroup();
                            } else if (obj instanceof ClassCollectionData) {
                                composer3.startReplaceGroup(-1599059256);
                                ClassesSearchFragment classesSearchFragment4 = classesSearchFragment2;
                                ClassCollectionData classCollectionData = (ClassCollectionData) obj;
                                composer3.startReplaceGroup(-1599059149);
                                boolean zChanged2 = composer3.changed(function18);
                                Object objRememberedValue3 = composer3.rememberedValue();
                                if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    final Function1 function110 = function18;
                                    objRememberedValue3 = (Function1) new Function1<ClassCollectionData, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$ClassesSearchScreen$4$3$2$2$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        /* JADX WARN: Multi-variable type inference failed */
                                        {
                                            super(1);
                                        }

                                        @Override // kotlin.jvm.functions.Function1
                                        public /* bridge */ /* synthetic */ Unit invoke(ClassCollectionData classCollectionData2) {
                                            invoke2(classCollectionData2);
                                            return Unit.INSTANCE;
                                        }

                                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                                        public final void invoke2(ClassCollectionData it) {
                                            Intrinsics.checkNotNullParameter(it, "it");
                                            function110.invoke(it);
                                        }
                                    };
                                    composer3.updateRememberedValue(objRememberedValue3);
                                }
                                composer3.endReplaceGroup();
                                classesSearchFragment4.CollectionDataItem(classCollectionData, (Function1) objRememberedValue3, composer3, 520);
                                composer3.endReplaceGroup();
                            } else {
                                composer3.startReplaceGroup(-1599059068);
                                composer3.endReplaceGroup();
                            }
                            if (i4 >= Math.max(0, list.size() - 5) && ClassesSearchFragment.ClassesSearchScreen$lambda$8(state3) && !ClassesSearchFragment.ClassesSearchScreen$lambda$5(state4)) {
                                EffectsKt.LaunchedEffect(Integer.valueOf(i4), new ClassesSearchFragment$ClassesSearchScreen$4$3$2$3(classesSearchViewModel2, null), composer3, ((i7 >> 3) & 14) | 64);
                            }
                            composer3.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }));
                    if (ClassesSearchFragment.ClassesSearchScreen$lambda$5(stateCollectAsState5)) {
                        LazyListScope.item$default(LazyColumn, null, null, ComposableSingletons$ClassesSearchFragmentKt.INSTANCE.m8655getLambda1$app_release(), 3, null);
                    }
                    if (!ClassesSearchFragment.ClassesSearchScreen$lambda$6(stateCollectAsState6) || listClassesSearchScreen$lambda$1.isEmpty()) {
                        return;
                    }
                    final ClassesSearchFragment classesSearchFragment3 = this;
                    LazyListScope.item$default(LazyColumn, null, null, ComposableLambdaKt.composableLambdaInstance(914373502, true, new Function3<LazyItemScope, Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$ClassesSearchScreen$4$3.3
                        {
                            super(3);
                        }

                        @Override // kotlin.jvm.functions.Function3
                        public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Composer composer3, Integer num) {
                            invoke(lazyItemScope, composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(LazyItemScope item, Composer composer3, int i4) {
                            Intrinsics.checkNotNullParameter(item, "$this$item");
                            if ((i4 & 81) == 16 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(914373502, i4, -1, "com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment.ClassesSearchScreen.<anonymous>.<anonymous>.<anonymous> (ClassesSearchFragment.kt:246)");
                            }
                            classesSearchFragment3.ReachedEndView(composer3, 8);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }), 3, null);
                }
            }, composer2, 0, 254);
            composer2.endReplaceGroup();
        }
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
            final Function1<? super ClassesData, Unit> function17 = function13;
            final Function1<? super ClassCollectionData, Unit> function18 = function14;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment.ClassesSearchScreen.5
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) throws Resources.NotFoundException {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i4) throws Resources.NotFoundException {
                    ClassesSearchFragment.this.ClassesSearchScreen(classesViewModel, searchViewModel, onBackClick, function17, function18, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* compiled from: ClassesSearchFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$ClassesSearchScreen$3", f = "ClassesSearchFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$ClassesSearchScreen$3, reason: invalid class name and case insensitive filesystem */
    static final class C08793 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ClassesSearchViewModel $classesViewModel;
        final /* synthetic */ State<String> $searchText$delegate;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08793(ClassesSearchViewModel classesSearchViewModel, State<String> state, Continuation<? super C08793> continuation) {
            super(2, continuation);
            this.$classesViewModel = classesSearchViewModel;
            this.$searchText$delegate = state;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08793(this.$classesViewModel, this.$searchText$delegate, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08793) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                this.$classesViewModel.getInput().setSearchText(ClassesSearchFragment.ClassesSearchScreen$lambda$4(this.$searchText$delegate));
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    public final void ClassesSearchDataItem(final ClassesData data, final Function1<? super ClassesData, Unit> onClick, Composer composer, final int i) {
        Composer composer2;
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1879013613);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1879013613, i, -1, "com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment.ClassesSearchDataItem (ClassesSearchFragment.kt:258)");
        }
        Modifier modifierM985padding3ABfNKs = PaddingKt.m985padding3ABfNKs(ClickableKt.m573clickableXHw0xAI$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, null, null, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment.ClassesSearchDataItem.1
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
                onClick.invoke(data);
            }
        }, 7, null), Dp.m7255constructorimpl(12));
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM985padding3ABfNKs);
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
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composerStartRestartGroup.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        SingletonAsyncImageKt.m7975AsyncImage3HmZ8SU(new ImageRequest.Builder((Context) objConsume).data(data.getBackground_url()).crossfade(true).build(), null, ClipKt.clip(SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(96)), RoundedCornerShapeKt.m1268RoundedCornerShape0680j_4(Dp.m7255constructorimpl(24))), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, composerStartRestartGroup, 1572920, 952);
        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m989paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m7255constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 1, null);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
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
        String class_name = data.getClass_name();
        if (class_name == null) {
            class_name = SdkConstants.RES_QUALIFIER_SEP;
        }
        TextKt.m2975Text4IGK_g(class_name, (Modifier) null, ColorResources_androidKt.colorResource(R.color.colorLabel_label1, composerStartRestartGroup, 0), TextUnitKt.getSp(17), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 199680, 0, 131026);
        Context context = getContext();
        composerStartRestartGroup.startReplaceGroup(-850467837);
        if (context == null) {
            composer2 = composerStartRestartGroup;
        } else {
            String string = context.getString(data.getClassType().getClassCategory());
            long sp = TextUnitKt.getSp(15);
            long jColorResource = ColorResources_androidKt.colorResource(R.color.colorLabel_label2, composerStartRestartGroup, 0);
            Intrinsics.checkNotNull(string);
            composer2 = composerStartRestartGroup;
            TextKt.m2975Text4IGK_g(string, (Modifier) null, jColorResource, sp, (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, WinPerf.PERF_TYPE_ZERO, 0, 131058);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment.ClassesSearchDataItem.3
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

                public final void invoke(Composer composer3, int i2) {
                    ClassesSearchFragment.this.ClassesSearchDataItem(data, onClick, composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public final void CollectionDataItem(final ClassCollectionData data, final Function1<? super ClassCollectionData, Unit> onClick, Composer composer, final int i) {
        Intrinsics.checkNotNullParameter(data, "data");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-93775817);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-93775817, i, -1, "com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment.CollectionDataItem (ClassesSearchFragment.kt:303)");
        }
        Modifier modifierM985padding3ABfNKs = PaddingKt.m985padding3ABfNKs(ClickableKt.m573clickableXHw0xAI$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), false, null, null, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment.CollectionDataItem.1
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
                onClick.invoke(data);
            }
        }, 7, null), Dp.m7255constructorimpl(12));
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getTop(), composerStartRestartGroup, 0);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM985padding3ABfNKs);
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
        ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composerStartRestartGroup.consume(localContext);
        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
        SingletonAsyncImageKt.m7975AsyncImage3HmZ8SU(new ImageRequest.Builder((Context) objConsume).data(data.getBackground_url()).crossfade(true).build(), null, ClipKt.clip(SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(96)), RoundedCornerShapeKt.m1268RoundedCornerShape0680j_4(Dp.m7255constructorimpl(24))), null, null, null, ContentScale.INSTANCE.getCrop(), 0.0f, null, 0, composerStartRestartGroup, 1572920, 952);
        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m989paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m7255constructorimpl(16), 0.0f, 0.0f, 0.0f, 14, null), 0.0f, 1, null);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
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
        String collection_name = data.getCollection_name();
        if (collection_name == null) {
            collection_name = SdkConstants.RES_QUALIFIER_SEP;
        }
        TextKt.m2975Text4IGK_g(collection_name, (Modifier) null, ColorResources_androidKt.colorResource(R.color.colorLabel_label1, composerStartRestartGroup, 0), TextUnitKt.getSp(17), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 199680, 0, 131026);
        StringBuilder sb = new StringBuilder();
        Integer workout_amount = data.getWorkout_amount();
        TextKt.m2975Text4IGK_g(sb.append(workout_amount != null ? workout_amount.intValue() : 0).append(" classes").toString(), (Modifier) null, ColorResources_androidKt.colorResource(R.color.colorLabel_label2, composerStartRestartGroup, 0), TextUnitKt.getSp(15), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, WinPerf.PERF_TYPE_ZERO, 0, 131058);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment.CollectionDataItem.3
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
                    ClassesSearchFragment.this.CollectionDataItem(data, onClick, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    public final void SearchView(final SearchViewModel searchViewModel, Composer composer, final int i) {
        Composer composer2;
        Context context;
        Intrinsics.checkNotNullParameter(searchViewModel, "searchViewModel");
        Composer composerStartRestartGroup = composer.startRestartGroup(2130625686);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2130625686, i, -1, "com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment.SearchView (ClassesSearchFragment.kt:343)");
        }
        composerStartRestartGroup.startReplaceGroup(317632709);
        Object objRememberedValue = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
        }
        final MutableState mutableState = (MutableState) objRememberedValue;
        composerStartRestartGroup.endReplaceGroup();
        float f = 44;
        float fM7255constructorimpl = Dp.m7255constructorimpl(f);
        State stateCollectAsState = SnapshotStateKt.collectAsState(searchViewModel.getText(), null, composerStartRestartGroup, 8, 1);
        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
        float f2 = 12;
        float f3 = 8;
        float f4 = fM7255constructorimpl / 2;
        Modifier modifierM987paddingVpY3zN4$default = PaddingKt.m987paddingVpY3zN4$default(BorderKt.m551borderxT4_qwU(BackgroundKt.m539backgroundbw27NRU(SizeKt.fillMaxWidth$default(SizeKt.m1016height3ABfNKs(PaddingKt.m988paddingqDBjuR0(Modifier.INSTANCE, Dp.m7255constructorimpl(f2), Dp.m7255constructorimpl(f3), Dp.m7255constructorimpl(f2), Dp.m7255constructorimpl(f2)), fM7255constructorimpl), 0.0f, 1, null), ColorResources_androidKt.colorResource(R.color.colorBackground_canvas, composerStartRestartGroup, 0), RoundedCornerShapeKt.m1268RoundedCornerShape0680j_4(Dp.m7255constructorimpl(f4))), Dp.m7255constructorimpl(1), ColorResources_androidKt.colorResource(R.color.colorLabel_outline, composerStartRestartGroup, 0), RoundedCornerShapeKt.m1268RoundedCornerShape0680j_4(Dp.m7255constructorimpl(f4))), Dp.m7255constructorimpl(10), 0.0f, 2, null);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
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
        IconKt.m1888Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_s__search, composerStartRestartGroup, 0), "Search Icon", SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(16)), ColorResources_androidKt.colorResource(R.color.colorLabel_label3, composerStartRestartGroup, 0), composerStartRestartGroup, 440, 0);
        SpacerKt.Spacer(SizeKt.m1035width3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(f3)), composerStartRestartGroup, 6);
        Modifier modifierFillMaxHeight$default = SizeKt.fillMaxHeight$default(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), 0.0f, 1, null);
        Alignment centerStart = Alignment.INSTANCE.getCenterStart();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(centerStart, false);
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxHeight$default);
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
        String strSearchView$lambda$20 = SearchView$lambda$20(stateCollectAsState);
        TextStyle textStyle = new TextStyle(ColorResources_androidKt.colorResource(R.color.colorLabel_label1, composerStartRestartGroup, 0), TextUnitKt.getSp(17), (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, TextUnitKt.getSp(44), (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16646140, (DefaultConstructorMarker) null);
        Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
        composerStartRestartGroup.startReplaceGroup(1449089709);
        Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = (Function1) new Function1<FocusState, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$SearchView$1$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(1);
                }

                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(FocusState focusState) {
                    invoke2(focusState);
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(FocusState focusState) {
                    Intrinsics.checkNotNullParameter(focusState, "focusState");
                    ClassesSearchFragment.SearchView$lambda$19(mutableState, focusState.isFocused());
                }
            };
            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
        }
        composerStartRestartGroup.endReplaceGroup();
        BasicTextFieldKt.BasicTextField(strSearchView$lambda$20, (Function1<? super String, Unit>) new Function1<String, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$SearchView$1$1$2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(String str) {
                invoke2(str);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(String it) {
                Intrinsics.checkNotNullParameter(it, "it");
                searchViewModel.updateText(it);
            }
        }, FocusChangedModifierKt.onFocusChanged(modifierFillMaxWidth$default, (Function1) objRememberedValue2), false, false, textStyle, (KeyboardOptions) null, (KeyboardActions) null, true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, (MutableInteractionSource) null, (Brush) null, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) null, composerStartRestartGroup, 100663296, 0, 65240);
        composerStartRestartGroup.startReplaceGroup(1959370338);
        if (SearchView$lambda$20(stateCollectAsState).length() != 0 || (context = getContext()) == null) {
            composer2 = composerStartRestartGroup;
        } else {
            Intrinsics.checkNotNull(context);
            composer2 = composerStartRestartGroup;
            TextKt.m2975Text4IGK_g(ClassesDetailFragmentKt.localized(context, searchViewModel.getHint()), (Modifier) null, ColorResources_androidKt.colorResource(R.color.colorLabel_label3, composerStartRestartGroup, 0), TextUnitKt.getSp(17), (FontStyle) null, (FontWeight) null, (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, WinPerf.PERF_TYPE_ZERO, 0, 131058);
            Unit unit = Unit.INSTANCE;
            Unit unit2 = Unit.INSTANCE;
        }
        composer2.endReplaceGroup();
        ComposerKt.sourceInformationMarkerEnd(composer2);
        composer2.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        ComposerKt.sourceInformationMarkerEnd(composer2);
        Composer composer3 = composer2;
        composer3.startReplaceGroup(317635004);
        if (SearchView$lambda$18(mutableState) || SearchView$lambda$20(stateCollectAsState).length() > 0) {
            IconButtonKt.IconButton(new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment$SearchView$1$2
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
                    searchViewModel.updateText("");
                }
            }, SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(f)), false, null, ComposableSingletons$ClassesSearchFragmentKt.INSTANCE.m8656getLambda2$app_release(), composer3, 24624, 12);
        }
        composer3.endReplaceGroup();
        ComposerKt.sourceInformationMarkerEnd(composer3);
        composer3.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer3);
        ComposerKt.sourceInformationMarkerEnd(composer3);
        ComposerKt.sourceInformationMarkerEnd(composer3);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer3.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment.SearchView.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                    invoke(composer4, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer4, int i2) {
                    ClassesSearchFragment.this.SearchView(searchViewModel, composer4, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final boolean SearchView$lambda$18(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void SearchView$lambda$19(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    public final void ReachedEndView(Composer composer, final int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1424579271);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1424579271, i, -1, "com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment.ReachedEndView (ClassesSearchFragment.kt:422)");
        }
        Modifier modifierM987paddingVpY3zN4$default = PaddingKt.m987paddingVpY3zN4$default(BackgroundKt.m540backgroundbw27NRU$default(SizeKt.m1016height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m7255constructorimpl(44)), ColorResources_androidKt.colorResource(R.color.colorBackground_raised, composerStartRestartGroup, 0), null, 2, null), Dp.m7255constructorimpl(16), 0.0f, 2, null);
        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
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
        ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.ic_m__checkmark_fill_circle, composerStartRestartGroup, 0), "Reached End", SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(24)), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.m4579tintxETnrds$default(ColorFilter.INSTANCE, ColorResources_androidKt.colorResource(R.color.colorLabel_accent, composerStartRestartGroup, 0), 0, 2, null), composerStartRestartGroup, 440, 56);
        SpacerKt.Spacer(SizeKt.m1035width3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(8)), composerStartRestartGroup, 6);
        Context context = getContext();
        composerStartRestartGroup.startReplaceGroup(1259997317);
        if (context == null) {
            composer2 = composerStartRestartGroup;
        } else {
            Intrinsics.checkNotNull(context);
            composer2 = composerStartRestartGroup;
            TextKt.m2975Text4IGK_g(ClassesDetailFragmentKt.localized(context, "you_have_reached_the_end"), (Modifier) null, ColorResources_androidKt.colorResource(R.color.colorLabel_label1, composerStartRestartGroup, 0), TextUnitKt.getSp(17), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 199680, 0, 131026);
        }
        composer2.endReplaceGroup();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesSearchFragment.ReachedEndView.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                    invoke(composer3, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer3, int i2) {
                    ClassesSearchFragment.this.ReachedEndView(composer3, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                }
            });
        }
    }

    private static final List<ClassesData> ClassesSearchScreen$lambda$1(State<? extends List<ClassesData>> state) {
        return state.getValue();
    }

    private static final List<ClassCollectionData> ClassesSearchScreen$lambda$2(State<? extends List<ClassCollectionData>> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ClassesSearchScreen$lambda$3(State<Integer> state) {
        return state.getValue().intValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String ClassesSearchScreen$lambda$4(State<String> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ClassesSearchScreen$lambda$5(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ClassesSearchScreen$lambda$6(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean ClassesSearchScreen$lambda$8(State<Boolean> state) {
        return state.getValue().booleanValue();
    }

    private static final String SearchView$lambda$20(State<String> state) {
        return state.getValue();
    }
}
