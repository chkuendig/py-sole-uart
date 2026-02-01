package com.dyaco.sole.fragment.programs;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.AttributeSet;
import android.util.Log;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dyaco.ideabussdk_sole.protocol.SoleProtocol;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.MyApp;
import com.dyaco.sole.activity.MainActivity;
import com.dyaco.sole.custom.DeviceModelList;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.ProtocolHandler;
import com.dyaco.sole.custom_view.LongClickRepeatButton;
import com.dyaco.sole.custom_view.TypefaceTextView;
import com.dyaco.sole.custom_view.UserProfileView;
import com.dyaco.sole.database.ProfileDataDB;
import com.soletreadmills.sole.R;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

/* loaded from: classes.dex */
public class ProfileFrameLayout extends FrameLayout implements View.OnClickListener, ProtocolHandler.OnDataResultListener {
    private static final int MAX_HEART_RATE = 200;
    private static final int MAX_TIME = 99;
    private static final int MIN_HEART_RATE = 60;
    private static final int MIN_INTERVAL_TIME = 1;
    private static final int MIN_LEVEL = 5;
    private static final int MIN_RECOVER_TIME = 1;
    private static final int MIN_TIME = 0;
    private static final int SECONDS_MIN_TIME = 10;
    private MainActivity activity;
    private int caloriesValue1;
    private int caloriesValue2;
    private int caloriesValue3;
    private View.OnClickListener clickListener;
    private boolean isCustomProfile;
    private boolean isHRMode;
    public OnSettingClickListener mOnSettingClickListener;
    private long pressStartTime;
    private int profileMode;
    private Resources res;
    private View rootView;
    private TextView[] settingNumberTextViews;
    private int[] settingValue;
    private TextView setting_start_textview;
    private int titleTextRid;
    private UserProfileView userProfileView;

    public interface OnSettingClickListener {
        void onCaloriesSettingClick();
    }

    protected void setListeners() {
    }

    public void setOnSettingClickListener(OnSettingClickListener onSettingClickListener) {
        this.mOnSettingClickListener = onSettingClickListener;
    }

