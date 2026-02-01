package com.soletreadmills.sole_v2.ui.classes;

import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.ButtonKt;
import androidx.compose.material.IconButtonKt;
import androidx.compose.material.IconKt;
import androidx.compose.material.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.res.ColorResources_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.club.DisplaySelectStatsData;
import com.soletreadmills.sole_v2._manager.AudioManagerHolder;
import com.soletreadmills.sole_v2._manager.AudioPlayerManager;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2._manager.ChangeViewManager;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import com.soletreadmills.sole_v2._type.DisplayStatsType;
import com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui._base.EmptyViewBinding;
import com.soletreadmills.sole_v2.ui.classes.VideoModeFragment;
import com.soletreadmills.sole_v2.ui.customview.DisplayStatsSelectCustom;
import io.ktor.http.ContentDisposition;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.LazyThreadSafetyMode;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import no.nordicsemi.android.ble.data.Data;

/* compiled from: VideoModeFragment.kt */
@Metadata(d1 = {"\u0000¤\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010 \b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J3\u0010\f\u001a\u00020\r2\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u0013JW\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\u00162\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\r0\u00182\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\r0\u00182\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u00182\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\r0\u00182\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010\u001cJ9\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0012\u0010$\u001a\u000e\u0012\u0004\u0012\u00020!\u0012\u0004\u0012\u00020\r0\u000fH\u0007¢\u0006\u0002\u0010%JQ\u0010&\u001a\u00020\r2\u0006\u0010'\u001a\u00020\u00162\u0006\u0010\u0006\u001a\u00020\u00072\f\u0010(\u001a\b\u0012\u0004\u0012\u00020\r0\u00182\f\u0010)\u001a\b\u0012\u0004\u0012\u00020\r0\u00182\f\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0\u00182\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010+JM\u0010,\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u00182\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u0002002\b\b\u0002\u0010\u0011\u001a\u00020\u00122\u0011\u00101\u001a\r\u0012\u0004\u0012\u00020\r0\u0018¢\u0006\u0002\b2H\u0007ø\u0001\u0000¢\u0006\u0004\b3\u00104J\u007f\u00105\u001a\u00020\r2\u0006\u00106\u001a\u00020\u001f2\u0006\u00107\u001a\u00020\u001f2\u0006\u0010\u0006\u001a\u00020\u00072\b\u00108\u001a\u0004\u0018\u0001092\u000e\b\u0002\u0010:\u001a\b\u0012\u0004\u0012\u00020\r0\u00182\u000e\b\u0002\u0010;\u001a\b\u0012\u0004\u0012\u00020\r0\u00182\u000e\b\u0002\u0010*\u001a\b\u0012\u0004\u0012\u00020\r0\u00182\u0014\b\u0002\u0010<\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\r0\u000f2\b\u0010=\u001a\u0004\u0018\u00010>H\u0007¢\u0006\u0002\u0010?JK\u0010@\u001a\u00020\r2\u0006\u0010A\u001a\u00020\u001f2\u0006\u0010B\u001a\u00020\u001f2\u0006\u0010C\u001a\u00020D2\u0006\u0010E\u001a\u00020\u00162\u0012\u0010F\u001a\u000e\u0012\u0004\u0012\u00020D\u0012\u0004\u0012\u00020\r0\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u0012H\u0007¢\u0006\u0002\u0010GJ\u001a\u0010H\u001a\u00020\u00022\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\b\u0010M\u001a\u00020\rH\u0016J\u0012\u0010N\u001a\u00020\r2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J$\u0010Q\u001a\u00020R2\u0006\u0010I\u001a\u00020J2\b\u0010K\u001a\u0004\u0018\u00010L2\b\u0010O\u001a\u0004\u0018\u00010PH\u0016J\b\u0010S\u001a\u00020\rH\u0016J\b\u0010T\u001a\u00020\rH\u0016J\b\u0010U\u001a\u00020\rH\u0016J\b\u0010V\u001a\u00020\rH\u0016J\u000e\u0010W\u001a\u00020\r2\u0006\u0010X\u001a\u00020\u0010R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\t\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006Y²\u0006\n\u0010E\u001a\u00020\u0016X\u008a\u008e\u0002²\u0006\u0010\u0010 \u001a\b\u0012\u0004\u0012\u00020!0ZX\u008a\u0084\u0002"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/classes/VideoModeFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/EmptyViewBinding;", "()V", "prefs", "Lcom/soletreadmills/sole_v2/_sharedPreferences/MySharedPreferences;", "viewModel", "Lcom/soletreadmills/sole_v2/ui/classes/VideoModeViewModel;", "getViewModel", "()Lcom/soletreadmills/sole_v2/ui/classes/VideoModeViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "InfoView", "", SdkConstants.ATTR_ON_CLICK, "Lkotlin/Function1;", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/soletreadmills/sole_v2/ui/classes/VideoModeViewModel;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "StartAndPauseView", "isVideoPlay", "", "onPlayPauseClick", "Lkotlin/Function0;", "onSeekBackward", "onSeekForward", "onBackgroundClick", "(ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "StatsItemView", "value", "", "data", "Lcom/soletreadmills/sole_v2/_data/club/DisplaySelectStatsData;", "alignment", "Landroidx/compose/ui/Alignment$Horizontal;", "onTap", "(Ljava/lang/String;Lcom/soletreadmills/sole_v2/_data/club/DisplaySelectStatsData;Landroidx/compose/ui/Alignment$Horizontal;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "TopView", "isLandscape", "onFinishClick", "onVideoSettingClick", "onWatchClick", "(ZLcom/soletreadmills/sole_v2/ui/classes/VideoModeViewModel;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "VideoControlButton", ContentDisposition.Parameters.Size, "Landroidx/compose/ui/unit/Dp;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "content", "Landroidx/compose/runtime/Composable;", "VideoControlButton-Ou1YvPQ", "(Lkotlin/jvm/functions/Function0;FJLandroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "VideoModeScreen", "classId", "videoId", "audioManager", "Lcom/soletreadmills/sole_v2/_manager/AudioPlayerManager;", "onNavigateToSettings", "onFinish", "onInfoClick", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "(Ljava/lang/String;Ljava/lang/String;Lcom/soletreadmills/sole_v2/ui/classes/VideoModeViewModel;Lcom/soletreadmills/sole_v2/_manager/AudioPlayerManager;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroid/content/Context;Landroidx/compose/runtime/Composer;II)V", "VideoProgressBarView", "videoStartTime", "videoTotalTime", "videoProgress", "", "showControls", "onProgressChange", "(Ljava/lang/String;Ljava/lang/String;FZLkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "onDestroy", "onDestroyView", "onPause", "onResume", "openSelectDisplayStatsView", "pos", "app_release", ""}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class VideoModeFragment extends BaseFragment<EmptyViewBinding> {
    public static final int $stable = 8;
    private final MySharedPreferences prefs;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;

    /* compiled from: VideoModeFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[DisplayStatsType.values().length];
            try {
                iArr[DisplayStatsType.TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[DisplayStatsType.REMAINING_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[DisplayStatsType.DISTANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[DisplayStatsType.SPEED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[DisplayStatsType.PACE.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[DisplayStatsType.AVG_PACE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr[DisplayStatsType.HEART_RATE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr[DisplayStatsType.INCLINE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr[DisplayStatsType.CALORIES.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr[DisplayStatsType.METS.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr[DisplayStatsType.ASCENT.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr[DisplayStatsType.OUTPUT.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr[DisplayStatsType.RESISTANCE.ordinal()] = 13;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr[DisplayStatsType.CADENCE.ordinal()] = 14;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr[DisplayStatsType.STRIDES.ordinal()] = 15;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr[DisplayStatsType.AVG_SPEED.ordinal()] = 16;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr[DisplayStatsType.AVG_CADENCE.ordinal()] = 17;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr[DisplayStatsType.STROKES.ordinal()] = 18;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr[DisplayStatsType.FLOORS.ordinal()] = 19;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr[DisplayStatsType.STEPS.ordinal()] = 20;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr[DisplayStatsType.CALORIES_PER_MIN.ordinal()] = 21;
            } catch (NoSuchFieldError unused21) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public VideoModeFragment() {
        final VideoModeFragment videoModeFragment = this;
        final Function0<Fragment> function0 = new Function0<Fragment>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Fragment invoke() {
                return videoModeFragment;
            }
        };
        final Lazy lazy = LazyKt.lazy(LazyThreadSafetyMode.NONE, (Function0) new Function0<ViewModelStoreOwner>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStoreOwner invoke() {
                return (ViewModelStoreOwner) function0.invoke();
            }
        });
        final Function0 function02 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(videoModeFragment, Reflection.getOrCreateKotlinClass(VideoModeViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$special$$inlined$viewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return FragmentViewModelLazyKt.m7569viewModels$lambda1(lazy).getViewModelStore();
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$special$$inlined$viewModels$default$4
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function03 = function02;
                if (function03 != null && (creationExtras = (CreationExtras) function03.invoke()) != null) {
                    return creationExtras;
                }
                ViewModelStoreOwner viewModelStoreOwnerM7569viewModels$lambda1 = FragmentViewModelLazyKt.m7569viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM7569viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM7569viewModels$lambda1 : null;
                return hasDefaultViewModelProviderFactory != null ? hasDefaultViewModelProviderFactory.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$special$$inlined$viewModels$default$5
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory;
                ViewModelStoreOwner viewModelStoreOwnerM7569viewModels$lambda1 = FragmentViewModelLazyKt.m7569viewModels$lambda1(lazy);
                HasDefaultViewModelProviderFactory hasDefaultViewModelProviderFactory = viewModelStoreOwnerM7569viewModels$lambda1 instanceof HasDefaultViewModelProviderFactory ? (HasDefaultViewModelProviderFactory) viewModelStoreOwnerM7569viewModels$lambda1 : null;
                if (hasDefaultViewModelProviderFactory != null && (defaultViewModelProviderFactory = hasDefaultViewModelProviderFactory.getDefaultViewModelProviderFactory()) != null) {
                    return defaultViewModelProviderFactory;
                }
                ViewModelProvider.Factory defaultViewModelProviderFactory2 = videoModeFragment.getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory2, "defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory2;
            }
        });
        this.prefs = MySharedPreferences.INSTANCE.getInstance();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final VideoModeViewModel getViewModel() {
        return (VideoModeViewModel) this.viewModel.getValue();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public EmptyViewBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        return new EmptyViewBinding();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        BleManager bleManager;
        FtmsDeviceManager ftmsDeviceManager;
        BleManager bleManager2;
        BleManager bleManager3;
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null && (bleManager3 = mainActivity.getBleManager()) != null) {
            bleManager3.removeBluetoothCallbackListener(getViewModel().getBluetoothCallbackListener());
        }
        MainActivity mainActivity2 = getMainActivity();
        if (mainActivity2 != null && (bleManager2 = mainActivity2.getBleManager()) != null) {
            bleManager2.addBluetoothCallbackListener(getViewModel().getBluetoothCallbackListener());
        }
        VideoModeViewModel viewModel = getViewModel();
        MainActivity mainActivity3 = getMainActivity();
        viewModel.setBleFtmsMachineType((mainActivity3 == null || (bleManager = mainActivity3.getBleManager()) == null || (ftmsDeviceManager = bleManager.getFtmsDeviceManager()) == null) ? null : ftmsDeviceManager.getBleFtmsMachineType());
        getViewModel().loadStatsForMachine(getViewModel().getBleFtmsMachineType());
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("classID") : null;
        VideoModeViewModel viewModel = getViewModel();
        if (string == null) {
            string = "";
        }
        viewModel.setClassId(string);
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString("videoID") : null;
        getViewModel().setVideoId(string2 != null ? string2 : "");
        AudioManagerHolder audioManagerHolder = AudioManagerHolder.INSTANCE;
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        audioManagerHolder.initialize(contextRequireContext);
        AudioPlayerManager audioPlayerManager = AudioManagerHolder.INSTANCE.get();
        if (audioPlayerManager != null) {
            audioPlayerManager.setVolume(this.prefs.getMusicVolume());
        }
        VideoPlayerHolder videoPlayerHolder = VideoPlayerHolder.INSTANCE;
        Context contextRequireContext2 = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
        videoPlayerHolder.initialize(contextRequireContext2);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        Window window;
        super.onResume();
        FragmentActivity activity = getActivity();
        if (activity != null && (window = activity.getWindow()) != null) {
            window.addFlags(128);
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C08981(null), 3, null);
        getViewModel().updateHrConnectionStatus();
        AudioPlayerManager audioPlayerManager = AudioManagerHolder.INSTANCE.get();
        if (audioPlayerManager != null) {
            audioPlayerManager.setVolume(this.prefs.getMusicVolume());
        }
    }

    /* compiled from: VideoModeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onResume$1", f = "VideoModeFragment.kt", i = {}, l = {121}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onResume$1, reason: invalid class name and case insensitive filesystem */
    static final class C08981 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08981(Continuation<? super C08981> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return VideoModeFragment.this.new C08981(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08981) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (VideoModeFragment.this.getViewModel().refreshSubtitlesState(this) == coroutine_suspended) {
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

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        Window window;
        super.onPause();
        FragmentActivity activity = getActivity();
        if (activity == null || (window = activity.getWindow()) == null) {
            return;
        }
        window.clearFlags(128);
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        BleManager bleManager;
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null && (bleManager = mainActivity.getBleManager()) != null) {
            bleManager.removeBluetoothCallbackListener(getViewModel().getBluetoothCallbackListener());
        }
        super.onDestroyView();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Log.d("VideoModeFragment", "onDestroy - 釋放資源");
        AudioManagerHolder.INSTANCE.release();
        VideoPlayerHolder.INSTANCE.release();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        Context contextRequireContext = requireContext();
        Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
        ComposeView composeView = new ComposeView(contextRequireContext, null, 0, 6, null);
        composeView.setContent(ComposableLambdaKt.composableLambdaInstance(447015947, true, new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1
            {
                super(2);
            }

            /* compiled from: VideoModeFragment.kt */
            @Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1$2, reason: invalid class name */
            static final class AnonymousClass2 extends Lambda implements Function0<Unit> {
                final /* synthetic */ VideoModeFragment this$0;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                AnonymousClass2(VideoModeFragment videoModeFragment) {
                    super(0);
                    this.this$0 = videoModeFragment;
                }

                /* JADX INFO: Access modifiers changed from: private */
                public static final void invoke$lambda$2(DialogInterface dialogInterface, int i) {
                }

                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    MainActivity mainActivity = this.this$0.getMainActivity();
                    if (mainActivity != null) {
                        MainActivity mainActivity2 = mainActivity;
                        String string = this.this$0.getString(R.string.save_record);
                        String string2 = BleManager.getInstance().isConnectedFtms() ? this.this$0.getString(R.string.save_record_connect) : this.this$0.getString(R.string.save_record_unconnect);
                        String string3 = this.this$0.getString(R.string.save_edit);
                        final VideoModeFragment videoModeFragment = this.this$0;
                        DialogInterface.OnClickListener onClickListener = 
                        /*  JADX ERROR: Method code generation error
                            jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0043: CONSTRUCTOR (r5v0 'onClickListener' android.content.DialogInterface$OnClickListener) = (r0v11 'videoModeFragment' com.soletreadmills.sole_v2.ui.classes.VideoModeFragment A[DONT_INLINE]) A[DECLARE_VAR, MD:(com.soletreadmills.sole_v2.ui.classes.VideoModeFragment):void (m)] call: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1$2$$ExternalSyntheticLambda0.<init>(com.soletreadmills.sole_v2.ui.classes.VideoModeFragment):void type: CONSTRUCTOR in method: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1.2.invoke():void, file: classes5.dex
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.RegionGen.makeRegionIndent(RegionGen.java:83)
                            	at jadx.core.codegen.RegionGen.makeIf(RegionGen.java:126)
                            	at jadx.core.dex.regions.conditions.IfRegion.generate(IfRegion.java:90)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:298)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:277)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:410)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:297)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:286)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:270)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:161)
                            	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:310)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:297)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:286)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:845)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                            	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                            	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                            	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                            	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                            	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                            	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.dex.regions.Region.generate(Region.java:35)
                            	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                            	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:298)
                            	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:277)
                            	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:410)
                            	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:335)
                            	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:301)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                            	at java.base/java.util.ArrayList.forEach(ArrayList.java:1604)
                            	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                            	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                            	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                            	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                            	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                            	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                            	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                            	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                            	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:297)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:286)
                            	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:270)
                            	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:161)
                            	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:103)
                            	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                            	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                            	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                            	at jadx.core.ProcessClass.process(ProcessClass.java:79)
                            	at jadx.core.ProcessClass.generateCode(ProcessClass.java:117)
                            	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:403)
                            	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:391)
                            	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:341)
                            Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1$2$$ExternalSyntheticLambda0, state: NOT_LOADED
                            	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                            	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                            	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                            	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                            	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                            	... 100 more
                            */
                        /*
                            this = this;
                            com.soletreadmills.sole_v2.ui.classes.VideoModeFragment r0 = r15.this$0
                            com.soletreadmills.sole_v2.ui.MainActivity r0 = r0.getMainActivity()
                            if (r0 == 0) goto L71
                            r1 = r0
                            com.soletreadmills.sole_v2.ui._base.BaseActivity r1 = (com.soletreadmills.sole_v2.ui._base.BaseActivity) r1
                            com.soletreadmills.sole_v2.ui.classes.VideoModeFragment r0 = r15.this$0
                            int r2 = com.soletreadmills.sole_v2.R.string.save_record
                            java.lang.String r0 = r0.getString(r2)
                            r2 = r0
                            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
                            com.soletreadmills.sole_v2._manager.BleManager r0 = com.soletreadmills.sole_v2._manager.BleManager.getInstance()
                            boolean r0 = r0.isConnectedFtms()
                            if (r0 == 0) goto L29
                            com.soletreadmills.sole_v2.ui.classes.VideoModeFragment r0 = r15.this$0
                            int r3 = com.soletreadmills.sole_v2.R.string.save_record_connect
                            java.lang.String r0 = r0.getString(r3)
                            goto L31
                        L29:
                            com.soletreadmills.sole_v2.ui.classes.VideoModeFragment r0 = r15.this$0
                            int r3 = com.soletreadmills.sole_v2.R.string.save_record_unconnect
                            java.lang.String r0 = r0.getString(r3)
                        L31:
                            r3 = r0
                            java.lang.CharSequence r3 = (java.lang.CharSequence) r3
                            com.soletreadmills.sole_v2.ui.classes.VideoModeFragment r0 = r15.this$0
                            int r4 = com.soletreadmills.sole_v2.R.string.save_edit
                            java.lang.String r0 = r0.getString(r4)
                            r4 = r0
                            java.lang.CharSequence r4 = (java.lang.CharSequence) r4
                            com.soletreadmills.sole_v2.ui.classes.VideoModeFragment r0 = r15.this$0
                            com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1$2$$ExternalSyntheticLambda0 r5 = new com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1$2$$ExternalSyntheticLambda0
                            r5.<init>(r0)
                            com.soletreadmills.sole_v2.ui.classes.VideoModeFragment r0 = r15.this$0
                            int r6 = com.soletreadmills.sole_v2.R.string.just_edit
                            java.lang.String r0 = r0.getString(r6)
                            r6 = r0
                            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
                            com.soletreadmills.sole_v2.ui.classes.VideoModeFragment r0 = r15.this$0
                            com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1$2$$ExternalSyntheticLambda1 r7 = new com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1$2$$ExternalSyntheticLambda1
                            r7.<init>(r0)
                            com.soletreadmills.sole_v2.ui.classes.VideoModeFragment r0 = r15.this$0
                            int r8 = com.soletreadmills.sole_v2.R.string.cancel
                            java.lang.String r0 = r0.getString(r8)
                            r8 = r0
                            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
                            com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1$2$$ExternalSyntheticLambda2 r9 = new com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1$2$$ExternalSyntheticLambda2
                            r9.<init>()
                            r13 = 1792(0x700, float:2.511E-42)
                            r14 = 0
                            r10 = 0
                            r11 = 0
                            r12 = 0
                            com.soletreadmills.sole_v2.ui._base.BaseActivity.showBaseDialog$default(r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11, r12, r13, r14)
                        L71:
                            return
                        */
                        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1.AnonymousClass2.invoke2():void");
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void invoke$lambda$0(VideoModeFragment this$0, DialogInterface dialogInterface, int i) {
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), null, null, new VideoModeFragment$onCreateView$1$1$2$1$1(this$0, null), 3, null);
                    }

                    /* JADX INFO: Access modifiers changed from: private */
                    public static final void invoke$lambda$1(VideoModeFragment this$0, DialogInterface dialogInterface, int i) {
                        Intrinsics.checkNotNullParameter(this$0, "this$0");
                        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this$0), null, null, new VideoModeFragment$onCreateView$1$1$2$2$1(this$0, null), 3, null);
                        this$0.requireActivity().getOnBackPressedDispatcher().onBackPressed();
                    }
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer, Integer num) throws Resources.NotFoundException {
                    invoke(composer, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer, int i) throws Resources.NotFoundException {
                    if ((i & 11) == 2 && composer.getSkipping()) {
                        composer.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(447015947, i, -1, "com.soletreadmills.sole_v2.ui.classes.VideoModeFragment.onCreateView.<anonymous>.<anonymous> (VideoModeFragment.kt:157)");
                    }
                    VideoModeFragment videoModeFragment = this.this$0;
                    String classId = videoModeFragment.getViewModel().getClassId();
                    String videoId = this.this$0.getViewModel().getVideoId();
                    VideoModeViewModel viewModel = this.this$0.getViewModel();
                    AudioPlayerManager audioPlayerManager = AudioManagerHolder.INSTANCE.get();
                    final VideoModeFragment videoModeFragment2 = this.this$0;
                    Function0<Unit> function0 = new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1.1
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
                            BaseFragment.safeNavigate$default(videoModeFragment2, R.id.videoSettingsFragment, null, 2, null);
                        }
                    };
                    AnonymousClass2 anonymousClass2 = new AnonymousClass2(this.this$0);
                    final VideoModeFragment videoModeFragment3 = this.this$0;
                    Function0<Unit> function02 = new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1.3
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
                            BaseFragment.safeNavigate$default(videoModeFragment3, R.id.heartRateMonitorFragment, null, 2, null);
                        }
                    };
                    final VideoModeFragment videoModeFragment4 = this.this$0;
                    videoModeFragment.VideoModeScreen(classId, videoId, viewModel, audioPlayerManager, function0, anonymousClass2, function02, new Function1<Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$onCreateView$1$1.4
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Integer num) {
                            invoke(num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(int i2) {
                            videoModeFragment4.openSelectDisplayStatsView(i2);
                        }
                    }, this.this$0.getMainActivity(), composer, 1207964160, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }));
            return composeView;
        }

        public final void openSelectDisplayStatsView(int pos) {
            ChangeViewManager changeViewManager;
            getViewModel().updateSelection(pos);
            getViewModel().getStatsList();
            MainActivity mainActivity = getMainActivity();
            if (mainActivity == null || (changeViewManager = mainActivity.getChangeViewManager()) == null) {
                return;
            }
            MainActivity mainActivity2 = getMainActivity();
            Intrinsics.checkNotNull(mainActivity2);
            String string = getString(R.string.select_parameter);
            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
            changeViewManager.changePage(new DisplayStatsSelectCustom(mainActivity2, string, getViewModel().getStatsList().getValue(), new DisplayStatsSelectCustom.BottomDialogCustomListener() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment.openSelectDisplayStatsView.1
                @Override // com.soletreadmills.sole_v2.ui.customview.DisplayStatsSelectCustom.BottomDialogCustomListener
                public void onClick(int pos2, DisplayStatsType newType) {
                    Intrinsics.checkNotNullParameter(newType, "newType");
                    VideoModeFragment.this.getViewModel().updateSelectionWithNewType(newType);
                }
            }));
        }

        /* JADX WARN: Removed duplicated region for block: B:82:0x0501  */
        /* JADX WARN: Removed duplicated region for block: B:83:0x0503  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void VideoModeScreen(final java.lang.String r44, final java.lang.String r45, final com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel r46, final com.soletreadmills.sole_v2._manager.AudioPlayerManager r47, kotlin.jvm.functions.Function0<kotlin.Unit> r48, kotlin.jvm.functions.Function0<kotlin.Unit> r49, kotlin.jvm.functions.Function0<kotlin.Unit> r50, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r51, final android.content.Context r52, androidx.compose.runtime.Composer r53, final int r54, final int r55) throws android.content.res.Resources.NotFoundException {
            /*
                Method dump skipped, instructions count: 1384
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment.VideoModeScreen(java.lang.String, java.lang.String, com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel, com.soletreadmills.sole_v2._manager.AudioPlayerManager, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function1, android.content.Context, androidx.compose.runtime.Composer, int, int):void");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final boolean VideoModeScreen$lambda$2(MutableState<Boolean> mutableState) {
            return mutableState.getValue().booleanValue();
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void VideoModeScreen$lambda$3(MutableState<Boolean> mutableState, boolean z) {
            mutableState.setValue(Boolean.valueOf(z));
        }

        /* compiled from: VideoModeFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$VideoModeScreen$5", f = "VideoModeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$VideoModeScreen$5, reason: invalid class name */
        static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ int $orientation;
            final /* synthetic */ VideoModeViewModel $viewModel;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass5(VideoModeViewModel videoModeViewModel, int i, Continuation<? super AnonymousClass5> continuation) {
                super(2, continuation);
                this.$viewModel = videoModeViewModel;
                this.$orientation = i;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass5(this.$viewModel, this.$orientation, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                this.$viewModel.updateOrientation(this.$orientation == 2);
                return Unit.INSTANCE;
            }
        }

        /* compiled from: VideoModeFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$VideoModeScreen$6", f = "VideoModeFragment.kt", i = {}, l = {287, Data.FORMAT_SINT32_BE}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$VideoModeScreen$6, reason: invalid class name */
        static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ AudioPlayerManager $audioManager;
            final /* synthetic */ String $classId;
            final /* synthetic */ String $videoId;
            final /* synthetic */ VideoPlayerController $videoPlayerController;
            final /* synthetic */ VideoModeViewModel $viewModel;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass6(VideoModeViewModel videoModeViewModel, String str, String str2, AudioPlayerManager audioPlayerManager, VideoPlayerController videoPlayerController, Continuation<? super AnonymousClass6> continuation) {
                super(2, continuation);
                this.$viewModel = videoModeViewModel;
                this.$classId = str;
                this.$videoId = str2;
                this.$audioManager = audioPlayerManager;
                this.$videoPlayerController = videoPlayerController;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass6(this.$viewModel, this.$classId, this.$videoId, this.$audioManager, this.$videoPlayerController, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Removed duplicated region for block: B:20:0x006a  */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct add '--show-bad-code' argument
            */
            public final java.lang.Object invokeSuspend(java.lang.Object r6) {
                /*
                    r5 = this;
                    java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                    int r1 = r5.label
                    r2 = 2
                    r3 = 1
                    if (r1 == 0) goto L1e
                    if (r1 == r3) goto L1a
                    if (r1 != r2) goto L12
                    kotlin.ResultKt.throwOnFailure(r6)
                    goto L62
                L12:
                    java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
                    java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
                    r6.<init>(r0)
                    throw r6
                L1a:
                    kotlin.ResultKt.throwOnFailure(r6)
                    goto L45
                L1e:
                    kotlin.ResultKt.throwOnFailure(r6)
                    com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel r6 = r5.$viewModel
                    boolean r6 = r6.getIsDataLoaded()
                    if (r6 != 0) goto L98
                    com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel r6 = r5.$viewModel
                    java.lang.String r1 = r5.$classId
                    r6.setClassId(r1)
                    com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel r6 = r5.$viewModel
                    java.lang.String r1 = r5.$videoId
                    r6.setVideoId(r1)
                    com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel r6 = r5.$viewModel
                    r1 = r5
                    kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                    r5.label = r3
                    java.lang.Object r6 = r6.apiGetClassVideo(r1)
                    if (r6 != r0) goto L45
                    return r0
                L45:
                    com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$VideoModeScreen$6$1 r6 = new com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$VideoModeScreen$6$1
                    com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel r1 = r5.$viewModel
                    r6.<init>()
                    kotlin.jvm.functions.Function0 r6 = (kotlin.jvm.functions.Function0) r6
                    kotlinx.coroutines.flow.Flow r6 = androidx.compose.runtime.SnapshotStateKt.snapshotFlow(r6)
                    kotlinx.coroutines.flow.Flow r6 = kotlinx.coroutines.flow.FlowKt.filterNotNull(r6)
                    r1 = r5
                    kotlin.coroutines.Continuation r1 = (kotlin.coroutines.Continuation) r1
                    r5.label = r2
                    java.lang.Object r6 = kotlinx.coroutines.flow.FlowKt.first(r6, r1)
                    if (r6 != r0) goto L62
                    return r0
                L62:
                    com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel r6 = r5.$viewModel
                    com.soletreadmills.sole_v2._data.classes.VideoDetailData r6 = r6.getVideoDetailData()
                    if (r6 == 0) goto L93
                    com.soletreadmills.sole_v2._manager.AudioPlayerManager r0 = r5.$audioManager
                    com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel r1 = r5.$viewModel
                    com.soletreadmills.sole_v2.ui.classes.VideoPlayerController r2 = r5.$videoPlayerController
                    java.util.List r6 = r6.getSongsUriList()
                    r4 = r6
                    java.util.Collection r4 = (java.util.Collection) r4
                    boolean r4 = r4.isEmpty()
                    if (r4 != 0) goto L93
                    if (r0 == 0) goto L82
                    r0.setPlaylist(r6)
                L82:
                    if (r0 == 0) goto L87
                    r0.playPlaylist()
                L87:
                    com.soletreadmills.sole_v2.ui.classes.VideoPlayerHolder r6 = com.soletreadmills.sole_v2.ui.classes.VideoPlayerHolder.INSTANCE
                    com.soletreadmills.sole_v2.ui.classes.CookieData r0 = r1.getCookieData()
                    kotlin.jvm.internal.Intrinsics.checkNotNull(r0)
                    r6.prepare(r0, r2)
                L93:
                    com.soletreadmills.sole_v2.ui.classes.VideoModeViewModel r6 = r5.$viewModel
                    r6.setDataLoaded(r3)
                L98:
                    kotlin.Unit r6 = kotlin.Unit.INSTANCE
                    return r6
                */
                throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment.AnonymousClass6.invokeSuspend(java.lang.Object):java.lang.Object");
            }
        }

        /* compiled from: VideoModeFragment.kt */
        @Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n¢\u0006\u0002\b\u0003"}, d2 = {"<anonymous>", "Landroidx/compose/runtime/DisposableEffectResult;", "Landroidx/compose/runtime/DisposableEffectScope;", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
        /* renamed from: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$VideoModeScreen$7, reason: invalid class name */
        static final class AnonymousClass7 extends Lambda implements Function1<DisposableEffectScope, DisposableEffectResult> {
            final /* synthetic */ LifecycleOwner $lifecycleOwner;
            final /* synthetic */ VideoModeViewModel $viewModel;
            final /* synthetic */ VideoModeFragment this$0;

            /* compiled from: VideoModeFragment.kt */
            @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
            /* renamed from: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$VideoModeScreen$7$WhenMappings */
            public /* synthetic */ class WhenMappings {
                public static final /* synthetic */ int[] $EnumSwitchMapping$0;

                static {
                    int[] iArr = new int[Lifecycle.Event.values().length];
                    try {
                        iArr[Lifecycle.Event.ON_START.ordinal()] = 1;
                    } catch (NoSuchFieldError unused) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_RESUME.ordinal()] = 2;
                    } catch (NoSuchFieldError unused2) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_STOP.ordinal()] = 3;
                    } catch (NoSuchFieldError unused3) {
                    }
                    try {
                        iArr[Lifecycle.Event.ON_PAUSE.ordinal()] = 4;
                    } catch (NoSuchFieldError unused4) {
                    }
                    $EnumSwitchMapping$0 = iArr;
                }
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass7(LifecycleOwner lifecycleOwner, VideoModeFragment videoModeFragment, VideoModeViewModel videoModeViewModel) {
                super(1);
                this.$lifecycleOwner = lifecycleOwner;
                this.this$0 = videoModeFragment;
                this.$viewModel = videoModeViewModel;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void invoke$lambda$0(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                Intrinsics.checkNotNullParameter(lifecycleOwner, "<anonymous parameter 0>");
                Intrinsics.checkNotNullParameter(event, "event");
                int i = WhenMappings.$EnumSwitchMapping$0[event.ordinal()];
                if (i == 1 || i == 2) {
                    Log.d("VideoModeFragment", "ON_START - 恢復播放");
                } else if (i == 3 || i == 4) {
                    Log.d("VideoModeFragment", "ON_PAUSE - 暫停播放");
                }
            }

            @Override // kotlin.jvm.functions.Function1
            public final DisposableEffectResult invoke(DisposableEffectScope DisposableEffect) {
                Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
                final LifecycleEventObserver lifecycleEventObserver = new LifecycleEventObserver() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$VideoModeScreen$7$$ExternalSyntheticLambda0
                    @Override // androidx.lifecycle.LifecycleEventObserver
                    public final void onStateChanged(LifecycleOwner lifecycleOwner, Lifecycle.Event event) {
                        VideoModeFragment.AnonymousClass7.invoke$lambda$0(lifecycleOwner, event);
                    }
                };
                this.$lifecycleOwner.getLifecycle().addObserver(lifecycleEventObserver);
                final LifecycleOwner lifecycleOwner = this.$lifecycleOwner;
                final VideoModeFragment videoModeFragment = this.this$0;
                final VideoModeViewModel videoModeViewModel = this.$viewModel;
                return new DisposableEffectResult() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$VideoModeScreen$7$invoke$$inlined$onDispose$1
                    @Override // androidx.compose.runtime.DisposableEffectResult
                    public void dispose() {
                        lifecycleOwner.getLifecycle().removeObserver(lifecycleEventObserver);
                        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(videoModeFragment), null, null, new VideoModeFragment$VideoModeScreen$7$1$1(videoModeViewModel, null), 3, null);
                    }
                };
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:101:0x0241  */
        /* JADX WARN: Removed duplicated region for block: B:104:0x0268  */
        /* JADX WARN: Removed duplicated region for block: B:105:0x026d  */
        /* JADX WARN: Removed duplicated region for block: B:108:0x031a  */
        /* JADX WARN: Removed duplicated region for block: B:112:0x0325  */
        /* JADX WARN: Removed duplicated region for block: B:114:? A[RETURN, SYNTHETIC] */
        /* JADX WARN: Removed duplicated region for block: B:70:0x00d2  */
        /* JADX WARN: Removed duplicated region for block: B:71:0x00d4  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x00da  */
        /* JADX WARN: Removed duplicated region for block: B:75:0x00e1  */
        /* JADX WARN: Removed duplicated region for block: B:77:0x00e9  */
        /* JADX WARN: Removed duplicated region for block: B:78:0x00ed  */
        /* JADX WARN: Removed duplicated region for block: B:81:0x0142  */
        /* JADX WARN: Removed duplicated region for block: B:84:0x014e  */
        /* JADX WARN: Removed duplicated region for block: B:85:0x0152  */
        /* JADX WARN: Removed duplicated region for block: B:90:0x0185  */
        /* JADX WARN: Removed duplicated region for block: B:93:0x022c  */
        /* JADX WARN: Removed duplicated region for block: B:94:0x022e  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void VideoProgressBarView(final java.lang.String r37, final java.lang.String r38, final float r39, final boolean r40, final kotlin.jvm.functions.Function1<? super java.lang.Float, kotlin.Unit> r41, androidx.compose.ui.Modifier r42, androidx.compose.runtime.Composer r43, final int r44, final int r45) {
            /*
                Method dump skipped, instructions count: 833
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment.VideoProgressBarView(java.lang.String, java.lang.String, float, boolean, kotlin.jvm.functions.Function1, androidx.compose.ui.Modifier, androidx.compose.runtime.Composer, int, int):void");
        }

        public final void StartAndPauseView(final boolean z, final Function0<Unit> onPlayPauseClick, final Function0<Unit> onSeekBackward, final Function0<Unit> onSeekForward, final Function0<Unit> onBackgroundClick, Modifier modifier, Composer composer, final int i, final int i2) {
            String str;
            String str2;
            long jM4537copywmQWz5c$default;
            Intrinsics.checkNotNullParameter(onPlayPauseClick, "onPlayPauseClick");
            Intrinsics.checkNotNullParameter(onSeekBackward, "onSeekBackward");
            Intrinsics.checkNotNullParameter(onSeekForward, "onSeekForward");
            Intrinsics.checkNotNullParameter(onBackgroundClick, "onBackgroundClick");
            Composer composerStartRestartGroup = composer.startRestartGroup(1822512586);
            final Modifier.Companion companion = (i2 & 32) != 0 ? Modifier.INSTANCE : modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1822512586, i, -1, "com.soletreadmills.sole_v2.ui.classes.VideoModeFragment.StartAndPauseView (VideoModeFragment.kt:577)");
            }
            Modifier modifierM540backgroundbw27NRU$default = BackgroundKt.m540backgroundbw27NRU$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), Color.m4537copywmQWz5c$default(Color.INSTANCE.m4564getBlack0d7_KjU(), 0.7f, 0.0f, 0.0f, 0.0f, 14, null), null, 2, null);
            composerStartRestartGroup.startReplaceGroup(-1444213347);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(-1444213289);
            boolean z2 = (((57344 & i) ^ 24576) > 16384 && composerStartRestartGroup.changed(onBackgroundClick)) || (i & 24576) == 16384;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$StartAndPauseView$2$1
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
                        onBackgroundClick.invoke();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierM571clickableO2vRcR0$default = ClickableKt.m571clickableO2vRcR0$default(modifierM540backgroundbw27NRU$default, mutableInteractionSource, null, false, null, null, (Function0) objRememberedValue2, 28, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM571clickableO2vRcR0$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3857constructorimpl = Updater.m3857constructorimpl(composerStartRestartGroup);
            Updater.m3864setimpl(composerM3857constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3864setimpl(composerM3857constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3857constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3857constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3857constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3864setimpl(composerM3857constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM865spacedBy0680j_4 = Arrangement.INSTANCE.m865spacedBy0680j_4(Dp.m7255constructorimpl(16));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            Modifier.Companion companion2 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM865spacedBy0680j_4, centerHorizontally, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3857constructorimpl2 = Updater.m3857constructorimpl(composerStartRestartGroup);
            Updater.m3864setimpl(composerM3857constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3864setimpl(composerM3857constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3857constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM3857constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3857constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3864setimpl(composerM3857constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceGroup(-394192154);
            if (!z) {
                str2 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
                str = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                TextKt.m2038Text4IGK_g("Paused", (Modifier) null, Color.INSTANCE.m4575getWhite0d7_KjU(), TextUnitKt.getSp(48), (FontStyle) null, FontWeight.INSTANCE.getBlack(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 200070, 0, 131026);
            } else {
                str = "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp";
                str2 = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
            }
            composerStartRestartGroup.endReplaceGroup();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM865spacedBy0680j_42 = Arrangement.INSTANCE.m865spacedBy0680j_4(Dp.m7255constructorimpl(20));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Modifier.Companion companion3 = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM865spacedBy0680j_42, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, str2);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, str);
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3857constructorimpl3 = Updater.m3857constructorimpl(composerStartRestartGroup);
            Updater.m3864setimpl(composerM3857constructorimpl3, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3864setimpl(composerM3857constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3857constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM3857constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM3857constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3864setimpl(composerM3857constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            float f = 56;
            m8662VideoControlButtonOu1YvPQ(onSeekBackward, Dp.m7255constructorimpl(f), Color.m4537copywmQWz5c$default(Color.INSTANCE.m4568getGray0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), null, ComposableSingletons$VideoModeFragmentKt.INSTANCE.m8658getLambda1$app_release(), composerStartRestartGroup, ((i >> 6) & 14) | 287152, 8);
            float fM7255constructorimpl = Dp.m7255constructorimpl(84);
            if (!z) {
                jM4537copywmQWz5c$default = ColorKt.Color(4283215696L);
            } else {
                jM4537copywmQWz5c$default = Color.m4537copywmQWz5c$default(ColorKt.Color(4293615204L), 0.8f, 0.0f, 0.0f, 0.0f, 14, null);
            }
            m8662VideoControlButtonOu1YvPQ(onPlayPauseClick, fM7255constructorimpl, jM4537copywmQWz5c$default, null, ComposableLambdaKt.rememberComposableLambda(453877286, true, new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$StartAndPauseView$3$1$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    int i4;
                    if ((i3 & 11) != 2 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(453877286, i3, -1, "com.soletreadmills.sole_v2.ui.classes.VideoModeFragment.StartAndPauseView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (VideoModeFragment.kt:633)");
                        }
                        if (z) {
                            i4 = R.drawable.ic_m__pause;
                        } else {
                            i4 = R.drawable.ic_m__play_fill;
                        }
                        IconKt.m1888Iconww6aTOc(PainterResources_androidKt.painterResource(i4, composer2, 0), (String) null, SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(28)), Color.INSTANCE.m4575getWhite0d7_KjU(), composer2, 3512, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i >> 3) & 14) | 286768, 8);
            m8662VideoControlButtonOu1YvPQ(onSeekForward, Dp.m7255constructorimpl(f), Color.m4537copywmQWz5c$default(Color.INSTANCE.m4568getGray0d7_KjU(), 0.4f, 0.0f, 0.0f, 0.0f, 14, null), null, ComposableSingletons$VideoModeFragmentKt.INSTANCE.m8659getLambda2$app_release(), composerStartRestartGroup, ((i >> 9) & 14) | 287152, 8);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment.StartAndPauseView.4
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i3) {
                        VideoModeFragment.this.StartAndPauseView(z, onPlayPauseClick, onSeekBackward, onSeekForward, onBackgroundClick, companion, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }

        /* JADX WARN: Removed duplicated region for block: B:46:0x0082  */
        /* JADX WARN: Removed duplicated region for block: B:47:0x0085  */
        /* JADX WARN: Removed duplicated region for block: B:60:0x00ab  */
        /* JADX WARN: Removed duplicated region for block: B:61:0x00ad  */
        /* JADX WARN: Removed duplicated region for block: B:62:0x00b3  */
        /* JADX WARN: Removed duplicated region for block: B:65:0x00ba  */
        /* JADX WARN: Removed duplicated region for block: B:68:0x00f7  */
        /* JADX WARN: Removed duplicated region for block: B:72:0x0101  */
        /* JADX WARN: Removed duplicated region for block: B:74:? A[RETURN, SYNTHETIC] */
        /* renamed from: VideoControlButton-Ou1YvPQ, reason: not valid java name */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final void m8662VideoControlButtonOu1YvPQ(final kotlin.jvm.functions.Function0<kotlin.Unit> r17, final float r18, final long r19, androidx.compose.ui.Modifier r21, final kotlin.jvm.functions.Function2<? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit> r22, androidx.compose.runtime.Composer r23, final int r24, final int r25) {
            /*
                Method dump skipped, instructions count: 283
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment.m8662VideoControlButtonOu1YvPQ(kotlin.jvm.functions.Function0, float, long, androidx.compose.ui.Modifier, kotlin.jvm.functions.Function2, androidx.compose.runtime.Composer, int, int):void");
        }

        public final void InfoView(final VideoModeViewModel viewModel, final Function1<? super Integer, Unit> onClick, Modifier modifier, Composer composer, final int i, final int i2) throws Resources.NotFoundException {
            int i3;
            String str;
            String str2;
            String str3;
            int i4;
            int i5;
            DisplaySelectStatsData displaySelectStatsData;
            Intrinsics.checkNotNullParameter(viewModel, "viewModel");
            Intrinsics.checkNotNullParameter(onClick, "onClick");
            Composer composerStartRestartGroup = composer.startRestartGroup(-1758162372);
            final Modifier.Companion companion = (i2 & 4) != 0 ? Modifier.INSTANCE : modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1758162372, i, -1, "com.soletreadmills.sole_v2.ui.classes.VideoModeFragment.InfoView (VideoModeFragment.kt:692)");
            }
            int i6 = 1;
            State stateCollectAsState = SnapshotStateKt.collectAsState(viewModel.getSelectedList(), null, composerStartRestartGroup, 8, 1);
            Modifier modifierM987paddingVpY3zN4$default = PaddingKt.m987paddingVpY3zN4$default(companion, Dp.m7255constructorimpl(viewModel.isLandscape() ? 60 : 20), 0.0f, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM987paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3857constructorimpl = Updater.m3857constructorimpl(composerStartRestartGroup);
            Updater.m3864setimpl(composerM3857constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3864setimpl(composerM3857constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3857constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3857constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3857constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3864setimpl(composerM3857constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3857constructorimpl2 = Updater.m3857constructorimpl(composerStartRestartGroup);
            Updater.m3864setimpl(composerM3857constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3864setimpl(composerM3857constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3857constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM3857constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3857constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3864setimpl(composerM3857constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            DisplaySelectStatsData displaySelectStatsData2 = (DisplaySelectStatsData) CollectionsKt.getOrNull(InfoView$lambda$15(stateCollectAsState), 0);
            composerStartRestartGroup.startReplaceGroup(165742370);
            if (displaySelectStatsData2 != null) {
                String tvDisplay1Title = viewModel.getTvDisplay1Title();
                Alignment.Horizontal start = Alignment.INSTANCE.getStart();
                composerStartRestartGroup.startReplaceGroup(1630764063);
                boolean z = (((i & 112) ^ 48) > 32 && composerStartRestartGroup.changed(onClick)) || (i & 48) == 32;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = (Function1) new Function1<DisplaySelectStatsData, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$InfoView$1$1$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DisplaySelectStatsData displaySelectStatsData3) {
                            invoke2(displaySelectStatsData3);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DisplaySelectStatsData it) {
                            Intrinsics.checkNotNullParameter(it, "it");
                            onClick.invoke(0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                composerStartRestartGroup.endReplaceGroup();
                i3 = 32;
                str = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
                str2 = "C101@5126L9:Row.kt#2w3rfo";
                str3 = "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo";
                StatsItemView(tvDisplay1Title, displaySelectStatsData2, start, (Function1) objRememberedValue, composerStartRestartGroup, 33216);
                Unit unit = Unit.INSTANCE;
                Unit unit2 = Unit.INSTANCE;
            } else {
                i3 = 32;
                str = "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh";
                str2 = "C101@5126L9:Row.kt#2w3rfo";
                str3 = "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo";
            }
            composerStartRestartGroup.endReplaceGroup();
            DisplaySelectStatsData displaySelectStatsData3 = (DisplaySelectStatsData) CollectionsKt.getOrNull(InfoView$lambda$15(stateCollectAsState), 1);
            composerStartRestartGroup.startReplaceGroup(1251093228);
            if (displaySelectStatsData3 != null) {
                String tvDisplay2Title = viewModel.getTvDisplay2Title();
                Alignment.Horizontal end = Alignment.INSTANCE.getEnd();
                composerStartRestartGroup.startReplaceGroup(1630764424);
                boolean z2 = (((i & 112) ^ 48) > i3 && composerStartRestartGroup.changed(onClick)) || (i & 48) == i3;
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = (Function1) new Function1<DisplaySelectStatsData, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$InfoView$1$1$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DisplaySelectStatsData displaySelectStatsData4) {
                            invoke2(displaySelectStatsData4);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DisplaySelectStatsData statsData) {
                            Intrinsics.checkNotNullParameter(statsData, "statsData");
                            onClick.invoke(1);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                composerStartRestartGroup.endReplaceGroup();
                StatsItemView(tvDisplay2Title, displaySelectStatsData3, end, (Function1) objRememberedValue2, composerStartRestartGroup, 33216);
                Unit unit3 = Unit.INSTANCE;
                Unit unit4 = Unit.INSTANCE;
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.startReplaceGroup(1251093593);
            if (viewModel.isLandscape()) {
                i4 = 0;
            } else {
                i4 = 0;
                SpacerKt.Spacer(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, str3);
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(spaceBetween2, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, str);
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, i4);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default2);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3857constructorimpl3 = Updater.m3857constructorimpl(composerStartRestartGroup);
            Updater.m3864setimpl(composerM3857constructorimpl3, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3864setimpl(composerM3857constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3857constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM3857constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM3857constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3864setimpl(composerM3857constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, str2);
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            DisplaySelectStatsData displaySelectStatsData4 = (DisplaySelectStatsData) CollectionsKt.getOrNull(InfoView$lambda$15(stateCollectAsState), 2);
            composerStartRestartGroup.startReplaceGroup(165743383);
            if (displaySelectStatsData4 == null) {
                i5 = i4;
            } else {
                String tvDisplay3Title = viewModel.getTvDisplay3Title();
                Alignment.Horizontal start2 = Alignment.INSTANCE.getStart();
                composerStartRestartGroup.startReplaceGroup(1630765076);
                int i7 = ((((i & 112) ^ 48) <= i3 || !composerStartRestartGroup.changed(onClick)) && (i & 48) != i3) ? i4 : 1;
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (i7 != 0 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = (Function1) new Function1<DisplaySelectStatsData, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$InfoView$1$2$1$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DisplaySelectStatsData displaySelectStatsData5) {
                            invoke2(displaySelectStatsData5);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DisplaySelectStatsData statsData) {
                            Intrinsics.checkNotNullParameter(statsData, "statsData");
                            onClick.invoke(2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                composerStartRestartGroup.endReplaceGroup();
                i5 = i4;
                StatsItemView(tvDisplay3Title, displaySelectStatsData4, start2, (Function1) objRememberedValue3, composerStartRestartGroup, 33216);
                Unit unit5 = Unit.INSTANCE;
                Unit unit6 = Unit.INSTANCE;
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.startReplaceGroup(1251094234);
            if (viewModel.getBleFtmsMachineType() != null && (displaySelectStatsData = (DisplaySelectStatsData) CollectionsKt.getOrNull(InfoView$lambda$15(stateCollectAsState), 3)) != null) {
                String tvDisplay4Title = viewModel.getTvDisplay4Title();
                Alignment.Horizontal end2 = Alignment.INSTANCE.getEnd();
                composerStartRestartGroup.startReplaceGroup(1630765533);
                if ((((i & 112) ^ 48) <= i3 || !composerStartRestartGroup.changed(onClick)) && (i & 48) != i3) {
                    i6 = i5;
                }
                Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (i6 != 0 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = (Function1) new Function1<DisplaySelectStatsData, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$InfoView$1$2$2$1$1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(DisplaySelectStatsData displaySelectStatsData5) {
                            invoke2(displaySelectStatsData5);
                            return Unit.INSTANCE;
                        }

                        /* renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2(DisplaySelectStatsData statsData) {
                            Intrinsics.checkNotNullParameter(statsData, "statsData");
                            onClick.invoke(3);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                composerStartRestartGroup.endReplaceGroup();
                StatsItemView(tvDisplay4Title, displaySelectStatsData, end2, (Function1) objRememberedValue4, composerStartRestartGroup, 33216);
                Unit unit7 = Unit.INSTANCE;
                Unit unit8 = Unit.INSTANCE;
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment.InfoView.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) throws Resources.NotFoundException {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i8) throws Resources.NotFoundException {
                        VideoModeFragment.this.InfoView(viewModel, onClick, companion, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }

        public final void StatsItemView(final String value, final DisplaySelectStatsData data, final Alignment.Horizontal alignment, final Function1<? super DisplaySelectStatsData, Unit> onTap, Composer composer, final int i) throws Resources.NotFoundException {
            Pair pair;
            Intrinsics.checkNotNullParameter(value, "value");
            Intrinsics.checkNotNullParameter(data, "data");
            Intrinsics.checkNotNullParameter(alignment, "alignment");
            Intrinsics.checkNotNullParameter(onTap, "onTap");
            Composer composerStartRestartGroup = composer.startRestartGroup(-1162119409);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1162119409, i, -1, "com.soletreadmills.sole_v2.ui.classes.VideoModeFragment.StatsItemView (VideoModeFragment.kt:766)");
            }
            switch (WhenMappings.$EnumSwitchMapping$0[data.getType().ordinal()]) {
                case 1:
                    pair = TuplesKt.to(Integer.valueOf(R.string.time), Integer.valueOf(R.drawable.ic_stats_timer_fill03));
                    break;
                case 2:
                    pair = TuplesKt.to(Integer.valueOf(R.string.remaining_time), Integer.valueOf(R.drawable.ic_stats_timer_fill02));
                    break;
                case 3:
                    pair = TuplesKt.to(Integer.valueOf(R.string.distance), Integer.valueOf(R.drawable.ic_stats_distance02));
                    break;
                case 4:
                    pair = TuplesKt.to(Integer.valueOf(R.string.speed), Integer.valueOf(R.drawable.ic_stats_speed02));
                    break;
                case 5:
                    pair = TuplesKt.to(Integer.valueOf(R.string.pace), Integer.valueOf(R.drawable.ic_activity_run02));
                    break;
                case 6:
                    pair = TuplesKt.to(Integer.valueOf(R.string.avg_pace), Integer.valueOf(R.drawable.ic_activity_run02));
                    break;
                case 7:
                    pair = TuplesKt.to(Integer.valueOf(R.string.heart_rate), Integer.valueOf(R.drawable.ic_stats_hr02));
                    break;
                case 8:
                    pair = TuplesKt.to(Integer.valueOf(R.string.incline), Integer.valueOf(R.drawable.ic_stats_incline02));
                    break;
                case 9:
                    pair = TuplesKt.to(Integer.valueOf(R.string.calories), Integer.valueOf(R.drawable.ic_stats_calories02));
                    break;
                case 10:
                    pair = TuplesKt.to(Integer.valueOf(R.string.mets), Integer.valueOf(R.drawable.ic_stats_mets02));
                    break;
                case 11:
                    pair = TuplesKt.to(Integer.valueOf(R.string.ascent), Integer.valueOf(R.drawable.ic_stats_ascent02));
                    break;
                case 12:
                    pair = TuplesKt.to(Integer.valueOf(R.string.output), Integer.valueOf(R.drawable.ic_stats_power02));
                    break;
                case 13:
                    pair = TuplesKt.to(Integer.valueOf(R.string.resistance), Integer.valueOf(R.drawable.ic_level_expert02));
                    break;
                case 14:
                    pair = TuplesKt.to(Integer.valueOf(R.string.cadence), Integer.valueOf(R.drawable.ic_stats_cadence_rpm02));
                    break;
                case 15:
                    pair = TuplesKt.to(Integer.valueOf(R.string.strides), Integer.valueOf(R.drawable.ic_stats_steps02));
                    break;
                case 16:
                    pair = TuplesKt.to(Integer.valueOf(R.string.avg_speed), Integer.valueOf(R.drawable.ic_stats_speed02));
                    break;
                case 17:
                    pair = TuplesKt.to(Integer.valueOf(R.string.avg_cadence), Integer.valueOf(R.drawable.ic_stats_cadence_rpm02));
                    break;
                case 18:
                    pair = TuplesKt.to(Integer.valueOf(R.string.strokes), Integer.valueOf(R.drawable.ic_stats_strokes02));
                    break;
                case 19:
                    pair = TuplesKt.to(Integer.valueOf(R.string.floors), Integer.valueOf(R.drawable.ic_stats_floors02));
                    break;
                case 20:
                    pair = TuplesKt.to(Integer.valueOf(R.string.steps), Integer.valueOf(R.drawable.ic_stats_steps02));
                    break;
                case 21:
                    pair = TuplesKt.to(Integer.valueOf(R.string.calories_min), Integer.valueOf(R.drawable.ic_stats_calories02));
                    break;
                default:
                    throw new NoWhenBranchMatchedException();
            }
            int iIntValue = ((Number) pair.component1()).intValue();
            int iIntValue2 = ((Number) pair.component2()).intValue();
            float f = 16;
            Modifier modifierM987paddingVpY3zN4$default = PaddingKt.m987paddingVpY3zN4$default(ClickableKt.m573clickableXHw0xAI$default(Modifier.INSTANCE, false, null, null, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$StatsItemView$1$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
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
                    onTap.invoke(data);
                }
            }, 7, null), 0.0f, Dp.m7255constructorimpl(f), 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -483455358, "CC(Column)P(2,3,1)86@4330L61,87@4396L133:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), alignment, composerStartRestartGroup, ((i & 896) >> 3) & 112);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM987paddingVpY3zN4$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3857constructorimpl = Updater.m3857constructorimpl(composerStartRestartGroup);
            Updater.m3864setimpl(composerM3857constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3864setimpl(composerM3857constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3857constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3857constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3857constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3864setimpl(composerM3857constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -384784025, "C88@4444L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            TextKt.m2038Text4IGK_g(value, (Modifier) null, Color.INSTANCE.m4575getWhite0d7_KjU(), TextUnitKt.getSp(38), (FontStyle) null, FontWeight.INSTANCE.getBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, (i & 14) | 200064, 0, 131026);
            SpacerKt.Spacer(SizeKt.m1016height3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(8)), composerStartRestartGroup, 6);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.HorizontalOrVertical horizontalOrVerticalM865spacedBy0680j_4 = Arrangement.INSTANCE.m865spacedBy0680j_4(Dp.m7255constructorimpl(5));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM865spacedBy0680j_4, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3857constructorimpl2 = Updater.m3857constructorimpl(composerStartRestartGroup);
            Updater.m3864setimpl(composerM3857constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3864setimpl(composerM3857constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3857constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM3857constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3857constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3864setimpl(composerM3857constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            IconKt.m1888Iconww6aTOc(PainterResources_androidKt.painterResource(iIntValue2, composerStartRestartGroup, 0), (String) null, SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(20)), Color.INSTANCE.m4575getWhite0d7_KjU(), composerStartRestartGroup, 3512, 0);
            TextKt.m2038Text4IGK_g(StringResources_androidKt.stringResource(iIntValue, composerStartRestartGroup, 0), (Modifier) null, Color.m4537copywmQWz5c$default(Color.INSTANCE.m4575getWhite0d7_KjU(), 0.85f, 0.0f, 0.0f, 0.0f, 14, null), TextUnitKt.getSp(17), (FontStyle) null, FontWeight.INSTANCE.getMedium(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composerStartRestartGroup, 200064, 0, 131026);
            Modifier modifierM539backgroundbw27NRU = BackgroundKt.m539backgroundbw27NRU(SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(24)), Color.m4537copywmQWz5c$default(Color.INSTANCE.m4575getWhite0d7_KjU(), 0.12f, 0.0f, 0.0f, 0.0f, 14, null), RoundedCornerShapeKt.getCircleShape());
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM539backgroundbw27NRU);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3857constructorimpl3 = Updater.m3857constructorimpl(composerStartRestartGroup);
            Updater.m3864setimpl(composerM3857constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3864setimpl(composerM3857constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3857constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM3857constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM3857constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3864setimpl(composerM3857constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            IconKt.m1888Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_chevron_up_down, composerStartRestartGroup, 0), (String) null, SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(f)), Color.m4537copywmQWz5c$default(Color.INSTANCE.m4575getWhite0d7_KjU(), 0.5f, 0.0f, 0.0f, 0.0f, 14, null), composerStartRestartGroup, 3512, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Unit unit = Unit.INSTANCE;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment.StatsItemView.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) throws Resources.NotFoundException {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i2) throws Resources.NotFoundException {
                        VideoModeFragment.this.StatsItemView(value, data, alignment, onTap, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1));
                    }
                });
            }
        }

        public final void TopView(final boolean z, final VideoModeViewModel viewModel, final Function0<Unit> onFinishClick, final Function0<Unit> onVideoSettingClick, final Function0<Unit> onWatchClick, Modifier modifier, Composer composer, final int i, final int i2) {
            Intrinsics.checkNotNullParameter(viewModel, "viewModel");
            Intrinsics.checkNotNullParameter(onFinishClick, "onFinishClick");
            Intrinsics.checkNotNullParameter(onVideoSettingClick, "onVideoSettingClick");
            Intrinsics.checkNotNullParameter(onWatchClick, "onWatchClick");
            Composer composerStartRestartGroup = composer.startRestartGroup(-623987636);
            final Modifier modifier2 = (i2 & 32) != 0 ? Modifier.INSTANCE : modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-623987636, i, -1, "com.soletreadmills.sole_v2.ui.classes.VideoModeFragment.TopView (VideoModeFragment.kt:862)");
            }
            ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM989paddingqDBjuR0$default = PaddingKt.m989paddingqDBjuR0$default(SizeKt.m1016height3ABfNKs(SizeKt.fillMaxWidth$default(modifier2, 0.0f, 1, null), Dp.m7255constructorimpl(64)), Dp.m7255constructorimpl(z ? 52 : 12), Dp.m7255constructorimpl(((Configuration) objConsume).screenHeightDp <= 568 ? 0 : 12), Dp.m7255constructorimpl(z ? 52 : 12), 0.0f, 8, null);
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical top = Alignment.INSTANCE.getTop();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, top, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM989paddingqDBjuR0$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3857constructorimpl = Updater.m3857constructorimpl(composerStartRestartGroup);
            Updater.m3864setimpl(composerM3857constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3864setimpl(composerM3857constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3857constructorimpl.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM3857constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM3857constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m3864setimpl(composerM3857constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            float f = 44;
            ButtonKt.TextButton(onFinishClick, SizeKt.m1016height3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(f)), false, null, null, null, null, null, null, ComposableLambdaKt.rememberComposableLambda(911853195, true, new Function3<RowScope, Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment$TopView$1$1
                {
                    super(3);
                }

                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(RowScope rowScope, Composer composer2, Integer num) {
                    invoke(rowScope, composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(RowScope TextButton, Composer composer2, int i3) {
                    Intrinsics.checkNotNullParameter(TextButton, "$this$TextButton");
                    if ((i3 & 81) != 16 || !composer2.getSkipping()) {
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(911853195, i3, -1, "com.soletreadmills.sole_v2.ui.classes.VideoModeFragment.TopView.<anonymous>.<anonymous> (VideoModeFragment.kt:883)");
                        }
                        Arrangement.HorizontalOrVertical horizontalOrVerticalM865spacedBy0680j_4 = Arrangement.INSTANCE.m865spacedBy0680j_4(Dp.m7255constructorimpl(8));
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        VideoModeFragment videoModeFragment = this.this$0;
                        ComposerKt.sourceInformationMarkerStart(composer2, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
                        Modifier.Companion companion = Modifier.INSTANCE;
                        MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontalOrVerticalM865spacedBy0680j_4, centerVertically, composer2, 54);
                        ComposerKt.sourceInformationMarkerStart(composer2, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
                        int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer2, 0);
                        CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion);
                        Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                        ComposerKt.sourceInformationMarkerStart(composer2, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor2);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM3857constructorimpl2 = Updater.m3857constructorimpl(composer2);
                        Updater.m3864setimpl(composerM3857constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m3864setimpl(composerM3857constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                        if (composerM3857constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                            composerM3857constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                            composerM3857constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                        }
                        Updater.m3864setimpl(composerM3857constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composer2, -407840262, "C101@5126L9:Row.kt#2w3rfo");
                        RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
                        IconKt.m1888Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_m__xmark, composer2, 0), "Finish", SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(24)), ColorResources_androidKt.colorResource(R.color.colorLabel_accent, composer2, 0), composer2, 440, 0);
                        Context context = videoModeFragment.getContext();
                        composer2.startReplaceGroup(-584990142);
                        if (context != null) {
                            String string = context.getString(R.string.exit);
                            Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
                            TextKt.m2038Text4IGK_g(string, (Modifier) null, ColorResources_androidKt.colorResource(R.color.colorLabel_accent, composer2, 0), TextUnitKt.getSp(17), (FontStyle) null, FontWeight.INSTANCE.getSemiBold(), (FontFamily) null, 0L, (TextDecoration) null, (TextAlign) null, 0L, 0, false, 0, 0, (Function1<? super TextLayoutResult, Unit>) null, (TextStyle) null, composer2, 199680, 0, 131026);
                        }
                        composer2.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                            return;
                        }
                        return;
                    }
                    composer2.skipToGroupEnd();
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i >> 6) & 14) | 805306416, TypedValues.PositionType.TYPE_CURVE_FIT);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM865spacedBy0680j_4 = Arrangement.INSTANCE.m865spacedBy0680j_4(Dp.m7255constructorimpl(16));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 693286680, "CC(Row)P(2,1,3)99@5018L58,100@5081L130:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(horizontalOrVerticalM865spacedBy0680j_4, Alignment.INSTANCE.getTop(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3857constructorimpl2 = Updater.m3857constructorimpl(composerStartRestartGroup);
            Updater.m3864setimpl(composerM3857constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3864setimpl(composerM3857constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3857constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                composerM3857constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                composerM3857constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
            }
            Updater.m3864setimpl(composerM3857constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -407840262, "C101@5126L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            IconButtonKt.IconButton(onVideoSettingClick, SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(f)), false, null, ComposableSingletons$VideoModeFragmentKt.INSTANCE.m8660getLambda3$app_release(), composerStartRestartGroup, ((i >> 9) & 14) | 24624, 12);
            Modifier modifierM1030size3ABfNKs = SizeKt.m1030size3ABfNKs(Modifier.INSTANCE, Dp.m7255constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 733328855, "CC(Box)P(2,1,3)72@3384L130:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3208L23,82@3359L411:Layout.kt#80mrfh");
            int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1030size3ABfNKs);
            Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)376@14062L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM3857constructorimpl3 = Updater.m3857constructorimpl(composerStartRestartGroup);
            Updater.m3864setimpl(composerM3857constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m3864setimpl(composerM3857constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM3857constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM3857constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                composerM3857constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                composerM3857constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
            }
            Updater.m3864setimpl(composerM3857constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2146769399, "C73@3429L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            IconButtonKt.IconButton(onWatchClick, boxScopeInstance.matchParentSize(Modifier.INSTANCE), false, null, ComposableSingletons$VideoModeFragmentKt.INSTANCE.m8661getLambda4$app_release(), composerStartRestartGroup, ((i >> 12) & 14) | 24576, 12);
            composerStartRestartGroup.startReplaceGroup(-584988441);
            if (viewModel.isConnectingHr()) {
                BoxKt.Box(BackgroundKt.m539backgroundbw27NRU(SizeKt.m1030size3ABfNKs(OffsetKt.m945offsetVpY3zN4(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopEnd()), Dp.m7255constructorimpl(-10), Dp.m7255constructorimpl(10)), Dp.m7255constructorimpl(8)), ColorKt.Color(4278255360L), RoundedCornerShapeKt.getCircleShape()), composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: com.soletreadmills.sole_v2.ui.classes.VideoModeFragment.TopView.2
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i3) {
                        VideoModeFragment.this.TopView(z, viewModel, onFinishClick, onVideoSettingClick, onWatchClick, modifier2, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }

        private static final List<DisplaySelectStatsData> InfoView$lambda$15(State<? extends List<DisplaySelectStatsData>> state) {
            return state.getValue();
        }
    }
