package com.ua.sdk.suggestedfriends;

import android.os.Parcel;
import android.os.Parcelable;
import com.dyaco.sole.database.UserData;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class SuggestedFriendsReasonImpl implements SuggestedFriendsReason {
    public static Parcelable.Creator<SuggestedFriendsReasonImpl> CREATOR = new Parcelable.Creator<SuggestedFriendsReasonImpl>() { // from class: com.ua.sdk.suggestedfriends.SuggestedFriendsReasonImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SuggestedFriendsReasonImpl createFromParcel(Parcel parcel) {
            return new SuggestedFriendsReasonImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SuggestedFriendsReasonImpl[] newArray(int i) {
            return new SuggestedFriendsReasonImpl[i];
        }
    };

    @SerializedName("source")
    String source;

    @SerializedName(UserData.WEIGHT)
    Double weight;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SuggestedFriendsReasonImpl() {
    }

    protected SuggestedFriendsReasonImpl(String str, Double d) {
        this.source = str;
        this.weight = d;
    }

    @Override // com.ua.sdk.suggestedfriends.SuggestedFriendsReason
    public String getSource() {
        return this.source;
    }

    @Override // com.ua.sdk.suggestedfriends.SuggestedFriendsReason
    public Double getWeight() {
        return this.weight;
    }

    public void setSource(String str) {
        this.source = str;
    }

    public void setWeight(Double d) {
        this.weight = d;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.source);
        parcel.writeValue(this.weight);
    }

    private SuggestedFriendsReasonImpl(Parcel parcel) {
        this.source = parcel.readString();
        this.weight = (Double) parcel.readValue(Double.class.getClassLoader());
    }
}
