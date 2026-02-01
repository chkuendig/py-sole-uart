package com.dyaco.sole.activity;

import android.content.ClipData;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.hardware.display.VirtualDisplay;
import android.location.Location;
import android.location.LocationManager;
import android.media.AudioManager;
import android.media.Image;
import android.media.ImageReader;
import android.media.projection.MediaProjection;
import android.media.projection.MediaProjectionManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.SystemClock;
import android.provider.DocumentsContract;
import android.provider.MediaStore;
import android.util.DisplayMetrics;
import android.util.Log;
import android.util.TypedValue;
import android.view.MotionEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.ToggleButton;
import androidx.appcompat.app.AlertDialog;
import androidx.core.app.ActivityCompat;
import androidx.core.internal.view.SupportMenu;
import androidx.fragment.app.FragmentActivity;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import com.digifly.cloudapi.CloudApi;
import com.digifly.cloudapi.JsonUtil;
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
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.MyApp;
import com.dyaco.sole.R2;
import com.dyaco.sole.ScreenshotTool;
import com.dyaco.sole.custom.GPSTracker;
import com.dyaco.sole.custom.GPSUtil;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom_view.ErrorDialog;
import com.dyaco.sole.custom_view.QuestMainView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.facebook.internal.security.CertificateUtil;
import com.facebook.share.internal.ShareConstants;
import com.facebook.stetho.common.LogUtil;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.UiSettings;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.PolylineOptions;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.soletreadmills.sole.R;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;
import java.util.concurrent.atomic.AtomicInteger;
import org.apache.commons.lang3.LocaleUtils;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;
import org.joda.time.DateTime;
import org.joda.time.Duration;
import org.joda.time.Period;
import pub.devrel.easypermissions.EasyPermissions;

/* loaded from: classes.dex */
public class OutdoorMapsActivity extends FragmentActivity implements OnMapReadyCallback, EasyPermissions.PermissionCallbacks {
    private static final int CAMERA = 66;
    public static final int CAPTURE_CODE = 291;
    private static final int PHOTO = 67;
    private static final String TAG = "outdoor";
    static AtomicInteger oneScreenshot = new AtomicInteger(0);
    private static File shareMapPicFile;

    @BindView(R.id.activity_OutdoorMaps)
    RelativeLayout activityOutdoorMaps;
    Handler backgroundHandler;

    @BindView(R.id.btn1)
    ToggleButton btn1;

    @BindView(R.id.btn2)
    ToggleButton btn2;

    @BindView(R.id.btn3)
    ToggleButton btn3;

    @BindView(R.id.btnBack)
    Button btnBack;

    @BindView(R.id.btnCycling)
    Button btnCycling;

    @BindView(R.id.btnGo)
    Button btnGo;

    @BindView(R.id.btnNext)
    Button btnNext;

    @BindView(R.id.btnPause)
    Button btnPause;

    @BindView(R.id.btnPlayPause)
    ToggleButton btnPlayPause;

    @BindView(R.id.btnPre)
    Button btnPre;

    @BindView(R.id.btnRecordSelf)
    Button btnRecordSelf;

    @BindView(R.id.btnRgGo)
    Button btnRgGo;

    @BindView(R.id.btnRunning)
    Button btnRunning;

    @BindView(R.id.btnShareMap)
    Button btnShareMap;

    @BindView(R.id.btnStop)
    Button btnStop;

    @BindView(R.id.btnWalking)
    Button btnWalking;

    @BindView(R.id.duration)
    LinearLayout duration;
    private ErrorDialog errorDialog;
    private GPSTracker gps;

    @BindView(R.id.iconMusic)
    ImageView iconMusic;
    public Uri imageUri;

    @BindView(R.id.imgMusicCover)
    ImageView imgCover;

    @BindView(R.id.imgSportType2)
    ImageView imgSportType2;
    private boolean isSporting;
    private GoogleMap mMap;
    private Location mMapMyLocation;
    private ImageView menu_service_map;

    @BindView(R.id.musicControlPanl)
    RelativeLayout musicControlPanl;

    @BindView(R.id.musicControlbar)
    RelativeLayout musicControlbar;
    private List<Map<String, String>> musicList;

    @BindView(R.id.musicName)
    TextView musicName;
    private MusicPlay musicPlay;

    @BindView(R.id.musicPlayBar)
    RelativeLayout musicPlayBar;

    @BindView(R.id.musicSelector)
    RelativeLayout musicSelector;

    @BindView(R.id.outdoor_wrapper_321go)
    RelativeLayout outdoorWrapper321go;
    private String provider;
    private QuestMainView questMainView;

    @BindView(R.id.runningLayout)
    RelativeLayout runningLayout;

    @BindView(R.id.settingLayout)
    RelativeLayout settingLayout;

    @BindView(R.id.skbVolume)
    SeekBar skbVolume;

    @BindView(R.id.sportControlBar)
    LinearLayout sportControlBar;
    private SportTypeSetting sportTypeSetting;

    @BindView(R.id.sportTypeSettingLayout)
    RelativeLayout sportTypeSettingLayout;

    @BindView(R.id.sportTypeTitle)
    TextView sportTypeTitle;

    @BindView(R.id.sportTypeTitle2)
    TextView sportTypeTitle2;
    private MyTimerTask timerTask;
    private Timer timer_321go;

    @BindView(R.id.toggleBtnScaleRunningLayout)
    ToggleButton toggleBtnScaleRunningLayout;
    private TrainingInfo trainingInfo;

    @BindView(R.id.tvDistance)
    LinearLayout tvDistance;

    @BindView(R.id.tvDistanceValue)
    TextView tvDistanceValue;
    private int tvDistance_height;

    @BindView(R.id.tvDuration)
    TextView tvDuration;

    @BindView(R.id.tvDurationUnitTitle)
    TextView tvDurationUnitTitle;

    @BindView(R.id.tvDurationUnitTitle1)
    TextView tvDurationUnitTitle1;

    @BindView(R.id.tvDurationValue)
    TextView tvDurationValue;

    @BindView(R.id.tvMusicTitle)
    TextView tvMusicTitle;
    private Timer ui_update_timer;
    private View view321Go;
    private float weight;
    private int posMusic = 0;
    private int runningLayout_height = 0;
    private boolean beFirstLocationChange = true;

    @Override // pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
    public void onPermissionsDenied(int i, List<String> list) {
    }

