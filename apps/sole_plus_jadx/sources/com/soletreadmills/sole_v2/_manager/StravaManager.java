package com.soletreadmills.sole_v2._manager;

import android.content.Context;
import android.net.Uri;
import android.widget.Toast;
import androidx.browser.customtabs.CustomTabsIntent;
import androidx.camera.video.AudioStats;
import androidx.core.app.NotificationCompat;
import androidx.core.content.ContextCompat;
import com.android.SdkConstants;
import com.facebook.gamingservices.cloudgaming.internal.SDKConstants;
import com.facebook.internal.NativeProtocol;
import com.soletreadmills.sole_v2.R;
import com.soletreadmills.sole_v2._data.WorkoutViewVo;
import com.soletreadmills.sole_v2._type.HistoryActivityType;
import com.sun.jna.platform.win32.WinError;
import java.util.Map;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Triple;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import okhttp3.ResponseBody;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Header;
import retrofit2.http.POST;

/* compiled from: StravaManager.kt */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001:\u0001'B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0082@¢\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004J\u000e\u0010\u0012\u001a\u00020\u000eH\u0086@¢\u0006\u0002\u0010\fJZ\u0010\u0013\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0086@¢\u0006\u0002\u0010\u001eJX\u0010\u001f\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\b\u0010 \u001a\u0004\u0018\u00010\u00042\u0006\u0010!\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u0004H\u0082@¢\u0006\u0002\u0010\"J2\u0010#\u001a\u0016\u0012\u0004\u0012\u00020\u0015\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\u00040\u00142\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010$\u001a\u00020%H\u0086@¢\u0006\u0002\u0010&R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \u0007*\u0004\u0018\u00010\t0\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006("}, d2 = {"Lcom/soletreadmills/sole_v2/_manager/StravaManager;", "", "()V", "STRAVA_API_URL", "", "retrofitStrava", "Lretrofit2/Retrofit;", "kotlin.jvm.PlatformType", "stravaService", "Lcom/soletreadmills/sole_v2/_manager/StravaManager$StravaApiService;", "getAccessToken", "Lcom/soletreadmills/sole_v2/_data/api/history/StravaGetAccessTokenApiData$ResponseData;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "openLoginPage", "", SdkConstants.ATTR_CONTEXT, "Landroid/content/Context;", "url", "revokeStrava", "shareActivitySuspend", "Lkotlin/Triple;", "", "name", "type", "startDateLocal", "elapsedTime", "", "distance", "", "description", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IFLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadActivity", "loginUrl", SDKConstants.PARAM_ACCESS_TOKEN, "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;IFLjava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "uploadWorkoutToStrava", NotificationCompat.CATEGORY_WORKOUT, "Lcom/soletreadmills/sole_v2/_data/WorkoutViewVo;", "(Landroid/content/Context;Lcom/soletreadmills/sole_v2/_data/WorkoutViewVo;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "StravaApiService", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class StravaManager {
    public static final int $stable;
    public static final StravaManager INSTANCE = new StravaManager();
    private static final String STRAVA_API_URL = "https://www.strava.com/api/v3/";
    private static final Retrofit retrofitStrava;
    private static final StravaApiService stravaService;

    /* compiled from: StravaManager.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J4\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\b\b\u0001\u0010\u0005\u001a\u00020\u00062\u0014\b\u0001\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00060\bH§@¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"Lcom/soletreadmills/sole_v2/_manager/StravaManager$StravaApiService;", "", "uploadActivity", "Lretrofit2/Response;", "Lokhttp3/ResponseBody;", "auth", "", NativeProtocol.WEB_DIALOG_PARAMS, "", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public interface StravaApiService {
        @FormUrlEncoded
        @POST("activities")
        Object uploadActivity(@Header("Authorization") String str, @FieldMap Map<String, String> map, Continuation<? super Response<ResponseBody>> continuation);
    }

    /* compiled from: StravaManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[HistoryActivityType.values().length];
            try {
                iArr[HistoryActivityType.RUNNING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[HistoryActivityType.CYCLING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[HistoryActivityType.ROWING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[HistoryActivityType.ELLIPTICAL.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr[HistoryActivityType.STAIR_CLIMBING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                iArr[HistoryActivityType.WALKING.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* compiled from: StravaManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2._manager.StravaManager", f = "StravaManager.kt", i = {}, l = {46}, m = "getAccessToken", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2._manager.StravaManager$getAccessToken$1, reason: invalid class name */
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
            return StravaManager.this.getAccessToken(this);
        }
    }

    /* compiled from: StravaManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2._manager.StravaManager", f = "StravaManager.kt", i = {}, l = {WinError.ERROR_LOCKED}, m = "revokeStrava", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2._manager.StravaManager$revokeStrava$1, reason: invalid class name and case insensitive filesystem */
    static final class C08401 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;

        C08401(Continuation<? super C08401> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StravaManager.this.revokeStrava(this);
        }
    }

    /* compiled from: StravaManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2._manager.StravaManager", f = "StravaManager.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {74, 79, 94}, m = "shareActivitySuspend", n = {"this", SdkConstants.ATTR_CONTEXT, "name", "type", "startDateLocal", "description", "elapsedTime", "distance"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "F$0"})
    /* renamed from: com.soletreadmills.sole_v2._manager.StravaManager$shareActivitySuspend$1, reason: invalid class name and case insensitive filesystem */
    static final class C08411 extends ContinuationImpl {
        float F$0;
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        C08411(Continuation<? super C08411> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StravaManager.this.shareActivitySuspend(null, null, null, null, 0, 0.0f, null, this);
        }
    }

    /* compiled from: StravaManager.kt */
    @Metadata(k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2._manager.StravaManager", f = "StravaManager.kt", i = {0, 0, 0, 1, 2, 3, 3, 4, 5}, l = {122, 124, 132, 140, 148, 151, 163}, m = "uploadActivity", n = {"this", SdkConstants.ATTR_CONTEXT, "loginUrl", SdkConstants.ATTR_CONTEXT, SdkConstants.ATTR_CONTEXT, "this", SdkConstants.ATTR_CONTEXT, SdkConstants.ATTR_CONTEXT, SdkConstants.ATTR_CONTEXT}, s = {"L$0", "L$1", "L$2", "L$0", "L$0", "L$0", "L$1", "L$0", "L$0"})
    /* renamed from: com.soletreadmills.sole_v2._manager.StravaManager$uploadActivity$1, reason: invalid class name and case insensitive filesystem */
    static final class C08421 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C08421(Continuation<? super C08421> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return StravaManager.this.uploadActivity(null, null, null, null, null, null, 0, 0.0f, null, this);
        }
    }

    private StravaManager() {
    }

    static {
        Retrofit retrofitBuild = new Retrofit.Builder().baseUrl(STRAVA_API_URL).addConverterFactory(GsonConverterFactory.create()).build();
        retrofitStrava = retrofitBuild;
        stravaService = (StravaApiService) retrofitBuild.create(StravaApiService.class);
        $stable = 8;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object getAccessToken(kotlin.coroutines.Continuation<? super com.soletreadmills.sole_v2._data.api.history.StravaGetAccessTokenApiData.ResponseData> r9) {
        /*
            r8 = this;
            java.lang.String r0 = "✅ 成功取得 Strava Token："
            java.lang.String r1 = "❌ 取得 Token 失敗："
            boolean r2 = r9 instanceof com.soletreadmills.sole_v2._manager.StravaManager.AnonymousClass1
            if (r2 == 0) goto L18
            r2 = r9
            com.soletreadmills.sole_v2._manager.StravaManager$getAccessToken$1 r2 = (com.soletreadmills.sole_v2._manager.StravaManager.AnonymousClass1) r2
            int r3 = r2.label
            r4 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r3 & r4
            if (r3 == 0) goto L18
            int r9 = r2.label
            int r9 = r9 - r4
            r2.label = r9
            goto L1d
        L18:
            com.soletreadmills.sole_v2._manager.StravaManager$getAccessToken$1 r2 = new com.soletreadmills.sole_v2._manager.StravaManager$getAccessToken$1
            r2.<init>(r9)
        L1d:
            java.lang.Object r9 = r2.result
            java.lang.Object r3 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r4 = r2.label
            r5 = 1
            java.lang.String r6 = "StravaManager"
            r7 = 0
            if (r4 == 0) goto L3b
            if (r4 != r5) goto L33
            kotlin.ResultKt.throwOnFailure(r9)     // Catch: java.lang.Exception -> L31
            goto L47
        L31:
            r9 = move-exception
            goto L8c
        L33:
            java.lang.IllegalStateException r9 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r9.<init>(r0)
            throw r9
        L3b:
            kotlin.ResultKt.throwOnFailure(r9)
            r2.label = r5     // Catch: java.lang.Exception -> L31
            java.lang.Object r9 = com.soletreadmills.sole_v2._network.DyacoApiKt.callStravaGetAccessToken(r2)     // Catch: java.lang.Exception -> L31
            if (r9 != r3) goto L47
            return r3
        L47:
            retrofit2.Response r9 = (retrofit2.Response) r9     // Catch: java.lang.Exception -> L31
            boolean r2 = r9.isSuccessful()     // Catch: java.lang.Exception -> L31
            if (r2 == 0) goto L6f
            java.lang.Object r9 = r9.body()     // Catch: java.lang.Exception -> L31
            com.soletreadmills.sole_v2._data.api.history.StravaGetAccessTokenApiData$ResponseData r9 = (com.soletreadmills.sole_v2._data.api.history.StravaGetAccessTokenApiData.ResponseData) r9     // Catch: java.lang.Exception -> L31
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L31
            r1.<init>(r0)     // Catch: java.lang.Exception -> L31
            if (r9 == 0) goto L61
            com.soletreadmills.sole_v2._data.api.history.StravaGetAccessTokenApiData$DataMap r0 = r9.getDataMap()     // Catch: java.lang.Exception -> L31
            goto L62
        L61:
            r0 = r7
        L62:
            java.lang.StringBuilder r0 = r1.append(r0)     // Catch: java.lang.Exception -> L31
            java.lang.String r0 = r0.toString()     // Catch: java.lang.Exception -> L31
            android.util.Log.d(r6, r0)     // Catch: java.lang.Exception -> L31
            r7 = r9
            goto La4
        L6f:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch: java.lang.Exception -> L31
            r0.<init>(r1)     // Catch: java.lang.Exception -> L31
            okhttp3.ResponseBody r9 = r9.errorBody()     // Catch: java.lang.Exception -> L31
            if (r9 == 0) goto L7f
            java.lang.String r9 = r9.string()     // Catch: java.lang.Exception -> L31
            goto L80
        L7f:
            r9 = r7
        L80:
            java.lang.StringBuilder r9 = r0.append(r9)     // Catch: java.lang.Exception -> L31
            java.lang.String r9 = r9.toString()     // Catch: java.lang.Exception -> L31
            android.util.Log.e(r6, r9)     // Catch: java.lang.Exception -> L31
            goto La4
        L8c:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "⚠️ 取得 Token 發生例外："
            r0.<init>(r1)
            java.lang.String r1 = r9.getMessage()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Throwable r9 = (java.lang.Throwable) r9
            android.util.Log.e(r6, r0, r9)
        La4:
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2._manager.StravaManager.getAccessToken(kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x00e8  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object shareActivitySuspend(android.content.Context r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, int r23, float r24, java.lang.String r25, kotlin.coroutines.Continuation<? super kotlin.Triple<java.lang.Boolean, java.lang.String, java.lang.String>> r26) {
        /*
            Method dump skipped, instructions count: 288
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2._manager.StravaManager.shareActivitySuspend(android.content.Context, java.lang.String, java.lang.String, java.lang.String, int, float, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00f8 A[Catch: Exception -> 0x007e, TryCatch #0 {Exception -> 0x007e, blocks: (B:62:0x0185, B:27:0x0078, B:38:0x00f0, B:40:0x00f8, B:43:0x0114, B:47:0x0120, B:50:0x013c, B:54:0x015a, B:57:0x0165), top: B:77:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0114 A[Catch: Exception -> 0x007e, TryCatch #0 {Exception -> 0x007e, blocks: (B:62:0x0185, B:27:0x0078, B:38:0x00f0, B:40:0x00f8, B:43:0x0114, B:47:0x0120, B:50:0x013c, B:54:0x015a, B:57:0x0165), top: B:77:0x0078 }] */
    /* JADX WARN: Removed duplicated region for block: B:64:0x0193 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01b9 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:7:0x001a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object uploadActivity(android.content.Context r17, java.lang.String r18, java.lang.String r19, java.lang.String r20, java.lang.String r21, java.lang.String r22, int r23, float r24, java.lang.String r25, kotlin.coroutines.Continuation<? super java.lang.Boolean> r26) {
        /*
            Method dump skipped, instructions count: 468
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2._manager.StravaManager.uploadActivity(android.content.Context, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, float, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* compiled from: StravaManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2._manager.StravaManager$uploadActivity$2", f = "StravaManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2._manager.StravaManager$uploadActivity$2, reason: invalid class name */
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Context context, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Context context = this.$context;
            Toast.makeText(context, context.getString(R.string.success), 0).show();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: StravaManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2._manager.StravaManager$uploadActivity$3", f = "StravaManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2._manager.StravaManager$uploadActivity$3, reason: invalid class name */
    static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass3(Context context, Continuation<? super AnonymousClass3> continuation) {
            super(2, continuation);
            this.$context = context;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass3(this.$context, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass3) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Context context = this.$context;
            Toast.makeText(context, context.getString(R.string.activity_may_already_exist), 0).show();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: StravaManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2._manager.StravaManager$uploadActivity$5", f = "StravaManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2._manager.StravaManager$uploadActivity$5, reason: invalid class name */
    static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Response<ResponseBody> $response;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass5(Context context, Response<ResponseBody> response, Continuation<? super AnonymousClass5> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$response = response;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass5(this.$context, this.$response, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass5) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Toast.makeText(this.$context, this.$context.getString(R.string.failed) + " :(" + this.$response.code() + ')', 0).show();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: StravaManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2._manager.StravaManager$uploadActivity$6", f = "StravaManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2._manager.StravaManager$uploadActivity$6, reason: invalid class name */
    static final class AnonymousClass6 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Response<ResponseBody> $response;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass6(Context context, Response<ResponseBody> response, Continuation<? super AnonymousClass6> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$response = response;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass6(this.$context, this.$response, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass6) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Toast.makeText(this.$context, this.$context.getString(R.string.failed) + " :(" + this.$response.code() + ')', 0).show();
            return Unit.INSTANCE;
        }
    }

    /* compiled from: StravaManager.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 9, 0}, xi = 48)
    @DebugMetadata(c = "com.soletreadmills.sole_v2._manager.StravaManager$uploadActivity$7", f = "StravaManager.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    /* renamed from: com.soletreadmills.sole_v2._manager.StravaManager$uploadActivity$7, reason: invalid class name */
    static final class AnonymousClass7 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Context $context;
        final /* synthetic */ Exception $e;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass7(Context context, Exception exc, Continuation<? super AnonymousClass7> continuation) {
            super(2, continuation);
            this.$context = context;
            this.$e = exc;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass7(this.$context, this.$e, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass7) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            Toast.makeText(this.$context, this.$context.getString(R.string.failed) + " :" + this.$e.getMessage(), 0).show();
            return Unit.INSTANCE;
        }
    }

    public final Object uploadWorkoutToStrava(Context context, WorkoutViewVo workoutViewVo, Continuation<? super Triple<Boolean, String, String>> continuation) {
        String str;
        String strName = workoutViewVo.getHistoryActivityType().name();
        switch (WhenMappings.$EnumSwitchMapping$0[workoutViewVo.getRootHistoryActivityType().ordinal()]) {
            case 1:
                str = "Run";
                break;
            case 2:
                str = "Ride";
                break;
            case 3:
                str = "Rowing";
                break;
            case 4:
                str = "Elliptical";
                break;
            case 5:
                str = "Stepper";
                break;
            case 6:
                str = "Walk";
                break;
            default:
                str = "Workout";
                break;
        }
        String str2 = str;
        String startTime = workoutViewVo.getStartTime();
        if (startTime == null) {
            startTime = "2025-10-23T08:00:00Z";
        }
        String str3 = startTime;
        Integer totalTime = workoutViewVo.getTotalTime();
        int iIntValue = totalTime != null ? totalTime.intValue() : 0;
        Double totalDistance = workoutViewVo.getTotalDistance();
        float fDoubleValue = (float) ((totalDistance != null ? totalDistance.doubleValue() : AudioStats.AUDIO_AMPLITUDE_NONE) * 1000);
        StringBuilder sbAppend = new StringBuilder().append(context.getString(R.string.heart_rate)).append(": ");
        Object avgHeartRate = workoutViewVo.getAvgHeartRate();
        Object obj = SdkConstants.RES_QUALIFIER_SEP;
        if (avgHeartRate == null) {
            avgHeartRate = SdkConstants.RES_QUALIFIER_SEP;
        }
        StringBuilder sbAppend2 = sbAppend.append(avgHeartRate).append(" bpm\n").append(context.getString(R.string.total_calories)).append(": ");
        Integer totalCalories = workoutViewVo.getTotalCalories();
        if (totalCalories != null) {
            obj = totalCalories;
        }
        return shareActivitySuspend(context, strName, str2, str3, iIntValue, fDoubleValue, sbAppend2.append(obj).append(" kcal").toString(), continuation);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object revokeStrava(kotlin.coroutines.Continuation<? super kotlin.Unit> r5) {
        /*
            r4 = this;
            boolean r0 = r5 instanceof com.soletreadmills.sole_v2._manager.StravaManager.C08401
            if (r0 == 0) goto L14
            r0 = r5
            com.soletreadmills.sole_v2._manager.StravaManager$revokeStrava$1 r0 = (com.soletreadmills.sole_v2._manager.StravaManager.C08401) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r5 = r0.label
            int r5 = r5 - r2
            r0.label = r5
            goto L19
        L14:
            com.soletreadmills.sole_v2._manager.StravaManager$revokeStrava$1 r0 = new com.soletreadmills.sole_v2._manager.StravaManager$revokeStrava$1
            r0.<init>(r5)
        L19:
            java.lang.Object r5 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 1
            if (r2 == 0) goto L34
            if (r2 != r3) goto L2c
            kotlin.ResultKt.throwOnFailure(r5)     // Catch: java.lang.Exception -> L2a
            goto L40
        L2a:
            r5 = move-exception
            goto L43
        L2c:
            java.lang.IllegalStateException r5 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r5.<init>(r0)
            throw r5
        L34:
            kotlin.ResultKt.throwOnFailure(r5)
            r0.label = r3     // Catch: java.lang.Exception -> L2a
            java.lang.Object r5 = com.soletreadmills.sole_v2._network.DyacoApiKt.callStravaOAuthRevoke(r0)     // Catch: java.lang.Exception -> L2a
            if (r5 != r1) goto L40
            return r1
        L40:
            retrofit2.Response r5 = (retrofit2.Response) r5     // Catch: java.lang.Exception -> L2a
            goto L5d
        L43:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            java.lang.String r1 = "⚠️ 取得 revokeStrava 發生例外："
            r0.<init>(r1)
            java.lang.String r1 = r5.getMessage()
            java.lang.StringBuilder r0 = r0.append(r1)
            java.lang.String r0 = r0.toString()
            java.lang.Throwable r5 = (java.lang.Throwable) r5
            java.lang.String r1 = "StravaManager"
            android.util.Log.e(r1, r0, r5)
        L5d:
            kotlin.Unit r5 = kotlin.Unit.INSTANCE
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.soletreadmills.sole_v2._manager.StravaManager.revokeStrava(kotlin.coroutines.Continuation):java.lang.Object");
    }

    public final void openLoginPage(Context context, String url) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(url, "url");
        CustomTabsIntent.Builder builder = new CustomTabsIntent.Builder();
        builder.setShowTitle(true);
        builder.setToolbarColor(ContextCompat.getColor(context, R.color.colorGlobal_accent));
        builder.setStartAnimations(context, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        builder.setExitAnimations(context, android.R.anim.slide_in_left, android.R.anim.slide_out_right);
        CustomTabsIntent customTabsIntentBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(customTabsIntentBuild, "build(...)");
        customTabsIntentBuild.launchUrl(context, Uri.parse(url));
    }
}
