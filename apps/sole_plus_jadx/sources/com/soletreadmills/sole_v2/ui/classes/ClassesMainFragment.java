package com.soletreadmills.sole_v2.ui.classes;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.ConcatAdapter;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.classes.ClassInstructorsDataBase;
import com.soletreadmills.sole_v2._data.api.classes.CollectionInstructorsData;
import com.soletreadmills.sole_v2._data.api.classes.SessionInstructorsData;
import com.soletreadmills.sole_v2._data.classes.ActivityDataBase;
import com.soletreadmills.sole_v2._data.classes.ClassCollectionData;
import com.soletreadmills.sole_v2._data.classes.ClassesCategoryData;
import com.soletreadmills.sole_v2._data.classes.ClassesData;
import com.soletreadmills.sole_v2._data.classes.ClassesFilterTagViewType;
import com.soletreadmills.sole_v2._data.classes.CollectionActivityData;
import com.soletreadmills.sole_v2._data.classes.DurationData;
import com.soletreadmills.sole_v2._data.classes.FitnessLevelData;
import com.soletreadmills.sole_v2._data.classes.FocusData;
import com.soletreadmills.sole_v2._data.classes.QuickPicksData;
import com.soletreadmills.sole_v2._data.classes.ResultsInfo;
import com.soletreadmills.sole_v2._data.classes.SessionActivityData;
import com.soletreadmills.sole_v2._manager.ChangeViewManager;
import com.soletreadmills.sole_v2._type.ActivityType;
import com.soletreadmills.sole_v2._type.ClassesCategoryType;
import com.soletreadmills.sole_v2._type.DurationType;
import com.soletreadmills.sole_v2._type.FitnessLevelType;
import com.soletreadmills.sole_v2._type.FocusType;
import com.soletreadmills.sole_v2.databinding.FragmentClassesMainBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.adapter.classes.ClassesCategoryAdapter;
import com.soletreadmills.sole_v2.ui.adapter.classes.ClassesCollectionsAdapter;
import com.soletreadmills.sole_v2.ui.adapter.classes.ClassesEndAdapter;
import com.soletreadmills.sole_v2.ui.adapter.classes.ClassesQuickPicksAdapter;
import com.soletreadmills.sole_v2.ui.adapter.classes.ClassesResultsAdapter;
import com.soletreadmills.sole_v2.ui.adapter.classes.ClassesSessionsAdapter;
import com.soletreadmills.sole_v2.ui.adapter.classes.WorkoutsEmptyAdapter;
import com.soletreadmills.sole_v2.ui.customview.SelectActivityCustom;
import com.soletreadmills.sole_v2.ui.customview.SelectDurationCustom;
import com.soletreadmills.sole_v2.ui.customview.SelectFitnessLevelCustom;
import com.soletreadmills.sole_v2.ui.customview.SelectFocusCustom;
import com.soletreadmills.sole_v2.ui.customview.SelectInstructorsCustom;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import timber.log.Timber;

