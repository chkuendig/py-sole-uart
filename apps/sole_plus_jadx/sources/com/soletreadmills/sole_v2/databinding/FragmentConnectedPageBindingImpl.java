package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.material.appbar.AppBarLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentConnectedPageBindingImpl extends FragmentConnectedPageBinding {
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
        sparseIntArray.put(R.id.appBarLayout, 1);
        sparseIntArray.put(R.id.tv_machineType, 2);
        sparseIntArray.put(R.id.tv_deviceName, 3);
        sparseIntArray.put(R.id.imageView11, 4);
        sparseIntArray.put(R.id.textView9, 5);
        sparseIntArray.put(R.id.collapsing_toolbar, 6);
        sparseIntArray.put(R.id.topbar, 7);
        sparseIntArray.put(R.id.back, 8);
        sparseIntArray.put(R.id.ble_watch, 9);
        sparseIntArray.put(R.id.img_watch, 10);
        sparseIntArray.put(R.id.title, 11);
        sparseIntArray.put(R.id.LL_category, 12);
        sparseIntArray.put(R.id.recyclerview_category, 13);
        sparseIntArray.put(R.id.recyclerView_program, 14);
        sparseIntArray.put(R.id.LL_noProgram, 15);
        sparseIntArray.put(R.id.imageView22, 16);
        sparseIntArray.put(R.id.textView11, 17);
        sparseIntArray.put(R.id.linearLayout5, 18);
        sparseIntArray.put(R.id.LL_simpleBottom, 19);
        sparseIntArray.put(R.id.LL_finish, 20);
        sparseIntArray.put(R.id.tv_display, 21);
        sparseIntArray.put(R.id.LL_bottom, 22);
        sparseIntArray.put(R.id.LL_disconnect, 23);
        sparseIntArray.put(R.id.LL_start, 24);
        sparseIntArray.put(R.id.imageView15, 25);
        sparseIntArray.put(R.id.tv_unpair, 26);
        sparseIntArray.put(R.id.ll_countdownWrap, 27);
        sparseIntArray.put(R.id.ll_countdownNum, 28);
    }

    public FragmentConnectedPageBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 29, sIncludes, sViewsWithIds));
    }

    private FragmentConnectedPageBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[22], (LinearLayout) bindings[12], (LinearLayout) bindings[23], (LinearLayout) bindings[20], (LinearLayout) bindings[15], (LinearLayout) bindings[19], (LinearLayout) bindings[24], (AppBarLayout) bindings[1], (ImageView) bindings[8], (ImageView) bindings[9], (Toolbar) bindings[6], (ImageView) bindings[4], (ImageView) bindings[25], (ImageView) bindings[16], (ImageView) bindings[10], (LinearLayout) bindings[18], (TextView) bindings[28], (LinearLayout) bindings[27], (RecyclerView) bindings[14], (RecyclerView) bindings[13], (TextView) bindings[17], (TextView) bindings[5], (TextView) bindings[11], (ConstraintLayout) bindings[7], (TextView) bindings[3], (TextView) bindings[21], (TextView) bindings[2], (TextView) bindings[26]);
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
