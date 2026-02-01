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
public class FragmentSettingsAppsBindingImpl extends FragmentSettingsAppsBinding {
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
        sparseIntArray.put(R.id.linearLayout4, 6);
        sparseIntArray.put(R.id.ll_health_connect, 7);
        sparseIntArray.put(R.id.tv_health_connect_linked, 8);
        sparseIntArray.put(R.id.ll_samsung_health, 9);
        sparseIntArray.put(R.id.tv_samsung_health_linked, 10);
        sparseIntArray.put(R.id.ll_garmin_connect, 11);
        sparseIntArray.put(R.id.tv_garmin_connect_linked, 12);
    }

    public FragmentSettingsAppsBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }

    private FragmentSettingsAppsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[3], (ImageView) bindings[4], (LinearLayout) bindings[6], (LinearLayout) bindings[11], (LinearLayout) bindings[7], (LinearLayout) bindings[9], (View) bindings[1], (TextView) bindings[5], (ConstraintLayout) bindings[2], (TextView) bindings[12], (TextView) bindings[8], (TextView) bindings[10]);
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
