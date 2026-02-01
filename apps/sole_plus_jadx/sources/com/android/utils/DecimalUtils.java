package com.android.utils;

import androidx.exifinterface.media.ExifInterface;
import java.text.DecimalFormatSymbols;

/* loaded from: classes3.dex */
public class DecimalUtils {
    public static String trimInsignificantZeros(String floatingPointNumber) {
        return trimInsignificantZeros(floatingPointNumber, '.', ExifInterface.LONGITUDE_EAST);
    }

    public static String trimInsignificantZeros(String floatingPointNumber, DecimalFormatSymbols symbols) {
        return trimInsignificantZeros(floatingPointNumber, symbols.getDecimalSeparator(), symbols.getExponentSeparator());
    }

    public static String trimInsignificantZeros(String floatingPointNumber, char decimalSeparator, String exponentialSeparator) {
        int iLastIndexOf = floatingPointNumber.lastIndexOf(decimalSeparator);
        if (iLastIndexOf < 0) {
            return floatingPointNumber;
        }
        if (iLastIndexOf == 0) {
            iLastIndexOf = 2;
        }
        int iIndexOfIgnoreCase = CharSequences.indexOfIgnoreCase(floatingPointNumber, exponentialSeparator, iLastIndexOf);
        int length = iIndexOfIgnoreCase >= 0 ? iIndexOfIgnoreCase : floatingPointNumber.length();
        while (true) {
            int i = length - 1;
            if (i <= iLastIndexOf) {
                length = i;
                break;
            }
            if (floatingPointNumber.charAt(i) != '0') {
                break;
            }
            length = i;
        }
        if (iIndexOfIgnoreCase < 0) {
            return floatingPointNumber.substring(0, length);
        }
        return iIndexOfIgnoreCase == length ? floatingPointNumber : floatingPointNumber.substring(0, length) + floatingPointNumber.substring(iIndexOfIgnoreCase);
    }

    private DecimalUtils() {
    }
}
