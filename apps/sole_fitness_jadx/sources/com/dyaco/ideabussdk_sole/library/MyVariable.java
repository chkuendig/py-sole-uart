package com.dyaco.ideabussdk_sole.library;

import androidx.core.view.InputDeviceCompat;
import com.facebook.appevents.AppEventsConstants;
import com.facebook.internal.security.CertificateUtil;
import com.ideabus.library.CustomVariable;
import java.io.UnsupportedEncodingException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Calendar;
import kotlin.UByte;
import org.apache.commons.lang3.StringUtils;

/* loaded from: classes.dex */
public class MyVariable extends CustomVariable {
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

    public static String getFillString(int i, int i2, String str) {
        StringBuilder sb = new StringBuilder(String.valueOf(i));
        while (sb.length() < i2) {
            sb.insert(0, str);
        }
        return sb.toString();
    }

    public static String getScaleToString(float f, int i) {
        return new BigDecimal(f).setScale(i, RoundingMode.HALF_UP).toString();
    }

    public static float getScaleToFloat(float f, int i) {
        return new BigDecimal(f).setScale(i, RoundingMode.HALF_UP).floatValue();
    }

    public static float divide(float f, float f2, int i) {
        return new BigDecimal(f).divide(new BigDecimal(f2), i, RoundingMode.HALF_UP).floatValue();
    }

    public static String getDateTime() {
        Calendar calendar = Calendar.getInstance();
        return calendar.get(1) + "/" + getStringPlace(calendar.get(2) + 1, 2) + "/" + getStringPlace(calendar.get(5), 2) + StringUtils.SPACE + getStringPlace(calendar.get(11), 2) + CertificateUtil.DELIMITER + getStringPlace(calendar.get(12), 2) + CertificateUtil.DELIMITER + getStringPlace(calendar.get(13), 2);
    }

    public static String bytesToHexString(byte[] bArr) {
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
        return sb.toString();
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

    public static String intToHexString(int i) {
        String hexString = Integer.toHexString(i);
        if (hexString.length() != 1) {
            return hexString;
        }
        return AppEventsConstants.EVENT_PARAM_VALUE_NO + hexString;
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
}
