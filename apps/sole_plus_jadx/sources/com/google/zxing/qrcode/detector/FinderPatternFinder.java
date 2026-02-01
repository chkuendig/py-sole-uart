package com.google.zxing.qrcode.detector;

import com.google.zxing.DecodeHintType;
import com.google.zxing.NotFoundException;
import com.google.zxing.ResultPoint;
import com.google.zxing.ResultPointCallback;
import com.google.zxing.common.BitMatrix;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: classes5.dex */
public class FinderPatternFinder {
    private static final int CENTER_QUORUM = 2;
    protected static final int MAX_MODULES = 97;
    protected static final int MIN_SKIP = 3;
    private static final EstimatedModuleComparator moduleComparator = new EstimatedModuleComparator();
    private final int[] crossCheckStateCount;
    private boolean hasSkipped;
    private final BitMatrix image;
    private final List<FinderPattern> possibleCenters;
    private final ResultPointCallback resultPointCallback;

    public FinderPatternFinder(BitMatrix bitMatrix) {
        this(bitMatrix, null);
    }

    public FinderPatternFinder(BitMatrix bitMatrix, ResultPointCallback resultPointCallback) {
        this.image = bitMatrix;
        this.possibleCenters = new ArrayList();
        this.crossCheckStateCount = new int[5];
        this.resultPointCallback = resultPointCallback;
    }

    protected final BitMatrix getImage() {
        return this.image;
    }

    protected final List<FinderPattern> getPossibleCenters() {
        return this.possibleCenters;
    }

