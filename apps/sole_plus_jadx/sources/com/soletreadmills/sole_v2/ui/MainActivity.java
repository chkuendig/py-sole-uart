package com.soletreadmills.sole_v2.ui;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.RelativeLayout;
import androidx.activity.EdgeToEdge;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.Insets;
import androidx.core.view.OnApplyWindowInsetsListener;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.RepeatOnLifecycleKt;
import androidx.lifecycle.ViewModelLazy;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.navigation.NavController;
import androidx.navigation.NavDestination;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.wearable.CapabilityInfo;
import com.google.android.gms.wearable.Wearable;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.FirebaseApp;
import com.google.firebase.messaging.Constants;
import com.soletreadmills.sole_v2.AppConfigKt;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.settings.GetMessagesApiData;
import com.soletreadmills.sole_v2._data.ble.BleDeviceInfoData;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2._manager.ChangeViewManager;
import com.soletreadmills.sole_v2._manager.LogManager;
import com.soletreadmills.sole_v2._manager.LogoutManager;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager;
import com.soletreadmills.sole_v2.databinding.ActivityMainBinding;
import com.soletreadmills.sole_v2.ui._base.BaseActivity;
import com.soletreadmills.sole_v2.ui.customview.BaseRelativeLayout;
import com.soletreadmills.sole_v2.ui.settings.SettingViewModel;
import io.ktor.http.auth.AuthScheme;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
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
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.SharedFlow;
import timber.log.Timber;

