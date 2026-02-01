package com.soletreadmills.sole_v2.ui._shared;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.util.TypedValue;
import android.view.Window;
import androidx.appcompat.app.AlertDialog;
import androidx.core.content.ContextCompat;
import com.android.SdkConstants;
import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.soletreadmills.sole_v2.R;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LoadingDialog.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\b\u001a\u00020\tJ\u000e\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\fR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/soletreadmills/sole_v2/ui/_shared/LoadingDialog;", "", "ms", "", "(J)V", "alertDialog", "Landroidx/appcompat/app/AlertDialog;", "dialogDismissDelay", "dismiss", "", "show", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LoadingDialog {
    public static final int $stable = 8;
    private AlertDialog alertDialog;
    private final long dialogDismissDelay;

    public LoadingDialog() {
        this(0L, 1, null);
    }

    public LoadingDialog(long j) {
        this.dialogDismissDelay = j;
    }

    public /* synthetic */ LoadingDialog(long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 60000L : j);
    }

    public final void show(Context context) {
        Window window;
        Intrinsics.checkNotNullParameter(context, "context");
        MaterialAlertDialogBuilder background = new MaterialAlertDialogBuilder(context, R.style.Theme_MyApp).setBackground(ContextCompat.getDrawable(context, R.drawable.bg_corner18_white));
        Intrinsics.checkNotNullExpressionValue(background, "setBackground(...)");
        background.setView(R.layout.shared_process_bar);
        background.setCancelable(false);
        AlertDialog alertDialogCreate = background.create();
        this.alertDialog = alertDialogCreate;
        if (alertDialogCreate != null) {
            alertDialogCreate.show();
        }
        int iApplyDimension = (int) TypedValue.applyDimension(1, 200, context.getResources().getDisplayMetrics());
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null && (window = alertDialog.getWindow()) != null) {
            window.setLayout(iApplyDimension, -2);
        }
        new Handler(Looper.getMainLooper()).postDelayed(new Runnable() { // from class: com.soletreadmills.sole_v2.ui._shared.LoadingDialog$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                LoadingDialog.show$lambda$0(this.f$0);
            }
        }, this.dialogDismissDelay);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void show$lambda$0(LoadingDialog this$0) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        AlertDialog alertDialog = this$0.alertDialog;
        if (alertDialog != null) {
            alertDialog.dismiss();
        }
    }

    public final void dismiss() {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            alertDialog.dismiss();
        }
        this.alertDialog = null;
    }
}
