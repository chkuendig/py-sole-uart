package com.soletreadmills.sole_v2.ui.club;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
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
import com.soletreadmills.sole_v2._data.api.club.GetChallengeMemberWorkoutListApiData;
import com.soletreadmills.sole_v2._data.club.ChallengeItemFullData;
import com.soletreadmills.sole_v2._data.club.ChallengeMemberData;
import com.soletreadmills.sole_v2._data.club.ChallengeMemberWorkoutData;
import com.soletreadmills.sole_v2._data.club.ChallengeMemberWorkoutWithUserSimpleInfoData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2.databinding.FragmentClubMemberScoreBinding;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.adapter.club.ClubMemberScoreAdapter;
import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.Map;
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
import kotlinx.coroutines.flow.MutableStateFlow;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: ClubMemberScoreFragment.kt */
@Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\u0002J\u001a\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u000eH\u0016J\u0012\u0010\u0018\u001a\u00020\u000e2\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u000eH\u0016J\u001e\u0010\u001c\u001a\u00020\u000e2\u0006\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 H\u0002J\u0018\u0010\"\u001a\u00020\u000e2\u0006\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020$H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082.¢\u0006\u0002\n\u0000¨\u0006&"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/club/ClubMemberScoreFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentClubMemberScoreBinding;", "Landroid/view/View$OnClickListener;", "()V", "clubViewModel", "Lcom/soletreadmills/sole_v2/ui/club/ClubViewModel;", "getClubViewModel", "()Lcom/soletreadmills/sole_v2/ui/club/ClubViewModel;", "clubViewModel$delegate", "Lkotlin/Lazy;", "memberScoreAdapter", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubMemberScoreAdapter;", "getChallengeMemberWorkoutList", "", "challengeUuid", "", "globalUserUuid", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onDestroyView", "reloadList", "challengeData", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemFullData;", "workoutData", "", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberWorkoutData;", "setupMemberScoreRecyclerView", "scoreItem", "", "challengeType", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubMemberScoreFragment extends BaseFragment<FragmentClubMemberScoreBinding> implements View.OnClickListener {
    public static final int $stable = 8;

    /* renamed from: clubViewModel$delegate, reason: from kotlin metadata */
    private final Lazy clubViewModel;
    private ClubMemberScoreAdapter memberScoreAdapter;

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    public ClubMemberScoreFragment() {
        final ClubMemberScoreFragment clubMemberScoreFragment = this;
        final Function0 function0 = null;
        this.clubViewModel = FragmentViewModelLazyKt.createViewModelLazy(clubMemberScoreFragment, Reflection.getOrCreateKotlinClass(ClubViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMemberScoreFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = clubMemberScoreFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMemberScoreFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = clubMemberScoreFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMemberScoreFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = clubMemberScoreFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public final ClubViewModel getClubViewModel() {
        return (ClubViewModel) this.clubViewModel.getValue();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentClubMemberScoreBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentClubMemberScoreBinding fragmentClubMemberScoreBindingInflate = FragmentClubMemberScoreBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentClubMemberScoreBindingInflate, "inflate(...)");
        return fragmentClubMemberScoreBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        ImageView imageView;
        SwipeRefreshLayout swipeRefreshLayout;
        final String value = getClubViewModel().getSelectedChallengeId().getValue();
        ChallengeItemFullData value2 = getClubViewModel().getSelectedChallengeData().getValue();
        final ChallengeMemberData value3 = getClubViewModel().getSelectedChallengeMemberData().getValue();
        if (value2 == null || value3 == null) {
            BaseFragment.safeNavigate$default(this, R.id.clubMainFragment, null, 2, null);
            return;
        }
        FragmentClubMemberScoreBinding binding = getBinding();
        if (binding != null && (swipeRefreshLayout = binding.swipeRefresh) != null) {
            swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMemberScoreFragment$$ExternalSyntheticLambda0
                @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
                public final void onRefresh() {
                    ClubMemberScoreFragment.initViews$lambda$0(value, this, value3);
                }
            });
        }
        setupMemberScoreRecyclerView(value2.getScoreItem(), value2.getChallengeType());
        if (value != null) {
            getChallengeMemberWorkoutList(value, value3.getGlobalUserUuid());
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass2(value2, null), 3, null);
        FragmentClubMemberScoreBinding binding2 = getBinding();
        TextView textView = binding2 != null ? binding2.tvUsername : null;
        if (textView != null) {
            textView.setText(value3.getUserSimpleInfo().getNickName());
        }
        FragmentClubMemberScoreBinding binding3 = getBinding();
        if (binding3 == null || (imageView = binding3.imgBtnGoPrev) == null) {
            return;
        }
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMemberScoreFragment$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view) {
                ClubMemberScoreFragment.initViews$lambda$1(this.f$0, view);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$0(String str, ClubMemberScoreFragment this$0, ChallengeMemberData challengeMemberData) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str != null) {
            Intrinsics.checkNotNull(challengeMemberData);
            this$0.getChallengeMemberWorkoutList(str, challengeMemberData.getGlobalUserUuid());
            FragmentClubMemberScoreBinding binding = this$0.getBinding();
            SwipeRefreshLayout swipeRefreshLayout = binding != null ? binding.swipeRefresh : null;
            if (swipeRefreshLayout == null) {
                return;
            }
            swipeRefreshLayout.setRefreshing(false);
        }
    }

    /* compiled from: ClubMemberScoreFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMemberScoreFragment$initViews$2", f = "ClubMemberScoreFragment.kt", i = {}, l = {78}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMemberScoreFragment$initViews$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ChallengeItemFullData $challengeData;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(ChallengeItemFullData challengeItemFullData, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$challengeData = challengeItemFullData;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubMemberScoreFragment.this.new AnonymousClass2(this.$challengeData, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: ClubMemberScoreFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMemberScoreFragment$initViews$2$1", f = "ClubMemberScoreFragment.kt", i = {}, l = {79}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMemberScoreFragment$initViews$2$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ ChallengeItemFullData $challengeData;
            int label;
            final /* synthetic */ ClubMemberScoreFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(ClubMemberScoreFragment clubMemberScoreFragment, ChallengeItemFullData challengeItemFullData, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.this$0 = clubMemberScoreFragment;
                this.$challengeData = challengeItemFullData;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.this$0, this.$challengeData, continuation);
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
                    MutableStateFlow<List<ChallengeMemberWorkoutData>> selectedChallengeMemberWorkout = this.this$0.getClubViewModel().getSelectedChallengeMemberWorkout();
                    final ClubMemberScoreFragment clubMemberScoreFragment = this.this$0;
                    final ChallengeItemFullData challengeItemFullData = this.$challengeData;
                    this.label = 1;
                    if (selectedChallengeMemberWorkout.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.club.ClubMemberScoreFragment.initViews.2.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((List<ChallengeMemberWorkoutData>) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(List<ChallengeMemberWorkoutData> list, Continuation<? super Unit> continuation) {
                            if (list != null) {
                                clubMemberScoreFragment.reloadList(challengeItemFullData, list);
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
                if (RepeatOnLifecycleKt.repeatOnLifecycle(ClubMemberScoreFragment.this.getViewLifecycleOwner().getLifecycle(), Lifecycle.State.STARTED, new AnonymousClass1(ClubMemberScoreFragment.this, this.$challengeData, null), this) == coroutine_suspended) {
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
    public static final void initViews$lambda$1(ClubMemberScoreFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.safeNavigateUp();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void reloadList(ChallengeItemFullData challengeData, List<ChallengeMemberWorkoutData> workoutData) {
        setupMemberScoreRecyclerView(challengeData.getScoreItem(), challengeData.getChallengeType());
        List mutableList = CollectionsKt.toMutableList((Collection) workoutData);
        ClubMemberScoreAdapter clubMemberScoreAdapter = this.memberScoreAdapter;
        if (clubMemberScoreAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberScoreAdapter");
            clubMemberScoreAdapter = null;
        }
        clubMemberScoreAdapter.submitList(mutableList);
    }

    private final void setupMemberScoreRecyclerView(int scoreItem, int challengeType) {
        RecyclerView recyclerView;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        this.memberScoreAdapter = new ClubMemberScoreAdapter(contextRequireContext, true, scoreItem, challengeType);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getContext(), 1, false);
        FragmentClubMemberScoreBinding binding = getBinding();
        if (binding == null || (recyclerView = binding.rvMemberScore) == null) {
            return;
        }
        ClubMemberScoreAdapter clubMemberScoreAdapter = this.memberScoreAdapter;
        if (clubMemberScoreAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("memberScoreAdapter");
            clubMemberScoreAdapter = null;
        }
        recyclerView.setAdapter(clubMemberScoreAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    /* compiled from: ClubMemberScoreFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMemberScoreFragment$getChallengeMemberWorkoutList$1", f = "ClubMemberScoreFragment.kt", i = {}, l = {160}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMemberScoreFragment$getChallengeMemberWorkoutList$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $challengeUuid;
        final /* synthetic */ String $globalUserUuid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$challengeUuid = str;
            this.$globalUserUuid = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubMemberScoreFragment.this.new AnonymousClass1(this.$challengeUuid, this.$globalUserUuid, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            GetChallengeMemberWorkoutListApiData.DataMap sysResponseData;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ClubMemberScoreFragment.this.showLoading();
                        this.label = 1;
                        obj = DyacoApiKt.callGetChallengeMemberWorkoutList(new GetChallengeMemberWorkoutListApiData.RequestBodyData(this.$challengeUuid, this.$globalUserUuid), this);
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
                    Timber.INSTANCE.d("callGetChallengeMemberWorkoutList: " + response, new Object[0]);
                    GetChallengeMemberWorkoutListApiData.ResponseData responseData = (GetChallengeMemberWorkoutListApiData.ResponseData) response.body();
                    ChallengeMemberWorkoutWithUserSimpleInfoData data = (responseData == null || (sysResponseData = responseData.getSysResponseData()) == null) ? null : sysResponseData.getData();
                    GetChallengeMemberWorkoutListApiData.ResponseData responseData2 = (GetChallengeMemberWorkoutListApiData.ResponseData) response.body();
                    String errorCode = responseData2 != null ? responseData2.getErrorCode() : null;
                    GetChallengeMemberWorkoutListApiData.ResponseData responseData3 = (GetChallengeMemberWorkoutListApiData.ResponseData) response.body();
                    if (responseData3 == null || !responseData3.getSuccess() || data == null) {
                        if (ClubMemberScoreFragment.this.shouldIgnoreError(errorCode)) {
                            return Unit.INSTANCE;
                        }
                        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required)), TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), null), TuplesKt.to(ErrorCode.CHALLENGE_NOT_EXIST_4000.getId(), Boxing.boxInt(R.string.challenge_pass_code_not_exist)), TuplesKt.to(ErrorCode.USER_NOT_FOUND_1003.getId(), Boxing.boxInt(R.string.user_not_found)));
                        GetChallengeMemberWorkoutListApiData.ResponseData responseData4 = (GetChallengeMemberWorkoutListApiData.ResponseData) response.body();
                        Integer num = (Integer) mapMapOf.get(responseData4 != null ? responseData4.getErrorCode() : null);
                        if (num != null) {
                            LifecycleOwner viewLifecycleOwner = ClubMemberScoreFragment.this.getViewLifecycleOwner();
                            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C02231(ClubMemberScoreFragment.this, num, null), 3, null);
                        } else {
                            ClubMemberScoreFragment clubMemberScoreFragment = ClubMemberScoreFragment.this;
                            GetChallengeMemberWorkoutListApiData.ResponseData responseData5 = (GetChallengeMemberWorkoutListApiData.ResponseData) response.body();
                            BaseFragment.handleUndefinedError$default(clubMemberScoreFragment, "getChallengeMemberWorkoutList", errorCode, responseData5 != null ? responseData5.getErrorMessage() : null, false, 8, null);
                        }
                    } else {
                        Timber.INSTANCE.d("workoutList------:" + data.getWorkoutList(), new Object[0]);
                        ClubMemberScoreFragment.this.getClubViewModel().setChallengeMemberWorkout(data.getWorkoutList());
                    }
                } catch (IOException e) {
                    Timber.INSTANCE.e(e, "API call failed", new Object[0]);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(ClubMemberScoreFragment.this, "getChallengeMemberWorkoutList", message, false, 4, null);
                }
                ClubMemberScoreFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                ClubMemberScoreFragment.this.stopLoading();
            }
        }

        /* compiled from: ClubMemberScoreFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubMemberScoreFragment$getChallengeMemberWorkoutList$1$1", f = "ClubMemberScoreFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubMemberScoreFragment$getChallengeMemberWorkoutList$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02231 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Integer $msgResId;
            int label;
            final /* synthetic */ ClubMemberScoreFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02231(ClubMemberScoreFragment clubMemberScoreFragment, Integer num, Continuation<? super C02231> continuation) {
                super(2, continuation);
                this.this$0 = clubMemberScoreFragment;
                this.$msgResId = num;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02231(this.this$0, this.$msgResId, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02231) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ClubMemberScoreFragment clubMemberScoreFragment = this.this$0;
                CustomDialogKt.showCustomDialog$default(clubMemberScoreFragment, null, clubMemberScoreFragment.getString(this.$msgResId.intValue()), this.this$0.getString(R.string.confirm), null, null, null, false, 112, null);
                return Unit.INSTANCE;
            }
        }
    }

    private final void getChallengeMemberWorkoutList(String challengeUuid, String globalUserUuid) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(challengeUuid, globalUserUuid, null), 3, null);
    }
}
