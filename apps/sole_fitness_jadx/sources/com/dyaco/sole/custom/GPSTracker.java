package com.dyaco.sole.custom;

import android.app.AlertDialog;
import android.app.Service;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.IBinder;
import android.util.Log;

/* loaded from: classes.dex */
public class GPSTracker extends Service implements LocationListener {
    private static final float MIN_DISTANCE_CHANGE_FOR_UPDATES = 0.2f;
    private static final long MIN_TIME_BW_UPDATES = 1000;
    double latitude;
    Location location;
    private LocationListener locationListener;
    protected LocationManager locationManager;
    double longitude;
    private final Context mContext;
    boolean isGPSEnabled = false;
    boolean isNetworkEnabled = false;
    boolean canGetLocation = false;

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override // android.location.LocationListener
    public void onProviderDisabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onProviderEnabled(String str) {
    }

    @Override // android.location.LocationListener
    public void onStatusChanged(String str, int i, Bundle bundle) {
    }

    public GPSTracker(Context context) {
        this.mContext = context;
        getLocation();
    }

    public Location getLocation() {
        try {
            LocationManager locationManager = (LocationManager) this.mContext.getSystemService("location");
            this.locationManager = locationManager;
            this.isGPSEnabled = locationManager.isProviderEnabled("gps");
            boolean zIsProviderEnabled = this.locationManager.isProviderEnabled("network");
            this.isNetworkEnabled = zIsProviderEnabled;
            if (this.isGPSEnabled || zIsProviderEnabled) {
                this.canGetLocation = true;
                if (zIsProviderEnabled) {
                    this.locationManager.requestLocationUpdates("network", 1000L, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                    Log.d("Network", "Network");
                    LocationManager locationManager2 = this.locationManager;
                    if (locationManager2 != null) {
                        Location lastKnownLocation = locationManager2.getLastKnownLocation("network");
                        this.location = lastKnownLocation;
                        if (lastKnownLocation != null) {
                            this.latitude = lastKnownLocation.getLatitude();
                            this.longitude = this.location.getLongitude();
                        }
                    }
                }
                if (this.isGPSEnabled && this.location == null) {
                    this.locationManager.requestLocationUpdates("gps", 1000L, MIN_DISTANCE_CHANGE_FOR_UPDATES, this);
                    Log.d("GPS Enabled", "GPS Enabled");
                    LocationManager locationManager3 = this.locationManager;
                    if (locationManager3 != null) {
                        Location lastKnownLocation2 = locationManager3.getLastKnownLocation("gps");
                        this.location = lastKnownLocation2;
                        if (lastKnownLocation2 != null) {
                            this.latitude = lastKnownLocation2.getLatitude();
                            this.longitude = this.location.getLongitude();
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return this.location;
    }

    public void stopUsingGPS() {
        LocationManager locationManager = this.locationManager;
        if (locationManager != null) {
            locationManager.removeUpdates(this);
        }
    }

    public double getLatitude() {
        Location location = this.location;
        if (location != null) {
            this.latitude = location.getLatitude();
        }
        return this.latitude;
    }

    public double getLongitude() {
        Location location = this.location;
        if (location != null) {
            this.longitude = location.getLongitude();
        }
        return this.longitude;
    }

    public boolean canGetLocation() {
        return this.canGetLocation;
    }

    public void showSettingsAlert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this.mContext);
        builder.setTitle("GPS is settings");
        builder.setMessage("GPS is not enabled. Do you want to go to settings menu?");
        builder.setPositiveButton("Settings", new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.custom.GPSTracker.1
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                GPSTracker.this.mContext.startActivity(new Intent("android.settings.LOCATION_SOURCE_SETTINGS"));
            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() { // from class: com.dyaco.sole.custom.GPSTracker.2
            @Override // android.content.DialogInterface.OnClickListener
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });
        builder.show();
    }

    @Override // android.location.LocationListener
    public void onLocationChanged(Location location) {
        this.latitude = location.getLatitude();
        this.longitude = location.getLongitude();
        LocationListener locationListener = this.locationListener;
        if (locationListener != null) {
            locationListener.onLocationChanged(location);
        }
    }

    public void updateGps(LocationListener locationListener) {
        this.locationListener = locationListener;
    }
}
