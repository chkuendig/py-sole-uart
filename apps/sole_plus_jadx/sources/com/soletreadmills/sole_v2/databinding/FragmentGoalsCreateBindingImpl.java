package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentGoalsCreateBindingImpl extends FragmentGoalsCreateBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final LinearLayout mboundView0;

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
        sparseIntArray.put(R.id.tv_cancelBtn, 3);
        sparseIntArray.put(R.id.tv_pageTitle, 4);
        sparseIntArray.put(R.id.tv_createBtn, 5);
        sparseIntArray.put(R.id.tv_scrollView, 6);
        sparseIntArray.put(R.id.ll_targetWrap, 7);
        sparseIntArray.put(R.id.rv_editScoreItem, 8);
        sparseIntArray.put(R.id.rv_editMachineType, 9);
        sparseIntArray.put(R.id.ll_race_distance_wrap, 10);
        sparseIntArray.put(R.id.rv_editRaceDistance, 11);
        sparseIntArray.put(R.id.ll_target_score_wrap, 12);
        sparseIntArray.put(R.id.et_target_score, 13);
        sparseIntArray.put(R.id.tv_target_score_error, 14);
        sparseIntArray.put(R.id.btn_bottom_save_create, 15);
    }

    public FragmentGoalsCreateBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 16, sIncludes, sViewsWithIds));
    }

    private FragmentGoalsCreateBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AppCompatButton) bindings[15], (EditText) bindings[13], (LinearLayout) bindings[10], (LinearLayout) bindings[12], (LinearLayout) bindings[7], (RecyclerView) bindings[9], (RecyclerView) bindings[11], (RecyclerView) bindings[8], (View) bindings[1], (ConstraintLayout) bindings[2], (TextView) bindings[3], (TextView) bindings[5], (TextView) bindings[4], (NestedScrollView) bindings[6], (TextView) bindings[14]);
        this.mDirtyFlags = -1L;
        LinearLayout linearLayout = (LinearLayout) bindings[0];
        this.mboundView0 = linearLayout;
        linearLayout.setTag(null);
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
