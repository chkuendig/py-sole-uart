package com.soletreadmills.sole_v2._data.club;

import androidx.camera.video.AudioStats;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ChallengeItemFullData.kt */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, d2 = {"toSimpleWithMemberData", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemSimpleDataWithMemberData;", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeItemFullData;", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ChallengeItemFullDataKt {
    public static final ChallengeItemSimpleDataWithMemberData toSimpleWithMemberData(ChallengeItemFullData challengeItemFullData) {
        Intrinsics.checkNotNullParameter(challengeItemFullData, "<this>");
        String challengeName = challengeItemFullData.getChallengeName();
        long startTimeMillis = challengeItemFullData.getStartTimeMillis();
        long endTimeMillis = challengeItemFullData.getEndTimeMillis();
        String timeZone = challengeItemFullData.getTimeZone();
        ChallengeUserSimpleInfo leaderSimpleInfo = challengeItemFullData.getLeaderSimpleInfo();
        String leaderGlobalUserUuid = challengeItemFullData.getLeaderGlobalUserUuid();
        int challengeType = challengeItemFullData.getChallengeType();
        String challengeUuid = challengeItemFullData.getChallengeUuid();
        String photoFileUrl = challengeItemFullData.getPhotoFileUrl();
        if (photoFileUrl == null) {
            photoFileUrl = "";
        }
        return new ChallengeItemSimpleDataWithMemberData(challengeName, startTimeMillis, endTimeMillis, timeZone, leaderSimpleInfo, leaderGlobalUserUuid, challengeType, challengeUuid, photoFileUrl, challengeItemFullData.getPrivacyLevel(), challengeItemFullData.getGoalValue(), challengeItemFullData.getScoreItem(), challengeItemFullData.getOnMachineType(), challengeItemFullData.getMemberCount(), challengeItemFullData.getActivityStatus(), Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE), 0, 0.0f, false, null, challengeItemFullData.getCreatedTime(), challengeItemFullData.getMidTimeMillis(), CollectionsKt.emptyList(), challengeItemFullData.getIconIdOnConsole(), challengeItemFullData.getVirtualRaceCode(), 524288, null);
    }
}
