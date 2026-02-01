package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentEditProfileBindingImpl extends FragmentEditProfileBinding {
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
        sparseIntArray.put(R.id.linearLayout7, 2);
        sparseIntArray.put(R.id.cancel, 3);
        sparseIntArray.put(R.id.title, 4);
        sparseIntArray.put(R.id.save, 5);
        sparseIntArray.put(R.id.name, 6);
        sparseIntArray.put(R.id.birthday, 7);
        sparseIntArray.put(R.id.male, 8);
        sparseIntArray.put(R.id.female, 9);
        sparseIntArray.put(R.id.other, 10);
        sparseIntArray.put(R.id.title_height, 11);
        sparseIntArray.put(R.id.height, 12);
        sparseIntArray.put(R.id.title_weight, 13);
        sparseIntArray.put(R.id.weight, 14);
    }

    public FragmentEditProfileBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    private FragmentEditProfileBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[7], (TextView) bindings[3], (TextView) bindings[9], (EditText) bindings[12], (LinearLayout) bindings[2], (TextView) bindings[8], (EditText) bindings[6], (TextView) bindings[10], (TextView) bindings[5], (View) bindings[1], (TextView) bindings[4], (TextView) bindings[11], (TextView) bindings[13], (EditText) bindings[14]);
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
