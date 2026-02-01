package com.facebook.appevents.internal;

import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;

/* compiled from: ActivityLifecycleTracker.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "run"}, k = 3, mv = {1, 5, 1})
/* loaded from: classes.dex */
final class ActivityLifecycleTracker$onActivityPaused$handleActivityPaused$1 implements Runnable {
    final /* synthetic */ String $activityName;
    final /* synthetic */ long $currentTime;

    ActivityLifecycleTracker$onActivityPaused$handleActivityPaused$1(long j, String str) {
        this.$currentTime = j;
        this.$activityName = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        if (CrashShieldHandler.isObjectCrashing(this)) {
            return;
        }
        try {
            if (CrashShieldHandler.isObjectCrashing(this)) {
                return;
            }
            try {
                if (ActivityLifecycleTracker.access$getCurrentSession$p(ActivityLifecycleTracker.INSTANCE) == null) {
                    ActivityLifecycleTracker activityLifecycleTracker = ActivityLifecycleTracker.INSTANCE;
                    ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(this.$currentTime), null, null, 4, null);
                }
                SessionInfo sessionInfoAccess$getCurrentSession$p = ActivityLifecycleTracker.access$getCurrentSession$p(ActivityLifecycleTracker.INSTANCE);
                if (sessionInfoAccess$getCurrentSession$p != null) {
                    sessionInfoAccess$getCurrentSession$p.setSessionLastEventTime(Long.valueOf(this.$currentTime));
                }
                ActivityLifecycleTracker activityLifecycleTracker2 = ActivityLifecycleTracker.INSTANCE;
                if (ActivityLifecycleTracker.foregroundActivityCount.get() <= 0) {
                    Runnable runnable = new Runnable() { // from class: com.facebook.appevents.internal.ActivityLifecycleTracker$onActivityPaused$handleActivityPaused$1$task$1
                        @Override // java.lang.Runnable
                        public final void run() {
                            if (CrashShieldHandler.isObjectCrashing(this)) {
                                return;
                            }
                            try {
                                if (CrashShieldHandler.isObjectCrashing(this)) {
                                    return;
                                }
                                try {
                                    if (ActivityLifecycleTracker.access$getCurrentSession$p(ActivityLifecycleTracker.INSTANCE) == null) {
                                        ActivityLifecycleTracker activityLifecycleTracker3 = ActivityLifecycleTracker.INSTANCE;
                                        ActivityLifecycleTracker.currentSession = new SessionInfo(Long.valueOf(this.this$0.$currentTime), null, null, 4, null);
                                    }
                                    ActivityLifecycleTracker activityLifecycleTracker4 = ActivityLifecycleTracker.INSTANCE;
                                    if (ActivityLifecycleTracker.foregroundActivityCount.get() <= 0) {
                                        String str = this.this$0.$activityName;
                                        SessionInfo sessionInfoAccess$getCurrentSession$p2 = ActivityLifecycleTracker.access$getCurrentSession$p(ActivityLifecycleTracker.INSTANCE);
                                        ActivityLifecycleTracker activityLifecycleTracker5 = ActivityLifecycleTracker.INSTANCE;
                                        SessionLogger.logDeactivateApp(str, sessionInfoAccess$getCurrentSession$p2, ActivityLifecycleTracker.appId);
                                        SessionInfo.INSTANCE.clearSavedSessionFromDisk();
                                        ActivityLifecycleTracker activityLifecycleTracker6 = ActivityLifecycleTracker.INSTANCE;
                                        ActivityLifecycleTracker.currentSession = null;
                                    }
                                    ActivityLifecycleTracker activityLifecycleTracker7 = ActivityLifecycleTracker.INSTANCE;
                                    synchronized (ActivityLifecycleTracker.currentFutureLock) {
                                        ActivityLifecycleTracker activityLifecycleTracker8 = ActivityLifecycleTracker.INSTANCE;
                                        ActivityLifecycleTracker.currentFuture = null;
                                        Unit unit = Unit.INSTANCE;
                                    }
                                } catch (Throwable th) {
                                    CrashShieldHandler.handleThrowable(th, this);
                                }
                            } catch (Throwable th2) {
                                CrashShieldHandler.handleThrowable(th2, this);
                            }
                        }
                    };
                    ActivityLifecycleTracker activityLifecycleTracker3 = ActivityLifecycleTracker.INSTANCE;
                    synchronized (ActivityLifecycleTracker.currentFutureLock) {
                        ActivityLifecycleTracker activityLifecycleTracker4 = ActivityLifecycleTracker.INSTANCE;
                        ActivityLifecycleTracker activityLifecycleTracker5 = ActivityLifecycleTracker.INSTANCE;
                        ActivityLifecycleTracker.currentFuture = ActivityLifecycleTracker.singleThreadExecutor.schedule(runnable, ActivityLifecycleTracker.INSTANCE.getSessionTimeoutInSeconds(), TimeUnit.SECONDS);
                        Unit unit = Unit.INSTANCE;
                    }
                }
                ActivityLifecycleTracker activityLifecycleTracker6 = ActivityLifecycleTracker.INSTANCE;
                long j = ActivityLifecycleTracker.currentActivityAppearTime;
                AutomaticAnalyticsLogger.logActivityTimeSpentEvent(this.$activityName, j > 0 ? (this.$currentTime - j) / 1000 : 0L);
                SessionInfo sessionInfoAccess$getCurrentSession$p2 = ActivityLifecycleTracker.access$getCurrentSession$p(ActivityLifecycleTracker.INSTANCE);
                if (sessionInfoAccess$getCurrentSession$p2 != null) {
                    sessionInfoAccess$getCurrentSession$p2.writeSessionToDisk();
                }
            } catch (Throwable th) {
                CrashShieldHandler.handleThrowable(th, this);
            }
        } catch (Throwable th2) {
            CrashShieldHandler.handleThrowable(th2, this);
        }
    }
}
