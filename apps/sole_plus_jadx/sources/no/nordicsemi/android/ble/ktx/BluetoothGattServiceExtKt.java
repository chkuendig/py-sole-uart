package no.nordicsemi.android.ble.ktx;

import android.bluetooth.BluetoothGattCharacteristic;
import android.bluetooth.BluetoothGattService;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: BluetoothGattServiceExt.kt */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\u001a/\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"getCharacteristic", "Landroid/bluetooth/BluetoothGattCharacteristic;", "Landroid/bluetooth/BluetoothGattService;", "uuid", "Ljava/util/UUID;", "requiredProperties", "", "instanceId", "(Landroid/bluetooth/BluetoothGattService;Ljava/util/UUID;ILjava/lang/Integer;)Landroid/bluetooth/BluetoothGattCharacteristic;", "ble-ktx_release"}, k = 2, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
public final class BluetoothGattServiceExtKt {
    public static /* synthetic */ BluetoothGattCharacteristic getCharacteristic$default(BluetoothGattService bluetoothGattService, UUID uuid, int i, Integer num, int i2, Object obj) {
        if ((i2 & 2) != 0) {
            i = 0;
        }
        if ((i2 & 4) != 0) {
            num = null;
        }
        return getCharacteristic(bluetoothGattService, uuid, i, num);
    }

    public static final BluetoothGattCharacteristic getCharacteristic(BluetoothGattService bluetoothGattService, UUID uuid, int i, Integer num) {
        Object next;
        Intrinsics.checkNotNullParameter(bluetoothGattService, "<this>");
        Intrinsics.checkNotNullParameter(uuid, "uuid");
        List<BluetoothGattCharacteristic> characteristics = bluetoothGattService.getCharacteristics();
        Intrinsics.checkNotNullExpressionValue(characteristics, "getCharacteristics(...)");
        Iterator<T> it = characteristics.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            BluetoothGattCharacteristic bluetoothGattCharacteristic = (BluetoothGattCharacteristic) next;
            if (Intrinsics.areEqual(bluetoothGattCharacteristic.getUuid(), uuid) && (num == null || bluetoothGattCharacteristic.getInstanceId() == num.intValue())) {
                break;
            }
        }
        BluetoothGattCharacteristic bluetoothGattCharacteristic2 = (BluetoothGattCharacteristic) next;
        if (bluetoothGattCharacteristic2 == null || (bluetoothGattCharacteristic2.getProperties() & i) != i) {
            return null;
        }
        return bluetoothGattCharacteristic2;
    }
}
