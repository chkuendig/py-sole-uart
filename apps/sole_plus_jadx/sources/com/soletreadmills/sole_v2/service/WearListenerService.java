package com.soletreadmills.sole_v2.service;

import android.os.Binder;
import androidx.health.connect.client.permission.HealthPermission;
import androidx.health.connect.client.records.HeartRateRecord;
import androidx.health.connect.client.records.StepsRecord;
import com.digifly.ble.data.wear.WearHrData;
import com.google.android.gms.wearable.MessageEvent;
import com.google.android.gms.wearable.WearableListenerService;
import com.google.gson.Gson;
import com.soletreadmills.sole_v2.AppConfig;
import com.soletreadmills.sole_v2._extension.ContextExtensionKt;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2._manager.WearServiceManager;
import com.soletreadmills.sole_v2._tools.WearDataTool;
import com.soletreadmills.sole_v2._type.MsgData;
import com.soletreadmills.sole_v2._type.WearMsgDataType;
import com.soletreadmills.sole_v2._type.WearStatusType;
import com.soletreadmills.sole_v2.ble.cmd.FitnessMachineControlPointCmd;
import com.soletreadmills.sole_v2.ble.manager.BleDataManager;
import com.soletreadmills.sole_v2.listener.WearHRListener;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import timber.log.Timber;

