package com.soletreadmills.sole_v2.ble.code;

/* loaded from: classes5.dex */
public class FitnessMachineControlPointResultCode {
    public static final byte CONTROL_NOT_PERMITTED = 5;
    public static final byte INVALID_PARAMETER = 3;
    public static final byte OPERATION_FAILED = 4;
    public static final byte OP_CODE_NOT_SUPPORTED = 2;
    public static final byte SUCCESS = 1;

    public enum Type {
        SUCCESS,
        OP_CODE_NOT_SUPPORTED,
        INVALID_PARAMETER,
        OPERATION_FAILED,
        CONTROL_NOT_PERMITTED
    }

    /* renamed from: com.soletreadmills.sole_v2.ble.code.FitnessMachineControlPointResultCode$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointResultCode$Type;

        static {
            int[] iArr = new int[Type.values().length];
            $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointResultCode$Type = iArr;
            try {
                iArr[Type.SUCCESS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointResultCode$Type[Type.OP_CODE_NOT_SUPPORTED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointResultCode$Type[Type.INVALID_PARAMETER.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointResultCode$Type[Type.OPERATION_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointResultCode$Type[Type.CONTROL_NOT_PERMITTED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static byte typeToCode(Type type) {
        int i = AnonymousClass1.$SwitchMap$com$soletreadmills$sole_v2$ble$code$FitnessMachineControlPointResultCode$Type[type.ordinal()];
        byte b = 1;
        if (i != 1) {
            b = 2;
            if (i != 2) {
                b = 3;
                if (i != 3) {
                    b = 4;
                    if (i != 4) {
                        return (byte) 5;
                    }
                }
            }
        }
        return b;
    }

    public static Type codeToType(byte code) {
        if (code == 1) {
            return Type.SUCCESS;
        }
        if (code == 2) {
            return Type.OP_CODE_NOT_SUPPORTED;
        }
        if (code == 3) {
            return Type.INVALID_PARAMETER;
        }
        if (code == 4) {
            return Type.OPERATION_FAILED;
        }
        return Type.CONTROL_NOT_PERMITTED;
    }
}
