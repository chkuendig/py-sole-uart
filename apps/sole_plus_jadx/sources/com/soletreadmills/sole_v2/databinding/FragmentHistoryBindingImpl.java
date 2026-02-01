package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentHistoryBindingImpl extends FragmentHistoryBinding {
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
        sparseIntArray.put(R.id.textView3, 4);
        sparseIntArray.put(R.id.rv_activityType, 5);
        sparseIntArray.put(R.id.collapsing_toolbar, 6);
        sparseIntArray.put(R.id.topbar, 7);
        sparseIntArray.put(R.id.back, 8);
        sparseIntArray.put(R.id.title, 9);
        sparseIntArray.put(R.id.edit, 10);
        sparseIntArray.put(R.id.swipeRefreshLayout, 11);
        sparseIntArray.put(R.id.recyclerview, 12);
    }

    public FragmentHistoryBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }

    private FragmentHistoryBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AppBarLayout) bindings[3], (ImageView) bindings[8], (Toolbar) bindings[6], (CoordinatorLayout) bindings[2], (TextView) bindings[10], (RecyclerView) bindings[12], (RecyclerView) bindings[5], (View) bindings[1], (SwipeRefreshLayout) bindings[11], (TextView) bindings[4], (TextView) bindings[9], (ConstraintLayout) bindings[7]);
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
