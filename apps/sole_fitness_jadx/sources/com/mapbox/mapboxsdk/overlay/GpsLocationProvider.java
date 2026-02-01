package com.mapbox.mapboxsdk.overlay;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import com.mapbox.mapboxsdk.util.NetworkLocationIgnorer;

/* loaded from: classes2.dex */
public class GpsLocationProvider implements LocationListener {
    private Location mLocation;
    private final LocationManager mLocationManager;
    private UserLocationOverlay mMyLocationConsumer;
    private long mLocationUpdateMinTime = 0;
    private float mLocationUpdateMinDistance = 0.0f;
    private final NetworkLocationIgnorer mIgnorer = new NetworkLocationIgnorer();

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public GpsLocationProvider(Context context) {
        this.mLocationManager = (LocationManager) context.getSystemService("location");
    }

    public long getLocationUpdateMinTime() {
        return this.mLocationUpdateMinTime;
    }

    public void setLocationUpdateMinTime(long j) {
        this.mLocationUpdateMinTime = j;
    }

    public float getLocationUpdateMinDistance() {
        return this.mLocationUpdateMinDistance;
    }

    public void setLocationUpdateMinDistance(float f) {
        this.mLocationUpdateMinDistance = f;
    }

    public boolean startLocationProvider(UserLocationOverlay userLocationOverlay) {
        this.mMyLocationConsumer = userLocationOverlay;
        boolean z = false;
        for (String str : this.mLocationManager.getProviders(true)) {
            if ("gps".equals(str) || "passive".equals(str) || "network".equals(str)) {
                if (this.mLocation == null) {
                    Location lastKnownLocation = this.mLocationManager.getLastKnownLocation(str);
                    this.mLocation = lastKnownLocation;
                    if (lastKnownLocation != null) {
                        this.mMyLocationConsumer.onLocationChanged(lastKnownLocation, this);
                    }
                }
                this.mLocationManager.requestLocationUpdates(str, this.mLocationUpdateMinTime, this.mLocationUpdateMinDistance, this);
                z = true;
            }
        }
        return z;
    }

    public void stopLocationProvider() {
        this.mMyLocationConsumer = null;
        this.mLocationManager.removeUpdates(this);
    }

    public Location getLastKnownLocation() {
        return this.mLocation;
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        if (this.mIgnorer.shouldIgnore(location.getProvider(), System.currentTimeMillis())) {
            return;
        }
        this.mLocation = location;
        UserLocationOverlay userLocationOverlay = this.mMyLocationConsumer;
        if (userLocationOverlay != null) {
            userLocationOverlay.onLocationChanged(location, this);
        }
    }
}
