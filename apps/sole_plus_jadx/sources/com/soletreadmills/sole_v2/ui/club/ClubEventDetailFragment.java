package com.soletreadmills.sole_v2.ui.club;

import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.core.os.BundleKt;
import androidx.core.widget.NestedScrollView;
import androidx.fragment.app.FragmentActivity;
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
import com.bumptech.glide.Glide;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._data.api.club.DeleteChallengeApiData;
import com.soletreadmills.sole_v2._data.api.club.GetChallengeDetailApiData;
import com.soletreadmills.sole_v2._data.api.club.JoinChallengeApiData;
import com.soletreadmills.sole_v2._data.api.club.QuitChallengeApiData;
import com.soletreadmills.sole_v2._data.club.ChallengeActivityStatus;
import com.soletreadmills.sole_v2._data.club.ChallengeEditModeTypeSettings;
import com.soletreadmills.sole_v2._data.club.ChallengeItemFullData;
import com.soletreadmills.sole_v2._data.club.ChallengeMemberData;
import com.soletreadmills.sole_v2._data.club.ChallengePrivacyLevelSettings;
import com.soletreadmills.sole_v2._data.club.ChallengeScoreItemSettings;
import com.soletreadmills.sole_v2._data.club.ChallengeTypeSettings;
import com.soletreadmills.sole_v2._data.club.ChallengeVirtualRaceFailReasonSettings;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2.ble.type.BleFtmsMachineType;
import com.soletreadmills.sole_v2.databinding.FragmentClubEventDetailBinding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.adapter.club.ClubAvatarItemAdapter;
import com.soletreadmills.sole_v2.ui.adapter.club.ClubListItemAdapterKt;
import com.soletreadmills.sole_v2.ui.adapter.club.ClubOngoingItemAdapterKt;
import com.soletreadmills.sole_v2.ui.adapter.club.ClubScoreboardItemAdapterKt;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
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
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: ClubEventDetailFragment.kt */
@Metadata(d1 = {"\u0000\u0082\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 N2\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001NB\u0005¢\u0006\u0002\u0010\u0004J8\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dH\u0002J8\u0010#\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001f2\u0006\u0010!\u001a\u00020\u001d2\u0006\u0010\"\u001a\u00020\u001dH\u0002J\u0010\u0010$\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&H\u0002J\u001a\u0010'\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&2\b\b\u0002\u0010(\u001a\u00020\u0013H\u0002J\u0018\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020\u001dH\u0002J\u0018\u0010-\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\u0006\u0010.\u001a\u00020\u001dH\u0002J\u0018\u0010/\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\u0006\u00100\u001a\u00020\u001dH\u0002J \u00101\u001a\u00020&2\u0006\u0010*\u001a\u00020+2\u0006\u0010!\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\u001dH\u0002J\b\u00103\u001a\u00020\u0019H\u0002J\b\u00104\u001a\u00020\u0019H\u0002J\b\u00105\u001a\u00020\u0019H\u0002J\u001a\u00106\u001a\u00020\u00022\u0006\u00107\u001a\u0002082\b\u00109\u001a\u0004\u0018\u00010:H\u0016J\b\u0010;\u001a\u00020\u0019H\u0016J \u0010<\u001a\u00020\u00192\n\b\u0002\u0010%\u001a\u0004\u0018\u00010&2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010&H\u0002J\u0012\u0010>\u001a\u00020\u00192\b\u0010?\u001a\u0004\u0018\u00010@H\u0016J\b\u0010A\u001a\u00020\u0019H\u0016J\u001e\u0010B\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u001b0C2\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u001b0CH\u0002J\u0010\u0010D\u001a\u00020\u00192\u0006\u0010%\u001a\u00020&H\u0002J\b\u0010E\u001a\u00020\u0019H\u0002J\u0010\u0010F\u001a\u00020\u00192\u0006\u0010*\u001a\u00020+H\u0002J\u0018\u0010G\u001a\u00020\u00192\u0006\u0010H\u001a\u00020I2\u0006\u0010J\u001a\u00020\u001bH\u0002J\u0010\u0010K\u001a\u00020\u00192\u0006\u0010H\u001a\u00020IH\u0002J\u001a\u0010L\u001a\u00020\u00192\u0006\u0010H\u001a\u00020I2\b\u0010J\u001a\u0004\u0018\u00010\u001bH\u0002J\u0010\u0010M\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020IH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.¢\u0006\u0002\n\u0000R\u001b\u0010\u0007\u001a\u00020\b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\t\u0010\nR\u001b\u0010\r\u001a\u00020\u000e8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\f\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006O"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/club/ClubEventDetailFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentClubEventDetailBinding;", "Landroid/view/View$OnClickListener;", "()V", "clubAvatarAdapter", "Lcom/soletreadmills/sole_v2/ui/adapter/club/ClubAvatarItemAdapter;", "clubRaceViewModel", "Lcom/soletreadmills/sole_v2/ui/club/ClubRaceViewModel;", "getClubRaceViewModel", "()Lcom/soletreadmills/sole_v2/ui/club/ClubRaceViewModel;", "clubRaceViewModel$delegate", "Lkotlin/Lazy;", "clubViewModel", "Lcom/soletreadmills/sole_v2/ui/club/ClubViewModel;", "getClubViewModel", "()Lcom/soletreadmills/sole_v2/ui/club/ClubViewModel;", "clubViewModel$delegate", "haveToRace", "", "getHaveToRace", "()Z", "setHaveToRace", "(Z)V", "bindRankingItem", "", "data", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberData;", "position", "", "maxScore", "", "minScore", "scoreItem", "challengeType", "bindRankingProgressItem", "deleteChallenge", "challengeUuid", "", "getChallengeDetail", "isWithMemberData", "getChallengePrivacyText", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "privacyId", "getChallengeScoreItemText", "scoreItemId", "getChallengeStatusText", "statusId", "getChallengeTypeText", "challengeTypeId", "hideGoalArea", "hideRankArea", "hideVirtualRaceArea", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "joinChallenge", "passCode", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onResume", "prepareAvatarData", "", "quitChallenge", "setupAvatarRecycleView", "shareMessage", "showGoalArea", SdkConstants.TAG_ITEM, "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemFullData;", "myData", "showRankArea", "showVirtualRaceArea", "updateDetailView", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubEventDetailFragment extends BaseFragment<FragmentClubEventDetailBinding> implements View.OnClickListener {
    private static final String ARG_CHALLENGE_ID = "challenge_id";
    private static final String ARG_CHALLENGE_TYPE = "challenge_type_id";
    private static final String ARG_PAGE_EDIT_MODE_ID = "page_mode_id";
    private ClubAvatarItemAdapter clubAvatarAdapter;

    /* renamed from: clubRaceViewModel$delegate, reason: from kotlin metadata */
    private final Lazy clubRaceViewModel;

    /* renamed from: clubViewModel$delegate, reason: from kotlin metadata */
    private final Lazy clubViewModel;
    private boolean haveToRace;
    public static final int $stable = 8;

    /* compiled from: ClubEventDetailFragment.kt */
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
    }

    public ClubEventDetailFragment() {
        final ClubEventDetailFragment clubEventDetailFragment = this;
        final Function0 function0 = null;
        this.clubViewModel = FragmentViewModelLazyKt.createViewModelLazy(clubEventDetailFragment, Reflection.getOrCreateKotlinClass(ClubViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = clubEventDetailFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = clubEventDetailFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = clubEventDetailFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
        this.clubRaceViewModel = FragmentViewModelLazyKt.createViewModelLazy(clubEventDetailFragment, Reflection.getOrCreateKotlinClass(ClubRaceViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$special$$inlined$activityViewModels$default$4
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = clubEventDetailFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$special$$inlined$activityViewModels$default$5
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
                CreationExtras defaultViewModelCreationExtras = clubEventDetailFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$special$$inlined$activityViewModels$default$6
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = clubEventDetailFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
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
    public FragmentClubEventDetailBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentClubEventDetailBinding fragmentClubEventDetailBindingInflate = FragmentClubEventDetailBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentClubEventDetailBindingInflate, "inflate(...)");
        return fragmentClubEventDetailBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        SwipeRefreshLayout swipeRefreshLayout;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        TextView textView;
        TextView textView2;
        LinearLayout linearLayout;
        ImageView imageView4;
        ImageView imageView5;
        NestedScrollView nestedScrollView;
        NestedScrollView nestedScrollView2;
        Resources resources;
        FragmentClubEventDetailBinding binding = getBinding();
        final float fApplyDimension = TypedValue.applyDimension(1, 280.0f, (binding == null || (nestedScrollView2 = binding.nestedScrollView2) == null || (resources = nestedScrollView2.getResources()) == null) ? null : resources.getDisplayMetrics());
        FragmentClubEventDetailBinding binding2 = getBinding();
        if (binding2 != null && (nestedScrollView = binding2.nestedScrollView2) != null) {
            nestedScrollView.setOnScrollChangeListener(new NestedScrollView.OnScrollChangeListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$$ExternalSyntheticLambda0
                @Override // androidx.core.widget.NestedScrollView.OnScrollChangeListener
                public final void onScrollChange(NestedScrollView nestedScrollView3, int i, int i2, int i3, int i4) {
                    ClubEventDetailFragment.initViews$lambda$0(fApplyDimension, this, nestedScrollView3, i, i2, i3, i4);
                }
            });
        }
        final String value = getClubViewModel().getSelectedChallengeId().getValue();
        setupAvatarRecycleView();
        FragmentClubEventDetailBinding binding3 = getBinding();
        LinearLayout linearLayout2 = binding3 != null ? binding3.llMenu1ForOwner : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        FragmentClubEventDetailBinding binding4 = getBinding();
        LinearLayout linearLayout3 = binding4 != null ? binding4.llMenu2ForMember : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        FragmentClubEventDetailBinding binding5 = getBinding();
        if (binding5 != null && (imageView5 = binding5.imgBackBtn) != null) {
            imageView5.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$$ExternalSyntheticLambda6
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubEventDetailFragment.initViews$lambda$1(this.f$0, view);
                }
            });
        }
        FragmentClubEventDetailBinding binding6 = getBinding();
        if (binding6 != null && (imageView4 = binding6.imgBtnGoPrev) != null) {
            imageView4.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$$ExternalSyntheticLambda7
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubEventDetailFragment.initViews$lambda$2(this.f$0, view);
                }
            });
        }
        FragmentClubEventDetailBinding binding7 = getBinding();
        if (binding7 != null && (linearLayout = binding7.shareButton) != null) {
            linearLayout.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$$ExternalSyntheticLambda8
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubEventDetailFragment.initViews$lambda$4(this.f$0, view);
                }
            });
        }
        FragmentClubEventDetailBinding binding8 = getBinding();
        if (binding8 != null && (textView2 = binding8.joinEventButton) != null) {
            textView2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$$ExternalSyntheticLambda9
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubEventDetailFragment.initViews$lambda$5(this.f$0, value, view);
                }
            });
        }
        FragmentClubEventDetailBinding binding9 = getBinding();
        if (binding9 != null && (textView = binding9.quitEventButton) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$$ExternalSyntheticLambda10
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubEventDetailFragment.initViews$lambda$6(value, this, view);
                }
            });
        }
        FragmentClubEventDetailBinding binding10 = getBinding();
        if (binding10 != null && (imageView3 = binding10.imgShareButtonSmall) != null) {
            imageView3.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$$ExternalSyntheticLambda11
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubEventDetailFragment.initViews$lambda$8(this.f$0, view);
                }
            });
        }
        FragmentClubEventDetailBinding binding11 = getBinding();
        if (binding11 != null && (imageView2 = binding11.imgEditButtonSmall) != null) {
            imageView2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$$ExternalSyntheticLambda12
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubEventDetailFragment.initViews$lambda$10(this.f$0, value, view);
                }
            });
        }
        FragmentClubEventDetailBinding binding12 = getBinding();
        if (binding12 != null && (imageView = binding12.imgDeleteButtonSmall) != null) {
            imageView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$$ExternalSyntheticLambda13
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubEventDetailFragment.initViews$lambda$11(value, this, view);
                }
            });
        }
        ClubEventDetailFragment clubEventDetailFragment = this;
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(clubEventDetailFragment), Dispatchers.getMain(), null, new AnonymousClass10(null), 2, null);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(clubEventDetailFragment), Dispatchers.getMain(), null, new AnonymousClass11(null), 2, null);
        FragmentClubEventDetailBinding binding13 = getBinding();
        if (binding13 == null || (swipeRefreshLayout = binding13.swipeRefresh) == null) {
            return;
        }
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$$ExternalSyntheticLambda14
            @Override // androidx.swiperefreshlayout.widget.SwipeRefreshLayout.OnRefreshListener
            public final void onRefresh() {
                ClubEventDetailFragment.initViews$lambda$12(value, this);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$0(float f, ClubEventDetailFragment this$0, NestedScrollView v, int i, int i2, int i3, int i4) {
        ConstraintLayout constraintLayout;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v, "v");
        if (i2 > f) {
            FragmentClubEventDetailBinding binding = this$0.getBinding();
            constraintLayout = binding != null ? binding.tobBar : null;
            if (constraintLayout == null) {
                return;
            }
            constraintLayout.setVisibility(0);
            return;
        }
        FragmentClubEventDetailBinding binding2 = this$0.getBinding();
        constraintLayout = binding2 != null ? binding2.tobBar : null;
        if (constraintLayout == null) {
            return;
        }
        constraintLayout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$1(ClubEventDetailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.safeNavigateUp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$2(ClubEventDetailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.safeNavigateUp();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$4(ClubEventDetailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainActivity mainActivity = this$0.getMainActivity();
        if (mainActivity != null) {
            this$0.shareMessage(mainActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$5(ClubEventDetailFragment this$0, String str, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        joinChallenge$default(this$0, str, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$6(String str, ClubEventDetailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str != null) {
            LifecycleOwner viewLifecycleOwner = this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new ClubEventDetailFragment$initViews$6$1(this$0, str, null), 3, null);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$8(ClubEventDetailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        MainActivity mainActivity = this$0.getMainActivity();
        if (mainActivity != null) {
            this$0.shareMessage(mainActivity);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$10(ClubEventDetailFragment this$0, String str, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        ChallengeItemFullData value = this$0.getClubViewModel().getSelectedChallengeData().getValue();
        Integer numValueOf = value != null ? Integer.valueOf(value.getActivityStatus()) : null;
        int id2 = ChallengeActivityStatus.IN_PROGRESS.getId();
        if (numValueOf == null || numValueOf.intValue() != id2) {
            int id3 = ChallengeActivityStatus.IN_PROGRESS_EARLY.getId();
            if (numValueOf == null || numValueOf.intValue() != id3) {
                int id4 = ChallengeActivityStatus.FINISHED.getId();
                if (numValueOf == null || numValueOf.intValue() != id4) {
                    ChallengeItemFullData value2 = this$0.getClubViewModel().getSelectedChallengeData().getValue();
                    if (value2 != null) {
                        this$0.safeNavigate(R.id.clubEditFormFragment, BundleKt.bundleOf(TuplesKt.to(ARG_PAGE_EDIT_MODE_ID, Integer.valueOf(ChallengeEditModeTypeSettings.EDIT.getId())), TuplesKt.to(ARG_CHALLENGE_TYPE, Integer.valueOf(value2.getChallengeType())), TuplesKt.to(ARG_CHALLENGE_ID, str)));
                        return;
                    }
                    return;
                }
            }
        }
        CustomDialogKt.showCustomDialog$default(this$0, null, this$0.getString(R.string.err_4008_only_challenges_that_have_not_yet_started_can_be_modified), this$0.getString(R.string.confirm), null, null, null, false, 112, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$11(String str, ClubEventDetailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str != null) {
            LifecycleOwner viewLifecycleOwner = this$0.getViewLifecycleOwner();
            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new ClubEventDetailFragment$initViews$9$1(this$0, str, null), 3, null);
        }
    }

    /* compiled from: ClubEventDetailFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$initViews$10", f = "ClubEventDetailFragment.kt", i = {}, l = {228}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$initViews$10, reason: invalid class name */
    static final class AnonymousClass10 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass10(Continuation<? super AnonymousClass10> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubEventDetailFragment.this.new AnonymousClass10(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass10) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<String> selectedChallengeId = ClubEventDetailFragment.this.getClubViewModel().getSelectedChallengeId();
                final ClubEventDetailFragment clubEventDetailFragment = ClubEventDetailFragment.this;
                this.label = 1;
                if (selectedChallengeId.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment.initViews.10.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((String) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(String str, Continuation<? super Unit> continuation) {
                        if (str != null) {
                            ClubEventDetailFragment clubEventDetailFragment2 = clubEventDetailFragment;
                            Timber.INSTANCE.d("更新的ID: " + str, new Object[0]);
                            ClubEventDetailFragment.getChallengeDetail$default(clubEventDetailFragment2, str, false, 2, null);
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

    /* compiled from: ClubEventDetailFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$initViews$11", f = "ClubEventDetailFragment.kt", i = {}, l = {237}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$initViews$11, reason: invalid class name */
    static final class AnonymousClass11 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass11(Continuation<? super AnonymousClass11> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubEventDetailFragment.this.new AnonymousClass11(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass11) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                StateFlow<ChallengeItemFullData> selectedChallengeData = ClubEventDetailFragment.this.getClubViewModel().getSelectedChallengeData();
                final ClubEventDetailFragment clubEventDetailFragment = ClubEventDetailFragment.this;
                this.label = 1;
                if (selectedChallengeData.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment.initViews.11.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((ChallengeItemFullData) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(ChallengeItemFullData challengeItemFullData, Continuation<? super Unit> continuation) {
                        if (challengeItemFullData != null) {
                            ClubEventDetailFragment clubEventDetailFragment2 = clubEventDetailFragment;
                            Timber.INSTANCE.d("更新view " + challengeItemFullData, new Object[0]);
                            clubEventDetailFragment2.updateDetailView(challengeItemFullData);
                            List<T> listPrepareAvatarData = clubEventDetailFragment2.prepareAvatarData(challengeItemFullData.getMemberList());
                            ClubAvatarItemAdapter clubAvatarItemAdapter = clubEventDetailFragment2.clubAvatarAdapter;
                            if (clubAvatarItemAdapter == null) {
                                Intrinsics.throwUninitializedPropertyAccessException("clubAvatarAdapter");
                                clubAvatarItemAdapter = null;
                            }
                            clubAvatarItemAdapter.submitList(listPrepareAvatarData);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$12(String str, ClubEventDetailFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (str != null) {
            this$0.getChallengeDetail(str, true);
            FragmentClubEventDetailBinding binding = this$0.getBinding();
            SwipeRefreshLayout swipeRefreshLayout = binding != null ? binding.swipeRefresh : null;
            if (swipeRefreshLayout == null) {
                return;
            }
            swipeRefreshLayout.setRefreshing(false);
        }
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

    private final void setupAvatarRecycleView() {
        RecyclerView recyclerView;
        this.clubAvatarAdapter = new ClubAvatarItemAdapter(getMainActivity(), true);
        new LinearLayoutManager(getContext(), 0, false);
        final Context context = getContext();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context) { // from class: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$setupAvatarRecycleView$nonScrollableLayoutManager$1
            @Override // androidx.recyclerview.widget.LinearLayoutManager, androidx.recyclerview.widget.RecyclerView.LayoutManager
            public boolean canScrollHorizontally() {
                return false;
            }
        };
        FragmentClubEventDetailBinding binding = getBinding();
        if (binding == null || (recyclerView = binding.rvUserList) == null) {
            return;
        }
        ClubAvatarItemAdapter clubAvatarItemAdapter = this.clubAvatarAdapter;
        if (clubAvatarItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("clubAvatarAdapter");
            clubAvatarItemAdapter = null;
        }
        recyclerView.setAdapter(clubAvatarItemAdapter);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:175:0x02be  */
    /* JADX WARN: Removed duplicated region for block: B:554:0x09a2  */
    /* JADX WARN: Removed duplicated region for block: B:555:0x09a5  */
    /* JADX WARN: Removed duplicated region for block: B:558:0x09a9  */
    /* JADX WARN: Removed duplicated region for block: B:565:0x09c8  */
    /* JADX WARN: Removed duplicated region for block: B:566:0x09cb  */
    /* JADX WARN: Removed duplicated region for block: B:569:0x09cf  */
    /* JADX WARN: Removed duplicated region for block: B:576:0x09ec  */
    /* JADX WARN: Removed duplicated region for block: B:577:0x09fb  */
    /* JADX WARN: Removed duplicated region for block: B:580:0x0a04  */
    /* JADX WARN: Removed duplicated region for block: B:581:0x0a07  */
    /* JADX WARN: Removed duplicated region for block: B:584:0x0a0b  */
    /* JADX WARN: Removed duplicated region for block: B:587:0x0a18  */
    /* JADX WARN: Removed duplicated region for block: B:588:0x0a1b  */
    /* JADX WARN: Removed duplicated region for block: B:591:0x0a1f  */
    /* JADX WARN: Removed duplicated region for block: B:598:0x0a3e  */
    /* JADX WARN: Removed duplicated region for block: B:599:0x0a41  */
    /* JADX WARN: Removed duplicated region for block: B:602:0x0a45  */
    /* JADX WARN: Removed duplicated region for block: B:604:0x0a54  */
    /* JADX WARN: Removed duplicated region for block: B:613:0x0a84  */
    /* JADX WARN: Removed duplicated region for block: B:620:0x0a9d  */
    /* JADX WARN: Removed duplicated region for block: B:632:0x0aea  */
    /* JADX WARN: Removed duplicated region for block: B:633:0x0aed  */
    /* JADX WARN: Removed duplicated region for block: B:636:0x0af1  */
    /* JADX WARN: Removed duplicated region for block: B:642:0x0b0f  */
    /* JADX WARN: Removed duplicated region for block: B:644:0x0b17  */
    /* JADX WARN: Removed duplicated region for block: B:645:0x0b1a  */
    /* JADX WARN: Removed duplicated region for block: B:648:0x0b1e  */
    /* JADX WARN: Removed duplicated region for block: B:651:0x0b2f  */
    /* JADX WARN: Removed duplicated region for block: B:671:0x0b66  */
    /* JADX WARN: Removed duplicated region for block: B:675:0x0b6b  */
    /* JADX WARN: Removed duplicated region for block: B:681:0x0b7e  */
    /* JADX WARN: Removed duplicated region for block: B:684:0x0b82  */
    /* JADX WARN: Removed duplicated region for block: B:690:0x0b95  */
    /* JADX WARN: Removed duplicated region for block: B:693:0x0b99  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void updateDetailView(final com.soletreadmills.sole_v2._data.club.ChallengeItemFullData r25) {
        /*
            Method dump skipped, instructions count: 3050
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment.updateDetailView(com.soletreadmills.sole_v2._data.club.ChallengeItemFullData):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateDetailView$lambda$22(ClubEventDetailFragment this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        BaseFragment.safeNavigate$default(this$0, R.id.clubScoreboardListFragment, null, 2, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateDetailView$lambda$33(final ClubEventDetailFragment this$0, final ChallengeItemFullData data, final String str) {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        LinearLayout linearLayout5;
        LinearLayout linearLayout6;
        LinearLayout linearLayout7;
        LinearLayout linearLayout8;
        LinearLayout linearLayout9;
        LinearLayout linearLayout10;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(data, "$data");
        FragmentClubEventDetailBinding binding = this$0.getBinding();
        int width = 0;
        int width2 = (binding == null || (linearLayout10 = binding.LLProgress1) == null) ? 0 : linearLayout10.getWidth();
        FragmentClubEventDetailBinding binding2 = this$0.getBinding();
        int width3 = (binding2 == null || (linearLayout9 = binding2.LLProgress2) == null) ? 0 : linearLayout9.getWidth();
        FragmentClubEventDetailBinding binding3 = this$0.getBinding();
        if (binding3 != null && (linearLayout8 = binding3.LLProgress3) != null) {
            width = linearLayout8.getWidth();
        }
        int iMax = Math.max(width2, Math.max(width3, width));
        FragmentClubEventDetailBinding binding4 = this$0.getBinding();
        ViewGroup.LayoutParams layoutParams = null;
        ViewGroup.LayoutParams layoutParams2 = (binding4 == null || (linearLayout7 = binding4.LLProgress1) == null) ? null : linearLayout7.getLayoutParams();
        if (layoutParams2 != null) {
            layoutParams2.width = iMax;
        }
        FragmentClubEventDetailBinding binding5 = this$0.getBinding();
        ViewGroup.LayoutParams layoutParams3 = (binding5 == null || (linearLayout6 = binding5.LLProgress2) == null) ? null : linearLayout6.getLayoutParams();
        if (layoutParams3 != null) {
            layoutParams3.width = iMax;
        }
        FragmentClubEventDetailBinding binding6 = this$0.getBinding();
        if (binding6 != null && (linearLayout5 = binding6.LLProgress3) != null) {
            layoutParams = linearLayout5.getLayoutParams();
        }
        if (layoutParams != null) {
            layoutParams.width = iMax;
        }
        FragmentClubEventDetailBinding binding7 = this$0.getBinding();
        if (binding7 != null && (linearLayout4 = binding7.LLProgress1) != null) {
            linearLayout4.requestLayout();
        }
        FragmentClubEventDetailBinding binding8 = this$0.getBinding();
        if (binding8 != null && (linearLayout3 = binding8.LLProgress2) != null) {
            linearLayout3.requestLayout();
        }
        FragmentClubEventDetailBinding binding9 = this$0.getBinding();
        if (binding9 != null && (linearLayout2 = binding9.LLProgress3) != null) {
            linearLayout2.requestLayout();
        }
        FragmentClubEventDetailBinding binding10 = this$0.getBinding();
        if (binding10 == null || (linearLayout = binding10.LLProgress3) == null) {
            return;
        }
        linearLayout.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ClubEventDetailFragment.updateDetailView$lambda$33$lambda$32(data, str, this$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void updateDetailView$lambda$33$lambda$32(ChallengeItemFullData data, String str, ClubEventDetailFragment this$0) {
        double dDoubleValue;
        int i;
        Double currentScore;
        Double currentScore2;
        Intrinsics.checkNotNullParameter(data, "$data");
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        List<ChallengeMemberData> rankingList = ClubOngoingItemAdapterKt.getRankingList(data.getMemberList(), str);
        FragmentClubEventDetailBinding binding = this$0.getBinding();
        LinearLayout linearLayout = binding != null ? binding.imgRank1Wrap : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        FragmentClubEventDetailBinding binding2 = this$0.getBinding();
        LinearLayout linearLayout2 = binding2 != null ? binding2.imgRank2Wrap : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        FragmentClubEventDetailBinding binding3 = this$0.getBinding();
        LinearLayout linearLayout3 = binding3 != null ? binding3.imgRank3Wrap : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        List<ChallengeMemberData> list = rankingList;
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = list.iterator();
        while (true) {
            boolean zHasNext = it.hasNext();
            dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
            if (!zHasNext) {
                break;
            }
            Object next = it.next();
            Double currentScore3 = ((ChallengeMemberData) next).getCurrentScore();
            if ((currentScore3 != null ? currentScore3.doubleValue() : 0.0d) > AudioStats.AUDIO_AMPLITUDE_NONE) {
                arrayList.add(next);
            }
        }
        ArrayList arrayList2 = arrayList;
        ChallengeMemberData challengeMemberData = (ChallengeMemberData) CollectionsKt.firstOrNull((List) arrayList2);
        double dDoubleValue2 = (challengeMemberData == null || (currentScore2 = challengeMemberData.getCurrentScore()) == null) ? 0.0d : currentScore2.doubleValue();
        ChallengeMemberData challengeMemberData2 = (ChallengeMemberData) CollectionsKt.lastOrNull((List) arrayList2);
        if (challengeMemberData2 != null && (currentScore = challengeMemberData2.getCurrentScore()) != null) {
            dDoubleValue = currentScore.doubleValue();
        }
        double d = dDoubleValue;
        int i2 = 0;
        int i3 = 0;
        for (Object obj : list) {
            int i4 = i3 + 1;
            if (i3 < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ChallengeMemberData challengeMemberData3 = (ChallengeMemberData) obj;
            if (i3 == 0) {
                i = i2;
                FragmentClubEventDetailBinding binding4 = this$0.getBinding();
                LinearLayout linearLayout4 = binding4 != null ? binding4.imgRank1Wrap : null;
                if (linearLayout4 != null) {
                    linearLayout4.setVisibility(i);
                }
                this$0.bindRankingProgressItem(challengeMemberData3, 1, dDoubleValue2, d, data.getScoreItem(), data.getChallengeType());
            } else if (i3 == 1) {
                i = i2;
                FragmentClubEventDetailBinding binding5 = this$0.getBinding();
                LinearLayout linearLayout5 = binding5 != null ? binding5.imgRank2Wrap : null;
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(i);
                }
                this$0.bindRankingProgressItem(challengeMemberData3, 2, dDoubleValue2, d, data.getScoreItem(), data.getChallengeType());
            } else if (i3 != 2) {
                i = i2;
            } else {
                FragmentClubEventDetailBinding binding6 = this$0.getBinding();
                LinearLayout linearLayout6 = binding6 != null ? binding6.imgRank3Wrap : null;
                if (linearLayout6 != null) {
                    linearLayout6.setVisibility(i2);
                }
                i = i2;
                this$0.bindRankingProgressItem(challengeMemberData3, 3, dDoubleValue2, d, data.getScoreItem(), data.getChallengeType());
            }
            i2 = i;
            i3 = i4;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<ChallengeMemberData> prepareAvatarData(List<ChallengeMemberData> data) {
        ArrayList arrayList = new ArrayList();
        if (data.size() <= 8) {
            arrayList.addAll(data);
        } else {
            arrayList.addAll(CollectionsKt.take(data, 7));
        }
        return arrayList;
    }

    static /* synthetic */ void joinChallenge$default(ClubEventDetailFragment clubEventDetailFragment, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = null;
        }
        if ((i & 2) != 0) {
            str2 = null;
        }
        clubEventDetailFragment.joinChallenge(str, str2);
    }

    /* compiled from: ClubEventDetailFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$joinChallenge$1", f = "ClubEventDetailFragment.kt", i = {}, l = {822}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$joinChallenge$1, reason: invalid class name and case insensitive filesystem */
    static final class C09261 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $challengeUuid;
        final /* synthetic */ String $passCode;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09261(String str, String str2, Continuation<? super C09261> continuation) {
            super(2, continuation);
            this.$challengeUuid = str;
            this.$passCode = str2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubEventDetailFragment.this.new C09261(this.$challengeUuid, this.$passCode, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09261) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Unit unit;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ClubEventDetailFragment.this.showLoading();
                        this.label = 1;
                        obj = DyacoApiKt.callJoinChallenge(new JoinChallengeApiData.RequestBodyData(this.$challengeUuid, this.$passCode), this);
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
                    Timber.INSTANCE.d("callJoinChallengeApiData: " + response, new Object[0]);
                    JoinChallengeApiData.ResponseData responseData = (JoinChallengeApiData.ResponseData) response.body();
                    JoinChallengeApiData.DataMap sysResponseData = responseData != null ? responseData.getSysResponseData() : null;
                    JoinChallengeApiData.ResponseData responseData2 = (JoinChallengeApiData.ResponseData) response.body();
                    String errorCode = responseData2 != null ? responseData2.getErrorCode() : null;
                    JoinChallengeApiData.ResponseData responseData3 = (JoinChallengeApiData.ResponseData) response.body();
                    if (responseData3 == null || !responseData3.getSuccess() || sysResponseData == null) {
                        if (ClubEventDetailFragment.this.shouldIgnoreError(errorCode)) {
                            unit = Unit.INSTANCE;
                        } else if (Intrinsics.areEqual(errorCode, ErrorCode.CHALLENGE_ALREADY_MEMBER_4003.getId())) {
                            String str = this.$challengeUuid;
                            if (str != null) {
                                ClubEventDetailFragment.getChallengeDetail$default(ClubEventDetailFragment.this, str, false, 2, null);
                            }
                            unit = Unit.INSTANCE;
                        } else {
                            Map mapMapOf = MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required)), TuplesKt.to(ErrorCode.INVALID_OPERATION_ON_TARGET_OBJ_STATUS_1045.getId(), Boxing.boxInt(R.string.invalid_operation_on_target_obj_status)), TuplesKt.to(ErrorCode.CHALLENGE_PASSCODE_REQUIRED_4002.getId(), Boxing.boxInt(R.string.challenge_passcode_required)), TuplesKt.to(ErrorCode.CHALLENGE_NOT_EXIST_4000.getId(), Boxing.boxInt(R.string.challenge_pass_code_not_exist)), TuplesKt.to(ErrorCode.USER_NOT_FOUND_1003.getId(), Boxing.boxInt(R.string.user_not_found)));
                            JoinChallengeApiData.ResponseData responseData4 = (JoinChallengeApiData.ResponseData) response.body();
                            Integer num = (Integer) mapMapOf.get(responseData4 != null ? responseData4.getErrorCode() : null);
                            if (num != null) {
                                LifecycleOwner viewLifecycleOwner = ClubEventDetailFragment.this.getViewLifecycleOwner();
                                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                                BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C02161(ClubEventDetailFragment.this, num, null), 3, null);
                            } else {
                                ClubEventDetailFragment clubEventDetailFragment = ClubEventDetailFragment.this;
                                JoinChallengeApiData.ResponseData responseData5 = (JoinChallengeApiData.ResponseData) response.body();
                                BaseFragment.handleUndefinedError$default(clubEventDetailFragment, "joinChallenge", errorCode, responseData5 != null ? responseData5.getErrorMessage() : null, false, 8, null);
                            }
                        }
                        return unit;
                    }
                    Timber.INSTANCE.d("dataJoin:" + sysResponseData, new Object[0]);
                    String str2 = this.$challengeUuid;
                    if (str2 != null) {
                        ClubEventDetailFragment.getChallengeDetail$default(ClubEventDetailFragment.this, str2, false, 2, null);
                    }
                } catch (IOException e) {
                    Timber.INSTANCE.e(e, "API call failed", new Object[0]);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(ClubEventDetailFragment.this, "joinChallenge", message, false, 4, null);
                }
                ClubEventDetailFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                ClubEventDetailFragment.this.stopLoading();
            }
        }

        /* compiled from: ClubEventDetailFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$joinChallenge$1$1", f = "ClubEventDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$joinChallenge$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Integer $msgResId;
            int label;
            final /* synthetic */ ClubEventDetailFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02161(ClubEventDetailFragment clubEventDetailFragment, Integer num, Continuation<? super C02161> continuation) {
                super(2, continuation);
                this.this$0 = clubEventDetailFragment;
                this.$msgResId = num;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02161(this.this$0, this.$msgResId, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ClubEventDetailFragment clubEventDetailFragment = this.this$0;
                CustomDialogKt.showCustomDialog$default(clubEventDetailFragment, null, clubEventDetailFragment.getString(this.$msgResId.intValue()), this.this$0.getString(R.string.confirm), null, null, null, false, 112, null);
                return Unit.INSTANCE;
            }
        }
    }

    private final void joinChallenge(String challengeUuid, String passCode) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09261(challengeUuid, passCode, null), 3, null);
    }

    /* compiled from: ClubEventDetailFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$quitChallenge$1", f = "ClubEventDetailFragment.kt", i = {}, l = {TypedValues.Custom.TYPE_BOOLEAN}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$quitChallenge$1, reason: invalid class name and case insensitive filesystem */
    static final class C09271 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $challengeUuid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09271(String str, Continuation<? super C09271> continuation) {
            super(2, continuation);
            this.$challengeUuid = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubEventDetailFragment.this.new C09271(this.$challengeUuid, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09271) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Unit unit;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ClubEventDetailFragment.this.showLoading();
                        this.label = 1;
                        obj = DyacoApiKt.callQuitChallenge(new QuitChallengeApiData.RequestBodyData(this.$challengeUuid), this);
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
                    ClubEventDetailFragment.this.stopLoading();
                    QuitChallengeApiData.ResponseData responseData = (QuitChallengeApiData.ResponseData) response.body();
                    String errorCode = responseData != null ? responseData.getErrorCode() : null;
                    QuitChallengeApiData.ResponseData responseData2 = (QuitChallengeApiData.ResponseData) response.body();
                    if (responseData2 == null || !responseData2.getSuccess()) {
                        if (ClubEventDetailFragment.this.shouldIgnoreError(errorCode)) {
                            unit = Unit.INSTANCE;
                        } else if (Intrinsics.areEqual(errorCode, ErrorCode.CHALLENGE_NOT_MEMBER_4009.getId())) {
                            BaseFragment.safeNavigateAndClearStack$default(ClubEventDetailFragment.this, R.id.clubMainFragment, null, 2, null);
                            unit = Unit.INSTANCE;
                        } else {
                            Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required)), TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), null), TuplesKt.to(ErrorCode.CHALLENGE_NOT_EXIST_4000.getId(), Boxing.boxInt(R.string.challenge_not_exist)), TuplesKt.to(ErrorCode.CHALLENGE_NOT_ACTIVE_4001.getId(), Boxing.boxInt(R.string.err_4001_challenge_is_not_active)), TuplesKt.to(ErrorCode.CHALLENGE_LEADER_CAN_NOT_QUIT_4011.getId(), Boxing.boxInt(R.string.err_4011_challenge_leader_cant_quit))).get(errorCode);
                            if (num != null) {
                                ClubEventDetailFragment clubEventDetailFragment = ClubEventDetailFragment.this;
                                CustomDialogKt.showCustomDialog$default(clubEventDetailFragment, null, clubEventDetailFragment.getString(num.intValue()), ClubEventDetailFragment.this.getString(R.string.confirm), null, null, null, false, 112, null);
                            } else {
                                ClubEventDetailFragment clubEventDetailFragment2 = ClubEventDetailFragment.this;
                                QuitChallengeApiData.ResponseData responseData3 = (QuitChallengeApiData.ResponseData) response.body();
                                BaseFragment.handleUndefinedError$default(clubEventDetailFragment2, "quitChallenge", errorCode, responseData3 != null ? responseData3.getErrorMessage() : null, false, 8, null);
                            }
                        }
                        return unit;
                    }
                    ClubEventDetailFragment.getChallengeDetail$default(ClubEventDetailFragment.this, this.$challengeUuid, false, 2, null);
                } catch (IOException e) {
                    Timber.INSTANCE.e(e, "API call failed", new Object[0]);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(ClubEventDetailFragment.this, "quitChallenge", message, false, 4, null);
                }
                ClubEventDetailFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                ClubEventDetailFragment.this.stopLoading();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void quitChallenge(String challengeUuid) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09271(challengeUuid, null), 3, null);
    }

    /* compiled from: ClubEventDetailFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$deleteChallenge$1", f = "ClubEventDetailFragment.kt", i = {}, l = {975}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$deleteChallenge$1, reason: invalid class name */
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
            return ClubEventDetailFragment.this.new AnonymousClass1(this.$challengeUuid, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        ClubEventDetailFragment.this.showLoading();
                        this.label = 1;
                        obj = DyacoApiKt.callDeleteChallenge(new DeleteChallengeApiData.RequestBodyData(this.$challengeUuid), this);
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
                    DeleteChallengeApiData.ResponseData responseData = (DeleteChallengeApiData.ResponseData) response.body();
                    String errorCode = responseData != null ? responseData.getErrorCode() : null;
                    DeleteChallengeApiData.ResponseData responseData2 = (DeleteChallengeApiData.ResponseData) response.body();
                    if (responseData2 == null || !responseData2.getSuccess()) {
                        if (ClubEventDetailFragment.this.shouldIgnoreError(errorCode)) {
                            return Unit.INSTANCE;
                        }
                        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required)), TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), null), TuplesKt.to(ErrorCode.CHALLENGE_NOT_EXIST_4000.getId(), Boxing.boxInt(R.string.challenge_pass_code_not_exist)), TuplesKt.to(ErrorCode.CHALLENGE_NOT_LEADER_4007.getId(), Boxing.boxInt(R.string.err_4007_not_challenge_leader)), TuplesKt.to(ErrorCode.CAN_NOT_DELETE_CHALLENGE_WITH_MEMBERS_4012.getId(), Boxing.boxInt(R.string.err_4012_can_t_delete_challenge_with_members)));
                        DeleteChallengeApiData.ResponseData responseData3 = (DeleteChallengeApiData.ResponseData) response.body();
                        Integer num = (Integer) mapMapOf.get(responseData3 != null ? responseData3.getErrorCode() : null);
                        if (num != null) {
                            LifecycleOwner viewLifecycleOwner = ClubEventDetailFragment.this.getViewLifecycleOwner();
                            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C02141(ClubEventDetailFragment.this, num, null), 3, null);
                        } else {
                            ClubEventDetailFragment clubEventDetailFragment = ClubEventDetailFragment.this;
                            DeleteChallengeApiData.ResponseData responseData4 = (DeleteChallengeApiData.ResponseData) response.body();
                            BaseFragment.handleUndefinedError$default(clubEventDetailFragment, "deleteChallenge", errorCode, responseData4 != null ? responseData4.getErrorMessage() : null, false, 8, null);
                        }
                    } else {
                        BaseFragment.safeNavigateAndClearStack$default(ClubEventDetailFragment.this, R.id.clubMainFragment, null, 2, null);
                    }
                } catch (IOException e) {
                    Timber.INSTANCE.e(e, "API call failed", new Object[0]);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(ClubEventDetailFragment.this, "deleteChallenge", message, false, 4, null);
                }
                ClubEventDetailFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                ClubEventDetailFragment.this.stopLoading();
            }
        }

        /* compiled from: ClubEventDetailFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$deleteChallenge$1$1", f = "ClubEventDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$deleteChallenge$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02141 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Integer $msgResId;
            int label;
            final /* synthetic */ ClubEventDetailFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02141(ClubEventDetailFragment clubEventDetailFragment, Integer num, Continuation<? super C02141> continuation) {
                super(2, continuation);
                this.this$0 = clubEventDetailFragment;
                this.$msgResId = num;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02141(this.this$0, this.$msgResId, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02141) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ClubEventDetailFragment clubEventDetailFragment = this.this$0;
                CustomDialogKt.showCustomDialog$default(clubEventDetailFragment, null, clubEventDetailFragment.getString(this.$msgResId.intValue()), this.this$0.getString(R.string.confirm), null, null, null, false, 112, null);
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

    static /* synthetic */ void getChallengeDetail$default(ClubEventDetailFragment clubEventDetailFragment, String str, boolean z, int i, Object obj) {
        if ((i & 2) != 0) {
            z = true;
        }
        clubEventDetailFragment.getChallengeDetail(str, z);
    }

    /* compiled from: ClubEventDetailFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$getChallengeDetail$1", f = "ClubEventDetailFragment.kt", i = {}, l = {1045}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$getChallengeDetail$1, reason: invalid class name and case insensitive filesystem */
    static final class C09251 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $challengeUuid;
        final /* synthetic */ boolean $isWithMemberData;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09251(String str, boolean z, Continuation<? super C09251> continuation) {
            super(2, continuation);
            this.$challengeUuid = str;
            this.$isWithMemberData = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubEventDetailFragment.this.new C09251(this.$challengeUuid, this.$isWithMemberData, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09251) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
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
                        ClubEventDetailFragment.this.showLoading();
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
                        ClubEventDetailFragment.this.getClubViewModel().setSelectChallengeData(data);
                    } else if (!Intrinsics.areEqual(errorCode, ErrorCode.NOT_AUTH_TO_PERFORM_THE_OPERATION_1011.getId())) {
                        if (ClubEventDetailFragment.this.shouldIgnoreError(errorCode)) {
                            return Unit.INSTANCE;
                        }
                        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(ErrorCode.DATA_NOT_FOUND_108.getId(), Boxing.boxInt(R.string.err_108_data_not_found)), TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required)), TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), null));
                        GetChallengeDetailApiData.ResponseData responseData4 = (GetChallengeDetailApiData.ResponseData) response.body();
                        Integer num = (Integer) mapMapOf.get(responseData4 != null ? responseData4.getErrorCode() : null);
                        if (num != null) {
                            LifecycleOwner viewLifecycleOwner = ClubEventDetailFragment.this.getViewLifecycleOwner();
                            Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                            BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C02151(ClubEventDetailFragment.this, num, null), 3, null);
                        } else {
                            ClubEventDetailFragment clubEventDetailFragment = ClubEventDetailFragment.this;
                            GetChallengeDetailApiData.ResponseData responseData5 = (GetChallengeDetailApiData.ResponseData) response.body();
                            BaseFragment.handleUndefinedError$default(clubEventDetailFragment, "getChallengeDetail", errorCode, responseData5 != null ? responseData5.getErrorMessage() : null, false, 8, null);
                        }
                    } else {
                        BaseFragment.safeNavigateAndClearStack$default(ClubEventDetailFragment.this, R.id.clubMainFragment, null, 2, null);
                    }
                } catch (IOException e) {
                    Timber.INSTANCE.e(e, "API call failed", new Object[0]);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(ClubEventDetailFragment.this, "getChallengeDetail", message, false, 4, null);
                }
                ClubEventDetailFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                ClubEventDetailFragment.this.stopLoading();
            }
        }

        /* compiled from: ClubEventDetailFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$getChallengeDetail$1$1", f = "ClubEventDetailFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$getChallengeDetail$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02151 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ Integer $msgResId;
            int label;
            final /* synthetic */ ClubEventDetailFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02151(ClubEventDetailFragment clubEventDetailFragment, Integer num, Continuation<? super C02151> continuation) {
                super(2, continuation);
                this.this$0 = clubEventDetailFragment;
                this.$msgResId = num;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02151(this.this$0, this.$msgResId, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02151) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                ClubEventDetailFragment clubEventDetailFragment = this.this$0;
                CustomDialogKt.showCustomDialog$default(clubEventDetailFragment, null, clubEventDetailFragment.getString(this.$msgResId.intValue()), this.this$0.getString(R.string.confirm), null, null, null, false, 112, null);
                return Unit.INSTANCE;
            }
        }
    }

    private final void getChallengeDetail(String challengeUuid, boolean isWithMemberData) {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09251(challengeUuid, isWithMemberData, null), 3, null);
    }

    private final void showVirtualRaceArea(final ChallengeItemFullData item, ChallengeMemberData myData) {
        LinearLayout linearLayout;
        TextView textView;
        FragmentClubEventDetailBinding binding = getBinding();
        if (binding != null && (textView = binding.tvRaceButton) != null) {
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment$$ExternalSyntheticLambda2
                @Override // android.view.View.OnClickListener
                public final void onClick(View view) {
                    ClubEventDetailFragment.showVirtualRaceArea$lambda$35(item, this, view);
                }
            });
        }
        FragmentClubEventDetailBinding binding2 = getBinding();
        LinearLayout linearLayout2 = binding2 != null ? binding2.llVirtualRaceAreaWrap : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(0);
        }
        FragmentClubEventDetailBinding binding3 = getBinding();
        LinearLayout linearLayout3 = binding3 != null ? binding3.llVirtualRaceNotStartYet : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        FragmentClubEventDetailBinding binding4 = getBinding();
        LinearLayout linearLayout4 = binding4 != null ? binding4.llVirtualRaceNotComplete : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        FragmentClubEventDetailBinding binding5 = getBinding();
        LinearLayout linearLayout5 = binding5 != null ? binding5.llVirtualRaceSelfDelete : null;
        if (linearLayout5 != null) {
            linearLayout5.setVisibility(8);
        }
        FragmentClubEventDetailBinding binding6 = getBinding();
        LinearLayout linearLayout6 = binding6 != null ? binding6.llVirtualRaceSingleScore : null;
        if (linearLayout6 != null) {
            linearLayout6.setVisibility(8);
        }
        FragmentClubEventDetailBinding binding7 = getBinding();
        TextView textView2 = binding7 != null ? binding7.tvVrScore : null;
        if (textView2 != null) {
            textView2.setText(ClubOngoingItemAdapterKt.getCurrentScoreVal$default(myData != null ? myData.getCurrentScore() : null, item.getScoreItem(), Integer.valueOf(item.getChallengeType()), false, false, false, 56, null));
        }
        TimeZone timeZone = TimeZone.getDefault();
        Intrinsics.checkNotNullExpressionValue(timeZone, "getDefault(...)");
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null) {
            String countdownToEndLabel = ClubListItemAdapterKt.formatCountdownToEndLabel(mainActivity, item.getEndTimeMillis(), item.getTimeZone(), timeZone, true);
            FragmentClubEventDetailBinding binding8 = getBinding();
            TextView textView3 = binding8 != null ? binding8.tvRaceInfoText : null;
            if (textView3 != null) {
                textView3.setText(getString(R.string.club_race_ongoing_desc, countdownToEndLabel));
            }
        }
        if (myData != null && myData.isPassForVirtualRace()) {
            List<ChallengeMemberData> memberList = item.getMemberList();
            ArrayList arrayList = new ArrayList();
            for (Object obj : memberList) {
                if (((ChallengeMemberData) obj).isPassForVirtualRace()) {
                    arrayList.add(obj);
                }
            }
            if (CollectionsKt.take(arrayList, 2).size() > 1) {
                Timber.INSTANCE.d("VIEW:多位通過 - 顯示rankList", new Object[0]);
                FragmentClubEventDetailBinding binding9 = getBinding();
                linearLayout = binding9 != null ? binding9.llVirtualRaceAreaWrap : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(8);
                }
                showRankArea(item);
                return;
            }
            Timber.INSTANCE.d("VIEW:1位通過", new Object[0]);
            FragmentClubEventDetailBinding binding10 = getBinding();
            linearLayout = binding10 != null ? binding10.llVirtualRaceSingleScore : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        Integer virtualRaceFailReason = myData != null ? myData.getVirtualRaceFailReason() : null;
        int id2 = ChallengeVirtualRaceFailReasonSettings.NOT_START_YET.getId();
        if (virtualRaceFailReason != null && virtualRaceFailReason.intValue() == id2) {
            if (item.getActivityStatus() == ChallengeActivityStatus.FINISHED.getId()) {
                Timber.INSTANCE.d("VIEW: NotComplete", new Object[0]);
                FragmentClubEventDetailBinding binding11 = getBinding();
                linearLayout = binding11 != null ? binding11.llVirtualRaceNotComplete : null;
                if (linearLayout == null) {
                    return;
                }
                linearLayout.setVisibility(0);
                return;
            }
            Timber.INSTANCE.d("VIEW: NotStart", new Object[0]);
            if (item.getActivityStatus() == ChallengeActivityStatus.IN_PROGRESS.getId() || item.getActivityStatus() == ChallengeActivityStatus.IN_PROGRESS_EARLY.getId()) {
                FragmentClubEventDetailBinding binding12 = getBinding();
                linearLayout = binding12 != null ? binding12.llVirtualRaceNotStartYet : null;
                if (linearLayout == null) {
                    return;
                }
                linearLayout.setVisibility(0);
                return;
            }
            return;
        }
        int id3 = ChallengeVirtualRaceFailReasonSettings.USER_DELETE_WORKOUT.getId();
        if (virtualRaceFailReason != null && virtualRaceFailReason.intValue() == id3) {
            Timber.INSTANCE.d("VIEW: SelfDelete", new Object[0]);
            FragmentClubEventDetailBinding binding13 = getBinding();
            linearLayout = binding13 != null ? binding13.llVirtualRaceSelfDelete : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
            return;
        }
        if (virtualRaceFailReason == null) {
            Timber.INSTANCE.d("VIEW: NotStart", new Object[0]);
            FragmentClubEventDetailBinding binding14 = getBinding();
            linearLayout = binding14 != null ? binding14.llVirtualRaceNotStartYet : null;
            if (linearLayout == null) {
                return;
            }
            linearLayout.setVisibility(0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x00d3, code lost:
    
        if (r15 != com.soletreadmills.sole_v2._type.BluetoothConnectType.ROWER) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x00d8, code lost:
    
        if (r15 != com.soletreadmills.sole_v2._type.BluetoothConnectType.ELLIPTICAL) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00dd, code lost:
    
        if (r15 != com.soletreadmills.sole_v2._type.BluetoothConnectType.BIKE) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00e2, code lost:
    
        if (r15 != com.soletreadmills.sole_v2._type.BluetoothConnectType.TREADMILL) goto L58;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00e4, code lost:
    
        com.soletreadmills.sole_v2._extension.CustomDialogKt.showCustomDialog$default(r14, null, r14.getString(com.soletreadmills.sole_v2.R.string.connect_device_not_match), r14.getString(com.soletreadmills.sole_v2.R.string.confirm), null, null, null, false, 112, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00fe, code lost:
    
        return;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00ff, code lost:
    
        com.soletreadmills.sole_v2.ui._base.BaseFragment.safeNavigate$default(r14, com.soletreadmills.sole_v2.R.id.clubRaceFragment, null, 2, null);
     */
    /* JADX WARN: Code restructure failed: missing block: B:61:0x0106, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final void showVirtualRaceArea$lambda$35(com.soletreadmills.sole_v2._data.club.ChallengeItemFullData r13, com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment r14, android.view.View r15) {
        /*
            Method dump skipped, instructions count: 263
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment.showVirtualRaceArea$lambda$35(com.soletreadmills.sole_v2._data.club.ChallengeItemFullData, com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment, android.view.View):void");
    }

    private final void hideVirtualRaceArea() {
        FragmentClubEventDetailBinding binding = getBinding();
        LinearLayout linearLayout = binding != null ? binding.llVirtualRaceAreaWrap : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    /* JADX WARN: Removed duplicated region for block: B:62:0x012f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void showGoalArea(com.soletreadmills.sole_v2._data.club.ChallengeItemFullData r16, com.soletreadmills.sole_v2._data.club.ChallengeMemberData r17) {
        /*
            Method dump skipped, instructions count: 676
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment.showGoalArea(com.soletreadmills.sole_v2._data.club.ChallengeItemFullData, com.soletreadmills.sole_v2._data.club.ChallengeMemberData):void");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showGoalArea$lambda$38(FrameLayout frameLayout, float f, View view) {
        int width = (int) ((frameLayout.getWidth() * f) / 100.0f);
        ViewGroup.LayoutParams layoutParams = view != null ? view.getLayoutParams() : null;
        if (layoutParams != null) {
            layoutParams.width = width;
        }
        if (view == null) {
            return;
        }
        view.setLayoutParams(layoutParams);
    }

    private final void hideGoalArea() {
        FragmentClubEventDetailBinding binding = getBinding();
        LinearLayout linearLayout = binding != null ? binding.llGoalAreaWrap : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    private final void showRankArea(ChallengeItemFullData item) {
        Double currentScore;
        Double currentScore2;
        FragmentClubEventDetailBinding binding = getBinding();
        LinearLayout linearLayout = binding != null ? binding.llRankAreaWrap : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(0);
        }
        List<ChallengeMemberData> rankingList = ClubOngoingItemAdapterKt.getRankingList(item.getMemberList(), Global.getLoginAccountNo());
        FragmentClubEventDetailBinding binding2 = getBinding();
        LinearLayout linearLayout2 = binding2 != null ? binding2.imgRank1Wrap : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        FragmentClubEventDetailBinding binding3 = getBinding();
        LinearLayout linearLayout3 = binding3 != null ? binding3.imgRank2Wrap : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(8);
        }
        FragmentClubEventDetailBinding binding4 = getBinding();
        LinearLayout linearLayout4 = binding4 != null ? binding4.imgRank3Wrap : null;
        if (linearLayout4 != null) {
            linearLayout4.setVisibility(8);
        }
        ChallengeMemberData challengeMemberData = (ChallengeMemberData) CollectionsKt.firstOrNull((List) rankingList);
        double dDoubleValue = AudioStats.AUDIO_AMPLITUDE_NONE;
        double dDoubleValue2 = (challengeMemberData == null || (currentScore2 = challengeMemberData.getCurrentScore()) == null) ? 0.0d : currentScore2.doubleValue();
        ChallengeMemberData challengeMemberData2 = (ChallengeMemberData) CollectionsKt.lastOrNull((List) rankingList);
        if (challengeMemberData2 != null && (currentScore = challengeMemberData2.getCurrentScore()) != null) {
            dDoubleValue = currentScore.doubleValue();
        }
        int i = 0;
        for (Object obj : rankingList) {
            int i2 = i + 1;
            if (i < 0) {
                CollectionsKt.throwIndexOverflow();
            }
            ChallengeMemberData challengeMemberData3 = (ChallengeMemberData) obj;
            if (i == 0) {
                FragmentClubEventDetailBinding binding5 = getBinding();
                LinearLayout linearLayout5 = binding5 != null ? binding5.imgRank1Wrap : null;
                if (linearLayout5 != null) {
                    linearLayout5.setVisibility(0);
                }
                bindRankingItem(challengeMemberData3, 1, dDoubleValue2, dDoubleValue, item.getScoreItem(), item.getChallengeType());
            } else if (i == 1) {
                FragmentClubEventDetailBinding binding6 = getBinding();
                LinearLayout linearLayout6 = binding6 != null ? binding6.imgRank2Wrap : null;
                if (linearLayout6 != null) {
                    linearLayout6.setVisibility(0);
                }
                bindRankingItem(challengeMemberData3, 2, dDoubleValue2, dDoubleValue, item.getScoreItem(), item.getChallengeType());
            } else if (i == 2) {
                FragmentClubEventDetailBinding binding7 = getBinding();
                LinearLayout linearLayout7 = binding7 != null ? binding7.imgRank3Wrap : null;
                if (linearLayout7 != null) {
                    linearLayout7.setVisibility(0);
                }
                bindRankingItem(challengeMemberData3, 3, dDoubleValue2, dDoubleValue, item.getScoreItem(), item.getChallengeType());
            }
            i = i2;
        }
    }

    private final void hideRankArea() {
        FragmentClubEventDetailBinding binding = getBinding();
        LinearLayout linearLayout = binding != null ? binding.llRankAreaWrap : null;
        if (linearLayout == null) {
            return;
        }
        linearLayout.setVisibility(8);
    }

    private final void bindRankingItem(ChallengeMemberData data, int position, double maxScore, double minScore, int scoreItem, int challengeType) {
        ImageView imageView;
        ImageView imageView2;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        TextView textView5;
        TextView textView6;
        MainActivity mainActivity;
        if (position == 1) {
            FragmentClubEventDetailBinding binding = getBinding();
            if (binding != null) {
                imageView = binding.imgRankAvatar1;
                imageView2 = imageView;
            }
            imageView2 = null;
        } else if (position == 2) {
            FragmentClubEventDetailBinding binding2 = getBinding();
            if (binding2 != null) {
                imageView = binding2.imgRankAvatar2;
                imageView2 = imageView;
            }
            imageView2 = null;
        } else {
            if (position != 3) {
                return;
            }
            FragmentClubEventDetailBinding binding3 = getBinding();
            if (binding3 != null) {
                imageView = binding3.imgRankAvatar3;
                imageView2 = imageView;
            }
            imageView2 = null;
        }
        if (position == 1) {
            FragmentClubEventDetailBinding binding4 = getBinding();
            if (binding4 != null) {
                textView = binding4.tvRankVal1;
                textView2 = textView;
            }
            textView2 = null;
        } else if (position == 2) {
            FragmentClubEventDetailBinding binding5 = getBinding();
            if (binding5 != null) {
                textView = binding5.tvRankVal2;
                textView2 = textView;
            }
            textView2 = null;
        } else {
            if (position != 3) {
                return;
            }
            FragmentClubEventDetailBinding binding6 = getBinding();
            if (binding6 != null) {
                textView = binding6.tvRankVal3;
                textView2 = textView;
            }
            textView2 = null;
        }
        if (position == 1) {
            FragmentClubEventDetailBinding binding7 = getBinding();
            if (binding7 != null) {
                textView3 = binding7.tvScore1;
                textView4 = textView3;
            }
            textView4 = null;
        } else if (position == 2) {
            FragmentClubEventDetailBinding binding8 = getBinding();
            if (binding8 != null) {
                textView3 = binding8.tvScore2;
                textView4 = textView3;
            }
            textView4 = null;
        } else {
            if (position != 3) {
                return;
            }
            FragmentClubEventDetailBinding binding9 = getBinding();
            if (binding9 != null) {
                textView3 = binding9.tvScore3;
                textView4 = textView3;
            }
            textView4 = null;
        }
        if (position == 1) {
            FragmentClubEventDetailBinding binding10 = getBinding();
            if (binding10 != null) {
                textView5 = binding10.tvScoreUnit1;
                textView6 = textView5;
            }
            textView6 = null;
        } else if (position == 2) {
            FragmentClubEventDetailBinding binding11 = getBinding();
            if (binding11 != null) {
                textView5 = binding11.tvScoreUnit2;
                textView6 = textView5;
            }
            textView6 = null;
        } else {
            if (position != 3) {
                return;
            }
            FragmentClubEventDetailBinding binding12 = getBinding();
            if (binding12 != null) {
                textView5 = binding12.tvScoreUnit3;
                textView6 = textView5;
            }
            textView6 = null;
        }
        Context context = getContext();
        if (context != null) {
            if (imageView2 != null) {
                Glide.with(context).load(data.getUserSimpleInfo().getPhotoUrl()).placeholder(R.drawable.video_classes).error(R.drawable.video_classes).into(imageView2);
            }
            Double currentScore = data.getCurrentScore();
            double dDoubleValue = currentScore != null ? currentScore.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE;
            if (textView2 != null) {
                textView2.setText("#" + data.getRank());
            }
            if (textView4 != null) {
                textView4.setText(ClubOngoingItemAdapterKt.getCurrentScoreVal$default(Double.valueOf(dDoubleValue), scoreItem, Integer.valueOf(challengeType), false, false, false, 56, null));
            }
            if (textView6 != null) {
                textView6.setText(ClubListItemAdapterKt.getUnitText$default(getActivity(), scoreItem, Global.INSTANCE.getUnitType(), scoreItem > 1, Integer.valueOf(challengeType), false, false, 96, null));
            }
            MainActivity mainActivity2 = getMainActivity();
            if (mainActivity2 != null) {
                MainActivity mainActivity3 = mainActivity2;
                Triple<Integer, Integer, Integer> goalColors = ClubOngoingItemAdapterKt.getGoalColors(mainActivity3, scoreItem, Integer.valueOf(challengeType));
                int iIntValue = goalColors.component1().intValue();
                goalColors.component2().intValue();
                int iIntValue2 = goalColors.component3().intValue();
                if (textView4 != null) {
                    textView4.setTextColor(iIntValue2);
                }
                if (textView6 != null) {
                    textView6.setTextColor(iIntValue2);
                }
                if (textView2 != null) {
                    textView2.setTextColor(ContextCompat.getColor(mainActivity3, R.color.colorLabel_label4));
                }
                if (Intrinsics.areEqual(data.getGlobalUserUuid(), Global.getLoginAccountNo())) {
                    if (textView4 != null) {
                        textView4.setTextColor(iIntValue);
                    }
                    if (textView6 != null) {
                        textView6.setTextColor(iIntValue);
                    }
                    if (textView2 != null) {
                        textView2.setTextColor(ContextCompat.getColor(mainActivity3, R.color.colorLabel_label1));
                    }
                }
            }
            if (ClubScoreboardItemAdapterKt.isNoScoreData(challengeType, data.getRank(), data.getCurrentScore())) {
                if (imageView2 != null && (mainActivity = getMainActivity()) != null) {
                    Glide.with((FragmentActivity) mainActivity).clear(imageView2);
                }
                if (imageView2 != null) {
                    imageView2.setImageDrawable(null);
                }
                MainActivity mainActivity4 = getMainActivity();
                if (mainActivity4 != null && imageView2 != null) {
                    imageView2.setBackgroundColor(ContextCompat.getColor(mainActivity4, R.color.gray_d9d9d9));
                }
                if (textView2 != null) {
                    textView2.setText("#--");
                }
                if (textView4 == null) {
                    return;
                }
                textView4.setText("--");
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x002d  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0056  */
    /* JADX WARN: Removed duplicated region for block: B:44:0x007f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void bindRankingProgressItem(com.soletreadmills.sole_v2._data.club.ChallengeMemberData r13, int r14, double r15, double r17, int r19, int r20) {
        /*
            Method dump skipped, instructions count: 332
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.club.ClubEventDetailFragment.bindRankingProgressItem(com.soletreadmills.sole_v2._data.club.ChallengeMemberData, int, double, double, int, int):void");
    }

    private final String getChallengeScoreItemText(Context context, int scoreItemId) {
        if (scoreItemId == ChallengeScoreItemSettings.TOTAL_TIME.getId()) {
            String string = context.getString(R.string.challenge_time);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (scoreItemId == ChallengeScoreItemSettings.TOTAL_DISTANCE.getId()) {
            String string2 = context.getString(R.string.challenge_distance);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        if (scoreItemId == ChallengeScoreItemSettings.TOTAL_CALORIES.getId()) {
            String string3 = context.getString(R.string.challenge_calories);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        }
        if (scoreItemId == ChallengeScoreItemSettings.SESSION.getId()) {
            String string4 = context.getString(R.string.challenge_sessions);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            return string4;
        }
        String string5 = context.getString(R.string.challenge_time);
        Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
        return string5;
    }

    private final String getChallengeTypeText(Context context, int scoreItem, int challengeTypeId) {
        if (challengeTypeId == ChallengeTypeSettings.RANKING.getId()) {
            StringBuilder sb = new StringBuilder();
            MainActivity mainActivity = getMainActivity();
            return sb.append(mainActivity != null ? getChallengeScoreItemText(mainActivity, scoreItem) : null).append(' ').append(context.getString(R.string.challenge_format_ranking)).toString();
        }
        if (challengeTypeId == ChallengeTypeSettings.GOAL.getId()) {
            StringBuilder sb2 = new StringBuilder();
            MainActivity mainActivity2 = getMainActivity();
            return sb2.append(mainActivity2 != null ? getChallengeScoreItemText(mainActivity2, scoreItem) : null).append(' ').append(context.getString(R.string.challenge_format_goal)).toString();
        }
        if (challengeTypeId == ChallengeTypeSettings.VIRTUAL_RACE.getId()) {
            String string = context.getString(R.string.virtual_race);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        StringBuilder sb3 = new StringBuilder();
        MainActivity mainActivity3 = getMainActivity();
        return sb3.append(mainActivity3 != null ? getChallengeScoreItemText(mainActivity3, scoreItem) : null).append(' ').append(context.getString(R.string.challenge_format_ranking)).toString();
    }

    private final String getChallengePrivacyText(Context context, int privacyId) {
        if (privacyId == ChallengePrivacyLevelSettings.PUBLIC.getId()) {
            String string = context.getString(R.string.challenge_privacy_public);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (privacyId == ChallengePrivacyLevelSettings.PRIVATE.getId()) {
            String string2 = context.getString(R.string.challenge_privacy_private);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        String string3 = context.getString(R.string.challenge_privacy_public);
        Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
        return string3;
    }

    private final String getChallengeStatusText(Context context, int statusId) {
        if (statusId == ChallengeActivityStatus.READY.getId()) {
            String string = context.getString(R.string.challenge_status_upcoming);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            return string;
        }
        if (statusId == ChallengeActivityStatus.IN_PROGRESS_EARLY.getId()) {
            String string2 = context.getString(R.string.challenge_status_ongoing);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
            return string2;
        }
        if (statusId == ChallengeActivityStatus.IN_PROGRESS.getId()) {
            String string3 = context.getString(R.string.challenge_status_ongoing);
            Intrinsics.checkNotNullExpressionValue(string3, "getString(...)");
            return string3;
        }
        if (statusId == ChallengeActivityStatus.FINISHED.getId()) {
            String string4 = context.getString(R.string.challenge_status_finished);
            Intrinsics.checkNotNullExpressionValue(string4, "getString(...)");
            return string4;
        }
        if (statusId == ChallengeActivityStatus.CANCELLED.getId()) {
            String string5 = context.getString(R.string.challenge_status_canceled);
            Intrinsics.checkNotNullExpressionValue(string5, "getString(...)");
            return string5;
        }
        return "";
    }

    private final void shareMessage(Context context) {
        String challengeName;
        String passCode;
        ChallengeItemFullData value = getClubViewModel().getSelectedChallengeData().getValue();
        boolean z = false;
        if (value != null && value.getPrivacyLevel() == ChallengePrivacyLevelSettings.PRIVATE.getId()) {
            z = true;
        }
        ChallengeItemFullData value2 = getClubViewModel().getSelectedChallengeData().getValue();
        String str = "";
        if (value2 == null || (challengeName = value2.getChallengeName()) == null) {
            challengeName = "";
        }
        String string = context.getString(R.string.tx_challenge_join_public_event, challengeName);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        if (z) {
            ChallengeItemFullData value3 = getClubViewModel().getSelectedChallengeData().getValue();
            if (value3 != null && (passCode = value3.getPassCode()) != null) {
                str = passCode;
            }
            string = context.getString(R.string.tx_challenge_join_privacy_event, str);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        }
        Intent intent = new Intent();
        intent.setAction("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.TEXT", string);
        intent.setType("text/plain");
        ContextCompat.startActivity(context, Intent.createChooser(intent, context.getString(R.string.tx_challenge_share_title)), null);
    }
}
