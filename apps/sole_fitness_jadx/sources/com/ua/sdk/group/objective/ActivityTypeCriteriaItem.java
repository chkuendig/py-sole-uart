package com.ua.sdk.group.objective;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class ActivityTypeCriteriaItem implements CriteriaItem<Integer> {
    public static final Parcelable.Creator<ActivityTypeCriteriaItem> CREATOR = new Parcelable.Creator<ActivityTypeCriteriaItem>() { // from class: com.ua.sdk.group.objective.ActivityTypeCriteriaItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityTypeCriteriaItem createFromParcel(Parcel parcel) {
            return new ActivityTypeCriteriaItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public ActivityTypeCriteriaItem[] newArray(int i) {
            return new ActivityTypeCriteriaItem[i];
        }
    };
    private Integer value;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public ActivityTypeCriteriaItem() {
    }

    private ActivityTypeCriteriaItem(Parcel parcel) {
        this.value = Integer.valueOf(parcel.readInt());
    }

    @Override // com.ua.sdk.group.objective.CriteriaItem
    public String getName() {
        return CriteriaTypes.ACTIVITY_TYPE;
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.ua.sdk.group.objective.CriteriaItem
    public Integer getValue() {
        return this.value;
    }

    @Override // com.ua.sdk.group.objective.CriteriaItem
    public void setValue(Integer num) {
        this.value = num;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.value.intValue());
    }
}
