package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.google.android.flexbox.FlexboxLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterClassesQuickPicksBinding extends ViewDataBinding {
    public final FlexboxLayout flexQuickPicks;
    public final TextView quickPicksLabel;

    protected AdapterClassesQuickPicksBinding(Object _bindingComponent, View _root, int _localFieldCount, FlexboxLayout flexQuickPicks, TextView quickPicksLabel) {
        super(_bindingComponent, _root, _localFieldCount);
        this.flexQuickPicks = flexQuickPicks;
        this.quickPicksLabel = quickPicksLabel;
    }

    public static AdapterClassesQuickPicksBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClassesQuickPicksBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterClassesQuickPicksBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_classes_quick_picks, root, attachToRoot, component);
    }

    public static AdapterClassesQuickPicksBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClassesQuickPicksBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterClassesQuickPicksBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_classes_quick_picks, null, false, component);
    }

    public static AdapterClassesQuickPicksBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterClassesQuickPicksBinding bind(View view, Object component) {
        return (AdapterClassesQuickPicksBinding) bind(component, view, R.layout.adapter_classes_quick_picks);
    }
}
