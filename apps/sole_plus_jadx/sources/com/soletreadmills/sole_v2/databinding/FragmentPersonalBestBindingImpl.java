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
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentPersonalBestBindingImpl extends FragmentPersonalBestBinding {
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
        sparseIntArray.put(R.id.LL_year, 2);
        sparseIntArray.put(R.id.rcv_year, 3);
        sparseIntArray.put(R.id.appBarLayout, 4);
        sparseIntArray.put(R.id.textView3, 5);
        sparseIntArray.put(R.id.LL_unlockHeader, 6);
        sparseIntArray.put(R.id.tv_unlockTitle, 7);
        sparseIntArray.put(R.id.unlock_line, 8);
        sparseIntArray.put(R.id.LL_lockHeader, 9);
        sparseIntArray.put(R.id.tv_lockTitle, 10);
        sparseIntArray.put(R.id.lock_line, 11);
        sparseIntArray.put(R.id.collapsing_toolbar, 12);
        sparseIntArray.put(R.id.topbar, 13);
        sparseIntArray.put(R.id.back, 14);
        sparseIntArray.put(R.id.title, 15);
        sparseIntArray.put(R.id.img_search, 16);
        sparseIntArray.put(R.id.LL_unlock, 17);
        sparseIntArray.put(R.id.recyclerview, 18);
        sparseIntArray.put(R.id.LL_lock, 19);
        sparseIntArray.put(R.id.LL_greatJob, 20);
        sparseIntArray.put(R.id.imageView30, 21);
        sparseIntArray.put(R.id.rcv_lock, 22);
    }

    public FragmentPersonalBestBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 23, sIncludes, sViewsWithIds));
    }

    private FragmentPersonalBestBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[20], (LinearLayout) bindings[19], (LinearLayout) bindings[9], (LinearLayout) bindings[17], (LinearLayout) bindings[6], (LinearLayout) bindings[2], (AppBarLayout) bindings[4], (ImageView) bindings[14], (Toolbar) bindings[12], (ImageView) bindings[21], (ImageView) bindings[16], (View) bindings[11], (RecyclerView) bindings[22], (RecyclerView) bindings[3], (RecyclerView) bindings[18], (View) bindings[1], (TextView) bindings[5], (TextView) bindings[15], (ConstraintLayout) bindings[13], (TextView) bindings[10], (TextView) bindings[7], (View) bindings[8]);
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
