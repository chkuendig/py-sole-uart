package com.android.utils;

import com.android.SdkConstants;
import kotlin.text.Typography;

/* loaded from: classes3.dex */
public class OffsetTrackingDecodedXmlValue {
    private static final char[] DECODED = {Typography.less, Typography.greater, Typography.amp, '\'', '\"'};
    private static final String[] ENCODED = {SdkConstants.LT_ENTITY, SdkConstants.GT_ENTITY, SdkConstants.AMP_ENTITY, SdkConstants.APOS_ENTITY, SdkConstants.QUOT_ENTITY};
    private final CharSequence myDecodedCharacters;
    private final int[] myOffsetMap;

    public OffsetTrackingDecodedXmlValue(CharSequence encodedValue) {
        int length = encodedValue.length();
        int[] iArr = null;
        StringBuilder sb = null;
        int length2 = 0;
        while (length2 < length) {
            int i = 0;
            while (true) {
                String[] strArr = ENCODED;
                if (i < strArr.length) {
                    String str = strArr[i];
                    if (str.length() + length2 > length || !CharSequences.regionMatches(encodedValue, length2, str, 0, str.length())) {
                        i++;
                    } else {
                        if (sb == null) {
                            StringBuilder sb2 = new StringBuilder(length);
                            int[] iArr2 = new int[length];
                            for (int i2 = 0; i2 < length2; i2++) {
                                iArr2[i2] = i2;
                                sb2.append(encodedValue.charAt(i2));
                            }
                            sb = sb2;
                            iArr = iArr2;
                        }
                        sb.append(DECODED[i]);
                        length2 += str.length();
                        iArr[sb.length() - 1] = length2;
                    }
                } else {
                    if (sb != null) {
                        sb.append(encodedValue.charAt(length2));
                        iArr[sb.length() - 1] = length2;
                    }
                    length2++;
                }
            }
        }
        this.myOffsetMap = iArr;
        this.myDecodedCharacters = sb != null ? sb.toString() : encodedValue;
    }

    public CharSequence getDecodedCharacters() {
        return this.myDecodedCharacters;
    }

    public int getEncodedOffset(int decodedOffset) {
        if (this.myOffsetMap == null || decodedOffset <= 0) {
            return decodedOffset;
        }
        if (decodedOffset <= this.myDecodedCharacters.length()) {
            return this.myOffsetMap[decodedOffset - 1];
        }
        return (this.myOffsetMap[this.myDecodedCharacters.length() - 1] + decodedOffset) - this.myDecodedCharacters.length();
    }
}
