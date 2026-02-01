package com.ideabus.library;

import android.util.Log;
import androidx.core.view.InputDeviceCompat;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.security.CertificateUtil;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.text.NumberFormat;
import java.util.Calendar;
import kotlin.UByte;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes2.dex */
public class CustomVariable {
    public static float density = 0.0f;
    public static boolean isFirstOpenApp = true;
    public static boolean isLongScreen = false;
    public static boolean isPrintLog = true;
    public static int screenHeight;
    public static float screenScale;
    public static int screenWidth;

    public static void printLog(String str, String str2, String str3) {
        int i;
        if (str.equals("i")) {
            i = 4;
        } else if (str.equals("d")) {
            i = 3;
        } else {
            i = str.equals("e") ? 6 : 0;
        }
        if (isPrintLog) {
            Log.println(i, str2, str3);
        }
    }

    public static float dpToPixel(float f) {
        return f * density;
    }

    public static float pixelToDp(float f) {
        return f / density;
    }

    public static String HexToASII(String str) {
        if (str.length() < 2) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        int i = 0;
        while (i < str.length()) {
            int i2 = i + 2;
            sb.append((char) Integer.parseInt(str.substring(i, i2), 16));
            i = i2;
        }
        return sb.toString();
    }

    public static String getStringPlace(String str, int i) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(false);
        numberFormat.setMinimumIntegerDigits(i);
        return numberFormat.format(str);
    }

    public static String getStringPlace(int i, int i2) {
        NumberFormat numberFormat = NumberFormat.getInstance();
        numberFormat.setGroupingUsed(false);
        numberFormat.setMinimumIntegerDigits(i2);
        return numberFormat.format(i);
    }

    public static String getDateTime() {
        Calendar calendar = Calendar.getInstance();
        return String.valueOf(calendar.get(1)) + "/" + getStringPlace(calendar.get(2) + 1, 2) + "/" + getStringPlace(calendar.get(5), 2) + StringUtils.SPACE + getStringPlace(calendar.get(11), 2) + CertificateUtil.DELIMITER + getStringPlace(calendar.get(12), 2) + CertificateUtil.DELIMITER + getStringPlace(calendar.get(13), 2);
    }

    public static String bytesToHexUpper(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            String hexString = Integer.toHexString(b & UByte.MAX_VALUE);
            if (hexString.length() < 2) {
                sb.append(0);
            }
            sb.append(hexString);
        }
        return sb.toString().toUpperCase();
    }

    public static String bytesToString(byte[] bArr) {
        StringBuilder sb = new StringBuilder("");
        if (bArr == null || bArr.length <= 0) {
            return null;
        }
        for (byte b : bArr) {
            sb.append(Integer.toString(b));
        }
        return sb.toString();
    }

    public static String bytesToAscii(byte[] bArr) {
        try {
            return new String(bArr, "ISO8859-1");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static byte[] hexToBytes(String str) {
        char[] charArray = str.toCharArray();
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
            sb.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        return sb.toString().toUpperCase();
    }

    public static String hexToBinary(String str, int i) {
        StringBuilder sb = new StringBuilder(new BigInteger(str, 16).toString(2));
        while (sb.length() < i) {
            sb = sb.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        return sb.toString();
    }

    public static String binaryToHexUpper(String str) {
        StringBuilder sb = new StringBuilder(new BigInteger(str, 2).toString(16));
        while (sb.length() < 2) {
            sb = sb.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        return sb.toString().toUpperCase();
    }

    public static int binaryToDecimal(String str) {
        return Integer.parseInt(str, 2);
    }

    public static String decimalToBinary(int i, int i2) {
        StringBuilder sb = new StringBuilder(Integer.toBinaryString(i));
        while (sb.length() < i2) {
            sb = sb.insert(0, AppEventsConstants.EVENT_PARAM_VALUE_NO);
        }
        return sb.toString();
    }
}
