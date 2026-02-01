package com.ua.sdk.activitytype;

import com.facebook.internal.security.CertificateUtil;
import com.google.gson.annotations.SerializedName;
import com.ua.sdk.datapoint.BaseDataTypes;
import com.ua.sdk.internal.ApiTransferObject;
import com.ua.sdk.internal.Link;
import java.util.List;

/* loaded from: classes2.dex */
class ActivityTypeTransferObject extends ApiTransferObject {
    protected static final String ICON_URL = "icon_url";
    protected static final String LINK_PARENT = "parent";
    protected static final String LINK_ROOT = "root";

    @SerializedName("has_children")
    Boolean hasChildren;

    @SerializedName("mets")
    Double mets;

    @SerializedName("mets_speed")
    List<MetsSpeedTransferObject> metsSpeed;

    @SerializedName("name")
    String name;

    @SerializedName("short_name")
    String shortName;

    class MetsSpeedTransferObject {

        @SerializedName("mets")
        String mets;

        @SerializedName(BaseDataTypes.ID_SPEED)
        Double speed;

        MetsSpeedTransferObject() {
        }
    }

    public static ActivityTypeImpl toImpl(ActivityTypeTransferObject activityTypeTransferObject) {
        if (activityTypeTransferObject == null) {
            return null;
        }
        ActivityTypeImpl activityTypeImpl = new ActivityTypeImpl(activityTypeTransferObject.getActivityId(), activityTypeTransferObject.getParentActivityId(), activityTypeTransferObject.name, activityTypeTransferObject.shortName, activityTypeTransferObject.mets, activityTypeTransferObject.getMetsSpeedString(), activityTypeTransferObject.hasChildren, null);
        activityTypeImpl.setLinkMap(activityTypeTransferObject.getLinkMap());
        return activityTypeImpl;
    }

    private String getLinkActivityId(String str) {
        Link link = getLink(str);
        if (link == null) {
            return null;
        }
        return link.getId();
    }

    public String getActivityId() {
        return getLinkActivityId("self");
    }

    public String getParentActivityId() {
        return getLinkActivityId(LINK_PARENT);
    }

    public String getMetsSpeedString() {
        List<MetsSpeedTransferObject> list = this.metsSpeed;
        if (list == null || list.isEmpty()) {
            return "{}";
        }
        int size = this.metsSpeed.size();
        StringBuilder sb = new StringBuilder();
        sb.append('{');
        for (int i = 0; i < size; i++) {
            if (i > 0) {
                sb.append(',');
            }
            MetsSpeedTransferObject metsSpeedTransferObject = this.metsSpeed.get(i);
            sb.append("\"");
            sb.append(metsSpeedTransferObject.mets);
            sb.append("\"");
            sb.append(CertificateUtil.DELIMITER);
            sb.append(metsSpeedTransferObject.speed);
        }
        sb.append('}');
        return sb.toString();
    }
}
