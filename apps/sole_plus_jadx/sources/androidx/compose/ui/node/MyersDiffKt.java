package androidx.compose.ui.node;

import com.android.SdkConstants;
import com.sun.jna.Callback;
import kotlin.Metadata;

/* compiled from: MyersDiff.kt */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0015\n\u0002\b\u0012\u001a \u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0002\u001a\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u00012\u0006\u0010\n\u001a\u00020\u0006H\u0002\u001a \u0010\u000b\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u0006H\u0000\u001aO\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u0017\u0010\u0018\u001aW\u0010\u0012\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001a\u0010\u001b\u001aW\u0010\u0014\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u0010\u001a\u00020\u00032\u0006\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0016H\u0002¢\u0006\u0004\b\u001c\u0010\u001b\u001a\r\u0010\u001d\u001a\u00020\u0003*\u00020\rH\u0082\b\u001a8\u0010\u001e\u001a\u00020\b2\u0006\u0010\u001f\u001a\u00020\u00032\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u00032\u0006\u0010#\u001a\u00020\r2\u0006\u0010$\u001a\u00020\u0016H\u0000\u001a\u001c\u0010%\u001a\u00020\b*\u00020\u00162\u0006\u0010&\u001a\u00020\u00032\u0006\u0010'\u001a\u00020\u0003H\u0002¨\u0006("}, d2 = {"calculateDiff", "Landroidx/compose/ui/node/IntStack;", "oldSize", "", "newSize", "cb", "Landroidx/compose/ui/node/DiffCallback;", "applyDiff", "", "diagonals", Callback.METHOD_NAME, "executeDiff", "midPoint", "", "oldStart", "oldEnd", "newStart", "newEnd", "forward", "Landroidx/compose/ui/node/CenteredArray;", "backward", "snake", "", "midPoint-q5eDKzI", "(IIIILandroidx/compose/ui/node/DiffCallback;[I[I[I)Z", "d", "forward-4l5_RBY", "(IIIILandroidx/compose/ui/node/DiffCallback;[I[II[I)Z", "backward-4l5_RBY", "toInt", "fillSnake", SdkConstants.ATTR_START_X, SdkConstants.ATTR_START_Y, SdkConstants.ATTR_END_X, SdkConstants.ATTR_END_Y, "reverse", "data", "swap", "i", "j", "ui_release"}, k = 2, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class MyersDiffKt {
    private static final int toInt(boolean z) {
        return z ? 1 : 0;
    }

    private static final IntStack calculateDiff(int i, int i2, DiffCallback diffCallback) {
        int i3 = ((i + i2) + 1) / 2;
        IntStack intStack = new IntStack(i3 * 3);
        IntStack intStack2 = new IntStack(i3 * 4);
        intStack2.pushRange(0, i, 0, i2);
        int i4 = (i3 * 2) + 1;
        int[] iArrM6088constructorimpl = CenteredArray.m6088constructorimpl(new int[i4]);
        int[] iArrM6088constructorimpl2 = CenteredArray.m6088constructorimpl(new int[i4]);
        int[] iArrM6315constructorimpl = Snake.m6315constructorimpl(new int[5]);
        while (intStack2.isNotEmpty()) {
            int iPop = intStack2.pop();
            int iPop2 = intStack2.pop();
            int iPop3 = intStack2.pop();
            int iPop4 = intStack2.pop();
            int[] iArr = iArrM6315constructorimpl;
            if (m6207midPointq5eDKzI(iPop4, iPop3, iPop2, iPop, diffCallback, iArrM6088constructorimpl, iArrM6088constructorimpl2, iArr)) {
                if (Math.min(iArr[2] - iArr[0], iArr[3] - iArr[1]) > 0) {
                    Snake.m6313addDiagonalToStackimpl(iArr, intStack);
                }
                intStack2.pushRange(iPop4, iArr[0], iPop2, iArr[1]);
                intStack2.pushRange(iArr[2], iPop3, iArr[3], iPop);
                iArrM6315constructorimpl = iArr;
            } else {
                iArrM6315constructorimpl = iArr;
            }
        }
        intStack.sortDiagonals();
        intStack.pushDiagonal(i, i2, 0);
        return intStack;
    }

    private static final void applyDiff(IntStack intStack, DiffCallback diffCallback) {
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        while (i < intStack.getLastIndex()) {
            int i4 = i + 2;
            int i5 = intStack.get(i) - intStack.get(i4);
            int i6 = intStack.get(i + 1) - intStack.get(i4);
            int i7 = intStack.get(i4);
            i += 3;
            while (i2 < i5) {
                diffCallback.remove(i3, i2);
                i2++;
            }
            while (i3 < i6) {
                diffCallback.insert(i3);
                i3++;
            }
            while (true) {
                int i8 = i7 - 1;
                if (i7 > 0) {
                    diffCallback.same(i2, i3);
                    i2++;
                    i3++;
                    i7 = i8;
                }
            }
        }
    }

    public static final void executeDiff(int i, int i2, DiffCallback diffCallback) {
        applyDiff(calculateDiff(i, i2, diffCallback), diffCallback);
    }

    /* renamed from: midPoint-q5eDKzI, reason: not valid java name */
    private static final boolean m6207midPointq5eDKzI(int i, int i2, int i3, int i4, DiffCallback diffCallback, int[] iArr, int[] iArr2, int[] iArr3) {
        int i5 = i2 - i;
        int i6 = i4 - i3;
        if (i5 >= 1 && i6 >= 1) {
            int i7 = ((i5 + i6) + 1) / 2;
            CenteredArray.m6094setimpl(iArr, 1, i);
            CenteredArray.m6094setimpl(iArr2, 1, i2);
            int i8 = 0;
            while (i8 < i7) {
                int i9 = i8;
                if (m6206forward4l5_RBY(i, i2, i3, i4, diffCallback, iArr, iArr2, i8, iArr3) || m6205backward4l5_RBY(i, i2, i3, i4, diffCallback, iArr, iArr2, i9, iArr3)) {
                    return true;
                }
                i8 = i9 + 1;
            }
        }
        return false;
    }

    /* renamed from: forward-4l5_RBY, reason: not valid java name */
    private static final boolean m6206forward4l5_RBY(int i, int i2, int i3, int i4, DiffCallback diffCallback, int[] iArr, int[] iArr2, int i5, int[] iArr3) {
        int iM6091getimpl;
        int i6;
        int i7;
        int i8 = (i2 - i) - (i4 - i3);
        boolean z = (Math.abs(i8) & 1) == 1;
        int i9 = -i5;
        for (int i10 = i9; i10 <= i5; i10 += 2) {
            if (i10 == i9 || (i10 != i5 && CenteredArray.m6091getimpl(iArr, i10 + 1) > CenteredArray.m6091getimpl(iArr, i10 - 1))) {
                iM6091getimpl = CenteredArray.m6091getimpl(iArr, i10 + 1);
                i6 = iM6091getimpl;
            } else {
                iM6091getimpl = CenteredArray.m6091getimpl(iArr, i10 - 1);
                i6 = iM6091getimpl + 1;
            }
            int i11 = (i3 + (i6 - i)) - i10;
            int i12 = i11 - ((i5 != 0 ? 1 : 0) & (i6 == iM6091getimpl ? 1 : 0));
            while (i6 < i2 && i11 < i4) {
                if (!diffCallback.areItemsTheSame(i6, i11)) {
                    break;
                }
                i6++;
                i11++;
            }
            CenteredArray.m6094setimpl(iArr, i10, i6);
            if (z && (i7 = i8 - i10) >= i9 + 1 && i7 <= i5 - 1) {
                if (CenteredArray.m6091getimpl(iArr2, i7) <= i6) {
                    fillSnake(iM6091getimpl, i12, i6, i11, false, iArr3);
                    return true;
                }
            }
        }
        return false;
    }

    /* renamed from: backward-4l5_RBY, reason: not valid java name */
    private static final boolean m6205backward4l5_RBY(int i, int i2, int i3, int i4, DiffCallback diffCallback, int[] iArr, int[] iArr2, int i5, int[] iArr3) {
        int iM6091getimpl;
        int i6;
        int i7;
        int i8 = (i2 - i) - (i4 - i3);
        boolean z = (i8 & 1) == 0;
        int i9 = -i5;
        for (int i10 = i9; i10 <= i5; i10 += 2) {
            if (i10 == i9 || (i10 != i5 && CenteredArray.m6091getimpl(iArr2, i10 + 1) < CenteredArray.m6091getimpl(iArr2, i10 - 1))) {
                iM6091getimpl = CenteredArray.m6091getimpl(iArr2, i10 + 1);
                i6 = iM6091getimpl;
            } else {
                iM6091getimpl = CenteredArray.m6091getimpl(iArr2, i10 - 1);
                i6 = iM6091getimpl - 1;
            }
            int i11 = i4 - ((i2 - i6) - i10);
            int i12 = ((i5 != 0 ? 1 : 0) & (i6 == iM6091getimpl ? 1 : 0)) + i11;
            while (i6 > i && i11 > i3) {
                if (!diffCallback.areItemsTheSame(i6 - 1, i11 - 1)) {
                    break;
                }
                i6--;
                i11--;
            }
            CenteredArray.m6094setimpl(iArr2, i10, i6);
            if (z && (i7 = i8 - i10) >= i9 && i7 <= i5) {
                if (CenteredArray.m6091getimpl(iArr, i7) >= i6) {
                    fillSnake(i6, i11, iM6091getimpl, i12, true, iArr3);
                    return true;
                }
            }
        }
        return false;
    }

    public static final void fillSnake(int i, int i2, int i3, int i4, boolean z, int[] iArr) {
        if (iArr.length < 5) {
            return;
        }
        iArr[0] = i;
        iArr[1] = i2;
        iArr[2] = i3;
        iArr[3] = i4;
        iArr[4] = z ? 1 : 0;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void swap(int[] iArr, int i, int i2) {
        int i3 = iArr[i];
        iArr[i] = iArr[i2];
        iArr[i2] = i3;
    }
}
