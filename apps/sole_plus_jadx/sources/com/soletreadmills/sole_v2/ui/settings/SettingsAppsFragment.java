package com.soletreadmills.sole_v2.ui.settings;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.URLUtil;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.fragment.app.FragmentActivity;
import androidx.health.connect.client.HealthConnectClient;
import androidx.health.connect.client.permission.HealthPermission;
import androidx.health.connect.client.records.DistanceRecord;
import androidx.health.connect.client.records.ExerciseSessionRecord;
import androidx.health.connect.client.records.StepsRecord;
import androidx.health.connect.client.records.TotalCaloriesBurnedRecord;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._data.api.settings.GarminStartUserAuthApiData;
import com.soletreadmills.sole_v2._data.api.settings.GetConnectedExternalServiceApiData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._manager.HealthDataManager;
import com.soletreadmills.sole_v2._manager.SamsungHealthManager;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2.databinding.FragmentSettingsAppsBinding;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui.settings.SettingsAppsFragment;
import java.io.IOException;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.CompletableFuture;
import java.util.function.Consumer;
import java.util.function.Function;
import kotlin.Metadata;
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
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: SettingsAppsFragment.kt */
@Metadata(d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010#\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0017\u001a\u00020\u0018H\u0002J\b\u0010\u0019\u001a\u00020\u0018H\u0002J\b\u0010\u001a\u001a\u00020\u0018H\u0002J\u001a\u0010\u001b\u001a\u00020\u00022\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0016J\b\u0010 \u001a\u00020\u0018H\u0016J\u0012\u0010!\u001a\u00020\u00182\b\u0010\"\u001a\u0004\u0018\u00010#H\u0016J\u0012\u0010$\u001a\u00020\u00182\b\u0010%\u001a\u0004\u0018\u00010&H\u0016J\b\u0010'\u001a\u00020\u0018H\u0016J\b\u0010(\u001a\u00020\u0018H\u0016J\u0010\u0010)\u001a\u00020\u00182\u0006\u0010*\u001a\u00020\bH\u0002J\b\u0010+\u001a\u00020\u0018H\u0002J\b\u0010,\u001a\u00020\u0018H\u0002J\u0006\u0010-\u001a\u00020\u0018J\b\u0010.\u001a\u00020\u0018H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u000e\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u0010\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016¨\u0006/"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/settings/SettingsAppsFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentSettingsAppsBinding;", "Landroid/view/View$OnClickListener;", "()V", "healthDataManager", "Lcom/soletreadmills/sole_v2/_manager/HealthDataManager;", "isGarminConnected", "", "permissions", "", "", "requestPermissionFor14Launcher", "Landroidx/activity/result/ActivityResultLauncher;", "", "requestPermissionLauncher", "", "samsungHealthManager", "Lcom/soletreadmills/sole_v2/_manager/SamsungHealthManager;", "getSamsungHealthManager", "()Lcom/soletreadmills/sole_v2/_manager/SamsungHealthManager;", "setSamsungHealthManager", "(Lcom/soletreadmills/sole_v2/_manager/SamsungHealthManager;)V", "garminRevokeUserAuth", "", "garminStartUserAuth", "getConnectedExternalService", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "onStart", "setGarminConnectedView", "isConnected", "setHealthConnectedView", "setSamsungHealthConnectedView", "setView", "toHealthConnect", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SettingsAppsFragment extends BaseFragment<FragmentSettingsAppsBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private HealthDataManager healthDataManager;
    private boolean isGarminConnected;
    private final Set<String> permissions = new HashSet();
    private ActivityResultLauncher<String[]> requestPermissionFor14Launcher;
    private ActivityResultLauncher<Set<String>> requestPermissionLauncher;
    private SamsungHealthManager samsungHealthManager;

    public final void setView() {
    }

    public static final /* synthetic */ FragmentSettingsAppsBinding access$getBinding(SettingsAppsFragment settingsAppsFragment) {
        return settingsAppsFragment.getBinding();
    }

    public final SamsungHealthManager getSamsungHealthManager() {
        return this.samsungHealthManager;
    }

    public final void setSamsungHealthManager(SamsungHealthManager samsungHealthManager) {
        this.samsungHealthManager = samsungHealthManager;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentSettingsAppsBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentSettingsAppsBinding fragmentSettingsAppsBindingInflate = FragmentSettingsAppsBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentSettingsAppsBindingInflate, "inflate(...)");
        return fragmentSettingsAppsBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        getConnectedExternalService();
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.permissions.add(HealthPermission.INSTANCE.getWritePermission(Reflection.getOrCreateKotlinClass(StepsRecord.class)));
        this.permissions.add(HealthPermission.INSTANCE.getWritePermission(Reflection.getOrCreateKotlinClass(ExerciseSessionRecord.class)));
        this.permissions.add(HealthPermission.INSTANCE.getWritePermission(Reflection.getOrCreateKotlinClass(TotalCaloriesBurnedRecord.class)));
        this.permissions.add(HealthPermission.INSTANCE.getWritePermission(Reflection.getOrCreateKotlinClass(DistanceRecord.class)));
        this.healthDataManager = new HealthDataManager();
        SamsungHealthManager.Companion companion = SamsungHealthManager.INSTANCE;
        Context applicationContext = requireActivity().getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        this.samsungHealthManager = companion.getInstance(applicationContext);
        if (Build.VERSION.SDK_INT >= 34) {
            this.requestPermissionFor14Launcher = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.soletreadmills.sole_v2.ui.settings.SettingsAppsFragment$$ExternalSyntheticLambda5
                @Override // androidx.activity.result.ActivityResultCallback
                public final void onActivityResult(Object obj) {
                    SettingsAppsFragment.onCreate$lambda$1((Map) obj);
                }
            });
            return;
        }
        HealthDataManager healthDataManager = this.healthDataManager;
        Intrinsics.checkNotNull(healthDataManager);
        this.requestPermissionLauncher = registerForActivityResult(healthDataManager.requestPermissionsActivityContract(), new ActivityResultCallback() { // from class: com.soletreadmills.sole_v2.ui.settings.SettingsAppsFragment$$ExternalSyntheticLambda6
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                Intrinsics.checkNotNullParameter((Set) obj, "grantedPermissions");
            }
        });
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        super.onResume();
        Timber.INSTANCE.d("resume", new Object[0]);
        setHealthConnectedView();
        setSamsungHealthConnectedView();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        LinearLayout linearLayout;
        LinearLayout linearLayout2;
        LinearLayout linearLayout3;
        ImageView imageView;
        FragmentSettingsAppsBinding binding = getBinding();
        if (binding != null && (imageView = binding.back) != null) {
            imageView.setOnClickListener(this);
        }
        FragmentSettingsAppsBinding binding2 = getBinding();
        if (binding2 != null && (linearLayout3 = binding2.llHealthConnect) != null) {
            linearLayout3.setOnClickListener(this);
        }
        FragmentSettingsAppsBinding binding3 = getBinding();
        if (binding3 != null && (linearLayout2 = binding3.llSamsungHealth) != null) {
            linearLayout2.setOnClickListener(this);
        }
        FragmentSettingsAppsBinding binding4 = getBinding();
        if (binding4 != null && (linearLayout = binding4.llGarminConnect) != null) {
            linearLayout.setOnClickListener(this);
        }
        setView();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Unit unit = null;
        CompletableFuture<Boolean> completableFutureHasAllPermissionsAsync = null;
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.back;
        if (numValueOf != null && numValueOf.intValue() == i) {
            safeNavigateUp();
            return;
        }
        int i2 = R.id.ll_health_connect;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            Timber.INSTANCE.d("link health connect", new Object[0]);
            MainActivity mainActivity = getMainActivity();
            Integer numValueOf2 = mainActivity != null ? Integer.valueOf(HealthConnectClient.Companion.getSdkStatus$default(HealthConnectClient.INSTANCE, mainActivity, null, 2, null)) : null;
            if (numValueOf2 != null && numValueOf2.intValue() == 3) {
                MainActivity mainActivity2 = getMainActivity();
                if (mainActivity2 != null) {
                    HealthDataManager healthDataManager = this.healthDataManager;
                    Intrinsics.checkNotNull(healthDataManager);
                    completableFutureHasAllPermissionsAsync = healthDataManager.hasAllPermissionsAsync(mainActivity2, this.permissions);
                }
                if (completableFutureHasAllPermissionsAsync != null) {
                    final Function1<Boolean, Unit> function1 = new Function1<Boolean, Unit>() { // from class: com.soletreadmills.sole_v2.ui.settings.SettingsAppsFragment.onClick.1
                        {
                            super(1);
                        }

                        @Override // kotlin.jvm.functions.Function1
                        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                            invoke(bool.booleanValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(boolean z) {
                            if (z) {
                                System.out.println((Object) "已獲取所有所需的權限");
                                SettingsAppsFragment.this.toHealthConnect();
                                return;
                            }
                            System.out.println((Object) "缺少一些權限");
                            SettingsAppsFragment settingsAppsFragment = SettingsAppsFragment.this;
                            String string = settingsAppsFragment.getString(R.string.health_connect_allow_info);
                            String string2 = SettingsAppsFragment.this.getString(R.string.yes);
                            String string3 = SettingsAppsFragment.this.getString(R.string.cancel);
                            final SettingsAppsFragment settingsAppsFragment2 = SettingsAppsFragment.this;
                            CustomDialogKt.showCustomDialog$default(settingsAppsFragment, null, string, string2, string3, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.settings.SettingsAppsFragment.onClick.1.1
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
                                    if (Build.VERSION.SDK_INT >= 34) {
                                        System.out.println((Object) "Android 14 或更新版本");
                                        ActivityResultLauncher activityResultLauncher = settingsAppsFragment2.requestPermissionFor14Launcher;
                                        Intrinsics.checkNotNull(activityResultLauncher);
                                        activityResultLauncher.launch(settingsAppsFragment2.permissions.toArray(new String[0]));
                                        return;
                                    }
                                    System.out.println((Object) "Android 14 以下版本");
                                    ActivityResultLauncher activityResultLauncher2 = settingsAppsFragment2.requestPermissionLauncher;
                                    Intrinsics.checkNotNull(activityResultLauncher2);
                                    activityResultLauncher2.launch(settingsAppsFragment2.permissions);
                                }
                            }, null, false, 96, null);
                        }
                    };
                    CompletableFuture<Void> completableFutureThenAccept = completableFutureHasAllPermissionsAsync.thenAccept(new Consumer() { // from class: com.soletreadmills.sole_v2.ui.settings.SettingsAppsFragment$$ExternalSyntheticLambda0
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            SettingsAppsFragment.onClick$lambda$5(function1, obj);
                        }
                    });
                    if (completableFutureThenAccept != null) {
                        completableFutureThenAccept.exceptionally(new Function() { // from class: com.soletreadmills.sole_v2.ui.settings.SettingsAppsFragment$$ExternalSyntheticLambda1
                            @Override // java.util.function.Function
                            public final Object apply(Object obj) {
                                return SettingsAppsFragment.onClick$lambda$6((Throwable) obj);
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            }
            Toast.makeText(getActivity(), getString(R.string.health_connect_unavailable_info), 1).show();
            try {
                Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.healthdata"));
                intent.setPackage("com.android.vending");
                startActivity(intent);
                return;
            } catch (Exception e) {
                Timber.INSTANCE.e(e.getMessage(), new Object[0]);
                return;
            }
        }
        int i3 = R.id.ll_samsung_health;
        if (numValueOf != null && numValueOf.intValue() == i3) {
            Timber.INSTANCE.d("link Samsung Health", new Object[0]);
            final SamsungHealthManager samsungHealthManager = this.samsungHealthManager;
            if (samsungHealthManager != null) {
                Context contextRequireContext = requireContext();
                Intrinsics.checkNotNullExpressionValue(contextRequireContext, "requireContext(...)");
                if (samsungHealthManager.isSamsungHealthInstalled(contextRequireContext)) {
                    Timber.INSTANCE.tag("SamsungHealth").d("1 確認已安裝SamsungHealth", new Object[0]);
                    if (!samsungHealthManager.checkSamsungHealthPermissions()) {
                        Timber.INSTANCE.tag("SamsungHealth").d("1-1 無權限時,要求權限", new Object[0]);
                        FragmentActivity fragmentActivityRequireActivity = requireActivity();
                        Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity, "requireActivity(...)");
                        samsungHealthManager.connectHealthData(fragmentActivityRequireActivity, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.settings.SettingsAppsFragment$onClick$3$1
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
                                SamsungHealthManager samsungHealthManager2 = samsungHealthManager;
                                FragmentActivity fragmentActivityRequireActivity2 = this.requireActivity();
                                Intrinsics.checkNotNullExpressionValue(fragmentActivityRequireActivity2, "requireActivity(...)");
                                samsungHealthManager2.requestSamsungHealthPermission(fragmentActivityRequireActivity2);
                            }
                        });
                    } else {
                        Timber.INSTANCE.tag("SamsungHealth").d("1-2 有權限時,開啟設定頁面", new Object[0]);
                        Context contextRequireContext2 = requireContext();
                        Intrinsics.checkNotNullExpressionValue(contextRequireContext2, "requireContext(...)");
                        samsungHealthManager.openSamsungHealthOrInstall(contextRequireContext2);
                    }
                } else {
                    Timber.INSTANCE.tag("SamsungHealth").d("2 確認未安裝SamsungHealth", new Object[0]);
                    Context contextRequireContext3 = requireContext();
                    Intrinsics.checkNotNullExpressionValue(contextRequireContext3, "requireContext(...)");
                    samsungHealthManager.openSamsungHealthOrInstall(contextRequireContext3);
                }
                unit = Unit.INSTANCE;
            }
            if (unit == null) {
                Timber.INSTANCE.e("samsungHealthManager is null", new Object[0]);
                return;
            }
            return;
        }
        int i4 = R.id.ll_garmin_connect;
        if (numValueOf != null && numValueOf.intValue() == i4) {
            Timber.INSTANCE.d("link Garmin", new Object[0]);
            if (Global.userData != null) {
                if (!this.isGarminConnected) {
                    garminStartUserAuth();
                } else {
                    CustomDialogKt.showCustomDialog$default(this, null, getString(R.string.do_you_want_to_disconnect) + ' ' + getString(R.string.garmin) + " ?", getString(R.string.yes), getString(R.string.cancel), new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui.settings.SettingsAppsFragment.onClick.5
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
                            SettingsAppsFragment.this.garminRevokeUserAuth();
                        }
                    }, null, false, 96, null);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onClick$lambda$5(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void onClick$lambda$6(Throwable e) {
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void setGarminConnectedView(final boolean isConnected) {
        View root;
        Runnable runnable = new Runnable() { // from class: com.soletreadmills.sole_v2.ui.settings.SettingsAppsFragment$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                SettingsAppsFragment.setGarminConnectedView$lambda$9(isConnected, this);
            }
        };
        if (Intrinsics.areEqual(Looper.myLooper(), Looper.getMainLooper())) {
            runnable.run();
            return;
        }
        FragmentSettingsAppsBinding binding = getBinding();
        if (binding == null || (root = binding.getRoot()) == null) {
            return;
        }
        root.post(runnable);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setGarminConnectedView$lambda$9(boolean z, SettingsAppsFragment this$0) {
        TextView textView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z) {
            FragmentSettingsAppsBinding binding = this$0.getBinding();
            textView = binding != null ? binding.tvGarminConnectLinked : null;
            if (textView != null) {
                textView.setVisibility(0);
            }
            this$0.isGarminConnected = true;
            return;
        }
        FragmentSettingsAppsBinding binding2 = this$0.getBinding();
        textView = binding2 != null ? binding2.tvGarminConnectLinked : null;
        if (textView != null) {
            textView.setVisibility(8);
        }
        this$0.isGarminConnected = false;
    }

    /* compiled from: SettingsAppsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.SettingsAppsFragment$getConnectedExternalService$1", f = "SettingsAppsFragment.kt", i = {}, l = {304}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.SettingsAppsFragment$getConnectedExternalService$1, reason: invalid class name and case insensitive filesystem */
    static final class C10051 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C10051(Continuation<? super C10051> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SettingsAppsFragment.this.new C10051(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10051) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            GetConnectedExternalServiceApiData.DataMap dataMap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            boolean z = true;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        obj = DyacoApiKt.callGetConnectedExternalService(this);
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
                    GetConnectedExternalServiceApiData.ResponseData responseData = (GetConnectedExternalServiceApiData.ResponseData) response.body();
                    List<Integer> data = (responseData == null || (dataMap = responseData.getDataMap()) == null) ? null : dataMap.getData();
                    Timber.INSTANCE.d("getConnectedExternalService: " + data, new Object[0]);
                    GetConnectedExternalServiceApiData.ResponseData responseData2 = (GetConnectedExternalServiceApiData.ResponseData) response.body();
                    String errorCode = responseData2 != null ? responseData2.getErrorCode() : null;
                    GetConnectedExternalServiceApiData.ResponseData responseData3 = (GetConnectedExternalServiceApiData.ResponseData) response.body();
                    if (responseData3 == null || !responseData3.getSuccess()) {
                        if (SettingsAppsFragment.this.shouldIgnoreError(errorCode)) {
                            return Unit.INSTANCE;
                        }
                        SettingsAppsFragment settingsAppsFragment = SettingsAppsFragment.this;
                        GetConnectedExternalServiceApiData.ResponseData responseData4 = (GetConnectedExternalServiceApiData.ResponseData) response.body();
                        BaseFragment.handleUndefinedError$default(settingsAppsFragment, "getConnectedExternalService", errorCode, responseData4 != null ? responseData4.getErrorMessage() : null, false, 8, null);
                        SettingsAppsFragment.this.setGarminConnectedView(false);
                    } else if (data == null) {
                        z = false;
                        SettingsAppsFragment.this.setGarminConnectedView(z);
                    } else {
                        List<Integer> list = data;
                        if (!(list instanceof Collection) || !list.isEmpty()) {
                            for (Integer num : list) {
                                if (num != null && num.intValue() == 1) {
                                    break;
                                }
                            }
                        }
                        z = false;
                        SettingsAppsFragment.this.setGarminConnectedView(z);
                    }
                } catch (IOException e) {
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(SettingsAppsFragment.this, "getConnectedExternalService", message, false, 4, null);
                    SettingsAppsFragment.this.setGarminConnectedView(false);
                }
                SettingsAppsFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                SettingsAppsFragment.this.stopLoading();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void getConnectedExternalService() {
        showLoading();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C10051(null), 3, null);
    }

    private final void garminStartUserAuth() {
        showLoading();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C10041(null), 3, null);
    }

    /* compiled from: SettingsAppsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.SettingsAppsFragment$garminStartUserAuth$1", f = "SettingsAppsFragment.kt", i = {}, l = {359}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.SettingsAppsFragment$garminStartUserAuth$1, reason: invalid class name and case insensitive filesystem */
    static final class C10041 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C10041(Continuation<? super C10041> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SettingsAppsFragment.this.new C10041(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10041) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object objCallGarminStartUserAuth;
            GarminStartUserAuthApiData.DataMap dataMap;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        this.label = 1;
                        objCallGarminStartUserAuth = DyacoApiKt.callGarminStartUserAuth(this);
                        if (objCallGarminStartUserAuth == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        objCallGarminStartUserAuth = obj;
                    }
                    Response response = (Response) objCallGarminStartUserAuth;
                    GarminStartUserAuthApiData.ResponseData responseData = (GarminStartUserAuthApiData.ResponseData) response.body();
                    Timber.INSTANCE.d("callGarminStartUserAuth: " + response, new Object[0]);
                    GarminStartUserAuthApiData.ResponseData responseData2 = (GarminStartUserAuthApiData.ResponseData) response.body();
                    String errorCode = responseData2 != null ? responseData2.getErrorCode() : null;
                    String url = (responseData == null || (dataMap = responseData.getDataMap()) == null) ? null : dataMap.getUrl();
                    Timber.INSTANCE.d("authUrl: " + url, new Object[0]);
                    GarminStartUserAuthApiData.ResponseData responseData3 = (GarminStartUserAuthApiData.ResponseData) response.body();
                    if (responseData3 == null || !responseData3.getSuccess()) {
                        if (SettingsAppsFragment.this.shouldIgnoreError(errorCode)) {
                            return Unit.INSTANCE;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required)), TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), null)).get(errorCode);
                        if (num != null) {
                            SettingsAppsFragment settingsAppsFragment = SettingsAppsFragment.this;
                            CustomDialogKt.showCustomDialog$default(settingsAppsFragment, null, settingsAppsFragment.getString(num.intValue()), SettingsAppsFragment.this.getString(R.string.confirm), null, null, null, false, 112, null);
                        } else {
                            SettingsAppsFragment settingsAppsFragment2 = SettingsAppsFragment.this;
                            GarminStartUserAuthApiData.ResponseData responseData4 = (GarminStartUserAuthApiData.ResponseData) response.body();
                            BaseFragment.handleUndefinedError$default(settingsAppsFragment2, "garminStartUserAuth", errorCode, responseData4 != null ? responseData4.getErrorMessage() : null, false, 8, null);
                        }
                    } else {
                        String str = url;
                        if (str != null && str.length() != 0 && URLUtil.isNetworkUrl(url)) {
                            Bundle bundle = new Bundle();
                            bundle.putString("KEY_GARMIN_URL", url);
                            SettingsAppsFragment.this.safeNavigate(R.id.garminConnectFragment, bundle);
                        }
                    }
                } catch (IOException e) {
                    Timber.INSTANCE.e(e, "API call failed", new Object[0]);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(SettingsAppsFragment.this, "garminStartUserAuth", message, false, 4, null);
                }
                SettingsAppsFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                SettingsAppsFragment.this.stopLoading();
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void garminRevokeUserAuth() {
        showLoading();
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(null), 3, null);
    }

    /* compiled from: SettingsAppsFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.SettingsAppsFragment$garminRevokeUserAuth$1", f = "SettingsAppsFragment.kt", i = {}, l = {429}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.SettingsAppsFragment$garminRevokeUserAuth$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SettingsAppsFragment.this.new AnonymousClass1(continuation);
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
                        this.label = 1;
                        obj = DyacoApiKt.callGarminRevokeUserAuth(this);
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
                    Timber.INSTANCE.d("garminRevokeUserAuth: " + response, new Object[0]);
                    WebApiBaseData webApiBaseData = (WebApiBaseData) response.body();
                    String errorCode = webApiBaseData != null ? webApiBaseData.getErrorCode() : null;
                    WebApiBaseData webApiBaseData2 = (WebApiBaseData) response.body();
                    if (webApiBaseData2 == null || !webApiBaseData2.getSuccess()) {
                        if (SettingsAppsFragment.this.shouldIgnoreError(errorCode)) {
                            return Unit.INSTANCE;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.LOGIN_REQUIRED_113.getId(), Boxing.boxInt(R.string.login_required)), TuplesKt.to(ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId(), null)).get(errorCode);
                        if (num != null) {
                            SettingsAppsFragment settingsAppsFragment = SettingsAppsFragment.this;
                            CustomDialogKt.showCustomDialog$default(settingsAppsFragment, null, settingsAppsFragment.getString(num.intValue()), SettingsAppsFragment.this.getString(R.string.confirm), null, null, null, false, 112, null);
                        } else {
                            SettingsAppsFragment settingsAppsFragment2 = SettingsAppsFragment.this;
                            WebApiBaseData webApiBaseData3 = (WebApiBaseData) response.body();
                            BaseFragment.handleUndefinedError$default(settingsAppsFragment2, "garminRevokeUserAuth", errorCode, webApiBaseData3 != null ? webApiBaseData3.getErrorMessage() : null, false, 8, null);
                        }
                        SettingsAppsFragment.this.getConnectedExternalService();
                    } else {
                        SettingsAppsFragment.this.getConnectedExternalService();
                    }
                } catch (IOException e) {
                    Timber.INSTANCE.e(e, "API call failed", new Object[0]);
                    String message = e.getMessage();
                    if (message == null) {
                        message = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(SettingsAppsFragment.this, "garminRevokeUserAuth", message, false, 4, null);
                }
                SettingsAppsFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                SettingsAppsFragment.this.stopLoading();
            }
        }
    }

    private final void setHealthConnectedView() {
        try {
            MainActivity mainActivity = getMainActivity();
            CompletableFuture<Boolean> completableFutureHasAllPermissionsAsync = null;
            Integer numValueOf = mainActivity != null ? Integer.valueOf(HealthConnectClient.Companion.getSdkStatus$default(HealthConnectClient.INSTANCE, mainActivity, null, 2, null)) : null;
            if (numValueOf != null && numValueOf.intValue() == 3) {
                MainActivity mainActivity2 = getMainActivity();
                if (mainActivity2 != null) {
                    HealthDataManager healthDataManager = this.healthDataManager;
                    Intrinsics.checkNotNull(healthDataManager);
                    completableFutureHasAllPermissionsAsync = healthDataManager.hasAllPermissionsAsync(mainActivity2, this.permissions);
                }
                if (completableFutureHasAllPermissionsAsync != null) {
                    final C10071 c10071 = new C10071();
                    CompletableFuture<Void> completableFutureThenAccept = completableFutureHasAllPermissionsAsync.thenAccept(new Consumer() { // from class: com.soletreadmills.sole_v2.ui.settings.SettingsAppsFragment$$ExternalSyntheticLambda3
                        @Override // java.util.function.Consumer
                        public final void accept(Object obj) {
                            SettingsAppsFragment.setHealthConnectedView$lambda$12(c10071, obj);
                        }
                    });
                    if (completableFutureThenAccept != null) {
                        completableFutureThenAccept.exceptionally(new Function() { // from class: com.soletreadmills.sole_v2.ui.settings.SettingsAppsFragment$$ExternalSyntheticLambda4
                            @Override // java.util.function.Function
                            public final Object apply(Object obj) {
                                return SettingsAppsFragment.setHealthConnectedView$lambda$13(this.f$0, (Throwable) obj);
                            }
                        });
                        return;
                    }
                    return;
                }
                return;
            }
            FragmentSettingsAppsBinding binding = getBinding();
            TextView textView = binding != null ? binding.tvHealthConnectLinked : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
        } catch (Exception e) {
            Timber.INSTANCE.e(e.getMessage(), new Object[0]);
        }
    }

    /* compiled from: SettingsAppsFragment.kt */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\n¢\u0006\u0002\b\u0004"}, d2 = {"<anonymous>", "", "hasAllPermissions", "", "invoke"}, k = 3, mv = {1, 9, 0}, xi = 48)
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.SettingsAppsFragment$setHealthConnectedView$1, reason: invalid class name and case insensitive filesystem */
    static final class C10071 extends Lambda implements Function1<Boolean, Unit> {
        C10071() {
            super(1);
        }

        @Override // kotlin.jvm.functions.Function1
        public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
            invoke(bool.booleanValue());
            return Unit.INSTANCE;
        }

        public final void invoke(final boolean z) {
            MainActivity mainActivity = SettingsAppsFragment.this.getMainActivity();
            if (mainActivity != null) {
                final SettingsAppsFragment settingsAppsFragment = SettingsAppsFragment.this;
                mainActivity.runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.settings.SettingsAppsFragment$setHealthConnectedView$1$$ExternalSyntheticLambda0
                    @Override // java.lang.Runnable
                    public final void run() {
                        SettingsAppsFragment.C10071.invoke$lambda$1(z, settingsAppsFragment);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$1(boolean z, final SettingsAppsFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            if (z) {
                FragmentSettingsAppsBinding fragmentSettingsAppsBindingAccess$getBinding = SettingsAppsFragment.access$getBinding(this$0);
                TextView textView = fragmentSettingsAppsBindingAccess$getBinding != null ? fragmentSettingsAppsBindingAccess$getBinding.tvHealthConnectLinked : null;
                if (textView == null) {
                    return;
                }
                textView.setVisibility(0);
                return;
            }
            MainActivity mainActivity = this$0.getMainActivity();
            if (mainActivity != null) {
                mainActivity.runOnUiThread(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.settings.SettingsAppsFragment$setHealthConnectedView$1$$ExternalSyntheticLambda1
                    @Override // java.lang.Runnable
                    public final void run() {
                        SettingsAppsFragment.C10071.invoke$lambda$1$lambda$0(this$0);
                    }
                });
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final void invoke$lambda$1$lambda$0(SettingsAppsFragment this$0) {
            Intrinsics.checkNotNullParameter(this$0, "this$0");
            FragmentSettingsAppsBinding fragmentSettingsAppsBindingAccess$getBinding = SettingsAppsFragment.access$getBinding(this$0);
            TextView textView = fragmentSettingsAppsBindingAccess$getBinding != null ? fragmentSettingsAppsBindingAccess$getBinding.tvHealthConnectLinked : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void setHealthConnectedView$lambda$12(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Void setHealthConnectedView$lambda$13(SettingsAppsFragment this$0, Throwable e) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(e, "e");
        e.printStackTrace();
        FragmentSettingsAppsBinding binding = this$0.getBinding();
        TextView textView = binding != null ? binding.tvHealthConnectLinked : null;
        if (textView != null) {
            textView.setVisibility(8);
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void toHealthConnect() {
        try {
            if (Build.VERSION.SDK_INT >= 34) {
                CustomDialogKt.showCustomDialog$default(this, null, getString(R.string.health_connect_for_14), getString(R.string.yes), null, null, null, false, 120, null);
                return;
            }
            MainActivity mainActivity = getMainActivity();
            PackageManager packageManager = mainActivity != null ? mainActivity.getPackageManager() : null;
            Intent launchIntentForPackage = packageManager != null ? packageManager.getLaunchIntentForPackage("com.google.android.apps.healthdata") : null;
            if (launchIntentForPackage != null) {
                startActivity(launchIntentForPackage);
                return;
            }
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://play.google.com/store/apps/details?id=com.google.android.apps.healthdata"));
            intent.setPackage("com.android.vending");
            startActivity(intent);
        } catch (Exception e) {
            Timber.INSTANCE.e(e.getMessage(), new Object[0]);
        }
    }

    private final void setSamsungHealthConnectedView() {
        Timber.INSTANCE.d("setSamsungHealthConnectedView()", new Object[0]);
        SamsungHealthManager samsungHealthManager = this.samsungHealthManager;
        if (samsungHealthManager != null) {
            FragmentSettingsAppsBinding binding = getBinding();
            TextView textView = binding != null ? binding.tvSamsungHealthLinked : null;
            if (textView == null) {
                return;
            }
            textView.setVisibility(samsungHealthManager.checkSamsungHealthPermissions() ? 0 : 8);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$1(Map result) {
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.isEmpty()) {
            return;
        }
        Iterator it = result.entrySet().iterator();
        while (it.hasNext() && ((Boolean) ((Map.Entry) it.next()).getValue()).booleanValue()) {
        }
    }
}
