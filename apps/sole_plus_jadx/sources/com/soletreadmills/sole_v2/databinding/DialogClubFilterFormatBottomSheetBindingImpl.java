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
public class DialogClubFilterFormatBottomSheetBindingImpl extends DialogClubFilterFormatBottomSheetBinding {
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
        sparseIntArray.put(R.id.ll_format_sharedGoal, 4);
        sparseIntArray.put(R.id.img_format_sharedGoal_check, 5);
        sparseIntArray.put(R.id.tv_format_sharedGoal_title, 6);
        sparseIntArray.put(R.id.ll_format_ranking, 7);
        sparseIntArray.put(R.id.img_format_ranking_check, 8);
        sparseIntArray.put(R.id.tv_format_ranking_title, 9);
        sparseIntArray.put(R.id.ll_format_virtualRace, 10);
        sparseIntArray.put(R.id.img_format_virtualRace_check, 11);
        sparseIntArray.put(R.id.tv_format_virtualRace_title, 12);
        sparseIntArray.put(R.id.btnDone, 13);
    }

    public DialogClubFilterFormatBottomSheetBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 14, sIncludes, sViewsWithIds));
    }

    private DialogClubFilterFormatBottomSheetBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ConstraintLayout) bindings[1], (AppCompatButton) bindings[13], (ImageView) bindings[2], (ImageView) bindings[8], (ImageView) bindings[5], (ImageView) bindings[11], (LinearLayout) bindings[7], (LinearLayout) bindings[4], (LinearLayout) bindings[10], (TextView) bindings[3], (TextView) bindings[9], (TextView) bindings[6], (TextView) bindings[12]);
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
