package com.ua.sdk.privacy;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.privacy.Privacy;

/* loaded from: classes2.dex */
public class PrivacyImpl extends ApiTransferObject implements Privacy, Parcelable {
    public static Parcelable.Creator<PrivacyImpl> CREATOR = new Parcelable.Creator<PrivacyImpl>() { // from class: com.ua.sdk.privacy.PrivacyImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrivacyImpl createFromParcel(Parcel parcel) {
            return new PrivacyImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PrivacyImpl[] newArray(int i) {
            return new PrivacyImpl[i];
        }
    };
    private String mDescription;
    private Privacy.Level mLevel;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Resource
    public EntityRef<Privacy> getRef() {
        return null;
    }

    protected PrivacyImpl(Privacy.Level level, String str) {
        this.mLevel = (Privacy.Level) Precondition.isNotNull(level);
        this.mDescription = str;
    }

    @Override // com.ua.sdk.privacy.Privacy
    public String getPrivacyDescription() {
        return this.mDescription;
    }

    @Override // com.ua.sdk.privacy.Privacy
    public Privacy.Level getLevel() {
        return this.mLevel;
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mLevel.toString());
        parcel.writeString(this.mDescription);
    }

    private PrivacyImpl(Parcel parcel) {
        super(parcel);
        this.mLevel = Privacy.Level.valueOf(parcel.readString());
        this.mDescription = parcel.readString();
    }
}
