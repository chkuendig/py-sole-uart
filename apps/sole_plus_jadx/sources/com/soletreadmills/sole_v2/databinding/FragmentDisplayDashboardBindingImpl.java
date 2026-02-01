package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.viewpager2.widget.ViewPager2;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentDisplayDashboardBindingImpl extends FragmentDisplayDashboardBinding {
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
        sparseIntArray.put(R.id.tobBar, 2);
        sparseIntArray.put(R.id.finishBtn, 3);
        sparseIntArray.put(R.id.backBtn, 4);
        sparseIntArray.put(R.id.rotateSetting, 5);
        sparseIntArray.put(R.id.ble_watch, 6);
        sparseIntArray.put(R.id.img_watch, 7);
        sparseIntArray.put(R.id.line, 8);
        sparseIntArray.put(R.id.viewPager, 9);
        sparseIntArray.put(R.id.pagerIndicator, 10);
        sparseIntArray.put(R.id.tabIndicator1, 11);
        sparseIntArray.put(R.id.tabIndicator2, 12);
        sparseIntArray.put(R.id.tabIndicator3, 13);
        sparseIntArray.put(R.id.control_board, 14);
        sparseIntArray.put(R.id.ll_control_panel, 15);
        sparseIntArray.put(R.id.ll_pause_panel, 16);
        sparseIntArray.put(R.id.ll_start_btn, 17);
        sparseIntArray.put(R.id.ll_start_panel, 18);
        sparseIntArray.put(R.id.ll_left_bottomSheet, 19);
        sparseIntArray.put(R.id.tv_left_value, 20);
        sparseIntArray.put(R.id.tv_left_unit, 21);
        sparseIntArray.put(R.id.ll_left_line, 22);
        sparseIntArray.put(R.id.ll_pause_btn, 23);
        sparseIntArray.put(R.id.ll_right_line, 24);
        sparseIntArray.put(R.id.ll_right_bottomSheet, 25);
        sparseIntArray.put(R.id.tv_right_value, 26);
        sparseIntArray.put(R.id.tv_right_unit, 27);
    }

    public FragmentDisplayDashboardBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 28, sIncludes, sViewsWithIds));
    }

    private FragmentDisplayDashboardBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[4], (ImageView) bindings[6], (LinearLayout) bindings[14], (LinearLayout) bindings[3], (ImageView) bindings[7], (LinearLayout) bindings[8], (LinearLayout) bindings[15], (LinearLayout) bindings[19], (LinearLayout) bindings[22], (LinearLayout) bindings[23], (LinearLayout) bindings[16], (LinearLayout) bindings[25], (LinearLayout) bindings[24], (LinearLayout) bindings[17], (LinearLayout) bindings[18], (LinearLayout) bindings[10], (ImageView) bindings[5], (View) bindings[1], (ImageView) bindings[11], (ImageView) bindings[12], (ImageView) bindings[13], (ConstraintLayout) bindings[2], (TextView) bindings[21], (TextView) bindings[20], (TextView) bindings[27], (TextView) bindings[26], (ViewPager2) bindings[9]);
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
