package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentBannerBindingImpl extends FragmentBannerBinding {
    private static final ViewDataBinding.IncludedLayouts sIncludes = null;
    private static final SparseIntArray sViewsWithIds;
    private long mDirtyFlags;
    private final FrameLayout mboundView0;

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
        sparseIntArray.put(R.id.bannerImg, 1);
        sparseIntArray.put(R.id.statusBarHeight, 2);
        sparseIntArray.put(R.id.topBar, 3);
        sparseIntArray.put(R.id.countDownTimeLayout, 4);
        sparseIntArray.put(R.id.countDownTime, 5);
        sparseIntArray.put(R.id.dontShowAgain, 6);
        sparseIntArray.put(R.id.msgBackground, 7);
        sparseIntArray.put(R.id.msg, 8);
        sparseIntArray.put(R.id.btn, 9);
    }

    public FragmentBannerBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 10, sIncludes, sViewsWithIds));
    }

    private FragmentBannerBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ImageView) bindings[1], (Button) bindings[9], (TextView) bindings[5], (CardView) bindings[4], (CardView) bindings[6], (TextView) bindings[8], (View) bindings[7], (View) bindings[2], (LinearLayout) bindings[3]);
        this.mDirtyFlags = -1L;
        FrameLayout frameLayout = (FrameLayout) bindings[0];
        this.mboundView0 = frameLayout;
        frameLayout.setTag(null);
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
