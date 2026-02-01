package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class CustomSelectActivityBindingImpl extends CustomSelectActivityBinding {
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
        sparseIntArray.put(R.id.close, 1);
        sparseIntArray.put(R.id.title, 2);
        sparseIntArray.put(R.id.reset, 3);
        sparseIntArray.put(R.id.LL_treadmill, 4);
        sparseIntArray.put(R.id.img_treadmill, 5);
        sparseIntArray.put(R.id.tv_treadmill, 6);
        sparseIntArray.put(R.id.LL_cycling, 7);
        sparseIntArray.put(R.id.img_cycling, 8);
        sparseIntArray.put(R.id.tv_cycling, 9);
        sparseIntArray.put(R.id.LL_elliptical, 10);
        sparseIntArray.put(R.id.img_elliptical, 11);
        sparseIntArray.put(R.id.tv_elliptical, 12);
        sparseIntArray.put(R.id.LL_rowing, 13);
        sparseIntArray.put(R.id.img_rowing, 14);
        sparseIntArray.put(R.id.tv_rowing, 15);
        sparseIntArray.put(R.id.LL_fullSweat, 16);
        sparseIntArray.put(R.id.img_fullSweat, 17);
        sparseIntArray.put(R.id.tv_fullSweat, 18);
        sparseIntArray.put(R.id.LL_boxing, 19);
        sparseIntArray.put(R.id.img_boxing, 20);
        sparseIntArray.put(R.id.tv_boxing, 21);
        sparseIntArray.put(R.id.LL_sculpt, 22);
        sparseIntArray.put(R.id.img_sculpt, 23);
        sparseIntArray.put(R.id.tv_sculpt, 24);
        sparseIntArray.put(R.id.LL_stretching, 25);
        sparseIntArray.put(R.id.img_stretching, 26);
        sparseIntArray.put(R.id.tv_stretching, 27);
        sparseIntArray.put(R.id.LL_yoga, 28);
        sparseIntArray.put(R.id.img_yoga, 29);
        sparseIntArray.put(R.id.tv_yoga, 30);
        sparseIntArray.put(R.id.LL_meditation, 31);
        sparseIntArray.put(R.id.img_meditation, 32);
        sparseIntArray.put(R.id.tv_meditation, 33);
        sparseIntArray.put(R.id.LL_done, 34);
        sparseIntArray.put(R.id.done, 35);
    }

    public CustomSelectActivityBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 36, sIncludes, sViewsWithIds));
    }

    private CustomSelectActivityBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[19], (LinearLayout) bindings[7], (LinearLayout) bindings[34], (LinearLayout) bindings[10], (LinearLayout) bindings[16], (LinearLayout) bindings[31], (LinearLayout) bindings[13], (LinearLayout) bindings[22], (LinearLayout) bindings[25], (LinearLayout) bindings[4], (LinearLayout) bindings[28], (AppCompatImageView) bindings[1], (TextView) bindings[35], (ImageView) bindings[20], (ImageView) bindings[8], (ImageView) bindings[11], (ImageView) bindings[17], (ImageView) bindings[32], (ImageView) bindings[14], (ImageView) bindings[23], (ImageView) bindings[26], (ImageView) bindings[5], (ImageView) bindings[29], (TextView) bindings[3], (TextView) bindings[2], (TextView) bindings[21], (TextView) bindings[9], (TextView) bindings[12], (TextView) bindings[18], (TextView) bindings[33], (TextView) bindings[15], (TextView) bindings[24], (TextView) bindings[27], (TextView) bindings[6], (TextView) bindings[30]);
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
