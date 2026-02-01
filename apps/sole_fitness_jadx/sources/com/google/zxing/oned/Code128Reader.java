package com.google.zxing.oned;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.ChecksumException;
import com.google.zxing.DecodeHintType;
import com.google.zxing.FormatException;
import com.google.zxing.NotFoundException;
import com.google.zxing.Result;
import com.google.zxing.ResultPoint;
import com.google.zxing.common.BitArray;
import java.util.ArrayList;
import java.util.Map;

/* loaded from: classes2.dex */
public final class Code128Reader extends OneDReader {
    private static final int CODE_CODE_A = 101;
    private static final int CODE_CODE_B = 100;
    private static final int CODE_CODE_C = 99;
    private static final int CODE_FNC_1 = 102;
    private static final int CODE_FNC_2 = 97;
    private static final int CODE_FNC_3 = 96;
    private static final int CODE_FNC_4_A = 101;
    private static final int CODE_FNC_4_B = 100;
    static final int[][] CODE_PATTERNS = {new int[]{2, 1, 2, 2, 2, 2}, new int[]{2, 2, 2, 1, 2, 2}, new int[]{2, 2, 2, 2, 2, 1}, new int[]{1, 2, 1, 2, 2, 3}, new int[]{1, 2, 1, 3, 2, 2}, new int[]{1, 3, 1, 2, 2, 2}, new int[]{1, 2, 2, 2, 1, 3}, new int[]{1, 2, 2, 3, 1, 2}, new int[]{1, 3, 2, 2, 1, 2}, new int[]{2, 2, 1, 2, 1, 3}, new int[]{2, 2, 1, 3, 1, 2}, new int[]{2, 3, 1, 2, 1, 2}, new int[]{1, 1, 2, 2, 3, 2}, new int[]{1, 2, 2, 1, 3, 2}, new int[]{1, 2, 2, 2, 3, 1}, new int[]{1, 1, 3, 2, 2, 2}, new int[]{1, 2, 3, 1, 2, 2}, new int[]{1, 2, 3, 2, 2, 1}, new int[]{2, 2, 3, 2, 1, 1}, new int[]{2, 2, 1, 1, 3, 2}, new int[]{2, 2, 1, 2, 3, 1}, new int[]{2, 1, 3, 2, 1, 2}, new int[]{2, 2, 3, 1, 1, 2}, new int[]{3, 1, 2, 1, 3, 1}, new int[]{3, 1, 1, 2, 2, 2}, new int[]{3, 2, 1, 1, 2, 2}, new int[]{3, 2, 1, 2, 2, 1}, new int[]{3, 1, 2, 2, 1, 2}, new int[]{3, 2, 2, 1, 1, 2}, new int[]{3, 2, 2, 2, 1, 1}, new int[]{2, 1, 2, 1, 2, 3}, new int[]{2, 1, 2, 3, 2, 1}, new int[]{2, 3, 2, 1, 2, 1}, new int[]{1, 1, 1, 3, 2, 3}, new int[]{1, 3, 1, 1, 2, 3}, new int[]{1, 3, 1, 3, 2, 1}, new int[]{1, 1, 2, 3, 1, 3}, new int[]{1, 3, 2, 1, 1, 3}, new int[]{1, 3, 2, 3, 1, 1}, new int[]{2, 1, 1, 3, 1, 3}, new int[]{2, 3, 1, 1, 1, 3}, new int[]{2, 3, 1, 3, 1, 1}, new int[]{1, 1, 2, 1, 3, 3}, new int[]{1, 1, 2, 3, 3, 1}, new int[]{1, 3, 2, 1, 3, 1}, new int[]{1, 1, 3, 1, 2, 3}, new int[]{1, 1, 3, 3, 2, 1}, new int[]{1, 3, 3, 1, 2, 1}, new int[]{3, 1, 3, 1, 2, 1}, new int[]{2, 1, 1, 3, 3, 1}, new int[]{2, 3, 1, 1, 3, 1}, new int[]{2, 1, 3, 1, 1, 3}, new int[]{2, 1, 3, 3, 1, 1}, new int[]{2, 1, 3, 1, 3, 1}, new int[]{3, 1, 1, 1, 2, 3}, new int[]{3, 1, 1, 3, 2, 1}, new int[]{3, 3, 1, 1, 2, 1}, new int[]{3, 1, 2, 1, 1, 3}, new int[]{3, 1, 2, 3, 1, 1}, new int[]{3, 3, 2, 1, 1, 1}, new int[]{3, 1, 4, 1, 1, 1}, new int[]{2, 2, 1, 4, 1, 1}, new int[]{4, 3, 1, 1, 1, 1}, new int[]{1, 1, 1, 2, 2, 4}, new int[]{1, 1, 1, 4, 2, 2}, new int[]{1, 2, 1, 1, 2, 4}, new int[]{1, 2, 1, 4, 2, 1}, new int[]{1, 4, 1, 1, 2, 2}, new int[]{1, 4, 1, 2, 2, 1}, new int[]{1, 1, 2, 2, 1, 4}, new int[]{1, 1, 2, 4, 1, 2}, new int[]{1, 2, 2, 1, 1, 4}, new int[]{1, 2, 2, 4, 1, 1}, new int[]{1, 4, 2, 1, 1, 2}, new int[]{1, 4, 2, 2, 1, 1}, new int[]{2, 4, 1, 2, 1, 1}, new int[]{2, 2, 1, 1, 1, 4}, new int[]{4, 1, 3, 1, 1, 1}, new int[]{2, 4, 1, 1, 1, 2}, new int[]{1, 3, 4, 1, 1, 1}, new int[]{1, 1, 1, 2, 4, 2}, new int[]{1, 2, 1, 1, 4, 2}, new int[]{1, 2, 1, 2, 4, 1}, new int[]{1, 1, 4, 2, 1, 2}, new int[]{1, 2, 4, 1, 1, 2}, new int[]{1, 2, 4, 2, 1, 1}, new int[]{4, 1, 1, 2, 1, 2}, new int[]{4, 2, 1, 1, 1, 2}, new int[]{4, 2, 1, 2, 1, 1}, new int[]{2, 1, 2, 1, 4, 1}, new int[]{2, 1, 4, 1, 2, 1}, new int[]{4, 1, 2, 1, 2, 1}, new int[]{1, 1, 1, 1, 4, 3}, new int[]{1, 1, 1, 3, 4, 1}, new int[]{1, 3, 1, 1, 4, 1}, new int[]{1, 1, 4, 1, 1, 3}, new int[]{1, 1, 4, 3, 1, 1}, new int[]{4, 1, 1, 1, 1, 3}, new int[]{4, 1, 1, 3, 1, 1}, new int[]{1, 1, 3, 1, 4, 1}, new int[]{1, 1, 4, 1, 3, 1}, new int[]{3, 1, 1, 1, 4, 1}, new int[]{4, 1, 1, 1, 3, 1}, new int[]{2, 1, 1, 4, 1, 2}, new int[]{2, 1, 1, 2, 1, 4}, new int[]{2, 1, 1, 2, 3, 2}, new int[]{2, 3, 3, 1, 1, 1, 2}};
    private static final int CODE_SHIFT = 98;
    private static final int CODE_START_A = 103;
    private static final int CODE_START_B = 104;
    private static final int CODE_START_C = 105;
    private static final int CODE_STOP = 106;
    private static final float MAX_AVG_VARIANCE = 0.25f;
    private static final float MAX_INDIVIDUAL_VARIANCE = 0.7f;

