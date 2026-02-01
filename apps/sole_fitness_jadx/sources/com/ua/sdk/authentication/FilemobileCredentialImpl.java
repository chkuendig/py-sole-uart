package com.ua.sdk.authentication;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.LinkEntityRef;
import java.util.Date;

/* loaded from: classes2.dex */
public class FilemobileCredentialImpl extends ApiTransferObject implements FilemobileCredential, Parcelable {
    public static Parcelable.Creator<FilemobileCredentialImpl> CREATOR = new Parcelable.Creator<FilemobileCredentialImpl>() { // from class: com.ua.sdk.authentication.FilemobileCredentialImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FilemobileCredentialImpl createFromParcel(Parcel parcel) {
            return new FilemobileCredentialImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public FilemobileCredentialImpl[] newArray(int i) {
            return new FilemobileCredentialImpl[i];
        }
    };
    private Date created;
    private String token;
    private String uid;
    private Uri uploaderUri;
    private String vhost;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public FilemobileCredentialImpl() {
    }

    @Override // com.ua.sdk.authentication.FilemobileCredential
    public String getToken() {
        return this.token;
    }

    @Override // com.ua.sdk.authentication.FilemobileCredential
    public void setToken(String str) {
        this.token = str;
    }

    @Override // com.ua.sdk.authentication.FilemobileCredential
    public String getVhost() {
        return this.vhost;
    }

    @Override // com.ua.sdk.authentication.FilemobileCredential
    public void setVhost(String str) {
        this.vhost = str;
    }

    @Override // com.ua.sdk.authentication.FilemobileCredential
    public String getUid() {
        return this.uid;
    }

    @Override // com.ua.sdk.authentication.FilemobileCredential
    public void setUid(String str) {
        this.uid = str;
    }

    @Override // com.ua.sdk.authentication.FilemobileCredential
    public Uri getUploaderUri() {
        return this.uploaderUri;
    }

    @Override // com.ua.sdk.authentication.FilemobileCredential
    public void setUploaderUri(Uri uri) {
        this.uploaderUri = uri;
    }

    @Override // com.ua.sdk.authentication.FilemobileCredential
    public Date getCreated() {
        return this.created;
    }

    @Override // com.ua.sdk.authentication.FilemobileCredential
    public void setCreated(Date date) {
        this.created = date;
    }

    @Override // com.ua.sdk.Resource
    public EntityRef getRef() {
        return new LinkEntityRef("", getLocalId(), getHref());
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.token);
        parcel.writeString(this.vhost);
        parcel.writeString(this.uid);
        parcel.writeParcelable(this.uploaderUri, i);
        Date date = this.created;
        parcel.writeLong(date != null ? date.getTime() : -1L);
    }

    private FilemobileCredentialImpl(Parcel parcel) {
        super(parcel);
        this.token = parcel.readString();
        this.vhost = parcel.readString();
        this.uid = parcel.readString();
        this.uploaderUri = (Uri) parcel.readParcelable(Uri.class.getClassLoader());
        long j = parcel.readLong();
        this.created = j == -1 ? null : new Date(j);
    }
}
