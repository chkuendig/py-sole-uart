package com.dyaco.sole.ErrorLog;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Display;
import android.view.WindowManager;
import com.digifly.cloudapi.data.MemberData;
import com.digifly.dbapi.DbManager;
import com.digifly.dbapi.greeddao_gen.MemberDataDao;
import com.dyaco.sole.Execute;
import com.dyaco.sole.custom.CalendarUtils;
import com.dyaco.sole.custom.Global;
import com.dyaco.sole.custom.ProtocolHandler;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.Response;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

/* loaded from: classes.dex */
public class ErrorLogSave {
    public static final String CLICK = "click";
    public static final String CONNECT = "connect";
    public static final String DEVICE_TYPE_INFO = "(0=跑步機/1=腳踏車/2=橢圓機)";
    public static final String DEVICE_UNIT_INFO = "(0=公制/1=英制)";
    public static final String DISCONNECT = "disconnect";
    public static final String ERROR_0001 = "0001";
    public static final String ERROR_0002 = "0002";
    public static final String ERROR_0003 = "0003";
    public static final String ERROR_0004 = "0004";
    public static final String ERROR_0005 = "0005";
    public static final String ERROR_0006 = "0006";
    public static final String ERROR_0007 = "0007";
    public static final String ERROR_0008 = "0008";
    public static final String ERROR_0009 = "0009";
    public static final String ERROR_0010 = "0010";
    public static final String ERROR_0011 = "0011";
    public static final String ERROR_0012 = "0012";
    public static final String ERROR_0013 = "0013";
    public static final String ERROR_0014 = "0014";
    public static final String ERROR_0015 = "0015";
    public static final String ERROR_0016 = "0016";
    public static final String ERROR_SAVE = "error_save_2";
    public static final String EXECUTE = "execute";
    public static final String FUEL_VER = "APP_FUEL_VER_ANDROID";
    public static final String INPUT = "input";
    public static final String LONG_CLICK = "long_click";
    public static final String SALE_VERSION_INFO = "(0=國際/1=美國)";
    public static final int SAVE_SIZE = 100;
    public static final String SOLE_VER = "APP_SOLE_VER_ANDROID";
    public static final String SPIRIT_VER = "APP_SPIRIT_VER_ANDROID";
    public static String VERSION_NAME = null;
    public static final String XTERRA_VER = "APP_XTERRA_VER_ANDROID";
    public static boolean isCheckVersion = false;
    public static ArrayList<String> errorList = new ArrayList<>();
    private static SimpleDateFormat dateFormat = new SimpleDateFormat(CalendarUtils.SQL_DATE_TIME_FORMAT);

    public static void addErrorString(Context context, String str, String str2, String str3) {
        saveErrorList(context, dateFormat.format(new Date()) + "=>" + str + "=>" + str2 + "=>" + str3);
    }

    public static void saveErrorList(Context context, String str) {
        if (errorList.size() >= 100) {
            errorList.remove(0);
        }
        errorList.add(str);
        SharedPreferences sharedPreferences = context.getSharedPreferences(ERROR_SAVE, 0);
        sharedPreferences.edit().putString(ERROR_SAVE, new Gson().toJson(errorList)).commit();
        showNowErrorLog();
    }

    public static void loadErrorList(Context context) {
        SharedPreferences sharedPreferences = context.getSharedPreferences(ERROR_SAVE, 0);
        Gson gson = new Gson();
        String string = sharedPreferences.getString(ERROR_SAVE, null);
        Type type = new TypeToken<ArrayList<String>>() { // from class: com.dyaco.sole.ErrorLog.ErrorLogSave.1
        }.getType();
        if (string != null) {
            errorList = (ArrayList) gson.fromJson(string, type);
        }
    }

    public static void clearErrorList(Context context) {
        context.getSharedPreferences(ERROR_SAVE, 0).edit().clear().commit();
        if (errorList == null) {
            errorList = new ArrayList<>();
        }
        errorList.clear();
    }

