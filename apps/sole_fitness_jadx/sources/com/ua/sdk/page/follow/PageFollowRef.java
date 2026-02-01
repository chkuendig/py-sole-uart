package com.ua.sdk.page.follow;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.internal.BaseReferenceBuilder;

/* loaded from: classes2.dex */
public class PageFollowRef implements EntityListRef<PageFollow> {
    public static Parcelable.Creator<PageFollowRef> CREATOR = new Parcelable.Creator<PageFollowRef>() { // from class: com.ua.sdk.page.follow.PageFollowRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageFollowRef createFromParcel(Parcel parcel) {
            return new PageFollowRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageFollowRef[] newArray(int i) {
            return new PageFollowRef[i];
        }
    };
    private String href;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        return null;
    }

    private PageFollowRef(Builder builder) {
        this.href = builder.getHref();
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static final class Builder extends BaseReferenceBuilder {
        private Builder() {
            super("/v7.0/page_follow/");
        }

        public Builder setUserId(String str) {
            setParam("user_id", str);
            return this;
        }

        public Builder setPageId(String str) {
            setParam("page_id", str);
            return this;
        }

        public PageFollowRef build() {
            PageFollowRef pageFollowRef;
            synchronized (PageFollowRef.class) {
                pageFollowRef = new PageFollowRef(this);
            }
            return pageFollowRef;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return this.href;
    }

    private PageFollowRef(Parcel parcel) {
        this.href = parcel.readString();
    }
}
