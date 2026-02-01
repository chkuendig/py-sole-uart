package com.soletreadmills.sole_v2._sharedPreferences;

import android.content.Context;
import android.content.SharedPreferences;
import com.android.SdkConstants;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.soletreadmills.sole_v2.MyApplication;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.login.LoginUserData;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: MySharedPreferences.kt */
@Metadata(d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b$\b\u0007\u0018\u0000 W2\u00020\u0001:\u0001WB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0014\u001a\u00020\u0015J\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u0015J\u000e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\b\u0010\u001b\u001a\u0004\u0018\u00010\u0019J\u000e\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0019J\u000e\u0010\u001f\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u0019J\u0006\u0010 \u001a\u00020\u001dJ\u000e\u0010!\u001a\u00020\"2\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010#\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010%\u001a\u00020$2\u0006\u0010\u001a\u001a\u00020\u0019J\u0006\u0010&\u001a\u00020$J\b\u0010'\u001a\u0004\u0018\u00010\u0019J\b\u0010(\u001a\u0004\u0018\u00010\u0019J\u0006\u0010)\u001a\u00020\u0019J\u000e\u0010*\u001a\u00020\u001d2\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010+\u001a\u00020,2\u0006\u0010\u001a\u001a\u00020\u0019J\b\u0010-\u001a\u0004\u0018\u00010\u0019J\u0006\u0010.\u001a\u00020\u0019J\b\u0010/\u001a\u0004\u0018\u00010\u0019J\u0006\u00100\u001a\u00020\u001dJ\u000e\u00101\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u00102\u001a\u00020,2\u0006\u0010\u001a\u001a\u00020\u0019J\b\u00103\u001a\u0004\u0018\u000104J\u0006\u00105\u001a\u00020\u0015J\u0006\u00106\u001a\u00020\u0015J\u0006\u00107\u001a\u00020\u0015J\u0006\u00108\u001a\u00020\u0015J\u0006\u00109\u001a\u00020\u0015J\u0016\u0010:\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u001dJ\u0016\u0010<\u001a\u00020\u00152\u0006\u0010\u001e\u001a\u00020\u00192\u0006\u0010;\u001a\u00020\u001dJ\u000e\u0010=\u001a\u00020\u00152\u0006\u0010>\u001a\u00020\u001dJ\u0016\u0010?\u001a\u00020\u00152\u0006\u0010@\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\u0010\u0010A\u001a\u00020\u00152\b\u0010B\u001a\u0004\u0018\u00010\u0019J\u0016\u0010C\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010D\u001a\u00020\"J\u0016\u0010E\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010F\u001a\u00020$J\u0016\u0010G\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010F\u001a\u00020$J\u000e\u0010H\u001a\u00020\u00152\u0006\u0010@\u001a\u00020$J\u0016\u0010I\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010J\u001a\u00020\u001dJ\u0016\u0010K\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010L\u001a\u00020,J\u0010\u0010M\u001a\u00020\u00152\b\u0010N\u001a\u0004\u0018\u00010\u0019J\u0010\u0010O\u001a\u00020\u00152\b\u0010P\u001a\u0004\u0018\u00010\u0019J\u0010\u0010Q\u001a\u00020\u00152\b\u0010P\u001a\u0004\u0018\u00010\u0019J\u000e\u0010R\u001a\u00020\u00152\u0006\u0010@\u001a\u00020\u001dJ\u0016\u0010S\u001a\u00020\u00152\u0006\u0010@\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\u0016\u0010T\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010L\u001a\u00020,J\u0010\u0010U\u001a\u00020\u00152\b\u0010V\u001a\u0004\u0018\u000104R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006R\u001b\u0010\t\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\b\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000e\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\b\u001a\u0004\b\u000f\u0010\fR\u001b\u0010\u0011\u001a\u00020\n8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\b\u001a\u0004\b\u0012\u0010\f¨\u0006X"}, d2 = {"Lcom/soletreadmills/sole_v2/_sharedPreferences/MySharedPreferences;", "", "()V", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "context$delegate", "Lkotlin/Lazy;", "historyPrefs", "Landroid/content/SharedPreferences;", "getHistoryPrefs", "()Landroid/content/SharedPreferences;", "historyPrefs$delegate", "historySamsungPrefs", "getHistorySamsungPrefs", "historySamsungPrefs$delegate", "prefs", "getPrefs", "prefs$delegate", "clearOldAccount", "", "clearOldLoginToken", "clearOldType", "getAppLanguage", "", "userId", "getConnectBleName", "getHistoryUpdateToHealthConnect", "", "trainingNo", "getHistoryUpdateToSamsungHealth", "getIsSupportWearOS", "getMaxResistance", "", "getMaxSpeedImperial", "", "getMaxSpeedMetric", "getMusicVolume", "getOldAccount", "getOldLoginToken", "getOldType", "getRotateAutomatically", "getRotateEvery", "", "getSharedBaseUrl", "getSharedLoginToken", "getSharedPushToken", "getShowSubtitles", "getSubtitleLanguage", "getTargetTime", "getUserData", "Lcom/soletreadmills/sole_v2/_data/login/LoginUserData;", "resetConnectBleName", "resetSharedBaseUrl", "resetSharedLoginToken", "resetSharedPushToken", "resetUserData", "saveHistoryUpdateToHealthConnect", "isUpdated", "saveHistoryUpdateToSamsungHealth", "saveIsSupportWearOS", "isSupport", "setAppLanguage", "value", "setConnectBleName", "bleName", "setMaxResistance", "resistance", "setMaxSpeedImperial", "speed", "setMaxSpeedMetric", "setMusicVolume", "setRotateAutomatically", "enabled", "setRotateEvery", "seconds", "setSharedBaseUrl", "url", "setSharedLoginToken", "token", "setSharedPushToken", "setShowSubtitles", "setSubtitleLanguage", "setTargetTime", "setUserData", "userData", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MySharedPreferences {
    public static final String CONNECT_BLE_NAME = "CONNECT_BLE_NAME";
    public static final String IS_SUPPORT_WEAR_OS = "IS_SUPPORT_WEAR_OS";
    public static final String LOGIN_TOKEN = "LOGIN_TOKEN";
    public static final String PUSH_TOKEN = "PUSH_TOKEN";
    public static final String SAVE_BASE_URL = "SAVE_BASE_URL";
    public static final String SAVE_MAX_RESISTANCE = "MAX_RESISTANCE";
    public static final String SAVE_MAX_SPEED_IMPERIAL = "MAX_SPEED_IMPERIAL";
    public static final String SAVE_MAX_SPEED_METRIC = "MAX_SPEED_METRIC";
    public static final String SAVE_Music_Volume = "SAVE_Music_Volume";
    public static final String SAVE_ROTATE_AUTOMATICALLY = "ROTATE_AUTOMATICALLY";
    public static final String SAVE_ROTATE_EVERY = "ROTATE_EVERY";
    public static final String SAVE_Show_Subtitles = "SAVE_Show_Subtitles";
    public static final String SAVE_Subtitles_Language = "SAVE_Subtitles_Language";
    public static final String SAVE_TARGET_TIME = "TARGET_TIME";
    public static final String USER_DATA = "USER_DATA";

    /* renamed from: context$delegate, reason: from kotlin metadata */
    private final Lazy context;

    /* renamed from: historyPrefs$delegate, reason: from kotlin metadata */
    private final Lazy historyPrefs;

    /* renamed from: historySamsungPrefs$delegate, reason: from kotlin metadata */
    private final Lazy historySamsungPrefs;

    /* renamed from: prefs$delegate, reason: from kotlin metadata */
    private final Lazy prefs;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;
    private static final Lazy<MySharedPreferences> instance$delegate = LazyKt.lazy(new Function0<MySharedPreferences>() { // from class: com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences$Companion$instance$2
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // kotlin.jvm.functions.Function0
        public final MySharedPreferences invoke() {
            return new MySharedPreferences(null);
        }
    });

    public /* synthetic */ MySharedPreferences(DefaultConstructorMarker defaultConstructorMarker) {
        this();
    }

    private MySharedPreferences() {
        this.context = LazyKt.lazy(new Function0<Context>() { // from class: com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences$context$2
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Context invoke() {
                return MyApplication.INSTANCE.getAppContext();
            }
        });
        this.prefs = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences$prefs$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPreferences invoke() {
                return this.this$0.getContext().getSharedPreferences("UserPrefs", 0);
            }
        });
        this.historyPrefs = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences$historyPrefs$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPreferences invoke() {
                return this.this$0.getContext().getSharedPreferences("History", 0);
            }
        });
        this.historySamsungPrefs = LazyKt.lazy(new Function0<SharedPreferences>() { // from class: com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences$historySamsungPrefs$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SharedPreferences invoke() {
                return this.this$0.getContext().getSharedPreferences("HistorySamsung", 0);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final Context getContext() {
        return (Context) this.context.getValue();
    }

    private final SharedPreferences getPrefs() {
        Object value = this.prefs.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (SharedPreferences) value;
    }

    private final SharedPreferences getHistoryPrefs() {
        Object value = this.historyPrefs.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (SharedPreferences) value;
    }

    private final SharedPreferences getHistorySamsungPrefs() {
        Object value = this.historySamsungPrefs.getValue();
        Intrinsics.checkNotNullExpressionValue(value, "getValue(...)");
        return (SharedPreferences) value;
    }

    /* compiled from: MySharedPreferences.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u001b\u0010\u0013\u001a\u00020\u00148FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0017\u0010\u0018\u001a\u0004\b\u0015\u0010\u0016¨\u0006\u0019"}, d2 = {"Lcom/soletreadmills/sole_v2/_sharedPreferences/MySharedPreferences$Companion;", "", "()V", MySharedPreferences.CONNECT_BLE_NAME, "", MySharedPreferences.IS_SUPPORT_WEAR_OS, MySharedPreferences.LOGIN_TOKEN, MySharedPreferences.PUSH_TOKEN, MySharedPreferences.SAVE_BASE_URL, "SAVE_MAX_RESISTANCE", "SAVE_MAX_SPEED_IMPERIAL", "SAVE_MAX_SPEED_METRIC", MySharedPreferences.SAVE_Music_Volume, "SAVE_ROTATE_AUTOMATICALLY", "SAVE_ROTATE_EVERY", MySharedPreferences.SAVE_Show_Subtitles, MySharedPreferences.SAVE_Subtitles_Language, "SAVE_TARGET_TIME", MySharedPreferences.USER_DATA, "instance", "Lcom/soletreadmills/sole_v2/_sharedPreferences/MySharedPreferences;", "getInstance", "()Lcom/soletreadmills/sole_v2/_sharedPreferences/MySharedPreferences;", "instance$delegate", "Lkotlin/Lazy;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final MySharedPreferences getInstance() {
            return (MySharedPreferences) MySharedPreferences.instance$delegate.getValue();
        }
    }

    public final String getOldLoginToken() {
        return getContext().getSharedPreferences(LOGIN_TOKEN, 0).getString(LOGIN_TOKEN, "");
    }

    public final void clearOldLoginToken() {
        SharedPreferences sharedPreferences = getContext().getSharedPreferences(LOGIN_TOKEN, 0);
        Intrinsics.checkNotNull(sharedPreferences);
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        editorEdit.clear();
        editorEdit.commit();
    }

    public final String getOldType() {
        String string = getContext().getSharedPreferences("TYPE", 0).getString("TYPE", "");
        Intrinsics.checkNotNull(string);
        return string;
    }

    public final void clearOldType() {
        getContext().getSharedPreferences("TYPE", 0).edit().clear().commit();
    }

    public final String getOldAccount() {
        return getContext().getSharedPreferences("ACCOUNT", 0).getString("ACCOUNT", "");
    }

    public final void clearOldAccount() {
        getContext().getSharedPreferences("ACCOUNT", 0).edit().clear().commit();
    }

    public final void setSharedBaseUrl(String url) {
        Timber.INSTANCE.d("setSharedBaseUrl: " + url, new Object[0]);
        if (url != null) {
            getPrefs().edit().putString(SAVE_BASE_URL, url).apply();
        }
    }

    public final String getSharedBaseUrl() {
        String string = getPrefs().getString(SAVE_BASE_URL, "");
        if (string != null) {
            Timber.INSTANCE.d("getSharedBaseUrl: " + string, new Object[0]);
        }
        return string;
    }

    public final void resetSharedBaseUrl() {
        Timber.INSTANCE.d("resetSharedBaseUrl", new Object[0]);
        getPrefs().edit().remove(SAVE_BASE_URL).apply();
    }

    public final void setAppLanguage(String value, String userId) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Timber.INSTANCE.d("setAppLanguage: userId=" + userId + ", value=" + value, new Object[0]);
        getPrefs().edit().putString("app_" + userId, value).apply();
    }

    public final String getAppLanguage(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        String string = MyApplication.INSTANCE.getAppContext().getString(R.string.locale_code);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getPrefs().getString("app_" + userId, string);
        if (string2 != null) {
            string = string2;
        }
        Timber.INSTANCE.d("getAppLanguage: userId=" + userId + ", value=" + string, new Object[0]);
        return string;
    }

    public final void setSharedLoginToken(String token) {
        Timber.INSTANCE.d("setSharedLoginToken: " + token, new Object[0]);
        if (token != null) {
            getPrefs().edit().putString(LOGIN_TOKEN, token).apply();
        }
    }

    public final String getSharedLoginToken() {
        String string = getPrefs().getString(LOGIN_TOKEN, "");
        if (string != null) {
            return string;
        }
        Timber.INSTANCE.e("getSharedLoginToken is null", new Object[0]);
        return "";
    }

    public final void resetSharedLoginToken() {
        Timber.INSTANCE.d("resetSharedLoginToken", new Object[0]);
        getPrefs().edit().remove(LOGIN_TOKEN).apply();
    }

    public final void setSharedPushToken(String token) {
        Timber.INSTANCE.d("setSharedPushToken: " + token, new Object[0]);
        if (token != null) {
            getPrefs().edit().putString(PUSH_TOKEN, token).apply();
        }
    }

    public final String getSharedPushToken() {
        Timber.INSTANCE.d("getSharedPushToken", new Object[0]);
        return getPrefs().getString(PUSH_TOKEN, "");
    }

    public final void resetSharedPushToken() {
        Timber.INSTANCE.d("resetSharedPushToken", new Object[0]);
        getPrefs().edit().remove(PUSH_TOKEN).apply();
    }

    public final void setUserData(LoginUserData userData) {
        Timber.INSTANCE.d("setUserData: " + userData, new Object[0]);
        if (userData != null) {
            getPrefs().edit().putString(USER_DATA, new Gson().toJson(userData)).apply();
        }
    }

    public final LoginUserData getUserData() {
        return (LoginUserData) new Gson().fromJson(getPrefs().getString(USER_DATA, null), new TypeToken<LoginUserData>() { // from class: com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences.getUserData.1
        }.getType());
    }

    public final void resetUserData() {
        Timber.INSTANCE.d("resetUserData", new Object[0]);
        getPrefs().edit().remove(USER_DATA).apply();
    }

    public final void setMusicVolume(float value) {
        Timber.INSTANCE.d("setMusicVolume: " + value, new Object[0]);
        getPrefs().edit().putFloat(SAVE_Music_Volume, value).apply();
    }

    public final float getMusicVolume() {
        float f = getPrefs().getFloat(SAVE_Music_Volume, 0.3f);
        Timber.INSTANCE.d("getMusicVolume: " + f, new Object[0]);
        return f;
    }

    public final void setShowSubtitles(boolean value) {
        Timber.INSTANCE.d("setShowSubtitles: " + value, new Object[0]);
        getPrefs().edit().putBoolean(SAVE_Show_Subtitles, value).apply();
    }

    public final boolean getShowSubtitles() {
        boolean z = getPrefs().getBoolean(SAVE_Show_Subtitles, true);
        Timber.INSTANCE.d("setShowSubtitles: " + z, new Object[0]);
        return z;
    }

    public final void setSubtitleLanguage(String value, String userId) {
        Intrinsics.checkNotNullParameter(value, "value");
        Intrinsics.checkNotNullParameter(userId, "userId");
        Timber.INSTANCE.d("setSubtitleLanguage: userId=" + userId + ", value=" + value, new Object[0]);
        getPrefs().edit().putString(userId, value).apply();
    }

    public final String getSubtitleLanguage(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        String string = MyApplication.INSTANCE.getAppContext().getString(R.string.locale_code);
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        String string2 = getPrefs().getString(userId, string);
        if (string2 != null) {
            string = string2;
        }
        Timber.INSTANCE.d("getSubtitleLanguage: userId=" + userId + ", value=" + string, new Object[0]);
        return string;
    }

    public final void setTargetTime(String userId, long seconds) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Timber.INSTANCE.d("setTargetTime for user " + userId + ": " + seconds + " seconds", new Object[0]);
        getPrefs().edit().putLong("TARGET_TIME_" + userId, seconds).apply();
    }

    public final long getTargetTime(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        long j = getPrefs().getLong("TARGET_TIME_" + userId, 1200L);
        Timber.INSTANCE.d("getTargetTime for user " + userId + ": " + j + " seconds", new Object[0]);
        return j;
    }

    public final void setMaxSpeedMetric(String userId, float speed) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Timber.INSTANCE.d("setMaxSpeedMetric for user " + userId + ": " + speed + " km/h", new Object[0]);
        getPrefs().edit().putFloat("MAX_SPEED_METRIC_" + userId, speed).apply();
    }

    public final float getMaxSpeedMetric(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        float f = getPrefs().getFloat("MAX_SPEED_METRIC_" + userId, 7.5f);
        Timber.INSTANCE.d("getMaxSpeedMetric for user " + userId + ": " + f + " km/h", new Object[0]);
        return f;
    }

    public final void setMaxSpeedImperial(String userId, float speed) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Timber.INSTANCE.d("setMaxSpeedImperial for user " + userId + ": " + speed + " mph", new Object[0]);
        getPrefs().edit().putFloat("MAX_SPEED_IMPERIAL_" + userId, speed).apply();
    }

    public final float getMaxSpeedImperial(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        float f = getPrefs().getFloat("MAX_SPEED_IMPERIAL_" + userId, 4.5f);
        Timber.INSTANCE.d("getMaxSpeedImperial for user " + userId + ": " + f + " mph", new Object[0]);
        return f;
    }

    public final void setMaxResistance(String userId, int resistance) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Timber.INSTANCE.d("setMaxResistance for user " + userId + ": " + resistance, new Object[0]);
        getPrefs().edit().putInt("MAX_RESISTANCE_" + userId, resistance).apply();
    }

    public final int getMaxResistance(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        int i = getPrefs().getInt("MAX_RESISTANCE_" + userId, 5);
        Timber.INSTANCE.d("getMaxResistance for user " + userId + ": " + i, new Object[0]);
        return i;
    }

    public final void setRotateAutomatically(String userId, boolean enabled) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Timber.INSTANCE.d("setRotateAutomatically for user " + userId + ": " + enabled, new Object[0]);
        getPrefs().edit().putBoolean("ROTATE_AUTOMATICALLY_" + userId, enabled).apply();
    }

    public final boolean getRotateAutomatically(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        boolean z = getPrefs().getBoolean("ROTATE_AUTOMATICALLY_" + userId, true);
        Timber.INSTANCE.d("getRotateAutomatically for user " + userId + ": " + z, new Object[0]);
        return z;
    }

    public final void setRotateEvery(String userId, long seconds) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        Timber.INSTANCE.d("setRotateEvery for user " + userId + ": " + seconds + " seconds", new Object[0]);
        getPrefs().edit().putLong("ROTATE_EVERY_" + userId, seconds).apply();
    }

    public final long getRotateEvery(String userId) {
        Intrinsics.checkNotNullParameter(userId, "userId");
        long j = getPrefs().getLong("ROTATE_EVERY_" + userId, 10L);
        Timber.INSTANCE.d("getRotateEvery for user " + userId + ": " + j + " seconds", new Object[0]);
        return j;
    }

    public final void saveHistoryUpdateToHealthConnect(String trainingNo, boolean isUpdated) {
        Intrinsics.checkNotNullParameter(trainingNo, "trainingNo");
        getHistoryPrefs().edit().putBoolean(trainingNo, isUpdated).apply();
    }

    public final boolean getHistoryUpdateToHealthConnect(String trainingNo) {
        Intrinsics.checkNotNullParameter(trainingNo, "trainingNo");
        return getHistoryPrefs().getBoolean(trainingNo, false);
    }

    public final void saveHistoryUpdateToSamsungHealth(String trainingNo, boolean isUpdated) {
        Intrinsics.checkNotNullParameter(trainingNo, "trainingNo");
        getHistorySamsungPrefs().edit().putBoolean(trainingNo, isUpdated).apply();
    }

    public final boolean getHistoryUpdateToSamsungHealth(String trainingNo) {
        Intrinsics.checkNotNullParameter(trainingNo, "trainingNo");
        return getHistorySamsungPrefs().getBoolean(trainingNo, false);
    }

    public final void saveIsSupportWearOS(boolean isSupport) {
        Timber.INSTANCE.d("setIsSupportWearOS: " + isSupport, new Object[0]);
        getPrefs().edit().putBoolean(IS_SUPPORT_WEAR_OS, isSupport).apply();
    }

    public final boolean getIsSupportWearOS() {
        boolean z = getPrefs().getBoolean(IS_SUPPORT_WEAR_OS, false);
        Timber.INSTANCE.d("getIsSupportWearOS -> " + z, new Object[0]);
        return z;
    }

    public final void setConnectBleName(String bleName) {
        if (bleName != null) {
            getPrefs().edit().putString(CONNECT_BLE_NAME, bleName).apply();
        }
    }

    public final String getConnectBleName() {
        return getPrefs().getString(CONNECT_BLE_NAME, "");
    }

    public final void resetConnectBleName() {
        getPrefs().edit().remove(CONNECT_BLE_NAME).apply();
    }
}
