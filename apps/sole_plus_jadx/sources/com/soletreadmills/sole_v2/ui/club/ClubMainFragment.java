package com.soletreadmills.sole_v2.ui.club;

import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.os.BundleKt;
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
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._data.api.club.GetMyComingChallengesApiData;
import com.soletreadmills.sole_v2._data.api.club.GetMyOnGoingChallengesWithMemberApiData;
import com.soletreadmills.sole_v2._data.api.club.GetPublicChallengesToJoinApiData;
import com.soletreadmills.sole_v2._data.club.ChallengeEditModeTypeSettings;
import com.soletreadmills.sole_v2._data.club.ChallengeItemSimpleData;
import com.soletreadmills.sole_v2._data.club.ChallengeItemSimpleDataWithMemberData;
import com.soletreadmills.sole_v2._data.club.ChallengeTypeSettings;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2.ble.type.BleFtmsMachineType;
import com.soletreadmills.sole_v2.databinding.FragmentClubMainBinding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.adapter.club.ClubListItemAdapter;
import com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapter;
import com.sun.jna.platform.win32.WinError;
import java.io.IOException;
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
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableStateFlow;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: ClubMainFragment.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0014\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u0000 ^2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0002^_B\u0005¢\u0006\u0002\u0010\u0004J,\u00108\u001a\u0002092\b\b\u0002\u0010:\u001a\u00020\u00182\b\b\u0002\u0010;\u001a\u00020-2\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u0002090=H\u0002J,\u0010>\u001a\u0002092\b\b\u0002\u0010:\u001a\u00020\u00182\b\b\u0002\u0010;\u001a\u00020-2\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u0002090=H\u0002J,\u0010?\u001a\u0002092\b\b\u0002\u0010:\u001a\u00020\u00182\b\b\u0002\u0010;\u001a\u00020-2\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u0002090=H\u0002J,\u0010@\u001a\u0002092\b\b\u0002\u0010:\u001a\u00020\u00182\b\b\u0002\u0010;\u001a\u00020-2\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u0002090=H\u0002J,\u0010A\u001a\u0002092\b\b\u0002\u0010:\u001a\u00020\u00182\b\b\u0002\u0010;\u001a\u00020-2\u000e\b\u0002\u0010<\u001a\b\u0012\u0004\u0012\u0002090=H\u0002J\u0010\u0010B\u001a\u0002092\u0006\u0010C\u001a\u00020DH\u0002J\u0010\u0010E\u001a\u0002092\u0006\u0010C\u001a\u00020FH\u0002J\u0010\u0010G\u001a\u0002092\u0006\u0010C\u001a\u00020FH\u0002J\u0010\u0010H\u001a\u0002092\u0006\u0010C\u001a\u00020FH\u0002J\u0010\u0010I\u001a\u0002092\u0006\u0010C\u001a\u00020FH\u0002J\u001a\u0010J\u001a\u00020\u00022\u0006\u0010K\u001a\u00020L2\b\u0010M\u001a\u0004\u0018\u00010NH\u0016J\b\u0010O\u001a\u000209H\u0016J\b\u0010P\u001a\u000209H\u0002J\b\u0010Q\u001a\u000209H\u0002J\b\u0010R\u001a\u000209H\u0002J\b\u0010S\u001a\u000209H\u0002J\b\u0010T\u001a\u000209H\u0002J\u0012\u0010U\u001a\u0002092\b\u0010V\u001a\u0004\u0018\u00010WH\u0016J\b\u0010X\u001a\u000209H\u0016J\b\u0010Y\u001a\u000209H\u0002J\b\u0010Z\u001a\u000209H\u0002J\b\u0010[\u001a\u000209H\u0002J\b\u0010\\\u001a\u000209H\u0002J\b\u0010]\u001a\u000209H\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\f\u001a\u00020\r8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000fR\u001b\u0010\u0012\u001a\u00020\u00138FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u0011\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001d\u001a\u00020\u0018X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u000e\u0010\"\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010(\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020/X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00100\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00101\u001a\u00020/X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00103\u001a\u00020/X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u00020/X\u0082.¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u00020/X\u0082.¢\u0006\u0002\n\u0000¨\u0006`"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/club/ClubMainFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentClubMainBinding;", "Landroid/view/View$OnClickListener;", "()V", "challengeList2Adapter", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubListItemAdapter;", "challengeList3Adapter", "challengeList4Adapter", "challengeList5Adapter", "clubOngoingAdapter", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubOngoingItemAdapter;", "clubRaceViewModel", "Lcom/soletreadmills/sole_v2/ui/club/ClubRaceViewModel;", "getClubRaceViewModel", "()Lcom/soletreadmills/sole_v2/ui/club/ClubRaceViewModel;", "clubRaceViewModel$delegate", "Lkotlin/Lazy;", "clubViewModel", "Lcom/soletreadmills/sole_v2/ui/club/ClubViewModel;", "getClubViewModel", "()Lcom/soletreadmills/sole_v2/ui/club/ClubViewModel;", "clubViewModel$delegate", "hasMoreList2Data", "", "hasMoreList3Data", "hasMoreList4Data", "hasMoreList5Data", "hasMoreOngoingData", "haveToRace", "getHaveToRace", "()Z", "setHaveToRace", "(Z)V", "isList2Loading", "isList3End", "isList3Loading", "isList4End", "isList4Loading", "isList5End", "isList5Loading", "isOngoingLoading", "isOverviewListEnd", "isUpcomingListEnd", "list2CurrentPage", "", "list2ScrollListener", "Lcom/soletreadmills/sole_v2/ui/club/ClubMainFragment$PaginationScrollListener;", "list3CurrentPage", "list3ScrollListener", "list4CurrentPage", "list4ScrollListener", "list5CurrentPage", "list5ScrollListener", "ongoingCurrentPage", "ongoingScrollListener", "getMyOngoingChallengeList", "", "isReset", "pageSize", "onComplete", "Lkotlin/Function0;", "getRankingChallengesList", "getShareGoalsChallengesList", "getUpcomingChallengeList", "getVirtualRacesChallengesList", "handleChallengeCardClick", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleDataWithMemberData;", "handleChallengeCardClick2", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleData;", "handleChallengeCardClick3", "handleChallengeCardClick4", "handleChallengeCardClick5", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "loadMoreList2Data", "loadMoreList3Data", "loadMoreList4Data", "loadMoreList5Data", "loadMoreOngoingData", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onResume", "setupChallengeList2RecyclerView", "setupChallengeList3RecyclerView", "setupChallengeList4RecyclerView", "setupChallengeList5RecyclerView", "setupMyOngoingRecyclerView", "Companion", "PaginationScrollListener", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubMainFragment extends BaseFragment<FragmentClubMainBinding> implements View.OnClickListener {
    private static final String ARG_CHALLENGE_ID = "challenge_id";
    private static final String ARG_CHALLENGE_TYPE = "challenge_type_id";
    private static final String ARG_CHALLENGE_TYPE_ID = "challenge_type";
    private static final String ARG_PAGE_EDIT_MODE_ID = "page_mode_id";
    private ClubListItemAdapter challengeList2Adapter;
    private ClubListItemAdapter challengeList3Adapter;
    private ClubListItemAdapter challengeList4Adapter;
    private ClubListItemAdapter challengeList5Adapter;
    private ClubOngoingItemAdapter clubOngoingAdapter;

    /* renamed from: clubRaceViewModel$delegate, reason: from kotlin metadata */
    private final Lazy clubRaceViewModel;

    /* renamed from: clubViewModel$delegate, reason: from kotlin metadata */
    private final Lazy clubViewModel;
    private boolean haveToRace;
    private boolean isList2Loading;
    private boolean isList3End;
    private boolean isList3Loading;
    private boolean isList4End;
    private boolean isList4Loading;
    private boolean isList5End;
    private boolean isList5Loading;
    private boolean isOngoingLoading;
    private boolean isOverviewListEnd;
    private boolean isUpcomingListEnd;
    private PaginationScrollListener list2ScrollListener;
    private PaginationScrollListener list3ScrollListener;
    private PaginationScrollListener list4ScrollListener;
    private PaginationScrollListener list5ScrollListener;
    private PaginationScrollListener ongoingScrollListener;
    public static final int $stable = 8;
    private int ongoingCurrentPage = 1;
    private boolean hasMoreOngoingData = true;
    private int list2CurrentPage = 1;
    private boolean hasMoreList2Data = true;
    private int list3CurrentPage = 1;
    private boolean hasMoreList3Data = true;
    private int list4CurrentPage = 1;
    private boolean hasMoreList4Data = true;
    private int list5CurrentPage = 1;
    private boolean hasMoreList5Data = true;

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    public ClubMainFragment() {
        final ClubMainFragment clubMainFragment = this;
        final Function0 function0 = null;
        this.clubViewModel = FragmentViewModelLazyKt.createViewModelLazy(clubMainFragment, Reflection.getOrCreateKotlinClass(ClubViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = clubMainFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = clubMainFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = clubMainFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.clubRaceViewModel = FragmentViewModelLazyKt.createViewModelLazy(clubMainFragment, Reflection.getOrCreateKotlinClass(ClubRaceViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = clubMainFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$special$$inlined$activityViewModels$default$5
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
                CreationExtras defaultViewModelCreationExtras = clubMainFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$special$$inlined$activityViewModels$default$6
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = clubMainFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public static final /* synthetic */ FragmentClubMainBinding access$getBinding(ClubMainFragment clubMainFragment) {
        return clubMainFragment.getBinding();
    }

    public final ClubViewModel getClubViewModel() {
        return (ClubViewModel) this.clubViewModel.getValue();
    }

    public final ClubRaceViewModel getClubRaceViewModel() {
        return (ClubRaceViewModel) this.clubRaceViewModel.getValue();
    }

    public final boolean getHaveToRace() {
        return this.haveToRace;
    }

    public final void setHaveToRace(boolean z) {
        this.haveToRace = z;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentClubMainBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentClubMainBinding fragmentClubMainBindingInflate = FragmentClubMainBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentClubMainBindingInflate, "inflate(...)");
        return fragmentClubMainBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        BleManager bleManager;
        super.onResume();
        if (this.haveToRace) {
            this.haveToRace = false;
            MainActivity mainActivity = getMainActivity();
            if (mainActivity == null || (bleManager = mainActivity.getBleManager()) == null || !bleManager.isConnectedFtms()) {
                return;
            }
            BaseFragment.safeNavigate$default(this, R.id.clubRaceFragment, null, 2, null);
        }
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        TextView textView;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        ImageView imageView4;
        LinearLayout linearLayout3;
        SwipeRefreshLayout swipeRefreshLayout;
        NestedScrollView nestedScrollView;
        NestedScrollView nestedScrollView2;
        Resources resources;
        FragmentClubMainBinding binding = getBinding();
        final float fApplyDimension = TypedValue.applyDimension(1, 68.0f, (binding == null || (nestedScrollView2 = binding.scrollView) == null || (resources = nestedScrollView2.getResources()) == null) ? null : resources.getDisplayMetrics());
        FragmentClubMainBinding binding2 = getBinding();
        if (binding2 != null && (nestedScrollView = binding2.scrollView) != null) {
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$$ExternalSyntheticLambda4
                @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                public final void onScrollChange(NestedScrollView nestedScrollView3, int i, int i2, int i3, int i4) {
                    ClubMainFragment.initViews$lambda$0(fApplyDimension, this, nestedScrollView3, i, i2, i3, i4);
                }
            });
        }
        FragmentClubMainBinding binding3 = getBinding();
        if (binding3 != null && (swipeRefreshLayout = binding3.swipeRefresh) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$$ExternalSyntheticLambda5
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    ClubMainFragment.initViews$lambda$1(this.f$0);
                }
            });
        }
        FragmentClubMainBinding binding4 = getBinding();
        if (binding4 != null && (linearLayout3 = binding4.llCreateEvent) != null) {
            linearLayout3.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubMainFragment.initViews$lambda$5(this.f$0, view);
                }
            });
        }
        FragmentClubMainBinding binding5 = getBinding();
        if (binding5 != null && (imageView4 = binding5.imgSearch) != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubMainFragment.initViews$lambda$6(this.f$0, view);
                }
            });
        }
        FragmentClubMainBinding binding6 = getBinding();
        if (binding6 != null && (linearLayout2 = binding6.llJoinById) != null) {
            linearLayout2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubMainFragment.initViews$lambda$7(this.f$0, view);
                }
            });
        }
        FragmentClubMainBinding binding7 = getBinding();
        if (binding7 != null && (linearLayout = binding7.llMyEvents) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubMainFragment.initViews$lambda$8(this.f$0, view);
                }
            });
        }
        FragmentClubMainBinding binding8 = getBinding();
        if (binding8 != null && (textView = binding8.tvAllEvent) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubMainFragment.initViews$lambda$9(this.f$0, view);
                }
            });
        }
        FragmentClubMainBinding binding9 = getBinding();
        if (binding9 != null && (imageView3 = binding9.imgShareGoalsMoreBtn) != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubMainFragment.initViews$lambda$11(this.f$0, view);
                }
            });
        }
        FragmentClubMainBinding binding10 = getBinding();
        if (binding10 != null && (imageView2 = binding10.imgRankingsMoreBtn) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubMainFragment.initViews$lambda$13(this.f$0, view);
                }
            });
        }
        FragmentClubMainBinding binding11 = getBinding();
        if (binding11 != null && (imageView = binding11.imgVirtuslRacesMoreBtn) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubMainFragment.initViews$lambda$15(this.f$0, view);
                }
            });
        }
        setupMyOngoingRecyclerView();
        getMyOngoingChallengeList$default(this, false, 0, null, 7, null);
        setupChallengeList2RecyclerView();
        getUpcomingChallengeList$default(this, false, 0, null, 7, null);
        setupChallengeList3RecyclerView();
        getVirtualRacesChallengesList$default(this, false, 0, null, 7, null);
        setupChallengeList4RecyclerView();
        getShareGoalsChallengesList$default(this, false, 0, null, 7, null);
        setupChallengeList5RecyclerView();
        getRankingChallengesList$default(this, false, 0, null, 7, null);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass11(null), 3, null);
        LifecycleOwner viewLifecycleOwner2 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner2, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner2), null, null, new AnonymousClass12(null), 3, null);
        LifecycleOwner viewLifecycleOwner3 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner3, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner3), null, null, new AnonymousClass13(null), 3, null);
        LifecycleOwner viewLifecycleOwner4 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner4, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner4), null, null, new AnonymousClass14(null), 3, null);
        LifecycleOwner viewLifecycleOwner5 = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner5, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner5), null, null, new AnonymousClass15(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$0(float f, ClubMainFragment this$0, NestedScrollView v, int i, int i2, int i3, int i4) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v, "v");
        if (i2 > f) {
            FragmentClubMainBinding binding = this$0.getBinding();
            textView = binding != null ? binding.title : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        FragmentClubMainBinding binding2 = this$0.getBinding();
        textView = binding2 != null ? binding2.title : null;
        if (textView == null) {
            return;
        }
        textView.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$1(final ClubMainFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        final Ref.IntRef intRef = new Ref.IntRef();
        intRef.element = 5;
        Function0<Unit> function0 = new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$initViews$2$onOneComplete$1
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
                    FragmentClubMainBinding fragmentClubMainBindingAccess$getBinding = ClubMainFragment.access$getBinding(this$0);
                    SwipeRefreshLayout swipeRefreshLayout = fragmentClubMainBindingAccess$getBinding != null ? fragmentClubMainBindingAccess$getBinding.swipeRefresh : null;
                    if (swipeRefreshLayout == null) {
                        return;
                    }
                    swipeRefreshLayout.setRefreshing(false);
                }
            }
        };
        getMyOngoingChallengeList$default(this$0, false, 0, function0, 3, null);
        getUpcomingChallengeList$default(this$0, false, 0, function0, 3, null);
        getVirtualRacesChallengesList$default(this$0, false, 0, function0, 3, null);
        getShareGoalsChallengesList$default(this$0, false, 0, function0, 3, null);
        getRankingChallengesList$default(this$0, false, 0, function0, 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$5(final ClubMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainActivity mainActivity = this$0.getMainActivity();
        if (mainActivity != null) {
            View viewInflate = this$0.getLayoutInflater().inflate(R.layout.dialog_club_select_event_type_bottom_sheet, (ViewGroup) null);
            final BottomSheetDialog bottomSheetDialog = new BottomSheetDialog(mainActivity);
            bottomSheetDialog.setContentView(viewInflate);
            Iterator it = CollectionsKt.listOf((Object[]) new Integer[]{Integer.valueOf(R.id.ll_shareGoal), Integer.valueOf(R.id.ll_ranking), Integer.valueOf(R.id.ll_virtualRace)}).iterator();
            while (it.hasNext()) {
                viewInflate.findViewById(((Number) it.next()).intValue()).setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$$ExternalSyntheticLambda0
                    @Override // android.view.View.OnClickListener
                    public final void onClick(View view2) {
                        ClubMainFragment.initViews$lambda$5$lambda$4$lambda$2(this.f$0, bottomSheetDialog, view2);
                    }
                });
            }
            ((ImageView) viewInflate.findViewById(R.id.imgBack)).setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view2) {
                    ClubMainFragment.initViews$lambda$5$lambda$4$lambda$3(bottomSheetDialog, view2);
                }
            });
            bottomSheetDialog.show();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$5$lambda$4$lambda$2(ClubMainFragment this$0, BottomSheetDialog bottomSheetDialog, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(bottomSheetDialog, "$bottomSheetDialog");
        int id2 = view.getId();
        if (id2 == R.id.ll_shareGoal) {
            this$0.safeNavigate(R.id.clubEditFormFragment, BundleKt.bundleOf(TuplesKt.to(ARG_PAGE_EDIT_MODE_ID, Integer.valueOf(ChallengeEditModeTypeSettings.CREATE.getId())), TuplesKt.to(ARG_CHALLENGE_TYPE, Integer.valueOf(ChallengeTypeSettings.GOAL.getId()))));
        } else if (id2 == R.id.ll_ranking) {
            this$0.safeNavigate(R.id.clubEditFormFragment, BundleKt.bundleOf(TuplesKt.to(ARG_PAGE_EDIT_MODE_ID, Integer.valueOf(ChallengeEditModeTypeSettings.CREATE.getId())), TuplesKt.to(ARG_CHALLENGE_TYPE, Integer.valueOf(ChallengeTypeSettings.RANKING.getId()))));
        } else if (id2 == R.id.ll_virtualRace) {
            this$0.safeNavigate(R.id.clubEditFormFragment, BundleKt.bundleOf(TuplesKt.to(ARG_PAGE_EDIT_MODE_ID, Integer.valueOf(ChallengeEditModeTypeSettings.CREATE.getId())), TuplesKt.to(ARG_CHALLENGE_TYPE, Integer.valueOf(ChallengeTypeSettings.VIRTUAL_RACE.getId()))));
        }
        bottomSheetDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$5$lambda$4$lambda$3(BottomSheetDialog bottomSheetDialog, View view) {
        Intrinsics.checkNotNullParameter(bottomSheetDialog, "$bottomSheetDialog");
        bottomSheetDialog.dismiss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$6(ClubMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseFragment.safeNavigate$default(this$0, R.id.clubSearchEventFragment, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$7(ClubMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseFragment.safeNavigate$default(this$0, R.id.clubJoinEventFragment, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$8(ClubMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseFragment.safeNavigate$default(this$0, R.id.clubMyEventsFragment, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$9(ClubMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseFragment.safeNavigate$default(this$0, R.id.clubAllEventsFragment, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$11(ClubMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bundle bundle = new Bundle();
        bundle.putString(ARG_CHALLENGE_TYPE_ID, "sharedGoal");
        this$0.safeNavigate(R.id.clubAllEventsFragment, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$13(ClubMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bundle bundle = new Bundle();
        bundle.putString(ARG_CHALLENGE_TYPE_ID, "ranking");
        this$0.safeNavigate(R.id.clubAllEventsFragment, bundle);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$15(ClubMainFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Bundle bundle = new Bundle();
        bundle.putString(ARG_CHALLENGE_TYPE_ID, "virtualRace");
        this$0.safeNavigate(R.id.clubAllEventsFragment, bundle);
    }

    /* compiled from: ClubMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMainFragment$initViews$11", f = "ClubMainFragment.kt", i = {}, l = {310}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$initViews$11, reason: invalid class name */
    static final class AnonymousClass11 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass11(Continuation<? super AnonymousClass11> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubMainFragment.this.new AnonymousClass11(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass11) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ClubMainFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMainFragment$initViews$11$1", f = "ClubMainFragment.kt", i = {}, l = {312}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$initViews$11$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ClubMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ClubMainFragment clubMainFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = clubMainFragment;
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
                    MutableStateFlow<List<ChallengeItemSimpleDataWithMemberData>> myOngoingList = this.this$0.getClubViewModel().getMyOngoingList();
                    final ClubMainFragment clubMainFragment = this.this$0;
                    this.label = 1;
                    if (myOngoingList.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment.initViews.11.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((List<ChallengeItemSimpleDataWithMemberData>) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(List<ChallengeItemSimpleDataWithMemberData> list, Continuation<? super Unit> continuation) {
                            LinearLayout linearLayout;
                            ClubOngoingItemAdapter clubOngoingItemAdapter = clubMainFragment.clubOngoingAdapter;
                            if (clubOngoingItemAdapter == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("clubOngoingAdapter");
                                clubOngoingItemAdapter = null;
                            }
                            clubOngoingItemAdapter.submitList(list);
                            if (list.isEmpty()) {
                                FragmentClubMainBinding fragmentClubMainBindingAccess$getBinding = ClubMainFragment.access$getBinding(clubMainFragment);
                                linearLayout = fragmentClubMainBindingAccess$getBinding != null ? fragmentClubMainBindingAccess$getBinding.llOngoingWrap : null;
                                if (linearLayout != null) {
                                    linearLayout.setVisibility(8);
                                }
                            } else {
                                FragmentClubMainBinding fragmentClubMainBindingAccess$getBinding2 = ClubMainFragment.access$getBinding(clubMainFragment);
                                linearLayout = fragmentClubMainBindingAccess$getBinding2 != null ? fragmentClubMainBindingAccess$getBinding2.llOngoingWrap : null;
                                if (linearLayout != null) {
                                    linearLayout.setVisibility(0);
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
                if (RepeatOnLifecycleKt.repeatOnLifecycle(ClubMainFragment.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new AnonymousClass1(ClubMainFragment.this, null), this) == coroutine_suspended) {
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

    /* compiled from: ClubMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMainFragment$initViews$12", f = "ClubMainFragment.kt", i = {}, l = {327}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$initViews$12, reason: invalid class name */
    static final class AnonymousClass12 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass12(Continuation<? super AnonymousClass12> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubMainFragment.this.new AnonymousClass12(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass12) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ClubMainFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMainFragment$initViews$12$1", f = "ClubMainFragment.kt", i = {}, l = {328}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$initViews$12$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ClubMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ClubMainFragment clubMainFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = clubMainFragment;
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
                    final ClubMainFragment clubMainFragment = this.this$0;
                    this.label = 1;
                    if (upcomingList.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment.initViews.12.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((List<ChallengeItemSimpleData>) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(List<ChallengeItemSimpleData> list, Continuation<? super Unit> continuation) {
                            LinearLayout linearLayout;
                            ClubListItemAdapter clubListItemAdapter = clubMainFragment.challengeList2Adapter;
                            if (clubListItemAdapter == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("challengeList2Adapter");
                                clubListItemAdapter = null;
                            }
                            clubListItemAdapter.submitList(list);
                            if (list.isEmpty()) {
                                FragmentClubMainBinding fragmentClubMainBindingAccess$getBinding = ClubMainFragment.access$getBinding(clubMainFragment);
                                linearLayout = fragmentClubMainBindingAccess$getBinding != null ? fragmentClubMainBindingAccess$getBinding.llUpcomingWrap : null;
                                if (linearLayout != null) {
                                    linearLayout.setVisibility(8);
                                }
                            } else {
                                FragmentClubMainBinding fragmentClubMainBindingAccess$getBinding2 = ClubMainFragment.access$getBinding(clubMainFragment);
                                linearLayout = fragmentClubMainBindingAccess$getBinding2 != null ? fragmentClubMainBindingAccess$getBinding2.llUpcomingWrap : null;
                                if (linearLayout != null) {
                                    linearLayout.setVisibility(0);
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
                if (RepeatOnLifecycleKt.repeatOnLifecycle(ClubMainFragment.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new AnonymousClass1(ClubMainFragment.this, null), this) == coroutine_suspended) {
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

    /* compiled from: ClubMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMainFragment$initViews$13", f = "ClubMainFragment.kt", i = {}, l = {342}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$initViews$13, reason: invalid class name */
    static final class AnonymousClass13 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass13(Continuation<? super AnonymousClass13> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubMainFragment.this.new AnonymousClass13(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass13) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ClubMainFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMainFragment$initViews$13$1", f = "ClubMainFragment.kt", i = {}, l = {343}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$initViews$13$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ClubMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ClubMainFragment clubMainFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = clubMainFragment;
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
                    MutableStateFlow<List<ChallengeItemSimpleData>> virtualRacesList = this.this$0.getClubViewModel().getVirtualRacesList();
                    final ClubMainFragment clubMainFragment = this.this$0;
                    this.label = 1;
                    if (virtualRacesList.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment.initViews.13.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((List<ChallengeItemSimpleData>) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(List<ChallengeItemSimpleData> list, Continuation<? super Unit> continuation) {
                            LinearLayout linearLayout;
                            ClubListItemAdapter clubListItemAdapter = clubMainFragment.challengeList3Adapter;
                            if (clubListItemAdapter == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("challengeList3Adapter");
                                clubListItemAdapter = null;
                            }
                            clubListItemAdapter.submitList(list);
                            if (list.isEmpty()) {
                                FragmentClubMainBinding fragmentClubMainBindingAccess$getBinding = ClubMainFragment.access$getBinding(clubMainFragment);
                                linearLayout = fragmentClubMainBindingAccess$getBinding != null ? fragmentClubMainBindingAccess$getBinding.llVirtualRaceWrap : null;
                                if (linearLayout != null) {
                                    linearLayout.setVisibility(8);
                                }
                            } else {
                                FragmentClubMainBinding fragmentClubMainBindingAccess$getBinding2 = ClubMainFragment.access$getBinding(clubMainFragment);
                                linearLayout = fragmentClubMainBindingAccess$getBinding2 != null ? fragmentClubMainBindingAccess$getBinding2.llVirtualRaceWrap : null;
                                if (linearLayout != null) {
                                    linearLayout.setVisibility(0);
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
                if (RepeatOnLifecycleKt.repeatOnLifecycle(ClubMainFragment.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new AnonymousClass1(ClubMainFragment.this, null), this) == coroutine_suspended) {
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

    /* compiled from: ClubMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMainFragment$initViews$14", f = "ClubMainFragment.kt", i = {}, l = {358}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$initViews$14, reason: invalid class name */
    static final class AnonymousClass14 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass14(Continuation<? super AnonymousClass14> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubMainFragment.this.new AnonymousClass14(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass14) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ClubMainFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMainFragment$initViews$14$1", f = "ClubMainFragment.kt", i = {}, l = {359}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$initViews$14$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ClubMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ClubMainFragment clubMainFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = clubMainFragment;
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
                    MutableStateFlow<List<ChallengeItemSimpleData>> shareGoalsList = this.this$0.getClubViewModel().getShareGoalsList();
                    final ClubMainFragment clubMainFragment = this.this$0;
                    this.label = 1;
                    if (shareGoalsList.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment.initViews.14.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((List<ChallengeItemSimpleData>) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(List<ChallengeItemSimpleData> list, Continuation<? super Unit> continuation) {
                            LinearLayout linearLayout;
                            ClubListItemAdapter clubListItemAdapter = clubMainFragment.challengeList4Adapter;
                            if (clubListItemAdapter == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("challengeList4Adapter");
                                clubListItemAdapter = null;
                            }
                            clubListItemAdapter.submitList(list);
                            if (list.isEmpty()) {
                                FragmentClubMainBinding fragmentClubMainBindingAccess$getBinding = ClubMainFragment.access$getBinding(clubMainFragment);
                                linearLayout = fragmentClubMainBindingAccess$getBinding != null ? fragmentClubMainBindingAccess$getBinding.llSharedGoalsWrap : null;
                                if (linearLayout != null) {
                                    linearLayout.setVisibility(8);
                                }
                            } else {
                                FragmentClubMainBinding fragmentClubMainBindingAccess$getBinding2 = ClubMainFragment.access$getBinding(clubMainFragment);
                                linearLayout = fragmentClubMainBindingAccess$getBinding2 != null ? fragmentClubMainBindingAccess$getBinding2.llSharedGoalsWrap : null;
                                if (linearLayout != null) {
                                    linearLayout.setVisibility(0);
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
                if (RepeatOnLifecycleKt.repeatOnLifecycle(ClubMainFragment.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new AnonymousClass1(ClubMainFragment.this, null), this) == coroutine_suspended) {
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

    /* compiled from: ClubMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMainFragment$initViews$15", f = "ClubMainFragment.kt", i = {}, l = {373}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$initViews$15, reason: invalid class name */
    static final class AnonymousClass15 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass15(Continuation<? super AnonymousClass15> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubMainFragment.this.new AnonymousClass15(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass15) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ClubMainFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMainFragment$initViews$15$1", f = "ClubMainFragment.kt", i = {}, l = {374}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$initViews$15$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ ClubMainFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ClubMainFragment clubMainFragment, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = clubMainFragment;
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
                    MutableStateFlow<List<ChallengeItemSimpleData>> rankingsList = this.this$0.getClubViewModel().getRankingsList();
                    final ClubMainFragment clubMainFragment = this.this$0;
                    this.label = 1;
                    if (rankingsList.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment.initViews.15.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((List<ChallengeItemSimpleData>) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(List<ChallengeItemSimpleData> list, Continuation<? super Unit> continuation) {
                            LinearLayout linearLayout;
                            ClubListItemAdapter clubListItemAdapter = clubMainFragment.challengeList5Adapter;
                            if (clubListItemAdapter == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("challengeList5Adapter");
                                clubListItemAdapter = null;
                            }
                            clubListItemAdapter.submitList(list);
                            if (list.isEmpty()) {
                                FragmentClubMainBinding fragmentClubMainBindingAccess$getBinding = ClubMainFragment.access$getBinding(clubMainFragment);
                                linearLayout = fragmentClubMainBindingAccess$getBinding != null ? fragmentClubMainBindingAccess$getBinding.llRankingsWrap : null;
                                if (linearLayout != null) {
                                    linearLayout.setVisibility(8);
                                }
                            } else {
                                FragmentClubMainBinding fragmentClubMainBindingAccess$getBinding2 = ClubMainFragment.access$getBinding(clubMainFragment);
                                linearLayout = fragmentClubMainBindingAccess$getBinding2 != null ? fragmentClubMainBindingAccess$getBinding2.llRankingsWrap : null;
                                if (linearLayout != null) {
                                    linearLayout.setVisibility(0);
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
                if (RepeatOnLifecycleKt.repeatOnLifecycle(ClubMainFragment.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new AnonymousClass1(ClubMainFragment.this, null), this) == coroutine_suspended) {
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

    private final void setupMyOngoingRecyclerView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null) {
            this.clubOngoingAdapter = new ClubOngoingItemAdapter(mainActivity, new ClubOngoingItemAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$setupMyOngoingRecyclerView$1$1

                /* compiled from: ClubMainFragment.kt */
                @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
                public /* synthetic */ class WhenMappings {
                    public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                    static {
                        int[] iArr = new int[BleFtmsMachineType.values().length];
                        try {
                            iArr[BleFtmsMachineType.TREADMILL.ordinal()] = 1;
                        } catch (NoSuchFieldError unused) {
                        }
                        try {
                            iArr[BleFtmsMachineType.BIKE.ordinal()] = 2;
                        } catch (NoSuchFieldError unused2) {
                        }
                        try {
                            iArr[BleFtmsMachineType.ELLIPTICAL.ordinal()] = 3;
                        } catch (NoSuchFieldError unused3) {
                        }
                        try {
                            iArr[BleFtmsMachineType.ROWER.ordinal()] = 4;
                        } catch (NoSuchFieldError unused4) {
                        }
                        $EnumSwitchMapping$0 = iArr;
                    }
                }

                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapter.OnItemClickListener
                public void onClick(int position, ChallengeItemSimpleDataWithMemberData item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    this.this$0.handleChallengeCardClick(item);
                }

                /* JADX WARN: Code restructure failed: missing block: B:48:0x00cd, code lost:
                
                    if (r11 != com.soletreadmills.sole_v2._type.BluetoothConnectType.ROWER) goto L58;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:51:0x00d2, code lost:
                
                    if (r11 != com.soletreadmills.sole_v2._type.BluetoothConnectType.ELLIPTICAL) goto L58;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:54:0x00d7, code lost:
                
                    if (r11 != com.soletreadmills.sole_v2._type.BluetoothConnectType.BIKE) goto L58;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:57:0x00dc, code lost:
                
                    if (r11 != com.soletreadmills.sole_v2._type.BluetoothConnectType.TREADMILL) goto L58;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:58:0x00de, code lost:
                
                    r11 = r10.this$0;
                    com.soletreadmills.sole_v2._extension.CustomDialogKt.showCustomDialog$default(r11, null, r11.getString(com.soletreadmills.sole_v2.R.string.connect_device_not_match), r10.this$0.getString(com.soletreadmills.sole_v2.R.string.confirm), null, null, null, false, 112, null);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:59:0x00fc, code lost:
                
                    return;
                 */
                /* JADX WARN: Code restructure failed: missing block: B:60:0x00fd, code lost:
                
                    com.soletreadmills.sole_v2.ui._base.BaseFragment.safeNavigate$default(r10.this$0, com.soletreadmills.sole_v2.R.id.clubRaceFragment, null, 2, null);
                 */
                /* JADX WARN: Code restructure failed: missing block: B:61:0x0106, code lost:
                
                    return;
                 */
                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapter.OnItemClickListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                    To view partially-correct add '--show-bad-code' argument
                */
                public void onStartRaceClick(int r11, com.soletreadmills.sole_v2._data.club.ChallengeItemSimpleDataWithMemberData r12) {
                    /*
                        Method dump skipped, instructions count: 263
                        To view this dump add '--comments-level debug' option
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$setupMyOngoingRecyclerView$1$1.onStartRaceClick(int, com.soletreadmills.sole_v2._data.club.ChallengeItemSimpleDataWithMemberData):void");
                }
            }, true);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        FragmentClubMainBinding binding = getBinding();
        PaginationScrollListener paginationScrollListener = null;
        if (binding != null && (recyclerView2 = binding.recyclerViewOngoingItems) != null) {
            ClubOngoingItemAdapter clubOngoingItemAdapter = this.clubOngoingAdapter;
            if (clubOngoingItemAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("clubOngoingAdapter");
                clubOngoingItemAdapter = null;
            }
            recyclerView2.setAdapter(clubOngoingItemAdapter);
            recyclerView2.setLayoutManager(linearLayoutManager);
        }
        this.ongoingScrollListener = new PaginationScrollListener(linearLayoutManager, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment.setupMyOngoingRecyclerView.3
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
                ClubMainFragment.this.loadMoreOngoingData();
            }
        });
        FragmentClubMainBinding binding2 = getBinding();
        if (binding2 == null || (recyclerView = binding2.recyclerViewOngoingItems) == null) {
            return;
        }
        PaginationScrollListener paginationScrollListener2 = this.ongoingScrollListener;
        if (paginationScrollListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ongoingScrollListener");
        } else {
            paginationScrollListener = paginationScrollListener2;
        }
        recyclerView.addOnScrollListener(paginationScrollListener);
    }

    private final void setupChallengeList2RecyclerView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null) {
            this.challengeList2Adapter = new ClubListItemAdapter(mainActivity, new ClubListItemAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$setupChallengeList2RecyclerView$1$1
                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubListItemAdapter.OnItemClickListener
                public void onClick(int position, ChallengeItemSimpleData item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    this.this$0.handleChallengeCardClick2(item);
                }
            }, true, false, null, 16, null);
        }
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        FragmentClubMainBinding binding = getBinding();
        PaginationScrollListener paginationScrollListener = null;
        if (binding != null && (recyclerView2 = binding.recyclerViewUpcomingItems) != null) {
            ClubListItemAdapter clubListItemAdapter = this.challengeList2Adapter;
            if (clubListItemAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("challengeList2Adapter");
                clubListItemAdapter = null;
            }
            recyclerView2.setAdapter(clubListItemAdapter);
            recyclerView2.setLayoutManager(linearLayoutManager);
        }
        this.list2ScrollListener = new PaginationScrollListener(linearLayoutManager, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment.setupChallengeList2RecyclerView.3
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
                ClubMainFragment.this.loadMoreList2Data();
            }
        });
        FragmentClubMainBinding binding2 = getBinding();
        if (binding2 == null || (recyclerView = binding2.recyclerViewUpcomingItems) == null) {
            return;
        }
        PaginationScrollListener paginationScrollListener2 = this.list2ScrollListener;
        if (paginationScrollListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("list2ScrollListener");
        } else {
            paginationScrollListener = paginationScrollListener2;
        }
        recyclerView.addOnScrollListener(paginationScrollListener);
    }

    private final void setupChallengeList3RecyclerView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.challengeList3Adapter = new ClubListItemAdapter(contextRequireContext, new ClubListItemAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment.setupChallengeList3RecyclerView.1
            @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubListItemAdapter.OnItemClickListener
            public void onClick(int position, ChallengeItemSimpleData item) {
                Intrinsics.checkNotNullParameter(item, "item");
                ClubMainFragment.this.handleChallengeCardClick3(item);
            }
        }, true, true, null, 16, null);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        FragmentClubMainBinding binding = getBinding();
        PaginationScrollListener paginationScrollListener = null;
        if (binding != null && (recyclerView2 = binding.recyclerViewVirtualRaceItems) != null) {
            ClubListItemAdapter clubListItemAdapter = this.challengeList3Adapter;
            if (clubListItemAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("challengeList3Adapter");
                clubListItemAdapter = null;
            }
            recyclerView2.setAdapter(clubListItemAdapter);
            recyclerView2.setLayoutManager(linearLayoutManager);
        }
        this.list3ScrollListener = new PaginationScrollListener(linearLayoutManager, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment.setupChallengeList3RecyclerView.3
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
                ClubMainFragment.this.loadMoreList3Data();
            }
        });
        FragmentClubMainBinding binding2 = getBinding();
        if (binding2 == null || (recyclerView = binding2.recyclerViewVirtualRaceItems) == null) {
            return;
        }
        PaginationScrollListener paginationScrollListener2 = this.list3ScrollListener;
        if (paginationScrollListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("list3ScrollListener");
        } else {
            paginationScrollListener = paginationScrollListener2;
        }
        recyclerView.addOnScrollListener(paginationScrollListener);
    }

    private final void setupChallengeList4RecyclerView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.challengeList4Adapter = new ClubListItemAdapter(contextRequireContext, new ClubListItemAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment.setupChallengeList4RecyclerView.1
            @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubListItemAdapter.OnItemClickListener
            public void onClick(int position, ChallengeItemSimpleData item) {
                Intrinsics.checkNotNullParameter(item, "item");
                ClubMainFragment.this.handleChallengeCardClick4(item);
            }
        }, true, false, null, 16, null);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        FragmentClubMainBinding binding = getBinding();
        PaginationScrollListener paginationScrollListener = null;
        if (binding != null && (recyclerView2 = binding.recyclerViewsharedGoalItems) != null) {
            ClubListItemAdapter clubListItemAdapter = this.challengeList4Adapter;
            if (clubListItemAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("challengeList4Adapter");
                clubListItemAdapter = null;
            }
            recyclerView2.setAdapter(clubListItemAdapter);
            recyclerView2.setLayoutManager(linearLayoutManager);
        }
        this.list4ScrollListener = new PaginationScrollListener(linearLayoutManager, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment.setupChallengeList4RecyclerView.3
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
                ClubMainFragment.this.loadMoreList4Data();
            }
        });
        FragmentClubMainBinding binding2 = getBinding();
        if (binding2 == null || (recyclerView = binding2.recyclerViewUpcomingItems) == null) {
            return;
        }
        PaginationScrollListener paginationScrollListener2 = this.list4ScrollListener;
        if (paginationScrollListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("list4ScrollListener");
        } else {
            paginationScrollListener = paginationScrollListener2;
        }
        recyclerView.addOnScrollListener(paginationScrollListener);
    }

    private final void setupChallengeList5RecyclerView() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.challengeList5Adapter = new ClubListItemAdapter(contextRequireContext, new ClubListItemAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment.setupChallengeList5RecyclerView.1
            @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubListItemAdapter.OnItemClickListener
            public void onClick(int position, ChallengeItemSimpleData item) {
                Intrinsics.checkNotNullParameter(item, "item");
                ClubMainFragment.this.handleChallengeCardClick5(item);
            }
        }, true, false, null, 16, null);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 0, false);
        FragmentClubMainBinding binding = getBinding();
        PaginationScrollListener paginationScrollListener = null;
        if (binding != null && (recyclerView2 = binding.recyclerViewRankingItems) != null) {
            ClubListItemAdapter clubListItemAdapter = this.challengeList5Adapter;
            if (clubListItemAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("challengeList5Adapter");
                clubListItemAdapter = null;
            }
            recyclerView2.setAdapter(clubListItemAdapter);
            recyclerView2.setLayoutManager(linearLayoutManager);
        }
        this.list5ScrollListener = new PaginationScrollListener(linearLayoutManager, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment.setupChallengeList5RecyclerView.3
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
                ClubMainFragment.this.loadMoreList5Data();
            }
        });
        FragmentClubMainBinding binding2 = getBinding();
        if (binding2 == null || (recyclerView = binding2.recyclerViewUpcomingItems) == null) {
            return;
        }
        PaginationScrollListener paginationScrollListener2 = this.list5ScrollListener;
        if (paginationScrollListener2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("list5ScrollListener");
        } else {
            paginationScrollListener = paginationScrollListener2;
        }
        recyclerView.addOnScrollListener(paginationScrollListener);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleChallengeCardClick(ChallengeItemSimpleDataWithMemberData item) {
        getClubViewModel().setSelectChallengeId(item.getChallengeUuid());
        BaseFragment.safeNavigate$default(this, R.id.clubEventDetailFragment, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleChallengeCardClick2(ChallengeItemSimpleData item) {
        getClubViewModel().setSelectChallengeId(item.getChallengeUuid());
        BaseFragment.safeNavigate$default(this, R.id.clubEventDetailFragment, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleChallengeCardClick3(ChallengeItemSimpleData item) {
        getClubViewModel().setSelectChallengeId(item.getChallengeUuid());
        BaseFragment.safeNavigate$default(this, R.id.clubEventDetailFragment, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleChallengeCardClick4(ChallengeItemSimpleData item) {
        getClubViewModel().setSelectChallengeId(item.getChallengeUuid());
        BaseFragment.safeNavigate$default(this, R.id.clubEventDetailFragment, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void handleChallengeCardClick5(ChallengeItemSimpleData item) {
        getClubViewModel().setSelectChallengeId(item.getChallengeUuid());
        BaseFragment.safeNavigate$default(this, R.id.clubEventDetailFragment, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void getMyOngoingChallengeList$default(ClubMainFragment clubMainFragment, boolean z, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            i = 100;
        }
        if ((i2 & 4) != 0) {
            function0 = new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment.getMyOngoingChallengeList.1
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
        clubMainFragment.getMyOngoingChallengeList(z, i, function0);
    }

    private final void getMyOngoingChallengeList(boolean isReset, int pageSize, Function0<Unit> onComplete) {
        if (isReset) {
            PaginationScrollListener paginationScrollListener = this.ongoingScrollListener;
            if (paginationScrollListener == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ongoingScrollListener");
                paginationScrollListener = null;
            }
            paginationScrollListener.reset();
            this.ongoingCurrentPage = 1;
            this.hasMoreOngoingData = true;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass2(pageSize, isReset, onComplete, null), 3, null);
    }

    /* compiled from: ClubMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMainFragment$getMyOngoingChallengeList$2", f = "ClubMainFragment.kt", i = {}, l = {WinError.ERROR_HANDLES_CLOSED}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$getMyOngoingChallengeList$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isReset;
        final /* synthetic */ Function0<Unit> $onComplete;
        final /* synthetic */ int $pageSize;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(int i, boolean z, Function0<Unit> function0, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$pageSize = i;
            this.$isReset = z;
            this.$onComplete = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubMainFragment.this.new AnonymousClass2(this.$pageSize, this.$isReset, this.$onComplete, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PaginationScrollListener paginationScrollListener;
            Object objCallGetMyOnGoingChallengesWithMember;
            GetMyOnGoingChallengesWithMemberApiData.DataMap sysResponseData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            PaginationScrollListener paginationScrollListener2 = null;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ClubMainFragment.this.showLoading();
                        ClubMainFragment.this.isOngoingLoading = true;
                        Timber.INSTANCE.d("getOverviewChallengeListPage:" + ClubMainFragment.this.ongoingCurrentPage, new Object[0]);
                        this.label = 1;
                        objCallGetMyOnGoingChallengesWithMember = DyacoApiKt.callGetMyOnGoingChallengesWithMember(new GetMyOnGoingChallengesWithMemberApiData.RequestBodyData(Boxing.boxInt(ClubMainFragment.this.ongoingCurrentPage), Boxing.boxInt(this.$pageSize), null, null, 12, null), this);
                        if (objCallGetMyOnGoingChallengesWithMember == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        objCallGetMyOnGoingChallengesWithMember = obj;
                    }
                    Response response = (Response) objCallGetMyOnGoingChallengesWithMember;
                    ClubMainFragment.this.stopLoading();
                    Timber.INSTANCE.d("callGetMyOnGoingChallengesWithMember: " + response, new Object[0]);
                    GetMyOnGoingChallengesWithMemberApiData.ResponseData responseData = (GetMyOnGoingChallengesWithMemberApiData.ResponseData) response.body();
                    List<ChallengeItemSimpleDataWithMemberData> data = (responseData == null || (sysResponseData = responseData.getSysResponseData()) == null) ? null : sysResponseData.getData();
                    Timber.INSTANCE.d("ongoing data size:" + (data != null ? Boxing.boxInt(data.size()) : null), new Object[0]);
                    GetMyOnGoingChallengesWithMemberApiData.ResponseData responseData2 = (GetMyOnGoingChallengesWithMemberApiData.ResponseData) response.body();
                    String errorCode = responseData2 != null ? responseData2.getErrorCode() : null;
                    GetMyOnGoingChallengesWithMemberApiData.ResponseData responseData3 = (GetMyOnGoingChallengesWithMemberApiData.ResponseData) response.body();
                    if (responseData3 != null && responseData3.getSuccess() && data != null) {
                        if (this.$isReset) {
                            ClubMainFragment.this.getClubViewModel().updateMyOngoingChallengesList(CollectionsKt.toList(data));
                        } else {
                            ClubMainFragment.this.getClubViewModel().addToMyOngoingChallengesList(CollectionsKt.toList(data));
                        }
                        if (data.isEmpty() || data.size() < this.$pageSize) {
                            Timber.INSTANCE.d("ongoing data: end", new Object[0]);
                            ClubMainFragment.this.isOverviewListEnd = true;
                            ClubMainFragment.this.hasMoreOngoingData = false;
                        }
                    } else {
                        if (ClubMainFragment.this.shouldIgnoreError(errorCode)) {
                            Unit unit = Unit.INSTANCE;
                            ClubMainFragment.this.stopLoading();
                            ClubMainFragment.this.isOngoingLoading = false;
                            PaginationScrollListener paginationScrollListener3 = ClubMainFragment.this.ongoingScrollListener;
                            if (paginationScrollListener3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("ongoingScrollListener");
                            } else {
                                paginationScrollListener2 = paginationScrollListener3;
                            }
                            paginationScrollListener2.setLoading(false);
                            this.$onComplete.invoke();
                            return unit;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required))).get(errorCode);
                        if (num != null) {
                            ClubMainFragment clubMainFragment = ClubMainFragment.this;
                            CustomDialogKt.showCustomDialog$default(clubMainFragment, null, clubMainFragment.getString(num.intValue()), ClubMainFragment.this.getString(R.string.confirm), null, null, null, false, 112, null);
                        } else {
                            ClubMainFragment clubMainFragment2 = ClubMainFragment.this;
                            GetMyOnGoingChallengesWithMemberApiData.ResponseData responseData4 = (GetMyOnGoingChallengesWithMemberApiData.ResponseData) response.body();
                            BaseFragment.handleUndefinedError$default(clubMainFragment2, "getMyOngoingChallengeList", errorCode, responseData4 != null ? responseData4.getErrorMessage() : null, false, 8, null);
                        }
                    }
                    ClubMainFragment.this.stopLoading();
                    ClubMainFragment.this.isOngoingLoading = false;
                    paginationScrollListener = ClubMainFragment.this.ongoingScrollListener;
                } catch (IOException e) {
                    Timber.INSTANCE.e(e, "API call failed", new Object[0]);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(ClubMainFragment.this, "getMyOngoingChallengeList", message, false, 4, null);
                    ClubMainFragment.this.stopLoading();
                    ClubMainFragment.this.isOngoingLoading = false;
                    paginationScrollListener = ClubMainFragment.this.ongoingScrollListener;
                    if (paginationScrollListener == null) {
                    }
                }
                if (paginationScrollListener == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ongoingScrollListener");
                } else {
                    paginationScrollListener2 = paginationScrollListener;
                }
                paginationScrollListener2.setLoading(false);
                this.$onComplete.invoke();
                return Unit.INSTANCE;
            } catch (Throwable th) {
                ClubMainFragment.this.stopLoading();
                ClubMainFragment.this.isOngoingLoading = false;
                PaginationScrollListener paginationScrollListener4 = ClubMainFragment.this.ongoingScrollListener;
                if (paginationScrollListener4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("ongoingScrollListener");
                } else {
                    paginationScrollListener2 = paginationScrollListener4;
                }
                paginationScrollListener2.setLoading(false);
                this.$onComplete.invoke();
                throw th;
            }
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void getUpcomingChallengeList$default(ClubMainFragment clubMainFragment, boolean z, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            i = 100;
        }
        if ((i2 & 4) != 0) {
            function0 = new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment.getUpcomingChallengeList.1
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
        clubMainFragment.getUpcomingChallengeList(z, i, function0);
    }

    /* compiled from: ClubMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMainFragment$getUpcomingChallengeList$2", f = "ClubMainFragment.kt", i = {}, l = {WinError.ERROR_INTERRUPT_VECTOR_ALREADY_CONNECTED}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$getUpcomingChallengeList$2, reason: invalid class name and case insensitive filesystem */
    static final class C09342 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isReset;
        final /* synthetic */ Function0<Unit> $onComplete;
        final /* synthetic */ int $pageSize;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09342(int i, boolean z, Function0<Unit> function0, Continuation<? super C09342> continuation) {
            super(2, continuation);
            this.$pageSize = i;
            this.$isReset = z;
            this.$onComplete = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubMainFragment.this.new C09342(this.$pageSize, this.$isReset, this.$onComplete, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09342) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PaginationScrollListener paginationScrollListener;
            Object objCallGetMyComingChallenges;
            GetMyComingChallengesApiData.DataMap sysResponseData;
            GetMyComingChallengesApiData.DataMap sysResponseData2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            PaginationScrollListener paginationScrollListener2 = null;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ClubMainFragment.this.showLoading();
                        ClubMainFragment.this.isList2Loading = true;
                        Timber.INSTANCE.d("getUpcomingChallengeListPage:" + ClubMainFragment.this.list2CurrentPage, new Object[0]);
                        this.label = 1;
                        objCallGetMyComingChallenges = DyacoApiKt.callGetMyComingChallenges(new GetMyComingChallengesApiData.RequestBodyData(Boxing.boxInt(ClubMainFragment.this.list2CurrentPage), Boxing.boxInt(this.$pageSize), null, null, null, 28, null), this);
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
                    GetMyComingChallengesApiData.ResponseData responseData4 = (GetMyComingChallengesApiData.ResponseData) response.body();
                    if (responseData4 != null && responseData4.getSuccess() && data != null) {
                        if (this.$isReset) {
                            ClubMainFragment.this.getClubViewModel().updateUpcomingChallengesList(data);
                        } else {
                            ClubMainFragment.this.getClubViewModel().addToUpcomingChallengesList(data);
                        }
                        if (data.isEmpty() || data.size() < this.$pageSize) {
                            ClubMainFragment.this.isUpcomingListEnd = true;
                            ClubMainFragment.this.hasMoreList2Data = false;
                        }
                    } else {
                        if (ClubMainFragment.this.shouldIgnoreError(errorCode)) {
                            Unit unit = Unit.INSTANCE;
                            ClubMainFragment.this.stopLoading();
                            ClubMainFragment.this.isList2Loading = false;
                            PaginationScrollListener paginationScrollListener3 = ClubMainFragment.this.list2ScrollListener;
                            if (paginationScrollListener3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("list2ScrollListener");
                            } else {
                                paginationScrollListener2 = paginationScrollListener3;
                            }
                            paginationScrollListener2.setLoading(false);
                            this.$onComplete.invoke();
                            return unit;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required))).get(errorCode);
                        if (num != null) {
                            ClubMainFragment clubMainFragment = ClubMainFragment.this;
                            CustomDialogKt.showCustomDialog$default(clubMainFragment, null, clubMainFragment.getString(num.intValue()), ClubMainFragment.this.getString(R.string.confirm), null, null, null, false, 112, null);
                        } else {
                            ClubMainFragment clubMainFragment2 = ClubMainFragment.this;
                            GetMyComingChallengesApiData.ResponseData responseData5 = (GetMyComingChallengesApiData.ResponseData) response.body();
                            BaseFragment.handleUndefinedError$default(clubMainFragment2, "getUpcomingChallengeList", errorCode, responseData5 != null ? responseData5.getErrorMessage() : null, false, 8, null);
                        }
                    }
                    ClubMainFragment.this.stopLoading();
                    ClubMainFragment.this.isList2Loading = false;
                    paginationScrollListener = ClubMainFragment.this.list2ScrollListener;
                } catch (IOException e) {
                    Timber.INSTANCE.e(e, "API call failed", new Object[0]);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(ClubMainFragment.this, "getUpcomingChallengeList", message, false, 4, null);
                    ClubMainFragment.this.stopLoading();
                    ClubMainFragment.this.isList2Loading = false;
                    paginationScrollListener = ClubMainFragment.this.list2ScrollListener;
                    if (paginationScrollListener == null) {
                    }
                }
                if (paginationScrollListener == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("list2ScrollListener");
                } else {
                    paginationScrollListener2 = paginationScrollListener;
                }
                paginationScrollListener2.setLoading(false);
                this.$onComplete.invoke();
                return Unit.INSTANCE;
            } catch (Throwable th) {
                ClubMainFragment.this.stopLoading();
                ClubMainFragment.this.isList2Loading = false;
                PaginationScrollListener paginationScrollListener4 = ClubMainFragment.this.list2ScrollListener;
                if (paginationScrollListener4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("list2ScrollListener");
                } else {
                    paginationScrollListener2 = paginationScrollListener4;
                }
                paginationScrollListener2.setLoading(false);
                this.$onComplete.invoke();
                throw th;
            }
        }
    }

    private final void getUpcomingChallengeList(boolean isReset, int pageSize, Function0<Unit> onComplete) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09342(pageSize, isReset, onComplete, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void getVirtualRacesChallengesList$default(ClubMainFragment clubMainFragment, boolean z, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            i = 100;
        }
        if ((i2 & 4) != 0) {
            function0 = new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment.getVirtualRacesChallengesList.1
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
        clubMainFragment.getVirtualRacesChallengesList(z, i, function0);
    }

    /* compiled from: ClubMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMainFragment$getVirtualRacesChallengesList$2", f = "ClubMainFragment.kt", i = {}, l = {849}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$getVirtualRacesChallengesList$2, reason: invalid class name and case insensitive filesystem */
    static final class C09362 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isReset;
        final /* synthetic */ Function0<Unit> $onComplete;
        final /* synthetic */ int $pageSize;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09362(int i, boolean z, Function0<Unit> function0, Continuation<? super C09362> continuation) {
            super(2, continuation);
            this.$pageSize = i;
            this.$isReset = z;
            this.$onComplete = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubMainFragment.this.new C09362(this.$pageSize, this.$isReset, this.$onComplete, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09362) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PaginationScrollListener paginationScrollListener;
            Object objCallGetPublicChallengesToJoin;
            GetPublicChallengesToJoinApiData.DataMap sysResponseData;
            GetPublicChallengesToJoinApiData.DataMap sysResponseData2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            PaginationScrollListener paginationScrollListener2 = null;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ClubMainFragment.this.showLoading();
                        ClubMainFragment.this.isList3Loading = true;
                        Timber.INSTANCE.d("GetPublicChallengesToJoin (VIRTUAL RACE):" + ClubMainFragment.this.list3CurrentPage, new Object[0]);
                        this.label = 1;
                        objCallGetPublicChallengesToJoin = DyacoApiKt.callGetPublicChallengesToJoin(new GetPublicChallengesToJoinApiData.RequestBodyData(null, null, Boxing.boxInt(ClubMainFragment.this.list3CurrentPage), Boxing.boxInt(this.$pageSize), CollectionsKt.listOf(Boxing.boxInt(ChallengeTypeSettings.VIRTUAL_RACE.getId())), null, null, 99, null), this);
                        if (objCallGetPublicChallengesToJoin == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        objCallGetPublicChallengesToJoin = obj;
                    }
                    Response response = (Response) objCallGetPublicChallengesToJoin;
                    ClubMainFragment.this.stopLoading();
                    Timber.INSTANCE.d("callGetPublicChallengesToJoin: " + response, new Object[0]);
                    GetPublicChallengesToJoinApiData.ResponseData responseData = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                    Integer totalCount = (responseData == null || (sysResponseData2 = responseData.getSysResponseData()) == null) ? null : sysResponseData2.getTotalCount();
                    GetPublicChallengesToJoinApiData.ResponseData responseData2 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                    List<ChallengeItemSimpleData> data = (responseData2 == null || (sysResponseData = responseData2.getSysResponseData()) == null) ? null : sysResponseData.getData();
                    Timber.INSTANCE.d("virtualRace data totalCount:" + totalCount, new Object[0]);
                    Timber.INSTANCE.d("virtualRace data :" + data, new Object[0]);
                    GetPublicChallengesToJoinApiData.ResponseData responseData3 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                    String errorCode = responseData3 != null ? responseData3.getErrorCode() : null;
                    GetPublicChallengesToJoinApiData.ResponseData responseData4 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                    if (responseData4 != null && responseData4.getSuccess() && data != null) {
                        if (this.$isReset) {
                            ClubMainFragment.this.getClubViewModel().updateVirtualRacesChallengesList(data);
                        } else {
                            ClubMainFragment.this.getClubViewModel().addToVirtualRacesChallengesList(data);
                        }
                        if (data.isEmpty() || data.size() < this.$pageSize) {
                            ClubMainFragment.this.isList3End = true;
                            ClubMainFragment.this.hasMoreList3Data = false;
                        }
                    } else {
                        if (ClubMainFragment.this.shouldIgnoreError(errorCode)) {
                            Unit unit = Unit.INSTANCE;
                            ClubMainFragment.this.stopLoading();
                            ClubMainFragment.this.isList3Loading = false;
                            PaginationScrollListener paginationScrollListener3 = ClubMainFragment.this.list3ScrollListener;
                            if (paginationScrollListener3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("list3ScrollListener");
                            } else {
                                paginationScrollListener2 = paginationScrollListener3;
                            }
                            paginationScrollListener2.setLoading(false);
                            this.$onComplete.invoke();
                            return unit;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required))).get(errorCode);
                        if (num != null) {
                            ClubMainFragment clubMainFragment = ClubMainFragment.this;
                            CustomDialogKt.showCustomDialog$default(clubMainFragment, null, clubMainFragment.getString(num.intValue()), ClubMainFragment.this.getString(R.string.confirm), null, null, null, false, 112, null);
                        } else {
                            ClubMainFragment clubMainFragment2 = ClubMainFragment.this;
                            GetPublicChallengesToJoinApiData.ResponseData responseData5 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                            BaseFragment.handleUndefinedError$default(clubMainFragment2, "getVirtualRacesChallengesList", errorCode, responseData5 != null ? responseData5.getErrorMessage() : null, false, 8, null);
                        }
                    }
                    ClubMainFragment.this.stopLoading();
                    ClubMainFragment.this.isList3Loading = false;
                    paginationScrollListener = ClubMainFragment.this.list3ScrollListener;
                } catch (IOException e) {
                    Timber.INSTANCE.e(e, "API call failed", new Object[0]);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(ClubMainFragment.this, "getVirtualRacesChallengesList", message, false, 4, null);
                    ClubMainFragment.this.stopLoading();
                    ClubMainFragment.this.isList3Loading = false;
                    paginationScrollListener = ClubMainFragment.this.list3ScrollListener;
                    if (paginationScrollListener == null) {
                    }
                }
                if (paginationScrollListener == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("list3ScrollListener");
                } else {
                    paginationScrollListener2 = paginationScrollListener;
                }
                paginationScrollListener2.setLoading(false);
                this.$onComplete.invoke();
                return Unit.INSTANCE;
            } catch (Throwable th) {
                ClubMainFragment.this.stopLoading();
                ClubMainFragment.this.isList3Loading = false;
                PaginationScrollListener paginationScrollListener4 = ClubMainFragment.this.list3ScrollListener;
                if (paginationScrollListener4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("list3ScrollListener");
                } else {
                    paginationScrollListener2 = paginationScrollListener4;
                }
                paginationScrollListener2.setLoading(false);
                this.$onComplete.invoke();
                throw th;
            }
        }
    }

    private final void getVirtualRacesChallengesList(boolean isReset, int pageSize, Function0<Unit> onComplete) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09362(pageSize, isReset, onComplete, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void getShareGoalsChallengesList$default(ClubMainFragment clubMainFragment, boolean z, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            i = 100;
        }
        if ((i2 & 4) != 0) {
            function0 = new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment.getShareGoalsChallengesList.1
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
        clubMainFragment.getShareGoalsChallengesList(z, i, function0);
    }

    /* compiled from: ClubMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMainFragment$getShareGoalsChallengesList$2", f = "ClubMainFragment.kt", i = {}, l = {937}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$getShareGoalsChallengesList$2, reason: invalid class name and case insensitive filesystem */
    static final class C09322 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isReset;
        final /* synthetic */ Function0<Unit> $onComplete;
        final /* synthetic */ int $pageSize;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09322(int i, boolean z, Function0<Unit> function0, Continuation<? super C09322> continuation) {
            super(2, continuation);
            this.$pageSize = i;
            this.$isReset = z;
            this.$onComplete = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubMainFragment.this.new C09322(this.$pageSize, this.$isReset, this.$onComplete, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09322) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PaginationScrollListener paginationScrollListener;
            Object objCallGetPublicChallengesToJoin;
            GetPublicChallengesToJoinApiData.DataMap sysResponseData;
            GetPublicChallengesToJoinApiData.DataMap sysResponseData2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            PaginationScrollListener paginationScrollListener2 = null;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ClubMainFragment.this.showLoading();
                        ClubMainFragment.this.isList4Loading = true;
                        Timber.INSTANCE.d("GetPublicChallengesToJoin (GOAL):" + ClubMainFragment.this.list4CurrentPage, new Object[0]);
                        this.label = 1;
                        objCallGetPublicChallengesToJoin = DyacoApiKt.callGetPublicChallengesToJoin(new GetPublicChallengesToJoinApiData.RequestBodyData(null, null, Boxing.boxInt(ClubMainFragment.this.list4CurrentPage), Boxing.boxInt(this.$pageSize), CollectionsKt.listOf(Boxing.boxInt(ChallengeTypeSettings.GOAL.getId())), null, null, 99, null), this);
                        if (objCallGetPublicChallengesToJoin == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        objCallGetPublicChallengesToJoin = obj;
                    }
                    Response response = (Response) objCallGetPublicChallengesToJoin;
                    ClubMainFragment.this.stopLoading();
                    Timber.INSTANCE.d("callGetPublicChallengesToJoin: " + response, new Object[0]);
                    GetPublicChallengesToJoinApiData.ResponseData responseData = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                    Integer totalCount = (responseData == null || (sysResponseData2 = responseData.getSysResponseData()) == null) ? null : sysResponseData2.getTotalCount();
                    GetPublicChallengesToJoinApiData.ResponseData responseData2 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                    List<ChallengeItemSimpleData> data = (responseData2 == null || (sysResponseData = responseData2.getSysResponseData()) == null) ? null : sysResponseData.getData();
                    GetPublicChallengesToJoinApiData.ResponseData responseData3 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                    String errorCode = responseData3 != null ? responseData3.getErrorCode() : null;
                    Timber.INSTANCE.d("goal data totalCount:" + totalCount, new Object[0]);
                    Timber.INSTANCE.d("goal data :" + data, new Object[0]);
                    GetPublicChallengesToJoinApiData.ResponseData responseData4 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                    if (responseData4 != null && responseData4.getSuccess() && data != null) {
                        if (this.$isReset) {
                            ClubMainFragment.this.getClubViewModel().updateShareGoalsChallengesList(data);
                        } else {
                            ClubMainFragment.this.getClubViewModel().addToShareGoalsChallengesList(data);
                        }
                        if (data.isEmpty() || data.size() < this.$pageSize) {
                            ClubMainFragment.this.isList4End = true;
                            ClubMainFragment.this.hasMoreList4Data = false;
                        }
                    } else {
                        if (ClubMainFragment.this.shouldIgnoreError(errorCode)) {
                            Unit unit = Unit.INSTANCE;
                            ClubMainFragment.this.stopLoading();
                            ClubMainFragment.this.isList4Loading = false;
                            PaginationScrollListener paginationScrollListener3 = ClubMainFragment.this.list4ScrollListener;
                            if (paginationScrollListener3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("list4ScrollListener");
                            } else {
                                paginationScrollListener2 = paginationScrollListener3;
                            }
                            paginationScrollListener2.setLoading(false);
                            this.$onComplete.invoke();
                            return unit;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required))).get(errorCode);
                        if (num != null) {
                            ClubMainFragment clubMainFragment = ClubMainFragment.this;
                            CustomDialogKt.showCustomDialog$default(clubMainFragment, null, clubMainFragment.getString(num.intValue()), ClubMainFragment.this.getString(R.string.confirm), null, null, null, false, 112, null);
                        } else {
                            ClubMainFragment clubMainFragment2 = ClubMainFragment.this;
                            GetPublicChallengesToJoinApiData.ResponseData responseData5 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                            BaseFragment.handleUndefinedError$default(clubMainFragment2, "getShareGoalsChallengesList", errorCode, responseData5 != null ? responseData5.getErrorMessage() : null, false, 8, null);
                        }
                    }
                    ClubMainFragment.this.stopLoading();
                    ClubMainFragment.this.isList4Loading = false;
                    paginationScrollListener = ClubMainFragment.this.list4ScrollListener;
                } catch (IOException e) {
                    Timber.INSTANCE.e(e, "API call failed", new Object[0]);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(ClubMainFragment.this, "getShareGoalsChallengesList", message, false, 4, null);
                    ClubMainFragment.this.stopLoading();
                    ClubMainFragment.this.isList4Loading = false;
                    paginationScrollListener = ClubMainFragment.this.list4ScrollListener;
                    if (paginationScrollListener == null) {
                    }
                }
                if (paginationScrollListener == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("list4ScrollListener");
                } else {
                    paginationScrollListener2 = paginationScrollListener;
                }
                paginationScrollListener2.setLoading(false);
                this.$onComplete.invoke();
                return Unit.INSTANCE;
            } catch (Throwable th) {
                ClubMainFragment.this.stopLoading();
                ClubMainFragment.this.isList4Loading = false;
                PaginationScrollListener paginationScrollListener4 = ClubMainFragment.this.list4ScrollListener;
                if (paginationScrollListener4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("list4ScrollListener");
                } else {
                    paginationScrollListener2 = paginationScrollListener4;
                }
                paginationScrollListener2.setLoading(false);
                this.$onComplete.invoke();
                throw th;
            }
        }
    }

    private final void getShareGoalsChallengesList(boolean isReset, int pageSize, Function0<Unit> onComplete) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09322(pageSize, isReset, onComplete, null), 3, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ void getRankingChallengesList$default(ClubMainFragment clubMainFragment, boolean z, int i, Function0 function0, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            z = true;
        }
        if ((i2 & 2) != 0) {
            i = 100;
        }
        if ((i2 & 4) != 0) {
            function0 = new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMainFragment.getRankingChallengesList.1
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
        clubMainFragment.getRankingChallengesList(z, i, function0);
    }

    /* compiled from: ClubMainFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMainFragment$getRankingChallengesList$2", f = "ClubMainFragment.kt", i = {}, l = {1025}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMainFragment$getRankingChallengesList$2, reason: invalid class name and case insensitive filesystem */
    static final class C09302 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isReset;
        final /* synthetic */ Function0<Unit> $onComplete;
        final /* synthetic */ int $pageSize;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09302(int i, boolean z, Function0<Unit> function0, Continuation<? super C09302> continuation) {
            super(2, continuation);
            this.$pageSize = i;
            this.$isReset = z;
            this.$onComplete = function0;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubMainFragment.this.new C09302(this.$pageSize, this.$isReset, this.$onComplete, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09302) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            PaginationScrollListener paginationScrollListener;
            Object objCallGetPublicChallengesToJoin;
            GetPublicChallengesToJoinApiData.DataMap sysResponseData;
            GetPublicChallengesToJoinApiData.DataMap sysResponseData2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            PaginationScrollListener paginationScrollListener2 = null;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ClubMainFragment.this.showLoading();
                        ClubMainFragment.this.isList5Loading = true;
                        Timber.INSTANCE.d("GetPublicChallengesToJoin (RANKING):" + ClubMainFragment.this.list5CurrentPage, new Object[0]);
                        this.label = 1;
                        objCallGetPublicChallengesToJoin = DyacoApiKt.callGetPublicChallengesToJoin(new GetPublicChallengesToJoinApiData.RequestBodyData(null, null, Boxing.boxInt(ClubMainFragment.this.list5CurrentPage), Boxing.boxInt(this.$pageSize), CollectionsKt.listOf(Boxing.boxInt(ChallengeTypeSettings.RANKING.getId())), null, null, 99, null), this);
                        if (objCallGetPublicChallengesToJoin == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        objCallGetPublicChallengesToJoin = obj;
                    }
                    Response response = (Response) objCallGetPublicChallengesToJoin;
                    ClubMainFragment.this.stopLoading();
                    Timber.INSTANCE.d("callGetPublicChallengesToJoin: " + response, new Object[0]);
                    GetPublicChallengesToJoinApiData.ResponseData responseData = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                    Integer totalCount = (responseData == null || (sysResponseData2 = responseData.getSysResponseData()) == null) ? null : sysResponseData2.getTotalCount();
                    GetPublicChallengesToJoinApiData.ResponseData responseData2 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                    List<ChallengeItemSimpleData> data = (responseData2 == null || (sysResponseData = responseData2.getSysResponseData()) == null) ? null : sysResponseData.getData();
                    GetPublicChallengesToJoinApiData.ResponseData responseData3 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                    String errorCode = responseData3 != null ? responseData3.getErrorCode() : null;
                    Timber.INSTANCE.d("rank data count:" + totalCount, new Object[0]);
                    Timber.INSTANCE.d("rank data :" + data, new Object[0]);
                    GetPublicChallengesToJoinApiData.ResponseData responseData4 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                    if (responseData4 != null && responseData4.getSuccess() && data != null) {
                        if (this.$isReset) {
                            ClubMainFragment.this.getClubViewModel().updateRankingsChallengesList(data);
                        } else {
                            ClubMainFragment.this.getClubViewModel().addToRankingsChallengesList(data);
                        }
                        if (data.isEmpty() || data.size() < this.$pageSize) {
                            ClubMainFragment.this.isList5End = true;
                            ClubMainFragment.this.hasMoreList5Data = false;
                        }
                    } else {
                        if (ClubMainFragment.this.shouldIgnoreError(errorCode)) {
                            Unit unit = Unit.INSTANCE;
                            ClubMainFragment.this.stopLoading();
                            ClubMainFragment.this.isList5Loading = false;
                            PaginationScrollListener paginationScrollListener3 = ClubMainFragment.this.list5ScrollListener;
                            if (paginationScrollListener3 == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("list5ScrollListener");
                            } else {
                                paginationScrollListener2 = paginationScrollListener3;
                            }
                            paginationScrollListener2.setLoading(false);
                            this.$onComplete.invoke();
                            return unit;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required))).get(errorCode);
                        if (num != null) {
                            ClubMainFragment clubMainFragment = ClubMainFragment.this;
                            CustomDialogKt.showCustomDialog$default(clubMainFragment, null, clubMainFragment.getString(num.intValue()), ClubMainFragment.this.getString(R.string.confirm), null, null, null, false, 112, null);
                        } else {
                            ClubMainFragment clubMainFragment2 = ClubMainFragment.this;
                            GetPublicChallengesToJoinApiData.ResponseData responseData5 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                            BaseFragment.handleUndefinedError$default(clubMainFragment2, "getRankingChallengesList", errorCode, responseData5 != null ? responseData5.getErrorMessage() : null, false, 8, null);
                        }
                    }
                    ClubMainFragment.this.stopLoading();
                    ClubMainFragment.this.isList5Loading = false;
                    paginationScrollListener = ClubMainFragment.this.list5ScrollListener;
                } catch (IOException e) {
                    Timber.INSTANCE.e(e, "API call failed", new Object[0]);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(ClubMainFragment.this, "getRankingChallengesList", message, false, 4, null);
                    ClubMainFragment.this.stopLoading();
                    ClubMainFragment.this.isList5Loading = false;
                    paginationScrollListener = ClubMainFragment.this.list5ScrollListener;
                    if (paginationScrollListener == null) {
                    }
                }
                if (paginationScrollListener == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("list5ScrollListener");
                } else {
                    paginationScrollListener2 = paginationScrollListener;
                }
                paginationScrollListener2.setLoading(false);
                this.$onComplete.invoke();
                return Unit.INSTANCE;
            } catch (Throwable th) {
                ClubMainFragment.this.stopLoading();
                ClubMainFragment.this.isList5Loading = false;
                PaginationScrollListener paginationScrollListener4 = ClubMainFragment.this.list5ScrollListener;
                if (paginationScrollListener4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("list5ScrollListener");
                } else {
                    paginationScrollListener2 = paginationScrollListener4;
                }
                paginationScrollListener2.setLoading(false);
                this.$onComplete.invoke();
                throw th;
            }
        }
    }

    private final void getRankingChallengesList(boolean isReset, int pageSize, Function0<Unit> onComplete) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09302(pageSize, isReset, onComplete, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadMoreOngoingData() {
        Timber.INSTANCE.d("loadMoreOngoingData", new Object[0]);
        if (this.isOngoingLoading || !this.hasMoreOngoingData || this.isOverviewListEnd) {
            return;
        }
        this.ongoingCurrentPage++;
        getMyOngoingChallengeList$default(this, false, 0, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadMoreList2Data() {
        Timber.INSTANCE.d("loadMoreList2Data", new Object[0]);
        if (this.isList2Loading || !this.hasMoreList2Data || this.isUpcomingListEnd) {
            return;
        }
        this.list2CurrentPage++;
        getUpcomingChallengeList$default(this, false, 0, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadMoreList3Data() {
        if (this.isList3Loading || !this.hasMoreList3Data || this.isList3End) {
            return;
        }
        this.list3CurrentPage++;
        getUpcomingChallengeList$default(this, false, 0, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadMoreList4Data() {
        if (this.isList4Loading || !this.hasMoreList4Data || this.isList4End) {
            return;
        }
        this.list4CurrentPage++;
        getUpcomingChallengeList$default(this, false, 0, null, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void loadMoreList5Data() {
        if (this.isList5Loading || !this.hasMoreList5Data || this.isList5End) {
            return;
        }
        this.list5CurrentPage++;
        getUpcomingChallengeList$default(this, false, 0, null, 6, null);
    }

    /* compiled from: ClubMainFragment.kt */
    @Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J \u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000b2\u0006\u0010\u0011\u001a\u00020\u000bH\u0016J\u0006\u0010\u0012\u001a\u00020\u0006J\u000e\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0014\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082D¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/club/ClubMainFragment$PaginationScrollListener;", "Landroidx/recyclerview/widget/RecyclerView$OnScrollListener;", SdkConstants.ATTR_LAYOUT_MANAGER, "Landroidx/recyclerview/widget/LinearLayoutManager;", "onLoadMore", "Lkotlin/Function0;", "", "(Landroidx/recyclerview/widget/LinearLayoutManager;Lkotlin/jvm/functions/Function0;)V", "loading", "", "previousTotal", "", "visibleThreshold", "onScrolled", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "dx", "dy", "reset", "setLoading", "isLoading", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class PaginationScrollListener extends RecyclerView.OnScrollListener {
        public static final int $stable = 8;
        private final LinearLayoutManager layoutManager;
        private boolean loading;
        private final Function0<Unit> onLoadMore;
        private int previousTotal;
        private final int visibleThreshold;

        public PaginationScrollListener(LinearLayoutManager layoutManager, Function0<Unit> onLoadMore) {
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
            if (dx <= 0) {
                return;
            }
            int childCount = recyclerView.getChildCount();
            int itemCount = this.layoutManager.getItemCount();
            int iFindFirstVisibleItemPosition = this.layoutManager.findFirstVisibleItemPosition();
            if (this.loading && itemCount > this.previousTotal) {
                this.loading = false;
                this.previousTotal = itemCount;
            }
            if (this.loading || itemCount - childCount > iFindFirstVisibleItemPosition + this.visibleThreshold) {
                return;
            }
            this.loading = true;
            this.onLoadMore.invoke();
        }

        public final void setLoading(boolean isLoading) {
            this.loading = isLoading;
        }

        public final void reset() {
            this.loading = false;
            this.previousTotal = 0;
        }
    }
}
