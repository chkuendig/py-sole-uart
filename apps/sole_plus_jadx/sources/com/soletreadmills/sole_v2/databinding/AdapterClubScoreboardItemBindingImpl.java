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
public class AdapterClubScoreboardItemBindingImpl extends AdapterClubScoreboardItemBinding {
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
        sparseIntArray.put(R.id.ll_bg, 1);
        sparseIntArray.put(R.id.img_delete, 2);
        sparseIntArray.put(R.id.img_avatar, 3);
        sparseIntArray.put(R.id.img_isSelf, 4);
        sparseIntArray.put(R.id.tv_rank, 5);
        sparseIntArray.put(R.id.tv_username, 6);
        sparseIntArray.put(R.id.tv_scoreValue, 7);
        sparseIntArray.put(R.id.tv_unit, 8);
        sparseIntArray.put(R.id.img_arrow, 9);
    }

    public AdapterClubScoreboardItemBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }

    private AdapterClubScoreboardItemBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[9], (ImageView) bindings[3], (ImageView) bindings[2], (View) bindings[4], (LinearLayout) bindings[1], (LinearLayout) bindings[0], (TextView) bindings[5], (TextView) bindings[7], (TextView) bindings[8], (TextView) bindings[6]);
        this.mDirtyFlags = -1L;
        this.llScoreboardWrap.setTag(null);
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
