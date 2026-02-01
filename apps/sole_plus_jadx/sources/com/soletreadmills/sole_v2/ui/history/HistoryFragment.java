package com.soletreadmills.sole_v2.ui.history;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.android.SdkConstants;
import com.dyaco.srvo.ui.CustomItemDecoration.HistoryHeaderDecoration;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.UserMonthlyStatisticsBeanData;
import com.soletreadmills.sole_v2._data.UserPersonalBestVoData;
import com.soletreadmills.sole_v2._data.WorkoutViewVo;
import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._data.api.history.DeleteWorkoutApiData;
import com.soletreadmills.sole_v2._data.api.history.GetMyUsedActivityTypesApiData;
import com.soletreadmills.sole_v2._data.api.history.GetUserMonthlyStatisticsApiData;
import com.soletreadmills.sole_v2._data.api.history.HistoryListData;
import com.soletreadmills.sole_v2._data.history.HistoryActivityTypeData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._manager.HealthDataManager;
import com.soletreadmills.sole_v2._manager.SamsungHealthManager;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2._type.HistoryActivityType;
import com.soletreadmills.sole_v2.databinding.FragmentHistoryBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.activity.ActivityViewModel;
import com.soletreadmills.sole_v2.ui.adapter.history.HistoryActivityTypeAdapter;
import com.soletreadmills.sole_v2.ui.adapter.history.HistoryAdapter;
import com.sun.jna.platform.win32.WinError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
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
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: HistoryFragment.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\fH\u0002J\u000e\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u001bJ\u0006\u0010\u001c\u001a\u00020\u0017J\u0006\u0010\u001d\u001a\u00020\u0017J\u001a\u0010\u001e\u001a\u00020\u00022\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0016J\b\u0010#\u001a\u00020\u0017H\u0016J\u0012\u0010$\u001a\u00020\u00172\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u0017H\u0002J\u0010\u0010(\u001a\u00020\u00172\u0006\u0010)\u001a\u00020\u000eH\u0002J\u0016\u0010*\u001a\u00020\u00172\f\u0010+\u001a\b\u0012\u0004\u0012\u00020-0,H\u0002J\u0018\u0010.\u001a\u00020\u00172\u000e\u0010/\u001a\n\u0012\u0004\u0012\u000200\u0018\u00010,H\u0002J\b\u00101\u001a\u00020\u0017H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00062"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/history/HistoryFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentHistoryBinding;", "Landroid/view/View$OnClickListener;", "()V", "activityViewModel", "Lcom/soletreadmills/sole_v2/ui/activity/ActivityViewModel;", "getActivityViewModel", "()Lcom/soletreadmills/sole_v2/ui/activity/ActivityViewModel;", "activityViewModel$delegate", "Lkotlin/Lazy;", "currentCollapseMode", "", "isEdit", "", "()Z", "setEdit", "(Z)V", "isLoading", "setLoading", "page", "totalCount", "changeCollapseMode", "", "collapseMode", "deleteWorkout", "workoutUuid", "", "getMyUsedActivityTypes", "getUserMonthlyStatisticsApiData", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "refreshData", "setEditView", TypedValues.Custom.S_BOOLEAN, "setRVActivityType", "data", "", "Lcom/soletreadmills/sole_v2/_type/HistoryActivityType;", "setRecyclerView", "historyList", "Lcom/soletreadmills/sole_v2/_data/api/history/HistoryListData;", "setupSwipeRefresh", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HistoryFragment extends BaseFragment<FragmentHistoryBinding> implements View.OnClickListener {
    public static final int $stable = 8;

    /* renamed from: activityViewModel$delegate, reason: from kotlin metadata */
    private final Lazy activityViewModel;
    private boolean isEdit;
    private boolean isLoading;
    private int currentCollapseMode = 2;
    private int page = 1;
    private int totalCount = Integer.MAX_VALUE;

    public HistoryFragment() {
        final HistoryFragment historyFragment = this;
        final Function0 function0 = null;
        this.activityViewModel = FragmentViewModelLazyKt.createViewModelLazy(historyFragment, Reflection.getOrCreateKotlinClass(ActivityViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = historyFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = historyFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = historyFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public static final /* synthetic */ FragmentHistoryBinding access$getBinding(HistoryFragment historyFragment) {
        return historyFragment.getBinding();
    }

    /* renamed from: isEdit, reason: from getter */
    public final boolean getIsEdit() {
        return this.isEdit;
    }

    public final void setEdit(boolean z) {
        this.isEdit = z;
    }

    public final ActivityViewModel getActivityViewModel() {
        return (ActivityViewModel) this.activityViewModel.getValue();
    }

    /* renamed from: isLoading, reason: from getter */
    public final boolean getIsLoading() {
        return this.isLoading;
    }

    public final void setLoading(boolean z) {
        this.isLoading = z;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentHistoryBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentHistoryBinding fragmentHistoryBindingInflate = FragmentHistoryBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentHistoryBindingInflate, "inflate(...)");
        return fragmentHistoryBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        TextView textView;
        ImageView imageView;
        AppBarLayout appBarLayout;
        FragmentHistoryBinding binding = getBinding();
        if (binding != null && (appBarLayout = binding.appBarLayout) != null) {
            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryFragment$$ExternalSyntheticLambda1
                @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
                public final void onOffsetChanged(AppBarLayout appBarLayout2, int i) {
                    HistoryFragment.initViews$lambda$0(this.f$0, appBarLayout2, i);
                }
            });
        }
        setupSwipeRefresh();
        FragmentHistoryBinding binding2 = getBinding();
        if (binding2 != null && (imageView = binding2.back) != null) {
            imageView.setOnClickListener(this);
        }
        FragmentHistoryBinding binding3 = getBinding();
        if (binding3 != null && (textView = binding3.edit) != null) {
            textView.setOnClickListener(this);
        }
        setRecyclerView(null);
        if (getActivityViewModel().getHistoryList().isEmpty()) {
            refreshData();
        } else {
            setRecyclerView(getActivityViewModel().getHistoryList());
            getUserMonthlyStatisticsApiData();
        }
        getMyUsedActivityTypes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$0(HistoryFragment this$0, AppBarLayout appBarLayout, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i2 = ((float) Math.abs(i)) / ((float) appBarLayout.getTotalScrollRange()) >= 0.85f ? 1 : 2;
        if (this$0.currentCollapseMode != i2) {
            this$0.changeCollapseMode(i2);
            this$0.currentCollapseMode = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        TextView textView;
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
        int i2 = R.id.edit;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            boolean z = this.isEdit;
            this.isEdit = !z;
            if (!z) {
                FragmentHistoryBinding binding = getBinding();
                textView = binding != null ? binding.edit : null;
                if (textView != null) {
                    textView.setText(getString(R.string.done));
                }
                setEditView(this.isEdit);
                return;
            }
            FragmentHistoryBinding binding2 = getBinding();
            textView = binding2 != null ? binding2.edit : null;
            if (textView != null) {
                textView.setText(getString(R.string.edit));
            }
            setEditView(this.isEdit);
        }
    }

    private final void setEditView(boolean z) {
        RecyclerView recyclerView;
        FragmentHistoryBinding binding = getBinding();
        RecyclerView.Adapter adapter = (binding == null || (recyclerView = binding.recyclerview) == null) ? null : recyclerView.getAdapter();
        if (adapter instanceof HistoryAdapter) {
            HistoryAdapter historyAdapter = (HistoryAdapter) adapter;
            List<HistoryListData> currentList = historyAdapter.getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
            for (HistoryListData historyListData : currentList) {
                if (z) {
                    historyListData.setEdit(true);
                } else {
                    historyListData.setEdit(false);
                }
            }
            historyAdapter.notifyItemRangeChanged(0, currentList.size());
        }
    }

    private final void changeCollapseMode(int collapseMode) {
        Toolbar toolbar;
        FragmentHistoryBinding binding = getBinding();
        ViewGroup.LayoutParams layoutParams = (binding == null || (toolbar = binding.collapsingToolbar) == null) ? null : toolbar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams");
        CollapsingToolbarLayout.LayoutParams layoutParams2 = (CollapsingToolbarLayout.LayoutParams) layoutParams;
        layoutParams2.setCollapseMode(collapseMode);
        FragmentHistoryBinding binding2 = getBinding();
        Toolbar toolbar2 = binding2 != null ? binding2.collapsingToolbar : null;
        if (toolbar2 == null) {
            return;
        }
        toolbar2.setLayoutParams(layoutParams2);
    }

    private final void setupSwipeRefresh() {
        SwipeRefreshLayout swipeRefreshLayout;
        SwipeRefreshLayout swipeRefreshLayout2;
        FragmentHistoryBinding binding = getBinding();
        if (binding != null && (swipeRefreshLayout2 = binding.swipeRefreshLayout) != null) {
            swipeRefreshLayout2.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryFragment$$ExternalSyntheticLambda0
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    HistoryFragment.setupSwipeRefresh$lambda$1(this.f$0);
                }
            });
        }
        FragmentHistoryBinding binding2 = getBinding();
        if (binding2 == null || (swipeRefreshLayout = binding2.swipeRefreshLayout) == null) {
            return;
        }
        swipeRefreshLayout.setColorSchemeResources(R.color.colorGlobal_accent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupSwipeRefresh$lambda$1(HistoryFragment this$0) {
        RecyclerView recyclerView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.refreshData();
        FragmentHistoryBinding binding = this$0.getBinding();
        RecyclerView.Adapter adapter = (binding == null || (recyclerView = binding.recyclerview) == null) ? null : recyclerView.getAdapter();
        if (adapter instanceof HistoryAdapter) {
            ((HistoryAdapter) adapter).setShowFooter(false);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshData() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        this.page = 1;
        this.totalCount = Integer.MAX_VALUE;
        FragmentHistoryBinding binding = getBinding();
        if (binding != null && (recyclerView2 = binding.recyclerview) != null) {
            recyclerView2.scrollToPosition(0);
        }
        FragmentHistoryBinding binding2 = getBinding();
        RecyclerView.Adapter adapter = (binding2 == null || (recyclerView = binding2.recyclerview) == null) ? null : recyclerView.getAdapter();
        if (adapter instanceof HistoryAdapter) {
            ((HistoryAdapter) adapter).submitList(CollectionsKt.emptyList());
        }
        getUserMonthlyStatisticsApiData();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRecyclerView(List<HistoryListData> historyList) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        RecyclerView recyclerView4;
        RecyclerView recyclerView5;
        FragmentHistoryBinding binding = getBinding();
        RecyclerView.Adapter adapter = null;
        if (!(((binding == null || (recyclerView5 = binding.recyclerview) == null) ? null : recyclerView5.getLayoutManager()) instanceof LinearLayoutManager)) {
            FragmentHistoryBinding binding2 = getBinding();
            RecyclerView recyclerView6 = binding2 != null ? binding2.recyclerview : null;
            if (recyclerView6 != null) {
                recyclerView6.setLayoutManager(new LinearLayoutManager(getActivity()));
            }
        }
        FragmentHistoryBinding binding3 = getBinding();
        RecyclerView recyclerView7 = binding3 != null ? binding3.recyclerview : null;
        if (recyclerView7 != null) {
            recyclerView7.setItemAnimator(null);
        }
        FragmentHistoryBinding binding4 = getBinding();
        if (!(((binding4 == null || (recyclerView4 = binding4.recyclerview) == null) ? null : recyclerView4.getAdapter()) instanceof HistoryAdapter)) {
            HistoryAdapter historyAdapter = new HistoryAdapter(new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryFragment$setRecyclerView$adapter$1
                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos) {
                    String userWorkoutUuid;
                    RecyclerView recyclerView8;
                    if (this.this$0.getIsEdit()) {
                        return;
                    }
                    FragmentHistoryBinding fragmentHistoryBindingAccess$getBinding = HistoryFragment.access$getBinding(this.this$0);
                    RecyclerView.Adapter adapter2 = (fragmentHistoryBindingAccess$getBinding == null || (recyclerView8 = fragmentHistoryBindingAccess$getBinding.recyclerview) == null) ? null : recyclerView8.getAdapter();
                    if (adapter2 instanceof HistoryAdapter) {
                        List<HistoryListData> currentList = ((HistoryAdapter) adapter2).getCurrentList();
                        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                        HistoryListData historyListData = currentList.get(pos);
                        Bundle bundle = new Bundle();
                        WorkoutViewVo workoutData = historyListData.getWorkoutData();
                        if (workoutData == null || (userWorkoutUuid = workoutData.getUserWorkoutUuid()) == null) {
                            userWorkoutUuid = "";
                        }
                        bundle.putString("workoutUuid", userWorkoutUuid);
                        bundle.putBoolean("isBest", historyListData.isBest());
                        this.this$0.safeNavigate(R.id.historyWorkoutFragment, bundle);
                    }
                }

                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos, String string) {
                    RecyclerView recyclerView8;
                    Intrinsics.checkNotNullParameter(string, "string");
                    FragmentHistoryBinding fragmentHistoryBindingAccess$getBinding = HistoryFragment.access$getBinding(this.this$0);
                    RecyclerView.Adapter adapter2 = (fragmentHistoryBindingAccess$getBinding == null || (recyclerView8 = fragmentHistoryBindingAccess$getBinding.recyclerview) == null) ? null : recyclerView8.getAdapter();
                    if (adapter2 instanceof HistoryAdapter) {
                        List<HistoryListData> currentList = ((HistoryAdapter) adapter2).getCurrentList();
                        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                        final HistoryListData historyListData = currentList.get(pos);
                        if (Intrinsics.areEqual(string, "delete")) {
                            HistoryFragment historyFragment = this.this$0;
                            String string2 = historyFragment.getString(R.string.delete_workout);
                            String string3 = this.this$0.getString(R.string.hint_27);
                            String string4 = this.this$0.getString(R.string.delete);
                            String string5 = this.this$0.getString(R.string.cancel);
                            final HistoryFragment historyFragment2 = this.this$0;
                            CustomDialogKt.showCustomDialog$default(historyFragment, string2, string3, string4, string5, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryFragment$setRecyclerView$adapter$1$onClick$1
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
                                    historyFragment2.deleteWorkout(historyListData.getId());
                                }
                            }, null, false, 96, null);
                        }
                    }
                }
            });
            FragmentHistoryBinding binding5 = getBinding();
            RecyclerView recyclerView8 = binding5 != null ? binding5.recyclerview : null;
            if (recyclerView8 != null) {
                recyclerView8.setAdapter(historyAdapter);
            }
            FragmentHistoryBinding binding6 = getBinding();
            if (binding6 != null && (recyclerView3 = binding6.recyclerview) != null) {
                recyclerView3.addItemDecoration(new HistoryHeaderDecoration(historyAdapter));
            }
            FragmentHistoryBinding binding7 = getBinding();
            if (binding7 != null && (recyclerView2 = binding7.recyclerview) != null) {
                recyclerView2.addOnScrollListener(new RecyclerView.OnScrollListener() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryFragment.setRecyclerView.1
                    @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
                    public void onScrolled(RecyclerView recyclerView9, int dx, int dy) {
                        FragmentHistoryBinding fragmentHistoryBindingAccess$getBinding;
                        SwipeRefreshLayout swipeRefreshLayout;
                        Intrinsics.checkNotNullParameter(recyclerView9, "recyclerView");
                        super.onScrolled(recyclerView9, dx, dy);
                        RecyclerView.LayoutManager layoutManager = recyclerView9.getLayoutManager();
                        LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
                        if (linearLayoutManager != null) {
                            HistoryFragment historyFragment = HistoryFragment.this;
                            int itemCount = linearLayoutManager.getItemCount();
                            if (linearLayoutManager.findLastVisibleItemPosition() < itemCount - 3 || itemCount <= 0 || historyFragment.getIsLoading() || (fragmentHistoryBindingAccess$getBinding = HistoryFragment.access$getBinding(historyFragment)) == null || (swipeRefreshLayout = fragmentHistoryBindingAccess$getBinding.swipeRefreshLayout) == null || swipeRefreshLayout.isRefreshing() || dy <= 0) {
                                return;
                            }
                            historyFragment.getUserMonthlyStatisticsApiData();
                        }
                    }
                });
            }
        }
        FragmentHistoryBinding binding8 = getBinding();
        if (binding8 != null && (recyclerView = binding8.recyclerview) != null) {
            adapter = recyclerView.getAdapter();
        }
        if (adapter instanceof HistoryAdapter) {
            ((HistoryAdapter) adapter).submitList(historyList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRVActivityType(List<? extends HistoryActivityType> data) {
        boolean z;
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        FragmentHistoryBinding binding = getBinding();
        RecyclerView.Adapter adapter = null;
        if (!(((binding == null || (recyclerView3 = binding.rvActivityType) == null) ? null : recyclerView3.getLayoutManager()) instanceof LinearLayoutManager)) {
            FragmentHistoryBinding binding2 = getBinding();
            RecyclerView recyclerView4 = binding2 != null ? binding2.rvActivityType : null;
            if (recyclerView4 != null) {
                recyclerView4.setLayoutManager(new LinearLayoutManager(getActivity(), 0, false));
            }
        }
        FragmentHistoryBinding binding3 = getBinding();
        RecyclerView recyclerView5 = binding3 != null ? binding3.rvActivityType : null;
        if (recyclerView5 != null) {
            recyclerView5.setItemAnimator(null);
        }
        FragmentHistoryBinding binding4 = getBinding();
        if (!(((binding4 == null || (recyclerView2 = binding4.rvActivityType) == null) ? null : recyclerView2.getAdapter()) instanceof HistoryActivityTypeAdapter)) {
            HistoryActivityTypeAdapter historyActivityTypeAdapter = new HistoryActivityTypeAdapter(new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryFragment$setRVActivityType$adapter$1
                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos, String string) {
                    Intrinsics.checkNotNullParameter(string, "string");
                }

                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos) {
                    RecyclerView recyclerView6;
                    FragmentHistoryBinding fragmentHistoryBindingAccess$getBinding = HistoryFragment.access$getBinding(this.this$0);
                    RecyclerView.Adapter adapter2 = (fragmentHistoryBindingAccess$getBinding == null || (recyclerView6 = fragmentHistoryBindingAccess$getBinding.rvActivityType) == null) ? null : recyclerView6.getAdapter();
                    if (adapter2 instanceof HistoryActivityTypeAdapter) {
                        HistoryActivityTypeAdapter historyActivityTypeAdapter2 = (HistoryActivityTypeAdapter) adapter2;
                        List<HistoryActivityTypeData> currentList = historyActivityTypeAdapter2.getCurrentList();
                        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                        List mutableList = CollectionsKt.toMutableList((Collection) currentList);
                        HistoryActivityTypeData historyActivityTypeData = (HistoryActivityTypeData) mutableList.get(pos);
                        int i = 0;
                        for (Object obj : mutableList) {
                            int i2 = i + 1;
                            if (i < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            HistoryActivityTypeData historyActivityTypeData2 = (HistoryActivityTypeData) obj;
                            Intrinsics.checkNotNull(historyActivityTypeData2);
                            mutableList.set(i, HistoryActivityTypeData.copy$default(historyActivityTypeData2, null, i == pos, 1, null));
                            i = i2;
                        }
                        historyActivityTypeAdapter2.submitList(mutableList);
                        this.this$0.getActivityViewModel().setSelectActivityType(historyActivityTypeData.getHistoryActivityType().getCode());
                        this.this$0.refreshData();
                    }
                }
            });
            FragmentHistoryBinding binding5 = getBinding();
            RecyclerView recyclerView6 = binding5 != null ? binding5.rvActivityType : null;
            if (recyclerView6 != null) {
                recyclerView6.setAdapter(historyActivityTypeAdapter);
            }
        }
        ArrayList arrayList = new ArrayList();
        Iterator<? extends HistoryActivityType> it = data.iterator();
        while (it.hasNext()) {
            HistoryActivityTypeData historyActivityTypeData = new HistoryActivityTypeData(it.next(), false, 2, null);
            if (historyActivityTypeData.getHistoryActivityType().getCode() == getActivityViewModel().getSelectActivityType()) {
                historyActivityTypeData.setSelect(true);
            }
            arrayList.add(historyActivityTypeData);
        }
        ArrayList arrayList2 = arrayList;
        if ((arrayList2 instanceof Collection) && arrayList2.isEmpty()) {
            z = false;
        } else {
            Iterator it2 = arrayList2.iterator();
            while (it2.hasNext()) {
                if (((HistoryActivityTypeData) it2.next()).isSelect()) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        arrayList.add(0, new HistoryActivityTypeData(HistoryActivityType.ALL, !z));
        if (arrayList.size() <= 2) {
            FragmentHistoryBinding binding6 = getBinding();
            RecyclerView recyclerView7 = binding6 != null ? binding6.rvActivityType : null;
            if (recyclerView7 != null) {
                recyclerView7.setVisibility(8);
            }
        } else {
            FragmentHistoryBinding binding7 = getBinding();
            RecyclerView recyclerView8 = binding7 != null ? binding7.rvActivityType : null;
            if (recyclerView8 != null) {
                recyclerView8.setVisibility(0);
            }
        }
        FragmentHistoryBinding binding8 = getBinding();
        if (binding8 != null && (recyclerView = binding8.rvActivityType) != null) {
            adapter = recyclerView.getAdapter();
        }
        if (adapter instanceof HistoryActivityTypeAdapter) {
            ((HistoryActivityTypeAdapter) adapter).submitList(arrayList);
        }
    }

    public final void getUserMonthlyStatisticsApiData() {
        RecyclerView recyclerView;
        if (this.isLoading) {
            return;
        }
        FragmentHistoryBinding binding = getBinding();
        RecyclerView.Adapter adapter = (binding == null || (recyclerView = binding.recyclerview) == null) ? null : recyclerView.getAdapter();
        if (adapter instanceof HistoryAdapter) {
            HistoryAdapter historyAdapter = (HistoryAdapter) adapter;
            List<HistoryListData> currentList = historyAdapter.getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
            if (currentList.size() > this.totalCount) {
                FragmentHistoryBinding binding2 = getBinding();
                SwipeRefreshLayout swipeRefreshLayout = binding2 != null ? binding2.swipeRefreshLayout : null;
                if (swipeRefreshLayout != null) {
                    swipeRefreshLayout.setRefreshing(false);
                }
                historyAdapter.setShowFooter(true);
                return;
            }
        }
        this.isLoading = true;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C09711(null), 3, null);
    }

    /* compiled from: HistoryFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.history.HistoryFragment$getUserMonthlyStatisticsApiData$1", f = "HistoryFragment.kt", i = {}, l = {398}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.history.HistoryFragment$getUserMonthlyStatisticsApiData$1, reason: invalid class name and case insensitive filesystem */
    static final class C09711 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09711(Continuation<? super C09711> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HistoryFragment.this.new C09711(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09711) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            SwipeRefreshLayout swipeRefreshLayout;
            Object objCallGetUserMonthlyStatisticsApiData;
            char c;
            int i;
            boolean z;
            boolean z2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            try {
                try {
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        HistoryFragment.this.showLoading();
                        GetUserMonthlyStatisticsApiData.RequestBodyData requestBodyData = HistoryFragment.this.getActivityViewModel().getSelectActivityType() == 0 ? new GetUserMonthlyStatisticsApiData.RequestBodyData(Boxing.boxBoolean(false), null, null, null, null, null, null, null, Boxing.boxInt(100), Boxing.boxInt(HistoryFragment.this.page), 254, null) : new GetUserMonthlyStatisticsApiData.RequestBodyData(Boxing.boxBoolean(true), CollectionsKt.mutableListOf(Boxing.boxInt(HistoryFragment.this.getActivityViewModel().getSelectActivityType())), null, null, null, null, null, null, Boxing.boxInt(100), Boxing.boxInt(HistoryFragment.this.page), 252, null);
                        this.label = 1;
                        objCallGetUserMonthlyStatisticsApiData = DyacoApiKt.callGetUserMonthlyStatisticsApiData(requestBodyData, this);
                        if (objCallGetUserMonthlyStatisticsApiData == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        objCallGetUserMonthlyStatisticsApiData = obj;
                    }
                    GetUserMonthlyStatisticsApiData.ResponseData responseData = (GetUserMonthlyStatisticsApiData.ResponseData) ((Response) objCallGetUserMonthlyStatisticsApiData).body();
                    if (responseData == null || !responseData.getSuccess()) {
                        String errorCode = responseData != null ? responseData.getErrorCode() : null;
                        if (HistoryFragment.this.shouldIgnoreError(errorCode)) {
                            Unit unit = Unit.INSTANCE;
                            HistoryFragment.this.stopLoading();
                            HistoryFragment.this.setLoading(false);
                            FragmentHistoryBinding fragmentHistoryBindingAccess$getBinding = HistoryFragment.access$getBinding(HistoryFragment.this);
                            SwipeRefreshLayout swipeRefreshLayout2 = fragmentHistoryBindingAccess$getBinding != null ? fragmentHistoryBindingAccess$getBinding.swipeRefreshLayout : null;
                            if (swipeRefreshLayout2 != null) {
                                swipeRefreshLayout2.setRefreshing(false);
                            }
                            return unit;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.err_113)), TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), Boxing.boxInt(R.string.error))).get(errorCode);
                        if (num != null) {
                            HistoryFragment historyFragment = HistoryFragment.this;
                            CustomDialogKt.showCustomDialog$default(historyFragment, historyFragment.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                        } else {
                            BaseFragment.handleUndefinedError$default(HistoryFragment.this, "getUserMonthlyStatisticsApiData", errorCode, responseData != null ? responseData.getErrorMessage() : null, false, 8, null);
                        }
                    } else {
                        GetUserMonthlyStatisticsApiData.DataMap dataMap = responseData.getDataMap();
                        List<UserMonthlyStatisticsBeanData> data = dataMap != null ? dataMap.getData() : null;
                        HistoryFragment historyFragment2 = HistoryFragment.this;
                        GetUserMonthlyStatisticsApiData.DataMap dataMap2 = responseData.getDataMap();
                        historyFragment2.totalCount = dataMap2 != null ? dataMap2.getTotalCount() : Integer.MAX_VALUE;
                        List<UserPersonalBestVoData> userPersonalBestVoDataValue = HistoryFragment.this.getActivityViewModel().getUserPersonalBestVoDataValue();
                        final ArrayList arrayList = new ArrayList();
                        if (HistoryFragment.this.page > 1) {
                            arrayList.addAll(HistoryFragment.this.getActivityViewModel().getHistoryList());
                        }
                        LinkedHashMap linkedHashMap = new LinkedHashMap();
                        ArrayList arrayList2 = new ArrayList();
                        for (Object obj2 : arrayList) {
                            if (!((HistoryListData) obj2).isHeader()) {
                                arrayList2.add(obj2);
                            }
                        }
                        Iterator it = arrayList2.iterator();
                        while (true) {
                            c = 26376;
                            if (!it.hasNext()) {
                                break;
                            }
                            HistoryListData historyListData = (HistoryListData) it.next();
                            String str = historyListData.getYear() + "年 " + historyListData.getMonth() + (char) 26376;
                            Integer num2 = (Integer) linkedHashMap.get(str);
                            linkedHashMap.put(str, Boxing.boxInt((num2 != null ? num2.intValue() : 0) + 1));
                        }
                        if (data != null) {
                            HistoryFragment historyFragment3 = HistoryFragment.this;
                            for (UserMonthlyStatisticsBeanData userMonthlyStatisticsBeanData : data) {
                                String str2 = userMonthlyStatisticsBeanData.getYear() + "年 " + userMonthlyStatisticsBeanData.getMonth() + c;
                                List<WorkoutViewVo> workoutList = userMonthlyStatisticsBeanData.getWorkoutList();
                                int size = workoutList != null ? workoutList.size() : 0;
                                Integer num3 = (Integer) linkedHashMap.get(str2);
                                linkedHashMap.put(str2, Boxing.boxInt((num3 != null ? num3.intValue() : 0) + size));
                                Integer num4 = (Integer) linkedHashMap.get(str2);
                                int iIntValue = num4 != null ? num4.intValue() : 0;
                                Iterator it2 = arrayList.iterator();
                                int i3 = 0;
                                while (true) {
                                    if (!it2.hasNext()) {
                                        i = -1;
                                        break;
                                    }
                                    HistoryListData historyListData2 = (HistoryListData) it2.next();
                                    if (historyListData2.isHeader() && Intrinsics.areEqual(historyListData2.getId(), str2)) {
                                        i = i3;
                                        break;
                                    }
                                    i3++;
                                }
                                if (i != -1) {
                                    HistoryListData historyListData3 = (HistoryListData) arrayList.get(i);
                                    arrayList.set(i, historyListData3.copy((511 & 1) != 0 ? historyListData3.id : null, (511 & 2) != 0 ? historyListData3.year : null, (511 & 4) != 0 ? historyListData3.month : null, (511 & 8) != 0 ? historyListData3.activeHours : null, (511 & 16) != 0 ? historyListData3.totalCalories : null, (511 & 32) != 0 ? historyListData3.totalSize : Boxing.boxInt(iIntValue), (511 & 64) != 0 ? historyListData3.isHeader : false, (511 & 128) != 0 ? historyListData3.workoutData : null, (511 & 256) != 0 ? historyListData3.isEdit : false, (511 & 512) != 0 ? historyListData3.isBest : false));
                                    int size2 = arrayList.size();
                                    for (int i4 = 0; i4 < size2; i4++) {
                                        HistoryListData historyListData4 = (HistoryListData) arrayList.get(i4);
                                        if (!historyListData4.isHeader() && Intrinsics.areEqual(historyListData4.getYear(), userMonthlyStatisticsBeanData.getYear()) && Intrinsics.areEqual(historyListData4.getMonth(), userMonthlyStatisticsBeanData.getMonth())) {
                                            arrayList.set(i4, historyListData4.copy((511 & 1) != 0 ? historyListData4.id : null, (511 & 2) != 0 ? historyListData4.year : null, (511 & 4) != 0 ? historyListData4.month : null, (511 & 8) != 0 ? historyListData4.activeHours : null, (511 & 16) != 0 ? historyListData4.totalCalories : null, (511 & 32) != 0 ? historyListData4.totalSize : Boxing.boxInt(iIntValue), (511 & 64) != 0 ? historyListData4.isHeader : false, (511 & 128) != 0 ? historyListData4.workoutData : null, (511 & 256) != 0 ? historyListData4.isEdit : false, (511 & 512) != 0 ? historyListData4.isBest : false));
                                        }
                                    }
                                } else {
                                    arrayList.add(new HistoryListData(str2, userMonthlyStatisticsBeanData.getYear(), userMonthlyStatisticsBeanData.getMonth(), userMonthlyStatisticsBeanData.getActiveHours(), userMonthlyStatisticsBeanData.getTotalCalories(), Boxing.boxInt(iIntValue), true, null, false, false, 768, null));
                                }
                                List<WorkoutViewVo> workoutList2 = userMonthlyStatisticsBeanData.getWorkoutList();
                                if (workoutList2 != null) {
                                    Iterator<T> it3 = workoutList2.iterator();
                                    while (it3.hasNext()) {
                                        for (WorkoutViewVo workoutViewVo : ((WorkoutViewVo) it3.next()).expand()) {
                                            if (userPersonalBestVoDataValue != null) {
                                                List<UserPersonalBestVoData> list = userPersonalBestVoDataValue;
                                                if ((list instanceof Collection) && list.isEmpty()) {
                                                    z2 = false;
                                                    z = z2;
                                                } else {
                                                    Iterator<T> it4 = list.iterator();
                                                    while (it4.hasNext()) {
                                                        if (Intrinsics.areEqual(((UserPersonalBestVoData) it4.next()).getCurrentBestUserWorkoutUuid(), workoutViewVo.getUserWorkoutUuid())) {
                                                            z2 = true;
                                                            break;
                                                        }
                                                    }
                                                    z2 = false;
                                                    z = z2;
                                                }
                                            } else {
                                                z = false;
                                            }
                                            String userWorkoutUuid = workoutViewVo.getUserWorkoutUuid();
                                            if (userWorkoutUuid == null) {
                                                userWorkoutUuid = "";
                                            }
                                            arrayList.add(new HistoryListData(userWorkoutUuid, userMonthlyStatisticsBeanData.getYear(), userMonthlyStatisticsBeanData.getMonth(), null, null, Boxing.boxInt(iIntValue), false, workoutViewVo, historyFragment3.getIsEdit(), z, 24, null));
                                        }
                                    }
                                    Unit unit2 = Unit.INSTANCE;
                                }
                                c = 26376;
                            }
                            Unit unit3 = Unit.INSTANCE;
                        }
                        HistoryFragment.this.setRecyclerView(arrayList);
                        HistoryFragment.this.getActivityViewModel().setHistoryList(arrayList);
                        HealthDataManager healthDataManager = new HealthDataManager();
                        MainActivity mainActivity = HistoryFragment.this.getMainActivity();
                        if (mainActivity != null) {
                            healthDataManager.writeData(mainActivity, arrayList);
                            Unit unit4 = Unit.INSTANCE;
                        }
                        final MainActivity mainActivity2 = HistoryFragment.this.getMainActivity();
                        if (mainActivity2 != null) {
                            SamsungHealthManager.Companion companion = SamsungHealthManager.INSTANCE;
                            Context applicationContext = mainActivity2.getApplicationContext();
                            Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                            final SamsungHealthManager companion2 = companion.getInstance(applicationContext);
                            if (!companion2.isSamsungHealthInstalled(mainActivity2) || !companion2.checkSamsungHealthPermissions()) {
                                Timber.INSTANCE.tag("SamsungHealth").d("SamsungHealth 未安裝/尚未授權", new Object[0]);
                            } else if (companion2.checkSamsungHealthConnect()) {
                                Timber.INSTANCE.tag("SamsungHealth").d("SamsungHealth 已經連過", new Object[0]);
                                companion2.writeData(mainActivity2, arrayList);
                            } else {
                                Timber.INSTANCE.tag("SamsungHealth").d("SamsungHealth 尚未連過", new Object[0]);
                                companion2.connectHealthData(mainActivity2, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryFragment$getUserMonthlyStatisticsApiData$1$5$1
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
                                        companion2.writeData(mainActivity2, arrayList);
                                    }
                                });
                            }
                            Unit unit5 = Unit.INSTANCE;
                        }
                        HistoryFragment.this.page++;
                    }
                    HistoryFragment.this.stopLoading();
                    HistoryFragment.this.setLoading(false);
                    FragmentHistoryBinding fragmentHistoryBindingAccess$getBinding2 = HistoryFragment.access$getBinding(HistoryFragment.this);
                    swipeRefreshLayout = fragmentHistoryBindingAccess$getBinding2 != null ? fragmentHistoryBindingAccess$getBinding2.swipeRefreshLayout : null;
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(HistoryFragment.this, "getUserMonthlyStatisticsApiData", message, false, 4, null);
                    HistoryFragment.this.stopLoading();
                    HistoryFragment.this.setLoading(false);
                    FragmentHistoryBinding fragmentHistoryBindingAccess$getBinding3 = HistoryFragment.access$getBinding(HistoryFragment.this);
                    swipeRefreshLayout = fragmentHistoryBindingAccess$getBinding3 != null ? fragmentHistoryBindingAccess$getBinding3.swipeRefreshLayout : null;
                    if (swipeRefreshLayout != null) {
                    }
                }
                if (swipeRefreshLayout != null) {
                    swipeRefreshLayout.setRefreshing(false);
                }
                return Unit.INSTANCE;
            } finally {
            }
        }
    }

    /* compiled from: HistoryFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.history.HistoryFragment$deleteWorkout$1", f = "HistoryFragment.kt", i = {}, l = {WinError.ERROR_ILLEGAL_FLOAT_CONTEXT}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.history.HistoryFragment$deleteWorkout$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $workoutUuid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$workoutUuid = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HistoryFragment.this.new AnonymousClass1(this.$workoutUuid, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            MainActivity mainActivity;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        MainActivity mainActivity2 = HistoryFragment.this.getMainActivity();
                        if (mainActivity2 != null) {
                            BaseActivity.showLoadDialog$default(mainActivity2, null, 1, null);
                        }
                        this.label = 1;
                        obj = DyacoApiKt.callDeleteWorkoutApiData(new DeleteWorkoutApiData.RequestBodyData(this.$workoutUuid), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    DeleteWorkoutApiData.ResponseData responseData = (DeleteWorkoutApiData.ResponseData) ((Response) obj).body();
                    if (responseData == null || !responseData.getSuccess()) {
                        String errorCode = responseData != null ? responseData.getErrorCode() : null;
                        if (HistoryFragment.this.shouldIgnoreError(errorCode)) {
                            return Unit.INSTANCE;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.err_113)), TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), Boxing.boxInt(R.string.error)), TuplesKt.to(ErrorCode.DATA_NOT_FOUND_108.getId(), Boxing.boxInt(R.string.err_108)), TuplesKt.to(ErrorCode.NOT_OWNER_1022.getId(), Boxing.boxInt(R.string.err_1022))).get(errorCode);
                        if (num != null) {
                            HistoryFragment historyFragment = HistoryFragment.this;
                            CustomDialogKt.showCustomDialog$default(historyFragment, historyFragment.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                        } else {
                            BaseFragment.handleUndefinedError$default(HistoryFragment.this, "deleteWorkout2", errorCode, responseData != null ? responseData.getErrorMessage() : null, false, 8, null);
                        }
                    } else {
                        HistoryFragment.this.refreshData();
                    }
                    mainActivity = HistoryFragment.this.getMainActivity();
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(HistoryFragment.this, "deleteWorkout2", message, false, 4, null);
                    mainActivity = HistoryFragment.this.getMainActivity();
                    if (mainActivity != null) {
                    }
                }
                if (mainActivity != null) {
                    mainActivity.cancelLoadDialog();
                }
                return Unit.INSTANCE;
            } finally {
                MainActivity mainActivity3 = HistoryFragment.this.getMainActivity();
                if (mainActivity3 != null) {
                    mainActivity3.cancelLoadDialog();
                }
            }
        }
    }

    public final void deleteWorkout(String workoutUuid) {
        Intrinsics.checkNotNullParameter(workoutUuid, "workoutUuid");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(workoutUuid, null), 3, null);
    }

    /* compiled from: HistoryFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.history.HistoryFragment$getMyUsedActivityTypes$1", f = "HistoryFragment.kt", i = {}, l = {660}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.history.HistoryFragment$getMyUsedActivityTypes$1, reason: invalid class name and case insensitive filesystem */
    static final class C09701 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09701(Continuation<? super C09701> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HistoryFragment.this.new C09701(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09701) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = DyacoApiKt.callGetMyUsedActivityTypes(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                GetMyUsedActivityTypesApiData.ResponseData responseData = (GetMyUsedActivityTypesApiData.ResponseData) ((Response) obj).body();
                if (responseData != null && responseData.getSuccess()) {
                    HistoryFragment.this.setRVActivityType(responseData.getHistoryActivityTypes());
                } else {
                    String errorCode = responseData != null ? responseData.getErrorCode() : null;
                    if (HistoryFragment.this.shouldIgnoreError(errorCode)) {
                        return Unit.INSTANCE;
                    }
                    Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.err_113)), TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), Boxing.boxInt(R.string.error))).get(errorCode);
                    if (num != null) {
                        HistoryFragment historyFragment = HistoryFragment.this;
                        CustomDialogKt.showCustomDialog$default(historyFragment, historyFragment.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                    } else {
                        BaseFragment.handleUndefinedError$default(HistoryFragment.this, "getMyUsedActivityTypes", errorCode, responseData != null ? responseData.getErrorMessage() : null, false, 8, null);
                    }
                }
            } catch (Exception e) {
                Timber.INSTANCE.e(e);
                String message = e.getMessage();
                if (message == null) {
                    message = e.getClass().getSimpleName();
                }
                BaseFragment.handleApiError$default(HistoryFragment.this, "getMyUsedActivityTypes", message, false, 4, null);
            }
            return Unit.INSTANCE;
        }
    }

    public final void getMyUsedActivityTypes() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09701(null), 3, null);
    }
}
