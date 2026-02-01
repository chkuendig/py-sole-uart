package com.dyaco.sole.activity;

import android.bluetooth.BluetoothDevice;
import android.content.ContentValues;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.view.animation.RotateAnimation;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AlertDialog;
import com.digifly.cloudapi.CloudApi;
import com.digifly.cloudapi.data.DCConnectInfoData;
import com.digifly.cloudapi.data.MemberData;
import com.digifly.cloudapi.data.ResponseDataCollection;
import com.digifly.cloudapi.listener.DCConnectInfoListener;
import com.digifly.dbapi.DbManager;
import com.digifly.dbapi.greeddao_gen.MemberDataDao;
import com.dyaco.ideabussdk_sole.library.MyActivity;
import com.dyaco.ideabussdk_sole.protocol.SoleProtocol;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.adapter.ConnectionListAdapter;
import com.dyaco.sole.custom.CalendarUtils;
import com.dyaco.sole.custom.DeviceModelList;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.ProtocolHandler;
import com.dyaco.sole.custom_view.ErrorDialog;
import com.dyaco.sole.custom_view.QuestMainView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.AnalyticsEvents;
import com.pnikosis.materialishprogress.ProgressWheel;
import com.soletreadmills.sole.R;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

/* loaded from: classes.dex */
public class ConnectionDialog extends MyActivity implements View.OnClickListener, AdapterView.OnItemClickListener, ProtocolHandler.OnConnectionStateListener, ProtocolHandler.OnBluetoothStateListener, ProtocolHandler.OnBleScanResultListener, ProtocolHandler.OnClassicScanResultListener {
    private static final int CAMERA = 66;
    private static final int PHOTO = 67;
    private ConnectionListAdapter adapter;
    private ProgressWheel circle_progress;
    private String connectMacAddress;
    private int connectionState;
    private TextView connection_cancel_textview;
    private TextView connection_connect_textview;
    private ListView connection_listView;
    private ImageView connection_refresh_imageview;
    private ErrorDialog errorDialog;
    public Uri imageUri;
    int pos;
    private QuestMainView questMainView;
    private Handler handler = new Handler();
    private Runnable scanRunnable = new Runnable() { // from class: com.dyaco.sole.activity.ConnectionDialog.4
        @Override // java.lang.Runnable
        public void run() {
            ConnectionDialog.this.startScan();
        }
    };

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void initFragments() {
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(0);
        setContentView(R.layout.dialog_connection);
        initFragments();
        findViews();
        initParams();
        setListeners();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        Global.nowActivityName = ConnectionDialog.class.getName();
        Global.printLog("d", "ConnectionDialog", "onStart - " + Global.nowActivityName);
        this.connectionState = 0;
        if (ProtocolHandler.protocol == null) {
            return;
        }
        ProtocolHandler.protocol.addOnBluetoothStateListener(this);
        ProtocolHandler.protocol.addOnConnectionStateListener(this);
        ProtocolHandler.protocol.setOnBleScanResultListener(this);
        ProtocolHandler.protocol.setOnClassicScanResultListener(this);
        startScan();
    }

    @Override // android.app.Activity
    public void onStop() {
        super.onStop();
        this.handler.removeCallbacks(this.scanRunnable);
        if (ProtocolHandler.protocol != null) {
            ProtocolHandler.protocol.removeOnBluetoothStateListener(this);
            ProtocolHandler.protocol.removeOnConnectionStateListener(this);
        }
    }

