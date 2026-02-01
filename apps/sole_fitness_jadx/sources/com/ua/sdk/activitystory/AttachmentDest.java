package com.ua.sdk.activitystory;

import com.facebook.share.internal.ShareConstants;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.google.gson.annotations.SerializedName;

/* loaded from: classes2.dex */
public class AttachmentDest {

    @SerializedName(ShareConstants.WEB_DIALOG_PARAM_HREF)
    String href;

    @SerializedName(FirebaseAnalytics.Param.INDEX)
    int index;

    @SerializedName("rel")
    String rel;
    transient String userId;

    public AttachmentDest(String str, String str2, int i) {
        this(str, str2, i, null);
    }

    public AttachmentDest(String str, String str2, int i, String str3) {
        this.href = str;
        this.rel = str2;
        this.index = i;
        this.userId = str3;
    }

    public String getHref() {
        return this.href;
    }

    public String getRel() {
        return this.rel;
    }

    public int getIndex() {
        return this.index;
    }

    public String getUserId() {
        return this.userId;
    }

    public String toString() {
        return "{\"href\":\"" + this.href + "\",\"rel\":\"" + this.rel + "\",\"index\":" + this.index + '}';
    }
}
