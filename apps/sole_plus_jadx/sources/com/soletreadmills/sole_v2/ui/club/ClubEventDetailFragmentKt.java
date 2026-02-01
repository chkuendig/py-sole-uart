package com.soletreadmills.sole_v2.ui.club;

import androidx.camera.video.AudioStats;
import com.soletreadmills.sole_v2._data.club.ChallengeMemberData;
import com.soletreadmills.sole_v2._data.club.ChallengeUserSimpleInfo;
import kotlin.Metadata;

/* compiled from: ClubEventDetailFragment.kt */
@Metadata(d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0006\u0010\u0000\u001a\u00020\u0001¨\u0006\u0002"}, d2 = {"createPlaceholderMember", "Lcom/soletreadmills/sole_v2/_data/club/ChallengeMemberData;", "app_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class ClubEventDetailFragmentKt {
    public static final ChallengeMemberData createPlaceholderMember() {
        return new ChallengeMemberData("", new ChallengeUserSimpleInfo("", null, null), false, 0.0f, Double.valueOf(AudioStats.AUDIO_AMPLITUDE_NONE), null, false, false, null, 0L);
    }
}
