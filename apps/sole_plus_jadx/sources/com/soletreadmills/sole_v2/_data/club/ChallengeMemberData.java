package com.soletreadmills.sole_v2._data.club;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChallengeMemberData.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b3\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u000e\u001a\u00020\u0007\u0012\u0006\u0010\u000f\u001a\u00020\u0007\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\r\u0012\u0006\u0010\u0011\u001a\u00020\u0012¢\u0006\u0002\u0010\u0013J\t\u00105\u001a\u00020\u0003HÆ\u0003J\t\u00106\u001a\u00020\u0012HÆ\u0003J\t\u00107\u001a\u00020\u0005HÆ\u0003J\t\u00108\u001a\u00020\u0007HÆ\u0003J\t\u00109\u001a\u00020\tHÆ\u0003J\u0010\u0010:\u001a\u0004\u0018\u00010\u000bHÆ\u0003¢\u0006\u0002\u0010\u0019J\u0010\u0010;\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010+J\t\u0010<\u001a\u00020\u0007HÆ\u0003J\t\u0010=\u001a\u00020\u0007HÆ\u0003J\u0010\u0010>\u001a\u0004\u0018\u00010\rHÆ\u0003¢\u0006\u0002\u0010+Jx\u0010?\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00072\b\b\u0002\u0010\u000f\u001a\u00020\u00072\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u0011\u001a\u00020\u0012HÆ\u0001¢\u0006\u0002\u0010@J\u0013\u0010A\u001a\u00020\u00072\b\u0010B\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010C\u001a\u00020\rHÖ\u0001J\t\u0010D\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0011\u001a\u00020\u00128\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\"\u0010\n\u001a\u0004\u0018\u00010\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u001c\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u001e\"\u0004\b\u001f\u0010 R\u001e\u0010\u000e\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010!\"\u0004\b\"\u0010#R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010!\"\u0004\b$\u0010#R\u001e\u0010\u000f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010!\"\u0004\b%\u0010#R\u001e\u0010\b\u001a\u00020\t8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010'\"\u0004\b(\u0010)R\"\u0010\f\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b*\u0010+\"\u0004\b,\u0010-R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u00100\"\u0004\b1\u00102R\"\u0010\u0010\u001a\u0004\u0018\u00010\r8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010.\u001a\u0004\b3\u0010+\"\u0004\b4\u0010-¨\u0006E"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberData;", "", "globalUserUuid", "", "userSimpleInfo", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeUserSimpleInfo;", "isLeader", "", "progress", "", "currentScore", "", "rank", "", "isGoalReached", "isPassForVirtualRace", "virtualRaceFailReason", "createdTime", "", "(Ljava/lang/String;Lcom/soletreadmills/sole_v2/_data/club/ChallengeUserSimpleInfo;ZFLjava/lang/Double;Ljava/lang/Integer;ZZLjava/lang/Integer;J)V", "getCreatedTime", "()J", "setCreatedTime", "(J)V", "getCurrentScore", "()Ljava/lang/Double;", "setCurrentScore", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getGlobalUserUuid", "()Ljava/lang/String;", "setGlobalUserUuid", "(Ljava/lang/String;)V", "()Z", "setGoalReached", "(Z)V", "setLeader", "setPassForVirtualRace", "getProgress", "()F", "setProgress", "(F)V", "getRank", "()Ljava/lang/Integer;", "setRank", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getUserSimpleInfo", "()Lcom/soletreadmills/sole_v2/_data/club/ChallengeUserSimpleInfo;", "setUserSimpleInfo", "(Lcom/soletreadmills/sole_v2/_data/club/ChallengeUserSimpleInfo;)V", "getVirtualRaceFailReason", "setVirtualRaceFailReason", "component1", "component10", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Lcom/soletreadmills/sole_v2/_data/club/ChallengeUserSimpleInfo;ZFLjava/lang/Double;Ljava/lang/Integer;ZZLjava/lang/Integer;J)Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberData;", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ChallengeMemberData {
    public static final int $stable = 8;

    @SerializedName("createdTime")
    private long createdTime;

    @SerializedName("currentScore")
    private Double currentScore;

    @SerializedName("globalUserUuid")
    private String globalUserUuid;

    @SerializedName("isGoalReached")
    private boolean isGoalReached;

    @SerializedName("isLeader")
    private boolean isLeader;

    @SerializedName("isPassForVirtualRace")
    private boolean isPassForVirtualRace;

    @SerializedName("progress")
    private float progress;

    @SerializedName("rank")
    private Integer rank;

    @SerializedName("userSimpleInfo")
    private ChallengeUserSimpleInfo userSimpleInfo;

    @SerializedName("virtualRaceFailReason")
    private Integer virtualRaceFailReason;

    /* renamed from: component1, reason: from getter */
    public final String getGlobalUserUuid() {
        return this.globalUserUuid;
    }

    /* renamed from: component10, reason: from getter */
    public final long getCreatedTime() {
        return this.createdTime;
    }

    /* renamed from: component2, reason: from getter */
    public final ChallengeUserSimpleInfo getUserSimpleInfo() {
        return this.userSimpleInfo;
    }

    /* renamed from: component3, reason: from getter */
    public final boolean getIsLeader() {
        return this.isLeader;
    }

    /* renamed from: component4, reason: from getter */
    public final float getProgress() {
        return this.progress;
    }

    /* renamed from: component5, reason: from getter */
    public final Double getCurrentScore() {
        return this.currentScore;
    }

    /* renamed from: component6, reason: from getter */
    public final Integer getRank() {
        return this.rank;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsGoalReached() {
        return this.isGoalReached;
    }

    /* renamed from: component8, reason: from getter */
    public final boolean getIsPassForVirtualRace() {
        return this.isPassForVirtualRace;
    }

    /* renamed from: component9, reason: from getter */
    public final Integer getVirtualRaceFailReason() {
        return this.virtualRaceFailReason;
    }

    public final ChallengeMemberData copy(String globalUserUuid, ChallengeUserSimpleInfo userSimpleInfo, boolean isLeader, float progress, Double currentScore, Integer rank, boolean isGoalReached, boolean isPassForVirtualRace, Integer virtualRaceFailReason, long createdTime) {
        Intrinsics.checkNotNullParameter(globalUserUuid, "globalUserUuid");
        Intrinsics.checkNotNullParameter(userSimpleInfo, "userSimpleInfo");
        return new ChallengeMemberData(globalUserUuid, userSimpleInfo, isLeader, progress, currentScore, rank, isGoalReached, isPassForVirtualRace, virtualRaceFailReason, createdTime);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChallengeMemberData)) {
            return false;
        }
        ChallengeMemberData challengeMemberData = (ChallengeMemberData) other;
        return Intrinsics.areEqual(this.globalUserUuid, challengeMemberData.globalUserUuid) && Intrinsics.areEqual(this.userSimpleInfo, challengeMemberData.userSimpleInfo) && this.isLeader == challengeMemberData.isLeader && Float.compare(this.progress, challengeMemberData.progress) == 0 && Intrinsics.areEqual((Object) this.currentScore, (Object) challengeMemberData.currentScore) && Intrinsics.areEqual(this.rank, challengeMemberData.rank) && this.isGoalReached == challengeMemberData.isGoalReached && this.isPassForVirtualRace == challengeMemberData.isPassForVirtualRace && Intrinsics.areEqual(this.virtualRaceFailReason, challengeMemberData.virtualRaceFailReason) && this.createdTime == challengeMemberData.createdTime;
    }

    public int hashCode() {
        int iHashCode = ((((((this.globalUserUuid.hashCode() * 31) + this.userSimpleInfo.hashCode()) * 31) + Boolean.hashCode(this.isLeader)) * 31) + Float.hashCode(this.progress)) * 31;
        Double d = this.currentScore;
        int iHashCode2 = (iHashCode + (d == null ? 0 : d.hashCode())) * 31;
        Integer num = this.rank;
        int iHashCode3 = (((((iHashCode2 + (num == null ? 0 : num.hashCode())) * 31) + Boolean.hashCode(this.isGoalReached)) * 31) + Boolean.hashCode(this.isPassForVirtualRace)) * 31;
        Integer num2 = this.virtualRaceFailReason;
        return ((iHashCode3 + (num2 != null ? num2.hashCode() : 0)) * 31) + Long.hashCode(this.createdTime);
    }

    public String toString() {
        return "ChallengeMemberData(globalUserUuid=" + this.globalUserUuid + ", userSimpleInfo=" + this.userSimpleInfo + ", isLeader=" + this.isLeader + ", progress=" + this.progress + ", currentScore=" + this.currentScore + ", rank=" + this.rank + ", isGoalReached=" + this.isGoalReached + ", isPassForVirtualRace=" + this.isPassForVirtualRace + ", virtualRaceFailReason=" + this.virtualRaceFailReason + ", createdTime=" + this.createdTime + ')';
    }

    public ChallengeMemberData(String globalUserUuid, ChallengeUserSimpleInfo userSimpleInfo, boolean z, float f, Double d, Integer num, boolean z2, boolean z3, Integer num2, long j) {
        Intrinsics.checkNotNullParameter(globalUserUuid, "globalUserUuid");
        Intrinsics.checkNotNullParameter(userSimpleInfo, "userSimpleInfo");
        this.globalUserUuid = globalUserUuid;
        this.userSimpleInfo = userSimpleInfo;
        this.isLeader = z;
        this.progress = f;
        this.currentScore = d;
        this.rank = num;
        this.isGoalReached = z2;
        this.isPassForVirtualRace = z3;
        this.virtualRaceFailReason = num2;
        this.createdTime = j;
    }

    public final String getGlobalUserUuid() {
        return this.globalUserUuid;
    }

    public final void setGlobalUserUuid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.globalUserUuid = str;
    }

    public final ChallengeUserSimpleInfo getUserSimpleInfo() {
        return this.userSimpleInfo;
    }

    public final void setUserSimpleInfo(ChallengeUserSimpleInfo challengeUserSimpleInfo) {
        Intrinsics.checkNotNullParameter(challengeUserSimpleInfo, "<set-?>");
        this.userSimpleInfo = challengeUserSimpleInfo;
    }

    public final boolean isLeader() {
        return this.isLeader;
    }

    public final void setLeader(boolean z) {
        this.isLeader = z;
    }

    public final float getProgress() {
        return this.progress;
    }

    public final void setProgress(float f) {
        this.progress = f;
    }

    public final Double getCurrentScore() {
        return this.currentScore;
    }

    public final void setCurrentScore(Double d) {
        this.currentScore = d;
    }

    public final Integer getRank() {
        return this.rank;
    }

    public final void setRank(Integer num) {
        this.rank = num;
    }

    public final boolean isGoalReached() {
        return this.isGoalReached;
    }

    public final void setGoalReached(boolean z) {
        this.isGoalReached = z;
    }

    public final boolean isPassForVirtualRace() {
        return this.isPassForVirtualRace;
    }

    public final void setPassForVirtualRace(boolean z) {
        this.isPassForVirtualRace = z;
    }

    public final Integer getVirtualRaceFailReason() {
        return this.virtualRaceFailReason;
    }

    public final void setVirtualRaceFailReason(Integer num) {
        this.virtualRaceFailReason = num;
    }

    public final long getCreatedTime() {
        return this.createdTime;
    }

    public final void setCreatedTime(long j) {
        this.createdTime = j;
    }
}
