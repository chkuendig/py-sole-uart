package com.ua.sdk.aggregate;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.datapoint.DataType;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.internal.Period;
import com.ua.sdk.user.User;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class AggregateImpl extends ApiTransferObject implements Aggregate {
    public static Parcelable.Creator<AggregateImpl> CREATOR = new Parcelable.Creator<AggregateImpl>() { // from class: com.ua.sdk.aggregate.AggregateImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AggregateImpl createFromParcel(Parcel parcel) {
            return new AggregateImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AggregateImpl[] newArray(int i) {
            return new AggregateImpl[i];
        }
    };
    protected static final String LINK_DATA_TYPE = "data_type";
    protected static final String LINK_USER = "user";
    transient EntityRef<DataType> dataTypeRef;

    @SerializedName(TypedValues.CycleType.S_WAVE_PERIOD)
    protected Period period;

    @SerializedName("periods")
    protected List<AggregateSummary> periods;

    @SerializedName("summary")
    protected AggregateSummary summary;
    transient EntityRef<User> userRef;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public AggregateImpl() {
    }

    protected AggregateImpl(Parcel parcel) {
        super(parcel);
        this.periods = new ArrayList();
        this.summary = (AggregateSummary) parcel.readValue(AggregateSummaryImpl.class.getClassLoader());
        parcel.readList(this.periods, AggregateSummary.class.getClassLoader());
        this.period = (Period) parcel.readValue(Period.class.getClassLoader());
    }

    @Override // com.ua.sdk.aggregate.Aggregate
    public AggregateSummary getSummary() {
        return this.summary;
    }

    public void setSummary(AggregateSummary aggregateSummary) {
        this.summary = aggregateSummary;
    }

    @Override // com.ua.sdk.aggregate.Aggregate
    public List<AggregateSummary> getPeriods() {
        return this.periods;
    }

    public void setPeriods(List<AggregateSummary> list) {
        List arrayList = list;
        if (list == null) {
            arrayList = new ArrayList();
        }
        arrayList.clear();
        arrayList.addAll(arrayList);
    }

    @Override // com.ua.sdk.aggregate.Aggregate
    public Period getPeriod() {
        return this.period;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    @Override // com.ua.sdk.aggregate.Aggregate
    public EntityRef<User> getUserRef() {
        Link link;
        if (this.userRef == null && (link = getLink("user")) != null) {
            this.userRef = new LinkEntityRef(link.getId(), link.getHref());
        }
        return this.userRef;
    }

    public void setUserRef(EntityRef<User> entityRef) {
        if (entityRef == null) {
            return;
        }
        this.userRef = entityRef;
        addLink("user", new Link(entityRef.getHref(), entityRef.getId()));
    }

    @Override // com.ua.sdk.aggregate.Aggregate
    public EntityRef<DataType> getDataTypeRef() {
        Link link;
        if (this.dataTypeRef == null && (link = getLink(LINK_DATA_TYPE)) != null) {
            this.dataTypeRef = new LinkEntityRef(link.getId(), link.getHref());
        }
        return this.dataTypeRef;
    }

    public void setDataTypeRef(EntityRef<DataType> entityRef) {
        if (entityRef == null) {
            return;
        }
        this.dataTypeRef = entityRef;
        addLink(LINK_DATA_TYPE, new Link(entityRef.getHref(), entityRef.getId()));
    }

    @Override // com.ua.sdk.Resource
    public EntityRef<Aggregate> getRef() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        if (this.periods == null) {
            this.periods = new ArrayList();
        }
        parcel.writeValue(this.summary);
        parcel.writeList(this.periods);
        parcel.writeValue(this.period);
    }
}
