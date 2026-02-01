package com.soletreadmills.sole_v2;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import com.soletreadmills.sole_v2._manager.BleManager;
import com.soletreadmills.sole_v2._manager.MyNotificationManager;
import com.soletreadmills.sole_v2._manager.WearServiceManager;
import com.soletreadmills.sole_v2.ui.MainActivity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import timber.log.Timber;

/* compiled from: MyApplication.kt */
@Metadata(d1 = {"\u00003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002*\u0001\u0004\b\u0007\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\u0019\u001a\u00020\u001aH\u0016R\u0010\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0005R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001e\u0010\f\u001a\u0004\u0018\u00010\rX\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u0012\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018¨\u0006\u001c"}, d2 = {"Lcom/soletreadmills/sole_v2/MyApplication;", "Landroid/app/Application;", "()V", "activityLifecycleCallbacks", "com/soletreadmills/sole_v2/MyApplication$activityLifecycleCallbacks$1", "Lcom/soletreadmills/sole_v2/MyApplication$activityLifecycleCallbacks$1;", "mainActivity", "Lcom/soletreadmills/sole_v2/ui/MainActivity;", "getMainActivity", "()Lcom/soletreadmills/sole_v2/ui/MainActivity;", "setMainActivity", "(Lcom/soletreadmills/sole_v2/ui/MainActivity;)V", "statusBarHeight", "", "getStatusBarHeight", "()Ljava/lang/Integer;", "setStatusBarHeight", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "wearServiceManager", "Lcom/soletreadmills/sole_v2/_manager/WearServiceManager;", "getWearServiceManager", "()Lcom/soletreadmills/sole_v2/_manager/WearServiceManager;", "setWearServiceManager", "(Lcom/soletreadmills/sole_v2/_manager/WearServiceManager;)V", "onCreate", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class MyApplication extends Application {
    private static boolean AUTO_RECONNECT;
    private static Context appContext;
    private final MyApplication$activityLifecycleCallbacks$1 activityLifecycleCallbacks = new Application.ActivityLifecycleCallbacks() { // from class: com.soletreadmills.sole_v2.MyApplication$activityLifecycleCallbacks$1
        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityCreated(Activity activity, Bundle savedInstanceState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Timber.INSTANCE.d("onActivityCreated activity=" + activity, new Object[0]);
            if (activity instanceof MainActivity) {
                this.this$0.setMainActivity((MainActivity) activity);
            }
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStarted(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Timber.INSTANCE.d("onActivityStarted activity=" + activity, new Object[0]);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityResumed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Timber.INSTANCE.d("onActivityResumed activity=" + activity, new Object[0]);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityPaused(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Timber.INSTANCE.d("onActivityPaused activity=" + activity, new Object[0]);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityStopped(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Timber.INSTANCE.d("onActivityStopped activity=" + activity, new Object[0]);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivitySaveInstanceState(Activity activity, Bundle outState) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(outState, "outState");
            Timber.INSTANCE.d("onActivitySaveInstanceState activity=" + activity, new Object[0]);
        }

        @Override // android.app.Application.ActivityLifecycleCallbacks
        public void onActivityDestroyed(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Timber.INSTANCE.d("onActivityDestroyed activity=" + activity, new Object[0]);
            if (activity instanceof MainActivity) {
                MyApplication myApplication = this.this$0;
                synchronized (myApplication) {
                    BleManager.getInstance().destroy();
                    myApplication.setMainActivity(null);
                    MyApplication.INSTANCE.setAUTO_RECONNECT(false);
                    Unit unit = Unit.INSTANCE;
                }
            }
        }
    };
    private MainActivity mainActivity;
    private Integer statusBarHeight;
    private WearServiceManager wearServiceManager;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    /* compiled from: MyApplication.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001e\u0010\u000b\u001a\u00020\n2\u0006\u0010\t\u001a\u00020\n@BX\u0086.¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u000e"}, d2 = {"Lcom/soletreadmills/sole_v2/MyApplication$Companion;", "", "()V", "AUTO_RECONNECT", "", "getAUTO_RECONNECT", "()Z", "setAUTO_RECONNECT", "(Z)V", "<set-?>", "Landroid/content/Context;", "appContext", "getAppContext", "()Landroid/content/Context;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Context getAppContext() {
            Context context = MyApplication.appContext;
            if (context != null) {
                return context;
            }
            Intrinsics.throwUninitializedPropertyAccessException("appContext");
            return null;
        }

        public final boolean getAUTO_RECONNECT() {
            return MyApplication.AUTO_RECONNECT;
        }

        public final void setAUTO_RECONNECT(boolean z) {
            MyApplication.AUTO_RECONNECT = z;
        }
    }

    public final MainActivity getMainActivity() {
        return this.mainActivity;
    }

    public final void setMainActivity(MainActivity mainActivity) {
        this.mainActivity = mainActivity;
    }

    public final Integer getStatusBarHeight() {
        return this.statusBarHeight;
    }

    public final void setStatusBarHeight(Integer num) {
        this.statusBarHeight = num;
    }

    public final WearServiceManager getWearServiceManager() {
        return this.wearServiceManager;
    }

    public final void setWearServiceManager(WearServiceManager wearServiceManager) {
        this.wearServiceManager = wearServiceManager;
    }

    @Override // android.app.Application
    public void onCreate() {
        super.onCreate();
        registerActivityLifecycleCallbacks(this.activityLifecycleCallbacks);
        Context applicationContext = getApplicationContext();
        Intrinsics.checkNotNullExpressionValue(applicationContext, "getApplicationContext(...)");
        appContext = applicationContext;
        BleManager.getInstance().setMyApplication(this);
        AppConfig appConfig = AppConfig.INSTANCE;
        String string = Settings.Secure.getString(getContentResolver(), "android_id");
        Intrinsics.checkNotNullExpressionValue(string, "getString(...)");
        appConfig.setHEADER_ANDROID_ID(string);
        this.wearServiceManager = new WearServiceManager();
        MyNotificationManager.INSTANCE.getInstance().setMyApplication(this);
    }
}
