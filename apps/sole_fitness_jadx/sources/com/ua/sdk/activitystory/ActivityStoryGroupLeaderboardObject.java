package com.ua.sdk.activitystory;

import java.util.Date;
import java.util.List;

/* loaded from: classes2.dex */
public interface ActivityStoryGroupLeaderboardObject extends ActivityStoryObject {
    Date getEndTime();

    List<ActivityStoryGroupLeaderboard> getLeaderboard();

    ActivityStoryGroupLeaderboard getResult();

    Date getStartTime();
}
