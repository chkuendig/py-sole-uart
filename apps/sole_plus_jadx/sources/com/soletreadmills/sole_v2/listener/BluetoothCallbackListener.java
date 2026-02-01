package com.soletreadmills.sole_v2.listener;

import com.soletreadmills.sole_v2.ble.data.FitnessMachineControlPointResponseData;
import com.soletreadmills.sole_v2.ble.type.FitnessMachineStatusType;
import com.soletreadmills.sole_v2.ble.type.TrainingStatusType;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import no.nordicsemi.android.support.v18.scanner.ScanResult;

/* compiled from: BluetoothCallbackListener.kt */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001:\u0001!J\u0018\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\b\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0018\u0010\t\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u0012\u0010\n\u001a\u00020\u00032\b\u0010\u000b\u001a\u0004\u0018\u00010\fH&J\u0012\u0010\r\u001a\u00020\u00032\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH&J\u001c\u0010\u0010\u001a\u00020\u00032\b\u0010\u0011\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\u0013\u001a\u00020\u00032\b\u0010\u0014\u001a\u0004\u0018\u00010\u0007H&J\u001c\u0010\u0015\u001a\u00020\u00032\b\u0010\u0016\u001a\u0004\u0018\u00010\u00072\b\u0010\u0012\u001a\u0004\u0018\u00010\u0007H&J\u0012\u0010\u0017\u001a\u00020\u00032\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H&J\b\u0010\u001a\u001a\u00020\u0003H&J\u0018\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001fH&J\u0010\u0010 \u001a\u00020\u00032\u0006\u0010\u0006\u001a\u00020\u0007H&¨\u0006\""}, d2 = {"Lcom/soletreadmills/sole_v2/listener/BluetoothCallbackListener;", "", "onConnected", "", "deviceType", "Lcom/soletreadmills/sole_v2/listener/BluetoothCallbackListener$DeviceType;", "macAddress", "", "onConnecting", "onDisconnected", "onReceiveFitnessMachineControlPoint", "fitnessMachineControlPointResponseData", "Lcom/soletreadmills/sole_v2/ble/data/FitnessMachineControlPointResponseData;", "onReceiveFitnessMachineStatus", "fitnessMachineStatusType", "Lcom/soletreadmills/sole_v2/ble/type/FitnessMachineStatusType;", "onReceiveFtmsData", "ftmsData", "className", "onReceiveHrData", "hrDataJsonStr", "onReceiveSrvoData", "srvoData", "onReceiveTrainingStatus", "trainingStatusType", "Lcom/soletreadmills/sole_v2/ble/type/TrainingStatusType;", "onScan", "onScanResult", "callbackType", "", "scanResult", "Lno/nordicsemi/android/support/v18/scanner/ScanResult;", "onSrvoDeviceReady", "DeviceType", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes5.dex */
public interface BluetoothCallbackListener {
    void onConnected(DeviceType deviceType, String macAddress);

    void onConnecting(DeviceType deviceType, String macAddress);

    void onDisconnected(DeviceType deviceType, String macAddress);

    void onReceiveFitnessMachineControlPoint(FitnessMachineControlPointResponseData fitnessMachineControlPointResponseData);

    void onReceiveFitnessMachineStatus(FitnessMachineStatusType fitnessMachineStatusType);

    void onReceiveFtmsData(String ftmsData, String className);

    void onReceiveHrData(String hrDataJsonStr);

    void onReceiveSrvoData(String srvoData, String className);

    void onReceiveTrainingStatus(TrainingStatusType trainingStatusType);

    void onScan();

    void onScanResult(int callbackType, ScanResult scanResult);

    void onSrvoDeviceReady(String macAddress);

    /* JADX WARN: Failed to restore enum class, 'enum' modifier and super class removed */
    /* JADX WARN: Unknown enum class pattern. Please report as an issue! */
    /* compiled from: BluetoothCallbackListener.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/soletreadmills/sole_v2/listener/BluetoothCallbackListener$DeviceType;", "", "(Ljava/lang/String;I)V", "FTMS", "HR", "SRVO", "app_release"}, k = 1, mv = {1, 9, 0}, xi = 48)
    public static final class DeviceType {
        private static final /* synthetic */ EnumEntries $ENTRIES;
        private static final /* synthetic */ DeviceType[] $VALUES;
        public static final DeviceType FTMS = new DeviceType("FTMS", 0);
        public static final DeviceType HR = new DeviceType("HR", 1);
        public static final DeviceType SRVO = new DeviceType("SRVO", 2);

        private static final /* synthetic */ DeviceType[] $values() {
            return new DeviceType[]{FTMS, HR, SRVO};
        }

        public static EnumEntries<DeviceType> getEntries() {
            return $ENTRIES;
        }

        public static DeviceType valueOf(String str) {
            return (DeviceType) Enum.valueOf(DeviceType.class, str);
        }

        public static DeviceType[] values() {
            return (DeviceType[]) $VALUES.clone();
        }

        private DeviceType(String str, int i) {
        }

        static {
            DeviceType[] deviceTypeArr$values = $values();
            $VALUES = deviceTypeArr$values;
            $ENTRIES = EnumEntriesKt.enumEntries(deviceTypeArr$values);
        }
    }
}
