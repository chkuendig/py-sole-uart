package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;
import androidx.appcompat.widget.Toolbar;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.google.android.material.appbar.AppBarLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentSettingsMainBindingImpl extends FragmentSettingsMainBinding {
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
        sparseIntArray.put(R.id.appBarLayout, 2);
        sparseIntArray.put(R.id.textView3, 3);
        sparseIntArray.put(R.id.collapsing_toolbar, 4);
        sparseIntArray.put(R.id.topbar, 5);
        sparseIntArray.put(R.id.title, 6);
        sparseIntArray.put(R.id.back, 7);
        sparseIntArray.put(R.id.endImg, 8);
        sparseIntArray.put(R.id.img_redCircle, 9);
        sparseIntArray.put(R.id.CL_profile, 10);
        sparseIntArray.put(R.id.cardView3, 11);
        sparseIntArray.put(R.id.img, 12);
        sparseIntArray.put(R.id.imageView14, 13);
        sparseIntArray.put(R.id.name, 14);
        sparseIntArray.put(R.id.email, 15);
        sparseIntArray.put(R.id.LL_subscription, 16);
        sparseIntArray.put(R.id.LL_getPremium, 17);
        sparseIntArray.put(R.id.LL_resetPasswordLine, 18);
        sparseIntArray.put(R.id.LL_resetPassword, 19);
        sparseIntArray.put(R.id.LL_logout, 20);
        sparseIntArray.put(R.id.LL_units, 21);
        sparseIntArray.put(R.id.txt_units, 22);
        sparseIntArray.put(R.id.LL_language, 23);
        sparseIntArray.put(R.id.txt_language, 24);
        sparseIntArray.put(R.id.LL_myFavorites, 25);
        sparseIntArray.put(R.id.LL_workoutSettings, 26);
        sparseIntArray.put(R.id.LL_notify, 27);
        sparseIntArray.put(R.id.switch_notify, 28);
        sparseIntArray.put(R.id.LL_devices, 29);
        sparseIntArray.put(R.id.LL_hrm, 30);
        sparseIntArray.put(R.id.LL_health_apps, 31);
        sparseIntArray.put(R.id.LL_appTour, 32);
        sparseIntArray.put(R.id.LL_faqSupport, 33);
        sparseIntArray.put(R.id.LL_termsOfUse, 34);
        sparseIntArray.put(R.id.LL_privacyPolicy, 35);
        sparseIntArray.put(R.id.LL_deleteAccount, 36);
        sparseIntArray.put(R.id.version_text, 37);
    }

    public FragmentSettingsMainBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 38, sIncludes, sViewsWithIds));
    }

    private FragmentSettingsMainBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (ConstraintLayout) bindings[10], (LinearLayout) bindings[32], (LinearLayout) bindings[36], (LinearLayout) bindings[29], (LinearLayout) bindings[33], (LinearLayout) bindings[17], (LinearLayout) bindings[31], (LinearLayout) bindings[30], (LinearLayout) bindings[23], (LinearLayout) bindings[20], (LinearLayout) bindings[25], (LinearLayout) bindings[27], (LinearLayout) bindings[35], (LinearLayout) bindings[19], (View) bindings[18], (LinearLayout) bindings[16], (LinearLayout) bindings[34], (LinearLayout) bindings[21], (LinearLayout) bindings[26], (AppBarLayout) bindings[2], (ImageView) bindings[7], (CardView) bindings[11], (Toolbar) bindings[4], (TextView) bindings[15], (ImageView) bindings[8], (ImageView) bindings[13], (ImageView) bindings[12], (ImageView) bindings[9], (TextView) bindings[14], (View) bindings[1], (Switch) bindings[28], (TextView) bindings[3], (TextView) bindings[6], (ConstraintLayout) bindings[5], (TextView) bindings[24], (TextView) bindings[22], (TextView) bindings[37]);
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
