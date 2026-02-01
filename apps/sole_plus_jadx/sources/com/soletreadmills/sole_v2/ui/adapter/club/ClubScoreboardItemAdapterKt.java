package com.soletreadmills.sole_v2.ui.adapter.club;

import androidx.camera.video.AudioStats;
import com.soletreadmills.sole_v2._data.club.ChallengeTypeSettings;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ClubScoreboardItemAdapter.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\u001a'\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"isNoScoreData", "", "challengeType", "", "rank", "currentScore", "", "(ILjava/lang/Integer;Ljava/lang/Double;)Z", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubScoreboardItemAdapterKt {
    public static final boolean isNoScoreData(int i, Integer num, Double d) {
        return i == ChallengeTypeSettings.GOAL.getId() ? Intrinsics.areEqual(d, AudioStats.AUDIO_AMPLITUDE_NONE) : i == ChallengeTypeSettings.RANKING.getId() ? Intrinsics.areEqual(d, AudioStats.AUDIO_AMPLITUDE_NONE) : i == ChallengeTypeSettings.VIRTUAL_RACE.getId() && num == null;
    }
}
