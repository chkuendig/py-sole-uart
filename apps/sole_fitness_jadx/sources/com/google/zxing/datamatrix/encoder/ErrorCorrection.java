package com.google.zxing.datamatrix.encoder;

import com.dyaco.sole.R2;

/* loaded from: classes2.dex */
public final class ErrorCorrection {
    private static final int MODULO_VALUE = 301;
    private static final int[] FACTOR_SETS = {5, 7, 10, 11, 12, 14, 18, 20, 24, 28, 36, 42, 48, 56, 62, 68};
    private static final int[][] FACTORS = {new int[]{R2.attr.defaultDuration, 48, 15, 111, 62}, new int[]{23, 68, 144, R2.attr.cardViewStyle, R2.attr.dividerPadding, 92, R2.attr.drawableTopCompat}, new int[]{28, 24, R2.attr.com_facebook_object_id, 166, R2.attr.customNavigationLayout, R2.attr.drawableLeftCompat, 116, 255, 110, 61}, new int[]{R2.attr.colorPrimaryDark, 138, 205, 12, R2.attr.constraintSetStart, 168, 39, R2.attr.drawPath, 60, 97, 120}, new int[]{41, R2.attr.circleCrop, R2.attr.circularflow_radiusInDP, 91, 61, 42, R2.attr.carousel_touchUpMode, R2.attr.coordinatorLayoutStyle, 97, 178, 100, R2.attr.dragDirection}, new int[]{R2.attr.circularflow_defaultAngle, 97, R2.attr.constraintSet, R2.attr.drawableTint, 95, 9, R2.attr.circularflow_defaultRadius, 119, 138, 45, 18, R2.attr.com_facebook_object_type, 83, R2.attr.com_facebook_object_id}, new int[]{83, R2.attr.constraint_referenced_ids, 100, 39, R2.attr.com_facebook_style, 75, 66, 61, R2.attr.dividerVertical, R2.attr.coordinatorLayoutStyle, 109, 129, 94, R2.attr.drawableTopCompat, R2.attr.customReference, 48, 90, R2.attr.com_facebook_style}, new int[]{15, R2.attr.constraint_referenced_ids, R2.attr.dragThreshold, 9, R2.attr.deriveConstraintsFrom, 71, 168, 2, R2.attr.com_facebook_style, 160, R2.attr.circleCrop, 145, R2.attr.drawableTintMode, 79, 108, 82, 27, R2.attr.colorPrimary, R2.attr.com_facebook_object_type, R2.attr.colorControlNormal}, new int[]{52, 190, 88, 205, 109, 39, 176, 21, 155, R2.attr.constraints, R2.attr.drawableStartCompat, R2.attr.customNavigationLayout, 155, 21, 5, R2.attr.colorControlNormal, R2.attr.drawableTopCompat, 124, 12, R2.attr.com_facebook_horizontal_alignment, R2.attr.com_facebook_logout_text, 96, 50, R2.attr.constraintSetEnd}, new int[]{R2.attr.contrast, R2.attr.deltaPolarAngle, 43, 97, 71, 96, 103, R2.attr.colorPrimary, 37, R2.attr.checkboxStyle, R2.attr.colorControlActivated, 53, 75, 34, R2.attr.drawableRightCompat, 121, 17, 138, 110, R2.attr.coordinatorLayoutStyle, R2.attr.carousel_previousState, 136, 120, R2.attr.checkboxStyle, R2.attr.deriveConstraintsFrom, 168, 93, 255}, new int[]{R2.attr.drawPath, 127, R2.attr.dragDirection, R2.attr.customColorDrawableValue, 130, 250, 162, R2.attr.com_facebook_horizontal_alignment, 102, 120, 84, R2.attr.com_facebook_confirm_logout, R2.attr.customDimension, R2.attr.drawableStartCompat, 80, R2.attr.com_facebook_is_cropped, R2.attr.defaultQueryHint, 18, 2, 4, 68, 33, 101, 137, 95, 119, 115, 44, R2.attr.colorPrimaryDark, R2.attr.com_facebook_logout_text, 59, 25, R2.attr.customReference, 98, 81, 112}, new int[]{77, R2.attr.constraintSetEnd, 137, 31, 19, 38, 22, R2.attr.circleCrop, R2.attr.drawableEndCompat, 105, 122, 2, R2.attr.drawPath, 133, R2.attr.dragDirection, 8, R2.attr.colorPrimaryDark, 95, 100, 9, 167, 105, R2.attr.crossfade, 111, 57, 121, 21, 1, R2.attr.drawableTintMode, 57, 54, 101, R2.attr.drawableLeftCompat, 202, 69, 50, R2.attr.checkMarkTintMode, 177, R2.attr.customStringValue, 5, 9, 5}, new int[]{R2.attr.drawPath, 132, R2.attr.colorControlNormal, R2.attr.customNavigationLayout, 96, 32, 117, 22, R2.attr.divider, 133, R2.attr.divider, R2.attr.deltaPolarAngle, 205, R2.attr.com_facebook_style, R2.attr.displayOptions, 87, R2.attr.constraintRotate, 106, 16, 147, 118, 23, 37, 90, R2.attr.colorControlActivated, 205, 131, 88, 120, 100, 66, 138, R2.attr.com_facebook_object_type, R2.attr.dividerPadding, 82, 44, 176, 87, R2.attr.com_facebook_preset_size, 147, 160, R2.attr.colorPrimaryDark, 69, R2.attr.coordinatorLayoutStyle, 92, R2.attr.drawableTintMode, R2.attr.customReference, 19}, new int[]{R2.attr.colorPrimaryDark, 9, R2.attr.customNavigationLayout, R2.attr.divider, 12, 17, R2.attr.customDimension, R2.attr.contentPaddingLeft, 100, 29, R2.attr.colorPrimaryDark, R2.attr.colorControlActivated, R2.attr.defaultState, R2.attr.constraintSet, R2.attr.currentState, R2.attr.dialogPreferredPadding, R2.attr.checkMarkTintMode, R2.attr.circularflow_viewCenter, 36, R2.attr.customNavigationLayout, 38, 200, 132, 54, R2.attr.defaultDuration, 146, R2.attr.customColorDrawableValue, R2.attr.dialogCornerRadius, 117, 203, 29, R2.attr.deltaPolarRadius, 144, R2.attr.divider, 22, R2.attr.checkMarkTintMode, 201, 117, 62, 207, 164, 13, 137, R2.attr.drawPath, 127, 67, R2.attr.drawableEndCompat, 28, 155, 43, 203, 107, R2.attr.deriveConstraintsFrom, 53, R2.attr.carousel_touchUp_dampeningFactor, 46}, new int[]{R2.attr.dragDirection, 93, 169, 50, 144, R2.attr.contentPaddingTop, 39, 118, 202, R2.attr.com_facebook_style, 201, R2.attr.com_facebook_tooltip_mode, R2.attr.carousel_touchUp_dampeningFactor, 108, R2.attr.constraint_referenced_tags, 37, R2.attr.com_facebook_object_id, 112, R2.attr.cardViewStyle, R2.attr.defaultState, R2.attr.drawPath, 63, R2.attr.constraints, 190, 250, 106, R2.attr.com_facebook_object_id, R2.attr.customFloatValue, R2.attr.colorPrimaryDark, 64, 114, 71, 161, 44, 147, 6, 27, R2.attr.customColorDrawableValue, 51, 63, 87, 10, 40, 130, R2.attr.com_facebook_style, 17, 163, 31, 176, R2.attr.colorControlActivated, 4, 107, R2.attr.deltaPolarRadius, 7, 94, 166, R2.attr.customPixelDimension, 124, 86, 47, 11, 204}, new int[]{R2.attr.customDimension, R2.attr.defaultDuration, R2.attr.colorError, 89, R2.attr.drawableStartCompat, 149, R2.attr.circularflow_viewCenter, 56, 89, 33, 147, R2.attr.dragThreshold, R2.attr.circleRadius, 36, 73, 127, R2.attr.coordinatorLayoutStyle, 136, R2.attr.drawableLeftCompat, R2.attr.com_facebook_foreground_color, R2.attr.dialogCornerRadius, R2.attr.constraints, R2.attr.circularflow_radiusInDP, 177, 68, 122, 93, R2.attr.coordinatorLayoutStyle, 15, 160, R2.attr.dateFormat, R2.attr.dialogTheme, 66, R2.attr.carousel_infinite, R2.attr.circleCrop, R2.attr.com_facebook_object_id, 202, 167, R2.attr.com_facebook_confirm_logout, 25, R2.attr.customDimension, R2.attr.deltaPolarRadius, 96, R2.attr.contentPaddingTop, R2.attr.deltaPolarAngle, 136, R2.attr.customNavigationLayout, R2.attr.dividerHorizontal, R2.attr.com_facebook_horizontal_alignment, R2.attr.dividerVertical, 59, 52, R2.attr.colorControlNormal, 25, 49, R2.attr.deltaPolarRadius, R2.attr.contrast, R2.attr.com_facebook_tooltip_mode, 64, 54, 108, R2.attr.circleCrop, 132, 63, 96, 103, 82, R2.attr.com_facebook_object_type}};
    private static final int[] LOG = new int[256];
    private static final int[] ALOG = new int[255];

