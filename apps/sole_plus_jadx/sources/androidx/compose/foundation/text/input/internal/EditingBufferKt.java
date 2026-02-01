package androidx.compose.foundation.text.input.internal;

import androidx.compose.ui.text.TextRange;
import androidx.compose.ui.text.TextRangeKt;
import androidx.constraintlayout.core.motion.utils.TypedValues;
import kotlin.Metadata;

/* compiled from: EditingBuffer.kt */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a\"\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0000ø\u0001\u0000¢\u0006\u0004\b\u0004\u0010\u0005\u0082\u0002\u0007\n\u0005\b¡\u001e0\u0001¨\u0006\u0006"}, d2 = {"updateRangeAfterDelete", "Landroidx/compose/ui/text/TextRange;", TypedValues.AttributesType.S_TARGET, "deleted", "updateRangeAfterDelete-pWDy79M", "(JJ)J", "foundation_release"}, k = 2, mv = {1, 8, 0}, xi = 48)
/* loaded from: classes.dex */
public final class EditingBufferKt {
    /* renamed from: updateRangeAfterDelete-pWDy79M, reason: not valid java name */
    public static final long m1448updateRangeAfterDeletepWDy79M(long j, long j2) {
        int iM6713getLengthimpl;
        int iM6715getMinimpl = TextRange.m6715getMinimpl(j);
        int iM6714getMaximpl = TextRange.m6714getMaximpl(j);
        if (TextRange.m6719intersects5zctL8(j2, j)) {
            if (TextRange.m6707contains5zctL8(j2, j)) {
                iM6715getMinimpl = TextRange.m6715getMinimpl(j2);
                iM6714getMaximpl = iM6715getMinimpl;
            } else {
                if (TextRange.m6707contains5zctL8(j, j2)) {
                    iM6713getLengthimpl = TextRange.m6713getLengthimpl(j2);
                } else if (TextRange.m6708containsimpl(j2, iM6715getMinimpl)) {
                    iM6715getMinimpl = TextRange.m6715getMinimpl(j2);
                    iM6713getLengthimpl = TextRange.m6713getLengthimpl(j2);
                } else {
                    iM6714getMaximpl = TextRange.m6715getMinimpl(j2);
                }
                iM6714getMaximpl -= iM6713getLengthimpl;
            }
        } else if (iM6714getMaximpl > TextRange.m6715getMinimpl(j2)) {
            iM6715getMinimpl -= TextRange.m6713getLengthimpl(j2);
            iM6713getLengthimpl = TextRange.m6713getLengthimpl(j2);
            iM6714getMaximpl -= iM6713getLengthimpl;
        }
        return TextRangeKt.TextRange(iM6715getMinimpl, iM6714getMaximpl);
    }
}
