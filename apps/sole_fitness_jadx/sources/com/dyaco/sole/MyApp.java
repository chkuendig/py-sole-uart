package com.dyaco.sole;

import android.app.AlarmManager;
import android.app.Application;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;
import android.util.Log;
import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.multidex.MultiDex;
import com.digifly.cloudapi.data.DCTrainingData;
import com.digifly.cloudapi.data.MemberData;
import com.digifly.dbapi.DbManager;
import com.digifly.dbapi.greeddao_gen.DCTrainingDataDao;
import com.digifly.dbapi.greeddao_gen.MemberDataDao;
import com.dyaco.ideabussdk_sole.protocol.EndWorkoutData;
import com.dyaco.sole.ErrorLog.ErrorLogSave;
import com.dyaco.sole.custom.CalendarUtils;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.ProtocolHandler;
import com.dyaco.sole.custom_view.QuestMainView;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.stetho.Stetho;
import com.google.gson.GsonBuilder;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Timer;
import org.apache.http.client.methods.HttpPost;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;
import org.joda.time.DateTime;
import org.joda.time.Interval;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MyApp extends Application {
    public static final String GARMIN_USER_ACCESSTOKEN_NAME = "GARMIN_USER_ACCESSTOKEN_NAME";
    public static final String GARMIN_USER_ACCESSTOKEN_SECRET_NAME = "GARMIN_USER_ACCESSTOKEN_SECRET_NAME";
    public static int calendar_type = 0;
    public static Timer dataSyncTimer = null;
    public static Timer goalDataSyncTimer = null;
    public static Interval interval = null;
    public static boolean isHRConnect = false;
    public static boolean isSporting;
    public static List<DCTrainingData> trainData;
    private Timer timer;
    public static AlertSchedule alertSchedule = new AlertSchedule();
    public static String omron_access_token = "";
    private static String connect_domain = "data-jp.omronconnect.com";
    private static String APP_ID = "1e3ddd17";
    public static int omron_data_select_index = 0;
    public static String strava_access_token = "";
    public static boolean isWork = false;

    @Override // android.content.ContextWrapper
    protected void attachBaseContext(Context context) {
        super.attachBaseContext(context);
        MultiDex.install(this);
    }

    @Override // android.app.Application
    public void onCreate() throws PackageManager.NameNotFoundException {
        int i;
        int i2;
        String str;
        super.onCreate();
        Global.isMainActivityRun = false;
        ErrorLogSave.VERSION_NAME = ErrorLogSave.getVersionName(getApplicationContext());
        ErrorLogSave.loadErrorList(getApplicationContext());
        Stetho.initialize(Stetho.newInitializerBuilder(this).enableDumpapp(Stetho.defaultDumperPluginsProvider(this)).enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this)).build());
        onAlertSchedule(this);
        Global.BRAND = 0;
        if (Global.BRAND == 0) {
            i = com.soletreadmills.sole.R.string.alert_title;
        } else if (Global.BRAND == 1) {
            i = com.soletreadmills.sole.R.string.s_alert_title;
        } else {
            i = Global.BRAND == 2 ? com.soletreadmills.sole.R.string.x_alert_title : com.soletreadmills.sole.R.string.f_alert_title;
        }
        Global.ALERT_TITLE_RID = i;
        if (Global.BRAND == 0) {
            i2 = com.soletreadmills.sole.R.string.app_name;
        } else if (Global.BRAND == 1) {
            i2 = com.soletreadmills.sole.R.string.s_app_name;
        } else {
            i2 = Global.BRAND == 2 ? com.soletreadmills.sole.R.string.x_app_name : com.soletreadmills.sole.R.string.f_app_name;
        }
        Global.APP_NAME_RID = i2;
        if (Global.BRAND == 0) {
            str = BuildConfig.FLAVOR;
        } else if (Global.BRAND == 1) {
            str = "spirit";
        } else {
            str = Global.BRAND == 2 ? "xterra" : "fuel";
        }
        Global.CLOUD_BRAND_NAME = str;
        isPackageInstalled("com.android.vending");
    }

    public Timer getTimer() {
        return this.timer;
    }

    public void setTimer(Timer timer) {
        this.timer = timer;
    }

    public void onAlertSchedule(Context context) {
        AlertSchedule alertScheduleLoadAlertSchedule = loadAlertSchedule(context);
        alertSchedule = alertScheduleLoadAlertSchedule;
        if (alertScheduleLoadAlertSchedule == null) {
            return;
        }
        alertScheduleLoadAlertSchedule.generateScheduleDateTime(new DateTime(), 2);
        List<DateTime> scheduleDateTimeList = alertSchedule.getScheduleDateTimeList();
        Log.d("ddd", Arrays.toString(scheduleDateTimeList.toArray(new DateTime[0])));
        for (DateTime dateTime : scheduleDateTimeList) {
            Intent intent = new Intent();
            intent.setClass(context, AlarmReceiver.class);
            intent.addCategory(dateTime.toString("yyy-MM-dd HH:mm:ss"));
            intent.putExtra(NotificationCompat.CATEGORY_MESSAGE, "alarmDemo:" + dateTime.toString(CalendarUtils.SQL_DATE_TIME_FORMAT));
            ((AlarmManager) context.getSystemService(NotificationCompat.CATEGORY_ALARM)).setExact(0, dateTime.getMillis(), PendingIntent.getBroadcast(context, 0, intent, 134217728));
            Log.d("ddd ccc", dateTime.toString("yyy-MM-dd HH:mm:ss"));
        }
    }

    private AlertSchedule loadAlertSchedule(Context context) {
        ScheduleData scheduleData = (ScheduleData) new GsonBuilder().setDateFormat(CalendarUtils.SQL_DATE_TIME_FORMAT).create().fromJson(context.getSharedPreferences("alert_schedule", 0).getString("schedule.jsonStr", ""), ScheduleData.class);
        AlertSchedule alertSchedule2 = new AlertSchedule();
        if (scheduleData == null) {
            return null;
        }
        alertSchedule2.setScheduleData(scheduleData);
        return alertSchedule2;
    }

    public void getOmronSearchDate() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar calendar = Calendar.getInstance();
        calendar.set(10, 0);
        calendar.set(12, 0);
        calendar.set(13, 0);
        calendar.set(11, 0);
        String str = simpleDateFormat.format(calendar.getTime());
        calendar.set(10, 23);
        calendar.set(12, 59);
        calendar.set(13, 59);
        String str2 = simpleDateFormat.format(calendar.getTime());
        getOmronVitalData(AppEventsConstants.EVENT_PARAM_VALUE_YES, str, str2, "");
        getOmronVitalData(AppEventsConstants.EVENT_PARAM_VALUE_NO, str, str2, "");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getOmronVitalData(final String str, final String str2, final String str3, final String str4) {
        final String str5 = String.format("https://%s/api/apps/%s/server-code/versions/current/measureData", connect_domain, APP_ID);
        new Thread(new Runnable() { // from class: com.dyaco.sole.MyApp.1
            @Override // java.lang.Runnable
            public void run() throws Throwable {
                String str6;
                HttpURLConnection httpURLConnection;
                String string;
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("deviceCategory", str);
                    jSONObject.put("searchDeviceDateFrom", str2);
                    jSONObject.put("searchDeviceDateTo", str3);
                    if (!"".equals(str4)) {
                        jSONObject.put("paginationKey", str4);
                    }
                } catch (JSONException unused) {
                }
                String string2 = jSONObject.toString();
                HttpURLConnection httpURLConnection2 = null;
                StringBuilder sb = new StringBuilder();
                try {
                    str6 = "Bearer " + MyApp.omron_access_token;
                    httpURLConnection = (HttpURLConnection) new URL(str5).openConnection();
                } catch (Exception unused2) {
                } catch (Throwable th) {
                    th = th;
                }
                try {
                    httpURLConnection.setRequestMethod(HttpPost.METHOD_NAME);
                    httpURLConnection.setRequestProperty("Content-Type", "application/json");
                    httpURLConnection.setRequestProperty("Authorization", str6);
                    httpURLConnection.setDoInput(true);
                    httpURLConnection.setDoOutput(true);
                    httpURLConnection.connect();
                    OutputStream outputStream = httpURLConnection.getOutputStream();
                    BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                    bufferedWriter.write(string2);
                    bufferedWriter.flush();
                    bufferedWriter.close();
                    outputStream.close();
                    BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream(), "utf-8"));
                    while (true) {
                        String line = bufferedReader.readLine();
                        if (line != null) {
                            sb.append(line);
                        } else {
                            try {
                                break;
                            } catch (JSONException unused3) {
                            }
                        }
                    }
                    JSONObject jSONObject2 = new JSONObject(sb.toString()).getJSONObject("returnedValue");
                    try {
                        string = jSONObject2.getString("paginationKey");
                    } catch (JSONException unused4) {
                        string = "";
                    }
                    JSONArray jSONArray = new JSONArray();
                    try {
                        jSONArray = jSONObject2.getJSONArray("deviceModelList");
                    } catch (JSONException unused5) {
                    }
                    if (jSONArray.length() > 0) {
                        for (int i = 0; i < jSONArray.length(); i++) {
                            JSONObject jSONObject3 = jSONArray.getJSONObject(i);
                            String string3 = jSONObject3.getString("deviceModel");
                            JSONArray jSONArray2 = jSONObject3.getJSONArray("deviceSerialIDList");
                            for (int i2 = 0; i2 < jSONArray2.length(); i2++) {
                                JSONObject jSONObject4 = jSONArray2.getJSONObject(i2);
                                String string4 = jSONObject4.getString("deviceSerialID");
                                JSONArray jSONArray3 = jSONObject4.getJSONArray("measureList");
                                for (int i3 = 0; i3 < jSONArray3.length(); i3++) {
                                    JSONObject jSONObject5 = jSONArray3.getJSONObject(i3);
                                    MyApp.this.checkAndSaveOmronData(jSONObject5.getJSONObject("bodyIndexList"), string3, string4, jSONObject5.getString("measureDeviceDateFrom").substring(0, 14));
                                }
                            }
                        }
                    }
                    if (!"".equals(string) && !str4.equals(string)) {
                        MyApp.this.getOmronVitalData(str, str2, str3, str4);
                    } else {
                        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
                        Calendar calendar = Calendar.getInstance();
                        calendar.setTime(simpleDateFormat.parse(str2));
                        calendar.add(5, -1);
                        String str7 = simpleDateFormat.format(calendar.getTime());
                        calendar.set(10, 23);
                        calendar.set(12, 59);
                        calendar.set(13, 59);
                        String str8 = simpleDateFormat.format(calendar.getTime());
                        calendar.setTime(new Date());
                        calendar.set(10, 0);
                        calendar.set(12, 0);
                        calendar.set(13, 0);
                        calendar.set(11, 0);
                        calendar.add(5, -7);
                        if (!simpleDateFormat.format(calendar.getTime()).equals(str7)) {
                            MyApp.this.getOmronVitalData(str, str7, str8, "");
                        }
                    }
                    if (httpURLConnection != null) {
                        httpURLConnection.disconnect();
                    }
                } catch (Exception unused6) {
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    httpURLConnection2 = httpURLConnection;
                    if (httpURLConnection2 != null) {
                        httpURLConnection2.disconnect();
                    }
                    throw th;
                }
            }
        }).start();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void checkAndSaveOmronData(JSONObject jSONObject, String str, String str2, String str3) throws JSONException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
        Calendar calendar = Calendar.getInstance();
        try {
            calendar.setTime(simpleDateFormat.parse(str3));
        } catch (ParseException unused) {
        }
        DCTrainingDataDao dCTrainingDataDao = DbManager.getDCTrainingDataDao();
        if (dCTrainingDataDao.queryBuilder().where(DCTrainingDataDao.Properties.Account.eq(Global.userName), DCTrainingDataDao.Properties.Training_datetime.eq(calendar.getTime()), DCTrainingDataDao.Properties.Trainh_no.eq(str2)).list().size() == 0) {
            double jsonObject = getJsonObject(jSONObject, "257");
            double jsonObject2 = getJsonObject(jSONObject, "259");
            double jsonObject3 = getJsonObject(jSONObject, "262");
            int iIntValue = Double.valueOf(getJsonObject(jSONObject, AppEventsConstants.EVENT_PARAM_VALUE_YES)).intValue();
            int iIntValue2 = Double.valueOf(getJsonObject(jSONObject, ExifInterface.GPS_MEASUREMENT_2D)).intValue();
            int iIntValue3 = Double.valueOf(getJsonObject(jSONObject, ExifInterface.GPS_MEASUREMENT_3D)).intValue();
            EndWorkoutData endWorkoutData = new EndWorkoutData();
            endWorkoutData.setDistance((float) jsonObject2);
            endWorkoutData.setCalories((float) jsonObject3);
            endWorkoutData.setSpeed((float) jsonObject);
            endWorkoutData.setHeartRate(iIntValue2);
            endWorkoutData.setRpm(iIntValue);
            endWorkoutData.setSeconds(iIntValue3);
            dCTrainingDataDao.insert(saveAsDCTrainingData(endWorkoutData, calendar, str, str2));
        }
    }

    private double getJsonObject(JSONObject jSONObject, String str) throws JSONException {
        try {
            return Double.valueOf(jSONObject.getJSONArray(str).getString(0)).doubleValue() * Math.pow(10.0d, Integer.valueOf(r5.getString(2)).intValue());
        } catch (JSONException unused) {
            return 0.0d;
        }
    }

    private DCTrainingData saveAsDCTrainingData(EndWorkoutData endWorkoutData, Calendar calendar, String str, String str2) {
        Calendar calendar2 = Calendar.getInstance();
        int i = ((calendar2.get(15) / 1000) / 60) / 60;
        DCTrainingData dCTrainingData = new DCTrainingData();
        int accout_noFromDB = getAccout_noFromDB();
        dCTrainingData.setAccount(Global.userName);
        dCTrainingData.setAccount_no(accout_noFromDB);
        dCTrainingData.setTraining_datetime(calendar.getTime());
        dCTrainingData.setTraining_timezone_hour(i);
        dCTrainingData.setTraining_timezone_name(calendar2.getTimeZone().getID());
        dCTrainingData.setBrand_code(QuestMainView.OMRON);
        dCTrainingData.setIn_out(ExifInterface.GPS_MEASUREMENT_3D);
        dCTrainingData.setModel_code("Omron");
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
        dCTrainingData.setAvg_rpm(endWorkoutData.getRpm());
        dCTrainingData.setTrainh_no(str2);
        dCTrainingData.setDevice_os_name("Android");
        dCTrainingData.setDevice_os_version(Build.VERSION.RELEASE);
        dCTrainingData.setDevice_model(Build.BRAND);
        dCTrainingData.setDevice_sno(Build.SERIAL);
        dCTrainingData.setDevice_gps_lat((float) Global.gpsLat);
        dCTrainingData.setDevice_gps_lng((float) Global.gpsLon);
        String str3 = ProtocolHandler.protocol.connectedMacAddress;
        return dCTrainingData;
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

    public boolean isPackageInstalled(String str) throws PackageManager.NameNotFoundException {
        try {
            getPackageManager().getPackageInfo(str, 0);
            return true;
        } catch (PackageManager.NameNotFoundException unused) {
            return false;
        }
    }
}
