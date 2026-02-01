package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterIosAlertActionSheetDialogBinding extends ViewDataBinding {
    public final TextView item;

    protected AdapterIosAlertActionSheetDialogBinding(Object _bindingComponent, View _root, int _localFieldCount, TextView item) {
        super(_bindingComponent, _root, _localFieldCount);
        this.item = item;
    }

    public static AdapterIosAlertActionSheetDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterIosAlertActionSheetDialogBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterIosAlertActionSheetDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_ios_alert_action_sheet_dialog, root, attachToRoot, component);
    }

    public static AdapterIosAlertActionSheetDialogBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterIosAlertActionSheetDialogBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterIosAlertActionSheetDialogBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_ios_alert_action_sheet_dialog, null, false, component);
    }

    public static AdapterIosAlertActionSheetDialogBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterIosAlertActionSheetDialogBinding bind(View view, Object component) {
        return (AdapterIosAlertActionSheetDialogBinding) bind(component, view, R.layout.adapter_ios_alert_action_sheet_dialog);
    }
}
