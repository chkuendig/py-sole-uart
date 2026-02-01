package com.ua.sdk.internal;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.ImageUrl;

/* loaded from: classes2.dex */
public class ImageUrlImpl implements ImageUrl, Parcelable {
    public static Parcelable.Creator<ImageUrlImpl> CREATOR = new Parcelable.Creator<ImageUrlImpl>() { // from class: com.ua.sdk.internal.ImageUrlImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageUrlImpl createFromParcel(Parcel parcel) {
            return new ImageUrlImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ImageUrlImpl[] newArray(int i) {
            return new ImageUrlImpl[i];
        }
    };
    private static final int HEIGHT_LARGE = 600;
    private static final int HEIGHT_MEDIUM = 250;
    private static final int HEIGHT_SMALL = 100;
    private static final int WIDTH_LARGE = 600;
    private static final int WIDTH_MEDIUM = 250;
    private static final int WIDTH_SMALL = 100;
    private String large;
    private String medium;
    private String small;
    private String template;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ImageUrlImpl() {
    }

    @Override // com.ua.sdk.ImageUrl
    public String getSmall() {
        if (this.small == null) {
            this.small = getCustom(100, 100);
        }
        return this.small;
    }

    public void setSmall(String str) {
        this.small = str;
    }

    @Override // com.ua.sdk.ImageUrl
    public String getMedium() {
        if (this.medium == null) {
            this.medium = getCustom(250, 250);
        }
        return this.medium;
    }

    public void setMedium(String str) {
        this.medium = str;
    }

    @Override // com.ua.sdk.ImageUrl
    public String getLarge() {
        if (this.large == null) {
            this.large = getCustom(600, 600);
        }
        return this.large;
    }

    public void setLarge(String str) {
        this.large = str;
    }

    public void setTemplate(String str) {
        this.template = str;
    }

    public String getTemplate() {
        return this.template;
    }

    @Override // com.ua.sdk.ImageUrl
    public String getCustom(int i, int i2) {
        String str = this.template;
        if (str != null) {
            return new ImageUriBuilder(str).setWidth(i).setHeight(i2).getHref();
        }
        String str2 = this.large;
        if (str2 != null) {
            return str2;
        }
        String str3 = this.medium;
        if (str3 != null) {
            return str3;
        }
        String str4 = this.small;
        if (str4 != null) {
            return str4;
        }
        return null;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder {
        private String large;
        private String medium;
        private String small;
        private String template;

        public Builder setSmall(String str) {
            this.small = str;
            return this;
        }

        public Builder setMedium(String str) {
            this.medium = str;
            return this;
        }

        public Builder setLarge(String str) {
            this.large = str;
            return this;
        }

        public Builder setTemplate(String str) {
            this.template = str;
            return this;
        }

        public Builder setUri(String str) {
            this.small = str;
            this.medium = str;
            this.large = str;
            return this;
        }

        public ImageUrlImpl build() {
            ImageUrlImpl imageUrlImpl = new ImageUrlImpl();
            imageUrlImpl.small = this.small;
            imageUrlImpl.medium = this.medium;
            imageUrlImpl.large = this.large;
            imageUrlImpl.template = this.template;
            return imageUrlImpl;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.small);
        parcel.writeString(this.medium);
        parcel.writeString(this.large);
        parcel.writeString(this.template);
    }

    private ImageUrlImpl(Parcel parcel) {
        this.small = parcel.readString();
        this.medium = parcel.readString();
        this.large = parcel.readString();
        this.template = parcel.readString();
    }

    class ImageUriBuilder extends BaseReferenceBuilder {
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
