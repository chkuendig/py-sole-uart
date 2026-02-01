package com.ua.sdk.group;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityRef;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.v7.UrlBuilderImpl;

/* loaded from: classes2.dex */
public class GroupRef implements EntityRef<Group> {
    public static Parcelable.Creator<GroupRef> CREATOR = new Parcelable.Creator<GroupRef>() { // from class: com.ua.sdk.group.GroupRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupRef createFromParcel(Parcel parcel) {
            return new GroupRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupRef[] newArray(int i) {
            return new GroupRef[i];
        }
    };
    private final String href;
    private final String id;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    private GroupRef(Builder builder) {
        this.id = builder.id;
        this.href = builder.getHref();
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        return this.id;
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return String.format(this.href, this.id);
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static final class Builder extends BaseReferenceBuilder {
        private static final String INVITATION_CODE_KEY = "invitation_code";
        private String code;
        private String id;

        private Builder() {
            super(UrlBuilderImpl.GET_GROUP_URL);
        }

        public Builder setGroupId(String str) {
            this.id = str;
            return this;
        }

        public Builder setInvitationCode(String str) {
            this.code = str;
            return this;
        }

        public GroupRef build() throws NullPointerException {
            Precondition.isNotNull(this.id, "Group Id");
            String str = this.code;
            if (str != null) {
                setParam(INVITATION_CODE_KEY, str);
            }
            return new GroupRef(this);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.id);
        parcel.writeString(this.href);
    }

    private GroupRef(Parcel parcel) {
        this.id = parcel.readString();
        this.href = parcel.readString();
    }
}
