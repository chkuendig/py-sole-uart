package androidx.health.platform.client.impl.sdkservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.util.Log;
import com.google.common.util.concurrent.ThreadFactoryBuilder;
import java.util.concurrent.Executors;

/* loaded from: classes2.dex */
public final class HealthDataSdkService extends Service {
    static final String BIND_ACTION = "androidx.health.platform.client.ACTION_BIND_SDK_SERVICE";
    private static final String TAG = "HealthDataSdkService";

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        String action = intent.getAction();
        if (!BIND_ACTION.equals(action)) {
            Log.i(TAG, String.format("Bind request with an invalid action [%s]", action));
            return null;
        }
        return new HealthDataSdkServiceStubImpl(getApplicationContext(), Executors.newSingleThreadExecutor(new ThreadFactoryBuilder().setNameFormat("HealthData-HealthDataSdkService-%d").build()));
    }
}
