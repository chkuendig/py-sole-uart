package com.ua.sdk.aggregate;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.datapoint.DataField;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class AggregateSummaryImpl implements AggregateSummary {
    public static Parcelable.Creator<AggregateSummaryImpl> CREATOR = new Parcelable.Creator<AggregateSummaryImpl>() { // from class: com.ua.sdk.aggregate.AggregateSummaryImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AggregateSummaryImpl createFromParcel(Parcel parcel) {
            return new AggregateSummaryImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AggregateSummaryImpl[] newArray(int i) {
            return new AggregateSummaryImpl[i];
        }
    };

    @SerializedName("datetime")
    Date datetime;

    @SerializedName("start_datetime")
    Date startDatetime;

    @SerializedName("value")
    Map<String, Object> value;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AggregateSummaryImpl() {
        this.value = new HashMap(4);
    }

    private AggregateSummaryImpl(Parcel parcel) {
        this.value = new HashMap(4);
        this.startDatetime = (Date) parcel.readValue(Date.class.getClassLoader());
        this.datetime = (Date) parcel.readValue(Date.class.getClassLoader());
        parcel.readMap(this.value, HashMap.class.getClassLoader());
    }

    @Override // com.ua.sdk.aggregate.AggregateSummary
    public Date getStartDatetime() {
        return this.startDatetime;
    }

    @Override // com.ua.sdk.aggregate.AggregateSummary
    public Date getDatetime() {
        return this.datetime;
    }

    @Override // com.ua.sdk.aggregate.AggregateSummary
    public Long getValueLong(DataField dataField) {
        if (dataField == null) {
            return null;
        }
        Object obj = this.value.get(dataField.getId());
        if (obj instanceof Long) {
            return (Long) obj;
        }
        if (obj instanceof Double) {
            return Long.valueOf(((Double) obj).longValue());
        }
        return null;
    }

    @Override // com.ua.sdk.aggregate.AggregateSummary
    public Double getValueDouble(DataField dataField) {
        if (dataField == null) {
            return null;
        }
        Object obj = this.value.get(dataField.getId());
        if (obj instanceof Double) {
            return (Double) obj;
        }
        if (obj instanceof Long) {
            return Double.valueOf(((Long) obj).doubleValue());
        }
        return null;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.startDatetime);
        parcel.writeValue(this.datetime);
        parcel.writeMap(this.value);
    }
}
