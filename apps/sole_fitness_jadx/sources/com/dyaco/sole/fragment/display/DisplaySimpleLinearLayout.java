package com.dyaco.sole.fragment.display;

import android.content.Context;
import android.content.res.Resources;
import android.text.Html;
import android.text.Spanned;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.dyaco.ideabussdk_sole.protocol.WorkoutData;
import com.dyaco.sole.activity.MainActivity;
import com.dyaco.sole.custom.DeviceModelList;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.ProtocolHandler;
import com.dyaco.sole.custom_view.TypefaceTextView;
import com.dyaco.sole.custom_view.UserProfileView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.security.CertificateUtil;
import com.google.firebase.crashlytics.internal.common.IdManager;
import com.soletreadmills.sole.R;
import java.math.BigDecimal;
import java.math.RoundingMode;

/* loaded from: classes.dex */
public class DisplaySimpleLinearLayout extends FrameLayout implements View.OnClickListener {
    private MainActivity activity;
    private View display_calories_include;
    private TypefaceTextView display_calories_number_textview;
    private View display_distance_include;
    private TypefaceTextView display_distance_number_name_textview;
    private TypefaceTextView display_distance_number_textview;
    private View display_hr_include;
    private TypefaceTextView display_hr_number_textview;
    private View display_simple_1_include;
    private View display_simple_2_include;
    private View display_simple_3_include;
    private View display_simple_4_include;
    private View display_simple_5_include;
    private ImageView display_simple_muscle_image;
    private TypefaceTextView display_simple_muscle_text;
    private TypefaceTextView display_simple_profile_text;
    private RelativeLayout display_simple_right_1_layout;
    private ViewGroup display_simple_right_2_layout;
    private TypefaceTextView display_simple_time_textview;
    private View display_target_hr_include;
    private TypefaceTextView display_target_hr_number_name_textview;
    private TypefaceTextView display_target_hr_number_textview;
    private int imageChangeCounter;
    private int imageIndex;
    private ImageView item_1_imageview;
    private TypefaceTextView item_1_title_textview;
    private TextView item_1_value_textview;
    private ImageView item_2_imageview;
    private TypefaceTextView item_2_title_textview;
    private TextView item_2_value_textview;
    private ImageView item_3_imageview;
    private TypefaceTextView item_3_title_textview;
    private TextView item_3_value_textview;
    private ImageView item_4_imageview;
    private TypefaceTextView item_4_title_textview;
    private TextView item_4_value_textview;
    private ImageView item_5_imageview;
    private TypefaceTextView item_5_title_textview;
    private TextView item_5_value_textview;
    private int nowWorkoutMode;
    private DisplayMainFragment parentFragment;
    private ImageView profile_imageview;
    private TextView profile_info_textview;
    private TypefaceTextView profile_textview;
    private RelativeLayout programProfileLayout;
    private Resources res;
    private View rootView;
    private TextView unit_4_1_text;
    private TextView unit_4_2_text;
    private View unit_4_layout;
    private TextView unit_5_1_text;
    private TextView unit_5_2_text;
    private View unit_5_layout;
    private UserProfileView userProfileView;
    private static final int[] EF_WEAK_NO_HR = {R.drawable.s_display_ef_1, R.drawable.s_display_ef_5, R.drawable.s_display_ef_6, R.drawable.s_display_ef_9};
    private static final int[] EF_WEAK_HR = {R.drawable.s_display_ef_1, R.drawable.s_display_ef_3, R.drawable.s_display_ef_4, R.drawable.s_display_ef_5, R.drawable.s_display_ef_6, R.drawable.s_display_ef_8, R.drawable.s_display_ef_9, R.drawable.s_display_ef_10};
    private static final int[] EF_STRONG_NO_HR = {R.drawable.s_display_ef_1, R.drawable.s_display_ef_2, R.drawable.s_display_ef_9};
    private static final int[] EF_STRONG_HR = {R.drawable.s_display_ef_1, R.drawable.s_display_ef_2, R.drawable.s_display_ef_3, R.drawable.s_display_ef_4, R.drawable.s_display_ef_5, R.drawable.s_display_ef_8, R.drawable.s_display_ef_9, R.drawable.s_display_ef_10};

