package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2.ui.widget.AnimatedPathImgForLoop;

/* loaded from: classes5.dex */
public class FragmentRematchBindingLandImpl extends FragmentRematchBinding {
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
        sparseIntArray.put(R.id.animatedPathImageView, 2);
        sparseIntArray.put(R.id.img_shadowTop, 3);
        sparseIntArray.put(R.id.img_shadowBottom, 4);
        sparseIntArray.put(R.id.linearLayout14, 5);
        sparseIntArray.put(R.id.LL_leave, 6);
        sparseIntArray.put(R.id.img_leave, 7);
        sparseIntArray.put(R.id.ble_machine, 8);
        sparseIntArray.put(R.id.ble_watch, 9);
        sparseIntArray.put(R.id.img_machine, 10);
        sparseIntArray.put(R.id.img_watch, 11);
        sparseIntArray.put(R.id.tv_display1Title, 12);
        sparseIntArray.put(R.id.layout_display1Click, 13);
        sparseIntArray.put(R.id.img_display1, 14);
        sparseIntArray.put(R.id.tv_display1, 15);
        sparseIntArray.put(R.id.tv_display2Title, 16);
        sparseIntArray.put(R.id.layout_display2Click, 17);
        sparseIntArray.put(R.id.img_display2, 18);
        sparseIntArray.put(R.id.tv_display2, 19);
        sparseIntArray.put(R.id.layout_distance, 20);
        sparseIntArray.put(R.id.tv_distance, 21);
        sparseIntArray.put(R.id.tv_lap, 22);
        sparseIntArray.put(R.id.linearLayout15, 23);
        sparseIntArray.put(R.id.tv_display3Title, 24);
        sparseIntArray.put(R.id.layout_display3Click, 25);
        sparseIntArray.put(R.id.img_display3, 26);
        sparseIntArray.put(R.id.tv_display3, 27);
        sparseIntArray.put(R.id.tv_display4Title, 28);
        sparseIntArray.put(R.id.layout_display4Click, 29);
        sparseIntArray.put(R.id.img_display4, 30);
        sparseIntArray.put(R.id.tv_display4, 31);
        sparseIntArray.put(R.id.progressBar, 32);
    }

    public FragmentRematchBindingLandImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 33, sIncludes, sViewsWithIds));
    }

    private FragmentRematchBindingLandImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[6], (AnimatedPathImgForLoop) bindings[2], (ImageView) bindings[8], (ImageView) bindings[9], (ImageView) bindings[14], (ImageView) bindings[18], (ImageView) bindings[26], (ImageView) bindings[30], (ImageView) bindings[7], (ImageView) bindings[10], (ImageView) bindings[4], (ImageView) bindings[3], (ImageView) bindings[11], null, (LinearLayout) bindings[13], null, (LinearLayout) bindings[17], (LinearLayout) bindings[25], (LinearLayout) bindings[29], (LinearLayout) bindings[20], null, null, (LinearLayout) bindings[5], (LinearLayout) bindings[23], null, null, (ProgressBar) bindings[32], null, (View) bindings[1], (TextView) bindings[15], (TextView) bindings[12], (TextView) bindings[19], (TextView) bindings[16], (TextView) bindings[27], (TextView) bindings[24], (TextView) bindings[31], (TextView) bindings[28], (TextView) bindings[21], (TextView) bindings[22], null);
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
