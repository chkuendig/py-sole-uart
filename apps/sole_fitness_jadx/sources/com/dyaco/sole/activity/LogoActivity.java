package com.dyaco.sole.activity;

import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.location.Location;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertDialog;
import com.dyaco.ideabussdk_sole.library.MyActivity;
import com.dyaco.sole.BuildConfig;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.Execute;
import com.dyaco.sole.custom.GPSUtil;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.ProtocolHandler;
import com.dyaco.sole.custom_view.ErrorDialog;
import com.dyaco.sole.custom_view.QuestMainView;
import com.facebook.internal.AnalyticsEvents;
import com.soletreadmills.sole.R;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Locale;
import java.util.Timer;
import java.util.TimerTask;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.json.JSONException;
import org.json.JSONObject;
import pub.devrel.easypermissions.AfterPermissionGranted;
import pub.devrel.easypermissions.AppSettingsDialog;
import pub.devrel.easypermissions.EasyPermissions;

/* loaded from: classes.dex */
public class LogoActivity extends MyActivity implements GPSUtil.OnGpsStatusListener, EasyPermissions.PermissionCallbacks {
    private static final int CAMERA = 66;
    private static final int PHOTO = 67;
    private static final int RequestCode = 1;
    public static final String TAG = "SOLE-LogoActivity";
    private static final int TIME = 2000;
    public static IWXAPI wechat_api;
    private String WECHAT_APP_ID;
    private String WECHAT_SECRET_ID;
    private float cal;
    private float dis;
    private ErrorDialog errorDialog;
    private int fixBugCalCount;
    private int fixBugDisCount;
    public Uri imageUri;
    private boolean isExit = true;
    private boolean isFixBugCal;
    private boolean isFixBugDis;
    private boolean isResetCal;
    private boolean isResetDis;
    private boolean isTransformCal;
    private boolean isTransformDis;
    private String[] perms;
    private QuestMainView questMainView;
    private int resetCalCount;
    private int resetDisCount;
    private Timer timer;
    private float totalCalories;
    private float totalDistance;

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void findViews() {
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void initFragments() {
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void setListeners() {
    }

    public LogoActivity() {
        this.perms = Build.VERSION.SDK_INT < 31 ? new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA"} : new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE", "android.permission.CAMERA", "android.permission.BLUETOOTH_SCAN", "android.permission.BLUETOOTH_CONNECT"};
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Log.d(TAG, "onCreate");
        ProtocolHandler.init(this);
        int i = Global.BRAND;
        if (i == 0) {
            ProtocolHandler.protocol.deviceModel = 16;
            setContentView(R.layout.activity_logo);
            this.questMainView = (QuestMainView) findViewById(R.id.questMainView);
            this.errorDialog = (ErrorDialog) findViewById(R.id.errorDialog);
        } else if (i == 1) {
            ProtocolHandler.protocol.deviceModel = 0;
            setContentView(R.layout.s_activity_logo);
        } else if (i == 2) {
            ProtocolHandler.protocol.deviceModel = 48;
            setContentView(R.layout.x_activity_logo);
        } else if (i == 3) {
            ProtocolHandler.protocol.deviceModel = 176;
            setContentView(R.layout.x_activity_logo);
        }
        initFragments();
        findViews();
        initParams();
        setListeners();
        getWechatAppID_SecretID();
        IWXAPI iwxapiCreateWXAPI = WXAPIFactory.createWXAPI(this, this.WECHAT_APP_ID, true);
        wechat_api = iwxapiCreateWXAPI;
        iwxapiCreateWXAPI.registerApp(this.WECHAT_APP_ID);
    }

    private void getWechatAppID_SecretID() {
        int i = Global.BRAND;
        if (i == 0) {
            this.WECHAT_APP_ID = getResources().getString(R.string.wechat_app_id_sole);
            this.WECHAT_SECRET_ID = getResources().getString(R.string.wechat_secret_id_sole);
            return;
        }
        if (i == 1) {
            this.WECHAT_APP_ID = getResources().getString(R.string.wechat_app_id_spirit);
            this.WECHAT_SECRET_ID = getResources().getString(R.string.wechat_secret_id_spirit);
        } else if (i == 2) {
            this.WECHAT_APP_ID = getResources().getString(R.string.wechat_app_id_xterra);
            this.WECHAT_SECRET_ID = getResources().getString(R.string.wechat_secret_id_xterra);
        } else {
            if (i != 3) {
                return;
            }
            this.WECHAT_APP_ID = getResources().getString(R.string.wechat_app_id_fuel);
            this.WECHAT_SECRET_ID = getResources().getString(R.string.wechat_secret_id_fuel);
        }
    }

    @Override // android.app.Activity
    protected void onResume() {
        super.onResume();
        checkPermissions();
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity, android.app.Activity
    public void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "onDestroy");
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        String str = TAG;
        Log.d(str, "onStart");
        this.isExit = false;
        SharedPreferences sharedPreferences = Global.getSharedPreferences(this);
        Resources resources = getResources();
        String string = sharedPreferences.getString(QuestMainView.LANGUAGE, "");
        Log.d(str, "App language = " + string);
        if (string.equals("")) {
            string = Locale.getDefault().toString();
            Log.d(str, "getDefault language = " + string);
            Global.getSpfEditor(this).putString(QuestMainView.LANGUAGE, string).commit();
        }
        if (string.equals(Locale.ENGLISH.toString())) {
            Global.setAppLocale(resources, Locale.ENGLISH);
            return;
        }
        if (string.equals(Locale.FRANCE.toString()) || string.equals(Locale.FRENCH.toString())) {
            Global.setAppLocale(resources, Locale.FRANCE);
            return;
        }
        if (string.equals(Locale.TAIWAN.toString()) || string.equals(Locale.TRADITIONAL_CHINESE.toString())) {
            Global.setAppLocale(resources, Locale.TAIWAN);
            return;
        }
        if (string.equals(Locale.SIMPLIFIED_CHINESE.toString()) || string.equals(Locale.CHINESE.toString()) || string.equals(Locale.CHINA.toString())) {
            Global.setAppLocale(resources, Locale.CHINA);
            return;
        }
        if (string.equals(Global.DE.toString())) {
            Global.setAppLocale(resources, Global.DE);
            return;
        }
        if (string.equals(Global.ES.toString())) {
            Global.setAppLocale(resources, Global.ES);
        } else if (string.equals(Global.RU.toString())) {
            Global.setAppLocale(resources, Global.RU);
        } else {
            Global.getSpfEditor(this).putString(QuestMainView.LANGUAGE, Locale.ENGLISH.toString()).commit();
        }
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.isExit = true;
        cancelTimer();
        GPSUtil.unregisterGps(this);
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void initParams() {
        ((TextView) findViewById(R.id.version_textview)).setText(String.format("v%s", BuildConfig.VERSION_NAME));
        if (Global.BRAND != 3) {
            return;
        }
        ((ImageView) findViewById(R.id.logo_image)).setImageResource(R.drawable.f_logo);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTimer() {
        cancelTimer();
        Timer timer = new Timer();
        this.timer = timer;
        timer.schedule(new TimerTask() { // from class: com.dyaco.sole.activity.LogoActivity.1
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                if (LogoActivity.this.isExit) {
                    return;
                }
                if (LogoActivity.this.getIntent().getBooleanExtra("restart", false)) {
                    LogoActivity.this.goLoginSystem();
                    return;
                }
                if (!ProtocolHandler.protocol.isConnected()) {
                    ProtocolHandler.protocol.disconnect();
                }
                boolean z = Global.getSharedPreferences(LogoActivity.this).getBoolean("terms_accept", false);
                Log.d(LogoActivity.TAG, "accept=" + z);
                if (Global.getSharedPreferences(LogoActivity.this).getBoolean("terms_accept", false)) {
                    LogoActivity.this.goLoginSystem();
                } else {
                    LogoActivity.this.goTerms();
                }
            }
        }, 2000L);
    }

    private void cancelTimer() {
        Timer timer = this.timer;
        if (timer != null) {
            timer.cancel();
            this.timer = null;
        }
    }

    @Override // com.dyaco.sole.custom.GPSUtil.OnGpsStatusListener
    public void onLocationChanged(Location location) {
        Global.gpsLat = location.getLatitude();
        Global.gpsLon = location.getLongitude();
    }

    private void goMain() {
        Global.printLog("d", TAG, "goMain");
        boolean booleanExtra = getIntent().getBooleanExtra("restart", false);
        Intent intent = new Intent(this, (Class<?>) MainActivity.class);
        intent.putExtra("restart", booleanExtra);
        startActivity(intent);
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goLoginSystem() {
        Global.printLog("d", TAG, "goLoginSystem");
        startActivity(new Intent(this, (Class<?>) LoginActivity.class));
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void goTerms() {
        startActivity(new Intent(this, (Class<?>) TermsActivity.class));
        overridePendingTransition(android.R.anim.slide_in_left, android.R.anim.slide_out_right);
    }

    @AfterPermissionGranted(1)
    private void checkPermissions() {
        Log.d("Logo", "CheckPermissions");
        if (!EasyPermissions.hasPermissions(this, this.perms)) {
            EasyPermissions.requestPermissions(this, "App need to access your location and media resource, please turn on permission.please select \"Allow\" or \"Deny\"", 1, this.perms);
        } else {
            ToMainActivity();
        }
    }

    private void checkVersion() {
        String versionName = ErrorLogSave.getVersionName(getApplicationContext());
        if (versionName == null || versionName.length() <= 0) {
            ToMainActivity();
        } else {
            Execute.getAppVersion(ErrorLogSave.SOLE_VER, new AnonymousClass2(versionName));
        }
    }

    /* renamed from: com.dyaco.sole.activity.LogoActivity$2, reason: invalid class name */
    class AnonymousClass2 implements Callback {
        final /* synthetic */ String val$version;

        AnonymousClass2(String str) {
            this.val$version = str;
        }

        @Override // okhttp3.Callback
        public void onFailure(Call call, IOException iOException) {
            LogoActivity.this.ToMainActivity();
        }

        @Override // okhttp3.Callback
        public void onResponse(Call call, Response response) throws JSONException, IOException {
            try {
                String string = new JSONObject(response.body().string()).getString("sys_response_data");
                if (string != null && string.length() > 0 && !string.equals("null")) {
                    Log.e("LogoActivity", "checkVersion : " + this.val$version + " | " + string);
                    if (this.val$version.equals(string)) {
                        LogoActivity.this.ToMainActivity();
                        return;
                    } else {
                        LogoActivity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.LogoActivity.2.1
                            @Override // java.lang.Runnable
                            public void run() {
                                if (Global.BRAND == 0) {
                                    LogoActivity.this.errorDialog.setVisibility(0);
                                    LogoActivity.this.errorDialog.initView(LogoActivity.this.getString(R.string.error_0001), new View.OnClickListener() { // from class: com.dyaco.sole.activity.LogoActivity.2.1.1
                                        @Override // android.view.View.OnClickListener
                                        public void onClick(View view) {
                                            ErrorLogSave.sendErrorList(LogoActivity.this.questMainView.getAccount(), LogoActivity.this.getApplicationContext());
                                            LogoActivity.this.questMainView.showQA(QuestMainView.LOGO, ErrorLogSave.ERROR_0001);
                                            LogoActivity.this.questMainView.setVisibility(0);
                                        }
                                    }, new View.OnClickListener() { // from class: com.dyaco.sole.activity.LogoActivity.2.1.2
                                        @Override // android.view.View.OnClickListener
                                        public void onClick(View view) {
                                            LogoActivity.this.errorDialog.setVisibility(8);
                                            LogoActivity.this.ToMainActivity();
                                        }
                                    });
                                }
                            }
                        });
                        return;
                    }
                }
                LogoActivity.this.ToMainActivity();
            } catch (Exception unused) {
                LogoActivity.this.ToMainActivity();
            }
        }
    }

    public void showCameraDialog() {
        new AlertDialog.Builder(this, R.style.myDialog).setSingleChoiceItems(new String[]{"Camera", "Album"}, -1, new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.activity.LogoActivity.3
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("description", "Image capture by camera");
                    contentValues.put("mime_type", "image/jpeg");
                    LogoActivity logoActivity = LogoActivity.this;
                    logoActivity.imageUri = logoActivity.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", LogoActivity.this.imageUri);
                    intent.putExtra("android.intent.extra.videoQuality", 1);
                    LogoActivity.this.startActivityForResult(intent, 66);
                } else {
                    Intent intent2 = new Intent();
                    intent2.setType("image/*");
                    intent2.setAction("android.intent.action.PICK");
                    LogoActivity.this.startActivityForResult(Intent.createChooser(intent2, "Choose Image File"), 67);
                }
                dialogInterface.dismiss();
            }
        }).show();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        String str = TAG;
        Log.d(str, "onActivityResult--------" + i);
        Log.d(str, "resultCode--------" + i2);
        if (i == 66 || i == 67) {
            final Uri data = i == 66 ? this.imageUri : null;
            if (i == 67 && intent != null) {
                Log.d(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
                data = intent.getData();
            }
            if (data != null) {
                Log.d(str, "uri:" + data.getPath());
                runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.LogoActivity.4
                    @Override // java.lang.Runnable
                    public void run() throws IOException {
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(LogoActivity.this.getContentResolver(), data);
                            File file = new File(LogoActivity.this.getExternalCacheDir(), System.currentTimeMillis() + ".jpg");
                            try {
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                                LogoActivity.this.questMainView.upLoadImg(new File(file.getPath()));
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

    /* JADX INFO: Access modifiers changed from: private */
    public void ToMainActivity() {
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.LogoActivity.5
            @Override // java.lang.Runnable
            public void run() {
                try {
                    GPSUtil.registerGps(LogoActivity.this);
                    GPSUtil.setOnGpsStatusListener(LogoActivity.this);
                } catch (Exception e) {
                    Log.d("LOGO", e.getMessage());
                    e.printStackTrace();
                }
                LogoActivity.this.startTimer();
            }
        });
    }

    @Override // pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
    public void onPermissionsGranted(int i, List<String> list) {
        Log.d("Logo", "onPermissionsGranted==>" + list);
        checkPermissions();
    }

    @Override // pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
    public void onPermissionsDenied(int i, List<String> list) {
        Log.d("Logo", "onPermissionsDenied==>" + list);
        if (EasyPermissions.somePermissionPermanentlyDenied(this, list)) {
            new AppSettingsDialog.Builder(this).setTitle("Alert").setPositiveButton("Setting").setNegativeButton("Cancel").setRequestCode(1).build().show();
        }
    }

    @Override // android.app.Activity, androidx.core.app.ActivityCompat.OnRequestPermissionsResultCallback
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Log.d("Logo", "onRequestPermissionsResultgrantResults:" + iArr);
        super.onRequestPermissionsResult(i, strArr, iArr);
        EasyPermissions.onRequestPermissionsResult(i, strArr, iArr, this);
    }
}
