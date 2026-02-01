package androidx.compose.ui.spatial;

import androidx.compose.ui.geometry.InlineClassHelperKt;
import com.android.SdkConstants;
import com.android.ddmlib.testrunner.IInstrumentationResultParser;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.ktor.http.ContentDisposition;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.functions.Function5;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.internal.LockFreeTaskQueueCore;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: RectList.kt */
@Metadata(d1 = {"\u0000r\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u0016\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000b\n\u0002\u0010\u000b\n\u0002\b\n\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0001\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\t\u0010\f\u001a\u00020\bH\u0082\bJ \u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u0005H\u0002JL\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\b\b\u0002\u0010\u0018\u001a\u00020\b2\b\b\u0002\u0010\u0019\u001a\u00020\u001a2\b\b\u0002\u0010\u001b\u001a\u00020\u001aJ\u000e\u0010\u001c\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\bJ.\u0010\u001d\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bJ\u001e\u0010\u001e\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001aJ.\u0010\u001f\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bJ\u001e\u0010 \u001a\u00020\u000e2\u0006\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bJ \u0010 \u001a\u00020\u000e2\u0006\u0010$\u001a\u00020%2\u0006\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\bH\u0002J\u000e\u0010&\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\bJ4\u0010'\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\b2$\u0010(\u001a \u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e0)J(\u0010*\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\b2\u0018\u0010(\u001a\u0014\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000e0+J\u0011\u0010,\u001a\u00020\u001a2\u0006\u0010\u0013\u001a\u00020\bH\u0086\u0002J\u000e\u0010-\u001a\u00020\b2\u0006\u0010\u0013\u001a\u00020\bJ\u000e\u0010.\u001a\u00020%2\u0006\u0010\u0013\u001a\u00020\bJ=\u0010/\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e00H\u0086\bJ=\u00101\u001a\u00020\u000e2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e00H\u0086\bJ5\u00102\u001a\u00020\u000e2*\u0010(\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e03H\u0086\bJ-\u0010/\u001a\u00020\u000e2\u0006\u00104\u001a\u00020\b2\u0006\u00105\u001a\u00020\b2\u0012\u0010(\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e00H\u0086\bJ=\u00106\u001a\u00020\u000e2\u0006\u00107\u001a\u00020\b2*\u0010(\u001a&\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u000e03H\u0086\bJ5\u00108\u001a\u0002092\u0006\u0010:\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0000¢\u0006\u0002\b;JÇ\u0001\u0010<\u001a\u00020\u000e2\u0006\u0010:\u001a\u00020\b2\u0006\u0010=\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\b2\u008b\u0001\u0010(\u001a\u0086\u0001\u0012\u0013\u0012\u00110\b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(A\u0012\u0013\u0012\u00110\b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(!\u0012\u0013\u0012\u00110\b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(\u0014\u0012\u0013\u0012\u00110\b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(\u0015\u0012\u0013\u0012\u00110\b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(\u0016\u0012\u0013\u0012\u00110\b¢\u0006\f\b?\u0012\b\b@\u0012\u0004\b\b(\u0017\u0012\u0004\u0012\u00020\u000e0>H\u0086\bJ1\u0010B\u001a\u00020\b2\u0006\u0010:\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\b2\u0006\u0010\u0017\u001a\u00020\bH\u0086\bJ\u0006\u0010C\u001a\u00020\u000eJ\u0006\u0010D\u001a\u00020\u000eJ)\u0010E\u001a\u00020\u000e2\u001e\u0010(\u001a\u001a\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020%\u0012\u0004\u0012\u00020\u000e0FH\u0086\bJ\u0006\u0010G\u001a\u00020HR\u0012\u0010\u0004\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00058\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\b8\u0000@\u0000X\u0081\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\t\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006I"}, d2 = {"Landroidx/compose/ui/spatial/RectList;", "", SdkConstants.CONSTRUCTOR_NAME, "()V", FirebaseAnalytics.Param.ITEMS, "", IInstrumentationResultParser.StatusKeys.STACK, "itemsSize", "", ContentDisposition.Parameters.Size, "getSize", "()I", "allocateItemsIndex", "resizeStorage", "", "actualSize", "currentSize", "currentItems", "insert", "value", "l", "t", SdkConstants.FD_RES_CLASS, "b", "parentId", SdkConstants.ATTR_FOCUSABLE, "", "gesturable", "remove", "update", "updateFlagsFor", "move", "updateSubhierarchy", "id", "deltaX", "deltaY", "stackMeta", "", "markUpdated", "withRect", "block", "Lkotlin/Function4;", "withTopLeftBottomRight", "Lkotlin/Function2;", "contains", "indexOf", "metaFor", "forEachIntersection", "Lkotlin/Function1;", "forEachGesturableIntersection", "forEachRect", "Lkotlin/Function5;", "x", "y", "forEachIntersectingRectWithValueAt", "index", "neighborsScoredByDistance", "", "searchAxis", "neighborsScoredByDistance$ui_release", "findKNearestNeighbors", "k", "Lkotlin/Function6;", "Lkotlin/ParameterName;", "name", "score", "findNearestNeighbor", "defragment", "clearUpdated", "forEachUpdatedRect", "Lkotlin/Function3;", "debugString", "", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class RectList {
    public static final int $stable = 8;
    public int itemsSize;
    public long[] items = new long[192];
    public long[] stack = new long[192];

    public final int getSize() {
        return this.itemsSize / 3;
    }

    private final int allocateItemsIndex() {
        long[] jArr = this.items;
        int i = this.itemsSize;
        int i2 = i + 3;
        this.itemsSize = i2;
        int length = jArr.length;
        if (length <= i2) {
            resizeStorage(length, i, jArr);
        }
        return i;
    }

    private final void resizeStorage(int actualSize, int currentSize, long[] currentItems) {
        int iMax = Math.max(actualSize * 2, currentSize + 3);
        long[] jArrCopyOf = Arrays.copyOf(currentItems, iMax);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf, "copyOf(...)");
        this.items = jArrCopyOf;
        long[] jArrCopyOf2 = Arrays.copyOf(this.stack, iMax);
        Intrinsics.checkNotNullExpressionValue(jArrCopyOf2, "copyOf(...)");
        this.stack = jArrCopyOf2;
    }

    public final boolean remove(int value) {
        int i = value & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i2 = this.itemsSize;
        for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
            int i4 = i3 + 2;
            if ((((int) jArr[i4]) & RectListKt.Lower26Bits) == i) {
                jArr[i3] = -1;
                jArr[i3 + 1] = -1;
                jArr[i4] = 2305843009213693951L;
                return true;
            }
        }
        return false;
    }

    public final boolean update(int value, int l, int t, int r, int b) {
        int i = value & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i2 = this.itemsSize;
        for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
            int i4 = i3 + 2;
            long j = jArr[i4];
            if ((((int) j) & RectListKt.Lower26Bits) == i) {
                jArr[i3] = (l << 32) | (t & 4294967295L);
                jArr[i3 + 1] = (r << 32) | (b & 4294967295L);
                jArr[i4] = LockFreeTaskQueueCore.CLOSED_MASK | j;
                return true;
            }
        }
        return false;
    }

    public final boolean updateFlagsFor(int value, boolean focusable, boolean gesturable) {
        int i = value & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i2 = this.itemsSize;
        for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
            int i4 = i3 + 2;
            long j = jArr[i4];
            if ((((int) j) & RectListKt.Lower26Bits) == i) {
                jArr[i4] = ((focusable ? 1L : 0L) * 4611686018427387904L) | (4611686018427387903L & j) | ((gesturable ? 1L : 0L) * Long.MIN_VALUE);
                return true;
            }
        }
        return false;
    }

    public final boolean move(int value, int l, int t, int r, int b) {
        int i = value & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i2 = this.itemsSize;
        for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
            int i4 = i3 + 2;
            long j = jArr[i4];
            if ((((int) j) & RectListKt.Lower26Bits) == i) {
                long j2 = jArr[i3];
                jArr[i3] = (t & 4294967295L) | (l << 32);
                int i5 = i3;
                jArr[i3 + 1] = (b & 4294967295L) | (r << 32);
                jArr[i4] = LockFreeTaskQueueCore.CLOSED_MASK | j;
                int i6 = l - ((int) (j2 >> 32));
                int i7 = t - ((int) j2);
                if ((i6 != 0) | (i7 != 0)) {
                    updateSubhierarchy((RectListKt.EverythingButParentId & j) | (((i5 + 3) & RectListKt.Lower26Bits) << 26), i6, i7);
                }
                return true;
            }
        }
        return false;
    }

    public final void updateSubhierarchy(int id2, int deltaX, int deltaY) {
        updateSubhierarchy((Math.min(this.itemsSize, 511) << 52) | (0 << 26) | (id2 & RectListKt.Lower26Bits), deltaX, deltaY);
    }

    private final void updateSubhierarchy(long stackMeta, int deltaX, int deltaY) {
        int i;
        char c;
        int i2;
        char c2;
        long[] jArr = this.items;
        long[] jArr2 = this.stack;
        getSize();
        jArr2[0] = stackMeta;
        int i3 = 1;
        while (i3 > 0) {
            i3--;
            long j = jArr2[i3];
            int i4 = RectListKt.Lower26Bits;
            int i5 = ((int) j) & RectListKt.Lower26Bits;
            char c3 = 26;
            int i6 = ((int) (j >> 26)) & RectListKt.Lower26Bits;
            char c4 = 511;
            int i7 = ((int) (j >> 52)) & 511;
            int length = i7 == 511 ? jArr.length : i7 + i6;
            if (i6 < 0) {
                return;
            }
            while (i6 < jArr.length - 2 && i6 < length) {
                int i8 = i6 + 2;
                long j2 = jArr[i8];
                if ((((int) (j2 >> c3)) & i4) == i5) {
                    long j3 = jArr[i6];
                    int i9 = i6 + 1;
                    long j4 = jArr[i9];
                    i = i5;
                    jArr[i6] = ((((int) j3) + deltaY) & 4294967295L) | ((((int) (j3 >> 32)) + deltaX) << 32);
                    jArr[i9] = ((((int) j4) + deltaY) & 4294967295L) | ((((int) (j4 >> 32)) + deltaX) << 32);
                    jArr[i8] = LockFreeTaskQueueCore.CLOSED_MASK | j2;
                    c = 511;
                    if ((((int) (j2 >> 52)) & 511) > 0) {
                        long j5 = j2 & RectListKt.EverythingButParentId;
                        i2 = RectListKt.Lower26Bits;
                        c2 = 26;
                        jArr2[i3] = j5 | (((i6 + 3) & RectListKt.Lower26Bits) << 26);
                        i3++;
                    } else {
                        c2 = 26;
                        i2 = RectListKt.Lower26Bits;
                    }
                } else {
                    i = i5;
                    c = c4;
                    char c5 = c3;
                    i2 = i4;
                    c2 = c5;
                }
                i6 += 3;
                c4 = c;
                i5 = i;
                int i10 = i2;
                c3 = c2;
                i4 = i10;
            }
        }
    }

    public final void markUpdated(int value) {
        int i = value & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i2 = this.itemsSize;
        for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
            int i4 = i3 + 2;
            long j = jArr[i4];
            if ((((int) j) & RectListKt.Lower26Bits) == i) {
                jArr[i4] = LockFreeTaskQueueCore.CLOSED_MASK | j;
                return;
            }
        }
    }

    public final boolean withRect(int value, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> block) {
        int i = value & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i2 = this.itemsSize;
        for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
            if ((((int) jArr[i3 + 2]) & RectListKt.Lower26Bits) == i) {
                long j = jArr[i3];
                long j2 = jArr[i3 + 1];
                block.invoke(Integer.valueOf((int) (j >> 32)), Integer.valueOf((int) j), Integer.valueOf((int) (j2 >> 32)), Integer.valueOf((int) j2));
                return true;
            }
        }
        return false;
    }

    public final boolean withTopLeftBottomRight(int value, Function2<? super Long, ? super Long, Unit> block) {
        int i = value & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i2 = this.itemsSize;
        for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
            if ((((int) jArr[i3 + 2]) & RectListKt.Lower26Bits) == i) {
                block.invoke(Long.valueOf(jArr[i3]), Long.valueOf(jArr[i3 + 1]));
                return true;
            }
        }
        return false;
    }

    public final boolean contains(int value) {
        int i = value & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i2 = this.itemsSize;
        for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
            if ((((int) jArr[i3 + 2]) & RectListKt.Lower26Bits) == i) {
                return true;
            }
        }
        return false;
    }

    public final int indexOf(int value) {
        int i = value & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i2 = this.itemsSize;
        for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
            if ((((int) jArr[i3 + 2]) & RectListKt.Lower26Bits) == i) {
                return i3;
            }
        }
        return -1;
    }

    public final long metaFor(int value) {
        int i = value & RectListKt.Lower26Bits;
        long[] jArr = this.items;
        int i2 = this.itemsSize;
        for (int i3 = 0; i3 < jArr.length - 2 && i3 < i2; i3 += 3) {
            long j = jArr[i3 + 2];
            if ((((int) j) & RectListKt.Lower26Bits) == i) {
                return j;
            }
        }
        return RectListKt.TombStone;
    }

    public final void forEachIntersection(int l, int t, int r, int b, Function1<? super Integer, Unit> block) {
        long j = (l << 32) | (t & 4294967295L);
        long j2 = (r << 32) | (b & 4294967295L);
        long[] jArr = this.items;
        int i = this.itemsSize;
        for (int i2 = 0; i2 < jArr.length - 2 && i2 < i; i2 += 3) {
            if (((((j2 - jArr[i2]) - InlineClassHelperKt.Uint64Low32) | ((jArr[i2 + 1] - j) - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) == 0) {
                block.invoke(Integer.valueOf(((int) jArr[i2 + 2]) & RectListKt.Lower26Bits));
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:11:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void forEachGesturableIntersection(int r17, int r18, int r19, int r20, kotlin.jvm.functions.Function1<? super java.lang.Integer, kotlin.Unit> r21) {
        /*
            r16 = this;
            r0 = r16
            r1 = r17
            long r1 = (long) r1
            r3 = 32
            long r1 = r1 << r3
            r4 = r18
            long r4 = (long) r4
            r6 = 4294967295(0xffffffff, double:2.1219957905E-314)
            long r4 = r4 & r6
            long r1 = r1 | r4
            r4 = r19
            long r4 = (long) r4
            long r3 = r4 << r3
            r5 = r20
            long r8 = (long) r5
            long r5 = r8 & r6
            long r3 = r3 | r5
            long[] r5 = r0.items
            int r6 = r0.itemsSize
            r7 = 0
        L22:
            int r8 = r5.length
            int r8 = r8 + (-2)
            if (r7 >= r8) goto L67
            if (r7 >= r6) goto L67
            int r8 = r7 + 2
            r8 = r5[r8]
            r10 = 63
            long r10 = r8 >> r10
            int r10 = (int) r10
            r10 = r10 & 1
            if (r10 == 0) goto L62
            r10 = r5[r7]
            int r12 = r7 + 1
            r12 = r5[r12]
            long r10 = r3 - r10
            r14 = 4294967297(0x100000001, double:2.1219957915E-314)
            long r10 = r10 - r14
            long r12 = r12 - r1
            long r12 = r12 - r14
            long r10 = r10 | r12
            r12 = -9223372034707292160(0x8000000080000000, double:-1.0609978955E-314)
            long r10 = r10 & r12
            r12 = 0
            int r10 = (r10 > r12 ? 1 : (r10 == r12 ? 0 : -1))
            if (r10 != 0) goto L62
            int r8 = (int) r8
            r9 = 67108863(0x3ffffff, float:1.5046327E-36)
            r8 = r8 & r9
            java.lang.Integer r8 = java.lang.Integer.valueOf(r8)
            r9 = r21
            r9.invoke(r8)
            goto L64
        L62:
            r9 = r21
        L64:
            int r7 = r7 + 3
            goto L22
        L67:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: androidx.compose.ui.spatial.RectList.forEachGesturableIntersection(int, int, int, int, kotlin.jvm.functions.Function1):void");
    }

    public final void forEachRect(Function5<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> block) {
        long[] jArr = this.items;
        int i = this.itemsSize;
        for (int i2 = 0; i2 < jArr.length - 2 && i2 < i; i2 += 3) {
            long j = jArr[i2];
            long j2 = jArr[i2 + 1];
            block.invoke(Integer.valueOf(((int) jArr[i2 + 2]) & RectListKt.Lower26Bits), Integer.valueOf((int) (j >> 32)), Integer.valueOf((int) j), Integer.valueOf((int) (j2 >> 32)), Integer.valueOf((int) j2));
        }
    }

    public final void forEachIntersection(int x, int y, Function1<? super Integer, Unit> block) {
        long j = (y & 4294967295L) | (x << 32);
        long[] jArr = this.items;
        int i = this.itemsSize;
        for (int i2 = 0; i2 < jArr.length - 2 && i2 < i; i2 += 3) {
            if (((((j - jArr[i2]) - InlineClassHelperKt.Uint64Low32) | ((jArr[i2 + 1] - j) - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) == 0) {
                block.invoke(Integer.valueOf(((int) jArr[i2 + 2]) & RectListKt.Lower26Bits));
            }
        }
    }

    public final void forEachIntersectingRectWithValueAt(int index, Function5<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> block) {
        long[] jArr = this.items;
        int i = this.itemsSize;
        long j = jArr[index];
        long j2 = jArr[index + 1];
        for (int i2 = 0; i2 < jArr.length - 2 && i2 < i; i2 += 3) {
            if (i2 != index) {
                long j3 = jArr[i2];
                long j4 = jArr[i2 + 1];
                if (((((j2 - j3) - InlineClassHelperKt.Uint64Low32) | ((j4 - j) - InlineClassHelperKt.Uint64Low32)) & (-9223372034707292160L)) == 0) {
                    block.invoke(Integer.valueOf((int) (j3 >> 32)), Integer.valueOf((int) j3), Integer.valueOf((int) (j4 >> 32)), Integer.valueOf((int) j4), Integer.valueOf(((int) jArr[i2 + 2]) & RectListKt.Lower26Bits));
                }
            }
        }
    }

    public final int[] neighborsScoredByDistance$ui_release(int searchAxis, int l, int t, int r, int b) {
        long[] jArr = this.items;
        int i = this.itemsSize / 3;
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            int i3 = i2 * 3;
            if (i3 < 0 || i3 >= jArr.length - 1) {
                break;
            }
            long j = jArr[i3];
            long j2 = jArr[i3 + 1];
            iArr[i2] = RectListKt.distanceScore(searchAxis, l, t, r, b, (int) (j >> 32), (int) j, (int) (j2 >> 32), (int) j2);
        }
        return iArr;
    }

    public final void findKNearestNeighbors(int searchAxis, int k, int l, int t, int r, int b, Function6<? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> block) {
        int i;
        int[] iArrNeighborsScoredByDistance$ui_release = neighborsScoredByDistance$ui_release(searchAxis, l, t, r, b);
        long[] jArr = this.items;
        int i2 = 1;
        int i3 = 0;
        int i4 = 0;
        while (i3 <= k) {
            int iMin = Integer.MAX_VALUE;
            int i5 = 0;
            while (i5 < iArrNeighborsScoredByDistance$ui_release.length) {
                int i6 = iArrNeighborsScoredByDistance$ui_release[i5];
                if (i6 > i2) {
                    iMin = Math.min(iMin, i6);
                }
                if (i6 == i2) {
                    int i7 = i5 * 3;
                    long j = jArr[i7];
                    long j2 = jArr[i7 + 1];
                    i = i2;
                    block.invoke(Integer.valueOf(i6), Integer.valueOf(((int) jArr[i7 + 2]) & RectListKt.Lower26Bits), Integer.valueOf((int) (j >> 32)), Integer.valueOf((int) j), Integer.valueOf((int) (j2 >> 32)), Integer.valueOf((int) j2));
                    i4++;
                    if (i4 == k) {
                        return;
                    }
                } else {
                    i = i2;
                }
                i5++;
                i2 = i;
            }
            i3++;
            i2 = iMin;
        }
    }

    public final int findNearestNeighbor(int searchAxis, int l, int t, int r, int b) {
        long[] jArr = this.items;
        int i = this.itemsSize;
        int i2 = Integer.MAX_VALUE;
        int i3 = -1;
        for (int i4 = 0; i4 < jArr.length - 2 && i4 < i; i4 += 3) {
            long j = jArr[i4];
            int i5 = i4 + 1;
            long j2 = jArr[i5];
            int iDistanceScore = RectListKt.distanceScore(searchAxis, l, t, r, b, (int) (j >> 32), (int) j, (int) (j2 >> 32), (int) j2);
            boolean z = (iDistanceScore < i2) & (iDistanceScore > 0);
            if (z) {
                i2 = iDistanceScore;
            }
            if (z) {
                i3 = i5;
            }
        }
        if (i3 < 0 || i3 >= jArr.length) {
            return -1;
        }
        return ((int) jArr[i3]) & RectListKt.Lower26Bits;
    }

    public final void defragment() {
        long[] jArr = this.items;
        int i = this.itemsSize;
        long[] jArr2 = this.stack;
        int i2 = 0;
        for (int i3 = 0; i3 < jArr.length - 2 && i2 < jArr2.length - 2 && i3 < i; i3 += 3) {
            int i4 = i3 + 2;
            if (jArr[i4] != RectListKt.TombStone) {
                jArr2[i2] = jArr[i3];
                jArr2[i2 + 1] = jArr[i3 + 1];
                jArr2[i2 + 2] = jArr[i4];
                i2 += 3;
            }
        }
        this.itemsSize = i2;
        this.items = jArr2;
        this.stack = jArr;
    }

    public final void clearUpdated() {
        long[] jArr = this.items;
        int i = this.itemsSize;
        for (int i2 = 0; i2 < jArr.length - 2 && i2 < i; i2 += 3) {
            int i3 = i2 + 2;
            jArr[i3] = jArr[i3] & (-2305843009213693953L);
        }
    }

    public final void forEachUpdatedRect(Function3<? super Integer, ? super Long, ? super Long, Unit> block) {
        long[] jArr = this.items;
        int i = this.itemsSize;
        for (int i2 = 0; i2 < jArr.length - 2 && i2 < i; i2 += 3) {
            long j = jArr[i2 + 2];
            if ((((int) (j >> 61)) & 1) != 0) {
                block.invoke(Integer.valueOf(((int) j) & RectListKt.Lower26Bits), Long.valueOf(jArr[i2]), Long.valueOf(jArr[i2 + 1]));
            }
        }
    }

    public final String debugString() {
        StringBuilder sb = new StringBuilder();
        long[] jArr = this.items;
        int i = this.itemsSize;
        for (int i2 = 0; i2 < jArr.length - 2 && i2 < i; i2 += 3) {
            long j = jArr[i2];
            long j2 = jArr[i2 + 1];
            long j3 = jArr[i2 + 2];
            StringBuilder sbAppend = sb.append("id=" + (((int) j3) & RectListKt.Lower26Bits) + ", rect=[" + ((int) (j >> 32)) + AbstractJsonLexerKt.COMMA + ((int) j) + AbstractJsonLexerKt.COMMA + ((int) (j2 >> 32)) + AbstractJsonLexerKt.COMMA + ((int) j2) + "], parent=" + (((int) (j3 >> 26)) & RectListKt.Lower26Bits));
            Intrinsics.checkNotNullExpressionValue(sbAppend, "append(...)");
            Intrinsics.checkNotNullExpressionValue(sbAppend.append('\n'), "append(...)");
        }
        String string = sb.toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        return string;
    }

    public final void insert(int value, int l, int t, int r, int b, int parentId, boolean focusable, boolean gesturable) {
        long[] jArr = this.items;
        int i = this.itemsSize;
        int i2 = i + 3;
        this.itemsSize = i2;
        int length = jArr.length;
        if (length <= i2) {
            resizeStorage(length, i, jArr);
        }
        long[] jArr2 = this.items;
        jArr2[i] = (l << 32) | (t & 4294967295L);
        jArr2[i + 1] = (r << 32) | (b & 4294967295L);
        long jMin = ((gesturable ? 1L : 0L) << 63) | ((focusable ? 1L : 0L) << 62) | (1 << 61) | (Math.min(0, 511) << 52);
        int i3 = parentId & RectListKt.Lower26Bits;
        jArr2[i + 2] = jMin | (i3 << 26) | (value & RectListKt.Lower26Bits);
        if (parentId < 0) {
            return;
        }
        for (int i4 = i - 3; i4 >= 0; i4 -= 3) {
            int i5 = i4 + 2;
            long j = jArr2[i5];
            if ((((int) j) & RectListKt.Lower26Bits) == i3) {
                jArr2[i5] = (Math.min(i - i4, 511) << 52) | (RectListKt.EverythingButLastChildOffset & j);
                return;
            }
        }
    }
}
