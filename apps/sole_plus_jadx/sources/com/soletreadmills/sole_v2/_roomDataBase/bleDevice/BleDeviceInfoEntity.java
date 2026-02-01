package com.soletreadmills.sole_v2._roomDataBase.bleDevice;

import com.facebook.appevents.integrity.IntegrityManager;
import com.soletreadmills.sole_v2._type.MachineType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BleDeviceInfoEntity.kt */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0087\b\u0018\u0000  2\u00020\u0001:\u0001 B7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0012\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\bHÆ\u0003J?\u0010\u0017\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u0018\u001a\u00020\b2\b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bJ\t\u0010\u001c\u001a\u00020\u001dHÖ\u0001J\u0010\u0010\u0010\u001a\u00020\u001e2\b\u0010\u0006\u001a\u0004\u0018\u00010\u001bJ\t\u0010\u001f\u001a\u00020\u0003HÖ\u0001R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\u000eR \u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u000b\"\u0004\b\u0010\u0010\u0011¨\u0006!"}, d2 = {"Lcom/soletreadmills/sole_v2/_roomDataBase/bleDevice/BleDeviceInfoEntity;", "", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "", "bleName", "accountNo", "machineType", "isHasAdv0x16", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getAccountNo", "()Ljava/lang/String;", "getAddress", "getBleName", "()Z", "getMachineType", "setMachineType", "(Ljava/lang/String;)V", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "other", "getMachineType02", "Lcom/soletreadmills/sole_v2/_type/MachineType;", "hashCode", "", "", "toString", "Companion", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BleDeviceInfoEntity {
    public static final String BLE_DEVICE_INFO_TABLE = "BLE_DEVICE_INFO_TABLE";
    private final String accountNo;
    private final String address;
    private final String bleName;
    private final boolean isHasAdv0x16;
    private String machineType;
    public static final int $stable = 8;

    public static /* synthetic */ BleDeviceInfoEntity copy$default(BleDeviceInfoEntity bleDeviceInfoEntity, String str, String str2, String str3, String str4, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = bleDeviceInfoEntity.address;
        }
        if ((i & 2) != 0) {
            str2 = bleDeviceInfoEntity.bleName;
        }
        String str5 = str2;
        if ((i & 4) != 0) {
            str3 = bleDeviceInfoEntity.accountNo;
        }
        String str6 = str3;
        if ((i & 8) != 0) {
            str4 = bleDeviceInfoEntity.machineType;
        }
        String str7 = str4;
        if ((i & 16) != 0) {
            z = bleDeviceInfoEntity.isHasAdv0x16;
        }
        return bleDeviceInfoEntity.copy(str, str5, str6, str7, z);
    }

    /* renamed from: component1, reason: from getter */
    public final String getAddress() {
        return this.address;
    }

    /* renamed from: component2, reason: from getter */
    public final String getBleName() {
        return this.bleName;
    }

    /* renamed from: component3, reason: from getter */
    public final String getAccountNo() {
        return this.accountNo;
    }

    /* renamed from: component4, reason: from getter */
    public final String getMachineType() {
        return this.machineType;
    }

    /* renamed from: component5, reason: from getter */
    public final boolean getIsHasAdv0x16() {
        return this.isHasAdv0x16;
    }

    public final BleDeviceInfoEntity copy(String address, String bleName, String accountNo, String machineType, boolean isHasAdv0x16) {
        Intrinsics.checkNotNullParameter(bleName, "bleName");
        Intrinsics.checkNotNullParameter(accountNo, "accountNo");
        return new BleDeviceInfoEntity(address, bleName, accountNo, machineType, isHasAdv0x16);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BleDeviceInfoEntity)) {
            return false;
        }
        BleDeviceInfoEntity bleDeviceInfoEntity = (BleDeviceInfoEntity) other;
        return Intrinsics.areEqual(this.address, bleDeviceInfoEntity.address) && Intrinsics.areEqual(this.bleName, bleDeviceInfoEntity.bleName) && Intrinsics.areEqual(this.accountNo, bleDeviceInfoEntity.accountNo) && Intrinsics.areEqual(this.machineType, bleDeviceInfoEntity.machineType) && this.isHasAdv0x16 == bleDeviceInfoEntity.isHasAdv0x16;
    }

    public int hashCode() {
        String str = this.address;
        int iHashCode = (((((str == null ? 0 : str.hashCode()) * 31) + this.bleName.hashCode()) * 31) + this.accountNo.hashCode()) * 31;
        String str2 = this.machineType;
        return ((iHashCode + (str2 != null ? str2.hashCode() : 0)) * 31) + Boolean.hashCode(this.isHasAdv0x16);
    }

    public String toString() {
        return "BleDeviceInfoEntity(address=" + this.address + ", bleName=" + this.bleName + ", accountNo=" + this.accountNo + ", machineType=" + this.machineType + ", isHasAdv0x16=" + this.isHasAdv0x16 + ')';
    }

    public BleDeviceInfoEntity(String str, String bleName, String accountNo, String str2, boolean z) {
        Intrinsics.checkNotNullParameter(bleName, "bleName");
        Intrinsics.checkNotNullParameter(accountNo, "accountNo");
        this.address = str;
        this.bleName = bleName;
        this.accountNo = accountNo;
        this.machineType = str2;
        this.isHasAdv0x16 = z;
    }

    public final String getAddress() {
        return this.address;
    }

    public final String getBleName() {
        return this.bleName;
    }

    public /* synthetic */ BleDeviceInfoEntity(String str, String str2, String str3, String str4, boolean z, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, str2, (i & 4) != 0 ? "" : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? false : z);
    }

    public final String getAccountNo() {
        return this.accountNo;
    }

    public final String getMachineType() {
        return this.machineType;
    }

    public final void setMachineType(String str) {
        this.machineType = str;
    }

    public final boolean isHasAdv0x16() {
        return this.isHasAdv0x16;
    }

    public final void setMachineType(MachineType machineType) {
        String apiCatalogType;
        if (machineType == null || (apiCatalogType = machineType.getApiCatalogType()) == null) {
            apiCatalogType = "";
        }
        if (apiCatalogType.length() == 0 || Intrinsics.areEqual(apiCatalogType, "99")) {
            apiCatalogType = null;
        }
        this.machineType = apiCatalogType;
    }

    public final MachineType getMachineType02() {
        return MachineType.INSTANCE.fromApiCatalogType(this.machineType);
    }
}
