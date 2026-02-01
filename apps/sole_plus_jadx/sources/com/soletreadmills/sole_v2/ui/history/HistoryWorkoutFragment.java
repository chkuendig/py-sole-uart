package com.soletreadmills.sole_v2.ui.history;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.widget.Toolbar;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.SdkConstants;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.samsung.android.sdk.healthdata.HealthConstants;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.SrvoRefDataVo;
import com.soletreadmills.sole_v2._data.UserPersonalBestVoData;
import com.soletreadmills.sole_v2._data.VideoRefDataVo;
import com.soletreadmills.sole_v2._data.WorkoutRawData4WorkoutDetailDisplay;
import com.soletreadmills.sole_v2._data.WorkoutViewVo;
import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._data.api.history.DeleteWorkoutApiData;
import com.soletreadmills.sole_v2._data.api.history.StravaShareHistoryApiData;
import com.soletreadmills.sole_v2._data.history.ChartData;
import com.soletreadmills.sole_v2._data.history.WorkoutInfoItem;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._extension.TextViewExtensionsKt;
import com.soletreadmills.sole_v2._helper.HistoryHelper;
import com.soletreadmills.sole_v2._helper.customChart.CustomChartHelper;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2._manager.StravaManager;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2._tools.ConvertUtils;
import com.soletreadmills.sole_v2._tools.TimeTools;
import com.soletreadmills.sole_v2._tools.UnitConversion;
import com.soletreadmills.sole_v2._type.BluetoothConnectType;
import com.soletreadmills.sole_v2._type.HistoryActivityType;
import com.soletreadmills.sole_v2._type.PersonalBestType;
import com.soletreadmills.sole_v2.databinding.CustomHistoryWorkoutChartItemBinding;
import com.soletreadmills.sole_v2.databinding.CustomHistoryWorkoutItemBinding;
import com.soletreadmills.sole_v2.databinding.FragmentHistoryWorkoutBinding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.activity.ActivityViewModel;
import com.soletreadmills.sole_v2.ui.adapter.history.HistoryWorkoutAdapter;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Pair;
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
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: HistoryWorkoutFragment.kt */
@Metadata(d1 = {"\u0000\u008c\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b3\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001zB\u0005¢\u0006\u0002\u0010\u0004Jo\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u00172\u0006\u0010 \u001a\u00020\f2\u0006\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\b\u0010&\u001a\u0004\u0018\u00010%2\b\u0010'\u001a\u0004\u0018\u00010%2\b\u0010(\u001a\u0004\u0018\u00010)2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0$2\u0006\u0010,\u001a\u00020-H\u0003¢\u0006\u0002\u0010.J \u0010/\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u00172\u0006\u00100\u001a\u00020\u00172\u0006\u0010\u001f\u001a\u00020\u0017H\u0002J\u0010\u00101\u001a\u00020\u001d2\u0006\u00102\u001a\u00020\fH\u0002J$\u00103\u001a\b\u0012\u0004\u0012\u00020%0$2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020%0$2\b\b\u0002\u00104\u001a\u00020\fJ\u0017\u00105\u001a\u0002062\b\u00107\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u00108J\u0017\u00109\u001a\u0002062\b\u0010:\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010;J\u001f\u0010<\u001a\u0002062\b\u0010=\u001a\u0004\u0018\u00010)2\u0006\u0010>\u001a\u00020-H\u0002¢\u0006\u0002\u0010?J\u0017\u0010@\u001a\u0002062\b\u0010A\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u00108J\u0017\u0010B\u001a\u0002062\b\u0010C\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u00108J\u0017\u0010D\u001a\u0002062\b\u0010E\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u00108J\u0017\u0010F\u001a\u0002062\b\u0010G\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u00108J\u0017\u0010H\u001a\u0002062\b\u0010G\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u00108J\u0017\u0010I\u001a\u0002062\b\u0010J\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u00108J\u0017\u0010K\u001a\u0002062\b\u0010L\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010;J\u0017\u0010M\u001a\u0002062\b\u0010N\u001a\u0004\u0018\u00010)H\u0002¢\u0006\u0002\u00108J\u0017\u0010O\u001a\u0002062\b\u0010P\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010;J\u0017\u0010Q\u001a\u0002062\b\u0010R\u001a\u0004\u0018\u00010\fH\u0002¢\u0006\u0002\u0010;J\u000e\u0010S\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017J\u000e\u0010T\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017J\u001c\u0010U\u001a\b\u0012\u0004\u0012\u00020%0$2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0$H\u0002J\u001c\u0010V\u001a\b\u0012\u0004\u0012\u00020%0$2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0$H\u0002J\u001c\u0010W\u001a\b\u0012\u0004\u0012\u00020%0$2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0$H\u0002J\u001c\u0010X\u001a\b\u0012\u0004\u0012\u00020%0$2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0$H\u0002J\u001a\u0010Y\u001a\b\u0012\u0004\u0012\u00020%0$2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0$J\u001c\u0010Z\u001a\b\u0012\u0004\u0012\u00020%0$2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0$H\u0002J\u001c\u0010[\u001a\b\u0012\u0004\u0012\u00020%0$2\f\u0010*\u001a\b\u0012\u0004\u0012\u00020+0$H\u0002J\u0016\u0010\\\u001a\b\u0012\u0004\u0012\u0002060$2\u0006\u0010!\u001a\u00020\"H\u0002J\u0016\u0010]\u001a\b\u0012\u0004\u0012\u0002060$2\u0006\u0010!\u001a\u00020\"H\u0002J\u0016\u0010^\u001a\b\u0012\u0004\u0012\u0002060$2\u0006\u0010!\u001a\u00020\"H\u0002J\u0016\u0010_\u001a\b\u0012\u0004\u0012\u0002060$2\u0006\u0010!\u001a\u00020\"H\u0002J\u0016\u0010`\u001a\b\u0012\u0004\u0012\u0002060$2\u0006\u0010!\u001a\u00020\"H\u0002J\u0016\u0010a\u001a\b\u0012\u0004\u0012\u0002060$2\u0006\u0010!\u001a\u00020\"H\u0002J\u0016\u0010b\u001a\b\u0012\u0004\u0012\u0002060$2\u0006\u0010!\u001a\u00020\"H\u0002J\u0016\u0010c\u001a\b\u0012\u0004\u0012\u0002060$2\u0006\u0010!\u001a\u00020\"H\u0002J\u0006\u0010d\u001a\u00020\u001dJ\u0016\u0010e\u001a\b\u0012\u0004\u0012\u0002060$2\u0006\u0010!\u001a\u00020\"H\u0002J\u001e\u0010f\u001a\u00020%2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020%0$2\u0006\u0010g\u001a\u00020%H\u0002J\u001a\u0010h\u001a\u00020\u00022\u0006\u0010i\u001a\u00020j2\b\u0010k\u001a\u0004\u0018\u00010lH\u0016J\b\u0010m\u001a\u00020\u001dH\u0016J\u0012\u0010n\u001a\u00020\u001d2\b\u0010o\u001a\u0004\u0018\u00010pH\u0016J\u0012\u0010q\u001a\u00020\u001d2\b\u0010r\u001a\u0004\u0018\u00010sH\u0016J\u001c\u0010t\u001a\u00020\u001d2\f\u0010u\u001a\b\u0012\u0004\u0012\u00020\f0$2\u0006\u0010>\u001a\u00020-J\u0010\u0010v\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0007J\u0010\u0010w\u001a\u00020\u001d2\u0006\u0010!\u001a\u00020\"H\u0002J\u0010\u0010x\u001a\u00020\u001d2\u0006\u0010y\u001a\u00020%H\u0002R\u001b\u0010\u0005\u001a\u00020\u00068FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u00020\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006{"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/history/HistoryWorkoutFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentHistoryWorkoutBinding;", "Landroid/view/View$OnClickListener;", "()V", "activityViewModel", "Lcom/soletreadmills/sole_v2/ui/activity/ActivityViewModel;", "getActivityViewModel", "()Lcom/soletreadmills/sole_v2/ui/activity/ActivityViewModel;", "activityViewModel$delegate", "Lkotlin/Lazy;", "currentCollapseMode", "", "isBest", "", "()Z", "setBest", "(Z)V", "isHide", "setHide", "syncManager", "Lcom/soletreadmills/sole_v2/_helper/customChart/CustomChartHelper$SyncManager;", "workoutUuid", "", "getWorkoutUuid", "()Ljava/lang/String;", "setWorkoutUuid", "(Ljava/lang/String;)V", "addChartView", "", "titleRes", "unitRes", "color", "data", "Lcom/soletreadmills/sole_v2/_data/WorkoutViewVo;", "dataArray", "", "", "max", HealthConstants.HeartRate.MIN, "avg", "", "rawDataList", "Lcom/soletreadmills/sole_v2/_data/WorkoutRawData4WorkoutDetailDisplay;", "historyActivityType", "Lcom/soletreadmills/sole_v2/_type/HistoryActivityType;", "(Ljava/lang/String;Ljava/lang/String;ILcom/soletreadmills/sole_v2/_data/WorkoutViewVo;Ljava/util/List;Ljava/lang/Float;Ljava/lang/Float;Ljava/lang/Double;Ljava/util/List;Lcom/soletreadmills/sole_v2/_type/HistoryActivityType;)V", "addWorkoutInfoView", "value", "changeCollapseMode", "collapseMode", "compressByMinMax", "targetSize", "createAscentItem", "Lcom/soletreadmills/sole_v2/_data/history/WorkoutInfoItem;", "elevation", "(Ljava/lang/Double;)Lcom/soletreadmills/sole_v2/_data/history/WorkoutInfoItem;", "createCaloriesItem", "calories", "(Ljava/lang/Integer;)Lcom/soletreadmills/sole_v2/_data/history/WorkoutInfoItem;", "createDistanceItem", "distance", "rootHistoryActivityType", "(Ljava/lang/Double;Lcom/soletreadmills/sole_v2/_type/HistoryActivityType;)Lcom/soletreadmills/sole_v2/_data/history/WorkoutInfoItem;", "createInclineItem", "incline", "createMetsItem", "mets", "createOutputItem", "watt", "createPaceItem", "pace", "createRowerPaceItem", "createSpeedItem", "speed", "createTimeItem", "totalTime", "createTotalLoadItem", "kg", "createTotalRepsItem", "reps", "createTotalSetsItem", "sets", "deleteWorkout", "exportToStrava", "extractHeartRateList", "extractInclineList", "extractResistanceList", "extractRpmList", "extractSpeedList", "extractSpmRowerList", "extractSpmStepperList", "getBikeInfo", "getDefaultInfo", "getEllipticalInfo", "getFullSweatInfo", "getRowingInfo", "getSrvoInfo", "getStepperInfo", "getTreadmillInfo", "getUserWorkoutContentApi", "getWalkingInfo", "getYValueAtProgress", "progress", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "setPaceRecyclerView", "list", "setView", "setupWorkoutInfo", "updateAllChartChildViews", "newProgress", "ChartItemInfo", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class HistoryWorkoutFragment extends BaseFragment<FragmentHistoryWorkoutBinding> implements View.OnClickListener {
    public static final int $stable = 8;

    /* renamed from: activityViewModel$delegate, reason: from kotlin metadata */
    private final Lazy activityViewModel;
    private boolean isBest;
    private int currentCollapseMode = 2;
    private String workoutUuid = "";
    private boolean isHide = true;
    private final CustomChartHelper.SyncManager syncManager = new CustomChartHelper.SyncManager();

    /* compiled from: HistoryWorkoutFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HistoryActivityType.values().length];
            try {
                iArr[HistoryActivityType.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HistoryActivityType.CYCLING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HistoryActivityType.STAIR_CLIMBING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HistoryActivityType.ROWING.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[HistoryActivityType.ELLIPTICAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[HistoryActivityType.WALKING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[HistoryActivityType.WALKING_AND_HIKING.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[HistoryActivityType.STRENGTH_AND_FUNCTION.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public HistoryWorkoutFragment() {
        final HistoryWorkoutFragment historyWorkoutFragment = this;
        final Function0 function0 = null;
        this.activityViewModel = FragmentViewModelLazyKt.createViewModelLazy(historyWorkoutFragment, Reflection.getOrCreateKotlinClass(ActivityViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = historyWorkoutFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = historyWorkoutFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = historyWorkoutFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public final ActivityViewModel getActivityViewModel() {
        return (ActivityViewModel) this.activityViewModel.getValue();
    }

    /* renamed from: isBest, reason: from getter */
    public final boolean getIsBest() {
        return this.isBest;
    }

    public final void setBest(boolean z) {
        this.isBest = z;
    }

    public final String getWorkoutUuid() {
        return this.workoutUuid;
    }

    public final void setWorkoutUuid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.workoutUuid = str;
    }

    /* renamed from: isHide, reason: from getter */
    public final boolean getIsHide() {
        return this.isHide;
    }

    public final void setHide(boolean z) {
        this.isHide = z;
    }

    /* compiled from: HistoryWorkoutFragment.kt */
    @Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\u0002\u0010\tJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0010J\u000f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0003JB\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\bHÆ\u0001¢\u0006\u0002\u0010\u0018J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\t\u0010\u001e\u001a\u00020\u001fHÖ\u0001R\u0015\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00050\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u000f\u0010\u0010R\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\u0011\u001a\u0004\b\u0012\u0010\u0010¨\u0006 "}, d2 = {"Lcom/soletreadmills/sole_v2/ui/history/HistoryWorkoutFragment$ChartItemInfo;", "", "avg", "", "max", "", HealthConstants.HeartRate.MIN, "dataArray", "", "(Ljava/lang/Double;Ljava/lang/Float;Ljava/lang/Float;Ljava/util/List;)V", "getAvg", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getDataArray", "()Ljava/util/List;", "getMax", "()Ljava/lang/Float;", "Ljava/lang/Float;", "getMin", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/Double;Ljava/lang/Float;Ljava/lang/Float;Ljava/util/List;)Lcom/soletreadmills/sole_v2/ui/history/HistoryWorkoutFragment$ChartItemInfo;", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ChartItemInfo {
        public static final int $stable = 8;
        private final Double avg;
        private final List<Float> dataArray;
        private final Float max;
        private final Float min;

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ ChartItemInfo copy$default(ChartItemInfo chartItemInfo, Double d, Float f, Float f2, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                d = chartItemInfo.avg;
            }
            if ((i & 2) != 0) {
                f = chartItemInfo.max;
            }
            if ((i & 4) != 0) {
                f2 = chartItemInfo.min;
            }
            if ((i & 8) != 0) {
                list = chartItemInfo.dataArray;
            }
            return chartItemInfo.copy(d, f, f2, list);
        }

        /* renamed from: component1, reason: from getter */
        public final Double getAvg() {
            return this.avg;
        }

        /* renamed from: component2, reason: from getter */
        public final Float getMax() {
            return this.max;
        }

        /* renamed from: component3, reason: from getter */
        public final Float getMin() {
            return this.min;
        }

        public final List<Float> component4() {
            return this.dataArray;
        }

        public final ChartItemInfo copy(Double avg, Float max, Float min, List<Float> dataArray) {
            Intrinsics.checkNotNullParameter(dataArray, "dataArray");
            return new ChartItemInfo(avg, max, min, dataArray);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ChartItemInfo)) {
                return false;
            }
            ChartItemInfo chartItemInfo = (ChartItemInfo) other;
            return Intrinsics.areEqual((Object) this.avg, (Object) chartItemInfo.avg) && Intrinsics.areEqual((Object) this.max, (Object) chartItemInfo.max) && Intrinsics.areEqual((Object) this.min, (Object) chartItemInfo.min) && Intrinsics.areEqual(this.dataArray, chartItemInfo.dataArray);
        }

        public int hashCode() {
            Double d = this.avg;
            int iHashCode = (d == null ? 0 : d.hashCode()) * 31;
            Float f = this.max;
            int iHashCode2 = (iHashCode + (f == null ? 0 : f.hashCode())) * 31;
            Float f2 = this.min;
            return ((iHashCode2 + (f2 != null ? f2.hashCode() : 0)) * 31) + this.dataArray.hashCode();
        }

        public String toString() {
            return "ChartItemInfo(avg=" + this.avg + ", max=" + this.max + ", min=" + this.min + ", dataArray=" + this.dataArray + ')';
        }

        public ChartItemInfo(Double d, Float f, Float f2, List<Float> dataArray) {
            Intrinsics.checkNotNullParameter(dataArray, "dataArray");
            this.avg = d;
            this.max = f;
            this.min = f2;
            this.dataArray = dataArray;
        }

        public final Double getAvg() {
            return this.avg;
        }

        public final Float getMax() {
            return this.max;
        }

        public final Float getMin() {
            return this.min;
        }

        public final List<Float> getDataArray() {
            return this.dataArray;
        }
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentHistoryWorkoutBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentHistoryWorkoutBinding fragmentHistoryWorkoutBindingInflate = FragmentHistoryWorkoutBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentHistoryWorkoutBindingInflate, "inflate(...)");
        return fragmentHistoryWorkoutBindingInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        if (arguments != null) {
            String string = arguments.getString("workoutUuid");
            if (string == null) {
                string = "";
            } else {
                Intrinsics.checkNotNull(string);
            }
            this.workoutUuid = string;
            this.isBest = arguments.getBoolean("isBest");
        }
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        TextView textView;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        ImageView imageView;
        ImageView imageView2;
        ImageView imageView3;
        AppBarLayout appBarLayout;
        FragmentHistoryWorkoutBinding binding = getBinding();
        if (binding != null && (appBarLayout = binding.appBarLayout) != null) {
            appBarLayout.addOnOffsetChangedListener(new AppBarLayout.OnOffsetChangedListener() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment$$ExternalSyntheticLambda0
                @Override // com.google.android.material.appbar.AppBarLayout.OnOffsetChangedListener, com.google.android.material.appbar.AppBarLayout.BaseOnOffsetChangedListener
                public final void onOffsetChanged(AppBarLayout appBarLayout2, int i) {
                    HistoryWorkoutFragment.initViews$lambda$1(this.f$0, appBarLayout2, i);
                }
            });
        }
        FragmentHistoryWorkoutBinding binding2 = getBinding();
        if (binding2 != null && (imageView3 = binding2.back) != null) {
            imageView3.setOnClickListener(this);
        }
        FragmentHistoryWorkoutBinding binding3 = getBinding();
        if (binding3 != null && (imageView2 = binding3.imgDelete) != null) {
            imageView2.setOnClickListener(this);
        }
        FragmentHistoryWorkoutBinding binding4 = getBinding();
        if (binding4 != null && (imageView = binding4.imgBack) != null) {
            imageView.setOnClickListener(this);
        }
        FragmentHistoryWorkoutBinding binding5 = getBinding();
        if (binding5 != null && (linearLayout2 = binding5.LLRematch) != null) {
            linearLayout2.setOnClickListener(this);
        }
        FragmentHistoryWorkoutBinding binding6 = getBinding();
        if (binding6 != null && (linearLayout = binding6.LLShare) != null) {
            linearLayout.setOnClickListener(this);
        }
        if (this.isBest) {
            FragmentHistoryWorkoutBinding binding7 = getBinding();
            Toolbar toolbar = binding7 != null ? binding7.collapsingToolbar : null;
            if (toolbar != null) {
                toolbar.setVisibility(8);
            }
            FragmentHistoryWorkoutBinding binding8 = getBinding();
            ConstraintLayout constraintLayout = binding8 != null ? binding8.CLIsBest : null;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(0);
            }
            FragmentHistoryWorkoutBinding binding9 = getBinding();
            LinearLayout linearLayout3 = binding9 != null ? binding9.LLRematch : null;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
            FragmentHistoryWorkoutBinding binding10 = getBinding();
            View view = binding10 != null ? binding10.space2 : null;
            if (view != null) {
                view.setVisibility(0);
            }
            FragmentHistoryWorkoutBinding binding11 = getBinding();
            View view2 = binding11 != null ? binding11.space1 : null;
            if (view2 != null) {
                view2.setVisibility(8);
            }
            FragmentHistoryWorkoutBinding binding12 = getBinding();
            textView = binding12 != null ? binding12.tvShare : null;
            if (textView != null) {
                textView.setVisibility(8);
            }
        } else {
            FragmentHistoryWorkoutBinding binding13 = getBinding();
            Toolbar toolbar2 = binding13 != null ? binding13.collapsingToolbar : null;
            if (toolbar2 != null) {
                toolbar2.setVisibility(0);
            }
            FragmentHistoryWorkoutBinding binding14 = getBinding();
            ConstraintLayout constraintLayout2 = binding14 != null ? binding14.CLIsBest : null;
            if (constraintLayout2 != null) {
                constraintLayout2.setVisibility(8);
            }
            FragmentHistoryWorkoutBinding binding15 = getBinding();
            LinearLayout linearLayout4 = binding15 != null ? binding15.LLRematch : null;
            if (linearLayout4 != null) {
                linearLayout4.setVisibility(8);
            }
            FragmentHistoryWorkoutBinding binding16 = getBinding();
            View view3 = binding16 != null ? binding16.space2 : null;
            if (view3 != null) {
                view3.setVisibility(8);
            }
            FragmentHistoryWorkoutBinding binding17 = getBinding();
            View view4 = binding17 != null ? binding17.space1 : null;
            if (view4 != null) {
                view4.setVisibility(0);
            }
            FragmentHistoryWorkoutBinding binding18 = getBinding();
            textView = binding18 != null ? binding18.tvShare : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
        }
        getUserWorkoutContentApi();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void initViews$lambda$1(HistoryWorkoutFragment this$0, AppBarLayout appBarLayout, int i) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        int i2 = ((float) Math.abs(i)) / ((float) appBarLayout.getTotalScrollRange()) >= 0.8f ? 1 : 2;
        if (this$0.currentCollapseMode != i2) {
            this$0.changeCollapseMode(i2);
            this$0.currentCollapseMode = i2;
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Context context;
        FragmentHistoryWorkoutBinding binding;
        BleManager bleManager;
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.back;
        if (numValueOf != null && numValueOf.intValue() == i) {
            safeNavigateUp();
            return;
        }
        int i2 = R.id.img_back;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            safeNavigateUp();
            return;
        }
        int i3 = R.id.img_delete;
        if (numValueOf != null && numValueOf.intValue() == i3) {
            CustomDialogKt.showCustomDialog$default(this, getString(R.string.delete_workout), getString(R.string.hint_27), getString(R.string.delete), getString(R.string.cancel), new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment.onClick.1
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
                    HistoryWorkoutFragment historyWorkoutFragment = HistoryWorkoutFragment.this;
                    historyWorkoutFragment.deleteWorkout(historyWorkoutFragment.getWorkoutUuid());
                }
            }, null, false, 96, null);
            return;
        }
        int i4 = R.id.LL_rematch;
        if (numValueOf != null && numValueOf.intValue() == i4) {
            MainActivity mainActivity = getMainActivity();
            if (mainActivity != null && (bleManager = mainActivity.getBleManager()) != null && !bleManager.isConnectedFtms()) {
                MainActivity mainActivity2 = getMainActivity();
                BleManager bleManager2 = mainActivity2 != null ? mainActivity2.getBleManager() : null;
                if (bleManager2 != null) {
                    bleManager2.setBluetoothConnectType(BluetoothConnectType.MACHINE);
                }
                Bundle bundle = new Bundle();
                bundle.putString("type", "Rematch");
                bundle.putString("deviceType", "MACHINE");
                safeNavigate(R.id.connectDeviceFragment, bundle);
                return;
            }
            BaseFragment.safeNavigate$default(this, R.id.rematchFragment, null, 2, null);
            return;
        }
        int i5 = R.id.LL_share;
        if (numValueOf == null || numValueOf.intValue() != i5 || (context = getContext()) == null || (binding = getBinding()) == null) {
            return;
        }
        List<Pair<String, Integer>> listListOf = CollectionsKt.listOf(TuplesKt.to(getString(R.string.strava), Integer.valueOf(R.drawable.ic_m__share)));
        LinearLayout LLShare = binding.LLShare;
        Intrinsics.checkNotNullExpressionValue(LLShare, "LLShare");
        showSharePopupWithCustomLayout(context, LLShare, listListOf, new Function1<Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment$onClick$2$1$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                invoke(num.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(int i6) {
                if (i6 == 0 && this.this$0.getActivityViewModel().getWorkoutData() != null) {
                    HistoryWorkoutFragment historyWorkoutFragment = this.this$0;
                    historyWorkoutFragment.exportToStrava(historyWorkoutFragment.getWorkoutUuid());
                }
            }
        });
    }

    private final void changeCollapseMode(int collapseMode) {
        Toolbar toolbar;
        FragmentHistoryWorkoutBinding binding = getBinding();
        ViewGroup.LayoutParams layoutParams = (binding == null || (toolbar = binding.collapsingToolbar) == null) ? null : toolbar.getLayoutParams();
        Intrinsics.checkNotNull(layoutParams, "null cannot be cast to non-null type com.google.android.material.appbar.CollapsingToolbarLayout.LayoutParams");
        CollapsingToolbarLayout.LayoutParams layoutParams2 = (CollapsingToolbarLayout.LayoutParams) layoutParams;
        layoutParams2.setCollapseMode(collapseMode);
        FragmentHistoryWorkoutBinding binding2 = getBinding();
        Toolbar toolbar2 = binding2 != null ? binding2.collapsingToolbar : null;
        if (toolbar2 != null) {
            toolbar2.setLayoutParams(layoutParams2);
        }
        if (collapseMode == 1) {
            FragmentHistoryWorkoutBinding binding3 = getBinding();
            Toolbar toolbar3 = binding3 != null ? binding3.collapsingToolbar : null;
            if (toolbar3 != null) {
                toolbar3.setVisibility(0);
            }
            FragmentHistoryWorkoutBinding binding4 = getBinding();
            TextView textView = binding4 != null ? binding4.title : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(0);
            return;
        }
        FragmentHistoryWorkoutBinding binding5 = getBinding();
        TextView textView2 = binding5 != null ? binding5.title : null;
        if (textView2 != null) {
            textView2.setVisibility(8);
        }
        if (this.isBest) {
            FragmentHistoryWorkoutBinding binding6 = getBinding();
            Toolbar toolbar4 = binding6 != null ? binding6.collapsingToolbar : null;
            if (toolbar4 == null) {
                return;
            }
            toolbar4.setVisibility(8);
            return;
        }
        FragmentHistoryWorkoutBinding binding7 = getBinding();
        Toolbar toolbar5 = binding7 != null ? binding7.collapsingToolbar : null;
        if (toolbar5 == null) {
            return;
        }
        toolbar5.setVisibility(0);
    }

    public final void setView(final WorkoutViewVo data) {
        LinearLayout linearLayout;
        List<WorkoutRawData4WorkoutDetailDisplay> listEmptyList;
        String str;
        Float f;
        Float f2;
        int i;
        TextView textView;
        UserPersonalBestVoData userPersonalBestVoData;
        ImageView imageView;
        Object next;
        Intrinsics.checkNotNullParameter(data, "data");
        Context context = getContext();
        if (context == null) {
            return;
        }
        boolean unitType = Global.INSTANCE.getUnitType();
        if (this.isBest) {
            List<UserPersonalBestVoData> userPersonalBestVoDataValue = getActivityViewModel().getUserPersonalBestVoDataValue();
            if (userPersonalBestVoDataValue != null) {
                Iterator<T> it = userPersonalBestVoDataValue.iterator();
                while (true) {
                    if (it.hasNext()) {
                        next = it.next();
                        if (Intrinsics.areEqual(((UserPersonalBestVoData) next).getCurrentBestUserWorkoutUuid(), this.workoutUuid)) {
                            break;
                        }
                    } else {
                        next = null;
                        break;
                    }
                }
                userPersonalBestVoData = (UserPersonalBestVoData) next;
            } else {
                userPersonalBestVoData = null;
            }
            PersonalBestType personalBestItem = userPersonalBestVoData != null ? userPersonalBestVoData.getPersonalBestItem() : null;
            if (personalBestItem != null) {
                FragmentHistoryWorkoutBinding binding = getBinding();
                if (binding != null && (imageView = binding.imgBest) != null) {
                    imageView.setImageResource(personalBestItem.getBackground());
                }
                FragmentHistoryWorkoutBinding binding2 = getBinding();
                TextView textView2 = binding2 != null ? binding2.tvTitle : null;
                if (textView2 != null) {
                    textView2.setText(getString(personalBestItem.getTitleResId()));
                }
                FragmentHistoryWorkoutBinding binding3 = getBinding();
                TextView textView3 = binding3 != null ? binding3.tvTitleDate : null;
                if (textView3 != null) {
                    textView3.setText(userPersonalBestVoData.getAchieveDate());
                }
            }
        }
        FragmentHistoryWorkoutBinding binding4 = getBinding();
        TextView textView4 = binding4 != null ? binding4.txtDate : null;
        if (textView4 != null) {
            textView4.setText(TimeTools.INSTANCE.formatDate(data.getStartTime()));
        }
        String toTime02 = TimeTools.INSTANCE.formatToTime02(data.getStartTime());
        String toTime022 = TimeTools.INSTANCE.formatToTime02(data.getEndTime());
        FragmentHistoryWorkoutBinding binding5 = getBinding();
        TextView textView5 = binding5 != null ? binding5.time : null;
        if (textView5 != null) {
            textView5.setText(toTime02 + " —\n" + toTime022);
        }
        String string = getString(R.string.free_workout);
        String str2 = "getString(...)";
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        VideoRefDataVo videoRefData = data.getVideoRefData();
        if ((videoRefData != null ? videoRefData.getClassName() : null) != null) {
            String className = data.getVideoRefData().getClassName();
            FragmentHistoryWorkoutBinding binding6 = getBinding();
            TextView textView6 = binding6 != null ? binding6.workoutName : null;
            if (textView6 != null) {
                textView6.setText(className);
            }
            FragmentHistoryWorkoutBinding binding7 = getBinding();
            if (binding7 != null && (textView = binding7.workoutName) != null) {
                TextViewExtensionsKt.setRedUnderlineClickable(textView, className, new Function1<Context, Unit>() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment.setView.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ Unit invoke(Context context2) {
                        invoke2(context2);
                        return Unit.INSTANCE;
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Context it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        if (data.getVideoRefData().getClassId() == null) {
                            return;
                        }
                        Bundle bundle = new Bundle();
                        bundle.putString("classID", data.getVideoRefData().getClassId());
                        this.safeNavigate(R.id.classesDetailFragment, bundle);
                    }
                });
            }
        } else {
            SrvoRefDataVo srvoRefData = data.getSrvoRefData();
            if ((srvoRefData != null ? srvoRefData.getSrvoName() : null) != null) {
                String srvoName = data.getSrvoRefData().getSrvoName();
                FragmentHistoryWorkoutBinding binding8 = getBinding();
                TextView textView7 = binding8 != null ? binding8.workoutName : null;
                if (textView7 != null) {
                    textView7.setText(srvoName);
                }
            } else {
                String programName = data.getProgramName();
                if (programName != null && programName.length() != 0) {
                    String programName2 = data.getProgramName();
                    FragmentHistoryWorkoutBinding binding9 = getBinding();
                    TextView textView8 = binding9 != null ? binding9.workoutName : null;
                    if (textView8 != null) {
                        textView8.setText(programName2);
                    }
                } else {
                    FragmentHistoryWorkoutBinding binding10 = getBinding();
                    TextView textView9 = binding10 != null ? binding10.workoutName : null;
                    if (textView9 != null) {
                        textView9.setText(string);
                    }
                }
            }
        }
        String str3 = HistoryHelper.INSTANCE.getCategoryType(context, data) + ' ' + getString(R.string.workout);
        FragmentHistoryWorkoutBinding binding11 = getBinding();
        TextView textView10 = binding11 != null ? binding11.title : null;
        if (textView10 != null) {
            textView10.setText(str3);
        }
        FragmentHistoryWorkoutBinding binding12 = getBinding();
        TextView textView11 = binding12 != null ? binding12.tvHeader : null;
        if (textView11 != null) {
            textView11.setText(str3);
        }
        setupWorkoutInfo(data);
        ArrayList arrayList = new ArrayList();
        arrayList.add(new ChartData(R.string.heart_rate, R.string.bpm, R.color.colorStats_hr, new Function1<List<? extends WorkoutRawData4WorkoutDetailDisplay>, List<? extends Float>>() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment.setView.2
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ List<? extends Float> invoke(List<? extends WorkoutRawData4WorkoutDetailDisplay> list) {
                return invoke2((List<WorkoutRawData4WorkoutDetailDisplay>) list);
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final List<Float> invoke2(List<WorkoutRawData4WorkoutDetailDisplay> it2) {
                Intrinsics.checkNotNullParameter(it2, "it");
                return HistoryWorkoutFragment.this.extractHeartRateList(it2);
            }
        }));
        switch (WhenMappings.$EnumSwitchMapping$0[data.getRootHistoryActivityType().ordinal()]) {
            case 1:
                if (unitType) {
                    i = R.string.mph;
                } else {
                    i = R.string.km_h;
                }
                arrayList.add(new ChartData(R.string.speed, i, R.color.colorStats_speed, new Function1<List<? extends WorkoutRawData4WorkoutDetailDisplay>, List<? extends Float>>() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment.setView.3
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ List<? extends Float> invoke(List<? extends WorkoutRawData4WorkoutDetailDisplay> list) {
                        return invoke2((List<WorkoutRawData4WorkoutDetailDisplay>) list);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final List<Float> invoke2(List<WorkoutRawData4WorkoutDetailDisplay> it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        return HistoryWorkoutFragment.this.extractSpeedList(it2);
                    }
                }));
                arrayList.add(new ChartData(R.string.incline, R.string.empty, R.color.colorStats_incline, new Function1<List<? extends WorkoutRawData4WorkoutDetailDisplay>, List<? extends Float>>() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment.setView.4
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ List<? extends Float> invoke(List<? extends WorkoutRawData4WorkoutDetailDisplay> list) {
                        return invoke2((List<WorkoutRawData4WorkoutDetailDisplay>) list);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final List<Float> invoke2(List<WorkoutRawData4WorkoutDetailDisplay> it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        return HistoryWorkoutFragment.this.extractInclineList(it2);
                    }
                }));
                break;
            case 2:
                arrayList.add(new ChartData(R.string.resistance, R.string.empty, R.color.colorStats_resistance, new Function1<List<? extends WorkoutRawData4WorkoutDetailDisplay>, List<? extends Float>>() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment.setView.5
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ List<? extends Float> invoke(List<? extends WorkoutRawData4WorkoutDetailDisplay> list) {
                        return invoke2((List<WorkoutRawData4WorkoutDetailDisplay>) list);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final List<Float> invoke2(List<WorkoutRawData4WorkoutDetailDisplay> it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        return HistoryWorkoutFragment.this.extractResistanceList(it2);
                    }
                }));
                arrayList.add(new ChartData(R.string.cadence, R.string.rpm, R.color.colorStats_cadence, new Function1<List<? extends WorkoutRawData4WorkoutDetailDisplay>, List<? extends Float>>() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment.setView.6
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ List<? extends Float> invoke(List<? extends WorkoutRawData4WorkoutDetailDisplay> list) {
                        return invoke2((List<WorkoutRawData4WorkoutDetailDisplay>) list);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final List<Float> invoke2(List<WorkoutRawData4WorkoutDetailDisplay> it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        return HistoryWorkoutFragment.this.extractRpmList(it2);
                    }
                }));
                break;
            case 3:
                arrayList.add(new ChartData(R.string.resistance, R.string.empty, R.color.colorStats_resistance, new Function1<List<? extends WorkoutRawData4WorkoutDetailDisplay>, List<? extends Float>>() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment.setView.7
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ List<? extends Float> invoke(List<? extends WorkoutRawData4WorkoutDetailDisplay> list) {
                        return invoke2((List<WorkoutRawData4WorkoutDetailDisplay>) list);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final List<Float> invoke2(List<WorkoutRawData4WorkoutDetailDisplay> it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        return HistoryWorkoutFragment.this.extractResistanceList(it2);
                    }
                }));
                arrayList.add(new ChartData(R.string.cadence, R.string.spm, R.color.colorStats_cadence, new Function1<List<? extends WorkoutRawData4WorkoutDetailDisplay>, List<? extends Float>>() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment.setView.8
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ List<? extends Float> invoke(List<? extends WorkoutRawData4WorkoutDetailDisplay> list) {
                        return invoke2((List<WorkoutRawData4WorkoutDetailDisplay>) list);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final List<Float> invoke2(List<WorkoutRawData4WorkoutDetailDisplay> it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        return HistoryWorkoutFragment.this.extractSpmStepperList(it2);
                    }
                }));
                break;
            case 4:
                arrayList.add(new ChartData(R.string.resistance, R.string.empty, R.color.colorStats_resistance, new Function1<List<? extends WorkoutRawData4WorkoutDetailDisplay>, List<? extends Float>>() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment.setView.9
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ List<? extends Float> invoke(List<? extends WorkoutRawData4WorkoutDetailDisplay> list) {
                        return invoke2((List<WorkoutRawData4WorkoutDetailDisplay>) list);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final List<Float> invoke2(List<WorkoutRawData4WorkoutDetailDisplay> it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        return HistoryWorkoutFragment.this.extractResistanceList(it2);
                    }
                }));
                arrayList.add(new ChartData(R.string.cadence, R.string.spm, R.color.colorStats_cadence, new Function1<List<? extends WorkoutRawData4WorkoutDetailDisplay>, List<? extends Float>>() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment.setView.10
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ List<? extends Float> invoke(List<? extends WorkoutRawData4WorkoutDetailDisplay> list) {
                        return invoke2((List<WorkoutRawData4WorkoutDetailDisplay>) list);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final List<Float> invoke2(List<WorkoutRawData4WorkoutDetailDisplay> it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        return HistoryWorkoutFragment.this.extractSpmRowerList(it2);
                    }
                }));
                break;
            case 5:
                arrayList.add(new ChartData(R.string.resistance, R.string.empty, R.color.colorStats_resistance, new Function1<List<? extends WorkoutRawData4WorkoutDetailDisplay>, List<? extends Float>>() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment.setView.11
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ List<? extends Float> invoke(List<? extends WorkoutRawData4WorkoutDetailDisplay> list) {
                        return invoke2((List<WorkoutRawData4WorkoutDetailDisplay>) list);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final List<Float> invoke2(List<WorkoutRawData4WorkoutDetailDisplay> it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        return HistoryWorkoutFragment.this.extractResistanceList(it2);
                    }
                }));
                arrayList.add(new ChartData(R.string.cadence, R.string.rpm, R.color.colorStats_cadence, new Function1<List<? extends WorkoutRawData4WorkoutDetailDisplay>, List<? extends Float>>() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment.setView.12
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ List<? extends Float> invoke(List<? extends WorkoutRawData4WorkoutDetailDisplay> list) {
                        return invoke2((List<WorkoutRawData4WorkoutDetailDisplay>) list);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final List<Float> invoke2(List<WorkoutRawData4WorkoutDetailDisplay> it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        return HistoryWorkoutFragment.this.extractRpmList(it2);
                    }
                }));
                arrayList.add(new ChartData(R.string.incline, R.string.empty, R.color.colorStats_incline, new Function1<List<? extends WorkoutRawData4WorkoutDetailDisplay>, List<? extends Float>>() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment.setView.13
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ List<? extends Float> invoke(List<? extends WorkoutRawData4WorkoutDetailDisplay> list) {
                        return invoke2((List<WorkoutRawData4WorkoutDetailDisplay>) list);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final List<Float> invoke2(List<WorkoutRawData4WorkoutDetailDisplay> it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        return HistoryWorkoutFragment.this.extractInclineList(it2);
                    }
                }));
                break;
            case 6:
                arrayList.add(new ChartData(R.string.cadence, R.string.rpm, R.color.colorStats_cadence, new Function1<List<? extends WorkoutRawData4WorkoutDetailDisplay>, List<? extends Float>>() { // from class: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment.setView.14
                    {
                        super(1);
                    }

                    @Override // kotlin.jvm.functions.Function1
                    public /* bridge */ /* synthetic */ List<? extends Float> invoke(List<? extends WorkoutRawData4WorkoutDetailDisplay> list) {
                        return invoke2((List<WorkoutRawData4WorkoutDetailDisplay>) list);
                    }

                    /* renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final List<Float> invoke2(List<WorkoutRawData4WorkoutDetailDisplay> it2) {
                        Intrinsics.checkNotNullParameter(it2, "it");
                        return HistoryWorkoutFragment.this.extractRpmList(it2);
                    }
                }));
                break;
        }
        Iterator it2 = arrayList.iterator();
        while (true) {
            if (it2.hasNext()) {
                ChartData chartData = (ChartData) it2.next();
                ArrayList rawDataList = data.getRawDataList();
                if (rawDataList == null) {
                    rawDataList = new ArrayList();
                }
                if (rawDataList == null) {
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    ArrayList arrayList2 = new ArrayList();
                    for (Object obj : rawDataList) {
                        if (((WorkoutRawData4WorkoutDetailDisplay) obj).getTotalWorkoutTime() != null) {
                            arrayList2.add(obj);
                        }
                    }
                    HashSet hashSet = new HashSet();
                    ArrayList arrayList3 = new ArrayList();
                    for (Object obj2 : arrayList2) {
                        if (hashSet.add(((WorkoutRawData4WorkoutDetailDisplay) obj2).getTotalWorkoutTime())) {
                            arrayList3.add(obj2);
                        }
                    }
                    ArrayList arrayList4 = arrayList3;
                    if (arrayList4.size() > 1500) {
                        float size = arrayList4.size() / 1500;
                        ArrayList arrayList5 = new ArrayList(1500);
                        for (int i2 = 0; i2 < 1500; i2++) {
                            arrayList5.add(arrayList4.get((int) (i2 * size)));
                        }
                        arrayList4 = arrayList5;
                    }
                    listEmptyList = arrayList4;
                }
                List<Float> listInvoke = chartData.getExtractor().invoke(listEmptyList);
                Float fValueOf = Float.valueOf(0.0f);
                Float fValueOf2 = Float.valueOf(0.0f);
                Double dValueOf = Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE);
                if (listInvoke.isEmpty()) {
                    str = str2;
                    f = fValueOf2;
                    f2 = fValueOf;
                } else {
                    List<Float> list = listInvoke;
                    Float fMaxOrNull = CollectionsKt.maxOrNull((Iterable<? extends Float>) list);
                    Float fMinOrNull = CollectionsKt.minOrNull((Iterable<? extends Float>) list);
                    Double dValueOf2 = Double.valueOf(CollectionsKt.averageOfFloat(list));
                    Timber.INSTANCE.e("avg:%s", dValueOf2);
                    str = str2;
                    double d = 10;
                    f2 = fMaxOrNull;
                    f = fMinOrNull;
                    dValueOf = Double.valueOf(Math.rint(dValueOf2.doubleValue() * d) / d);
                }
                Double dValueOf3 = chartData.getTitleRes() == R.string.heart_rate ? Double.valueOf(Double.parseDouble(ConvertUtils.formatToIntegerRounded$default(ConvertUtils.INSTANCE, String.valueOf(dValueOf), null, 2, null))) : dValueOf;
                String string2 = getString(chartData.getTitleRes());
                str2 = str;
                Intrinsics.checkNotNullExpressionValue(string2, str2);
                String string3 = getString(chartData.getUnitRes());
                Intrinsics.checkNotNullExpressionValue(string3, str2);
                addChartView(string2, string3, chartData.getColorRes(), data, listInvoke, f2, f, dValueOf3, listEmptyList, data.getRootHistoryActivityType());
            } else {
                if (Global.INSTANCE.getUnitType() && data.getRootHistoryActivityType() != HistoryActivityType.ROWING) {
                    List<Integer> splitsImperial = data.getSplitsImperial();
                    if (splitsImperial == null || splitsImperial.isEmpty()) {
                        FragmentHistoryWorkoutBinding binding13 = getBinding();
                        linearLayout = binding13 != null ? binding13.LLPace : null;
                        if (linearLayout == null) {
                            return;
                        }
                        linearLayout.setVisibility(8);
                        return;
                    }
                    FragmentHistoryWorkoutBinding binding14 = getBinding();
                    linearLayout = binding14 != null ? binding14.LLPace : null;
                    if (linearLayout != null) {
                        linearLayout.setVisibility(0);
                    }
                    setPaceRecyclerView(data.getSplitsImperial(), data.getRootHistoryActivityType());
                    return;
                }
                List<Integer> splits = data.getSplits();
                if (splits == null || splits.isEmpty()) {
                    FragmentHistoryWorkoutBinding binding15 = getBinding();
                    linearLayout = binding15 != null ? binding15.LLPace : null;
                    if (linearLayout == null) {
                        return;
                    }
                    linearLayout.setVisibility(8);
                    return;
                }
                FragmentHistoryWorkoutBinding binding16 = getBinding();
                linearLayout = binding16 != null ? binding16.LLPace : null;
                if (linearLayout != null) {
                    linearLayout.setVisibility(0);
                }
                setPaceRecyclerView(data.getSplits(), data.getRootHistoryActivityType());
                return;
            }
        }
    }

    private final void addWorkoutInfoView(String titleRes, String value, String unitRes) {
        LinearLayout linearLayout;
        TextView textView;
        Context context = getContext();
        if (context != null) {
            CustomHistoryWorkoutItemBinding customHistoryWorkoutItemBinding = (CustomHistoryWorkoutItemBinding) DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.custom_history_workout_item, null, false);
            TextView textView2 = customHistoryWorkoutItemBinding != null ? customHistoryWorkoutItemBinding.title : null;
            if (textView2 != null) {
                textView2.setText(titleRes);
            }
            TextView textView3 = customHistoryWorkoutItemBinding != null ? customHistoryWorkoutItemBinding.value : null;
            if (textView3 != null) {
                textView3.setText(value);
            }
            TextView textView4 = customHistoryWorkoutItemBinding != null ? customHistoryWorkoutItemBinding.unit : null;
            if (textView4 != null) {
                textView4.setText(unitRes);
            }
            int color = ContextCompat.getColor(context, R.color.colorLabel_label3);
            if (Intrinsics.areEqual(value, "--")) {
                if (customHistoryWorkoutItemBinding != null && (textView = customHistoryWorkoutItemBinding.value) != null) {
                    textView.setTextColor(color);
                }
                TextView textView5 = customHistoryWorkoutItemBinding != null ? customHistoryWorkoutItemBinding.unit : null;
                if (textView5 != null) {
                    textView5.setText("");
                }
            }
            FragmentHistoryWorkoutBinding binding = getBinding();
            if (binding == null || (linearLayout = binding.LLWorkoutInfo) == null) {
                return;
            }
            linearLayout.addView(customHistoryWorkoutItemBinding.getRoot());
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0150  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final void addChartView(java.lang.String r24, java.lang.String r25, int r26, com.soletreadmills.sole_v2._data.WorkoutViewVo r27, final java.util.List<java.lang.Float> r28, java.lang.Float r29, java.lang.Float r30, java.lang.Double r31, final java.util.List<com.soletreadmills.sole_v2._data.WorkoutRawData4WorkoutDetailDisplay> r32, final com.soletreadmills.sole_v2._type.HistoryActivityType r33) {
        /*
            Method dump skipped, instructions count: 409
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment.addChartView(java.lang.String, java.lang.String, int, com.soletreadmills.sole_v2._data.WorkoutViewVo, java.util.List, java.lang.Float, java.lang.Float, java.lang.Double, java.util.List, com.soletreadmills.sole_v2._type.HistoryActivityType):void");
    }

    public static /* synthetic */ List compressByMinMax$default(HistoryWorkoutFragment historyWorkoutFragment, List list, int i, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 500;
        }
        return historyWorkoutFragment.compressByMinMax(list, i);
    }

    public final List<Float> compressByMinMax(List<Float> data, int targetSize) {
        Intrinsics.checkNotNullParameter(data, "data");
        if (data.size() <= targetSize) {
            return data;
        }
        int iCeil = (int) Math.ceil(data.size() / (targetSize / 2.0d));
        ArrayList arrayList = new ArrayList(targetSize);
        int i = 0;
        while (i < data.size()) {
            int i2 = i + iCeil;
            Iterator<Float> it = data.subList(i, Math.min(i2, data.size())).iterator();
            float f = Float.MAX_VALUE;
            float f2 = Float.MIN_VALUE;
            while (it.hasNext()) {
                float fFloatValue = it.next().floatValue();
                if (fFloatValue < f) {
                    f = fFloatValue;
                }
                if (fFloatValue > f2) {
                    f2 = fFloatValue;
                }
            }
            arrayList.add(Float.valueOf(f));
            arrayList.add(Float.valueOf(f2));
            i = i2;
        }
        if (arrayList.size() > targetSize) {
            List<Float> listSubList = arrayList.subList(0, targetSize);
            Intrinsics.checkNotNull(listSubList);
            return listSubList;
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void updateAllChartChildViews(float newProgress) {
        FragmentHistoryWorkoutBinding binding = getBinding();
        if (binding != null) {
            int childCount = binding.LLChart.getChildCount();
            for (int i = 0; i < childCount; i++) {
                View childAt = binding.LLChart.getChildAt(i);
                CustomHistoryWorkoutChartItemBinding customHistoryWorkoutChartItemBinding = (CustomHistoryWorkoutChartItemBinding) DataBindingUtil.getBinding(childAt);
                if (customHistoryWorkoutChartItemBinding != null) {
                    Intrinsics.checkNotNull(customHistoryWorkoutChartItemBinding);
                    Object tag = childAt.getTag();
                    ChartItemInfo chartItemInfo = tag instanceof ChartItemInfo ? (ChartItemInfo) tag : null;
                    if (chartItemInfo != null) {
                        customHistoryWorkoutChartItemBinding.tvDistance.setVisibility(this.isHide ? 8 : 0);
                        customHistoryWorkoutChartItemBinding.tvTime.setVisibility(this.isHide ? 8 : 0);
                        if (this.isHide) {
                            customHistoryWorkoutChartItemBinding.value.setText(ConvertUtils.formatToOneDecimal02$default(ConvertUtils.INSTANCE, String.valueOf(chartItemInfo.getAvg()), null, 2, null));
                        } else {
                            customHistoryWorkoutChartItemBinding.value.setText(ConvertUtils.formatToOneDecimal02$default(ConvertUtils.INSTANCE, String.valueOf(getYValueAtProgress(chartItemInfo.getDataArray(), newProgress)), null, 2, null));
                        }
                    }
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final float getYValueAtProgress(List<Float> dataArray, float progress) {
        if (dataArray.isEmpty()) {
            return 0.0f;
        }
        return dataArray.get(RangesKt.coerceIn((int) progress, 0, dataArray.size() - 1)).floatValue();
    }

    public final void setPaceRecyclerView(List<Integer> list, HistoryActivityType rootHistoryActivityType) {
        RecyclerView recyclerView;
        RecyclerView recyclerView2;
        RecyclerView recyclerView3;
        Intrinsics.checkNotNullParameter(list, "list");
        Intrinsics.checkNotNullParameter(rootHistoryActivityType, "rootHistoryActivityType");
        FragmentHistoryWorkoutBinding binding = getBinding();
        RecyclerView.Adapter adapter = null;
        if (!(((binding == null || (recyclerView3 = binding.rvPace) == null) ? null : recyclerView3.getLayoutManager()) instanceof LinearLayoutManager)) {
            FragmentHistoryWorkoutBinding binding2 = getBinding();
            RecyclerView recyclerView4 = binding2 != null ? binding2.rvPace : null;
            if (recyclerView4 != null) {
                recyclerView4.setLayoutManager(new LinearLayoutManager(getActivity()));
            }
        }
        FragmentHistoryWorkoutBinding binding3 = getBinding();
        if (!(((binding3 == null || (recyclerView2 = binding3.rvPace) == null) ? null : recyclerView2.getAdapter()) instanceof HistoryWorkoutAdapter)) {
            HistoryWorkoutAdapter historyWorkoutAdapter = new HistoryWorkoutAdapter(rootHistoryActivityType);
            FragmentHistoryWorkoutBinding binding4 = getBinding();
            RecyclerView recyclerView5 = binding4 != null ? binding4.rvPace : null;
            if (recyclerView5 != null) {
                recyclerView5.setAdapter(historyWorkoutAdapter);
            }
        }
        FragmentHistoryWorkoutBinding binding5 = getBinding();
        if (binding5 != null && (recyclerView = binding5.rvPace) != null) {
            adapter = recyclerView.getAdapter();
        }
        if (adapter instanceof HistoryWorkoutAdapter) {
            ((HistoryWorkoutAdapter) adapter).submitList(list);
        }
    }

    /* compiled from: HistoryWorkoutFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment$getUserWorkoutContentApi$1", f = "HistoryWorkoutFragment.kt", i = {}, l = {809}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment$getUserWorkoutContentApi$1, reason: invalid class name and case insensitive filesystem */
    static final class C09741 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09741(Continuation<? super C09741> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HistoryWorkoutFragment.this.new C09741(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09741) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        HistoryWorkoutFragment.this.showLoading();
                        this.label = 1;
                        obj = BuildersKt.withContext(Dispatchers.getIO(), new HistoryWorkoutFragment$getUserWorkoutContentApi$1$result$1(HistoryWorkoutFragment.this, null), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    Pair pair = (Pair) obj;
                    WorkoutViewVo workoutViewVo = (WorkoutViewVo) pair.component1();
                    String str = (String) pair.component2();
                    if (workoutViewVo == null) {
                        if (HistoryWorkoutFragment.this.shouldIgnoreError(str)) {
                            return Unit.INSTANCE;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.err_113)), TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), Boxing.boxInt(R.string.error))).get(str);
                        if (num != null) {
                            HistoryWorkoutFragment historyWorkoutFragment = HistoryWorkoutFragment.this;
                            CustomDialogKt.showCustomDialog$default(historyWorkoutFragment, historyWorkoutFragment.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                        } else {
                            BaseFragment.handleUndefinedError$default(HistoryWorkoutFragment.this, "getUserWorkoutContent", str, str, false, 8, null);
                        }
                    } else {
                        HistoryWorkoutFragment.this.setView(workoutViewVo);
                        HistoryWorkoutFragment.this.getActivityViewModel().setWorkoutData(workoutViewVo);
                    }
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(HistoryWorkoutFragment.this, "getUserWorkoutContent", message, false, 4, null);
                }
                HistoryWorkoutFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                HistoryWorkoutFragment.this.stopLoading();
            }
        }
    }

    public final void getUserWorkoutContentApi() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C09741(null), 3, null);
    }

    /* compiled from: HistoryWorkoutFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment$deleteWorkout$1", f = "HistoryWorkoutFragment.kt", i = {}, l = {872}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment$deleteWorkout$1, reason: invalid class name */
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
            return HistoryWorkoutFragment.this.new AnonymousClass1(this.$workoutUuid, continuation);
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
                        HistoryWorkoutFragment.this.showLoading();
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
                    if (responseData != null && responseData.getSuccess()) {
                        HistoryWorkoutFragment.this.getActivityViewModel().setHistoryList(new ArrayList());
                        HistoryWorkoutFragment.this.safeNavigateUp();
                    } else {
                        String errorCode = responseData != null ? responseData.getErrorCode() : null;
                        if (HistoryWorkoutFragment.this.shouldIgnoreError(errorCode)) {
                            return Unit.INSTANCE;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.err_113)), TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), Boxing.boxInt(R.string.error)), TuplesKt.to(ErrorCode.DATA_NOT_FOUND_108.getId(), Boxing.boxInt(R.string.err_108)), TuplesKt.to(ErrorCode.NOT_OWNER_1022.getId(), Boxing.boxInt(R.string.err_1022))).get(errorCode);
                        if (num != null) {
                            HistoryWorkoutFragment historyWorkoutFragment = HistoryWorkoutFragment.this;
                            CustomDialogKt.showCustomDialog$default(historyWorkoutFragment, historyWorkoutFragment.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                        } else {
                            BaseFragment.handleUndefinedError$default(HistoryWorkoutFragment.this, "deleteWorkout", errorCode, responseData != null ? responseData.getErrorMessage() : null, false, 8, null);
                        }
                    }
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(HistoryWorkoutFragment.this, "deleteWorkout", message, false, 4, null);
                }
                HistoryWorkoutFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                HistoryWorkoutFragment.this.stopLoading();
            }
        }
    }

    public final void deleteWorkout(String workoutUuid) {
        Intrinsics.checkNotNullParameter(workoutUuid, "workoutUuid");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(workoutUuid, null), 3, null);
    }

    /* compiled from: HistoryWorkoutFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment$exportToStrava$1", f = "HistoryWorkoutFragment.kt", i = {}, l = {945, 948}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment$exportToStrava$1, reason: invalid class name and case insensitive filesystem */
    static final class C09731 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $workoutUuid;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C09731(String str, Continuation<? super C09731> continuation) {
            super(2, continuation);
            this.$workoutUuid = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return HistoryWorkoutFragment.this.new C09731(this.$workoutUuid, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09731) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Unit unit;
            String url;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(HistoryWorkoutFragment.this, "exportToStrava", message, false, 4, null);
                }
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    HistoryWorkoutFragment.this.showLoading();
                    this.label = 1;
                    obj = DyacoApiKt.callExportToStrava(new StravaShareHistoryApiData.RequestBodyData(this.$workoutUuid), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return Unit.INSTANCE;
                    }
                    ResultKt.throwOnFailure(obj);
                }
                StravaShareHistoryApiData.ResponseData responseData = (StravaShareHistoryApiData.ResponseData) ((Response) obj).body();
                if (responseData != null && responseData.getSuccess()) {
                    this.label = 2;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C02501(HistoryWorkoutFragment.this, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    String errorCode = responseData != null ? responseData.getErrorCode() : null;
                    if (HistoryWorkoutFragment.this.shouldIgnoreError(errorCode)) {
                        unit = Unit.INSTANCE;
                    } else {
                        Map mapMapOf = MapsKt.mapOf(TuplesKt.to(ErrorCode.STRAVA_UPLOAD_DUPLICATE.getId(), Boxing.boxInt(R.string.activity_may_already_exist)));
                        if (Intrinsics.areEqual(errorCode, "1011")) {
                            StravaShareHistoryApiData.DataMap dataMap = responseData.getDataMap();
                            if (dataMap == null || (url = dataMap.getUrl()) == null) {
                                unit = Unit.INSTANCE;
                            } else {
                                StravaManager stravaManager = StravaManager.INSTANCE;
                                Context contextRequireContext = HistoryWorkoutFragment.this.requireContext();
                                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                                stravaManager.openLoginPage(contextRequireContext, url);
                                unit = Unit.INSTANCE;
                            }
                        } else {
                            Integer num = (Integer) mapMapOf.get(errorCode);
                            if (num != null) {
                                HistoryWorkoutFragment historyWorkoutFragment = HistoryWorkoutFragment.this;
                                CustomDialogKt.showCustomDialog$default(historyWorkoutFragment, historyWorkoutFragment.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                            } else {
                                BaseFragment.handleUndefinedError$default(HistoryWorkoutFragment.this, "exportToStrava", errorCode, responseData != null ? responseData.getErrorMessage() : null, false, 8, null);
                            }
                        }
                    }
                    return unit;
                }
                return Unit.INSTANCE;
            } finally {
                HistoryWorkoutFragment.this.stopLoading();
            }
        }

        /* compiled from: HistoryWorkoutFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment$exportToStrava$1$1", f = "HistoryWorkoutFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.history.HistoryWorkoutFragment$exportToStrava$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02501 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ HistoryWorkoutFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02501(HistoryWorkoutFragment historyWorkoutFragment, Continuation<? super C02501> continuation) {
                super(2, continuation);
                this.this$0 = historyWorkoutFragment;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02501(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02501) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Toast.makeText(this.this$0.getContext(), this.this$0.getString(R.string.success), 0).show();
                return Unit.INSTANCE;
            }
        }
    }

    public final void exportToStrava(String workoutUuid) {
        Intrinsics.checkNotNullParameter(workoutUuid, "workoutUuid");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C09731(workoutUuid, null), 3, null);
    }

    private final void setupWorkoutInfo(WorkoutViewVo data) {
        List<WorkoutInfoItem> treadmillInfo;
        LinearLayout linearLayout;
        FragmentHistoryWorkoutBinding binding = getBinding();
        if (binding != null && (linearLayout = binding.LLWorkoutInfo) != null) {
            linearLayout.removeAllViews();
        }
        switch (WhenMappings.$EnumSwitchMapping$0[data.getRootHistoryActivityType().ordinal()]) {
            case 1:
                treadmillInfo = getTreadmillInfo(data);
                break;
            case 2:
                treadmillInfo = getBikeInfo(data);
                break;
            case 3:
                treadmillInfo = getStepperInfo(data);
                break;
            case 4:
                treadmillInfo = getRowingInfo(data);
                break;
            case 5:
                treadmillInfo = getEllipticalInfo(data);
                break;
            case 6:
            default:
                treadmillInfo = getDefaultInfo(data);
                break;
            case 7:
                treadmillInfo = getWalkingInfo(data);
                break;
            case 8:
                treadmillInfo = getSrvoInfo(data);
                break;
        }
        for (WorkoutInfoItem workoutInfoItem : treadmillInfo) {
            String string = getString(workoutInfoItem.getTitleRes());
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            addWorkoutInfoView(string, workoutInfoItem.getValue(), workoutInfoItem.getUnit());
        }
    }

    private final List<WorkoutInfoItem> getTreadmillInfo(WorkoutViewVo data) {
        return CollectionsKt.listOf((Object[]) new WorkoutInfoItem[]{createDistanceItem(data.getTotalDistance(), data.getRootHistoryActivityType()), createTimeItem(data.getTotalTime()), createPaceItem(data.getAvgPace()), createCaloriesItem(data.getTotalCalories()), createMetsItem(data.getAvgMet()), createOutputItem(data.getAvgWatt()), createAscentItem(data.getTotalElevation())});
    }

    private final List<WorkoutInfoItem> getWalkingInfo(WorkoutViewVo data) {
        WorkoutInfoItem[] workoutInfoItemArr = new WorkoutInfoItem[6];
        workoutInfoItemArr[0] = createDistanceItem(data.getTotalDistance(), data.getRootHistoryActivityType());
        workoutInfoItemArr[1] = createTimeItem(data.getTotalTime());
        int i = R.string.total_steps;
        Integer totalSteps = data.getTotalSteps();
        workoutInfoItemArr[2] = new WorkoutInfoItem(i, String.valueOf(totalSteps != null ? totalSteps.intValue() : 0), "");
        workoutInfoItemArr[3] = createCaloriesItem(data.getTotalCalories());
        workoutInfoItemArr[4] = createSpeedItem(data.getAvgSpeed());
        workoutInfoItemArr[5] = createMetsItem(data.getAvgMet());
        return CollectionsKt.listOf((Object[]) workoutInfoItemArr);
    }

    private final List<WorkoutInfoItem> getBikeInfo(WorkoutViewVo data) {
        return CollectionsKt.listOf((Object[]) new WorkoutInfoItem[]{createDistanceItem(data.getTotalDistance(), data.getRootHistoryActivityType()), createTimeItem(data.getTotalTime()), createSpeedItem(data.getAvgSpeed()), createCaloriesItem(data.getTotalCalories()), createMetsItem(data.getAvgMet()), createOutputItem(data.getAvgWatt())});
    }

    private final List<WorkoutInfoItem> getEllipticalInfo(WorkoutViewVo data) {
        return CollectionsKt.listOf((Object[]) new WorkoutInfoItem[]{createDistanceItem(data.getTotalDistance(), data.getRootHistoryActivityType()), createTimeItem(data.getTotalTime()), createSpeedItem(data.getAvgSpeed()), createCaloriesItem(data.getTotalCalories()), createMetsItem(data.getAvgMet()), createOutputItem(data.getAvgWatt()), createAscentItem(data.getTotalElevation()), createInclineItem(data.getAvgIncline())});
    }

    private final List<WorkoutInfoItem> getStepperInfo(WorkoutViewVo data) {
        WorkoutInfoItem[] workoutInfoItemArr = new WorkoutInfoItem[5];
        int i = R.string.total_steps;
        Integer totalSteps = data.getTotalSteps();
        workoutInfoItemArr[0] = new WorkoutInfoItem(i, String.valueOf(totalSteps != null ? totalSteps.intValue() : 0), "");
        workoutInfoItemArr[1] = createTimeItem(data.getTotalTime());
        workoutInfoItemArr[2] = createCaloriesItem(data.getTotalCalories());
        workoutInfoItemArr[3] = createMetsItem(data.getAvgMet());
        workoutInfoItemArr[4] = createAscentItem(data.getTotalElevation());
        return CollectionsKt.listOf((Object[]) workoutInfoItemArr);
    }

    private final List<WorkoutInfoItem> getRowingInfo(WorkoutViewVo data) {
        WorkoutInfoItem[] workoutInfoItemArr = new WorkoutInfoItem[7];
        workoutInfoItemArr[0] = createDistanceItem(data.getTotalDistance(), data.getRootHistoryActivityType());
        workoutInfoItemArr[1] = createTimeItem(data.getTotalTime());
        workoutInfoItemArr[2] = createRowerPaceItem(data.getAvgPace());
        workoutInfoItemArr[3] = createCaloriesItem(data.getTotalCalories());
        workoutInfoItemArr[4] = createMetsItem(data.getAvgMet());
        workoutInfoItemArr[5] = createOutputItem(data.getAvgWatt());
        int i = R.string.total_strokes;
        ConvertUtils convertUtils = ConvertUtils.INSTANCE;
        Integer totalStrokes = data.getTotalStrokes();
        workoutInfoItemArr[6] = new WorkoutInfoItem(i, ConvertUtils.formatToOneDecimal02$default(convertUtils, String.valueOf(totalStrokes != null ? totalStrokes.intValue() : 0), null, 2, null), "");
        return CollectionsKt.listOf((Object[]) workoutInfoItemArr);
    }

    private final List<WorkoutInfoItem> getFullSweatInfo(WorkoutViewVo data) {
        return CollectionsKt.listOf((Object[]) new WorkoutInfoItem[]{createDistanceItem(data.getTotalDistance(), data.getRootHistoryActivityType()), createTimeItem(data.getTotalTime()), createPaceItem(data.getAvgPace()), createCaloriesItem(data.getTotalCalories())});
    }

    private final List<WorkoutInfoItem> getSrvoInfo(WorkoutViewVo data) {
        WorkoutInfoItem[] workoutInfoItemArr = new WorkoutInfoItem[6];
        SrvoRefDataVo srvoRefData = data.getSrvoRefData();
        workoutInfoItemArr[0] = createTotalLoadItem(srvoRefData != null ? srvoRefData.getSrvoTotalWeight() : null);
        workoutInfoItemArr[1] = createTimeItem(data.getTotalTime());
        SrvoRefDataVo srvoRefData2 = data.getSrvoRefData();
        workoutInfoItemArr[2] = createTotalSetsItem(srvoRefData2 != null ? srvoRefData2.getSrvoTotalSets() : null);
        SrvoRefDataVo srvoRefData3 = data.getSrvoRefData();
        workoutInfoItemArr[3] = createTotalRepsItem(srvoRefData3 != null ? srvoRefData3.getSrvoTotalReps() : null);
        workoutInfoItemArr[4] = new WorkoutInfoItem(R.string.avg_load, "--", "");
        workoutInfoItemArr[5] = new WorkoutInfoItem(R.string.avg_tension_time, "--", "");
        return CollectionsKt.listOf((Object[]) workoutInfoItemArr);
    }

    private final List<WorkoutInfoItem> getDefaultInfo(WorkoutViewVo data) {
        return CollectionsKt.listOf((Object[]) new WorkoutInfoItem[]{createTimeItem(data.getTotalTime()), createCaloriesItem(data.getTotalCalories())});
    }

    private final WorkoutInfoItem createDistanceItem(Double distance, HistoryActivityType rootHistoryActivityType) {
        String string;
        String toTwoDecimalSmart$default;
        boolean unitType = Global.INSTANCE.getUnitType();
        if (rootHistoryActivityType == HistoryActivityType.ROWING) {
            string = getString(R.string.m);
        } else if (unitType) {
            string = getString(R.string.mi);
        } else {
            string = getString(R.string.km);
        }
        Intrinsics.checkNotNull(string);
        if (rootHistoryActivityType == HistoryActivityType.ROWING) {
            toTwoDecimalSmart$default = ConvertUtils.formatToTwoDecimalSmart$default(ConvertUtils.INSTANCE, String.valueOf((distance != null ? distance.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE) * 1000), null, 2, null);
        } else if (unitType) {
            ConvertUtils convertUtils = ConvertUtils.INSTANCE;
            UnitConversion unitConversion = UnitConversion.INSTANCE;
            Object obj = distance;
            if (distance == null) {
                obj = 0;
            }
            toTwoDecimalSmart$default = ConvertUtils.formatToTwoDecimalSmart$default(convertUtils, unitConversion.getMi(((Number) obj).toString(), 2), null, 2, null);
        } else {
            ConvertUtils convertUtils2 = ConvertUtils.INSTANCE;
            Object obj2 = distance;
            if (distance == null) {
                obj2 = 0;
            }
            toTwoDecimalSmart$default = ConvertUtils.formatToTwoDecimalSmart$default(convertUtils2, ((Number) obj2).toString(), null, 2, null);
        }
        return new WorkoutInfoItem(R.string.distance, toTwoDecimalSmart$default, string);
    }

    private final WorkoutInfoItem createTimeItem(Integer totalTime) {
        return new WorkoutInfoItem(R.string.total_time, TimeTools.secToTime02$default(TimeTools.INSTANCE, totalTime != null ? totalTime.intValue() : 0, false, 2, null), "");
    }

    private final WorkoutInfoItem createPaceItem(Double pace) {
        return new WorkoutInfoItem(R.string.avg_pace, TimeTools.INSTANCE.secToTime02(pace != null ? (long) WorkoutViewVo.INSTANCE.convertedPace(pace.doubleValue(), Global.INSTANCE.getUnitType()) : 0L, false), "");
    }

    private final WorkoutInfoItem createRowerPaceItem(Double pace) {
        return new WorkoutInfoItem(R.string.avg_pace, TimeTools.INSTANCE.secToTime02(pace != null ? (long) pace.doubleValue() : 0L, false), "");
    }

    private final WorkoutInfoItem createSpeedItem(Double speed) {
        String toOneDecimal02;
        boolean unitType = Global.INSTANCE.getUnitType();
        String string = getString(unitType ? R.string.mph : R.string.km_h);
        Intrinsics.checkNotNull(string);
        if (!unitType) {
            toOneDecimal02 = ConvertUtils.INSTANCE.formatToOneDecimal02(speed != null ? speed.toString() : null, "--");
        } else {
            toOneDecimal02 = ConvertUtils.INSTANCE.formatToOneDecimal02(UnitConversion.INSTANCE.getMi(speed != null ? speed.toString() : null), "--");
        }
        return new WorkoutInfoItem(R.string.avg_speed, toOneDecimal02, string);
    }

    private final WorkoutInfoItem createCaloriesItem(Integer calories) {
        String toOneDecimal02 = ConvertUtils.INSTANCE.formatToOneDecimal02(String.valueOf(calories), "--");
        int i = R.string.calories;
        String string = getString(R.string.kcal);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return new WorkoutInfoItem(i, toOneDecimal02, string);
    }

    private final WorkoutInfoItem createMetsItem(Double mets) {
        return new WorkoutInfoItem(R.string.mets, ConvertUtils.INSTANCE.formatToOneDecimal02(String.valueOf(mets), "--"), "");
    }

    private final WorkoutInfoItem createOutputItem(Double watt) {
        String toOneDecimal02 = ConvertUtils.INSTANCE.formatToOneDecimal02(String.valueOf(watt), "--");
        int i = R.string.avg_output;
        String string = getString(R.string.watts);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        return new WorkoutInfoItem(i, toOneDecimal02, string);
    }

    private final WorkoutInfoItem createAscentItem(Double elevation) {
        String toOneDecimal02;
        boolean unitType = Global.INSTANCE.getUnitType();
        String string = getString(unitType ? R.string.ft : R.string.m);
        Intrinsics.checkNotNull(string);
        if (!unitType) {
            toOneDecimal02 = ConvertUtils.INSTANCE.formatToOneDecimal02(String.valueOf(elevation), "--");
        } else {
            toOneDecimal02 = ConvertUtils.INSTANCE.formatToOneDecimal02(UnitConversion.INSTANCE.getM_ToFt(elevation != null ? elevation.toString() : null), "--");
        }
        return new WorkoutInfoItem(R.string.ascent, toOneDecimal02, string);
    }

    private final WorkoutInfoItem createInclineItem(Double incline) {
        return new WorkoutInfoItem(R.string.avg_incline, ConvertUtils.INSTANCE.formatToOneDecimal02(String.valueOf(incline), "--"), "");
    }

    private final WorkoutInfoItem createTotalLoadItem(Double kg) {
        String toOneDecimal02;
        boolean unitType = Global.INSTANCE.getUnitType();
        String string = getString(unitType ? R.string.lb : R.string.kg);
        Intrinsics.checkNotNull(string);
        if (!unitType) {
            toOneDecimal02 = ConvertUtils.INSTANCE.formatToOneDecimal02(String.valueOf(kg), "--");
        } else {
            toOneDecimal02 = ConvertUtils.INSTANCE.formatToOneDecimal02(UnitConversion.INSTANCE.getLb(kg != null ? kg.toString() : null), "--");
        }
        return new WorkoutInfoItem(R.string.total_load, toOneDecimal02, string);
    }

    private final WorkoutInfoItem createTotalSetsItem(Integer sets) {
        return new WorkoutInfoItem(R.string.total_sets, ConvertUtils.INSTANCE.formatToOneDecimal02(String.valueOf(sets), "--"), "");
    }

    private final WorkoutInfoItem createTotalRepsItem(Integer reps) {
        return new WorkoutInfoItem(R.string.total_reps, ConvertUtils.INSTANCE.formatToOneDecimal02(String.valueOf(reps), "--"), "");
    }

    public final List<Float> extractSpeedList(List<WorkoutRawData4WorkoutDetailDisplay> rawDataList) {
        Intrinsics.checkNotNullParameter(rawDataList, "rawDataList");
        boolean unitType = Global.INSTANCE.getUnitType();
        ArrayList arrayList = new ArrayList();
        for (WorkoutRawData4WorkoutDetailDisplay workoutRawData4WorkoutDetailDisplay : rawDataList) {
            Float fValueOf = null;
            if (unitType) {
                ConvertUtils convertUtils = ConvertUtils.INSTANCE;
                UnitConversion unitConversion = UnitConversion.INSTANCE;
                Double nowSpeed = workoutRawData4WorkoutDetailDisplay.getNowSpeed();
                fValueOf = Float.valueOf(Float.parseFloat(convertUtils.formatToOneDecimal02(unitConversion.getMi(nowSpeed != null ? nowSpeed.toString() : null), "0")));
            } else {
                Double nowSpeed2 = workoutRawData4WorkoutDetailDisplay.getNowSpeed();
                if (nowSpeed2 != null) {
                    fValueOf = Float.valueOf((float) nowSpeed2.doubleValue());
                }
            }
            if (fValueOf != null) {
                arrayList.add(fValueOf);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Float> extractHeartRateList(List<WorkoutRawData4WorkoutDetailDisplay> rawDataList) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = rawDataList.iterator();
        while (it.hasNext()) {
            Double nowHr = ((WorkoutRawData4WorkoutDetailDisplay) it.next()).getNowHr();
            Float fValueOf = nowHr != null ? Float.valueOf((float) nowHr.doubleValue()) : null;
            if (fValueOf != null) {
                arrayList.add(fValueOf);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Float> extractInclineList(List<WorkoutRawData4WorkoutDetailDisplay> rawDataList) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = rawDataList.iterator();
        while (it.hasNext()) {
            Double nowIncline = ((WorkoutRawData4WorkoutDetailDisplay) it.next()).getNowIncline();
            Float fValueOf = nowIncline != null ? Float.valueOf((float) nowIncline.doubleValue()) : null;
            if (fValueOf != null) {
                arrayList.add(fValueOf);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Float> extractResistanceList(List<WorkoutRawData4WorkoutDetailDisplay> rawDataList) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = rawDataList.iterator();
        while (it.hasNext()) {
            Float fValueOf = ((WorkoutRawData4WorkoutDetailDisplay) it.next()).getNowLevel() != null ? Float.valueOf(r1.intValue()) : null;
            if (fValueOf != null) {
                arrayList.add(fValueOf);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Float> extractRpmList(List<WorkoutRawData4WorkoutDetailDisplay> rawDataList) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = rawDataList.iterator();
        while (it.hasNext()) {
            Double avgRpm = ((WorkoutRawData4WorkoutDetailDisplay) it.next()).getAvgRpm();
            Float fValueOf = avgRpm != null ? Float.valueOf((float) avgRpm.doubleValue()) : null;
            if (fValueOf != null) {
                arrayList.add(fValueOf);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Float> extractSpmRowerList(List<WorkoutRawData4WorkoutDetailDisplay> rawDataList) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = rawDataList.iterator();
        while (it.hasNext()) {
            Double avgSpmRower = ((WorkoutRawData4WorkoutDetailDisplay) it.next()).getAvgSpmRower();
            Float fValueOf = avgSpmRower != null ? Float.valueOf((float) avgSpmRower.doubleValue()) : null;
            if (fValueOf != null) {
                arrayList.add(fValueOf);
            }
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final List<Float> extractSpmStepperList(List<WorkoutRawData4WorkoutDetailDisplay> rawDataList) {
        ArrayList arrayList = new ArrayList();
        Iterator<T> it = rawDataList.iterator();
        while (it.hasNext()) {
            Double curSpmStepper = ((WorkoutRawData4WorkoutDetailDisplay) it.next()).getCurSpmStepper();
            Float fValueOf = curSpmStepper != null ? Float.valueOf((float) curSpmStepper.doubleValue()) : null;
            if (fValueOf != null) {
                arrayList.add(fValueOf);
            }
        }
        return arrayList;
    }
}
