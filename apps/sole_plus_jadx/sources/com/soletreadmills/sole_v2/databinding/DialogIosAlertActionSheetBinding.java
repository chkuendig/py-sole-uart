package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class DialogIosAlertActionSheetBinding extends ViewDataBinding {
    public final CardView cancel;
    public final RecyclerView list;

    protected DialogIosAlertActionSheetBinding(Object _bindingComponent, View _root, int _localFieldCount, CardView cancel, RecyclerView list) {
        super(_bindingComponent, _root, _localFieldCount);
        this.cancel = cancel;
        this.list = list;
    }

    public static DialogIosAlertActionSheetBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogIosAlertActionSheetBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (DialogIosAlertActionSheetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_ios_alert_action_sheet, root, attachToRoot, component);
    }

    public static DialogIosAlertActionSheetBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogIosAlertActionSheetBinding inflate(LayoutInflater inflater, Object component) {
        return (DialogIosAlertActionSheetBinding) ViewDataBinding.inflateInternal(inflater, R.layout.dialog_ios_alert_action_sheet, null, false, component);
    }

    public static DialogIosAlertActionSheetBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static DialogIosAlertActionSheetBinding bind(View view, Object component) {
        return (DialogIosAlertActionSheetBinding) bind(component, view, R.layout.dialog_ios_alert_action_sheet);
    }
}
