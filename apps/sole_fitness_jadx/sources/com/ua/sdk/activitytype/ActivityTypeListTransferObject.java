package com.ua.sdk.activitytype;

import com.google.gson.annotations.SerializedName;
import com.ua.sdk.cache.EntityDatabase;
import com.ua.sdk.internal.ApiTransferObject;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes2.dex */
class ActivityTypeListTransferObject extends ApiTransferObject {
    private static final String EMBEDDED_ACTIVITY_TYPES = "activity_types";

    @SerializedName("_embedded")
    Map<String, List<ActivityTypeTransferObject>> embedded;

    @SerializedName(EntityDatabase.LIST.COLS.TOTAL_COUNT)
    Integer totalCount;

    public List<ActivityTypeTransferObject> getActivityTypes() {
        return this.embedded.get(EMBEDDED_ACTIVITY_TYPES);
    }

    public static List<ActivityTypeImpl> toImplList(ActivityTypeListTransferObject activityTypeListTransferObject) {
        List<ActivityTypeTransferObject> activityTypes = activityTypeListTransferObject.getActivityTypes();
        if (activityTypes == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(activityTypes.size());
        Iterator<ActivityTypeTransferObject> it = activityTypes.iterator();
        while (it.hasNext()) {
            arrayList.add(ActivityTypeTransferObject.toImpl(it.next()));
        }
        return arrayList;
    }
}
