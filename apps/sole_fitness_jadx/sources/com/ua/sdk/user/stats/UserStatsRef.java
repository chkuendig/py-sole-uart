package com.ua.sdk.user.stats;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.EntityRef;
import com.ua.sdk.LocalDate;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.user.User;

/* loaded from: classes2.dex */
public class UserStatsRef implements EntityRef<UserStats> {
    public static Parcelable.Creator<UserStatsRef> CREATOR = new Parcelable.Creator<UserStatsRef>() { // from class: com.ua.sdk.user.stats.UserStatsRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserStatsRef createFromParcel(Parcel parcel) {
            return new UserStatsRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public UserStatsRef[] newArray(int i) {
            return new UserStatsRef[i];
        }
    };
    private String href;

    @Override // android.os.Parcelable
    public int describeContents() {
        return 0;
    }

    @Override // com.ua.sdk.Reference
    public String getId() {
        return null;
    }

    private UserStatsRef(Builder builder) {
        this.href = builder.getHref();
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return this.href;
    }

    public static final class Builder extends BaseReferenceBuilder {
        private Builder() {
            super("v7.0/user_stats/{id}/");
        }

        public Builder setUser(EntityRef<User> entityRef) {
            setParam("id", entityRef.getId());
            return this;
        }

        public Builder setAggregatePeriodUserStats(AggregatePeriodUserStats aggregatePeriodUserStats) {
            setParam("aggregate_by_period", aggregatePeriodUserStats.toString());
            return this;
        }

        public Builder setStartDate(LocalDate localDate) {
            setParam("start_date", localDate.toString());
            return this;
        }

        public Builder setEndDate(LocalDate localDate) {
            setParam("end_date", localDate.toString());
            return this;
        }

        public Builder setIncludeSummaries(boolean z) {
            setParam("include_summary_stats", Boolean.toString(z));
            return this;
        }

        public UserStatsRef build() {
            UserStatsRef userStatsRef;
            synchronized (UserStatsRef.class) {
                Precondition.isNotNull(getParam("user"));
                userStatsRef = new UserStatsRef(this);
            }
            return userStatsRef;
        }
    }

    public enum AggregatePeriodUserStats {
        DAY("day"),
        WEEK("week"),
        MONTH("month"),
        YEAR("year"),
        LIFETIME("lifetime");

        private String value;

        AggregatePeriodUserStats(String str) {
            this.value = str;
        }

        @Override // java.lang.Enum
        public String toString() {
            return this.value;
        }
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
    }

    private UserStatsRef(Parcel parcel) {
        this.href = parcel.readString();
    }
}
