package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class AdapterClubSearchItemBindingImpl extends AdapterClubSearchItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

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
        sparseIntArray.put(R.id.img_quitBtn, 1);
        sparseIntArray.put(R.id.img_deleteBtn, 2);
        sparseIntArray.put(R.id.ll_card_wrap, 3);
        sparseIntArray.put(R.id.img_mainImg, 4);
        sparseIntArray.put(R.id.tv_targetVal, 5);
        sparseIntArray.put(R.id.tv_unit, 6);
        sparseIntArray.put(R.id.tv_days, 7);
        sparseIntArray.put(R.id.tv_dayUnit, 8);
        sparseIntArray.put(R.id.tv_title, 9);
        sparseIntArray.put(R.id.tv_startDate, 10);
    }

    public AdapterClubSearchItemBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }

    private AdapterClubSearchItemBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[2], (ImageView) bindings[4], (ImageView) bindings[1], (LinearLayout) bindings[3], (LinearLayout) bindings[0], (TextView) bindings[8], (TextView) bindings[7], (TextView) bindings[10], (TextView) bindings[5], (TextView) bindings[9], (TextView) bindings[6]);
        this.mDirtyFlags = -1L;
        this.llMainWrap.setTag(null);
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
