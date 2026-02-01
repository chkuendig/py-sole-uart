package com.ua.sdk.group.objective;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.AbstractEntityList;

/* loaded from: classes2.dex */
public class GroupObjectiveList extends AbstractEntityList<GroupObjective> {
    public static Parcelable.Creator<GroupObjectiveList> CREATOR = new Parcelable.Creator<GroupObjectiveList>() { // from class: com.ua.sdk.group.objective.GroupObjectiveList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupObjectiveList createFromParcel(Parcel parcel) {
            return new GroupObjectiveList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupObjectiveList[] newArray(int i) {
            return new GroupObjectiveList[i];
        }
    };
    private static final String LIST_KEY = "group_objectives";

    @Override // com.ua.sdk.internal.AbstractEntityList
    protected String getListKey() {
        return LIST_KEY;
    }

    public GroupObjectiveList() {
    }

    private GroupObjectiveList(Parcel parcel) {
        super(parcel);
    }
}
