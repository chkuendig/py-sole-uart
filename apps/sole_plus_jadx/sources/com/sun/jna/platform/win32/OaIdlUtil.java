package com.sun.jna.platform.win32;

import com.sun.jna.Pointer;
import com.sun.jna.platform.win32.OaIdl;
import com.sun.jna.platform.win32.Variant;
import com.sun.jna.platform.win32.WTypes;
import com.sun.jna.platform.win32.WinDef;
import java.lang.reflect.Array;

/* loaded from: classes4.dex */
public abstract class OaIdlUtil {
    public static Object toPrimitiveArray(OaIdl.SAFEARRAY safearray, boolean z) {
        Object shortArray;
        Pointer pointerAccessData = safearray.accessData();
        try {
            int dimensionCount = safearray.getDimensionCount();
            int[] iArr = new int[dimensionCount];
            int[] iArr2 = new int[dimensionCount];
            int iIntValue = safearray.getVarType().intValue();
            for (int i = 0; i < dimensionCount; i++) {
                iArr[i] = (safearray.getUBound(i) - safearray.getLBound(i)) + 1;
            }
            int i2 = dimensionCount - 1;
            for (int i3 = i2; i3 >= 0; i3--) {
                if (i3 == i2) {
                    iArr2[i3] = 1;
                } else {
                    int i4 = i3 + 1;
                    iArr2[i3] = iArr2[i4] * iArr[i4];
                }
            }
            if (dimensionCount == 0) {
                throw new IllegalArgumentException("Supplied Array has no dimensions.");
            }
            int i5 = iArr2[0] * iArr[0];
            switch (iIntValue) {
                case 2:
                case 11:
                case 18:
                    shortArray = pointerAccessData.getShortArray(0L, i5);
                    break;
                case 3:
                case 10:
                case 19:
                case 22:
                case 23:
                    shortArray = pointerAccessData.getIntArray(0L, i5);
                    break;
                case 4:
                    shortArray = pointerAccessData.getFloatArray(0L, i5);
                    break;
                case 5:
                case 7:
                    shortArray = pointerAccessData.getDoubleArray(0L, i5);
                    break;
                case 6:
                case 9:
                case 13:
                case 14:
                case 15:
                case 20:
                case 21:
                default:
                    throw new IllegalStateException("Type not supported: " + iIntValue);
                case 8:
                    shortArray = pointerAccessData.getPointerArray(0L, i5);
                    break;
                case 12:
                    shortArray = new Variant.VARIANT(pointerAccessData).toArray(i5);
                    break;
                case 16:
                case 17:
                    shortArray = pointerAccessData.getByteArray(0L, i5);
                    break;
            }
            Object objNewInstance = Array.newInstance((Class<?>) Object.class, iArr);
            toPrimitiveArray(shortArray, objNewInstance, iArr, iArr2, iIntValue, new int[0]);
            return objNewInstance;
        } finally {
            safearray.unaccessData();
            if (z) {
                safearray.destroy();
            }
        }
    }

    private static void toPrimitiveArray(Object obj, Object obj2, int[] iArr, int[] iArr2, int i, int[] iArr3) throws ArrayIndexOutOfBoundsException, IllegalArgumentException {
        int length = iArr3.length;
        int[] iArr4 = new int[iArr3.length + 1];
        System.arraycopy(iArr3, 0, iArr4, 0, length);
        for (int i2 = 0; i2 < iArr[length]; i2++) {
            iArr4[length] = i2;
            if (length == iArr.length - 1) {
                int i3 = 0;
                for (int i4 = 0; i4 < length; i4++) {
                    i3 += iArr2[i4] * iArr3[i4];
                }
                int i5 = iArr4[length];
                int i6 = i3 + i5;
                switch (i) {
                    case 2:
                    case 18:
                        Array.set(obj2, i5, Short.valueOf(Array.getShort(obj, i6)));
                        break;
                    case 3:
                    case 19:
                    case 22:
                    case 23:
                        Array.set(obj2, i5, Integer.valueOf(Array.getInt(obj, i6)));
                        break;
                    case 4:
                        Array.set(obj2, i5, Float.valueOf(Array.getFloat(obj, i6)));
                        break;
                    case 5:
                        Array.set(obj2, i5, Double.valueOf(Array.getDouble(obj, i6)));
                        break;
                    case 6:
                    case 9:
                    case 13:
                    case 14:
                    case 15:
                    case 20:
                    case 21:
                    default:
                        throw new IllegalStateException("Type not supported: " + i);
                    case 7:
                        Array.set(obj2, i5, new OaIdl.DATE(Array.getDouble(obj, i6)).getAsJavaDate());
                        break;
                    case 8:
                        Array.set(obj2, i5, new WTypes.BSTR((Pointer) Array.get(obj, i6)).getValue());
                        break;
                    case 10:
                        Array.set(obj2, i5, new WinDef.SCODE(Array.getInt(obj, i6)));
                        break;
                    case 11:
                        Array.set(obj2, i5, Boolean.valueOf(Array.getShort(obj, i6) != 0));
                        break;
                    case 12:
                        Variant.VARIANT variant = (Variant.VARIANT) Array.get(obj, i6);
                        switch (variant.getVarType().intValue()) {
                            case 0:
                            case 1:
                                Array.set(obj2, i5, null);
                                break;
                            case 2:
                            case 18:
                                Array.set(obj2, i5, Short.valueOf(variant.shortValue()));
                                break;
                            case 3:
                            case 19:
                            case 22:
                            case 23:
                                Array.set(obj2, i5, Integer.valueOf(variant.intValue()));
                                break;
                            case 4:
                                Array.set(obj2, i5, Float.valueOf(variant.floatValue()));
                                break;
                            case 5:
                                Array.set(obj2, i5, Double.valueOf(variant.doubleValue()));
                                break;
                            case 6:
                            case 9:
                            case 12:
                            case 13:
                            case 14:
                            case 15:
                            case 20:
                            case 21:
                            default:
                                throw new IllegalStateException("Type not supported: " + variant.getVarType().intValue());
                            case 7:
                                Array.set(obj2, i5, variant.dateValue());
                                break;
                            case 8:
                                Array.set(obj2, i5, variant.stringValue());
                                break;
                            case 10:
                                Array.set(obj2, i5, new WinDef.SCODE(variant.intValue()));
                                break;
                            case 11:
                                Array.set(obj2, i5, Boolean.valueOf(variant.booleanValue()));
                                break;
                            case 16:
                            case 17:
                                Array.set(obj2, i5, Byte.valueOf(variant.byteValue()));
                                break;
                        }
                    case 16:
                    case 17:
                        Array.set(obj2, i5, Byte.valueOf(Array.getByte(obj, i6)));
                        break;
                }
            } else {
                toPrimitiveArray(obj, Array.get(obj2, i2), iArr, iArr2, i, iArr4);
            }
        }
    }
}
