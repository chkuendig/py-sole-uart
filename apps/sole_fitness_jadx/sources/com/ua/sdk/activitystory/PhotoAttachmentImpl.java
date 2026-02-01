package com.ua.sdk.activitystory;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.share.internal.ShareConstants;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.ImageUrl;
import com.ua.sdk.activitystory.Attachment;
import com.ua.sdk.internal.ImageUrlImpl;
import java.util.Date;

/* loaded from: classes2.dex */
public class PhotoAttachmentImpl implements PhotoAttachment {
    public static final Parcelable.Creator<PhotoAttachmentImpl> CREATOR = new Parcelable.Creator<PhotoAttachmentImpl>() { // from class: com.ua.sdk.activitystory.PhotoAttachmentImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhotoAttachmentImpl createFromParcel(Parcel parcel) {
            return new PhotoAttachmentImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PhotoAttachmentImpl[] newArray(int i) {
            return new PhotoAttachmentImpl[i];
        }
    };

    @SerializedName("object")
    Data data;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PhotoAttachmentImpl() {
    }

    public PhotoAttachmentImpl(Attachment.Type type) {
        Data data = new Data();
        this.data = data;
        data.type = type;
    }

    @Override // com.ua.sdk.activitystory.Attachment
    public String getUri() {
        return this.data.uri;
    }

    @Override // com.ua.sdk.activitystory.PhotoAttachment
    public ImageUrl getImageUrl() {
        if (this.data.template == null && this.data.uri == null) {
            return null;
        }
        return ImageUrlImpl.getBuilder().setUri(this.data.uri).setTemplate(this.data.template).build();
    }

    @Override // com.ua.sdk.activitystory.PhotoAttachment, com.ua.sdk.activitystory.Attachment
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

    private PhotoAttachmentImpl(Parcel parcel) {
        this.data = (Data) parcel.readParcelable(Data.class.getClassLoader());
    }

    public static class Data implements Parcelable {
        public static final Parcelable.Creator<Data> CREATOR = new Parcelable.Creator<Data>() { // from class: com.ua.sdk.activitystory.PhotoAttachmentImpl.Data.1
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

        @SerializedName("published")
        Date published;

        @SerializedName("status")
        Attachment.Status status;

        @SerializedName("template")
        String template;

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
            parcel.writeString(this.template);
            Attachment.Type type = this.type;
            parcel.writeInt(type == null ? -1 : type.ordinal());
            Date date = this.published;
            parcel.writeLong(date != null ? date.getTime() : -1L);
            Attachment.Status status = this.status;
            parcel.writeInt(status != null ? status.ordinal() : -1);
        }

        public Data() {
        }

        private Data(Parcel parcel) {
            this.uri = parcel.readString();
            this.template = parcel.readString();
            int i = parcel.readInt();
            this.type = i == -1 ? null : Attachment.Type.values()[i];
            long j = parcel.readLong();
            this.published = j == -1 ? null : new Date(j);
            int i2 = parcel.readInt();
            this.status = i2 != -1 ? Attachment.Status.values()[i2] : null;
        }
    }
}
