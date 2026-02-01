package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentMyDevicesBindingImpl extends FragmentMyDevicesBinding {
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
        sparseIntArray.put(R.id.coordinatorLayout, 2);
        sparseIntArray.put(R.id.appBarLayout, 3);
        sparseIntArray.put(R.id.collapsing_toolbar, 4);
        sparseIntArray.put(R.id.topbar, 5);
        sparseIntArray.put(R.id.back, 6);
        sparseIntArray.put(R.id.title, 7);
        sparseIntArray.put(R.id.edit, 8);
        sparseIntArray.put(R.id.recyclerview, 9);
        sparseIntArray.put(R.id.CL_no_search, 10);
        sparseIntArray.put(R.id.view2, 11);
        sparseIntArray.put(R.id.linearLayout5, 12);
        sparseIntArray.put(R.id.LL_addDevice, 13);
        sparseIntArray.put(R.id.LL_unpair, 14);
        sparseIntArray.put(R.id.tv_unpair, 15);
    }

    public FragmentMyDevicesBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }

    private FragmentMyDevicesBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ConstraintLayout) bindings[10], (LinearLayout) bindings[13], (LinearLayout) bindings[14], (AppBarLayout) bindings[3], (ImageView) bindings[6], (Toolbar) bindings[4], (CoordinatorLayout) bindings[2], (TextView) bindings[8], (LinearLayout) bindings[12], (RecyclerView) bindings[9], (View) bindings[1], (TextView) bindings[7], (ConstraintLayout) bindings[5], (TextView) bindings[15], (View) bindings[11]);
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
