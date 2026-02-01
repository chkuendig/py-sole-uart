package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.github.mikephil.charting.charts.PieChart;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class AdapterGoalsItemBindingImpl extends AdapterGoalsItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

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
        sparseIntArray.put(R.id.layout_goal_bg, 1);
        sparseIntArray.put(R.id.layout_goal, 2);
        sparseIntArray.put(R.id.img_deleteBtn, 3);
        sparseIntArray.put(R.id.pieChart, 4);
        sparseIntArray.put(R.id.tv_timeFrame, 5);
        sparseIntArray.put(R.id.img_arrow, 6);
        sparseIntArray.put(R.id.tv_completeRate, 7);
        sparseIntArray.put(R.id.layout_add, 8);
        sparseIntArray.put(R.id.imageView12, 9);
        sparseIntArray.put(R.id.layout_add_btn_cover, 10);
    }

    public AdapterGoalsItemBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }

    private AdapterGoalsItemBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[9], (ImageView) bindings[6], (ImageView) bindings[3], (ConstraintLayout) bindings[8], (LinearLayout) bindings[10], (LinearLayout) bindings[2], (CardView) bindings[1], (ConstraintLayout) bindings[0], (PieChart) bindings[4], (TextView) bindings[7], (TextView) bindings[5]);
        this.mDirtyFlags = -1L;
        this.layoutGoalWrap.setTag(null);
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
