package com.ua.sdk.activitystory;

import android.os.Parcelable;

/* loaded from: classes2.dex */
public interface ActivityStoryObject extends Parcelable {

    public enum Type {
        WORKOUT,
        ROUTE,
        USER,
        ACTIGRAPHY,
        COMMENT,
        LIKE,
        TOUT,
        AD,
        STATUS,
        REPOST,
        GROUP,
        GROUP_LEADERBOARD
    }

    Type getType();
}
