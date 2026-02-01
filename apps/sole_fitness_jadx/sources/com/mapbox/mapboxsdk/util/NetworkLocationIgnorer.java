package com.mapbox.mapboxsdk.util;

import com.mapbox.mapboxsdk.util.constants.UtilConstants;

/* loaded from: classes2.dex */
public class NetworkLocationIgnorer {
    private long mLastGps = 0;

    public boolean shouldIgnore(String str, long j) {
        if (!"gps".equals(str)) {
            return j < this.mLastGps + UtilConstants.GPS_WAIT_TIME;
        }
        this.mLastGps = j;
        return false;
    }
}
