package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.ui.widget.MultiLayerBarChartView;

/* loaded from: classes5.dex */
public class FragmentConnectProgramBindingImpl extends FragmentConnectProgramBinding {
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
        sparseIntArray.put(R.id.appBarLayout, 2);
        sparseIntArray.put(R.id.tv_programName, 3);
        sparseIntArray.put(R.id.tv_machineName, 4);
        sparseIntArray.put(R.id.imageView11, 5);
        sparseIntArray.put(R.id.collapsing_toolbar, 6);
        sparseIntArray.put(R.id.topbar, 7);
        sparseIntArray.put(R.id.back, 8);
        sparseIntArray.put(R.id.ble_watch, 9);
        sparseIntArray.put(R.id.img_watch, 10);
        sparseIntArray.put(R.id.title, 11);
        sparseIntArray.put(R.id.LL_targetImg, 12);
        sparseIntArray.put(R.id.img, 13);
        sparseIntArray.put(R.id.LL_barchat, 14);
        sparseIntArray.put(R.id.textView12, 15);
        sparseIntArray.put(R.id.textView13, 16);
        sparseIntArray.put(R.id.barChart, 17);
        sparseIntArray.put(R.id.edit, 18);
        sparseIntArray.put(R.id.CL_targetHeartRate, 19);
        sparseIntArray.put(R.id.name, 20);
        sparseIntArray.put(R.id.value, 21);
        sparseIntArray.put(R.id.unit, 22);
        sparseIntArray.put(R.id.tv_max60, 23);
        sparseIntArray.put(R.id.tv_max80, 24);
        sparseIntArray.put(R.id.LL_targetView, 25);
        sparseIntArray.put(R.id.linearLayout8, 26);
        sparseIntArray.put(R.id.LL_save, 27);
        sparseIntArray.put(R.id.start, 28);
    }

    public FragmentConnectProgramBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 29, sIncludes, sViewsWithIds));
    }

    private FragmentConnectProgramBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ConstraintLayout) bindings[19], (LinearLayout) bindings[14], (LinearLayout) bindings[27], (LinearLayout) bindings[12], (LinearLayout) bindings[25], (AppBarLayout) bindings[2], (ImageView) bindings[8], (MultiLayerBarChartView) bindings[17], (ImageView) bindings[9], (Toolbar) bindings[6], (TextView) bindings[18], (ImageView) bindings[5], (ImageView) bindings[13], (ImageView) bindings[10], (LinearLayout) bindings[26], (TextView) bindings[20], (LinearLayout) bindings[28], (View) bindings[1], (TextView) bindings[15], (TextView) bindings[16], (TextView) bindings[11], (ConstraintLayout) bindings[7], (TextView) bindings[4], (TextView) bindings[23], (TextView) bindings[24], (TextView) bindings[3], (TextView) bindings[22], (TextView) bindings[21]);
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