    private static int[] findStartPattern(BitArray bitArray) throws NotFoundException {
        int size = bitArray.getSize();
        int nextSet = bitArray.getNextSet(0);
        int[] iArr = new int[6];
        boolean z = false;
        int i = 0;
        int i2 = nextSet;
        while (nextSet < size) {
            if (bitArray.get(nextSet) != z) {
                iArr[i] = iArr[i] + 1;
            } else {
                if (i == 5) {
                    float f = MAX_AVG_VARIANCE;
                    int i3 = -1;
                    for (int i4 = 103; i4 <= 105; i4++) {
                        float fPatternMatchVariance = patternMatchVariance(iArr, CODE_PATTERNS[i4], MAX_INDIVIDUAL_VARIANCE);
                        if (fPatternMatchVariance < f) {
                            i3 = i4;
                            f = fPatternMatchVariance;
                        }
                    }
                    if (i3 >= 0 && bitArray.isRange(Math.max(0, i2 - ((nextSet - i2) / 2)), i2, false)) {
                        return new int[]{i2, nextSet, i3};
                    }
                    i2 += iArr[0] + iArr[1];
                    int i5 = i - 1;
                    System.arraycopy(iArr, 2, iArr, 0, i5);
                    iArr[i5] = 0;
                    iArr[i] = 0;
                    i--;
                } else {
                    i++;
                }
                iArr[i] = 1;
                z = !z;
            }
            nextSet++;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    private static int decodeCode(BitArray bitArray, int[] iArr, int i) throws NotFoundException {
        recordPattern(bitArray, i, iArr);
        float f = MAX_AVG_VARIANCE;
        int i2 = -1;
        int i3 = 0;
        while (true) {
            int[][] iArr2 = CODE_PATTERNS;
            if (i3 >= iArr2.length) {
                break;
            }
            float fPatternMatchVariance = patternMatchVariance(iArr, iArr2[i3], MAX_INDIVIDUAL_VARIANCE);
            if (fPatternMatchVariance < f) {
                i2 = i3;
                f = fPatternMatchVariance;
            }
            i3++;
        }
        if (i2 >= 0) {
            return i2;
        }
        throw NotFoundException.getNotFoundInstance();
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:54:0x00e2, code lost:
    
        if (r9 != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x012a, code lost:
    
        if (r9 != false) goto L80;
     */
    /* JADX WARN: Code restructure failed: missing block: B:80:0x012c, code lost:
    
        r3 = false;
     */
    /* JADX WARN: Removed duplicated region for block: B:17:0x005a  */
    /* JADX WARN: Removed duplicated region for block: B:82:0x0131 A[PHI: r17
      0x0131: PHI (r17v10 boolean) = (r17v6 boolean), (r17v16 boolean) binds: [B:67:0x010a, B:43:0x00c2] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:85:0x013b A[PHI: r17
      0x013b: PHI (r17v8 boolean) = (r17v6 boolean), (r17v16 boolean) binds: [B:66:0x0108, B:42:0x00c0] A[DONT_GENERATE, DONT_INLINE]] */
    @Override // com.google.zxing.oned.OneDReader
    /*
        Code decompiled incorrectly, please refer to instructions dump.
    */
    public Result decodeRow(int i, BitArray bitArray, Map<DecodeHintType, ?> map) throws NotFoundException, ChecksumException, FormatException {
        char c;
        char c2;
        boolean z;
        boolean z2 = false;
        boolean z3 = map != null && map.containsKey(DecodeHintType.ASSUME_GS1);
        int[] iArrFindStartPattern = findStartPattern(bitArray);
        int i2 = iArrFindStartPattern[2];
        ArrayList arrayList = new ArrayList(20);
        arrayList.add(Byte.valueOf((byte) i2));
        switch (i2) {
            case 103:
                c = 'e';
                break;
            case 104:
                c = 'd';
                break;
            case 105:
                c = 'c';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        StringBuilder sb = new StringBuilder(20);
        int i3 = 6;
        int[] iArr = new int[6];
        boolean z4 = false;
        boolean z5 = false;
        boolean z6 = false;
        int i4 = 0;
        int i5 = 0;
        int i6 = 0;
        boolean z7 = true;
        char c3 = c;
        int i7 = iArrFindStartPattern[0];
        int i8 = iArrFindStartPattern[1];
        char c4 = c3;
        while (!z5) {
            int iDecodeCode = decodeCode(bitArray, iArr, i8);
            arrayList.add(Byte.valueOf((byte) iDecodeCode));
            if (iDecodeCode != 106) {
                z7 = true;
            }
            if (iDecodeCode != 106) {
                i5++;
                i2 += i5 * iDecodeCode;
            }
            int i9 = i8;
            for (int i10 = 0; i10 < i3; i10++) {
                i9 += iArr[i10];
            }
            switch (iDecodeCode) {
                case 103:
                case 104:
                case 105:
                    throw FormatException.getFormatInstance();
                default:
                    switch (c4) {
                        case 'c':
                            c2 = 'd';
                            if (iDecodeCode >= 100) {
                                if (iDecodeCode != 106) {
                                    z7 = false;
                                }
                                if (iDecodeCode != 106) {
                                    switch (iDecodeCode) {
                                        case 100:
                                            c4 = 'd';
                                            break;
                                        case 101:
                                            z = false;
                                            c4 = 'e';
                                            break;
                                        case 102:
                                            if (z3) {
                                                if (sb.length() == 0) {
                                                    sb.append("]C1");
                                                    break;
                                                } else {
                                                    sb.append((char) 29);
                                                    break;
                                                }
                                            }
                                            break;
                                    }
                                } else {
                                    z = false;
                                    z5 = true;
                                    break;
                                }
                            } else {
                                if (iDecodeCode < 10) {
                                    sb.append('0');
                                }
                                sb.append(iDecodeCode);
                            }
                            z = false;
                            break;
                        case 'd':
                            if (iDecodeCode < 96) {
                                if (z4 == z2) {
                                    sb.append((char) (iDecodeCode + 32));
                                } else {
                                    sb.append((char) (iDecodeCode + 32 + 128));
                                }
                                z = false;
                                z4 = false;
                                c2 = 'd';
                                break;
                            } else {
                                if (iDecodeCode != 106) {
                                    z7 = false;
                                }
                                if (iDecodeCode != 106) {
                                    switch (iDecodeCode) {
                                        case 98:
                                            z = true;
                                            c2 = 'd';
                                            c4 = 'e';
                                            break;
                                        case 99:
                                            z = false;
                                            c2 = 'd';
                                            c4 = 'c';
                                            break;
                                        case 100:
                                            if (z2 || !z4) {
                                                if (z2) {
                                                }
                                                z = false;
                                                z4 = true;
                                                c2 = 'd';
                                                break;
                                            }
                                            z2 = true;
                                            z = false;
                                            z4 = false;
                                            c2 = 'd';
                                            break;
                                        case 101:
                                            z = false;
                                            c2 = 'd';
                                            c4 = 'e';
                                            break;
                                        case 102:
                                            if (z3) {
                                                if (sb.length() == 0) {
                                                    sb.append("]C1");
                                                    break;
                                                } else {
                                                    sb.append((char) 29);
                                                    break;
                                                }
                                            }
                                            break;
                                    }
                                } else {
                                    z5 = true;
                                }
                                z = false;
                                c2 = 'd';
                            }
                            break;
                        case 'e':
                            if (iDecodeCode < 64) {
                                if (z4 == z2) {
                                    sb.append((char) (iDecodeCode + 32));
                                } else {
                                    sb.append((char) (iDecodeCode + 32 + 128));
                                }
                            } else if (iDecodeCode >= 96) {
                                if (iDecodeCode != 106) {
                                    z7 = false;
                                }
                                if (iDecodeCode != 106) {
                                    switch (iDecodeCode) {
                                        case 98:
                                            z = true;
                                            c2 = 'd';
                                            c4 = 'd';
                                            break;
                                        case 100:
                                            z = false;
                                            c2 = 'd';
                                            c4 = 'd';
                                            break;
                                        case 101:
                                            if (z2 || !z4) {
                                                if (z2) {
                                                }
                                                z = false;
                                                z4 = true;
                                                c2 = 'd';
                                                break;
                                            }
                                            z2 = true;
                                            break;
                                        case 102:
                                            if (z3) {
                                                if (sb.length() == 0) {
                                                    sb.append("]C1");
                                                    break;
                                                } else {
                                                    sb.append((char) 29);
                                                    break;
                                                }
                                            }
                                            break;
                                    }
                                }
                                z = false;
                                c2 = 'd';
                            } else if (z4 == z2) {
                                sb.append((char) (iDecodeCode - 64));
                            } else {
                                sb.append((char) (iDecodeCode + 64));
                            }
                            z = false;
                            z4 = false;
                            c2 = 'd';
                            break;
                        default:
                            c2 = 'd';
                            z = false;
                            break;
                    }
                    if (z6) {
                        c4 = c4 == 'e' ? c2 : 'e';
                    }
                    z6 = z;
                    i3 = 6;
                    i7 = i8;
                    i8 = i9;
                    i6 = i4;
                    i4 = iDecodeCode;
                    break;
            }
            while (!z5) {
            }
        }
        int i11 = i8 - i7;
        int nextUnset = bitArray.getNextUnset(i8);
        if (!bitArray.isRange(nextUnset, Math.min(bitArray.getSize(), ((nextUnset - i7) / 2) + nextUnset), false)) {
            throw NotFoundException.getNotFoundInstance();
        }
        int i12 = i6;
        if ((i2 - (i5 * i12)) % 103 != i12) {
            throw ChecksumException.getChecksumInstance();
        }
        int length = sb.length();
        if (length == 0) {
            throw NotFoundException.getNotFoundInstance();
        }
        if (length > 0 && z7) {
            if (c4 == 'c') {
                sb.delete(length - 2, length);
            } else {
                sb.delete(length - 1, length);
            }
        }
        float f = (iArrFindStartPattern[1] + iArrFindStartPattern[0]) / 2.0f;
        float f2 = i7 + (i11 / 2.0f);
        int size = arrayList.size();
        byte[] bArr = new byte[size];
        for (int i13 = 0; i13 < size; i13++) {
            bArr[i13] = ((Byte) arrayList.get(i13)).byteValue();
        }
        float f3 = i;
        return new Result(sb.toString(), bArr, new ResultPoint[]{new ResultPoint(f, f3), new ResultPoint(f2, f3)}, BarcodeFormat.CODE_128);
    }
}
