package com.soletreadmills.sole_v2.ui.club;

import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.core.widget.NestedScrollView;
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
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._data.api.club.DeleteChallengeApiData;
import com.soletreadmills.sole_v2._data.api.club.GetMyComingChallengesApiData;
import com.soletreadmills.sole_v2._data.api.club.GetMyFinishedChallengesApiData;
import com.soletreadmills.sole_v2._data.api.club.GetMyOnGoingChallengesApiData;
import com.soletreadmills.sole_v2._data.api.club.QuitChallengeApiData;
import com.soletreadmills.sole_v2._data.club.ChallengeItemSimpleData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2.databinding.FragmentClubMyEventsBinding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.adapter.club.ClubSearchItemAdapter;
import com.sun.jna.platform.win32.WinError;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: ClubMyEventsFragment.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001YB\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J\u0010\u0010(\u001a\u00020%2\u0006\u0010&\u001a\u00020'H\u0002J(\u0010)\u001a\u00020%2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\f\u0010.\u001a\b\u0012\u0004\u0012\u00020%0/H\u0002J\u0010\u00100\u001a\u00020%2\u0006\u00101\u001a\u00020-H\u0002J6\u00102\u001a\u00020%2\b\b\u0002\u00103\u001a\u00020\u00122\b\b\u0002\u00104\u001a\u00020\u00122\b\b\u0002\u00105\u001a\u00020\u00102\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u00020%0/H\u0002J6\u00107\u001a\u00020%2\b\b\u0002\u00103\u001a\u00020\u00122\b\b\u0002\u00104\u001a\u00020\u00122\b\b\u0002\u00105\u001a\u00020\u00102\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u00020%0/H\u0002J6\u00108\u001a\u00020%2\b\b\u0002\u00103\u001a\u00020\u00122\b\b\u0002\u00104\u001a\u00020\u00122\b\b\u0002\u00105\u001a\u00020\u00102\u000e\b\u0002\u00106\u001a\b\u0012\u0004\u0012\u00020%0/H\u0002J\u0010\u00109\u001a\u00020%2\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010<\u001a\u00020%2\u0006\u0010:\u001a\u00020;H\u0002J\u0010\u0010=\u001a\u00020%2\u0006\u0010:\u001a\u00020;H\u0002J\u001a\u0010>\u001a\u00020\u00022\u0006\u0010?\u001a\u00020@2\b\u0010A\u001a\u0004\u0018\u00010BH\u0016J\b\u0010C\u001a\u00020%H\u0016J \u0010D\u001a\u00020\u00122\u0006\u0010E\u001a\u00020F2\u0006\u0010G\u001a\u00020\u00102\u0006\u0010H\u001a\u00020\u0010H\u0002J\b\u0010I\u001a\u00020%H\u0002J\b\u0010J\u001a\u00020%H\u0002J\b\u0010K\u001a\u00020%H\u0002J\u0012\u0010L\u001a\u00020%2\b\u0010M\u001a\u0004\u0018\u00010FH\u0016J\b\u0010N\u001a\u00020%H\u0016J\u001a\u0010O\u001a\u00020%2\u0006\u0010P\u001a\u00020F2\b\u0010Q\u001a\u0004\u0018\u00010RH\u0016J\u0010\u0010S\u001a\u00020%2\u0006\u00101\u001a\u00020-H\u0002J\u0012\u0010T\u001a\u00020%2\b\b\u0002\u0010U\u001a\u00020\u0012H\u0002J\u0012\u0010V\u001a\u00020%2\b\b\u0002\u0010U\u001a\u00020\u0012H\u0002J\b\u0010W\u001a\u00020%H\u0002J\u0012\u0010X\u001a\u00020%2\b\b\u0002\u0010U\u001a\u00020\u0012H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\t\u001a\u00020\n8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010 \u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001dX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006Z"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/club/ClubMyEventsFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentClubMyEventsBinding;", "Landroid/view/View$OnClickListener;", "()V", "challengeList2Adapter", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubSearchItemAdapter;", "challengeList3Adapter", "clubOngoingAdapter", "clubViewModel", "Lcom/soletreadmills/sole_v2/ui/club/ClubViewModel;", "getClubViewModel", "()Lcom/soletreadmills/sole_v2/ui/club/ClubViewModel;", "clubViewModel$delegate", "Lkotlin/Lazy;", "finishedListCount", "", "hasMoreList2Data", "", "hasMoreList3Data", "hasMoreOngoingData", "isFinishedListEnd", "isList2Loading", "isList3Loading", "isOngoingListEnd", "isOngoingLoading", "isUpcomingListEnd", "list2CurrentPage", "list2ScrollListener", "Lcom/soletreadmills/sole_v2/ui/club/ClubMyEventsFragment$PaginationScrollVerticalListener;", "list3CurrentPage", "list3ScrollListener", "ongoingCurrentPage", "ongoingListCount", "ongoingScrollListener", "upcomingListCount", "checkCurrentVisibleSection", "", "scrollView", "Landroidx/core/widget/NestedScrollView;", "checkLoadMoreForAllSections", "checkLoadMoreForSection", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "sectionType", "", "onLoadMore", "Lkotlin/Function0;", "deleteChallenge", "challengeUuid", "getFinishedChallengeList", "isReset", "isCreatedByMe", "pageSize", "onComplete", "getMyOngoingChallengeList", "getUpcomingChallengeList", "handleChallengeCardClick", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleData;", "handleDeleteChallenge", "handleQuitChallenge", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "isSectionVisible", "section", "Landroid/view/View;", SdkConstants.ATTR_SCROLLY, "scrollViewHeight", "loadMoreList2Data", "loadMoreList3Data", "loadMoreOngoingData", SdkConstants.ATTR_ON_CLICK, "v", "onDestroy", "onViewCreated", "view", "savedInstanceState", "Landroid/os/Bundle;", "quitChallenge", "setupChallengeList2RecyclerView", "isEdit", "setupChallengeList3RecyclerView", "setupIntegratedScrollListener", "setupMyOngoingRecyclerView", "PaginationScrollVerticalListener", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubMyEventsFragment extends BaseFragment<FragmentClubMyEventsBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private ClubSearchItemAdapter challengeList2Adapter;
    private ClubSearchItemAdapter challengeList3Adapter;
    private ClubSearchItemAdapter clubOngoingAdapter;

    /* renamed from: clubViewModel$delegate, reason: from kotlin metadata */
    private final Lazy clubViewModel;
    private int finishedListCount;
    private boolean isFinishedListEnd;
    private boolean isList2Loading;
    private boolean isList3Loading;
    private boolean isOngoingListEnd;
    private boolean isOngoingLoading;
    private boolean isUpcomingListEnd;
    private PaginationScrollVerticalListener list2ScrollListener;
    private PaginationScrollVerticalListener list3ScrollListener;
    private int ongoingListCount;
    private PaginationScrollVerticalListener ongoingScrollListener;
    private int upcomingListCount;
    private int ongoingCurrentPage = 1;
    private boolean hasMoreOngoingData = true;
    private int list2CurrentPage = 1;
    private boolean hasMoreList2Data = true;
    private int list3CurrentPage = 1;
    private boolean hasMoreList3Data = true;

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    public ClubMyEventsFragment() {
        final ClubMyEventsFragment clubMyEventsFragment = this;
        final Function0 function0 = null;
        this.clubViewModel = FragmentViewModelLazyKt.createViewModelLazy(clubMyEventsFragment, Reflection.getOrCreateKotlinClass(ClubViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = clubMyEventsFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = clubMyEventsFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = clubMyEventsFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public static final /* synthetic */ FragmentClubMyEventsBinding access$getBinding(ClubMyEventsFragment clubMyEventsFragment) {
        return clubMyEventsFragment.getBinding();
    }

    public final ClubViewModel getClubViewModel() {
        return (ClubViewModel) this.clubViewModel.getValue();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentClubMyEventsBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentClubMyEventsBinding fragmentClubMyEventsBindingInflate = FragmentClubMyEventsBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentClubMyEventsBindingInflate, "inflate(...)");
        return fragmentClubMyEventsBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        TextView textView;
        TextView textView2;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        ImageView imageView;
        SwipeRefreshLayout swipeRefreshLayout;
        setupIntegratedScrollListener();
        FragmentClubMyEventsBinding binding = getBinding();
        if (binding != null && (swipeRefreshLayout = binding.swipeRefresh) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$$ExternalSyntheticLambda0
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    ClubMyEventsFragment.initViews$lambda$1(this.f$0);
                }
            });
        }
        FragmentClubMyEventsBinding binding2 = getBinding();
        if (binding2 != null && (imageView = binding2.imgBack) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubMyEventsFragment.initViews$lambda$2(this.f$0, view);
                }
            });
        }
        FragmentClubMyEventsBinding binding3 = getBinding();
        if (binding3 != null && (linearLayout2 = binding3.tvAllBtn) != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubMyEventsFragment.initViews$lambda$4(this.f$0, view);
                }
            });
        }
        FragmentClubMyEventsBinding binding4 = getBinding();
        if (binding4 != null && (linearLayout = binding4.tvCreatedByMeBtn) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubMyEventsFragment.initViews$lambda$6(this.f$0, view);
                }
            });
        }
        FragmentClubMyEventsBinding binding5 = getBinding();
        TextView textView3 = binding5 != null ? binding5.tvEditBtn : null;
        if (textView3 != null) {
            textView3.setVisibility(0);
        }
        FragmentClubMyEventsBinding binding6 = getBinding();
        TextView textView4 = binding6 != null ? binding6.tvEditDoneBtn : null;
        if (textView4 != null) {
            textView4.setVisibility(8);
        }
        FragmentClubMyEventsBinding binding7 = getBinding();
        if (binding7 != null && (textView2 = binding7.tvEditBtn) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubMyEventsFragment.initViews$lambda$7(this.f$0, view);
                }
            });
        }
        FragmentClubMyEventsBinding binding8 = getBinding();
        if (binding8 != null && (textView = binding8.tvEditDoneBtn) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$$ExternalSyntheticLambda5
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubMyEventsFragment.initViews$lambda$8(this.f$0, view);
                }
            });
        }
        setupMyOngoingRecyclerView$default(this, false, 1, null);
        getMyOngoingChallengeList$default(this, false, false, 0, null, 15, null);
        setupChallengeList2RecyclerView$default(this, false, 1, null);
        getUpcomingChallengeList$default(this, false, false, 0, null, 15, null);
        setupChallengeList3RecyclerView$default(this, false, 1, null);
        getFinishedChallengeList$default(this, false, false, 0, null, 15, null);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass7(null), 3, null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), null, null, new AnonymousClass8(null), 3, null);
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3), null, null, new AnonymousClass9(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$1(final ClubMyEventsFragment this$0) {
        TextView textView;
        TextView textView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.ongoingListCount = 0;
        this$0.upcomingListCount = 0;
        this$0.finishedListCount = 0;
        this$0.ongoingCurrentPage = 1;
        this$0.list2CurrentPage = 1;
        this$0.list3CurrentPage = 1;
        this$0.hasMoreOngoingData = true;
        this$0.hasMoreList2Data = true;
        this$0.hasMoreList3Data = true;
        this$0.isOngoingListEnd = false;
        this$0.isUpcomingListEnd = false;
        this$0.isFinishedListEnd = false;
        FragmentClubMyEventsBinding binding = this$0.getBinding();
        View view = binding != null ? binding.underlineAll : null;
        if (view != null) {
            view.setVisibility(0);
        }
        FragmentClubMyEventsBinding binding2 = this$0.getBinding();
        View view2 = binding2 != null ? binding2.underlineCreatedByMe : null;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        MainActivity mainActivity = this$0.getMainActivity();
        if (mainActivity != null) {
            FragmentClubMyEventsBinding binding3 = this$0.getBinding();
            if (binding3 != null && (textView2 = binding3.tvAllBtnText) != null) {
                textView2.setTextColor(ContextCompat.getColor(mainActivity, R.color.colorLabel_label1));
            }
            FragmentClubMyEventsBinding binding4 = this$0.getBinding();
            if (binding4 != null && (textView = binding4.tvCreatedByMeBtnText) != null) {
                textView.setTextColor(ContextCompat.getColor(mainActivity, R.color.colorLabel_label3));
            }
        }
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 3;
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$initViews$1$onOneComplete$1
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
                intRef.element--;
                if (intRef.element <= 0) {
                    FragmentClubMyEventsBinding fragmentClubMyEventsBindingAccess$getBinding = ClubMyEventsFragment.access$getBinding(this$0);
                    SwipeRefreshLayout swipeRefreshLayout = fragmentClubMyEventsBindingAccess$getBinding != null ? fragmentClubMyEventsBindingAccess$getBinding.swipeRefresh : null;
                    if (swipeRefreshLayout == null) {
                        return;
                    }
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        };
        getMyOngoingChallengeList$default(this$0, false, false, 0, function0, 7, null);
        getUpcomingChallengeList$default(this$0, false, false, 0, function0, 7, null);
        getFinishedChallengeList$default(this$0, false, false, 0, function0, 7, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$2(ClubMyEventsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.safeNavigateUp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$4(ClubMyEventsFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentClubMyEventsBinding binding = this$0.getBinding();
        View view2 = binding != null ? binding.underlineAll : null;
        if (view2 != null) {
            view2.setVisibility(0);
        }
        FragmentClubMyEventsBinding binding2 = this$0.getBinding();
        View view3 = binding2 != null ? binding2.underlineCreatedByMe : null;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        MainActivity mainActivity = this$0.getMainActivity();
        if (mainActivity != null) {
            FragmentClubMyEventsBinding binding3 = this$0.getBinding();
            if (binding3 != null && (textView2 = binding3.tvAllBtnText) != null) {
                textView2.setTextColor(ContextCompat.getColor(mainActivity, R.color.colorLabel_label1));
            }
            FragmentClubMyEventsBinding binding4 = this$0.getBinding();
            if (binding4 != null && (textView = binding4.tvCreatedByMeBtnText) != null) {
                textView.setTextColor(ContextCompat.getColor(mainActivity, R.color.colorLabel_label3));
            }
        }
        getMyOngoingChallengeList$default(this$0, false, false, 0, null, 15, null);
        getUpcomingChallengeList$default(this$0, false, false, 0, null, 15, null);
        getFinishedChallengeList$default(this$0, false, false, 0, null, 15, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$6(ClubMyEventsFragment this$0, View view) {
        TextView textView;
        TextView textView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentClubMyEventsBinding binding = this$0.getBinding();
        View view2 = binding != null ? binding.underlineAll : null;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        FragmentClubMyEventsBinding binding2 = this$0.getBinding();
        View view3 = binding2 != null ? binding2.underlineCreatedByMe : null;
        if (view3 != null) {
            view3.setVisibility(0);
        }
        MainActivity mainActivity = this$0.getMainActivity();
        if (mainActivity != null) {
            FragmentClubMyEventsBinding binding3 = this$0.getBinding();
            if (binding3 != null && (textView2 = binding3.tvAllBtnText) != null) {
                textView2.setTextColor(ContextCompat.getColor(mainActivity, R.color.colorLabel_label3));
            }
            FragmentClubMyEventsBinding binding4 = this$0.getBinding();
            if (binding4 != null && (textView = binding4.tvCreatedByMeBtnText) != null) {
                textView.setTextColor(ContextCompat.getColor(mainActivity, R.color.colorLabel_label1));
            }
        }
        getMyOngoingChallengeList$default(this$0, false, true, 0, null, 13, null);
        getUpcomingChallengeList$default(this$0, false, true, 0, null, 13, null);
        getFinishedChallengeList$default(this$0, false, true, 0, null, 13, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$7(ClubMyEventsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Timber.INSTANCE.d("Edit", new Object[0]);
        FragmentClubMyEventsBinding binding = this$0.getBinding();
        ClubSearchItemAdapter clubSearchItemAdapter = null;
        TextView textView = binding != null ? binding.tvEditBtn : null;
        if (textView != null) {
            textView.setVisibility(8);
        }
        FragmentClubMyEventsBinding binding2 = this$0.getBinding();
        TextView textView2 = binding2 != null ? binding2.tvEditDoneBtn : null;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        FragmentClubMyEventsBinding binding3 = this$0.getBinding();
        ImageView imageView = binding3 != null ? binding3.imgBack : null;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        this$0.setupMyOngoingRecyclerView(true);
        List<ChallengeItemSimpleData> value = this$0.getClubViewModel().getOngoingList().getValue();
        ClubSearchItemAdapter clubSearchItemAdapter2 = this$0.clubOngoingAdapter;
        if (clubSearchItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clubOngoingAdapter");
            clubSearchItemAdapter2 = null;
        }
        clubSearchItemAdapter2.submitList(value);
        this$0.setupChallengeList2RecyclerView(true);
        List<ChallengeItemSimpleData> value2 = this$0.getClubViewModel().getUpcomingList().getValue();
        ClubSearchItemAdapter clubSearchItemAdapter3 = this$0.challengeList2Adapter;
        if (clubSearchItemAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("challengeList2Adapter");
            clubSearchItemAdapter3 = null;
        }
        clubSearchItemAdapter3.submitList(value2);
        this$0.setupChallengeList3RecyclerView(true);
        List<ChallengeItemSimpleData> value3 = this$0.getClubViewModel().getFinishedList().getValue();
        ClubSearchItemAdapter clubSearchItemAdapter4 = this$0.challengeList3Adapter;
        if (clubSearchItemAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("challengeList3Adapter");
        } else {
            clubSearchItemAdapter = clubSearchItemAdapter4;
        }
        clubSearchItemAdapter.submitList(value3);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$8(ClubMyEventsFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Timber.INSTANCE.d("Save", new Object[0]);
        FragmentClubMyEventsBinding binding = this$0.getBinding();
        ClubSearchItemAdapter clubSearchItemAdapter = null;
        TextView textView = binding != null ? binding.tvEditDoneBtn : null;
        if (textView != null) {
            textView.setVisibility(8);
        }
        FragmentClubMyEventsBinding binding2 = this$0.getBinding();
        TextView textView2 = binding2 != null ? binding2.tvEditBtn : null;
        if (textView2 != null) {
            textView2.setVisibility(0);
        }
        FragmentClubMyEventsBinding binding3 = this$0.getBinding();
        ImageView imageView = binding3 != null ? binding3.imgBack : null;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
        this$0.setupMyOngoingRecyclerView(false);
        List<ChallengeItemSimpleData> value = this$0.getClubViewModel().getOngoingList().getValue();
        ClubSearchItemAdapter clubSearchItemAdapter2 = this$0.clubOngoingAdapter;
        if (clubSearchItemAdapter2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clubOngoingAdapter");
            clubSearchItemAdapter2 = null;
        }
        clubSearchItemAdapter2.submitList(value);
        this$0.setupChallengeList2RecyclerView(false);
        List<ChallengeItemSimpleData> value2 = this$0.getClubViewModel().getUpcomingList().getValue();
        ClubSearchItemAdapter clubSearchItemAdapter3 = this$0.challengeList2Adapter;
        if (clubSearchItemAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("challengeList2Adapter");
            clubSearchItemAdapter3 = null;
        }
        clubSearchItemAdapter3.submitList(value2);
        this$0.setupChallengeList3RecyclerView(false);
        List<ChallengeItemSimpleData> value3 = this$0.getClubViewModel().getFinishedList().getValue();
        ClubSearchItemAdapter clubSearchItemAdapter4 = this$0.challengeList3Adapter;
        if (clubSearchItemAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("challengeList3Adapter");
        } else {
            clubSearchItemAdapter = clubSearchItemAdapter4;
        }
        clubSearchItemAdapter.submitList(value3);
    }

    /* compiled from: ClubMyEventsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$initViews$7", f = "ClubMyEventsFragment.kt", i = {}, l = {WinError.ERROR_CANNOT_COPY}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$initViews$7, reason: invalid class name */
    static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass7(Continuation<? super AnonymousClass7> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubMyEventsFragment.this.new AnonymousClass7(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ClubMyEventsFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$initViews$7$1", f = "ClubMyEventsFragment.kt", i = {}, l = {268}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$initViews$7$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ClubMyEventsFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ClubMyEventsFragment clubMyEventsFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = clubMyEventsFragment;
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
                    MutableStateFlow<List<ChallengeItemSimpleData>> ongoingList = this.this$0.getClubViewModel().getOngoingList();
                    final ClubMyEventsFragment clubMyEventsFragment = this.this$0;
                    this.label = 1;
                    if (ongoingList.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment.initViews.7.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((List<ChallengeItemSimpleData>) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(List<ChallengeItemSimpleData> list, Continuation<? super Unit> continuation) {
                            ClubSearchItemAdapter clubSearchItemAdapter = clubMyEventsFragment.clubOngoingAdapter;
                            if (clubSearchItemAdapter == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("clubOngoingAdapter");
                                clubSearchItemAdapter = null;
                            }
                            clubSearchItemAdapter.submitList(list);
                            FragmentClubMyEventsBinding fragmentClubMyEventsBindingAccess$getBinding = ClubMyEventsFragment.access$getBinding(clubMyEventsFragment);
                            LinearLayout linearLayout = fragmentClubMyEventsBindingAccess$getBinding != null ? fragmentClubMyEventsBindingAccess$getBinding.llOngoingWrap : null;
                            if (linearLayout != null) {
                                linearLayout.setVisibility(0);
                            }
                            if (list.isEmpty()) {
                                FragmentClubMyEventsBinding fragmentClubMyEventsBindingAccess$getBinding2 = ClubMyEventsFragment.access$getBinding(clubMyEventsFragment);
                                LinearLayout linearLayout2 = fragmentClubMyEventsBindingAccess$getBinding2 != null ? fragmentClubMyEventsBindingAccess$getBinding2.llOngoingWrap : null;
                                if (linearLayout2 != null) {
                                    linearLayout2.setVisibility(8);
                                }
                            }
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
                if (RepeatOnLifecycleKt.repeatOnLifecycle(ClubMyEventsFragment.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new AnonymousClass1(ClubMyEventsFragment.this, null), this) == coroutine_suspended) {
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

    /* compiled from: ClubMyEventsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$initViews$8", f = "ClubMyEventsFragment.kt", i = {}, l = {281}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$initViews$8, reason: invalid class name */
    static final class AnonymousClass8 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass8(Continuation<? super AnonymousClass8> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubMyEventsFragment.this.new AnonymousClass8(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass8) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ClubMyEventsFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$initViews$8$1", f = "ClubMyEventsFragment.kt", i = {}, l = {WinError.ERROR_EAS_NOT_SUPPORTED}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$initViews$8$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ClubMyEventsFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ClubMyEventsFragment clubMyEventsFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = clubMyEventsFragment;
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
                    MutableStateFlow<List<ChallengeItemSimpleData>> upcomingList = this.this$0.getClubViewModel().getUpcomingList();
                    final ClubMyEventsFragment clubMyEventsFragment = this.this$0;
                    this.label = 1;
                    if (upcomingList.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment.initViews.8.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((List<ChallengeItemSimpleData>) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(List<ChallengeItemSimpleData> list, Continuation<? super Unit> continuation) {
                            ClubSearchItemAdapter clubSearchItemAdapter = clubMyEventsFragment.challengeList2Adapter;
                            if (clubSearchItemAdapter == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("challengeList2Adapter");
                                clubSearchItemAdapter = null;
                            }
                            clubSearchItemAdapter.submitList(list);
                            FragmentClubMyEventsBinding fragmentClubMyEventsBindingAccess$getBinding = ClubMyEventsFragment.access$getBinding(clubMyEventsFragment);
                            LinearLayout linearLayout = fragmentClubMyEventsBindingAccess$getBinding != null ? fragmentClubMyEventsBindingAccess$getBinding.llUpcomingWrap : null;
                            if (linearLayout != null) {
                                linearLayout.setVisibility(0);
                            }
                            if (list.isEmpty()) {
                                FragmentClubMyEventsBinding fragmentClubMyEventsBindingAccess$getBinding2 = ClubMyEventsFragment.access$getBinding(clubMyEventsFragment);
                                LinearLayout linearLayout2 = fragmentClubMyEventsBindingAccess$getBinding2 != null ? fragmentClubMyEventsBindingAccess$getBinding2.llUpcomingWrap : null;
                                if (linearLayout2 != null) {
                                    linearLayout2.setVisibility(8);
                                }
                            }
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
                if (RepeatOnLifecycleKt.repeatOnLifecycle(ClubMyEventsFragment.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new AnonymousClass1(ClubMyEventsFragment.this, null), this) == coroutine_suspended) {
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

    /* compiled from: ClubMyEventsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$initViews$9", f = "ClubMyEventsFragment.kt", i = {}, l = {295}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$initViews$9, reason: invalid class name */
    static final class AnonymousClass9 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass9(Continuation<? super AnonymousClass9> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubMyEventsFragment.this.new AnonymousClass9(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass9) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ClubMyEventsFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$initViews$9$1", f = "ClubMyEventsFragment.kt", i = {}, l = {296}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$initViews$9$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ClubMyEventsFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ClubMyEventsFragment clubMyEventsFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = clubMyEventsFragment;
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
                    MutableStateFlow<List<ChallengeItemSimpleData>> finishedList = this.this$0.getClubViewModel().getFinishedList();
                    final ClubMyEventsFragment clubMyEventsFragment = this.this$0;
                    this.label = 1;
                    if (finishedList.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment.initViews.9.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((List<ChallengeItemSimpleData>) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(List<ChallengeItemSimpleData> list, Continuation<? super Unit> continuation) {
                            ClubSearchItemAdapter clubSearchItemAdapter = clubMyEventsFragment.challengeList3Adapter;
                            if (clubSearchItemAdapter == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("challengeList3Adapter");
                                clubSearchItemAdapter = null;
                            }
                            clubSearchItemAdapter.submitList(list);
                            FragmentClubMyEventsBinding fragmentClubMyEventsBindingAccess$getBinding = ClubMyEventsFragment.access$getBinding(clubMyEventsFragment);
                            LinearLayout linearLayout = fragmentClubMyEventsBindingAccess$getBinding != null ? fragmentClubMyEventsBindingAccess$getBinding.llArchiveWrap : null;
                            if (linearLayout != null) {
                                linearLayout.setVisibility(0);
                            }
                            if (list.isEmpty()) {
                                FragmentClubMyEventsBinding fragmentClubMyEventsBindingAccess$getBinding2 = ClubMyEventsFragment.access$getBinding(clubMyEventsFragment);
                                LinearLayout linearLayout2 = fragmentClubMyEventsBindingAccess$getBinding2 != null ? fragmentClubMyEventsBindingAccess$getBinding2.llArchiveWrap : null;
                                if (linearLayout2 != null) {
                                    linearLayout2.setVisibility(8);
                                }
                            }
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
                if (RepeatOnLifecycleKt.repeatOnLifecycle(ClubMyEventsFragment.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new AnonymousClass1(ClubMyEventsFragment.this, null), this) == coroutine_suspended) {
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

    private final void setupIntegratedScrollListener() {
        FragmentClubMyEventsBinding binding = getBinding();
        Intrinsics.checkNotNull(binding);
        binding.llTopbarTextContent.setVisibility(8);
        final int iApplyDimension = (int) TypedValue.applyDimension(1, 200.0f, getResources().getDisplayMetrics());
        FragmentClubMyEventsBinding binding2 = getBinding();
        Intrinsics.checkNotNull(binding2);
        final LinearLayout llOngoingWrap = binding2.llOngoingWrap;
        Intrinsics.checkNotNullExpressionValue(llOngoingWrap, "llOngoingWrap");
        FragmentClubMyEventsBinding binding3 = getBinding();
        Intrinsics.checkNotNull(binding3);
        final LinearLayout llUpcomingWrap = binding3.llUpcomingWrap;
        Intrinsics.checkNotNullExpressionValue(llUpcomingWrap, "llUpcomingWrap");
        FragmentClubMyEventsBinding binding4 = getBinding();
        Intrinsics.checkNotNull(binding4);
        final LinearLayout llArchiveWrap = binding4.llArchiveWrap;
        Intrinsics.checkNotNullExpressionValue(llArchiveWrap, "llArchiveWrap");
        FragmentClubMyEventsBinding binding5 = getBinding();
        Intrinsics.checkNotNull(binding5);
        binding5.scrollView.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$$ExternalSyntheticLambda7
            @Override // java.lang.Runnable
            public final void run() {
                ClubMyEventsFragment.setupIntegratedScrollListener$lambda$10(this.f$0, llOngoingWrap, llUpcomingWrap, llArchiveWrap, iApplyDimension);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupIntegratedScrollListener$lambda$10(final ClubMyEventsFragment this$0, final LinearLayout ongoingView, final LinearLayout upcomingView, final LinearLayout archiveView, final int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(ongoingView, "$ongoingView");
        Intrinsics.checkNotNullParameter(upcomingView, "$upcomingView");
        Intrinsics.checkNotNullParameter(archiveView, "$archiveView");
        FragmentClubMyEventsBinding binding = this$0.getBinding();
        Intrinsics.checkNotNull(binding);
        binding.scrollView.setOnScrollChangeListener(new View.OnScrollChangeListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$$ExternalSyntheticLambda6
            @Override // android.view.View.OnScrollChangeListener
            public final void onScrollChange(View view, int i2, int i3, int i4, int i5) {
                ClubMyEventsFragment.setupIntegratedScrollListener$lambda$10$lambda$9(ongoingView, upcomingView, archiveView, i, this$0, view, i2, i3, i4, i5);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setupIntegratedScrollListener$lambda$10$lambda$9(LinearLayout ongoingView, LinearLayout upcomingView, LinearLayout archiveView, int i, ClubMyEventsFragment this$0, View view, int i2, int i3, int i4, int i5) {
        Intrinsics.checkNotNullParameter(ongoingView, "$ongoingView");
        Intrinsics.checkNotNullParameter(upcomingView, "$upcomingView");
        Intrinsics.checkNotNullParameter(archiveView, "$archiveView");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int top = ongoingView.getTop();
        int top2 = upcomingView.getTop();
        int top3 = archiveView.getTop();
        if (i3 > i) {
            FragmentClubMyEventsBinding binding = this$0.getBinding();
            Intrinsics.checkNotNull(binding);
            binding.llTopbarTextContent.setVisibility(0);
            FragmentClubMyEventsBinding binding2 = this$0.getBinding();
            Intrinsics.checkNotNull(binding2);
            binding2.tvTopBarTitle.setVisibility(0);
        } else {
            FragmentClubMyEventsBinding binding3 = this$0.getBinding();
            Intrinsics.checkNotNull(binding3);
            binding3.llTopbarTextContent.setVisibility(8);
            FragmentClubMyEventsBinding binding4 = this$0.getBinding();
            Intrinsics.checkNotNull(binding4);
            binding4.tvTopBarTitle.setVisibility(8);
        }
        if (i3 >= top3) {
            if (this$0.finishedListCount != 0) {
                FragmentClubMyEventsBinding binding5 = this$0.getBinding();
                Intrinsics.checkNotNull(binding5);
                binding5.tvStyckyTitle.setText(this$0.getString(R.string.archive));
                FragmentClubMyEventsBinding binding6 = this$0.getBinding();
                Intrinsics.checkNotNull(binding6);
                binding6.tvStickyCount.setText(String.valueOf(this$0.finishedListCount));
            }
        } else if (i3 >= top2) {
            if (this$0.upcomingListCount != 0) {
                FragmentClubMyEventsBinding binding7 = this$0.getBinding();
                Intrinsics.checkNotNull(binding7);
                binding7.tvStyckyTitle.setText(this$0.getString(R.string.upcoming));
                FragmentClubMyEventsBinding binding8 = this$0.getBinding();
                Intrinsics.checkNotNull(binding8);
                binding8.tvStickyCount.setText(String.valueOf(this$0.upcomingListCount));
            }
        } else if (i3 >= top) {
            if (this$0.ongoingListCount != 0) {
                FragmentClubMyEventsBinding binding9 = this$0.getBinding();
                Intrinsics.checkNotNull(binding9);
                binding9.tvStyckyTitle.setText(this$0.getString(R.string.ongoing));
                FragmentClubMyEventsBinding binding10 = this$0.getBinding();
                Intrinsics.checkNotNull(binding10);
                binding10.tvStickyCount.setText(String.valueOf(this$0.ongoingListCount));
            }
        } else if (this$0.finishedListCount != 0) {
            FragmentClubMyEventsBinding binding11 = this$0.getBinding();
            Intrinsics.checkNotNull(binding11);
            binding11.tvStyckyTitle.setText(this$0.getString(R.string.ongoing));
            FragmentClubMyEventsBinding binding12 = this$0.getBinding();
            Intrinsics.checkNotNull(binding12);
            binding12.tvStickyCount.setText(String.valueOf(this$0.ongoingListCount));
        }
        Intrinsics.checkNotNull(view, "null cannot be cast to non-null type androidx.core.widget.NestedScrollView");
        this$0.checkLoadMoreForAllSections((NestedScrollView) view);
    }

    private final void checkLoadMoreForAllSections(NestedScrollView scrollView) {
        if (scrollView.getChildAt(0).getBottom() - (scrollView.getHeight() + scrollView.getScrollY()) < 1000) {
            checkCurrentVisibleSection(scrollView);
        }
    }

    private final void checkCurrentVisibleSection(NestedScrollView scrollView) {
        FragmentClubMyEventsBinding binding = getBinding();
        LinearLayout linearLayout = binding != null ? binding.llOngoingWrap : null;
        FragmentClubMyEventsBinding binding2 = getBinding();
        LinearLayout linearLayout2 = binding2 != null ? binding2.llUpcomingWrap : null;
        FragmentClubMyEventsBinding binding3 = getBinding();
        LinearLayout linearLayout3 = binding3 != null ? binding3.llArchiveWrap : null;
        int scrollY = scrollView.getScrollY();
        int height = scrollView.getHeight();
        if (linearLayout != null && isSectionVisible(linearLayout, scrollY, height)) {
            FragmentClubMyEventsBinding binding4 = getBinding();
            checkLoadMoreForSection(binding4 != null ? binding4.recyclerViewOngoingItems : null, "ongoing", new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$checkCurrentVisibleSection$1$1
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
                    this.this$0.loadMoreOngoingData();
                }
            });
        }
        if (linearLayout2 != null && isSectionVisible(linearLayout2, scrollY, height)) {
            FragmentClubMyEventsBinding binding5 = getBinding();
            checkLoadMoreForSection(binding5 != null ? binding5.recyclerViewUpcomingItems : null, "upcoming", new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$checkCurrentVisibleSection$2$1
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
                    this.this$0.loadMoreList2Data();
                }
            });
        }
        if (linearLayout3 == null || !isSectionVisible(linearLayout3, scrollY, height)) {
            return;
        }
        FragmentClubMyEventsBinding binding6 = getBinding();
        checkLoadMoreForSection(binding6 != null ? binding6.recyclerViewArchiveItems : null, "archive", new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$checkCurrentVisibleSection$3$1
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
                this.this$0.loadMoreList3Data();
            }
        });
    }

    private final boolean isSectionVisible(View section, int scrollY, int scrollViewHeight) {
        return section.getBottom() > scrollY + (-200) && section.getTop() < (scrollY + scrollViewHeight) + 200;
    }

    private final void checkLoadMoreForSection(RecyclerView recyclerView, String sectionType, Function0<Unit> onLoadMore) {
        int itemCount;
        if (recyclerView != null) {
            RecyclerView.LayoutManager layoutManager = recyclerView.getLayoutManager();
            LinearLayoutManager linearLayoutManager = layoutManager instanceof LinearLayoutManager ? (LinearLayoutManager) layoutManager : null;
            if (linearLayoutManager != null && linearLayoutManager.findLastVisibleItemPosition() + 2 >= (itemCount = linearLayoutManager.getItemCount()) && itemCount > 0) {
                int iHashCode = sectionType.hashCode();
                if (iHashCode == -1318566021) {
                    if (sectionType.equals("ongoing")) {
                        if (!this.isOngoingLoading && this.hasMoreOngoingData && !this.isOngoingListEnd) {
                            Timber.INSTANCE.d("[" + sectionType + "] Triggering load more", new Object[0]);
                            this.isOngoingLoading = true;
                            onLoadMore.invoke();
                            return;
                        }
                        Timber.INSTANCE.d("[" + sectionType + "] Skip load more: isOngoingLoading=" + this.isOngoingLoading + ", hasMoreOngoingData=" + this.hasMoreOngoingData + ", isOngoingListEnd=" + this.isOngoingListEnd, new Object[0]);
                        return;
                    }
                    return;
                }
                if (iHashCode == -748101438) {
                    if (sectionType.equals("archive")) {
                        if (!this.isList3Loading && this.hasMoreList3Data && !this.isFinishedListEnd) {
                            Timber.INSTANCE.d("[" + sectionType + "] Triggering load more", new Object[0]);
                            this.isList3Loading = true;
                            onLoadMore.invoke();
                            return;
                        }
                        Timber.INSTANCE.d("[" + sectionType + "] Skip load more: isList3Loading=" + this.isList3Loading + ", hasMoreList3Data=" + this.hasMoreList3Data + ", isFinishedListEnd=" + this.isFinishedListEnd, new Object[0]);
                        return;
                    }
                    return;
                }
                if (iHashCode == 1306691868 && sectionType.equals("upcoming")) {
                    if (!this.isList2Loading && this.hasMoreList2Data && !this.isUpcomingListEnd) {
                        Timber.INSTANCE.d("[" + sectionType + "] Triggering load more", new Object[0]);
                        this.isList2Loading = true;
                        onLoadMore.invoke();
                        return;
                    }
                    Timber.INSTANCE.d("[" + sectionType + "] Skip load more: isList2Loading=" + this.isList2Loading + ", hasMoreList2Data=" + this.hasMoreList2Data + ", isUpcomingListEnd=" + this.isUpcomingListEnd, new Object[0]);
                }
            }
        }
    }

    static /* synthetic */ void setupMyOngoingRecyclerView$default(ClubMyEventsFragment clubMyEventsFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        clubMyEventsFragment.setupMyOngoingRecyclerView(z);
    }

    private final void setupMyOngoingRecyclerView(boolean isEdit) {
        RecyclerView recyclerView;
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null) {
            this.clubOngoingAdapter = new ClubSearchItemAdapter(mainActivity, new ClubSearchItemAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$setupMyOngoingRecyclerView$1$1
                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubSearchItemAdapter.OnItemClickListener
                public void onClick(int position, ChallengeItemSimpleData item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    this.this$0.handleChallengeCardClick(item);
                }

                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubSearchItemAdapter.OnItemClickListener
                public void onQuitClick(int position, ChallengeItemSimpleData item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    this.this$0.handleQuitChallenge(item);
                }

                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubSearchItemAdapter.OnItemClickListener
                public void onDeleteClick(int position, ChallengeItemSimpleData item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    this.this$0.handleDeleteChallenge(item);
                }
            }, true, isEdit);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        FragmentClubMyEventsBinding binding = getBinding();
        if (binding == null || (recyclerView = binding.recyclerViewOngoingItems) == null) {
            return;
        }
        ClubSearchItemAdapter clubSearchItemAdapter = this.clubOngoingAdapter;
        if (clubSearchItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clubOngoingAdapter");
            clubSearchItemAdapter = null;
        }
        recyclerView.setAdapter(clubSearchItemAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
    }

    static /* synthetic */ void setupChallengeList2RecyclerView$default(ClubMyEventsFragment clubMyEventsFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        clubMyEventsFragment.setupChallengeList2RecyclerView(z);
    }

    private final void setupChallengeList2RecyclerView(boolean isEdit) {
        RecyclerView recyclerView;
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null) {
            this.challengeList2Adapter = new ClubSearchItemAdapter(mainActivity, new ClubSearchItemAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$setupChallengeList2RecyclerView$1$1
                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubSearchItemAdapter.OnItemClickListener
                public void onClick(int position, ChallengeItemSimpleData item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    this.this$0.handleChallengeCardClick(item);
                }

                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubSearchItemAdapter.OnItemClickListener
                public void onQuitClick(int position, ChallengeItemSimpleData item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    this.this$0.handleQuitChallenge(item);
                }

                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubSearchItemAdapter.OnItemClickListener
                public void onDeleteClick(int position, ChallengeItemSimpleData item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    this.this$0.handleDeleteChallenge(item);
                }
            }, true, isEdit);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        FragmentClubMyEventsBinding binding = getBinding();
        if (binding == null || (recyclerView = binding.recyclerViewUpcomingItems) == null) {
            return;
        }
        ClubSearchItemAdapter clubSearchItemAdapter = this.challengeList2Adapter;
        if (clubSearchItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("challengeList2Adapter");
            clubSearchItemAdapter = null;
        }
        recyclerView.setAdapter(clubSearchItemAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
    }

    static /* synthetic */ void setupChallengeList3RecyclerView$default(ClubMyEventsFragment clubMyEventsFragment, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        clubMyEventsFragment.setupChallengeList3RecyclerView(z);
    }

    private final void setupChallengeList3RecyclerView(boolean isEdit) {
        RecyclerView recyclerView;
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null) {
            this.challengeList3Adapter = new ClubSearchItemAdapter(mainActivity, new ClubSearchItemAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$setupChallengeList3RecyclerView$1$1
                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubSearchItemAdapter.OnItemClickListener
                public void onClick(int position, ChallengeItemSimpleData item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    this.this$0.handleChallengeCardClick(item);
                }

                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubSearchItemAdapter.OnItemClickListener
                public void onQuitClick(int position, ChallengeItemSimpleData item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    this.this$0.handleQuitChallenge(item);
                }

                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubSearchItemAdapter.OnItemClickListener
                public void onDeleteClick(int position, ChallengeItemSimpleData item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    this.this$0.handleDeleteChallenge(item);
                }
            }, true, isEdit);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        FragmentClubMyEventsBinding binding = getBinding();
        if (binding == null || (recyclerView = binding.recyclerViewArchiveItems) == null) {
            return;
        }
        ClubSearchItemAdapter clubSearchItemAdapter = this.challengeList3Adapter;
        if (clubSearchItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("challengeList3Adapter");
            clubSearchItemAdapter = null;
        }
        recyclerView.setAdapter(clubSearchItemAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setNestedScrollingEnabled(false);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleChallengeCardClick(ChallengeItemSimpleData item) {
        getClubViewModel().setSelectChallengeId(item.getChallengeUuid());
        BaseFragment.safeNavigate$default(this, R.id.clubEventDetailFragment, null, 2, null);
    }

    /* compiled from: ClubMyEventsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$handleQuitChallenge$1", f = "ClubMyEventsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$handleQuitChallenge$1, reason: invalid class name and case insensitive filesystem */
    static final class C09501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ChallengeItemSimpleData $item;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09501(ChallengeItemSimpleData challengeItemSimpleData, Continuation<? super C09501> continuation) {
            super(2, continuation);
            this.$item = challengeItemSimpleData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubMyEventsFragment.this.new C09501(this.$item, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09501) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ClubMyEventsFragment clubMyEventsFragment = ClubMyEventsFragment.this;
            String string = clubMyEventsFragment.getString(R.string.quit_event_title);
            String string2 = ClubMyEventsFragment.this.getString(R.string.quit_event_desc);
            String string3 = ClubMyEventsFragment.this.getString(R.string.quit_event_confirm);
            String string4 = ClubMyEventsFragment.this.getString(R.string.quit_event_cancel);
            final ClubMyEventsFragment clubMyEventsFragment2 = ClubMyEventsFragment.this;
            final ChallengeItemSimpleData challengeItemSimpleData = this.$item;
            CustomDialogKt.showCustomDialog$default(clubMyEventsFragment, string, string2, string3, string4, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment.handleQuitChallenge.1.1
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
                    clubMyEventsFragment2.quitChallenge(challengeItemSimpleData.getChallengeUuid());
                }
            }, null, false, 96, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleQuitChallenge(ChallengeItemSimpleData item) {
        Timber.INSTANCE.d("quit:" + item, new Object[0]);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09501(item, null), 3, null);
    }

    /* compiled from: ClubMyEventsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$handleDeleteChallenge$1", f = "ClubMyEventsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$handleDeleteChallenge$1, reason: invalid class name and case insensitive filesystem */
    static final class C09491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ChallengeItemSimpleData $item;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09491(ChallengeItemSimpleData challengeItemSimpleData, Continuation<? super C09491> continuation) {
            super(2, continuation);
            this.$item = challengeItemSimpleData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubMyEventsFragment.this.new C09491(this.$item, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09491) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            ClubMyEventsFragment clubMyEventsFragment = ClubMyEventsFragment.this;
            String string = clubMyEventsFragment.getString(R.string.delete_event_title);
            String string2 = ClubMyEventsFragment.this.getString(R.string.delete_event_desc);
            String string3 = ClubMyEventsFragment.this.getString(R.string.delete_event_confirm);
            String string4 = ClubMyEventsFragment.this.getString(R.string.delete_event_cancel);
            final ClubMyEventsFragment clubMyEventsFragment2 = ClubMyEventsFragment.this;
            final ChallengeItemSimpleData challengeItemSimpleData = this.$item;
            CustomDialogKt.showCustomDialog$default(clubMyEventsFragment, string, string2, string3, string4, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment.handleDeleteChallenge.1.1
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
                    clubMyEventsFragment2.deleteChallenge(challengeItemSimpleData.getChallengeUuid());
                }
            }, null, false, 96, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleDeleteChallenge(ChallengeItemSimpleData item) {
        Timber.INSTANCE.d("delete:" + item, new Object[0]);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09491(item, null), 3, null);
    }

    /* compiled from: ClubMyEventsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$quitChallenge$1", f = "ClubMyEventsFragment.kt", i = {}, l = {WinError.ERROR_FILE_SYSTEM_LIMITATION}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$quitChallenge$1, reason: invalid class name and case insensitive filesystem */
    static final class C09511 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $challengeUuid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09511(String str, Continuation<? super C09511> continuation) {
            super(2, continuation);
            this.$challengeUuid = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubMyEventsFragment.this.new C09511(this.$challengeUuid, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09511) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objCallQuitChallenge;
            Unit unit;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ClubMyEventsFragment.this.showLoading();
                        this.label = 1;
                        objCallQuitChallenge = DyacoApiKt.callQuitChallenge(new QuitChallengeApiData.RequestBodyData(this.$challengeUuid), this);
                        if (objCallQuitChallenge == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        objCallQuitChallenge = obj;
                    }
                    Response response = (Response) objCallQuitChallenge;
                    ClubMyEventsFragment.this.stopLoading();
                    Timber.INSTANCE.d("callQuitChallenge: " + response, new Object[0]);
                    QuitChallengeApiData.ResponseData responseData = (QuitChallengeApiData.ResponseData) response.body();
                    String errorCode = responseData != null ? responseData.getErrorCode() : null;
                    QuitChallengeApiData.ResponseData responseData2 = (QuitChallengeApiData.ResponseData) response.body();
                    if (responseData2 == null || !responseData2.getSuccess()) {
                        if (ClubMyEventsFragment.this.shouldIgnoreError(errorCode)) {
                            unit = Unit.INSTANCE;
                        } else if (Intrinsics.areEqual(errorCode, ErrorCode.CHALLENGE_NOT_MEMBER_4009.getId())) {
                            BaseFragment.safeNavigate$default(ClubMyEventsFragment.this, R.id.clubMainFragment, null, 2, null);
                            unit = Unit.INSTANCE;
                        } else {
                            Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required)), TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), null), TuplesKt.to(ErrorCode.CHALLENGE_NOT_EXIST_4000.getId(), Boxing.boxInt(R.string.challenge_not_exist)), TuplesKt.to(ErrorCode.CHALLENGE_NOT_ACTIVE_4001.getId(), Boxing.boxInt(R.string.err_4001_challenge_is_not_active)), TuplesKt.to(ErrorCode.CHALLENGE_LEADER_CAN_NOT_QUIT_4011.getId(), Boxing.boxInt(R.string.err_4011_challenge_leader_cant_quit))).get(errorCode);
                            if (num != null) {
                                ClubMyEventsFragment clubMyEventsFragment = ClubMyEventsFragment.this;
                                CustomDialogKt.showCustomDialog$default(clubMyEventsFragment, null, clubMyEventsFragment.getString(num.intValue()), ClubMyEventsFragment.this.getString(R.string.confirm), null, null, null, false, 112, null);
                            } else {
                                ClubMyEventsFragment clubMyEventsFragment2 = ClubMyEventsFragment.this;
                                QuitChallengeApiData.ResponseData responseData3 = (QuitChallengeApiData.ResponseData) response.body();
                                BaseFragment.handleUndefinedError$default(clubMyEventsFragment2, "quitChallenge", errorCode, responseData3 != null ? responseData3.getErrorMessage() : null, false, 8, null);
                            }
                        }
                        return unit;
                    }
                    ClubMyEventsFragment.getMyOngoingChallengeList$default(ClubMyEventsFragment.this, false, false, 0, null, 15, null);
                    ClubMyEventsFragment.getUpcomingChallengeList$default(ClubMyEventsFragment.this, false, false, 0, null, 15, null);
                    ClubMyEventsFragment.getFinishedChallengeList$default(ClubMyEventsFragment.this, false, false, 0, null, 15, null);
                } catch (IOException e) {
                    Timber.INSTANCE.e(e, "API call failed", new Object[0]);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(ClubMyEventsFragment.this, "quitChallenge", message, false, 4, null);
                }
                ClubMyEventsFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                ClubMyEventsFragment.this.stopLoading();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void quitChallenge(String challengeUuid) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09511(challengeUuid, null), 3, null);
    }

    /* compiled from: ClubMyEventsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$deleteChallenge$1", f = "ClubMyEventsFragment.kt", i = {}, l = {WinError.ERROR_REPARSE}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$deleteChallenge$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $challengeUuid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$challengeUuid = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubMyEventsFragment.this.new AnonymousClass1(this.$challengeUuid, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objCallDeleteChallenge;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ClubMyEventsFragment.this.showLoading();
                        this.label = 1;
                        objCallDeleteChallenge = DyacoApiKt.callDeleteChallenge(new DeleteChallengeApiData.RequestBodyData(this.$challengeUuid), this);
                        if (objCallDeleteChallenge == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        objCallDeleteChallenge = obj;
                    }
                    Response response = (Response) objCallDeleteChallenge;
                    Timber.INSTANCE.d("callDeleteChallenge: " + response, new Object[0]);
                    DeleteChallengeApiData.ResponseData responseData = (DeleteChallengeApiData.ResponseData) response.body();
                    String errorCode = responseData != null ? responseData.getErrorCode() : null;
                    DeleteChallengeApiData.ResponseData responseData2 = (DeleteChallengeApiData.ResponseData) response.body();
                    if (responseData2 == null || !responseData2.getSuccess()) {
                        if (ClubMyEventsFragment.this.shouldIgnoreError(errorCode)) {
                            return Unit.INSTANCE;
                        }
                        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required)), TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), null), TuplesKt.to(ErrorCode.CHALLENGE_NOT_EXIST_4000.getId(), Boxing.boxInt(R.string.challenge_pass_code_not_exist)), TuplesKt.to(ErrorCode.CHALLENGE_NOT_LEADER_4007.getId(), Boxing.boxInt(R.string.err_4007_not_challenge_leader)), TuplesKt.to(ErrorCode.CAN_NOT_DELETE_CHALLENGE_WITH_MEMBERS_4012.getId(), Boxing.boxInt(R.string.err_4012_can_t_delete_challenge_with_members)), TuplesKt.to(ErrorCode.INVALID_OPERATION_ON_TARGET_OBJ_STATUS_1045.getId(), Boxing.boxInt(R.string.err_1045_can_t_delete_an_ongoing_challenge_with_members)));
                        DeleteChallengeApiData.ResponseData responseData3 = (DeleteChallengeApiData.ResponseData) response.body();
                        Integer num = (Integer) mapMapOf.get(responseData3 != null ? responseData3.getErrorCode() : null);
                        if (num != null) {
                            LifecycleOwner viewLifecycleOwner = ClubMyEventsFragment.this.getViewLifecycleOwner();
                            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C02251(ClubMyEventsFragment.this, num, null), 3, null);
                        } else {
                            ClubMyEventsFragment clubMyEventsFragment = ClubMyEventsFragment.this;
                            DeleteChallengeApiData.ResponseData responseData4 = (DeleteChallengeApiData.ResponseData) response.body();
                            BaseFragment.handleUndefinedError$default(clubMyEventsFragment, "deleteChallenge", errorCode, responseData4 != null ? responseData4.getErrorMessage() : null, false, 8, null);
                        }
                    } else {
                        ClubMyEventsFragment.getMyOngoingChallengeList$default(ClubMyEventsFragment.this, false, false, 0, null, 15, null);
                        ClubMyEventsFragment.getUpcomingChallengeList$default(ClubMyEventsFragment.this, false, false, 0, null, 15, null);
                        ClubMyEventsFragment.getFinishedChallengeList$default(ClubMyEventsFragment.this, false, false, 0, null, 15, null);
                    }
                } catch (IOException e) {
                    Timber.INSTANCE.e(e, "API call failed", new Object[0]);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(ClubMyEventsFragment.this, "deleteChallenge", message, false, 4, null);
                }
                ClubMyEventsFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                ClubMyEventsFragment.this.stopLoading();
            }
        }

        /* compiled from: ClubMyEventsFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$deleteChallenge$1$1", f = "ClubMyEventsFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$deleteChallenge$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Integer $msgResId;
            int label;
            final /* synthetic */ ClubMyEventsFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02251(ClubMyEventsFragment clubMyEventsFragment, Integer num, Continuation<? super C02251> continuation) {
                super(2, continuation);
                this.this$0 = clubMyEventsFragment;
                this.$msgResId = num;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02251(this.this$0, this.$msgResId, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02251) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ClubMyEventsFragment clubMyEventsFragment = this.this$0;
                CustomDialogKt.showCustomDialog$default(clubMyEventsFragment, null, clubMyEventsFragment.getString(this.$msgResId.intValue()), this.this$0.getString(R.string.confirm), null, null, null, false, 112, null);
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteChallenge(String challengeUuid) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(challengeUuid, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void getMyOngoingChallengeList$default(ClubMyEventsFragment clubMyEventsFragment, boolean z, boolean z2, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        if ((i2 & 4) != 0) {
            i = 100;
        }
        if ((i2 & 8) != 0) {
            function0 = new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment.getMyOngoingChallengeList.1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        clubMyEventsFragment.getMyOngoingChallengeList(z, z2, i, function0);
    }

    private final void getMyOngoingChallengeList(boolean isReset, boolean isCreatedByMe, int pageSize, Function0<Unit> onComplete) {
        if (isReset) {
            this.ongoingCurrentPage = 1;
            this.hasMoreOngoingData = true;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09462(pageSize, isCreatedByMe, isReset, onComplete, null), 3, null);
    }

    /* compiled from: ClubMyEventsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$getMyOngoingChallengeList$2", f = "ClubMyEventsFragment.kt", i = {}, l = {830}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$getMyOngoingChallengeList$2, reason: invalid class name and case insensitive filesystem */
    static final class C09462 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isCreatedByMe;
        final /* synthetic */ boolean $isReset;
        final /* synthetic */ Function0<Unit> $onComplete;
        final /* synthetic */ int $pageSize;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09462(int i, boolean z, boolean z2, Function0<Unit> function0, Continuation<? super C09462> continuation) {
            super(2, continuation);
            this.$pageSize = i;
            this.$isCreatedByMe = z;
            this.$isReset = z2;
            this.$onComplete = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubMyEventsFragment.this.new C09462(this.$pageSize, this.$isCreatedByMe, this.$isReset, this.$onComplete, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09462) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objCallGetMyOnGoingChallenges;
            GetMyOnGoingChallengesApiData.DataMap sysResponseData;
            GetMyOnGoingChallengesApiData.DataMap sysResponseData2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ClubMyEventsFragment.this.showLoading();
                        ClubMyEventsFragment.this.isOngoingLoading = true;
                        Timber.INSTANCE.d("getOngoingChallengeListPage:" + ClubMyEventsFragment.this.ongoingCurrentPage, new Object[0]);
                        this.label = 1;
                        objCallGetMyOnGoingChallenges = DyacoApiKt.callGetMyOnGoingChallenges(new GetMyOnGoingChallengesApiData.RequestBodyData(Boxing.boxInt(ClubMyEventsFragment.this.ongoingCurrentPage), Boxing.boxInt(this.$pageSize), null, null, Boxing.boxBoolean(this.$isCreatedByMe), null, 44, null), this);
                        if (objCallGetMyOnGoingChallenges == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        objCallGetMyOnGoingChallenges = obj;
                    }
                    Response response = (Response) objCallGetMyOnGoingChallenges;
                    Timber.INSTANCE.d("callGetMyOnGoingChallenges: " + response, new Object[0]);
                    GetMyOnGoingChallengesApiData.ResponseData responseData = (GetMyOnGoingChallengesApiData.ResponseData) response.body();
                    Long totalCount = (responseData == null || (sysResponseData2 = responseData.getSysResponseData()) == null) ? null : sysResponseData2.getTotalCount();
                    GetMyOnGoingChallengesApiData.ResponseData responseData2 = (GetMyOnGoingChallengesApiData.ResponseData) response.body();
                    List<ChallengeItemSimpleData> data = (responseData2 == null || (sysResponseData = responseData2.getSysResponseData()) == null) ? null : sysResponseData.getData();
                    Timber.INSTANCE.d("ongoing data size:" + (data != null ? Boxing.boxInt(data.size()) : null), new Object[0]);
                    GetMyOnGoingChallengesApiData.ResponseData responseData3 = (GetMyOnGoingChallengesApiData.ResponseData) response.body();
                    String errorCode = responseData3 != null ? responseData3.getErrorCode() : null;
                    if (totalCount != null) {
                        ClubMyEventsFragment.this.ongoingListCount = (int) totalCount.longValue();
                        FragmentClubMyEventsBinding fragmentClubMyEventsBindingAccess$getBinding = ClubMyEventsFragment.access$getBinding(ClubMyEventsFragment.this);
                        TextView textView = fragmentClubMyEventsBindingAccess$getBinding != null ? fragmentClubMyEventsBindingAccess$getBinding.ongoingTotalCount : null;
                        if (textView != null) {
                            textView.setText(totalCount.toString());
                        }
                    }
                    GetMyOnGoingChallengesApiData.ResponseData responseData4 = (GetMyOnGoingChallengesApiData.ResponseData) response.body();
                    if (responseData4 == null || !responseData4.getSuccess() || data == null) {
                        if (ClubMyEventsFragment.this.shouldIgnoreError(errorCode)) {
                            return Unit.INSTANCE;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required))).get(errorCode);
                        if (num != null) {
                            ClubMyEventsFragment clubMyEventsFragment = ClubMyEventsFragment.this;
                            CustomDialogKt.showCustomDialog$default(clubMyEventsFragment, null, clubMyEventsFragment.getString(num.intValue()), ClubMyEventsFragment.this.getString(R.string.confirm), null, null, null, false, 112, null);
                        } else {
                            ClubMyEventsFragment clubMyEventsFragment2 = ClubMyEventsFragment.this;
                            GetMyOnGoingChallengesApiData.ResponseData responseData5 = (GetMyOnGoingChallengesApiData.ResponseData) response.body();
                            BaseFragment.handleUndefinedError$default(clubMyEventsFragment2, "getMyOngoingChallengeList", errorCode, responseData5 != null ? responseData5.getErrorMessage() : null, false, 8, null);
                        }
                    } else {
                        if (this.$isReset) {
                            ClubMyEventsFragment.this.getClubViewModel().updateOngoingChallengesList(data);
                        } else {
                            ClubMyEventsFragment.this.getClubViewModel().addToOngoingChallengesList(data);
                        }
                        if (data.isEmpty() || data.size() < this.$pageSize) {
                            Timber.INSTANCE.d("ongoing data: end", new Object[0]);
                            ClubMyEventsFragment.this.isOngoingListEnd = true;
                            ClubMyEventsFragment.this.hasMoreOngoingData = false;
                        }
                    }
                } catch (IOException e) {
                    Timber.INSTANCE.e(e, "API call failed", new Object[0]);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(ClubMyEventsFragment.this, "getMyOngoingChallengeList", message, false, 4, null);
                }
                ClubMyEventsFragment.this.stopLoading();
                ClubMyEventsFragment.this.isOngoingLoading = false;
                this.$onComplete.invoke();
                return Unit.INSTANCE;
            } finally {
                ClubMyEventsFragment.this.stopLoading();
                ClubMyEventsFragment.this.isOngoingLoading = false;
                this.$onComplete.invoke();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void getUpcomingChallengeList$default(ClubMyEventsFragment clubMyEventsFragment, boolean z, boolean z2, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        if ((i2 & 4) != 0) {
            i = 100;
        }
        if ((i2 & 8) != 0) {
            function0 = new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment.getUpcomingChallengeList.1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        clubMyEventsFragment.getUpcomingChallengeList(z, z2, i, function0);
    }

    private final void getUpcomingChallengeList(boolean isReset, boolean isCreatedByMe, int pageSize, Function0<Unit> onComplete) {
        if (isReset) {
            this.list2CurrentPage = 1;
            this.hasMoreList2Data = true;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09482(pageSize, isCreatedByMe, isReset, onComplete, null), 3, null);
    }

    /* compiled from: ClubMyEventsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$getUpcomingChallengeList$2", f = "ClubMyEventsFragment.kt", i = {}, l = {923}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$getUpcomingChallengeList$2, reason: invalid class name and case insensitive filesystem */
    static final class C09482 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isCreatedByMe;
        final /* synthetic */ boolean $isReset;
        final /* synthetic */ Function0<Unit> $onComplete;
        final /* synthetic */ int $pageSize;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09482(int i, boolean z, boolean z2, Function0<Unit> function0, Continuation<? super C09482> continuation) {
            super(2, continuation);
            this.$pageSize = i;
            this.$isCreatedByMe = z;
            this.$isReset = z2;
            this.$onComplete = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubMyEventsFragment.this.new C09482(this.$pageSize, this.$isCreatedByMe, this.$isReset, this.$onComplete, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09482) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objCallGetMyComingChallenges;
            GetMyComingChallengesApiData.DataMap sysResponseData;
            GetMyComingChallengesApiData.DataMap sysResponseData2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ClubMyEventsFragment.this.showLoading();
                        ClubMyEventsFragment.this.isList2Loading = true;
                        Timber.INSTANCE.d("getUpcomingChallengeListPage:" + ClubMyEventsFragment.this.list2CurrentPage, new Object[0]);
                        this.label = 1;
                        objCallGetMyComingChallenges = DyacoApiKt.callGetMyComingChallenges(new GetMyComingChallengesApiData.RequestBodyData(Boxing.boxInt(ClubMyEventsFragment.this.list2CurrentPage), Boxing.boxInt(this.$pageSize), null, null, Boxing.boxBoolean(this.$isCreatedByMe), 12, null), this);
                        if (objCallGetMyComingChallenges == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        objCallGetMyComingChallenges = obj;
                    }
                    Response response = (Response) objCallGetMyComingChallenges;
                    Timber.INSTANCE.d("callGetMyComingChallenges: " + response, new Object[0]);
                    GetMyComingChallengesApiData.ResponseData responseData = (GetMyComingChallengesApiData.ResponseData) response.body();
                    Long totalCount = (responseData == null || (sysResponseData2 = responseData.getSysResponseData()) == null) ? null : sysResponseData2.getTotalCount();
                    GetMyComingChallengesApiData.ResponseData responseData2 = (GetMyComingChallengesApiData.ResponseData) response.body();
                    List<ChallengeItemSimpleData> data = (responseData2 == null || (sysResponseData = responseData2.getSysResponseData()) == null) ? null : sysResponseData.getData();
                    GetMyComingChallengesApiData.ResponseData responseData3 = (GetMyComingChallengesApiData.ResponseData) response.body();
                    String errorCode = responseData3 != null ? responseData3.getErrorCode() : null;
                    Timber.INSTANCE.d("upcoming data totalCount:" + totalCount, new Object[0]);
                    if (totalCount != null) {
                        ClubMyEventsFragment.this.upcomingListCount = (int) totalCount.longValue();
                        FragmentClubMyEventsBinding fragmentClubMyEventsBindingAccess$getBinding = ClubMyEventsFragment.access$getBinding(ClubMyEventsFragment.this);
                        TextView textView = fragmentClubMyEventsBindingAccess$getBinding != null ? fragmentClubMyEventsBindingAccess$getBinding.upcomingTotalCount : null;
                        if (textView != null) {
                            textView.setText(totalCount.toString());
                        }
                    }
                    GetMyComingChallengesApiData.ResponseData responseData4 = (GetMyComingChallengesApiData.ResponseData) response.body();
                    if (responseData4 == null || !responseData4.getSuccess() || data == null) {
                        if (ClubMyEventsFragment.this.shouldIgnoreError(errorCode)) {
                            return Unit.INSTANCE;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required))).get(errorCode);
                        if (num != null) {
                            ClubMyEventsFragment clubMyEventsFragment = ClubMyEventsFragment.this;
                            CustomDialogKt.showCustomDialog$default(clubMyEventsFragment, null, clubMyEventsFragment.getString(num.intValue()), ClubMyEventsFragment.this.getString(R.string.confirm), null, null, null, false, 112, null);
                        } else {
                            ClubMyEventsFragment clubMyEventsFragment2 = ClubMyEventsFragment.this;
                            GetMyComingChallengesApiData.ResponseData responseData5 = (GetMyComingChallengesApiData.ResponseData) response.body();
                            BaseFragment.handleUndefinedError$default(clubMyEventsFragment2, "getUpcomingChallengeList", errorCode, responseData5 != null ? responseData5.getErrorMessage() : null, false, 8, null);
                        }
                    } else {
                        if (this.$isReset) {
                            ClubMyEventsFragment.this.getClubViewModel().updateUpcomingChallengesList(data);
                        } else {
                            ClubMyEventsFragment.this.getClubViewModel().addToUpcomingChallengesList(data);
                        }
                        if (data.isEmpty() || data.size() < this.$pageSize) {
                            ClubMyEventsFragment.this.isUpcomingListEnd = true;
                            ClubMyEventsFragment.this.hasMoreList2Data = false;
                        }
                    }
                } catch (IOException e) {
                    Timber.INSTANCE.e(e, "API call failed", new Object[0]);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(ClubMyEventsFragment.this, "getUpcomingChallengeList", message, false, 4, null);
                }
                ClubMyEventsFragment.this.stopLoading();
                ClubMyEventsFragment.this.isList2Loading = false;
                this.$onComplete.invoke();
                return Unit.INSTANCE;
            } finally {
                ClubMyEventsFragment.this.stopLoading();
                ClubMyEventsFragment.this.isList2Loading = false;
                this.$onComplete.invoke();
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void getFinishedChallengeList$default(ClubMyEventsFragment clubMyEventsFragment, boolean z, boolean z2, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            z2 = false;
        }
        if ((i2 & 4) != 0) {
            i = 100;
        }
        if ((i2 & 8) != 0) {
            function0 = new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment.getFinishedChallengeList.1
                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }
            };
        }
        clubMyEventsFragment.getFinishedChallengeList(z, z2, i, function0);
    }

    private final void getFinishedChallengeList(boolean isReset, boolean isCreatedByMe, int pageSize, Function0<Unit> onComplete) {
        if (isReset) {
            this.list3CurrentPage = 1;
            this.hasMoreList3Data = true;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass2(pageSize, isCreatedByMe, isReset, onComplete, null), 3, null);
    }

    /* compiled from: ClubMyEventsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$getFinishedChallengeList$2", f = "ClubMyEventsFragment.kt", i = {}, l = {1018}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMyEventsFragment$getFinishedChallengeList$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isCreatedByMe;
        final /* synthetic */ boolean $isReset;
        final /* synthetic */ Function0<Unit> $onComplete;
        final /* synthetic */ int $pageSize;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i, boolean z, boolean z2, Function0<Unit> function0, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$pageSize = i;
            this.$isCreatedByMe = z;
            this.$isReset = z2;
            this.$onComplete = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubMyEventsFragment.this.new AnonymousClass2(this.$pageSize, this.$isCreatedByMe, this.$isReset, this.$onComplete, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objCallGetMyFinishedChallenges;
            GetMyFinishedChallengesApiData.DataMap sysResponseData;
            GetMyFinishedChallengesApiData.DataMap sysResponseData2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ClubMyEventsFragment.this.showLoading();
                        ClubMyEventsFragment.this.isList3Loading = true;
                        Timber.INSTANCE.d("getFinishedChallengeList:" + ClubMyEventsFragment.this.list3CurrentPage, new Object[0]);
                        this.label = 1;
                        objCallGetMyFinishedChallenges = DyacoApiKt.callGetMyFinishedChallenges(new GetMyFinishedChallengesApiData.RequestBodyData(Boxing.boxInt(ClubMyEventsFragment.this.list3CurrentPage), Boxing.boxInt(this.$pageSize), null, null, Boxing.boxBoolean(this.$isCreatedByMe), 12, null), this);
                        if (objCallGetMyFinishedChallenges == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        objCallGetMyFinishedChallenges = obj;
                    }
                    Response response = (Response) objCallGetMyFinishedChallenges;
                    Timber.INSTANCE.d("callGetMyFinishedChallenges: " + response, new Object[0]);
                    GetMyFinishedChallengesApiData.ResponseData responseData = (GetMyFinishedChallengesApiData.ResponseData) response.body();
                    Long totalCount = (responseData == null || (sysResponseData2 = responseData.getSysResponseData()) == null) ? null : sysResponseData2.getTotalCount();
                    GetMyFinishedChallengesApiData.ResponseData responseData2 = (GetMyFinishedChallengesApiData.ResponseData) response.body();
                    List<ChallengeItemSimpleData> data = (responseData2 == null || (sysResponseData = responseData2.getSysResponseData()) == null) ? null : sysResponseData.getData();
                    GetMyFinishedChallengesApiData.ResponseData responseData3 = (GetMyFinishedChallengesApiData.ResponseData) response.body();
                    String errorCode = responseData3 != null ? responseData3.getErrorCode() : null;
                    if (totalCount != null) {
                        ClubMyEventsFragment.this.finishedListCount = (int) totalCount.longValue();
                        FragmentClubMyEventsBinding fragmentClubMyEventsBindingAccess$getBinding = ClubMyEventsFragment.access$getBinding(ClubMyEventsFragment.this);
                        TextView textView = fragmentClubMyEventsBindingAccess$getBinding != null ? fragmentClubMyEventsBindingAccess$getBinding.archiveTotalCount : null;
                        if (textView != null) {
                            textView.setText(totalCount.toString());
                        }
                    }
                    GetMyFinishedChallengesApiData.ResponseData responseData4 = (GetMyFinishedChallengesApiData.ResponseData) response.body();
                    if (responseData4 == null || !responseData4.getSuccess() || data == null) {
                        if (ClubMyEventsFragment.this.shouldIgnoreError(errorCode)) {
                            return Unit.INSTANCE;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required))).get(errorCode);
                        if (num != null) {
                            ClubMyEventsFragment clubMyEventsFragment = ClubMyEventsFragment.this;
                            CustomDialogKt.showCustomDialog$default(clubMyEventsFragment, null, clubMyEventsFragment.getString(num.intValue()), ClubMyEventsFragment.this.getString(R.string.confirm), null, null, null, false, 112, null);
                        } else {
                            ClubMyEventsFragment clubMyEventsFragment2 = ClubMyEventsFragment.this;
                            GetMyFinishedChallengesApiData.ResponseData responseData5 = (GetMyFinishedChallengesApiData.ResponseData) response.body();
                            BaseFragment.handleUndefinedError$default(clubMyEventsFragment2, "getFinishedChallengeList", errorCode, responseData5 != null ? responseData5.getErrorMessage() : null, false, 8, null);
                        }
                    } else {
                        if (this.$isReset) {
                            ClubMyEventsFragment.this.getClubViewModel().updateFinishedChallengesList(data);
                        } else {
                            ClubMyEventsFragment.this.getClubViewModel().addToFinishedChallengesList(data);
                        }
                        if (data.isEmpty() || data.size() < this.$pageSize) {
                            ClubMyEventsFragment.this.isUpcomingListEnd = true;
                            ClubMyEventsFragment.this.hasMoreList3Data = false;
                        }
                    }
                } catch (IOException e) {
                    Timber.INSTANCE.e(e, "API call failed", new Object[0]);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(ClubMyEventsFragment.this, "getFinishedChallengeList", message, false, 4, null);
                }
                ClubMyEventsFragment.this.stopLoading();
                ClubMyEventsFragment.this.isList3Loading = false;
                this.$onComplete.invoke();
                return Unit.INSTANCE;
            } finally {
                ClubMyEventsFragment.this.stopLoading();
                ClubMyEventsFragment.this.isList3Loading = false;
                this.$onComplete.invoke();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadMoreOngoingData() {
        Timber.INSTANCE.d("loadMoreOngoingData", new Object[0]);
        this.ongoingCurrentPage++;
        getMyOngoingChallengeList$default(this, false, false, 0, null, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadMoreList2Data() {
        Timber.INSTANCE.d("loadMoreList2Data", new Object[0]);
        this.list2CurrentPage++;
        getUpcomingChallengeList$default(this, false, false, 0, null, 14, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadMoreList3Data() {
        Timber.INSTANCE.d("loadMoreList3Data", new Object[0]);
        this.list3CurrentPage++;
        getFinishedChallengeList$default(this, false, false, 0, null, 14, null);
    }

    /* compiled from: ClubMyEventsFragment.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J \u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0006\u0010\u0012\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/club/ClubMyEventsFragment$PaginationScrollVerticalListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", SdkConstants.ATTR_LAYOUT_MANAGER, "Landroidx/recyclerview/widget/LinearLayoutManager;", "onLoadMore", "Lkotlin/Function0;", "", "(Landroidx/recyclerview/widget/LinearLayoutManager;Lkotlin/jvm/functions/Function0;)V", "loading", "", "previousTotal", "", "visibleThreshold", "onScrolled", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", "reset", "setLoading", "isLoading", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PaginationScrollVerticalListener extends RecyclerView.OnScrollListener {
        public static final int $stable = 8;
        private final LinearLayoutManager layoutManager;
        private boolean loading;
        private final Function0<Unit> onLoadMore;
        private int previousTotal;
        private final int visibleThreshold;

        public PaginationScrollVerticalListener(LinearLayoutManager layoutManager, Function0<Unit> onLoadMore) {
            Intrinsics.checkNotNullParameter(layoutManager, "layoutManager");
            Intrinsics.checkNotNullParameter(onLoadMore, "onLoadMore");
            this.layoutManager = layoutManager;
            this.onLoadMore = onLoadMore;
            this.visibleThreshold = 2;
        }

        @Override // androidx.recyclerview.widget.RecyclerView.OnScrollListener
        public void onScrolled(RecyclerView recyclerView, int dx, int dy) {
            Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
            super.onScrolled(recyclerView, dx, dy);
            if (dy <= 0) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            int itemCount = this.layoutManager.getItemCount();
            int iFindFirstVisibleItemPosition = this.layoutManager.findFirstVisibleItemPosition();
            int iFindLastVisibleItemPosition = this.layoutManager.findLastVisibleItemPosition();
            Timber.INSTANCE.d("Scroll info: visibleItemCount=" + childCount + ", totalItemCount=" + itemCount + ", firstVisibleItem=" + iFindFirstVisibleItemPosition + ", loading=" + this.loading + ", previousTotal=" + this.previousTotal, new Object[0]);
            if (this.loading && itemCount > this.previousTotal) {
                this.loading = false;
                this.previousTotal = itemCount;
            }
            if (this.loading || this.visibleThreshold + iFindLastVisibleItemPosition < itemCount) {
                return;
            }
            Timber.INSTANCE.d("Triggering load more... lastVisibleItem=" + iFindLastVisibleItemPosition + ", threshold=" + this.visibleThreshold + ", totalItemCount=" + itemCount, new Object[0]);
            this.loading = true;
            this.onLoadMore.invoke();
        }

        public final void setLoading(boolean isLoading) {
            this.loading = isLoading;
            Timber.INSTANCE.d("ScrollListener setLoading: " + isLoading, new Object[0]);
        }

        public final void reset() {
            this.loading = false;
            this.previousTotal = 0;
            Timber.INSTANCE.d("ScrollListener reset", new Object[0]);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        getClubViewModel().resetOngoingChallengesList();
        getClubViewModel().resetUpcomingChallengesList();
        getClubViewModel().resetFinishedChallengesList();
    }
}
