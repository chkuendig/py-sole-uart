package com.dyaco.sole.custom;

import android.content.Context;
import android.content.SharedPreferences;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

/* loaded from: classes.dex */
public class GPSUtil {
    private static boolean isRegisterGPS = false;
    private static String latLon;
    private static Location location;
    private static LocationManager locationManager;
    private static LocationListener mLocationListener = new LocationListener() { // from class: com.dyaco.sole.custom.GPSUtil.1
        @Override // android.location.LocationListener
        public void onProviderDisabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onProviderEnabled(String str) {
        }

        @Override // android.location.LocationListener
        public void onStatusChanged(String str, int i, Bundle bundle) {
        }

        @Override // android.location.LocationListener
        public void onLocationChanged(Location location2) {
            String unused = GPSUtil.latLon = location2.getLatitude() + "," + location2.getLongitude();
            StringBuilder sb = new StringBuilder();
            sb.append("onLocationChanged latLon = ");
            sb.append(GPSUtil.latLon);
            Global.printLog("d", "GPSUtil", sb.toString());
            if (GPSUtil.mOnGpsStatusListener != null) {
                GPSUtil.mOnGpsStatusListener.onLocationChanged(location2);
            }
        }
    };
    public static OnGpsStatusListener mOnGpsStatusListener;

    public interface OnGpsStatusListener {
        void onLocationChanged(Location location);
    }

    public static void setOnGpsStatusListener(OnGpsStatusListener onGpsStatusListener) {
        mOnGpsStatusListener = onGpsStatusListener;
    }

    private static String getProvider() {
        if (locationManager.isProviderEnabled("gps")) {
            return "gps";
        }
        if (locationManager.isProviderEnabled("network")) {
            return "network";
        }
        return null;
    }

    private static boolean checkEnableGPS() {
        return getProvider() != null;
    }

    public static void registerGps(Context context) {
        if (locationManager == null) {
            locationManager = (LocationManager) context.getSystemService("location");
        }
        if (!isRegisterGPS && checkEnableGPS()) {
            isRegisterGPS = true;
            String provider = getProvider();
            Location lastKnownLocation = locationManager.getLastKnownLocation(provider);
            locationManager.requestLocationUpdates(provider, 100L, 0.0f, mLocationListener);
            if (lastKnownLocation == null) {
                return;
            }
            try {
                Global.printLog("d", "GPSUtil", "registerGps  getLastKnownLocation Lat = " + lastKnownLocation.getLatitude() + "Long = " + lastKnownLocation.getLongitude());
                StringBuilder sb = new StringBuilder();
                sb.append(lastKnownLocation.getLatitude());
                sb.append(",");
                sb.append(lastKnownLocation.getLongitude());
                latLon = sb.toString();
                location = lastKnownLocation;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static void unregisterGps(Context context) {
        try {
            isRegisterGPS = false;
            if (locationManager == null) {
                locationManager = (LocationManager) context.getSystemService("location");
            }
            locationManager.removeUpdates(mLocationListener);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String getLatLon(Context context) {
        if (latLon == null) {
            latLon = Global.getSharedPreferences(context).getString("latLon", null);
        } else {
            SharedPreferences.Editor spfEditor = Global.getSpfEditor(context);
            spfEditor.putString("latLon", latLon);
            spfEditor.commit();
        }
        return latLon;
    }

    public static Location getLocation(Context context) {
        return location;
    }
}
