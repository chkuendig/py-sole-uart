package androidx.compose.ui.node;

import com.android.SdkConstants;
import java.util.Arrays;
import kotlin.Metadata;
import kotlin.jvm.JvmInline;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* compiled from: MyersDiff.kt */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0083@\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0015\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f¢\u0006\u0004\b \u0010!J\u000f\u0010\"\u001a\u00020#H\u0016¢\u0006\u0004\b$\u0010%J\u0013\u0010&\u001a\u00020\u00132\b\u0010'\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010(\u001a\u00020\tHÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u0012\u0010\b\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\r\u0010\u000bR\u0012\u0010\u000e\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u000bR\u0012\u0010\u0010\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000bR\u0012\u0010\u0012\u001a\u00020\u00138Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\t8Æ\u0002¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u000bR\u0014\u0010\u0018\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0015R\u0014\u0010\u001a\u001a\u00020\u00138BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0015\u0088\u0001\u0002¨\u0006)"}, d2 = {"Landroidx/compose/ui/node/Snake;", "", "data", "", "constructor-impl", "([I)[I", "getData", "()[I", SdkConstants.ATTR_START_X, "", "getStartX-impl", "([I)I", SdkConstants.ATTR_START_Y, "getStartY-impl", SdkConstants.ATTR_END_X, "getEndX-impl", SdkConstants.ATTR_END_Y, "getEndY-impl", "reverse", "", "getReverse-impl", "([I)Z", "diagonalSize", "getDiagonalSize-impl", "hasAdditionOrRemoval", "getHasAdditionOrRemoval-impl", "isAddition", "isAddition-impl", "addDiagonalToStack", "", "diagonals", "Landroidx/compose/ui/node/IntStack;", "addDiagonalToStack-impl", "([ILandroidx/compose/ui/node/IntStack;)V", "toString", "", "toString-impl", "([I)Ljava/lang/String;", "equals", "other", "hashCode", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
@JvmInline
/* loaded from: classes2.dex */
final class Snake {
    private final int[] data;

    /* renamed from: box-impl, reason: not valid java name */
    public static final /* synthetic */ Snake m6314boximpl(int[] iArr) {
        return new Snake(iArr);
    }

    /* renamed from: constructor-impl, reason: not valid java name */
    public static int[] m6315constructorimpl(int[] iArr) {
        return iArr;
    }

    /* renamed from: equals-impl, reason: not valid java name */
    public static boolean m6316equalsimpl(int[] iArr, Object obj) {
        return (obj instanceof Snake) && Intrinsics.areEqual(iArr, ((Snake) obj).m6328unboximpl());
    }

    /* renamed from: equals-impl0, reason: not valid java name */
    public static final boolean m6317equalsimpl0(int[] iArr, int[] iArr2) {
        return Intrinsics.areEqual(iArr, iArr2);
    }

    /* renamed from: hashCode-impl, reason: not valid java name */
    public static int m6325hashCodeimpl(int[] iArr) {
        return Arrays.hashCode(iArr);
    }

    public boolean equals(Object other) {
        return m6316equalsimpl(this.data, other);
    }

    public int hashCode() {
        return m6325hashCodeimpl(this.data);
    }

    /* renamed from: unbox-impl, reason: not valid java name */
    public final /* synthetic */ int[] m6328unboximpl() {
        return this.data;
    }

    private /* synthetic */ Snake(int[] iArr) {
        this.data = iArr;
    }

    public final int[] getData() {
        return this.data;
    }

    /* renamed from: getStartX-impl, reason: not valid java name */
    public static final int m6323getStartXimpl(int[] iArr) {
        return iArr[0];
    }

    /* renamed from: getStartY-impl, reason: not valid java name */
    public static final int m6324getStartYimpl(int[] iArr) {
        return iArr[1];
    }

    /* renamed from: getEndX-impl, reason: not valid java name */
    public static final int m6319getEndXimpl(int[] iArr) {
        return iArr[2];
    }

    /* renamed from: getEndY-impl, reason: not valid java name */
    public static final int m6320getEndYimpl(int[] iArr) {
        return iArr[3];
    }

    /* renamed from: getReverse-impl, reason: not valid java name */
    public static final boolean m6322getReverseimpl(int[] iArr) {
        return iArr[4] != 0;
    }

    /* renamed from: toString-impl, reason: not valid java name */
    public static String m6327toStringimpl(int[] iArr) {
        return "Snake(" + iArr[0] + AbstractJsonLexerKt.COMMA + iArr[1] + AbstractJsonLexerKt.COMMA + iArr[2] + AbstractJsonLexerKt.COMMA + iArr[3] + AbstractJsonLexerKt.COMMA + (iArr[4] != 0) + ')';
    }

    public String toString() {
        return m6327toStringimpl(this.data);
    }

    /* renamed from: getDiagonalSize-impl, reason: not valid java name */
    public static final int m6318getDiagonalSizeimpl(int[] iArr) {
        return Math.min(iArr[2] - iArr[0], iArr[3] - iArr[1]);
    }

    /* renamed from: getHasAdditionOrRemoval-impl, reason: not valid java name */
    private static final boolean m6321getHasAdditionOrRemovalimpl(int[] iArr) {
        return iArr[3] - iArr[1] != iArr[2] - iArr[0];
    }

    /* renamed from: isAddition-impl, reason: not valid java name */
    private static final boolean m6326isAdditionimpl(int[] iArr) {
        return iArr[3] - iArr[1] > iArr[2] - iArr[0];
    }

    /* renamed from: addDiagonalToStack-impl, reason: not valid java name */
    public static final void m6313addDiagonalToStackimpl(int[] iArr, IntStack intStack) {
        int iMin;
        int i = iArr[0];
        int i2 = iArr[1];
        if (m6321getHasAdditionOrRemovalimpl(iArr)) {
            iMin = Math.min(iArr[2] - iArr[0], iArr[3] - iArr[1]);
            i += ((iArr[4] != 0 ? 1 : 0) | (m6326isAdditionimpl(iArr) ? 1 : 0)) ^ 1;
            i2 += ((!m6326isAdditionimpl(iArr) ? 1 : 0) | (iArr[4] != 0 ? 1 : 0)) ^ 1;
        } else {
            iMin = iArr[2] - iArr[0];
        }
        intStack.pushDiagonal(i, i2, iMin);
    }
}
