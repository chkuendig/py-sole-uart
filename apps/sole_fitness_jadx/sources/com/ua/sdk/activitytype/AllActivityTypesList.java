package com.ua.sdk.activitytype;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityList;
import com.ua.sdk.EntityListRef;
import java.util.ArrayList;
import java.util.List;

/* loaded from: classes2.dex */
public class AllActivityTypesList implements EntityList<ActivityType>, Parcelable {
    public static final Parcelable.Creator<AllActivityTypesList> CREATOR = new Parcelable.Creator<AllActivityTypesList>() { // from class: com.ua.sdk.activitytype.AllActivityTypesList.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AllActivityTypesList createFromParcel(Parcel parcel) {
            return new AllActivityTypesList(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public AllActivityTypesList[] newArray(int i) {
            return new AllActivityTypesList[i];
        }
    };
    List<ActivityType> activityTypes;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.EntityList
    public EntityListRef<ActivityType> getNextPage() {
        return null;
    }

    @Override // com.ua.sdk.EntityList
    public EntityListRef<ActivityType> getPreviousPage() {
        return null;
    }

    @Override // com.ua.sdk.Resource
    public EntityListRef<ActivityType> getRef() {
        return null;
    }

    @Override // com.ua.sdk.EntityList
    public boolean hasNext() {
        return false;
    }

    @Override // com.ua.sdk.EntityList
    public boolean hasPrevious() {
        return false;
    }

    public AllActivityTypesList(List list) {
        this.activityTypes = list;
    }

    @Override // com.ua.sdk.EntityList
    public int getTotalCount() {
        return this.activityTypes.size();
    }

    @Override // com.ua.sdk.EntityList
    public int getSize() {
        return this.activityTypes.size();
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.EntityList
    public ActivityType get(int i) {
        return this.activityTypes.get(i);
    }

    @Override // com.ua.sdk.EntityList
    public List<ActivityType> getAll() {
        return this.activityTypes;
    }

    @Override // com.ua.sdk.EntityList
    public boolean isEmpty() {
        return this.activityTypes.isEmpty();
    }

    @Override // com.ua.sdk.EntityList
    public void set(int i, ActivityType activityType) {
        this.activityTypes.set(i, activityType);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.EntityList
    public ActivityType remove(int i) {
        return this.activityTypes.remove(i);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeList(this.activityTypes);
    }

    private AllActivityTypesList(Parcel parcel) {
        ArrayList arrayList = new ArrayList();
        this.activityTypes = arrayList;
        parcel.readList(arrayList, ActivityType.class.getClassLoader());
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        List<ActivityType> list = this.activityTypes;
        List<ActivityType> list2 = ((AllActivityTypesList) obj).activityTypes;
        return list == null ? list2 == null : list.equals(list2);
    }

    public int hashCode() {
        List<ActivityType> list = this.activityTypes;
        if (list != null) {
            return list.hashCode();
        }
        return 0;
    }
}
