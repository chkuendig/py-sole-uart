package com.dyaco.sole.activity;

import android.app.AlarmManager;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.app.PendingIntent;
import android.app.TimePickerDialog;
import android.bluetooth.BluetoothAdapter;
import android.bluetooth.BluetoothDevice;
import android.bluetooth.BluetoothGatt;
import android.bluetooth.BluetoothManager;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.hardware.display.VirtualDisplay;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.os.SystemClock;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.TimePicker;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.NotificationCompat;
import androidx.core.view.ViewCompat;
import androidx.exifinterface.media.ExifInterface;
import com.digifly.cloudapi.CloudApi;
import com.digifly.cloudapi.JsonUtil;
import com.digifly.cloudapi.data.BaseWebApiData;
import com.digifly.cloudapi.data.DCGoalWebData;
import com.digifly.cloudapi.data.DCProgramGoalData;
import com.digifly.cloudapi.data.DCTrainingData;
import com.digifly.cloudapi.data.DCTrainingDetailData;
import com.digifly.cloudapi.data.MemberData;
import com.digifly.cloudapi.data.MessagePullData;
import com.digifly.cloudapi.data.ResponseDataCollection;
import com.digifly.cloudapi.data.ResponseDataGet;
import com.digifly.cloudapi.data.ResponseDetailDataGet;
import com.digifly.cloudapi.data.ResponseMessage;
import com.digifly.cloudapi.data.ResponseMessagePush;
import com.digifly.cloudapi.listener.DCGetTrainingDataListener;
import com.digifly.cloudapi.listener.DCGetTrainingDetailDataListener;
import com.digifly.cloudapi.listener.DCGoalGetListener;
import com.digifly.cloudapi.listener.DCUploadTrainingDataListener;
import com.digifly.cloudapi.listener.DCUploadTrainingDetailDataListener;
import com.digifly.cloudapi.listener.GetPushMessageListener;
import com.digifly.cloudapi.listener.MemberChangeLangCodeListener;
import com.digifly.dbapi.DbManager;
import com.digifly.dbapi.greeddao_gen.DCProgramGoalDataDao;
import com.digifly.dbapi.greeddao_gen.DCTrainingDataDao;
import com.digifly.dbapi.greeddao_gen.DCTrainingDetailDataDao;
import com.digifly.dbapi.greeddao_gen.MemberDataDao;
import com.dyaco.ideabussdk_sole.library.MyActivity;
import com.dyaco.ideabussdk_sole.library.MyVariable;
import com.dyaco.ideabussdk_sole.protocol.EndWorkoutData;
import com.dyaco.ideabussdk_sole.protocol.SoleProtocol;
import com.dyaco.ideabussdk_sole.protocol.WorkoutData;
import com.dyaco.sole.AlarmReceiver;
import com.dyaco.sole.AlertSchedule;
import com.dyaco.sole.BluetoothLeService;
import com.dyaco.sole.BuildConfig;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.Execute;
import com.dyaco.sole.MyApp;
import com.dyaco.sole.R2;
import com.dyaco.sole.ScheduleData;
import com.dyaco.sole.ScreenshotTool;
import com.dyaco.sole.Week;
import com.dyaco.sole.custom.CalendarUtils;
import com.dyaco.sole.custom.DataUtils;
import com.dyaco.sole.custom.DateUtil;
import com.dyaco.sole.custom.DeviceModelList;
import com.dyaco.sole.custom.Fuel_DeviceModelList;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.PostUtil;
import com.dyaco.sole.custom.ProtocolHandler;
import com.dyaco.sole.custom.Sole_DeviceModelList;
import com.dyaco.sole.custom.Spirit_DeviceModelList;
import com.dyaco.sole.custom.Xterra_DeviceModelList;
import com.dyaco.sole.custom_view.ConnectionHRDialog;
import com.dyaco.sole.custom_view.ErrorDialog;
import com.dyaco.sole.custom_view.MessageListAlertDialog;
import com.dyaco.sole.custom_view.QuestMainView;
import com.dyaco.sole.custom_view.TypefaceTextView;
import com.dyaco.sole.database.MessageDB;
import com.dyaco.sole.database.ProfileDataDB;
import com.dyaco.sole.fragment.BaseFragment;
import com.dyaco.sole.fragment.calendar.CalendarMainFragment;
import com.dyaco.sole.fragment.display.DisplayMainFragment;
import com.dyaco.sole.fragment.programs.ProfilesFragment;
import com.dyaco.sole.fragment.programs.ProgramsExportDBPanelFragment;
import com.dyaco.sole.fragment.programs.ProgramsGoalAddEditFragment;
import com.dyaco.sole.fragment.programs.ProgramsGoalFragment;
import com.dyaco.sole.fragment.programs.ProgramsMainFragment;
import com.dyaco.sole.fragment.programs.ProgramsMenuFragment;
import com.dyaco.sole.fragment.user_profiles.EditGuestFragment;
import com.dyaco.sole.fragment.user_profiles.EditUserFragment;
import com.dyaco.sole.fragment.user_profiles.MemberUserFragment;
import com.dyaco.sole.fragment.user_profiles.NewUserFragment;
import com.dyaco.sole.listener.GetTrainingDataFinishListener;
import com.dyaco.sole.notification.MyFirebaseMessagingService;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.appevents.ondeviceprocessing.RemoteServiceWrapper;
import com.facebook.internal.AnalyticsEvents;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.gson.GsonBuilder;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import com.orhanobut.logger.AndroidLogAdapter;
import com.orhanobut.logger.Logger;
import com.orhanobut.logger.PrettyFormatStrategy;
import com.soletreadmills.sole.R;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.math.BigDecimal;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import java.util.UUID;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.protocol.HTTP;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.joda.time.MutableDateTime;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MainActivity extends MyActivity implements View.OnClickListener, ProtocolHandler.OnConnectionStateListener, ProtocolHandler.OnBluetoothStateListener, ProtocolHandler.OnDataResultListener, ProtocolHandler.OnWorkoutResultListener, BluetoothLeService.OnHRConnectListener, ProtocolHandler.OnErrorHappened {
    public static final int CALENDAR_MAIN = 6;
    private static final int CAMERA = 66;
    public static final int CAPTURE_CODE = 291;
    public static final int DISPLAY_MAIN = 5;
    public static final int MESSAGE_PULL = 13;
    private static final int PHOTO = 67;
    public static final int PROGRAMS_EDIT_PROFILE = 49;
    public static final int PROGRAMS_EXPORT_DB_PANEL = 10;
    public static final int PROGRAMS_GOAL = 8;
    public static final int PROGRAMS_GOAL_ADD_EDIT = 9;
    public static final int PROGRAMS_MAIN = 3;
    public static final int PROGRAMS_MENU = 7;
    public static final int PROGRAMS_PROFILES = 4;
    public static final int USER_PROFILES_EDIT = 11;
    public static final int USER_PROFILES_EDIT_GUEST = 12;
    public static final int USER_PROFILES_GUEST = 2;
    public static final int USER_PROFILES_NEW_USER = 1;
    public static final int USER_PROFILES_SIGN_IN = 0;
    private static WorkoutData autoConnectedOldSimulationWorkoutDataTemp;
    private AlarmManager alarmManager;
    private AlertSchedule alertSchedule;
    private RelativeLayout background;
    Handler backgroundHandler;
    private BluetoothAdapter bluetoothAdapter;
    private ImageView connect_hr_imageview;
    private FrameLayout content_layout;
    private int controlType;
    private ImageView control_cancel_image;
    private TypefaceTextView control_content_textview;
    private ImageView control_down_image;
    private TypefaceTextView control_title_textview;
    private ImageView control_up_image;
    private View control_view;
    private ErrorDialog errorDialog;
    private List<BaseFragment> fragments;
    public Uri imageUri;
    private boolean isConnecting;
    public int lastPage;
    private boolean linkLayoutIsShowing;
    private ImageView link_arrow_imageview;
    private ImageView link_fb_imageview;
    private LinearLayout link_layout;
    private ImageView link_mail_imageview;
    private ImageView link_music_imageview;
    private ImageView link_sfr_imageview;
    private ImageView link_tt_imageview;
    private ImageView link_yt_imageview;
    private BluetoothLeService mBluetoothLeService;
    private ImageView main_bottom_line;
    private ImageView menuQrCode;
    private ImageView menu_alert_imageview;
    private TypefaceTextView menu_calendar_textview;
    private ImageView menu_connect_imageview;
    private TypefaceTextView menu_display_textview;
    private ImageView menu_goal_imageview;
    private ImageView menu_language_imageview;
    private ImageView menu_message_imageview;
    private RelativeLayout menu_programs_layout;
    private TypefaceTextView menu_programs_textview;
    private ImageView menu_service;
    private ImageView menu_share_imageview;
    private TypefaceTextView menu_user_textview;
    private MessageListAlertDialog messageListAlertDialog;
    private AlertDialog qrCodeSelectDialog;
    private QuestMainView questMainView;
    private Resources res;
    private ImageView s_menu_calendar_image;
    private ImageView s_menu_display_image;
    private ImageView s_menu_programs_image;
    private ImageView s_menu_user_image;
    private ConnectionHRDialog selectHRDevice;
    private EditText showError;
    private LinearLayout title_layout;
    private static final String TAG = "Sole-MainActivity";
    private static Thread autoConnectedScaningUpdateWorkoutDataThread = null;
    private static boolean isAutoConnectedScaningUpdateWorkoutDataThreadRuningFlag = false;
    static AtomicInteger oneScreenshot = new AtomicInteger(0);
    private static boolean isAutoConnectedSimulationWorkoutDataAdd2Sec = false;
    private long backPressedTime = 0;
    private FragmentManager fragmentManager = getFragmentManager();
    public int nowPage = 0;
    private boolean isSaveQrCodeFitData = false;
    private boolean isQrCodePairingConsoleAccount = false;
    private boolean isWantShowMessagePullAlertDialog = false;
    private boolean isOnPause = false;
    private Integer callDCGetTrainingDataRunCount = 0;
    private GetTrainingDataFinishListener getTrainingDataFinishListener = null;
    private final BroadcastReceiver noticeTokenReceiver = new BroadcastReceiver() { // from class: com.dyaco.sole.activity.MainActivity.4
        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            MainActivity.this.updatePullMessages();
        }
    };
    private HandlerThread dbHandlerThread = null;
    private Handler dbHandler = null;
    private View.OnClickListener onMenuClick = new View.OnClickListener() { // from class: com.dyaco.sole.activity.MainActivity.7
        @Override // android.view.View.OnClickListener
        public void onClick(View view) {
            int id = view.getId();
            Context applicationContext = MainActivity.this.getApplicationContext();
            StringBuilder sb = new StringBuilder();
            sb.append("click_isDisplay:");
            sb.append(String.valueOf(MainActivity.this.nowPage == 5 && ProtocolHandler.protocol.isConnected()));
            ErrorLogSave.addErrorString(applicationContext, ErrorLogSave.CLICK, "main_onMenuClick", sb.toString());
            if (MainActivity.this.nowPage == 5 && ProtocolHandler.protocol.isConnected()) {
                MainActivity.this.showBaseAlert(Global.ALERT_TITLE_RID, R.string.confirm, true, R.string.display_alert_workout_progress, (DialogInterface.OnClickListener) null);
            }
            Global.shareMore = false;
            switch (id) {
                case R.id.menuQrCode /* 2131231391 */:
                    ErrorLogSave.addErrorString(MainActivity.this, ErrorLogSave.CLICK, "ProgramsMenuFragment_menuQrCode", ErrorLogSave.CLICK);
                    MainActivity.this.showQrCodeSelectDialog();
                    break;
                case R.id.menu_calendar_textview /* 2131231393 */:
                    ErrorLogSave.addErrorString(MainActivity.this.getApplicationContext(), ErrorLogSave.CLICK, "main_menuCalendar_btn", ErrorLogSave.CLICK);
                    MainActivity.this.setHRBtnVisible(8);
                    if (Global.calendarUserName.equals("") || Global.calendarUserName.equals(MainActivity.this.res.getString(R.string.guest))) {
                        MainActivity.this.showBaseAlert(Global.ALERT_TITLE_RID, R.string.confirm, true, R.string.must_sign_in, (DialogInterface.OnClickListener) null);
                        break;
                    } else {
                        MainActivity mainActivity = MainActivity.this;
                        mainActivity.resetButtonState(mainActivity.menu_calendar_textview, R.drawable.all_title_a_calendar, 6);
                        break;
                    }
                    break;
                case R.id.menu_programs_textview /* 2131231404 */:
                    ErrorLogSave.addErrorString(MainActivity.this.getApplicationContext(), ErrorLogSave.CLICK, "main_menuProgram_btn", ErrorLogSave.CLICK);
                    MainActivity.this.setHRBtnVisible(0);
                    MainActivity mainActivity2 = MainActivity.this;
                    mainActivity2.resetButtonState(mainActivity2.menu_programs_textview, R.drawable.all_title_a_program, 7);
                    break;
                case R.id.menu_user_textview /* 2131231411 */:
                    ErrorLogSave.addErrorString(MainActivity.this.getApplicationContext(), ErrorLogSave.CLICK, "main_menuUser_btn", ErrorLogSave.CLICK);
                    MainActivity.this.setHRBtnVisible(8);
                    MainActivity mainActivity3 = MainActivity.this;
                    mainActivity3.resetButtonState(mainActivity3.menu_user_textview, R.drawable.all_title_a_user, 0);
                    break;
            }
        }
    };
    private final CountDownTimer autoConnectedSimulationWorkoutDataCountDownTimer = new CountDownTimer(2000, 500) { // from class: com.dyaco.sole.activity.MainActivity.18
        @Override // android.os.CountDownTimer
        public void onTick(long j) {
        }

        @Override // android.os.CountDownTimer
        public void onFinish() {
            MainActivity.this.runAutoConnectedSimulationWorkoutData();
        }
    };
    private final ServiceConnection mServiceConnection = new ServiceConnection() { // from class: com.dyaco.sole.activity.MainActivity.21
        @Override // android.content.ServiceConnection
        public void onServiceConnected(ComponentName componentName, IBinder iBinder) {
            MainActivity.this.mBluetoothLeService = ((BluetoothLeService.LocalBinder) iBinder).getService();
            MainActivity.this.mBluetoothLeService.setOnHRConnectListener(MainActivity.this);
            if (MainActivity.this.mBluetoothLeService.initialize()) {
                return;
            }
            Log.e("ConnectionHRDialog", "Unable to initialize Bluetooth");
        }

        @Override // android.content.ServiceConnection
        public void onServiceDisconnected(ComponentName componentName) {
            MainActivity.this.mBluetoothLeService = null;
        }
    };
    private final BluetoothAdapter.LeScanCallback leScanCallback = new BluetoothAdapter.LeScanCallback() { // from class: com.dyaco.sole.activity.MainActivity.22
        @Override // android.bluetooth.BluetoothAdapter.LeScanCallback
        public void onLeScan(BluetoothDevice bluetoothDevice, int i, byte[] bArr) {
            BluetoothGatt bluetoothGatt;
            synchronized (MainActivity.this.leScanCallback) {
                if (MainActivity.this.selectHRDevice.adapter != null && MainActivity.this.selectHRDevice.adapter.mConnectionDevice.size() > 0) {
                    for (int i2 = 0; i2 < MainActivity.this.selectHRDevice.adapter.mConnectionDevice.size(); i2++) {
                        if (bluetoothDevice.getAddress().equals(MainActivity.this.selectHRDevice.adapter.mConnectionDevice.get(i2).getAddress())) {
                            return;
                        }
                    }
                }
                if (TextUtils.isEmpty(bluetoothDevice.getName())) {
                    return;
                }
                Log.e("getHRscan", bluetoothDevice.getName() + " | " + bluetoothDevice.getAddress() + " | " + i);
                MainActivity.this.selectHRDevice.adapter.addConnectionDevice(bluetoothDevice, i);
                if (MainActivity.this.mBluetoothLeService != null && (bluetoothGatt = MainActivity.this.mBluetoothLeService.getmBluetoothGatt()) != null && TextUtils.equals(bluetoothGatt.getDevice().getAddress(), bluetoothDevice.getAddress()) && MainActivity.this.mBluetoothLeService.isConnected() && MainActivity.this.selectHRDevice.adapter.getCount() > 0 && TextUtils.equals(MainActivity.this.selectHRDevice.adapter.getItemMac(MainActivity.this.selectHRDevice.adapter.getCount() - 1), bluetoothDevice.getAddress())) {
                    MainActivity.this.selectHRDevice.adapter.setSelected(MainActivity.this.selectHRDevice.adapter.getCount() - 1);
                }
            }
        }
    };
    public int heartRate = 0;

    public void disconnectSaving() {
    }

    public String getProgromName(int i) {
        switch (i) {
            case 0:
                return "Manual";
            case 1:
                return "Hill";
            case 2:
                return "Fat Burn";
            case 3:
                return "Cardio";
            case 4:
                return "Calories";
            case 5:
                return "Interval";
            case 6:
                return "Heart Rate";
            case 7:
                return "Custom";
            case 8:
                return "5k Run";
            case 9:
                return "10k Run";
            case 10:
                return "Strength";
            default:
                return "";
        }
    }

    @Override // com.dyaco.sole.custom.ProtocolHandler.OnWorkoutResultListener
    public void onWorkoutResult(WorkoutData workoutData) {
    }

    public void setSave() {
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        startDbHandler();
        this.bluetoothAdapter = ((BluetoothManager) getSystemService("bluetooth")).getAdapter();
        Global.nowActivityName = MainActivity.class.getName();
        Global.printLog("d", TAG, "onCreate - " + Global.nowActivityName);
        getWindow().addFlags(128);
        registerReceiver(this.noticeTokenReceiver, new IntentFilter(MyFirebaseMessagingService.INTENT_FILTER));
        Logger.addLogAdapter(new AndroidLogAdapter(PrettyFormatStrategy.newBuilder().methodCount(6).build()));
        ProtocolHandler.init(this);
        ProtocolHandler.protocol.setHandler(this);
        ProtocolHandler.protocol.setOnErrorHappened(this);
        int i = Global.BRAND;
        if (i == 0) {
            setContentView(R.layout.activity_main);
        } else if (i == 1) {
            setContentView(R.layout.s_activity_main);
        } else if (i == 2 || i == 3) {
            setContentView(R.layout.x_activity_main);
        }
        initFragments();
        findViews();
        initParams();
        setListeners();
        AlertSchedule alertSchedule = MyApp.alertSchedule;
        this.alertSchedule = alertSchedule;
        if (alertSchedule == null) {
            this.alertSchedule = new AlertSchedule();
        }
        refreshOmronToken();
        checkStravaAccessToken();
        if (!ErrorLogSave.isCheckVersion) {
            checkVersion();
            ErrorLogSave.isCheckVersion = true;
        }
        callDCUploadNoticeToken();
    }

    private void checkVersion() {
        if (ErrorLogSave.VERSION_NAME == null || ErrorLogSave.VERSION_NAME.length() <= 0) {
            return;
        }
        Execute.getAppVersion(ErrorLogSave.SOLE_VER, new Callback() { // from class: com.dyaco.sole.activity.MainActivity.1
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws JSONException, IOException {
                try {
                    String string = new JSONObject(response.body().string()).getString("sys_response_data");
                    if (string != null && string.length() > 0 && !string.equals("null")) {
                        Log.e("LogoActivity", "checkVersion : " + ErrorLogSave.VERSION_NAME + " | " + string);
                        if (ErrorLogSave.VERSION_NAME.equals(string)) {
                            return;
                        }
                        MainActivity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.MainActivity.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (Global.BRAND != 0 || MyApp.isWork) {
                                    return;
                                }
                                MainActivity.this.showErrorLog(R.string.error_0001, ErrorLogSave.ERROR_0001);
                            }
                        });
                    }
                } catch (Exception unused) {
                }
            }
        });
    }

    @Override // android.app.Activity
    public void onResume() {
        super.onResume();
        this.isOnPause = false;
        Global.nowActivityName = MainActivity.class.getName();
        Global.printLog("d", TAG, "onResume - " + Global.nowActivityName);
        ProtocolHandler.protocol.setOnWorkoutResultListener(this);
        this.alarmManager = (AlarmManager) getSystemService(NotificationCompat.CATEGORY_ALARM);
        bindService(new Intent(getApplicationContext(), (Class<?>) BluetoothLeService.class), this.mServiceConnection, 1);
        updatePullMessages();
        if (this.isWantShowMessagePullAlertDialog) {
            showMessagePullAlertDialog();
        }
    }

    private void callDCUploadNoticeToken() {
        String str = TAG;
        Log.d(str, "callDCUploadNoticeToken");
        boolean zIsPackageInstalled = isPackageInstalled("com.android.vending");
        Log.d(str, "callDCUploadNoticeToken -> isGooglePlayInstall=" + zIsPackageInstalled);
        if (zIsPackageInstalled) {
            FirebaseMessaging.getInstance().getToken().addOnCompleteListener(new OnCompleteListener<String>() { // from class: com.dyaco.sole.activity.MainActivity.2
                @Override // com.google.android.gms.tasks.OnCompleteListener
                public void onComplete(Task<String> task) {
                    if (!task.isSuccessful()) {
                        Log.e(MainActivity.TAG, "callDCUploadNoticeToken -> Firebase onComplete -> token failure");
                        return;
                    }
                    if (task.getResult() == null) {
                        Log.e(MainActivity.TAG, "callDCUploadNoticeToken -> Firebase onComplete -> task.getResult() == null");
                        return;
                    }
                    String result = task.getResult();
                    Log.d(MainActivity.TAG, "callDCUploadNoticeToken -> Firebase onComplete -> token=" + result);
                    MemberData accoutData = MainActivity.this.getAccoutData();
                    if (Global.userName == null) {
                        Log.e(MainActivity.TAG, "callDCUploadNoticeToken -> Firebase onComplete -> Global.userName == null");
                        return;
                    }
                    if (accoutData == null) {
                        Log.e(MainActivity.TAG, "callDCUploadNoticeToken -> Firebase onComplete -> accoutData == null");
                    } else if (accoutData.getPassword() == null) {
                        Log.e(MainActivity.TAG, "callDCUploadNoticeToken -> Firebase onComplete -> accoutData == null");
                    } else {
                        MainActivity.this.callDCUploadNoticeTokenListener(Global.userName, accoutData.getPassword(), result, AppEventsConstants.EVENT_PARAM_VALUE_YES);
                    }
                }
            });
        }
        onNewIntent(getIntent());
    }

    public void callDCUploadNoticeTokenListener(String str, String str2, String str3, String str4) {
        Request requestBuild = new Request.Builder().url(CloudApi.CLOUD_URL_UPLOAD_NOTICE_TOKEN).post(new FormBody.Builder().add(MessageDB.ACCOUNT, str).add("password", str2).add("device_type", str4).add("token", str3).add("app_package_name", BuildConfig.APPLICATION_ID).build()).build();
        new OkHttpClient();
        new OkHttpClient.Builder().connectTimeout(10L, TimeUnit.SECONDS).writeTimeout(10L, TimeUnit.SECONDS).readTimeout(10L, TimeUnit.SECONDS).build().newCall(requestBuild).enqueue(new Callback() { // from class: com.dyaco.sole.activity.MainActivity.3
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                Log.e(MainActivity.TAG, "callDCUploadNoticeTokenListener -> onFailure Exception=" + iOException.getMessage());
                iOException.printStackTrace();
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    Log.d(MainActivity.TAG, "callDCUploadNoticeTokenListener -> onResponse");
                    String strString = response.body().string();
                    Log.d(MainActivity.TAG, "callDCUploadNoticeTokenListener -> onResponse -> strResponse=" + strString);
                    ResponseDataCollection responseDataCollection = JsonUtil.parseResponseDataCollection(strString);
                    if (responseDataCollection.isSuccess()) {
                        Log.d(MainActivity.TAG, "callDCUploadNoticeTokenListener -> onResponse -> successfully");
                    } else {
                        String message = responseDataCollection.getSys_response_message().getMessage();
                        Log.e(MainActivity.TAG, "callDCUploadNoticeTokenListener -> onResponse -> fail Msg=" + message);
                    }
                } catch (Exception e) {
                    Log.e(MainActivity.TAG, "callDCUploadNoticeTokenListener -> onResponse -> Exception=" + e.getMessage());
                    e.printStackTrace();
                }
            }
        });
    }

    @Override // android.app.Activity
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        String str = TAG;
        Log.d(str, "onNewIntent");
        updatePullMessages();
        if (intent != null) {
            Log.d(str, "onNewIntent 01");
            if (Global.noticeMessage_no.length() > 0) {
                Log.d(str, "onNewIntent 02");
                if (this.isOnPause) {
                    this.isWantShowMessagePullAlertDialog = true;
                } else {
                    showMessagePullAlertDialog();
                }
            }
        }
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        Global.isMainActivityRun = true;
        if (Global.memberData == null) {
            ToLoginPage();
            return;
        }
        if (ShareDialog.flag) {
            ShareDialog.flag = true ^ ShareDialog.flag;
            return;
        }
        Global.printLog("d", TAG, "onStart - " + Global.nowActivityName);
        getIntent().getBooleanExtra("restart", false);
        if (!Global.calendarUserName.equals("") && !Global.calendarUserName.equals(this.res.getString(R.string.guest))) {
            this.menu_calendar_textview.setTextColor(this.res.getColor(R.color.white));
        }
        this.menu_programs_textview.setTextColor(this.res.getColor(R.color.white));
        if (Global.BRAND == 0) {
            if (getNowPage() == 0) {
                setBackgroundColor(Color.rgb(R2.attr.divider, R2.attr.divider, R2.attr.divider));
            } else {
                setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
            }
        }
        int i = this.nowPage;
        if (i == 0) {
            resetButtonState(this.menu_user_textview, R.drawable.all_title_a_user, -1);
        } else if (i == 5) {
            resetButtonState(this.menu_display_textview, R.drawable.all_title_a_display, -1);
        } else if (i == 6) {
            resetButtonState(this.menu_calendar_textview, R.drawable.all_title_a_calendar, -1);
        } else if (i == 7) {
            resetButtonState(this.menu_programs_textview, R.drawable.all_title_a_program, -1);
        }
        ProtocolHandler.init(this);
        ProtocolHandler.protocol.setHandler(this);
        if (!ProtocolHandler.protocol.isConnected()) {
            onConnectState(SoleProtocol.ConnectState.Disconnect);
            switchFragment(7);
        } else {
            onConnectState(SoleProtocol.ConnectState.Connected);
        }
        startDataSyncTimer();
        uploadMemberChangeLangCode();
    }

    public void updatePullMessages() {
        CloudApi cloudApi = CloudApi.getInstance(this);
        cloudApi.setGetPushMessageListener(new GetPushMessageListener() { // from class: com.dyaco.sole.activity.MainActivity.5
            @Override // com.digifly.cloudapi.listener.GetPushMessageListener
            public void onError(String str) {
            }

            @Override // com.digifly.cloudapi.listener.GetPushMessageListener
            public void onFail(ResponseMessagePush responseMessagePush) {
            }

            @Override // com.digifly.cloudapi.listener.GetPushMessageListener
            public void onSuccess(ResponseMessagePush responseMessagePush) {
                final boolean z;
                List<MessagePullData> sys_response_data = responseMessagePush.getSys_response_data();
                Logger.d("sys_response_data = " + sys_response_data);
                Iterator<MessagePullData> it = sys_response_data.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        z = false;
                        break;
                    } else if (it.next().getUmsg_isread() == 0) {
                        z = true;
                        break;
                    }
                }
                MainActivity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.MainActivity.5.1
                    /* JADX WARN: Removed duplicated region for block: B:16:0x002c  */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void run() {
                        int i;
                        int i2;
                        int i3;
                        int i4 = Global.BRAND;
                        int i5 = 0;
                        if (i4 == 0) {
                            i = R.drawable.message_icon_white;
                            i2 = R.drawable.nomessage_icon_white;
                        } else {
                            if (i4 != 1 && i4 != 2 && i4 != 3) {
                                i3 = 0;
                                ImageView imageView = MainActivity.this.menu_message_imageview;
                                if (z) {
                                    i5 = i3;
                                }
                                imageView.setBackgroundResource(i5);
                            }
                            i = R.drawable.message_icon_color;
                            i2 = R.drawable.nomessage_icon_color;
                        }
                        int i6 = i;
                        i5 = i2;
                        i3 = i6;
                        ImageView imageView2 = MainActivity.this.menu_message_imageview;
                        if (z) {
                        }
                        imageView2.setBackgroundResource(i5);
                    }
                });
            }
        });
        if (Global.memberData == null || Global.memberData.getAccount() == null || Global.memberData.getPassword() == null) {
            return;
        }
        cloudApi.callMessagePull(Global.memberData.getAccount(), Global.memberData.getPassword());
    }

    private boolean hadExportedUsersFromSPF() {
        return getSharedPreferences("exported_users", 0).getBoolean("hadExportData", false);
    }

    private void setExportedUsersFSPF(boolean z) {
        getSharedPreferences("exported_users", 0).edit().putBoolean("hadExportData", z).apply();
    }

    public void startDataSyncTimer() {
        synchronized (this.callDCGetTrainingDataRunCount) {
            if (this.callDCGetTrainingDataRunCount.intValue() > 0) {
                return;
            }
            if (MyApp.dataSyncTimer != null) {
                MyApp.dataSyncTimer.cancel();
            }
            MyApp.dataSyncTimer = new Timer();
            MyApp.dataSyncTimer.schedule(new MyTimerTask(), 100L, 21600000L);
            MyApp.goalDataSyncTimer = new Timer();
            MyApp.goalDataSyncTimer.schedule(new MyGoalTimerTask(), 100L);
        }
    }

    @Override // com.dyaco.sole.custom.ProtocolHandler.OnWorkoutResultListener
    public void onEndWorkoutResult(EndWorkoutData endWorkoutData) {
        Log.e("getEndMessage", String.valueOf(SoleProtocol.notRunning));
        saveEnd(endWorkoutData);
    }

    @Override // com.dyaco.sole.custom.ProtocolHandler.OnErrorHappened
    public void onError(String str) {
        Log.e("getError", "main" + str);
    }

    void startDbHandler() {
        stopDbHandler();
        HandlerThread handlerThread = new HandlerThread(TAG + "DbHandlerThread", -2);
        this.dbHandlerThread = handlerThread;
        handlerThread.start();
        this.dbHandler = new Handler(this.dbHandlerThread.getLooper());
    }

    void stopDbHandler() {
        Handler handler = this.dbHandler;
        if (handler != null) {
            handler.removeCallbacksAndMessages(null);
        }
        this.dbHandler = null;
        HandlerThread handlerThread = this.dbHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        this.dbHandlerThread = null;
    }

    public class MyTimerTask extends TimerTask {
        public MyTimerTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() throws InterruptedException {
            Log.d(MainActivity.TAG, "start  timer ");
            final MemberData accoutData = MainActivity.this.getAccoutData();
            if (accoutData == null) {
                return;
            }
            LocalDate localDate = DateTime.now().toLocalDate();
            Logger.d("ttt = ttt");
            final LocalDate localDateMinusDays = localDate.minusDays(R2.attr.layout_constraintEnd_toStartOf);
            Logger.d("localDate = " + localDateMinusDays);
            Logger.d("acc.getPassword = " + accoutData.getPassword());
            CloudApi cloudApiCreateInstance = CloudApi.createInstance(MainActivity.this);
            cloudApiCreateInstance.setDCGetTrainingDataListener(new DCGetTrainingDataListener() { // from class: com.dyaco.sole.activity.MainActivity.MyTimerTask.1
                @Override // com.digifly.cloudapi.listener.DCGetTrainingDataListener
                public void onSuccess(final List<DCTrainingData> list) {
                    Logger.d("get DCTrainingData  datas = " + list);
                    if (list == null || list.isEmpty()) {
                        MainActivity.this.closeLoadDialogForCallDCGetTrainingData();
                    } else if (MainActivity.this.dbHandler != null) {
                        MainActivity.this.dbHandler.post(new Runnable() { // from class: com.dyaco.sole.activity.MainActivity.MyTimerTask.1.1
                            @Override // java.lang.Runnable
                            public void run() {
                                for (DCTrainingData dCTrainingData : list) {
                                    if (!TextUtils.isEmpty(dCTrainingData.getBrand_code())) {
                                        boolean zContains = dCTrainingData.getBrand_code().contains(Global.CLOUD_BRAND_NAME);
                                        if (dCTrainingData.getBrand_code().equals("garmin")) {
                                            zContains = true;
                                        }
                                        if (zContains) {
                                            try {
                                                dCTrainingData.setAccount(accoutData.getAccount());
                                                dCTrainingData.setAccount_no(accoutData.getAccount_no());
                                                String trainh_no = dCTrainingData.getTrainh_no();
                                                DbManager.getInstance(MainActivity.this);
                                                DCTrainingDataDao dCTrainingDataDao = DbManager.getDCTrainingDataDao();
                                                if (dCTrainingDataDao.queryBuilder().where(DCTrainingDataDao.Properties.Trainh_no.eq(trainh_no), new WhereCondition[0]).list().size() == 0) {
                                                    long jInsert = dCTrainingDataDao.insert(dCTrainingData);
                                                    Log.d(MainActivity.TAG, "DCGetTrainingDataListener -> onSuccess insertRowId=" + jInsert);
                                                }
                                                CloudApi cloudApiCreateInstance2 = CloudApi.createInstance(MainActivity.this);
                                                cloudApiCreateInstance2.setDCGetTrainingDetailDataListener(MainActivity.this.new MyDCGetTrainingDetailDataListener(accoutData, dCTrainingData));
                                                cloudApiCreateInstance2.callDCGetTrainingDetailData(Global.userName, accoutData.getPassword(), localDateMinusDays.toString(CalendarUtils.SQL_DATE_FORMAT));
                                                MainActivity.this.showLoadDialogForCallDCGetTrainingData();
                                            } catch (Exception e) {
                                                e.printStackTrace();
                                            }
                                        }
                                    }
                                }
                                MainActivity.this.closeLoadDialogForCallDCGetTrainingData();
                            }
                        });
                    } else {
                        MainActivity.this.closeLoadDialogForCallDCGetTrainingData();
                    }
                }

                @Override // com.digifly.cloudapi.listener.DCGetTrainingDataListener
                public void onFail(ResponseDataGet responseDataGet) {
                    Log.d(MainActivity.TAG, "get DCTrainingData responseDataCollection = " + responseDataGet);
                    MainActivity.this.closeLoadDialogForCallDCGetTrainingData();
                }

                @Override // com.digifly.cloudapi.listener.DCGetTrainingDataListener
                public void onError(String str) {
                    Log.d(MainActivity.TAG, "get DCTrainingData err = " + str);
                    MainActivity.this.closeLoadDialogForCallDCGetTrainingData();
                }
            });
            cloudApiCreateInstance.callDCGetTrainingData(Global.userName, accoutData.getPassword(), localDateMinusDays.toString(CalendarUtils.SQL_DATE_FORMAT));
            MainActivity.this.showLoadDialogForCallDCGetTrainingData();
            try {
                Thread.sleep(200L);
            } catch (Exception e) {
                e.printStackTrace();
            }
            DbManager.getInstance(MainActivity.this);
            List<DCTrainingData> list = DbManager.getDCTrainingDataDao().queryBuilder().where(DCTrainingDataDao.Properties.Trainh_no.eq(""), new WhereCondition[0]).list();
            if (list.size() > 0) {
                for (final DCTrainingData dCTrainingData : list) {
                    dCTrainingData.setPassword(accoutData.getPassword());
                    CloudApi cloudApiCreateInstance2 = CloudApi.createInstance(MainActivity.this);
                    cloudApiCreateInstance2.setDCUploadTrainingDataListener(new DCUploadTrainingDataListener() { // from class: com.dyaco.sole.activity.MainActivity.MyTimerTask.2
                        @Override // com.digifly.cloudapi.listener.DCUploadTrainingDataListener
                        public void onSuccess(final ResponseDataCollection responseDataCollection) {
                            if (MainActivity.this.dbHandler != null) {
                                MainActivity.this.dbHandler.post(new Runnable() { // from class: com.dyaco.sole.activity.MainActivity.MyTimerTask.2.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        String str = responseDataCollection.getSys_response_data().get("trainh_no");
                                        DCTrainingDataDao dCTrainingDataDao = DbManager.getDCTrainingDataDao();
                                        DCTrainingData dCTrainingDataLoad = dCTrainingDataDao.load(dCTrainingData.getTrainingId());
                                        dCTrainingDataLoad.setTrainh_no(str);
                                        dCTrainingDataDao.update(dCTrainingDataLoad);
                                        MainActivity.this.updateTrainingDetailDataToCloud(dCTrainingDataLoad);
                                    }
                                });
                            }
                        }

                        @Override // com.digifly.cloudapi.listener.DCUploadTrainingDataListener
                        public void onFail(ResponseDataCollection responseDataCollection) {
                            Log.d(MainActivity.TAG, "dcUploadTrainingDataListener = " + responseDataCollection);
                        }

                        @Override // com.digifly.cloudapi.listener.DCUploadTrainingDataListener
                        public void onError(String str) {
                            Log.d(MainActivity.TAG, "dcUploadTrainingDataListener  err = " + str);
                        }
                    });
                    cloudApiCreateInstance2.callDCUploadTrainingData(dCTrainingData);
                }
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void showLoadDialogForCallDCGetTrainingData() {
        synchronized (this.callDCGetTrainingDataRunCount) {
            this.callDCGetTrainingDataRunCount = Integer.valueOf(this.callDCGetTrainingDataRunCount.intValue() + 1);
        }
        Log.d(TAG, "showLoadDialogForCallDCGetTrainingData callDCGetTrainingDataRunCount=" + this.callDCGetTrainingDataRunCount);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void closeLoadDialogForCallDCGetTrainingData() {
        Integer numValueOf;
        synchronized (this.callDCGetTrainingDataRunCount) {
            numValueOf = Integer.valueOf(this.callDCGetTrainingDataRunCount.intValue() - 1);
            this.callDCGetTrainingDataRunCount = numValueOf;
        }
        if (numValueOf.intValue() <= 0) {
            synchronized (this) {
                this.callDCGetTrainingDataRunCount = 0;
                if (this.getTrainingDataFinishListener != null) {
                    runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.MainActivity.6
                        @Override // java.lang.Runnable
                        public void run() {
                            if (MainActivity.this.getTrainingDataFinishListener != null) {
                                MainActivity.this.getTrainingDataFinishListener.onFinish();
                            }
                        }
                    });
                }
            }
        }
        Log.d(TAG, "closeLoadDialogForCallDCGetTrainingData callDCGetTrainingDataRunCount=" + this.callDCGetTrainingDataRunCount);
    }

    public void setGetTrainingDataFinishListener(GetTrainingDataFinishListener getTrainingDataFinishListener) {
        this.getTrainingDataFinishListener = getTrainingDataFinishListener;
    }

    public class MyGoalTimerTask extends TimerTask {
        public MyGoalTimerTask() {
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            CloudApi cloudApi = CloudApi.getInstance(MainActivity.this);
            cloudApi.setGoalGetListener(new DCGoalGetListener() { // from class: com.dyaco.sole.activity.MainActivity.MyGoalTimerTask.1
                @Override // com.digifly.cloudapi.listener.DCGoalGetListener
                public void onSuccess(List<DCGoalWebData> list) {
                    Logger.d("data = " + list);
                    DbManager.getInstance(MainActivity.this);
                    DCProgramGoalDataDao dCProgramGoalDataDao = DbManager.getDCProgramGoalDataDao();
                    dCProgramGoalDataDao.deleteAll();
                    Iterator<DCGoalWebData> it = list.iterator();
                    while (it.hasNext()) {
                        DCProgramGoalData dCProgramGoalDataConvertToGoalData = DataUtils.convertToGoalData(it.next());
                        dCProgramGoalDataDao.insert(dCProgramGoalDataConvertToGoalData);
                        Logger.d("goalDBData = " + dCProgramGoalDataConvertToGoalData);
                    }
                }

                @Override // com.digifly.cloudapi.listener.DCGoalGetListener
                public void onFail(ResponseMessage responseMessage) {
                    Logger.d("responseDataCollection = " + responseMessage);
                }

                @Override // com.digifly.cloudapi.listener.DCGoalGetListener
                public void onError(String str) {
                    Logger.d("err = " + str);
                }
            });
            cloudApi.callGoalGet(Global.memberData.getAccount(), Global.memberData.getPassword());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTrainingDetailDataToCloud(DCTrainingData dCTrainingData) {
        Long trainingId = dCTrainingData.getTrainingId();
        QueryBuilder<DCTrainingDetailData> queryBuilder = DbManager.getDCTrainingDetailDataDao().queryBuilder();
        queryBuilder.where(DCTrainingDetailDataDao.Properties.TrainingId.eq(trainingId), new WhereCondition[0]);
        for (DCTrainingDetailData dCTrainingDetailData : queryBuilder.list()) {
            dCTrainingDetailData.setPassword(dCTrainingData.getPassword());
            dCTrainingDetailData.setTrainh_no(dCTrainingData.getTrainh_no());
            CloudApi cloudApiCreateInstance = CloudApi.createInstance(this);
            cloudApiCreateInstance.setDCUploadTrainingDetailDataListener(new MyDCUploadTrainingDetailDataListener(dCTrainingDetailData));
            cloudApiCreateInstance.callDCUploadTrainingDetailData(dCTrainingDetailData);
        }
    }

    class MyDCGetTrainingDetailDataListener implements DCGetTrainingDetailDataListener {
        private final MemberData accoutData;
        private final DCTrainingData dcTrainingData;

        public MyDCGetTrainingDetailDataListener(MemberData memberData, DCTrainingData dCTrainingData) {
            this.accoutData = memberData;
            this.dcTrainingData = dCTrainingData;
        }

        @Override // com.digifly.cloudapi.listener.DCGetTrainingDetailDataListener
        public void onSuccess(final List<DCTrainingDetailData> list) {
            Log.d(MainActivity.TAG, "get TrainingDetailData  datas = " + list);
            if (list == null || list.isEmpty()) {
                MainActivity.this.closeLoadDialogForCallDCGetTrainingData();
            } else if (MainActivity.this.dbHandler != null) {
                MainActivity.this.dbHandler.post(new Runnable() { // from class: com.dyaco.sole.activity.MainActivity.MyDCGetTrainingDetailDataListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        for (DCTrainingDetailData dCTrainingDetailData : list) {
                            dCTrainingDetailData.setAccount(MyDCGetTrainingDetailDataListener.this.accoutData.getAccount());
                            dCTrainingDetailData.setAccount_no(MyDCGetTrainingDetailDataListener.this.accoutData.getAccount_no());
                            dCTrainingDetailData.setTrainingId(MyDCGetTrainingDetailDataListener.this.dcTrainingData.getTrainingId());
                            dCTrainingDetailData.getTrainh_no();
                            String trainh_detail_no = dCTrainingDetailData.getTrainh_detail_no();
                            DbManager.getInstance(MainActivity.this);
                            DCTrainingDetailDataDao dCTrainingDetailDataDao = DbManager.getDCTrainingDetailDataDao();
                            if (dCTrainingDetailDataDao.queryBuilder().where(DCTrainingDetailDataDao.Properties.Trainh_detail_no.eq(trainh_detail_no), new WhereCondition[0]).list().size() == 0) {
                                long jInsert = dCTrainingDetailDataDao.insert(dCTrainingDetailData);
                                Log.d(MainActivity.TAG, "MyDCGetTrainingDetailDataListener -> onSuccess insertRowId=" + jInsert);
                            }
                        }
                        MainActivity.this.closeLoadDialogForCallDCGetTrainingData();
                    }
                });
            } else {
                MainActivity.this.closeLoadDialogForCallDCGetTrainingData();
            }
        }

        @Override // com.digifly.cloudapi.listener.DCGetTrainingDetailDataListener
        public void onFail(ResponseDetailDataGet responseDetailDataGet) {
            Log.d(MainActivity.TAG, "get TrainingDetailData  responseDataCollection = " + responseDetailDataGet);
            MainActivity.this.closeLoadDialogForCallDCGetTrainingData();
        }

        @Override // com.digifly.cloudapi.listener.DCGetTrainingDetailDataListener
        public void onError(String str) {
            Log.d(MainActivity.TAG, "get TrainingDetailData  err = " + str);
            MainActivity.this.closeLoadDialogForCallDCGetTrainingData();
        }
    }

    class MyDCUploadTrainingDetailDataListener implements DCUploadTrainingDetailDataListener {
        private final DCTrainingDetailData dcTrainingDetailData;

        public MyDCUploadTrainingDetailDataListener(DCTrainingDetailData dCTrainingDetailData) {
            this.dcTrainingDetailData = dCTrainingDetailData;
        }

        @Override // com.digifly.cloudapi.listener.DCUploadTrainingDetailDataListener
        public void onSuccess(final ResponseDataCollection responseDataCollection) {
            if (MainActivity.this.dbHandler != null) {
                MainActivity.this.dbHandler.post(new Runnable() { // from class: com.dyaco.sole.activity.MainActivity.MyDCUploadTrainingDetailDataListener.1
                    @Override // java.lang.Runnable
                    public void run() {
                        String str = responseDataCollection.getSys_response_data().get("trainh_detail_no");
                        Log.d("qqq trainh_detail_no", str);
                        MyDCUploadTrainingDetailDataListener.this.dcTrainingDetailData.setTrainh_detail_no(str);
                        DbManager.getDCTrainingDetailDataDao().update(MyDCUploadTrainingDetailDataListener.this.dcTrainingDetailData);
                    }
                });
            }
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

    /* JADX INFO: Access modifiers changed from: private */
    public MemberData getAccoutData() {
        if (Global.memberData == null || Global.memberData.getAccount_no() == 0) {
            return null;
        }
        DbManager.getInstance(this);
        QueryBuilder<MemberData> queryBuilder = DbManager.getMemberDataDao().queryBuilder();
        queryBuilder.where(MemberDataDao.Properties.Account_no.eq(Integer.valueOf(Global.memberData.getAccount_no())), new WhereCondition[0]);
        List<MemberData> list = queryBuilder.list();
        if (list == null || list.size() != 1) {
            return null;
        }
        return list.get(0);
    }

    @Override // android.app.Activity
    protected void onPause() {
        super.onPause();
        this.isOnPause = true;
        System.gc();
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        stopDbHandler();
        Global.isMainActivityRun = false;
        Global.printLog("d", TAG, "onDestroy");
        ProtocolHandler.protocol.disconnect();
        setAutoConnectedScaningUpdateWorkoutDataThreadRuningFlag(false);
        enableAutoConnectedSimulationWorkoutDataCountDownTimer(false);
        for (BaseFragment baseFragment : this.fragments) {
        }
        this.fragments = null;
        this.fragmentManager = null;
        ProtocolHandler.release();
        MessageListAlertDialog messageListAlertDialog = this.messageListAlertDialog;
        if (messageListAlertDialog != null) {
            messageListAlertDialog.dismiss();
        }
        unregisterReceiver(this.noticeTokenReceiver);
        closeQrCodeSelectDialog();
        BluetoothLeService bluetoothLeService = this.mBluetoothLeService;
        if (bluetoothLeService != null) {
            bluetoothLeService.stopSelf();
        }
    }

    @Override // android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        Global.printLog("d", TAG, "onConfigurationChanged");
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        View view = this.control_view;
        if (view != null && view.getVisibility() == 0) {
            this.control_view.setVisibility(8);
            return;
        }
        int i = this.nowPage;
        if (i == 1 || i == 2) {
            switchFragment(0);
            return;
        }
        if (i == 4) {
            switchFragment(3);
            return;
        }
        if (i != 5) {
            if (i == 49) {
                switchFragment(3);
                return;
            }
            switch (i) {
                case 8:
                    break;
                case 9:
                    switchFragment(0);
                    break;
                case 10:
                    switchFragment(0);
                    break;
                default:
                    System.currentTimeMillis();
                    break;
            }
            return;
        }
        if (ProtocolHandler.protocol.isConnected()) {
            showBaseAlert(Global.ALERT_TITLE_RID, R.string.confirm, true, R.string.display_alert_workout_progress, (DialogInterface.OnClickListener) null);
            return;
        }
        switchFragment(0);
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void initFragments() {
        int i = Global.BRAND;
        if (i == 0) {
            Sole_DeviceModelList.handleDeviceModel();
        } else if (i == 1) {
            Spirit_DeviceModelList.handleDeviceModel();
        } else if (i == 2) {
            Xterra_DeviceModelList.handleDeviceModel();
        } else if (i == 3) {
            Fuel_DeviceModelList.handleDeviceModel();
        }
        DeviceModelList.handleDeviceModel();
        this.fragments = new ArrayList();
        this.fragmentManager = getFragmentManager();
        MemberUserFragment memberUserFragment = new MemberUserFragment();
        NewUserFragment newUserFragment = new NewUserFragment();
        ProgramsMenuFragment programsMenuFragment = new ProgramsMenuFragment();
        ProgramsMainFragment programsMainFragment = new ProgramsMainFragment();
        ProfilesFragment profilesFragment = new ProfilesFragment();
        DisplayMainFragment displayMainFragment = new DisplayMainFragment();
        CalendarMainFragment calendarMainFragment = new CalendarMainFragment();
        ProgramsGoalFragment programsGoalFragment = new ProgramsGoalFragment();
        ProgramsGoalAddEditFragment programsGoalAddEditFragment = new ProgramsGoalAddEditFragment();
        ProgramsExportDBPanelFragment programsExportDBPanelFragment = new ProgramsExportDBPanelFragment();
        EditUserFragment editUserFragment = new EditUserFragment();
        EditGuestFragment editGuestFragment = new EditGuestFragment();
        memberUserFragment.setEditUserFragment(editUserFragment);
        memberUserFragment.setEditGuestFragment(editGuestFragment);
        this.fragments.add(memberUserFragment);
        this.fragments.add(newUserFragment);
        this.fragments.add(newUserFragment);
        this.fragments.add(programsMainFragment);
        this.fragments.add(profilesFragment);
        this.fragments.add(displayMainFragment);
        this.fragments.add(calendarMainFragment);
        this.fragments.add(programsMenuFragment);
        this.fragments.add(programsGoalFragment);
        this.fragments.add(programsGoalAddEditFragment);
        this.fragments.add(programsExportDBPanelFragment);
        this.fragments.add(editUserFragment);
        this.fragments.add(editGuestFragment);
        this.fragmentManager.beginTransaction().add(R.id.content_layout, memberUserFragment).add(R.id.content_layout, newUserFragment).add(R.id.content_layout, programsMainFragment).add(R.id.content_layout, profilesFragment).add(R.id.content_layout, displayMainFragment).add(R.id.content_layout, calendarMainFragment).add(R.id.content_layout, programsMenuFragment).add(R.id.content_layout, programsGoalFragment).add(R.id.content_layout, programsGoalAddEditFragment).add(R.id.content_layout, programsExportDBPanelFragment).add(R.id.content_layout, editUserFragment).add(R.id.content_layout, editGuestFragment).hide(memberUserFragment).hide(newUserFragment).hide(programsMainFragment).hide(profilesFragment).hide(displayMainFragment).hide(calendarMainFragment).hide(programsGoalFragment).hide(programsGoalAddEditFragment).hide(programsExportDBPanelFragment).hide(editUserFragment).hide(editGuestFragment).commit();
        this.nowPage = 7;
    }

    public void setBackgroundColor(int i) {
        this.background.setBackgroundColor(i);
    }

    public void saveEnd(EndWorkoutData endWorkoutData) {
        Log.e("getEndMessage", String.valueOf(SoleProtocol.notRunning));
        if (SoleProtocol.notRunning) {
            ((DisplayMainFragment) this.fragments.get(5)).isSaveEndData = false;
            ((DisplayMainFragment) this.fragments.get(5)).onEndWorkoutResult(endWorkoutData);
        }
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void findViews() {
        this.content_layout = (FrameLayout) findViewById(R.id.content_layout);
        this.menu_connect_imageview = (ImageView) findViewById(R.id.menu_connect_imageview);
        this.menu_message_imageview = (ImageView) findViewById(R.id.menu_pull_message);
        this.menu_goal_imageview = (ImageView) findViewById(R.id.menu_goal_imageview);
        this.menu_share_imageview = (ImageView) findViewById(R.id.menu_share_imageview);
        this.menu_alert_imageview = (ImageView) findViewById(R.id.menu_alert_imageview);
        this.menu_language_imageview = (ImageView) findViewById(R.id.menu_language_imageview);
        this.connect_hr_imageview = (ImageView) findViewById(R.id.connect_hr_imageview);
        this.menu_user_textview = (TypefaceTextView) findViewById(R.id.menu_user_textview);
        this.menu_programs_textview = (TypefaceTextView) findViewById(R.id.menu_programs_textview);
        this.menu_display_textview = (TypefaceTextView) findViewById(R.id.menu_display_textview);
        this.menu_calendar_textview = (TypefaceTextView) findViewById(R.id.menu_calendar_textview);
        this.link_layout = (LinearLayout) findViewById(R.id.link_layout);
        this.link_fb_imageview = (ImageView) findViewById(R.id.link_fb_imageview);
        this.link_yt_imageview = (ImageView) findViewById(R.id.link_yt_imageview);
        this.link_tt_imageview = (ImageView) findViewById(R.id.link_tt_imageview);
        this.link_music_imageview = (ImageView) findViewById(R.id.link_music_imageview);
        this.link_sfr_imageview = (ImageView) findViewById(R.id.link_sfr_imageview);
        this.link_mail_imageview = (ImageView) findViewById(R.id.link_mail_imageview);
        this.link_arrow_imageview = (ImageView) findViewById(R.id.link_arrow_imageview);
        this.selectHRDevice = (ConnectionHRDialog) findViewById(R.id.selectHRDevice);
        int i = Global.BRAND;
        if (i == 0) {
            this.background = (RelativeLayout) findViewById(R.id.background);
            this.questMainView = (QuestMainView) findViewById(R.id.questMainViewMain);
            this.errorDialog = (ErrorDialog) findViewById(R.id.errorDialogMain);
            ImageView imageView = (ImageView) findViewById(R.id.menu_service);
            this.menu_service = imageView;
            imageView.setOnClickListener(this);
            initControlView();
        } else if (i == 1 || i == 2 || i == 3) {
            this.title_layout = (LinearLayout) findViewById(R.id.s_title_layout);
            this.menu_programs_layout = (RelativeLayout) findViewById(R.id.menu_programs_layout);
            this.s_menu_user_image = (ImageView) findViewById(R.id.s_menu_user_image);
            this.s_menu_programs_image = (ImageView) findViewById(R.id.s_menu_programs_image);
            this.s_menu_display_image = (ImageView) findViewById(R.id.s_menu_display_image);
            this.s_menu_calendar_image = (ImageView) findViewById(R.id.s_menu_calendar_image);
            this.main_bottom_line = (ImageView) findViewById(R.id.main_bottom_line);
        }
        this.menuQrCode = (ImageView) findViewById(R.id.menuQrCode);
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void initParams() {
        this.res = getResources();
        int i = Global.BRAND;
        if (i == 0) {
            ((ImageView) findViewById(R.id.menu_logo_imageview)).setOnClickListener(this);
        } else if (i == 3) {
            ((ImageView) findViewById(R.id.menu_logo_imageview)).setImageResource(R.drawable.f_all_logo);
        }
        ProtocolHandler.protocol.addOnBluetoothStateListener(this);
        ProtocolHandler.protocol.addOnConnectionStateListener(this);
        ProtocolHandler.protocol.addOnDataResultListener(this);
        resetLanguageView();
        this.menu_share_imageview.setVisibility(8);
        this.menu_connect_imageview.setVisibility(8);
        this.selectHRDevice.close();
        initAnimation();
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.link_layout.getLayoutParams();
        layoutParams.setMarginStart(-((int) this.res.getDimension(R.dimen.display_link_content_margin_start)));
        this.link_layout.setLayoutParams(layoutParams);
        if (this.menuQrCode != null) {
            if (Global.userName == null || Global.userName.length() <= 0) {
                this.menuQrCode.setVisibility(8);
            }
        }
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void setListeners() {
        this.menu_connect_imageview.setOnClickListener(this);
        this.menu_message_imageview.setOnClickListener(this);
        this.menu_share_imageview.setOnClickListener(this);
        this.menu_language_imageview.setOnClickListener(this);
        try {
            this.menu_goal_imageview.setOnClickListener(this);
        } catch (Exception e) {
            Log.i(TAG, "Error : " + e.toString());
        }
        this.menu_alert_imageview.setOnClickListener(this);
        this.menu_user_textview.setOnClickListener(this.onMenuClick);
        this.menu_programs_textview.setOnClickListener(this.onMenuClick);
        this.menu_calendar_textview.setOnClickListener(this.onMenuClick);
        ImageView imageView = this.menuQrCode;
        if (imageView != null) {
            imageView.setOnClickListener(this.onMenuClick);
        }
        this.connect_hr_imageview.setOnClickListener(this);
        this.link_arrow_imageview.setOnClickListener(this);
        this.link_fb_imageview.setOnClickListener(this);
        this.link_yt_imageview.setOnClickListener(this);
        this.link_tt_imageview.setOnClickListener(this);
        this.link_music_imageview.setOnClickListener(this);
        this.link_sfr_imageview.setOnClickListener(this);
        this.link_mail_imageview.setOnClickListener(this);
    }

    public void setHRBtnVisible(int i) {
        if (i == 0 && ProtocolHandler.protocol.isConnected()) {
            this.connect_hr_imageview.setVisibility(i);
        } else {
            this.connect_hr_imageview.setVisibility(8);
        }
    }

    public void showMessageView(final String str) {
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.MainActivity.8
            @Override // java.lang.Runnable
            public void run() {
                ErrorLogSave.sendErrorList(MainActivity.this.questMainView.getAccount(), MainActivity.this.getApplicationContext());
                MainActivity.this.questMainView.showQA(QuestMainView.MAIN, str);
                MainActivity.this.questMainView.setVisibility(0);
            }
        });
    }

    public void showErrorLog(final int i, final String str) {
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.MainActivity.9
            @Override // java.lang.Runnable
            public void run() {
                Log.e("showErrorLog", "show");
                if (MainActivity.this.errorDialog.isShown()) {
                    return;
                }
                MainActivity.this.errorDialog.setVisibility(0);
                MainActivity.this.errorDialog.initView(MainActivity.this.getString(i), new View.OnClickListener() { // from class: com.dyaco.sole.activity.MainActivity.9.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MainActivity.this.showMessageView(str);
                    }
                }, new View.OnClickListener() { // from class: com.dyaco.sole.activity.MainActivity.9.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        MainActivity.this.errorDialog.setVisibility(8);
                    }
                });
            }
        });
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws PackageManager.NameNotFoundException {
        Intent intent = new Intent("android.intent.action.VIEW");
        switch (view.getId()) {
            case R.id.connect_hr_imageview /* 2131231025 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "main_hrConnect_btn", ErrorLogSave.CLICK);
                if (MyApp.isHRConnect) {
                    this.mBluetoothLeService.disconnect(true);
                    break;
                } else {
                    this.selectHRDevice.scan();
                    break;
                }
            case R.id.control_cancel_image /* 2131231054 */:
                hideControlView();
                break;
            case R.id.control_down_image /* 2131231056 */:
                if (this.controlType == 1) {
                    ((DisplayMainFragment) this.fragments.get(5)).setInclineDown();
                    break;
                } else {
                    ((DisplayMainFragment) this.fragments.get(5)).setLevelDown();
                    break;
                }
            case R.id.control_up_image /* 2131231058 */:
                if (this.controlType == 1) {
                    ((DisplayMainFragment) this.fragments.get(5)).setInclineUp();
                    break;
                } else {
                    ((DisplayMainFragment) this.fragments.get(5)).setLevelUp();
                    break;
                }
            case R.id.link_arrow_imageview /* 2131231371 */:
                transformLinkLayout();
                break;
            case R.id.link_fb_imageview /* 2131231372 */:
                PostUtil.postTrackerData(this, 20);
                try {
                    getPackageManager().getPackageInfo(RemoteServiceWrapper.RECEIVER_SERVICE_PACKAGE, 0);
                    intent.setData(Uri.parse("fb://page/"));
                } catch (Exception unused) {
                    intent.setData(Uri.parse("https://www.facebook.com/"));
                }
                startActivity(intent);
                break;
            case R.id.link_mail_imageview /* 2131231374 */:
                PostUtil.postTrackerData(this, 25);
                intent.setAction("android.intent.action.SEND");
                intent.setType(HTTP.PLAIN_TEXT_TYPE);
                startActivity(Intent.createChooser(intent, "Choose Email Client"));
                break;
            case R.id.link_music_imageview /* 2131231375 */:
                PostUtil.postTrackerData(this, 23);
                intent.setType("application/*");
                startActivity(intent);
                break;
            case R.id.link_sfr_imageview /* 2131231376 */:
                PostUtil.postTrackerData(this, 24);
                int i = Global.BRAND;
                if (i == 0) {
                    intent.setData(Uri.parse("http://www.solefitness.com.tw/"));
                } else if (i == 1) {
                    intent.setData(Uri.parse("http://www.spiritfitness.com/"));
                } else if (i == 2) {
                    intent.setData(Uri.parse("http://www.xterraplanet.com/"));
                } else if (i == 3) {
                    intent.setData(Uri.parse("http://www.fuelfitnessusa.com/"));
                }
                startActivity(intent);
                break;
            case R.id.link_tt_imageview /* 2131231377 */:
                PostUtil.postTrackerData(this, 22);
                intent.setData(Uri.parse("http://www.twitter.com/"));
                startActivity(intent);
                break;
            case R.id.link_yt_imageview /* 2131231378 */:
                PostUtil.postTrackerData(this, 21);
                intent.setData(Uri.parse("http://www.youtube.com/"));
                startActivity(intent);
                break;
            case R.id.menu_alert_imageview /* 2131231392 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "main_alert_btn", ErrorLogSave.CLICK);
                if (MyApp.alertSchedule != null) {
                    ProgramsGoalFragment.txtGoalAlert.setText("");
                    MyApp.alertSchedule = null;
                    clearAlertSchedule();
                    break;
                } else {
                    DateTime dateTimeNow = DateTime.now();
                    new TimePickerDialog(this, new TimePickerDialog.OnTimeSetListener() { // from class: com.dyaco.sole.activity.MainActivity.10
                        @Override // android.app.TimePickerDialog.OnTimeSetListener
                        public void onTimeSet(TimePicker timePicker, int i2, int i3) throws Resources.NotFoundException {
                            MutableDateTime mutableDateTime = new DateTime().toMutableDateTime();
                            mutableDateTime.setTime(i2, i3, 0, 0);
                            ProgramsGoalFragment.alarmDateTime = mutableDateTime.toDateTime();
                            LocalTime localTime = ProgramsGoalFragment.alarmDateTime.toLocalTime();
                            ProgramsGoalFragment.txtGoalAlert.setText(MainActivity.this.getResources().getString(R.string.goal_alert_title_alert_time).concat(localTime.toString("a hh:mm")));
                            MainActivity.this.alertSchedule.setTime(localTime);
                            Log.d("ddd", MainActivity.this.alertSchedule.toString());
                            MainActivity.this.alertSchedule.setWeek(Week.Monday, true);
                            MainActivity.this.alertSchedule.setWeek(Week.Tuesday, true);
                            MainActivity.this.alertSchedule.setWeek(Week.Wednesday, true);
                            MainActivity.this.alertSchedule.setWeek(Week.Thursday, true);
                            MainActivity.this.alertSchedule.setWeek(Week.Friday, true);
                            MainActivity.this.alertSchedule.setWeek(Week.Saturday, true);
                            MainActivity.this.alertSchedule.setWeek(Week.Sunday, true);
                            MyApp.alertSchedule = MainActivity.this.alertSchedule;
                            MainActivity.this.alertSchedule.generateScheduleDateTime(new DateTime(), 2);
                            List<DateTime> scheduleDateTimeList = MainActivity.this.alertSchedule.getScheduleDateTimeList();
                            Log.d("ddd", Arrays.toString(scheduleDateTimeList.toArray(new DateTime[0])));
                            for (DateTime dateTime : scheduleDateTimeList) {
                                Intent intent2 = new Intent();
                                intent2.setClass(MainActivity.this, AlarmReceiver.class);
                                intent2.addCategory(dateTime.toString("yyy-MM-dd HH:mm:ss"));
                                intent2.putExtra(NotificationCompat.CATEGORY_MESSAGE, "Sport Alarm:" + dateTime.toString("yyy-MM-dd HH:mm:ss"));
                                MainActivity.this.alarmManager.setExact(0, dateTime.getMillis(), PendingIntent.getBroadcast(MainActivity.this, 0, intent2, 134217728));
                                Log.d("ddd ccc", dateTime.toString("yyy-MM-dd HH:mm:ss"));
                            }
                            MainActivity.this.saveAlertSchedule(MainActivity.this.alertSchedule.getScheduleData());
                        }
                    }, dateTimeNow.getHourOfDay(), dateTimeNow.getMinuteOfHour(), false).show();
                    break;
                }
            case R.id.menu_connect_imageview /* 2131231394 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "main_bleConnect_btn", ErrorLogSave.CLICK);
                if (ProtocolHandler.protocol.isConnected()) {
                    ProtocolHandler.protocol.setAutoConnectedEnable(false);
                    ProtocolHandler.protocol.disconnect();
                    break;
                } else {
                    PostUtil.postTrackerData(this, 4);
                    if (this.isConnecting) {
                        ProtocolHandler.protocol.disconnect();
                    }
                    switchFragment(7);
                    goConnection();
                    break;
                }
            case R.id.menu_goal_imageview /* 2131231397 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "main_goal_btn", ErrorLogSave.CLICK);
                resetButtonState(this.menu_calendar_textview, R.drawable.all_title_a_calendar, 8);
                this.menu_alert_imageview.setVisibility(0);
                break;
            case R.id.menu_language_imageview /* 2131231398 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "main_language_btn", ErrorLogSave.CLICK);
                goLanguage();
                break;
            case R.id.menu_pull_message /* 2131231405 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "main_pullMessage_btn", ErrorLogSave.CLICK);
                showMessagePullAlertDialog();
                break;
            case R.id.menu_service /* 2131231408 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "main_menu_service_btn", "click_nowPage:" + this.nowPage);
                Log.e("checkNowPage", this.nowPage + "");
                int i2 = this.nowPage;
                if (i2 != 3 && i2 != 4) {
                    if (i2 != 5) {
                        if (i2 == 6) {
                            showMessageView(ErrorLogSave.ERROR_0010);
                            break;
                        } else {
                            showMessageView("");
                            break;
                        }
                    } else {
                        showMessageView(ErrorLogSave.ERROR_0008);
                        break;
                    }
                } else {
                    showMessageView(ErrorLogSave.ERROR_0007);
                    break;
                }
            case R.id.menu_share_imageview /* 2131231410 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "main_share_btn", ErrorLogSave.CLICK);
                ScreenshotTool.takeScreenshotFromView(this);
                break;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void saveAlertSchedule(ScheduleData scheduleData) {
        SharedPreferences sharedPreferences = getSharedPreferences("alert_schedule", 0);
        sharedPreferences.edit().putString("schedule.jsonStr", new GsonBuilder().setDateFormat(CalendarUtils.SQL_DATE_TIME_FORMAT).create().toJson(scheduleData)).apply();
    }

    private void clearAlertSchedule() {
        getSharedPreferences("alert_schedule", 0).edit().remove("schedule.jsonStr").apply();
    }

    private void showMessagePullAlertDialog() {
        this.isWantShowMessagePullAlertDialog = false;
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.MainActivity.11
            @Override // java.lang.Runnable
            public void run() {
                if (MainActivity.this.messageListAlertDialog != null) {
                    MainActivity.this.messageListAlertDialog.dismiss();
                }
                MainActivity mainActivity = MainActivity.this;
                mainActivity.messageListAlertDialog = MessageListAlertDialog.createMessageDialog(mainActivity);
                MainActivity.this.messageListAlertDialog.setDialogListener(new MessageListAlertDialog.DialogListener() { // from class: com.dyaco.sole.activity.MainActivity.11.1
                    @Override // com.dyaco.sole.custom_view.MessageListAlertDialog.DialogListener
                    public void OnDismiss() {
                        MainActivity.this.updatePullMessages();
                    }
                });
                MainActivity.this.messageListAlertDialog.showAlertDialog();
                Global.noticeMessage_no = "";
            }
        });
    }

    private void initControlView() {
        this.control_view = findViewById(R.id.control_view);
        this.control_cancel_image = (ImageView) findViewById(R.id.control_cancel_image);
        this.control_up_image = (ImageView) findViewById(R.id.control_up_image);
        this.control_down_image = (ImageView) findViewById(R.id.control_down_image);
        this.control_title_textview = (TypefaceTextView) findViewById(R.id.control_title_textview);
        this.control_content_textview = (TypefaceTextView) findViewById(R.id.control_content_textview);
        this.control_title_textview.setTypeface(this, Global.fontsPath[1], 2);
        this.control_content_textview.setTypeface(this, Global.fontsPath[0]);
        this.control_cancel_image.setOnClickListener(this);
        this.control_up_image.setOnClickListener(this);
        this.control_down_image.setOnClickListener(this);
    }

    public void showControlView(int i, int i2, int i3, float f) {
        if (Global.BRAND == 0) {
            if (i != -1) {
                this.controlType = i;
                this.control_view.setVisibility(0);
            }
            int i4 = this.controlType;
            if (i4 == 0) {
                this.control_title_textview.setText(R.string.level);
                this.control_content_textview.setText(String.valueOf(i2));
            } else if (i4 == 1) {
                this.control_title_textview.setText(R.string.display_incline);
                this.control_content_textview.setText(String.valueOf(i3));
            } else {
                if (i4 != 2) {
                    return;
                }
                this.control_title_textview.setText(R.string.speed);
                this.control_content_textview.setText(String.valueOf(f));
            }
        }
    }

    public void hideControlView() {
        this.control_view.setVisibility(8);
    }

    private void initAnimation() {
        this.linkLayoutIsShowing = false;
    }

    public boolean getLinkViewIsShowing() {
        return this.linkLayoutIsShowing;
    }

    private void transformLinkLayout() {
        if (this.linkLayoutIsShowing) {
            int dimension = (int) this.res.getDimension(R.dimen.display_link_content_margin_start);
            RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.link_layout.getLayoutParams();
            layoutParams.leftMargin = -dimension;
            this.link_layout.setLayoutParams(layoutParams);
            int i = Global.BRAND;
            if (i == 0) {
                this.link_arrow_imageview.setImageResource(R.drawable.display_arrow_a_0);
            } else if (i == 1 || i == 2 || i == 3) {
                this.link_arrow_imageview.setImageResource(R.drawable.s_display_arrow_a_0);
            }
        } else {
            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.link_layout.getLayoutParams();
            layoutParams2.leftMargin = 0;
            this.link_layout.setLayoutParams(layoutParams2);
            int i2 = Global.BRAND;
            if (i2 == 0) {
                this.link_arrow_imageview.setImageResource(R.drawable.display_arrow_a_1);
            } else if (i2 == 1 || i2 == 2 || i2 == 3) {
                this.link_arrow_imageview.setImageResource(R.drawable.s_display_arrow_a_1);
            }
        }
        this.linkLayoutIsShowing = !this.linkLayoutIsShowing;
    }

    private void hideLinkLayout() {
        int dimension = (int) this.res.getDimension(R.dimen.display_link_content_margin_start);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.link_layout.getLayoutParams();
        layoutParams.leftMargin = -dimension;
        this.link_layout.setLayoutParams(layoutParams);
        int i = Global.BRAND;
        if (i == 0) {
            this.link_arrow_imageview.setImageResource(R.drawable.display_arrow_a_0);
        } else if (i == 1 || i == 2 || i == 3) {
            this.link_arrow_imageview.setImageResource(R.drawable.s_display_arrow_a_0);
        }
        this.linkLayoutIsShowing = false;
        this.link_layout.setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resetButtonState(TextView textView, int i, int i2) {
        int i3 = Global.BRAND;
        if (i3 == 0) {
            this.menu_user_textview.setBackgroundResource(R.drawable.all_title_a_line1);
            this.menu_programs_textview.setBackgroundResource(R.drawable.all_title_a_line2);
            this.menu_display_textview.setBackgroundResource(R.drawable.all_title_a_line3);
            this.menu_calendar_textview.setBackgroundResource(0);
            textView.setBackgroundResource(i);
        } else if (i3 == 1 || i3 == 2 || i3 == 3) {
            this.s_menu_user_image.setVisibility(8);
            this.s_menu_programs_image.setVisibility(8);
            this.s_menu_display_image.setVisibility(8);
            this.s_menu_calendar_image.setVisibility(8);
            switch (i) {
                case R.drawable.all_title_a_calendar /* 2131165295 */:
                    this.s_menu_calendar_image.setVisibility(0);
                    break;
                case R.drawable.all_title_a_display /* 2131165296 */:
                    this.s_menu_display_image.setVisibility(0);
                    break;
                case R.drawable.all_title_a_program /* 2131165302 */:
                    this.s_menu_programs_image.setVisibility(0);
                    break;
                case R.drawable.all_title_a_user /* 2131165303 */:
                    this.s_menu_user_image.setVisibility(0);
                    break;
            }
        }
        Logger.d("fragmentId = " + i2);
        if (i2 != -1) {
            switchFragment(i2);
        }
    }

    public int getLastPage() {
        return this.lastPage;
    }

    public int getNowPage() {
        return this.nowPage;
    }

    public List<BaseFragment> getFragments() {
        return this.fragments;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x023c  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x01e7 A[Catch: all -> 0x025e, TryCatch #1 {, blocks: (B:9:0x0010, B:17:0x003d, B:19:0x0087, B:21:0x0095, B:22:0x00a0, B:35:0x00bf, B:36:0x00c2, B:80:0x01e3, B:82:0x01e7, B:84:0x01eb, B:85:0x01f6, B:87:0x01fa, B:89:0x01fe, B:90:0x020c, B:92:0x0210, B:94:0x0214, B:96:0x0221, B:97:0x022a, B:98:0x0234, B:102:0x0240, B:104:0x024f, B:103:0x0244, B:105:0x0252, B:106:0x025b, B:38:0x00c7, B:39:0x00db, B:42:0x00e1, B:43:0x00e6, B:46:0x00f1, B:47:0x00f6, B:48:0x00fd, B:53:0x0109, B:52:0x0104, B:54:0x013f, B:57:0x0145, B:58:0x014e, B:60:0x0165, B:62:0x0173, B:63:0x0178, B:68:0x0184, B:67:0x017f, B:70:0x01b4, B:71:0x01bd, B:77:0x01d5, B:78:0x01db, B:15:0x0032, B:16:0x0038, B:8:0x000d), top: B:116:0x000d, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:87:0x01fa A[Catch: all -> 0x025e, TryCatch #1 {, blocks: (B:9:0x0010, B:17:0x003d, B:19:0x0087, B:21:0x0095, B:22:0x00a0, B:35:0x00bf, B:36:0x00c2, B:80:0x01e3, B:82:0x01e7, B:84:0x01eb, B:85:0x01f6, B:87:0x01fa, B:89:0x01fe, B:90:0x020c, B:92:0x0210, B:94:0x0214, B:96:0x0221, B:97:0x022a, B:98:0x0234, B:102:0x0240, B:104:0x024f, B:103:0x0244, B:105:0x0252, B:106:0x025b, B:38:0x00c7, B:39:0x00db, B:42:0x00e1, B:43:0x00e6, B:46:0x00f1, B:47:0x00f6, B:48:0x00fd, B:53:0x0109, B:52:0x0104, B:54:0x013f, B:57:0x0145, B:58:0x014e, B:60:0x0165, B:62:0x0173, B:63:0x0178, B:68:0x0184, B:67:0x017f, B:70:0x01b4, B:71:0x01bd, B:77:0x01d5, B:78:0x01db, B:15:0x0032, B:16:0x0038, B:8:0x000d), top: B:116:0x000d, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:92:0x0210 A[Catch: all -> 0x025e, TryCatch #1 {, blocks: (B:9:0x0010, B:17:0x003d, B:19:0x0087, B:21:0x0095, B:22:0x00a0, B:35:0x00bf, B:36:0x00c2, B:80:0x01e3, B:82:0x01e7, B:84:0x01eb, B:85:0x01f6, B:87:0x01fa, B:89:0x01fe, B:90:0x020c, B:92:0x0210, B:94:0x0214, B:96:0x0221, B:97:0x022a, B:98:0x0234, B:102:0x0240, B:104:0x024f, B:103:0x0244, B:105:0x0252, B:106:0x025b, B:38:0x00c7, B:39:0x00db, B:42:0x00e1, B:43:0x00e6, B:46:0x00f1, B:47:0x00f6, B:48:0x00fd, B:53:0x0109, B:52:0x0104, B:54:0x013f, B:57:0x0145, B:58:0x014e, B:60:0x0165, B:62:0x0173, B:63:0x0178, B:68:0x0184, B:67:0x017f, B:70:0x01b4, B:71:0x01bd, B:77:0x01d5, B:78:0x01db, B:15:0x0032, B:16:0x0038, B:8:0x000d), top: B:116:0x000d, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x0221 A[Catch: all -> 0x025e, TryCatch #1 {, blocks: (B:9:0x0010, B:17:0x003d, B:19:0x0087, B:21:0x0095, B:22:0x00a0, B:35:0x00bf, B:36:0x00c2, B:80:0x01e3, B:82:0x01e7, B:84:0x01eb, B:85:0x01f6, B:87:0x01fa, B:89:0x01fe, B:90:0x020c, B:92:0x0210, B:94:0x0214, B:96:0x0221, B:97:0x022a, B:98:0x0234, B:102:0x0240, B:104:0x024f, B:103:0x0244, B:105:0x0252, B:106:0x025b, B:38:0x00c7, B:39:0x00db, B:42:0x00e1, B:43:0x00e6, B:46:0x00f1, B:47:0x00f6, B:48:0x00fd, B:53:0x0109, B:52:0x0104, B:54:0x013f, B:57:0x0145, B:58:0x014e, B:60:0x0165, B:62:0x0173, B:63:0x0178, B:68:0x0184, B:67:0x017f, B:70:0x01b4, B:71:0x01bd, B:77:0x01d5, B:78:0x01db, B:15:0x0032, B:16:0x0038, B:8:0x000d), top: B:116:0x000d, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public synchronized void switchFragment(int i) {
        BaseFragment baseFragment;
        int i2 = i;
        synchronized (this) {
            synchronized (this) {
                if (i2 == 3 || i2 == 5) {
                    setHRBtnVisible(0);
                }
                Logger.d("toFragmentLocation = " + i2);
                int i3 = Global.BRAND;
                if (i3 == 0) {
                    setBackgroundColor(ViewCompat.MEASURED_STATE_MASK);
                } else if (i3 == 1 || i3 == 2 || i3 == 3) {
                    this.main_bottom_line.setVisibility(0);
                }
                this.menu_language_imageview.setVisibility(0);
                this.menu_share_imageview.setVisibility(8);
                this.menu_connect_imageview.setVisibility(0);
                this.menu_goal_imageview.setVisibility(8);
                this.menu_alert_imageview.setVisibility(8);
                this.lastPage = this.nowPage;
                this.nowPage = i2;
                this.menu_display_textview.setTextColor(this.res.getColor(R.color.light_gray));
                this.menu_calendar_textview.setTextColor(this.res.getColor(R.color.light_gray));
                if (!Global.calendarUserName.equals("") && !Global.calendarUserName.equals(this.res.getString(R.string.guest))) {
                    this.menu_calendar_textview.setTextColor(this.res.getColor(R.color.white));
                }
                int i4 = this.nowPage;
                if (i4 == 0) {
                    resetButtonState(this.menu_user_textview, R.drawable.all_title_a_user, -1);
                    this.menu_connect_imageview.setVisibility(8);
                    int i5 = Global.BRAND;
                    if (i5 == 0) {
                        setBackgroundColor(Color.rgb(R2.attr.divider, R2.attr.divider, R2.attr.divider));
                    } else if (i5 == 1 || i5 == 2 || i5 == 3) {
                        this.main_bottom_line.setVisibility(0);
                    }
                } else if (i4 == 3) {
                    resetButtonState(this.menu_programs_textview, R.drawable.all_title_a_program, -1);
                } else if (i4 != 49) {
                    if (i4 != 97 && i4 != 99) {
                        if (i4 == 11 || i4 == 12) {
                            if (Global.BRAND == 0) {
                                setBackgroundColor(Color.rgb(R2.attr.divider, R2.attr.divider, R2.attr.divider));
                            }
                        } else {
                            switch (i4) {
                                case 5:
                                    int i6 = Global.BRAND;
                                    if (i6 == 2 || i6 == 3) {
                                        this.main_bottom_line.setVisibility(8);
                                    }
                                    resetButtonState(this.menu_display_textview, R.drawable.all_title_a_display, -1);
                                    this.link_layout.setVisibility(0);
                                    this.menu_language_imageview.setVisibility(4);
                                    this.nowPage = 5;
                                    baseFragment = this.fragments.get(5);
                                    DisplayMainFragment displayMainFragment = (DisplayMainFragment) baseFragment;
                                    displayMainFragment.showInfoDialog();
                                    displayMainFragment.switchView(81);
                                    this.menu_display_textview.setTextColor(this.res.getColor(R.color.white));
                                    i2 = 5;
                                    break;
                                case 6:
                                    break;
                                case 7:
                                    ProtocolHandler.protocol.resetCalDis();
                                    break;
                                case 8:
                                    this.menu_alert_imageview.setVisibility(0);
                                    if (Global.BRAND != 0) {
                                        break;
                                    } else {
                                        setBackgroundColor(-1);
                                        break;
                                    }
                                case 9:
                                    if (Global.BRAND != 0) {
                                        break;
                                    } else {
                                        setBackgroundColor(-1);
                                        break;
                                    }
                                default:
                                    switch (i4) {
                                        case 65:
                                        case 66:
                                        case 67:
                                        case 68:
                                        case 69:
                                        case 70:
                                        case 71:
                                        case 72:
                                        case 73:
                                        case 74:
                                        case 75:
                                        case 76:
                                            this.nowPage = 4;
                                            baseFragment = this.fragments.get(4);
                                            ((ProfilesFragment) baseFragment).switchFragment(i4);
                                            i2 = 4;
                                            break;
                                    }
                            }
                            if (this.lastPage == 4 && this.nowPage != 4) {
                                ((ProfilesFragment) this.fragments.get(4)).hideFragment();
                            }
                            if (this.lastPage == 5 && this.nowPage != 5) {
                                ((DisplayMainFragment) this.fragments.get(5)).hideFragment();
                                hideLinkLayout();
                            }
                            if (this.lastPage == 6 && this.nowPage != 6) {
                                ((CalendarMainFragment) this.fragments.get(6)).hideFragment();
                            }
                            if (baseFragment == null) {
                                baseFragment = this.fragments.get(i2);
                            }
                            FragmentManager fragmentManager = getFragmentManager();
                            this.fragmentManager = fragmentManager;
                            FragmentTransaction fragmentTransactionBeginTransaction = fragmentManager.beginTransaction();
                            for (int i7 = 0; i7 < this.fragments.size(); i7++) {
                                if (i7 == i2 && baseFragment != null) {
                                    fragmentTransactionBeginTransaction.show(baseFragment);
                                } else {
                                    fragmentTransactionBeginTransaction.hide(this.fragments.get(i7));
                                }
                            }
                            fragmentTransactionBeginTransaction.setTransition(4097).commit();
                        }
                    }
                    resetButtonState(this.menu_calendar_textview, R.drawable.all_title_a_calendar, -1);
                    this.menu_connect_imageview.setVisibility(8);
                    if (!Global.calendarUserName.equals("") && !Global.calendarUserName.equals(this.res.getString(R.string.guest))) {
                        this.menu_goal_imageview.setVisibility(0);
                    }
                    int i8 = Global.BRAND;
                    if (i8 == 2 || i8 == 3) {
                        this.main_bottom_line.setVisibility(8);
                    }
                    this.menu_share_imageview.setVisibility(0);
                    int i9 = this.nowPage;
                    this.nowPage = 6;
                    baseFragment = this.fragments.get(6);
                    Logger.d("calendarPosition = " + i9);
                    ((CalendarMainFragment) baseFragment).switchFragment(i9);
                    i2 = 6;
                    if (this.lastPage == 4) {
                        ((ProfilesFragment) this.fragments.get(4)).hideFragment();
                    }
                    if (this.lastPage == 5) {
                        ((DisplayMainFragment) this.fragments.get(5)).hideFragment();
                        hideLinkLayout();
                    }
                    if (this.lastPage == 6) {
                        ((CalendarMainFragment) this.fragments.get(6)).hideFragment();
                    }
                    if (baseFragment == null) {
                    }
                    FragmentManager fragmentManager2 = getFragmentManager();
                    this.fragmentManager = fragmentManager2;
                    FragmentTransaction fragmentTransactionBeginTransaction2 = fragmentManager2.beginTransaction();
                    while (i7 < this.fragments.size()) {
                    }
                    fragmentTransactionBeginTransaction2.setTransition(4097).commit();
                } else {
                    i2 = 1;
                }
                baseFragment = null;
                if (this.lastPage == 4) {
                }
                if (this.lastPage == 5) {
                }
                if (this.lastPage == 6) {
                }
                if (baseFragment == null) {
                }
                FragmentManager fragmentManager22 = getFragmentManager();
                this.fragmentManager = fragmentManager22;
                FragmentTransaction fragmentTransactionBeginTransaction22 = fragmentManager22.beginTransaction();
                while (i7 < this.fragments.size()) {
                }
                fragmentTransactionBeginTransaction22.setTransition(4097).commit();
            }
        }
    }

    private void resetLanguageView() {
        String string = Global.getSharedPreferences(this).getString(QuestMainView.LANGUAGE, "");
        int i = Global.BRAND;
        if (i == 0) {
            if (string.equals(Locale.ENGLISH.toString())) {
                this.menu_language_imageview.setImageResource(R.drawable.all_btn_a_en);
                return;
            }
            if (string.equals(Locale.FRANCE.toString())) {
                this.menu_language_imageview.setImageResource(R.drawable.all_btn_a_fr);
                return;
            }
            if (string.equals(Locale.TAIWAN.toString())) {
                this.menu_language_imageview.setImageResource(R.drawable.all_btn_a_zh_hant);
                return;
            }
            if (string.equals(Locale.CHINA.toString())) {
                this.menu_language_imageview.setImageResource(R.drawable.all_btn_a_zh_hans);
                return;
            }
            if (string.equals(Global.DE.toString())) {
                this.menu_language_imageview.setImageResource(R.drawable.all_btn_a_de);
                return;
            } else if (string.equals(Global.ES.toString())) {
                this.menu_language_imageview.setImageResource(R.drawable.all_btn_a_es);
                return;
            } else {
                if (string.equals(Global.RU.toString())) {
                    this.menu_language_imageview.setImageResource(R.drawable.all_btn_a_ru);
                    return;
                }
                return;
            }
        }
        if (i == 1 || i == 2 || i == 3) {
            if (string.equals(Locale.ENGLISH.toString())) {
                this.menu_language_imageview.setImageResource(R.drawable.s_all_btn_a_en);
                return;
            }
            if (string.equals(Locale.FRANCE.toString())) {
                this.menu_language_imageview.setImageResource(R.drawable.s_all_btn_a_fr);
                return;
            }
            if (string.equals(Locale.TAIWAN.toString())) {
                this.menu_language_imageview.setImageResource(R.drawable.s_all_btn_a_zh_hant);
                return;
            }
            if (string.equals(Locale.CHINA.toString())) {
                this.menu_language_imageview.setImageResource(R.drawable.s_all_btn_a_zh_hans);
                return;
            }
            if (string.equals(Global.DE.toString())) {
                this.menu_language_imageview.setImageResource(R.drawable.s_all_btn_a_de);
            } else if (string.equals(Global.ES.toString())) {
                this.menu_language_imageview.setImageResource(R.drawable.s_all_btn_a_es);
            } else if (string.equals(Global.RU.toString())) {
                this.menu_language_imageview.setImageResource(R.drawable.s_all_btn_a_ru);
            }
        }
    }

    public void showBottomRedLine() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.content_layout.getLayoutParams();
        layoutParams.bottomMargin = (int) this.res.getDimension(R.dimen.s_main_content_margin_bottom);
        this.content_layout.setLayoutParams(layoutParams);
    }

    public void hideBottomRedLine() {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.content_layout.getLayoutParams();
        layoutParams.bottomMargin = 0;
        this.content_layout.setLayoutParams(layoutParams);
    }

    private void resetConnectView(boolean z) {
        int i = Global.BRAND;
        if (i == 0) {
            if (z) {
                this.menu_connect_imageview.setImageResource(R.drawable.all_icon_a_ble_1_sole_plus);
                return;
            }
            if (!MyApp.isHRConnect) {
                this.selectHRDevice.close();
            }
            this.menu_connect_imageview.setImageResource(R.drawable.all_icon_a_ble_0_sole_plus);
            return;
        }
        if (i == 1) {
            if (z) {
                this.menu_connect_imageview.setImageResource(R.drawable.all_icon_a_ble_1_other);
                return;
            } else {
                this.menu_connect_imageview.setImageResource(R.drawable.all_icon_a_ble_0_other);
                return;
            }
        }
        if (i == 2 || i == 3) {
            if (z) {
                this.menu_connect_imageview.setImageResource(R.drawable.all_icon_a_ble_1_other);
            } else {
                this.menu_connect_imageview.setImageResource(R.drawable.all_icon_a_ble_0_other);
            }
            if (z) {
                int i2 = ProtocolHandler.protocol.salesVersion;
            } else {
                this.menu_programs_layout.setVisibility(0);
                this.title_layout.setBackgroundResource(R.drawable.x_all_title_a_bg);
            }
        }
    }

    public void showCameraDialog() {
        new AlertDialog.Builder(this, R.style.myDialog).setSingleChoiceItems(new String[]{"Camera", "Album"}, -1, new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.activity.MainActivity.12
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("description", "Image capture by camera");
                    contentValues.put("mime_type", "image/jpeg");
                    MainActivity mainActivity = MainActivity.this;
                    mainActivity.imageUri = mainActivity.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", MainActivity.this.imageUri);
                    intent.putExtra("android.intent.extra.videoQuality", 1);
                    MainActivity.this.startActivityForResult(intent, 66);
                } else {
                    Intent intent2 = new Intent();
                    intent2.setType("image/*");
                    intent2.setAction("android.intent.action.PICK");
                    MainActivity.this.startActivityForResult(Intent.createChooser(intent2, "Choose Image File"), 67);
                }
                dialogInterface.dismiss();
            }
        }).show();
    }

    private Handler getBackgroundHandler() {
        if (this.backgroundHandler == null) {
            HandlerThread handlerThread = new HandlerThread("catwindow", 10);
            handlerThread.start();
            this.backgroundHandler = new Handler(handlerThread.getLooper());
        }
        return this.backgroundHandler;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onScreenshotTaskOver() {
        oneScreenshot.set(0);
    }

    private synchronized void onScreenshotTaskBegan() {
        oneScreenshot.set(1);
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) throws IOException {
        super.onActivityResult(i, i2, intent);
        String str = TAG;
        Log.d(str, "onActivityResult--------" + i);
        Log.d(str, "resultCode--------" + i2);
        if (i == 291) {
            if (i2 != -1) {
                return;
            }
            SystemClock.sleep(1000L);
            onScreenshotTaskBegan();
            final MediaProjection mediaProjection = ((MediaProjectionManager) getSystemService("media_projection")).getMediaProjection(i2, intent);
            final DisplayMetrics displayMetrics = new DisplayMetrics();
            getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            ImageReader imageReaderNewInstance = ImageReader.newInstance(displayMetrics.widthPixels, displayMetrics.heightPixels, 1, 2);
            final VirtualDisplay virtualDisplayCreateVirtualDisplay = mediaProjection.createVirtualDisplay("share_screenshot", displayMetrics.widthPixels, displayMetrics.heightPixels, 160, 2, imageReaderNewInstance.getSurface(), null, null);
            imageReaderNewInstance.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: com.dyaco.sole.activity.MainActivity.13
                /* JADX WARN: Removed duplicated region for block: B:21:0x007c A[PHI: r1
                  0x007c: PHI (r1v7 android.hardware.display.VirtualDisplay) = (r1v6 android.hardware.display.VirtualDisplay), (r1v9 android.hardware.display.VirtualDisplay) binds: [B:33:0x00a1, B:20:0x007a] A[DONT_GENERATE, DONT_INLINE]] */
                /* JADX WARN: Removed duplicated region for block: B:38:0x00a8  */
                /* JADX WARN: Removed duplicated region for block: B:40:0x00ad  */
                /* JADX WARN: Removed duplicated region for block: B:43:0x00b4  */
                @Override // android.media.ImageReader.OnImageAvailableListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onImageAvailable(ImageReader imageReader) throws Throwable {
                    Image imageAcquireLatestImage;
                    VirtualDisplay virtualDisplay;
                    VirtualDisplay virtualDisplay2;
                    try {
                        imageAcquireLatestImage = imageReader.acquireLatestImage();
                        if (imageAcquireLatestImage != null) {
                            try {
                                try {
                                    Image.Plane[] planes = imageAcquireLatestImage.getPlanes();
                                    if (planes.length > 0) {
                                        ByteBuffer buffer = planes[0].getBuffer();
                                        int pixelStride = planes[0].getPixelStride();
                                        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(displayMetrics.widthPixels + ((planes[0].getRowStride() - (displayMetrics.widthPixels * pixelStride)) / pixelStride), displayMetrics.heightPixels, Bitmap.Config.ARGB_8888);
                                        bitmapCreateBitmap.copyPixelsFromBuffer(buffer);
                                        Bitmap bitmapCreateBitmap2 = Bitmap.createBitmap(bitmapCreateBitmap, 0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels);
                                        FileOutputStream fileOutputStream = new FileOutputStream(Global.screenshotFile);
                                        bitmapCreateBitmap2.compress(Bitmap.CompressFormat.JPEG, 100, fileOutputStream);
                                        fileOutputStream.flush();
                                        fileOutputStream.close();
                                        MainActivity mainActivity = MainActivity.this;
                                        mainActivity.goShare(mainActivity.nowPage);
                                        if (bitmapCreateBitmap2 != null) {
                                            bitmapCreateBitmap2.recycle();
                                        }
                                        if (bitmapCreateBitmap != null) {
                                            bitmapCreateBitmap.recycle();
                                        }
                                    }
                                } catch (Exception e) {
                                    e = e;
                                    e.printStackTrace();
                                    if (imageAcquireLatestImage != null) {
                                        imageAcquireLatestImage.close();
                                    }
                                    if (imageReader != null) {
                                        imageReader.close();
                                    }
                                    virtualDisplay2 = virtualDisplayCreateVirtualDisplay;
                                    if (virtualDisplay2 != null) {
                                    }
                                    imageReader.setOnImageAvailableListener(null, null);
                                    mediaProjection.stop();
                                    MainActivity.this.onScreenshotTaskOver();
                                }
                            } catch (Throwable th) {
                                th = th;
                                if (imageAcquireLatestImage != null) {
                                    imageAcquireLatestImage.close();
                                }
                                if (imageReader != null) {
                                    imageReader.close();
                                }
                                virtualDisplay = virtualDisplayCreateVirtualDisplay;
                                if (virtualDisplay != null) {
                                    virtualDisplay.release();
                                }
                                imageReader.setOnImageAvailableListener(null, null);
                                mediaProjection.stop();
                                MainActivity.this.onScreenshotTaskOver();
                                throw th;
                            }
                        }
                        if (imageAcquireLatestImage != null) {
                            imageAcquireLatestImage.close();
                        }
                        if (imageReader != null) {
                            imageReader.close();
                        }
                        virtualDisplay2 = virtualDisplayCreateVirtualDisplay;
                    } catch (Exception e2) {
                        e = e2;
                        imageAcquireLatestImage = null;
                    } catch (Throwable th2) {
                        th = th2;
                        imageAcquireLatestImage = null;
                        if (imageAcquireLatestImage != null) {
                        }
                        if (imageReader != null) {
                        }
                        virtualDisplay = virtualDisplayCreateVirtualDisplay;
                        if (virtualDisplay != null) {
                        }
                        imageReader.setOnImageAvailableListener(null, null);
                        mediaProjection.stop();
                        MainActivity.this.onScreenshotTaskOver();
                        throw th;
                    }
                    if (virtualDisplay2 != null) {
                        virtualDisplay2.release();
                    }
                    imageReader.setOnImageAvailableListener(null, null);
                    mediaProjection.stop();
                    MainActivity.this.onScreenshotTaskOver();
                }
            }, getBackgroundHandler());
            return;
        }
        IntentResult activityResult = IntentIntegrator.parseActivityResult(i, i2, intent);
        if (activityResult != null) {
            final String contents = activityResult.getContents();
            String formatName = activityResult.getFormatName();
            if (this.isQrCodePairingConsoleAccount && contents != null) {
                showBaseAlert(R.string.confirm, true, getString(R.string.sync_confirm_sync) + StringUtils.LF + contents, new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.activity.MainActivity.14
                    @Override // android.content.DialogInterface.OnClickListener
                    public void onClick(DialogInterface dialogInterface, int i3) {
                        MainActivity.this.callSyncAddSynceDevice(contents);
                    }
                });
            }
            try {
                if (this.isSaveQrCodeFitData && contents != null) {
                    saveQrCodeFitData(contents);
                }
            } catch (Exception unused) {
                showBaseAlert(Global.ALERT_TITLE_RID, R.string.confirm, true, "Receive fitness data failed.", (DialogInterface.OnClickListener) null);
            }
            String str2 = TAG;
            Log.d(str2, "scanContent:" + contents);
            Log.d(str2, "scanFormat:" + formatName);
        } else {
            Log.d(str, "scanContent:Nothing.");
        }
        if (i == 10000 || i == 9527) {
            return;
        }
        if (i == 99) {
            resetConnectView(i2 == -1);
            if (i2 == -1) {
                int i3 = Global.BRAND;
                if (i3 == 0 || i3 == 1) {
                    switchFragment(3);
                } else if (i3 == 2 || i3 == 3) {
                    if (ProtocolHandler.protocol.salesVersion == 1) {
                        startWorkout();
                        switchFragment(5);
                    } else {
                        switchFragment(3);
                    }
                }
                boolean zEquals = Global.memberData.getSex().equals("M");
                int iCountAge = (Global.calendarUserName.equals("") || Global.calendarUserName.equals(this.res.getString(R.string.guest))) ? 35 : DateUtil.countAge(Global.memberData.getBirthday());
                float memberWeightByDeviceUnit = getMemberWeightByDeviceUnit();
                float memberHeightByDeviceUnit = getMemberHeightByDeviceUnit();
                ProtocolHandler.protocol.setGender = zEquals ? 1 : 0;
                ProtocolHandler.protocol.setAge = iCountAge;
                ProtocolHandler.protocol.setWeight = (int) memberWeightByDeviceUnit;
                ProtocolHandler.protocol.setHeight = (int) memberHeightByDeviceUnit;
                return;
            }
            return;
        }
        if (i == 999) {
            if (i2 == -1) {
                resetLanguageView();
                uploadMemberChangeLangCode();
                restart();
                return;
            }
            return;
        }
        if (i == 500) {
            if (i2 == -1) {
                resetButtonState(this.menu_programs_textview, R.drawable.all_title_a_program, -1);
                switchFragment(7);
                return;
            }
            return;
        }
        if (i == 101 || i == 102) {
            ((DisplayMainFragment) this.fragments.get(5)).onRecordResult(i, intent);
            return;
        }
        if (i == 66 || i == 67) {
            final Uri data = i == 66 ? this.imageUri : null;
            if (i == 67 && intent != null) {
                Log.d(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
                data = intent.getData();
            }
            if (data != null) {
                Log.d(TAG, "uri:" + data.getPath());
                runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.MainActivity.15
                    @Override // java.lang.Runnable
                    public void run() throws IOException {
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(MainActivity.this.getContentResolver(), data);
                            File file = new File(MainActivity.this.getExternalCacheDir(), System.currentTimeMillis() + ".jpg");
                            try {
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                                MainActivity.this.questMainView.upLoadImg(new File(file.getPath()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        } catch (Exception e2) {
                            Log.e("uploadImg", "bitmapEr : " + e2.toString());
                        }
                    }
                });
            }
        }
    }

    private void saveQrCodeFitData(String str) throws NumberFormatException {
        if (str.indexOf("736f6c65545439") >= 0) {
            int i = Integer.parseInt(str.substring(16, 18), 16);
            float f = (float) (Integer.parseInt(str.substring(25, 30), 16) * 0.01d * (i == 0 ? 1.0d : 1.61d));
            float f2 = Integer.parseInt(str.substring(30, 34), 16);
            int i2 = (int) (Integer.parseInt(str.substring(34, 38), 16) * 0.01d);
            float f3 = (float) (Integer.parseInt(str.substring(43, 47), 16) * 0.01d * (i == 0 ? 1.0d : 1.61d));
            int i3 = Integer.parseInt(str.substring(20, 25), 16);
            long millis = new DateTime().getMillis();
            String progromName = getProgromName(Integer.parseInt(str.substring(18, 20), 16));
            EndWorkoutData endWorkoutData = new EndWorkoutData();
            endWorkoutData.setDistance(f);
            endWorkoutData.setCalories(f2);
            endWorkoutData.setHeartRate(i2);
            endWorkoutData.setSpeed(f3);
            endWorkoutData.setIncline((int) (Integer.parseInt(str.substring(61, 65), 16) * 0.01d));
            endWorkoutData.setSeconds(i3);
            endWorkoutData.setRpm((int) (Integer.parseInt(str.substring(38, 43), 16) * 0.01d));
            endWorkoutData.setWatt((int) (Integer.parseInt(str.substring(47, 52), 16) * 0.01d));
            endWorkoutData.setMets((float) (Integer.parseInt(str.substring(52, 57), 16) * 0.01d));
            endWorkoutData.setLevel((int) (Integer.parseInt(str.substring(57, 61), 16) * 0.01d));
            DCTrainingDataDao dCTrainingDataDao = DbManager.getDCTrainingDataDao();
            Calendar calendar = Calendar.getInstance();
            calendar.setTimeInMillis(millis);
            List<DCTrainingData> list = dCTrainingDataDao.queryBuilder().where(DCTrainingDataDao.Properties.Training_datetime.eq(calendar.getTime()), new WhereCondition[0]).list();
            String str2 = TAG;
            Log.d(str2, "count==>" + list.size());
            if (list.size() == 0) {
                dCTrainingDataDao.insert(saveQRCodeDCTrainingData(endWorkoutData, calendar, progromName, str));
                showBaseAlert(Global.ALERT_TITLE_RID, R.string.confirm, true, "Receive fitness data success and save to your calendar database.", (DialogInterface.OnClickListener) null);
                Log.d(str2, "Insert");
            } else {
                showBaseAlert(Global.ALERT_TITLE_RID, R.string.confirm, true, "Receive fitness data failed. ", (DialogInterface.OnClickListener) null);
                Log.d(str2, "Double");
            }
            Log.d(str2, "============================================================================");
        }
    }

    public static DCTrainingData saveAsDCTrainingData(EndWorkoutData endWorkoutData, Calendar calendar, String str) {
        Calendar calendar2 = Calendar.getInstance();
        int i = ((calendar2.get(15) / 1000) / 60) / 60;
        DCTrainingData dCTrainingData = new DCTrainingData();
        int accout_noFromDB = getAccout_noFromDB();
        dCTrainingData.setAccount(Global.userName);
        dCTrainingData.setAccount_no(accout_noFromDB);
        dCTrainingData.setTraining_datetime(calendar.getTime());
        dCTrainingData.setTraining_timezone_hour(i);
        dCTrainingData.setTraining_timezone_name(calendar2.getTimeZone().getID());
        dCTrainingData.setBrand_code("garmin");
        dCTrainingData.setIn_out(ExifInterface.GPS_MEASUREMENT_2D);
        dCTrainingData.setModel_code("Garmin");
        dCTrainingData.setCategory_code("9");
        dCTrainingData.setBrand_type(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        dCTrainingData.setUnit(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        dCTrainingData.setSales_version(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        dCTrainingData.setProgram_name(str);
        dCTrainingData.setGoals("");
        dCTrainingData.setNotes("");
        dCTrainingData.setTotal_time(endWorkoutData.getSeconds());
        dCTrainingData.setTotal_distance(endWorkoutData.getDistance());
        dCTrainingData.setTotal_calories(endWorkoutData.getCalories());
        dCTrainingData.setAvg_hr(endWorkoutData.getHeartRate());
        dCTrainingData.setAvg_incline(endWorkoutData.getIncline());
        dCTrainingData.setAvg_speed(endWorkoutData.getSpeed());
        dCTrainingData.setDevice_os_name("Android");
        dCTrainingData.setDevice_os_version(Build.VERSION.RELEASE);
        dCTrainingData.setDevice_model(Build.BRAND);
        dCTrainingData.setDevice_sno(Build.SERIAL);
        dCTrainingData.setDevice_gps_lat((float) Global.gpsLat);
        dCTrainingData.setDevice_gps_lng((float) Global.gpsLon);
        String str2 = ProtocolHandler.protocol.connectedMacAddress;
        return dCTrainingData;
    }

    public static DCTrainingData saveQRCodeDCTrainingData(EndWorkoutData endWorkoutData, Calendar calendar, String str, String str2) {
        Calendar calendar2 = Calendar.getInstance();
        int i = ((calendar2.get(15) / 1000) / 60) / 60;
        DCTrainingData dCTrainingData = new DCTrainingData();
        int accout_noFromDB = getAccout_noFromDB();
        dCTrainingData.setAccount(Global.userName);
        dCTrainingData.setAccount_no(accout_noFromDB);
        dCTrainingData.setTraining_datetime(calendar.getTime());
        dCTrainingData.setTraining_timezone_hour(i);
        dCTrainingData.setTraining_timezone_name(calendar2.getTimeZone().getID());
        dCTrainingData.setBrand_code(BuildConfig.FLAVOR);
        dCTrainingData.setIn_out(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        dCTrainingData.setModel_code("TT9");
        dCTrainingData.setCategory_code(String.valueOf(Integer.parseInt(str2.substring(14, 16), 16)));
        dCTrainingData.setBrand_type(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        dCTrainingData.setUnit(String.valueOf(Integer.parseInt(str2.substring(16, 18), 16)));
        dCTrainingData.setSales_version(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        dCTrainingData.setProgram_name(str);
        dCTrainingData.setGoals("");
        dCTrainingData.setNotes("");
        dCTrainingData.setTotal_time(endWorkoutData.getSeconds());
        dCTrainingData.setTotal_distance(endWorkoutData.getDistance());
        dCTrainingData.setTotal_calories(endWorkoutData.getCalories());
        dCTrainingData.setAvg_hr(endWorkoutData.getHeartRate());
        dCTrainingData.setAvg_speed(endWorkoutData.getSpeed());
        dCTrainingData.setAvg_rpm(endWorkoutData.getRpm());
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
        String str3 = ProtocolHandler.protocol.connectedMacAddress;
        return dCTrainingData;
    }

    private static int getAccout_noFromDB() {
        QueryBuilder<MemberData> queryBuilder = DbManager.getMemberDataDao().queryBuilder();
        queryBuilder.where(MemberDataDao.Properties.Account.eq(Global.userName), new WhereCondition[0]);
        List<MemberData> list = queryBuilder.list();
        if (list == null || list.size() != 1) {
            return -1;
        }
        return list.get(0).getAccount_no();
    }

    private float getMemberWeightByDeviceUnit() {
        float scaleToFloat;
        float weight = Global.memberData.getWeight();
        if (Integer.parseInt(Global.memberData.getUnit_type()) == 0) {
            scaleToFloat = weight;
            weight = MyVariable.getScaleToFloat(2.2f * weight, 2);
        } else {
            scaleToFloat = MyVariable.getScaleToFloat(0.4535f * weight, 2);
        }
        return ProtocolHandler.protocol.deviceUnit == 0 ? scaleToFloat : weight;
    }

    private float getMemberHeightByDeviceUnit() {
        float scaleToFloat;
        float height = Global.memberData.getHeight();
        if (Integer.parseInt(Global.memberData.getUnit_type()) == 0) {
            scaleToFloat = height;
            height = MyVariable.getScaleToFloat(0.3937f * height, 2);
        } else {
            scaleToFloat = MyVariable.getScaleToFloat(2.54f * height, 2);
        }
        return ProtocolHandler.protocol.deviceUnit == 0 ? scaleToFloat : height;
    }

    private void uploadMemberChangeLangCode() {
        String string = Global.getSharedPreferences(this).getString(QuestMainView.LANGUAGE, "");
        Logger.d("language = " + string);
        if (string.equalsIgnoreCase("zh_tw") || string.equalsIgnoreCase("zh_hk") || string.equalsIgnoreCase("zh_hant")) {
            string = "zh-Hant";
        } else if (string.equalsIgnoreCase("zh_cn") || string.equalsIgnoreCase("zh_hans") || string.toLowerCase().startsWith("zh_hans")) {
            string = "zh-Hans";
        } else if (string.toLowerCase().startsWith("fr")) {
            string = "fr";
        } else if (string.toLowerCase().startsWith("de")) {
            string = "de";
        } else if (string.toLowerCase().startsWith("es")) {
            string = "es";
        } else if (string.toLowerCase().startsWith("ru")) {
            string = "ru";
        }
        Logger.d("language = " + string);
        CloudApi cloudApi = CloudApi.getInstance(this);
        cloudApi.setMemberChangeLangCodeListener(new MemberChangeLangCodeListener() { // from class: com.dyaco.sole.activity.MainActivity.16
            @Override // com.digifly.cloudapi.listener.MemberChangeLangCodeListener
            public void onSuccess(ResponseMessage responseMessage) {
                Logger.d("MemberChangeLangCode  responseMessage = " + responseMessage);
            }

            @Override // com.digifly.cloudapi.listener.MemberChangeLangCodeListener
            public void onFail(ResponseMessage responseMessage) {
                Logger.d("MemberChangeLangCode  responseMessage = " + responseMessage);
            }

            @Override // com.digifly.cloudapi.listener.MemberChangeLangCodeListener
            public void onError(String str) {
                Logger.d("MemberChangeLangCode  err = " + str);
            }
        });
        cloudApi.callMemberChangeLangCode(Global.memberData.getAccount(), Global.memberData.getPassword(), string);
    }

    @Override // com.dyaco.sole.custom.ProtocolHandler.OnBluetoothStateListener
    public void onBluetoothState(boolean z) {
        Log.d(TAG, "onBluetoothState --- " + z);
        if (z) {
            return;
        }
        resetConnectView(false);
    }

    /* renamed from: com.dyaco.sole.activity.MainActivity$27, reason: invalid class name */
    static /* synthetic */ class AnonymousClass27 {
        static final /* synthetic */ int[] $SwitchMap$com$dyaco$ideabussdk_sole$protocol$SoleProtocol$ConnectState;

        static {
            int[] iArr = new int[SoleProtocol.ConnectState.values().length];
            $SwitchMap$com$dyaco$ideabussdk_sole$protocol$SoleProtocol$ConnectState = iArr;
            try {
                iArr[SoleProtocol.ConnectState.ScanFinish.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$dyaco$ideabussdk_sole$protocol$SoleProtocol$ConnectState[SoleProtocol.ConnectState.Connected.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$dyaco$ideabussdk_sole$protocol$SoleProtocol$ConnectState[SoleProtocol.ConnectState.Disconnect.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$dyaco$ideabussdk_sole$protocol$SoleProtocol$ConnectState[SoleProtocol.ConnectState.ConnectTimeout.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    @Override // com.dyaco.sole.custom.ProtocolHandler.OnConnectionStateListener
    public void onConnectState(SoleProtocol.ConnectState connectState) {
        int i = AnonymousClass27.$SwitchMap$com$dyaco$ideabussdk_sole$protocol$SoleProtocol$ConnectState[connectState.ordinal()];
        if (i == 1) {
            autoConnectedScan();
            return;
        }
        if (i == 2) {
            this.isConnecting = false;
            resetConnectView(true);
            setAutoConnectedScaningUpdateWorkoutDataThreadRuningFlag(false);
            autoConnectedOldSimulationWorkoutDataTemp = null;
            enableAutoConnectedSimulationWorkoutDataCountDownTimer(false);
            Global.getSpfEditor(this).putBoolean("first_connect", false).commit();
            return;
        }
        if ((i == 3 || i == 4) && !autoConnectedScan()) {
            autoConnectedOldSimulationWorkoutDataTemp = null;
            setAutoConnectedScaningUpdateWorkoutDataThreadRuningFlag(false);
            enableAutoConnectedSimulationWorkoutDataCountDownTimer(false);
            this.isConnecting = false;
            resetConnectView(false);
        }
    }

    private boolean autoConnectedScan() {
        if (ProtocolHandler.protocol == null || !ProtocolHandler.protocol.isAutoConnectedEnable() || ProtocolHandler.protocol.isBleScan() || ProtocolHandler.protocol.isClassicScan()) {
            return false;
        }
        if (!ProtocolHandler.protocol.isAutoConnecting()) {
            ProtocolHandler.protocol.setAutoConnectedCount(ProtocolHandler.protocol.getAutoConnectedCount() + 1);
            if (ProtocolHandler.protocol.getAutoConnectedCount() <= 10) {
                ProtocolHandler.protocol.startClassicScan();
                ProtocolHandler.protocol.startBleScan();
                runAutoConnectedSimulationWorkoutData();
                Log.d(TAG, "autoConnectedScan");
            }
        }
        return true;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void runAutoConnectedSimulationWorkoutData() {
        if (this.nowPage == 5) {
            if (autoConnectedScaningUpdateWorkoutDataThread == null) {
                setAutoConnectedScaningUpdateWorkoutDataThreadRuningFlag(true);
                Thread thread = new Thread(new Runnable() { // from class: com.dyaco.sole.activity.MainActivity.17
                    /* JADX WARN: Removed duplicated region for block: B:25:0x0119  */
                    /* JADX WARN: Removed duplicated region for block: B:47:0x0214  */
                    @Override // java.lang.Runnable
                    /*
                        Code decompiled incorrectly, please refer to instructions dump.
                    */
                    public void run() throws InterruptedException {
                        final WorkoutData workoutData;
                        Log.d(MainActivity.TAG, "runAutoConnectedSimulationWorkoutData star");
                        boolean unused = MainActivity.isAutoConnectedSimulationWorkoutDataAdd2Sec = true;
                        while (MainActivity.this.isAutoConnectedScaningUpdateWorkoutDataThreadRuningFlag() && !Thread.currentThread().isInterrupted() && MainActivity.this.nowPage == 5) {
                            Log.d(MainActivity.TAG, "runAutoConnectedSimulationWorkoutData run");
                            if (Global.workoutDataListForProtocol.size() <= 0) {
                                if (MainActivity.autoConnectedOldSimulationWorkoutDataTemp != null) {
                                    workoutData = MainActivity.autoConnectedOldSimulationWorkoutDataTemp;
                                } else {
                                    workoutData = new WorkoutData();
                                    workoutData.setPaceMinute(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                    workoutData.setPaceSeconds(AppEventsConstants.EVENT_PARAM_VALUE_NO);
                                }
                            } else {
                                workoutData = Global.workoutDataListForProtocol.get(Global.workoutDataListForProtocol.size() - 1);
                            }
                            int seconds = workoutData.getSeconds() + (workoutData.getMinute() * 60);
                            int i = 0;
                            if (MainActivity.isAutoConnectedSimulationWorkoutDataAdd2Sec) {
                                boolean unused2 = MainActivity.isAutoConnectedSimulationWorkoutDataAdd2Sec = false;
                            }
                            if (Global.workoutDataListForProtocol.size() > 2) {
                                WorkoutData workoutData2 = Global.workoutDataListForProtocol.get(Global.workoutDataListForProtocol.size() - 2);
                                int iIntValue = BigDecimal.valueOf(workoutData2.getSeconds()).add(BigDecimal.valueOf(workoutData2.getMinute()).multiply(BigDecimal.valueOf(60L))).intValue();
                                WorkoutData workoutData3 = Global.workoutDataListForProtocol.get(Global.workoutDataListForProtocol.size() - 1);
                                int iIntValue2 = BigDecimal.valueOf(workoutData3.getSeconds()).add(BigDecimal.valueOf(workoutData3.getMinute()).multiply(BigDecimal.valueOf(60L))).intValue();
                                Log.d(MainActivity.TAG, "runAutoConnectedSimulationWorkoutData workoutDataTemp01TimeSeconds=" + iIntValue + " workoutDataTemp02TimeSeconds=" + iIntValue2);
                                long j = (long) iIntValue2;
                                int iIntValue3 = BigDecimal.valueOf(j).subtract(BigDecimal.valueOf((long) iIntValue)).intValue();
                                if (iIntValue3 <= 0) {
                                    if (iIntValue3 >= 0) {
                                        if (Global.workoutDataListForProtocol.size() > 5) {
                                            WorkoutData workoutData4 = Global.workoutDataListForProtocol.get(Global.workoutDataListForProtocol.size() - 5);
                                            int iIntValue4 = BigDecimal.valueOf(j).subtract(BigDecimal.valueOf(BigDecimal.valueOf(workoutData4.getSeconds()).add(BigDecimal.valueOf(workoutData4.getMinute()).multiply(BigDecimal.valueOf(60L))).intValue())).intValue();
                                            if (iIntValue4 <= 0) {
                                                if (iIntValue4 >= 0) {
                                                    if (Global.workoutDataListForProtocol.size() > 10) {
                                                        WorkoutData workoutData5 = Global.workoutDataListForProtocol.get(Global.workoutDataListForProtocol.size() - 10);
                                                        int iIntValue5 = BigDecimal.valueOf(j).subtract(BigDecimal.valueOf(BigDecimal.valueOf(workoutData5.getSeconds()).add(BigDecimal.valueOf(workoutData5.getMinute()).multiply(BigDecimal.valueOf(60L))).intValue())).intValue();
                                                        if (iIntValue5 <= 0) {
                                                            if (iIntValue5 >= 0) {
                                                                if (Global.workoutDataListForProtocol.size() > 15) {
                                                                    WorkoutData workoutData6 = Global.workoutDataListForProtocol.get(Global.workoutDataListForProtocol.size() - 15);
                                                                    int iIntValue6 = BigDecimal.valueOf(j).subtract(BigDecimal.valueOf(BigDecimal.valueOf(workoutData6.getSeconds()).add(BigDecimal.valueOf(workoutData6.getMinute()).multiply(BigDecimal.valueOf(60L))).intValue())).intValue();
                                                                    if (iIntValue6 > 0) {
                                                                        seconds++;
                                                                    } else if (iIntValue6 < 0) {
                                                                        seconds--;
                                                                    }
                                                                }
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                        }
                                    }
                                }
                            }
                            if (seconds > 0) {
                                workoutData.setDistance(workoutData.getDistance() + 0.005f);
                                i = seconds;
                            }
                            workoutData.setSeconds(i % 60);
                            workoutData.setMinute(i / 60);
                            workoutData.setAutoConnectedSimulationData(true);
                            WorkoutData unused3 = MainActivity.autoConnectedOldSimulationWorkoutDataTemp = workoutData;
                            if (MainActivity.this.fragments.size() >= 4) {
                                MainActivity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.MainActivity.17.1
                                    @Override // java.lang.Runnable
                                    public void run() {
                                        if (MainActivity.this.isAutoConnectedScaningUpdateWorkoutDataThreadRuningFlag()) {
                                            ((DisplayMainFragment) MainActivity.this.fragments.get(5)).onWorkoutResult(workoutData);
                                        }
                                    }
                                });
                            }
                            try {
                                Thread.sleep(1000L);
                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }
                        }
                        Thread unused4 = MainActivity.autoConnectedScaningUpdateWorkoutDataThread = null;
                        Log.d(MainActivity.TAG, "runAutoConnectedSimulationWorkoutData stop");
                    }
                });
                autoConnectedScaningUpdateWorkoutDataThread = thread;
                thread.start();
                return;
            }
            return;
        }
        setAutoConnectedScaningUpdateWorkoutDataThreadRuningFlag(false);
    }

    public void enableAutoConnectedSimulationWorkoutDataCountDownTimer(boolean z) {
        if (z) {
            this.autoConnectedSimulationWorkoutDataCountDownTimer.start();
        } else {
            this.autoConnectedSimulationWorkoutDataCountDownTimer.cancel();
            setAutoConnectedScaningUpdateWorkoutDataThreadRuningFlag(false);
        }
    }

    public void restartAutoConnectedSimulationWorkoutDataCountDownTimer() {
        enableAutoConnectedSimulationWorkoutDataCountDownTimer(false);
        enableAutoConnectedSimulationWorkoutDataCountDownTimer(true);
        Log.d(TAG, "restartAutoConnectedSimulationWorkoutDataCountDownTimer");
    }

    private void restart() {
        Intent intent = new Intent(this, (Class<?>) LogoActivity.class);
        intent.putExtra("restart", true);
        startActivity(intent);
        finish();
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    private void goConnection() {
        startActivityForResult(new Intent(this, (Class<?>) ConnectionDialog.class), 99);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    private void goLanguage() {
        startActivityForResult(new Intent(this, (Class<?>) LanguageDialog.class), R2.color.olive);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void goExportUser() {
        startActivityForResult(new Intent(this, (Class<?>) ExportUserDialog.class), 500);
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
    }

    public void goShare(int i) {
        Intent intent = new Intent(this, (Class<?>) ShareDialog.class);
        if (i == 6) {
            CalendarMainFragment calendarMainFragment = (CalendarMainFragment) this.fragments.get(6);
            String shareRecording = calendarMainFragment.getShareRecording();
            String trackCalories = calendarMainFragment.getTrackCalories();
            String trackStartDate = calendarMainFragment.getTrackStartDate();
            String trackDuration = calendarMainFragment.getTrackDuration();
            String trackDistance = calendarMainFragment.getTrackDistance();
            String trackSpeed = calendarMainFragment.getTrackSpeed();
            String trackHeartRate = calendarMainFragment.getTrackHeartRate();
            String shareProgram = calendarMainFragment.getShareProgram();
            String shareModel = calendarMainFragment.getShareModel();
            String shareCategory = calendarMainFragment.getShareCategory();
            intent.putExtra("nowPage", i);
            intent.putExtra("shareRecording", shareRecording);
            intent.putExtra("trackCalories", trackCalories);
            intent.putExtra("trackStartDate", trackStartDate);
            intent.putExtra("trackDuration", trackDuration);
            intent.putExtra("trackDistance", trackDistance);
            intent.putExtra("trackSpeed", trackSpeed);
            intent.putExtra("trackHeartRate", trackHeartRate);
            intent.putExtra("trackProgram", shareProgram);
            intent.putExtra("trackModel", shareModel);
            intent.putExtra("trackCategory", shareCategory);
            ShareDialog.flag = true;
            startActivityForResult(intent, 9527);
            overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
        }
    }

    @Override // com.dyaco.sole.custom.ProtocolHandler.OnDataResultListener
    public void onDataResult(int i, boolean z, List<Number> list) {
        if (i != 3) {
            if (i != 9) {
                return;
            }
            if (ProtocolHandler.protocol.deviceType == 0) {
                Global.isSafeKeyOn = list.get(0).intValue() != 2;
            }
            if (Global.isSafeKeyOn) {
                return;
            }
            ((DisplayMainFragment) this.fragments.get(5)).showSafekeyDialog();
            return;
        }
        int iIntValue = list.get(0).intValue();
        if (iIntValue == 1) {
            Global.printLog("e", TAG, "切換到Idle Mode!");
            Global.isIdleMode = true;
            ((DisplayMainFragment) this.fragments.get(5)).cancelDialog();
        } else if (iIntValue == 128 || iIntValue == 8) {
            Global.printLog("e", TAG, "CS Running Mode!無法進入操作");
            Global.isIdleMode = false;
            int i2 = this.nowPage;
            if (i2 == 5 || i2 == 3) {
                ProtocolHandler.protocol.disconnect();
            }
        }
    }

    public void startWorkout() throws IOException {
        int i = DeviceModelList.programTitleTexts[0];
        boolean z = i == R.string.hr1 || i == R.string.hr2;
        boolean z2 = i == R.string.user || i == R.string.user1 || i == R.string.user2 || i == R.string.custom;
        ProtocolHandler.protocol.setWorkoutTime = 0;
        if (z) {
            ProtocolHandler.protocol.setMaxTargetHR = 220 - ProtocolHandler.protocol.setAge;
        } else if (i == R.string.calorie) {
            ProtocolHandler.protocol.setTargetCalories = 5;
        } else if (i == R.string.fusion) {
            ProtocolHandler.protocol.setIntervalTime = 5;
            ProtocolHandler.protocol.setRecoverTime = 10;
        } else {
            ProtocolHandler.protocol.setMaxTargetHR = 220 - ProtocolHandler.protocol.setAge;
            int i2 = ProtocolHandler.protocol.deviceType;
            if (i2 == 1 || i2 == 2) {
                ProtocolHandler.protocol.setMaxLevel = 5;
            }
        }
        int[] iArr = DeviceModelList.programPosition[0];
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i3 : iArr) {
            if (z) {
                arrayList.add(0);
            } else {
                arrayList.add(Integer.valueOf(i3 - 1));
            }
        }
        ProtocolHandler.protocol.setProgramMode = 0;
        ProtocolHandler.protocol.setUserProfiles = arrayList;
        ProfileDataDB profileDataDB = new ProfileDataDB(this);
        if (z2) {
            profileDataDB.updateProfileData(i == R.string.user2 ? 2 : 1, ProtocolHandler.protocol.setUserProfiles);
        }
        profileDataDB.close();
        if (!z && ProtocolHandler.protocol.isConnected()) {
            ProtocolHandler.protocol.startWorkout();
        }
    }

    private void refreshOmronToken() {
        final String str = String.format("https://%s/api/apps/%s/oauth2/token", "data-jp.omronconnect.com", "1e3ddd17");
        new Thread(new Runnable() { // from class: com.dyaco.sole.activity.MainActivity.19
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                String str2;
                String string;
                if (Global.memberData != null) {
                    str2 = "" + Global.memberData.getAccount_no();
                } else {
                    str2 = "";
                }
                try {
                    FileInputStream fileInputStreamOpenFileInput = MainActivity.this.openFileInput("omron_refresh_token_" + str2);
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        int i = fileInputStreamOpenFileInput.read();
                        if (i == -1) {
                            break;
                        } else {
                            stringBuffer.append((char) i);
                        }
                    }
                    string = stringBuffer.toString();
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (FileNotFoundException | IOException unused) {
                    }
                } catch (FileNotFoundException | IOException unused2) {
                    string = "";
                }
                if ("".equals(string)) {
                    return;
                }
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("grant_type", "refresh_token");
                    jSONObject.put("refresh_token", string);
                } catch (JSONException unused3) {
                }
                String string2 = jSONObject.toString();
                HttpURLConnection httpURLConnection = null;
                StringBuilder sb = new StringBuilder();
                try {
                    HttpURLConnection httpURLConnection2 = (HttpURLConnection) new URL(str).openConnection();
                    try {
                        httpURLConnection2.setRequestMethod(HttpPost.METHOD_NAME);
                        httpURLConnection2.setRequestProperty("Content-Type", "application/json");
                        httpURLConnection2.setDoInput(true);
                        httpURLConnection2.setDoOutput(true);
                        httpURLConnection2.connect();
                        OutputStream outputStream = httpURLConnection2.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                        bufferedWriter.write(string2);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection2.getInputStream(), "utf-8"));
                        while (true) {
                            String line = bufferedReader.readLine();
                            if (line == null) {
                                break;
                            } else {
                                sb.append(line);
                            }
                        }
                        JSONObject jSONObject2 = new JSONObject(sb.toString());
                        String string3 = jSONObject2.getString("access_token");
                        String string4 = jSONObject2.getString("refresh_token");
                        MyApp.omron_access_token = string3;
                        FileOutputStream fileOutputStreamOpenFileOutput = MainActivity.this.openFileOutput("omron_refresh_token_" + str2, 0);
                        fileOutputStreamOpenFileOutput.write(string4.getBytes());
                        fileOutputStreamOpenFileOutput.close();
                        new MyApp().getOmronSearchDate();
                        if (httpURLConnection2 != null) {
                            httpURLConnection2.disconnect();
                        }
                    } catch (Exception unused4) {
                        httpURLConnection = httpURLConnection2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                    } catch (Throwable th) {
                        th = th;
                        httpURLConnection = httpURLConnection2;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                } catch (Exception unused5) {
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }).start();
    }

    private void checkStravaAccessToken() {
        final String str = String.format("https://www.strava.com/api/v3/athlete", new Object[0]);
        new Thread(new Runnable() { // from class: com.dyaco.sole.activity.MainActivity.20
            /* JADX WARN: Multi-variable type inference failed */
            /* JADX WARN: Type inference failed for: r0v18, types: [java.io.BufferedReader] */
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                String str2;
                String string;
                HttpURLConnection httpURLConnection;
                Throwable th;
                if (Global.memberData != null) {
                    str2 = "" + Global.memberData.getAccount_no();
                } else {
                    str2 = "";
                }
                try {
                    FileInputStream fileInputStreamOpenFileInput = MainActivity.this.openFileInput("strava_access_token_" + str2);
                    StringBuffer stringBuffer = new StringBuffer();
                    while (true) {
                        int i = fileInputStreamOpenFileInput.read();
                        if (i == -1) {
                            break;
                        } else {
                            stringBuffer.append((char) i);
                        }
                    }
                    string = stringBuffer.toString();
                    try {
                        fileInputStreamOpenFileInput.close();
                    } catch (FileNotFoundException | IOException unused) {
                    }
                } catch (FileNotFoundException | IOException unused2) {
                    string = "";
                }
                if (!"".equals(string)) {
                    HttpURLConnection httpURLConnection2 = null;
                    HttpURLConnection httpURLConnection3 = null;
                    try {
                        try {
                            httpURLConnection = (HttpURLConnection) new URL(str).openConnection();
                        } catch (Throwable th2) {
                            httpURLConnection = httpURLConnection2;
                            th = th2;
                        }
                    } catch (Exception unused3) {
                    }
                    try {
                        httpURLConnection.setRequestMethod(HttpGet.METHOD_NAME);
                        httpURLConnection.setRequestProperty("Authorization", "Bearer " + string);
                        httpURLConnection.connect();
                        ?? bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
                        MyApp.strava_access_token = string;
                        httpURLConnection2 = bufferedReader;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                            httpURLConnection2 = bufferedReader;
                        }
                    } catch (Exception unused4) {
                        httpURLConnection3 = httpURLConnection;
                        Global.getSpfEditor(MainActivity.this.getApplicationContext()).putBoolean("strava_auto", false).commit();
                        httpURLConnection2 = httpURLConnection3;
                        if (httpURLConnection3 != null) {
                            httpURLConnection3.disconnect();
                            httpURLConnection2 = httpURLConnection3;
                        }
                        return;
                    } catch (Throwable th3) {
                        th = th3;
                        if (httpURLConnection != null) {
                            httpURLConnection.disconnect();
                        }
                        throw th;
                    }
                    return;
                }
                Global.getSpfEditor(MainActivity.this.getApplicationContext()).putBoolean("strava_auto", false).commit();
            }
        }).start();
    }

    public void ToLoginPage() {
        Intent intent = new Intent();
        intent.setFlags(268468224);
        intent.setClass(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }

    public void startHRScan() {
        BluetoothLeService bluetoothLeService = this.mBluetoothLeService;
        if (bluetoothLeService != null) {
            bluetoothLeService.stopAutoReConnectLeScan();
        }
        this.bluetoothAdapter.startLeScan(new UUID[]{BluetoothLeService.UUID_HEART_RATE}, this.leScanCallback);
    }

    public void stopHRScan() {
        this.bluetoothAdapter.stopLeScan(this.leScanCallback);
    }

    public boolean connectHRDevice(String str) {
        BluetoothLeService bluetoothLeService = this.mBluetoothLeService;
        if (bluetoothLeService != null) {
            return bluetoothLeService.connect(str);
        }
        return false;
    }

    @Override // com.dyaco.sole.BluetoothLeService.OnHRConnectListener
    public void isConnect() {
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.MainActivity.23
            @Override // java.lang.Runnable
            public void run() {
                MyApp.isHRConnect = true;
                MainActivity.this.selectHRDevice.close();
                MainActivity.this.connect_hr_imageview.setImageResource(R.drawable.icon_hr_1);
            }
        });
    }

    @Override // com.dyaco.sole.BluetoothLeService.OnHRConnectListener
    public void isDisconnect() {
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.MainActivity.24
            @Override // java.lang.Runnable
            public void run() {
                MyApp.isHRConnect = false;
                MainActivity.this.selectHRDevice.closeProgress();
                MainActivity.this.connect_hr_imageview.setImageResource(R.drawable.icon_hr_0);
                if (ProtocolHandler.protocol.isConnected()) {
                    return;
                }
                MainActivity.this.connect_hr_imageview.setVisibility(8);
            }
        });
    }

    @Override // com.dyaco.sole.BluetoothLeService.OnHRConnectListener
    public void setHR(int i) {
        Log.e("heartRate", i + "");
        this.heartRate = i;
    }

    public void setAutoConnectedScaningUpdateWorkoutDataThreadRuningFlag(boolean z) {
        isAutoConnectedScaningUpdateWorkoutDataThreadRuningFlag = z;
    }

    public boolean isAutoConnectedScaningUpdateWorkoutDataThreadRuningFlag() {
        return isAutoConnectedScaningUpdateWorkoutDataThreadRuningFlag;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void openQRCodeScane() {
        Log.d(TAG, "OpenQRCodeScane");
        new IntentIntegrator(this).initiateScan();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void showQrCodeSelectDialog() {
        Log.d(TAG, "showQrCodeSelectDialog");
        closeQrCodeSelectDialog();
        this.isSaveQrCodeFitData = false;
        this.isQrCodePairingConsoleAccount = false;
        this.qrCodeSelectDialog = new AlertDialog.Builder(this, R.style.myDialog).setTitle(getString(R.string.qr_code)).setItems(new String[]{getString(R.string.data_reception)}, new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.activity.MainActivity.25
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                Log.d(MainActivity.TAG, "qrCodeSelectDialog which=" + i);
                if (i == 0) {
                    MainActivity.this.isSaveQrCodeFitData = true;
                }
                MainActivity.this.openQRCodeScane();
            }
        }).setNegativeButton(getString(R.string.cancel), (DialogInterface.OnClickListener) null).show();
    }

    private void closeQrCodeSelectDialog() {
        AlertDialog alertDialog = this.qrCodeSelectDialog;
        if (alertDialog != null && alertDialog.isShowing()) {
            this.qrCodeSelectDialog.dismiss();
        }
        this.qrCodeSelectDialog = null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void callSyncAddSynceDevice(String str) {
        if (Global.userName == null || Global.userName.length() <= 0) {
            return;
        }
        CloudApi cloudApi = CloudApi.getInstance(this);
        showLoadDialog(null);
        cloudApi.callSyncAddSynceDevice(Global.userName, str, new Callback() { // from class: com.dyaco.sole.activity.MainActivity.26
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                Log.e(MainActivity.TAG, "callSyncAddSynceDevice -> onFailure Exception=" + iOException.toString());
                iOException.printStackTrace();
                MainActivity.this.closeLoadDialog();
                MainActivity.this.showBaseAlert(R.string.error, R.string.confirm, true, MainActivity.this.getString(R.string.sync_profile_data_failed) + StringUtils.LF + iOException.getMessage(), (DialogInterface.OnClickListener) null);
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    try {
                        String strString = response.body().string();
                        Log.d(MainActivity.TAG, "callSyncAddSynceDevice -> onResponse data=" + strString);
                        BaseWebApiData baseWebApiDataObjectFromData = BaseWebApiData.objectFromData(strString);
                        if (baseWebApiDataObjectFromData.getSys_response_message().getCode().equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
                            MainActivity.this.showBaseAlert(R.string.confirm, true, R.string.sync_profile_data_success, (DialogInterface.OnClickListener) null);
                        } else {
                            MainActivity.this.showBaseAlert(R.string.error, R.string.confirm, true, MainActivity.this.getString(R.string.sync_profile_data_failed) + StringUtils.LF + baseWebApiDataObjectFromData.getSys_response_message().getCode(), (DialogInterface.OnClickListener) null);
                        }
                    } catch (Exception e) {
                        Log.e(MainActivity.TAG, "callSyncAddSynceDevice -> onResponse Exception=" + e.toString());
                        e.printStackTrace();
                        MainActivity.this.showBaseAlert(R.string.error, R.string.confirm, true, MainActivity.this.getString(R.string.sync_profile_data_failed) + StringUtils.LF + e.getMessage(), (DialogInterface.OnClickListener) null);
                    }
                } finally {
                    MainActivity.this.closeLoadDialog();
                }
            }
        });
    }
}
