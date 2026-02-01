package com.ua.sdk.group.leaderboard;

import android.os.Parcel;
import android.os.Parcelable;
import com.ua.sdk.aggregate.AggregateImpl;

/* loaded from: classes2.dex */
public class GroupLeaderboardImpl extends AggregateImpl implements GroupLeaderboard {
    public static Parcelable.Creator<GroupLeaderboardImpl> CREATOR = new Parcelable.Creator<GroupLeaderboardImpl>() { // from class: com.ua.sdk.group.leaderboard.GroupLeaderboardImpl.1
        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupLeaderboardImpl createFromParcel(Parcel parcel) {
            return new GroupLeaderboardImpl(parcel);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // android.os.Parcelable.Creator
        public GroupLeaderboardImpl[] newArray(int i) {
            return new GroupLeaderboardImpl[i];
        }
    };

    public GroupLeaderboardImpl() {
    }

    private GroupLeaderboardImpl(Parcel parcel) {
        super(parcel);
    }
}
