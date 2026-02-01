package com.ua.sdk.recorder.datasource.derived.location;

import com.ua.sdk.UaLog;
import com.ua.sdk.datapoint.BaseDataTypes;
import com.ua.sdk.datapoint.DataPointImpl;

/* loaded from: classes2.dex */
public class KalmanFilter {
    public static final double KALMAN_NOISE_VALUE = 500.0d;
    private static boolean jniLoaded;
    private long kalmanFilterPtr = 0;
    private double previousTime = 0.0d;

    protected native long allocNative(double d);

    protected native double getLatNative(long j);

    protected native double getLngNative(long j);

    protected native void releaseNative(long j);

    protected native void updateNative(long j, double d, double d2, double d3);

    static {
        try {
            System.loadLibrary("KalmanFilterJni");
            jniLoaded = true;
        } catch (Throwable th) {
            jniLoaded = false;
            UaLog.error("KalmanFilterJni was NOT loaded. Entering graceful fail mode.", th);
        }
    }

    public KalmanFilter() {
        init(500.0d);
    }

    public DataPointImpl update(DataPointImpl dataPointImpl) {
        if (jniLoaded) {
            double time = dataPointImpl.getDatetime().getTime() / 1000.0d;
            double d = this.previousTime;
            double d2 = d != 0.0d ? time - d : 0.0d;
            this.previousTime = time;
            updateNative(this.kalmanFilterPtr, dataPointImpl.getValueDouble(BaseDataTypes.FIELD_LATITUDE).doubleValue(), dataPointImpl.getValueDouble(BaseDataTypes.FIELD_LONGITUDE).doubleValue(), d2);
            DataPointImpl dataPointImpl2 = new DataPointImpl(dataPointImpl);
            dataPointImpl2.setValue(BaseDataTypes.FIELD_LATITUDE, Double.valueOf(getLatNative(this.kalmanFilterPtr)));
            dataPointImpl2.setValue(BaseDataTypes.FIELD_LONGITUDE, Double.valueOf(getLngNative(this.kalmanFilterPtr)));
            return dataPointImpl2;
        }
        return new DataPointImpl(dataPointImpl);
    }

    private void init(double d) {
        this.kalmanFilterPtr = allocNative(d);
    }

    protected void finalize() throws Throwable {
        releaseNative(this.kalmanFilterPtr);
        super.finalize();
    }
}