    public static void toShowString() {
        ArrayList<String> arrayList = errorList;
        if (arrayList == null || arrayList.size() <= 0) {
            Log.e("ErrorLogSave", "size = 0");
        }
        for (int i = 0; i < errorList.size(); i++) {
            Log.e("ErrorLogSave", i + " => " + errorList.get(i));
        }
    }

    public static void showNowErrorLog() {
        StringBuilder sb = new StringBuilder();
        sb.append(errorList.size());
        sb.append(" => ");
        sb.append(errorList.get(r1.size() - 1));
        Log.e("ErrorLogSave", sb.toString());
    }

    public static boolean isPad(Context context) {
        Display defaultDisplay = ((WindowManager) context.getSystemService("window")).getDefaultDisplay();
        defaultDisplay.getWidth();
        defaultDisplay.getHeight();
        DisplayMetrics displayMetrics = new DisplayMetrics();
        defaultDisplay.getMetrics(displayMetrics);
        return Math.sqrt(Math.pow((double) (((float) displayMetrics.widthPixels) / displayMetrics.xdpi), 2.0d) + Math.pow((double) (((float) displayMetrics.heightPixels) / displayMetrics.ydpi), 2.0d)) >= 6.0d;
    }

    public static MemberData getAccoutData() {
        try {
            QueryBuilder<MemberData> queryBuilder = DbManager.getMemberDataDao().queryBuilder();
            queryBuilder.where(MemberDataDao.Properties.Account.eq(Global.userName), new WhereCondition[0]);
            List<MemberData> list = queryBuilder.list();
            if (list != null && list.size() == 1) {
                return list.get(0);
            }
        } catch (Exception unused) {
        }
        return null;
    }

    public static void sendErrorList(String str, Context context) {
        String str2;
        ArrayList<String> arrayList = errorList;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        if (errorList.size() >= 100) {
            errorList.remove(0);
        }
        String str3 = isPad(context) ? "Y" : "N";
        String str4 = dateFormat.format(new Date());
        errorList.add(str4 + "=>Brand:" + Build.BRAND + "_AndroidVer:" + Build.VERSION.SDK_INT + "_AppVer:" + VERSION_NAME + "_isPad:" + str3);
        if (errorList.size() >= 100) {
            errorList.remove(0);
        }
        if (ProtocolHandler.protocol.isConnected()) {
            errorList.add("deviceName:" + ProtocolHandler.protocol.deviceName + "deviceModel:" + ProtocolHandler.protocol.deviceModel + "_deviceSalesVersion:" + ProtocolHandler.protocol.salesVersion + SALE_VERSION_INFO + "_deviceType:" + ProtocolHandler.protocol.deviceType + DEVICE_TYPE_INFO + "_deviceUnit:" + ProtocolHandler.protocol.deviceUnit + DEVICE_UNIT_INFO);
        } else {
            errorList.add("not connect");
        }
        if (errorList.size() >= 100) {
            errorList.remove(0);
        }
        MemberData accoutData = getAccoutData();
        String email = "guest";
        if (accoutData != null) {
            String account = accoutData.getAccount();
            email = accoutData.getEmail();
            str2 = account;
        } else {
            str2 = "guest";
        }
        if (email == null) {
            email = "";
        }
        errorList.add(str4 + "=>account:" + str2 + "_email:" + email);
        Execute.addErrorLog(str, errorList, new Callback() { // from class: com.dyaco.sole.ErrorLog.ErrorLogSave.2
            @Override // okhttp3.Callback
            public void onFailure(Call call, IOException iOException) {
                Log.e("ErrorLogSave", "sendErrorList_onFailure : " + iOException.toString());
            }

            @Override // okhttp3.Callback
            public void onResponse(Call call, Response response) throws IOException {
                try {
                    Log.e("ErrorLogSave", "sendErrorList_data : " + response.body().string());
                } catch (Exception e) {
                    Log.e("ErrorLogSave", "sendErrorList_Exception : " + e.toString());
                }
            }
        });
    }

    public static String getVersionName(Context context) {
        try {
            return context.getPackageManager().getPackageInfo(context.getPackageName(), 0).versionName;
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
