package com.soletreadmills.sole_v2._data.ble;

import android.bluetooth.le.ScanResult;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BleDeviceData.kt */
@Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B1\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0006HÆ\u0003J\t\u0010\u001b\u001a\u00020\bHÆ\u0003J7\u0010\u001c\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\b\u0002\u0010\u0007\u001a\u00020\bHÆ\u0001J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010 \u001a\u00020\bHÖ\u0001J\t\u0010!\u001a\u00020\u0003HÖ\u0001R\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u000f\"\u0004\b\u0013\u0010\u0011R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017¨\u0006\""}, d2 = {"Lcom/soletreadmills/sole_v2/_data/ble/BleDeviceData;", "", "deviceMac", "", "deviceName", "scanResult", "Landroid/bluetooth/le/ScanResult;", "connectionState", "", "(Ljava/lang/String;Ljava/lang/String;Landroid/bluetooth/le/ScanResult;I)V", "getConnectionState", "()I", "setConnectionState", "(I)V", "getDeviceMac", "()Ljava/lang/String;", "setDeviceMac", "(Ljava/lang/String;)V", "getDeviceName", "setDeviceName", "getScanResult", "()Landroid/bluetooth/le/ScanResult;", "setScanResult", "(Landroid/bluetooth/le/ScanResult;)V", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public final /* data */ class BleDeviceData {
    public static final int $stable = 8;
    private int connectionState;
    private String deviceMac;
    private String deviceName;
    private ScanResult scanResult;

    public static /* synthetic */ BleDeviceData copy$default(BleDeviceData bleDeviceData, String str, String str2, ScanResult scanResult, int i, int i2, Object obj) {
        if ((i2 & 1) != 0) {
            str = bleDeviceData.deviceMac;
        }
        if ((i2 & 2) != 0) {
            str2 = bleDeviceData.deviceName;
        }
        if ((i2 & 4) != 0) {
            scanResult = bleDeviceData.scanResult;
        }
        if ((i2 & 8) != 0) {
            i = bleDeviceData.connectionState;
        }
        return bleDeviceData.copy(str, str2, scanResult, i);
    }

    /* renamed from: component1, reason: from getter */
    public final String getDeviceMac() {
        return this.deviceMac;
    }

    /* renamed from: component2, reason: from getter */
    public final String getDeviceName() {
        return this.deviceName;
    }

    /* renamed from: component3, reason: from getter */
    public final ScanResult getScanResult() {
        return this.scanResult;
    }

    /* renamed from: component4, reason: from getter */
    public final int getConnectionState() {
        return this.connectionState;
    }

    public final BleDeviceData copy(String deviceMac, String deviceName, ScanResult scanResult, int connectionState) {
        return new BleDeviceData(deviceMac, deviceName, scanResult, connectionState);
    }

    public boolean equals(Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof BleDeviceData)) {
            return false;
        }
        BleDeviceData bleDeviceData = (BleDeviceData) other;
        return Intrinsics.areEqual(this.deviceMac, bleDeviceData.deviceMac) && Intrinsics.areEqual(this.deviceName, bleDeviceData.deviceName) && Intrinsics.areEqual(this.scanResult, bleDeviceData.scanResult) && this.connectionState == bleDeviceData.connectionState;
    }

    public int hashCode() {
        String str = this.deviceMac;
        int iHashCode = (str == null ? 0 : str.hashCode()) * 31;
        String str2 = this.deviceName;
        int iHashCode2 = (iHashCode + (str2 == null ? 0 : str2.hashCode())) * 31;
        ScanResult scanResult = this.scanResult;
        return ((iHashCode2 + (scanResult != null ? scanResult.hashCode() : 0)) * 31) + Integer.hashCode(this.connectionState);
    }

    public String toString() {
        return "BleDeviceData(deviceMac=" + this.deviceMac + ", deviceName=" + this.deviceName + ", scanResult=" + this.scanResult + ", connectionState=" + this.connectionState + ')';
    }

    public BleDeviceData(String str, String str2, ScanResult scanResult, int i) {
        this.deviceMac = str;
        this.deviceName = str2;
        this.scanResult = scanResult;
        this.connectionState = i;
    }

    public /* synthetic */ BleDeviceData(String str, String str2, ScanResult scanResult, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this((i2 & 1) != 0 ? null : str, (i2 & 2) != 0 ? null : str2, scanResult, (i2 & 8) != 0 ? 0 : i);
    }

    public final String getDeviceMac() {
        return this.deviceMac;
    }

    public final void setDeviceMac(String str) {
        this.deviceMac = str;
    }

    public final String getDeviceName() {
        return this.deviceName;
    }

    public final void setDeviceName(String str) {
        this.deviceName = str;
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
}
