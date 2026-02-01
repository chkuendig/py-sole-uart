package com.soletreadmills.sole_v2._data.club;

import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChallengeMemberRankScoreSettings.kt */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\bJ\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\rJ&\u0010\u0013\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u0014J\u0013\u0010\u0015\u001a\u00020\u00162\b\u0010\u0017\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0018\u001a\u00020\u0005HÖ\u0001J\t\u0010\u0019\u001a\u00020\u001aHÖ\u0001R\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u000b\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\"\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0010\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001b"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberRankScoreSettings;", "", "currentScore", "", "rank", "", "(Ljava/lang/Double;Ljava/lang/Integer;)V", "getCurrentScore", "()Ljava/lang/Double;", "setCurrentScore", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getRank", "()Ljava/lang/Integer;", "setRank", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "component1", "component2", "copy", "(Ljava/lang/Double;Ljava/lang/Integer;)Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberRankScoreSettings;", "equals", "", "other", "hashCode", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ChallengeMemberRankScoreSettings {
    public static final int $stable = 8;

    @SerializedName("challengeName")
    private Double currentScore;

    @SerializedName("startTimeMillis")
    private Integer rank;

    /* JADX WARN: Multi-variable type inference failed */
    public ChallengeMemberRankScoreSettings() {
        this(null, 0 == true ? 1 : 0, 3, 0 == true ? 1 : 0);
    }

    public static /* synthetic */ ChallengeMemberRankScoreSettings copy$default(ChallengeMemberRankScoreSettings challengeMemberRankScoreSettings, Double d, Integer num, int i, Object obj) {
        if ((i & 1) != 0) {
            d = challengeMemberRankScoreSettings.currentScore;
        }
        if ((i & 2) != 0) {
            num = challengeMemberRankScoreSettings.rank;
        }
        return challengeMemberRankScoreSettings.copy(d, num);
    }

    /* renamed from: component1, reason: from getter */
    public final Double getCurrentScore() {
        return this.currentScore;
    }

    /* renamed from: component2, reason: from getter */
    public final Integer getRank() {
        return this.rank;
    }

    public final ChallengeMemberRankScoreSettings copy(Double currentScore, Integer rank) {
        return new ChallengeMemberRankScoreSettings(currentScore, rank);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChallengeMemberRankScoreSettings)) {
            return false;
        }
        ChallengeMemberRankScoreSettings challengeMemberRankScoreSettings = (ChallengeMemberRankScoreSettings) other;
        return Intrinsics.areEqual((Object) this.currentScore, (Object) challengeMemberRankScoreSettings.currentScore) && Intrinsics.areEqual(this.rank, challengeMemberRankScoreSettings.rank);
    }

    public int hashCode() {
        Double d = this.currentScore;
        int iHashCode = (d == null ? 0 : d.hashCode()) * 31;
        Integer num = this.rank;
        return iHashCode + (num != null ? num.hashCode() : 0);
    }

    public String toString() {
        return "ChallengeMemberRankScoreSettings(currentScore=" + this.currentScore + ", rank=" + this.rank + ')';
    }

    public ChallengeMemberRankScoreSettings(Double d, Integer num) {
        this.currentScore = d;
        this.rank = num;
    }

    public /* synthetic */ ChallengeMemberRankScoreSettings(Double d, Integer num, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : d, (i & 2) != 0 ? null : num);
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
}
