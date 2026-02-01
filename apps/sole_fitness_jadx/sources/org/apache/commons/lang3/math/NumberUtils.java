package org.apache.commons.lang3.math;

import com.facebook.appevents.AppEventsConstants;
import java.lang.reflect.Array;
import java.math.BigDecimal;
import java.math.BigInteger;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.SystemUtils;
import org.apache.commons.lang3.Validate;

/* loaded from: classes2.dex */
public class NumberUtils {
    public static final Long LONG_ZERO = 0L;
    public static final Long LONG_ONE = 1L;
    public static final Long LONG_MINUS_ONE = -1L;
    public static final Integer INTEGER_ZERO = 0;
    public static final Integer INTEGER_ONE = 1;
    public static final Integer INTEGER_MINUS_ONE = -1;
    public static final Short SHORT_ZERO = 0;
    public static final Short SHORT_ONE = 1;
    public static final Short SHORT_MINUS_ONE = -1;
    public static final Byte BYTE_ZERO = (byte) 0;
    public static final Byte BYTE_ONE = (byte) 1;
    public static final Byte BYTE_MINUS_ONE = (byte) -1;
    public static final Double DOUBLE_ZERO = Double.valueOf(0.0d);
    public static final Double DOUBLE_ONE = Double.valueOf(1.0d);
    public static final Double DOUBLE_MINUS_ONE = Double.valueOf(-1.0d);
    public static final Float FLOAT_ZERO = Float.valueOf(0.0f);
    public static final Float FLOAT_ONE = Float.valueOf(1.0f);
    public static final Float FLOAT_MINUS_ONE = Float.valueOf(-1.0f);

    public static int compare(byte b, byte b2) {
        return b - b2;
    }

    public static int compare(int i, int i2) {
        if (i == i2) {
            return 0;
        }
        return i < i2 ? -1 : 1;
    }

    public static int compare(long j, long j2) {
        if (j == j2) {
            return 0;
        }
        return j < j2 ? -1 : 1;
    }

    public static int compare(short s, short s2) {
        if (s == s2) {
            return 0;
        }
        return s < s2 ? -1 : 1;
    }

    public static byte max(byte b, byte b2, byte b3) {
        if (b2 > b) {
            b = b2;
        }
        return b3 > b ? b3 : b;
    }

    public static int max(int i, int i2, int i3) {
        if (i2 > i) {
            i = i2;
        }
        return i3 > i ? i3 : i;
    }

    public static long max(long j, long j2, long j3) {
        if (j2 > j) {
            j = j2;
        }
        return j3 > j ? j3 : j;
    }

    public static short max(short s, short s2, short s3) {
        if (s2 > s) {
            s = s2;
        }
        return s3 > s ? s3 : s;
    }

    public static byte min(byte b, byte b2, byte b3) {
        if (b2 < b) {
            b = b2;
        }
        return b3 < b ? b3 : b;
    }

    public static int min(int i, int i2, int i3) {
        if (i2 < i) {
            i = i2;
        }
        return i3 < i ? i3 : i;
    }

    public static long min(long j, long j2, long j3) {
        if (j2 < j) {
            j = j2;
        }
        return j3 < j ? j3 : j;
    }

    public static short min(short s, short s2, short s3) {
        if (s2 < s) {
            s = s2;
        }
        return s3 < s ? s3 : s;
    }

    public static int toInt(String str) {
        return toInt(str, 0);
    }

    public static int toInt(String str, int i) {
        if (str == null) {
            return i;
        }
        try {
            return Integer.parseInt(str);
        } catch (NumberFormatException unused) {
            return i;
        }
    }

    public static long toLong(String str) {
        return toLong(str, 0L);
    }

