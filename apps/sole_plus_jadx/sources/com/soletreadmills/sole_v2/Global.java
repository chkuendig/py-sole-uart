package com.soletreadmills.sole_v2;

import com.soletreadmills.sole_v2._data.login.LoginUserData;
import com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences;
import com.soletreadmills.sole_v2._type.user.GenderType;
import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: Global.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\bÇ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\"\u001a\u00020\u0004R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\tR\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001a\u0010\u0012\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0014\u001a\u0004\u0018\u00010\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0007R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\u00048FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0018\u0010\u0002\u001a\u0004\b\u0019\u0010\u0007R\u0011\u0010\u001a\u001a\u00020\u001b8F¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u000e8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u000fR\u0014\u0010 \u001a\u0004\u0018\u00010!8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006#"}, d2 = {"Lcom/soletreadmills/sole_v2/Global;", "", "()V", "clubRaceTicket", "", "fmSecret", "getFmSecret", "()Ljava/lang/String;", "setFmSecret", "(Ljava/lang/String;)V", "fmToken", "getFmToken", "setFmToken", "isSubscription", "", "()Z", "setSubscription", "(Z)V", "isUseMachineControl", "setUseMachineControl", "loginAccountNo", "getLoginAccountNo$annotations", "getLoginAccountNo", "loginUuid", "getLoginUuid$annotations", "getLoginUuid", "sex", "Lcom/soletreadmills/sole_v2/_type/user/GenderType;", "getSex", "()Lcom/soletreadmills/sole_v2/_type/user/GenderType;", "unitType", "getUnitType", "userData", "Lcom/soletreadmills/sole_v2/_data/login/LoginUserData;", "calculateAge", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class Global {
    private static boolean isSubscription;
    public static LoginUserData userData;
    public static final Global INSTANCE = new Global();
    private static boolean isUseMachineControl = true;
    public static String clubRaceTicket = "";
    private static String fmToken = "";
    private static String fmSecret = "";
    public static final int $stable = 8;

    @JvmStatic
    public static /* synthetic */ void getLoginAccountNo$annotations() {
    }

    @JvmStatic
    public static /* synthetic */ void getLoginUuid$annotations() {
    }

    private Global() {
    }

    public final boolean isUseMachineControl() {
        return isUseMachineControl;
    }

    public final void setUseMachineControl(boolean z) {
        isUseMachineControl = z;
    }

    public final boolean isSubscription() {
        return isSubscription;
    }

    public final void setSubscription(boolean z) {
        isSubscription = z;
    }

    public static final String getLoginAccountNo() {
        String globalUserUuid;
        try {
            LoginUserData loginUserData = userData;
            if (loginUserData != null && (globalUserUuid = loginUserData.getGlobalUserUuid()) != null) {
                return globalUserUuid;
            }
            LoginUserData userData2 = MySharedPreferences.INSTANCE.getInstance().getUserData();
            if (userData2 != null) {
                return userData2.getGlobalUserUuid();
            }
            return null;
        } catch (Exception e) {
            Timber.INSTANCE.e(e.fillInStackTrace());
            return null;
        }
    }

    public static final String getLoginUuid() {
        try {
            LoginUserData loginUserData = userData;
            if (loginUserData != null) {
                return loginUserData.getUserUuid();
            }
            return null;
        } catch (Exception e) {
            Timber.INSTANCE.e(e.fillInStackTrace());
            return null;
        }
    }

    public final boolean getUnitType() {
        Integer measurementUnit;
        LoginUserData loginUserData = userData;
        return (loginUserData == null || loginUserData == null || (measurementUnit = loginUserData.getMeasurementUnit()) == null || measurementUnit.intValue() != 1) ? false : true;
    }

    public final GenderType getSex() {
        Object obj;
        try {
            Iterator<GenderType> it = GenderType.getEntries().iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                GenderType next = it.next();
                String id2 = next.getId();
                LoginUserData loginUserData = userData;
                if (Intrinsics.areEqual(id2, loginUserData != null ? loginUserData.getGender() : null)) {
                    obj = next;
                    break;
                }
            }
            GenderType genderType = (GenderType) obj;
            return genderType == null ? GenderType.Male : genderType;
        } catch (Exception e) {
            Timber.INSTANCE.e(e.fillInStackTrace());
            return GenderType.Male;
        }
    }

    public final String calculateAge() {
        LoginUserData loginUserData = userData;
        String birthDate = loginUserData != null ? loginUserData.getBirthDate() : null;
        if (birthDate == null) {
            return "30";
        }
        return String.valueOf(Period.between(LocalDate.parse(birthDate, DateTimeFormatter.ofPattern("yyyy-MM-dd")), LocalDate.now()).getYears());
    }

    public final String getFmToken() {
        return fmToken;
    }

    public final void setFmToken(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        fmToken = str;
    }

    public final String getFmSecret() {
        return fmSecret;
    }

    public final void setFmSecret(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        fmSecret = str;
    }
}
