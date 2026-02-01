package androidx.compose.ui.input.pointer;

import androidx.compose.ui.internal.PlatformOptimizedCancellationException;
import com.android.SdkConstants;
import kotlin.Metadata;

/* compiled from: SuspendingPointerInputFilter.kt */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bÁ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0004"}, d2 = {"Landroidx/compose/ui/input/pointer/CancelTimeoutCancellationException;", "Landroidx/compose/ui/internal/PlatformOptimizedCancellationException;", SdkConstants.CONSTRUCTOR_NAME, "()V", "ui_release"}, k = 1, mv = {2, 0, 0}, xi = 48)
/* loaded from: classes2.dex */
public final class CancelTimeoutCancellationException extends PlatformOptimizedCancellationException {
    public static final CancelTimeoutCancellationException INSTANCE = new CancelTimeoutCancellationException();
    public static final int $stable = 8;

    private CancelTimeoutCancellationException() {
        super(null, 1, null);
    }
}