    static {
        int i = 1;
        for (int i2 = 0; i2 < 255; i2++) {
            ALOG[i2] = i;
            LOG[i] = i2;
            i <<= 1;
            if (i >= 256) {
                i ^= 301;
            }
        }
    }

    private ErrorCorrection() {
    }

    public static String encodeECC200(String str, SymbolInfo symbolInfo) {
        if (str.length() != symbolInfo.getDataCapacity()) {
            throw new IllegalArgumentException("The number of codewords does not match the selected symbol");
        }
        StringBuilder sb = new StringBuilder(symbolInfo.getDataCapacity() + symbolInfo.getErrorCodewords());
        sb.append(str);
        int interleavedBlockCount = symbolInfo.getInterleavedBlockCount();
        if (interleavedBlockCount == 1) {
            sb.append(createECCBlock(str, symbolInfo.getErrorCodewords()));
        } else {
            sb.setLength(sb.capacity());
            int[] iArr = new int[interleavedBlockCount];
            int[] iArr2 = new int[interleavedBlockCount];
            int i = 0;
            while (i < interleavedBlockCount) {
                int i2 = i + 1;
                iArr[i] = symbolInfo.getDataLengthForInterleavedBlock(i2);
                iArr2[i] = symbolInfo.getErrorLengthForInterleavedBlock(i2);
                i = i2;
            }
            for (int i3 = 0; i3 < interleavedBlockCount; i3++) {
                StringBuilder sb2 = new StringBuilder(iArr[i3]);
                for (int i4 = i3; i4 < symbolInfo.getDataCapacity(); i4 += interleavedBlockCount) {
                    sb2.append(str.charAt(i4));
                }
                String strCreateECCBlock = createECCBlock(sb2.toString(), iArr2[i3]);
                int i5 = 0;
                int i6 = i3;
                while (i6 < iArr2[i3] * interleavedBlockCount) {
                    sb.setCharAt(symbolInfo.getDataCapacity() + i6, strCreateECCBlock.charAt(i5));
                    i6 += interleavedBlockCount;
                    i5++;
                }
            }
        }
        return sb.toString();
    }