    @Override // android.app.Activity
    public void onBackPressed() {
        setResultState();
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    public void showErrorLog(final int i, final String str) {
        runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.ConnectionDialog.1
            @Override // java.lang.Runnable
            public void run() {
                ConnectionDialog.this.errorDialog.setVisibility(0);
                ConnectionDialog.this.errorDialog.setShowDownloadAppViews(ErrorLogSave.ERROR_0005.equals(str));
                ConnectionDialog.this.errorDialog.initView(ConnectionDialog.this.getString(i), new View.OnClickListener() { // from class: com.dyaco.sole.activity.ConnectionDialog.1.1
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ErrorLogSave.sendErrorList(ConnectionDialog.this.questMainView.getAccount(), ConnectionDialog.this.getApplicationContext());
                        ConnectionDialog.this.questMainView.showQA(QuestMainView.CONNECT_BLE, str);
                        ConnectionDialog.this.questMainView.setVisibility(0);
                    }
                }, new View.OnClickListener() { // from class: com.dyaco.sole.activity.ConnectionDialog.1.2
                    @Override // android.view.View.OnClickListener
                    public void onClick(View view) {
                        ConnectionDialog.this.errorDialog.setVisibility(8);
                    }
                });
            }
        });
    }

    public void showCameraDialog() {
        new AlertDialog.Builder(this, R.style.myDialog).setSingleChoiceItems(new String[]{"Camera", "Album"}, -1, new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.activity.ConnectionDialog.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                if (i == 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("description", "Image capture by camera");
                    contentValues.put("mime_type", "image/jpeg");
                    ConnectionDialog connectionDialog = ConnectionDialog.this;
                    connectionDialog.imageUri = connectionDialog.getContentResolver().insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
                    Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
                    intent.putExtra("output", ConnectionDialog.this.imageUri);
                    intent.putExtra("android.intent.extra.videoQuality", 1);
                    ConnectionDialog.this.startActivityForResult(intent, 66);
                } else {
                    Intent intent2 = new Intent();
                    intent2.setType("image/*");
                    intent2.setAction("android.intent.action.PICK");
                    ConnectionDialog.this.startActivityForResult(Intent.createChooser(intent2, "Choose Image File"), 67);
                }
                dialogInterface.dismiss();
            }
        }).show();
    }

    @Override // android.app.Activity
    protected void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 66 || i == 67) {
            final Uri data = i == 66 ? this.imageUri : null;
            if (i == 67 && intent != null) {
                Log.d(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO);
                data = intent.getData();
            }
            if (data != null) {
                Log.d(TAG, "uri:" + data.getPath());
                runOnUiThread(new Runnable() { // from class: com.dyaco.sole.activity.ConnectionDialog.3
                    @Override // java.lang.Runnable
                    public void run() throws IOException {
                        try {
                            Bitmap bitmap = MediaStore.Images.Media.getBitmap(ConnectionDialog.this.getContentResolver(), data);
                            File file = new File(ConnectionDialog.this.getExternalCacheDir(), System.currentTimeMillis() + ".jpg");
                            try {
                                BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
                                bitmap.compress(Bitmap.CompressFormat.JPEG, 80, bufferedOutputStream);
                                bufferedOutputStream.flush();
                                bufferedOutputStream.close();
                                ConnectionDialog.this.questMainView.upLoadImg(new File(file.getPath()));
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

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void findViews() {
        this.connection_listView = (ListView) findViewById(R.id.connection_listView);
        this.connection_refresh_imageview = (ImageView) findViewById(R.id.connection_refresh_imageview);
        this.connection_cancel_textview = (TextView) findViewById(R.id.connection_cancel_textview);
        this.connection_connect_textview = (TextView) findViewById(R.id.connection_connect_textview);
        this.circle_progress = (ProgressWheel) findViewById(R.id.circle_progress);
        this.questMainView = (QuestMainView) findViewById(R.id.questMainView);
        this.errorDialog = (ErrorDialog) findViewById(R.id.errorDialog);
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void initParams() {
        ConnectionListAdapter connectionListAdapter = new ConnectionListAdapter(this);
        this.adapter = connectionListAdapter;
        this.connection_listView.setAdapter((ListAdapter) connectionListAdapter);
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void setListeners() {
        this.connection_refresh_imageview.setOnClickListener(this);
        this.connection_cancel_textview.setOnClickListener(this);
        this.connection_connect_textview.setOnClickListener(this);
        this.connection_listView.setOnItemClickListener(this);
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) throws IOException {
        switch (view.getId()) {
            case R.id.connection_cancel_textview /* 2131231027 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "connectionDialog_cancel_btn", ErrorLogSave.CLICK);
                setResultState();
                break;
            case R.id.connection_connect_textview /* 2131231028 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "connectionDialog_connect_btn", ErrorLogSave.CLICK);
                connect();
                this.connectMacAddress = this.adapter.getSelectedMac();
                int selectedType = this.adapter.getSelectedType();
                if (selectedType == 0) {
                    ProtocolHandler.protocol.connectClassic(this.adapter.getSelectedDevice());
                    break;
                } else if (selectedType == 1) {
                    ProtocolHandler.protocol.connectBle(this.connectMacAddress);
                    break;
                }
                break;
            case R.id.connection_refresh_imageview /* 2131231031 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "connectionDialog_refresh_btn", ErrorLogSave.CLICK);
                startScan();
                break;
        }
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.connection_connect_textview.setEnabled(true);
        this.adapter.setSelected(i);
        ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "connectionDialog_onItemClick_btn", "select_item:" + this.adapter.mConnectionData.get(i).get("name") + "_mac:" + this.adapter.mConnectionData.get(i).get("mac") + "_rssi:" + this.adapter.mConnectionData.get(i).get("rssi"));
    }

    private void setResultState() {
        int i = this.connectionState;
        if (i == 0) {
            stopScan();
            setResult(0);
        } else if (i == 1) {
            ProtocolHandler.protocol.disconnect();
            disconnect();
            return;
        } else if (i == 2) {
            setResult(-1);
        }
        finish();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void startScan() {
        this.pos = 0;
        this.circle_progress.setVisibility(8);
        this.connection_refresh_imageview.setEnabled(true);
        this.connection_listView.setEnabled(true);
        this.connection_connect_textview.setEnabled(false);
        if (!ProtocolHandler.protocol.enableBluetoothLE(this) && !ProtocolHandler.protocol.enableBluetoothClassic(this)) {
            Toast.makeText(this, "Device not support BLE!", 0).show();
            showErrorLog(R.string.error_0005, ErrorLogSave.ERROR_0005);
            return;
        }
        this.adapter.clearAllData();
        ProtocolHandler.protocol.startClassicScan();
        ProtocolHandler.protocol.startBleScan();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, 1, 0.5f, 1, 0.5f);
        rotateAnimation.setDuration(1000L);
        rotateAnimation.setRepeatCount(10);
        this.connection_refresh_imageview.startAnimation(rotateAnimation);
    }

    private void stopScan() {
        ProtocolHandler.protocol.stopClassicScan();
        ProtocolHandler.protocol.stopBleScan();
        this.connection_refresh_imageview.clearAnimation();
    }

    private void connect() {
        this.connectionState = 1;
        this.circle_progress.setVisibility(0);
        this.connection_refresh_imageview.setEnabled(false);
        this.connection_listView.setEnabled(false);
        this.connection_connect_textview.setEnabled(false);
        stopScan();
    }

    private void disconnect() {
        this.connectionState = 0;
        this.handler.postDelayed(this.scanRunnable, 2000L);
    }

    @Override // com.dyaco.sole.custom.ProtocolHandler.OnBluetoothStateListener
    public void onBluetoothState(boolean z) {
        Log.d("ConnectionDialog", "onBluetoothState --- " + z);
        if (z) {
            startScan();
        }
    }

    @Override // com.dyaco.sole.custom.ProtocolHandler.OnClassicScanResultListener
    public void onClassicScanResult(BluetoothDevice bluetoothDevice, int i) {
        int i2 = this.pos + 1;
        this.pos = i2;
        String.valueOf(i2);
        this.adapter.addConnectionDevice(bluetoothDevice, i);
    }

    @Override // com.dyaco.sole.custom.ProtocolHandler.OnBleScanResultListener
    public void onBleScanResult(String str, String str2, int i) {
        Log.d("ConnectionDialog", "onBleScanResult name = " + str2);
        this.adapter.addConnectionData(str, str2, i);
    }

    /* renamed from: com.dyaco.sole.activity.ConnectionDialog$7, reason: invalid class name */
    static /* synthetic */ class AnonymousClass7 {
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
        int i = AnonymousClass7.$SwitchMap$com$dyaco$ideabussdk_sole$protocol$SoleProtocol$ConnectState[connectState.ordinal()];
        if (i != 2) {
            if (i == 3 || i == 4) {
                this.connectionState = 0;
                disconnect();
                SoleProtocol.ConnectState connectState2 = SoleProtocol.ConnectState.Disconnect;
                int i2 = R.string.device_failed;
                Toast.makeText(this, connectState == connectState2 ? R.string.device_failed : R.string.device_timeout, 0).show();
                Context applicationContext = getApplicationContext();
                if (connectState != SoleProtocol.ConnectState.Disconnect) {
                    i2 = R.string.device_timeout;
                }
                ErrorLogSave.addErrorString(applicationContext, ErrorLogSave.DISCONNECT, ErrorLogSave.DISCONNECT, getString(i2));
                showErrorLog(R.string.error_0005, ErrorLogSave.ERROR_0005);
                return;
            }
            return;
        }
        if (ProtocolHandler.protocol.deviceBrand != Global.BRAND) {
            ProtocolHandler.protocol.disconnect();
            showBaseAlert(Global.ALERT_TITLE_RID, R.string.confirm, true, "Unavailable model", new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.activity.ConnectionDialog.5
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i3) {
                    ConnectionDialog.this.showErrorLog(R.string.error_0005, ErrorLogSave.ERROR_0005);
                }
            });
            return;
        }
        ProtocolHandler.protocol.connectedMacAddress = this.connectMacAddress;
        ProtocolHandler.protocol.setAutoConnectedMacAddress(ProtocolHandler.protocol.connectedMacAddress);
        updateConnectInfoToCloud();
        SharedPreferences.Editor spfEditor = Global.getSpfEditor(this);
        spfEditor.putString("macAddress", this.connectMacAddress);
        spfEditor.commit();
        Log.d("ConnectionDialog", "ConnectionDialog 連線儲存address = " + this.connectMacAddress);
        this.connectionState = 2;
        setResultState();
        try {
            ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CONNECT, "connectionDialog_onConnectState", "deviceName:" + ProtocolHandler.protocol.deviceName + "deviceModel:" + ProtocolHandler.protocol.deviceModel + "_deviceSalesVersion:" + ProtocolHandler.protocol.salesVersion + ErrorLogSave.SALE_VERSION_INFO + "_deviceType:" + ProtocolHandler.protocol.deviceType + ErrorLogSave.DEVICE_TYPE_INFO + "_deviceUnit:" + ProtocolHandler.protocol.deviceUnit + ErrorLogSave.DEVICE_UNIT_INFO);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void updateConnectInfoToCloud() {
        if (Global.userName.equals(getResources().getString(R.string.guest))) {
            return;
        }
        String memberPassword = getMemberPassword();
        CloudApi cloudApi = CloudApi.getInstance(this);
        DCConnectInfoData dCConnectInfoData = new DCConnectInfoData();
        dCConnectInfoData.setAccount(Global.userName);
        dCConnectInfoData.setPassword(memberPassword);
        Calendar calendar = Calendar.getInstance(getLocale());
        String calendarFormat = CalendarUtils.getCalendarFormat(calendar.getTime(), CalendarUtils.SQL_DATE_TIME_FORMAT);
        Calendar calendar2 = Calendar.getInstance(getLocale());
        calendar2.setTimeInMillis(calendar.getTimeInMillis());
        int i = ((calendar2.get(15) / 1000) / 60) / 60;
        dCConnectInfoData.setConnect_time(calendarFormat);
        dCConnectInfoData.setConnect_timezone_hour(i);
        dCConnectInfoData.setConnect_timezone_name(calendar2.getTimeZone().getID());
        dCConnectInfoData.setBrand_code(Global.CLOUD_BRAND_NAME);
        dCConnectInfoData.setBrand_type(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        Log.d(TAG, "ProtocolHandler.protocol.deviceModel] = " + ProtocolHandler.protocol.deviceModel);
        Log.d(TAG, "DeviceModelList.DEVICE_NAME_LIST[ProtocolHandler.protocol.deviceModel] = " + DeviceModelList.DEVICE_NAME_LIST[ProtocolHandler.protocol.deviceModel]);
        dCConnectInfoData.setModel_code(DeviceModelList.DEVICE_NAME_LIST[ProtocolHandler.protocol.deviceModel]);
        dCConnectInfoData.setCategory_code(String.valueOf(ProtocolHandler.protocol.deviceType));
        dCConnectInfoData.setUnit(String.valueOf(ProtocolHandler.protocol.deviceUnit));
        dCConnectInfoData.setSales_version(String.valueOf(ProtocolHandler.protocol.salesVersion));
        dCConnectInfoData.setDevice_os_name("Android");
        dCConnectInfoData.setDevice_os_version(Build.VERSION.RELEASE);
        dCConnectInfoData.setDevice_model(Build.BRAND);
        dCConnectInfoData.setDevice_sno(Build.SERIAL);
        dCConnectInfoData.setMac_address("5a:79:60:4a:80:55");
        cloudApi.setDCConnectInfoListener(new DCConnectInfoListener() { // from class: com.dyaco.sole.activity.ConnectionDialog.6
            @Override // com.digifly.cloudapi.listener.DCConnectInfoListener
            public void onSuccess(ResponseDataCollection responseDataCollection) {
                Log.d(MyActivity.TAG, "callDCConnectInfo  responseMessage = " + responseDataCollection);
            }

            @Override // com.digifly.cloudapi.listener.DCConnectInfoListener
            public void onFail(ResponseDataCollection responseDataCollection) {
                Log.d(MyActivity.TAG, "callDCConnectInfo  onFail  responseMessage = " + responseDataCollection);
            }

            @Override // com.digifly.cloudapi.listener.DCConnectInfoListener
            public void onError(String str) {
                Log.d(MyActivity.TAG, "err = " + str);
            }
        });
        cloudApi.callDCConnectInfo(dCConnectInfoData);
    }

    private String getMemberPassword() {
        QueryBuilder<MemberData> queryBuilder = DbManager.getMemberDataDao().queryBuilder();
        queryBuilder.where(MemberDataDao.Properties.Account.eq(Global.userName), new WhereCondition[0]);
        List<MemberData> list = queryBuilder.list();
        return (list == null || list.size() != 1) ? "" : list.get(0).getPassword();
    }

    private Locale getLocale() {
        Resources resources = getResources();
        resources.getDisplayMetrics();
        return resources.getConfiguration().locale;
    }
}
