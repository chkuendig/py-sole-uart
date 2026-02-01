package com.soletreadmills.sole_v2._manager;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.android.SdkConstants;
import com.samsung.android.sdk.healthdata.HealthConnectionErrorResult;
import com.samsung.android.sdk.healthdata.HealthConstants;
import com.samsung.android.sdk.healthdata.HealthData;
import com.samsung.android.sdk.healthdata.HealthDataResolver;
import com.samsung.android.sdk.healthdata.HealthDataStore;
import com.samsung.android.sdk.healthdata.HealthDevice;
import com.samsung.android.sdk.healthdata.HealthDeviceManager;
import com.samsung.android.sdk.healthdata.HealthPermissionManager;
import com.samsung.android.sdk.healthdata.HealthResultHolder;
import com.soletreadmills.sole_v2._manager.SamsungHealthManager;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import com.soletreadmills.sole_v2._type.CategoryType;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import timber.log.Timber;

/* compiled from: SamsungHealthManager.kt */
@Metadata(d1 = {"\u0000t\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010#\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001/B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\u0014\u001a\u00020\u0013J\u0006\u0010\u0015\u001a\u00020\u0013J \u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0010\b\u0002\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u0017\u0018\u00010\u001bJ\b\u0010\u001c\u001a\u0004\u0018\u00010\u0006J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u001eH\u0002J,\u0010 \u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00032\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020$0#2\f\u0010%\u001a\b\u0012\u0004\u0012\u00020\u00060#H\u0002J\u000e\u0010&\u001a\u00020\u00132\u0006\u0010!\u001a\u00020\u0003J\u000e\u0010'\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u0003J\u000e\u0010(\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019J\u0018\u0010)\u001a\u00020\u00172\u0006\u0010*\u001a\u00020+2\u0006\u0010\u0018\u001a\u00020\u0019H\u0002J\u001c\u0010,\u001a\u00020\u00172\u0006\u0010!\u001a\u00020\u00032\f\u0010-\u001a\b\u0012\u0004\u0012\u00020.0#R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\b\u0010\r\u001a\u0004\u0018\u00010\u000e@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/soletreadmills/sole_v2/_manager/SamsungHealthManager;", "", "appContext", "Landroid/content/Context;", "(Landroid/content/Context;)V", "APP_TAG", "", "mKeys", "", "Lcom/samsung/android/sdk/healthdata/HealthPermissionManager$PermissionKey;", "mPermissionListener", "Lcom/samsung/android/sdk/healthdata/HealthResultHolder$ResultListener;", "Lcom/samsung/android/sdk/healthdata/HealthPermissionManager$PermissionResult;", "<set-?>", "Lcom/samsung/android/sdk/healthdata/HealthDataStore;", "mStore", "getMStore", "()Lcom/samsung/android/sdk/healthdata/HealthDataStore;", "mStoreIsConnect", "", "checkSamsungHealthConnect", "checkSamsungHealthPermissions", "connectHealthData", "", "activity", "Landroid/app/Activity;", "onConnected", "Lkotlin/Function0;", "getDeviceUuid", "getTimeOffset", "", "currentTime", "insertExerciseRecords", SdkConstants.ATTR_CONTEXT, "records", "", "Lcom/samsung/android/sdk/healthdata/HealthData;", "trainNoList", "isSamsungHealthInstalled", "openSamsungHealthOrInstall", "requestSamsungHealthPermission", "showConnectionFailureDialog", "error", "Lcom/samsung/android/sdk/healthdata/HealthConnectionErrorResult;", "writeData", "historyData", "Lcom/soletreadmills/sole_v2/_data/api/history/HistoryListData;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SamsungHealthManager {
    private static volatile SamsungHealthManager instance;
    private final String APP_TAG;
    private final Context appContext;
    private final Set<HealthPermissionManager.PermissionKey> mKeys;
    private final HealthResultHolder.ResultListener<HealthPermissionManager.PermissionResult> mPermissionListener;
    private HealthDataStore mStore;
    private boolean mStoreIsConnect;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: SamsungHealthManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[CategoryType.values().length];
            try {
                iArr[CategoryType.TREADMILL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[CategoryType.BIKE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[CategoryType.ELLIPTICAL.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[CategoryType.STEPPER.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[CategoryType.ROWER.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    public /* synthetic */ SamsungHealthManager(Context context, DefaultConstructorMarker defaultConstructorMarker) {
        this(context);
    }

    @JvmStatic
    public static final SamsungHealthManager getInstance(Context context) {
        return INSTANCE.getInstance(context);
    }

    private SamsungHealthManager(Context context) {
        this.appContext = context;
        this.APP_TAG = "SamsungHealth";
        this.mKeys = CollectionsKt.toMutableSet(SetsKt.setOf(new HealthPermissionManager.PermissionKey(HealthConstants.Exercise.HEALTH_DATA_TYPE, HealthPermissionManager.PermissionType.WRITE)));
        this.mPermissionListener = new HealthResultHolder.ResultListener() { // from class: com.soletreadmills.sole_v2._manager.SamsungHealthManager$$ExternalSyntheticLambda0
            @Override // com.samsung.android.sdk.healthdata.HealthResultHolder.ResultListener
            public final void onResult(HealthResultHolder.BaseResult baseResult) {
                SamsungHealthManager.mPermissionListener$lambda$0(this.f$0, (HealthPermissionManager.PermissionResult) baseResult);
            }
        };
    }

    /* compiled from: SamsungHealthManager.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007H\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/_manager/SamsungHealthManager$Companion;", "", "()V", "instance", "Lcom/soletreadmills/sole_v2/_manager/SamsungHealthManager;", "getInstance", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final SamsungHealthManager getInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            SamsungHealthManager samsungHealthManager = SamsungHealthManager.instance;
            if (samsungHealthManager == null) {
                synchronized (this) {
                    samsungHealthManager = SamsungHealthManager.instance;
                    if (samsungHealthManager == null) {
                        Context applicationContext = context.getApplicationContext();
                        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
                        samsungHealthManager = new SamsungHealthManager(applicationContext, null);
                        Companion companion = SamsungHealthManager.INSTANCE;
                        SamsungHealthManager.instance = samsungHealthManager;
                    }
                }
            }
            return samsungHealthManager;
        }
    }

    public final HealthDataStore getMStore() {
        return this.mStore;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void mPermissionListener$lambda$0(SamsungHealthManager this$0, HealthPermissionManager.PermissionResult permissionResult) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Timber.INSTANCE.tag(this$0.APP_TAG).d("Permission callback is received.", new Object[0]);
        Map<HealthPermissionManager.PermissionKey, Boolean> resultMap = permissionResult.getResultMap();
        Timber.INSTANCE.tag(this$0.APP_TAG).d("Permission result" + resultMap, new Object[0]);
        if (resultMap.containsValue(false)) {
            Timber.INSTANCE.i("Requesting permission fails", new Object[0]);
        } else {
            Timber.INSTANCE.i("Requesting OK, Get the current step count and display it: " + permissionResult, new Object[0]);
        }
    }

    public final void requestSamsungHealthPermission(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        try {
            new HealthPermissionManager(this.mStore).requestPermissions(this.mKeys, activity).setResultListener(this.mPermissionListener);
        } catch (Exception unused) {
            Timber.INSTANCE.tag("samsung health:").d("requestPermissions() fails", new Object[0]);
            Timber.INSTANCE.tag(this.APP_TAG).e("要求權限失敗，可能沒有先開啟 store", new Object[0]);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ void connectHealthData$default(SamsungHealthManager samsungHealthManager, Activity activity, Function0 function0, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = null;
        }
        samsungHealthManager.connectHealthData(activity, function0);
    }

    public final void connectHealthData(final Activity activity, final Function0<Unit> onConnected) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Timber.INSTANCE.d("Connecting to Samsung Health...", new Object[0]);
        HealthDataStore healthDataStore = new HealthDataStore(this.appContext, new HealthDataStore.ConnectionListener() { // from class: com.soletreadmills.sole_v2._manager.SamsungHealthManager.connectHealthData.1
            @Override // com.samsung.android.sdk.healthdata.HealthDataStore.ConnectionListener
            public void onConnected() {
                Timber.INSTANCE.tag(SamsungHealthManager.this.APP_TAG).d("HealthDataStore connected.", new Object[0]);
                SamsungHealthManager.this.mStoreIsConnect = true;
                Function0<Unit> function0 = onConnected;
                if (function0 != null) {
                    function0.invoke();
                }
            }

            @Override // com.samsung.android.sdk.healthdata.HealthDataStore.ConnectionListener
            public void onConnectionFailed(HealthConnectionErrorResult error) {
                Intrinsics.checkNotNullParameter(error, "error");
                Timber.INSTANCE.tag(SamsungHealthManager.this.APP_TAG).e("Connection failed: " + error.getErrorCode(), new Object[0]);
                SamsungHealthManager.this.mStoreIsConnect = false;
                SamsungHealthManager.this.showConnectionFailureDialog(error, activity);
            }

            @Override // com.samsung.android.sdk.healthdata.HealthDataStore.ConnectionListener
            public void onDisconnected() {
                Timber.INSTANCE.tag(SamsungHealthManager.this.APP_TAG).e("HealthDataStore disconnected.", new Object[0]);
                SamsungHealthManager.this.mStoreIsConnect = false;
            }
        });
        this.mStore = healthDataStore;
        try {
            healthDataStore.connectService();
        } catch (Exception e) {
            Timber.INSTANCE.tag(this.APP_TAG).i("Failed to connect to HealthDataStore: " + e.getMessage(), new Object[0]);
        }
    }

    public final boolean checkSamsungHealthPermissions() {
        if (this.mStore == null) {
            Timber.INSTANCE.tag(this.APP_TAG).i("HealthDataStore is not initialized.", new Object[0]);
            return false;
        }
        try {
            return !new HealthPermissionManager(this.mStore).isPermissionAcquired(this.mKeys).containsValue(false);
        } catch (Exception e) {
            Timber.INSTANCE.tag(this.APP_TAG).i("Permission check failed: " + e.getMessage(), new Object[0]);
            return false;
        }
    }

    public final boolean checkSamsungHealthConnect() {
        if (this.mStoreIsConnect) {
            Timber.INSTANCE.d("Samsung Health 已連線", new Object[0]);
            return true;
        }
        Timber.INSTANCE.d("Samsung Health 尚未連線", new Object[0]);
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void showConnectionFailureDialog(final HealthConnectionErrorResult error, final Activity activity) {
        String str;
        AlertDialog.Builder builder = new AlertDialog.Builder(activity);
        if (!error.hasResolution()) {
            str = "Connection with Samsung Health is not available";
        } else {
            int errorCode = error.getErrorCode();
            if (errorCode == 2) {
                str = "Please install Samsung Health";
            } else if (errorCode == 4) {
                str = "Please upgrade Samsung Health";
            } else if (errorCode == 6) {
                str = "Please enable Samsung Health";
            } else if (errorCode == 9) {
                str = "Please agree with Samsung Health policy";
            } else {
                str = "Please make Samsung Health available";
            }
        }
        builder.setMessage(str);
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() { // from class: com.soletreadmills.sole_v2._manager.SamsungHealthManager$$ExternalSyntheticLambda1
            @Override // android.content.DialogInterface.OnClickListener
            public final void onClick(DialogInterface dialogInterface, int i) {
                SamsungHealthManager.showConnectionFailureDialog$lambda$1(error, activity, dialogInterface, i);
            }
        });
        if (error.hasResolution()) {
            builder.setNegativeButton("Cancel", (DialogInterface.OnClickListener) null);
        }
        builder.show();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showConnectionFailureDialog$lambda$1(HealthConnectionErrorResult mConnError, Activity activity, DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(mConnError, "$mConnError");
        Intrinsics.checkNotNullParameter(activity, "$activity");
        if (mConnError.hasResolution()) {
            mConnError.resolve(activity);
        }
    }

    public final boolean isSamsungHealthInstalled(Context context) throws PackageManager.NameNotFoundException {
        Intrinsics.checkNotNullParameter(context, "context");
        try {
            context.getApplicationContext().getPackageManager().getPackageInfo("com.sec.android.app.shealth", 1);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }

    public final void openSamsungHealthOrInstall(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (isSamsungHealthInstalled(context)) {
            Intent launchIntentForPackage = context.getPackageManager().getLaunchIntentForPackage("com.sec.android.app.shealth");
            if (launchIntentForPackage != null) {
                context.startActivity(launchIntentForPackage);
                return;
            }
            return;
        }
        Toast.makeText(context, "Samsung Health is Unavailable, please install or update", 1).show();
        context.startActivity(new Intent("android.intent.action.VIEW", Uri.parse("market://details?id=com.sec.android.app.shealth")));
    }

    public final String getDeviceUuid() {
        HealthDevice localDevice;
        try {
            HealthDataStore healthDataStore = this.mStore;
            if (healthDataStore == null || (localDevice = new HealthDeviceManager(healthDataStore).getLocalDevice()) == null) {
                return null;
            }
            return localDevice.getUuid();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    private final long getTimeOffset(long currentTime) {
        return TimeZone.getDefault().getOffset(currentTime);
    }

    private final void insertExerciseRecords(Context context, List<HealthData> records, List<String> trainNoList) {
        if (this.mStore != null && this.mStoreIsConnect) {
            BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C08391(records, this, trainNoList, null), 3, null);
        } else {
            Timber.INSTANCE.tag("SamsungHealth").i("HealthDataStore is not connected.", new Object[0]);
        }
    }

    /* compiled from: SamsungHealthManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2._manager.SamsungHealthManager$insertExerciseRecords$1", f = "SamsungHealthManager.kt", i = {}, l = {305}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2._manager.SamsungHealthManager$insertExerciseRecords$1, reason: invalid class name and case insensitive filesystem */
    static final class C08391 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ List<HealthData> $records;
        final /* synthetic */ List<String> $trainNoList;
        int label;
        final /* synthetic */ SamsungHealthManager this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C08391(List<HealthData> list, SamsungHealthManager samsungHealthManager, List<String> list2, Continuation<? super C08391> continuation) {
            super(2, continuation);
            this.$records = list;
            this.this$0 = samsungHealthManager;
            this.$trainNoList = list2;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new C08391(this.$records, this.this$0, this.$trainNoList, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08391) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Timber.INSTANCE.tag("SamsungHealth").i("HealthDataStore is insertExerciseRecords =======", new Object[0]);
                    HealthDataResolver.InsertRequest insertRequestBuild = new HealthDataResolver.InsertRequest.Builder().setDataType(HealthConstants.Exercise.HEALTH_DATA_TYPE).build();
                    Iterator<HealthData> it = this.$records.iterator();
                    while (it.hasNext()) {
                        insertRequestBuild.addHealthData(it.next());
                    }
                    HealthDataResolver healthDataResolver = new HealthDataResolver(this.this$0.getMStore(), null);
                    this.label = 1;
                    if (BuildersKt.withContext(Dispatchers.getMain(), new C02071(healthDataResolver, insertRequestBuild, this.$trainNoList, null), this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Exception e) {
                Timber.INSTANCE.tag("SamsungHealth").e("插入運動紀錄時發生錯誤: %s", e.getMessage());
            }
            return Unit.INSTANCE;
        }

        /* compiled from: SamsungHealthManager.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2._manager.SamsungHealthManager$insertExerciseRecords$1$1", f = "SamsungHealthManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2._manager.SamsungHealthManager$insertExerciseRecords$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ HealthDataResolver.InsertRequest $request;
            final /* synthetic */ HealthDataResolver $resolver;
            final /* synthetic */ List<String> $trainNoList;
            int label;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02071(HealthDataResolver healthDataResolver, HealthDataResolver.InsertRequest insertRequest, List<String> list, Continuation<? super C02071> continuation) {
                super(2, continuation);
                this.$resolver = healthDataResolver;
                this.$request = insertRequest;
                this.$trainNoList = list;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02071(this.$resolver, this.$request, this.$trainNoList, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02071) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) throws IOException {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                HealthResultHolder<HealthResultHolder.BaseResult> healthResultHolderInsert = this.$resolver.insert(this.$request);
                final List<String> list = this.$trainNoList;
                healthResultHolderInsert.setResultListener(new HealthResultHolder.ResultListener() { // from class: com.soletreadmills.sole_v2._manager.SamsungHealthManager$insertExerciseRecords$1$1$$ExternalSyntheticLambda0
                    @Override // com.samsung.android.sdk.healthdata.HealthResultHolder.ResultListener
                    public final void onResult(HealthResultHolder.BaseResult baseResult) {
                        SamsungHealthManager.C08391.C02071.invokeSuspend$lambda$1(list, baseResult);
                    }
                });
                return Unit.INSTANCE;
            }

            /* JADX INFO: Access modifiers changed from: private */
            public static final void invokeSuspend$lambda$1(List list, HealthResultHolder.BaseResult baseResult) {
                if (baseResult.getStatus() == 1) {
                    Timber.INSTANCE.tag("SamsungHealth").i("插入SamsungHealth運動成功 " + list.size() + " 筆", new Object[0]);
                    Iterator it = list.iterator();
                    while (it.hasNext()) {
                        MySharedPreferences.INSTANCE.getInstance().saveHistoryUpdateToSamsungHealth((String) it.next(), true);
                    }
                    return;
                }
                Timber.INSTANCE.tag("SamsungHealth").e("插入SamsungHealth運動紀錄失敗，count: " + baseResult.getCount(), new Object[0]);
                Timber.INSTANCE.tag("SamsungHealth").e("插入SamsungHealth運動紀錄失敗，status: " + baseResult.getStatus(), new Object[0]);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:148:0x02e4  */
    /* JADX WARN: Removed duplicated region for block: B:149:0x02ec  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void writeData(android.content.Context r21, java.util.List<com.soletreadmills.sole_v2._data.api.history.HistoryListData> r22) {
        /*
            Method dump skipped, instructions count: 766
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2._manager.SamsungHealthManager.writeData(android.content.Context, java.util.List):void");
    }
}
