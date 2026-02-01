package com.google.firebase.sessions.settings;

import androidx.datastore.core.DataStore;
import androidx.datastore.preferences.core.Preferences;
import com.google.firebase.installations.FirebaseInstallationsApi;
import com.google.firebase.sessions.ApplicationInfo;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.Regex;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* compiled from: RemoteSettings.kt */
@Metadata(d1 = {"\u0000d\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\b\u0000\u0018\u0000 +2\u00020\u0001:\u0001+B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\f0\u000b¢\u0006\u0002\u0010\rJ\r\u0010\"\u001a\u00020#H\u0001¢\u0006\u0002\b$J\b\u0010%\u001a\u00020\u0015H\u0016J\u0010\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0002J\u0011\u0010)\u001a\u00020#H\u0096@ø\u0001\u0000¢\u0006\u0002\u0010*R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0010\u001a\u0004\u0018\u00010\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0013R\u0016\u0010\u0014\u001a\u0004\u0018\u00010\u00158VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u001f\u0010\u0018\u001a\u0004\u0018\u00010\u00198VX\u0096\u0004ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001b\u0010\u001c\u001a\u00020\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001f\u0082\u0002\u000f\n\u0002\b\u0019\n\u0005\b¡\u001e0\u0001\n\u0002\b!¨\u0006,"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings;", "Lcom/google/firebase/sessions/settings/SettingsProvider;", "backgroundDispatcher", "Lkotlin/coroutines/CoroutineContext;", "firebaseInstallationsApi", "Lcom/google/firebase/installations/FirebaseInstallationsApi;", "appInfo", "Lcom/google/firebase/sessions/ApplicationInfo;", "configsFetcher", "Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;", "dataStore", "Landroidx/datastore/core/DataStore;", "Landroidx/datastore/preferences/core/Preferences;", "(Lkotlin/coroutines/CoroutineContext;Lcom/google/firebase/installations/FirebaseInstallationsApi;Lcom/google/firebase/sessions/ApplicationInfo;Lcom/google/firebase/sessions/settings/CrashlyticsSettingsFetcher;Landroidx/datastore/core/DataStore;)V", "fetchInProgress", "Lkotlinx/coroutines/sync/Mutex;", "samplingRate", "", "getSamplingRate", "()Ljava/lang/Double;", "sessionEnabled", "", "getSessionEnabled", "()Ljava/lang/Boolean;", "sessionRestartTimeout", "Lkotlin/time/Duration;", "getSessionRestartTimeout-FghU774", "()Lkotlin/time/Duration;", "settingsCache", "Lcom/google/firebase/sessions/settings/SettingsCache;", "getSettingsCache", "()Lcom/google/firebase/sessions/settings/SettingsCache;", "settingsCache$delegate", "Lkotlin/Lazy;", "clearCachedSettings", "", "clearCachedSettings$com_google_firebase_firebase_sessions", "isSettingsStale", "removeForwardSlashesIn", "", "s", "updateSettings", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class RemoteSettings implements SettingsProvider {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String FORWARD_SLASH_STRING = "/";

    @Deprecated
    public static final String TAG = "SessionConfigFetcher";
    private final ApplicationInfo appInfo;
    private final CoroutineContext backgroundDispatcher;
    private final CrashlyticsSettingsFetcher configsFetcher;
    private final Mutex fetchInProgress;
    private final FirebaseInstallationsApi firebaseInstallationsApi;

    /* renamed from: settingsCache$delegate, reason: from kotlin metadata */
    private final Lazy settingsCache;

    /* compiled from: RemoteSettings.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.google.firebase.sessions.settings.RemoteSettings", f = "RemoteSettings.kt", i = {0, 0, 1, 1, 2}, l = {170, 76, 94}, m = "updateSettings", n = {"this", "$this$withLock_u24default$iv", "this", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$1", "L$0", "L$1", "L$0"})
    /* renamed from: com.google.firebase.sessions.settings.RemoteSettings$updateSettings$1, reason: invalid class name */
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return RemoteSettings.this.updateSettings(this);
        }
    }

    public RemoteSettings(CoroutineContext backgroundDispatcher, FirebaseInstallationsApi firebaseInstallationsApi, ApplicationInfo appInfo, CrashlyticsSettingsFetcher configsFetcher, final DataStore<Preferences> dataStore) {
        Intrinsics.checkNotNullParameter(backgroundDispatcher, "backgroundDispatcher");
        Intrinsics.checkNotNullParameter(firebaseInstallationsApi, "firebaseInstallationsApi");
        Intrinsics.checkNotNullParameter(appInfo, "appInfo");
        Intrinsics.checkNotNullParameter(configsFetcher, "configsFetcher");
        Intrinsics.checkNotNullParameter(dataStore, "dataStore");
        this.backgroundDispatcher = backgroundDispatcher;
        this.firebaseInstallationsApi = firebaseInstallationsApi;
        this.appInfo = appInfo;
        this.configsFetcher = configsFetcher;
        this.settingsCache = LazyKt.lazy(new Function0<SettingsCache>() { // from class: com.google.firebase.sessions.settings.RemoteSettings$settingsCache$2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final SettingsCache invoke() {
                return new SettingsCache(dataStore);
            }
        });
        this.fetchInProgress = MutexKt.Mutex$default(false, 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final SettingsCache getSettingsCache() {
        return (SettingsCache) this.settingsCache.getValue();
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Boolean getSessionEnabled() {
        return getSettingsCache().sessionsEnabled();
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    /* renamed from: getSessionRestartTimeout-FghU774 */
    public Duration mo8583getSessionRestartTimeoutFghU774() {
        Integer numSessionRestartTimeout = getSettingsCache().sessionRestartTimeout();
        if (numSessionRestartTimeout == null) {
            return null;
        }
        Duration.Companion companion = Duration.INSTANCE;
        return Duration.m10411boximpl(DurationKt.toDuration(numSessionRestartTimeout.intValue(), DurationUnit.SECONDS));
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public Double getSamplingRate() {
        return getSettingsCache().sessionSamplingRate();
    }

    /* JADX WARN: Removed duplicated region for block: B:47:0x00bf A[Catch: all -> 0x004f, TRY_LEAVE, TryCatch #2 {all -> 0x004f, blocks: (B:21:0x004b, B:45:0x00b1, B:47:0x00bf, B:51:0x00cb), top: B:65:0x004b }] */
    /* JADX WARN: Removed duplicated region for block: B:50:0x00ca  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    @Override // com.google.firebase.sessions.settings.SettingsProvider
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public java.lang.Object updateSettings(kotlin.coroutines.Continuation<? super kotlin.Unit> r15) throws java.lang.Throwable {
        /*
            Method dump skipped, instructions count: 359
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.firebase.sessions.settings.RemoteSettings.updateSettings(kotlin.coroutines.Continuation):java.lang.Object");
    }

    @Override // com.google.firebase.sessions.settings.SettingsProvider
    public boolean isSettingsStale() {
        return getSettingsCache().hasCacheExpired$com_google_firebase_firebase_sessions();
    }

    public final void clearCachedSettings$com_google_firebase_firebase_sessions() {
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(this.backgroundDispatcher), null, null, new RemoteSettings$clearCachedSettings$1(this, null), 3, null);
    }

    private final String removeForwardSlashesIn(String s) {
        return new Regex("/").replace(s, "");
    }

    /* compiled from: RemoteSettings.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0082\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0006"}, d2 = {"Lcom/google/firebase/sessions/settings/RemoteSettings$Companion;", "", "()V", "FORWARD_SLASH_STRING", "", "TAG", "com.google.firebase-firebase-sessions"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
