package com.ua.sdk.group.objective;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.group.Group;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;

/* loaded from: classes2.dex */
public class GroupObjectiveListRef implements EntityListRef<GroupObjective> {
    public static Parcelable.Creator<GroupObjectiveListRef> CREATOR = new Parcelable.Creator<GroupObjectiveListRef>() { // from class: com.ua.sdk.group.objective.GroupObjectiveListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupObjectiveListRef createFromParcel(Parcel parcel) {
            return new GroupObjectiveListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupObjectiveListRef[] newArray(int i) {
            return new GroupObjectiveListRef[i];
        }
    };
    private final String href;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        return null;
    }

    private GroupObjectiveListRef(Parcel parcel) {
        this.href = parcel.readString();
    }

    private GroupObjectiveListRef(Builder builder) {
        this.href = builder.getHref();
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return this.href;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
    }

    public static class Builder extends BaseReferenceBuilder {
        private static final String GROUP_ID_KEY = "group_id";
        String id;

        public Builder() {
            super("/v7.0/group_objective/");
        }

        public Builder setGroupRef(EntityRef<Group> entityRef) throws NullPointerException {
            Precondition.isNotNull(entityRef);
            Precondition.isNotNull(entityRef.getId());
            String id = entityRef.getId();
            this.id = id;
            setParam("group_id", id);
            return this;
        }

        public GroupObjectiveListRef build() throws NullPointerException {
            Precondition.isNotNull(this.id);
            return new GroupObjectiveListRef(this);
        }
    }
}
