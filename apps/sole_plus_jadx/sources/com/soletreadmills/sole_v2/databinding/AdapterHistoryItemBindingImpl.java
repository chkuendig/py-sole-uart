package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class AdapterHistoryItemBindingImpl extends AdapterHistoryItemBinding {
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
        sparseIntArray.put(R.id.img_personalBest, 1);
        sparseIntArray.put(R.id.LL_img, 2);
        sparseIntArray.put(R.id.img_remove, 3);
        sparseIntArray.put(R.id.card_img, 4);
        sparseIntArray.put(R.id.img, 5);
        sparseIntArray.put(R.id.LL_history, 6);
        sparseIntArray.put(R.id.name, 7);
        sparseIntArray.put(R.id.value, 8);
        sparseIntArray.put(R.id.img_arrow, 9);
        sparseIntArray.put(R.id.sportsParts, 10);
        sparseIntArray.put(R.id.date, 11);
        sparseIntArray.put(R.id.img_space, 12);
    }

    public AdapterHistoryItemBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }

    private AdapterHistoryItemBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[6], (LinearLayout) bindings[2], (CardView) bindings[4], (TextView) bindings[11], (ImageView) bindings[5], (ImageView) bindings[9], (ImageView) bindings[1], (ImageView) bindings[3], (ImageView) bindings[12], (TextView) bindings[7], (TextView) bindings[10], (TextView) bindings[8]);
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
