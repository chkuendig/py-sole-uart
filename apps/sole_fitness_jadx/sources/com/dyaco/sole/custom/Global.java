package com.dyaco.sole.custom;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.projection.MediaProjectionManager;
import android.os.Build;
import android.util.DisplayMetrics;
import android.util.Log;
import com.digifly.cloudapi.data.MemberData;
import com.digifly.dbapi.DbManager;
import com.digifly.dbapi.greeddao_gen.MemberDataDao;
import com.dyaco.ideabussdk_sole.library.MyVariable;
import com.dyaco.ideabussdk_sole.protocol.WorkoutData;
import com.dyaco.sole.BuildConfig;
import com.dyaco.sole.activity.LogoActivity;
import com.dyaco.sole.database.BaseDB;
import com.dyaco.sole.database.MessageDB;
import com.facebook.internal.security.CertificateUtil;
import com.ideabus.library.CustomVariable;
import com.soletreadmills.sole.R;
import java.io.File;
import java.text.NumberFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;
import org.apache.commons.lang3.StringUtils;
import org.greenrobot.greendao.query.QueryBuilder;
import org.greenrobot.greendao.query.WhereCondition;

/* loaded from: classes.dex */
public class Global extends MyVariable {
    public static int BRAND = 0;
    public static final int FUEL = 3;
    public static final String GOOGLE_PLAY_PACKAGE_NAME = "com.android.vending";
    public static final int RECORD_INTERVAL = 5;
    public static final String REGIST_TYPE_NORMAL = "NORMAL";
    public static final String SHARED_PREFERENCES_NOTIFICATION = "Notification";
    public static final int SOLE = 0;
    public static final int SPIRIT = 1;
    public static final int XTERRA = 2;
    public static String guestAge = null;
    public static String guestWeight = null;
    public static boolean isAuth = false;
    private static final boolean isPrintLog = true;
    public static MemberData memberData = null;
    public static File screenshotFile = null;
    public static boolean shareMore = false;
    public static int ALERT_TITLE_RID = R.string.alert_title;
    public static int APP_NAME_RID = R.string.app_name;
    public static String CLOUD_BRAND_NAME = BuildConfig.FLAVOR;
    public static boolean isMainActivityRun = false;
    public static String noticeMessage_no = "";
    public static String nowActivityName = LogoActivity.class.getName();
    public static boolean isIdleMode = false;
    public static boolean isSafeKeyOn = true;
    public static final String[] fontsPath = {"fonts/Univers LT 39 Thin Ultra Condensed.ttf", "fonts/Univers LT 59 Ultra Condensed.ttf", "fonts/Helvetica LT 25 Ultra Light.ttf", "fonts/Helvetica LT 66 Medium Italic.ttf", "fonts/HandelGothic-BT.ttf"};
    public static String userName = "";
    public static String calendarUserName = "";
    public static final Locale DE = new Locale("de", "DE");
    public static final Locale ES = new Locale("es", "ES");
    public static final Locale RU = new Locale("ru", "RU");
    public static List<WorkoutData> workoutDataList = new ArrayList();
    public static List<WorkoutData> workoutDataListForProtocol = new ArrayList();
    public static double gpsLat = 999.0d;
    public static double gpsLon = 999.0d;

    public static void setAppLocale(Resources resources, Locale locale) {
        Configuration configuration = resources.getConfiguration();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        configuration.setLocale(locale);
        resources.updateConfiguration(configuration, displayMetrics);
    }

    public static int getLongScreenHeight(int i, float f) {
        if (CustomVariable.isLongScreen) {
            return i;
        }
        return (int) (i * f * (2.9f - CustomVariable.screenScale));
    }

    public static Bitmap readBitmapFromStream(Resources resources, int i, int i2) {
        if (i == 0) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        options.inPurgeable = true;
        options.inInputShareable = true;
        options.inSampleSize = i2;
        return BitmapFactory.decodeStream(resources.openRawResource(i), null, options);
    }

    public static Drawable getDrawableFromResId(Resources resources, int i) {
        try {
            return new BitmapDrawable(resources, resources.openRawResource(i));
        } catch (OutOfMemoryError e) {
            e.printStackTrace();
            System.gc();
            return null;
        }
    }

    public static String getStringPlace(int i, int i2) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(false);
        numberFormat.setMinimumIntegerDigits(i2);
        return numberFormat.format(i);
    }

    public static String getDateTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(1) + "/" + getStringPlace(calendar.get(2) + 1, 2) + "/" + getStringPlace(calendar.get(5), 2) + StringUtils.SPACE + getStringPlace(calendar.get(11), 2) + CertificateUtil.DELIMITER + getStringPlace(calendar.get(12), 2) + CertificateUtil.DELIMITER + getStringPlace(calendar.get(13), 2);
    }

    public static SharedPreferences getSharedPreferences(Context context) {
        return context.getSharedPreferences(BaseDB.DB_NAME, 0);
    }

    public static SharedPreferences.Editor getSpfEditor(Context context) {
        return context.getSharedPreferences(BaseDB.DB_NAME, 0).edit();
    }

    public static void takeScreenshot(Activity activity) {
        if (screenshotFile == null) {
            screenshotFile = new File(activity.getFilesDir(), "share_screenshot.jpg");
        }
        if (Build.VERSION.SDK_INT >= 21) {
            activity.startActivityForResult(((MediaProjectionManager) activity.getSystemService("media_projection")).createScreenCaptureIntent(), 291);
        }
    }

    public static void printLog(String str, String str2, String str3) {
        int i;
        if (str.equals("i")) {
            i = 4;
        } else if (str.equals("d")) {
            i = 3;
        } else {
            i = str.equals("e") ? 6 : 0;
        }
        Log.println(i, str2, str3);
    }

    public static MemberData getAccoutData(Context context) {
        DbManager.getInstance(context);
        QueryBuilder<MemberData> queryBuilder = DbManager.getMemberDataDao().queryBuilder();
        queryBuilder.where(MemberDataDao.Properties.Account.eq(userName), new WhereCondition[0]);
        List<MemberData> list = queryBuilder.list();
        if (list == null || list.size() != 1) {
            return null;
        }
        return list.get(0);
    }

    public static void saveNotifyToken(Context context, String str) {
        context.getSharedPreferences(SHARED_PREFERENCES_NOTIFICATION, 0).edit().putString(SHARED_PREFERENCES_NOTIFICATION, str).commit();
    }

    public static String getNotifyToken(Context context) {
        return context.getSharedPreferences(SHARED_PREFERENCES_NOTIFICATION, 0).getString(SHARED_PREFERENCES_NOTIFICATION, "");
    }

    public static void saveNotifyMessageNo(Context context, String str) {
        context.getSharedPreferences(SHARED_PREFERENCES_NOTIFICATION, 0).edit().putString("NotifyMessageNo", str).commit();
    }

    public static String getNotifyMessageNo(Context context) {
        return context.getSharedPreferences(SHARED_PREFERENCES_NOTIFICATION, 0).getString("NotifyMessageNo", "");
    }

    public static String getAccount(Context context) {
        return context.getSharedPreferences("DATA", 0).getString(MessageDB.ACCOUNT, null);
    }

    public static String getPassword(Context context) {
        return context.getSharedPreferences("DATA", 0).getString("password", null);
    }
}
