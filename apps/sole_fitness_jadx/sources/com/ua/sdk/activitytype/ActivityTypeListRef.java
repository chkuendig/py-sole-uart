package com.ua.sdk.activitytype;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.internal.BaseReferenceBuilder;

/* loaded from: classes2.dex */
public class ActivityTypeListRef implements EntityListRef<ActivityType> {
    public static Parcelable.Creator<ActivityTypeListRef> CREATOR = new Parcelable.Creator<ActivityTypeListRef>() { // from class: com.ua.sdk.activitytype.ActivityTypeListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityTypeListRef createFromParcel(Parcel parcel) {
            return new ActivityTypeListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityTypeListRef[] newArray(int i) {
            return new ActivityTypeListRef[i];
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

    public ActivityTypeListRef(Builder builder) {
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

    private ActivityTypeListRef(Parcel parcel) {
        this.href = parcel.readString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        return this.href.equals(((ActivityTypeListRef) obj).href);
    }

    public int hashCode() {
        return this.href.hashCode();
    }

    public static class Builder extends BaseReferenceBuilder {
        protected Builder() {
            super("/v7.0/activity_type/");
        }

        public ActivityTypeListRef build() {
            return new ActivityTypeListRef(this);
        }
    }
}
