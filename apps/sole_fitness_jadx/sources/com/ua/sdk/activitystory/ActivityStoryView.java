package com.ua.sdk.activitystory;

import com.facebook.internal.AnalyticsEvents;

/* loaded from: classes2.dex */
public enum ActivityStoryView {
    PUBLIC_STATUS("status", ActivityStoryType.PUBLIC),
    PUBLIC_PHOTO(AnalyticsEvents.PARAMETER_SHARE_DIALOG_CONTENT_PHOTO, ActivityStoryType.PUBLIC),
    PUBLIC_VIDEO("video", ActivityStoryType.PUBLIC),
    PUBLIC_WORKOUT("workout", ActivityStoryType.PUBLIC),
    USER_ME("me", ActivityStoryType.USER),
    PAGE_SELF("self", ActivityStoryType.PAGE),
    PAGE_FEATURED("featured", ActivityStoryType.PAGE);

    private final ActivityStoryType type;
    private final String value;

    ActivityStoryView(String str, ActivityStoryType activityStoryType) {
        this.value = str;
        this.type = activityStoryType;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public ActivityStoryType getActivityStoryType() {
        return this.type;
    }
}
