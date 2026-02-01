package com.soletreadmills.sole_v2._data.club;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChallengeItemSimpleData.kt */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\bk\b\u0087\b\u0018\u00002\u00020\u0001Bç\u0001\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u000f\u001a\u00020\f\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\f\u0012\b\u0010\u0013\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0014\u001a\u00020\f\u0012\u0006\u0010\u0015\u001a\u00020\f\u0012\b\u0010\u0016\u001a\u0004\u0018\u00010\u0011\u0012\b\u0010\u0017\u001a\u0004\u0018\u00010\f\u0012\u0006\u0010\u0018\u001a\u00020\u0019\u0012\u0006\u0010\u001a\u001a\u00020\u001b\u0012\u0006\u0010\u001c\u001a\u00020\u0005\u0012\u0006\u0010\u001d\u001a\u00020\u0005\u0012\u000e\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f\u0012\b\u0010!\u001a\u0004\u0018\u00010\f\u0012\b\u0010\"\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010#\u001a\u00020\f¢\u0006\u0002\u0010$J\u000b\u0010l\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010m\u001a\u00020\fHÆ\u0003J\t\u0010n\u001a\u00020\u0011HÆ\u0003J\t\u0010o\u001a\u00020\fHÆ\u0003J\u0010\u0010p\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010CJ\t\u0010q\u001a\u00020\fHÆ\u0003J\t\u0010r\u001a\u00020\fHÆ\u0003J\u0010\u0010s\u001a\u0004\u0018\u00010\u0011HÆ\u0003¢\u0006\u0002\u00106J\u0010\u0010t\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010CJ\t\u0010u\u001a\u00020\u0019HÆ\u0003J\t\u0010v\u001a\u00020\u001bHÆ\u0003J\t\u0010w\u001a\u00020\u0005HÆ\u0003J\t\u0010x\u001a\u00020\u0005HÆ\u0003J\t\u0010y\u001a\u00020\u0005HÆ\u0003J\u0011\u0010z\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001fHÆ\u0003J\u0010\u0010{\u001a\u0004\u0018\u00010\fHÆ\u0003¢\u0006\u0002\u0010CJ\u000b\u0010|\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010}\u001a\u00020\fHÆ\u0003J\t\u0010~\u001a\u00020\u0005HÆ\u0003J\t\u0010\u007f\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0080\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\nHÆ\u0003J\n\u0010\u0082\u0001\u001a\u00020\fHÆ\u0003J\n\u0010\u0083\u0001\u001a\u00020\u0003HÆ\u0003J\f\u0010\u0084\u0001\u001a\u0004\u0018\u00010\u0003HÆ\u0003J \u0002\u0010\u0085\u0001\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u00032\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\f2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0015\u001a\u00020\f2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00112\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\f2\b\b\u0002\u0010\u0018\u001a\u00020\u00192\b\b\u0002\u0010\u001a\u001a\u00020\u001b2\b\b\u0002\u0010\u001c\u001a\u00020\u00052\b\b\u0002\u0010\u001d\u001a\u00020\u00052\u0010\b\u0002\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f2\n\b\u0002\u0010!\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\"\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010#\u001a\u00020\fHÆ\u0001¢\u0006\u0003\u0010\u0086\u0001J\u0015\u0010\u0087\u0001\u001a\u00020\u001b2\t\u0010\u0088\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0089\u0001\u001a\u00020\fHÖ\u0001J\n\u0010\u008a\u0001\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0015\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R \u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010*\"\u0004\b+\u0010,R\u001e\u0010\u000b\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010&\"\u0004\b.\u0010(R\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010*\"\u0004\b0\u0010,R\u001e\u0010\u001c\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u00102\"\u0004\b3\u00104R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u00109\u001a\u0004\b5\u00106\"\u0004\b7\u00108R\u001e\u0010#\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010&\"\u0004\b;\u0010(R\u001e\u0010\u0006\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b<\u00102\"\u0004\b=\u00104R\u001e\u0010\u0010\u001a\u00020\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\"\u0010!\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010F\u001a\u0004\bB\u0010C\"\u0004\bD\u0010ER\u001e\u0010\u001a\u001a\u00020\u001b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010G\"\u0004\bH\u0010IR\u001e\u0010\b\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010*\"\u0004\bK\u0010,R\u001e\u0010\t\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010M\"\u0004\bN\u0010OR\u001e\u0010\u0014\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010&\"\u0004\bQ\u0010(R&\u0010\u001e\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010\u001f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bR\u0010S\"\u0004\bT\u0010UR\u001e\u0010\u001d\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bV\u00102\"\u0004\bW\u00104R\"\u0010\u0013\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010F\u001a\u0004\bX\u0010C\"\u0004\bY\u0010ER \u0010\u000e\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bZ\u0010*\"\u0004\b[\u0010,R\u001e\u0010\u000f\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\\\u0010&\"\u0004\b]\u0010(R\u001e\u0010\u0018\u001a\u00020\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b^\u0010_\"\u0004\b`\u0010aR\"\u0010\u0017\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010F\u001a\u0004\bb\u0010C\"\u0004\bc\u0010ER\u001e\u0010\u0012\u001a\u00020\f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bd\u0010&\"\u0004\be\u0010(R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bf\u00102\"\u0004\bg\u00104R\u001e\u0010\u0007\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bh\u0010*\"\u0004\bi\u0010,R \u0010\"\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bj\u0010*\"\u0004\bk\u0010,¨\u0006\u008b\u0001"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleData;", "", "challengeName", "", "startTimeMillis", "", "endTimeMillis", "timeZone", "leaderGlobalUserUuid", "leaderSimpleInfo", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeUserSimpleInfo;", "challengeType", "", "challengeUuid", "photoUrl", "privacyLevel", "goalValue", "", "scoreItem", "onMachineType", "memberCount", "activityStatus", "currentScore", "rank", "progress", "", "isGoalReached", "", "createdTime", "midTimeMillis", "memberRankScoreList", "", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberRankScoreSettings;", "iconIdOnConsole", "virtualRaceCode", "displayMeasurementUnit", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Lcom/soletreadmills/sole_v2/_data/club/ChallengeUserSimpleInfo;ILjava/lang/String;Ljava/lang/String;IDILjava/lang/Integer;IILjava/lang/Double;Ljava/lang/Integer;FZJJLjava/util/List;Ljava/lang/Integer;Ljava/lang/String;I)V", "getActivityStatus", "()I", "setActivityStatus", "(I)V", "getChallengeName", "()Ljava/lang/String;", "setChallengeName", "(Ljava/lang/String;)V", "getChallengeType", "setChallengeType", "getChallengeUuid", "setChallengeUuid", "getCreatedTime", "()J", "setCreatedTime", "(J)V", "getCurrentScore", "()Ljava/lang/Double;", "setCurrentScore", "(Ljava/lang/Double;)V", "Ljava/lang/Double;", "getDisplayMeasurementUnit", "setDisplayMeasurementUnit", "getEndTimeMillis", "setEndTimeMillis", "getGoalValue", "()D", "setGoalValue", "(D)V", "getIconIdOnConsole", "()Ljava/lang/Integer;", "setIconIdOnConsole", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "()Z", "setGoalReached", "(Z)V", "getLeaderGlobalUserUuid", "setLeaderGlobalUserUuid", "getLeaderSimpleInfo", "()Lcom/soletreadmills/sole_v2/_data/club/ChallengeUserSimpleInfo;", "setLeaderSimpleInfo", "(Lcom/soletreadmills/sole_v2/_data/club/ChallengeUserSimpleInfo;)V", "getMemberCount", "setMemberCount", "getMemberRankScoreList", "()Ljava/util/List;", "setMemberRankScoreList", "(Ljava/util/List;)V", "getMidTimeMillis", "setMidTimeMillis", "getOnMachineType", "setOnMachineType", "getPhotoUrl", "setPhotoUrl", "getPrivacyLevel", "setPrivacyLevel", "getProgress", "()F", "setProgress", "(F)V", "getRank", "setRank", "getScoreItem", "setScoreItem", "getStartTimeMillis", "setStartTimeMillis", "getTimeZone", "setTimeZone", "getVirtualRaceCode", "setVirtualRaceCode", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;JJLjava/lang/String;Ljava/lang/String;Lcom/soletreadmills/sole_v2/_data/club/ChallengeUserSimpleInfo;ILjava/lang/String;Ljava/lang/String;IDILjava/lang/Integer;IILjava/lang/Double;Ljava/lang/Integer;FZJJLjava/util/List;Ljava/lang/Integer;Ljava/lang/String;I)Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleData;", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ChallengeItemSimpleData {
    public static final int $stable = 8;

    @SerializedName("activityStatus")
    private int activityStatus;

    @SerializedName("challengeName")
    private String challengeName;

    @SerializedName("challengeType")
    private int challengeType;

    @SerializedName("challengeUuid")
    private String challengeUuid;

    @SerializedName("createdTime")
    private long createdTime;

    @SerializedName("currentScore")
    private Double currentScore;

    @SerializedName("displayMeasurementUnit")
    private int displayMeasurementUnit;

    @SerializedName("endTimeMillis")
    private long endTimeMillis;

    @SerializedName("goalValue")
    private double goalValue;

    @SerializedName("iconIdOnConsole")
    private Integer iconIdOnConsole;

    @SerializedName("isGoalReached")
    private boolean isGoalReached;

    @SerializedName("leaderGlobalUserUuid")
    private String leaderGlobalUserUuid;

    @SerializedName("leaderSimpleInfo")
    private ChallengeUserSimpleInfo leaderSimpleInfo;

    @SerializedName("memberCount")
    private int memberCount;

    @SerializedName("memberRankScoreList")
    private List<ChallengeMemberRankScoreSettings> memberRankScoreList;

    @SerializedName("midTimeMillis")
    private long midTimeMillis;

    @SerializedName("onMachineType")
    private Integer onMachineType;

    @SerializedName("photoUrl")
    private String photoUrl;

    @SerializedName("privacyLevel")
    private int privacyLevel;

    @SerializedName("progress")
    private float progress;

    @SerializedName("rank")
    private Integer rank;

    @SerializedName("scoreItem")
    private int scoreItem;

    @SerializedName("startTimeMillis")
    private long startTimeMillis;

    @SerializedName("timeZone")
    private String timeZone;

    @SerializedName("virtualRaceCode")
    private String virtualRaceCode;

    /* renamed from: component1, reason: from getter */
    public final String getChallengeName() {
        return this.challengeName;
    }

    /* renamed from: component10, reason: from getter */
    public final int getPrivacyLevel() {
        return this.privacyLevel;
    }

    /* renamed from: component11, reason: from getter */
    public final double getGoalValue() {
        return this.goalValue;
    }

    /* renamed from: component12, reason: from getter */
    public final int getScoreItem() {
        return this.scoreItem;
    }

    /* renamed from: component13, reason: from getter */
    public final Integer getOnMachineType() {
        return this.onMachineType;
    }

    /* renamed from: component14, reason: from getter */
    public final int getMemberCount() {
        return this.memberCount;
    }

    /* renamed from: component15, reason: from getter */
    public final int getActivityStatus() {
        return this.activityStatus;
    }

    /* renamed from: component16, reason: from getter */
    public final Double getCurrentScore() {
        return this.currentScore;
    }

    /* renamed from: component17, reason: from getter */
    public final Integer getRank() {
        return this.rank;
    }

    /* renamed from: component18, reason: from getter */
    public final float getProgress() {
        return this.progress;
    }

    /* renamed from: component19, reason: from getter */
    public final boolean getIsGoalReached() {
        return this.isGoalReached;
    }

    /* renamed from: component2, reason: from getter */
    public final long getStartTimeMillis() {
        return this.startTimeMillis;
    }

    /* renamed from: component20, reason: from getter */
    public final long getCreatedTime() {
        return this.createdTime;
    }

    /* renamed from: component21, reason: from getter */
    public final long getMidTimeMillis() {
        return this.midTimeMillis;
    }

    public final List<ChallengeMemberRankScoreSettings> component22() {
        return this.memberRankScoreList;
    }

    /* renamed from: component23, reason: from getter */
    public final Integer getIconIdOnConsole() {
        return this.iconIdOnConsole;
    }

    /* renamed from: component24, reason: from getter */
    public final String getVirtualRaceCode() {
        return this.virtualRaceCode;
    }

    /* renamed from: component25, reason: from getter */
    public final int getDisplayMeasurementUnit() {
        return this.displayMeasurementUnit;
    }

    /* renamed from: component3, reason: from getter */
    public final long getEndTimeMillis() {
        return this.endTimeMillis;
    }

    /* renamed from: component4, reason: from getter */
    public final String getTimeZone() {
        return this.timeZone;
    }

    /* renamed from: component5, reason: from getter */
    public final String getLeaderGlobalUserUuid() {
        return this.leaderGlobalUserUuid;
    }

    /* renamed from: component6, reason: from getter */
    public final ChallengeUserSimpleInfo getLeaderSimpleInfo() {
        return this.leaderSimpleInfo;
    }

    /* renamed from: component7, reason: from getter */
    public final int getChallengeType() {
        return this.challengeType;
    }

    /* renamed from: component8, reason: from getter */
    public final String getChallengeUuid() {
        return this.challengeUuid;
    }

    /* renamed from: component9, reason: from getter */
    public final String getPhotoUrl() {
        return this.photoUrl;
    }

    public final ChallengeItemSimpleData copy(String challengeName, long startTimeMillis, long endTimeMillis, String timeZone, String leaderGlobalUserUuid, ChallengeUserSimpleInfo leaderSimpleInfo, int challengeType, String challengeUuid, String photoUrl, int privacyLevel, double goalValue, int scoreItem, Integer onMachineType, int memberCount, int activityStatus, Double currentScore, Integer rank, float progress, boolean isGoalReached, long createdTime, long midTimeMillis, List<ChallengeMemberRankScoreSettings> memberRankScoreList, Integer iconIdOnConsole, String virtualRaceCode, int displayMeasurementUnit) {
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        Intrinsics.checkNotNullParameter(leaderGlobalUserUuid, "leaderGlobalUserUuid");
        Intrinsics.checkNotNullParameter(leaderSimpleInfo, "leaderSimpleInfo");
        Intrinsics.checkNotNullParameter(challengeUuid, "challengeUuid");
        return new ChallengeItemSimpleData(challengeName, startTimeMillis, endTimeMillis, timeZone, leaderGlobalUserUuid, leaderSimpleInfo, challengeType, challengeUuid, photoUrl, privacyLevel, goalValue, scoreItem, onMachineType, memberCount, activityStatus, currentScore, rank, progress, isGoalReached, createdTime, midTimeMillis, memberRankScoreList, iconIdOnConsole, virtualRaceCode, displayMeasurementUnit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChallengeItemSimpleData)) {
            return false;
        }
        ChallengeItemSimpleData challengeItemSimpleData = (ChallengeItemSimpleData) other;
        return Intrinsics.areEqual(this.challengeName, challengeItemSimpleData.challengeName) && this.startTimeMillis == challengeItemSimpleData.startTimeMillis && this.endTimeMillis == challengeItemSimpleData.endTimeMillis && Intrinsics.areEqual(this.timeZone, challengeItemSimpleData.timeZone) && Intrinsics.areEqual(this.leaderGlobalUserUuid, challengeItemSimpleData.leaderGlobalUserUuid) && Intrinsics.areEqual(this.leaderSimpleInfo, challengeItemSimpleData.leaderSimpleInfo) && this.challengeType == challengeItemSimpleData.challengeType && Intrinsics.areEqual(this.challengeUuid, challengeItemSimpleData.challengeUuid) && Intrinsics.areEqual(this.photoUrl, challengeItemSimpleData.photoUrl) && this.privacyLevel == challengeItemSimpleData.privacyLevel && Double.compare(this.goalValue, challengeItemSimpleData.goalValue) == 0 && this.scoreItem == challengeItemSimpleData.scoreItem && Intrinsics.areEqual(this.onMachineType, challengeItemSimpleData.onMachineType) && this.memberCount == challengeItemSimpleData.memberCount && this.activityStatus == challengeItemSimpleData.activityStatus && Intrinsics.areEqual((Object) this.currentScore, (Object) challengeItemSimpleData.currentScore) && Intrinsics.areEqual(this.rank, challengeItemSimpleData.rank) && Float.compare(this.progress, challengeItemSimpleData.progress) == 0 && this.isGoalReached == challengeItemSimpleData.isGoalReached && this.createdTime == challengeItemSimpleData.createdTime && this.midTimeMillis == challengeItemSimpleData.midTimeMillis && Intrinsics.areEqual(this.memberRankScoreList, challengeItemSimpleData.memberRankScoreList) && Intrinsics.areEqual(this.iconIdOnConsole, challengeItemSimpleData.iconIdOnConsole) && Intrinsics.areEqual(this.virtualRaceCode, challengeItemSimpleData.virtualRaceCode) && this.displayMeasurementUnit == challengeItemSimpleData.displayMeasurementUnit;
    }

    public int hashCode() {
        String str = this.challengeName;
        int iHashCode = (((((((((((((((str == null ? 0 : str.hashCode()) * 31) + Long.hashCode(this.startTimeMillis)) * 31) + Long.hashCode(this.endTimeMillis)) * 31) + this.timeZone.hashCode()) * 31) + this.leaderGlobalUserUuid.hashCode()) * 31) + this.leaderSimpleInfo.hashCode()) * 31) + Integer.hashCode(this.challengeType)) * 31) + this.challengeUuid.hashCode()) * 31;
        String str2 = this.photoUrl;
        int iHashCode2 = (((((((iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31) + Integer.hashCode(this.privacyLevel)) * 31) + Double.hashCode(this.goalValue)) * 31) + Integer.hashCode(this.scoreItem)) * 31;
        Integer num = this.onMachineType;
        int iHashCode3 = (((((iHashCode2 + (num == null ? 0 : num.hashCode())) * 31) + Integer.hashCode(this.memberCount)) * 31) + Integer.hashCode(this.activityStatus)) * 31;
        Double d = this.currentScore;
        int iHashCode4 = (iHashCode3 + (d == null ? 0 : d.hashCode())) * 31;
        Integer num2 = this.rank;
        int iHashCode5 = (((((((((iHashCode4 + (num2 == null ? 0 : num2.hashCode())) * 31) + Float.hashCode(this.progress)) * 31) + Boolean.hashCode(this.isGoalReached)) * 31) + Long.hashCode(this.createdTime)) * 31) + Long.hashCode(this.midTimeMillis)) * 31;
        List<ChallengeMemberRankScoreSettings> list = this.memberRankScoreList;
        int iHashCode6 = (iHashCode5 + (list == null ? 0 : list.hashCode())) * 31;
        Integer num3 = this.iconIdOnConsole;
        int iHashCode7 = (iHashCode6 + (num3 == null ? 0 : num3.hashCode())) * 31;
        String str3 = this.virtualRaceCode;
        return ((iHashCode7 + (str3 != null ? str3.hashCode() : 0)) * 31) + Integer.hashCode(this.displayMeasurementUnit);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChallengeItemSimpleData(challengeName=");
        sb.append(this.challengeName).append(", startTimeMillis=").append(this.startTimeMillis).append(", endTimeMillis=").append(this.endTimeMillis).append(", timeZone=").append(this.timeZone).append(", leaderGlobalUserUuid=").append(this.leaderGlobalUserUuid).append(", leaderSimpleInfo=").append(this.leaderSimpleInfo).append(", challengeType=").append(this.challengeType).append(", challengeUuid=").append(this.challengeUuid).append(", photoUrl=").append(this.photoUrl).append(", privacyLevel=").append(this.privacyLevel).append(", goalValue=").append(this.goalValue).append(", scoreItem=");
        sb.append(this.scoreItem).append(", onMachineType=").append(this.onMachineType).append(", memberCount=").append(this.memberCount).append(", activityStatus=").append(this.activityStatus).append(", currentScore=").append(this.currentScore).append(", rank=").append(this.rank).append(", progress=").append(this.progress).append(", isGoalReached=").append(this.isGoalReached).append(", createdTime=").append(this.createdTime).append(", midTimeMillis=").append(this.midTimeMillis).append(", memberRankScoreList=").append(this.memberRankScoreList).append(", iconIdOnConsole=").append(this.iconIdOnConsole);
        sb.append(", virtualRaceCode=").append(this.virtualRaceCode).append(", displayMeasurementUnit=").append(this.displayMeasurementUnit).append(')');
        return sb.toString();
    }

    public ChallengeItemSimpleData(String str, long j, long j2, String timeZone, String leaderGlobalUserUuid, ChallengeUserSimpleInfo leaderSimpleInfo, int i, String challengeUuid, String str2, int i2, double d, int i3, Integer num, int i4, int i5, Double d2, Integer num2, float f, boolean z, long j3, long j4, List<ChallengeMemberRankScoreSettings> list, Integer num3, String str3, int i6) {
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        Intrinsics.checkNotNullParameter(leaderGlobalUserUuid, "leaderGlobalUserUuid");
        Intrinsics.checkNotNullParameter(leaderSimpleInfo, "leaderSimpleInfo");
        Intrinsics.checkNotNullParameter(challengeUuid, "challengeUuid");
        this.challengeName = str;
        this.startTimeMillis = j;
        this.endTimeMillis = j2;
        this.timeZone = timeZone;
        this.leaderGlobalUserUuid = leaderGlobalUserUuid;
        this.leaderSimpleInfo = leaderSimpleInfo;
        this.challengeType = i;
        this.challengeUuid = challengeUuid;
        this.photoUrl = str2;
        this.privacyLevel = i2;
        this.goalValue = d;
        this.scoreItem = i3;
        this.onMachineType = num;
        this.memberCount = i4;
        this.activityStatus = i5;
        this.currentScore = d2;
        this.rank = num2;
        this.progress = f;
        this.isGoalReached = z;
        this.createdTime = j3;
        this.midTimeMillis = j4;
        this.memberRankScoreList = list;
        this.iconIdOnConsole = num3;
        this.virtualRaceCode = str3;
        this.displayMeasurementUnit = i6;
    }

    public /* synthetic */ ChallengeItemSimpleData(String str, long j, long j2, String str2, String str3, ChallengeUserSimpleInfo challengeUserSimpleInfo, int i, String str4, String str5, int i2, double d, int i3, Integer num, int i4, int i5, Double d2, Integer num2, float f, boolean z, long j3, long j4, List list, Integer num3, String str6, int i6, int i7, DefaultConstructorMarker defaultConstructorMarker) {
        this((i7 & 1) != 0 ? "" : str, j, j2, str2, str3, challengeUserSimpleInfo, i, str4, (i7 & 256) != 0 ? "" : str5, i2, d, i3, num, i4, i5, d2, num2, f, z, j3, j4, list, num3, str6, i6);
    }

    public final String getChallengeName() {
        return this.challengeName;
    }

    public final void setChallengeName(String str) {
        this.challengeName = str;
    }

    public final long getStartTimeMillis() {
        return this.startTimeMillis;
    }

    public final void setStartTimeMillis(long j) {
        this.startTimeMillis = j;
    }

    public final long getEndTimeMillis() {
        return this.endTimeMillis;
    }

    public final void setEndTimeMillis(long j) {
        this.endTimeMillis = j;
    }

    public final String getTimeZone() {
        return this.timeZone;
    }

    public final void setTimeZone(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.timeZone = str;
    }

    public final String getLeaderGlobalUserUuid() {
        return this.leaderGlobalUserUuid;
    }

    public final void setLeaderGlobalUserUuid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.leaderGlobalUserUuid = str;
    }

    public final ChallengeUserSimpleInfo getLeaderSimpleInfo() {
        return this.leaderSimpleInfo;
    }

    public final void setLeaderSimpleInfo(ChallengeUserSimpleInfo challengeUserSimpleInfo) {
        Intrinsics.checkNotNullParameter(challengeUserSimpleInfo, "<set-?>");
        this.leaderSimpleInfo = challengeUserSimpleInfo;
    }

    public final int getChallengeType() {
        return this.challengeType;
    }

    public final void setChallengeType(int i) {
        this.challengeType = i;
    }

    public final String getChallengeUuid() {
        return this.challengeUuid;
    }

    public final void setChallengeUuid(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.challengeUuid = str;
    }

    public final String getPhotoUrl() {
        return this.photoUrl;
    }

    public final void setPhotoUrl(String str) {
        this.photoUrl = str;
    }

    public final int getPrivacyLevel() {
        return this.privacyLevel;
    }

    public final void setPrivacyLevel(int i) {
        this.privacyLevel = i;
    }

    public final double getGoalValue() {
        return this.goalValue;
    }

    public final void setGoalValue(double d) {
        this.goalValue = d;
    }

    public final int getScoreItem() {
        return this.scoreItem;
    }

    public final void setScoreItem(int i) {
        this.scoreItem = i;
    }

    public final Integer getOnMachineType() {
        return this.onMachineType;
    }

    public final void setOnMachineType(Integer num) {
        this.onMachineType = num;
    }

    public final int getMemberCount() {
        return this.memberCount;
    }

    public final void setMemberCount(int i) {
        this.memberCount = i;
    }

    public final int getActivityStatus() {
        return this.activityStatus;
    }

    public final void setActivityStatus(int i) {
        this.activityStatus = i;
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

    public final float getProgress() {
        return this.progress;
    }

    public final void setProgress(float f) {
        this.progress = f;
    }

    public final boolean isGoalReached() {
        return this.isGoalReached;
    }

    public final void setGoalReached(boolean z) {
        this.isGoalReached = z;
    }

    public final long getCreatedTime() {
        return this.createdTime;
    }

    public final void setCreatedTime(long j) {
        this.createdTime = j;
    }

    public final long getMidTimeMillis() {
        return this.midTimeMillis;
    }

    public final void setMidTimeMillis(long j) {
        this.midTimeMillis = j;
    }

    public final List<ChallengeMemberRankScoreSettings> getMemberRankScoreList() {
        return this.memberRankScoreList;
    }

    public final void setMemberRankScoreList(List<ChallengeMemberRankScoreSettings> list) {
        this.memberRankScoreList = list;
    }

    public final Integer getIconIdOnConsole() {
        return this.iconIdOnConsole;
    }

    public final void setIconIdOnConsole(Integer num) {
        this.iconIdOnConsole = num;
    }

    public final String getVirtualRaceCode() {
        return this.virtualRaceCode;
    }

    public final void setVirtualRaceCode(String str) {
        this.virtualRaceCode = str;
    }

    public final int getDisplayMeasurementUnit() {
        return this.displayMeasurementUnit;
    }

    public final void setDisplayMeasurementUnit(int i) {
        this.displayMeasurementUnit = i;
    }
}
