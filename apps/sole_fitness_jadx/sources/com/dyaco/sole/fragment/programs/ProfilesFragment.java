package com.dyaco.sole.fragment.programs;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.activity.CaloriesSettingDialog;
import com.dyaco.sole.activity.MainActivity;
import com.dyaco.sole.custom.DeviceModelList;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.ProtocolHandler;
import com.dyaco.sole.custom_view.TypefaceTextView;
import com.dyaco.sole.fragment.BaseFragment;
import com.dyaco.sole.fragment.programs.ProfileFrameLayout;
import com.soletreadmills.sole.R;
import java.io.IOException;
import java.util.List;

/* loaded from: classes.dex */
public class ProfilesFragment extends BaseFragment implements View.OnClickListener, ProtocolHandler.OnDataResultListener, ProfileFrameLayout.OnSettingClickListener {
    public static final int PROGRAMS_PROFILE_1 = 65;
    public static final int PROGRAMS_PROFILE_10 = 74;
    public static final int PROGRAMS_PROFILE_11 = 75;
    public static final int PROGRAMS_PROFILE_12 = 76;
    public static final int PROGRAMS_PROFILE_2 = 66;
    public static final int PROGRAMS_PROFILE_3 = 67;
    public static final int PROGRAMS_PROFILE_4 = 68;
    public static final int PROGRAMS_PROFILE_5 = 69;
    public static final int PROGRAMS_PROFILE_6 = 70;
    public static final int PROGRAMS_PROFILE_7 = 71;
    public static final int PROGRAMS_PROFILE_8 = 72;
    public static final int PROGRAMS_PROFILE_9 = 73;
    public static final String TAG = "SOLE-ProfilesFragment";
    private MainActivity activity;
    private FrameLayout content_layout;
    private int nowProgramPosition;
    private long pressStartTime;
    private ProfileFrameLayout[] profileViews;
    private TableLayout programs_tablelayout;
    private View rootView;
    private int selectedImageRid;
    private TypefaceTextView setting_start_textview;
    private int unselectedImageRid;

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) throws Resources.NotFoundException {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.activity = (MainActivity) getActivity();
        int i = Global.BRAND;
        if (i == 0) {
            this.rootView = layoutInflater.inflate(R.layout.fragment_programs_profiles, viewGroup, false);
            this.selectedImageRid = R.drawable.all_btn_a_03;
            this.unselectedImageRid = R.drawable.all_btn_a_02;
        } else if (i == 1) {
            this.rootView = layoutInflater.inflate(R.layout.s_fragment_programs_profiles, viewGroup, false);
            this.selectedImageRid = R.drawable.s_all_btn_a_03;
            this.unselectedImageRid = R.drawable.s_all_btn_a_02;
        } else if (i == 2 || i == 3) {
            this.rootView = layoutInflater.inflate(R.layout.s_fragment_programs_profiles, viewGroup, false);
            this.selectedImageRid = R.drawable.x_all_btn_a_03;
            this.unselectedImageRid = R.drawable.s_all_btn_a_02;
        }
        findViews();
        initParams();
        setListeners();
        return this.rootView;
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z) throws Resources.NotFoundException {
        super.onHiddenChanged(z);
        Log.d(TAG, "onHiddenChanged~~~~" + z);
        if (z) {
            return;
        }
        handleDeviceModelView();
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void findViews() {
        this.programs_tablelayout = (TableLayout) this.rootView.findViewById(R.id.programs_tablelayout);
        int i = Global.BRAND;
        if (i == 1 || i == 2 || i == 3) {
            this.setting_start_textview = (TypefaceTextView) this.rootView.findViewById(R.id.setting_start_textview);
        }
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void initParams() throws Resources.NotFoundException {
        ProtocolHandler.protocol.addOnDataResultListener(this);
        Log.d(TAG, "initParams~~~~");
        handleDeviceModelView();
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void setListeners() {
        int i = Global.BRAND;
        if (i == 1 || i == 2 || i == 3) {
            this.setting_start_textview.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        ErrorLogSave.addErrorString(getActivity(), ErrorLogSave.CLICK, "ProfilesFragment_onClick", "click_id:" + view.getId());
        int id = view.getId();
        if (id == R.id.setting_start_textview) {
            if (System.currentTimeMillis() - this.pressStartTime > 2000) {
                this.pressStartTime = System.currentTimeMillis();
                this.profileViews[this.nowProgramPosition - 65].startWorkout();
            }
            return;
        }
        switch (id) {
            case 0:
                this.activity.switchFragment(65);
                break;
            case 1:
                this.activity.switchFragment(66);
                break;
            case 2:
                this.activity.switchFragment(67);
                break;
            case 3:
                this.activity.switchFragment(68);
                break;
            case 4:
                this.activity.switchFragment(69);
                break;
            case 5:
                this.activity.switchFragment(70);
                break;
            case 6:
                this.activity.switchFragment(71);
                break;
            case 7:
                this.activity.switchFragment(72);
                break;
            case 8:
                this.activity.switchFragment(73);
                break;
            case 9:
                this.activity.switchFragment(74);
                break;
            case 10:
                this.activity.switchFragment(75);
                break;
            case 11:
                this.activity.switchFragment(76);
                break;
        }
    }

    private void setBottomButtonState(int i) {
        View childAt = this.programs_tablelayout.getChildAt(0);
        if (childAt == null) {
            return;
        }
        for (int i2 = 0; i2 < DeviceModelList.programUnselectedImages.length; i2++) {
            View viewFindViewById = childAt.findViewById(i2);
            if (viewFindViewById != null) {
                if (i2 == i) {
                    viewFindViewById.findViewById(R.id.item_program_layout).setBackgroundResource(this.selectedImageRid);
                    ((ImageView) viewFindViewById.findViewById(R.id.item_program_imageview)).setImageResource(DeviceModelList.programSelectedImages[i2]);
                } else {
                    viewFindViewById.findViewById(R.id.item_program_layout).setBackgroundResource(this.unselectedImageRid);
                    ((ImageView) viewFindViewById.findViewById(R.id.item_program_imageview)).setImageResource(DeviceModelList.programUnselectedImages[i2]);
                }
            }
        }
    }

    public void hideFragment() {
        switchFragment(-1);
    }

    public void switchFragment(int i) {
        Log.d(TAG, "switchFragment~~~~");
        this.nowProgramPosition = i;
        int i2 = i - 65;
        ProfileFrameLayout[] profileFrameLayoutArr = this.profileViews;
        if (profileFrameLayoutArr == null || i2 >= profileFrameLayoutArr.length) {
            return;
        }
        if (i2 >= 0 && i2 <= DeviceModelList.programUnselectedImages.length - 1) {
            this.content_layout.setVisibility(0);
            this.content_layout.removeAllViews();
            this.content_layout.addView(this.profileViews[i2]);
            setBottomButtonState(i2);
            return;
        }
        this.content_layout.setVisibility(8);
    }

    public void startWorkout() throws IOException {
        if (ProtocolHandler.protocol.isConnected()) {
            ProtocolHandler.protocol.startWorkout();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:42:0x00ed A[LOOP:1: B:29:0x00b6->B:42:0x00ed, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:46:0x013b A[EDGE_INSN: B:46:0x013b->B:43:0x013b BREAK  A[LOOP:1: B:29:0x00b6->B:42:0x00ed], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleDeviceModelView() throws Resources.NotFoundException {
        float dimension;
        int i;
        Log.d(TAG, "handleDeviceModelView~~~~");
        if (DeviceModelList.programSelectedImages == null) {
            return;
        }
        Resources resources = getResources();
        int i2 = Global.BRAND;
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            if (ProtocolHandler.protocol.salesVersion == 1) {
                this.setting_start_textview.setText(R.string.sync);
            } else {
                this.setting_start_textview.setText(R.string.start);
            }
        }
        if (ProtocolHandler.protocol.salesVersion == 1) {
            ((TextView) this.rootView.findViewById(R.id.begin_info_textview)).setText(R.string.begin_start_info);
        } else {
            ((TextView) this.rootView.findViewById(R.id.begin_info_textview)).setText(R.string.begin_sync_info);
        }
        this.content_layout = (FrameLayout) this.rootView.findViewById(R.id.content_layout);
        int length = DeviceModelList.programSelectedImages.length;
        this.profileViews = new ProfileFrameLayout[length];
        for (int i3 = 0; i3 < length; i3++) {
            this.profileViews[i3] = new ProfileFrameLayout(this.activity, i3);
        }
        if (ProtocolHandler.protocol.deviceModel == 131 || ProtocolHandler.protocol.deviceModel == 132) {
            ProfileFrameLayout[] profileFrameLayoutArr = this.profileViews;
            if (profileFrameLayoutArr.length > 8) {
                profileFrameLayoutArr[8].setOnSettingClickListener(this);
                this.content_layout.addView(this.profileViews[0]);
            }
        }
        TableRow tableRow = new TableRow(this.activity);
        tableRow.setGravity(17);
        this.programs_tablelayout.removeAllViews();
        for (int i4 = 0; i4 < DeviceModelList.programSelectedImages.length; i4++) {
            int i5 = Global.BRAND;
            View viewInflate = null;
            if (i5 == 0) {
                viewInflate = View.inflate(this.activity, R.layout.item_programs, null);
                dimension = resources.getDimension(R.dimen.profiles_bottom_bg_size);
            } else if (i5 == 1 || i5 == 2 || i5 == 3) {
                viewInflate = View.inflate(this.activity, R.layout.s_item_programs, null);
                dimension = resources.getDimension(R.dimen.s_profiles_bottom_bg_size);
            } else {
                i = 0;
                if (viewInflate != null) {
                    break;
                }
                viewInflate.setId(i4);
                viewInflate.setOnClickListener(this);
                LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(R.id.item_program_layout);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams.height = i;
                layoutParams.width = i;
                linearLayout.setLayoutParams(layoutParams);
                ImageView imageView = (ImageView) viewInflate.findViewById(R.id.item_program_imageview);
                imageView.setImageResource(DeviceModelList.programSelectedImages[i4]);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) imageView.getLayoutParams();
                layoutParams2.bottomMargin = 0;
                layoutParams2.topMargin = 0;
                layoutParams2.rightMargin = 0;
                layoutParams2.leftMargin = 0;
                imageView.setLayoutParams(layoutParams2);
                viewInflate.findViewById(R.id.item_program_textview).setVisibility(8);
                tableRow.addView(viewInflate);
            }
            i = (int) dimension;
            if (viewInflate != null) {
            }
        }
        this.programs_tablelayout.addView(tableRow);
        switchFragment(this.nowProgramPosition);
    }

    @Override // com.dyaco.sole.custom.ProtocolHandler.OnDataResultListener
    public void onDataResult(int i, boolean z, List<Number> list) {
        if (i == 2) {
            int iIntValue = list.get(0).intValue();
            Global.printLog("d", TAG, "CS 改變 Program Mode-----" + iIntValue);
            if (iIntValue == 2) {
                this.activity.switchFragment(5);
                return;
            } else {
                if (iIntValue == 128) {
                    this.activity.showBaseAlert(Global.ALERT_TITLE_RID, R.string.confirm, true, R.string.display_alert_workout_idle, (DialogInterface.OnClickListener) null);
                    return;
                }
                return;
            }
        }
        if (i == 4 || i == 25 || i == 32 || i == 7 || i == 8 || i == 34 || i == 35 || i == 37 || i == 38) {
            if (z) {
                Global.printLog("d", TAG, "狀態改變成功-----" + i);
                return;
            }
            Global.printLog("d", TAG, "狀態改變失敗-----" + i);
        }
    }

    @Override // android.app.Fragment
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Global.printLog("d", TAG, "requestCode = " + i + " , resultCode = " + i2);
        if (i == 88 && i2 == -1) {
            this.profileViews[8].setSettingText(intent.getIntExtra("value1", 3), intent.getIntExtra("value2", 0), intent.getIntExtra("value3", 0));
        }
    }

    @Override // com.dyaco.sole.fragment.programs.ProfileFrameLayout.OnSettingClickListener
    public void onCaloriesSettingClick() {
        goCaloriesSetting();
    }

    private void goCaloriesSetting() {
        Intent intent = new Intent(this.activity, (Class<?>) CaloriesSettingDialog.class);
        intent.putExtra("valueIntArray", this.profileViews[8].getCalorieValues());
        startActivityForResult(intent, 88);
        this.activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