    public ProfileFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.clickListener = new AnonymousClass2();
    }

    public ProfileFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.clickListener = new AnonymousClass2();
    }

    public ProfileFrameLayout(Context context, int i) throws Resources.NotFoundException {
        super(context);
        this.clickListener = new AnonymousClass2();
        init(context, i);
    }

    private void init(Context context, int i) throws Resources.NotFoundException {
        this.activity = (MainActivity) context;
        this.profileMode = i;
        this.res = getResources();
        int i2 = Global.BRAND;
        if (i2 == 0) {
            this.rootView = inflate(context, R.layout.fragment_programs_profile, null);
        } else if (i2 == 1 || i2 == 2 || i2 == 3) {
            this.rootView = inflate(context, R.layout.s_fragment_programs_profile, null);
        }
        addView(this.rootView);
        findViews();
        initParams();
        setListeners();
    }

    protected void findViews() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.profiles_weight), 1.0f), Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.profiles_height), 1.0f));
        UserProfileView userProfileView = new UserProfileView(this.activity);
        this.userProfileView = userProfileView;
        userProfileView.setLayoutParams(layoutParams);
        int i = Global.BRAND;
        if (i == 0) {
            this.userProfileView.setProfileColor(R.color.display_number_blue);
        } else if (i == 1) {
            this.userProfileView.setProfileColor(R.color.spirit_program_red);
        } else if (i == 2 || i == 3) {
            this.userProfileView.setProfileColor(R.color.xterra_program_blue);
        }
        ((LinearLayout) this.rootView.findViewById(R.id.profile_program_layout)).addView(this.userProfileView);
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x01ab  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    protected void initParams() throws Resources.NotFoundException {
        int dimension;
        float dimension2;
        int i;
        int i2;
        Resources resources = getResources();
        int i3 = DeviceModelList.programTitleTexts[this.profileMode];
        this.titleTextRid = i3;
        this.isHRMode = i3 == R.string.hr1 || i3 == R.string.hr2;
        this.isCustomProfile = i3 == R.string.user || i3 == R.string.user1 || i3 == R.string.user2 || i3 == R.string.custom;
        View viewFindViewById = this.rootView.findViewById(R.id.profile_title_include);
        handleView(viewFindViewById);
        setUserProfile();
        TypefaceTextView typefaceTextView = (TypefaceTextView) viewFindViewById.findViewById(R.id.profile_textview);
        typefaceTextView.setTextSize(0, Global.getLongScreenHeight((int) resources.getDimension(R.dimen.all_title_text_size), 1.0f));
        typefaceTextView.setText(this.titleTextRid);
        if (Global.BRAND == 0) {
            typefaceTextView.setTypeface(this.activity, Global.fontsPath[2], 1);
            ImageView imageView = (ImageView) viewFindViewById.findViewById(R.id.profile_imageview);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) imageView.getLayoutParams();
            int longScreenHeight = Global.getLongScreenHeight((int) resources.getDimension(R.dimen.profiles_title_image_height), 1.0f);
            layoutParams.height = longScreenHeight;
            layoutParams.weight = longScreenHeight;
            imageView.setLayoutParams(layoutParams);
            imageView.setImageResource(DeviceModelList.programUnselectedImages[this.profileMode]);
        }
        ((TextView) viewFindViewById.findViewById(R.id.profile_info_textview)).setText(DeviceModelList.programInfoTexts[this.profileMode]);
        LinearLayout linearLayout = (LinearLayout) this.rootView.findViewById(R.id.profile_setting_layout);
        for (int i4 = 0; i4 < this.settingNumberTextViews.length; i4++) {
            View viewInflate = View.inflate(this.activity, R.layout.include_program_setting, null);
            TypefaceTextView typefaceTextView2 = (TypefaceTextView) viewInflate.findViewById(R.id.setting_title_textview);
            View viewFindViewById2 = viewInflate.findViewById(R.id.setting_bg_layout);
            final TextView textView = (TextView) viewInflate.findViewById(R.id.setting_number_textview);
            int i5 = DeviceModelList.programSettingSize[this.profileMode][i4];
            typefaceTextView2.setText(this.activity.getString(i5));
            textView.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.fragment.programs.ProfileFrameLayout.1
                @Override // android.view.View.OnClickListener
                public void onClick(final View view) {
                    final String[] strArrCreateItmes = ProfileFrameLayout.this.createItmes(view);
                    int iIndexOf = Arrays.asList(strArrCreateItmes).indexOf(String.valueOf(ProfileFrameLayout.this.settingValue[view.getId()]));
                    ContextThemeWrapper contextThemeWrapper = new ContextThemeWrapper(ProfileFrameLayout.this.activity, R.style.numAlertDialogCustomSole);
                    int i6 = Global.BRAND;
                    if (i6 == 1 || i6 == 2 || i6 == 3) {
                        contextThemeWrapper = new ContextThemeWrapper(ProfileFrameLayout.this.activity, R.style.numAlertDialogCustomXterra);
                    }
                    new AlertDialog.Builder(contextThemeWrapper).setTitle("").setSingleChoiceItems(strArrCreateItmes, iIndexOf, new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.fragment.programs.ProfileFrameLayout.1.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i7) {
                            textView.setText(strArrCreateItmes[i7]);
                            ProfileFrameLayout.this.settingValue[view.getId()] = Integer.parseInt(strArrCreateItmes[i7]);
                            dialogInterface.dismiss();
                        }
                    }).create().show();
                }
            });
            int i6 = Global.BRAND;
            if (i6 == 0) {
                textView.setTextSize(0, resources.getDimension(R.dimen.profiles_number_text_size));
                dimension = (int) resources.getDimension(R.dimen.profiles_number_bg_width);
                dimension2 = resources.getDimension(R.dimen.profiles_number_bg_height);
            } else if (i6 == 1 || i6 == 2 || i6 == 3) {
                typefaceTextView2.setTextColor(resources.getColor(R.color.black));
                textView.setTextSize(0, resources.getDimension(R.dimen.s_profiles_number_text_size));
                dimension = (int) resources.getDimension(R.dimen.s_profiles_number_bg_width);
                dimension2 = resources.getDimension(R.dimen.s_profiles_number_bg_height);
            } else {
                dimension = 0;
                i = 0;
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) viewFindViewById2.getLayoutParams();
                layoutParams2.width = dimension;
                layoutParams2.height = i;
                viewFindViewById2.setLayoutParams(layoutParams2);
                textView.setText(String.valueOf(this.settingValue[i4]));
                textView.setId(i4);
                this.settingNumberTextViews[i4] = textView;
                LongClickRepeatButton longClickRepeatButton = (LongClickRepeatButton) viewInflate.findViewById(R.id.setting_up_button);
                LongClickRepeatButton longClickRepeatButton2 = (LongClickRepeatButton) viewInflate.findViewById(R.id.setting_down_button);
                longClickRepeatButton.setIntervalTime(60L);
                longClickRepeatButton2.setIntervalTime(60L);
                longClickRepeatButton.setId(i4 + 100);
                longClickRepeatButton2.setId(i4 + 200);
                longClickRepeatButton.setOnClickListener(this);
                longClickRepeatButton2.setOnClickListener(this);
                linearLayout.addView(viewInflate);
                i2 = this.titleTextRid;
                if (i2 != R.string.calorie && i5 == R.string.time) {
                    viewInflate.setVisibility(8);
                } else if (i2 != R.string.fusion && i5 == R.string.time) {
                    viewInflate.setVisibility(8);
                }
            }
            i = (int) dimension2;
            RelativeLayout.LayoutParams layoutParams22 = (RelativeLayout.LayoutParams) viewFindViewById2.getLayoutParams();
            layoutParams22.width = dimension;
            layoutParams22.height = i;
            viewFindViewById2.setLayoutParams(layoutParams22);
            textView.setText(String.valueOf(this.settingValue[i4]));
            textView.setId(i4);
            this.settingNumberTextViews[i4] = textView;
            LongClickRepeatButton longClickRepeatButton3 = (LongClickRepeatButton) viewInflate.findViewById(R.id.setting_up_button);
            LongClickRepeatButton longClickRepeatButton22 = (LongClickRepeatButton) viewInflate.findViewById(R.id.setting_down_button);
            longClickRepeatButton3.setIntervalTime(60L);
            longClickRepeatButton22.setIntervalTime(60L);
            longClickRepeatButton3.setId(i4 + 100);
            longClickRepeatButton22.setId(i4 + 200);
            longClickRepeatButton3.setOnClickListener(this);
            longClickRepeatButton22.setOnClickListener(this);
            linearLayout.addView(viewInflate);
            i2 = this.titleTextRid;
            if (i2 != R.string.calorie) {
                if (i2 != R.string.fusion) {
                }
            }
        }
        int i7 = Global.BRAND;
        if (i7 == 0) {
            this.setting_start_textview = (TextView) View.inflate(this.activity, R.layout.include_program_begin_start, linearLayout).findViewById(R.id.setting_start_textview);
            if (ProtocolHandler.protocol.salesVersion == 1) {
                this.setting_start_textview.setText(R.string.sync);
            } else {
                this.setting_start_textview.setText(R.string.start);
            }
            linearLayout.findViewById(R.id.setting_start_textview).setOnClickListener(this.clickListener);
            return;
        }
        if ((i7 == 1 || i7 == 2 || i7 == 3) && this.titleTextRid == R.string.calorie) {
            setSettingText(3, 0, 0);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String[] createItmes(View view) {
        String[] strArr = new String[0];
        if (view.getId() == 0) {
            return genNumArr();
        }
        if (view.getId() == 1) {
            if (this.isHRMode) {
                return genNumArr2();
            }
            return this.titleTextRid == R.string.fusion ? strArr : genNumArr3();
        }
        view.getId();
        return strArr;
    }

    private String[] genNumArr3() {
        LinkedList linkedList = new LinkedList();
        for (int i = 5; i <= ProtocolHandler.protocol.maxLevel; i++) {
            linkedList.add(String.valueOf(i));
        }
        return (String[]) linkedList.toArray(new String[0]);
    }

    private String[] genNumArr2() {
        LinkedList linkedList = new LinkedList();
        for (int i = 60; i <= 200; i++) {
            linkedList.add(String.valueOf(i));
        }
        return (String[]) linkedList.toArray(new String[0]);
    }

    private String[] genNumArr() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(String.valueOf(0));
        for (int i = 10; i <= 99; i++) {
            linkedList.add(String.valueOf(i));
        }
        return (String[]) linkedList.toArray(new String[0]);
    }

    private void setUserProfile() {
        int[] profileData;
        if (this.isHRMode) {
            this.userProfileView.setVisibility(8);
            return;
        }
        int[] iArr = null;
        if (this.isCustomProfile) {
            int i = this.titleTextRid == R.string.user2 ? 2 : 1;
            ProfileDataDB profileDataDB = new ProfileDataDB(this.activity);
            int i2 = Global.BRAND;
            if (i2 == 0) {
                profileData = profileDataDB.getProfileData(i, 18);
            } else {
                if (i2 == 1 || i2 == 2 || i2 == 3) {
                    profileData = profileDataDB.getProfileData(i, 20);
                }
                profileDataDB.close();
            }
            iArr = profileData;
            profileDataDB.close();
        }
        if (iArr == null) {
            iArr = DeviceModelList.programPosition[this.profileMode];
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i3 : iArr) {
            if (this.isHRMode) {
                arrayList.add(0);
            } else {
                arrayList.add(Integer.valueOf(i3 - 1));
            }
        }
        this.userProfileView.resetProgramCount();
        this.userProfileView.setProgramNowPositionArray(arrayList, this.isCustomProfile);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        char c;
        int i;
        int[] iArr = this.settingValue;
        int i2 = iArr[0];
        int i3 = iArr[1];
        int i4 = iArr[2];
        ErrorLogSave.addErrorString(getContext(), ErrorLogSave.CLICK, "ProfileFrameLayout_onClick", "click_id:" + view.getId() + "_time:" + i2 + "_value1:" + i3 + "_value2:" + i4);
        int id = view.getId();
        switch (id) {
            case 100:
                i2++;
                if (i2 > 99) {
                    i2 = 0;
                } else if (i2 < 10) {
                    i2 = 10;
                }
                c = 0;
                this.settingNumberTextViews[0].setText(String.valueOf(i2));
                int[] iArr2 = this.settingValue;
                iArr2[c] = i2;
                iArr2[1] = i3;
                iArr2[2] = i4;
                ErrorLogSave.addErrorString(getContext(), ErrorLogSave.CLICK, "ProfileFrameLayout_onClick_End", "click_id:" + view.getId() + "_time:" + i2 + "_value1:" + i3 + "_value2:" + i4);
            case 101:
                int i5 = this.titleTextRid;
                if (i5 == R.string.calorie) {
                    OnSettingClickListener onSettingClickListener = this.mOnSettingClickListener;
                    if (onSettingClickListener != null) {
                        onSettingClickListener.onCaloriesSettingClick();
                        return;
                    }
                    return;
                }
                i3++;
                if (this.isHRMode) {
                    if (i3 > 200) {
                        i3 = 60;
                    }
                } else if (i5 == R.string.fusion) {
                    if (i3 > ProtocolHandler.protocol.maxIntervalTime) {
                        i3 = 1;
                    }
                } else if (i3 > ProtocolHandler.protocol.maxLevel) {
                    i3 = 5;
                }
                this.settingNumberTextViews[1].setText(String.valueOf(i3));
                break;
            case 102:
                i4++;
                if (i4 > ProtocolHandler.protocol.maxRecoverTime) {
                    i4 = 1;
                }
                this.settingNumberTextViews[2].setText(String.valueOf(i4));
                break;
            default:
                switch (id) {
                    case 200:
                        i2--;
                        if (i2 < 0) {
                            i2 = 99;
                        } else if (i2 < 10) {
                            i2 = 0;
                        }
                        this.settingNumberTextViews[0].setText(String.valueOf(i2));
                        break;
                    case 201:
                        int i6 = this.titleTextRid;
                        if (i6 == R.string.calorie) {
                            OnSettingClickListener onSettingClickListener2 = this.mOnSettingClickListener;
                            if (onSettingClickListener2 != null) {
                                onSettingClickListener2.onCaloriesSettingClick();
                                return;
                            }
                            return;
                        }
                        i3--;
                        if (!this.isHRMode) {
                            if (i6 == R.string.fusion) {
                                if (i3 < 1) {
                                    i = ProtocolHandler.protocol.maxIntervalTime;
                                    i3 = i;
                                }
                            } else if (i3 < 5) {
                                i = ProtocolHandler.protocol.maxLevel;
                                i3 = i;
                            }
                            int[] iArr22 = this.settingValue;
                            iArr22[c] = i2;
                            iArr22[1] = i3;
                            iArr22[2] = i4;
                            ErrorLogSave.addErrorString(getContext(), ErrorLogSave.CLICK, "ProfileFrameLayout_onClick_End", "click_id:" + view.getId() + "_time:" + i2 + "_value1:" + i3 + "_value2:" + i4);
                        }
                        if (i3 < 60) {
                            i3 = 200;
                        }
                        this.settingNumberTextViews[1].setText(String.valueOf(i3));
                        break;
                    case 202:
                        i4--;
                        if (i4 < 1) {
                            i4 = ProtocolHandler.protocol.maxRecoverTime;
                        }
                        this.settingNumberTextViews[2].setText(String.valueOf(i4));
                        break;
                }
        }
        c = 0;
        int[] iArr222 = this.settingValue;
        iArr222[c] = i2;
        iArr222[1] = i3;
        iArr222[2] = i4;
        ErrorLogSave.addErrorString(getContext(), ErrorLogSave.CLICK, "ProfileFrameLayout_onClick_End", "click_id:" + view.getId() + "_time:" + i2 + "_value1:" + i3 + "_value2:" + i4);
    }

    /* renamed from: com.dyaco.sole.fragment.programs.ProfileFrameLayout$2, reason: invalid class name */
    class AnonymousClass2 implements View.OnClickListener {
        AnonymousClass2() {
        }

        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            if (view.getId() != R.id.setting_start_textview) {
                return;
            }
            Log.e("setting_start_textview", ErrorLogSave.CLICK);
            if (System.currentTimeMillis() - ProfileFrameLayout.this.pressStartTime > 2000) {
                ErrorLogSave.addErrorString(ProfileFrameLayout.this.getContext(), ErrorLogSave.CLICK, "ProfileFrameLayout_setting_start", ErrorLogSave.CLICK);
                ProfileFrameLayout.this.setting_start_textview.setTextColor(Color.parseColor("#353535"));
                ProfileFrameLayout.this.setting_start_textview.setOnClickListener(null);
                new Timer().schedule(new TimerTask() { // from class: com.dyaco.sole.fragment.programs.ProfileFrameLayout.2.1
                    @Override // java.util.TimerTask, java.lang.Runnable
                    public void run() {
                        Log.e("setting_start_textview", "resume");
                        ProfileFrameLayout.this.activity.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.fragment.programs.ProfileFrameLayout.2.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                ProfileFrameLayout.this.setting_start_textview.setTextColor(ProfileFrameLayout.this.getResources().getColor(R.color.light_gray));
                                ProfileFrameLayout.this.setting_start_textview.setOnClickListener(ProfileFrameLayout.this.clickListener);
                            }
                        });
                    }
                }, 5000L);
                SoleProtocol.notRunning = false;
                MyApp.isWork = true;
                ProfileFrameLayout.this.pressStartTime = System.currentTimeMillis();
                ProfileFrameLayout.this.startWorkout();
            }
        }
    }

    public void startWorkout() {
        int[] iArr = this.settingValue;
        int i = iArr[0];
        int i2 = iArr[1];
        int i3 = iArr[2];
        ProtocolHandler.protocol.setWorkoutTime = i;
        if (this.isHRMode) {
            ProtocolHandler.protocol.setMaxTargetHR = i2;
        } else {
            int i4 = this.titleTextRid;
            if (i4 == R.string.calorie) {
                ProtocolHandler.protocol.setTargetCalories = getCalorieValue();
            } else if (i4 == R.string.fusion) {
                ProtocolHandler.protocol.setIntervalTime = i2;
                ProtocolHandler.protocol.setRecoverTime = i3;
            } else {
                ProtocolHandler.protocol.setMaxTargetHR = 220 - ProtocolHandler.protocol.setAge;
                int i5 = ProtocolHandler.protocol.deviceType;
                if (i5 == 1 || i5 == 2) {
                    ProtocolHandler.protocol.setMaxLevel = i2;
                }
            }
        }
        ProtocolHandler.protocol.setProgramMode = this.profileMode;
        ProtocolHandler.protocol.setUserProfiles = this.userProfileView.getProgramNowPositionArray();
        ProfileDataDB profileDataDB = new ProfileDataDB(this.activity);
        if (this.isCustomProfile) {
            profileDataDB.updateProfileData(this.titleTextRid == R.string.user2 ? 2 : 1, ProtocolHandler.protocol.setUserProfiles);
        }
        profileDataDB.close();
        if (this.isHRMode) {
            ProtocolHandler.protocol.addOnDataResultListener(this);
            ProtocolHandler.protocol.getHeartRateType();
        } else {
            ((ProfilesFragment) this.activity.getFragments().get(4)).startWorkout();
        }
        Global.workoutDataList.clear();
        Global.workoutDataListForProtocol.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:29:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    private void handleView(View view) {
        boolean z;
        int i;
        int i2;
        float f;
        int i3 = this.titleTextRid;
        if (i3 == R.string.hr1) {
            f = (220 - ProtocolHandler.protocol.setAge) * 0.6f;
        } else if (i3 == R.string.hr2) {
            f = (220 - ProtocolHandler.protocol.setAge) * 0.8f;
        } else if (i3 != R.string.fusion) {
            int[] iArr = DeviceModelList.programSettingSize[this.profileMode];
            int length = iArr.length;
            int i4 = 0;
            while (true) {
                if (i4 >= length) {
                    z = false;
                    break;
                } else {
                    if (iArr[i4] == R.string.level) {
                        z = true;
                        break;
                    }
                    i4++;
                }
            }
            i = z ? 5 : 0;
            i2 = 0;
            this.settingValue = new int[]{0, i, i2};
            this.settingNumberTextViews = new TextView[DeviceModelList.programSettingSize[this.profileMode].length];
            if (this.isHRMode) {
            }
        } else {
            i = 1;
            i2 = 1;
            this.settingValue = new int[]{0, i, i2};
            this.settingNumberTextViews = new TextView[DeviceModelList.programSettingSize[this.profileMode].length];
            if (this.isHRMode) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) view.getLayoutParams();
                layoutParams.weight = 0.6f;
                view.setLayoutParams(layoutParams);
                LinearLayout linearLayout = (LinearLayout) this.rootView.findViewById(R.id.profile_program_layout);
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) linearLayout.getLayoutParams();
                layoutParams2.weight = 0.2f;
                linearLayout.setLayoutParams(layoutParams2);
                return;
            }
            return;
        }
        i = (int) f;
        i2 = 0;
        this.settingValue = new int[]{0, i, i2};
        this.settingNumberTextViews = new TextView[DeviceModelList.programSettingSize[this.profileMode].length];
        if (this.isHRMode) {
        }
    }

    public void setSettingText(int i, int i2, int i3) {
        this.caloriesValue1 = i;
        this.caloriesValue2 = i2;
        this.caloriesValue3 = i3;
        TextView[] textViewArr = this.settingNumberTextViews;
        if (textViewArr == null || textViewArr[1] == null || textViewArr.length < 2) {
            return;
        }
        this.settingNumberTextViews[1].setText(String.valueOf(Integer.parseInt("" + i + i2 + i3)));
    }

    public int[] getCalorieValues() {
        return new int[]{this.caloriesValue1, this.caloriesValue2, this.caloriesValue3};
    }

    public int getCalorieValue() {
        return (this.caloriesValue1 * 100) + (this.caloriesValue2 * 10) + this.caloriesValue3;
    }

    @Override // com.dyaco.sole.custom.ProtocolHandler.OnDataResultListener
    public void onDataResult(int i, boolean z, List<Number> list) throws IOException {
        int iIntValue;
        int i2;
        if (i != 9) {
            return;
        }
        if (ProtocolHandler.protocol.deviceType == 0) {
            iIntValue = list.get(1).intValue();
        } else {
            iIntValue = list.get(0).intValue();
        }
        if (iIntValue == 0) {
            if (ProtocolHandler.protocol.salesVersion == 0 || (i2 = Global.BRAND) == 0 || i2 == 1) {
                this.activity.showBaseAlert(Global.ALERT_TITLE_RID, R.string.confirm, true, R.string.no_hr, (DialogInterface.OnClickListener) null);
            }
        } else {
            ((ProfilesFragment) this.activity.getFragments().get(4)).startWorkout();
        }
        ProtocolHandler.protocol.removeOnDataResultListener(this);
    }
}
