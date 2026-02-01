package com.soletreadmills.sole_v2;

import android.icu.text.SimpleDateFormat;
import android.os.Build;
import com.android.SdkConstants;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Locale;
import java.util.TimeZone;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import timber.log.Timber;

/* compiled from: appConfig.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u000f\u001a\u0012\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0001H\u0002\u001a\u0006\u0010\u0003\u001a\u00020\u0004\u001a\u0006\u0010\u0005\u001a\u00020\u0004\u001a\b\u0010\u0006\u001a\u00020\u0001H\u0002\u001a\u000e\u0010\u0007\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\b\u001a\u0006\u0010\t\u001a\u00020\u0001\u001a\u0006\u0010\n\u001a\u00020\u0001\u001a\u0006\u0010\u000b\u001a\u00020\u0001\u001a\u0006\u0010\f\u001a\u00020\u0001\u001a\u0006\u0010\r\u001a\u00020\u0001\u001a\u0006\u0010\u000e\u001a\u00020\u0001\u001a\u0010\u0010\u000f\u001a\u00020\u00042\b\u0010\u0010\u001a\u0004\u0018\u00010\u0001\u001a\u0010\u0010\u0011\u001a\u00020\u00042\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001¨\u0006\u0013"}, d2 = {SdkConstants.ATTR_CAPITALIZE, "", "s", "clearServiceLoginToken", "", "clearSessionId", "getDeviceName", "getFirebaseMessagingToken", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getLang", "getServiceLoginToken", "getSessionId", "getTime", "getTimeStamp", "getTimezone", "setServiceLoginToken", "newToken", "setSessionId", "newSessionId", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class AppConfigKt {

    /* compiled from: appConfig.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2.AppConfigKt", f = "appConfig.kt", i = {}, l = {376}, m = "getFirebaseMessagingToken", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2.AppConfigKt$getFirebaseMessagingToken$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return AppConfigKt.getFirebaseMessagingToken(this);
        }
    }

    public static final String getTimezone() {
        TimeZone timeZone = TimeZone.getDefault();
        return String.valueOf(timeZone != null ? timeZone.getID() : null);
    }

    public static final String getLang() {
        String language = Locale.getDefault().getLanguage();
        if (language == null) {
            language = "en";
        }
        AppConfig.INSTANCE.setHEADER_LOCAL_LANGUAGE(language);
        return language;
    }

    public static final String getTime() {
        DateTimeFormatter dateTimeFormatterOfPattern = DateTimeFormatter.ofPattern(AppConfig.PATTERN_DATE_TIME, Locale.US);
        Intrinsics.checkNotNullExpressionValue(dateTimeFormatterOfPattern, "ofPattern(...)");
        return LocalDateTime.now().format(dateTimeFormatterOfPattern).toString();
    }

    public static final String getTimeStamp() {
        Date date = new SimpleDateFormat(AppConfig.PATTERN_DATE_TIME, Locale.getDefault()).parse(getTime());
        return String.valueOf(date != null ? Long.valueOf(date.getTime()) : null);
    }

    public static final void setSessionId(String str) {
        Timber.INSTANCE.i("set sessionId: " + str, new Object[0]);
        if (str != null) {
            AppConfig.INSTANCE.setSESSION_ID(str);
        } else {
            AppConfig.INSTANCE.setSESSION_ID("");
            Timber.INSTANCE.e("Error: sessionId: " + str, new Object[0]);
        }
    }

    public static final String getSessionId() {
        Timber.INSTANCE.i("get sessionId: " + AppConfig.INSTANCE.getSESSION_ID(), new Object[0]);
        return AppConfig.INSTANCE.getSESSION_ID();
    }

    public static final void clearSessionId() {
        AppConfig.INSTANCE.setSESSION_ID("");
    }

    public static final void setServiceLoginToken(String str) {
        Timber.INSTANCE.i("set ServiceLoginToken: " + str, new Object[0]);
        if (str != null) {
            AppConfig.INSTANCE.setSERVICE_LOGIN_TOKEN(str);
        } else {
            AppConfig.INSTANCE.setSERVICE_LOGIN_TOKEN("");
            Timber.INSTANCE.e("Error: ServiceLoginToken: " + str, new Object[0]);
        }
    }

    public static final String getServiceLoginToken() {
        Timber.INSTANCE.i("get ServiceLoginToken: " + AppConfig.INSTANCE.getSERVICE_LOGIN_TOKEN(), new Object[0]);
        return AppConfig.INSTANCE.getSERVICE_LOGIN_TOKEN();
    }

    public static final void clearServiceLoginToken() {
        AppConfig.INSTANCE.setSERVICE_LOGIN_TOKEN("");
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public static final java.lang.Object getFirebaseMessagingToken(kotlin.coroutines.Continuation<? super kotlin.Unit> r4) {
        /*
            boolean r0 = r4 instanceof com.soletreadmills.sole_v2.AppConfigKt.AnonymousClass1
            if (r0 == 0) goto L14
            r0 = r4
            com.soletreadmills.sole_v2.AppConfigKt$getFirebaseMessagingToken$1 r0 = (com.soletreadmills.sole_v2.AppConfigKt.AnonymousClass1) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r4 = r0.label
            int r4 = r4 - r2
            r0.label = r4
            goto L19
        L14:
            com.soletreadmills.sole_v2.AppConfigKt$getFirebaseMessagingToken$1 r0 = new com.soletreadmills.sole_v2.AppConfigKt$getFirebaseMessagingToken$1
            r0.<init>(r4)
        L19:
            java.lang.Object r4 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r4)     // Catch: java.lang.Exception -> L2a
            goto L54
        L2a:
            r4 = move-exception
            goto L68
        L2c:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r0)
            throw r4
        L34:
            kotlin.ResultKt.throwOnFailure(r4)
            java.lang.String r4 = "getFirebaseInstanceId----------"
            java.io.PrintStream r2 = java.lang.System.out     // Catch: java.lang.Exception -> L2a
            r2.println(r4)     // Catch: java.lang.Exception -> L2a
            com.google.firebase.messaging.FirebaseMessaging r4 = com.google.firebase.messaging.FirebaseMessaging.getInstance()     // Catch: java.lang.Exception -> L2a
            com.google.android.gms.tasks.Task r4 = r4.getToken()     // Catch: java.lang.Exception -> L2a
            java.lang.String r2 = "getToken(...)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r4, r2)     // Catch: java.lang.Exception -> L2a
            r0.label = r3     // Catch: java.lang.Exception -> L2a
            java.lang.Object r4 = kotlinx.coroutines.tasks.TasksKt.await(r4, r0)     // Catch: java.lang.Exception -> L2a
            if (r4 != r1) goto L54
            return r1
        L54:
            java.lang.String r4 = (java.lang.String) r4     // Catch: java.lang.Exception -> L2a
            com.soletreadmills.sole_v2.AppConfig r0 = com.soletreadmills.sole_v2.AppConfig.INSTANCE     // Catch: java.lang.Exception -> L2a
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)     // Catch: java.lang.Exception -> L2a
            r0.setPUSH_MESSAGE_TOKEN(r4)     // Catch: java.lang.Exception -> L2a
            com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences$Companion r0 = com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences.INSTANCE     // Catch: java.lang.Exception -> L2a
            com.soletreadmills.sole_v2._sharedPreferences.MySharedPreferences r0 = r0.getInstance()     // Catch: java.lang.Exception -> L2a
            r0.setSharedPushToken(r4)     // Catch: java.lang.Exception -> L2a
            goto L80
        L68:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "Fetching FCM registration token failed: "
            r0.<init>(r1)
            java.lang.String r4 = r4.getMessage()
            java.lang.StringBuilder r4 = r0.append(r4)
            java.lang.String r4 = r4.toString()
            java.io.PrintStream r0 = java.lang.System.out
            r0.println(r4)
        L80:
            kotlin.Unit r4 = kotlin.Unit.INSTANCE
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2.AppConfigKt.getFirebaseMessagingToken(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String getDeviceName() {
        String str = Build.MANUFACTURER;
        String str2 = Build.MODEL;
        String strValueOf = String.valueOf(Build.VERSION.SDK_INT);
        Intrinsics.checkNotNull(str2);
        Locale locale = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale, "getDefault(...)");
        String lowerCase = str2.toLowerCase(locale);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        Intrinsics.checkNotNull(str);
        Locale locale2 = Locale.getDefault();
        Intrinsics.checkNotNullExpressionValue(locale2, "getDefault(...)");
        String lowerCase2 = str.toLowerCase(locale2);
        Intrinsics.checkNotNullExpressionValue(lowerCase2, "toLowerCase(...)");
        if (StringsKt.startsWith$default(lowerCase, lowerCase2, false, 2, (Object) null)) {
            return capitalize(str2) + ' ' + strValueOf;
        }
        return capitalize(str) + ' ' + str2 + ' ' + strValueOf;
    }

    private static final String capitalize(String str) {
        String str2 = str;
        if (str2 == null || str2.length() == 0) {
            return "";
        }
        char cCharAt = str.charAt(0);
        if (Character.isUpperCase(cCharAt)) {
            return str;
        }
        StringBuilder sbAppend = new StringBuilder().append(Character.toUpperCase(cCharAt));
        String strSubstring = str.substring(1);
        Intrinsics.checkNotNullExpressionValue(strSubstring, "substring(...)");
        return sbAppend.append(strSubstring).toString();
    }
}
