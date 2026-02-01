package androidx.health.platform.client.impl.ipc;

import android.os.IBinder;
import android.os.RemoteException;
import com.google.common.util.concurrent.SettableFuture;

/* loaded from: classes2.dex */
public interface ServiceOperation<R> {
    void execute(IBinder iBinder, SettableFuture<R> settableFuture) throws RemoteException;
}
