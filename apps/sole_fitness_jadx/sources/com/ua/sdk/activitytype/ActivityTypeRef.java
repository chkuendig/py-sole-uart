package com.ua.sdk.activitytype;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.LinkEntityRef;
import com.ua.sdk.internal.Precondition;

/* loaded from: classes2.dex */
public class ActivityTypeRef extends LinkEntityRef<ActivityType> implements EntityRef<ActivityType> {
    public static Parcelable.Creator<ActivityTypeRef> CREATOR = new Parcelable.Creator<ActivityTypeRef>() { // from class: com.ua.sdk.activitytype.ActivityTypeRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityTypeRef createFromParcel(Parcel parcel) {
            return new ActivityTypeRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityTypeRef[] newArray(int i) {
            return new ActivityTypeRef[i];
        }
    };

    @Override // com.ua.sdk.internal.LinkEntityRef, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    private ActivityTypeRef(Builder builder) {
        super(builder.id, builder.localId, builder.getHref());
    }

    @Override // com.ua.sdk.internal.LinkEntityRef, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    private ActivityTypeRef(Parcel parcel) {
        super(parcel);
    }

    public static class Builder extends BaseReferenceBuilder {
        private String id;
        private long localId;

        protected Builder() {
            super("/v7.0/activity_type/{id}/");
            this.localId = -1L;
        }

        public Builder setActivityTypeId(String str) {
            setParam("id", str);
            this.id = str;
            return this;
        }

        public Builder setLocalId(long j) {
            this.localId = j;
            return this;
        }

        public ActivityTypeRef build() throws NullPointerException {
            Precondition.isNotNull(this.id, "id");
            return new ActivityTypeRef(this);
        }
    }
}
