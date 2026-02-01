package com.ua.sdk.page;

/* loaded from: classes2.dex */
public enum PageTypeEnum {
    PERSONAL("personal"),
    PUBLIC_ENTITY("public_entity"),
    PUBLIC_FIGURE("public_figure");

    private final String name;

    PageTypeEnum(String str) {
        this.name = str;
    }

    public String getName() {
        return this.name;
    }

    public static PageTypeEnum getById(String str) {
        for (PageTypeEnum pageTypeEnum : values()) {
            if (pageTypeEnum.toString().toLowerCase().equals(str)) {
                return pageTypeEnum;
            }
        }
        return null;
    }
}
