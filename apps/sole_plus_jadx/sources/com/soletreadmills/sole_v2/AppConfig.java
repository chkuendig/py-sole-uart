package com.soletreadmills.sole_v2;

import com.soletreadmills.sole_v2._data.api.ErrorCode;
import com.soletreadmills.sole_v2._data.api.JwtErrorCode;
import java.util.Locale;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: appConfig.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b%\n\u0002\u0010\"\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b0\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010\u0017\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0010R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0010\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010\"\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b#\u0010\u0010\"\u0004\b$\u0010\u001fR\u0011\u0010%\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010\u0010R\u000e\u0010'\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010(\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0010\"\u0004\b*\u0010\u001fR\u0011\u0010+\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010\u0010R\u000e\u0010-\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010.\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000400¢\u0006\b\n\u0000\u001a\u0004\b1\u00102R\u000e\u00103\u001a\u000204X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00105\u001a\u000204X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00106\u001a\u000204X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00107\u001a\u000204X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000204X\u0086T¢\u0006\u0002\n\u0000R\u000e\u00109\u001a\u000204X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u000204X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010;\u001a\u000204X\u0086T¢\u0006\u0002\n\u0000R\u0011\u0010<\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0010R\u000e\u0010>\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010?\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010@\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bA\u0010\u0010\"\u0004\bB\u0010\u001fR\u0011\u0010C\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\bD\u0010\u0010R\u000e\u0010E\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010F\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010G\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010H\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010I\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010J\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010K\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010L\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010M\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010N\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010O\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010P\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010Q\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010\u0010\"\u0004\bS\u0010\u001fR\u001a\u0010T\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bU\u0010\u0010\"\u0004\bV\u0010\u001fR\u001a\u0010W\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bX\u0010\u0010\"\u0004\bY\u0010\u001fR\u000e\u0010Z\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010[\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\\\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010]\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010^\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010_\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010`\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001a\u0010a\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bb\u0010\u0010\"\u0004\bc\u0010\u001f¨\u0006d"}, d2 = {"Lcom/soletreadmills/sole_v2/AppConfig;", "", "()V", "ACCESSORIES_ANKLE_STRAP", "", "ACCESSORIES_BAR", "ACCESSORIES_BELT", "ACCESSORIES_BENCH", "ACCESSORIES_HANDLES", "ACTIVITY_RESULT_REQUESTCODE_SELECT_PHOTO", "", "ACTIVITY_RESULT_REQUESTCODE_SELECT_PHOTOGRAPHY", "ACTIVITY_RESULT_REQUESTCODE_SELECT_VIDEO", "BAIDU_APP_URL", "BASE_URL_WHEN_NULL", "getBASE_URL_WHEN_NULL", "()Ljava/lang/String;", "BASE_URL_WHEN_NULL_DEV", "BASE_URL_WHEN_NULL_PROD", "BRAND_CODE", "BRAND_CODE_GARMIN", AppConfig.GARMIN_USER_ACCESSTOKEN_NAME, AppConfig.GARMIN_USER_ACCESSTOKEN_SECRET_NAME, "GLOBAL_BASE_URL", "getGLOBAL_BASE_URL", "GLOBAL_BASE_URL_DEV", "GLOBAL_BASE_URL_PROD", "GOOGLE_FIT_PERMISSIONS_REQUEST_CODE", "HEADER_ANDROID_ID", "getHEADER_ANDROID_ID", "setHEADER_ANDROID_ID", "(Ljava/lang/String;)V", "HEADER_APP_VERSION_NAME", "HEADER_BRAND_CODE", "HEADER_COUNTRY_CODE", "getHEADER_COUNTRY_CODE", "setHEADER_COUNTRY_CODE", "HEADER_DEVICE_NAME", "getHEADER_DEVICE_NAME", "HEADER_DEVICE_TYPE_TITLE", "HEADER_LOCAL_LANGUAGE", "getHEADER_LOCAL_LANGUAGE", "setHEADER_LOCAL_LANGUAGE", "HEADER_NOW_TIMEZONE", "getHEADER_NOW_TIMEZONE", "HEAD_IMG_NAME", "HELP_EMAIL", "IGNORED_ERROR_CODES", "", "getIGNORED_ERROR_CODES", "()Ljava/util/Set;", "IS_ADD_FTMS_SIMULATION_MACHINE", "", "IS_BLE_ENABLE", "IS_DEV_URL", "IS_MANDATORY_USE_MACHINE_CONTROL", "IS_SHOW_ADVERTISING_MACHINE_TYPE", "IS_SHOW_DASHBOARD_CONTROL_BAR_START_BTN", "IS_SHOW_FTMS_FMS_AND_TS_OSD_MSG", "IS_SHOW_USE_MACHINE_CONTROL_DIALOG", "JWT_BASE_URL", "getJWT_BASE_URL", "JWT_BASE_URL_DEV", "JWT_BASE_URL_PROD", "JWT_BRAND_CODE", "getJWT_BRAND_CODE", "setJWT_BRAND_CODE", "JWT_NOTIFICATION_BASE_URL", "getJWT_NOTIFICATION_BASE_URL", "JWT_NOTIFICATION_BASE_URL_DEV", "JWT_NOTIFICATION_BASE_URL_PROD", "LOG_BASE_URL", "MESSAGE_PATH", "PASSWORD_USE_MACHINE_CONTROL", "PATTERN_DATE_TIME", "PERMISSION_REQUEST_BLUETOOTH", "PERMISSION_REQUEST_LOCATION", "PERMISSION_REQUEST_SELECT_CAMERA", "PERMISSION_REQUEST_SELECT_PHOTO", "PERMISSION_REQUEST_SELECT_VIDEO", "PERMISSION_REQUEST_START", "PUSH_MESSAGE_TOKEN", "getPUSH_MESSAGE_TOKEN", "setPUSH_MESSAGE_TOKEN", "SERVICE_LOGIN_TOKEN", "getSERVICE_LOGIN_TOKEN", "setSERVICE_LOGIN_TOKEN", "SESSION_ID", "getSESSION_ID", "setSESSION_ID", "SRVO_OTA_URL", "SRVO_SOUND", "SUPPORT_URL", "TRAINING_MODE_ECCENTRIC", "TRAINING_MODE_ISOKINETIC", "TRAINING_MODE_STANDARD", "WEAR_CAPABILITY", "token", "getToken", "setToken", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AppConfig {
    public static final int $stable;
    public static final String ACCESSORIES_ANKLE_STRAP = "https://daii8hieupx72.cloudfront.net/power-station-info/sole/en/accessories/ankle-strap.html";
    public static final String ACCESSORIES_BAR = "https://daii8hieupx72.cloudfront.net/power-station-info/sole/en/accessories/bar.html";
    public static final String ACCESSORIES_BELT = "https://daii8hieupx72.cloudfront.net/power-station-info/sole/en/accessories/belt.html";
    public static final String ACCESSORIES_BENCH = "https://daii8hieupx72.cloudfront.net/power-station-info/sole/en/accessories/bench.html";
    public static final String ACCESSORIES_HANDLES = "https://daii8hieupx72.cloudfront.net/power-station-info/sole/en/accessories/handles.html";
    public static final int ACTIVITY_RESULT_REQUESTCODE_SELECT_PHOTO = 20301;
    public static final int ACTIVITY_RESULT_REQUESTCODE_SELECT_PHOTOGRAPHY = 20201;
    public static final int ACTIVITY_RESULT_REQUESTCODE_SELECT_VIDEO = 20401;
    public static final String BAIDU_APP_URL = "https://mobile.baidu.com/item?docid=5004176496&f0=search_suggestContent%400_appBaseNormal%400";
    public static final String BASE_URL_WHEN_NULL_DEV = "https://sole-homeplus-dev.dyacocloud.com";
    public static final String BRAND_CODE = "sole";
    public static final String BRAND_CODE_GARMIN = "garmin";
    public static final String GARMIN_USER_ACCESSTOKEN_NAME = "GARMIN_USER_ACCESSTOKEN_NAME";
    public static final String GARMIN_USER_ACCESSTOKEN_SECRET_NAME = "GARMIN_USER_ACCESSTOKEN_SECRET_NAME";
    public static final String GLOBAL_BASE_URL_DEV = "https://sole-homeglobal-dev.dyacocloud.com";
    public static final int GOOGLE_FIT_PERMISSIONS_REQUEST_CODE = 10005;
    private static String HEADER_ANDROID_ID = null;
    public static final String HEADER_APP_VERSION_NAME = "4.11";
    public static final String HEADER_BRAND_CODE = "sole";
    private static String HEADER_COUNTRY_CODE = null;
    private static final String HEADER_DEVICE_NAME;
    public static final String HEADER_DEVICE_TYPE_TITLE = "HOME_ANDROID";
    private static String HEADER_LOCAL_LANGUAGE = null;
    private static final String HEADER_NOW_TIMEZONE;
    public static final String HEAD_IMG_NAME = "headimg123456.jpg";
    public static final String HELP_EMAIL = "service@soletreadmills.com";
    public static final boolean IS_ADD_FTMS_SIMULATION_MACHINE = false;
    public static final boolean IS_BLE_ENABLE = true;
    public static final boolean IS_DEV_URL = false;
    public static final boolean IS_MANDATORY_USE_MACHINE_CONTROL = false;
    public static final boolean IS_SHOW_ADVERTISING_MACHINE_TYPE = true;
    public static final boolean IS_SHOW_DASHBOARD_CONTROL_BAR_START_BTN = false;
    public static final boolean IS_SHOW_FTMS_FMS_AND_TS_OSD_MSG = false;
    public static final boolean IS_SHOW_USE_MACHINE_CONTROL_DIALOG = false;
    public static final String JWT_BASE_URL_DEV = "https://homeplugin.mycare-dev.com";
    private static String JWT_BRAND_CODE = null;
    public static final String JWT_NOTIFICATION_BASE_URL_DEV = "https://www.mycare-dev.com:5050";
    public static final String LOG_BASE_URL = "https://applog.dyacocloud.com";
    public static final String MESSAGE_PATH = "/wear-message";
    public static final String PASSWORD_USE_MACHINE_CONTROL = "Dyaco";
    public static final String PATTERN_DATE_TIME = "yyyy-MM-dd HH:mm:ss";
    public static final int PERMISSION_REQUEST_BLUETOOTH = 10007;
    public static final int PERMISSION_REQUEST_LOCATION = 10006;
    public static final int PERMISSION_REQUEST_SELECT_CAMERA = 10002;
    public static final int PERMISSION_REQUEST_SELECT_PHOTO = 10003;
    public static final int PERMISSION_REQUEST_SELECT_VIDEO = 10004;
    public static final int PERMISSION_REQUEST_START = 10001;
    private static String PUSH_MESSAGE_TOKEN = null;
    private static String SERVICE_LOGIN_TOKEN = null;
    private static String SESSION_ID = null;
    public static final String SRVO_OTA_URL = "http://iwbota.com/";
    public static final String SRVO_SOUND = "https://daii8hieupx72.cloudfront.net/power-station-info/sole/en/sound.html";
    public static final String SUPPORT_URL = "https://dyaco-resources.s3.us-east-1.amazonaws.com/Support/index.html#";
    public static final String TRAINING_MODE_ECCENTRIC = "https://daii8hieupx72.cloudfront.net/power-station-info/sole/en/training-modes/eccentric-mode.html";
    public static final String TRAINING_MODE_ISOKINETIC = "https://daii8hieupx72.cloudfront.net/power-station-info/sole/en/training-modes/isokinetic-mode.html";
    public static final String TRAINING_MODE_STANDARD = "https://daii8hieupx72.cloudfront.net/power-station-info/sole/en/training-modes/standard-mode.html";
    public static final String WEAR_CAPABILITY = "verify_remote_wear_app";
    private static String token;
    public static final AppConfig INSTANCE = new AppConfig();
    public static final String GLOBAL_BASE_URL_PROD = "https://sole-homeglobal.dyacocloud.com";
    private static final String GLOBAL_BASE_URL = GLOBAL_BASE_URL_PROD;
    public static final String BASE_URL_WHEN_NULL_PROD = "https://sole-homeplus.dyacocloud.com";
    private static final String BASE_URL_WHEN_NULL = BASE_URL_WHEN_NULL_PROD;
    public static final String JWT_BASE_URL_PROD = "https://homeplugin.dyacocloud.com";
    private static final String JWT_BASE_URL = JWT_BASE_URL_PROD;
    public static final String JWT_NOTIFICATION_BASE_URL_PROD = "https://notification.dyacocloud.com";
    private static final String JWT_NOTIFICATION_BASE_URL = JWT_NOTIFICATION_BASE_URL_PROD;
    private static final Set<String> IGNORED_ERROR_CODES = SetsKt.setOf((Object[]) new String[]{ErrorCode.UNKNOWN_ERR_NEG1.getId(), ErrorCode.LOGIN_REQUIRED_113.getId(), JwtErrorCode.JWT_SERVICE_TOKEN_EXPIRED_3007.getId(), JwtErrorCode.JWT_AUTHORIZATION_105.getId()});

    private AppConfig() {
    }

    public final String getGLOBAL_BASE_URL() {
        return GLOBAL_BASE_URL;
    }

    static {
        String country = Locale.getDefault().getCountry();
        if (country == null) {
            country = "TW";
        }
        HEADER_COUNTRY_CODE = country;
        HEADER_LOCAL_LANGUAGE = AppConfigKt.getLang();
        HEADER_NOW_TIMEZONE = AppConfigKt.getTimezone();
        HEADER_DEVICE_NAME = AppConfigKt.getDeviceName();
        HEADER_ANDROID_ID = "";
        SESSION_ID = "";
        SERVICE_LOGIN_TOKEN = "";
        PUSH_MESSAGE_TOKEN = "";
        JWT_BRAND_CODE = "1";
        token = "";
        $stable = 8;
    }

    public final String getBASE_URL_WHEN_NULL() {
        return BASE_URL_WHEN_NULL;
    }

    public final String getJWT_BASE_URL() {
        return JWT_BASE_URL;
    }

    public final String getJWT_NOTIFICATION_BASE_URL() {
        return JWT_NOTIFICATION_BASE_URL;
    }

    public final Set<String> getIGNORED_ERROR_CODES() {
        return IGNORED_ERROR_CODES;
    }

    public final String getHEADER_COUNTRY_CODE() {
        return HEADER_COUNTRY_CODE;
    }

    public final void setHEADER_COUNTRY_CODE(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        HEADER_COUNTRY_CODE = str;
    }

    public final String getHEADER_LOCAL_LANGUAGE() {
        return HEADER_LOCAL_LANGUAGE;
    }

    public final void setHEADER_LOCAL_LANGUAGE(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        HEADER_LOCAL_LANGUAGE = str;
    }

    public final String getHEADER_NOW_TIMEZONE() {
        return HEADER_NOW_TIMEZONE;
    }

    public final String getHEADER_DEVICE_NAME() {
        return HEADER_DEVICE_NAME;
    }

    public final String getHEADER_ANDROID_ID() {
        return HEADER_ANDROID_ID;
    }

    public final void setHEADER_ANDROID_ID(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        HEADER_ANDROID_ID = str;
    }

    public final String getSESSION_ID() {
        return SESSION_ID;
    }

    public final void setSESSION_ID(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        SESSION_ID = str;
    }

    public final String getSERVICE_LOGIN_TOKEN() {
        return SERVICE_LOGIN_TOKEN;
    }

    public final void setSERVICE_LOGIN_TOKEN(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        SERVICE_LOGIN_TOKEN = str;
    }

    public final String getPUSH_MESSAGE_TOKEN() {
        return PUSH_MESSAGE_TOKEN;
    }

    public final void setPUSH_MESSAGE_TOKEN(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        PUSH_MESSAGE_TOKEN = str;
    }

    public final String getJWT_BRAND_CODE() {
        return JWT_BRAND_CODE;
    }

    public final void setJWT_BRAND_CODE(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        JWT_BRAND_CODE = str;
    }

    public final String getToken() {
        return token;
    }

    public final void setToken(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        token = str;
    }
}
