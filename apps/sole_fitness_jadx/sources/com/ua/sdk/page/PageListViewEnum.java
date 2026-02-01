package com.ua.sdk.page;

/* loaded from: classes2.dex */
public enum PageListViewEnum {
    INITIAL("initial"),
    SUGGESTED("suggested");

    private final String name;

    PageListViewEnum(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }
}
