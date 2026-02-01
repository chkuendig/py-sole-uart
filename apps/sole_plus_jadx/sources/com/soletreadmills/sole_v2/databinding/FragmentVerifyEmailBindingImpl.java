package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentVerifyEmailBindingImpl extends FragmentVerifyEmailBinding {
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
        sparseIntArray.put(R.id.endImg, 4);
        sparseIntArray.put(R.id.title, 5);
        sparseIntArray.put(R.id.email, 6);
        sparseIntArray.put(R.id.edt_1, 7);
        sparseIntArray.put(R.id.edt_2, 8);
        sparseIntArray.put(R.id.edt_3, 9);
        sparseIntArray.put(R.id.edt_4, 10);
        sparseIntArray.put(R.id.edt_5, 11);
        sparseIntArray.put(R.id.edt_6, 12);
        sparseIntArray.put(R.id.number1, 13);
        sparseIntArray.put(R.id.number2, 14);
        sparseIntArray.put(R.id.number3, 15);
        sparseIntArray.put(R.id.number4, 16);
        sparseIntArray.put(R.id.number5, 17);
        sparseIntArray.put(R.id.number6, 18);
        sparseIntArray.put(R.id.number7, 19);
        sparseIntArray.put(R.id.number8, 20);
        sparseIntArray.put(R.id.number9, 21);
        sparseIntArray.put(R.id.clear, 22);
        sparseIntArray.put(R.id.imageView18, 23);
        sparseIntArray.put(R.id.number0, 24);
        sparseIntArray.put(R.id.delete, 25);
        sparseIntArray.put(R.id.imageView19, 26);
        sparseIntArray.put(R.id.resendCode, 27);
        sparseIntArray.put(R.id.resendCodeDelayCount, 28);
    }

    public FragmentVerifyEmailBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 29, sIncludes, sViewsWithIds));
    }

    private FragmentVerifyEmailBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[3], (LinearLayout) bindings[22], (LinearLayout) bindings[25], (EditText) bindings[7], (EditText) bindings[8], (EditText) bindings[9], (EditText) bindings[10], (EditText) bindings[11], (EditText) bindings[12], (TextView) bindings[6], (ImageView) bindings[4], (ImageView) bindings[23], (ImageView) bindings[26], (TextView) bindings[24], (TextView) bindings[13], (TextView) bindings[14], (TextView) bindings[15], (TextView) bindings[16], (TextView) bindings[17], (TextView) bindings[18], (TextView) bindings[19], (TextView) bindings[20], (TextView) bindings[21], (TextView) bindings[27], (TextView) bindings[28], (View) bindings[1], (TextView) bindings[5], (ConstraintLayout) bindings[2]);
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
