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
public class FragmentSettingProfileBindingImpl extends FragmentSettingProfileBinding {
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
        sparseIntArray.put(R.id.img_head, 6);
        sparseIntArray.put(R.id.LL_edit, 7);
        sparseIntArray.put(R.id.globalUserUuid, 8);
        sparseIntArray.put(R.id.name, 9);
        sparseIntArray.put(R.id.birthday, 10);
        sparseIntArray.put(R.id.years, 11);
        sparseIntArray.put(R.id.gender, 12);
        sparseIntArray.put(R.id.height, 13);
        sparseIntArray.put(R.id.weight, 14);
        sparseIntArray.put(R.id.LL_editProfile, 15);
    }

    public FragmentSettingProfileBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }

    private FragmentSettingProfileBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[7], (LinearLayout) bindings[15], (ImageView) bindings[3], (TextView) bindings[10], (ImageView) bindings[4], (TextView) bindings[12], (TextView) bindings[8], (TextView) bindings[13], (ImageView) bindings[6], (TextView) bindings[9], (View) bindings[1], (TextView) bindings[5], (ConstraintLayout) bindings[2], (TextView) bindings[14], (TextView) bindings[11]);
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
