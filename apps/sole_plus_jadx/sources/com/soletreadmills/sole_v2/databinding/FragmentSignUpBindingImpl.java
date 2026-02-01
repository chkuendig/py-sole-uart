package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentSignUpBindingImpl extends FragmentSignUpBinding {
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
        sparseIntArray.put(R.id.linearLayout, 6);
        sparseIntArray.put(R.id.LL_email, 7);
        sparseIntArray.put(R.id.edt_email, 8);
        sparseIntArray.put(R.id.img_emailClear, 9);
        sparseIntArray.put(R.id.tv_email_alert_text, 10);
        sparseIntArray.put(R.id.LL_password, 11);
        sparseIntArray.put(R.id.edt_password, 12);
        sparseIntArray.put(R.id.img_passwordClear, 13);
        sparseIntArray.put(R.id.img_eye, 14);
        sparseIntArray.put(R.id.tv_password_alert_text, 15);
        sparseIntArray.put(R.id.LL_sign_up_with_email, 16);
        sparseIntArray.put(R.id.tvTerms, 17);
        sparseIntArray.put(R.id.CL_progressbar, 18);
        sparseIntArray.put(R.id.progressBar, 19);
        sparseIntArray.put(R.id.textView4, 20);
    }

    public FragmentSignUpBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 21, sIncludes, sViewsWithIds));
    }

    private FragmentSignUpBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ConstraintLayout) bindings[18], (LinearLayout) bindings[7], (LinearLayout) bindings[11], (LinearLayout) bindings[16], (ImageView) bindings[3], (EditText) bindings[8], (EditText) bindings[12], (ImageView) bindings[4], (ImageView) bindings[9], (ImageView) bindings[14], (ImageView) bindings[13], (LinearLayout) bindings[6], (ProgressBar) bindings[19], (View) bindings[1], (TextView) bindings[5], (TextView) bindings[20], (ConstraintLayout) bindings[2], (TextView) bindings[10], (TextView) bindings[15], (TextView) bindings[17]);
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
