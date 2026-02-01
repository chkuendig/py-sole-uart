package com.facebook.appevents.integrity;

import android.os.Build;
import android.os.Bundle;
import androidx.core.app.NotificationCompat;
import com.android.SdkConstants;
import com.facebook.FacebookSdk;
import com.facebook.internal.FetchedAppSettings;
import com.facebook.internal.FetchedAppSettingsManager;
import com.facebook.internal.NativeProtocol;
import com.facebook.internal.Utility;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import com.google.firebase.crashlytics.internal.metadata.UserMetadata;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.HttpUrl;
import org.json.JSONArray;
import org.json.JSONObject;

/* compiled from: MACARuleMatchingManager.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000b\u001a\u00020\fH\u0007J\u0018\u0010\r\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0007J\u0012\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u0012\u0010\u0014\u001a\u00020\t2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0007J&\u0010\u0015\u001a\u0016\u0012\u0004\u0012\u00020\t\u0018\u00010\u0016j\n\u0012\u0004\u0012\u00020\t\u0018\u0001`\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0004H\u0007J\u001c\u0010\u0019\u001a\u00020\u00062\b\u0010\u001a\u001a\u0004\u0018\u00010\t2\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0007J\b\u0010\u001c\u001a\u00020\fH\u0002J\u001a\u0010\u001d\u001a\u00020\f2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\tH\u0007J\u0010\u0010\u001e\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\u000fH\u0007J\"\u0010\u001f\u001a\u00020\u00062\u0006\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\u00132\b\u0010\u001b\u001a\u0004\u0018\u00010\u000fH\u0007R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\n¨\u0006\""}, d2 = {"Lcom/facebook/appevents/integrity/MACARuleMatchingManager;", "", "()V", "MACARules", "Lorg/json/JSONArray;", "enabled", "", UserMetadata.KEYDATA_FILENAME, "", "", "[Ljava/lang/String;", "enable", "", "generateInfo", NativeProtocol.WEB_DIALOG_PARAMS, "Landroid/os/Bundle;", NotificationCompat.CATEGORY_EVENT, "getKey", "logic", "Lorg/json/JSONObject;", "getMatchPropertyIDs", "getStringArrayList", "Ljava/util/ArrayList;", "Lkotlin/collections/ArrayList;", "jsonArray", "isMatchCCRule", "ruleString", "data", "loadMACARules", "processParameters", "removeGeneratedInfo", "stringComparison", SdkConstants.TAG_VARIABLE, SdkConstants.FD_RES_VALUES, "facebook-core_release"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes3.dex */
public final class MACARuleMatchingManager {
    private static JSONArray MACARules;
    private static boolean enabled;
    public static final MACARuleMatchingManager INSTANCE = new MACARuleMatchingManager();
    private static String[] keys = {NotificationCompat.CATEGORY_EVENT, "_locale", "_appVersion", "_deviceOS", "_platform", "_deviceModel", "_nativeAppID", "_nativeAppShortVersion", "_timezone", "_carrier", "_deviceOSTypeName", "_deviceOSVersion", "_remainingDiskGB"};

    private MACARuleMatchingManager() {
    }

