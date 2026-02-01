package com.soletreadmills.sole_v2._data.club;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChallengeMemberWorkoutWithUserSimpleInfoData.kt */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\u000f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0003J#\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005HÆ\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR$\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001a"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberWorkoutWithUserSimpleInfoData;", "", "userSimpleInfo", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeUserSimpleInfo;", "workoutList", "", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberWorkoutData;", "(Lcom/soletreadmills/sole_v2/_data/club/ChallengeUserSimpleInfo;Ljava/util/List;)V", "getUserSimpleInfo", "()Lcom/soletreadmills/sole_v2/_data/club/ChallengeUserSimpleInfo;", "setUserSimpleInfo", "(Lcom/soletreadmills/sole_v2/_data/club/ChallengeUserSimpleInfo;)V", "getWorkoutList", "()Ljava/util/List;", "setWorkoutList", "(Ljava/util/List;)V", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ChallengeMemberWorkoutWithUserSimpleInfoData {
    public static final int $stable = 8;

    @SerializedName("userSimpleInfo")
    private ChallengeUserSimpleInfo userSimpleInfo;

    @SerializedName("workoutList")
    private List<ChallengeMemberWorkoutData> workoutList;

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ ChallengeMemberWorkoutWithUserSimpleInfoData copy$default(ChallengeMemberWorkoutWithUserSimpleInfoData challengeMemberWorkoutWithUserSimpleInfoData, ChallengeUserSimpleInfo challengeUserSimpleInfo, List list, int i, Object obj) {
        if ((i & 1) != 0) {
            challengeUserSimpleInfo = challengeMemberWorkoutWithUserSimpleInfoData.userSimpleInfo;
        }
        if ((i & 2) != 0) {
            list = challengeMemberWorkoutWithUserSimpleInfoData.workoutList;
        }
        return challengeMemberWorkoutWithUserSimpleInfoData.copy(challengeUserSimpleInfo, list);
    }

    /* renamed from: component1, reason: from getter */
    public final ChallengeUserSimpleInfo getUserSimpleInfo() {
        return this.userSimpleInfo;
    }

    public final List<ChallengeMemberWorkoutData> component2() {
        return this.workoutList;
    }

    public final ChallengeMemberWorkoutWithUserSimpleInfoData copy(ChallengeUserSimpleInfo userSimpleInfo, List<ChallengeMemberWorkoutData> workoutList) {
        Intrinsics.checkNotNullParameter(userSimpleInfo, "userSimpleInfo");
        Intrinsics.checkNotNullParameter(workoutList, "workoutList");
        return new ChallengeMemberWorkoutWithUserSimpleInfoData(userSimpleInfo, workoutList);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChallengeMemberWorkoutWithUserSimpleInfoData)) {
            return false;
        }
        ChallengeMemberWorkoutWithUserSimpleInfoData challengeMemberWorkoutWithUserSimpleInfoData = (ChallengeMemberWorkoutWithUserSimpleInfoData) other;
        return Intrinsics.areEqual(this.userSimpleInfo, challengeMemberWorkoutWithUserSimpleInfoData.userSimpleInfo) && Intrinsics.areEqual(this.workoutList, challengeMemberWorkoutWithUserSimpleInfoData.workoutList);
    }

    public int hashCode() {
        return (this.userSimpleInfo.hashCode() * 31) + this.workoutList.hashCode();
    }

    public String toString() {
        return "ChallengeMemberWorkoutWithUserSimpleInfoData(userSimpleInfo=" + this.userSimpleInfo + ", workoutList=" + this.workoutList + ')';
    }

    public ChallengeMemberWorkoutWithUserSimpleInfoData(ChallengeUserSimpleInfo userSimpleInfo, List<ChallengeMemberWorkoutData> workoutList) {
        Intrinsics.checkNotNullParameter(userSimpleInfo, "userSimpleInfo");
        Intrinsics.checkNotNullParameter(workoutList, "workoutList");
        this.userSimpleInfo = userSimpleInfo;
        this.workoutList = workoutList;
    }

    public final ChallengeUserSimpleInfo getUserSimpleInfo() {
        return this.userSimpleInfo;
    }

    public final void setUserSimpleInfo(ChallengeUserSimpleInfo challengeUserSimpleInfo) {
        Intrinsics.checkNotNullParameter(challengeUserSimpleInfo, "<set-?>");
        this.userSimpleInfo = challengeUserSimpleInfo;
    }

    public final List<ChallengeMemberWorkoutData> getWorkoutList() {
        return this.workoutList;
    }

    public final void setWorkoutList(List<ChallengeMemberWorkoutData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.workoutList = list;
    }
}
