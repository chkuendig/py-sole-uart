package com.ua.sdk.actigraphysettings;

import com.google.gson.annotations.SerializedName;
import com.ua.sdk.internal.ApiTransferObject;

/* loaded from: classes2.dex */
public class ActigraphySettingsRequestTO extends ApiTransferObject {

    @SerializedName("recorder_type_key")
    String recorderTypeKey;

    @SerializedName("qs_type")
    String type;

    public static ActigraphySettingsRequestTO toTransferObject(ActigraphySettings actigraphySettings) {
        ActigraphySettingsRequestTO actigraphySettingsRequestTO = new ActigraphySettingsRequestTO();
        if (actigraphySettings.getActivityRecorderPriorities() != null && actigraphySettings.getActivityRecorderPriorities().get(0) != null) {
            actigraphySettingsRequestTO.type = "activity";
            actigraphySettingsRequestTO.recorderTypeKey = actigraphySettings.getActivityRecorderPriorities().get(0);
        } else if (actigraphySettings.getSleepRecorderPriorities() != null && actigraphySettings.getSleepRecorderPriorities().get(0) != null) {
            actigraphySettingsRequestTO.type = "sleep";
            actigraphySettingsRequestTO.recorderTypeKey = actigraphySettings.getSleepRecorderPriorities().get(0);
        }
        return actigraphySettingsRequestTO;
    }
}
