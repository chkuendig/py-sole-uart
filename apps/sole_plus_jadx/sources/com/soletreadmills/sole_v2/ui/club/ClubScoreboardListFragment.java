package com.soletreadmills.sole_v2.ui.club;

import android.os.CountDownTimer;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
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
import com.blankj.utilcode.constant.TimeConstants;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._data.api.club.GetChallengeDetailApiData;
import com.soletreadmills.sole_v2._data.club.ChallengeActivityStatus;
import com.soletreadmills.sole_v2._data.club.ChallengeItemFullData;
import com.soletreadmills.sole_v2._data.club.ChallengeMemberData;
import com.soletreadmills.sole_v2._data.club.ChallengePrivacyLevelSettings;
import com.soletreadmills.sole_v2._data.club.ChallengeTypeSettings;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2.databinding.FragmentClubScoreboardListBinding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.adapter.club.ClubScoreItemAdapter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
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
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: ClubScoreboardListFragment.kt */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u0006\b\u0007\u0018\u0000 >2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001>B\u0005¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0002J\u001a\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u00162\b\b\u0002\u0010\u0019\u001a\u00020\u000eH\u0002J\u0010\u0010\u001a\u001a\u00020\u00142\u0006\u0010\u001b\u001a\u00020\u001cH\u0002J\u001a\u0010\u001d\u001a\u00020\u00022\u0006\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010\"\u001a\u00020\u0014H\u0016J\u0016\u0010#\u001a\u00020\u00142\f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u00160%H\u0002J\u0012\u0010&\u001a\u00020\u00142\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020\u0014H\u0002J\b\u0010*\u001a\u00020\u0014H\u0016J*\u0010+\u001a\u00020\u00142\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010/\u001a\u00020\u000e2\b\b\u0002\u00100\u001a\u00020\u0016H\u0002J\"\u00101\u001a\u00020\u00142\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\b\b\u0002\u0010/\u001a\u00020\u000eH\u0002J\"\u00105\u001a\u00020\u00142\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\b\b\u0002\u0010/\u001a\u00020\u000eH\u0002J\"\u00106\u001a\u00020\u00142\u0006\u00102\u001a\u0002032\u0006\u00104\u001a\u0002032\b\b\u0002\u0010/\u001a\u00020\u000eH\u0002J\u0010\u00107\u001a\u00020\u00142\u0006\u00108\u001a\u000209H\u0002J \u0010:\u001a\u00020\u00142\u0006\u0010.\u001a\u00020\u000e2\u0006\u0010;\u001a\u0002032\u0006\u0010<\u001a\u000203H\u0002J\u0010\u0010=\u001a\u00020\u00142\u0006\u00104\u001a\u000203H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0010X\u0082.¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/club/ClubScoreboardListFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentClubScoreboardListBinding;", "Landroid/view/View$OnClickListener;", "()V", "clubViewModel", "Lcom/soletreadmills/sole_v2/ui/club/ClubViewModel;", "getClubViewModel", "()Lcom/soletreadmills/sole_v2/ui/club/ClubViewModel;", "clubViewModel$delegate", "Lkotlin/Lazy;", "countDownTimer", "Landroid/os/CountDownTimer;", "isEditing", "", "memberAllRankAdapter", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubScoreItemAdapter;", "memberOnProgressAdapter", "memberReachedAdapter", "deleteMemberAsk", "", "globalUserUuid", "", "getChallengeDetail", "challengeUuid", "isWithMemberData", "goMemberDetail", "challengeMemberData", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberData;", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "leaderDeleteMember", "globalUserUuids", "", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onCountdownFinished", "onDestroyView", "reloadList", "challengeData", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemFullData;", "isOwner", "isEdit", "searchText", "setupMemberAllRankRecyclerView", "scoreItem", "", "challengeType", "setupMemberOnProgressRecyclerView", "setupMemberReachedRecyclerView", "startCountdown", "endTimeMillis", "", "updateHeaderBtn", "activityStatus", "privacyLevel", "updateView", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubScoreboardListFragment extends BaseFragment<FragmentClubScoreboardListBinding> implements View.OnClickListener {

    /* renamed from: clubViewModel$delegate, reason: from kotlin metadata */
    private final Lazy clubViewModel;
    private CountDownTimer countDownTimer;
    private boolean isEditing;
    private ClubScoreItemAdapter memberAllRankAdapter;
    private ClubScoreItemAdapter memberOnProgressAdapter;
    private ClubScoreItemAdapter memberReachedAdapter;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    public ClubScoreboardListFragment() {
        final ClubScoreboardListFragment clubScoreboardListFragment = this;
        final Function0 function0 = null;
        this.clubViewModel = FragmentViewModelLazyKt.createViewModelLazy(clubScoreboardListFragment, Reflection.getOrCreateKotlinClass(ClubViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = clubScoreboardListFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = clubScoreboardListFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = clubScoreboardListFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public static final /* synthetic */ FragmentClubScoreboardListBinding access$getBinding(ClubScoreboardListFragment clubScoreboardListFragment) {
        return clubScoreboardListFragment.getBinding();
    }

    /* compiled from: ClubScoreboardListFragment.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/club/ClubScoreboardListFragment$Companion;", "", "()V", "newInstance", "Lcom/soletreadmills/sole_v2/ui/club/ClubScoreboardListFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final ClubScoreboardListFragment newInstance() {
            return new ClubScoreboardListFragment();
        }
    }

    public final ClubViewModel getClubViewModel() {
        return (ClubViewModel) this.clubViewModel.getValue();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentClubScoreboardListBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentClubScoreboardListBinding fragmentClubScoreboardListBindingInflate = FragmentClubScoreboardListBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentClubScoreboardListBindingInflate, "inflate(...)");
        return fragmentClubScoreboardListBindingInflate;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r2v2, types: [T, java.lang.Object] */
    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        ImageView imageView;
        AppCompatEditText appCompatEditText;
        TextView textView;
        ImageView imageView2;
        TextView textView2;
        ImageView imageView3;
        Object next;
        SwipeRefreshLayout swipeRefreshLayout;
        final String value = getClubViewModel().getSelectedChallengeId().getValue();
        final Ref.ObjectRef objectRef = new Ref.ObjectRef();
        objectRef.element = getClubViewModel().getSelectedChallengeData().getValue();
        String loginAccountNo = Global.getLoginAccountNo();
        ChallengeItemFullData challengeItemFullData = (ChallengeItemFullData) objectRef.element;
        final boolean zAreEqual = Intrinsics.areEqual(loginAccountNo, challengeItemFullData != null ? challengeItemFullData.getLeaderGlobalUserUuid() : null);
        if (objectRef.element == 0) {
            BaseFragment.safeNavigate$default(this, R.id.clubMainFragment, null, 2, null);
            return;
        }
        FragmentClubScoreboardListBinding binding = getBinding();
        if (binding != null && (swipeRefreshLayout = binding.swipeRefresh) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment$$ExternalSyntheticLambda0
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    ClubScoreboardListFragment.initViews$lambda$0(value, this);
                }
            });
        }
        setupMemberAllRankRecyclerView(((ChallengeItemFullData) objectRef.element).getScoreItem(), ((ChallengeItemFullData) objectRef.element).getChallengeType(), false);
        setupMemberReachedRecyclerView(((ChallengeItemFullData) objectRef.element).getScoreItem(), ((ChallengeItemFullData) objectRef.element).getChallengeType(), false);
        setupMemberOnProgressRecyclerView(((ChallengeItemFullData) objectRef.element).getScoreItem(), ((ChallengeItemFullData) objectRef.element).getChallengeType(), false);
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass2(objectRef, zAreEqual, null), 3, null);
        ChallengeItemFullData challengeItemFullData2 = (ChallengeItemFullData) objectRef.element;
        if (challengeItemFullData2 != null) {
            updateView(challengeItemFullData2.getChallengeType());
            updateHeaderBtn(zAreEqual, challengeItemFullData2.getActivityStatus(), challengeItemFullData2.getPrivacyLevel());
            String loginAccountNo2 = Global.getLoginAccountNo();
            Iterator<T> it = challengeItemFullData2.getMemberList().iterator();
            while (true) {
                if (!it.hasNext()) {
                    next = null;
                    break;
                } else {
                    next = it.next();
                    if (Intrinsics.areEqual(((ChallengeMemberData) next).getGlobalUserUuid(), loginAccountNo2)) {
                        break;
                    }
                }
            }
            ChallengeMemberData challengeMemberData = (ChallengeMemberData) next;
            FragmentClubScoreboardListBinding binding2 = getBinding();
            LinearLayout linearLayout = binding2 != null ? binding2.tvRaceCountDownTimerWrap : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            if (challengeItemFullData2.getChallengeType() == ChallengeTypeSettings.VIRTUAL_RACE.getId() && ((challengeMemberData == null || !challengeMemberData.isPassForVirtualRace()) && challengeItemFullData2.getActivityStatus() != ChallengeActivityStatus.FINISHED.getId() && challengeItemFullData2.getActivityStatus() != ChallengeActivityStatus.READY.getId())) {
                FragmentClubScoreboardListBinding binding3 = getBinding();
                LinearLayout linearLayout2 = binding3 != null ? binding3.tvRaceCountDownTimerWrap : null;
                if (linearLayout2 != null) {
                    linearLayout2.setVisibility(0);
                }
                startCountdown(challengeItemFullData2.getEndTimeMillis());
            }
        }
        FragmentClubScoreboardListBinding binding4 = getBinding();
        if (binding4 != null && (imageView3 = binding4.imgBtnGoPrev) != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment$$ExternalSyntheticLambda1
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubScoreboardListFragment.initViews$lambda$3(this.f$0, view);
                }
            });
        }
        FragmentClubScoreboardListBinding binding5 = getBinding();
        LinearLayout linearLayout3 = binding5 != null ? binding5.clSearch : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        FragmentClubScoreboardListBinding binding6 = getBinding();
        if (binding6 != null && (textView2 = binding6.tvBtnCreatorEdit) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubScoreboardListFragment.initViews$lambda$4(this.f$0, objectRef, zAreEqual, view);
                }
            });
        }
        FragmentClubScoreboardListBinding binding7 = getBinding();
        if (binding7 != null && (imageView2 = binding7.imgBtnCreatorCancelEdit) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment$$ExternalSyntheticLambda3
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubScoreboardListFragment.initViews$lambda$5(this.f$0, view);
                }
            });
        }
        FragmentClubScoreboardListBinding binding8 = getBinding();
        if (binding8 != null && (textView = binding8.tvBtnCreatorDoneEdit) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment$$ExternalSyntheticLambda4
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubScoreboardListFragment.initViews$lambda$6(this.f$0, objectRef, zAreEqual, view);
                }
            });
        }
        FragmentClubScoreboardListBinding binding9 = getBinding();
        if (binding9 != null && (appCompatEditText = binding9.editEventName) != null) {
            appCompatEditText.addTextChangedListener(new TextWatcher() { // from class: com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment.initViews.8
                @Override // android.text.TextWatcher
                public void afterTextChanged(Editable s) {
                }

                @Override // android.text.TextWatcher
                public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                }

                @Override // android.text.TextWatcher
                public void onTextChanged(CharSequence s, int start, int before, int count) {
                    FragmentClubScoreboardListBinding fragmentClubScoreboardListBindingAccess$getBinding = ClubScoreboardListFragment.access$getBinding(ClubScoreboardListFragment.this);
                    ImageView imageView4 = fragmentClubScoreboardListBindingAccess$getBinding != null ? fragmentClubScoreboardListBindingAccess$getBinding.clearButton : null;
                    if (imageView4 != null) {
                        imageView4.setVisibility(s == null || s.length() == 0 ? 8 : 0);
                    }
                    String strValueOf = String.valueOf(s);
                    ClubScoreboardListFragment clubScoreboardListFragment = ClubScoreboardListFragment.this;
                    ChallengeItemFullData challengeItemFullData3 = objectRef.element;
                    Intrinsics.checkNotNull(challengeItemFullData3);
                    clubScoreboardListFragment.reloadList(challengeItemFullData3, zAreEqual, ClubScoreboardListFragment.this.isEditing, strValueOf);
                }
            });
        }
        FragmentClubScoreboardListBinding binding10 = getBinding();
        if (binding10 == null || (imageView = binding10.clearButton) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment$$ExternalSyntheticLambda5
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClubScoreboardListFragment.initViews$lambda$7(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$0(String str, ClubScoreboardListFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str != null) {
            this$0.getChallengeDetail(str, true);
            FragmentClubScoreboardListBinding binding = this$0.getBinding();
            SwipeRefreshLayout swipeRefreshLayout = binding != null ? binding.swipeRefresh : null;
            if (swipeRefreshLayout == null) {
                return;
            }
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    /* compiled from: ClubScoreboardListFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment$initViews$2", f = "ClubScoreboardListFragment.kt", i = {}, l = {96}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment$initViews$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Ref.ObjectRef<ChallengeItemFullData> $challengeData;
        final /* synthetic */ boolean $isOwner;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Ref.ObjectRef<ChallengeItemFullData> objectRef, boolean z, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$challengeData = objectRef;
            this.$isOwner = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubScoreboardListFragment.this.new AnonymousClass2(this.$challengeData, this.$isOwner, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ClubScoreboardListFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment$initViews$2$1", f = "ClubScoreboardListFragment.kt", i = {}, l = {97}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment$initViews$2$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Ref.ObjectRef<ChallengeItemFullData> $challengeData;
            final /* synthetic */ boolean $isOwner;
            int label;
            final /* synthetic */ ClubScoreboardListFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ClubScoreboardListFragment clubScoreboardListFragment, Ref.ObjectRef<ChallengeItemFullData> objectRef, boolean z, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = clubScoreboardListFragment;
                this.$challengeData = objectRef;
                this.$isOwner = z;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$challengeData, this.$isOwner, continuation);
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
                    StateFlow<ChallengeItemFullData> selectedChallengeData = this.this$0.getClubViewModel().getSelectedChallengeData();
                    final Ref.ObjectRef<ChallengeItemFullData> objectRef = this.$challengeData;
                    final ClubScoreboardListFragment clubScoreboardListFragment = this.this$0;
                    final boolean z = this.$isOwner;
                    this.label = 1;
                    if (selectedChallengeData.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment.initViews.2.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((ChallengeItemFullData) obj2, (Continuation<? super Unit>) continuation);
                        }

                        /* JADX WARN: Multi-variable type inference failed */
                        public final Object emit(ChallengeItemFullData challengeItemFullData, Continuation<? super Unit> continuation) {
                            if (challengeItemFullData != 0) {
                                objectRef.element = challengeItemFullData;
                                ClubScoreboardListFragment clubScoreboardListFragment2 = clubScoreboardListFragment;
                                ClubScoreboardListFragment.reloadList$default(clubScoreboardListFragment2, challengeItemFullData, z, clubScoreboardListFragment2.isEditing, null, 8, null);
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
                if (RepeatOnLifecycleKt.repeatOnLifecycle(ClubScoreboardListFragment.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new AnonymousClass1(ClubScoreboardListFragment.this, this.$challengeData, this.$isOwner, null), this) == coroutine_suspended) {
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$3(ClubScoreboardListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.safeNavigateUp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initViews$lambda$4(ClubScoreboardListFragment this$0, Ref.ObjectRef challengeData, boolean z, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(challengeData, "$challengeData");
        Timber.INSTANCE.d("tvBtnCreatorEdit", new Object[0]);
        this$0.isEditing = true;
        FragmentClubScoreboardListBinding binding = this$0.getBinding();
        LinearLayout linearLayout = binding != null ? binding.clSearch : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        T t = challengeData.element;
        Intrinsics.checkNotNull(t);
        reloadList$default(this$0, (ChallengeItemFullData) t, z, this$0.isEditing, null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$5(ClubScoreboardListFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Timber.INSTANCE.d("imgBtnCreatorCancelEdit", new Object[0]);
        this$0.safeNavigateUp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void initViews$lambda$6(ClubScoreboardListFragment this$0, Ref.ObjectRef challengeData, boolean z, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(challengeData, "$challengeData");
        Timber.INSTANCE.d("tvBtnCreatorDoneEdit", new Object[0]);
        this$0.isEditing = false;
        FragmentClubScoreboardListBinding binding = this$0.getBinding();
        LinearLayout linearLayout = binding != null ? binding.clSearch : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        T t = challengeData.element;
        Intrinsics.checkNotNull(t);
        reloadList$default(this$0, (ChallengeItemFullData) t, z, this$0.isEditing, null, 8, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$7(ClubScoreboardListFragment this$0, View view) {
        AppCompatEditText appCompatEditText;
        Editable text;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentClubScoreboardListBinding binding = this$0.getBinding();
        if (binding == null || (appCompatEditText = binding.editEventName) == null || (text = appCompatEditText.getText()) == null) {
            return;
        }
        text.clear();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
    }

    /* compiled from: ClubScoreboardListFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment$deleteMemberAsk$1", f = "ClubScoreboardListFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment$deleteMemberAsk$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $globalUserUuid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$globalUserUuid = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubScoreboardListFragment.this.new AnonymousClass1(this.$globalUserUuid, continuation);
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
            ClubScoreboardListFragment clubScoreboardListFragment = ClubScoreboardListFragment.this;
            String string = clubScoreboardListFragment.getString(R.string.delete_event_confirm);
            String string2 = ClubScoreboardListFragment.this.getString(R.string.delete_event_cancel);
            final String str = this.$globalUserUuid;
            final ClubScoreboardListFragment clubScoreboardListFragment2 = ClubScoreboardListFragment.this;
            CustomDialogKt.showCustomDialog$default(clubScoreboardListFragment, "Delete member", "Are you sure you want to delete this member?", string, string2, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment.deleteMemberAsk.1.1
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
                    Timber.INSTANCE.d("delete: " + str, new Object[0]);
                    clubScoreboardListFragment2.leaderDeleteMember(CollectionsKt.listOf(str));
                }
            }, null, false, 96, null);
            return Unit.INSTANCE;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void deleteMemberAsk(String globalUserUuid) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(globalUserUuid, null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void leaderDeleteMember(List<String> globalUserUuids) {
        if (getContext() != null) {
            LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new ClubScoreboardListFragment$leaderDeleteMember$1$1(this, globalUserUuids, null), 3, null);
        }
    }

    static /* synthetic */ void reloadList$default(ClubScoreboardListFragment clubScoreboardListFragment, ChallengeItemFullData challengeItemFullData, boolean z, boolean z2, String str, int i, Object obj) {
        if ((i & 8) != 0) {
            str = "";
        }
        clubScoreboardListFragment.reloadList(challengeItemFullData, z, z2, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reloadList(ChallengeItemFullData challengeData, boolean isOwner, boolean isEdit, String searchText) {
        setupMemberAllRankRecyclerView(challengeData.getScoreItem(), challengeData.getChallengeType(), isEdit);
        setupMemberReachedRecyclerView(challengeData.getScoreItem(), challengeData.getChallengeType(), isEdit);
        setupMemberOnProgressRecyclerView(challengeData.getScoreItem(), challengeData.getChallengeType(), isEdit);
        ArrayList list = CollectionsKt.toList(challengeData.getMemberList());
        String str = searchText;
        if (str.length() > 0) {
            ArrayList arrayList = new ArrayList();
            for (Object obj : list) {
                if (StringsKt.contains((CharSequence) ((ChallengeMemberData) obj).getUserSimpleInfo().getNickName(), (CharSequence) str, true)) {
                    arrayList.add(obj);
                }
            }
            list = arrayList;
        }
        ClubScoreItemAdapter clubScoreItemAdapter = this.memberAllRankAdapter;
        ClubScoreItemAdapter clubScoreItemAdapter2 = null;
        if (clubScoreItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberAllRankAdapter");
            clubScoreItemAdapter = null;
        }
        clubScoreItemAdapter.submitList(list);
        List list2 = list;
        ArrayList arrayList2 = new ArrayList();
        for (Object obj2 : list2) {
            if (((ChallengeMemberData) obj2).isGoalReached()) {
                arrayList2.add(obj2);
            }
        }
        ArrayList arrayList3 = arrayList2;
        ClubScoreItemAdapter clubScoreItemAdapter3 = this.memberReachedAdapter;
        if (clubScoreItemAdapter3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberReachedAdapter");
            clubScoreItemAdapter3 = null;
        }
        clubScoreItemAdapter3.submitList(arrayList3);
        ArrayList arrayList4 = new ArrayList();
        for (Object obj3 : list2) {
            if (!((ChallengeMemberData) obj3).isGoalReached()) {
                arrayList4.add(obj3);
            }
        }
        ArrayList arrayList5 = arrayList4;
        ClubScoreItemAdapter clubScoreItemAdapter4 = this.memberOnProgressAdapter;
        if (clubScoreItemAdapter4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberOnProgressAdapter");
        } else {
            clubScoreItemAdapter2 = clubScoreItemAdapter4;
        }
        clubScoreItemAdapter2.submitList(arrayList5);
        updateView(challengeData.getChallengeType());
        updateHeaderBtn(isOwner, challengeData.getActivityStatus(), challengeData.getPrivacyLevel());
    }

    private final void updateHeaderBtn(boolean isOwner, int activityStatus, int privacyLevel) {
        boolean z = privacyLevel == ChallengePrivacyLevelSettings.PRIVATE.getId();
        FragmentClubScoreboardListBinding binding = getBinding();
        ImageView imageView = binding != null ? binding.imgBtnGoPrev : null;
        if (imageView != null) {
            imageView.setVisibility(8);
        }
        FragmentClubScoreboardListBinding binding2 = getBinding();
        TextView textView = binding2 != null ? binding2.tvBtnCreatorEdit : null;
        if (textView != null) {
            textView.setVisibility(8);
        }
        FragmentClubScoreboardListBinding binding3 = getBinding();
        ImageView imageView2 = binding3 != null ? binding3.imgBtnCreatorCancelEdit : null;
        if (imageView2 != null) {
            imageView2.setVisibility(8);
        }
        FragmentClubScoreboardListBinding binding4 = getBinding();
        TextView textView2 = binding4 != null ? binding4.tvBtnCreatorDoneEdit : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        if (isOwner && z) {
            FragmentClubScoreboardListBinding binding5 = getBinding();
            TextView textView3 = binding5 != null ? binding5.tvBtnCreatorEdit : null;
            if (textView3 != null) {
                textView3.setVisibility(0);
            }
            if (this.isEditing) {
                FragmentClubScoreboardListBinding binding6 = getBinding();
                TextView textView4 = binding6 != null ? binding6.tvBtnCreatorDoneEdit : null;
                if (textView4 != null) {
                    textView4.setVisibility(0);
                }
                FragmentClubScoreboardListBinding binding7 = getBinding();
                TextView textView5 = binding7 != null ? binding7.tvBtnCreatorEdit : null;
                if (textView5 != null) {
                    textView5.setVisibility(8);
                }
            } else {
                FragmentClubScoreboardListBinding binding8 = getBinding();
                ImageView imageView3 = binding8 != null ? binding8.imgBtnCreatorCancelEdit : null;
                if (imageView3 != null) {
                    imageView3.setVisibility(0);
                }
            }
        } else {
            FragmentClubScoreboardListBinding binding9 = getBinding();
            ImageView imageView4 = binding9 != null ? binding9.imgBtnGoPrev : null;
            if (imageView4 != null) {
                imageView4.setVisibility(0);
            }
        }
        if (activityStatus == ChallengeActivityStatus.FINISHED.getId()) {
            FragmentClubScoreboardListBinding binding10 = getBinding();
            TextView textView6 = binding10 != null ? binding10.tvBtnCreatorEdit : null;
            if (textView6 == null) {
                return;
            }
            textView6.setVisibility(8);
        }
    }

    private final void updateView(int challengeType) {
        LinearLayout linearLayout;
        FragmentClubScoreboardListBinding binding = getBinding();
        LinearLayout linearLayout2 = binding != null ? binding.tvTargetReachedWrap : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        FragmentClubScoreboardListBinding binding2 = getBinding();
        LinearLayout linearLayout3 = binding2 != null ? binding2.tvWorkInProgressWrap : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        FragmentClubScoreboardListBinding binding3 = getBinding();
        LinearLayout linearLayout4 = binding3 != null ? binding3.tvAllWrap : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        if (challengeType == ChallengeTypeSettings.GOAL.getId()) {
            FragmentClubScoreboardListBinding binding4 = getBinding();
            LinearLayout linearLayout5 = binding4 != null ? binding4.tvTargetReachedWrap : null;
            if (linearLayout5 != null) {
                linearLayout5.setVisibility(0);
            }
            FragmentClubScoreboardListBinding binding5 = getBinding();
            linearLayout = binding5 != null ? binding5.tvWorkInProgressWrap : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        FragmentClubScoreboardListBinding binding6 = getBinding();
        linearLayout = binding6 != null ? binding6.tvAllWrap : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(0);
    }

    static /* synthetic */ void setupMemberAllRankRecyclerView$default(ClubScoreboardListFragment clubScoreboardListFragment, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        clubScoreboardListFragment.setupMemberAllRankRecyclerView(i, i2, z);
    }

    private final void setupMemberAllRankRecyclerView(int scoreItem, int challengeType, boolean isEdit) {
        RecyclerView recyclerView;
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null) {
            this.memberAllRankAdapter = new ClubScoreItemAdapter(mainActivity, new ClubScoreItemAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment$setupMemberAllRankRecyclerView$1$1
                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubScoreItemAdapter.OnItemClickListener
                public void onClick(int position, ChallengeMemberData item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    Timber.INSTANCE.d("item click: " + item, new Object[0]);
                    this.this$0.goMemberDetail(item);
                }

                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubScoreItemAdapter.OnItemClickListener
                public void onDeleteClick(int position, ChallengeMemberData item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    this.this$0.deleteMemberAsk(item.getGlobalUserUuid());
                }
            }, true, scoreItem, challengeType, isEdit);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
            FragmentClubScoreboardListBinding binding = getBinding();
            if (binding == null || (recyclerView = binding.rvAllList) == null) {
                return;
            }
            ClubScoreItemAdapter clubScoreItemAdapter = this.memberAllRankAdapter;
            if (clubScoreItemAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberAllRankAdapter");
                clubScoreItemAdapter = null;
            }
            recyclerView.setAdapter(clubScoreItemAdapter);
            recyclerView.setLayoutManager(linearLayoutManager);
        }
    }

    static /* synthetic */ void setupMemberReachedRecyclerView$default(ClubScoreboardListFragment clubScoreboardListFragment, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        clubScoreboardListFragment.setupMemberReachedRecyclerView(i, i2, z);
    }

    private final void setupMemberReachedRecyclerView(int scoreItem, int challengeType, boolean isEdit) {
        RecyclerView recyclerView;
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null) {
            this.memberReachedAdapter = new ClubScoreItemAdapter(mainActivity, new ClubScoreItemAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment$setupMemberReachedRecyclerView$1$1
                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubScoreItemAdapter.OnItemClickListener
                public void onClick(int position, ChallengeMemberData item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    Timber.INSTANCE.d("item Reached:" + item, new Object[0]);
                    this.this$0.goMemberDetail(item);
                }

                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubScoreItemAdapter.OnItemClickListener
                public void onDeleteClick(int position, ChallengeMemberData item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    this.this$0.deleteMemberAsk(item.getGlobalUserUuid());
                }
            }, true, scoreItem, challengeType, isEdit);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
            FragmentClubScoreboardListBinding binding = getBinding();
            if (binding == null || (recyclerView = binding.rvTargetReached) == null) {
                return;
            }
            ClubScoreItemAdapter clubScoreItemAdapter = this.memberReachedAdapter;
            if (clubScoreItemAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberReachedAdapter");
                clubScoreItemAdapter = null;
            }
            recyclerView.setAdapter(clubScoreItemAdapter);
            recyclerView.setLayoutManager(linearLayoutManager);
        }
    }

    static /* synthetic */ void setupMemberOnProgressRecyclerView$default(ClubScoreboardListFragment clubScoreboardListFragment, int i, int i2, boolean z, int i3, Object obj) {
        if ((i3 & 4) != 0) {
            z = false;
        }
        clubScoreboardListFragment.setupMemberOnProgressRecyclerView(i, i2, z);
    }

    private final void setupMemberOnProgressRecyclerView(int scoreItem, int challengeType, boolean isEdit) {
        RecyclerView recyclerView;
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null) {
            this.memberOnProgressAdapter = new ClubScoreItemAdapter(mainActivity, new ClubScoreItemAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment$setupMemberOnProgressRecyclerView$1$1
                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubScoreItemAdapter.OnItemClickListener
                public void onClick(int position, ChallengeMemberData item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    Timber.INSTANCE.d("item onProgress:" + item, new Object[0]);
                    this.this$0.goMemberDetail(item);
                }

                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubScoreItemAdapter.OnItemClickListener
                public void onDeleteClick(int position, ChallengeMemberData item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    this.this$0.deleteMemberAsk(item.getGlobalUserUuid());
                }
            }, true, scoreItem, challengeType, isEdit);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
            FragmentClubScoreboardListBinding binding = getBinding();
            if (binding == null || (recyclerView = binding.rvWorkInProgress) == null) {
                return;
            }
            ClubScoreItemAdapter clubScoreItemAdapter = this.memberOnProgressAdapter;
            if (clubScoreItemAdapter == null) {
                Intrinsics.throwUninitializedPropertyAccessException("memberOnProgressAdapter");
                clubScoreItemAdapter = null;
            }
            recyclerView.setAdapter(clubScoreItemAdapter);
            recyclerView.setLayoutManager(linearLayoutManager);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goMemberDetail(ChallengeMemberData challengeMemberData) {
        getClubViewModel().setChallengeMemberData(challengeMemberData);
        BaseFragment.safeNavigate$default(this, R.id.clubMemberScoreFragment, null, 2, null);
    }

    static /* synthetic */ void getChallengeDetail$default(ClubScoreboardListFragment clubScoreboardListFragment, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        clubScoreboardListFragment.getChallengeDetail(str, z);
    }

    /* compiled from: ClubScoreboardListFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment$getChallengeDetail$1", f = "ClubScoreboardListFragment.kt", i = {}, l = {483}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment$getChallengeDetail$1, reason: invalid class name and case insensitive filesystem */
    static final class C09541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $challengeUuid;
        final /* synthetic */ boolean $isWithMemberData;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09541(String str, boolean z, Continuation<? super C09541> continuation) {
            super(2, continuation);
            this.$challengeUuid = str;
            this.$isWithMemberData = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubScoreboardListFragment.this.new C09541(this.$challengeUuid, this.$isWithMemberData, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09541) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            GetChallengeDetailApiData.DataMap sysResponseData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ClubScoreboardListFragment.this.showLoading();
                        this.label = 1;
                        obj = DyacoApiKt.callGetChallengeDetail(new GetChallengeDetailApiData.RequestBodyData(this.$challengeUuid, Boxing.boxBoolean(this.$isWithMemberData)), this);
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
                    Timber.INSTANCE.d("callGetPublicChallengesToJoin: " + response, new Object[0]);
                    GetChallengeDetailApiData.ResponseData responseData = (GetChallengeDetailApiData.ResponseData) response.body();
                    ChallengeItemFullData data = (responseData == null || (sysResponseData = responseData.getSysResponseData()) == null) ? null : sysResponseData.getData();
                    GetChallengeDetailApiData.ResponseData responseData2 = (GetChallengeDetailApiData.ResponseData) response.body();
                    String errorCode = responseData2 != null ? responseData2.getErrorCode() : null;
                    GetChallengeDetailApiData.ResponseData responseData3 = (GetChallengeDetailApiData.ResponseData) response.body();
                    if (responseData3 != null && responseData3.getSuccess() && data != null) {
                        ClubScoreboardListFragment.this.getClubViewModel().setSelectChallengeData(data);
                    } else if (!Intrinsics.areEqual(errorCode, ErrorCode.NOT_AUTH_TO_PERFORM_THE_OPERATION_1011.getId())) {
                        if (ClubScoreboardListFragment.this.shouldIgnoreError(errorCode)) {
                            return Unit.INSTANCE;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.DATA_NOT_FOUND_108.getId(), Boxing.boxInt(R.string.err_108_data_not_found)), TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required)), TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), null)).get(errorCode);
                        if (num != null) {
                            ClubScoreboardListFragment clubScoreboardListFragment = ClubScoreboardListFragment.this;
                            CustomDialogKt.showCustomDialog$default(clubScoreboardListFragment, null, clubScoreboardListFragment.getString(num.intValue()), ClubScoreboardListFragment.this.getString(R.string.confirm), null, null, null, false, 112, null);
                        } else {
                            ClubScoreboardListFragment clubScoreboardListFragment2 = ClubScoreboardListFragment.this;
                            GetChallengeDetailApiData.ResponseData responseData4 = (GetChallengeDetailApiData.ResponseData) response.body();
                            BaseFragment.handleUndefinedError$default(clubScoreboardListFragment2, "getChallengeDetail", errorCode, responseData4 != null ? responseData4.getErrorMessage() : null, false, 8, null);
                        }
                    } else {
                        BaseFragment.safeNavigateAndClearStack$default(ClubScoreboardListFragment.this, R.id.clubEventDetailFragment, null, 2, null);
                    }
                } catch (IOException e) {
                    Timber.INSTANCE.e(e, "API call failed", new Object[0]);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(ClubScoreboardListFragment.this, "getChallengeDetail", message, false, 4, null);
                }
                ClubScoreboardListFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                ClubScoreboardListFragment.this.stopLoading();
            }
        }
    }

    private final void getChallengeDetail(String challengeUuid, boolean isWithMemberData) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09541(challengeUuid, isWithMemberData, null), 3, null);
    }

    /* JADX WARN: Type inference failed for: r0v4, types: [com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment$startCountdown$1] */
    private final void startCountdown(long endTimeMillis) {
        long jCurrentTimeMillis = endTimeMillis - System.currentTimeMillis();
        if (jCurrentTimeMillis <= 0) {
            FragmentClubScoreboardListBinding binding = getBinding();
            TextView textView = binding != null ? binding.tvRaceCountDownTimer : null;
            if (textView == null) {
                return;
            }
            textView.setText("00:00:00");
            return;
        }
        CountDownTimer countDownTimer = this.countDownTimer;
        if (countDownTimer != null) {
            countDownTimer.cancel();
        }
        this.countDownTimer = new CountDownTimer(jCurrentTimeMillis) { // from class: com.soletreadmills.sole_v2.ui.club.ClubScoreboardListFragment.startCountdown.1
            @Override // android.os.CountDownTimer
            public void onTick(long millisUntilFinished) {
                long j = millisUntilFinished / TimeConstants.HOUR;
                long j2 = 60;
                long j3 = (millisUntilFinished / TimeConstants.MIN) % j2;
                long j4 = (millisUntilFinished / 1000) % j2;
                StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                String str = String.format(Locale.US, "%02d:%02d:%02d", Arrays.copyOf(new Object[]{Long.valueOf(j), Long.valueOf(j3), Long.valueOf(j4)}, 3));
                Intrinsics.checkNotNullExpressionValue(str, "format(...)");
                FragmentClubScoreboardListBinding fragmentClubScoreboardListBindingAccess$getBinding = ClubScoreboardListFragment.access$getBinding(this);
                TextView textView2 = fragmentClubScoreboardListBindingAccess$getBinding != null ? fragmentClubScoreboardListBindingAccess$getBinding.tvRaceCountDownTimer : null;
                if (textView2 == null) {
                    return;
                }
                textView2.setText(str);
            }

            @Override // android.os.CountDownTimer
            public void onFinish() {
                FragmentClubScoreboardListBinding fragmentClubScoreboardListBindingAccess$getBinding = ClubScoreboardListFragment.access$getBinding(this);
                TextView textView2 = fragmentClubScoreboardListBindingAccess$getBinding != null ? fragmentClubScoreboardListBindingAccess$getBinding.tvRaceCountDownTimer : null;
                if (textView2 != null) {
                    textView2.setText("00:00:00");
                }
                this.onCountdownFinished();
            }
        }.start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void onCountdownFinished() {
        FragmentClubScoreboardListBinding binding = getBinding();
        LinearLayout linearLayout = binding != null ? binding.tvRaceCountDownTimerWrap : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }
}
