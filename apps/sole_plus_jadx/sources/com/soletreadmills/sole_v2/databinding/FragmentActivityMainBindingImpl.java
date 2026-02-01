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
import com.github.mikephil.charting.charts.LineChart;
import com.google.android.material.appbar.AppBarLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentActivityMainBindingImpl extends FragmentActivityMainBinding {
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
        sparseIntArray.put(R.id.textView3, 3);
        sparseIntArray.put(R.id.collapsing_toolbar, 4);
        sparseIntArray.put(R.id.topbar, 5);
        sparseIntArray.put(R.id.add, 6);
        sparseIntArray.put(R.id.title, 7);
        sparseIntArray.put(R.id.endImg, 8);
        sparseIntArray.put(R.id.tv_workoutsCount, 9);
        sparseIntArray.put(R.id.tv_totalCalories, 10);
        sparseIntArray.put(R.id.tv_activeHours, 11);
        sparseIntArray.put(R.id.tv_totalDistanceTitle, 12);
        sparseIntArray.put(R.id.tv_totalDistance, 13);
        sparseIntArray.put(R.id.LL_history, 14);
        sparseIntArray.put(R.id.img_history_arrow, 15);
        sparseIntArray.put(R.id.rv_history, 16);
        sparseIntArray.put(R.id.LL_historyEmpty, 17);
        sparseIntArray.put(R.id.LL_trainingVolume, 18);
        sparseIntArray.put(R.id.chartTitle, 19);
        sparseIntArray.put(R.id.lineChart, 20);
        sparseIntArray.put(R.id.LL_personalBest, 21);
        sparseIntArray.put(R.id.img_personal_best_arrow, 22);
        sparseIntArray.put(R.id.LL_personalBestEmpty, 23);
        sparseIntArray.put(R.id.rv_personalBest, 24);
        sparseIntArray.put(R.id.sectionsContainer, 25);
    }

    public FragmentActivityMainBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 26, sIncludes, sViewsWithIds));
    }

    private FragmentActivityMainBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[14], (LinearLayout) bindings[17], (LinearLayout) bindings[21], (LinearLayout) bindings[23], (LinearLayout) bindings[18], (ImageView) bindings[6], (AppBarLayout) bindings[2], (TextView) bindings[19], (Toolbar) bindings[4], (ImageView) bindings[8], (ImageView) bindings[15], (ImageView) bindings[22], (LineChart) bindings[20], (RecyclerView) bindings[16], (RecyclerView) bindings[24], (LinearLayout) bindings[25], (View) bindings[1], (TextView) bindings[3], (TextView) bindings[7], (ConstraintLayout) bindings[5], (TextView) bindings[11], (TextView) bindings[10], (TextView) bindings[13], (TextView) bindings[12], (TextView) bindings[9]);
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
