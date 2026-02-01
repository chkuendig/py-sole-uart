package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.github.mikephil.charting.charts.LineChart;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class CustomHistoryWorkoutChartItemBindingImpl extends CustomHistoryWorkoutChartItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final ConstraintLayout mboundView0;

    @Override // androidx.databinding.ViewDataBinding
    protected boolean onFieldChange(int localFieldId, Object object, int fieldId) {
        return false;
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean setVariable(int variableId, Object variable) {
        return true;
    }

    static {
        SparseIntArray sparseIntArray = new SparseIntArray();
        sViewsWithIds = sparseIntArray;
        sparseIntArray.put(R.id.LL_top, 1);
        sparseIntArray.put(R.id.title, 2);
        sparseIntArray.put(R.id.value, 3);
        sparseIntArray.put(R.id.unit, 4);
        sparseIntArray.put(R.id.tv_distance, 5);
        sparseIntArray.put(R.id.tv_time, 6);
        sparseIntArray.put(R.id.maxLabel, 7);
        sparseIntArray.put(R.id.LL_notEnoughData, 8);
        sparseIntArray.put(R.id.tv_notEnoughData, 9);
        sparseIntArray.put(R.id.lineChart, 10);
        sparseIntArray.put(R.id.minLabel, 11);
    }

    public CustomHistoryWorkoutChartItemBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 12, sIncludes, sViewsWithIds));
    }

    private CustomHistoryWorkoutChartItemBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[8], (LinearLayout) bindings[1], (LineChart) bindings[10], (TextView) bindings[7], (TextView) bindings[11], (TextView) bindings[2], (TextView) bindings[5], (TextView) bindings[9], (TextView) bindings[6], (TextView) bindings[4], (TextView) bindings[3]);
        this.mDirtyFlags = -1L;
        ConstraintLayout constraintLayout = (ConstraintLayout) bindings[0];
        this.mboundView0 = constraintLayout;
        constraintLayout.setTag(null);
        setRootTag(root);
        invalidateAll();
    }

    @Override // androidx.databinding.ViewDataBinding
    public void invalidateAll() {
        synchronized (this) {
            this.mDirtyFlags = 1L;
        }
        requestRebind();
    }

    @Override // androidx.databinding.ViewDataBinding
    public boolean hasPendingBindings() {
        synchronized (this) {
            return this.mDirtyFlags != 0;
        }
    }

    @Override // androidx.databinding.ViewDataBinding
    protected void executeBindings() {
        synchronized (this) {
            this.mDirtyFlags = 0L;
        }
    }
}
