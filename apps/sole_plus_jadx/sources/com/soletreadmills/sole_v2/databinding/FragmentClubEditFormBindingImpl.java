package com.soletreadmills.sole_v2.databinding;

import android.util.SparseIntArray;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatButton;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.databinding.DataBindingComponent;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import com.soletreadmills.sole_v2.R;

/* loaded from: classes5.dex */
public class FragmentClubEditFormBindingImpl extends FragmentClubEditFormBinding {
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
        sparseIntArray.put(R.id.tv_cancelBtn, 3);
        sparseIntArray.put(R.id.tv_pageTitle, 4);
        sparseIntArray.put(R.id.tv_saveEditBtn, 5);
        sparseIntArray.put(R.id.tv_createBtn, 6);
        sparseIntArray.put(R.id.ll_photoWrap, 7);
        sparseIntArray.put(R.id.challenge_form_take_photo_wrap, 8);
        sparseIntArray.put(R.id.challenge_form_make_photo_btn, 9);
        sparseIntArray.put(R.id.challenge_form_select_photo_btn, 10);
        sparseIntArray.put(R.id.challenge_form_preview_photo_wrap, 11);
        sparseIntArray.put(R.id.challenge_form_clear_photo_btn, 12);
        sparseIntArray.put(R.id.challenge_form_preview_photo, 13);
        sparseIntArray.put(R.id.challenge_form_take_photo_error, 14);
        sparseIntArray.put(R.id.et_event_name, 15);
        sparseIntArray.put(R.id.tv_event_name_error, 16);
        sparseIntArray.put(R.id.et_event_description, 17);
        sparseIntArray.put(R.id.tv_event_description_error, 18);
        sparseIntArray.put(R.id.ll_targetWrap, 19);
        sparseIntArray.put(R.id.rv_editScoreItem, 20);
        sparseIntArray.put(R.id.ll_target_score_wrap, 21);
        sparseIntArray.put(R.id.et_target_score, 22);
        sparseIntArray.put(R.id.tv_target_score_error, 23);
        sparseIntArray.put(R.id.ll_datesWrap, 24);
        sparseIntArray.put(R.id.challenge_form_start_date_time_format, 25);
        sparseIntArray.put(R.id.et_date_start, 26);
        sparseIntArray.put(R.id.challenge_form_end_date_time_format, 27);
        sparseIntArray.put(R.id.et_date_end, 28);
        sparseIntArray.put(R.id.et_dateCount, 29);
        sparseIntArray.put(R.id.img_minus_day, 30);
        sparseIntArray.put(R.id.img_plus_day, 31);
        sparseIntArray.put(R.id.rv_editMachineType, 32);
        sparseIntArray.put(R.id.ll_race_distance_wrap, 33);
        sparseIntArray.put(R.id.img_raceDistance, 34);
        sparseIntArray.put(R.id.rv_editRaceDistance, 35);
        sparseIntArray.put(R.id.ll_race_date_wrap, 36);
        sparseIntArray.put(R.id.et_virtual_race_date_start, 37);
        sparseIntArray.put(R.id.ll_privacyWrap, 38);
        sparseIntArray.put(R.id.rv_editPravicy, 39);
        sparseIntArray.put(R.id.btn_bottom_save_edit, 40);
        sparseIntArray.put(R.id.btn_bottom_save_create, 41);
    }

    public FragmentClubEditFormBindingImpl(DataBindingComponent bindingComponent, View root) {
        this(bindingComponent, root, mapBindings(bindingComponent, root, 42, sIncludes, sViewsWithIds));
    }

    private FragmentClubEditFormBindingImpl(DataBindingComponent bindingComponent, View root, Object[] bindings) {
        super(bindingComponent, root, 0, (AppCompatButton) bindings[41], (AppCompatButton) bindings[40], (ImageView) bindings[12], (TextView) bindings[27], (LinearLayout) bindings[9], (ImageView) bindings[13], (LinearLayout) bindings[11], (LinearLayout) bindings[10], (TextView) bindings[25], (TextView) bindings[14], (LinearLayout) bindings[8], (EditText) bindings[29], (EditText) bindings[28], (EditText) bindings[26], (EditText) bindings[17], (EditText) bindings[15], (EditText) bindings[22], (EditText) bindings[37], (ImageView) bindings[30], (ImageView) bindings[31], (ImageView) bindings[34], (LinearLayout) bindings[24], (LinearLayout) bindings[7], (LinearLayout) bindings[38], (LinearLayout) bindings[36], (LinearLayout) bindings[33], (LinearLayout) bindings[21], (LinearLayout) bindings[19], (RecyclerView) bindings[32], (RecyclerView) bindings[39], (RecyclerView) bindings[35], (RecyclerView) bindings[20], (View) bindings[1], (ConstraintLayout) bindings[2], (TextView) bindings[3], (TextView) bindings[6], (TextView) bindings[18], (TextView) bindings[16], (TextView) bindings[4], (TextView) bindings[5], (TextView) bindings[23]);
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
