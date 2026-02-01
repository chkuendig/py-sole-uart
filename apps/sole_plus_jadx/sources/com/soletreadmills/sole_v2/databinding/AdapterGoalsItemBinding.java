package com.soletreadmills.sole_v2.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import com.github.mikephil.charting.charts.PieChart;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public abstract class AdapterGoalsItemBinding extends ViewDataBinding {
    public final ImageView imageView12;
    public final ImageView imgArrow;
    public final ImageView imgDeleteBtn;
    public final ConstraintLayout layoutAdd;
    public final LinearLayout layoutAddBtnCover;
    public final LinearLayout layoutGoal;
    public final CardView layoutGoalBg;
    public final ConstraintLayout layoutGoalWrap;
    public final PieChart pieChart;
    public final TextView tvCompleteRate;
    public final TextView tvTimeFrame;

    protected AdapterGoalsItemBinding(Object _bindingComponent, View _root, int _localFieldCount, ImageView imageView12, ImageView imgArrow, ImageView imgDeleteBtn, ConstraintLayout layoutAdd, LinearLayout layoutAddBtnCover, LinearLayout layoutGoal, CardView layoutGoalBg, ConstraintLayout layoutGoalWrap, PieChart pieChart, TextView tvCompleteRate, TextView tvTimeFrame) {
        super(_bindingComponent, _root, _localFieldCount);
        this.imageView12 = imageView12;
        this.imgArrow = imgArrow;
        this.imgDeleteBtn = imgDeleteBtn;
        this.layoutAdd = layoutAdd;
        this.layoutAddBtnCover = layoutAddBtnCover;
        this.layoutGoal = layoutGoal;
        this.layoutGoalBg = layoutGoalBg;
        this.layoutGoalWrap = layoutGoalWrap;
        this.pieChart = pieChart;
        this.tvCompleteRate = tvCompleteRate;
        this.tvTimeFrame = tvTimeFrame;
    }

    public static AdapterGoalsItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot) {
        return inflate(inflater, root, attachToRoot, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterGoalsItemBinding inflate(LayoutInflater inflater, ViewGroup root, boolean attachToRoot, Object component) {
        return (AdapterGoalsItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_goals_item, root, attachToRoot, component);
    }

    public static AdapterGoalsItemBinding inflate(LayoutInflater inflater) {
        return inflate(inflater, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterGoalsItemBinding inflate(LayoutInflater inflater, Object component) {
        return (AdapterGoalsItemBinding) ViewDataBinding.inflateInternal(inflater, R.layout.adapter_goals_item, null, false, component);
    }

    public static AdapterGoalsItemBinding bind(View view) {
        return bind(view, DataBindingUtil.getDefaultComponent());
    }

    @Deprecated
    public static AdapterGoalsItemBinding bind(View view, Object component) {
        return (AdapterGoalsItemBinding) bind(component, view, R.layout.adapter_goals_item);
    }
}
