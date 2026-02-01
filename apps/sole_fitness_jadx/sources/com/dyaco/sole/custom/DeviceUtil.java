package com.dyaco.sole.custom;

/* loaded from: classes.dex */
public class DeviceUtil {
    public static boolean checkSpiritNotControlDevice(int i) {
        if (i == 14 || i == 99) {
            return true;
        }
        switch (i) {
            case 83:
            case 84:
            case 85:
            case 86:
            case 87:
            case 88:
                return true;
            default:
                switch (i) {
                    case 136:
                    case 137:
                    case 138:
                        return true;
                    default:
                        return false;
                }
        }
    }
}
