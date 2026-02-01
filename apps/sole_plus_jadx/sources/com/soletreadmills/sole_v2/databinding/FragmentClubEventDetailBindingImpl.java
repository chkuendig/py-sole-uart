package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.widget.NestedScrollView;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.google.android.flexbox.FlexboxLayout;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentClubEventDetailBindingImpl extends FragmentClubEventDetailBinding {
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
        sparseIntArray.put(R.id.linearLayout2Wrap, 3);
        sparseIntArray.put(R.id.tobBar, 4);
        sparseIntArray.put(R.id.img_btnGoPrev, 5);
        sparseIntArray.put(R.id.tv_challengeName, 6);
        sparseIntArray.put(R.id.nestedScrollView2, 7);
        sparseIntArray.put(R.id.img_challengeTopImg, 8);
        sparseIntArray.put(R.id.img_backBtn, 9);
        sparseIntArray.put(R.id.tv_userCount, 10);
        sparseIntArray.put(R.id.ll_clubCodeWrap, 11);
        sparseIntArray.put(R.id.tv_clubCode, 12);
        sparseIntArray.put(R.id.tv_clubTitle, 13);
        sparseIntArray.put(R.id.bodyParts, 14);
        sparseIntArray.put(R.id.tv_mainValue, 15);
        sparseIntArray.put(R.id.tv_mainValueUnit, 16);
        sparseIntArray.put(R.id.tv_days, 17);
        sparseIntArray.put(R.id.tv_daysUnit, 18);
        sparseIntArray.put(R.id.ll_memberOnlyWrap, 19);
        sparseIntArray.put(R.id.pb_progressBar, 20);
        sparseIntArray.put(R.id.tv_leftTime, 21);
        sparseIntArray.put(R.id.ll_goalAreaWrap, 22);
        sparseIntArray.put(R.id.v_goalProgressWrap, 23);
        sparseIntArray.put(R.id.v_goalProgress, 24);
        sparseIntArray.put(R.id.img_area2_icon, 25);
        sparseIntArray.put(R.id.tv_goalNowVal, 26);
        sparseIntArray.put(R.id.tv_goalLine, 27);
        sparseIntArray.put(R.id.tv_goalVal, 28);
        sparseIntArray.put(R.id.tv_goalUnit, 29);
        sparseIntArray.put(R.id.ll_rankAreaWrap, 30);
        sparseIntArray.put(R.id.img_rank1Wrap, 31);
        sparseIntArray.put(R.id.img_rankAvatar1, 32);
        sparseIntArray.put(R.id.card_progress1, 33);
        sparseIntArray.put(R.id.v_rankProgress1Wrap, 34);
        sparseIntArray.put(R.id.v_rankProgress1, 35);
        sparseIntArray.put(R.id.LL_progress1, 36);
        sparseIntArray.put(R.id.tv_rankVal1, 37);
        sparseIntArray.put(R.id.tv_score1, 38);
        sparseIntArray.put(R.id.tv_scoreUnit1, 39);
        sparseIntArray.put(R.id.img_rank2Wrap, 40);
        sparseIntArray.put(R.id.img_rankAvatar2, 41);
        sparseIntArray.put(R.id.card_progress2, 42);
        sparseIntArray.put(R.id.v_rankProgress2Wrap, 43);
        sparseIntArray.put(R.id.v_rankProgress2, 44);
        sparseIntArray.put(R.id.LL_progress2, 45);
        sparseIntArray.put(R.id.tv_rankVal2, 46);
        sparseIntArray.put(R.id.tv_score2, 47);
        sparseIntArray.put(R.id.tv_scoreUnit2, 48);
        sparseIntArray.put(R.id.img_rank3Wrap, 49);
        sparseIntArray.put(R.id.img_rankAvatar3, 50);
        sparseIntArray.put(R.id.card_progress3, 51);
        sparseIntArray.put(R.id.v_rankProgress3Wrap, 52);
        sparseIntArray.put(R.id.v_rankProgress3, 53);
        sparseIntArray.put(R.id.LL_progress3, 54);
        sparseIntArray.put(R.id.tv_rankVal3, 55);
        sparseIntArray.put(R.id.tv_score3, 56);
        sparseIntArray.put(R.id.tv_scoreUnit3, 57);
        sparseIntArray.put(R.id.ll_virtualRaceAreaWrap, 58);
        sparseIntArray.put(R.id.ll_virtualRace_NotStartYet, 59);
        sparseIntArray.put(R.id.tv_raceInfoText, 60);
        sparseIntArray.put(R.id.tv_raceButton, 61);
        sparseIntArray.put(R.id.ll_virtualRace_SelfDelete, 62);
        sparseIntArray.put(R.id.img_vrRaceStatusIcon1, 63);
        sparseIntArray.put(R.id.ll_virtualRace_NotComplete, 64);
        sparseIntArray.put(R.id.img_vrRaceStatusIcon2, 65);
        sparseIntArray.put(R.id.ll_virtualRace_SingleScore, 66);
        sparseIntArray.put(R.id.img_raceIcon, 67);
        sparseIntArray.put(R.id.tv_vrScore, 68);
        sparseIntArray.put(R.id.ll_membersWrap, 69);
        sparseIntArray.put(R.id.rv_userList, 70);
        sparseIntArray.put(R.id.tv_usersMoreCountWrap, 71);
        sparseIntArray.put(R.id.tv_usersMoreCount, 72);
        sparseIntArray.put(R.id.tv_usersMoreArrowBtn, 73);
        sparseIntArray.put(R.id.tv_startDate, 74);
        sparseIntArray.put(R.id.tv_dash, 75);
        sparseIntArray.put(R.id.tv_endDate, 76);
        sparseIntArray.put(R.id.tv_equipment, 77);
        sparseIntArray.put(R.id.tv_status, 78);
        sparseIntArray.put(R.id.tv_clubFormatType, 79);
        sparseIntArray.put(R.id.tv_privacy, 80);
        sparseIntArray.put(R.id.tv_createdOwnerName, 81);
        sparseIntArray.put(R.id.tv_createDate, 82);
        sparseIntArray.put(R.id.tv_challengeDescText, 83);
        sparseIntArray.put(R.id.ll_bottomWrap, 84);
        sparseIntArray.put(R.id.ll_menu1ForOwner, 85);
        sparseIntArray.put(R.id.img_shareButtonSmall, 86);
        sparseIntArray.put(R.id.img_editButtonSmall, 87);
        sparseIntArray.put(R.id.img_deleteButtonSmall, 88);
        sparseIntArray.put(R.id.ll_menu2ForMember, 89);
        sparseIntArray.put(R.id.shareButton, 90);
        sparseIntArray.put(R.id.quitEventButton, 91);
        sparseIntArray.put(R.id.joinEventButton, 92);
    }

    public FragmentClubEventDetailBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 93, sIncludes, sViewsWithIds));
    }

    private FragmentClubEventDetailBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (LinearLayout) bindings[36], (LinearLayout) bindings[45], (LinearLayout) bindings[54], (FlexboxLayout) bindings[14], (CardView) bindings[33], (CardView) bindings[42], (CardView) bindings[51], (ImageView) bindings[25], (ImageView) bindings[9], (ImageView) bindings[5], (ImageView) bindings[8], (ImageView) bindings[88], (ImageView) bindings[87], (ImageView) bindings[67], (LinearLayout) bindings[31], (LinearLayout) bindings[40], (LinearLayout) bindings[49], (ImageView) bindings[32], (ImageView) bindings[41], (ImageView) bindings[50], (ImageView) bindings[86], (ImageView) bindings[63], (ImageView) bindings[65], (TextView) bindings[92], (ConstraintLayout) bindings[3], (LinearLayout) bindings[84], (LinearLayout) bindings[11], (LinearLayout) bindings[22], (LinearLayout) bindings[19], (LinearLayout) bindings[69], (LinearLayout) bindings[85], (LinearLayout) bindings[89], (LinearLayout) bindings[30], (LinearLayout) bindings[58], (LinearLayout) bindings[64], (LinearLayout) bindings[59], (LinearLayout) bindings[62], (LinearLayout) bindings[66], (NestedScrollView) bindings[7], (ProgressBar) bindings[20], (TextView) bindings[91], (RecyclerView) bindings[70], (LinearLayout) bindings[90], (View) bindings[1], (SwipeRefreshLayout) bindings[2], (ConstraintLayout) bindings[4], (TextView) bindings[83], (TextView) bindings[6], (TextView) bindings[12], (TextView) bindings[79], (TextView) bindings[13], (TextView) bindings[82], (TextView) bindings[81], (TextView) bindings[75], (TextView) bindings[17], (TextView) bindings[18], (TextView) bindings[76], (TextView) bindings[77], (TextView) bindings[27], (TextView) bindings[26], (TextView) bindings[29], (TextView) bindings[28], (TextView) bindings[21], (TextView) bindings[15], (TextView) bindings[16], (TextView) bindings[80], (TextView) bindings[61], (TextView) bindings[60], (TextView) bindings[37], (TextView) bindings[46], (TextView) bindings[55], (TextView) bindings[38], (TextView) bindings[47], (TextView) bindings[56], (TextView) bindings[39], (TextView) bindings[48], (TextView) bindings[57], (TextView) bindings[74], (TextView) bindings[78], (TextView) bindings[10], (ImageView) bindings[73], (TextView) bindings[72], (LinearLayout) bindings[71], (TextView) bindings[68], (View) bindings[24], (FrameLayout) bindings[23], (View) bindings[35], (FrameLayout) bindings[34], (View) bindings[44], (FrameLayout) bindings[43], (View) bindings[53], (FrameLayout) bindings[52]);
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
