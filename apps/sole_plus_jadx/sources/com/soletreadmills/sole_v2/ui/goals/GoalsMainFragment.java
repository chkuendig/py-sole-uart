package com.soletreadmills.sole_v2.ui.goals;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.android.SdkConstants;
import com.blankj.utilcode.util.SnackbarUtils;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._data.api.goal.DeleteUserGoalApiData;
import com.soletreadmills.sole_v2._data.api.goal.GetMyUserGoalListApiData;
import com.soletreadmills.sole_v2._data.goal.UserGoalData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2._type.MachineType;
import com.soletreadmills.sole_v2.databinding.FragmentGoalsMainBinding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.adapter.goals.GoalsAdapter;
import com.soletreadmills.sole_v2.ui.customview.GoalsDetailView;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: GoalsMainFragment.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0006H\u0002J\u000e\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019J\b\u0010\u001a\u001a\u00020\u0015H\u0002J\u001a\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0015H\u0016J\u0012\u0010!\u001a\u00020\u00152\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u0015H\u0002J\u0010\u0010%\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\b\u0010&\u001a\u00020\u0015H\u0002J\u0016\u0010'\u001a\u00020\u00152\f\u0010(\u001a\b\u0012\u0004\u0012\u00020*0)H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001a\u0010\u000f\u001a\u00020\u0010X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013¨\u0006+"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/goals/GoalsMainFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentGoalsMainBinding;", "Landroid/view/View$OnClickListener;", "()V", "currentCollapseMode", "", "goalsAdapter", "Lcom/soletreadmills/sole_v2/ui/adapter/goals/GoalsAdapter;", "goalsViewModel", "Lcom/soletreadmills/sole_v2/ui/goals/GoalsViewModel;", "getGoalsViewModel", "()Lcom/soletreadmills/sole_v2/ui/goals/GoalsViewModel;", "goalsViewModel$delegate", "Lkotlin/Lazy;", "isEdit", "", "()Z", "setEdit", "(Z)V", "changeCollapseMode", "", "collapseMode", "deleteGoal", "userGoalId", "", "getGoalsData", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "setRecyclerview", "showDeleteConfirmation", "updateEditBtnView", "updateGoalsData", "goalsList", "", "Lcom/soletreadmills/sole_v2/_data/goal/UserGoalData;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GoalsMainFragment extends BaseFragment<FragmentGoalsMainBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private int currentCollapseMode = 2;
    private GoalsAdapter goalsAdapter;

    /* renamed from: goalsViewModel$delegate, reason: from kotlin metadata */
    private final Lazy goalsViewModel;
    private boolean isEdit;

    public GoalsMainFragment() {
        final GoalsMainFragment goalsMainFragment = this;
        final Function0 function0 = null;
        this.goalsViewModel = FragmentViewModelLazyKt.createViewModelLazy(goalsMainFragment, Reflection.getOrCreateKotlinClass(GoalsViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsMainFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = goalsMainFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsMainFragment$special$$inlined$activityViewModels$default$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                if (function02 != null && (creationExtras = (CreationExtras) function02.invoke()) != null) {
                    return creationExtras;
                }
                CreationExtras defaultViewModelCreationExtras = goalsMainFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsMainFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = goalsMainFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public static final /* synthetic */ FragmentGoalsMainBinding access$getBinding(GoalsMainFragment goalsMainFragment) {
        return goalsMainFragment.getBinding();
    }

    public final GoalsViewModel getGoalsViewModel() {
        return (GoalsViewModel) this.goalsViewModel.getValue();
    }

    /* renamed from: isEdit, reason: from getter */
    public final boolean getIsEdit() {
        return this.isEdit;
    }

    public final void setEdit(boolean z) {
        this.isEdit = z;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentGoalsMainBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentGoalsMainBinding fragmentGoalsMainBindingInflate = FragmentGoalsMainBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentGoalsMainBindingInflate, "inflate(...)");
        return fragmentGoalsMainBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        SwipeRefreshLayout swipeRefreshLayout;
        TextView textView;
        TextView textView2;
        ImageView imageView;
        AppBarLayout appBarLayout;
        FragmentGoalsMainBinding binding = getBinding();
        if (binding != null && (appBarLayout = binding.appBarLayout) != null) {
            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsMainFragment$$ExternalSyntheticLambda0
                @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
                public final void onOffsetChanged(AppBarLayout appBarLayout2, int i) {
                    GoalsMainFragment.initViews$lambda$0(this.f$0, appBarLayout2, i);
                }
            });
        }
        FragmentGoalsMainBinding binding2 = getBinding();
        if (binding2 != null && (imageView = binding2.back) != null) {
            imageView.setOnClickListener(this);
        }
        FragmentGoalsMainBinding binding3 = getBinding();
        if (binding3 != null && (textView2 = binding3.tvEdit) != null) {
            textView2.setOnClickListener(this);
        }
        FragmentGoalsMainBinding binding4 = getBinding();
        if (binding4 != null && (textView = binding4.tvDone) != null) {
            textView.setOnClickListener(this);
        }
        setRecyclerview();
        FragmentGoalsMainBinding binding5 = getBinding();
        if (binding5 != null && (swipeRefreshLayout = binding5.swipeRefreshLayout) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsMainFragment$$ExternalSyntheticLambda1
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    GoalsMainFragment.initViews$lambda$1(this.f$0);
                }
            });
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass3(null), 3, null);
        getGoalsData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$0(GoalsMainFragment this$0, AppBarLayout appBarLayout, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i2 = ((float) Math.abs(i)) / ((float) appBarLayout.getTotalScrollRange()) >= 0.85f ? 1 : 2;
        if (this$0.currentCollapseMode != i2) {
            this$0.changeCollapseMode(i2);
            this$0.currentCollapseMode = i2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$1(GoalsMainFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.getGoalsData();
    }

    /* compiled from: GoalsMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.goals.GoalsMainFragment$initViews$3", f = "GoalsMainFragment.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.goals.GoalsMainFragment$initViews$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass3(Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GoalsMainFragment.this.new AnonymousClass3(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: GoalsMainFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.goals.GoalsMainFragment$initViews$3$1", f = "GoalsMainFragment.kt", i = {}, l = {81}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.goals.GoalsMainFragment$initViews$3$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ GoalsMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(GoalsMainFragment goalsMainFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = goalsMainFragment;
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
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    StateFlow<List<UserGoalData>> goalsList = this.this$0.getGoalsViewModel().getGoalsList();
                    final GoalsMainFragment goalsMainFragment = this.this$0;
                    this.label = 1;
                    if (goalsList.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsMainFragment.initViews.3.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((List<UserGoalData>) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(List<UserGoalData> list, Continuation<? super Unit> continuation) {
                            goalsMainFragment.updateGoalsData(list);
                            return Unit.INSTANCE;
                        }
                    }, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                throw new KotlinNothingValueException();
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(GoalsMainFragment.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new AnonymousClass1(GoalsMainFragment.this, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.back;
        if (numValueOf != null && numValueOf.intValue() == i) {
            MainActivity mainActivity = getMainActivity();
            if (mainActivity != null) {
                mainActivity.onBackPressed();
                return;
            }
            return;
        }
        int i2 = R.id.tv_edit;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            this.isEdit = true;
            updateEditBtnView();
            return;
        }
        int i3 = R.id.tv_done;
        if (numValueOf != null && numValueOf.intValue() == i3) {
            this.isEdit = false;
            updateEditBtnView();
        }
    }

    private final void changeCollapseMode(int collapseMode) {
        Toolbar toolbar;
        FragmentGoalsMainBinding binding = getBinding();
        ViewGroup.LayoutParams layoutParams = (binding == null || (toolbar = binding.collapsingToolbar) == null) ? null : toolbar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams");
        CollapsingToolbarLayout.LayoutParams layoutParams2 = (CollapsingToolbarLayout.LayoutParams) layoutParams;
        layoutParams2.setCollapseMode(collapseMode);
        FragmentGoalsMainBinding binding2 = getBinding();
        Toolbar toolbar2 = binding2 != null ? binding2.collapsingToolbar : null;
        if (toolbar2 == null) {
            return;
        }
        toolbar2.setLayoutParams(layoutParams2);
    }

    private final void updateEditBtnView() {
        TextView textView;
        GoalsAdapter goalsAdapter = this.goalsAdapter;
        if (goalsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goalsAdapter");
            goalsAdapter = null;
        }
        goalsAdapter.setEditMode(this.isEdit);
        if (this.isEdit) {
            FragmentGoalsMainBinding binding = getBinding();
            TextView textView2 = binding != null ? binding.tvEdit : null;
            if (textView2 != null) {
                textView2.setVisibility(8);
            }
            FragmentGoalsMainBinding binding2 = getBinding();
            textView = binding2 != null ? binding2.tvDone : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        FragmentGoalsMainBinding binding3 = getBinding();
        TextView textView3 = binding3 != null ? binding3.tvEdit : null;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        FragmentGoalsMainBinding binding4 = getBinding();
        textView = binding4 != null ? binding4.tvDone : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    private final void setRecyclerview() {
        RecyclerView recyclerView;
        Context context = getContext();
        if (context != null) {
            FragmentGoalsMainBinding binding = getBinding();
            GoalsAdapter goalsAdapter = null;
            if (!(((binding == null || (recyclerView = binding.rv) == null) ? null : recyclerView.getLayoutManager()) instanceof LinearLayoutManager)) {
                FragmentGoalsMainBinding binding2 = getBinding();
                RecyclerView recyclerView2 = binding2 != null ? binding2.rv : null;
                if (recyclerView2 != null) {
                    recyclerView2.setLayoutManager(new LinearLayoutManager(context));
                }
            }
            if (this.goalsAdapter == null) {
                this.goalsAdapter = new GoalsAdapter(context, new GoalsAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsMainFragment$setRecyclerview$1$1
                    @Override // com.soletreadmills.sole_v2.ui.adapter.goals.GoalsAdapter.OnItemClickListener
                    public void onItemClick(UserGoalData userGoalData, int position) {
                        Intrinsics.checkNotNullParameter(userGoalData, "userGoalData");
                        Timber.INSTANCE.d("userGoalData: " + userGoalData, new Object[0]);
                        if (Intrinsics.areEqual(userGoalData.getUserGoalUuid(), "addGoal")) {
                            Timber.INSTANCE.d("addGoal", new Object[0]);
                            if (this.this$0.getIsEdit()) {
                                return;
                            }
                            BaseFragment.safeNavigate$default(this.this$0, R.id.goalsCreateFragment, null, 2, null);
                            return;
                        }
                        if (this.this$0.getIsEdit()) {
                            String userGoalUuid = userGoalData.getUserGoalUuid();
                            if (userGoalUuid != null) {
                                this.this$0.showDeleteConfirmation(userGoalUuid);
                                return;
                            }
                            return;
                        }
                        this.this$0.getGoalsViewModel().setSelectedGoal(userGoalData);
                        GoalsDetailView.Companion companion = GoalsDetailView.INSTANCE;
                        FragmentManager parentFragmentManager = this.this$0.getParentFragmentManager();
                        Intrinsics.checkNotNullExpressionValue(parentFragmentManager, "getParentFragmentManager(...)");
                        companion.show(parentFragmentManager);
                    }
                }, true, false, 8, null);
            }
            FragmentGoalsMainBinding binding3 = getBinding();
            RecyclerView recyclerView3 = binding3 != null ? binding3.rv : null;
            if (recyclerView3 == null) {
                return;
            }
            GoalsAdapter goalsAdapter2 = this.goalsAdapter;
            if (goalsAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("goalsAdapter");
            } else {
                goalsAdapter = goalsAdapter2;
            }
            recyclerView3.setAdapter(goalsAdapter);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateGoalsData(List<UserGoalData> goalsList) {
        ArrayList arrayList = new ArrayList();
        for (Object obj : goalsList) {
            if (!Intrinsics.areEqual(String.valueOf(((UserGoalData) obj).getMachineCategoryType()), MachineType.SRVO.getApiCatalogType())) {
                arrayList.add(obj);
            }
        }
        List mutableList = CollectionsKt.toMutableList((Collection) arrayList);
        List list = mutableList;
        if ((list instanceof Collection) && list.isEmpty()) {
            mutableList.add(0, new UserGoalData("addGoal", null, null, null, null, null, null, null, null, null, null, null, 4094, null));
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                if (Intrinsics.areEqual(((UserGoalData) it.next()).getUserGoalUuid(), "addGoal")) {
                    break;
                }
            }
            mutableList.add(0, new UserGoalData("addGoal", null, null, null, null, null, null, null, null, null, null, null, 4094, null));
        }
        GoalsAdapter goalsAdapter = this.goalsAdapter;
        if (goalsAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("goalsAdapter");
            goalsAdapter = null;
        }
        goalsAdapter.submitList(mutableList);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showDeleteConfirmation(final String userGoalId) {
        CustomDialogKt.showCustomDialog$default(this, getString(R.string.delete_goal_title), getString(R.string.delete_goal_desc), getString(R.string.confirm), getString(R.string.cancel), new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.goals.GoalsMainFragment.showDeleteConfirmation.1
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
                Timber.INSTANCE.d("Delete!! :" + userGoalId, new Object[0]);
                this.deleteGoal(userGoalId);
            }
        }, null, false, 96, null);
    }

    /* compiled from: GoalsMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.goals.GoalsMainFragment$deleteGoal$1", f = "GoalsMainFragment.kt", i = {}, l = {200}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.goals.GoalsMainFragment$deleteGoal$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $userGoalId;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$userGoalId = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GoalsMainFragment.this.new AnonymousClass1(this.$userGoalId, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: GoalsMainFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.goals.GoalsMainFragment$deleteGoal$1$1", f = "GoalsMainFragment.kt", i = {}, l = {203}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.goals.GoalsMainFragment$deleteGoal$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $userGoalId;
            int label;
            final /* synthetic */ GoalsMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02481(GoalsMainFragment goalsMainFragment, String str, Continuation<? super C02481> continuation) {
                super(2, continuation);
                this.this$0 = goalsMainFragment;
                this.$userGoalId = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02481(this.this$0, this.$userGoalId, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02481) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                DeleteUserGoalApiData.DataMap dataMap;
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                try {
                    try {
                        if (i == 0) {
                            ResultKt.throwOnFailure(obj);
                            this.this$0.showLoading();
                            this.label = 1;
                            obj = DyacoApiKt.callDeleteUserGoal(new DeleteUserGoalApiData.RequestBodyData(this.$userGoalId), this);
                            if (obj == coroutine_suspended) {
                                return coroutine_suspended;
                            }
                        } else {
                            if (i != 1) {
                                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                            }
                            ResultKt.throwOnFailure(obj);
                        }
                        Response response = (Response) obj;
                        DeleteUserGoalApiData.ResponseData responseData = (DeleteUserGoalApiData.ResponseData) response.body();
                        List<UserGoalData> data = (responseData == null || (dataMap = responseData.getDataMap()) == null) ? null : dataMap.getData();
                        DeleteUserGoalApiData.ResponseData responseData2 = (DeleteUserGoalApiData.ResponseData) response.body();
                        String errorCode = responseData2 != null ? responseData2.getErrorCode() : null;
                        Timber.INSTANCE.d("callDeleteUserGoal: " + data, new Object[0]);
                        DeleteUserGoalApiData.ResponseData responseData3 = (DeleteUserGoalApiData.ResponseData) response.body();
                        if (responseData3 == null || !responseData3.getSuccess()) {
                            if (this.this$0.shouldIgnoreError(errorCode)) {
                                return Unit.INSTANCE;
                            }
                            Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), null), TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required)), TuplesKt.to(ErrorCode.DATA_NOT_FOUND_108.getId(), Boxing.boxInt(R.string.err_108_data_not_found)), TuplesKt.to(ErrorCode.NOT_OWNER_1022.getId(), Boxing.boxInt(R.string.err_1022_operation_requires_resource_ownership))).get(errorCode);
                            if (num != null) {
                                GoalsMainFragment goalsMainFragment = this.this$0;
                                CustomDialogKt.showCustomDialog$default(goalsMainFragment, null, goalsMainFragment.getString(num.intValue()), this.this$0.getString(R.string.confirm), null, null, null, false, 112, null);
                            } else {
                                GoalsMainFragment goalsMainFragment2 = this.this$0;
                                DeleteUserGoalApiData.ResponseData responseData4 = (DeleteUserGoalApiData.ResponseData) response.body();
                                BaseFragment.handleUndefinedError$default(goalsMainFragment2, "deleteGoal", errorCode, responseData4 != null ? responseData4.getErrorMessage() : null, false, 8, null);
                            }
                        } else {
                            Timber.INSTANCE.d("callDeleteUserGoal: success", new Object[0]);
                            this.this$0.getGoalsViewModel().deleteGoalFromGoalsList(this.$userGoalId);
                            SnackbarUtils.dismiss();
                        }
                    } catch (IOException e) {
                        String message = e.getMessage();
                        if (message == null) {
                            message = e.getClass().getSimpleName();
                        }
                        BaseFragment.handleApiError$default(this.this$0, "deleteGoal", message, false, 4, null);
                    }
                    this.this$0.stopLoading();
                    return Unit.INSTANCE;
                } finally {
                    this.this$0.stopLoading();
                }
            }
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (RepeatOnLifecycleKt.repeatOnLifecycle(GoalsMainFragment.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new C02481(GoalsMainFragment.this, this.$userGoalId, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final void deleteGoal(String userGoalId) {
        Intrinsics.checkNotNullParameter(userGoalId, "userGoalId");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(userGoalId, null), 3, null);
    }

    /* compiled from: GoalsMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.goals.GoalsMainFragment$getGoalsData$1", f = "GoalsMainFragment.kt", i = {}, l = {262}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.goals.GoalsMainFragment$getGoalsData$1, reason: invalid class name and case insensitive filesystem */
    static final class C09681 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09681(Continuation<? super C09681> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return GoalsMainFragment.this.new C09681(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09681) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SwipeRefreshLayout swipeRefreshLayout;
            GetMyUserGoalListApiData.DataMap dataMap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        obj = DyacoApiKt.callGetMyUserGoalList(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    Response response = (Response) obj;
                    GetMyUserGoalListApiData.ResponseData responseData = (GetMyUserGoalListApiData.ResponseData) response.body();
                    List<UserGoalData> data = (responseData == null || (dataMap = responseData.getDataMap()) == null) ? null : dataMap.getData();
                    GetMyUserGoalListApiData.ResponseData responseData2 = (GetMyUserGoalListApiData.ResponseData) response.body();
                    String errorCode = responseData2 != null ? responseData2.getErrorCode() : null;
                    Timber.INSTANCE.d("callGetMyUserGoalList: " + data, new Object[0]);
                    GetMyUserGoalListApiData.ResponseData responseData3 = (GetMyUserGoalListApiData.ResponseData) response.body();
                    if (responseData3 != null && responseData3.getSuccess() && data != null) {
                        Timber.INSTANCE.d("callGetMyUserGoalList: success", new Object[0]);
                        GoalsMainFragment.this.getGoalsViewModel().updateGoalList(data);
                    } else {
                        if (GoalsMainFragment.this.shouldIgnoreError(errorCode)) {
                            Unit unit = Unit.INSTANCE;
                            GoalsMainFragment.this.stopLoading();
                            FragmentGoalsMainBinding fragmentGoalsMainBindingAccess$getBinding = GoalsMainFragment.access$getBinding(GoalsMainFragment.this);
                            swipeRefreshLayout = fragmentGoalsMainBindingAccess$getBinding != null ? fragmentGoalsMainBindingAccess$getBinding.swipeRefreshLayout : null;
                            if (swipeRefreshLayout != null) {
                                swipeRefreshLayout.setRefreshing(false);
                            }
                            return unit;
                        }
                        GoalsMainFragment goalsMainFragment = GoalsMainFragment.this;
                        GetMyUserGoalListApiData.ResponseData responseData4 = (GetMyUserGoalListApiData.ResponseData) response.body();
                        BaseFragment.handleUndefinedError$default(goalsMainFragment, "getGoalsData", errorCode, responseData4 != null ? responseData4.getErrorMessage() : null, false, 8, null);
                    }
                    GoalsMainFragment.this.stopLoading();
                    FragmentGoalsMainBinding fragmentGoalsMainBindingAccess$getBinding2 = GoalsMainFragment.access$getBinding(GoalsMainFragment.this);
                    swipeRefreshLayout = fragmentGoalsMainBindingAccess$getBinding2 != null ? fragmentGoalsMainBindingAccess$getBinding2.swipeRefreshLayout : null;
                } catch (IOException e) {
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(GoalsMainFragment.this, "getGoalsData", message, false, 4, null);
                    GoalsMainFragment.this.stopLoading();
                    FragmentGoalsMainBinding fragmentGoalsMainBindingAccess$getBinding3 = GoalsMainFragment.access$getBinding(GoalsMainFragment.this);
                    swipeRefreshLayout = fragmentGoalsMainBindingAccess$getBinding3 != null ? fragmentGoalsMainBindingAccess$getBinding3.swipeRefreshLayout : null;
                    if (swipeRefreshLayout != null) {
                    }
                }
                if (swipeRefreshLayout != null) {
                    swipeRefreshLayout.setRefreshing(false);
                }
                return Unit.INSTANCE;
            } catch (Throwable th) {
                GoalsMainFragment.this.stopLoading();
                FragmentGoalsMainBinding fragmentGoalsMainBindingAccess$getBinding4 = GoalsMainFragment.access$getBinding(GoalsMainFragment.this);
                swipeRefreshLayout = fragmentGoalsMainBindingAccess$getBinding4 != null ? fragmentGoalsMainBindingAccess$getBinding4.swipeRefreshLayout : null;
                if (swipeRefreshLayout != null) {
                    swipeRefreshLayout.setRefreshing(false);
                }
                throw th;
            }
        }
    }

    private final void getGoalsData() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09681(null), 3, null);
    }
}
