package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentUserSubscriptionBindingImpl extends FragmentUserSubscriptionBinding {
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
        sparseIntArray.put(R.id.topbar, 1);
        sparseIntArray.put(R.id.back, 2);
        sparseIntArray.put(R.id.endImg, 3);
        sparseIntArray.put(R.id.title, 4);
        sparseIntArray.put(R.id.LL_ALL, 5);
        sparseIntArray.put(R.id.tv_subscriptionMethod, 6);
        sparseIntArray.put(R.id.img_failed, 7);
        sparseIntArray.put(R.id.tv_fee, 8);
        sparseIntArray.put(R.id.tv_desc, 9);
        sparseIntArray.put(R.id.LL_card, 10);
        sparseIntArray.put(R.id.tv_card, 11);
        sparseIntArray.put(R.id.img_card, 12);
        sparseIntArray.put(R.id.tv_failed, 13);
        sparseIntArray.put(R.id.LL_changePlans, 14);
        sparseIntArray.put(R.id.LL_changeToOtherPlan, 15);
        sparseIntArray.put(R.id.tv_changeTitle, 16);
        sparseIntArray.put(R.id.tv_changeFee, 17);
        sparseIntArray.put(R.id.tv_changeDesc, 18);
        sparseIntArray.put(R.id.LL_seePlans, 19);
        sparseIntArray.put(R.id.LL_manageBilling, 20);
        sparseIntArray.put(R.id.view_manageBilling, 21);
        sparseIntArray.put(R.id.LL_getPremium, 22);
        sparseIntArray.put(R.id.imageView9, 23);
        sparseIntArray.put(R.id.LL_cancelSubscription, 24);
        sparseIntArray.put(R.id.LL_cancelStatus, 25);
        sparseIntArray.put(R.id.LL_removeCard, 26);
        sparseIntArray.put(R.id.line_re, 27);
        sparseIntArray.put(R.id.LL_renewSubscription, 28);
    }

    public FragmentUserSubscriptionBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 29, sIncludes, sViewsWithIds));
    }

    private FragmentUserSubscriptionBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[5], (LinearLayout) bindings[25], (LinearLayout) bindings[24], (LinearLayout) bindings[10], (LinearLayout) bindings[14], (LinearLayout) bindings[15], (LinearLayout) bindings[22], (LinearLayout) bindings[20], (LinearLayout) bindings[26], (LinearLayout) bindings[28], (LinearLayout) bindings[19], (ImageView) bindings[2], (ImageView) bindings[3], (ImageView) bindings[23], (ImageView) bindings[12], (ImageView) bindings[7], (View) bindings[27], (TextView) bindings[4], (ConstraintLayout) bindings[1], (TextView) bindings[11], (TextView) bindings[18], (TextView) bindings[17], (TextView) bindings[16], (TextView) bindings[9], (TextView) bindings[13], (TextView) bindings[8], (TextView) bindings[6], (View) bindings[21]);
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
