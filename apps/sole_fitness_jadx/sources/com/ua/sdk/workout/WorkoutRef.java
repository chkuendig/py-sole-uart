package com.ua.sdk.workout;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.LinkEntityRef;

/* loaded from: classes2.dex */
public class WorkoutRef extends LinkEntityRef<Workout> {
    public static final Parcelable.Creator<WorkoutRef> CREATOR = new Parcelable.Creator<WorkoutRef>() { // from class: com.ua.sdk.workout.WorkoutRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutRef createFromParcel(Parcel parcel) {
            return new WorkoutRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutRef[] newArray(int i) {
            return new WorkoutRef[i];
        }
    };

    @Override // com.ua.sdk.internal.LinkEntityRef, android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    public WorkoutRef(String str) {
        super(str);
    }

    public WorkoutRef(String str, String str2) {
        super(str, str2);
    }

    public WorkoutRef(String str, long j, String str2) {
        super(str, j, str2);
    }

    public WorkoutRef(String str, long j, String str2, int i) {
        super(str, j, str2, i);
    }

    private WorkoutRef(FieldBuilder fieldBuilder) {
        super(fieldBuilder.id, fieldBuilder.getHref());
    }

    private WorkoutRef(Builder builder) {
        super(builder.id, builder.getHref());
    }

    public static FieldBuilder getFieldBuilder(WorkoutRef workoutRef) {
        return new FieldBuilder();
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class FieldBuilder extends BaseReferenceBuilder {
        private String id;

        private FieldBuilder(WorkoutRef workoutRef) {
            super(workoutRef.getHref());
            this.id = workoutRef.getId();
        }

        public FieldBuilder setTimeSeriesField(boolean z) {
            if (z) {
                setParam("field_set", "time_series");
            } else {
                removeParam("field_set");
            }
            return this;
        }

        public WorkoutRef build() {
            return new WorkoutRef(this);
        }
    }

    public static class Builder extends BaseReferenceBuilder {
        protected String id;

        public Builder() {
            super("/v7.0/workout/{id}/");
        }

        public Builder setId(String str) {
            this.id = str;
            setParam("id", str);
            return this;
        }

        public WorkoutRef build() {
            if (this.id == null) {
                throw new IllegalArgumentException("Id must be set to build workout reference");
            }
            return new WorkoutRef(this);
        }
    }

    @Override // com.ua.sdk.internal.LinkEntityRef, android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        super.writeToParcel(parcel, i);
    }

    private WorkoutRef(Parcel parcel) {
        super(parcel);
    }
}
