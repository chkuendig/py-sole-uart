package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.HorizontalScrollView;
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
public class FragmentMyFavoritesBindingImpl extends FragmentMyFavoritesBinding {
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
        sparseIntArray.put(R.id.collapsing_toolbar, 3);
        sparseIntArray.put(R.id.topbar, 4);
        sparseIntArray.put(R.id.back, 5);
        sparseIntArray.put(R.id.txt_editOrDone, 6);
        sparseIntArray.put(R.id.title, 7);
        sparseIntArray.put(R.id.scroll_filter, 8);
        sparseIntArray.put(R.id.LL_category, 9);
        sparseIntArray.put(R.id.txt_classes, 10);
        sparseIntArray.put(R.id.txt_collections, 11);
        sparseIntArray.put(R.id.txt_programs, 12);
        sparseIntArray.put(R.id.LL_workoutsEmpty, 13);
        sparseIntArray.put(R.id.img_empty, 14);
        sparseIntArray.put(R.id.tv_empty, 15);
        sparseIntArray.put(R.id.tv_resetFilters, 16);
        sparseIntArray.put(R.id.recyclerView_favorites, 17);
        sparseIntArray.put(R.id.LL_removeAll, 18);
        sparseIntArray.put(R.id.setFree, 19);
    }

    public FragmentMyFavoritesBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }

    private FragmentMyFavoritesBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[9], (LinearLayout) bindings[18], (LinearLayout) bindings[13], (AppBarLayout) bindings[2], (ImageView) bindings[5], (Toolbar) bindings[3], (ImageView) bindings[14], (RecyclerView) bindings[17], (HorizontalScrollView) bindings[8], (TextView) bindings[19], (View) bindings[1], (TextView) bindings[7], (ConstraintLayout) bindings[4], (TextView) bindings[15], (TextView) bindings[16], (TextView) bindings[10], (TextView) bindings[11], (TextView) bindings[6], (TextView) bindings[12]);
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
