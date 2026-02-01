package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class AdapterClubListItemBindingImpl extends AdapterClubListItemBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;

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
        sparseIntArray.put(R.id.img_main_wrap, 1);
        sparseIntArray.put(R.id.img_main, 2);
        sparseIntArray.put(R.id.tv_memberCount, 3);
        sparseIntArray.put(R.id.img_race_wrap, 4);
        sparseIntArray.put(R.id.img_race, 5);
        sparseIntArray.put(R.id.tv_raceMemberCount, 6);
        sparseIntArray.put(R.id.tv_targetVal, 7);
        sparseIntArray.put(R.id.tv_unit, 8);
        sparseIntArray.put(R.id.tv_days_bar, 9);
        sparseIntArray.put(R.id.tv_days, 10);
        sparseIntArray.put(R.id.tv_days_unit, 11);
        sparseIntArray.put(R.id.tv_title, 12);
        sparseIntArray.put(R.id.flexboxLayout, 13);
        sparseIntArray.put(R.id.tv_equipmentAndDate, 14);
    }

    public AdapterClubListItemBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    private AdapterClubListItemBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[13], (ImageView) bindings[2], (CardView) bindings[1], (ImageView) bindings[5], (CardView) bindings[4], (LinearLayout) bindings[0], (TextView) bindings[10], (View) bindings[9], (TextView) bindings[11], (TextView) bindings[14], (TextView) bindings[3], (TextView) bindings[6], (TextView) bindings[7], (TextView) bindings[12], (TextView) bindings[8]);
        this.mDirtyFlags = -1L;
        this.llMainWrap.setTag(null);
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
