package com.ua.sdk.group.objective;

import android.os.Parcel;
import android.os.Parcelable;

/* loaded from: classes2.dex */
public class SortCriteriaItem implements CriteriaItem<String> {
    public static final Parcelable.Creator<SortCriteriaItem> CREATOR = new Parcelable.Creator<SortCriteriaItem>() { // from class: com.ua.sdk.group.objective.SortCriteriaItem.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SortCriteriaItem createFromParcel(Parcel parcel) {
            return new SortCriteriaItem(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public SortCriteriaItem[] newArray(int i) {
            return new SortCriteriaItem[i];
        }
    };
    private String value;

    public enum Value {
        ASC,
        DESC
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public SortCriteriaItem() {
    }

    private SortCriteriaItem(Parcel parcel) {
        this.value = parcel.readString();
    }

    @Override // com.ua.sdk.group.objective.CriteriaItem
    public String getName() {
        return CriteriaTypes.SORT;
    }

    @Override // com.ua.sdk.group.objective.CriteriaItem
    public String getValue() {
        return this.value;
    }

    @Override // com.ua.sdk.group.objective.CriteriaItem
    public void setValue(String str) {
        if (str == null) {
            return;
        }
        for (Value value : Value.values()) {
            if (str.equalsIgnoreCase(value.toString())) {
                setValue(value);
                return;
            }
        }
        throw new EnumConstantNotPresentException(Value.class, "Unable to set value: " + str);
    }

    public void setValue(Value value) {
        if (value == null) {
            return;
        }
        this.value = value.toString().toLowerCase();
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.value);
    }
}
