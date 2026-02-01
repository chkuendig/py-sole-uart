package com.dyaco.sole.activity;

import android.app.ProgressDialog;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.digifly.cloudapi.CloudApi;
import com.digifly.cloudapi.JsonUtil;
import com.digifly.cloudapi.data.DCTrainingData;
import com.digifly.cloudapi.data.ResponseDataCollection;
import com.digifly.cloudapi.listener.DCUploadTrainingDataListener;
import com.digifly.dbapi.DbManager;
import com.digifly.dbapi.greeddao_gen.DCTrainingDataDao;
import com.dyaco.ideabussdk_sole.library.MyActivity;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.adapter.ConnectionListAdapter;
import com.dyaco.sole.custom.CalendarUtils;
import com.dyaco.sole.custom.DeviceModelList;
import com.dyaco.sole.custom.Fuel_DeviceModelList;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.ProtocolHandler;
import com.dyaco.sole.custom.Sole_DeviceModelList;
import com.dyaco.sole.custom.Spirit_DeviceModelList;
import com.dyaco.sole.custom.Xterra_DeviceModelList;
import com.dyaco.sole.database.UserData;
import com.dyaco.sole.database.UserDataDB;
import com.dyaco.sole.database.WorkoutData;
import com.dyaco.sole.database.WorkoutDataDB;
import com.facebook.appevents.AppEventsConstants;
import com.pnikosis.materialishprogress.ProgressWheel;
import com.soletreadmills.sole.R;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import okhttp3.HttpUrl;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action0;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/* loaded from: classes.dex */
public class ExportUserDialog extends MyActivity implements View.OnClickListener, AdapterView.OnItemClickListener {
    private ConnectionListAdapter adapter;
    private ProgressWheel circle_progress;
    private TextView connection_cancel_textview;
    private TextView connection_connect_textview;
    private ListView connection_listView;
    private TextView connection_title_textview;
    private RelativeLayout exportUserLayout;
    private TextView info_progress;
    ProgressDialog mProgressDialog;
    int sum = 0;
    int num = 0;

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void initFragments() {
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity, android.app.Activity
    protected void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setRequestedOrientation(0);
        setContentView(R.layout.dialog_export_user);
        DbManager.getInstance(this);
        initFragments();
        findViews();
        initParams();
        setListeners();
    }

