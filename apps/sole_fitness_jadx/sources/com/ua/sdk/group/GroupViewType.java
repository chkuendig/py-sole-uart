package com.ua.sdk.group;

/* loaded from: classes2.dex */
public enum GroupViewType {
    MEMBER("member"),
    INVITED("invited"),
    COMPLETED("completed"),
    IN_PROGRESS("in_progress"),
    ALL("all");

    private final String name;

    GroupViewType(String str) {
        this.name = str;
    }

    @Override // java.lang.Enum
    public String toString() {
        return this.name;
    }
}
