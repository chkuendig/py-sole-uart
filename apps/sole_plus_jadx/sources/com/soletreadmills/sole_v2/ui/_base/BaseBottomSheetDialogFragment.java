package com.soletreadmills.sole_v2.ui._base;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentViewModelLazyKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStore;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.viewbinding.ViewBinding;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.soletreadmills.sole_v2.AppConfig;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._extension.CustomDialogKt;
import com.soletreadmills.sole_v2.ui.MainActivity;
import com.soletreadmills.sole_v2.ui._shared.LoadingDialog;
import com.soletreadmills.sole_v2.ui._shared.UiStateViewModel;
import kotlin.Lazy;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import timber.log.Timber;

/* compiled from: BaseBottomSheetDialogFragment.kt */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b'\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0005¢\u0006\u0002\u0010\u0004J\r\u0010\u0019\u001a\u00028\u0000H$¢\u0006\u0002\u0010\tJ$\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0004J0\u0010!\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001d2\b\u0010\"\u001a\u0004\u0018\u00010\u001d2\n\b\u0002\u0010#\u001a\u0004\u0018\u00010\u001d2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0004J\b\u0010$\u001a\u00020\u001bH&J\b\u0010%\u001a\u00020\u001bH\u0002J&\u0010&\u001a\u0004\u0018\u00010'2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\b\u0010.\u001a\u00020\u001bH\u0016J\u001a\u0010/\u001a\u00020\u001b2\u0006\u00100\u001a\u00020'2\b\u0010,\u001a\u0004\u0018\u00010-H\u0016J\u0012\u00101\u001a\u00020 2\b\u0010\"\u001a\u0004\u0018\u00010\u001dH\u0004J\u0006\u00102\u001a\u00020\u001bJ\u0006\u00103\u001a\u00020\u001bR\u0012\u0010\u0005\u001a\u0004\u0018\u00018\u0000X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00028\u00008DX\u0084\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001b\u0010\u0013\u001a\u00020\u00148DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u00064"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/_base/BaseBottomSheetDialogFragment;", "VB", "Landroidx/viewbinding/ViewBinding;", "Lcom/google/android/material/bottomsheet/BottomSheetDialogFragment;", "()V", "_binding", "Landroidx/viewbinding/ViewBinding;", "binding", "getBinding", "()Landroidx/viewbinding/ViewBinding;", "loadingCount", "", "loadingDialog", "Lcom/soletreadmills/sole_v2/ui/_shared/LoadingDialog;", "<set-?>", "Lcom/soletreadmills/sole_v2/ui/MainActivity;", "mainActivity", "getMainActivity", "()Lcom/soletreadmills/sole_v2/ui/MainActivity;", "uiViewModel", "Lcom/soletreadmills/sole_v2/ui/_shared/UiStateViewModel;", "getUiViewModel", "()Lcom/soletreadmills/sole_v2/ui/_shared/UiStateViewModel;", "uiViewModel$delegate", "Lkotlin/Lazy;", "getViewBinding", "handleApiError", "", "apiName", "", "exception", "showDialog", "", "handleUndefinedError", "errorCode", "errorMsg", "initViews", "observeLoading", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "savedInstanceState", "Landroid/os/Bundle;", "onDestroyView", "onViewCreated", "view", "shouldIgnoreError", "showLoading", "stopLoading", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public abstract class BaseBottomSheetDialogFragment<VB extends ViewBinding> extends BottomSheetDialogFragment {
    public static final int $stable = 8;
    private VB _binding;
    private int loadingCount;
    private LoadingDialog loadingDialog;
    private MainActivity mainActivity;

    /* renamed from: uiViewModel$delegate, reason: from kotlin metadata */
    private final Lazy uiViewModel;

    protected abstract VB getViewBinding();

    public abstract void initViews();

    public BaseBottomSheetDialogFragment() {
        final BaseBottomSheetDialogFragment<VB> baseBottomSheetDialogFragment = this;
        final Function0 function0 = null;
        this.uiViewModel = FragmentViewModelLazyKt.createViewModelLazy(baseBottomSheetDialogFragment, Reflection.getOrCreateKotlinClass(UiStateViewModel.class), new Function0<ViewModelStore>() { // from class: com.soletreadmills.sole_v2.ui._base.BaseBottomSheetDialogFragment$special$$inlined$activityViewModels$default$1
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelStore invoke() {
                ViewModelStore viewModelStore = baseBottomSheetDialogFragment.requireActivity().getViewModelStore();
                Intrinsics.checkNotNullExpressionValue(viewModelStore, "requireActivity().viewModelStore");
                return viewModelStore;
            }
        }, new Function0<CreationExtras>() { // from class: com.soletreadmills.sole_v2.ui._base.BaseBottomSheetDialogFragment$special$$inlined$activityViewModels$default$2
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
                CreationExtras defaultViewModelCreationExtras = baseBottomSheetDialogFragment.requireActivity().getDefaultViewModelCreationExtras();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelCreationExtras, "requireActivity().defaultViewModelCreationExtras");
                return defaultViewModelCreationExtras;
            }
        }, new Function0<ViewModelProvider.Factory>() { // from class: com.soletreadmills.sole_v2.ui._base.BaseBottomSheetDialogFragment$special$$inlined$activityViewModels$default$3
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final ViewModelProvider.Factory invoke() {
                ViewModelProvider.Factory defaultViewModelProviderFactory = baseBottomSheetDialogFragment.requireActivity().getDefaultViewModelProviderFactory();
                Intrinsics.checkNotNullExpressionValue(defaultViewModelProviderFactory, "requireActivity().defaultViewModelProviderFactory");
                return defaultViewModelProviderFactory;
            }
        });
    }

    protected final UiStateViewModel getUiViewModel() {
        return (UiStateViewModel) this.uiViewModel.getValue();
    }

    public final MainActivity getMainActivity() {
        return this.mainActivity;
    }

    protected final VB getBinding() {
        VB vb = this._binding;
        Intrinsics.checkNotNull(vb);
        return vb;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        this.mainActivity = (MainActivity) getActivity();
        observeLoading();
    }

    protected final boolean shouldIgnoreError(String errorCode) {
        return CollectionsKt.contains(AppConfig.INSTANCE.getIGNORED_ERROR_CODES(), errorCode);
    }

    public static /* synthetic */ void handleApiError$default(BaseBottomSheetDialogFragment baseBottomSheetDialogFragment, String str, String str2, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleApiError");
        }
        if ((i & 4) != 0) {
            z = true;
        }
        baseBottomSheetDialogFragment.handleApiError(str, str2, z);
    }

    protected final void handleApiError(String apiName, String exception, boolean showDialog) {
        FragmentActivity activity;
        View view;
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Timber.INSTANCE.e("API Exception - Name: " + apiName + ", Exception: " + exception, new Object[0]);
        MainActivity mainActivity = this.mainActivity;
        if (mainActivity != null) {
            MainActivity.logErrorUpload$default(mainActivity, apiName, "Exception", null, exception, 4, null);
        }
        if (!showDialog || (activity = getActivity()) == null || (view = getView()) == null || !isAdded() || isDetached()) {
            return;
        }
        final String string = activity.getString(R.string.err_network_service_not_available);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        final String string2 = activity.getString(R.string.confirm);
        Intrinsics.checkNotNullExpressionValue(string2, "getString(...)");
        view.post(new Runnable() { // from class: com.soletreadmills.sole_v2.ui._base.BaseBottomSheetDialogFragment$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                BaseBottomSheetDialogFragment.handleApiError$lambda$0(this.f$0, string, string2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void handleApiError$lambda$0(BaseBottomSheetDialogFragment this$0, String errorMessage, String confirmText) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Intrinsics.checkNotNullParameter(errorMessage, "$errorMessage");
        Intrinsics.checkNotNullParameter(confirmText, "$confirmText");
        FragmentActivity activity = this$0.getActivity();
        if (activity == null || !this$0.isAdded() || this$0.isDetached() || this$0.getParentFragmentManager().isStateSaved() || activity.isFinishing() || activity.isDestroyed()) {
            return;
        }
        CustomDialogKt.showCustomDialog$default(this$0, "", errorMessage, confirmText, null, null, null, false, 112, null);
    }

    public static /* synthetic */ void handleUndefinedError$default(BaseBottomSheetDialogFragment baseBottomSheetDialogFragment, String str, String str2, String str3, boolean z, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: handleUndefinedError");
        }
        if ((i & 4) != 0) {
            str3 = null;
        }
        if ((i & 8) != 0) {
            z = true;
        }
        baseBottomSheetDialogFragment.handleUndefinedError(str, str2, str3, z);
    }

    protected final void handleUndefinedError(String apiName, String errorCode, String errorMsg, boolean showDialog) {
        Intrinsics.checkNotNullParameter(apiName, "apiName");
        Timber.INSTANCE.e("API Undefined Error - Name: " + apiName + ", Code: " + errorCode + ", Msg: " + errorMsg, new Object[0]);
        MainActivity mainActivity = this.mainActivity;
        if (mainActivity != null) {
            mainActivity.logErrorUpload(apiName, "UndefinedErrorCode", errorCode, errorMsg);
        }
        if (isAdded() && getContext() != null && showDialog) {
            CustomDialogKt.showCustomDialog$default(this, "", getString(R.string.err_network_exception) + " (" + errorCode + ')', getString(R.string.confirm), null, null, null, false, 112, null);
        }
    }

    public final void showLoading() {
        Context context;
        if (!isAdded() || getView() == null || !getLifecycle().getState().isAtLeast(Lifecycle.State.RESUMED) || (context = getContext()) == null) {
            return;
        }
        int i = this.loadingCount + 1;
        this.loadingCount = i;
        if (i == 1) {
            LoadingDialog loadingDialog = new LoadingDialog(0L, 1, null);
            this.loadingDialog = loadingDialog;
            loadingDialog.show(context);
        }
    }

    public final void stopLoading() {
        int i = this.loadingCount - 1;
        this.loadingCount = i;
        if (i <= 0) {
            this.loadingCount = 0;
            LoadingDialog loadingDialog = this.loadingDialog;
            if (loadingDialog != null) {
                loadingDialog.dismiss();
            }
        }
    }

    private final void observeLoading() {
        getUiViewModel().getLoadingState().observe(getViewLifecycleOwner(), new BaseBottomSheetDialogFragment$sam$androidx_lifecycle_Observer$0(new Function1<Boolean, Unit>(this) { // from class: com.soletreadmills.sole_v2.ui._base.BaseBottomSheetDialogFragment.observeLoading.1
            final /* synthetic */ BaseBottomSheetDialogFragment<VB> this$0;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
                this.this$0 = this;
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(Boolean bool) {
                invoke2(bool);
                return Unit.INSTANCE;
            }

            /* renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(Boolean bool) {
                Intrinsics.checkNotNull(bool);
                if (bool.booleanValue()) {
                    this.this$0.showLoading();
                } else {
                    this.this$0.stopLoading();
                }
            }
        }));
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onDestroyView() {
        super.onDestroyView();
        LoadingDialog loadingDialog = this.loadingDialog;
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
        this.loadingDialog = null;
        this.loadingCount = 0;
        this._binding = null;
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        this._binding = (VB) getViewBinding();
        return getBinding().getRoot();
    }
}