    @Override // android.app.Activity
    public void onStart() {
        super.onStart();
        Global.nowActivityName = ExportUserDialog.class.getName();
        Global.printLog("d", "LanguageDialog", "onStart - " + Global.nowActivityName);
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity, android.app.Activity
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void findViews() {
        this.connection_title_textview = (TextView) findViewById(R.id.connection_title_textview);
        this.connection_listView = (ListView) findViewById(R.id.connection_listView);
        this.connection_cancel_textview = (TextView) findViewById(R.id.connection_cancel_textview);
        this.connection_connect_textview = (TextView) findViewById(R.id.connection_connect_textview);
        this.exportUserLayout = (RelativeLayout) findViewById(R.id.exportUser_layout);
        this.circle_progress = (ProgressWheel) findViewById(R.id.circle_progress);
        this.info_progress = (TextView) findViewById(R.id.info_progress);
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void initParams() {
        this.connection_title_textview.setText(R.string.export_user_data);
        ConnectionListAdapter connectionListAdapter = new ConnectionListAdapter(this);
        this.adapter = connectionListAdapter;
        this.connection_listView.setAdapter((ListAdapter) connectionListAdapter);
        addExportableUser();
        this.connection_connect_textview.setText(R.string.confirm);
        findViewById(R.id.connection_refresh_imageview).setVisibility(8);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void addExportableUser() {
        List<String> exportedUsersFromSPF = getExportedUsersFromSPF();
        Iterator<UserData> it = new UserDataDB(this).getAllUserData().iterator();
        while (it.hasNext()) {
            UserData next = it.next();
            if (!exportedUsersFromSPF.contains(next.getName())) {
                this.adapter.addConnectionData(next.getName(), next.getName(), 0);
            }
        }
    }

    private List<String> getExportedUsersFromSPF() {
        return JsonUtil.parseExportedUsers(getSharedPreferences("exported_users", 0).getString("users", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
    }

    private void handleDeviceModel2(int i) {
        int i2 = Global.BRAND;
        if (i2 == 0) {
            Sole_DeviceModelList.handleDeviceModelExportUser(i);
            return;
        }
        if (i2 == 1) {
            Spirit_DeviceModelList.handleDeviceModelExportUser(i);
        } else if (i2 == 2) {
            Xterra_DeviceModelList.handleDeviceModelExportUser(i);
        } else {
            if (i2 != 3) {
                return;
            }
            Fuel_DeviceModelList.handleDeviceModelExportUser(i);
        }
    }

    @Override // com.dyaco.ideabussdk_sole.library.MyActivity
    protected void setListeners() {
        this.connection_cancel_textview.setOnClickListener(this);
        this.connection_connect_textview.setOnClickListener(this);
        this.connection_listView.setOnItemClickListener(this);
        this.connection_cancel_textview.setOnLongClickListener(new View.OnLongClickListener() { // from class: com.dyaco.sole.activity.ExportUserDialog.1
            @Override // android.view.View.OnLongClickListener
            public boolean onLongClick(View view) {
                ErrorLogSave.addErrorString(ExportUserDialog.this.getApplicationContext(), ErrorLogSave.LONG_CLICK, "ExportUserDialog_cancel", ErrorLogSave.LONG_CLICK);
                return true;
            }
        });
    }

    private void setExportedUsersFSPF(boolean z) {
        getSharedPreferences("exported_users", 0).edit().putBoolean("hadExportData", z).apply();
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.connection_cancel_textview /* 2131231027 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "ExportUserDialog_cancel", ErrorLogSave.CLICK);
                setResult(-1);
                finish();
                break;
            case R.id.connection_connect_textview /* 2131231028 */:
                ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "ExportUserDialog_connect", ErrorLogSave.CLICK);
                String selectedMac = this.adapter.getSelectedMac();
                if (selectedMac != null) {
                    this.circle_progress.setVisibility(0);
                    this.info_progress.setVisibility(0);
                    exportWorkoutDataToNewDB(selectedMac);
                    break;
                }
                break;
        }
    }

    private void exportWorkoutDataToNewDB(final String str) {
        Observable.create(new Observable.OnSubscribe<DCTrainingData>() { // from class: com.dyaco.sole.activity.ExportUserDialog.5
            @Override // rx.functions.Action1
            public void call(Subscriber<? super DCTrainingData> subscriber) {
                DCTrainingDataDao dCTrainingDataDao = DbManager.getDCTrainingDataDao();
                ArrayList<WorkoutData> allDateData = new WorkoutDataDB(ExportUserDialog.this).getAllDateData(str);
                ExportUserDialog.this.sum = allDateData.size();
                Iterator<WorkoutData> it = allDateData.iterator();
                while (it.hasNext()) {
                    DCTrainingData dCTrainingDataConvertToTrainingData = ExportUserDialog.this.convertToTrainingData(it.next());
                    dCTrainingDataDao.insert(dCTrainingDataConvertToTrainingData);
                    ExportUserDialog.this.updateTrainingDataToCloud(dCTrainingDataConvertToTrainingData);
                    subscriber.onNext(dCTrainingDataConvertToTrainingData);
                }
                subscriber.onCompleted();
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action1<DCTrainingData>() { // from class: com.dyaco.sole.activity.ExportUserDialog.2
            @Override // rx.functions.Action1
            public void call(DCTrainingData dCTrainingData) {
                ExportUserDialog.this.num++;
                ExportUserDialog.this.info_progress.setText(String.valueOf(ExportUserDialog.this.num + " / " + ExportUserDialog.this.sum));
            }
        }, new Action1<Throwable>() { // from class: com.dyaco.sole.activity.ExportUserDialog.3
            @Override // rx.functions.Action1
            public void call(Throwable th) {
            }
        }, new Action0() { // from class: com.dyaco.sole.activity.ExportUserDialog.4
            @Override // rx.functions.Action0
            public void call() {
                SharedPreferences sharedPreferences = ExportUserDialog.this.getSharedPreferences("exported_users", 0);
                List<String> exportedUsers = JsonUtil.parseExportedUsers(sharedPreferences.getString("users", HttpUrl.PATH_SEGMENT_ENCODE_SET_URI));
                exportedUsers.add(str);
                sharedPreferences.edit().putString("users", JsonUtil.toJsonExportedUsers(exportedUsers)).apply();
                ExportUserDialog.this.circle_progress.setVisibility(8);
                ExportUserDialog.this.info_progress.setVisibility(8);
                ExportUserDialog.this.adapter.clearAllData();
                ExportUserDialog.this.addExportableUser();
                if (ExportUserDialog.this.adapter.getCount() == 0) {
                    ExportUserDialog.this.setResult(-1);
                    ExportUserDialog.this.finish();
                }
            }
        });
    }

    private ProgressDialog createProgressDialog() {
        ProgressDialog progressDialog = new ProgressDialog(this, R.style.MyDialog);
        this.mProgressDialog = progressDialog;
        progressDialog.setTitle("export user data");
        this.mProgressDialog.setMessage("doing ...");
        this.mProgressDialog.setMax(100);
        this.mProgressDialog.setProgressStyle(1);
        return this.mProgressDialog;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void updateTrainingDataToCloud(final DCTrainingData dCTrainingData) {
        CloudApi cloudApiCreateInstance = CloudApi.createInstance(this);
        cloudApiCreateInstance.setDCUploadTrainingDataListener(new DCUploadTrainingDataListener() { // from class: com.dyaco.sole.activity.ExportUserDialog.6
            @Override // com.digifly.cloudapi.listener.DCUploadTrainingDataListener
            public void onSuccess(ResponseDataCollection responseDataCollection) {
                String str = responseDataCollection.getSys_response_data().get("trainh_no");
                Log.d("cloudapi   trainh_no  ", str);
                DCTrainingDataDao dCTrainingDataDao = DbManager.getDCTrainingDataDao();
                DCTrainingData dCTrainingDataLoad = dCTrainingDataDao.load(dCTrainingData.getTrainingId());
                dCTrainingDataLoad.setTrainh_no(str);
                dCTrainingDataDao.update(dCTrainingDataLoad);
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
        cloudApiCreateInstance.callDCUploadTrainingData(dCTrainingData);
    }

    public DCTrainingData convertToTrainingData(WorkoutData workoutData) {
        DCTrainingData dCTrainingData = new DCTrainingData();
        dCTrainingData.setAccount(Global.memberData.getAccount());
        dCTrainingData.setAccount_no(Global.memberData.getAccount_no());
        dCTrainingData.setPassword(Global.memberData.getPassword());
        Date date = DateTime.parse(workoutData.getStartDate(), DateTimeFormat.forPattern(CalendarUtils.SQL_DATE_TIME_FORMAT)).toDate();
        dCTrainingData.setTraining_datetime(date);
        Calendar calendar = Calendar.getInstance(getLocale());
        calendar.setTimeInMillis(date.getTime());
        dCTrainingData.setTraining_timezone_hour(((calendar.get(15) / 1000) / 60) / 60);
        dCTrainingData.setTraining_timezone_name(calendar.getTimeZone().getID());
        dCTrainingData.setTotal_time(workoutData.getDuration());
        dCTrainingData.setTotal_distance(workoutData.getDistance());
        dCTrainingData.setTotal_calories(workoutData.getCalories());
        dCTrainingData.setAvg_hr(workoutData.getAvgHR());
        dCTrainingData.setAvg_speed(workoutData.getAvgSpeed());
        dCTrainingData.setAvg_rpm(workoutData.getAvgRPM());
        dCTrainingData.setAvg_watt(workoutData.getAvgWatts());
        dCTrainingData.setAvg_level(workoutData.getAvgLevel());
        dCTrainingData.setAvg_met(workoutData.getAvgMETs());
        dCTrainingData.setModel_code(workoutData.getDeviceModelName());
        dCTrainingData.setBrand_code(Global.CLOUD_BRAND_NAME);
        dCTrainingData.setCategory_code(workoutData.getAvgSpeed() > ((float) workoutData.getAvgRPM()) ? AppEventsConstants.EVENT_PARAM_VALUE_NO : AppEventsConstants.EVENT_PARAM_VALUE_YES);
        dCTrainingData.setBrand_type(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        dCTrainingData.setIn_out(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        dCTrainingData.setUnit(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        dCTrainingData.setSales_version(AppEventsConstants.EVENT_PARAM_VALUE_NO);
        int iSearchDeviceName = searchDeviceName(DeviceModelList.DEVICE_NAME_LIST, workoutData.getDeviceModelName());
        if (iSearchDeviceName == -1) {
            iSearchDeviceName = 0;
        }
        handleDeviceModel2(iSearchDeviceName);
        int iSearchProgramTitleTexts = searchProgramTitleTexts(DeviceModelList.programAllOldResIDExportUser, workoutData.getProgramNameRes());
        dCTrainingData.setProgram_name(DeviceModelList.programNamesExportUser[searchProgramTitleTexts(DeviceModelList.programTitleTextsExportUser, DeviceModelList.programAllTitleTextsExportUser[iSearchProgramTitleTexts != -1 ? iSearchProgramTitleTexts : 0])]);
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

    private int searchDeviceName(String[] strArr, String str) {
        for (int i = 0; i < strArr.length; i++) {
            if (strArr[i].equalsIgnoreCase(str)) {
                return i;
            }
        }
        return -1;
    }

    private int searchProgramTitleTexts(int[] iArr, int i) {
        for (int i2 = 0; i2 < iArr.length; i2++) {
            if (iArr[i2] == i) {
                return i2;
            }
        }
        return -1;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public void onItemClick(AdapterView<?> adapterView, View view, int i, long j) {
        this.connection_connect_textview.setEnabled(true);
        this.adapter.setSelected(i);
        ErrorLogSave.addErrorString(getApplicationContext(), ErrorLogSave.CLICK, "ExportUserDialog_onItemClick", "selectItem:" + this.adapter.getSelected());
    }
}
