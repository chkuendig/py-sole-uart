package com.ua.sdk.activitystory.actor;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.EntityRef;
import com.ua.sdk.ImageUrl;
import com.ua.sdk.activitystory.ActivityStoryActor;
import com.ua.sdk.activitystory.ActivityStoryPageActor;
import com.ua.sdk.internal.ImageUrlImpl;
import com.ua.sdk.page.Page;
import com.ua.sdk.page.PageRef;

/* loaded from: classes2.dex */
public class ActivityStoryPageActorImpl implements ActivityStoryPageActor {
    public static Parcelable.Creator<ActivityStoryPageActorImpl> CREATOR = new Parcelable.Creator<ActivityStoryPageActorImpl>() { // from class: com.ua.sdk.activitystory.actor.ActivityStoryPageActorImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryPageActorImpl createFromParcel(Parcel parcel) {
            return new ActivityStoryPageActorImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityStoryPageActorImpl[] newArray(int i) {
            return new ActivityStoryPageActorImpl[i];
        }
    };

    @SerializedName("alias")
    String mAlias;

    @SerializedName("cover_photo")
    Photo mCoverPhoto;
    transient ImageUrl mCoverPhotoUrl;

    @SerializedName("id")
    String mId;

    @SerializedName("profile_photo")
    Photo mProfilePhoto;
    transient ImageUrl mProfilePhotoUrl;

    @SerializedName("title")
    String mTitle;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ActivityStoryPageActorImpl(String str) {
        this.mId = str;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryPageActor
    public EntityRef<Page> getPageRef() {
        if (this.mId == null) {
            return null;
        }
        return PageRef.getBuilder().setId(this.mId).build();
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryPageActor, com.ua.sdk.activitystory.ActivityStoryActor
    public ActivityStoryActor.Type getType() {
        return ActivityStoryActor.Type.PAGE;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryPageActor
    public String getAlias() {
        return this.mAlias;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryPageActor
    public String getTitle() {
        return this.mTitle;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryPageActor
    public ImageUrl getProfilePhoto() {
        if (this.mProfilePhotoUrl == null && this.mProfilePhoto != null) {
            this.mProfilePhotoUrl = ImageUrlImpl.getBuilder().setLarge(this.mProfilePhoto.uri).setTemplate(this.mProfilePhoto.template).build();
        }
        return this.mProfilePhotoUrl;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryPageActor
    public ImageUrl getCoverPhoto() {
        if (this.mCoverPhotoUrl == null && this.mCoverPhoto != null) {
            this.mCoverPhotoUrl = ImageUrlImpl.getBuilder().setLarge(this.mCoverPhoto.uri).setTemplate(this.mCoverPhoto.template).build();
        }
        return this.mCoverPhotoUrl;
    }

    @Override // com.ua.sdk.activitystory.ActivityStoryActor
    public String getId() {
        return this.mId;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.mId);
        parcel.writeString(this.mTitle);
        parcel.writeString(this.mAlias);
        parcel.writeParcelable(this.mProfilePhoto, i);
        parcel.writeParcelable(this.mCoverPhoto, i);
    }

    public ActivityStoryPageActorImpl() {
    }

    private ActivityStoryPageActorImpl(Parcel parcel) {
        this.mId = parcel.readString();
        this.mTitle = parcel.readString();
        this.mAlias = parcel.readString();
        this.mProfilePhoto = (Photo) parcel.readParcelable(ImageUrl.class.getClassLoader());
        this.mCoverPhoto = (Photo) parcel.readParcelable(ImageUrl.class.getClassLoader());
    }

    public static class Photo implements Parcelable {
        public static Parcelable.Creator<Photo> CREATOR = new Parcelable.Creator<Photo>() { // from class: com.ua.sdk.activitystory.actor.ActivityStoryPageActorImpl.Photo.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Photo createFromParcel(Parcel parcel) {
                return new Photo(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Photo[] newArray(int i) {
                return new Photo[i];
            }
        };

        @SerializedName("template")
        String template;

        @SerializedName(ShareConstants.MEDIA_URI)
        String uri;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.uri);
            parcel.writeString(this.template);
        }

        public Photo() {
        }

        private Photo(Parcel parcel) {
            this.uri = parcel.readString();
            this.template = parcel.readString();
        }
    }
}
