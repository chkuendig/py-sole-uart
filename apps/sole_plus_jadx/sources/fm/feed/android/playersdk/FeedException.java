package fm.feed.android.playersdk;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* compiled from: FeedException.kt */
@Metadata(d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00060\u0001j\u0002`\u0002B\u0011\u0012\n\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016R\u0012\u0010\u0003\u001a\u00060\u0001j\u0002`\u0002X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007"}, d2 = {"Lfm/feed/android/playersdk/FeedException;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "wrappedException", "(Ljava/lang/Exception;)V", "toString", "", "PlayerSdk_exoDefaultRelease"}, k = 1, mv = {1, 5, 1}, xi = 48)
/* loaded from: classes6.dex */
public final class FeedException extends Exception {
    private final Exception wrappedException;

    public FeedException(Exception wrappedException) {
        Intrinsics.checkNotNullParameter(wrappedException, "wrappedException");
        this.wrappedException = wrappedException;
    }

    @Override // java.lang.Throwable
    public String toString() {
        return this.wrappedException.toString();
    }
}
