package com.soletreadmills.sole_v2.ble;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Calendar;
import java.util.Locale;

/* loaded from: classes5.dex */
public class BleTools {
    public static final int FORMAT_SINT16 = 34;
    public static final int FORMAT_SINT32 = 36;
    public static final int FORMAT_SINT8 = 33;
    public static final int FORMAT_UINT16 = 18;
    public static final int FORMAT_UINT32 = 20;
    public static final int FORMAT_UINT8 = 17;
    public static boolean isPrintLog = true;

    private static int getTypeLen(int formatType) {
        return formatType & 15;
    }

    private static int intToSignedBits(int i, int size) {
        if (i >= 0) {
            return i;
        }
        int i2 = 1 << (size - 1);
        return (i & (i2 - 1)) + i2;
    }

    private static int unsignedByteToInt(byte b) {
        return b & 255;
    }

    private static int unsignedToSigned(int unsigned, int size) {
        int i = 1 << (size - 1);
        return (unsigned & i) != 0 ? (i - (unsigned & (i - 1))) * (-1) : unsigned;
    }

    public static void printLog(String type, String tag, String msg) {
        int i;
        if (type.equals("i")) {
            i = 4;
        } else if (type.equals("d")) {
            i = 3;
        } else {
            i = type.equals("e") ? 6 : 0;
        }
        if (isPrintLog) {
            Log.println(i, tag, msg);
        }
    }

