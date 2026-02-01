package com.soletreadmills.sole_v2._data.ble;

import android.bluetooth.le.ScanResult;
import com.facebook.appevents.integrity.IntegrityManager;
import com.soletreadmills.sole_v2._type.BleDeviceListType;
import com.soletreadmills.sole_v2._type.MachineType;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: BleDeviceInfoData.kt */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u001a\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u001b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\b\u0010;\u001a\u00020\u0000H\u0016J\b\u0010<\u001a\u00020\u0003H\u0016R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\u0012\u001a\u00020\u0013X\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u0015\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0005\u0010\u001aR\u001a\u0010\u001c\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\u001d\"\u0004\b\u001e\u0010\u001fR\u001a\u0010 \u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u001d\"\u0004\b!\u0010\u001fR\u001a\u0010\"\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001d\"\u0004\b#\u0010\u001fR\u001e\u0010$\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001b\u001a\u0004\b$\u0010\u001a\"\u0004\b%\u0010&R\u001a\u0010'\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010\u001d\"\u0004\b(\u0010\u001fR\u001a\u0010)\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001d\"\u0004\b*\u0010\u001fR\u001c\u0010+\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\t\"\u0004\b-\u0010\u000bR\u001c\u0010.\u001a\u0004\u0018\u00010/X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b4\u0010\tR\u001c\u00105\u001a\u0004\u0018\u000106X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b7\u00108\"\u0004\b9\u0010:¨\u0006="}, d2 = {"Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceInfoData;", "", "name", "", IntegrityManager.INTEGRITY_TYPE_ADDRESS, "is0x16", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Boolean;)V", "getAddress", "()Ljava/lang/String;", "setAddress", "(Ljava/lang/String;)V", "bleDeviceListType", "Lcom/soletreadmills/sole_v2/_type/BleDeviceListType;", "getBleDeviceListType", "()Lcom/soletreadmills/sole_v2/_type/BleDeviceListType;", "setBleDeviceListType", "(Lcom/soletreadmills/sole_v2/_type/BleDeviceListType;)V", "connectionState", "", "getConnectionState$annotations", "()V", "getConnectionState", "()I", "setConnectionState", "(I)V", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "isEdit", "()Z", "setEdit", "(Z)V", "isFtmsSimulationMachine", "setFtmsSimulationMachine", "isHasAdv0x16", "setHasAdv0x16", "isNewMachine", "setNewMachine", "(Ljava/lang/Boolean;)V", "isSelect", "setSelect", "isUserSync", "setUserSync", "machineConsoleUuid", "getMachineConsoleUuid", "setMachineConsoleUuid", "machineType", "Lcom/soletreadmills/sole_v2/_type/MachineType;", "getMachineType", "()Lcom/soletreadmills/sole_v2/_type/MachineType;", "setMachineType", "(Lcom/soletreadmills/sole_v2/_type/MachineType;)V", "getName", "scanResult", "Landroid/bluetooth/le/ScanResult;", "getScanResult", "()Landroid/bluetooth/le/ScanResult;", "setScanResult", "(Landroid/bluetooth/le/ScanResult;)V", "clone", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final class BleDeviceInfoData implements Cloneable {
    public static final int $stable = 8;
    private String address;
    private BleDeviceListType bleDeviceListType;
    private int connectionState;
    private final Boolean is0x16;
    private boolean isEdit;
    private boolean isFtmsSimulationMachine;
    private boolean isHasAdv0x16;
    private Boolean isNewMachine;
    private boolean isSelect;
    private boolean isUserSync;
    private String machineConsoleUuid;
    private MachineType machineType;
    private final String name;
    private ScanResult scanResult;

    public static /* synthetic */ void getConnectionState$annotations() {
    }

    public BleDeviceInfoData(String name, String str, Boolean bool) {
        Intrinsics.checkNotNullParameter(name, "name");
        this.name = name;
        this.address = str;
        this.is0x16 = bool;
        this.bleDeviceListType = BleDeviceListType.OTHER_DEVICES;
    }

    public /* synthetic */ BleDeviceInfoData(String str, String str2, Boolean bool, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : bool);
    }

    public final String getName() {
        return this.name;
    }

    public final String getAddress() {
        return this.address;
    }

    public final void setAddress(String str) {
        this.address = str;
    }

    /* renamed from: is0x16, reason: from getter */
    public final Boolean getIs0x16() {
        return this.is0x16;
    }

    public final ScanResult getScanResult() {
        return this.scanResult;
    }

    public final void setScanResult(ScanResult scanResult) {
        this.scanResult = scanResult;
    }

    public final int getConnectionState() {
        return this.connectionState;
    }

    public final void setConnectionState(int i) {
        this.connectionState = i;
    }

    public final MachineType getMachineType() {
        return this.machineType;
    }

    public final void setMachineType(MachineType machineType) {
        this.machineType = machineType;
    }

    /* renamed from: isNewMachine, reason: from getter */
    public final Boolean getIsNewMachine() {
        return this.isNewMachine;
    }

    public final void setNewMachine(Boolean bool) {
        this.isNewMachine = bool;
    }

    public final BleDeviceListType getBleDeviceListType() {
        return this.bleDeviceListType;
    }

    public final void setBleDeviceListType(BleDeviceListType bleDeviceListType) {
        Intrinsics.checkNotNullParameter(bleDeviceListType, "<set-?>");
        this.bleDeviceListType = bleDeviceListType;
    }

    /* renamed from: isFtmsSimulationMachine, reason: from getter */
    public final boolean getIsFtmsSimulationMachine() {
        return this.isFtmsSimulationMachine;
    }

    public final void setFtmsSimulationMachine(boolean z) {
        this.isFtmsSimulationMachine = z;
    }

    /* renamed from: isHasAdv0x16, reason: from getter */
    public final boolean getIsHasAdv0x16() {
        return this.isHasAdv0x16;
    }

    public final void setHasAdv0x16(boolean z) {
        this.isHasAdv0x16 = z;
    }

    /* renamed from: isUserSync, reason: from getter */
    public final boolean getIsUserSync() {
        return this.isUserSync;
    }

    public final void setUserSync(boolean z) {
        this.isUserSync = z;
    }

    public final String getMachineConsoleUuid() {
        return this.machineConsoleUuid;
    }

    public final void setMachineConsoleUuid(String str) {
        this.machineConsoleUuid = str;
    }

    /* renamed from: isEdit, reason: from getter */
    public final boolean getIsEdit() {
        return this.isEdit;
    }

    public final void setEdit(boolean z) {
        this.isEdit = z;
    }

    /* renamed from: isSelect, reason: from getter */
    public final boolean getIsSelect() {
        return this.isSelect;
    }

    public final void setSelect(boolean z) {
        this.isSelect = z;
    }

    public String toString() {
        return "BleDeviceInfoData{scanResult=" + this.scanResult + ", name='" + this.name + "', address='" + this.address + "', connectionState=" + this.connectionState + ", machineType=" + this.machineType + ", isNewMachine=" + this.isNewMachine + ", bleDeviceListType=" + this.bleDeviceListType + ", isFtmsSimulationMachine=" + this.isFtmsSimulationMachine + ", isHasAdv0x16=" + this.isHasAdv0x16 + ", machineConsoleUuid=" + this.machineConsoleUuid + AbstractJsonLexerKt.END_OBJ;
    }

    /* renamed from: clone, reason: merged with bridge method [inline-methods] */
    public BleDeviceInfoData m8608clone() throws CloneNotSupportedException {
        BleDeviceInfoData bleDeviceInfoData;
        try {
            Object objClone = super.clone();
            Intrinsics.checkNotNull(objClone, "null cannot be cast to non-null type com.soletreadmills.sole_v2._data.ble.BleDeviceInfoData");
            bleDeviceInfoData = (BleDeviceInfoData) objClone;
        } catch (Exception e) {
            e.printStackTrace();
            bleDeviceInfoData = null;
        }
        if (bleDeviceInfoData == null) {
            bleDeviceInfoData = new BleDeviceInfoData(this.name, this.address, this.is0x16);
        }
        bleDeviceInfoData.connectionState = this.connectionState;
        bleDeviceInfoData.machineType = this.machineType;
        bleDeviceInfoData.isNewMachine = this.isNewMachine;
        bleDeviceInfoData.bleDeviceListType = this.bleDeviceListType;
        bleDeviceInfoData.isFtmsSimulationMachine = this.isFtmsSimulationMachine;
        bleDeviceInfoData.isHasAdv0x16 = this.isHasAdv0x16;
        Boolean bool = this.is0x16;
        if (bool != null) {
            bleDeviceInfoData.isHasAdv0x16 = bool.booleanValue();
        }
        bleDeviceInfoData.isUserSync = this.isUserSync;
        bleDeviceInfoData.isEdit = this.isEdit;
        bleDeviceInfoData.isSelect = this.isSelect;
        bleDeviceInfoData.machineConsoleUuid = this.machineConsoleUuid;
        return bleDeviceInfoData;
    }
}