/* compiled from: WearListenerService.kt */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016J\b\u0010\u0014\u001a\u00020\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\u0013H\u0002J\b\u0010\u0019\u001a\u00020\u0013H\u0002R\u0012\u0010\u0003\u001a\u00060\u0004R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/soletreadmills/sole_v2/service/WearListenerService;", "Lcom/google/android/gms/wearable/WearableListenerService;", "()V", "binder", "Lcom/soletreadmills/sole_v2/service/WearListenerService$LocalBinder;", "permissions", "", "", "getPermissions", "()Ljava/util/Set;", "sendHrToMachinejob", "Lkotlinx/coroutines/Job;", "serviceScope", "Lkotlinx/coroutines/CoroutineScope;", "byteArrayToData", "Lcom/soletreadmills/sole_v2/_type/MsgData;", "bytes", "", "onCreate", "", "onDestroy", "onMessageReceived", "messageEvent", "Lcom/google/android/gms/wearable/MessageEvent;", "startTask", "stopTask", "LocalBinder", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class WearListenerService extends WearableListenerService {
    public static final int $stable = 8;
    private Job sendHrToMachinejob;
    private final LocalBinder binder = new LocalBinder();
    private final CoroutineScope serviceScope = CoroutineScopeKt.CoroutineScope(Dispatchers.getDefault());
    private final Set<String> permissions = SetsKt.setOf((Object[]) new String[]{HealthPermission.INSTANCE.getWritePermission(Reflection.getOrCreateKotlinClass(StepsRecord.class)), HealthPermission.INSTANCE.getWritePermission(Reflection.getOrCreateKotlinClass(HeartRateRecord.class))});

    /* compiled from: WearListenerService.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[WearMsgDataType.values().length];
            try {
                iArr[WearMsgDataType.HR.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[WearMsgDataType.CMD.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[WearMsgDataType.ASK_CONNECT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public final Set<String> getPermissions() {
        return this.permissions;
    }

    private final void startTask() {
        Job job = this.sendHrToMachinejob;
        if (job == null || !job.isActive()) {
            this.sendHrToMachinejob = BuildersKt__Builders_commonKt.launch$default(this.serviceScope, null, null, new AnonymousClass1(null), 3, null);
        } else {
            Timber.INSTANCE.tag("HRRR").d("Task is already running.", new Object[0]);
        }
    }

    /* compiled from: WearListenerService.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.service.WearListenerService$startTask$1", f = "WearListenerService.kt", i = {0}, l = {73}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"})
    /* renamed from: com.soletreadmills.sole_v2.service.WearListenerService$startTask$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                coroutineScope = (CoroutineScope) this.L$0;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                coroutineScope = (CoroutineScope) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            while (CoroutineScopeKt.isActive(coroutineScope)) {
                WearHrData wearHrData = BleDataManager.nowWearHrData;
                if (wearHrData != null && wearHrData.checkTimeInRangeAndGetValue() >= 0) {
                    Timber.INSTANCE.tag("HRRR").d("set hr to machine:" + BleDataManager.nowWearHrData, new Object[0]);
                    WearHrData wearHrData2 = BleDataManager.nowWearHrData;
                    Integer hrValue = wearHrData2 != null ? wearHrData2.getHrValue() : null;
                    if (hrValue != null) {
                        BleManager.getInstance().sendCmdFtms(FitnessMachineControlPointCmd.setTargetHeartRate(hrValue));
                    }
                }
                this.L$0 = coroutineScope;
                this.label = 1;
                if (DelayKt.delay(1500L, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
            return Unit.INSTANCE;
        }
    }

    private final void stopTask() {
        Job job = this.sendHrToMachinejob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
    }

    @Override // com.google.android.gms.wearable.WearableListenerService, android.app.Service
    public void onCreate() {
        super.onCreate();
        Timber.INSTANCE.tag("HRRR").d("WearListenerService onCreate", new Object[0]);
    }

    @Override // com.google.android.gms.wearable.WearableListenerService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        stopTask();
    }

    @Override // com.google.android.gms.wearable.WearableListenerService, com.google.android.gms.wearable.MessageApi.MessageListener
    public void onMessageReceived(MessageEvent messageEvent) throws NumberFormatException {
        Intrinsics.checkNotNullParameter(messageEvent, "messageEvent");
        Timber.INSTANCE.tag("HRRR").d("onMessageReceived", new Object[0]);
        if (Intrinsics.areEqual(messageEvent.getPath(), AppConfig.MESSAGE_PATH)) {
            try {
                byte[] data = messageEvent.getData();
                Intrinsics.checkNotNullExpressionValue(data, "getData(...)");
                MsgData msgDataByteArrayToData = byteArrayToData(data);
                Timber.INSTANCE.tag("HRRR").d("message:" + msgDataByteArrayToData, new Object[0]);
                if (msgDataByteArrayToData == null) {
                    return;
                }
                int i = WhenMappings.$EnumSwitchMapping$0[msgDataByteArrayToData.getType().ordinal()];
                if (i == 1) {
                    int i2 = Integer.parseInt(msgDataByteArrayToData.getValue());
                    BleDataManager.getInstance().setWearData(i2);
                    Timber.INSTANCE.tag("HRRR").d("receive hrValue " + i2, new Object[0]);
                    WearServiceManager wearServiceManager = ContextExtensionKt.getMyApplication(this).getWearServiceManager();
                    List<WearHRListener> listenerArray = wearServiceManager != null ? wearServiceManager.getListenerArray() : null;
                    if (listenerArray != null) {
                        Iterator<WearHRListener> it = listenerArray.iterator();
                        while (it.hasNext()) {
                            it.next().wearDataReceive(i2);
                        }
                    }
                    if (this.sendHrToMachinejob == null) {
                        startTask();
                        return;
                    }
                    return;
                }
                if (i != 2) {
                    if (i != 3) {
                        return;
                    }
                    boolean zIsConnectedFtms = BleManager.getInstance().isConnectedFtms();
                    Timber.INSTANCE.tag("HRRR").d("isBleLinked:" + zIsConnectedFtms, new Object[0]);
                    if (zIsConnectedFtms) {
                        WearDataTool.INSTANCE.callWearCommand(WearStatusType.DEVICE_LINKED.getId(), ContextExtensionKt.getMyApplication(this));
                        return;
                    }
                    return;
                }
                if (Intrinsics.areEqual(msgDataByteArrayToData.getValue(), WearStatusType.WEAR_IS_START.getId())) {
                    Timber.INSTANCE.tag("HRRR").d("receive CMD WEAR_IS_START", new Object[0]);
                    BleManager.getInstance().sendCmdFtms(FitnessMachineControlPointCmd.startOrResume());
                }
                if (Intrinsics.areEqual(msgDataByteArrayToData.getValue(), WearStatusType.WEAR_IS_STOP.getId())) {
                    Timber.INSTANCE.tag("HRRR").d("receive CMD WEAR_IS_STOP", new Object[0]);
                    BleManager.getInstance().sendCmdFtms(FitnessMachineControlPointCmd.pause());
                }
            } catch (Exception e) {
                Timber.INSTANCE.e(e);
            }
        }
    }

    private final MsgData byteArrayToData(byte[] bytes) {
        try {
            return (MsgData) new Gson().fromJson(new String(bytes, Charsets.UTF_8), MsgData.class);
        } catch (Exception unused) {
            return null;
        }
    }

    /* compiled from: WearListenerService.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0004\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u00048F¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/service/WearListenerService$LocalBinder;", "Landroid/os/Binder;", "(Lcom/soletreadmills/sole_v2/service/WearListenerService;)V", "service", "Lcom/soletreadmills/sole_v2/service/WearListenerService;", "getService", "()Lcom/soletreadmills/sole_v2/service/WearListenerService;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public final class LocalBinder extends Binder {
        public LocalBinder() {
        }

        /* renamed from: getService, reason: from getter */
        public final WearListenerService getThis$0() {
            return WearListenerService.this;
        }
    }
}
