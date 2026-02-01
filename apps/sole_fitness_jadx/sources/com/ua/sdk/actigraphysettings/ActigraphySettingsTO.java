package com.ua.sdk.actigraphysettings;

import com.google.gson.annotations.SerializedName;
import com.ua.sdk.internal.ApiTransferObject;
import java.util.List;

/* loaded from: classes2.dex */
public class ActigraphySettingsTO extends ApiTransferObject {

    @SerializedName("recorder_priorities")
    RecorderPrioritiesTransferObject recorderPriorities;

    class RecorderPrioritiesTransferObject {

        @SerializedName("activity")
        List<String> activity;

        @SerializedName("sleep")
        List<String> sleep;

        RecorderPrioritiesTransferObject() {
        }
    }

    public static ActigraphySettingsImpl fromTransferObject(ActigraphySettingsTO actigraphySettingsTO) {
        if (actigraphySettingsTO == null) {
            return null;
        }
        ActigraphySettingsImpl actigraphySettingsImpl = new ActigraphySettingsImpl();
        if (actigraphySettingsTO.recorderPriorities.sleep != null) {
            actigraphySettingsImpl.setSleepPriority(actigraphySettingsTO.recorderPriorities.sleep);
        }
        if (actigraphySettingsTO.recorderPriorities.activity != null) {
            actigraphySettingsImpl.setActivityPriority(actigraphySettingsTO.recorderPriorities.activity);
        }
        return actigraphySettingsImpl;
    }
}
