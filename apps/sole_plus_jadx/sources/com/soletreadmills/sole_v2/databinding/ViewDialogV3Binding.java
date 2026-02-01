package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public final class ViewDialogV3Binding implements ViewBinding {
    public final Button btnCancel;
    public final View btnCancelTopLine;
    public final Button btnConfirm;
    public final View btnConfirmTopLine;
    private final LinearLayout rootView;
    public final TextView tvDialogMessage;
    public final TextView tvDialogTitle;

    private ViewDialogV3Binding(LinearLayout rootView, Button btnCancel, View btnCancelTopLine, Button btnConfirm, View btnConfirmTopLine, TextView tvDialogMessage, TextView tvDialogTitle) {
        this.rootView = rootView;
        this.btnCancel = btnCancel;
        this.btnCancelTopLine = btnCancelTopLine;
        this.btnConfirm = btnConfirm;
        this.btnConfirmTopLine = btnConfirmTopLine;
        this.tvDialogMessage = tvDialogMessage;
        this.tvDialogTitle = tvDialogTitle;
    }

    @Override // androidx.viewbinding.ViewBinding
    public LinearLayout getRoot() {
        return this.rootView;
    }

    public static ViewDialogV3Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, null, false);
    }

    public static ViewDialogV3Binding inflate(LayoutInflater inflater, ViewGroup parent, boolean attachToParent) {
        View viewInflate = inflater.inflate(R.layout.view_dialog_v3, parent, false);
        if (attachToParent) {
            parent.addView(viewInflate);
        }
        return bind(viewInflate);
    }

    public static ViewDialogV3Binding bind(View rootView) {
        View viewFindChildViewById;
        View viewFindChildViewById2;
        int i = R.id.btn_cancel;
        Button button = (Button) ViewBindings.findChildViewById(rootView, i);
        if (button != null && (viewFindChildViewById = ViewBindings.findChildViewById(rootView, (i = R.id.btn_cancel_top_line))) != null) {
            i = R.id.btn_confirm;
            Button button2 = (Button) ViewBindings.findChildViewById(rootView, i);
            if (button2 != null && (viewFindChildViewById2 = ViewBindings.findChildViewById(rootView, (i = R.id.btn_confirm_top_line))) != null) {
                i = R.id.tv_dialog_message;
                TextView textView = (TextView) ViewBindings.findChildViewById(rootView, i);
                if (textView != null) {
                    i = R.id.tv_dialog_title;
                    TextView textView2 = (TextView) ViewBindings.findChildViewById(rootView, i);
                    if (textView2 != null) {
                        return new ViewDialogV3Binding((LinearLayout) rootView, button, viewFindChildViewById, button2, viewFindChildViewById2, textView, textView2);
                    }
                }
            }
        }
        throw new NullPointerException("Missing required view with ID: ".concat(rootView.getResources().getResourceName(i)));
    }
}
