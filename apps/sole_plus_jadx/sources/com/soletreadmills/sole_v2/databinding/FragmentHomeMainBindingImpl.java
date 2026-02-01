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
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.material.appbar.AppBarLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentHomeMainBindingImpl extends FragmentHomeMainBinding {
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
        sparseIntArray.put(R.id.collapsing_toolbar, 4);
        sparseIntArray.put(R.id.topbar, 5);
        sparseIntArray.put(R.id.title, 6);
        sparseIntArray.put(R.id.LL_getPremium, 7);
        sparseIntArray.put(R.id.swipeRefreshLayout, 8);
        sparseIntArray.put(R.id.LL_connect, 9);
        sparseIntArray.put(R.id.img_connect_plus, 10);
        sparseIntArray.put(R.id.img_connect, 11);
        sparseIntArray.put(R.id.tv_connect, 12);
        sparseIntArray.put(R.id.rv_connect, 13);
        sparseIntArray.put(R.id.img_favorites_more_btn, 14);
        sparseIntArray.put(R.id.tv_favorites_empty_desc, 15);
        sparseIntArray.put(R.id.rv_favorites, 16);
        sparseIntArray.put(R.id.rv_pickedForYou, 17);
        sparseIntArray.put(R.id.img_collections_more_btn, 18);
        sparseIntArray.put(R.id.rv_collections, 19);
        sparseIntArray.put(R.id.LL_goals, 20);
        sparseIntArray.put(R.id.rv_goals, 21);
    }

    public FragmentHomeMainBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 22, sIncludes, sViewsWithIds));
    }

    private FragmentHomeMainBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[9], (LinearLayout) bindings[7], (LinearLayout) bindings[20], (AppBarLayout) bindings[2], (Toolbar) bindings[4], (ImageView) bindings[18], (ImageView) bindings[11], (ImageView) bindings[10], (ImageView) bindings[14], (RecyclerView) bindings[19], (RecyclerView) bindings[13], (RecyclerView) bindings[16], (RecyclerView) bindings[21], (RecyclerView) bindings[17], (View) bindings[1], (SwipeRefreshLayout) bindings[8], (TextView) bindings[3], (TextView) bindings[6], (ConstraintLayout) bindings[5], (TextView) bindings[12], (TextView) bindings[15]);
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