/* compiled from: MainActivity.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010,\u001a\u00020!2\u0012\u0010-\u001a\u000e\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!0\u001fJ\u000e\u0010.\u001a\u00020!2\u0006\u0010/\u001a\u00020\u0019J\u0010\u00100\u001a\u00020!2\u0006\u0010/\u001a\u00020\u0019H\u0002J.\u00101\u001a\u00020!2\u0006\u00102\u001a\u00020%2\u0006\u00103\u001a\u00020%2\n\b\u0002\u00104\u001a\u0004\u0018\u00010%2\n\b\u0002\u00105\u001a\u0004\u0018\u00010%J\b\u00106\u001a\u00020!H\u0002J\b\u00107\u001a\u00020!H\u0016J\u0012\u00108\u001a\u00020!2\b\u00109\u001a\u0004\u0018\u00010:H\u0014J\u0010\u0010;\u001a\u00020!2\u0006\u0010/\u001a\u00020\u0019H\u0014J\u0010\u0010<\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u00010\u0019R\u001e\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u0004\u0018\u00010\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u000e\u0010\u000e\u001a\u00020\u000fX\u0082.¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u00020\u0011X\u0086.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082.¢\u0006\u0002\n\u0000R\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001c\u0010\u001e\u001a\u0010\u0012\u0004\u0012\u00020 \u0012\u0004\u0012\u00020!\u0018\u00010\u001fX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020%0$0#X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010&\u001a\u00020'8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)¨\u0006="}, d2 = {"Lcom/soletreadmills/sole_v2/ui/MainActivity;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseActivity;", "()V", "<set-?>", "Lcom/soletreadmills/sole_v2/databinding/ActivityMainBinding;", "binding", "getBinding", "()Lcom/soletreadmills/sole_v2/databinding/ActivityMainBinding;", "bleManager", "Lcom/soletreadmills/sole_v2/_manager/BleManager;", "getBleManager", "()Lcom/soletreadmills/sole_v2/_manager/BleManager;", "setBleManager", "(Lcom/soletreadmills/sole_v2/_manager/BleManager;)V", "bottomNav", "Lcom/google/android/material/bottomnavigation/BottomNavigationView;", "changeViewManager", "Lcom/soletreadmills/sole_v2/_manager/ChangeViewManager;", "getChangeViewManager", "()Lcom/soletreadmills/sole_v2/_manager/ChangeViewManager;", "setChangeViewManager", "(Lcom/soletreadmills/sole_v2/_manager/ChangeViewManager;)V", "navController", "Landroidx/navigation/NavController;", "pendingFcmIntent", "Landroid/content/Intent;", "getPendingFcmIntent", "()Landroid/content/Intent;", "setPendingFcmIntent", "(Landroid/content/Intent;)V", "permissionCallback", "Lkotlin/Function1;", "", "", "requestBluetoothPermissions", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "settingViewModel", "Lcom/soletreadmills/sole_v2/ui/settings/SettingViewModel;", "getSettingViewModel", "()Lcom/soletreadmills/sole_v2/ui/settings/SettingViewModel;", "settingViewModel$delegate", "Lkotlin/Lazy;", "checkBluetoothPermissions", "onResult", "handleFcmData", "intent", "handleOAuthCallback", "logErrorUpload", "apiName", "errorType", "errorCode", "errorMsg", "observeLogoutEvent", "onBackPressed", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onNewIntent", "parseFcmIntent", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MainActivity extends BaseActivity {
    public static final int $stable = 8;
    private ActivityMainBinding binding;
    private BleManager bleManager;
    private BottomNavigationView bottomNav;
    public ChangeViewManager changeViewManager;
    private NavController navController;
    private Intent pendingFcmIntent;
    private Function1<? super Boolean, Unit> permissionCallback;
    private final ActivityResultLauncher<String[]> requestBluetoothPermissions = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.soletreadmills.sole_v2.ui.MainActivity$$ExternalSyntheticLambda5
        @Override // androidx.activity.result.ActivityResultCallback
        public final void onActivityResult(Object obj) {
            MainActivity.requestBluetoothPermissions$lambda$1(this.f$0, (Map) obj);
        }
    });

    /* renamed from: settingViewModel$delegate, reason: from kotlin metadata */
    private final Lazy settingViewModel;

    public MainActivity() {
        final MainActivity mainActivity = this;
        final Function0 function0 = null;
        this.settingViewModel = new ViewModelLazy(Reflection.getOrCreateKotlinClass(SettingViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.MainActivity$special$$inlined$viewModels$default$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                return mainActivity.getViewModelStore();
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.MainActivity$special$$inlined$viewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                return mainActivity.getDefaultViewModelProviderFactory();
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.MainActivity$special$$inlined$viewModels$default$3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final CreationExtras invoke() {
                CreationExtras creationExtras;
                Function0 function02 = function0;
                return (function02 == null || (creationExtras = (CreationExtras) function02.invoke()) == null) ? mainActivity.getDefaultViewModelCreationExtras() : creationExtras;
            }
        });
    }

    public final ActivityMainBinding getBinding() {
        ActivityMainBinding activityMainBinding = this.binding;
        if (activityMainBinding != null) {
            return activityMainBinding;
        }
        Intrinsics.throwUninitializedPropertyAccessException("binding");
        return null;
    }

    public final ChangeViewManager getChangeViewManager() {
        ChangeViewManager changeViewManager = this.changeViewManager;
        if (changeViewManager != null) {
            return changeViewManager;
        }
        Intrinsics.throwUninitializedPropertyAccessException("changeViewManager");
        return null;
    }

    public final void setChangeViewManager(ChangeViewManager changeViewManager) {
        Intrinsics.checkNotNullParameter(changeViewManager, "<set-?>");
        this.changeViewManager = changeViewManager;
    }

    public final BleManager getBleManager() {
        return this.bleManager;
    }

    public final void setBleManager(BleManager bleManager) {
        this.bleManager = bleManager;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void requestBluetoothPermissions$lambda$1(MainActivity this$0, Map permissions) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(permissions, "permissions");
        Collection collectionValues = permissions.values();
        boolean z = true;
        if (!(collectionValues instanceof Collection) || !collectionValues.isEmpty()) {
            Iterator it = collectionValues.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                } else if (!((Boolean) it.next()).booleanValue()) {
                    z = false;
                    break;
                }
            }
        }
        Function1<? super Boolean, Unit> function1 = this$0.permissionCallback;
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z));
        }
    }

    private final SettingViewModel getSettingViewModel() {
        return (SettingViewModel) this.settingViewModel.getValue();
    }

    public final Intent getPendingFcmIntent() {
        return this.pendingFcmIntent;
    }

    public final void setPendingFcmIntent(Intent intent) {
        this.pendingFcmIntent = intent;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MainActivity mainActivity = this;
        ViewDataBinding contentView = DataBindingUtil.setContentView(mainActivity, R.layout.activity_main);
        Intrinsics.checkNotNullExpressionValue(contentView, "setContentView(...)");
        this.binding = (ActivityMainBinding) contentView;
        setChangeViewManager(ChangeViewManager.INSTANCE.getInstance());
        ChangeViewManager changeViewManager = getChangeViewManager();
        RelativeLayout addViewLayout = getBinding().addViewLayout;
        Intrinsics.checkNotNullExpressionValue(addViewLayout, "addViewLayout");
        changeViewManager.setChangeViewManager(this, addViewLayout);
        BleManager bleManager = BleManager.getInstance();
        this.bleManager = bleManager;
        if (bleManager != null) {
            bleManager.init();
        }
        EdgeToEdge.enable$default(this, null, null, 3, null);
        FirebaseApp.initializeApp(this);
        Task<CapabilityInfo> capability = Wearable.getCapabilityClient((Activity) mainActivity).getCapability("wearable_capability", 1);
        final C08451 c08451 = new Function1<CapabilityInfo, Unit>() { // from class: com.soletreadmills.sole_v2.ui.MainActivity.onCreate.1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(CapabilityInfo capabilityInfo) {
                invoke2(capabilityInfo);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(CapabilityInfo capabilityInfo) {
                MySharedPreferences.INSTANCE.getInstance().saveIsSupportWearOS(true);
                Timber.INSTANCE.d("getIsSupportWearOS" + MySharedPreferences.INSTANCE.getInstance().getIsSupportWearOS(), new Object[0]);
            }
        };
        capability.addOnSuccessListener(new OnSuccessListener() { // from class: com.soletreadmills.sole_v2.ui.MainActivity$$ExternalSyntheticLambda0
            @Override // com.google.android.gms.tasks.OnSuccessListener
            public final void onSuccess(Object obj) {
                MainActivity.onCreate$lambda$2(c08451, obj);
            }
        }).addOnFailureListener(new OnFailureListener() { // from class: com.soletreadmills.sole_v2.ui.MainActivity$$ExternalSyntheticLambda1
            @Override // com.google.android.gms.tasks.OnFailureListener
            public final void onFailure(Exception exc) {
                MainActivity.onCreate$lambda$3(exc);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.addViewLayout), new OnApplyWindowInsetsListener() { // from class: com.soletreadmills.sole_v2.ui.MainActivity$$ExternalSyntheticLambda2
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return MainActivity.onCreate$lambda$4(view, windowInsetsCompat);
            }
        });
        Fragment fragmentFindFragmentById = getSupportFragmentManager().findFragmentById(R.id.nav_host_fragment);
        Intrinsics.checkNotNull(fragmentFindFragmentById, "null cannot be cast to non-null type androidx.navigation.fragment.NavHostFragment");
        this.navController = ((NavHostFragment) fragmentFindFragmentById).getNavController();
        View viewFindViewById = findViewById(R.id.bottom_navigation);
        Intrinsics.checkNotNullExpressionValue(viewFindViewById, "findViewById(...)");
        BottomNavigationView bottomNavigationView = (BottomNavigationView) viewFindViewById;
        this.bottomNav = bottomNavigationView;
        if (bottomNavigationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomNav");
            bottomNavigationView = null;
        }
        BottomNavigationView bottomNavigationView2 = bottomNavigationView;
        NavController navController = this.navController;
        if (navController == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController = null;
        }
        NavigationUI.setupWithNavController(bottomNavigationView2, navController);
        NavController navController2 = this.navController;
        if (navController2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("navController");
            navController2 = null;
        }
        navController2.addOnDestinationChangedListener(new NavController.OnDestinationChangedListener() { // from class: com.soletreadmills.sole_v2.ui.MainActivity$$ExternalSyntheticLambda3
            @Override // androidx.navigation.NavController.OnDestinationChangedListener
            public final void onDestinationChanged(NavController navController3, NavDestination navDestination, Bundle bundle) {
                MainActivity.onCreate$lambda$5(this.f$0, navController3, navDestination, bundle);
            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.nav_host_fragment), new OnApplyWindowInsetsListener() { // from class: com.soletreadmills.sole_v2.ui.MainActivity$$ExternalSyntheticLambda4
            @Override // androidx.core.view.OnApplyWindowInsetsListener
            public final WindowInsetsCompat onApplyWindowInsets(View view, WindowInsetsCompat windowInsetsCompat) {
                return MainActivity.onCreate$lambda$6(this.f$0, view, windowInsetsCompat);
            }
        });
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass6(null), 3, null);
        observeLogoutEvent();
        parseFcmIntent(getIntent());
        Intent intent = getIntent();
        Intrinsics.checkNotNullExpressionValue(intent, "getIntent(...)");
        handleOAuthCallback(intent);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$2(Function1 tmp0, Object obj) {
        Intrinsics.checkNotNullParameter(tmp0, "$tmp0");
        tmp0.invoke(obj);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$3(Exception exc) {
        Timber.INSTANCE.d("getIsSupportWearOS err", new Object[0]);
        MySharedPreferences.INSTANCE.getInstance().saveIsSupportWearOS(false);
        Timber.INSTANCE.d("getIsSupportWearOS" + MySharedPreferences.INSTANCE.getInstance().getIsSupportWearOS(), new Object[0]);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onCreate$lambda$4(View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        v.setPadding(v.getPaddingLeft(), v.getPaddingTop(), v.getPaddingRight(), insets2.bottom);
        return insets;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$5(MainActivity this$0, NavController navController, NavDestination destination, Bundle bundle) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(navController, "<anonymous parameter 0>");
        Intrinsics.checkNotNullParameter(destination, "destination");
        int id2 = destination.getId();
        boolean z = true;
        if (id2 != R.id.classesMainFragment && id2 != R.id.activityMainFragment && id2 != R.id.settingsMainFragment && id2 != R.id.homeMainFragment && id2 != R.id.clubMainFragment) {
            z = false;
        }
        BottomNavigationView bottomNavigationView = this$0.bottomNav;
        if (bottomNavigationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomNav");
            bottomNavigationView = null;
        }
        bottomNavigationView.setVisibility(z ? 0 : 8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final WindowInsetsCompat onCreate$lambda$6(MainActivity this$0, View v, WindowInsetsCompat insets) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(v, "v");
        Intrinsics.checkNotNullParameter(insets, "insets");
        Insets insets2 = insets.getInsets(WindowInsetsCompat.Type.systemBars());
        Intrinsics.checkNotNullExpressionValue(insets2, "getInsets(...)");
        BottomNavigationView bottomNavigationView = this$0.bottomNav;
        if (bottomNavigationView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("bottomNav");
            bottomNavigationView = null;
        }
        if (bottomNavigationView.getVisibility() == 0) {
            v.setPadding(insets2.left, insets2.top, insets2.right, 0);
        } else {
            v.setPadding(insets2.left, insets2.top, insets2.right, insets2.bottom);
        }
        return insets;
    }

    /* compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.MainActivity$onCreate$6", f = "MainActivity.kt", i = {}, l = {161}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.MainActivity$onCreate$6, reason: invalid class name */
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass6(Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass6(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (AppConfigKt.getFirebaseMessagingToken(this) == coroutine_suspended) {
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

    /* compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.MainActivity$observeLogoutEvent$1", f = "MainActivity.kt", i = {}, l = {173}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.MainActivity$observeLogoutEvent$1, reason: invalid class name and case insensitive filesystem */
    static final class C08441 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        C08441(Continuation<? super C08441> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return MainActivity.this.new C08441(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C08441) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* compiled from: MainActivity.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.MainActivity$observeLogoutEvent$1$1", f = "MainActivity.kt", i = {}, l = {174}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.MainActivity$observeLogoutEvent$1$1, reason: invalid class name and collision with other inner class name */
        static final class C02081 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            int label;
            final /* synthetic */ MainActivity this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            C02081(MainActivity mainActivity, Continuation<? super C02081> continuation) {
                super(2, continuation);
                this.this$0 = mainActivity;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new C02081(this.this$0, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((C02081) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int i = this.label;
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    SharedFlow<Unit> logoutEvent = LogoutManager.INSTANCE.getLogoutEvent();
                    final MainActivity mainActivity = this.this$0;
                    this.label = 1;
                    if (logoutEvent.collect(new FlowCollector() { // from class: com.soletreadmills.sole_v2.ui.MainActivity.observeLogoutEvent.1.1.1
                        @Override // kotlinx.coroutines.flow.FlowCollector
                        public /* bridge */ /* synthetic */ Object emit(Object obj2, Continuation continuation) {
                            return emit((Unit) obj2, (Continuation<? super Unit>) continuation);
                        }

                        public final Object emit(Unit unit, Continuation<? super Unit> continuation) {
                            Timber.INSTANCE.d("收到登出事件", new Object[0]);
                            try {
                                NavController navController = mainActivity.navController;
                                NavController navController2 = null;
                                if (navController == null) {
                                    Intrinsics.throwUninitializedPropertyAccessException("navController");
                                    navController = null;
                                }
                                NavDestination currentDestination = navController.getCurrentDestination();
                                Integer numBoxInt = currentDestination != null ? Boxing.boxInt(currentDestination.getId()) : null;
                                Timber.INSTANCE.d("當前頁面 ID: " + numBoxInt, new Object[0]);
                                int i2 = R.id.loginFragment;
                                if (numBoxInt == null || numBoxInt.intValue() != i2) {
                                    BottomNavigationView bottomNavigationView = mainActivity.bottomNav;
                                    if (bottomNavigationView == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("bottomNav");
                                        bottomNavigationView = null;
                                    }
                                    bottomNavigationView.setVisibility(8);
                                    NavController navController3 = mainActivity.navController;
                                    if (navController3 == null) {
                                        Intrinsics.throwUninitializedPropertyAccessException("navController");
                                    } else {
                                        navController2 = navController3;
                                    }
                                    navController2.navigate(R.id.action_global_logout);
                                    Timber.INSTANCE.d("✅ 成功導航到登入頁", new Object[0]);
                                } else {
                                    Timber.INSTANCE.d("已在登入頁", new Object[0]);
                                }
                                LogoutManager.INSTANCE.onNavigatedToLogin();
                            } catch (Exception e) {
                                Timber.INSTANCE.e(e, "導航失敗: " + e.getMessage(), new Object[0]);
                                LogoutManager.INSTANCE.onNavigatedToLogin();
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
                if (RepeatOnLifecycleKt.repeatOnLifecycle(MainActivity.this, Lifecycle.State.STARTED, new C02081(MainActivity.this, null), this) == coroutine_suspended) {
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

    private final void observeLogoutEvent() {
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new C08441(null), 3, null);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        BaseRelativeLayout nowView = getChangeViewManager().getNowView();
        if (nowView == null) {
            super.onBackPressed();
        } else {
            if (nowView.onBackPressed()) {
                return;
            }
            getChangeViewManager().closePage();
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void checkBluetoothPermissions(Function1<? super Boolean, Unit> onResult) {
        Intrinsics.checkNotNullParameter(onResult, "onResult");
        ArrayList arrayList = new ArrayList();
        if (Build.VERSION.SDK_INT >= 31) {
            arrayList.add("android.permission.BLUETOOTH_SCAN");
            arrayList.add("android.permission.BLUETOOTH_CONNECT");
        } else {
            arrayList.add("android.permission.ACCESS_FINE_LOCATION");
            arrayList.add("android.permission.ACCESS_COARSE_LOCATION");
        }
        ArrayList arrayList2 = new ArrayList();
        for (Object obj : arrayList) {
            if (ContextCompat.checkSelfPermission(this, (String) obj) != 0) {
                arrayList2.add(obj);
            }
        }
        ArrayList arrayList3 = arrayList2;
        if (arrayList3.isEmpty()) {
            onResult.invoke(true);
        } else {
            this.permissionCallback = onResult;
            this.requestBluetoothPermissions.launch(arrayList3.toArray(new String[0]));
        }
    }

    public static /* synthetic */ void logErrorUpload$default(MainActivity mainActivity, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            str4 = null;
        }
        mainActivity.logErrorUpload(str, str2, str3, str4);
    }

    public final void logErrorUpload(String apiName, String errorType, String errorCode, String errorMsg) {
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Intrinsics.checkNotNullParameter(errorType, "errorType");
        Timber.INSTANCE.d("logErrorUpload", new Object[0]);
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), null, null, new AnonymousClass1(apiName, errorCode, errorMsg, errorType, null), 3, null);
    }

    /* compiled from: MainActivity.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.MainActivity$logErrorUpload$1", f = "MainActivity.kt", i = {}, l = {260}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.MainActivity$logErrorUpload$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $apiName;
        final /* synthetic */ String $errorCode;
        final /* synthetic */ String $errorMsg;
        final /* synthetic */ String $errorType;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, String str2, String str3, String str4, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$apiName = str;
            this.$errorCode = str2;
            this.$errorMsg = str3;
            this.$errorType = str4;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$apiName, this.$errorCode, this.$errorMsg, this.$errorType, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            String name;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    BleDeviceInfoData connectFtmsBleDeviceInfoData = BleManager.getInstance().getConnectFtmsBleDeviceInfoData();
                    if (connectFtmsBleDeviceInfoData == null || (name = connectFtmsBleDeviceInfoData.getName()) == null) {
                        name = "no device";
                    }
                    FtmsDeviceManager ftmsDeviceManager = BleManager.getInstance().getFtmsDeviceManager();
                    Boolean boolBoxBoolean = ftmsDeviceManager != null ? Boxing.boxBoolean(ftmsDeviceManager.isFitnessMachineControlPoint()) : null;
                    String strGenerateUuid = LogManager.INSTANCE.generateUuid();
                    this.label = 1;
                    if (LogManager.INSTANCE.uploadLog(strGenerateUuid, this.$apiName, "ErrorCode " + this.$errorCode + " ErrorMsg: " + this.$errorMsg + " ErrorType: " + this.$errorType, "bleDeviceName: " + name + ", ControlPoint: " + boolBoxBoolean, this) == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    ResultKt.throwOnFailure(obj);
                }
            } catch (Exception e) {
                Timber.INSTANCE.e(e, "Failed to send error to backend", new Object[0]);
            }
            return Unit.INSTANCE;
        }
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    protected void onNewIntent(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        super.onNewIntent(intent);
        Bundle extras = intent.getExtras();
        if (extras == null) {
            Log.d("FCM_INTENT", "No extras found");
        } else {
            for (String str : extras.keySet()) {
                Log.d("FCM_INTENT", str + " = " + extras.get(str));
            }
        }
        handleOAuthCallback(intent);
        parseFcmIntent(intent);
    }

    public final void parseFcmIntent(Intent intent) {
        String str;
        if (intent == null) {
            return;
        }
        String stringExtra = intent.getStringExtra("message_url");
        String stringExtra2 = intent.getStringExtra("message_published_time");
        String str2 = stringExtra;
        if (str2 == null || str2.length() == 0 || (str = stringExtra2) == null || str.length() == 0) {
            return;
        }
        if (AppConfigKt.getServiceLoginToken().length() > 0) {
            handleFcmData(intent);
        } else {
            this.pendingFcmIntent = intent;
        }
    }

    public final void handleFcmData(Intent intent) {
        Intrinsics.checkNotNullParameter(intent, "intent");
        getSettingViewModel().setInBoxMsgData(new GetMessagesApiData.MessageData(null, null, null, Integer.valueOf(intent.getIntExtra("message_category", -1)), intent.getStringExtra(Constants.MessagePayloadKeys.MSGID_SERVER), intent.getStringExtra("message_url"), null, null));
        try {
            NavController navController = this.navController;
            NavController navController2 = null;
            if (navController == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
                navController = null;
            }
            navController.navigate(R.id.settingsMainFragment);
            NavController navController3 = this.navController;
            if (navController3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
                navController3 = null;
            }
            navController3.navigate(R.id.inboxFragment);
            NavController navController4 = this.navController;
            if (navController4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("navController");
            } else {
                navController2 = navController4;
            }
            navController2.navigate(R.id.inboxMsgFragment);
        } catch (IllegalArgumentException e) {
            Timber.INSTANCE.e(e, "NavController 跳轉錯誤", new Object[0]);
        }
    }

    private final void handleOAuthCallback(Intent intent) {
        Uri data = intent.getData();
        if (data != null) {
            Log.d(AuthScheme.OAuth, "收到 URI: " + data);
            if (Intrinsics.areEqual(data.getScheme(), "stravasole3") && Intrinsics.areEqual(data.getHost(), "com.stravasole3callback")) {
                if (Intrinsics.areEqual(data.getQueryParameter("success"), "true")) {
                    Log.d(AuthScheme.OAuth, "授權成功！");
                } else {
                    Log.d(AuthScheme.OAuth, "授權失敗或使用者取消");
                }
            }
        }
    }
}