    @Override // pub.devrel.easypermissions.EasyPermissions.PermissionCallbacks
    public void onPermissionsGranted(int i, List<String> list) {
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Global.setAppLocale(getResources(), LocaleUtils.toLocale(Global.getSharedPreferences(this).getString(QuestMainView.LANGUAGE, "")));
        setContentView(R.layout.activity_outdoor_maps);
        ButterKnife.bind(this);
        this.outdoorWrapper321go.setVisibility(8);
        ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMapAsync(this);
        SportTypeSetting sportTypeSetting = new SportTypeSetting(getApplicationContext(), this.sportTypeSettingLayout);
        this.sportTypeSetting = sportTypeSetting;
        sportTypeSetting.updateSportType();
        this.questMainView = (QuestMainView) findViewById(R.id.questMainViewMap);
        this.errorDialog = (ErrorDialog) findViewById(R.id.errorDialogMap);
        ImageView imageView = (ImageView) findViewById(R.id.menu_service_map);
        this.menu_service_map = imageView;
        imageView.setOnClickListener(new View.OnClickListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity.1
            @Override // android.view.View.OnClickListener
            public void onClick(View view) {
                OutdoorMapsActivity.this.setRequestedOrientation(0);
                OutdoorMapsActivity.this.showMessageView(ErrorLogSave.ERROR_0014);
            }
        });
        this.btnPlayPause.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity.2
            @Override // android.widget.CompoundButton.OnCheckedChangeListener
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) throws IllegalStateException {
                Log.d("ccc", String.valueOf(z));
                if (z) {
                    OutdoorMapsActivity.this.pauseMusic();
                } else {
                    OutdoorMapsActivity.this.resumeMusic();
                }
            }
        });
        this.outdoorWrapper321go.setOnTouchListener(new View.OnTouchListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity.3
            @Override // android.view.View.OnTouchListener
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
    }

    public void showMessageView(final String str) {
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity.4
            @Override // java.lang.Runnable
            public void run() {
                ErrorLogSave.sendErrorList(OutdoorMapsActivity.this.questMainView.getAccount(), OutdoorMapsActivity.this.getApplicationContext());
                OutdoorMapsActivity.this.questMainView.showQA("outdoor", str);
                OutdoorMapsActivity.this.questMainView.setVisibility(0);
            }
        });
    }

    public void changeView() {
        setRequestedOrientation(1);
    }

    public void showErrorLog(final int i, final String str) {
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity.5
            @Override // java.lang.Runnable
            public void run() {
                Log.e("showErrorLog", "show:" + i + " | " + OutdoorMapsActivity.this.getString(i));
                if (OutdoorMapsActivity.this.errorDialog.isShown()) {
                    return;
                }
                OutdoorMapsActivity.this.errorDialog.setVisibility(0);
                OutdoorMapsActivity.this.errorDialog.initView(OutdoorMapsActivity.this.getString(i), new View.OnClickListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity.5.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        OutdoorMapsActivity.this.showMessageView(str);
                    }
                }, new View.OnClickListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity.5.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        OutdoorMapsActivity.this.errorDialog.setVisibility(8);
                        OutdoorMapsActivity.this.setRequestedOrientation(1);
                    }
                });
            }
        });
    }

    public boolean isErrorShow() {
        return this.errorDialog.isShown();
    }

    public void showCameraDialog() {
        new AlertDialog.Builder(this, R.style.myDialog).setSingleChoiceItems(new String[]{"Camera", "Album"}, -1, new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity.6
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("description", "Image capture by camera");
                    contentValues.put("mime_type", "image/jpeg");
                    OutdoorMapsActivity outdoorMapsActivity = OutdoorMapsActivity.this;
                    outdoorMapsActivity.imageUri = outdoorMapsActivity.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", OutdoorMapsActivity.this.imageUri);
                    intent.putExtra("android.intent.extra.videoQuality", 1);
                    OutdoorMapsActivity.this.startActivityForResult(intent, 66);
                } else {
                    Intent intent2 = new Intent();
                    intent2.setType("image/*");
                    intent2.setAction("android.intent.action.PICK");
                    OutdoorMapsActivity.this.startActivityForResult(Intent.createChooser(intent2, "Choose Image File"), 67);
                }
                dialogInterface.dismiss();
            }
        }).show();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity, android.content.ComponentCallbacks
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        if (getResources().getConfiguration().orientation == 2) {
            return;
        }
        int i = getResources().getConfiguration().orientation;
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStart() {
        super.onStart();
        String[] strArr = {"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION", "android.permission.READ_EXTERNAL_STORAGE", "android.permission.WRITE_EXTERNAL_STORAGE"};
        if (!EasyPermissions.hasPermissions(this, strArr)) {
            EasyPermissions.requestPermissions(this, "需要權限", 100, strArr);
        }
        DbManager.getInstance(this);
        GPSUtil.registerGps(this);
        this.musicPlay = new MusicPlay();
        if (this.runningLayout_height == 0) {
            this.runningLayout_height = this.runningLayout.getLayoutParams().height;
        }
        this.tvDistance_height = this.tvDistance.getMeasuredHeight();
    }

    public boolean isOpen() {
        LocationManager locationManager = (LocationManager) getSystemService("location");
        return locationManager.isProviderEnabled("gps") || locationManager.isProviderEnabled("network");
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onResume() {
        super.onResume();
        this.isSporting = MyApp.isSporting;
        this.settingLayout.setVisibility(8);
        this.runningLayout.setVisibility(8);
        this.settingLayout.setVisibility(0);
        if (this.isSporting) {
            this.settingLayout.setVisibility(8);
            this.runningLayout.setVisibility(0);
        }
        this.skbVolume.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity.7
            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onStopTrackingTouch(SeekBar seekBar) {
            }

            @Override // android.widget.SeekBar.OnSeekBarChangeListener
            public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
                OutdoorMapsActivity.this.initMusicVolume(i);
                Log.d("ddd", "skbVolume: " + i);
            }
        });
        if (isOpen()) {
            return;
        }
        setRequestedOrientation(0);
        showErrorLog(R.string.error_0015, ErrorLogSave.ERROR_0015);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onPause() {
        super.onPause();
        ((TextView) this.outdoorWrapper321go.findViewById(R.id.tv321go)).clearAnimation();
        this.outdoorWrapper321go.setVisibility(8);
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onStop() {
        super.onStop();
    }

    @Override // androidx.fragment.app.FragmentActivity, android.app.Activity
    protected void onDestroy() throws IllegalStateException {
        super.onDestroy();
        stopMusic();
        stopTimer();
        GPSUtil.unregisterGps(this);
    }

    @Override // androidx.activity.ComponentActivity, android.app.Activity
    public void onBackPressed() {
        finish();
        goPage(MainActivity.class);
    }

    public static Bitmap getScreenShot(View view) {
        View rootView = view.getRootView();
        rootView.setDrawingCacheEnabled(true);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(rootView.getDrawingCache());
        rootView.setDrawingCacheEnabled(false);
        return bitmapCreateBitmap;
    }

    public static File store(Bitmap bitmap, String str) throws IOException {
        String str2 = Environment.getExternalStorageDirectory().getAbsolutePath() + "/Screenshots";
        File file = new File(str2);
        if (!file.exists()) {
            file.mkdirs();
        }
        shareMapPicFile = new File(str2, str);
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(shareMapPicFile);
            bitmap.compress(Bitmap.CompressFormat.PNG, 85, fileOutputStream);
            fileOutputStream.flush();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return shareMapPicFile;
    }

    public void shareImage(String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setType("image/jpeg");
        Uri uri = null;
        try {
            FileInputStream fileInputStreamOpenFileInput = getApplicationContext().openFileInput(Global.screenshotFile.getName());
            uri = Uri.parse(MediaStore.Images.Media.insertImage(getApplicationContext().getContentResolver(), BitmapFactory.decodeStream(fileInputStreamOpenFileInput), (String) null, (String) null));
            fileInputStreamOpenFileInput.close();
        } catch (Exception e) {
            LogUtil.v("outdoor", "shareAct e = ", e);
            showErrorLog(R.string.error_0011, ErrorLogSave.ERROR_0011);
        }
        intent.putExtra("android.intent.extra.STREAM", uri);
        startActivity(Intent.createChooser(intent, str));
    }

    @Override // com.google.android.gms.maps.OnMapReadyCallback
    public void onMapReady(GoogleMap googleMap) {
        this.mMap = googleMap;
        UiSettings uiSettings = googleMap.getUiSettings();
        uiSettings.setZoomControlsEnabled(true);
        uiSettings.setMyLocationButtonEnabled(true);
        uiSettings.setIndoorLevelPickerEnabled(true);
        uiSettings.setCompassEnabled(true);
        this.mMap.animateCamera(CameraUpdateFactory.zoomTo(5.0f));
        if (ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_FINE_LOCATION") == 0 || ActivityCompat.checkSelfPermission(this, "android.permission.ACCESS_COARSE_LOCATION") == 0) {
            this.mMap.setMyLocationEnabled(true);
            this.mMap.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity.8
                @Override // com.google.android.gms.maps.GoogleMap.OnMyLocationChangeListener
                public void onMyLocationChange(Location location) {
                    if (OutdoorMapsActivity.this.beFirstLocationChange) {
                        OutdoorMapsActivity.this.mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(location.getLatitude(), location.getLongitude())));
                        OutdoorMapsActivity.this.mMap.animateCamera(CameraUpdateFactory.zoomTo(15.0f));
                        OutdoorMapsActivity.this.beFirstLocationChange = false;
                    }
                }
            });
        } else {
            Toast.makeText(this, "no get loctation.", 0).show();
        }
    }

    public void trackToMe() {
        PolylineOptions polylineOptions = new PolylineOptions();
        synchronized (this.timerTask.getLatLngListSave()) {
            Iterator<LatLng> it = this.timerTask.getLatLngListSave().iterator();
            while (it.hasNext()) {
                polylineOptions.add(it.next());
            }
        }
        polylineOptions.color(SupportMenu.CATEGORY_MASK);
        this.mMap.addPolyline(polylineOptions).setWidth(10.0f);
    }

    public void updateFitInfo() {
        TrainingInfo trainingInfo = this.timerTask.getTrainingInfo();
        this.trainingInfo = trainingInfo;
        float distance = trainingInfo.getDistance() / 1000.0f;
        if (Global.memberData.getUnit_type().equals(AppEventsConstants.EVENT_PARAM_VALUE_YES)) {
            distance = this.trainingInfo.getDistance() / 1.6f;
        }
        this.tvDistanceValue.setText(String.format("%2.2f", Float.valueOf(distance)));
        if (this.toggleBtnScaleRunningLayout.isChecked()) {
            this.tvDurationValue.setText(String.format("%2.3f", Float.valueOf(distance)));
        } else {
            Period period = this.trainingInfo.getDuration().toPeriod();
            this.tvDurationValue.setText(String.format("%02d:%02d", Integer.valueOf(period.getMinutes()), Integer.valueOf(period.getSeconds())));
        }
        List<Map<String, String>> list = this.musicList;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.tvMusicTitle.setText(this.musicList.get(this.posMusic).get("title"));
        this.musicName.setText(this.musicList.get(this.posMusic).get("title"));
    }

    public void setSportType() {
        this.sportTypeTitle2.setText(this.sportTypeSetting.getCurrentSportTypeTitle());
        this.imgSportType2.setImageResource(this.sportTypeSetting.getCurrentSportTypeImgID());
    }

    @OnClick({R.id.btnWalking, R.id.btnRunning, R.id.btnCycling, R.id.btnGo, R.id.btnRgGo, R.id.btnPause, R.id.btnStop, R.id.btnBack, R.id.btnRecordSelf, R.id.iconMusic, R.id.imgMusicCover, R.id.tvMusicTitle, R.id.btnPlayPause, R.id.btnNext, R.id.btnPre, R.id.musicControlPanl, R.id.toggleBtnScaleRunningLayout, R.id.btnShareMap})
    public void onClick(View view) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        switch (view.getId()) {
            case R.id.btnBack /* 2131230844 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "OutdoorMapsActivity_btnBack", ErrorLogSave.CLICK);
                goPage(MainActivity.class);
                finish();
                break;
            case R.id.btnGo /* 2131230851 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "OutdoorMapsActivity_btnGo", ErrorLogSave.CLICK);
                this.settingLayout.setVisibility(8);
                this.runningLayout.setVisibility(0);
                this.outdoorWrapper321go.setVisibility(0);
                final TextView textView = (TextView) this.outdoorWrapper321go.findViewById(R.id.tv321go);
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) textView.getLayoutParams();
                final ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 6.0f, 0.0f, 6.0f, layoutParams.width / 2, layoutParams.height / 2);
                scaleAnimation.setDuration(1000L);
                scaleAnimation.setRepeatCount(2);
                scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity.9
                    int conntdown321go = 3;

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationStart(Animation animation) {
                        textView.setText(String.valueOf(this.conntdown321go));
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationEnd(Animation animation) {
                        scaleAnimation.setRepeatCount(0);
                        scaleAnimation.setDuration(1000L);
                        scaleAnimation.setAnimationListener(new Animation.AnimationListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity.9.1
                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationRepeat(Animation animation2) {
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationStart(Animation animation2) {
                                textView.setText("Go!");
                            }

                            @Override // android.view.animation.Animation.AnimationListener
                            public void onAnimationEnd(Animation animation2) throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
                                OutdoorMapsActivity.this.outdoorWrapper321go.setVisibility(8);
                                OutdoorMapsActivity.this.startTimer();
                            }
                        });
                        textView.startAnimation(scaleAnimation);
                    }

                    @Override // android.view.animation.Animation.AnimationListener
                    public void onAnimationRepeat(Animation animation) {
                        int i = this.conntdown321go - 1;
                        this.conntdown321go = i;
                        textView.setText(String.valueOf(i));
                    }
                });
                textView.startAnimation(scaleAnimation);
                break;
            case R.id.btnNext /* 2131230853 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "OutdoorMapsActivity_btnNext", ErrorLogSave.CLICK);
                nextMusic();
                playMusic();
                updateFitInfo();
                break;
            case R.id.btnPause /* 2131230857 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "OutdoorMapsActivity_btnPause", ErrorLogSave.CLICK);
                pauseTimer();
                hidePauseButton();
                stopMusic();
                break;
            case R.id.btnPre /* 2131230859 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "OutdoorMapsActivity_btnPre", ErrorLogSave.CLICK);
                preMusic();
                playMusic();
                break;
            case R.id.btnRecordSelf /* 2131230860 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "OutdoorMapsActivity_btnRecordSelf", ErrorLogSave.CLICK);
                Log.e("checkDuration", "here");
                goPage(CustomRecordActivity.class);
                break;
            case R.id.btnRgGo /* 2131230861 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "OutdoorMapsActivity_btnRgGo", ErrorLogSave.CLICK);
                resumeTimer();
                showPauseButton();
                playMusic();
                break;
            case R.id.btnShareMap /* 2131230864 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "OutdoorMapsActivity_btnShareMap", ErrorLogSave.CLICK);
                shareMap();
                break;
            case R.id.btnStop /* 2131230865 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "OutdoorMapsActivity_btnStop", ErrorLogSave.CLICK);
                stopTimer();
                showPauseButton();
                this.settingLayout.setVisibility(0);
                this.runningLayout.setVisibility(8);
                if (!Global.userName.equals(getResources().getString(R.string.guest))) {
                    TrainingInfo trainingInfo = this.timerTask.getTrainingInfo();
                    this.trainingInfo = trainingInfo;
                    trainingInfo.setSportPath(this.timerTask.getLatLngListSave());
                    saveDB(this.trainingInfo, this.timerTask.getTrainingDetailInfoList());
                    break;
                }
                break;
            case R.id.iconMusic /* 2131231288 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "OutdoorMapsActivity_iconMusic", ErrorLogSave.CLICK);
                Uri uri = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                intent.setType("audio/mpeg");
                intent.putExtra("android.intent.extra.LOCAL_ONLY", true);
                intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
                startActivityForResult(Intent.createChooser(intent, null), 1);
                break;
            case R.id.imgMusicCover /* 2131231300 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "OutdoorMapsActivity_imgMusicCover", ErrorLogSave.CLICK);
                this.musicControlPanl.setVisibility(0);
                break;
            case R.id.musicControlPanl /* 2131231424 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "OutdoorMapsActivity_musicControPanl", ErrorLogSave.CLICK);
                this.musicControlPanl.setVisibility(8);
                break;
            case R.id.toggleBtnScaleRunningLayout /* 2131231744 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "OutdoorMapsActivity_toggleBtnScaleRunningLayout", ErrorLogSave.CLICK);
                if (this.toggleBtnScaleRunningLayout.isChecked()) {
                    int dimension = (int) getResources().getDimension(R.dimen.outdoor_distance_layout_height);
                    TypedValue.applyDimension(1, dimension, getResources().getDisplayMetrics());
                    ((RelativeLayout.LayoutParams) this.runningLayout.getLayoutParams()).height = this.runningLayout_height - dimension;
                    ((RelativeLayout.LayoutParams) this.duration.getLayoutParams()).topMargin = (int) TypedValue.applyDimension(1, 20.0f, getResources().getDisplayMetrics());
                    this.tvDistance.setVisibility(8);
                    this.tvDuration.setText(getResources().getString(R.string.distance_title));
                    this.tvDurationUnitTitle.setText(getResources().getString(R.string.distance_unit));
                    this.tvDurationUnitTitle1.setVisibility(8);
                    break;
                } else {
                    ((RelativeLayout.LayoutParams) this.runningLayout.getLayoutParams()).height = this.runningLayout_height;
                    ((RelativeLayout.LayoutParams) this.duration.getLayoutParams()).topMargin = 0;
                    this.tvDistance.setVisibility(0);
                    this.tvDuration.setText(getResources().getString(R.string.duration_title));
                    this.tvDurationUnitTitle.setText(getResources().getString(R.string.duration_unit2));
                    this.tvDurationUnitTitle1.setVisibility(0);
                    break;
                }
            case R.id.tvMusicTitle /* 2131231791 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "OutdoorMapsActivity_tvMusicTitle", ErrorLogSave.CLICK);
                this.musicControlPanl.setVisibility(0);
                break;
        }
    }

    private void shareMap() {
        ScreenshotTool.takeScreenshotFromView(this);
    }

    private void saveDB(TrainingInfo trainingInfo, List<TrainingInfo> list) {
        DCTrainingData dCTrainingDataSaveAsDcTrainingData = saveAsDcTrainingData(trainingInfo);
        DbManager.getDCTrainingDataDao().insert(dCTrainingDataSaveAsDcTrainingData);
        saveDCTrainingDetailData(dCTrainingDataSaveAsDcTrainingData, list);
        Log.d("bbb", dCTrainingDataSaveAsDcTrainingData.toString());
        dCTrainingDataSaveAsDcTrainingData.setPassword(getAccoutData().getPassword());
        updateTrainingDataToCloud(dCTrainingDataSaveAsDcTrainingData);
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

    private void updateTrainingDataToCloud(final DCTrainingData dCTrainingData) {
        CloudApi cloudApi = CloudApi.getInstance(this);
        cloudApi.setDCUploadTrainingDataListener(new DCUploadTrainingDataListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity.10
            @Override // com.digifly.cloudapi.listener.DCUploadTrainingDataListener
            public void onSuccess(ResponseDataCollection responseDataCollection) {
                String str = responseDataCollection.getSys_response_data().get("trainh_no");
                Log.d("cloudapi   trainh_no  ", str);
                DCTrainingDataDao dCTrainingDataDao = DbManager.getDCTrainingDataDao();
                DCTrainingData dCTrainingDataLoad = dCTrainingDataDao.load(dCTrainingData.getTrainingId());
                dCTrainingDataLoad.setTrainh_no(str);
                dCTrainingDataDao.update(dCTrainingDataLoad);
                OutdoorMapsActivity.this.updateTrainingDetailDataToCloud(dCTrainingData);
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

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTrainingDetailDataToCloud(DCTrainingData dCTrainingData) {
        Long trainingId = dCTrainingData.getTrainingId();
        QueryBuilder<DCTrainingDetailData> queryBuilder = DbManager.getDCTrainingDetailDataDao().queryBuilder();
        queryBuilder.where(DCTrainingDetailDataDao.Properties.TrainingId.eq(trainingId), new WhereCondition[0]);
        for (DCTrainingDetailData dCTrainingDetailData : queryBuilder.list()) {
            dCTrainingDetailData.setPassword(dCTrainingData.getPassword());
            dCTrainingDetailData.setTrainh_no(dCTrainingData.getTrainh_no());
            Log.d("qqq  TrainingDetailData", String.valueOf(dCTrainingDetailData.toString()));
            CloudApi cloudApiCreateInstance = CloudApi.createInstance(this);
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

    private void saveDCTrainingDetailData(DCTrainingData dCTrainingData, List<TrainingInfo> list) {
        DCTrainingDetailDataDao dCTrainingDetailDataDao = DbManager.getDCTrainingDetailDataDao();
        for (TrainingInfo trainingInfo : list) {
            DCTrainingDetailData dCTrainingDetailData = new DCTrainingDetailData();
            DateTime startTime = trainingInfo.getStartTime();
            int accout_noFromDB = getAccout_noFromDB();
            Long trainingId = dCTrainingData.getTrainingId();
            dCTrainingDetailData.setAccount(Global.userName);
            dCTrainingDetailData.setAccount_no(accout_noFromDB);
            dCTrainingDetailData.setTrainingId(trainingId);
            dCTrainingDetailData.setTraning_datetime(startTime.toDate());
            dCTrainingDetailData.setD_time(trainingInfo.getDuration().getStandardSeconds());
            dCTrainingDetailData.setD_distance(trainingInfo.getDistance());
            dCTrainingDetailData.setD_calories((float) trainingInfo.getCalorie());
            float distance = trainingInfo.getDistance() / 1000.0f;
            long standardSeconds = trainingInfo.getDuration().getStandardSeconds();
            Log.d("outdoor", "distanceInKM = " + distance);
            Log.d("outdoor", "standardHours = " + standardSeconds);
            if (standardSeconds != 0) {
                dCTrainingDetailData.setD_speed((distance / standardSeconds) * 60.0f * 60.0f);
            }
            dCTrainingDetailData.setDevice_gps_lat(trainingInfo.getLat());
            dCTrainingDetailData.setDevice_gps_lng(trainingInfo.getLng());
            Log.d("ppp", dCTrainingDetailData.toString());
            dCTrainingDetailDataDao.insert(dCTrainingDetailData);
        }
    }

    private DCTrainingData saveAsDcTrainingData(TrainingInfo trainingInfo) {
        DCTrainingData dCTrainingData = new DCTrainingData();
        String jsonSportPath = JsonUtil.toJsonSportPath(saveAsList(trainingInfo.getSportPath()));
        DateTime startTime = trainingInfo.getStartTime();
        Calendar calendar = Calendar.getInstance(getLocale());
        calendar.setTimeInMillis(startTime.getMillis());
        int i = ((calendar.get(15) / 1000) / 60) / 60;
        int accout_noFromDB = getAccout_noFromDB();
        dCTrainingData.setAccount(Global.userName);
        dCTrainingData.setAccount_no(accout_noFromDB);
        dCTrainingData.setTraining_datetime(startTime.toDate());
        dCTrainingData.setTraining_timezone_hour(i);
        dCTrainingData.setTraining_timezone_name(calendar.getTimeZone().getID());
        dCTrainingData.setBrand_code(Global.CLOUD_BRAND_NAME);
        dCTrainingData.setIn_out(AppEventsConstants.EVENT_PARAM_VALUE_YES);
        dCTrainingData.setUnit(String.valueOf(Global.memberData.getUnit_type()));
        dCTrainingData.setProgram_name(trainingInfo.getSportType());
        dCTrainingData.setTotal_time(trainingInfo.getDuration().getStandardSeconds());
        dCTrainingData.setTotal_distance(trainingInfo.getDistance() / 1000.0f);
        dCTrainingData.setTotal_calories((float) trainingInfo.getCalorie());
        float distance = trainingInfo.getDistance() / 1000.0f;
        long standardSeconds = trainingInfo.getDuration().getStandardSeconds();
        Log.d("outdoor", "distanceInKM = " + distance);
        Log.d("outdoor", "standardHours = " + standardSeconds);
        if (standardSeconds != 0) {
            dCTrainingData.setAvg_speed((distance / standardSeconds) * 60.0f * 60.0f);
        }
        dCTrainingData.setDevice_os_name("Android");
        dCTrainingData.setDevice_os_version(Build.VERSION.RELEASE);
        dCTrainingData.setDevice_model(Build.BRAND);
        dCTrainingData.setDevice_sno(Build.SERIAL);
        dCTrainingData.setMac_address("");
        dCTrainingData.setSportPathJsonStr(jsonSportPath);
        return dCTrainingData;
    }

    private List<double[]> saveAsList(List<LatLng> list) {
        ArrayList arrayList = new ArrayList();
        for (LatLng latLng : list) {
            arrayList.add(new double[]{latLng.latitude, latLng.longitude});
        }
        return arrayList;
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

    private Locale getLocale() {
        Resources resources = getResources();
        resources.getDisplayMetrics();
        return resources.getConfiguration().locale;
    }

    private void goPage(Class<?> cls) {
        Intent intent = new Intent();
        intent.setClass(this, cls);
        intent.addFlags(536870912);
        startActivity(intent);
    }

    private void hidePauseButton() {
        this.btnPause.setVisibility(8);
        this.btnStop.setVisibility(0);
        this.btnRgGo.setVisibility(0);
    }

    private void showPauseButton() {
        this.btnPause.setVisibility(0);
        this.btnStop.setVisibility(8);
        this.btnRgGo.setVisibility(8);
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

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        Uri[] uriArr;
        super.onActivityResult(i, i2, intent);
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
            imageReaderNewInstance.setOnImageAvailableListener(new ImageReader.OnImageAvailableListener() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity.11
                /* JADX WARN: Removed duplicated region for block: B:21:0x0081 A[PHI: r1
                  0x0081: PHI (r1v6 android.hardware.display.VirtualDisplay) = (r1v5 android.hardware.display.VirtualDisplay), (r1v8 android.hardware.display.VirtualDisplay) binds: [B:33:0x00a6, B:20:0x007f] A[DONT_GENERATE, DONT_INLINE]] */
                /* JADX WARN: Removed duplicated region for block: B:38:0x00ad  */
                /* JADX WARN: Removed duplicated region for block: B:40:0x00b2  */
                /* JADX WARN: Removed duplicated region for block: B:43:0x00b9  */
                @Override // android.media.ImageReader.OnImageAvailableListener
                /*
                    Code decompiled incorrectly, please refer to instructions dump.
                */
                public void onImageAvailable(ImageReader imageReader) throws Throwable {
                    Image imageAcquireLatestImage;
                    VirtualDisplay virtualDisplay;
                    VirtualDisplay virtualDisplay2;
                    Image image = null;
                    try {
                        try {
                            imageAcquireLatestImage = imageReader.acquireLatestImage();
                            if (imageAcquireLatestImage != null) {
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
                                        OutdoorMapsActivity outdoorMapsActivity = OutdoorMapsActivity.this;
                                        outdoorMapsActivity.shareImage(outdoorMapsActivity.getString(R.string.shareto));
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
                                    OutdoorMapsActivity.this.onScreenshotTaskOver();
                                }
                            }
                            if (imageAcquireLatestImage != null) {
                                imageAcquireLatestImage.close();
                            }
                            if (imageReader != null) {
                                imageReader.close();
                            }
                            virtualDisplay2 = virtualDisplayCreateVirtualDisplay;
                        } catch (Throwable th) {
                            th = th;
                            if (0 != 0) {
                                image.close();
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
                            OutdoorMapsActivity.this.onScreenshotTaskOver();
                            throw th;
                        }
                    } catch (Exception e2) {
                        e = e2;
                        imageAcquireLatestImage = null;
                    } catch (Throwable th2) {
                        th = th2;
                        if (0 != 0) {
                        }
                        if (imageReader != null) {
                        }
                        virtualDisplay = virtualDisplayCreateVirtualDisplay;
                        if (virtualDisplay != null) {
                        }
                        imageReader.setOnImageAvailableListener(null, null);
                        mediaProjection.stop();
                        OutdoorMapsActivity.this.onScreenshotTaskOver();
                        throw th;
                    }
                    if (virtualDisplay2 != null) {
                        virtualDisplay2.release();
                    }
                    imageReader.setOnImageAvailableListener(null, null);
                    mediaProjection.stop();
                    OutdoorMapsActivity.this.onScreenshotTaskOver();
                }
            }, getBackgroundHandler());
            return;
        }
        if (i == 1 && i2 == -1) {
            ClipData clipData = intent.getClipData();
            if (clipData != null) {
                Log.d("outdoor", "data.clipData = " + clipData);
                int itemCount = clipData.getItemCount();
                uriArr = new Uri[itemCount];
                if (itemCount > 0) {
                    for (int i3 = 0; i3 < itemCount; i3++) {
                        uriArr[i3] = clipData.getItemAt(i3).getUri();
                        Log.d("ccc", uriArr[i3].toString());
                    }
                }
            } else {
                uriArr = new Uri[]{intent.getData()};
                Log.d("outdoor", "data.getData() = " + intent.getData());
            }
            if (Build.VERSION.SDK_INT > 19) {
                List<Map<String, String>> allPathForUri = getAllPathForUri(uriArr);
                this.musicList = allPathForUri;
                Log.d("ccc", allPathForUri.toString());
            } else {
                ArrayList arrayList = new ArrayList();
                this.musicList = arrayList;
                scanMusic(this, uriArr, arrayList);
                Log.d("ccc2", this.musicList.toString());
            }
            this.tvMusicTitle.setText(this.musicList.get(this.posMusic).get(ShareConstants.MEDIA_URI));
        }
        if (i == 66 || i == 67) {
            final Uri data = i == 66 ? this.imageUri : null;
            if (i == 67 && intent != null) {
                Log.d(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
                data = intent.getData();
            }
            if (data != null) {
                Log.d("outdoor", "uri:" + data.getPath());
                runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity.12
                    @Override // java.lang.Runnable
                    public void run() throws IOException {
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(OutdoorMapsActivity.this.getContentResolver(), data);
                            File file = new File(OutdoorMapsActivity.this.getExternalCacheDir(), System.currentTimeMillis() + ".jpg");
                            try {
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                                OutdoorMapsActivity.this.questMainView.upLoadImg(new File(file.getPath()));
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

    private List<Map<String, String>> getAllPathForUri(Uri[] uriArr) {
        ArrayList arrayList = new ArrayList();
        for (Uri uri : uriArr) {
            arrayList.add(getAllInfo(this, uri));
        }
        return arrayList;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startTimer() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        init();
        MyApp.isSporting = true;
        getMyApp().getTimer().schedule(this.timerTask, 0L, 100L);
        Timer timer = new Timer();
        this.ui_update_timer = timer;
        timer.schedule(new TimerTask() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity.13
            @Override // java.util.TimerTask, java.lang.Runnable
            public void run() {
                OutdoorMapsActivity.this.runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.OutdoorMapsActivity.13.1
                    @Override // java.lang.Runnable
                    public void run() {
                        OutdoorMapsActivity.this.trackToMe();
                        OutdoorMapsActivity.this.updateFitInfo();
                    }
                });
            }
        }, 0L, 500L);
        updateFitInfo();
        setSportType();
        AudioManager audioManager = (AudioManager) getSystemService("audio");
        audioManager.setStreamVolume(3, 20, 0);
        int streamVolume = audioManager.getStreamVolume(3);
        int streamMaxVolume = audioManager.getStreamMaxVolume(3);
        audioManager.setStreamVolume(3, streamMaxVolume / 2, 0);
        double d = ((streamVolume * 0.5d) / streamMaxVolume) * 100.0d;
        this.skbVolume.setProgress((int) d);
        initMusicVolume((float) d);
        playMusic();
    }

    public static void scanMusic(Context context, Uri[] uriArr, List<Map<String, String>> list) {
        Uri[] uriArr2 = uriArr;
        list.clear();
        int length = uriArr2.length;
        int i = 0;
        while (i < length) {
            Cursor cursorQuery = context.getContentResolver().query(uriArr2[i], null, null, null, "title_key");
            if (cursorQuery == null) {
                return;
            }
            while (cursorQuery.moveToNext()) {
                if (cursorQuery.getInt(cursorQuery.getColumnIndex("is_music")) != 0) {
                    cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("title"));
                    String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("artist"));
                    String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("album"));
                    long j = cursorQuery.getLong(cursorQuery.getColumnIndex("duration"));
                    String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
                    String coverUri = getCoverUri(context, cursorQuery.getLong(cursorQuery.getColumnIndex("album_id")));
                    String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                    long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex("_size"));
                    cursorQuery.getString(cursorQuery.getColumnIndex("year"));
                    HashMap map = new HashMap();
                    map.put("title", string);
                    map.put("artist", string2);
                    map.put("album", string3);
                    map.put("duration", String.valueOf(j));
                    map.put(ShareConstants.MEDIA_URI, string4);
                    map.put("coverUri", coverUri);
                    map.put("fileName", string5);
                    map.put("fileSize", String.valueOf(j2));
                    list.add(map);
                }
            }
            Log.d("ccc  inside", list.toString());
            cursorQuery.close();
            i++;
            uriArr2 = uriArr;
        }
    }

    private static String getCoverUri(Context context, long j) {
        Cursor cursorQuery = context.getContentResolver().query(Uri.parse("content://media/external/audio/albums/" + j), new String[]{"album_art"}, null, null, null);
        if (cursorQuery == null) {
            return null;
        }
        cursorQuery.moveToNext();
        String string = cursorQuery.getString(0);
        cursorQuery.close();
        return string;
    }

    public static Map<String, String> getAllInfo(Context context, Uri uri) {
        if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri) && isMediaDocument(uri)) {
            String documentId = DocumentsContract.getDocumentId(uri);
            String[] strArrSplit = documentId.split(CertificateUtil.DELIMITER);
            String str = strArrSplit[0];
            Log.d("outdoor", "docId = " + documentId);
            Uri uri2 = null;
            if ("image".equals(str)) {
                uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
            } else if ("video".equals(str)) {
                uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
            } else if ("audio".equals(str)) {
                uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
            }
            return getAllDataColumn(context, uri2, "_id=?", new String[]{strArrSplit[1]});
        }
        return new HashMap();
    }

    public static Map<String, String> getAllDataColumn(Context context, Uri uri, String str, String[] strArr) {
        new String[]{"_data"};
        HashMap map = new HashMap();
        Cursor cursorQuery = null;
        try {
            cursorQuery = context.getContentResolver().query(uri, null, str, strArr, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                if (cursorQuery != null) {
                    cursorQuery.close();
                }
                return map;
            }
            cursorQuery.getInt(cursorQuery.getColumnIndex("is_music"));
            cursorQuery.getLong(cursorQuery.getColumnIndex("_id"));
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("title"));
            String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("artist"));
            String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("album"));
            long j = cursorQuery.getLong(cursorQuery.getColumnIndex("duration"));
            String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("_data"));
            String coverUri = getCoverUri(context, cursorQuery.getLong(cursorQuery.getColumnIndex("album_id")));
            String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
            long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex("_size"));
            cursorQuery.getString(cursorQuery.getColumnIndex("year"));
            map.put("title", string);
            map.put("artist", string2);
            map.put("album", string3);
            map.put("duration", String.valueOf(j));
            map.put(ShareConstants.MEDIA_URI, string4);
            map.put("coverUri", coverUri);
            map.put("fileName", string5);
            map.put("fileSize", String.valueOf(j2));
            Log.d("outdoor", "music = " + map);
            return map;
        } finally {
            if (cursorQuery != null) {
                cursorQuery.close();
            }
        }
    }

    public static String getPath(Context context, Uri uri) {
        Uri uri2 = null;
        if ((Build.VERSION.SDK_INT >= 19) && DocumentsContract.isDocumentUri(context, uri)) {
            if (isExternalStorageDocument(uri)) {
                String[] strArrSplit = DocumentsContract.getDocumentId(uri).split(CertificateUtil.DELIMITER);
                if ("primary".equalsIgnoreCase(strArrSplit[0])) {
                    return Environment.getExternalStorageDirectory() + "/" + strArrSplit[1];
                }
            } else {
                if (isDownloadsDocument(uri)) {
                    return getDataColumn(context, ContentUris.withAppendedId(Uri.parse("content://downloads/public_downloads"), Long.valueOf(DocumentsContract.getDocumentId(uri)).longValue()), null, null);
                }
                if (isMediaDocument(uri)) {
                    String[] strArrSplit2 = DocumentsContract.getDocumentId(uri).split(CertificateUtil.DELIMITER);
                    String str = strArrSplit2[0];
                    if ("image".equals(str)) {
                        uri2 = MediaStore.Images.Media.EXTERNAL_CONTENT_URI;
                    } else if ("video".equals(str)) {
                        uri2 = MediaStore.Video.Media.EXTERNAL_CONTENT_URI;
                    } else if ("audio".equals(str)) {
                        uri2 = MediaStore.Audio.Media.EXTERNAL_CONTENT_URI;
                    }
                    return getDataColumn(context, uri2, "_id=?", new String[]{strArrSplit2[1]});
                }
            }
        } else {
            if (FirebaseAnalytics.Param.CONTENT.equalsIgnoreCase(uri.getScheme())) {
                return getDataColumn(context, uri, null, null);
            }
            if ("file".equalsIgnoreCase(uri.getScheme())) {
                return uri.getPath();
            }
        }
        return null;
    }

    public static String getDataColumn(Context context, Uri uri, String str, String[] strArr) throws Throwable {
        Cursor cursor = null;
        try {
            Cursor cursorQuery = context.getContentResolver().query(uri, new String[]{"_data"}, str, strArr, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("_data"));
                        if (cursorQuery != null) {
                            cursorQuery.close();
                        }
                        return string;
                    }
                } catch (Throwable th) {
                    th = th;
                    cursor = cursorQuery;
                    if (cursor != null) {
                        cursor.close();
                    }
                    throw th;
                }
            }
            if (cursorQuery != null) {
                cursorQuery.close();
            }
            return null;
        } catch (Throwable th2) {
            th = th2;
        }
    }

    public static boolean isExternalStorageDocument(Uri uri) {
        return "com.android.externalstorage.documents".equals(uri.getAuthority());
    }

    public static boolean isDownloadsDocument(Uri uri) {
        return "com.android.providers.downloads.documents".equals(uri.getAuthority());
    }

    public static boolean isMediaDocument(Uri uri) {
        return "com.android.providers.media.documents".equals(uri.getAuthority());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void initMusicVolume(float f) {
        float fLog = (float) (1.0d - (Math.log(100.0f - f) / Math.log(100.0d)));
        List<Map<String, String>> list = this.musicList;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.musicPlay.setVolume(fLog);
    }

    private void playMusic() throws IllegalStateException, IOException, SecurityException, IllegalArgumentException {
        List<Map<String, String>> list = this.musicList;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.musicPlay.setMp3Path(this.musicList.get(this.posMusic).get(ShareConstants.MEDIA_URI));
        this.musicPlay.play(0);
    }

    private void stopMusic() throws IllegalStateException {
        List<Map<String, String>> list = this.musicList;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.musicPlay.stop();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pauseMusic() throws IllegalStateException {
        List<Map<String, String>> list = this.musicList;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.musicPlay.pause();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void resumeMusic() throws IllegalStateException {
        Log.d("ccc", "rrr000");
        List<Map<String, String>> list = this.musicList;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.musicPlay.resume();
    }

    private void nextMusic() {
        List<Map<String, String>> list = this.musicList;
        if (list == null || list.size() <= 0) {
            return;
        }
        this.posMusic = (this.posMusic + 1) % this.musicList.size();
    }

    private void preMusic() {
        List<Map<String, String>> list = this.musicList;
        if (list == null || list.size() <= 0) {
            return;
        }
        int size = ((this.posMusic - 1) + this.musicList.size()) % this.musicList.size();
        this.posMusic = size;
        Log.d("ccc", String.valueOf(size));
    }

    private void init() {
        getMyApp().setTimer(new Timer());
        this.weight = 70.0f;
        MyTimerTask myTimerTask = new MyTimerTask(this.sportTypeSetting.getCurrentSportTypeName());
        this.timerTask = myTimerTask;
        this.trainingInfo = myTimerTask.getTrainingInfo();
        GPSUtil.setOnGpsStatusListener(this.timerTask);
    }

    private MyApp getMyApp() {
        return (MyApp) getApplication();
    }

    private void pauseTimer() {
        MyTimerTask myTimerTask = this.timerTask;
        if (myTimerTask != null) {
            myTimerTask.pasue();
        }
    }

    private void resumeTimer() {
        MyTimerTask myTimerTask = this.timerTask;
        if (myTimerTask != null) {
            myTimerTask.resume();
        }
    }

    private void stopTimer() {
        if (getMyApp().getTimer() != null) {
            getMyApp().getTimer().cancel();
            getMyApp().setTimer(null);
        }
        MyApp.isSporting = false;
    }

    public class MyTimerTask extends TimerTask implements GPSUtil.OnGpsStatusListener {
        private boolean isPasue;
        private DateTime lastTime;
        private LinkedList<LatLng> latLngList;
        private LinkedList<LatLng> latLngListSave;
        private List<TrainingInfo> trainingDetailInfoList;
        private TrainingInfo trainingInfo;
        private int LOG_INTERVAL_TIME = R2.styleable.AppCompatTheme_autoCompleteTextViewStyle;
        int i = 0;
        private double lat = 24.1621d;
        private double lng = 120.635623d;

        public MyTimerTask(String str) {
            TrainingInfo trainingInfo = new TrainingInfo();
            this.trainingInfo = trainingInfo;
            trainingInfo.setStartTime(new DateTime());
            this.trainingInfo.setSportType(str);
            this.lastTime = this.trainingInfo.getStartTime();
            this.trainingDetailInfoList = new ArrayList();
            this.latLngList = new LinkedList<>();
            this.latLngListSave = new LinkedList<>();
        }

        @Override // java.util.TimerTask, java.lang.Runnable
        public void run() {
            if (this.isPasue) {
                return;
            }
            DateTime dateTime = new DateTime();
            Duration duration = new Duration(this.lastTime, dateTime);
            TrainingInfo trainingInfo = this.trainingInfo;
            trainingInfo.setDuration(trainingInfo.getDuration().plus(duration.getMillis()));
            this.lastTime = dateTime;
            synchronized (this.latLngList) {
                if (this.latLngList.size() > 1) {
                    float[] fArr = new float[1];
                    Location.distanceBetween(this.latLngList.get(0).latitude, this.latLngList.get(0).longitude, this.latLngList.get(1).latitude, this.latLngList.get(1).longitude, fArr);
                    if (fArr[0] >= 10.0f && fArr[0] * (duration.getMillis() / 1000.0d) < 100.0d) {
                        TrainingInfo trainingInfo2 = this.trainingInfo;
                        trainingInfo2.setDistance(trainingInfo2.getDistance() + fArr[0]);
                        this.latLngList.remove(0);
                    } else {
                        this.latLngList.remove(1);
                    }
                }
            }
            this.trainingInfo.setPace(new Period((int) ((this.trainingInfo.getDuration().toStandardSeconds().getSeconds() * 1000) / (this.trainingInfo.getDistance() / 1000.0f))));
            this.trainingInfo.setCalorie((this.trainingInfo.getDistance() / 1000.0f) * OutdoorMapsActivity.this.weight * 1.036d);
            if (this.trainingInfo.getDuration().getMillis() % this.LOG_INTERVAL_TIME < 100) {
                TrainingInfo trainingInfoCopy = this.trainingInfo.copy();
                trainingInfoCopy.setStartTime(dateTime);
                if (getLatLngListSave().size() > 0) {
                    LatLng latLng = getLatLngListSave().get(getLatLngListSave().size() - 1);
                    trainingInfoCopy.setLat((float) latLng.latitude);
                    trainingInfoCopy.setLng((float) latLng.longitude);
                }
                this.trainingDetailInfoList.add(trainingInfoCopy);
            }
        }

        @Override // com.dyaco.sole.custom.GPSUtil.OnGpsStatusListener
        public void onLocationChanged(Location location) {
            double latitude = location.getLatitude();
            double longitude = location.getLongitude();
            saveLatLngList(latitude, longitude);
            if (OutdoorMapsActivity.this.timerTask.getLatLngListSave().size() == 1) {
                OutdoorMapsActivity.this.mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(latitude, longitude)));
            }
        }

        private void saveLatLngList(double d, double d2) {
            synchronized (OutdoorMapsActivity.this.timerTask.getLatLngList()) {
                OutdoorMapsActivity.this.timerTask.getLatLngList().add(new LatLng(d, d2));
            }
            synchronized (OutdoorMapsActivity.this.timerTask.getLatLngListSave()) {
                OutdoorMapsActivity.this.timerTask.getLatLngListSave().add(new LatLng(d, d2));
            }
        }

        public void pasue() {
            this.isPasue = true;
        }

        public void resume() {
            this.lastTime = new DateTime();
            this.isPasue = false;
        }

        public TrainingInfo getTrainingInfo() {
            return this.trainingInfo;
        }

        public void setTrainingInfo(TrainingInfo trainingInfo) {
            this.trainingInfo = trainingInfo;
        }

        public List<TrainingInfo> getTrainingDetailInfoList() {
            return this.trainingDetailInfoList;
        }

        public void setTrainingDetailInfoList(List<TrainingInfo> list) {
            this.trainingDetailInfoList = list;
        }

        public LinkedList<LatLng> getLatLngList() {
            return this.latLngList;
        }

        public void setLatLngList(LinkedList<LatLng> linkedList) {
            this.latLngList = linkedList;
        }

        public LinkedList<LatLng> getLatLngListSave() {
            return this.latLngListSave;
        }

        public void setLatLngListSave(LinkedList<LatLng> linkedList) {
            this.latLngListSave = linkedList;
        }
    }
}
