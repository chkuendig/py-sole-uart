package com.ua.sdk.bodymass;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.oss.org.codehaus.jackson.map.util.Iso8601DateFormat;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.v7.UrlBuilderImpl;
import java.util.Date;

/* loaded from: classes2.dex */
public class BodyMassListRef implements EntityListRef<BodyMass> {
    public static Parcelable.Creator<BodyMassListRef> CREATOR = new Parcelable.Creator<BodyMassListRef>() { // from class: com.ua.sdk.bodymass.BodyMassListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BodyMassListRef createFromParcel(Parcel parcel) {
            return new BodyMassListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public BodyMassListRef[] newArray(int i) {
            return new BodyMassListRef[i];
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

    private BodyMassListRef(Parcel parcel) {
        this.href = parcel.readString();
    }

    private BodyMassListRef(Builder builder) {
        this.href = builder.getHref();
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return this.href;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
    }

    public static class Builder extends BaseReferenceBuilder {
        private static final String TARGET_END_DT_KEY = "target_end_datetime";
        private static final String TARGET_START_DT_KEY = "target_start_datetime";

        public Builder() {
            super(UrlBuilderImpl.BODYMASS_COLLECTION_URL);
        }

        public Builder setStartDateTime(Date date) throws NullPointerException {
            Precondition.isNotNull(date);
            setParam("target_start_datetime", Iso8601DateFormat.format(date));
            return this;
        }

        public Builder setEndDateTime(Date date) throws NullPointerException {
            Precondition.isNotNull(date);
            setParam("target_end_datetime", Iso8601DateFormat.format(date));
            return this;
        }

        public BodyMassListRef build() throws NullPointerException {
            Precondition.isNotNull(getParam("target_start_datetime"), "Start DateTime");
            return new BodyMassListRef(this);
        }
    }
}
