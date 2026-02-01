package com.samsung.android.sdk.healthdata;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.RemoteException;
import android.text.TextUtils;
import android.util.Log;
import com.samsung.android.sdk.healthdata.IHealthDataObserver;
import com.samsung.android.sdk.internal.healthdata.ErrorUtil;
import com.samsung.android.sdk.internal.healthdata.RemoteConnectionException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* loaded from: classes5.dex */
public abstract class HealthDataObserver {
    private static final ArrayList<HealthDataObserver> c = new ArrayList<>();
    private final Handler a;
    private final IHealthDataObserver.Stub b = new a();

    class a extends IHealthDataObserver.Stub {
        a() {
        }

        @Override // com.samsung.android.sdk.healthdata.IHealthDataObserver
        public void onChange(String str) {
            if (HealthDataObserver.this.a != null) {
                HealthDataObserver.this.a.sendMessage(HealthDataObserver.this.a.obtainMessage(0, str));
            } else {
                HealthDataObserver.this.onChange(str);
            }
        }
    }

    private static class b extends Handler {
        private final WeakReference<HealthDataObserver> a;

        public b(HealthDataObserver healthDataObserver, Looper looper) {
            super(looper);
            this.a = new WeakReference<>(healthDataObserver);
        }

        @Override // android.os.Handler
        public void handleMessage(Message message) {
            HealthDataObserver healthDataObserver = this.a.get();
            if (healthDataObserver != null) {
                healthDataObserver.onChange((String) message.obj);
            }
        }
    }

    public HealthDataObserver(Handler handler) {
        this.a = handler == null ? null : new b(this, handler.getLooper());
    }

    public static void addObserver(HealthDataStore healthDataStore, String str, HealthDataObserver healthDataObserver) {
        if (TextUtils.isEmpty(str)) {
            throw new IllegalArgumentException("Data type is invalid");
        }
        if (healthDataObserver == null) {
            throw new IllegalArgumentException("Invalid observer instance");
        }
        ArrayList<HealthDataObserver> arrayList = c;
        synchronized (arrayList) {
            if (!arrayList.contains(healthDataObserver)) {
                arrayList.add(healthDataObserver);
            }
            try {
                IDataWatcher iDataWatcher = HealthDataStore.getInterface(healthDataStore).getIDataWatcher();
                if (iDataWatcher == null) {
                    throw new IllegalStateException("IDataWatcher is null");
                }
                iDataWatcher.registerDataObserver2(healthDataStore.a().getPackageName(), str, healthDataObserver.b);
            } catch (RemoteException e) {
                Log.d("Health.Observer", str + " registration failed: " + e.toString());
                throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e));
            }
        }
    }

    public static void removeObserver(HealthDataStore healthDataStore, HealthDataObserver healthDataObserver) {
        if (healthDataObserver == null) {
            throw new IllegalArgumentException("Invalid observer instance");
        }
        ArrayList<HealthDataObserver> arrayList = c;
        synchronized (arrayList) {
            arrayList.remove(healthDataObserver);
            try {
                IDataWatcher iDataWatcher = HealthDataStore.getInterface(healthDataStore).getIDataWatcher();
                if (iDataWatcher == null) {
                    throw new IllegalStateException("IDataWatcher is null");
                }
                iDataWatcher.unregisterDataObserver2(healthDataStore.a().getPackageName(), healthDataObserver.b);
            } catch (RemoteException e) {
                Log.d("Health.Observer", "Object unregistration failed: " + e.toString());
                throw new RemoteConnectionException(ErrorUtil.getRemoteExceptionMessage(e));
            }
        }
    }

    public abstract void onChange(String str);
}
