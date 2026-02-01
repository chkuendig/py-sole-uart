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
import com.soletreadmills.sole_v2.ui.widget.AnimatedPathImageView;

/* loaded from: classes5.dex */
public class FragmentClubRaceBindingImpl extends FragmentClubRaceBinding {
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
        sparseIntArray.put(R.id.linearLayout17, 5);
        sparseIntArray.put(R.id.LL_leave, 6);
        sparseIntArray.put(R.id.img_leave, 7);
        sparseIntArray.put(R.id.ble_machine, 8);
        sparseIntArray.put(R.id.ble_watch, 9);
        sparseIntArray.put(R.id.img_machine, 10);
        sparseIntArray.put(R.id.img_watch, 11);
        sparseIntArray.put(R.id.layout_display1, 12);
        sparseIntArray.put(R.id.tv_display1Title, 13);
        sparseIntArray.put(R.id.layout_display1Click, 14);
        sparseIntArray.put(R.id.img_display1, 15);
        sparseIntArray.put(R.id.tv_display1, 16);
        sparseIntArray.put(R.id.tv_display2Title, 17);
        sparseIntArray.put(R.id.layout_display2Click, 18);
        sparseIntArray.put(R.id.img_display2, 19);
        sparseIntArray.put(R.id.tv_display2, 20);
        sparseIntArray.put(R.id.layout_distance, 21);
        sparseIntArray.put(R.id.tv_distance, 22);
        sparseIntArray.put(R.id.tv_lap, 23);
        sparseIntArray.put(R.id.linearLayout18, 24);
        sparseIntArray.put(R.id.layout_start, 25);
        sparseIntArray.put(R.id.start, 26);
        sparseIntArray.put(R.id.layout_display2, 27);
        sparseIntArray.put(R.id.tv_display3Title, 28);
        sparseIntArray.put(R.id.layout_display3Click, 29);
        sparseIntArray.put(R.id.img_display3, 30);
        sparseIntArray.put(R.id.tv_display3, 31);
        sparseIntArray.put(R.id.tv_display4Title, 32);
        sparseIntArray.put(R.id.layout_display4Click, 33);
        sparseIntArray.put(R.id.img_display4, 34);
        sparseIntArray.put(R.id.tv_display4, 35);
        sparseIntArray.put(R.id.progressBar, 36);
        sparseIntArray.put(R.id.layout_topView, 37);
        sparseIntArray.put(R.id.tv_startOrFinish, 38);
    }

    public FragmentClubRaceBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 39, sIncludes, sViewsWithIds));
    }

    private FragmentClubRaceBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[6], (AnimatedPathImageView) bindings[2], (ImageView) bindings[8], (ImageView) bindings[9], (ImageView) bindings[15], (ImageView) bindings[19], (ImageView) bindings[30], (ImageView) bindings[34], (ImageView) bindings[7], (ImageView) bindings[10], (ImageView) bindings[4], (ImageView) bindings[3], (ImageView) bindings[11], (LinearLayout) bindings[12], (LinearLayout) bindings[14], (LinearLayout) bindings[27], (LinearLayout) bindings[18], (LinearLayout) bindings[29], (LinearLayout) bindings[33], (LinearLayout) bindings[21], (LinearLayout) bindings[25], (ConstraintLayout) bindings[37], null, null, (LinearLayout) bindings[5], (LinearLayout) bindings[24], (ProgressBar) bindings[36], (LinearLayout) bindings[26], (View) bindings[1], (TextView) bindings[16], (TextView) bindings[13], (TextView) bindings[20], (TextView) bindings[17], (TextView) bindings[31], (TextView) bindings[28], (TextView) bindings[35], (TextView) bindings[32], (TextView) bindings[22], (TextView) bindings[23], (TextView) bindings[38]);
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
