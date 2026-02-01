package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentClubScoreboardListBindingImpl extends FragmentClubScoreboardListBinding {
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
        sparseIntArray.put(R.id.swipeRefresh, 2);
        sparseIntArray.put(R.id.tobBar, 3);
        sparseIntArray.put(R.id.img_btnGoPrev, 4);
        sparseIntArray.put(R.id.imgBtnCreatorCancelEdit, 5);
        sparseIntArray.put(R.id.tv_BtnCreatorDoneEdit, 6);
        sparseIntArray.put(R.id.tv_BtnCreatorEdit, 7);
        sparseIntArray.put(R.id.cl_search_wrap, 8);
        sparseIntArray.put(R.id.cl_search, 9);
        sparseIntArray.put(R.id.editEventName, 10);
        sparseIntArray.put(R.id.clearButton, 11);
        sparseIntArray.put(R.id.tv_raceCountDownTimerWrap, 12);
        sparseIntArray.put(R.id.tv_raceCountDownTimer, 13);
        sparseIntArray.put(R.id.tv_all_wrap, 14);
        sparseIntArray.put(R.id.rv_allList, 15);
        sparseIntArray.put(R.id.tv_target_reached_wrap, 16);
        sparseIntArray.put(R.id.tv_target_reached_title, 17);
        sparseIntArray.put(R.id.rv_targetReached, 18);
        sparseIntArray.put(R.id.tv_work_in_progress_wrap, 19);
        sparseIntArray.put(R.id.rv_workInProgress, 20);
    }

    public FragmentClubScoreboardListBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 21, sIncludes, sViewsWithIds));
    }

    private FragmentClubScoreboardListBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[9], (ConstraintLayout) bindings[8], (ImageView) bindings[11], (AppCompatEditText) bindings[10], (ImageView) bindings[5], (ImageView) bindings[4], (RecyclerView) bindings[15], (RecyclerView) bindings[18], (RecyclerView) bindings[20], (View) bindings[1], (SwipeRefreshLayout) bindings[2], (ConstraintLayout) bindings[3], (LinearLayout) bindings[14], (TextView) bindings[6], (TextView) bindings[7], (TextView) bindings[13], (LinearLayout) bindings[12], (TextView) bindings[17], (LinearLayout) bindings[16], (LinearLayout) bindings[19]);
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