    final FinderPatternInfo find(Map<DecodeHintType, ?> map) throws NotFoundException {
        boolean z = map != null && map.containsKey(DecodeHintType.TRY_HARDER);
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i = (height * 3) / 388;
        if (i < 3 || z) {
            i = 3;
        }
        int[] iArr = new int[5];
        int i2 = i - 1;
        boolean zHaveMultiplyConfirmedCenters = false;
        while (i2 < height && !zHaveMultiplyConfirmedCenters) {
            doClearCounts(iArr);
            int i3 = 0;
            int i4 = 0;
            while (i3 < width) {
                if (this.image.get(i3, i2)) {
                    if ((i4 & 1) == 1) {
                        i4++;
                    }
                    iArr[i4] = iArr[i4] + 1;
                } else if ((i4 & 1) != 0) {
                    iArr[i4] = iArr[i4] + 1;
                } else if (i4 == 4) {
                    if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i2, i3)) {
                        if (this.hasSkipped) {
                            zHaveMultiplyConfirmedCenters = haveMultiplyConfirmedCenters();
                        } else {
                            int iFindRowSkip = findRowSkip();
                            int i5 = iArr[2];
                            if (iFindRowSkip > i5) {
                                i2 += (iFindRowSkip - i5) - 2;
                                i3 = width - 1;
                            }
                        }
                        doClearCounts(iArr);
                        i = 2;
                        i4 = 0;
                    } else {
                        doShiftCounts2(iArr);
                        i4 = 3;
                    }
                } else {
                    i4++;
                    iArr[i4] = iArr[i4] + 1;
                }
                i3++;
            }
            if (foundPatternCross(iArr) && handlePossibleCenter(iArr, i2, width)) {
                i = iArr[0];
                if (this.hasSkipped) {
                    zHaveMultiplyConfirmedCenters = haveMultiplyConfirmedCenters();
                }
            }
            i2 += i;
        }
        FinderPattern[] finderPatternArrSelectBestPatterns = selectBestPatterns();
        ResultPoint.orderBestPatterns(finderPatternArrSelectBestPatterns);
        return new FinderPatternInfo(finderPatternArrSelectBestPatterns);
    }

    private static float centerFromEnd(int[] iArr, int i) {
        return ((i - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    protected static boolean foundPatternCross(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = f / 2.0f;
        return Math.abs(f - ((float) iArr[0])) < f2 && Math.abs(f - ((float) iArr[1])) < f2 && Math.abs((f * 3.0f) - ((float) iArr[2])) < 3.0f * f2 && Math.abs(f - ((float) iArr[3])) < f2 && Math.abs(f - ((float) iArr[4])) < f2;
    }

    protected static boolean foundPatternDiagonal(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f = i / 7.0f;
        float f2 = f / 1.333f;
        return Math.abs(f - ((float) iArr[0])) < f2 && Math.abs(f - ((float) iArr[1])) < f2 && Math.abs((f * 3.0f) - ((float) iArr[2])) < 3.0f * f2 && Math.abs(f - ((float) iArr[3])) < f2 && Math.abs(f - ((float) iArr[4])) < f2;
    }

    private int[] getCrossCheckStateCount() {
        doClearCounts(this.crossCheckStateCount);
        return this.crossCheckStateCount;
    }

    @Deprecated
    protected final void clearCounts(int[] iArr) {
        doClearCounts(iArr);
    }

    @Deprecated
    protected final void shiftCounts2(int[] iArr) {
        doShiftCounts2(iArr);
    }

    protected static void doClearCounts(int[] iArr) {
        Arrays.fill(iArr, 0);
    }

    protected static void doShiftCounts2(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    private boolean crossCheckDiagonal(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i6 = 0;
        while (i >= i6 && i2 >= i6 && this.image.get(i2 - i6, i - i6)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i6++;
        }
        if (crossCheckStateCount[2] == 0) {
            return false;
        }
        while (i >= i6 && i2 >= i6 && !this.image.get(i2 - i6, i - i6)) {
            crossCheckStateCount[1] = crossCheckStateCount[1] + 1;
            i6++;
        }
        if (crossCheckStateCount[1] == 0) {
            return false;
        }
        while (i >= i6 && i2 >= i6 && this.image.get(i2 - i6, i - i6)) {
            crossCheckStateCount[0] = crossCheckStateCount[0] + 1;
            i6++;
        }
        if (crossCheckStateCount[0] == 0) {
            return false;
        }
        int height = this.image.getHeight();
        int width = this.image.getWidth();
        int i7 = 1;
        while (true) {
            int i8 = i + i7;
            if (i8 >= height || (i5 = i2 + i7) >= width || !this.image.get(i5, i8)) {
                break;
            }
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i7++;
        }
        while (true) {
            int i9 = i + i7;
            if (i9 >= height || (i4 = i2 + i7) >= width || this.image.get(i4, i9)) {
                break;
            }
            crossCheckStateCount[3] = crossCheckStateCount[3] + 1;
            i7++;
        }
        if (crossCheckStateCount[3] == 0) {
            return false;
        }
        while (true) {
            int i10 = i + i7;
            if (i10 >= height || (i3 = i2 + i7) >= width || !this.image.get(i3, i10)) {
                break;
            }
            crossCheckStateCount[4] = crossCheckStateCount[4] + 1;
            i7++;
        }
        if (crossCheckStateCount[4] == 0) {
            return false;
        }
        return foundPatternDiagonal(crossCheckStateCount);
    }

    private float crossCheckVertical(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        BitMatrix bitMatrix = this.image;
        int height = bitMatrix.getHeight();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i8 = i;
        while (i8 >= 0 && bitMatrix.get(i2, i8)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i8--;
        }
        if (i8 < 0) {
            return Float.NaN;
        }
        while (i8 >= 0 && !bitMatrix.get(i2, i8)) {
            int i9 = crossCheckStateCount[1];
            if (i9 > i3) {
                break;
            }
            crossCheckStateCount[1] = i9 + 1;
            i8--;
        }
        if (i8 >= 0 && crossCheckStateCount[1] <= i3) {
            while (i8 >= 0 && bitMatrix.get(i2, i8) && (i7 = crossCheckStateCount[0]) <= i3) {
                crossCheckStateCount[0] = i7 + 1;
                i8--;
            }
            if (crossCheckStateCount[0] > i3) {
                return Float.NaN;
            }
            int i10 = i + 1;
            while (i10 < height && bitMatrix.get(i2, i10)) {
                crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
                i10++;
            }
            if (i10 == height) {
                return Float.NaN;
            }
            while (i10 < height && !bitMatrix.get(i2, i10) && (i6 = crossCheckStateCount[3]) < i3) {
                crossCheckStateCount[3] = i6 + 1;
                i10++;
            }
            if (i10 != height && crossCheckStateCount[3] < i3) {
                while (i10 < height && bitMatrix.get(i2, i10) && (i5 = crossCheckStateCount[4]) < i3) {
                    crossCheckStateCount[4] = i5 + 1;
                    i10++;
                }
                int i11 = crossCheckStateCount[4];
                if (i11 < i3 && Math.abs(((((crossCheckStateCount[0] + crossCheckStateCount[1]) + crossCheckStateCount[2]) + crossCheckStateCount[3]) + i11) - i4) * 5 < i4 * 2 && foundPatternCross(crossCheckStateCount)) {
                    return centerFromEnd(crossCheckStateCount, i10);
                }
            }
        }
        return Float.NaN;
    }

    private float crossCheckHorizontal(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        BitMatrix bitMatrix = this.image;
        int width = bitMatrix.getWidth();
        int[] crossCheckStateCount = getCrossCheckStateCount();
        int i8 = i;
        while (i8 >= 0 && bitMatrix.get(i8, i2)) {
            crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
            i8--;
        }
        if (i8 < 0) {
            return Float.NaN;
        }
        while (i8 >= 0 && !bitMatrix.get(i8, i2)) {
            int i9 = crossCheckStateCount[1];
            if (i9 > i3) {
                break;
            }
            crossCheckStateCount[1] = i9 + 1;
            i8--;
        }
        if (i8 >= 0 && crossCheckStateCount[1] <= i3) {
            while (i8 >= 0 && bitMatrix.get(i8, i2) && (i7 = crossCheckStateCount[0]) <= i3) {
                crossCheckStateCount[0] = i7 + 1;
                i8--;
            }
            if (crossCheckStateCount[0] > i3) {
                return Float.NaN;
            }
            int i10 = i + 1;
            while (i10 < width && bitMatrix.get(i10, i2)) {
                crossCheckStateCount[2] = crossCheckStateCount[2] + 1;
                i10++;
            }
            if (i10 == width) {
                return Float.NaN;
            }
            while (i10 < width && !bitMatrix.get(i10, i2) && (i6 = crossCheckStateCount[3]) < i3) {
                crossCheckStateCount[3] = i6 + 1;
                i10++;
            }
            if (i10 != width && crossCheckStateCount[3] < i3) {
                while (i10 < width && bitMatrix.get(i10, i2) && (i5 = crossCheckStateCount[4]) < i3) {
                    crossCheckStateCount[4] = i5 + 1;
                    i10++;
                }
                int i11 = crossCheckStateCount[4];
                if (i11 < i3 && Math.abs(((((crossCheckStateCount[0] + crossCheckStateCount[1]) + crossCheckStateCount[2]) + crossCheckStateCount[3]) + i11) - i4) * 5 < i4 && foundPatternCross(crossCheckStateCount)) {
                    return centerFromEnd(crossCheckStateCount, i10);
                }
            }
        }
        return Float.NaN;
    }

    @Deprecated
    protected final boolean handlePossibleCenter(int[] iArr, int i, int i2, boolean z) {
        return handlePossibleCenter(iArr, i, i2);
    }

    protected final boolean handlePossibleCenter(int[] iArr, int i, int i2) {
        int i3 = 0;
        int i4 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int iCenterFromEnd = (int) centerFromEnd(iArr, i2);
        float fCrossCheckVertical = crossCheckVertical(i, iCenterFromEnd, iArr[2], i4);
        if (!Float.isNaN(fCrossCheckVertical)) {
            int i5 = (int) fCrossCheckVertical;
            float fCrossCheckHorizontal = crossCheckHorizontal(iCenterFromEnd, i5, iArr[2], i4);
            if (!Float.isNaN(fCrossCheckHorizontal) && crossCheckDiagonal(i5, (int) fCrossCheckHorizontal)) {
                float f = i4 / 7.0f;
                while (true) {
                    if (i3 < this.possibleCenters.size()) {
                        FinderPattern finderPattern = this.possibleCenters.get(i3);
                        if (finderPattern.aboutEquals(f, fCrossCheckVertical, fCrossCheckHorizontal)) {
                            this.possibleCenters.set(i3, finderPattern.combineEstimate(fCrossCheckVertical, fCrossCheckHorizontal, f));
                            break;
                        }
                        i3++;
                    } else {
                        FinderPattern finderPattern2 = new FinderPattern(fCrossCheckHorizontal, fCrossCheckVertical, f);
                        this.possibleCenters.add(finderPattern2);
                        ResultPointCallback resultPointCallback = this.resultPointCallback;
                        if (resultPointCallback != null) {
                            resultPointCallback.foundPossibleResultPoint(finderPattern2);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    private int findRowSkip() {
        if (this.possibleCenters.size() <= 1) {
            return 0;
        }
        FinderPattern finderPattern = null;
        for (FinderPattern finderPattern2 : this.possibleCenters) {
            if (finderPattern2.getCount() >= 2) {
                if (finderPattern != null) {
                    this.hasSkipped = true;
                    return ((int) (Math.abs(finderPattern.getX() - finderPattern2.getX()) - Math.abs(finderPattern.getY() - finderPattern2.getY()))) / 2;
                }
                finderPattern = finderPattern2;
            }
        }
        return 0;
    }

    private boolean haveMultiplyConfirmedCenters() {
        int size = this.possibleCenters.size();
        float fAbs = 0.0f;
        int i = 0;
        float estimatedModuleSize = 0.0f;
        for (FinderPattern finderPattern : this.possibleCenters) {
            if (finderPattern.getCount() >= 2) {
                i++;
                estimatedModuleSize += finderPattern.getEstimatedModuleSize();
            }
        }
        if (i < 3) {
            return false;
        }
        float f = estimatedModuleSize / size;
        Iterator<FinderPattern> it = this.possibleCenters.iterator();
        while (it.hasNext()) {
            fAbs += Math.abs(it.next().getEstimatedModuleSize() - f);
        }
        return fAbs <= estimatedModuleSize * 0.05f;
    }

    private static double squaredDistance(FinderPattern finderPattern, FinderPattern finderPattern2) {
        double x = finderPattern.getX() - finderPattern2.getX();
        double y = finderPattern.getY() - finderPattern2.getY();
        return (x * x) + (y * y);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00bd  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x00c5 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private com.google.zxing.qrcode.detector.FinderPattern[] selectBestPatterns() throws com.google.zxing.NotFoundException {
        /*
            r26 = this;
            r0 = r26
            java.util.List<com.google.zxing.qrcode.detector.FinderPattern> r1 = r0.possibleCenters
            int r1 = r1.size()
            r2 = 3
            if (r1 < r2) goto Ld7
            java.util.List<com.google.zxing.qrcode.detector.FinderPattern> r1 = r0.possibleCenters
            com.google.zxing.qrcode.detector.FinderPatternFinder$EstimatedModuleComparator r3 = com.google.zxing.qrcode.detector.FinderPatternFinder.moduleComparator
            r1.sort(r3)
            com.google.zxing.qrcode.detector.FinderPattern[] r1 = new com.google.zxing.qrcode.detector.FinderPattern[r2]
            r2 = 0
            r5 = r2
            r6 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
        L1b:
            java.util.List<com.google.zxing.qrcode.detector.FinderPattern> r8 = r0.possibleCenters
            int r8 = r8.size()
            r9 = 2
            int r8 = r8 - r9
            if (r5 >= r8) goto Lc8
            java.util.List<com.google.zxing.qrcode.detector.FinderPattern> r8 = r0.possibleCenters
            java.lang.Object r8 = r8.get(r5)
            com.google.zxing.qrcode.detector.FinderPattern r8 = (com.google.zxing.qrcode.detector.FinderPattern) r8
            float r10 = r8.getEstimatedModuleSize()
            int r5 = r5 + 1
            r11 = r5
        L34:
            java.util.List<com.google.zxing.qrcode.detector.FinderPattern> r12 = r0.possibleCenters
            int r12 = r12.size()
            r13 = 1
            int r12 = r12 - r13
            if (r11 >= r12) goto L1b
            java.util.List<com.google.zxing.qrcode.detector.FinderPattern> r12 = r0.possibleCenters
            java.lang.Object r12 = r12.get(r11)
            com.google.zxing.qrcode.detector.FinderPattern r12 = (com.google.zxing.qrcode.detector.FinderPattern) r12
            double r14 = squaredDistance(r8, r12)
            int r11 = r11 + 1
            r3 = r11
        L4d:
            java.util.List<com.google.zxing.qrcode.detector.FinderPattern> r4 = r0.possibleCenters
            int r4 = r4.size()
            if (r3 >= r4) goto L34
            java.util.List<com.google.zxing.qrcode.detector.FinderPattern> r4 = r0.possibleCenters
            java.lang.Object r4 = r4.get(r3)
            com.google.zxing.qrcode.detector.FinderPattern r4 = (com.google.zxing.qrcode.detector.FinderPattern) r4
            float r16 = r4.getEstimatedModuleSize()
            r17 = 1068708659(0x3fb33333, float:1.4)
            float r17 = r17 * r10
            int r16 = (r16 > r17 ? 1 : (r16 == r17 ? 0 : -1))
            if (r16 > 0) goto Lc5
            double r16 = squaredDistance(r12, r4)
            double r18 = squaredDistance(r8, r4)
            int r20 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r20 >= 0) goto L8d
            int r20 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r20 <= 0) goto L84
            int r20 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r20 >= 0) goto L81
            r20 = r14
            goto La5
        L81:
            r20 = r18
            goto L99
        L84:
            r20 = r14
            r24 = r16
            r16 = r18
            r18 = r24
            goto La5
        L8d:
            int r20 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r20 >= 0) goto L9f
            int r20 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r20 >= 0) goto L9c
            r20 = r16
            r16 = r18
        L99:
            r18 = r14
            goto La5
        L9c:
            r20 = r16
            goto La3
        L9f:
            r20 = r18
            r18 = r16
        La3:
            r16 = r14
        La5:
            r22 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r18 = r18 * r22
            double r18 = r16 - r18
            double r18 = java.lang.Math.abs(r18)
            double r20 = r20 * r22
            double r16 = r16 - r20
            double r16 = java.lang.Math.abs(r16)
            double r18 = r18 + r16
            int r16 = (r18 > r6 ? 1 : (r18 == r6 ? 0 : -1))
            if (r16 >= 0) goto Lc5
            r1[r2] = r8
            r1[r13] = r12
            r1[r9] = r4
            r6 = r18
        Lc5:
            int r3 = r3 + 1
            goto L4d
        Lc8:
            r3 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
            int r2 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r2 == 0) goto Ld2
            return r1
        Ld2:
            com.google.zxing.NotFoundException r1 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r1
        Ld7:
            com.google.zxing.NotFoundException r1 = com.google.zxing.NotFoundException.getNotFoundInstance()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.zxing.qrcode.detector.FinderPatternFinder.selectBestPatterns():com.google.zxing.qrcode.detector.FinderPattern[]");
    }

    private static final class EstimatedModuleComparator implements Serializable, Comparator<FinderPattern> {
        private EstimatedModuleComparator() {
        }

        @Override // java.util.Comparator
        public int compare(FinderPattern finderPattern, FinderPattern finderPattern2) {
            return Float.compare(finderPattern.getEstimatedModuleSize(), finderPattern2.getEstimatedModuleSize());
        }
    }
}
