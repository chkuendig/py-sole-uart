package com.ua.sdk.activitystory;

import android.os.Parcelable;

/* loaded from: classes2.dex */
public interface ActivityStoryActor extends Parcelable {

    public enum Type {
        USER,
        SITE,
        BRAND,
        PAGE,
        GROUP,
        UNKNOWN
    }

    String getId();

    Type getType();
}
