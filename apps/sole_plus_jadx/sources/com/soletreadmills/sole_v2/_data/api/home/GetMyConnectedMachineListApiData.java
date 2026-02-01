package com.soletreadmills.sole_v2._data.api.home;

import com.google.gson.annotations.SerializedName;
import com.soletreadmills.sole_v2._data._base.WebApiBaseData;
import com.soletreadmills.sole_v2._type.CategoryType;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: GetMyConnectedMachineListApiData.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001:\u0003\u0003\u0004\u0005B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/home/GetMyConnectedMachineListApiData;", "", "()V", "ConnectedMachineData", com.google.android.gms.wearable.DataMap.TAG, "ResponseData", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class GetMyConnectedMachineListApiData {
    public static final int $stable = 0;

    /* compiled from: GetMyConnectedMachineListApiData.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/home/GetMyConnectedMachineListApiData$ResponseData;", "Lcom/soletreadmills/sole_v2/_data/_base/WebApiBaseData;", "()V", "dataMap", "Lcom/soletreadmills/sole_v2/_data/api/home/GetMyConnectedMachineListApiData$DataMap;", "getDataMap", "()Lcom/soletreadmills/sole_v2/_data/api/home/GetMyConnectedMachineListApiData$DataMap;", "setDataMap", "(Lcom/soletreadmills/sole_v2/_data/api/home/GetMyConnectedMachineListApiData$DataMap;)V", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class ResponseData extends WebApiBaseData {
        public static final int $stable = 8;

        @SerializedName("dataMap")
        private DataMap dataMap;

        public final DataMap getDataMap() {
            return this.dataMap;
        }

        public final void setDataMap(DataMap dataMap) {
            this.dataMap = dataMap;
        }
    }

    /* compiled from: GetMyConnectedMachineListApiData.kt */
    @Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0017\u0012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0005J\u0011\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0003J\u001b\u0010\t\u001a\u00020\u00002\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\r\u001a\u00020\u000eHÖ\u0001J\t\u0010\u000f\u001a\u00020\u0010HÖ\u0001R\u001e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0011"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/home/GetMyConnectedMachineListApiData$DataMap;", "", "data", "", "Lcom/soletreadmills/sole_v2/_data/api/home/GetMyConnectedMachineListApiData$ConnectedMachineData;", "(Ljava/util/List;)V", "getData", "()Ljava/util/List;", "component1", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class DataMap {
        public static final int $stable = 8;

        @SerializedName("data")
        private final List<ConnectedMachineData> data;

        /* JADX WARN: Multi-variable type inference failed */
        public DataMap() {
            this(null, 1, 0 == true ? 1 : 0);
        }

        /* JADX WARN: Multi-variable type inference failed */
        public static /* synthetic */ DataMap copy$default(DataMap dataMap, List list, int i, Object obj) {
            if ((i & 1) != 0) {
                list = dataMap.data;
            }
            return dataMap.copy(list);
        }

        public final List<ConnectedMachineData> component1() {
            return this.data;
        }

        public final DataMap copy(List<ConnectedMachineData> data) {
            return new DataMap(data);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            return (other instanceof DataMap) && Intrinsics.areEqual(this.data, ((DataMap) other).data);
        }

        public int hashCode() {
            List<ConnectedMachineData> list = this.data;
            if (list == null) {
                return 0;
            }
            return list.hashCode();
        }

        public String toString() {
            return "DataMap(data=" + this.data + ')';
        }

        public DataMap(List<ConnectedMachineData> list) {
            this.data = list;
        }

        public /* synthetic */ DataMap(List list, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this((i & 1) != 0 ? null : list);
        }

        public final List<ConnectedMachineData> getData() {
            return this.data;
        }
    }

    /* compiled from: GetMyConnectedMachineListApiData.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B/\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0013J\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u0005HÂ\u0003¢\u0006\u0002\u0010\u0013J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J>\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010!\u001a\u00020\u0005HÖ\u0001J\t\u0010\"\u001a\u00020\u0003HÖ\u0001R\u0014\u0010\u0006\u001a\u0004\u0018\u00010\u00058\u0002X\u0083\u0004¢\u0006\u0004\n\u0002\u0010\tR\u0011\u0010\n\u001a\u00020\u000b8F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006#"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/api/home/GetMyConnectedMachineListApiData$ConnectedMachineData;", "", "machineConsoleUuid", "", "machineModelId", "", "_machineCategoryType", "machineModelName", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)V", "Ljava/lang/Integer;", "machineCategoryType", "Lcom/soletreadmills/sole_v2/_type/CategoryType;", "getMachineCategoryType", "()Lcom/soletreadmills/sole_v2/_type/CategoryType;", "getMachineConsoleUuid", "()Ljava/lang/String;", "setMachineConsoleUuid", "(Ljava/lang/String;)V", "getMachineModelId", "()Ljava/lang/Integer;", "setMachineModelId", "(Ljava/lang/Integer;)V", "getMachineModelName", "setMachineModelName", "component1", "component2", "component3", "component4", "copy", "(Ljava/lang/String;Ljava/lang/Integer;Ljava/lang/Integer;Ljava/lang/String;)Lcom/soletreadmills/sole_v2/_data/api/home/GetMyConnectedMachineListApiData$ConnectedMachineData;", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final /* data */ class ConnectedMachineData {
        public static final int $stable = 8;

        @SerializedName("machineCategoryType")
        private final Integer _machineCategoryType;
        private String machineConsoleUuid;
        private Integer machineModelId;
        private String machineModelName;

        /* renamed from: component3, reason: from getter */
        private final Integer get_machineCategoryType() {
            return this._machineCategoryType;
        }

        public static /* synthetic */ ConnectedMachineData copy$default(ConnectedMachineData connectedMachineData, String str, Integer num, Integer num2, String str2, int i, Object obj) {
            if ((i & 1) != 0) {
                str = connectedMachineData.machineConsoleUuid;
            }
            if ((i & 2) != 0) {
                num = connectedMachineData.machineModelId;
            }
            if ((i & 4) != 0) {
                num2 = connectedMachineData._machineCategoryType;
            }
            if ((i & 8) != 0) {
                str2 = connectedMachineData.machineModelName;
            }
            return connectedMachineData.copy(str, num, num2, str2);
        }

        /* renamed from: component1, reason: from getter */
        public final String getMachineConsoleUuid() {
            return this.machineConsoleUuid;
        }

        /* renamed from: component2, reason: from getter */
        public final Integer getMachineModelId() {
            return this.machineModelId;
        }

        /* renamed from: component4, reason: from getter */
        public final String getMachineModelName() {
            return this.machineModelName;
        }

        public final ConnectedMachineData copy(String machineConsoleUuid, Integer machineModelId, Integer _machineCategoryType, String machineModelName) {
            return new ConnectedMachineData(machineConsoleUuid, machineModelId, _machineCategoryType, machineModelName);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof ConnectedMachineData)) {
                return false;
            }
            ConnectedMachineData connectedMachineData = (ConnectedMachineData) other;
            return Intrinsics.areEqual(this.machineConsoleUuid, connectedMachineData.machineConsoleUuid) && Intrinsics.areEqual(this.machineModelId, connectedMachineData.machineModelId) && Intrinsics.areEqual(this._machineCategoryType, connectedMachineData._machineCategoryType) && Intrinsics.areEqual(this.machineModelName, connectedMachineData.machineModelName);
        }

        public int hashCode() {
            String str = this.machineConsoleUuid;
            int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
            Integer num = this.machineModelId;
            int iHashCode2 = (iHashCode + (num == null ? 0 : num.hashCode())) * 31;
            Integer num2 = this._machineCategoryType;
            int iHashCode3 = (iHashCode2 + (num2 == null ? 0 : num2.hashCode())) * 31;
            String str2 = this.machineModelName;
            return iHashCode3 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "ConnectedMachineData(machineConsoleUuid=" + this.machineConsoleUuid + ", machineModelId=" + this.machineModelId + ", _machineCategoryType=" + this._machineCategoryType + ", machineModelName=" + this.machineModelName + ')';
        }

        public ConnectedMachineData(String str, Integer num, Integer num2, String str2) {
            this.machineConsoleUuid = str;
            this.machineModelId = num;
            this._machineCategoryType = num2;
            this.machineModelName = str2;
        }

        public /* synthetic */ ConnectedMachineData(String str, Integer num, Integer num2, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, num, (i & 4) != 0 ? null : num2, str2);
        }

        public final String getMachineConsoleUuid() {
            return this.machineConsoleUuid;
        }

        public final void setMachineConsoleUuid(String str) {
            this.machineConsoleUuid = str;
        }

        public final Integer getMachineModelId() {
            return this.machineModelId;
        }

        public final void setMachineModelId(Integer num) {
            this.machineModelId = num;
        }

        public final String getMachineModelName() {
            return this.machineModelName;
        }

        public final void setMachineModelName(String str) {
            this.machineModelName = str;
        }

        public final CategoryType getMachineCategoryType() {
            Integer num = this._machineCategoryType;
            if (num != null) {
                CategoryType categoryTypeFromCode = CategoryType.INSTANCE.fromCode(num.intValue());
                if (categoryTypeFromCode != null) {
                    return categoryTypeFromCode;
                }
            }
            return CategoryType.UNDEFINED;
        }
    }
}
