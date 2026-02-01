package com.soletreadmills.sole_v2.ui.club;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._data.api.club.GetPublicChallengesToJoinApiData;
import com.soletreadmills.sole_v2._data.club.ChallengeItemSimpleData;
import com.soletreadmills.sole_v2._data.club.ChallengeScoreItemSettings;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2.databinding.FragmentClubAllEventsBinding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.adapter.club.ClubListItemAdapter;
import com.soletreadmills.sole_v2.ui.club.ClubAllEventsFragment;
import com.soletreadmills.sole_v2.ui.club.bottomSheet.DurationSelectorBottomSheet;
import com.soletreadmills.sole_v2.ui.club.bottomSheet.EquipmentSelectorBottomSheet;
import com.soletreadmills.sole_v2.ui.club.bottomSheet.FormatSelectorBottomSheet;
import com.soletreadmills.sole_v2.ui.club.bottomSheet.TargetSelectorBottomSheet;
import java.io.IOException;
import java.util.ArrayList;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: ClubAllEventsFragment.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 :2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001:B\u0005¢\u0006\u0002\u0010\u0004J\u0006\u0010\u001d\u001a\u00020\u001eJ\u001a\u0010\u001f\u001a\u00020\u00022\u0006\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\b\u0010$\u001a\u00020\u001eH\u0016J\u0012\u0010%\u001a\u00020\u001e2\b\u0010&\u001a\u0004\u0018\u00010'H\u0016J\u0012\u0010(\u001a\u00020\u001e2\b\u0010)\u001a\u0004\u0018\u00010*H\u0016J\b\u0010+\u001a\u00020\u001eH\u0002J\b\u0010,\u001a\u00020\u001eH\u0002J\b\u0010-\u001a\u00020\u001eH\u0002J\b\u0010.\u001a\u00020\u001eH\u0002J\u0006\u0010/\u001a\u00020\u001eJ6\u00100\u001a\u00020\u001e2\u0006\u00101\u001a\u00020\u00132\b\u00102\u001a\u0004\u0018\u0001032\b\u00104\u001a\u0004\u0018\u0001052\b\u00106\u001a\u0004\u0018\u0001052\b\u00107\u001a\u0004\u0018\u000108J\b\u00109\u001a\u00020\u001eH\u0002R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR \u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u0014\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00190\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00190\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00190\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00190\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006;"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/club/ClubAllEventsFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentClubAllEventsBinding;", "Landroid/view/View$OnClickListener;", "()V", "clubViewModel", "Lcom/soletreadmills/sole_v2/ui/club/ClubViewModel;", "getClubViewModel", "()Lcom/soletreadmills/sole_v2/ui/club/ClubViewModel;", "clubViewModel$delegate", "Lkotlin/Lazy;", "dataList", "", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleData;", "getDataList", "()Ljava/util/List;", "setDataList", "(Ljava/util/List;)V", "page", "", "getPage", "()I", "setPage", "(I)V", "savedDurationSelections", "", "savedEquipmentSelections", "savedFormatSelections", "savedTargetSelections", "getAllEvent", "", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "openDurationSelector", "openEquipmentSelector", "openFormatSelector", "openTargetSelector", "setAllFilter", "setLayoutView", "listSize", "linearLayout", "Landroid/widget/LinearLayout;", "tvCount", "Landroid/widget/TextView;", "tvTitle", "img", "Landroid/widget/ImageView;", "setRecyclerview", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubAllEventsFragment extends BaseFragment<FragmentClubAllEventsBinding> implements View.OnClickListener {
    private static final String ARG_CHALLENGE_TYPE_ID = "challenge_type";
    private static String argChallengeTypeId;

    /* renamed from: clubViewModel$delegate, reason: from kotlin metadata */
    private final Lazy clubViewModel;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private List<String> savedFormatSelections = new ArrayList();
    private List<String> savedEquipmentSelections = new ArrayList();
    private List<String> savedDurationSelections = new ArrayList();
    private List<String> savedTargetSelections = new ArrayList();
    private int page = 1;
    private List<ChallengeItemSimpleData> dataList = new ArrayList();

    public ClubAllEventsFragment() {
        final ClubAllEventsFragment clubAllEventsFragment = this;
        final Function0 function0 = null;
        this.clubViewModel = FragmentViewModelLazyKt.createViewModelLazy(clubAllEventsFragment, Reflection.getOrCreateKotlinClass(ClubViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubAllEventsFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = clubAllEventsFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubAllEventsFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = clubAllEventsFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubAllEventsFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = clubAllEventsFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public static final /* synthetic */ FragmentClubAllEventsBinding access$getBinding(ClubAllEventsFragment clubAllEventsFragment) {
        return clubAllEventsFragment.getBinding();
    }

    /* compiled from: ClubAllEventsFragment.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/club/ClubAllEventsFragment$Companion;", "", "()V", "ARG_CHALLENGE_TYPE_ID", "", "argChallengeTypeId", "newInstance", "Lcom/soletreadmills/sole_v2/ui/club/ClubAllEventsFragment;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public static /* synthetic */ ClubAllEventsFragment newInstance$default(Companion companion, String str, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            return companion.newInstance(str);
        }

        public final ClubAllEventsFragment newInstance(String argChallengeTypeId) {
            ClubAllEventsFragment clubAllEventsFragment = new ClubAllEventsFragment();
            Bundle bundle = new Bundle();
            if (argChallengeTypeId != null) {
                bundle.putString(ClubAllEventsFragment.ARG_CHALLENGE_TYPE_ID, argChallengeTypeId);
            }
            clubAllEventsFragment.setArguments(bundle);
            return clubAllEventsFragment;
        }
    }

    public final ClubViewModel getClubViewModel() {
        return (ClubViewModel) this.clubViewModel.getValue();
    }

    public final int getPage() {
        return this.page;
    }

    public final void setPage(int i) {
        this.page = i;
    }

    public final List<ChallengeItemSimpleData> getDataList() {
        return this.dataList;
    }

    public final void setDataList(List<ChallengeItemSimpleData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.dataList = list;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentClubAllEventsBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentClubAllEventsBinding fragmentClubAllEventsBindingInflate = FragmentClubAllEventsBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentClubAllEventsBindingInflate, "inflate(...)");
        return fragmentClubAllEventsBindingInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            argChallengeTypeId = arguments.getString(ARG_CHALLENGE_TYPE_ID);
        }
        Timber.INSTANCE.d("argChallengeTypeId: " + argChallengeTypeId, new Object[0]);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        FragmentClubAllEventsBinding binding = getBinding();
        if (binding != null && (imageView3 = binding.imgBack) != null) {
            imageView3.setOnClickListener(this);
        }
        FragmentClubAllEventsBinding binding2 = getBinding();
        if (binding2 != null && (imageView2 = binding2.imgSearch) != null) {
            imageView2.setOnClickListener(this);
        }
        FragmentClubAllEventsBinding binding3 = getBinding();
        if (binding3 != null && (imageView = binding3.imgClear) != null) {
            imageView.setOnClickListener(this);
        }
        FragmentClubAllEventsBinding binding4 = getBinding();
        if (binding4 != null && (linearLayout4 = binding4.LLFormat) != null) {
            linearLayout4.setOnClickListener(this);
        }
        FragmentClubAllEventsBinding binding5 = getBinding();
        if (binding5 != null && (linearLayout3 = binding5.LLEquipment) != null) {
            linearLayout3.setOnClickListener(this);
        }
        FragmentClubAllEventsBinding binding6 = getBinding();
        if (binding6 != null && (linearLayout2 = binding6.LLDuration) != null) {
            linearLayout2.setOnClickListener(this);
        }
        FragmentClubAllEventsBinding binding7 = getBinding();
        if (binding7 != null && (linearLayout = binding7.LLTarget) != null) {
            linearLayout.setOnClickListener(this);
        }
        if (argChallengeTypeId != null) {
            Timber.INSTANCE.d("argChallengeTypeId:" + argChallengeTypeId, new Object[0]);
            String str = argChallengeTypeId;
            Intrinsics.checkNotNull(str);
            this.savedFormatSelections = CollectionsKt.mutableListOf(str);
        }
        setAllFilter();
        setRecyclerview();
        getAllEvent();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.imgBack;
        if (numValueOf != null && numValueOf.intValue() == i) {
            safeNavigateUp();
            return;
        }
        int i2 = R.id.imgSearch;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            BaseFragment.safeNavigate$default(this, R.id.clubSearchEventFragment, null, 2, null);
            return;
        }
        int i3 = R.id.img_clear;
        if (numValueOf != null && numValueOf.intValue() == i3) {
            this.savedFormatSelections.clear();
            this.savedEquipmentSelections.clear();
            this.savedDurationSelections.clear();
            this.savedTargetSelections.clear();
            setAllFilter();
            getAllEvent();
            return;
        }
        int i4 = R.id.LL_format;
        if (numValueOf != null && numValueOf.intValue() == i4) {
            openFormatSelector();
            return;
        }
        int i5 = R.id.LL_equipment;
        if (numValueOf != null && numValueOf.intValue() == i5) {
            openEquipmentSelector();
            return;
        }
        int i6 = R.id.LL_duration;
        if (numValueOf != null && numValueOf.intValue() == i6) {
            openDurationSelector();
            return;
        }
        int i7 = R.id.LL_target;
        if (numValueOf != null && numValueOf.intValue() == i7) {
            openTargetSelector();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setRecyclerview() {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        Context context = getContext();
        if (context == null) {
            return;
        }
        FragmentClubAllEventsBinding binding = getBinding();
        RecyclerView.Adapter adapter = null;
        if (!(((binding == null || (recyclerView3 = binding.rv) == null) ? null : recyclerView3.getLayoutManager()) instanceof LinearLayoutManager)) {
            FragmentClubAllEventsBinding binding2 = getBinding();
            RecyclerView recyclerView4 = binding2 != null ? binding2.rv : null;
            if (recyclerView4 != null) {
                recyclerView4.setLayoutManager(new LinearLayoutManager(context));
            }
        }
        FragmentClubAllEventsBinding binding3 = getBinding();
        if (!(((binding3 == null || (recyclerView2 = binding3.rv) == null) ? null : recyclerView2.getAdapter()) instanceof ClubListItemAdapter)) {
            MainActivity mainActivity = getMainActivity();
            ClubListItemAdapter clubListItemAdapter = mainActivity != null ? new ClubListItemAdapter(mainActivity, new ClubListItemAdapter.OnItemClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubAllEventsFragment$setRecyclerview$adapter$1$1
                @Override // com.soletreadmills.sole_v2.ui.adapter.club.ClubListItemAdapter.OnItemClickListener
                public void onClick(int position, ChallengeItemSimpleData item) {
                    Intrinsics.checkNotNullParameter(item, "item");
                    this.this$0.getClubViewModel().setSelectChallengeId(item.getChallengeUuid());
                    BaseFragment.safeNavigate$default(this.this$0, R.id.clubEventDetailFragment, null, 2, null);
                }
            }, true, false, true) : null;
            FragmentClubAllEventsBinding binding4 = getBinding();
            RecyclerView recyclerView5 = binding4 != null ? binding4.rv : null;
            if (recyclerView5 != null) {
                recyclerView5.setAdapter(clubListItemAdapter);
            }
        }
        ArrayList arrayList = new ArrayList();
        for (ChallengeItemSimpleData challengeItemSimpleData : this.dataList) {
            arrayList.add(challengeItemSimpleData.copy((33554431 & 1) != 0 ? challengeItemSimpleData.challengeName : null, (33554431 & 2) != 0 ? challengeItemSimpleData.startTimeMillis : 0L, (33554431 & 4) != 0 ? challengeItemSimpleData.endTimeMillis : 0L, (33554431 & 8) != 0 ? challengeItemSimpleData.timeZone : null, (33554431 & 16) != 0 ? challengeItemSimpleData.leaderGlobalUserUuid : null, (33554431 & 32) != 0 ? challengeItemSimpleData.leaderSimpleInfo : null, (33554431 & 64) != 0 ? challengeItemSimpleData.challengeType : 0, (33554431 & 128) != 0 ? challengeItemSimpleData.challengeUuid : null, (33554431 & 256) != 0 ? challengeItemSimpleData.photoUrl : null, (33554431 & 512) != 0 ? challengeItemSimpleData.privacyLevel : 0, (33554431 & 1024) != 0 ? challengeItemSimpleData.goalValue : AudioStats.AUDIO_AMPLITUDE_NONE, (33554431 & 2048) != 0 ? challengeItemSimpleData.scoreItem : 0, (33554431 & 4096) != 0 ? challengeItemSimpleData.onMachineType : null, (33554431 & 8192) != 0 ? challengeItemSimpleData.memberCount : 0, (33554431 & 16384) != 0 ? challengeItemSimpleData.activityStatus : 0, (33554431 & 32768) != 0 ? challengeItemSimpleData.currentScore : null, (33554431 & 65536) != 0 ? challengeItemSimpleData.rank : null, (33554431 & 131072) != 0 ? challengeItemSimpleData.progress : 0.0f, (33554431 & 262144) != 0 ? challengeItemSimpleData.isGoalReached : false, (33554431 & 524288) != 0 ? challengeItemSimpleData.createdTime : 0L, (33554431 & 1048576) != 0 ? challengeItemSimpleData.midTimeMillis : 0L, (33554431 & 2097152) != 0 ? challengeItemSimpleData.memberRankScoreList : null, (4194304 & 33554431) != 0 ? challengeItemSimpleData.iconIdOnConsole : null, (33554431 & 8388608) != 0 ? challengeItemSimpleData.virtualRaceCode : null, (33554431 & 16777216) != 0 ? challengeItemSimpleData.displayMeasurementUnit : 0));
        }
        FragmentClubAllEventsBinding binding5 = getBinding();
        if (binding5 != null && (recyclerView = binding5.rv) != null) {
            adapter = recyclerView.getAdapter();
        }
        if (adapter instanceof ClubListItemAdapter) {
            ((ClubListItemAdapter) adapter).submitList(CollectionsKt.toList(arrayList));
        }
    }

    private final void openFormatSelector() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        new FormatSelectorBottomSheet(context, this.savedFormatSelections, new Function1<List<String>, Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubAllEventsFragment.openFormatSelector.1
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> selected) {
                Intrinsics.checkNotNullParameter(selected, "selected");
                ClubAllEventsFragment.this.savedFormatSelections = selected;
                ClubAllEventsFragment.this.setAllFilter();
                ClubAllEventsFragment.this.getAllEvent();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<String> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }
        }).show();
    }

    private final void openEquipmentSelector() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        new EquipmentSelectorBottomSheet(context, this.savedEquipmentSelections, new Function1<List<String>, Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubAllEventsFragment.openEquipmentSelector.1
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> selected) {
                Intrinsics.checkNotNullParameter(selected, "selected");
                ClubAllEventsFragment.this.savedEquipmentSelections = selected;
                ClubAllEventsFragment.this.setAllFilter();
                ClubAllEventsFragment.this.getAllEvent();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<String> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }
        }).show();
    }

    private final void openDurationSelector() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        new DurationSelectorBottomSheet(context, this.savedDurationSelections, new Function1<List<String>, Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubAllEventsFragment.openDurationSelector.1
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> selected) {
                Intrinsics.checkNotNullParameter(selected, "selected");
                ClubAllEventsFragment.this.savedDurationSelections = selected;
                ClubAllEventsFragment.this.setAllFilter();
                ClubAllEventsFragment.this.getAllEvent();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<String> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }
        }).show();
    }

    private final void openTargetSelector() {
        Context context = getContext();
        if (context == null) {
            return;
        }
        new TargetSelectorBottomSheet(context, this.savedTargetSelections, new Function1<List<String>, Unit>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubAllEventsFragment.openTargetSelector.1
            {
                super(1);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(List<String> selected) {
                Intrinsics.checkNotNullParameter(selected, "selected");
                ClubAllEventsFragment.this.savedTargetSelections = selected;
                ClubAllEventsFragment.this.setAllFilter();
                ClubAllEventsFragment.this.getAllEvent();
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(List<String> list) {
                invoke2(list);
                return Unit.INSTANCE;
            }
        }).show();
    }

    public final void setAllFilter() {
        int size = this.savedFormatSelections.size();
        FragmentClubAllEventsBinding binding = getBinding();
        LinearLayout linearLayout = binding != null ? binding.LLFormat : null;
        FragmentClubAllEventsBinding binding2 = getBinding();
        TextView textView = binding2 != null ? binding2.tvFormatCount : null;
        FragmentClubAllEventsBinding binding3 = getBinding();
        TextView textView2 = binding3 != null ? binding3.tvFormatTitle : null;
        FragmentClubAllEventsBinding binding4 = getBinding();
        setLayoutView(size, linearLayout, textView, textView2, binding4 != null ? binding4.imgFormat : null);
        int size2 = this.savedEquipmentSelections.size();
        FragmentClubAllEventsBinding binding5 = getBinding();
        LinearLayout linearLayout2 = binding5 != null ? binding5.LLEquipment : null;
        FragmentClubAllEventsBinding binding6 = getBinding();
        TextView textView3 = binding6 != null ? binding6.tvEquipmentCount : null;
        FragmentClubAllEventsBinding binding7 = getBinding();
        TextView textView4 = binding7 != null ? binding7.tvEquipmentTitle : null;
        FragmentClubAllEventsBinding binding8 = getBinding();
        setLayoutView(size2, linearLayout2, textView3, textView4, binding8 != null ? binding8.imgEquipment : null);
        int size3 = this.savedDurationSelections.size();
        FragmentClubAllEventsBinding binding9 = getBinding();
        LinearLayout linearLayout3 = binding9 != null ? binding9.LLDuration : null;
        FragmentClubAllEventsBinding binding10 = getBinding();
        TextView textView5 = binding10 != null ? binding10.tvDurationCount : null;
        FragmentClubAllEventsBinding binding11 = getBinding();
        TextView textView6 = binding11 != null ? binding11.tvDurationTitle : null;
        FragmentClubAllEventsBinding binding12 = getBinding();
        setLayoutView(size3, linearLayout3, textView5, textView6, binding12 != null ? binding12.imgDuration : null);
        int size4 = this.savedTargetSelections.size();
        FragmentClubAllEventsBinding binding13 = getBinding();
        LinearLayout linearLayout4 = binding13 != null ? binding13.LLTarget : null;
        FragmentClubAllEventsBinding binding14 = getBinding();
        TextView textView7 = binding14 != null ? binding14.tvTargetCount : null;
        FragmentClubAllEventsBinding binding15 = getBinding();
        TextView textView8 = binding15 != null ? binding15.tvTargetTitle : null;
        FragmentClubAllEventsBinding binding16 = getBinding();
        setLayoutView(size4, linearLayout4, textView7, textView8, binding16 != null ? binding16.imgTarget : null);
    }

    public final void setLayoutView(int listSize, LinearLayout linearLayout, TextView tvCount, TextView tvTitle, ImageView img) {
        Context context = getContext();
        if (context == null) {
            return;
        }
        if (listSize <= 0) {
            if (tvCount != null) {
                tvCount.setVisibility(8);
            }
            if (linearLayout != null) {
                linearLayout.setBackgroundResource(R.drawable.bg_corner28_line_canvas_gray);
            }
            if (img != null) {
                img.setImageResource(R.drawable.ic_s__chevron_down);
            }
            if (tvTitle != null) {
                tvTitle.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_label1));
                return;
            }
            return;
        }
        if (tvCount != null) {
            tvCount.setVisibility(0);
        }
        if (tvCount != null) {
            tvCount.setText(String.valueOf(listSize));
        }
        if (linearLayout != null) {
            linearLayout.setBackgroundResource(R.drawable.bg_corner28_red_raised_bg);
        }
        if (img != null) {
            img.setImageResource(R.drawable.ic_s__chevron_down_red);
        }
        if (tvTitle != null) {
            tvTitle.setTextColor(ContextCompat.getColor(context, R.color.colorLabel_accent));
        }
    }

    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue
    java.lang.NullPointerException: Cannot invoke "java.util.List.iterator()" because the return value of "jadx.core.dex.visitors.regions.SwitchOverStringVisitor$SwitchData.getNewCases()" is null
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.restoreSwitchOverString(SwitchOverStringVisitor.java:109)
    	at jadx.core.dex.visitors.regions.SwitchOverStringVisitor.visitRegion(SwitchOverStringVisitor.java:66)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:77)
    	at jadx.core.dex.visitors.regions.DepthRegionTraversal.traverseIterativeStepInternal(DepthRegionTraversal.java:82)
     */
    public final void getAllEvent() {
        int size;
        GetPublicChallengesToJoinApiData.RequestBodyData requestBodyData = new GetPublicChallengesToJoinApiData.RequestBodyData(null, null, Integer.valueOf(this.page), null, null, null, null, 123, null);
        if (this.savedFormatSelections.size() > 0) {
            size = this.savedFormatSelections.size();
            ArrayList arrayList = new ArrayList();
            for (String str : this.savedFormatSelections) {
                int iHashCode = str.hashCode();
                if (iHashCode != -1784683240) {
                    if (iHashCode != -991731588) {
                        if (iHashCode == 978111542 && str.equals("ranking")) {
                            arrayList.add(2);
                        }
                    } else if (str.equals("virtualRace")) {
                        arrayList.add(3);
                    }
                } else if (str.equals("sharedGoal")) {
                    arrayList.add(1);
                }
            }
            requestBodyData.setChallengeTypes(arrayList);
        } else {
            size = 0;
        }
        if (this.savedEquipmentSelections.size() > 0) {
            size += this.savedEquipmentSelections.size();
            ArrayList arrayList2 = new ArrayList();
            if (this.savedEquipmentSelections.contains("any")) {
                requestBodyData.setOnMachineTypes(CollectionsKt.emptyList());
            } else {
                for (String str2 : this.savedEquipmentSelections) {
                    switch (str2.hashCode()) {
                        case -1893554479:
                            if (str2.equals("stepper")) {
                                arrayList2.add(3);
                                break;
                            } else {
                                break;
                            }
                        case -78115034:
                            if (str2.equals("treadmill")) {
                                arrayList2.add(0);
                                break;
                            } else {
                                break;
                            }
                        case 3023841:
                            if (str2.equals("bike")) {
                                arrayList2.add(1);
                                break;
                            } else {
                                break;
                            }
                        case 108705799:
                            if (str2.equals("rower")) {
                                arrayList2.add(4);
                                break;
                            } else {
                                break;
                            }
                        case 955799597:
                            if (str2.equals("elliptical")) {
                                arrayList2.add(2);
                                break;
                            } else {
                                break;
                            }
                    }
                }
                requestBodyData.setOnMachineTypes(arrayList2);
            }
        }
        if (this.savedDurationSelections.size() > 0) {
            size += this.savedDurationSelections.size();
            ArrayList arrayList3 = new ArrayList();
            for (String str3 : this.savedDurationSelections) {
                switch (str3.hashCode()) {
                    case 48537:
                        if (str3.equals("1-5")) {
                            arrayList3.add(10);
                            break;
                        } else {
                            break;
                        }
                    case 53304:
                        if (str3.equals("6+M")) {
                            arrayList3.add(60);
                            break;
                        } else {
                            break;
                        }
                    case 1504662:
                        if (str3.equals("1-3M")) {
                            arrayList3.add(40);
                            break;
                        } else {
                            break;
                        }
                    case 1564337:
                        if (str3.equals("3-6M")) {
                            arrayList3.add(50);
                            break;
                        } else {
                            break;
                        }
                    case 1623740:
                        if (str3.equals("5-15")) {
                            arrayList3.add(20);
                            break;
                        } else {
                            break;
                        }
                    case 46876326:
                        if (str3.equals("15-30")) {
                            arrayList3.add(30);
                            break;
                        } else {
                            break;
                        }
                }
            }
            requestBodyData.setDurations(arrayList3);
        }
        if (this.savedTargetSelections.size() > 0) {
            size += this.savedTargetSelections.size();
            ArrayList arrayList4 = new ArrayList();
            for (String str4 : this.savedTargetSelections) {
                switch (str4.hashCode()) {
                    case -1051328410:
                        if (str4.equals("active_time")) {
                            arrayList4.add(Integer.valueOf(ChallengeScoreItemSettings.TOTAL_TIME.getId()));
                            break;
                        } else {
                            break;
                        }
                    case -168965370:
                        if (str4.equals("calories")) {
                            arrayList4.add(Integer.valueOf(ChallengeScoreItemSettings.TOTAL_CALORIES.getId()));
                            break;
                        } else {
                            break;
                        }
                    case 288459765:
                        if (str4.equals("distance")) {
                            arrayList4.add(Integer.valueOf(ChallengeScoreItemSettings.TOTAL_DISTANCE.getId()));
                            break;
                        } else {
                            break;
                        }
                    case 1405079709:
                        if (str4.equals("sessions")) {
                            arrayList4.add(Integer.valueOf(ChallengeScoreItemSettings.SESSION.getId()));
                            break;
                        } else {
                            break;
                        }
                }
            }
            requestBodyData.setScoreItems(arrayList4);
        }
        if (size > 0) {
            FragmentClubAllEventsBinding binding = getBinding();
            LinearLayout linearLayout = binding != null ? binding.LLResults : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(0);
            }
            FragmentClubAllEventsBinding binding2 = getBinding();
            TextView textView = binding2 != null ? binding2.txtFilterCount : null;
            if (textView != null) {
                textView.setText(getString(R.string.filter_count, Integer.valueOf(size)));
            }
        } else {
            FragmentClubAllEventsBinding binding3 = getBinding();
            LinearLayout linearLayout2 = binding3 != null ? binding3.LLResults : null;
            if (linearLayout2 != null) {
                linearLayout2.setVisibility(8);
            }
            FragmentClubAllEventsBinding binding4 = getBinding();
            TextView textView2 = binding4 != null ? binding4.txtFilterCount : null;
            if (textView2 != null) {
                textView2.setText(getString(R.string.filter_count, Integer.valueOf(size)));
            }
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(requestBodyData, this, null), 3, null);
    }

    /* compiled from: ClubAllEventsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubAllEventsFragment$getAllEvent$1", f = "ClubAllEventsFragment.kt", i = {}, l = {389}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubAllEventsFragment$getAllEvent$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ GetPublicChallengesToJoinApiData.RequestBodyData $requestBody;
        int label;
        final /* synthetic */ ClubAllEventsFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(GetPublicChallengesToJoinApiData.RequestBodyData requestBodyData, ClubAllEventsFragment clubAllEventsFragment, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$requestBody = requestBodyData;
            this.this$0 = clubAllEventsFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$requestBody, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            View root;
            GetPublicChallengesToJoinApiData.DataMap sysResponseData;
            GetPublicChallengesToJoinApiData.DataMap sysResponseData2;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        obj = DyacoApiKt.callGetPublicChallengesToJoin(this.$requestBody, this);
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
                    GetPublicChallengesToJoinApiData.ResponseData responseData = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                    if (responseData != null && (sysResponseData2 = responseData.getSysResponseData()) != null) {
                        sysResponseData2.getTotalCount();
                    }
                    GetPublicChallengesToJoinApiData.ResponseData responseData2 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                    List<ChallengeItemSimpleData> data = (responseData2 == null || (sysResponseData = responseData2.getSysResponseData()) == null) ? null : sysResponseData.getData();
                    GetPublicChallengesToJoinApiData.ResponseData responseData3 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                    String errorCode = responseData3 != null ? responseData3.getErrorCode() : null;
                    Timber.INSTANCE.d("callGetPublicChallengesToJoin: " + response, new Object[0]);
                    GetPublicChallengesToJoinApiData.ResponseData responseData4 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                    if (responseData4 == null || !responseData4.getSuccess() || data == null) {
                        if (this.this$0.shouldIgnoreError(errorCode)) {
                            return Unit.INSTANCE;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required))).get(errorCode);
                        if (num != null) {
                            ClubAllEventsFragment clubAllEventsFragment = this.this$0;
                            CustomDialogKt.showCustomDialog$default(clubAllEventsFragment, null, clubAllEventsFragment.getString(num.intValue()), this.this$0.getString(R.string.confirm), null, null, null, false, 112, null);
                        } else {
                            ClubAllEventsFragment clubAllEventsFragment2 = this.this$0;
                            GetPublicChallengesToJoinApiData.ResponseData responseData5 = (GetPublicChallengesToJoinApiData.ResponseData) response.body();
                            BaseFragment.handleUndefinedError$default(clubAllEventsFragment2, "getAllEvent", errorCode, responseData5 != null ? responseData5.getErrorMessage() : null, false, 8, null);
                        }
                    } else {
                        if (this.this$0.getPage() >= 2) {
                            this.this$0.getDataList().addAll(data);
                        } else {
                            this.this$0.getDataList().clear();
                            this.this$0.getDataList().addAll(data);
                        }
                        FragmentClubAllEventsBinding fragmentClubAllEventsBindingAccess$getBinding = ClubAllEventsFragment.access$getBinding(this.this$0);
                        if (fragmentClubAllEventsBindingAccess$getBinding != null && (root = fragmentClubAllEventsBindingAccess$getBinding.getRoot()) != null) {
                            final ClubAllEventsFragment clubAllEventsFragment3 = this.this$0;
                            Boxing.boxBoolean(root.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.club.ClubAllEventsFragment$getAllEvent$1$$ExternalSyntheticLambda0
                                @Override // java.lang.Runnable
                                public final void run() {
                                    ClubAllEventsFragment.AnonymousClass1.invokeSuspend$lambda$0(clubAllEventsFragment3);
                                }
                            }));
                        }
                        this.this$0.setRecyclerview();
                    }
                } catch (IOException e) {
                    Timber.INSTANCE.e(e, "API call failed", new Object[0]);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(this.this$0, "getAllEvent", message, false, 4, null);
                }
                this.this$0.stopLoading();
                return Unit.INSTANCE;
            } finally {
                this.this$0.stopLoading();
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invokeSuspend$lambda$0(ClubAllEventsFragment clubAllEventsFragment) {
            FragmentClubAllEventsBinding fragmentClubAllEventsBindingAccess$getBinding = ClubAllEventsFragment.access$getBinding(clubAllEventsFragment);
            TextView textView = fragmentClubAllEventsBindingAccess$getBinding != null ? fragmentClubAllEventsBindingAccess$getBinding.txtResultsCount : null;
            if (textView == null) {
                return;
            }
            textView.setText(clubAllEventsFragment.getString(R.string.results_count, Integer.valueOf(clubAllEventsFragment.getDataList().size())));
        }
    }
}
