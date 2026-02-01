package com.ua.sdk.aggregate;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.oss.org.codehaus.jackson.map.util.Iso8601DateFormat;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.UaException;
import com.ua.sdk.datapoint.DataType;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Period;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.v7.UrlBuilderImpl;
import com.ua.sdk.user.User;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public class AggregateListRef implements EntityListRef<Aggregate> {
    public static Parcelable.Creator<AggregateListRef> CREATOR = new Parcelable.Creator<AggregateListRef>() { // from class: com.ua.sdk.aggregate.AggregateListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AggregateListRef createFromParcel(Parcel parcel) {
            return new AggregateListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AggregateListRef[] newArray(int i) {
            return new AggregateListRef[i];
        }
    };
    private final String href;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        return null;
    }

    private AggregateListRef(Parcel parcel) {
        this.href = parcel.readString();
    }

    private AggregateListRef(Builder builder) {
        this.href = builder.getHref();
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return this.href;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
    }

    public static class Builder extends BaseReferenceBuilder {
        private static final String DATA_TYPES_KEY = "data_types";
        private static final String END_DATE_KEY = "end_datetime";
        private static final String PERIOD_KEY = "period";
        private static final String START_DATE_KEY = "start_datetime";
        private static final String USER_ID_KEY = "user_id";
        List<String> dataTypes;
        Date endDate;
        Period period;
        Date startDate;
        String userId;

        public Builder() {
            super(UrlBuilderImpl.GET_AGGREGATE_LIST_URL);
        }

        public Builder setStartDate(Date date) {
            this.startDate = date;
            setParam(START_DATE_KEY, Iso8601DateFormat.format(date));
            return this;
        }

        public Builder setEndDate(Date date) {
            this.endDate = date;
            setParam(END_DATE_KEY, Iso8601DateFormat.format(date));
            return this;
        }

        public Builder setPeriod(Period period) {
            this.period = period;
            setParam("period", period.toString());
            return this;
        }

        public Builder setUser(EntityRef<User> entityRef) {
            String id = entityRef.getId();
            this.userId = id;
            setParam("user_id", id);
            return this;
        }

        public Builder addDataType(DataType dataType) {
            if (this.dataTypes == null) {
                this.dataTypes = new ArrayList();
            }
            this.dataTypes.add(dataType.getId());
            return this;
        }

        public AggregateListRef build() throws UaException, NullPointerException {
            Precondition.isNotNull(this.userId, "userId");
            Precondition.isNotNull(this.startDate, "startDate");
            Precondition.isNotNull(this.endDate, "endDate");
            Precondition.isNotNull(this.dataTypes, "dataTypes");
            Period period = this.period;
            if (period != null && !period.isValid(Period.ONE_YEAR, Period.ONE_MONTH, Period.ONE_DAY)) {
                throw new UaException(this.period.toString() + " is not valid...P1Y, P1M, P1D are only supported for aggregates!");
            }
            StringBuilder sb = new StringBuilder();
            for (String str : this.dataTypes) {
                if (sb.length() > 0) {
                    sb.append(",");
                }
                sb.append(str);
            }
            setParam(DATA_TYPES_KEY, sb.toString());
            return new AggregateListRef(this);
        }
    }
}
