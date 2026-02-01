package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.ui.widget.MultiLayerBarChartView;

/* loaded from: classes5.dex */
public abstract class FragmentConnectEditProgramBinding extends ViewDataBinding {
    public final LinearLayout LLIncline;
    public final LinearLayout LLSpeedOrLevel;
    public final MultiLayerBarChartView barChart;
    public final RelativeLayout cancel;
    public final View lineIncline;
    public final View lineSpeedOrLevel;
    public final RecyclerView recyclerView;
    public final RecyclerView recyclerViewIncline;
    public final RelativeLayout save;
    public final View statusBarHeight;
    public final TextView title;
    public final ConstraintLayout tobBar;
    public final TextView txtIncline;
    public final TextView txtSave;
    public final TextView txtSpeedOrLevel;

    protected FragmentConnectEditProgramBinding(Object _bindingComponent, View _root, int _localFieldCount, LinearLayout LLIncline, LinearLayout LLSpeedOrLevel, MultiLayerBarChartView barChart, RelativeLayout cancel, View lineIncline, View lineSpeedOrLevel, RecyclerView recyclerView, RecyclerView recyclerViewIncline, RelativeLayout save, View statusBarHeight, TextView title, ConstraintLayout tobBar, TextView txtIncline, TextView txtSave, TextView txtSpeedOrLevel) {
        super(_bindingComponent, _root, _localFieldCount);
        this.LLIncline = LLIncline;
        this.LLSpeedOrLevel = LLSpeedOrLevel;
        this.barChart = barChart;
        this.cancel = cancel;
        this.lineIncline = lineIncline;
        this.lineSpeedOrLevel = lineSpeedOrLevel;
        this.recyclerView = recyclerView;
        this.recyclerViewIncline = recyclerViewIncline;
        this.save = save;
        this.statusBarHeight = statusBarHeight;
        this.title = title;
        this.tobBar = tobBar;
        this.txtIncline = txtIncline;
        this.txtSave = txtSave;
        this.txtSpeedOrLevel = txtSpeedOrLevel;
    }

    public static FragmentConnectEditProgramBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentConnectEditProgramBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (FragmentConnectEditProgramBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_connect_edit_program, root, attachToRoot, component);
    }

    public static FragmentConnectEditProgramBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentConnectEditProgramBinding inflate(LayoutInflater inflater, Object component) {
        return (FragmentConnectEditProgramBinding) ViewDataBinding.inflateInternal(inflater, R.layout.fragment_connect_edit_program, null, false, component);
    }

    public static FragmentConnectEditProgramBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static FragmentConnectEditProgramBinding bind(View view, Object component) {
        return (FragmentConnectEditProgramBinding) bind(component, view, R.layout.fragment_connect_edit_program);
    }
}
