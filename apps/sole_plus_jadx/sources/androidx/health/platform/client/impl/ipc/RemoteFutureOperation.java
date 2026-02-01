package androidx.health.platform.client.impl.ipc;

import android.os.RemoteException;
import com.google.common.util.concurrent.SettableFuture;

/* loaded from: classes2.dex */
public interface RemoteFutureOperation<S, R> {
    void execute(S s, SettableFuture<R> settableFuture) throws RemoteException;
}
