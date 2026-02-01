package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentClubAllEventsBindingImpl extends FragmentClubAllEventsBinding {
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
        sparseIntArray.put(R.id.imgBack, 3);
        sparseIntArray.put(R.id.imgSearch, 4);
        sparseIntArray.put(R.id.LL_format, 5);
        sparseIntArray.put(R.id.tv_formatCount, 6);
        sparseIntArray.put(R.id.tv_formatTitle, 7);
        sparseIntArray.put(R.id.img_format, 8);
        sparseIntArray.put(R.id.LL_equipment, 9);
        sparseIntArray.put(R.id.tv_equipmentCount, 10);
        sparseIntArray.put(R.id.tv_equipmentTitle, 11);
        sparseIntArray.put(R.id.img_equipment, 12);
        sparseIntArray.put(R.id.LL_duration, 13);
        sparseIntArray.put(R.id.tv_durationCount, 14);
        sparseIntArray.put(R.id.tv_durationTitle, 15);
        sparseIntArray.put(R.id.img_duration, 16);
        sparseIntArray.put(R.id.LL_target, 17);
        sparseIntArray.put(R.id.tv_targetCount, 18);
        sparseIntArray.put(R.id.tv_targetTitle, 19);
        sparseIntArray.put(R.id.img_target, 20);
        sparseIntArray.put(R.id.LL_results, 21);
        sparseIntArray.put(R.id.txt_resultsCount, 22);
        sparseIntArray.put(R.id.img_clear, 23);
        sparseIntArray.put(R.id.txt_filterCount, 24);
        sparseIntArray.put(R.id.rv, 25);
    }

    public FragmentClubAllEventsBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 26, sIncludes, sViewsWithIds));
    }

    private FragmentClubAllEventsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[13], (LinearLayout) bindings[9], (LinearLayout) bindings[5], (LinearLayout) bindings[21], (LinearLayout) bindings[17], (ImageView) bindings[3], (ImageView) bindings[23], (ImageView) bindings[16], (ImageView) bindings[12], (ImageView) bindings[8], (ImageView) bindings[4], (ImageView) bindings[20], (RecyclerView) bindings[25], (View) bindings[1], (ConstraintLayout) bindings[2], (TextView) bindings[14], (TextView) bindings[15], (TextView) bindings[10], (TextView) bindings[11], (TextView) bindings[6], (TextView) bindings[7], (TextView) bindings[18], (TextView) bindings[19], (TextView) bindings[24], (TextView) bindings[22]);
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
