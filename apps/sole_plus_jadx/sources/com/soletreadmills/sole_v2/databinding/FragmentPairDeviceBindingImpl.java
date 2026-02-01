package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.tabs.TabLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentPairDeviceBindingImpl extends FragmentPairDeviceBinding {
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
        sparseIntArray.put(R.id.CL_no_search, 2);
        sparseIntArray.put(R.id.linearLayout3, 3);
        sparseIntArray.put(R.id.tryAgain, 4);
        sparseIntArray.put(R.id.CL_search_progressbar, 5);
        sparseIntArray.put(R.id.topbar, 6);
        sparseIntArray.put(R.id.cancel, 7);
        sparseIntArray.put(R.id.tv_search, 8);
        sparseIntArray.put(R.id.CL_device_list, 9);
        sparseIntArray.put(R.id.viewPager, 10);
        sparseIntArray.put(R.id.dotsIndicator, 11);
        sparseIntArray.put(R.id.LL_pair, 12);
        sparseIntArray.put(R.id.pair, 13);
        sparseIntArray.put(R.id.CL_progressbar, 14);
        sparseIntArray.put(R.id.LL_pair_success, 15);
        sparseIntArray.put(R.id.tv_devicePaired, 16);
        sparseIntArray.put(R.id.LL_pair_failed, 17);
        sparseIntArray.put(R.id.LL_pairing_progressbar, 18);
        sparseIntArray.put(R.id.textView4, 19);
    }

    public FragmentPairDeviceBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 20, sIncludes, sViewsWithIds));
    }

    private FragmentPairDeviceBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ConstraintLayout) bindings[9], (ConstraintLayout) bindings[2], (ConstraintLayout) bindings[14], (ConstraintLayout) bindings[5], (LinearLayout) bindings[12], (LinearLayout) bindings[17], (LinearLayout) bindings[15], (LinearLayout) bindings[18], (TextView) bindings[7], (TabLayout) bindings[11], (LinearLayout) bindings[3], (LinearLayout) bindings[13], (View) bindings[1], (TextView) bindings[19], (ConstraintLayout) bindings[6], (LinearLayout) bindings[4], (TextView) bindings[16], (TextView) bindings[8], (ViewPager2) bindings[10]);
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
