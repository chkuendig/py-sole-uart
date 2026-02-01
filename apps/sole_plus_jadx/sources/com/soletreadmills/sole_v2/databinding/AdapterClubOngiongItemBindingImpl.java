package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class AdapterClubOngiongItemBindingImpl extends AdapterClubOngiongItemBinding {
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
        sparseIntArray.put(R.id.img_ongoingThumb, 1);
        sparseIntArray.put(R.id.img_ongoingTitle, 2);
        sparseIntArray.put(R.id.img_ongoingProcessVal, 3);
        sparseIntArray.put(R.id.avatarIcon, 4);
        sparseIntArray.put(R.id.participantCount, 5);
        sparseIntArray.put(R.id.progressBar, 6);
        sparseIntArray.put(R.id.img_ongoingLeftTimeVal, 7);
        sparseIntArray.put(R.id.ll_virtualRaceAreaWrap, 8);
        sparseIntArray.put(R.id.ll_virtualRace_NotStartYet, 9);
        sparseIntArray.put(R.id.ll_virtualRace_NotStartYet_time, 10);
        sparseIntArray.put(R.id.tv_raceButton, 11);
        sparseIntArray.put(R.id.ll_virtualRace_SelfDelete, 12);
        sparseIntArray.put(R.id.img_vrRaceStatusIcon1, 13);
        sparseIntArray.put(R.id.ll_virtualRace_NotComplete, 14);
        sparseIntArray.put(R.id.img_vrRaceStatusIcon2, 15);
        sparseIntArray.put(R.id.ll_virtualRace_SingleScore, 16);
        sparseIntArray.put(R.id.img_raceIcon, 17);
        sparseIntArray.put(R.id.tv_vrScore, 18);
        sparseIntArray.put(R.id.ll_goalAreaWrap, 19);
        sparseIntArray.put(R.id.v_goalProgressWrap, 20);
        sparseIntArray.put(R.id.v_goalProgress, 21);
        sparseIntArray.put(R.id.img_area2_icon, 22);
        sparseIntArray.put(R.id.tv_goalNowVal, 23);
        sparseIntArray.put(R.id.tv_goalLine, 24);
        sparseIntArray.put(R.id.tv_goalVal, 25);
        sparseIntArray.put(R.id.tv_goalUnit, 26);
        sparseIntArray.put(R.id.ll_rankAreaWrap, 27);
        sparseIntArray.put(R.id.img_rank1Wrap, 28);
        sparseIntArray.put(R.id.img_rankAvatar1, 29);
        sparseIntArray.put(R.id.card_progress1, 30);
        sparseIntArray.put(R.id.v_rankProgress1Wrap, 31);
        sparseIntArray.put(R.id.v_rankProgress1, 32);
        sparseIntArray.put(R.id.LL_progress1, 33);
        sparseIntArray.put(R.id.tv_rankVal1, 34);
        sparseIntArray.put(R.id.tv_score1, 35);
        sparseIntArray.put(R.id.tv_scoreUnit1, 36);
        sparseIntArray.put(R.id.img_rank2Wrap, 37);
        sparseIntArray.put(R.id.img_rankAvatar2, 38);
        sparseIntArray.put(R.id.card_progress2, 39);
        sparseIntArray.put(R.id.v_rankProgress2Wrap, 40);
        sparseIntArray.put(R.id.v_rankProgress2, 41);
        sparseIntArray.put(R.id.LL_progress2, 42);
        sparseIntArray.put(R.id.tv_rankVal2, 43);
        sparseIntArray.put(R.id.tv_score2, 44);
        sparseIntArray.put(R.id.tv_scoreUnit2, 45);
        sparseIntArray.put(R.id.img_rank3Wrap, 46);
        sparseIntArray.put(R.id.img_rankAvatar3, 47);
        sparseIntArray.put(R.id.card_progress3, 48);
        sparseIntArray.put(R.id.v_rankProgress3Wrap, 49);
        sparseIntArray.put(R.id.v_rankProgress3, 50);
        sparseIntArray.put(R.id.LL_progress3, 51);
        sparseIntArray.put(R.id.tv_rankVal3, 52);
        sparseIntArray.put(R.id.tv_score3, 53);
        sparseIntArray.put(R.id.tv_scoreUnit3, 54);
    }

    public AdapterClubOngiongItemBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 55, sIncludes, sViewsWithIds));
    }

    private AdapterClubOngiongItemBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[33], (LinearLayout) bindings[42], (LinearLayout) bindings[51], (ImageView) bindings[4], (CardView) bindings[30], (CardView) bindings[39], (CardView) bindings[48], (CardView) bindings[0], (ImageView) bindings[22], (TextView) bindings[7], (TextView) bindings[3], (ImageView) bindings[1], (TextView) bindings[2], (ImageView) bindings[17], (LinearLayout) bindings[28], (LinearLayout) bindings[37], (LinearLayout) bindings[46], (ImageView) bindings[29], (ImageView) bindings[38], (ImageView) bindings[47], (ImageView) bindings[13], (ImageView) bindings[15], (LinearLayout) bindings[19], (LinearLayout) bindings[27], (LinearLayout) bindings[8], (LinearLayout) bindings[14], (LinearLayout) bindings[9], (TextView) bindings[10], (LinearLayout) bindings[12], (LinearLayout) bindings[16], (TextView) bindings[5], (ProgressBar) bindings[6], (TextView) bindings[24], (TextView) bindings[23], (TextView) bindings[26], (TextView) bindings[25], (TextView) bindings[11], (TextView) bindings[34], (TextView) bindings[43], (TextView) bindings[52], (TextView) bindings[35], (TextView) bindings[44], (TextView) bindings[53], (TextView) bindings[36], (TextView) bindings[45], (TextView) bindings[54], (TextView) bindings[18], (View) bindings[21], (FrameLayout) bindings[20], (View) bindings[32], (FrameLayout) bindings[31], (View) bindings[41], (FrameLayout) bindings[40], (View) bindings[50], (FrameLayout) bindings[49]);
        this.mDirtyFlags = -1L;
        this.cvOngoingCard.setTag(null);
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
