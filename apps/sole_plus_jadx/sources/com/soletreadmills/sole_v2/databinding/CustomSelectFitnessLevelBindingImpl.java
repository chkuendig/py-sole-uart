package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class CustomSelectFitnessLevelBindingImpl extends CustomSelectFitnessLevelBinding {
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
        sparseIntArray.put(R.id.close, 1);
        sparseIntArray.put(R.id.title, 2);
        sparseIntArray.put(R.id.reset, 3);
        sparseIntArray.put(R.id.LL_novice, 4);
        sparseIntArray.put(R.id.img_novice, 5);
        sparseIntArray.put(R.id.txt_novice, 6);
        sparseIntArray.put(R.id.LL_skilled, 7);
        sparseIntArray.put(R.id.img_skilled, 8);
        sparseIntArray.put(R.id.txt_skilled, 9);
        sparseIntArray.put(R.id.LL_expert, 10);
        sparseIntArray.put(R.id.img_expert, 11);
        sparseIntArray.put(R.id.txt_expert, 12);
        sparseIntArray.put(R.id.LL_anyLevel, 13);
        sparseIntArray.put(R.id.img_anyLevel, 14);
        sparseIntArray.put(R.id.txt_anyLevel, 15);
        sparseIntArray.put(R.id.LL_done, 16);
        sparseIntArray.put(R.id.done, 17);
    }

    public CustomSelectFitnessLevelBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 18, sIncludes, sViewsWithIds));
    }

    private CustomSelectFitnessLevelBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[13], (LinearLayout) bindings[16], (LinearLayout) bindings[10], (LinearLayout) bindings[4], (LinearLayout) bindings[7], (AppCompatImageView) bindings[1], (TextView) bindings[17], (ImageView) bindings[14], (ImageView) bindings[11], (ImageView) bindings[5], (ImageView) bindings[8], (TextView) bindings[3], (TextView) bindings[2], (TextView) bindings[15], (TextView) bindings[12], (TextView) bindings[6], (TextView) bindings[9]);
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
