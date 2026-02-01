package com.ua.sdk.activitystory;

import android.os.Parcelable;
import java.util.List;

/* loaded from: classes2.dex */
public interface ActivityStoryRepostSummary extends Parcelable {
    List<ActivityStory> getItems();

    int getTotalCount();

    boolean isReposted();
}
