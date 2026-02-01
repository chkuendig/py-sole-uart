package kotlinx.coroutines.guava;

import java.util.concurrent.CancellationException;
import kotlin.Metadata;

/* compiled from: ListenableFuture.kt */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0010\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lkotlinx/coroutines/guava/Cancelled;", "", "exception", "Ljava/util/concurrent/CancellationException;", "(Ljava/util/concurrent/CancellationException;)V", "kotlinx-coroutines-guava"}, k = 1, mv = {1, 9, 0}, xi = 48)
/* loaded from: classes6.dex */
final class Cancelled {
    public final CancellationException exception;

    public Cancelled(CancellationException cancellationException) {
        this.exception = cancellationException;
    }
}
