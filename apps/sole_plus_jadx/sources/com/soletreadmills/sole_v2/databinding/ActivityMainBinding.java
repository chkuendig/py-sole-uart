package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.fragment.app.FragmentContainerView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class ActivityMainBinding extends ViewDataBinding {
    public final RelativeLayout addViewLayout;
    public final BottomNavigationView bottomNavigation;
    public final ConstraintLayout main;
    public final FragmentContainerView navHostFragment;

    protected ActivityMainBinding(Object _bindingComponent, View _root, int _localFieldCount, RelativeLayout addViewLayout, BottomNavigationView bottomNavigation, ConstraintLayout main, FragmentContainerView navHostFragment) {
        super(_bindingComponent, _root, _localFieldCount);
        this.addViewLayout = addViewLayout;
        this.bottomNavigation = bottomNavigation;
        this.main = main;
        this.navHostFragment = navHostFragment;
    }

    public static ActivityMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (ActivityMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_main, root, attachToRoot, component);
    }

    public static ActivityMainBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding inflate(LayoutInflater inflater, Object component) {
        return (ActivityMainBinding) ViewDataBinding.inflateInternal(inflater, R.layout.activity_main, null, false, component);
    }

    public static ActivityMainBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static ActivityMainBinding bind(View view, Object component) {
        return (ActivityMainBinding) bind(component, view, R.layout.activity_main);
    }
}
