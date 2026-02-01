package com.soletreadmills.sole_v2._data.api.settings;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import kotlin.Metadata;

/* compiled from: UpdatePreferenceApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/UpdatePreferenceApiData;", "", "()V", "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class UpdatePreferenceApiData {
    public static final int $stable = 0;

    /* compiled from: UpdatePreferenceApiData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/UpdatePreferenceApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends WebApiBaseData {
        public static final int $stable = 0;
    }

    /* compiled from: UpdatePreferenceApiData.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\u0019\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005R\"\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\n\u001a\u0004\b\u000b\u0010\u0007\"\u0004\b\f\u0010\t¨\u0006\r"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/settings/UpdatePreferenceApiData$RequestBodyData;", "", "enableAll", "", "disableAll", "(Ljava/lang/Boolean;Ljava/lang/Boolean;)V", "getDisableAll", "()Ljava/lang/Boolean;", "setDisableAll", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "getEnableAll", "setEnableAll", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 8;

        @SerializedName("disableAll")
        private Boolean disableAll;

        @SerializedName("enableAll")
        private Boolean enableAll;

        public RequestBodyData(Boolean bool, Boolean bool2) {
            this.enableAll = bool;
            this.disableAll = bool2;
        }

        public final Boolean getEnableAll() {
            return this.enableAll;
        }

        public final void setEnableAll(Boolean bool) {
            this.enableAll = bool;
        }

        public final Boolean getDisableAll() {
            return this.disableAll;
        }

        public final void setDisableAll(Boolean bool) {
            this.disableAll = bool;
        }
    }
}
