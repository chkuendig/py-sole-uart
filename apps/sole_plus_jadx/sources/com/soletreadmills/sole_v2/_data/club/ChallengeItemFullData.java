package com.soletreadmills.sole_v2._data.club;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChallengeItemFullData.kt */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\bl\b\u0087\b\u0018\u00002\u00020\u0001Bá\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\b\u0010\f\u001a\u0004\u0018\u00010\u0005\u0012\u0006\u0010\r\u001a\u00020\u0003\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0010\u001a\u00020\u0005\u0012\u0006\u0010\u0011\u001a\u00020\u0003\u0012\u0006\u0010\u0012\u001a\u00020\u0005\u0012\u0006\u0010\u0013\u001a\u00020\u0005\u0012\u0006\u0010\u0014\u001a\u00020\u0003\u0012\b\u0010\u0015\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0016\u001a\u00020\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0005\u0012\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019\u0012\u0006\u0010\u001b\u001a\u00020\u001c\u0012\b\u0010\u001d\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u001e\u001a\u0004\u0018\u00010\u0007\u0012\b\u0010\u001f\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010 \u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010!\u001a\u00020\u0005\u0012\u0006\u0010\"\u001a\u00020\u0005¢\u0006\u0002\u0010#J\t\u0010i\u001a\u00020\u0003HÆ\u0003J\t\u0010j\u001a\u00020\u0005HÆ\u0003J\t\u0010k\u001a\u00020\u0003HÆ\u0003J\t\u0010l\u001a\u00020\u0005HÆ\u0003J\t\u0010m\u001a\u00020\u0005HÆ\u0003J\t\u0010n\u001a\u00020\u0003HÆ\u0003J\u000b\u0010o\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010p\u001a\u00020\u0007HÆ\u0003J\t\u0010q\u001a\u00020\u0005HÆ\u0003J\u000f\u0010r\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019HÆ\u0003J\t\u0010s\u001a\u00020\u001cHÆ\u0003J\t\u0010t\u001a\u00020\u0005HÆ\u0003J\u000b\u0010u\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010v\u001a\u0004\u0018\u00010\u0007HÆ\u0003¢\u0006\u0002\u0010UJ\u0010\u0010w\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010?J\u000b\u0010x\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010y\u001a\u00020\u0005HÆ\u0003J\t\u0010z\u001a\u00020\u0005HÆ\u0003J\t\u0010{\u001a\u00020\u0007HÆ\u0003J\t\u0010|\u001a\u00020\u0007HÆ\u0003J\t\u0010}\u001a\u00020\u0003HÆ\u0003J\t\u0010~\u001a\u00020\u000bHÆ\u0003J\u0010\u0010\u007f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010?J\n\u0010\u0080\u0001\u001a\u00020\u0003HÆ\u0003J\n\u0010\u0081\u0001\u001a\u00020\u000fHÆ\u0003J\u009c\u0002\u0010\u0082\u0001\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00052\b\b\u0002\u0010\u0011\u001a\u00020\u00032\b\b\u0002\u0010\u0012\u001a\u00020\u00052\b\b\u0002\u0010\u0013\u001a\u00020\u00052\b\b\u0002\u0010\u0014\u001a\u00020\u00032\n\b\u0002\u0010\u0015\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0016\u001a\u00020\u00072\b\b\u0002\u0010\u0017\u001a\u00020\u00052\u000e\b\u0002\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u001c2\n\b\u0002\u0010\u001d\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u001e\u001a\u0004\u0018\u00010\u00072\n\b\u0002\u0010\u001f\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010 \u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010!\u001a\u00020\u00052\b\b\u0002\u0010\"\u001a\u00020\u0005HÆ\u0001¢\u0006\u0003\u0010\u0083\u0001J\u0015\u0010\u0084\u0001\u001a\u00020\u001c2\t\u0010\u0085\u0001\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\n\u0010\u0086\u0001\u001a\u00020\u0005HÖ\u0001J\n\u0010\u0087\u0001\u001a\u00020\u0003HÖ\u0001R\u001e\u0010\u0004\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001e\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001e\u0010\u0013\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010%\"\u0004\b-\u0010'R\u001e\u0010\u0014\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b.\u0010)\"\u0004\b/\u0010+R\u001e\u0010\u0016\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001e\u0010\"\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b4\u0010%\"\u0004\b5\u0010'R\u001e\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00101\"\u0004\b7\u00103R\u001e\u0010\u0017\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u0010%\"\u0004\b9\u0010'R\u001e\u0010\n\u001a\u00020\u000b8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010;\"\u0004\b<\u0010=R\"\u0010\u001f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010B\u001a\u0004\b>\u0010?\"\u0004\b@\u0010AR\u001e\u0010\u0011\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010)\"\u0004\bD\u0010+R\u001e\u0010\u001b\u001a\u00020\u001c8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010E\"\u0004\bF\u0010GR\u001e\u0010\r\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010)\"\u0004\bI\u0010+R\u001e\u0010\u000e\u001a\u00020\u000f8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bJ\u0010K\"\u0004\bL\u0010MR\u001e\u0010!\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bN\u0010%\"\u0004\bO\u0010'R$\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u00198\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bP\u0010Q\"\u0004\bR\u0010SR\"\u0010\u001e\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010X\u001a\u0004\bT\u0010U\"\u0004\bV\u0010WR\"\u0010\f\u001a\u0004\u0018\u00010\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010B\u001a\u0004\bY\u0010?\"\u0004\bZ\u0010AR \u0010\u001d\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b[\u0010)\"\u0004\b\\\u0010+R \u0010\u0015\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b]\u0010)\"\u0004\b^\u0010+R\u001e\u0010\u0010\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b_\u0010%\"\u0004\b`\u0010'R\u001e\u0010\u0012\u001a\u00020\u00058\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\ba\u0010%\"\u0004\bb\u0010'R\u001e\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bc\u00101\"\u0004\bd\u00103R\u001e\u0010\t\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\be\u0010)\"\u0004\bf\u0010+R \u0010 \u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bg\u0010)\"\u0004\bh\u0010+¨\u0006\u0088\u0001"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemFullData;", "", "challengeName", "", "activityStatus", "", "startTimeMillis", "", "endTimeMillis", "timeZone", "goalValue", "", "onMachineType", "leaderGlobalUserUuid", "leaderSimpleInfo", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeUserSimpleInfo;", "privacyLevel", "introduction", "scoreItem", "challengeType", "challengeUuid", "photoFileUrl", "createdTime", "goalAchieveRate", "memberList", "", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberData;", "isMember", "", "passCode", "midTimeMillis", "iconIdOnConsole", "virtualRaceCode", "memberCount", "displayMeasurementUnit", "(Ljava/lang/String;IJJLjava/lang/String;DLjava/lang/Integer;Ljava/lang/String;Lcom/soletreadmills/sole_v2/_data/club/ChallengeUserSimpleInfo;ILjava/lang/String;IILjava/lang/String;Ljava/lang/String;JILjava/util/List;ZLjava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;II)V", "getActivityStatus", "()I", "setActivityStatus", "(I)V", "getChallengeName", "()Ljava/lang/String;", "setChallengeName", "(Ljava/lang/String;)V", "getChallengeType", "setChallengeType", "getChallengeUuid", "setChallengeUuid", "getCreatedTime", "()J", "setCreatedTime", "(J)V", "getDisplayMeasurementUnit", "setDisplayMeasurementUnit", "getEndTimeMillis", "setEndTimeMillis", "getGoalAchieveRate", "setGoalAchieveRate", "getGoalValue", "()D", "setGoalValue", "(D)V", "getIconIdOnConsole", "()Ljava/lang/Integer;", "setIconIdOnConsole", "(Ljava/lang/Integer;)V", "Ljava/lang/Integer;", "getIntroduction", "setIntroduction", "()Z", "setMember", "(Z)V", "getLeaderGlobalUserUuid", "setLeaderGlobalUserUuid", "getLeaderSimpleInfo", "()Lcom/soletreadmills/sole_v2/_data/club/ChallengeUserSimpleInfo;", "setLeaderSimpleInfo", "(Lcom/soletreadmills/sole_v2/_data/club/ChallengeUserSimpleInfo;)V", "getMemberCount", "setMemberCount", "getMemberList", "()Ljava/util/List;", "setMemberList", "(Ljava/util/List;)V", "getMidTimeMillis", "()Ljava/lang/Long;", "setMidTimeMillis", "(Ljava/lang/Long;)V", "Ljava/lang/Long;", "getOnMachineType", "setOnMachineType", "getPassCode", "setPassCode", "getPhotoFileUrl", "setPhotoFileUrl", "getPrivacyLevel", "setPrivacyLevel", "getScoreItem", "setScoreItem", "getStartTimeMillis", "setStartTimeMillis", "getTimeZone", "setTimeZone", "getVirtualRaceCode", "setVirtualRaceCode", "component1", "component10", "component11", "component12", "component13", "component14", "component15", "component16", "component17", "component18", "component19", "component2", "component20", "component21", "component22", "component23", "component24", "component25", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;IJJLjava/lang/String;DLjava/lang/Integer;Ljava/lang/String;Lcom/soletreadmills/sole_v2/_data/club/ChallengeUserSimpleInfo;ILjava/lang/String;IILjava/lang/String;Ljava/lang/String;JILjava/util/List;ZLjava/lang/String;Ljava/lang/Long;Ljava/lang/Integer;Ljava/lang/String;II)Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemFullData;", "equals", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ChallengeItemFullData {
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

    @SerializedName("displayMeasurementUnit")
    private int displayMeasurementUnit;

    @SerializedName("endTimeMillis")
    private long endTimeMillis;

    @SerializedName("goalAchieveRate")
    private int goalAchieveRate;

    @SerializedName("goalValue")
    private double goalValue;

    @SerializedName("iconIdOnConsole")
    private Integer iconIdOnConsole;

    @SerializedName("introduction")
    private String introduction;

    @SerializedName("isMember")
    private boolean isMember;

    @SerializedName("leaderGlobalUserUuid")
    private String leaderGlobalUserUuid;

    @SerializedName("leaderSimpleInfo")
    private ChallengeUserSimpleInfo leaderSimpleInfo;

    @SerializedName("memberCount")
    private int memberCount;

    @SerializedName("memberList")
    private List<ChallengeMemberData> memberList;

    @SerializedName("midTimeMillis")
    private Long midTimeMillis;

    @SerializedName("onMachineType")
    private Integer onMachineType;

    @SerializedName("passCode")
    private String passCode;

    @SerializedName("photoFileUrl")
    private String photoFileUrl;

    @SerializedName("privacyLevel")
    private int privacyLevel;

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
    public final String getIntroduction() {
        return this.introduction;
    }

    /* renamed from: component12, reason: from getter */
    public final int getScoreItem() {
        return this.scoreItem;
    }

    /* renamed from: component13, reason: from getter */
    public final int getChallengeType() {
        return this.challengeType;
    }

    /* renamed from: component14, reason: from getter */
    public final String getChallengeUuid() {
        return this.challengeUuid;
    }

    /* renamed from: component15, reason: from getter */
    public final String getPhotoFileUrl() {
        return this.photoFileUrl;
    }

    /* renamed from: component16, reason: from getter */
    public final long getCreatedTime() {
        return this.createdTime;
    }

    /* renamed from: component17, reason: from getter */
    public final int getGoalAchieveRate() {
        return this.goalAchieveRate;
    }

    public final List<ChallengeMemberData> component18() {
        return this.memberList;
    }

    /* renamed from: component19, reason: from getter */
    public final boolean getIsMember() {
        return this.isMember;
    }

    /* renamed from: component2, reason: from getter */
    public final int getActivityStatus() {
        return this.activityStatus;
    }

    /* renamed from: component20, reason: from getter */
    public final String getPassCode() {
        return this.passCode;
    }

    /* renamed from: component21, reason: from getter */
    public final Long getMidTimeMillis() {
        return this.midTimeMillis;
    }

    /* renamed from: component22, reason: from getter */
    public final Integer getIconIdOnConsole() {
        return this.iconIdOnConsole;
    }

    /* renamed from: component23, reason: from getter */
    public final String getVirtualRaceCode() {
        return this.virtualRaceCode;
    }

    /* renamed from: component24, reason: from getter */
    public final int getMemberCount() {
        return this.memberCount;
    }

    /* renamed from: component25, reason: from getter */
    public final int getDisplayMeasurementUnit() {
        return this.displayMeasurementUnit;
    }

    /* renamed from: component3, reason: from getter */
    public final long getStartTimeMillis() {
        return this.startTimeMillis;
    }

    /* renamed from: component4, reason: from getter */
    public final long getEndTimeMillis() {
        return this.endTimeMillis;
    }

    /* renamed from: component5, reason: from getter */
    public final String getTimeZone() {
        return this.timeZone;
    }

    /* renamed from: component6, reason: from getter */
    public final double getGoalValue() {
        return this.goalValue;
    }

    /* renamed from: component7, reason: from getter */
    public final Integer getOnMachineType() {
        return this.onMachineType;
    }

    /* renamed from: component8, reason: from getter */
    public final String getLeaderGlobalUserUuid() {
        return this.leaderGlobalUserUuid;
    }

    /* renamed from: component9, reason: from getter */
    public final ChallengeUserSimpleInfo getLeaderSimpleInfo() {
        return this.leaderSimpleInfo;
    }

    public final ChallengeItemFullData copy(String challengeName, int activityStatus, long startTimeMillis, long endTimeMillis, String timeZone, double goalValue, Integer onMachineType, String leaderGlobalUserUuid, ChallengeUserSimpleInfo leaderSimpleInfo, int privacyLevel, String introduction, int scoreItem, int challengeType, String challengeUuid, String photoFileUrl, long createdTime, int goalAchieveRate, List<ChallengeMemberData> memberList, boolean isMember, String passCode, Long midTimeMillis, Integer iconIdOnConsole, String virtualRaceCode, int memberCount, int displayMeasurementUnit) {
        Intrinsics.checkNotNullParameter(challengeName, "challengeName");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        Intrinsics.checkNotNullParameter(leaderGlobalUserUuid, "leaderGlobalUserUuid");
        Intrinsics.checkNotNullParameter(leaderSimpleInfo, "leaderSimpleInfo");
        Intrinsics.checkNotNullParameter(introduction, "introduction");
        Intrinsics.checkNotNullParameter(challengeUuid, "challengeUuid");
        Intrinsics.checkNotNullParameter(memberList, "memberList");
        return new ChallengeItemFullData(challengeName, activityStatus, startTimeMillis, endTimeMillis, timeZone, goalValue, onMachineType, leaderGlobalUserUuid, leaderSimpleInfo, privacyLevel, introduction, scoreItem, challengeType, challengeUuid, photoFileUrl, createdTime, goalAchieveRate, memberList, isMember, passCode, midTimeMillis, iconIdOnConsole, virtualRaceCode, memberCount, displayMeasurementUnit);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ChallengeItemFullData)) {
            return false;
        }
        ChallengeItemFullData challengeItemFullData = (ChallengeItemFullData) other;
        return Intrinsics.areEqual(this.challengeName, challengeItemFullData.challengeName) && this.activityStatus == challengeItemFullData.activityStatus && this.startTimeMillis == challengeItemFullData.startTimeMillis && this.endTimeMillis == challengeItemFullData.endTimeMillis && Intrinsics.areEqual(this.timeZone, challengeItemFullData.timeZone) && Double.compare(this.goalValue, challengeItemFullData.goalValue) == 0 && Intrinsics.areEqual(this.onMachineType, challengeItemFullData.onMachineType) && Intrinsics.areEqual(this.leaderGlobalUserUuid, challengeItemFullData.leaderGlobalUserUuid) && Intrinsics.areEqual(this.leaderSimpleInfo, challengeItemFullData.leaderSimpleInfo) && this.privacyLevel == challengeItemFullData.privacyLevel && Intrinsics.areEqual(this.introduction, challengeItemFullData.introduction) && this.scoreItem == challengeItemFullData.scoreItem && this.challengeType == challengeItemFullData.challengeType && Intrinsics.areEqual(this.challengeUuid, challengeItemFullData.challengeUuid) && Intrinsics.areEqual(this.photoFileUrl, challengeItemFullData.photoFileUrl) && this.createdTime == challengeItemFullData.createdTime && this.goalAchieveRate == challengeItemFullData.goalAchieveRate && Intrinsics.areEqual(this.memberList, challengeItemFullData.memberList) && this.isMember == challengeItemFullData.isMember && Intrinsics.areEqual(this.passCode, challengeItemFullData.passCode) && Intrinsics.areEqual(this.midTimeMillis, challengeItemFullData.midTimeMillis) && Intrinsics.areEqual(this.iconIdOnConsole, challengeItemFullData.iconIdOnConsole) && Intrinsics.areEqual(this.virtualRaceCode, challengeItemFullData.virtualRaceCode) && this.memberCount == challengeItemFullData.memberCount && this.displayMeasurementUnit == challengeItemFullData.displayMeasurementUnit;
    }

    public int hashCode() {
        int iHashCode = ((((((((((this.challengeName.hashCode() * 31) + Integer.hashCode(this.activityStatus)) * 31) + Long.hashCode(this.startTimeMillis)) * 31) + Long.hashCode(this.endTimeMillis)) * 31) + this.timeZone.hashCode()) * 31) + Double.hashCode(this.goalValue)) * 31;
        Integer num = this.onMachineType;
        int iHashCode2 = (((((((((((((((iHashCode + (num == null ? 0 : num.hashCode())) * 31) + this.leaderGlobalUserUuid.hashCode()) * 31) + this.leaderSimpleInfo.hashCode()) * 31) + Integer.hashCode(this.privacyLevel)) * 31) + this.introduction.hashCode()) * 31) + Integer.hashCode(this.scoreItem)) * 31) + Integer.hashCode(this.challengeType)) * 31) + this.challengeUuid.hashCode()) * 31;
        String str = this.photoFileUrl;
        int iHashCode3 = (((((((((iHashCode2 + (str == null ? 0 : str.hashCode())) * 31) + Long.hashCode(this.createdTime)) * 31) + Integer.hashCode(this.goalAchieveRate)) * 31) + this.memberList.hashCode()) * 31) + Boolean.hashCode(this.isMember)) * 31;
        String str2 = this.passCode;
        int iHashCode4 = (iHashCode3 + (str2 == null ? 0 : str2.hashCode())) * 31;
        Long l = this.midTimeMillis;
        int iHashCode5 = (iHashCode4 + (l == null ? 0 : l.hashCode())) * 31;
        Integer num2 = this.iconIdOnConsole;
        int iHashCode6 = (iHashCode5 + (num2 == null ? 0 : num2.hashCode())) * 31;
        String str3 = this.virtualRaceCode;
        return ((((iHashCode6 + (str3 != null ? str3.hashCode() : 0)) * 31) + Integer.hashCode(this.memberCount)) * 31) + Integer.hashCode(this.displayMeasurementUnit);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder("ChallengeItemFullData(challengeName=");
        sb.append(this.challengeName).append(", activityStatus=").append(this.activityStatus).append(", startTimeMillis=").append(this.startTimeMillis).append(", endTimeMillis=").append(this.endTimeMillis).append(", timeZone=").append(this.timeZone).append(", goalValue=").append(this.goalValue).append(", onMachineType=").append(this.onMachineType).append(", leaderGlobalUserUuid=").append(this.leaderGlobalUserUuid).append(", leaderSimpleInfo=").append(this.leaderSimpleInfo).append(", privacyLevel=").append(this.privacyLevel).append(", introduction=").append(this.introduction).append(", scoreItem=");
        sb.append(this.scoreItem).append(", challengeType=").append(this.challengeType).append(", challengeUuid=").append(this.challengeUuid).append(", photoFileUrl=").append(this.photoFileUrl).append(", createdTime=").append(this.createdTime).append(", goalAchieveRate=").append(this.goalAchieveRate).append(", memberList=").append(this.memberList).append(", isMember=").append(this.isMember).append(", passCode=").append(this.passCode).append(", midTimeMillis=").append(this.midTimeMillis).append(", iconIdOnConsole=").append(this.iconIdOnConsole).append(", virtualRaceCode=").append(this.virtualRaceCode);
        sb.append(", memberCount=").append(this.memberCount).append(", displayMeasurementUnit=").append(this.displayMeasurementUnit).append(')');
        return sb.toString();
    }

    public ChallengeItemFullData(String challengeName, int i, long j, long j2, String timeZone, double d, Integer num, String leaderGlobalUserUuid, ChallengeUserSimpleInfo leaderSimpleInfo, int i2, String introduction, int i3, int i4, String challengeUuid, String str, long j3, int i5, List<ChallengeMemberData> memberList, boolean z, String str2, Long l, Integer num2, String str3, int i6, int i7) {
        Intrinsics.checkNotNullParameter(challengeName, "challengeName");
        Intrinsics.checkNotNullParameter(timeZone, "timeZone");
        Intrinsics.checkNotNullParameter(leaderGlobalUserUuid, "leaderGlobalUserUuid");
        Intrinsics.checkNotNullParameter(leaderSimpleInfo, "leaderSimpleInfo");
        Intrinsics.checkNotNullParameter(introduction, "introduction");
        Intrinsics.checkNotNullParameter(challengeUuid, "challengeUuid");
        Intrinsics.checkNotNullParameter(memberList, "memberList");
        this.challengeName = challengeName;
        this.activityStatus = i;
        this.startTimeMillis = j;
        this.endTimeMillis = j2;
        this.timeZone = timeZone;
        this.goalValue = d;
        this.onMachineType = num;
        this.leaderGlobalUserUuid = leaderGlobalUserUuid;
        this.leaderSimpleInfo = leaderSimpleInfo;
        this.privacyLevel = i2;
        this.introduction = introduction;
        this.scoreItem = i3;
        this.challengeType = i4;
        this.challengeUuid = challengeUuid;
        this.photoFileUrl = str;
        this.createdTime = j3;
        this.goalAchieveRate = i5;
        this.memberList = memberList;
        this.isMember = z;
        this.passCode = str2;
        this.midTimeMillis = l;
        this.iconIdOnConsole = num2;
        this.virtualRaceCode = str3;
        this.memberCount = i6;
        this.displayMeasurementUnit = i7;
    }

    public /* synthetic */ ChallengeItemFullData(String str, int i, long j, long j2, String str2, double d, Integer num, String str3, ChallengeUserSimpleInfo challengeUserSimpleInfo, int i2, String str4, int i3, int i4, String str5, String str6, long j3, int i5, List list, boolean z, String str7, Long l, Integer num2, String str8, int i6, int i7, int i8, DefaultConstructorMarker defaultConstructorMarker) {
        this((i8 & 1) != 0 ? "" : str, i, j, j2, str2, d, num, str3, challengeUserSimpleInfo, i2, str4, i3, i4, str5, str6, j3, i5, list, z, str7, l, num2, str8, i6, i7);
    }

    public final String getChallengeName() {
        return this.challengeName;
    }

    public final void setChallengeName(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.challengeName = str;
    }

    public final int getActivityStatus() {
        return this.activityStatus;
    }

    public final void setActivityStatus(int i) {
        this.activityStatus = i;
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

    public final double getGoalValue() {
        return this.goalValue;
    }

    public final void setGoalValue(double d) {
        this.goalValue = d;
    }

    public final Integer getOnMachineType() {
        return this.onMachineType;
    }

    public final void setOnMachineType(Integer num) {
        this.onMachineType = num;
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

    public final int getPrivacyLevel() {
        return this.privacyLevel;
    }

    public final void setPrivacyLevel(int i) {
        this.privacyLevel = i;
    }

    public final String getIntroduction() {
        return this.introduction;
    }

    public final void setIntroduction(String str) {
        Intrinsics.checkNotNullParameter(str, "<set-?>");
        this.introduction = str;
    }

    public final int getScoreItem() {
        return this.scoreItem;
    }

    public final void setScoreItem(int i) {
        this.scoreItem = i;
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

    public final String getPhotoFileUrl() {
        return this.photoFileUrl;
    }

    public final void setPhotoFileUrl(String str) {
        this.photoFileUrl = str;
    }

    public final long getCreatedTime() {
        return this.createdTime;
    }

    public final void setCreatedTime(long j) {
        this.createdTime = j;
    }

    public final int getGoalAchieveRate() {
        return this.goalAchieveRate;
    }

    public final void setGoalAchieveRate(int i) {
        this.goalAchieveRate = i;
    }

    public final List<ChallengeMemberData> getMemberList() {
        return this.memberList;
    }

    public final void setMemberList(List<ChallengeMemberData> list) {
        Intrinsics.checkNotNullParameter(list, "<set-?>");
        this.memberList = list;
    }

    public final boolean isMember() {
        return this.isMember;
    }

    public final void setMember(boolean z) {
        this.isMember = z;
    }

    public final String getPassCode() {
        return this.passCode;
    }

    public final void setPassCode(String str) {
        this.passCode = str;
    }

    public final Long getMidTimeMillis() {
        return this.midTimeMillis;
    }

    public final void setMidTimeMillis(Long l) {
        this.midTimeMillis = l;
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

    public final int getMemberCount() {
        return this.memberCount;
    }

    public final void setMemberCount(int i) {
        this.memberCount = i;
    }

    public final int getDisplayMeasurementUnit() {
        return this.displayMeasurementUnit;
    }

    public final void setDisplayMeasurementUnit(int i) {
        this.displayMeasurementUnit = i;
    }
}
