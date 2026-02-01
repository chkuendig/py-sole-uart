package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.github.mikephil.charting.charts.PieChart;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class BottomSheetGoalsDetailBindingImpl extends BottomSheetGoalsDetailBinding {
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
        sparseIntArray.put(R.id.bottomSheetLayout, 1);
        sparseIntArray.put(R.id.close, 2);
        sparseIntArray.put(R.id.editButton, 3);
        sparseIntArray.put(R.id.deleteButton, 4);
        sparseIntArray.put(R.id.tvTitle, 5);
        sparseIntArray.put(R.id.tvSubTitle, 6);
        sparseIntArray.put(R.id.pieChart, 7);
        sparseIntArray.put(R.id.tvCurrentValue, 8);
        sparseIntArray.put(R.id.tvCurrentUnit, 9);
        sparseIntArray.put(R.id.tvGoalValue, 10);
        sparseIntArray.put(R.id.tvGoalUnit, 11);
        sparseIntArray.put(R.id.tvStatusRateValue, 12);
        sparseIntArray.put(R.id.tvStatusPercentUnit, 13);
        sparseIntArray.put(R.id.tvToGainValue, 14);
        sparseIntArray.put(R.id.tvToGainUnit, 15);
        sparseIntArray.put(R.id.tvLeftValue, 16);
        sparseIntArray.put(R.id.tvLeftUnit, 17);
        sparseIntArray.put(R.id.tvStreakValue, 18);
        sparseIntArray.put(R.id.tvStreakUnit, 19);
    }

    public BottomSheetGoalsDetailBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }

    private BottomSheetGoalsDetailBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[1], (AppCompatImageView) bindings[2], (AppCompatImageView) bindings[4], (AppCompatImageView) bindings[3], (PieChart) bindings[7], (TextView) bindings[9], (TextView) bindings[8], (TextView) bindings[11], (TextView) bindings[10], (TextView) bindings[17], (TextView) bindings[16], (TextView) bindings[13], (TextView) bindings[12], (TextView) bindings[19], (TextView) bindings[18], (TextView) bindings[6], (TextView) bindings[5], (TextView) bindings[15], (TextView) bindings[14]);
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
