package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.LinearLayoutCompat;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class DialogClubFilterDurationBottomSheetBindingImpl extends DialogClubFilterDurationBottomSheetBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayoutCompat mboundView0;

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
        sparseIntArray.put(R.id.CL_title, 1);
        sparseIntArray.put(R.id.imgBack, 2);
        sparseIntArray.put(R.id.title, 3);
        sparseIntArray.put(R.id.LL_day1, 4);
        sparseIntArray.put(R.id.LL_day2, 5);
        sparseIntArray.put(R.id.LL_day3, 6);
        sparseIntArray.put(R.id.LL_months1, 7);
        sparseIntArray.put(R.id.LL_months2, 8);
        sparseIntArray.put(R.id.LL_months3, 9);
        sparseIntArray.put(R.id.btn_done, 10);
    }

    public DialogClubFilterDurationBottomSheetBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 11, sIncludes, sViewsWithIds));
    }

    private DialogClubFilterDurationBottomSheetBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ConstraintLayout) bindings[1], (LinearLayout) bindings[4], (LinearLayout) bindings[5], (LinearLayout) bindings[6], (LinearLayout) bindings[7], (LinearLayout) bindings[8], (LinearLayout) bindings[9], (AppCompatButton) bindings[10], (ImageView) bindings[2], (TextView) bindings[3]);
        this.mDirtyFlags = -1L;
        LinearLayoutCompat linearLayoutCompat = (LinearLayoutCompat) bindings[0];
        this.mboundView0 = linearLayoutCompat;
        linearLayoutCompat.setTag(null);
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
