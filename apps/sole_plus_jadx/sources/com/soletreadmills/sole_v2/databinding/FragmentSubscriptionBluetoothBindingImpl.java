package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentSubscriptionBluetoothBindingImpl extends FragmentSubscriptionBluetoothBinding {
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
        sparseIntArray.put(R.id.back, 3);
        sparseIntArray.put(R.id.viaSnLayout, 4);
        sparseIntArray.put(R.id.serialNumber, 5);
        sparseIntArray.put(R.id.img_camera, 6);
        sparseIntArray.put(R.id.submit, 7);
        sparseIntArray.put(R.id.iLostMyNumber, 8);
        sparseIntArray.put(R.id.viaBleLayout, 9);
        sparseIntArray.put(R.id.bleDevice, 10);
        sparseIntArray.put(R.id.CL_add, 11);
        sparseIntArray.put(R.id.imageView12, 12);
        sparseIntArray.put(R.id.classTypeName, 13);
        sparseIntArray.put(R.id.useSerialNumber, 14);
    }

    public FragmentSubscriptionBluetoothBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    private FragmentSubscriptionBluetoothBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ConstraintLayout) bindings[11], (ImageView) bindings[3], (ConstraintLayout) bindings[10], (TextView) bindings[13], (AppCompatTextView) bindings[8], (ImageView) bindings[12], (ImageView) bindings[6], (EditText) bindings[5], (View) bindings[1], (Button) bindings[7], (LinearLayout) bindings[2], (TextView) bindings[14], (LinearLayout) bindings[9], (LinearLayout) bindings[4]);
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
