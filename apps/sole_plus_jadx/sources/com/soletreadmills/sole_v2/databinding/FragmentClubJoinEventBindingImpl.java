package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentClubJoinEventBindingImpl extends FragmentClubJoinEventBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

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
        sparseIntArray.put(R.id.tobBar, 2);
        sparseIntArray.put(R.id.tv_cancel, 3);
        sparseIntArray.put(R.id.ll_otp_wrap, 4);
        sparseIntArray.put(R.id.et_digit_1, 5);
        sparseIntArray.put(R.id.et_digit_2, 6);
        sparseIntArray.put(R.id.et_digit_3, 7);
        sparseIntArray.put(R.id.et_digit_4, 8);
        sparseIntArray.put(R.id.et_digit_5, 9);
        sparseIntArray.put(R.id.et_digit_6, 10);
        sparseIntArray.put(R.id.btn_1, 11);
        sparseIntArray.put(R.id.btn_2, 12);
        sparseIntArray.put(R.id.btn_3, 13);
        sparseIntArray.put(R.id.btn_4, 14);
        sparseIntArray.put(R.id.btn_5, 15);
        sparseIntArray.put(R.id.btn_6, 16);
        sparseIntArray.put(R.id.btn_7, 17);
        sparseIntArray.put(R.id.btn_8, 18);
        sparseIntArray.put(R.id.btn_9, 19);
        sparseIntArray.put(R.id.btn_dot, 20);
        sparseIntArray.put(R.id.btn_0, 21);
        sparseIntArray.put(R.id.btn_delete, 22);
    }

    public FragmentClubJoinEventBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 23, sIncludes, sViewsWithIds));
    }

    private FragmentClubJoinEventBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (Button) bindings[21], (Button) bindings[11], (Button) bindings[12], (Button) bindings[13], (Button) bindings[14], (Button) bindings[15], (Button) bindings[16], (Button) bindings[17], (Button) bindings[18], (Button) bindings[19], (LinearLayout) bindings[22], (Button) bindings[20], (EditText) bindings[5], (EditText) bindings[6], (EditText) bindings[7], (EditText) bindings[8], (EditText) bindings[9], (EditText) bindings[10], (LinearLayout) bindings[4], (View) bindings[1], (ConstraintLayout) bindings[2], (TextView) bindings[3]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
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
