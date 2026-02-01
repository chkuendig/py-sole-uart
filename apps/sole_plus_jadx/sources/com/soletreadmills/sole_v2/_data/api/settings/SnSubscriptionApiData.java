package com.soletreadmills.sole_v2._data.api.settings;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.JwtApiBaseData;
import kotlin.Metadata;

/* compiled from: SnSubscriptionApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/SnSubscriptionApiData;", "", "()V", "RequestBody", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class SnSubscriptionApiData {
    public static final int $stable = 0;

    /* compiled from: SnSubscriptionApiData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/SnSubscriptionApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/JwtApiBaseData;", "()V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends JwtApiBaseData {
        public static final int $stable = 0;
    }

    /* compiled from: SnSubscriptionApiData.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/SnSubscriptionApiData$RequestBody;", "", "sn", "", "(Ljava/lang/String;)V", "getSn", "()Ljava/lang/String;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBody {
        public static final int $stable = 0;

        @SerializedName("sn")
        private final String sn;

        public RequestBody(String str) {
            this.sn = str;
        }

        public final String getSn() {
            return this.sn;
        }
    }
}
