package com.dyaco.sole.fragment.display;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.AnimationDrawable;
import android.os.Handler;
import android.os.Message;
import android.text.Html;
import android.text.Spanned;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.dyaco.ideabussdk_sole.protocol.WorkoutData;
import com.dyaco.sole.activity.MainActivity;
import com.dyaco.sole.custom.DeviceModelList;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.ProtocolHandler;
import com.dyaco.sole.custom_view.TargetHRView;
import com.dyaco.sole.custom_view.TypefaceTextView;
import com.dyaco.sole.custom_view.UserProfileView;
import com.facebook.appevents.AppEventsConstants;
import com.soletreadmills.sole.R;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Timer;
import java.util.TimerTask;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public abstract class DisplayBaseLinearLayout extends FrameLayout implements View.OnClickListener {
    private static final int[] RES_ANIMATION = {R.drawable.display_t_0, R.drawable.display_t_1, R.drawable.display_t_2, R.drawable.display_t_1};
    protected MainActivity activity;
    private int animationIndex;
    private Timer animationTimer;
    private TypefaceTextView display_bottom1_number_textview;
    private TypefaceTextView display_bottom3_number_textview;
    private TypefaceTextView display_bottom5_number_textview;
    private TypefaceTextView display_bottom6_number_textview;
    private Handler handler;
    protected boolean isHRMode;
    private int pageType;
    private TextView profileNameText;
    private ImageView programImageView;
    protected Resources res;
    protected View rootView;
    private TargetHRView targetHRView;
    private UserProfileView userProfileView;

    protected abstract void findViews();

    protected abstract void initParams();

    protected abstract void resetData();

    protected abstract void setListeners();

    static /* synthetic */ int access$104(DisplayBaseLinearLayout displayBaseLinearLayout) {
        int i = displayBaseLinearLayout.animationIndex + 1;
        displayBaseLinearLayout.animationIndex = i;
        return i;
    }

    public DisplayBaseLinearLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.handler = new Handler() { // from class: com.dyaco.sole.fragment.display.DisplayBaseLinearLayout.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                DisplayBaseLinearLayout.this.programImageView.setImageResource(DisplayBaseLinearLayout.RES_ANIMATION[DisplayBaseLinearLayout.this.animationIndex]);
                DisplayBaseLinearLayout displayBaseLinearLayout = DisplayBaseLinearLayout.this;
                displayBaseLinearLayout.animationIndex = displayBaseLinearLayout.animationIndex >= DisplayBaseLinearLayout.RES_ANIMATION.length + (-1) ? 0 : DisplayBaseLinearLayout.access$104(DisplayBaseLinearLayout.this);
            }
        };
    }

    public DisplayBaseLinearLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.handler = new Handler() { // from class: com.dyaco.sole.fragment.display.DisplayBaseLinearLayout.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                DisplayBaseLinearLayout.this.programImageView.setImageResource(DisplayBaseLinearLayout.RES_ANIMATION[DisplayBaseLinearLayout.this.animationIndex]);
                DisplayBaseLinearLayout displayBaseLinearLayout = DisplayBaseLinearLayout.this;
                displayBaseLinearLayout.animationIndex = displayBaseLinearLayout.animationIndex >= DisplayBaseLinearLayout.RES_ANIMATION.length + (-1) ? 0 : DisplayBaseLinearLayout.access$104(DisplayBaseLinearLayout.this);
            }
        };
    }

    public DisplayBaseLinearLayout(Context context, int i) {
        super(context);
        this.handler = new Handler() { // from class: com.dyaco.sole.fragment.display.DisplayBaseLinearLayout.1
            @Override // android.os.Handler
            public void handleMessage(Message message) {
                DisplayBaseLinearLayout.this.programImageView.setImageResource(DisplayBaseLinearLayout.RES_ANIMATION[DisplayBaseLinearLayout.this.animationIndex]);
                DisplayBaseLinearLayout displayBaseLinearLayout = DisplayBaseLinearLayout.this;
                displayBaseLinearLayout.animationIndex = displayBaseLinearLayout.animationIndex >= DisplayBaseLinearLayout.RES_ANIMATION.length + (-1) ? 0 : DisplayBaseLinearLayout.access$104(DisplayBaseLinearLayout.this);
            }
        };
        this.pageType = i;
        init(context);
    }

    private void init(Context context) {
        this.activity = (MainActivity) context;
        this.res = getResources();
        View viewInflate = inflate(context, R.layout.include_display_view, null);
        this.rootView = viewInflate;
        addView(viewInflate);
    }

    protected void setBottomLayout() {
        if (DeviceModelList.programTitleUpperTexts == null) {
            return;
        }
        LinearLayout linearLayout = (LinearLayout) this.rootView.findViewById(R.id.display_bottom_title_layout);
        LinearLayout linearLayout2 = (LinearLayout) this.rootView.findViewById(R.id.display_bottom_number_layout);
        linearLayout.removeAllViews();
        linearLayout2.removeAllViews();
        for (int i = 0; i < DeviceModelList.bottomParamTexts.length; i++) {
            int i2 = DeviceModelList.bottomParamTexts[i];
            int longScreenHeight = Global.getLongScreenHeight(((int) this.res.getDimension(R.dimen.display_hr_percent_width)) * 2, 0.8f);
            int longScreenHeight2 = Global.getLongScreenHeight(((int) this.res.getDimension(R.dimen.display_hr_percent_width)) * 5, 0.8f);
            int longScreenHeight3 = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_hr_percent_width), 0.8f);
            int longScreenHeight4 = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_hr_percent_height), 0.8f);
            if (i2 == R.string.display_program_name) {
                longScreenHeight = longScreenHeight2;
            } else if (i2 == R.string.display_hr_percent) {
                longScreenHeight = longScreenHeight3;
            }
            if (i2 == 0) {
                float f = longScreenHeight / 2;
                linearLayout.addView(getCustomTitleTextView(StringUtils.SPACE, f));
                linearLayout2.addView(getCustomNumberTextView("", f));
            } else {
                if (i2 == R.string.display_program_name) {
                    TypefaceTextView customTitleTextView = getCustomTitleTextView(this.activity.getString(DeviceModelList.programTitleUpperTexts[ProtocolHandler.protocol.setProgramMode]).toUpperCase(), longScreenHeight);
                    FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(longScreenHeight, -2);
                    layoutParams.gravity = 17;
                    layoutParams.setMarginStart((int) Global.dpToPixel(20.0f));
                    customTitleTextView.setLayoutParams(layoutParams);
                    this.profileNameText = customTitleTextView;
                    linearLayout.addView(customTitleTextView);
                } else if (i2 != R.string.vert_ft_mtr || this.pageType == 1) {
                    linearLayout.addView(getCustomTitleTextView(i2, longScreenHeight));
                }
                switch (i2) {
                    case R.string.display_calories /* 2131689615 */:
                        TypefaceTextView customNumberTextView = getCustomNumberTextView(AppEventsConstants.EVENT_PARAM_VALUE_NO, longScreenHeight);
                        this.display_bottom3_number_textview = customNumberTextView;
                        linearLayout2.addView(customNumberTextView);
                        break;
                    case R.string.display_hr_percent /* 2131689617 */:
                        this.targetHRView = new TargetHRView(this.activity);
                        FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(longScreenHeight, longScreenHeight4);
                        layoutParams2.gravity = 17;
                        this.targetHRView.setLayoutParams(layoutParams2);
                        linearLayout2.addView(this.targetHRView);
                        break;
                    case R.string.display_program_name /* 2131689621 */:
                        this.userProfileView = new UserProfileView(this.activity);
                        this.programImageView = new ImageView(this.activity);
                        this.userProfileView.setProfileColor(R.color.display_number_blue);
                        FrameLayout.LayoutParams layoutParams3 = new FrameLayout.LayoutParams(longScreenHeight, longScreenHeight4);
                        layoutParams3.gravity = 17;
                        layoutParams3.setMarginStart((int) Global.dpToPixel(20.0f));
                        this.userProfileView.setLayoutParams(layoutParams3);
                        this.programImageView.setLayoutParams(layoutParams3);
                        this.userProfileView.setVisibility(8);
                        this.programImageView.setVisibility(8);
                        linearLayout2.addView(this.userProfileView);
                        linearLayout2.addView(this.programImageView);
                        break;
                    case R.string.display_pulse /* 2131689622 */:
                        TypefaceTextView customNumberTextView2 = getCustomNumberTextView(AppEventsConstants.EVENT_PARAM_VALUE_NO, longScreenHeight);
                        this.display_bottom1_number_textview = customNumberTextView2;
                        linearLayout2.addView(customNumberTextView2);
                        break;
                    case R.string.display_rpm /* 2131689623 */:
                        TypefaceTextView customNumberTextView3 = getCustomNumberTextView(AppEventsConstants.EVENT_PARAM_VALUE_NO, longScreenHeight);
                        this.display_bottom6_number_textview = customNumberTextView3;
                        linearLayout2.addView(customNumberTextView3);
                        break;
                    case R.string.display_watts /* 2131689627 */:
                        TypefaceTextView customNumberTextView4 = getCustomNumberTextView(AppEventsConstants.EVENT_PARAM_VALUE_NO, longScreenHeight);
                        this.display_bottom5_number_textview = customNumberTextView4;
                        linearLayout2.addView(customNumberTextView4);
                        break;
                    case R.string.vert_ft_mtr /* 2131690021 */:
                        if (this.pageType == 1) {
                            TypefaceTextView customNumberTextView5 = getCustomNumberTextView(AppEventsConstants.EVENT_PARAM_VALUE_NO, longScreenHeight);
                            this.display_bottom5_number_textview = customNumberTextView5;
                            linearLayout2.addView(customNumberTextView5);
                            break;
                        } else {
                            break;
                        }
                }
            }
        }
    }

    public void modeChanged(int i) {
        if (Global.BRAND != 0) {
            return;
        }
        if (i == 6 || i == 7 || i == 128 || i == 8) {
            UserProfileView userProfileView = this.userProfileView;
            if (userProfileView != null) {
                userProfileView.cancelProgramAnimation();
                return;
            }
            return;
        }
        if (i != 4 || this.userProfileView == null) {
            return;
        }
        updateProgramImage();
        this.userProfileView.showProgramAnimation();
    }

    protected void showProgramImage() {
        this.userProfileView.showProgramAnimation();
    }

    public void cancelProgramAnimation() {
        UserProfileView userProfileView = this.userProfileView;
        if (userProfileView != null) {
            userProfileView.cancelProgramAnimation();
        }
    }

    protected void updateProgramImage() {
        int i = DeviceModelList.programTitleUpperTexts[ProtocolHandler.protocol.setProgramMode];
        boolean z = i == R.string.hr1 || i == R.string.hr2;
        this.profileNameText.setText(this.activity.getString(i).toUpperCase());
        this.userProfileView.resetProgramCount();
        this.userProfileView.setProgramNowPositionArray(ProtocolHandler.protocol.setUserProfiles, false);
        if (z) {
            this.userProfileView.setVisibility(8);
            this.programImageView.setVisibility(0);
            AnimationDrawable animationDrawable = (AnimationDrawable) getResources().getDrawable(R.drawable.display_hr1_anim);
            AnimationDrawable animationDrawable2 = (AnimationDrawable) getResources().getDrawable(R.drawable.display_hr2_anim);
            this.programImageView.setImageDrawable(i == R.string.hr1 ? animationDrawable : animationDrawable2);
            animationDrawable.start();
            animationDrawable2.start();
            return;
        }
        int i2 = Global.getSharedPreferences(this.activity).getInt("nowWorkoutMode", -1);
        Log.d("DisplayBaseLinearLayout", "updateProgramImage-----lastWorkoutMode = " + i2);
        if (ProtocolHandler.protocol.deviceType == 0 && (i2 == 3 || i2 == 5)) {
            this.userProfileView.setVisibility(8);
            this.programImageView.setVisibility(0);
            this.programImageView.setImageResource(R.drawable.display_t_0);
        } else {
            this.programImageView.setVisibility(8);
            this.userProfileView.setVisibility(0);
        }
    }

    protected void updateWorkoutData(WorkoutData workoutData) {
        if (Global.BRAND != 0) {
            return;
        }
        String strValueOf = String.valueOf(workoutData.getCalories());
        String strValueOf2 = String.valueOf(workoutData.getHeartRate());
        String strValueOf3 = String.valueOf(workoutData.getRpm());
        int i = DeviceModelList.programTitleTexts[ProtocolHandler.protocol.setProgramMode];
        this.display_bottom1_number_textview.setText(strValueOf2);
        this.targetHRView.setLevel(new BigDecimal(workoutData.getHeartRate() * 100).divide(new BigDecimal(ProtocolHandler.protocol.setMaxTargetHR), 0, RoundingMode.FLOOR).intValue());
        this.display_bottom3_number_textview.setText(strValueOf);
        if (ProtocolHandler.protocol.deviceModel != 29 && ProtocolHandler.protocol.deviceModel != 30) {
            if (ProtocolHandler.protocol.deviceModel == 31) {
                if (this.pageType == 1) {
                    this.display_bottom5_number_textview.setText(String.valueOf(workoutData.getVert()));
                }
            } else {
                this.display_bottom5_number_textview.setText(String.valueOf(workoutData.getWatt()));
                if (ProtocolHandler.protocol.deviceType == 2) {
                    this.display_bottom6_number_textview.setText(strValueOf3);
                }
            }
        }
        int programRow = workoutData.getProgramRow();
        this.userProfileView.setNowShowAnimationPosition(programRow);
        if (i == R.string.manual) {
            int i2 = ProtocolHandler.protocol.deviceType;
            if (i2 != 0) {
                if (i2 == 1 || i2 == 2) {
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

    public void workoutWarmUpMode() {
        if (Global.BRAND != 0) {
            return;
        }
        this.programImageView.setVisibility(0);
        this.userProfileView.setVisibility(8);
        cancelAnimationTimer();
        Timer timer = new Timer();
        this.animationTimer = timer;
        timer.schedule(new TimerTask() { // from class: com.dyaco.sole.fragment.display.DisplayBaseLinearLayout.2
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                DisplayBaseLinearLayout.this.handler.sendEmptyMessage(0);
            }
        }, 300L, 150L);
    }

    public void workoutRunningMode() {
        if (Global.BRAND != 0) {
            return;
        }
        int i = DeviceModelList.programTitleUpperTexts[ProtocolHandler.protocol.setProgramMode];
        if (i == R.string.hr1 || i == R.string.hr2) {
            this.userProfileView.setVisibility(8);
            this.programImageView.setVisibility(0);
        } else {
            this.programImageView.setVisibility(8);
            this.userProfileView.setVisibility(0);
        }
        cancelAnimationTimer();
    }

    public void workoutCoolDownMode() {
        if (Global.BRAND != 0) {
            return;
        }
        this.programImageView.setVisibility(0);
        this.userProfileView.setVisibility(8);
        cancelAnimationTimer();
        Timer timer = new Timer();
        this.animationTimer = timer;
        timer.schedule(new TimerTask() { // from class: com.dyaco.sole.fragment.display.DisplayBaseLinearLayout.3
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                DisplayBaseLinearLayout.this.handler.sendEmptyMessage(0);
            }
        }, 300L, 150L);
    }

    public void workoutPauseMode() {
        cancelAnimationTimer();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cancelAnimationTimer() {
        Timer timer = this.animationTimer;
        if (timer != null) {
            timer.cancel();
            this.animationTimer = null;
        }
    }

    public void refreshView() {
        if (Global.BRAND != 0) {
            return;
        }
        this.handler.postDelayed(new AnonymousClass4(), 1000L);
    }

    /* renamed from: com.dyaco.sole.fragment.display.DisplayBaseLinearLayout$4, reason: invalid class name */
    class AnonymousClass4 implements Runnable {
        AnonymousClass4() {
        }

        @Override // java.lang.Runnable
        public void run() {
            DisplayBaseLinearLayout.this.activity.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.fragment.display.DisplayBaseLinearLayout.4.1
                @Override // java.lang.Runnable
                public void run() {
                    int i = Global.getSharedPreferences(DisplayBaseLinearLayout.this.activity).getInt("nowWorkoutMode", -1);
                    Log.d("DisplayBaseLinearLayout", "refreshView-----lastWorkoutMode = " + i);
                    if (i == 3) {
                        DisplayBaseLinearLayout.this.programImageView.setVisibility(0);
                        DisplayBaseLinearLayout.this.userProfileView.setVisibility(8);
                        DisplayBaseLinearLayout.this.cancelAnimationTimer();
                        DisplayBaseLinearLayout.this.animationTimer = new Timer();
                        DisplayBaseLinearLayout.this.animationTimer.schedule(new TimerTask() { // from class: com.dyaco.sole.fragment.display.DisplayBaseLinearLayout.4.1.1
                            @Override // java.util.TimerTask, java.lang.Runnable
                            public void run() {
                                DisplayBaseLinearLayout.this.handler.sendEmptyMessage(0);
                            }
                        }, 300L, 150L);
                        return;
                    }
                    if (i == 4) {
                        int i2 = DeviceModelList.programTitleUpperTexts[ProtocolHandler.protocol.setProgramMode];
                        if (i2 == R.string.hr1 || i2 == R.string.hr2) {
                            DisplayBaseLinearLayout.this.userProfileView.setVisibility(8);
                            DisplayBaseLinearLayout.this.programImageView.setVisibility(0);
                        } else {
                            DisplayBaseLinearLayout.this.programImageView.setVisibility(8);
                            DisplayBaseLinearLayout.this.userProfileView.setVisibility(0);
                        }
                    }
                }
            });
        }
    }

    private TypefaceTextView getCustomTitleTextView(int i, float f) {
        return getCustomTitleTextView(this.activity.getString(i), f);
    }

    private TypefaceTextView getCustomTitleTextView(String str, float f) {
        Spanned spannedFromHtml;
        TypefaceTextView typefaceTextView = new TypefaceTextView(this.activity);
        typefaceTextView.setTypeface(this.activity, Global.fontsPath[3]);
        typefaceTextView.setTextColor(this.res.getColor(R.color.white));
        typefaceTextView.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_title_text_size), 0.8f));
        if (str != null) {
            if (this.activity.getString(R.string.vert_ft_mtr).equals(str)) {
                if (ProtocolHandler.protocol.deviceUnit == 0) {
                    spannedFromHtml = Html.fromHtml(this.activity.getString(R.string.vert) + " <font color=\"#7B7B7B\">FT</font>/MTR");
                } else {
                    spannedFromHtml = Html.fromHtml(this.activity.getString(R.string.vert) + " FT/<font color=\"#7B7B7B\">MTR</font>");
                }
                typefaceTextView.setText(spannedFromHtml);
            } else {
                typefaceTextView.setText(str);
            }
        }
        typefaceTextView.setGravity(17);
        typefaceTextView.setLayoutParams(new FrameLayout.LayoutParams((int) f, -2));
        return typefaceTextView;
    }

    private TypefaceTextView getCustomNumberTextView(String str, float f) {
        TypefaceTextView typefaceTextView = new TypefaceTextView(this.activity);
        typefaceTextView.setLines(1);
        typefaceTextView.setTypeface(this.activity, Global.fontsPath[0]);
        typefaceTextView.setTextColor(this.res.getColor(R.color.display_number_blue));
        typefaceTextView.setTextSize(0, Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.display_bottom_number_text_size), 0.9f));
        typefaceTextView.setText(str);
        typefaceTextView.setGravity(17);
        typefaceTextView.setLayoutParams(new FrameLayout.LayoutParams((int) f, -2));
        return typefaceTextView;
    }
}
