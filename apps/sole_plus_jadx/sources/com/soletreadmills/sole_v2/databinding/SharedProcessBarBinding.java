package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.widget.ContentLoadingProgressBar;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class SharedProcessBarBinding extends ViewDataBinding {
    public final ContentLoadingProgressBar progressBar;
    public final LinearLayout shareLoadingView;

    protected SharedProcessBarBinding(Object _bindingComponent, View _root, int _localFieldCount, ContentLoadingProgressBar progressBar, LinearLayout shareLoadingView) {
        super(_bindingComponent, _root, _localFieldCount);
        this.progressBar = progressBar;
        this.shareLoadingView = shareLoadingView;
    }

    public static SharedProcessBarBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SharedProcessBarBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (SharedProcessBarBinding) ViewDataBinding.inflateInternal(inflater, R.layout.shared_process_bar, root, attachToRoot, component);
    }

    public static SharedProcessBarBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SharedProcessBarBinding inflate(LayoutInflater inflater, Object component) {
        return (SharedProcessBarBinding) ViewDataBinding.inflateInternal(inflater, R.layout.shared_process_bar, null, false, component);
    }

    public static SharedProcessBarBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static SharedProcessBarBinding bind(View view, Object component) {
        return (SharedProcessBarBinding) bind(component, view, R.layout.shared_process_bar);
    }
}
