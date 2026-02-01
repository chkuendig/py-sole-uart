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
public class FragmentClubMainBindingImpl extends FragmentClubMainBinding {
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
        sparseIntArray.put(R.id.tobBar, 2);
        sparseIntArray.put(R.id.title, 3);
        sparseIntArray.put(R.id.imgSearch, 4);
        sparseIntArray.put(R.id.scrollView, 5);
        sparseIntArray.put(R.id.llCreateEvent, 6);
        sparseIntArray.put(R.id.llJoinById, 7);
        sparseIntArray.put(R.id.llMyEvents, 8);
        sparseIntArray.put(R.id.ll_ongoingWrap, 9);
        sparseIntArray.put(R.id.recyclerViewOngoingItems, 10);
        sparseIntArray.put(R.id.ll_upcomingWrap, 11);
        sparseIntArray.put(R.id.recyclerViewUpcomingItems, 12);
        sparseIntArray.put(R.id.ll_virtualRaceWrap, 13);
        sparseIntArray.put(R.id.img_virtuslRacesMoreBtn, 14);
        sparseIntArray.put(R.id.recyclerViewVirtualRaceItems, 15);
        sparseIntArray.put(R.id.ll_sharedGoalsWrap, 16);
        sparseIntArray.put(R.id.img_shareGoalsMoreBtn, 17);
        sparseIntArray.put(R.id.recyclerViewsharedGoalItems, 18);
        sparseIntArray.put(R.id.ll_rankingsWrap, 19);
        sparseIntArray.put(R.id.img_rankingsMoreBtn, 20);
        sparseIntArray.put(R.id.recyclerViewRankingItems, 21);
        sparseIntArray.put(R.id.LL_virtualRaces, 22);
        sparseIntArray.put(R.id.tv_allEvent, 23);
    }

    public FragmentClubMainBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 24, sIncludes, sViewsWithIds));
    }

    private FragmentClubMainBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[22], (ImageView) bindings[20], (ImageView) bindings[4], (ImageView) bindings[17], (ImageView) bindings[14], (LinearLayout) bindings[6], (LinearLayout) bindings[7], (LinearLayout) bindings[8], (LinearLayout) bindings[9], (LinearLayout) bindings[19], (LinearLayout) bindings[16], (LinearLayout) bindings[11], (LinearLayout) bindings[13], (RecyclerView) bindings[10], (RecyclerView) bindings[21], (RecyclerView) bindings[12], (RecyclerView) bindings[15], (RecyclerView) bindings[18], (NestedScrollView) bindings[5], (View) bindings[1], (SwipeRefreshLayout) bindings[0], (TextView) bindings[3], (ConstraintLayout) bindings[2], (TextView) bindings[23]);
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
