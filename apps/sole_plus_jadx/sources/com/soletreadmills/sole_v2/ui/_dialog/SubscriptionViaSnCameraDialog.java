package com.soletreadmills.sole_v2.ui._dialog;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.camera.view.LifecycleCameraController;
import androidx.camera.view.PreviewView;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.LifecycleOwnerKt;
import com.android.SdkConstants;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.mlkit.vision.text.TextRecognition;
import com.google.mlkit.vision.text.TextRecognizer;
import com.google.mlkit.vision.text.latin.TextRecognizerOptions;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2.databinding.DialogSubscriptionViaSnCameraBinding;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* compiled from: SubscriptionViaSnCameraDialog.kt */
@Metadata(d1 = {"\u0000y\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f*\u0001\u000e\b\u0007\u0018\u0000 32\u00020\u00012\u00020\u0002:\u00013B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bH\u0016J\u0012\u0010\u001c\u001a\u00020\u00192\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0016J\u0012\u0010\u001f\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\u0012\u0010\"\u001a\u00020#2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J&\u0010$\u001a\u0004\u0018\u00010\u001e2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(2\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u0010)\u001a\u00020\u0019H\u0016J\b\u0010*\u001a\u00020\u0019H\u0016J\u0010\u0010+\u001a\u00020\u00192\u0006\u0010,\u001a\u00020!H\u0016J\b\u0010-\u001a\u00020\u0019H\u0016J\b\u0010.\u001a\u00020\u0019H\u0016J\u001a\u0010/\u001a\u00020\u00192\u0006\u00100\u001a\u00020\u001e2\b\u0010 \u001a\u0004\u0018\u00010!H\u0017J\u0012\u00101\u001a\u00020\u00192\b\u0010 \u001a\u0004\u0018\u00010!H\u0016J\b\u00102\u001a\u00020\u0019H\u0003R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082.¢\u0006\u0002\n\u0000R(\u0010\b\u001a\u001c\u0012\u0018\u0012\u0016\u0012\u0004\u0012\u00020\u000b \f*\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\n0\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0013R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082.¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/_dialog/SubscriptionViaSnCameraDialog;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "Landroid/view/View$OnClickListener;", "()V", "binding", "Lcom/soletreadmills/sole_v2/databinding/DialogSubscriptionViaSnCameraBinding;", "cameraExecutor", "Ljava/util/concurrent/ExecutorService;", "checkPermissionCameraActivityResultLauncher", "Landroidx/activity/result/ActivityResultLauncher;", "", "", "kotlin.jvm.PlatformType", "imageCapturedCallback", "com/soletreadmills/sole_v2/ui/_dialog/SubscriptionViaSnCameraDialog$imageCapturedCallback$1", "Lcom/soletreadmills/sole_v2/ui/_dialog/SubscriptionViaSnCameraDialog$imageCapturedCallback$1;", "lifecycleCameraController", "Landroidx/camera/view/LifecycleCameraController;", "permissionList", "[Ljava/lang/String;", "recognizer", "Lcom/google/mlkit/vision/text/TextRecognizer;", "allPermissionsGranted", "", "onAttach", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", SdkConstants.ATTR_ON_CLICK, "v", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateDialog", "Landroid/app/Dialog;", "onCreateView", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroyView", "onDetach", "onSaveInstanceState", "outState", "onStart", "onStop", "onViewCreated", "view", "onViewStateRestored", "startCamera", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SubscriptionViaSnCameraDialog extends BottomSheetDialogFragment implements View.OnClickListener {
    public static final String KEY_RESULT = "SubscriptionViaSnCameraDialog_RESULT";
    public static final String KEY_RESULT_SN = "RESULT_SN";
    private DialogSubscriptionViaSnCameraBinding binding;
    private ExecutorService cameraExecutor;
    private final ActivityResultLauncher<String[]> checkPermissionCameraActivityResultLauncher;
    private LifecycleCameraController lifecycleCameraController;
    private TextRecognizer recognizer;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private final String[] permissionList = (String[]) CollectionsKt.mutableListOf("android.permission.CAMERA").toArray(new String[0]);
    private final SubscriptionViaSnCameraDialog$imageCapturedCallback$1 imageCapturedCallback = new SubscriptionViaSnCameraDialog$imageCapturedCallback$1(this);

    public SubscriptionViaSnCameraDialog() {
        ActivityResultLauncher<String[]> activityResultLauncherRegisterForActivityResult = registerForActivityResult(new ActivityResultContracts.RequestMultiplePermissions(), new ActivityResultCallback() { // from class: com.soletreadmills.sole_v2.ui._dialog.SubscriptionViaSnCameraDialog$$ExternalSyntheticLambda0
            @Override // androidx.activity.result.ActivityResultCallback
            public final void onActivityResult(Object obj) {
                SubscriptionViaSnCameraDialog.checkPermissionCameraActivityResultLauncher$lambda$3(this.f$0, (Map) obj);
            }
        });
        Intrinsics.checkNotNullExpressionValue(activityResultLauncherRegisterForActivityResult, "registerForActivityResult(...)");
        this.checkPermissionCameraActivityResultLauncher = activityResultLauncherRegisterForActivityResult;
    }

    /* compiled from: SubscriptionViaSnCameraDialog.kt */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0006\u001a\u00020\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/_dialog/SubscriptionViaSnCameraDialog$Companion;", "", "()V", "KEY_RESULT", "", "KEY_RESULT_SN", "newInstance", "Lcom/soletreadmills/sole_v2/ui/_dialog/SubscriptionViaSnCameraDialog;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final SubscriptionViaSnCameraDialog newInstance() {
            return new SubscriptionViaSnCameraDialog();
        }
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onAttach(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        super.onAttach(context);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(0, R.style.TransparentBottomSheetDialogTheme02);
        ExecutorService executorServiceNewSingleThreadExecutor = Executors.newSingleThreadExecutor();
        Intrinsics.checkNotNullExpressionValue(executorServiceNewSingleThreadExecutor, "newSingleThreadExecutor(...)");
        this.cameraExecutor = executorServiceNewSingleThreadExecutor;
        TextRecognizerOptions.Builder builder = new TextRecognizerOptions.Builder();
        ExecutorService executorService = this.cameraExecutor;
        if (executorService == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraExecutor");
            executorService = null;
        }
        TextRecognizer client = TextRecognition.getClient(builder.setExecutor(executorService).build());
        Intrinsics.checkNotNullExpressionValue(client, "getClient(...)");
        this.recognizer = client;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        if (this.binding == null) {
            this.binding = DialogSubscriptionViaSnCameraBinding.inflate(inflater, container, false);
        }
        DialogSubscriptionViaSnCameraBinding dialogSubscriptionViaSnCameraBinding = this.binding;
        if (dialogSubscriptionViaSnCameraBinding != null) {
            return dialogSubscriptionViaSnCameraBinding.getRoot();
        }
        return null;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        AppCompatImageView appCompatImageView;
        AppCompatImageView appCompatImageView2;
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        DialogSubscriptionViaSnCameraBinding dialogSubscriptionViaSnCameraBinding = this.binding;
        if (dialogSubscriptionViaSnCameraBinding != null && (appCompatImageView2 = dialogSubscriptionViaSnCameraBinding.close) != null) {
            appCompatImageView2.setOnClickListener(this);
        }
        DialogSubscriptionViaSnCameraBinding dialogSubscriptionViaSnCameraBinding2 = this.binding;
        if (dialogSubscriptionViaSnCameraBinding2 != null && (appCompatImageView = dialogSubscriptionViaSnCameraBinding2.scanning) != null) {
            appCompatImageView.setOnClickListener(this);
        }
        if (allPermissionsGranted()) {
            startCamera();
        } else {
            this.checkPermissionCameraActivityResultLauncher.launch(this.permissionList);
        }
    }

    @Override // com.google.android.material.bottomsheet.BottomSheetDialogFragment, androidx.appcompat.app.AppCompatDialogFragment, androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "onCreateDialog(...)");
        if (dialogOnCreateDialog instanceof BottomSheetDialog) {
            ((BottomSheetDialog) dialogOnCreateDialog).getBehavior().setState(3);
        }
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onViewStateRestored(Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        super.onStart();
        if (allPermissionsGranted()) {
            return;
        }
        this.checkPermissionCameraActivityResultLauncher.launch(this.permissionList);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onSaveInstanceState(Bundle outState) {
        Intrinsics.checkNotNullParameter(outState, "outState");
        super.onSaveInstanceState(outState);
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStop() {
        super.onStop();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        TextRecognizer textRecognizer = this.recognizer;
        ExecutorService executorService = null;
        if (textRecognizer == null) {
            Intrinsics.throwUninitializedPropertyAccessException("recognizer");
            textRecognizer = null;
        }
        textRecognizer.close();
        ExecutorService executorService2 = this.cameraExecutor;
        if (executorService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraExecutor");
        } else {
            executorService = executorService2;
        }
        executorService.shutdown();
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDetach() {
        super.onDetach();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View v) {
        LifecycleCameraController lifecycleCameraController;
        ExecutorService executorService = null;
        Integer numValueOf = v != null ? Integer.valueOf(v.getId()) : null;
        int i = R.id.close;
        if (numValueOf != null && numValueOf.intValue() == i) {
            if (isStateSaved()) {
                dismissAllowingStateLoss();
                return;
            } else {
                dismiss();
                return;
            }
        }
        int i2 = R.id.scanning;
        if (numValueOf == null || numValueOf.intValue() != i2 || (lifecycleCameraController = this.lifecycleCameraController) == null) {
            return;
        }
        BuildersKt__Builders_commonKt.launch$default(LifecycleOwnerKt.getLifecycleScope(this), Dispatchers.getMain(), null, new AnonymousClass1(null), 2, null);
        ExecutorService executorService2 = this.cameraExecutor;
        if (executorService2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("cameraExecutor");
        } else {
            executorService = executorService2;
        }
        lifecycleCameraController.takePicture(executorService, this.imageCapturedCallback);
    }

    /* compiled from: SubscriptionViaSnCameraDialog.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.ui._dialog.SubscriptionViaSnCameraDialog$onClick$1", f = "SubscriptionViaSnCameraDialog.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.ui._dialog.SubscriptionViaSnCameraDialog$onClick$1, reason: invalid class name */
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SubscriptionViaSnCameraDialog.this.new AnonymousClass1(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label == 0) {
                ResultKt.throwOnFailure(obj);
                DialogSubscriptionViaSnCameraBinding dialogSubscriptionViaSnCameraBinding = SubscriptionViaSnCameraDialog.this.binding;
                AppCompatImageView appCompatImageView = dialogSubscriptionViaSnCameraBinding != null ? dialogSubscriptionViaSnCameraBinding.scanning : null;
                if (appCompatImageView != null) {
                    appCompatImageView.setEnabled(false);
                }
                return Unit.INSTANCE;
            }
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    private final void startCamera() {
        Context context;
        PreviewView previewView;
        if (this.lifecycleCameraController == null && (context = getContext()) != null) {
            LifecycleCameraController lifecycleCameraController = new LifecycleCameraController(context);
            lifecycleCameraController.setEnabledUseCases(1);
            lifecycleCameraController.bindToLifecycle(this);
            DialogSubscriptionViaSnCameraBinding dialogSubscriptionViaSnCameraBinding = this.binding;
            if (dialogSubscriptionViaSnCameraBinding != null && (previewView = dialogSubscriptionViaSnCameraBinding.previewView) != null) {
                previewView.setController(lifecycleCameraController);
            }
            this.lifecycleCameraController = lifecycleCameraController;
            DialogSubscriptionViaSnCameraBinding dialogSubscriptionViaSnCameraBinding2 = this.binding;
            AppCompatImageView appCompatImageView = dialogSubscriptionViaSnCameraBinding2 != null ? dialogSubscriptionViaSnCameraBinding2.scanning : null;
            if (appCompatImageView == null) {
                return;
            }
            appCompatImageView.setEnabled(true);
        }
    }

    private final boolean allPermissionsGranted() {
        Context context = getContext();
        if (context == null) {
            return false;
        }
        for (String str : this.permissionList) {
            if (ContextCompat.checkSelfPermission(context, str) != 0) {
                return false;
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void checkPermissionCameraActivityResultLauncher$lambda$3(final SubscriptionViaSnCameraDialog this$0, Map result) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(result, "result");
        if (result.containsValue(false)) {
            SubscriptionViaSnCameraDialog subscriptionViaSnCameraDialog = this$0;
            Context context = this$0.getContext();
            String string = context != null ? context.getString(R.string.permission_error) : null;
            Context context2 = this$0.getContext();
            String string2 = context2 != null ? context2.getString(R.string.confirm) : null;
            Context context3 = this$0.getContext();
            CustomDialogKt.showCustomDialog$default(subscriptionViaSnCameraDialog, string, null, string2, context3 != null ? context3.getString(R.string.cancel) : null, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui._dialog.SubscriptionViaSnCameraDialog$checkPermissionCameraActivityResultLauncher$1$1
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
                    Context context4 = this.this$0.getContext();
                    if (context4 == null) {
                        return;
                    }
                    Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                    intent.setData(Uri.fromParts("package", context4.getPackageName(), null));
                    intent.addFlags(268435456);
                    this.this$0.startActivity(intent);
                }
            }, new Function0<Unit>() { // from class: com.soletreadmills.sole_v2.ui._dialog.SubscriptionViaSnCameraDialog$checkPermissionCameraActivityResultLauncher$1$2
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
                    AppCompatImageView appCompatImageView;
                    DialogSubscriptionViaSnCameraBinding dialogSubscriptionViaSnCameraBinding = this.this$0.binding;
                    if (dialogSubscriptionViaSnCameraBinding == null || (appCompatImageView = dialogSubscriptionViaSnCameraBinding.close) == null) {
                        return;
                    }
                    appCompatImageView.performClick();
                }
            }, false, 64, null);
            return;
        }
        this$0.startCamera();
    }
}
