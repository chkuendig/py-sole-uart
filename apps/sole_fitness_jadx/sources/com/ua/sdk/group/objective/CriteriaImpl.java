package com.ua.sdk.group.objective;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;
import java.util.Map;

/* loaded from: classes2.dex */
public class CriteriaImpl implements Criteria {
    public static final Parcelable.Creator<CriteriaImpl> CREATOR = new Parcelable.Creator<CriteriaImpl>() { // from class: com.ua.sdk.group.objective.CriteriaImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CriteriaImpl createFromParcel(Parcel parcel) {
            return new CriteriaImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public CriteriaImpl[] newArray(int i) {
            return new CriteriaImpl[i];
        }
    };
    Map<String, CriteriaItem> criteria;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public CriteriaImpl() {
        this.criteria = new HashMap(2);
    }

    private CriteriaImpl(Parcel parcel) {
        HashMap map = new HashMap(2);
        this.criteria = map;
        parcel.readMap(map, CriteriaItem.class.getClassLoader());
    }

    @Override // com.ua.sdk.group.objective.Criteria
    public void addCriteriaItem(CriteriaItem criteriaItem) {
        this.criteria.put(criteriaItem.getName(), criteriaItem);
    }

    @Override // com.ua.sdk.group.objective.Criteria
    public CriteriaItem getCriteriaItem(String str) {
        return this.criteria.get(str);
    }

    @Override // com.ua.sdk.group.objective.Criteria
    public void removeAllItems() {
        this.criteria.clear();
    }

    @Override // com.ua.sdk.group.objective.Criteria
    public CriteriaItem removeItem(String str) {
        return this.criteria.remove(str);
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeMap(this.criteria);
    }
}
