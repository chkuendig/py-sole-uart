package com.ua.sdk.activitystory;

import com.ua.sdk.activitystory.ActivityStoryObject;

/* loaded from: classes2.dex */
public interface ActivityStoryToutObject extends ActivityStoryObject {

    public enum Subtype {
        FIND_FRIENDS
    }

    Subtype getSubtype();

    @Override // com.ua.sdk.activitystory.ActivityStoryObject
    ActivityStoryObject.Type getType();
}
