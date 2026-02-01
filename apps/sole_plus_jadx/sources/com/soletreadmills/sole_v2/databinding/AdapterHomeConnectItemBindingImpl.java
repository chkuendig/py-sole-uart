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
public class AdapterHomeConnectItemBindingImpl extends AdapterHomeConnectItemBinding {
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
        sparseIntArray.put(R.id.card, 1);
        sparseIntArray.put(R.id.layout_connect, 2);
        sparseIntArray.put(R.id.card_img, 3);
        sparseIntArray.put(R.id.img, 4);
        sparseIntArray.put(R.id.img_circle, 5);
        sparseIntArray.put(R.id.tv_Title, 6);
        sparseIntArray.put(R.id.imageView11, 7);
        sparseIntArray.put(R.id.tv_name, 8);
        sparseIntArray.put(R.id.tv_status, 9);
        sparseIntArray.put(R.id.ll_connecting_board, 10);
        sparseIntArray.put(R.id.ll_display_stats, 11);
        sparseIntArray.put(R.id.ll_browse_programs, 12);
        sparseIntArray.put(R.id.ll_disconnect, 13);
        sparseIntArray.put(R.id.ll_quick_start, 14);
        sparseIntArray.put(R.id.imageView15, 15);
        sparseIntArray.put(R.id.layout_add, 16);
        sparseIntArray.put(R.id.imageView12, 17);
    }

    public AdapterHomeConnectItemBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }

    private AdapterHomeConnectItemBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (CardView) bindings[1], (CardView) bindings[3], (ImageView) bindings[7], (ImageView) bindings[17], (ImageView) bindings[15], (ImageView) bindings[4], (ImageView) bindings[5], (LinearLayout) bindings[16], (LinearLayout) bindings[2], (LinearLayout) bindings[12], (LinearLayout) bindings[10], (LinearLayout) bindings[13], (LinearLayout) bindings[11], (LinearLayout) bindings[14], (TextView) bindings[8], (TextView) bindings[9], (TextView) bindings[6]);
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
