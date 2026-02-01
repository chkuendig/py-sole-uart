package com.ua.sdk.workout;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.AbstractEntityList;

/* loaded from: classes2.dex */
public class WorkoutListImpl extends AbstractEntityList<Workout> implements WorkoutList {
    public static final Parcelable.Creator<WorkoutListImpl> CREATOR = new Parcelable.Creator<WorkoutListImpl>() { // from class: com.ua.sdk.workout.WorkoutListImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutListImpl createFromParcel(Parcel parcel) {
            return new WorkoutListImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutListImpl[] newArray(int i) {
            return new WorkoutListImpl[i];
        }
    };

    @Override // com.ua.sdk.internal.AbstractEntityList, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.internal.AbstractEntityList
    protected String getListKey() {
        return "workouts";
    }

    public WorkoutListImpl() {
    }

    @Override // com.ua.sdk.internal.AbstractEntityList, com.ua.sdk.internal.ApiTransferObject, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    private WorkoutListImpl(Parcel parcel) {
        super(parcel);
    }
}