    public DisplaySimpleLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.nowWorkoutMode = 3;
    }

    public DisplaySimpleLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.nowWorkoutMode = 3;
    }

    public DisplaySimpleLinearLayout(Context context, DisplayMainFragment displayMainFragment) {
        super(context);
        this.nowWorkoutMode = 3;
        this.parentFragment = displayMainFragment;
        init(context);
    }

    private void init(Context context) {
        this.activity = (MainActivity) context;
        this.res = getResources();
        int i = Global.BRAND;
        if (i == 0) {
            this.rootView = inflate(context, R.layout.include_display_simple, null);
        } else if (i == 1) {
            this.rootView = inflate(context, R.layout.s_include_display_simple, null);
        } else if (i == 2 || i == 3) {
            this.rootView = inflate(context, R.layout.x_include_display_simple, null);
        }
        addView(this.rootView);
        findViews();
        initParams();
        setListeners();
    }

    private void findViews() {
        int i = Global.BRAND;
        if (i == 0) {
            View viewFindViewById = this.rootView.findViewById(R.id.profile_title_include);
            this.profile_textview = (TypefaceTextView) viewFindViewById.findViewById(R.id.profile_textview);
            this.profile_imageview = (ImageView) viewFindViewById.findViewById(R.id.profile_imageview);
            this.profile_info_textview = (TextView) viewFindViewById.findViewById(R.id.profile_info_textview);
            this.display_simple_time_textview = (TypefaceTextView) this.rootView.findViewById(R.id.display_simple_time_textview);
            this.display_distance_include = this.rootView.findViewById(R.id.display_distance_include);
            this.display_calories_include = this.rootView.findViewById(R.id.display_calories_include);
            this.display_hr_include = this.rootView.findViewById(R.id.display_hr_include);
            this.display_target_hr_include = this.rootView.findViewById(R.id.display_target_hr_include);
            this.display_distance_number_textview = (TypefaceTextView) this.display_distance_include.findViewById(R.id.display_number_textview);
            this.display_calories_number_textview = (TypefaceTextView) this.display_calories_include.findViewById(R.id.display_number_textview);
            this.display_hr_number_textview = (TypefaceTextView) this.display_hr_include.findViewById(R.id.display_number_textview);
            this.display_target_hr_number_textview = (TypefaceTextView) this.display_target_hr_include.findViewById(R.id.display_number_textview);
            return;
        }
        if (i == 1 || i == 2 || i == 3) {
            if (Global.BRAND == 1) {
                this.display_simple_muscle_text = (TypefaceTextView) this.rootView.findViewById(R.id.display_simple_muscle_text);
                this.display_simple_muscle_image = (ImageView) this.rootView.findViewById(R.id.display_simple_muscle_image);
            }
            this.display_simple_right_1_layout = (RelativeLayout) this.rootView.findViewById(R.id.display_simple_right_1_layout);
            this.display_simple_right_2_layout = (ViewGroup) this.rootView.findViewById(R.id.display_simple_right_2_layout);
            this.display_simple_1_include = this.rootView.findViewById(R.id.display_simple_left_1_include);
            this.display_simple_2_include = this.rootView.findViewById(R.id.display_simple_left_2_include);
            this.display_simple_3_include = this.rootView.findViewById(R.id.display_simple_left_3_include);
            this.display_simple_4_include = this.rootView.findViewById(R.id.display_simple_left_4_include);
            this.display_simple_5_include = this.rootView.findViewById(R.id.display_simple_left_5_include);
            this.item_1_value_textview = (TextView) this.display_simple_1_include.findViewById(R.id.display_simple_item_value_textview);
            this.item_2_value_textview = (TextView) this.display_simple_2_include.findViewById(R.id.display_simple_item_value_textview);
            this.item_3_value_textview = (TextView) this.display_simple_3_include.findViewById(R.id.display_simple_item_value_textview);
            this.item_4_value_textview = (TextView) this.display_simple_4_include.findViewById(R.id.display_simple_item_value_textview);
            this.item_5_value_textview = (TextView) this.display_simple_5_include.findViewById(R.id.display_simple_item_value_textview);
            this.item_1_imageview = (ImageView) this.display_simple_1_include.findViewById(R.id.display_simple_item_title_imageview);
            this.item_2_imageview = (ImageView) this.display_simple_2_include.findViewById(R.id.display_simple_item_title_imageview);
            this.item_3_imageview = (ImageView) this.display_simple_3_include.findViewById(R.id.display_simple_item_title_imageview);
            this.item_4_imageview = (ImageView) this.display_simple_4_include.findViewById(R.id.display_simple_item_title_imageview);
            this.item_5_imageview = (ImageView) this.display_simple_5_include.findViewById(R.id.display_simple_item_title_imageview);
            this.item_1_title_textview = (TypefaceTextView) this.display_simple_1_include.findViewById(R.id.display_simple_item_title_textview);
            this.item_2_title_textview = (TypefaceTextView) this.display_simple_2_include.findViewById(R.id.display_simple_item_title_textview);
            this.item_3_title_textview = (TypefaceTextView) this.display_simple_3_include.findViewById(R.id.display_simple_item_title_textview);
            this.item_4_title_textview = (TypefaceTextView) this.display_simple_4_include.findViewById(R.id.display_simple_item_title_textview);
            this.item_5_title_textview = (TypefaceTextView) this.display_simple_5_include.findViewById(R.id.display_simple_item_title_textview);
            this.display_simple_profile_text = (TypefaceTextView) this.rootView.findViewById(R.id.display_simple_profile_text);
            this.programProfileLayout = (RelativeLayout) this.rootView.findViewById(R.id.display_simple_profile_layout);
            this.unit_4_layout = this.display_simple_4_include.findViewById(R.id.unit_layout);
            this.unit_5_layout = this.display_simple_5_include.findViewById(R.id.unit_layout);
            this.unit_4_1_text = (TypefaceTextView) this.display_simple_4_include.findViewById(R.id.unit_1_text);
            this.unit_4_2_text = (TypefaceTextView) this.display_simple_4_include.findViewById(R.id.unit_2_text);
            this.unit_5_1_text = (TypefaceTextView) this.display_simple_5_include.findViewById(R.id.unit_1_text);
            this.unit_5_2_text = (TypefaceTextView) this.display_simple_5_include.findViewById(R.id.unit_2_text);
        }
    }

    private void initParams() {
        if (DeviceModelList.programTitleTexts == null) {
            return;
        }
        int i = DeviceModelList.programTitleTexts[ProtocolHandler.protocol.setProgramMode];
        boolean z = i == R.string.hr1 || i == R.string.hr2;
        int i2 = Global.BRAND;
        if (i2 != 0) {
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                this.item_2_title_textview.setText(this.res.getString(R.string.heart_rate).toUpperCase());
                this.item_3_title_textview.setText(this.res.getString(R.string.time).toUpperCase());
                this.item_4_title_textview.setText(this.res.getString(R.string.distance).toUpperCase());
                this.item_2_imageview.setImageResource(R.drawable.s_display_icon_a_hr);
                this.item_3_imageview.setImageResource(R.drawable.s_display_icon_a_time);
                this.item_4_imageview.setImageResource(R.drawable.s_display_icon_a_dis);
                if (Global.BRAND == 1) {
                    this.display_simple_muscle_text.setText(this.res.getString(R.string.muscle_profile).toUpperCase());
                    RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.programProfileLayout.getLayoutParams();
                    layoutParams.width = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.s_display_simple_profile_width), 0.9f);
                    layoutParams.height = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.s_display_simple_profile_height), 1.0f);
                    this.programProfileLayout.setLayoutParams(layoutParams);
                }
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.display_simple_1_include.getLayoutParams();
                layoutParams2.height = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.s_display_dashboard_top_height), 1.0f);
                this.display_simple_1_include.setLayoutParams(layoutParams2);
                this.display_simple_2_include.setLayoutParams(layoutParams2);
                this.display_simple_3_include.setLayoutParams(layoutParams2);
                this.display_simple_4_include.setLayoutParams(layoutParams2);
                this.display_simple_5_include.setLayoutParams(layoutParams2);
                return;
            }
            return;
        }
        TypefaceTextView typefaceTextView = (TypefaceTextView) this.rootView.findViewById(R.id.display_simple_time_title_textview);
        typefaceTextView.setTypeface(this.activity, Global.fontsPath[1], 3);
        typefaceTextView.setText(this.res.getString(R.string.time).toUpperCase());
        TypefaceTextView typefaceTextView2 = (TypefaceTextView) this.display_distance_include.findViewById(R.id.display_number_name_textview);
        this.display_distance_number_name_textview = typefaceTextView2;
        typefaceTextView2.setTypeface(this.activity, Global.fontsPath[1], 3);
        this.display_distance_number_name_textview.setText(R.string.distance);
        TypefaceTextView typefaceTextView3 = (TypefaceTextView) this.display_calories_include.findViewById(R.id.display_number_name_textview);
        typefaceTextView3.setTypeface(this.activity, Global.fontsPath[1], 3);
        typefaceTextView3.setText(R.string.calories);
        TypefaceTextView typefaceTextView4 = (TypefaceTextView) this.display_hr_include.findViewById(R.id.display_number_name_textview);
        typefaceTextView4.setTypeface(this.activity, Global.fontsPath[1], 3);
        typefaceTextView4.setText(R.string.heart_rate);
        TypefaceTextView typefaceTextView5 = (TypefaceTextView) this.display_target_hr_include.findViewById(R.id.display_number_name_textview);
        this.display_target_hr_number_name_textview = typefaceTextView5;
        typefaceTextView5.setTypeface(this.activity, Global.fontsPath[1], 3);
        this.display_target_hr_number_name_textview.setText(R.string.target_hr_short);
        this.profile_textview.setTypeface(this.activity, Global.fontsPath[2], 1);
        this.profile_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.all_title_text_size), 1.2f));
        LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) this.profile_imageview.getLayoutParams();
        int longScreenHeight = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.profiles_title_image_height), 1.2f);
        layoutParams3.height = longScreenHeight;
        layoutParams3.weight = longScreenHeight;
        this.profile_imageview.setLayoutParams(layoutParams3);
        RelativeLayout relativeLayout = (RelativeLayout) this.display_distance_include.findViewById(R.id.display_number_layout);
        LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) relativeLayout.getLayoutParams();
        layoutParams4.width = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_number_name_width), 0.7f);
        relativeLayout.setLayoutParams(layoutParams4);
        RelativeLayout relativeLayout2 = (RelativeLayout) this.display_calories_include.findViewById(R.id.display_number_layout);
        LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) relativeLayout2.getLayoutParams();
        layoutParams5.width = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_number_name_width), 0.7f);
        relativeLayout2.setLayoutParams(layoutParams5);
        RelativeLayout relativeLayout3 = (RelativeLayout) this.rootView.findViewById(R.id.display_simple_time_layout);
        LinearLayout.LayoutParams layoutParams6 = (LinearLayout.LayoutParams) relativeLayout3.getLayoutParams();
        layoutParams6.width = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_number_time_width), 0.7f);
        relativeLayout3.setLayoutParams(layoutParams6);
        RelativeLayout relativeLayout4 = (RelativeLayout) this.display_hr_include.findViewById(R.id.display_number_layout);
        LinearLayout.LayoutParams layoutParams7 = (LinearLayout.LayoutParams) relativeLayout4.getLayoutParams();
        layoutParams7.width = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_number_name_width), 0.7f);
        relativeLayout4.setLayoutParams(layoutParams7);
        RelativeLayout relativeLayout5 = (RelativeLayout) this.display_target_hr_include.findViewById(R.id.display_number_layout);
        LinearLayout.LayoutParams layoutParams8 = (LinearLayout.LayoutParams) relativeLayout5.getLayoutParams();
        layoutParams8.width = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_number_name_width), 0.7f);
        relativeLayout5.setLayoutParams(layoutParams8);
        this.display_distance_number_name_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.profiles_info_text_size), 0.7f));
        typefaceTextView3.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.profiles_info_text_size), 0.7f));
        typefaceTextView.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.profiles_info_text_size), 0.7f));
        typefaceTextView4.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.profiles_info_text_size), 0.7f));
        this.display_target_hr_number_name_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.profiles_info_text_size), 0.7f));
        this.display_distance_number_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_number_text_size), 0.7f));
        this.display_calories_number_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_number_text_size), 0.7f));
        this.display_simple_time_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_number_text_size), 0.7f));
        this.display_hr_number_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_number_text_size), 0.7f));
        this.display_target_hr_number_textview.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_number_text_size), 0.7f));
        if (z) {
            this.display_target_hr_number_textview.setTextColor(this.res.getColor(R.color.light_gray));
        }
        this.display_distance_number_textview.setTypeface(this.activity, Global.fontsPath[0]);
        this.display_calories_number_textview.setTypeface(this.activity, Global.fontsPath[0]);
        this.display_simple_time_textview.setTypeface(this.activity, Global.fontsPath[0]);
        this.display_hr_number_textview.setTypeface(this.activity, Global.fontsPath[0]);
        this.display_target_hr_number_textview.setTypeface(this.activity, Global.fontsPath[0]);
    }

    private void setListeners() {
        int i = Global.BRAND;
        if (i == 1 || i == 2 || i == 3) {
            this.display_simple_4_include.setOnClickListener(this);
            this.display_simple_5_include.setOnClickListener(this);
        }
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.display_simple_left_4_include /* 2131231145 */:
                if (this.parentFragment.distanceUnitFlag) {
                    change4ViewToMI();
                } else {
                    change4ViewToKM();
                }
                this.item_4_value_textview.setText(String.valueOf(ProtocolHandler.protocol.getConvertDistanceUnit(!this.parentFragment.distanceUnitFlag ? 1 : 0, this.parentFragment.distanceUnitValue)));
                this.parentFragment.distanceUnitFlag = !r3.distanceUnitFlag;
                break;
            case R.id.display_simple_left_5_include /* 2131231146 */:
                if (ProtocolHandler.protocol.deviceType == 0) {
                    if (this.parentFragment.speedUnitFlag) {
                        change5ViewToMI();
                    } else {
                        change5ViewToKM();
                    }
                    this.item_5_value_textview.setText(String.valueOf(ProtocolHandler.protocol.getConvertDistanceUnit(!this.parentFragment.speedUnitFlag ? 1 : 0, this.parentFragment.speedUnitValue)));
                    this.parentFragment.speedUnitFlag = !r3.speedUnitFlag;
                    break;
                }
                break;
        }
    }

    public void startProgramAnimation() {
        UserProfileView userProfileView = this.userProfileView;
        if (userProfileView != null) {
            userProfileView.startProgramAnimation();
        }
    }

    public void pauseProgramAnimation() {
        UserProfileView userProfileView = this.userProfileView;
        if (userProfileView != null) {
            userProfileView.pauseProgramAnimation();
        }
    }

    public void cancelProgramAnimation() {
        UserProfileView userProfileView = this.userProfileView;
        if (userProfileView != null) {
            userProfileView.cancelProgramAnimation();
        }
    }

    public void workoutWarmUpMode() {
        this.nowWorkoutMode = 3;
    }

    public void workoutRunningMode() {
        this.nowWorkoutMode = 4;
    }

    public void workoutCoolDownMode() {
        this.nowWorkoutMode = 5;
    }

    public void workoutPauseMode() {
        this.nowWorkoutMode = 6;
    }

    private void change4ViewToMI() {
        if (Global.BRAND == 1) {
            this.unit_4_1_text.setTextColor(this.res.getColor(R.color.light_gray));
            this.unit_4_2_text.setTextColor(this.res.getColor(R.color.black));
        } else {
            this.unit_4_1_text.setTextColor(this.res.getColor(R.color.black));
            this.unit_4_2_text.setTextColor(this.res.getColor(R.color.light_gray));
        }
    }

    private void change4ViewToKM() {
        if (Global.BRAND == 1) {
            this.unit_4_1_text.setTextColor(this.res.getColor(R.color.black));
            this.unit_4_2_text.setTextColor(this.res.getColor(R.color.light_gray));
        } else {
            this.unit_4_1_text.setTextColor(this.res.getColor(R.color.light_gray));
            this.unit_4_2_text.setTextColor(this.res.getColor(R.color.black));
        }
    }

    private void change5ViewToMI() {
        if (Global.BRAND == 1) {
            this.unit_5_1_text.setTextColor(this.res.getColor(R.color.light_gray));
            this.unit_5_2_text.setTextColor(this.res.getColor(R.color.black));
        } else {
            this.unit_5_1_text.setTextColor(this.res.getColor(R.color.black));
            this.unit_5_2_text.setTextColor(this.res.getColor(R.color.light_gray));
        }
    }

    private void change5ViewToKM() {
        if (Global.BRAND == 1) {
            this.unit_5_1_text.setTextColor(this.res.getColor(R.color.black));
            this.unit_5_2_text.setTextColor(this.res.getColor(R.color.light_gray));
        } else {
            this.unit_5_1_text.setTextColor(this.res.getColor(R.color.light_gray));
            this.unit_5_2_text.setTextColor(this.res.getColor(R.color.black));
        }
    }

    public void resetData() {
        Spanned spannedFromHtml;
        int i = DeviceModelList.programTitleTexts[ProtocolHandler.protocol.setProgramMode];
        boolean z = (i == R.string.hr1 || i == R.string.hr2) ? false : true;
        int i2 = Global.BRAND;
        if (i2 == 0) {
            this.profile_textview.setText(DeviceModelList.programTitleTexts[ProtocolHandler.protocol.setProgramMode]);
            this.profile_imageview.setImageResource(DeviceModelList.programUnselectedImages[ProtocolHandler.protocol.setProgramMode]);
            this.profile_info_textview.setText(DeviceModelList.programInfoTexts[ProtocolHandler.protocol.setProgramMode]);
            if (ProtocolHandler.protocol.deviceModel == 29 || ProtocolHandler.protocol.deviceModel == 30 || ProtocolHandler.protocol.deviceModel == 31) {
                this.display_distance_number_name_textview.setText(R.string.total_steps);
                if (ProtocolHandler.protocol.deviceUnit == 0) {
                    spannedFromHtml = Html.fromHtml(this.activity.getString(R.string.vert) + " FT/<font color=\"#FFFFFF\">MTR</font>");
                } else {
                    spannedFromHtml = Html.fromHtml(this.activity.getString(R.string.vert) + " <font color=\"#FFFFFF\">FT</font>/MTR");
                }
                this.display_target_hr_number_name_textview.setText(spannedFromHtml);
                this.display_distance_number_textview.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                this.display_target_hr_number_textview.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            } else {
                this.display_distance_number_name_textview.setText(R.string.distance);
                this.display_target_hr_number_name_textview.setText(R.string.target_hr_short);
                this.display_distance_number_textview.setText(IdManager.DEFAULT_VERSION_NAME);
                this.display_target_hr_number_textview.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                if (z) {
                    int color = this.res.getColor(R.color.light_gray);
                    if (this.display_target_hr_number_textview.getCurrentTextColor() != color) {
                        this.display_target_hr_number_textview.setTextColor(color);
                    }
                } else {
                    int color2 = this.res.getColor(R.color.display_number_blue);
                    if (this.display_target_hr_number_textview.getCurrentTextColor() != color2) {
                        this.display_target_hr_number_textview.setTextColor(color2);
                    }
                }
            }
            this.display_calories_number_textview.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.display_simple_time_textview.setText("  0:00");
            this.display_hr_number_textview.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            return;
        }
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            this.item_1_value_textview.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.item_2_value_textview.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.item_3_value_textview.setText("0:00");
            this.item_4_value_textview.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            this.item_5_value_textview.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
            DisplayMainFragment displayMainFragment = this.parentFragment;
            boolean z2 = ProtocolHandler.protocol.deviceUnit == 0;
            displayMainFragment.speedUnitFlag = z2;
            displayMainFragment.distanceUnitFlag = z2;
            updateDistanceUnit();
            this.unit_4_layout.setVisibility(0);
            int i3 = ProtocolHandler.protocol.deviceType;
            if (i3 == 0) {
                this.display_simple_profile_text.setText(this.res.getString(R.string.active_profile_speed).toUpperCase());
                if (ProtocolHandler.protocol.showInclineMode == 2) {
                    this.item_1_title_textview.setText(this.res.getString(R.string.stride).toUpperCase());
                } else {
                    this.item_1_title_textview.setText(this.res.getString(R.string.display_incline).toUpperCase());
                    this.item_1_imageview.setImageResource(R.drawable.s_display_icon_a_incline);
                }
                this.item_5_title_textview.setText(this.res.getString(R.string.speed).toUpperCase());
                this.item_5_imageview.setImageResource(R.drawable.s_display_icon_a_speed);
                this.unit_5_layout.setVisibility(0);
            } else if (i3 == 1 || i3 == 2) {
                this.display_simple_profile_text.setText(this.res.getString(R.string.active_profile_level).toUpperCase());
                this.item_1_title_textview.setText(this.res.getString(R.string.display_level).toUpperCase());
                this.item_1_imageview.setImageResource(R.drawable.s_display_icon_a_level);
                this.item_5_title_textview.setText(this.res.getString(R.string.calories).toUpperCase());
                this.item_5_imageview.setImageResource(R.drawable.s_display_icon_a_cal);
                this.unit_5_layout.setVisibility(8);
            }
            if (z) {
                this.display_simple_right_1_layout.setVisibility(0);
                this.display_simple_right_2_layout.setVisibility(8);
                this.programProfileLayout.removeAllViews();
                UserProfileView userProfileView = new UserProfileView(this.activity);
                this.userProfileView = userProfileView;
                userProfileView.resetProgramCount();
                this.userProfileView.setProgramNowPositionArray(ProtocolHandler.protocol.setUserProfiles, false);
                this.userProfileView.showProgramAnimation();
                if (Global.BRAND == 1) {
                    this.display_simple_muscle_text.setVisibility(0);
                    this.display_simple_muscle_image.setImageResource(R.drawable.s_display_ef_1);
                    this.userProfileView.setProfileColor(R.color.white);
                    ImageView imageView = new ImageView(this.activity);
                    imageView.setLayoutParams(new RelativeLayout.LayoutParams(-1, -1));
                    imageView.setBackgroundResource(R.drawable.s_display_simple_ui);
                    RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.s_display_simple_profile_width), 0.9f), Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.s_display_simple_profile_height), 1.0f));
                    int dimension = (int) this.res.getDimension(R.dimen.s_display_simple_profile_margin);
                    layoutParams.setMargins(dimension, dimension * 3, dimension, dimension);
                    this.programProfileLayout.addView(imageView);
                    this.programProfileLayout.addView(this.userProfileView, layoutParams);
                    return;
                }
                this.userProfileView.setProfileColor(R.color.xterra_program_blue);
                RelativeLayout.LayoutParams layoutParams2 = new RelativeLayout.LayoutParams(-1, -1);
                int dimension2 = ((int) this.res.getDimension(R.dimen.s_display_simple_profile_margin)) * 5;
                layoutParams2.setMargins(dimension2, 50, dimension2, 0);
                this.programProfileLayout.addView(this.userProfileView, layoutParams2);
                return;
            }
            this.display_simple_right_1_layout.setVisibility(8);
            this.display_simple_right_2_layout.setVisibility(0);
            if (Global.BRAND == 1) {
                this.display_simple_muscle_text.setVisibility(8);
                this.display_simple_muscle_image.setImageResource(R.drawable.s_display_simple_pic);
            }
        }
    }

    public void updateDistanceUnit() {
        if (this.parentFragment.distanceUnitFlag) {
            change4ViewToKM();
        } else {
            change4ViewToMI();
        }
        if (this.parentFragment.speedUnitFlag) {
            change5ViewToKM();
        } else {
            change5ViewToMI();
        }
    }

    public void resetUnitParam() {
        updateDistanceUnit();
        this.item_4_value_textview.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        this.item_5_value_textview.setText(AppEventsConstants.EVENT_PARAM_VALUE_NO);
    }

    public void updateWorkoutData(WorkoutData workoutData) {
        String str = Global.getFillString(workoutData.getMinute(), 2, "  ") + CertificateUtil.DELIMITER + Global.getFillString(workoutData.getSeconds(), 2, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        String strValueOf = String.valueOf(workoutData.getCalories());
        int heartRate = workoutData.getHeartRate();
        String strValueOf2 = String.valueOf(workoutData.getHeartRate());
        String strValueOf3 = String.valueOf(workoutData.getNowTargetHR());
        float distance = workoutData.getDistance();
        float speed = workoutData.getSpeed();
        BigDecimal bigDecimalDivide = new BigDecimal(distance).divide(new BigDecimal(1), 2, RoundingMode.HALF_UP);
        String strValueOf4 = String.valueOf(workoutData.getNowLevel());
        int i = DeviceModelList.programTitleTexts[ProtocolHandler.protocol.setProgramMode];
        boolean z = i == R.string.hr1 || i == R.string.hr2;
        int i2 = Global.BRAND;
        if (i2 == 0) {
            if (ProtocolHandler.protocol.deviceModel == 29 || ProtocolHandler.protocol.deviceModel == 30 || ProtocolHandler.protocol.deviceModel == 31) {
                this.display_distance_number_textview.setText(String.valueOf(workoutData.getTotalSteps()));
                if (ProtocolHandler.protocol.deviceModel == 29) {
                    this.display_target_hr_number_textview.setText(String.valueOf(ProtocolHandler.protocol.getVert()));
                } else {
                    this.display_target_hr_number_textview.setText(String.valueOf(workoutData.getVert()));
                }
            } else {
                this.display_distance_number_textview.setText(String.valueOf(bigDecimalDivide.floatValue()));
                if (z) {
                    this.display_target_hr_number_textview.setText(strValueOf3);
                }
            }
            this.display_calories_number_textview.setText(strValueOf);
            this.display_simple_time_textview.setText(str);
            this.display_hr_number_textview.setText(strValueOf2);
            return;
        }
        if (i2 == 1 || i2 == 2 || i2 == 3) {
            float nowIncline = workoutData.getNowIncline();
            if (ProtocolHandler.protocol.showInclineMode == 1 || ProtocolHandler.protocol.deviceModel == 133) {
                nowIncline = Global.divide(nowIncline, 2.0f, 1);
            } else if (ProtocolHandler.protocol.showInclineMode == 2) {
                nowIncline = 18.0f + Global.divide(nowIncline, 2.0f, 1);
            }
            this.parentFragment.distanceUnitValue = distance;
            this.parentFragment.speedUnitValue = speed;
            String str2 = String.format("%2.2f", Float.valueOf(ProtocolHandler.protocol.getConvertDistanceUnit(!this.parentFragment.distanceUnitFlag ? 1 : 0, distance)));
            String strValueOf5 = String.valueOf(ProtocolHandler.protocol.getConvertDistanceUnit(!this.parentFragment.speedUnitFlag ? 1 : 0, speed));
            String strValueOf6 = String.valueOf(Global.divide(nowIncline, 10.0f, 1));
            int i3 = ProtocolHandler.protocol.deviceType;
            if (i3 == 0) {
                this.item_1_value_textview.setText(strValueOf6);
                this.item_5_value_textview.setText(strValueOf5);
            } else if (i3 == 1 || i3 == 2) {
                this.item_1_value_textview.setText(strValueOf4);
                this.item_5_value_textview.setText(strValueOf);
            }
            this.item_2_value_textview.setText(strValueOf2);
            this.item_3_value_textview.setText(str);
            this.item_4_value_textview.setText(str2);
            if (Global.BRAND == 1) {
                int i4 = this.imageChangeCounter + 1;
                this.imageChangeCounter = i4;
                if (i4 >= 3 && this.nowWorkoutMode == 4 && !z) {
                    this.imageChangeCounter = 0;
                    if (nowIncline < 5.0f) {
                        if (heartRate != 0) {
                            ImageView imageView = this.display_simple_muscle_image;
                            Resources resources = this.res;
                            int[] iArr = EF_WEAK_HR;
                            imageView.setImageBitmap(Global.readBitmapFromStream(resources, iArr[this.imageIndex % iArr.length], 1));
                        } else {
                            ImageView imageView2 = this.display_simple_muscle_image;
                            Resources resources2 = this.res;
                            int[] iArr2 = EF_WEAK_NO_HR;
                            imageView2.setImageBitmap(Global.readBitmapFromStream(resources2, iArr2[this.imageIndex % iArr2.length], 1));
                        }
                    } else if (heartRate != 0) {
                        ImageView imageView3 = this.display_simple_muscle_image;
                        Resources resources3 = this.res;
                        int[] iArr3 = EF_STRONG_HR;
                        imageView3.setImageBitmap(Global.readBitmapFromStream(resources3, iArr3[this.imageIndex % iArr3.length], 1));
                    } else {
                        ImageView imageView4 = this.display_simple_muscle_image;
                        Resources resources4 = this.res;
                        int[] iArr4 = EF_STRONG_NO_HR;
                        imageView4.setImageBitmap(Global.readBitmapFromStream(resources4, iArr4[this.imageIndex % iArr4.length], 1));
                    }
                    this.imageIndex++;
                }
            }
            UserProfileView userProfileView = this.userProfileView;
            if (userProfileView == null) {
                return;
            }
            if (this.nowWorkoutMode != 4) {
                userProfileView.pauseProgramAnimation();
            }
            int programRow = workoutData.getProgramRow();
            this.userProfileView.setNowShowAnimationPosition(programRow);
            if (i == R.string.manual) {
                int i5 = ProtocolHandler.protocol.deviceType;
                if (i5 != 0) {
                    if (i5 == 1 || i5 == 2) {
                        this.userProfileView.setProgramNowManualPosition(programRow, workoutData.getNowLevel());
                        return;
                    }
                    return;
                }
                int programHeight = workoutData.getProgramHeight();
                if (programHeight != 0) {
                    this.userProfileView.setProgramNowManualPosition(programRow, programHeight);
                }
            }
        }
    }
}
