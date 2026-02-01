package no.nordicsemi.android.ble.common.callback.cgm;

import android.os.Parcel;
import android.os.Parcelable;
import no.nordicsemi.android.ble.common.profile.cgm.CGMTypes;

/* loaded from: classes6.dex */
public class ContinuousGlucoseMeasurementResponseItem implements Parcelable {
    public static final Parcelable.Creator<ContinuousGlucoseMeasurementResponseItem> CREATOR = new Parcelable.Creator<ContinuousGlucoseMeasurementResponseItem>() { // from class: no.nordicsemi.android.ble.common.callback.cgm.ContinuousGlucoseMeasurementResponseItem.1
        @Override // android.os.Parcelable.Creator
        public ContinuousGlucoseMeasurementResponseItem createFromParcel(Parcel parcel) {
            return new ContinuousGlucoseMeasurementResponseItem(parcel);
        }

        @Override // android.os.Parcelable.Creator
        public ContinuousGlucoseMeasurementResponseItem[] newArray(int i) {
            return new ContinuousGlucoseMeasurementResponseItem[i];
        }
    };
    private float glucoseConcentration;
    private Float quality;
    private CGMTypes.CGMStatus status;
    private int timeOffset;
    private Float trend;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ContinuousGlucoseMeasurementResponseItem(float f, Float f2, Float f3, CGMTypes.CGMStatus cGMStatus, int i) {
        this.glucoseConcentration = f;
        this.trend = f2;
        this.quality = f3;
        this.status = cGMStatus;
        this.timeOffset = i;
    }

    public float getGlucoseConcentration() {
        return this.glucoseConcentration;
    }

    public Float getTrend() {
        return this.trend;
    }

    public Float getQuality() {
        return this.quality;
    }

    public CGMTypes.CGMStatus getStatus() {
        return this.status;
    }

    public int getTimeOffset() {
        return this.timeOffset;
    }

    public void setGlucoseConcentration(float f) {
        this.glucoseConcentration = f;
    }

    public void setTrend(Float f) {
        this.trend = f;
    }

    public void setQuality(Float f) {
        this.quality = f;
    }

    public void setStatus(CGMTypes.CGMStatus cGMStatus) {
        this.status = cGMStatus;
    }

    public void setTimeOffset(int i) {
        this.timeOffset = i;
    }

    ContinuousGlucoseMeasurementResponseItem(Parcel parcel) {
        this.glucoseConcentration = parcel.readFloat();
        if (parcel.readByte() == 0) {
            this.trend = null;
        } else {
            this.trend = Float.valueOf(parcel.readFloat());
        }
        if (parcel.readByte() == 0) {
            this.quality = null;
        } else {
            this.quality = Float.valueOf(parcel.readFloat());
        }
        if (parcel.readByte() == 0) {
            this.status = null;
        } else {
            this.status = new CGMTypes.CGMStatus(parcel.readInt(), parcel.readInt(), parcel.readInt());
        }
        this.timeOffset = parcel.readInt();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeFloat(this.glucoseConcentration);
        if (this.trend == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeFloat(this.trend.floatValue());
        }
        if (this.quality == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeFloat(this.quality.floatValue());
        }
        if (this.status == null) {
            parcel.writeByte((byte) 0);
        } else {
            parcel.writeByte((byte) 1);
            parcel.writeInt(this.status.warningStatus);
            parcel.writeInt(this.status.calibrationTempStatus);
            parcel.writeInt(this.status.sensorStatus);
        }
        parcel.writeInt(this.timeOffset);
    }
}
