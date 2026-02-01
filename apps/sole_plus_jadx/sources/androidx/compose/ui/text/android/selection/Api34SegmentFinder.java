package androidx.compose.ui.text.android.selection;

import com.android.SdkConstants;
import kotlin.Metadata;

/* compiled from: SegmentFinder.android.kt */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0011\u0010\u0004\u001a\u00020\u0005*\u00020\u0006H\u0000¢\u0006\u0002\b\u0007¨\u0006\b"}, d2 = {"Landroidx/compose/ui/text/android/selection/Api34SegmentFinder;", "", SdkConstants.CONSTRUCTOR_NAME, "()V", "toAndroidSegmentFinder", "Landroid/text/SegmentFinder;", "Landroidx/compose/ui/text/android/selection/SegmentFinder;", "toAndroidSegmentFinder$ui_text", "ui-text"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class Api34SegmentFinder {
    public static final int $stable = 0;
    public static final Api34SegmentFinder INSTANCE = new Api34SegmentFinder();

    private Api34SegmentFinder() {
    }

    public final android.text.SegmentFinder toAndroidSegmentFinder$ui_text(final SegmentFinder segmentFinder) {
        return new android.text.SegmentFinder() { // from class: androidx.compose.ui.text.android.selection.Api34SegmentFinder$toAndroidSegmentFinder$1
            @Override // android.text.SegmentFinder
            public int previousStartBoundary(int offset) {
                return segmentFinder.previousStartBoundary(offset);
            }

            @Override // android.text.SegmentFinder
            public int previousEndBoundary(int offset) {
                return segmentFinder.previousEndBoundary(offset);
            }

            @Override // android.text.SegmentFinder
            public int nextStartBoundary(int offset) {
                return segmentFinder.nextStartBoundary(offset);
            }

            @Override // android.text.SegmentFinder
            public int nextEndBoundary(int offset) {
                return segmentFinder.nextEndBoundary(offset);
            }
        };
    }
}
