package com.dyaco.sole;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.IBinder;
import android.util.Log;

/* loaded from: classes.dex */
public class GarminService extends Service {
    private Notification notification;
    private final String TAG = "GarminService";
    private HandlerThread bgHandlerThread = null;
    private Handler bgHandler = null;
    private final IBinder mBinder = new LocalBinder();
    private final Runnable getGarminUserActivityDataRunnable = new Runnable() { // from class: com.dyaco.sole.GarminService.1
        @Override // java.lang.Runnable
        public void run() {
            Log.d(GarminService.this.TAG, "getGarminUserActivityDataRunnable run");
            GarminService.this.getGarminUserActivityData(1, 15);
        }
    };

    public void getGarminUserActivityData(int i, int i2) {
    }

    public class LocalBinder extends Binder {
        public LocalBinder() {
        }

        public GarminService getService() {
            return GarminService.this;
        }
    }

    @Override // android.app.Service
    public void onCreate() {
        Log.d(this.TAG, "onCreate..");
        startBgHandler();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return this.mBinder;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent intent, int i, int i2) {
        Log.e(this.TAG, "onStartCommand Received start id " + i2 + ": " + intent);
        return 1;
    }

    @Override // android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Log.d(this.TAG, "onDestroy..");
        stopBgHandler();
    }

    void startBgHandler() {
        stopBgHandler();
        HandlerThread handlerThread = new HandlerThread(this.TAG + "BgHandlerThread", 10);
        this.bgHandlerThread = handlerThread;
        handlerThread.start();
        this.bgHandler = new Handler(this.bgHandlerThread.getLooper());
    }

    void stopBgHandler() {
        Handler handler = this.bgHandler;
        if (handler != null) {
            handler.removeCallbacks(this.getGarminUserActivityDataRunnable);
            this.bgHandler.removeCallbacksAndMessages(null);
        }
        this.bgHandler = null;
        HandlerThread handlerThread = this.bgHandlerThread;
        if (handlerThread != null) {
            handlerThread.quit();
        }
        this.bgHandlerThread = null;
    }

    public void startGetGarminUserActivityDataActivity() {
        Handler handler = this.bgHandler;
        if (handler != null) {
            handler.removeCallbacks(this.getGarminUserActivityDataRunnable);
            this.bgHandler.postDelayed(this.getGarminUserActivityDataRunnable, 1000L);
        }
    }
}
