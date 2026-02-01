package com.ua.sdk.activitystory;

import org.apache.http.cookie.ClientCookie;

/* loaded from: classes2.dex */
public enum ActivityStoryReplyType {
    COMMENTS(ClientCookie.COMMENT_ATTR),
    LIKES("like"),
    REPOSTS("repost");

    private String value;

    ActivityStoryReplyType(String str) {
        this.value = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }
}
