package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentClubMyEventsBindingImpl extends FragmentClubMyEventsBinding {
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
        sparseIntArray.put(R.id.tobBar2, 2);
        sparseIntArray.put(R.id.imgBack, 3);
        sparseIntArray.put(R.id.tv_topBarTitle, 4);
        sparseIntArray.put(R.id.tv_editBtn, 5);
        sparseIntArray.put(R.id.tv_editDoneBtn, 6);
        sparseIntArray.put(R.id.ll_topbarTextContent, 7);
        sparseIntArray.put(R.id.tv_styckyTitle, 8);
        sparseIntArray.put(R.id.tv_stickyCount, 9);
        sparseIntArray.put(R.id.scrollView, 10);
        sparseIntArray.put(R.id.tv_all_btn, 11);
        sparseIntArray.put(R.id.tv_all_btn_text, 12);
        sparseIntArray.put(R.id.underline_all, 13);
        sparseIntArray.put(R.id.tv_created_by_me_btn, 14);
        sparseIntArray.put(R.id.tv_created_by_me_btn_text, 15);
        sparseIntArray.put(R.id.underline_created_by_me, 16);
        sparseIntArray.put(R.id.ll_ongoingWrap, 17);
        sparseIntArray.put(R.id.ongoingTotalCount, 18);
        sparseIntArray.put(R.id.recyclerViewOngoingItems, 19);
        sparseIntArray.put(R.id.ll_upcomingWrap, 20);
        sparseIntArray.put(R.id.upcomingTotalCount, 21);
        sparseIntArray.put(R.id.recyclerViewUpcomingItems, 22);
        sparseIntArray.put(R.id.ll_archiveWrap, 23);
        sparseIntArray.put(R.id.archiveTotalCount, 24);
        sparseIntArray.put(R.id.recyclerViewArchiveItems, 25);
    }

    public FragmentClubMyEventsBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 26, sIncludes, sViewsWithIds));
    }

    private FragmentClubMyEventsBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (TextView) bindings[24], (ImageView) bindings[3], (LinearLayout) bindings[23], (LinearLayout) bindings[17], (LinearLayout) bindings[7], (LinearLayout) bindings[20], (TextView) bindings[18], (RecyclerView) bindings[25], (RecyclerView) bindings[19], (RecyclerView) bindings[22], (NestedScrollView) bindings[10], (View) bindings[1], (SwipeRefreshLayout) bindings[0], (ConstraintLayout) bindings[2], (LinearLayout) bindings[11], (TextView) bindings[12], (LinearLayout) bindings[14], (TextView) bindings[15], (TextView) bindings[5], (TextView) bindings[6], (TextView) bindings[9], (TextView) bindings[8], (TextView) bindings[4], (View) bindings[13], (View) bindings[16], (TextView) bindings[21]);
        this.mDirtyFlags = -1L;
        this.swipeRefresh.setTag(null);
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
