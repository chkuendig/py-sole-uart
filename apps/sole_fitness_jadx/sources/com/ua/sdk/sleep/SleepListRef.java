package com.ua.sdk.sleep;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.oss.org.codehaus.jackson.map.util.Iso8601DateFormat;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.internal.BaseReferenceBuilder;
import java.util.Date;

/* loaded from: classes2.dex */
public class SleepListRef implements EntityListRef<SleepMetric>, Parcelable {
    public static final Parcelable.Creator<SleepListRef> CREATOR = new Parcelable.Creator<SleepListRef>() { // from class: com.ua.sdk.sleep.SleepListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SleepListRef createFromParcel(Parcel parcel) {
            return new SleepListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SleepListRef[] newArray(int i) {
            return new SleepListRef[i];
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

    private SleepListRef(Builder builder) {
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
        public static final String END = "target_end_datetime";
        public static final String START = "target_start_datetime";

        protected Builder() {
            super("/api/0.1/sleep/");
        }

        public Builder setTargetStartDateTime(Date date) {
            setParam(START, Iso8601DateFormat.format(date));
            return this;
        }

        public Builder setTargetEndDateTime(Date date) {
            setParam(END, Iso8601DateFormat.format(date));
            return this;
        }

        public SleepListRef build() {
            if (getParam(START) == null) {
                throw new IllegalStateException("Must specify targetStartDateTime.");
            }
            return new SleepListRef(this);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
    }

    private SleepListRef(Parcel parcel) {
        this.href = parcel.readString();
    }
}
