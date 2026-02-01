package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.journeyapps.barcodescanner.BarcodeView;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentQrcodeBindingImpl extends FragmentQrcodeBinding {
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
        sparseIntArray.put(R.id.statusBarHeight, 1);
        sparseIntArray.put(R.id.topbar, 2);
        sparseIntArray.put(R.id.cancel, 3);
        sparseIntArray.put(R.id.barcode_view, 4);
        sparseIntArray.put(R.id.mask_top, 5);
        sparseIntArray.put(R.id.mask_bottom, 6);
        sparseIntArray.put(R.id.mask_left, 7);
        sparseIntArray.put(R.id.mask_right, 8);
        sparseIntArray.put(R.id.scan_frame, 9);
        sparseIntArray.put(R.id.linearLayout3, 10);
        sparseIntArray.put(R.id.textView3, 11);
        sparseIntArray.put(R.id.layout_help, 12);
        sparseIntArray.put(R.id.imageView8, 13);
        sparseIntArray.put(R.id.tv_help, 14);
    }

    public FragmentQrcodeBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 15, sIncludes, sViewsWithIds));
    }

    private FragmentQrcodeBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (BarcodeView) bindings[4], (TextView) bindings[3], (ImageView) bindings[13], (LinearLayout) bindings[12], (LinearLayout) bindings[10], (View) bindings[6], (View) bindings[7], (View) bindings[8], (View) bindings[5], (ConstraintLayout) bindings[0], (View) bindings[9], (View) bindings[1], (TextView) bindings[11], (ConstraintLayout) bindings[2], (TextView) bindings[14]);
        this.mDirtyFlags = -1L;
        this.qrRoot.setTag(null);
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
