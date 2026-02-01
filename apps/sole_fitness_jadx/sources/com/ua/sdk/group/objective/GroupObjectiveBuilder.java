package com.ua.sdk.group.objective;

import com.ua.sdk.datapoint.DataField;
import com.ua.sdk.datapoint.DataType;
import com.ua.sdk.datapoint.DataTypeRef;
import com.ua.sdk.internal.Period;
import com.ua.sdk.internal.Precondition;
import java.util.Date;

/* loaded from: classes2.dex */
public class GroupObjectiveBuilder {
    Criteria criteria;
    String dataTypeField;
    DataTypeRef dataTypeRef;
    Date endDate;
    int iteration;
    Date iterationEndDate;
    Date iterationStartDate;
    String name;
    Period period;
    Date startDate;

    public GroupObjectiveBuilder setStartDate(Date date) {
        this.startDate = date;
        return this;
    }

    public GroupObjectiveBuilder setEndDate(Date date) {
        this.endDate = date;
        return this;
    }

    public GroupObjectiveBuilder setIterationStartDate(Date date) {
        this.iterationStartDate = date;
        return this;
    }

    public GroupObjectiveBuilder setIterationEndDate(Date date) {
        this.iterationEndDate = date;
        return this;
    }

    public GroupObjectiveBuilder setIteration(int i) {
        this.iteration = i;
        return this;
    }

    public GroupObjectiveBuilder setPeriod(Period period) {
        this.period = period;
        return this;
    }

    public GroupObjectiveBuilder setDataType(DataType dataType) throws NullPointerException {
        Precondition.isNotNull(dataType);
        this.dataTypeRef = dataType.getRef();
        return this;
    }

    public GroupObjectiveBuilder setDataField(DataField dataField) throws NullPointerException {
        Precondition.isNotNull(dataField);
        this.dataTypeField = dataField.getId();
        return this;
    }

    public GroupObjectiveBuilder setName(String str) {
        this.name = str;
        return this;
    }

    public GroupObjectiveBuilder setCriteria(Criteria criteria) {
        this.criteria = criteria;
        return this;
    }

    public GroupObjective build() throws NullPointerException {
        Precondition.isNotNull(this.dataTypeRef, "dataTypeRef");
        Precondition.isNotNull(this.dataTypeField, "dataTypeField");
        if (this.startDate == null && this.endDate == null) {
            Precondition.isNotNull(this.period);
        }
        if (this.period == null) {
            Precondition.isNotNull(this.startDate);
            Precondition.isNotNull(this.endDate);
        }
        GroupObjectiveImpl groupObjectiveImpl = new GroupObjectiveImpl();
        groupObjectiveImpl.setPeriod(this.period);
        groupObjectiveImpl.setStartDate(this.startDate);
        groupObjectiveImpl.setEndDate(this.endDate);
        groupObjectiveImpl.setIterationStartDate(this.iterationStartDate);
        groupObjectiveImpl.setIterationEndDate(this.iterationEndDate);
        groupObjectiveImpl.setIteration(Integer.valueOf(this.iteration));
        groupObjectiveImpl.setDataTypeField(this.dataTypeField);
        groupObjectiveImpl.setDataTypeRef(this.dataTypeRef);
        groupObjectiveImpl.setName(this.name);
        groupObjectiveImpl.setCriteria(this.criteria);
        return groupObjectiveImpl;
    }
}
