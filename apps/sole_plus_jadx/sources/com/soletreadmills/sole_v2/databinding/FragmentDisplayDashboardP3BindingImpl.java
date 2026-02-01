package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.ui.widget.displayDashboard.DisplayItemView;

/* loaded from: classes5.dex */
public class FragmentDisplayDashboardP3BindingImpl extends FragmentDisplayDashboardP3Binding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final NestedScrollView mboundView0;

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
        sparseIntArray.put(R.id.chartContainer, 1);
        sparseIntArray.put(R.id.maxHrItemView, 2);
        sparseIntArray.put(R.id.cl_rainbowChart, 3);
        sparseIntArray.put(R.id.hrSelectPosition, 4);
        sparseIntArray.put(R.id.selectAreaText, 5);
        sparseIntArray.put(R.id.selectAreaBg, 6);
        sparseIntArray.put(R.id.selectArea, 7);
        sparseIntArray.put(R.id.cl_rainbowChartEmpty, 8);
    }

    public FragmentDisplayDashboardP3BindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 9, sIncludes, sViewsWithIds));
    }

    private FragmentDisplayDashboardP3BindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[1], (ConstraintLayout) bindings[3], (ConstraintLayout) bindings[8], (Guideline) bindings[4], (DisplayItemView) bindings[2], (LinearLayout) bindings[7], (LinearLayout) bindings[6], (TextView) bindings[5]);
        this.mDirtyFlags = -1L;
        NestedScrollView nestedScrollView = (NestedScrollView) bindings[0];
        this.mboundView0 = nestedScrollView;
        nestedScrollView.setTag(null);
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
