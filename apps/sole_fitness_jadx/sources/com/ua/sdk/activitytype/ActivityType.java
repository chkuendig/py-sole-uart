package com.ua.sdk.activitytype;

import com.ua.sdk.Entity;
import java.util.Date;

/* loaded from: classes2.dex */
public interface ActivityType extends Entity {
    Boolean canCalculateCalories();

    Date getAccessedDate();

    String getActivityId();

    Boolean getHasChildren();

    String getIconUrl();

    String getMetsSpeed();

    Double getMetsValue();

    String getName();

    String getParentActivityId();

    String getParentUrl();

    @Override // com.ua.sdk.Entity, com.ua.sdk.Resource
    ActivityTypeRef getRef();

    String getRootActivityId();

    String getRootUrl();

    String getShortName();

    boolean hasChildren();
}