    private static String createECCBlock(CharSequence charSequence, int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = FACTOR_SETS;
            if (i2 >= iArr.length) {
                i2 = -1;
                break;
            }
            if (iArr[i2] == i) {
                break;
            }
            i2++;
        }
        if (i2 < 0) {
            throw new IllegalArgumentException("Illegal number of error correction codewords specified: ".concat(String.valueOf(i)));
        }
        int[] iArr2 = FACTORS[i2];
        char[] cArr = new char[i];
        for (int i3 = 0; i3 < i; i3++) {
            cArr[i3] = 0;
        }
        for (int i4 = 0; i4 < charSequence.length(); i4++) {
            int i5 = i - 1;
            int iCharAt = cArr[i5] ^ charSequence.charAt(i4);
            while (i5 > 0) {
                if (iCharAt != 0 && iArr2[i5] != 0) {
                    char c = cArr[i5 - 1];
                    int[] iArr3 = ALOG;
                    int[] iArr4 = LOG;
                    cArr[i5] = (char) (c ^ iArr3[(iArr4[iCharAt] + iArr4[iArr2[i5]]) % 255]);
                } else {
                    cArr[i5] = cArr[i5 - 1];
                }
                i5--;
            }
            if (iCharAt != 0 && iArr2[0] != 0) {
                int[] iArr5 = ALOG;
                int[] iArr6 = LOG;
                cArr[0] = (char) iArr5[(iArr6[iCharAt] + iArr6[iArr2[0]]) % 255];
            } else {
                cArr[0] = 0;
            }
        }
        char[] cArr2 = new char[i];
        for (int i6 = 0; i6 < i; i6++) {
            cArr2[i6] = cArr[(i - i6) - 1];
        }
        return String.valueOf(cArr2);
    }
}
