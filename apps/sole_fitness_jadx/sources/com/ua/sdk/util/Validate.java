package com.ua.sdk.util;

import java.util.Collection;

/* loaded from: classes2.dex */
public final class Validate {
    private Validate() {
    }

    public static void notNull(Object obj, String str) {
        if (obj != null) {
            return;
        }
        throw new NullPointerException("Argument " + str + " cannot be null");
    }

    public static void notNullOrEmpty(String str, String str2) {
        if (Utility.isEmpty(str)) {
            throw new IllegalArgumentException("Argument " + str2 + " cannot be null or empty");
        }
    }

    public static <T> void notEmpty(Collection<T> collection, String str) {
        if (collection.isEmpty()) {
            throw new IllegalArgumentException("Container '" + str + "' cannot be empty");
        }
    }

    public static <T> void containsNoNulls(Collection<T> collection, String str) {
        notNull(collection, str);
        if (Utility.containsNull(collection)) {
            throw new NullPointerException("Container '" + str + "' cannot contain null values");
        }
    }

    public static <T> void notEmptyAndContainsNoNulls(Collection<T> collection, String str) {
        notEmpty(collection, str);
        containsNoNulls(collection, str);
    }
}
