package com.ua.sdk.activitystory;

/* loaded from: classes2.dex */
public enum ActivityStoryType {
    PUBLIC("public", false),
    USER("user", true),
    PAGE("page", true),
    GROUP("group", true),
    REPLY("reply", true),
    WORKOUT("workout", true);

    private final boolean idRequired;
    private final String value;

    ActivityStoryType(String str, boolean z) {
        this.value = str;
        this.idRequired = z;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.value;
    }

    public boolean isIdRequired() {
        return this.idRequired;
    }
}
