package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.Switch;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentWorkoutSettingsBindingImpl extends FragmentWorkoutSettingsBinding {
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
        sparseIntArray.put(R.id.linearLayout7, 2);
        sparseIntArray.put(R.id.done, 3);
        sparseIntArray.put(R.id.title, 4);
        sparseIntArray.put(R.id.reset, 5);
        sparseIntArray.put(R.id.LL_targetTime, 6);
        sparseIntArray.put(R.id.tv_targetTime, 7);
        sparseIntArray.put(R.id.LL_maxSpeed, 8);
        sparseIntArray.put(R.id.tv_maxSpeed, 9);
        sparseIntArray.put(R.id.LL_maxResistance, 10);
        sparseIntArray.put(R.id.tv_maxResistance, 11);
        sparseIntArray.put(R.id.LL_rotateAutomatically, 12);
        sparseIntArray.put(R.id.switch_automatically, 13);
        sparseIntArray.put(R.id.LL_rotateEvery, 14);
        sparseIntArray.put(R.id.tv_rotateEvery, 15);
        sparseIntArray.put(R.id.switch_showSubtitles, 16);
        sparseIntArray.put(R.id.LL_language, 17);
        sparseIntArray.put(R.id.language, 18);
        sparseIntArray.put(R.id.volumeValue, 19);
        sparseIntArray.put(R.id.imageView20, 20);
        sparseIntArray.put(R.id.seekBar, 21);
        sparseIntArray.put(R.id.imageView21, 22);
    }

    public FragmentWorkoutSettingsBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 23, sIncludes, sViewsWithIds));
    }

    private FragmentWorkoutSettingsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[17], (LinearLayout) bindings[10], (LinearLayout) bindings[8], (LinearLayout) bindings[12], (LinearLayout) bindings[14], (LinearLayout) bindings[6], (TextView) bindings[3], (ImageView) bindings[20], (ImageView) bindings[22], (TextView) bindings[18], (LinearLayout) bindings[2], (TextView) bindings[5], (SeekBar) bindings[21], (View) bindings[1], (Switch) bindings[13], (Switch) bindings[16], (TextView) bindings[4], (TextView) bindings[11], (TextView) bindings[9], (TextView) bindings[15], (TextView) bindings[7], (TextView) bindings[19]);
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
