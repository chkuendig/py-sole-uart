package com.soletreadmills.sole_v2._manager;

import androidx.fragment.app.FragmentManager;
import androidx.navigation.compose.DialogNavigator;
import com.soletreadmills.sole_v2._extension.CustomDialog;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomDialogManager.kt */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\u0015\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\u0004H\u0000¢\u0006\u0002\b\tJl\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000e2\n\b\u0002\u0010\u0011\u001a\u0004\u0018\u00010\u000e2\u0010\b\u0002\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00132\u0010\b\u0002\u0010\u0014\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00132\b\b\u0002\u0010\u0015\u001a\u00020\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lcom/soletreadmills/sole_v2/_manager/CustomDialogManager;", "", "()V", "currentDialog", "Lcom/soletreadmills/sole_v2/_extension/CustomDialog;", "dismiss", "", "onDialogDestroyed", DialogNavigator.NAME, "onDialogDestroyed$app_release", "show", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "title", "", "message", "confirmText", "cancelText", "onConfirm", "Lkotlin/Function0;", "onCancel", "cancelable", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CustomDialogManager {
    private static CustomDialog currentDialog;
    public static final CustomDialogManager INSTANCE = new CustomDialogManager();
    public static final int $stable = 8;

    private CustomDialogManager() {
    }

    public final void show(FragmentManager fragmentManager, String title, String message, String confirmText, String cancelText, Function0<Unit> onConfirm, Function0<Unit> onCancel, boolean cancelable) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        if (fragmentManager.isStateSaved()) {
            return;
        }
        CustomDialog customDialog = currentDialog;
        if (customDialog != null) {
            customDialog.dismissAllowingStateLoss();
        }
        currentDialog = null;
        CustomDialog customDialogNewInstance = CustomDialog.INSTANCE.newInstance(title, message, confirmText, cancelText, onConfirm, onCancel, cancelable);
        currentDialog = customDialogNewInstance;
        customDialogNewInstance.showSafely(fragmentManager);
    }

    public final void dismiss() {
        CustomDialog customDialog = currentDialog;
        if (customDialog != null) {
            customDialog.dismissAllowingStateLoss();
        }
        currentDialog = null;
    }

    public final void onDialogDestroyed$app_release(CustomDialog dialog) {
        Intrinsics.checkNotNullParameter(dialog, "dialog");
        if (currentDialog == dialog) {
            currentDialog = null;
        }
    }
}
