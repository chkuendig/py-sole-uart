package com.ua.sdk.group;

import android.os.Parcel;
import android.os.Parcelable;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.group.purpose.GroupPurposeType;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.v7.UrlBuilderImpl;

/* loaded from: classes2.dex */
public class GroupListRef implements EntityListRef<Group> {
    public static Parcelable.Creator<GroupListRef> CREATOR = new Parcelable.Creator<GroupListRef>() { // from class: com.ua.sdk.group.GroupListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupListRef createFromParcel(Parcel parcel) {
            return new GroupListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupListRef[] newArray(int i) {
            return new GroupListRef[i];
        }
    };
    private String params;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        return null;
    }

    private GroupListRef(Builder builder) {
        this.params = "";
        this.params = builder.getHref();
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return this.params;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static final class Builder extends BaseReferenceBuilder {
        String view;

        private Builder() {
            super(UrlBuilderImpl.GET_GROUPS_LIST_URL);
        }

        public Builder setUser(String str) {
            setParam("user_id", str);
            return this;
        }

        public Builder setGroupViewType(GroupViewType groupViewType) throws NullPointerException {
            Precondition.isNotNull(groupViewType);
            this.view = groupViewType.toString();
            setParam(ViewHierarchyConstants.VIEW_KEY, groupViewType.toString());
            return this;
        }

        public GroupListRef build() {
            if (this.view != null) {
                setParam("purpose", GroupPurposeType.CHALLENGE.toString().toLowerCase());
            }
            return new GroupListRef(this);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.params);
    }

    private GroupListRef(Parcel parcel) {
        this.params = "";
        this.params = parcel.readString();
    }
}
