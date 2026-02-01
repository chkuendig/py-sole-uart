package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class BottomSheetDisplayModeAdjustBindingImpl extends BottomSheetDisplayModeAdjustBinding {
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
        sparseIntArray.put(R.id.ll_wrap, 1);
        sparseIntArray.put(R.id.tvTitle, 2);
        sparseIntArray.put(R.id.tv_minusBtn, 3);
        sparseIntArray.put(R.id.tvValue, 4);
        sparseIntArray.put(R.id.tv_plusBtn, 5);
        sparseIntArray.put(R.id.tvUnit, 6);
        sparseIntArray.put(R.id.number1, 7);
        sparseIntArray.put(R.id.number2, 8);
        sparseIntArray.put(R.id.number3, 9);
        sparseIntArray.put(R.id.number4, 10);
        sparseIntArray.put(R.id.number6, 11);
        sparseIntArray.put(R.id.number8, 12);
        sparseIntArray.put(R.id.number10, 13);
        sparseIntArray.put(R.id.number12, 14);
        sparseIntArray.put(R.id.number14, 15);
        sparseIntArray.put(R.id.number16, 16);
        sparseIntArray.put(R.id.number18, 17);
        sparseIntArray.put(R.id.number20, 18);
        sparseIntArray.put(R.id.tv_done, 19);
    }

    public BottomSheetDisplayModeAdjustBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }

    private BottomSheetDisplayModeAdjustBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[1], (TextView) bindings[7], (TextView) bindings[13], (TextView) bindings[14], (TextView) bindings[15], (TextView) bindings[16], (TextView) bindings[17], (TextView) bindings[8], (TextView) bindings[18], (TextView) bindings[9], (TextView) bindings[10], (TextView) bindings[11], (TextView) bindings[12], (TextView) bindings[19], (LinearLayout) bindings[3], (LinearLayout) bindings[5], (TextView) bindings[2], (TextView) bindings[6], (TextView) bindings[4]);
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
