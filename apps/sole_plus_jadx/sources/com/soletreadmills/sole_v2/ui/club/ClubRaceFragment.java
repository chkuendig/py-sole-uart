package com.soletreadmills.sole_v2.ui.club;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.camera.video.AudioStats;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.android.SdkConstants;
import com.google.gson.Gson;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._data.api.club.StartRace4VirtualRaceApiData;
import com.soletreadmills.sole_v2._data.club.ChallengeItemSimpleDataWithMemberData;
import com.soletreadmills.sole_v2._data.club.DisplaySelectStatsData;
import com.soletreadmills.sole_v2._data.club.VirtualRaceCodeType;
import com.soletreadmills.sole_v2._data.login.LoginUserData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2._manager.ChangeViewManager;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2._tools.ConvertUtils;
import com.soletreadmills.sole_v2._tools.TimeTools;
import com.soletreadmills.sole_v2._tools.UnitConversion;
import com.soletreadmills.sole_v2._type.DisplayStatsType;
import com.soletreadmills.sole_v2.ble.cmd.FitnessMachineControlPointCmd;
import com.soletreadmills.sole_v2.ble.code.FitnessMachineControlPointOpCode;
import com.soletreadmills.sole_v2.ble.code.FitnessMachineControlPointResultCode;
import com.soletreadmills.sole_v2.ble.data.CrossTrainerData;
import com.soletreadmills.sole_v2.ble.data.FitnessMachineControlPointResponseData;
import com.soletreadmills.sole_v2.ble.data.FtmsBaseData;
import com.soletreadmills.sole_v2.ble.data.IndoorBikeData;
import com.soletreadmills.sole_v2.ble.data.RowerData;
import com.soletreadmills.sole_v2.ble.data.StepClimberData;
import com.soletreadmills.sole_v2.ble.data.TreadmillData;
import com.soletreadmills.sole_v2.ble.manager.BleDataManager;
import com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager;
import com.soletreadmills.sole_v2.ble.type.BleFtmsMachineType;
import com.soletreadmills.sole_v2.ble.type.FitnessMachineStatusType;
import com.soletreadmills.sole_v2.ble.type.TrainingStatusType;
import com.soletreadmills.sole_v2.databinding.FragmentClubRaceBinding;
import com.soletreadmills.sole_v2.listener.BluetoothCallbackListener;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.customview.DisplayStatsSelectCustom;
import com.soletreadmills.sole_v2.ui.widget.AnimatedPathImageView;
import com.sun.jna.platform.win32.WinError;
import java.io.IOException;
import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
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
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.StringCompanionObject;
import kotlin.math.MathKt;
import kotlin.ranges.RangesKt;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.StateFlow;
import no.nordicsemi.android.support.v18.scanner.ScanResult;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: ClubRaceFragment.kt */
@Metadata(d1 = {"\u0000¯\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001\f\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\u001f\u0010.\u001a\u00020#2\b\u0010/\u001a\u0004\u0018\u0001002\b\u00101\u001a\u0004\u0018\u000100¢\u0006\u0002\u00102J)\u00103\u001a\u0002042\b\u00105\u001a\u0004\u0018\u0001042\b\u00106\u001a\u0004\u0018\u0001042\b\u00107\u001a\u0004\u0018\u000104¢\u0006\u0002\u00108J\u0015\u00109\u001a\u00020#2\b\u0010:\u001a\u0004\u0018\u000104¢\u0006\u0002\u0010;J\u0006\u0010<\u001a\u00020=J\u0017\u0010>\u001a\u00020#2\b\u0010?\u001a\u0004\u0018\u00010@H\u0002¢\u0006\u0002\u0010AJ\u0017\u0010B\u001a\u00020#2\b\u0010C\u001a\u0004\u0018\u000104H\u0002¢\u0006\u0002\u0010;J\u0017\u0010D\u001a\u00020#2\b\u0010:\u001a\u0004\u0018\u00010@H\u0002¢\u0006\u0002\u0010AJ\u0017\u0010E\u001a\u00020#2\b\u0010F\u001a\u0004\u0018\u000100H\u0002¢\u0006\u0002\u0010GJ\u0006\u0010H\u001a\u00020=J\u001a\u0010I\u001a\u00020#2\u0006\u0010J\u001a\u00020K2\b\u0010L\u001a\u0004\u0018\u00010\u000fH\u0002J\u001a\u0010M\u001a\u00020\u00022\u0006\u0010N\u001a\u00020O2\b\u0010P\u001a\u0004\u0018\u00010QH\u0016J\b\u0010R\u001a\u00020=H\u0016J\u0012\u0010S\u001a\u00020=2\b\u0010T\u001a\u0004\u0018\u00010UH\u0002J\u0012\u0010V\u001a\u00020=2\b\u0010W\u001a\u0004\u0018\u00010XH\u0016J\b\u0010Y\u001a\u00020=H\u0016J\b\u0010Z\u001a\u00020=H\u0016J\b\u0010[\u001a\u00020=H\u0016J\b\u0010\\\u001a\u00020=H\u0016J\u000e\u0010]\u001a\u00020=2\u0006\u0010^\u001a\u000200J\u0006\u0010_\u001a\u00020=J \u0010`\u001a\u00020=2\u0006\u0010^\u001a\u0002002\u0006\u0010a\u001a\u00020b2\b\u0010L\u001a\u0004\u0018\u00010\u000fJ\"\u0010c\u001a\u00020=2\u0006\u0010a\u001a\u00020b2\b\u0010d\u001a\u0004\u0018\u00010e2\b\u0010f\u001a\u0004\u0018\u00010gJ\u0016\u0010h\u001a\u00020=2\f\u0010i\u001a\b\u0012\u0004\u0012\u00020b0jH\u0002J\u0006\u0010k\u001a\u00020=J\u0006\u0010l\u001a\u00020=J\u0006\u0010m\u001a\u00020=J\u0012\u0010n\u001a\u00020=2\b\u0010o\u001a\u0004\u0018\u00010pH\u0002J\u0006\u0010q\u001a\u00020=J\u0006\u0010r\u001a\u00020=R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0010\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\rR\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001a\u0010\u0019\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0016\"\u0004\b\u001a\u0010\u0018R\u001a\u0010\u001b\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0016\"\u0004\b\u001c\u0010\u0018R\u001a\u0010\u001d\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0016\"\u0004\b\u001e\u0010\u0018R\u001c\u0010\u001f\u001a\u0004\u0018\u00010\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0011\"\u0004\b!\u0010\u0013R\u001a\u0010\"\u001a\u00020#X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001b\u0010(\u001a\u00020)8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b,\u0010-\u001a\u0004\b*\u0010+¨\u0006s"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/club/ClubRaceFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentClubRaceBinding;", "Landroid/view/View$OnClickListener;", "()V", "bleFtmsMachineType", "Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "getBleFtmsMachineType", "()Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "setBleFtmsMachineType", "(Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;)V", "bluetoothCallbackListener", "com/soletreadmills/sole_v2/ui/club/ClubRaceFragment$bluetoothCallbackListener$1", "Lcom/soletreadmills/sole_v2/ui/club/ClubRaceFragment$bluetoothCallbackListener$1;", "firstFtmsData", "Lcom/soletreadmills/sole_v2/ble/data/FtmsBaseData;", "getFirstFtmsData", "()Lcom/soletreadmills/sole_v2/ble/data/FtmsBaseData;", "setFirstFtmsData", "(Lcom/soletreadmills/sole_v2/ble/data/FtmsBaseData;)V", "isCallApi", "", "()Z", "setCallApi", "(Z)V", "isCallBack", "setCallBack", "isFinish", "setFinish", "isStart", "setStart", "oldFtmsData", "getOldFtmsData", "setOldFtmsData", "ticket", "", "getTicket", "()Ljava/lang/String;", "setTicket", "(Ljava/lang/String;)V", "viewModel", "Lcom/soletreadmills/sole_v2/ui/club/ClubRaceViewModel;", "getViewModel", "()Lcom/soletreadmills/sole_v2/ui/club/ClubRaceViewModel;", "viewModel$delegate", "Lkotlin/Lazy;", "calculateAveragePace", "totalTimeSec", "", "distance", "(Ljava/lang/Integer;Ljava/lang/Integer;)Ljava/lang/String;", "calculateMets", "", "speed", "inclinePercent", "watt", "(Ljava/lang/Double;Ljava/lang/Double;Ljava/lang/Double;)D", "calculatePace", "speedKmh", "(Ljava/lang/Double;)Ljava/lang/String;", "changeScaleFactor", "", "convertDistance", "distanceM", "", "(Ljava/lang/Float;)Ljava/lang/String;", "convertPositiveElevationGain", "elevation", "convertSpeed", "convertTime", "seconds", "(Ljava/lang/Integer;)Ljava/lang/String;", "finishRace", "getDisplayValue", "type", "Lcom/soletreadmills/sole_v2/_type/DisplayStatsType;", "ftmsData", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", "isPaused", "fitnessMachineStatusType", "Lcom/soletreadmills/sole_v2/ble/type/FitnessMachineStatusType;", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onDestroy", "onDestroyView", "onResume", "onStop", "openSelectDisplayStatsView", "pos", "setBlueToothConnectStatus", "setDisPlayValue", "data", "Lcom/soletreadmills/sole_v2/_data/club/DisplaySelectStatsData;", "setDisplayContentView", "img", "Landroid/widget/ImageView;", "tv", "Landroid/widget/TextView;", "setDisplayView", "list", "", "setProgressBar", "setRaceView", "showDisplayInfo", "showIdle", "trainingStatusType", "Lcom/soletreadmills/sole_v2/ble/type/TrainingStatusType;", "startRace", "startRace4VirtualRace", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubRaceFragment extends BaseFragment<FragmentClubRaceBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private FtmsBaseData firstFtmsData;
    private boolean isCallApi;
    private boolean isCallBack;
    private boolean isFinish;
    private boolean isStart;
    private FtmsBaseData oldFtmsData;

    /* renamed from: viewModel$delegate, reason: from kotlin metadata */
    private final Lazy viewModel;
    private BleFtmsMachineType bleFtmsMachineType = BleFtmsMachineType.TREADMILL;
    private String ticket = "";
    private final ClubRaceFragment$bluetoothCallbackListener$1 bluetoothCallbackListener = new BluetoothCallbackListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubRaceFragment$bluetoothCallbackListener$1

        /* compiled from: ClubRaceFragment.kt */
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
                    iArr[BleFtmsMachineType.STEPPER.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[BleFtmsMachineType.ROWER.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
        public void onConnecting(BluetoothCallbackListener.DeviceType deviceType, String macAddress) {
            Intrinsics.checkNotNullParameter(deviceType, "deviceType");
            Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        }

        @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
        public void onReceiveHrData(String hrDataJsonStr) {
        }

        @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
        public void onReceiveSrvoData(String srvoData, String className) {
        }

        @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
        public void onScan() {
        }

        @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
        public void onScanResult(int callbackType, ScanResult scanResult) {
            Intrinsics.checkNotNullParameter(scanResult, "scanResult");
        }

        @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
        public void onSrvoDeviceReady(String macAddress) {
            Intrinsics.checkNotNullParameter(macAddress, "macAddress");
        }

        @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
        public void onConnected(BluetoothCallbackListener.DeviceType deviceType, String macAddress) {
            Intrinsics.checkNotNullParameter(deviceType, "deviceType");
            Intrinsics.checkNotNullParameter(macAddress, "macAddress");
            this.this$0.setBlueToothConnectStatus();
        }

        @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
        public void onDisconnected(BluetoothCallbackListener.DeviceType deviceType, String macAddress) {
            Intrinsics.checkNotNullParameter(deviceType, "deviceType");
            Intrinsics.checkNotNullParameter(macAddress, "macAddress");
            this.this$0.setBlueToothConnectStatus();
        }

        @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
        public void onReceiveFtmsData(String ftmsDataJsonStr, String className) throws InterruptedException, ClassNotFoundException, NumberFormatException {
            Class<?> cls;
            FtmsBaseData ftmsBaseData;
            int iIntValue;
            AnimatedPathImageView animatedPathImageView;
            AnimatedPathImageView animatedPathImageView2;
            AnimatedPathImageView animatedPathImageView3;
            AnimatedPathImageView animatedPathImageView4;
            AnimatedPathImageView animatedPathImageView5;
            FragmentClubRaceBinding fragmentClubRaceBindingAccess$getBinding;
            AnimatedPathImageView animatedPathImageView6;
            AnimatedPathImageView animatedPathImageView7;
            AnimatedPathImageView animatedPathImageView8;
            if (className == null || ftmsDataJsonStr == null || ClubRaceFragment.access$getBinding(this.this$0) == null || this.this$0.getIsFinish()) {
                return;
            }
            try {
                cls = Class.forName(className);
            } catch (Exception e) {
                e.printStackTrace();
                cls = null;
            }
            try {
                ftmsBaseData = (FtmsBaseData) new Gson().fromJson(ftmsDataJsonStr, (Type) cls);
            } catch (Exception e2) {
                e2.printStackTrace();
                ftmsBaseData = null;
            }
            FragmentClubRaceBinding fragmentClubRaceBindingAccess$getBinding2 = ClubRaceFragment.access$getBinding(this.this$0);
            if (fragmentClubRaceBindingAccess$getBinding2 == null || (animatedPathImageView8 = fragmentClubRaceBindingAccess$getBinding2.animatedPathImageView) == null || !animatedPathImageView8.getIsPaused()) {
                if (this.this$0.getOldFtmsData() != null) {
                    Integer elapsedTime = ftmsBaseData != null ? ftmsBaseData.getElapsedTime() : null;
                    FtmsBaseData oldFtmsData = this.this$0.getOldFtmsData();
                    if (Intrinsics.areEqual(elapsedTime, oldFtmsData != null ? oldFtmsData.getElapsedTime() : null)) {
                        return;
                    }
                }
                List<DisplaySelectStatsData> value = this.this$0.getViewModel().getSelectedList().getValue();
                int size = value.size();
                int i = 0;
                for (int i2 = 0; i2 < size; i2++) {
                    this.this$0.setDisPlayValue(i2, value.get(i2), ftmsBaseData);
                }
                int i3 = WhenMappings.$EnumSwitchMapping$0[this.this$0.getBleFtmsMachineType().ordinal()];
                float totalDistanceKm = 0.0f;
                if (i3 != 1) {
                    if (i3 != 2) {
                        if (i3 != 3) {
                            if (i3 == 4) {
                                if ((ftmsBaseData instanceof StepClimberData) && (fragmentClubRaceBindingAccess$getBinding = ClubRaceFragment.access$getBinding(this.this$0)) != null && (animatedPathImageView6 = fragmentClubRaceBindingAccess$getBinding.animatedPathImageView) != null) {
                                    Double stepPerMinute = ((StepClimberData) ftmsBaseData).getStepPerMinute();
                                    animatedPathImageView6.updateSpeed(stepPerMinute != null ? (float) stepPerMinute.doubleValue() : 0.0f);
                                }
                            } else if (i3 == 5 && (ftmsBaseData instanceof RowerData)) {
                                FragmentClubRaceBinding fragmentClubRaceBindingAccess$getBinding3 = ClubRaceFragment.access$getBinding(this.this$0);
                                if (fragmentClubRaceBindingAccess$getBinding3 != null && (animatedPathImageView7 = fragmentClubRaceBindingAccess$getBinding3.animatedPathImageView) != null) {
                                    Double instantaneousPace = ((RowerData) ftmsBaseData).getInstantaneousPace();
                                    animatedPathImageView7.updateSpeed(instantaneousPace != null ? (float) instantaneousPace.doubleValue() : 0.0f);
                                }
                                Integer totalDistance = ((RowerData) ftmsBaseData).getTotalDistance();
                                if (totalDistance != null) {
                                    iIntValue = totalDistance.intValue();
                                    i = iIntValue;
                                }
                            }
                        } else if (ftmsBaseData instanceof CrossTrainerData) {
                            FragmentClubRaceBinding fragmentClubRaceBindingAccess$getBinding4 = ClubRaceFragment.access$getBinding(this.this$0);
                            if (fragmentClubRaceBindingAccess$getBinding4 != null && (animatedPathImageView5 = fragmentClubRaceBindingAccess$getBinding4.animatedPathImageView) != null) {
                                Double instantaneousSpeed = ((CrossTrainerData) ftmsBaseData).getInstantaneousSpeed();
                                animatedPathImageView5.updateSpeed(instantaneousSpeed != null ? (float) instantaneousSpeed.doubleValue() : 0.0f);
                            }
                            Integer totalDistance2 = ((CrossTrainerData) ftmsBaseData).getTotalDistance();
                            if (totalDistance2 != null) {
                                iIntValue = totalDistance2.intValue();
                                i = iIntValue;
                            }
                        }
                    } else if (ftmsBaseData instanceof IndoorBikeData) {
                        FragmentClubRaceBinding fragmentClubRaceBindingAccess$getBinding5 = ClubRaceFragment.access$getBinding(this.this$0);
                        if (fragmentClubRaceBindingAccess$getBinding5 != null && (animatedPathImageView4 = fragmentClubRaceBindingAccess$getBinding5.animatedPathImageView) != null) {
                            Double instantaneousSpeed2 = ((IndoorBikeData) ftmsBaseData).getInstantaneousSpeed();
                            animatedPathImageView4.updateSpeed(instantaneousSpeed2 != null ? (float) instantaneousSpeed2.doubleValue() : 0.0f);
                        }
                        Integer totalDistance3 = ((IndoorBikeData) ftmsBaseData).getTotalDistance();
                        if (totalDistance3 != null) {
                            iIntValue = totalDistance3.intValue();
                            i = iIntValue;
                        }
                    }
                } else if (ftmsBaseData instanceof TreadmillData) {
                    Timber.Companion companion = Timber.INSTANCE;
                    TreadmillData treadmillData = (TreadmillData) ftmsBaseData;
                    Double instantaneousSpeed3 = treadmillData.getInstantaneousSpeed();
                    companion.e("Speed:%s", Float.valueOf(instantaneousSpeed3 != null ? (float) instantaneousSpeed3.doubleValue() : 0.0f));
                    FragmentClubRaceBinding fragmentClubRaceBindingAccess$getBinding6 = ClubRaceFragment.access$getBinding(this.this$0);
                    if (fragmentClubRaceBindingAccess$getBinding6 != null && (animatedPathImageView = fragmentClubRaceBindingAccess$getBinding6.animatedPathImageView) != null) {
                        Double instantaneousSpeed4 = treadmillData.getInstantaneousSpeed();
                        animatedPathImageView.updateSpeed(instantaneousSpeed4 != null ? (float) instantaneousSpeed4.doubleValue() : 0.0f);
                    }
                    Integer totalDistance4 = treadmillData.getTotalDistance();
                    if (totalDistance4 != null) {
                        iIntValue = totalDistance4.intValue();
                        i = iIntValue;
                    }
                }
                this.this$0.setOldFtmsData(ftmsBaseData);
                this.this$0.setProgressBar();
                FragmentClubRaceBinding fragmentClubRaceBindingAccess$getBinding7 = ClubRaceFragment.access$getBinding(this.this$0);
                if (fragmentClubRaceBindingAccess$getBinding7 != null && (animatedPathImageView3 = fragmentClubRaceBindingAccess$getBinding7.animatedPathImageView) != null) {
                    totalDistanceKm = animatedPathImageView3.getTotalDistanceKm();
                }
                if (i >= totalDistanceKm * 1000) {
                    this.this$0.setFinish(true);
                    FtmsDeviceManager ftmsDeviceManager = BleManager.getInstance().getFtmsDeviceManager();
                    if (ftmsDeviceManager != null) {
                        ftmsDeviceManager.setRaceFinish(true);
                    }
                    this.this$0.finishRace();
                    FragmentClubRaceBinding fragmentClubRaceBindingAccess$getBinding8 = ClubRaceFragment.access$getBinding(this.this$0);
                    if (fragmentClubRaceBindingAccess$getBinding8 != null && (animatedPathImageView2 = fragmentClubRaceBindingAccess$getBinding8.animatedPathImageView) != null) {
                        animatedPathImageView2.pauseAnimation();
                    }
                    BleManager.getInstance().sendCmdFtms(FitnessMachineControlPointCmd.pause());
                    Thread.sleep(200L);
                    BleManager.getInstance().sendCmdFtms(FitnessMachineControlPointCmd.stop());
                }
            }
        }

        @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
        public void onReceiveTrainingStatus(TrainingStatusType trainingStatusType) {
            if (this.this$0.getIsStart()) {
                this.this$0.showIdle(BleDataManager.getInstance().getNowTrainingStatusType());
                this.this$0.isPaused(BleDataManager.getInstance().getNowFMSTypeOnlyFourType());
            }
        }

        @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
        public void onReceiveFitnessMachineStatus(FitnessMachineStatusType fitnessMachineStatusType) {
            FitnessMachineStatusType nowFMSTypeOnlyFourType;
            FragmentClubRaceBinding fragmentClubRaceBindingAccess$getBinding;
            LinearLayout linearLayout;
            if (fitnessMachineStatusType == null || (nowFMSTypeOnlyFourType = BleDataManager.getInstance().getNowFMSTypeOnlyFourType()) == null) {
                return;
            }
            if (this.this$0.getIsStart()) {
                this.this$0.showIdle(BleDataManager.getInstance().getNowTrainingStatusType());
                this.this$0.isPaused(nowFMSTypeOnlyFourType);
            } else {
                if (BleDataManager.getInstance().getNowTrainingStatusType() == TrainingStatusType.IDLE || nowFMSTypeOnlyFourType == FitnessMachineStatusType.FITNESS_MACHINE_STOPPED_BY_THE_USER || nowFMSTypeOnlyFourType == FitnessMachineStatusType.FITNESS_MACHINE_PAUSED_BY_THE_USER || (fragmentClubRaceBindingAccess$getBinding = ClubRaceFragment.access$getBinding(this.this$0)) == null || (linearLayout = fragmentClubRaceBindingAccess$getBinding.start) == null) {
                    return;
                }
                linearLayout.performClick();
            }
        }

        @Override // com.soletreadmills.sole_v2.listener.BluetoothCallbackListener
        public void onReceiveFitnessMachineControlPoint(FitnessMachineControlPointResponseData fitnessMachineControlPointResponseData) {
            if ((fitnessMachineControlPointResponseData != null ? fitnessMachineControlPointResponseData.getOpCodeType() : null) == FitnessMachineControlPointOpCode.Type.START_OR_RESUME && fitnessMachineControlPointResponseData.getResultCodeType() == FitnessMachineControlPointResultCode.Type.SUCCESS) {
                Timber.INSTANCE.e("onReceiveFitnessMachineControlPoint", new Object[0]);
                this.this$0.startRace();
            }
        }
    };

    /* compiled from: ClubRaceFragment.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[BleFtmsMachineType.values().length];
            try {
                iArr[BleFtmsMachineType.ROWER.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[BleFtmsMachineType.STEPPER.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[BleFtmsMachineType.TREADMILL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[BleFtmsMachineType.BIKE.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[BleFtmsMachineType.ELLIPTICAL.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[DisplayStatsType.values().length];
            try {
                iArr2[DisplayStatsType.TIME.ordinal()] = 1;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                iArr2[DisplayStatsType.REMAINING_TIME.ordinal()] = 2;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                iArr2[DisplayStatsType.DISTANCE.ordinal()] = 3;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                iArr2[DisplayStatsType.SPEED.ordinal()] = 4;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                iArr2[DisplayStatsType.PACE.ordinal()] = 5;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                iArr2[DisplayStatsType.AVG_PACE.ordinal()] = 6;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                iArr2[DisplayStatsType.HEART_RATE.ordinal()] = 7;
            } catch (NoSuchFieldError unused12) {
            }
            try {
                iArr2[DisplayStatsType.INCLINE.ordinal()] = 8;
            } catch (NoSuchFieldError unused13) {
            }
            try {
                iArr2[DisplayStatsType.CALORIES.ordinal()] = 9;
            } catch (NoSuchFieldError unused14) {
            }
            try {
                iArr2[DisplayStatsType.METS.ordinal()] = 10;
            } catch (NoSuchFieldError unused15) {
            }
            try {
                iArr2[DisplayStatsType.ASCENT.ordinal()] = 11;
            } catch (NoSuchFieldError unused16) {
            }
            try {
                iArr2[DisplayStatsType.OUTPUT.ordinal()] = 12;
            } catch (NoSuchFieldError unused17) {
            }
            try {
                iArr2[DisplayStatsType.RESISTANCE.ordinal()] = 13;
            } catch (NoSuchFieldError unused18) {
            }
            try {
                iArr2[DisplayStatsType.CADENCE.ordinal()] = 14;
            } catch (NoSuchFieldError unused19) {
            }
            try {
                iArr2[DisplayStatsType.STRIDES.ordinal()] = 15;
            } catch (NoSuchFieldError unused20) {
            }
            try {
                iArr2[DisplayStatsType.AVG_SPEED.ordinal()] = 16;
            } catch (NoSuchFieldError unused21) {
            }
            try {
                iArr2[DisplayStatsType.AVG_CADENCE.ordinal()] = 17;
            } catch (NoSuchFieldError unused22) {
            }
            try {
                iArr2[DisplayStatsType.STROKES.ordinal()] = 18;
            } catch (NoSuchFieldError unused23) {
            }
            try {
                iArr2[DisplayStatsType.FLOORS.ordinal()] = 19;
            } catch (NoSuchFieldError unused24) {
            }
            try {
                iArr2[DisplayStatsType.STEPS.ordinal()] = 20;
            } catch (NoSuchFieldError unused25) {
            }
            try {
                iArr2[DisplayStatsType.CALORIES_PER_MIN.ordinal()] = 21;
            } catch (NoSuchFieldError unused26) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX WARN: Type inference failed for: r0v5, types: [com.soletreadmills.sole_v2.ui.club.ClubRaceFragment$bluetoothCallbackListener$1] */
    public ClubRaceFragment() {
        final ClubRaceFragment clubRaceFragment = this;
        final Function0 function0 = null;
        this.viewModel = FragmentViewModelLazyKt.createViewModelLazy(clubRaceFragment, Reflection.getOrCreateKotlinClass(ClubRaceViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubRaceFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = clubRaceFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubRaceFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = clubRaceFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.club.ClubRaceFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = clubRaceFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    public static final /* synthetic */ FragmentClubRaceBinding access$getBinding(ClubRaceFragment clubRaceFragment) {
        return clubRaceFragment.getBinding();
    }

    public final ClubRaceViewModel getViewModel() {
        return (ClubRaceViewModel) this.viewModel.getValue();
    }

    /* renamed from: isStart, reason: from getter */
    public final boolean getIsStart() {
        return this.isStart;
    }

    public final void setStart(boolean z) {
        this.isStart = z;
    }

    public final BleFtmsMachineType getBleFtmsMachineType() {
        return this.bleFtmsMachineType;
    }

    public final void setBleFtmsMachineType(BleFtmsMachineType bleFtmsMachineType) {
        Intrinsics.checkNotNullParameter(bleFtmsMachineType, "<set-?>");
        this.bleFtmsMachineType = bleFtmsMachineType;
    }

    public final FtmsBaseData getFirstFtmsData() {
        return this.firstFtmsData;
    }

    public final void setFirstFtmsData(FtmsBaseData ftmsBaseData) {
        this.firstFtmsData = ftmsBaseData;
    }

    public final FtmsBaseData getOldFtmsData() {
        return this.oldFtmsData;
    }

    public final void setOldFtmsData(FtmsBaseData ftmsBaseData) {
        this.oldFtmsData = ftmsBaseData;
    }

    public final String getTicket() {
        return this.ticket;
    }

    public final void setTicket(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.ticket = str;
    }

    /* renamed from: isCallBack, reason: from getter */
    public final boolean getIsCallBack() {
        return this.isCallBack;
    }

    public final void setCallBack(boolean z) {
        this.isCallBack = z;
    }

    /* renamed from: isCallApi, reason: from getter */
    public final boolean getIsCallApi() {
        return this.isCallApi;
    }

    public final void setCallApi(boolean z) {
        this.isCallApi = z;
    }

    /* renamed from: isFinish, reason: from getter */
    public final boolean getIsFinish() {
        return this.isFinish;
    }

    public final void setFinish(boolean z) {
        this.isFinish = z;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        TextView textView;
        CharSequence text;
        String string;
        FragmentClubRaceBinding binding;
        View root;
        super.onResume();
        FragmentClubRaceBinding binding2 = getBinding();
        if (binding2 == null || (textView = binding2.tvStartOrFinish) == null || (text = textView.getText()) == null || (string = text.toString()) == null || !string.equals(getString(R.string.finish_02)) || this.isCallBack || (binding = getBinding()) == null || (root = binding.getRoot()) == null) {
            return;
        }
        root.postDelayed(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.club.ClubRaceFragment$$ExternalSyntheticLambda3
            @Override // java.lang.Runnable
            public final void run() {
                ClubRaceFragment.onResume$lambda$0(this.f$0);
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onResume$lambda$0(ClubRaceFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.safeNavigateUp();
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        AnimatedPathImageView animatedPathImageView;
        super.onStop();
        FragmentClubRaceBinding binding = getBinding();
        if (binding == null || (animatedPathImageView = binding.animatedPathImageView) == null) {
            return;
        }
        animatedPathImageView.stopAnimation();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        BleManager bleManager;
        super.onDestroyView();
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null && (bleManager = mainActivity.getBleManager()) != null) {
            bleManager.removeBluetoothCallbackListener(this.bluetoothCallbackListener);
        }
        BleDataManager.getInstance().setFirstFtmsData(null);
        FtmsDeviceManager ftmsDeviceManager = BleManager.getInstance().getFtmsDeviceManager();
        if (ftmsDeviceManager != null) {
            ftmsDeviceManager.setRaceFinish(false);
        }
        Global global = Global.INSTANCE;
        Global.clubRaceTicket = "";
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentClubRaceBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentClubRaceBinding fragmentClubRaceBindingInflate = FragmentClubRaceBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentClubRaceBindingInflate, "inflate(...)");
        return fragmentClubRaceBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() throws IOException {
        BleManager bleManager;
        FtmsDeviceManager ftmsDeviceManager;
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        LinearLayout linearLayout4;
        LinearLayout linearLayout5;
        LinearLayout linearLayout6;
        BleManager bleManager2;
        FtmsDeviceManager ftmsDeviceManager2 = BleManager.getInstance().getFtmsDeviceManager();
        if (ftmsDeviceManager2 != null) {
            ftmsDeviceManager2.setRaceFinish(false);
        }
        Global global = Global.INSTANCE;
        Global.clubRaceTicket = "";
        MainActivity mainActivity = getMainActivity();
        if (mainActivity != null && (bleManager2 = mainActivity.getBleManager()) != null) {
            bleManager2.addBluetoothCallbackListener(this.bluetoothCallbackListener);
        }
        FragmentClubRaceBinding binding = getBinding();
        if (binding != null && (linearLayout6 = binding.LLLeave) != null) {
            linearLayout6.setOnClickListener(this);
        }
        FragmentClubRaceBinding binding2 = getBinding();
        if (binding2 != null && (linearLayout5 = binding2.start) != null) {
            linearLayout5.setOnClickListener(this);
        }
        FragmentClubRaceBinding binding3 = getBinding();
        if (binding3 != null && (linearLayout4 = binding3.layoutDisplay1Click) != null) {
            linearLayout4.setOnClickListener(this);
        }
        FragmentClubRaceBinding binding4 = getBinding();
        if (binding4 != null && (linearLayout3 = binding4.layoutDisplay2Click) != null) {
            linearLayout3.setOnClickListener(this);
        }
        FragmentClubRaceBinding binding5 = getBinding();
        if (binding5 != null && (linearLayout2 = binding5.layoutDisplay3Click) != null) {
            linearLayout2.setOnClickListener(this);
        }
        FragmentClubRaceBinding binding6 = getBinding();
        if (binding6 != null && (linearLayout = binding6.layoutDisplay4Click) != null) {
            linearLayout.setOnClickListener(this);
        }
        MainActivity mainActivity2 = getMainActivity();
        BleFtmsMachineType bleFtmsMachineType = (mainActivity2 == null || (bleManager = mainActivity2.getBleManager()) == null || (ftmsDeviceManager = bleManager.getFtmsDeviceManager()) == null) ? null : ftmsDeviceManager.getBleFtmsMachineType();
        if (bleFtmsMachineType == null) {
            bleFtmsMachineType = BleFtmsMachineType.TREADMILL;
        }
        this.bleFtmsMachineType = bleFtmsMachineType;
        getViewModel().loadStatsForMachine(this.bleFtmsMachineType);
        setRaceView();
        LifecycleOwnerKt.getLifecycleScope(this).launchWhenStarted(new AnonymousClass1(null));
        OnBackPressedDispatcher onBackPressedDispatcher = requireActivity().getOnBackPressedDispatcher();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        onBackPressedDispatcher.addCallback(viewLifecycleOwner, new OnBackPressedCallback() { // from class: com.soletreadmills.sole_v2.ui.club.ClubRaceFragment.initViews.2
            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
            }
        });
        setBlueToothConnectStatus();
        TrainingStatusType nowTrainingStatusType = BleDataManager.getInstance().getNowTrainingStatusType();
        FitnessMachineStatusType nowFMSTypeOnlyFourType = BleDataManager.getInstance().getNowFMSTypeOnlyFourType();
        if (nowTrainingStatusType == TrainingStatusType.IDLE || nowFMSTypeOnlyFourType == FitnessMachineStatusType.FITNESS_MACHINE_STOPPED_BY_THE_USER || nowFMSTypeOnlyFourType == FitnessMachineStatusType.FITNESS_MACHINE_STOPPED_BY_SAFETY_KEY || nowFMSTypeOnlyFourType == FitnessMachineStatusType.FITNESS_MACHINE_PAUSED_BY_THE_USER) {
            return;
        }
        startRace();
    }

    /* compiled from: ClubRaceFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubRaceFragment$initViews$1", f = "ClubRaceFragment.kt", i = {}, l = {139}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubRaceFragment$initViews$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubRaceFragment.this.new AnonymousClass1(continuation);
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
                StateFlow<List<DisplaySelectStatsData>> selectedList = ClubRaceFragment.this.getViewModel().getSelectedList();
                final ClubRaceFragment clubRaceFragment = ClubRaceFragment.this;
                this.label = 1;
                if (selectedList.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.club.ClubRaceFragment.initViews.1.1
                    @Override // kotlinx.coroutines.flow.FlowCollector
                    public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                        return emit((List<DisplaySelectStatsData>) obj2, (Continuation<? super Unit>) continuation);
                    }

                    public final Object emit(List<DisplaySelectStatsData> list, Continuation<? super Unit> continuation) {
                        clubRaceFragment.setDisplayView(list);
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

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        BleManager bleManager;
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.LL_leave;
        if (numValueOf != null && numValueOf.intValue() == i) {
            if (this.isCallBack) {
                return;
            }
            this.isCallBack = true;
            safeNavigateUp();
            return;
        }
        int i2 = R.id.start;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            MainActivity mainActivity = getMainActivity();
            if (mainActivity == null || (bleManager = mainActivity.getBleManager()) == null || !bleManager.isConnectedFtms() || this.isCallApi) {
                return;
            }
            startRace4VirtualRace();
            return;
        }
        int i3 = R.id.layout_display1Click;
        if (numValueOf != null && numValueOf.intValue() == i3) {
            openSelectDisplayStatsView(0);
            return;
        }
        int i4 = R.id.layout_display2Click;
        if (numValueOf != null && numValueOf.intValue() == i4) {
            openSelectDisplayStatsView(1);
            return;
        }
        int i5 = R.id.layout_display3Click;
        if (numValueOf != null && numValueOf.intValue() == i5) {
            openSelectDisplayStatsView(2);
            return;
        }
        int i6 = R.id.layout_display4Click;
        if (numValueOf != null && numValueOf.intValue() == i6) {
            openSelectDisplayStatsView(3);
        }
    }

    public final void setRaceView() throws IOException {
        String virtualRaceCode;
        AnimatedPathImageView animatedPathImageView;
        String photoFileUrl;
        AnimatedPathImageView animatedPathImageView2;
        AnimatedPathImageView animatedPathImageView3;
        AnimatedPathImageView animatedPathImageView4;
        VirtualRaceCodeType.Companion companion = VirtualRaceCodeType.INSTANCE;
        ChallengeItemSimpleDataWithMemberData challengeItemSimpleDataWithMemberData = getViewModel().getChallengeItemSimpleDataWithMemberData();
        if (challengeItemSimpleDataWithMemberData == null || (virtualRaceCode = challengeItemSimpleDataWithMemberData.getVirtualRaceCode()) == null) {
            virtualRaceCode = "T_3K";
        }
        VirtualRaceCodeType virtualRaceCodeTypeFromCode = companion.fromCode(virtualRaceCode);
        if (virtualRaceCodeTypeFromCode == null) {
            virtualRaceCodeTypeFromCode = VirtualRaceCodeType.T_3K;
        }
        FragmentClubRaceBinding binding = getBinding();
        AnimatedPathImageView animatedPathImageView5 = binding != null ? binding.animatedPathImageView : null;
        if (animatedPathImageView5 != null) {
            animatedPathImageView5.setRacePathType(virtualRaceCodeTypeFromCode);
        }
        FragmentClubRaceBinding binding2 = getBinding();
        TextView textView = binding2 != null ? binding2.tvDistance : null;
        String str = "";
        if (textView != null) {
            textView.setText("" + virtualRaceCodeTypeFromCode.getDistanceKm() + 'K');
        }
        FragmentClubRaceBinding binding3 = getBinding();
        if (binding3 != null && (animatedPathImageView4 = binding3.animatedPathImageView) != null) {
            animatedPathImageView4.updateSpeed(480.0f);
        }
        FragmentClubRaceBinding binding4 = getBinding();
        if (binding4 != null && (animatedPathImageView3 = binding4.animatedPathImageView) != null) {
            animatedPathImageView3.resetView();
        }
        Timber.INSTANCE.e("startAnimation", new Object[0]);
        FragmentClubRaceBinding binding5 = getBinding();
        if (binding5 != null && (animatedPathImageView2 = binding5.animatedPathImageView) != null) {
            animatedPathImageView2.stopAnimation();
        }
        changeScaleFactor();
        LoginUserData loginUserData = Global.userData;
        if (loginUserData != null && (photoFileUrl = loginUserData.getPhotoFileUrl()) != null) {
            str = photoFileUrl;
        }
        FragmentClubRaceBinding binding6 = getBinding();
        if (binding6 == null || (animatedPathImageView = binding6.animatedPathImageView) == null) {
            return;
        }
        animatedPathImageView.setMainUserBitmap(str);
    }

    public final void setProgressBar() {
        View root;
        FragmentClubRaceBinding binding = getBinding();
        if (binding == null || (root = binding.getRoot()) == null) {
            return;
        }
        root.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.club.ClubRaceFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                ClubRaceFragment.setProgressBar$lambda$1(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setProgressBar$lambda$1(ClubRaceFragment this$0) {
        AnimatedPathImageView animatedPathImageView;
        AnimatedPathImageView animatedPathImageView2;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        FragmentClubRaceBinding binding = this$0.getBinding();
        float currentDistance = (binding == null || (animatedPathImageView2 = binding.animatedPathImageView) == null) ? 0.0f : animatedPathImageView2.getCurrentDistance();
        FragmentClubRaceBinding binding2 = this$0.getBinding();
        float fCoerceIn = RangesKt.coerceIn(currentDistance / ((binding2 == null || (animatedPathImageView = binding2.animatedPathImageView) == null) ? 0.0f : animatedPathImageView.getTotalDistanceKm()), 0.0f, 1.0f) * 100;
        FragmentClubRaceBinding binding3 = this$0.getBinding();
        ProgressBar progressBar = binding3 != null ? binding3.progressBar : null;
        if (progressBar == null) {
            return;
        }
        progressBar.setProgress((int) fCoerceIn);
    }

    public final void changeScaleFactor() {
        AnimatedPathImageView animatedPathImageView;
        FragmentClubRaceBinding binding = getBinding();
        if (binding == null || (animatedPathImageView = binding.animatedPathImageView) == null) {
            return;
        }
        animatedPathImageView.setScaleFactor(3.0f);
    }

    public final void openSelectDisplayStatsView(int pos) {
        ChangeViewManager changeViewManager;
        getViewModel().updateSelection(pos);
        getViewModel().getStatsList();
        MainActivity mainActivity = getMainActivity();
        if (mainActivity == null || (changeViewManager = mainActivity.getChangeViewManager()) == null) {
            return;
        }
        String string = getString(R.string.select_parameter);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        changeViewManager.changePage(new DisplayStatsSelectCustom(mainActivity, string, getViewModel().getStatsList().getValue(), new DisplayStatsSelectCustom.BottomDialogCustomListener() { // from class: com.soletreadmills.sole_v2.ui.club.ClubRaceFragment$openSelectDisplayStatsView$1$1
            @Override // com.soletreadmills.sole_v2.ui.customview.DisplayStatsSelectCustom.BottomDialogCustomListener
            public void onClick(int pos2, DisplayStatsType newType) {
                Intrinsics.checkNotNullParameter(newType, "newType");
                this.this$0.getViewModel().updateSelectionWithNewType(newType);
            }
        }));
    }

    public final void startRace() {
        AnimatedPathImageView animatedPathImageView;
        FragmentClubRaceBinding binding = getBinding();
        TextView textView = binding != null ? binding.tvStartOrFinish : null;
        if (textView != null) {
            textView.setText(getString(R.string.ready));
        }
        FragmentClubRaceBinding binding2 = getBinding();
        ConstraintLayout constraintLayout = binding2 != null ? binding2.layoutTopView : null;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        FragmentClubRaceBinding binding3 = getBinding();
        if (binding3 != null && (animatedPathImageView = binding3.animatedPathImageView) != null) {
            animatedPathImageView.setOtherUsers();
        }
        this.isStart = true;
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09521(null), 3, null);
    }

    /* compiled from: ClubRaceFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubRaceFragment$startRace$1", f = "ClubRaceFragment.kt", i = {}, l = {301}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubRaceFragment$startRace$1, reason: invalid class name and case insensitive filesystem */
    static final class C09521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C09521(Continuation<? super C09521> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubRaceFragment.this.new C09521(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09521) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            AnimatedPathImageView animatedPathImageView;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (DelayKt.delay(1000L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            FragmentClubRaceBinding fragmentClubRaceBindingAccess$getBinding = ClubRaceFragment.access$getBinding(ClubRaceFragment.this);
            ConstraintLayout constraintLayout = fragmentClubRaceBindingAccess$getBinding != null ? fragmentClubRaceBindingAccess$getBinding.layoutTopView : null;
            if (constraintLayout != null) {
                constraintLayout.setVisibility(8);
            }
            FragmentClubRaceBinding fragmentClubRaceBindingAccess$getBinding2 = ClubRaceFragment.access$getBinding(ClubRaceFragment.this);
            if (fragmentClubRaceBindingAccess$getBinding2 != null && (animatedPathImageView = fragmentClubRaceBindingAccess$getBinding2.animatedPathImageView) != null) {
                animatedPathImageView.startAnimation();
            }
            ClubRaceFragment.this.showDisplayInfo();
            return Unit.INSTANCE;
        }
    }

    public final void finishRace() {
        View root;
        FragmentClubRaceBinding binding = getBinding();
        TextView textView = binding != null ? binding.tvStartOrFinish : null;
        if (textView != null) {
            textView.setText(getString(R.string.finish_02));
        }
        FragmentClubRaceBinding binding2 = getBinding();
        ConstraintLayout constraintLayout = binding2 != null ? binding2.layoutTopView : null;
        if (constraintLayout != null) {
            constraintLayout.setVisibility(0);
        }
        Global global = Global.INSTANCE;
        Global.clubRaceTicket = this.ticket;
        BleDataManager.getInstance().uploadSummaryData();
        FragmentClubRaceBinding binding3 = getBinding();
        if (binding3 == null || (root = binding3.getRoot()) == null) {
            return;
        }
        root.postDelayed(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.club.ClubRaceFragment$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                ClubRaceFragment.finishRace$lambda$3(this.f$0);
            }
        }, 3000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void finishRace$lambda$3(ClubRaceFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        this$0.safeNavigateUp();
    }

    public final void showDisplayInfo() {
        FragmentClubRaceBinding binding = getBinding();
        LinearLayout linearLayout = binding != null ? binding.layoutDistance : null;
        if (linearLayout != null) {
            linearLayout.setVisibility(8);
        }
        FragmentClubRaceBinding binding2 = getBinding();
        LinearLayout linearLayout2 = binding2 != null ? binding2.layoutStart : null;
        if (linearLayout2 != null) {
            linearLayout2.setVisibility(8);
        }
        FragmentClubRaceBinding binding3 = getBinding();
        LinearLayout linearLayout3 = binding3 != null ? binding3.layoutDisplay1 : null;
        if (linearLayout3 != null) {
            linearLayout3.setVisibility(0);
        }
        FragmentClubRaceBinding binding4 = getBinding();
        LinearLayout linearLayout4 = binding4 != null ? binding4.layoutDisplay2 : null;
        if (linearLayout4 == null) {
            return;
        }
        linearLayout4.setVisibility(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setDisplayView(List<DisplaySelectStatsData> list) {
        if (list.size() >= 4) {
            for (int i = 0; i < 4; i++) {
                DisplaySelectStatsData displaySelectStatsData = list.get(i);
                if (i == 0) {
                    FragmentClubRaceBinding binding = getBinding();
                    ImageView imageView = binding != null ? binding.imgDisplay1 : null;
                    FragmentClubRaceBinding binding2 = getBinding();
                    setDisplayContentView(displaySelectStatsData, imageView, binding2 != null ? binding2.tvDisplay1 : null);
                } else if (i == 1) {
                    FragmentClubRaceBinding binding3 = getBinding();
                    ImageView imageView2 = binding3 != null ? binding3.imgDisplay2 : null;
                    FragmentClubRaceBinding binding4 = getBinding();
                    setDisplayContentView(displaySelectStatsData, imageView2, binding4 != null ? binding4.tvDisplay2 : null);
                } else if (i == 2) {
                    FragmentClubRaceBinding binding5 = getBinding();
                    ImageView imageView3 = binding5 != null ? binding5.imgDisplay3 : null;
                    FragmentClubRaceBinding binding6 = getBinding();
                    setDisplayContentView(displaySelectStatsData, imageView3, binding6 != null ? binding6.tvDisplay3 : null);
                } else if (i == 3) {
                    FragmentClubRaceBinding binding7 = getBinding();
                    ImageView imageView4 = binding7 != null ? binding7.imgDisplay4 : null;
                    FragmentClubRaceBinding binding8 = getBinding();
                    setDisplayContentView(displaySelectStatsData, imageView4, binding8 != null ? binding8.tvDisplay4 : null);
                }
            }
        }
    }

    public final void setDisplayContentView(DisplaySelectStatsData data, ImageView img, TextView tv) {
        String string;
        String string2;
        String string3;
        String string4;
        String string5;
        String string6;
        Intrinsics.checkNotNullParameter(data, "data");
        if (img == null || tv == null) {
            return;
        }
        boolean unitType = Global.INSTANCE.getUnitType();
        switch (WhenMappings.$EnumSwitchMapping$1[data.getType().ordinal()]) {
            case 1:
                tv.setText(getString(R.string.elapsed));
                img.setImageResource(R.drawable.ic_stats_timer_fill03);
                break;
            case 2:
                tv.setText(getString(R.string.remaining_time));
                img.setImageResource(R.drawable.ic_stats_timer_fill02);
                break;
            case 3:
                if (unitType) {
                    string = getString(R.string.mi);
                } else {
                    string = getString(R.string.km);
                }
                tv.setText(string);
                img.setImageResource(R.drawable.ic_stats_distance02);
                break;
            case 4:
                if (unitType) {
                    string2 = getString(R.string.mi_h);
                } else {
                    string2 = getString(R.string.km_h);
                }
                tv.setText(string2);
                img.setImageResource(R.drawable.ic_stats_speed02);
                break;
            case 5:
                if (unitType) {
                    string3 = getString(R.string.min_mi);
                } else {
                    string3 = getString(R.string.min_km);
                }
                tv.setText(string3);
                img.setImageResource(R.drawable.ic_activity_run02);
                break;
            case 6:
                if (unitType) {
                    string4 = getString(R.string.avg_min_mi);
                } else {
                    string4 = getString(R.string.avg_min_km);
                }
                tv.setText(string4);
                img.setImageResource(R.drawable.ic_activity_run02);
                break;
            case 7:
                tv.setText(getString(R.string.bpm));
                img.setImageResource(R.drawable.ic_stats_hr02);
                break;
            case 8:
                tv.setText(getString(R.string.incline));
                img.setImageResource(R.drawable.ic_stats_incline02);
                break;
            case 9:
                tv.setText(getString(R.string.kcal));
                img.setImageResource(R.drawable.ic_stats_calories02);
                break;
            case 10:
                tv.setText(getString(R.string.mets));
                img.setImageResource(R.drawable.ic_stats_mets02);
                break;
            case 11:
                if (unitType) {
                    string5 = getString(R.string.ft_ascent);
                } else {
                    string5 = getString(R.string.m_ascent);
                }
                tv.setText(string5);
                img.setImageResource(R.drawable.ic_stats_ascent02);
                break;
            case 12:
                tv.setText(getString(R.string.watts));
                img.setImageResource(R.drawable.ic_stats_power02);
                break;
            case 13:
                tv.setText(getString(R.string.resistance));
                img.setImageResource(R.drawable.ic_level_expert02);
                break;
            case 14:
                int i = WhenMappings.$EnumSwitchMapping$0[this.bleFtmsMachineType.ordinal()];
                if (i == 1 || i == 2) {
                    tv.setText(getString(R.string.spm));
                } else {
                    tv.setText(getString(R.string.rpm));
                }
                img.setImageResource(R.drawable.ic_stats_cadence_rpm02);
                break;
            case 15:
                tv.setText(getString(R.string.strides));
                img.setImageResource(R.drawable.ic_stats_steps02);
                break;
            case 16:
                if (unitType) {
                    string6 = getString(R.string.avg_mi_h);
                } else {
                    string6 = getString(R.string.avg_km_h);
                }
                tv.setText(string6);
                img.setImageResource(R.drawable.ic_stats_speed02);
                break;
            case 17:
                int i2 = WhenMappings.$EnumSwitchMapping$0[this.bleFtmsMachineType.ordinal()];
                if (i2 == 1 || i2 == 2) {
                    tv.setText(getString(R.string.avg_spm));
                } else {
                    tv.setText(getString(R.string.avg_rpm));
                }
                img.setImageResource(R.drawable.ic_stats_cadence_rpm02);
                break;
            case 18:
                tv.setText(getString(R.string.strokes));
                img.setImageResource(R.drawable.ic_stats_strokes02);
                break;
            case 19:
                tv.setText(getString(R.string.floors));
                img.setImageResource(R.drawable.ic_stats_floors02);
                break;
            case 20:
                tv.setText(getString(R.string.steps));
                img.setImageResource(R.drawable.ic_stats_steps02);
                break;
            case 21:
                tv.setText(getString(R.string.kcal_min));
                img.setImageResource(R.drawable.ic_stats_calories02);
                break;
        }
    }

    public final void setDisPlayValue(int pos, DisplaySelectStatsData data, FtmsBaseData ftmsData) throws NumberFormatException {
        TextView textView;
        Intrinsics.checkNotNullParameter(data, "data");
        String displayValue = getDisplayValue(data.getType(), ftmsData);
        if (this.isStart) {
            if (this.firstFtmsData == null) {
                this.firstFtmsData = ftmsData;
                BleDataManager.getInstance().setFirstFtmsData(this.firstFtmsData);
                return;
            }
            if (pos == 0) {
                FragmentClubRaceBinding binding = getBinding();
                textView = binding != null ? binding.tvDisplay1Title : null;
                if (textView == null) {
                    return;
                }
                textView.setText(displayValue);
                return;
            }
            if (pos == 1) {
                FragmentClubRaceBinding binding2 = getBinding();
                textView = binding2 != null ? binding2.tvDisplay2Title : null;
                if (textView == null) {
                    return;
                }
                textView.setText(displayValue);
                return;
            }
            if (pos == 2) {
                FragmentClubRaceBinding binding3 = getBinding();
                textView = binding3 != null ? binding3.tvDisplay3Title : null;
                if (textView == null) {
                    return;
                }
                textView.setText(displayValue);
                return;
            }
            if (pos != 3) {
                return;
            }
            FragmentClubRaceBinding binding4 = getBinding();
            textView = binding4 != null ? binding4.tvDisplay4Title : null;
            if (textView == null) {
                return;
            }
            textView.setText(displayValue);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:180:0x02ab A[PHI: r17
      0x02ab: PHI (r17v1 java.lang.String) = 
      (r17v0 java.lang.String)
      (r17v2 java.lang.String)
      (r17v3 java.lang.String)
      (r17v4 java.lang.String)
      (r17v7 java.lang.String)
     binds: [B:313:0x0459, B:253:0x0393, B:179:0x02a8, B:132:0x01ca, B:73:0x00f1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:181:0x02af A[PHI: r7
      0x02af: PHI (r7v4 java.lang.String) = (r7v2 java.lang.String), (r7v6 java.lang.String), (r7v9 java.lang.String), (r7v15 java.lang.String) binds: [B:313:0x0459, B:179:0x02a8, B:132:0x01ca, B:73:0x00f1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:182:0x02b2 A[PHI: r12
      0x02b2: PHI (r12v4 java.lang.String) = 
      (r12v2 java.lang.String)
      (r12v7 java.lang.String)
      (r12v10 java.lang.String)
      (r12v13 java.lang.String)
      (r12v17 java.lang.String)
     binds: [B:313:0x0459, B:252:0x0390, B:179:0x02a8, B:132:0x01ca, B:73:0x00f1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:183:0x02b5 A[PHI: r1
      0x02b5: PHI (r1v3 java.lang.String) = 
      (r1v2 java.lang.String)
      (r1v5 java.lang.String)
      (r1v13 java.lang.String)
      (r1v19 java.lang.String)
      (r1v31 java.lang.String)
     binds: [B:313:0x0459, B:242:0x037d, B:179:0x02a8, B:132:0x01ca, B:73:0x00f1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:184:0x02b8 A[PHI: r11
      0x02b8: PHI (r11v4 java.lang.String) = 
      (r11v2 java.lang.String)
      (r11v7 java.lang.String)
      (r11v11 java.lang.String)
      (r11v15 java.lang.String)
      (r11v19 java.lang.String)
     binds: [B:313:0x0459, B:253:0x0393, B:179:0x02a8, B:132:0x01ca, B:73:0x00f1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:185:0x02bb A[PHI: r10
      0x02bb: PHI (r10v4 java.lang.String) = 
      (r10v2 java.lang.String)
      (r10v7 java.lang.String)
      (r10v11 java.lang.String)
      (r10v15 java.lang.String)
      (r10v19 java.lang.String)
     binds: [B:313:0x0459, B:253:0x0393, B:179:0x02a8, B:132:0x01ca, B:73:0x00f1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:186:0x02be A[PHI: r9
      0x02be: PHI (r9v4 java.lang.String) = 
      (r9v2 java.lang.String)
      (r9v7 java.lang.String)
      (r9v12 java.lang.String)
      (r9v16 java.lang.String)
      (r9v21 java.lang.String)
     binds: [B:313:0x0459, B:245:0x0382, B:179:0x02a8, B:132:0x01ca, B:73:0x00f1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:187:0x02c1 A[PHI: r8
      0x02c1: PHI (r8v4 java.lang.String) = 
      (r8v2 java.lang.String)
      (r8v7 java.lang.String)
      (r8v7 java.lang.String)
      (r8v11 java.lang.String)
      (r8v15 java.lang.String)
      (r8v19 java.lang.String)
     binds: [B:313:0x0459, B:247:0x0386, B:251:0x038e, B:179:0x02a8, B:132:0x01ca, B:73:0x00f1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:188:0x02c4 A[PHI: r4
      0x02c4: PHI (r4v7 java.lang.String) = 
      (r4v4 java.lang.String)
      (r4v9 java.lang.String)
      (r4v14 java.lang.String)
      (r4v18 java.lang.String)
      (r4v22 java.lang.String)
     binds: [B:313:0x0459, B:252:0x0390, B:179:0x02a8, B:132:0x01ca, B:73:0x00f1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:189:0x02c7 A[PHI: r3
      0x02c7: PHI (r3v6 java.lang.String) = (r3v4 java.lang.String), (r3v12 java.lang.String), (r3v17 java.lang.String), (r3v20 java.lang.String) binds: [B:313:0x0459, B:179:0x02a8, B:132:0x01ca, B:73:0x00f1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:255:0x0398 A[PHI: r13
      0x0398: PHI (r13v6 java.lang.String) = (r13v4 java.lang.String), (r13v15 java.lang.String) binds: [B:253:0x0393, B:73:0x00f1] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:256:0x039b A[PHI: r5
      0x039b: PHI (r5v8 java.lang.String) = (r5v4 java.lang.String), (r5v13 java.lang.String), (r5v31 java.lang.String) binds: [B:313:0x0459, B:252:0x0390, B:132:0x01ca] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:257:0x039e A[PHI: r2
      0x039e: PHI (r2v6 java.lang.String) = (r2v5 java.lang.String), (r2v9 java.lang.String), (r2v17 java.lang.String), (r2v20 java.lang.String) binds: [B:313:0x0459, B:243:0x037f, B:132:0x01ca, B:73:0x00f1] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final java.lang.String getDisplayValue(com.soletreadmills.sole_v2._type.DisplayStatsType r19, com.soletreadmills.sole_v2.ble.data.FtmsBaseData r20) throws java.lang.NumberFormatException {
        /*
            Method dump skipped, instructions count: 1284
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.ui.club.ClubRaceFragment.getDisplayValue(com.soletreadmills.sole_v2._type.DisplayStatsType, com.soletreadmills.sole_v2.ble.data.FtmsBaseData):java.lang.String");
    }

    public final String calculateAveragePace(Integer totalTimeSec, Integer distance) {
        double dDoubleValue;
        if (totalTimeSec == null || totalTimeSec.intValue() <= 0 || distance == null || distance.intValue() <= 0) {
            return "0:00";
        }
        try {
            float fIntValue = distance.intValue() / 1000.0f;
            if (Global.INSTANCE.getUnitType()) {
                Double doubleOrNull = StringsKt.toDoubleOrNull(UnitConversion.INSTANCE.getMi(String.valueOf(fIntValue)));
                if (doubleOrNull == null) {
                    return "0:00";
                }
                dDoubleValue = doubleOrNull.doubleValue();
            } else {
                dDoubleValue = fIntValue;
            }
            int iIntValue = (int) (totalTimeSec.intValue() / dDoubleValue);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.US, "%d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(iIntValue / 60), Integer.valueOf(iIntValue % 60)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
            return "0:00";
        }
    }

    public final double calculateMets(Double speed, Double inclinePercent, Double watt) throws NumberFormatException {
        ClubRaceFragment clubRaceFragment;
        double d;
        double d2;
        double d3;
        String weight;
        LoginUserData loginUserData = Global.userData;
        double d4 = AudioStats.AUDIO_AMPLITUDE_NONE;
        if (loginUserData == null || (weight = loginUserData.getWeight()) == null) {
            clubRaceFragment = this;
            d = 0.0d;
        } else {
            d = Double.parseDouble(weight);
            clubRaceFragment = this;
        }
        try {
            int i = WhenMappings.$EnumSwitchMapping$0[clubRaceFragment.bleFtmsMachineType.ordinal()];
            if (i == 3) {
                double dDoubleValue = speed != null ? speed.doubleValue() : 0.0d;
                double d5 = 26.8d * dDoubleValue;
                double dDoubleValue2 = (inclinePercent != null ? inclinePercent.doubleValue() : 0.0d) / 100.0d;
                if (dDoubleValue >= 4.5d) {
                    d2 = (0.2d * d5) + 3.5d;
                    d3 = d5 * 0.9d;
                } else {
                    d2 = (0.1d * d5) + 3.5d;
                    d3 = d5 * 1.8d;
                }
                double d6 = d2 + (d3 * dDoubleValue2);
                if (d6 > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    d4 = d6 / 3.5d;
                }
            } else if (i == 4 || i == 5) {
                double dDoubleValue3 = (watt != null ? watt.doubleValue() : 0.0d) * 6;
                if (dDoubleValue3 > AudioStats.AUDIO_AMPLITUDE_NONE && d > AudioStats.AUDIO_AMPLITUDE_NONE) {
                    d4 = (7 + ((dDoubleValue3 * 1.8d) / d)) / 3.5d;
                }
            }
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
        }
        return MathKt.roundToInt(d4 * 10) / 10.0d;
    }

    private final String convertDistance(Float distanceM) {
        if (distanceM == null) {
            return SdkConstants.RES_QUALIFIER_SEP;
        }
        try {
            BigDecimal bigDecimal = new BigDecimal(String.valueOf(distanceM.floatValue()));
            BigDecimal bigDecimalValueOf = BigDecimal.valueOf(1000);
            Intrinsics.checkNotNullExpressionValue(bigDecimalValueOf, "valueOf(...)");
            BigDecimal bigDecimalDivide = bigDecimal.divide(bigDecimalValueOf, 4, RoundingMode.FLOOR);
            if (Global.INSTANCE.getUnitType()) {
                bigDecimalDivide = new BigDecimal(UnitConversion.INSTANCE.getMi(bigDecimalDivide.toString()));
            }
            DecimalFormat decimalFormat = new DecimalFormat("#0.##", DecimalFormatSymbols.getInstance(Locale.US));
            decimalFormat.setRoundingMode(RoundingMode.FLOOR);
            String str = decimalFormat.format(bigDecimalDivide);
            Intrinsics.checkNotNull(str);
            return str;
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
            return SdkConstants.RES_QUALIFIER_SEP;
        }
    }

    private final String convertTime(Integer seconds) {
        return TimeTools.INSTANCE.secToTime02(seconds != null ? seconds.intValue() : 0L, false);
    }

    private final String convertSpeed(Float speedKmh) throws NumberFormatException {
        double dFloatValue;
        if (speedKmh == null) {
            return SdkConstants.RES_QUALIFIER_SEP;
        }
        try {
            if (Global.INSTANCE.getUnitType()) {
                dFloatValue = Double.parseDouble(UnitConversion.INSTANCE.getMi(speedKmh.toString()));
            } else {
                dFloatValue = speedKmh.floatValue();
            }
            DecimalFormat decimalFormat = new DecimalFormat("#0.#", DecimalFormatSymbols.getInstance(Locale.US));
            decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
            String str = decimalFormat.format(dFloatValue);
            Intrinsics.checkNotNull(str);
            return str;
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
            return SdkConstants.RES_QUALIFIER_SEP;
        }
    }

    private final String convertPositiveElevationGain(Double elevation) {
        if (!Global.INSTANCE.getUnitType()) {
            return ConvertUtils.INSTANCE.formatToOneDecimal02(String.valueOf(elevation), SdkConstants.RES_QUALIFIER_SEP);
        }
        return ConvertUtils.INSTANCE.formatToOneDecimal02(UnitConversion.INSTANCE.getM_ToFt(elevation != null ? elevation.toString() : null), SdkConstants.RES_QUALIFIER_SEP);
    }

    public final String calculatePace(Double speedKmh) throws NumberFormatException {
        double dDoubleValue;
        if (speedKmh == null || speedKmh.doubleValue() <= AudioStats.AUDIO_AMPLITUDE_NONE) {
            return SdkConstants.RES_QUALIFIER_SEP;
        }
        try {
            if (Global.INSTANCE.getUnitType()) {
                dDoubleValue = Double.parseDouble(UnitConversion.INSTANCE.getMi(speedKmh.toString()));
            } else {
                dDoubleValue = speedKmh.doubleValue();
            }
            double d = 60.0d / dDoubleValue;
            int i = (int) d;
            int iRoundToInt = MathKt.roundToInt((d - i) * 60);
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.US, "%02d:%02d", Arrays.copyOf(new Object[]{Integer.valueOf(i), Integer.valueOf(iRoundToInt)}, 2));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            return str;
        } catch (Exception e) {
            Timber.INSTANCE.e(e);
            return SdkConstants.RES_QUALIFIER_SEP;
        }
    }

    public final void setBlueToothConnectStatus() {
        View root;
        FragmentClubRaceBinding binding = getBinding();
        if (binding == null || (root = binding.getRoot()) == null) {
            return;
        }
        root.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.club.ClubRaceFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                ClubRaceFragment.setBlueToothConnectStatus$lambda$6(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setBlueToothConnectStatus$lambda$6(ClubRaceFragment this$0) {
        ImageView imageView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        boolean zIsConnectedHr = BleManager.getInstance().isConnectedHr();
        boolean zIsConnectedFtms = BleManager.getInstance().isConnectedFtms();
        if (zIsConnectedHr) {
            FragmentClubRaceBinding binding = this$0.getBinding();
            ImageView imageView2 = binding != null ? binding.imgWatch : null;
            if (imageView2 != null) {
                imageView2.setVisibility(0);
            }
        } else {
            FragmentClubRaceBinding binding2 = this$0.getBinding();
            ImageView imageView3 = binding2 != null ? binding2.imgWatch : null;
            if (imageView3 != null) {
                imageView3.setVisibility(4);
            }
        }
        if (zIsConnectedFtms) {
            FragmentClubRaceBinding binding3 = this$0.getBinding();
            imageView = binding3 != null ? binding3.imgMachine : null;
            if (imageView == null) {
                return;
            }
            imageView.setVisibility(0);
            return;
        }
        FragmentClubRaceBinding binding4 = this$0.getBinding();
        imageView = binding4 != null ? binding4.imgMachine : null;
        if (imageView == null) {
            return;
        }
        imageView.setVisibility(4);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showIdle(TrainingStatusType trainingStatusType) {
        FragmentClubRaceBinding binding;
        LinearLayout linearLayout;
        if (trainingStatusType != null && trainingStatusType == TrainingStatusType.IDLE) {
            FitnessMachineStatusType nowFMSTypeOnlyFourType = BleDataManager.getInstance().getNowFMSTypeOnlyFourType();
            if ((nowFMSTypeOnlyFourType != FitnessMachineStatusType.FITNESS_MACHINE_STOPPED_BY_THE_USER && nowFMSTypeOnlyFourType != FitnessMachineStatusType.FITNESS_MACHINE_STOPPED_BY_SAFETY_KEY && nowFMSTypeOnlyFourType != FitnessMachineStatusType.FITNESS_MACHINE_PAUSED_BY_THE_USER) || (binding = getBinding()) == null || (linearLayout = binding.LLLeave) == null) {
                return;
            }
            linearLayout.performClick();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void isPaused(FitnessMachineStatusType fitnessMachineStatusType) {
        AnimatedPathImageView animatedPathImageView;
        AnimatedPathImageView animatedPathImageView2;
        if (fitnessMachineStatusType == null) {
            return;
        }
        if (fitnessMachineStatusType == FitnessMachineStatusType.FITNESS_MACHINE_PAUSED_BY_THE_USER || fitnessMachineStatusType == FitnessMachineStatusType.FITNESS_MACHINE_STOPPED_BY_THE_USER) {
            FragmentClubRaceBinding binding = getBinding();
            if (binding == null || (animatedPathImageView = binding.animatedPathImageView) == null) {
                return;
            }
            animatedPathImageView.pauseAnimation();
            return;
        }
        FragmentClubRaceBinding binding2 = getBinding();
        if (binding2 == null || (animatedPathImageView2 = binding2.animatedPathImageView) == null) {
            return;
        }
        animatedPathImageView2.resumeAnimation();
    }

    /* compiled from: ClubRaceFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.club.ClubRaceFragment$startRace4VirtualRace$1", f = "ClubRaceFragment.kt", i = {}, l = {WinError.ERROR_INVALID_MESSAGEDEST}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubRaceFragment$startRace4VirtualRace$1, reason: invalid class name and case insensitive filesystem */
    static final class C09531 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        /* compiled from: ClubRaceFragment.kt */
        @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
        /* renamed from: com.soletreadmills.sole_v2.ui.club.ClubRaceFragment$startRace4VirtualRace$1$WhenMappings */
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
                    iArr[BleFtmsMachineType.STEPPER.ordinal()] = 4;
                } catch (NoSuchFieldError unused4) {
                }
                try {
                    iArr[BleFtmsMachineType.ROWER.ordinal()] = 5;
                } catch (NoSuchFieldError unused5) {
                }
                $EnumSwitchMapping$0 = iArr;
            }
        }

        C09531(Continuation<? super C09531> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return ClubRaceFragment.this.new C09531(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C09531) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Unit unit;
            int i;
            String challengeUuid;
            StartRace4VirtualRaceApiData.ResponseData responseData;
            List<StartRace4VirtualRaceApiData.OthersWorkout> othersWorkoutVoList;
            StartRace4VirtualRaceApiData.WorkoutData data;
            StartRace4VirtualRaceApiData.WorkoutData data2;
            String ticket;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i2 = this.label;
            String str = "";
            try {
                try {
                    if (i2 == 0) {
                        ResultKt.throwOnFailure(obj);
                        int i3 = WhenMappings.$EnumSwitchMapping$0[ClubRaceFragment.this.getBleFtmsMachineType().ordinal()];
                        if (i3 == 1) {
                            i = 0;
                        } else if (i3 == 2) {
                            i = 1;
                        } else if (i3 == 3) {
                            i = 2;
                        } else if (i3 == 4) {
                            i = 3;
                        } else {
                            if (i3 != 5) {
                                throw new NoWhenBranchMatchedException();
                            }
                            i = 4;
                        }
                        ChallengeItemSimpleDataWithMemberData challengeItemSimpleDataWithMemberData = ClubRaceFragment.this.getViewModel().getChallengeItemSimpleDataWithMemberData();
                        if (challengeItemSimpleDataWithMemberData == null || (challengeUuid = challengeItemSimpleDataWithMemberData.getChallengeUuid()) == null) {
                            challengeUuid = "";
                        }
                        StartRace4VirtualRaceApiData.RequestBodyData requestBodyData = new StartRace4VirtualRaceApiData.RequestBodyData(challengeUuid, i);
                        ClubRaceFragment.this.showLoading();
                        ClubRaceFragment.this.setCallApi(true);
                        this.label = 1;
                        obj = DyacoApiKt.callStartRace4VirtualRace(requestBodyData, this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i2 != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    responseData = (StartRace4VirtualRaceApiData.ResponseData) ((Response) obj).body();
                    othersWorkoutVoList = null;
                    othersWorkoutVoList = null;
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(ClubRaceFragment.this, "startRace4VirtualRace", message, false, 4, null);
                    unit = Unit.INSTANCE;
                }
                if (responseData != null && responseData.getSuccess()) {
                    ClubRaceFragment.this.setCallApi(false);
                    Timber.INSTANCE.e("startRace4VirtualRace success", new Object[0]);
                    Global global = Global.INSTANCE;
                    Global.clubRaceTicket = "";
                    BleDataManager.getInstance().uploadSummaryData();
                    ClubRaceFragment clubRaceFragment = ClubRaceFragment.this;
                    StartRace4VirtualRaceApiData.DataMap dataMap = responseData.getDataMap();
                    if (dataMap != null && (data2 = dataMap.getData()) != null && (ticket = data2.getTicket()) != null) {
                        str = ticket;
                    }
                    clubRaceFragment.setTicket(str);
                    FragmentClubRaceBinding fragmentClubRaceBindingAccess$getBinding = ClubRaceFragment.access$getBinding(ClubRaceFragment.this);
                    AnimatedPathImageView animatedPathImageView = fragmentClubRaceBindingAccess$getBinding != null ? fragmentClubRaceBindingAccess$getBinding.animatedPathImageView : null;
                    if (animatedPathImageView != null) {
                        StartRace4VirtualRaceApiData.DataMap dataMap2 = responseData.getDataMap();
                        if (dataMap2 != null && (data = dataMap2.getData()) != null) {
                            othersWorkoutVoList = data.getOthersWorkoutVoList();
                        }
                        animatedPathImageView.setOtherUsersDataList(othersWorkoutVoList);
                    }
                    TrainingStatusType nowTrainingStatusType = BleDataManager.getInstance().getNowTrainingStatusType();
                    FitnessMachineStatusType nowFMSTypeOnlyFourType = BleDataManager.getInstance().getNowFMSTypeOnlyFourType();
                    if (nowTrainingStatusType == TrainingStatusType.IDLE) {
                        BleManager.getInstance().sendCmdFtms(FitnessMachineControlPointCmd.startOrResume());
                    } else if (nowFMSTypeOnlyFourType != FitnessMachineStatusType.FITNESS_MACHINE_STOPPED_BY_THE_USER && nowFMSTypeOnlyFourType != FitnessMachineStatusType.FITNESS_MACHINE_STOPPED_BY_SAFETY_KEY && nowFMSTypeOnlyFourType != FitnessMachineStatusType.FITNESS_MACHINE_PAUSED_BY_THE_USER) {
                        ClubRaceFragment.this.startRace();
                    }
                } else {
                    ClubRaceFragment.this.setCallApi(false);
                    String errorCode = responseData != null ? responseData.getErrorCode() : null;
                    if (ClubRaceFragment.this.shouldIgnoreError(errorCode)) {
                        unit = Unit.INSTANCE;
                        return unit;
                    }
                    Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required)), TuplesKt.to(ErrorCode.CHALLENGE_NOT_EXIST_4000.getId(), Boxing.boxInt(R.string.challenge_not_exist)), TuplesKt.to(ErrorCode.CHALLENGE_INVALID_OPERATION_4016.getId(), Boxing.boxInt(R.string.challenge_invalid_operation)), TuplesKt.to(ErrorCode.CHALLENGE_TYPE_MISMATCH_4019.getId(), Boxing.boxInt(R.string.challenge_type_mismatch)), TuplesKt.to(ErrorCode.CHALLENGE_NOT_START_YET_4017.getId(), Boxing.boxInt(R.string.challenge_not_start_yet)), TuplesKt.to(ErrorCode.CHALLENGE_OVER_DUE_4018.getId(), Boxing.boxInt(R.string.challenge_over_due)), TuplesKt.to(ErrorCode.NO_AUTH_TO_ACCESS_100.getId(), Boxing.boxInt(R.string.no_auth_to_access)), TuplesKt.to(ErrorCode.INVALID_OPERATION_ON_TARGET_OBJ_STATUS_1045.getId(), Boxing.boxInt(R.string.invalid_operation_on_target_obj_status))).get(errorCode);
                    if (num != null) {
                        ClubRaceFragment clubRaceFragment2 = ClubRaceFragment.this;
                        CustomDialogKt.showCustomDialog$default(clubRaceFragment2, clubRaceFragment2.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                    } else {
                        BaseFragment.handleUndefinedError$default(ClubRaceFragment.this, "startRace4VirtualRace", errorCode, responseData != null ? responseData.getErrorMessage() : null, false, 8, null);
                    }
                }
                ClubRaceFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                ClubRaceFragment.this.stopLoading();
            }
        }
    }

    public final void startRace4VirtualRace() {
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C09531(null), 3, null);
    }
}
