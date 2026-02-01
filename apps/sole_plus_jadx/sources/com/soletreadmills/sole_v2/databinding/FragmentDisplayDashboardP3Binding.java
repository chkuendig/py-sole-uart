package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.ui.widget.displayDashboard.DisplayItemView;

/* loaded from: classes5.dex */
public abstract class FragmentDisplayDashboardP3Binding extends ViewDataBinding {
    public final LinearLayout chartContainer;
    public final ConstraintLayout clRainbowChart;
    public final ConstraintLayout clRainbowChartEmpty;
    public final Guideline hrSelectPosition;
    public final DisplayItemView maxHrItemView;
    public final LinearLayout selectArea;
    public final LinearLayout selectAreaBg;
    public final TextView selectAreaText;

    protected FragmentDisplayDashboardP3Binding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout chartContainer, ConstraintLayout clRainbowChart, ConstraintLayout clRainbowChartEmpty, Guideline hrSelectPosition, DisplayItemView maxHrItemView, LinearLayout selectArea, LinearLayout selectAreaBg, TextView selectAreaText) {
        super(_bindingComponent, _root, _localFieldCount);
        this.chartContainer = chartContainer;
        this.clRainbowChart = clRainbowChart;
        this.clRainbowChartEmpty = clRainbowChartEmpty;
        this.hrSelectPosition = hrSelectPosition;
        this.maxHrItemView = maxHrItemView;
        this.selectArea = selectArea;
        this.selectAreaBg = selectAreaBg;
        this.selectAreaText = selectAreaText;
    }

    public static FragmentDisplayDashboardP3Binding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDisplayDashboardP3Binding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentDisplayDashboardP3Binding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_display_dashboard_p3, root, attachToRoot, component);
    }

    public static FragmentDisplayDashboardP3Binding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDisplayDashboardP3Binding inflate(LayoutInflater inflater, Object component) {
        return (FragmentDisplayDashboardP3Binding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_display_dashboard_p3, null, false, component);
    }

    public static FragmentDisplayDashboardP3Binding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentDisplayDashboardP3Binding bind(View view, Object component) {
        return (FragmentDisplayDashboardP3Binding) bind(component, view, R.layout.fragment_display_dashboard_p3);
    }
}
