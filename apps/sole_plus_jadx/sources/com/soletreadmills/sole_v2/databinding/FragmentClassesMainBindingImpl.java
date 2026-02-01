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
public class FragmentClassesMainBindingImpl extends FragmentClassesMainBinding {
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
        sparseIntArray.put(R.id.textView3, 3);
        sparseIntArray.put(R.id.LL_All, 4);
        sparseIntArray.put(R.id.sessions, 5);
        sparseIntArray.put(R.id.sessions_line, 6);
        sparseIntArray.put(R.id.LL_collections, 7);
        sparseIntArray.put(R.id.collections, 8);
        sparseIntArray.put(R.id.collections_line, 9);
        sparseIntArray.put(R.id.collapsing_toolbar, 10);
        sparseIntArray.put(R.id.topbar, 11);
        sparseIntArray.put(R.id.add, 12);
        sparseIntArray.put(R.id.title, 13);
        sparseIntArray.put(R.id.img_search, 14);
        sparseIntArray.put(R.id.LL_category, 15);
        sparseIntArray.put(R.id.recyclerview_category, 16);
        sparseIntArray.put(R.id.LL_workoutsEmpty, 17);
        sparseIntArray.put(R.id.imageView30, 18);
        sparseIntArray.put(R.id.txt_resetFilters, 19);
        sparseIntArray.put(R.id.LL_sessions_view, 20);
        sparseIntArray.put(R.id.recyclerview, 21);
        sparseIntArray.put(R.id.LL_collections_view, 22);
        sparseIntArray.put(R.id.recyclerview_collections, 23);
    }

    public FragmentClassesMainBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }

    private FragmentClassesMainBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[4], (LinearLayout) bindings[15], (LinearLayout) bindings[7], (LinearLayout) bindings[22], (LinearLayout) bindings[20], (LinearLayout) bindings[17], (ImageView) bindings[12], (AppBarLayout) bindings[2], (Toolbar) bindings[10], (TextView) bindings[8], (View) bindings[9], (ImageView) bindings[18], (ImageView) bindings[14], (RecyclerView) bindings[21], (RecyclerView) bindings[16], (RecyclerView) bindings[23], (TextView) bindings[5], (View) bindings[6], (View) bindings[1], (TextView) bindings[3], (TextView) bindings[13], (ConstraintLayout) bindings[11], (TextView) bindings[19]);
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
