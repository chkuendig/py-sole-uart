package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class BottomSheetGoalsEditTargetBindingImpl extends BottomSheetGoalsEditTargetBinding {
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
        sparseIntArray.put(R.id.tv_cancel, 2);
        sparseIntArray.put(R.id.tvTitle, 3);
        sparseIntArray.put(R.id.tv_minusBtn, 4);
        sparseIntArray.put(R.id.tv_minusBtnImg, 5);
        sparseIntArray.put(R.id.tvValue, 6);
        sparseIntArray.put(R.id.tv_plusBtn, 7);
        sparseIntArray.put(R.id.tv_plusBtnImg, 8);
        sparseIntArray.put(R.id.tvPeriodAndUnit, 9);
        sparseIntArray.put(R.id.number1, 10);
        sparseIntArray.put(R.id.number2, 11);
        sparseIntArray.put(R.id.number3, 12);
        sparseIntArray.put(R.id.number4, 13);
        sparseIntArray.put(R.id.number5, 14);
        sparseIntArray.put(R.id.number6, 15);
        sparseIntArray.put(R.id.number7, 16);
        sparseIntArray.put(R.id.number8, 17);
        sparseIntArray.put(R.id.number9, 18);
        sparseIntArray.put(R.id.clear, 19);
        sparseIntArray.put(R.id.number0, 20);
        sparseIntArray.put(R.id.delete, 21);
        sparseIntArray.put(R.id.imageView19, 22);
        sparseIntArray.put(R.id.tv_done, 23);
    }

    public BottomSheetGoalsEditTargetBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }

    private BottomSheetGoalsEditTargetBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[19], (LinearLayout) bindings[21], (ImageView) bindings[22], (LinearLayout) bindings[1], (TextView) bindings[20], (TextView) bindings[10], (TextView) bindings[11], (TextView) bindings[12], (TextView) bindings[13], (TextView) bindings[14], (TextView) bindings[15], (TextView) bindings[16], (TextView) bindings[17], (TextView) bindings[18], (TextView) bindings[2], (TextView) bindings[23], (LinearLayout) bindings[4], (ImageView) bindings[5], (TextView) bindings[9], (LinearLayout) bindings[7], (ImageView) bindings[8], (TextView) bindings[3], (TextView) bindings[6]);
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
