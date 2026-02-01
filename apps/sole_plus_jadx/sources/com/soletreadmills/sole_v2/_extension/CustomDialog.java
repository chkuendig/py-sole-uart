package com.soletreadmills.sole_v2._extension;

import android.app.Dialog;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentManager;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._manager.CustomDialogManager;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: CustomDialog.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J$\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u0011\u001a\u00020\u0005H\u0016J\b\u0010\u0012\u001a\u00020\u0005H\u0016J\u001a\u0010\u0013\u001a\u00020\u00052\u0006\u0010\u0014\u001a\u00020\f2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u000e\u0010\u0015\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0017R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0019"}, d2 = {"Lcom/soletreadmills/sole_v2/_extension/CustomDialog;", "Landroidx/fragment/app/DialogFragment;", "()V", "onCancelClick", "Lkotlin/Function0;", "", "onConfirmClick", "onCreateDialog", "Landroid/app/Dialog;", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", "container", "Landroid/view/ViewGroup;", "onDestroy", "onStart", "onViewCreated", "view", "showSafely", "fragmentManager", "Landroidx/fragment/app/FragmentManager;", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class CustomDialog extends DialogFragment {
    private static final String KEY_CANCELABLE = "cancelable";
    private static final String KEY_CANCEL_TEXT = "cancel_text";
    private static final String KEY_CONFIRM_TEXT = "confirm_text";
    private static final String KEY_MESSAGE = "message";
    private static final String KEY_TITLE = "title";
    public static final String TAG = "CustomDialogFragment";
    private Function0<Unit> onCancelClick;
    private Function0<Unit> onConfirmClick;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: CustomDialog.kt */
    @Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002Jd\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00042\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u00042\u0010\b\u0002\u0010\u0010\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\u0010\b\u0002\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0012\u0018\u00010\u00112\b\b\u0002\u0010\u0014\u001a\u00020\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/soletreadmills/sole_v2/_extension/CustomDialog$Companion;", "", "()V", "KEY_CANCELABLE", "", "KEY_CANCEL_TEXT", "KEY_CONFIRM_TEXT", "KEY_MESSAGE", "KEY_TITLE", "TAG", "newInstance", "Lcom/soletreadmills/sole_v2/_extension/CustomDialog;", "title", "message", "confirmText", "cancelText", "onConfirm", "Lkotlin/Function0;", "", "onCancel", CustomDialog.KEY_CANCELABLE, "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ CustomDialog newInstance$default(Companion companion, String str, String str2, String str3, String str4, Function0 function0, Function0 function02, boolean z, int i, Object obj) {
            if ((i & 1) != 0) {
                str = null;
            }
            if ((i & 2) != 0) {
                str2 = null;
            }
            if ((i & 4) != 0) {
                str3 = null;
            }
            if ((i & 8) != 0) {
                str4 = null;
            }
            if ((i & 16) != 0) {
                function0 = null;
            }
            if ((i & 32) != 0) {
                function02 = null;
            }
            if ((i & 64) != 0) {
                z = true;
            }
            return companion.newInstance(str, str2, str3, str4, function0, function02, z);
        }

        public final CustomDialog newInstance(String title, String message, String confirmText, String cancelText, Function0<Unit> onConfirm, Function0<Unit> onCancel, boolean cancelable) {
            CustomDialog customDialog = new CustomDialog();
            Bundle bundle = new Bundle();
            bundle.putString("title", title);
            bundle.putString("message", message);
            bundle.putString(CustomDialog.KEY_CONFIRM_TEXT, confirmText);
            bundle.putString(CustomDialog.KEY_CANCEL_TEXT, cancelText);
            bundle.putBoolean(CustomDialog.KEY_CANCELABLE, cancelable);
            customDialog.setArguments(bundle);
            customDialog.onConfirmClick = onConfirm;
            customDialog.onCancelClick = onCancel;
            return customDialog;
        }
    }

    @Override // androidx.fragment.app.DialogFragment
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        Dialog dialogOnCreateDialog = super.onCreateDialog(savedInstanceState);
        Intrinsics.checkNotNullExpressionValue(dialogOnCreateDialog, "onCreateDialog(...)");
        Window window = dialogOnCreateDialog.getWindow();
        if (window != null) {
            window.requestFeature(1);
        }
        return dialogOnCreateDialog;
    }

    @Override // androidx.fragment.app.DialogFragment, androidx.fragment.app.Fragment
    public void onStart() {
        Window window;
        super.onStart();
        Dialog dialog = getDialog();
        if (dialog == null || (window = dialog.getWindow()) == null) {
            return;
        }
        window.setBackgroundDrawable(new ColorDrawable(0));
        window.setLayout(getResources().getDisplayMetrics().widthPixels - (((int) (48 * getResources().getDisplayMetrics().density)) * 2), -2);
    }

    @Override // androidx.fragment.app.Fragment
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(inflater, "inflater");
        View viewInflate = inflater.inflate(R.layout.view_dialog_v3, container, false);
        Intrinsics.checkNotNullExpressionValue(viewInflate, "inflate(...)");
        return viewInflate;
    }

    @Override // androidx.fragment.app.Fragment
    public void onViewCreated(View view, Bundle savedInstanceState) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, savedInstanceState);
        TextView textView = (TextView) view.findViewById(R.id.tv_dialog_title);
        TextView textView2 = (TextView) view.findViewById(R.id.tv_dialog_message);
        Button button = (Button) view.findViewById(R.id.btn_confirm);
        Button button2 = (Button) view.findViewById(R.id.btn_cancel);
        View viewFindViewById = view.findViewById(R.id.btn_cancel_top_line);
        View viewFindViewById2 = view.findViewById(R.id.btn_confirm_top_line);
        Bundle arguments = getArguments();
        String string = arguments != null ? arguments.getString("title") : null;
        if (string == null) {
            string = "";
        }
        Bundle arguments2 = getArguments();
        String string2 = arguments2 != null ? arguments2.getString("message") : null;
        String str = string2 != null ? string2 : "";
        Bundle arguments3 = getArguments();
        String string3 = arguments3 != null ? arguments3.getString(KEY_CONFIRM_TEXT) : null;
        Bundle arguments4 = getArguments();
        String string4 = arguments4 != null ? arguments4.getString(KEY_CANCEL_TEXT) : null;
        String str2 = string;
        textView.setText(str2);
        String str3 = str;
        textView2.setText(str3);
        button.setText(string3);
        button2.setText(string4);
        textView.setVisibility(str2.length() > 0 ? 0 : 8);
        textView2.setVisibility(str3.length() > 0 ? 0 : 8);
        button.setVisibility(string3 != null ? 0 : 8);
        button2.setVisibility(string4 == null ? 8 : 0);
        viewFindViewById2.setVisibility(button.getVisibility());
        viewFindViewById.setVisibility(button2.getVisibility());
        Bundle arguments5 = getArguments();
        boolean z = arguments5 != null ? arguments5.getBoolean(KEY_CANCELABLE, true) : true;
        Dialog dialog = getDialog();
        if (dialog != null) {
            dialog.setCancelable(z);
        }
        button.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2._extension.CustomDialog$$ExternalSyntheticLambda0
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CustomDialog.onViewCreated$lambda$1(this.f$0, view2);
            }
        });
        button2.setOnClickListener(new View.OnClickListener() { // from class: com.soletreadmills.sole_v2._extension.CustomDialog$$ExternalSyntheticLambda1
            @Override // android.view.View.OnClickListener
            public final void onClick(View view2) {
                CustomDialog.onViewCreated$lambda$2(this.f$0, view2);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$1(CustomDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.onConfirmClick;
        if (function0 != null) {
            function0.invoke();
        }
        this$0.dismissAllowingStateLoss();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void onViewCreated$lambda$2(CustomDialog this$0, View view) {
        Intrinsics.checkNotNullParameter(this$0, "this$0");
        Function0<Unit> function0 = this$0.onCancelClick;
        if (function0 != null) {
            function0.invoke();
        }
        this$0.dismissAllowingStateLoss();
    }

    @Override // androidx.fragment.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        CustomDialogManager.INSTANCE.onDialogDestroyed$app_release(this);
    }

    public final void showSafely(FragmentManager fragmentManager) {
        Intrinsics.checkNotNullParameter(fragmentManager, "fragmentManager");
        if (fragmentManager.isStateSaved() || isAdded()) {
            return;
        }
        try {
            fragmentManager.beginTransaction().setReorderingAllowed(true).add(this, TAG).commitAllowingStateLoss();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }
    }
}
