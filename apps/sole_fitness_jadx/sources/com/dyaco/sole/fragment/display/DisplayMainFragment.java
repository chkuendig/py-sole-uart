package com.dyaco.sole.fragment.display;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;
import com.digifly.cloudapi.CloudApi;
import com.digifly.cloudapi.data.DCTrainingData;
import com.digifly.cloudapi.data.DCTrainingDetailData;
import com.digifly.cloudapi.data.MemberData;
import com.digifly.cloudapi.data.ResponseDataCollection;
import com.digifly.cloudapi.listener.DCUploadTrainingDataListener;
import com.digifly.cloudapi.listener.DCUploadTrainingDetailDataListener;
import com.digifly.dbapi.DbManager;
import com.digifly.dbapi.greeddao_gen.DCTrainingDataDao;
import com.digifly.dbapi.greeddao_gen.DCTrainingDetailDataDao;
import com.digifly.dbapi.greeddao_gen.MemberDataDao;
import com.dyaco.ideabussdk_sole.library.MyVariable;
import com.dyaco.ideabussdk_sole.protocol.EndWorkoutData;
import com.dyaco.ideabussdk_sole.protocol.SoleProtocol;
import com.dyaco.ideabussdk_sole.protocol.WorkoutData;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.MyApp;
import com.dyaco.sole.activity.FitbitAuthenticationActivity;
import com.dyaco.sole.activity.MainActivity;
import com.dyaco.sole.activity.MapMyFitnessActivity;
import com.dyaco.sole.custom.CalendarUtils;
import com.dyaco.sole.custom.DeviceModelList;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.PostUtil;
import com.dyaco.sole.custom.ProtocolHandler;
import com.dyaco.sole.custom_view.TypefaceTextView;
import com.dyaco.sole.fragment.BaseFragment;
import com.facebook.appevents.AppEventsConstants;
import com.soletreadmills.sole.R;
import java.io.IOException;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

