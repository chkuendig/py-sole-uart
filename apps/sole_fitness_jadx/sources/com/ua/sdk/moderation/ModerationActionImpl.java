package com.ua.sdk.moderation;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.ApiTransferObject;

/* loaded from: classes2.dex */
public class ModerationActionImpl extends ApiTransferObject implements ModerationAction {
    public static final Parcelable.Creator<ModerationActionImpl> CREATOR = new Parcelable.Creator<ModerationActionImpl>() { // from class: com.ua.sdk.moderation.ModerationActionImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ModerationActionImpl createFromParcel(Parcel parcel) {
            return new ModerationActionImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ModerationActionImpl[] newArray(int i) {
            return new ModerationActionImpl[i];
        }
    };

    @SerializedName("action")
    String actionHref;

    @SerializedName("resource")
    String resourceHref;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Resource
    public EntityRef getRef() {
        return null;
    }

    public ModerationActionImpl() {
    }

    @Override // com.ua.sdk.moderation.ModerationAction
    public String getAction() {
        return this.actionHref;
    }

    @Override // com.ua.sdk.moderation.ModerationAction
    public String getResource() {
        return this.resourceHref;
    }

    @Override // com.ua.sdk.moderation.ModerationAction
    public void setAction(String str) {
        this.actionHref = str;
    }

    @Override // com.ua.sdk.moderation.ModerationAction
    public void setResource(String str) {
        this.resourceHref = str;
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.actionHref);
        parcel.writeString(this.resourceHref);
    }

    private ModerationActionImpl(Parcel parcel) {
        super(parcel);
        this.actionHref = parcel.readString();
        this.resourceHref = parcel.readString();
    }
}
