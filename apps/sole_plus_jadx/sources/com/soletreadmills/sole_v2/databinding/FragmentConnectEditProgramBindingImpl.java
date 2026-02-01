package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.ui.widget.MultiLayerBarChartView;

/* loaded from: classes5.dex */
public class FragmentConnectEditProgramBindingImpl extends FragmentConnectEditProgramBinding {
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
        sparseIntArray.put(R.id.tobBar, 2);
        sparseIntArray.put(R.id.title, 3);
        sparseIntArray.put(R.id.cancel, 4);
        sparseIntArray.put(R.id.save, 5);
        sparseIntArray.put(R.id.txt_save, 6);
        sparseIntArray.put(R.id.LL_speedOrLevel, 7);
        sparseIntArray.put(R.id.txt_speedOrLevel, 8);
        sparseIntArray.put(R.id.line_speedOrLevel, 9);
        sparseIntArray.put(R.id.LL_incline, 10);
        sparseIntArray.put(R.id.txt_incline, 11);
        sparseIntArray.put(R.id.line_incline, 12);
        sparseIntArray.put(R.id.barChart, 13);
        sparseIntArray.put(R.id.recyclerView, 14);
        sparseIntArray.put(R.id.recyclerView_incline, 15);
    }

    public FragmentConnectEditProgramBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }

    private FragmentConnectEditProgramBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[10], (LinearLayout) bindings[7], (MultiLayerBarChartView) bindings[13], (RelativeLayout) bindings[4], (View) bindings[12], (View) bindings[9], (RecyclerView) bindings[14], (RecyclerView) bindings[15], (RelativeLayout) bindings[5], (View) bindings[1], (TextView) bindings[3], (ConstraintLayout) bindings[2], (TextView) bindings[11], (TextView) bindings[6], (TextView) bindings[8]);
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
