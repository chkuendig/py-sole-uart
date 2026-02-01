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
public class FragmentOnboardingBindingImpl extends FragmentOnboardingBinding {
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
        sparseIntArray.put(R.id.tv_skip, 3);
        sparseIntArray.put(R.id.tv_pairLater, 4);
        sparseIntArray.put(R.id.linearLayout2, 5);
        sparseIntArray.put(R.id.view_1, 6);
        sparseIntArray.put(R.id.view_2, 7);
        sparseIntArray.put(R.id.view_3, 8);
        sparseIntArray.put(R.id.tv_next, 9);
        sparseIntArray.put(R.id.layout_page1, 10);
        sparseIntArray.put(R.id.imageView5, 11);
        sparseIntArray.put(R.id.imageView7, 12);
        sparseIntArray.put(R.id.layout_page2, 13);
        sparseIntArray.put(R.id.birthday, 14);
        sparseIntArray.put(R.id.male, 15);
        sparseIntArray.put(R.id.female, 16);
        sparseIntArray.put(R.id.title_height, 17);
        sparseIntArray.put(R.id.height, 18);
        sparseIntArray.put(R.id.title_weight, 19);
        sparseIntArray.put(R.id.weight, 20);
        sparseIntArray.put(R.id.layout_page3, 21);
        sparseIntArray.put(R.id.ll_pairViaCloud, 22);
        sparseIntArray.put(R.id.ll_pairViaBluetooth, 23);
    }

    public FragmentOnboardingBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }

    private FragmentOnboardingBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[14], (TextView) bindings[16], (EditText) bindings[18], (ImageView) bindings[11], (ImageView) bindings[12], (LinearLayout) bindings[10], (LinearLayout) bindings[13], (LinearLayout) bindings[21], (LinearLayout) bindings[5], (LinearLayout) bindings[2], (LinearLayout) bindings[23], (LinearLayout) bindings[22], (TextView) bindings[15], (View) bindings[1], (TextView) bindings[17], (TextView) bindings[19], (TextView) bindings[9], (TextView) bindings[4], (TextView) bindings[3], (View) bindings[6], (View) bindings[7], (View) bindings[8], (EditText) bindings[20]);
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