    @JvmStatic
    public static final void enable() {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            INSTANCE.loadMACARules();
            if (MACARules != null) {
                enabled = true;
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    private final void loadMACARules() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            FetchedAppSettingsManager fetchedAppSettingsManager = FetchedAppSettingsManager.INSTANCE;
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            FetchedAppSettings fetchedAppSettingsQueryAppSettings = FetchedAppSettingsManager.queryAppSettings(FacebookSdk.getApplicationId(), false);
            if (fetchedAppSettingsQueryAppSettings == null) {
                return;
            }
            MACARules = fetchedAppSettingsQueryAppSettings.getMACARuleMatchingSetting();
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, this);
        }
    }

    @JvmStatic
    public static final String getKey(JSONObject logic) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return null;
        }
        try {
            Intrinsics.checkNotNullParameter(logic, "logic");
            Iterator<String> itKeys = logic.keys();
            if (itKeys.hasNext()) {
                return itKeys.next();
            }
            return null;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:112:0x01d2  */
    /* JADX WARN: Removed duplicated region for block: B:121:0x01f7  */
    /* JADX WARN: Removed duplicated region for block: B:133:0x0229  */
    /* JADX WARN: Removed duplicated region for block: B:143:0x0258  */
    /* JADX WARN: Removed duplicated region for block: B:148:0x0265 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:149:0x0266 A[Catch: all -> 0x0401, TryCatch #0 {all -> 0x0401, blocks: (B:5:0x000a, B:8:0x001d, B:13:0x0041, B:12:0x0039, B:22:0x0067, B:25:0x006f, B:29:0x007d, B:32:0x0087, B:34:0x008d, B:36:0x0098, B:37:0x00a7, B:38:0x00ac, B:39:0x00ad, B:40:0x00b2, B:41:0x00b3, B:44:0x00be, B:47:0x00ce, B:149:0x0266, B:151:0x026c, B:154:0x0276, B:155:0x027a, B:157:0x0280, B:159:0x0288, B:161:0x0297, B:164:0x02a8, B:165:0x02ad, B:166:0x02ae, B:167:0x02b3, B:50:0x00d8, B:53:0x00e2, B:55:0x00e8, B:57:0x00f5, B:58:0x0106, B:59:0x010b, B:60:0x010c, B:61:0x0111, B:62:0x0112, B:173:0x02c1, B:175:0x02c7, B:178:0x02d2, B:179:0x02d6, B:181:0x02dc, B:183:0x02e4, B:185:0x02f3, B:188:0x0304, B:189:0x0309, B:190:0x030a, B:191:0x030f, B:65:0x011c, B:68:0x0126, B:70:0x012c, B:72:0x0137, B:73:0x0146, B:74:0x014b, B:75:0x014c, B:76:0x0151, B:77:0x0152, B:125:0x0202, B:80:0x015d, B:119:0x01e7, B:83:0x0167, B:110:0x01c2, B:86:0x0171, B:89:0x017c, B:141:0x0248, B:92:0x0186, B:95:0x0190, B:232:0x03bc, B:98:0x019a, B:131:0x0219, B:101:0x01a4, B:104:0x01ae, B:137:0x0234, B:107:0x01b8, B:113:0x01d3, B:116:0x01dd, B:122:0x01f8, B:128:0x020f, B:134:0x022a, B:138:0x023e, B:144:0x0259, B:168:0x02b4, B:192:0x0310, B:195:0x031a, B:197:0x0320, B:199:0x032b, B:202:0x033c, B:203:0x0341, B:204:0x0342, B:205:0x0347, B:206:0x0348, B:209:0x0352, B:210:0x0360, B:226:0x03a7, B:213:0x036a, B:216:0x0375, B:217:0x0386, B:220:0x0391, B:221:0x039a, B:227:0x03b0, B:233:0x03c5, B:236:0x03ce, B:238:0x03d4, B:240:0x03e1, B:243:0x03f4, B:244:0x03f9, B:245:0x03fa, B:246:0x03ff, B:18:0x0054), top: B:251:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:172:0x02c0 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:173:0x02c1 A[Catch: all -> 0x0401, TryCatch #0 {all -> 0x0401, blocks: (B:5:0x000a, B:8:0x001d, B:13:0x0041, B:12:0x0039, B:22:0x0067, B:25:0x006f, B:29:0x007d, B:32:0x0087, B:34:0x008d, B:36:0x0098, B:37:0x00a7, B:38:0x00ac, B:39:0x00ad, B:40:0x00b2, B:41:0x00b3, B:44:0x00be, B:47:0x00ce, B:149:0x0266, B:151:0x026c, B:154:0x0276, B:155:0x027a, B:157:0x0280, B:159:0x0288, B:161:0x0297, B:164:0x02a8, B:165:0x02ad, B:166:0x02ae, B:167:0x02b3, B:50:0x00d8, B:53:0x00e2, B:55:0x00e8, B:57:0x00f5, B:58:0x0106, B:59:0x010b, B:60:0x010c, B:61:0x0111, B:62:0x0112, B:173:0x02c1, B:175:0x02c7, B:178:0x02d2, B:179:0x02d6, B:181:0x02dc, B:183:0x02e4, B:185:0x02f3, B:188:0x0304, B:189:0x0309, B:190:0x030a, B:191:0x030f, B:65:0x011c, B:68:0x0126, B:70:0x012c, B:72:0x0137, B:73:0x0146, B:74:0x014b, B:75:0x014c, B:76:0x0151, B:77:0x0152, B:125:0x0202, B:80:0x015d, B:119:0x01e7, B:83:0x0167, B:110:0x01c2, B:86:0x0171, B:89:0x017c, B:141:0x0248, B:92:0x0186, B:95:0x0190, B:232:0x03bc, B:98:0x019a, B:131:0x0219, B:101:0x01a4, B:104:0x01ae, B:137:0x0234, B:107:0x01b8, B:113:0x01d3, B:116:0x01dd, B:122:0x01f8, B:128:0x020f, B:134:0x022a, B:138:0x023e, B:144:0x0259, B:168:0x02b4, B:192:0x0310, B:195:0x031a, B:197:0x0320, B:199:0x032b, B:202:0x033c, B:203:0x0341, B:204:0x0342, B:205:0x0347, B:206:0x0348, B:209:0x0352, B:210:0x0360, B:226:0x03a7, B:213:0x036a, B:216:0x0375, B:217:0x0386, B:220:0x0391, B:221:0x039a, B:227:0x03b0, B:233:0x03c5, B:236:0x03ce, B:238:0x03d4, B:240:0x03e1, B:243:0x03f4, B:244:0x03f9, B:245:0x03fa, B:246:0x03ff, B:18:0x0054), top: B:251:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:225:0x03a6 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:226:0x03a7 A[Catch: all -> 0x0401, TryCatch #0 {all -> 0x0401, blocks: (B:5:0x000a, B:8:0x001d, B:13:0x0041, B:12:0x0039, B:22:0x0067, B:25:0x006f, B:29:0x007d, B:32:0x0087, B:34:0x008d, B:36:0x0098, B:37:0x00a7, B:38:0x00ac, B:39:0x00ad, B:40:0x00b2, B:41:0x00b3, B:44:0x00be, B:47:0x00ce, B:149:0x0266, B:151:0x026c, B:154:0x0276, B:155:0x027a, B:157:0x0280, B:159:0x0288, B:161:0x0297, B:164:0x02a8, B:165:0x02ad, B:166:0x02ae, B:167:0x02b3, B:50:0x00d8, B:53:0x00e2, B:55:0x00e8, B:57:0x00f5, B:58:0x0106, B:59:0x010b, B:60:0x010c, B:61:0x0111, B:62:0x0112, B:173:0x02c1, B:175:0x02c7, B:178:0x02d2, B:179:0x02d6, B:181:0x02dc, B:183:0x02e4, B:185:0x02f3, B:188:0x0304, B:189:0x0309, B:190:0x030a, B:191:0x030f, B:65:0x011c, B:68:0x0126, B:70:0x012c, B:72:0x0137, B:73:0x0146, B:74:0x014b, B:75:0x014c, B:76:0x0151, B:77:0x0152, B:125:0x0202, B:80:0x015d, B:119:0x01e7, B:83:0x0167, B:110:0x01c2, B:86:0x0171, B:89:0x017c, B:141:0x0248, B:92:0x0186, B:95:0x0190, B:232:0x03bc, B:98:0x019a, B:131:0x0219, B:101:0x01a4, B:104:0x01ae, B:137:0x0234, B:107:0x01b8, B:113:0x01d3, B:116:0x01dd, B:122:0x01f8, B:128:0x020f, B:134:0x022a, B:138:0x023e, B:144:0x0259, B:168:0x02b4, B:192:0x0310, B:195:0x031a, B:197:0x0320, B:199:0x032b, B:202:0x033c, B:203:0x0341, B:204:0x0342, B:205:0x0347, B:206:0x0348, B:209:0x0352, B:210:0x0360, B:226:0x03a7, B:213:0x036a, B:216:0x0375, B:217:0x0386, B:220:0x0391, B:221:0x039a, B:227:0x03b0, B:233:0x03c5, B:236:0x03ce, B:238:0x03d4, B:240:0x03e1, B:243:0x03f4, B:244:0x03f9, B:245:0x03fa, B:246:0x03ff, B:18:0x0054), top: B:251:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:231:0x03bb A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:232:0x03bc A[Catch: all -> 0x0401, TryCatch #0 {all -> 0x0401, blocks: (B:5:0x000a, B:8:0x001d, B:13:0x0041, B:12:0x0039, B:22:0x0067, B:25:0x006f, B:29:0x007d, B:32:0x0087, B:34:0x008d, B:36:0x0098, B:37:0x00a7, B:38:0x00ac, B:39:0x00ad, B:40:0x00b2, B:41:0x00b3, B:44:0x00be, B:47:0x00ce, B:149:0x0266, B:151:0x026c, B:154:0x0276, B:155:0x027a, B:157:0x0280, B:159:0x0288, B:161:0x0297, B:164:0x02a8, B:165:0x02ad, B:166:0x02ae, B:167:0x02b3, B:50:0x00d8, B:53:0x00e2, B:55:0x00e8, B:57:0x00f5, B:58:0x0106, B:59:0x010b, B:60:0x010c, B:61:0x0111, B:62:0x0112, B:173:0x02c1, B:175:0x02c7, B:178:0x02d2, B:179:0x02d6, B:181:0x02dc, B:183:0x02e4, B:185:0x02f3, B:188:0x0304, B:189:0x0309, B:190:0x030a, B:191:0x030f, B:65:0x011c, B:68:0x0126, B:70:0x012c, B:72:0x0137, B:73:0x0146, B:74:0x014b, B:75:0x014c, B:76:0x0151, B:77:0x0152, B:125:0x0202, B:80:0x015d, B:119:0x01e7, B:83:0x0167, B:110:0x01c2, B:86:0x0171, B:89:0x017c, B:141:0x0248, B:92:0x0186, B:95:0x0190, B:232:0x03bc, B:98:0x019a, B:131:0x0219, B:101:0x01a4, B:104:0x01ae, B:137:0x0234, B:107:0x01b8, B:113:0x01d3, B:116:0x01dd, B:122:0x01f8, B:128:0x020f, B:134:0x022a, B:138:0x023e, B:144:0x0259, B:168:0x02b4, B:192:0x0310, B:195:0x031a, B:197:0x0320, B:199:0x032b, B:202:0x033c, B:203:0x0341, B:204:0x0342, B:205:0x0347, B:206:0x0348, B:209:0x0352, B:210:0x0360, B:226:0x03a7, B:213:0x036a, B:216:0x0375, B:217:0x0386, B:220:0x0391, B:221:0x039a, B:227:0x03b0, B:233:0x03c5, B:236:0x03ce, B:238:0x03d4, B:240:0x03e1, B:243:0x03f4, B:244:0x03f9, B:245:0x03fa, B:246:0x03ff, B:18:0x0054), top: B:251:0x000a }] */
    /* JADX WARN: Removed duplicated region for block: B:282:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:285:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:287:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:290:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:294:? A[RETURN, SYNTHETIC] */
    @kotlin.jvm.JvmStatic
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final boolean stringComparison(java.lang.String r9, org.json.JSONObject r10, android.os.Bundle r11) {
        /*
            Method dump skipped, instructions count: 1164
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.facebook.appevents.integrity.MACARuleMatchingManager.stringComparison(java.lang.String, org.json.JSONObject, android.os.Bundle):boolean");
    }

    @JvmStatic
    public static final ArrayList<String> getStringArrayList(JSONArray jsonArray) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class) || jsonArray == null) {
            return null;
        }
        try {
            ArrayList<String> arrayList = new ArrayList<>();
            int length = jsonArray.length();
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    arrayList.add(jsonArray.get(i).toString());
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            return arrayList;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final boolean isMatchCCRule(String ruleString, Bundle data) {
        int length;
        if (!CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class) && ruleString != null && data != null) {
            try {
                JSONObject jSONObject = new JSONObject(ruleString);
                String key = getKey(jSONObject);
                if (key == null) {
                    return false;
                }
                Object obj = jSONObject.get(key);
                int iHashCode = key.hashCode();
                if (iHashCode != 3555) {
                    if (iHashCode != 96727) {
                        if (iHashCode == 109267 && key.equals("not")) {
                            return !isMatchCCRule(obj.toString(), data);
                        }
                    } else if (key.equals("and")) {
                        JSONArray jSONArray = (JSONArray) obj;
                        if (jSONArray == null) {
                            return false;
                        }
                        int length2 = jSONArray.length();
                        if (length2 > 0) {
                            int i = 0;
                            while (true) {
                                int i2 = i + 1;
                                if (!isMatchCCRule(jSONArray.get(i).toString(), data)) {
                                    return false;
                                }
                                if (i2 >= length2) {
                                    break;
                                }
                                i = i2;
                            }
                        }
                        return true;
                    }
                } else if (key.equals("or")) {
                    JSONArray jSONArray2 = (JSONArray) obj;
                    if (jSONArray2 != null && (length = jSONArray2.length()) > 0) {
                        int i3 = 0;
                        while (true) {
                            int i4 = i3 + 1;
                            if (isMatchCCRule(jSONArray2.get(i3).toString(), data)) {
                                return true;
                            }
                            if (i4 >= length) {
                                break;
                            }
                            i3 = i4;
                        }
                    }
                    return false;
                }
                JSONObject jSONObject2 = (JSONObject) obj;
                if (jSONObject2 == null) {
                    return false;
                }
                return stringComparison(key, jSONObject2, data);
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            }
        }
        return false;
    }

    @JvmStatic
    public static final String getMatchPropertyIDs(Bundle params) {
        String strOptString;
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return null;
        }
        try {
            JSONArray jSONArray = MACARules;
            if (jSONArray == null) {
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            Integer numValueOf = jSONArray == null ? null : Integer.valueOf(jSONArray.length());
            if (numValueOf != null && numValueOf.intValue() == 0) {
                return HttpUrl.PATH_SEGMENT_ENCODE_SET_URI;
            }
            JSONArray jSONArray2 = MACARules;
            if (jSONArray2 == null) {
                throw new NullPointerException("null cannot be cast to non-null type org.json.JSONArray");
            }
            ArrayList arrayList = new ArrayList();
            int length = jSONArray2.length();
            if (length > 0) {
                int i = 0;
                while (true) {
                    int i2 = i + 1;
                    String strOptString2 = jSONArray2.optString(i);
                    if (strOptString2 != null) {
                        JSONObject jSONObject = new JSONObject(strOptString2);
                        long jOptLong = jSONObject.optLong("id");
                        if (jOptLong != 0 && (strOptString = jSONObject.optString("rule")) != null && isMatchCCRule(strOptString, params)) {
                            arrayList.add(Long.valueOf(jOptLong));
                        }
                    }
                    if (i2 >= length) {
                        break;
                    }
                    i = i2;
                }
            }
            String string = new JSONArray((Collection) arrayList).toString();
            Intrinsics.checkNotNullExpressionValue(string, "JSONArray(res).toString()");
            return string;
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
            return null;
        }
    }

    @JvmStatic
    public static final void processParameters(Bundle params, String event) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(event, "event");
            if (!enabled || params == null) {
                return;
            }
            try {
                generateInfo(params, event);
                params.putString("_audiencePropertyIds", getMatchPropertyIDs(params));
                params.putString("cs_maca", "1");
                removeGeneratedInfo(params);
            } catch (Exception unused) {
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    @JvmStatic
    public static final void generateInfo(Bundle params, String event) {
        String language;
        String country;
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(params, "params");
            Intrinsics.checkNotNullParameter(event, "event");
            params.putString(NotificationCompat.CATEGORY_EVENT, event);
            StringBuilder sb = new StringBuilder();
            Locale locale = Utility.INSTANCE.getLocale();
            String str = "";
            if (locale == null || (language = locale.getLanguage()) == null) {
                language = "";
            }
            StringBuilder sbAppend = sb.append(language).append('_');
            Locale locale2 = Utility.INSTANCE.getLocale();
            if (locale2 == null || (country = locale2.getCountry()) == null) {
                country = "";
            }
            params.putString("_locale", sbAppend.append(country).toString());
            String versionName = Utility.INSTANCE.getVersionName();
            if (versionName == null) {
                versionName = "";
            }
            params.putString("_appVersion", versionName);
            params.putString("_deviceOS", "ANDROID");
            params.putString("_platform", "mobile");
            String str2 = Build.MODEL;
            if (str2 == null) {
                str2 = "";
            }
            params.putString("_deviceModel", str2);
            FacebookSdk facebookSdk = FacebookSdk.INSTANCE;
            params.putString("_nativeAppID", FacebookSdk.getApplicationId());
            String versionName2 = Utility.INSTANCE.getVersionName();
            if (versionName2 != null) {
                str = versionName2;
            }
            params.putString("_nativeAppShortVersion", str);
            params.putString("_timezone", Utility.INSTANCE.getDeviceTimeZoneName());
            params.putString("_carrier", Utility.INSTANCE.getCarrierName());
            params.putString("_deviceOSTypeName", "ANDROID");
            params.putString("_deviceOSVersion", Build.VERSION.RELEASE);
            params.putLong("_remainingDiskGB", Utility.INSTANCE.getAvailableExternalStorageGB());
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }

    @JvmStatic
    public static final void removeGeneratedInfo(Bundle params) {
        if (CrashShieldHandler.isObjectCrashing(MACARuleMatchingManager.class)) {
            return;
        }
        try {
            Intrinsics.checkNotNullParameter(params, "params");
            String[] strArr = keys;
            int length = strArr.length;
            int i = 0;
            while (i < length) {
                String str = strArr[i];
                i++;
                params.remove(str);
            }
        } catch (Throwable th) {
            CrashShieldHandler.handleThrowable(th, MACARuleMatchingManager.class);
        }
    }
}
