package com.ua.sdk.recorder.datasource.sensor.location;

import android.location.GpsStatus;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.HandlerThread;
import android.os.SystemClock;
import com.ua.sdk.UaLog;
import com.ua.sdk.recorder.datasource.RollingAverage;
import com.ua.sdk.recorder.datasource.sensor.location.LocationClient;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class AndroidLocationClient implements LocationClient {
    private static final int ACCURACY_MOVING_AVG_COUNT = 3;
    private static final long DURATION_TO_FIX_LOST_MS = 10000;
    public static final float MINIMUM_DISTANCECHANGE_FOR_UPDATE_GPS = 0.0f;
    public static final long MINIMUM_TIME_BETWEEN_UPDATE_GPS = 1000;
    private MyLocationListener androidLocationListener;
    private LocationManager androidLocationManager;
    private HandlerThread handlerThread;
    private LocationClient.LocationClientListener locationClientListener;
    private long serviceStartRealtime = 0;
    private boolean serviceSeenFirstFix = false;
    private long previousLocationRealtime = 0;
    private boolean isRunning = false;
    private RollingAverage<Float> accuracyAccumulator = new RollingAverage<>(3);
    private boolean hasDispatched = false;
    private boolean curGpsEnabled = false;
    private boolean curGpsFix = false;
    private double curAccuracy = 0.0d;
    private boolean nextGpsEnabled = false;
    private boolean nextGpsFix = false;
    private double nextAccuracy = 0.0d;

    public AndroidLocationClient(LocationManager locationManager) {
        this.androidLocationManager = locationManager;
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.location.LocationClient
    public void connect(LocationClient.LocationClientListener locationClientListener) {
        this.locationClientListener = locationClientListener;
        this.serviceStartRealtime = SystemClock.elapsedRealtime();
        this.serviceSeenFirstFix = false;
        MyLocationListener myLocationListener = new MyLocationListener();
        this.androidLocationListener = myLocationListener;
        this.androidLocationManager.requestLocationUpdates("gps", 1000L, 0.0f, myLocationListener);
        this.androidLocationManager.addGpsStatusListener(this.androidLocationListener);
        this.isRunning = true;
    }

    @Override // com.ua.sdk.recorder.datasource.sensor.location.LocationClient
    public void disconnect() {
        MyLocationListener myLocationListener = this.androidLocationListener;
        if (myLocationListener != null) {
            this.androidLocationManager.removeUpdates(myLocationListener);
        }
        this.isRunning = false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dispatchOnStatus() {
        if (this.hasDispatched && this.curGpsEnabled == this.nextGpsEnabled && this.curGpsFix == this.nextGpsFix && this.curAccuracy == this.nextAccuracy) {
            return;
        }
        this.hasDispatched = true;
        boolean z = this.nextGpsEnabled;
        this.curGpsEnabled = z;
        boolean z2 = this.nextGpsFix;
        this.curGpsFix = z2;
        double d = this.nextAccuracy;
        this.curAccuracy = d;
        this.locationClientListener.onStatus(z, z2, Double.valueOf(d).floatValue());
    }

    protected class MyLocationListener implements LocationListener, GpsStatus.Listener {
        protected MyLocationListener() {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location) {
            if (location == null) {
                UaLog.warn("AndroidLocationClient bad location. location==null");
                return;
            }
            if (location.hasAccuracy() && location.getAccuracy() <= 0.0d) {
                UaLog.warn("AndroidLocationClient bad location. accuracy zero. " + location.toString());
                return;
            }
            if (location.getLatitude() == 0.0d && location.getLongitude() == 0.0d) {
                UaLog.warn("AndroidLocationClient bad location. lat/lng zero. " + location.toString());
                return;
            }
            if (location.getTime() != 0) {
                AndroidLocationClient.this.locationClientListener.onLocation(location);
                AndroidLocationClient.this.previousLocationRealtime = SystemClock.elapsedRealtime();
                if (location.hasAccuracy()) {
                    AndroidLocationClient.this.accuracyAccumulator.addValue(Float.valueOf(location.getAccuracy()));
                    AndroidLocationClient androidLocationClient = AndroidLocationClient.this;
                    androidLocationClient.nextAccuracy = androidLocationClient.accuracyAccumulator.getAverage();
                }
                AndroidLocationClient.this.dispatchOnStatus();
                return;
            }
            UaLog.warn("AndroidLocationClient bad location. time zero. " + location.toString());
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
            UaLog.info("AndroidLocationClient onStatusChanged " + str + StringUtils.SPACE + i);
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
            UaLog.warn("AndroidLocationClient onProviderEnabled");
        }

        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
            UaLog.warn("AndroidLocationClient onProviderDisabled");
        }

        @Override // android.location.GpsStatus.Listener
        public void onGpsStatusChanged(int i) {
            if (i == 1) {
                AndroidLocationClient.this.nextGpsEnabled = true;
                AndroidLocationClient.this.nextGpsFix = false;
            } else if (i == 2) {
                AndroidLocationClient.this.nextGpsEnabled = false;
                AndroidLocationClient.this.nextGpsFix = false;
            } else if (i == 3) {
                AndroidLocationClient.this.nextGpsEnabled = true;
                AndroidLocationClient.this.nextGpsFix = true;
            } else if (i == 4) {
                AndroidLocationClient.this.nextGpsEnabled = true;
                AndroidLocationClient.this.nextGpsFix = SystemClock.elapsedRealtime() - AndroidLocationClient.this.previousLocationRealtime < AndroidLocationClient.DURATION_TO_FIX_LOST_MS;
            } else {
                UaLog.warn("unknown GpsStatus event type. " + i);
                return;
            }
            AndroidLocationClient androidLocationClient = AndroidLocationClient.this;
            androidLocationClient.nextAccuracy = androidLocationClient.accuracyAccumulator.getAverage();
            AndroidLocationClient.this.dispatchOnStatus();
        }
    }
}
