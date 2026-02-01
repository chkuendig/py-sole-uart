package com.ua.sdk.page;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class PageSettingImpl implements PageSetting {
    public static Parcelable.Creator<PageSettingImpl> CREATOR = new Parcelable.Creator<PageSettingImpl>() { // from class: com.ua.sdk.page.PageSettingImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageSettingImpl createFromParcel(Parcel parcel) {
            return new PageSettingImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageSettingImpl[] newArray(int i) {
            return new PageSettingImpl[i];
        }
    };

    @SerializedName("cta_link")
    String ctaLink;

    @SerializedName("cta_target")
    String ctaTarget;

    @SerializedName("cta_text")
    String ctaText;

    @SerializedName("featured_gallery_enabled")
    Boolean featuredGalleryEnabled;

    @SerializedName("qs_graph_enabled")
    Boolean qsGraphEnabled;

    @SerializedName("template")
    String template;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public PageSettingImpl() {
    }

    public PageSettingImpl(Boolean bool, Boolean bool2, String str, String str2, String str3, String str4) {
        this.featuredGalleryEnabled = bool;
        this.qsGraphEnabled = bool2;
        this.ctaText = str;
        this.ctaLink = str2;
        this.ctaTarget = str3;
        this.template = str4;
    }

    @Override // com.ua.sdk.page.PageSetting
    public boolean isFeaturedGalleryEnabled() {
        Boolean bool = this.featuredGalleryEnabled;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.ua.sdk.page.PageSetting
    public Boolean getFeaturedGalleryEnabled() {
        return this.featuredGalleryEnabled;
    }

    @Override // com.ua.sdk.page.PageSetting
    public void setFeaturedGalleryEnabled(Boolean bool) {
        this.featuredGalleryEnabled = bool;
    }

    @Override // com.ua.sdk.page.PageSetting
    public boolean isQsGraphEnabled() {
        Boolean bool = this.qsGraphEnabled;
        if (bool == null) {
            return false;
        }
        return bool.booleanValue();
    }

    @Override // com.ua.sdk.page.PageSetting
    public Boolean getQsGraphEnabled() {
        return this.featuredGalleryEnabled;
    }

    @Override // com.ua.sdk.page.PageSetting
    public void setQsGraphEnabled(Boolean bool) {
        this.qsGraphEnabled = bool;
    }

    @Override // com.ua.sdk.page.PageSetting
    public String getCtaText() {
        return this.ctaText;
    }

    @Override // com.ua.sdk.page.PageSetting
    public void setCtaText(String str) {
        this.ctaText = str;
    }

    @Override // com.ua.sdk.page.PageSetting
    public String getCtaLink() {
        return this.ctaLink;
    }

    @Override // com.ua.sdk.page.PageSetting
    public void setCtaLink(String str) {
        this.ctaLink = str;
    }

    @Override // com.ua.sdk.page.PageSetting
    public String getCtaTarget() {
        return this.ctaTarget;
    }

    @Override // com.ua.sdk.page.PageSetting
    public void setCtaTarget(String str) {
        this.ctaTarget = str;
    }

    @Override // com.ua.sdk.page.PageSetting
    public String getTemplate() {
        return this.template;
    }

    @Override // com.ua.sdk.page.PageSetting
    public void setTemplate(String str) {
        this.template = str;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeValue(this.featuredGalleryEnabled);
        parcel.writeValue(this.qsGraphEnabled);
        parcel.writeString(this.ctaText);
        parcel.writeString(this.ctaLink);
        parcel.writeString(this.ctaTarget);
        parcel.writeString(this.template);
    }

    private PageSettingImpl(Parcel parcel) {
        this.featuredGalleryEnabled = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.qsGraphEnabled = (Boolean) parcel.readValue(Boolean.class.getClassLoader());
        this.ctaText = parcel.readString();
        this.ctaLink = parcel.readString();
        this.ctaTarget = parcel.readString();
        this.template = parcel.readString();
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof PageSettingImpl)) {
            return false;
        }
        PageSettingImpl pageSettingImpl = (PageSettingImpl) obj;
        Boolean bool = this.featuredGalleryEnabled;
        if (bool == null ? pageSettingImpl.featuredGalleryEnabled != null : !bool.equals(pageSettingImpl.featuredGalleryEnabled)) {
            return false;
        }
        Boolean bool2 = this.qsGraphEnabled;
        if (bool2 == null ? pageSettingImpl.qsGraphEnabled != null : !bool2.equals(pageSettingImpl.qsGraphEnabled)) {
            return false;
        }
        String str = this.ctaText;
        if (str == null ? pageSettingImpl.ctaText != null : !str.equals(pageSettingImpl.ctaText)) {
            return false;
        }
        String str2 = this.ctaLink;
        if (str2 == null ? pageSettingImpl.ctaLink != null : !str2.equals(pageSettingImpl.ctaLink)) {
            return false;
        }
        String str3 = this.ctaTarget;
        if (str3 == null ? pageSettingImpl.ctaTarget != null : !str3.equals(pageSettingImpl.ctaTarget)) {
            return false;
        }
        String str4 = this.template;
        String str5 = pageSettingImpl.template;
        return str4 == null ? str5 == null : str4.equals(str5);
    }

    public int hashCode() {
        Boolean bool = this.featuredGalleryEnabled;
        int iHashCode = (bool != null ? bool.hashCode() : 0) * 31;
        Boolean bool2 = this.qsGraphEnabled;
        int iHashCode2 = (iHashCode + (bool2 != null ? bool2.hashCode() : 0)) * 31;
        String str = this.ctaText;
        int iHashCode3 = (iHashCode2 + (str != null ? str.hashCode() : 0)) * 31;
        String str2 = this.ctaLink;
        int iHashCode4 = (iHashCode3 + (str2 != null ? str2.hashCode() : 0)) * 31;
        String str3 = this.ctaTarget;
        int iHashCode5 = (iHashCode4 + (str3 != null ? str3.hashCode() : 0)) * 31;
        String str4 = this.template;
        return iHashCode5 + (str4 != null ? str4.hashCode() : 0);
    }
}