/* loaded from: classes.dex */
public class DisplayMainFragment extends BaseFragment implements View.OnClickListener, ProtocolHandler.OnDataResultListener, ProtocolHandler.OnWorkoutResultListener {
    public static final int DISPLAY_DASHBOARD = 83;
    public static final int DISPLAY_SIMPLE = 81;
    public static final int DISPLAY_TRACK = 82;
    public static final String TAG = "DisplayMainFragment";
    private MainActivity activity;
    private AlertDialog alertDialog;
    private View bottom_layout;
    public int caloriesLayoutFlag;
    public String caloriesValue;
    private FrameLayout content_layout;
    private ImageView control_1_image;
    private View control_1_layout;
    private TypefaceTextView control_1_text;
    private ImageView control_2_image;
    private View control_2_layout;
    private TypefaceTextView control_2_text;
    private ImageView control_3_image;
    private View control_3_layout;
    private TypefaceTextView control_3_text;
    private ImageView control_4_image;
    private View control_4_layout;
    private TypefaceTextView control_4_text;
    private DisplayDashboardLinearLayout dashboardLinearLayout;
    private TypefaceTextView display_dashboard_textview;
    private ImageView display_pause_imageview;
    private LinearLayout display_pause_layout;
    private TextView display_pause_textview;
    private TypefaceTextView display_simple_textview;
    private LinearLayout display_stop_layout;
    private TypefaceTextView display_track_textview;
    public boolean distanceUnitFlag;
    public float distanceUnitValue;
    private boolean isHRMode;
    public boolean isPaceOrLapsUnitFlag;
    private boolean isSafekeyDialogShown;
    public String lapsUnitValue;
    private int nowWorkoutMode;
    public String paceUnitValue;
    private LinearLayout param_layout;
    private ImageView pause_image;
    private TypefaceTextView pause_text;
    private Resources res;
    private View rootView;
    private DisplaySimpleLinearLayout simpleFrameLayout;
    public boolean speedUnitFlag;
    public float speedUnitValue;
    private ImageView stop_image;
    private TypefaceTextView stop_text;
    private String trackCalories;
    private String trackDistance;
    private String trackDuration;
    private String trackHeartRate;
    private DisplayTrackLinearLayout trackLinearLayout;
    private String trackSpeed;
    private String trackStartDate;
    private String shareRecording = "";
    private boolean isPauseMode = true;
    public boolean isSaveEndData = false;
    private int nowDisplayPage = 81;
    private int nowLevel = 1;
    private int nowIncline = 1;
    private float nowSpeed = 0.6f;
    protected int nowTargetHR = 60;
    int hrType = -1;
    private boolean isEndWorkoutMode = false;
    private int totalHR = 0;
    private int totalHRCount = 0;
    private ProtocolHandler.UpdateAutoConnectedListener updateAutoConnectedListener = new ProtocolHandler.UpdateAutoConnectedListener() { // from class: com.dyaco.sole.fragment.display.DisplayMainFragment.6
        @Override // com.dyaco.sole.custom.ProtocolHandler.UpdateAutoConnectedListener
        public void updateAutoConnectedShowScanView(final boolean z) {
            DisplayMainFragment.this.activity.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.fragment.display.DisplayMainFragment.6.1
                @Override // java.lang.Runnable
                public void run() {
                    ProgressBar progressBar = (ProgressBar) DisplayMainFragment.this.rootView.findViewById(R.id.loading_auto_connected);
                    if (z) {
                        progressBar.setVisibility(0);
                    } else {
                        progressBar.setVisibility(8);
                    }
                }
            });
        }
    };

    @Override // android.app.Fragment
    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        super.onCreateView(layoutInflater, viewGroup, bundle);
        this.activity = (MainActivity) getActivity();
        int i = Global.BRAND;
        if (i == 0) {
            this.rootView = layoutInflater.inflate(R.layout.fragment_display_main, viewGroup, false);
        } else if (i == 1) {
            this.rootView = layoutInflater.inflate(R.layout.s_fragment_display_main, viewGroup, false);
        } else if (i == 2 || i == 3) {
            this.rootView = layoutInflater.inflate(R.layout.x_fragment_display_main, viewGroup, false);
        }
        findViews();
        initParams();
        setListeners();
        return this.rootView;
    }

    @Override // android.app.Fragment
    public void onStart() {
        super.onStart();
        if (Global.BRAND == 0) {
            this.trackLinearLayout.onStart();
        }
        DbManager.getInstance(this.activity);
    }

    @Override // android.app.Fragment
    public void onHiddenChanged(boolean z) {
        super.onHiddenChanged(z);
        if (this.activity == null) {
            return;
        }
        if (!z) {
            resetData();
            ProtocolHandler.protocol.setOnWorkoutResultListener(this);
            ProtocolHandler.protocol.setAutoConnectedEnable(true);
            ProtocolHandler.protocol.setAutoConnectedCount(0);
            ProtocolHandler.protocol.setUpdateAutoConnectedListener(this.updateAutoConnectedListener);
            ((ProgressBar) this.rootView.findViewById(R.id.loading_auto_connected)).setVisibility(8);
            int i = Global.BRAND;
            if (i == 0) {
                if (ProtocolHandler.protocol.salesVersion == 0) {
                    this.display_stop_layout.setVisibility(0);
                    this.display_pause_layout.setVisibility(0);
                    return;
                } else {
                    this.display_stop_layout.setVisibility(4);
                    this.display_pause_layout.setVisibility(4);
                    return;
                }
            }
            if (i == 1 || i == 2 || i == 3) {
                if (ProtocolHandler.protocol.salesVersion == 0) {
                    this.bottom_layout.setVisibility(0);
                } else {
                    this.bottom_layout.setVisibility(8);
                }
                this.activity.hideBottomRedLine();
                return;
            }
            return;
        }
        ProtocolHandler.protocol.setAutoConnectedEnable(false);
        ProtocolHandler.protocol.setAutoConnectedCount(0);
        ProtocolHandler.protocol.setAutoConnectedMacAddress(null);
        ProtocolHandler.protocol.setUpdateAutoConnectedListener(null);
        this.activity.setAutoConnectedScaningUpdateWorkoutDataThreadRuningFlag(false);
        int i2 = Global.BRAND;
        if (i2 == 0) {
            this.trackLinearLayout.onDestroy();
        } else if (i2 == 1 || i2 == 2 || i2 == 3) {
            this.simpleFrameLayout.cancelProgramAnimation();
            this.activity.showBottomRedLine();
        }
    }

    public void showInfoDialog() {
        if (ProtocolHandler.protocol.salesVersion == 1) {
            setDialogHasButton(R.string.display_alert_waiting_start);
        }
    }

    public void refreshView() {
        ProtocolHandler.protocol.setOnWorkoutResultListener(this);
        this.trackLinearLayout.refreshView();
        this.dashboardLinearLayout.refreshView();
    }

    private void setDialogNoButton(final int i) {
        ErrorLogSave.addErrorString(getActivity(), ErrorLogSave.CLICK, "DisplayMainFragment_setDialogNoButton", "click_messageId:" + getString(i));
        this.activity.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.fragment.display.DisplayMainFragment.1
            @Override // java.lang.Runnable
            public void run() {
                DisplayMainFragment.this.cancelDialog();
                AlertDialog.Builder cancelable = new AlertDialog.Builder(DisplayMainFragment.this.activity).setTitle(Global.ALERT_TITLE_RID).setMessage(i).setCancelable(false);
                DisplayMainFragment.this.alertDialog = cancelable.create();
                DisplayMainFragment.this.alertDialog.show();
            }
        });
    }

    private void setDialogHasButton(final int i) {
        ErrorLogSave.addErrorString(getActivity(), ErrorLogSave.CLICK, "DisplayMainFragment_setDialogHasButton", "click_messageId:" + getString(i));
        this.activity.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.fragment.display.DisplayMainFragment.2
            @Override // java.lang.Runnable
            public void run() {
                DisplayMainFragment.this.cancelDialog();
                AlertDialog.Builder positiveButton = new AlertDialog.Builder(DisplayMainFragment.this.activity).setTitle(Global.ALERT_TITLE_RID).setMessage(i).setPositiveButton(R.string.confirm, new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.fragment.display.DisplayMainFragment.2.1
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i2) {
                        ErrorLogSave.addErrorString(DisplayMainFragment.this.getActivity(), ErrorLogSave.CLICK, "DisplayMainFragment_setDialogHasButton_Pos", ErrorLogSave.CLICK);
                        DisplayMainFragment.this.cancelDialog();
                    }
                });
                DisplayMainFragment.this.alertDialog = positiveButton.create();
                DisplayMainFragment.this.alertDialog.show();
            }
        });
    }

    private void setDialogButton(final int i, final int i2) {
        Log.e("getEndMessage", "type : " + i);
        ErrorLogSave.addErrorString(getActivity(), ErrorLogSave.CLICK, "DisplayMainFragment_setDialogButton", "click_type:" + i + "_messageId:" + getString(i2));
        this.activity.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.fragment.display.DisplayMainFragment.3
            @Override // java.lang.Runnable
            public void run() {
                DisplayMainFragment.this.cancelDialog();
                AlertDialog.Builder message = new AlertDialog.Builder(DisplayMainFragment.this.activity).setTitle(Global.ALERT_TITLE_RID).setCancelable(false).setMessage(i2);
                int i3 = i;
                if (i3 == 0) {
                    message.setPositiveButton(R.string.continue_text, new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.fragment.display.DisplayMainFragment.3.2
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i4) throws IOException {
                            ErrorLogSave.addErrorString(DisplayMainFragment.this.getActivity(), ErrorLogSave.CLICK, "DisplayMainFragment_setDialogButton_0_Pos", ErrorLogSave.CLICK);
                            if (ProtocolHandler.protocol.isConnected()) {
                                ProtocolHandler.protocol.restartWorkout();
                            }
                        }
                    }).setNegativeButton(R.string.dialog_stop, new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.fragment.display.DisplayMainFragment.3.1
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i4) throws NumberFormatException, IOException {
                            ErrorLogSave.addErrorString(DisplayMainFragment.this.getActivity(), ErrorLogSave.CLICK, "DisplayMainFragment_setDialogButton_Neg", ErrorLogSave.CLICK);
                            if (ProtocolHandler.protocol.isConnected()) {
                                ProtocolHandler.protocol.pauseWorkout();
                            }
                        }
                    });
                } else if (i3 != 2) {
                    message.setPositiveButton(R.string.no, new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.fragment.display.DisplayMainFragment.3.4
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i4) {
                            ErrorLogSave.addErrorString(DisplayMainFragment.this.getActivity(), ErrorLogSave.CLICK, "DisplayMainFragment_setDialogButton_1_Pos", ErrorLogSave.CLICK);
                            if (ProtocolHandler.protocol.isConnected()) {
                                DisplayMainFragment.this.alertDialog.dismiss();
                            }
                        }
                    }).setNegativeButton(R.string.yes, new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.fragment.display.DisplayMainFragment.3.3
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i4) throws NumberFormatException, IOException {
                            ErrorLogSave.addErrorString(DisplayMainFragment.this.getActivity(), ErrorLogSave.CLICK, "DisplayMainFragment_setDialogButton_1_Neg", ErrorLogSave.CLICK);
                            if (ProtocolHandler.protocol.isConnected()) {
                                ProtocolHandler.protocol.stopWorkout();
                            }
                        }
                    });
                } else {
                    message.setPositiveButton(R.string.continue_text, new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.fragment.display.DisplayMainFragment.3.5
                        @Override // android.content.DialogInterface.OnClickListener
                        public void onClick(DialogInterface dialogInterface, int i4) throws NumberFormatException, IOException {
                            ErrorLogSave.addErrorString(DisplayMainFragment.this.getActivity(), ErrorLogSave.CLICK, "DisplayMainFragment_setDialogButton_2_Pos", ErrorLogSave.CLICK);
                            if (i2 == R.string.no_safe_key) {
                                DisplayMainFragment.this.isSafekeyDialogShown = false;
                            }
                            if (ProtocolHandler.protocol.isConnected()) {
                                ProtocolHandler.protocol.pauseWorkout();
                            }
                        }
                    });
                }
                DisplayMainFragment.this.alertDialog = message.create();
                DisplayMainFragment.this.alertDialog.show();
            }
        });
    }

    public void cancelDialog() {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog == null || !alertDialog.isShowing()) {
            return;
        }
        this.alertDialog.dismiss();
    }

    public void cancelSafeKeyDialog() {
        AlertDialog alertDialog = this.alertDialog;
        if (alertDialog != null && alertDialog.isShowing() && this.isSafekeyDialogShown) {
            this.alertDialog.dismiss();
            this.isSafekeyDialogShown = false;
        }
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void findViews() {
        int i = Global.BRAND;
        if (i == 0) {
            this.display_stop_layout = (LinearLayout) this.rootView.findViewById(R.id.display_stop_layout);
            this.display_pause_layout = (LinearLayout) this.rootView.findViewById(R.id.display_pause_layout);
            this.display_pause_textview = (TextView) this.rootView.findViewById(R.id.display_pause_textview);
            this.display_pause_imageview = (ImageView) this.rootView.findViewById(R.id.display_pause_imageview);
        } else if (i == 1) {
            this.bottom_layout = this.rootView.findViewById(R.id.bottom_layout);
            this.stop_text = (TypefaceTextView) this.rootView.findViewById(R.id.stop_text);
            this.pause_text = (TypefaceTextView) this.rootView.findViewById(R.id.pause_text);
            this.control_1_text = (TypefaceTextView) this.rootView.findViewById(R.id.control_1_text);
            this.control_2_text = (TypefaceTextView) this.rootView.findViewById(R.id.control_2_text);
            this.control_3_text = (TypefaceTextView) this.rootView.findViewById(R.id.control_3_text);
            this.control_4_text = (TypefaceTextView) this.rootView.findViewById(R.id.control_4_text);
            this.control_1_image = (ImageView) this.rootView.findViewById(R.id.control_1_image);
            this.control_2_image = (ImageView) this.rootView.findViewById(R.id.control_2_image);
            this.control_3_image = (ImageView) this.rootView.findViewById(R.id.control_3_image);
            this.control_4_image = (ImageView) this.rootView.findViewById(R.id.control_4_image);
            this.control_1_layout = this.rootView.findViewById(R.id.control_1_layout);
            this.control_2_layout = this.rootView.findViewById(R.id.control_2_layout);
            this.control_3_layout = this.rootView.findViewById(R.id.control_3_layout);
            this.control_4_layout = this.rootView.findViewById(R.id.control_4_layout);
        } else if (i == 2 || i == 3) {
            this.param_layout = (LinearLayout) this.rootView.findViewById(R.id.param_layout);
            this.bottom_layout = this.rootView.findViewById(R.id.bottom_layout);
            this.stop_image = (ImageView) this.rootView.findViewById(R.id.stop_image);
            this.pause_image = (ImageView) this.rootView.findViewById(R.id.pause_image);
            this.control_1_image = (ImageView) this.rootView.findViewById(R.id.x_control_1_image);
            this.control_2_image = (ImageView) this.rootView.findViewById(R.id.x_control_2_image);
            this.control_3_image = (ImageView) this.rootView.findViewById(R.id.x_control_3_image);
            this.control_4_image = (ImageView) this.rootView.findViewById(R.id.x_control_4_image);
            this.control_1_text = (TypefaceTextView) this.rootView.findViewById(R.id.control_1_text);
            this.control_3_text = (TypefaceTextView) this.rootView.findViewById(R.id.control_3_text);
        }
        this.display_simple_textview = (TypefaceTextView) this.rootView.findViewById(R.id.display_simple_textview);
        this.display_track_textview = (TypefaceTextView) this.rootView.findViewById(R.id.display_track_textview);
        this.display_dashboard_textview = (TypefaceTextView) this.rootView.findViewById(R.id.display_dashboard_textview);
        this.content_layout = (FrameLayout) this.rootView.findViewById(R.id.content_layout);
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void initParams() {
        this.res = getResources();
        ProtocolHandler.protocol.addOnDataResultListener(this);
        int i = Global.BRAND;
        if (i == 0) {
            this.display_simple_textview.setTypeface(this.activity, Global.fontsPath[3]);
            this.display_track_textview.setTypeface(this.activity, Global.fontsPath[3]);
            this.display_dashboard_textview.setTypeface(this.activity, Global.fontsPath[3]);
            this.display_pause_textview.setText(R.string.play);
            this.display_pause_imageview.setImageResource(R.drawable.display_btn_icon_a_play);
        } else if (i == 1 || i == 2 || i == 3) {
            TypefaceTextView typefaceTextView = (TypefaceTextView) this.rootView.findViewById(R.id.display_workout_textview);
            if (Global.BRAND == 1) {
                this.pause_text.setText(R.string.play);
                this.display_simple_textview.setBackgroundResource(R.drawable.s_all_bottom_btn_0);
                this.display_track_textview.setBackgroundResource(R.drawable.s_all_bottom_btn_0);
                this.display_dashboard_textview.setBackgroundResource(R.drawable.s_all_bottom_btn_0);
            } else {
                this.display_simple_textview.setBackgroundResource(R.drawable.x_all_bottom_btn_0);
                this.display_track_textview.setBackgroundResource(R.drawable.x_all_bottom_btn_0);
                this.display_dashboard_textview.setBackgroundResource(R.drawable.x_all_bottom_btn_0);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.param_layout.getLayoutParams();
                layoutParams.height = Global.getLongScreenHeight((int) this.res.getDimension(R.dimen.s_display_dashboard_bottom_layout_height), 0.8f);
                this.param_layout.setLayoutParams(layoutParams);
            }
            typefaceTextView.setText(getString(R.string.workout_view).toUpperCase());
            this.display_simple_textview.setText(getString(R.string.simple).toUpperCase());
            this.display_track_textview.setText(getString(R.string.track).toUpperCase());
            this.display_dashboard_textview.setText(getString(R.string.dashboard).toUpperCase());
        }
        initSimpleView();
        initTrackView();
        initDashboard();
    }

    @Override // com.dyaco.sole.fragment.BaseFragment
    protected void setListeners() {
        int i = Global.BRAND;
        if (i == 0) {
            this.display_stop_layout.setOnClickListener(this);
            this.display_pause_layout.setOnClickListener(this);
        } else if (i == 1) {
            this.stop_text.setOnClickListener(this);
            this.pause_text.setOnClickListener(this);
            this.control_1_layout.setOnClickListener(this);
            this.control_2_layout.setOnClickListener(this);
            this.control_3_layout.setOnClickListener(this);
            this.control_4_layout.setOnClickListener(this);
        } else if (i == 2 || i == 3) {
            this.stop_image.setOnClickListener(this);
            this.pause_image.setOnClickListener(this);
            this.control_1_image.setOnClickListener(this);
            this.control_2_image.setOnClickListener(this);
            this.control_3_image.setOnClickListener(this);
            this.control_4_image.setOnClickListener(this);
        }
        this.display_simple_textview.setOnClickListener(this);
        this.display_track_textview.setOnClickListener(this);
        this.display_dashboard_textview.setOnClickListener(this);
    }

    private void initSimpleView() {
        DisplaySimpleLinearLayout displaySimpleLinearLayout = new DisplaySimpleLinearLayout(this.activity, this);
        this.simpleFrameLayout = displaySimpleLinearLayout;
        this.content_layout.addView(displaySimpleLinearLayout);
    }

    private void initTrackView() {
        DisplayTrackLinearLayout displayTrackLinearLayout = new DisplayTrackLinearLayout(this.activity, this);
        this.trackLinearLayout = displayTrackLinearLayout;
        displayTrackLinearLayout.setAlpha(0.0f);
        this.content_layout.addView(this.trackLinearLayout);
    }

    private void initDashboard() {
        DisplayDashboardLinearLayout displayDashboardLinearLayout = new DisplayDashboardLinearLayout(this.activity, this);
        this.dashboardLinearLayout = displayDashboardLinearLayout;
        displayDashboardLinearLayout.setVisibility(8);
        this.content_layout.addView(this.dashboardLinearLayout);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IOException, NumberFormatException {
        switch (view.getId()) {
            case R.id.control_1_layout /* 2131231043 */:
                ErrorLogSave.addErrorString(getActivity(), ErrorLogSave.CLICK, "DisplayMainFragment_control_1", "click_deviceType:" + ProtocolHandler.protocol.deviceType + "_isHRMode:" + String.valueOf(this.isHRMode));
                int i = ProtocolHandler.protocol.deviceType;
                if (i == 0) {
                    setInclineUp();
                    break;
                } else if (i == 1) {
                    if (!this.isHRMode) {
                        setLevelDown();
                        break;
                    }
                } else if (i == 2) {
                    if (this.isHRMode) {
                        setInclineDown();
                        break;
                    } else {
                        setInclineUp();
                        break;
                    }
                }
                break;
            case R.id.control_2_layout /* 2131231046 */:
                ErrorLogSave.addErrorString(getActivity(), ErrorLogSave.CLICK, "DisplayMainFragment_control_2", "click_deviceType:" + ProtocolHandler.protocol.deviceType + "_isHRMode:" + String.valueOf(this.isHRMode));
                int i2 = ProtocolHandler.protocol.deviceType;
                if (i2 == 0) {
                    setInclineDown();
                    break;
                } else if (i2 == 2) {
                    setInclineDown();
                    break;
                }
                break;
            case R.id.control_3_layout /* 2131231049 */:
                ErrorLogSave.addErrorString(getActivity(), ErrorLogSave.CLICK, "DisplayMainFragment_control_3", "click_deviceType:" + ProtocolHandler.protocol.deviceType + "_isHRMode:" + String.valueOf(this.isHRMode));
                int i3 = ProtocolHandler.protocol.deviceType;
                if (i3 == 0) {
                    setLevelDown();
                    break;
                } else if (i3 == 2) {
                    setLevelDown();
                    break;
                }
                break;
            case R.id.control_4_layout /* 2131231052 */:
                ErrorLogSave.addErrorString(getActivity(), ErrorLogSave.CLICK, "DisplayMainFragment_control_4", "click_deviceType:" + ProtocolHandler.protocol.deviceType + "_isHRMode:" + String.valueOf(this.isHRMode));
                int i4 = ProtocolHandler.protocol.deviceType;
                if (i4 == 0) {
                    setLevelUp();
                    break;
                } else if (i4 == 1) {
                    if (!this.isHRMode) {
                        setLevelUp();
                        break;
                    }
                } else if (i4 == 2) {
                    if (this.isHRMode) {
                        setInclineUp();
                        break;
                    } else {
                        setLevelUp();
                        break;
                    }
                }
                break;
            case R.id.display_dashboard_textview /* 2131231128 */:
                ErrorLogSave.addErrorString(getActivity(), ErrorLogSave.CLICK, "DisplayMainFragment_display_dashboard", ErrorLogSave.CLICK);
                PostUtil.postTrackerData(this.activity, 8);
                switchView(83);
                break;
            case R.id.display_pause_layout /* 2131231136 */:
            case R.id.pause_image /* 2131231477 */:
            case R.id.pause_text /* 2131231478 */:
                ErrorLogSave.addErrorString(getActivity(), ErrorLogSave.CLICK, "DisplayMainFragment_pause", "click_isPauseMode:" + String.valueOf(this.isPauseMode));
                if (this.isPauseMode) {
                    ProtocolHandler.protocol.restartWorkout();
                    break;
                } else {
                    ProtocolHandler.protocol.pauseWorkout();
                    break;
                }
            case R.id.display_simple_textview /* 2131231154 */:
                ErrorLogSave.addErrorString(getActivity(), ErrorLogSave.CLICK, "DisplayMainFragment_display_simple", ErrorLogSave.CLICK);
                PostUtil.postTrackerData(this.activity, 6);
                switchView(81);
                break;
            case R.id.display_stop_layout /* 2131231158 */:
            case R.id.stop_image /* 2131231694 */:
            case R.id.stop_text /* 2131231695 */:
                ErrorLogSave.addErrorString(getActivity(), ErrorLogSave.CLICK, "DisplayMainFragment_stop", ErrorLogSave.CLICK);
                setDialogButton(1, R.string.stop_workout);
                break;
            case R.id.display_track_textview /* 2131231160 */:
                ErrorLogSave.addErrorString(getActivity(), ErrorLogSave.CLICK, "DisplayMainFragment_display_track", ErrorLogSave.CLICK);
                PostUtil.postTrackerData(this.activity, 7);
                switchView(82);
                break;
            case R.id.x_control_1_image /* 2131231883 */:
                ErrorLogSave.addErrorString(getActivity(), ErrorLogSave.CLICK, "DisplayMainFragment_x_control_1", "click_deviceType:" + ProtocolHandler.protocol.deviceType + "_isHRMode:" + String.valueOf(this.isHRMode));
                int i5 = ProtocolHandler.protocol.deviceType;
                if (i5 == 0) {
                    setInclineDown();
                    break;
                } else if (i5 == 1) {
                    if (!this.isHRMode) {
                        setLevelDown();
                        break;
                    }
                } else if (i5 == 2) {
                    if (this.isHRMode) {
                        setInclineDown();
                        break;
                    } else {
                        setInclineDown();
                        break;
                    }
                }
                break;
            case R.id.x_control_2_image /* 2131231884 */:
                ErrorLogSave.addErrorString(getActivity(), ErrorLogSave.CLICK, "DisplayMainFragment_x_control_2", "click_deviceType:" + ProtocolHandler.protocol.deviceType + "_isHRMode:" + String.valueOf(this.isHRMode));
                int i6 = ProtocolHandler.protocol.deviceType;
                if (i6 == 0) {
                    setInclineUp();
                    break;
                } else if (i6 == 1) {
                    if (!this.isHRMode) {
                        setLevelUp();
                        break;
                    }
                } else if (i6 == 2) {
                    if (this.isHRMode) {
                        setInclineUp();
                        break;
                    } else {
                        setInclineUp();
                        break;
                    }
                }
                break;
            case R.id.x_control_3_image /* 2131231885 */:
                ErrorLogSave.addErrorString(getActivity(), ErrorLogSave.CLICK, "DisplayMainFragment_x_control_3", "click_deviceType:" + ProtocolHandler.protocol.deviceType + "_isHRMode:" + String.valueOf(this.isHRMode));
                int i7 = ProtocolHandler.protocol.deviceType;
                if (i7 == 0) {
                    setLevelDown();
                    break;
                } else if (i7 != 1 && i7 == 2 && !this.isHRMode) {
                    setLevelDown();
                    break;
                }
                break;
            case R.id.x_control_4_image /* 2131231886 */:
                ErrorLogSave.addErrorString(getActivity(), ErrorLogSave.CLICK, "DisplayMainFragment_x_control_4", "click_deviceType:" + ProtocolHandler.protocol.deviceType + "_isHRMode:" + String.valueOf(this.isHRMode));
                int i8 = ProtocolHandler.protocol.deviceType;
                if (i8 == 0) {
                    setLevelUp();
                    break;
                } else if (i8 != 1 && i8 == 2 && !this.isHRMode) {
                    setLevelUp();
                    break;
                }
                break;
        }
    }

    private void setBottomButtonState(int i) {
        int i2 = Global.BRAND;
        if (i2 == 0) {
            this.display_simple_textview.setBackgroundResource(R.drawable.all_btn_a_02);
            this.display_track_textview.setBackgroundResource(R.drawable.all_btn_a_02);
            this.display_dashboard_textview.setBackgroundResource(R.drawable.all_btn_a_02);
            if (i == 0) {
                this.display_simple_textview.setBackgroundResource(R.drawable.all_btn_a_03);
                return;
            } else if (i == 1) {
                this.display_track_textview.setBackgroundResource(R.drawable.all_btn_a_03);
                return;
            } else {
                if (i != 2) {
                    return;
                }
                this.display_dashboard_textview.setBackgroundResource(R.drawable.all_btn_a_03);
                return;
            }
        }
        if (i2 == 1) {
            this.display_simple_textview.setBackgroundResource(R.drawable.s_all_bottom_btn_0);
            this.display_track_textview.setBackgroundResource(R.drawable.s_all_bottom_btn_0);
            this.display_dashboard_textview.setBackgroundResource(R.drawable.s_all_bottom_btn_0);
            if (i == 0) {
                this.display_simple_textview.setBackgroundResource(R.drawable.s_all_bottom_btn_1);
                return;
            } else if (i == 1) {
                this.display_track_textview.setBackgroundResource(R.drawable.s_all_bottom_btn_1);
                return;
            } else {
                if (i != 2) {
                    return;
                }
                this.display_dashboard_textview.setBackgroundResource(R.drawable.s_all_bottom_btn_1);
                return;
            }
        }
        if (i2 == 2 || i2 == 3) {
            this.param_layout.setVisibility(0);
            this.display_simple_textview.setBackgroundResource(R.drawable.x_all_bottom_btn_0);
            this.display_track_textview.setBackgroundResource(R.drawable.x_all_bottom_btn_0);
            this.display_dashboard_textview.setBackgroundResource(R.drawable.x_all_bottom_btn_0);
            if (i == 0) {
                this.display_simple_textview.setBackgroundResource(R.drawable.x_all_bottom_btn_1);
                this.param_layout.setVisibility(8);
            } else if (i == 1) {
                this.display_track_textview.setBackgroundResource(R.drawable.x_all_bottom_btn_1);
            } else {
                if (i != 2) {
                    return;
                }
                this.display_dashboard_textview.setBackgroundResource(R.drawable.x_all_bottom_btn_1);
            }
        }
    }

    public void setInclineUp() {
        ProtocolHandler.protocol.setInclineUp();
    }

    public void setInclineDown() {
        ProtocolHandler.protocol.setInclineDown();
    }

    public void setLevelUp() {
        ProtocolHandler.protocol.setLevelUp();
    }

    public void setLevelDown() {
        ProtocolHandler.protocol.setLevelDown();
    }

    public void hideFragment() {
        switchView(-1);
    }

    public void switchView(int i) {
        this.nowDisplayPage = i;
        this.simpleFrameLayout.setVisibility(8);
        this.trackLinearLayout.setAlpha(0.0f);
        this.dashboardLinearLayout.setVisibility(8);
        switch (i) {
            case 81:
                this.simpleFrameLayout.setVisibility(0);
                int i2 = Global.BRAND;
                if (i2 == 2 || i2 == 3) {
                    this.simpleFrameLayout.resetUnitParam();
                    break;
                }
            case 82:
                this.trackLinearLayout.setAlpha(1.0f);
                int i3 = Global.BRAND;
                if (i3 != 0 && i3 != 1) {
                    if (i3 == 2 || i3 == 3) {
                        this.trackLinearLayout.resetParams();
                        break;
                    }
                } else {
                    this.trackLinearLayout.resetProfileImage();
                    break;
                }
                break;
            case 83:
                this.dashboardLinearLayout.setVisibility(0);
                int i4 = Global.BRAND;
                if (i4 != 0 && i4 != 1) {
                    if (i4 == 2 || i4 == 3) {
                        this.dashboardLinearLayout.resetParams();
                        break;
                    }
                } else {
                    this.dashboardLinearLayout.resetProfileImage();
                    break;
                }
                break;
        }
        setBottomButtonState(i - 81);
    }

    private void modeChanged(int i) {
        this.trackLinearLayout.modeChanged(i);
        this.dashboardLinearLayout.modeChanged(i);
    }

    private void resetData() {
        Log.e("endDataHR", "resetData");
        this.totalHR = 0;
        this.totalHRCount = 0;
        int i = DeviceModelList.programTitleTexts[ProtocolHandler.protocol.setProgramMode];
        this.hrType = -1;
        this.isSafekeyDialogShown = false;
        this.nowWorkoutMode = 0;
        initTrackView();
        initDashboard();
        this.simpleFrameLayout.resetData();
        this.trackLinearLayout.resetData();
        this.dashboardLinearLayout.resetData();
        if (ProtocolHandler.protocol.salesVersion == 0) {
            int i2 = Global.BRAND;
            if (i2 == 1 || i2 == 2 || i2 == 3) {
                this.isHRMode = i == R.string.hr1 || i == R.string.hr2;
                String upperCase = this.res.getString(R.string.display_incline).toUpperCase();
                String upperCase2 = this.res.getString(R.string.level).toUpperCase();
                String upperCase3 = this.res.getString(R.string.speed).toUpperCase();
                if (Global.BRAND == 1) {
                    int i3 = ProtocolHandler.protocol.deviceType;
                    if (i3 == 0) {
                        this.control_1_layout.setVisibility(0);
                        this.control_2_layout.setVisibility(0);
                        this.control_3_layout.setVisibility(0);
                        this.control_4_layout.setVisibility(0);
                        this.control_1_text.setText(upperCase);
                        this.control_2_text.setText(upperCase);
                        this.control_3_text.setText(upperCase3);
                        this.control_4_text.setText(upperCase3);
                        this.control_1_image.setImageResource(R.drawable.s_display_btn_a_u);
                        this.control_2_image.setImageResource(R.drawable.s_display_btn_a_d);
                        this.control_3_image.setImageResource(R.drawable.s_display_btn_a_d);
                        this.control_4_image.setImageResource(R.drawable.s_display_btn_a_u);
                        return;
                    }
                    if (i3 == 1) {
                        if (this.isHRMode) {
                            this.control_1_layout.setVisibility(8);
                            this.control_2_layout.setVisibility(4);
                            this.control_3_layout.setVisibility(4);
                            this.control_4_layout.setVisibility(8);
                            return;
                        }
                        this.control_1_layout.setVisibility(0);
                        this.control_2_layout.setVisibility(8);
                        this.control_3_layout.setVisibility(8);
                        this.control_4_layout.setVisibility(0);
                        this.control_1_text.setText(upperCase2);
                        this.control_4_text.setText(upperCase2);
                        this.control_1_image.setImageResource(R.drawable.s_display_btn_a_d);
                        this.control_4_image.setImageResource(R.drawable.s_display_btn_a_u);
                        return;
                    }
                    if (i3 != 2) {
                        return;
                    }
                    if (this.isHRMode) {
                        this.control_1_layout.setVisibility(0);
                        this.control_2_layout.setVisibility(8);
                        this.control_3_layout.setVisibility(8);
                        this.control_4_layout.setVisibility(0);
                        this.control_1_text.setText(upperCase);
                        this.control_4_text.setText(upperCase);
                        this.control_1_image.setImageResource(R.drawable.s_display_btn_a_d);
                        this.control_4_image.setImageResource(R.drawable.s_display_btn_a_u);
                        return;
                    }
                    this.control_1_layout.setVisibility(0);
                    this.control_2_layout.setVisibility(0);
                    this.control_3_layout.setVisibility(0);
                    this.control_4_layout.setVisibility(0);
                    this.control_1_text.setText(upperCase);
                    this.control_2_text.setText(upperCase);
                    this.control_3_text.setText(upperCase2);
                    this.control_4_text.setText(upperCase2);
                    this.control_1_image.setImageResource(R.drawable.s_display_btn_a_u);
                    this.control_2_image.setImageResource(R.drawable.s_display_btn_a_d);
                    this.control_3_image.setImageResource(R.drawable.s_display_btn_a_d);
                    this.control_4_image.setImageResource(R.drawable.s_display_btn_a_u);
                    return;
                }
                int i4 = ProtocolHandler.protocol.deviceType;
                if (i4 == 0) {
                    this.control_1_text.setText(upperCase);
                    this.control_3_text.setText(upperCase3);
                    this.control_1_image.setAlpha(1.0f);
                    this.control_2_image.setAlpha(1.0f);
                    this.control_3_image.setAlpha(1.0f);
                    this.control_4_image.setAlpha(1.0f);
                    this.control_1_image.setEnabled(true);
                    this.control_2_image.setEnabled(true);
                    this.control_3_image.setEnabled(true);
                    this.control_4_image.setEnabled(true);
                    return;
                }
                if (i4 == 1) {
                    this.control_1_text.setText("");
                    this.control_3_text.setText("");
                    if (this.isHRMode) {
                        this.control_1_image.setAlpha(0.5f);
                        this.control_2_image.setAlpha(0.5f);
                        this.control_3_image.setAlpha(0.5f);
                        this.control_4_image.setAlpha(0.5f);
                        this.control_1_image.setEnabled(false);
                        this.control_2_image.setEnabled(false);
                        this.control_3_image.setEnabled(false);
                        this.control_4_image.setEnabled(false);
                        return;
                    }
                    this.control_1_text.setText(upperCase2);
                    this.control_1_image.setAlpha(1.0f);
                    this.control_2_image.setAlpha(1.0f);
                    this.control_3_image.setAlpha(0.5f);
                    this.control_4_image.setAlpha(0.5f);
                    this.control_1_image.setEnabled(true);
                    this.control_2_image.setEnabled(true);
                    this.control_3_image.setEnabled(false);
                    this.control_4_image.setEnabled(false);
                    return;
                }
                if (i4 != 2) {
                    return;
                }
                if (this.isHRMode) {
                    this.control_1_text.setText(upperCase);
                    this.control_3_text.setText("");
                    this.control_1_image.setAlpha(1.0f);
                    this.control_2_image.setAlpha(1.0f);
                    this.control_3_image.setAlpha(0.5f);
                    this.control_4_image.setAlpha(0.5f);
                    this.control_1_image.setEnabled(true);
                    this.control_2_image.setEnabled(true);
                    this.control_3_image.setEnabled(false);
                    this.control_4_image.setEnabled(false);
                } else {
                    this.control_1_text.setText(upperCase);
                    this.control_3_text.setText(upperCase2);
                    this.control_1_image.setAlpha(1.0f);
                    this.control_2_image.setAlpha(1.0f);
                    this.control_3_image.setAlpha(1.0f);
                    this.control_4_image.setAlpha(1.0f);
                    this.control_1_image.setEnabled(true);
                    this.control_2_image.setEnabled(true);
                    this.control_3_image.setEnabled(true);
                    this.control_4_image.setEnabled(true);
                }
                if (ProtocolHandler.protocol.deviceModel == 49) {
                    this.control_1_text.setText("");
                    this.control_1_image.setAlpha(0.5f);
                    this.control_2_image.setAlpha(0.5f);
                    this.control_1_image.setEnabled(false);
                    this.control_2_image.setEnabled(false);
                }
            }
        }
    }

    public void removeParamLayout() {
        this.param_layout.removeAllViews();
    }

    public void addParamLayout(int i, int i2) {
        View viewInflate = View.inflate(this.activity, R.layout.x_include_display_simple_item, null);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(0, (int) this.res.getDimension(R.dimen.s_display_dashboard_top_height), 1.0f);
        ((TypefaceTextView) viewInflate.findViewById(R.id.display_simple_item_title_textview)).setText(i);
        ((ImageView) viewInflate.findViewById(R.id.display_simple_item_title_imageview)).setImageResource(i2);
        this.param_layout.addView(viewInflate, layoutParams);
    }

    public void setParamValue(int i, String str) {
        if (i >= this.param_layout.getChildCount()) {
            return;
        }
        ((TextView) this.param_layout.getChildAt(i).findViewById(R.id.display_simple_item_value_textview)).setText(str);
    }

    public void setUnitLayout(final int i, boolean z) {
        if (i >= this.param_layout.getChildCount()) {
            return;
        }
        View childAt = this.param_layout.getChildAt(i);
        childAt.findViewById(R.id.unit_layout).setVisibility(z ? 0 : 8);
        if (z) {
            childAt.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.fragment.display.DisplayMainFragment.4
                @Override // android.view.View.OnClickListener
                public void onClick(View view) {
                    int i2 = ProtocolHandler.protocol.deviceType;
                    if (i2 != 0) {
                        if (i2 != 2) {
                            return;
                        }
                        int i3 = i;
                        if (i3 == 2) {
                            DisplayMainFragment.this.distanceUnitFlag = !r4.distanceUnitFlag;
                            String strValueOf = String.valueOf(ProtocolHandler.protocol.getConvertDistanceUnit(!DisplayMainFragment.this.distanceUnitFlag ? 1 : 0, DisplayMainFragment.this.distanceUnitValue));
                            DisplayMainFragment displayMainFragment = DisplayMainFragment.this;
                            displayMainFragment.setUnit(2, displayMainFragment.distanceUnitFlag, strValueOf);
                            return;
                        }
                        if (i3 != 5) {
                            return;
                        }
                        DisplayMainFragment.this.distanceUnitFlag = !r4.distanceUnitFlag;
                        String strValueOf2 = String.valueOf(ProtocolHandler.protocol.getConvertDistanceUnit(!DisplayMainFragment.this.distanceUnitFlag ? 1 : 0, DisplayMainFragment.this.distanceUnitValue));
                        DisplayMainFragment displayMainFragment2 = DisplayMainFragment.this;
                        displayMainFragment2.setUnit(5, displayMainFragment2.distanceUnitFlag, strValueOf2);
                        return;
                    }
                    int i4 = i;
                    if (i4 == 2) {
                        DisplayMainFragment.this.distanceUnitFlag = !r4.distanceUnitFlag;
                        String strValueOf3 = String.valueOf(ProtocolHandler.protocol.getConvertDistanceUnit(!DisplayMainFragment.this.distanceUnitFlag ? 1 : 0, DisplayMainFragment.this.distanceUnitValue));
                        DisplayMainFragment displayMainFragment3 = DisplayMainFragment.this;
                        displayMainFragment3.setUnit(2, displayMainFragment3.distanceUnitFlag, strValueOf3);
                        return;
                    }
                    if (i4 == 3) {
                        DisplayMainFragment.this.speedUnitFlag = !r4.speedUnitFlag;
                        String strValueOf4 = String.valueOf(ProtocolHandler.protocol.getConvertDistanceUnit(!DisplayMainFragment.this.speedUnitFlag ? 1 : 0, DisplayMainFragment.this.speedUnitValue));
                        DisplayMainFragment displayMainFragment4 = DisplayMainFragment.this;
                        displayMainFragment4.setUnit(3, displayMainFragment4.speedUnitFlag, strValueOf4);
                        return;
                    }
                    if (i4 != 4) {
                        return;
                    }
                    DisplayMainFragment.this.distanceUnitFlag = !r4.distanceUnitFlag;
                    String strValueOf5 = String.valueOf(ProtocolHandler.protocol.getConvertDistanceUnit(!DisplayMainFragment.this.distanceUnitFlag ? 1 : 0, DisplayMainFragment.this.distanceUnitValue));
                    DisplayMainFragment displayMainFragment5 = DisplayMainFragment.this;
                    displayMainFragment5.setUnit(4, displayMainFragment5.distanceUnitFlag, strValueOf5);
                }
            });
        }
    }

    public void setUnit(int i, boolean z, String str) {
        if (i >= this.param_layout.getChildCount()) {
            return;
        }
        View childAt = this.param_layout.getChildAt(i);
        TextView textView = (TextView) childAt.findViewById(R.id.unit_1_text);
        TextView textView2 = (TextView) childAt.findViewById(R.id.unit_2_text);
        TextView textView3 = (TextView) childAt.findViewById(R.id.display_simple_item_value_textview);
        if (!z) {
            textView.setTextColor(this.res.getColor(R.color.black));
            textView2.setTextColor(this.res.getColor(R.color.light_gray));
        } else {
            textView.setTextColor(this.res.getColor(R.color.light_gray));
            textView2.setTextColor(this.res.getColor(R.color.black));
        }
        textView3.setText(str);
    }

    private void updateWorkoutData(WorkoutData workoutData) {
        this.simpleFrameLayout.pauseProgramAnimation();
        switch (this.nowDisplayPage) {
            case 81:
                this.simpleFrameLayout.startProgramAnimation();
                this.trackLinearLayout.updateWorkoutData(workoutData);
                this.dashboardLinearLayout.updateWorkoutData(workoutData);
                this.simpleFrameLayout.updateWorkoutData(workoutData);
                break;
            case 82:
                this.simpleFrameLayout.updateWorkoutData(workoutData);
                this.dashboardLinearLayout.updateWorkoutData(workoutData);
                this.trackLinearLayout.updateWorkoutData(workoutData);
                break;
            case 83:
                this.simpleFrameLayout.updateWorkoutData(workoutData);
                this.trackLinearLayout.updateWorkoutData(workoutData);
                this.dashboardLinearLayout.updateWorkoutData(workoutData);
                break;
        }
    }

    public int getNowTargetHR() {
        return this.nowTargetHR;
    }

    public void showControlView(int i) {
        this.activity.showControlView(i, this.nowLevel, this.nowIncline, this.nowSpeed);
    }

    @Override // com.dyaco.sole.custom.ProtocolHandler.OnDataResultListener
    public void onDataResult(int i, boolean z, List<Number> list) throws NumberFormatException, IOException {
        if (this.activity.nowPage == 5 || i == 3) {
            if (i != 3) {
                if (i != 9) {
                    if (i == 32) {
                        this.nowTargetHR = list.get(0).intValue();
                        return;
                    }
                    if (i != 18) {
                        if (i != 19) {
                            return;
                        }
                        this.nowLevel = list.get(0).intValue();
                        Log.d(TAG, "--------nowLevel = " + this.nowLevel);
                        return;
                    }
                    this.nowIncline = list.get(0).intValue();
                    int i2 = Global.BRAND;
                    if (i2 == 1 || i2 == 2 || i2 == 3) {
                        if (ProtocolHandler.protocol.showInclineMode == 1 || ProtocolHandler.protocol.showInclineMode == 2) {
                            this.nowIncline--;
                        }
                        if (ProtocolHandler.protocol.deviceModel == 149 || ProtocolHandler.protocol.deviceModel == 27 || ProtocolHandler.protocol.deviceModel == 64) {
                            this.nowIncline--;
                        }
                    }
                    Log.d(TAG, "--------nowIncline = " + this.nowIncline);
                    return;
                }
                if (this.hrType == list.get(1).intValue()) {
                    return;
                }
                if (Global.BRAND == 2) {
                    if (ProtocolHandler.protocol.deviceType == 0) {
                        int iIntValue = list.get(0).intValue();
                        if (!this.isSafekeyDialogShown && iIntValue == 2) {
                            if (ProtocolHandler.protocol.isConnected()) {
                                ProtocolHandler.protocol.disconnect();
                            }
                            showSafekeyDialog();
                        }
                        if (this.nowWorkoutMode == 4 && this.isSafekeyDialogShown && iIntValue != 2) {
                            cancelSafeKeyDialog();
                            return;
                        }
                        return;
                    }
                    return;
                }
                int iIntValue2 = list.get(1).intValue();
                this.hrType = iIntValue2;
                if (iIntValue2 == 0) {
                    ProtocolHandler.protocol.pauseWorkout();
                } else {
                    ProtocolHandler.protocol.restartWorkout();
                }
                if (ProtocolHandler.protocol.deviceType == 0) {
                    int iIntValue3 = list.get(0).intValue();
                    if (this.isSafekeyDialogShown || iIntValue3 != 2) {
                        return;
                    }
                    if (Global.BRAND == 0) {
                        this.trackLinearLayout.onDestroy();
                        this.trackLinearLayout.cancelProgramAnimation();
                        this.dashboardLinearLayout.cancelProgramAnimation();
                    }
                    showSafekeyDialog();
                    return;
                }
                return;
            }
            if (this.nowWorkoutMode == list.get(0).intValue()) {
                return;
            }
            this.nowWorkoutMode = list.get(0).intValue();
            Global.printLog("d", TAG, "CS 改變 Workout Mode-----" + this.nowWorkoutMode);
            modeChanged(this.nowWorkoutMode);
            Global.getSpfEditor(this.activity).putInt("nowWorkoutMode", this.nowWorkoutMode).commit();
            int i3 = this.nowWorkoutMode;
            if (i3 == 1) {
                cancelDialog();
                this.activity.enableAutoConnectedSimulationWorkoutDataCountDownTimer(false);
                if (this.activity.nowPage != 5) {
                    return;
                }
                int i4 = Global.BRAND;
                if (i4 == 0) {
                    this.activity.hideControlView();
                    this.activity.switchFragment(7);
                    return;
                }
                if (i4 == 1) {
                    this.activity.switchFragment(3);
                    return;
                }
                if (i4 == 2 || i4 == 3) {
                    if (ProtocolHandler.protocol.salesVersion == 1) {
                        if (this.isEndWorkoutMode) {
                            this.activity.switchFragment(7);
                            this.isEndWorkoutMode = false;
                            return;
                        } else {
                            this.activity.switchFragment(5);
                            return;
                        }
                    }
                    this.activity.switchFragment(3);
                    return;
                }
                return;
            }
            if (i3 == 3) {
                ProtocolHandler.protocol.setOnWorkoutResultListener(this);
                cancelDialog();
                this.simpleFrameLayout.workoutWarmUpMode();
                this.trackLinearLayout.workoutWarmUpMode();
                this.dashboardLinearLayout.workoutWarmUpMode();
                this.isSaveEndData = false;
                return;
            }
            if (i3 == 4) {
                if (this.isSaveEndData) {
                    this.isSaveEndData = false;
                }
                ProtocolHandler.protocol.setOnWorkoutResultListener(this);
                cancelDialog();
                this.simpleFrameLayout.workoutRunningMode();
                this.trackLinearLayout.workoutRunningMode();
                this.dashboardLinearLayout.workoutRunningMode();
                this.trackLinearLayout.resetPace();
                this.nowTargetHR = ProtocolHandler.protocol.setMaxTargetHR;
                showControlView(-1);
                this.isEndWorkoutMode = false;
                this.isPauseMode = false;
                int i5 = Global.BRAND;
                if (i5 == 0) {
                    this.display_pause_textview.setText(R.string.pause);
                    this.display_pause_imageview.setImageResource(R.drawable.display_btn_icon_a_pause);
                    return;
                } else {
                    if (i5 != 1) {
                        return;
                    }
                    this.pause_text.setText(R.string.pause);
                    return;
                }
            }
            if (i3 == 5) {
                ProtocolHandler.protocol.setOnWorkoutResultListener(this);
                cancelDialog();
                this.simpleFrameLayout.workoutCoolDownMode();
                this.trackLinearLayout.workoutCoolDownMode();
                this.dashboardLinearLayout.workoutCoolDownMode();
                return;
            }
            if (i3 != 6) {
                if (i3 != 7) {
                    return;
                }
                this.isEndWorkoutMode = true;
                this.activity.enableAutoConnectedSimulationWorkoutDataCountDownTimer(false);
                if (Global.BRAND == 2) {
                    if (ProtocolHandler.protocol.deviceModel == 160 || ProtocolHandler.protocol.deviceModel == 161 || ProtocolHandler.protocol.deviceModel == 162) {
                        if (ProtocolHandler.protocol.salesVersion == 0) {
                            setDialogButton(2, R.string.end_workout);
                        } else {
                            setDialogButton(2, R.string.end_workout);
                        }
                        this.isPauseMode = true;
                        int i6 = Global.BRAND;
                        if (i6 != 0) {
                            if (i6 != 1) {
                                return;
                            }
                            this.pause_text.setText(R.string.play);
                            return;
                        } else {
                            this.activity.hideControlView();
                            this.display_pause_textview.setText(R.string.play);
                            this.display_pause_imageview.setImageResource(R.drawable.display_btn_icon_a_play);
                            return;
                        }
                    }
                    return;
                }
                return;
            }
            this.activity.enableAutoConnectedSimulationWorkoutDataCountDownTimer(false);
            this.simpleFrameLayout.workoutPauseMode();
            this.trackLinearLayout.workoutPauseMode();
            this.dashboardLinearLayout.workoutPauseMode();
            int i7 = R.string.pause_workout;
            if (ProtocolHandler.protocol.salesVersion == 1 && Global.BRAND == 2) {
                i7 = R.string.pause2_workout;
            }
            if (ProtocolHandler.protocol.salesVersion == 0) {
                setDialogButton(0, i7);
            } else if (this.hrType == 0) {
                int i8 = Global.BRAND;
                if (i8 == 0 || i8 == 1) {
                    setDialogNoButton(R.string.no_hr);
                } else if (i8 == 2 || i8 == 3) {
                    setDialogNoButton(i7);
                }
            } else {
                setDialogNoButton(i7);
            }
            this.isPauseMode = true;
            int i9 = Global.BRAND;
            if (i9 != 0) {
                if (i9 != 1) {
                    return;
                }
                this.pause_text.setText(R.string.play);
            } else {
                this.activity.hideControlView();
                this.display_pause_textview.setText(R.string.play);
                this.display_pause_imageview.setImageResource(R.drawable.display_btn_icon_a_play);
            }
        }
    }

    public void showSafekeyDialog() {
        if (this.isSafekeyDialogShown) {
            return;
        }
        this.isSafekeyDialogShown = true;
        if (ProtocolHandler.protocol.salesVersion == 0) {
            setDialogButton(2, R.string.no_safe_key);
            this.activity.switchFragment(7);
        } else {
            setDialogButton(2, R.string.no_safe_key);
            this.activity.switchFragment(7);
        }
    }

    @Override // com.dyaco.sole.custom.ProtocolHandler.OnWorkoutResultListener
    public void onWorkoutResult(WorkoutData workoutData) {
        if (this.activity.nowPage != 5) {
            return;
        }
        Log.e("checkDeviceUnit", ProtocolHandler.protocol.deviceUnit + "");
        if (MyApp.isWork) {
            if (workoutData.isAutoConnectedSimulationData()) {
                if (!this.activity.isAutoConnectedScaningUpdateWorkoutDataThreadRuningFlag()) {
                    return;
                }
            } else {
                this.activity.setAutoConnectedScaningUpdateWorkoutDataThreadRuningFlag(false);
            }
        }
        if ((ProtocolHandler.protocol.deviceType == 1 || ProtocolHandler.protocol.deviceType == 2) && ProtocolHandler.protocol.deviceModel != 30) {
            if (ProtocolHandler.protocol.deviceModel == 31) {
                Log.d(TAG, "sc200  xxx  data = " + workoutData);
            } else {
                workoutData.setNowLevel(this.nowLevel);
            }
        }
        if (ProtocolHandler.protocol.deviceType == 2) {
            if (ProtocolHandler.protocol.deviceModel == 30 || ProtocolHandler.protocol.deviceModel == 29 || ProtocolHandler.protocol.deviceModel == 31) {
                Log.d(TAG, "sc200  xxx  data = " + workoutData);
            } else {
                workoutData.setNowIncline(this.nowIncline);
            }
        }
        if (ProtocolHandler.protocol.deviceModel == 149) {
            int nowIncline = workoutData.getNowIncline() - 6;
            this.nowIncline = nowIncline;
            workoutData.setNowIncline(nowIncline);
        }
        if (MyApp.isHRConnect) {
            workoutData.setHeartRate(this.activity.heartRate);
            Log.e("endDataHR", "nowHr : " + this.activity.heartRate);
            if (this.activity.heartRate > 0) {
                this.totalHR += this.activity.heartRate;
                this.totalHRCount++;
            }
        }
        this.nowLevel = workoutData.getNowLevel();
        this.nowIncline = workoutData.getNowIncline();
        Log.d(TAG, "nowIncline = " + this.nowIncline);
        this.nowSpeed = workoutData.getSpeed();
        updateWorkoutData(workoutData);
        if (workoutData.getSeconds() % (ProtocolHandler.protocol.setWorkoutTime >= 10 ? (ProtocolHandler.protocol.setWorkoutTime * 60) / 100 : 5) == 0) {
            Global.workoutDataList.add(workoutData);
            Log.d("ppp", Arrays.toString(Global.workoutDataList.toArray(new WorkoutData[0])));
        }
    }

    @Override // android.app.Fragment
    public void onDestroy() {
        super.onDestroy();
        Log.e("checkIsWork", "onDestroy" + String.valueOf(MyApp.isWork));
    }

    @Override // android.app.Fragment
    public void onResume() {
        super.onResume();
        Log.e("checkIsWork", "onResume" + String.valueOf(MyApp.isWork));
        if (MyApp.isWork && ProtocolHandler.protocol.isConnected()) {
            ProtocolHandler.protocol.setOnWorkoutResultListener(this);
        }
    }

    @Override // com.dyaco.sole.custom.ProtocolHandler.OnWorkoutResultListener
    public void onEndWorkoutResult(EndWorkoutData endWorkoutData) {
        int i;
        int i2;
        MyApp.isWork = false;
        Log.e("endDataHR", "isSaveEndData " + String.valueOf(this.isSaveEndData));
        this.activity.enableAutoConnectedSimulationWorkoutDataCountDownTimer(false);
        if (this.isSaveEndData) {
            return;
        }
        this.isSaveEndData = true;
        if (ProtocolHandler.protocol.salesVersion == 0 || Global.BRAND == 2) {
            setDialogButton(2, R.string.end_workout);
        } else if (SoleProtocol.notRunning) {
            Log.e("getEndMessage", String.valueOf(SoleProtocol.notRunning));
            setDialogButton(2, R.string.end_workout);
        } else {
            setDialogNoButton(R.string.end_workout);
        }
        this.isPauseMode = true;
        int i3 = Global.BRAND;
        if (i3 == 0) {
            this.activity.hideControlView();
            this.display_pause_textview.setText(R.string.play);
            this.display_pause_imageview.setImageResource(R.drawable.display_btn_icon_a_play);
        } else if (i3 == 1) {
            this.pause_text.setText(R.string.play);
        }
        if (Global.userName.equals(this.res.getString(R.string.guest))) {
            return;
        }
        try {
            if (MyApp.isHRConnect && (i = this.totalHR) != 0 && (i2 = this.totalHRCount) != 0) {
                int i4 = i / i2;
                Log.e("endDataHR", "totalHr " + this.totalHR + " / count " + this.totalHRCount + " = hr " + i4);
                endWorkoutData.setHeartRate(i4);
            }
        } catch (Exception unused) {
        }
        try {
            Log.d(TAG, "endData = " + endWorkoutData);
            DCTrainingDataDao dCTrainingDataDao = DbManager.getDCTrainingDataDao();
            Calendar calendar = Calendar.getInstance(getLocale());
            CalendarUtils.getCalendarFormat(calendar.getTime(), CalendarUtils.SQL_DATE_TIME_FORMAT);
            calendar.set(13, -endWorkoutData.getSeconds());
            String calendarFormat = CalendarUtils.getCalendarFormat(calendar.getTime(), CalendarUtils.SQL_DATE_TIME_FORMAT);
            DCTrainingData dCTrainingDataSaveAsDCTrainingData = saveAsDCTrainingData(endWorkoutData, calendar);
            dCTrainingDataDao.insert(dCTrainingDataSaveAsDCTrainingData);
            Log.d("ppp2", dCTrainingDataSaveAsDCTrainingData.toString());
            Log.d("ppp", Arrays.toString(Global.workoutDataList.toArray(new WorkoutData[0])));
            saveDCTrainingDetailData(dCTrainingDataSaveAsDCTrainingData, Global.workoutDataList, calendar.getTime());
            Global.workoutDataList.clear();
            Global.workoutDataListForProtocol.clear();
            dCTrainingDataSaveAsDCTrainingData.setPassword(getAccoutData().getPassword());
            updateTrainingDataToCloud(dCTrainingDataSaveAsDCTrainingData);
            Global.getSharedPreferences(this.activity).edit().putInt(calendarFormat, ProtocolHandler.protocol.deviceUnit).commit();
            setShareAndTrackData(endWorkoutData);
            SoleProtocol.notRunning = true;
        } catch (Exception unused2) {
            this.activity.showMessageView(ErrorLogSave.ERROR_0009);
        }
        for (int i5 = 0; i5 < DeviceModelList.programNames.length; i5++) {
            if (DeviceModelList.programNames[i5].equals(DeviceModelList.PGName_Manual)) {
                Log.e("lookforprogram", DeviceModelList.PGName_Manual + " : " + i5);
                ProtocolHandler.protocol.setProgramMode = i5;
            }
        }
    }

    private DCTrainingData saveAsDCTrainingData(EndWorkoutData endWorkoutData, Calendar calendar) {
        Calendar calendar2 = Calendar.getInstance(getLocale());
        calendar2.setTimeInMillis(calendar.getTimeInMillis());
        int i = ((calendar2.get(15) / 1000) / 60) / 60;
        DCTrainingData dCTrainingData = new DCTrainingData();
        int accout_noFromDB = getAccout_noFromDB();
        dCTrainingData.setAccount(Global.userName);
        dCTrainingData.setAccount_no(accout_noFromDB);
        dCTrainingData.setTraining_datetime(calendar.getTime());
        dCTrainingData.setTraining_timezone_hour(i);
        dCTrainingData.setTraining_timezone_name(calendar2.getTimeZone().getID());
        dCTrainingData.setBrand_code(Global.CLOUD_BRAND_NAME);
        if (ProtocolHandler.protocol.deviceName != "" && "XBR55".equalsIgnoreCase(ProtocolHandler.protocol.deviceName)) {
            dCTrainingData.setModel_code(DeviceModelList.DEVICE_NAME_LIST[1]);
        } else {
            dCTrainingData.setModel_code(DeviceModelList.DEVICE_NAME_LIST[ProtocolHandler.protocol.deviceModel]);
        }
        dCTrainingData.setModel_code(DeviceModelList.DEVICE_NAME_LIST[ProtocolHandler.protocol.deviceModel]);
        dCTrainingData.setCategory_code(String.valueOf(ProtocolHandler.protocol.deviceType));
        dCTrainingData.setBrand_type(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        dCTrainingData.setIn_out(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        dCTrainingData.setUnit(String.valueOf(ProtocolHandler.protocol.deviceUnit));
        dCTrainingData.setSales_version(String.valueOf(ProtocolHandler.protocol.salesVersion));
        dCTrainingData.setProgram_name(DeviceModelList.programNames[ProtocolHandler.protocol.setProgramMode]);
        dCTrainingData.setProgramNameRes(DeviceModelList.programTitleTexts[ProtocolHandler.protocol.setProgramMode]);
        dCTrainingData.setGoals("");
        dCTrainingData.setNotes("");
        dCTrainingData.setTotal_time(endWorkoutData.getSeconds());
        float distance = endWorkoutData.getDistance();
        if (ProtocolHandler.protocol.deviceUnit == 1) {
            distance = endWorkoutData.getDistance() * 1.6f;
        }
        dCTrainingData.setTotal_distance(distance);
        dCTrainingData.setTotal_calories(endWorkoutData.getCalories());
        dCTrainingData.setAvg_hr(endWorkoutData.getHeartRate());
        dCTrainingData.setAvg_rpm(endWorkoutData.getRpm());
        float speed = endWorkoutData.getSpeed();
        if (ProtocolHandler.protocol.deviceUnit == 1) {
            speed = endWorkoutData.getSpeed() * 1.6f;
        }
        dCTrainingData.setAvg_speed(speed);
        dCTrainingData.setAvg_watt(endWorkoutData.getWatt());
        dCTrainingData.setAvg_met(endWorkoutData.getMets());
        dCTrainingData.setAvg_level(endWorkoutData.getLevel());
        dCTrainingData.setAvg_incline(endWorkoutData.getIncline());
        dCTrainingData.setDevice_os_name("Android");
        dCTrainingData.setDevice_os_version(Build.VERSION.RELEASE);
        dCTrainingData.setDevice_model(Build.BRAND);
        dCTrainingData.setDevice_sno(Build.SERIAL);
        dCTrainingData.setDevice_gps_lat((float) Global.gpsLat);
        dCTrainingData.setDevice_gps_lng((float) Global.gpsLon);
        String str = ProtocolHandler.protocol.connectedMacAddress;
        return dCTrainingData;
    }

    private Locale getLocale() {
        Resources resources = getResources();
        resources.getDisplayMetrics();
        return resources.getConfiguration().locale;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTrainingDetailDataToCloud(DCTrainingData dCTrainingData) {
        Long trainingId = dCTrainingData.getTrainingId();
        QueryBuilder<DCTrainingDetailData> queryBuilder = DbManager.getDCTrainingDetailDataDao().queryBuilder();
        queryBuilder.where(DCTrainingDetailDataDao.Properties.TrainingId.eq(trainingId), new WhereCondition[0]);
        for (DCTrainingDetailData dCTrainingDetailData : queryBuilder.list()) {
            dCTrainingDetailData.setPassword(dCTrainingData.getPassword());
            dCTrainingDetailData.setTrainh_no(dCTrainingData.getTrainh_no());
            Log.d("qqq  TrainingDetailData", String.valueOf(dCTrainingDetailData.toString()));
            CloudApi cloudApiCreateInstance = CloudApi.createInstance(this.activity);
            cloudApiCreateInstance.setDCUploadTrainingDetailDataListener(new MyDCUploadTrainingDetailDataListener(dCTrainingDetailData));
            cloudApiCreateInstance.callDCUploadTrainingDetailData(dCTrainingDetailData);
        }
    }

    class MyDCUploadTrainingDetailDataListener implements DCUploadTrainingDetailDataListener {
        private final DCTrainingDetailData dcTrainingDetailData;

        public MyDCUploadTrainingDetailDataListener(DCTrainingDetailData dCTrainingDetailData) {
            this.dcTrainingDetailData = dCTrainingDetailData;
        }

        @Override // com.digifly.cloudapi.listener.DCUploadTrainingDetailDataListener
        public void onSuccess(ResponseDataCollection responseDataCollection) {
            String str = responseDataCollection.getSys_response_data().get("trainh_detail_no");
            Log.d("qqq trainh_detail_no", str);
            this.dcTrainingDetailData.setTrainh_detail_no(str);
            DbManager.getDCTrainingDetailDataDao().update(this.dcTrainingDetailData);
        }

        @Override // com.digifly.cloudapi.listener.DCUploadTrainingDetailDataListener
        public void onFail(ResponseDataCollection responseDataCollection) {
            Log.d("cloudap2  Faili:", responseDataCollection.toString());
        }

        @Override // com.digifly.cloudapi.listener.DCUploadTrainingDetailDataListener
        public void onError(String str) {
            Log.d("cloudapi2   Error:", str.toString());
        }
    }

    private void updateTrainingDataToCloud(final DCTrainingData dCTrainingData) {
        CloudApi cloudApi = CloudApi.getInstance(this.activity);
        cloudApi.setDCUploadTrainingDataListener(new DCUploadTrainingDataListener() { // from class: com.dyaco.sole.fragment.display.DisplayMainFragment.5
            @Override // com.digifly.cloudapi.listener.DCUploadTrainingDataListener
            public void onSuccess(ResponseDataCollection responseDataCollection) {
                String str = responseDataCollection.getSys_response_data().get("trainh_no");
                Log.d("cloudapi   trainh_no  ", str);
                DCTrainingDataDao dCTrainingDataDao = DbManager.getDCTrainingDataDao();
                DCTrainingData dCTrainingDataLoad = dCTrainingDataDao.load(dCTrainingData.getTrainingId());
                dCTrainingDataLoad.setTrainh_no(str);
                dCTrainingDataDao.update(dCTrainingDataLoad);
                DisplayMainFragment.this.updateTrainingDetailDataToCloud(dCTrainingData);
            }

            @Override // com.digifly.cloudapi.listener.DCUploadTrainingDataListener
            public void onFail(ResponseDataCollection responseDataCollection) {
                Log.d("cloudapi  Faili:", responseDataCollection.toString());
            }

            @Override // com.digifly.cloudapi.listener.DCUploadTrainingDataListener
            public void onError(String str) {
                Log.d("cloudapi Error:", str.toString());
            }
        });
        cloudApi.callDCUploadTrainingData(dCTrainingData);
    }

    private void saveDCTrainingDetailData(DCTrainingData dCTrainingData, List<WorkoutData> list, Date date) {
        Calendar calendar = Calendar.getInstance(getLocale());
        calendar.setTimeInMillis(date.getTime());
        int i = ((calendar.get(15) / 1000) / 60) / 60;
        DCTrainingDetailDataDao dCTrainingDetailDataDao = DbManager.getDCTrainingDetailDataDao();
        for (WorkoutData workoutData : list) {
            DCTrainingDetailData dCTrainingDetailData = new DCTrainingDetailData();
            int accout_noFromDB = getAccout_noFromDB();
            Long trainingId = dCTrainingData.getTrainingId();
            dCTrainingDetailData.setAccount(Global.userName);
            dCTrainingDetailData.setAccount_no(accout_noFromDB);
            dCTrainingDetailData.setTrainingId(trainingId);
            dCTrainingDetailData.setTraning_datetime(date);
            int minute = (workoutData.getMinute() * 60) + workoutData.getSeconds();
            if (ProtocolHandler.protocol.setWorkoutTime > 0) {
                minute = (ProtocolHandler.protocol.setWorkoutTime * 60) - minute;
            }
            dCTrainingDetailData.setD_time(minute);
            float distance = workoutData.getDistance();
            if (ProtocolHandler.protocol.deviceUnit == 1) {
                distance = workoutData.getDistance() * 1.6f;
            }
            dCTrainingDetailData.setD_distance(distance);
            dCTrainingDetailData.setD_calories(workoutData.getCalories());
            dCTrainingDetailData.setD_hr(workoutData.getHeartRate());
            dCTrainingDetailData.setD_rpm(workoutData.getRpm());
            float speed = workoutData.getSpeed();
            if (ProtocolHandler.protocol.deviceUnit == 1) {
                speed = workoutData.getSpeed() * 1.6f;
            }
            dCTrainingDetailData.setD_speed(speed);
            dCTrainingDetailData.setD_watt(workoutData.getWatt());
            dCTrainingDetailData.setD_met(workoutData.getMets());
            dCTrainingDetailData.setD_level(workoutData.getNowLevel());
            dCTrainingDetailData.setD_incline(workoutData.getNowIncline());
            dCTrainingDetailData.setD_heart_rate_type(String.valueOf(workoutData.getHrType()));
            dCTrainingDetailData.setD_fusion_interval_time(workoutData.getFusionIntervalTime());
            dCTrainingDetailData.setD_fusion_recovery_time(workoutData.getFusionRecoveryTime());
            dCTrainingDetailData.setD_program_row(workoutData.getProgramRow());
            dCTrainingDetailData.setD_program_height(workoutData.getProgramHeight());
            dCTrainingDetailData.setD_program_level(workoutData.getNowLevel());
            dCTrainingDetailData.setD_program_total_step(workoutData.getTotalSteps());
            dCTrainingDetailData.setD_program_per_step(workoutData.getSpm());
            dCTrainingDetailData.setD_program_vert(workoutData.getVert());
            dCTrainingDetailData.setD_program_step_height(workoutData.getNowIncline());
            Log.d("ppp", dCTrainingDetailData.toString());
            dCTrainingDetailDataDao.insert(dCTrainingDetailData);
        }
    }

    private int getAccout_noFromDB() {
        QueryBuilder<MemberData> queryBuilder = DbManager.getMemberDataDao().queryBuilder();
        queryBuilder.where(MemberDataDao.Properties.Account.eq(Global.userName), new WhereCondition[0]);
        List<MemberData> list = queryBuilder.list();
        if (list == null || list.size() != 1) {
            return -1;
        }
        return list.get(0).getAccount_no();
    }

    private MemberData getAccoutData() {
        QueryBuilder<MemberData> queryBuilder = DbManager.getMemberDataDao().queryBuilder();
        queryBuilder.where(MemberDataDao.Properties.Account.eq(Global.userName), new WhereCondition[0]);
        List<MemberData> list = queryBuilder.list();
        if (list == null || list.size() != 1) {
            return null;
        }
        return list.get(0);
    }

    public void setShareAndTrackData(EndWorkoutData endWorkoutData) {
        String scaleToString = Global.getScaleToString(ProtocolHandler.protocol.getConvertDistanceUnit(endWorkoutData.getDistance()), 1);
        StringBuilder sb = new StringBuilder();
        sb.append(scaleToString);
        sb.append(StringUtils.SPACE);
        sb.append(this.res.getString(ProtocolHandler.protocol.deviceUnit == 0 ? R.string.unit_km : R.string.unit_mi));
        String string = sb.toString();
        int seconds = endWorkoutData.getSeconds() % 60;
        int seconds2 = endWorkoutData.getSeconds() / 60;
        Log.d(TAG, "----- minute = " + seconds2 + " , seconds = " + seconds);
        this.shareRecording = string + StringUtils.SPACE + seconds2 + "m" + seconds + "s";
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(calendar.getTimeInMillis() - ((long) (endWorkoutData.getSeconds() * 1000)));
        this.trackCalories = String.valueOf(endWorkoutData.getCalories());
        this.trackStartDate = CalendarUtils.getCalendarFormat(calendar.getTime(), CalendarUtils.SQL_DATE_TIME_FORMAT);
        this.trackDuration = String.valueOf(seconds2);
        this.trackDistance = scaleToString;
        this.trackSpeed = Global.getScaleToString(ProtocolHandler.protocol.getConvertDistanceUnit(endWorkoutData.getSpeed()), 1);
        this.trackHeartRate = String.valueOf(endWorkoutData.getHeartRate());
        Log.d(TAG, "----- trackStartDate = " + this.trackStartDate);
        Log.d(TAG, "----- trackDuration = " + this.trackDuration);
    }

    public String getShareRecording() {
        return this.shareRecording;
    }

    public String getTrackCalories() {
        return this.trackCalories;
    }

    public String getTrackStartDate() {
        return this.trackStartDate;
    }

    public String getTrackDuration() {
        return this.trackDuration;
    }

    public String getTrackDistance() {
        return this.trackDistance;
    }

    public String getTrackSpeed() {
        return this.trackSpeed;
    }

    public String getTrackHeartRate() {
        return this.trackHeartRate;
    }

    public void onRecordResult(int i, Intent intent) {
        String str = i == 101 ? "Fitbit " : "MapMyFitness ";
        if (intent != null) {
            Bundle extras = intent.getExtras();
            String string = extras != null ? extras.getString("error") : null;
            if (string == null) {
                Toast.makeText(this.activity, str + getString(R.string.record_succeed), 0).show();
                return;
            }
            Toast.makeText(this.activity, str + string, 0).show();
            return;
        }
        Toast.makeText(this.activity, str + getString(R.string.record_cancel), 0).show();
    }

    private void goFitbit() {
        Intent intent = new Intent(this.activity, (Class<?>) FitbitAuthenticationActivity.class);
        intent.putExtra("auth", false);
        intent.putExtra("trackCalories", this.trackCalories);
        intent.putExtra("trackStartDate", this.trackStartDate);
        intent.putExtra("trackDuration", this.trackDuration);
        intent.putExtra("trackDistance", this.trackDistance);
        this.activity.startActivityForResult(intent, 101);
        this.activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    private void goMapMyFitness() {
        if (ProtocolHandler.protocol.deviceUnit == 1) {
            this.trackSpeed = Global.getScaleToString(MyVariable.getScaleToFloat(Float.valueOf(this.trackSpeed).floatValue() * 1.6093f, 2), 1);
        }
        Intent intent = new Intent(this.activity, (Class<?>) MapMyFitnessActivity.class);
        intent.putExtra("auth", false);
        intent.putExtra("trackCalories", this.trackCalories);
        intent.putExtra("trackStartDate", this.trackStartDate);
        intent.putExtra("trackDuration", this.trackDuration);
        intent.putExtra("trackDistance", this.trackDistance);
        intent.putExtra("trackSpeed", this.trackSpeed);
        intent.putExtra("trackHeartRate", this.trackHeartRate);
        this.activity.startActivityForResult(intent, 102);
        this.activity.overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }
}
