package com.ua.sdk.group.objective;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.datapoint.BaseDataTypes;
import com.ua.sdk.datapoint.DataField;
import com.ua.sdk.datapoint.DataType;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.internal.Period;
import com.ua.sdk.net.json.Iso8601PeriodFormat;
import java.util.Date;

/* loaded from: classes2.dex */
public class GroupObjectiveImpl extends ApiTransferObject implements GroupObjective {
    public static Parcelable.Creator<GroupObjectiveImpl> CREATOR = new Parcelable.Creator<GroupObjectiveImpl>() { // from class: com.ua.sdk.group.objective.GroupObjectiveImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupObjectiveImpl createFromParcel(Parcel parcel) {
            return new GroupObjectiveImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupObjectiveImpl[] newArray(int i) {
            return new GroupObjectiveImpl[i];
        }
    };
    private static final String LINK_DATA_TYPE = "data_type";

    @SerializedName("criteria")
    Criteria criteria;
    transient DataField dataField;
    transient DataType dataType;

    @SerializedName("data_type_field")
    String dataTypeField;
    transient EntityRef<DataType> dataTypeRef;

    @SerializedName("end_datetime")
    Date endDate;

    @SerializedName("iteration")
    Integer iteration;

    @SerializedName("iteration_end_datetime")
    Date iterationEndDate;

    @SerializedName("iteration_start_datetime")
    Date iterationStartDate;

    @SerializedName("name")
    String name;

    @SerializedName(TypedValues.CycleType.S_WAVE_PERIOD)
    Period period;

    @SerializedName("start_datetime")
    Date startDate;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public GroupObjectiveImpl() {
    }

    private GroupObjectiveImpl(Parcel parcel) {
        super(parcel);
        this.period = (Period) parcel.readValue(Iso8601PeriodFormat.class.getClassLoader());
        this.startDate = (Date) parcel.readValue(Date.class.getClassLoader());
        this.endDate = (Date) parcel.readValue(Date.class.getClassLoader());
        this.iterationStartDate = (Date) parcel.readValue(Date.class.getClassLoader());
        this.iterationEndDate = (Date) parcel.readValue(Date.class.getClassLoader());
        this.iteration = (Integer) parcel.readValue(Integer.class.getClassLoader());
        this.dataTypeField = parcel.readString();
        this.name = parcel.readString();
        this.criteria = (Criteria) parcel.readParcelable(Criteria.class.getClassLoader());
    }

    @Override // com.ua.sdk.group.objective.GroupObjective
    public Period getPeriod() {
        return this.period;
    }

    @Override // com.ua.sdk.group.objective.GroupObjective
    public Date getStartDate() {
        return this.startDate;
    }

    @Override // com.ua.sdk.group.objective.GroupObjective
    public Date getEndDate() {
        return this.endDate;
    }

    @Override // com.ua.sdk.group.objective.GroupObjective
    public Date getIterationStartDate() {
        return this.iterationStartDate;
    }

    @Override // com.ua.sdk.group.objective.GroupObjective
    public Date getIterationEndDate() {
        return this.iterationEndDate;
    }

    @Override // com.ua.sdk.group.objective.GroupObjective
    public Integer getIteration() {
        return this.iteration;
    }

    @Override // com.ua.sdk.group.objective.GroupObjective
    public EntityRef<DataType> getDataTypeRef() {
        Link link;
        if (this.dataTypeRef == null && (link = getLink(LINK_DATA_TYPE)) != null) {
            this.dataTypeRef = new LinkEntityRef(link.getId(), link.getHref());
        }
        return this.dataTypeRef;
    }

    @Override // com.ua.sdk.group.objective.GroupObjective
    public DataType getDataType() {
        if (this.dataType == null && getDataTypeRef() != null) {
            this.dataType = BaseDataTypes.ALL_BASE_TYPE_MAP.get(this.dataTypeRef.getId());
        }
        return this.dataType;
    }

    @Override // com.ua.sdk.group.objective.GroupObjective
    public DataField getDataField() {
        String str;
        if (this.dataField == null && (str = this.dataTypeField) != null) {
            this.dataField = BaseDataTypes.findDataField(str, getDataType());
        }
        return this.dataField;
    }

    @Override // com.ua.sdk.group.objective.GroupObjective
    public String getName() {
        return this.name;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setPeriod(Period period) {
        this.period = period;
    }

    public void setStartDate(Date date) {
        this.startDate = date;
    }

    public void setEndDate(Date date) {
        this.endDate = date;
    }

    public void setIterationStartDate(Date date) {
        this.iterationStartDate = date;
    }

    public void setIterationEndDate(Date date) {
        this.iterationEndDate = date;
    }

    public void setIteration(Integer num) {
        this.iteration = num;
    }

    public void setDataField(DataField dataField) {
        if (dataField == null) {
            return;
        }
        this.dataField = BaseDataTypes.findDataField(dataField.getId(), getDataType());
    }

    public void setDataTypeField(String str) {
        this.dataTypeField = str;
    }

    public void setDataTypeRef(EntityRef<DataType> entityRef) {
        this.dataTypeRef = entityRef;
        addLink(LINK_DATA_TYPE, new Link(entityRef.getHref(), entityRef.getId()));
    }

    @Override // com.ua.sdk.group.objective.GroupObjective
    public Criteria getCriteria() {
        return this.criteria;
    }

    @Override // com.ua.sdk.group.objective.GroupObjective
    public void setCriteria(Criteria criteria) {
        this.criteria = criteria;
    }

    @Override // com.ua.sdk.Resource
    public EntityRef<GroupObjective> getRef() {
        Link link = getLink("self");
        if (link == null) {
            return null;
        }
        return new LinkEntityRef(link.getId(), link.getHref());
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeValue(this.period);
        parcel.writeValue(this.startDate);
        parcel.writeValue(this.endDate);
        parcel.writeValue(this.iterationStartDate);
        parcel.writeValue(this.iterationEndDate);
        parcel.writeValue(this.iteration);
        parcel.writeString(this.dataTypeField);
        parcel.writeString(this.name);
        parcel.writeParcelable(this.criteria, i);
    }
}