    public static String HexToASII(String hex) {
        if (hex.length() < 2) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < hex.length()) {
            int i2 = i + 2;
            sb.append((char) Integer.parseInt(hex.substring(i, i2), 16));
            i = i2;
        }
        return sb.toString();
    }

    public static String getStringPlace(String num, int place) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        numberFormat.setGroupingUsed(false);
        numberFormat.setMinimumIntegerDigits(place);
        return numberFormat.format(num);
    }

    public static String getStringPlace(int num, int place) {
        NumberFormat numberFormat = NumberFormat.getInstance(Locale.US);
        numberFormat.setGroupingUsed(false);
        numberFormat.setMinimumIntegerDigits(place);
        return numberFormat.format(num);
    }

    public static String getDateTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(1) + "/" + getStringPlace(calendar.get(2) + 1, 2) + "/" + getStringPlace(calendar.get(5), 2) + " " + getStringPlace(calendar.get(11), 2) + ":" + getStringPlace(calendar.get(12), 2) + ":" + getStringPlace(calendar.get(13), 2);
    }

    public static String bytesToHexUpper(byte[] src, boolean isAddZero) {
        StringBuilder sb = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (byte b : src) {
            String hexString = Integer.toHexString(b & 255);
            if (sb.length() > 0) {
                sb.append(" ");
            }
            if (isAddZero && hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString().toUpperCase();
    }

    public static String bytesToString(byte[] src) {
        StringBuilder sb = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (byte b : src) {
            sb.append(Integer.toString(b));
        }
        return sb.toString();
    }

    public static String bytesToAscii(byte[] src) {
        try {
            return new String(src, "ISO8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static String intToHexString(int i, int digit) {
        StringBuilder sb = new StringBuilder(Integer.toHexString(i));
        int length = sb.length();
        if (length > digit) {
            sb.delete(0, length - digit);
        } else {
            while (length < digit) {
                sb.insert(0, "0");
                length = sb.length();
            }
        }
        return sb.toString().toUpperCase();
    }

    public static byte[] hexToBytes(String hexString) {
        char[] charArray = hexString.toCharArray();
        int length = charArray.length / 2;
        byte[] bArr = new byte[length];
        for (int i = 0; i < length; i++) {
            int i2 = i * 2;
            int iDigit = Character.digit(charArray[i2 + 1], 16) | (Character.digit(charArray[i2], 16) << 4);
            if (iDigit > 127) {
                iDigit += InputDeviceCompat.SOURCE_ANY;
            }
            bArr[i] = (byte) iDigit;
        }
        return bArr;
    }

    public static String decimalToHexUpper(int i) {
        StringBuilder sb = new StringBuilder(Integer.toHexString(i));
        while (sb.length() < 2) {
            sb.insert(0, "0");
        }
        return sb.toString().toUpperCase();
    }

    public static String hexToBinary(String s, int bitCount) {
        StringBuilder sb = new StringBuilder(new BigInteger(s, 16).toString(2));
        while (sb.length() < bitCount) {
            sb = sb.insert(0, "0");
        }
        return sb.toString();
    }

    public static String binaryToHexUpper(String s) {
        StringBuilder sb = new StringBuilder(new BigInteger(s, 2).toString(16));
        while (sb.length() < 2) {
            sb = sb.insert(0, "0");
        }
        return sb.toString().toUpperCase();
    }

    public static int binaryToDecimal(String c) {
        return Integer.parseInt(c, 2);
    }

    public static String decimalToBinary(int i, int bitCount) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(i));
        while (sb.length() < bitCount) {
            sb = sb.insert(0, "0");
        }
        return sb.toString();
    }

    public static byte[] mergeBytes(byte[] data1, byte[] data2) {
        byte[] bArr = new byte[data1.length + data2.length];
        System.arraycopy(data1, 0, bArr, 0, data1.length);
        System.arraycopy(data2, 0, bArr, data1.length, data2.length);
        return bArr;
    }

    public static Integer byteArrToInt(final byte[] data, final int formatType, final int offset) {
        if (getTypeLen(formatType) + offset > data.length) {
            return null;
        }
        if (formatType == 17) {
            return Integer.valueOf(unsignedByteToInt(data[offset]));
        }
        if (formatType == 18) {
            return Integer.valueOf(unsignedBytesToInt(data[offset], data[offset + 1]));
        }
        if (formatType == 20) {
            return Integer.valueOf(unsignedBytesToInt(data[offset], data[offset + 1], data[offset + 2], data[offset + 3]));
        }
        if (formatType == 36) {
            return Integer.valueOf(unsignedToSigned(unsignedBytesToInt(data[offset], data[offset + 1], data[offset + 2], data[offset + 3]), 32));
        }
        if (formatType == 33) {
            return Integer.valueOf(unsignedToSigned(unsignedByteToInt(data[offset]), 8));
        }
        if (formatType != 34) {
            return null;
        }
        return Integer.valueOf(unsignedToSigned(unsignedBytesToInt(data[offset], data[offset + 1]), 16));
    }

    private static int unsignedBytesToInt(byte b0, byte b1) {
        return unsignedByteToInt(b0) + (unsignedByteToInt(b1) << 8);
    }

    private static int unsignedBytesToInt(byte b0, byte b1, byte b2, byte b3) {
        return unsignedByteToInt(b0) + (unsignedByteToInt(b1) << 8) + (unsignedByteToInt(b2) << 16) + (unsignedByteToInt(b3) << 24);
    }

    public static byte[] intToByteArr(int value, int formatType, int offset) {
        byte[] bArr = new byte[getTypeLen(formatType) + offset];
        try {
            if (formatType == 17) {
                bArr[offset] = (byte) (value & 255);
            } else if (formatType == 18) {
                bArr[offset] = (byte) (value & 255);
                bArr[offset + 1] = (byte) ((value >> 8) & 255);
            } else {
                if (formatType != 20) {
                    if (formatType == 36) {
                        value = intToSignedBits(value, 32);
                    } else if (formatType == 33) {
                        value = intToSignedBits(value, 8);
                        bArr[offset] = (byte) (value & 255);
                    } else {
                        if (formatType != 34) {
                            return null;
                        }
                        value = intToSignedBits(value, 16);
                        bArr[offset] = (byte) (value & 255);
                        bArr[offset + 1] = (byte) ((value >> 8) & 255);
                    }
                }
                bArr[offset] = (byte) (value & 255);
                bArr[offset + 1] = (byte) ((value >> 8) & 255);
                bArr[offset + 2] = (byte) ((value >> 16) & 255);
                bArr[offset + 3] = (byte) ((value >> 24) & 255);
            }
            return bArr;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String swapHighLowBytes(int value) {
        return String.format(Locale.US, "%02X%02X", Byte.valueOf((byte) value), Byte.valueOf((byte) (value >> 8)));
    }
}
