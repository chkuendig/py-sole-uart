package com.soletreadmills.sole_v2.ui.settings.subscription;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentResultListener;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import com.android.SdkConstants;
import com.soletreadmills.sole_v2.Global;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data._base.JwtApiBaseData;
import com.soletreadmills.sole_v2._data.api.JwtErrorCode;
import com.soletreadmills.sole_v2._data.api.settings.BluetoothSubscriptionApiData;
import com.soletreadmills.sole_v2._data.api.settings.SnSubscriptionApiData;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2._network.JwtDyacoApiKt;
import com.soletreadmills.sole_v2.ble.manager.FtmsDeviceManager;
import com.soletreadmills.sole_v2.databinding.FragmentSubscriptionBluetoothBinding;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import com.soletreadmills.sole_v2.ui._dialog.SubscriptionViaSnCameraDialog;
import com.soletreadmills.sole_v2.ui.settings.SettingViewModel;
import kotlin.Lazy;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: SubscriptionBluetoothFragment.kt */
@Metadata(d1 = {"\u0000U\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000*\u0001\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u001a\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0011H\u0002J\b\u0010\u0018\u001a\u00020\u0011H\u0016J\u0012\u0010\u0019\u001a\u00020\u00112\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00112\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\b\u0010\u001f\u001a\u00020\u0011H\u0016J\b\u0010 \u001a\u00020\u0011H\u0002J\u0006\u0010!\u001a\u00020\u0011J\u000e\u0010\"\u001a\u00020\u00112\u0006\u0010#\u001a\u00020$R\u0010\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0007R\u001b\u0010\b\u001a\u00020\t8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\f\u0010\r\u001a\u0004\b\n\u0010\u000bR\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/settings/subscription/SubscriptionBluetoothFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentSubscriptionBluetoothBinding;", "Landroid/view/View$OnClickListener;", "()V", "serialNumberTextWatcher", "com/soletreadmills/sole_v2/ui/settings/subscription/SubscriptionBluetoothFragment$serialNumberTextWatcher$1", "Lcom/soletreadmills/sole_v2/ui/settings/subscription/SubscriptionBluetoothFragment$serialNumberTextWatcher$1;", "settingViewModel", "Lcom/soletreadmills/sole_v2/ui/settings/SettingViewModel;", "getSettingViewModel", "()Lcom/soletreadmills/sole_v2/ui/settings/SettingViewModel;", "settingViewModel$delegate", "Lkotlin/Lazy;", "subscriptionViaSnCameraDialog", "Lcom/soletreadmills/sole_v2/ui/_dialog/SubscriptionViaSnCameraDialog;", "cancelSubscriptionViaSnCameraDialog", "", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initSerialNumberLayout", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onStop", "showSubscriptionViaSnCameraDialog", "snSubscription", "snSubscriptionByName", "name", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubscriptionBluetoothFragment extends BaseFragment<FragmentSubscriptionBluetoothBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private final SubscriptionBluetoothFragment$serialNumberTextWatcher$1 serialNumberTextWatcher = new TextWatcher() { // from class: com.soletreadmills.sole_v2.ui.settings.subscription.SubscriptionBluetoothFragment$serialNumberTextWatcher$1
        @Override // android.text.TextWatcher
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        }

        @Override // android.text.TextWatcher
        public void onTextChanged(CharSequence s, int start, int before, int count) {
        }

        @Override // android.text.TextWatcher
        public void afterTextChanged(Editable s) {
            Button button;
            EditText editText;
            Editable text;
            CharSequence charSequenceTrim;
            FragmentSubscriptionBluetoothBinding binding = this.this$0.getBinding();
            String string = (binding == null || (editText = binding.serialNumber) == null || (text = editText.getText()) == null || (charSequenceTrim = StringsKt.trim(text)) == null) ? null : charSequenceTrim.toString();
            if (string == null || string.length() == 0) {
                FragmentSubscriptionBluetoothBinding binding2 = this.this$0.getBinding();
                button = binding2 != null ? binding2.submit : null;
                if (button == null) {
                    return;
                }
                button.setEnabled(false);
                return;
            }
            FragmentSubscriptionBluetoothBinding binding3 = this.this$0.getBinding();
            button = binding3 != null ? binding3.submit : null;
            if (button == null) {
                return;
            }
            button.setEnabled(true);
        }
    };

    /* renamed from: settingViewModel$delegate, reason: from kotlin metadata */
    private final Lazy settingViewModel;
    private SubscriptionViaSnCameraDialog subscriptionViaSnCameraDialog;

    /* JADX WARN: Type inference failed for: r0v3, types: [com.soletreadmills.sole_v2.ui.settings.subscription.SubscriptionBluetoothFragment$serialNumberTextWatcher$1] */
    public SubscriptionBluetoothFragment() {
        final SubscriptionBluetoothFragment subscriptionBluetoothFragment = this;
        final Function0 function0 = null;
        this.settingViewModel = FragmentViewModelLazyKt.createViewModelLazy(subscriptionBluetoothFragment, Reflection.getOrCreateKotlinClass(SettingViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui.settings.subscription.SubscriptionBluetoothFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = subscriptionBluetoothFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui.settings.subscription.SubscriptionBluetoothFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = subscriptionBluetoothFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui.settings.subscription.SubscriptionBluetoothFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = subscriptionBluetoothFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    private final SettingViewModel getSettingViewModel() {
        return (SettingViewModel) this.settingViewModel.getValue();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentSubscriptionBluetoothBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentSubscriptionBluetoothBinding fragmentSubscriptionBluetoothBindingInflate = FragmentSubscriptionBluetoothBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentSubscriptionBluetoothBindingInflate, "inflate(...)");
        return fragmentSubscriptionBluetoothBindingInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getChildFragmentManager().setFragmentResultListener(SubscriptionViaSnCameraDialog.KEY_RESULT, this, new FragmentResultListener() { // from class: com.soletreadmills.sole_v2.ui.settings.subscription.SubscriptionBluetoothFragment$$ExternalSyntheticLambda0
            @Override // androidx.fragment.app.FragmentResultListener
            public final void onFragmentResult(String str, Bundle bundle) {
                SubscriptionBluetoothFragment.onCreate$lambda$0(this.f$0, str, bundle);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onCreate$lambda$0(SubscriptionBluetoothFragment this$0, String requestKey, Bundle result) {
        EditText editText;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(requestKey, "requestKey");
        Intrinsics.checkNotNullParameter(result, "result");
        if (requestKey.hashCode() == 1555644515 && requestKey.equals(SubscriptionViaSnCameraDialog.KEY_RESULT)) {
            String string = result.getString(SubscriptionViaSnCameraDialog.KEY_RESULT_SN);
            FragmentSubscriptionBluetoothBinding binding = this$0.getBinding();
            if (binding == null || (editText = binding.serialNumber) == null) {
                return;
            }
            editText.setText(string);
        }
    }

    @Override // androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
        cancelSubscriptionViaSnCameraDialog();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        ImageView imageView;
        Button button;
        TextView textView;
        AppCompatTextView appCompatTextView;
        ConstraintLayout constraintLayout;
        ImageView imageView2;
        FragmentSubscriptionBluetoothBinding binding = getBinding();
        if (binding != null && (imageView2 = binding.back) != null) {
            imageView2.setOnClickListener(this);
        }
        FragmentSubscriptionBluetoothBinding binding2 = getBinding();
        if (binding2 != null && (constraintLayout = binding2.bleDevice) != null) {
            constraintLayout.setOnClickListener(this);
        }
        FragmentSubscriptionBluetoothBinding binding3 = getBinding();
        if (binding3 != null && (appCompatTextView = binding3.iLostMyNumber) != null) {
            appCompatTextView.setOnClickListener(this);
        }
        FragmentSubscriptionBluetoothBinding binding4 = getBinding();
        if (binding4 != null && (textView = binding4.useSerialNumber) != null) {
            textView.setOnClickListener(this);
        }
        FragmentSubscriptionBluetoothBinding binding5 = getBinding();
        if (binding5 != null && (button = binding5.submit) != null) {
            button.setOnClickListener(this);
        }
        FragmentSubscriptionBluetoothBinding binding6 = getBinding();
        if (binding6 == null || (imageView = binding6.imgCamera) == null) {
            return;
        }
        imageView.setOnClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        FtmsDeviceManager ftmsDeviceManager;
        bluetoothDeviceName = null;
        String bluetoothDeviceName = null;
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.back;
        if (numValueOf != null && numValueOf.intValue() == i) {
            safeNavigateUp();
            return;
        }
        int i2 = R.id.bleDevice;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            BleManager bleManager = BleManager.getInstance();
            if (bleManager != null && (ftmsDeviceManager = bleManager.getFtmsDeviceManager()) != null) {
                bluetoothDeviceName = ftmsDeviceManager.getBluetoothDeviceName();
            }
            String str = bluetoothDeviceName;
            if (str != null && str.length() != 0) {
                snSubscriptionByName(bluetoothDeviceName);
                return;
            }
            Bundle bundle = new Bundle();
            bundle.putString("type", "Subscription");
            bundle.putString("deviceType", "MACHINE");
            safeNavigate(R.id.connectDeviceFragment, bundle);
            return;
        }
        int i3 = R.id.iLostMyNumber;
        if (numValueOf != null && numValueOf.intValue() == i3) {
            FragmentSubscriptionBluetoothBinding binding = getBinding();
            LinearLayout linearLayout = binding != null ? binding.viaSnLayout : null;
            if (linearLayout != null) {
                linearLayout.setVisibility(8);
            }
            FragmentSubscriptionBluetoothBinding binding2 = getBinding();
            LinearLayout linearLayout2 = binding2 != null ? binding2.viaBleLayout : null;
            if (linearLayout2 == null) {
                return;
            }
            linearLayout2.setVisibility(0);
            return;
        }
        int i4 = R.id.useSerialNumber;
        if (numValueOf != null && numValueOf.intValue() == i4) {
            FragmentSubscriptionBluetoothBinding binding3 = getBinding();
            LinearLayout linearLayout3 = binding3 != null ? binding3.viaSnLayout : null;
            if (linearLayout3 != null) {
                linearLayout3.setVisibility(0);
            }
            FragmentSubscriptionBluetoothBinding binding4 = getBinding();
            LinearLayout linearLayout4 = binding4 != null ? binding4.viaBleLayout : null;
            if (linearLayout4 == null) {
                return;
            }
            linearLayout4.setVisibility(8);
            return;
        }
        int i5 = R.id.submit;
        if (numValueOf != null && numValueOf.intValue() == i5) {
            snSubscription();
            return;
        }
        int i6 = R.id.img_camera;
        if (numValueOf != null && numValueOf.intValue() == i6) {
            initSerialNumberLayout();
        }
    }

    private final void initSerialNumberLayout() {
        EditText editText;
        EditText editText2;
        EditText editText3;
        Editable text;
        CharSequence charSequenceTrim;
        FragmentSubscriptionBluetoothBinding binding = getBinding();
        String string = (binding == null || (editText3 = binding.serialNumber) == null || (text = editText3.getText()) == null || (charSequenceTrim = StringsKt.trim(text)) == null) ? null : charSequenceTrim.toString();
        if (string == null || string.length() == 0) {
            showSubscriptionViaSnCameraDialog();
        } else {
            showSubscriptionViaSnCameraDialog();
        }
        FragmentSubscriptionBluetoothBinding binding2 = getBinding();
        if (binding2 != null && (editText2 = binding2.serialNumber) != null) {
            editText2.removeTextChangedListener(this.serialNumberTextWatcher);
        }
        FragmentSubscriptionBluetoothBinding binding3 = getBinding();
        if (binding3 == null || (editText = binding3.serialNumber) == null) {
            return;
        }
        editText.addTextChangedListener(this.serialNumberTextWatcher);
    }

    private final void showSubscriptionViaSnCameraDialog() {
        View root;
        cancelSubscriptionViaSnCameraDialog();
        FragmentSubscriptionBluetoothBinding binding = getBinding();
        if (binding == null || (root = binding.getRoot()) == null) {
            return;
        }
        root.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.settings.subscription.SubscriptionBluetoothFragment$$ExternalSyntheticLambda2
            @Override // java.lang.Runnable
            public final void run() {
                SubscriptionBluetoothFragment.showSubscriptionViaSnCameraDialog$lambda$2(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void showSubscriptionViaSnCameraDialog$lambda$2(SubscriptionBluetoothFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SubscriptionViaSnCameraDialog subscriptionViaSnCameraDialogNewInstance = SubscriptionViaSnCameraDialog.INSTANCE.newInstance();
        subscriptionViaSnCameraDialogNewInstance.show(this$0.getChildFragmentManager(), "SubscriptionViaSnCameraDialog");
        this$0.subscriptionViaSnCameraDialog = subscriptionViaSnCameraDialogNewInstance;
    }

    private final void cancelSubscriptionViaSnCameraDialog() {
        View root;
        FragmentSubscriptionBluetoothBinding binding = getBinding();
        if (binding == null || (root = binding.getRoot()) == null) {
            return;
        }
        root.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui.settings.subscription.SubscriptionBluetoothFragment$$ExternalSyntheticLambda1
            @Override // java.lang.Runnable
            public final void run() {
                SubscriptionBluetoothFragment.cancelSubscriptionViaSnCameraDialog$lambda$3(this.f$0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cancelSubscriptionViaSnCameraDialog$lambda$3(SubscriptionBluetoothFragment this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        SubscriptionViaSnCameraDialog subscriptionViaSnCameraDialog = this$0.subscriptionViaSnCameraDialog;
        if (subscriptionViaSnCameraDialog != null && subscriptionViaSnCameraDialog.isStateSaved()) {
            SubscriptionViaSnCameraDialog subscriptionViaSnCameraDialog2 = this$0.subscriptionViaSnCameraDialog;
            if (subscriptionViaSnCameraDialog2 != null) {
                subscriptionViaSnCameraDialog2.dismissAllowingStateLoss();
            }
        } else {
            SubscriptionViaSnCameraDialog subscriptionViaSnCameraDialog3 = this$0.subscriptionViaSnCameraDialog;
            if (subscriptionViaSnCameraDialog3 != null) {
                subscriptionViaSnCameraDialog3.dismiss();
            }
        }
        this$0.subscriptionViaSnCameraDialog = null;
    }

    public final void snSubscription() {
        EditText editText;
        Editable text;
        CharSequence charSequenceTrim;
        FragmentSubscriptionBluetoothBinding binding = getBinding();
        String string = (binding == null || (editText = binding.serialNumber) == null || (text = editText.getText()) == null || (charSequenceTrim = StringsKt.trim(text)) == null) ? null : charSequenceTrim.toString();
        String str = string;
        if (str == null || str.length() == 0) {
            return;
        }
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new AnonymousClass1(string, null), 3, null);
    }

    /* compiled from: SubscriptionBluetoothFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.subscription.SubscriptionBluetoothFragment$snSubscription$1", f = "SubscriptionBluetoothFragment.kt", i = {}, l = {192}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.subscription.SubscriptionBluetoothFragment$snSubscription$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $serialNumber;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$serialNumber = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SubscriptionBluetoothFragment.this.new AnonymousClass1(this.$serialNumber, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            JwtApiBaseData.SysResponseMessage sysMsg;
            JwtApiBaseData.SysResponseMessage sysMsg2;
            JwtApiBaseData.SysResponseMessage sysMsg3;
            JwtApiBaseData.SysResponseMessage sysMsg4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        SubscriptionBluetoothFragment.this.showLoading();
                        this.label = 1;
                        obj = JwtDyacoApiKt.callSnSubscription(new SnSubscriptionApiData.RequestBody(this.$serialNumber), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    SnSubscriptionApiData.ResponseData responseData = (SnSubscriptionApiData.ResponseData) ((Response) obj).body();
                    String message = null;
                    String code = (responseData == null || (sysMsg4 = responseData.getSysMsg()) == null) ? null : sysMsg4.getCode();
                    if (!Intrinsics.areEqual((responseData == null || (sysMsg3 = responseData.getSysMsg()) == null) ? null : sysMsg3.getCode(), JwtErrorCode.JWT_SUCCESS_1.getId())) {
                        String code2 = (responseData == null || (sysMsg2 = responseData.getSysMsg()) == null) ? null : sysMsg2.getCode();
                        if (SubscriptionBluetoothFragment.this.shouldIgnoreError(code2)) {
                            return Unit.INSTANCE;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(JwtErrorCode.JWT_INVALID_PARAMETER_102.getId(), Boxing.boxInt(R.string.error_jwt_102)), TuplesKt.to(JwtErrorCode.JWT_ERROR_1502.getId(), Boxing.boxInt(R.string.error_jwt_1502)), TuplesKt.to(JwtErrorCode.JWT_ERROR_1503.getId(), Boxing.boxInt(R.string.error_jwt_1503)), TuplesKt.to(JwtErrorCode.JWT_ERROR_1510.getId(), Boxing.boxInt(R.string.error_jwt_1510))).get(code);
                        if (num != null) {
                            SubscriptionBluetoothFragment subscriptionBluetoothFragment = SubscriptionBluetoothFragment.this;
                            CustomDialogKt.showCustomDialog$default(subscriptionBluetoothFragment, subscriptionBluetoothFragment.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                        } else {
                            SubscriptionBluetoothFragment subscriptionBluetoothFragment2 = SubscriptionBluetoothFragment.this;
                            if (responseData != null && (sysMsg = responseData.getSysMsg()) != null) {
                                message = sysMsg.getMessage();
                            }
                            BaseFragment.handleUndefinedError$default(subscriptionBluetoothFragment2, "snSubscription", code2, message, false, 8, null);
                        }
                    } else {
                        Global.INSTANCE.setSubscription(true);
                        BaseFragment.safeNavigateWithPopUp$default(SubscriptionBluetoothFragment.this, R.id.userSubscriptionFragment, R.id.settingsMainFragment, false, null, 8, null);
                    }
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message2 = e.getMessage();
                    if (message2 == null) {
                        message2 = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(SubscriptionBluetoothFragment.this, "snSubscription", message2, false, 4, null);
                }
                SubscriptionBluetoothFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                SubscriptionBluetoothFragment.this.stopLoading();
            }
        }
    }

    /* compiled from: SubscriptionBluetoothFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.settings.subscription.SubscriptionBluetoothFragment$snSubscriptionByName$1", f = "SubscriptionBluetoothFragment.kt", i = {}, l = {255}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.settings.subscription.SubscriptionBluetoothFragment$snSubscriptionByName$1, reason: invalid class name and case insensitive filesystem */
    static final class C10161 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $name;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C10161(String str, Continuation<? super C10161> continuation) {
            super(2, continuation);
            this.$name = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SubscriptionBluetoothFragment.this.new C10161(this.$name, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C10161) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            JwtApiBaseData.SysResponseMessage sysMsg;
            JwtApiBaseData.SysResponseMessage sysMsg2;
            JwtApiBaseData.SysResponseMessage sysMsg3;
            JwtApiBaseData.SysResponseMessage sysMsg4;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                try {
                    if (i == 0) {
                        ResultKt.throwOnFailure(obj);
                        SubscriptionBluetoothFragment.this.showLoading();
                        this.label = 1;
                        obj = JwtDyacoApiKt.callBluetoothSubscription(new BluetoothSubscriptionApiData.RequestBody(this.$name), this);
                        if (obj == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        if (i != 1) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                    }
                    BluetoothSubscriptionApiData.ResponseData responseData = (BluetoothSubscriptionApiData.ResponseData) ((Response) obj).body();
                    String message = null;
                    String code = (responseData == null || (sysMsg4 = responseData.getSysMsg()) == null) ? null : sysMsg4.getCode();
                    if (!Intrinsics.areEqual((responseData == null || (sysMsg3 = responseData.getSysMsg()) == null) ? null : sysMsg3.getCode(), JwtErrorCode.JWT_SUCCESS_1.getId())) {
                        String code2 = (responseData == null || (sysMsg2 = responseData.getSysMsg()) == null) ? null : sysMsg2.getCode();
                        if (SubscriptionBluetoothFragment.this.shouldIgnoreError(code2)) {
                            return Unit.INSTANCE;
                        }
                        Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(JwtErrorCode.JWT_ERROR_1501.getId(), Boxing.boxInt(R.string.error_jwt_1501))).get(code);
                        if (num != null) {
                            SubscriptionBluetoothFragment subscriptionBluetoothFragment = SubscriptionBluetoothFragment.this;
                            CustomDialogKt.showCustomDialog$default(subscriptionBluetoothFragment, subscriptionBluetoothFragment.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                        } else {
                            SubscriptionBluetoothFragment subscriptionBluetoothFragment2 = SubscriptionBluetoothFragment.this;
                            if (responseData != null && (sysMsg = responseData.getSysMsg()) != null) {
                                message = sysMsg.getMessage();
                            }
                            BaseFragment.handleUndefinedError$default(subscriptionBluetoothFragment2, "snSubscriptionByName", code2, message, false, 8, null);
                        }
                    } else {
                        Global.INSTANCE.setSubscription(true);
                        BaseFragment.safeNavigateWithPopUp$default(SubscriptionBluetoothFragment.this, R.id.userSubscriptionFragment, R.id.settingsMainFragment, false, null, 8, null);
                    }
                } catch (Exception e) {
                    Timber.INSTANCE.e(e);
                    String message2 = e.getMessage();
                    if (message2 == null) {
                        message2 = e.getClass().getSimpleName();
                    }
                    BaseFragment.handleApiError$default(SubscriptionBluetoothFragment.this, "snSubscriptionByName", message2, false, 4, null);
                }
                SubscriptionBluetoothFragment.this.stopLoading();
                return Unit.INSTANCE;
            } finally {
                SubscriptionBluetoothFragment.this.stopLoading();
            }
        }
    }

    public final void snSubscriptionByName(String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        LifecycleOwner viewLifecycleOwner = getViewLifecycleOwner();
        Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new C10161(name, null), 3, null);
    }
}
