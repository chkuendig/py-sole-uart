package com.ua.sdk.activitystory;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.internal.Link;
import com.ua.sdk.privacy.Privacy;

/* loaded from: classes2.dex */
public class ActivityStoryRpcPostObject extends ActivityStoryImpl implements Parcelable {
    public static Parcelable.Creator<ActivityStoryRpcPostObject> CREATOR = new Parcelable.Creator<ActivityStoryRpcPostObject>() { // from class: com.ua.sdk.activitystory.ActivityStoryRpcPostObject.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryRpcPostObject createFromParcel(Parcel parcel) {
            return new ActivityStoryRpcPostObject(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryRpcPostObject[] newArray(int i) {
            return new ActivityStoryRpcPostObject[i];
        }
    };

    @SerializedName(ShareConstants.WEB_DIALOG_PARAM_PRIVACY)
    Privacy privacy;

    @Override // com.ua.sdk.activitystory.ActivityStoryImpl, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ActivityStoryRpcPostObject() {
    }

    private ActivityStoryRpcPostObject(Parcel parcel) {
        this.privacy = (Privacy) parcel.readParcelable(Privacy.class.getClassLoader());
    }

    private ActivityStoryRpcPostObject(Builder builder) {
        this.privacy = builder.privacy;
        setLink("self", builder.link);
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryImpl, com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.privacy, i);
    }

    public static class Builder {
        Link link;
        final Privacy privacy;

        public Builder(Privacy privacy) {
            this.privacy = privacy;
        }

        public Builder setLink(String str) {
            this.link = new Link(str);
            return this;
        }

        public ActivityStoryRpcPostObject build() {
            return new ActivityStoryRpcPostObject(this);
        }
    }
}
