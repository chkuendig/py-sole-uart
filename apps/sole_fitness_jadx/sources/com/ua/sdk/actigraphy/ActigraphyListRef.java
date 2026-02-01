package com.ua.sdk.actigraphy;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import com.facebook.appevents.AppEventsConstants;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.user.User;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimeZone;

/* loaded from: classes2.dex */
public class ActigraphyListRef implements EntityListRef<Actigraphy> {
    public static Parcelable.Creator<ActigraphyListRef> CREATOR = new Parcelable.Creator<ActigraphyListRef>() { // from class: com.ua.sdk.actigraphy.ActigraphyListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActigraphyListRef createFromParcel(Parcel parcel) {
            return new ActigraphyListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActigraphyListRef[] newArray(int i) {
            return new ActigraphyListRef[i];
        }
    };
    private String href;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        return null;
    }

    public enum TimeInterval {
        DEFAULT(AppEventsConstants.EVENT_PARAM_VALUE_NO),
        FIFTEEN_MINUTES("900"),
        THIRTY_MINUTES("1800"),
        ONE_HOUR("3600");

        private String value;

        TimeInterval(String str) {
            this.value = str;
        }

        public String getValue() {
            return this.value;
        }
    }

    private ActigraphyListRef(Builder builder) {
        this.href = builder.getHref();
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return this.href;
    }

    public static class Builder extends BaseReferenceBuilder {
        private static final String DATE_FORMAT = "yyyy-MM-dd";
        private static final int DEFAULT_FETCH_LIMIT = 40;
        private static final int DEFAULT_OFFSET = 0;
        private Date endDate;
        private int limit;
        private int offset;
        private Date startDate;
        private TimeInterval timeInterval;
        private TimeZone timeZone;
        private EntityRef<User> user;

        private Builder() {
            super(null);
            this.timeInterval = TimeInterval.DEFAULT;
            this.limit = 40;
            this.offset = 0;
        }

        public Builder setStartDate(Date date) throws NullPointerException {
            Precondition.isNotNull(date, "startDate");
            this.startDate = date;
            validateTimeLine();
            return this;
        }

        public Builder setEndDate(Date date) {
            this.endDate = date;
            if (date != null) {
                validateTimeLine();
            }
            return this;
        }

        public Builder setTimeZone(TimeZone timeZone) throws NullPointerException {
            Precondition.isNotNull(timeZone, "timeZone");
            this.timeZone = timeZone;
            return this;
        }

        public Builder setTimeZone(String str) throws NullPointerException {
            Precondition.isNotNull(str, "timeZone");
            return setTimeZone(TimeZone.getTimeZone(str));
        }

        public Builder setTimeInterval(TimeInterval timeInterval) throws NullPointerException {
            Precondition.isNotNull(timeInterval, "timeInterval");
            this.timeInterval = timeInterval;
            return this;
        }

        public Builder setUserRef(EntityRef<User> entityRef) throws NullPointerException {
            Precondition.isNotNull(entityRef, "user");
            this.user = entityRef;
            return this;
        }

        public Builder setLimit(int i) throws IllegalArgumentException {
            Precondition.isNotNegative(i, "limit");
            this.limit = i;
            return this;
        }

        public Builder setOffset(int i) throws IllegalArgumentException {
            Precondition.isNotNegative(i, TypedValues.CycleType.S_WAVE_OFFSET);
            this.offset = i;
            return this;
        }

        public ActigraphyListRef build() throws NullPointerException {
            Precondition.isNotNull(this.startDate, "startDate");
            if (this.timeZone == null) {
                setTimeZone(TimeZone.getTimeZone("UTC"));
            }
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            simpleDateFormat.setTimeZone(this.timeZone);
            String str = simpleDateFormat.format(this.startDate);
            Date date = this.endDate;
            String str2 = date != null ? simpleDateFormat.format(date) : null;
            setParam("start_date", str);
            if (str2 != null) {
                str = str2;
            }
            setParam("end_date", str);
            EntityRef<User> entityRef = this.user;
            if (entityRef != null) {
                setParam("user", entityRef.getId());
            }
            if (this.timeInterval != TimeInterval.DEFAULT) {
                setParam("time_series_interval", this.timeInterval.getValue());
            }
            setParam("limit", Integer.toString(this.limit));
            setParam(TypedValues.CycleType.S_WAVE_OFFSET, Integer.toString(this.offset));
            return new ActigraphyListRef(this);
        }

        private void validateTimeLine() {
            Date date = this.startDate;
            if (date != null && this.endDate != null && date.getTime() > this.endDate.getTime()) {
                throw new IllegalStateException("the start date can not be greater than the end date.");
            }
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
    }

    private ActigraphyListRef(Parcel parcel) {
        this.href = parcel.readString();
    }
}
