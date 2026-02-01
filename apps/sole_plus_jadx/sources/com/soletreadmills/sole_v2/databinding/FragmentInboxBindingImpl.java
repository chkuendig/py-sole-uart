package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentInboxBindingImpl extends FragmentInboxBinding {
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
        sparseIntArray.put(R.id.topbar, 2);
        sparseIntArray.put(R.id.back, 3);
        sparseIntArray.put(R.id.title, 4);
        sparseIntArray.put(R.id.LL_inboxEmpty, 5);
        sparseIntArray.put(R.id.img_empty, 6);
        sparseIntArray.put(R.id.tv_empty, 7);
        sparseIntArray.put(R.id.tv_resetFilters, 8);
        sparseIntArray.put(R.id.LL_hasData, 9);
        sparseIntArray.put(R.id.LL_unread, 10);
        sparseIntArray.put(R.id.tv_unReadCount, 11);
        sparseIntArray.put(R.id.textView3, 12);
        sparseIntArray.put(R.id.rv, 13);
        sparseIntArray.put(R.id.linearLayout9, 14);
        sparseIntArray.put(R.id.LL_markAllRead, 15);
        sparseIntArray.put(R.id.textView8, 16);
    }

    public FragmentInboxBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }

    private FragmentInboxBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[9], (LinearLayout) bindings[5], (LinearLayout) bindings[15], (LinearLayout) bindings[10], (ImageView) bindings[3], (ImageView) bindings[6], (LinearLayout) bindings[14], (RecyclerView) bindings[13], (View) bindings[1], (TextView) bindings[12], (TextView) bindings[16], (TextView) bindings[4], (ConstraintLayout) bindings[2], (TextView) bindings[7], (TextView) bindings[8], (TextView) bindings[11]);
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
