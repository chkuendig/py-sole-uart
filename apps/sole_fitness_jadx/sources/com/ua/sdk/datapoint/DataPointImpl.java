package com.ua.sdk.datapoint;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class DataPointImpl implements DataPoint {
    public static Parcelable.Creator<DataPointImpl> CREATOR = new Parcelable.Creator<DataPointImpl>() { // from class: com.ua.sdk.datapoint.DataPointImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataPointImpl createFromParcel(Parcel parcel) {
            return new DataPointImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public DataPointImpl[] newArray(int i) {
            return new DataPointImpl[i];
        }
    };
    private Date datetime;
    private Map<DataField, Object> fields;
    private Date startDatetime;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public DataPointImpl() {
        this.fields = new HashMap(4);
    }

    public DataPointImpl(DataPointImpl dataPointImpl) {
        HashMap map = new HashMap(4);
        this.fields = map;
        this.startDatetime = dataPointImpl.startDatetime;
        this.datetime = dataPointImpl.datetime;
        map.putAll(dataPointImpl.fields);
    }

    private DataPointImpl(Parcel parcel) {
        this.fields = new HashMap(4);
        this.startDatetime = (Date) parcel.readValue(Date.class.getClassLoader());
        this.datetime = (Date) parcel.readValue(Date.class.getClassLoader());
        int i = parcel.readInt();
        for (int i2 = 0; i2 < i; i2++) {
            this.fields.put((DataField) parcel.readValue(DataField.class.getClassLoader()), parcel.readValue(Object.class.getClassLoader()));
        }
    }

    @Override // com.ua.sdk.datapoint.DataPoint
    public Date getStartDatetime() {
        return this.startDatetime;
    }

    public void setStartDatetime(Date date) {
        this.startDatetime = date;
    }

    @Override // com.ua.sdk.datapoint.DataPoint
    public Date getDatetime() {
        return this.datetime;
    }

    public void setDatetime(Date date) {
        this.datetime = date;
    }

    public void setValue(DataField dataField, Long l) {
        this.fields.put(dataField, l);
    }

    public void setValue(DataField dataField, Double d) {
        this.fields.put(dataField, d);
    }

    @Override // com.ua.sdk.datapoint.DataPoint
    public Long getValueLong(DataField dataField) {
        Object obj = this.fields.get(dataField);
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof Double) {
            return Long.valueOf(((Double) obj).longValue());
        }
        return null;
    }

    @Override // com.ua.sdk.datapoint.DataPoint
    public Double getValueDouble(DataField dataField) {
        Object obj = this.fields.get(dataField);
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Long) {
            return Double.valueOf(((Long) obj).doubleValue());
        }
        return null;
    }

    public void reset() {
        this.startDatetime = null;
        this.datetime = null;
        this.fields.clear();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        DataPointImpl dataPointImpl = (DataPointImpl) obj;
        Date date = this.datetime;
        if (date == null ? dataPointImpl.datetime != null : !date.equals(dataPointImpl.datetime)) {
            return false;
        }
        Date date2 = this.startDatetime;
        if (date2 == null ? dataPointImpl.startDatetime != null : !date2.equals(dataPointImpl.startDatetime)) {
            return false;
        }
        Map<DataField, Object> map = this.fields;
        Map<DataField, Object> map2 = dataPointImpl.fields;
        return map == null ? map2 == null : map.equals(map2);
    }

    public int hashCode() {
        Date date = this.startDatetime;
        int iHashCode = (date != null ? date.hashCode() : 0) * 31;
        Date date2 = this.datetime;
        int iHashCode2 = (iHashCode + (date2 != null ? date2.hashCode() : 0)) * 31;
        Map<DataField, Object> map = this.fields;
        return iHashCode2 + (map != null ? map.hashCode() : 0);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.startDatetime);
        parcel.writeValue(this.datetime);
        parcel.writeInt(this.fields.size());
        for (DataField dataField : this.fields.keySet()) {
            parcel.writeValue(dataField);
            parcel.writeValue(this.fields.get(dataField));
        }
    }
}