    public static long toLong(String str, long j) {
        if (str == null) {
            return j;
        }
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static float toFloat(String str) {
        return toFloat(str, 0.0f);
    }

    public static float toFloat(String str, float f) {
        if (str == null) {
            return f;
        }
        try {
            return Float.parseFloat(str);
        } catch (NumberFormatException unused) {
            return f;
        }
    }

    public static double toDouble(String str) {
        return toDouble(str, 0.0d);
    }

    public static double toDouble(String str, double d) {
        if (str == null) {
            return d;
        }
        try {
            return Double.parseDouble(str);
        } catch (NumberFormatException unused) {
            return d;
        }
    }

    public static byte toByte(String str) {
        return toByte(str, (byte) 0);
    }

    public static byte toByte(String str, byte b) {
        if (str == null) {
            return b;
        }
        try {
            return Byte.parseByte(str);
        } catch (NumberFormatException unused) {
            return b;
        }
    }

    public static short toShort(String str) {
        return toShort(str, (short) 0);
    }

    public static short toShort(String str, short s) {
        if (str == null) {
            return s;
        }
        try {
            return Short.parseShort(str);
        } catch (NumberFormatException unused) {
            return s;
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:81:0x0136, code lost:
    
        if (r1 == 'l') goto L82;
     */
    /* JADX WARN: Removed duplicated region for block: B:105:0x0192 A[Catch: NumberFormatException -> 0x019e, TRY_LEAVE, TryCatch #5 {NumberFormatException -> 0x019e, blocks: (B:103:0x0188, B:105:0x0192), top: B:164:0x0188 }] */
    /* JADX WARN: Removed duplicated region for block: B:164:0x0188 A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x017d A[Catch: NumberFormatException -> 0x0188, TRY_LEAVE, TryCatch #2 {NumberFormatException -> 0x0188, blocks: (B:96:0x0173, B:98:0x017d), top: B:158:0x0173 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static Number createNumber(String str) throws NumberFormatException {
        int length;
        String mantissa;
        String strSubstring;
        Float fCreateFloat;
        Double dCreateDouble;
        Double dCreateDouble2;
        Float fCreateFloat2;
        String strSubstring2 = null;
        if (str == null) {
            return null;
        }
        if (StringUtils.isBlank(str)) {
            throw new NumberFormatException("A blank string is not a valid number");
        }
        String[] strArr = {"0x", "0X", "-0x", "-0X", "#", "-#"};
        char cCharAt = 0;
        int i = 0;
        while (true) {
            if (i >= 6) {
                length = 0;
                break;
            }
            String str2 = strArr[i];
            if (str.startsWith(str2)) {
                length = str2.length() + 0;
                break;
            }
            i++;
        }
        if (length > 0) {
            int i2 = length;
            while (length < str.length() && (cCharAt = str.charAt(length)) == '0') {
                i2++;
                length++;
            }
            int length2 = str.length() - i2;
            if (length2 > 16 || (length2 == 16 && cCharAt > '7')) {
                return createBigInteger(str);
            }
            if (length2 > 8 || (length2 == 8 && cCharAt > '7')) {
                return createLong(str);
            }
            return createInteger(str);
        }
        char cCharAt2 = str.charAt(str.length() - 1);
        int iIndexOf = str.indexOf(46);
        int iIndexOf2 = str.indexOf(101) + str.indexOf(69) + 1;
        if (iIndexOf > -1) {
            if (iIndexOf2 > -1) {
                if (iIndexOf2 < iIndexOf || iIndexOf2 > str.length()) {
                    throw new NumberFormatException(str + " is not a valid number.");
                }
                strSubstring = str.substring(iIndexOf + 1, iIndexOf2);
            } else {
                strSubstring = str.substring(iIndexOf + 1);
            }
            mantissa = getMantissa(str, iIndexOf);
        } else {
            if (iIndexOf2 > -1) {
                if (iIndexOf2 > str.length()) {
                    throw new NumberFormatException(str + " is not a valid number.");
                }
                mantissa = getMantissa(str, iIndexOf2);
            } else {
                mantissa = getMantissa(str);
            }
            strSubstring = null;
        }
        if (!Character.isDigit(cCharAt2) && cCharAt2 != '.') {
            if (iIndexOf2 > -1 && iIndexOf2 < str.length() - 1) {
                strSubstring2 = str.substring(iIndexOf2 + 1, str.length() - 1);
            }
            String strSubstring3 = str.substring(0, str.length() - 1);
            boolean z = isAllZeros(mantissa) && isAllZeros(strSubstring2);
            if (cCharAt2 != 'D') {
                if (cCharAt2 != 'F') {
                    if (cCharAt2 != 'L') {
                        if (cCharAt2 != 'd') {
                            if (cCharAt2 != 'f') {
                            }
                            fCreateFloat2 = createFloat(str);
                            if (!fCreateFloat2.isInfinite()) {
                            }
                            dCreateDouble2 = createDouble(str);
                            if (!dCreateDouble2.isInfinite()) {
                            }
                            return createBigDecimal(strSubstring3);
                        }
                    }
                    if (strSubstring == null && strSubstring2 == null && ((strSubstring3.charAt(0) == '-' && isDigits(strSubstring3.substring(1))) || isDigits(strSubstring3))) {
                        try {
                            return createLong(strSubstring3);
                        } catch (NumberFormatException unused) {
                            return createBigInteger(strSubstring3);
                        }
                    }
                    throw new NumberFormatException(str + " is not a valid number.");
                }
                try {
                    fCreateFloat2 = createFloat(str);
                    if (!fCreateFloat2.isInfinite()) {
                        if (fCreateFloat2.floatValue() != 0.0f || z) {
                            return fCreateFloat2;
                        }
                    }
                } catch (NumberFormatException unused2) {
                }
                dCreateDouble2 = createDouble(str);
                if (!dCreateDouble2.isInfinite()) {
                }
                return createBigDecimal(strSubstring3);
            }
            try {
                dCreateDouble2 = createDouble(str);
                if (!dCreateDouble2.isInfinite()) {
                    if (dCreateDouble2.floatValue() != 0.0d || z) {
                        return dCreateDouble2;
                    }
                }
            } catch (NumberFormatException unused3) {
            }
            try {
                return createBigDecimal(strSubstring3);
            } catch (NumberFormatException unused4) {
            }
            throw new NumberFormatException(str + " is not a valid number.");
        }
        if (iIndexOf2 > -1 && iIndexOf2 < str.length() - 1) {
            strSubstring2 = str.substring(iIndexOf2 + 1, str.length());
        }
        if (strSubstring == null && strSubstring2 == null) {
            try {
                try {
                    return createInteger(str);
                } catch (NumberFormatException unused5) {
                    return createBigInteger(str);
                }
            } catch (NumberFormatException unused6) {
                return createLong(str);
            }
        }
        if (isAllZeros(mantissa) && isAllZeros(strSubstring2)) {
            cCharAt = 1;
        }
        try {
            fCreateFloat = createFloat(str);
            dCreateDouble = createDouble(str);
        } catch (NumberFormatException unused7) {
        }
        if (!fCreateFloat.isInfinite() && ((fCreateFloat.floatValue() != 0.0f || cCharAt != 0) && fCreateFloat.toString().equals(dCreateDouble.toString()))) {
            return fCreateFloat;
        }
        if (!dCreateDouble.isInfinite() && (dCreateDouble.doubleValue() != 0.0d || cCharAt != 0)) {
            BigDecimal bigDecimalCreateBigDecimal = createBigDecimal(str);
            return bigDecimalCreateBigDecimal.compareTo(BigDecimal.valueOf(dCreateDouble.doubleValue())) == 0 ? dCreateDouble : bigDecimalCreateBigDecimal;
        }
        return createBigDecimal(str);
    }

    private static String getMantissa(String str) {
        return getMantissa(str, str.length());
    }

    private static String getMantissa(String str, int i) {
        char cCharAt = str.charAt(0);
        return cCharAt == '-' || cCharAt == '+' ? str.substring(1, i) : str.substring(0, i);
    }

    private static boolean isAllZeros(String str) {
        if (str == null) {
            return true;
        }
        for (int length = str.length() - 1; length >= 0; length--) {
            if (str.charAt(length) != '0') {
                return false;
            }
        }
        return str.length() > 0;
    }

    public static Float createFloat(String str) {
        if (str == null) {
            return null;
        }
        return Float.valueOf(str);
    }

    public static Double createDouble(String str) {
        if (str == null) {
            return null;
        }
        return Double.valueOf(str);
    }

    public static Integer createInteger(String str) {
        if (str == null) {
            return null;
        }
        return Integer.decode(str);
    }

    public static Long createLong(String str) {
        if (str == null) {
            return null;
        }
        return Long.decode(str);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0040  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static BigInteger createBigInteger(String str) {
        int i;
        if (str == null) {
            return null;
        }
        boolean zStartsWith = str.startsWith(HelpFormatter.DEFAULT_OPT_PREFIX);
        int i2 = 16;
        if (str.startsWith("0x", zStartsWith ? 1 : 0) || str.startsWith("0X", zStartsWith ? 1 : 0)) {
            i = (zStartsWith ? 1 : 0) + 2;
        } else if (str.startsWith("#", zStartsWith ? 1 : 0)) {
            i = (zStartsWith ? 1 : 0) + 1;
        } else if (str.startsWith(AppEventsConstants.EVENT_PARAM_VALUE_NO, zStartsWith ? 1 : 0)) {
            int length = str.length();
            int i3 = (zStartsWith ? 1 : 0) + 1;
            if (length > i3) {
                i2 = 8;
                i = i3;
            } else {
                i2 = 10;
                i = zStartsWith ? 1 : 0;
            }
        }
        BigInteger bigInteger = new BigInteger(str.substring(i), i2);
        return zStartsWith ? bigInteger.negate() : bigInteger;
    }

    public static BigDecimal createBigDecimal(String str) {
        if (str == null) {
            return null;
        }
        if (StringUtils.isBlank(str)) {
            throw new NumberFormatException("A blank string is not a valid number");
        }
        if (str.trim().startsWith(HelpFormatter.DEFAULT_LONG_OPT_PREFIX)) {
            throw new NumberFormatException(str + " is not a valid number.");
        }
        return new BigDecimal(str);
    }

    public static long min(long... jArr) {
        validateArray(jArr);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            if (jArr[i] < j) {
                j = jArr[i];
            }
        }
        return j;
    }

    public static int min(int... iArr) {
        validateArray(iArr);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (iArr[i2] < i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public static short min(short... sArr) {
        validateArray(sArr);
        short s = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            if (sArr[i] < s) {
                s = sArr[i];
            }
        }
        return s;
    }

    public static byte min(byte... bArr) {
        validateArray(bArr);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            if (bArr[i] < b) {
                b = bArr[i];
            }
        }
        return b;
    }

    public static double min(double... dArr) {
        validateArray(dArr);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            if (Double.isNaN(dArr[i])) {
                return Double.NaN;
            }
            if (dArr[i] < d) {
                d = dArr[i];
            }
        }
        return d;
    }

    public static float min(float... fArr) {
        validateArray(fArr);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            if (Float.isNaN(fArr[i])) {
                return Float.NaN;
            }
            if (fArr[i] < f) {
                f = fArr[i];
            }
        }
        return f;
    }

    public static long max(long... jArr) {
        validateArray(jArr);
        long j = jArr[0];
        for (int i = 1; i < jArr.length; i++) {
            if (jArr[i] > j) {
                j = jArr[i];
            }
        }
        return j;
    }

    public static int max(int... iArr) {
        validateArray(iArr);
        int i = iArr[0];
        for (int i2 = 1; i2 < iArr.length; i2++) {
            if (iArr[i2] > i) {
                i = iArr[i2];
            }
        }
        return i;
    }

    public static short max(short... sArr) {
        validateArray(sArr);
        short s = sArr[0];
        for (int i = 1; i < sArr.length; i++) {
            if (sArr[i] > s) {
                s = sArr[i];
            }
        }
        return s;
    }

    public static byte max(byte... bArr) {
        validateArray(bArr);
        byte b = bArr[0];
        for (int i = 1; i < bArr.length; i++) {
            if (bArr[i] > b) {
                b = bArr[i];
            }
        }
        return b;
    }

    public static double max(double... dArr) {
        validateArray(dArr);
        double d = dArr[0];
        for (int i = 1; i < dArr.length; i++) {
            if (Double.isNaN(dArr[i])) {
                return Double.NaN;
            }
            if (dArr[i] > d) {
                d = dArr[i];
            }
        }
        return d;
    }

    public static float max(float... fArr) {
        validateArray(fArr);
        float f = fArr[0];
        for (int i = 1; i < fArr.length; i++) {
            if (Float.isNaN(fArr[i])) {
                return Float.NaN;
            }
            if (fArr[i] > f) {
                f = fArr[i];
            }
        }
        return f;
    }

    private static void validateArray(Object obj) {
        if (obj == null) {
            throw new IllegalArgumentException("The Array must not be null");
        }
        Validate.isTrue(Array.getLength(obj) != 0, "Array cannot be empty.", new Object[0]);
    }

    public static double min(double d, double d2, double d3) {
        return Math.min(Math.min(d, d2), d3);
    }

    public static float min(float f, float f2, float f3) {
        return Math.min(Math.min(f, f2), f3);
    }

    public static double max(double d, double d2, double d3) {
        return Math.max(Math.max(d, d2), d3);
    }

    public static float max(float f, float f2, float f3) {
        return Math.max(Math.max(f, f2), f3);
    }

    public static boolean isDigits(String str) {
        return StringUtils.isNumeric(str);
    }

    @Deprecated
    public static boolean isNumber(String str) {
        return isCreatable(str);
    }

    /* JADX WARN: Code restructure failed: missing block: B:127:0x0123, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public static boolean isCreatable(String str) {
        if (StringUtils.isEmpty(str)) {
            return false;
        }
        char[] charArray = str.toCharArray();
        int length = charArray.length;
        boolean z = true;
        int i = (charArray[0] == '-' || charArray[0] == '+') ? 1 : 0;
        boolean z2 = i == 1 && charArray[0] == '+';
        int i2 = i + 1;
        if (length > i2 && charArray[i] == '0') {
            if (charArray[i2] == 'x' || charArray[i2] == 'X') {
                int i3 = i + 2;
                if (i3 == length) {
                    return false;
                }
                while (i3 < charArray.length) {
                    if ((charArray[i3] < '0' || charArray[i3] > '9') && ((charArray[i3] < 'a' || charArray[i3] > 'f') && (charArray[i3] < 'A' || charArray[i3] > 'F'))) {
                        return false;
                    }
                    i3++;
                }
                return true;
            }
            if (Character.isDigit(charArray[i2])) {
                while (i2 < charArray.length) {
                    if (charArray[i2] < '0' || charArray[i2] > '7') {
                        return false;
                    }
                    i2++;
                }
                return true;
            }
        }
        int i4 = length - 1;
        boolean z3 = false;
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        while (true) {
            if (i >= i4 && (i >= i4 + 1 || !z3 || z4)) {
                break;
            }
            if (charArray[i] >= '0' && charArray[i] <= '9') {
                z3 = false;
                z4 = true;
            } else if (charArray[i] == '.') {
                if (z6 || z5) {
                    break;
                }
                z6 = true;
            } else if (charArray[i] != 'e' && charArray[i] != 'E') {
                if (charArray[i] != '+' && charArray[i] != '-') {
                    return false;
                }
                if (!z3) {
                    return false;
                }
                z3 = false;
                z4 = false;
            } else {
                if (z5 || !z4) {
                    return false;
                }
                z3 = true;
                z5 = true;
            }
            i++;
            z = true;
        }
        if (i >= charArray.length) {
            if (z3 || !z4) {
                return false;
            }
            return z;
        }
        if (charArray[i] >= '0' && charArray[i] <= '9') {
            if (SystemUtils.IS_JAVA_1_6 && z2 && !z6) {
                return false;
            }
            return z;
        }
        if (charArray[i] == 'e' || charArray[i] == 'E') {
            return false;
        }
        if (charArray[i] == '.') {
            if (z6 || z5) {
                return false;
            }
            return z4;
        }
        if (!z3 && (charArray[i] == 'd' || charArray[i] == 'D' || charArray[i] == 'f' || charArray[i] == 'F')) {
            return z4;
        }
        if ((charArray[i] == 'l' || charArray[i] == 'L') && z4 && !z5 && !z6) {
            return z;
        }
        return false;
    }

    public static boolean isParsable(String str) {
        if (StringUtils.isEmpty(str) || str.charAt(str.length() - 1) == '.') {
            return false;
        }
        if (str.charAt(0) == '-') {
            if (str.length() == 1) {
                return false;
            }
            return withDecimalsParsing(str, 1);
        }
        return withDecimalsParsing(str, 0);
    }

    private static boolean withDecimalsParsing(String str, int i) {
        int i2 = 0;
        while (i < str.length()) {
            boolean z = str.charAt(i) == '.';
            if (z) {
                i2++;
            }
            if (i2 > 1) {
                return false;
            }
            if (!z && !Character.isDigit(str.charAt(i))) {
                return false;
            }
            i++;
        }
        return true;
    }
}
