package com.ua.sdk.workout;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.oss.org.codehaus.jackson.map.util.Iso8601DateFormat;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.activitytype.ActivityType;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.v7.UrlBuilderImpl;
import com.ua.sdk.user.User;
import java.util.Date;

/* loaded from: classes2.dex */
public class WorkoutListRef implements EntityListRef<Workout> {
    public static final Parcelable.Creator<WorkoutListRef> CREATOR = new Parcelable.Creator<WorkoutListRef>() { // from class: com.ua.sdk.workout.WorkoutListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutListRef createFromParcel(Parcel parcel) {
            return new WorkoutListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public WorkoutListRef[] newArray(int i) {
            return new WorkoutListRef[i];
        }
    };
    private String href;

    public enum WorkoutOrder {
        CHRONOLOGICAL,
        LATEST_FIRST
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        return null;
    }

    public WorkoutListRef(String str) {
        this.href = str;
    }

    private WorkoutListRef(Builder builder) {
        this.href = builder.getHref();
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return this.href;
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    public static class Builder extends BaseReferenceBuilder {
        private static final String KEY_ACTIVITY_TYPE = "activity_type";
        private static final String KEY_ORDER_BY = "order_by";
        private static final String KEY_STARTED_AFTER = "started_after";
        private static final String KEY_STARTED_BEFORE = "started_before";
        private static final String KEY_USER = "user";
        private Date startedAfter;
        private Date startedBefore;
        private EntityRef<User> user;

        private Builder() {
            super(UrlBuilderImpl.GET_WORKOUTS_URL);
        }

        public Builder setActivityTypes(EntityRef<ActivityType>... entityRefArr) {
            if (entityRefArr != null) {
                String[] strArr = new String[entityRefArr.length];
                for (int i = 0; i < entityRefArr.length; i++) {
                    strArr[i] = entityRefArr[i].getId();
                }
                setParams(KEY_ACTIVITY_TYPE, strArr);
            } else {
                setParams(KEY_ACTIVITY_TYPE, null);
            }
            return this;
        }

        public Builder setStartedAfter(Date date) {
            if (date != null) {
                setParam(KEY_STARTED_AFTER, Iso8601DateFormat.format(date));
                this.startedAfter = date;
            }
            return this;
        }

        public Builder setStartedBefore(Date date) {
            if (date != null) {
                setParam(KEY_STARTED_BEFORE, Iso8601DateFormat.format(date));
                this.startedBefore = date;
            }
            return this;
        }

        public Builder setUser(EntityRef<User> entityRef) {
            if (entityRef != null) {
                this.user = entityRef;
                setParam("user", entityRef.getId());
            } else {
                setParam("user", (String) null);
            }
            return this;
        }

        public Builder setWorkoutOrder(WorkoutOrder workoutOrder) {
            if (workoutOrder == WorkoutOrder.LATEST_FIRST) {
                setParam(KEY_ORDER_BY, "-start_datetime");
            }
            return this;
        }

        public WorkoutListRef build() throws IllegalArgumentException {
            if (this.user == null) {
                throw new IllegalArgumentException("Must call setUser before building.");
            }
            Date date = this.startedAfter;
            if (date != null && this.startedBefore != null) {
                Precondition.check(date.getTime() < this.startedBefore.getTime(), "Started after not should be less than started before date");
            }
            return new WorkoutListRef(this);
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
    }

    private WorkoutListRef(Parcel parcel) {
        this.href = parcel.readString();
    }
}
