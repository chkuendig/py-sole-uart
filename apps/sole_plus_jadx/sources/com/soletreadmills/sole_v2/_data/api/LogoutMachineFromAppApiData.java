package com.soletreadmills.sole_v2._data.api;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: LogoutMachineFromAppApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001:\u0002\u0003\u0004B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0005"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/LogoutMachineFromAppApiData;", "", "()V", "RequestBodyData", "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class LogoutMachineFromAppApiData {
    public static final int $stable = 0;

    /* compiled from: LogoutMachineFromAppApiData.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/LogoutMachineFromAppApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends WebApiBaseData {
        public static final int $stable = 0;
    }

    /* compiled from: LogoutMachineFromAppApiData.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005R\u001c\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/LogoutMachineFromAppApiData$RequestBodyData;", "", "machineConsoleUuidList", "", "", "(Ljava/util/List;)V", "getMachineConsoleUuidList", "()Ljava/util/List;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class RequestBodyData {
        public static final int $stable = 8;

        @SerializedName("machineConsoleUuidList")
        private final List<String> machineConsoleUuidList;

        public RequestBodyData(List<String> machineConsoleUuidList) {
            Intrinsics.checkNotNullParameter(machineConsoleUuidList, "machineConsoleUuidList");
            this.machineConsoleUuidList = machineConsoleUuidList;
        }

        public final List<String> getMachineConsoleUuidList() {
            return this.machineConsoleUuidList;
        }
    }
}
