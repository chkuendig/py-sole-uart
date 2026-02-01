package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.VideoView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentChooseBindingImpl extends FragmentChooseBinding {
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
        sparseIntArray.put(R.id.videoView, 2);
        sparseIntArray.put(R.id.imageView2, 3);
        sparseIntArray.put(R.id.imageView3, 4);
        sparseIntArray.put(R.id.imageView4, 5);
        sparseIntArray.put(R.id.textView, 6);
        sparseIntArray.put(R.id.view, 7);
        sparseIntArray.put(R.id.LL_FB, 8);
        sparseIntArray.put(R.id.LL_Google, 9);
        sparseIntArray.put(R.id.LL_login, 10);
        sparseIntArray.put(R.id.LL_signup, 11);
        sparseIntArray.put(R.id.tvTerms, 12);
    }

    public FragmentChooseBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 13, sIncludes, sViewsWithIds));
    }

    private FragmentChooseBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[8], (LinearLayout) bindings[9], (LinearLayout) bindings[10], (LinearLayout) bindings[11], (ImageView) bindings[3], (ImageView) bindings[4], (ImageView) bindings[5], (View) bindings[1], (TextView) bindings[6], (TextView) bindings[12], (VideoView) bindings[2], (View) bindings[7]);
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
