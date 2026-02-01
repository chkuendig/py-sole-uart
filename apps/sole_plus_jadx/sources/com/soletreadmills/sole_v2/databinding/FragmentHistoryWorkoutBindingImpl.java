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
public class FragmentHistoryWorkoutBindingImpl extends FragmentHistoryWorkoutBinding {
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
        sparseIntArray.put(R.id.appBarLayout, 2);
        sparseIntArray.put(R.id.CL_isBest, 3);
        sparseIntArray.put(R.id.img_best, 4);
        sparseIntArray.put(R.id.img, 5);
        sparseIntArray.put(R.id.tv_title, 6);
        sparseIntArray.put(R.id.tv_titleDate, 7);
        sparseIntArray.put(R.id.img_back, 8);
        sparseIntArray.put(R.id.tv_header, 9);
        sparseIntArray.put(R.id.collapsing_toolbar, 10);
        sparseIntArray.put(R.id.topbar, 11);
        sparseIntArray.put(R.id.back, 12);
        sparseIntArray.put(R.id.endImg, 13);
        sparseIntArray.put(R.id.title, 14);
        sparseIntArray.put(R.id.view2, 15);
        sparseIntArray.put(R.id.txt_date, 16);
        sparseIntArray.put(R.id.time, 17);
        sparseIntArray.put(R.id.workoutName, 18);
        sparseIntArray.put(R.id.LL_workoutInfo, 19);
        sparseIntArray.put(R.id.LL_chart, 20);
        sparseIntArray.put(R.id.LL_pace, 21);
        sparseIntArray.put(R.id.rv_pace, 22);
        sparseIntArray.put(R.id.view4, 23);
        sparseIntArray.put(R.id.LL_bottom, 24);
        sparseIntArray.put(R.id.img_delete, 25);
        sparseIntArray.put(R.id.space1, 26);
        sparseIntArray.put(R.id.LL_share, 27);
        sparseIntArray.put(R.id.tv_share, 28);
        sparseIntArray.put(R.id.space2, 29);
        sparseIntArray.put(R.id.LL_rematch, 30);
        sparseIntArray.put(R.id.imageView15, 31);
    }

    public FragmentHistoryWorkoutBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 32, sIncludes, sViewsWithIds));
    }

    private FragmentHistoryWorkoutBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ConstraintLayout) bindings[3], (LinearLayout) bindings[24], (LinearLayout) bindings[20], (LinearLayout) bindings[21], (LinearLayout) bindings[30], (LinearLayout) bindings[27], (LinearLayout) bindings[19], (AppBarLayout) bindings[2], (ImageView) bindings[12], (Toolbar) bindings[10], (ImageView) bindings[13], (ImageView) bindings[31], (ImageView) bindings[5], (ImageView) bindings[8], (ImageView) bindings[4], (ImageView) bindings[25], (RecyclerView) bindings[22], (View) bindings[26], (View) bindings[29], (View) bindings[1], (TextView) bindings[17], (TextView) bindings[14], (ConstraintLayout) bindings[11], (TextView) bindings[9], (TextView) bindings[28], (TextView) bindings[6], (TextView) bindings[7], (TextView) bindings[16], (View) bindings[15], (View) bindings[23], (TextView) bindings[18]);
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
