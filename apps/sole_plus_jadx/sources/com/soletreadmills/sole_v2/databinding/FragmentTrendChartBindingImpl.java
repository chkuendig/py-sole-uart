package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.github.mikephil.charting.charts.BarChart;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentTrendChartBindingImpl extends FragmentTrendChartBinding {
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
        sparseIntArray.put(R.id.statusBarHeight, 1);
        sparseIntArray.put(R.id.linearLayout10, 2);
        sparseIntArray.put(R.id.m3, 3);
        sparseIntArray.put(R.id.m6, 4);
        sparseIntArray.put(R.id.year, 5);
        sparseIntArray.put(R.id.topbar, 6);
        sparseIntArray.put(R.id.back, 7);
        sparseIntArray.put(R.id.endImg, 8);
        sparseIntArray.put(R.id.tv_title, 9);
        sparseIntArray.put(R.id.dateTitle, 10);
        sparseIntArray.put(R.id.subTitle, 11);
        sparseIntArray.put(R.id.barChart, 12);
        sparseIntArray.put(R.id.tv_maxTitle, 13);
        sparseIntArray.put(R.id.maxValue, 14);
        sparseIntArray.put(R.id.maxUnit, 15);
        sparseIntArray.put(R.id.tv_avgTitle, 16);
        sparseIntArray.put(R.id.avgValue, 17);
        sparseIntArray.put(R.id.avgUnit, 18);
    }

    public FragmentTrendChartBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 19, sIncludes, sViewsWithIds));
    }

    private FragmentTrendChartBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[18], (TextView) bindings[17], (ImageView) bindings[7], (BarChart) bindings[12], (TextView) bindings[10], (ImageView) bindings[8], (LinearLayout) bindings[2], (TextView) bindings[3], (TextView) bindings[4], (TextView) bindings[15], (TextView) bindings[14], (View) bindings[1], (TextView) bindings[11], (ConstraintLayout) bindings[6], (TextView) bindings[16], (TextView) bindings[13], (TextView) bindings[9], (TextView) bindings[5]);
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
