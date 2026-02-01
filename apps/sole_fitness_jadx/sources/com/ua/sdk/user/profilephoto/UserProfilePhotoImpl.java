package com.ua.sdk.user.profilephoto;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.ImageUrlImpl;
import com.ua.sdk.internal.Link;
import com.ua.sdk.internal.LinkEntityRef;
import java.util.ArrayList;

/* loaded from: classes2.dex */
public class UserProfilePhotoImpl extends ApiTransferObject implements UserProfilePhoto, Parcelable {
    public static Parcelable.Creator<UserProfilePhotoImpl> CREATOR = new Parcelable.Creator<UserProfilePhotoImpl>() { // from class: com.ua.sdk.user.profilephoto.UserProfilePhotoImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserProfilePhotoImpl createFromParcel(Parcel parcel) {
            return new UserProfilePhotoImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserProfilePhotoImpl[] newArray(int i) {
            return new UserProfilePhotoImpl[i];
        }
    };
    public static final String REF_LARGE = "large";
    public static final String REF_MEDIUM = "medium";
    public static final String REF_SMALL = "small";
    private String mLargeProfilePhotoURL;
    private String mMediumProfilePhotoURL;
    private String mSmallProfilePhotoURL;
    private transient EntityRef<UserProfilePhoto> ref;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public UserProfilePhotoImpl() {
    }

    @Override // com.ua.sdk.Resource
    public EntityRef<UserProfilePhoto> getRef() {
        if (this.ref == null) {
            ArrayList<Link> links = getLinks("self");
            if (links == null || links.isEmpty()) {
                return null;
            }
            this.ref = new LinkEntityRef(links.get(0).getId(), links.get(0).getHref());
        }
        return this.ref;
    }

    @Override // com.ua.sdk.user.profilephoto.UserProfilePhoto
    public String getSmallImageURL() {
        if (this.mSmallProfilePhotoURL == null) {
            this.mSmallProfilePhotoURL = getLinks(REF_SMALL) != null ? getLinks(REF_SMALL).get(0).getHref() : null;
        }
        return this.mSmallProfilePhotoURL;
    }

    @Override // com.ua.sdk.user.profilephoto.UserProfilePhoto
    public String getMediumImageURL() {
        if (this.mMediumProfilePhotoURL == null) {
            this.mMediumProfilePhotoURL = getLinks("medium") != null ? getLinks("medium").get(0).getHref() : null;
        }
        return this.mMediumProfilePhotoURL;
    }

    @Override // com.ua.sdk.user.profilephoto.UserProfilePhoto
    public String getLargeImageURL() {
        if (this.mLargeProfilePhotoURL == null) {
            this.mLargeProfilePhotoURL = getLinks(REF_LARGE) != null ? getLinks(REF_LARGE).get(0).getHref() : null;
        }
        return this.mLargeProfilePhotoURL;
    }

    public void setRef(EntityRef<UserProfilePhoto> entityRef) {
        this.ref = entityRef;
    }

    public void setSmallImageURL(String str) {
        this.mSmallProfilePhotoURL = str;
    }

    public void setMediumImageURL(String str) {
        this.mMediumProfilePhotoURL = str;
    }

    public void setLargeImageURL(String str) {
        this.mLargeProfilePhotoURL = str;
    }

    public ImageUrlImpl toImageUrl() {
        return ImageUrlImpl.getBuilder().setSmall(getSmallImageURL()).setMedium(getMediumImageURL()).setLarge(getLargeImageURL()).build();
    }

    @Override // com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
        parcel.writeString(this.mSmallProfilePhotoURL);
        parcel.writeString(this.mMediumProfilePhotoURL);
        parcel.writeString(this.mLargeProfilePhotoURL);
    }

    private UserProfilePhotoImpl(Parcel parcel) {
        super(parcel);
        this.mSmallProfilePhotoURL = parcel.readString();
        this.mMediumProfilePhotoURL = parcel.readString();
        this.mLargeProfilePhotoURL = parcel.readString();
    }
}
