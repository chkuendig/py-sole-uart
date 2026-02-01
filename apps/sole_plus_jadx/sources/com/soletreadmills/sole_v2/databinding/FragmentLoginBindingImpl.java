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
public class FragmentLoginBindingImpl extends FragmentLoginBinding {
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
        sparseIntArray.put(R.id.textView2, 5);
        sparseIntArray.put(R.id.ll_email, 6);
        sparseIntArray.put(R.id.edt_email, 7);
        sparseIntArray.put(R.id.img_emailClear, 8);
        sparseIntArray.put(R.id.tv_email_alert_text, 9);
        sparseIntArray.put(R.id.LL_password, 10);
        sparseIntArray.put(R.id.edt_password, 11);
        sparseIntArray.put(R.id.img_passwordClear, 12);
        sparseIntArray.put(R.id.img_eye, 13);
        sparseIntArray.put(R.id.tv_password_alert_text, 14);
        sparseIntArray.put(R.id.tv_forgot_password, 15);
        sparseIntArray.put(R.id.LL_login, 16);
    }

    public FragmentLoginBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 17, sIncludes, sViewsWithIds));
    }

    private FragmentLoginBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[16], (LinearLayout) bindings[10], (ImageView) bindings[3], (EditText) bindings[7], (EditText) bindings[11], (ImageView) bindings[4], (ImageView) bindings[8], (ImageView) bindings[13], (ImageView) bindings[12], (LinearLayout) bindings[6], (View) bindings[1], (TextView) bindings[5], (ConstraintLayout) bindings[2], (TextView) bindings[9], (TextView) bindings[15], (TextView) bindings[14]);
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
