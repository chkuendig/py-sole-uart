package com.soletreadmills.sole_v2._data.ble;

import com.soletreadmills.sole_v2._type.ConnectProgramNameType;
import com.soletreadmills.sole_v2._type.ConnectProgramSettingsType;
import com.soletreadmills.sole_v2._type.ConnectProgramType;
import com.soletreadmills.sole_v2.ble.type.BleFtmsMachineType;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: ConnectProgramData.kt */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0018\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0087\b\u0018\u0000 )2\u00020\u0001:\u0001)BI\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b\u0012\u0006\u0010\u000e\u001a\u00020\u000f¢\u0006\u0002\u0010\u0010J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0005HÆ\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\t0\bHÆ\u0003J\t\u0010 \u001a\u00020\u000bHÆ\u0003J\u000f\u0010!\u001a\b\u0012\u0004\u0012\u00020\r0\bHÆ\u0003J\t\u0010\"\u001a\u00020\u000fHÆ\u0003J[\u0010#\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b2\b\b\u0002\u0010\u000e\u001a\u00020\u000fHÆ\u0001J\u0013\u0010$\u001a\u00020\u000f2\b\u0010%\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010&\u001a\u00020\u0005HÖ\u0001J\t\u0010'\u001a\u00020(HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u0018R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\r0\b¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0016R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001b¨\u0006*"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/ble/ConnectProgramData;", "", "connectProgramNameType", "Lcom/soletreadmills/sole_v2/_type/ConnectProgramNameType;", "desc", "", "icon", "equipment", "", "Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "type", "Lcom/soletreadmills/sole_v2/_type/ConnectProgramType;", "settings", "Lcom/soletreadmills/sole_v2/_type/ConnectProgramSettingsType;", "isFavorites", "", "(Lcom/soletreadmills/sole_v2/_type/ConnectProgramNameType;IILjava/util/List;Lcom/soletreadmills/sole_v2/_type/ConnectProgramType;Ljava/util/List;Z)V", "getConnectProgramNameType", "()Lcom/soletreadmills/sole_v2/_type/ConnectProgramNameType;", "getDesc", "()I", "getEquipment", "()Ljava/util/List;", "getIcon", "()Z", "getSettings", "getType", "()Lcom/soletreadmills/sole_v2/_type/ConnectProgramType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "toString", "", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class ConnectProgramData {
    private static final List<ConnectProgramData> allProgramDataList;
    private final ConnectProgramNameType connectProgramNameType;
    private final int desc;
    private final List<BleFtmsMachineType> equipment;
    private final int icon;
    private final boolean isFavorites;
    private final List<ConnectProgramSettingsType> settings;
    private final ConnectProgramType type;

    /* renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    public static final int $stable = 8;

    public static /* synthetic */ ConnectProgramData copy$default(ConnectProgramData connectProgramData, ConnectProgramNameType connectProgramNameType, int i, int i2, List list, ConnectProgramType connectProgramType, List list2, boolean z, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            connectProgramNameType = connectProgramData.connectProgramNameType;
        }
        if ((i3 & 2) != 0) {
            i = connectProgramData.desc;
        }
        int i4 = i;
        if ((i3 & 4) != 0) {
            i2 = connectProgramData.icon;
        }
        int i5 = i2;
        if ((i3 & 8) != 0) {
            list = connectProgramData.equipment;
        }
        List list3 = list;
        if ((i3 & 16) != 0) {
            connectProgramType = connectProgramData.type;
        }
        ConnectProgramType connectProgramType2 = connectProgramType;
        if ((i3 & 32) != 0) {
            list2 = connectProgramData.settings;
        }
        List list4 = list2;
        if ((i3 & 64) != 0) {
            z = connectProgramData.isFavorites;
        }
        return connectProgramData.copy(connectProgramNameType, i4, i5, list3, connectProgramType2, list4, z);
    }

    /* renamed from: component1, reason: from getter */
    public final ConnectProgramNameType getConnectProgramNameType() {
        return this.connectProgramNameType;
    }

    /* renamed from: component2, reason: from getter */
    public final int getDesc() {
        return this.desc;
    }

    /* renamed from: component3, reason: from getter */
    public final int getIcon() {
        return this.icon;
    }

    public final List<BleFtmsMachineType> component4() {
        return this.equipment;
    }

    /* renamed from: component5, reason: from getter */
    public final ConnectProgramType getType() {
        return this.type;
    }

    public final List<ConnectProgramSettingsType> component6() {
        return this.settings;
    }

    /* renamed from: component7, reason: from getter */
    public final boolean getIsFavorites() {
        return this.isFavorites;
    }

    public final ConnectProgramData copy(ConnectProgramNameType connectProgramNameType, int desc, int icon, List<? extends BleFtmsMachineType> equipment, ConnectProgramType type, List<? extends ConnectProgramSettingsType> settings, boolean isFavorites) {
        Intrinsics.checkNotNullParameter(connectProgramNameType, "connectProgramNameType");
        Intrinsics.checkNotNullParameter(equipment, "equipment");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(settings, "settings");
        return new ConnectProgramData(connectProgramNameType, desc, icon, equipment, type, settings, isFavorites);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ConnectProgramData)) {
            return false;
        }
        ConnectProgramData connectProgramData = (ConnectProgramData) other;
        return this.connectProgramNameType == connectProgramData.connectProgramNameType && this.desc == connectProgramData.desc && this.icon == connectProgramData.icon && Intrinsics.areEqual(this.equipment, connectProgramData.equipment) && this.type == connectProgramData.type && Intrinsics.areEqual(this.settings, connectProgramData.settings) && this.isFavorites == connectProgramData.isFavorites;
    }

    public int hashCode() {
        return (((((((((((this.connectProgramNameType.hashCode() * 31) + Integer.hashCode(this.desc)) * 31) + Integer.hashCode(this.icon)) * 31) + this.equipment.hashCode()) * 31) + this.type.hashCode()) * 31) + this.settings.hashCode()) * 31) + Boolean.hashCode(this.isFavorites);
    }

    public String toString() {
        return "ConnectProgramData(connectProgramNameType=" + this.connectProgramNameType + ", desc=" + this.desc + ", icon=" + this.icon + ", equipment=" + this.equipment + ", type=" + this.type + ", settings=" + this.settings + ", isFavorites=" + this.isFavorites + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ConnectProgramData(ConnectProgramNameType connectProgramNameType, int i, int i2, List<? extends BleFtmsMachineType> equipment, ConnectProgramType type, List<? extends ConnectProgramSettingsType> settings, boolean z) {
        Intrinsics.checkNotNullParameter(connectProgramNameType, "connectProgramNameType");
        Intrinsics.checkNotNullParameter(equipment, "equipment");
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(settings, "settings");
        this.connectProgramNameType = connectProgramNameType;
        this.desc = i;
        this.icon = i2;
        this.equipment = equipment;
        this.type = type;
        this.settings = settings;
        this.isFavorites = z;
    }

    public final ConnectProgramNameType getConnectProgramNameType() {
        return this.connectProgramNameType;
    }

    public final int getDesc() {
        return this.desc;
    }

    public final int getIcon() {
        return this.icon;
    }

    public final List<BleFtmsMachineType> getEquipment() {
        return this.equipment;
    }

    public final ConnectProgramType getType() {
        return this.type;
    }

    public final List<ConnectProgramSettingsType> getSettings() {
        return this.settings;
    }

    public final boolean isFavorites() {
        return this.isFavorites;
    }

    /* compiled from: ConnectProgramData.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\t\u001a\u00020\nJ\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\u0006\u0010\f\u001a\u00020\rR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u000e"}, d2 = {"Lcom/soletreadmills/sole_v2/_data/ble/ConnectProgramData$Companion;", "", "()V", "allProgramDataList", "", "Lcom/soletreadmills/sole_v2/_data/ble/ConnectProgramData;", "getAllProgramDataList", "()Ljava/util/List;", "createData", "connectProgramNameType", "Lcom/soletreadmills/sole_v2/_type/ConnectProgramNameType;", "filteredDataList", "deviceType", "Lcom/soletreadmills/sole_v2/ble/type/BleFtmsMachineType;", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final List<ConnectProgramData> getAllProgramDataList() {
            return ConnectProgramData.allProgramDataList;
        }

        public final List<ConnectProgramData> filteredDataList(BleFtmsMachineType deviceType) {
            Intrinsics.checkNotNullParameter(deviceType, "deviceType");
            List<ConnectProgramData> allProgramDataList = getAllProgramDataList();
            ArrayList arrayList = new ArrayList();
            for (Object obj : allProgramDataList) {
                if (((ConnectProgramData) obj).getEquipment().contains(deviceType)) {
                    arrayList.add(obj);
                }
            }
            return arrayList;
        }

        public final List<ConnectProgramData> createData(ConnectProgramNameType connectProgramNameType) {
            Intrinsics.checkNotNullParameter(connectProgramNameType, "connectProgramNameType");
            return CollectionsKt.listOf(new ConnectProgramData(connectProgramNameType, connectProgramNameType.getDescRes(), connectProgramNameType.getDefaultIcon(), CollectionsKt.toList(connectProgramNameType.getEquipmentSettingsMap().keySet()), connectProgramNameType.getType(), CollectionsKt.flatten(connectProgramNameType.getEquipmentSettingsMap().values()), false));
        }
    }

    static {
        ConnectProgramNameType[] connectProgramNameTypeArrValues = ConnectProgramNameType.values();
        ArrayList arrayList = new ArrayList();
        for (ConnectProgramNameType connectProgramNameType : connectProgramNameTypeArrValues) {
            CollectionsKt.addAll(arrayList, INSTANCE.createData(connectProgramNameType));
        }
        allProgramDataList = arrayList;
    }
}
