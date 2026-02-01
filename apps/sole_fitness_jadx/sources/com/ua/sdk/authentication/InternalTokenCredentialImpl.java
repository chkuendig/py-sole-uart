package com.ua.sdk.authentication;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class InternalTokenCredentialImpl implements InternalTokenCredential, Parcelable {
    public static final Parcelable.Creator<InternalTokenCredentialImpl> CREATOR = new Parcelable.Creator<InternalTokenCredentialImpl>() { // from class: com.ua.sdk.authentication.InternalTokenCredentialImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InternalTokenCredentialImpl createFromParcel(Parcel parcel) {
            return new InternalTokenCredentialImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public InternalTokenCredentialImpl[] newArray(int i) {
            return new InternalTokenCredentialImpl[i];
        }
    };
    private String secret;
    private String token;
    private String tokenType;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.authentication.InternalTokenCredential
    public String getTokenType() {
        return this.tokenType;
    }

    @Override // com.ua.sdk.authentication.InternalTokenCredential
    public void setTokenType(String str) {
        this.tokenType = str;
    }

    @Override // com.ua.sdk.authentication.InternalTokenCredential
    public String getToken() {
        return this.token;
    }

    @Override // com.ua.sdk.authentication.InternalTokenCredential
    public void setToken(String str) {
        this.token = str;
    }

    @Override // com.ua.sdk.authentication.InternalTokenCredential
    public String getSecret() {
        return this.secret;
    }

    @Override // com.ua.sdk.authentication.InternalTokenCredential
    public void setSecret(String str) {
        this.secret = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.tokenType);
        parcel.writeString(this.token);
        parcel.writeString(this.secret);
    }

    public InternalTokenCredentialImpl() {
    }

    private InternalTokenCredentialImpl(Parcel parcel) {
        this.tokenType = parcel.readString();
        this.token = parcel.readString();
        this.secret = parcel.readString();
    }
}
