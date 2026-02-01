package com.soletreadmills.sole_v2.ui.pair;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.navigation.fragment.FragmentKt;
import com.android.SdkConstants;
import com.google.zxing.ResultPoint;
import com.journeyapps.barcodescanner.BarcodeCallback;
import com.journeyapps.barcodescanner.BarcodeResult;
import com.journeyapps.barcodescanner.BarcodeView;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._data.api.login.UserScanMachineQRCodeToPair;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2._network.DyacoApiKt;
import com.soletreadmills.sole_v2.databinding.FragmentQrcodeBinding;
import com.soletreadmills.sole_v2.ui._base.BaseFragment;
import java.io.IOException;
import java.util.List;
import java.util.concurrent.CancellationException;
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
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import retrofit2.Response;
import timber.log.Timber;

/* compiled from: QRCodeFragment.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u0001\"B\u0005¢\u0006\u0002\u0010\u0004J\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\tH\u0082@¢\u0006\u0002\u0010\u0010J\b\u0010\u0011\u001a\u00020\u0012H\u0002J\b\u0010\u0013\u001a\u00020\fH\u0002J\u001a\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0012H\u0002J\b\u0010\u001a\u001a\u00020\u0012H\u0016J\u0012\u0010\u001b\u001a\u00020\u00122\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0016J\b\u0010\u001e\u001a\u00020\u0012H\u0016J\b\u0010\u001f\u001a\u00020\u0012H\u0016J\b\u0010 \u001a\u00020\u0012H\u0016J\b\u0010!\u001a\u00020\u0012H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \n*\u0004\u0018\u00010\t0\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/pair/QRCodeFragment;", "Lcom/soletreadmills/sole_v2/ui/_base/BaseFragment;", "Lcom/soletreadmills/sole_v2/databinding/FragmentQrcodeBinding;", "Landroid/view/View$OnClickListener;", "()V", "apiJob", "Lkotlinx/coroutines/Job;", "cameraPermissionLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "kotlin.jvm.PlatformType", "inFlight", "", "callQrApi", "Lcom/soletreadmills/sole_v2/ui/pair/QRCodeFragment$ApiOutcome;", "qrText", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "goPrevPage", "", "hasCameraPermission", "inflateBinding", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "initScanner", "initViews", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onDestroyView", "onPause", "onResume", "requestCameraPermission", "ApiOutcome", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class QRCodeFragment extends BaseFragment<FragmentQrcodeBinding> implements View.OnClickListener {
    public static final int $stable = 8;
    private Job apiJob;
    private final ActivityResultLauncher<String> cameraPermissionLauncher;
    private boolean inFlight;

    public QRCodeFragment() {
        ActivityResultLauncher<String> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestPermission(), new ActivityResultCallback() { // from class: com.soletreadmills.sole_v2.ui.pair.QRCodeFragment$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                QRCodeFragment.cameraPermissionLauncher$lambda$0(this.f$0, ((Boolean) obj).booleanValue());
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.cameraPermissionLauncher = activityResultLauncherRegisterForActivityResult;
    }

    public static final /* synthetic */ FragmentQrcodeBinding access$getBinding(QRCodeFragment qRCodeFragment) {
        return qRCodeFragment.getBinding();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public FragmentQrcodeBinding inflateBinding(LayoutInflater inflater, ViewGroup container) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        FragmentQrcodeBinding fragmentQrcodeBindingInflate = FragmentQrcodeBinding.inflate(inflater, container, false);
        Intrinsics.checkNotNullExpressionValue(fragmentQrcodeBindingInflate, "inflate(...)");
        return fragmentQrcodeBindingInflate;
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onResume() {
        FragmentQrcodeBinding binding;
        BarcodeView barcodeView;
        super.onResume();
        if (this.inFlight || (binding = getBinding()) == null || (barcodeView = binding.barcodeView) == null) {
            return;
        }
        barcodeView.resume();
    }

    @Override // androidx.fragment.app.Fragment
    public void onPause() {
        BarcodeView barcodeView;
        FragmentQrcodeBinding binding = getBinding();
        if (binding != null && (barcodeView = binding.barcodeView) != null) {
            barcodeView.pause();
        }
        Job job = this.apiJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.inFlight = false;
        super.onPause();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        BarcodeView barcodeView;
        FragmentQrcodeBinding binding = getBinding();
        if (binding != null && (barcodeView = binding.barcodeView) != null) {
            barcodeView.pause();
        }
        Job job = this.apiJob;
        if (job != null) {
            Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
        }
        this.inFlight = false;
        super.onDestroyView();
    }

    @Override // com.soletreadmills.sole_v2.ui._base.BaseFragment
    public void initViews() {
        TextView textView;
        LinearLayout linearLayout;
        FragmentQrcodeBinding binding = getBinding();
        if (binding != null && (linearLayout = binding.layoutHelp) != null) {
            linearLayout.setOnClickListener(this);
        }
        FragmentQrcodeBinding binding2 = getBinding();
        if (binding2 != null && (textView = binding2.cancel) != null) {
            textView.setOnClickListener(this);
        }
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("fromPageName") : null;
        if (string != null) {
            Timber.INSTANCE.d("fromPageName:" + string, new Object[0]);
        }
        if (hasCameraPermission()) {
            initScanner();
        } else {
            requestCameraPermission();
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.layout_help;
        if (numValueOf != null && numValueOf.intValue() == i) {
            FragmentKt.findNavController(this).navigate(R.id.action_QRCodeFragment_to_howToLinkProfileFragment);
            return;
        }
        int i2 = R.id.cancel;
        if (numValueOf != null && numValueOf.intValue() == i2) {
            goPrevPage();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void goPrevPage() {
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("fromPageName") : null;
        if (string != null) {
            Timber.INSTANCE.d("redirectPageNameArg:" + string, new Object[0]);
            if (Intrinsics.areEqual(string, "onBoarding")) {
                BaseFragment.safeNavigateAndClearStack$default(this, R.id.homeMainFragment, null, 2, null);
                return;
            }
            return;
        }
        safeNavigateUp();
    }

    private final void initScanner() {
        BarcodeView barcodeView;
        FragmentQrcodeBinding binding = getBinding();
        if (binding == null || (barcodeView = binding.barcodeView) == null) {
            return;
        }
        barcodeView.decodeContinuous(new BarcodeCallback() { // from class: com.soletreadmills.sole_v2.ui.pair.QRCodeFragment.initScanner.1
            @Override // com.journeyapps.barcodescanner.BarcodeCallback
            public void possibleResultPoints(List<ResultPoint> resultPoints) {
            }

            @Override // com.journeyapps.barcodescanner.BarcodeCallback
            public void barcodeResult(BarcodeResult result) {
                BarcodeView barcodeView2;
                String text = result != null ? result.getText() : null;
                if (text == null || QRCodeFragment.this.inFlight) {
                    return;
                }
                QRCodeFragment.this.inFlight = true;
                FragmentQrcodeBinding fragmentQrcodeBindingAccess$getBinding = QRCodeFragment.access$getBinding(QRCodeFragment.this);
                if (fragmentQrcodeBindingAccess$getBinding != null && (barcodeView2 = fragmentQrcodeBindingAccess$getBinding.barcodeView) != null) {
                    barcodeView2.pause();
                }
                Job job = QRCodeFragment.this.apiJob;
                if (job != null) {
                    Job.DefaultImpls.cancel$default(job, (CancellationException) null, 1, (Object) null);
                }
                QRCodeFragment qRCodeFragment = QRCodeFragment.this;
                LifecycleOwner viewLifecycleOwner = qRCodeFragment.getViewLifecycleOwner();
                Intrinsics.checkNotNullExpressionValue(viewLifecycleOwner, "getViewLifecycleOwner(...)");
                qRCodeFragment.apiJob = BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(viewLifecycleOwner), null, null, new QRCodeFragment$initScanner$1$barcodeResult$1(QRCodeFragment.this, text, null), 3, null);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* compiled from: QRCodeFragment.kt */
    @Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000e\n\u0002\u0010\b\n\u0002\b\u0002\b\u0082\b\u0018\u00002\u00020\u0001B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J)\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0011\u001a\u00020\u00032\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0005HÖ\u0001R\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006\u0016"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/pair/QRCodeFragment$ApiOutcome;", "", "ok", "", "code", "", "networkDown", "(ZLjava/lang/String;Z)V", "getCode", "()Ljava/lang/String;", "getNetworkDown", "()Z", "getOk", "component1", "component2", "component3", "copy", "equals", "other", "hashCode", "", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    static final /* data */ class ApiOutcome {
        private final String code;
        private final boolean networkDown;
        private final boolean ok;

        public static /* synthetic */ ApiOutcome copy$default(ApiOutcome apiOutcome, boolean z, String str, boolean z2, int i, Object obj) {
            if ((i & 1) != 0) {
                z = apiOutcome.ok;
            }
            if ((i & 2) != 0) {
                str = apiOutcome.code;
            }
            if ((i & 4) != 0) {
                z2 = apiOutcome.networkDown;
            }
            return apiOutcome.copy(z, str, z2);
        }

        /* renamed from: component1, reason: from getter */
        public final boolean getOk() {
            return this.ok;
        }

        /* renamed from: component2, reason: from getter */
        public final String getCode() {
            return this.code;
        }

        /* renamed from: component3, reason: from getter */
        public final boolean getNetworkDown() {
            return this.networkDown;
        }

        public final ApiOutcome copy(boolean ok, String code, boolean networkDown) {
            return new ApiOutcome(ok, code, networkDown);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ApiOutcome)) {
                return false;
            }
            ApiOutcome apiOutcome = (ApiOutcome) other;
            return this.ok == apiOutcome.ok && Intrinsics.areEqual(this.code, apiOutcome.code) && this.networkDown == apiOutcome.networkDown;
        }

        public int hashCode() {
            int iHashCode = Boolean.hashCode(this.ok) * 31;
            String str = this.code;
            return ((iHashCode + (str == null ? 0 : str.hashCode())) * 31) + Boolean.hashCode(this.networkDown);
        }

        public String toString() {
            return "ApiOutcome(ok=" + this.ok + ", code=" + this.code + ", networkDown=" + this.networkDown + ')';
        }

        public ApiOutcome(boolean z, String str, boolean z2) {
            this.ok = z;
            this.code = str;
            this.networkDown = z2;
        }

        public /* synthetic */ ApiOutcome(boolean z, String str, boolean z2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(z, (i & 2) != 0 ? null : str, (i & 4) != 0 ? false : z2);
        }

        public final boolean getOk() {
            return this.ok;
        }

        public final String getCode() {
            return this.code;
        }

        public final boolean getNetworkDown() {
            return this.networkDown;
        }
    }

    /* compiled from: QRCodeFragment.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/soletreadmills/sole_v2/ui/pair/QRCodeFragment$ApiOutcome;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.pair.QRCodeFragment$callQrApi$2", f = "QRCodeFragment.kt", i = {}, l = {154, 180}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui.pair.QRCodeFragment$callQrApi$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super ApiOutcome>, Object> {
        final /* synthetic */ String $qrText;
        int label;
        final /* synthetic */ QRCodeFragment this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, QRCodeFragment qRCodeFragment, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$qrText = str;
            this.this$0 = qRCodeFragment;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$qrText, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super ApiOutcome> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            try {
                if (i == 0) {
                    ResultKt.throwOnFailure(obj);
                    Timber.INSTANCE.d("callUserScanMachineQRCodeToPair:" + this.$qrText, new Object[0]);
                    this.label = 1;
                    obj = DyacoApiKt.callUserScanMachineQRCodeToPair(new UserScanMachineQRCodeToPair.RequestBodyData(this.$qrText), this);
                    if (obj == coroutine_suspended) {
                        return coroutine_suspended;
                    }
                } else {
                    if (i != 1) {
                        if (i != 2) {
                            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                        }
                        ResultKt.throwOnFailure(obj);
                        return new ApiOutcome(false, null, false, 6, null);
                    }
                    ResultKt.throwOnFailure(obj);
                }
                Response response = (Response) obj;
                Timber.INSTANCE.d("res Body: " + response, new Object[0]);
                UserScanMachineQRCodeToPair.ResponseData responseData = (UserScanMachineQRCodeToPair.ResponseData) response.body();
                String errorCode = responseData != null ? responseData.getErrorCode() : null;
                if (responseData != null && responseData.getSuccess()) {
                    Timber.INSTANCE.d("Pair成功!", new Object[0]);
                    return new ApiOutcome(true, null, false, 6, null);
                }
                if (Intrinsics.areEqual(errorCode, ErrorCode.MISSING_REQUIRED_PARAMETER_102.getId())) {
                    return new ApiOutcome(false, null, false, 6, null);
                }
                Integer num = (Integer) MapsKt.mapOf(TuplesKt.to(ErrorCode.MACHINE_BRAND_MISMATCH_1306.getId(), Boxing.boxInt(R.string.err_1306_machine_brand_mismatch)), TuplesKt.to(ErrorCode.TARGET_SVR_ERR_NEG4.getId(), Boxing.boxInt(R.string.err_neg4_server_busy_please_try_again))).get(errorCode);
                this.label = 2;
                if (BuildersKt.withContext(Dispatchers.getMain(), new AnonymousClass1(num, this.this$0, errorCode, null), this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                return new ApiOutcome(false, null, false, 6, null);
            } catch (IOException unused) {
                return new ApiOutcome(false, null, false, 6, null);
            }
        }

        /* compiled from: QRCodeFragment.kt */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
        @DebugMetadata(c = "com.soletreadmills.sole_v2.ui.pair.QRCodeFragment$callQrApi$2$1", f = "QRCodeFragment.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        /* renamed from: com.soletreadmills.sole_v2.ui.pair.QRCodeFragment$callQrApi$2$1, reason: invalid class name */
        static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ String $errorCode;
            final /* synthetic */ Integer $msgResId;
            int label;
            final /* synthetic */ QRCodeFragment this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            AnonymousClass1(Integer num, QRCodeFragment qRCodeFragment, String str, Continuation<? super AnonymousClass1> continuation) {
                super(2, continuation);
                this.$msgResId = num;
                this.this$0 = qRCodeFragment;
                this.$errorCode = str;
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
                return new AnonymousClass1(this.$msgResId, this.this$0, this.$errorCode, continuation);
            }

            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
                return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object obj) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                Integer num = this.$msgResId;
                if (num != null) {
                    QRCodeFragment qRCodeFragment = this.this$0;
                    CustomDialogKt.showCustomDialog$default(qRCodeFragment, qRCodeFragment.getString(num.intValue()), "", null, null, null, null, false, 124, null);
                } else {
                    CustomDialogKt.showCustomDialog$default(this.this$0, "", this.this$0.getString(R.string.err_network_exception) + " (" + this.$errorCode + ')', this.this$0.getString(R.string.confirm), null, null, null, false, 112, null);
                }
                return Unit.INSTANCE;
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Object callQrApi(String str, Continuation<? super ApiOutcome> continuation) {
        return BuildersKt.withContext(Dispatchers.getIO(), new AnonymousClass2(str, this, null), continuation);
    }

    private final boolean hasCameraPermission() {
        return ContextCompat.checkSelfPermission(requireContext(), "android.permission.CAMERA") == 0;
    }

    private final void requestCameraPermission() {
        this.cameraPermissionLauncher.launch("android.permission.CAMERA");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void cameraPermissionLauncher$lambda$0(QRCodeFragment this$0, boolean z) {
        BarcodeView barcodeView;
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        if (z) {
            this$0.initScanner();
            FragmentQrcodeBinding binding = this$0.getBinding();
            if (binding == null || (barcodeView = binding.barcodeView) == null) {
                return;
            }
            barcodeView.resume();
            return;
        }
        Toast.makeText(this$0.requireContext(), "需要相機權限才能掃描", 0).show();
    }
}
