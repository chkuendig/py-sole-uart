package com.ua.sdk.group.leaderboard;

import android.os.Parcel;
import android.os.Parcelable;
import com.dyaco.sole.custom.CalendarUtils;
import com.ua.sdk.EntityListRef;
import com.ua.sdk.EntityRef;
import com.ua.sdk.group.Group;
import com.ua.sdk.internal.BaseReferenceBuilder;
import com.ua.sdk.internal.Precondition;
import com.ua.sdk.internal.net.v7.UrlBuilderImpl;
import java.text.SimpleDateFormat;
import java.util.Date;

/* loaded from: classes2.dex */
public class GroupLeaderboardListRef implements EntityListRef<GroupLeaderboard> {
    public static Parcelable.Creator<GroupLeaderboardListRef> CREATOR = new Parcelable.Creator<GroupLeaderboardListRef>() { // from class: com.ua.sdk.group.leaderboard.GroupLeaderboardListRef.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupLeaderboardListRef createFromParcel(Parcel parcel) {
            return new GroupLeaderboardListRef(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupLeaderboardListRef[] newArray(int i) {
            return new GroupLeaderboardListRef[i];
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

    private GroupLeaderboardListRef(Parcel parcel) {
        this.href = parcel.readString();
    }

    private GroupLeaderboardListRef(Builder builder) {
        this.href = builder.getHref();
    }

    public static Builder getBuilder() {
        return new Builder();
    }

    @Override // com.ua.sdk.Reference
    public String getHref() {
        return this.href;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.href);
    }

    public static class Builder extends BaseReferenceBuilder {
        private static final String END_DATE_KEY = "end_datetime";
        private static final String GROUP_ID_KEY = "group_id";
        private static final String ITERATION_KEY = "iteration";
        private static final String START_DATE_KEY = "start_datetime";
        Date endDate;
        String groupId;
        Integer iteration;
        Date startDate;

        public Builder() {
            super(UrlBuilderImpl.GET_GROUP_LEADERBOARD_LIST_URL);
        }

        public Builder setStartDate(Date date) {
            this.startDate = date;
            return this;
        }

        public Builder setEndDate(Date date) {
            this.endDate = date;
            return this;
        }

        public Builder setGroup(EntityRef<Group> entityRef) {
            this.groupId = entityRef.getId();
            return this;
        }

        public Builder setIteration(int i) {
            this.iteration = Integer.valueOf(i);
            return this;
        }

        public GroupLeaderboardListRef build() throws NullPointerException {
            Precondition.isNotNull(this.groupId);
            setParam("group_id", this.groupId);
            Integer num = this.iteration;
            if (num != null) {
                setParam(ITERATION_KEY, num.intValue());
                return new GroupLeaderboardListRef(this);
            }
            Precondition.isNotNull(this.startDate);
            Precondition.isNotNull(this.endDate);
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat(CalendarUtils.SQL_DATE_FORMAT);
            setParam(START_DATE_KEY, simpleDateFormat.format(this.startDate));
            setParam(END_DATE_KEY, simpleDateFormat.format(this.endDate));
            return new GroupLeaderboardListRef(this);
        }
    }
}
