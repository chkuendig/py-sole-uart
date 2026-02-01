package com.ua.sdk.activitystory;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.ImageUrl;
import com.ua.sdk.activitystory.Attachment;
import com.ua.sdk.activitystory.VideoAttachment;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.ImageUrlImpl;
import java.util.Date;

/* loaded from: classes2.dex */
public class VideoAttachmentImpl implements VideoAttachment {
    public static final Parcelable.Creator<VideoAttachmentImpl> CREATOR = new Parcelable.Creator<VideoAttachmentImpl>() { // from class: com.ua.sdk.activitystory.VideoAttachmentImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoAttachmentImpl createFromParcel(Parcel parcel) {
            return new VideoAttachmentImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public VideoAttachmentImpl[] newArray(int i) {
            return new VideoAttachmentImpl[i];
        }
    };

    @SerializedName("object")
    Data data;
    transient ImageUrl imageUrl;
    transient VideoAttachment.Provider provider;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public VideoAttachmentImpl() {
    }

    public VideoAttachmentImpl(Attachment.Type type) {
        Data data = new Data();
        this.data = data;
        data.type = type;
    }

    @Override // com.ua.sdk.activitystory.Attachment
    public String getUri() {
        return this.data.uri;
    }

    @Override // com.ua.sdk.activitystory.VideoAttachment
    public String getProviderId() {
        return this.data.providerId;
    }

    @Override // com.ua.sdk.activitystory.VideoAttachment
    public ImageUrl getThumbnailUrl() {
        if (this.imageUrl == null) {
            this.imageUrl = ImageUrlImpl.getBuilder().setUri(this.data.thumbnailUri).setTemplate(this.data.thumbnailUriTemplate).build();
        }
        return this.imageUrl;
    }

    @Override // com.ua.sdk.activitystory.VideoAttachment
    public VideoAttachment.Provider getProvider() {
        if (this.provider == null) {
            if (this.data.providerId != null && this.data.providerId.equalsIgnoreCase(VideoAttachment.Provider.OOYALA.name())) {
                this.provider = VideoAttachment.Provider.OOYALA;
            } else {
                this.provider = VideoAttachment.Provider.UNKNOWN;
            }
        }
        return this.provider;
    }

    @Override // com.ua.sdk.activitystory.VideoAttachment
    public String getProviderString() {
        return this.data.provider;
    }

    @Override // com.ua.sdk.activitystory.VideoAttachment, com.ua.sdk.activitystory.Attachment
    public Attachment.Type getType() {
        return this.data.type;
    }

    @Override // com.ua.sdk.activitystory.Attachment
    public Attachment.Status getStatus() {
        return this.data.status;
    }

    @Override // com.ua.sdk.activitystory.Attachment
    public Date getPublished() {
        return this.data.published;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.data, i);
    }

    private VideoAttachmentImpl(Parcel parcel) {
        this.data = (Data) parcel.readParcelable(Data.class.getClassLoader());
    }

    public static class Data implements Parcelable {
        public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator<Data>() { // from class: com.ua.sdk.activitystory.VideoAttachmentImpl.Data.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Data createFromParcel(Parcel parcel) {
                return new Data(parcel);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // android.os.Parcelable.Creator
            public Data[] newArray(int i) {
                return new Data[i];
            }
        };

        @SerializedName("provider")
        String provider;

        @SerializedName("provider_id")
        String providerId;

        @SerializedName("published")
        Date published;

        @SerializedName("status")
        Attachment.Status status;

        @SerializedName("thumbnail_uri")
        String thumbnailUri;

        @SerializedName("thumbnail_uri_template")
        String thumbnailUriTemplate;

        @SerializedName("type")
        Attachment.Type type;

        @SerializedName(ShareConstants.MEDIA_URI)
        String uri;

        @Override // android.os.Parcelable
        public int describeContents() {
            return 0;
        }

        @Override // android.os.Parcelable
        public void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.uri);
            Attachment.Type type = this.type;
            parcel.writeInt(type == null ? -1 : type.ordinal());
            Date date = this.published;
            parcel.writeLong(date != null ? date.getTime() : -1L);
            parcel.writeString(this.provider);
            parcel.writeString(this.providerId);
            parcel.writeString(this.thumbnailUri);
            parcel.writeString(this.thumbnailUriTemplate);
            Attachment.Status status = this.status;
            parcel.writeInt(status != null ? status.ordinal() : -1);
        }

        public Data() {
        }

        private Data(Parcel parcel) {
            this.uri = parcel.readString();
            int i = parcel.readInt();
            this.type = i == -1 ? null : Attachment.Type.values()[i];
            long j = parcel.readLong();
            this.published = j == -1 ? null : new Date(j);
            this.provider = parcel.readString();
            this.providerId = parcel.readString();
            this.thumbnailUri = parcel.readString();
            this.thumbnailUriTemplate = parcel.readString();
            int i2 = parcel.readInt();
            this.status = i2 != -1 ? Attachment.Status.values()[i2] : null;
        }
    }

    static class ImageUriBuilder extends BaseReferenceBuilder {
        public ImageUriBuilder(String str) {
            super(str);
        }

        public ImageUriBuilder setWidth(int i) {
            setParam("width_px", i);
            return this;
        }

        public ImageUriBuilder setHeight(int i) {
            setParam("height_px", i);
            return this;
        }
    }
}
