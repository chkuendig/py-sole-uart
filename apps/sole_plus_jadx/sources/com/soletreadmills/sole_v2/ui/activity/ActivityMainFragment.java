package com.soletreadmills.sole_v2.ui.activity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.dyaco.srvo.ui.CustomItemDecoration.HistoryHeaderDecoration;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IndexAxisValueFormatter;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.UserMonthlyStatisticsBeanData;
import com.soletreadmills.sole_v2._data.UserPersonalBestVoData;
import com.soletreadmills.sole_v2._data.UserStatisticsVoData;
import com.soletreadmills.sole_v2._data.UserWorkout12WeeklyStatsVoData;
import com.soletreadmills.sole_v2._data.WorkoutViewVo;
import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._data.api.activity.GetMyLatest3MonthWorkoutStatsApiData;
import com.soletreadmills.sole_v2._data.api.activity.GetMyLatest6WeeklyActiveTimeApiData;
import com.soletreadmills.sole_v2._data.api.activity.GetMyPersonalBestListApiData;
import com.soletreadmills.sole_v2._data.api.history.GetMyUsedActivityTypesApiData;
import com.soletreadmills.sole_v2._data.api.history.GetMyWorkoutStatisticsApiData;
import com.soletreadmills.sole_v2._data.api.history.GetUserMonthlyStatisticsApiData;
import com.soletreadmills.sole_v2._data.api.history.HistoryListData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._manager.HealthDataManager;
import com.soletreadmills.sole_v2._manager.SamsungHealthManager;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2._tools.ConvertUtils;
import com.soletreadmills.sole_v2._tools.TimeTools;
import com.soletreadmills.sole_v2._tools.UnitConversion;
import com.soletreadmills.sole_v2._type.HistoryActivityType;
import com.soletreadmills.sole_v2._type.TrendsType;
import com.soletreadmills.sole_v2.databinding.CustomSectionItemViewBinding;
import com.soletreadmills.sole_v2.databinding.FragmentActivityMainBinding;
import com.soletreadmills.sole_v2.listener.OnItemClickListener;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.adapter.activity.PersonalBestAdapter;
import com.soletreadmills.sole_v2.ui.adapter.activity.RunningTrendsAdapter;
import com.soletreadmills.sole_v2.ui.adapter.history.HistoryAdapter;
import com.sun.jna.platform.win32.WinError;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.AwaitKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import org.objectweb.asm.Opcodes;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: ActivityMainFragment.kt */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J0\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\b\u0010\u001c\u001a\u0004\u0018\u00010\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\fH\u0002J\b\u0010\"\u001a\u00020\u0016H\u0002J\u000e\u0010#\u001a\u00020\u00162\u0006\u0010\u001e\u001a\u00020\u001fJ\u0006\u0010$\u001a\u00020\u0016J\u0006\u0010%\u001a\u00020\u0016J\u0006\u0010&\u001a\u00020\u0016J\u0006\u0010'\u001a\u00020\u0016J\u0006\u0010(\u001a\u00020\u0016J\u001a\u0010)\u001a\u00020\u00022\u0006\u0010*\u001a\u00020+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020\u0016H\u0016J\u0014\u0010/\u001a\u00020\u00162\f\u00100\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001aJ\u0012\u00101\u001a\u00020\u00162\b\u00102\u001a\u0004\u0018\u000103H\u0016J\u0012\u00104\u001a\u00020\u00162\b\u00105\u001a\u0004\u0018\u000106H\u0016J\u001a\u00107\u001a\u00020\u00162\u0006\u00108\u001a\u0002032\b\u00105\u001a\u0004\u0018\u000106H\u0016J\b\u00109\u001a\u00020\u0016H\u0002J\u0018\u0010:\u001a\u00020\u00162\u000e\u0010;\u001a\n\u0012\u0004\u0012\u00020<\u0018\u00010\u001aH\u0002J\u0018\u0010=\u001a\u00020\u00162\u000e\u0010>\u001a\n\u0012\u0004\u0012\u00020?\u0018\u00010\u0013H\u0002J\u0016\u0010@\u001a\u00020\u00162\u000e\u0010\u0019\u001a\n\u0012\u0004\u0012\u00020A\u0018\u00010\u0013J\u0010\u0010B\u001a\u00020\u00162\b\u0010\u0019\u001a\u0004\u0018\u00010CJ\b\u0010D\u001a\u00020\u0016H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006E"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/activity/ActivityMainFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentActivityMainBinding;", "Landroid/view/View$OnClickListener;", "()V", "activityViewModel", "Lcom/soletreadmills/sole_v2/ui/activity/ActivityViewModel;", "getActivityViewModel", "()Lcom/soletreadmills/sole_v2/ui/activity/ActivityViewModel;", "activityViewModel$delegate", "Lkotlin/Lazy;", "currentCollapseMode", "", "isEdit", "", "()Z", "setEdit", "(Z)V", "sectionBindings", "", "Lcom/soletreadmills/sole_v2/databinding/CustomSectionItemViewBinding;", "addSection", "", "title", "", "data", "", "Lcom/soletreadmills/sole_v2/_type/TrendsType;", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/UserWorkout12WeeklyStatsVoData;", "historyActivityType", "Lcom/soletreadmills/sole_v2/_type/HistoryActivityType;", "changeCollapseMode", "collapseMode", "clearAllSections", "getMyLatest3MonthWorkoutStatsApiData", "getMyLatest6WeeklyActiveTimeApiData", "getMyPersonalBestListApiData", "getMyUsedActivityTypes", "getMyWorkoutStatisticsApiData", "getUserMonthlyStatisticsApiData", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "loadAllSections", "list", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onViewCreated", "view", "refreshHistoryListBestStatus", "setHistoryRecyclerView", "historyList", "Lcom/soletreadmills/sole_v2/_data/api/history/HistoryListData;", "setLineChart", "pointList", "Lcom/soletreadmills/sole_v2/_data/api/activity/GetMyLatest6WeeklyActiveTimeApiData$WeeklyStatsData;", "setPersonalBestRecyclerview", "Lcom/soletreadmills/sole_v2/_data/UserPersonalBestVoData;", "setWorkStatisticsView", "Lcom/soletreadmills/sole_v2/_data/UserStatisticsVoData;", "sortAndDisplaySections", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ActivityMainFragment extends BaseFragment<FragmentActivityMainBinding> implements View.OnClickListener {
    public static final int $stable = 8;

    /* renamed from: activityViewModel$delegate, reason: from kotlin metadata */
    private final Lazy activityViewModel;
    private boolean isEdit;
    private int currentCollapseMode = 2;
    private final List<CustomSectionItemViewBinding> sectionBindings = new ArrayList();

    public ActivityMainFragment() {
        final ActivityMainFragment activityMainFragment = this;
        final Function0 function0 = null;
        this.activityViewModel = FragmentViewModelLazyKt.createViewModelLazy(activityMainFragment, Reflection.getOrCreateKotlinClass(ActivityViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = activityMainFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = activityMainFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = activityMainFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public static final /* synthetic */ FragmentActivityMainBinding access$getBinding(ActivityMainFragment activityMainFragment) {
        return activityMainFragment.getBinding();
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

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentActivityMainBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentActivityMainBinding fragmentActivityMainBindingInflate = FragmentActivityMainBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentActivityMainBindingInflate, "inflate(...)");
        return fragmentActivityMainBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        getActivityViewModel().getUserPersonalBestVoData().observe(getViewLifecycleOwner(), new ActivityMainFragment$sam$androidx_lifecycle_Observer$0(new Function1<List<UserPersonalBestVoData>, Unit>() { // from class: com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment.onViewCreated.1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<UserPersonalBestVoData> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<UserPersonalBestVoData> list) {
                if (list != null) {
                    ActivityMainFragment.this.setPersonalBestRecyclerview(GetMyPersonalBestListApiData.DataMap.INSTANCE.filterBestRecords(list));
                    ActivityMainFragment.this.refreshHistoryListBestStatus();
                }
            }
        }));
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        AppBarLayout appBarLayout;
        FragmentActivityMainBinding binding = getBinding();
        if (binding != null && (appBarLayout = binding.appBarLayout) != null) {
            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$$ExternalSyntheticLambda0
                @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
                public final void onOffsetChanged(AppBarLayout appBarLayout2, int i) {
                    ActivityMainFragment.initViews$lambda$0(this.f$0, appBarLayout2, i);
                }
            });
        }
        FragmentActivityMainBinding binding2 = getBinding();
        if (binding2 != null && (linearLayout2 = binding2.LLHistory) != null) {
            linearLayout2.setOnClickListener(this);
        }
        FragmentActivityMainBinding binding3 = getBinding();
        if (binding3 != null && (linearLayout = binding3.LLPersonalBest) != null) {
            linearLayout.setOnClickListener(this);
        }
        setHistoryRecyclerView(null);
        setPersonalBestRecyclerview(null);
        getMyWorkoutStatisticsApiData();
        getUserMonthlyStatisticsApiData();
        getMyPersonalBestListApiData();
        getMyLatest6WeeklyActiveTimeApiData();
        getMyUsedActivityTypes();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$0(ActivityMainFragment this$0, AppBarLayout appBarLayout, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i2 = ((float) Math.abs(i)) / ((float) appBarLayout.getTotalScrollRange()) >= 0.85f ? 1 : 2;
        if (this$0.currentCollapseMode != i2) {
            this$0.changeCollapseMode(i2);
            this$0.currentCollapseMode = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        List<UserPersonalBestVoData> value;
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.LL_history;
        if (numValueOf != null && numValueOf.intValue() == i) {
            BaseFragment.safeNavigate$default(this, R.id.historyFragment, null, 2, null);
            return;
        }
        int i2 = R.id.LL_personalBest;
        if (numValueOf == null || numValueOf.intValue() != i2 || (value = getActivityViewModel().getUserPersonalBestVoData().getValue()) == null || value.isEmpty()) {
            return;
        }
        BaseFragment.safeNavigate$default(this, R.id.personalBestFragment, null, 2, null);
    }

    private final void changeCollapseMode(int collapseMode) {
        TextView textView;
        Toolbar toolbar;
        FragmentActivityMainBinding binding = getBinding();
        ViewGroup.LayoutParams layoutParams = (binding == null || (toolbar = binding.collapsingToolbar) == null) ? null : toolbar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams");
        CollapsingToolbarLayout.LayoutParams layoutParams2 = (CollapsingToolbarLayout.LayoutParams) layoutParams;
        layoutParams2.setCollapseMode(collapseMode);
        FragmentActivityMainBinding binding2 = getBinding();
        Toolbar toolbar2 = binding2 != null ? binding2.collapsingToolbar : null;
        if (toolbar2 != null) {
            toolbar2.setLayoutParams(layoutParams2);
        }
        if (collapseMode == 1) {
            FragmentActivityMainBinding binding3 = getBinding();
            textView = binding3 != null ? binding3.title : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        FragmentActivityMainBinding binding4 = getBinding();
        textView = binding4 != null ? binding4.title : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(4);
    }

    public final void loadAllSections(List<? extends HistoryActivityType> list) {
        Intrinsics.checkNotNullParameter(list, "list");
        clearAllSections();
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C08611(list, null), 3, null);
    }

    /* compiled from: ActivityMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$loadAllSections$1", f = "ActivityMainFragment.kt", i = {}, l = {Opcodes.RET}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$loadAllSections$1, reason: invalid class name and case insensitive filesystem */
    static final class C08611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<HistoryActivityType> $list;
        private /* synthetic */ Object L$0;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        C08611(List<? extends HistoryActivityType> list, Continuation<? super C08611> continuation) {
            super(2, continuation);
            this.$list = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            C08611 c08611 = ActivityMainFragment.this.new C08611(this.$list, continuation);
            c08611.L$0 = obj;
            return c08611;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08611) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
                MainActivity mainActivity = ActivityMainFragment.this.getMainActivity();
                if (mainActivity != null) {
                    BaseActivity.showLoadDialog$default(mainActivity, null, 1, null);
                }
                List<HistoryActivityType> list = this.$list;
                ActivityMainFragment activityMainFragment = ActivityMainFragment.this;
                ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
                Iterator<T> it = list.iterator();
                while (it.hasNext()) {
                    arrayList.add(BuildersKt__Builders_commonKt.async$default(coroutineScope, null, null, new ActivityMainFragment$loadAllSections$1$1$1(activityMainFragment, (HistoryActivityType) it.next(), null), 3, null));
                }
                this.label = 1;
                if (AwaitKt.awaitAll(arrayList, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            MainActivity mainActivity2 = ActivityMainFragment.this.getMainActivity();
            if (mainActivity2 != null) {
                mainActivity2.cancelLoadDialog();
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setHistoryRecyclerView(List<HistoryListData> historyList) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        RecyclerView recyclerView4;
        FragmentActivityMainBinding binding = getBinding();
        RecyclerView.Adapter adapter = null;
        if (!(((binding == null || (recyclerView4 = binding.rvHistory) == null) ? null : recyclerView4.getLayoutManager()) instanceof LinearLayoutManager)) {
            FragmentActivityMainBinding binding2 = getBinding();
            RecyclerView recyclerView5 = binding2 != null ? binding2.rvHistory : null;
            if (recyclerView5 != null) {
                recyclerView5.setLayoutManager(new LinearLayoutManager(getActivity()));
            }
        }
        FragmentActivityMainBinding binding3 = getBinding();
        if (!(((binding3 == null || (recyclerView3 = binding3.rvHistory) == null) ? null : recyclerView3.getAdapter()) instanceof HistoryAdapter)) {
            HistoryAdapter historyAdapter = new HistoryAdapter(new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$setHistoryRecyclerView$adapter$1
                @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                public void onClick(int pos) {
                    String userWorkoutUuid;
                    RecyclerView recyclerView6;
                    FragmentActivityMainBinding fragmentActivityMainBindingAccess$getBinding = ActivityMainFragment.access$getBinding(this.this$0);
                    RecyclerView.Adapter adapter2 = (fragmentActivityMainBindingAccess$getBinding == null || (recyclerView6 = fragmentActivityMainBindingAccess$getBinding.rvHistory) == null) ? null : recyclerView6.getAdapter();
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
                    RecyclerView recyclerView6;
                    Intrinsics.checkNotNullParameter(string, "string");
                    FragmentActivityMainBinding fragmentActivityMainBindingAccess$getBinding = ActivityMainFragment.access$getBinding(this.this$0);
                    RecyclerView.Adapter adapter2 = (fragmentActivityMainBindingAccess$getBinding == null || (recyclerView6 = fragmentActivityMainBindingAccess$getBinding.rvHistory) == null) ? null : recyclerView6.getAdapter();
                    if (adapter2 instanceof HistoryAdapter) {
                        List<HistoryListData> currentList = ((HistoryAdapter) adapter2).getCurrentList();
                        Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                        currentList.get(pos);
                        Intrinsics.areEqual(string, "delete");
                    }
                }
            });
            FragmentActivityMainBinding binding4 = getBinding();
            RecyclerView recyclerView6 = binding4 != null ? binding4.rvHistory : null;
            if (recyclerView6 != null) {
                recyclerView6.setAdapter(historyAdapter);
            }
            FragmentActivityMainBinding binding5 = getBinding();
            if (binding5 != null && (recyclerView2 = binding5.rvHistory) != null) {
                recyclerView2.addItemDecoration(new HistoryHeaderDecoration(historyAdapter));
            }
        }
        List<HistoryListData> list = historyList;
        if (list == null || list.isEmpty()) {
            FragmentActivityMainBinding binding6 = getBinding();
            LinearLayout linearLayout = binding6 != null ? binding6.LLHistoryEmpty : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            FragmentActivityMainBinding binding7 = getBinding();
            RecyclerView recyclerView7 = binding7 != null ? binding7.rvHistory : null;
            if (recyclerView7 != null) {
                recyclerView7.setVisibility(8);
            }
            FragmentActivityMainBinding binding8 = getBinding();
            ImageView imageView = binding8 != null ? binding8.imgHistoryArrow : null;
            if (imageView != null) {
                imageView.setVisibility(4);
            }
        } else {
            FragmentActivityMainBinding binding9 = getBinding();
            LinearLayout linearLayout2 = binding9 != null ? binding9.LLHistoryEmpty : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            FragmentActivityMainBinding binding10 = getBinding();
            RecyclerView recyclerView8 = binding10 != null ? binding10.rvHistory : null;
            if (recyclerView8 != null) {
                recyclerView8.setVisibility(0);
            }
            FragmentActivityMainBinding binding11 = getBinding();
            ImageView imageView2 = binding11 != null ? binding11.imgHistoryArrow : null;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
        }
        ArrayList arrayList = new ArrayList();
        if (historyList != null) {
            for (HistoryListData historyListData : historyList) {
                HistoryListData historyListDataCopy = historyListData.copy((511 & 1) != 0 ? historyListData.id : null, (511 & 2) != 0 ? historyListData.year : null, (511 & 4) != 0 ? historyListData.month : null, (511 & 8) != 0 ? historyListData.activeHours : null, (511 & 16) != 0 ? historyListData.totalCalories : null, (511 & 32) != 0 ? historyListData.totalSize : null, (511 & 64) != 0 ? historyListData.isHeader : false, (511 & 128) != 0 ? historyListData.workoutData : null, (511 & 256) != 0 ? historyListData.isEdit : false, (511 & 512) != 0 ? historyListData.isBest : false);
                if (this.isEdit) {
                    historyListDataCopy.setEdit(true);
                } else {
                    historyListDataCopy.setEdit(false);
                }
                arrayList.add(historyListDataCopy);
            }
        }
        FragmentActivityMainBinding binding12 = getBinding();
        if (binding12 != null && (recyclerView = binding12.rvHistory) != null) {
            adapter = recyclerView.getAdapter();
        }
        if (adapter instanceof HistoryAdapter) {
            ((HistoryAdapter) adapter).submitList(arrayList);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void refreshHistoryListBestStatus() {
        RecyclerView recyclerView;
        FragmentActivityMainBinding binding = getBinding();
        RecyclerView.Adapter adapter = (binding == null || (recyclerView = binding.rvHistory) == null) ? null : recyclerView.getAdapter();
        if (adapter instanceof HistoryAdapter) {
            HistoryAdapter historyAdapter = (HistoryAdapter) adapter;
            List<HistoryListData> currentList = historyAdapter.getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
            if (currentList.isEmpty()) {
                return;
            }
            List<HistoryListData> currentList2 = historyAdapter.getCurrentList();
            Intrinsics.checkNotNullExpressionValue(currentList2, "getCurrentList(...)");
            List mutableList = CollectionsKt.toMutableList((Collection) currentList2);
            List<UserPersonalBestVoData> userPersonalBestVoDataValue = getActivityViewModel().getUserPersonalBestVoDataValue();
            List<HistoryListData> list = mutableList;
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            for (HistoryListData historyListDataCopy : list) {
                if (!historyListDataCopy.isHeader() && historyListDataCopy.getWorkoutData() != null) {
                    boolean z = false;
                    if (userPersonalBestVoDataValue != null) {
                        List<UserPersonalBestVoData> list2 = userPersonalBestVoDataValue;
                        if (!(list2 instanceof Collection) || !list2.isEmpty()) {
                            Iterator<T> it = list2.iterator();
                            while (true) {
                                if (!it.hasNext()) {
                                    break;
                                }
                                String currentBestUserWorkoutUuid = ((UserPersonalBestVoData) it.next()).getCurrentBestUserWorkoutUuid();
                                WorkoutViewVo workoutData = historyListDataCopy.getWorkoutData();
                                if (Intrinsics.areEqual(currentBestUserWorkoutUuid, workoutData != null ? workoutData.getUserWorkoutUuid() : null)) {
                                    z = true;
                                    break;
                                }
                            }
                        }
                    }
                    Intrinsics.checkNotNull(historyListDataCopy);
                    historyListDataCopy = historyListDataCopy.copy((511 & 1) != 0 ? historyListDataCopy.id : null, (511 & 2) != 0 ? historyListDataCopy.year : null, (511 & 4) != 0 ? historyListDataCopy.month : null, (511 & 8) != 0 ? historyListDataCopy.activeHours : null, (511 & 16) != 0 ? historyListDataCopy.totalCalories : null, (511 & 32) != 0 ? historyListDataCopy.totalSize : null, (511 & 64) != 0 ? historyListDataCopy.isHeader : false, (511 & 128) != 0 ? historyListDataCopy.workoutData : null, (511 & 256) != 0 ? historyListDataCopy.isEdit : false, (511 & 512) != 0 ? historyListDataCopy.isBest : z);
                }
                arrayList.add(historyListDataCopy);
            }
            historyAdapter.submitList(arrayList);
        }
    }

    public final void setPersonalBestRecyclerview(List<UserPersonalBestVoData> data) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        Context context = getContext();
        if (context != null) {
            FragmentActivityMainBinding binding = getBinding();
            RecyclerView.Adapter adapter = null;
            if (!(((binding == null || (recyclerView3 = binding.rvPersonalBest) == null) ? null : recyclerView3.getLayoutManager()) instanceof LinearLayoutManager)) {
                FragmentActivityMainBinding binding2 = getBinding();
                RecyclerView recyclerView4 = binding2 != null ? binding2.rvPersonalBest : null;
                if (recyclerView4 != null) {
                    recyclerView4.setLayoutManager(new LinearLayoutManager(context, 0, false));
                }
            }
            FragmentActivityMainBinding binding3 = getBinding();
            if (!(((binding3 == null || (recyclerView2 = binding3.rvPersonalBest) == null) ? null : recyclerView2.getAdapter()) instanceof PersonalBestAdapter)) {
                PersonalBestAdapter personalBestAdapter = new PersonalBestAdapter(new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$setPersonalBestRecyclerview$1$adapter$1
                    @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                    public void onClick(int pos, String string) {
                        Intrinsics.checkNotNullParameter(string, "string");
                    }

                    @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                    public void onClick(int pos) {
                        RecyclerView recyclerView5;
                        FragmentActivityMainBinding fragmentActivityMainBindingAccess$getBinding = ActivityMainFragment.access$getBinding(this.this$0);
                        RecyclerView.Adapter adapter2 = (fragmentActivityMainBindingAccess$getBinding == null || (recyclerView5 = fragmentActivityMainBindingAccess$getBinding.rvPersonalBest) == null) ? null : recyclerView5.getAdapter();
                        if (adapter2 instanceof PersonalBestAdapter) {
                            List<UserPersonalBestVoData> currentList = ((PersonalBestAdapter) adapter2).getCurrentList();
                            Intrinsics.checkNotNullExpressionValue(currentList, "getCurrentList(...)");
                            UserPersonalBestVoData userPersonalBestVoData = currentList.get(pos);
                            Bundle bundle = new Bundle();
                            String currentBestUserWorkoutUuid = userPersonalBestVoData.getCurrentBestUserWorkoutUuid();
                            if (currentBestUserWorkoutUuid == null) {
                                currentBestUserWorkoutUuid = "";
                            }
                            bundle.putString("workoutUuid", currentBestUserWorkoutUuid);
                            bundle.putBoolean("isBest", true);
                            this.this$0.safeNavigate(R.id.historyWorkoutFragment, bundle);
                        }
                    }
                });
                FragmentActivityMainBinding binding4 = getBinding();
                RecyclerView recyclerView5 = binding4 != null ? binding4.rvPersonalBest : null;
                if (recyclerView5 != null) {
                    recyclerView5.setAdapter(personalBestAdapter);
                }
            }
            ArrayList arrayList = new ArrayList();
            if (data != null && !data.isEmpty()) {
                FragmentActivityMainBinding binding5 = getBinding();
                LinearLayout linearLayout = binding5 != null ? binding5.LLPersonalBestEmpty : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                FragmentActivityMainBinding binding6 = getBinding();
                RecyclerView recyclerView6 = binding6 != null ? binding6.rvPersonalBest : null;
                if (recyclerView6 != null) {
                    recyclerView6.setVisibility(0);
                }
                FragmentActivityMainBinding binding7 = getBinding();
                ImageView imageView = binding7 != null ? binding7.imgPersonalBestArrow : null;
                if (imageView != null) {
                    imageView.setVisibility(0);
                }
                Iterator<UserPersonalBestVoData> it = data.iterator();
                while (it.hasNext()) {
                    arrayList.add(UserPersonalBestVoData.copy$default(it.next(), null, null, null, null, null, null, 63, null));
                }
            } else {
                FragmentActivityMainBinding binding8 = getBinding();
                LinearLayout linearLayout2 = binding8 != null ? binding8.LLPersonalBestEmpty : null;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                FragmentActivityMainBinding binding9 = getBinding();
                RecyclerView recyclerView7 = binding9 != null ? binding9.rvPersonalBest : null;
                if (recyclerView7 != null) {
                    recyclerView7.setVisibility(8);
                }
                FragmentActivityMainBinding binding10 = getBinding();
                ImageView imageView2 = binding10 != null ? binding10.imgPersonalBestArrow : null;
                if (imageView2 != null) {
                    imageView2.setVisibility(4);
                }
            }
            FragmentActivityMainBinding binding11 = getBinding();
            if (binding11 != null && (recyclerView = binding11.rvPersonalBest) != null) {
                adapter = recyclerView.getAdapter();
            }
            if (adapter instanceof PersonalBestAdapter) {
                ((PersonalBestAdapter) adapter).submitList(arrayList);
            }
        }
    }

    public final void setWorkStatisticsView(UserStatisticsVoData data) {
        if (data == null) {
            return;
        }
        boolean unitType = Global.INSTANCE.getUnitType();
        try {
            FragmentActivityMainBinding binding = getBinding();
            TextView textView = binding != null ? binding.tvWorkoutsCount : null;
            if (textView != null) {
                textView.setText(String.valueOf(data.getTotalCount()));
            }
            FragmentActivityMainBinding binding2 = getBinding();
            TextView textView2 = binding2 != null ? binding2.tvTotalCalories : null;
            if (textView2 != null) {
                textView2.setText(String.valueOf((int) data.getTotalCalories()));
            }
            FragmentActivityMainBinding binding3 = getBinding();
            TextView textView3 = binding3 != null ? binding3.tvActiveHours : null;
            if (textView3 != null) {
                textView3.setText(String.valueOf(data.getActiveHours()));
            }
            double totalDistanceBike = data.getTotalDistanceBike() + data.getTotalDistanceRower() + data.getTotalDistanceTreadmill() + data.getTotalDistanceElliptical() + data.getTotalElevationStepper();
            Timber.INSTANCE.e("totalDistance:%s", Double.valueOf(totalDistanceBike));
            if (unitType) {
                FragmentActivityMainBinding binding4 = getBinding();
                TextView textView4 = binding4 != null ? binding4.tvTotalDistanceTitle : null;
                if (textView4 != null) {
                    textView4.setText(getString(R.string.total_miles));
                }
                FragmentActivityMainBinding binding5 = getBinding();
                TextView textView5 = binding5 != null ? binding5.tvTotalDistance : null;
                if (textView5 == null) {
                    return;
                }
                textView5.setText(ConvertUtils.formatToOneDecimal02$default(ConvertUtils.INSTANCE, UnitConversion.INSTANCE.getMi(String.valueOf(totalDistanceBike), 1), null, 2, null));
                return;
            }
            FragmentActivityMainBinding binding6 = getBinding();
            TextView textView6 = binding6 != null ? binding6.tvTotalDistanceTitle : null;
            if (textView6 != null) {
                textView6.setText(getString(R.string.total_kilometers));
            }
            FragmentActivityMainBinding binding7 = getBinding();
            TextView textView7 = binding7 != null ? binding7.tvTotalDistance : null;
            if (textView7 == null) {
                return;
            }
            textView7.setText(ConvertUtils.formatToOneDecimal02$default(ConvertUtils.INSTANCE, String.valueOf(totalDistanceBike), null, 2, null));
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
        }
    }

    private final void clearAllSections() {
        LinearLayout linearLayout;
        FragmentActivityMainBinding binding = getBinding();
        if (binding != null && (linearLayout = binding.sectionsContainer) != null) {
            linearLayout.removeAllViews();
        }
        this.sectionBindings.clear();
    }

    /* compiled from: ActivityMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$addSection$1", f = "ActivityMainFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$addSection$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<TrendsType> $data;
        final /* synthetic */ HistoryActivityType $historyActivityType;
        final /* synthetic */ UserWorkout12WeeklyStatsVoData $item;
        final /* synthetic */ String $title;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        /* JADX WARN: Multi-variable type inference failed */
        AnonymousClass1(String str, HistoryActivityType historyActivityType, UserWorkout12WeeklyStatsVoData userWorkout12WeeklyStatsVoData, List<? extends TrendsType> list, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$title = str;
            this.$historyActivityType = historyActivityType;
            this.$item = userWorkout12WeeklyStatsVoData;
            this.$data = list;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ActivityMainFragment.this.new AnonymousClass1(this.$title, this.$historyActivityType, this.$item, this.$data, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Context context;
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            if (ActivityMainFragment.this.isAdded() && (context = ActivityMainFragment.this.getContext()) != null) {
                LayoutInflater layoutInflaterFrom = LayoutInflater.from(context);
                FragmentActivityMainBinding fragmentActivityMainBindingAccess$getBinding = ActivityMainFragment.access$getBinding(ActivityMainFragment.this);
                CustomSectionItemViewBinding customSectionItemViewBindingInflate = CustomSectionItemViewBinding.inflate(layoutInflaterFrom, fragmentActivityMainBindingAccess$getBinding != null ? fragmentActivityMainBindingAccess$getBinding.sectionsContainer : null, false);
                Intrinsics.checkNotNullExpressionValue(customSectionItemViewBindingInflate, "inflate(...)");
                customSectionItemViewBindingInflate.tvSectionTitle.setText(this.$title);
                RecyclerView recyclerView = customSectionItemViewBindingInflate.rvSectionContent;
                final UserWorkout12WeeklyStatsVoData userWorkout12WeeklyStatsVoData = this.$item;
                final ActivityMainFragment activityMainFragment = ActivityMainFragment.this;
                final List<TrendsType> list = this.$data;
                recyclerView.setLayoutManager(new GridLayoutManager(context, 2));
                RunningTrendsAdapter runningTrendsAdapter = new RunningTrendsAdapter(userWorkout12WeeklyStatsVoData, new OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$addSection$1$1$1
                    @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                    public void onClick(int pos, String string) {
                        Intrinsics.checkNotNullParameter(string, "string");
                    }

                    @Override // com.soletreadmills.sole_v2.listener.OnItemClickListener
                    public void onClick(int pos) {
                        if (activityMainFragment.isAdded()) {
                            activityMainFragment.getActivityViewModel().setTrendsType(list.get(pos));
                            activityMainFragment.getActivityViewModel().setTrendData(userWorkout12WeeklyStatsVoData);
                            BaseFragment.safeNavigate$default(activityMainFragment, R.id.trendChartFragment, null, 2, null);
                        }
                    }
                });
                runningTrendsAdapter.submitList(list);
                recyclerView.setAdapter(runningTrendsAdapter);
                customSectionItemViewBindingInflate.getRoot().setTag(Boxing.boxInt(this.$historyActivityType.getCode()));
                ActivityMainFragment.this.sectionBindings.add(customSectionItemViewBindingInflate);
                ActivityMainFragment.this.sortAndDisplaySections();
                return Unit.INSTANCE;
            }
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void addSection(String title, List<? extends TrendsType> data, UserWorkout12WeeklyStatsVoData item, HistoryActivityType historyActivityType) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(title, historyActivityType, item, data, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void sortAndDisplaySections() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        List<CustomSectionItemViewBinding> listSortedWith = CollectionsKt.sortedWith(this.sectionBindings, new Comparator() { // from class: com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$sortAndDisplaySections$$inlined$sortedBy$1
            /* JADX WARN: Multi-variable type inference failed */
            @Override // java.util.Comparator
            public final int compare(T t, T t2) {
                Object tag = ((CustomSectionItemViewBinding) t).getRoot().getTag();
                Integer num = tag instanceof Integer ? (Integer) tag : null;
                Integer numValueOf = Integer.valueOf(num != null ? num.intValue() : Integer.MAX_VALUE);
                Object tag2 = ((CustomSectionItemViewBinding) t2).getRoot().getTag();
                Integer num2 = tag2 instanceof Integer ? (Integer) tag2 : null;
                return ComparisonsKt.compareValues(numValueOf, Integer.valueOf(num2 != null ? num2.intValue() : Integer.MAX_VALUE));
            }
        });
        FragmentActivityMainBinding binding = getBinding();
        if (binding != null && (linearLayout2 = binding.sectionsContainer) != null) {
            linearLayout2.removeAllViews();
        }
        for (CustomSectionItemViewBinding customSectionItemViewBinding : listSortedWith) {
            ViewParent parent = customSectionItemViewBinding.getRoot().getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.removeView(customSectionItemViewBinding.getRoot());
            }
            FragmentActivityMainBinding binding2 = getBinding();
            if (binding2 != null && (linearLayout = binding2.sectionsContainer) != null) {
                linearLayout.addView(customSectionItemViewBinding.getRoot());
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setLineChart(List<GetMyLatest6WeeklyActiveTimeApiData.WeeklyStatsData> pointList) {
        FragmentActivityMainBinding binding;
        ArrayList arrayList;
        Context context = getContext();
        if (context == null || (binding = getBinding()) == null) {
            return;
        }
        LineChart lineChart = binding.lineChart;
        Intrinsics.checkNotNullExpressionValue(lineChart, "lineChart");
        ArrayList arrayList2 = new ArrayList();
        if (pointList != null) {
            int i = 0;
            for (Object obj : pointList) {
                int i2 = i + 1;
                if (i < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                arrayList2.add(new Entry(i, ((GetMyLatest6WeeklyActiveTimeApiData.WeeklyStatsData) obj).getTotalTime() / 3600.0f));
                i = i2;
            }
        }
        LineDataSet lineDataSet = new LineDataSet(arrayList2, "Exercise Data");
        lineDataSet.setColor(ContextCompat.getColor(context, R.color.colorGlobal_accent));
        lineDataSet.setLineWidth(4.0f);
        lineDataSet.setValueTextColor(-16777216);
        lineDataSet.setCircleRadius(4.0f);
        lineDataSet.setCircleColor(ContextCompat.getColor(context, R.color.colorGlobal_accent));
        lineDataSet.setDrawCircleHole(false);
        lineDataSet.setDrawCircles(false);
        lineDataSet.setDrawValues(false);
        lineDataSet.setValueTextSize(12.0f);
        lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
        lineDataSet.setCubicIntensity(0.01f);
        lineChart.setData(new LineData(lineDataSet));
        XAxis xAxis = lineChart.getXAxis();
        xAxis.setPosition(XAxis.XAxisPosition.BOTTOM);
        xAxis.setTextColor(ContextCompat.getColor(context, R.color.colorGlobal_black));
        xAxis.setDrawGridLines(true);
        xAxis.setLabelCount(pointList != null ? pointList.size() : 0, true);
        xAxis.setGranularity(1.0f);
        if (pointList != null) {
            List<GetMyLatest6WeeklyActiveTimeApiData.WeeklyStatsData> list = pointList;
            ArrayList arrayList3 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list, 10));
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                arrayList3.add(TimeTools.INSTANCE.formatToTime06(((GetMyLatest6WeeklyActiveTimeApiData.WeeklyStatsData) it.next()).getWeekStartDate()));
            }
            arrayList = arrayList3;
        } else {
            arrayList = null;
        }
        xAxis.setValueFormatter(new IndexAxisValueFormatter(arrayList));
        YAxis axisRight = lineChart.getAxisRight();
        axisRight.setTextColor(ContextCompat.getColor(context, R.color.colorGlobal_black));
        axisRight.setDrawGridLines(true);
        lineChart.getAxisLeft().setEnabled(false);
        lineChart.setHighlightPerTapEnabled(false);
        lineChart.setHighlightPerDragEnabled(false);
        lineChart.setScaleEnabled(false);
        lineChart.getDescription().setEnabled(false);
        lineChart.getLegend().setEnabled(false);
        lineChart.animateY(1000);
    }

    /* compiled from: ActivityMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$getMyWorkoutStatisticsApiData$1", f = "ActivityMainFragment.kt", i = {}, l = {524}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$getMyWorkoutStatisticsApiData$1, reason: invalid class name and case insensitive filesystem */
    static final class C08591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08591(Continuation<? super C08591> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ActivityMainFragment.this.new C08591(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08591) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Unit unit;
            GetMyWorkoutStatisticsApiData.ResponseData responseData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ActivityMainFragment.this.showLoading();
                        this.label = 1;
                        obj = DyacoApiKt.callGetMyWorkoutStatistics(this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    responseData = (GetMyWorkoutStatisticsApiData.ResponseData) ((Response) obj).body();
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(ActivityMainFragment.this, "getMyWorkoutStatisticsApiData", message, false, 4, null);
                    unit = Unit.INSTANCE;
                }
                if (responseData != null && responseData.getSuccess()) {
                    ActivityMainFragment activityMainFragment = ActivityMainFragment.this;
                    GetMyWorkoutStatisticsApiData.DataMap dataMap = responseData.getDataMap();
                    activityMainFragment.setWorkStatisticsView(dataMap != null ? dataMap.getData() : null);
                } else {
                    String errorCode = responseData != null ? responseData.getErrorCode() : null;
                    if (ActivityMainFragment.this.shouldIgnoreError(errorCode)) {
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                    Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.err_113))).get(errorCode);
                    if (num != null) {
                        ActivityMainFragment activityMainFragment2 = ActivityMainFragment.this;
                        CustomDialogKt.showCustomDialog$default(activityMainFragment2, activityMainFragment2.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                    } else {
                        BaseFragment.handleUndefinedError$default(ActivityMainFragment.this, "getMyWorkoutStatisticsApiData", errorCode, responseData != null ? responseData.getErrorMessage() : null, false, 8, null);
                    }
                }
                ActivityMainFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                ActivityMainFragment.this.stopLoading();
            }
        }
    }

    public final void getMyWorkoutStatisticsApiData() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C08591(null), 3, null);
    }

    /* compiled from: ActivityMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$getUserMonthlyStatisticsApiData$1", f = "ActivityMainFragment.kt", i = {}, l = {WinError.ERROR_DOMAIN_CTRLR_CONFIG_ERROR}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$getUserMonthlyStatisticsApiData$1, reason: invalid class name and case insensitive filesystem */
    static final class C08601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08601(Continuation<? super C08601> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ActivityMainFragment.this.new C08601(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08601) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objCallGetUserMonthlyStatisticsApiData;
            boolean z;
            boolean z2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    objCallGetUserMonthlyStatisticsApiData = DyacoApiKt.callGetUserMonthlyStatisticsApiData(new GetUserMonthlyStatisticsApiData.RequestBodyData(Boxing.boxBoolean(false), null, null, null, null, null, null, null, Boxing.boxInt(3), Boxing.boxInt(1), 254, null), this);
                    if (objCallGetUserMonthlyStatisticsApiData == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    objCallGetUserMonthlyStatisticsApiData = obj;
                }
                GetUserMonthlyStatisticsApiData.ResponseData responseData = (GetUserMonthlyStatisticsApiData.ResponseData) ((Response) objCallGetUserMonthlyStatisticsApiData).body();
                if (responseData != null && responseData.getSuccess()) {
                    GetUserMonthlyStatisticsApiData.DataMap dataMap = responseData.getDataMap();
                    List<UserMonthlyStatisticsBeanData> data = dataMap != null ? dataMap.getData() : null;
                    final ArrayList arrayList = new ArrayList();
                    List<UserPersonalBestVoData> userPersonalBestVoDataValue = ActivityMainFragment.this.getActivityViewModel().getUserPersonalBestVoDataValue();
                    if (data != null) {
                        Iterator<T> it = data.iterator();
                        while (it.hasNext()) {
                            List<WorkoutViewVo> workoutList = ((UserMonthlyStatisticsBeanData) it.next()).getWorkoutList();
                            if (workoutList != null) {
                                Iterator<T> it2 = workoutList.iterator();
                                while (it2.hasNext()) {
                                    for (WorkoutViewVo workoutViewVo : ((WorkoutViewVo) it2.next()).expand()) {
                                        if (userPersonalBestVoDataValue != null) {
                                            List<UserPersonalBestVoData> list = userPersonalBestVoDataValue;
                                            if ((list instanceof Collection) && list.isEmpty()) {
                                                z2 = false;
                                                z = z2;
                                            } else {
                                                Iterator<T> it3 = list.iterator();
                                                while (it3.hasNext()) {
                                                    if (Intrinsics.areEqual(((UserPersonalBestVoData) it3.next()).getCurrentBestUserWorkoutUuid(), workoutViewVo.getUserWorkoutUuid())) {
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
                                        arrayList.add(new HistoryListData(userWorkoutUuid, null, null, null, null, null, false, workoutViewVo, false, z, 318, null));
                                    }
                                }
                            }
                        }
                    }
                    ActivityMainFragment.this.setHistoryRecyclerView(arrayList);
                    HealthDataManager healthDataManager = new HealthDataManager();
                    MainActivity mainActivity = ActivityMainFragment.this.getMainActivity();
                    if (mainActivity != null) {
                        healthDataManager.writeData(mainActivity, arrayList);
                    }
                    final MainActivity mainActivity2 = ActivityMainFragment.this.getMainActivity();
                    if (mainActivity2 != null) {
                        SamsungHealthManager.Companion companion = SamsungHealthManager.INSTANCE;
                        Context applicationContext = mainActivity2.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                        final SamsungHealthManager companion2 = companion.getInstance(applicationContext);
                        if (companion2.isSamsungHealthInstalled(mainActivity2) && companion2.checkSamsungHealthPermissions()) {
                            if (!companion2.checkSamsungHealthConnect()) {
                                Timber.INSTANCE.tag("SamsungHealth").d("SamsungHealth 尚未連過", new Object[0]);
                                companion2.connectHealthData(mainActivity2, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$getUserMonthlyStatisticsApiData$1$3$1
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
                            } else {
                                Timber.INSTANCE.tag("SamsungHealth").d("SamsungHealth 已經連過", new Object[0]);
                                companion2.writeData(mainActivity2, arrayList);
                            }
                        } else {
                            Timber.INSTANCE.tag("SamsungHealth").d("SamsungHealth 未安裝/尚未授權", new Object[0]);
                        }
                    }
                } else {
                    String errorCode = responseData != null ? responseData.getErrorCode() : null;
                    if (ActivityMainFragment.this.shouldIgnoreError(errorCode)) {
                        return Unit.INSTANCE;
                    }
                    Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.err_113)), TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), Boxing.boxInt(R.string.error))).get(errorCode);
                    if (num != null) {
                        ActivityMainFragment activityMainFragment = ActivityMainFragment.this;
                        CustomDialogKt.showCustomDialog$default(activityMainFragment, activityMainFragment.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                    } else {
                        BaseFragment.handleUndefinedError$default(ActivityMainFragment.this, "callUnReadMessageCountApi", errorCode, responseData != null ? responseData.getErrorMessage() : null, false, 8, null);
                    }
                }
                return Unit.INSTANCE;
            } catch (Exception e) {
                Timber.INSTANCE.e(e);
                String message = e.getMessage();
                if (message == null) {
                    message = e.getClass().getSimpleName();
                }
                BaseFragment.handleApiError$default(ActivityMainFragment.this, "callUnReadMessageCountApi", message, false, 4, null);
                return Unit.INSTANCE;
            }
        }
    }

    public final void getUserMonthlyStatisticsApiData() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C08601(null), 3, null);
    }

    /* compiled from: ActivityMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$getMyLatest6WeeklyActiveTimeApiData$1", f = "ActivityMainFragment.kt", i = {}, l = {WinError.ERROR_DLL_MIGHT_BE_INSECURE}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$getMyLatest6WeeklyActiveTimeApiData$1, reason: invalid class name and case insensitive filesystem */
    static final class C08561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08561(Continuation<? super C08561> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ActivityMainFragment.this.new C08561(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08561) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = DyacoApiKt.callGetMyLatest6WeeklyActiveTimeApiData(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                GetMyLatest6WeeklyActiveTimeApiData.ResponseData responseData = (GetMyLatest6WeeklyActiveTimeApiData.ResponseData) ((Response) obj).body();
                if (responseData != null && responseData.getSuccess()) {
                    GetMyLatest6WeeklyActiveTimeApiData.DataMap dataMap = responseData.getDataMap();
                    ActivityMainFragment.this.setLineChart(dataMap != null ? dataMap.getData() : null);
                } else {
                    String errorCode = responseData != null ? responseData.getErrorCode() : null;
                    if (ActivityMainFragment.this.shouldIgnoreError(errorCode)) {
                        return Unit.INSTANCE;
                    }
                    Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.err_113)), TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), Boxing.boxInt(R.string.error))).get(errorCode);
                    if (num != null) {
                        ActivityMainFragment activityMainFragment = ActivityMainFragment.this;
                        CustomDialogKt.showCustomDialog$default(activityMainFragment, activityMainFragment.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                    } else {
                        BaseFragment.handleUndefinedError$default(ActivityMainFragment.this, "getMyLatest6WeeklyActiveTimeApiData", errorCode, responseData != null ? responseData.getErrorMessage() : null, false, 8, null);
                    }
                }
                return Unit.INSTANCE;
            } catch (Exception e) {
                Timber.INSTANCE.e(e);
                String message = e.getMessage();
                if (message == null) {
                    message = e.getClass().getSimpleName();
                }
                BaseFragment.handleApiError$default(ActivityMainFragment.this, "getMyLatest6WeeklyActiveTimeApiData", message, false, 4, null);
                return Unit.INSTANCE;
            }
        }
    }

    public final void getMyLatest6WeeklyActiveTimeApiData() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C08561(null), 3, null);
    }

    /* compiled from: ActivityMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$getMyPersonalBestListApiData$1", f = "ActivityMainFragment.kt", i = {}, l = {WinError.ERROR_USER_APC}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$getMyPersonalBestListApiData$1, reason: invalid class name and case insensitive filesystem */
    static final class C08571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08571(Continuation<? super C08571> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ActivityMainFragment.this.new C08571(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08571) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    obj = DyacoApiKt.callGetMyPersonalBestListApiData(this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                GetMyPersonalBestListApiData.ResponseData responseData = (GetMyPersonalBestListApiData.ResponseData) ((Response) obj).body();
                if (responseData != null && responseData.getSuccess()) {
                    GetMyPersonalBestListApiData.DataMap dataMap = responseData.getDataMap();
                    ActivityMainFragment.this.getActivityViewModel().setUserPersonalBestVoData(dataMap != null ? dataMap.getData() : null);
                } else {
                    String errorCode = responseData != null ? responseData.getErrorCode() : null;
                    if (ActivityMainFragment.this.shouldIgnoreError(errorCode)) {
                        return Unit.INSTANCE;
                    }
                    Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.err_113)), TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), Boxing.boxInt(R.string.error))).get(errorCode);
                    if (num != null) {
                        ActivityMainFragment activityMainFragment = ActivityMainFragment.this;
                        CustomDialogKt.showCustomDialog$default(activityMainFragment, activityMainFragment.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                    } else {
                        BaseFragment.handleUndefinedError$default(ActivityMainFragment.this, "getMyPersonalBestListApiData", errorCode, responseData != null ? responseData.getErrorMessage() : null, false, 8, null);
                    }
                }
                return Unit.INSTANCE;
            } catch (Exception e) {
                String message = e.getMessage();
                if (message == null) {
                    message = e.getClass().getSimpleName();
                }
                BaseFragment.handleApiError$default(ActivityMainFragment.this, "getMyPersonalBestListApiData", message, false, 4, null);
                return Unit.INSTANCE;
            }
        }
    }

    public final void getMyPersonalBestListApiData() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C08571(null), 3, null);
    }

    /* compiled from: ActivityMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$getMyLatest3MonthWorkoutStatsApiData$1", f = "ActivityMainFragment.kt", i = {}, l = {795}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$getMyLatest3MonthWorkoutStatsApiData$1, reason: invalid class name and case insensitive filesystem */
    static final class C08551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ HistoryActivityType $historyActivityType;
        int label;
        final /* synthetic */ ActivityMainFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08551(HistoryActivityType historyActivityType, ActivityMainFragment activityMainFragment, Context context, Continuation<? super C08551> continuation) {
            super(2, continuation);
            this.$historyActivityType = historyActivityType;
            this.this$0 = activityMainFragment;
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08551(this.$historyActivityType, this.this$0, this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08551) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    GetMyLatest3MonthWorkoutStatsApiData.RequestBodyData requestBodyData = new GetMyLatest3MonthWorkoutStatsApiData.RequestBodyData(null, 1, null);
                    requestBodyData.setActivityType(String.valueOf(this.$historyActivityType.getCode()));
                    this.label = 1;
                    obj = DyacoApiKt.callGetMyLatest3MonthWorkoutStatsApiData(requestBodyData, this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
                GetMyLatest3MonthWorkoutStatsApiData.ResponseData responseData = (GetMyLatest3MonthWorkoutStatsApiData.ResponseData) ((Response) obj).body();
                if (responseData != null && responseData.getSuccess()) {
                    GetMyLatest3MonthWorkoutStatsApiData.DataMap dataMap = responseData.getDataMap();
                    this.this$0.addSection(this.$historyActivityType.getTitle(this.$context) + ' ' + this.this$0.getString(R.string.trends), TrendsType.INSTANCE.getTrends(this.$historyActivityType), dataMap != null ? dataMap.getData() : null, this.$historyActivityType);
                } else {
                    String errorCode = responseData != null ? responseData.getErrorCode() : null;
                    if (this.this$0.shouldIgnoreError(errorCode)) {
                        return Unit.INSTANCE;
                    }
                    Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.err_113)), TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), Boxing.boxInt(R.string.error))).get(errorCode);
                    if (num != null) {
                        ActivityMainFragment activityMainFragment = this.this$0;
                        CustomDialogKt.showCustomDialog$default(activityMainFragment, activityMainFragment.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                    } else {
                        BaseFragment.handleUndefinedError$default(this.this$0, "getMyLatest3MonthWorkoutStatsApiData", errorCode, responseData != null ? responseData.getErrorMessage() : null, false, 8, null);
                    }
                }
                return Unit.INSTANCE;
            } catch (Exception e) {
                Timber.INSTANCE.e(e);
                String message = e.getMessage();
                if (message == null) {
                    message = e.getClass().getSimpleName();
                }
                BaseFragment.handleApiError$default(this.this$0, "getMyLatest3MonthWorkoutStatsApiData", message, false, 4, null);
                return Unit.INSTANCE;
            }
        }
    }

    public final void getMyLatest3MonthWorkoutStatsApiData(HistoryActivityType historyActivityType) {
        Intrinsics.checkNotNullParameter(historyActivityType, "historyActivityType");
        Context context = getContext();
        if (context == null) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C08551(historyActivityType, this, context, null), 3, null);
    }

    /* compiled from: ActivityMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$getMyUsedActivityTypes$1", f = "ActivityMainFragment.kt", i = {}, l = {854}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.activity.ActivityMainFragment$getMyUsedActivityTypes$1, reason: invalid class name and case insensitive filesystem */
    static final class C08581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08581(Context context, Continuation<? super C08581> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ActivityMainFragment.this.new C08581(this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08581) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objCallGetMyUsedActivityTypes;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    this.label = 1;
                    objCallGetMyUsedActivityTypes = DyacoApiKt.callGetMyUsedActivityTypes(this);
                    if (objCallGetMyUsedActivityTypes == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                    objCallGetMyUsedActivityTypes = obj;
                }
                GetMyUsedActivityTypesApiData.ResponseData responseData = (GetMyUsedActivityTypesApiData.ResponseData) ((Response) objCallGetMyUsedActivityTypes).body();
                if (responseData == null || !responseData.getSuccess()) {
                    ActivityMainFragment.this.addSection(HistoryActivityType.RUNNING.getTitle(this.$context) + ' ' + ActivityMainFragment.this.getString(R.string.trends), TrendsType.INSTANCE.getTrends(HistoryActivityType.RUNNING), null, HistoryActivityType.RUNNING);
                    String errorCode = responseData != null ? responseData.getErrorCode() : null;
                    if (ActivityMainFragment.this.shouldIgnoreError(errorCode)) {
                        return Unit.INSTANCE;
                    }
                    Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.err_113)), TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), Boxing.boxInt(R.string.error))).get(errorCode);
                    if (num != null) {
                        ActivityMainFragment activityMainFragment = ActivityMainFragment.this;
                        CustomDialogKt.showCustomDialog$default(activityMainFragment, activityMainFragment.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                    } else {
                        BaseFragment.handleUndefinedError$default(ActivityMainFragment.this, "getMyUsedActivityTypes", errorCode, responseData != null ? responseData.getErrorMessage() : null, false, 8, null);
                    }
                } else {
                    List<HistoryActivityType> historyActivityTypes = responseData.getHistoryActivityTypes();
                    if (historyActivityTypes.isEmpty()) {
                        ActivityMainFragment.this.addSection(HistoryActivityType.RUNNING.getTitle(this.$context) + ' ' + ActivityMainFragment.this.getString(R.string.trends), TrendsType.INSTANCE.getTrends(HistoryActivityType.RUNNING), null, HistoryActivityType.RUNNING);
                    } else {
                        ActivityMainFragment.this.loadAllSections(historyActivityTypes);
                    }
                }
            } catch (Exception e) {
                Timber.INSTANCE.e(e);
                if (ActivityMainFragment.this.isAdded()) {
                    ActivityMainFragment.this.addSection(HistoryActivityType.RUNNING.getTitle(this.$context) + ' ' + ActivityMainFragment.this.getString(R.string.trends), TrendsType.INSTANCE.getTrends(HistoryActivityType.RUNNING), null, HistoryActivityType.RUNNING);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(ActivityMainFragment.this, "getMyUsedActivityTypes", message, false, 4, null);
                }
            }
            return Unit.INSTANCE;
        }
    }

    public final void getMyUsedActivityTypes() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C08581(context, null), 3, null);
    }
}
