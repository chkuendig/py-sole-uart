package com.ua.sdk.page;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.v7.UrlBuilderImpl;
import com.ua.sdk.user.User;

/* loaded from: classes2.dex */
public class PageRef implements EntityRef<Page> {
    public static Parcelable.Creator<PageRef> CREATOR = new Parcelable.Creator<PageRef>() { // from class: com.ua.sdk.page.PageRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageRef createFromParcel(Parcel parcel) {
            return new PageRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public PageRef[] newArray(int i) {
            return new PageRef[i];
        }
    };
    private final String id;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private PageRef(Builder builder) {
        this.id = builder.id;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static final class Builder {
        private String id;

        private Builder() {
        }

        public Builder setUser(User user) throws NullPointerException {
            Precondition.isNotNull(user, "User");
            Precondition.isNotNull(user.getId(), "User's ID");
            this.id = "u" + user.getId();
            return this;
        }

        public Builder setUserRef(EntityRef<User> entityRef) throws NullPointerException {
            Precondition.isNotNull(entityRef, "User Reference");
            Precondition.isNotNull(entityRef.getId(), "Reference's ID");
            this.id = "u" + entityRef.getId();
            return this;
        }

        public Builder setPage(Page page) throws NullPointerException {
            Precondition.isNotNull(page, "Page");
            Precondition.isNotNull(page.getAlias(), "Page's alias");
            this.id = page.getAlias();
            return this;
        }

        public Builder setId(String str) {
            this.id = str;
            return this;
        }

        public PageRef build() {
            PageRef pageRef;
            synchronized (PageRef.class) {
                pageRef = new PageRef(this);
            }
            return pageRef;
        }
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        String str = this.id;
        if (str == null || str.length() <= 0) {
            return null;
        }
        return this.id;
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        String str = this.id;
        if (str == null || str.isEmpty()) {
            return null;
        }
        return String.format(UrlBuilderImpl.GET_PAGE_URL, this.id);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
    }

    private PageRef(Parcel parcel) {
        this.id = parcel.readString();
    }
}