/* compiled from: ClassesMainFragment.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0012H\u0002J\u001a\u0010%\u001a\u00020\u00022\u0006\u0010&\u001a\u00020'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0016J\b\u0010*\u001a\u00020#H\u0016J\b\u0010+\u001a\u00020#H\u0002J\b\u0010,\u001a\u00020#H\u0002J\u0012\u0010-\u001a\u00020#2\b\u0010.\u001a\u0004\u0018\u00010/H\u0016J\u0012\u00100\u001a\u00020#2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\u001a\u00103\u001a\u00020#2\u0006\u00104\u001a\u00020/2\b\u00101\u001a\u0004\u0018\u000102H\u0016J\b\u00105\u001a\u00020#H\u0002J\u0016\u00106\u001a\u00020#2\f\u00107\u001a\b\u0012\u0004\u0012\u00020908H\u0002J\b\u0010:\u001a\u00020#H\u0002J\b\u0010;\u001a\u00020#H\u0002J\b\u0010<\u001a\u00020#H\u0002J\b\u0010=\u001a\u00020#H\u0002J\b\u0010>\u001a\u00020#H\u0002J\b\u0010?\u001a\u00020#H\u0002J\b\u0010@\u001a\u00020#H\u0002J\b\u0010A\u001a\u00020#H\u0002J\b\u0010B\u001a\u00020#H\u0002J$\u0010C\u001a\u00020#2\f\u0010D\u001a\b\u0012\u0004\u0012\u000209082\f\u0010E\u001a\b\u0012\u0004\u0012\u00020908H\u0002J\b\u0010F\u001a\u00020#H\u0002J\b\u0010G\u001a\u00020#H\u0002J\b\u0010H\u001a\u00020#H\u0002J\b\u0010I\u001a\u00020#H\u0002J\b\u0010J\u001a\u00020#H\u0002J\u0016\u0010K\u001a\u00020#2\u0006\u0010L\u001a\u00020M2\u0006\u0010N\u001a\u00020OJ\b\u0010P\u001a\u00020#H\u0002J\b\u0010Q\u001a\u00020#H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u00020\fX\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u000e\"\u0004\b\u001b\u0010\u0010R\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f¨\u0006R"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/classes/ClassesMainFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentClassesMainBinding;", "Landroid/view/View$OnClickListener;", "()V", "collectionResultsAdapter", "Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesResultsAdapter;", "collectionsAdapter", "Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesCollectionsAdapter;", "collectionsEmptyAdapter", "Lcom/soletreadmills/sole_v2/ui/adapter/classes/WorkoutsEmptyAdapter;", "collectionsQuickPicksAdapter", "Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesQuickPicksAdapter;", "getCollectionsQuickPicksAdapter", "()Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesQuickPicksAdapter;", "setCollectionsQuickPicksAdapter", "(Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesQuickPicksAdapter;)V", "currentCollapseMode", "", "endAdapter", "Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesEndAdapter;", "sessionResultsAdapter", "sessionsAdapter", "Lcom/soletreadmills/sole_v2/ui/adapter/classes/ClassesSessionsAdapter;", "sessionsEmptyAdapter", "sessionsQuickPicksAdapter", "getSessionsQuickPicksAdapter", "setSessionsQuickPicksAdapter", "viewModel", "Lcom/soletreadmills/sole_v2/ui/classes/ClassesMainViewModel;", "getViewModel", "()Lcom/soletreadmills/sole_v2/ui/classes/ClassesMainViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "changeCollapseMode", "", "collapseMode", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "initializeCollectionsAdapters", "initializeSessionsAdapters", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "reSetCategoryRecyclerView", "resetQuickPicksFor", "rawValues", "", "", "resetQuickPicksForActivity", "resetQuickPicksForDuration", "resetQuickPicksForFitnessLevel", "resetQuickPicksForFocus", "resetQuickPicksForInstructors", "setCategoryRecyclerView", "setConcatAdapter", "setupCollectionsRecyclerView", "setupSessionsRecyclerView", "syncQuickPicksFor", "selectedRawValues", "allRawValues", "syncQuickPicksForActivity", "syncQuickPicksForDuration", "syncQuickPicksForFitnessLevel", "syncQuickPicksForFocus", "syncQuickPicksForInstructors", "toggleSelection", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/classes/QuickPicksData;", "isSelected", "", "updateCategoryList", "updateTabSelection", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClassesMainFragment extends BaseFragment<FragmentClassesMainBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private ClassesResultsAdapter collectionResultsAdapter;
    private ClassesCollectionsAdapter collectionsAdapter;
    private WorkoutsEmptyAdapter collectionsEmptyAdapter;
    public ClassesQuickPicksAdapter collectionsQuickPicksAdapter;
    private int currentCollapseMode;
    private ClassesEndAdapter endAdapter;
    private ClassesResultsAdapter sessionResultsAdapter;
    private ClassesSessionsAdapter sessionsAdapter;
    private WorkoutsEmptyAdapter sessionsEmptyAdapter;
    public ClassesQuickPicksAdapter sessionsQuickPicksAdapter;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: ClassesMainFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[ClassesCategoryType.values().length];
            try {
                iArr[ClassesCategoryType.FAVORITE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ClassesCategoryType.ACTIVITY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ClassesCategoryType.DURATION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ClassesCategoryType.INSTRUCTORS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[ClassesCategoryType.LEVEL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[ClassesCategoryType.FOCUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ClassesFilterTagViewType.values().length];
            try {
                iArr2[ClassesFilterTagViewType.Activity.ordinal()] = 1;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[ClassesFilterTagViewType.Duration.ordinal()] = 2;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[ClassesFilterTagViewType.Instructors.ordinal()] = 3;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[ClassesFilterTagViewType.Level.ordinal()] = 4;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[ClassesFilterTagViewType.Focus.ordinal()] = 5;
            } catch (NoSuchFieldError unused11) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    public ClassesMainFragment() {
        final ClassesMainFragment classesMainFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return classesMainFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$special$$inlined$viewModels$default$2
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
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(classesMainFragment, Reflection.getOrCreateKotlinClass(ClassesMainViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m7569viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$special$$inlined$viewModels$default$4
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
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$special$$inlined$viewModels$default$5
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
                ViewModelProvider.Factory defaultViewModelProviderFactory2 = classesMainFragment.getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory2, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory2;
            }
        });
        this.currentCollapseMode = 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final ClassesMainViewModel getViewModel() {
        return (ClassesMainViewModel) this.viewModel.getValue();
    }

    public final ClassesQuickPicksAdapter getSessionsQuickPicksAdapter() {
        ClassesQuickPicksAdapter classesQuickPicksAdapter = this.sessionsQuickPicksAdapter;
        if (classesQuickPicksAdapter != null) {
            return classesQuickPicksAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("sessionsQuickPicksAdapter");
        return null;
    }

    public final void setSessionsQuickPicksAdapter(ClassesQuickPicksAdapter classesQuickPicksAdapter) {
        Intrinsics.checkNotNullParameter(classesQuickPicksAdapter, "<set-?>");
        this.sessionsQuickPicksAdapter = classesQuickPicksAdapter;
    }

    public final ClassesQuickPicksAdapter getCollectionsQuickPicksAdapter() {
        ClassesQuickPicksAdapter classesQuickPicksAdapter = this.collectionsQuickPicksAdapter;
        if (classesQuickPicksAdapter != null) {
            return classesQuickPicksAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("collectionsQuickPicksAdapter");
        return null;
    }

    public final void setCollectionsQuickPicksAdapter(ClassesQuickPicksAdapter classesQuickPicksAdapter) {
        Intrinsics.checkNotNullParameter(classesQuickPicksAdapter, "<set-?>");
        this.collectionsQuickPicksAdapter = classesQuickPicksAdapter;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentClassesMainBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentClassesMainBinding fragmentClassesMainBindingInflate = FragmentClassesMainBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentClassesMainBindingInflate, "inflate(...)");
        return fragmentClassesMainBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getViewModel().getSessionList().observe(getViewLifecycleOwner(), new ClassesMainFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends ClassesData>, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment.onViewCreated.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ClassesData> list) {
                invoke2((List<ClassesData>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ClassesData> list) {
                ClassesSessionsAdapter classesSessionsAdapter = ClassesMainFragment.this.sessionsAdapter;
                if (classesSessionsAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sessionsAdapter");
                    classesSessionsAdapter = null;
                }
                classesSessionsAdapter.submitList(list);
                ClassesMainFragment.this.updateTabSelection();
            }
        }));
        getViewModel().getCollectionList().observe(getViewLifecycleOwner(), new ClassesMainFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends ClassCollectionData>, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment.onViewCreated.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends ClassCollectionData> list) {
                invoke2((List<ClassCollectionData>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<ClassCollectionData> list) {
                ClassesCollectionsAdapter classesCollectionsAdapter = ClassesMainFragment.this.collectionsAdapter;
                if (classesCollectionsAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("collectionsAdapter");
                    classesCollectionsAdapter = null;
                }
                classesCollectionsAdapter.submitList(list);
                ClassesMainFragment.this.updateTabSelection();
            }
        }));
        getViewModel().getSessionsQuickPicks().observe(getViewLifecycleOwner(), new ClassesMainFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends QuickPicksData>, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment.onViewCreated.3
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends QuickPicksData> list) {
                invoke2((List<QuickPicksData>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<QuickPicksData> list) {
                ClassesMainFragment.this.getSessionsQuickPicksAdapter().submitList(list);
            }
        }));
        getViewModel().getCollectionsQuickPicks().observe(getViewLifecycleOwner(), new ClassesMainFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<? extends QuickPicksData>, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment.onViewCreated.4
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<? extends QuickPicksData> list) {
                invoke2((List<QuickPicksData>) list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<QuickPicksData> list) {
                ClassesMainFragment.this.getCollectionsQuickPicksAdapter().submitList(list);
            }
        }));
        getViewModel().getSessionFilterResult().observe(getViewLifecycleOwner(), new ClassesMainFragment$sam$androidx_lifecycle_Observer$0(new Function1<ResultsInfo, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment.onViewCreated.5
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ResultsInfo resultsInfo) {
                invoke2(resultsInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ResultsInfo resultsInfo) {
                ClassesResultsAdapter classesResultsAdapter = ClassesMainFragment.this.sessionResultsAdapter;
                if (classesResultsAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sessionResultsAdapter");
                    classesResultsAdapter = null;
                }
                classesResultsAdapter.submitList(CollectionsKt.listOf(resultsInfo));
            }
        }));
        getViewModel().getCollectionFilterResult().observe(getViewLifecycleOwner(), new ClassesMainFragment$sam$androidx_lifecycle_Observer$0(new Function1<ResultsInfo, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment.onViewCreated.6
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(ResultsInfo resultsInfo) {
                invoke2(resultsInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(ResultsInfo resultsInfo) {
                ClassesResultsAdapter classesResultsAdapter = ClassesMainFragment.this.collectionResultsAdapter;
                if (classesResultsAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("collectionResultsAdapter");
                    classesResultsAdapter = null;
                }
                classesResultsAdapter.submitList(CollectionsKt.listOf(resultsInfo));
            }
        }));
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        ImageView imageView;
        AppBarLayout appBarLayout;
        FragmentClassesMainBinding binding = getBinding();
        if (binding != null && (appBarLayout = binding.appBarLayout) != null) {
            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$$ExternalSyntheticLambda0
                @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
                public final void onOffsetChanged(AppBarLayout appBarLayout2, int i) {
                    ClassesMainFragment.initViews$lambda$0(this.f$0, appBarLayout2, i);
                }
            });
        }
        FragmentClassesMainBinding binding2 = getBinding();
        if (binding2 != null && (imageView = binding2.imgSearch) != null) {
            imageView.setOnClickListener(this);
        }
        FragmentClassesMainBinding binding3 = getBinding();
        if (binding3 != null && (linearLayout2 = binding3.LLAll) != null) {
            linearLayout2.setOnClickListener(this);
        }
        FragmentClassesMainBinding binding4 = getBinding();
        if (binding4 != null && (linearLayout = binding4.LLCollections) != null) {
            linearLayout.setOnClickListener(this);
        }
        getViewModel().getCallGetClassInstructors();
        setCategoryRecyclerView();
        setConcatAdapter();
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("openPageName") : null;
        Timber.INSTANCE.d("openPageName:" + string, new Object[0]);
        if (Intrinsics.areEqual(string, "Collections")) {
            getViewModel().setSessionsSelected(false);
            updateTabSelection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$0(ClassesMainFragment this$0, AppBarLayout appBarLayout, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        float fAbs = Math.abs(i) / appBarLayout.getTotalScrollRange();
        FragmentClassesMainBinding binding = this$0.getBinding();
        TextView textView = binding != null ? binding.title : null;
        if (textView != null) {
            textView.setVisibility(fAbs >= 0.85f ? 0 : 8);
        }
        int i2 = fAbs >= 0.85f ? 1 : 2;
        if (this$0.currentCollapseMode != i2) {
            this$0.changeCollapseMode(i2);
            this$0.currentCollapseMode = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.img_search;
        if (numValueOf != null && numValueOf.intValue() == i) {
            Bundle bundle = new Bundle();
            bundle.putInt("type", !getViewModel().getIsSessionsSelected() ? 1 : 0);
            safeNavigate(R.id.classesSearchFragment, bundle);
            return;
        }
        int i2 = R.id.LL_All;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            if (getViewModel().getIsSessionsSelected()) {
                return;
            }
            getViewModel().setSessionsSelected(true);
            updateTabSelection();
            return;
        }
        int i3 = R.id.LL_collections;
        if (numValueOf != null && numValueOf.intValue() == i3 && getViewModel().getIsSessionsSelected()) {
            getViewModel().setSessionsSelected(false);
            updateTabSelection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateTabSelection() {
        ConcatAdapter concatAdapter;
        RecyclerView recyclerView;
        TextView textView;
        TextView textView2;
        ConcatAdapter concatAdapter2;
        TextView textView3;
        TextView textView4;
        if (getViewModel().getIsSessionsSelected()) {
            FragmentClassesMainBinding binding = getBinding();
            View view = binding != null ? binding.sessionsLine : null;
            if (view != null) {
                view.setVisibility(0);
            }
            FragmentClassesMainBinding binding2 = getBinding();
            View view2 = binding2 != null ? binding2.collectionsLine : null;
            if (view2 != null) {
                view2.setVisibility(4);
            }
            FragmentClassesMainBinding binding3 = getBinding();
            if (binding3 != null && (textView4 = binding3.sessions) != null) {
                textView4.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorLabel_label2));
            }
            FragmentClassesMainBinding binding4 = getBinding();
            if (binding4 != null && (textView3 = binding4.collections) != null) {
                textView3.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorLabel_label3));
            }
            FragmentClassesMainBinding binding5 = getBinding();
            LinearLayout linearLayout = binding5 != null ? binding5.LLSessionsView : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            FragmentClassesMainBinding binding6 = getBinding();
            LinearLayout linearLayout2 = binding6 != null ? binding6.LLCollectionsView : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            int sessionFilterount = getViewModel().getSessionFilterount();
            ResultsInfo value = getViewModel().getSessionFilterResult().getValue();
            int resultCount = value != null ? value.getResultCount() : 0;
            if (sessionFilterount == 0) {
                RecyclerView.Adapter[] adapterArr = new RecyclerView.Adapter[3];
                adapterArr[0] = getSessionsQuickPicksAdapter();
                ClassesSessionsAdapter classesSessionsAdapter = this.sessionsAdapter;
                if (classesSessionsAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sessionsAdapter");
                    classesSessionsAdapter = null;
                }
                adapterArr[1] = classesSessionsAdapter;
                ClassesEndAdapter classesEndAdapter = this.endAdapter;
                if (classesEndAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("endAdapter");
                    classesEndAdapter = null;
                }
                adapterArr[2] = classesEndAdapter;
                concatAdapter2 = new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr);
            } else if (resultCount != 0) {
                RecyclerView.Adapter[] adapterArr2 = new RecyclerView.Adapter[4];
                adapterArr2[0] = getSessionsQuickPicksAdapter();
                ClassesResultsAdapter classesResultsAdapter = this.sessionResultsAdapter;
                if (classesResultsAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sessionResultsAdapter");
                    classesResultsAdapter = null;
                }
                adapterArr2[1] = classesResultsAdapter;
                ClassesSessionsAdapter classesSessionsAdapter2 = this.sessionsAdapter;
                if (classesSessionsAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sessionsAdapter");
                    classesSessionsAdapter2 = null;
                }
                adapterArr2[2] = classesSessionsAdapter2;
                ClassesEndAdapter classesEndAdapter2 = this.endAdapter;
                if (classesEndAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("endAdapter");
                    classesEndAdapter2 = null;
                }
                adapterArr2[3] = classesEndAdapter2;
                concatAdapter2 = new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr2);
            } else {
                RecyclerView.Adapter[] adapterArr3 = new RecyclerView.Adapter[1];
                WorkoutsEmptyAdapter workoutsEmptyAdapter = this.sessionsEmptyAdapter;
                if (workoutsEmptyAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("sessionsEmptyAdapter");
                    workoutsEmptyAdapter = null;
                }
                adapterArr3[0] = workoutsEmptyAdapter;
                concatAdapter2 = new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr3);
            }
            FragmentClassesMainBinding binding7 = getBinding();
            recyclerView = binding7 != null ? binding7.recyclerview : null;
            if (recyclerView != null) {
                recyclerView.setAdapter(concatAdapter2);
            }
        } else {
            FragmentClassesMainBinding binding8 = getBinding();
            View view3 = binding8 != null ? binding8.sessionsLine : null;
            if (view3 != null) {
                view3.setVisibility(4);
            }
            FragmentClassesMainBinding binding9 = getBinding();
            View view4 = binding9 != null ? binding9.collectionsLine : null;
            if (view4 != null) {
                view4.setVisibility(0);
            }
            FragmentClassesMainBinding binding10 = getBinding();
            if (binding10 != null && (textView2 = binding10.collections) != null) {
                textView2.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorLabel_label2));
            }
            FragmentClassesMainBinding binding11 = getBinding();
            if (binding11 != null && (textView = binding11.sessions) != null) {
                textView.setTextColor(ContextCompat.getColor(requireContext(), R.color.colorLabel_label3));
            }
            FragmentClassesMainBinding binding12 = getBinding();
            LinearLayout linearLayout3 = binding12 != null ? binding12.LLSessionsView : null;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(8);
            }
            FragmentClassesMainBinding binding13 = getBinding();
            LinearLayout linearLayout4 = binding13 != null ? binding13.LLCollectionsView : null;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(0);
            }
            int collectionFilterount = getViewModel().getCollectionFilterount();
            ResultsInfo value2 = getViewModel().getCollectionFilterResult().getValue();
            int resultCount2 = value2 != null ? value2.getResultCount() : 0;
            if (collectionFilterount == 0) {
                RecyclerView.Adapter[] adapterArr4 = new RecyclerView.Adapter[3];
                adapterArr4[0] = getCollectionsQuickPicksAdapter();
                ClassesCollectionsAdapter classesCollectionsAdapter = this.collectionsAdapter;
                if (classesCollectionsAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("collectionsAdapter");
                    classesCollectionsAdapter = null;
                }
                adapterArr4[1] = classesCollectionsAdapter;
                ClassesEndAdapter classesEndAdapter3 = this.endAdapter;
                if (classesEndAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("endAdapter");
                    classesEndAdapter3 = null;
                }
                adapterArr4[2] = classesEndAdapter3;
                concatAdapter = new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr4);
            } else if (resultCount2 != 0) {
                RecyclerView.Adapter[] adapterArr5 = new RecyclerView.Adapter[4];
                adapterArr5[0] = getCollectionsQuickPicksAdapter();
                ClassesResultsAdapter classesResultsAdapter2 = this.collectionResultsAdapter;
                if (classesResultsAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("collectionResultsAdapter");
                    classesResultsAdapter2 = null;
                }
                adapterArr5[1] = classesResultsAdapter2;
                ClassesCollectionsAdapter classesCollectionsAdapter2 = this.collectionsAdapter;
                if (classesCollectionsAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("collectionsAdapter");
                    classesCollectionsAdapter2 = null;
                }
                adapterArr5[2] = classesCollectionsAdapter2;
                ClassesEndAdapter classesEndAdapter4 = this.endAdapter;
                if (classesEndAdapter4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("endAdapter");
                    classesEndAdapter4 = null;
                }
                adapterArr5[3] = classesEndAdapter4;
                concatAdapter = new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr5);
            } else {
                RecyclerView.Adapter[] adapterArr6 = new RecyclerView.Adapter[1];
                WorkoutsEmptyAdapter workoutsEmptyAdapter2 = this.collectionsEmptyAdapter;
                if (workoutsEmptyAdapter2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("collectionsEmptyAdapter");
                    workoutsEmptyAdapter2 = null;
                }
                adapterArr6[0] = workoutsEmptyAdapter2;
                concatAdapter = new ConcatAdapter((RecyclerView.Adapter<? extends RecyclerView.ViewHolder>[]) adapterArr6);
            }
            FragmentClassesMainBinding binding14 = getBinding();
            recyclerView = binding14 != null ? binding14.recyclerviewCollections : null;
            if (recyclerView != null) {
                recyclerView.setAdapter(concatAdapter);
            }
        }
        setCategoryRecyclerView();
    }

    private final void changeCollapseMode(int collapseMode) {
        Toolbar toolbar;
        FragmentClassesMainBinding binding = getBinding();
        ViewGroup.LayoutParams layoutParams = (binding == null || (toolbar = binding.collapsingToolbar) == null) ? null : toolbar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams");
        CollapsingToolbarLayout.LayoutParams layoutParams2 = (CollapsingToolbarLayout.LayoutParams) layoutParams;
        layoutParams2.setCollapseMode(collapseMode);
        FragmentClassesMainBinding binding2 = getBinding();
        Toolbar toolbar2 = binding2 != null ? binding2.collapsingToolbar : null;
        if (toolbar2 == null) {
            return;
        }
        toolbar2.setLayoutParams(layoutParams2);
    }

    private final void setCategoryRecyclerView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        FragmentClassesMainBinding binding = getBinding();
        if (!(((binding == null || (recyclerView2 = binding.recyclerviewCategory) == null) ? null : recyclerView2.getLayoutManager()) instanceof LinearLayoutManager)) {
            FragmentClassesMainBinding binding2 = getBinding();
            RecyclerView recyclerView3 = binding2 != null ? binding2.recyclerviewCategory : null;
            if (recyclerView3 != null) {
                recyclerView3.setLayoutManager(new LinearLayoutManager(getContext(), 0, false));
            }
        }
        FragmentClassesMainBinding binding3 = getBinding();
        if (!(((binding3 == null || (recyclerView = binding3.recyclerviewCategory) == null) ? null : recyclerView.getAdapter()) instanceof ClassesCategoryAdapter)) {
            ClassesCategoryAdapter classesCategoryAdapter = new ClassesCategoryAdapter(new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$setCategoryRecyclerView$adapter$1
                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos) {
                }

                /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos, String string) {
                    ChangeViewManager changeViewManager;
                    ChangeViewManager changeViewManager2;
                    MainActivity mainActivity;
                    ChangeViewManager changeViewManager3;
                    ChangeViewManager changeViewManager4;
                    ChangeViewManager changeViewManager5;
                    MainActivity mainActivity2;
                    ChangeViewManager changeViewManager6;
                    MainActivity mainActivity3;
                    ChangeViewManager changeViewManager7;
                    Intrinsics.checkNotNullParameter(string, "string");
                    MainActivity mainActivity4 = this.this$0.getMainActivity();
                    switch (string.hashCode()) {
                        case -1840474282:
                            if (string.equals("INSTRUCTORS") && mainActivity4 != null) {
                                if (!this.this$0.getViewModel().getIsSessionsSelected()) {
                                    MainActivity mainActivity5 = this.this$0.getMainActivity();
                                    if (mainActivity5 != null && (changeViewManager = mainActivity5.getChangeViewManager()) != null) {
                                        List<CollectionInstructorsData> collectionInstructorsList = this.this$0.getViewModel().getCollectionInstructorsList();
                                        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(collectionInstructorsList, 10));
                                        Iterator<T> it = collectionInstructorsList.iterator();
                                        while (it.hasNext()) {
                                            arrayList.add((CollectionInstructorsData) it.next());
                                        }
                                        List mutableList = CollectionsKt.toMutableList((Collection) arrayList);
                                        final ClassesMainFragment classesMainFragment = this.this$0;
                                        changeViewManager.changePage(new SelectInstructorsCustom(mainActivity4, mutableList, new SelectInstructorsCustom.SelectDurationCustomListener() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$setCategoryRecyclerView$adapter$1$onClick$9
                                            @Override // com.soletreadmills.sole_v2.ui.customview.SelectInstructorsCustom.SelectDurationCustomListener
                                            public void onClick(List<ClassInstructorsDataBase> list) {
                                                Intrinsics.checkNotNullParameter(list, "list");
                                                ClassesMainViewModel viewModel = classesMainFragment.getViewModel();
                                                List<ClassInstructorsDataBase> list2 = list;
                                                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                                                for (ClassInstructorsDataBase classInstructorsDataBase : list2) {
                                                    Intrinsics.checkNotNull(classInstructorsDataBase, "null cannot be cast to non-null type com.soletreadmills.sole_v2._data.api.classes.CollectionInstructorsData");
                                                    arrayList2.add((CollectionInstructorsData) classInstructorsDataBase);
                                                }
                                                viewModel.setCollectionInstructorsList(CollectionsKt.toMutableList((Collection) arrayList2));
                                                classesMainFragment.syncQuickPicksForInstructors();
                                                classesMainFragment.reSetCategoryRecyclerView();
                                            }

                                            @Override // com.soletreadmills.sole_v2.ui.customview.SelectInstructorsCustom.SelectDurationCustomListener
                                            public void onReset() {
                                                Iterator<T> it2 = classesMainFragment.getViewModel().getCollectionInstructorsList().iterator();
                                                while (it2.hasNext()) {
                                                    ((CollectionInstructorsData) it2.next()).setSelect(false);
                                                }
                                                classesMainFragment.resetQuickPicksForInstructors();
                                                classesMainFragment.reSetCategoryRecyclerView();
                                            }
                                        }));
                                        break;
                                    }
                                } else {
                                    MainActivity mainActivity6 = this.this$0.getMainActivity();
                                    if (mainActivity6 != null && (changeViewManager2 = mainActivity6.getChangeViewManager()) != null) {
                                        List<SessionInstructorsData> sessionInstructorsList = this.this$0.getViewModel().getSessionInstructorsList();
                                        ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(sessionInstructorsList, 10));
                                        Iterator<T> it2 = sessionInstructorsList.iterator();
                                        while (it2.hasNext()) {
                                            arrayList2.add((SessionInstructorsData) it2.next());
                                        }
                                        List mutableList2 = CollectionsKt.toMutableList((Collection) arrayList2);
                                        final ClassesMainFragment classesMainFragment2 = this.this$0;
                                        changeViewManager2.changePage(new SelectInstructorsCustom(mainActivity4, mutableList2, new SelectInstructorsCustom.SelectDurationCustomListener() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$setCategoryRecyclerView$adapter$1$onClick$7
                                            @Override // com.soletreadmills.sole_v2.ui.customview.SelectInstructorsCustom.SelectDurationCustomListener
                                            public void onClick(List<ClassInstructorsDataBase> list) {
                                                Intrinsics.checkNotNullParameter(list, "list");
                                                ClassesMainViewModel viewModel = classesMainFragment2.getViewModel();
                                                List<ClassInstructorsDataBase> list2 = list;
                                                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
                                                for (ClassInstructorsDataBase classInstructorsDataBase : list2) {
                                                    Intrinsics.checkNotNull(classInstructorsDataBase, "null cannot be cast to non-null type com.soletreadmills.sole_v2._data.api.classes.SessionInstructorsData");
                                                    arrayList3.add((SessionInstructorsData) classInstructorsDataBase);
                                                }
                                                viewModel.setSessionInstructorsList(CollectionsKt.toMutableList((Collection) arrayList3));
                                                classesMainFragment2.syncQuickPicksForInstructors();
                                                classesMainFragment2.reSetCategoryRecyclerView();
                                            }

                                            @Override // com.soletreadmills.sole_v2.ui.customview.SelectInstructorsCustom.SelectDurationCustomListener
                                            public void onReset() {
                                                Iterator<T> it3 = classesMainFragment2.getViewModel().getSessionInstructorsList().iterator();
                                                while (it3.hasNext()) {
                                                    ((SessionInstructorsData) it3.next()).setSelect(false);
                                                }
                                                classesMainFragment2.resetQuickPicksForInstructors();
                                                classesMainFragment2.reSetCategoryRecyclerView();
                                            }
                                        }));
                                        break;
                                    }
                                }
                            }
                            break;
                        case -1209385580:
                            if (string.equals("DURATION") && this.this$0.getViewModel().getIsSessionsSelected() && mainActivity4 != null && (mainActivity = this.this$0.getMainActivity()) != null && (changeViewManager3 = mainActivity.getChangeViewManager()) != null) {
                                List<DurationData> durationDataList = this.this$0.getViewModel().getDurationDataList();
                                final ClassesMainFragment classesMainFragment3 = this.this$0;
                                changeViewManager3.changePage(new SelectDurationCustom(mainActivity4, durationDataList, new SelectDurationCustom.SelectDurationCustomListener() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$setCategoryRecyclerView$adapter$1$onClick$5
                                    @Override // com.soletreadmills.sole_v2.ui.customview.SelectDurationCustom.SelectDurationCustomListener
                                    public void onClick(List<DurationData> durationDataList2) {
                                        Intrinsics.checkNotNullParameter(durationDataList2, "durationDataList");
                                        classesMainFragment3.getViewModel().setDurationDataList(durationDataList2);
                                        classesMainFragment3.syncQuickPicksForDuration();
                                        classesMainFragment3.reSetCategoryRecyclerView();
                                    }

                                    @Override // com.soletreadmills.sole_v2.ui.customview.SelectDurationCustom.SelectDurationCustomListener
                                    public void onReset() {
                                        classesMainFragment3.resetQuickPicksForDuration();
                                        classesMainFragment3.reSetCategoryRecyclerView();
                                    }
                                }));
                                break;
                            }
                            break;
                        case -873340145:
                            if (string.equals("ACTIVITY") && mainActivity4 != null) {
                                if (!this.this$0.getViewModel().getIsSessionsSelected()) {
                                    MainActivity mainActivity7 = this.this$0.getMainActivity();
                                    if (mainActivity7 != null && (changeViewManager4 = mainActivity7.getChangeViewManager()) != null) {
                                        List<CollectionActivityData> collectionActivityDataList = this.this$0.getViewModel().getCollectionActivityDataList();
                                        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(collectionActivityDataList, 10));
                                        Iterator<T> it3 = collectionActivityDataList.iterator();
                                        while (it3.hasNext()) {
                                            arrayList3.add((CollectionActivityData) it3.next());
                                        }
                                        List mutableList3 = CollectionsKt.toMutableList((Collection) arrayList3);
                                        final ClassesMainFragment classesMainFragment4 = this.this$0;
                                        changeViewManager4.changePage(new SelectActivityCustom(mainActivity4, mutableList3, new SelectActivityCustom.SelectActivityCustomListener() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$setCategoryRecyclerView$adapter$1$onClick$4
                                            @Override // com.soletreadmills.sole_v2.ui.customview.SelectActivityCustom.SelectActivityCustomListener
                                            public void onClick(List<ActivityDataBase> activityDataList) {
                                                Intrinsics.checkNotNullParameter(activityDataList, "activityDataList");
                                                ClassesMainViewModel viewModel = classesMainFragment4.getViewModel();
                                                List<ActivityDataBase> list = activityDataList;
                                                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                                                for (ActivityDataBase activityDataBase : list) {
                                                    Intrinsics.checkNotNull(activityDataBase, "null cannot be cast to non-null type com.soletreadmills.sole_v2._data.classes.CollectionActivityData");
                                                    arrayList4.add((CollectionActivityData) activityDataBase);
                                                }
                                                viewModel.setCollectionActivityDataList(CollectionsKt.toMutableList((Collection) arrayList4));
                                                classesMainFragment4.syncQuickPicksForActivity();
                                                classesMainFragment4.reSetCategoryRecyclerView();
                                            }

                                            @Override // com.soletreadmills.sole_v2.ui.customview.SelectActivityCustom.SelectActivityCustomListener
                                            public void onReset() {
                                                classesMainFragment4.resetQuickPicksForActivity();
                                                classesMainFragment4.reSetCategoryRecyclerView();
                                            }
                                        }));
                                        break;
                                    }
                                } else {
                                    MainActivity mainActivity8 = this.this$0.getMainActivity();
                                    if (mainActivity8 != null && (changeViewManager5 = mainActivity8.getChangeViewManager()) != null) {
                                        List<SessionActivityData> sessionActivityDataList = this.this$0.getViewModel().getSessionActivityDataList();
                                        ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(sessionActivityDataList, 10));
                                        Iterator<T> it4 = sessionActivityDataList.iterator();
                                        while (it4.hasNext()) {
                                            arrayList4.add((SessionActivityData) it4.next());
                                        }
                                        List mutableList4 = CollectionsKt.toMutableList((Collection) arrayList4);
                                        final ClassesMainFragment classesMainFragment5 = this.this$0;
                                        changeViewManager5.changePage(new SelectActivityCustom(mainActivity4, mutableList4, new SelectActivityCustom.SelectActivityCustomListener() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$setCategoryRecyclerView$adapter$1$onClick$2
                                            @Override // com.soletreadmills.sole_v2.ui.customview.SelectActivityCustom.SelectActivityCustomListener
                                            public void onClick(List<ActivityDataBase> activityDataList) {
                                                Intrinsics.checkNotNullParameter(activityDataList, "activityDataList");
                                                ClassesMainViewModel viewModel = classesMainFragment5.getViewModel();
                                                List<ActivityDataBase> list = activityDataList;
                                                ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                                                for (ActivityDataBase activityDataBase : list) {
                                                    Intrinsics.checkNotNull(activityDataBase, "null cannot be cast to non-null type com.soletreadmills.sole_v2._data.classes.SessionActivityData");
                                                    arrayList5.add((SessionActivityData) activityDataBase);
                                                }
                                                viewModel.setSessionActivityDataList(CollectionsKt.toMutableList((Collection) arrayList5));
                                                classesMainFragment5.syncQuickPicksForActivity();
                                                classesMainFragment5.reSetCategoryRecyclerView();
                                            }

                                            @Override // com.soletreadmills.sole_v2.ui.customview.SelectActivityCustom.SelectActivityCustomListener
                                            public void onReset() {
                                                classesMainFragment5.resetQuickPicksForActivity();
                                                classesMainFragment5.reSetCategoryRecyclerView();
                                            }
                                        }));
                                        break;
                                    }
                                }
                            }
                            break;
                        case 67067064:
                            if (string.equals("FOCUS") && this.this$0.getViewModel().getIsSessionsSelected() && mainActivity4 != null && (mainActivity2 = this.this$0.getMainActivity()) != null && (changeViewManager6 = mainActivity2.getChangeViewManager()) != null) {
                                List<FocusData> focusDataList = this.this$0.getViewModel().getFocusDataList();
                                final ClassesMainFragment classesMainFragment6 = this.this$0;
                                changeViewManager6.changePage(new SelectFocusCustom(mainActivity4, focusDataList, new SelectFocusCustom.SelectFocusCustomListener() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$setCategoryRecyclerView$adapter$1$onClick$11
                                    @Override // com.soletreadmills.sole_v2.ui.customview.SelectFocusCustom.SelectFocusCustomListener
                                    public void onClick(List<FocusData> durationDataList2) {
                                        Intrinsics.checkNotNullParameter(durationDataList2, "durationDataList");
                                        classesMainFragment6.getViewModel().setFocusDataList(durationDataList2);
                                        classesMainFragment6.syncQuickPicksForFocus();
                                        classesMainFragment6.reSetCategoryRecyclerView();
                                    }

                                    @Override // com.soletreadmills.sole_v2.ui.customview.SelectFocusCustom.SelectFocusCustomListener
                                    public void onReset() {
                                        classesMainFragment6.resetQuickPicksForFocus();
                                        classesMainFragment6.reSetCategoryRecyclerView();
                                    }
                                }));
                                break;
                            }
                            break;
                        case 72328036:
                            if (string.equals("LEVEL") && this.this$0.getViewModel().getIsSessionsSelected() && mainActivity4 != null && (mainActivity3 = this.this$0.getMainActivity()) != null && (changeViewManager7 = mainActivity3.getChangeViewManager()) != null) {
                                List<FitnessLevelData> fitnessLevelDataList = this.this$0.getViewModel().getFitnessLevelDataList();
                                final ClassesMainFragment classesMainFragment7 = this.this$0;
                                changeViewManager7.changePage(new SelectFitnessLevelCustom(mainActivity4, fitnessLevelDataList, new SelectFitnessLevelCustom.SelectFitnessLevelCustomListener() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$setCategoryRecyclerView$adapter$1$onClick$10
                                    @Override // com.soletreadmills.sole_v2.ui.customview.SelectFitnessLevelCustom.SelectFitnessLevelCustomListener
                                    public void onClick(List<FitnessLevelData> fitnessLevelDataList2) {
                                        Intrinsics.checkNotNullParameter(fitnessLevelDataList2, "fitnessLevelDataList");
                                        classesMainFragment7.getViewModel().setFitnessLevelDataList(fitnessLevelDataList2);
                                        classesMainFragment7.syncQuickPicksForFitnessLevel();
                                        classesMainFragment7.reSetCategoryRecyclerView();
                                    }

                                    @Override // com.soletreadmills.sole_v2.ui.customview.SelectFitnessLevelCustom.SelectFitnessLevelCustomListener
                                    public void onReset() {
                                        classesMainFragment7.resetQuickPicksForFitnessLevel();
                                        classesMainFragment7.reSetCategoryRecyclerView();
                                    }
                                }));
                                break;
                            }
                            break;
                        case 1833417116:
                            if (string.equals("FAVORITE")) {
                                if (this.this$0.getViewModel().getIsSessionsSelected()) {
                                    this.this$0.getViewModel().setSessionIsFavoriteSelect(!this.this$0.getViewModel().getSessionIsFavoriteSelect());
                                    ClassesMainViewModel.loadSessionsData$default(this.this$0.getViewModel(), false, 0, null, 7, null);
                                } else {
                                    this.this$0.getViewModel().setCollectionIsFavoriteSelect(!this.this$0.getViewModel().getCollectionIsFavoriteSelect());
                                    ClassesMainViewModel.loadCollectionsData$default(this.this$0.getViewModel(), false, 0, null, 7, null);
                                }
                                this.this$0.reSetCategoryRecyclerView();
                                break;
                            }
                            break;
                    }
                }
            });
            FragmentClassesMainBinding binding4 = getBinding();
            RecyclerView recyclerView4 = binding4 != null ? binding4.recyclerviewCategory : null;
            if (recyclerView4 != null) {
                recyclerView4.setAdapter(classesCategoryAdapter);
            }
        }
        updateCategoryList();
    }

    private final void syncQuickPicksFor(List<String> selectedRawValues, List<String> allRawValues) {
        Set<String> collectionQuickPicksSelectedItems;
        ClassesQuickPicksAdapter sessionsQuickPicksAdapter = getViewModel().getIsSessionsSelected() ? getSessionsQuickPicksAdapter() : getCollectionsQuickPicksAdapter();
        if (getViewModel().getIsSessionsSelected()) {
            collectionQuickPicksSelectedItems = getViewModel().getSessionQuickPicksSelectedItems();
        } else {
            collectionQuickPicksSelectedItems = getViewModel().getCollectionQuickPicksSelectedItems();
        }
        Iterator<String> it = sessionsQuickPicksAdapter.getSelectedItems().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (allRawValues.contains(next)) {
                it.remove();
                collectionQuickPicksSelectedItems.remove(next);
            }
        }
        List<String> list = selectedRawValues;
        sessionsQuickPicksAdapter.getSelectedItems().addAll(list);
        collectionQuickPicksSelectedItems.addAll(list);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncQuickPicksForDuration() {
        List<DurationData> durationDataList = getViewModel().getDurationDataList();
        ArrayList arrayList = new ArrayList();
        for (Object obj : durationDataList) {
            if (((DurationData) obj).isSelect()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((DurationData) it.next()).getType().getRawValue());
        }
        syncQuickPicksFor(arrayList3, DurationType.INSTANCE.getAllRawValues());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncQuickPicksForFitnessLevel() {
        List<FitnessLevelData> fitnessLevelDataList = getViewModel().getFitnessLevelDataList();
        ArrayList arrayList = new ArrayList();
        for (Object obj : fitnessLevelDataList) {
            if (((FitnessLevelData) obj).isSelect()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((FitnessLevelData) it.next()).getType().getRawValue());
        }
        syncQuickPicksFor(arrayList3, FitnessLevelType.INSTANCE.getAllRawValues());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncQuickPicksForFocus() {
        List<FocusData> focusDataList = getViewModel().getFocusDataList();
        ArrayList arrayList = new ArrayList();
        for (Object obj : focusDataList) {
            if (((FocusData) obj).isSelect()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((FocusData) it.next()).getType().getRawValue());
        }
        syncQuickPicksFor(arrayList3, FocusType.INSTANCE.getAllRawValues());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncQuickPicksForActivity() {
        Iterable sessionActivityDataList = getViewModel().getIsSessionsSelected() ? getViewModel().getSessionActivityDataList() : getViewModel().getCollectionActivityDataList();
        ArrayList arrayList = new ArrayList();
        for (Object obj : sessionActivityDataList) {
            if (((ActivityDataBase) obj).isSelect()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = arrayList;
        ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList2, 10));
        Iterator it = arrayList2.iterator();
        while (it.hasNext()) {
            arrayList3.add(((ActivityDataBase) it.next()).getType().getRawValue());
        }
        syncQuickPicksFor(arrayList3, ActivityType.INSTANCE.getAllRawValues());
    }

    private final void resetQuickPicksFor(List<String> rawValues) {
        Set<String> collectionQuickPicksSelectedItems;
        ClassesQuickPicksAdapter sessionsQuickPicksAdapter = getViewModel().getIsSessionsSelected() ? getSessionsQuickPicksAdapter() : getCollectionsQuickPicksAdapter();
        if (getViewModel().getIsSessionsSelected()) {
            collectionQuickPicksSelectedItems = getViewModel().getSessionQuickPicksSelectedItems();
        } else {
            collectionQuickPicksSelectedItems = getViewModel().getCollectionQuickPicksSelectedItems();
        }
        Iterator<String> it = sessionsQuickPicksAdapter.getSelectedItems().iterator();
        while (it.hasNext()) {
            String next = it.next();
            if (rawValues.contains(next)) {
                it.remove();
                collectionQuickPicksSelectedItems.remove(next);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetQuickPicksForDuration() {
        resetQuickPicksFor(DurationType.INSTANCE.getAllRawValues());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetQuickPicksForFitnessLevel() {
        resetQuickPicksFor(FitnessLevelType.INSTANCE.getAllRawValues());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetQuickPicksForFocus() {
        resetQuickPicksFor(FocusType.INSTANCE.getAllRawValues());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetQuickPicksForActivity() {
        resetQuickPicksFor(ActivityType.INSTANCE.getAllRawValues());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void resetQuickPicksForInstructors() {
        ClassesQuickPicksAdapter sessionsQuickPicksAdapter = getViewModel().getIsSessionsSelected() ? getSessionsQuickPicksAdapter() : getCollectionsQuickPicksAdapter();
        Iterable sessionInstructorsList = getViewModel().getIsSessionsSelected() ? getViewModel().getSessionInstructorsList() : getViewModel().getCollectionInstructorsList();
        ArrayList arrayList = new ArrayList();
        Iterator it = sessionInstructorsList.iterator();
        while (it.hasNext()) {
            String instructor_id = ((ClassInstructorsDataBase) it.next()).getInstructorsData().getInstructor_id();
            if (instructor_id != null) {
                arrayList.add(instructor_id);
            }
        }
        ArrayList arrayList2 = arrayList;
        if (getViewModel().getIsSessionsSelected()) {
            getViewModel().getSessionQuickPicksSelectedItems();
        } else {
            getViewModel().getCollectionQuickPicksSelectedItems();
        }
        Iterator<String> it2 = sessionsQuickPicksAdapter.getSelectedItems().iterator();
        while (it2.hasNext()) {
            if (arrayList2.contains(it2.next())) {
                it2.remove();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void syncQuickPicksForInstructors() {
        Iterable sessionInstructorsList = getViewModel().getIsSessionsSelected() ? getViewModel().getSessionInstructorsList() : getViewModel().getCollectionInstructorsList();
        ArrayList arrayList = new ArrayList();
        for (Object obj : sessionInstructorsList) {
            if (((ClassInstructorsDataBase) obj).isSelect()) {
                arrayList.add(obj);
            }
        }
        ArrayList arrayList2 = new ArrayList();
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            String instructor_id = ((ClassInstructorsDataBase) it.next()).getInstructorsData().getInstructor_id();
            if (instructor_id != null) {
                arrayList2.add(instructor_id);
            }
        }
        ArrayList arrayList3 = arrayList2;
        ArrayList arrayList4 = new ArrayList();
        Iterator it2 = sessionInstructorsList.iterator();
        while (it2.hasNext()) {
            String instructor_id2 = ((ClassInstructorsDataBase) it2.next()).getInstructorsData().getInstructor_id();
            if (instructor_id2 != null) {
                arrayList4.add(instructor_id2);
            }
        }
        syncQuickPicksFor(arrayList3, arrayList4);
    }

    private final void updateCategoryList() {
        RecyclerView recyclerView;
        FragmentClassesMainBinding binding = getBinding();
        Object adapter = (binding == null || (recyclerView = binding.recyclerviewCategory) == null) ? null : recyclerView.getAdapter();
        ClassesCategoryAdapter classesCategoryAdapter = adapter instanceof ClassesCategoryAdapter ? (ClassesCategoryAdapter) adapter : null;
        if (classesCategoryAdapter == null) {
            return;
        }
        int activityCount = getViewModel().getActivityCount();
        int durationCount = getViewModel().getDurationCount();
        int instructorsCount = getViewModel().getInstructorsCount();
        int fitnessLevelCount = getViewModel().getFitnessLevelCount();
        int focusCount = getViewModel().getFocusCount();
        ArrayList arrayList = new ArrayList();
        if (getViewModel().getIsSessionsSelected()) {
            arrayList.add(new ClassesCategoryData(ClassesCategoryType.FAVORITE, 0, getViewModel().getSessionIsFavoriteSelect()));
            arrayList.add(new ClassesCategoryData(ClassesCategoryType.ACTIVITY, activityCount, false));
            arrayList.add(new ClassesCategoryData(ClassesCategoryType.DURATION, durationCount, false));
            arrayList.add(new ClassesCategoryData(ClassesCategoryType.INSTRUCTORS, instructorsCount, false));
            arrayList.add(new ClassesCategoryData(ClassesCategoryType.LEVEL, fitnessLevelCount, false));
            arrayList.add(new ClassesCategoryData(ClassesCategoryType.FOCUS, focusCount, false));
        } else {
            arrayList.add(new ClassesCategoryData(ClassesCategoryType.FAVORITE, 0, getViewModel().getCollectionIsFavoriteSelect()));
            arrayList.add(new ClassesCategoryData(ClassesCategoryType.ACTIVITY, activityCount, false));
            arrayList.add(new ClassesCategoryData(ClassesCategoryType.INSTRUCTORS, instructorsCount, false));
        }
        classesCategoryAdapter.submitList(arrayList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reSetCategoryRecyclerView() {
        int i;
        int i2;
        int i3;
        int i4;
        RecyclerView recyclerView;
        FragmentClassesMainBinding binding = getBinding();
        ClassesResultsAdapter classesResultsAdapter = null;
        RecyclerView.Adapter adapter = (binding == null || (recyclerView = binding.recyclerviewCategory) == null) ? null : recyclerView.getAdapter();
        if (adapter instanceof ClassesCategoryAdapter) {
            ClassesCategoryAdapter classesCategoryAdapter = (ClassesCategoryAdapter) adapter;
            List<ClassesCategoryData> currentList = classesCategoryAdapter.getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
            ArrayList arrayList = new ArrayList();
            Iterable sessionActivityDataList = getViewModel().getIsSessionsSelected() ? getViewModel().getSessionActivityDataList() : getViewModel().getCollectionActivityDataList();
            Iterable sessionInstructorsList = getViewModel().getIsSessionsSelected() ? getViewModel().getSessionInstructorsList() : getViewModel().getCollectionInstructorsList();
            boolean sessionIsFavoriteSelect = getViewModel().getIsSessionsSelected() ? getViewModel().getSessionIsFavoriteSelect() : getViewModel().getCollectionIsFavoriteSelect();
            Iterable iterable = sessionActivityDataList;
            int i5 = 0;
            if ((iterable instanceof Collection) && ((Collection) iterable).isEmpty()) {
                i = 0;
            } else {
                Iterator it = iterable.iterator();
                i = 0;
                while (it.hasNext()) {
                    if (((ActivityDataBase) it.next()).isSelect() && (i = i + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            Iterable iterable2 = sessionInstructorsList;
            if ((iterable2 instanceof Collection) && ((Collection) iterable2).isEmpty()) {
                i2 = 0;
            } else {
                Iterator it2 = iterable2.iterator();
                i2 = 0;
                while (it2.hasNext()) {
                    if (((ClassInstructorsDataBase) it2.next()).isSelect() && (i2 = i2 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            List<DurationData> durationDataList = getViewModel().getDurationDataList();
            if ((durationDataList instanceof Collection) && durationDataList.isEmpty()) {
                i3 = 0;
            } else {
                Iterator<T> it3 = durationDataList.iterator();
                i3 = 0;
                while (it3.hasNext()) {
                    if (((DurationData) it3.next()).isSelect() && (i3 = i3 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            List<FitnessLevelData> fitnessLevelDataList = getViewModel().getFitnessLevelDataList();
            if ((fitnessLevelDataList instanceof Collection) && fitnessLevelDataList.isEmpty()) {
                i4 = 0;
            } else {
                Iterator<T> it4 = fitnessLevelDataList.iterator();
                i4 = 0;
                while (it4.hasNext()) {
                    if (((FitnessLevelData) it4.next()).isSelect() && (i4 = i4 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            List<FocusData> focusDataList = getViewModel().getFocusDataList();
            if (!(focusDataList instanceof Collection) || !focusDataList.isEmpty()) {
                Iterator<T> it5 = focusDataList.iterator();
                while (it5.hasNext()) {
                    if (((FocusData) it5.next()).isSelect() && (i5 = i5 + 1) < 0) {
                        CollectionsKt.throwCountOverflow();
                    }
                }
            }
            for (ClassesCategoryData classesCategoryData : currentList) {
                Intrinsics.checkNotNull(classesCategoryData);
                ClassesCategoryData classesCategoryDataCopy$default = ClassesCategoryData.copy$default(classesCategoryData, null, 0, false, 7, null);
                switch (WhenMappings.$EnumSwitchMapping$0[classesCategoryData.getType().ordinal()]) {
                    case 1:
                        classesCategoryDataCopy$default.setSelect(sessionIsFavoriteSelect);
                        break;
                    case 2:
                        classesCategoryDataCopy$default.setCount(i);
                        break;
                    case 3:
                        classesCategoryDataCopy$default.setCount(i3);
                        break;
                    case 4:
                        classesCategoryDataCopy$default.setCount(i2);
                        break;
                    case 5:
                        classesCategoryDataCopy$default.setCount(i4);
                        break;
                    case 6:
                        classesCategoryDataCopy$default.setCount(i5);
                        break;
                }
                arrayList.add(classesCategoryDataCopy$default);
            }
            classesCategoryAdapter.submitList(arrayList);
            if (getViewModel().getIsSessionsSelected()) {
                ClassesResultsAdapter classesResultsAdapter2 = this.sessionResultsAdapter;
                if (classesResultsAdapter2 != null) {
                    if (classesResultsAdapter2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sessionResultsAdapter");
                    } else {
                        classesResultsAdapter = classesResultsAdapter2;
                    }
                    classesResultsAdapter.submitList(CollectionsKt.emptyList());
                }
                ClassesMainViewModel.loadSessionsData$default(getViewModel(), false, 0, null, 7, null);
                return;
            }
            ClassesResultsAdapter classesResultsAdapter3 = this.collectionResultsAdapter;
            if (classesResultsAdapter3 != null) {
                if (classesResultsAdapter3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("collectionResultsAdapter");
                } else {
                    classesResultsAdapter = classesResultsAdapter3;
                }
                classesResultsAdapter.submitList(CollectionsKt.emptyList());
            }
            ClassesMainViewModel.loadCollectionsData$default(getViewModel(), false, 0, null, 7, null);
        }
    }

    private final void setConcatAdapter() {
        initializeSessionsAdapters();
        setupSessionsRecyclerView();
        initializeCollectionsAdapters();
        setupCollectionsRecyclerView();
        ClassesMainViewModel.loadSessionsData$default(getViewModel(), false, 0, null, 7, null);
        getViewModel().loadSessionsQuickPickData();
        ClassesMainViewModel.loadCollectionsData$default(getViewModel(), false, 0, null, 7, null);
        getViewModel().loadCollecionQuickPickData();
    }

    private final void initializeSessionsAdapters() {
        Context context = getContext();
        if (context != null) {
            setSessionsQuickPicksAdapter(new ClassesQuickPicksAdapter(context, new ClassesQuickPicksAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$initializeSessionsAdapters$1$1
                @Override // com.soletreadmills.sole_v2.ui.adapter.classes.ClassesQuickPicksAdapter.OnItemClickListener
                public void onQuickPickClick(QuickPicksData item, boolean isSelected) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    this.this$0.toggleSelection(item, isSelected);
                }
            }));
            getSessionsQuickPicksAdapter().getSelectedItems().clear();
            getSessionsQuickPicksAdapter().getSelectedItems().addAll(getViewModel().getSessionQuickPicksSelectedItems());
            this.sessionResultsAdapter = new ClassesResultsAdapter(context, new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$initializeSessionsAdapters$1$2
                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos) {
                }

                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos, String string) {
                    Intrinsics.checkNotNullParameter(string, "string");
                    if (Intrinsics.areEqual(string, "clear_filter")) {
                        this.this$0.getViewModel().clearAllFilters();
                        this.this$0.getSessionsQuickPicksAdapter().getSelectedItems().clear();
                        this.this$0.getSessionsQuickPicksAdapter().notifyDataSetChanged();
                    }
                }
            });
            this.sessionsAdapter = new ClassesSessionsAdapter(context, new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$initializeSessionsAdapters$1$3
                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos) {
                }

                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos, String string) {
                    Intrinsics.checkNotNullParameter(string, "string");
                    Bundle bundle = new Bundle();
                    bundle.putString("classID", string);
                    this.this$0.safeNavigate(R.id.classesDetailFragment, bundle);
                }
            });
            if (this.endAdapter == null) {
                this.endAdapter = new ClassesEndAdapter(new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$initializeSessionsAdapters$1$4
                    @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                    public void onClick(int pos) {
                    }

                    @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                    public void onClick(int pos, String string) {
                        Intrinsics.checkNotNullParameter(string, "string");
                    }
                });
                List listMutableListOf = CollectionsKt.mutableListOf("end1");
                ClassesEndAdapter classesEndAdapter = this.endAdapter;
                if (classesEndAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("endAdapter");
                    classesEndAdapter = null;
                }
                classesEndAdapter.submitList(listMutableListOf);
            }
            if (this.sessionsEmptyAdapter == null) {
                this.sessionsEmptyAdapter = new WorkoutsEmptyAdapter(context, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$initializeSessionsAdapters$1$5
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
                        this.this$0.getViewModel().clearAllFilters();
                        this.this$0.getSessionsQuickPicksAdapter().getSelectedItems().clear();
                        this.this$0.getSessionsQuickPicksAdapter().notifyDataSetChanged();
                    }
                });
            }
        }
    }

    private final void initializeCollectionsAdapters() {
        Context context = getContext();
        if (context != null) {
            setCollectionsQuickPicksAdapter(new ClassesQuickPicksAdapter(context, new ClassesQuickPicksAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$initializeCollectionsAdapters$1$1
                @Override // com.soletreadmills.sole_v2.ui.adapter.classes.ClassesQuickPicksAdapter.OnItemClickListener
                public void onQuickPickClick(QuickPicksData item, boolean isSelected) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    this.this$0.toggleSelection(item, isSelected);
                }
            }));
            getCollectionsQuickPicksAdapter().getSelectedItems().clear();
            getCollectionsQuickPicksAdapter().getSelectedItems().addAll(getViewModel().getCollectionQuickPicksSelectedItems());
            this.collectionResultsAdapter = new ClassesResultsAdapter(context, new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$initializeCollectionsAdapters$1$2
                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos) {
                }

                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos, String string) {
                    Intrinsics.checkNotNullParameter(string, "string");
                    if (Intrinsics.areEqual(string, "clear_filter")) {
                        this.this$0.getViewModel().clearAllFilters();
                        this.this$0.getCollectionsQuickPicksAdapter().getSelectedItems().clear();
                        this.this$0.getCollectionsQuickPicksAdapter().notifyDataSetChanged();
                    }
                }
            });
            this.collectionsAdapter = new ClassesCollectionsAdapter(context, new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$initializeCollectionsAdapters$1$3
                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos) {
                }

                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos, String string) {
                    Intrinsics.checkNotNullParameter(string, "string");
                    Bundle bundle = new Bundle();
                    bundle.putString("collectionId", string);
                    this.this$0.safeNavigate(R.id.collectionDetailFragment, bundle);
                }
            });
            if (this.endAdapter == null) {
                this.endAdapter = new ClassesEndAdapter(new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$initializeCollectionsAdapters$1$4
                    @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                    public void onClick(int pos) {
                    }

                    @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                    public void onClick(int pos, String string) {
                        Intrinsics.checkNotNullParameter(string, "string");
                    }
                });
                List listMutableListOf = CollectionsKt.mutableListOf("end1");
                ClassesEndAdapter classesEndAdapter = this.endAdapter;
                if (classesEndAdapter == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("endAdapter");
                    classesEndAdapter = null;
                }
                classesEndAdapter.submitList(listMutableListOf);
            }
            if (this.collectionsEmptyAdapter == null) {
                this.collectionsEmptyAdapter = new WorkoutsEmptyAdapter(context, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$initializeCollectionsAdapters$1$5
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
                        this.this$0.getViewModel().clearAllFilters();
                        this.this$0.getCollectionsQuickPicksAdapter().getSelectedItems().clear();
                        this.this$0.getCollectionsQuickPicksAdapter().notifyDataSetChanged();
                    }
                });
            }
        }
    }

    private final void setupSessionsRecyclerView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        Context context = getContext();
        if (context != null) {
            FragmentClassesMainBinding binding = getBinding();
            if (((binding == null || (recyclerView2 = binding.recyclerview) == null) ? null : recyclerView2.getLayoutManager()) == null) {
                FragmentClassesMainBinding binding2 = getBinding();
                RecyclerView recyclerView3 = binding2 != null ? binding2.recyclerview : null;
                if (recyclerView3 != null) {
                    recyclerView3.setLayoutManager(new LinearLayoutManager(context));
                }
            }
            FragmentClassesMainBinding binding3 = getBinding();
            if (binding3 == null || (recyclerView = binding3.recyclerview) == null) {
                return;
            }
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$setupSessionsRecyclerView$1$1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView4, int dx, int dy) {
                    Intrinsics.checkNotNullParameter(recyclerView4, "recyclerView");
                    super.onScrolled(recyclerView4, dx, dy);
                    if (this.this$0.getViewModel().getIsSessionsSelected() && this.this$0.getViewModel().getSessionHasMoreData() && dy > 0) {
                        RecyclerView.LayoutManager layoutManager = recyclerView4.getLayoutManager();
                        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                        if (linearLayoutManager == null) {
                            return;
                        }
                        if (linearLayoutManager.findLastVisibleItemPosition() >= linearLayoutManager.getItemCount() - 3) {
                            this.this$0.getViewModel().loadMoreSessionsData();
                        }
                    }
                }
            });
        }
    }

    private final void setupCollectionsRecyclerView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        Context context = getContext();
        if (context != null) {
            FragmentClassesMainBinding binding = getBinding();
            if (((binding == null || (recyclerView2 = binding.recyclerviewCollections) == null) ? null : recyclerView2.getLayoutManager()) == null) {
                FragmentClassesMainBinding binding2 = getBinding();
                RecyclerView recyclerView3 = binding2 != null ? binding2.recyclerviewCollections : null;
                if (recyclerView3 != null) {
                    recyclerView3.setLayoutManager(new LinearLayoutManager(context));
                }
            }
            FragmentClassesMainBinding binding3 = getBinding();
            if (binding3 == null || (recyclerView = binding3.recyclerviewCollections) == null) {
                return;
            }
            recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.soletreadmills.sole_v2.ui.classes.ClassesMainFragment$setupCollectionsRecyclerView$1$1
                @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                public void onScrolled(RecyclerView recyclerView4, int dx, int dy) {
                    Intrinsics.checkNotNullParameter(recyclerView4, "recyclerView");
                    super.onScrolled(recyclerView4, dx, dy);
                    if (this.this$0.getViewModel().getIsSessionsSelected() || !this.this$0.getViewModel().getCollectionHasMoreData() || dy <= 0) {
                        return;
                    }
                    RecyclerView.LayoutManager layoutManager = recyclerView4.getLayoutManager();
                    LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                    if (linearLayoutManager == null) {
                        return;
                    }
                    if (linearLayoutManager.findLastVisibleItemPosition() >= linearLayoutManager.getItemCount() - 3) {
                        this.this$0.getViewModel().loadMoreCollectionsData();
                    }
                }
            });
        }
    }

    public final void toggleSelection(QuickPicksData item, boolean isSelected) {
        Set<String> collectionQuickPicksSelectedItems;
        int i;
        Intrinsics.checkNotNullParameter(item, "item");
        if (getViewModel().getIsSessionsSelected()) {
            collectionQuickPicksSelectedItems = getViewModel().getSessionQuickPicksSelectedItems();
        } else {
            collectionQuickPicksSelectedItems = getViewModel().getCollectionQuickPicksSelectedItems();
        }
        String filterItemId = item.getFilterItemId();
        if (filterItemId == null && (filterItemId = item.getFilterItemName()) == null) {
            filterItemId = "";
        }
        if (isSelected) {
            collectionQuickPicksSelectedItems.add(filterItemId);
        } else {
            collectionQuickPicksSelectedItems.remove(filterItemId);
        }
        if (getViewModel().getIsSessionsSelected()) {
            ClassesFilterTagViewType classesFilterTagViewType = item.getClassesFilterTagViewType();
            i = classesFilterTagViewType != null ? WhenMappings.$EnumSwitchMapping$1[classesFilterTagViewType.ordinal()] : -1;
            if (i == 1) {
                ClassesMainViewModel viewModel = getViewModel();
                List<SessionActivityData> sessionActivityDataList = getViewModel().getSessionActivityDataList();
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(sessionActivityDataList, 10));
                for (SessionActivityData sessionActivityDataCopy$default : sessionActivityDataList) {
                    if (Intrinsics.areEqual(sessionActivityDataCopy$default.getType().getRawValue(), item.getFilterItemId())) {
                        sessionActivityDataCopy$default = SessionActivityData.copy$default(sessionActivityDataCopy$default, null, isSelected, 1, null);
                    }
                    arrayList.add(sessionActivityDataCopy$default);
                }
                viewModel.setSessionActivityDataList(CollectionsKt.toMutableList((Collection) arrayList));
            } else if (i == 2) {
                ClassesMainViewModel viewModel2 = getViewModel();
                List<DurationData> durationDataList = getViewModel().getDurationDataList();
                ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(durationDataList, 10));
                for (DurationData durationDataCopy$default : durationDataList) {
                    if (Intrinsics.areEqual(durationDataCopy$default.getType().getRawValue(), item.getFilterItemId())) {
                        durationDataCopy$default = DurationData.copy$default(durationDataCopy$default, null, isSelected, 1, null);
                    }
                    arrayList2.add(durationDataCopy$default);
                }
                viewModel2.setDurationDataList(CollectionsKt.toMutableList((Collection) arrayList2));
            } else if (i == 3) {
                ClassesMainViewModel viewModel3 = getViewModel();
                List<SessionInstructorsData> sessionInstructorsList = getViewModel().getSessionInstructorsList();
                ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(sessionInstructorsList, 10));
                for (SessionInstructorsData sessionInstructorsDataCopy$default : sessionInstructorsList) {
                    if (Intrinsics.areEqual(sessionInstructorsDataCopy$default.getInstructorsData().getInstructor_id(), item.getFilterItemId())) {
                        sessionInstructorsDataCopy$default = SessionInstructorsData.copy$default(sessionInstructorsDataCopy$default, null, isSelected, 1, null);
                    }
                    arrayList3.add(sessionInstructorsDataCopy$default);
                }
                viewModel3.setSessionInstructorsList(CollectionsKt.toMutableList((Collection) arrayList3));
            } else if (i == 4) {
                ClassesMainViewModel viewModel4 = getViewModel();
                List<FitnessLevelData> fitnessLevelDataList = getViewModel().getFitnessLevelDataList();
                ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(fitnessLevelDataList, 10));
                for (FitnessLevelData fitnessLevelDataCopy$default : fitnessLevelDataList) {
                    if (Intrinsics.areEqual(fitnessLevelDataCopy$default.getType().getRawValue(), item.getFilterItemId())) {
                        fitnessLevelDataCopy$default = FitnessLevelData.copy$default(fitnessLevelDataCopy$default, null, isSelected, 1, null);
                    }
                    arrayList4.add(fitnessLevelDataCopy$default);
                }
                viewModel4.setFitnessLevelDataList(CollectionsKt.toMutableList((Collection) arrayList4));
            } else if (i == 5) {
                ClassesMainViewModel viewModel5 = getViewModel();
                List<FocusData> focusDataList = getViewModel().getFocusDataList();
                ArrayList arrayList5 = new ArrayList(CollectionsKt.collectionSizeOrDefault(focusDataList, 10));
                for (FocusData focusDataCopy$default : focusDataList) {
                    if (Intrinsics.areEqual(focusDataCopy$default.getType().getRawValue(), item.getFilterItemId())) {
                        focusDataCopy$default = FocusData.copy$default(focusDataCopy$default, null, isSelected, 1, null);
                    }
                    arrayList5.add(focusDataCopy$default);
                }
                viewModel5.setFocusDataList(CollectionsKt.toMutableList((Collection) arrayList5));
            }
        } else {
            ClassesFilterTagViewType classesFilterTagViewType2 = item.getClassesFilterTagViewType();
            i = classesFilterTagViewType2 != null ? WhenMappings.$EnumSwitchMapping$1[classesFilterTagViewType2.ordinal()] : -1;
            if (i == 1) {
                ClassesMainViewModel viewModel6 = getViewModel();
                List<CollectionActivityData> collectionActivityDataList = getViewModel().getCollectionActivityDataList();
                ArrayList arrayList6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(collectionActivityDataList, 10));
                for (CollectionActivityData collectionActivityDataCopy$default : collectionActivityDataList) {
                    if (Intrinsics.areEqual(collectionActivityDataCopy$default.getType().getRawValue(), item.getFilterItemId())) {
                        collectionActivityDataCopy$default = CollectionActivityData.copy$default(collectionActivityDataCopy$default, null, isSelected, 1, null);
                    }
                    arrayList6.add(collectionActivityDataCopy$default);
                }
                viewModel6.setCollectionActivityDataList(CollectionsKt.toMutableList((Collection) arrayList6));
            } else if (i == 3) {
                ClassesMainViewModel viewModel7 = getViewModel();
                List<CollectionInstructorsData> collectionInstructorsList = getViewModel().getCollectionInstructorsList();
                ArrayList arrayList7 = new ArrayList(CollectionsKt.collectionSizeOrDefault(collectionInstructorsList, 10));
                for (CollectionInstructorsData collectionInstructorsDataCopy$default : collectionInstructorsList) {
                    if (Intrinsics.areEqual(collectionInstructorsDataCopy$default.getInstructorsData().getInstructor_id(), item.getFilterItemId())) {
                        collectionInstructorsDataCopy$default = CollectionInstructorsData.copy$default(collectionInstructorsDataCopy$default, null, isSelected, 1, null);
                    }
                    arrayList7.add(collectionInstructorsDataCopy$default);
                }
                viewModel7.setCollectionInstructorsList(CollectionsKt.toMutableList((Collection) arrayList7));
            }
        }
        reSetCategoryRecyclerView();
    }
}
